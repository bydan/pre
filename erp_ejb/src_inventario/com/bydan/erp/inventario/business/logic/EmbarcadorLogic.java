/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.EmbarcadorConstantesFunciones;
import com.bydan.erp.inventario.util.EmbarcadorParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EmbarcadorParameterGeneral;
import com.bydan.erp.inventario.business.entity.Embarcador;
import com.bydan.erp.inventario.business.logic.EmbarcadorLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmbarcadorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmbarcadorLogic.class);
	
	protected EmbarcadorDataAccess embarcadorDataAccess; 	
	protected Embarcador embarcador;
	protected List<Embarcador> embarcadors;
	protected Object embarcadorObject;	
	protected List<Object> embarcadorsObject;
	
	public static ClassValidator<Embarcador> embarcadorValidator = new ClassValidator<Embarcador>(Embarcador.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmbarcadorLogicAdditional embarcadorLogicAdditional=null;
	
	public EmbarcadorLogicAdditional getEmbarcadorLogicAdditional() {
		return this.embarcadorLogicAdditional;
	}
	
	public void setEmbarcadorLogicAdditional(EmbarcadorLogicAdditional embarcadorLogicAdditional) {
		try {
			this.embarcadorLogicAdditional=embarcadorLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  EmbarcadorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.embarcadorDataAccess = new EmbarcadorDataAccess();
			
			this.embarcadors= new ArrayList<Embarcador>();
			this.embarcador= new Embarcador();
			
			this.embarcadorObject=new Object();
			this.embarcadorsObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.embarcadorDataAccess.setConnexionType(this.connexionType);
			this.embarcadorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmbarcadorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.embarcadorDataAccess = new EmbarcadorDataAccess();
			this.embarcadors= new ArrayList<Embarcador>();
			this.embarcador= new Embarcador();
			this.embarcadorObject=new Object();
			this.embarcadorsObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.embarcadorDataAccess.setConnexionType(this.connexionType);
			this.embarcadorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Embarcador getEmbarcador() throws Exception {	
		EmbarcadorLogicAdditional.checkEmbarcadorToGet(embarcador,this.datosCliente,this.arrDatoGeneral);
		EmbarcadorLogicAdditional.updateEmbarcadorToGet(embarcador,this.arrDatoGeneral);
		
		return embarcador;
	}
		
	public void setEmbarcador(Embarcador newEmbarcador) {
		this.embarcador = newEmbarcador;
	}
	
	public EmbarcadorDataAccess getEmbarcadorDataAccess() {
		return embarcadorDataAccess;
	}
	
	public void setEmbarcadorDataAccess(EmbarcadorDataAccess newembarcadorDataAccess) {
		this.embarcadorDataAccess = newembarcadorDataAccess;
	}
	
	public List<Embarcador> getEmbarcadors() throws Exception {		
		this.quitarEmbarcadorsNulos();
		
		EmbarcadorLogicAdditional.checkEmbarcadorToGets(embarcadors,this.datosCliente,this.arrDatoGeneral);
		
		for (Embarcador embarcadorLocal: embarcadors ) {
			EmbarcadorLogicAdditional.updateEmbarcadorToGet(embarcadorLocal,this.arrDatoGeneral);
		}
		
		return embarcadors;
	}
	
	public void setEmbarcadors(List<Embarcador> newEmbarcadors) {
		this.embarcadors = newEmbarcadors;
	}
	
	public Object getEmbarcadorObject() {	
		this.embarcadorObject=this.embarcadorDataAccess.getEntityObject();
		return this.embarcadorObject;
	}
		
	public void setEmbarcadorObject(Object newEmbarcadorObject) {
		this.embarcadorObject = newEmbarcadorObject;
	}
	
	public List<Object> getEmbarcadorsObject() {		
		this.embarcadorsObject=this.embarcadorDataAccess.getEntitiesObject();
		return this.embarcadorsObject;
	}
		
	public void setEmbarcadorsObject(List<Object> newEmbarcadorsObject) {
		this.embarcadorsObject = newEmbarcadorsObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.embarcadorDataAccess!=null) {
			this.embarcadorDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
	}
	
	public ArrayList<DatoGeneral> getArrDatoGeneral() {
		return arrDatoGeneral;
	}

	public void setArrDatoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) {
		this.arrDatoGeneral = arrDatoGeneral;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}


	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void getNewConnexionToDeep(String sDetalle)throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,sDetalle);connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void commitNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.commit();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void rollbackNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.rollback();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void closeNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.close();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			embarcadorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void executeQuery(String sQueryExecute) throws Exception {
		try {			
			embarcadorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		embarcador = new  Embarcador();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			embarcador=embarcadorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.embarcador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcador);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		embarcador = new  Embarcador();
		  		  
        try {
			
			embarcador=embarcadorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.embarcador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcador);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		embarcador = new  Embarcador();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			embarcador=embarcadorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.embarcador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcador);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		embarcador = new  Embarcador();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		embarcador = new  Embarcador();
		  		  
        try {
			
			embarcador=embarcadorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.embarcador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcador);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		embarcador = new  Embarcador();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		embarcador = new  Embarcador();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =embarcadorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		embarcador = new  Embarcador();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=embarcadorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		embarcador = new  Embarcador();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =embarcadorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		embarcador = new  Embarcador();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=embarcadorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		embarcador = new  Embarcador();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =embarcadorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		embarcador = new  Embarcador();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=embarcadorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		  		  
        try {			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		  		  
        try {
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		embarcador = new  Embarcador();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcador=embarcadorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmbarcador(embarcador);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcador);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		embarcador = new  Embarcador();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcador=embarcadorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmbarcador(embarcador);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcador);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		embarcadors = new  ArrayList<Embarcador>();
		  		  
        try {
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmbarcadorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		embarcadors = new  ArrayList<Embarcador>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getTodosEmbarcadorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosEmbarcadors(String sFinalQuery,Pagination pagination)throws Exception {
		embarcadors = new  ArrayList<Embarcador>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmbarcador(embarcadors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmbarcador(Embarcador embarcador) throws Exception {
		Boolean estaValidado=false;
		
		if(embarcador.getIsNew() || embarcador.getIsChanged()) { 
			this.invalidValues = embarcadorValidator.getInvalidValues(embarcador);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(embarcador);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmbarcador(List<Embarcador> Embarcadors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Embarcador embarcadorLocal:embarcadors) {				
			estaValidadoObjeto=this.validarGuardarEmbarcador(embarcadorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmbarcador(List<Embarcador> Embarcadors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmbarcador(embarcadors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmbarcador(Embarcador Embarcador) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmbarcador(embarcador)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Embarcador embarcador) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+embarcador.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmbarcadorConstantesFunciones.getEmbarcadorLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"embarcador","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmbarcadorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmbarcadorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmbarcadorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-saveEmbarcadorWithConnection");connexion.begin();			
			
			EmbarcadorLogicAdditional.checkEmbarcadorToSave(this.embarcador,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmbarcadorLogicAdditional.updateEmbarcadorToSave(this.embarcador,this.arrDatoGeneral);
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.embarcador,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmbarcador();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmbarcador(this.embarcador)) {
				EmbarcadorDataAccess.save(this.embarcador, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.embarcador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmbarcadorLogicAdditional.checkEmbarcadorToSaveAfter(this.embarcador,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmbarcador();
			
			connexion.commit();			
			
			if(this.embarcador.getIsDeleted()) {
				this.embarcador=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmbarcador()throws Exception {	
		try {	
			
			EmbarcadorLogicAdditional.checkEmbarcadorToSave(this.embarcador,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmbarcadorLogicAdditional.updateEmbarcadorToSave(this.embarcador,this.arrDatoGeneral);
			
			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.embarcador,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmbarcador(this.embarcador)) {			
				EmbarcadorDataAccess.save(this.embarcador, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.embarcador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmbarcadorLogicAdditional.checkEmbarcadorToSaveAfter(this.embarcador,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.embarcador.getIsDeleted()) {
				this.embarcador=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmbarcadorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-saveEmbarcadorsWithConnection");connexion.begin();			
			
			EmbarcadorLogicAdditional.checkEmbarcadorToSaves(embarcadors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmbarcadors();
			
			Boolean validadoTodosEmbarcador=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Embarcador embarcadorLocal:embarcadors) {		
				if(embarcadorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmbarcadorLogicAdditional.updateEmbarcadorToSave(embarcadorLocal,this.arrDatoGeneral);
	        	
				EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),embarcadorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmbarcador(embarcadorLocal)) {
					EmbarcadorDataAccess.save(embarcadorLocal, connexion);				
				} else {
					validadoTodosEmbarcador=false;
				}
			}
			
			if(!validadoTodosEmbarcador) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmbarcadorLogicAdditional.checkEmbarcadorToSavesAfter(embarcadors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmbarcadors();
			
			connexion.commit();		
			
			this.quitarEmbarcadorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmbarcadors()throws Exception {				
		 try {	
			EmbarcadorLogicAdditional.checkEmbarcadorToSaves(embarcadors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmbarcador=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Embarcador embarcadorLocal:embarcadors) {				
				if(embarcadorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmbarcadorLogicAdditional.updateEmbarcadorToSave(embarcadorLocal,this.arrDatoGeneral);
	        	
				EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),embarcadorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmbarcador(embarcadorLocal)) {				
					EmbarcadorDataAccess.save(embarcadorLocal, connexion);				
				} else {
					validadoTodosEmbarcador=false;
				}
			}
			
			if(!validadoTodosEmbarcador) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmbarcadorLogicAdditional.checkEmbarcadorToSavesAfter(embarcadors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmbarcadorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmbarcadorParameterReturnGeneral procesarAccionEmbarcadors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Embarcador> embarcadors,EmbarcadorParameterReturnGeneral embarcadorParameterGeneral)throws Exception {
		 try {	
			EmbarcadorParameterReturnGeneral embarcadorReturnGeneral=new EmbarcadorParameterReturnGeneral();
	
			EmbarcadorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,embarcadors,embarcadorParameterGeneral,embarcadorReturnGeneral);
			
			return embarcadorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmbarcadorParameterReturnGeneral procesarAccionEmbarcadorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Embarcador> embarcadors,EmbarcadorParameterReturnGeneral embarcadorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-procesarAccionEmbarcadorsWithConnection");connexion.begin();			
			
			EmbarcadorParameterReturnGeneral embarcadorReturnGeneral=new EmbarcadorParameterReturnGeneral();
	
			EmbarcadorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,embarcadors,embarcadorParameterGeneral,embarcadorReturnGeneral);
			
			this.connexion.commit();
			
			return embarcadorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmbarcadorParameterReturnGeneral procesarEventosEmbarcadors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Embarcador> embarcadors,Embarcador embarcador,EmbarcadorParameterReturnGeneral embarcadorParameterGeneral,Boolean isEsNuevoEmbarcador,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmbarcadorParameterReturnGeneral embarcadorReturnGeneral=new EmbarcadorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				embarcadorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmbarcadorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,embarcadors,embarcador,embarcadorParameterGeneral,embarcadorReturnGeneral,isEsNuevoEmbarcador,clases);
			
			return embarcadorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmbarcadorParameterReturnGeneral procesarEventosEmbarcadorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Embarcador> embarcadors,Embarcador embarcador,EmbarcadorParameterReturnGeneral embarcadorParameterGeneral,Boolean isEsNuevoEmbarcador,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-procesarEventosEmbarcadorsWithConnection");connexion.begin();			
			
			EmbarcadorParameterReturnGeneral embarcadorReturnGeneral=new EmbarcadorParameterReturnGeneral();
	
			embarcadorReturnGeneral.setEmbarcador(embarcador);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				embarcadorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmbarcadorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,embarcadors,embarcador,embarcadorParameterGeneral,embarcadorReturnGeneral,isEsNuevoEmbarcador,clases);
			
			this.connexion.commit();
			
			return embarcadorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmbarcadorParameterReturnGeneral procesarImportacionEmbarcadorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmbarcadorParameterReturnGeneral embarcadorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-procesarImportacionEmbarcadorsWithConnection");connexion.begin();			
			
			EmbarcadorParameterReturnGeneral embarcadorReturnGeneral=new EmbarcadorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.embarcadors=new ArrayList<Embarcador>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.embarcador=new Embarcador();
				
				
				if(conColumnasBase) {this.embarcador.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.embarcador.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.embarcador.setnombre(arrColumnas[iColumn++]);
				this.embarcador.setruc(arrColumnas[iColumn++]);
				this.embarcador.setdireccion(arrColumnas[iColumn++]);
				this.embarcador.settelefono(arrColumnas[iColumn++]);
				this.embarcador.setcontacto(arrColumnas[iColumn++]);
				this.embarcador.sete_mail(arrColumnas[iColumn++]);
				this.embarcador.setfax(arrColumnas[iColumn++]);
				
				this.embarcadors.add(this.embarcador);
			}
			
			this.saveEmbarcadors();
			
			this.connexion.commit();
			
			embarcadorReturnGeneral.setConRetornoEstaProcesado(true);
			embarcadorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return embarcadorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmbarcadorsEliminados() throws Exception {				
		
		List<Embarcador> embarcadorsAux= new ArrayList<Embarcador>();
		
		for(Embarcador embarcador:embarcadors) {
			if(!embarcador.getIsDeleted()) {
				embarcadorsAux.add(embarcador);
			}
		}
		
		embarcadors=embarcadorsAux;
	}
	
	public void quitarEmbarcadorsNulos() throws Exception {				
		
		List<Embarcador> embarcadorsAux= new ArrayList<Embarcador>();
		
		for(Embarcador embarcador : this.embarcadors) {
			if(embarcador==null) {
				embarcadorsAux.add(embarcador);
			}
		}
		
		//this.embarcadors=embarcadorsAux;
		
		this.embarcadors.removeAll(embarcadorsAux);
	}
	
	public void getSetVersionRowEmbarcadorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(embarcador.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((embarcador.getIsDeleted() || (embarcador.getIsChanged()&&!embarcador.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=embarcadorDataAccess.getSetVersionRowEmbarcador(connexion,embarcador.getId());
				
				if(!embarcador.getVersionRow().equals(timestamp)) {	
					embarcador.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				embarcador.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmbarcador()throws Exception {	
		
		if(embarcador.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((embarcador.getIsDeleted() || (embarcador.getIsChanged()&&!embarcador.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=embarcadorDataAccess.getSetVersionRowEmbarcador(connexion,embarcador.getId());
			
			try {							
				if(!embarcador.getVersionRow().equals(timestamp)) {	
					embarcador.setVersionRow(timestamp);
				}
				
				embarcador.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmbarcadorsWithConnection()throws Exception {	
		if(embarcadors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Embarcador embarcadorAux:embarcadors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(embarcadorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(embarcadorAux.getIsDeleted() || (embarcadorAux.getIsChanged()&&!embarcadorAux.getIsNew())) {
						
						timestamp=embarcadorDataAccess.getSetVersionRowEmbarcador(connexion,embarcadorAux.getId());
						
						if(!embarcador.getVersionRow().equals(timestamp)) {	
							embarcadorAux.setVersionRow(timestamp);
						}
								
						embarcadorAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmbarcadors()throws Exception {	
		if(embarcadors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Embarcador embarcadorAux:embarcadors) {
					if(embarcadorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(embarcadorAux.getIsDeleted() || (embarcadorAux.getIsChanged()&&!embarcadorAux.getIsNew())) {
						
						timestamp=embarcadorDataAccess.getSetVersionRowEmbarcador(connexion,embarcadorAux.getId());
						
						if(!embarcadorAux.getVersionRow().equals(timestamp)) {	
							embarcadorAux.setVersionRow(timestamp);
						}
						
													
						embarcadorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmbarcadorParameterReturnGeneral cargarCombosLoteForeignKeyEmbarcadorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalPuerto,String finalQueryGlobalEmpleado,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		EmbarcadorParameterReturnGeneral  embarcadorReturnGeneral =new EmbarcadorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmbarcadorWithConnection");connexion.begin();
			
			embarcadorReturnGeneral =new EmbarcadorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			embarcadorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			embarcadorReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<Puerto> puertosForeignKey=new ArrayList<Puerto>();
			PuertoLogic puertoLogic=new PuertoLogic();
			puertoLogic.setConnexion(this.connexion);
			puertoLogic.getPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuerto.equals("NONE")) {
				puertoLogic.getTodosPuertos(finalQueryGlobalPuerto,new Pagination());
				puertosForeignKey=puertoLogic.getPuertos();
			}

			embarcadorReturnGeneral.setpuertosForeignKey(puertosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			embarcadorReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			embarcadorReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			embarcadorReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return embarcadorReturnGeneral;
	}
	
	public EmbarcadorParameterReturnGeneral cargarCombosLoteForeignKeyEmbarcador(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalPuerto,String finalQueryGlobalEmpleado,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		EmbarcadorParameterReturnGeneral  embarcadorReturnGeneral =new EmbarcadorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			embarcadorReturnGeneral =new EmbarcadorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			embarcadorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			embarcadorReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<Puerto> puertosForeignKey=new ArrayList<Puerto>();
			PuertoLogic puertoLogic=new PuertoLogic();
			puertoLogic.setConnexion(this.connexion);
			puertoLogic.getPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuerto.equals("NONE")) {
				puertoLogic.getTodosPuertos(finalQueryGlobalPuerto,new Pagination());
				puertosForeignKey=puertoLogic.getPuertos();
			}

			embarcadorReturnGeneral.setpuertosForeignKey(puertosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			embarcadorReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			embarcadorReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			embarcadorReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return embarcadorReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEmbarcadorWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PedidoCompraImporLogic pedidocompraimporLogic=new PedidoCompraImporLogic();
			ParametroCompraLogic parametrocompraLogic=new ParametroCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEmbarcadorWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PedidoCompraImpor.class));
			classes.add(new Classe(ParametroCompra.class));
											
			

			pedidocompraimporLogic.setConnexion(this.getConnexion());
			pedidocompraimporLogic.setDatosCliente(this.datosCliente);
			pedidocompraimporLogic.setIsConRefrescarForeignKeys(true);

			parametrocompraLogic.setConnexion(this.getConnexion());
			parametrocompraLogic.setDatosCliente(this.datosCliente);
			parametrocompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Embarcador embarcador:this.embarcadors) {
				

				classes=new ArrayList<Classe>();
				classes=PedidoCompraImporConstantesFunciones.getClassesForeignKeysOfPedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidocompraimporLogic.setPedidoCompraImpors(embarcador.pedidocompraimpors);
				pedidocompraimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCompraConstantesFunciones.getClassesForeignKeysOfParametroCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocompraLogic.setParametroCompras(embarcador.parametrocompras);
				parametrocompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(Embarcador embarcador,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmbarcadorLogicAdditional.updateEmbarcadorToGet(embarcador,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		embarcador.setEmpresa(embarcadorDataAccess.getEmpresa(connexion,embarcador));
		embarcador.setTipoViaTransporte(embarcadorDataAccess.getTipoViaTransporte(connexion,embarcador));
		embarcador.setPuerto(embarcadorDataAccess.getPuerto(connexion,embarcador));
		embarcador.setEmpleado(embarcadorDataAccess.getEmpleado(connexion,embarcador));
		embarcador.setPais(embarcadorDataAccess.getPais(connexion,embarcador));
		embarcador.setCiudad(embarcadorDataAccess.getCiudad(connexion,embarcador));
		embarcador.setPedidoCompraImpors(embarcadorDataAccess.getPedidoCompraImpors(connexion,embarcador));
		embarcador.setParametroCompras(embarcadorDataAccess.getParametroCompras(connexion,embarcador));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				embarcador.setEmpresa(embarcadorDataAccess.getEmpresa(connexion,embarcador));
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				embarcador.setTipoViaTransporte(embarcadorDataAccess.getTipoViaTransporte(connexion,embarcador));
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				embarcador.setPuerto(embarcadorDataAccess.getPuerto(connexion,embarcador));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				embarcador.setEmpleado(embarcadorDataAccess.getEmpleado(connexion,embarcador));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				embarcador.setPais(embarcadorDataAccess.getPais(connexion,embarcador));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				embarcador.setCiudad(embarcadorDataAccess.getCiudad(connexion,embarcador));
				continue;
			}

			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				embarcador.setPedidoCompraImpors(embarcadorDataAccess.getPedidoCompraImpors(connexion,embarcador));

				if(this.isConDeep) {
					PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(this.connexion);
					pedidocompraimporLogic.setPedidoCompraImpors(embarcador.getPedidoCompraImpors());
					ArrayList<Classe> classesLocal=PedidoCompraImporConstantesFunciones.getClassesForeignKeysOfPedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidocompraimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(pedidocompraimporLogic.getPedidoCompraImpors());
					embarcador.setPedidoCompraImpors(pedidocompraimporLogic.getPedidoCompraImpors());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				embarcador.setParametroCompras(embarcadorDataAccess.getParametroCompras(connexion,embarcador));

				if(this.isConDeep) {
					ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(this.connexion);
					parametrocompraLogic.setParametroCompras(embarcador.getParametroCompras());
					ArrayList<Classe> classesLocal=ParametroCompraConstantesFunciones.getClassesForeignKeysOfParametroCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(parametrocompraLogic.getParametroCompras());
					embarcador.setParametroCompras(parametrocompraLogic.getParametroCompras());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setEmpresa(embarcadorDataAccess.getEmpresa(connexion,embarcador));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setTipoViaTransporte(embarcadorDataAccess.getTipoViaTransporte(connexion,embarcador));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Puerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setPuerto(embarcadorDataAccess.getPuerto(connexion,embarcador));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setEmpleado(embarcadorDataAccess.getEmpleado(connexion,embarcador));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setPais(embarcadorDataAccess.getPais(connexion,embarcador));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setCiudad(embarcadorDataAccess.getCiudad(connexion,embarcador));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoCompraImpor.class));
			embarcador.setPedidoCompraImpors(embarcadorDataAccess.getPedidoCompraImpors(connexion,embarcador));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCompra.class));
			embarcador.setParametroCompras(embarcadorDataAccess.getParametroCompras(connexion,embarcador));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		embarcador.setEmpresa(embarcadorDataAccess.getEmpresa(connexion,embarcador));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(embarcador.getEmpresa(),isDeep,deepLoadType,clases);
				
		embarcador.setTipoViaTransporte(embarcadorDataAccess.getTipoViaTransporte(connexion,embarcador));
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(embarcador.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		embarcador.setPuerto(embarcadorDataAccess.getPuerto(connexion,embarcador));
		PuertoLogic puertoLogic= new PuertoLogic(connexion);
		puertoLogic.deepLoad(embarcador.getPuerto(),isDeep,deepLoadType,clases);
				
		embarcador.setEmpleado(embarcadorDataAccess.getEmpleado(connexion,embarcador));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(embarcador.getEmpleado(),isDeep,deepLoadType,clases);
				
		embarcador.setPais(embarcadorDataAccess.getPais(connexion,embarcador));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(embarcador.getPais(),isDeep,deepLoadType,clases);
				
		embarcador.setCiudad(embarcadorDataAccess.getCiudad(connexion,embarcador));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(embarcador.getCiudad(),isDeep,deepLoadType,clases);
				

		embarcador.setPedidoCompraImpors(embarcadorDataAccess.getPedidoCompraImpors(connexion,embarcador));

		for(PedidoCompraImpor pedidocompraimpor:embarcador.getPedidoCompraImpors()) {
			PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
			pedidocompraimporLogic.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
		}

		embarcador.setParametroCompras(embarcadorDataAccess.getParametroCompras(connexion,embarcador));

		for(ParametroCompra parametrocompra:embarcador.getParametroCompras()) {
			ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
			parametrocompraLogic.deepLoad(parametrocompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				embarcador.setEmpresa(embarcadorDataAccess.getEmpresa(connexion,embarcador));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(embarcador.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				embarcador.setTipoViaTransporte(embarcadorDataAccess.getTipoViaTransporte(connexion,embarcador));
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepLoad(embarcador.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				embarcador.setPuerto(embarcadorDataAccess.getPuerto(connexion,embarcador));
				PuertoLogic puertoLogic= new PuertoLogic(connexion);
				puertoLogic.deepLoad(embarcador.getPuerto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				embarcador.setEmpleado(embarcadorDataAccess.getEmpleado(connexion,embarcador));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(embarcador.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				embarcador.setPais(embarcadorDataAccess.getPais(connexion,embarcador));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(embarcador.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				embarcador.setCiudad(embarcadorDataAccess.getCiudad(connexion,embarcador));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(embarcador.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				embarcador.setPedidoCompraImpors(embarcadorDataAccess.getPedidoCompraImpors(connexion,embarcador));

				for(PedidoCompraImpor pedidocompraimpor:embarcador.getPedidoCompraImpors()) {
					PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
					pedidocompraimporLogic.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				embarcador.setParametroCompras(embarcadorDataAccess.getParametroCompras(connexion,embarcador));

				for(ParametroCompra parametrocompra:embarcador.getParametroCompras()) {
					ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
					parametrocompraLogic.deepLoad(parametrocompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setEmpresa(embarcadorDataAccess.getEmpresa(connexion,embarcador));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(embarcador.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setTipoViaTransporte(embarcadorDataAccess.getTipoViaTransporte(connexion,embarcador));
			TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
			tipoviatransporteLogic.deepLoad(embarcador.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Puerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setPuerto(embarcadorDataAccess.getPuerto(connexion,embarcador));
			PuertoLogic puertoLogic= new PuertoLogic(connexion);
			puertoLogic.deepLoad(embarcador.getPuerto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setEmpleado(embarcadorDataAccess.getEmpleado(connexion,embarcador));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(embarcador.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setPais(embarcadorDataAccess.getPais(connexion,embarcador));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(embarcador.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			embarcador.setCiudad(embarcadorDataAccess.getCiudad(connexion,embarcador));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(embarcador.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoCompraImpor.class));
			embarcador.setPedidoCompraImpors(embarcadorDataAccess.getPedidoCompraImpors(connexion,embarcador));

			for(PedidoCompraImpor pedidocompraimpor:embarcador.getPedidoCompraImpors()) {
				PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
				pedidocompraimporLogic.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCompra.class));
			embarcador.setParametroCompras(embarcadorDataAccess.getParametroCompras(connexion,embarcador));

			for(ParametroCompra parametrocompra:embarcador.getParametroCompras()) {
				ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
				parametrocompraLogic.deepLoad(parametrocompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Embarcador embarcador,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmbarcadorLogicAdditional.updateEmbarcadorToSave(embarcador,this.arrDatoGeneral);
			
EmbarcadorDataAccess.save(embarcador, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(embarcador.getEmpresa(),connexion);

		TipoViaTransporteDataAccess.save(embarcador.getTipoViaTransporte(),connexion);

		PuertoDataAccess.save(embarcador.getPuerto(),connexion);

		EmpleadoDataAccess.save(embarcador.getEmpleado(),connexion);

		PaisDataAccess.save(embarcador.getPais(),connexion);

		CiudadDataAccess.save(embarcador.getCiudad(),connexion);

		for(PedidoCompraImpor pedidocompraimpor:embarcador.getPedidoCompraImpors()) {
			pedidocompraimpor.setid_embarcador(embarcador.getId());
			PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
		}

		for(ParametroCompra parametrocompra:embarcador.getParametroCompras()) {
			parametrocompra.setid_embarcador(embarcador.getId());
			ParametroCompraDataAccess.save(parametrocompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(embarcador.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(embarcador.getTipoViaTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				PuertoDataAccess.save(embarcador.getPuerto(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(embarcador.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(embarcador.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(embarcador.getCiudad(),connexion);
				continue;
			}


			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoCompraImpor pedidocompraimpor:embarcador.getPedidoCompraImpors()) {
					pedidocompraimpor.setid_embarcador(embarcador.getId());
					PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCompra parametrocompra:embarcador.getParametroCompras()) {
					parametrocompra.setid_embarcador(embarcador.getId());
					ParametroCompraDataAccess.save(parametrocompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(embarcador.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(embarcador.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoViaTransporteDataAccess.save(embarcador.getTipoViaTransporte(),connexion);
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(embarcador.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				

		PuertoDataAccess.save(embarcador.getPuerto(),connexion);
		PuertoLogic puertoLogic= new PuertoLogic(connexion);
		puertoLogic.deepLoad(embarcador.getPuerto(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(embarcador.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(embarcador.getEmpleado(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(embarcador.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(embarcador.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(embarcador.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(embarcador.getCiudad(),isDeep,deepLoadType,clases);
				

		for(PedidoCompraImpor pedidocompraimpor:embarcador.getPedidoCompraImpors()) {
			PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
			pedidocompraimpor.setid_embarcador(embarcador.getId());
			PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
			pedidocompraimporLogic.deepSave(pedidocompraimpor,isDeep,deepLoadType,clases);
		}

		for(ParametroCompra parametrocompra:embarcador.getParametroCompras()) {
			ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
			parametrocompra.setid_embarcador(embarcador.getId());
			ParametroCompraDataAccess.save(parametrocompra,connexion);
			parametrocompraLogic.deepSave(parametrocompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(embarcador.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(embarcador.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(embarcador.getTipoViaTransporte(),connexion);
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepSave(embarcador.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				PuertoDataAccess.save(embarcador.getPuerto(),connexion);
				PuertoLogic puertoLogic= new PuertoLogic(connexion);
				puertoLogic.deepSave(embarcador.getPuerto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(embarcador.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(embarcador.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(embarcador.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(embarcador.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(embarcador.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(embarcador.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoCompraImpor pedidocompraimpor:embarcador.getPedidoCompraImpors()) {
					PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
					pedidocompraimpor.setid_embarcador(embarcador.getId());
					PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
					pedidocompraimporLogic.deepSave(pedidocompraimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCompra parametrocompra:embarcador.getParametroCompras()) {
					ParametroCompraLogic parametrocompraLogic= new ParametroCompraLogic(connexion);
					parametrocompra.setid_embarcador(embarcador.getId());
					ParametroCompraDataAccess.save(parametrocompra,connexion);
					parametrocompraLogic.deepSave(parametrocompra,isDeep,deepLoadType,clases);
				}
				continue;
			}
		}
	}

	}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Embarcador.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(embarcador,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(embarcador);
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoad(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.deepLoad(this.embarcador,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcador);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Embarcador.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(embarcadors!=null) {
				for(Embarcador embarcador:embarcadors) {
					this.deepLoad(embarcador,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(embarcadors);
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoads(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			if(embarcadors!=null) {
				for(Embarcador embarcador:embarcadors) {
					this.deepLoad(embarcador,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(embarcadors);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(Embarcador.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(embarcador,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(Embarcador.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(embarcadors!=null) {
				for(Embarcador embarcador:embarcadors) {
					this.deepSave(embarcador,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(embarcadors!=null) {
				for(Embarcador embarcador:embarcadors) {
					this.deepSave(embarcador,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmbarcadorsBusquedaPorContactoWithConnection(String sFinalQuery,Pagination pagination,String contacto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralContacto= new ParameterSelectionGeneral();
			parameterSelectionGeneralContacto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+contacto+"%",EmbarcadorConstantesFunciones.CONTACTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralContacto);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorContacto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsBusquedaPorContacto(String sFinalQuery,Pagination pagination,String contacto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralContacto= new ParameterSelectionGeneral();
			parameterSelectionGeneralContacto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+contacto+"%",EmbarcadorConstantesFunciones.CONTACTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralContacto);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorContacto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsBusquedaPorEMailWithConnection(String sFinalQuery,Pagination pagination,String e_mail)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralEMail= new ParameterSelectionGeneral();
			parameterSelectionGeneralEMail.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+e_mail+"%",EmbarcadorConstantesFunciones.EMAIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralEMail);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorEMail","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsBusquedaPorEMail(String sFinalQuery,Pagination pagination,String e_mail)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralEMail= new ParameterSelectionGeneral();
			parameterSelectionGeneralEMail.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+e_mail+"%",EmbarcadorConstantesFunciones.EMAIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralEMail);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorEMail","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",EmbarcadorConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",EmbarcadorConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsBusquedaPorRucWithConnection(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",EmbarcadorConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsBusquedaPorRuc(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",EmbarcadorConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsBusquedaPorTelefonoWithConnection(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",EmbarcadorConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsBusquedaPorTelefono(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",EmbarcadorConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,EmbarcadorConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,EmbarcadorConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmbarcadorConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmbarcadorConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmbarcadorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmbarcadorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmbarcadorConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmbarcadorConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsFK_IdPuertoWithConnection(String sFinalQuery,Pagination pagination,Long id_puerto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuerto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuerto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puerto,EmbarcadorConstantesFunciones.IDPUERTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuerto);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuerto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsFK_IdPuerto(String sFinalQuery,Pagination pagination,Long id_puerto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuerto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuerto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puerto,EmbarcadorConstantesFunciones.IDPUERTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuerto);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuerto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmbarcadorsFK_IdTipoViaTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Embarcador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmbarcadorsFK_IdTipoViaTransporte(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			EmbarcadorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(this.embarcadors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmbarcadorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmbarcadorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Embarcador embarcador,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmbarcadorConstantesFunciones.ISCONAUDITORIA) {
				if(embarcador.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmbarcadorDataAccess.TABLENAME, embarcador.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmbarcadorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmbarcadorLogic.registrarAuditoriaDetallesEmbarcador(connexion,embarcador,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(embarcador.getIsDeleted()) {
					/*if(!embarcador.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmbarcadorDataAccess.TABLENAME, embarcador.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmbarcadorLogic.registrarAuditoriaDetallesEmbarcador(connexion,embarcador,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmbarcadorDataAccess.TABLENAME, embarcador.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(embarcador.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmbarcadorDataAccess.TABLENAME, embarcador.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmbarcadorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmbarcadorLogic.registrarAuditoriaDetallesEmbarcador(connexion,embarcador,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmbarcador(Connexion connexion,Embarcador embarcador)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(embarcador.getIsNew()||!embarcador.getid_empresa().equals(embarcador.getEmbarcadorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getid_empresa()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getid_empresa().toString();
				}
				if(embarcador.getid_empresa()!=null)
				{
					strValorNuevo=embarcador.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getnombre().equals(embarcador.getEmbarcadorOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getnombre()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getnombre();
				}
				if(embarcador.getnombre()!=null)
				{
					strValorNuevo=embarcador.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getruc().equals(embarcador.getEmbarcadorOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getruc()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getruc();
				}
				if(embarcador.getruc()!=null)
				{
					strValorNuevo=embarcador.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getdireccion().equals(embarcador.getEmbarcadorOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getdireccion()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getdireccion();
				}
				if(embarcador.getdireccion()!=null)
				{
					strValorNuevo=embarcador.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.gettelefono().equals(embarcador.getEmbarcadorOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().gettelefono()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().gettelefono();
				}
				if(embarcador.gettelefono()!=null)
				{
					strValorNuevo=embarcador.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getcontacto().equals(embarcador.getEmbarcadorOriginal().getcontacto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getcontacto()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getcontacto();
				}
				if(embarcador.getcontacto()!=null)
				{
					strValorNuevo=embarcador.getcontacto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.CONTACTO,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.gete_mail().equals(embarcador.getEmbarcadorOriginal().gete_mail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().gete_mail()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().gete_mail();
				}
				if(embarcador.gete_mail()!=null)
				{
					strValorNuevo=embarcador.gete_mail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getfax().equals(embarcador.getEmbarcadorOriginal().getfax()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getfax()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getfax();
				}
				if(embarcador.getfax()!=null)
				{
					strValorNuevo=embarcador.getfax() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.FAX,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getid_tipo_via_transporte().equals(embarcador.getEmbarcadorOriginal().getid_tipo_via_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getid_tipo_via_transporte()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getid_tipo_via_transporte().toString();
				}
				if(embarcador.getid_tipo_via_transporte()!=null)
				{
					strValorNuevo=embarcador.getid_tipo_via_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getid_puerto().equals(embarcador.getEmbarcadorOriginal().getid_puerto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getid_puerto()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getid_puerto().toString();
				}
				if(embarcador.getid_puerto()!=null)
				{
					strValorNuevo=embarcador.getid_puerto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.IDPUERTO,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getid_empleado().equals(embarcador.getEmbarcadorOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getid_empleado()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getid_empleado().toString();
				}
				if(embarcador.getid_empleado()!=null)
				{
					strValorNuevo=embarcador.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getid_pais().equals(embarcador.getEmbarcadorOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getid_pais()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getid_pais().toString();
				}
				if(embarcador.getid_pais()!=null)
				{
					strValorNuevo=embarcador.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(embarcador.getIsNew()||!embarcador.getid_ciudad().equals(embarcador.getEmbarcadorOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(embarcador.getEmbarcadorOriginal().getid_ciudad()!=null)
				{
					strValorActual=embarcador.getEmbarcadorOriginal().getid_ciudad().toString();
				}
				if(embarcador.getid_ciudad()!=null)
				{
					strValorNuevo=embarcador.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmbarcadorConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmbarcadorRelacionesWithConnection(Embarcador embarcador,List<PedidoCompraImpor> pedidocompraimpors,List<ParametroCompra> parametrocompras) throws Exception {

		if(!embarcador.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmbarcadorRelacionesBase(embarcador,pedidocompraimpors,parametrocompras,true);
		}
	}

	public void saveEmbarcadorRelaciones(Embarcador embarcador,List<PedidoCompraImpor> pedidocompraimpors,List<ParametroCompra> parametrocompras)throws Exception {

		if(!embarcador.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmbarcadorRelacionesBase(embarcador,pedidocompraimpors,parametrocompras,false);
		}
	}

	public void saveEmbarcadorRelacionesBase(Embarcador embarcador,List<PedidoCompraImpor> pedidocompraimpors,List<ParametroCompra> parametrocompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Embarcador-saveRelacionesWithConnection");}
	
			embarcador.setPedidoCompraImpors(pedidocompraimpors);
			embarcador.setParametroCompras(parametrocompras);

			this.setEmbarcador(embarcador);

			if(EmbarcadorLogicAdditional.validarSaveRelaciones(embarcador,this)) {

				EmbarcadorLogicAdditional.updateRelacionesToSave(embarcador,this);

				if((embarcador.getIsNew()||embarcador.getIsChanged())&&!embarcador.getIsDeleted()) {
					this.saveEmbarcador();
					this.saveEmbarcadorRelacionesDetalles(pedidocompraimpors,parametrocompras);

				} else if(embarcador.getIsDeleted()) {
					this.saveEmbarcadorRelacionesDetalles(pedidocompraimpors,parametrocompras);
					this.saveEmbarcador();
				}

				EmbarcadorLogicAdditional.updateRelacionesToSaveAfter(embarcador,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PedidoCompraImporConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoCompraImpors(pedidocompraimpors,true,true);
			ParametroCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCompras(parametrocompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEmbarcadorRelacionesDetalles(List<PedidoCompraImpor> pedidocompraimpors,List<ParametroCompra> parametrocompras)throws Exception {
		try {
	

			Long idEmbarcadorActual=this.getEmbarcador().getId();

			PedidoCompraImporLogic pedidocompraimporLogic_Desde_Embarcador=new PedidoCompraImporLogic();
			pedidocompraimporLogic_Desde_Embarcador.setPedidoCompraImpors(pedidocompraimpors);

			pedidocompraimporLogic_Desde_Embarcador.setConnexion(this.getConnexion());
			pedidocompraimporLogic_Desde_Embarcador.setDatosCliente(this.datosCliente);

			for(PedidoCompraImpor pedidocompraimpor_Desde_Embarcador:pedidocompraimporLogic_Desde_Embarcador.getPedidoCompraImpors()) {
				pedidocompraimpor_Desde_Embarcador.setid_embarcador(idEmbarcadorActual);

				pedidocompraimporLogic_Desde_Embarcador.setPedidoCompraImpor(pedidocompraimpor_Desde_Embarcador);
				pedidocompraimporLogic_Desde_Embarcador.savePedidoCompraImpor();

				Long idPedidoCompraImporActual=pedidocompraimpor_Desde_Embarcador.getId();

				DetallePedidoCompraImporLogic detallepedidocompraimporLogic_Desde_PedidoCompraImpor=new DetallePedidoCompraImporLogic();

				if(pedidocompraimpor_Desde_Embarcador.getDetallePedidoCompraImpors()==null){
					pedidocompraimpor_Desde_Embarcador.setDetallePedidoCompraImpors(new ArrayList<DetallePedidoCompraImpor>());
				}

				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDetallePedidoCompraImpors(pedidocompraimpor_Desde_Embarcador.getDetallePedidoCompraImpors());

				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

				for(DetallePedidoCompraImpor detallepedidocompraimpor_Desde_PedidoCompraImpor:detallepedidocompraimporLogic_Desde_PedidoCompraImpor.getDetallePedidoCompraImpors()) {
					detallepedidocompraimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);
				}

				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.saveDetallePedidoCompraImpors();

				LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor=new LiquidacionImpuestoImporLogic();

				if(pedidocompraimpor_Desde_Embarcador.getLiquidacionImpuestoImpors()==null){
					pedidocompraimpor_Desde_Embarcador.setLiquidacionImpuestoImpors(new ArrayList<LiquidacionImpuestoImpor>());
				}

				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpors(pedidocompraimpor_Desde_Embarcador.getLiquidacionImpuestoImpors());

				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor_Desde_PedidoCompraImpor:liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.getLiquidacionImpuestoImpors()) {
					liquidacionimpuestoimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);

					liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpor(liquidacionimpuestoimpor_Desde_PedidoCompraImpor);
					liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.saveLiquidacionImpuestoImpor();

					Long idLiquidacionImpuestoImporActual=liquidacionimpuestoimpor_Desde_PedidoCompraImpor.getId();

					DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor=new DetalleLiquidacionImpuestoImporLogic();

					if(liquidacionimpuestoimpor_Desde_PedidoCompraImpor.getDetalleLiquidacionImpuestoImpors()==null){
						liquidacionimpuestoimpor_Desde_PedidoCompraImpor.setDetalleLiquidacionImpuestoImpors(new ArrayList<DetalleLiquidacionImpuestoImpor>());
					}

					detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimpor_Desde_PedidoCompraImpor.getDetalleLiquidacionImpuestoImpors());

					detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setConnexion(this.getConnexion());
					detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setDatosCliente(this.datosCliente);

					for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor_Desde_LiquidacionImpuestoImpor:detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.getDetalleLiquidacionImpuestoImpors()) {
						detalleliquidacionimpuestoimpor_Desde_LiquidacionImpuestoImpor.setid_liquidacion_impuesto_impor(idLiquidacionImpuestoImporActual);
					}

					detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.saveDetalleLiquidacionImpuestoImpors();
				}

			}


			ParametroCompraLogic parametrocompraLogic_Desde_Embarcador=new ParametroCompraLogic();
			parametrocompraLogic_Desde_Embarcador.setParametroCompras(parametrocompras);

			parametrocompraLogic_Desde_Embarcador.setConnexion(this.getConnexion());
			parametrocompraLogic_Desde_Embarcador.setDatosCliente(this.datosCliente);

			for(ParametroCompra parametrocompra_Desde_Embarcador:parametrocompraLogic_Desde_Embarcador.getParametroCompras()) {
				parametrocompra_Desde_Embarcador.setid_embarcador(idEmbarcadorActual);
			}

			parametrocompraLogic_Desde_Embarcador.saveParametroCompras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmbarcador(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmbarcadorConstantesFunciones.getClassesForeignKeysOfEmbarcador(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmbarcador(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmbarcadorConstantesFunciones.getClassesRelationshipsOfEmbarcador(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

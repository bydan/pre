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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.ParroquiaConstantesFunciones;
import com.bydan.erp.seguridad.util.ParroquiaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ParroquiaParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Parroquia;
import com.bydan.erp.seguridad.business.logic.ParroquiaLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParroquiaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParroquiaLogic.class);
	
	protected ParroquiaDataAccess parroquiaDataAccess; 	
	protected Parroquia parroquia;
	protected List<Parroquia> parroquias;
	protected Object parroquiaObject;	
	protected List<Object> parroquiasObject;
	
	public static ClassValidator<Parroquia> parroquiaValidator = new ClassValidator<Parroquia>(Parroquia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParroquiaLogicAdditional parroquiaLogicAdditional=null;
	
	public ParroquiaLogicAdditional getParroquiaLogicAdditional() {
		return this.parroquiaLogicAdditional;
	}
	
	public void setParroquiaLogicAdditional(ParroquiaLogicAdditional parroquiaLogicAdditional) {
		try {
			this.parroquiaLogicAdditional=parroquiaLogicAdditional;
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
	
	
	
	
	public  ParroquiaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parroquiaDataAccess = new ParroquiaDataAccess();
			
			this.parroquias= new ArrayList<Parroquia>();
			this.parroquia= new Parroquia();
			
			this.parroquiaObject=new Object();
			this.parroquiasObject=new ArrayList<Object>();
				
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
			
			this.parroquiaDataAccess.setConnexionType(this.connexionType);
			this.parroquiaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParroquiaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parroquiaDataAccess = new ParroquiaDataAccess();
			this.parroquias= new ArrayList<Parroquia>();
			this.parroquia= new Parroquia();
			this.parroquiaObject=new Object();
			this.parroquiasObject=new ArrayList<Object>();
			
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
			
			this.parroquiaDataAccess.setConnexionType(this.connexionType);
			this.parroquiaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Parroquia getParroquia() throws Exception {	
		ParroquiaLogicAdditional.checkParroquiaToGet(parroquia,this.datosCliente,this.arrDatoGeneral);
		ParroquiaLogicAdditional.updateParroquiaToGet(parroquia,this.arrDatoGeneral);
		
		return parroquia;
	}
		
	public void setParroquia(Parroquia newParroquia) {
		this.parroquia = newParroquia;
	}
	
	public ParroquiaDataAccess getParroquiaDataAccess() {
		return parroquiaDataAccess;
	}
	
	public void setParroquiaDataAccess(ParroquiaDataAccess newparroquiaDataAccess) {
		this.parroquiaDataAccess = newparroquiaDataAccess;
	}
	
	public List<Parroquia> getParroquias() throws Exception {		
		this.quitarParroquiasNulos();
		
		ParroquiaLogicAdditional.checkParroquiaToGets(parroquias,this.datosCliente,this.arrDatoGeneral);
		
		for (Parroquia parroquiaLocal: parroquias ) {
			ParroquiaLogicAdditional.updateParroquiaToGet(parroquiaLocal,this.arrDatoGeneral);
		}
		
		return parroquias;
	}
	
	public void setParroquias(List<Parroquia> newParroquias) {
		this.parroquias = newParroquias;
	}
	
	public Object getParroquiaObject() {	
		this.parroquiaObject=this.parroquiaDataAccess.getEntityObject();
		return this.parroquiaObject;
	}
		
	public void setParroquiaObject(Object newParroquiaObject) {
		this.parroquiaObject = newParroquiaObject;
	}
	
	public List<Object> getParroquiasObject() {		
		this.parroquiasObject=this.parroquiaDataAccess.getEntitiesObject();
		return this.parroquiasObject;
	}
		
	public void setParroquiasObject(List<Object> newParroquiasObject) {
		this.parroquiasObject = newParroquiasObject;
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
		
		if(this.parroquiaDataAccess!=null) {
			this.parroquiaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parroquiaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parroquiaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parroquia = new  Parroquia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parroquia=parroquiaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parroquia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquia);
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
		parroquia = new  Parroquia();
		  		  
        try {
			
			parroquia=parroquiaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parroquia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parroquia = new  Parroquia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parroquia=parroquiaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parroquia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquia);
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
		parroquia = new  Parroquia();
		  		  
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
		parroquia = new  Parroquia();
		  		  
        try {
			
			parroquia=parroquiaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parroquia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parroquia = new  Parroquia();
		  		  
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
		parroquia = new  Parroquia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parroquiaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parroquia = new  Parroquia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parroquiaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parroquia = new  Parroquia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parroquiaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parroquia = new  Parroquia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parroquiaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parroquia = new  Parroquia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parroquiaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parroquia = new  Parroquia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parroquiaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parroquias = new  ArrayList<Parroquia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
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
		parroquias = new  ArrayList<Parroquia>();
		  		  
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
		parroquias = new  ArrayList<Parroquia>();
		  		  
        try {			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parroquias = new  ArrayList<Parroquia>();
		  		  
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
		parroquias = new  ArrayList<Parroquia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
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
		parroquias = new  ArrayList<Parroquia>();
		  		  
        try {
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
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
		parroquias = new  ArrayList<Parroquia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
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
		parroquias = new  ArrayList<Parroquia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parroquia = new  Parroquia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquia=parroquiaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParroquia(parroquia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquia);
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
		parroquia = new  Parroquia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquia=parroquiaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParroquia(parroquia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parroquias = new  ArrayList<Parroquia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
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
		parroquias = new  ArrayList<Parroquia>();
		  		  
        try {
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParroquiasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parroquias = new  ArrayList<Parroquia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getTodosParroquiasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
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
	
	public  void  getTodosParroquias(String sFinalQuery,Pagination pagination)throws Exception {
		parroquias = new  ArrayList<Parroquia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parroquias=parroquiaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParroquia(parroquias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParroquia(Parroquia parroquia) throws Exception {
		Boolean estaValidado=false;
		
		if(parroquia.getIsNew() || parroquia.getIsChanged()) { 
			this.invalidValues = parroquiaValidator.getInvalidValues(parroquia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parroquia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParroquia(List<Parroquia> Parroquias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Parroquia parroquiaLocal:parroquias) {				
			estaValidadoObjeto=this.validarGuardarParroquia(parroquiaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParroquia(List<Parroquia> Parroquias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParroquia(parroquias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParroquia(Parroquia Parroquia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParroquia(parroquia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Parroquia parroquia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parroquia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParroquiaConstantesFunciones.getParroquiaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parroquia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParroquiaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParroquiaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParroquiaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-saveParroquiaWithConnection");connexion.begin();			
			
			ParroquiaLogicAdditional.checkParroquiaToSave(this.parroquia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParroquiaLogicAdditional.updateParroquiaToSave(this.parroquia,this.arrDatoGeneral);
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parroquia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParroquia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParroquia(this.parroquia)) {
				ParroquiaDataAccess.save(this.parroquia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parroquia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParroquiaLogicAdditional.checkParroquiaToSaveAfter(this.parroquia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParroquia();
			
			connexion.commit();			
			
			if(this.parroquia.getIsDeleted()) {
				this.parroquia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParroquia()throws Exception {	
		try {	
			
			ParroquiaLogicAdditional.checkParroquiaToSave(this.parroquia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParroquiaLogicAdditional.updateParroquiaToSave(this.parroquia,this.arrDatoGeneral);
			
			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parroquia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParroquia(this.parroquia)) {			
				ParroquiaDataAccess.save(this.parroquia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parroquia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParroquiaLogicAdditional.checkParroquiaToSaveAfter(this.parroquia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parroquia.getIsDeleted()) {
				this.parroquia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParroquiasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-saveParroquiasWithConnection");connexion.begin();			
			
			ParroquiaLogicAdditional.checkParroquiaToSaves(parroquias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParroquias();
			
			Boolean validadoTodosParroquia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Parroquia parroquiaLocal:parroquias) {		
				if(parroquiaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParroquiaLogicAdditional.updateParroquiaToSave(parroquiaLocal,this.arrDatoGeneral);
	        	
				ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parroquiaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParroquia(parroquiaLocal)) {
					ParroquiaDataAccess.save(parroquiaLocal, connexion);				
				} else {
					validadoTodosParroquia=false;
				}
			}
			
			if(!validadoTodosParroquia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParroquiaLogicAdditional.checkParroquiaToSavesAfter(parroquias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParroquias();
			
			connexion.commit();		
			
			this.quitarParroquiasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParroquias()throws Exception {				
		 try {	
			ParroquiaLogicAdditional.checkParroquiaToSaves(parroquias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParroquia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Parroquia parroquiaLocal:parroquias) {				
				if(parroquiaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParroquiaLogicAdditional.updateParroquiaToSave(parroquiaLocal,this.arrDatoGeneral);
	        	
				ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parroquiaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParroquia(parroquiaLocal)) {				
					ParroquiaDataAccess.save(parroquiaLocal, connexion);				
				} else {
					validadoTodosParroquia=false;
				}
			}
			
			if(!validadoTodosParroquia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParroquiaLogicAdditional.checkParroquiaToSavesAfter(parroquias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParroquiasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParroquiaParameterReturnGeneral procesarAccionParroquias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Parroquia> parroquias,ParroquiaParameterReturnGeneral parroquiaParameterGeneral)throws Exception {
		 try {	
			ParroquiaParameterReturnGeneral parroquiaReturnGeneral=new ParroquiaParameterReturnGeneral();
	
			ParroquiaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parroquias,parroquiaParameterGeneral,parroquiaReturnGeneral);
			
			return parroquiaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParroquiaParameterReturnGeneral procesarAccionParroquiasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Parroquia> parroquias,ParroquiaParameterReturnGeneral parroquiaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-procesarAccionParroquiasWithConnection");connexion.begin();			
			
			ParroquiaParameterReturnGeneral parroquiaReturnGeneral=new ParroquiaParameterReturnGeneral();
	
			ParroquiaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parroquias,parroquiaParameterGeneral,parroquiaReturnGeneral);
			
			this.connexion.commit();
			
			return parroquiaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParroquiaParameterReturnGeneral procesarEventosParroquias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Parroquia> parroquias,Parroquia parroquia,ParroquiaParameterReturnGeneral parroquiaParameterGeneral,Boolean isEsNuevoParroquia,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParroquiaParameterReturnGeneral parroquiaReturnGeneral=new ParroquiaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parroquiaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParroquiaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parroquias,parroquia,parroquiaParameterGeneral,parroquiaReturnGeneral,isEsNuevoParroquia,clases);
			
			return parroquiaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParroquiaParameterReturnGeneral procesarEventosParroquiasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Parroquia> parroquias,Parroquia parroquia,ParroquiaParameterReturnGeneral parroquiaParameterGeneral,Boolean isEsNuevoParroquia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-procesarEventosParroquiasWithConnection");connexion.begin();			
			
			ParroquiaParameterReturnGeneral parroquiaReturnGeneral=new ParroquiaParameterReturnGeneral();
	
			parroquiaReturnGeneral.setParroquia(parroquia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parroquiaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParroquiaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parroquias,parroquia,parroquiaParameterGeneral,parroquiaReturnGeneral,isEsNuevoParroquia,clases);
			
			this.connexion.commit();
			
			return parroquiaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParroquiaParameterReturnGeneral procesarImportacionParroquiasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParroquiaParameterReturnGeneral parroquiaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-procesarImportacionParroquiasWithConnection");connexion.begin();			
			
			ParroquiaParameterReturnGeneral parroquiaReturnGeneral=new ParroquiaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parroquias=new ArrayList<Parroquia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parroquia=new Parroquia();
				
				
				if(conColumnasBase) {this.parroquia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parroquia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parroquia.setcodigo(arrColumnas[iColumn++]);
			this.parroquia.setnombre(arrColumnas[iColumn++]);
				this.parroquia.setes_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parroquias.add(this.parroquia);
			}
			
			this.saveParroquias();
			
			this.connexion.commit();
			
			parroquiaReturnGeneral.setConRetornoEstaProcesado(true);
			parroquiaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parroquiaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParroquiasEliminados() throws Exception {				
		
		List<Parroquia> parroquiasAux= new ArrayList<Parroquia>();
		
		for(Parroquia parroquia:parroquias) {
			if(!parroquia.getIsDeleted()) {
				parroquiasAux.add(parroquia);
			}
		}
		
		parroquias=parroquiasAux;
	}
	
	public void quitarParroquiasNulos() throws Exception {				
		
		List<Parroquia> parroquiasAux= new ArrayList<Parroquia>();
		
		for(Parroquia parroquia : this.parroquias) {
			if(parroquia==null) {
				parroquiasAux.add(parroquia);
			}
		}
		
		//this.parroquias=parroquiasAux;
		
		this.parroquias.removeAll(parroquiasAux);
	}
	
	public void getSetVersionRowParroquiaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parroquia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parroquia.getIsDeleted() || (parroquia.getIsChanged()&&!parroquia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parroquiaDataAccess.getSetVersionRowParroquia(connexion,parroquia.getId());
				
				if(!parroquia.getVersionRow().equals(timestamp)) {	
					parroquia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parroquia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParroquia()throws Exception {	
		
		if(parroquia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parroquia.getIsDeleted() || (parroquia.getIsChanged()&&!parroquia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parroquiaDataAccess.getSetVersionRowParroquia(connexion,parroquia.getId());
			
			try {							
				if(!parroquia.getVersionRow().equals(timestamp)) {	
					parroquia.setVersionRow(timestamp);
				}
				
				parroquia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParroquiasWithConnection()throws Exception {	
		if(parroquias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Parroquia parroquiaAux:parroquias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parroquiaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parroquiaAux.getIsDeleted() || (parroquiaAux.getIsChanged()&&!parroquiaAux.getIsNew())) {
						
						timestamp=parroquiaDataAccess.getSetVersionRowParroquia(connexion,parroquiaAux.getId());
						
						if(!parroquia.getVersionRow().equals(timestamp)) {	
							parroquiaAux.setVersionRow(timestamp);
						}
								
						parroquiaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParroquias()throws Exception {	
		if(parroquias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Parroquia parroquiaAux:parroquias) {
					if(parroquiaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parroquiaAux.getIsDeleted() || (parroquiaAux.getIsChanged()&&!parroquiaAux.getIsNew())) {
						
						timestamp=parroquiaDataAccess.getSetVersionRowParroquia(connexion,parroquiaAux.getId());
						
						if(!parroquiaAux.getVersionRow().equals(timestamp)) {	
							parroquiaAux.setVersionRow(timestamp);
						}
						
													
						parroquiaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParroquiaParameterReturnGeneral cargarCombosLoteForeignKeyParroquiaWithConnection(String finalQueryGlobalCanton) throws Exception {
		ParroquiaParameterReturnGeneral  parroquiaReturnGeneral =new ParroquiaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-cargarCombosLoteForeignKeyParroquiaWithConnection");connexion.begin();
			
			parroquiaReturnGeneral =new ParroquiaParameterReturnGeneral();
			
			

			List<Canton> cantonsForeignKey=new ArrayList<Canton>();
			CantonLogic cantonLogic=new CantonLogic();
			cantonLogic.setConnexion(this.connexion);
			cantonLogic.getCantonDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCanton.equals("NONE")) {
				cantonLogic.getTodosCantons(finalQueryGlobalCanton,new Pagination());
				cantonsForeignKey=cantonLogic.getCantons();
			}

			parroquiaReturnGeneral.setcantonsForeignKey(cantonsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parroquiaReturnGeneral;
	}
	
	public ParroquiaParameterReturnGeneral cargarCombosLoteForeignKeyParroquia(String finalQueryGlobalCanton) throws Exception {
		ParroquiaParameterReturnGeneral  parroquiaReturnGeneral =new ParroquiaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parroquiaReturnGeneral =new ParroquiaParameterReturnGeneral();
			
			

			List<Canton> cantonsForeignKey=new ArrayList<Canton>();
			CantonLogic cantonLogic=new CantonLogic();
			cantonLogic.setConnexion(this.connexion);
			cantonLogic.getCantonDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCanton.equals("NONE")) {
				cantonLogic.getTodosCantons(finalQueryGlobalCanton,new Pagination());
				cantonsForeignKey=cantonLogic.getCantons();
			}

			parroquiaReturnGeneral.setcantonsForeignKey(cantonsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parroquiaReturnGeneral;
	}
	
	
	public void deepLoad(Parroquia parroquia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParroquiaLogicAdditional.updateParroquiaToGet(parroquia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parroquia.setCanton(parroquiaDataAccess.getCanton(connexion,parroquia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				parroquia.setCanton(parroquiaDataAccess.getCanton(connexion,parroquia));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parroquia.setCanton(parroquiaDataAccess.getCanton(connexion,parroquia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parroquia.setCanton(parroquiaDataAccess.getCanton(connexion,parroquia));
		CantonLogic cantonLogic= new CantonLogic(connexion);
		cantonLogic.deepLoad(parroquia.getCanton(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				parroquia.setCanton(parroquiaDataAccess.getCanton(connexion,parroquia));
				CantonLogic cantonLogic= new CantonLogic(connexion);
				cantonLogic.deepLoad(parroquia.getCanton(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parroquia.setCanton(parroquiaDataAccess.getCanton(connexion,parroquia));
			CantonLogic cantonLogic= new CantonLogic(connexion);
			cantonLogic.deepLoad(parroquia.getCanton(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Parroquia parroquia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParroquiaLogicAdditional.updateParroquiaToSave(parroquia,this.arrDatoGeneral);
			
ParroquiaDataAccess.save(parroquia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CantonDataAccess.save(parroquia.getCanton(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				CantonDataAccess.save(parroquia.getCanton(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CantonDataAccess.save(parroquia.getCanton(),connexion);
		CantonLogic cantonLogic= new CantonLogic(connexion);
		cantonLogic.deepLoad(parroquia.getCanton(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				CantonDataAccess.save(parroquia.getCanton(),connexion);
				CantonLogic cantonLogic= new CantonLogic(connexion);
				cantonLogic.deepSave(parroquia.getCanton(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Parroquia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parroquia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(parroquia);
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
			this.deepLoad(this.parroquia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Parroquia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parroquias!=null) {
				for(Parroquia parroquia:parroquias) {
					this.deepLoad(parroquia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(parroquias);
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
			if(parroquias!=null) {
				for(Parroquia parroquia:parroquias) {
					this.deepLoad(parroquia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(parroquias);
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
			this.getNewConnexionToDeep(Parroquia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parroquia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Parroquia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parroquias!=null) {
				for(Parroquia parroquia:parroquias) {
					this.deepSave(parroquia,isDeep,deepLoadType,clases);
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
			if(parroquias!=null) {
				for(Parroquia parroquia:parroquias) {
					this.deepSave(parroquia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParroquiasFK_IdCantonWithConnection(String sFinalQuery,Pagination pagination,Long id_canton)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Parroquia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCanton= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCanton.setParameterSelectionGeneralEqual(ParameterType.LONG,id_canton,ParroquiaConstantesFunciones.IDCANTON,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCanton);

			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCanton","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parroquias=parroquiaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParroquiasFK_IdCanton(String sFinalQuery,Pagination pagination,Long id_canton)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCanton= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCanton.setParameterSelectionGeneralEqual(ParameterType.LONG,id_canton,ParroquiaConstantesFunciones.IDCANTON,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCanton);

			ParroquiaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCanton","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parroquias=parroquiaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(this.parroquias);
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
			if(ParroquiaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParroquiaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Parroquia parroquia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParroquiaConstantesFunciones.ISCONAUDITORIA) {
				if(parroquia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParroquiaDataAccess.TABLENAME, parroquia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParroquiaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParroquiaLogic.registrarAuditoriaDetallesParroquia(connexion,parroquia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parroquia.getIsDeleted()) {
					/*if(!parroquia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParroquiaDataAccess.TABLENAME, parroquia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParroquiaLogic.registrarAuditoriaDetallesParroquia(connexion,parroquia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParroquiaDataAccess.TABLENAME, parroquia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parroquia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParroquiaDataAccess.TABLENAME, parroquia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParroquiaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParroquiaLogic.registrarAuditoriaDetallesParroquia(connexion,parroquia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParroquia(Connexion connexion,Parroquia parroquia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parroquia.getIsNew()||!parroquia.getid_canton().equals(parroquia.getParroquiaOriginal().getid_canton()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parroquia.getParroquiaOriginal().getid_canton()!=null)
				{
					strValorActual=parroquia.getParroquiaOriginal().getid_canton().toString();
				}
				if(parroquia.getid_canton()!=null)
				{
					strValorNuevo=parroquia.getid_canton().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParroquiaConstantesFunciones.IDCANTON,strValorActual,strValorNuevo);
			}	
			
			if(parroquia.getIsNew()||!parroquia.getcodigo().equals(parroquia.getParroquiaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parroquia.getParroquiaOriginal().getcodigo()!=null)
				{
					strValorActual=parroquia.getParroquiaOriginal().getcodigo();
				}
				if(parroquia.getcodigo()!=null)
				{
					strValorNuevo=parroquia.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParroquiaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(parroquia.getIsNew()||!parroquia.getnombre().equals(parroquia.getParroquiaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parroquia.getParroquiaOriginal().getnombre()!=null)
				{
					strValorActual=parroquia.getParroquiaOriginal().getnombre();
				}
				if(parroquia.getnombre()!=null)
				{
					strValorNuevo=parroquia.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParroquiaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(parroquia.getIsNew()||!parroquia.getes_activo().equals(parroquia.getParroquiaOriginal().getes_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parroquia.getParroquiaOriginal().getes_activo()!=null)
				{
					strValorActual=parroquia.getParroquiaOriginal().getes_activo().toString();
				}
				if(parroquia.getes_activo()!=null)
				{
					strValorNuevo=parroquia.getes_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParroquiaConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParroquiaRelacionesWithConnection(Parroquia parroquia) throws Exception {

		if(!parroquia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParroquiaRelacionesBase(parroquia,true);
		}
	}

	public void saveParroquiaRelaciones(Parroquia parroquia)throws Exception {

		if(!parroquia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParroquiaRelacionesBase(parroquia,false);
		}
	}

	public void saveParroquiaRelacionesBase(Parroquia parroquia,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Parroquia-saveRelacionesWithConnection");}
	

			this.setParroquia(parroquia);

			if(ParroquiaLogicAdditional.validarSaveRelaciones(parroquia,this)) {

				ParroquiaLogicAdditional.updateRelacionesToSave(parroquia,this);

				if((parroquia.getIsNew()||parroquia.getIsChanged())&&!parroquia.getIsDeleted()) {
					this.saveParroquia();
					this.saveParroquiaRelacionesDetalles();

				} else if(parroquia.getIsDeleted()) {
					this.saveParroquiaRelacionesDetalles();
					this.saveParroquia();
				}

				ParroquiaLogicAdditional.updateRelacionesToSaveAfter(parroquia,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveParroquiaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParroquia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParroquiaConstantesFunciones.getClassesForeignKeysOfParroquia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParroquia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParroquiaConstantesFunciones.getClassesRelationshipsOfParroquia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

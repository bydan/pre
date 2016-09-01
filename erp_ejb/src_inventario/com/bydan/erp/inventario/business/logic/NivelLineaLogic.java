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
import com.bydan.erp.inventario.util.NivelLineaConstantesFunciones;
import com.bydan.erp.inventario.util.NivelLineaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.NivelLineaParameterGeneral;
import com.bydan.erp.inventario.business.entity.NivelLinea;
import com.bydan.erp.inventario.business.logic.NivelLineaLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class NivelLineaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NivelLineaLogic.class);
	
	protected NivelLineaDataAccess nivellineaDataAccess; 	
	protected NivelLinea nivellinea;
	protected List<NivelLinea> nivellineas;
	protected Object nivellineaObject;	
	protected List<Object> nivellineasObject;
	
	public static ClassValidator<NivelLinea> nivellineaValidator = new ClassValidator<NivelLinea>(NivelLinea.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NivelLineaLogicAdditional nivellineaLogicAdditional=null;
	
	public NivelLineaLogicAdditional getNivelLineaLogicAdditional() {
		return this.nivellineaLogicAdditional;
	}
	
	public void setNivelLineaLogicAdditional(NivelLineaLogicAdditional nivellineaLogicAdditional) {
		try {
			this.nivellineaLogicAdditional=nivellineaLogicAdditional;
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
	
	
	
	
	public  NivelLineaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.nivellineaDataAccess = new NivelLineaDataAccess();
			
			this.nivellineas= new ArrayList<NivelLinea>();
			this.nivellinea= new NivelLinea();
			
			this.nivellineaObject=new Object();
			this.nivellineasObject=new ArrayList<Object>();
				
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
			
			this.nivellineaDataAccess.setConnexionType(this.connexionType);
			this.nivellineaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NivelLineaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.nivellineaDataAccess = new NivelLineaDataAccess();
			this.nivellineas= new ArrayList<NivelLinea>();
			this.nivellinea= new NivelLinea();
			this.nivellineaObject=new Object();
			this.nivellineasObject=new ArrayList<Object>();
			
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
			
			this.nivellineaDataAccess.setConnexionType(this.connexionType);
			this.nivellineaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NivelLinea getNivelLinea() throws Exception {	
		NivelLineaLogicAdditional.checkNivelLineaToGet(nivellinea,this.datosCliente,this.arrDatoGeneral);
		NivelLineaLogicAdditional.updateNivelLineaToGet(nivellinea,this.arrDatoGeneral);
		
		return nivellinea;
	}
		
	public void setNivelLinea(NivelLinea newNivelLinea) {
		this.nivellinea = newNivelLinea;
	}
	
	public NivelLineaDataAccess getNivelLineaDataAccess() {
		return nivellineaDataAccess;
	}
	
	public void setNivelLineaDataAccess(NivelLineaDataAccess newnivellineaDataAccess) {
		this.nivellineaDataAccess = newnivellineaDataAccess;
	}
	
	public List<NivelLinea> getNivelLineas() throws Exception {		
		this.quitarNivelLineasNulos();
		
		NivelLineaLogicAdditional.checkNivelLineaToGets(nivellineas,this.datosCliente,this.arrDatoGeneral);
		
		for (NivelLinea nivellineaLocal: nivellineas ) {
			NivelLineaLogicAdditional.updateNivelLineaToGet(nivellineaLocal,this.arrDatoGeneral);
		}
		
		return nivellineas;
	}
	
	public void setNivelLineas(List<NivelLinea> newNivelLineas) {
		this.nivellineas = newNivelLineas;
	}
	
	public Object getNivelLineaObject() {	
		this.nivellineaObject=this.nivellineaDataAccess.getEntityObject();
		return this.nivellineaObject;
	}
		
	public void setNivelLineaObject(Object newNivelLineaObject) {
		this.nivellineaObject = newNivelLineaObject;
	}
	
	public List<Object> getNivelLineasObject() {		
		this.nivellineasObject=this.nivellineaDataAccess.getEntitiesObject();
		return this.nivellineasObject;
	}
		
	public void setNivelLineasObject(List<Object> newNivelLineasObject) {
		this.nivellineasObject = newNivelLineasObject;
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
		
		if(this.nivellineaDataAccess!=null) {
			this.nivellineaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			nivellineaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			nivellineaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		nivellinea = new  NivelLinea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			nivellinea=nivellineaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivellinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellinea);
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
		nivellinea = new  NivelLinea();
		  		  
        try {
			
			nivellinea=nivellineaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivellinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		nivellinea = new  NivelLinea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			nivellinea=nivellineaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivellinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellinea);
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
		nivellinea = new  NivelLinea();
		  		  
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
		nivellinea = new  NivelLinea();
		  		  
        try {
			
			nivellinea=nivellineaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivellinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		nivellinea = new  NivelLinea();
		  		  
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
		nivellinea = new  NivelLinea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =nivellineaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivellinea = new  NivelLinea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=nivellineaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		nivellinea = new  NivelLinea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =nivellineaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivellinea = new  NivelLinea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=nivellineaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		nivellinea = new  NivelLinea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =nivellineaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivellinea = new  NivelLinea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=nivellineaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		nivellineas = new  ArrayList<NivelLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
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
		nivellineas = new  ArrayList<NivelLinea>();
		  		  
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
		nivellineas = new  ArrayList<NivelLinea>();
		  		  
        try {			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		nivellineas = new  ArrayList<NivelLinea>();
		  		  
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
		nivellineas = new  ArrayList<NivelLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
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
		nivellineas = new  ArrayList<NivelLinea>();
		  		  
        try {
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
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
		nivellineas = new  ArrayList<NivelLinea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
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
		nivellineas = new  ArrayList<NivelLinea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		nivellinea = new  NivelLinea();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellinea=nivellineaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelLinea(nivellinea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellinea);
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
		nivellinea = new  NivelLinea();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellinea=nivellineaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelLinea(nivellinea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		nivellineas = new  ArrayList<NivelLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
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
		nivellineas = new  ArrayList<NivelLinea>();
		  		  
        try {
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNivelLineasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		nivellineas = new  ArrayList<NivelLinea>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getTodosNivelLineasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
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
	
	public  void  getTodosNivelLineas(String sFinalQuery,Pagination pagination)throws Exception {
		nivellineas = new  ArrayList<NivelLinea>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivellineas=nivellineaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNivelLinea(nivellineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellineas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNivelLinea(NivelLinea nivellinea) throws Exception {
		Boolean estaValidado=false;
		
		if(nivellinea.getIsNew() || nivellinea.getIsChanged()) { 
			this.invalidValues = nivellineaValidator.getInvalidValues(nivellinea);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(nivellinea);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNivelLinea(List<NivelLinea> NivelLineas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NivelLinea nivellineaLocal:nivellineas) {				
			estaValidadoObjeto=this.validarGuardarNivelLinea(nivellineaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNivelLinea(List<NivelLinea> NivelLineas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNivelLinea(nivellineas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNivelLinea(NivelLinea NivelLinea) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNivelLinea(nivellinea)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NivelLinea nivellinea) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+nivellinea.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NivelLineaConstantesFunciones.getNivelLineaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"nivellinea","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NivelLineaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NivelLineaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNivelLineaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-saveNivelLineaWithConnection");connexion.begin();			
			
			NivelLineaLogicAdditional.checkNivelLineaToSave(this.nivellinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NivelLineaLogicAdditional.updateNivelLineaToSave(this.nivellinea,this.arrDatoGeneral);
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.nivellinea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNivelLinea();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNivelLinea(this.nivellinea)) {
				NivelLineaDataAccess.save(this.nivellinea, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.nivellinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NivelLineaLogicAdditional.checkNivelLineaToSaveAfter(this.nivellinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNivelLinea();
			
			connexion.commit();			
			
			if(this.nivellinea.getIsDeleted()) {
				this.nivellinea=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNivelLinea()throws Exception {	
		try {	
			
			NivelLineaLogicAdditional.checkNivelLineaToSave(this.nivellinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NivelLineaLogicAdditional.updateNivelLineaToSave(this.nivellinea,this.arrDatoGeneral);
			
			NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.nivellinea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNivelLinea(this.nivellinea)) {			
				NivelLineaDataAccess.save(this.nivellinea, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.nivellinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NivelLineaLogicAdditional.checkNivelLineaToSaveAfter(this.nivellinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.nivellinea.getIsDeleted()) {
				this.nivellinea=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNivelLineasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-saveNivelLineasWithConnection");connexion.begin();			
			
			NivelLineaLogicAdditional.checkNivelLineaToSaves(nivellineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNivelLineas();
			
			Boolean validadoTodosNivelLinea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NivelLinea nivellineaLocal:nivellineas) {		
				if(nivellineaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NivelLineaLogicAdditional.updateNivelLineaToSave(nivellineaLocal,this.arrDatoGeneral);
	        	
				NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),nivellineaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNivelLinea(nivellineaLocal)) {
					NivelLineaDataAccess.save(nivellineaLocal, connexion);				
				} else {
					validadoTodosNivelLinea=false;
				}
			}
			
			if(!validadoTodosNivelLinea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NivelLineaLogicAdditional.checkNivelLineaToSavesAfter(nivellineas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNivelLineas();
			
			connexion.commit();		
			
			this.quitarNivelLineasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNivelLineas()throws Exception {				
		 try {	
			NivelLineaLogicAdditional.checkNivelLineaToSaves(nivellineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNivelLinea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NivelLinea nivellineaLocal:nivellineas) {				
				if(nivellineaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NivelLineaLogicAdditional.updateNivelLineaToSave(nivellineaLocal,this.arrDatoGeneral);
	        	
				NivelLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),nivellineaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNivelLinea(nivellineaLocal)) {				
					NivelLineaDataAccess.save(nivellineaLocal, connexion);				
				} else {
					validadoTodosNivelLinea=false;
				}
			}
			
			if(!validadoTodosNivelLinea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NivelLineaLogicAdditional.checkNivelLineaToSavesAfter(nivellineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNivelLineasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NivelLineaParameterReturnGeneral procesarAccionNivelLineas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NivelLinea> nivellineas,NivelLineaParameterReturnGeneral nivellineaParameterGeneral)throws Exception {
		 try {	
			NivelLineaParameterReturnGeneral nivellineaReturnGeneral=new NivelLineaParameterReturnGeneral();
	
			NivelLineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,nivellineas,nivellineaParameterGeneral,nivellineaReturnGeneral);
			
			return nivellineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NivelLineaParameterReturnGeneral procesarAccionNivelLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NivelLinea> nivellineas,NivelLineaParameterReturnGeneral nivellineaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-procesarAccionNivelLineasWithConnection");connexion.begin();			
			
			NivelLineaParameterReturnGeneral nivellineaReturnGeneral=new NivelLineaParameterReturnGeneral();
	
			NivelLineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,nivellineas,nivellineaParameterGeneral,nivellineaReturnGeneral);
			
			this.connexion.commit();
			
			return nivellineaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NivelLineaParameterReturnGeneral procesarEventosNivelLineas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NivelLinea> nivellineas,NivelLinea nivellinea,NivelLineaParameterReturnGeneral nivellineaParameterGeneral,Boolean isEsNuevoNivelLinea,ArrayList<Classe> clases)throws Exception {
		 try {	
			NivelLineaParameterReturnGeneral nivellineaReturnGeneral=new NivelLineaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				nivellineaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NivelLineaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,nivellineas,nivellinea,nivellineaParameterGeneral,nivellineaReturnGeneral,isEsNuevoNivelLinea,clases);
			
			return nivellineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NivelLineaParameterReturnGeneral procesarEventosNivelLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NivelLinea> nivellineas,NivelLinea nivellinea,NivelLineaParameterReturnGeneral nivellineaParameterGeneral,Boolean isEsNuevoNivelLinea,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-procesarEventosNivelLineasWithConnection");connexion.begin();			
			
			NivelLineaParameterReturnGeneral nivellineaReturnGeneral=new NivelLineaParameterReturnGeneral();
	
			nivellineaReturnGeneral.setNivelLinea(nivellinea);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				nivellineaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NivelLineaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,nivellineas,nivellinea,nivellineaParameterGeneral,nivellineaReturnGeneral,isEsNuevoNivelLinea,clases);
			
			this.connexion.commit();
			
			return nivellineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NivelLineaParameterReturnGeneral procesarImportacionNivelLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NivelLineaParameterReturnGeneral nivellineaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-procesarImportacionNivelLineasWithConnection");connexion.begin();			
			
			NivelLineaParameterReturnGeneral nivellineaReturnGeneral=new NivelLineaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.nivellineas=new ArrayList<NivelLinea>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.nivellinea=new NivelLinea();
				
				
				if(conColumnasBase) {this.nivellinea.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.nivellinea.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.nivellinea.setnombre(arrColumnas[iColumn++]);
				
				this.nivellineas.add(this.nivellinea);
			}
			
			this.saveNivelLineas();
			
			this.connexion.commit();
			
			nivellineaReturnGeneral.setConRetornoEstaProcesado(true);
			nivellineaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return nivellineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNivelLineasEliminados() throws Exception {				
		
		List<NivelLinea> nivellineasAux= new ArrayList<NivelLinea>();
		
		for(NivelLinea nivellinea:nivellineas) {
			if(!nivellinea.getIsDeleted()) {
				nivellineasAux.add(nivellinea);
			}
		}
		
		nivellineas=nivellineasAux;
	}
	
	public void quitarNivelLineasNulos() throws Exception {				
		
		List<NivelLinea> nivellineasAux= new ArrayList<NivelLinea>();
		
		for(NivelLinea nivellinea : this.nivellineas) {
			if(nivellinea==null) {
				nivellineasAux.add(nivellinea);
			}
		}
		
		//this.nivellineas=nivellineasAux;
		
		this.nivellineas.removeAll(nivellineasAux);
	}
	
	public void getSetVersionRowNivelLineaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(nivellinea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((nivellinea.getIsDeleted() || (nivellinea.getIsChanged()&&!nivellinea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=nivellineaDataAccess.getSetVersionRowNivelLinea(connexion,nivellinea.getId());
				
				if(!nivellinea.getVersionRow().equals(timestamp)) {	
					nivellinea.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				nivellinea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNivelLinea()throws Exception {	
		
		if(nivellinea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((nivellinea.getIsDeleted() || (nivellinea.getIsChanged()&&!nivellinea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=nivellineaDataAccess.getSetVersionRowNivelLinea(connexion,nivellinea.getId());
			
			try {							
				if(!nivellinea.getVersionRow().equals(timestamp)) {	
					nivellinea.setVersionRow(timestamp);
				}
				
				nivellinea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNivelLineasWithConnection()throws Exception {	
		if(nivellineas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NivelLinea nivellineaAux:nivellineas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(nivellineaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(nivellineaAux.getIsDeleted() || (nivellineaAux.getIsChanged()&&!nivellineaAux.getIsNew())) {
						
						timestamp=nivellineaDataAccess.getSetVersionRowNivelLinea(connexion,nivellineaAux.getId());
						
						if(!nivellinea.getVersionRow().equals(timestamp)) {	
							nivellineaAux.setVersionRow(timestamp);
						}
								
						nivellineaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNivelLineas()throws Exception {	
		if(nivellineas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NivelLinea nivellineaAux:nivellineas) {
					if(nivellineaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(nivellineaAux.getIsDeleted() || (nivellineaAux.getIsChanged()&&!nivellineaAux.getIsNew())) {
						
						timestamp=nivellineaDataAccess.getSetVersionRowNivelLinea(connexion,nivellineaAux.getId());
						
						if(!nivellineaAux.getVersionRow().equals(timestamp)) {	
							nivellineaAux.setVersionRow(timestamp);
						}
						
													
						nivellineaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyNivelLineaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			LineaLogic lineaLogic=new LineaLogic();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyNivelLineaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Linea.class));
			classes.add(new Classe(ComisionConfig.class));
											
			

			lineaLogic.setConnexion(this.getConnexion());
			lineaLogic.setDatosCliente(this.datosCliente);
			lineaLogic.setIsConRefrescarForeignKeys(true);

			comisionconfigLogic.setConnexion(this.getConnexion());
			comisionconfigLogic.setDatosCliente(this.datosCliente);
			comisionconfigLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(NivelLinea nivellinea:this.nivellineas) {
				

				classes=new ArrayList<Classe>();
				classes=LineaConstantesFunciones.getClassesForeignKeysOfLinea(new ArrayList<Classe>(),DeepLoadType.NONE);

				lineaLogic.setLineas(nivellinea.lineas);
				lineaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionConfigConstantesFunciones.getClassesForeignKeysOfComisionConfig(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionconfigLogic.setComisionConfigs(nivellinea.comisionconfigs);
				comisionconfigLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(NivelLinea nivellinea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NivelLineaLogicAdditional.updateNivelLineaToGet(nivellinea,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		nivellinea.setLineas(nivellineaDataAccess.getLineas(connexion,nivellinea));
		nivellinea.setComisionConfigs(nivellineaDataAccess.getComisionConfigs(connexion,nivellinea));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				nivellinea.setLineas(nivellineaDataAccess.getLineas(connexion,nivellinea));

				if(this.isConDeep) {
					LineaLogic lineaLogic= new LineaLogic(this.connexion);
					lineaLogic.setLineas(nivellinea.getLineas());
					ArrayList<Classe> classesLocal=LineaConstantesFunciones.getClassesForeignKeysOfLinea(new ArrayList<Classe>(),DeepLoadType.NONE);
					lineaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					LineaConstantesFunciones.refrescarForeignKeysDescripcionesLinea(lineaLogic.getLineas());
					nivellinea.setLineas(lineaLogic.getLineas());
				}

				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				nivellinea.setComisionConfigs(nivellineaDataAccess.getComisionConfigs(connexion,nivellinea));

				if(this.isConDeep) {
					ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(this.connexion);
					comisionconfigLogic.setComisionConfigs(nivellinea.getComisionConfigs());
					ArrayList<Classe> classesLocal=ComisionConfigConstantesFunciones.getClassesForeignKeysOfComisionConfig(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionconfigLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(comisionconfigLogic.getComisionConfigs());
					nivellinea.setComisionConfigs(comisionconfigLogic.getComisionConfigs());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Linea.class));
			nivellinea.setLineas(nivellineaDataAccess.getLineas(connexion,nivellinea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionConfig.class));
			nivellinea.setComisionConfigs(nivellineaDataAccess.getComisionConfigs(connexion,nivellinea));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		nivellinea.setLineas(nivellineaDataAccess.getLineas(connexion,nivellinea));

		for(Linea linea:nivellinea.getLineas()) {
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(linea,isDeep,deepLoadType,clases);
		}

		nivellinea.setComisionConfigs(nivellineaDataAccess.getComisionConfigs(connexion,nivellinea));

		for(ComisionConfig comisionconfig:nivellinea.getComisionConfigs()) {
			ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
			comisionconfigLogic.deepLoad(comisionconfig,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				nivellinea.setLineas(nivellineaDataAccess.getLineas(connexion,nivellinea));

				for(Linea linea:nivellinea.getLineas()) {
					LineaLogic lineaLogic= new LineaLogic(connexion);
					lineaLogic.deepLoad(linea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				nivellinea.setComisionConfigs(nivellineaDataAccess.getComisionConfigs(connexion,nivellinea));

				for(ComisionConfig comisionconfig:nivellinea.getComisionConfigs()) {
					ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
					comisionconfigLogic.deepLoad(comisionconfig,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Linea.class));
			nivellinea.setLineas(nivellineaDataAccess.getLineas(connexion,nivellinea));

			for(Linea linea:nivellinea.getLineas()) {
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(linea,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionConfig.class));
			nivellinea.setComisionConfigs(nivellineaDataAccess.getComisionConfigs(connexion,nivellinea));

			for(ComisionConfig comisionconfig:nivellinea.getComisionConfigs()) {
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepLoad(comisionconfig,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NivelLinea nivellinea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NivelLineaLogicAdditional.updateNivelLineaToSave(nivellinea,this.arrDatoGeneral);
			
NivelLineaDataAccess.save(nivellinea, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Linea linea:nivellinea.getLineas()) {
			linea.setid_nivel_linea(nivellinea.getId());
			LineaDataAccess.save(linea,connexion);
		}

		for(ComisionConfig comisionconfig:nivellinea.getComisionConfigs()) {
			comisionconfig.setid_nivel_linea(nivellinea.getId());
			ComisionConfigDataAccess.save(comisionconfig,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Linea linea:nivellinea.getLineas()) {
					linea.setid_nivel_linea(nivellinea.getId());
					LineaDataAccess.save(linea,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionConfig comisionconfig:nivellinea.getComisionConfigs()) {
					comisionconfig.setid_nivel_linea(nivellinea.getId());
					ComisionConfigDataAccess.save(comisionconfig,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Linea linea:nivellinea.getLineas()) {
			LineaLogic lineaLogic= new LineaLogic(connexion);
			linea.setid_nivel_linea(nivellinea.getId());
			LineaDataAccess.save(linea,connexion);
			lineaLogic.deepSave(linea,isDeep,deepLoadType,clases);
		}

		for(ComisionConfig comisionconfig:nivellinea.getComisionConfigs()) {
			ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
			comisionconfig.setid_nivel_linea(nivellinea.getId());
			ComisionConfigDataAccess.save(comisionconfig,connexion);
			comisionconfigLogic.deepSave(comisionconfig,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Linea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Linea linea:nivellinea.getLineas()) {
					LineaLogic lineaLogic= new LineaLogic(connexion);
					linea.setid_nivel_linea(nivellinea.getId());
					LineaDataAccess.save(linea,connexion);
					lineaLogic.deepSave(linea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionConfig comisionconfig:nivellinea.getComisionConfigs()) {
					ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
					comisionconfig.setid_nivel_linea(nivellinea.getId());
					ComisionConfigDataAccess.save(comisionconfig,connexion);
					comisionconfigLogic.deepSave(comisionconfig,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(NivelLinea.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(nivellinea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(nivellinea);
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
			this.deepLoad(this.nivellinea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NivelLinea.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(nivellineas!=null) {
				for(NivelLinea nivellinea:nivellineas) {
					this.deepLoad(nivellinea,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(nivellineas);
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
			if(nivellineas!=null) {
				for(NivelLinea nivellinea:nivellineas) {
					this.deepLoad(nivellinea,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(nivellineas);
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
			this.getNewConnexionToDeep(NivelLinea.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(nivellinea,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NivelLinea.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(nivellineas!=null) {
				for(NivelLinea nivellinea:nivellineas) {
					this.deepSave(nivellinea,isDeep,deepLoadType,clases);
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
			if(nivellineas!=null) {
				for(NivelLinea nivellinea:nivellineas) {
					this.deepSave(nivellinea,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNivelLineaPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelLinea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,NivelLineaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			nivellinea=nivellineaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.nivellinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellinea);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNivelLineaPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,NivelLineaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			nivellinea=nivellineaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.nivellinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				NivelLineaConstantesFunciones.refrescarForeignKeysDescripcionesNivelLinea(this.nivellinea);
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
			if(NivelLineaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelLineaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NivelLinea nivellinea,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NivelLineaConstantesFunciones.ISCONAUDITORIA) {
				if(nivellinea.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelLineaDataAccess.TABLENAME, nivellinea.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NivelLineaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NivelLineaLogic.registrarAuditoriaDetallesNivelLinea(connexion,nivellinea,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(nivellinea.getIsDeleted()) {
					/*if(!nivellinea.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NivelLineaDataAccess.TABLENAME, nivellinea.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NivelLineaLogic.registrarAuditoriaDetallesNivelLinea(connexion,nivellinea,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelLineaDataAccess.TABLENAME, nivellinea.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(nivellinea.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelLineaDataAccess.TABLENAME, nivellinea.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NivelLineaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NivelLineaLogic.registrarAuditoriaDetallesNivelLinea(connexion,nivellinea,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNivelLinea(Connexion connexion,NivelLinea nivellinea)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(nivellinea.getIsNew()||!nivellinea.getnombre().equals(nivellinea.getNivelLineaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(nivellinea.getNivelLineaOriginal().getnombre()!=null)
				{
					strValorActual=nivellinea.getNivelLineaOriginal().getnombre();
				}
				if(nivellinea.getnombre()!=null)
				{
					strValorNuevo=nivellinea.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NivelLineaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNivelLineaRelacionesWithConnection(NivelLinea nivellinea,List<Linea> lineas,List<ComisionConfig> comisionconfigs) throws Exception {

		if(!nivellinea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNivelLineaRelacionesBase(nivellinea,lineas,comisionconfigs,true);
		}
	}

	public void saveNivelLineaRelaciones(NivelLinea nivellinea,List<Linea> lineas,List<ComisionConfig> comisionconfigs)throws Exception {

		if(!nivellinea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNivelLineaRelacionesBase(nivellinea,lineas,comisionconfigs,false);
		}
	}

	public void saveNivelLineaRelacionesBase(NivelLinea nivellinea,List<Linea> lineas,List<ComisionConfig> comisionconfigs,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NivelLinea-saveRelacionesWithConnection");}
	
			nivellinea.setLineas(lineas);
			nivellinea.setComisionConfigs(comisionconfigs);

			this.setNivelLinea(nivellinea);

				if((nivellinea.getIsNew()||nivellinea.getIsChanged())&&!nivellinea.getIsDeleted()) {
					this.saveNivelLinea();
					this.saveNivelLineaRelacionesDetalles(lineas,comisionconfigs);

				} else if(nivellinea.getIsDeleted()) {
					this.saveNivelLineaRelacionesDetalles(lineas,comisionconfigs);
					this.saveNivelLinea();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			LineaConstantesFunciones.InicializarGeneralEntityAuxiliaresLineas(lineas,true,true);
			ComisionConfigConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionConfigs(comisionconfigs,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveNivelLineaRelacionesDetalles(List<Linea> lineas,List<ComisionConfig> comisionconfigs)throws Exception {
		try {
	

			Long idNivelLineaActual=this.getNivelLinea().getId();

			LineaLogic lineaLogic_Desde_NivelLinea=new LineaLogic();
			lineaLogic_Desde_NivelLinea.setLineas(lineas);

			lineaLogic_Desde_NivelLinea.setConnexion(this.getConnexion());
			lineaLogic_Desde_NivelLinea.setDatosCliente(this.datosCliente);

			for(Linea linea_Desde_NivelLinea:lineaLogic_Desde_NivelLinea.getLineas()) {
				linea_Desde_NivelLinea.setid_nivel_linea(idNivelLineaActual);

				lineaLogic_Desde_NivelLinea.setLinea(linea_Desde_NivelLinea);
				lineaLogic_Desde_NivelLinea.saveLinea();
			}


			ComisionConfigLogic comisionconfigLogic_Desde_NivelLinea=new ComisionConfigLogic();
			comisionconfigLogic_Desde_NivelLinea.setComisionConfigs(comisionconfigs);

			comisionconfigLogic_Desde_NivelLinea.setConnexion(this.getConnexion());
			comisionconfigLogic_Desde_NivelLinea.setDatosCliente(this.datosCliente);

			for(ComisionConfig comisionconfig_Desde_NivelLinea:comisionconfigLogic_Desde_NivelLinea.getComisionConfigs()) {
				comisionconfig_Desde_NivelLinea.setid_nivel_linea(idNivelLineaActual);

				comisionconfigLogic_Desde_NivelLinea.setComisionConfig(comisionconfig_Desde_NivelLinea);
				comisionconfigLogic_Desde_NivelLinea.saveComisionConfig();

				Long idComisionConfigActual=comisionconfig_Desde_NivelLinea.getId();

				ComisionCateLogic comisioncateLogic_Desde_ComisionConfig=new ComisionCateLogic();

				if(comisionconfig_Desde_NivelLinea.getComisionCates()==null){
					comisionconfig_Desde_NivelLinea.setComisionCates(new ArrayList<ComisionCate>());
				}

				comisioncateLogic_Desde_ComisionConfig.setComisionCates(comisionconfig_Desde_NivelLinea.getComisionCates());

				comisioncateLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
				comisioncateLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

				for(ComisionCate comisioncate_Desde_ComisionConfig:comisioncateLogic_Desde_ComisionConfig.getComisionCates()) {
					comisioncate_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
				}

				comisioncateLogic_Desde_ComisionConfig.saveComisionCates();

				ComisionMarcaLogic comisionmarcaLogic_Desde_ComisionConfig=new ComisionMarcaLogic();

				if(comisionconfig_Desde_NivelLinea.getComisionMarcas()==null){
					comisionconfig_Desde_NivelLinea.setComisionMarcas(new ArrayList<ComisionMarca>());
				}

				comisionmarcaLogic_Desde_ComisionConfig.setComisionMarcas(comisionconfig_Desde_NivelLinea.getComisionMarcas());

				comisionmarcaLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
				comisionmarcaLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

				for(ComisionMarca comisionmarca_Desde_ComisionConfig:comisionmarcaLogic_Desde_ComisionConfig.getComisionMarcas()) {
					comisionmarca_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
				}

				comisionmarcaLogic_Desde_ComisionConfig.saveComisionMarcas();

				ComisionLineaLogic comisionlineaLogic_Desde_ComisionConfig=new ComisionLineaLogic();

				if(comisionconfig_Desde_NivelLinea.getComisionLineas()==null){
					comisionconfig_Desde_NivelLinea.setComisionLineas(new ArrayList<ComisionLinea>());
				}

				comisionlineaLogic_Desde_ComisionConfig.setComisionLineas(comisionconfig_Desde_NivelLinea.getComisionLineas());

				comisionlineaLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
				comisionlineaLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

				for(ComisionLinea comisionlinea_Desde_ComisionConfig:comisionlineaLogic_Desde_ComisionConfig.getComisionLineas()) {
					comisionlinea_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
				}

				comisionlineaLogic_Desde_ComisionConfig.saveComisionLineas();

				ComisionPenaLogic comisionpenaLogic_Desde_ComisionConfig=new ComisionPenaLogic();

				if(comisionconfig_Desde_NivelLinea.getComisionPenas()==null){
					comisionconfig_Desde_NivelLinea.setComisionPenas(new ArrayList<ComisionPena>());
				}

				comisionpenaLogic_Desde_ComisionConfig.setComisionPenas(comisionconfig_Desde_NivelLinea.getComisionPenas());

				comisionpenaLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
				comisionpenaLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

				for(ComisionPena comisionpena_Desde_ComisionConfig:comisionpenaLogic_Desde_ComisionConfig.getComisionPenas()) {
					comisionpena_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
				}

				comisionpenaLogic_Desde_ComisionConfig.saveComisionPenas();

				ComisionGrupoLogic comisiongrupoLogic_Desde_ComisionConfig=new ComisionGrupoLogic();

				if(comisionconfig_Desde_NivelLinea.getComisionGrupos()==null){
					comisionconfig_Desde_NivelLinea.setComisionGrupos(new ArrayList<ComisionGrupo>());
				}

				comisiongrupoLogic_Desde_ComisionConfig.setComisionGrupos(comisionconfig_Desde_NivelLinea.getComisionGrupos());

				comisiongrupoLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
				comisiongrupoLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

				for(ComisionGrupo comisiongrupo_Desde_ComisionConfig:comisiongrupoLogic_Desde_ComisionConfig.getComisionGrupos()) {
					comisiongrupo_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
				}

				comisiongrupoLogic_Desde_ComisionConfig.saveComisionGrupos();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNivelLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NivelLineaConstantesFunciones.getClassesForeignKeysOfNivelLinea(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NivelLineaConstantesFunciones.getClassesRelationshipsOfNivelLinea(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

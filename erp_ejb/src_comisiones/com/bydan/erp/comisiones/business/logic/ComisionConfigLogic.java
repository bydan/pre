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
package com.bydan.erp.comisiones.business.logic;

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
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.comisiones.util.ComisionConfigConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionConfigParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionConfigParameterGeneral;
import com.bydan.erp.comisiones.business.entity.ComisionConfig;
import com.bydan.erp.comisiones.business.logic.ComisionConfigLogicAdditional;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.comisiones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ComisionConfigLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ComisionConfigLogic.class);
	
	protected ComisionConfigDataAccess comisionconfigDataAccess; 	
	protected ComisionConfig comisionconfig;
	protected List<ComisionConfig> comisionconfigs;
	protected Object comisionconfigObject;	
	protected List<Object> comisionconfigsObject;
	
	public static ClassValidator<ComisionConfig> comisionconfigValidator = new ClassValidator<ComisionConfig>(ComisionConfig.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ComisionConfigLogicAdditional comisionconfigLogicAdditional=null;
	
	public ComisionConfigLogicAdditional getComisionConfigLogicAdditional() {
		return this.comisionconfigLogicAdditional;
	}
	
	public void setComisionConfigLogicAdditional(ComisionConfigLogicAdditional comisionconfigLogicAdditional) {
		try {
			this.comisionconfigLogicAdditional=comisionconfigLogicAdditional;
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
	
	
	
	
	public  ComisionConfigLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.comisionconfigDataAccess = new ComisionConfigDataAccess();
			
			this.comisionconfigs= new ArrayList<ComisionConfig>();
			this.comisionconfig= new ComisionConfig();
			
			this.comisionconfigObject=new Object();
			this.comisionconfigsObject=new ArrayList<Object>();
				
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
			
			this.comisionconfigDataAccess.setConnexionType(this.connexionType);
			this.comisionconfigDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComisionConfigLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.comisionconfigDataAccess = new ComisionConfigDataAccess();
			this.comisionconfigs= new ArrayList<ComisionConfig>();
			this.comisionconfig= new ComisionConfig();
			this.comisionconfigObject=new Object();
			this.comisionconfigsObject=new ArrayList<Object>();
			
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
			
			this.comisionconfigDataAccess.setConnexionType(this.connexionType);
			this.comisionconfigDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComisionConfig getComisionConfig() throws Exception {	
		ComisionConfigLogicAdditional.checkComisionConfigToGet(comisionconfig,this.datosCliente,this.arrDatoGeneral);
		ComisionConfigLogicAdditional.updateComisionConfigToGet(comisionconfig,this.arrDatoGeneral);
		
		return comisionconfig;
	}
		
	public void setComisionConfig(ComisionConfig newComisionConfig) {
		this.comisionconfig = newComisionConfig;
	}
	
	public ComisionConfigDataAccess getComisionConfigDataAccess() {
		return comisionconfigDataAccess;
	}
	
	public void setComisionConfigDataAccess(ComisionConfigDataAccess newcomisionconfigDataAccess) {
		this.comisionconfigDataAccess = newcomisionconfigDataAccess;
	}
	
	public List<ComisionConfig> getComisionConfigs() throws Exception {		
		this.quitarComisionConfigsNulos();
		
		ComisionConfigLogicAdditional.checkComisionConfigToGets(comisionconfigs,this.datosCliente,this.arrDatoGeneral);
		
		for (ComisionConfig comisionconfigLocal: comisionconfigs ) {
			ComisionConfigLogicAdditional.updateComisionConfigToGet(comisionconfigLocal,this.arrDatoGeneral);
		}
		
		return comisionconfigs;
	}
	
	public void setComisionConfigs(List<ComisionConfig> newComisionConfigs) {
		this.comisionconfigs = newComisionConfigs;
	}
	
	public Object getComisionConfigObject() {	
		this.comisionconfigObject=this.comisionconfigDataAccess.getEntityObject();
		return this.comisionconfigObject;
	}
		
	public void setComisionConfigObject(Object newComisionConfigObject) {
		this.comisionconfigObject = newComisionConfigObject;
	}
	
	public List<Object> getComisionConfigsObject() {		
		this.comisionconfigsObject=this.comisionconfigDataAccess.getEntitiesObject();
		return this.comisionconfigsObject;
	}
		
	public void setComisionConfigsObject(List<Object> newComisionConfigsObject) {
		this.comisionconfigsObject = newComisionConfigsObject;
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
		
		if(this.comisionconfigDataAccess!=null) {
			this.comisionconfigDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			comisionconfigDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			comisionconfigDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		comisionconfig = new  ComisionConfig();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionconfig=comisionconfigDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfig);
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
		comisionconfig = new  ComisionConfig();
		  		  
        try {
			
			comisionconfig=comisionconfigDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfig);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		comisionconfig = new  ComisionConfig();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionconfig=comisionconfigDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfig);
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
		comisionconfig = new  ComisionConfig();
		  		  
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
		comisionconfig = new  ComisionConfig();
		  		  
        try {
			
			comisionconfig=comisionconfigDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfig);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		comisionconfig = new  ComisionConfig();
		  		  
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
		comisionconfig = new  ComisionConfig();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =comisionconfigDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionconfig = new  ComisionConfig();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=comisionconfigDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionconfig = new  ComisionConfig();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =comisionconfigDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionconfig = new  ComisionConfig();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=comisionconfigDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionconfig = new  ComisionConfig();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =comisionconfigDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionconfig = new  ComisionConfig();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=comisionconfigDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionconfigs = new  ArrayList<ComisionConfig>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
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
		comisionconfigs = new  ArrayList<ComisionConfig>();
		  		  
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
		comisionconfigs = new  ArrayList<ComisionConfig>();
		  		  
        try {			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		comisionconfigs = new  ArrayList<ComisionConfig>();
		  		  
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
		comisionconfigs = new  ArrayList<ComisionConfig>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
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
		comisionconfigs = new  ArrayList<ComisionConfig>();
		  		  
        try {
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
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
		comisionconfigs = new  ArrayList<ComisionConfig>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
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
		comisionconfigs = new  ArrayList<ComisionConfig>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisionconfig = new  ComisionConfig();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfig=comisionconfigDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionConfig(comisionconfig);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfig);
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
		comisionconfig = new  ComisionConfig();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfig=comisionconfigDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionConfig(comisionconfig);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfig);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionconfigs = new  ArrayList<ComisionConfig>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
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
		comisionconfigs = new  ArrayList<ComisionConfig>();
		  		  
        try {
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosComisionConfigsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		comisionconfigs = new  ArrayList<ComisionConfig>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getTodosComisionConfigsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
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
	
	public  void  getTodosComisionConfigs(String sFinalQuery,Pagination pagination)throws Exception {
		comisionconfigs = new  ArrayList<ComisionConfig>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionConfig(comisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarComisionConfig(ComisionConfig comisionconfig) throws Exception {
		Boolean estaValidado=false;
		
		if(comisionconfig.getIsNew() || comisionconfig.getIsChanged()) { 
			this.invalidValues = comisionconfigValidator.getInvalidValues(comisionconfig);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(comisionconfig);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarComisionConfig(List<ComisionConfig> ComisionConfigs) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ComisionConfig comisionconfigLocal:comisionconfigs) {				
			estaValidadoObjeto=this.validarGuardarComisionConfig(comisionconfigLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarComisionConfig(List<ComisionConfig> ComisionConfigs) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionConfig(comisionconfigs)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarComisionConfig(ComisionConfig ComisionConfig) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionConfig(comisionconfig)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ComisionConfig comisionconfig) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+comisionconfig.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ComisionConfigConstantesFunciones.getComisionConfigLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"comisionconfig","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ComisionConfigConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ComisionConfigConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveComisionConfigWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-saveComisionConfigWithConnection");connexion.begin();			
			
			ComisionConfigLogicAdditional.checkComisionConfigToSave(this.comisionconfig,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionConfigLogicAdditional.updateComisionConfigToSave(this.comisionconfig,this.arrDatoGeneral);
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionconfig,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowComisionConfig();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionConfig(this.comisionconfig)) {
				ComisionConfigDataAccess.save(this.comisionconfig, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.comisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionConfigLogicAdditional.checkComisionConfigToSaveAfter(this.comisionconfig,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionConfig();
			
			connexion.commit();			
			
			if(this.comisionconfig.getIsDeleted()) {
				this.comisionconfig=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveComisionConfig()throws Exception {	
		try {	
			
			ComisionConfigLogicAdditional.checkComisionConfigToSave(this.comisionconfig,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionConfigLogicAdditional.updateComisionConfigToSave(this.comisionconfig,this.arrDatoGeneral);
			
			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionconfig,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionConfig(this.comisionconfig)) {			
				ComisionConfigDataAccess.save(this.comisionconfig, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.comisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionConfigLogicAdditional.checkComisionConfigToSaveAfter(this.comisionconfig,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.comisionconfig.getIsDeleted()) {
				this.comisionconfig=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveComisionConfigsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-saveComisionConfigsWithConnection");connexion.begin();			
			
			ComisionConfigLogicAdditional.checkComisionConfigToSaves(comisionconfigs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowComisionConfigs();
			
			Boolean validadoTodosComisionConfig=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionConfig comisionconfigLocal:comisionconfigs) {		
				if(comisionconfigLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionConfigLogicAdditional.updateComisionConfigToSave(comisionconfigLocal,this.arrDatoGeneral);
	        	
				ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionconfigLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionConfig(comisionconfigLocal)) {
					ComisionConfigDataAccess.save(comisionconfigLocal, connexion);				
				} else {
					validadoTodosComisionConfig=false;
				}
			}
			
			if(!validadoTodosComisionConfig) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionConfigLogicAdditional.checkComisionConfigToSavesAfter(comisionconfigs,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionConfigs();
			
			connexion.commit();		
			
			this.quitarComisionConfigsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveComisionConfigs()throws Exception {				
		 try {	
			ComisionConfigLogicAdditional.checkComisionConfigToSaves(comisionconfigs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosComisionConfig=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionConfig comisionconfigLocal:comisionconfigs) {				
				if(comisionconfigLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionConfigLogicAdditional.updateComisionConfigToSave(comisionconfigLocal,this.arrDatoGeneral);
	        	
				ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionconfigLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionConfig(comisionconfigLocal)) {				
					ComisionConfigDataAccess.save(comisionconfigLocal, connexion);				
				} else {
					validadoTodosComisionConfig=false;
				}
			}
			
			if(!validadoTodosComisionConfig) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionConfigLogicAdditional.checkComisionConfigToSavesAfter(comisionconfigs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarComisionConfigsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionConfigParameterReturnGeneral procesarAccionComisionConfigs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionConfig> comisionconfigs,ComisionConfigParameterReturnGeneral comisionconfigParameterGeneral)throws Exception {
		 try {	
			ComisionConfigParameterReturnGeneral comisionconfigReturnGeneral=new ComisionConfigParameterReturnGeneral();
	
			ComisionConfigLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionconfigs,comisionconfigParameterGeneral,comisionconfigReturnGeneral);
			
			return comisionconfigReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionConfigParameterReturnGeneral procesarAccionComisionConfigsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionConfig> comisionconfigs,ComisionConfigParameterReturnGeneral comisionconfigParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-procesarAccionComisionConfigsWithConnection");connexion.begin();			
			
			ComisionConfigParameterReturnGeneral comisionconfigReturnGeneral=new ComisionConfigParameterReturnGeneral();
	
			ComisionConfigLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionconfigs,comisionconfigParameterGeneral,comisionconfigReturnGeneral);
			
			this.connexion.commit();
			
			return comisionconfigReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionConfigParameterReturnGeneral procesarEventosComisionConfigs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionConfig> comisionconfigs,ComisionConfig comisionconfig,ComisionConfigParameterReturnGeneral comisionconfigParameterGeneral,Boolean isEsNuevoComisionConfig,ArrayList<Classe> clases)throws Exception {
		 try {	
			ComisionConfigParameterReturnGeneral comisionconfigReturnGeneral=new ComisionConfigParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionconfigReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionConfigLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionconfigs,comisionconfig,comisionconfigParameterGeneral,comisionconfigReturnGeneral,isEsNuevoComisionConfig,clases);
			
			return comisionconfigReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ComisionConfigParameterReturnGeneral procesarEventosComisionConfigsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionConfig> comisionconfigs,ComisionConfig comisionconfig,ComisionConfigParameterReturnGeneral comisionconfigParameterGeneral,Boolean isEsNuevoComisionConfig,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-procesarEventosComisionConfigsWithConnection");connexion.begin();			
			
			ComisionConfigParameterReturnGeneral comisionconfigReturnGeneral=new ComisionConfigParameterReturnGeneral();
	
			comisionconfigReturnGeneral.setComisionConfig(comisionconfig);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionconfigReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionConfigLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionconfigs,comisionconfig,comisionconfigParameterGeneral,comisionconfigReturnGeneral,isEsNuevoComisionConfig,clases);
			
			this.connexion.commit();
			
			return comisionconfigReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionConfigParameterReturnGeneral procesarImportacionComisionConfigsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ComisionConfigParameterReturnGeneral comisionconfigParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-procesarImportacionComisionConfigsWithConnection");connexion.begin();			
			
			ComisionConfigParameterReturnGeneral comisionconfigReturnGeneral=new ComisionConfigParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.comisionconfigs=new ArrayList<ComisionConfig>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.comisionconfig=new ComisionConfig();
				
				
				if(conColumnasBase) {this.comisionconfig.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.comisionconfig.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.comisionconfig.setcon_vendedor(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.comisionconfig.setcon_ventas(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.comisionconfig.setcon_cobros(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.comisionconfig.setcon_remesa_transito(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.comisionconfig.setcon_penalidad(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.comisionconfig.setcon_abono(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.comisionconfigs.add(this.comisionconfig);
			}
			
			this.saveComisionConfigs();
			
			this.connexion.commit();
			
			comisionconfigReturnGeneral.setConRetornoEstaProcesado(true);
			comisionconfigReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return comisionconfigReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarComisionConfigsEliminados() throws Exception {				
		
		List<ComisionConfig> comisionconfigsAux= new ArrayList<ComisionConfig>();
		
		for(ComisionConfig comisionconfig:comisionconfigs) {
			if(!comisionconfig.getIsDeleted()) {
				comisionconfigsAux.add(comisionconfig);
			}
		}
		
		comisionconfigs=comisionconfigsAux;
	}
	
	public void quitarComisionConfigsNulos() throws Exception {				
		
		List<ComisionConfig> comisionconfigsAux= new ArrayList<ComisionConfig>();
		
		for(ComisionConfig comisionconfig : this.comisionconfigs) {
			if(comisionconfig==null) {
				comisionconfigsAux.add(comisionconfig);
			}
		}
		
		//this.comisionconfigs=comisionconfigsAux;
		
		this.comisionconfigs.removeAll(comisionconfigsAux);
	}
	
	public void getSetVersionRowComisionConfigWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(comisionconfig.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((comisionconfig.getIsDeleted() || (comisionconfig.getIsChanged()&&!comisionconfig.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=comisionconfigDataAccess.getSetVersionRowComisionConfig(connexion,comisionconfig.getId());
				
				if(!comisionconfig.getVersionRow().equals(timestamp)) {	
					comisionconfig.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				comisionconfig.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowComisionConfig()throws Exception {	
		
		if(comisionconfig.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((comisionconfig.getIsDeleted() || (comisionconfig.getIsChanged()&&!comisionconfig.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=comisionconfigDataAccess.getSetVersionRowComisionConfig(connexion,comisionconfig.getId());
			
			try {							
				if(!comisionconfig.getVersionRow().equals(timestamp)) {	
					comisionconfig.setVersionRow(timestamp);
				}
				
				comisionconfig.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowComisionConfigsWithConnection()throws Exception {	
		if(comisionconfigs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ComisionConfig comisionconfigAux:comisionconfigs) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(comisionconfigAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionconfigAux.getIsDeleted() || (comisionconfigAux.getIsChanged()&&!comisionconfigAux.getIsNew())) {
						
						timestamp=comisionconfigDataAccess.getSetVersionRowComisionConfig(connexion,comisionconfigAux.getId());
						
						if(!comisionconfig.getVersionRow().equals(timestamp)) {	
							comisionconfigAux.setVersionRow(timestamp);
						}
								
						comisionconfigAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowComisionConfigs()throws Exception {	
		if(comisionconfigs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ComisionConfig comisionconfigAux:comisionconfigs) {
					if(comisionconfigAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionconfigAux.getIsDeleted() || (comisionconfigAux.getIsChanged()&&!comisionconfigAux.getIsNew())) {
						
						timestamp=comisionconfigDataAccess.getSetVersionRowComisionConfig(connexion,comisionconfigAux.getId());
						
						if(!comisionconfigAux.getVersionRow().equals(timestamp)) {	
							comisionconfigAux.setVersionRow(timestamp);
						}
						
													
						comisionconfigAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ComisionConfigParameterReturnGeneral cargarCombosLoteForeignKeyComisionConfigWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoComisionConfig,String finalQueryGlobalNivelLinea) throws Exception {
		ComisionConfigParameterReturnGeneral  comisionconfigReturnGeneral =new ComisionConfigParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-cargarCombosLoteForeignKeyComisionConfigWithConnection");connexion.begin();
			
			comisionconfigReturnGeneral =new ComisionConfigParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionconfigReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoComisionConfig> tipocomisionconfigsForeignKey=new ArrayList<TipoComisionConfig>();
			TipoComisionConfigLogic tipocomisionconfigLogic=new TipoComisionConfigLogic();
			tipocomisionconfigLogic.setConnexion(this.connexion);
			tipocomisionconfigLogic.getTipoComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComisionConfig.equals("NONE")) {
				tipocomisionconfigLogic.getTodosTipoComisionConfigs(finalQueryGlobalTipoComisionConfig,new Pagination());
				tipocomisionconfigsForeignKey=tipocomisionconfigLogic.getTipoComisionConfigs();
			}

			comisionconfigReturnGeneral.settipocomisionconfigsForeignKey(tipocomisionconfigsForeignKey);


			List<NivelLinea> nivellineasForeignKey=new ArrayList<NivelLinea>();
			NivelLineaLogic nivellineaLogic=new NivelLineaLogic();
			nivellineaLogic.setConnexion(this.connexion);
			nivellineaLogic.getNivelLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNivelLinea.equals("NONE")) {
				nivellineaLogic.getTodosNivelLineas(finalQueryGlobalNivelLinea,new Pagination());
				nivellineasForeignKey=nivellineaLogic.getNivelLineas();
			}

			comisionconfigReturnGeneral.setnivellineasForeignKey(nivellineasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return comisionconfigReturnGeneral;
	}
	
	public ComisionConfigParameterReturnGeneral cargarCombosLoteForeignKeyComisionConfig(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoComisionConfig,String finalQueryGlobalNivelLinea) throws Exception {
		ComisionConfigParameterReturnGeneral  comisionconfigReturnGeneral =new ComisionConfigParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			comisionconfigReturnGeneral =new ComisionConfigParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionconfigReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoComisionConfig> tipocomisionconfigsForeignKey=new ArrayList<TipoComisionConfig>();
			TipoComisionConfigLogic tipocomisionconfigLogic=new TipoComisionConfigLogic();
			tipocomisionconfigLogic.setConnexion(this.connexion);
			tipocomisionconfigLogic.getTipoComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComisionConfig.equals("NONE")) {
				tipocomisionconfigLogic.getTodosTipoComisionConfigs(finalQueryGlobalTipoComisionConfig,new Pagination());
				tipocomisionconfigsForeignKey=tipocomisionconfigLogic.getTipoComisionConfigs();
			}

			comisionconfigReturnGeneral.settipocomisionconfigsForeignKey(tipocomisionconfigsForeignKey);


			List<NivelLinea> nivellineasForeignKey=new ArrayList<NivelLinea>();
			NivelLineaLogic nivellineaLogic=new NivelLineaLogic();
			nivellineaLogic.setConnexion(this.connexion);
			nivellineaLogic.getNivelLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNivelLinea.equals("NONE")) {
				nivellineaLogic.getTodosNivelLineas(finalQueryGlobalNivelLinea,new Pagination());
				nivellineasForeignKey=nivellineaLogic.getNivelLineas();
			}

			comisionconfigReturnGeneral.setnivellineasForeignKey(nivellineasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return comisionconfigReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyComisionConfigWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ComisionCateLogic comisioncateLogic=new ComisionCateLogic();
			ComisionMarcaLogic comisionmarcaLogic=new ComisionMarcaLogic();
			ComisionLineaLogic comisionlineaLogic=new ComisionLineaLogic();
			ComisionPenaLogic comisionpenaLogic=new ComisionPenaLogic();
			ComisionGrupoLogic comisiongrupoLogic=new ComisionGrupoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyComisionConfigWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ComisionCate.class));
			classes.add(new Classe(ComisionMarca.class));
			classes.add(new Classe(ComisionLinea.class));
			classes.add(new Classe(ComisionPena.class));
			classes.add(new Classe(ComisionGrupo.class));
											
			

			comisioncateLogic.setConnexion(this.getConnexion());
			comisioncateLogic.setDatosCliente(this.datosCliente);
			comisioncateLogic.setIsConRefrescarForeignKeys(true);

			comisionmarcaLogic.setConnexion(this.getConnexion());
			comisionmarcaLogic.setDatosCliente(this.datosCliente);
			comisionmarcaLogic.setIsConRefrescarForeignKeys(true);

			comisionlineaLogic.setConnexion(this.getConnexion());
			comisionlineaLogic.setDatosCliente(this.datosCliente);
			comisionlineaLogic.setIsConRefrescarForeignKeys(true);

			comisionpenaLogic.setConnexion(this.getConnexion());
			comisionpenaLogic.setDatosCliente(this.datosCliente);
			comisionpenaLogic.setIsConRefrescarForeignKeys(true);

			comisiongrupoLogic.setConnexion(this.getConnexion());
			comisiongrupoLogic.setDatosCliente(this.datosCliente);
			comisiongrupoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(ComisionConfig comisionconfig:this.comisionconfigs) {
				

				classes=new ArrayList<Classe>();
				classes=ComisionCateConstantesFunciones.getClassesForeignKeysOfComisionCate(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisioncateLogic.setComisionCates(comisionconfig.comisioncates);
				comisioncateLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionMarcaConstantesFunciones.getClassesForeignKeysOfComisionMarca(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionmarcaLogic.setComisionMarcas(comisionconfig.comisionmarcas);
				comisionmarcaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionLineaConstantesFunciones.getClassesForeignKeysOfComisionLinea(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionlineaLogic.setComisionLineas(comisionconfig.comisionlineas);
				comisionlineaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionPenaConstantesFunciones.getClassesForeignKeysOfComisionPena(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionpenaLogic.setComisionPenas(comisionconfig.comisionpenas);
				comisionpenaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionGrupoConstantesFunciones.getClassesForeignKeysOfComisionGrupo(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisiongrupoLogic.setComisionGrupos(comisionconfig.comisiongrupos);
				comisiongrupoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(ComisionConfig comisionconfig,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComisionConfigLogicAdditional.updateComisionConfigToGet(comisionconfig,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionconfig.setEmpresa(comisionconfigDataAccess.getEmpresa(connexion,comisionconfig));
		comisionconfig.setTipoComisionConfig(comisionconfigDataAccess.getTipoComisionConfig(connexion,comisionconfig));
		comisionconfig.setNivelLinea(comisionconfigDataAccess.getNivelLinea(connexion,comisionconfig));
		comisionconfig.setComisionCates(comisionconfigDataAccess.getComisionCates(connexion,comisionconfig));
		comisionconfig.setComisionMarcas(comisionconfigDataAccess.getComisionMarcas(connexion,comisionconfig));
		comisionconfig.setComisionLineas(comisionconfigDataAccess.getComisionLineas(connexion,comisionconfig));
		comisionconfig.setComisionPenas(comisionconfigDataAccess.getComisionPenas(connexion,comisionconfig));
		comisionconfig.setComisionGrupos(comisionconfigDataAccess.getComisionGrupos(connexion,comisionconfig));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionconfig.setEmpresa(comisionconfigDataAccess.getEmpresa(connexion,comisionconfig));
				continue;
			}

			if(clas.clas.equals(TipoComisionConfig.class)) {
				comisionconfig.setTipoComisionConfig(comisionconfigDataAccess.getTipoComisionConfig(connexion,comisionconfig));
				continue;
			}

			if(clas.clas.equals(NivelLinea.class)) {
				comisionconfig.setNivelLinea(comisionconfigDataAccess.getNivelLinea(connexion,comisionconfig));
				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionCates(comisionconfigDataAccess.getComisionCates(connexion,comisionconfig));

				if(this.isConDeep) {
					ComisionCateLogic comisioncateLogic= new ComisionCateLogic(this.connexion);
					comisioncateLogic.setComisionCates(comisionconfig.getComisionCates());
					ArrayList<Classe> classesLocal=ComisionCateConstantesFunciones.getClassesForeignKeysOfComisionCate(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisioncateLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(comisioncateLogic.getComisionCates());
					comisionconfig.setComisionCates(comisioncateLogic.getComisionCates());
				}

				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionMarcas(comisionconfigDataAccess.getComisionMarcas(connexion,comisionconfig));

				if(this.isConDeep) {
					ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(this.connexion);
					comisionmarcaLogic.setComisionMarcas(comisionconfig.getComisionMarcas());
					ArrayList<Classe> classesLocal=ComisionMarcaConstantesFunciones.getClassesForeignKeysOfComisionMarca(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionmarcaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(comisionmarcaLogic.getComisionMarcas());
					comisionconfig.setComisionMarcas(comisionmarcaLogic.getComisionMarcas());
				}

				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionLineas(comisionconfigDataAccess.getComisionLineas(connexion,comisionconfig));

				if(this.isConDeep) {
					ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(this.connexion);
					comisionlineaLogic.setComisionLineas(comisionconfig.getComisionLineas());
					ArrayList<Classe> classesLocal=ComisionLineaConstantesFunciones.getClassesForeignKeysOfComisionLinea(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionlineaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(comisionlineaLogic.getComisionLineas());
					comisionconfig.setComisionLineas(comisionlineaLogic.getComisionLineas());
				}

				continue;
			}

			if(clas.clas.equals(ComisionPena.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionPenas(comisionconfigDataAccess.getComisionPenas(connexion,comisionconfig));

				if(this.isConDeep) {
					ComisionPenaLogic comisionpenaLogic= new ComisionPenaLogic(this.connexion);
					comisionpenaLogic.setComisionPenas(comisionconfig.getComisionPenas());
					ArrayList<Classe> classesLocal=ComisionPenaConstantesFunciones.getClassesForeignKeysOfComisionPena(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionpenaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(comisionpenaLogic.getComisionPenas());
					comisionconfig.setComisionPenas(comisionpenaLogic.getComisionPenas());
				}

				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionGrupos(comisionconfigDataAccess.getComisionGrupos(connexion,comisionconfig));

				if(this.isConDeep) {
					ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(this.connexion);
					comisiongrupoLogic.setComisionGrupos(comisionconfig.getComisionGrupos());
					ArrayList<Classe> classesLocal=ComisionGrupoConstantesFunciones.getClassesForeignKeysOfComisionGrupo(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisiongrupoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(comisiongrupoLogic.getComisionGrupos());
					comisionconfig.setComisionGrupos(comisiongrupoLogic.getComisionGrupos());
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
			comisionconfig.setEmpresa(comisionconfigDataAccess.getEmpresa(connexion,comisionconfig));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionconfig.setTipoComisionConfig(comisionconfigDataAccess.getTipoComisionConfig(connexion,comisionconfig));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NivelLinea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionconfig.setNivelLinea(comisionconfigDataAccess.getNivelLinea(connexion,comisionconfig));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionCate.class));
			comisionconfig.setComisionCates(comisionconfigDataAccess.getComisionCates(connexion,comisionconfig));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionMarca.class));
			comisionconfig.setComisionMarcas(comisionconfigDataAccess.getComisionMarcas(connexion,comisionconfig));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionLinea.class));
			comisionconfig.setComisionLineas(comisionconfigDataAccess.getComisionLineas(connexion,comisionconfig));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionPena.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionPena.class));
			comisionconfig.setComisionPenas(comisionconfigDataAccess.getComisionPenas(connexion,comisionconfig));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionGrupo.class));
			comisionconfig.setComisionGrupos(comisionconfigDataAccess.getComisionGrupos(connexion,comisionconfig));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionconfig.setEmpresa(comisionconfigDataAccess.getEmpresa(connexion,comisionconfig));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionconfig.getEmpresa(),isDeep,deepLoadType,clases);
				
		comisionconfig.setTipoComisionConfig(comisionconfigDataAccess.getTipoComisionConfig(connexion,comisionconfig));
		TipoComisionConfigLogic tipocomisionconfigLogic= new TipoComisionConfigLogic(connexion);
		tipocomisionconfigLogic.deepLoad(comisionconfig.getTipoComisionConfig(),isDeep,deepLoadType,clases);
				
		comisionconfig.setNivelLinea(comisionconfigDataAccess.getNivelLinea(connexion,comisionconfig));
		NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
		nivellineaLogic.deepLoad(comisionconfig.getNivelLinea(),isDeep,deepLoadType,clases);
				

		comisionconfig.setComisionCates(comisionconfigDataAccess.getComisionCates(connexion,comisionconfig));

		for(ComisionCate comisioncate:comisionconfig.getComisionCates()) {
			ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
			comisioncateLogic.deepLoad(comisioncate,isDeep,deepLoadType,clases);
		}

		comisionconfig.setComisionMarcas(comisionconfigDataAccess.getComisionMarcas(connexion,comisionconfig));

		for(ComisionMarca comisionmarca:comisionconfig.getComisionMarcas()) {
			ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
			comisionmarcaLogic.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
		}

		comisionconfig.setComisionLineas(comisionconfigDataAccess.getComisionLineas(connexion,comisionconfig));

		for(ComisionLinea comisionlinea:comisionconfig.getComisionLineas()) {
			ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
			comisionlineaLogic.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
		}

		comisionconfig.setComisionPenas(comisionconfigDataAccess.getComisionPenas(connexion,comisionconfig));

		for(ComisionPena comisionpena:comisionconfig.getComisionPenas()) {
			ComisionPenaLogic comisionpenaLogic= new ComisionPenaLogic(connexion);
			comisionpenaLogic.deepLoad(comisionpena,isDeep,deepLoadType,clases);
		}

		comisionconfig.setComisionGrupos(comisionconfigDataAccess.getComisionGrupos(connexion,comisionconfig));

		for(ComisionGrupo comisiongrupo:comisionconfig.getComisionGrupos()) {
			ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
			comisiongrupoLogic.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionconfig.setEmpresa(comisionconfigDataAccess.getEmpresa(connexion,comisionconfig));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comisionconfig.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComisionConfig.class)) {
				comisionconfig.setTipoComisionConfig(comisionconfigDataAccess.getTipoComisionConfig(connexion,comisionconfig));
				TipoComisionConfigLogic tipocomisionconfigLogic= new TipoComisionConfigLogic(connexion);
				tipocomisionconfigLogic.deepLoad(comisionconfig.getTipoComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NivelLinea.class)) {
				comisionconfig.setNivelLinea(comisionconfigDataAccess.getNivelLinea(connexion,comisionconfig));
				NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
				nivellineaLogic.deepLoad(comisionconfig.getNivelLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionCates(comisionconfigDataAccess.getComisionCates(connexion,comisionconfig));

				for(ComisionCate comisioncate:comisionconfig.getComisionCates()) {
					ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
					comisioncateLogic.deepLoad(comisioncate,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionMarcas(comisionconfigDataAccess.getComisionMarcas(connexion,comisionconfig));

				for(ComisionMarca comisionmarca:comisionconfig.getComisionMarcas()) {
					ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
					comisionmarcaLogic.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionLineas(comisionconfigDataAccess.getComisionLineas(connexion,comisionconfig));

				for(ComisionLinea comisionlinea:comisionconfig.getComisionLineas()) {
					ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
					comisionlineaLogic.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionPena.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionPenas(comisionconfigDataAccess.getComisionPenas(connexion,comisionconfig));

				for(ComisionPena comisionpena:comisionconfig.getComisionPenas()) {
					ComisionPenaLogic comisionpenaLogic= new ComisionPenaLogic(connexion);
					comisionpenaLogic.deepLoad(comisionpena,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				comisionconfig.setComisionGrupos(comisionconfigDataAccess.getComisionGrupos(connexion,comisionconfig));

				for(ComisionGrupo comisiongrupo:comisionconfig.getComisionGrupos()) {
					ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
					comisiongrupoLogic.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
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
			comisionconfig.setEmpresa(comisionconfigDataAccess.getEmpresa(connexion,comisionconfig));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comisionconfig.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionconfig.setTipoComisionConfig(comisionconfigDataAccess.getTipoComisionConfig(connexion,comisionconfig));
			TipoComisionConfigLogic tipocomisionconfigLogic= new TipoComisionConfigLogic(connexion);
			tipocomisionconfigLogic.deepLoad(comisionconfig.getTipoComisionConfig(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NivelLinea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionconfig.setNivelLinea(comisionconfigDataAccess.getNivelLinea(connexion,comisionconfig));
			NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
			nivellineaLogic.deepLoad(comisionconfig.getNivelLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionCate.class));
			comisionconfig.setComisionCates(comisionconfigDataAccess.getComisionCates(connexion,comisionconfig));

			for(ComisionCate comisioncate:comisionconfig.getComisionCates()) {
				ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
				comisioncateLogic.deepLoad(comisioncate,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionMarca.class));
			comisionconfig.setComisionMarcas(comisionconfigDataAccess.getComisionMarcas(connexion,comisionconfig));

			for(ComisionMarca comisionmarca:comisionconfig.getComisionMarcas()) {
				ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
				comisionmarcaLogic.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionLinea.class));
			comisionconfig.setComisionLineas(comisionconfigDataAccess.getComisionLineas(connexion,comisionconfig));

			for(ComisionLinea comisionlinea:comisionconfig.getComisionLineas()) {
				ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
				comisionlineaLogic.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionPena.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionPena.class));
			comisionconfig.setComisionPenas(comisionconfigDataAccess.getComisionPenas(connexion,comisionconfig));

			for(ComisionPena comisionpena:comisionconfig.getComisionPenas()) {
				ComisionPenaLogic comisionpenaLogic= new ComisionPenaLogic(connexion);
				comisionpenaLogic.deepLoad(comisionpena,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionGrupo.class));
			comisionconfig.setComisionGrupos(comisionconfigDataAccess.getComisionGrupos(connexion,comisionconfig));

			for(ComisionGrupo comisiongrupo:comisionconfig.getComisionGrupos()) {
				ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
				comisiongrupoLogic.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ComisionConfig comisionconfig,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ComisionConfigLogicAdditional.updateComisionConfigToSave(comisionconfig,this.arrDatoGeneral);
			
ComisionConfigDataAccess.save(comisionconfig, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionconfig.getEmpresa(),connexion);

		TipoComisionConfigDataAccess.save(comisionconfig.getTipoComisionConfig(),connexion);

		NivelLineaDataAccess.save(comisionconfig.getNivelLinea(),connexion);

		for(ComisionCate comisioncate:comisionconfig.getComisionCates()) {
			comisioncate.setid_comision_config(comisionconfig.getId());
			ComisionCateDataAccess.save(comisioncate,connexion);
		}

		for(ComisionMarca comisionmarca:comisionconfig.getComisionMarcas()) {
			comisionmarca.setid_comision_config(comisionconfig.getId());
			ComisionMarcaDataAccess.save(comisionmarca,connexion);
		}

		for(ComisionLinea comisionlinea:comisionconfig.getComisionLineas()) {
			comisionlinea.setid_comision_config(comisionconfig.getId());
			ComisionLineaDataAccess.save(comisionlinea,connexion);
		}

		for(ComisionPena comisionpena:comisionconfig.getComisionPenas()) {
			comisionpena.setid_comision_config(comisionconfig.getId());
			ComisionPenaDataAccess.save(comisionpena,connexion);
		}

		for(ComisionGrupo comisiongrupo:comisionconfig.getComisionGrupos()) {
			comisiongrupo.setid_comision_config(comisionconfig.getId());
			ComisionGrupoDataAccess.save(comisiongrupo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionconfig.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoComisionConfig.class)) {
				TipoComisionConfigDataAccess.save(comisionconfig.getTipoComisionConfig(),connexion);
				continue;
			}

			if(clas.clas.equals(NivelLinea.class)) {
				NivelLineaDataAccess.save(comisionconfig.getNivelLinea(),connexion);
				continue;
			}


			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionCate comisioncate:comisionconfig.getComisionCates()) {
					comisioncate.setid_comision_config(comisionconfig.getId());
					ComisionCateDataAccess.save(comisioncate,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionMarca comisionmarca:comisionconfig.getComisionMarcas()) {
					comisionmarca.setid_comision_config(comisionconfig.getId());
					ComisionMarcaDataAccess.save(comisionmarca,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionLinea comisionlinea:comisionconfig.getComisionLineas()) {
					comisionlinea.setid_comision_config(comisionconfig.getId());
					ComisionLineaDataAccess.save(comisionlinea,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionPena.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionPena comisionpena:comisionconfig.getComisionPenas()) {
					comisionpena.setid_comision_config(comisionconfig.getId());
					ComisionPenaDataAccess.save(comisionpena,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionGrupo comisiongrupo:comisionconfig.getComisionGrupos()) {
					comisiongrupo.setid_comision_config(comisionconfig.getId());
					ComisionGrupoDataAccess.save(comisiongrupo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionconfig.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionconfig.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoComisionConfigDataAccess.save(comisionconfig.getTipoComisionConfig(),connexion);
		TipoComisionConfigLogic tipocomisionconfigLogic= new TipoComisionConfigLogic(connexion);
		tipocomisionconfigLogic.deepLoad(comisionconfig.getTipoComisionConfig(),isDeep,deepLoadType,clases);
				

		NivelLineaDataAccess.save(comisionconfig.getNivelLinea(),connexion);
		NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
		nivellineaLogic.deepLoad(comisionconfig.getNivelLinea(),isDeep,deepLoadType,clases);
				

		for(ComisionCate comisioncate:comisionconfig.getComisionCates()) {
			ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
			comisioncate.setid_comision_config(comisionconfig.getId());
			ComisionCateDataAccess.save(comisioncate,connexion);
			comisioncateLogic.deepSave(comisioncate,isDeep,deepLoadType,clases);
		}

		for(ComisionMarca comisionmarca:comisionconfig.getComisionMarcas()) {
			ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
			comisionmarca.setid_comision_config(comisionconfig.getId());
			ComisionMarcaDataAccess.save(comisionmarca,connexion);
			comisionmarcaLogic.deepSave(comisionmarca,isDeep,deepLoadType,clases);
		}

		for(ComisionLinea comisionlinea:comisionconfig.getComisionLineas()) {
			ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
			comisionlinea.setid_comision_config(comisionconfig.getId());
			ComisionLineaDataAccess.save(comisionlinea,connexion);
			comisionlineaLogic.deepSave(comisionlinea,isDeep,deepLoadType,clases);
		}

		for(ComisionPena comisionpena:comisionconfig.getComisionPenas()) {
			ComisionPenaLogic comisionpenaLogic= new ComisionPenaLogic(connexion);
			comisionpena.setid_comision_config(comisionconfig.getId());
			ComisionPenaDataAccess.save(comisionpena,connexion);
			comisionpenaLogic.deepSave(comisionpena,isDeep,deepLoadType,clases);
		}

		for(ComisionGrupo comisiongrupo:comisionconfig.getComisionGrupos()) {
			ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
			comisiongrupo.setid_comision_config(comisionconfig.getId());
			ComisionGrupoDataAccess.save(comisiongrupo,connexion);
			comisiongrupoLogic.deepSave(comisiongrupo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionconfig.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(comisionconfig.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComisionConfig.class)) {
				TipoComisionConfigDataAccess.save(comisionconfig.getTipoComisionConfig(),connexion);
				TipoComisionConfigLogic tipocomisionconfigLogic= new TipoComisionConfigLogic(connexion);
				tipocomisionconfigLogic.deepSave(comisionconfig.getTipoComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NivelLinea.class)) {
				NivelLineaDataAccess.save(comisionconfig.getNivelLinea(),connexion);
				NivelLineaLogic nivellineaLogic= new NivelLineaLogic(connexion);
				nivellineaLogic.deepSave(comisionconfig.getNivelLinea(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionCate comisioncate:comisionconfig.getComisionCates()) {
					ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
					comisioncate.setid_comision_config(comisionconfig.getId());
					ComisionCateDataAccess.save(comisioncate,connexion);
					comisioncateLogic.deepSave(comisioncate,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionMarca comisionmarca:comisionconfig.getComisionMarcas()) {
					ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
					comisionmarca.setid_comision_config(comisionconfig.getId());
					ComisionMarcaDataAccess.save(comisionmarca,connexion);
					comisionmarcaLogic.deepSave(comisionmarca,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionLinea comisionlinea:comisionconfig.getComisionLineas()) {
					ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
					comisionlinea.setid_comision_config(comisionconfig.getId());
					ComisionLineaDataAccess.save(comisionlinea,connexion);
					comisionlineaLogic.deepSave(comisionlinea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionPena.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionPena comisionpena:comisionconfig.getComisionPenas()) {
					ComisionPenaLogic comisionpenaLogic= new ComisionPenaLogic(connexion);
					comisionpena.setid_comision_config(comisionconfig.getId());
					ComisionPenaDataAccess.save(comisionpena,connexion);
					comisionpenaLogic.deepSave(comisionpena,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionGrupo comisiongrupo:comisionconfig.getComisionGrupos()) {
					ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
					comisiongrupo.setid_comision_config(comisionconfig.getId());
					ComisionGrupoDataAccess.save(comisiongrupo,connexion);
					comisiongrupoLogic.deepSave(comisiongrupo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(ComisionConfig.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(comisionconfig,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(comisionconfig);
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
			this.deepLoad(this.comisionconfig,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfig);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ComisionConfig.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(comisionconfigs!=null) {
				for(ComisionConfig comisionconfig:comisionconfigs) {
					this.deepLoad(comisionconfig,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(comisionconfigs);
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
			if(comisionconfigs!=null) {
				for(ComisionConfig comisionconfig:comisionconfigs) {
					this.deepLoad(comisionconfig,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(comisionconfigs);
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
			this.getNewConnexionToDeep(ComisionConfig.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(comisionconfig,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ComisionConfig.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(comisionconfigs!=null) {
				for(ComisionConfig comisionconfig:comisionconfigs) {
					this.deepSave(comisionconfig,isDeep,deepLoadType,clases);
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
			if(comisionconfigs!=null) {
				for(ComisionConfig comisionconfig:comisionconfigs) {
					this.deepSave(comisionconfig,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getComisionConfigsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionConfigConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionConfigsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionConfigConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionConfigsFK_IdNivelLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_nivel_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNivelLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNivelLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nivel_linea,ComisionConfigConstantesFunciones.IDNIVELLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNivelLinea);

			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNivelLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionConfigsFK_IdNivelLinea(String sFinalQuery,Pagination pagination,Long id_nivel_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNivelLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNivelLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nivel_linea,ComisionConfigConstantesFunciones.IDNIVELLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNivelLinea);

			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNivelLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionConfigsFK_IdTipoComisionConfigWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_comision_config)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionConfig.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comision_config,ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComisionConfig);

			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionConfigsFK_IdTipoComisionConfig(String sFinalQuery,Pagination pagination,Long id_tipo_comision_config)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comision_config,ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComisionConfig);

			ComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(this.comisionconfigs);
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
			if(ComisionConfigConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionConfigDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ComisionConfig comisionconfig,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ComisionConfigConstantesFunciones.ISCONAUDITORIA) {
				if(comisionconfig.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionConfigDataAccess.TABLENAME, comisionconfig.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionConfigConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionConfigLogic.registrarAuditoriaDetallesComisionConfig(connexion,comisionconfig,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(comisionconfig.getIsDeleted()) {
					/*if(!comisionconfig.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ComisionConfigDataAccess.TABLENAME, comisionconfig.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ComisionConfigLogic.registrarAuditoriaDetallesComisionConfig(connexion,comisionconfig,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionConfigDataAccess.TABLENAME, comisionconfig.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(comisionconfig.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionConfigDataAccess.TABLENAME, comisionconfig.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionConfigConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionConfigLogic.registrarAuditoriaDetallesComisionConfig(connexion,comisionconfig,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesComisionConfig(Connexion connexion,ComisionConfig comisionconfig)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(comisionconfig.getIsNew()||!comisionconfig.getid_empresa().equals(comisionconfig.getComisionConfigOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionconfig.getComisionConfigOriginal().getid_empresa()!=null)
				{
					strValorActual=comisionconfig.getComisionConfigOriginal().getid_empresa().toString();
				}
				if(comisionconfig.getid_empresa()!=null)
				{
					strValorNuevo=comisionconfig.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionConfigConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(comisionconfig.getIsNew()||!comisionconfig.getid_tipo_comision_config().equals(comisionconfig.getComisionConfigOriginal().getid_tipo_comision_config()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionconfig.getComisionConfigOriginal().getid_tipo_comision_config()!=null)
				{
					strValorActual=comisionconfig.getComisionConfigOriginal().getid_tipo_comision_config().toString();
				}
				if(comisionconfig.getid_tipo_comision_config()!=null)
				{
					strValorNuevo=comisionconfig.getid_tipo_comision_config().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG,strValorActual,strValorNuevo);
			}	
			
			if(comisionconfig.getIsNew()||!comisionconfig.getid_nivel_linea().equals(comisionconfig.getComisionConfigOriginal().getid_nivel_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionconfig.getComisionConfigOriginal().getid_nivel_linea()!=null)
				{
					strValorActual=comisionconfig.getComisionConfigOriginal().getid_nivel_linea().toString();
				}
				if(comisionconfig.getid_nivel_linea()!=null)
				{
					strValorNuevo=comisionconfig.getid_nivel_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionConfigConstantesFunciones.IDNIVELLINEA,strValorActual,strValorNuevo);
			}	
			
			if(comisionconfig.getIsNew()||!comisionconfig.getcon_vendedor().equals(comisionconfig.getComisionConfigOriginal().getcon_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionconfig.getComisionConfigOriginal().getcon_vendedor()!=null)
				{
					strValorActual=comisionconfig.getComisionConfigOriginal().getcon_vendedor().toString();
				}
				if(comisionconfig.getcon_vendedor()!=null)
				{
					strValorNuevo=comisionconfig.getcon_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionConfigConstantesFunciones.CONVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(comisionconfig.getIsNew()||!comisionconfig.getcon_ventas().equals(comisionconfig.getComisionConfigOriginal().getcon_ventas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionconfig.getComisionConfigOriginal().getcon_ventas()!=null)
				{
					strValorActual=comisionconfig.getComisionConfigOriginal().getcon_ventas().toString();
				}
				if(comisionconfig.getcon_ventas()!=null)
				{
					strValorNuevo=comisionconfig.getcon_ventas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionConfigConstantesFunciones.CONVENTAS,strValorActual,strValorNuevo);
			}	
			
			if(comisionconfig.getIsNew()||!comisionconfig.getcon_cobros().equals(comisionconfig.getComisionConfigOriginal().getcon_cobros()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionconfig.getComisionConfigOriginal().getcon_cobros()!=null)
				{
					strValorActual=comisionconfig.getComisionConfigOriginal().getcon_cobros().toString();
				}
				if(comisionconfig.getcon_cobros()!=null)
				{
					strValorNuevo=comisionconfig.getcon_cobros().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionConfigConstantesFunciones.CONCOBROS,strValorActual,strValorNuevo);
			}	
			
			if(comisionconfig.getIsNew()||!comisionconfig.getcon_remesa_transito().equals(comisionconfig.getComisionConfigOriginal().getcon_remesa_transito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionconfig.getComisionConfigOriginal().getcon_remesa_transito()!=null)
				{
					strValorActual=comisionconfig.getComisionConfigOriginal().getcon_remesa_transito().toString();
				}
				if(comisionconfig.getcon_remesa_transito()!=null)
				{
					strValorNuevo=comisionconfig.getcon_remesa_transito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionConfigConstantesFunciones.CONREMESATRANSITO,strValorActual,strValorNuevo);
			}	
			
			if(comisionconfig.getIsNew()||!comisionconfig.getcon_penalidad().equals(comisionconfig.getComisionConfigOriginal().getcon_penalidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionconfig.getComisionConfigOriginal().getcon_penalidad()!=null)
				{
					strValorActual=comisionconfig.getComisionConfigOriginal().getcon_penalidad().toString();
				}
				if(comisionconfig.getcon_penalidad()!=null)
				{
					strValorNuevo=comisionconfig.getcon_penalidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionConfigConstantesFunciones.CONPENALIDAD,strValorActual,strValorNuevo);
			}	
			
			if(comisionconfig.getIsNew()||!comisionconfig.getcon_abono().equals(comisionconfig.getComisionConfigOriginal().getcon_abono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionconfig.getComisionConfigOriginal().getcon_abono()!=null)
				{
					strValorActual=comisionconfig.getComisionConfigOriginal().getcon_abono().toString();
				}
				if(comisionconfig.getcon_abono()!=null)
				{
					strValorNuevo=comisionconfig.getcon_abono().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionConfigConstantesFunciones.CONABONO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveComisionConfigRelacionesWithConnection(ComisionConfig comisionconfig,List<ComisionCate> comisioncates,List<ComisionMarca> comisionmarcas,List<ComisionLinea> comisionlineas,List<ComisionPena> comisionpenas,List<ComisionGrupo> comisiongrupos) throws Exception {

		if(!comisionconfig.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionConfigRelacionesBase(comisionconfig,comisioncates,comisionmarcas,comisionlineas,comisionpenas,comisiongrupos,true);
		}
	}

	public void saveComisionConfigRelaciones(ComisionConfig comisionconfig,List<ComisionCate> comisioncates,List<ComisionMarca> comisionmarcas,List<ComisionLinea> comisionlineas,List<ComisionPena> comisionpenas,List<ComisionGrupo> comisiongrupos)throws Exception {

		if(!comisionconfig.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionConfigRelacionesBase(comisionconfig,comisioncates,comisionmarcas,comisionlineas,comisionpenas,comisiongrupos,false);
		}
	}

	public void saveComisionConfigRelacionesBase(ComisionConfig comisionconfig,List<ComisionCate> comisioncates,List<ComisionMarca> comisionmarcas,List<ComisionLinea> comisionlineas,List<ComisionPena> comisionpenas,List<ComisionGrupo> comisiongrupos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ComisionConfig-saveRelacionesWithConnection");}
	
			comisionconfig.setComisionCates(comisioncates);
			comisionconfig.setComisionMarcas(comisionmarcas);
			comisionconfig.setComisionLineas(comisionlineas);
			comisionconfig.setComisionPenas(comisionpenas);
			comisionconfig.setComisionGrupos(comisiongrupos);

			this.setComisionConfig(comisionconfig);

			if(ComisionConfigLogicAdditional.validarSaveRelaciones(comisionconfig,this)) {

				ComisionConfigLogicAdditional.updateRelacionesToSave(comisionconfig,this);

				if((comisionconfig.getIsNew()||comisionconfig.getIsChanged())&&!comisionconfig.getIsDeleted()) {
					this.saveComisionConfig();
					this.saveComisionConfigRelacionesDetalles(comisioncates,comisionmarcas,comisionlineas,comisionpenas,comisiongrupos);

				} else if(comisionconfig.getIsDeleted()) {
					this.saveComisionConfigRelacionesDetalles(comisioncates,comisionmarcas,comisionlineas,comisionpenas,comisiongrupos);
					this.saveComisionConfig();
				}

				ComisionConfigLogicAdditional.updateRelacionesToSaveAfter(comisionconfig,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ComisionCateConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionCates(comisioncates,true,true);
			ComisionMarcaConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionMarcas(comisionmarcas,true,true);
			ComisionLineaConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionLineas(comisionlineas,true,true);
			ComisionPenaConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionPenas(comisionpenas,true,true);
			ComisionGrupoConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionGrupos(comisiongrupos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveComisionConfigRelacionesDetalles(List<ComisionCate> comisioncates,List<ComisionMarca> comisionmarcas,List<ComisionLinea> comisionlineas,List<ComisionPena> comisionpenas,List<ComisionGrupo> comisiongrupos)throws Exception {
		try {
	

			Long idComisionConfigActual=this.getComisionConfig().getId();

			ComisionCateLogic comisioncateLogic_Desde_ComisionConfig=new ComisionCateLogic();
			comisioncateLogic_Desde_ComisionConfig.setComisionCates(comisioncates);

			comisioncateLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
			comisioncateLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

			for(ComisionCate comisioncate_Desde_ComisionConfig:comisioncateLogic_Desde_ComisionConfig.getComisionCates()) {
				comisioncate_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
			}

			comisioncateLogic_Desde_ComisionConfig.saveComisionCates();

			ComisionMarcaLogic comisionmarcaLogic_Desde_ComisionConfig=new ComisionMarcaLogic();
			comisionmarcaLogic_Desde_ComisionConfig.setComisionMarcas(comisionmarcas);

			comisionmarcaLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
			comisionmarcaLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

			for(ComisionMarca comisionmarca_Desde_ComisionConfig:comisionmarcaLogic_Desde_ComisionConfig.getComisionMarcas()) {
				comisionmarca_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
			}

			comisionmarcaLogic_Desde_ComisionConfig.saveComisionMarcas();

			ComisionLineaLogic comisionlineaLogic_Desde_ComisionConfig=new ComisionLineaLogic();
			comisionlineaLogic_Desde_ComisionConfig.setComisionLineas(comisionlineas);

			comisionlineaLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
			comisionlineaLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

			for(ComisionLinea comisionlinea_Desde_ComisionConfig:comisionlineaLogic_Desde_ComisionConfig.getComisionLineas()) {
				comisionlinea_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
			}

			comisionlineaLogic_Desde_ComisionConfig.saveComisionLineas();

			ComisionPenaLogic comisionpenaLogic_Desde_ComisionConfig=new ComisionPenaLogic();
			comisionpenaLogic_Desde_ComisionConfig.setComisionPenas(comisionpenas);

			comisionpenaLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
			comisionpenaLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

			for(ComisionPena comisionpena_Desde_ComisionConfig:comisionpenaLogic_Desde_ComisionConfig.getComisionPenas()) {
				comisionpena_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
			}

			comisionpenaLogic_Desde_ComisionConfig.saveComisionPenas();

			ComisionGrupoLogic comisiongrupoLogic_Desde_ComisionConfig=new ComisionGrupoLogic();
			comisiongrupoLogic_Desde_ComisionConfig.setComisionGrupos(comisiongrupos);

			comisiongrupoLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
			comisiongrupoLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

			for(ComisionGrupo comisiongrupo_Desde_ComisionConfig:comisiongrupoLogic_Desde_ComisionConfig.getComisionGrupos()) {
				comisiongrupo_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
			}

			comisiongrupoLogic_Desde_ComisionConfig.saveComisionGrupos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionConfigConstantesFunciones.getClassesForeignKeysOfComisionConfig(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionConfigConstantesFunciones.getClassesRelationshipsOfComisionConfig(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

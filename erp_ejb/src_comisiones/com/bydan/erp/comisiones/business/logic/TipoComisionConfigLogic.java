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
import com.bydan.erp.comisiones.util.TipoComisionConfigConstantesFunciones;
import com.bydan.erp.comisiones.util.TipoComisionConfigParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.TipoComisionConfigParameterGeneral;
import com.bydan.erp.comisiones.business.entity.TipoComisionConfig;
import com.bydan.erp.comisiones.business.logic.TipoComisionConfigLogicAdditional;
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
public class TipoComisionConfigLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoComisionConfigLogic.class);
	
	protected TipoComisionConfigDataAccess tipocomisionconfigDataAccess; 	
	protected TipoComisionConfig tipocomisionconfig;
	protected List<TipoComisionConfig> tipocomisionconfigs;
	protected Object tipocomisionconfigObject;	
	protected List<Object> tipocomisionconfigsObject;
	
	public static ClassValidator<TipoComisionConfig> tipocomisionconfigValidator = new ClassValidator<TipoComisionConfig>(TipoComisionConfig.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoComisionConfigLogicAdditional tipocomisionconfigLogicAdditional=null;
	
	public TipoComisionConfigLogicAdditional getTipoComisionConfigLogicAdditional() {
		return this.tipocomisionconfigLogicAdditional;
	}
	
	public void setTipoComisionConfigLogicAdditional(TipoComisionConfigLogicAdditional tipocomisionconfigLogicAdditional) {
		try {
			this.tipocomisionconfigLogicAdditional=tipocomisionconfigLogicAdditional;
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
	
	
	
	
	public  TipoComisionConfigLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocomisionconfigDataAccess = new TipoComisionConfigDataAccess();
			
			this.tipocomisionconfigs= new ArrayList<TipoComisionConfig>();
			this.tipocomisionconfig= new TipoComisionConfig();
			
			this.tipocomisionconfigObject=new Object();
			this.tipocomisionconfigsObject=new ArrayList<Object>();
				
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
			
			this.tipocomisionconfigDataAccess.setConnexionType(this.connexionType);
			this.tipocomisionconfigDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoComisionConfigLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocomisionconfigDataAccess = new TipoComisionConfigDataAccess();
			this.tipocomisionconfigs= new ArrayList<TipoComisionConfig>();
			this.tipocomisionconfig= new TipoComisionConfig();
			this.tipocomisionconfigObject=new Object();
			this.tipocomisionconfigsObject=new ArrayList<Object>();
			
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
			
			this.tipocomisionconfigDataAccess.setConnexionType(this.connexionType);
			this.tipocomisionconfigDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoComisionConfig getTipoComisionConfig() throws Exception {	
		TipoComisionConfigLogicAdditional.checkTipoComisionConfigToGet(tipocomisionconfig,this.datosCliente,this.arrDatoGeneral);
		TipoComisionConfigLogicAdditional.updateTipoComisionConfigToGet(tipocomisionconfig,this.arrDatoGeneral);
		
		return tipocomisionconfig;
	}
		
	public void setTipoComisionConfig(TipoComisionConfig newTipoComisionConfig) {
		this.tipocomisionconfig = newTipoComisionConfig;
	}
	
	public TipoComisionConfigDataAccess getTipoComisionConfigDataAccess() {
		return tipocomisionconfigDataAccess;
	}
	
	public void setTipoComisionConfigDataAccess(TipoComisionConfigDataAccess newtipocomisionconfigDataAccess) {
		this.tipocomisionconfigDataAccess = newtipocomisionconfigDataAccess;
	}
	
	public List<TipoComisionConfig> getTipoComisionConfigs() throws Exception {		
		this.quitarTipoComisionConfigsNulos();
		
		TipoComisionConfigLogicAdditional.checkTipoComisionConfigToGets(tipocomisionconfigs,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoComisionConfig tipocomisionconfigLocal: tipocomisionconfigs ) {
			TipoComisionConfigLogicAdditional.updateTipoComisionConfigToGet(tipocomisionconfigLocal,this.arrDatoGeneral);
		}
		
		return tipocomisionconfigs;
	}
	
	public void setTipoComisionConfigs(List<TipoComisionConfig> newTipoComisionConfigs) {
		this.tipocomisionconfigs = newTipoComisionConfigs;
	}
	
	public Object getTipoComisionConfigObject() {	
		this.tipocomisionconfigObject=this.tipocomisionconfigDataAccess.getEntityObject();
		return this.tipocomisionconfigObject;
	}
		
	public void setTipoComisionConfigObject(Object newTipoComisionConfigObject) {
		this.tipocomisionconfigObject = newTipoComisionConfigObject;
	}
	
	public List<Object> getTipoComisionConfigsObject() {		
		this.tipocomisionconfigsObject=this.tipocomisionconfigDataAccess.getEntitiesObject();
		return this.tipocomisionconfigsObject;
	}
		
	public void setTipoComisionConfigsObject(List<Object> newTipoComisionConfigsObject) {
		this.tipocomisionconfigsObject = newTipoComisionConfigsObject;
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
		
		if(this.tipocomisionconfigDataAccess!=null) {
			this.tipocomisionconfigDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocomisionconfigDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocomisionconfigDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocomisionconfig = new  TipoComisionConfig();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocomisionconfig=tipocomisionconfigDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocomisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfig);
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
		tipocomisionconfig = new  TipoComisionConfig();
		  		  
        try {
			
			tipocomisionconfig=tipocomisionconfigDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocomisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfig);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocomisionconfig = new  TipoComisionConfig();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocomisionconfig=tipocomisionconfigDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocomisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfig);
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
		tipocomisionconfig = new  TipoComisionConfig();
		  		  
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
		tipocomisionconfig = new  TipoComisionConfig();
		  		  
        try {
			
			tipocomisionconfig=tipocomisionconfigDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocomisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfig);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocomisionconfig = new  TipoComisionConfig();
		  		  
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
		tipocomisionconfig = new  TipoComisionConfig();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocomisionconfigDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocomisionconfig = new  TipoComisionConfig();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocomisionconfigDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocomisionconfig = new  TipoComisionConfig();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocomisionconfigDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocomisionconfig = new  TipoComisionConfig();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocomisionconfigDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocomisionconfig = new  TipoComisionConfig();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocomisionconfigDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocomisionconfig = new  TipoComisionConfig();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocomisionconfigDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
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
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		  		  
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
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		  		  
        try {			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		  		  
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
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
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
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		  		  
        try {
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
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
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
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
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocomisionconfig = new  TipoComisionConfig();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfig=tipocomisionconfigDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfig);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfig);
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
		tipocomisionconfig = new  TipoComisionConfig();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfig=tipocomisionconfigDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfig);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfig);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
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
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		  		  
        try {
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoComisionConfigsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getTodosTipoComisionConfigsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
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
	
	public  void  getTodosTipoComisionConfigs(String sFinalQuery,Pagination pagination)throws Exception {
		tipocomisionconfigs = new  ArrayList<TipoComisionConfig>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoComisionConfig(tipocomisionconfigs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoComisionConfig(TipoComisionConfig tipocomisionconfig) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocomisionconfig.getIsNew() || tipocomisionconfig.getIsChanged()) { 
			this.invalidValues = tipocomisionconfigValidator.getInvalidValues(tipocomisionconfig);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocomisionconfig);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoComisionConfig(List<TipoComisionConfig> TipoComisionConfigs) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoComisionConfig tipocomisionconfigLocal:tipocomisionconfigs) {				
			estaValidadoObjeto=this.validarGuardarTipoComisionConfig(tipocomisionconfigLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoComisionConfig(List<TipoComisionConfig> TipoComisionConfigs) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoComisionConfig(tipocomisionconfigs)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoComisionConfig(TipoComisionConfig TipoComisionConfig) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoComisionConfig(tipocomisionconfig)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoComisionConfig tipocomisionconfig) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocomisionconfig.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoComisionConfigConstantesFunciones.getTipoComisionConfigLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocomisionconfig","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoComisionConfigConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoComisionConfigConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoComisionConfigWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-saveTipoComisionConfigWithConnection");connexion.begin();			
			
			TipoComisionConfigLogicAdditional.checkTipoComisionConfigToSave(this.tipocomisionconfig,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoComisionConfigLogicAdditional.updateTipoComisionConfigToSave(this.tipocomisionconfig,this.arrDatoGeneral);
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocomisionconfig,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoComisionConfig();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoComisionConfig(this.tipocomisionconfig)) {
				TipoComisionConfigDataAccess.save(this.tipocomisionconfig, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocomisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoComisionConfigLogicAdditional.checkTipoComisionConfigToSaveAfter(this.tipocomisionconfig,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoComisionConfig();
			
			connexion.commit();			
			
			if(this.tipocomisionconfig.getIsDeleted()) {
				this.tipocomisionconfig=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoComisionConfig()throws Exception {	
		try {	
			
			TipoComisionConfigLogicAdditional.checkTipoComisionConfigToSave(this.tipocomisionconfig,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoComisionConfigLogicAdditional.updateTipoComisionConfigToSave(this.tipocomisionconfig,this.arrDatoGeneral);
			
			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocomisionconfig,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoComisionConfig(this.tipocomisionconfig)) {			
				TipoComisionConfigDataAccess.save(this.tipocomisionconfig, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocomisionconfig,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoComisionConfigLogicAdditional.checkTipoComisionConfigToSaveAfter(this.tipocomisionconfig,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocomisionconfig.getIsDeleted()) {
				this.tipocomisionconfig=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoComisionConfigsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-saveTipoComisionConfigsWithConnection");connexion.begin();			
			
			TipoComisionConfigLogicAdditional.checkTipoComisionConfigToSaves(tipocomisionconfigs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoComisionConfigs();
			
			Boolean validadoTodosTipoComisionConfig=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoComisionConfig tipocomisionconfigLocal:tipocomisionconfigs) {		
				if(tipocomisionconfigLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoComisionConfigLogicAdditional.updateTipoComisionConfigToSave(tipocomisionconfigLocal,this.arrDatoGeneral);
	        	
				TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocomisionconfigLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoComisionConfig(tipocomisionconfigLocal)) {
					TipoComisionConfigDataAccess.save(tipocomisionconfigLocal, connexion);				
				} else {
					validadoTodosTipoComisionConfig=false;
				}
			}
			
			if(!validadoTodosTipoComisionConfig) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoComisionConfigLogicAdditional.checkTipoComisionConfigToSavesAfter(tipocomisionconfigs,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoComisionConfigs();
			
			connexion.commit();		
			
			this.quitarTipoComisionConfigsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoComisionConfigs()throws Exception {				
		 try {	
			TipoComisionConfigLogicAdditional.checkTipoComisionConfigToSaves(tipocomisionconfigs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoComisionConfig=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoComisionConfig tipocomisionconfigLocal:tipocomisionconfigs) {				
				if(tipocomisionconfigLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoComisionConfigLogicAdditional.updateTipoComisionConfigToSave(tipocomisionconfigLocal,this.arrDatoGeneral);
	        	
				TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocomisionconfigLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoComisionConfig(tipocomisionconfigLocal)) {				
					TipoComisionConfigDataAccess.save(tipocomisionconfigLocal, connexion);				
				} else {
					validadoTodosTipoComisionConfig=false;
				}
			}
			
			if(!validadoTodosTipoComisionConfig) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoComisionConfigLogicAdditional.checkTipoComisionConfigToSavesAfter(tipocomisionconfigs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoComisionConfigsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoComisionConfigParameterReturnGeneral procesarAccionTipoComisionConfigs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoComisionConfig> tipocomisionconfigs,TipoComisionConfigParameterReturnGeneral tipocomisionconfigParameterGeneral)throws Exception {
		 try {	
			TipoComisionConfigParameterReturnGeneral tipocomisionconfigReturnGeneral=new TipoComisionConfigParameterReturnGeneral();
	
			TipoComisionConfigLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocomisionconfigs,tipocomisionconfigParameterGeneral,tipocomisionconfigReturnGeneral);
			
			return tipocomisionconfigReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoComisionConfigParameterReturnGeneral procesarAccionTipoComisionConfigsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoComisionConfig> tipocomisionconfigs,TipoComisionConfigParameterReturnGeneral tipocomisionconfigParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-procesarAccionTipoComisionConfigsWithConnection");connexion.begin();			
			
			TipoComisionConfigParameterReturnGeneral tipocomisionconfigReturnGeneral=new TipoComisionConfigParameterReturnGeneral();
	
			TipoComisionConfigLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocomisionconfigs,tipocomisionconfigParameterGeneral,tipocomisionconfigReturnGeneral);
			
			this.connexion.commit();
			
			return tipocomisionconfigReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoComisionConfigParameterReturnGeneral procesarEventosTipoComisionConfigs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoComisionConfig> tipocomisionconfigs,TipoComisionConfig tipocomisionconfig,TipoComisionConfigParameterReturnGeneral tipocomisionconfigParameterGeneral,Boolean isEsNuevoTipoComisionConfig,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoComisionConfigParameterReturnGeneral tipocomisionconfigReturnGeneral=new TipoComisionConfigParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocomisionconfigReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoComisionConfigLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocomisionconfigs,tipocomisionconfig,tipocomisionconfigParameterGeneral,tipocomisionconfigReturnGeneral,isEsNuevoTipoComisionConfig,clases);
			
			return tipocomisionconfigReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoComisionConfigParameterReturnGeneral procesarEventosTipoComisionConfigsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoComisionConfig> tipocomisionconfigs,TipoComisionConfig tipocomisionconfig,TipoComisionConfigParameterReturnGeneral tipocomisionconfigParameterGeneral,Boolean isEsNuevoTipoComisionConfig,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-procesarEventosTipoComisionConfigsWithConnection");connexion.begin();			
			
			TipoComisionConfigParameterReturnGeneral tipocomisionconfigReturnGeneral=new TipoComisionConfigParameterReturnGeneral();
	
			tipocomisionconfigReturnGeneral.setTipoComisionConfig(tipocomisionconfig);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocomisionconfigReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoComisionConfigLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocomisionconfigs,tipocomisionconfig,tipocomisionconfigParameterGeneral,tipocomisionconfigReturnGeneral,isEsNuevoTipoComisionConfig,clases);
			
			this.connexion.commit();
			
			return tipocomisionconfigReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoComisionConfigParameterReturnGeneral procesarImportacionTipoComisionConfigsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoComisionConfigParameterReturnGeneral tipocomisionconfigParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-procesarImportacionTipoComisionConfigsWithConnection");connexion.begin();			
			
			TipoComisionConfigParameterReturnGeneral tipocomisionconfigReturnGeneral=new TipoComisionConfigParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocomisionconfigs=new ArrayList<TipoComisionConfig>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocomisionconfig=new TipoComisionConfig();
				
				
				if(conColumnasBase) {this.tipocomisionconfig.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocomisionconfig.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocomisionconfig.setcodigo(arrColumnas[iColumn++]);
				this.tipocomisionconfig.setnombre(arrColumnas[iColumn++]);
				
				this.tipocomisionconfigs.add(this.tipocomisionconfig);
			}
			
			this.saveTipoComisionConfigs();
			
			this.connexion.commit();
			
			tipocomisionconfigReturnGeneral.setConRetornoEstaProcesado(true);
			tipocomisionconfigReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocomisionconfigReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoComisionConfigsEliminados() throws Exception {				
		
		List<TipoComisionConfig> tipocomisionconfigsAux= new ArrayList<TipoComisionConfig>();
		
		for(TipoComisionConfig tipocomisionconfig:tipocomisionconfigs) {
			if(!tipocomisionconfig.getIsDeleted()) {
				tipocomisionconfigsAux.add(tipocomisionconfig);
			}
		}
		
		tipocomisionconfigs=tipocomisionconfigsAux;
	}
	
	public void quitarTipoComisionConfigsNulos() throws Exception {				
		
		List<TipoComisionConfig> tipocomisionconfigsAux= new ArrayList<TipoComisionConfig>();
		
		for(TipoComisionConfig tipocomisionconfig : this.tipocomisionconfigs) {
			if(tipocomisionconfig==null) {
				tipocomisionconfigsAux.add(tipocomisionconfig);
			}
		}
		
		//this.tipocomisionconfigs=tipocomisionconfigsAux;
		
		this.tipocomisionconfigs.removeAll(tipocomisionconfigsAux);
	}
	
	public void getSetVersionRowTipoComisionConfigWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocomisionconfig.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocomisionconfig.getIsDeleted() || (tipocomisionconfig.getIsChanged()&&!tipocomisionconfig.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocomisionconfigDataAccess.getSetVersionRowTipoComisionConfig(connexion,tipocomisionconfig.getId());
				
				if(!tipocomisionconfig.getVersionRow().equals(timestamp)) {	
					tipocomisionconfig.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocomisionconfig.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoComisionConfig()throws Exception {	
		
		if(tipocomisionconfig.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocomisionconfig.getIsDeleted() || (tipocomisionconfig.getIsChanged()&&!tipocomisionconfig.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocomisionconfigDataAccess.getSetVersionRowTipoComisionConfig(connexion,tipocomisionconfig.getId());
			
			try {							
				if(!tipocomisionconfig.getVersionRow().equals(timestamp)) {	
					tipocomisionconfig.setVersionRow(timestamp);
				}
				
				tipocomisionconfig.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoComisionConfigsWithConnection()throws Exception {	
		if(tipocomisionconfigs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoComisionConfig tipocomisionconfigAux:tipocomisionconfigs) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocomisionconfigAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocomisionconfigAux.getIsDeleted() || (tipocomisionconfigAux.getIsChanged()&&!tipocomisionconfigAux.getIsNew())) {
						
						timestamp=tipocomisionconfigDataAccess.getSetVersionRowTipoComisionConfig(connexion,tipocomisionconfigAux.getId());
						
						if(!tipocomisionconfig.getVersionRow().equals(timestamp)) {	
							tipocomisionconfigAux.setVersionRow(timestamp);
						}
								
						tipocomisionconfigAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoComisionConfigs()throws Exception {	
		if(tipocomisionconfigs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoComisionConfig tipocomisionconfigAux:tipocomisionconfigs) {
					if(tipocomisionconfigAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocomisionconfigAux.getIsDeleted() || (tipocomisionconfigAux.getIsChanged()&&!tipocomisionconfigAux.getIsNew())) {
						
						timestamp=tipocomisionconfigDataAccess.getSetVersionRowTipoComisionConfig(connexion,tipocomisionconfigAux.getId());
						
						if(!tipocomisionconfigAux.getVersionRow().equals(timestamp)) {	
							tipocomisionconfigAux.setVersionRow(timestamp);
						}
						
													
						tipocomisionconfigAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoComisionConfigParameterReturnGeneral cargarCombosLoteForeignKeyTipoComisionConfigWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoComisionConfigParameterReturnGeneral  tipocomisionconfigReturnGeneral =new TipoComisionConfigParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoComisionConfigWithConnection");connexion.begin();
			
			tipocomisionconfigReturnGeneral =new TipoComisionConfigParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocomisionconfigReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocomisionconfigReturnGeneral;
	}
	
	public TipoComisionConfigParameterReturnGeneral cargarCombosLoteForeignKeyTipoComisionConfig(String finalQueryGlobalEmpresa) throws Exception {
		TipoComisionConfigParameterReturnGeneral  tipocomisionconfigReturnGeneral =new TipoComisionConfigParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocomisionconfigReturnGeneral =new TipoComisionConfigParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocomisionconfigReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocomisionconfigReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoComisionConfigWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoComisionConfigWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ComisionConfig.class));
											
			

			comisionconfigLogic.setConnexion(this.getConnexion());
			comisionconfigLogic.setDatosCliente(this.datosCliente);
			comisionconfigLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoComisionConfig tipocomisionconfig:this.tipocomisionconfigs) {
				

				classes=new ArrayList<Classe>();
				classes=ComisionConfigConstantesFunciones.getClassesForeignKeysOfComisionConfig(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionconfigLogic.setComisionConfigs(tipocomisionconfig.comisionconfigs);
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
	
	public void deepLoad(TipoComisionConfig tipocomisionconfig,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoComisionConfigLogicAdditional.updateTipoComisionConfigToGet(tipocomisionconfig,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocomisionconfig.setEmpresa(tipocomisionconfigDataAccess.getEmpresa(connexion,tipocomisionconfig));
		tipocomisionconfig.setComisionConfigs(tipocomisionconfigDataAccess.getComisionConfigs(connexion,tipocomisionconfig));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocomisionconfig.setEmpresa(tipocomisionconfigDataAccess.getEmpresa(connexion,tipocomisionconfig));
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocomisionconfig.setComisionConfigs(tipocomisionconfigDataAccess.getComisionConfigs(connexion,tipocomisionconfig));

				if(this.isConDeep) {
					ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(this.connexion);
					comisionconfigLogic.setComisionConfigs(tipocomisionconfig.getComisionConfigs());
					ArrayList<Classe> classesLocal=ComisionConfigConstantesFunciones.getClassesForeignKeysOfComisionConfig(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionconfigLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesComisionConfig(comisionconfigLogic.getComisionConfigs());
					tipocomisionconfig.setComisionConfigs(comisionconfigLogic.getComisionConfigs());
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
			tipocomisionconfig.setEmpresa(tipocomisionconfigDataAccess.getEmpresa(connexion,tipocomisionconfig));
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
			tipocomisionconfig.setComisionConfigs(tipocomisionconfigDataAccess.getComisionConfigs(connexion,tipocomisionconfig));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocomisionconfig.setEmpresa(tipocomisionconfigDataAccess.getEmpresa(connexion,tipocomisionconfig));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocomisionconfig.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipocomisionconfig.setComisionConfigs(tipocomisionconfigDataAccess.getComisionConfigs(connexion,tipocomisionconfig));

		for(ComisionConfig comisionconfig:tipocomisionconfig.getComisionConfigs()) {
			ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
			comisionconfigLogic.deepLoad(comisionconfig,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocomisionconfig.setEmpresa(tipocomisionconfigDataAccess.getEmpresa(connexion,tipocomisionconfig));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipocomisionconfig.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocomisionconfig.setComisionConfigs(tipocomisionconfigDataAccess.getComisionConfigs(connexion,tipocomisionconfig));

				for(ComisionConfig comisionconfig:tipocomisionconfig.getComisionConfigs()) {
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
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocomisionconfig.setEmpresa(tipocomisionconfigDataAccess.getEmpresa(connexion,tipocomisionconfig));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipocomisionconfig.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			tipocomisionconfig.setComisionConfigs(tipocomisionconfigDataAccess.getComisionConfigs(connexion,tipocomisionconfig));

			for(ComisionConfig comisionconfig:tipocomisionconfig.getComisionConfigs()) {
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
	
	public void deepSave(TipoComisionConfig tipocomisionconfig,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoComisionConfigLogicAdditional.updateTipoComisionConfigToSave(tipocomisionconfig,this.arrDatoGeneral);
			
TipoComisionConfigDataAccess.save(tipocomisionconfig, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocomisionconfig.getEmpresa(),connexion);

		for(ComisionConfig comisionconfig:tipocomisionconfig.getComisionConfigs()) {
			comisionconfig.setid_tipo_comision_config(tipocomisionconfig.getId());
			ComisionConfigDataAccess.save(comisionconfig,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocomisionconfig.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionConfig comisionconfig:tipocomisionconfig.getComisionConfigs()) {
					comisionconfig.setid_tipo_comision_config(tipocomisionconfig.getId());
					ComisionConfigDataAccess.save(comisionconfig,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocomisionconfig.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocomisionconfig.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ComisionConfig comisionconfig:tipocomisionconfig.getComisionConfigs()) {
			ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
			comisionconfig.setid_tipo_comision_config(tipocomisionconfig.getId());
			ComisionConfigDataAccess.save(comisionconfig,connexion);
			comisionconfigLogic.deepSave(comisionconfig,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocomisionconfig.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipocomisionconfig.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ComisionConfig.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionConfig comisionconfig:tipocomisionconfig.getComisionConfigs()) {
					ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
					comisionconfig.setid_tipo_comision_config(tipocomisionconfig.getId());
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
			this.getNewConnexionToDeep(TipoComisionConfig.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocomisionconfig,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(tipocomisionconfig);
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
			this.deepLoad(this.tipocomisionconfig,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfig);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoComisionConfig.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocomisionconfigs!=null) {
				for(TipoComisionConfig tipocomisionconfig:tipocomisionconfigs) {
					this.deepLoad(tipocomisionconfig,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(tipocomisionconfigs);
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
			if(tipocomisionconfigs!=null) {
				for(TipoComisionConfig tipocomisionconfig:tipocomisionconfigs) {
					this.deepLoad(tipocomisionconfig,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(tipocomisionconfigs);
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
			this.getNewConnexionToDeep(TipoComisionConfig.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocomisionconfig,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoComisionConfig.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocomisionconfigs!=null) {
				for(TipoComisionConfig tipocomisionconfig:tipocomisionconfigs) {
					this.deepSave(tipocomisionconfig,isDeep,deepLoadType,clases);
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
			if(tipocomisionconfigs!=null) {
				for(TipoComisionConfig tipocomisionconfig:tipocomisionconfigs) {
					this.deepSave(tipocomisionconfig,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoComisionConfigsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComisionConfig.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoComisionConfigConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoComisionConfigsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoComisionConfigConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoComisionConfigLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocomisionconfigs=tipocomisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoComisionConfigConstantesFunciones.refrescarForeignKeysDescripcionesTipoComisionConfig(this.tipocomisionconfigs);
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
			if(TipoComisionConfigConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoComisionConfigDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoComisionConfig tipocomisionconfig,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoComisionConfigConstantesFunciones.ISCONAUDITORIA) {
				if(tipocomisionconfig.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoComisionConfigDataAccess.TABLENAME, tipocomisionconfig.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoComisionConfigConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoComisionConfigLogic.registrarAuditoriaDetallesTipoComisionConfig(connexion,tipocomisionconfig,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocomisionconfig.getIsDeleted()) {
					/*if(!tipocomisionconfig.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoComisionConfigDataAccess.TABLENAME, tipocomisionconfig.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoComisionConfigLogic.registrarAuditoriaDetallesTipoComisionConfig(connexion,tipocomisionconfig,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoComisionConfigDataAccess.TABLENAME, tipocomisionconfig.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocomisionconfig.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoComisionConfigDataAccess.TABLENAME, tipocomisionconfig.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoComisionConfigConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoComisionConfigLogic.registrarAuditoriaDetallesTipoComisionConfig(connexion,tipocomisionconfig,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoComisionConfig(Connexion connexion,TipoComisionConfig tipocomisionconfig)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocomisionconfig.getIsNew()||!tipocomisionconfig.getid_empresa().equals(tipocomisionconfig.getTipoComisionConfigOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocomisionconfig.getTipoComisionConfigOriginal().getid_empresa()!=null)
				{
					strValorActual=tipocomisionconfig.getTipoComisionConfigOriginal().getid_empresa().toString();
				}
				if(tipocomisionconfig.getid_empresa()!=null)
				{
					strValorNuevo=tipocomisionconfig.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoComisionConfigConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipocomisionconfig.getIsNew()||!tipocomisionconfig.getcodigo().equals(tipocomisionconfig.getTipoComisionConfigOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocomisionconfig.getTipoComisionConfigOriginal().getcodigo()!=null)
				{
					strValorActual=tipocomisionconfig.getTipoComisionConfigOriginal().getcodigo();
				}
				if(tipocomisionconfig.getcodigo()!=null)
				{
					strValorNuevo=tipocomisionconfig.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoComisionConfigConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocomisionconfig.getIsNew()||!tipocomisionconfig.getnombre().equals(tipocomisionconfig.getTipoComisionConfigOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocomisionconfig.getTipoComisionConfigOriginal().getnombre()!=null)
				{
					strValorActual=tipocomisionconfig.getTipoComisionConfigOriginal().getnombre();
				}
				if(tipocomisionconfig.getnombre()!=null)
				{
					strValorNuevo=tipocomisionconfig.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoComisionConfigConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoComisionConfigRelacionesWithConnection(TipoComisionConfig tipocomisionconfig,List<ComisionConfig> comisionconfigs) throws Exception {

		if(!tipocomisionconfig.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoComisionConfigRelacionesBase(tipocomisionconfig,comisionconfigs,true);
		}
	}

	public void saveTipoComisionConfigRelaciones(TipoComisionConfig tipocomisionconfig,List<ComisionConfig> comisionconfigs)throws Exception {

		if(!tipocomisionconfig.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoComisionConfigRelacionesBase(tipocomisionconfig,comisionconfigs,false);
		}
	}

	public void saveTipoComisionConfigRelacionesBase(TipoComisionConfig tipocomisionconfig,List<ComisionConfig> comisionconfigs,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoComisionConfig-saveRelacionesWithConnection");}
	
			tipocomisionconfig.setComisionConfigs(comisionconfigs);

			this.setTipoComisionConfig(tipocomisionconfig);

			if(TipoComisionConfigLogicAdditional.validarSaveRelaciones(tipocomisionconfig,this)) {

				TipoComisionConfigLogicAdditional.updateRelacionesToSave(tipocomisionconfig,this);

				if((tipocomisionconfig.getIsNew()||tipocomisionconfig.getIsChanged())&&!tipocomisionconfig.getIsDeleted()) {
					this.saveTipoComisionConfig();
					this.saveTipoComisionConfigRelacionesDetalles(comisionconfigs);

				} else if(tipocomisionconfig.getIsDeleted()) {
					this.saveTipoComisionConfigRelacionesDetalles(comisionconfigs);
					this.saveTipoComisionConfig();
				}

				TipoComisionConfigLogicAdditional.updateRelacionesToSaveAfter(tipocomisionconfig,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ComisionConfigConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionConfigs(comisionconfigs,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoComisionConfigRelacionesDetalles(List<ComisionConfig> comisionconfigs)throws Exception {
		try {
	

			Long idTipoComisionConfigActual=this.getTipoComisionConfig().getId();

			ComisionConfigLogic comisionconfigLogic_Desde_TipoComisionConfig=new ComisionConfigLogic();
			comisionconfigLogic_Desde_TipoComisionConfig.setComisionConfigs(comisionconfigs);

			comisionconfigLogic_Desde_TipoComisionConfig.setConnexion(this.getConnexion());
			comisionconfigLogic_Desde_TipoComisionConfig.setDatosCliente(this.datosCliente);

			for(ComisionConfig comisionconfig_Desde_TipoComisionConfig:comisionconfigLogic_Desde_TipoComisionConfig.getComisionConfigs()) {
				comisionconfig_Desde_TipoComisionConfig.setid_tipo_comision_config(idTipoComisionConfigActual);

				comisionconfigLogic_Desde_TipoComisionConfig.setComisionConfig(comisionconfig_Desde_TipoComisionConfig);
				comisionconfigLogic_Desde_TipoComisionConfig.saveComisionConfig();

				Long idComisionConfigActual=comisionconfig_Desde_TipoComisionConfig.getId();

				ComisionCateLogic comisioncateLogic_Desde_ComisionConfig=new ComisionCateLogic();

				if(comisionconfig_Desde_TipoComisionConfig.getComisionCates()==null){
					comisionconfig_Desde_TipoComisionConfig.setComisionCates(new ArrayList<ComisionCate>());
				}

				comisioncateLogic_Desde_ComisionConfig.setComisionCates(comisionconfig_Desde_TipoComisionConfig.getComisionCates());

				comisioncateLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
				comisioncateLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

				for(ComisionCate comisioncate_Desde_ComisionConfig:comisioncateLogic_Desde_ComisionConfig.getComisionCates()) {
					comisioncate_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
				}

				comisioncateLogic_Desde_ComisionConfig.saveComisionCates();

				ComisionMarcaLogic comisionmarcaLogic_Desde_ComisionConfig=new ComisionMarcaLogic();

				if(comisionconfig_Desde_TipoComisionConfig.getComisionMarcas()==null){
					comisionconfig_Desde_TipoComisionConfig.setComisionMarcas(new ArrayList<ComisionMarca>());
				}

				comisionmarcaLogic_Desde_ComisionConfig.setComisionMarcas(comisionconfig_Desde_TipoComisionConfig.getComisionMarcas());

				comisionmarcaLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
				comisionmarcaLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

				for(ComisionMarca comisionmarca_Desde_ComisionConfig:comisionmarcaLogic_Desde_ComisionConfig.getComisionMarcas()) {
					comisionmarca_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
				}

				comisionmarcaLogic_Desde_ComisionConfig.saveComisionMarcas();

				ComisionLineaLogic comisionlineaLogic_Desde_ComisionConfig=new ComisionLineaLogic();

				if(comisionconfig_Desde_TipoComisionConfig.getComisionLineas()==null){
					comisionconfig_Desde_TipoComisionConfig.setComisionLineas(new ArrayList<ComisionLinea>());
				}

				comisionlineaLogic_Desde_ComisionConfig.setComisionLineas(comisionconfig_Desde_TipoComisionConfig.getComisionLineas());

				comisionlineaLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
				comisionlineaLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

				for(ComisionLinea comisionlinea_Desde_ComisionConfig:comisionlineaLogic_Desde_ComisionConfig.getComisionLineas()) {
					comisionlinea_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
				}

				comisionlineaLogic_Desde_ComisionConfig.saveComisionLineas();

				ComisionPenaLogic comisionpenaLogic_Desde_ComisionConfig=new ComisionPenaLogic();

				if(comisionconfig_Desde_TipoComisionConfig.getComisionPenas()==null){
					comisionconfig_Desde_TipoComisionConfig.setComisionPenas(new ArrayList<ComisionPena>());
				}

				comisionpenaLogic_Desde_ComisionConfig.setComisionPenas(comisionconfig_Desde_TipoComisionConfig.getComisionPenas());

				comisionpenaLogic_Desde_ComisionConfig.setConnexion(this.getConnexion());
				comisionpenaLogic_Desde_ComisionConfig.setDatosCliente(this.datosCliente);

				for(ComisionPena comisionpena_Desde_ComisionConfig:comisionpenaLogic_Desde_ComisionConfig.getComisionPenas()) {
					comisionpena_Desde_ComisionConfig.setid_comision_config(idComisionConfigActual);
				}

				comisionpenaLogic_Desde_ComisionConfig.saveComisionPenas();

				ComisionGrupoLogic comisiongrupoLogic_Desde_ComisionConfig=new ComisionGrupoLogic();

				if(comisionconfig_Desde_TipoComisionConfig.getComisionGrupos()==null){
					comisionconfig_Desde_TipoComisionConfig.setComisionGrupos(new ArrayList<ComisionGrupo>());
				}

				comisiongrupoLogic_Desde_ComisionConfig.setComisionGrupos(comisionconfig_Desde_TipoComisionConfig.getComisionGrupos());

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
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoComisionConfigConstantesFunciones.getClassesForeignKeysOfTipoComisionConfig(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoComisionConfigConstantesFunciones.getClassesRelationshipsOfTipoComisionConfig(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

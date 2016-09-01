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
import com.bydan.erp.seguridad.util.TipoImagenPersonaConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoImagenPersonaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoImagenPersonaParameterGeneral;
import com.bydan.erp.seguridad.business.entity.TipoImagenPersona;
//import com.bydan.erp.seguridad.business.logic.TipoImagenPersonaLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.cartera.util.*;


import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoImagenPersonaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoImagenPersonaLogic.class);
	
	protected TipoImagenPersonaDataAccess tipoimagenpersonaDataAccess; 	
	protected TipoImagenPersona tipoimagenpersona;
	protected List<TipoImagenPersona> tipoimagenpersonas;
	protected Object tipoimagenpersonaObject;	
	protected List<Object> tipoimagenpersonasObject;
	
	public static ClassValidator<TipoImagenPersona> tipoimagenpersonaValidator = new ClassValidator<TipoImagenPersona>(TipoImagenPersona.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoImagenPersonaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoimagenpersonaDataAccess = new TipoImagenPersonaDataAccess();
			
			this.tipoimagenpersonas= new ArrayList<TipoImagenPersona>();
			this.tipoimagenpersona= new TipoImagenPersona();
			
			this.tipoimagenpersonaObject=new Object();
			this.tipoimagenpersonasObject=new ArrayList<Object>();
				
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
			
			this.tipoimagenpersonaDataAccess.setConnexionType(this.connexionType);
			this.tipoimagenpersonaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoImagenPersonaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoimagenpersonaDataAccess = new TipoImagenPersonaDataAccess();
			this.tipoimagenpersonas= new ArrayList<TipoImagenPersona>();
			this.tipoimagenpersona= new TipoImagenPersona();
			this.tipoimagenpersonaObject=new Object();
			this.tipoimagenpersonasObject=new ArrayList<Object>();
			
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
			
			this.tipoimagenpersonaDataAccess.setConnexionType(this.connexionType);
			this.tipoimagenpersonaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoImagenPersona getTipoImagenPersona() throws Exception {	
		//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToGet(tipoimagenpersona,this.datosCliente,this.arrDatoGeneral);
		//TipoImagenPersonaLogicAdditional.updateTipoImagenPersonaToGet(tipoimagenpersona,this.arrDatoGeneral);
		
		return tipoimagenpersona;
	}
		
	public void setTipoImagenPersona(TipoImagenPersona newTipoImagenPersona) {
		this.tipoimagenpersona = newTipoImagenPersona;
	}
	
	public TipoImagenPersonaDataAccess getTipoImagenPersonaDataAccess() {
		return tipoimagenpersonaDataAccess;
	}
	
	public void setTipoImagenPersonaDataAccess(TipoImagenPersonaDataAccess newtipoimagenpersonaDataAccess) {
		this.tipoimagenpersonaDataAccess = newtipoimagenpersonaDataAccess;
	}
	
	public List<TipoImagenPersona> getTipoImagenPersonas() throws Exception {		
		this.quitarTipoImagenPersonasNulos();
		
		//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToGets(tipoimagenpersonas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoImagenPersona tipoimagenpersonaLocal: tipoimagenpersonas ) {
			//TipoImagenPersonaLogicAdditional.updateTipoImagenPersonaToGet(tipoimagenpersonaLocal,this.arrDatoGeneral);
		}
		
		return tipoimagenpersonas;
	}
	
	public void setTipoImagenPersonas(List<TipoImagenPersona> newTipoImagenPersonas) {
		this.tipoimagenpersonas = newTipoImagenPersonas;
	}
	
	public Object getTipoImagenPersonaObject() {	
		this.tipoimagenpersonaObject=this.tipoimagenpersonaDataAccess.getEntityObject();
		return this.tipoimagenpersonaObject;
	}
		
	public void setTipoImagenPersonaObject(Object newTipoImagenPersonaObject) {
		this.tipoimagenpersonaObject = newTipoImagenPersonaObject;
	}
	
	public List<Object> getTipoImagenPersonasObject() {		
		this.tipoimagenpersonasObject=this.tipoimagenpersonaDataAccess.getEntitiesObject();
		return this.tipoimagenpersonasObject;
	}
		
	public void setTipoImagenPersonasObject(List<Object> newTipoImagenPersonasObject) {
		this.tipoimagenpersonasObject = newTipoImagenPersonasObject;
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
		
		if(this.tipoimagenpersonaDataAccess!=null) {
			this.tipoimagenpersonaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoimagenpersonaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoimagenpersonaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoimagenpersona = new  TipoImagenPersona();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoimagenpersona=tipoimagenpersonaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoimagenpersona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersona);
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
		tipoimagenpersona = new  TipoImagenPersona();
		  		  
        try {
			
			tipoimagenpersona=tipoimagenpersonaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoimagenpersona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersona);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoimagenpersona = new  TipoImagenPersona();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoimagenpersona=tipoimagenpersonaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoimagenpersona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersona);
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
		tipoimagenpersona = new  TipoImagenPersona();
		  		  
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
		tipoimagenpersona = new  TipoImagenPersona();
		  		  
        try {
			
			tipoimagenpersona=tipoimagenpersonaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoimagenpersona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersona);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoimagenpersona = new  TipoImagenPersona();
		  		  
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
		tipoimagenpersona = new  TipoImagenPersona();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoimagenpersonaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoimagenpersona = new  TipoImagenPersona();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoimagenpersonaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoimagenpersona = new  TipoImagenPersona();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoimagenpersonaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoimagenpersona = new  TipoImagenPersona();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoimagenpersonaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoimagenpersona = new  TipoImagenPersona();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoimagenpersonaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoimagenpersona = new  TipoImagenPersona();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoimagenpersonaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersonas=tipoimagenpersonaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersonas);
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
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		  		  
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
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		  		  
        try {			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersonas=tipoimagenpersonaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersonas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		  		  
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
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersonas=tipoimagenpersonaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersonas);
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
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		  		  
        try {
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersonas=tipoimagenpersonaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersonas);
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
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersonas=tipoimagenpersonaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersonas);
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
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersonas=tipoimagenpersonaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersonas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoimagenpersona = new  TipoImagenPersona();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersona=tipoimagenpersonaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersona);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersona);
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
		tipoimagenpersona = new  TipoImagenPersona();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersona=tipoimagenpersonaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersona);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersona);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoImagenPersonasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-getTodosTipoImagenPersonasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersonas=tipoimagenpersonaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersonas);
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
	
	public  void  getTodosTipoImagenPersonas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoimagenpersonas = new  ArrayList<TipoImagenPersona>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoimagenpersonas=tipoimagenpersonaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoImagenPersona(tipoimagenpersonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersonas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoImagenPersona(TipoImagenPersona tipoimagenpersona) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoimagenpersona.getIsNew() || tipoimagenpersona.getIsChanged()) { 
			this.invalidValues = tipoimagenpersonaValidator.getInvalidValues(tipoimagenpersona);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoimagenpersona);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoImagenPersona(List<TipoImagenPersona> TipoImagenPersonas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoImagenPersona tipoimagenpersonaLocal:tipoimagenpersonas) {				
			estaValidadoObjeto=this.validarGuardarTipoImagenPersona(tipoimagenpersonaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoImagenPersona(List<TipoImagenPersona> TipoImagenPersonas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoImagenPersona(tipoimagenpersonas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoImagenPersona(TipoImagenPersona TipoImagenPersona) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoImagenPersona(tipoimagenpersona)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoImagenPersona tipoimagenpersona) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoimagenpersona.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoImagenPersonaConstantesFunciones.getTipoImagenPersonaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoimagenpersona","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoImagenPersonaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoImagenPersonaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoImagenPersonaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-saveTipoImagenPersonaWithConnection");connexion.begin();			
			
			//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToSave(this.tipoimagenpersona,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoImagenPersonaLogicAdditional.updateTipoImagenPersonaToSave(this.tipoimagenpersona,this.arrDatoGeneral);
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoimagenpersona,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoImagenPersona();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoImagenPersona(this.tipoimagenpersona)) {
				TipoImagenPersonaDataAccess.save(this.tipoimagenpersona, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoimagenpersona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToSaveAfter(this.tipoimagenpersona,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoImagenPersona();
			
			connexion.commit();			
			
			if(this.tipoimagenpersona.getIsDeleted()) {
				this.tipoimagenpersona=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoImagenPersona()throws Exception {	
		try {	
			
			//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToSave(this.tipoimagenpersona,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoImagenPersonaLogicAdditional.updateTipoImagenPersonaToSave(this.tipoimagenpersona,this.arrDatoGeneral);
			
			TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoimagenpersona,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoImagenPersona(this.tipoimagenpersona)) {			
				TipoImagenPersonaDataAccess.save(this.tipoimagenpersona, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoimagenpersona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToSaveAfter(this.tipoimagenpersona,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoimagenpersona.getIsDeleted()) {
				this.tipoimagenpersona=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoImagenPersonasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-saveTipoImagenPersonasWithConnection");connexion.begin();			
			
			//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToSaves(tipoimagenpersonas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoImagenPersonas();
			
			Boolean validadoTodosTipoImagenPersona=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoImagenPersona tipoimagenpersonaLocal:tipoimagenpersonas) {		
				if(tipoimagenpersonaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoImagenPersonaLogicAdditional.updateTipoImagenPersonaToSave(tipoimagenpersonaLocal,this.arrDatoGeneral);
	        	
				TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoimagenpersonaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoImagenPersona(tipoimagenpersonaLocal)) {
					TipoImagenPersonaDataAccess.save(tipoimagenpersonaLocal, connexion);				
				} else {
					validadoTodosTipoImagenPersona=false;
				}
			}
			
			if(!validadoTodosTipoImagenPersona) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToSavesAfter(tipoimagenpersonas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoImagenPersonas();
			
			connexion.commit();		
			
			this.quitarTipoImagenPersonasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoImagenPersonas()throws Exception {				
		 try {	
			//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToSaves(tipoimagenpersonas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoImagenPersona=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoImagenPersona tipoimagenpersonaLocal:tipoimagenpersonas) {				
				if(tipoimagenpersonaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoImagenPersonaLogicAdditional.updateTipoImagenPersonaToSave(tipoimagenpersonaLocal,this.arrDatoGeneral);
	        	
				TipoImagenPersonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoimagenpersonaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoImagenPersona(tipoimagenpersonaLocal)) {				
					TipoImagenPersonaDataAccess.save(tipoimagenpersonaLocal, connexion);				
				} else {
					validadoTodosTipoImagenPersona=false;
				}
			}
			
			if(!validadoTodosTipoImagenPersona) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoImagenPersonaLogicAdditional.checkTipoImagenPersonaToSavesAfter(tipoimagenpersonas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoImagenPersonasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoImagenPersonaParameterReturnGeneral procesarAccionTipoImagenPersonas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoImagenPersona> tipoimagenpersonas,TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaParameterGeneral)throws Exception {
		 try {	
			TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaReturnGeneral=new TipoImagenPersonaParameterReturnGeneral();
	
			
			return tipoimagenpersonaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoImagenPersonaParameterReturnGeneral procesarAccionTipoImagenPersonasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoImagenPersona> tipoimagenpersonas,TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-procesarAccionTipoImagenPersonasWithConnection");connexion.begin();			
			
			TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaReturnGeneral=new TipoImagenPersonaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoimagenpersonaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoImagenPersonaParameterReturnGeneral procesarEventosTipoImagenPersonas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoImagenPersona> tipoimagenpersonas,TipoImagenPersona tipoimagenpersona,TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaParameterGeneral,Boolean isEsNuevoTipoImagenPersona,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaReturnGeneral=new TipoImagenPersonaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoimagenpersonaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoimagenpersonaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoImagenPersonaParameterReturnGeneral procesarEventosTipoImagenPersonasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoImagenPersona> tipoimagenpersonas,TipoImagenPersona tipoimagenpersona,TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaParameterGeneral,Boolean isEsNuevoTipoImagenPersona,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-procesarEventosTipoImagenPersonasWithConnection");connexion.begin();			
			
			TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaReturnGeneral=new TipoImagenPersonaParameterReturnGeneral();
	
			tipoimagenpersonaReturnGeneral.setTipoImagenPersona(tipoimagenpersona);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoimagenpersonaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoimagenpersonaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoImagenPersonaParameterReturnGeneral procesarImportacionTipoImagenPersonasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoImagenPersona.class.getSimpleName()+"-procesarImportacionTipoImagenPersonasWithConnection");connexion.begin();			
			
			TipoImagenPersonaParameterReturnGeneral tipoimagenpersonaReturnGeneral=new TipoImagenPersonaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoimagenpersonas=new ArrayList<TipoImagenPersona>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoimagenpersona=new TipoImagenPersona();
				
				
				if(conColumnasBase) {this.tipoimagenpersona.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoimagenpersona.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoimagenpersona.setcodigo(arrColumnas[iColumn++]);
				this.tipoimagenpersona.setnombre(arrColumnas[iColumn++]);
				
				this.tipoimagenpersonas.add(this.tipoimagenpersona);
			}
			
			this.saveTipoImagenPersonas();
			
			this.connexion.commit();
			
			tipoimagenpersonaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoimagenpersonaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoimagenpersonaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoImagenPersonasEliminados() throws Exception {				
		
		List<TipoImagenPersona> tipoimagenpersonasAux= new ArrayList<TipoImagenPersona>();
		
		for(TipoImagenPersona tipoimagenpersona:tipoimagenpersonas) {
			if(!tipoimagenpersona.getIsDeleted()) {
				tipoimagenpersonasAux.add(tipoimagenpersona);
			}
		}
		
		tipoimagenpersonas=tipoimagenpersonasAux;
	}
	
	public void quitarTipoImagenPersonasNulos() throws Exception {				
		
		List<TipoImagenPersona> tipoimagenpersonasAux= new ArrayList<TipoImagenPersona>();
		
		for(TipoImagenPersona tipoimagenpersona : this.tipoimagenpersonas) {
			if(tipoimagenpersona==null) {
				tipoimagenpersonasAux.add(tipoimagenpersona);
			}
		}
		
		//this.tipoimagenpersonas=tipoimagenpersonasAux;
		
		this.tipoimagenpersonas.removeAll(tipoimagenpersonasAux);
	}
	
	public void getSetVersionRowTipoImagenPersonaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoimagenpersona.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoimagenpersona.getIsDeleted() || (tipoimagenpersona.getIsChanged()&&!tipoimagenpersona.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoimagenpersonaDataAccess.getSetVersionRowTipoImagenPersona(connexion,tipoimagenpersona.getId());
				
				if(!tipoimagenpersona.getVersionRow().equals(timestamp)) {	
					tipoimagenpersona.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoimagenpersona.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoImagenPersona()throws Exception {	
		
		if(tipoimagenpersona.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoimagenpersona.getIsDeleted() || (tipoimagenpersona.getIsChanged()&&!tipoimagenpersona.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoimagenpersonaDataAccess.getSetVersionRowTipoImagenPersona(connexion,tipoimagenpersona.getId());
			
			try {							
				if(!tipoimagenpersona.getVersionRow().equals(timestamp)) {	
					tipoimagenpersona.setVersionRow(timestamp);
				}
				
				tipoimagenpersona.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoImagenPersonasWithConnection()throws Exception {	
		if(tipoimagenpersonas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoImagenPersona tipoimagenpersonaAux:tipoimagenpersonas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoimagenpersonaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoimagenpersonaAux.getIsDeleted() || (tipoimagenpersonaAux.getIsChanged()&&!tipoimagenpersonaAux.getIsNew())) {
						
						timestamp=tipoimagenpersonaDataAccess.getSetVersionRowTipoImagenPersona(connexion,tipoimagenpersonaAux.getId());
						
						if(!tipoimagenpersona.getVersionRow().equals(timestamp)) {	
							tipoimagenpersonaAux.setVersionRow(timestamp);
						}
								
						tipoimagenpersonaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoImagenPersonas()throws Exception {	
		if(tipoimagenpersonas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoImagenPersona tipoimagenpersonaAux:tipoimagenpersonas) {
					if(tipoimagenpersonaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoimagenpersonaAux.getIsDeleted() || (tipoimagenpersonaAux.getIsChanged()&&!tipoimagenpersonaAux.getIsNew())) {
						
						timestamp=tipoimagenpersonaDataAccess.getSetVersionRowTipoImagenPersona(connexion,tipoimagenpersonaAux.getId());
						
						if(!tipoimagenpersonaAux.getVersionRow().equals(timestamp)) {	
							tipoimagenpersonaAux.setVersionRow(timestamp);
						}
						
													
						tipoimagenpersonaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoImagenPersona tipoimagenpersona,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoImagenPersonaLogicAdditional.updateTipoImagenPersonaToGet(tipoimagenpersona,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoImagenPersona tipoimagenpersona,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoImagenPersona.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoimagenpersona,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(tipoimagenpersona);
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
			this.deepLoad(this.tipoimagenpersona,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(this.tipoimagenpersona);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoImagenPersona.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoimagenpersonas!=null) {
				for(TipoImagenPersona tipoimagenpersona:tipoimagenpersonas) {
					this.deepLoad(tipoimagenpersona,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(tipoimagenpersonas);
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
			if(tipoimagenpersonas!=null) {
				for(TipoImagenPersona tipoimagenpersona:tipoimagenpersonas) {
					this.deepLoad(tipoimagenpersona,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoImagenPersonaConstantesFunciones.refrescarForeignKeysDescripcionesTipoImagenPersona(tipoimagenpersonas);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoImagenPersonaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoImagenPersonaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoImagenPersona tipoimagenpersona,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoImagenPersonaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoimagenpersona.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoImagenPersonaDataAccess.TABLENAME, tipoimagenpersona.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoImagenPersonaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoImagenPersonaLogic.registrarAuditoriaDetallesTipoImagenPersona(connexion,tipoimagenpersona,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoimagenpersona.getIsDeleted()) {
					/*if(!tipoimagenpersona.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoImagenPersonaDataAccess.TABLENAME, tipoimagenpersona.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoImagenPersonaLogic.registrarAuditoriaDetallesTipoImagenPersona(connexion,tipoimagenpersona,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoImagenPersonaDataAccess.TABLENAME, tipoimagenpersona.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoimagenpersona.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoImagenPersonaDataAccess.TABLENAME, tipoimagenpersona.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoImagenPersonaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoImagenPersonaLogic.registrarAuditoriaDetallesTipoImagenPersona(connexion,tipoimagenpersona,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoImagenPersona(Connexion connexion,TipoImagenPersona tipoimagenpersona)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoimagenpersona.getIsNew()||!tipoimagenpersona.getcodigo().equals(tipoimagenpersona.getTipoImagenPersonaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoimagenpersona.getTipoImagenPersonaOriginal().getcodigo()!=null)
				{
					strValorActual=tipoimagenpersona.getTipoImagenPersonaOriginal().getcodigo();
				}
				if(tipoimagenpersona.getcodigo()!=null)
				{
					strValorNuevo=tipoimagenpersona.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoImagenPersonaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoimagenpersona.getIsNew()||!tipoimagenpersona.getnombre().equals(tipoimagenpersona.getTipoImagenPersonaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoimagenpersona.getTipoImagenPersonaOriginal().getnombre()!=null)
				{
					strValorActual=tipoimagenpersona.getTipoImagenPersonaOriginal().getnombre();
				}
				if(tipoimagenpersona.getnombre()!=null)
				{
					strValorNuevo=tipoimagenpersona.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoImagenPersonaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoImagenPersona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoImagenPersonaConstantesFunciones.getClassesForeignKeysOfTipoImagenPersona(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoImagenPersona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoImagenPersonaConstantesFunciones.getClassesRelationshipsOfTipoImagenPersona(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

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
import com.bydan.erp.seguridad.util.HistorialCambioClaveConstantesFunciones;
import com.bydan.erp.seguridad.util.HistorialCambioClaveParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.HistorialCambioClaveParameterGeneral;
import com.bydan.erp.seguridad.business.entity.HistorialCambioClave;
import com.bydan.erp.seguridad.business.logic.HistorialCambioClaveLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class HistorialCambioClaveLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(HistorialCambioClaveLogic.class);
	
	protected HistorialCambioClaveDataAccess historialcambioclaveDataAccess; 	
	protected HistorialCambioClave historialcambioclave;
	protected List<HistorialCambioClave> historialcambioclaves;
	protected Object historialcambioclaveObject;	
	protected List<Object> historialcambioclavesObject;
	
	public static ClassValidator<HistorialCambioClave> historialcambioclaveValidator = new ClassValidator<HistorialCambioClave>(HistorialCambioClave.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected HistorialCambioClaveLogicAdditional historialcambioclaveLogicAdditional=null;
	
	public HistorialCambioClaveLogicAdditional getHistorialCambioClaveLogicAdditional() {
		return this.historialcambioclaveLogicAdditional;
	}
	
	public void setHistorialCambioClaveLogicAdditional(HistorialCambioClaveLogicAdditional historialcambioclaveLogicAdditional) {
		try {
			this.historialcambioclaveLogicAdditional=historialcambioclaveLogicAdditional;
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
	
	
	
	
	public  HistorialCambioClaveLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.historialcambioclaveDataAccess = new HistorialCambioClaveDataAccess();
			
			this.historialcambioclaves= new ArrayList<HistorialCambioClave>();
			this.historialcambioclave= new HistorialCambioClave();
			
			this.historialcambioclaveObject=new Object();
			this.historialcambioclavesObject=new ArrayList<Object>();
				
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
			
			this.historialcambioclaveDataAccess.setConnexionType(this.connexionType);
			this.historialcambioclaveDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  HistorialCambioClaveLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.historialcambioclaveDataAccess = new HistorialCambioClaveDataAccess();
			this.historialcambioclaves= new ArrayList<HistorialCambioClave>();
			this.historialcambioclave= new HistorialCambioClave();
			this.historialcambioclaveObject=new Object();
			this.historialcambioclavesObject=new ArrayList<Object>();
			
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
			
			this.historialcambioclaveDataAccess.setConnexionType(this.connexionType);
			this.historialcambioclaveDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public HistorialCambioClave getHistorialCambioClave() throws Exception {	
		HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToGet(historialcambioclave,this.datosCliente,this.arrDatoGeneral);
		HistorialCambioClaveLogicAdditional.updateHistorialCambioClaveToGet(historialcambioclave,this.arrDatoGeneral);
		
		return historialcambioclave;
	}
		
	public void setHistorialCambioClave(HistorialCambioClave newHistorialCambioClave) {
		this.historialcambioclave = newHistorialCambioClave;
	}
	
	public HistorialCambioClaveDataAccess getHistorialCambioClaveDataAccess() {
		return historialcambioclaveDataAccess;
	}
	
	public void setHistorialCambioClaveDataAccess(HistorialCambioClaveDataAccess newhistorialcambioclaveDataAccess) {
		this.historialcambioclaveDataAccess = newhistorialcambioclaveDataAccess;
	}
	
	public List<HistorialCambioClave> getHistorialCambioClaves() throws Exception {		
		this.quitarHistorialCambioClavesNulos();
		
		HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToGets(historialcambioclaves,this.datosCliente,this.arrDatoGeneral);
		
		for (HistorialCambioClave historialcambioclaveLocal: historialcambioclaves ) {
			HistorialCambioClaveLogicAdditional.updateHistorialCambioClaveToGet(historialcambioclaveLocal,this.arrDatoGeneral);
		}
		
		return historialcambioclaves;
	}
	
	public void setHistorialCambioClaves(List<HistorialCambioClave> newHistorialCambioClaves) {
		this.historialcambioclaves = newHistorialCambioClaves;
	}
	
	public Object getHistorialCambioClaveObject() {	
		this.historialcambioclaveObject=this.historialcambioclaveDataAccess.getEntityObject();
		return this.historialcambioclaveObject;
	}
		
	public void setHistorialCambioClaveObject(Object newHistorialCambioClaveObject) {
		this.historialcambioclaveObject = newHistorialCambioClaveObject;
	}
	
	public List<Object> getHistorialCambioClavesObject() {		
		this.historialcambioclavesObject=this.historialcambioclaveDataAccess.getEntitiesObject();
		return this.historialcambioclavesObject;
	}
		
	public void setHistorialCambioClavesObject(List<Object> newHistorialCambioClavesObject) {
		this.historialcambioclavesObject = newHistorialCambioClavesObject;
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
		
		if(this.historialcambioclaveDataAccess!=null) {
			this.historialcambioclaveDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			historialcambioclaveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			historialcambioclaveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		historialcambioclave = new  HistorialCambioClave();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialcambioclave=historialcambioclaveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialcambioclave,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclave);
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
		historialcambioclave = new  HistorialCambioClave();
		  		  
        try {
			
			historialcambioclave=historialcambioclaveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialcambioclave,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclave);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		historialcambioclave = new  HistorialCambioClave();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialcambioclave=historialcambioclaveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialcambioclave,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclave);
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
		historialcambioclave = new  HistorialCambioClave();
		  		  
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
		historialcambioclave = new  HistorialCambioClave();
		  		  
        try {
			
			historialcambioclave=historialcambioclaveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialcambioclave,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclave);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		historialcambioclave = new  HistorialCambioClave();
		  		  
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
		historialcambioclave = new  HistorialCambioClave();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =historialcambioclaveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialcambioclave = new  HistorialCambioClave();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=historialcambioclaveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialcambioclave = new  HistorialCambioClave();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =historialcambioclaveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialcambioclave = new  HistorialCambioClave();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=historialcambioclaveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialcambioclave = new  HistorialCambioClave();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =historialcambioclaveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialcambioclave = new  HistorialCambioClave();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=historialcambioclaveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
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
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		  		  
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
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		  		  
        try {			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		  		  
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
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
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
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		  		  
        try {
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
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
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
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
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		historialcambioclave = new  HistorialCambioClave();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclave=historialcambioclaveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclave);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclave);
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
		historialcambioclave = new  HistorialCambioClave();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclave=historialcambioclaveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclave);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclave);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
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
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		  		  
        try {
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosHistorialCambioClavesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getTodosHistorialCambioClavesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
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
	
	public  void  getTodosHistorialCambioClaves(String sFinalQuery,Pagination pagination)throws Exception {
		historialcambioclaves = new  ArrayList<HistorialCambioClave>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialCambioClave(historialcambioclaves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarHistorialCambioClave(HistorialCambioClave historialcambioclave) throws Exception {
		Boolean estaValidado=false;
		
		if(historialcambioclave.getIsNew() || historialcambioclave.getIsChanged()) { 
			this.invalidValues = historialcambioclaveValidator.getInvalidValues(historialcambioclave);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(historialcambioclave);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarHistorialCambioClave(List<HistorialCambioClave> HistorialCambioClaves) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(HistorialCambioClave historialcambioclaveLocal:historialcambioclaves) {				
			estaValidadoObjeto=this.validarGuardarHistorialCambioClave(historialcambioclaveLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarHistorialCambioClave(List<HistorialCambioClave> HistorialCambioClaves) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialCambioClave(historialcambioclaves)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarHistorialCambioClave(HistorialCambioClave HistorialCambioClave) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialCambioClave(historialcambioclave)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(HistorialCambioClave historialcambioclave) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+historialcambioclave.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=HistorialCambioClaveConstantesFunciones.getHistorialCambioClaveLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"historialcambioclave","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(HistorialCambioClaveConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(HistorialCambioClaveConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveHistorialCambioClaveWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-saveHistorialCambioClaveWithConnection");connexion.begin();			
			
			HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToSave(this.historialcambioclave,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialCambioClaveLogicAdditional.updateHistorialCambioClaveToSave(this.historialcambioclave,this.arrDatoGeneral);
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialcambioclave,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowHistorialCambioClave();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialCambioClave(this.historialcambioclave)) {
				HistorialCambioClaveDataAccess.save(this.historialcambioclave, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.historialcambioclave,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToSaveAfter(this.historialcambioclave,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialCambioClave();
			
			connexion.commit();			
			
			if(this.historialcambioclave.getIsDeleted()) {
				this.historialcambioclave=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveHistorialCambioClave()throws Exception {	
		try {	
			
			HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToSave(this.historialcambioclave,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialCambioClaveLogicAdditional.updateHistorialCambioClaveToSave(this.historialcambioclave,this.arrDatoGeneral);
			
			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialcambioclave,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialCambioClave(this.historialcambioclave)) {			
				HistorialCambioClaveDataAccess.save(this.historialcambioclave, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.historialcambioclave,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToSaveAfter(this.historialcambioclave,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.historialcambioclave.getIsDeleted()) {
				this.historialcambioclave=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveHistorialCambioClavesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-saveHistorialCambioClavesWithConnection");connexion.begin();			
			
			HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToSaves(historialcambioclaves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowHistorialCambioClaves();
			
			Boolean validadoTodosHistorialCambioClave=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialCambioClave historialcambioclaveLocal:historialcambioclaves) {		
				if(historialcambioclaveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialCambioClaveLogicAdditional.updateHistorialCambioClaveToSave(historialcambioclaveLocal,this.arrDatoGeneral);
	        	
				HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialcambioclaveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialCambioClave(historialcambioclaveLocal)) {
					HistorialCambioClaveDataAccess.save(historialcambioclaveLocal, connexion);				
				} else {
					validadoTodosHistorialCambioClave=false;
				}
			}
			
			if(!validadoTodosHistorialCambioClave) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToSavesAfter(historialcambioclaves,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialCambioClaves();
			
			connexion.commit();		
			
			this.quitarHistorialCambioClavesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveHistorialCambioClaves()throws Exception {				
		 try {	
			HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToSaves(historialcambioclaves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosHistorialCambioClave=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialCambioClave historialcambioclaveLocal:historialcambioclaves) {				
				if(historialcambioclaveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialCambioClaveLogicAdditional.updateHistorialCambioClaveToSave(historialcambioclaveLocal,this.arrDatoGeneral);
	        	
				HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialcambioclaveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialCambioClave(historialcambioclaveLocal)) {				
					HistorialCambioClaveDataAccess.save(historialcambioclaveLocal, connexion);				
				} else {
					validadoTodosHistorialCambioClave=false;
				}
			}
			
			if(!validadoTodosHistorialCambioClave) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialCambioClaveLogicAdditional.checkHistorialCambioClaveToSavesAfter(historialcambioclaves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarHistorialCambioClavesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialCambioClaveParameterReturnGeneral procesarAccionHistorialCambioClaves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialCambioClave> historialcambioclaves,HistorialCambioClaveParameterReturnGeneral historialcambioclaveParameterGeneral)throws Exception {
		 try {	
			HistorialCambioClaveParameterReturnGeneral historialcambioclaveReturnGeneral=new HistorialCambioClaveParameterReturnGeneral();
	
			HistorialCambioClaveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialcambioclaves,historialcambioclaveParameterGeneral,historialcambioclaveReturnGeneral);
			
			return historialcambioclaveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialCambioClaveParameterReturnGeneral procesarAccionHistorialCambioClavesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialCambioClave> historialcambioclaves,HistorialCambioClaveParameterReturnGeneral historialcambioclaveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-procesarAccionHistorialCambioClavesWithConnection");connexion.begin();			
			
			HistorialCambioClaveParameterReturnGeneral historialcambioclaveReturnGeneral=new HistorialCambioClaveParameterReturnGeneral();
	
			HistorialCambioClaveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialcambioclaves,historialcambioclaveParameterGeneral,historialcambioclaveReturnGeneral);
			
			this.connexion.commit();
			
			return historialcambioclaveReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialCambioClaveParameterReturnGeneral procesarEventosHistorialCambioClaves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialCambioClave> historialcambioclaves,HistorialCambioClave historialcambioclave,HistorialCambioClaveParameterReturnGeneral historialcambioclaveParameterGeneral,Boolean isEsNuevoHistorialCambioClave,ArrayList<Classe> clases)throws Exception {
		 try {	
			HistorialCambioClaveParameterReturnGeneral historialcambioclaveReturnGeneral=new HistorialCambioClaveParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialcambioclaveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialCambioClaveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialcambioclaves,historialcambioclave,historialcambioclaveParameterGeneral,historialcambioclaveReturnGeneral,isEsNuevoHistorialCambioClave,clases);
			
			return historialcambioclaveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public HistorialCambioClaveParameterReturnGeneral procesarEventosHistorialCambioClavesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialCambioClave> historialcambioclaves,HistorialCambioClave historialcambioclave,HistorialCambioClaveParameterReturnGeneral historialcambioclaveParameterGeneral,Boolean isEsNuevoHistorialCambioClave,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-procesarEventosHistorialCambioClavesWithConnection");connexion.begin();			
			
			HistorialCambioClaveParameterReturnGeneral historialcambioclaveReturnGeneral=new HistorialCambioClaveParameterReturnGeneral();
	
			historialcambioclaveReturnGeneral.setHistorialCambioClave(historialcambioclave);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialcambioclaveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialCambioClaveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialcambioclaves,historialcambioclave,historialcambioclaveParameterGeneral,historialcambioclaveReturnGeneral,isEsNuevoHistorialCambioClave,clases);
			
			this.connexion.commit();
			
			return historialcambioclaveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialCambioClaveParameterReturnGeneral procesarImportacionHistorialCambioClavesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,HistorialCambioClaveParameterReturnGeneral historialcambioclaveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-procesarImportacionHistorialCambioClavesWithConnection");connexion.begin();			
			
			HistorialCambioClaveParameterReturnGeneral historialcambioclaveReturnGeneral=new HistorialCambioClaveParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.historialcambioclaves=new ArrayList<HistorialCambioClave>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.historialcambioclave=new HistorialCambioClave();
				
				
				if(conColumnasBase) {this.historialcambioclave.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.historialcambioclave.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.historialcambioclave.setnombre(arrColumnas[iColumn++]);
				//this.historialcambioclave.setfecha_hora(new Timestamp(arrColumnas[iColumn++].getTime()));
				this.historialcambioclave.setobservacion(arrColumnas[iColumn++]);
				
				this.historialcambioclaves.add(this.historialcambioclave);
			}
			
			this.saveHistorialCambioClaves();
			
			this.connexion.commit();
			
			historialcambioclaveReturnGeneral.setConRetornoEstaProcesado(true);
			historialcambioclaveReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return historialcambioclaveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarHistorialCambioClavesEliminados() throws Exception {				
		
		List<HistorialCambioClave> historialcambioclavesAux= new ArrayList<HistorialCambioClave>();
		
		for(HistorialCambioClave historialcambioclave:historialcambioclaves) {
			if(!historialcambioclave.getIsDeleted()) {
				historialcambioclavesAux.add(historialcambioclave);
			}
		}
		
		historialcambioclaves=historialcambioclavesAux;
	}
	
	public void quitarHistorialCambioClavesNulos() throws Exception {				
		
		List<HistorialCambioClave> historialcambioclavesAux= new ArrayList<HistorialCambioClave>();
		
		for(HistorialCambioClave historialcambioclave : this.historialcambioclaves) {
			if(historialcambioclave==null) {
				historialcambioclavesAux.add(historialcambioclave);
			}
		}
		
		//this.historialcambioclaves=historialcambioclavesAux;
		
		this.historialcambioclaves.removeAll(historialcambioclavesAux);
	}
	
	public void getSetVersionRowHistorialCambioClaveWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(historialcambioclave.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((historialcambioclave.getIsDeleted() || (historialcambioclave.getIsChanged()&&!historialcambioclave.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=historialcambioclaveDataAccess.getSetVersionRowHistorialCambioClave(connexion,historialcambioclave.getId());
				
				if(!historialcambioclave.getVersionRow().equals(timestamp)) {	
					historialcambioclave.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				historialcambioclave.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowHistorialCambioClave()throws Exception {	
		
		if(historialcambioclave.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((historialcambioclave.getIsDeleted() || (historialcambioclave.getIsChanged()&&!historialcambioclave.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=historialcambioclaveDataAccess.getSetVersionRowHistorialCambioClave(connexion,historialcambioclave.getId());
			
			try {							
				if(!historialcambioclave.getVersionRow().equals(timestamp)) {	
					historialcambioclave.setVersionRow(timestamp);
				}
				
				historialcambioclave.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowHistorialCambioClavesWithConnection()throws Exception {	
		if(historialcambioclaves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(HistorialCambioClave historialcambioclaveAux:historialcambioclaves) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(historialcambioclaveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialcambioclaveAux.getIsDeleted() || (historialcambioclaveAux.getIsChanged()&&!historialcambioclaveAux.getIsNew())) {
						
						timestamp=historialcambioclaveDataAccess.getSetVersionRowHistorialCambioClave(connexion,historialcambioclaveAux.getId());
						
						if(!historialcambioclave.getVersionRow().equals(timestamp)) {	
							historialcambioclaveAux.setVersionRow(timestamp);
						}
								
						historialcambioclaveAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowHistorialCambioClaves()throws Exception {	
		if(historialcambioclaves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(HistorialCambioClave historialcambioclaveAux:historialcambioclaves) {
					if(historialcambioclaveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialcambioclaveAux.getIsDeleted() || (historialcambioclaveAux.getIsChanged()&&!historialcambioclaveAux.getIsNew())) {
						
						timestamp=historialcambioclaveDataAccess.getSetVersionRowHistorialCambioClave(connexion,historialcambioclaveAux.getId());
						
						if(!historialcambioclaveAux.getVersionRow().equals(timestamp)) {	
							historialcambioclaveAux.setVersionRow(timestamp);
						}
						
													
						historialcambioclaveAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public HistorialCambioClaveParameterReturnGeneral cargarCombosLoteForeignKeyHistorialCambioClaveWithConnection(String finalQueryGlobalUsuario) throws Exception {
		HistorialCambioClaveParameterReturnGeneral  historialcambioclaveReturnGeneral =new HistorialCambioClaveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-cargarCombosLoteForeignKeyHistorialCambioClaveWithConnection");connexion.begin();
			
			historialcambioclaveReturnGeneral =new HistorialCambioClaveParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			historialcambioclaveReturnGeneral.setusuariosForeignKey(usuariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return historialcambioclaveReturnGeneral;
	}
	
	public HistorialCambioClaveParameterReturnGeneral cargarCombosLoteForeignKeyHistorialCambioClave(String finalQueryGlobalUsuario) throws Exception {
		HistorialCambioClaveParameterReturnGeneral  historialcambioclaveReturnGeneral =new HistorialCambioClaveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			historialcambioclaveReturnGeneral =new HistorialCambioClaveParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			historialcambioclaveReturnGeneral.setusuariosForeignKey(usuariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return historialcambioclaveReturnGeneral;
	}
	
	
	public void deepLoad(HistorialCambioClave historialcambioclave,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			HistorialCambioClaveLogicAdditional.updateHistorialCambioClaveToGet(historialcambioclave,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialcambioclave.setUsuario(historialcambioclaveDataAccess.getUsuario(connexion,historialcambioclave));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				historialcambioclave.setUsuario(historialcambioclaveDataAccess.getUsuario(connexion,historialcambioclave));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialcambioclave.setUsuario(historialcambioclaveDataAccess.getUsuario(connexion,historialcambioclave));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialcambioclave.setUsuario(historialcambioclaveDataAccess.getUsuario(connexion,historialcambioclave));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(historialcambioclave.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				historialcambioclave.setUsuario(historialcambioclaveDataAccess.getUsuario(connexion,historialcambioclave));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(historialcambioclave.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialcambioclave.setUsuario(historialcambioclaveDataAccess.getUsuario(connexion,historialcambioclave));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(historialcambioclave.getUsuario(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(HistorialCambioClave historialcambioclave,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			HistorialCambioClaveLogicAdditional.updateHistorialCambioClaveToSave(historialcambioclave,this.arrDatoGeneral);
			
HistorialCambioClaveDataAccess.save(historialcambioclave, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(historialcambioclave.getUsuario(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(historialcambioclave.getUsuario(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(historialcambioclave.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(historialcambioclave.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(historialcambioclave.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(historialcambioclave.getUsuario(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(HistorialCambioClave.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(historialcambioclave,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(historialcambioclave);
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
			this.deepLoad(this.historialcambioclave,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclave);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(HistorialCambioClave.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(historialcambioclaves!=null) {
				for(HistorialCambioClave historialcambioclave:historialcambioclaves) {
					this.deepLoad(historialcambioclave,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(historialcambioclaves);
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
			if(historialcambioclaves!=null) {
				for(HistorialCambioClave historialcambioclave:historialcambioclaves) {
					this.deepLoad(historialcambioclave,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(historialcambioclaves);
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
			this.getNewConnexionToDeep(HistorialCambioClave.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(historialcambioclave,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(HistorialCambioClave.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(historialcambioclaves!=null) {
				for(HistorialCambioClave historialcambioclave:historialcambioclaves) {
					this.deepSave(historialcambioclave,isDeep,deepLoadType,clases);
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
			if(historialcambioclaves!=null) {
				for(HistorialCambioClave historialcambioclave:historialcambioclaves) {
					this.deepSave(historialcambioclave,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getHistorialCambioClavesBusquedaPorIdUsuarioPorFechaHoraWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario,Timestamp fecha_hora)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,HistorialCambioClaveConstantesFunciones.IDUSUARIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralEqual(ParameterType.TIMESTAMP,fecha_hora,HistorialCambioClaveConstantesFunciones.FECHAHORA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdUsuarioPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialCambioClavesBusquedaPorIdUsuarioPorFechaHora(String sFinalQuery,Pagination pagination,Long id_usuario,Timestamp fecha_hora)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,HistorialCambioClaveConstantesFunciones.IDUSUARIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralEqual(ParameterType.TIMESTAMP,fecha_hora,HistorialCambioClaveConstantesFunciones.FECHAHORA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdUsuarioPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialCambioClavesFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialCambioClave.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,HistorialCambioClaveConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialCambioClavesFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,HistorialCambioClaveConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			HistorialCambioClaveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(this.historialcambioclaves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(HistorialCambioClaveConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialCambioClaveDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,HistorialCambioClave historialcambioclave,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(HistorialCambioClaveConstantesFunciones.ISCONAUDITORIA) {
				if(historialcambioclave.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialCambioClaveDataAccess.TABLENAME, historialcambioclave.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialCambioClaveConstantesFunciones.ISCONAUDITORIADETALLE) {
						//HistorialCambioClaveLogic.registrarAuditoriaDetallesHistorialCambioClave(connexion,historialcambioclave,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(historialcambioclave.getIsDeleted()) {
					/*if(!historialcambioclave.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,HistorialCambioClaveDataAccess.TABLENAME, historialcambioclave.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//HistorialCambioClaveLogic.registrarAuditoriaDetallesHistorialCambioClave(connexion,historialcambioclave,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialCambioClaveDataAccess.TABLENAME, historialcambioclave.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(historialcambioclave.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialCambioClaveDataAccess.TABLENAME, historialcambioclave.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialCambioClaveConstantesFunciones.ISCONAUDITORIADETALLE) {
						//HistorialCambioClaveLogic.registrarAuditoriaDetallesHistorialCambioClave(connexion,historialcambioclave,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesHistorialCambioClave(Connexion connexion,HistorialCambioClave historialcambioclave)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(historialcambioclave.getIsNew()||!historialcambioclave.getid_usuario().equals(historialcambioclave.getHistorialCambioClaveOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialcambioclave.getHistorialCambioClaveOriginal().getid_usuario()!=null)
				{
					strValorActual=historialcambioclave.getHistorialCambioClaveOriginal().getid_usuario().toString();
				}
				if(historialcambioclave.getid_usuario()!=null)
				{
					strValorNuevo=historialcambioclave.getid_usuario().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialCambioClaveConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(historialcambioclave.getIsNew()||!historialcambioclave.getnombre().equals(historialcambioclave.getHistorialCambioClaveOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialcambioclave.getHistorialCambioClaveOriginal().getnombre()!=null)
				{
					strValorActual=historialcambioclave.getHistorialCambioClaveOriginal().getnombre();
				}
				if(historialcambioclave.getnombre()!=null)
				{
					strValorNuevo=historialcambioclave.getnombre() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialCambioClaveConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(historialcambioclave.getIsNew()||!historialcambioclave.getfecha_hora().equals(historialcambioclave.getHistorialCambioClaveOriginal().getfecha_hora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialcambioclave.getHistorialCambioClaveOriginal().getfecha_hora()!=null)
				{
					strValorActual=historialcambioclave.getHistorialCambioClaveOriginal().getfecha_hora().toString();
				}
				if(historialcambioclave.getfecha_hora()!=null)
				{
					strValorNuevo=historialcambioclave.getfecha_hora().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialCambioClaveConstantesFunciones.FECHAHORA,strValorActual,strValorNuevo);
			}	
			
			if(historialcambioclave.getIsNew()||!historialcambioclave.getobservacion().equals(historialcambioclave.getHistorialCambioClaveOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialcambioclave.getHistorialCambioClaveOriginal().getobservacion()!=null)
				{
					strValorActual=historialcambioclave.getHistorialCambioClaveOriginal().getobservacion();
				}
				if(historialcambioclave.getobservacion()!=null)
				{
					strValorNuevo=historialcambioclave.getobservacion() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialCambioClaveConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveHistorialCambioClaveRelacionesWithConnection(HistorialCambioClave historialcambioclave) throws Exception {

		if(!historialcambioclave.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialCambioClaveRelacionesBase(historialcambioclave,true);
		}
	}

	public void saveHistorialCambioClaveRelaciones(HistorialCambioClave historialcambioclave)throws Exception {

		if(!historialcambioclave.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialCambioClaveRelacionesBase(historialcambioclave,false);
		}
	}

	public void saveHistorialCambioClaveRelacionesBase(HistorialCambioClave historialcambioclave,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("HistorialCambioClave-saveRelacionesWithConnection");}
	

			this.setHistorialCambioClave(historialcambioclave);

			if(HistorialCambioClaveLogicAdditional.validarSaveRelaciones(historialcambioclave,this)) {

				HistorialCambioClaveLogicAdditional.updateRelacionesToSave(historialcambioclave,this);

				if((historialcambioclave.getIsNew()||historialcambioclave.getIsChanged())&&!historialcambioclave.getIsDeleted()) {
					this.saveHistorialCambioClave();
					this.saveHistorialCambioClaveRelacionesDetalles();

				} else if(historialcambioclave.getIsDeleted()) {
					this.saveHistorialCambioClaveRelacionesDetalles();
					this.saveHistorialCambioClave();
				}

				HistorialCambioClaveLogicAdditional.updateRelacionesToSaveAfter(historialcambioclave,this);

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
	
	
	private void saveHistorialCambioClaveRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialCambioClave(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialCambioClaveConstantesFunciones.getClassesForeignKeysOfHistorialCambioClave(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialCambioClave(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialCambioClaveConstantesFunciones.getClassesRelationshipsOfHistorialCambioClave(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

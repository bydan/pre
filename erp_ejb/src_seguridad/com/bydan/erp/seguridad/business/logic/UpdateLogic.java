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
import com.bydan.erp.seguridad.util.UpdateConstantesFunciones;
import com.bydan.erp.seguridad.util.UpdateParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.UpdateParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Update;
import com.bydan.erp.seguridad.business.logic.UpdateLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class UpdateLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(UpdateLogic.class);
	
	protected UpdateDataAccess updateDataAccess; 	
	protected Update update;
	protected List<Update> updates;
	protected Object updateObject;	
	protected List<Object> updatesObject;
	
	public static ClassValidator<Update> updateValidator = new ClassValidator<Update>(Update.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected UpdateLogicAdditional updateLogicAdditional=null;
	
	public UpdateLogicAdditional getUpdateLogicAdditional() {
		return this.updateLogicAdditional;
	}
	
	public void setUpdateLogicAdditional(UpdateLogicAdditional updateLogicAdditional) {
		try {
			this.updateLogicAdditional=updateLogicAdditional;
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
	
	
	
	
	public  UpdateLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.updateDataAccess = new UpdateDataAccess();
			
			this.updates= new ArrayList<Update>();
			this.update= new Update();
			
			this.updateObject=new Object();
			this.updatesObject=new ArrayList<Object>();
				
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
			
			this.updateDataAccess.setConnexionType(this.connexionType);
			this.updateDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  UpdateLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.updateDataAccess = new UpdateDataAccess();
			this.updates= new ArrayList<Update>();
			this.update= new Update();
			this.updateObject=new Object();
			this.updatesObject=new ArrayList<Object>();
			
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
			
			this.updateDataAccess.setConnexionType(this.connexionType);
			this.updateDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Update getUpdate() throws Exception {	
		UpdateLogicAdditional.checkUpdateToGet(update,this.datosCliente,this.arrDatoGeneral);
		UpdateLogicAdditional.updateUpdateToGet(update,this.arrDatoGeneral);
		
		return update;
	}
		
	public void setUpdate(Update newUpdate) {
		this.update = newUpdate;
	}
	
	public UpdateDataAccess getUpdateDataAccess() {
		return updateDataAccess;
	}
	
	public void setUpdateDataAccess(UpdateDataAccess newupdateDataAccess) {
		this.updateDataAccess = newupdateDataAccess;
	}
	
	public List<Update> getUpdates() throws Exception {		
		this.quitarUpdatesNulos();
		
		UpdateLogicAdditional.checkUpdateToGets(updates,this.datosCliente,this.arrDatoGeneral);
		
		for (Update updateLocal: updates ) {
			UpdateLogicAdditional.updateUpdateToGet(updateLocal,this.arrDatoGeneral);
		}
		
		return updates;
	}
	
	public void setUpdates(List<Update> newUpdates) {
		this.updates = newUpdates;
	}
	
	public Object getUpdateObject() {	
		this.updateObject=this.updateDataAccess.getEntityObject();
		return this.updateObject;
	}
		
	public void setUpdateObject(Object newUpdateObject) {
		this.updateObject = newUpdateObject;
	}
	
	public List<Object> getUpdatesObject() {		
		this.updatesObject=this.updateDataAccess.getEntitiesObject();
		return this.updatesObject;
	}
		
	public void setUpdatesObject(List<Object> newUpdatesObject) {
		this.updatesObject = newUpdatesObject;
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
		
		if(this.updateDataAccess!=null) {
			this.updateDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			updateDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			updateDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		update = new  Update();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			update=updateDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.update,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.update);
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
		update = new  Update();
		  		  
        try {
			
			update=updateDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.update,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.update);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		update = new  Update();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			update=updateDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.update,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.update);
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
		update = new  Update();
		  		  
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
		update = new  Update();
		  		  
        try {
			
			update=updateDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.update,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.update);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		update = new  Update();
		  		  
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
		update = new  Update();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =updateDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		update = new  Update();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=updateDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		update = new  Update();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =updateDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		update = new  Update();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=updateDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		update = new  Update();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =updateDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		update = new  Update();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=updateDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		updates = new  ArrayList<Update>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updates=updateDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUpdate(updates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
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
		updates = new  ArrayList<Update>();
		  		  
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
		updates = new  ArrayList<Update>();
		  		  
        try {			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updates=updateDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarUpdate(updates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		updates = new  ArrayList<Update>();
		  		  
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
		updates = new  ArrayList<Update>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updates=updateDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUpdate(updates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
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
		updates = new  ArrayList<Update>();
		  		  
        try {
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updates=updateDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUpdate(updates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
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
		updates = new  ArrayList<Update>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updates=updateDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUpdate(updates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
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
		updates = new  ArrayList<Update>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updates=updateDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUpdate(updates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		update = new  Update();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			update=updateDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUpdate(update);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.update);
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
		update = new  Update();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			update=updateDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUpdate(update);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.update);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosUpdatesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		updates = new  ArrayList<Update>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getTodosUpdatesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updates=updateDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUpdate(updates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
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
	
	public  void  getTodosUpdates(String sFinalQuery,Pagination pagination)throws Exception {
		updates = new  ArrayList<Update>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updates=updateDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUpdate(updates);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarUpdate(Update update) throws Exception {
		Boolean estaValidado=false;
		
		if(update.getIsNew() || update.getIsChanged()) { 
			this.invalidValues = updateValidator.getInvalidValues(update);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(update);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarUpdate(List<Update> Updates) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Update updateLocal:updates) {				
			estaValidadoObjeto=this.validarGuardarUpdate(updateLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarUpdate(List<Update> Updates) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUpdate(updates)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarUpdate(Update Update) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUpdate(update)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Update update) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+update.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=UpdateConstantesFunciones.getUpdateLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"update","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(UpdateConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(UpdateConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveUpdateWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-saveUpdateWithConnection");connexion.begin();			
			
			UpdateLogicAdditional.checkUpdateToSave(this.update,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UpdateLogicAdditional.updateUpdateToSave(this.update,this.arrDatoGeneral);
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.update,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowUpdate();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUpdate(this.update)) {
				UpdateDataAccess.save(this.update, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.update,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UpdateLogicAdditional.checkUpdateToSaveAfter(this.update,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUpdate();
			
			connexion.commit();			
			
			if(this.update.getIsDeleted()) {
				this.update=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveUpdate()throws Exception {	
		try {	
			
			UpdateLogicAdditional.checkUpdateToSave(this.update,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UpdateLogicAdditional.updateUpdateToSave(this.update,this.arrDatoGeneral);
			
			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.update,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUpdate(this.update)) {			
				UpdateDataAccess.save(this.update, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.update,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UpdateLogicAdditional.checkUpdateToSaveAfter(this.update,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.update.getIsDeleted()) {
				this.update=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveUpdatesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-saveUpdatesWithConnection");connexion.begin();			
			
			UpdateLogicAdditional.checkUpdateToSaves(updates,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowUpdates();
			
			Boolean validadoTodosUpdate=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Update updateLocal:updates) {		
				if(updateLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UpdateLogicAdditional.updateUpdateToSave(updateLocal,this.arrDatoGeneral);
	        	
				UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),updateLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUpdate(updateLocal)) {
					UpdateDataAccess.save(updateLocal, connexion);				
				} else {
					validadoTodosUpdate=false;
				}
			}
			
			if(!validadoTodosUpdate) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UpdateLogicAdditional.checkUpdateToSavesAfter(updates,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUpdates();
			
			connexion.commit();		
			
			this.quitarUpdatesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveUpdates()throws Exception {				
		 try {	
			UpdateLogicAdditional.checkUpdateToSaves(updates,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosUpdate=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Update updateLocal:updates) {				
				if(updateLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UpdateLogicAdditional.updateUpdateToSave(updateLocal,this.arrDatoGeneral);
	        	
				UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),updateLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUpdate(updateLocal)) {				
					UpdateDataAccess.save(updateLocal, connexion);				
				} else {
					validadoTodosUpdate=false;
				}
			}
			
			if(!validadoTodosUpdate) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UpdateLogicAdditional.checkUpdateToSavesAfter(updates,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarUpdatesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UpdateParameterReturnGeneral procesarAccionUpdates(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Update> updates,UpdateParameterReturnGeneral updateParameterGeneral)throws Exception {
		 try {	
			UpdateParameterReturnGeneral updateReturnGeneral=new UpdateParameterReturnGeneral();
	
			UpdateLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,updates,updateParameterGeneral,updateReturnGeneral);
			
			return updateReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UpdateParameterReturnGeneral procesarAccionUpdatesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Update> updates,UpdateParameterReturnGeneral updateParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-procesarAccionUpdatesWithConnection");connexion.begin();			
			
			UpdateParameterReturnGeneral updateReturnGeneral=new UpdateParameterReturnGeneral();
	
			UpdateLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,updates,updateParameterGeneral,updateReturnGeneral);
			
			this.connexion.commit();
			
			return updateReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UpdateParameterReturnGeneral procesarEventosUpdates(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Update> updates,Update update,UpdateParameterReturnGeneral updateParameterGeneral,Boolean isEsNuevoUpdate,ArrayList<Classe> clases)throws Exception {
		 try {	
			UpdateParameterReturnGeneral updateReturnGeneral=new UpdateParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				updateReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UpdateLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,updates,update,updateParameterGeneral,updateReturnGeneral,isEsNuevoUpdate,clases);
			
			return updateReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public UpdateParameterReturnGeneral procesarEventosUpdatesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Update> updates,Update update,UpdateParameterReturnGeneral updateParameterGeneral,Boolean isEsNuevoUpdate,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-procesarEventosUpdatesWithConnection");connexion.begin();			
			
			UpdateParameterReturnGeneral updateReturnGeneral=new UpdateParameterReturnGeneral();
	
			updateReturnGeneral.setUpdate(update);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				updateReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UpdateLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,updates,update,updateParameterGeneral,updateReturnGeneral,isEsNuevoUpdate,clases);
			
			this.connexion.commit();
			
			return updateReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UpdateParameterReturnGeneral procesarImportacionUpdatesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,UpdateParameterReturnGeneral updateParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-procesarImportacionUpdatesWithConnection");connexion.begin();			
			
			UpdateParameterReturnGeneral updateReturnGeneral=new UpdateParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.updates=new ArrayList<Update>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.update=new Update();
				
				
				if(conColumnasBase) {this.update.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.update.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.update.setcodigo(arrColumnas[iColumn++]);
				this.update.setcodigo_proceso(arrColumnas[iColumn++]);
			this.update.setquery_resumen(arrColumnas[iColumn++]);
				this.update.setnumero_intento(Integer.parseInt(arrColumnas[iColumn++]));
				this.update.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.update.setfecha_archivo(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.update.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				this.update.setejecutado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.update.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.update.setdescripcion(arrColumnas[iColumn++]);
				
				this.updates.add(this.update);
			}
			
			this.saveUpdates();
			
			this.connexion.commit();
			
			updateReturnGeneral.setConRetornoEstaProcesado(true);
			updateReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return updateReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarUpdatesEliminados() throws Exception {				
		
		List<Update> updatesAux= new ArrayList<Update>();
		
		for(Update update:updates) {
			if(!update.getIsDeleted()) {
				updatesAux.add(update);
			}
		}
		
		updates=updatesAux;
	}
	
	public void quitarUpdatesNulos() throws Exception {				
		
		List<Update> updatesAux= new ArrayList<Update>();
		
		for(Update update : this.updates) {
			if(update==null) {
				updatesAux.add(update);
			}
		}
		
		//this.updates=updatesAux;
		
		this.updates.removeAll(updatesAux);
	}
	
	public void getSetVersionRowUpdateWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(update.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((update.getIsDeleted() || (update.getIsChanged()&&!update.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=updateDataAccess.getSetVersionRowUpdate(connexion,update.getId());
				
				if(!update.getVersionRow().equals(timestamp)) {	
					update.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				update.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUpdate()throws Exception {	
		
		if(update.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((update.getIsDeleted() || (update.getIsChanged()&&!update.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=updateDataAccess.getSetVersionRowUpdate(connexion,update.getId());
			
			try {							
				if(!update.getVersionRow().equals(timestamp)) {	
					update.setVersionRow(timestamp);
				}
				
				update.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowUpdatesWithConnection()throws Exception {	
		if(updates!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Update updateAux:updates) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(updateAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(updateAux.getIsDeleted() || (updateAux.getIsChanged()&&!updateAux.getIsNew())) {
						
						timestamp=updateDataAccess.getSetVersionRowUpdate(connexion,updateAux.getId());
						
						if(!update.getVersionRow().equals(timestamp)) {	
							updateAux.setVersionRow(timestamp);
						}
								
						updateAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowUpdates()throws Exception {	
		if(updates!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Update updateAux:updates) {
					if(updateAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(updateAux.getIsDeleted() || (updateAux.getIsChanged()&&!updateAux.getIsNew())) {
						
						timestamp=updateDataAccess.getSetVersionRowUpdate(connexion,updateAux.getId());
						
						if(!updateAux.getVersionRow().equals(timestamp)) {	
							updateAux.setVersionRow(timestamp);
						}
						
													
						updateAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public UpdateParameterReturnGeneral cargarCombosLoteForeignKeyUpdateWithConnection(String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		UpdateParameterReturnGeneral  updateReturnGeneral =new UpdateParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-cargarCombosLoteForeignKeyUpdateWithConnection");connexion.begin();
			
			updateReturnGeneral =new UpdateParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			updateReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			updateReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return updateReturnGeneral;
	}
	
	public UpdateParameterReturnGeneral cargarCombosLoteForeignKeyUpdate(String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		UpdateParameterReturnGeneral  updateReturnGeneral =new UpdateParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			updateReturnGeneral =new UpdateParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			updateReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			updateReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return updateReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyUpdateWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			UpdateDetalleLogic updatedetalleLogic=new UpdateDetalleLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyUpdateWithConnection");connexion.begin();
			
			
			classes.add(new Classe(UpdateDetalle.class));
											
			

			updatedetalleLogic.setConnexion(this.getConnexion());
			updatedetalleLogic.setDatosCliente(this.datosCliente);
			updatedetalleLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Update update:this.updates) {
				

				classes=new ArrayList<Classe>();
				classes=UpdateDetalleConstantesFunciones.getClassesForeignKeysOfUpdateDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);

				updatedetalleLogic.setUpdateDetalles(update.updatedetalles);
				updatedetalleLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Update update,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			UpdateLogicAdditional.updateUpdateToGet(update,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		update.setAnio(updateDataAccess.getAnio(connexion,update));
		update.setMes(updateDataAccess.getMes(connexion,update));
		update.setUpdateDetalles(updateDataAccess.getUpdateDetalles(connexion,update));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				update.setAnio(updateDataAccess.getAnio(connexion,update));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				update.setMes(updateDataAccess.getMes(connexion,update));
				continue;
			}

			if(clas.clas.equals(UpdateDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				update.setUpdateDetalles(updateDataAccess.getUpdateDetalles(connexion,update));

				if(this.isConDeep) {
					UpdateDetalleLogic updatedetalleLogic= new UpdateDetalleLogic(this.connexion);
					updatedetalleLogic.setUpdateDetalles(update.getUpdateDetalles());
					ArrayList<Classe> classesLocal=UpdateDetalleConstantesFunciones.getClassesForeignKeysOfUpdateDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);
					updatedetalleLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(updatedetalleLogic.getUpdateDetalles());
					update.setUpdateDetalles(updatedetalleLogic.getUpdateDetalles());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			update.setAnio(updateDataAccess.getAnio(connexion,update));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			update.setMes(updateDataAccess.getMes(connexion,update));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UpdateDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UpdateDetalle.class));
			update.setUpdateDetalles(updateDataAccess.getUpdateDetalles(connexion,update));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		update.setAnio(updateDataAccess.getAnio(connexion,update));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(update.getAnio(),isDeep,deepLoadType,clases);
				
		update.setMes(updateDataAccess.getMes(connexion,update));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(update.getMes(),isDeep,deepLoadType,clases);
				

		update.setUpdateDetalles(updateDataAccess.getUpdateDetalles(connexion,update));

		for(UpdateDetalle updatedetalle:update.getUpdateDetalles()) {
			UpdateDetalleLogic updatedetalleLogic= new UpdateDetalleLogic(connexion);
			updatedetalleLogic.deepLoad(updatedetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				update.setAnio(updateDataAccess.getAnio(connexion,update));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(update.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				update.setMes(updateDataAccess.getMes(connexion,update));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(update.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(UpdateDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				update.setUpdateDetalles(updateDataAccess.getUpdateDetalles(connexion,update));

				for(UpdateDetalle updatedetalle:update.getUpdateDetalles()) {
					UpdateDetalleLogic updatedetalleLogic= new UpdateDetalleLogic(connexion);
					updatedetalleLogic.deepLoad(updatedetalle,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			update.setAnio(updateDataAccess.getAnio(connexion,update));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(update.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			update.setMes(updateDataAccess.getMes(connexion,update));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(update.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UpdateDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UpdateDetalle.class));
			update.setUpdateDetalles(updateDataAccess.getUpdateDetalles(connexion,update));

			for(UpdateDetalle updatedetalle:update.getUpdateDetalles()) {
				UpdateDetalleLogic updatedetalleLogic= new UpdateDetalleLogic(connexion);
				updatedetalleLogic.deepLoad(updatedetalle,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Update update,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Update.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(update,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(update);
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
			this.deepLoad(this.update,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.update);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Update.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(updates!=null) {
				for(Update update:updates) {
					this.deepLoad(update,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(updates);
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
			if(updates!=null) {
				for(Update update:updates) {
					this.deepLoad(update,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(updates);
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
	
	
	public void getUpdatesFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,UpdateConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updates=updateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUpdatesFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,UpdateConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updates=updateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUpdatesFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Update.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,UpdateConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updates=updateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUpdatesFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,UpdateConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			UpdateLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updates=updateDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateConstantesFunciones.refrescarForeignKeysDescripcionesUpdate(this.updates);
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
			if(UpdateConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,UpdateDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Update update,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UpdateConstantesFunciones.ISCONAUDITORIA) {
				if(update.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UpdateDataAccess.TABLENAME, update.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UpdateConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UpdateLogic.registrarAuditoriaDetallesUpdate(connexion,update,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(update.getIsDeleted()) {
					/*if(!update.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,UpdateDataAccess.TABLENAME, update.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////UpdateLogic.registrarAuditoriaDetallesUpdate(connexion,update,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UpdateDataAccess.TABLENAME, update.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(update.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UpdateDataAccess.TABLENAME, update.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UpdateConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UpdateLogic.registrarAuditoriaDetallesUpdate(connexion,update,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesUpdate(Connexion connexion,Update update)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(update.getIsNew()||!update.getid_anio().equals(update.getUpdateOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getid_anio()!=null)
				{
					strValorActual=update.getUpdateOriginal().getid_anio().toString();
				}
				if(update.getid_anio()!=null)
				{
					strValorNuevo=update.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getid_mes().equals(update.getUpdateOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getid_mes()!=null)
				{
					strValorActual=update.getUpdateOriginal().getid_mes().toString();
				}
				if(update.getid_mes()!=null)
				{
					strValorNuevo=update.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getcodigo().equals(update.getUpdateOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getcodigo()!=null)
				{
					strValorActual=update.getUpdateOriginal().getcodigo();
				}
				if(update.getcodigo()!=null)
				{
					strValorNuevo=update.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getcodigo_proceso().equals(update.getUpdateOriginal().getcodigo_proceso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getcodigo_proceso()!=null)
				{
					strValorActual=update.getUpdateOriginal().getcodigo_proceso();
				}
				if(update.getcodigo_proceso()!=null)
				{
					strValorNuevo=update.getcodigo_proceso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.CODIGOPROCESO,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getquery_resumen().equals(update.getUpdateOriginal().getquery_resumen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getquery_resumen()!=null)
				{
					strValorActual=update.getUpdateOriginal().getquery_resumen();
				}
				if(update.getquery_resumen()!=null)
				{
					strValorNuevo=update.getquery_resumen() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.QUERYRESUMEN,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getnumero_intento().equals(update.getUpdateOriginal().getnumero_intento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getnumero_intento()!=null)
				{
					strValorActual=update.getUpdateOriginal().getnumero_intento().toString();
				}
				if(update.getnumero_intento()!=null)
				{
					strValorNuevo=update.getnumero_intento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.NUMEROINTENTO,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getfecha().equals(update.getUpdateOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getfecha()!=null)
				{
					strValorActual=update.getUpdateOriginal().getfecha().toString();
				}
				if(update.getfecha()!=null)
				{
					strValorNuevo=update.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getfecha_archivo().equals(update.getUpdateOriginal().getfecha_archivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getfecha_archivo()!=null)
				{
					strValorActual=update.getUpdateOriginal().getfecha_archivo().toString();
				}
				if(update.getfecha_archivo()!=null)
				{
					strValorNuevo=update.getfecha_archivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.FECHAARCHIVO,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getorden().equals(update.getUpdateOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getorden()!=null)
				{
					strValorActual=update.getUpdateOriginal().getorden().toString();
				}
				if(update.getorden()!=null)
				{
					strValorNuevo=update.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getejecutado().equals(update.getUpdateOriginal().getejecutado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getejecutado()!=null)
				{
					strValorActual=update.getUpdateOriginal().getejecutado().toString();
				}
				if(update.getejecutado()!=null)
				{
					strValorNuevo=update.getejecutado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.EJECUTADO,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getesta_activo().equals(update.getUpdateOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getesta_activo()!=null)
				{
					strValorActual=update.getUpdateOriginal().getesta_activo().toString();
				}
				if(update.getesta_activo()!=null)
				{
					strValorNuevo=update.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(update.getIsNew()||!update.getdescripcion().equals(update.getUpdateOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(update.getUpdateOriginal().getdescripcion()!=null)
				{
					strValorActual=update.getUpdateOriginal().getdescripcion();
				}
				if(update.getdescripcion()!=null)
				{
					strValorNuevo=update.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfUpdate(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UpdateConstantesFunciones.getClassesForeignKeysOfUpdate(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUpdate(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UpdateConstantesFunciones.getClassesRelationshipsOfUpdate(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

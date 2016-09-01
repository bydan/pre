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
import com.bydan.erp.seguridad.util.UpdateDetalleConstantesFunciones;
import com.bydan.erp.seguridad.util.UpdateDetalleParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.UpdateDetalleParameterGeneral;
import com.bydan.erp.seguridad.business.entity.UpdateDetalle;
import com.bydan.erp.seguridad.business.logic.UpdateDetalleLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class UpdateDetalleLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(UpdateDetalleLogic.class);
	
	protected UpdateDetalleDataAccess updatedetalleDataAccess; 	
	protected UpdateDetalle updatedetalle;
	protected List<UpdateDetalle> updatedetalles;
	protected Object updatedetalleObject;	
	protected List<Object> updatedetallesObject;
	
	public static ClassValidator<UpdateDetalle> updatedetalleValidator = new ClassValidator<UpdateDetalle>(UpdateDetalle.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected UpdateDetalleLogicAdditional updatedetalleLogicAdditional=null;
	
	public UpdateDetalleLogicAdditional getUpdateDetalleLogicAdditional() {
		return this.updatedetalleLogicAdditional;
	}
	
	public void setUpdateDetalleLogicAdditional(UpdateDetalleLogicAdditional updatedetalleLogicAdditional) {
		try {
			this.updatedetalleLogicAdditional=updatedetalleLogicAdditional;
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
	
	
	
	
	public  UpdateDetalleLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.updatedetalleDataAccess = new UpdateDetalleDataAccess();
			
			this.updatedetalles= new ArrayList<UpdateDetalle>();
			this.updatedetalle= new UpdateDetalle();
			
			this.updatedetalleObject=new Object();
			this.updatedetallesObject=new ArrayList<Object>();
				
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
			
			this.updatedetalleDataAccess.setConnexionType(this.connexionType);
			this.updatedetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  UpdateDetalleLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.updatedetalleDataAccess = new UpdateDetalleDataAccess();
			this.updatedetalles= new ArrayList<UpdateDetalle>();
			this.updatedetalle= new UpdateDetalle();
			this.updatedetalleObject=new Object();
			this.updatedetallesObject=new ArrayList<Object>();
			
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
			
			this.updatedetalleDataAccess.setConnexionType(this.connexionType);
			this.updatedetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public UpdateDetalle getUpdateDetalle() throws Exception {	
		UpdateDetalleLogicAdditional.checkUpdateDetalleToGet(updatedetalle,this.datosCliente,this.arrDatoGeneral);
		UpdateDetalleLogicAdditional.updateUpdateDetalleToGet(updatedetalle,this.arrDatoGeneral);
		
		return updatedetalle;
	}
		
	public void setUpdateDetalle(UpdateDetalle newUpdateDetalle) {
		this.updatedetalle = newUpdateDetalle;
	}
	
	public UpdateDetalleDataAccess getUpdateDetalleDataAccess() {
		return updatedetalleDataAccess;
	}
	
	public void setUpdateDetalleDataAccess(UpdateDetalleDataAccess newupdatedetalleDataAccess) {
		this.updatedetalleDataAccess = newupdatedetalleDataAccess;
	}
	
	public List<UpdateDetalle> getUpdateDetalles() throws Exception {		
		this.quitarUpdateDetallesNulos();
		
		UpdateDetalleLogicAdditional.checkUpdateDetalleToGets(updatedetalles,this.datosCliente,this.arrDatoGeneral);
		
		for (UpdateDetalle updatedetalleLocal: updatedetalles ) {
			UpdateDetalleLogicAdditional.updateUpdateDetalleToGet(updatedetalleLocal,this.arrDatoGeneral);
		}
		
		return updatedetalles;
	}
	
	public void setUpdateDetalles(List<UpdateDetalle> newUpdateDetalles) {
		this.updatedetalles = newUpdateDetalles;
	}
	
	public Object getUpdateDetalleObject() {	
		this.updatedetalleObject=this.updatedetalleDataAccess.getEntityObject();
		return this.updatedetalleObject;
	}
		
	public void setUpdateDetalleObject(Object newUpdateDetalleObject) {
		this.updatedetalleObject = newUpdateDetalleObject;
	}
	
	public List<Object> getUpdateDetallesObject() {		
		this.updatedetallesObject=this.updatedetalleDataAccess.getEntitiesObject();
		return this.updatedetallesObject;
	}
		
	public void setUpdateDetallesObject(List<Object> newUpdateDetallesObject) {
		this.updatedetallesObject = newUpdateDetallesObject;
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
		
		if(this.updatedetalleDataAccess!=null) {
			this.updatedetalleDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			updatedetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			updatedetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		updatedetalle = new  UpdateDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			updatedetalle=updatedetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.updatedetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalle);
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
		updatedetalle = new  UpdateDetalle();
		  		  
        try {
			
			updatedetalle=updatedetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.updatedetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		updatedetalle = new  UpdateDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			updatedetalle=updatedetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.updatedetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalle);
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
		updatedetalle = new  UpdateDetalle();
		  		  
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
		updatedetalle = new  UpdateDetalle();
		  		  
        try {
			
			updatedetalle=updatedetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.updatedetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		updatedetalle = new  UpdateDetalle();
		  		  
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
		updatedetalle = new  UpdateDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =updatedetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		updatedetalle = new  UpdateDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=updatedetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		updatedetalle = new  UpdateDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =updatedetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		updatedetalle = new  UpdateDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=updatedetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		updatedetalle = new  UpdateDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =updatedetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		updatedetalle = new  UpdateDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=updatedetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		updatedetalles = new  ArrayList<UpdateDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalles=updatedetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUpdateDetalle(updatedetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
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
		updatedetalles = new  ArrayList<UpdateDetalle>();
		  		  
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
		updatedetalles = new  ArrayList<UpdateDetalle>();
		  		  
        try {			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalles=updatedetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarUpdateDetalle(updatedetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		updatedetalles = new  ArrayList<UpdateDetalle>();
		  		  
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
		updatedetalles = new  ArrayList<UpdateDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalles=updatedetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUpdateDetalle(updatedetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
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
		updatedetalles = new  ArrayList<UpdateDetalle>();
		  		  
        try {
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalles=updatedetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUpdateDetalle(updatedetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
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
		updatedetalles = new  ArrayList<UpdateDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalles=updatedetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUpdateDetalle(updatedetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
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
		updatedetalles = new  ArrayList<UpdateDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalles=updatedetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUpdateDetalle(updatedetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		updatedetalle = new  UpdateDetalle();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalle=updatedetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUpdateDetalle(updatedetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalle);
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
		updatedetalle = new  UpdateDetalle();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalle=updatedetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUpdateDetalle(updatedetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosUpdateDetallesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		updatedetalles = new  ArrayList<UpdateDetalle>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getTodosUpdateDetallesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalles=updatedetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUpdateDetalle(updatedetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
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
	
	public  void  getTodosUpdateDetalles(String sFinalQuery,Pagination pagination)throws Exception {
		updatedetalles = new  ArrayList<UpdateDetalle>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			updatedetalles=updatedetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUpdateDetalle(updatedetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarUpdateDetalle(UpdateDetalle updatedetalle) throws Exception {
		Boolean estaValidado=false;
		
		if(updatedetalle.getIsNew() || updatedetalle.getIsChanged()) { 
			this.invalidValues = updatedetalleValidator.getInvalidValues(updatedetalle);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(updatedetalle);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarUpdateDetalle(List<UpdateDetalle> UpdateDetalles) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(UpdateDetalle updatedetalleLocal:updatedetalles) {				
			estaValidadoObjeto=this.validarGuardarUpdateDetalle(updatedetalleLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarUpdateDetalle(List<UpdateDetalle> UpdateDetalles) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUpdateDetalle(updatedetalles)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarUpdateDetalle(UpdateDetalle UpdateDetalle) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUpdateDetalle(updatedetalle)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(UpdateDetalle updatedetalle) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+updatedetalle.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=UpdateDetalleConstantesFunciones.getUpdateDetalleLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"updatedetalle","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(UpdateDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(UpdateDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveUpdateDetalleWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-saveUpdateDetalleWithConnection");connexion.begin();			
			
			UpdateDetalleLogicAdditional.checkUpdateDetalleToSave(this.updatedetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UpdateDetalleLogicAdditional.updateUpdateDetalleToSave(this.updatedetalle,this.arrDatoGeneral);
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.updatedetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowUpdateDetalle();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUpdateDetalle(this.updatedetalle)) {
				UpdateDetalleDataAccess.save(this.updatedetalle, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.updatedetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UpdateDetalleLogicAdditional.checkUpdateDetalleToSaveAfter(this.updatedetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUpdateDetalle();
			
			connexion.commit();			
			
			if(this.updatedetalle.getIsDeleted()) {
				this.updatedetalle=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveUpdateDetalle()throws Exception {	
		try {	
			
			UpdateDetalleLogicAdditional.checkUpdateDetalleToSave(this.updatedetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UpdateDetalleLogicAdditional.updateUpdateDetalleToSave(this.updatedetalle,this.arrDatoGeneral);
			
			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.updatedetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUpdateDetalle(this.updatedetalle)) {			
				UpdateDetalleDataAccess.save(this.updatedetalle, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.updatedetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UpdateDetalleLogicAdditional.checkUpdateDetalleToSaveAfter(this.updatedetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.updatedetalle.getIsDeleted()) {
				this.updatedetalle=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveUpdateDetallesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-saveUpdateDetallesWithConnection");connexion.begin();			
			
			UpdateDetalleLogicAdditional.checkUpdateDetalleToSaves(updatedetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowUpdateDetalles();
			
			Boolean validadoTodosUpdateDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UpdateDetalle updatedetalleLocal:updatedetalles) {		
				if(updatedetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UpdateDetalleLogicAdditional.updateUpdateDetalleToSave(updatedetalleLocal,this.arrDatoGeneral);
	        	
				UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),updatedetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUpdateDetalle(updatedetalleLocal)) {
					UpdateDetalleDataAccess.save(updatedetalleLocal, connexion);				
				} else {
					validadoTodosUpdateDetalle=false;
				}
			}
			
			if(!validadoTodosUpdateDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UpdateDetalleLogicAdditional.checkUpdateDetalleToSavesAfter(updatedetalles,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUpdateDetalles();
			
			connexion.commit();		
			
			this.quitarUpdateDetallesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveUpdateDetalles()throws Exception {				
		 try {	
			UpdateDetalleLogicAdditional.checkUpdateDetalleToSaves(updatedetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosUpdateDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UpdateDetalle updatedetalleLocal:updatedetalles) {				
				if(updatedetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UpdateDetalleLogicAdditional.updateUpdateDetalleToSave(updatedetalleLocal,this.arrDatoGeneral);
	        	
				UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),updatedetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUpdateDetalle(updatedetalleLocal)) {				
					UpdateDetalleDataAccess.save(updatedetalleLocal, connexion);				
				} else {
					validadoTodosUpdateDetalle=false;
				}
			}
			
			if(!validadoTodosUpdateDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UpdateDetalleLogicAdditional.checkUpdateDetalleToSavesAfter(updatedetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarUpdateDetallesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UpdateDetalleParameterReturnGeneral procesarAccionUpdateDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UpdateDetalle> updatedetalles,UpdateDetalleParameterReturnGeneral updatedetalleParameterGeneral)throws Exception {
		 try {	
			UpdateDetalleParameterReturnGeneral updatedetalleReturnGeneral=new UpdateDetalleParameterReturnGeneral();
	
			UpdateDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,updatedetalles,updatedetalleParameterGeneral,updatedetalleReturnGeneral);
			
			return updatedetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UpdateDetalleParameterReturnGeneral procesarAccionUpdateDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UpdateDetalle> updatedetalles,UpdateDetalleParameterReturnGeneral updatedetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-procesarAccionUpdateDetallesWithConnection");connexion.begin();			
			
			UpdateDetalleParameterReturnGeneral updatedetalleReturnGeneral=new UpdateDetalleParameterReturnGeneral();
	
			UpdateDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,updatedetalles,updatedetalleParameterGeneral,updatedetalleReturnGeneral);
			
			this.connexion.commit();
			
			return updatedetalleReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UpdateDetalleParameterReturnGeneral procesarEventosUpdateDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UpdateDetalle> updatedetalles,UpdateDetalle updatedetalle,UpdateDetalleParameterReturnGeneral updatedetalleParameterGeneral,Boolean isEsNuevoUpdateDetalle,ArrayList<Classe> clases)throws Exception {
		 try {	
			UpdateDetalleParameterReturnGeneral updatedetalleReturnGeneral=new UpdateDetalleParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				updatedetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UpdateDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,updatedetalles,updatedetalle,updatedetalleParameterGeneral,updatedetalleReturnGeneral,isEsNuevoUpdateDetalle,clases);
			
			return updatedetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public UpdateDetalleParameterReturnGeneral procesarEventosUpdateDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UpdateDetalle> updatedetalles,UpdateDetalle updatedetalle,UpdateDetalleParameterReturnGeneral updatedetalleParameterGeneral,Boolean isEsNuevoUpdateDetalle,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-procesarEventosUpdateDetallesWithConnection");connexion.begin();			
			
			UpdateDetalleParameterReturnGeneral updatedetalleReturnGeneral=new UpdateDetalleParameterReturnGeneral();
	
			updatedetalleReturnGeneral.setUpdateDetalle(updatedetalle);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				updatedetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UpdateDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,updatedetalles,updatedetalle,updatedetalleParameterGeneral,updatedetalleReturnGeneral,isEsNuevoUpdateDetalle,clases);
			
			this.connexion.commit();
			
			return updatedetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UpdateDetalleParameterReturnGeneral procesarImportacionUpdateDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,UpdateDetalleParameterReturnGeneral updatedetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-procesarImportacionUpdateDetallesWithConnection");connexion.begin();			
			
			UpdateDetalleParameterReturnGeneral updatedetalleReturnGeneral=new UpdateDetalleParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.updatedetalles=new ArrayList<UpdateDetalle>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.updatedetalle=new UpdateDetalle();
				
				
				if(conColumnasBase) {this.updatedetalle.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.updatedetalle.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.updatedetalle.setcodigo(arrColumnas[iColumn++]);
				this.updatedetalle.setcodigo_proceso(arrColumnas[iColumn++]);
				this.updatedetalle.setquery_resumen(arrColumnas[iColumn++]);
				this.updatedetalle.setnumero_intento(Integer.parseInt(arrColumnas[iColumn++]));
				this.updatedetalle.setfecha_archivo(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.updatedetalle.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.updatedetalle.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				this.updatedetalle.setejecutado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.updatedetalle.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.updatedetalle.setdescripcion(arrColumnas[iColumn++]);
				
				this.updatedetalles.add(this.updatedetalle);
			}
			
			this.saveUpdateDetalles();
			
			this.connexion.commit();
			
			updatedetalleReturnGeneral.setConRetornoEstaProcesado(true);
			updatedetalleReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return updatedetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarUpdateDetallesEliminados() throws Exception {				
		
		List<UpdateDetalle> updatedetallesAux= new ArrayList<UpdateDetalle>();
		
		for(UpdateDetalle updatedetalle:updatedetalles) {
			if(!updatedetalle.getIsDeleted()) {
				updatedetallesAux.add(updatedetalle);
			}
		}
		
		updatedetalles=updatedetallesAux;
	}
	
	public void quitarUpdateDetallesNulos() throws Exception {				
		
		List<UpdateDetalle> updatedetallesAux= new ArrayList<UpdateDetalle>();
		
		for(UpdateDetalle updatedetalle : this.updatedetalles) {
			if(updatedetalle==null) {
				updatedetallesAux.add(updatedetalle);
			}
		}
		
		//this.updatedetalles=updatedetallesAux;
		
		this.updatedetalles.removeAll(updatedetallesAux);
	}
	
	public void getSetVersionRowUpdateDetalleWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(updatedetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((updatedetalle.getIsDeleted() || (updatedetalle.getIsChanged()&&!updatedetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=updatedetalleDataAccess.getSetVersionRowUpdateDetalle(connexion,updatedetalle.getId());
				
				if(!updatedetalle.getVersionRow().equals(timestamp)) {	
					updatedetalle.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				updatedetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUpdateDetalle()throws Exception {	
		
		if(updatedetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((updatedetalle.getIsDeleted() || (updatedetalle.getIsChanged()&&!updatedetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=updatedetalleDataAccess.getSetVersionRowUpdateDetalle(connexion,updatedetalle.getId());
			
			try {							
				if(!updatedetalle.getVersionRow().equals(timestamp)) {	
					updatedetalle.setVersionRow(timestamp);
				}
				
				updatedetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowUpdateDetallesWithConnection()throws Exception {	
		if(updatedetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(UpdateDetalle updatedetalleAux:updatedetalles) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(updatedetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(updatedetalleAux.getIsDeleted() || (updatedetalleAux.getIsChanged()&&!updatedetalleAux.getIsNew())) {
						
						timestamp=updatedetalleDataAccess.getSetVersionRowUpdateDetalle(connexion,updatedetalleAux.getId());
						
						if(!updatedetalle.getVersionRow().equals(timestamp)) {	
							updatedetalleAux.setVersionRow(timestamp);
						}
								
						updatedetalleAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowUpdateDetalles()throws Exception {	
		if(updatedetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(UpdateDetalle updatedetalleAux:updatedetalles) {
					if(updatedetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(updatedetalleAux.getIsDeleted() || (updatedetalleAux.getIsChanged()&&!updatedetalleAux.getIsNew())) {
						
						timestamp=updatedetalleDataAccess.getSetVersionRowUpdateDetalle(connexion,updatedetalleAux.getId());
						
						if(!updatedetalleAux.getVersionRow().equals(timestamp)) {	
							updatedetalleAux.setVersionRow(timestamp);
						}
						
													
						updatedetalleAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public UpdateDetalleParameterReturnGeneral cargarCombosLoteForeignKeyUpdateDetalleWithConnection(String finalQueryGlobalUpdate,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		UpdateDetalleParameterReturnGeneral  updatedetalleReturnGeneral =new UpdateDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-cargarCombosLoteForeignKeyUpdateDetalleWithConnection");connexion.begin();
			
			updatedetalleReturnGeneral =new UpdateDetalleParameterReturnGeneral();
			
			

			List<Update> updatesForeignKey=new ArrayList<Update>();
			UpdateLogic updateLogic=new UpdateLogic();
			updateLogic.setConnexion(this.connexion);
			updateLogic.getUpdateDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUpdate.equals("NONE")) {
				updateLogic.getTodosUpdates(finalQueryGlobalUpdate,new Pagination());
				updatesForeignKey=updateLogic.getUpdates();
			}

			updatedetalleReturnGeneral.setupdatesForeignKey(updatesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			updatedetalleReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			updatedetalleReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return updatedetalleReturnGeneral;
	}
	
	public UpdateDetalleParameterReturnGeneral cargarCombosLoteForeignKeyUpdateDetalle(String finalQueryGlobalUpdate,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		UpdateDetalleParameterReturnGeneral  updatedetalleReturnGeneral =new UpdateDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			updatedetalleReturnGeneral =new UpdateDetalleParameterReturnGeneral();
			
			

			List<Update> updatesForeignKey=new ArrayList<Update>();
			UpdateLogic updateLogic=new UpdateLogic();
			updateLogic.setConnexion(this.connexion);
			updateLogic.getUpdateDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUpdate.equals("NONE")) {
				updateLogic.getTodosUpdates(finalQueryGlobalUpdate,new Pagination());
				updatesForeignKey=updateLogic.getUpdates();
			}

			updatedetalleReturnGeneral.setupdatesForeignKey(updatesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			updatedetalleReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			updatedetalleReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return updatedetalleReturnGeneral;
	}
	
	
	public void deepLoad(UpdateDetalle updatedetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			UpdateDetalleLogicAdditional.updateUpdateDetalleToGet(updatedetalle,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		updatedetalle.setUpdate(updatedetalleDataAccess.getUpdate(connexion,updatedetalle));
		updatedetalle.setAnio(updatedetalleDataAccess.getAnio(connexion,updatedetalle));
		updatedetalle.setMes(updatedetalleDataAccess.getMes(connexion,updatedetalle));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Update.class)) {
				updatedetalle.setUpdate(updatedetalleDataAccess.getUpdate(connexion,updatedetalle));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				updatedetalle.setAnio(updatedetalleDataAccess.getAnio(connexion,updatedetalle));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				updatedetalle.setMes(updatedetalleDataAccess.getMes(connexion,updatedetalle));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Update.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			updatedetalle.setUpdate(updatedetalleDataAccess.getUpdate(connexion,updatedetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			updatedetalle.setAnio(updatedetalleDataAccess.getAnio(connexion,updatedetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			updatedetalle.setMes(updatedetalleDataAccess.getMes(connexion,updatedetalle));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		updatedetalle.setUpdate(updatedetalleDataAccess.getUpdate(connexion,updatedetalle));
		UpdateLogic updateLogic= new UpdateLogic(connexion);
		updateLogic.deepLoad(updatedetalle.getUpdate(),isDeep,deepLoadType,clases);
				
		updatedetalle.setAnio(updatedetalleDataAccess.getAnio(connexion,updatedetalle));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(updatedetalle.getAnio(),isDeep,deepLoadType,clases);
				
		updatedetalle.setMes(updatedetalleDataAccess.getMes(connexion,updatedetalle));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(updatedetalle.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Update.class)) {
				updatedetalle.setUpdate(updatedetalleDataAccess.getUpdate(connexion,updatedetalle));
				UpdateLogic updateLogic= new UpdateLogic(connexion);
				updateLogic.deepLoad(updatedetalle.getUpdate(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				updatedetalle.setAnio(updatedetalleDataAccess.getAnio(connexion,updatedetalle));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(updatedetalle.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				updatedetalle.setMes(updatedetalleDataAccess.getMes(connexion,updatedetalle));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(updatedetalle.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Update.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			updatedetalle.setUpdate(updatedetalleDataAccess.getUpdate(connexion,updatedetalle));
			UpdateLogic updateLogic= new UpdateLogic(connexion);
			updateLogic.deepLoad(updatedetalle.getUpdate(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			updatedetalle.setAnio(updatedetalleDataAccess.getAnio(connexion,updatedetalle));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(updatedetalle.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			updatedetalle.setMes(updatedetalleDataAccess.getMes(connexion,updatedetalle));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(updatedetalle.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(UpdateDetalle updatedetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(UpdateDetalle.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(updatedetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(updatedetalle);
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
			this.deepLoad(this.updatedetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(UpdateDetalle.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(updatedetalles!=null) {
				for(UpdateDetalle updatedetalle:updatedetalles) {
					this.deepLoad(updatedetalle,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(updatedetalles);
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
			if(updatedetalles!=null) {
				for(UpdateDetalle updatedetalle:updatedetalles) {
					this.deepLoad(updatedetalle,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(updatedetalles);
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
	
	
	public void getUpdateDetallesFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,UpdateDetalleConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updatedetalles=updatedetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUpdateDetallesFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,UpdateDetalleConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updatedetalles=updatedetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUpdateDetallesFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,UpdateDetalleConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updatedetalles=updatedetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUpdateDetallesFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,UpdateDetalleConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updatedetalles=updatedetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUpdateDetallesFK_IdUpdateWithConnection(String sFinalQuery,Pagination pagination,Long id_update)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UpdateDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUpdate= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUpdate.setParameterSelectionGeneralEqual(ParameterType.LONG,id_update,UpdateDetalleConstantesFunciones.IDUPDATE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUpdate);

			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUpdate","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updatedetalles=updatedetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUpdateDetallesFK_IdUpdate(String sFinalQuery,Pagination pagination,Long id_update)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUpdate= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUpdate.setParameterSelectionGeneralEqual(ParameterType.LONG,id_update,UpdateDetalleConstantesFunciones.IDUPDATE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUpdate);

			UpdateDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUpdate","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			updatedetalles=updatedetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UpdateDetalleConstantesFunciones.refrescarForeignKeysDescripcionesUpdateDetalle(this.updatedetalles);
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
			if(UpdateDetalleConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,UpdateDetalleDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,UpdateDetalle updatedetalle,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UpdateDetalleConstantesFunciones.ISCONAUDITORIA) {
				if(updatedetalle.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UpdateDetalleDataAccess.TABLENAME, updatedetalle.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UpdateDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UpdateDetalleLogic.registrarAuditoriaDetallesUpdateDetalle(connexion,updatedetalle,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(updatedetalle.getIsDeleted()) {
					/*if(!updatedetalle.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,UpdateDetalleDataAccess.TABLENAME, updatedetalle.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////UpdateDetalleLogic.registrarAuditoriaDetallesUpdateDetalle(connexion,updatedetalle,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UpdateDetalleDataAccess.TABLENAME, updatedetalle.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(updatedetalle.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UpdateDetalleDataAccess.TABLENAME, updatedetalle.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UpdateDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UpdateDetalleLogic.registrarAuditoriaDetallesUpdateDetalle(connexion,updatedetalle,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesUpdateDetalle(Connexion connexion,UpdateDetalle updatedetalle)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(updatedetalle.getIsNew()||!updatedetalle.getid_update().equals(updatedetalle.getUpdateDetalleOriginal().getid_update()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getid_update()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getid_update().toString();
				}
				if(updatedetalle.getid_update()!=null)
				{
					strValorNuevo=updatedetalle.getid_update().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.IDUPDATE,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getid_anio().equals(updatedetalle.getUpdateDetalleOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getid_anio()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getid_anio().toString();
				}
				if(updatedetalle.getid_anio()!=null)
				{
					strValorNuevo=updatedetalle.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getid_mes().equals(updatedetalle.getUpdateDetalleOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getid_mes()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getid_mes().toString();
				}
				if(updatedetalle.getid_mes()!=null)
				{
					strValorNuevo=updatedetalle.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getcodigo().equals(updatedetalle.getUpdateDetalleOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getcodigo()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getcodigo();
				}
				if(updatedetalle.getcodigo()!=null)
				{
					strValorNuevo=updatedetalle.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getcodigo_proceso().equals(updatedetalle.getUpdateDetalleOriginal().getcodigo_proceso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getcodigo_proceso()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getcodigo_proceso();
				}
				if(updatedetalle.getcodigo_proceso()!=null)
				{
					strValorNuevo=updatedetalle.getcodigo_proceso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.CODIGOPROCESO,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getquery_resumen().equals(updatedetalle.getUpdateDetalleOriginal().getquery_resumen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getquery_resumen()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getquery_resumen();
				}
				if(updatedetalle.getquery_resumen()!=null)
				{
					strValorNuevo=updatedetalle.getquery_resumen() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.QUERYRESUMEN,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getnumero_intento().equals(updatedetalle.getUpdateDetalleOriginal().getnumero_intento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getnumero_intento()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getnumero_intento().toString();
				}
				if(updatedetalle.getnumero_intento()!=null)
				{
					strValorNuevo=updatedetalle.getnumero_intento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.NUMEROINTENTO,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getfecha_archivo().equals(updatedetalle.getUpdateDetalleOriginal().getfecha_archivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getfecha_archivo()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getfecha_archivo().toString();
				}
				if(updatedetalle.getfecha_archivo()!=null)
				{
					strValorNuevo=updatedetalle.getfecha_archivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.FECHAARCHIVO,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getfecha().equals(updatedetalle.getUpdateDetalleOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getfecha()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getfecha().toString();
				}
				if(updatedetalle.getfecha()!=null)
				{
					strValorNuevo=updatedetalle.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getorden().equals(updatedetalle.getUpdateDetalleOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getorden()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getorden().toString();
				}
				if(updatedetalle.getorden()!=null)
				{
					strValorNuevo=updatedetalle.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getejecutado().equals(updatedetalle.getUpdateDetalleOriginal().getejecutado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getejecutado()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getejecutado().toString();
				}
				if(updatedetalle.getejecutado()!=null)
				{
					strValorNuevo=updatedetalle.getejecutado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.EJECUTADO,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getesta_activo().equals(updatedetalle.getUpdateDetalleOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getesta_activo()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getesta_activo().toString();
				}
				if(updatedetalle.getesta_activo()!=null)
				{
					strValorNuevo=updatedetalle.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(updatedetalle.getIsNew()||!updatedetalle.getdescripcion().equals(updatedetalle.getUpdateDetalleOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(updatedetalle.getUpdateDetalleOriginal().getdescripcion()!=null)
				{
					strValorActual=updatedetalle.getUpdateDetalleOriginal().getdescripcion();
				}
				if(updatedetalle.getdescripcion()!=null)
				{
					strValorNuevo=updatedetalle.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UpdateDetalleConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfUpdateDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UpdateDetalleConstantesFunciones.getClassesForeignKeysOfUpdateDetalle(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUpdateDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UpdateDetalleConstantesFunciones.getClassesRelationshipsOfUpdateDetalle(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

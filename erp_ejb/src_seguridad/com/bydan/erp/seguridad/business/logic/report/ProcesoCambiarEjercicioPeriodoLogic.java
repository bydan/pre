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
package com.bydan.erp.seguridad.business.logic.report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.InputStream;

import java.lang.reflect.Field;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
//import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.resources.general.AuxiliarGeneral;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarEjercicioPeriodoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.report.ProcesoCambiarEjercicioPeriodoParameterGeneral;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarEjercicioPeriodoConstantesFunciones;
import com.bydan.erp.seguridad.business.entity.report.ProcesoCambiarEjercicioPeriodo;

import com.bydan.erp.seguridad.business.logic.report.ProcesoCambiarEjercicioPeriodoLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;














@SuppressWarnings("unused")
public class ProcesoCambiarEjercicioPeriodoLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCambiarEjercicioPeriodoLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCambiarEjercicioPeriodoLogic procesocambiarejercicioperiodoDataAccess; 		
	protected ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo;
	protected List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos;
	protected Object procesocambiarejercicioperiodoObject;	
	protected List<Object> procesocambiarejercicioperiodosObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCambiarEjercicioPeriodoLogic()throws SQLException,Exception {
		try	{
			this.procesocambiarejercicioperiodos= new ArrayList<ProcesoCambiarEjercicioPeriodo>();
			this.procesocambiarejercicioperiodo= new ProcesoCambiarEjercicioPeriodo();
			this.procesocambiarejercicioperiodoObject=new Object();
			this.procesocambiarejercicioperiodosObject=new ArrayList<Object>();
			
			this.procesocambiarejercicioperiodoDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocambiarejercicioperiodoDataAccess.setConnexionType(this.connexionType);
			this.procesocambiarejercicioperiodoDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocambiarejercicioperiodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCambiarEjercicioPeriodoLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocambiarejercicioperiodos= new ArrayList<ProcesoCambiarEjercicioPeriodo>();
			this.procesocambiarejercicioperiodo= new ProcesoCambiarEjercicioPeriodo();
			this.procesocambiarejercicioperiodoObject=new Object();
			this.procesocambiarejercicioperiodosObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocambiarejercicioperiodoDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocambiarejercicioperiodoDataAccess.setConnexionType(this.connexionType);
			this.procesocambiarejercicioperiodoDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocambiarejercicioperiodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCambiarEjercicioPeriodo getProcesoCambiarEjercicioPeriodo() throws Exception {	
		ProcesoCambiarEjercicioPeriodoLogicAdditional.checkProcesoCambiarEjercicioPeriodoToGet(procesocambiarejercicioperiodo,this.datosCliente,this.arrDatoGeneral);
		ProcesoCambiarEjercicioPeriodoLogicAdditional.updateProcesoCambiarEjercicioPeriodoToGet(procesocambiarejercicioperiodo,this.arrDatoGeneral);
		
		return procesocambiarejercicioperiodo;
	}
		
	public void setProcesoCambiarEjercicioPeriodo(ProcesoCambiarEjercicioPeriodo newProcesoCambiarEjercicioPeriodo) {
		this.procesocambiarejercicioperiodo = newProcesoCambiarEjercicioPeriodo;
	}
	
	public List<ProcesoCambiarEjercicioPeriodo> getProcesoCambiarEjercicioPeriodos() throws Exception {		
		this.quitarProcesoCambiarEjercicioPeriodosNulos();
		
		ProcesoCambiarEjercicioPeriodoLogicAdditional.checkProcesoCambiarEjercicioPeriodoToGets(procesocambiarejercicioperiodos,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoLocal: procesocambiarejercicioperiodos ) {
			ProcesoCambiarEjercicioPeriodoLogicAdditional.updateProcesoCambiarEjercicioPeriodoToGet(procesocambiarejercicioperiodoLocal,this.arrDatoGeneral);
		}
		
		return procesocambiarejercicioperiodos;
	}
	
	public void setProcesoCambiarEjercicioPeriodos(List<ProcesoCambiarEjercicioPeriodo> newProcesoCambiarEjercicioPeriodos) {
		this.procesocambiarejercicioperiodos = newProcesoCambiarEjercicioPeriodos;
	}
	
	public Object getProcesoCambiarEjercicioPeriodoObject() {	
		//this.procesocambiarejercicioperiodoObject=this.procesocambiarejercicioperiodoDataAccess.getEntityObject();
		return this.procesocambiarejercicioperiodoObject;
	}
		
	public void setProcesoCambiarEjercicioPeriodoObject(Object newProcesoCambiarEjercicioPeriodoObject) {
		this.procesocambiarejercicioperiodoObject = newProcesoCambiarEjercicioPeriodoObject;
	}
	
	public List<Object> getProcesoCambiarEjercicioPeriodosObject() {		
		//this.procesocambiarejercicioperiodosObject=this.procesocambiarejercicioperiodoDataAccess.getEntitiesObject();
		return this.procesocambiarejercicioperiodosObject;
	}
		
	public void setProcesoCambiarEjercicioPeriodosObject(List<Object> newProcesoCambiarEjercicioPeriodosObject) {
		this.procesocambiarejercicioperiodosObject = newProcesoCambiarEjercicioPeriodosObject;
	}
	
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
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
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public void getNewConnexionToDeep()throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
			
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
	
	/*
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocambiarejercicioperiodos = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarEjercicioPeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarejercicioperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocambiarejercicioperiodos = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		  		  
        try {
			//ProcesoCambiarEjercicioPeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarejercicioperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocambiarejercicioperiodos = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarEjercicioPeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarejercicioperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocambiarejercicioperiodos = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		  		  
        try {
			//ProcesoCambiarEjercicioPeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarejercicioperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocambiarejercicioperiodos = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarEjercicioPeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarejercicioperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocambiarejercicioperiodos = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCambiarEjercicioPeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarejercicioperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCambiarEjercicioPeriodo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarEjercicioPeriodo> entities = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		ProcesoCambiarEjercicioPeriodo entity = new ProcesoCambiarEjercicioPeriodo();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
				entities =this.getEntitiesHibernateNative(connexion,sQuerySelect,queryWhereSelectParameters);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<ProcesoCambiarEjercicioPeriodo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarEjercicioPeriodo> entities = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		ProcesoCambiarEjercicioPeriodo entity = new ProcesoCambiarEjercicioPeriodo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCambiarEjercicioPeriodo();
				
				
      	    	entity=ProcesoCambiarEjercicioPeriodoLogic.getEntityProcesoCambiarEjercicioPeriodo("",entity,resultSet);
      	    	
				//entity.setProcesoCambiarEjercicioPeriodoOriginal( new ProcesoCambiarEjercicioPeriodo());
      	    	//entity.setProcesoCambiarEjercicioPeriodoOriginal(super.getEntity("",entity.getProcesoCambiarEjercicioPeriodoOriginal(),resultSet,ProcesoCambiarEjercicioPeriodoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCambiarEjercicioPeriodoOriginal(ProcesoCambiarEjercicioPeriodoDataAccess.getEntityProcesoCambiarEjercicioPeriodo("",entity.getProcesoCambiarEjercicioPeriodoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCambiarEjercicioPeriodo> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarEjercicioPeriodo> entities = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		ProcesoCambiarEjercicioPeriodo entity = new ProcesoCambiarEjercicioPeriodo();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCambiarEjercicioPeriodo.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCambiarEjercicioPeriodo>((List<ProcesoCambiarEjercicioPeriodo>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCambiarEjercicioPeriodosOriginal(entities);
			
			}  else {
				this.procesocambiarejercicioperiodosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCambiarEjercicioPeriodoConstantesFunciones.quitarEspaciosProcesoCambiarEjercicioPeriodos(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCambiarEjercicioPeriodo getEntityProcesoCambiarEjercicioPeriodo(String strPrefijo,ProcesoCambiarEjercicioPeriodo entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCambiarEjercicioPeriodo getEntityProcesoCambiarEjercicioPeriodo(String strPrefijo,ProcesoCambiarEjercicioPeriodo entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCambiarEjercicioPeriodo.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCambiarEjercicioPeriodo.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCambiarEjercicioPeriodoLogic.setFieldReflectionProcesoCambiarEjercicioPeriodo(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCambiarEjercicioPeriodo(Field field,String strPrefijo,String sColumn,ProcesoCambiarEjercicioPeriodo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public void quitarProcesoCambiarEjercicioPeriodosNulos() throws Exception {				
		
		List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodosAux= new ArrayList<ProcesoCambiarEjercicioPeriodo>();
		
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo:procesocambiarejercicioperiodos) {
			if(procesocambiarejercicioperiodo!=null) {
				procesocambiarejercicioperiodosAux.add(procesocambiarejercicioperiodo);
			}
		}
		
		procesocambiarejercicioperiodos=procesocambiarejercicioperiodosAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCambiarEjercicioPeriodo> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarEjercicioPeriodo> entities = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		ProcesoCambiarEjercicioPeriodo entity = new ProcesoCambiarEjercicioPeriodo();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCambiarEjercicioPeriodo>((List<ProcesoCambiarEjercicioPeriodo>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCambiarEjercicioPeriodosOriginal(entities);
			
			}  else {
				this.procesocambiarejercicioperiodosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCambiarEjercicioPeriodoConstantesFunciones.quitarEspaciosProcesoCambiarEjercicioPeriodos(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocambiarejercicioperiodos = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarEjercicioPeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarejercicioperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocambiarejercicioperiodos = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		  		  
        try {
			//ProcesoCambiarEjercicioPeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarejercicioperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCambiarEjercicioPeriodo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCambiarEjercicioPeriodo> entities = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		ProcesoCambiarEjercicioPeriodo entity = new ProcesoCambiarEjercicioPeriodo();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<ProcesoCambiarEjercicioPeriodo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCambiarEjercicioPeriodo> entities = new  ArrayList<ProcesoCambiarEjercicioPeriodo>();
		ProcesoCambiarEjercicioPeriodo entity = new ProcesoCambiarEjercicioPeriodo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCambiarEjercicioPeriodo();
				
				if(conMapGenerico) {
					entity.setMapProcesoCambiarEjercicioPeriodo( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCambiarEjercicioPeriodo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCambiarEjercicioPeriodoDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCambiarEjercicioPeriodoLogic.getEntityProcesoCambiarEjercicioPeriodo("",entity,resultSet,listColumns);
					
					////entity.setProcesoCambiarEjercicioPeriodoOriginal( new ProcesoCambiarEjercicioPeriodo());
					////entity.setProcesoCambiarEjercicioPeriodoOriginal(super.getEntity("",entity.getProcesoCambiarEjercicioPeriodoOriginal(),resultSet,ProcesoCambiarEjercicioPeriodoDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCambiarEjercicioPeriodoOriginal(ProcesoCambiarEjercicioPeriodoDataAccess.getEntityProcesoCambiarEjercicioPeriodo("",entity.getProcesoCambiarEjercicioPeriodoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	public void getProcesoCambiarEjercicioPeriodosBusquedaProcesoCambiarEjercicioPeriodoWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_sistema)throws Exception {
		try {
			ProcesoCambiarEjercicioPeriodoLogicAdditional procesocambiarejercicioperiodoLogicAdditional=new ProcesoCambiarEjercicioPeriodoLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocambiarejercicioperiodoLogicAdditional.BusquedaProcesoCambiarEjercicioPeriodo(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_sistema);

			//this.procesocambiarejercicioperiodos=this.getProcesoCambiarEjercicioPeriodos();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCambiarEjercicioPeriodoLogicAdditional.ProcesarInformacionProcesoCambiarEjercicioPeriodo(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocambiarejercicioperiodoLogicAdditional,this.procesocambiarejercicioperiodos,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCambiarEjercicioPeriodo",fecha_sistema);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCambiarEjercicioPeriodosBusquedaProcesoCambiarEjercicioPeriodo(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_sistema)throws Exception {
		try {
			ProcesoCambiarEjercicioPeriodoLogicAdditional procesocambiarejercicioperiodoLogicAdditional=new ProcesoCambiarEjercicioPeriodoLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocambiarejercicioperiodoLogicAdditional.BusquedaProcesoCambiarEjercicioPeriodo(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_sistema);

			//this.procesocambiarejercicioperiodos=this.getProcesoCambiarEjercicioPeriodos();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCambiarEjercicioPeriodoLogicAdditional.ProcesarInformacionProcesoCambiarEjercicioPeriodo(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocambiarejercicioperiodoLogicAdditional,this.procesocambiarejercicioperiodos,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCambiarEjercicioPeriodo",fecha_sistema);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			ProcesoCambiarEjercicioPeriodoLogicAdditional.updateProcesoCambiarEjercicioPeriodoToGet(procesocambiarejercicioperiodo,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			this.deepLoad(procesocambiarejercicioperiodo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCambiarEjercicioPeriodoConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarEjercicioPeriodo(procesocambiarejercicioperiodo);
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
			this.deepLoad(this.procesocambiarejercicioperiodo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCambiarEjercicioPeriodoConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarEjercicioPeriodo(this.procesocambiarejercicioperiodo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocambiarejercicioperiodos!=null) {
				for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo:procesocambiarejercicioperiodos) {
					this.deepLoad(procesocambiarejercicioperiodo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCambiarEjercicioPeriodoConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarEjercicioPeriodo(procesocambiarejercicioperiodos);
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
			if(procesocambiarejercicioperiodos!=null) {
				for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo:procesocambiarejercicioperiodos) {
					this.deepLoad(procesocambiarejercicioperiodo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCambiarEjercicioPeriodoConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarEjercicioPeriodo(procesocambiarejercicioperiodos);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();	
					
			this.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			this.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public ProcesoCambiarEjercicioPeriodoParameterReturnGeneral procesarAccionProcesoCambiarEjercicioPeriodos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,ProcesoCambiarEjercicioPeriodoParameterReturnGeneral procesocambiarejercicioperiodoParameterGeneral)throws Exception {
		 try {	
			ProcesoCambiarEjercicioPeriodoParameterReturnGeneral procesocambiarejercicioperiodoReturnGeneral=new ProcesoCambiarEjercicioPeriodoParameterReturnGeneral();
	
			ProcesoCambiarEjercicioPeriodoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocambiarejercicioperiodos,procesocambiarejercicioperiodoParameterGeneral,procesocambiarejercicioperiodoReturnGeneral);
			
			return procesocambiarejercicioperiodoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCambiarEjercicioPeriodoParameterReturnGeneral procesarAccionProcesoCambiarEjercicioPeriodosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,ProcesoCambiarEjercicioPeriodoParameterReturnGeneral procesocambiarejercicioperiodoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCambiarEjercicioPeriodoParameterReturnGeneral procesocambiarejercicioperiodoReturnGeneral=new ProcesoCambiarEjercicioPeriodoParameterReturnGeneral();
	
			ProcesoCambiarEjercicioPeriodoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocambiarejercicioperiodos,procesocambiarejercicioperiodoParameterGeneral,procesocambiarejercicioperiodoReturnGeneral);
			
			this.connexion.commit();
			
			return procesocambiarejercicioperiodoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoCambiarEjercicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,String sTipoBusqueda,Date fecha_sistemaBusquedaProcesoCambiarEjercicioPeriodo) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoCambiarEjercicioPeriodoLogicAdditional procesocambiarejercicioperiodoLogicAdditional=new ProcesoCambiarEjercicioPeriodoLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesocambiarejercicioperiodoLogicAdditional.setConnexion(this.connexion);

			procesocambiarejercicioperiodoLogicAdditional.ProcesarInformacionProcesoCambiarEjercicioPeriodo(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocambiarejercicioperiodos,sTipoBusqueda,fecha_sistemaBusquedaProcesoCambiarEjercicioPeriodo);

			//this.connexion.commit();
		} catch(Exception e) {
			//this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			//this.connexion.close();
		}

		return procesado;
	}

	
}

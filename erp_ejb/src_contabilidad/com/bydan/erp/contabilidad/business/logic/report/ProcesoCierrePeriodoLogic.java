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
package com.bydan.erp.contabilidad.business.logic.report;

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

import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.resources.general.AuxiliarGeneral;
import com.bydan.erp.contabilidad.util.report.ProcesoCierrePeriodoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoCierrePeriodoParameterGeneral;
import com.bydan.erp.contabilidad.util.report.ProcesoCierrePeriodoConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.ProcesoCierrePeriodo;

import com.bydan.erp.contabilidad.business.logic.report.ProcesoCierrePeriodoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoCierrePeriodoLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCierrePeriodoLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCierrePeriodoLogic procesocierreperiodoDataAccess; 		
	protected ProcesoCierrePeriodo procesocierreperiodo;
	protected List<ProcesoCierrePeriodo> procesocierreperiodos;
	protected Object procesocierreperiodoObject;	
	protected List<Object> procesocierreperiodosObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCierrePeriodoLogic()throws SQLException,Exception {
		try	{
			this.procesocierreperiodos= new ArrayList<ProcesoCierrePeriodo>();
			this.procesocierreperiodo= new ProcesoCierrePeriodo();
			this.procesocierreperiodoObject=new Object();
			this.procesocierreperiodosObject=new ArrayList<Object>();
			
			this.procesocierreperiodoDataAccess=this;
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
			this.procesocierreperiodoDataAccess.setConnexionType(this.connexionType);
			this.procesocierreperiodoDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocierreperiodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCierrePeriodoLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocierreperiodos= new ArrayList<ProcesoCierrePeriodo>();
			this.procesocierreperiodo= new ProcesoCierrePeriodo();
			this.procesocierreperiodoObject=new Object();
			this.procesocierreperiodosObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocierreperiodoDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocierreperiodoDataAccess.setConnexionType(this.connexionType);
			this.procesocierreperiodoDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocierreperiodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCierrePeriodo getProcesoCierrePeriodo() throws Exception {	
		ProcesoCierrePeriodoLogicAdditional.checkProcesoCierrePeriodoToGet(procesocierreperiodo,this.datosCliente,this.arrDatoGeneral);
		ProcesoCierrePeriodoLogicAdditional.updateProcesoCierrePeriodoToGet(procesocierreperiodo,this.arrDatoGeneral);
		
		return procesocierreperiodo;
	}
		
	public void setProcesoCierrePeriodo(ProcesoCierrePeriodo newProcesoCierrePeriodo) {
		this.procesocierreperiodo = newProcesoCierrePeriodo;
	}
	
	public List<ProcesoCierrePeriodo> getProcesoCierrePeriodos() throws Exception {		
		this.quitarProcesoCierrePeriodosNulos();
		
		ProcesoCierrePeriodoLogicAdditional.checkProcesoCierrePeriodoToGets(procesocierreperiodos,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCierrePeriodo procesocierreperiodoLocal: procesocierreperiodos ) {
			ProcesoCierrePeriodoLogicAdditional.updateProcesoCierrePeriodoToGet(procesocierreperiodoLocal,this.arrDatoGeneral);
		}
		
		return procesocierreperiodos;
	}
	
	public void setProcesoCierrePeriodos(List<ProcesoCierrePeriodo> newProcesoCierrePeriodos) {
		this.procesocierreperiodos = newProcesoCierrePeriodos;
	}
	
	public Object getProcesoCierrePeriodoObject() {	
		//this.procesocierreperiodoObject=this.procesocierreperiodoDataAccess.getEntityObject();
		return this.procesocierreperiodoObject;
	}
		
	public void setProcesoCierrePeriodoObject(Object newProcesoCierrePeriodoObject) {
		this.procesocierreperiodoObject = newProcesoCierrePeriodoObject;
	}
	
	public List<Object> getProcesoCierrePeriodosObject() {		
		//this.procesocierreperiodosObject=this.procesocierreperiodoDataAccess.getEntitiesObject();
		return this.procesocierreperiodosObject;
	}
		
	public void setProcesoCierrePeriodosObject(List<Object> newProcesoCierrePeriodosObject) {
		this.procesocierreperiodosObject = newProcesoCierrePeriodosObject;
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
		procesocierreperiodos = new  ArrayList<ProcesoCierrePeriodo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierrePeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocierreperiodos = new  ArrayList<ProcesoCierrePeriodo>();
		  		  
        try {
			//ProcesoCierrePeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocierreperiodos = new  ArrayList<ProcesoCierrePeriodo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierrePeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocierreperiodos = new  ArrayList<ProcesoCierrePeriodo>();
		  		  
        try {
			//ProcesoCierrePeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocierreperiodos = new  ArrayList<ProcesoCierrePeriodo>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierrePeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocierreperiodos = new  ArrayList<ProcesoCierrePeriodo>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCierrePeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCierrePeriodo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierrePeriodo> entities = new  ArrayList<ProcesoCierrePeriodo>();
		ProcesoCierrePeriodo entity = new ProcesoCierrePeriodo();		  
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
	
	public  List<ProcesoCierrePeriodo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierrePeriodo> entities = new  ArrayList<ProcesoCierrePeriodo>();
		ProcesoCierrePeriodo entity = new ProcesoCierrePeriodo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCierrePeriodo();
				
				
      	    	entity=ProcesoCierrePeriodoLogic.getEntityProcesoCierrePeriodo("",entity,resultSet);
      	    	
				//entity.setProcesoCierrePeriodoOriginal( new ProcesoCierrePeriodo());
      	    	//entity.setProcesoCierrePeriodoOriginal(super.getEntity("",entity.getProcesoCierrePeriodoOriginal(),resultSet,ProcesoCierrePeriodoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCierrePeriodoOriginal(ProcesoCierrePeriodoDataAccess.getEntityProcesoCierrePeriodo("",entity.getProcesoCierrePeriodoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCierrePeriodo> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierrePeriodo> entities = new  ArrayList<ProcesoCierrePeriodo>();
		ProcesoCierrePeriodo entity = new ProcesoCierrePeriodo();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCierrePeriodo.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCierrePeriodo>((List<ProcesoCierrePeriodo>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCierrePeriodosOriginal(entities);
			
			}  else {
				this.procesocierreperiodosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCierrePeriodoConstantesFunciones.quitarEspaciosProcesoCierrePeriodos(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCierrePeriodo getEntityProcesoCierrePeriodo(String strPrefijo,ProcesoCierrePeriodo entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_ejercicio(resultSet.getLong(strPrefijo+ProcesoCierrePeriodoConstantesFunciones.IDEJERCICIO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCierrePeriodo getEntityProcesoCierrePeriodo(String strPrefijo,ProcesoCierrePeriodo entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCierrePeriodo.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCierrePeriodo.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCierrePeriodoLogic.setFieldReflectionProcesoCierrePeriodo(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCierrePeriodo(Field field,String strPrefijo,String sColumn,ProcesoCierrePeriodo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoCierrePeriodoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
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
	
	public void quitarProcesoCierrePeriodosNulos() throws Exception {				
		
		List<ProcesoCierrePeriodo> procesocierreperiodosAux= new ArrayList<ProcesoCierrePeriodo>();
		
		for(ProcesoCierrePeriodo procesocierreperiodo:procesocierreperiodos) {
			if(procesocierreperiodo!=null) {
				procesocierreperiodosAux.add(procesocierreperiodo);
			}
		}
		
		procesocierreperiodos=procesocierreperiodosAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCierrePeriodo> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierrePeriodo> entities = new  ArrayList<ProcesoCierrePeriodo>();
		ProcesoCierrePeriodo entity = new ProcesoCierrePeriodo();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCierrePeriodo>((List<ProcesoCierrePeriodo>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCierrePeriodosOriginal(entities);
			
			}  else {
				this.procesocierreperiodosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCierrePeriodoConstantesFunciones.quitarEspaciosProcesoCierrePeriodos(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocierreperiodos = new  ArrayList<ProcesoCierrePeriodo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierrePeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesocierreperiodos = new  ArrayList<ProcesoCierrePeriodo>();
		  		  
        try {
			//ProcesoCierrePeriodoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreperiodos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCierrePeriodo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCierrePeriodo> entities = new  ArrayList<ProcesoCierrePeriodo>();
		ProcesoCierrePeriodo entity = new ProcesoCierrePeriodo();		  
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
	
	public  List<ProcesoCierrePeriodo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCierrePeriodo> entities = new  ArrayList<ProcesoCierrePeriodo>();
		ProcesoCierrePeriodo entity = new ProcesoCierrePeriodo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCierrePeriodo();
				
				if(conMapGenerico) {
					entity.setMapProcesoCierrePeriodo( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCierrePeriodo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCierrePeriodoDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCierrePeriodoLogic.getEntityProcesoCierrePeriodo("",entity,resultSet,listColumns);
					
					////entity.setProcesoCierrePeriodoOriginal( new ProcesoCierrePeriodo());
					////entity.setProcesoCierrePeriodoOriginal(super.getEntity("",entity.getProcesoCierrePeriodoOriginal(),resultSet,ProcesoCierrePeriodoDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCierrePeriodoOriginal(ProcesoCierrePeriodoDataAccess.getEntityProcesoCierrePeriodo("",entity.getProcesoCierrePeriodoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Ejercicio getEjercicio(Connexion connexion,ProcesoCierrePeriodo relprocesocierreperiodo)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relprocesocierreperiodo.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,ProcesoCierrePeriodo relprocesocierreperiodo)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);
			periodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periodo=periodoDataAccess.getEntity(connexion,relprocesocierreperiodo.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public EstadoPeriodo getEstadoPeriodo(Connexion connexion,ProcesoCierrePeriodo relprocesocierreperiodo)throws SQLException,Exception {

		EstadoPeriodo estadoperiodo= new EstadoPeriodo();

		try {
			EstadoPeriodoDataAccess estadoperiodoDataAccess=new EstadoPeriodoDataAccess();

			estadoperiodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoperiodoDataAccess.setConnexionType(this.connexionType);
			estadoperiodoDataAccess.setParameterDbType(this.parameterDbType);
			estadoperiodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			estadoperiodo=estadoperiodoDataAccess.getEntity(connexion,relprocesocierreperiodo.getid_estado_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoperiodo;

	}


	
	
	public void getProcesoCierrePeriodosBusquedaPorIdEjercicioPorIdPeriodoPorEstadoWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_estado_periodo)throws Exception {
		try {
			ProcesoCierrePeriodoLogic procesocierreperiodoLogic=new ProcesoCierrePeriodoLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			//sQuerySelect=ProcesoCierrePeriodoLogic.GetSelecSqlProcesoCierrePeriodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_estado_periodo);

			//this.getEntities(sQuerySelect, sFinalQueryFinal);

			//this.procesocierreperiodos=this.getProcesoCierrePeriodos();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCierrePeriodoLogicAdditional.ProcesarInformacionProcesoCierrePeriodo(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierreperiodoLogic,this.procesocierreperiodos,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaPorIdEjercicioPorIdPeriodoPorEstado",id_ejercicio,id_periodo,id_estado_periodo);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCierrePeriodosBusquedaPorIdEjercicioPorIdPeriodoPorEstado(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_estado_periodo)throws Exception {
		try {
			ProcesoCierrePeriodoLogic procesocierreperiodoLogic=new ProcesoCierrePeriodoLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			//sQuerySelect=ProcesoCierrePeriodoLogic.GetSelecSqlProcesoCierrePeriodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_estado_periodo);

			//this.getEntities(sQuerySelect, sFinalQueryFinal);

			//this.procesocierreperiodos=this.getProcesoCierrePeriodos();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCierrePeriodoLogicAdditional.ProcesarInformacionProcesoCierrePeriodo(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierreperiodoLogic,this.procesocierreperiodos,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaPorIdEjercicioPorIdPeriodoPorEstado",id_ejercicio,id_periodo,id_estado_periodo);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoCierrePeriodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_estado_periodo)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoCierrePeriodo_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" id_empresa="+parametroGeneralUsuario.getid_empresa();
					//existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" id_ejercicio = "+id_ejercicio.toString();
					existeWhere=true;
				}

				if(id_periodo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" id_periodo = "+id_periodo.toString();
					existeWhere=true;
				}

				if(id_estado_periodo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" id_estado_periodo = "+id_estado_periodo.toString();
					existeWhere=true;
				}

				if(existeWhere) {
					sSqlWhere=" where "+sSqlWhere;
				}

				if(sSelectQuery.contains(Constantes2.S_KEYWHERE)) {
					sSql=sSelectQuery.replace(Constantes2.S_KEYWHERE,sSqlWhere);
				} else {
					sSql=sSelectQuery+sSqlWhere;
				}

				//OBTENER EL ORDER BY DESDE FINALQUERY, DONDE PUEDE SER POR ID, POR DEFAUTL DESCRIPTION O FORMADO POR EL CLIENTE DINAMICAMENTE 
				String sOrderBy=FuncionesSql.getOrderSqlFromFinalQuery(sFinalQuery,sSelectQuery);

				sSql=sSql+sOrderBy;

				sSql+=QueryWhereSelectParameters.getPaginationFinalQuery(pagination, connexion.getDbType());

				if(Constantes.ISDEVELOPING) {
					System.out.println(sSql);
				}
			}
		}

		return sSql;
	}
	
	
	public void deepLoad(ProcesoCierrePeriodo procesocierreperiodo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoCierrePeriodoLogicAdditional.updateProcesoCierrePeriodoToGet(procesocierreperiodo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocierreperiodo.setEjercicio(procesocierreperiodoDataAccess.getEjercicio(connexion,procesocierreperiodo));
		procesocierreperiodo.setPeriodo(procesocierreperiodoDataAccess.getPeriodo(connexion,procesocierreperiodo));
		procesocierreperiodo.setEstadoPeriodo(procesocierreperiodoDataAccess.getEstadoPeriodo(connexion,procesocierreperiodo));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				procesocierreperiodo.setEjercicio(procesocierreperiodoDataAccess.getEjercicio(connexion,procesocierreperiodo));
			}

			if(clas.clas.equals(Periodo.class)) {
				procesocierreperiodo.setPeriodo(procesocierreperiodoDataAccess.getPeriodo(connexion,procesocierreperiodo));
			}

			if(clas.clas.equals(EstadoPeriodo.class)) {
				procesocierreperiodo.setEstadoPeriodo(procesocierreperiodoDataAccess.getEstadoPeriodo(connexion,procesocierreperiodo));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreperiodo.setEjercicio(procesocierreperiodoDataAccess.getEjercicio(connexion,procesocierreperiodo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreperiodo.setPeriodo(procesocierreperiodoDataAccess.getPeriodo(connexion,procesocierreperiodo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPeriodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreperiodo.setEstadoPeriodo(procesocierreperiodoDataAccess.getEstadoPeriodo(connexion,procesocierreperiodo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocierreperiodo.setEjercicio(procesocierreperiodoDataAccess.getEjercicio(connexion,procesocierreperiodo));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(procesocierreperiodo.getEjercicio(),isDeep,deepLoadType,clases);
				
		procesocierreperiodo.setPeriodo(procesocierreperiodoDataAccess.getPeriodo(connexion,procesocierreperiodo));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(procesocierreperiodo.getPeriodo(),isDeep,deepLoadType,clases);
				
		procesocierreperiodo.setEstadoPeriodo(procesocierreperiodoDataAccess.getEstadoPeriodo(connexion,procesocierreperiodo));
		EstadoPeriodoLogic estadoperiodoLogic= new EstadoPeriodoLogic(connexion);
		estadoperiodoLogic.deepLoad(procesocierreperiodo.getEstadoPeriodo(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				procesocierreperiodo.setEjercicio(procesocierreperiodoDataAccess.getEjercicio(connexion,procesocierreperiodo));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(procesocierreperiodo.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Periodo.class)) {
				procesocierreperiodo.setPeriodo(procesocierreperiodoDataAccess.getPeriodo(connexion,procesocierreperiodo));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(procesocierreperiodo.getPeriodo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(EstadoPeriodo.class)) {
				procesocierreperiodo.setEstadoPeriodo(procesocierreperiodoDataAccess.getEstadoPeriodo(connexion,procesocierreperiodo));
				EstadoPeriodoLogic estadoperiodoLogic= new EstadoPeriodoLogic(connexion);
				estadoperiodoLogic.deepLoad(procesocierreperiodo.getEstadoPeriodo(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreperiodo.setEjercicio(procesocierreperiodoDataAccess.getEjercicio(connexion,procesocierreperiodo));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(procesocierreperiodo.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreperiodo.setPeriodo(procesocierreperiodoDataAccess.getPeriodo(connexion,procesocierreperiodo));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(procesocierreperiodo.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPeriodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreperiodo.setEstadoPeriodo(procesocierreperiodoDataAccess.getEstadoPeriodo(connexion,procesocierreperiodo));
			EstadoPeriodoLogic estadoperiodoLogic= new EstadoPeriodoLogic(connexion);
			estadoperiodoLogic.deepLoad(procesocierreperiodo.getEstadoPeriodo(),isDeep,deepLoadType,clases);
				
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
			this.getNewConnexionToDeep();
			
			this.deepLoad(procesocierreperiodo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCierrePeriodoConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierrePeriodo(procesocierreperiodo);
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
			this.deepLoad(this.procesocierreperiodo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCierrePeriodoConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierrePeriodo(this.procesocierreperiodo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocierreperiodos!=null) {
				for(ProcesoCierrePeriodo procesocierreperiodo:procesocierreperiodos) {
					this.deepLoad(procesocierreperiodo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCierrePeriodoConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierrePeriodo(procesocierreperiodos);
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
			if(procesocierreperiodos!=null) {
				for(ProcesoCierrePeriodo procesocierreperiodo:procesocierreperiodos) {
					this.deepLoad(procesocierreperiodo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCierrePeriodoConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierrePeriodo(procesocierreperiodos);
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
	
	public ProcesoCierrePeriodoParameterReturnGeneral procesarAccionProcesoCierrePeriodos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCierrePeriodo> procesocierreperiodos,ProcesoCierrePeriodoParameterReturnGeneral procesocierreperiodoParameterGeneral)throws Exception {
		 try {	
			ProcesoCierrePeriodoParameterReturnGeneral procesocierreperiodoReturnGeneral=new ProcesoCierrePeriodoParameterReturnGeneral();
	
			ProcesoCierrePeriodoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocierreperiodos,procesocierreperiodoParameterGeneral,procesocierreperiodoReturnGeneral);
			
			return procesocierreperiodoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCierrePeriodoParameterReturnGeneral procesarAccionProcesoCierrePeriodosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCierrePeriodo> procesocierreperiodos,ProcesoCierrePeriodoParameterReturnGeneral procesocierreperiodoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCierrePeriodoParameterReturnGeneral procesocierreperiodoReturnGeneral=new ProcesoCierrePeriodoParameterReturnGeneral();
	
			ProcesoCierrePeriodoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocierreperiodos,procesocierreperiodoParameterGeneral,procesocierreperiodoReturnGeneral);
			
			this.connexion.commit();
			
			return procesocierreperiodoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoCierrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCierrePeriodo> procesocierreperiodos,String sTipoBusqueda,Long id_ejercicioBusquedaPorIdEjercicioPorIdPeriodoPorEstado,Long id_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado,Long id_estado_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoCierrePeriodoLogicAdditional procesocierreperiodoLogicAdditional=new ProcesoCierrePeriodoLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesocierreperiodoLogicAdditional.setConnexion(this.connexion);

			procesocierreperiodoLogicAdditional.ProcesarInformacionProcesoCierrePeriodo(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierreperiodos,sTipoBusqueda,id_ejercicioBusquedaPorIdEjercicioPorIdPeriodoPorEstado,id_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado,id_estado_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado);

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

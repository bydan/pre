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
import com.bydan.erp.contabilidad.util.report.ReporteTestParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ReporteTestParameterGeneral;
import com.bydan.erp.contabilidad.util.report.ReporteTestConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.ReporteTest;

import com.bydan.erp.contabilidad.business.logic.report.ReporteTestLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ReporteTestLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ReporteTestLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ReporteTestLogic reportetestDataAccess; 		
	protected ReporteTest reportetest;
	protected List<ReporteTest> reportetests;
	protected Object reportetestObject;	
	protected List<Object> reportetestsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ReporteTestLogic()throws SQLException,Exception {
		try	{
			this.reportetests= new ArrayList<ReporteTest>();
			this.reportetest= new ReporteTest();
			this.reportetestObject=new Object();
			this.reportetestsObject=new ArrayList<Object>();
			
			this.reportetestDataAccess=this;
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
			this.reportetestDataAccess.setConnexionType(this.connexionType);
			this.reportetestDataAccess.setParameterDbType(this.parameterDbType);
			this.reportetestDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ReporteTestLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.reportetests= new ArrayList<ReporteTest>();
			this.reportetest= new ReporteTest();
			this.reportetestObject=new Object();
			this.reportetestsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.reportetestDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.reportetestDataAccess.setConnexionType(this.connexionType);
			this.reportetestDataAccess.setParameterDbType(this.parameterDbType);
			this.reportetestDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ReporteTest getReporteTest() throws Exception {	
		ReporteTestLogicAdditional.checkReporteTestToGet(reportetest,this.datosCliente,this.arrDatoGeneral);
		ReporteTestLogicAdditional.updateReporteTestToGet(reportetest,this.arrDatoGeneral);
		
		return reportetest;
	}
		
	public void setReporteTest(ReporteTest newReporteTest) {
		this.reportetest = newReporteTest;
	}
	
	public List<ReporteTest> getReporteTests() throws Exception {		
		this.quitarReporteTestsNulos();
		
		ReporteTestLogicAdditional.checkReporteTestToGets(reportetests,this.datosCliente,this.arrDatoGeneral);
		
		for (ReporteTest reportetestLocal: reportetests ) {
			ReporteTestLogicAdditional.updateReporteTestToGet(reportetestLocal,this.arrDatoGeneral);
		}
		
		return reportetests;
	}
	
	public void setReporteTests(List<ReporteTest> newReporteTests) {
		this.reportetests = newReporteTests;
	}
	
	public Object getReporteTestObject() {	
		//this.reportetestObject=this.reportetestDataAccess.getEntityObject();
		return this.reportetestObject;
	}
		
	public void setReporteTestObject(Object newReporteTestObject) {
		this.reportetestObject = newReporteTestObject;
	}
	
	public List<Object> getReporteTestsObject() {		
		//this.reportetestsObject=this.reportetestDataAccess.getEntitiesObject();
		return this.reportetestsObject;
	}
		
	public void setReporteTestsObject(List<Object> newReporteTestsObject) {
		this.reportetestsObject = newReporteTestsObject;
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
		reportetests = new  ArrayList<ReporteTest>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ReporteTestLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			reportetests=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		reportetests = new  ArrayList<ReporteTest>();
		  		  
        try {
			//ReporteTestLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			reportetests=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		reportetests = new  ArrayList<ReporteTest>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ReporteTestLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			reportetests=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		reportetests = new  ArrayList<ReporteTest>();
		  		  
        try {
			//ReporteTestLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			reportetests=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		reportetests = new  ArrayList<ReporteTest>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ReporteTestLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			reportetests=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		reportetests = new  ArrayList<ReporteTest>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ReporteTestLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			reportetests=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ReporteTest> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReporteTest> entities = new  ArrayList<ReporteTest>();
		ReporteTest entity = new ReporteTest();		  
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
	
	public  List<ReporteTest> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReporteTest> entities = new  ArrayList<ReporteTest>();
		ReporteTest entity = new ReporteTest();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReporteTest();
				
				
      	    	entity=ReporteTestLogic.getEntityReporteTest("",entity,resultSet);
      	    	
				//entity.setReporteTestOriginal( new ReporteTest());
      	    	//entity.setReporteTestOriginal(super.getEntity("",entity.getReporteTestOriginal(),resultSet,ReporteTestDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReporteTestOriginal(ReporteTestDataAccess.getEntityReporteTest("",entity.getReporteTestOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ReporteTest> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReporteTest> entities = new  ArrayList<ReporteTest>();
		ReporteTest entity = new ReporteTest();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ReporteTest.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ReporteTest>((List<ReporteTest>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setReporteTestsOriginal(entities);
			
			}  else {
				this.reportetestsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ReporteTestConstantesFunciones.quitarEspaciosReporteTests(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ReporteTest getEntityReporteTest(String strPrefijo,ReporteTest entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+ReporteTestConstantesFunciones.IDTIPOMOVIMIENTO));
			entity.setnombre(resultSet.getString(strPrefijo+ReporteTestConstantesFunciones.NOMBRE));
			entity.setubicacion(resultSet.getString(strPrefijo+ReporteTestConstantesFunciones.UBICACION));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ReporteTest getEntityReporteTest(String strPrefijo,ReporteTest entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ReporteTest.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ReporteTest.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ReporteTestLogic.setFieldReflectionReporteTest(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionReporteTest(Field field,String strPrefijo,String sColumn,ReporteTest entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ReporteTestConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReporteTestConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReporteTestConstantesFunciones.UBICACION:
					field.set(entity,resultSet.getString(sCampo));
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
	
	public void quitarReporteTestsNulos() throws Exception {				
		
		List<ReporteTest> reportetestsAux= new ArrayList<ReporteTest>();
		
		for(ReporteTest reportetest:reportetests) {
			if(reportetest!=null) {
				reportetestsAux.add(reportetest);
			}
		}
		
		reportetests=reportetestsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ReporteTest> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReporteTest> entities = new  ArrayList<ReporteTest>();
		ReporteTest entity = new ReporteTest();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ReporteTest>((List<ReporteTest>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setReporteTestsOriginal(entities);
			
			}  else {
				this.reportetestsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ReporteTestConstantesFunciones.quitarEspaciosReporteTests(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		reportetests = new  ArrayList<ReporteTest>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ReporteTestLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			reportetests=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		reportetests = new  ArrayList<ReporteTest>();
		  		  
        try {
			//ReporteTestLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			reportetests=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ReporteTest> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReporteTest> entities = new  ArrayList<ReporteTest>();
		ReporteTest entity = new ReporteTest();		  
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
	
	public  List<ReporteTest> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReporteTest> entities = new  ArrayList<ReporteTest>();
		ReporteTest entity = new ReporteTest();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReporteTest();
				
				if(conMapGenerico) {
					entity.setMapReporteTest( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapReporteTest().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ReporteTestDataAccess.ISWITHSCHEMA);         		
					entity=ReporteTestLogic.getEntityReporteTest("",entity,resultSet,listColumns);
					
					////entity.setReporteTestOriginal( new ReporteTest());
					////entity.setReporteTestOriginal(super.getEntity("",entity.getReporteTestOriginal(),resultSet,ReporteTestDataAccess.ISWITHSCHEMA));         		
					////entity.setReporteTestOriginal(ReporteTestDataAccess.getEntityReporteTest("",entity.getReporteTestOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ReporteTest relreportetest)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relreportetest.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Modulo getModulo(Connexion connexion,ReporteTest relreportetest)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);
			moduloDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			modulo=moduloDataAccess.getEntity(connexion,relreportetest.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,ReporteTest relreportetest)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);
			tipomovimientoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relreportetest.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}


	
	
	public void getReporteTestsBusquedaReporteTestWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_empresa,Long id_modulo,String nombre,String ubicacion)throws Exception {
		try {
			//ReporteTestLogic reportetestLogic=new ReporteTestLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ReporteTestLogic.GetSelecSqlReporteTest(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_empresa,id_modulo,nombre,ubicacion);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.reportetests=this.getReporteTests();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getReporteTestsBusquedaReporteTest(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_empresa,Long id_modulo,String nombre,String ubicacion)throws Exception {
		try {
			//ReporteTestLogic reportetestLogic=new ReporteTestLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ReporteTestLogic.GetSelecSqlReporteTest(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_empresa,id_modulo,nombre,ubicacion);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.reportetests=this.getReporteTests();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlReporteTest(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_empresa,Long id_modulo,String nombre,String ubicacion)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ReporteTest_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_modulo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" id_modulo = "+id_modulo.toString();
					existeWhere=true;
				}

				if(nombre!= null && !nombre.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" nombre = "+"'"+nombre+"'";
					existeWhere=true;
				}

				if(ubicacion!= null && !ubicacion.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" ubicacion = "+"'"+ubicacion+"'";
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
	
	
	public void deepLoad(ReporteTest reportetest,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ReporteTestLogicAdditional.updateReporteTestToGet(reportetest,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		reportetest.setEmpresa(reportetestDataAccess.getEmpresa(connexion,reportetest));
		reportetest.setModulo(reportetestDataAccess.getModulo(connexion,reportetest));
		reportetest.setTipoMovimiento(reportetestDataAccess.getTipoMovimiento(connexion,reportetest));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				reportetest.setEmpresa(reportetestDataAccess.getEmpresa(connexion,reportetest));
			}

			if(clas.clas.equals(Modulo.class)) {
				reportetest.setModulo(reportetestDataAccess.getModulo(connexion,reportetest));
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				reportetest.setTipoMovimiento(reportetestDataAccess.getTipoMovimiento(connexion,reportetest));
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
			reportetest.setEmpresa(reportetestDataAccess.getEmpresa(connexion,reportetest));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			reportetest.setModulo(reportetestDataAccess.getModulo(connexion,reportetest));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			reportetest.setTipoMovimiento(reportetestDataAccess.getTipoMovimiento(connexion,reportetest));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		reportetest.setEmpresa(reportetestDataAccess.getEmpresa(connexion,reportetest));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(reportetest.getEmpresa(),isDeep,deepLoadType,clases);
				
		reportetest.setModulo(reportetestDataAccess.getModulo(connexion,reportetest));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(reportetest.getModulo(),isDeep,deepLoadType,clases);
				
		reportetest.setTipoMovimiento(reportetestDataAccess.getTipoMovimiento(connexion,reportetest));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(reportetest.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				reportetest.setEmpresa(reportetestDataAccess.getEmpresa(connexion,reportetest));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(reportetest.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Modulo.class)) {
				reportetest.setModulo(reportetestDataAccess.getModulo(connexion,reportetest));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(reportetest.getModulo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				reportetest.setTipoMovimiento(reportetestDataAccess.getTipoMovimiento(connexion,reportetest));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(reportetest.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			reportetest.setEmpresa(reportetestDataAccess.getEmpresa(connexion,reportetest));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(reportetest.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			reportetest.setModulo(reportetestDataAccess.getModulo(connexion,reportetest));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(reportetest.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			reportetest.setTipoMovimiento(reportetestDataAccess.getTipoMovimiento(connexion,reportetest));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(reportetest.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(reportetest,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReporteTestConstantesFunciones.refrescarForeignKeysDescripcionesReporteTest(reportetest);
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
			this.deepLoad(this.reportetest,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReporteTestConstantesFunciones.refrescarForeignKeysDescripcionesReporteTest(this.reportetest);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(reportetests!=null) {
				for(ReporteTest reportetest:reportetests) {
					this.deepLoad(reportetest,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ReporteTestConstantesFunciones.refrescarForeignKeysDescripcionesReporteTest(reportetests);
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
			if(reportetests!=null) {
				for(ReporteTest reportetest:reportetests) {
					this.deepLoad(reportetest,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ReporteTestConstantesFunciones.refrescarForeignKeysDescripcionesReporteTest(reportetests);
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
	
	public ReporteTestParameterReturnGeneral procesarAccionReporteTests(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReporteTest> reportetests,ReporteTestParameterReturnGeneral reportetestParameterGeneral)throws Exception {
		 try {	
			ReporteTestParameterReturnGeneral reportetestReturnGeneral=new ReporteTestParameterReturnGeneral();
	
			ReporteTestLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,reportetests,reportetestParameterGeneral,reportetestReturnGeneral);
			
			return reportetestReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReporteTestParameterReturnGeneral procesarAccionReporteTestsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReporteTest> reportetests,ReporteTestParameterReturnGeneral reportetestParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ReporteTestParameterReturnGeneral reportetestReturnGeneral=new ReporteTestParameterReturnGeneral();
	
			ReporteTestLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,reportetests,reportetestParameterGeneral,reportetestReturnGeneral);
			
			this.connexion.commit();
			
			return reportetestReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

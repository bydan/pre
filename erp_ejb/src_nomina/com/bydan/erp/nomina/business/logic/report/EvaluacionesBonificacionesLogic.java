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
package com.bydan.erp.nomina.business.logic.report;

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

import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;
import com.bydan.erp.nomina.util.report.EvaluacionesBonificacionesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.EvaluacionesBonificacionesParameterGeneral;
import com.bydan.erp.nomina.util.report.EvaluacionesBonificacionesConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.EvaluacionesBonificaciones;

import com.bydan.erp.nomina.business.logic.report.EvaluacionesBonificacionesLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class EvaluacionesBonificacionesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(EvaluacionesBonificacionesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected EvaluacionesBonificacionesLogic evaluacionesbonificacionesDataAccess; 		
	protected EvaluacionesBonificaciones evaluacionesbonificaciones;
	protected List<EvaluacionesBonificaciones> evaluacionesbonificacioness;
	protected Object evaluacionesbonificacionesObject;	
	protected List<Object> evaluacionesbonificacionessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  EvaluacionesBonificacionesLogic()throws SQLException,Exception {
		try	{
			this.evaluacionesbonificacioness= new ArrayList<EvaluacionesBonificaciones>();
			this.evaluacionesbonificaciones= new EvaluacionesBonificaciones();
			this.evaluacionesbonificacionesObject=new Object();
			this.evaluacionesbonificacionessObject=new ArrayList<Object>();
			
			this.evaluacionesbonificacionesDataAccess=this;
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
			this.evaluacionesbonificacionesDataAccess.setConnexionType(this.connexionType);
			this.evaluacionesbonificacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.evaluacionesbonificacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EvaluacionesBonificacionesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.evaluacionesbonificacioness= new ArrayList<EvaluacionesBonificaciones>();
			this.evaluacionesbonificaciones= new EvaluacionesBonificaciones();
			this.evaluacionesbonificacionesObject=new Object();
			this.evaluacionesbonificacionessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.evaluacionesbonificacionesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.evaluacionesbonificacionesDataAccess.setConnexionType(this.connexionType);
			this.evaluacionesbonificacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.evaluacionesbonificacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EvaluacionesBonificaciones getEvaluacionesBonificaciones() throws Exception {	
		EvaluacionesBonificacionesLogicAdditional.checkEvaluacionesBonificacionesToGet(evaluacionesbonificaciones,this.datosCliente,this.arrDatoGeneral);
		EvaluacionesBonificacionesLogicAdditional.updateEvaluacionesBonificacionesToGet(evaluacionesbonificaciones,this.arrDatoGeneral);
		
		return evaluacionesbonificaciones;
	}
		
	public void setEvaluacionesBonificaciones(EvaluacionesBonificaciones newEvaluacionesBonificaciones) {
		this.evaluacionesbonificaciones = newEvaluacionesBonificaciones;
	}
	
	public List<EvaluacionesBonificaciones> getEvaluacionesBonificacioness() throws Exception {		
		this.quitarEvaluacionesBonificacionessNulos();
		
		EvaluacionesBonificacionesLogicAdditional.checkEvaluacionesBonificacionesToGets(evaluacionesbonificacioness,this.datosCliente,this.arrDatoGeneral);
		
		for (EvaluacionesBonificaciones evaluacionesbonificacionesLocal: evaluacionesbonificacioness ) {
			EvaluacionesBonificacionesLogicAdditional.updateEvaluacionesBonificacionesToGet(evaluacionesbonificacionesLocal,this.arrDatoGeneral);
		}
		
		return evaluacionesbonificacioness;
	}
	
	public void setEvaluacionesBonificacioness(List<EvaluacionesBonificaciones> newEvaluacionesBonificacioness) {
		this.evaluacionesbonificacioness = newEvaluacionesBonificacioness;
	}
	
	public Object getEvaluacionesBonificacionesObject() {	
		//this.evaluacionesbonificacionesObject=this.evaluacionesbonificacionesDataAccess.getEntityObject();
		return this.evaluacionesbonificacionesObject;
	}
		
	public void setEvaluacionesBonificacionesObject(Object newEvaluacionesBonificacionesObject) {
		this.evaluacionesbonificacionesObject = newEvaluacionesBonificacionesObject;
	}
	
	public List<Object> getEvaluacionesBonificacionessObject() {		
		//this.evaluacionesbonificacionessObject=this.evaluacionesbonificacionesDataAccess.getEntitiesObject();
		return this.evaluacionesbonificacionessObject;
	}
		
	public void setEvaluacionesBonificacionessObject(List<Object> newEvaluacionesBonificacionessObject) {
		this.evaluacionesbonificacionessObject = newEvaluacionesBonificacionessObject;
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
		evaluacionesbonificacioness = new  ArrayList<EvaluacionesBonificaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesBonificacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesbonificacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		evaluacionesbonificacioness = new  ArrayList<EvaluacionesBonificaciones>();
		  		  
        try {
			//EvaluacionesBonificacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesbonificacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		evaluacionesbonificacioness = new  ArrayList<EvaluacionesBonificaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesBonificacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesbonificacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		evaluacionesbonificacioness = new  ArrayList<EvaluacionesBonificaciones>();
		  		  
        try {
			//EvaluacionesBonificacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesbonificacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		evaluacionesbonificacioness = new  ArrayList<EvaluacionesBonificaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesBonificacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesbonificacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		evaluacionesbonificacioness = new  ArrayList<EvaluacionesBonificaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//EvaluacionesBonificacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesbonificacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<EvaluacionesBonificaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesBonificaciones> entities = new  ArrayList<EvaluacionesBonificaciones>();
		EvaluacionesBonificaciones entity = new EvaluacionesBonificaciones();		  
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
	
	public  List<EvaluacionesBonificaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesBonificaciones> entities = new  ArrayList<EvaluacionesBonificaciones>();
		EvaluacionesBonificaciones entity = new EvaluacionesBonificaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionesBonificaciones();
				
				
      	    	entity=EvaluacionesBonificacionesLogic.getEntityEvaluacionesBonificaciones("",entity,resultSet);
      	    	
				//entity.setEvaluacionesBonificacionesOriginal( new EvaluacionesBonificaciones());
      	    	//entity.setEvaluacionesBonificacionesOriginal(super.getEntity("",entity.getEvaluacionesBonificacionesOriginal(),resultSet,EvaluacionesBonificacionesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionesBonificacionesOriginal(EvaluacionesBonificacionesDataAccess.getEntityEvaluacionesBonificaciones("",entity.getEvaluacionesBonificacionesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<EvaluacionesBonificaciones> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesBonificaciones> entities = new  ArrayList<EvaluacionesBonificaciones>();
		EvaluacionesBonificaciones entity = new EvaluacionesBonificaciones();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,EvaluacionesBonificaciones.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EvaluacionesBonificaciones>((List<EvaluacionesBonificaciones>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEvaluacionesBonificacionessOriginal(entities);
			
			}  else {
				this.evaluacionesbonificacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EvaluacionesBonificacionesConstantesFunciones.quitarEspaciosEvaluacionesBonificacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static EvaluacionesBonificaciones getEntityEvaluacionesBonificaciones(String strPrefijo,EvaluacionesBonificaciones entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_dato(resultSet.getString(strPrefijo+EvaluacionesBonificacionesConstantesFunciones.CODIGODATO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+EvaluacionesBonificacionesConstantesFunciones.NOMBRECOMPLETO));
			entity.setsueldo(resultSet.getDouble(strPrefijo+EvaluacionesBonificacionesConstantesFunciones.SUELDO));
			entity.setvalor_conocimiento(resultSet.getDouble(strPrefijo+EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO));
			entity.setvalor_eficiencia(resultSet.getDouble(strPrefijo+EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA));
			entity.setvalor_obtenido(resultSet.getDouble(strPrefijo+EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO));
			entity.setvalor_peso(resultSet.getDouble(strPrefijo+EvaluacionesBonificacionesConstantesFunciones.VALORPESO));
			entity.setbonificacion(resultSet.getDouble(strPrefijo+EvaluacionesBonificacionesConstantesFunciones.BONIFICACION));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EvaluacionesBonificaciones getEntityEvaluacionesBonificaciones(String strPrefijo,EvaluacionesBonificaciones entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = EvaluacionesBonificaciones.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = EvaluacionesBonificaciones.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				EvaluacionesBonificacionesLogic.setFieldReflectionEvaluacionesBonificaciones(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEvaluacionesBonificaciones(Field field,String strPrefijo,String sColumn,EvaluacionesBonificaciones entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EvaluacionesBonificacionesConstantesFunciones.CODIGODATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionesBonificacionesConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionesBonificacionesConstantesFunciones.SUELDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesBonificacionesConstantesFunciones.VALORCONOCIMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesBonificacionesConstantesFunciones.VALOREFICIENCIA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesBonificacionesConstantesFunciones.VALOROBTENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesBonificacionesConstantesFunciones.VALORPESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesBonificacionesConstantesFunciones.BONIFICACION:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	public void quitarEvaluacionesBonificacionessNulos() throws Exception {				
		
		List<EvaluacionesBonificaciones> evaluacionesbonificacionessAux= new ArrayList<EvaluacionesBonificaciones>();
		
		for(EvaluacionesBonificaciones evaluacionesbonificaciones:evaluacionesbonificacioness) {
			if(evaluacionesbonificaciones!=null) {
				evaluacionesbonificacionessAux.add(evaluacionesbonificaciones);
			}
		}
		
		evaluacionesbonificacioness=evaluacionesbonificacionessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<EvaluacionesBonificaciones> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesBonificaciones> entities = new  ArrayList<EvaluacionesBonificaciones>();
		EvaluacionesBonificaciones entity = new EvaluacionesBonificaciones();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EvaluacionesBonificaciones>((List<EvaluacionesBonificaciones>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEvaluacionesBonificacionessOriginal(entities);
			
			}  else {
				this.evaluacionesbonificacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EvaluacionesBonificacionesConstantesFunciones.quitarEspaciosEvaluacionesBonificacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		evaluacionesbonificacioness = new  ArrayList<EvaluacionesBonificaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesBonificacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesbonificacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		evaluacionesbonificacioness = new  ArrayList<EvaluacionesBonificaciones>();
		  		  
        try {
			//EvaluacionesBonificacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesbonificacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<EvaluacionesBonificaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionesBonificaciones> entities = new  ArrayList<EvaluacionesBonificaciones>();
		EvaluacionesBonificaciones entity = new EvaluacionesBonificaciones();		  
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
	
	public  List<EvaluacionesBonificaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionesBonificaciones> entities = new  ArrayList<EvaluacionesBonificaciones>();
		EvaluacionesBonificaciones entity = new EvaluacionesBonificaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionesBonificaciones();
				
				if(conMapGenerico) {
					entity.setMapEvaluacionesBonificaciones( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapEvaluacionesBonificaciones().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EvaluacionesBonificacionesDataAccess.ISWITHSCHEMA);         		
					entity=EvaluacionesBonificacionesLogic.getEntityEvaluacionesBonificaciones("",entity,resultSet,listColumns);
					
					////entity.setEvaluacionesBonificacionesOriginal( new EvaluacionesBonificaciones());
					////entity.setEvaluacionesBonificacionesOriginal(super.getEntity("",entity.getEvaluacionesBonificacionesOriginal(),resultSet,EvaluacionesBonificacionesDataAccess.ISWITHSCHEMA));         		
					////entity.setEvaluacionesBonificacionesOriginal(EvaluacionesBonificacionesDataAccess.getEntityEvaluacionesBonificaciones("",entity.getEvaluacionesBonificacionesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public TipoCalificacionEmpleado getTipoCalificacionEmpleado(Connexion connexion,EvaluacionesBonificaciones relevaluacionesbonificaciones)throws SQLException,Exception {

		TipoCalificacionEmpleado tipocalificacionempleado= new TipoCalificacionEmpleado();

		try {
			TipoCalificacionEmpleadoDataAccess tipocalificacionempleadoDataAccess=new TipoCalificacionEmpleadoDataAccess();

			tipocalificacionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocalificacionempleadoDataAccess.setConnexionType(this.connexionType);
			tipocalificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			tipocalificacionempleadoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion,relevaluacionesbonificaciones.getid_tipo_calificacion_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocalificacionempleado;

	}

	public Estructura getEstructura(Connexion connexion,EvaluacionesBonificaciones relevaluacionesbonificaciones)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			estructura=estructuraDataAccess.getEntity(connexion,relevaluacionesbonificaciones.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empresa getEmpresa(Connexion connexion,EvaluacionesBonificaciones relevaluacionesbonificaciones)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relevaluacionesbonificaciones.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,EvaluacionesBonificaciones relevaluacionesbonificaciones)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relevaluacionesbonificaciones.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}


	
	
	public void getEvaluacionesBonificacionessBusquedaEvaluacionesBonificacionesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo)throws Exception {
		try {
			//EvaluacionesBonificacionesLogic evaluacionesbonificacionesLogic=new EvaluacionesBonificacionesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EvaluacionesBonificacionesLogic.GetSelecSqlEvaluacionesBonificaciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_calificacion_empleado,verificado,id_estructura,codigo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.evaluacionesbonificacioness=this.getEvaluacionesBonificacioness();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getEvaluacionesBonificacionessBusquedaEvaluacionesBonificaciones(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo)throws Exception {
		try {
			//EvaluacionesBonificacionesLogic evaluacionesbonificacionesLogic=new EvaluacionesBonificacionesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EvaluacionesBonificacionesLogic.GetSelecSqlEvaluacionesBonificaciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_calificacion_empleado,verificado,id_estructura,codigo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.evaluacionesbonificacioness=this.getEvaluacionesBonificacioness();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlEvaluacionesBonificaciones(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("EvaluacionesBonificaciones_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" e.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" e.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_tipo_calificacion_empleado!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_tipo_calificacion_empleado = "+id_tipo_calificacion_empleado.toString();
					existeWhere=true;
				}

				if(verificado!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.verificado = "+verificado.toString();
					existeWhere=true;
				}

				if(id_estructura!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.id_estructura = "+id_estructura.toString();
					existeWhere=true;
				}

				if(codigo!= null && !codigo.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.codigo = "+"'"+codigo+"'";
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
	
	
	public void deepLoad(EvaluacionesBonificaciones evaluacionesbonificaciones,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EvaluacionesBonificacionesLogicAdditional.updateEvaluacionesBonificacionesToGet(evaluacionesbonificaciones,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionesbonificaciones.setTipoCalificacionEmpleado(evaluacionesbonificacionesDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesbonificaciones));
		evaluacionesbonificaciones.setEstructura(evaluacionesbonificacionesDataAccess.getEstructura(connexion,evaluacionesbonificaciones));
		evaluacionesbonificaciones.setEmpresa(evaluacionesbonificacionesDataAccess.getEmpresa(connexion,evaluacionesbonificaciones));
		evaluacionesbonificaciones.setSucursal(evaluacionesbonificacionesDataAccess.getSucursal(connexion,evaluacionesbonificaciones));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				evaluacionesbonificaciones.setTipoCalificacionEmpleado(evaluacionesbonificacionesDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesbonificaciones));
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionesbonificaciones.setEstructura(evaluacionesbonificacionesDataAccess.getEstructura(connexion,evaluacionesbonificaciones));
			}

			if(clas.clas.equals(Empresa.class)) {
				evaluacionesbonificaciones.setEmpresa(evaluacionesbonificacionesDataAccess.getEmpresa(connexion,evaluacionesbonificaciones));
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionesbonificaciones.setSucursal(evaluacionesbonificacionesDataAccess.getSucursal(connexion,evaluacionesbonificaciones));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesbonificaciones.setTipoCalificacionEmpleado(evaluacionesbonificacionesDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesbonificaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesbonificaciones.setEstructura(evaluacionesbonificacionesDataAccess.getEstructura(connexion,evaluacionesbonificaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesbonificaciones.setEmpresa(evaluacionesbonificacionesDataAccess.getEmpresa(connexion,evaluacionesbonificaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesbonificaciones.setSucursal(evaluacionesbonificacionesDataAccess.getSucursal(connexion,evaluacionesbonificaciones));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionesbonificaciones.setTipoCalificacionEmpleado(evaluacionesbonificacionesDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesbonificaciones));
		TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
		tipocalificacionempleadoLogic.deepLoad(evaluacionesbonificaciones.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);
				
		evaluacionesbonificaciones.setEstructura(evaluacionesbonificacionesDataAccess.getEstructura(connexion,evaluacionesbonificaciones));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(evaluacionesbonificaciones.getEstructura(),isDeep,deepLoadType,clases);
				
		evaluacionesbonificaciones.setEmpresa(evaluacionesbonificacionesDataAccess.getEmpresa(connexion,evaluacionesbonificaciones));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(evaluacionesbonificaciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		evaluacionesbonificaciones.setSucursal(evaluacionesbonificacionesDataAccess.getSucursal(connexion,evaluacionesbonificaciones));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(evaluacionesbonificaciones.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				evaluacionesbonificaciones.setTipoCalificacionEmpleado(evaluacionesbonificacionesDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesbonificaciones));
				TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
				tipocalificacionempleadoLogic.deepLoad(evaluacionesbonificaciones.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionesbonificaciones.setEstructura(evaluacionesbonificacionesDataAccess.getEstructura(connexion,evaluacionesbonificaciones));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(evaluacionesbonificaciones.getEstructura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				evaluacionesbonificaciones.setEmpresa(evaluacionesbonificacionesDataAccess.getEmpresa(connexion,evaluacionesbonificaciones));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(evaluacionesbonificaciones.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionesbonificaciones.setSucursal(evaluacionesbonificacionesDataAccess.getSucursal(connexion,evaluacionesbonificaciones));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(evaluacionesbonificaciones.getSucursal(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesbonificaciones.setTipoCalificacionEmpleado(evaluacionesbonificacionesDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesbonificaciones));
			TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
			tipocalificacionempleadoLogic.deepLoad(evaluacionesbonificaciones.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesbonificaciones.setEstructura(evaluacionesbonificacionesDataAccess.getEstructura(connexion,evaluacionesbonificaciones));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(evaluacionesbonificaciones.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesbonificaciones.setEmpresa(evaluacionesbonificacionesDataAccess.getEmpresa(connexion,evaluacionesbonificaciones));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(evaluacionesbonificaciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesbonificaciones.setSucursal(evaluacionesbonificacionesDataAccess.getSucursal(connexion,evaluacionesbonificaciones));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(evaluacionesbonificaciones.getSucursal(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(evaluacionesbonificaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionesBonificacionesConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesBonificaciones(evaluacionesbonificaciones);
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
			this.deepLoad(this.evaluacionesbonificaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionesBonificacionesConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesBonificaciones(this.evaluacionesbonificaciones);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(evaluacionesbonificacioness!=null) {
				for(EvaluacionesBonificaciones evaluacionesbonificaciones:evaluacionesbonificacioness) {
					this.deepLoad(evaluacionesbonificaciones,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EvaluacionesBonificacionesConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesBonificaciones(evaluacionesbonificacioness);
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
			if(evaluacionesbonificacioness!=null) {
				for(EvaluacionesBonificaciones evaluacionesbonificaciones:evaluacionesbonificacioness) {
					this.deepLoad(evaluacionesbonificaciones,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EvaluacionesBonificacionesConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesBonificaciones(evaluacionesbonificacioness);
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
	
	public EvaluacionesBonificacionesParameterReturnGeneral procesarAccionEvaluacionesBonificacioness(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionesBonificaciones> evaluacionesbonificacioness,EvaluacionesBonificacionesParameterReturnGeneral evaluacionesbonificacionesParameterGeneral)throws Exception {
		 try {	
			EvaluacionesBonificacionesParameterReturnGeneral evaluacionesbonificacionesReturnGeneral=new EvaluacionesBonificacionesParameterReturnGeneral();
	
			EvaluacionesBonificacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionesbonificacioness,evaluacionesbonificacionesParameterGeneral,evaluacionesbonificacionesReturnGeneral);
			
			return evaluacionesbonificacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EvaluacionesBonificacionesParameterReturnGeneral procesarAccionEvaluacionesBonificacionessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionesBonificaciones> evaluacionesbonificacioness,EvaluacionesBonificacionesParameterReturnGeneral evaluacionesbonificacionesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			EvaluacionesBonificacionesParameterReturnGeneral evaluacionesbonificacionesReturnGeneral=new EvaluacionesBonificacionesParameterReturnGeneral();
	
			EvaluacionesBonificacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionesbonificacioness,evaluacionesbonificacionesParameterGeneral,evaluacionesbonificacionesReturnGeneral);
			
			this.connexion.commit();
			
			return evaluacionesbonificacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

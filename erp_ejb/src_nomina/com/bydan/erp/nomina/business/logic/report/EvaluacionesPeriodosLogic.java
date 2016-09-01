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
import com.bydan.erp.nomina.util.report.EvaluacionesPeriodosParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.EvaluacionesPeriodosParameterGeneral;
import com.bydan.erp.nomina.util.report.EvaluacionesPeriodosConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.EvaluacionesPeriodos;

import com.bydan.erp.nomina.business.logic.report.EvaluacionesPeriodosLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class EvaluacionesPeriodosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(EvaluacionesPeriodosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected EvaluacionesPeriodosLogic evaluacionesperiodosDataAccess; 		
	protected EvaluacionesPeriodos evaluacionesperiodos;
	protected List<EvaluacionesPeriodos> evaluacionesperiodoss;
	protected Object evaluacionesperiodosObject;	
	protected List<Object> evaluacionesperiodossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  EvaluacionesPeriodosLogic()throws SQLException,Exception {
		try	{
			this.evaluacionesperiodoss= new ArrayList<EvaluacionesPeriodos>();
			this.evaluacionesperiodos= new EvaluacionesPeriodos();
			this.evaluacionesperiodosObject=new Object();
			this.evaluacionesperiodossObject=new ArrayList<Object>();
			
			this.evaluacionesperiodosDataAccess=this;
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
			this.evaluacionesperiodosDataAccess.setConnexionType(this.connexionType);
			this.evaluacionesperiodosDataAccess.setParameterDbType(this.parameterDbType);
			this.evaluacionesperiodosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EvaluacionesPeriodosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.evaluacionesperiodoss= new ArrayList<EvaluacionesPeriodos>();
			this.evaluacionesperiodos= new EvaluacionesPeriodos();
			this.evaluacionesperiodosObject=new Object();
			this.evaluacionesperiodossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.evaluacionesperiodosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.evaluacionesperiodosDataAccess.setConnexionType(this.connexionType);
			this.evaluacionesperiodosDataAccess.setParameterDbType(this.parameterDbType);
			this.evaluacionesperiodosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EvaluacionesPeriodos getEvaluacionesPeriodos() throws Exception {	
		EvaluacionesPeriodosLogicAdditional.checkEvaluacionesPeriodosToGet(evaluacionesperiodos,this.datosCliente,this.arrDatoGeneral);
		EvaluacionesPeriodosLogicAdditional.updateEvaluacionesPeriodosToGet(evaluacionesperiodos,this.arrDatoGeneral);
		
		return evaluacionesperiodos;
	}
		
	public void setEvaluacionesPeriodos(EvaluacionesPeriodos newEvaluacionesPeriodos) {
		this.evaluacionesperiodos = newEvaluacionesPeriodos;
	}
	
	public List<EvaluacionesPeriodos> getEvaluacionesPeriodoss() throws Exception {		
		this.quitarEvaluacionesPeriodossNulos();
		
		EvaluacionesPeriodosLogicAdditional.checkEvaluacionesPeriodosToGets(evaluacionesperiodoss,this.datosCliente,this.arrDatoGeneral);
		
		for (EvaluacionesPeriodos evaluacionesperiodosLocal: evaluacionesperiodoss ) {
			EvaluacionesPeriodosLogicAdditional.updateEvaluacionesPeriodosToGet(evaluacionesperiodosLocal,this.arrDatoGeneral);
		}
		
		return evaluacionesperiodoss;
	}
	
	public void setEvaluacionesPeriodoss(List<EvaluacionesPeriodos> newEvaluacionesPeriodoss) {
		this.evaluacionesperiodoss = newEvaluacionesPeriodoss;
	}
	
	public Object getEvaluacionesPeriodosObject() {	
		//this.evaluacionesperiodosObject=this.evaluacionesperiodosDataAccess.getEntityObject();
		return this.evaluacionesperiodosObject;
	}
		
	public void setEvaluacionesPeriodosObject(Object newEvaluacionesPeriodosObject) {
		this.evaluacionesperiodosObject = newEvaluacionesPeriodosObject;
	}
	
	public List<Object> getEvaluacionesPeriodossObject() {		
		//this.evaluacionesperiodossObject=this.evaluacionesperiodosDataAccess.getEntitiesObject();
		return this.evaluacionesperiodossObject;
	}
		
	public void setEvaluacionesPeriodossObject(List<Object> newEvaluacionesPeriodossObject) {
		this.evaluacionesperiodossObject = newEvaluacionesPeriodossObject;
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
		evaluacionesperiodoss = new  ArrayList<EvaluacionesPeriodos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesPeriodosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesperiodoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		evaluacionesperiodoss = new  ArrayList<EvaluacionesPeriodos>();
		  		  
        try {
			//EvaluacionesPeriodosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesperiodoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		evaluacionesperiodoss = new  ArrayList<EvaluacionesPeriodos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesPeriodosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesperiodoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		evaluacionesperiodoss = new  ArrayList<EvaluacionesPeriodos>();
		  		  
        try {
			//EvaluacionesPeriodosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesperiodoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		evaluacionesperiodoss = new  ArrayList<EvaluacionesPeriodos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesPeriodosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesperiodoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		evaluacionesperiodoss = new  ArrayList<EvaluacionesPeriodos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//EvaluacionesPeriodosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesperiodoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<EvaluacionesPeriodos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesPeriodos> entities = new  ArrayList<EvaluacionesPeriodos>();
		EvaluacionesPeriodos entity = new EvaluacionesPeriodos();		  
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
	
	public  List<EvaluacionesPeriodos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesPeriodos> entities = new  ArrayList<EvaluacionesPeriodos>();
		EvaluacionesPeriodos entity = new EvaluacionesPeriodos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionesPeriodos();
				
				
      	    	entity=EvaluacionesPeriodosLogic.getEntityEvaluacionesPeriodos("",entity,resultSet);
      	    	
				//entity.setEvaluacionesPeriodosOriginal( new EvaluacionesPeriodos());
      	    	//entity.setEvaluacionesPeriodosOriginal(super.getEntity("",entity.getEvaluacionesPeriodosOriginal(),resultSet,EvaluacionesPeriodosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionesPeriodosOriginal(EvaluacionesPeriodosDataAccess.getEntityEvaluacionesPeriodos("",entity.getEvaluacionesPeriodosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<EvaluacionesPeriodos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesPeriodos> entities = new  ArrayList<EvaluacionesPeriodos>();
		EvaluacionesPeriodos entity = new EvaluacionesPeriodos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,EvaluacionesPeriodos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EvaluacionesPeriodos>((List<EvaluacionesPeriodos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEvaluacionesPeriodossOriginal(entities);
			
			}  else {
				this.evaluacionesperiodossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EvaluacionesPeriodosConstantesFunciones.quitarEspaciosEvaluacionesPeriodoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static EvaluacionesPeriodos getEntityEvaluacionesPeriodos(String strPrefijo,EvaluacionesPeriodos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_dato(resultSet.getString(strPrefijo+EvaluacionesPeriodosConstantesFunciones.CODIGODATO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+EvaluacionesPeriodosConstantesFunciones.NOMBRECOMPLETO));
			entity.setid_formato_nomi_pregunta_nomi(resultSet.getLong(strPrefijo+EvaluacionesPeriodosConstantesFunciones.IDFORMATONOMIPREGUNTANOMI));
			entity.setvalor_conocimiento(resultSet.getDouble(strPrefijo+EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO));
			entity.setvalor_eficiencia(resultSet.getDouble(strPrefijo+EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA));
			entity.setvalor_obtenido(resultSet.getDouble(strPrefijo+EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO));
			entity.setpromedio(resultSet.getDouble(strPrefijo+EvaluacionesPeriodosConstantesFunciones.PROMEDIO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EvaluacionesPeriodos getEntityEvaluacionesPeriodos(String strPrefijo,EvaluacionesPeriodos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = EvaluacionesPeriodos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = EvaluacionesPeriodos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				EvaluacionesPeriodosLogic.setFieldReflectionEvaluacionesPeriodos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEvaluacionesPeriodos(Field field,String strPrefijo,String sColumn,EvaluacionesPeriodos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EvaluacionesPeriodosConstantesFunciones.CODIGODATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionesPeriodosConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionesPeriodosConstantesFunciones.IDFORMATONOMIPREGUNTANOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionesPeriodosConstantesFunciones.VALORCONOCIMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesPeriodosConstantesFunciones.VALOREFICIENCIA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesPeriodosConstantesFunciones.VALOROBTENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesPeriodosConstantesFunciones.PROMEDIO:
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
	
	public void quitarEvaluacionesPeriodossNulos() throws Exception {				
		
		List<EvaluacionesPeriodos> evaluacionesperiodossAux= new ArrayList<EvaluacionesPeriodos>();
		
		for(EvaluacionesPeriodos evaluacionesperiodos:evaluacionesperiodoss) {
			if(evaluacionesperiodos!=null) {
				evaluacionesperiodossAux.add(evaluacionesperiodos);
			}
		}
		
		evaluacionesperiodoss=evaluacionesperiodossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<EvaluacionesPeriodos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesPeriodos> entities = new  ArrayList<EvaluacionesPeriodos>();
		EvaluacionesPeriodos entity = new EvaluacionesPeriodos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EvaluacionesPeriodos>((List<EvaluacionesPeriodos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEvaluacionesPeriodossOriginal(entities);
			
			}  else {
				this.evaluacionesperiodossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EvaluacionesPeriodosConstantesFunciones.quitarEspaciosEvaluacionesPeriodoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		evaluacionesperiodoss = new  ArrayList<EvaluacionesPeriodos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesPeriodosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesperiodoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		evaluacionesperiodoss = new  ArrayList<EvaluacionesPeriodos>();
		  		  
        try {
			//EvaluacionesPeriodosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesperiodoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<EvaluacionesPeriodos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionesPeriodos> entities = new  ArrayList<EvaluacionesPeriodos>();
		EvaluacionesPeriodos entity = new EvaluacionesPeriodos();		  
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
	
	public  List<EvaluacionesPeriodos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionesPeriodos> entities = new  ArrayList<EvaluacionesPeriodos>();
		EvaluacionesPeriodos entity = new EvaluacionesPeriodos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionesPeriodos();
				
				if(conMapGenerico) {
					entity.setMapEvaluacionesPeriodos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapEvaluacionesPeriodos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EvaluacionesPeriodosDataAccess.ISWITHSCHEMA);         		
					entity=EvaluacionesPeriodosLogic.getEntityEvaluacionesPeriodos("",entity,resultSet,listColumns);
					
					////entity.setEvaluacionesPeriodosOriginal( new EvaluacionesPeriodos());
					////entity.setEvaluacionesPeriodosOriginal(super.getEntity("",entity.getEvaluacionesPeriodosOriginal(),resultSet,EvaluacionesPeriodosDataAccess.ISWITHSCHEMA));         		
					////entity.setEvaluacionesPeriodosOriginal(EvaluacionesPeriodosDataAccess.getEntityEvaluacionesPeriodos("",entity.getEvaluacionesPeriodosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public TipoCalificacionEmpleado getTipoCalificacionEmpleado(Connexion connexion,EvaluacionesPeriodos relevaluacionesperiodos)throws SQLException,Exception {

		TipoCalificacionEmpleado tipocalificacionempleado= new TipoCalificacionEmpleado();

		try {
			TipoCalificacionEmpleadoDataAccess tipocalificacionempleadoDataAccess=new TipoCalificacionEmpleadoDataAccess();

			tipocalificacionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocalificacionempleadoDataAccess.setConnexionType(this.connexionType);
			tipocalificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			tipocalificacionempleadoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion,relevaluacionesperiodos.getid_tipo_calificacion_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocalificacionempleado;

	}

	public Estructura getEstructura(Connexion connexion,EvaluacionesPeriodos relevaluacionesperiodos)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			estructura=estructuraDataAccess.getEntity(connexion,relevaluacionesperiodos.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empresa getEmpresa(Connexion connexion,EvaluacionesPeriodos relevaluacionesperiodos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relevaluacionesperiodos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,EvaluacionesPeriodos relevaluacionesperiodos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relevaluacionesperiodos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,EvaluacionesPeriodos relevaluacionesperiodos)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relevaluacionesperiodos.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public TipoEvaluacionEmpleado getTipoEvaluacionEmpleado(Connexion connexion,EvaluacionesPeriodos relevaluacionesperiodos)throws SQLException,Exception {

		TipoEvaluacionEmpleado tipoevaluacionempleado= new TipoEvaluacionEmpleado();

		try {
			TipoEvaluacionEmpleadoDataAccess tipoevaluacionempleadoDataAccess=new TipoEvaluacionEmpleadoDataAccess();

			tipoevaluacionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoevaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			tipoevaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			tipoevaluacionempleadoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoevaluacionempleado=tipoevaluacionempleadoDataAccess.getEntity(connexion,relevaluacionesperiodos.getid_tipo_evaluacion_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoevaluacionempleado;

	}

	public FormatoNomiPreguntaNomi getFormatoNomiPreguntaNomi(Connexion connexion,EvaluacionesPeriodos relevaluacionesperiodos)throws SQLException,Exception {

		FormatoNomiPreguntaNomi formatonomipreguntanomi= new FormatoNomiPreguntaNomi();

		try {
			FormatoNomiPreguntaNomiDataAccess formatonomipreguntanomiDataAccess=new FormatoNomiPreguntaNomiDataAccess();

			formatonomipreguntanomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatonomipreguntanomiDataAccess.setConnexionType(this.connexionType);
			formatonomipreguntanomiDataAccess.setParameterDbType(this.parameterDbType);
			formatonomipreguntanomiDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			formatonomipreguntanomi=formatonomipreguntanomiDataAccess.getEntity(connexion,relevaluacionesperiodos.getid_formato_nomi_pregunta_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomipreguntanomi;

	}


	
	
	public void getEvaluacionesPeriodossBusquedaEvaluacionesPeriodosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo,Long id_ejercicio,Long id_tipo_evaluacion_empleado)throws Exception {
		try {
			//EvaluacionesPeriodosLogic evaluacionesperiodosLogic=new EvaluacionesPeriodosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EvaluacionesPeriodosLogic.GetSelecSqlEvaluacionesPeriodos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_calificacion_empleado,verificado,id_estructura,codigo,id_ejercicio,id_tipo_evaluacion_empleado);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.evaluacionesperiodoss=this.getEvaluacionesPeriodoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getEvaluacionesPeriodossBusquedaEvaluacionesPeriodos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo,Long id_ejercicio,Long id_tipo_evaluacion_empleado)throws Exception {
		try {
			//EvaluacionesPeriodosLogic evaluacionesperiodosLogic=new EvaluacionesPeriodosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EvaluacionesPeriodosLogic.GetSelecSqlEvaluacionesPeriodos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_calificacion_empleado,verificado,id_estructura,codigo,id_ejercicio,id_tipo_evaluacion_empleado);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.evaluacionesperiodoss=this.getEvaluacionesPeriodoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlEvaluacionesPeriodos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo,Long id_ejercicio,Long id_tipo_evaluacion_empleado)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("EvaluacionesPeriodos_Postgres.sql");
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

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" v.id_ejercicio = "+id_ejercicio.toString();
					existeWhere=true;
				}

				if(id_tipo_evaluacion_empleado!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" v.id_tipo_evaluacion_empleado = "+id_tipo_evaluacion_empleado.toString();
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
	
	
	public void deepLoad(EvaluacionesPeriodos evaluacionesperiodos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EvaluacionesPeriodosLogicAdditional.updateEvaluacionesPeriodosToGet(evaluacionesperiodos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionesperiodos.setTipoCalificacionEmpleado(evaluacionesperiodosDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesperiodos));
		evaluacionesperiodos.setEstructura(evaluacionesperiodosDataAccess.getEstructura(connexion,evaluacionesperiodos));
		evaluacionesperiodos.setEmpresa(evaluacionesperiodosDataAccess.getEmpresa(connexion,evaluacionesperiodos));
		evaluacionesperiodos.setSucursal(evaluacionesperiodosDataAccess.getSucursal(connexion,evaluacionesperiodos));
		evaluacionesperiodos.setEjercicio(evaluacionesperiodosDataAccess.getEjercicio(connexion,evaluacionesperiodos));
		evaluacionesperiodos.setTipoEvaluacionEmpleado(evaluacionesperiodosDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionesperiodos));
		evaluacionesperiodos.setFormatoNomiPreguntaNomi(evaluacionesperiodosDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesperiodos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				evaluacionesperiodos.setTipoCalificacionEmpleado(evaluacionesperiodosDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesperiodos));
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionesperiodos.setEstructura(evaluacionesperiodosDataAccess.getEstructura(connexion,evaluacionesperiodos));
			}

			if(clas.clas.equals(Empresa.class)) {
				evaluacionesperiodos.setEmpresa(evaluacionesperiodosDataAccess.getEmpresa(connexion,evaluacionesperiodos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionesperiodos.setSucursal(evaluacionesperiodosDataAccess.getSucursal(connexion,evaluacionesperiodos));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				evaluacionesperiodos.setEjercicio(evaluacionesperiodosDataAccess.getEjercicio(connexion,evaluacionesperiodos));
			}

			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				evaluacionesperiodos.setTipoEvaluacionEmpleado(evaluacionesperiodosDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionesperiodos));
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				evaluacionesperiodos.setFormatoNomiPreguntaNomi(evaluacionesperiodosDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesperiodos));
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
			evaluacionesperiodos.setTipoCalificacionEmpleado(evaluacionesperiodosDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesperiodos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setEstructura(evaluacionesperiodosDataAccess.getEstructura(connexion,evaluacionesperiodos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setEmpresa(evaluacionesperiodosDataAccess.getEmpresa(connexion,evaluacionesperiodos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setSucursal(evaluacionesperiodosDataAccess.getSucursal(connexion,evaluacionesperiodos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setEjercicio(evaluacionesperiodosDataAccess.getEjercicio(connexion,evaluacionesperiodos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setTipoEvaluacionEmpleado(evaluacionesperiodosDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionesperiodos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setFormatoNomiPreguntaNomi(evaluacionesperiodosDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesperiodos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionesperiodos.setTipoCalificacionEmpleado(evaluacionesperiodosDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesperiodos));
		TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
		tipocalificacionempleadoLogic.deepLoad(evaluacionesperiodos.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);
				
		evaluacionesperiodos.setEstructura(evaluacionesperiodosDataAccess.getEstructura(connexion,evaluacionesperiodos));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(evaluacionesperiodos.getEstructura(),isDeep,deepLoadType,clases);
				
		evaluacionesperiodos.setEmpresa(evaluacionesperiodosDataAccess.getEmpresa(connexion,evaluacionesperiodos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(evaluacionesperiodos.getEmpresa(),isDeep,deepLoadType,clases);
				
		evaluacionesperiodos.setSucursal(evaluacionesperiodosDataAccess.getSucursal(connexion,evaluacionesperiodos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(evaluacionesperiodos.getSucursal(),isDeep,deepLoadType,clases);
				
		evaluacionesperiodos.setEjercicio(evaluacionesperiodosDataAccess.getEjercicio(connexion,evaluacionesperiodos));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(evaluacionesperiodos.getEjercicio(),isDeep,deepLoadType,clases);
				
		evaluacionesperiodos.setTipoEvaluacionEmpleado(evaluacionesperiodosDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionesperiodos));
		TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic= new TipoEvaluacionEmpleadoLogic(connexion);
		tipoevaluacionempleadoLogic.deepLoad(evaluacionesperiodos.getTipoEvaluacionEmpleado(),isDeep,deepLoadType,clases);
				
		evaluacionesperiodos.setFormatoNomiPreguntaNomi(evaluacionesperiodosDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesperiodos));
		FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
		formatonomipreguntanomiLogic.deepLoad(evaluacionesperiodos.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				evaluacionesperiodos.setTipoCalificacionEmpleado(evaluacionesperiodosDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesperiodos));
				TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
				tipocalificacionempleadoLogic.deepLoad(evaluacionesperiodos.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionesperiodos.setEstructura(evaluacionesperiodosDataAccess.getEstructura(connexion,evaluacionesperiodos));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(evaluacionesperiodos.getEstructura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				evaluacionesperiodos.setEmpresa(evaluacionesperiodosDataAccess.getEmpresa(connexion,evaluacionesperiodos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(evaluacionesperiodos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionesperiodos.setSucursal(evaluacionesperiodosDataAccess.getSucursal(connexion,evaluacionesperiodos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(evaluacionesperiodos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				evaluacionesperiodos.setEjercicio(evaluacionesperiodosDataAccess.getEjercicio(connexion,evaluacionesperiodos));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(evaluacionesperiodos.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				evaluacionesperiodos.setTipoEvaluacionEmpleado(evaluacionesperiodosDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionesperiodos));
				TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic= new TipoEvaluacionEmpleadoLogic(connexion);
				tipoevaluacionempleadoLogic.deepLoad(evaluacionesperiodos.getTipoEvaluacionEmpleado(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				evaluacionesperiodos.setFormatoNomiPreguntaNomi(evaluacionesperiodosDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesperiodos));
				FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
				formatonomipreguntanomiLogic.deepLoad(evaluacionesperiodos.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);				
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
			evaluacionesperiodos.setTipoCalificacionEmpleado(evaluacionesperiodosDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesperiodos));
			TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
			tipocalificacionempleadoLogic.deepLoad(evaluacionesperiodos.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setEstructura(evaluacionesperiodosDataAccess.getEstructura(connexion,evaluacionesperiodos));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(evaluacionesperiodos.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setEmpresa(evaluacionesperiodosDataAccess.getEmpresa(connexion,evaluacionesperiodos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(evaluacionesperiodos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setSucursal(evaluacionesperiodosDataAccess.getSucursal(connexion,evaluacionesperiodos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(evaluacionesperiodos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setEjercicio(evaluacionesperiodosDataAccess.getEjercicio(connexion,evaluacionesperiodos));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(evaluacionesperiodos.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setTipoEvaluacionEmpleado(evaluacionesperiodosDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionesperiodos));
			TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic= new TipoEvaluacionEmpleadoLogic(connexion);
			tipoevaluacionempleadoLogic.deepLoad(evaluacionesperiodos.getTipoEvaluacionEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesperiodos.setFormatoNomiPreguntaNomi(evaluacionesperiodosDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesperiodos));
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
			formatonomipreguntanomiLogic.deepLoad(evaluacionesperiodos.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(evaluacionesperiodos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionesPeriodosConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesPeriodos(evaluacionesperiodos);
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
			this.deepLoad(this.evaluacionesperiodos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionesPeriodosConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesPeriodos(this.evaluacionesperiodos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(evaluacionesperiodoss!=null) {
				for(EvaluacionesPeriodos evaluacionesperiodos:evaluacionesperiodoss) {
					this.deepLoad(evaluacionesperiodos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EvaluacionesPeriodosConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesPeriodos(evaluacionesperiodoss);
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
			if(evaluacionesperiodoss!=null) {
				for(EvaluacionesPeriodos evaluacionesperiodos:evaluacionesperiodoss) {
					this.deepLoad(evaluacionesperiodos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EvaluacionesPeriodosConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesPeriodos(evaluacionesperiodoss);
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
	
	public EvaluacionesPeriodosParameterReturnGeneral procesarAccionEvaluacionesPeriodoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionesPeriodos> evaluacionesperiodoss,EvaluacionesPeriodosParameterReturnGeneral evaluacionesperiodosParameterGeneral)throws Exception {
		 try {	
			EvaluacionesPeriodosParameterReturnGeneral evaluacionesperiodosReturnGeneral=new EvaluacionesPeriodosParameterReturnGeneral();
	
			EvaluacionesPeriodosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionesperiodoss,evaluacionesperiodosParameterGeneral,evaluacionesperiodosReturnGeneral);
			
			return evaluacionesperiodosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EvaluacionesPeriodosParameterReturnGeneral procesarAccionEvaluacionesPeriodossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionesPeriodos> evaluacionesperiodoss,EvaluacionesPeriodosParameterReturnGeneral evaluacionesperiodosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			EvaluacionesPeriodosParameterReturnGeneral evaluacionesperiodosReturnGeneral=new EvaluacionesPeriodosParameterReturnGeneral();
	
			EvaluacionesPeriodosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionesperiodoss,evaluacionesperiodosParameterGeneral,evaluacionesperiodosReturnGeneral);
			
			this.connexion.commit();
			
			return evaluacionesperiodosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

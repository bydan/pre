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
import com.bydan.erp.nomina.util.report.EvaluacionesFactoresParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.EvaluacionesFactoresParameterGeneral;
import com.bydan.erp.nomina.util.report.EvaluacionesFactoresConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.EvaluacionesFactores;

import com.bydan.erp.nomina.business.logic.report.EvaluacionesFactoresLogicAdditional;
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
public class EvaluacionesFactoresLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(EvaluacionesFactoresLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected EvaluacionesFactoresLogic evaluacionesfactoresDataAccess; 		
	protected EvaluacionesFactores evaluacionesfactores;
	protected List<EvaluacionesFactores> evaluacionesfactoress;
	protected Object evaluacionesfactoresObject;	
	protected List<Object> evaluacionesfactoressObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  EvaluacionesFactoresLogic()throws SQLException,Exception {
		try	{
			this.evaluacionesfactoress= new ArrayList<EvaluacionesFactores>();
			this.evaluacionesfactores= new EvaluacionesFactores();
			this.evaluacionesfactoresObject=new Object();
			this.evaluacionesfactoressObject=new ArrayList<Object>();
			
			this.evaluacionesfactoresDataAccess=this;
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
			this.evaluacionesfactoresDataAccess.setConnexionType(this.connexionType);
			this.evaluacionesfactoresDataAccess.setParameterDbType(this.parameterDbType);
			this.evaluacionesfactoresDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EvaluacionesFactoresLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.evaluacionesfactoress= new ArrayList<EvaluacionesFactores>();
			this.evaluacionesfactores= new EvaluacionesFactores();
			this.evaluacionesfactoresObject=new Object();
			this.evaluacionesfactoressObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.evaluacionesfactoresDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.evaluacionesfactoresDataAccess.setConnexionType(this.connexionType);
			this.evaluacionesfactoresDataAccess.setParameterDbType(this.parameterDbType);
			this.evaluacionesfactoresDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EvaluacionesFactores getEvaluacionesFactores() throws Exception {	
		EvaluacionesFactoresLogicAdditional.checkEvaluacionesFactoresToGet(evaluacionesfactores,this.datosCliente,this.arrDatoGeneral);
		EvaluacionesFactoresLogicAdditional.updateEvaluacionesFactoresToGet(evaluacionesfactores,this.arrDatoGeneral);
		
		return evaluacionesfactores;
	}
		
	public void setEvaluacionesFactores(EvaluacionesFactores newEvaluacionesFactores) {
		this.evaluacionesfactores = newEvaluacionesFactores;
	}
	
	public List<EvaluacionesFactores> getEvaluacionesFactoress() throws Exception {		
		this.quitarEvaluacionesFactoressNulos();
		
		EvaluacionesFactoresLogicAdditional.checkEvaluacionesFactoresToGets(evaluacionesfactoress,this.datosCliente,this.arrDatoGeneral);
		
		for (EvaluacionesFactores evaluacionesfactoresLocal: evaluacionesfactoress ) {
			EvaluacionesFactoresLogicAdditional.updateEvaluacionesFactoresToGet(evaluacionesfactoresLocal,this.arrDatoGeneral);
		}
		
		return evaluacionesfactoress;
	}
	
	public void setEvaluacionesFactoress(List<EvaluacionesFactores> newEvaluacionesFactoress) {
		this.evaluacionesfactoress = newEvaluacionesFactoress;
	}
	
	public Object getEvaluacionesFactoresObject() {	
		//this.evaluacionesfactoresObject=this.evaluacionesfactoresDataAccess.getEntityObject();
		return this.evaluacionesfactoresObject;
	}
		
	public void setEvaluacionesFactoresObject(Object newEvaluacionesFactoresObject) {
		this.evaluacionesfactoresObject = newEvaluacionesFactoresObject;
	}
	
	public List<Object> getEvaluacionesFactoressObject() {		
		//this.evaluacionesfactoressObject=this.evaluacionesfactoresDataAccess.getEntitiesObject();
		return this.evaluacionesfactoressObject;
	}
		
	public void setEvaluacionesFactoressObject(List<Object> newEvaluacionesFactoressObject) {
		this.evaluacionesfactoressObject = newEvaluacionesFactoressObject;
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
		evaluacionesfactoress = new  ArrayList<EvaluacionesFactores>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesFactoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesfactoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		evaluacionesfactoress = new  ArrayList<EvaluacionesFactores>();
		  		  
        try {
			//EvaluacionesFactoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesfactoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		evaluacionesfactoress = new  ArrayList<EvaluacionesFactores>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesFactoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesfactoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		evaluacionesfactoress = new  ArrayList<EvaluacionesFactores>();
		  		  
        try {
			//EvaluacionesFactoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesfactoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		evaluacionesfactoress = new  ArrayList<EvaluacionesFactores>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesFactoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesfactoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		evaluacionesfactoress = new  ArrayList<EvaluacionesFactores>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//EvaluacionesFactoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesfactoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<EvaluacionesFactores> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesFactores> entities = new  ArrayList<EvaluacionesFactores>();
		EvaluacionesFactores entity = new EvaluacionesFactores();		  
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
	
	public  List<EvaluacionesFactores> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesFactores> entities = new  ArrayList<EvaluacionesFactores>();
		EvaluacionesFactores entity = new EvaluacionesFactores();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionesFactores();
				
				
      	    	entity=EvaluacionesFactoresLogic.getEntityEvaluacionesFactores("",entity,resultSet);
      	    	
				//entity.setEvaluacionesFactoresOriginal( new EvaluacionesFactores());
      	    	//entity.setEvaluacionesFactoresOriginal(super.getEntity("",entity.getEvaluacionesFactoresOriginal(),resultSet,EvaluacionesFactoresDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionesFactoresOriginal(EvaluacionesFactoresDataAccess.getEntityEvaluacionesFactores("",entity.getEvaluacionesFactoresOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<EvaluacionesFactores> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesFactores> entities = new  ArrayList<EvaluacionesFactores>();
		EvaluacionesFactores entity = new EvaluacionesFactores();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,EvaluacionesFactores.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EvaluacionesFactores>((List<EvaluacionesFactores>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEvaluacionesFactoressOriginal(entities);
			
			}  else {
				this.evaluacionesfactoressObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EvaluacionesFactoresConstantesFunciones.quitarEspaciosEvaluacionesFactoress(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static EvaluacionesFactores getEntityEvaluacionesFactores(String strPrefijo,EvaluacionesFactores entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_dato(resultSet.getString(strPrefijo+EvaluacionesFactoresConstantesFunciones.CODIGODATO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+EvaluacionesFactoresConstantesFunciones.NOMBRECOMPLETO));
			entity.setid_formato_nomi_pregunta_nomi(resultSet.getLong(strPrefijo+EvaluacionesFactoresConstantesFunciones.IDFORMATONOMIPREGUNTANOMI));
			entity.setvalor_conocimiento(resultSet.getDouble(strPrefijo+EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO));
			entity.setvalor_eficiencia(resultSet.getDouble(strPrefijo+EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA));
			entity.setvalor_obtenido(resultSet.getDouble(strPrefijo+EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO));
			entity.setpromedio(resultSet.getDouble(strPrefijo+EvaluacionesFactoresConstantesFunciones.PROMEDIO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EvaluacionesFactores getEntityEvaluacionesFactores(String strPrefijo,EvaluacionesFactores entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = EvaluacionesFactores.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = EvaluacionesFactores.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				EvaluacionesFactoresLogic.setFieldReflectionEvaluacionesFactores(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEvaluacionesFactores(Field field,String strPrefijo,String sColumn,EvaluacionesFactores entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EvaluacionesFactoresConstantesFunciones.CODIGODATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionesFactoresConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionesFactoresConstantesFunciones.IDFORMATONOMIPREGUNTANOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionesFactoresConstantesFunciones.VALORCONOCIMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesFactoresConstantesFunciones.VALOREFICIENCIA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesFactoresConstantesFunciones.VALOROBTENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EvaluacionesFactoresConstantesFunciones.PROMEDIO:
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
	
	public void quitarEvaluacionesFactoressNulos() throws Exception {				
		
		List<EvaluacionesFactores> evaluacionesfactoressAux= new ArrayList<EvaluacionesFactores>();
		
		for(EvaluacionesFactores evaluacionesfactores:evaluacionesfactoress) {
			if(evaluacionesfactores!=null) {
				evaluacionesfactoressAux.add(evaluacionesfactores);
			}
		}
		
		evaluacionesfactoress=evaluacionesfactoressAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<EvaluacionesFactores> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionesFactores> entities = new  ArrayList<EvaluacionesFactores>();
		EvaluacionesFactores entity = new EvaluacionesFactores();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EvaluacionesFactores>((List<EvaluacionesFactores>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEvaluacionesFactoressOriginal(entities);
			
			}  else {
				this.evaluacionesfactoressObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EvaluacionesFactoresConstantesFunciones.quitarEspaciosEvaluacionesFactoress(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		evaluacionesfactoress = new  ArrayList<EvaluacionesFactores>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EvaluacionesFactoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesfactoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		evaluacionesfactoress = new  ArrayList<EvaluacionesFactores>();
		  		  
        try {
			//EvaluacionesFactoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionesfactoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<EvaluacionesFactores> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionesFactores> entities = new  ArrayList<EvaluacionesFactores>();
		EvaluacionesFactores entity = new EvaluacionesFactores();		  
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
	
	public  List<EvaluacionesFactores> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionesFactores> entities = new  ArrayList<EvaluacionesFactores>();
		EvaluacionesFactores entity = new EvaluacionesFactores();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionesFactores();
				
				if(conMapGenerico) {
					entity.setMapEvaluacionesFactores( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapEvaluacionesFactores().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EvaluacionesFactoresDataAccess.ISWITHSCHEMA);         		
					entity=EvaluacionesFactoresLogic.getEntityEvaluacionesFactores("",entity,resultSet,listColumns);
					
					////entity.setEvaluacionesFactoresOriginal( new EvaluacionesFactores());
					////entity.setEvaluacionesFactoresOriginal(super.getEntity("",entity.getEvaluacionesFactoresOriginal(),resultSet,EvaluacionesFactoresDataAccess.ISWITHSCHEMA));         		
					////entity.setEvaluacionesFactoresOriginal(EvaluacionesFactoresDataAccess.getEntityEvaluacionesFactores("",entity.getEvaluacionesFactoresOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public TipoCalificacionEmpleado getTipoCalificacionEmpleado(Connexion connexion,EvaluacionesFactores relevaluacionesfactores)throws SQLException,Exception {

		TipoCalificacionEmpleado tipocalificacionempleado= new TipoCalificacionEmpleado();

		try {
			TipoCalificacionEmpleadoDataAccess tipocalificacionempleadoDataAccess=new TipoCalificacionEmpleadoDataAccess();

			tipocalificacionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocalificacionempleadoDataAccess.setConnexionType(this.connexionType);
			tipocalificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			tipocalificacionempleadoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion,relevaluacionesfactores.getid_tipo_calificacion_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocalificacionempleado;

	}

	public Estructura getEstructura(Connexion connexion,EvaluacionesFactores relevaluacionesfactores)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			estructura=estructuraDataAccess.getEntity(connexion,relevaluacionesfactores.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empresa getEmpresa(Connexion connexion,EvaluacionesFactores relevaluacionesfactores)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relevaluacionesfactores.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,EvaluacionesFactores relevaluacionesfactores)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relevaluacionesfactores.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public FormatoNomiPreguntaNomi getFormatoNomiPreguntaNomi(Connexion connexion,EvaluacionesFactores relevaluacionesfactores)throws SQLException,Exception {

		FormatoNomiPreguntaNomi formatonomipreguntanomi= new FormatoNomiPreguntaNomi();

		try {
			FormatoNomiPreguntaNomiDataAccess formatonomipreguntanomiDataAccess=new FormatoNomiPreguntaNomiDataAccess();

			formatonomipreguntanomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatonomipreguntanomiDataAccess.setConnexionType(this.connexionType);
			formatonomipreguntanomiDataAccess.setParameterDbType(this.parameterDbType);
			formatonomipreguntanomiDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			formatonomipreguntanomi=formatonomipreguntanomiDataAccess.getEntity(connexion,relevaluacionesfactores.getid_formato_nomi_pregunta_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomipreguntanomi;

	}


	
	
	public void getEvaluacionesFactoressBusquedaEvaluacionesFactoresWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo)throws Exception {
		try {
			//EvaluacionesFactoresLogic evaluacionesfactoresLogic=new EvaluacionesFactoresLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EvaluacionesFactoresLogic.GetSelecSqlEvaluacionesFactores(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_calificacion_empleado,verificado,id_estructura,codigo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.evaluacionesfactoress=this.getEvaluacionesFactoress();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getEvaluacionesFactoressBusquedaEvaluacionesFactores(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo)throws Exception {
		try {
			//EvaluacionesFactoresLogic evaluacionesfactoresLogic=new EvaluacionesFactoresLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EvaluacionesFactoresLogic.GetSelecSqlEvaluacionesFactores(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_calificacion_empleado,verificado,id_estructura,codigo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.evaluacionesfactoress=this.getEvaluacionesFactoress();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlEvaluacionesFactores(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_calificacion_empleado,Boolean verificado,Long id_estructura,String codigo)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("EvaluacionesFactores_Postgres.sql");
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
	
	
	public void deepLoad(EvaluacionesFactores evaluacionesfactores,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EvaluacionesFactoresLogicAdditional.updateEvaluacionesFactoresToGet(evaluacionesfactores,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionesfactores.setTipoCalificacionEmpleado(evaluacionesfactoresDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesfactores));
		evaluacionesfactores.setEstructura(evaluacionesfactoresDataAccess.getEstructura(connexion,evaluacionesfactores));
		evaluacionesfactores.setEmpresa(evaluacionesfactoresDataAccess.getEmpresa(connexion,evaluacionesfactores));
		evaluacionesfactores.setSucursal(evaluacionesfactoresDataAccess.getSucursal(connexion,evaluacionesfactores));
		evaluacionesfactores.setFormatoNomiPreguntaNomi(evaluacionesfactoresDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesfactores));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				evaluacionesfactores.setTipoCalificacionEmpleado(evaluacionesfactoresDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesfactores));
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionesfactores.setEstructura(evaluacionesfactoresDataAccess.getEstructura(connexion,evaluacionesfactores));
			}

			if(clas.clas.equals(Empresa.class)) {
				evaluacionesfactores.setEmpresa(evaluacionesfactoresDataAccess.getEmpresa(connexion,evaluacionesfactores));
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionesfactores.setSucursal(evaluacionesfactoresDataAccess.getSucursal(connexion,evaluacionesfactores));
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				evaluacionesfactores.setFormatoNomiPreguntaNomi(evaluacionesfactoresDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesfactores));
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
			evaluacionesfactores.setTipoCalificacionEmpleado(evaluacionesfactoresDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesfactores));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesfactores.setEstructura(evaluacionesfactoresDataAccess.getEstructura(connexion,evaluacionesfactores));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesfactores.setEmpresa(evaluacionesfactoresDataAccess.getEmpresa(connexion,evaluacionesfactores));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesfactores.setSucursal(evaluacionesfactoresDataAccess.getSucursal(connexion,evaluacionesfactores));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesfactores.setFormatoNomiPreguntaNomi(evaluacionesfactoresDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesfactores));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionesfactores.setTipoCalificacionEmpleado(evaluacionesfactoresDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesfactores));
		TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
		tipocalificacionempleadoLogic.deepLoad(evaluacionesfactores.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);
				
		evaluacionesfactores.setEstructura(evaluacionesfactoresDataAccess.getEstructura(connexion,evaluacionesfactores));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(evaluacionesfactores.getEstructura(),isDeep,deepLoadType,clases);
				
		evaluacionesfactores.setEmpresa(evaluacionesfactoresDataAccess.getEmpresa(connexion,evaluacionesfactores));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(evaluacionesfactores.getEmpresa(),isDeep,deepLoadType,clases);
				
		evaluacionesfactores.setSucursal(evaluacionesfactoresDataAccess.getSucursal(connexion,evaluacionesfactores));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(evaluacionesfactores.getSucursal(),isDeep,deepLoadType,clases);
				
		evaluacionesfactores.setFormatoNomiPreguntaNomi(evaluacionesfactoresDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesfactores));
		FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
		formatonomipreguntanomiLogic.deepLoad(evaluacionesfactores.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				evaluacionesfactores.setTipoCalificacionEmpleado(evaluacionesfactoresDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesfactores));
				TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
				tipocalificacionempleadoLogic.deepLoad(evaluacionesfactores.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionesfactores.setEstructura(evaluacionesfactoresDataAccess.getEstructura(connexion,evaluacionesfactores));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(evaluacionesfactores.getEstructura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				evaluacionesfactores.setEmpresa(evaluacionesfactoresDataAccess.getEmpresa(connexion,evaluacionesfactores));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(evaluacionesfactores.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionesfactores.setSucursal(evaluacionesfactoresDataAccess.getSucursal(connexion,evaluacionesfactores));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(evaluacionesfactores.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				evaluacionesfactores.setFormatoNomiPreguntaNomi(evaluacionesfactoresDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesfactores));
				FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
				formatonomipreguntanomiLogic.deepLoad(evaluacionesfactores.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);				
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
			evaluacionesfactores.setTipoCalificacionEmpleado(evaluacionesfactoresDataAccess.getTipoCalificacionEmpleado(connexion,evaluacionesfactores));
			TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
			tipocalificacionempleadoLogic.deepLoad(evaluacionesfactores.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesfactores.setEstructura(evaluacionesfactoresDataAccess.getEstructura(connexion,evaluacionesfactores));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(evaluacionesfactores.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesfactores.setEmpresa(evaluacionesfactoresDataAccess.getEmpresa(connexion,evaluacionesfactores));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(evaluacionesfactores.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesfactores.setSucursal(evaluacionesfactoresDataAccess.getSucursal(connexion,evaluacionesfactores));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(evaluacionesfactores.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionesfactores.setFormatoNomiPreguntaNomi(evaluacionesfactoresDataAccess.getFormatoNomiPreguntaNomi(connexion,evaluacionesfactores));
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
			formatonomipreguntanomiLogic.deepLoad(evaluacionesfactores.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(evaluacionesfactores,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionesFactoresConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesFactores(evaluacionesfactores);
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
			this.deepLoad(this.evaluacionesfactores,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionesFactoresConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesFactores(this.evaluacionesfactores);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(evaluacionesfactoress!=null) {
				for(EvaluacionesFactores evaluacionesfactores:evaluacionesfactoress) {
					this.deepLoad(evaluacionesfactores,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EvaluacionesFactoresConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesFactores(evaluacionesfactoress);
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
			if(evaluacionesfactoress!=null) {
				for(EvaluacionesFactores evaluacionesfactores:evaluacionesfactoress) {
					this.deepLoad(evaluacionesfactores,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EvaluacionesFactoresConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionesFactores(evaluacionesfactoress);
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
	
	public EvaluacionesFactoresParameterReturnGeneral procesarAccionEvaluacionesFactoress(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionesFactores> evaluacionesfactoress,EvaluacionesFactoresParameterReturnGeneral evaluacionesfactoresParameterGeneral)throws Exception {
		 try {	
			EvaluacionesFactoresParameterReturnGeneral evaluacionesfactoresReturnGeneral=new EvaluacionesFactoresParameterReturnGeneral();
	
			EvaluacionesFactoresLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionesfactoress,evaluacionesfactoresParameterGeneral,evaluacionesfactoresReturnGeneral);
			
			return evaluacionesfactoresReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EvaluacionesFactoresParameterReturnGeneral procesarAccionEvaluacionesFactoressWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionesFactores> evaluacionesfactoress,EvaluacionesFactoresParameterReturnGeneral evaluacionesfactoresParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			EvaluacionesFactoresParameterReturnGeneral evaluacionesfactoresReturnGeneral=new EvaluacionesFactoresParameterReturnGeneral();
	
			EvaluacionesFactoresLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionesfactoress,evaluacionesfactoresParameterGeneral,evaluacionesfactoresReturnGeneral);
			
			this.connexion.commit();
			
			return evaluacionesfactoresReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

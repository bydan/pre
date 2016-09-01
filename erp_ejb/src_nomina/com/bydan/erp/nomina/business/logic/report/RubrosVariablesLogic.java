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
import com.bydan.erp.nomina.util.report.RubrosVariablesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.RubrosVariablesParameterGeneral;
import com.bydan.erp.nomina.util.report.RubrosVariablesConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.RubrosVariables;

import com.bydan.erp.nomina.business.logic.report.RubrosVariablesLogicAdditional;
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
public class RubrosVariablesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(RubrosVariablesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected RubrosVariablesLogic rubrosvariablesDataAccess; 		
	protected RubrosVariables rubrosvariables;
	protected List<RubrosVariables> rubrosvariabless;
	protected Object rubrosvariablesObject;	
	protected List<Object> rubrosvariablessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  RubrosVariablesLogic()throws SQLException,Exception {
		try	{
			this.rubrosvariabless= new ArrayList<RubrosVariables>();
			this.rubrosvariables= new RubrosVariables();
			this.rubrosvariablesObject=new Object();
			this.rubrosvariablessObject=new ArrayList<Object>();
			
			this.rubrosvariablesDataAccess=this;
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
			this.rubrosvariablesDataAccess.setConnexionType(this.connexionType);
			this.rubrosvariablesDataAccess.setParameterDbType(this.parameterDbType);
			this.rubrosvariablesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RubrosVariablesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.rubrosvariabless= new ArrayList<RubrosVariables>();
			this.rubrosvariables= new RubrosVariables();
			this.rubrosvariablesObject=new Object();
			this.rubrosvariablessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.rubrosvariablesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.rubrosvariablesDataAccess.setConnexionType(this.connexionType);
			this.rubrosvariablesDataAccess.setParameterDbType(this.parameterDbType);
			this.rubrosvariablesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RubrosVariables getRubrosVariables() throws Exception {	
		RubrosVariablesLogicAdditional.checkRubrosVariablesToGet(rubrosvariables,this.datosCliente,this.arrDatoGeneral);
		RubrosVariablesLogicAdditional.updateRubrosVariablesToGet(rubrosvariables,this.arrDatoGeneral);
		
		return rubrosvariables;
	}
		
	public void setRubrosVariables(RubrosVariables newRubrosVariables) {
		this.rubrosvariables = newRubrosVariables;
	}
	
	public List<RubrosVariables> getRubrosVariabless() throws Exception {		
		this.quitarRubrosVariablessNulos();
		
		RubrosVariablesLogicAdditional.checkRubrosVariablesToGets(rubrosvariabless,this.datosCliente,this.arrDatoGeneral);
		
		for (RubrosVariables rubrosvariablesLocal: rubrosvariabless ) {
			RubrosVariablesLogicAdditional.updateRubrosVariablesToGet(rubrosvariablesLocal,this.arrDatoGeneral);
		}
		
		return rubrosvariabless;
	}
	
	public void setRubrosVariabless(List<RubrosVariables> newRubrosVariabless) {
		this.rubrosvariabless = newRubrosVariabless;
	}
	
	public Object getRubrosVariablesObject() {	
		//this.rubrosvariablesObject=this.rubrosvariablesDataAccess.getEntityObject();
		return this.rubrosvariablesObject;
	}
		
	public void setRubrosVariablesObject(Object newRubrosVariablesObject) {
		this.rubrosvariablesObject = newRubrosVariablesObject;
	}
	
	public List<Object> getRubrosVariablessObject() {		
		//this.rubrosvariablessObject=this.rubrosvariablesDataAccess.getEntitiesObject();
		return this.rubrosvariablessObject;
	}
		
	public void setRubrosVariablessObject(List<Object> newRubrosVariablessObject) {
		this.rubrosvariablessObject = newRubrosVariablessObject;
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
		rubrosvariabless = new  ArrayList<RubrosVariables>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RubrosVariablesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubrosvariabless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		rubrosvariabless = new  ArrayList<RubrosVariables>();
		  		  
        try {
			//RubrosVariablesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubrosvariabless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rubrosvariabless = new  ArrayList<RubrosVariables>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RubrosVariablesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubrosvariabless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		rubrosvariabless = new  ArrayList<RubrosVariables>();
		  		  
        try {
			//RubrosVariablesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubrosvariabless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		rubrosvariabless = new  ArrayList<RubrosVariables>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RubrosVariablesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubrosvariabless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		rubrosvariabless = new  ArrayList<RubrosVariables>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//RubrosVariablesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubrosvariabless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<RubrosVariables> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubrosVariables> entities = new  ArrayList<RubrosVariables>();
		RubrosVariables entity = new RubrosVariables();		  
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
	
	public  List<RubrosVariables> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubrosVariables> entities = new  ArrayList<RubrosVariables>();
		RubrosVariables entity = new RubrosVariables();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubrosVariables();
				
				
      	    	entity=RubrosVariablesLogic.getEntityRubrosVariables("",entity,resultSet);
      	    	
				//entity.setRubrosVariablesOriginal( new RubrosVariables());
      	    	//entity.setRubrosVariablesOriginal(super.getEntity("",entity.getRubrosVariablesOriginal(),resultSet,RubrosVariablesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubrosVariablesOriginal(RubrosVariablesDataAccess.getEntityRubrosVariables("",entity.getRubrosVariablesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<RubrosVariables> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubrosVariables> entities = new  ArrayList<RubrosVariables>();
		RubrosVariables entity = new RubrosVariables();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,RubrosVariables.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<RubrosVariables>((List<RubrosVariables>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setRubrosVariablessOriginal(entities);
			
			}  else {
				this.rubrosvariablessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//RubrosVariablesConstantesFunciones.quitarEspaciosRubrosVariabless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static RubrosVariables getEntityRubrosVariables(String strPrefijo,RubrosVariables entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+RubrosVariablesConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+RubrosVariablesConstantesFunciones.NOMBRE));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+RubrosVariablesConstantesFunciones.FECHA).getTime()));
			entity.setvalor(resultSet.getDouble(strPrefijo+RubrosVariablesConstantesFunciones.VALOR));
			entity.setnombre_rubro_emplea(resultSet.getString(strPrefijo+RubrosVariablesConstantesFunciones.NOMBRERUBROEMPLEA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RubrosVariables getEntityRubrosVariables(String strPrefijo,RubrosVariables entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = RubrosVariables.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = RubrosVariables.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				RubrosVariablesLogic.setFieldReflectionRubrosVariables(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRubrosVariables(Field field,String strPrefijo,String sColumn,RubrosVariables entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RubrosVariablesConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RubrosVariablesConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RubrosVariablesConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RubrosVariablesConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RubrosVariablesConstantesFunciones.NOMBRERUBROEMPLEA:
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
	
	public void quitarRubrosVariablessNulos() throws Exception {				
		
		List<RubrosVariables> rubrosvariablessAux= new ArrayList<RubrosVariables>();
		
		for(RubrosVariables rubrosvariables:rubrosvariabless) {
			if(rubrosvariables!=null) {
				rubrosvariablessAux.add(rubrosvariables);
			}
		}
		
		rubrosvariabless=rubrosvariablessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<RubrosVariables> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubrosVariables> entities = new  ArrayList<RubrosVariables>();
		RubrosVariables entity = new RubrosVariables();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<RubrosVariables>((List<RubrosVariables>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setRubrosVariablessOriginal(entities);
			
			}  else {
				this.rubrosvariablessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//RubrosVariablesConstantesFunciones.quitarEspaciosRubrosVariabless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		rubrosvariabless = new  ArrayList<RubrosVariables>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RubrosVariablesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubrosvariabless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		rubrosvariabless = new  ArrayList<RubrosVariables>();
		  		  
        try {
			//RubrosVariablesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubrosvariabless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<RubrosVariables> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<RubrosVariables> entities = new  ArrayList<RubrosVariables>();
		RubrosVariables entity = new RubrosVariables();		  
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
	
	public  List<RubrosVariables> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<RubrosVariables> entities = new  ArrayList<RubrosVariables>();
		RubrosVariables entity = new RubrosVariables();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubrosVariables();
				
				if(conMapGenerico) {
					entity.setMapRubrosVariables( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapRubrosVariables().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RubrosVariablesDataAccess.ISWITHSCHEMA);         		
					entity=RubrosVariablesLogic.getEntityRubrosVariables("",entity,resultSet,listColumns);
					
					////entity.setRubrosVariablesOriginal( new RubrosVariables());
					////entity.setRubrosVariablesOriginal(super.getEntity("",entity.getRubrosVariablesOriginal(),resultSet,RubrosVariablesDataAccess.ISWITHSCHEMA));         		
					////entity.setRubrosVariablesOriginal(RubrosVariablesDataAccess.getEntityRubrosVariables("",entity.getRubrosVariablesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public TipoContrato getTipoContrato(Connexion connexion,RubrosVariables relrubrosvariables)throws SQLException,Exception {

		TipoContrato tipocontrato= new TipoContrato();

		try {
			TipoContratoDataAccess tipocontratoDataAccess=new TipoContratoDataAccess();

			tipocontratoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocontratoDataAccess.setConnexionType(this.connexionType);
			tipocontratoDataAccess.setParameterDbType(this.parameterDbType);
			tipocontratoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipocontrato=tipocontratoDataAccess.getEntity(connexion,relrubrosvariables.getid_tipo_contrato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocontrato;

	}

	public Empresa getEmpresa(Connexion connexion,RubrosVariables relrubrosvariables)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relrubrosvariables.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public RubroEmplea getRubroEmplea(Connexion connexion,RubrosVariables relrubrosvariables)throws SQLException,Exception {

		RubroEmplea rubroemplea= new RubroEmplea();

		try {
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);
			rubroempleaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			rubroemplea=rubroempleaDataAccess.getEntity(connexion,relrubrosvariables.getid_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroemplea;

	}


	
	
	public void getRubrosVariablessBusquedaRubrosVariablesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_contrato,Long id_rubro_emplea,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//RubrosVariablesLogic rubrosvariablesLogic=new RubrosVariablesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=RubrosVariablesLogic.GetSelecSqlRubrosVariables(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_contrato,id_rubro_emplea,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.rubrosvariabless=this.getRubrosVariabless();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getRubrosVariablessBusquedaRubrosVariables(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_contrato,Long id_rubro_emplea,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//RubrosVariablesLogic rubrosvariablesLogic=new RubrosVariablesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=RubrosVariablesLogic.GetSelecSqlRubrosVariables(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_contrato,id_rubro_emplea,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.rubrosvariabless=this.getRubrosVariabless();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlRubrosVariables(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_contrato,Long id_rubro_emplea,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("RubrosVariables_Postgres.sql");
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
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" e.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_tipo_contrato!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.id_tipo_contrato = "+id_tipo_contrato.toString();
					existeWhere=true;
				}

				if(id_rubro_emplea!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.id_rubro_emplea = "+id_rubro_emplea.toString();
					existeWhere=true;
				}

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
					existeWhere=true;
				}

				if(fecha_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_hasta)+"'";
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
	
	
	public void deepLoad(RubrosVariables rubrosvariables,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RubrosVariablesLogicAdditional.updateRubrosVariablesToGet(rubrosvariables,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubrosvariables.setTipoContrato(rubrosvariablesDataAccess.getTipoContrato(connexion,rubrosvariables));
		rubrosvariables.setEmpresa(rubrosvariablesDataAccess.getEmpresa(connexion,rubrosvariables));
		rubrosvariables.setRubroEmplea(rubrosvariablesDataAccess.getRubroEmplea(connexion,rubrosvariables));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				rubrosvariables.setTipoContrato(rubrosvariablesDataAccess.getTipoContrato(connexion,rubrosvariables));
			}

			if(clas.clas.equals(Empresa.class)) {
				rubrosvariables.setEmpresa(rubrosvariablesDataAccess.getEmpresa(connexion,rubrosvariables));
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				rubrosvariables.setRubroEmplea(rubrosvariablesDataAccess.getRubroEmplea(connexion,rubrosvariables));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubrosvariables.setTipoContrato(rubrosvariablesDataAccess.getTipoContrato(connexion,rubrosvariables));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubrosvariables.setEmpresa(rubrosvariablesDataAccess.getEmpresa(connexion,rubrosvariables));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubrosvariables.setRubroEmplea(rubrosvariablesDataAccess.getRubroEmplea(connexion,rubrosvariables));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubrosvariables.setTipoContrato(rubrosvariablesDataAccess.getTipoContrato(connexion,rubrosvariables));
		TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
		tipocontratoLogic.deepLoad(rubrosvariables.getTipoContrato(),isDeep,deepLoadType,clases);
				
		rubrosvariables.setEmpresa(rubrosvariablesDataAccess.getEmpresa(connexion,rubrosvariables));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rubrosvariables.getEmpresa(),isDeep,deepLoadType,clases);
				
		rubrosvariables.setRubroEmplea(rubrosvariablesDataAccess.getRubroEmplea(connexion,rubrosvariables));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(rubrosvariables.getRubroEmplea(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				rubrosvariables.setTipoContrato(rubrosvariablesDataAccess.getTipoContrato(connexion,rubrosvariables));
				TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
				tipocontratoLogic.deepLoad(rubrosvariables.getTipoContrato(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				rubrosvariables.setEmpresa(rubrosvariablesDataAccess.getEmpresa(connexion,rubrosvariables));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(rubrosvariables.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				rubrosvariables.setRubroEmplea(rubrosvariablesDataAccess.getRubroEmplea(connexion,rubrosvariables));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(rubrosvariables.getRubroEmplea(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubrosvariables.setTipoContrato(rubrosvariablesDataAccess.getTipoContrato(connexion,rubrosvariables));
			TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
			tipocontratoLogic.deepLoad(rubrosvariables.getTipoContrato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubrosvariables.setEmpresa(rubrosvariablesDataAccess.getEmpresa(connexion,rubrosvariables));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(rubrosvariables.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubrosvariables.setRubroEmplea(rubrosvariablesDataAccess.getRubroEmplea(connexion,rubrosvariables));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(rubrosvariables.getRubroEmplea(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(rubrosvariables,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubrosVariablesConstantesFunciones.refrescarForeignKeysDescripcionesRubrosVariables(rubrosvariables);
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
			this.deepLoad(this.rubrosvariables,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubrosVariablesConstantesFunciones.refrescarForeignKeysDescripcionesRubrosVariables(this.rubrosvariables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(rubrosvariabless!=null) {
				for(RubrosVariables rubrosvariables:rubrosvariabless) {
					this.deepLoad(rubrosvariables,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RubrosVariablesConstantesFunciones.refrescarForeignKeysDescripcionesRubrosVariables(rubrosvariabless);
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
			if(rubrosvariabless!=null) {
				for(RubrosVariables rubrosvariables:rubrosvariabless) {
					this.deepLoad(rubrosvariables,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RubrosVariablesConstantesFunciones.refrescarForeignKeysDescripcionesRubrosVariables(rubrosvariabless);
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
	
	public RubrosVariablesParameterReturnGeneral procesarAccionRubrosVariabless(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubrosVariables> rubrosvariabless,RubrosVariablesParameterReturnGeneral rubrosvariablesParameterGeneral)throws Exception {
		 try {	
			RubrosVariablesParameterReturnGeneral rubrosvariablesReturnGeneral=new RubrosVariablesParameterReturnGeneral();
	
			RubrosVariablesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubrosvariabless,rubrosvariablesParameterGeneral,rubrosvariablesReturnGeneral);
			
			return rubrosvariablesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RubrosVariablesParameterReturnGeneral procesarAccionRubrosVariablessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubrosVariables> rubrosvariabless,RubrosVariablesParameterReturnGeneral rubrosvariablesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			RubrosVariablesParameterReturnGeneral rubrosvariablesReturnGeneral=new RubrosVariablesParameterReturnGeneral();
	
			RubrosVariablesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubrosvariabless,rubrosvariablesParameterGeneral,rubrosvariablesReturnGeneral);
			
			this.connexion.commit();
			
			return rubrosvariablesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

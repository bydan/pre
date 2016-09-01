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
import com.bydan.erp.nomina.util.report.ProcesoUtilidadesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoUtilidadesParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoUtilidadesConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoUtilidades;

import com.bydan.erp.nomina.business.logic.report.ProcesoUtilidadesLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoUtilidadesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoUtilidadesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoUtilidadesLogic procesoutilidadesDataAccess; 		
	protected ProcesoUtilidades procesoutilidades;
	protected List<ProcesoUtilidades> procesoutilidadess;
	protected Object procesoutilidadesObject;	
	protected List<Object> procesoutilidadessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoUtilidadesLogic()throws SQLException,Exception {
		try	{
			this.procesoutilidadess= new ArrayList<ProcesoUtilidades>();
			this.procesoutilidades= new ProcesoUtilidades();
			this.procesoutilidadesObject=new Object();
			this.procesoutilidadessObject=new ArrayList<Object>();
			
			this.procesoutilidadesDataAccess=this;
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
			this.procesoutilidadesDataAccess.setConnexionType(this.connexionType);
			this.procesoutilidadesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoutilidadesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoUtilidadesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesoutilidadess= new ArrayList<ProcesoUtilidades>();
			this.procesoutilidades= new ProcesoUtilidades();
			this.procesoutilidadesObject=new Object();
			this.procesoutilidadessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesoutilidadesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesoutilidadesDataAccess.setConnexionType(this.connexionType);
			this.procesoutilidadesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoutilidadesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoUtilidades getProcesoUtilidades() throws Exception {	
		ProcesoUtilidadesLogicAdditional.checkProcesoUtilidadesToGet(procesoutilidades,this.datosCliente,this.arrDatoGeneral);
		ProcesoUtilidadesLogicAdditional.updateProcesoUtilidadesToGet(procesoutilidades,this.arrDatoGeneral);
		
		return procesoutilidades;
	}
		
	public void setProcesoUtilidades(ProcesoUtilidades newProcesoUtilidades) {
		this.procesoutilidades = newProcesoUtilidades;
	}
	
	public List<ProcesoUtilidades> getProcesoUtilidadess() throws Exception {		
		this.quitarProcesoUtilidadessNulos();
		
		ProcesoUtilidadesLogicAdditional.checkProcesoUtilidadesToGets(procesoutilidadess,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoUtilidades procesoutilidadesLocal: procesoutilidadess ) {
			ProcesoUtilidadesLogicAdditional.updateProcesoUtilidadesToGet(procesoutilidadesLocal,this.arrDatoGeneral);
		}
		
		return procesoutilidadess;
	}
	
	public void setProcesoUtilidadess(List<ProcesoUtilidades> newProcesoUtilidadess) {
		this.procesoutilidadess = newProcesoUtilidadess;
	}
	
	public Object getProcesoUtilidadesObject() {	
		//this.procesoutilidadesObject=this.procesoutilidadesDataAccess.getEntityObject();
		return this.procesoutilidadesObject;
	}
		
	public void setProcesoUtilidadesObject(Object newProcesoUtilidadesObject) {
		this.procesoutilidadesObject = newProcesoUtilidadesObject;
	}
	
	public List<Object> getProcesoUtilidadessObject() {		
		//this.procesoutilidadessObject=this.procesoutilidadesDataAccess.getEntitiesObject();
		return this.procesoutilidadessObject;
	}
		
	public void setProcesoUtilidadessObject(List<Object> newProcesoUtilidadessObject) {
		this.procesoutilidadessObject = newProcesoUtilidadessObject;
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
		procesoutilidadess = new  ArrayList<ProcesoUtilidades>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoUtilidadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoutilidadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesoutilidadess = new  ArrayList<ProcesoUtilidades>();
		  		  
        try {
			//ProcesoUtilidadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoutilidadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesoutilidadess = new  ArrayList<ProcesoUtilidades>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoUtilidadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoutilidadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoutilidadess = new  ArrayList<ProcesoUtilidades>();
		  		  
        try {
			//ProcesoUtilidadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoutilidadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesoutilidadess = new  ArrayList<ProcesoUtilidades>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoUtilidadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoutilidadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoutilidadess = new  ArrayList<ProcesoUtilidades>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoUtilidadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoutilidadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoUtilidades> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoUtilidades> entities = new  ArrayList<ProcesoUtilidades>();
		ProcesoUtilidades entity = new ProcesoUtilidades();		  
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
	
	public  List<ProcesoUtilidades> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoUtilidades> entities = new  ArrayList<ProcesoUtilidades>();
		ProcesoUtilidades entity = new ProcesoUtilidades();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoUtilidades();
				
				
      	    	entity=ProcesoUtilidadesLogic.getEntityProcesoUtilidades("",entity,resultSet);
      	    	
				//entity.setProcesoUtilidadesOriginal( new ProcesoUtilidades());
      	    	//entity.setProcesoUtilidadesOriginal(super.getEntity("",entity.getProcesoUtilidadesOriginal(),resultSet,ProcesoUtilidadesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoUtilidadesOriginal(ProcesoUtilidadesDataAccess.getEntityProcesoUtilidades("",entity.getProcesoUtilidadesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoUtilidades> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoUtilidades> entities = new  ArrayList<ProcesoUtilidades>();
		ProcesoUtilidades entity = new ProcesoUtilidades();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoUtilidades.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoUtilidades>((List<ProcesoUtilidades>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoUtilidadessOriginal(entities);
			
			}  else {
				this.procesoutilidadessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoUtilidadesConstantesFunciones.quitarEspaciosProcesoUtilidadess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoUtilidades getEntityProcesoUtilidades(String strPrefijo,ProcesoUtilidades entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_anio(resultSet.getLong(strPrefijo+ProcesoUtilidadesConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
			entity.setvalor(resultSet.getDouble(strPrefijo+ProcesoUtilidadesConstantesFunciones.VALOR));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoUtilidades getEntityProcesoUtilidades(String strPrefijo,ProcesoUtilidades entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoUtilidades.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoUtilidades.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoUtilidadesLogic.setFieldReflectionProcesoUtilidades(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoUtilidades(Field field,String strPrefijo,String sColumn,ProcesoUtilidades entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoUtilidadesConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoUtilidadesConstantesFunciones.VALOR:
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
	
	public void quitarProcesoUtilidadessNulos() throws Exception {				
		
		List<ProcesoUtilidades> procesoutilidadessAux= new ArrayList<ProcesoUtilidades>();
		
		for(ProcesoUtilidades procesoutilidades:procesoutilidadess) {
			if(procesoutilidades!=null) {
				procesoutilidadessAux.add(procesoutilidades);
			}
		}
		
		procesoutilidadess=procesoutilidadessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoUtilidades> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoUtilidades> entities = new  ArrayList<ProcesoUtilidades>();
		ProcesoUtilidades entity = new ProcesoUtilidades();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoUtilidades>((List<ProcesoUtilidades>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoUtilidadessOriginal(entities);
			
			}  else {
				this.procesoutilidadessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoUtilidadesConstantesFunciones.quitarEspaciosProcesoUtilidadess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesoutilidadess = new  ArrayList<ProcesoUtilidades>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoUtilidadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoutilidadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesoutilidadess = new  ArrayList<ProcesoUtilidades>();
		  		  
        try {
			//ProcesoUtilidadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoutilidadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoUtilidades> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoUtilidades> entities = new  ArrayList<ProcesoUtilidades>();
		ProcesoUtilidades entity = new ProcesoUtilidades();		  
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
	
	public  List<ProcesoUtilidades> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoUtilidades> entities = new  ArrayList<ProcesoUtilidades>();
		ProcesoUtilidades entity = new ProcesoUtilidades();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoUtilidades();
				
				if(conMapGenerico) {
					entity.setMapProcesoUtilidades( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoUtilidades().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoUtilidadesDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoUtilidadesLogic.getEntityProcesoUtilidades("",entity,resultSet,listColumns);
					
					////entity.setProcesoUtilidadesOriginal( new ProcesoUtilidades());
					////entity.setProcesoUtilidadesOriginal(super.getEntity("",entity.getProcesoUtilidadesOriginal(),resultSet,ProcesoUtilidadesDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoUtilidadesOriginal(ProcesoUtilidadesDataAccess.getEntityProcesoUtilidades("",entity.getProcesoUtilidadesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Anio getAnio(Connexion connexion,ProcesoUtilidades relprocesoutilidades)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,relprocesoutilidades.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}


	
	
	public void getProcesoUtilidadessBusquedaProcesoUtilidadesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Double valor)throws Exception {
		try {
			ProcesoUtilidadesLogicAdditional procesoutilidadesLogicAdditional=new ProcesoUtilidadesLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoutilidadesLogicAdditional.BusquedaProcesoUtilidades(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,valor);

			//this.procesoutilidadess=this.getProcesoUtilidadess();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoUtilidadesLogicAdditional.ProcesarInformacionProcesoUtilidades(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoutilidadesLogicAdditional,this.procesoutilidadess,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoUtilidades",id_anio,valor);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoUtilidadessBusquedaProcesoUtilidades(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Double valor)throws Exception {
		try {
			ProcesoUtilidadesLogicAdditional procesoutilidadesLogicAdditional=new ProcesoUtilidadesLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoutilidadesLogicAdditional.BusquedaProcesoUtilidades(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,valor);

			//this.procesoutilidadess=this.getProcesoUtilidadess();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoUtilidadesLogicAdditional.ProcesarInformacionProcesoUtilidades(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoutilidadesLogicAdditional,this.procesoutilidadess,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoUtilidades",id_anio,valor);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoUtilidades procesoutilidades,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoUtilidadesLogicAdditional.updateProcesoUtilidadesToGet(procesoutilidades,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoutilidades.setAnio(procesoutilidadesDataAccess.getAnio(connexion,procesoutilidades));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoutilidades.setAnio(procesoutilidadesDataAccess.getAnio(connexion,procesoutilidades));
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
			procesoutilidades.setAnio(procesoutilidadesDataAccess.getAnio(connexion,procesoutilidades));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoutilidades.setAnio(procesoutilidadesDataAccess.getAnio(connexion,procesoutilidades));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(procesoutilidades.getAnio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoutilidades.setAnio(procesoutilidadesDataAccess.getAnio(connexion,procesoutilidades));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(procesoutilidades.getAnio(),isDeep,deepLoadType,clases);				
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
			procesoutilidades.setAnio(procesoutilidadesDataAccess.getAnio(connexion,procesoutilidades));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(procesoutilidades.getAnio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesoutilidades,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoUtilidadesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoUtilidades(procesoutilidades);
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
			this.deepLoad(this.procesoutilidades,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoUtilidadesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoUtilidades(this.procesoutilidades);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesoutilidadess!=null) {
				for(ProcesoUtilidades procesoutilidades:procesoutilidadess) {
					this.deepLoad(procesoutilidades,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoUtilidadesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoUtilidades(procesoutilidadess);
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
			if(procesoutilidadess!=null) {
				for(ProcesoUtilidades procesoutilidades:procesoutilidadess) {
					this.deepLoad(procesoutilidades,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoUtilidadesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoUtilidades(procesoutilidadess);
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
	
	public ProcesoUtilidadesParameterReturnGeneral procesarAccionProcesoUtilidadess(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoUtilidades> procesoutilidadess,ProcesoUtilidadesParameterReturnGeneral procesoutilidadesParameterGeneral)throws Exception {
		 try {	
			ProcesoUtilidadesParameterReturnGeneral procesoutilidadesReturnGeneral=new ProcesoUtilidadesParameterReturnGeneral();
	
			ProcesoUtilidadesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoutilidadess,procesoutilidadesParameterGeneral,procesoutilidadesReturnGeneral);
			
			return procesoutilidadesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoUtilidadesParameterReturnGeneral procesarAccionProcesoUtilidadessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoUtilidades> procesoutilidadess,ProcesoUtilidadesParameterReturnGeneral procesoutilidadesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoUtilidadesParameterReturnGeneral procesoutilidadesReturnGeneral=new ProcesoUtilidadesParameterReturnGeneral();
	
			ProcesoUtilidadesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoutilidadess,procesoutilidadesParameterGeneral,procesoutilidadesReturnGeneral);
			
			this.connexion.commit();
			
			return procesoutilidadesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoUtilidades(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoUtilidades> procesoutilidadess,String sTipoBusqueda,Long id_anioBusquedaProcesoUtilidades,Double valorBusquedaProcesoUtilidades) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoUtilidadesLogicAdditional procesoutilidadesLogicAdditional=new ProcesoUtilidadesLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesoutilidadesLogicAdditional.setConnexion(this.connexion);

			procesoutilidadesLogicAdditional.ProcesarInformacionProcesoUtilidades(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoutilidadess,sTipoBusqueda,id_anioBusquedaProcesoUtilidades,valorBusquedaProcesoUtilidades);

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

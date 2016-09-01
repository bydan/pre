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
import com.bydan.erp.nomina.util.report.ProcesoGeneraVacacionesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoGeneraVacacionesParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoGeneraVacacionesConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoGeneraVacaciones;

import com.bydan.erp.nomina.business.logic.report.ProcesoGeneraVacacionesLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;














@SuppressWarnings("unused")
public class ProcesoGeneraVacacionesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoGeneraVacacionesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoGeneraVacacionesLogic procesogeneravacacionesDataAccess; 		
	protected ProcesoGeneraVacaciones procesogeneravacaciones;
	protected List<ProcesoGeneraVacaciones> procesogeneravacacioness;
	protected Object procesogeneravacacionesObject;	
	protected List<Object> procesogeneravacacionessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoGeneraVacacionesLogic()throws SQLException,Exception {
		try	{
			this.procesogeneravacacioness= new ArrayList<ProcesoGeneraVacaciones>();
			this.procesogeneravacaciones= new ProcesoGeneraVacaciones();
			this.procesogeneravacacionesObject=new Object();
			this.procesogeneravacacionessObject=new ArrayList<Object>();
			
			this.procesogeneravacacionesDataAccess=this;
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
			this.procesogeneravacacionesDataAccess.setConnexionType(this.connexionType);
			this.procesogeneravacacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesogeneravacacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoGeneraVacacionesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesogeneravacacioness= new ArrayList<ProcesoGeneraVacaciones>();
			this.procesogeneravacaciones= new ProcesoGeneraVacaciones();
			this.procesogeneravacacionesObject=new Object();
			this.procesogeneravacacionessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesogeneravacacionesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesogeneravacacionesDataAccess.setConnexionType(this.connexionType);
			this.procesogeneravacacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesogeneravacacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoGeneraVacaciones getProcesoGeneraVacaciones() throws Exception {	
		ProcesoGeneraVacacionesLogicAdditional.checkProcesoGeneraVacacionesToGet(procesogeneravacaciones,this.datosCliente,this.arrDatoGeneral);
		ProcesoGeneraVacacionesLogicAdditional.updateProcesoGeneraVacacionesToGet(procesogeneravacaciones,this.arrDatoGeneral);
		
		return procesogeneravacaciones;
	}
		
	public void setProcesoGeneraVacaciones(ProcesoGeneraVacaciones newProcesoGeneraVacaciones) {
		this.procesogeneravacaciones = newProcesoGeneraVacaciones;
	}
	
	public List<ProcesoGeneraVacaciones> getProcesoGeneraVacacioness() throws Exception {		
		this.quitarProcesoGeneraVacacionessNulos();
		
		ProcesoGeneraVacacionesLogicAdditional.checkProcesoGeneraVacacionesToGets(procesogeneravacacioness,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoGeneraVacaciones procesogeneravacacionesLocal: procesogeneravacacioness ) {
			ProcesoGeneraVacacionesLogicAdditional.updateProcesoGeneraVacacionesToGet(procesogeneravacacionesLocal,this.arrDatoGeneral);
		}
		
		return procesogeneravacacioness;
	}
	
	public void setProcesoGeneraVacacioness(List<ProcesoGeneraVacaciones> newProcesoGeneraVacacioness) {
		this.procesogeneravacacioness = newProcesoGeneraVacacioness;
	}
	
	public Object getProcesoGeneraVacacionesObject() {	
		//this.procesogeneravacacionesObject=this.procesogeneravacacionesDataAccess.getEntityObject();
		return this.procesogeneravacacionesObject;
	}
		
	public void setProcesoGeneraVacacionesObject(Object newProcesoGeneraVacacionesObject) {
		this.procesogeneravacacionesObject = newProcesoGeneraVacacionesObject;
	}
	
	public List<Object> getProcesoGeneraVacacionessObject() {		
		//this.procesogeneravacacionessObject=this.procesogeneravacacionesDataAccess.getEntitiesObject();
		return this.procesogeneravacacionessObject;
	}
		
	public void setProcesoGeneraVacacionessObject(List<Object> newProcesoGeneraVacacionessObject) {
		this.procesogeneravacacionessObject = newProcesoGeneraVacacionessObject;
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
		procesogeneravacacioness = new  ArrayList<ProcesoGeneraVacaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGeneraVacacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneravacacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesogeneravacacioness = new  ArrayList<ProcesoGeneraVacaciones>();
		  		  
        try {
			//ProcesoGeneraVacacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneravacacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesogeneravacacioness = new  ArrayList<ProcesoGeneraVacaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGeneraVacacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneravacacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesogeneravacacioness = new  ArrayList<ProcesoGeneraVacaciones>();
		  		  
        try {
			//ProcesoGeneraVacacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneravacacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesogeneravacacioness = new  ArrayList<ProcesoGeneraVacaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGeneraVacacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneravacacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesogeneravacacioness = new  ArrayList<ProcesoGeneraVacaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoGeneraVacacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneravacacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoGeneraVacaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGeneraVacaciones> entities = new  ArrayList<ProcesoGeneraVacaciones>();
		ProcesoGeneraVacaciones entity = new ProcesoGeneraVacaciones();		  
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
	
	public  List<ProcesoGeneraVacaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGeneraVacaciones> entities = new  ArrayList<ProcesoGeneraVacaciones>();
		ProcesoGeneraVacaciones entity = new ProcesoGeneraVacaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoGeneraVacaciones();
				
				
      	    	entity=ProcesoGeneraVacacionesLogic.getEntityProcesoGeneraVacaciones("",entity,resultSet);
      	    	
				//entity.setProcesoGeneraVacacionesOriginal( new ProcesoGeneraVacaciones());
      	    	//entity.setProcesoGeneraVacacionesOriginal(super.getEntity("",entity.getProcesoGeneraVacacionesOriginal(),resultSet,ProcesoGeneraVacacionesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoGeneraVacacionesOriginal(ProcesoGeneraVacacionesDataAccess.getEntityProcesoGeneraVacaciones("",entity.getProcesoGeneraVacacionesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoGeneraVacaciones> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGeneraVacaciones> entities = new  ArrayList<ProcesoGeneraVacaciones>();
		ProcesoGeneraVacaciones entity = new ProcesoGeneraVacaciones();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoGeneraVacaciones.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoGeneraVacaciones>((List<ProcesoGeneraVacaciones>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoGeneraVacacionessOriginal(entities);
			
			}  else {
				this.procesogeneravacacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoGeneraVacacionesConstantesFunciones.quitarEspaciosProcesoGeneraVacacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoGeneraVacaciones getEntityProcesoGeneraVacaciones(String strPrefijo,ProcesoGeneraVacaciones entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ProcesoGeneraVacacionesConstantesFunciones.FECHA).getTime()));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoGeneraVacaciones getEntityProcesoGeneraVacaciones(String strPrefijo,ProcesoGeneraVacaciones entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoGeneraVacaciones.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoGeneraVacaciones.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoGeneraVacacionesLogic.setFieldReflectionProcesoGeneraVacaciones(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoGeneraVacaciones(Field field,String strPrefijo,String sColumn,ProcesoGeneraVacaciones entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoGeneraVacacionesConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	public void quitarProcesoGeneraVacacionessNulos() throws Exception {				
		
		List<ProcesoGeneraVacaciones> procesogeneravacacionessAux= new ArrayList<ProcesoGeneraVacaciones>();
		
		for(ProcesoGeneraVacaciones procesogeneravacaciones:procesogeneravacacioness) {
			if(procesogeneravacaciones!=null) {
				procesogeneravacacionessAux.add(procesogeneravacaciones);
			}
		}
		
		procesogeneravacacioness=procesogeneravacacionessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoGeneraVacaciones> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGeneraVacaciones> entities = new  ArrayList<ProcesoGeneraVacaciones>();
		ProcesoGeneraVacaciones entity = new ProcesoGeneraVacaciones();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoGeneraVacaciones>((List<ProcesoGeneraVacaciones>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoGeneraVacacionessOriginal(entities);
			
			}  else {
				this.procesogeneravacacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoGeneraVacacionesConstantesFunciones.quitarEspaciosProcesoGeneraVacacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesogeneravacacioness = new  ArrayList<ProcesoGeneraVacaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGeneraVacacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneravacacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesogeneravacacioness = new  ArrayList<ProcesoGeneraVacaciones>();
		  		  
        try {
			//ProcesoGeneraVacacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneravacacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoGeneraVacaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoGeneraVacaciones> entities = new  ArrayList<ProcesoGeneraVacaciones>();
		ProcesoGeneraVacaciones entity = new ProcesoGeneraVacaciones();		  
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
	
	public  List<ProcesoGeneraVacaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoGeneraVacaciones> entities = new  ArrayList<ProcesoGeneraVacaciones>();
		ProcesoGeneraVacaciones entity = new ProcesoGeneraVacaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoGeneraVacaciones();
				
				if(conMapGenerico) {
					entity.setMapProcesoGeneraVacaciones( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoGeneraVacaciones().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoGeneraVacacionesDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoGeneraVacacionesLogic.getEntityProcesoGeneraVacaciones("",entity,resultSet,listColumns);
					
					////entity.setProcesoGeneraVacacionesOriginal( new ProcesoGeneraVacaciones());
					////entity.setProcesoGeneraVacacionesOriginal(super.getEntity("",entity.getProcesoGeneraVacacionesOriginal(),resultSet,ProcesoGeneraVacacionesDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoGeneraVacacionesOriginal(ProcesoGeneraVacacionesDataAccess.getEntityProcesoGeneraVacaciones("",entity.getProcesoGeneraVacacionesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	
	
	
	public void deepLoad(ProcesoGeneraVacaciones procesogeneravacaciones,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			ProcesoGeneraVacacionesLogicAdditional.updateProcesoGeneraVacacionesToGet(procesogeneravacaciones,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			this.deepLoad(procesogeneravacaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoGeneraVacacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGeneraVacaciones(procesogeneravacaciones);
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
			this.deepLoad(this.procesogeneravacaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoGeneraVacacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGeneraVacaciones(this.procesogeneravacaciones);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesogeneravacacioness!=null) {
				for(ProcesoGeneraVacaciones procesogeneravacaciones:procesogeneravacacioness) {
					this.deepLoad(procesogeneravacaciones,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoGeneraVacacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGeneraVacaciones(procesogeneravacacioness);
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
			if(procesogeneravacacioness!=null) {
				for(ProcesoGeneraVacaciones procesogeneravacaciones:procesogeneravacacioness) {
					this.deepLoad(procesogeneravacaciones,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoGeneraVacacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGeneraVacaciones(procesogeneravacacioness);
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
	
	public ProcesoGeneraVacacionesParameterReturnGeneral procesarAccionProcesoGeneraVacacioness(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoGeneraVacaciones> procesogeneravacacioness,ProcesoGeneraVacacionesParameterReturnGeneral procesogeneravacacionesParameterGeneral)throws Exception {
		 try {	
			ProcesoGeneraVacacionesParameterReturnGeneral procesogeneravacacionesReturnGeneral=new ProcesoGeneraVacacionesParameterReturnGeneral();
	
			ProcesoGeneraVacacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesogeneravacacioness,procesogeneravacacionesParameterGeneral,procesogeneravacacionesReturnGeneral);
			
			return procesogeneravacacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoGeneraVacacionesParameterReturnGeneral procesarAccionProcesoGeneraVacacionessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoGeneraVacaciones> procesogeneravacacioness,ProcesoGeneraVacacionesParameterReturnGeneral procesogeneravacacionesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoGeneraVacacionesParameterReturnGeneral procesogeneravacacionesReturnGeneral=new ProcesoGeneraVacacionesParameterReturnGeneral();
	
			ProcesoGeneraVacacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesogeneravacacioness,procesogeneravacacionesParameterGeneral,procesogeneravacacionesReturnGeneral);
			
			this.connexion.commit();
			
			return procesogeneravacacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoGeneraVacaciones(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoGeneraVacaciones> procesogeneravacacioness,String sTipoBusqueda) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoGeneraVacacionesLogicAdditional procesogeneravacacionesLogicAdditional=new ProcesoGeneraVacacionesLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesogeneravacacionesLogicAdditional.setConnexion(this.connexion);

			procesogeneravacacionesLogicAdditional.ProcesarInformacionProcesoGeneraVacaciones(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesogeneravacacioness,sTipoBusqueda);

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

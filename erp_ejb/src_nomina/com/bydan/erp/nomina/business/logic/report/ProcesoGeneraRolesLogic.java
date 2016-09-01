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
import com.bydan.erp.nomina.util.report.ProcesoGeneraRolesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoGeneraRolesParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoGeneraRolesConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoGeneraRoles;

import com.bydan.erp.nomina.business.logic.report.ProcesoGeneraRolesLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoGeneraRolesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoGeneraRolesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoGeneraRolesLogic procesogenerarolesDataAccess; 		
	protected ProcesoGeneraRoles procesogeneraroles;
	protected List<ProcesoGeneraRoles> procesogeneraroless;
	protected Object procesogenerarolesObject;	
	protected List<Object> procesogenerarolessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoGeneraRolesLogic()throws SQLException,Exception {
		try	{
			this.procesogeneraroless= new ArrayList<ProcesoGeneraRoles>();
			this.procesogeneraroles= new ProcesoGeneraRoles();
			this.procesogenerarolesObject=new Object();
			this.procesogenerarolessObject=new ArrayList<Object>();
			
			this.procesogenerarolesDataAccess=this;
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
			this.procesogenerarolesDataAccess.setConnexionType(this.connexionType);
			this.procesogenerarolesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesogenerarolesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoGeneraRolesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesogeneraroless= new ArrayList<ProcesoGeneraRoles>();
			this.procesogeneraroles= new ProcesoGeneraRoles();
			this.procesogenerarolesObject=new Object();
			this.procesogenerarolessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesogenerarolesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesogenerarolesDataAccess.setConnexionType(this.connexionType);
			this.procesogenerarolesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesogenerarolesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoGeneraRoles getProcesoGeneraRoles() throws Exception {	
		ProcesoGeneraRolesLogicAdditional.checkProcesoGeneraRolesToGet(procesogeneraroles,this.datosCliente,this.arrDatoGeneral);
		ProcesoGeneraRolesLogicAdditional.updateProcesoGeneraRolesToGet(procesogeneraroles,this.arrDatoGeneral);
		
		return procesogeneraroles;
	}
		
	public void setProcesoGeneraRoles(ProcesoGeneraRoles newProcesoGeneraRoles) {
		this.procesogeneraroles = newProcesoGeneraRoles;
	}
	
	public List<ProcesoGeneraRoles> getProcesoGeneraRoless() throws Exception {		
		this.quitarProcesoGeneraRolessNulos();
		
		ProcesoGeneraRolesLogicAdditional.checkProcesoGeneraRolesToGets(procesogeneraroless,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoGeneraRoles procesogenerarolesLocal: procesogeneraroless ) {
			ProcesoGeneraRolesLogicAdditional.updateProcesoGeneraRolesToGet(procesogenerarolesLocal,this.arrDatoGeneral);
		}
		
		return procesogeneraroless;
	}
	
	public void setProcesoGeneraRoless(List<ProcesoGeneraRoles> newProcesoGeneraRoless) {
		this.procesogeneraroless = newProcesoGeneraRoless;
	}
	
	public Object getProcesoGeneraRolesObject() {	
		//this.procesogenerarolesObject=this.procesogenerarolesDataAccess.getEntityObject();
		return this.procesogenerarolesObject;
	}
		
	public void setProcesoGeneraRolesObject(Object newProcesoGeneraRolesObject) {
		this.procesogenerarolesObject = newProcesoGeneraRolesObject;
	}
	
	public List<Object> getProcesoGeneraRolessObject() {		
		//this.procesogenerarolessObject=this.procesogenerarolesDataAccess.getEntitiesObject();
		return this.procesogenerarolessObject;
	}
		
	public void setProcesoGeneraRolessObject(List<Object> newProcesoGeneraRolessObject) {
		this.procesogenerarolessObject = newProcesoGeneraRolessObject;
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
		procesogeneraroless = new  ArrayList<ProcesoGeneraRoles>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGeneraRolesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneraroless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesogeneraroless = new  ArrayList<ProcesoGeneraRoles>();
		  		  
        try {
			//ProcesoGeneraRolesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneraroless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesogeneraroless = new  ArrayList<ProcesoGeneraRoles>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGeneraRolesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneraroless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesogeneraroless = new  ArrayList<ProcesoGeneraRoles>();
		  		  
        try {
			//ProcesoGeneraRolesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneraroless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesogeneraroless = new  ArrayList<ProcesoGeneraRoles>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGeneraRolesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneraroless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesogeneraroless = new  ArrayList<ProcesoGeneraRoles>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoGeneraRolesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneraroless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoGeneraRoles> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGeneraRoles> entities = new  ArrayList<ProcesoGeneraRoles>();
		ProcesoGeneraRoles entity = new ProcesoGeneraRoles();		  
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
	
	public  List<ProcesoGeneraRoles> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGeneraRoles> entities = new  ArrayList<ProcesoGeneraRoles>();
		ProcesoGeneraRoles entity = new ProcesoGeneraRoles();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoGeneraRoles();
				
				
      	    	entity=ProcesoGeneraRolesLogic.getEntityProcesoGeneraRoles("",entity,resultSet);
      	    	
				//entity.setProcesoGeneraRolesOriginal( new ProcesoGeneraRoles());
      	    	//entity.setProcesoGeneraRolesOriginal(super.getEntity("",entity.getProcesoGeneraRolesOriginal(),resultSet,ProcesoGeneraRolesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoGeneraRolesOriginal(ProcesoGeneraRolesDataAccess.getEntityProcesoGeneraRoles("",entity.getProcesoGeneraRolesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoGeneraRoles> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGeneraRoles> entities = new  ArrayList<ProcesoGeneraRoles>();
		ProcesoGeneraRoles entity = new ProcesoGeneraRoles();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoGeneraRoles.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoGeneraRoles>((List<ProcesoGeneraRoles>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoGeneraRolessOriginal(entities);
			
			}  else {
				this.procesogenerarolessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoGeneraRolesConstantesFunciones.quitarEspaciosProcesoGeneraRoless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoGeneraRoles getEntityProcesoGeneraRoles(String strPrefijo,ProcesoGeneraRoles entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_mes(resultSet.getLong(strPrefijo+ProcesoGeneraRolesConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			entity.setid_estructura(resultSet.getLong(strPrefijo+ProcesoGeneraRolesConstantesFunciones.IDESTRUCTURA));
			entity.setid_empleado(resultSet.getLong(strPrefijo+ProcesoGeneraRolesConstantesFunciones.IDEMPLEADO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoGeneraRoles getEntityProcesoGeneraRoles(String strPrefijo,ProcesoGeneraRoles entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoGeneraRoles.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoGeneraRoles.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoGeneraRolesLogic.setFieldReflectionProcesoGeneraRoles(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoGeneraRoles(Field field,String strPrefijo,String sColumn,ProcesoGeneraRoles entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoGeneraRolesConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoGeneraRolesConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoGeneraRolesConstantesFunciones.IDEMPLEADO:
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
	
	public void quitarProcesoGeneraRolessNulos() throws Exception {				
		
		List<ProcesoGeneraRoles> procesogenerarolessAux= new ArrayList<ProcesoGeneraRoles>();
		
		for(ProcesoGeneraRoles procesogeneraroles:procesogeneraroless) {
			if(procesogeneraroles!=null) {
				procesogenerarolessAux.add(procesogeneraroles);
			}
		}
		
		procesogeneraroless=procesogenerarolessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoGeneraRoles> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGeneraRoles> entities = new  ArrayList<ProcesoGeneraRoles>();
		ProcesoGeneraRoles entity = new ProcesoGeneraRoles();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoGeneraRoles>((List<ProcesoGeneraRoles>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoGeneraRolessOriginal(entities);
			
			}  else {
				this.procesogenerarolessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoGeneraRolesConstantesFunciones.quitarEspaciosProcesoGeneraRoless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesogeneraroless = new  ArrayList<ProcesoGeneraRoles>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGeneraRolesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneraroless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesogeneraroless = new  ArrayList<ProcesoGeneraRoles>();
		  		  
        try {
			//ProcesoGeneraRolesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogeneraroless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoGeneraRoles> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoGeneraRoles> entities = new  ArrayList<ProcesoGeneraRoles>();
		ProcesoGeneraRoles entity = new ProcesoGeneraRoles();		  
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
	
	public  List<ProcesoGeneraRoles> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoGeneraRoles> entities = new  ArrayList<ProcesoGeneraRoles>();
		ProcesoGeneraRoles entity = new ProcesoGeneraRoles();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoGeneraRoles();
				
				if(conMapGenerico) {
					entity.setMapProcesoGeneraRoles( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoGeneraRoles().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoGeneraRolesDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoGeneraRolesLogic.getEntityProcesoGeneraRoles("",entity,resultSet,listColumns);
					
					////entity.setProcesoGeneraRolesOriginal( new ProcesoGeneraRoles());
					////entity.setProcesoGeneraRolesOriginal(super.getEntity("",entity.getProcesoGeneraRolesOriginal(),resultSet,ProcesoGeneraRolesDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoGeneraRolesOriginal(ProcesoGeneraRolesDataAccess.getEntityProcesoGeneraRoles("",entity.getProcesoGeneraRolesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Mes getMes(Connexion connexion,ProcesoGeneraRoles relprocesogeneraroles)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);
			mesDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			mes=mesDataAccess.getEntity(connexion,relprocesogeneraroles.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Estructura getEstructura(Connexion connexion,ProcesoGeneraRoles relprocesogeneraroles)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			estructura=estructuraDataAccess.getEntity(connexion,relprocesogeneraroles.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empleado getEmpleado(Connexion connexion,ProcesoGeneraRoles relprocesogeneraroles)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);
			empleadoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empleado=empleadoDataAccess.getEntity(connexion,relprocesogeneraroles.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


	
	
	public void getProcesoGeneraRolessBusquedaProcesoGeneraRolesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_mes,Long id_estructura,Long id_empleado)throws Exception {
		try {
			ProcesoGeneraRolesLogicAdditional procesogenerarolesLogicAdditional=new ProcesoGeneraRolesLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesogenerarolesLogicAdditional.BusquedaProcesoGeneraRoles(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_mes,id_estructura,id_empleado);

			//this.procesogeneraroless=this.getProcesoGeneraRoless();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoGeneraRolesLogicAdditional.ProcesarInformacionProcesoGeneraRoles(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesogenerarolesLogicAdditional,this.procesogeneraroless,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoGeneraRoles",id_mes,id_estructura,id_empleado);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoGeneraRolessBusquedaProcesoGeneraRoles(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_mes,Long id_estructura,Long id_empleado)throws Exception {
		try {
			ProcesoGeneraRolesLogicAdditional procesogenerarolesLogicAdditional=new ProcesoGeneraRolesLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesogenerarolesLogicAdditional.BusquedaProcesoGeneraRoles(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_mes,id_estructura,id_empleado);

			//this.procesogeneraroless=this.getProcesoGeneraRoless();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoGeneraRolesLogicAdditional.ProcesarInformacionProcesoGeneraRoles(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesogenerarolesLogicAdditional,this.procesogeneraroless,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoGeneraRoles",id_mes,id_estructura,id_empleado);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoGeneraRoles procesogeneraroles,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoGeneraRolesLogicAdditional.updateProcesoGeneraRolesToGet(procesogeneraroles,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesogeneraroles.setMes(procesogenerarolesDataAccess.getMes(connexion,procesogeneraroles));
		procesogeneraroles.setEstructura(procesogenerarolesDataAccess.getEstructura(connexion,procesogeneraroles));
		procesogeneraroles.setEmpleado(procesogenerarolesDataAccess.getEmpleado(connexion,procesogeneraroles));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				procesogeneraroles.setMes(procesogenerarolesDataAccess.getMes(connexion,procesogeneraroles));
			}

			if(clas.clas.equals(Estructura.class)) {
				procesogeneraroles.setEstructura(procesogenerarolesDataAccess.getEstructura(connexion,procesogeneraroles));
			}

			if(clas.clas.equals(Empleado.class)) {
				procesogeneraroles.setEmpleado(procesogenerarolesDataAccess.getEmpleado(connexion,procesogeneraroles));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogeneraroles.setMes(procesogenerarolesDataAccess.getMes(connexion,procesogeneraroles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogeneraroles.setEstructura(procesogenerarolesDataAccess.getEstructura(connexion,procesogeneraroles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogeneraroles.setEmpleado(procesogenerarolesDataAccess.getEmpleado(connexion,procesogeneraroles));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesogeneraroles.setMes(procesogenerarolesDataAccess.getMes(connexion,procesogeneraroles));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(procesogeneraroles.getMes(),isDeep,deepLoadType,clases);
				
		procesogeneraroles.setEstructura(procesogenerarolesDataAccess.getEstructura(connexion,procesogeneraroles));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(procesogeneraroles.getEstructura(),isDeep,deepLoadType,clases);
				
		procesogeneraroles.setEmpleado(procesogenerarolesDataAccess.getEmpleado(connexion,procesogeneraroles));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(procesogeneraroles.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				procesogeneraroles.setMes(procesogenerarolesDataAccess.getMes(connexion,procesogeneraroles));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(procesogeneraroles.getMes(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Estructura.class)) {
				procesogeneraroles.setEstructura(procesogenerarolesDataAccess.getEstructura(connexion,procesogeneraroles));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(procesogeneraroles.getEstructura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empleado.class)) {
				procesogeneraroles.setEmpleado(procesogenerarolesDataAccess.getEmpleado(connexion,procesogeneraroles));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(procesogeneraroles.getEmpleado(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogeneraroles.setMes(procesogenerarolesDataAccess.getMes(connexion,procesogeneraroles));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(procesogeneraroles.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogeneraroles.setEstructura(procesogenerarolesDataAccess.getEstructura(connexion,procesogeneraroles));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(procesogeneraroles.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogeneraroles.setEmpleado(procesogenerarolesDataAccess.getEmpleado(connexion,procesogeneraroles));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(procesogeneraroles.getEmpleado(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesogeneraroles,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoGeneraRolesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGeneraRoles(procesogeneraroles);
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
			this.deepLoad(this.procesogeneraroles,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoGeneraRolesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGeneraRoles(this.procesogeneraroles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesogeneraroless!=null) {
				for(ProcesoGeneraRoles procesogeneraroles:procesogeneraroless) {
					this.deepLoad(procesogeneraroles,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoGeneraRolesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGeneraRoles(procesogeneraroless);
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
			if(procesogeneraroless!=null) {
				for(ProcesoGeneraRoles procesogeneraroles:procesogeneraroless) {
					this.deepLoad(procesogeneraroles,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoGeneraRolesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGeneraRoles(procesogeneraroless);
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
	
	public ProcesoGeneraRolesParameterReturnGeneral procesarAccionProcesoGeneraRoless(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoGeneraRoles> procesogeneraroless,ProcesoGeneraRolesParameterReturnGeneral procesogenerarolesParameterGeneral)throws Exception {
		 try {	
			ProcesoGeneraRolesParameterReturnGeneral procesogenerarolesReturnGeneral=new ProcesoGeneraRolesParameterReturnGeneral();
	
			ProcesoGeneraRolesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesogeneraroless,procesogenerarolesParameterGeneral,procesogenerarolesReturnGeneral);
			
			return procesogenerarolesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoGeneraRolesParameterReturnGeneral procesarAccionProcesoGeneraRolessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoGeneraRoles> procesogeneraroless,ProcesoGeneraRolesParameterReturnGeneral procesogenerarolesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoGeneraRolesParameterReturnGeneral procesogenerarolesReturnGeneral=new ProcesoGeneraRolesParameterReturnGeneral();
	
			ProcesoGeneraRolesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesogeneraroless,procesogenerarolesParameterGeneral,procesogenerarolesReturnGeneral);
			
			this.connexion.commit();
			
			return procesogenerarolesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoGeneraRoles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoGeneraRoles> procesogeneraroless,String sTipoBusqueda,Long id_mesBusquedaProcesoGeneraRoles,Long id_estructuraBusquedaProcesoGeneraRoles,Long id_empleadoBusquedaProcesoGeneraRoles) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoGeneraRolesLogicAdditional procesogenerarolesLogicAdditional=new ProcesoGeneraRolesLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesogenerarolesLogicAdditional.setConnexion(this.connexion);

			procesogenerarolesLogicAdditional.ProcesarInformacionProcesoGeneraRoles(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesogeneraroless,sTipoBusqueda,id_mesBusquedaProcesoGeneraRoles,id_estructuraBusquedaProcesoGeneraRoles,id_empleadoBusquedaProcesoGeneraRoles);

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

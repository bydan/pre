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
package com.bydan.erp.activosfijos.business.logic.report;

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

import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.resources.general.AuxiliarGeneral;
import com.bydan.erp.activosfijos.util.report.ProcesarMayorizarParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ProcesarMayorizarParameterGeneral;
import com.bydan.erp.activosfijos.util.report.ProcesarMayorizarConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.ProcesarMayorizar;

import com.bydan.erp.activosfijos.business.logic.report.ProcesarMayorizarLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesarMayorizarLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesarMayorizarLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesarMayorizarLogic procesarmayorizarDataAccess; 		
	protected ProcesarMayorizar procesarmayorizar;
	protected List<ProcesarMayorizar> procesarmayorizars;
	protected Object procesarmayorizarObject;	
	protected List<Object> procesarmayorizarsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesarMayorizarLogic()throws SQLException,Exception {
		try	{
			this.procesarmayorizars= new ArrayList<ProcesarMayorizar>();
			this.procesarmayorizar= new ProcesarMayorizar();
			this.procesarmayorizarObject=new Object();
			this.procesarmayorizarsObject=new ArrayList<Object>();
			
			this.procesarmayorizarDataAccess=this;
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
			this.procesarmayorizarDataAccess.setConnexionType(this.connexionType);
			this.procesarmayorizarDataAccess.setParameterDbType(this.parameterDbType);
			this.procesarmayorizarDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesarMayorizarLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesarmayorizars= new ArrayList<ProcesarMayorizar>();
			this.procesarmayorizar= new ProcesarMayorizar();
			this.procesarmayorizarObject=new Object();
			this.procesarmayorizarsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesarmayorizarDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesarmayorizarDataAccess.setConnexionType(this.connexionType);
			this.procesarmayorizarDataAccess.setParameterDbType(this.parameterDbType);
			this.procesarmayorizarDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesarMayorizar getProcesarMayorizar() throws Exception {	
		ProcesarMayorizarLogicAdditional.checkProcesarMayorizarToGet(procesarmayorizar,this.datosCliente,this.arrDatoGeneral);
		ProcesarMayorizarLogicAdditional.updateProcesarMayorizarToGet(procesarmayorizar,this.arrDatoGeneral);
		
		return procesarmayorizar;
	}
		
	public void setProcesarMayorizar(ProcesarMayorizar newProcesarMayorizar) {
		this.procesarmayorizar = newProcesarMayorizar;
	}
	
	public List<ProcesarMayorizar> getProcesarMayorizars() throws Exception {		
		this.quitarProcesarMayorizarsNulos();
		
		ProcesarMayorizarLogicAdditional.checkProcesarMayorizarToGets(procesarmayorizars,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesarMayorizar procesarmayorizarLocal: procesarmayorizars ) {
			ProcesarMayorizarLogicAdditional.updateProcesarMayorizarToGet(procesarmayorizarLocal,this.arrDatoGeneral);
		}
		
		return procesarmayorizars;
	}
	
	public void setProcesarMayorizars(List<ProcesarMayorizar> newProcesarMayorizars) {
		this.procesarmayorizars = newProcesarMayorizars;
	}
	
	public Object getProcesarMayorizarObject() {	
		//this.procesarmayorizarObject=this.procesarmayorizarDataAccess.getEntityObject();
		return this.procesarmayorizarObject;
	}
		
	public void setProcesarMayorizarObject(Object newProcesarMayorizarObject) {
		this.procesarmayorizarObject = newProcesarMayorizarObject;
	}
	
	public List<Object> getProcesarMayorizarsObject() {		
		//this.procesarmayorizarsObject=this.procesarmayorizarDataAccess.getEntitiesObject();
		return this.procesarmayorizarsObject;
	}
		
	public void setProcesarMayorizarsObject(List<Object> newProcesarMayorizarsObject) {
		this.procesarmayorizarsObject = newProcesarMayorizarsObject;
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
		procesarmayorizars = new  ArrayList<ProcesarMayorizar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarMayorizarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarmayorizars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesarmayorizars = new  ArrayList<ProcesarMayorizar>();
		  		  
        try {
			//ProcesarMayorizarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarmayorizars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesarmayorizars = new  ArrayList<ProcesarMayorizar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarMayorizarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarmayorizars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesarmayorizars = new  ArrayList<ProcesarMayorizar>();
		  		  
        try {
			//ProcesarMayorizarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarmayorizars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesarmayorizars = new  ArrayList<ProcesarMayorizar>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarMayorizarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarmayorizars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesarmayorizars = new  ArrayList<ProcesarMayorizar>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesarMayorizarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarmayorizars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesarMayorizar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarMayorizar> entities = new  ArrayList<ProcesarMayorizar>();
		ProcesarMayorizar entity = new ProcesarMayorizar();		  
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
	
	public  List<ProcesarMayorizar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarMayorizar> entities = new  ArrayList<ProcesarMayorizar>();
		ProcesarMayorizar entity = new ProcesarMayorizar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesarMayorizar();
				
      	    	entity=this.getEntity("",entity,resultSet,ProcesarMayorizarLogic.ISWITHSCHEMA);         		
				
      	    	entity=ProcesarMayorizarLogic.getEntityProcesarMayorizar("",entity,resultSet);
      	    	
				//entity.setProcesarMayorizarOriginal( new ProcesarMayorizar());
      	    	//entity.setProcesarMayorizarOriginal(super.getEntity("",entity.getProcesarMayorizarOriginal(),resultSet,ProcesarMayorizarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesarMayorizarOriginal(ProcesarMayorizarDataAccess.getEntityProcesarMayorizar("",entity.getProcesarMayorizarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesarMayorizar> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarMayorizar> entities = new  ArrayList<ProcesarMayorizar>();
		ProcesarMayorizar entity = new ProcesarMayorizar();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesarMayorizar.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesarMayorizar>((List<ProcesarMayorizar>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesarMayorizarsOriginal(entities);
			
			}  else {
				this.procesarmayorizarsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesarMayorizarConstantesFunciones.quitarEspaciosProcesarMayorizars(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  ProcesarMayorizar getEntity(String strPrefijo,ProcesarMayorizar entityT,ResultSet rs,Boolean isWithSchema) throws Exception {	 
		  entityT.setIsNew(false);
        
		  try {
    	  
      	  if(isWithSchema) {
    	    	entityT.setId(rs.getLong(strPrefijo+DataAccessHelper.getColumnNameId()));	
    	    	//extracted(entityT).setIsActive(rs.getBoolean(strPrefijo+DataAccessHelper.getColumnNameIsActive()));
    	    	//extracted(entityT).setIsExpired(rs.getBoolean(strPrefijo+DataAccessHelper.getColumnNameIsExpired()));
    	    	entityT.setVersionRow(rs.getTimestamp(strPrefijo+DataAccessHelper.getColumnNameVersionRow()));     	    	       	 
      	  }
	      	} catch(Exception ex) {
	            throw new Exception();
	        }
	      	
        return entityT;
  	}
	
	public  static ProcesarMayorizar getEntityProcesarMayorizar(String strPrefijo,ProcesarMayorizar entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ProcesarMayorizarConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+ProcesarMayorizarConstantesFunciones.NOMBRE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesarMayorizar getEntityProcesarMayorizar(String strPrefijo,ProcesarMayorizar entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesarMayorizar.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesarMayorizar.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesarMayorizarLogic.setFieldReflectionProcesarMayorizar(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesarMayorizar(Field field,String strPrefijo,String sColumn,ProcesarMayorizar entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesarMayorizarConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesarMayorizarConstantesFunciones.NOMBRE:
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
	
	public void quitarProcesarMayorizarsNulos() throws Exception {				
		
		List<ProcesarMayorizar> procesarmayorizarsAux= new ArrayList<ProcesarMayorizar>();
		
		for(ProcesarMayorizar procesarmayorizar:procesarmayorizars) {
			if(procesarmayorizar!=null) {
				procesarmayorizarsAux.add(procesarmayorizar);
			}
		}
		
		procesarmayorizars=procesarmayorizarsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesarMayorizar> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarMayorizar> entities = new  ArrayList<ProcesarMayorizar>();
		ProcesarMayorizar entity = new ProcesarMayorizar();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesarMayorizar>((List<ProcesarMayorizar>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesarMayorizarsOriginal(entities);
			
			}  else {
				this.procesarmayorizarsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesarMayorizarConstantesFunciones.quitarEspaciosProcesarMayorizars(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesarmayorizars = new  ArrayList<ProcesarMayorizar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarMayorizarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarmayorizars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesarmayorizars = new  ArrayList<ProcesarMayorizar>();
		  		  
        try {
			//ProcesarMayorizarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarmayorizars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesarMayorizar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesarMayorizar> entities = new  ArrayList<ProcesarMayorizar>();
		ProcesarMayorizar entity = new ProcesarMayorizar();		  
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
	
	public  List<ProcesarMayorizar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesarMayorizar> entities = new  ArrayList<ProcesarMayorizar>();
		ProcesarMayorizar entity = new ProcesarMayorizar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesarMayorizar();
				
				if(conMapGenerico) {
					entity.setMapProcesarMayorizar( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesarMayorizar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesarMayorizarDataAccess.ISWITHSCHEMA);         		
					entity=ProcesarMayorizarLogic.getEntityProcesarMayorizar("",entity,resultSet,listColumns);
					
					////entity.setProcesarMayorizarOriginal( new ProcesarMayorizar());
					////entity.setProcesarMayorizarOriginal(super.getEntity("",entity.getProcesarMayorizarOriginal(),resultSet,ProcesarMayorizarDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesarMayorizarOriginal(ProcesarMayorizarDataAccess.getEntityProcesarMayorizar("",entity.getProcesarMayorizarOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Anio getAnio(Connexion connexion,ProcesarMayorizar relprocesarmayorizar)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,relprocesarmayorizar.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,ProcesarMayorizar relprocesarmayorizar)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);
			mesDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			mes=mesDataAccess.getEntity(connexion,relprocesarmayorizar.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,ProcesarMayorizar relprocesarmayorizar)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);
			tipodocumentoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relprocesarmayorizar.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}


	
	
	public void getProcesarMayorizarsBusquedaProcesarMayorizarWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_tipo_documento)throws Exception {
		try {
			ProcesarMayorizarLogicAdditional procesarmayorizarLogicAdditional=new ProcesarMayorizarLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesarmayorizarLogicAdditional.BusquedaProcesarMayorizar(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_mes,id_tipo_documento);

			//this.procesarmayorizars=this.getProcesarMayorizars();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesarMayorizarLogicAdditional.ProcesarInformacionProcesarMayorizar(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarmayorizarLogicAdditional,this.procesarmayorizars,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesarMayorizar",id_anio,id_mes,id_tipo_documento);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesarMayorizarsBusquedaProcesarMayorizar(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_tipo_documento)throws Exception {
		try {
			ProcesarMayorizarLogicAdditional procesarmayorizarLogicAdditional=new ProcesarMayorizarLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesarmayorizarLogicAdditional.BusquedaProcesarMayorizar(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_mes,id_tipo_documento);

			//this.procesarmayorizars=this.getProcesarMayorizars();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesarMayorizarLogicAdditional.ProcesarInformacionProcesarMayorizar(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarmayorizarLogicAdditional,this.procesarmayorizars,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesarMayorizar",id_anio,id_mes,id_tipo_documento);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesarMayorizar procesarmayorizar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesarMayorizarLogicAdditional.updateProcesarMayorizarToGet(procesarmayorizar,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesarmayorizar.setAnio(procesarmayorizarDataAccess.getAnio(connexion,procesarmayorizar));
		procesarmayorizar.setMes(procesarmayorizarDataAccess.getMes(connexion,procesarmayorizar));
		procesarmayorizar.setTipoDocumento(procesarmayorizarDataAccess.getTipoDocumento(connexion,procesarmayorizar));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesarmayorizar.setAnio(procesarmayorizarDataAccess.getAnio(connexion,procesarmayorizar));
			}

			if(clas.clas.equals(Mes.class)) {
				procesarmayorizar.setMes(procesarmayorizarDataAccess.getMes(connexion,procesarmayorizar));
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				procesarmayorizar.setTipoDocumento(procesarmayorizarDataAccess.getTipoDocumento(connexion,procesarmayorizar));
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
			procesarmayorizar.setAnio(procesarmayorizarDataAccess.getAnio(connexion,procesarmayorizar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarmayorizar.setMes(procesarmayorizarDataAccess.getMes(connexion,procesarmayorizar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarmayorizar.setTipoDocumento(procesarmayorizarDataAccess.getTipoDocumento(connexion,procesarmayorizar));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesarmayorizar.setAnio(procesarmayorizarDataAccess.getAnio(connexion,procesarmayorizar));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(procesarmayorizar.getAnio(),isDeep,deepLoadType,clases);
				
		procesarmayorizar.setMes(procesarmayorizarDataAccess.getMes(connexion,procesarmayorizar));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(procesarmayorizar.getMes(),isDeep,deepLoadType,clases);
				
		procesarmayorizar.setTipoDocumento(procesarmayorizarDataAccess.getTipoDocumento(connexion,procesarmayorizar));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(procesarmayorizar.getTipoDocumento(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesarmayorizar.setAnio(procesarmayorizarDataAccess.getAnio(connexion,procesarmayorizar));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(procesarmayorizar.getAnio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Mes.class)) {
				procesarmayorizar.setMes(procesarmayorizarDataAccess.getMes(connexion,procesarmayorizar));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(procesarmayorizar.getMes(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				procesarmayorizar.setTipoDocumento(procesarmayorizarDataAccess.getTipoDocumento(connexion,procesarmayorizar));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(procesarmayorizar.getTipoDocumento(),isDeep,deepLoadType,clases);				
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
			procesarmayorizar.setAnio(procesarmayorizarDataAccess.getAnio(connexion,procesarmayorizar));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(procesarmayorizar.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarmayorizar.setMes(procesarmayorizarDataAccess.getMes(connexion,procesarmayorizar));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(procesarmayorizar.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarmayorizar.setTipoDocumento(procesarmayorizarDataAccess.getTipoDocumento(connexion,procesarmayorizar));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(procesarmayorizar.getTipoDocumento(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesarmayorizar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesarMayorizarConstantesFunciones.refrescarForeignKeysDescripcionesProcesarMayorizar(procesarmayorizar);
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
			this.deepLoad(this.procesarmayorizar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesarMayorizarConstantesFunciones.refrescarForeignKeysDescripcionesProcesarMayorizar(this.procesarmayorizar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesarmayorizars!=null) {
				for(ProcesarMayorizar procesarmayorizar:procesarmayorizars) {
					this.deepLoad(procesarmayorizar,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesarMayorizarConstantesFunciones.refrescarForeignKeysDescripcionesProcesarMayorizar(procesarmayorizars);
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
			if(procesarmayorizars!=null) {
				for(ProcesarMayorizar procesarmayorizar:procesarmayorizars) {
					this.deepLoad(procesarmayorizar,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesarMayorizarConstantesFunciones.refrescarForeignKeysDescripcionesProcesarMayorizar(procesarmayorizars);
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
	
	public ProcesarMayorizarParameterReturnGeneral procesarAccionProcesarMayorizars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesarMayorizar> procesarmayorizars,ProcesarMayorizarParameterReturnGeneral procesarmayorizarParameterGeneral)throws Exception {
		 try {	
			ProcesarMayorizarParameterReturnGeneral procesarmayorizarReturnGeneral=new ProcesarMayorizarParameterReturnGeneral();
	
			ProcesarMayorizarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesarmayorizars,procesarmayorizarParameterGeneral,procesarmayorizarReturnGeneral);
			
			return procesarmayorizarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesarMayorizarParameterReturnGeneral procesarAccionProcesarMayorizarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesarMayorizar> procesarmayorizars,ProcesarMayorizarParameterReturnGeneral procesarmayorizarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesarMayorizarParameterReturnGeneral procesarmayorizarReturnGeneral=new ProcesarMayorizarParameterReturnGeneral();
	
			ProcesarMayorizarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesarmayorizars,procesarmayorizarParameterGeneral,procesarmayorizarReturnGeneral);
			
			this.connexion.commit();
			
			return procesarmayorizarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesarMayorizar> procesarmayorizars,String sTipoBusqueda,Long id_anioBusquedaProcesarMayorizar,Long id_mesBusquedaProcesarMayorizar,Long id_tipo_documentoBusquedaProcesarMayorizar) throws Exception {
		Boolean procesado=false;

		try {
			ProcesarMayorizarLogicAdditional procesarmayorizarLogicAdditional=new ProcesarMayorizarLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesarmayorizarLogicAdditional.setConnexion(this.connexion);

			procesarmayorizarLogicAdditional.ProcesarInformacionProcesarMayorizar(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarmayorizars,sTipoBusqueda,id_anioBusquedaProcesarMayorizar,id_mesBusquedaProcesarMayorizar,id_tipo_documentoBusquedaProcesarMayorizar);

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

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
import com.bydan.erp.activosfijos.util.report.ProcesarCrearIndicesParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ProcesarCrearIndicesParameterGeneral;
import com.bydan.erp.activosfijos.util.report.ProcesarCrearIndicesConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.ProcesarCrearIndices;

import com.bydan.erp.activosfijos.business.logic.report.ProcesarCrearIndicesLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;














@SuppressWarnings("unused")
public class ProcesarCrearIndicesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesarCrearIndicesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesarCrearIndicesLogic procesarcrearindicesDataAccess; 		
	protected ProcesarCrearIndices procesarcrearindices;
	protected List<ProcesarCrearIndices> procesarcrearindicess;
	protected Object procesarcrearindicesObject;	
	protected List<Object> procesarcrearindicessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesarCrearIndicesLogic()throws SQLException,Exception {
		try	{
			this.procesarcrearindicess= new ArrayList<ProcesarCrearIndices>();
			this.procesarcrearindices= new ProcesarCrearIndices();
			this.procesarcrearindicesObject=new Object();
			this.procesarcrearindicessObject=new ArrayList<Object>();
			
			this.procesarcrearindicesDataAccess=this;
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
			this.procesarcrearindicesDataAccess.setConnexionType(this.connexionType);
			this.procesarcrearindicesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesarcrearindicesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesarCrearIndicesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesarcrearindicess= new ArrayList<ProcesarCrearIndices>();
			this.procesarcrearindices= new ProcesarCrearIndices();
			this.procesarcrearindicesObject=new Object();
			this.procesarcrearindicessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesarcrearindicesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesarcrearindicesDataAccess.setConnexionType(this.connexionType);
			this.procesarcrearindicesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesarcrearindicesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesarCrearIndices getProcesarCrearIndices() throws Exception {	
		ProcesarCrearIndicesLogicAdditional.checkProcesarCrearIndicesToGet(procesarcrearindices,this.datosCliente,this.arrDatoGeneral);
		ProcesarCrearIndicesLogicAdditional.updateProcesarCrearIndicesToGet(procesarcrearindices,this.arrDatoGeneral);
		
		return procesarcrearindices;
	}
		
	public void setProcesarCrearIndices(ProcesarCrearIndices newProcesarCrearIndices) {
		this.procesarcrearindices = newProcesarCrearIndices;
	}
	
	public List<ProcesarCrearIndices> getProcesarCrearIndicess() throws Exception {		
		this.quitarProcesarCrearIndicessNulos();
		
		ProcesarCrearIndicesLogicAdditional.checkProcesarCrearIndicesToGets(procesarcrearindicess,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesarCrearIndices procesarcrearindicesLocal: procesarcrearindicess ) {
			ProcesarCrearIndicesLogicAdditional.updateProcesarCrearIndicesToGet(procesarcrearindicesLocal,this.arrDatoGeneral);
		}
		
		return procesarcrearindicess;
	}
	
	public void setProcesarCrearIndicess(List<ProcesarCrearIndices> newProcesarCrearIndicess) {
		this.procesarcrearindicess = newProcesarCrearIndicess;
	}
	
	public Object getProcesarCrearIndicesObject() {	
		//this.procesarcrearindicesObject=this.procesarcrearindicesDataAccess.getEntityObject();
		return this.procesarcrearindicesObject;
	}
		
	public void setProcesarCrearIndicesObject(Object newProcesarCrearIndicesObject) {
		this.procesarcrearindicesObject = newProcesarCrearIndicesObject;
	}
	
	public List<Object> getProcesarCrearIndicessObject() {		
		//this.procesarcrearindicessObject=this.procesarcrearindicesDataAccess.getEntitiesObject();
		return this.procesarcrearindicessObject;
	}
		
	public void setProcesarCrearIndicessObject(List<Object> newProcesarCrearIndicessObject) {
		this.procesarcrearindicessObject = newProcesarCrearIndicessObject;
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
		procesarcrearindicess = new  ArrayList<ProcesarCrearIndices>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarCrearIndicesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcrearindicess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesarcrearindicess = new  ArrayList<ProcesarCrearIndices>();
		  		  
        try {
			//ProcesarCrearIndicesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcrearindicess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesarcrearindicess = new  ArrayList<ProcesarCrearIndices>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarCrearIndicesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcrearindicess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesarcrearindicess = new  ArrayList<ProcesarCrearIndices>();
		  		  
        try {
			//ProcesarCrearIndicesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcrearindicess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesarcrearindicess = new  ArrayList<ProcesarCrearIndices>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarCrearIndicesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcrearindicess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesarcrearindicess = new  ArrayList<ProcesarCrearIndices>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesarCrearIndicesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcrearindicess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesarCrearIndices> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarCrearIndices> entities = new  ArrayList<ProcesarCrearIndices>();
		ProcesarCrearIndices entity = new ProcesarCrearIndices();		  
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
	
	public  List<ProcesarCrearIndices> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarCrearIndices> entities = new  ArrayList<ProcesarCrearIndices>();
		ProcesarCrearIndices entity = new ProcesarCrearIndices();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesarCrearIndices();
				
				
      	    	entity=ProcesarCrearIndicesLogic.getEntityProcesarCrearIndices("",entity,resultSet);
      	    	
				//entity.setProcesarCrearIndicesOriginal( new ProcesarCrearIndices());
      	    	//entity.setProcesarCrearIndicesOriginal(super.getEntity("",entity.getProcesarCrearIndicesOriginal(),resultSet,ProcesarCrearIndicesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesarCrearIndicesOriginal(ProcesarCrearIndicesDataAccess.getEntityProcesarCrearIndices("",entity.getProcesarCrearIndicesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesarCrearIndices> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarCrearIndices> entities = new  ArrayList<ProcesarCrearIndices>();
		ProcesarCrearIndices entity = new ProcesarCrearIndices();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesarCrearIndices.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesarCrearIndices>((List<ProcesarCrearIndices>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesarCrearIndicessOriginal(entities);
			
			}  else {
				this.procesarcrearindicessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesarCrearIndicesConstantesFunciones.quitarEspaciosProcesarCrearIndicess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesarCrearIndices getEntityProcesarCrearIndices(String strPrefijo,ProcesarCrearIndices entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesarCrearIndices getEntityProcesarCrearIndices(String strPrefijo,ProcesarCrearIndices entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesarCrearIndices.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesarCrearIndices.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesarCrearIndicesLogic.setFieldReflectionProcesarCrearIndices(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesarCrearIndices(Field field,String strPrefijo,String sColumn,ProcesarCrearIndices entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
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
	
	public void quitarProcesarCrearIndicessNulos() throws Exception {				
		
		List<ProcesarCrearIndices> procesarcrearindicessAux= new ArrayList<ProcesarCrearIndices>();
		
		for(ProcesarCrearIndices procesarcrearindices:procesarcrearindicess) {
			if(procesarcrearindices!=null) {
				procesarcrearindicessAux.add(procesarcrearindices);
			}
		}
		
		procesarcrearindicess=procesarcrearindicessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesarCrearIndices> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarCrearIndices> entities = new  ArrayList<ProcesarCrearIndices>();
		ProcesarCrearIndices entity = new ProcesarCrearIndices();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesarCrearIndices>((List<ProcesarCrearIndices>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesarCrearIndicessOriginal(entities);
			
			}  else {
				this.procesarcrearindicessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesarCrearIndicesConstantesFunciones.quitarEspaciosProcesarCrearIndicess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesarcrearindicess = new  ArrayList<ProcesarCrearIndices>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarCrearIndicesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcrearindicess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesarcrearindicess = new  ArrayList<ProcesarCrearIndices>();
		  		  
        try {
			//ProcesarCrearIndicesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcrearindicess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesarCrearIndices> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesarCrearIndices> entities = new  ArrayList<ProcesarCrearIndices>();
		ProcesarCrearIndices entity = new ProcesarCrearIndices();		  
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
	
	public  List<ProcesarCrearIndices> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesarCrearIndices> entities = new  ArrayList<ProcesarCrearIndices>();
		ProcesarCrearIndices entity = new ProcesarCrearIndices();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesarCrearIndices();
				
				if(conMapGenerico) {
					entity.setMapProcesarCrearIndices( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesarCrearIndices().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesarCrearIndicesDataAccess.ISWITHSCHEMA);         		
					entity=ProcesarCrearIndicesLogic.getEntityProcesarCrearIndices("",entity,resultSet,listColumns);
					
					////entity.setProcesarCrearIndicesOriginal( new ProcesarCrearIndices());
					////entity.setProcesarCrearIndicesOriginal(super.getEntity("",entity.getProcesarCrearIndicesOriginal(),resultSet,ProcesarCrearIndicesDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesarCrearIndicesOriginal(ProcesarCrearIndicesDataAccess.getEntityProcesarCrearIndices("",entity.getProcesarCrearIndicesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	public void getProcesarCrearIndicessBusquedaProcesarCrearIndicesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			ProcesarCrearIndicesLogicAdditional procesarcrearindicesLogicAdditional=new ProcesarCrearIndicesLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesarcrearindicesLogicAdditional.BusquedaProcesarCrearIndices(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			//this.procesarcrearindicess=this.getProcesarCrearIndicess();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesarCrearIndicesLogicAdditional.ProcesarInformacionProcesarCrearIndices(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarcrearindicesLogicAdditional,this.procesarcrearindicess,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesarCrearIndices",id);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesarCrearIndicessBusquedaProcesarCrearIndices(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			ProcesarCrearIndicesLogicAdditional procesarcrearindicesLogicAdditional=new ProcesarCrearIndicesLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesarcrearindicesLogicAdditional.BusquedaProcesarCrearIndices(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			//this.procesarcrearindicess=this.getProcesarCrearIndicess();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesarCrearIndicesLogicAdditional.ProcesarInformacionProcesarCrearIndices(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarcrearindicesLogicAdditional,this.procesarcrearindicess,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesarCrearIndices",id);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesarCrearIndices procesarcrearindices,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			ProcesarCrearIndicesLogicAdditional.updateProcesarCrearIndicesToGet(procesarcrearindices,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			this.deepLoad(procesarcrearindices,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesarCrearIndicesConstantesFunciones.refrescarForeignKeysDescripcionesProcesarCrearIndices(procesarcrearindices);
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
			this.deepLoad(this.procesarcrearindices,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesarCrearIndicesConstantesFunciones.refrescarForeignKeysDescripcionesProcesarCrearIndices(this.procesarcrearindices);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesarcrearindicess!=null) {
				for(ProcesarCrearIndices procesarcrearindices:procesarcrearindicess) {
					this.deepLoad(procesarcrearindices,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesarCrearIndicesConstantesFunciones.refrescarForeignKeysDescripcionesProcesarCrearIndices(procesarcrearindicess);
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
			if(procesarcrearindicess!=null) {
				for(ProcesarCrearIndices procesarcrearindices:procesarcrearindicess) {
					this.deepLoad(procesarcrearindices,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesarCrearIndicesConstantesFunciones.refrescarForeignKeysDescripcionesProcesarCrearIndices(procesarcrearindicess);
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
	
	public ProcesarCrearIndicesParameterReturnGeneral procesarAccionProcesarCrearIndicess(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesarCrearIndices> procesarcrearindicess,ProcesarCrearIndicesParameterReturnGeneral procesarcrearindicesParameterGeneral)throws Exception {
		 try {	
			ProcesarCrearIndicesParameterReturnGeneral procesarcrearindicesReturnGeneral=new ProcesarCrearIndicesParameterReturnGeneral();
	
			ProcesarCrearIndicesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesarcrearindicess,procesarcrearindicesParameterGeneral,procesarcrearindicesReturnGeneral);
			
			return procesarcrearindicesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesarCrearIndicesParameterReturnGeneral procesarAccionProcesarCrearIndicessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesarCrearIndices> procesarcrearindicess,ProcesarCrearIndicesParameterReturnGeneral procesarcrearindicesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesarCrearIndicesParameterReturnGeneral procesarcrearindicesReturnGeneral=new ProcesarCrearIndicesParameterReturnGeneral();
	
			ProcesarCrearIndicesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesarcrearindicess,procesarcrearindicesParameterGeneral,procesarcrearindicesReturnGeneral);
			
			this.connexion.commit();
			
			return procesarcrearindicesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesarCrearIndices(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesarCrearIndices> procesarcrearindicess,String sTipoBusqueda,Long idBusquedaProcesarCrearIndices) throws Exception {
		Boolean procesado=false;

		try {
			ProcesarCrearIndicesLogicAdditional procesarcrearindicesLogicAdditional=new ProcesarCrearIndicesLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesarcrearindicesLogicAdditional.setConnexion(this.connexion);

			procesarcrearindicesLogicAdditional.ProcesarInformacionProcesarCrearIndices(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarcrearindicess,sTipoBusqueda,idBusquedaProcesarCrearIndices);

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

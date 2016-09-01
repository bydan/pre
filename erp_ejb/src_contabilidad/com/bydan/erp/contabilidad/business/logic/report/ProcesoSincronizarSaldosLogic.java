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
import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosParameterGeneral;
import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.ProcesoSincronizarSaldos;

import com.bydan.erp.contabilidad.business.logic.report.ProcesoSincronizarSaldosLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoSincronizarSaldosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoSincronizarSaldosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoSincronizarSaldosLogic procesosincronizarsaldosDataAccess; 		
	protected ProcesoSincronizarSaldos procesosincronizarsaldos;
	protected List<ProcesoSincronizarSaldos> procesosincronizarsaldoss;
	protected Object procesosincronizarsaldosObject;	
	protected List<Object> procesosincronizarsaldossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoSincronizarSaldosLogic()throws SQLException,Exception {
		try	{
			this.procesosincronizarsaldoss= new ArrayList<ProcesoSincronizarSaldos>();
			this.procesosincronizarsaldos= new ProcesoSincronizarSaldos();
			this.procesosincronizarsaldosObject=new Object();
			this.procesosincronizarsaldossObject=new ArrayList<Object>();
			
			this.procesosincronizarsaldosDataAccess=this;
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
			this.procesosincronizarsaldosDataAccess.setConnexionType(this.connexionType);
			this.procesosincronizarsaldosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesosincronizarsaldosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoSincronizarSaldosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesosincronizarsaldoss= new ArrayList<ProcesoSincronizarSaldos>();
			this.procesosincronizarsaldos= new ProcesoSincronizarSaldos();
			this.procesosincronizarsaldosObject=new Object();
			this.procesosincronizarsaldossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesosincronizarsaldosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesosincronizarsaldosDataAccess.setConnexionType(this.connexionType);
			this.procesosincronizarsaldosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesosincronizarsaldosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoSincronizarSaldos getProcesoSincronizarSaldos() throws Exception {	
		ProcesoSincronizarSaldosLogicAdditional.checkProcesoSincronizarSaldosToGet(procesosincronizarsaldos,this.datosCliente,this.arrDatoGeneral);
		ProcesoSincronizarSaldosLogicAdditional.updateProcesoSincronizarSaldosToGet(procesosincronizarsaldos,this.arrDatoGeneral);
		
		return procesosincronizarsaldos;
	}
		
	public void setProcesoSincronizarSaldos(ProcesoSincronizarSaldos newProcesoSincronizarSaldos) {
		this.procesosincronizarsaldos = newProcesoSincronizarSaldos;
	}
	
	public List<ProcesoSincronizarSaldos> getProcesoSincronizarSaldoss() throws Exception {		
		this.quitarProcesoSincronizarSaldossNulos();
		
		ProcesoSincronizarSaldosLogicAdditional.checkProcesoSincronizarSaldosToGets(procesosincronizarsaldoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoSincronizarSaldos procesosincronizarsaldosLocal: procesosincronizarsaldoss ) {
			ProcesoSincronizarSaldosLogicAdditional.updateProcesoSincronizarSaldosToGet(procesosincronizarsaldosLocal,this.arrDatoGeneral);
		}
		
		return procesosincronizarsaldoss;
	}
	
	public void setProcesoSincronizarSaldoss(List<ProcesoSincronizarSaldos> newProcesoSincronizarSaldoss) {
		this.procesosincronizarsaldoss = newProcesoSincronizarSaldoss;
	}
	
	public Object getProcesoSincronizarSaldosObject() {	
		//this.procesosincronizarsaldosObject=this.procesosincronizarsaldosDataAccess.getEntityObject();
		return this.procesosincronizarsaldosObject;
	}
		
	public void setProcesoSincronizarSaldosObject(Object newProcesoSincronizarSaldosObject) {
		this.procesosincronizarsaldosObject = newProcesoSincronizarSaldosObject;
	}
	
	public List<Object> getProcesoSincronizarSaldossObject() {		
		//this.procesosincronizarsaldossObject=this.procesosincronizarsaldosDataAccess.getEntitiesObject();
		return this.procesosincronizarsaldossObject;
	}
		
	public void setProcesoSincronizarSaldossObject(List<Object> newProcesoSincronizarSaldossObject) {
		this.procesosincronizarsaldossObject = newProcesoSincronizarSaldossObject;
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
		procesosincronizarsaldoss = new  ArrayList<ProcesoSincronizarSaldos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoSincronizarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosincronizarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesosincronizarsaldoss = new  ArrayList<ProcesoSincronizarSaldos>();
		  		  
        try {
			//ProcesoSincronizarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosincronizarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesosincronizarsaldoss = new  ArrayList<ProcesoSincronizarSaldos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoSincronizarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosincronizarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesosincronizarsaldoss = new  ArrayList<ProcesoSincronizarSaldos>();
		  		  
        try {
			//ProcesoSincronizarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosincronizarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesosincronizarsaldoss = new  ArrayList<ProcesoSincronizarSaldos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoSincronizarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosincronizarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesosincronizarsaldoss = new  ArrayList<ProcesoSincronizarSaldos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoSincronizarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosincronizarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoSincronizarSaldos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoSincronizarSaldos> entities = new  ArrayList<ProcesoSincronizarSaldos>();
		ProcesoSincronizarSaldos entity = new ProcesoSincronizarSaldos();		  
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
	
	public  List<ProcesoSincronizarSaldos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoSincronizarSaldos> entities = new  ArrayList<ProcesoSincronizarSaldos>();
		ProcesoSincronizarSaldos entity = new ProcesoSincronizarSaldos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoSincronizarSaldos();
				
				
      	    	entity=ProcesoSincronizarSaldosLogic.getEntityProcesoSincronizarSaldos("",entity,resultSet);
      	    	
				//entity.setProcesoSincronizarSaldosOriginal( new ProcesoSincronizarSaldos());
      	    	//entity.setProcesoSincronizarSaldosOriginal(super.getEntity("",entity.getProcesoSincronizarSaldosOriginal(),resultSet,ProcesoSincronizarSaldosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoSincronizarSaldosOriginal(ProcesoSincronizarSaldosDataAccess.getEntityProcesoSincronizarSaldos("",entity.getProcesoSincronizarSaldosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoSincronizarSaldos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoSincronizarSaldos> entities = new  ArrayList<ProcesoSincronizarSaldos>();
		ProcesoSincronizarSaldos entity = new ProcesoSincronizarSaldos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoSincronizarSaldos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoSincronizarSaldos>((List<ProcesoSincronizarSaldos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoSincronizarSaldossOriginal(entities);
			
			}  else {
				this.procesosincronizarsaldossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoSincronizarSaldosConstantesFunciones.quitarEspaciosProcesoSincronizarSaldoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoSincronizarSaldos getEntityProcesoSincronizarSaldos(String strPrefijo,ProcesoSincronizarSaldos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_ejercicio(resultSet.getLong(strPrefijo+ProcesoSincronizarSaldosConstantesFunciones.IDEJERCICIO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoSincronizarSaldos getEntityProcesoSincronizarSaldos(String strPrefijo,ProcesoSincronizarSaldos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoSincronizarSaldos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoSincronizarSaldos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoSincronizarSaldosLogic.setFieldReflectionProcesoSincronizarSaldos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoSincronizarSaldos(Field field,String strPrefijo,String sColumn,ProcesoSincronizarSaldos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoSincronizarSaldosConstantesFunciones.IDEJERCICIO:
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
	
	public void quitarProcesoSincronizarSaldossNulos() throws Exception {				
		
		List<ProcesoSincronizarSaldos> procesosincronizarsaldossAux= new ArrayList<ProcesoSincronizarSaldos>();
		
		for(ProcesoSincronizarSaldos procesosincronizarsaldos:procesosincronizarsaldoss) {
			if(procesosincronizarsaldos!=null) {
				procesosincronizarsaldossAux.add(procesosincronizarsaldos);
			}
		}
		
		procesosincronizarsaldoss=procesosincronizarsaldossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoSincronizarSaldos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoSincronizarSaldos> entities = new  ArrayList<ProcesoSincronizarSaldos>();
		ProcesoSincronizarSaldos entity = new ProcesoSincronizarSaldos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoSincronizarSaldos>((List<ProcesoSincronizarSaldos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoSincronizarSaldossOriginal(entities);
			
			}  else {
				this.procesosincronizarsaldossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoSincronizarSaldosConstantesFunciones.quitarEspaciosProcesoSincronizarSaldoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesosincronizarsaldoss = new  ArrayList<ProcesoSincronizarSaldos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoSincronizarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosincronizarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesosincronizarsaldoss = new  ArrayList<ProcesoSincronizarSaldos>();
		  		  
        try {
			//ProcesoSincronizarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosincronizarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoSincronizarSaldos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoSincronizarSaldos> entities = new  ArrayList<ProcesoSincronizarSaldos>();
		ProcesoSincronizarSaldos entity = new ProcesoSincronizarSaldos();		  
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
	
	public  List<ProcesoSincronizarSaldos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoSincronizarSaldos> entities = new  ArrayList<ProcesoSincronizarSaldos>();
		ProcesoSincronizarSaldos entity = new ProcesoSincronizarSaldos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoSincronizarSaldos();
				
				if(conMapGenerico) {
					entity.setMapProcesoSincronizarSaldos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoSincronizarSaldos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoSincronizarSaldosDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoSincronizarSaldosLogic.getEntityProcesoSincronizarSaldos("",entity,resultSet,listColumns);
					
					////entity.setProcesoSincronizarSaldosOriginal( new ProcesoSincronizarSaldos());
					////entity.setProcesoSincronizarSaldosOriginal(super.getEntity("",entity.getProcesoSincronizarSaldosOriginal(),resultSet,ProcesoSincronizarSaldosDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoSincronizarSaldosOriginal(ProcesoSincronizarSaldosDataAccess.getEntityProcesoSincronizarSaldos("",entity.getProcesoSincronizarSaldosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Ejercicio getEjercicio(Connexion connexion,ProcesoSincronizarSaldos relprocesosincronizarsaldos)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relprocesosincronizarsaldos.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,ProcesoSincronizarSaldos relprocesosincronizarsaldos)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);
			periodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periodo=periodoDataAccess.getEntity(connexion,relprocesosincronizarsaldos.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}


	
	
	public void getProcesoSincronizarSaldossBusquedaProcesoSincronizarSaldosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo)throws Exception {
		try {
			ProcesoSincronizarSaldosLogic procesosincronizarsaldosLogic=new ProcesoSincronizarSaldosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			//sQuerySelect=ProcesoSincronizarSaldosLogic.GetSelecSqlProcesoSincronizarSaldos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo);

			//this.getEntities(sQuerySelect, sFinalQueryFinal);

			//this.procesosincronizarsaldoss=this.getProcesoSincronizarSaldoss();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoSincronizarSaldosLogicAdditional.ProcesarInformacionProcesoSincronizarSaldos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesosincronizarsaldosLogic,this.procesosincronizarsaldoss,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoSincronizarSaldos",id_ejercicio,id_periodo);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoSincronizarSaldossBusquedaProcesoSincronizarSaldos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo)throws Exception {
		try {
			ProcesoSincronizarSaldosLogic procesosincronizarsaldosLogic=new ProcesoSincronizarSaldosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			//sQuerySelect=ProcesoSincronizarSaldosLogic.GetSelecSqlProcesoSincronizarSaldos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo);

			//this.getEntities(sQuerySelect, sFinalQueryFinal);

			//this.procesosincronizarsaldoss=this.getProcesoSincronizarSaldoss();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoSincronizarSaldosLogicAdditional.ProcesarInformacionProcesoSincronizarSaldos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesosincronizarsaldosLogic,this.procesosincronizarsaldoss,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoSincronizarSaldos",id_ejercicio,id_periodo);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoSincronizarSaldos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoSincronizarSaldos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" id_empresa="+parametroGeneralUsuario.getid_empresa();
					//existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" id_ejercicio = "+id_ejercicio.toString();
					existeWhere=true;
				}

				if(id_periodo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" id_periodo = "+id_periodo.toString();
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
	
	
	public void deepLoad(ProcesoSincronizarSaldos procesosincronizarsaldos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoSincronizarSaldosLogicAdditional.updateProcesoSincronizarSaldosToGet(procesosincronizarsaldos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesosincronizarsaldos.setEjercicio(procesosincronizarsaldosDataAccess.getEjercicio(connexion,procesosincronizarsaldos));
		procesosincronizarsaldos.setPeriodo(procesosincronizarsaldosDataAccess.getPeriodo(connexion,procesosincronizarsaldos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				procesosincronizarsaldos.setEjercicio(procesosincronizarsaldosDataAccess.getEjercicio(connexion,procesosincronizarsaldos));
			}

			if(clas.clas.equals(Periodo.class)) {
				procesosincronizarsaldos.setPeriodo(procesosincronizarsaldosDataAccess.getPeriodo(connexion,procesosincronizarsaldos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesosincronizarsaldos.setEjercicio(procesosincronizarsaldosDataAccess.getEjercicio(connexion,procesosincronizarsaldos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesosincronizarsaldos.setPeriodo(procesosincronizarsaldosDataAccess.getPeriodo(connexion,procesosincronizarsaldos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesosincronizarsaldos.setEjercicio(procesosincronizarsaldosDataAccess.getEjercicio(connexion,procesosincronizarsaldos));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(procesosincronizarsaldos.getEjercicio(),isDeep,deepLoadType,clases);
				
		procesosincronizarsaldos.setPeriodo(procesosincronizarsaldosDataAccess.getPeriodo(connexion,procesosincronizarsaldos));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(procesosincronizarsaldos.getPeriodo(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				procesosincronizarsaldos.setEjercicio(procesosincronizarsaldosDataAccess.getEjercicio(connexion,procesosincronizarsaldos));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(procesosincronizarsaldos.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Periodo.class)) {
				procesosincronizarsaldos.setPeriodo(procesosincronizarsaldosDataAccess.getPeriodo(connexion,procesosincronizarsaldos));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(procesosincronizarsaldos.getPeriodo(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesosincronizarsaldos.setEjercicio(procesosincronizarsaldosDataAccess.getEjercicio(connexion,procesosincronizarsaldos));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(procesosincronizarsaldos.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesosincronizarsaldos.setPeriodo(procesosincronizarsaldosDataAccess.getPeriodo(connexion,procesosincronizarsaldos));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(procesosincronizarsaldos.getPeriodo(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesosincronizarsaldos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoSincronizarSaldosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoSincronizarSaldos(procesosincronizarsaldos);
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
			this.deepLoad(this.procesosincronizarsaldos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoSincronizarSaldosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoSincronizarSaldos(this.procesosincronizarsaldos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesosincronizarsaldoss!=null) {
				for(ProcesoSincronizarSaldos procesosincronizarsaldos:procesosincronizarsaldoss) {
					this.deepLoad(procesosincronizarsaldos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoSincronizarSaldosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoSincronizarSaldos(procesosincronizarsaldoss);
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
			if(procesosincronizarsaldoss!=null) {
				for(ProcesoSincronizarSaldos procesosincronizarsaldos:procesosincronizarsaldoss) {
					this.deepLoad(procesosincronizarsaldos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoSincronizarSaldosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoSincronizarSaldos(procesosincronizarsaldoss);
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
	
	public ProcesoSincronizarSaldosParameterReturnGeneral procesarAccionProcesoSincronizarSaldoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,ProcesoSincronizarSaldosParameterReturnGeneral procesosincronizarsaldosParameterGeneral)throws Exception {
		 try {	
			ProcesoSincronizarSaldosParameterReturnGeneral procesosincronizarsaldosReturnGeneral=new ProcesoSincronizarSaldosParameterReturnGeneral();
	
			ProcesoSincronizarSaldosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesosincronizarsaldoss,procesosincronizarsaldosParameterGeneral,procesosincronizarsaldosReturnGeneral);
			
			return procesosincronizarsaldosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoSincronizarSaldosParameterReturnGeneral procesarAccionProcesoSincronizarSaldossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,ProcesoSincronizarSaldosParameterReturnGeneral procesosincronizarsaldosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoSincronizarSaldosParameterReturnGeneral procesosincronizarsaldosReturnGeneral=new ProcesoSincronizarSaldosParameterReturnGeneral();
	
			ProcesoSincronizarSaldosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesosincronizarsaldoss,procesosincronizarsaldosParameterGeneral,procesosincronizarsaldosReturnGeneral);
			
			this.connexion.commit();
			
			return procesosincronizarsaldosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoSincronizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,String sTipoBusqueda,Long id_ejercicioBusquedaProcesoSincronizarSaldos,Long id_periodoBusquedaProcesoSincronizarSaldos) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoSincronizarSaldosLogicAdditional procesosincronizarsaldosLogicAdditional=new ProcesoSincronizarSaldosLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesosincronizarsaldosLogicAdditional.setConnexion(this.connexion);

			procesosincronizarsaldosLogicAdditional.ProcesarInformacionProcesoSincronizarSaldos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesosincronizarsaldoss,sTipoBusqueda,id_ejercicioBusquedaProcesoSincronizarSaldos,id_periodoBusquedaProcesoSincronizarSaldos);

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

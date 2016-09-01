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
import com.bydan.erp.activosfijos.util.report.ListadoActivosFijosParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ListadoActivosFijosParameterGeneral;
import com.bydan.erp.activosfijos.util.report.ListadoActivosFijosConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.ListadoActivosFijos;

import com.bydan.erp.activosfijos.business.logic.report.ListadoActivosFijosLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ListadoActivosFijosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ListadoActivosFijosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ListadoActivosFijosLogic listadoactivosfijosDataAccess; 		
	protected ListadoActivosFijos listadoactivosfijos;
	protected List<ListadoActivosFijos> listadoactivosfijoss;
	protected Object listadoactivosfijosObject;	
	protected List<Object> listadoactivosfijossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ListadoActivosFijosLogic()throws SQLException,Exception {
		try	{
			this.listadoactivosfijoss= new ArrayList<ListadoActivosFijos>();
			this.listadoactivosfijos= new ListadoActivosFijos();
			this.listadoactivosfijosObject=new Object();
			this.listadoactivosfijossObject=new ArrayList<Object>();
			
			this.listadoactivosfijosDataAccess=this;
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
			this.listadoactivosfijosDataAccess.setConnexionType(this.connexionType);
			this.listadoactivosfijosDataAccess.setParameterDbType(this.parameterDbType);
			this.listadoactivosfijosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ListadoActivosFijosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.listadoactivosfijoss= new ArrayList<ListadoActivosFijos>();
			this.listadoactivosfijos= new ListadoActivosFijos();
			this.listadoactivosfijosObject=new Object();
			this.listadoactivosfijossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.listadoactivosfijosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.listadoactivosfijosDataAccess.setConnexionType(this.connexionType);
			this.listadoactivosfijosDataAccess.setParameterDbType(this.parameterDbType);
			this.listadoactivosfijosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ListadoActivosFijos getListadoActivosFijos() throws Exception {	
		ListadoActivosFijosLogicAdditional.checkListadoActivosFijosToGet(listadoactivosfijos,this.datosCliente,this.arrDatoGeneral);
		ListadoActivosFijosLogicAdditional.updateListadoActivosFijosToGet(listadoactivosfijos,this.arrDatoGeneral);
		
		return listadoactivosfijos;
	}
		
	public void setListadoActivosFijos(ListadoActivosFijos newListadoActivosFijos) {
		this.listadoactivosfijos = newListadoActivosFijos;
	}
	
	public List<ListadoActivosFijos> getListadoActivosFijoss() throws Exception {		
		this.quitarListadoActivosFijossNulos();
		
		ListadoActivosFijosLogicAdditional.checkListadoActivosFijosToGets(listadoactivosfijoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ListadoActivosFijos listadoactivosfijosLocal: listadoactivosfijoss ) {
			ListadoActivosFijosLogicAdditional.updateListadoActivosFijosToGet(listadoactivosfijosLocal,this.arrDatoGeneral);
		}
		
		return listadoactivosfijoss;
	}
	
	public void setListadoActivosFijoss(List<ListadoActivosFijos> newListadoActivosFijoss) {
		this.listadoactivosfijoss = newListadoActivosFijoss;
	}
	
	public Object getListadoActivosFijosObject() {	
		//this.listadoactivosfijosObject=this.listadoactivosfijosDataAccess.getEntityObject();
		return this.listadoactivosfijosObject;
	}
		
	public void setListadoActivosFijosObject(Object newListadoActivosFijosObject) {
		this.listadoactivosfijosObject = newListadoActivosFijosObject;
	}
	
	public List<Object> getListadoActivosFijossObject() {		
		//this.listadoactivosfijossObject=this.listadoactivosfijosDataAccess.getEntitiesObject();
		return this.listadoactivosfijossObject;
	}
		
	public void setListadoActivosFijossObject(List<Object> newListadoActivosFijossObject) {
		this.listadoactivosfijossObject = newListadoActivosFijossObject;
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
		listadoactivosfijoss = new  ArrayList<ListadoActivosFijos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ListadoActivosFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadoactivosfijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		listadoactivosfijoss = new  ArrayList<ListadoActivosFijos>();
		  		  
        try {
			//ListadoActivosFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadoactivosfijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		listadoactivosfijoss = new  ArrayList<ListadoActivosFijos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ListadoActivosFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadoactivosfijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		listadoactivosfijoss = new  ArrayList<ListadoActivosFijos>();
		  		  
        try {
			//ListadoActivosFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadoactivosfijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		listadoactivosfijoss = new  ArrayList<ListadoActivosFijos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ListadoActivosFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadoactivosfijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		listadoactivosfijoss = new  ArrayList<ListadoActivosFijos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ListadoActivosFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadoactivosfijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ListadoActivosFijos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ListadoActivosFijos> entities = new  ArrayList<ListadoActivosFijos>();
		ListadoActivosFijos entity = new ListadoActivosFijos();		  
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
	
	public  List<ListadoActivosFijos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ListadoActivosFijos> entities = new  ArrayList<ListadoActivosFijos>();
		ListadoActivosFijos entity = new ListadoActivosFijos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ListadoActivosFijos();
				
				
      	    	entity=ListadoActivosFijosLogic.getEntityListadoActivosFijos("",entity,resultSet);
      	    	
				//entity.setListadoActivosFijosOriginal( new ListadoActivosFijos());
      	    	//entity.setListadoActivosFijosOriginal(super.getEntity("",entity.getListadoActivosFijosOriginal(),resultSet,ListadoActivosFijosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setListadoActivosFijosOriginal(ListadoActivosFijosDataAccess.getEntityListadoActivosFijos("",entity.getListadoActivosFijosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ListadoActivosFijos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ListadoActivosFijos> entities = new  ArrayList<ListadoActivosFijos>();
		ListadoActivosFijos entity = new ListadoActivosFijos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ListadoActivosFijos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ListadoActivosFijos>((List<ListadoActivosFijos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setListadoActivosFijossOriginal(entities);
			
			}  else {
				this.listadoactivosfijossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ListadoActivosFijosConstantesFunciones.quitarEspaciosListadoActivosFijoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ListadoActivosFijos getEntityListadoActivosFijos(String strPrefijo,ListadoActivosFijos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_sub_grupo(resultSet.getString(strPrefijo+ListadoActivosFijosConstantesFunciones.CODIGOSUBGRUPO));
			entity.setnombre_sub_grupo(resultSet.getString(strPrefijo+ListadoActivosFijosConstantesFunciones.NOMBRESUBGRUPO));
			entity.setcodigo_detalle_grupo(resultSet.getString(strPrefijo+ListadoActivosFijosConstantesFunciones.CODIGODETALLEGRUPO));
			entity.setnombre_detalle_grupo(resultSet.getString(strPrefijo+ListadoActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO));
			entity.setclave(resultSet.getString(strPrefijo+ListadoActivosFijosConstantesFunciones.CLAVE));
			entity.setnombre(resultSet.getString(strPrefijo+ListadoActivosFijosConstantesFunciones.NOMBRE));
			entity.setfecha_compra(new Date(resultSet.getDate(strPrefijo+ListadoActivosFijosConstantesFunciones.FECHACOMPRA).getTime()));
			entity.setvida_util(resultSet.getDouble(strPrefijo+ListadoActivosFijosConstantesFunciones.VIDAUTIL));
			entity.setcosto_de_compra(resultSet.getDouble(strPrefijo+ListadoActivosFijosConstantesFunciones.COSTODECOMPRA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ListadoActivosFijos getEntityListadoActivosFijos(String strPrefijo,ListadoActivosFijos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ListadoActivosFijos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ListadoActivosFijos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ListadoActivosFijosLogic.setFieldReflectionListadoActivosFijos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionListadoActivosFijos(Field field,String strPrefijo,String sColumn,ListadoActivosFijos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ListadoActivosFijosConstantesFunciones.CODIGOSUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadoActivosFijosConstantesFunciones.NOMBRESUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadoActivosFijosConstantesFunciones.CODIGODETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadoActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadoActivosFijosConstantesFunciones.CLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadoActivosFijosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadoActivosFijosConstantesFunciones.FECHACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ListadoActivosFijosConstantesFunciones.VIDAUTIL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ListadoActivosFijosConstantesFunciones.COSTODECOMPRA:
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
	
	public void quitarListadoActivosFijossNulos() throws Exception {				
		
		List<ListadoActivosFijos> listadoactivosfijossAux= new ArrayList<ListadoActivosFijos>();
		
		for(ListadoActivosFijos listadoactivosfijos:listadoactivosfijoss) {
			if(listadoactivosfijos!=null) {
				listadoactivosfijossAux.add(listadoactivosfijos);
			}
		}
		
		listadoactivosfijoss=listadoactivosfijossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ListadoActivosFijos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ListadoActivosFijos> entities = new  ArrayList<ListadoActivosFijos>();
		ListadoActivosFijos entity = new ListadoActivosFijos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ListadoActivosFijos>((List<ListadoActivosFijos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setListadoActivosFijossOriginal(entities);
			
			}  else {
				this.listadoactivosfijossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ListadoActivosFijosConstantesFunciones.quitarEspaciosListadoActivosFijoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		listadoactivosfijoss = new  ArrayList<ListadoActivosFijos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ListadoActivosFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadoactivosfijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		listadoactivosfijoss = new  ArrayList<ListadoActivosFijos>();
		  		  
        try {
			//ListadoActivosFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadoactivosfijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ListadoActivosFijos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ListadoActivosFijos> entities = new  ArrayList<ListadoActivosFijos>();
		ListadoActivosFijos entity = new ListadoActivosFijos();		  
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
	
	public  List<ListadoActivosFijos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ListadoActivosFijos> entities = new  ArrayList<ListadoActivosFijos>();
		ListadoActivosFijos entity = new ListadoActivosFijos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ListadoActivosFijos();
				
				if(conMapGenerico) {
					entity.setMapListadoActivosFijos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapListadoActivosFijos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ListadoActivosFijosDataAccess.ISWITHSCHEMA);         		
					entity=ListadoActivosFijosLogic.getEntityListadoActivosFijos("",entity,resultSet,listColumns);
					
					////entity.setListadoActivosFijosOriginal( new ListadoActivosFijos());
					////entity.setListadoActivosFijosOriginal(super.getEntity("",entity.getListadoActivosFijosOriginal(),resultSet,ListadoActivosFijosDataAccess.ISWITHSCHEMA));         		
					////entity.setListadoActivosFijosOriginal(ListadoActivosFijosDataAccess.getEntityListadoActivosFijos("",entity.getListadoActivosFijosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ListadoActivosFijos rellistadoactivosfijos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,rellistadoactivosfijos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getListadoActivosFijossBusquedaListadoActivosFijosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//ListadoActivosFijosLogic listadoactivosfijosLogic=new ListadoActivosFijosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ListadoActivosFijosLogic.GetSelecSqlListadoActivosFijos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.listadoactivosfijoss=this.getListadoActivosFijoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getListadoActivosFijossBusquedaListadoActivosFijos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//ListadoActivosFijosLogic listadoactivosfijosLogic=new ListadoActivosFijosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ListadoActivosFijosLogic.GetSelecSqlListadoActivosFijos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.listadoactivosfijoss=this.getListadoActivosFijoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlListadoActivosFijos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ListadoActivosFijos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
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
	
	
	public void deepLoad(ListadoActivosFijos listadoactivosfijos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ListadoActivosFijosLogicAdditional.updateListadoActivosFijosToGet(listadoactivosfijos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		listadoactivosfijos.setEmpresa(listadoactivosfijosDataAccess.getEmpresa(connexion,listadoactivosfijos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				listadoactivosfijos.setEmpresa(listadoactivosfijosDataAccess.getEmpresa(connexion,listadoactivosfijos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			listadoactivosfijos.setEmpresa(listadoactivosfijosDataAccess.getEmpresa(connexion,listadoactivosfijos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		listadoactivosfijos.setEmpresa(listadoactivosfijosDataAccess.getEmpresa(connexion,listadoactivosfijos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(listadoactivosfijos.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				listadoactivosfijos.setEmpresa(listadoactivosfijosDataAccess.getEmpresa(connexion,listadoactivosfijos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(listadoactivosfijos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			listadoactivosfijos.setEmpresa(listadoactivosfijosDataAccess.getEmpresa(connexion,listadoactivosfijos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(listadoactivosfijos.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(listadoactivosfijos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ListadoActivosFijosConstantesFunciones.refrescarForeignKeysDescripcionesListadoActivosFijos(listadoactivosfijos);
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
			this.deepLoad(this.listadoactivosfijos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ListadoActivosFijosConstantesFunciones.refrescarForeignKeysDescripcionesListadoActivosFijos(this.listadoactivosfijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(listadoactivosfijoss!=null) {
				for(ListadoActivosFijos listadoactivosfijos:listadoactivosfijoss) {
					this.deepLoad(listadoactivosfijos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ListadoActivosFijosConstantesFunciones.refrescarForeignKeysDescripcionesListadoActivosFijos(listadoactivosfijoss);
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
			if(listadoactivosfijoss!=null) {
				for(ListadoActivosFijos listadoactivosfijos:listadoactivosfijoss) {
					this.deepLoad(listadoactivosfijos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ListadoActivosFijosConstantesFunciones.refrescarForeignKeysDescripcionesListadoActivosFijos(listadoactivosfijoss);
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
	
	public ListadoActivosFijosParameterReturnGeneral procesarAccionListadoActivosFijoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ListadoActivosFijos> listadoactivosfijoss,ListadoActivosFijosParameterReturnGeneral listadoactivosfijosParameterGeneral)throws Exception {
		 try {	
			ListadoActivosFijosParameterReturnGeneral listadoactivosfijosReturnGeneral=new ListadoActivosFijosParameterReturnGeneral();
	
			ListadoActivosFijosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,listadoactivosfijoss,listadoactivosfijosParameterGeneral,listadoactivosfijosReturnGeneral);
			
			return listadoactivosfijosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ListadoActivosFijosParameterReturnGeneral procesarAccionListadoActivosFijossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ListadoActivosFijos> listadoactivosfijoss,ListadoActivosFijosParameterReturnGeneral listadoactivosfijosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ListadoActivosFijosParameterReturnGeneral listadoactivosfijosReturnGeneral=new ListadoActivosFijosParameterReturnGeneral();
	
			ListadoActivosFijosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,listadoactivosfijoss,listadoactivosfijosParameterGeneral,listadoactivosfijosReturnGeneral);
			
			this.connexion.commit();
			
			return listadoactivosfijosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

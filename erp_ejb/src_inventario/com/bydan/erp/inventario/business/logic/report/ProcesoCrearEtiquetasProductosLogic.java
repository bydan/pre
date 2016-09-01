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
package com.bydan.erp.inventario.business.logic.report;

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

import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.resources.general.AuxiliarGeneral;
import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasProductosParameterGeneral;
import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasProductosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProcesoCrearEtiquetasProductos;

import com.bydan.erp.inventario.business.logic.report.ProcesoCrearEtiquetasProductosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoCrearEtiquetasProductosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCrearEtiquetasProductosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCrearEtiquetasProductosLogic procesocrearetiquetasproductosDataAccess; 		
	protected ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos;
	protected List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss;
	protected Object procesocrearetiquetasproductosObject;	
	protected List<Object> procesocrearetiquetasproductossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCrearEtiquetasProductosLogic()throws SQLException,Exception {
		try	{
			this.procesocrearetiquetasproductoss= new ArrayList<ProcesoCrearEtiquetasProductos>();
			this.procesocrearetiquetasproductos= new ProcesoCrearEtiquetasProductos();
			this.procesocrearetiquetasproductosObject=new Object();
			this.procesocrearetiquetasproductossObject=new ArrayList<Object>();
			
			this.procesocrearetiquetasproductosDataAccess=this;
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
			this.procesocrearetiquetasproductosDataAccess.setConnexionType(this.connexionType);
			this.procesocrearetiquetasproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocrearetiquetasproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCrearEtiquetasProductosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocrearetiquetasproductoss= new ArrayList<ProcesoCrearEtiquetasProductos>();
			this.procesocrearetiquetasproductos= new ProcesoCrearEtiquetasProductos();
			this.procesocrearetiquetasproductosObject=new Object();
			this.procesocrearetiquetasproductossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocrearetiquetasproductosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocrearetiquetasproductosDataAccess.setConnexionType(this.connexionType);
			this.procesocrearetiquetasproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocrearetiquetasproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCrearEtiquetasProductos getProcesoCrearEtiquetasProductos() throws Exception {	
		ProcesoCrearEtiquetasProductosLogicAdditional.checkProcesoCrearEtiquetasProductosToGet(procesocrearetiquetasproductos,this.datosCliente,this.arrDatoGeneral);
		ProcesoCrearEtiquetasProductosLogicAdditional.updateProcesoCrearEtiquetasProductosToGet(procesocrearetiquetasproductos,this.arrDatoGeneral);
		
		return procesocrearetiquetasproductos;
	}
		
	public void setProcesoCrearEtiquetasProductos(ProcesoCrearEtiquetasProductos newProcesoCrearEtiquetasProductos) {
		this.procesocrearetiquetasproductos = newProcesoCrearEtiquetasProductos;
	}
	
	public List<ProcesoCrearEtiquetasProductos> getProcesoCrearEtiquetasProductoss() throws Exception {		
		this.quitarProcesoCrearEtiquetasProductossNulos();
		
		ProcesoCrearEtiquetasProductosLogicAdditional.checkProcesoCrearEtiquetasProductosToGets(procesocrearetiquetasproductoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCrearEtiquetasProductos procesocrearetiquetasproductosLocal: procesocrearetiquetasproductoss ) {
			ProcesoCrearEtiquetasProductosLogicAdditional.updateProcesoCrearEtiquetasProductosToGet(procesocrearetiquetasproductosLocal,this.arrDatoGeneral);
		}
		
		return procesocrearetiquetasproductoss;
	}
	
	public void setProcesoCrearEtiquetasProductoss(List<ProcesoCrearEtiquetasProductos> newProcesoCrearEtiquetasProductoss) {
		this.procesocrearetiquetasproductoss = newProcesoCrearEtiquetasProductoss;
	}
	
	public Object getProcesoCrearEtiquetasProductosObject() {	
		//this.procesocrearetiquetasproductosObject=this.procesocrearetiquetasproductosDataAccess.getEntityObject();
		return this.procesocrearetiquetasproductosObject;
	}
		
	public void setProcesoCrearEtiquetasProductosObject(Object newProcesoCrearEtiquetasProductosObject) {
		this.procesocrearetiquetasproductosObject = newProcesoCrearEtiquetasProductosObject;
	}
	
	public List<Object> getProcesoCrearEtiquetasProductossObject() {		
		//this.procesocrearetiquetasproductossObject=this.procesocrearetiquetasproductosDataAccess.getEntitiesObject();
		return this.procesocrearetiquetasproductossObject;
	}
		
	public void setProcesoCrearEtiquetasProductossObject(List<Object> newProcesoCrearEtiquetasProductossObject) {
		this.procesocrearetiquetasproductossObject = newProcesoCrearEtiquetasProductossObject;
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
		procesocrearetiquetasproductoss = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCrearEtiquetasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocrearetiquetasproductoss = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		  		  
        try {
			//ProcesoCrearEtiquetasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocrearetiquetasproductoss = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCrearEtiquetasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocrearetiquetasproductoss = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		  		  
        try {
			//ProcesoCrearEtiquetasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocrearetiquetasproductoss = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCrearEtiquetasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocrearetiquetasproductoss = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCrearEtiquetasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCrearEtiquetasProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasProductos> entities = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		ProcesoCrearEtiquetasProductos entity = new ProcesoCrearEtiquetasProductos();		  
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
	
	public  List<ProcesoCrearEtiquetasProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasProductos> entities = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		ProcesoCrearEtiquetasProductos entity = new ProcesoCrearEtiquetasProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCrearEtiquetasProductos();
				
				
      	    	entity=ProcesoCrearEtiquetasProductosLogic.getEntityProcesoCrearEtiquetasProductos("",entity,resultSet);
      	    	
				//entity.setProcesoCrearEtiquetasProductosOriginal( new ProcesoCrearEtiquetasProductos());
      	    	//entity.setProcesoCrearEtiquetasProductosOriginal(super.getEntity("",entity.getProcesoCrearEtiquetasProductosOriginal(),resultSet,ProcesoCrearEtiquetasProductosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCrearEtiquetasProductosOriginal(ProcesoCrearEtiquetasProductosDataAccess.getEntityProcesoCrearEtiquetasProductos("",entity.getProcesoCrearEtiquetasProductosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCrearEtiquetasProductos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasProductos> entities = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		ProcesoCrearEtiquetasProductos entity = new ProcesoCrearEtiquetasProductos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCrearEtiquetasProductos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCrearEtiquetasProductos>((List<ProcesoCrearEtiquetasProductos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCrearEtiquetasProductossOriginal(entities);
			
			}  else {
				this.procesocrearetiquetasproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCrearEtiquetasProductosConstantesFunciones.quitarEspaciosProcesoCrearEtiquetasProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCrearEtiquetasProductos getEntityProcesoCrearEtiquetasProductos(String strPrefijo,ProcesoCrearEtiquetasProductos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ProcesoCrearEtiquetasProductosConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+ProcesoCrearEtiquetasProductosConstantesFunciones.NOMBRE));
			entity.setprecio1(resultSet.getDouble(strPrefijo+ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1));
			entity.setprecio2(resultSet.getDouble(strPrefijo+ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2));
			entity.setprecio3(resultSet.getDouble(strPrefijo+ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3));
			entity.setprecio4(resultSet.getDouble(strPrefijo+ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4));
			entity.setprecio5(resultSet.getDouble(strPrefijo+ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCrearEtiquetasProductos getEntityProcesoCrearEtiquetasProductos(String strPrefijo,ProcesoCrearEtiquetasProductos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCrearEtiquetasProductos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCrearEtiquetasProductos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCrearEtiquetasProductosLogic.setFieldReflectionProcesoCrearEtiquetasProductos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCrearEtiquetasProductos(Field field,String strPrefijo,String sColumn,ProcesoCrearEtiquetasProductos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoCrearEtiquetasProductosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoCrearEtiquetasProductosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5:
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
	
	public void quitarProcesoCrearEtiquetasProductossNulos() throws Exception {				
		
		List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductossAux= new ArrayList<ProcesoCrearEtiquetasProductos>();
		
		for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos:procesocrearetiquetasproductoss) {
			if(procesocrearetiquetasproductos!=null) {
				procesocrearetiquetasproductossAux.add(procesocrearetiquetasproductos);
			}
		}
		
		procesocrearetiquetasproductoss=procesocrearetiquetasproductossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCrearEtiquetasProductos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasProductos> entities = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		ProcesoCrearEtiquetasProductos entity = new ProcesoCrearEtiquetasProductos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCrearEtiquetasProductos>((List<ProcesoCrearEtiquetasProductos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCrearEtiquetasProductossOriginal(entities);
			
			}  else {
				this.procesocrearetiquetasproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCrearEtiquetasProductosConstantesFunciones.quitarEspaciosProcesoCrearEtiquetasProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocrearetiquetasproductoss = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCrearEtiquetasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesocrearetiquetasproductoss = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		  		  
        try {
			//ProcesoCrearEtiquetasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCrearEtiquetasProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasProductos> entities = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		ProcesoCrearEtiquetasProductos entity = new ProcesoCrearEtiquetasProductos();		  
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
	
	public  List<ProcesoCrearEtiquetasProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasProductos> entities = new  ArrayList<ProcesoCrearEtiquetasProductos>();
		ProcesoCrearEtiquetasProductos entity = new ProcesoCrearEtiquetasProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCrearEtiquetasProductos();
				
				if(conMapGenerico) {
					entity.setMapProcesoCrearEtiquetasProductos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCrearEtiquetasProductos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCrearEtiquetasProductosDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCrearEtiquetasProductosLogic.getEntityProcesoCrearEtiquetasProductos("",entity,resultSet,listColumns);
					
					////entity.setProcesoCrearEtiquetasProductosOriginal( new ProcesoCrearEtiquetasProductos());
					////entity.setProcesoCrearEtiquetasProductosOriginal(super.getEntity("",entity.getProcesoCrearEtiquetasProductosOriginal(),resultSet,ProcesoCrearEtiquetasProductosDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCrearEtiquetasProductosOriginal(ProcesoCrearEtiquetasProductosDataAccess.getEntityProcesoCrearEtiquetasProductos("",entity.getProcesoCrearEtiquetasProductosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,ProcesoCrearEtiquetasProductos relprocesocrearetiquetasproductos)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relprocesocrearetiquetasproductos.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProcesoCrearEtiquetasProductos relprocesocrearetiquetasproductos)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relprocesocrearetiquetasproductos.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,ProcesoCrearEtiquetasProductos relprocesocrearetiquetasproductos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relprocesocrearetiquetasproductos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProcesoCrearEtiquetasProductos relprocesocrearetiquetasproductos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relprocesocrearetiquetasproductos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,ProcesoCrearEtiquetasProductos relprocesocrearetiquetasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocrearetiquetasproductos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProcesoCrearEtiquetasProductos relprocesocrearetiquetasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocrearetiquetasproductos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProcesoCrearEtiquetasProductos relprocesocrearetiquetasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocrearetiquetasproductos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProcesoCrearEtiquetasProductos relprocesocrearetiquetasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocrearetiquetasproductos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getProcesoCrearEtiquetasProductossBusquedaProcesoCrearEtiquetasProductosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoCrearEtiquetasProductosLogic procesocrearetiquetasproductosLogic=new ProcesoCrearEtiquetasProductosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoCrearEtiquetasProductosLogic.GetSelecSqlProcesoCrearEtiquetasProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesocrearetiquetasproductoss=this.getProcesoCrearEtiquetasProductoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCrearEtiquetasProductossBusquedaProcesoCrearEtiquetasProductos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoCrearEtiquetasProductosLogic procesocrearetiquetasproductosLogic=new ProcesoCrearEtiquetasProductosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoCrearEtiquetasProductosLogic.GetSelecSqlProcesoCrearEtiquetasProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesocrearetiquetasproductoss=this.getProcesoCrearEtiquetasProductoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoCrearEtiquetasProductos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoCrearEtiquetasProductos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_bodega!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_bodega = "+id_bodega.toString();
					existeWhere=true;
				}

				if(id_producto!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_producto = "+id_producto.toString();
					existeWhere=true;
				}

				if(id_linea!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea = "+id_linea.toString();
					existeWhere=true;
				}

				if(id_linea_grupo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_grupo = "+id_linea_grupo.toString();
					existeWhere=true;
				}

				if(id_linea_categoria!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_categoria = "+id_linea_categoria.toString();
					existeWhere=true;
				}

				if(id_linea_marca!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_marca = "+id_linea_marca.toString();
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
	
	
	public void deepLoad(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoCrearEtiquetasProductosLogicAdditional.updateProcesoCrearEtiquetasProductosToGet(procesocrearetiquetasproductos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocrearetiquetasproductos.setBodega(procesocrearetiquetasproductosDataAccess.getBodega(connexion,procesocrearetiquetasproductos));
		procesocrearetiquetasproductos.setProducto(procesocrearetiquetasproductosDataAccess.getProducto(connexion,procesocrearetiquetasproductos));
		procesocrearetiquetasproductos.setEmpresa(procesocrearetiquetasproductosDataAccess.getEmpresa(connexion,procesocrearetiquetasproductos));
		procesocrearetiquetasproductos.setSucursal(procesocrearetiquetasproductosDataAccess.getSucursal(connexion,procesocrearetiquetasproductos));
		procesocrearetiquetasproductos.setLinea(procesocrearetiquetasproductosDataAccess.getLinea(connexion,procesocrearetiquetasproductos));
		procesocrearetiquetasproductos.setLineaGrupo(procesocrearetiquetasproductosDataAccess.getLineaGrupo(connexion,procesocrearetiquetasproductos));
		procesocrearetiquetasproductos.setLineaCategoria(procesocrearetiquetasproductosDataAccess.getLineaCategoria(connexion,procesocrearetiquetasproductos));
		procesocrearetiquetasproductos.setLineaMarca(procesocrearetiquetasproductosDataAccess.getLineaMarca(connexion,procesocrearetiquetasproductos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesocrearetiquetasproductos.setBodega(procesocrearetiquetasproductosDataAccess.getBodega(connexion,procesocrearetiquetasproductos));
			}

			if(clas.clas.equals(Producto.class)) {
				procesocrearetiquetasproductos.setProducto(procesocrearetiquetasproductosDataAccess.getProducto(connexion,procesocrearetiquetasproductos));
			}

			if(clas.clas.equals(Empresa.class)) {
				procesocrearetiquetasproductos.setEmpresa(procesocrearetiquetasproductosDataAccess.getEmpresa(connexion,procesocrearetiquetasproductos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesocrearetiquetasproductos.setSucursal(procesocrearetiquetasproductosDataAccess.getSucursal(connexion,procesocrearetiquetasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetasproductos.setLinea(procesocrearetiquetasproductosDataAccess.getLinea(connexion,procesocrearetiquetasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetasproductos.setLineaGrupo(procesocrearetiquetasproductosDataAccess.getLineaGrupo(connexion,procesocrearetiquetasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetasproductos.setLineaCategoria(procesocrearetiquetasproductosDataAccess.getLineaCategoria(connexion,procesocrearetiquetasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetasproductos.setLineaMarca(procesocrearetiquetasproductosDataAccess.getLineaMarca(connexion,procesocrearetiquetasproductos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setBodega(procesocrearetiquetasproductosDataAccess.getBodega(connexion,procesocrearetiquetasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setProducto(procesocrearetiquetasproductosDataAccess.getProducto(connexion,procesocrearetiquetasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setEmpresa(procesocrearetiquetasproductosDataAccess.getEmpresa(connexion,procesocrearetiquetasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setSucursal(procesocrearetiquetasproductosDataAccess.getSucursal(connexion,procesocrearetiquetasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setLinea(procesocrearetiquetasproductosDataAccess.getLinea(connexion,procesocrearetiquetasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setLineaGrupo(procesocrearetiquetasproductosDataAccess.getLineaGrupo(connexion,procesocrearetiquetasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setLineaCategoria(procesocrearetiquetasproductosDataAccess.getLineaCategoria(connexion,procesocrearetiquetasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setLineaMarca(procesocrearetiquetasproductosDataAccess.getLineaMarca(connexion,procesocrearetiquetasproductos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocrearetiquetasproductos.setBodega(procesocrearetiquetasproductosDataAccess.getBodega(connexion,procesocrearetiquetasproductos));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(procesocrearetiquetasproductos.getBodega(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetasproductos.setProducto(procesocrearetiquetasproductosDataAccess.getProducto(connexion,procesocrearetiquetasproductos));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(procesocrearetiquetasproductos.getProducto(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetasproductos.setEmpresa(procesocrearetiquetasproductosDataAccess.getEmpresa(connexion,procesocrearetiquetasproductos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(procesocrearetiquetasproductos.getEmpresa(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetasproductos.setSucursal(procesocrearetiquetasproductosDataAccess.getSucursal(connexion,procesocrearetiquetasproductos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(procesocrearetiquetasproductos.getSucursal(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetasproductos.setLinea(procesocrearetiquetasproductosDataAccess.getLinea(connexion,procesocrearetiquetasproductos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(procesocrearetiquetasproductos.getLinea(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetasproductos.setLineaGrupo(procesocrearetiquetasproductosDataAccess.getLineaGrupo(connexion,procesocrearetiquetasproductos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(procesocrearetiquetasproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetasproductos.setLineaCategoria(procesocrearetiquetasproductosDataAccess.getLineaCategoria(connexion,procesocrearetiquetasproductos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(procesocrearetiquetasproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetasproductos.setLineaMarca(procesocrearetiquetasproductosDataAccess.getLineaMarca(connexion,procesocrearetiquetasproductos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(procesocrearetiquetasproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesocrearetiquetasproductos.setBodega(procesocrearetiquetasproductosDataAccess.getBodega(connexion,procesocrearetiquetasproductos));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(procesocrearetiquetasproductos.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				procesocrearetiquetasproductos.setProducto(procesocrearetiquetasproductosDataAccess.getProducto(connexion,procesocrearetiquetasproductos));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(procesocrearetiquetasproductos.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				procesocrearetiquetasproductos.setEmpresa(procesocrearetiquetasproductosDataAccess.getEmpresa(connexion,procesocrearetiquetasproductos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(procesocrearetiquetasproductos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesocrearetiquetasproductos.setSucursal(procesocrearetiquetasproductosDataAccess.getSucursal(connexion,procesocrearetiquetasproductos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(procesocrearetiquetasproductos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetasproductos.setLinea(procesocrearetiquetasproductosDataAccess.getLinea(connexion,procesocrearetiquetasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocrearetiquetasproductos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetasproductos.setLineaGrupo(procesocrearetiquetasproductosDataAccess.getLineaGrupo(connexion,procesocrearetiquetasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocrearetiquetasproductos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetasproductos.setLineaCategoria(procesocrearetiquetasproductosDataAccess.getLineaCategoria(connexion,procesocrearetiquetasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocrearetiquetasproductos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetasproductos.setLineaMarca(procesocrearetiquetasproductosDataAccess.getLineaMarca(connexion,procesocrearetiquetasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocrearetiquetasproductos.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setBodega(procesocrearetiquetasproductosDataAccess.getBodega(connexion,procesocrearetiquetasproductos));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(procesocrearetiquetasproductos.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setProducto(procesocrearetiquetasproductosDataAccess.getProducto(connexion,procesocrearetiquetasproductos));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(procesocrearetiquetasproductos.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setEmpresa(procesocrearetiquetasproductosDataAccess.getEmpresa(connexion,procesocrearetiquetasproductos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(procesocrearetiquetasproductos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setSucursal(procesocrearetiquetasproductosDataAccess.getSucursal(connexion,procesocrearetiquetasproductos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(procesocrearetiquetasproductos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setLinea(procesocrearetiquetasproductosDataAccess.getLinea(connexion,procesocrearetiquetasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocrearetiquetasproductos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setLineaGrupo(procesocrearetiquetasproductosDataAccess.getLineaGrupo(connexion,procesocrearetiquetasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocrearetiquetasproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setLineaCategoria(procesocrearetiquetasproductosDataAccess.getLineaCategoria(connexion,procesocrearetiquetasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocrearetiquetasproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetasproductos.setLineaMarca(procesocrearetiquetasproductosDataAccess.getLineaMarca(connexion,procesocrearetiquetasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocrearetiquetasproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesocrearetiquetasproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCrearEtiquetasProductosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCrearEtiquetasProductos(procesocrearetiquetasproductos);
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
			this.deepLoad(this.procesocrearetiquetasproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCrearEtiquetasProductosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCrearEtiquetasProductos(this.procesocrearetiquetasproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocrearetiquetasproductoss!=null) {
				for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos:procesocrearetiquetasproductoss) {
					this.deepLoad(procesocrearetiquetasproductos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCrearEtiquetasProductosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCrearEtiquetasProductos(procesocrearetiquetasproductoss);
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
			if(procesocrearetiquetasproductoss!=null) {
				for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos:procesocrearetiquetasproductoss) {
					this.deepLoad(procesocrearetiquetasproductos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCrearEtiquetasProductosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCrearEtiquetasProductos(procesocrearetiquetasproductoss);
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
	
	public ProcesoCrearEtiquetasProductosParameterReturnGeneral procesarAccionProcesoCrearEtiquetasProductoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss,ProcesoCrearEtiquetasProductosParameterReturnGeneral procesocrearetiquetasproductosParameterGeneral)throws Exception {
		 try {	
			ProcesoCrearEtiquetasProductosParameterReturnGeneral procesocrearetiquetasproductosReturnGeneral=new ProcesoCrearEtiquetasProductosParameterReturnGeneral();
	
			ProcesoCrearEtiquetasProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocrearetiquetasproductoss,procesocrearetiquetasproductosParameterGeneral,procesocrearetiquetasproductosReturnGeneral);
			
			return procesocrearetiquetasproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCrearEtiquetasProductosParameterReturnGeneral procesarAccionProcesoCrearEtiquetasProductossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss,ProcesoCrearEtiquetasProductosParameterReturnGeneral procesocrearetiquetasproductosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCrearEtiquetasProductosParameterReturnGeneral procesocrearetiquetasproductosReturnGeneral=new ProcesoCrearEtiquetasProductosParameterReturnGeneral();
	
			ProcesoCrearEtiquetasProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocrearetiquetasproductoss,procesocrearetiquetasproductosParameterGeneral,procesocrearetiquetasproductosReturnGeneral);
			
			this.connexion.commit();
			
			return procesocrearetiquetasproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

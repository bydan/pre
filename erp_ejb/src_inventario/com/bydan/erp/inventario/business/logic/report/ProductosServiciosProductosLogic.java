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
import com.bydan.erp.inventario.util.report.ProductosServiciosProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProductosServiciosProductosParameterGeneral;
import com.bydan.erp.inventario.util.report.ProductosServiciosProductosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProductosServiciosProductos;

import com.bydan.erp.inventario.business.logic.report.ProductosServiciosProductosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProductosServiciosProductosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProductosServiciosProductosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProductosServiciosProductosLogic productosserviciosproductosDataAccess; 		
	protected ProductosServiciosProductos productosserviciosproductos;
	protected List<ProductosServiciosProductos> productosserviciosproductoss;
	protected Object productosserviciosproductosObject;	
	protected List<Object> productosserviciosproductossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProductosServiciosProductosLogic()throws SQLException,Exception {
		try	{
			this.productosserviciosproductoss= new ArrayList<ProductosServiciosProductos>();
			this.productosserviciosproductos= new ProductosServiciosProductos();
			this.productosserviciosproductosObject=new Object();
			this.productosserviciosproductossObject=new ArrayList<Object>();
			
			this.productosserviciosproductosDataAccess=this;
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
			this.productosserviciosproductosDataAccess.setConnexionType(this.connexionType);
			this.productosserviciosproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.productosserviciosproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductosServiciosProductosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.productosserviciosproductoss= new ArrayList<ProductosServiciosProductos>();
			this.productosserviciosproductos= new ProductosServiciosProductos();
			this.productosserviciosproductosObject=new Object();
			this.productosserviciosproductossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.productosserviciosproductosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.productosserviciosproductosDataAccess.setConnexionType(this.connexionType);
			this.productosserviciosproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.productosserviciosproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductosServiciosProductos getProductosServiciosProductos() throws Exception {	
		ProductosServiciosProductosLogicAdditional.checkProductosServiciosProductosToGet(productosserviciosproductos,this.datosCliente,this.arrDatoGeneral);
		ProductosServiciosProductosLogicAdditional.updateProductosServiciosProductosToGet(productosserviciosproductos,this.arrDatoGeneral);
		
		return productosserviciosproductos;
	}
		
	public void setProductosServiciosProductos(ProductosServiciosProductos newProductosServiciosProductos) {
		this.productosserviciosproductos = newProductosServiciosProductos;
	}
	
	public List<ProductosServiciosProductos> getProductosServiciosProductoss() throws Exception {		
		this.quitarProductosServiciosProductossNulos();
		
		ProductosServiciosProductosLogicAdditional.checkProductosServiciosProductosToGets(productosserviciosproductoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductosServiciosProductos productosserviciosproductosLocal: productosserviciosproductoss ) {
			ProductosServiciosProductosLogicAdditional.updateProductosServiciosProductosToGet(productosserviciosproductosLocal,this.arrDatoGeneral);
		}
		
		return productosserviciosproductoss;
	}
	
	public void setProductosServiciosProductoss(List<ProductosServiciosProductos> newProductosServiciosProductoss) {
		this.productosserviciosproductoss = newProductosServiciosProductoss;
	}
	
	public Object getProductosServiciosProductosObject() {	
		//this.productosserviciosproductosObject=this.productosserviciosproductosDataAccess.getEntityObject();
		return this.productosserviciosproductosObject;
	}
		
	public void setProductosServiciosProductosObject(Object newProductosServiciosProductosObject) {
		this.productosserviciosproductosObject = newProductosServiciosProductosObject;
	}
	
	public List<Object> getProductosServiciosProductossObject() {		
		//this.productosserviciosproductossObject=this.productosserviciosproductosDataAccess.getEntitiesObject();
		return this.productosserviciosproductossObject;
	}
		
	public void setProductosServiciosProductossObject(List<Object> newProductosServiciosProductossObject) {
		this.productosserviciosproductossObject = newProductosServiciosProductossObject;
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
		productosserviciosproductoss = new  ArrayList<ProductosServiciosProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		productosserviciosproductoss = new  ArrayList<ProductosServiciosProductos>();
		  		  
        try {
			//ProductosServiciosProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productosserviciosproductoss = new  ArrayList<ProductosServiciosProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productosserviciosproductoss = new  ArrayList<ProductosServiciosProductos>();
		  		  
        try {
			//ProductosServiciosProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		productosserviciosproductoss = new  ArrayList<ProductosServiciosProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productosserviciosproductoss = new  ArrayList<ProductosServiciosProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProductosServiciosProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProductosServiciosProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosProductos> entities = new  ArrayList<ProductosServiciosProductos>();
		ProductosServiciosProductos entity = new ProductosServiciosProductos();		  
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
	
	public  List<ProductosServiciosProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosProductos> entities = new  ArrayList<ProductosServiciosProductos>();
		ProductosServiciosProductos entity = new ProductosServiciosProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosServiciosProductos();
				
				
      	    	entity=ProductosServiciosProductosLogic.getEntityProductosServiciosProductos("",entity,resultSet);
      	    	
				//entity.setProductosServiciosProductosOriginal( new ProductosServiciosProductos());
      	    	//entity.setProductosServiciosProductosOriginal(super.getEntity("",entity.getProductosServiciosProductosOriginal(),resultSet,ProductosServiciosProductosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductosServiciosProductosOriginal(ProductosServiciosProductosDataAccess.getEntityProductosServiciosProductos("",entity.getProductosServiciosProductosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProductosServiciosProductos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosProductos> entities = new  ArrayList<ProductosServiciosProductos>();
		ProductosServiciosProductos entity = new ProductosServiciosProductos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProductosServiciosProductos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosServiciosProductos>((List<ProductosServiciosProductos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosServiciosProductossOriginal(entities);
			
			}  else {
				this.productosserviciosproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosServiciosProductosConstantesFunciones.quitarEspaciosProductosServiciosProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProductosServiciosProductos getEntityProductosServiciosProductos(String strPrefijo,ProductosServiciosProductos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.NOMBRESUCURSAL));
			entity.setnombre_linea(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.NOMBRELINEA));
			entity.setnombre_linea_grupo(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.NOMBRELINEAGRUPO));
			entity.setnombre_linea_categoria(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.NOMBRELINEACATEGORIA));
			entity.setnombre_linea_marca(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.NOMBRELINEAMARCA));
			entity.setcodigo(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.NOMBRE));
			entity.setnombre_tipo_producto_servicio(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ProductosServiciosProductosConstantesFunciones.NOMBREUNIDAD));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductosServiciosProductos getEntityProductosServiciosProductos(String strPrefijo,ProductosServiciosProductos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProductosServiciosProductos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProductosServiciosProductos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProductosServiciosProductosLogic.setFieldReflectionProductosServiciosProductos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductosServiciosProductos(Field field,String strPrefijo,String sColumn,ProductosServiciosProductos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductosServiciosProductosConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosProductosConstantesFunciones.NOMBRELINEA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosProductosConstantesFunciones.NOMBRELINEAGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosProductosConstantesFunciones.NOMBRELINEACATEGORIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosProductosConstantesFunciones.NOMBRELINEAMARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosProductosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosProductosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosProductosConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosProductosConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosProductosConstantesFunciones.NOMBREUNIDAD:
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
	
	public void quitarProductosServiciosProductossNulos() throws Exception {				
		
		List<ProductosServiciosProductos> productosserviciosproductossAux= new ArrayList<ProductosServiciosProductos>();
		
		for(ProductosServiciosProductos productosserviciosproductos:productosserviciosproductoss) {
			if(productosserviciosproductos!=null) {
				productosserviciosproductossAux.add(productosserviciosproductos);
			}
		}
		
		productosserviciosproductoss=productosserviciosproductossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductosServiciosProductos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosProductos> entities = new  ArrayList<ProductosServiciosProductos>();
		ProductosServiciosProductos entity = new ProductosServiciosProductos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosServiciosProductos>((List<ProductosServiciosProductos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosServiciosProductossOriginal(entities);
			
			}  else {
				this.productosserviciosproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosServiciosProductosConstantesFunciones.quitarEspaciosProductosServiciosProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		productosserviciosproductoss = new  ArrayList<ProductosServiciosProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		productosserviciosproductoss = new  ArrayList<ProductosServiciosProductos>();
		  		  
        try {
			//ProductosServiciosProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProductosServiciosProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosServiciosProductos> entities = new  ArrayList<ProductosServiciosProductos>();
		ProductosServiciosProductos entity = new ProductosServiciosProductos();		  
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
	
	public  List<ProductosServiciosProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosServiciosProductos> entities = new  ArrayList<ProductosServiciosProductos>();
		ProductosServiciosProductos entity = new ProductosServiciosProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosServiciosProductos();
				
				if(conMapGenerico) {
					entity.setMapProductosServiciosProductos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProductosServiciosProductos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductosServiciosProductosDataAccess.ISWITHSCHEMA);         		
					entity=ProductosServiciosProductosLogic.getEntityProductosServiciosProductos("",entity,resultSet,listColumns);
					
					////entity.setProductosServiciosProductosOriginal( new ProductosServiciosProductos());
					////entity.setProductosServiciosProductosOriginal(super.getEntity("",entity.getProductosServiciosProductosOriginal(),resultSet,ProductosServiciosProductosDataAccess.ISWITHSCHEMA));         		
					////entity.setProductosServiciosProductosOriginal(ProductosServiciosProductosDataAccess.getEntityProductosServiciosProductos("",entity.getProductosServiciosProductosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ProductosServiciosProductos relproductosserviciosproductos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relproductosserviciosproductos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProductosServiciosProductos relproductosserviciosproductos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relproductosserviciosproductos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,ProductosServiciosProductos relproductosserviciosproductos)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relproductosserviciosproductos.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Linea getLinea(Connexion connexion,ProductosServiciosProductos relproductosserviciosproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosproductos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProductosServiciosProductos relproductosserviciosproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosproductos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProductosServiciosProductos relproductosserviciosproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosproductos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProductosServiciosProductos relproductosserviciosproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosproductos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public TipoProductoServicio getTipoProductoServicio(Connexion connexion,ProductosServiciosProductos relproductosserviciosproductos)throws SQLException,Exception {

		TipoProductoServicio tipoproductoservicio= new TipoProductoServicio();

		try {
			TipoProductoServicioDataAccess tipoproductoservicioDataAccess=new TipoProductoServicioDataAccess();

			tipoproductoservicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);
			tipoproductoservicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,relproductosserviciosproductos.getid_tipo_producto_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicio;

	}


	
	
	public void getProductosServiciosProductossBusquedaProductosServiciosProductosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio)throws Exception {
		try {
			//ProductosServiciosProductosLogic productosserviciosproductosLogic=new ProductosServiciosProductosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosServiciosProductosLogic.GetSelecSqlProductosServiciosProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productosserviciosproductoss=this.getProductosServiciosProductoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProductosServiciosProductossBusquedaProductosServiciosProductos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio)throws Exception {
		try {
			//ProductosServiciosProductosLogic productosserviciosproductosLogic=new ProductosServiciosProductosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosServiciosProductosLogic.GetSelecSqlProductosServiciosProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productosserviciosproductoss=this.getProductosServiciosProductoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProductosServiciosProductos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProductosServiciosProductos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" p.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" p.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_bodega!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_bodega = "+id_bodega.toString();
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

				if(id_tipo_producto_servicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_tipo_producto_servicio = "+id_tipo_producto_servicio.toString();
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
	
	
	public void deepLoad(ProductosServiciosProductos productosserviciosproductos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductosServiciosProductosLogicAdditional.updateProductosServiciosProductosToGet(productosserviciosproductos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productosserviciosproductos.setEmpresa(productosserviciosproductosDataAccess.getEmpresa(connexion,productosserviciosproductos));
		productosserviciosproductos.setSucursal(productosserviciosproductosDataAccess.getSucursal(connexion,productosserviciosproductos));
		productosserviciosproductos.setBodega(productosserviciosproductosDataAccess.getBodega(connexion,productosserviciosproductos));
		productosserviciosproductos.setLinea(productosserviciosproductosDataAccess.getLinea(connexion,productosserviciosproductos));
		productosserviciosproductos.setLineaGrupo(productosserviciosproductosDataAccess.getLineaGrupo(connexion,productosserviciosproductos));
		productosserviciosproductos.setLineaCategoria(productosserviciosproductosDataAccess.getLineaCategoria(connexion,productosserviciosproductos));
		productosserviciosproductos.setLineaMarca(productosserviciosproductosDataAccess.getLineaMarca(connexion,productosserviciosproductos));
		productosserviciosproductos.setTipoProductoServicio(productosserviciosproductosDataAccess.getTipoProductoServicio(connexion,productosserviciosproductos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productosserviciosproductos.setEmpresa(productosserviciosproductosDataAccess.getEmpresa(connexion,productosserviciosproductos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				productosserviciosproductos.setSucursal(productosserviciosproductosDataAccess.getSucursal(connexion,productosserviciosproductos));
			}

			if(clas.clas.equals(Bodega.class)) {
				productosserviciosproductos.setBodega(productosserviciosproductosDataAccess.getBodega(connexion,productosserviciosproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosproductos.setLinea(productosserviciosproductosDataAccess.getLinea(connexion,productosserviciosproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosproductos.setLineaGrupo(productosserviciosproductosDataAccess.getLineaGrupo(connexion,productosserviciosproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosproductos.setLineaCategoria(productosserviciosproductosDataAccess.getLineaCategoria(connexion,productosserviciosproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosproductos.setLineaMarca(productosserviciosproductosDataAccess.getLineaMarca(connexion,productosserviciosproductos));
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				productosserviciosproductos.setTipoProductoServicio(productosserviciosproductosDataAccess.getTipoProductoServicio(connexion,productosserviciosproductos));
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
			productosserviciosproductos.setEmpresa(productosserviciosproductosDataAccess.getEmpresa(connexion,productosserviciosproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setSucursal(productosserviciosproductosDataAccess.getSucursal(connexion,productosserviciosproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setBodega(productosserviciosproductosDataAccess.getBodega(connexion,productosserviciosproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setLinea(productosserviciosproductosDataAccess.getLinea(connexion,productosserviciosproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setLineaGrupo(productosserviciosproductosDataAccess.getLineaGrupo(connexion,productosserviciosproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setLineaCategoria(productosserviciosproductosDataAccess.getLineaCategoria(connexion,productosserviciosproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setLineaMarca(productosserviciosproductosDataAccess.getLineaMarca(connexion,productosserviciosproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setTipoProductoServicio(productosserviciosproductosDataAccess.getTipoProductoServicio(connexion,productosserviciosproductos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productosserviciosproductos.setEmpresa(productosserviciosproductosDataAccess.getEmpresa(connexion,productosserviciosproductos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productosserviciosproductos.getEmpresa(),isDeep,deepLoadType,clases);
				
		productosserviciosproductos.setSucursal(productosserviciosproductosDataAccess.getSucursal(connexion,productosserviciosproductos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productosserviciosproductos.getSucursal(),isDeep,deepLoadType,clases);
				
		productosserviciosproductos.setBodega(productosserviciosproductosDataAccess.getBodega(connexion,productosserviciosproductos));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productosserviciosproductos.getBodega(),isDeep,deepLoadType,clases);
				
		productosserviciosproductos.setLinea(productosserviciosproductosDataAccess.getLinea(connexion,productosserviciosproductos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(productosserviciosproductos.getLinea(),isDeep,deepLoadType,clases);
				
		productosserviciosproductos.setLineaGrupo(productosserviciosproductosDataAccess.getLineaGrupo(connexion,productosserviciosproductos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(productosserviciosproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		productosserviciosproductos.setLineaCategoria(productosserviciosproductosDataAccess.getLineaCategoria(connexion,productosserviciosproductos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(productosserviciosproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		productosserviciosproductos.setLineaMarca(productosserviciosproductosDataAccess.getLineaMarca(connexion,productosserviciosproductos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(productosserviciosproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
		productosserviciosproductos.setTipoProductoServicio(productosserviciosproductosDataAccess.getTipoProductoServicio(connexion,productosserviciosproductos));
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(productosserviciosproductos.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productosserviciosproductos.setEmpresa(productosserviciosproductosDataAccess.getEmpresa(connexion,productosserviciosproductos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productosserviciosproductos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				productosserviciosproductos.setSucursal(productosserviciosproductosDataAccess.getSucursal(connexion,productosserviciosproductos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productosserviciosproductos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Bodega.class)) {
				productosserviciosproductos.setBodega(productosserviciosproductosDataAccess.getBodega(connexion,productosserviciosproductos));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productosserviciosproductos.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosproductos.setLinea(productosserviciosproductosDataAccess.getLinea(connexion,productosserviciosproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosproductos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosproductos.setLineaGrupo(productosserviciosproductosDataAccess.getLineaGrupo(connexion,productosserviciosproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosproductos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosproductos.setLineaCategoria(productosserviciosproductosDataAccess.getLineaCategoria(connexion,productosserviciosproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosproductos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosproductos.setLineaMarca(productosserviciosproductosDataAccess.getLineaMarca(connexion,productosserviciosproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosproductos.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				productosserviciosproductos.setTipoProductoServicio(productosserviciosproductosDataAccess.getTipoProductoServicio(connexion,productosserviciosproductos));
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepLoad(productosserviciosproductos.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
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
			productosserviciosproductos.setEmpresa(productosserviciosproductosDataAccess.getEmpresa(connexion,productosserviciosproductos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productosserviciosproductos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setSucursal(productosserviciosproductosDataAccess.getSucursal(connexion,productosserviciosproductos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productosserviciosproductos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setBodega(productosserviciosproductosDataAccess.getBodega(connexion,productosserviciosproductos));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productosserviciosproductos.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setLinea(productosserviciosproductosDataAccess.getLinea(connexion,productosserviciosproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosproductos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setLineaGrupo(productosserviciosproductosDataAccess.getLineaGrupo(connexion,productosserviciosproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setLineaCategoria(productosserviciosproductosDataAccess.getLineaCategoria(connexion,productosserviciosproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setLineaMarca(productosserviciosproductosDataAccess.getLineaMarca(connexion,productosserviciosproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosproductos.setTipoProductoServicio(productosserviciosproductosDataAccess.getTipoProductoServicio(connexion,productosserviciosproductos));
			TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
			tipoproductoservicioLogic.deepLoad(productosserviciosproductos.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(productosserviciosproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosServiciosProductosConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosProductos(productosserviciosproductos);
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
			this.deepLoad(this.productosserviciosproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosServiciosProductosConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosProductos(this.productosserviciosproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(productosserviciosproductoss!=null) {
				for(ProductosServiciosProductos productosserviciosproductos:productosserviciosproductoss) {
					this.deepLoad(productosserviciosproductos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductosServiciosProductosConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosProductos(productosserviciosproductoss);
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
			if(productosserviciosproductoss!=null) {
				for(ProductosServiciosProductos productosserviciosproductos:productosserviciosproductoss) {
					this.deepLoad(productosserviciosproductos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductosServiciosProductosConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosProductos(productosserviciosproductoss);
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
	
	public ProductosServiciosProductosParameterReturnGeneral procesarAccionProductosServiciosProductoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosServiciosProductos> productosserviciosproductoss,ProductosServiciosProductosParameterReturnGeneral productosserviciosproductosParameterGeneral)throws Exception {
		 try {	
			ProductosServiciosProductosParameterReturnGeneral productosserviciosproductosReturnGeneral=new ProductosServiciosProductosParameterReturnGeneral();
	
			ProductosServiciosProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productosserviciosproductoss,productosserviciosproductosParameterGeneral,productosserviciosproductosReturnGeneral);
			
			return productosserviciosproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductosServiciosProductosParameterReturnGeneral procesarAccionProductosServiciosProductossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosServiciosProductos> productosserviciosproductoss,ProductosServiciosProductosParameterReturnGeneral productosserviciosproductosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProductosServiciosProductosParameterReturnGeneral productosserviciosproductosReturnGeneral=new ProductosServiciosProductosParameterReturnGeneral();
	
			ProductosServiciosProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productosserviciosproductoss,productosserviciosproductosParameterGeneral,productosserviciosproductosReturnGeneral);
			
			this.connexion.commit();
			
			return productosserviciosproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

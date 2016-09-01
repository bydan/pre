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
import com.bydan.erp.inventario.util.report.ProductosServiciosDisponiblesParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProductosServiciosDisponiblesParameterGeneral;
import com.bydan.erp.inventario.util.report.ProductosServiciosDisponiblesConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProductosServiciosDisponibles;

import com.bydan.erp.inventario.business.logic.report.ProductosServiciosDisponiblesLogicAdditional;
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
public class ProductosServiciosDisponiblesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProductosServiciosDisponiblesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProductosServiciosDisponiblesLogic productosserviciosdisponiblesDataAccess; 		
	protected ProductosServiciosDisponibles productosserviciosdisponibles;
	protected List<ProductosServiciosDisponibles> productosserviciosdisponibless;
	protected Object productosserviciosdisponiblesObject;	
	protected List<Object> productosserviciosdisponiblessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProductosServiciosDisponiblesLogic()throws SQLException,Exception {
		try	{
			this.productosserviciosdisponibless= new ArrayList<ProductosServiciosDisponibles>();
			this.productosserviciosdisponibles= new ProductosServiciosDisponibles();
			this.productosserviciosdisponiblesObject=new Object();
			this.productosserviciosdisponiblessObject=new ArrayList<Object>();
			
			this.productosserviciosdisponiblesDataAccess=this;
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
			this.productosserviciosdisponiblesDataAccess.setConnexionType(this.connexionType);
			this.productosserviciosdisponiblesDataAccess.setParameterDbType(this.parameterDbType);
			this.productosserviciosdisponiblesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductosServiciosDisponiblesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.productosserviciosdisponibless= new ArrayList<ProductosServiciosDisponibles>();
			this.productosserviciosdisponibles= new ProductosServiciosDisponibles();
			this.productosserviciosdisponiblesObject=new Object();
			this.productosserviciosdisponiblessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.productosserviciosdisponiblesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.productosserviciosdisponiblesDataAccess.setConnexionType(this.connexionType);
			this.productosserviciosdisponiblesDataAccess.setParameterDbType(this.parameterDbType);
			this.productosserviciosdisponiblesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductosServiciosDisponibles getProductosServiciosDisponibles() throws Exception {	
		ProductosServiciosDisponiblesLogicAdditional.checkProductosServiciosDisponiblesToGet(productosserviciosdisponibles,this.datosCliente,this.arrDatoGeneral);
		ProductosServiciosDisponiblesLogicAdditional.updateProductosServiciosDisponiblesToGet(productosserviciosdisponibles,this.arrDatoGeneral);
		
		return productosserviciosdisponibles;
	}
		
	public void setProductosServiciosDisponibles(ProductosServiciosDisponibles newProductosServiciosDisponibles) {
		this.productosserviciosdisponibles = newProductosServiciosDisponibles;
	}
	
	public List<ProductosServiciosDisponibles> getProductosServiciosDisponibless() throws Exception {		
		this.quitarProductosServiciosDisponiblessNulos();
		
		ProductosServiciosDisponiblesLogicAdditional.checkProductosServiciosDisponiblesToGets(productosserviciosdisponibless,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductosServiciosDisponibles productosserviciosdisponiblesLocal: productosserviciosdisponibless ) {
			ProductosServiciosDisponiblesLogicAdditional.updateProductosServiciosDisponiblesToGet(productosserviciosdisponiblesLocal,this.arrDatoGeneral);
		}
		
		return productosserviciosdisponibless;
	}
	
	public void setProductosServiciosDisponibless(List<ProductosServiciosDisponibles> newProductosServiciosDisponibless) {
		this.productosserviciosdisponibless = newProductosServiciosDisponibless;
	}
	
	public Object getProductosServiciosDisponiblesObject() {	
		//this.productosserviciosdisponiblesObject=this.productosserviciosdisponiblesDataAccess.getEntityObject();
		return this.productosserviciosdisponiblesObject;
	}
		
	public void setProductosServiciosDisponiblesObject(Object newProductosServiciosDisponiblesObject) {
		this.productosserviciosdisponiblesObject = newProductosServiciosDisponiblesObject;
	}
	
	public List<Object> getProductosServiciosDisponiblessObject() {		
		//this.productosserviciosdisponiblessObject=this.productosserviciosdisponiblesDataAccess.getEntitiesObject();
		return this.productosserviciosdisponiblessObject;
	}
		
	public void setProductosServiciosDisponiblessObject(List<Object> newProductosServiciosDisponiblessObject) {
		this.productosserviciosdisponiblessObject = newProductosServiciosDisponiblessObject;
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
		productosserviciosdisponibless = new  ArrayList<ProductosServiciosDisponibles>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		productosserviciosdisponibless = new  ArrayList<ProductosServiciosDisponibles>();
		  		  
        try {
			//ProductosServiciosDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productosserviciosdisponibless = new  ArrayList<ProductosServiciosDisponibles>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productosserviciosdisponibless = new  ArrayList<ProductosServiciosDisponibles>();
		  		  
        try {
			//ProductosServiciosDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		productosserviciosdisponibless = new  ArrayList<ProductosServiciosDisponibles>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productosserviciosdisponibless = new  ArrayList<ProductosServiciosDisponibles>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProductosServiciosDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProductosServiciosDisponibles> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosDisponibles> entities = new  ArrayList<ProductosServiciosDisponibles>();
		ProductosServiciosDisponibles entity = new ProductosServiciosDisponibles();		  
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
	
	public  List<ProductosServiciosDisponibles> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosDisponibles> entities = new  ArrayList<ProductosServiciosDisponibles>();
		ProductosServiciosDisponibles entity = new ProductosServiciosDisponibles();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosServiciosDisponibles();
				
				
      	    	entity=ProductosServiciosDisponiblesLogic.getEntityProductosServiciosDisponibles("",entity,resultSet);
      	    	
				//entity.setProductosServiciosDisponiblesOriginal( new ProductosServiciosDisponibles());
      	    	//entity.setProductosServiciosDisponiblesOriginal(super.getEntity("",entity.getProductosServiciosDisponiblesOriginal(),resultSet,ProductosServiciosDisponiblesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductosServiciosDisponiblesOriginal(ProductosServiciosDisponiblesDataAccess.getEntityProductosServiciosDisponibles("",entity.getProductosServiciosDisponiblesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProductosServiciosDisponibles> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosDisponibles> entities = new  ArrayList<ProductosServiciosDisponibles>();
		ProductosServiciosDisponibles entity = new ProductosServiciosDisponibles();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProductosServiciosDisponibles.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosServiciosDisponibles>((List<ProductosServiciosDisponibles>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosServiciosDisponiblessOriginal(entities);
			
			}  else {
				this.productosserviciosdisponiblessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosServiciosDisponiblesConstantesFunciones.quitarEspaciosProductosServiciosDisponibless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProductosServiciosDisponibles getEntityProductosServiciosDisponibles(String strPrefijo,ProductosServiciosDisponibles entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.NOMBRESUCURSAL));
			entity.setnombre_linea(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEA));
			entity.setnombre_linea_grupo(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAGRUPO));
			entity.setnombre_linea_categoria(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEACATEGORIA));
			entity.setnombre_linea_marca(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAMARCA));
			entity.setcodigo(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.NOMBRE));
			entity.setnombre_tipo_producto_servicio(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad_disponible(resultSet.getInt(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.CANTIDADDISPONIBLE));
			entity.setcantidad_maximo(resultSet.getInt(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMAXIMO));
			entity.setcantidad_minimo(resultSet.getInt(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMINIMO));
			entity.setprecio_compra(resultSet.getDouble(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA));
			entity.setprecio_venta(resultSet.getDouble(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA));
			entity.setcosto_ultimo(resultSet.getDouble(strPrefijo+ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductosServiciosDisponibles getEntityProductosServiciosDisponibles(String strPrefijo,ProductosServiciosDisponibles entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProductosServiciosDisponibles.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProductosServiciosDisponibles.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProductosServiciosDisponiblesLogic.setFieldReflectionProductosServiciosDisponibles(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductosServiciosDisponibles(Field field,String strPrefijo,String sColumn,ProductosServiciosDisponibles entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductosServiciosDisponiblesConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEACATEGORIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAMARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.CANTIDADDISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMAXIMO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMINIMO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO:
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
	
	public void quitarProductosServiciosDisponiblessNulos() throws Exception {				
		
		List<ProductosServiciosDisponibles> productosserviciosdisponiblessAux= new ArrayList<ProductosServiciosDisponibles>();
		
		for(ProductosServiciosDisponibles productosserviciosdisponibles:productosserviciosdisponibless) {
			if(productosserviciosdisponibles!=null) {
				productosserviciosdisponiblessAux.add(productosserviciosdisponibles);
			}
		}
		
		productosserviciosdisponibless=productosserviciosdisponiblessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductosServiciosDisponibles> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosDisponibles> entities = new  ArrayList<ProductosServiciosDisponibles>();
		ProductosServiciosDisponibles entity = new ProductosServiciosDisponibles();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosServiciosDisponibles>((List<ProductosServiciosDisponibles>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosServiciosDisponiblessOriginal(entities);
			
			}  else {
				this.productosserviciosdisponiblessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosServiciosDisponiblesConstantesFunciones.quitarEspaciosProductosServiciosDisponibless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		productosserviciosdisponibless = new  ArrayList<ProductosServiciosDisponibles>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		productosserviciosdisponibless = new  ArrayList<ProductosServiciosDisponibles>();
		  		  
        try {
			//ProductosServiciosDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProductosServiciosDisponibles> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosServiciosDisponibles> entities = new  ArrayList<ProductosServiciosDisponibles>();
		ProductosServiciosDisponibles entity = new ProductosServiciosDisponibles();		  
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
	
	public  List<ProductosServiciosDisponibles> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosServiciosDisponibles> entities = new  ArrayList<ProductosServiciosDisponibles>();
		ProductosServiciosDisponibles entity = new ProductosServiciosDisponibles();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosServiciosDisponibles();
				
				if(conMapGenerico) {
					entity.setMapProductosServiciosDisponibles( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProductosServiciosDisponibles().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductosServiciosDisponiblesDataAccess.ISWITHSCHEMA);         		
					entity=ProductosServiciosDisponiblesLogic.getEntityProductosServiciosDisponibles("",entity,resultSet,listColumns);
					
					////entity.setProductosServiciosDisponiblesOriginal( new ProductosServiciosDisponibles());
					////entity.setProductosServiciosDisponiblesOriginal(super.getEntity("",entity.getProductosServiciosDisponiblesOriginal(),resultSet,ProductosServiciosDisponiblesDataAccess.ISWITHSCHEMA));         		
					////entity.setProductosServiciosDisponiblesOriginal(ProductosServiciosDisponiblesDataAccess.getEntityProductosServiciosDisponibles("",entity.getProductosServiciosDisponiblesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ProductosServiciosDisponibles relproductosserviciosdisponibles)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relproductosserviciosdisponibles.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProductosServiciosDisponibles relproductosserviciosdisponibles)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relproductosserviciosdisponibles.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,ProductosServiciosDisponibles relproductosserviciosdisponibles)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relproductosserviciosdisponibles.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Linea getLinea(Connexion connexion,ProductosServiciosDisponibles relproductosserviciosdisponibles)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosdisponibles.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProductosServiciosDisponibles relproductosserviciosdisponibles)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosdisponibles.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProductosServiciosDisponibles relproductosserviciosdisponibles)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosdisponibles.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProductosServiciosDisponibles relproductosserviciosdisponibles)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosdisponibles.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public TipoProductoServicio getTipoProductoServicio(Connexion connexion,ProductosServiciosDisponibles relproductosserviciosdisponibles)throws SQLException,Exception {

		TipoProductoServicio tipoproductoservicio= new TipoProductoServicio();

		try {
			TipoProductoServicioDataAccess tipoproductoservicioDataAccess=new TipoProductoServicioDataAccess();

			tipoproductoservicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);
			tipoproductoservicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,relproductosserviciosdisponibles.getid_tipo_producto_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicio;

	}


	
	
	public void getProductosServiciosDisponiblessBusquedaProductosServiciosDisponiblesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio)throws Exception {
		try {
			//ProductosServiciosDisponiblesLogic productosserviciosdisponiblesLogic=new ProductosServiciosDisponiblesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosServiciosDisponiblesLogic.GetSelecSqlProductosServiciosDisponibles(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productosserviciosdisponibless=this.getProductosServiciosDisponibless();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProductosServiciosDisponiblessBusquedaProductosServiciosDisponibles(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio)throws Exception {
		try {
			//ProductosServiciosDisponiblesLogic productosserviciosdisponiblesLogic=new ProductosServiciosDisponiblesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosServiciosDisponiblesLogic.GetSelecSqlProductosServiciosDisponibles(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productosserviciosdisponibless=this.getProductosServiciosDisponibless();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProductosServiciosDisponibles(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProductosServiciosDisponibles_Postgres.sql");
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
	
	
	public void deepLoad(ProductosServiciosDisponibles productosserviciosdisponibles,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductosServiciosDisponiblesLogicAdditional.updateProductosServiciosDisponiblesToGet(productosserviciosdisponibles,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productosserviciosdisponibles.setEmpresa(productosserviciosdisponiblesDataAccess.getEmpresa(connexion,productosserviciosdisponibles));
		productosserviciosdisponibles.setSucursal(productosserviciosdisponiblesDataAccess.getSucursal(connexion,productosserviciosdisponibles));
		productosserviciosdisponibles.setBodega(productosserviciosdisponiblesDataAccess.getBodega(connexion,productosserviciosdisponibles));
		productosserviciosdisponibles.setLinea(productosserviciosdisponiblesDataAccess.getLinea(connexion,productosserviciosdisponibles));
		productosserviciosdisponibles.setLineaGrupo(productosserviciosdisponiblesDataAccess.getLineaGrupo(connexion,productosserviciosdisponibles));
		productosserviciosdisponibles.setLineaCategoria(productosserviciosdisponiblesDataAccess.getLineaCategoria(connexion,productosserviciosdisponibles));
		productosserviciosdisponibles.setLineaMarca(productosserviciosdisponiblesDataAccess.getLineaMarca(connexion,productosserviciosdisponibles));
		productosserviciosdisponibles.setTipoProductoServicio(productosserviciosdisponiblesDataAccess.getTipoProductoServicio(connexion,productosserviciosdisponibles));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productosserviciosdisponibles.setEmpresa(productosserviciosdisponiblesDataAccess.getEmpresa(connexion,productosserviciosdisponibles));
			}

			if(clas.clas.equals(Sucursal.class)) {
				productosserviciosdisponibles.setSucursal(productosserviciosdisponiblesDataAccess.getSucursal(connexion,productosserviciosdisponibles));
			}

			if(clas.clas.equals(Bodega.class)) {
				productosserviciosdisponibles.setBodega(productosserviciosdisponiblesDataAccess.getBodega(connexion,productosserviciosdisponibles));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosdisponibles.setLinea(productosserviciosdisponiblesDataAccess.getLinea(connexion,productosserviciosdisponibles));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosdisponibles.setLineaGrupo(productosserviciosdisponiblesDataAccess.getLineaGrupo(connexion,productosserviciosdisponibles));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosdisponibles.setLineaCategoria(productosserviciosdisponiblesDataAccess.getLineaCategoria(connexion,productosserviciosdisponibles));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosdisponibles.setLineaMarca(productosserviciosdisponiblesDataAccess.getLineaMarca(connexion,productosserviciosdisponibles));
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				productosserviciosdisponibles.setTipoProductoServicio(productosserviciosdisponiblesDataAccess.getTipoProductoServicio(connexion,productosserviciosdisponibles));
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
			productosserviciosdisponibles.setEmpresa(productosserviciosdisponiblesDataAccess.getEmpresa(connexion,productosserviciosdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setSucursal(productosserviciosdisponiblesDataAccess.getSucursal(connexion,productosserviciosdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setBodega(productosserviciosdisponiblesDataAccess.getBodega(connexion,productosserviciosdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setLinea(productosserviciosdisponiblesDataAccess.getLinea(connexion,productosserviciosdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setLineaGrupo(productosserviciosdisponiblesDataAccess.getLineaGrupo(connexion,productosserviciosdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setLineaCategoria(productosserviciosdisponiblesDataAccess.getLineaCategoria(connexion,productosserviciosdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setLineaMarca(productosserviciosdisponiblesDataAccess.getLineaMarca(connexion,productosserviciosdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setTipoProductoServicio(productosserviciosdisponiblesDataAccess.getTipoProductoServicio(connexion,productosserviciosdisponibles));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productosserviciosdisponibles.setEmpresa(productosserviciosdisponiblesDataAccess.getEmpresa(connexion,productosserviciosdisponibles));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productosserviciosdisponibles.getEmpresa(),isDeep,deepLoadType,clases);
				
		productosserviciosdisponibles.setSucursal(productosserviciosdisponiblesDataAccess.getSucursal(connexion,productosserviciosdisponibles));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productosserviciosdisponibles.getSucursal(),isDeep,deepLoadType,clases);
				
		productosserviciosdisponibles.setBodega(productosserviciosdisponiblesDataAccess.getBodega(connexion,productosserviciosdisponibles));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productosserviciosdisponibles.getBodega(),isDeep,deepLoadType,clases);
				
		productosserviciosdisponibles.setLinea(productosserviciosdisponiblesDataAccess.getLinea(connexion,productosserviciosdisponibles));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(productosserviciosdisponibles.getLinea(),isDeep,deepLoadType,clases);
				
		productosserviciosdisponibles.setLineaGrupo(productosserviciosdisponiblesDataAccess.getLineaGrupo(connexion,productosserviciosdisponibles));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(productosserviciosdisponibles.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		productosserviciosdisponibles.setLineaCategoria(productosserviciosdisponiblesDataAccess.getLineaCategoria(connexion,productosserviciosdisponibles));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(productosserviciosdisponibles.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		productosserviciosdisponibles.setLineaMarca(productosserviciosdisponiblesDataAccess.getLineaMarca(connexion,productosserviciosdisponibles));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(productosserviciosdisponibles.getLineaMarca(),isDeep,deepLoadType,clases);
				
		productosserviciosdisponibles.setTipoProductoServicio(productosserviciosdisponiblesDataAccess.getTipoProductoServicio(connexion,productosserviciosdisponibles));
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(productosserviciosdisponibles.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productosserviciosdisponibles.setEmpresa(productosserviciosdisponiblesDataAccess.getEmpresa(connexion,productosserviciosdisponibles));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productosserviciosdisponibles.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				productosserviciosdisponibles.setSucursal(productosserviciosdisponiblesDataAccess.getSucursal(connexion,productosserviciosdisponibles));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productosserviciosdisponibles.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Bodega.class)) {
				productosserviciosdisponibles.setBodega(productosserviciosdisponiblesDataAccess.getBodega(connexion,productosserviciosdisponibles));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productosserviciosdisponibles.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosdisponibles.setLinea(productosserviciosdisponiblesDataAccess.getLinea(connexion,productosserviciosdisponibles));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosdisponibles.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosdisponibles.setLineaGrupo(productosserviciosdisponiblesDataAccess.getLineaGrupo(connexion,productosserviciosdisponibles));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosdisponibles.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosdisponibles.setLineaCategoria(productosserviciosdisponiblesDataAccess.getLineaCategoria(connexion,productosserviciosdisponibles));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosdisponibles.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosdisponibles.setLineaMarca(productosserviciosdisponiblesDataAccess.getLineaMarca(connexion,productosserviciosdisponibles));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosdisponibles.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				productosserviciosdisponibles.setTipoProductoServicio(productosserviciosdisponiblesDataAccess.getTipoProductoServicio(connexion,productosserviciosdisponibles));
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepLoad(productosserviciosdisponibles.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
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
			productosserviciosdisponibles.setEmpresa(productosserviciosdisponiblesDataAccess.getEmpresa(connexion,productosserviciosdisponibles));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productosserviciosdisponibles.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setSucursal(productosserviciosdisponiblesDataAccess.getSucursal(connexion,productosserviciosdisponibles));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productosserviciosdisponibles.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setBodega(productosserviciosdisponiblesDataAccess.getBodega(connexion,productosserviciosdisponibles));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productosserviciosdisponibles.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setLinea(productosserviciosdisponiblesDataAccess.getLinea(connexion,productosserviciosdisponibles));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosdisponibles.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setLineaGrupo(productosserviciosdisponiblesDataAccess.getLineaGrupo(connexion,productosserviciosdisponibles));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosdisponibles.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setLineaCategoria(productosserviciosdisponiblesDataAccess.getLineaCategoria(connexion,productosserviciosdisponibles));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosdisponibles.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setLineaMarca(productosserviciosdisponiblesDataAccess.getLineaMarca(connexion,productosserviciosdisponibles));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosdisponibles.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosdisponibles.setTipoProductoServicio(productosserviciosdisponiblesDataAccess.getTipoProductoServicio(connexion,productosserviciosdisponibles));
			TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
			tipoproductoservicioLogic.deepLoad(productosserviciosdisponibles.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(productosserviciosdisponibles,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosServiciosDisponiblesConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosDisponibles(productosserviciosdisponibles);
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
			this.deepLoad(this.productosserviciosdisponibles,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosServiciosDisponiblesConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosDisponibles(this.productosserviciosdisponibles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(productosserviciosdisponibless!=null) {
				for(ProductosServiciosDisponibles productosserviciosdisponibles:productosserviciosdisponibless) {
					this.deepLoad(productosserviciosdisponibles,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductosServiciosDisponiblesConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosDisponibles(productosserviciosdisponibless);
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
			if(productosserviciosdisponibless!=null) {
				for(ProductosServiciosDisponibles productosserviciosdisponibles:productosserviciosdisponibless) {
					this.deepLoad(productosserviciosdisponibles,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductosServiciosDisponiblesConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosDisponibles(productosserviciosdisponibless);
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
	
	public ProductosServiciosDisponiblesParameterReturnGeneral procesarAccionProductosServiciosDisponibless(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosServiciosDisponibles> productosserviciosdisponibless,ProductosServiciosDisponiblesParameterReturnGeneral productosserviciosdisponiblesParameterGeneral)throws Exception {
		 try {	
			ProductosServiciosDisponiblesParameterReturnGeneral productosserviciosdisponiblesReturnGeneral=new ProductosServiciosDisponiblesParameterReturnGeneral();
	
			ProductosServiciosDisponiblesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productosserviciosdisponibless,productosserviciosdisponiblesParameterGeneral,productosserviciosdisponiblesReturnGeneral);
			
			return productosserviciosdisponiblesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductosServiciosDisponiblesParameterReturnGeneral procesarAccionProductosServiciosDisponiblessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosServiciosDisponibles> productosserviciosdisponibless,ProductosServiciosDisponiblesParameterReturnGeneral productosserviciosdisponiblesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProductosServiciosDisponiblesParameterReturnGeneral productosserviciosdisponiblesReturnGeneral=new ProductosServiciosDisponiblesParameterReturnGeneral();
	
			ProductosServiciosDisponiblesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productosserviciosdisponibless,productosserviciosdisponiblesParameterGeneral,productosserviciosdisponiblesReturnGeneral);
			
			this.connexion.commit();
			
			return productosserviciosdisponiblesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

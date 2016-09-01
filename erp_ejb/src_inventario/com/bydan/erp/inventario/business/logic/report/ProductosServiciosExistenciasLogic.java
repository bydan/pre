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
import com.bydan.erp.inventario.util.report.ProductosServiciosExistenciasParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProductosServiciosExistenciasParameterGeneral;
import com.bydan.erp.inventario.util.report.ProductosServiciosExistenciasConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProductosServiciosExistencias;

import com.bydan.erp.inventario.business.logic.report.ProductosServiciosExistenciasLogicAdditional;
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
public class ProductosServiciosExistenciasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProductosServiciosExistenciasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProductosServiciosExistenciasLogic productosserviciosexistenciasDataAccess; 		
	protected ProductosServiciosExistencias productosserviciosexistencias;
	protected List<ProductosServiciosExistencias> productosserviciosexistenciass;
	protected Object productosserviciosexistenciasObject;	
	protected List<Object> productosserviciosexistenciassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProductosServiciosExistenciasLogic()throws SQLException,Exception {
		try	{
			this.productosserviciosexistenciass= new ArrayList<ProductosServiciosExistencias>();
			this.productosserviciosexistencias= new ProductosServiciosExistencias();
			this.productosserviciosexistenciasObject=new Object();
			this.productosserviciosexistenciassObject=new ArrayList<Object>();
			
			this.productosserviciosexistenciasDataAccess=this;
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
			this.productosserviciosexistenciasDataAccess.setConnexionType(this.connexionType);
			this.productosserviciosexistenciasDataAccess.setParameterDbType(this.parameterDbType);
			this.productosserviciosexistenciasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductosServiciosExistenciasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.productosserviciosexistenciass= new ArrayList<ProductosServiciosExistencias>();
			this.productosserviciosexistencias= new ProductosServiciosExistencias();
			this.productosserviciosexistenciasObject=new Object();
			this.productosserviciosexistenciassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.productosserviciosexistenciasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.productosserviciosexistenciasDataAccess.setConnexionType(this.connexionType);
			this.productosserviciosexistenciasDataAccess.setParameterDbType(this.parameterDbType);
			this.productosserviciosexistenciasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductosServiciosExistencias getProductosServiciosExistencias() throws Exception {	
		ProductosServiciosExistenciasLogicAdditional.checkProductosServiciosExistenciasToGet(productosserviciosexistencias,this.datosCliente,this.arrDatoGeneral);
		ProductosServiciosExistenciasLogicAdditional.updateProductosServiciosExistenciasToGet(productosserviciosexistencias,this.arrDatoGeneral);
		
		return productosserviciosexistencias;
	}
		
	public void setProductosServiciosExistencias(ProductosServiciosExistencias newProductosServiciosExistencias) {
		this.productosserviciosexistencias = newProductosServiciosExistencias;
	}
	
	public List<ProductosServiciosExistencias> getProductosServiciosExistenciass() throws Exception {		
		this.quitarProductosServiciosExistenciassNulos();
		
		ProductosServiciosExistenciasLogicAdditional.checkProductosServiciosExistenciasToGets(productosserviciosexistenciass,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductosServiciosExistencias productosserviciosexistenciasLocal: productosserviciosexistenciass ) {
			ProductosServiciosExistenciasLogicAdditional.updateProductosServiciosExistenciasToGet(productosserviciosexistenciasLocal,this.arrDatoGeneral);
		}
		
		return productosserviciosexistenciass;
	}
	
	public void setProductosServiciosExistenciass(List<ProductosServiciosExistencias> newProductosServiciosExistenciass) {
		this.productosserviciosexistenciass = newProductosServiciosExistenciass;
	}
	
	public Object getProductosServiciosExistenciasObject() {	
		//this.productosserviciosexistenciasObject=this.productosserviciosexistenciasDataAccess.getEntityObject();
		return this.productosserviciosexistenciasObject;
	}
		
	public void setProductosServiciosExistenciasObject(Object newProductosServiciosExistenciasObject) {
		this.productosserviciosexistenciasObject = newProductosServiciosExistenciasObject;
	}
	
	public List<Object> getProductosServiciosExistenciassObject() {		
		//this.productosserviciosexistenciassObject=this.productosserviciosexistenciasDataAccess.getEntitiesObject();
		return this.productosserviciosexistenciassObject;
	}
		
	public void setProductosServiciosExistenciassObject(List<Object> newProductosServiciosExistenciassObject) {
		this.productosserviciosexistenciassObject = newProductosServiciosExistenciassObject;
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
		productosserviciosexistenciass = new  ArrayList<ProductosServiciosExistencias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosExistenciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosexistenciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		productosserviciosexistenciass = new  ArrayList<ProductosServiciosExistencias>();
		  		  
        try {
			//ProductosServiciosExistenciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosexistenciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productosserviciosexistenciass = new  ArrayList<ProductosServiciosExistencias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosExistenciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosexistenciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productosserviciosexistenciass = new  ArrayList<ProductosServiciosExistencias>();
		  		  
        try {
			//ProductosServiciosExistenciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosexistenciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		productosserviciosexistenciass = new  ArrayList<ProductosServiciosExistencias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosExistenciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosexistenciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productosserviciosexistenciass = new  ArrayList<ProductosServiciosExistencias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProductosServiciosExistenciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosexistenciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProductosServiciosExistencias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosExistencias> entities = new  ArrayList<ProductosServiciosExistencias>();
		ProductosServiciosExistencias entity = new ProductosServiciosExistencias();		  
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
	
	public  List<ProductosServiciosExistencias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosExistencias> entities = new  ArrayList<ProductosServiciosExistencias>();
		ProductosServiciosExistencias entity = new ProductosServiciosExistencias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosServiciosExistencias();
				
				
      	    	entity=ProductosServiciosExistenciasLogic.getEntityProductosServiciosExistencias("",entity,resultSet);
      	    	
				//entity.setProductosServiciosExistenciasOriginal( new ProductosServiciosExistencias());
      	    	//entity.setProductosServiciosExistenciasOriginal(super.getEntity("",entity.getProductosServiciosExistenciasOriginal(),resultSet,ProductosServiciosExistenciasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductosServiciosExistenciasOriginal(ProductosServiciosExistenciasDataAccess.getEntityProductosServiciosExistencias("",entity.getProductosServiciosExistenciasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProductosServiciosExistencias> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosExistencias> entities = new  ArrayList<ProductosServiciosExistencias>();
		ProductosServiciosExistencias entity = new ProductosServiciosExistencias();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProductosServiciosExistencias.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosServiciosExistencias>((List<ProductosServiciosExistencias>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosServiciosExistenciassOriginal(entities);
			
			}  else {
				this.productosserviciosexistenciassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosServiciosExistenciasConstantesFunciones.quitarEspaciosProductosServiciosExistenciass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProductosServiciosExistencias getEntityProductosServiciosExistencias(String strPrefijo,ProductosServiciosExistencias entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.NOMBRESUCURSAL));
			entity.setnombre_linea(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEA));
			entity.setnombre_linea_grupo(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAGRUPO));
			entity.setnombre_linea_categoria(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEACATEGORIA));
			entity.setnombre_linea_marca(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAMARCA));
			entity.setcodigo(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.NOMBRE));
			entity.setnombre_tipo_producto_servicio(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad_disponible(resultSet.getInt(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.CANTIDADDISPONIBLE));
			entity.setcantidad_reservada(resultSet.getDouble(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA));
			entity.setcantidad_pedida(resultSet.getDouble(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA));
			entity.settotal_egreso(resultSet.getDouble(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO));
			entity.settotal_compra(resultSet.getDouble(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA));
			entity.settotal_devuelto(resultSet.getDouble(strPrefijo+ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductosServiciosExistencias getEntityProductosServiciosExistencias(String strPrefijo,ProductosServiciosExistencias entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProductosServiciosExistencias.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProductosServiciosExistencias.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProductosServiciosExistenciasLogic.setFieldReflectionProductosServiciosExistencias(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductosServiciosExistencias(Field field,String strPrefijo,String sColumn,ProductosServiciosExistencias entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductosServiciosExistenciasConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEACATEGORIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAMARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.CANTIDADDISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO:
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
	
	public void quitarProductosServiciosExistenciassNulos() throws Exception {				
		
		List<ProductosServiciosExistencias> productosserviciosexistenciassAux= new ArrayList<ProductosServiciosExistencias>();
		
		for(ProductosServiciosExistencias productosserviciosexistencias:productosserviciosexistenciass) {
			if(productosserviciosexistencias!=null) {
				productosserviciosexistenciassAux.add(productosserviciosexistencias);
			}
		}
		
		productosserviciosexistenciass=productosserviciosexistenciassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductosServiciosExistencias> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosExistencias> entities = new  ArrayList<ProductosServiciosExistencias>();
		ProductosServiciosExistencias entity = new ProductosServiciosExistencias();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosServiciosExistencias>((List<ProductosServiciosExistencias>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosServiciosExistenciassOriginal(entities);
			
			}  else {
				this.productosserviciosexistenciassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosServiciosExistenciasConstantesFunciones.quitarEspaciosProductosServiciosExistenciass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		productosserviciosexistenciass = new  ArrayList<ProductosServiciosExistencias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosExistenciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosexistenciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		productosserviciosexistenciass = new  ArrayList<ProductosServiciosExistencias>();
		  		  
        try {
			//ProductosServiciosExistenciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciosexistenciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProductosServiciosExistencias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosServiciosExistencias> entities = new  ArrayList<ProductosServiciosExistencias>();
		ProductosServiciosExistencias entity = new ProductosServiciosExistencias();		  
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
	
	public  List<ProductosServiciosExistencias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosServiciosExistencias> entities = new  ArrayList<ProductosServiciosExistencias>();
		ProductosServiciosExistencias entity = new ProductosServiciosExistencias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosServiciosExistencias();
				
				if(conMapGenerico) {
					entity.setMapProductosServiciosExistencias( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProductosServiciosExistencias().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductosServiciosExistenciasDataAccess.ISWITHSCHEMA);         		
					entity=ProductosServiciosExistenciasLogic.getEntityProductosServiciosExistencias("",entity,resultSet,listColumns);
					
					////entity.setProductosServiciosExistenciasOriginal( new ProductosServiciosExistencias());
					////entity.setProductosServiciosExistenciasOriginal(super.getEntity("",entity.getProductosServiciosExistenciasOriginal(),resultSet,ProductosServiciosExistenciasDataAccess.ISWITHSCHEMA));         		
					////entity.setProductosServiciosExistenciasOriginal(ProductosServiciosExistenciasDataAccess.getEntityProductosServiciosExistencias("",entity.getProductosServiciosExistenciasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ProductosServiciosExistencias relproductosserviciosexistencias)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relproductosserviciosexistencias.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProductosServiciosExistencias relproductosserviciosexistencias)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relproductosserviciosexistencias.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,ProductosServiciosExistencias relproductosserviciosexistencias)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relproductosserviciosexistencias.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProductosServiciosExistencias relproductosserviciosexistencias)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relproductosserviciosexistencias.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Linea getLinea(Connexion connexion,ProductosServiciosExistencias relproductosserviciosexistencias)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosexistencias.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProductosServiciosExistencias relproductosserviciosexistencias)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosexistencias.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProductosServiciosExistencias relproductosserviciosexistencias)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosexistencias.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProductosServiciosExistencias relproductosserviciosexistencias)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciosexistencias.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public TipoProductoServicio getTipoProductoServicio(Connexion connexion,ProductosServiciosExistencias relproductosserviciosexistencias)throws SQLException,Exception {

		TipoProductoServicio tipoproductoservicio= new TipoProductoServicio();

		try {
			TipoProductoServicioDataAccess tipoproductoservicioDataAccess=new TipoProductoServicioDataAccess();

			tipoproductoservicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);
			tipoproductoservicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,relproductosserviciosexistencias.getid_tipo_producto_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicio;

	}


	
	
	public void getProductosServiciosExistenciassBusquedaProductosServiciosExistenciasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio)throws Exception {
		try {
			//ProductosServiciosExistenciasLogic productosserviciosexistenciasLogic=new ProductosServiciosExistenciasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosServiciosExistenciasLogic.GetSelecSqlProductosServiciosExistencias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productosserviciosexistenciass=this.getProductosServiciosExistenciass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProductosServiciosExistenciassBusquedaProductosServiciosExistencias(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio)throws Exception {
		try {
			//ProductosServiciosExistenciasLogic productosserviciosexistenciasLogic=new ProductosServiciosExistenciasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosServiciosExistenciasLogic.GetSelecSqlProductosServiciosExistencias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productosserviciosexistenciass=this.getProductosServiciosExistenciass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProductosServiciosExistencias(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProductosServiciosExistencias_Postgres.sql");
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
	
	
	public void deepLoad(ProductosServiciosExistencias productosserviciosexistencias,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductosServiciosExistenciasLogicAdditional.updateProductosServiciosExistenciasToGet(productosserviciosexistencias,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productosserviciosexistencias.setEmpresa(productosserviciosexistenciasDataAccess.getEmpresa(connexion,productosserviciosexistencias));
		productosserviciosexistencias.setSucursal(productosserviciosexistenciasDataAccess.getSucursal(connexion,productosserviciosexistencias));
		productosserviciosexistencias.setBodega(productosserviciosexistenciasDataAccess.getBodega(connexion,productosserviciosexistencias));
		productosserviciosexistencias.setProducto(productosserviciosexistenciasDataAccess.getProducto(connexion,productosserviciosexistencias));
		productosserviciosexistencias.setLinea(productosserviciosexistenciasDataAccess.getLinea(connexion,productosserviciosexistencias));
		productosserviciosexistencias.setLineaGrupo(productosserviciosexistenciasDataAccess.getLineaGrupo(connexion,productosserviciosexistencias));
		productosserviciosexistencias.setLineaCategoria(productosserviciosexistenciasDataAccess.getLineaCategoria(connexion,productosserviciosexistencias));
		productosserviciosexistencias.setLineaMarca(productosserviciosexistenciasDataAccess.getLineaMarca(connexion,productosserviciosexistencias));
		productosserviciosexistencias.setTipoProductoServicio(productosserviciosexistenciasDataAccess.getTipoProductoServicio(connexion,productosserviciosexistencias));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productosserviciosexistencias.setEmpresa(productosserviciosexistenciasDataAccess.getEmpresa(connexion,productosserviciosexistencias));
			}

			if(clas.clas.equals(Sucursal.class)) {
				productosserviciosexistencias.setSucursal(productosserviciosexistenciasDataAccess.getSucursal(connexion,productosserviciosexistencias));
			}

			if(clas.clas.equals(Bodega.class)) {
				productosserviciosexistencias.setBodega(productosserviciosexistenciasDataAccess.getBodega(connexion,productosserviciosexistencias));
			}

			if(clas.clas.equals(Producto.class)) {
				productosserviciosexistencias.setProducto(productosserviciosexistenciasDataAccess.getProducto(connexion,productosserviciosexistencias));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosexistencias.setLinea(productosserviciosexistenciasDataAccess.getLinea(connexion,productosserviciosexistencias));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosexistencias.setLineaGrupo(productosserviciosexistenciasDataAccess.getLineaGrupo(connexion,productosserviciosexistencias));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosexistencias.setLineaCategoria(productosserviciosexistenciasDataAccess.getLineaCategoria(connexion,productosserviciosexistencias));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosexistencias.setLineaMarca(productosserviciosexistenciasDataAccess.getLineaMarca(connexion,productosserviciosexistencias));
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				productosserviciosexistencias.setTipoProductoServicio(productosserviciosexistenciasDataAccess.getTipoProductoServicio(connexion,productosserviciosexistencias));
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
			productosserviciosexistencias.setEmpresa(productosserviciosexistenciasDataAccess.getEmpresa(connexion,productosserviciosexistencias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setSucursal(productosserviciosexistenciasDataAccess.getSucursal(connexion,productosserviciosexistencias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setBodega(productosserviciosexistenciasDataAccess.getBodega(connexion,productosserviciosexistencias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setProducto(productosserviciosexistenciasDataAccess.getProducto(connexion,productosserviciosexistencias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setLinea(productosserviciosexistenciasDataAccess.getLinea(connexion,productosserviciosexistencias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setLineaGrupo(productosserviciosexistenciasDataAccess.getLineaGrupo(connexion,productosserviciosexistencias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setLineaCategoria(productosserviciosexistenciasDataAccess.getLineaCategoria(connexion,productosserviciosexistencias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setLineaMarca(productosserviciosexistenciasDataAccess.getLineaMarca(connexion,productosserviciosexistencias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setTipoProductoServicio(productosserviciosexistenciasDataAccess.getTipoProductoServicio(connexion,productosserviciosexistencias));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productosserviciosexistencias.setEmpresa(productosserviciosexistenciasDataAccess.getEmpresa(connexion,productosserviciosexistencias));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productosserviciosexistencias.getEmpresa(),isDeep,deepLoadType,clases);
				
		productosserviciosexistencias.setSucursal(productosserviciosexistenciasDataAccess.getSucursal(connexion,productosserviciosexistencias));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productosserviciosexistencias.getSucursal(),isDeep,deepLoadType,clases);
				
		productosserviciosexistencias.setBodega(productosserviciosexistenciasDataAccess.getBodega(connexion,productosserviciosexistencias));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productosserviciosexistencias.getBodega(),isDeep,deepLoadType,clases);
				
		productosserviciosexistencias.setProducto(productosserviciosexistenciasDataAccess.getProducto(connexion,productosserviciosexistencias));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productosserviciosexistencias.getProducto(),isDeep,deepLoadType,clases);
				
		productosserviciosexistencias.setLinea(productosserviciosexistenciasDataAccess.getLinea(connexion,productosserviciosexistencias));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(productosserviciosexistencias.getLinea(),isDeep,deepLoadType,clases);
				
		productosserviciosexistencias.setLineaGrupo(productosserviciosexistenciasDataAccess.getLineaGrupo(connexion,productosserviciosexistencias));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(productosserviciosexistencias.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		productosserviciosexistencias.setLineaCategoria(productosserviciosexistenciasDataAccess.getLineaCategoria(connexion,productosserviciosexistencias));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(productosserviciosexistencias.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		productosserviciosexistencias.setLineaMarca(productosserviciosexistenciasDataAccess.getLineaMarca(connexion,productosserviciosexistencias));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(productosserviciosexistencias.getLineaMarca(),isDeep,deepLoadType,clases);
				
		productosserviciosexistencias.setTipoProductoServicio(productosserviciosexistenciasDataAccess.getTipoProductoServicio(connexion,productosserviciosexistencias));
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(productosserviciosexistencias.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productosserviciosexistencias.setEmpresa(productosserviciosexistenciasDataAccess.getEmpresa(connexion,productosserviciosexistencias));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productosserviciosexistencias.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				productosserviciosexistencias.setSucursal(productosserviciosexistenciasDataAccess.getSucursal(connexion,productosserviciosexistencias));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productosserviciosexistencias.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Bodega.class)) {
				productosserviciosexistencias.setBodega(productosserviciosexistenciasDataAccess.getBodega(connexion,productosserviciosexistencias));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productosserviciosexistencias.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				productosserviciosexistencias.setProducto(productosserviciosexistenciasDataAccess.getProducto(connexion,productosserviciosexistencias));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productosserviciosexistencias.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosexistencias.setLinea(productosserviciosexistenciasDataAccess.getLinea(connexion,productosserviciosexistencias));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosexistencias.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosexistencias.setLineaGrupo(productosserviciosexistenciasDataAccess.getLineaGrupo(connexion,productosserviciosexistencias));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosexistencias.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosexistencias.setLineaCategoria(productosserviciosexistenciasDataAccess.getLineaCategoria(connexion,productosserviciosexistencias));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosexistencias.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciosexistencias.setLineaMarca(productosserviciosexistenciasDataAccess.getLineaMarca(connexion,productosserviciosexistencias));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciosexistencias.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				productosserviciosexistencias.setTipoProductoServicio(productosserviciosexistenciasDataAccess.getTipoProductoServicio(connexion,productosserviciosexistencias));
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepLoad(productosserviciosexistencias.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
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
			productosserviciosexistencias.setEmpresa(productosserviciosexistenciasDataAccess.getEmpresa(connexion,productosserviciosexistencias));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productosserviciosexistencias.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setSucursal(productosserviciosexistenciasDataAccess.getSucursal(connexion,productosserviciosexistencias));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productosserviciosexistencias.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setBodega(productosserviciosexistenciasDataAccess.getBodega(connexion,productosserviciosexistencias));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productosserviciosexistencias.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setProducto(productosserviciosexistenciasDataAccess.getProducto(connexion,productosserviciosexistencias));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productosserviciosexistencias.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setLinea(productosserviciosexistenciasDataAccess.getLinea(connexion,productosserviciosexistencias));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosexistencias.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setLineaGrupo(productosserviciosexistenciasDataAccess.getLineaGrupo(connexion,productosserviciosexistencias));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosexistencias.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setLineaCategoria(productosserviciosexistenciasDataAccess.getLineaCategoria(connexion,productosserviciosexistencias));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosexistencias.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setLineaMarca(productosserviciosexistenciasDataAccess.getLineaMarca(connexion,productosserviciosexistencias));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciosexistencias.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciosexistencias.setTipoProductoServicio(productosserviciosexistenciasDataAccess.getTipoProductoServicio(connexion,productosserviciosexistencias));
			TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
			tipoproductoservicioLogic.deepLoad(productosserviciosexistencias.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(productosserviciosexistencias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosServiciosExistenciasConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosExistencias(productosserviciosexistencias);
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
			this.deepLoad(this.productosserviciosexistencias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosServiciosExistenciasConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosExistencias(this.productosserviciosexistencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(productosserviciosexistenciass!=null) {
				for(ProductosServiciosExistencias productosserviciosexistencias:productosserviciosexistenciass) {
					this.deepLoad(productosserviciosexistencias,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductosServiciosExistenciasConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosExistencias(productosserviciosexistenciass);
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
			if(productosserviciosexistenciass!=null) {
				for(ProductosServiciosExistencias productosserviciosexistencias:productosserviciosexistenciass) {
					this.deepLoad(productosserviciosexistencias,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductosServiciosExistenciasConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosExistencias(productosserviciosexistenciass);
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
	
	public ProductosServiciosExistenciasParameterReturnGeneral procesarAccionProductosServiciosExistenciass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosServiciosExistencias> productosserviciosexistenciass,ProductosServiciosExistenciasParameterReturnGeneral productosserviciosexistenciasParameterGeneral)throws Exception {
		 try {	
			ProductosServiciosExistenciasParameterReturnGeneral productosserviciosexistenciasReturnGeneral=new ProductosServiciosExistenciasParameterReturnGeneral();
	
			ProductosServiciosExistenciasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productosserviciosexistenciass,productosserviciosexistenciasParameterGeneral,productosserviciosexistenciasReturnGeneral);
			
			return productosserviciosexistenciasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductosServiciosExistenciasParameterReturnGeneral procesarAccionProductosServiciosExistenciassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosServiciosExistencias> productosserviciosexistenciass,ProductosServiciosExistenciasParameterReturnGeneral productosserviciosexistenciasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProductosServiciosExistenciasParameterReturnGeneral productosserviciosexistenciasReturnGeneral=new ProductosServiciosExistenciasParameterReturnGeneral();
	
			ProductosServiciosExistenciasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productosserviciosexistenciass,productosserviciosexistenciasParameterGeneral,productosserviciosexistenciasReturnGeneral);
			
			this.connexion.commit();
			
			return productosserviciosexistenciasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

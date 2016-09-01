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
import com.bydan.erp.inventario.util.report.ProductosServiciosPreciosSinRangosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProductosServiciosPreciosSinRangosParameterGeneral;
import com.bydan.erp.inventario.util.report.ProductosServiciosPreciosSinRangosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProductosServiciosPreciosSinRangos;

import com.bydan.erp.inventario.business.logic.report.ProductosServiciosPreciosSinRangosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProductosServiciosPreciosSinRangosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProductosServiciosPreciosSinRangosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProductosServiciosPreciosSinRangosLogic productosserviciospreciossinrangosDataAccess; 		
	protected ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos;
	protected List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss;
	protected Object productosserviciospreciossinrangosObject;	
	protected List<Object> productosserviciospreciossinrangossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProductosServiciosPreciosSinRangosLogic()throws SQLException,Exception {
		try	{
			this.productosserviciospreciossinrangoss= new ArrayList<ProductosServiciosPreciosSinRangos>();
			this.productosserviciospreciossinrangos= new ProductosServiciosPreciosSinRangos();
			this.productosserviciospreciossinrangosObject=new Object();
			this.productosserviciospreciossinrangossObject=new ArrayList<Object>();
			
			this.productosserviciospreciossinrangosDataAccess=this;
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
			this.productosserviciospreciossinrangosDataAccess.setConnexionType(this.connexionType);
			this.productosserviciospreciossinrangosDataAccess.setParameterDbType(this.parameterDbType);
			this.productosserviciospreciossinrangosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductosServiciosPreciosSinRangosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.productosserviciospreciossinrangoss= new ArrayList<ProductosServiciosPreciosSinRangos>();
			this.productosserviciospreciossinrangos= new ProductosServiciosPreciosSinRangos();
			this.productosserviciospreciossinrangosObject=new Object();
			this.productosserviciospreciossinrangossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.productosserviciospreciossinrangosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.productosserviciospreciossinrangosDataAccess.setConnexionType(this.connexionType);
			this.productosserviciospreciossinrangosDataAccess.setParameterDbType(this.parameterDbType);
			this.productosserviciospreciossinrangosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductosServiciosPreciosSinRangos getProductosServiciosPreciosSinRangos() throws Exception {	
		ProductosServiciosPreciosSinRangosLogicAdditional.checkProductosServiciosPreciosSinRangosToGet(productosserviciospreciossinrangos,this.datosCliente,this.arrDatoGeneral);
		ProductosServiciosPreciosSinRangosLogicAdditional.updateProductosServiciosPreciosSinRangosToGet(productosserviciospreciossinrangos,this.arrDatoGeneral);
		
		return productosserviciospreciossinrangos;
	}
		
	public void setProductosServiciosPreciosSinRangos(ProductosServiciosPreciosSinRangos newProductosServiciosPreciosSinRangos) {
		this.productosserviciospreciossinrangos = newProductosServiciosPreciosSinRangos;
	}
	
	public List<ProductosServiciosPreciosSinRangos> getProductosServiciosPreciosSinRangoss() throws Exception {		
		this.quitarProductosServiciosPreciosSinRangossNulos();
		
		ProductosServiciosPreciosSinRangosLogicAdditional.checkProductosServiciosPreciosSinRangosToGets(productosserviciospreciossinrangoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosLocal: productosserviciospreciossinrangoss ) {
			ProductosServiciosPreciosSinRangosLogicAdditional.updateProductosServiciosPreciosSinRangosToGet(productosserviciospreciossinrangosLocal,this.arrDatoGeneral);
		}
		
		return productosserviciospreciossinrangoss;
	}
	
	public void setProductosServiciosPreciosSinRangoss(List<ProductosServiciosPreciosSinRangos> newProductosServiciosPreciosSinRangoss) {
		this.productosserviciospreciossinrangoss = newProductosServiciosPreciosSinRangoss;
	}
	
	public Object getProductosServiciosPreciosSinRangosObject() {	
		//this.productosserviciospreciossinrangosObject=this.productosserviciospreciossinrangosDataAccess.getEntityObject();
		return this.productosserviciospreciossinrangosObject;
	}
		
	public void setProductosServiciosPreciosSinRangosObject(Object newProductosServiciosPreciosSinRangosObject) {
		this.productosserviciospreciossinrangosObject = newProductosServiciosPreciosSinRangosObject;
	}
	
	public List<Object> getProductosServiciosPreciosSinRangossObject() {		
		//this.productosserviciospreciossinrangossObject=this.productosserviciospreciossinrangosDataAccess.getEntitiesObject();
		return this.productosserviciospreciossinrangossObject;
	}
		
	public void setProductosServiciosPreciosSinRangossObject(List<Object> newProductosServiciosPreciosSinRangossObject) {
		this.productosserviciospreciossinrangossObject = newProductosServiciosPreciosSinRangossObject;
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
		productosserviciospreciossinrangoss = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosPreciosSinRangosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciospreciossinrangoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		productosserviciospreciossinrangoss = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		  		  
        try {
			//ProductosServiciosPreciosSinRangosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciospreciossinrangoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productosserviciospreciossinrangoss = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosPreciosSinRangosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciospreciossinrangoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productosserviciospreciossinrangoss = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		  		  
        try {
			//ProductosServiciosPreciosSinRangosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciospreciossinrangoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		productosserviciospreciossinrangoss = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosPreciosSinRangosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciospreciossinrangoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productosserviciospreciossinrangoss = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProductosServiciosPreciosSinRangosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciospreciossinrangoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProductosServiciosPreciosSinRangos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosPreciosSinRangos> entities = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		ProductosServiciosPreciosSinRangos entity = new ProductosServiciosPreciosSinRangos();		  
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
	
	public  List<ProductosServiciosPreciosSinRangos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosPreciosSinRangos> entities = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		ProductosServiciosPreciosSinRangos entity = new ProductosServiciosPreciosSinRangos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosServiciosPreciosSinRangos();
				
				
      	    	entity=ProductosServiciosPreciosSinRangosLogic.getEntityProductosServiciosPreciosSinRangos("",entity,resultSet);
      	    	
				//entity.setProductosServiciosPreciosSinRangosOriginal( new ProductosServiciosPreciosSinRangos());
      	    	//entity.setProductosServiciosPreciosSinRangosOriginal(super.getEntity("",entity.getProductosServiciosPreciosSinRangosOriginal(),resultSet,ProductosServiciosPreciosSinRangosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductosServiciosPreciosSinRangosOriginal(ProductosServiciosPreciosSinRangosDataAccess.getEntityProductosServiciosPreciosSinRangos("",entity.getProductosServiciosPreciosSinRangosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProductosServiciosPreciosSinRangos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosPreciosSinRangos> entities = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		ProductosServiciosPreciosSinRangos entity = new ProductosServiciosPreciosSinRangos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProductosServiciosPreciosSinRangos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosServiciosPreciosSinRangos>((List<ProductosServiciosPreciosSinRangos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosServiciosPreciosSinRangossOriginal(entities);
			
			}  else {
				this.productosserviciospreciossinrangossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosServiciosPreciosSinRangosConstantesFunciones.quitarEspaciosProductosServiciosPreciosSinRangoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProductosServiciosPreciosSinRangos getEntityProductosServiciosPreciosSinRangos(String strPrefijo,ProductosServiciosPreciosSinRangos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRESUCURSAL));
			entity.setcodigo(resultSet.getString(strPrefijo+ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRE));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREUNIDAD));
			entity.setcodigo_tipo_precio(resultSet.getString(strPrefijo+ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGOTIPOPRECIO));
			entity.setprecio(resultSet.getDouble(strPrefijo+ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductosServiciosPreciosSinRangos getEntityProductosServiciosPreciosSinRangos(String strPrefijo,ProductosServiciosPreciosSinRangos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProductosServiciosPreciosSinRangos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProductosServiciosPreciosSinRangos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProductosServiciosPreciosSinRangosLogic.setFieldReflectionProductosServiciosPreciosSinRangos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductosServiciosPreciosSinRangos(Field field,String strPrefijo,String sColumn,ProductosServiciosPreciosSinRangos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGOTIPOPRECIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO:
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
	
	public void quitarProductosServiciosPreciosSinRangossNulos() throws Exception {				
		
		List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangossAux= new ArrayList<ProductosServiciosPreciosSinRangos>();
		
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos:productosserviciospreciossinrangoss) {
			if(productosserviciospreciossinrangos!=null) {
				productosserviciospreciossinrangossAux.add(productosserviciospreciossinrangos);
			}
		}
		
		productosserviciospreciossinrangoss=productosserviciospreciossinrangossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductosServiciosPreciosSinRangos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosServiciosPreciosSinRangos> entities = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		ProductosServiciosPreciosSinRangos entity = new ProductosServiciosPreciosSinRangos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosServiciosPreciosSinRangos>((List<ProductosServiciosPreciosSinRangos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosServiciosPreciosSinRangossOriginal(entities);
			
			}  else {
				this.productosserviciospreciossinrangossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosServiciosPreciosSinRangosConstantesFunciones.quitarEspaciosProductosServiciosPreciosSinRangoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		productosserviciospreciossinrangoss = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosServiciosPreciosSinRangosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciospreciossinrangoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		productosserviciospreciossinrangoss = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		  		  
        try {
			//ProductosServiciosPreciosSinRangosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productosserviciospreciossinrangoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProductosServiciosPreciosSinRangos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosServiciosPreciosSinRangos> entities = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		ProductosServiciosPreciosSinRangos entity = new ProductosServiciosPreciosSinRangos();		  
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
	
	public  List<ProductosServiciosPreciosSinRangos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosServiciosPreciosSinRangos> entities = new  ArrayList<ProductosServiciosPreciosSinRangos>();
		ProductosServiciosPreciosSinRangos entity = new ProductosServiciosPreciosSinRangos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosServiciosPreciosSinRangos();
				
				if(conMapGenerico) {
					entity.setMapProductosServiciosPreciosSinRangos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProductosServiciosPreciosSinRangos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductosServiciosPreciosSinRangosDataAccess.ISWITHSCHEMA);         		
					entity=ProductosServiciosPreciosSinRangosLogic.getEntityProductosServiciosPreciosSinRangos("",entity,resultSet,listColumns);
					
					////entity.setProductosServiciosPreciosSinRangosOriginal( new ProductosServiciosPreciosSinRangos());
					////entity.setProductosServiciosPreciosSinRangosOriginal(super.getEntity("",entity.getProductosServiciosPreciosSinRangosOriginal(),resultSet,ProductosServiciosPreciosSinRangosDataAccess.ISWITHSCHEMA));         		
					////entity.setProductosServiciosPreciosSinRangosOriginal(ProductosServiciosPreciosSinRangosDataAccess.getEntityProductosServiciosPreciosSinRangos("",entity.getProductosServiciosPreciosSinRangosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ProductosServiciosPreciosSinRangos relproductosserviciospreciossinrangos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relproductosserviciospreciossinrangos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProductosServiciosPreciosSinRangos relproductosserviciospreciossinrangos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relproductosserviciospreciossinrangos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,ProductosServiciosPreciosSinRangos relproductosserviciospreciossinrangos)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relproductosserviciospreciossinrangos.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Linea getLinea(Connexion connexion,ProductosServiciosPreciosSinRangos relproductosserviciospreciossinrangos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciospreciossinrangos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProductosServiciosPreciosSinRangos relproductosserviciospreciossinrangos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciospreciossinrangos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProductosServiciosPreciosSinRangos relproductosserviciospreciossinrangos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciospreciossinrangos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProductosServiciosPreciosSinRangos relproductosserviciospreciossinrangos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductosserviciospreciossinrangos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getProductosServiciosPreciosSinRangossBusquedaProductosServiciosPreciosSinRangosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProductosServiciosPreciosSinRangosLogic productosserviciospreciossinrangosLogic=new ProductosServiciosPreciosSinRangosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosServiciosPreciosSinRangosLogic.GetSelecSqlProductosServiciosPreciosSinRangos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productosserviciospreciossinrangoss=this.getProductosServiciosPreciosSinRangoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProductosServiciosPreciosSinRangossBusquedaProductosServiciosPreciosSinRangos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProductosServiciosPreciosSinRangosLogic productosserviciospreciossinrangosLogic=new ProductosServiciosPreciosSinRangosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosServiciosPreciosSinRangosLogic.GetSelecSqlProductosServiciosPreciosSinRangos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productosserviciospreciossinrangoss=this.getProductosServiciosPreciosSinRangoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProductosServiciosPreciosSinRangos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProductosServiciosPreciosSinRangos_Postgres.sql");
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
	
	
	public void deepLoad(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductosServiciosPreciosSinRangosLogicAdditional.updateProductosServiciosPreciosSinRangosToGet(productosserviciospreciossinrangos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productosserviciospreciossinrangos.setEmpresa(productosserviciospreciossinrangosDataAccess.getEmpresa(connexion,productosserviciospreciossinrangos));
		productosserviciospreciossinrangos.setSucursal(productosserviciospreciossinrangosDataAccess.getSucursal(connexion,productosserviciospreciossinrangos));
		productosserviciospreciossinrangos.setBodega(productosserviciospreciossinrangosDataAccess.getBodega(connexion,productosserviciospreciossinrangos));
		productosserviciospreciossinrangos.setLinea(productosserviciospreciossinrangosDataAccess.getLinea(connexion,productosserviciospreciossinrangos));
		productosserviciospreciossinrangos.setLineaGrupo(productosserviciospreciossinrangosDataAccess.getLineaGrupo(connexion,productosserviciospreciossinrangos));
		productosserviciospreciossinrangos.setLineaCategoria(productosserviciospreciossinrangosDataAccess.getLineaCategoria(connexion,productosserviciospreciossinrangos));
		productosserviciospreciossinrangos.setLineaMarca(productosserviciospreciossinrangosDataAccess.getLineaMarca(connexion,productosserviciospreciossinrangos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productosserviciospreciossinrangos.setEmpresa(productosserviciospreciossinrangosDataAccess.getEmpresa(connexion,productosserviciospreciossinrangos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				productosserviciospreciossinrangos.setSucursal(productosserviciospreciossinrangosDataAccess.getSucursal(connexion,productosserviciospreciossinrangos));
			}

			if(clas.clas.equals(Bodega.class)) {
				productosserviciospreciossinrangos.setBodega(productosserviciospreciossinrangosDataAccess.getBodega(connexion,productosserviciospreciossinrangos));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciospreciossinrangos.setLinea(productosserviciospreciossinrangosDataAccess.getLinea(connexion,productosserviciospreciossinrangos));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciospreciossinrangos.setLineaGrupo(productosserviciospreciossinrangosDataAccess.getLineaGrupo(connexion,productosserviciospreciossinrangos));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciospreciossinrangos.setLineaCategoria(productosserviciospreciossinrangosDataAccess.getLineaCategoria(connexion,productosserviciospreciossinrangos));
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciospreciossinrangos.setLineaMarca(productosserviciospreciossinrangosDataAccess.getLineaMarca(connexion,productosserviciospreciossinrangos));
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
			productosserviciospreciossinrangos.setEmpresa(productosserviciospreciossinrangosDataAccess.getEmpresa(connexion,productosserviciospreciossinrangos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setSucursal(productosserviciospreciossinrangosDataAccess.getSucursal(connexion,productosserviciospreciossinrangos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setBodega(productosserviciospreciossinrangosDataAccess.getBodega(connexion,productosserviciospreciossinrangos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setLinea(productosserviciospreciossinrangosDataAccess.getLinea(connexion,productosserviciospreciossinrangos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setLineaGrupo(productosserviciospreciossinrangosDataAccess.getLineaGrupo(connexion,productosserviciospreciossinrangos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setLineaCategoria(productosserviciospreciossinrangosDataAccess.getLineaCategoria(connexion,productosserviciospreciossinrangos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setLineaMarca(productosserviciospreciossinrangosDataAccess.getLineaMarca(connexion,productosserviciospreciossinrangos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productosserviciospreciossinrangos.setEmpresa(productosserviciospreciossinrangosDataAccess.getEmpresa(connexion,productosserviciospreciossinrangos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productosserviciospreciossinrangos.getEmpresa(),isDeep,deepLoadType,clases);
				
		productosserviciospreciossinrangos.setSucursal(productosserviciospreciossinrangosDataAccess.getSucursal(connexion,productosserviciospreciossinrangos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productosserviciospreciossinrangos.getSucursal(),isDeep,deepLoadType,clases);
				
		productosserviciospreciossinrangos.setBodega(productosserviciospreciossinrangosDataAccess.getBodega(connexion,productosserviciospreciossinrangos));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productosserviciospreciossinrangos.getBodega(),isDeep,deepLoadType,clases);
				
		productosserviciospreciossinrangos.setLinea(productosserviciospreciossinrangosDataAccess.getLinea(connexion,productosserviciospreciossinrangos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(productosserviciospreciossinrangos.getLinea(),isDeep,deepLoadType,clases);
				
		productosserviciospreciossinrangos.setLineaGrupo(productosserviciospreciossinrangosDataAccess.getLineaGrupo(connexion,productosserviciospreciossinrangos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(productosserviciospreciossinrangos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		productosserviciospreciossinrangos.setLineaCategoria(productosserviciospreciossinrangosDataAccess.getLineaCategoria(connexion,productosserviciospreciossinrangos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(productosserviciospreciossinrangos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		productosserviciospreciossinrangos.setLineaMarca(productosserviciospreciossinrangosDataAccess.getLineaMarca(connexion,productosserviciospreciossinrangos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(productosserviciospreciossinrangos.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productosserviciospreciossinrangos.setEmpresa(productosserviciospreciossinrangosDataAccess.getEmpresa(connexion,productosserviciospreciossinrangos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productosserviciospreciossinrangos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				productosserviciospreciossinrangos.setSucursal(productosserviciospreciossinrangosDataAccess.getSucursal(connexion,productosserviciospreciossinrangos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productosserviciospreciossinrangos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Bodega.class)) {
				productosserviciospreciossinrangos.setBodega(productosserviciospreciossinrangosDataAccess.getBodega(connexion,productosserviciospreciossinrangos));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productosserviciospreciossinrangos.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciospreciossinrangos.setLinea(productosserviciospreciossinrangosDataAccess.getLinea(connexion,productosserviciospreciossinrangos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciospreciossinrangos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciospreciossinrangos.setLineaGrupo(productosserviciospreciossinrangosDataAccess.getLineaGrupo(connexion,productosserviciospreciossinrangos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciospreciossinrangos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciospreciossinrangos.setLineaCategoria(productosserviciospreciossinrangosDataAccess.getLineaCategoria(connexion,productosserviciospreciossinrangos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciospreciossinrangos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productosserviciospreciossinrangos.setLineaMarca(productosserviciospreciossinrangosDataAccess.getLineaMarca(connexion,productosserviciospreciossinrangos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productosserviciospreciossinrangos.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			productosserviciospreciossinrangos.setEmpresa(productosserviciospreciossinrangosDataAccess.getEmpresa(connexion,productosserviciospreciossinrangos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productosserviciospreciossinrangos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setSucursal(productosserviciospreciossinrangosDataAccess.getSucursal(connexion,productosserviciospreciossinrangos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productosserviciospreciossinrangos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setBodega(productosserviciospreciossinrangosDataAccess.getBodega(connexion,productosserviciospreciossinrangos));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productosserviciospreciossinrangos.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setLinea(productosserviciospreciossinrangosDataAccess.getLinea(connexion,productosserviciospreciossinrangos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciospreciossinrangos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setLineaGrupo(productosserviciospreciossinrangosDataAccess.getLineaGrupo(connexion,productosserviciospreciossinrangos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciospreciossinrangos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setLineaCategoria(productosserviciospreciossinrangosDataAccess.getLineaCategoria(connexion,productosserviciospreciossinrangos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciospreciossinrangos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productosserviciospreciossinrangos.setLineaMarca(productosserviciospreciossinrangosDataAccess.getLineaMarca(connexion,productosserviciospreciossinrangos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productosserviciospreciossinrangos.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(productosserviciospreciossinrangos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosServiciosPreciosSinRangosConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosPreciosSinRangos(productosserviciospreciossinrangos);
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
			this.deepLoad(this.productosserviciospreciossinrangos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosServiciosPreciosSinRangosConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosPreciosSinRangos(this.productosserviciospreciossinrangos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(productosserviciospreciossinrangoss!=null) {
				for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos:productosserviciospreciossinrangoss) {
					this.deepLoad(productosserviciospreciossinrangos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductosServiciosPreciosSinRangosConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosPreciosSinRangos(productosserviciospreciossinrangoss);
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
			if(productosserviciospreciossinrangoss!=null) {
				for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos:productosserviciospreciossinrangoss) {
					this.deepLoad(productosserviciospreciossinrangos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductosServiciosPreciosSinRangosConstantesFunciones.refrescarForeignKeysDescripcionesProductosServiciosPreciosSinRangos(productosserviciospreciossinrangoss);
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
	
	public ProductosServiciosPreciosSinRangosParameterReturnGeneral procesarAccionProductosServiciosPreciosSinRangoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,ProductosServiciosPreciosSinRangosParameterReturnGeneral productosserviciospreciossinrangosParameterGeneral)throws Exception {
		 try {	
			ProductosServiciosPreciosSinRangosParameterReturnGeneral productosserviciospreciossinrangosReturnGeneral=new ProductosServiciosPreciosSinRangosParameterReturnGeneral();
	
			ProductosServiciosPreciosSinRangosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productosserviciospreciossinrangoss,productosserviciospreciossinrangosParameterGeneral,productosserviciospreciossinrangosReturnGeneral);
			
			return productosserviciospreciossinrangosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductosServiciosPreciosSinRangosParameterReturnGeneral procesarAccionProductosServiciosPreciosSinRangossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,ProductosServiciosPreciosSinRangosParameterReturnGeneral productosserviciospreciossinrangosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProductosServiciosPreciosSinRangosParameterReturnGeneral productosserviciospreciossinrangosReturnGeneral=new ProductosServiciosPreciosSinRangosParameterReturnGeneral();
	
			ProductosServiciosPreciosSinRangosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productosserviciospreciossinrangoss,productosserviciospreciossinrangosParameterGeneral,productosserviciospreciossinrangosReturnGeneral);
			
			this.connexion.commit();
			
			return productosserviciospreciossinrangosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

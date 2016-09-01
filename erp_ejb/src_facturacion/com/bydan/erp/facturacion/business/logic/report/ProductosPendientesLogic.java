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
package com.bydan.erp.facturacion.business.logic.report;

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

import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.resources.general.AuxiliarGeneral;
import com.bydan.erp.facturacion.util.report.ProductosPendientesParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.ProductosPendientesParameterGeneral;
import com.bydan.erp.facturacion.util.report.ProductosPendientesConstantesFunciones;
import com.bydan.erp.facturacion.business.entity.report.ProductosPendientes;

import com.bydan.erp.facturacion.business.logic.report.ProductosPendientesLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProductosPendientesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProductosPendientesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProductosPendientesLogic productospendientesDataAccess; 		
	protected ProductosPendientes productospendientes;
	protected List<ProductosPendientes> productospendientess;
	protected Object productospendientesObject;	
	protected List<Object> productospendientessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProductosPendientesLogic()throws SQLException,Exception {
		try	{
			this.productospendientess= new ArrayList<ProductosPendientes>();
			this.productospendientes= new ProductosPendientes();
			this.productospendientesObject=new Object();
			this.productospendientessObject=new ArrayList<Object>();
			
			this.productospendientesDataAccess=this;
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
			this.productospendientesDataAccess.setConnexionType(this.connexionType);
			this.productospendientesDataAccess.setParameterDbType(this.parameterDbType);
			this.productospendientesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductosPendientesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.productospendientess= new ArrayList<ProductosPendientes>();
			this.productospendientes= new ProductosPendientes();
			this.productospendientesObject=new Object();
			this.productospendientessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.productospendientesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.productospendientesDataAccess.setConnexionType(this.connexionType);
			this.productospendientesDataAccess.setParameterDbType(this.parameterDbType);
			this.productospendientesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductosPendientes getProductosPendientes() throws Exception {	
		ProductosPendientesLogicAdditional.checkProductosPendientesToGet(productospendientes,this.datosCliente,this.arrDatoGeneral);
		ProductosPendientesLogicAdditional.updateProductosPendientesToGet(productospendientes,this.arrDatoGeneral);
		
		return productospendientes;
	}
		
	public void setProductosPendientes(ProductosPendientes newProductosPendientes) {
		this.productospendientes = newProductosPendientes;
	}
	
	public List<ProductosPendientes> getProductosPendientess() throws Exception {		
		this.quitarProductosPendientessNulos();
		
		ProductosPendientesLogicAdditional.checkProductosPendientesToGets(productospendientess,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductosPendientes productospendientesLocal: productospendientess ) {
			ProductosPendientesLogicAdditional.updateProductosPendientesToGet(productospendientesLocal,this.arrDatoGeneral);
		}
		
		return productospendientess;
	}
	
	public void setProductosPendientess(List<ProductosPendientes> newProductosPendientess) {
		this.productospendientess = newProductosPendientess;
	}
	
	public Object getProductosPendientesObject() {	
		//this.productospendientesObject=this.productospendientesDataAccess.getEntityObject();
		return this.productospendientesObject;
	}
		
	public void setProductosPendientesObject(Object newProductosPendientesObject) {
		this.productospendientesObject = newProductosPendientesObject;
	}
	
	public List<Object> getProductosPendientessObject() {		
		//this.productospendientessObject=this.productospendientesDataAccess.getEntitiesObject();
		return this.productospendientessObject;
	}
		
	public void setProductosPendientessObject(List<Object> newProductosPendientessObject) {
		this.productospendientessObject = newProductosPendientessObject;
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
		productospendientess = new  ArrayList<ProductosPendientes>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		productospendientess = new  ArrayList<ProductosPendientes>();
		  		  
        try {
			//ProductosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productospendientess = new  ArrayList<ProductosPendientes>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productospendientess = new  ArrayList<ProductosPendientes>();
		  		  
        try {
			//ProductosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		productospendientess = new  ArrayList<ProductosPendientes>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		productospendientess = new  ArrayList<ProductosPendientes>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProductosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProductosPendientes> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosPendientes> entities = new  ArrayList<ProductosPendientes>();
		ProductosPendientes entity = new ProductosPendientes();		  
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
	
	public  List<ProductosPendientes> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosPendientes> entities = new  ArrayList<ProductosPendientes>();
		ProductosPendientes entity = new ProductosPendientes();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosPendientes();
				
				
      	    	entity=ProductosPendientesLogic.getEntityProductosPendientes("",entity,resultSet);
      	    	
				//entity.setProductosPendientesOriginal( new ProductosPendientes());
      	    	//entity.setProductosPendientesOriginal(super.getEntity("",entity.getProductosPendientesOriginal(),resultSet,ProductosPendientesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductosPendientesOriginal(ProductosPendientesDataAccess.getEntityProductosPendientes("",entity.getProductosPendientesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProductosPendientes> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosPendientes> entities = new  ArrayList<ProductosPendientes>();
		ProductosPendientes entity = new ProductosPendientes();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProductosPendientes.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosPendientes>((List<ProductosPendientes>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosPendientessOriginal(entities);
			
			}  else {
				this.productospendientessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosPendientesConstantesFunciones.quitarEspaciosProductosPendientess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProductosPendientes getEntityProductosPendientes(String strPrefijo,ProductosPendientes entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_empresa(resultSet.getString(strPrefijo+ProductosPendientesConstantesFunciones.NOMBREEMPRESA));
			entity.setruc_empresa(resultSet.getString(strPrefijo+ProductosPendientesConstantesFunciones.RUCEMPRESA));
			entity.setnombre_producto(resultSet.getString(strPrefijo+ProductosPendientesConstantesFunciones.NOMBREPRODUCTO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ProductosPendientesConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad(resultSet.getInt(strPrefijo+ProductosPendientesConstantesFunciones.CANTIDAD));
			entity.setprecio(resultSet.getDouble(strPrefijo+ProductosPendientesConstantesFunciones.PRECIO));
			entity.settotal(resultSet.getDouble(strPrefijo+ProductosPendientesConstantesFunciones.TOTAL));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+ProductosPendientesConstantesFunciones.CODIGOPRODUCTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductosPendientes getEntityProductosPendientes(String strPrefijo,ProductosPendientes entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProductosPendientes.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProductosPendientes.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProductosPendientesLogic.setFieldReflectionProductosPendientes(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductosPendientes(Field field,String strPrefijo,String sColumn,ProductosPendientes entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductosPendientesConstantesFunciones.NOMBREEMPRESA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosPendientesConstantesFunciones.RUCEMPRESA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosPendientesConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosPendientesConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductosPendientesConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductosPendientesConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductosPendientesConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductosPendientesConstantesFunciones.CODIGOPRODUCTO:
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
	
	public void quitarProductosPendientessNulos() throws Exception {				
		
		List<ProductosPendientes> productospendientessAux= new ArrayList<ProductosPendientes>();
		
		for(ProductosPendientes productospendientes:productospendientess) {
			if(productospendientes!=null) {
				productospendientessAux.add(productospendientes);
			}
		}
		
		productospendientess=productospendientessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductosPendientes> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductosPendientes> entities = new  ArrayList<ProductosPendientes>();
		ProductosPendientes entity = new ProductosPendientes();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProductosPendientes>((List<ProductosPendientes>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProductosPendientessOriginal(entities);
			
			}  else {
				this.productospendientessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProductosPendientesConstantesFunciones.quitarEspaciosProductosPendientess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		productospendientess = new  ArrayList<ProductosPendientes>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProductosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		productospendientess = new  ArrayList<ProductosPendientes>();
		  		  
        try {
			//ProductosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProductosPendientes> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosPendientes> entities = new  ArrayList<ProductosPendientes>();
		ProductosPendientes entity = new ProductosPendientes();		  
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
	
	public  List<ProductosPendientes> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductosPendientes> entities = new  ArrayList<ProductosPendientes>();
		ProductosPendientes entity = new ProductosPendientes();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductosPendientes();
				
				if(conMapGenerico) {
					entity.setMapProductosPendientes( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProductosPendientes().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductosPendientesDataAccess.ISWITHSCHEMA);         		
					entity=ProductosPendientesLogic.getEntityProductosPendientes("",entity,resultSet,listColumns);
					
					////entity.setProductosPendientesOriginal( new ProductosPendientes());
					////entity.setProductosPendientesOriginal(super.getEntity("",entity.getProductosPendientesOriginal(),resultSet,ProductosPendientesDataAccess.ISWITHSCHEMA));         		
					////entity.setProductosPendientesOriginal(ProductosPendientesDataAccess.getEntityProductosPendientes("",entity.getProductosPendientesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ProductosPendientes relproductospendientes)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relproductospendientes.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Bodega getBodega(Connexion connexion,ProductosPendientes relproductospendientes)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relproductospendientes.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Linea getLinea(Connexion connexion,ProductosPendientes relproductospendientes)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductospendientes.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProductosPendientes relproductospendientes)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductospendientes.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProductosPendientes relproductospendientes)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductospendientes.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProductosPendientes relproductospendientes)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relproductospendientes.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getProductosPendientessBusquedaProductosPendientesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//ProductosPendientesLogic productospendientesLogic=new ProductosPendientesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosPendientesLogic.GetSelecSqlProductosPendientes(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productospendientess=this.getProductosPendientess();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProductosPendientessBusquedaProductosPendientes(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//ProductosPendientesLogic productospendientesLogic=new ProductosPendientesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProductosPendientesLogic.GetSelecSqlProductosPendientes(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.productospendientess=this.getProductosPendientess();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProductosPendientes(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProductosPendientes_Postgres.sql");
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
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" p.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_bodega!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_bodega = "+id_bodega.toString();
					existeWhere=true;
				}

				if(id_linea!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" pr.id_linea = "+id_linea.toString();
					existeWhere=true;
				}

				if(id_linea_grupo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" pr.id_linea_grupo = "+id_linea_grupo.toString();
					existeWhere=true;
				}

				if(id_linea_categoria!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" pr.id_linea_categoria = "+id_linea_categoria.toString();
					existeWhere=true;
				}

				if(id_linea_marca!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" pr.id_linea_marca = "+id_linea_marca.toString();
					existeWhere=true;
				}

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
					existeWhere=true;
				}

				if(fecha_emision_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_emision_hasta)+"'";
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
	
	
	public void deepLoad(ProductosPendientes productospendientes,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductosPendientesLogicAdditional.updateProductosPendientesToGet(productospendientes,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productospendientes.setEmpresa(productospendientesDataAccess.getEmpresa(connexion,productospendientes));
		productospendientes.setBodega(productospendientesDataAccess.getBodega(connexion,productospendientes));
		productospendientes.setLinea(productospendientesDataAccess.getLinea(connexion,productospendientes));
		productospendientes.setLineaGrupo(productospendientesDataAccess.getLineaGrupo(connexion,productospendientes));
		productospendientes.setLineaCategoria(productospendientesDataAccess.getLineaCategoria(connexion,productospendientes));
		productospendientes.setLineaMarca(productospendientesDataAccess.getLineaMarca(connexion,productospendientes));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productospendientes.setEmpresa(productospendientesDataAccess.getEmpresa(connexion,productospendientes));
			}

			if(clas.clas.equals(Bodega.class)) {
				productospendientes.setBodega(productospendientesDataAccess.getBodega(connexion,productospendientes));
			}

			if(clas.clas.equals(Linea.class)) {
				productospendientes.setLinea(productospendientesDataAccess.getLinea(connexion,productospendientes));
			}

			if(clas.clas.equals(Linea.class)) {
				productospendientes.setLineaGrupo(productospendientesDataAccess.getLineaGrupo(connexion,productospendientes));
			}

			if(clas.clas.equals(Linea.class)) {
				productospendientes.setLineaCategoria(productospendientesDataAccess.getLineaCategoria(connexion,productospendientes));
			}

			if(clas.clas.equals(Linea.class)) {
				productospendientes.setLineaMarca(productospendientesDataAccess.getLineaMarca(connexion,productospendientes));
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
			productospendientes.setEmpresa(productospendientesDataAccess.getEmpresa(connexion,productospendientes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setBodega(productospendientesDataAccess.getBodega(connexion,productospendientes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setLinea(productospendientesDataAccess.getLinea(connexion,productospendientes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setLineaGrupo(productospendientesDataAccess.getLineaGrupo(connexion,productospendientes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setLineaCategoria(productospendientesDataAccess.getLineaCategoria(connexion,productospendientes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setLineaMarca(productospendientesDataAccess.getLineaMarca(connexion,productospendientes));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productospendientes.setEmpresa(productospendientesDataAccess.getEmpresa(connexion,productospendientes));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productospendientes.getEmpresa(),isDeep,deepLoadType,clases);
				
		productospendientes.setBodega(productospendientesDataAccess.getBodega(connexion,productospendientes));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productospendientes.getBodega(),isDeep,deepLoadType,clases);
				
		productospendientes.setLinea(productospendientesDataAccess.getLinea(connexion,productospendientes));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(productospendientes.getLinea(),isDeep,deepLoadType,clases);
				
		productospendientes.setLineaGrupo(productospendientesDataAccess.getLineaGrupo(connexion,productospendientes));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(productospendientes.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		productospendientes.setLineaCategoria(productospendientesDataAccess.getLineaCategoria(connexion,productospendientes));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(productospendientes.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		productospendientes.setLineaMarca(productospendientesDataAccess.getLineaMarca(connexion,productospendientes));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(productospendientes.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productospendientes.setEmpresa(productospendientesDataAccess.getEmpresa(connexion,productospendientes));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productospendientes.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Bodega.class)) {
				productospendientes.setBodega(productospendientesDataAccess.getBodega(connexion,productospendientes));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productospendientes.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productospendientes.setLinea(productospendientesDataAccess.getLinea(connexion,productospendientes));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productospendientes.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productospendientes.setLineaGrupo(productospendientesDataAccess.getLineaGrupo(connexion,productospendientes));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productospendientes.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productospendientes.setLineaCategoria(productospendientesDataAccess.getLineaCategoria(connexion,productospendientes));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productospendientes.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				productospendientes.setLineaMarca(productospendientesDataAccess.getLineaMarca(connexion,productospendientes));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(productospendientes.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			productospendientes.setEmpresa(productospendientesDataAccess.getEmpresa(connexion,productospendientes));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productospendientes.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setBodega(productospendientesDataAccess.getBodega(connexion,productospendientes));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productospendientes.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setLinea(productospendientesDataAccess.getLinea(connexion,productospendientes));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productospendientes.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setLineaGrupo(productospendientesDataAccess.getLineaGrupo(connexion,productospendientes));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productospendientes.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setLineaCategoria(productospendientesDataAccess.getLineaCategoria(connexion,productospendientes));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productospendientes.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productospendientes.setLineaMarca(productospendientesDataAccess.getLineaMarca(connexion,productospendientes));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(productospendientes.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(productospendientes,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosPendientesConstantesFunciones.refrescarForeignKeysDescripcionesProductosPendientes(productospendientes);
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
			this.deepLoad(this.productospendientes,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductosPendientesConstantesFunciones.refrescarForeignKeysDescripcionesProductosPendientes(this.productospendientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(productospendientess!=null) {
				for(ProductosPendientes productospendientes:productospendientess) {
					this.deepLoad(productospendientes,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductosPendientesConstantesFunciones.refrescarForeignKeysDescripcionesProductosPendientes(productospendientess);
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
			if(productospendientess!=null) {
				for(ProductosPendientes productospendientes:productospendientess) {
					this.deepLoad(productospendientes,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductosPendientesConstantesFunciones.refrescarForeignKeysDescripcionesProductosPendientes(productospendientess);
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
	
	public ProductosPendientesParameterReturnGeneral procesarAccionProductosPendientess(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosPendientes> productospendientess,ProductosPendientesParameterReturnGeneral productospendientesParameterGeneral)throws Exception {
		 try {	
			ProductosPendientesParameterReturnGeneral productospendientesReturnGeneral=new ProductosPendientesParameterReturnGeneral();
	
			ProductosPendientesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productospendientess,productospendientesParameterGeneral,productospendientesReturnGeneral);
			
			return productospendientesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductosPendientesParameterReturnGeneral procesarAccionProductosPendientessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductosPendientes> productospendientess,ProductosPendientesParameterReturnGeneral productospendientesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProductosPendientesParameterReturnGeneral productospendientesReturnGeneral=new ProductosPendientesParameterReturnGeneral();
	
			ProductosPendientesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productospendientess,productospendientesParameterGeneral,productospendientesReturnGeneral);
			
			this.connexion.commit();
			
			return productospendientesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

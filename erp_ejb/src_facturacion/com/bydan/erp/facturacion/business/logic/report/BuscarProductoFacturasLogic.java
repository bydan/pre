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
import com.bydan.erp.facturacion.util.report.BuscarProductoFacturasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.BuscarProductoFacturasParameterGeneral;
import com.bydan.erp.facturacion.util.report.BuscarProductoFacturasConstantesFunciones;
import com.bydan.erp.facturacion.business.entity.report.BuscarProductoFacturas;

import com.bydan.erp.facturacion.business.logic.report.BuscarProductoFacturasLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;






@SuppressWarnings("unused")
public class BuscarProductoFacturasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(BuscarProductoFacturasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected BuscarProductoFacturasLogic buscarproductofacturasDataAccess; 		
	protected BuscarProductoFacturas buscarproductofacturas;
	protected List<BuscarProductoFacturas> buscarproductofacturass;
	protected Object buscarproductofacturasObject;	
	protected List<Object> buscarproductofacturassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  BuscarProductoFacturasLogic()throws SQLException,Exception {
		try	{
			this.buscarproductofacturass= new ArrayList<BuscarProductoFacturas>();
			this.buscarproductofacturas= new BuscarProductoFacturas();
			this.buscarproductofacturasObject=new Object();
			this.buscarproductofacturassObject=new ArrayList<Object>();
			
			this.buscarproductofacturasDataAccess=this;
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
			this.buscarproductofacturasDataAccess.setConnexionType(this.connexionType);
			this.buscarproductofacturasDataAccess.setParameterDbType(this.parameterDbType);
			this.buscarproductofacturasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BuscarProductoFacturasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.buscarproductofacturass= new ArrayList<BuscarProductoFacturas>();
			this.buscarproductofacturas= new BuscarProductoFacturas();
			this.buscarproductofacturasObject=new Object();
			this.buscarproductofacturassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.buscarproductofacturasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.buscarproductofacturasDataAccess.setConnexionType(this.connexionType);
			this.buscarproductofacturasDataAccess.setParameterDbType(this.parameterDbType);
			this.buscarproductofacturasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public BuscarProductoFacturas getBuscarProductoFacturas() throws Exception {	
		BuscarProductoFacturasLogicAdditional.checkBuscarProductoFacturasToGet(buscarproductofacturas,this.datosCliente,this.arrDatoGeneral);
		BuscarProductoFacturasLogicAdditional.updateBuscarProductoFacturasToGet(buscarproductofacturas,this.arrDatoGeneral);
		
		return buscarproductofacturas;
	}
		
	public void setBuscarProductoFacturas(BuscarProductoFacturas newBuscarProductoFacturas) {
		this.buscarproductofacturas = newBuscarProductoFacturas;
	}
	
	public List<BuscarProductoFacturas> getBuscarProductoFacturass() throws Exception {		
		this.quitarBuscarProductoFacturassNulos();
		
		BuscarProductoFacturasLogicAdditional.checkBuscarProductoFacturasToGets(buscarproductofacturass,this.datosCliente,this.arrDatoGeneral);
		
		for (BuscarProductoFacturas buscarproductofacturasLocal: buscarproductofacturass ) {
			BuscarProductoFacturasLogicAdditional.updateBuscarProductoFacturasToGet(buscarproductofacturasLocal,this.arrDatoGeneral);
		}
		
		return buscarproductofacturass;
	}
	
	public void setBuscarProductoFacturass(List<BuscarProductoFacturas> newBuscarProductoFacturass) {
		this.buscarproductofacturass = newBuscarProductoFacturass;
	}
	
	public Object getBuscarProductoFacturasObject() {	
		//this.buscarproductofacturasObject=this.buscarproductofacturasDataAccess.getEntityObject();
		return this.buscarproductofacturasObject;
	}
		
	public void setBuscarProductoFacturasObject(Object newBuscarProductoFacturasObject) {
		this.buscarproductofacturasObject = newBuscarProductoFacturasObject;
	}
	
	public List<Object> getBuscarProductoFacturassObject() {		
		//this.buscarproductofacturassObject=this.buscarproductofacturasDataAccess.getEntitiesObject();
		return this.buscarproductofacturassObject;
	}
		
	public void setBuscarProductoFacturassObject(List<Object> newBuscarProductoFacturassObject) {
		this.buscarproductofacturassObject = newBuscarProductoFacturassObject;
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
		buscarproductofacturass = new  ArrayList<BuscarProductoFacturas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//BuscarProductoFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			buscarproductofacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		buscarproductofacturass = new  ArrayList<BuscarProductoFacturas>();
		  		  
        try {
			//BuscarProductoFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			buscarproductofacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		buscarproductofacturass = new  ArrayList<BuscarProductoFacturas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//BuscarProductoFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			buscarproductofacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		buscarproductofacturass = new  ArrayList<BuscarProductoFacturas>();
		  		  
        try {
			//BuscarProductoFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			buscarproductofacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		buscarproductofacturass = new  ArrayList<BuscarProductoFacturas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//BuscarProductoFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			buscarproductofacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		buscarproductofacturass = new  ArrayList<BuscarProductoFacturas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//BuscarProductoFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			buscarproductofacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<BuscarProductoFacturas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BuscarProductoFacturas> entities = new  ArrayList<BuscarProductoFacturas>();
		BuscarProductoFacturas entity = new BuscarProductoFacturas();		  
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
	
	public  List<BuscarProductoFacturas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BuscarProductoFacturas> entities = new  ArrayList<BuscarProductoFacturas>();
		BuscarProductoFacturas entity = new BuscarProductoFacturas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BuscarProductoFacturas();
				
				
      	    	entity=BuscarProductoFacturasLogic.getEntityBuscarProductoFacturas("",entity,resultSet);
      	    	
				//entity.setBuscarProductoFacturasOriginal( new BuscarProductoFacturas());
      	    	//entity.setBuscarProductoFacturasOriginal(super.getEntity("",entity.getBuscarProductoFacturasOriginal(),resultSet,BuscarProductoFacturasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBuscarProductoFacturasOriginal(BuscarProductoFacturasDataAccess.getEntityBuscarProductoFacturas("",entity.getBuscarProductoFacturasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<BuscarProductoFacturas> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BuscarProductoFacturas> entities = new  ArrayList<BuscarProductoFacturas>();
		BuscarProductoFacturas entity = new BuscarProductoFacturas();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,BuscarProductoFacturas.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<BuscarProductoFacturas>((List<BuscarProductoFacturas>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setBuscarProductoFacturassOriginal(entities);
			
			}  else {
				this.buscarproductofacturassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//BuscarProductoFacturasConstantesFunciones.quitarEspaciosBuscarProductoFacturass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static BuscarProductoFacturas getEntityBuscarProductoFacturas(String strPrefijo,BuscarProductoFacturas entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_vendedor(resultSet.getString(strPrefijo+BuscarProductoFacturasConstantesFunciones.NOMBREVENDEDOR));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+BuscarProductoFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+BuscarProductoFacturasConstantesFunciones.FECHAEMISION).getTime()));
			entity.setnumero_pre_impreso_dato(resultSet.getString(strPrefijo+BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESODATO));
			entity.settotal(resultSet.getDouble(strPrefijo+BuscarProductoFacturasConstantesFunciones.TOTAL));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+BuscarProductoFacturasConstantesFunciones.NOMBREUNIDAD));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+BuscarProductoFacturasConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_producto(resultSet.getString(strPrefijo+BuscarProductoFacturasConstantesFunciones.NOMBREPRODUCTO));
			entity.setcantidad(resultSet.getInt(strPrefijo+BuscarProductoFacturasConstantesFunciones.CANTIDAD));
			entity.setprecio(resultSet.getDouble(strPrefijo+BuscarProductoFacturasConstantesFunciones.PRECIO));
			entity.setdescuento(resultSet.getDouble(strPrefijo+BuscarProductoFacturasConstantesFunciones.DESCUENTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static BuscarProductoFacturas getEntityBuscarProductoFacturas(String strPrefijo,BuscarProductoFacturas entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = BuscarProductoFacturas.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = BuscarProductoFacturas.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				BuscarProductoFacturasLogic.setFieldReflectionBuscarProductoFacturas(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionBuscarProductoFacturas(Field field,String strPrefijo,String sColumn,BuscarProductoFacturas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case BuscarProductoFacturasConstantesFunciones.NOMBREVENDEDOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESODATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BuscarProductoFacturasConstantesFunciones.DESCUENTO:
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
	
	public void quitarBuscarProductoFacturassNulos() throws Exception {				
		
		List<BuscarProductoFacturas> buscarproductofacturassAux= new ArrayList<BuscarProductoFacturas>();
		
		for(BuscarProductoFacturas buscarproductofacturas:buscarproductofacturass) {
			if(buscarproductofacturas!=null) {
				buscarproductofacturassAux.add(buscarproductofacturas);
			}
		}
		
		buscarproductofacturass=buscarproductofacturassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<BuscarProductoFacturas> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BuscarProductoFacturas> entities = new  ArrayList<BuscarProductoFacturas>();
		BuscarProductoFacturas entity = new BuscarProductoFacturas();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<BuscarProductoFacturas>((List<BuscarProductoFacturas>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setBuscarProductoFacturassOriginal(entities);
			
			}  else {
				this.buscarproductofacturassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//BuscarProductoFacturasConstantesFunciones.quitarEspaciosBuscarProductoFacturass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		buscarproductofacturass = new  ArrayList<BuscarProductoFacturas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//BuscarProductoFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			buscarproductofacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		buscarproductofacturass = new  ArrayList<BuscarProductoFacturas>();
		  		  
        try {
			//BuscarProductoFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			buscarproductofacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<BuscarProductoFacturas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<BuscarProductoFacturas> entities = new  ArrayList<BuscarProductoFacturas>();
		BuscarProductoFacturas entity = new BuscarProductoFacturas();		  
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
	
	public  List<BuscarProductoFacturas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<BuscarProductoFacturas> entities = new  ArrayList<BuscarProductoFacturas>();
		BuscarProductoFacturas entity = new BuscarProductoFacturas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BuscarProductoFacturas();
				
				if(conMapGenerico) {
					entity.setMapBuscarProductoFacturas( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapBuscarProductoFacturas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BuscarProductoFacturasDataAccess.ISWITHSCHEMA);         		
					entity=BuscarProductoFacturasLogic.getEntityBuscarProductoFacturas("",entity,resultSet,listColumns);
					
					////entity.setBuscarProductoFacturasOriginal( new BuscarProductoFacturas());
					////entity.setBuscarProductoFacturasOriginal(super.getEntity("",entity.getBuscarProductoFacturasOriginal(),resultSet,BuscarProductoFacturasDataAccess.ISWITHSCHEMA));         		
					////entity.setBuscarProductoFacturasOriginal(BuscarProductoFacturasDataAccess.getEntityBuscarProductoFacturas("",entity.getBuscarProductoFacturasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Producto getProducto(Connexion connexion,BuscarProductoFacturas relbuscarproductofacturas)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relbuscarproductofacturas.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,BuscarProductoFacturas relbuscarproductofacturas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relbuscarproductofacturas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,BuscarProductoFacturas relbuscarproductofacturas)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relbuscarproductofacturas.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,BuscarProductoFacturas relbuscarproductofacturas)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relbuscarproductofacturas.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


	
	
	public void getBuscarProductoFacturassBusquedaBuscarProductoFacturasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_producto,Long id_cliente,String numero_pre_impreso,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//BuscarProductoFacturasLogic buscarproductofacturasLogic=new BuscarProductoFacturasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=BuscarProductoFacturasLogic.GetSelecSqlBuscarProductoFacturas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_producto,id_cliente,numero_pre_impreso,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.buscarproductofacturass=this.getBuscarProductoFacturass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getBuscarProductoFacturassBusquedaBuscarProductoFacturas(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_producto,Long id_cliente,String numero_pre_impreso,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//BuscarProductoFacturasLogic buscarproductofacturasLogic=new BuscarProductoFacturasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=BuscarProductoFacturasLogic.GetSelecSqlBuscarProductoFacturas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_producto,id_cliente,numero_pre_impreso,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.buscarproductofacturass=this.getBuscarProductoFacturass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlBuscarProductoFacturas(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_producto,Long id_cliente,String numero_pre_impreso,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("BuscarProductoFacturas_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" f.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" f.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_producto!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_producto = "+id_producto.toString();
					existeWhere=true;
				}

				if(id_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_cliente = "+id_cliente.toString();
					existeWhere=true;
				}

				if(numero_pre_impreso!= null && !numero_pre_impreso.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.numero_pre_impreso = "+"'"+numero_pre_impreso+"'";
					existeWhere=true;
				}

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
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
	
	
	public void deepLoad(BuscarProductoFacturas buscarproductofacturas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BuscarProductoFacturasLogicAdditional.updateBuscarProductoFacturasToGet(buscarproductofacturas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		buscarproductofacturas.setProducto(buscarproductofacturasDataAccess.getProducto(connexion,buscarproductofacturas));
		buscarproductofacturas.setEmpresa(buscarproductofacturasDataAccess.getEmpresa(connexion,buscarproductofacturas));
		buscarproductofacturas.setSucursal(buscarproductofacturasDataAccess.getSucursal(connexion,buscarproductofacturas));
		buscarproductofacturas.setCliente(buscarproductofacturasDataAccess.getCliente(connexion,buscarproductofacturas));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				buscarproductofacturas.setProducto(buscarproductofacturasDataAccess.getProducto(connexion,buscarproductofacturas));
			}

			if(clas.clas.equals(Empresa.class)) {
				buscarproductofacturas.setEmpresa(buscarproductofacturasDataAccess.getEmpresa(connexion,buscarproductofacturas));
			}

			if(clas.clas.equals(Sucursal.class)) {
				buscarproductofacturas.setSucursal(buscarproductofacturasDataAccess.getSucursal(connexion,buscarproductofacturas));
			}

			if(clas.clas.equals(Cliente.class)) {
				buscarproductofacturas.setCliente(buscarproductofacturasDataAccess.getCliente(connexion,buscarproductofacturas));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			buscarproductofacturas.setProducto(buscarproductofacturasDataAccess.getProducto(connexion,buscarproductofacturas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			buscarproductofacturas.setEmpresa(buscarproductofacturasDataAccess.getEmpresa(connexion,buscarproductofacturas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			buscarproductofacturas.setSucursal(buscarproductofacturasDataAccess.getSucursal(connexion,buscarproductofacturas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			buscarproductofacturas.setCliente(buscarproductofacturasDataAccess.getCliente(connexion,buscarproductofacturas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		buscarproductofacturas.setProducto(buscarproductofacturasDataAccess.getProducto(connexion,buscarproductofacturas));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(buscarproductofacturas.getProducto(),isDeep,deepLoadType,clases);
				
		buscarproductofacturas.setEmpresa(buscarproductofacturasDataAccess.getEmpresa(connexion,buscarproductofacturas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(buscarproductofacturas.getEmpresa(),isDeep,deepLoadType,clases);
				
		buscarproductofacturas.setSucursal(buscarproductofacturasDataAccess.getSucursal(connexion,buscarproductofacturas));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(buscarproductofacturas.getSucursal(),isDeep,deepLoadType,clases);
				
		buscarproductofacturas.setCliente(buscarproductofacturasDataAccess.getCliente(connexion,buscarproductofacturas));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(buscarproductofacturas.getCliente(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				buscarproductofacturas.setProducto(buscarproductofacturasDataAccess.getProducto(connexion,buscarproductofacturas));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(buscarproductofacturas.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				buscarproductofacturas.setEmpresa(buscarproductofacturasDataAccess.getEmpresa(connexion,buscarproductofacturas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(buscarproductofacturas.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				buscarproductofacturas.setSucursal(buscarproductofacturasDataAccess.getSucursal(connexion,buscarproductofacturas));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(buscarproductofacturas.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				buscarproductofacturas.setCliente(buscarproductofacturasDataAccess.getCliente(connexion,buscarproductofacturas));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(buscarproductofacturas.getCliente(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			buscarproductofacturas.setProducto(buscarproductofacturasDataAccess.getProducto(connexion,buscarproductofacturas));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(buscarproductofacturas.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			buscarproductofacturas.setEmpresa(buscarproductofacturasDataAccess.getEmpresa(connexion,buscarproductofacturas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(buscarproductofacturas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			buscarproductofacturas.setSucursal(buscarproductofacturasDataAccess.getSucursal(connexion,buscarproductofacturas));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(buscarproductofacturas.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			buscarproductofacturas.setCliente(buscarproductofacturasDataAccess.getCliente(connexion,buscarproductofacturas));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(buscarproductofacturas.getCliente(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(buscarproductofacturas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BuscarProductoFacturasConstantesFunciones.refrescarForeignKeysDescripcionesBuscarProductoFacturas(buscarproductofacturas);
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
			this.deepLoad(this.buscarproductofacturas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BuscarProductoFacturasConstantesFunciones.refrescarForeignKeysDescripcionesBuscarProductoFacturas(this.buscarproductofacturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(buscarproductofacturass!=null) {
				for(BuscarProductoFacturas buscarproductofacturas:buscarproductofacturass) {
					this.deepLoad(buscarproductofacturas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BuscarProductoFacturasConstantesFunciones.refrescarForeignKeysDescripcionesBuscarProductoFacturas(buscarproductofacturass);
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
			if(buscarproductofacturass!=null) {
				for(BuscarProductoFacturas buscarproductofacturas:buscarproductofacturass) {
					this.deepLoad(buscarproductofacturas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BuscarProductoFacturasConstantesFunciones.refrescarForeignKeysDescripcionesBuscarProductoFacturas(buscarproductofacturass);
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
	
	public BuscarProductoFacturasParameterReturnGeneral procesarAccionBuscarProductoFacturass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BuscarProductoFacturas> buscarproductofacturass,BuscarProductoFacturasParameterReturnGeneral buscarproductofacturasParameterGeneral)throws Exception {
		 try {	
			BuscarProductoFacturasParameterReturnGeneral buscarproductofacturasReturnGeneral=new BuscarProductoFacturasParameterReturnGeneral();
	
			BuscarProductoFacturasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,buscarproductofacturass,buscarproductofacturasParameterGeneral,buscarproductofacturasReturnGeneral);
			
			return buscarproductofacturasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BuscarProductoFacturasParameterReturnGeneral procesarAccionBuscarProductoFacturassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BuscarProductoFacturas> buscarproductofacturass,BuscarProductoFacturasParameterReturnGeneral buscarproductofacturasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			BuscarProductoFacturasParameterReturnGeneral buscarproductofacturasReturnGeneral=new BuscarProductoFacturasParameterReturnGeneral();
	
			BuscarProductoFacturasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,buscarproductofacturass,buscarproductofacturasParameterGeneral,buscarproductofacturasReturnGeneral);
			
			this.connexion.commit();
			
			return buscarproductofacturasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

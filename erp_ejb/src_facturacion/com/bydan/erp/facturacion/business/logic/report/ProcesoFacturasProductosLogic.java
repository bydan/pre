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
import com.bydan.erp.facturacion.util.report.ProcesoFacturasProductosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.ProcesoFacturasProductosParameterGeneral;
import com.bydan.erp.facturacion.util.report.ProcesoFacturasProductosConstantesFunciones;
import com.bydan.erp.facturacion.business.entity.report.ProcesoFacturasProductos;

import com.bydan.erp.facturacion.business.logic.report.ProcesoFacturasProductosLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoFacturasProductosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoFacturasProductosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoFacturasProductosLogic procesofacturasproductosDataAccess; 		
	protected ProcesoFacturasProductos procesofacturasproductos;
	protected List<ProcesoFacturasProductos> procesofacturasproductoss;
	protected Object procesofacturasproductosObject;	
	protected List<Object> procesofacturasproductossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoFacturasProductosLogic()throws SQLException,Exception {
		try	{
			this.procesofacturasproductoss= new ArrayList<ProcesoFacturasProductos>();
			this.procesofacturasproductos= new ProcesoFacturasProductos();
			this.procesofacturasproductosObject=new Object();
			this.procesofacturasproductossObject=new ArrayList<Object>();
			
			this.procesofacturasproductosDataAccess=this;
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
			this.procesofacturasproductosDataAccess.setConnexionType(this.connexionType);
			this.procesofacturasproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesofacturasproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoFacturasProductosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesofacturasproductoss= new ArrayList<ProcesoFacturasProductos>();
			this.procesofacturasproductos= new ProcesoFacturasProductos();
			this.procesofacturasproductosObject=new Object();
			this.procesofacturasproductossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesofacturasproductosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesofacturasproductosDataAccess.setConnexionType(this.connexionType);
			this.procesofacturasproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesofacturasproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoFacturasProductos getProcesoFacturasProductos() throws Exception {	
		ProcesoFacturasProductosLogicAdditional.checkProcesoFacturasProductosToGet(procesofacturasproductos,this.datosCliente,this.arrDatoGeneral);
		ProcesoFacturasProductosLogicAdditional.updateProcesoFacturasProductosToGet(procesofacturasproductos,this.arrDatoGeneral);
		
		return procesofacturasproductos;
	}
		
	public void setProcesoFacturasProductos(ProcesoFacturasProductos newProcesoFacturasProductos) {
		this.procesofacturasproductos = newProcesoFacturasProductos;
	}
	
	public List<ProcesoFacturasProductos> getProcesoFacturasProductoss() throws Exception {		
		this.quitarProcesoFacturasProductossNulos();
		
		ProcesoFacturasProductosLogicAdditional.checkProcesoFacturasProductosToGets(procesofacturasproductoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoFacturasProductos procesofacturasproductosLocal: procesofacturasproductoss ) {
			ProcesoFacturasProductosLogicAdditional.updateProcesoFacturasProductosToGet(procesofacturasproductosLocal,this.arrDatoGeneral);
		}
		
		return procesofacturasproductoss;
	}
	
	public void setProcesoFacturasProductoss(List<ProcesoFacturasProductos> newProcesoFacturasProductoss) {
		this.procesofacturasproductoss = newProcesoFacturasProductoss;
	}
	
	public Object getProcesoFacturasProductosObject() {	
		//this.procesofacturasproductosObject=this.procesofacturasproductosDataAccess.getEntityObject();
		return this.procesofacturasproductosObject;
	}
		
	public void setProcesoFacturasProductosObject(Object newProcesoFacturasProductosObject) {
		this.procesofacturasproductosObject = newProcesoFacturasProductosObject;
	}
	
	public List<Object> getProcesoFacturasProductossObject() {		
		//this.procesofacturasproductossObject=this.procesofacturasproductosDataAccess.getEntitiesObject();
		return this.procesofacturasproductossObject;
	}
		
	public void setProcesoFacturasProductossObject(List<Object> newProcesoFacturasProductossObject) {
		this.procesofacturasproductossObject = newProcesoFacturasProductossObject;
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
		procesofacturasproductoss = new  ArrayList<ProcesoFacturasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoFacturasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesofacturasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesofacturasproductoss = new  ArrayList<ProcesoFacturasProductos>();
		  		  
        try {
			//ProcesoFacturasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesofacturasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesofacturasproductoss = new  ArrayList<ProcesoFacturasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoFacturasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesofacturasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesofacturasproductoss = new  ArrayList<ProcesoFacturasProductos>();
		  		  
        try {
			//ProcesoFacturasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesofacturasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesofacturasproductoss = new  ArrayList<ProcesoFacturasProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoFacturasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesofacturasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesofacturasproductoss = new  ArrayList<ProcesoFacturasProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoFacturasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesofacturasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoFacturasProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoFacturasProductos> entities = new  ArrayList<ProcesoFacturasProductos>();
		ProcesoFacturasProductos entity = new ProcesoFacturasProductos();		  
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
	
	public  List<ProcesoFacturasProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoFacturasProductos> entities = new  ArrayList<ProcesoFacturasProductos>();
		ProcesoFacturasProductos entity = new ProcesoFacturasProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoFacturasProductos();
				
				
      	    	entity=ProcesoFacturasProductosLogic.getEntityProcesoFacturasProductos("",entity,resultSet);
      	    	
				//entity.setProcesoFacturasProductosOriginal( new ProcesoFacturasProductos());
      	    	//entity.setProcesoFacturasProductosOriginal(super.getEntity("",entity.getProcesoFacturasProductosOriginal(),resultSet,ProcesoFacturasProductosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoFacturasProductosOriginal(ProcesoFacturasProductosDataAccess.getEntityProcesoFacturasProductos("",entity.getProcesoFacturasProductosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoFacturasProductos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoFacturasProductos> entities = new  ArrayList<ProcesoFacturasProductos>();
		ProcesoFacturasProductos entity = new ProcesoFacturasProductos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoFacturasProductos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoFacturasProductos>((List<ProcesoFacturasProductos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoFacturasProductossOriginal(entities);
			
			}  else {
				this.procesofacturasproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoFacturasProductosConstantesFunciones.quitarEspaciosProcesoFacturasProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoFacturasProductos getEntityProcesoFacturasProductos(String strPrefijo,ProcesoFacturasProductos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_provincia(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.NOMBREPROVINCIA));
			entity.setnombre_ciudad(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.NOMBRECIUDAD));
			entity.setnombre_zona(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.NOMBREZONA));
			entity.setnombre_grupo_cliente(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.NOMBREGRUPOCLIENTE));
			entity.setcodigo_dato(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.CODIGODATO));
			entity.setnombre_completo_dato(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETODATO));
			entity.setnumero_pre_impreso_factura(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.NUMEROPREIMPRESOFACTURA));
			entity.setnombre_producto(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.NOMBREPRODUCTO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.NOMBREUNIDAD));
			entity.setprecio(resultSet.getDouble(strPrefijo+ProcesoFacturasProductosConstantesFunciones.PRECIO));
			entity.settarea(resultSet.getString(strPrefijo+ProcesoFacturasProductosConstantesFunciones.TAREA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoFacturasProductos getEntityProcesoFacturasProductos(String strPrefijo,ProcesoFacturasProductos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoFacturasProductos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoFacturasProductos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoFacturasProductosLogic.setFieldReflectionProcesoFacturasProductos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoFacturasProductos(Field field,String strPrefijo,String sColumn,ProcesoFacturasProductos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoFacturasProductosConstantesFunciones.NOMBREPROVINCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.NOMBRECIUDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.NOMBREZONA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.NOMBREGRUPOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.CODIGODATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETODATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.NUMEROPREIMPRESOFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoFacturasProductosConstantesFunciones.TAREA:
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
	
	public void quitarProcesoFacturasProductossNulos() throws Exception {				
		
		List<ProcesoFacturasProductos> procesofacturasproductossAux= new ArrayList<ProcesoFacturasProductos>();
		
		for(ProcesoFacturasProductos procesofacturasproductos:procesofacturasproductoss) {
			if(procesofacturasproductos!=null) {
				procesofacturasproductossAux.add(procesofacturasproductos);
			}
		}
		
		procesofacturasproductoss=procesofacturasproductossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoFacturasProductos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoFacturasProductos> entities = new  ArrayList<ProcesoFacturasProductos>();
		ProcesoFacturasProductos entity = new ProcesoFacturasProductos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoFacturasProductos>((List<ProcesoFacturasProductos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoFacturasProductossOriginal(entities);
			
			}  else {
				this.procesofacturasproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoFacturasProductosConstantesFunciones.quitarEspaciosProcesoFacturasProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesofacturasproductoss = new  ArrayList<ProcesoFacturasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoFacturasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesofacturasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesofacturasproductoss = new  ArrayList<ProcesoFacturasProductos>();
		  		  
        try {
			//ProcesoFacturasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesofacturasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoFacturasProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoFacturasProductos> entities = new  ArrayList<ProcesoFacturasProductos>();
		ProcesoFacturasProductos entity = new ProcesoFacturasProductos();		  
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
	
	public  List<ProcesoFacturasProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoFacturasProductos> entities = new  ArrayList<ProcesoFacturasProductos>();
		ProcesoFacturasProductos entity = new ProcesoFacturasProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoFacturasProductos();
				
				if(conMapGenerico) {
					entity.setMapProcesoFacturasProductos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoFacturasProductos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoFacturasProductosDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoFacturasProductosLogic.getEntityProcesoFacturasProductos("",entity,resultSet,listColumns);
					
					////entity.setProcesoFacturasProductosOriginal( new ProcesoFacturasProductos());
					////entity.setProcesoFacturasProductosOriginal(super.getEntity("",entity.getProcesoFacturasProductosOriginal(),resultSet,ProcesoFacturasProductosDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoFacturasProductosOriginal(ProcesoFacturasProductosDataAccess.getEntityProcesoFacturasProductos("",entity.getProcesoFacturasProductosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Ciudad getCiudad(Connexion connexion,ProcesoFacturasProductos relprocesofacturasproductos)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);
			ciudadDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ciudad=ciudadDataAccess.getEntity(connexion,relprocesofacturasproductos.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,ProcesoFacturasProductos relprocesofacturasproductos)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);
			zonaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			zona=zonaDataAccess.getEntity(connexion,relprocesofacturasproductos.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public GrupoCliente getGrupoCliente(Connexion connexion,ProcesoFacturasProductos relprocesofacturasproductos)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			grupoclienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relprocesofacturasproductos.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}

	public Vendedor getVendedor(Connexion connexion,ProcesoFacturasProductos relprocesofacturasproductos)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);
			vendedorDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			vendedor=vendedorDataAccess.getEntity(connexion,relprocesofacturasproductos.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}


	
	
	public void getProcesoFacturasProductossBusquedaProcesoFacturasProductosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor,String codigo,String nombre_completo)throws Exception {
		try {
			//ProcesoFacturasProductosLogic procesofacturasproductosLogic=new ProcesoFacturasProductosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoFacturasProductosLogic.GetSelecSqlProcesoFacturasProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ciudad,id_zona,id_grupo_cliente,id_vendedor,codigo,nombre_completo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesofacturasproductoss=this.getProcesoFacturasProductoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoFacturasProductossBusquedaProcesoFacturasProductos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor,String codigo,String nombre_completo)throws Exception {
		try {
			//ProcesoFacturasProductosLogic procesofacturasproductosLogic=new ProcesoFacturasProductosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoFacturasProductosLogic.GetSelecSqlProcesoFacturasProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ciudad,id_zona,id_grupo_cliente,id_vendedor,codigo,nombre_completo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesofacturasproductoss=this.getProcesoFacturasProductoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoFacturasProductos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor,String codigo,String nombre_completo)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoFacturasProductos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" c.id_empresa="+parametroGeneralUsuario.getid_empresa();
					//existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" c.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_ciudad!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_ciudad = "+id_ciudad.toString();
					existeWhere=true;
				}

				if(id_zona!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_zona = "+id_zona.toString();
					existeWhere=true;
				}

				if(id_grupo_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_grupo_cliente = "+id_grupo_cliente.toString();
					existeWhere=true;
				}

				if(id_vendedor!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_vendedor = "+id_vendedor.toString();
					existeWhere=true;
				}

				if(codigo!= null && !codigo.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.codigo = "+"'"+codigo+"'";
					existeWhere=true;
				}

				if(nombre_completo!= null && !nombre_completo.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.nombre_completo = "+"'"+nombre_completo+"'";
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
	
	
	public void deepLoad(ProcesoFacturasProductos procesofacturasproductos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoFacturasProductosLogicAdditional.updateProcesoFacturasProductosToGet(procesofacturasproductos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesofacturasproductos.setCiudad(procesofacturasproductosDataAccess.getCiudad(connexion,procesofacturasproductos));
		procesofacturasproductos.setZona(procesofacturasproductosDataAccess.getZona(connexion,procesofacturasproductos));
		procesofacturasproductos.setGrupoCliente(procesofacturasproductosDataAccess.getGrupoCliente(connexion,procesofacturasproductos));
		procesofacturasproductos.setVendedor(procesofacturasproductosDataAccess.getVendedor(connexion,procesofacturasproductos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				procesofacturasproductos.setCiudad(procesofacturasproductosDataAccess.getCiudad(connexion,procesofacturasproductos));
			}

			if(clas.clas.equals(Zona.class)) {
				procesofacturasproductos.setZona(procesofacturasproductosDataAccess.getZona(connexion,procesofacturasproductos));
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				procesofacturasproductos.setGrupoCliente(procesofacturasproductosDataAccess.getGrupoCliente(connexion,procesofacturasproductos));
			}

			if(clas.clas.equals(Vendedor.class)) {
				procesofacturasproductos.setVendedor(procesofacturasproductosDataAccess.getVendedor(connexion,procesofacturasproductos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesofacturasproductos.setCiudad(procesofacturasproductosDataAccess.getCiudad(connexion,procesofacturasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesofacturasproductos.setZona(procesofacturasproductosDataAccess.getZona(connexion,procesofacturasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesofacturasproductos.setGrupoCliente(procesofacturasproductosDataAccess.getGrupoCliente(connexion,procesofacturasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesofacturasproductos.setVendedor(procesofacturasproductosDataAccess.getVendedor(connexion,procesofacturasproductos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesofacturasproductos.setCiudad(procesofacturasproductosDataAccess.getCiudad(connexion,procesofacturasproductos));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(procesofacturasproductos.getCiudad(),isDeep,deepLoadType,clases);
				
		procesofacturasproductos.setZona(procesofacturasproductosDataAccess.getZona(connexion,procesofacturasproductos));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(procesofacturasproductos.getZona(),isDeep,deepLoadType,clases);
				
		procesofacturasproductos.setGrupoCliente(procesofacturasproductosDataAccess.getGrupoCliente(connexion,procesofacturasproductos));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(procesofacturasproductos.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		procesofacturasproductos.setVendedor(procesofacturasproductosDataAccess.getVendedor(connexion,procesofacturasproductos));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(procesofacturasproductos.getVendedor(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				procesofacturasproductos.setCiudad(procesofacturasproductosDataAccess.getCiudad(connexion,procesofacturasproductos));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(procesofacturasproductos.getCiudad(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Zona.class)) {
				procesofacturasproductos.setZona(procesofacturasproductosDataAccess.getZona(connexion,procesofacturasproductos));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(procesofacturasproductos.getZona(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				procesofacturasproductos.setGrupoCliente(procesofacturasproductosDataAccess.getGrupoCliente(connexion,procesofacturasproductos));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(procesofacturasproductos.getGrupoCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Vendedor.class)) {
				procesofacturasproductos.setVendedor(procesofacturasproductosDataAccess.getVendedor(connexion,procesofacturasproductos));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(procesofacturasproductos.getVendedor(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesofacturasproductos.setCiudad(procesofacturasproductosDataAccess.getCiudad(connexion,procesofacturasproductos));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(procesofacturasproductos.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesofacturasproductos.setZona(procesofacturasproductosDataAccess.getZona(connexion,procesofacturasproductos));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(procesofacturasproductos.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesofacturasproductos.setGrupoCliente(procesofacturasproductosDataAccess.getGrupoCliente(connexion,procesofacturasproductos));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(procesofacturasproductos.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesofacturasproductos.setVendedor(procesofacturasproductosDataAccess.getVendedor(connexion,procesofacturasproductos));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(procesofacturasproductos.getVendedor(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesofacturasproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoFacturasProductosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoFacturasProductos(procesofacturasproductos);
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
			this.deepLoad(this.procesofacturasproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoFacturasProductosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoFacturasProductos(this.procesofacturasproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesofacturasproductoss!=null) {
				for(ProcesoFacturasProductos procesofacturasproductos:procesofacturasproductoss) {
					this.deepLoad(procesofacturasproductos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoFacturasProductosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoFacturasProductos(procesofacturasproductoss);
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
			if(procesofacturasproductoss!=null) {
				for(ProcesoFacturasProductos procesofacturasproductos:procesofacturasproductoss) {
					this.deepLoad(procesofacturasproductos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoFacturasProductosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoFacturasProductos(procesofacturasproductoss);
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
	
	public ProcesoFacturasProductosParameterReturnGeneral procesarAccionProcesoFacturasProductoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoFacturasProductos> procesofacturasproductoss,ProcesoFacturasProductosParameterReturnGeneral procesofacturasproductosParameterGeneral)throws Exception {
		 try {	
			ProcesoFacturasProductosParameterReturnGeneral procesofacturasproductosReturnGeneral=new ProcesoFacturasProductosParameterReturnGeneral();
	
			ProcesoFacturasProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesofacturasproductoss,procesofacturasproductosParameterGeneral,procesofacturasproductosReturnGeneral);
			
			return procesofacturasproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoFacturasProductosParameterReturnGeneral procesarAccionProcesoFacturasProductossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoFacturasProductos> procesofacturasproductoss,ProcesoFacturasProductosParameterReturnGeneral procesofacturasproductosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoFacturasProductosParameterReturnGeneral procesofacturasproductosReturnGeneral=new ProcesoFacturasProductosParameterReturnGeneral();
	
			ProcesoFacturasProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesofacturasproductoss,procesofacturasproductosParameterGeneral,procesofacturasproductosReturnGeneral);
			
			this.connexion.commit();
			
			return procesofacturasproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

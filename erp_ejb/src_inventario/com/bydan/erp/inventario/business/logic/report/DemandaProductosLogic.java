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
import com.bydan.erp.inventario.util.report.DemandaProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.DemandaProductosParameterGeneral;
import com.bydan.erp.inventario.util.report.DemandaProductosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.DemandaProductos;

import com.bydan.erp.inventario.business.logic.report.DemandaProductosLogicAdditional;
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
public class DemandaProductosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(DemandaProductosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected DemandaProductosLogic demandaproductosDataAccess; 		
	protected DemandaProductos demandaproductos;
	protected List<DemandaProductos> demandaproductoss;
	protected Object demandaproductosObject;	
	protected List<Object> demandaproductossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  DemandaProductosLogic()throws SQLException,Exception {
		try	{
			this.demandaproductoss= new ArrayList<DemandaProductos>();
			this.demandaproductos= new DemandaProductos();
			this.demandaproductosObject=new Object();
			this.demandaproductossObject=new ArrayList<Object>();
			
			this.demandaproductosDataAccess=this;
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
			this.demandaproductosDataAccess.setConnexionType(this.connexionType);
			this.demandaproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.demandaproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DemandaProductosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.demandaproductoss= new ArrayList<DemandaProductos>();
			this.demandaproductos= new DemandaProductos();
			this.demandaproductosObject=new Object();
			this.demandaproductossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.demandaproductosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.demandaproductosDataAccess.setConnexionType(this.connexionType);
			this.demandaproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.demandaproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DemandaProductos getDemandaProductos() throws Exception {	
		DemandaProductosLogicAdditional.checkDemandaProductosToGet(demandaproductos,this.datosCliente,this.arrDatoGeneral);
		DemandaProductosLogicAdditional.updateDemandaProductosToGet(demandaproductos,this.arrDatoGeneral);
		
		return demandaproductos;
	}
		
	public void setDemandaProductos(DemandaProductos newDemandaProductos) {
		this.demandaproductos = newDemandaProductos;
	}
	
	public List<DemandaProductos> getDemandaProductoss() throws Exception {		
		this.quitarDemandaProductossNulos();
		
		DemandaProductosLogicAdditional.checkDemandaProductosToGets(demandaproductoss,this.datosCliente,this.arrDatoGeneral);
		
		for (DemandaProductos demandaproductosLocal: demandaproductoss ) {
			DemandaProductosLogicAdditional.updateDemandaProductosToGet(demandaproductosLocal,this.arrDatoGeneral);
		}
		
		return demandaproductoss;
	}
	
	public void setDemandaProductoss(List<DemandaProductos> newDemandaProductoss) {
		this.demandaproductoss = newDemandaProductoss;
	}
	
	public Object getDemandaProductosObject() {	
		//this.demandaproductosObject=this.demandaproductosDataAccess.getEntityObject();
		return this.demandaproductosObject;
	}
		
	public void setDemandaProductosObject(Object newDemandaProductosObject) {
		this.demandaproductosObject = newDemandaProductosObject;
	}
	
	public List<Object> getDemandaProductossObject() {		
		//this.demandaproductossObject=this.demandaproductosDataAccess.getEntitiesObject();
		return this.demandaproductossObject;
	}
		
	public void setDemandaProductossObject(List<Object> newDemandaProductossObject) {
		this.demandaproductossObject = newDemandaProductossObject;
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
		demandaproductoss = new  ArrayList<DemandaProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DemandaProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			demandaproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		demandaproductoss = new  ArrayList<DemandaProductos>();
		  		  
        try {
			//DemandaProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			demandaproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		demandaproductoss = new  ArrayList<DemandaProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DemandaProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			demandaproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		demandaproductoss = new  ArrayList<DemandaProductos>();
		  		  
        try {
			//DemandaProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			demandaproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		demandaproductoss = new  ArrayList<DemandaProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DemandaProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			demandaproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		demandaproductoss = new  ArrayList<DemandaProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//DemandaProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			demandaproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<DemandaProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DemandaProductos> entities = new  ArrayList<DemandaProductos>();
		DemandaProductos entity = new DemandaProductos();		  
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
	
	public  List<DemandaProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DemandaProductos> entities = new  ArrayList<DemandaProductos>();
		DemandaProductos entity = new DemandaProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DemandaProductos();
				
				
      	    	entity=DemandaProductosLogic.getEntityDemandaProductos("",entity,resultSet);
      	    	
				//entity.setDemandaProductosOriginal( new DemandaProductos());
      	    	//entity.setDemandaProductosOriginal(super.getEntity("",entity.getDemandaProductosOriginal(),resultSet,DemandaProductosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDemandaProductosOriginal(DemandaProductosDataAccess.getEntityDemandaProductos("",entity.getDemandaProductosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<DemandaProductos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DemandaProductos> entities = new  ArrayList<DemandaProductos>();
		DemandaProductos entity = new DemandaProductos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,DemandaProductos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DemandaProductos>((List<DemandaProductos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDemandaProductossOriginal(entities);
			
			}  else {
				this.demandaproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DemandaProductosConstantesFunciones.quitarEspaciosDemandaProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static DemandaProductos getEntityDemandaProductos(String strPrefijo,DemandaProductos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+DemandaProductosConstantesFunciones.CODIGO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+DemandaProductosConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad_disponible(resultSet.getInt(strPrefijo+DemandaProductosConstantesFunciones.CANTIDADDISPONIBLE));
			entity.setstock_minimo(resultSet.getInt(strPrefijo+DemandaProductosConstantesFunciones.STOCKMINIMO));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+DemandaProductosConstantesFunciones.CODIGOPRODUCTO));
			entity.setnombre(resultSet.getString(strPrefijo+DemandaProductosConstantesFunciones.NOMBRE));
			entity.setdem_tri(resultSet.getDouble(strPrefijo+DemandaProductosConstantesFunciones.DEMTRI));
			entity.setdem_bi(resultSet.getDouble(strPrefijo+DemandaProductosConstantesFunciones.DEMBI));
			entity.setdem_men(resultSet.getDouble(strPrefijo+DemandaProductosConstantesFunciones.DEMMEN));
			entity.setingresos(resultSet.getDouble(strPrefijo+DemandaProductosConstantesFunciones.INGRESOS));
			entity.setegresos(resultSet.getDouble(strPrefijo+DemandaProductosConstantesFunciones.EGRESOS));
			entity.setexistencia(resultSet.getDouble(strPrefijo+DemandaProductosConstantesFunciones.EXISTENCIA));
			entity.setcosto(resultSet.getDouble(strPrefijo+DemandaProductosConstantesFunciones.COSTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DemandaProductos getEntityDemandaProductos(String strPrefijo,DemandaProductos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = DemandaProductos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = DemandaProductos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				DemandaProductosLogic.setFieldReflectionDemandaProductos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDemandaProductos(Field field,String strPrefijo,String sColumn,DemandaProductos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DemandaProductosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.CANTIDADDISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.STOCKMINIMO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.CODIGOPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.DEMTRI:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.DEMBI:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.DEMMEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.INGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.EGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.EXISTENCIA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DemandaProductosConstantesFunciones.COSTO:
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
	
	public void quitarDemandaProductossNulos() throws Exception {				
		
		List<DemandaProductos> demandaproductossAux= new ArrayList<DemandaProductos>();
		
		for(DemandaProductos demandaproductos:demandaproductoss) {
			if(demandaproductos!=null) {
				demandaproductossAux.add(demandaproductos);
			}
		}
		
		demandaproductoss=demandaproductossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<DemandaProductos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DemandaProductos> entities = new  ArrayList<DemandaProductos>();
		DemandaProductos entity = new DemandaProductos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DemandaProductos>((List<DemandaProductos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDemandaProductossOriginal(entities);
			
			}  else {
				this.demandaproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DemandaProductosConstantesFunciones.quitarEspaciosDemandaProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		demandaproductoss = new  ArrayList<DemandaProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DemandaProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			demandaproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		demandaproductoss = new  ArrayList<DemandaProductos>();
		  		  
        try {
			//DemandaProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			demandaproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<DemandaProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DemandaProductos> entities = new  ArrayList<DemandaProductos>();
		DemandaProductos entity = new DemandaProductos();		  
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
	
	public  List<DemandaProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DemandaProductos> entities = new  ArrayList<DemandaProductos>();
		DemandaProductos entity = new DemandaProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DemandaProductos();
				
				if(conMapGenerico) {
					entity.setMapDemandaProductos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapDemandaProductos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DemandaProductosDataAccess.ISWITHSCHEMA);         		
					entity=DemandaProductosLogic.getEntityDemandaProductos("",entity,resultSet,listColumns);
					
					////entity.setDemandaProductosOriginal( new DemandaProductos());
					////entity.setDemandaProductosOriginal(super.getEntity("",entity.getDemandaProductosOriginal(),resultSet,DemandaProductosDataAccess.ISWITHSCHEMA));         		
					////entity.setDemandaProductosOriginal(DemandaProductosDataAccess.getEntityDemandaProductos("",entity.getDemandaProductosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,DemandaProductos reldemandaproductos)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,reldemandaproductos.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DemandaProductos reldemandaproductos)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,reldemandaproductos.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,DemandaProductos reldemandaproductos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reldemandaproductos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DemandaProductos reldemandaproductos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,reldemandaproductos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,DemandaProductos reldemandaproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldemandaproductos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,DemandaProductos reldemandaproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldemandaproductos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,DemandaProductos reldemandaproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldemandaproductos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,DemandaProductos reldemandaproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldemandaproductos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getDemandaProductossBusquedaDemandaProductosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//DemandaProductosLogic demandaproductosLogic=new DemandaProductosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DemandaProductosLogic.GetSelecSqlDemandaProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.demandaproductoss=this.getDemandaProductoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getDemandaProductossBusquedaDemandaProductos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//DemandaProductosLogic demandaproductosLogic=new DemandaProductosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DemandaProductosLogic.GetSelecSqlDemandaProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.demandaproductoss=this.getDemandaProductoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlDemandaProductos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("DemandaProductos_Postgres.sql");
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

				if(fecha_ultima_venta_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.fecha_ultima_venta<="+"'"+Funciones2.getStringPostgresDate(fecha_ultima_venta_hasta)+"'";
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
	
	
	public void deepLoad(DemandaProductos demandaproductos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DemandaProductosLogicAdditional.updateDemandaProductosToGet(demandaproductos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		demandaproductos.setBodega(demandaproductosDataAccess.getBodega(connexion,demandaproductos));
		demandaproductos.setProducto(demandaproductosDataAccess.getProducto(connexion,demandaproductos));
		demandaproductos.setEmpresa(demandaproductosDataAccess.getEmpresa(connexion,demandaproductos));
		demandaproductos.setSucursal(demandaproductosDataAccess.getSucursal(connexion,demandaproductos));
		demandaproductos.setLinea(demandaproductosDataAccess.getLinea(connexion,demandaproductos));
		demandaproductos.setLineaGrupo(demandaproductosDataAccess.getLineaGrupo(connexion,demandaproductos));
		demandaproductos.setLineaCategoria(demandaproductosDataAccess.getLineaCategoria(connexion,demandaproductos));
		demandaproductos.setLineaMarca(demandaproductosDataAccess.getLineaMarca(connexion,demandaproductos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				demandaproductos.setBodega(demandaproductosDataAccess.getBodega(connexion,demandaproductos));
			}

			if(clas.clas.equals(Producto.class)) {
				demandaproductos.setProducto(demandaproductosDataAccess.getProducto(connexion,demandaproductos));
			}

			if(clas.clas.equals(Empresa.class)) {
				demandaproductos.setEmpresa(demandaproductosDataAccess.getEmpresa(connexion,demandaproductos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				demandaproductos.setSucursal(demandaproductosDataAccess.getSucursal(connexion,demandaproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				demandaproductos.setLinea(demandaproductosDataAccess.getLinea(connexion,demandaproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				demandaproductos.setLineaGrupo(demandaproductosDataAccess.getLineaGrupo(connexion,demandaproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				demandaproductos.setLineaCategoria(demandaproductosDataAccess.getLineaCategoria(connexion,demandaproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				demandaproductos.setLineaMarca(demandaproductosDataAccess.getLineaMarca(connexion,demandaproductos));
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
			demandaproductos.setBodega(demandaproductosDataAccess.getBodega(connexion,demandaproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setProducto(demandaproductosDataAccess.getProducto(connexion,demandaproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setEmpresa(demandaproductosDataAccess.getEmpresa(connexion,demandaproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setSucursal(demandaproductosDataAccess.getSucursal(connexion,demandaproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setLinea(demandaproductosDataAccess.getLinea(connexion,demandaproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setLineaGrupo(demandaproductosDataAccess.getLineaGrupo(connexion,demandaproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setLineaCategoria(demandaproductosDataAccess.getLineaCategoria(connexion,demandaproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setLineaMarca(demandaproductosDataAccess.getLineaMarca(connexion,demandaproductos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		demandaproductos.setBodega(demandaproductosDataAccess.getBodega(connexion,demandaproductos));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(demandaproductos.getBodega(),isDeep,deepLoadType,clases);
				
		demandaproductos.setProducto(demandaproductosDataAccess.getProducto(connexion,demandaproductos));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(demandaproductos.getProducto(),isDeep,deepLoadType,clases);
				
		demandaproductos.setEmpresa(demandaproductosDataAccess.getEmpresa(connexion,demandaproductos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(demandaproductos.getEmpresa(),isDeep,deepLoadType,clases);
				
		demandaproductos.setSucursal(demandaproductosDataAccess.getSucursal(connexion,demandaproductos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(demandaproductos.getSucursal(),isDeep,deepLoadType,clases);
				
		demandaproductos.setLinea(demandaproductosDataAccess.getLinea(connexion,demandaproductos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(demandaproductos.getLinea(),isDeep,deepLoadType,clases);
				
		demandaproductos.setLineaGrupo(demandaproductosDataAccess.getLineaGrupo(connexion,demandaproductos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(demandaproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		demandaproductos.setLineaCategoria(demandaproductosDataAccess.getLineaCategoria(connexion,demandaproductos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(demandaproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		demandaproductos.setLineaMarca(demandaproductosDataAccess.getLineaMarca(connexion,demandaproductos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(demandaproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				demandaproductos.setBodega(demandaproductosDataAccess.getBodega(connexion,demandaproductos));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(demandaproductos.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				demandaproductos.setProducto(demandaproductosDataAccess.getProducto(connexion,demandaproductos));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(demandaproductos.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				demandaproductos.setEmpresa(demandaproductosDataAccess.getEmpresa(connexion,demandaproductos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(demandaproductos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				demandaproductos.setSucursal(demandaproductosDataAccess.getSucursal(connexion,demandaproductos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(demandaproductos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				demandaproductos.setLinea(demandaproductosDataAccess.getLinea(connexion,demandaproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(demandaproductos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				demandaproductos.setLineaGrupo(demandaproductosDataAccess.getLineaGrupo(connexion,demandaproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(demandaproductos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				demandaproductos.setLineaCategoria(demandaproductosDataAccess.getLineaCategoria(connexion,demandaproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(demandaproductos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				demandaproductos.setLineaMarca(demandaproductosDataAccess.getLineaMarca(connexion,demandaproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(demandaproductos.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			demandaproductos.setBodega(demandaproductosDataAccess.getBodega(connexion,demandaproductos));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(demandaproductos.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setProducto(demandaproductosDataAccess.getProducto(connexion,demandaproductos));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(demandaproductos.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setEmpresa(demandaproductosDataAccess.getEmpresa(connexion,demandaproductos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(demandaproductos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setSucursal(demandaproductosDataAccess.getSucursal(connexion,demandaproductos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(demandaproductos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setLinea(demandaproductosDataAccess.getLinea(connexion,demandaproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(demandaproductos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setLineaGrupo(demandaproductosDataAccess.getLineaGrupo(connexion,demandaproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(demandaproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setLineaCategoria(demandaproductosDataAccess.getLineaCategoria(connexion,demandaproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(demandaproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			demandaproductos.setLineaMarca(demandaproductosDataAccess.getLineaMarca(connexion,demandaproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(demandaproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(demandaproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DemandaProductosConstantesFunciones.refrescarForeignKeysDescripcionesDemandaProductos(demandaproductos);
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
			this.deepLoad(this.demandaproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DemandaProductosConstantesFunciones.refrescarForeignKeysDescripcionesDemandaProductos(this.demandaproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(demandaproductoss!=null) {
				for(DemandaProductos demandaproductos:demandaproductoss) {
					this.deepLoad(demandaproductos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DemandaProductosConstantesFunciones.refrescarForeignKeysDescripcionesDemandaProductos(demandaproductoss);
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
			if(demandaproductoss!=null) {
				for(DemandaProductos demandaproductos:demandaproductoss) {
					this.deepLoad(demandaproductos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DemandaProductosConstantesFunciones.refrescarForeignKeysDescripcionesDemandaProductos(demandaproductoss);
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
	
	public DemandaProductosParameterReturnGeneral procesarAccionDemandaProductoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DemandaProductos> demandaproductoss,DemandaProductosParameterReturnGeneral demandaproductosParameterGeneral)throws Exception {
		 try {	
			DemandaProductosParameterReturnGeneral demandaproductosReturnGeneral=new DemandaProductosParameterReturnGeneral();
	
			DemandaProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,demandaproductoss,demandaproductosParameterGeneral,demandaproductosReturnGeneral);
			
			return demandaproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DemandaProductosParameterReturnGeneral procesarAccionDemandaProductossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DemandaProductos> demandaproductoss,DemandaProductosParameterReturnGeneral demandaproductosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			DemandaProductosParameterReturnGeneral demandaproductosReturnGeneral=new DemandaProductosParameterReturnGeneral();
	
			DemandaProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,demandaproductoss,demandaproductosParameterGeneral,demandaproductosReturnGeneral);
			
			this.connexion.commit();
			
			return demandaproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

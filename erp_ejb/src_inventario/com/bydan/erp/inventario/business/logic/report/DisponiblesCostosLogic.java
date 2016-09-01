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
import com.bydan.erp.inventario.util.report.DisponiblesCostosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.DisponiblesCostosParameterGeneral;
import com.bydan.erp.inventario.util.report.DisponiblesCostosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.DisponiblesCostos;

import com.bydan.erp.inventario.business.logic.report.DisponiblesCostosLogicAdditional;
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
public class DisponiblesCostosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(DisponiblesCostosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected DisponiblesCostosLogic disponiblescostosDataAccess; 		
	protected DisponiblesCostos disponiblescostos;
	protected List<DisponiblesCostos> disponiblescostoss;
	protected Object disponiblescostosObject;	
	protected List<Object> disponiblescostossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  DisponiblesCostosLogic()throws SQLException,Exception {
		try	{
			this.disponiblescostoss= new ArrayList<DisponiblesCostos>();
			this.disponiblescostos= new DisponiblesCostos();
			this.disponiblescostosObject=new Object();
			this.disponiblescostossObject=new ArrayList<Object>();
			
			this.disponiblescostosDataAccess=this;
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
			this.disponiblescostosDataAccess.setConnexionType(this.connexionType);
			this.disponiblescostosDataAccess.setParameterDbType(this.parameterDbType);
			this.disponiblescostosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DisponiblesCostosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.disponiblescostoss= new ArrayList<DisponiblesCostos>();
			this.disponiblescostos= new DisponiblesCostos();
			this.disponiblescostosObject=new Object();
			this.disponiblescostossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.disponiblescostosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.disponiblescostosDataAccess.setConnexionType(this.connexionType);
			this.disponiblescostosDataAccess.setParameterDbType(this.parameterDbType);
			this.disponiblescostosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DisponiblesCostos getDisponiblesCostos() throws Exception {	
		DisponiblesCostosLogicAdditional.checkDisponiblesCostosToGet(disponiblescostos,this.datosCliente,this.arrDatoGeneral);
		DisponiblesCostosLogicAdditional.updateDisponiblesCostosToGet(disponiblescostos,this.arrDatoGeneral);
		
		return disponiblescostos;
	}
		
	public void setDisponiblesCostos(DisponiblesCostos newDisponiblesCostos) {
		this.disponiblescostos = newDisponiblesCostos;
	}
	
	public List<DisponiblesCostos> getDisponiblesCostoss() throws Exception {		
		this.quitarDisponiblesCostossNulos();
		
		DisponiblesCostosLogicAdditional.checkDisponiblesCostosToGets(disponiblescostoss,this.datosCliente,this.arrDatoGeneral);
		
		for (DisponiblesCostos disponiblescostosLocal: disponiblescostoss ) {
			DisponiblesCostosLogicAdditional.updateDisponiblesCostosToGet(disponiblescostosLocal,this.arrDatoGeneral);
		}
		
		return disponiblescostoss;
	}
	
	public void setDisponiblesCostoss(List<DisponiblesCostos> newDisponiblesCostoss) {
		this.disponiblescostoss = newDisponiblesCostoss;
	}
	
	public Object getDisponiblesCostosObject() {	
		//this.disponiblescostosObject=this.disponiblescostosDataAccess.getEntityObject();
		return this.disponiblescostosObject;
	}
		
	public void setDisponiblesCostosObject(Object newDisponiblesCostosObject) {
		this.disponiblescostosObject = newDisponiblesCostosObject;
	}
	
	public List<Object> getDisponiblesCostossObject() {		
		//this.disponiblescostossObject=this.disponiblescostosDataAccess.getEntitiesObject();
		return this.disponiblescostossObject;
	}
		
	public void setDisponiblesCostossObject(List<Object> newDisponiblesCostossObject) {
		this.disponiblescostossObject = newDisponiblesCostossObject;
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
		disponiblescostoss = new  ArrayList<DisponiblesCostos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DisponiblesCostosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			disponiblescostoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		disponiblescostoss = new  ArrayList<DisponiblesCostos>();
		  		  
        try {
			//DisponiblesCostosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			disponiblescostoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		disponiblescostoss = new  ArrayList<DisponiblesCostos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DisponiblesCostosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			disponiblescostoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		disponiblescostoss = new  ArrayList<DisponiblesCostos>();
		  		  
        try {
			//DisponiblesCostosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			disponiblescostoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		disponiblescostoss = new  ArrayList<DisponiblesCostos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DisponiblesCostosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			disponiblescostoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		disponiblescostoss = new  ArrayList<DisponiblesCostos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//DisponiblesCostosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			disponiblescostoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<DisponiblesCostos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DisponiblesCostos> entities = new  ArrayList<DisponiblesCostos>();
		DisponiblesCostos entity = new DisponiblesCostos();		  
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
	
	public  List<DisponiblesCostos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DisponiblesCostos> entities = new  ArrayList<DisponiblesCostos>();
		DisponiblesCostos entity = new DisponiblesCostos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DisponiblesCostos();
				
				
      	    	entity=DisponiblesCostosLogic.getEntityDisponiblesCostos("",entity,resultSet);
      	    	
				//entity.setDisponiblesCostosOriginal( new DisponiblesCostos());
      	    	//entity.setDisponiblesCostosOriginal(super.getEntity("",entity.getDisponiblesCostosOriginal(),resultSet,DisponiblesCostosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDisponiblesCostosOriginal(DisponiblesCostosDataAccess.getEntityDisponiblesCostos("",entity.getDisponiblesCostosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<DisponiblesCostos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DisponiblesCostos> entities = new  ArrayList<DisponiblesCostos>();
		DisponiblesCostos entity = new DisponiblesCostos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,DisponiblesCostos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DisponiblesCostos>((List<DisponiblesCostos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDisponiblesCostossOriginal(entities);
			
			}  else {
				this.disponiblescostossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DisponiblesCostosConstantesFunciones.quitarEspaciosDisponiblesCostoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static DisponiblesCostos getEntityDisponiblesCostos(String strPrefijo,DisponiblesCostos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+DisponiblesCostosConstantesFunciones.NOMBRESUCURSAL));
			entity.setnombre_linea(resultSet.getString(strPrefijo+DisponiblesCostosConstantesFunciones.NOMBRELINEA));
			entity.setnombre_linea_grupo(resultSet.getString(strPrefijo+DisponiblesCostosConstantesFunciones.NOMBRELINEAGRUPO));
			entity.setnombre_linea_categoria(resultSet.getString(strPrefijo+DisponiblesCostosConstantesFunciones.NOMBRELINEACATEGORIA));
			entity.setnombre_linea_marca(resultSet.getString(strPrefijo+DisponiblesCostosConstantesFunciones.NOMBRELINEAMARCA));
			entity.setcodigo(resultSet.getString(strPrefijo+DisponiblesCostosConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+DisponiblesCostosConstantesFunciones.NOMBRE));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+DisponiblesCostosConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+DisponiblesCostosConstantesFunciones.NOMBREUNIDAD));
			entity.setingresos(resultSet.getDouble(strPrefijo+DisponiblesCostosConstantesFunciones.INGRESOS));
			entity.setegresos(resultSet.getDouble(strPrefijo+DisponiblesCostosConstantesFunciones.EGRESOS));
			entity.setdisponible_corte(resultSet.getDouble(strPrefijo+DisponiblesCostosConstantesFunciones.DISPONIBLECORTE));
			entity.setcosto(resultSet.getDouble(strPrefijo+DisponiblesCostosConstantesFunciones.COSTO));
			entity.settotal(resultSet.getDouble(strPrefijo+DisponiblesCostosConstantesFunciones.TOTAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DisponiblesCostos getEntityDisponiblesCostos(String strPrefijo,DisponiblesCostos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = DisponiblesCostos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = DisponiblesCostos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				DisponiblesCostosLogic.setFieldReflectionDisponiblesCostos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDisponiblesCostos(Field field,String strPrefijo,String sColumn,DisponiblesCostos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DisponiblesCostosConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.NOMBRELINEA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.NOMBRELINEAGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.NOMBRELINEACATEGORIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.NOMBRELINEAMARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.INGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.EGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.DISPONIBLECORTE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DisponiblesCostosConstantesFunciones.TOTAL:
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
	
	public void quitarDisponiblesCostossNulos() throws Exception {				
		
		List<DisponiblesCostos> disponiblescostossAux= new ArrayList<DisponiblesCostos>();
		
		for(DisponiblesCostos disponiblescostos:disponiblescostoss) {
			if(disponiblescostos!=null) {
				disponiblescostossAux.add(disponiblescostos);
			}
		}
		
		disponiblescostoss=disponiblescostossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<DisponiblesCostos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DisponiblesCostos> entities = new  ArrayList<DisponiblesCostos>();
		DisponiblesCostos entity = new DisponiblesCostos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DisponiblesCostos>((List<DisponiblesCostos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDisponiblesCostossOriginal(entities);
			
			}  else {
				this.disponiblescostossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DisponiblesCostosConstantesFunciones.quitarEspaciosDisponiblesCostoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		disponiblescostoss = new  ArrayList<DisponiblesCostos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DisponiblesCostosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			disponiblescostoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		disponiblescostoss = new  ArrayList<DisponiblesCostos>();
		  		  
        try {
			//DisponiblesCostosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			disponiblescostoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<DisponiblesCostos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DisponiblesCostos> entities = new  ArrayList<DisponiblesCostos>();
		DisponiblesCostos entity = new DisponiblesCostos();		  
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
	
	public  List<DisponiblesCostos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DisponiblesCostos> entities = new  ArrayList<DisponiblesCostos>();
		DisponiblesCostos entity = new DisponiblesCostos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DisponiblesCostos();
				
				if(conMapGenerico) {
					entity.setMapDisponiblesCostos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapDisponiblesCostos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DisponiblesCostosDataAccess.ISWITHSCHEMA);         		
					entity=DisponiblesCostosLogic.getEntityDisponiblesCostos("",entity,resultSet,listColumns);
					
					////entity.setDisponiblesCostosOriginal( new DisponiblesCostos());
					////entity.setDisponiblesCostosOriginal(super.getEntity("",entity.getDisponiblesCostosOriginal(),resultSet,DisponiblesCostosDataAccess.ISWITHSCHEMA));         		
					////entity.setDisponiblesCostosOriginal(DisponiblesCostosDataAccess.getEntityDisponiblesCostos("",entity.getDisponiblesCostosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,DisponiblesCostos reldisponiblescostos)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,reldisponiblescostos.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DisponiblesCostos reldisponiblescostos)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,reldisponiblescostos.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,DisponiblesCostos reldisponiblescostos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reldisponiblescostos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DisponiblesCostos reldisponiblescostos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,reldisponiblescostos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,DisponiblesCostos reldisponiblescostos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldisponiblescostos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,DisponiblesCostos reldisponiblescostos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldisponiblescostos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,DisponiblesCostos reldisponiblescostos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldisponiblescostos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,DisponiblesCostos reldisponiblescostos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldisponiblescostos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getDisponiblesCostossBusquedaDisponiblesCostosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_hasta)throws Exception {
		try {
			//DisponiblesCostosLogic disponiblescostosLogic=new DisponiblesCostosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DisponiblesCostosLogic.GetSelecSqlDisponiblesCostos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.disponiblescostoss=this.getDisponiblesCostoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getDisponiblesCostossBusquedaDisponiblesCostos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_hasta)throws Exception {
		try {
			//DisponiblesCostosLogic disponiblescostosLogic=new DisponiblesCostosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DisponiblesCostosLogic.GetSelecSqlDisponiblesCostos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.disponiblescostoss=this.getDisponiblesCostoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlDisponiblesCostos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("DisponiblesCostos_Postgres.sql");
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

				sSelectQuery=sSelectQuery.replace("FECHA_EMISION_HASTA", Funciones2.getStringPostgresDate(fecha_emision_hasta));

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
	
	
	public void deepLoad(DisponiblesCostos disponiblescostos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DisponiblesCostosLogicAdditional.updateDisponiblesCostosToGet(disponiblescostos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		disponiblescostos.setBodega(disponiblescostosDataAccess.getBodega(connexion,disponiblescostos));
		disponiblescostos.setProducto(disponiblescostosDataAccess.getProducto(connexion,disponiblescostos));
		disponiblescostos.setEmpresa(disponiblescostosDataAccess.getEmpresa(connexion,disponiblescostos));
		disponiblescostos.setSucursal(disponiblescostosDataAccess.getSucursal(connexion,disponiblescostos));
		disponiblescostos.setLinea(disponiblescostosDataAccess.getLinea(connexion,disponiblescostos));
		disponiblescostos.setLineaGrupo(disponiblescostosDataAccess.getLineaGrupo(connexion,disponiblescostos));
		disponiblescostos.setLineaCategoria(disponiblescostosDataAccess.getLineaCategoria(connexion,disponiblescostos));
		disponiblescostos.setLineaMarca(disponiblescostosDataAccess.getLineaMarca(connexion,disponiblescostos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				disponiblescostos.setBodega(disponiblescostosDataAccess.getBodega(connexion,disponiblescostos));
			}

			if(clas.clas.equals(Producto.class)) {
				disponiblescostos.setProducto(disponiblescostosDataAccess.getProducto(connexion,disponiblescostos));
			}

			if(clas.clas.equals(Empresa.class)) {
				disponiblescostos.setEmpresa(disponiblescostosDataAccess.getEmpresa(connexion,disponiblescostos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				disponiblescostos.setSucursal(disponiblescostosDataAccess.getSucursal(connexion,disponiblescostos));
			}

			if(clas.clas.equals(Linea.class)) {
				disponiblescostos.setLinea(disponiblescostosDataAccess.getLinea(connexion,disponiblescostos));
			}

			if(clas.clas.equals(Linea.class)) {
				disponiblescostos.setLineaGrupo(disponiblescostosDataAccess.getLineaGrupo(connexion,disponiblescostos));
			}

			if(clas.clas.equals(Linea.class)) {
				disponiblescostos.setLineaCategoria(disponiblescostosDataAccess.getLineaCategoria(connexion,disponiblescostos));
			}

			if(clas.clas.equals(Linea.class)) {
				disponiblescostos.setLineaMarca(disponiblescostosDataAccess.getLineaMarca(connexion,disponiblescostos));
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
			disponiblescostos.setBodega(disponiblescostosDataAccess.getBodega(connexion,disponiblescostos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setProducto(disponiblescostosDataAccess.getProducto(connexion,disponiblescostos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setEmpresa(disponiblescostosDataAccess.getEmpresa(connexion,disponiblescostos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setSucursal(disponiblescostosDataAccess.getSucursal(connexion,disponiblescostos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setLinea(disponiblescostosDataAccess.getLinea(connexion,disponiblescostos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setLineaGrupo(disponiblescostosDataAccess.getLineaGrupo(connexion,disponiblescostos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setLineaCategoria(disponiblescostosDataAccess.getLineaCategoria(connexion,disponiblescostos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setLineaMarca(disponiblescostosDataAccess.getLineaMarca(connexion,disponiblescostos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		disponiblescostos.setBodega(disponiblescostosDataAccess.getBodega(connexion,disponiblescostos));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(disponiblescostos.getBodega(),isDeep,deepLoadType,clases);
				
		disponiblescostos.setProducto(disponiblescostosDataAccess.getProducto(connexion,disponiblescostos));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(disponiblescostos.getProducto(),isDeep,deepLoadType,clases);
				
		disponiblescostos.setEmpresa(disponiblescostosDataAccess.getEmpresa(connexion,disponiblescostos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(disponiblescostos.getEmpresa(),isDeep,deepLoadType,clases);
				
		disponiblescostos.setSucursal(disponiblescostosDataAccess.getSucursal(connexion,disponiblescostos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(disponiblescostos.getSucursal(),isDeep,deepLoadType,clases);
				
		disponiblescostos.setLinea(disponiblescostosDataAccess.getLinea(connexion,disponiblescostos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(disponiblescostos.getLinea(),isDeep,deepLoadType,clases);
				
		disponiblescostos.setLineaGrupo(disponiblescostosDataAccess.getLineaGrupo(connexion,disponiblescostos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(disponiblescostos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		disponiblescostos.setLineaCategoria(disponiblescostosDataAccess.getLineaCategoria(connexion,disponiblescostos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(disponiblescostos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		disponiblescostos.setLineaMarca(disponiblescostosDataAccess.getLineaMarca(connexion,disponiblescostos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(disponiblescostos.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				disponiblescostos.setBodega(disponiblescostosDataAccess.getBodega(connexion,disponiblescostos));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(disponiblescostos.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				disponiblescostos.setProducto(disponiblescostosDataAccess.getProducto(connexion,disponiblescostos));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(disponiblescostos.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				disponiblescostos.setEmpresa(disponiblescostosDataAccess.getEmpresa(connexion,disponiblescostos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(disponiblescostos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				disponiblescostos.setSucursal(disponiblescostosDataAccess.getSucursal(connexion,disponiblescostos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(disponiblescostos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				disponiblescostos.setLinea(disponiblescostosDataAccess.getLinea(connexion,disponiblescostos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(disponiblescostos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				disponiblescostos.setLineaGrupo(disponiblescostosDataAccess.getLineaGrupo(connexion,disponiblescostos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(disponiblescostos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				disponiblescostos.setLineaCategoria(disponiblescostosDataAccess.getLineaCategoria(connexion,disponiblescostos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(disponiblescostos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				disponiblescostos.setLineaMarca(disponiblescostosDataAccess.getLineaMarca(connexion,disponiblescostos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(disponiblescostos.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			disponiblescostos.setBodega(disponiblescostosDataAccess.getBodega(connexion,disponiblescostos));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(disponiblescostos.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setProducto(disponiblescostosDataAccess.getProducto(connexion,disponiblescostos));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(disponiblescostos.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setEmpresa(disponiblescostosDataAccess.getEmpresa(connexion,disponiblescostos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(disponiblescostos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setSucursal(disponiblescostosDataAccess.getSucursal(connexion,disponiblescostos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(disponiblescostos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setLinea(disponiblescostosDataAccess.getLinea(connexion,disponiblescostos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(disponiblescostos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setLineaGrupo(disponiblescostosDataAccess.getLineaGrupo(connexion,disponiblescostos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(disponiblescostos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setLineaCategoria(disponiblescostosDataAccess.getLineaCategoria(connexion,disponiblescostos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(disponiblescostos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			disponiblescostos.setLineaMarca(disponiblescostosDataAccess.getLineaMarca(connexion,disponiblescostos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(disponiblescostos.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(disponiblescostos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DisponiblesCostosConstantesFunciones.refrescarForeignKeysDescripcionesDisponiblesCostos(disponiblescostos);
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
			this.deepLoad(this.disponiblescostos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DisponiblesCostosConstantesFunciones.refrescarForeignKeysDescripcionesDisponiblesCostos(this.disponiblescostos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(disponiblescostoss!=null) {
				for(DisponiblesCostos disponiblescostos:disponiblescostoss) {
					this.deepLoad(disponiblescostos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DisponiblesCostosConstantesFunciones.refrescarForeignKeysDescripcionesDisponiblesCostos(disponiblescostoss);
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
			if(disponiblescostoss!=null) {
				for(DisponiblesCostos disponiblescostos:disponiblescostoss) {
					this.deepLoad(disponiblescostos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DisponiblesCostosConstantesFunciones.refrescarForeignKeysDescripcionesDisponiblesCostos(disponiblescostoss);
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
	
	public DisponiblesCostosParameterReturnGeneral procesarAccionDisponiblesCostoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DisponiblesCostos> disponiblescostoss,DisponiblesCostosParameterReturnGeneral disponiblescostosParameterGeneral)throws Exception {
		 try {	
			DisponiblesCostosParameterReturnGeneral disponiblescostosReturnGeneral=new DisponiblesCostosParameterReturnGeneral();
	
			DisponiblesCostosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,disponiblescostoss,disponiblescostosParameterGeneral,disponiblescostosReturnGeneral);
			
			return disponiblescostosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DisponiblesCostosParameterReturnGeneral procesarAccionDisponiblesCostossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DisponiblesCostos> disponiblescostoss,DisponiblesCostosParameterReturnGeneral disponiblescostosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			DisponiblesCostosParameterReturnGeneral disponiblescostosReturnGeneral=new DisponiblesCostosParameterReturnGeneral();
	
			DisponiblesCostosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,disponiblescostoss,disponiblescostosParameterGeneral,disponiblescostosReturnGeneral);
			
			this.connexion.commit();
			
			return disponiblescostosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

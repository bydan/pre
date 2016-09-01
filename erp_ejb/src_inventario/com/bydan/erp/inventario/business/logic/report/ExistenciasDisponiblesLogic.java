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
import com.bydan.erp.inventario.util.report.ExistenciasDisponiblesParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ExistenciasDisponiblesParameterGeneral;
import com.bydan.erp.inventario.util.report.ExistenciasDisponiblesConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ExistenciasDisponibles;

import com.bydan.erp.inventario.business.logic.report.ExistenciasDisponiblesLogicAdditional;
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
public class ExistenciasDisponiblesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ExistenciasDisponiblesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ExistenciasDisponiblesLogic existenciasdisponiblesDataAccess; 		
	protected ExistenciasDisponibles existenciasdisponibles;
	protected List<ExistenciasDisponibles> existenciasdisponibless;
	protected Object existenciasdisponiblesObject;	
	protected List<Object> existenciasdisponiblessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ExistenciasDisponiblesLogic()throws SQLException,Exception {
		try	{
			this.existenciasdisponibless= new ArrayList<ExistenciasDisponibles>();
			this.existenciasdisponibles= new ExistenciasDisponibles();
			this.existenciasdisponiblesObject=new Object();
			this.existenciasdisponiblessObject=new ArrayList<Object>();
			
			this.existenciasdisponiblesDataAccess=this;
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
			this.existenciasdisponiblesDataAccess.setConnexionType(this.connexionType);
			this.existenciasdisponiblesDataAccess.setParameterDbType(this.parameterDbType);
			this.existenciasdisponiblesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ExistenciasDisponiblesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.existenciasdisponibless= new ArrayList<ExistenciasDisponibles>();
			this.existenciasdisponibles= new ExistenciasDisponibles();
			this.existenciasdisponiblesObject=new Object();
			this.existenciasdisponiblessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.existenciasdisponiblesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.existenciasdisponiblesDataAccess.setConnexionType(this.connexionType);
			this.existenciasdisponiblesDataAccess.setParameterDbType(this.parameterDbType);
			this.existenciasdisponiblesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ExistenciasDisponibles getExistenciasDisponibles() throws Exception {	
		ExistenciasDisponiblesLogicAdditional.checkExistenciasDisponiblesToGet(existenciasdisponibles,this.datosCliente,this.arrDatoGeneral);
		ExistenciasDisponiblesLogicAdditional.updateExistenciasDisponiblesToGet(existenciasdisponibles,this.arrDatoGeneral);
		
		return existenciasdisponibles;
	}
		
	public void setExistenciasDisponibles(ExistenciasDisponibles newExistenciasDisponibles) {
		this.existenciasdisponibles = newExistenciasDisponibles;
	}
	
	public List<ExistenciasDisponibles> getExistenciasDisponibless() throws Exception {		
		this.quitarExistenciasDisponiblessNulos();
		
		ExistenciasDisponiblesLogicAdditional.checkExistenciasDisponiblesToGets(existenciasdisponibless,this.datosCliente,this.arrDatoGeneral);
		
		for (ExistenciasDisponibles existenciasdisponiblesLocal: existenciasdisponibless ) {
			ExistenciasDisponiblesLogicAdditional.updateExistenciasDisponiblesToGet(existenciasdisponiblesLocal,this.arrDatoGeneral);
		}
		
		return existenciasdisponibless;
	}
	
	public void setExistenciasDisponibless(List<ExistenciasDisponibles> newExistenciasDisponibless) {
		this.existenciasdisponibless = newExistenciasDisponibless;
	}
	
	public Object getExistenciasDisponiblesObject() {	
		//this.existenciasdisponiblesObject=this.existenciasdisponiblesDataAccess.getEntityObject();
		return this.existenciasdisponiblesObject;
	}
		
	public void setExistenciasDisponiblesObject(Object newExistenciasDisponiblesObject) {
		this.existenciasdisponiblesObject = newExistenciasDisponiblesObject;
	}
	
	public List<Object> getExistenciasDisponiblessObject() {		
		//this.existenciasdisponiblessObject=this.existenciasdisponiblesDataAccess.getEntitiesObject();
		return this.existenciasdisponiblessObject;
	}
		
	public void setExistenciasDisponiblessObject(List<Object> newExistenciasDisponiblessObject) {
		this.existenciasdisponiblessObject = newExistenciasDisponiblessObject;
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
		existenciasdisponibless = new  ArrayList<ExistenciasDisponibles>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ExistenciasDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			existenciasdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		existenciasdisponibless = new  ArrayList<ExistenciasDisponibles>();
		  		  
        try {
			//ExistenciasDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			existenciasdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		existenciasdisponibless = new  ArrayList<ExistenciasDisponibles>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ExistenciasDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			existenciasdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		existenciasdisponibless = new  ArrayList<ExistenciasDisponibles>();
		  		  
        try {
			//ExistenciasDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			existenciasdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		existenciasdisponibless = new  ArrayList<ExistenciasDisponibles>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ExistenciasDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			existenciasdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		existenciasdisponibless = new  ArrayList<ExistenciasDisponibles>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ExistenciasDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			existenciasdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ExistenciasDisponibles> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ExistenciasDisponibles> entities = new  ArrayList<ExistenciasDisponibles>();
		ExistenciasDisponibles entity = new ExistenciasDisponibles();		  
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
	
	public  List<ExistenciasDisponibles> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ExistenciasDisponibles> entities = new  ArrayList<ExistenciasDisponibles>();
		ExistenciasDisponibles entity = new ExistenciasDisponibles();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ExistenciasDisponibles();
				
				
      	    	entity=ExistenciasDisponiblesLogic.getEntityExistenciasDisponibles("",entity,resultSet);
      	    	
				//entity.setExistenciasDisponiblesOriginal( new ExistenciasDisponibles());
      	    	//entity.setExistenciasDisponiblesOriginal(super.getEntity("",entity.getExistenciasDisponiblesOriginal(),resultSet,ExistenciasDisponiblesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setExistenciasDisponiblesOriginal(ExistenciasDisponiblesDataAccess.getEntityExistenciasDisponibles("",entity.getExistenciasDisponiblesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ExistenciasDisponibles> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ExistenciasDisponibles> entities = new  ArrayList<ExistenciasDisponibles>();
		ExistenciasDisponibles entity = new ExistenciasDisponibles();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ExistenciasDisponibles.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ExistenciasDisponibles>((List<ExistenciasDisponibles>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setExistenciasDisponiblessOriginal(entities);
			
			}  else {
				this.existenciasdisponiblessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ExistenciasDisponiblesConstantesFunciones.quitarEspaciosExistenciasDisponibless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ExistenciasDisponibles getEntityExistenciasDisponibles(String strPrefijo,ExistenciasDisponibles entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ExistenciasDisponiblesConstantesFunciones.CODIGO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ExistenciasDisponiblesConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad_disponible(resultSet.getInt(strPrefijo+ExistenciasDisponiblesConstantesFunciones.CANTIDADDISPONIBLE));
			entity.setcantidad_fisica(resultSet.getInt(strPrefijo+ExistenciasDisponiblesConstantesFunciones.CANTIDADFISICA));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+ExistenciasDisponiblesConstantesFunciones.CODIGOPRODUCTO));
			entity.setnombre(resultSet.getString(strPrefijo+ExistenciasDisponiblesConstantesFunciones.NOMBRE));
			entity.setingresos(resultSet.getDouble(strPrefijo+ExistenciasDisponiblesConstantesFunciones.INGRESOS));
			entity.setegresos(resultSet.getDouble(strPrefijo+ExistenciasDisponiblesConstantesFunciones.EGRESOS));
			entity.setdisponible_corte(resultSet.getDouble(strPrefijo+ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE));
			entity.setdiferencia(resultSet.getDouble(strPrefijo+ExistenciasDisponiblesConstantesFunciones.DIFERENCIA));
			entity.setdestino(resultSet.getDouble(strPrefijo+ExistenciasDisponiblesConstantesFunciones.DESTINO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ExistenciasDisponibles getEntityExistenciasDisponibles(String strPrefijo,ExistenciasDisponibles entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ExistenciasDisponibles.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ExistenciasDisponibles.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ExistenciasDisponiblesLogic.setFieldReflectionExistenciasDisponibles(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionExistenciasDisponibles(Field field,String strPrefijo,String sColumn,ExistenciasDisponibles entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ExistenciasDisponiblesConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.CANTIDADDISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.CANTIDADFISICA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.CODIGOPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.INGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.EGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.DIFERENCIA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ExistenciasDisponiblesConstantesFunciones.DESTINO:
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
	
	public void quitarExistenciasDisponiblessNulos() throws Exception {				
		
		List<ExistenciasDisponibles> existenciasdisponiblessAux= new ArrayList<ExistenciasDisponibles>();
		
		for(ExistenciasDisponibles existenciasdisponibles:existenciasdisponibless) {
			if(existenciasdisponibles!=null) {
				existenciasdisponiblessAux.add(existenciasdisponibles);
			}
		}
		
		existenciasdisponibless=existenciasdisponiblessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ExistenciasDisponibles> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ExistenciasDisponibles> entities = new  ArrayList<ExistenciasDisponibles>();
		ExistenciasDisponibles entity = new ExistenciasDisponibles();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ExistenciasDisponibles>((List<ExistenciasDisponibles>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setExistenciasDisponiblessOriginal(entities);
			
			}  else {
				this.existenciasdisponiblessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ExistenciasDisponiblesConstantesFunciones.quitarEspaciosExistenciasDisponibless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		existenciasdisponibless = new  ArrayList<ExistenciasDisponibles>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ExistenciasDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			existenciasdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		existenciasdisponibless = new  ArrayList<ExistenciasDisponibles>();
		  		  
        try {
			//ExistenciasDisponiblesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			existenciasdisponibless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ExistenciasDisponibles> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ExistenciasDisponibles> entities = new  ArrayList<ExistenciasDisponibles>();
		ExistenciasDisponibles entity = new ExistenciasDisponibles();		  
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
	
	public  List<ExistenciasDisponibles> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ExistenciasDisponibles> entities = new  ArrayList<ExistenciasDisponibles>();
		ExistenciasDisponibles entity = new ExistenciasDisponibles();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ExistenciasDisponibles();
				
				if(conMapGenerico) {
					entity.setMapExistenciasDisponibles( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapExistenciasDisponibles().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ExistenciasDisponiblesDataAccess.ISWITHSCHEMA);         		
					entity=ExistenciasDisponiblesLogic.getEntityExistenciasDisponibles("",entity,resultSet,listColumns);
					
					////entity.setExistenciasDisponiblesOriginal( new ExistenciasDisponibles());
					////entity.setExistenciasDisponiblesOriginal(super.getEntity("",entity.getExistenciasDisponiblesOriginal(),resultSet,ExistenciasDisponiblesDataAccess.ISWITHSCHEMA));         		
					////entity.setExistenciasDisponiblesOriginal(ExistenciasDisponiblesDataAccess.getEntityExistenciasDisponibles("",entity.getExistenciasDisponiblesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,ExistenciasDisponibles relexistenciasdisponibles)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relexistenciasdisponibles.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ExistenciasDisponibles relexistenciasdisponibles)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relexistenciasdisponibles.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,ExistenciasDisponibles relexistenciasdisponibles)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relexistenciasdisponibles.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ExistenciasDisponibles relexistenciasdisponibles)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relexistenciasdisponibles.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,ExistenciasDisponibles relexistenciasdisponibles)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relexistenciasdisponibles.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ExistenciasDisponibles relexistenciasdisponibles)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relexistenciasdisponibles.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ExistenciasDisponibles relexistenciasdisponibles)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relexistenciasdisponibles.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ExistenciasDisponibles relexistenciasdisponibles)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relexistenciasdisponibles.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getExistenciasDisponiblessBusquedaExistenciasDisponiblesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//ExistenciasDisponiblesLogic existenciasdisponiblesLogic=new ExistenciasDisponiblesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ExistenciasDisponiblesLogic.GetSelecSqlExistenciasDisponibles(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.existenciasdisponibless=this.getExistenciasDisponibless();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getExistenciasDisponiblessBusquedaExistenciasDisponibles(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//ExistenciasDisponiblesLogic existenciasdisponiblesLogic=new ExistenciasDisponiblesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ExistenciasDisponiblesLogic.GetSelecSqlExistenciasDisponibles(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.existenciasdisponibless=this.getExistenciasDisponibless();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlExistenciasDisponibles(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ExistenciasDisponibles_Postgres.sql");
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
	
	
	public void deepLoad(ExistenciasDisponibles existenciasdisponibles,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ExistenciasDisponiblesLogicAdditional.updateExistenciasDisponiblesToGet(existenciasdisponibles,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		existenciasdisponibles.setBodega(existenciasdisponiblesDataAccess.getBodega(connexion,existenciasdisponibles));
		existenciasdisponibles.setProducto(existenciasdisponiblesDataAccess.getProducto(connexion,existenciasdisponibles));
		existenciasdisponibles.setEmpresa(existenciasdisponiblesDataAccess.getEmpresa(connexion,existenciasdisponibles));
		existenciasdisponibles.setSucursal(existenciasdisponiblesDataAccess.getSucursal(connexion,existenciasdisponibles));
		existenciasdisponibles.setLinea(existenciasdisponiblesDataAccess.getLinea(connexion,existenciasdisponibles));
		existenciasdisponibles.setLineaGrupo(existenciasdisponiblesDataAccess.getLineaGrupo(connexion,existenciasdisponibles));
		existenciasdisponibles.setLineaCategoria(existenciasdisponiblesDataAccess.getLineaCategoria(connexion,existenciasdisponibles));
		existenciasdisponibles.setLineaMarca(existenciasdisponiblesDataAccess.getLineaMarca(connexion,existenciasdisponibles));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existenciasdisponibles.setBodega(existenciasdisponiblesDataAccess.getBodega(connexion,existenciasdisponibles));
			}

			if(clas.clas.equals(Producto.class)) {
				existenciasdisponibles.setProducto(existenciasdisponiblesDataAccess.getProducto(connexion,existenciasdisponibles));
			}

			if(clas.clas.equals(Empresa.class)) {
				existenciasdisponibles.setEmpresa(existenciasdisponiblesDataAccess.getEmpresa(connexion,existenciasdisponibles));
			}

			if(clas.clas.equals(Sucursal.class)) {
				existenciasdisponibles.setSucursal(existenciasdisponiblesDataAccess.getSucursal(connexion,existenciasdisponibles));
			}

			if(clas.clas.equals(Linea.class)) {
				existenciasdisponibles.setLinea(existenciasdisponiblesDataAccess.getLinea(connexion,existenciasdisponibles));
			}

			if(clas.clas.equals(Linea.class)) {
				existenciasdisponibles.setLineaGrupo(existenciasdisponiblesDataAccess.getLineaGrupo(connexion,existenciasdisponibles));
			}

			if(clas.clas.equals(Linea.class)) {
				existenciasdisponibles.setLineaCategoria(existenciasdisponiblesDataAccess.getLineaCategoria(connexion,existenciasdisponibles));
			}

			if(clas.clas.equals(Linea.class)) {
				existenciasdisponibles.setLineaMarca(existenciasdisponiblesDataAccess.getLineaMarca(connexion,existenciasdisponibles));
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
			existenciasdisponibles.setBodega(existenciasdisponiblesDataAccess.getBodega(connexion,existenciasdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setProducto(existenciasdisponiblesDataAccess.getProducto(connexion,existenciasdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setEmpresa(existenciasdisponiblesDataAccess.getEmpresa(connexion,existenciasdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setSucursal(existenciasdisponiblesDataAccess.getSucursal(connexion,existenciasdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setLinea(existenciasdisponiblesDataAccess.getLinea(connexion,existenciasdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setLineaGrupo(existenciasdisponiblesDataAccess.getLineaGrupo(connexion,existenciasdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setLineaCategoria(existenciasdisponiblesDataAccess.getLineaCategoria(connexion,existenciasdisponibles));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setLineaMarca(existenciasdisponiblesDataAccess.getLineaMarca(connexion,existenciasdisponibles));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		existenciasdisponibles.setBodega(existenciasdisponiblesDataAccess.getBodega(connexion,existenciasdisponibles));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(existenciasdisponibles.getBodega(),isDeep,deepLoadType,clases);
				
		existenciasdisponibles.setProducto(existenciasdisponiblesDataAccess.getProducto(connexion,existenciasdisponibles));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(existenciasdisponibles.getProducto(),isDeep,deepLoadType,clases);
				
		existenciasdisponibles.setEmpresa(existenciasdisponiblesDataAccess.getEmpresa(connexion,existenciasdisponibles));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(existenciasdisponibles.getEmpresa(),isDeep,deepLoadType,clases);
				
		existenciasdisponibles.setSucursal(existenciasdisponiblesDataAccess.getSucursal(connexion,existenciasdisponibles));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(existenciasdisponibles.getSucursal(),isDeep,deepLoadType,clases);
				
		existenciasdisponibles.setLinea(existenciasdisponiblesDataAccess.getLinea(connexion,existenciasdisponibles));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(existenciasdisponibles.getLinea(),isDeep,deepLoadType,clases);
				
		existenciasdisponibles.setLineaGrupo(existenciasdisponiblesDataAccess.getLineaGrupo(connexion,existenciasdisponibles));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(existenciasdisponibles.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		existenciasdisponibles.setLineaCategoria(existenciasdisponiblesDataAccess.getLineaCategoria(connexion,existenciasdisponibles));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(existenciasdisponibles.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		existenciasdisponibles.setLineaMarca(existenciasdisponiblesDataAccess.getLineaMarca(connexion,existenciasdisponibles));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(existenciasdisponibles.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existenciasdisponibles.setBodega(existenciasdisponiblesDataAccess.getBodega(connexion,existenciasdisponibles));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(existenciasdisponibles.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				existenciasdisponibles.setProducto(existenciasdisponiblesDataAccess.getProducto(connexion,existenciasdisponibles));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(existenciasdisponibles.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				existenciasdisponibles.setEmpresa(existenciasdisponiblesDataAccess.getEmpresa(connexion,existenciasdisponibles));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(existenciasdisponibles.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				existenciasdisponibles.setSucursal(existenciasdisponiblesDataAccess.getSucursal(connexion,existenciasdisponibles));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(existenciasdisponibles.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				existenciasdisponibles.setLinea(existenciasdisponiblesDataAccess.getLinea(connexion,existenciasdisponibles));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(existenciasdisponibles.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				existenciasdisponibles.setLineaGrupo(existenciasdisponiblesDataAccess.getLineaGrupo(connexion,existenciasdisponibles));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(existenciasdisponibles.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				existenciasdisponibles.setLineaCategoria(existenciasdisponiblesDataAccess.getLineaCategoria(connexion,existenciasdisponibles));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(existenciasdisponibles.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				existenciasdisponibles.setLineaMarca(existenciasdisponiblesDataAccess.getLineaMarca(connexion,existenciasdisponibles));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(existenciasdisponibles.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			existenciasdisponibles.setBodega(existenciasdisponiblesDataAccess.getBodega(connexion,existenciasdisponibles));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(existenciasdisponibles.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setProducto(existenciasdisponiblesDataAccess.getProducto(connexion,existenciasdisponibles));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(existenciasdisponibles.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setEmpresa(existenciasdisponiblesDataAccess.getEmpresa(connexion,existenciasdisponibles));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(existenciasdisponibles.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setSucursal(existenciasdisponiblesDataAccess.getSucursal(connexion,existenciasdisponibles));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(existenciasdisponibles.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setLinea(existenciasdisponiblesDataAccess.getLinea(connexion,existenciasdisponibles));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(existenciasdisponibles.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setLineaGrupo(existenciasdisponiblesDataAccess.getLineaGrupo(connexion,existenciasdisponibles));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(existenciasdisponibles.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setLineaCategoria(existenciasdisponiblesDataAccess.getLineaCategoria(connexion,existenciasdisponibles));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(existenciasdisponibles.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			existenciasdisponibles.setLineaMarca(existenciasdisponiblesDataAccess.getLineaMarca(connexion,existenciasdisponibles));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(existenciasdisponibles.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(existenciasdisponibles,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ExistenciasDisponiblesConstantesFunciones.refrescarForeignKeysDescripcionesExistenciasDisponibles(existenciasdisponibles);
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
			this.deepLoad(this.existenciasdisponibles,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ExistenciasDisponiblesConstantesFunciones.refrescarForeignKeysDescripcionesExistenciasDisponibles(this.existenciasdisponibles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(existenciasdisponibless!=null) {
				for(ExistenciasDisponibles existenciasdisponibles:existenciasdisponibless) {
					this.deepLoad(existenciasdisponibles,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ExistenciasDisponiblesConstantesFunciones.refrescarForeignKeysDescripcionesExistenciasDisponibles(existenciasdisponibless);
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
			if(existenciasdisponibless!=null) {
				for(ExistenciasDisponibles existenciasdisponibles:existenciasdisponibless) {
					this.deepLoad(existenciasdisponibles,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ExistenciasDisponiblesConstantesFunciones.refrescarForeignKeysDescripcionesExistenciasDisponibles(existenciasdisponibless);
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
	
	public ExistenciasDisponiblesParameterReturnGeneral procesarAccionExistenciasDisponibless(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ExistenciasDisponibles> existenciasdisponibless,ExistenciasDisponiblesParameterReturnGeneral existenciasdisponiblesParameterGeneral)throws Exception {
		 try {	
			ExistenciasDisponiblesParameterReturnGeneral existenciasdisponiblesReturnGeneral=new ExistenciasDisponiblesParameterReturnGeneral();
	
			ExistenciasDisponiblesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,existenciasdisponibless,existenciasdisponiblesParameterGeneral,existenciasdisponiblesReturnGeneral);
			
			return existenciasdisponiblesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ExistenciasDisponiblesParameterReturnGeneral procesarAccionExistenciasDisponiblessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ExistenciasDisponibles> existenciasdisponibless,ExistenciasDisponiblesParameterReturnGeneral existenciasdisponiblesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ExistenciasDisponiblesParameterReturnGeneral existenciasdisponiblesReturnGeneral=new ExistenciasDisponiblesParameterReturnGeneral();
	
			ExistenciasDisponiblesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,existenciasdisponibless,existenciasdisponiblesParameterGeneral,existenciasdisponiblesReturnGeneral);
			
			this.connexion.commit();
			
			return existenciasdisponiblesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

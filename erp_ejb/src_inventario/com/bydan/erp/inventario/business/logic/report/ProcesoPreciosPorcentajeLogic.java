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
import com.bydan.erp.inventario.util.report.ProcesoPreciosPorcentajeParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoPreciosPorcentajeParameterGeneral;
import com.bydan.erp.inventario.util.report.ProcesoPreciosPorcentajeConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProcesoPreciosPorcentaje;

import com.bydan.erp.inventario.business.logic.report.ProcesoPreciosPorcentajeLogicAdditional;
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
public class ProcesoPreciosPorcentajeLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoPreciosPorcentajeLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoPreciosPorcentajeLogic procesopreciosporcentajeDataAccess; 		
	protected ProcesoPreciosPorcentaje procesopreciosporcentaje;
	protected List<ProcesoPreciosPorcentaje> procesopreciosporcentajes;
	protected Object procesopreciosporcentajeObject;	
	protected List<Object> procesopreciosporcentajesObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoPreciosPorcentajeLogic()throws SQLException,Exception {
		try	{
			this.procesopreciosporcentajes= new ArrayList<ProcesoPreciosPorcentaje>();
			this.procesopreciosporcentaje= new ProcesoPreciosPorcentaje();
			this.procesopreciosporcentajeObject=new Object();
			this.procesopreciosporcentajesObject=new ArrayList<Object>();
			
			this.procesopreciosporcentajeDataAccess=this;
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
			this.procesopreciosporcentajeDataAccess.setConnexionType(this.connexionType);
			this.procesopreciosporcentajeDataAccess.setParameterDbType(this.parameterDbType);
			this.procesopreciosporcentajeDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoPreciosPorcentajeLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesopreciosporcentajes= new ArrayList<ProcesoPreciosPorcentaje>();
			this.procesopreciosporcentaje= new ProcesoPreciosPorcentaje();
			this.procesopreciosporcentajeObject=new Object();
			this.procesopreciosporcentajesObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesopreciosporcentajeDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesopreciosporcentajeDataAccess.setConnexionType(this.connexionType);
			this.procesopreciosporcentajeDataAccess.setParameterDbType(this.parameterDbType);
			this.procesopreciosporcentajeDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoPreciosPorcentaje getProcesoPreciosPorcentaje() throws Exception {	
		ProcesoPreciosPorcentajeLogicAdditional.checkProcesoPreciosPorcentajeToGet(procesopreciosporcentaje,this.datosCliente,this.arrDatoGeneral);
		ProcesoPreciosPorcentajeLogicAdditional.updateProcesoPreciosPorcentajeToGet(procesopreciosporcentaje,this.arrDatoGeneral);
		
		return procesopreciosporcentaje;
	}
		
	public void setProcesoPreciosPorcentaje(ProcesoPreciosPorcentaje newProcesoPreciosPorcentaje) {
		this.procesopreciosporcentaje = newProcesoPreciosPorcentaje;
	}
	
	public List<ProcesoPreciosPorcentaje> getProcesoPreciosPorcentajes() throws Exception {		
		this.quitarProcesoPreciosPorcentajesNulos();
		
		ProcesoPreciosPorcentajeLogicAdditional.checkProcesoPreciosPorcentajeToGets(procesopreciosporcentajes,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoPreciosPorcentaje procesopreciosporcentajeLocal: procesopreciosporcentajes ) {
			ProcesoPreciosPorcentajeLogicAdditional.updateProcesoPreciosPorcentajeToGet(procesopreciosporcentajeLocal,this.arrDatoGeneral);
		}
		
		return procesopreciosporcentajes;
	}
	
	public void setProcesoPreciosPorcentajes(List<ProcesoPreciosPorcentaje> newProcesoPreciosPorcentajes) {
		this.procesopreciosporcentajes = newProcesoPreciosPorcentajes;
	}
	
	public Object getProcesoPreciosPorcentajeObject() {	
		//this.procesopreciosporcentajeObject=this.procesopreciosporcentajeDataAccess.getEntityObject();
		return this.procesopreciosporcentajeObject;
	}
		
	public void setProcesoPreciosPorcentajeObject(Object newProcesoPreciosPorcentajeObject) {
		this.procesopreciosporcentajeObject = newProcesoPreciosPorcentajeObject;
	}
	
	public List<Object> getProcesoPreciosPorcentajesObject() {		
		//this.procesopreciosporcentajesObject=this.procesopreciosporcentajeDataAccess.getEntitiesObject();
		return this.procesopreciosporcentajesObject;
	}
		
	public void setProcesoPreciosPorcentajesObject(List<Object> newProcesoPreciosPorcentajesObject) {
		this.procesopreciosporcentajesObject = newProcesoPreciosPorcentajesObject;
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
		procesopreciosporcentajes = new  ArrayList<ProcesoPreciosPorcentaje>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoPreciosPorcentajeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosporcentajes=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesopreciosporcentajes = new  ArrayList<ProcesoPreciosPorcentaje>();
		  		  
        try {
			//ProcesoPreciosPorcentajeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosporcentajes=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesopreciosporcentajes = new  ArrayList<ProcesoPreciosPorcentaje>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoPreciosPorcentajeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosporcentajes=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesopreciosporcentajes = new  ArrayList<ProcesoPreciosPorcentaje>();
		  		  
        try {
			//ProcesoPreciosPorcentajeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosporcentajes=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesopreciosporcentajes = new  ArrayList<ProcesoPreciosPorcentaje>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoPreciosPorcentajeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosporcentajes=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesopreciosporcentajes = new  ArrayList<ProcesoPreciosPorcentaje>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoPreciosPorcentajeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosporcentajes=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoPreciosPorcentaje> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoPreciosPorcentaje> entities = new  ArrayList<ProcesoPreciosPorcentaje>();
		ProcesoPreciosPorcentaje entity = new ProcesoPreciosPorcentaje();		  
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
	
	public  List<ProcesoPreciosPorcentaje> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoPreciosPorcentaje> entities = new  ArrayList<ProcesoPreciosPorcentaje>();
		ProcesoPreciosPorcentaje entity = new ProcesoPreciosPorcentaje();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoPreciosPorcentaje();
				
				
      	    	entity=ProcesoPreciosPorcentajeLogic.getEntityProcesoPreciosPorcentaje("",entity,resultSet);
      	    	
				//entity.setProcesoPreciosPorcentajeOriginal( new ProcesoPreciosPorcentaje());
      	    	//entity.setProcesoPreciosPorcentajeOriginal(super.getEntity("",entity.getProcesoPreciosPorcentajeOriginal(),resultSet,ProcesoPreciosPorcentajeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoPreciosPorcentajeOriginal(ProcesoPreciosPorcentajeDataAccess.getEntityProcesoPreciosPorcentaje("",entity.getProcesoPreciosPorcentajeOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoPreciosPorcentaje> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoPreciosPorcentaje> entities = new  ArrayList<ProcesoPreciosPorcentaje>();
		ProcesoPreciosPorcentaje entity = new ProcesoPreciosPorcentaje();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoPreciosPorcentaje.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoPreciosPorcentaje>((List<ProcesoPreciosPorcentaje>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoPreciosPorcentajesOriginal(entities);
			
			}  else {
				this.procesopreciosporcentajesObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoPreciosPorcentajeConstantesFunciones.quitarEspaciosProcesoPreciosPorcentajes(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoPreciosPorcentaje getEntityProcesoPreciosPorcentaje(String strPrefijo,ProcesoPreciosPorcentaje entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ProcesoPreciosPorcentajeConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+ProcesoPreciosPorcentajeConstantesFunciones.NOMBRE));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+ProcesoPreciosPorcentajeConstantesFunciones.CODIGOPRODUCTO));
			entity.setnombre_producto(resultSet.getString(strPrefijo+ProcesoPreciosPorcentajeConstantesFunciones.NOMBREPRODUCTO));
			entity.setprecio(resultSet.getDouble(strPrefijo+ProcesoPreciosPorcentajeConstantesFunciones.PRECIO));
			entity.setporcentaje(resultSet.getDouble(strPrefijo+ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoPreciosPorcentaje getEntityProcesoPreciosPorcentaje(String strPrefijo,ProcesoPreciosPorcentaje entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoPreciosPorcentaje.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoPreciosPorcentaje.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoPreciosPorcentajeLogic.setFieldReflectionProcesoPreciosPorcentaje(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoPreciosPorcentaje(Field field,String strPrefijo,String sColumn,ProcesoPreciosPorcentaje entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoPreciosPorcentajeConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoPreciosPorcentajeConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoPreciosPorcentajeConstantesFunciones.CODIGOPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoPreciosPorcentajeConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoPreciosPorcentajeConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE:
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
	
	public void quitarProcesoPreciosPorcentajesNulos() throws Exception {				
		
		List<ProcesoPreciosPorcentaje> procesopreciosporcentajesAux= new ArrayList<ProcesoPreciosPorcentaje>();
		
		for(ProcesoPreciosPorcentaje procesopreciosporcentaje:procesopreciosporcentajes) {
			if(procesopreciosporcentaje!=null) {
				procesopreciosporcentajesAux.add(procesopreciosporcentaje);
			}
		}
		
		procesopreciosporcentajes=procesopreciosporcentajesAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoPreciosPorcentaje> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoPreciosPorcentaje> entities = new  ArrayList<ProcesoPreciosPorcentaje>();
		ProcesoPreciosPorcentaje entity = new ProcesoPreciosPorcentaje();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoPreciosPorcentaje>((List<ProcesoPreciosPorcentaje>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoPreciosPorcentajesOriginal(entities);
			
			}  else {
				this.procesopreciosporcentajesObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoPreciosPorcentajeConstantesFunciones.quitarEspaciosProcesoPreciosPorcentajes(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesopreciosporcentajes = new  ArrayList<ProcesoPreciosPorcentaje>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoPreciosPorcentajeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosporcentajes=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesopreciosporcentajes = new  ArrayList<ProcesoPreciosPorcentaje>();
		  		  
        try {
			//ProcesoPreciosPorcentajeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosporcentajes=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoPreciosPorcentaje> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoPreciosPorcentaje> entities = new  ArrayList<ProcesoPreciosPorcentaje>();
		ProcesoPreciosPorcentaje entity = new ProcesoPreciosPorcentaje();		  
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
	
	public  List<ProcesoPreciosPorcentaje> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoPreciosPorcentaje> entities = new  ArrayList<ProcesoPreciosPorcentaje>();
		ProcesoPreciosPorcentaje entity = new ProcesoPreciosPorcentaje();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoPreciosPorcentaje();
				
				if(conMapGenerico) {
					entity.setMapProcesoPreciosPorcentaje( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoPreciosPorcentaje().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoPreciosPorcentajeDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoPreciosPorcentajeLogic.getEntityProcesoPreciosPorcentaje("",entity,resultSet,listColumns);
					
					////entity.setProcesoPreciosPorcentajeOriginal( new ProcesoPreciosPorcentaje());
					////entity.setProcesoPreciosPorcentajeOriginal(super.getEntity("",entity.getProcesoPreciosPorcentajeOriginal(),resultSet,ProcesoPreciosPorcentajeDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoPreciosPorcentajeOriginal(ProcesoPreciosPorcentajeDataAccess.getEntityProcesoPreciosPorcentaje("",entity.getProcesoPreciosPorcentajeOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,ProcesoPreciosPorcentaje relprocesopreciosporcentaje)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relprocesopreciosporcentaje.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProcesoPreciosPorcentaje relprocesopreciosporcentaje)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relprocesopreciosporcentaje.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,ProcesoPreciosPorcentaje relprocesopreciosporcentaje)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relprocesopreciosporcentaje.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProcesoPreciosPorcentaje relprocesopreciosporcentaje)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relprocesopreciosporcentaje.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,ProcesoPreciosPorcentaje relprocesopreciosporcentaje)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesopreciosporcentaje.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProcesoPreciosPorcentaje relprocesopreciosporcentaje)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesopreciosporcentaje.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProcesoPreciosPorcentaje relprocesopreciosporcentaje)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesopreciosporcentaje.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProcesoPreciosPorcentaje relprocesopreciosporcentaje)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesopreciosporcentaje.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getProcesoPreciosPorcentajesBusquedaProcesoPreciosPorcentajeWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoPreciosPorcentajeLogic procesopreciosporcentajeLogic=new ProcesoPreciosPorcentajeLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoPreciosPorcentajeLogic.GetSelecSqlProcesoPreciosPorcentaje(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesopreciosporcentajes=this.getProcesoPreciosPorcentajes();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoPreciosPorcentajesBusquedaProcesoPreciosPorcentaje(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoPreciosPorcentajeLogic procesopreciosporcentajeLogic=new ProcesoPreciosPorcentajeLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoPreciosPorcentajeLogic.GetSelecSqlProcesoPreciosPorcentaje(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesopreciosporcentajes=this.getProcesoPreciosPorcentajes();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoPreciosPorcentaje(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoPreciosPorcentaje_Postgres.sql");
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
	
	
	public void deepLoad(ProcesoPreciosPorcentaje procesopreciosporcentaje,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoPreciosPorcentajeLogicAdditional.updateProcesoPreciosPorcentajeToGet(procesopreciosporcentaje,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesopreciosporcentaje.setBodega(procesopreciosporcentajeDataAccess.getBodega(connexion,procesopreciosporcentaje));
		procesopreciosporcentaje.setProducto(procesopreciosporcentajeDataAccess.getProducto(connexion,procesopreciosporcentaje));
		procesopreciosporcentaje.setEmpresa(procesopreciosporcentajeDataAccess.getEmpresa(connexion,procesopreciosporcentaje));
		procesopreciosporcentaje.setSucursal(procesopreciosporcentajeDataAccess.getSucursal(connexion,procesopreciosporcentaje));
		procesopreciosporcentaje.setLinea(procesopreciosporcentajeDataAccess.getLinea(connexion,procesopreciosporcentaje));
		procesopreciosporcentaje.setLineaGrupo(procesopreciosporcentajeDataAccess.getLineaGrupo(connexion,procesopreciosporcentaje));
		procesopreciosporcentaje.setLineaCategoria(procesopreciosporcentajeDataAccess.getLineaCategoria(connexion,procesopreciosporcentaje));
		procesopreciosporcentaje.setLineaMarca(procesopreciosporcentajeDataAccess.getLineaMarca(connexion,procesopreciosporcentaje));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesopreciosporcentaje.setBodega(procesopreciosporcentajeDataAccess.getBodega(connexion,procesopreciosporcentaje));
			}

			if(clas.clas.equals(Producto.class)) {
				procesopreciosporcentaje.setProducto(procesopreciosporcentajeDataAccess.getProducto(connexion,procesopreciosporcentaje));
			}

			if(clas.clas.equals(Empresa.class)) {
				procesopreciosporcentaje.setEmpresa(procesopreciosporcentajeDataAccess.getEmpresa(connexion,procesopreciosporcentaje));
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesopreciosporcentaje.setSucursal(procesopreciosporcentajeDataAccess.getSucursal(connexion,procesopreciosporcentaje));
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosporcentaje.setLinea(procesopreciosporcentajeDataAccess.getLinea(connexion,procesopreciosporcentaje));
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosporcentaje.setLineaGrupo(procesopreciosporcentajeDataAccess.getLineaGrupo(connexion,procesopreciosporcentaje));
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosporcentaje.setLineaCategoria(procesopreciosporcentajeDataAccess.getLineaCategoria(connexion,procesopreciosporcentaje));
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosporcentaje.setLineaMarca(procesopreciosporcentajeDataAccess.getLineaMarca(connexion,procesopreciosporcentaje));
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
			procesopreciosporcentaje.setBodega(procesopreciosporcentajeDataAccess.getBodega(connexion,procesopreciosporcentaje));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setProducto(procesopreciosporcentajeDataAccess.getProducto(connexion,procesopreciosporcentaje));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setEmpresa(procesopreciosporcentajeDataAccess.getEmpresa(connexion,procesopreciosporcentaje));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setSucursal(procesopreciosporcentajeDataAccess.getSucursal(connexion,procesopreciosporcentaje));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setLinea(procesopreciosporcentajeDataAccess.getLinea(connexion,procesopreciosporcentaje));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setLineaGrupo(procesopreciosporcentajeDataAccess.getLineaGrupo(connexion,procesopreciosporcentaje));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setLineaCategoria(procesopreciosporcentajeDataAccess.getLineaCategoria(connexion,procesopreciosporcentaje));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setLineaMarca(procesopreciosporcentajeDataAccess.getLineaMarca(connexion,procesopreciosporcentaje));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesopreciosporcentaje.setBodega(procesopreciosporcentajeDataAccess.getBodega(connexion,procesopreciosporcentaje));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(procesopreciosporcentaje.getBodega(),isDeep,deepLoadType,clases);
				
		procesopreciosporcentaje.setProducto(procesopreciosporcentajeDataAccess.getProducto(connexion,procesopreciosporcentaje));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(procesopreciosporcentaje.getProducto(),isDeep,deepLoadType,clases);
				
		procesopreciosporcentaje.setEmpresa(procesopreciosporcentajeDataAccess.getEmpresa(connexion,procesopreciosporcentaje));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(procesopreciosporcentaje.getEmpresa(),isDeep,deepLoadType,clases);
				
		procesopreciosporcentaje.setSucursal(procesopreciosporcentajeDataAccess.getSucursal(connexion,procesopreciosporcentaje));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(procesopreciosporcentaje.getSucursal(),isDeep,deepLoadType,clases);
				
		procesopreciosporcentaje.setLinea(procesopreciosporcentajeDataAccess.getLinea(connexion,procesopreciosporcentaje));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(procesopreciosporcentaje.getLinea(),isDeep,deepLoadType,clases);
				
		procesopreciosporcentaje.setLineaGrupo(procesopreciosporcentajeDataAccess.getLineaGrupo(connexion,procesopreciosporcentaje));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(procesopreciosporcentaje.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		procesopreciosporcentaje.setLineaCategoria(procesopreciosporcentajeDataAccess.getLineaCategoria(connexion,procesopreciosporcentaje));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(procesopreciosporcentaje.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		procesopreciosporcentaje.setLineaMarca(procesopreciosporcentajeDataAccess.getLineaMarca(connexion,procesopreciosporcentaje));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(procesopreciosporcentaje.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesopreciosporcentaje.setBodega(procesopreciosporcentajeDataAccess.getBodega(connexion,procesopreciosporcentaje));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(procesopreciosporcentaje.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				procesopreciosporcentaje.setProducto(procesopreciosporcentajeDataAccess.getProducto(connexion,procesopreciosporcentaje));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(procesopreciosporcentaje.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				procesopreciosporcentaje.setEmpresa(procesopreciosporcentajeDataAccess.getEmpresa(connexion,procesopreciosporcentaje));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(procesopreciosporcentaje.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesopreciosporcentaje.setSucursal(procesopreciosporcentajeDataAccess.getSucursal(connexion,procesopreciosporcentaje));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(procesopreciosporcentaje.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosporcentaje.setLinea(procesopreciosporcentajeDataAccess.getLinea(connexion,procesopreciosporcentaje));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesopreciosporcentaje.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosporcentaje.setLineaGrupo(procesopreciosporcentajeDataAccess.getLineaGrupo(connexion,procesopreciosporcentaje));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesopreciosporcentaje.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosporcentaje.setLineaCategoria(procesopreciosporcentajeDataAccess.getLineaCategoria(connexion,procesopreciosporcentaje));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesopreciosporcentaje.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosporcentaje.setLineaMarca(procesopreciosporcentajeDataAccess.getLineaMarca(connexion,procesopreciosporcentaje));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesopreciosporcentaje.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			procesopreciosporcentaje.setBodega(procesopreciosporcentajeDataAccess.getBodega(connexion,procesopreciosporcentaje));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(procesopreciosporcentaje.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setProducto(procesopreciosporcentajeDataAccess.getProducto(connexion,procesopreciosporcentaje));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(procesopreciosporcentaje.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setEmpresa(procesopreciosporcentajeDataAccess.getEmpresa(connexion,procesopreciosporcentaje));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(procesopreciosporcentaje.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setSucursal(procesopreciosporcentajeDataAccess.getSucursal(connexion,procesopreciosporcentaje));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(procesopreciosporcentaje.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setLinea(procesopreciosporcentajeDataAccess.getLinea(connexion,procesopreciosporcentaje));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesopreciosporcentaje.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setLineaGrupo(procesopreciosporcentajeDataAccess.getLineaGrupo(connexion,procesopreciosporcentaje));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesopreciosporcentaje.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setLineaCategoria(procesopreciosporcentajeDataAccess.getLineaCategoria(connexion,procesopreciosporcentaje));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesopreciosporcentaje.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosporcentaje.setLineaMarca(procesopreciosporcentajeDataAccess.getLineaMarca(connexion,procesopreciosporcentaje));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesopreciosporcentaje.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesopreciosporcentaje,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoPreciosPorcentajeConstantesFunciones.refrescarForeignKeysDescripcionesProcesoPreciosPorcentaje(procesopreciosporcentaje);
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
			this.deepLoad(this.procesopreciosporcentaje,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoPreciosPorcentajeConstantesFunciones.refrescarForeignKeysDescripcionesProcesoPreciosPorcentaje(this.procesopreciosporcentaje);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesopreciosporcentajes!=null) {
				for(ProcesoPreciosPorcentaje procesopreciosporcentaje:procesopreciosporcentajes) {
					this.deepLoad(procesopreciosporcentaje,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoPreciosPorcentajeConstantesFunciones.refrescarForeignKeysDescripcionesProcesoPreciosPorcentaje(procesopreciosporcentajes);
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
			if(procesopreciosporcentajes!=null) {
				for(ProcesoPreciosPorcentaje procesopreciosporcentaje:procesopreciosporcentajes) {
					this.deepLoad(procesopreciosporcentaje,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoPreciosPorcentajeConstantesFunciones.refrescarForeignKeysDescripcionesProcesoPreciosPorcentaje(procesopreciosporcentajes);
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
	
	public ProcesoPreciosPorcentajeParameterReturnGeneral procesarAccionProcesoPreciosPorcentajes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoPreciosPorcentaje> procesopreciosporcentajes,ProcesoPreciosPorcentajeParameterReturnGeneral procesopreciosporcentajeParameterGeneral)throws Exception {
		 try {	
			ProcesoPreciosPorcentajeParameterReturnGeneral procesopreciosporcentajeReturnGeneral=new ProcesoPreciosPorcentajeParameterReturnGeneral();
	
			ProcesoPreciosPorcentajeLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesopreciosporcentajes,procesopreciosporcentajeParameterGeneral,procesopreciosporcentajeReturnGeneral);
			
			return procesopreciosporcentajeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoPreciosPorcentajeParameterReturnGeneral procesarAccionProcesoPreciosPorcentajesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoPreciosPorcentaje> procesopreciosporcentajes,ProcesoPreciosPorcentajeParameterReturnGeneral procesopreciosporcentajeParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoPreciosPorcentajeParameterReturnGeneral procesopreciosporcentajeReturnGeneral=new ProcesoPreciosPorcentajeParameterReturnGeneral();
	
			ProcesoPreciosPorcentajeLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesopreciosporcentajes,procesopreciosporcentajeParameterGeneral,procesopreciosporcentajeReturnGeneral);
			
			this.connexion.commit();
			
			return procesopreciosporcentajeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

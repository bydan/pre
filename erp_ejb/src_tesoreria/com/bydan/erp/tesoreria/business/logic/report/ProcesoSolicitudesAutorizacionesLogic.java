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
package com.bydan.erp.tesoreria.business.logic.report;

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

import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.resources.general.AuxiliarGeneral;
import com.bydan.erp.tesoreria.util.report.ProcesoSolicitudesAutorizacionesParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ProcesoSolicitudesAutorizacionesParameterGeneral;
import com.bydan.erp.tesoreria.util.report.ProcesoSolicitudesAutorizacionesConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.ProcesoSolicitudesAutorizaciones;

import com.bydan.erp.tesoreria.business.logic.report.ProcesoSolicitudesAutorizacionesLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoSolicitudesAutorizacionesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoSolicitudesAutorizacionesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoSolicitudesAutorizacionesLogic procesosolicitudesautorizacionesDataAccess; 		
	protected ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones;
	protected List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness;
	protected Object procesosolicitudesautorizacionesObject;	
	protected List<Object> procesosolicitudesautorizacionessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoSolicitudesAutorizacionesLogic()throws SQLException,Exception {
		try	{
			this.procesosolicitudesautorizacioness= new ArrayList<ProcesoSolicitudesAutorizaciones>();
			this.procesosolicitudesautorizaciones= new ProcesoSolicitudesAutorizaciones();
			this.procesosolicitudesautorizacionesObject=new Object();
			this.procesosolicitudesautorizacionessObject=new ArrayList<Object>();
			
			this.procesosolicitudesautorizacionesDataAccess=this;
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
			this.procesosolicitudesautorizacionesDataAccess.setConnexionType(this.connexionType);
			this.procesosolicitudesautorizacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesosolicitudesautorizacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoSolicitudesAutorizacionesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesosolicitudesautorizacioness= new ArrayList<ProcesoSolicitudesAutorizaciones>();
			this.procesosolicitudesautorizaciones= new ProcesoSolicitudesAutorizaciones();
			this.procesosolicitudesautorizacionesObject=new Object();
			this.procesosolicitudesautorizacionessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesosolicitudesautorizacionesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesosolicitudesautorizacionesDataAccess.setConnexionType(this.connexionType);
			this.procesosolicitudesautorizacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesosolicitudesautorizacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoSolicitudesAutorizaciones getProcesoSolicitudesAutorizaciones() throws Exception {	
		ProcesoSolicitudesAutorizacionesLogicAdditional.checkProcesoSolicitudesAutorizacionesToGet(procesosolicitudesautorizaciones,this.datosCliente,this.arrDatoGeneral);
		ProcesoSolicitudesAutorizacionesLogicAdditional.updateProcesoSolicitudesAutorizacionesToGet(procesosolicitudesautorizaciones,this.arrDatoGeneral);
		
		return procesosolicitudesautorizaciones;
	}
		
	public void setProcesoSolicitudesAutorizaciones(ProcesoSolicitudesAutorizaciones newProcesoSolicitudesAutorizaciones) {
		this.procesosolicitudesautorizaciones = newProcesoSolicitudesAutorizaciones;
	}
	
	public List<ProcesoSolicitudesAutorizaciones> getProcesoSolicitudesAutorizacioness() throws Exception {		
		this.quitarProcesoSolicitudesAutorizacionessNulos();
		
		ProcesoSolicitudesAutorizacionesLogicAdditional.checkProcesoSolicitudesAutorizacionesToGets(procesosolicitudesautorizacioness,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesLocal: procesosolicitudesautorizacioness ) {
			ProcesoSolicitudesAutorizacionesLogicAdditional.updateProcesoSolicitudesAutorizacionesToGet(procesosolicitudesautorizacionesLocal,this.arrDatoGeneral);
		}
		
		return procesosolicitudesautorizacioness;
	}
	
	public void setProcesoSolicitudesAutorizacioness(List<ProcesoSolicitudesAutorizaciones> newProcesoSolicitudesAutorizacioness) {
		this.procesosolicitudesautorizacioness = newProcesoSolicitudesAutorizacioness;
	}
	
	public Object getProcesoSolicitudesAutorizacionesObject() {	
		//this.procesosolicitudesautorizacionesObject=this.procesosolicitudesautorizacionesDataAccess.getEntityObject();
		return this.procesosolicitudesautorizacionesObject;
	}
		
	public void setProcesoSolicitudesAutorizacionesObject(Object newProcesoSolicitudesAutorizacionesObject) {
		this.procesosolicitudesautorizacionesObject = newProcesoSolicitudesAutorizacionesObject;
	}
	
	public List<Object> getProcesoSolicitudesAutorizacionessObject() {		
		//this.procesosolicitudesautorizacionessObject=this.procesosolicitudesautorizacionesDataAccess.getEntitiesObject();
		return this.procesosolicitudesautorizacionessObject;
	}
		
	public void setProcesoSolicitudesAutorizacionessObject(List<Object> newProcesoSolicitudesAutorizacionessObject) {
		this.procesosolicitudesautorizacionessObject = newProcesoSolicitudesAutorizacionessObject;
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
		procesosolicitudesautorizacioness = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoSolicitudesAutorizacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosolicitudesautorizacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesosolicitudesautorizacioness = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		  		  
        try {
			//ProcesoSolicitudesAutorizacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosolicitudesautorizacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesosolicitudesautorizacioness = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoSolicitudesAutorizacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosolicitudesautorizacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesosolicitudesautorizacioness = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		  		  
        try {
			//ProcesoSolicitudesAutorizacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosolicitudesautorizacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesosolicitudesautorizacioness = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoSolicitudesAutorizacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosolicitudesautorizacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesosolicitudesautorizacioness = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoSolicitudesAutorizacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosolicitudesautorizacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoSolicitudesAutorizaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoSolicitudesAutorizaciones> entities = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		ProcesoSolicitudesAutorizaciones entity = new ProcesoSolicitudesAutorizaciones();		  
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
	
	public  List<ProcesoSolicitudesAutorizaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoSolicitudesAutorizaciones> entities = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		ProcesoSolicitudesAutorizaciones entity = new ProcesoSolicitudesAutorizaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoSolicitudesAutorizaciones();
				
				
      	    	entity=ProcesoSolicitudesAutorizacionesLogic.getEntityProcesoSolicitudesAutorizaciones("",entity,resultSet);
      	    	
				//entity.setProcesoSolicitudesAutorizacionesOriginal( new ProcesoSolicitudesAutorizaciones());
      	    	//entity.setProcesoSolicitudesAutorizacionesOriginal(super.getEntity("",entity.getProcesoSolicitudesAutorizacionesOriginal(),resultSet,ProcesoSolicitudesAutorizacionesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoSolicitudesAutorizacionesOriginal(ProcesoSolicitudesAutorizacionesDataAccess.getEntityProcesoSolicitudesAutorizaciones("",entity.getProcesoSolicitudesAutorizacionesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoSolicitudesAutorizaciones> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoSolicitudesAutorizaciones> entities = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		ProcesoSolicitudesAutorizaciones entity = new ProcesoSolicitudesAutorizaciones();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoSolicitudesAutorizaciones.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoSolicitudesAutorizaciones>((List<ProcesoSolicitudesAutorizaciones>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoSolicitudesAutorizacionessOriginal(entities);
			
			}  else {
				this.procesosolicitudesautorizacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoSolicitudesAutorizacionesConstantesFunciones.quitarEspaciosProcesoSolicitudesAutorizacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoSolicitudesAutorizaciones getEntityProcesoSolicitudesAutorizaciones(String strPrefijo,ProcesoSolicitudesAutorizaciones entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_moneda(resultSet.getString(strPrefijo+ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBREMONEDA));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setnumero_pre_impreso_factura(resultSet.getString(strPrefijo+ProcesoSolicitudesAutorizacionesConstantesFunciones.NUMEROPREIMPRESOFACTURA));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_pago(new Date(resultSet.getDate(strPrefijo+ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAPAGO).getTime()));
			entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTO).getTime()));
			entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONELOCAL));
			entity.setdebito_mone_extra(resultSet.getDouble(strPrefijo+ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONEEXTRA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoSolicitudesAutorizaciones getEntityProcesoSolicitudesAutorizaciones(String strPrefijo,ProcesoSolicitudesAutorizaciones entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoSolicitudesAutorizaciones.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoSolicitudesAutorizaciones.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoSolicitudesAutorizacionesLogic.setFieldReflectionProcesoSolicitudesAutorizaciones(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoSolicitudesAutorizaciones(Field field,String strPrefijo,String sColumn,ProcesoSolicitudesAutorizaciones entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBREMONEDA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoSolicitudesAutorizacionesConstantesFunciones.NUMEROPREIMPRESOFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAPAGO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONEEXTRA:
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
	
	public void quitarProcesoSolicitudesAutorizacionessNulos() throws Exception {				
		
		List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacionessAux= new ArrayList<ProcesoSolicitudesAutorizaciones>();
		
		for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones:procesosolicitudesautorizacioness) {
			if(procesosolicitudesautorizaciones!=null) {
				procesosolicitudesautorizacionessAux.add(procesosolicitudesautorizaciones);
			}
		}
		
		procesosolicitudesautorizacioness=procesosolicitudesautorizacionessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoSolicitudesAutorizaciones> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoSolicitudesAutorizaciones> entities = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		ProcesoSolicitudesAutorizaciones entity = new ProcesoSolicitudesAutorizaciones();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoSolicitudesAutorizaciones>((List<ProcesoSolicitudesAutorizaciones>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoSolicitudesAutorizacionessOriginal(entities);
			
			}  else {
				this.procesosolicitudesautorizacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoSolicitudesAutorizacionesConstantesFunciones.quitarEspaciosProcesoSolicitudesAutorizacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesosolicitudesautorizacioness = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoSolicitudesAutorizacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosolicitudesautorizacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesosolicitudesautorizacioness = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		  		  
        try {
			//ProcesoSolicitudesAutorizacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesosolicitudesautorizacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoSolicitudesAutorizaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoSolicitudesAutorizaciones> entities = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		ProcesoSolicitudesAutorizaciones entity = new ProcesoSolicitudesAutorizaciones();		  
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
	
	public  List<ProcesoSolicitudesAutorizaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoSolicitudesAutorizaciones> entities = new  ArrayList<ProcesoSolicitudesAutorizaciones>();
		ProcesoSolicitudesAutorizaciones entity = new ProcesoSolicitudesAutorizaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoSolicitudesAutorizaciones();
				
				if(conMapGenerico) {
					entity.setMapProcesoSolicitudesAutorizaciones( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoSolicitudesAutorizaciones().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoSolicitudesAutorizacionesDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoSolicitudesAutorizacionesLogic.getEntityProcesoSolicitudesAutorizaciones("",entity,resultSet,listColumns);
					
					////entity.setProcesoSolicitudesAutorizacionesOriginal( new ProcesoSolicitudesAutorizaciones());
					////entity.setProcesoSolicitudesAutorizacionesOriginal(super.getEntity("",entity.getProcesoSolicitudesAutorizacionesOriginal(),resultSet,ProcesoSolicitudesAutorizacionesDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoSolicitudesAutorizacionesOriginal(ProcesoSolicitudesAutorizacionesDataAccess.getEntityProcesoSolicitudesAutorizaciones("",entity.getProcesoSolicitudesAutorizacionesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ProcesoSolicitudesAutorizaciones relprocesosolicitudesautorizaciones)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relprocesosolicitudesautorizaciones.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProcesoSolicitudesAutorizaciones relprocesosolicitudesautorizaciones)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relprocesosolicitudesautorizaciones.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,ProcesoSolicitudesAutorizaciones relprocesosolicitudesautorizaciones)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relprocesosolicitudesautorizaciones.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


	
	
	public void getProcesoSolicitudesAutorizacionessBusquedaProcesoSolicitudesAutorizacionesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cliente,Date fecha_vencimiento_hasta)throws Exception {
		try {
			ProcesoSolicitudesAutorizacionesLogicAdditional procesosolicitudesautorizacionesLogicAdditional=new ProcesoSolicitudesAutorizacionesLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesosolicitudesautorizacionesLogicAdditional.BusquedaProcesoSolicitudesAutorizaciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cliente,fecha_vencimiento_hasta);

			//this.procesosolicitudesautorizacioness=this.getProcesoSolicitudesAutorizacioness();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoSolicitudesAutorizacionesLogicAdditional.ProcesarInformacionProcesoSolicitudesAutorizaciones(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesosolicitudesautorizacionesLogicAdditional,this.procesosolicitudesautorizacioness,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoSolicitudesAutorizaciones",id_cliente,fecha_vencimiento_hasta);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoSolicitudesAutorizacionessBusquedaProcesoSolicitudesAutorizaciones(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cliente,Date fecha_vencimiento_hasta)throws Exception {
		try {
			ProcesoSolicitudesAutorizacionesLogicAdditional procesosolicitudesautorizacionesLogicAdditional=new ProcesoSolicitudesAutorizacionesLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesosolicitudesautorizacionesLogicAdditional.BusquedaProcesoSolicitudesAutorizaciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cliente,fecha_vencimiento_hasta);

			//this.procesosolicitudesautorizacioness=this.getProcesoSolicitudesAutorizacioness();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoSolicitudesAutorizacionesLogicAdditional.ProcesarInformacionProcesoSolicitudesAutorizaciones(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesosolicitudesautorizacionesLogicAdditional,this.procesosolicitudesautorizacioness,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoSolicitudesAutorizaciones",id_cliente,fecha_vencimiento_hasta);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoSolicitudesAutorizacionesLogicAdditional.updateProcesoSolicitudesAutorizacionesToGet(procesosolicitudesautorizaciones,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesosolicitudesautorizaciones.setEmpresa(procesosolicitudesautorizacionesDataAccess.getEmpresa(connexion,procesosolicitudesautorizaciones));
		procesosolicitudesautorizaciones.setSucursal(procesosolicitudesautorizacionesDataAccess.getSucursal(connexion,procesosolicitudesautorizaciones));
		procesosolicitudesautorizaciones.setCliente(procesosolicitudesautorizacionesDataAccess.getCliente(connexion,procesosolicitudesautorizaciones));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				procesosolicitudesautorizaciones.setEmpresa(procesosolicitudesautorizacionesDataAccess.getEmpresa(connexion,procesosolicitudesautorizaciones));
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesosolicitudesautorizaciones.setSucursal(procesosolicitudesautorizacionesDataAccess.getSucursal(connexion,procesosolicitudesautorizaciones));
			}

			if(clas.clas.equals(Cliente.class)) {
				procesosolicitudesautorizaciones.setCliente(procesosolicitudesautorizacionesDataAccess.getCliente(connexion,procesosolicitudesautorizaciones));
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
			procesosolicitudesautorizaciones.setEmpresa(procesosolicitudesautorizacionesDataAccess.getEmpresa(connexion,procesosolicitudesautorizaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesosolicitudesautorizaciones.setSucursal(procesosolicitudesautorizacionesDataAccess.getSucursal(connexion,procesosolicitudesautorizaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesosolicitudesautorizaciones.setCliente(procesosolicitudesautorizacionesDataAccess.getCliente(connexion,procesosolicitudesautorizaciones));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesosolicitudesautorizaciones.setEmpresa(procesosolicitudesautorizacionesDataAccess.getEmpresa(connexion,procesosolicitudesautorizaciones));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(procesosolicitudesautorizaciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		procesosolicitudesautorizaciones.setSucursal(procesosolicitudesautorizacionesDataAccess.getSucursal(connexion,procesosolicitudesautorizaciones));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(procesosolicitudesautorizaciones.getSucursal(),isDeep,deepLoadType,clases);
				
		procesosolicitudesautorizaciones.setCliente(procesosolicitudesautorizacionesDataAccess.getCliente(connexion,procesosolicitudesautorizaciones));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(procesosolicitudesautorizaciones.getCliente(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				procesosolicitudesautorizaciones.setEmpresa(procesosolicitudesautorizacionesDataAccess.getEmpresa(connexion,procesosolicitudesautorizaciones));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(procesosolicitudesautorizaciones.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesosolicitudesautorizaciones.setSucursal(procesosolicitudesautorizacionesDataAccess.getSucursal(connexion,procesosolicitudesautorizaciones));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(procesosolicitudesautorizaciones.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				procesosolicitudesautorizaciones.setCliente(procesosolicitudesautorizacionesDataAccess.getCliente(connexion,procesosolicitudesautorizaciones));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(procesosolicitudesautorizaciones.getCliente(),isDeep,deepLoadType,clases);				
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
			procesosolicitudesautorizaciones.setEmpresa(procesosolicitudesautorizacionesDataAccess.getEmpresa(connexion,procesosolicitudesautorizaciones));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(procesosolicitudesautorizaciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesosolicitudesautorizaciones.setSucursal(procesosolicitudesautorizacionesDataAccess.getSucursal(connexion,procesosolicitudesautorizaciones));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(procesosolicitudesautorizaciones.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesosolicitudesautorizaciones.setCliente(procesosolicitudesautorizacionesDataAccess.getCliente(connexion,procesosolicitudesautorizaciones));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(procesosolicitudesautorizaciones.getCliente(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesosolicitudesautorizaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoSolicitudesAutorizacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoSolicitudesAutorizaciones(procesosolicitudesautorizaciones);
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
			this.deepLoad(this.procesosolicitudesautorizaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoSolicitudesAutorizacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoSolicitudesAutorizaciones(this.procesosolicitudesautorizaciones);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesosolicitudesautorizacioness!=null) {
				for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones:procesosolicitudesautorizacioness) {
					this.deepLoad(procesosolicitudesautorizaciones,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoSolicitudesAutorizacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoSolicitudesAutorizaciones(procesosolicitudesautorizacioness);
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
			if(procesosolicitudesautorizacioness!=null) {
				for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones:procesosolicitudesautorizacioness) {
					this.deepLoad(procesosolicitudesautorizaciones,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoSolicitudesAutorizacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoSolicitudesAutorizaciones(procesosolicitudesautorizacioness);
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
	
	public ProcesoSolicitudesAutorizacionesParameterReturnGeneral procesarAccionProcesoSolicitudesAutorizacioness(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness,ProcesoSolicitudesAutorizacionesParameterReturnGeneral procesosolicitudesautorizacionesParameterGeneral)throws Exception {
		 try {	
			ProcesoSolicitudesAutorizacionesParameterReturnGeneral procesosolicitudesautorizacionesReturnGeneral=new ProcesoSolicitudesAutorizacionesParameterReturnGeneral();
	
			ProcesoSolicitudesAutorizacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesosolicitudesautorizacioness,procesosolicitudesautorizacionesParameterGeneral,procesosolicitudesautorizacionesReturnGeneral);
			
			return procesosolicitudesautorizacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoSolicitudesAutorizacionesParameterReturnGeneral procesarAccionProcesoSolicitudesAutorizacionessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness,ProcesoSolicitudesAutorizacionesParameterReturnGeneral procesosolicitudesautorizacionesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoSolicitudesAutorizacionesParameterReturnGeneral procesosolicitudesautorizacionesReturnGeneral=new ProcesoSolicitudesAutorizacionesParameterReturnGeneral();
	
			ProcesoSolicitudesAutorizacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesosolicitudesautorizacioness,procesosolicitudesautorizacionesParameterGeneral,procesosolicitudesautorizacionesReturnGeneral);
			
			this.connexion.commit();
			
			return procesosolicitudesautorizacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness,String sTipoBusqueda,Long id_clienteBusquedaProcesoSolicitudesAutorizaciones,Date fecha_vencimiento_hastaBusquedaProcesoSolicitudesAutorizaciones) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoSolicitudesAutorizacionesLogicAdditional procesosolicitudesautorizacionesLogicAdditional=new ProcesoSolicitudesAutorizacionesLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesosolicitudesautorizacionesLogicAdditional.setConnexion(this.connexion);

			procesosolicitudesautorizacionesLogicAdditional.ProcesarInformacionProcesoSolicitudesAutorizaciones(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesosolicitudesautorizacioness,sTipoBusqueda,id_clienteBusquedaProcesoSolicitudesAutorizaciones,fecha_vencimiento_hastaBusquedaProcesoSolicitudesAutorizaciones);

			//this.connexion.commit();
		} catch(Exception e) {
			//this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			//this.connexion.close();
		}

		return procesado;
	}

	
}

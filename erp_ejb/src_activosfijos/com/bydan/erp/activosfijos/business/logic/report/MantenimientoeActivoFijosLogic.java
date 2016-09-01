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
package com.bydan.erp.activosfijos.business.logic.report;

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

import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.resources.general.AuxiliarGeneral;
import com.bydan.erp.activosfijos.util.report.MantenimientoeActivoFijosParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.MantenimientoeActivoFijosParameterGeneral;
import com.bydan.erp.activosfijos.util.report.MantenimientoeActivoFijosConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.MantenimientoeActivoFijos;

import com.bydan.erp.activosfijos.business.logic.report.MantenimientoeActivoFijosLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class MantenimientoeActivoFijosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(MantenimientoeActivoFijosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected MantenimientoeActivoFijosLogic mantenimientoeactivofijosDataAccess; 		
	protected MantenimientoeActivoFijos mantenimientoeactivofijos;
	protected List<MantenimientoeActivoFijos> mantenimientoeactivofijoss;
	protected Object mantenimientoeactivofijosObject;	
	protected List<Object> mantenimientoeactivofijossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  MantenimientoeActivoFijosLogic()throws SQLException,Exception {
		try	{
			this.mantenimientoeactivofijoss= new ArrayList<MantenimientoeActivoFijos>();
			this.mantenimientoeactivofijos= new MantenimientoeActivoFijos();
			this.mantenimientoeactivofijosObject=new Object();
			this.mantenimientoeactivofijossObject=new ArrayList<Object>();
			
			this.mantenimientoeactivofijosDataAccess=this;
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
			this.mantenimientoeactivofijosDataAccess.setConnexionType(this.connexionType);
			this.mantenimientoeactivofijosDataAccess.setParameterDbType(this.parameterDbType);
			this.mantenimientoeactivofijosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MantenimientoeActivoFijosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.mantenimientoeactivofijoss= new ArrayList<MantenimientoeActivoFijos>();
			this.mantenimientoeactivofijos= new MantenimientoeActivoFijos();
			this.mantenimientoeactivofijosObject=new Object();
			this.mantenimientoeactivofijossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.mantenimientoeactivofijosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.mantenimientoeactivofijosDataAccess.setConnexionType(this.connexionType);
			this.mantenimientoeactivofijosDataAccess.setParameterDbType(this.parameterDbType);
			this.mantenimientoeactivofijosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MantenimientoeActivoFijos getMantenimientoeActivoFijos() throws Exception {	
		MantenimientoeActivoFijosLogicAdditional.checkMantenimientoeActivoFijosToGet(mantenimientoeactivofijos,this.datosCliente,this.arrDatoGeneral);
		MantenimientoeActivoFijosLogicAdditional.updateMantenimientoeActivoFijosToGet(mantenimientoeactivofijos,this.arrDatoGeneral);
		
		return mantenimientoeactivofijos;
	}
		
	public void setMantenimientoeActivoFijos(MantenimientoeActivoFijos newMantenimientoeActivoFijos) {
		this.mantenimientoeactivofijos = newMantenimientoeActivoFijos;
	}
	
	public List<MantenimientoeActivoFijos> getMantenimientoeActivoFijoss() throws Exception {		
		this.quitarMantenimientoeActivoFijossNulos();
		
		MantenimientoeActivoFijosLogicAdditional.checkMantenimientoeActivoFijosToGets(mantenimientoeactivofijoss,this.datosCliente,this.arrDatoGeneral);
		
		for (MantenimientoeActivoFijos mantenimientoeactivofijosLocal: mantenimientoeactivofijoss ) {
			MantenimientoeActivoFijosLogicAdditional.updateMantenimientoeActivoFijosToGet(mantenimientoeactivofijosLocal,this.arrDatoGeneral);
		}
		
		return mantenimientoeactivofijoss;
	}
	
	public void setMantenimientoeActivoFijoss(List<MantenimientoeActivoFijos> newMantenimientoeActivoFijoss) {
		this.mantenimientoeactivofijoss = newMantenimientoeActivoFijoss;
	}
	
	public Object getMantenimientoeActivoFijosObject() {	
		//this.mantenimientoeactivofijosObject=this.mantenimientoeactivofijosDataAccess.getEntityObject();
		return this.mantenimientoeactivofijosObject;
	}
		
	public void setMantenimientoeActivoFijosObject(Object newMantenimientoeActivoFijosObject) {
		this.mantenimientoeactivofijosObject = newMantenimientoeActivoFijosObject;
	}
	
	public List<Object> getMantenimientoeActivoFijossObject() {		
		//this.mantenimientoeactivofijossObject=this.mantenimientoeactivofijosDataAccess.getEntitiesObject();
		return this.mantenimientoeactivofijossObject;
	}
		
	public void setMantenimientoeActivoFijossObject(List<Object> newMantenimientoeActivoFijossObject) {
		this.mantenimientoeactivofijossObject = newMantenimientoeActivoFijossObject;
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
		mantenimientoeactivofijoss = new  ArrayList<MantenimientoeActivoFijos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MantenimientoeActivoFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoeactivofijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		mantenimientoeactivofijoss = new  ArrayList<MantenimientoeActivoFijos>();
		  		  
        try {
			//MantenimientoeActivoFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoeactivofijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mantenimientoeactivofijoss = new  ArrayList<MantenimientoeActivoFijos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MantenimientoeActivoFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoeactivofijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		mantenimientoeactivofijoss = new  ArrayList<MantenimientoeActivoFijos>();
		  		  
        try {
			//MantenimientoeActivoFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoeactivofijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		mantenimientoeactivofijoss = new  ArrayList<MantenimientoeActivoFijos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MantenimientoeActivoFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoeactivofijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		mantenimientoeactivofijoss = new  ArrayList<MantenimientoeActivoFijos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//MantenimientoeActivoFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoeactivofijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<MantenimientoeActivoFijos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MantenimientoeActivoFijos> entities = new  ArrayList<MantenimientoeActivoFijos>();
		MantenimientoeActivoFijos entity = new MantenimientoeActivoFijos();		  
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
	
	public  List<MantenimientoeActivoFijos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MantenimientoeActivoFijos> entities = new  ArrayList<MantenimientoeActivoFijos>();
		MantenimientoeActivoFijos entity = new MantenimientoeActivoFijos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MantenimientoeActivoFijos();
				
				
      	    	entity=MantenimientoeActivoFijosLogic.getEntityMantenimientoeActivoFijos("",entity,resultSet);
      	    	
				//entity.setMantenimientoeActivoFijosOriginal( new MantenimientoeActivoFijos());
      	    	//entity.setMantenimientoeActivoFijosOriginal(super.getEntity("",entity.getMantenimientoeActivoFijosOriginal(),resultSet,MantenimientoeActivoFijosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMantenimientoeActivoFijosOriginal(MantenimientoeActivoFijosDataAccess.getEntityMantenimientoeActivoFijos("",entity.getMantenimientoeActivoFijosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<MantenimientoeActivoFijos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MantenimientoeActivoFijos> entities = new  ArrayList<MantenimientoeActivoFijos>();
		MantenimientoeActivoFijos entity = new MantenimientoeActivoFijos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,MantenimientoeActivoFijos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<MantenimientoeActivoFijos>((List<MantenimientoeActivoFijos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setMantenimientoeActivoFijossOriginal(entities);
			
			}  else {
				this.mantenimientoeactivofijossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//MantenimientoeActivoFijosConstantesFunciones.quitarEspaciosMantenimientoeActivoFijoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static MantenimientoeActivoFijos getEntityMantenimientoeActivoFijos(String strPrefijo,MantenimientoeActivoFijos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnumero_documento(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.NUMERODOCUMENTO));
			entity.setcausa(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.CAUSA));
			entity.setreferencia(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.REFERENCIA));
			entity.settaller(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.TALLER));
			entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.FECHAINICIO).getTime()));
			entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.FECHAENTREGA).getTime()));
			entity.setcosto(resultSet.getDouble(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.COSTO));
			entity.setresponsable(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.RESPONSABLE));
			entity.setobservacion(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.OBSERVACION));
			entity.settipo_movimiento(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.TIPOMOVIMIENTO));
			entity.setclave(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.CLAVE));
			entity.setnombre(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.NOMBRE));
			entity.setcodigo_detalle_grupo(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.CODIGODETALLEGRUPO));
			entity.setnombre_detalle_grupo(resultSet.getString(strPrefijo+MantenimientoeActivoFijosConstantesFunciones.NOMBREDETALLEGRUPO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MantenimientoeActivoFijos getEntityMantenimientoeActivoFijos(String strPrefijo,MantenimientoeActivoFijos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = MantenimientoeActivoFijos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = MantenimientoeActivoFijos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				MantenimientoeActivoFijosLogic.setFieldReflectionMantenimientoeActivoFijos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMantenimientoeActivoFijos(Field field,String strPrefijo,String sColumn,MantenimientoeActivoFijos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MantenimientoeActivoFijosConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.CAUSA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.REFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.TALLER:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.RESPONSABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.OBSERVACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.TIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.CLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.CODIGODETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoeActivoFijosConstantesFunciones.NOMBREDETALLEGRUPO:
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
	
	public void quitarMantenimientoeActivoFijossNulos() throws Exception {				
		
		List<MantenimientoeActivoFijos> mantenimientoeactivofijossAux= new ArrayList<MantenimientoeActivoFijos>();
		
		for(MantenimientoeActivoFijos mantenimientoeactivofijos:mantenimientoeactivofijoss) {
			if(mantenimientoeactivofijos!=null) {
				mantenimientoeactivofijossAux.add(mantenimientoeactivofijos);
			}
		}
		
		mantenimientoeactivofijoss=mantenimientoeactivofijossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<MantenimientoeActivoFijos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MantenimientoeActivoFijos> entities = new  ArrayList<MantenimientoeActivoFijos>();
		MantenimientoeActivoFijos entity = new MantenimientoeActivoFijos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<MantenimientoeActivoFijos>((List<MantenimientoeActivoFijos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setMantenimientoeActivoFijossOriginal(entities);
			
			}  else {
				this.mantenimientoeactivofijossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//MantenimientoeActivoFijosConstantesFunciones.quitarEspaciosMantenimientoeActivoFijoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		mantenimientoeactivofijoss = new  ArrayList<MantenimientoeActivoFijos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MantenimientoeActivoFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoeactivofijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		mantenimientoeactivofijoss = new  ArrayList<MantenimientoeActivoFijos>();
		  		  
        try {
			//MantenimientoeActivoFijosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoeactivofijoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<MantenimientoeActivoFijos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<MantenimientoeActivoFijos> entities = new  ArrayList<MantenimientoeActivoFijos>();
		MantenimientoeActivoFijos entity = new MantenimientoeActivoFijos();		  
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
	
	public  List<MantenimientoeActivoFijos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<MantenimientoeActivoFijos> entities = new  ArrayList<MantenimientoeActivoFijos>();
		MantenimientoeActivoFijos entity = new MantenimientoeActivoFijos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MantenimientoeActivoFijos();
				
				if(conMapGenerico) {
					entity.setMapMantenimientoeActivoFijos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapMantenimientoeActivoFijos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MantenimientoeActivoFijosDataAccess.ISWITHSCHEMA);         		
					entity=MantenimientoeActivoFijosLogic.getEntityMantenimientoeActivoFijos("",entity,resultSet,listColumns);
					
					////entity.setMantenimientoeActivoFijosOriginal( new MantenimientoeActivoFijos());
					////entity.setMantenimientoeActivoFijosOriginal(super.getEntity("",entity.getMantenimientoeActivoFijosOriginal(),resultSet,MantenimientoeActivoFijosDataAccess.ISWITHSCHEMA));         		
					////entity.setMantenimientoeActivoFijosOriginal(MantenimientoeActivoFijosDataAccess.getEntityMantenimientoeActivoFijos("",entity.getMantenimientoeActivoFijosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,MantenimientoeActivoFijos relmantenimientoeactivofijos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relmantenimientoeactivofijos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getMantenimientoeActivoFijossBusquedaMantenimientoeActivoFijosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//MantenimientoeActivoFijosLogic mantenimientoeactivofijosLogic=new MantenimientoeActivoFijosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=MantenimientoeActivoFijosLogic.GetSelecSqlMantenimientoeActivoFijos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.mantenimientoeactivofijoss=this.getMantenimientoeActivoFijoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getMantenimientoeActivoFijossBusquedaMantenimientoeActivoFijos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//MantenimientoeActivoFijosLogic mantenimientoeactivofijosLogic=new MantenimientoeActivoFijosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=MantenimientoeActivoFijosLogic.GetSelecSqlMantenimientoeActivoFijos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.mantenimientoeactivofijoss=this.getMantenimientoeActivoFijoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlMantenimientoeActivoFijos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("MantenimientoeActivoFijos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" m.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" m.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
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
	
	
	public void deepLoad(MantenimientoeActivoFijos mantenimientoeactivofijos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MantenimientoeActivoFijosLogicAdditional.updateMantenimientoeActivoFijosToGet(mantenimientoeactivofijos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mantenimientoeactivofijos.setEmpresa(mantenimientoeactivofijosDataAccess.getEmpresa(connexion,mantenimientoeactivofijos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mantenimientoeactivofijos.setEmpresa(mantenimientoeactivofijosDataAccess.getEmpresa(connexion,mantenimientoeactivofijos));
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
			mantenimientoeactivofijos.setEmpresa(mantenimientoeactivofijosDataAccess.getEmpresa(connexion,mantenimientoeactivofijos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mantenimientoeactivofijos.setEmpresa(mantenimientoeactivofijosDataAccess.getEmpresa(connexion,mantenimientoeactivofijos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mantenimientoeactivofijos.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mantenimientoeactivofijos.setEmpresa(mantenimientoeactivofijosDataAccess.getEmpresa(connexion,mantenimientoeactivofijos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(mantenimientoeactivofijos.getEmpresa(),isDeep,deepLoadType,clases);				
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
			mantenimientoeactivofijos.setEmpresa(mantenimientoeactivofijosDataAccess.getEmpresa(connexion,mantenimientoeactivofijos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(mantenimientoeactivofijos.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(mantenimientoeactivofijos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MantenimientoeActivoFijosConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoeActivoFijos(mantenimientoeactivofijos);
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
			this.deepLoad(this.mantenimientoeactivofijos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MantenimientoeActivoFijosConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoeActivoFijos(this.mantenimientoeactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(mantenimientoeactivofijoss!=null) {
				for(MantenimientoeActivoFijos mantenimientoeactivofijos:mantenimientoeactivofijoss) {
					this.deepLoad(mantenimientoeactivofijos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MantenimientoeActivoFijosConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoeActivoFijos(mantenimientoeactivofijoss);
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
			if(mantenimientoeactivofijoss!=null) {
				for(MantenimientoeActivoFijos mantenimientoeactivofijos:mantenimientoeactivofijoss) {
					this.deepLoad(mantenimientoeactivofijos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MantenimientoeActivoFijosConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoeActivoFijos(mantenimientoeactivofijoss);
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
	
	public MantenimientoeActivoFijosParameterReturnGeneral procesarAccionMantenimientoeActivoFijoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,MantenimientoeActivoFijosParameterReturnGeneral mantenimientoeactivofijosParameterGeneral)throws Exception {
		 try {	
			MantenimientoeActivoFijosParameterReturnGeneral mantenimientoeactivofijosReturnGeneral=new MantenimientoeActivoFijosParameterReturnGeneral();
	
			MantenimientoeActivoFijosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mantenimientoeactivofijoss,mantenimientoeactivofijosParameterGeneral,mantenimientoeactivofijosReturnGeneral);
			
			return mantenimientoeactivofijosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MantenimientoeActivoFijosParameterReturnGeneral procesarAccionMantenimientoeActivoFijossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,MantenimientoeActivoFijosParameterReturnGeneral mantenimientoeactivofijosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			MantenimientoeActivoFijosParameterReturnGeneral mantenimientoeactivofijosReturnGeneral=new MantenimientoeActivoFijosParameterReturnGeneral();
	
			MantenimientoeActivoFijosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mantenimientoeactivofijoss,mantenimientoeactivofijosParameterGeneral,mantenimientoeactivofijosReturnGeneral);
			
			this.connexion.commit();
			
			return mantenimientoeactivofijosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

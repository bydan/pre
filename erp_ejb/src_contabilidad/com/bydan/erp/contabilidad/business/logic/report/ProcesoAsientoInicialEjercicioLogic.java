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
package com.bydan.erp.contabilidad.business.logic.report;

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

import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.resources.general.AuxiliarGeneral;
import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioParameterGeneral;
import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.ProcesoAsientoInicialEjercicio;

import com.bydan.erp.contabilidad.business.logic.report.ProcesoAsientoInicialEjercicioLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoAsientoInicialEjercicioLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoAsientoInicialEjercicioLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoAsientoInicialEjercicioLogic procesoasientoinicialejercicioDataAccess; 		
	protected ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio;
	protected List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios;
	protected Object procesoasientoinicialejercicioObject;	
	protected List<Object> procesoasientoinicialejerciciosObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoAsientoInicialEjercicioLogic()throws SQLException,Exception {
		try	{
			this.procesoasientoinicialejercicios= new ArrayList<ProcesoAsientoInicialEjercicio>();
			this.procesoasientoinicialejercicio= new ProcesoAsientoInicialEjercicio();
			this.procesoasientoinicialejercicioObject=new Object();
			this.procesoasientoinicialejerciciosObject=new ArrayList<Object>();
			
			this.procesoasientoinicialejercicioDataAccess=this;
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
			this.procesoasientoinicialejercicioDataAccess.setConnexionType(this.connexionType);
			this.procesoasientoinicialejercicioDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoasientoinicialejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoAsientoInicialEjercicioLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesoasientoinicialejercicios= new ArrayList<ProcesoAsientoInicialEjercicio>();
			this.procesoasientoinicialejercicio= new ProcesoAsientoInicialEjercicio();
			this.procesoasientoinicialejercicioObject=new Object();
			this.procesoasientoinicialejerciciosObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesoasientoinicialejercicioDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesoasientoinicialejercicioDataAccess.setConnexionType(this.connexionType);
			this.procesoasientoinicialejercicioDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoasientoinicialejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoAsientoInicialEjercicio getProcesoAsientoInicialEjercicio() throws Exception {	
		ProcesoAsientoInicialEjercicioLogicAdditional.checkProcesoAsientoInicialEjercicioToGet(procesoasientoinicialejercicio,this.datosCliente,this.arrDatoGeneral);
		ProcesoAsientoInicialEjercicioLogicAdditional.updateProcesoAsientoInicialEjercicioToGet(procesoasientoinicialejercicio,this.arrDatoGeneral);
		
		return procesoasientoinicialejercicio;
	}
		
	public void setProcesoAsientoInicialEjercicio(ProcesoAsientoInicialEjercicio newProcesoAsientoInicialEjercicio) {
		this.procesoasientoinicialejercicio = newProcesoAsientoInicialEjercicio;
	}
	
	public List<ProcesoAsientoInicialEjercicio> getProcesoAsientoInicialEjercicios() throws Exception {		
		this.quitarProcesoAsientoInicialEjerciciosNulos();
		
		ProcesoAsientoInicialEjercicioLogicAdditional.checkProcesoAsientoInicialEjercicioToGets(procesoasientoinicialejercicios,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioLocal: procesoasientoinicialejercicios ) {
			ProcesoAsientoInicialEjercicioLogicAdditional.updateProcesoAsientoInicialEjercicioToGet(procesoasientoinicialejercicioLocal,this.arrDatoGeneral);
		}
		
		return procesoasientoinicialejercicios;
	}
	
	public void setProcesoAsientoInicialEjercicios(List<ProcesoAsientoInicialEjercicio> newProcesoAsientoInicialEjercicios) {
		this.procesoasientoinicialejercicios = newProcesoAsientoInicialEjercicios;
	}
	
	public Object getProcesoAsientoInicialEjercicioObject() {	
		//this.procesoasientoinicialejercicioObject=this.procesoasientoinicialejercicioDataAccess.getEntityObject();
		return this.procesoasientoinicialejercicioObject;
	}
		
	public void setProcesoAsientoInicialEjercicioObject(Object newProcesoAsientoInicialEjercicioObject) {
		this.procesoasientoinicialejercicioObject = newProcesoAsientoInicialEjercicioObject;
	}
	
	public List<Object> getProcesoAsientoInicialEjerciciosObject() {		
		//this.procesoasientoinicialejerciciosObject=this.procesoasientoinicialejercicioDataAccess.getEntitiesObject();
		return this.procesoasientoinicialejerciciosObject;
	}
		
	public void setProcesoAsientoInicialEjerciciosObject(List<Object> newProcesoAsientoInicialEjerciciosObject) {
		this.procesoasientoinicialejerciciosObject = newProcesoAsientoInicialEjerciciosObject;
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
		procesoasientoinicialejercicios = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoAsientoInicialEjercicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoasientoinicialejercicios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesoasientoinicialejercicios = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		  		  
        try {
			//ProcesoAsientoInicialEjercicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoasientoinicialejercicios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesoasientoinicialejercicios = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoAsientoInicialEjercicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoasientoinicialejercicios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoasientoinicialejercicios = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		  		  
        try {
			//ProcesoAsientoInicialEjercicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoasientoinicialejercicios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesoasientoinicialejercicios = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoAsientoInicialEjercicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoasientoinicialejercicios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoasientoinicialejercicios = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoAsientoInicialEjercicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoasientoinicialejercicios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoAsientoInicialEjercicio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoAsientoInicialEjercicio> entities = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		ProcesoAsientoInicialEjercicio entity = new ProcesoAsientoInicialEjercicio();		  
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
	
	public  List<ProcesoAsientoInicialEjercicio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoAsientoInicialEjercicio> entities = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		ProcesoAsientoInicialEjercicio entity = new ProcesoAsientoInicialEjercicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoAsientoInicialEjercicio();
				
				
      	    	entity=ProcesoAsientoInicialEjercicioLogic.getEntityProcesoAsientoInicialEjercicio("",entity,resultSet);
      	    	
				//entity.setProcesoAsientoInicialEjercicioOriginal( new ProcesoAsientoInicialEjercicio());
      	    	//entity.setProcesoAsientoInicialEjercicioOriginal(super.getEntity("",entity.getProcesoAsientoInicialEjercicioOriginal(),resultSet,ProcesoAsientoInicialEjercicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoAsientoInicialEjercicioOriginal(ProcesoAsientoInicialEjercicioDataAccess.getEntityProcesoAsientoInicialEjercicio("",entity.getProcesoAsientoInicialEjercicioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoAsientoInicialEjercicio> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoAsientoInicialEjercicio> entities = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		ProcesoAsientoInicialEjercicio entity = new ProcesoAsientoInicialEjercicio();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoAsientoInicialEjercicio.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoAsientoInicialEjercicio>((List<ProcesoAsientoInicialEjercicio>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoAsientoInicialEjerciciosOriginal(entities);
			
			}  else {
				this.procesoasientoinicialejerciciosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoAsientoInicialEjercicioConstantesFunciones.quitarEspaciosProcesoAsientoInicialEjercicios(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoAsientoInicialEjercicio getEntityProcesoAsientoInicialEjercicio(String strPrefijo,ProcesoAsientoInicialEjercicio entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_tipo_documento(resultSet.getLong(strPrefijo+ProcesoAsientoInicialEjercicioConstantesFunciones.IDTIPODOCUMENTO));
			entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAINICIO).getTime()));
			entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAFIN).getTime()));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoAsientoInicialEjercicio getEntityProcesoAsientoInicialEjercicio(String strPrefijo,ProcesoAsientoInicialEjercicio entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoAsientoInicialEjercicio.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoAsientoInicialEjercicio.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoAsientoInicialEjercicioLogic.setFieldReflectionProcesoAsientoInicialEjercicio(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoAsientoInicialEjercicio(Field field,String strPrefijo,String sColumn,ProcesoAsientoInicialEjercicio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoAsientoInicialEjercicioConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProcesoAsientoInicialEjercicioConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	public void quitarProcesoAsientoInicialEjerciciosNulos() throws Exception {				
		
		List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejerciciosAux= new ArrayList<ProcesoAsientoInicialEjercicio>();
		
		for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio:procesoasientoinicialejercicios) {
			if(procesoasientoinicialejercicio!=null) {
				procesoasientoinicialejerciciosAux.add(procesoasientoinicialejercicio);
			}
		}
		
		procesoasientoinicialejercicios=procesoasientoinicialejerciciosAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoAsientoInicialEjercicio> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoAsientoInicialEjercicio> entities = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		ProcesoAsientoInicialEjercicio entity = new ProcesoAsientoInicialEjercicio();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoAsientoInicialEjercicio>((List<ProcesoAsientoInicialEjercicio>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoAsientoInicialEjerciciosOriginal(entities);
			
			}  else {
				this.procesoasientoinicialejerciciosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoAsientoInicialEjercicioConstantesFunciones.quitarEspaciosProcesoAsientoInicialEjercicios(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesoasientoinicialejercicios = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoAsientoInicialEjercicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoasientoinicialejercicios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesoasientoinicialejercicios = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		  		  
        try {
			//ProcesoAsientoInicialEjercicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoasientoinicialejercicios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoAsientoInicialEjercicio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoAsientoInicialEjercicio> entities = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		ProcesoAsientoInicialEjercicio entity = new ProcesoAsientoInicialEjercicio();		  
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
	
	public  List<ProcesoAsientoInicialEjercicio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoAsientoInicialEjercicio> entities = new  ArrayList<ProcesoAsientoInicialEjercicio>();
		ProcesoAsientoInicialEjercicio entity = new ProcesoAsientoInicialEjercicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoAsientoInicialEjercicio();
				
				if(conMapGenerico) {
					entity.setMapProcesoAsientoInicialEjercicio( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoAsientoInicialEjercicio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoAsientoInicialEjercicioDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoAsientoInicialEjercicioLogic.getEntityProcesoAsientoInicialEjercicio("",entity,resultSet,listColumns);
					
					////entity.setProcesoAsientoInicialEjercicioOriginal( new ProcesoAsientoInicialEjercicio());
					////entity.setProcesoAsientoInicialEjercicioOriginal(super.getEntity("",entity.getProcesoAsientoInicialEjercicioOriginal(),resultSet,ProcesoAsientoInicialEjercicioDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoAsientoInicialEjercicioOriginal(ProcesoAsientoInicialEjercicioDataAccess.getEntityProcesoAsientoInicialEjercicio("",entity.getProcesoAsientoInicialEjercicioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public TipoDocumento getTipoDocumento(Connexion connexion,ProcesoAsientoInicialEjercicio relprocesoasientoinicialejercicio)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);
			tipodocumentoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relprocesoasientoinicialejercicio.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}


	
	
	public void getProcesoAsientoInicialEjerciciosBusquedaProcesoAsientoInicialEjercicioWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_documento,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			ProcesoAsientoInicialEjercicioLogicAdditional procesoasientoinicialejercicioLogicAdditional=new ProcesoAsientoInicialEjercicioLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoasientoinicialejercicioLogicAdditional.BusquedaProcesoAsientoInicialEjercicio(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_documento,fecha_inicio,fecha_fin);

			//this.procesoasientoinicialejercicios=this.getProcesoAsientoInicialEjercicios();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoAsientoInicialEjercicioLogicAdditional.ProcesarInformacionProcesoAsientoInicialEjercicio(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoasientoinicialejercicioLogicAdditional,this.procesoasientoinicialejercicios,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoAsientoInicialEjercicio",id_tipo_documento,fecha_inicio,fecha_fin);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoAsientoInicialEjerciciosBusquedaProcesoAsientoInicialEjercicio(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_documento,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			ProcesoAsientoInicialEjercicioLogicAdditional procesoasientoinicialejercicioLogicAdditional=new ProcesoAsientoInicialEjercicioLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoasientoinicialejercicioLogicAdditional.BusquedaProcesoAsientoInicialEjercicio(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_documento,fecha_inicio,fecha_fin);

			//this.procesoasientoinicialejercicios=this.getProcesoAsientoInicialEjercicios();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoAsientoInicialEjercicioLogicAdditional.ProcesarInformacionProcesoAsientoInicialEjercicio(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoasientoinicialejercicioLogicAdditional,this.procesoasientoinicialejercicios,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoAsientoInicialEjercicio",id_tipo_documento,fecha_inicio,fecha_fin);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoAsientoInicialEjercicioLogicAdditional.updateProcesoAsientoInicialEjercicioToGet(procesoasientoinicialejercicio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoasientoinicialejercicio.setTipoDocumento(procesoasientoinicialejercicioDataAccess.getTipoDocumento(connexion,procesoasientoinicialejercicio));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				procesoasientoinicialejercicio.setTipoDocumento(procesoasientoinicialejercicioDataAccess.getTipoDocumento(connexion,procesoasientoinicialejercicio));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoasientoinicialejercicio.setTipoDocumento(procesoasientoinicialejercicioDataAccess.getTipoDocumento(connexion,procesoasientoinicialejercicio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoasientoinicialejercicio.setTipoDocumento(procesoasientoinicialejercicioDataAccess.getTipoDocumento(connexion,procesoasientoinicialejercicio));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(procesoasientoinicialejercicio.getTipoDocumento(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				procesoasientoinicialejercicio.setTipoDocumento(procesoasientoinicialejercicioDataAccess.getTipoDocumento(connexion,procesoasientoinicialejercicio));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(procesoasientoinicialejercicio.getTipoDocumento(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoasientoinicialejercicio.setTipoDocumento(procesoasientoinicialejercicioDataAccess.getTipoDocumento(connexion,procesoasientoinicialejercicio));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(procesoasientoinicialejercicio.getTipoDocumento(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesoasientoinicialejercicio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoAsientoInicialEjercicioConstantesFunciones.refrescarForeignKeysDescripcionesProcesoAsientoInicialEjercicio(procesoasientoinicialejercicio);
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
			this.deepLoad(this.procesoasientoinicialejercicio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoAsientoInicialEjercicioConstantesFunciones.refrescarForeignKeysDescripcionesProcesoAsientoInicialEjercicio(this.procesoasientoinicialejercicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesoasientoinicialejercicios!=null) {
				for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio:procesoasientoinicialejercicios) {
					this.deepLoad(procesoasientoinicialejercicio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoAsientoInicialEjercicioConstantesFunciones.refrescarForeignKeysDescripcionesProcesoAsientoInicialEjercicio(procesoasientoinicialejercicios);
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
			if(procesoasientoinicialejercicios!=null) {
				for(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio:procesoasientoinicialejercicios) {
					this.deepLoad(procesoasientoinicialejercicio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoAsientoInicialEjercicioConstantesFunciones.refrescarForeignKeysDescripcionesProcesoAsientoInicialEjercicio(procesoasientoinicialejercicios);
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
	
	public ProcesoAsientoInicialEjercicioParameterReturnGeneral procesarAccionProcesoAsientoInicialEjercicios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,ProcesoAsientoInicialEjercicioParameterReturnGeneral procesoasientoinicialejercicioParameterGeneral)throws Exception {
		 try {	
			ProcesoAsientoInicialEjercicioParameterReturnGeneral procesoasientoinicialejercicioReturnGeneral=new ProcesoAsientoInicialEjercicioParameterReturnGeneral();
	
			ProcesoAsientoInicialEjercicioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoasientoinicialejercicios,procesoasientoinicialejercicioParameterGeneral,procesoasientoinicialejercicioReturnGeneral);
			
			return procesoasientoinicialejercicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoAsientoInicialEjercicioParameterReturnGeneral procesarAccionProcesoAsientoInicialEjerciciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,ProcesoAsientoInicialEjercicioParameterReturnGeneral procesoasientoinicialejercicioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoAsientoInicialEjercicioParameterReturnGeneral procesoasientoinicialejercicioReturnGeneral=new ProcesoAsientoInicialEjercicioParameterReturnGeneral();
	
			ProcesoAsientoInicialEjercicioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoasientoinicialejercicios,procesoasientoinicialejercicioParameterGeneral,procesoasientoinicialejercicioReturnGeneral);
			
			this.connexion.commit();
			
			return procesoasientoinicialejercicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoAsientoInicialEjercicio(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,String sTipoBusqueda,Long id_tipo_documentoBusquedaProcesoAsientoInicialEjercicio,Date fecha_inicioBusquedaProcesoAsientoInicialEjercicio,Date fecha_finBusquedaProcesoAsientoInicialEjercicio) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoAsientoInicialEjercicioLogicAdditional procesoasientoinicialejercicioLogicAdditional=new ProcesoAsientoInicialEjercicioLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesoasientoinicialejercicioLogicAdditional.setConnexion(this.connexion);

			procesoasientoinicialejercicioLogicAdditional.ProcesarInformacionProcesoAsientoInicialEjercicio(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoasientoinicialejercicios,sTipoBusqueda,id_tipo_documentoBusquedaProcesoAsientoInicialEjercicio,fecha_inicioBusquedaProcesoAsientoInicialEjercicio,fecha_finBusquedaProcesoAsientoInicialEjercicio);

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

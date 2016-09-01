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
package com.bydan.erp.cartera.business.logic.report;

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

import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.resources.general.AuxiliarGeneral;
import com.bydan.erp.cartera.util.report.CobrarClientesNovedadesParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesNovedadesParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarClientesNovedadesConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarClientesNovedades;

import com.bydan.erp.cartera.business.logic.report.CobrarClientesNovedadesLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarClientesNovedadesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarClientesNovedadesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarClientesNovedadesLogic cobrarclientesnovedadesDataAccess; 		
	protected CobrarClientesNovedades cobrarclientesnovedades;
	protected List<CobrarClientesNovedades> cobrarclientesnovedadess;
	protected Object cobrarclientesnovedadesObject;	
	protected List<Object> cobrarclientesnovedadessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarClientesNovedadesLogic()throws SQLException,Exception {
		try	{
			this.cobrarclientesnovedadess= new ArrayList<CobrarClientesNovedades>();
			this.cobrarclientesnovedades= new CobrarClientesNovedades();
			this.cobrarclientesnovedadesObject=new Object();
			this.cobrarclientesnovedadessObject=new ArrayList<Object>();
			
			this.cobrarclientesnovedadesDataAccess=this;
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
			this.cobrarclientesnovedadesDataAccess.setConnexionType(this.connexionType);
			this.cobrarclientesnovedadesDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclientesnovedadesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarClientesNovedadesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarclientesnovedadess= new ArrayList<CobrarClientesNovedades>();
			this.cobrarclientesnovedades= new CobrarClientesNovedades();
			this.cobrarclientesnovedadesObject=new Object();
			this.cobrarclientesnovedadessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarclientesnovedadesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarclientesnovedadesDataAccess.setConnexionType(this.connexionType);
			this.cobrarclientesnovedadesDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclientesnovedadesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarClientesNovedades getCobrarClientesNovedades() throws Exception {	
		CobrarClientesNovedadesLogicAdditional.checkCobrarClientesNovedadesToGet(cobrarclientesnovedades,this.datosCliente,this.arrDatoGeneral);
		CobrarClientesNovedadesLogicAdditional.updateCobrarClientesNovedadesToGet(cobrarclientesnovedades,this.arrDatoGeneral);
		
		return cobrarclientesnovedades;
	}
		
	public void setCobrarClientesNovedades(CobrarClientesNovedades newCobrarClientesNovedades) {
		this.cobrarclientesnovedades = newCobrarClientesNovedades;
	}
	
	public List<CobrarClientesNovedades> getCobrarClientesNovedadess() throws Exception {		
		this.quitarCobrarClientesNovedadessNulos();
		
		CobrarClientesNovedadesLogicAdditional.checkCobrarClientesNovedadesToGets(cobrarclientesnovedadess,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarClientesNovedades cobrarclientesnovedadesLocal: cobrarclientesnovedadess ) {
			CobrarClientesNovedadesLogicAdditional.updateCobrarClientesNovedadesToGet(cobrarclientesnovedadesLocal,this.arrDatoGeneral);
		}
		
		return cobrarclientesnovedadess;
	}
	
	public void setCobrarClientesNovedadess(List<CobrarClientesNovedades> newCobrarClientesNovedadess) {
		this.cobrarclientesnovedadess = newCobrarClientesNovedadess;
	}
	
	public Object getCobrarClientesNovedadesObject() {	
		//this.cobrarclientesnovedadesObject=this.cobrarclientesnovedadesDataAccess.getEntityObject();
		return this.cobrarclientesnovedadesObject;
	}
		
	public void setCobrarClientesNovedadesObject(Object newCobrarClientesNovedadesObject) {
		this.cobrarclientesnovedadesObject = newCobrarClientesNovedadesObject;
	}
	
	public List<Object> getCobrarClientesNovedadessObject() {		
		//this.cobrarclientesnovedadessObject=this.cobrarclientesnovedadesDataAccess.getEntitiesObject();
		return this.cobrarclientesnovedadessObject;
	}
		
	public void setCobrarClientesNovedadessObject(List<Object> newCobrarClientesNovedadessObject) {
		this.cobrarclientesnovedadessObject = newCobrarClientesNovedadessObject;
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
		cobrarclientesnovedadess = new  ArrayList<CobrarClientesNovedades>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesNovedadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesnovedadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarclientesnovedadess = new  ArrayList<CobrarClientesNovedades>();
		  		  
        try {
			//CobrarClientesNovedadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesnovedadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarclientesnovedadess = new  ArrayList<CobrarClientesNovedades>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesNovedadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesnovedadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclientesnovedadess = new  ArrayList<CobrarClientesNovedades>();
		  		  
        try {
			//CobrarClientesNovedadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesnovedadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarclientesnovedadess = new  ArrayList<CobrarClientesNovedades>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesNovedadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesnovedadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclientesnovedadess = new  ArrayList<CobrarClientesNovedades>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarClientesNovedadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesnovedadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarClientesNovedades> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesNovedades> entities = new  ArrayList<CobrarClientesNovedades>();
		CobrarClientesNovedades entity = new CobrarClientesNovedades();		  
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
	
	public  List<CobrarClientesNovedades> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesNovedades> entities = new  ArrayList<CobrarClientesNovedades>();
		CobrarClientesNovedades entity = new CobrarClientesNovedades();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesNovedades();
				
				
      	    	entity=CobrarClientesNovedadesLogic.getEntityCobrarClientesNovedades("",entity,resultSet);
      	    	
				//entity.setCobrarClientesNovedadesOriginal( new CobrarClientesNovedades());
      	    	//entity.setCobrarClientesNovedadesOriginal(super.getEntity("",entity.getCobrarClientesNovedadesOriginal(),resultSet,CobrarClientesNovedadesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarClientesNovedadesOriginal(CobrarClientesNovedadesDataAccess.getEntityCobrarClientesNovedades("",entity.getCobrarClientesNovedadesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarClientesNovedades> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesNovedades> entities = new  ArrayList<CobrarClientesNovedades>();
		CobrarClientesNovedades entity = new CobrarClientesNovedades();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarClientesNovedades.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesNovedades>((List<CobrarClientesNovedades>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesNovedadessOriginal(entities);
			
			}  else {
				this.cobrarclientesnovedadessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesNovedadesConstantesFunciones.quitarEspaciosCobrarClientesNovedadess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarClientesNovedades getEntityCobrarClientesNovedades(String strPrefijo,CobrarClientesNovedades entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarClientesNovedadesConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+CobrarClientesNovedadesConstantesFunciones.NOMBRE));
			entity.setapellido(resultSet.getString(strPrefijo+CobrarClientesNovedadesConstantesFunciones.APELLIDO));
			entity.setfeha_atencion(new Date(resultSet.getDate(strPrefijo+CobrarClientesNovedadesConstantesFunciones.FEHAATENCION).getTime()));
			entity.sethora_atencion(resultSet.getTime(strPrefijo+CobrarClientesNovedadesConstantesFunciones.HORAATENCION));
			entity.setaccion_tomada(resultSet.getString(strPrefijo+CobrarClientesNovedadesConstantesFunciones.ACCIONTOMADA));
			entity.setdescripcion(resultSet.getString(strPrefijo+CobrarClientesNovedadesConstantesFunciones.DESCRIPCION));
			entity.setesta_activo(resultSet.getBoolean(strPrefijo+CobrarClientesNovedadesConstantesFunciones.ESTAACTIVO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarClientesNovedades getEntityCobrarClientesNovedades(String strPrefijo,CobrarClientesNovedades entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarClientesNovedades.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarClientesNovedades.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarClientesNovedadesLogic.setFieldReflectionCobrarClientesNovedades(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarClientesNovedades(Field field,String strPrefijo,String sColumn,CobrarClientesNovedades entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarClientesNovedadesConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesNovedadesConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesNovedadesConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesNovedadesConstantesFunciones.FEHAATENCION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarClientesNovedadesConstantesFunciones.HORAATENCION:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case CobrarClientesNovedadesConstantesFunciones.ACCIONTOMADA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesNovedadesConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesNovedadesConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	public void quitarCobrarClientesNovedadessNulos() throws Exception {				
		
		List<CobrarClientesNovedades> cobrarclientesnovedadessAux= new ArrayList<CobrarClientesNovedades>();
		
		for(CobrarClientesNovedades cobrarclientesnovedades:cobrarclientesnovedadess) {
			if(cobrarclientesnovedades!=null) {
				cobrarclientesnovedadessAux.add(cobrarclientesnovedades);
			}
		}
		
		cobrarclientesnovedadess=cobrarclientesnovedadessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarClientesNovedades> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesNovedades> entities = new  ArrayList<CobrarClientesNovedades>();
		CobrarClientesNovedades entity = new CobrarClientesNovedades();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesNovedades>((List<CobrarClientesNovedades>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesNovedadessOriginal(entities);
			
			}  else {
				this.cobrarclientesnovedadessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesNovedadesConstantesFunciones.quitarEspaciosCobrarClientesNovedadess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarclientesnovedadess = new  ArrayList<CobrarClientesNovedades>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesNovedadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesnovedadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarclientesnovedadess = new  ArrayList<CobrarClientesNovedades>();
		  		  
        try {
			//CobrarClientesNovedadesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesnovedadess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarClientesNovedades> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesNovedades> entities = new  ArrayList<CobrarClientesNovedades>();
		CobrarClientesNovedades entity = new CobrarClientesNovedades();		  
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
	
	public  List<CobrarClientesNovedades> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesNovedades> entities = new  ArrayList<CobrarClientesNovedades>();
		CobrarClientesNovedades entity = new CobrarClientesNovedades();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesNovedades();
				
				if(conMapGenerico) {
					entity.setMapCobrarClientesNovedades( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarClientesNovedades().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarClientesNovedadesDataAccess.ISWITHSCHEMA);         		
					entity=CobrarClientesNovedadesLogic.getEntityCobrarClientesNovedades("",entity,resultSet,listColumns);
					
					////entity.setCobrarClientesNovedadesOriginal( new CobrarClientesNovedades());
					////entity.setCobrarClientesNovedadesOriginal(super.getEntity("",entity.getCobrarClientesNovedadesOriginal(),resultSet,CobrarClientesNovedadesDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarClientesNovedadesOriginal(CobrarClientesNovedadesDataAccess.getEntityCobrarClientesNovedades("",entity.getCobrarClientesNovedadesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarClientesNovedades relcobrarclientesnovedades)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarclientesnovedades.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CobrarClientesNovedades relcobrarclientesnovedades)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relcobrarclientesnovedades.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}


	
	
	public void getCobrarClientesNovedadessBusquedaCobrarClientesNovedadesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date feha_atencion_hasta)throws Exception {
		try {
			//CobrarClientesNovedadesLogic cobrarclientesnovedadesLogic=new CobrarClientesNovedadesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesNovedadesLogic.GetSelecSqlCobrarClientesNovedades(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,feha_atencion_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclientesnovedadess=this.getCobrarClientesNovedadess();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarClientesNovedadessBusquedaCobrarClientesNovedades(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date feha_atencion_hasta)throws Exception {
		try {
			//CobrarClientesNovedadesLogic cobrarclientesnovedadesLogic=new CobrarClientesNovedadesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesNovedadesLogic.GetSelecSqlCobrarClientesNovedades(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,feha_atencion_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclientesnovedadess=this.getCobrarClientesNovedadess();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarClientesNovedades(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date feha_atencion_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarClientesNovedades_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" c.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" c.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(feha_atencion_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" n.feha_atencion<="+"'"+Funciones2.getStringPostgresDate(feha_atencion_hasta)+"'";
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
	
	
	public void deepLoad(CobrarClientesNovedades cobrarclientesnovedades,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarClientesNovedadesLogicAdditional.updateCobrarClientesNovedadesToGet(cobrarclientesnovedades,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarclientesnovedades.setEmpresa(cobrarclientesnovedadesDataAccess.getEmpresa(connexion,cobrarclientesnovedades));
		cobrarclientesnovedades.setSucursal(cobrarclientesnovedadesDataAccess.getSucursal(connexion,cobrarclientesnovedades));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarclientesnovedades.setEmpresa(cobrarclientesnovedadesDataAccess.getEmpresa(connexion,cobrarclientesnovedades));
			}

			if(clas.clas.equals(Sucursal.class)) {
				cobrarclientesnovedades.setSucursal(cobrarclientesnovedadesDataAccess.getSucursal(connexion,cobrarclientesnovedades));
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
			cobrarclientesnovedades.setEmpresa(cobrarclientesnovedadesDataAccess.getEmpresa(connexion,cobrarclientesnovedades));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesnovedades.setSucursal(cobrarclientesnovedadesDataAccess.getSucursal(connexion,cobrarclientesnovedades));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarclientesnovedades.setEmpresa(cobrarclientesnovedadesDataAccess.getEmpresa(connexion,cobrarclientesnovedades));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarclientesnovedades.getEmpresa(),isDeep,deepLoadType,clases);
				
		cobrarclientesnovedades.setSucursal(cobrarclientesnovedadesDataAccess.getSucursal(connexion,cobrarclientesnovedades));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cobrarclientesnovedades.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarclientesnovedades.setEmpresa(cobrarclientesnovedadesDataAccess.getEmpresa(connexion,cobrarclientesnovedades));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarclientesnovedades.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				cobrarclientesnovedades.setSucursal(cobrarclientesnovedadesDataAccess.getSucursal(connexion,cobrarclientesnovedades));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cobrarclientesnovedades.getSucursal(),isDeep,deepLoadType,clases);				
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
			cobrarclientesnovedades.setEmpresa(cobrarclientesnovedadesDataAccess.getEmpresa(connexion,cobrarclientesnovedades));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarclientesnovedades.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesnovedades.setSucursal(cobrarclientesnovedadesDataAccess.getSucursal(connexion,cobrarclientesnovedades));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cobrarclientesnovedades.getSucursal(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarclientesnovedades,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesNovedadesConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesNovedades(cobrarclientesnovedades);
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
			this.deepLoad(this.cobrarclientesnovedades,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesNovedadesConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesNovedades(this.cobrarclientesnovedades);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarclientesnovedadess!=null) {
				for(CobrarClientesNovedades cobrarclientesnovedades:cobrarclientesnovedadess) {
					this.deepLoad(cobrarclientesnovedades,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesNovedadesConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesNovedades(cobrarclientesnovedadess);
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
			if(cobrarclientesnovedadess!=null) {
				for(CobrarClientesNovedades cobrarclientesnovedades:cobrarclientesnovedadess) {
					this.deepLoad(cobrarclientesnovedades,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesNovedadesConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesNovedades(cobrarclientesnovedadess);
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
	
	public CobrarClientesNovedadesParameterReturnGeneral procesarAccionCobrarClientesNovedadess(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesNovedades> cobrarclientesnovedadess,CobrarClientesNovedadesParameterReturnGeneral cobrarclientesnovedadesParameterGeneral)throws Exception {
		 try {	
			CobrarClientesNovedadesParameterReturnGeneral cobrarclientesnovedadesReturnGeneral=new CobrarClientesNovedadesParameterReturnGeneral();
	
			CobrarClientesNovedadesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclientesnovedadess,cobrarclientesnovedadesParameterGeneral,cobrarclientesnovedadesReturnGeneral);
			
			return cobrarclientesnovedadesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarClientesNovedadesParameterReturnGeneral procesarAccionCobrarClientesNovedadessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesNovedades> cobrarclientesnovedadess,CobrarClientesNovedadesParameterReturnGeneral cobrarclientesnovedadesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarClientesNovedadesParameterReturnGeneral cobrarclientesnovedadesReturnGeneral=new CobrarClientesNovedadesParameterReturnGeneral();
	
			CobrarClientesNovedadesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclientesnovedadess,cobrarclientesnovedadesParameterGeneral,cobrarclientesnovedadesReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarclientesnovedadesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

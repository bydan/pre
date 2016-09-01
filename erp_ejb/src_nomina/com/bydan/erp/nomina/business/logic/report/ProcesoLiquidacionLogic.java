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
package com.bydan.erp.nomina.business.logic.report;

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

import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;
import com.bydan.erp.nomina.util.report.ProcesoLiquidacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoLiquidacionParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoLiquidacionConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoLiquidacion;

import com.bydan.erp.nomina.business.logic.report.ProcesoLiquidacionLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;














@SuppressWarnings("unused")
public class ProcesoLiquidacionLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoLiquidacionLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoLiquidacionLogic procesoliquidacionDataAccess; 		
	protected ProcesoLiquidacion procesoliquidacion;
	protected List<ProcesoLiquidacion> procesoliquidacions;
	protected Object procesoliquidacionObject;	
	protected List<Object> procesoliquidacionsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoLiquidacionLogic()throws SQLException,Exception {
		try	{
			this.procesoliquidacions= new ArrayList<ProcesoLiquidacion>();
			this.procesoliquidacion= new ProcesoLiquidacion();
			this.procesoliquidacionObject=new Object();
			this.procesoliquidacionsObject=new ArrayList<Object>();
			
			this.procesoliquidacionDataAccess=this;
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
			this.procesoliquidacionDataAccess.setConnexionType(this.connexionType);
			this.procesoliquidacionDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoliquidacionDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoLiquidacionLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesoliquidacions= new ArrayList<ProcesoLiquidacion>();
			this.procesoliquidacion= new ProcesoLiquidacion();
			this.procesoliquidacionObject=new Object();
			this.procesoliquidacionsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesoliquidacionDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesoliquidacionDataAccess.setConnexionType(this.connexionType);
			this.procesoliquidacionDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoliquidacionDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoLiquidacion getProcesoLiquidacion() throws Exception {	
		ProcesoLiquidacionLogicAdditional.checkProcesoLiquidacionToGet(procesoliquidacion,this.datosCliente,this.arrDatoGeneral);
		ProcesoLiquidacionLogicAdditional.updateProcesoLiquidacionToGet(procesoliquidacion,this.arrDatoGeneral);
		
		return procesoliquidacion;
	}
		
	public void setProcesoLiquidacion(ProcesoLiquidacion newProcesoLiquidacion) {
		this.procesoliquidacion = newProcesoLiquidacion;
	}
	
	public List<ProcesoLiquidacion> getProcesoLiquidacions() throws Exception {		
		this.quitarProcesoLiquidacionsNulos();
		
		ProcesoLiquidacionLogicAdditional.checkProcesoLiquidacionToGets(procesoliquidacions,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoLiquidacion procesoliquidacionLocal: procesoliquidacions ) {
			ProcesoLiquidacionLogicAdditional.updateProcesoLiquidacionToGet(procesoliquidacionLocal,this.arrDatoGeneral);
		}
		
		return procesoliquidacions;
	}
	
	public void setProcesoLiquidacions(List<ProcesoLiquidacion> newProcesoLiquidacions) {
		this.procesoliquidacions = newProcesoLiquidacions;
	}
	
	public Object getProcesoLiquidacionObject() {	
		//this.procesoliquidacionObject=this.procesoliquidacionDataAccess.getEntityObject();
		return this.procesoliquidacionObject;
	}
		
	public void setProcesoLiquidacionObject(Object newProcesoLiquidacionObject) {
		this.procesoliquidacionObject = newProcesoLiquidacionObject;
	}
	
	public List<Object> getProcesoLiquidacionsObject() {		
		//this.procesoliquidacionsObject=this.procesoliquidacionDataAccess.getEntitiesObject();
		return this.procesoliquidacionsObject;
	}
		
	public void setProcesoLiquidacionsObject(List<Object> newProcesoLiquidacionsObject) {
		this.procesoliquidacionsObject = newProcesoLiquidacionsObject;
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
		procesoliquidacions = new  ArrayList<ProcesoLiquidacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoLiquidacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoliquidacions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesoliquidacions = new  ArrayList<ProcesoLiquidacion>();
		  		  
        try {
			//ProcesoLiquidacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoliquidacions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesoliquidacions = new  ArrayList<ProcesoLiquidacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoLiquidacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoliquidacions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoliquidacions = new  ArrayList<ProcesoLiquidacion>();
		  		  
        try {
			//ProcesoLiquidacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoliquidacions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesoliquidacions = new  ArrayList<ProcesoLiquidacion>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoLiquidacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoliquidacions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoliquidacions = new  ArrayList<ProcesoLiquidacion>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoLiquidacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoliquidacions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoLiquidacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoLiquidacion> entities = new  ArrayList<ProcesoLiquidacion>();
		ProcesoLiquidacion entity = new ProcesoLiquidacion();		  
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
	
	public  List<ProcesoLiquidacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoLiquidacion> entities = new  ArrayList<ProcesoLiquidacion>();
		ProcesoLiquidacion entity = new ProcesoLiquidacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoLiquidacion();
				
				
      	    	entity=ProcesoLiquidacionLogic.getEntityProcesoLiquidacion("",entity,resultSet);
      	    	
				//entity.setProcesoLiquidacionOriginal( new ProcesoLiquidacion());
      	    	//entity.setProcesoLiquidacionOriginal(super.getEntity("",entity.getProcesoLiquidacionOriginal(),resultSet,ProcesoLiquidacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoLiquidacionOriginal(ProcesoLiquidacionDataAccess.getEntityProcesoLiquidacion("",entity.getProcesoLiquidacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoLiquidacion> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoLiquidacion> entities = new  ArrayList<ProcesoLiquidacion>();
		ProcesoLiquidacion entity = new ProcesoLiquidacion();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoLiquidacion.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoLiquidacion>((List<ProcesoLiquidacion>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoLiquidacionsOriginal(entities);
			
			}  else {
				this.procesoliquidacionsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoLiquidacionConstantesFunciones.quitarEspaciosProcesoLiquidacions(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoLiquidacion getEntityProcesoLiquidacion(String strPrefijo,ProcesoLiquidacion entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ProcesoLiquidacionConstantesFunciones.FECHA).getTime()));
			entity.setes_reversar(resultSet.getBoolean(strPrefijo+ProcesoLiquidacionConstantesFunciones.ESREVERSAR));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoLiquidacion getEntityProcesoLiquidacion(String strPrefijo,ProcesoLiquidacion entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoLiquidacion.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoLiquidacion.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoLiquidacionLogic.setFieldReflectionProcesoLiquidacion(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoLiquidacion(Field field,String strPrefijo,String sColumn,ProcesoLiquidacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoLiquidacionConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProcesoLiquidacionConstantesFunciones.ESREVERSAR:
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
	
	public void quitarProcesoLiquidacionsNulos() throws Exception {				
		
		List<ProcesoLiquidacion> procesoliquidacionsAux= new ArrayList<ProcesoLiquidacion>();
		
		for(ProcesoLiquidacion procesoliquidacion:procesoliquidacions) {
			if(procesoliquidacion!=null) {
				procesoliquidacionsAux.add(procesoliquidacion);
			}
		}
		
		procesoliquidacions=procesoliquidacionsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoLiquidacion> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoLiquidacion> entities = new  ArrayList<ProcesoLiquidacion>();
		ProcesoLiquidacion entity = new ProcesoLiquidacion();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoLiquidacion>((List<ProcesoLiquidacion>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoLiquidacionsOriginal(entities);
			
			}  else {
				this.procesoliquidacionsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoLiquidacionConstantesFunciones.quitarEspaciosProcesoLiquidacions(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesoliquidacions = new  ArrayList<ProcesoLiquidacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoLiquidacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoliquidacions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesoliquidacions = new  ArrayList<ProcesoLiquidacion>();
		  		  
        try {
			//ProcesoLiquidacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoliquidacions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoLiquidacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoLiquidacion> entities = new  ArrayList<ProcesoLiquidacion>();
		ProcesoLiquidacion entity = new ProcesoLiquidacion();		  
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
	
	public  List<ProcesoLiquidacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoLiquidacion> entities = new  ArrayList<ProcesoLiquidacion>();
		ProcesoLiquidacion entity = new ProcesoLiquidacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoLiquidacion();
				
				if(conMapGenerico) {
					entity.setMapProcesoLiquidacion( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoLiquidacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoLiquidacionDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoLiquidacionLogic.getEntityProcesoLiquidacion("",entity,resultSet,listColumns);
					
					////entity.setProcesoLiquidacionOriginal( new ProcesoLiquidacion());
					////entity.setProcesoLiquidacionOriginal(super.getEntity("",entity.getProcesoLiquidacionOriginal(),resultSet,ProcesoLiquidacionDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoLiquidacionOriginal(ProcesoLiquidacionDataAccess.getEntityProcesoLiquidacion("",entity.getProcesoLiquidacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	public void getProcesoLiquidacionsBusquedaProcesoLiquidacionWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha,Boolean es_reversar)throws Exception {
		try {
			ProcesoLiquidacionLogicAdditional procesoliquidacionLogicAdditional=new ProcesoLiquidacionLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoliquidacionLogicAdditional.BusquedaProcesoLiquidacion(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha,es_reversar);

			//this.procesoliquidacions=this.getProcesoLiquidacions();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoLiquidacionLogicAdditional.ProcesarInformacionProcesoLiquidacion(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoliquidacionLogicAdditional,this.procesoliquidacions,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoLiquidacion",fecha,es_reversar);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoLiquidacionsBusquedaProcesoLiquidacion(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha,Boolean es_reversar)throws Exception {
		try {
			ProcesoLiquidacionLogicAdditional procesoliquidacionLogicAdditional=new ProcesoLiquidacionLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoliquidacionLogicAdditional.BusquedaProcesoLiquidacion(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha,es_reversar);

			//this.procesoliquidacions=this.getProcesoLiquidacions();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoLiquidacionLogicAdditional.ProcesarInformacionProcesoLiquidacion(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoliquidacionLogicAdditional,this.procesoliquidacions,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoLiquidacion",fecha,es_reversar);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoLiquidacion procesoliquidacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			ProcesoLiquidacionLogicAdditional.updateProcesoLiquidacionToGet(procesoliquidacion,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			this.deepLoad(procesoliquidacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoLiquidacionConstantesFunciones.refrescarForeignKeysDescripcionesProcesoLiquidacion(procesoliquidacion);
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
			this.deepLoad(this.procesoliquidacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoLiquidacionConstantesFunciones.refrescarForeignKeysDescripcionesProcesoLiquidacion(this.procesoliquidacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesoliquidacions!=null) {
				for(ProcesoLiquidacion procesoliquidacion:procesoliquidacions) {
					this.deepLoad(procesoliquidacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoLiquidacionConstantesFunciones.refrescarForeignKeysDescripcionesProcesoLiquidacion(procesoliquidacions);
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
			if(procesoliquidacions!=null) {
				for(ProcesoLiquidacion procesoliquidacion:procesoliquidacions) {
					this.deepLoad(procesoliquidacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoLiquidacionConstantesFunciones.refrescarForeignKeysDescripcionesProcesoLiquidacion(procesoliquidacions);
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
	
	public ProcesoLiquidacionParameterReturnGeneral procesarAccionProcesoLiquidacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoLiquidacion> procesoliquidacions,ProcesoLiquidacionParameterReturnGeneral procesoliquidacionParameterGeneral)throws Exception {
		 try {	
			ProcesoLiquidacionParameterReturnGeneral procesoliquidacionReturnGeneral=new ProcesoLiquidacionParameterReturnGeneral();
	
			ProcesoLiquidacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoliquidacions,procesoliquidacionParameterGeneral,procesoliquidacionReturnGeneral);
			
			return procesoliquidacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoLiquidacionParameterReturnGeneral procesarAccionProcesoLiquidacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoLiquidacion> procesoliquidacions,ProcesoLiquidacionParameterReturnGeneral procesoliquidacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoLiquidacionParameterReturnGeneral procesoliquidacionReturnGeneral=new ProcesoLiquidacionParameterReturnGeneral();
	
			ProcesoLiquidacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoliquidacions,procesoliquidacionParameterGeneral,procesoliquidacionReturnGeneral);
			
			this.connexion.commit();
			
			return procesoliquidacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoLiquidacion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoLiquidacion> procesoliquidacions,String sTipoBusqueda,Date fechaBusquedaProcesoLiquidacion,Boolean es_reversarBusquedaProcesoLiquidacion) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoLiquidacionLogicAdditional procesoliquidacionLogicAdditional=new ProcesoLiquidacionLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesoliquidacionLogicAdditional.setConnexion(this.connexion);

			procesoliquidacionLogicAdditional.ProcesarInformacionProcesoLiquidacion(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoliquidacions,sTipoBusqueda,fechaBusquedaProcesoLiquidacion,es_reversarBusquedaProcesoLiquidacion);

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

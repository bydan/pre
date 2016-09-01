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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;
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
import com.bydan.erp.contabilidad.util.report.ProcesoCierreEjercicioAnualParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoCierreEjercicioAnualParameterGeneral;
import com.bydan.erp.contabilidad.util.report.ProcesoCierreEjercicioAnualConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.ProcesoCierreEjercicioAnual;

import com.bydan.erp.contabilidad.business.logic.report.ProcesoCierreEjercicioAnualLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoCierreEjercicioAnualLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCierreEjercicioAnualLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCierreEjercicioAnualLogic procesocierreejercicioanualDataAccess; 		
	protected ProcesoCierreEjercicioAnual procesocierreejercicioanual;
	protected List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals;
	protected Object procesocierreejercicioanualObject;	
	protected List<Object> procesocierreejercicioanualsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCierreEjercicioAnualLogic()throws SQLException,Exception {
		try	{
			this.procesocierreejercicioanuals= new ArrayList<ProcesoCierreEjercicioAnual>();
			this.procesocierreejercicioanual= new ProcesoCierreEjercicioAnual();
			this.procesocierreejercicioanualObject=new Object();
			this.procesocierreejercicioanualsObject=new ArrayList<Object>();
			
			this.procesocierreejercicioanualDataAccess=this;
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
			this.procesocierreejercicioanualDataAccess.setConnexionType(this.connexionType);
			this.procesocierreejercicioanualDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocierreejercicioanualDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCierreEjercicioAnualLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocierreejercicioanuals= new ArrayList<ProcesoCierreEjercicioAnual>();
			this.procesocierreejercicioanual= new ProcesoCierreEjercicioAnual();
			this.procesocierreejercicioanualObject=new Object();
			this.procesocierreejercicioanualsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocierreejercicioanualDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocierreejercicioanualDataAccess.setConnexionType(this.connexionType);
			this.procesocierreejercicioanualDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocierreejercicioanualDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCierreEjercicioAnual getProcesoCierreEjercicioAnual() throws Exception {	
		ProcesoCierreEjercicioAnualLogicAdditional.checkProcesoCierreEjercicioAnualToGet(procesocierreejercicioanual,this.datosCliente,this.arrDatoGeneral);
		ProcesoCierreEjercicioAnualLogicAdditional.updateProcesoCierreEjercicioAnualToGet(procesocierreejercicioanual,this.arrDatoGeneral);
		
		return procesocierreejercicioanual;
	}
		
	public void setProcesoCierreEjercicioAnual(ProcesoCierreEjercicioAnual newProcesoCierreEjercicioAnual) {
		this.procesocierreejercicioanual = newProcesoCierreEjercicioAnual;
	}
	
	public List<ProcesoCierreEjercicioAnual> getProcesoCierreEjercicioAnuals() throws Exception {		
		this.quitarProcesoCierreEjercicioAnualsNulos();
		
		ProcesoCierreEjercicioAnualLogicAdditional.checkProcesoCierreEjercicioAnualToGets(procesocierreejercicioanuals,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCierreEjercicioAnual procesocierreejercicioanualLocal: procesocierreejercicioanuals ) {
			ProcesoCierreEjercicioAnualLogicAdditional.updateProcesoCierreEjercicioAnualToGet(procesocierreejercicioanualLocal,this.arrDatoGeneral);
		}
		
		return procesocierreejercicioanuals;
	}
	
	public void setProcesoCierreEjercicioAnuals(List<ProcesoCierreEjercicioAnual> newProcesoCierreEjercicioAnuals) {
		this.procesocierreejercicioanuals = newProcesoCierreEjercicioAnuals;
	}
	
	public Object getProcesoCierreEjercicioAnualObject() {	
		//this.procesocierreejercicioanualObject=this.procesocierreejercicioanualDataAccess.getEntityObject();
		return this.procesocierreejercicioanualObject;
	}
		
	public void setProcesoCierreEjercicioAnualObject(Object newProcesoCierreEjercicioAnualObject) {
		this.procesocierreejercicioanualObject = newProcesoCierreEjercicioAnualObject;
	}
	
	public List<Object> getProcesoCierreEjercicioAnualsObject() {		
		//this.procesocierreejercicioanualsObject=this.procesocierreejercicioanualDataAccess.getEntitiesObject();
		return this.procesocierreejercicioanualsObject;
	}
		
	public void setProcesoCierreEjercicioAnualsObject(List<Object> newProcesoCierreEjercicioAnualsObject) {
		this.procesocierreejercicioanualsObject = newProcesoCierreEjercicioAnualsObject;
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
		procesocierreejercicioanuals = new  ArrayList<ProcesoCierreEjercicioAnual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreEjercicioAnualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreejercicioanuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocierreejercicioanuals = new  ArrayList<ProcesoCierreEjercicioAnual>();
		  		  
        try {
			//ProcesoCierreEjercicioAnualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreejercicioanuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocierreejercicioanuals = new  ArrayList<ProcesoCierreEjercicioAnual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreEjercicioAnualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreejercicioanuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocierreejercicioanuals = new  ArrayList<ProcesoCierreEjercicioAnual>();
		  		  
        try {
			//ProcesoCierreEjercicioAnualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreejercicioanuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocierreejercicioanuals = new  ArrayList<ProcesoCierreEjercicioAnual>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreEjercicioAnualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreejercicioanuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocierreejercicioanuals = new  ArrayList<ProcesoCierreEjercicioAnual>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCierreEjercicioAnualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreejercicioanuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCierreEjercicioAnual> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreEjercicioAnual> entities = new  ArrayList<ProcesoCierreEjercicioAnual>();
		ProcesoCierreEjercicioAnual entity = new ProcesoCierreEjercicioAnual();		  
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
	
	public  List<ProcesoCierreEjercicioAnual> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreEjercicioAnual> entities = new  ArrayList<ProcesoCierreEjercicioAnual>();
		ProcesoCierreEjercicioAnual entity = new ProcesoCierreEjercicioAnual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCierreEjercicioAnual();
				
				
      	    	entity=ProcesoCierreEjercicioAnualLogic.getEntityProcesoCierreEjercicioAnual("",entity,resultSet);
      	    	
				//entity.setProcesoCierreEjercicioAnualOriginal( new ProcesoCierreEjercicioAnual());
      	    	//entity.setProcesoCierreEjercicioAnualOriginal(super.getEntity("",entity.getProcesoCierreEjercicioAnualOriginal(),resultSet,ProcesoCierreEjercicioAnualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCierreEjercicioAnualOriginal(ProcesoCierreEjercicioAnualDataAccess.getEntityProcesoCierreEjercicioAnual("",entity.getProcesoCierreEjercicioAnualOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCierreEjercicioAnual> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreEjercicioAnual> entities = new  ArrayList<ProcesoCierreEjercicioAnual>();
		ProcesoCierreEjercicioAnual entity = new ProcesoCierreEjercicioAnual();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCierreEjercicioAnual.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCierreEjercicioAnual>((List<ProcesoCierreEjercicioAnual>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCierreEjercicioAnualsOriginal(entities);
			
			}  else {
				this.procesocierreejercicioanualsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCierreEjercicioAnualConstantesFunciones.quitarEspaciosProcesoCierreEjercicioAnuals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCierreEjercicioAnual getEntityProcesoCierreEjercicioAnual(String strPrefijo,ProcesoCierreEjercicioAnual entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_tipo_documento(resultSet.getLong(strPrefijo+ProcesoCierreEjercicioAnualConstantesFunciones.IDTIPODOCUMENTO));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ProcesoCierreEjercicioAnualConstantesFunciones.FECHA).getTime()));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCierreEjercicioAnual getEntityProcesoCierreEjercicioAnual(String strPrefijo,ProcesoCierreEjercicioAnual entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCierreEjercicioAnual.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCierreEjercicioAnual.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCierreEjercicioAnualLogic.setFieldReflectionProcesoCierreEjercicioAnual(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCierreEjercicioAnual(Field field,String strPrefijo,String sColumn,ProcesoCierreEjercicioAnual entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoCierreEjercicioAnualConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCierreEjercicioAnualConstantesFunciones.FECHA:
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
	
	public void quitarProcesoCierreEjercicioAnualsNulos() throws Exception {				
		
		List<ProcesoCierreEjercicioAnual> procesocierreejercicioanualsAux= new ArrayList<ProcesoCierreEjercicioAnual>();
		
		for(ProcesoCierreEjercicioAnual procesocierreejercicioanual:procesocierreejercicioanuals) {
			if(procesocierreejercicioanual!=null) {
				procesocierreejercicioanualsAux.add(procesocierreejercicioanual);
			}
		}
		
		procesocierreejercicioanuals=procesocierreejercicioanualsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCierreEjercicioAnual> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreEjercicioAnual> entities = new  ArrayList<ProcesoCierreEjercicioAnual>();
		ProcesoCierreEjercicioAnual entity = new ProcesoCierreEjercicioAnual();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCierreEjercicioAnual>((List<ProcesoCierreEjercicioAnual>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCierreEjercicioAnualsOriginal(entities);
			
			}  else {
				this.procesocierreejercicioanualsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCierreEjercicioAnualConstantesFunciones.quitarEspaciosProcesoCierreEjercicioAnuals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocierreejercicioanuals = new  ArrayList<ProcesoCierreEjercicioAnual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreEjercicioAnualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreejercicioanuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesocierreejercicioanuals = new  ArrayList<ProcesoCierreEjercicioAnual>();
		  		  
        try {
			//ProcesoCierreEjercicioAnualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreejercicioanuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCierreEjercicioAnual> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCierreEjercicioAnual> entities = new  ArrayList<ProcesoCierreEjercicioAnual>();
		ProcesoCierreEjercicioAnual entity = new ProcesoCierreEjercicioAnual();		  
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
	
	public  List<ProcesoCierreEjercicioAnual> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCierreEjercicioAnual> entities = new  ArrayList<ProcesoCierreEjercicioAnual>();
		ProcesoCierreEjercicioAnual entity = new ProcesoCierreEjercicioAnual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCierreEjercicioAnual();
				
				if(conMapGenerico) {
					entity.setMapProcesoCierreEjercicioAnual( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCierreEjercicioAnual().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCierreEjercicioAnualDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCierreEjercicioAnualLogic.getEntityProcesoCierreEjercicioAnual("",entity,resultSet,listColumns);
					
					////entity.setProcesoCierreEjercicioAnualOriginal( new ProcesoCierreEjercicioAnual());
					////entity.setProcesoCierreEjercicioAnualOriginal(super.getEntity("",entity.getProcesoCierreEjercicioAnualOriginal(),resultSet,ProcesoCierreEjercicioAnualDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCierreEjercicioAnualOriginal(ProcesoCierreEjercicioAnualDataAccess.getEntityProcesoCierreEjercicioAnual("",entity.getProcesoCierreEjercicioAnualOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public TipoDocumento getTipoDocumento(Connexion connexion,ProcesoCierreEjercicioAnual relprocesocierreejercicioanual)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);
			tipodocumentoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relprocesocierreejercicioanual.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}


	
	
	public void getProcesoCierreEjercicioAnualsBusquedaProcesoCierreEjercicioAnualWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_documento,Date fecha)throws Exception {
		try {
			ProcesoCierreEjercicioAnualLogicAdditional procesocierreejercicioanualLogicAdditional=new ProcesoCierreEjercicioAnualLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocierreejercicioanualLogicAdditional.BusquedaProcesoCierreEjercicioAnual(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_documento,fecha);

			//this.procesocierreejercicioanuals=this.getProcesoCierreEjercicioAnuals();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCierreEjercicioAnualLogicAdditional.ProcesarInformacionProcesoCierreEjercicioAnual(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierreejercicioanualLogicAdditional,this.procesocierreejercicioanuals,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCierreEjercicioAnual",id_tipo_documento,fecha);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCierreEjercicioAnualsBusquedaProcesoCierreEjercicioAnual(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_documento,Date fecha)throws Exception {
		try {
			ProcesoCierreEjercicioAnualLogicAdditional procesocierreejercicioanualLogicAdditional=new ProcesoCierreEjercicioAnualLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocierreejercicioanualLogicAdditional.BusquedaProcesoCierreEjercicioAnual(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_documento,fecha);

			//this.procesocierreejercicioanuals=this.getProcesoCierreEjercicioAnuals();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCierreEjercicioAnualLogicAdditional.ProcesarInformacionProcesoCierreEjercicioAnual(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierreejercicioanualLogicAdditional,this.procesocierreejercicioanuals,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCierreEjercicioAnual",id_tipo_documento,fecha);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoCierreEjercicioAnual procesocierreejercicioanual,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoCierreEjercicioAnualLogicAdditional.updateProcesoCierreEjercicioAnualToGet(procesocierreejercicioanual,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocierreejercicioanual.setTipoDocumento(procesocierreejercicioanualDataAccess.getTipoDocumento(connexion,procesocierreejercicioanual));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				procesocierreejercicioanual.setTipoDocumento(procesocierreejercicioanualDataAccess.getTipoDocumento(connexion,procesocierreejercicioanual));
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
			procesocierreejercicioanual.setTipoDocumento(procesocierreejercicioanualDataAccess.getTipoDocumento(connexion,procesocierreejercicioanual));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocierreejercicioanual.setTipoDocumento(procesocierreejercicioanualDataAccess.getTipoDocumento(connexion,procesocierreejercicioanual));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(procesocierreejercicioanual.getTipoDocumento(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				procesocierreejercicioanual.setTipoDocumento(procesocierreejercicioanualDataAccess.getTipoDocumento(connexion,procesocierreejercicioanual));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(procesocierreejercicioanual.getTipoDocumento(),isDeep,deepLoadType,clases);				
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
			procesocierreejercicioanual.setTipoDocumento(procesocierreejercicioanualDataAccess.getTipoDocumento(connexion,procesocierreejercicioanual));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(procesocierreejercicioanual.getTipoDocumento(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesocierreejercicioanual,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCierreEjercicioAnualConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreEjercicioAnual(procesocierreejercicioanual);
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
			this.deepLoad(this.procesocierreejercicioanual,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCierreEjercicioAnualConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreEjercicioAnual(this.procesocierreejercicioanual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocierreejercicioanuals!=null) {
				for(ProcesoCierreEjercicioAnual procesocierreejercicioanual:procesocierreejercicioanuals) {
					this.deepLoad(procesocierreejercicioanual,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCierreEjercicioAnualConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreEjercicioAnual(procesocierreejercicioanuals);
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
			if(procesocierreejercicioanuals!=null) {
				for(ProcesoCierreEjercicioAnual procesocierreejercicioanual:procesocierreejercicioanuals) {
					this.deepLoad(procesocierreejercicioanual,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCierreEjercicioAnualConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreEjercicioAnual(procesocierreejercicioanuals);
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
	
	public ProcesoCierreEjercicioAnualParameterReturnGeneral procesarAccionProcesoCierreEjercicioAnuals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals,ProcesoCierreEjercicioAnualParameterReturnGeneral procesocierreejercicioanualParameterGeneral)throws Exception {
		 try {	
			ProcesoCierreEjercicioAnualParameterReturnGeneral procesocierreejercicioanualReturnGeneral=new ProcesoCierreEjercicioAnualParameterReturnGeneral();
	
			ProcesoCierreEjercicioAnualLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocierreejercicioanuals,procesocierreejercicioanualParameterGeneral,procesocierreejercicioanualReturnGeneral);
			
			return procesocierreejercicioanualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCierreEjercicioAnualParameterReturnGeneral procesarAccionProcesoCierreEjercicioAnualsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals,ProcesoCierreEjercicioAnualParameterReturnGeneral procesocierreejercicioanualParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCierreEjercicioAnualParameterReturnGeneral procesocierreejercicioanualReturnGeneral=new ProcesoCierreEjercicioAnualParameterReturnGeneral();
	
			ProcesoCierreEjercicioAnualLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocierreejercicioanuals,procesocierreejercicioanualParameterGeneral,procesocierreejercicioanualReturnGeneral);
			
			this.connexion.commit();
			
			return procesocierreejercicioanualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoCierreEjercicioAnual(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals,String sTipoBusqueda,Long id_tipo_documentoBusquedaProcesoCierreEjercicioAnual,Date fechaBusquedaProcesoCierreEjercicioAnual) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoCierreEjercicioAnualLogicAdditional procesocierreejercicioanualLogicAdditional=new ProcesoCierreEjercicioAnualLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesocierreejercicioanualLogicAdditional.setConnexion(this.connexion);

			procesocierreejercicioanualLogicAdditional.ProcesarInformacionProcesoCierreEjercicioAnual(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierreejercicioanuals,sTipoBusqueda,id_tipo_documentoBusquedaProcesoCierreEjercicioAnual,fechaBusquedaProcesoCierreEjercicioAnual);

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

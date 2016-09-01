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
package com.bydan.erp.seguridad.business.logic.report;

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

import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.resources.general.AuxiliarGeneral;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarEmpresaSucursalParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.report.ProcesoCambiarEmpresaSucursalParameterGeneral;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarEmpresaSucursalConstantesFunciones;
import com.bydan.erp.seguridad.business.entity.report.ProcesoCambiarEmpresaSucursal;

import com.bydan.erp.seguridad.business.logic.report.ProcesoCambiarEmpresaSucursalLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoCambiarEmpresaSucursalLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCambiarEmpresaSucursalLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCambiarEmpresaSucursalLogic procesocambiarempresasucursalDataAccess; 		
	protected ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal;
	protected List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals;
	protected Object procesocambiarempresasucursalObject;	
	protected List<Object> procesocambiarempresasucursalsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCambiarEmpresaSucursalLogic()throws SQLException,Exception {
		try	{
			this.procesocambiarempresasucursals= new ArrayList<ProcesoCambiarEmpresaSucursal>();
			this.procesocambiarempresasucursal= new ProcesoCambiarEmpresaSucursal();
			this.procesocambiarempresasucursalObject=new Object();
			this.procesocambiarempresasucursalsObject=new ArrayList<Object>();
			
			this.procesocambiarempresasucursalDataAccess=this;
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
			this.procesocambiarempresasucursalDataAccess.setConnexionType(this.connexionType);
			this.procesocambiarempresasucursalDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocambiarempresasucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCambiarEmpresaSucursalLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocambiarempresasucursals= new ArrayList<ProcesoCambiarEmpresaSucursal>();
			this.procesocambiarempresasucursal= new ProcesoCambiarEmpresaSucursal();
			this.procesocambiarempresasucursalObject=new Object();
			this.procesocambiarempresasucursalsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocambiarempresasucursalDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocambiarempresasucursalDataAccess.setConnexionType(this.connexionType);
			this.procesocambiarempresasucursalDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocambiarempresasucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCambiarEmpresaSucursal getProcesoCambiarEmpresaSucursal() throws Exception {	
		ProcesoCambiarEmpresaSucursalLogicAdditional.checkProcesoCambiarEmpresaSucursalToGet(procesocambiarempresasucursal,this.datosCliente,this.arrDatoGeneral);
		ProcesoCambiarEmpresaSucursalLogicAdditional.updateProcesoCambiarEmpresaSucursalToGet(procesocambiarempresasucursal,this.arrDatoGeneral);
		
		return procesocambiarempresasucursal;
	}
		
	public void setProcesoCambiarEmpresaSucursal(ProcesoCambiarEmpresaSucursal newProcesoCambiarEmpresaSucursal) {
		this.procesocambiarempresasucursal = newProcesoCambiarEmpresaSucursal;
	}
	
	public List<ProcesoCambiarEmpresaSucursal> getProcesoCambiarEmpresaSucursals() throws Exception {		
		this.quitarProcesoCambiarEmpresaSucursalsNulos();
		
		ProcesoCambiarEmpresaSucursalLogicAdditional.checkProcesoCambiarEmpresaSucursalToGets(procesocambiarempresasucursals,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalLocal: procesocambiarempresasucursals ) {
			ProcesoCambiarEmpresaSucursalLogicAdditional.updateProcesoCambiarEmpresaSucursalToGet(procesocambiarempresasucursalLocal,this.arrDatoGeneral);
		}
		
		return procesocambiarempresasucursals;
	}
	
	public void setProcesoCambiarEmpresaSucursals(List<ProcesoCambiarEmpresaSucursal> newProcesoCambiarEmpresaSucursals) {
		this.procesocambiarempresasucursals = newProcesoCambiarEmpresaSucursals;
	}
	
	public Object getProcesoCambiarEmpresaSucursalObject() {	
		//this.procesocambiarempresasucursalObject=this.procesocambiarempresasucursalDataAccess.getEntityObject();
		return this.procesocambiarempresasucursalObject;
	}
		
	public void setProcesoCambiarEmpresaSucursalObject(Object newProcesoCambiarEmpresaSucursalObject) {
		this.procesocambiarempresasucursalObject = newProcesoCambiarEmpresaSucursalObject;
	}
	
	public List<Object> getProcesoCambiarEmpresaSucursalsObject() {		
		//this.procesocambiarempresasucursalsObject=this.procesocambiarempresasucursalDataAccess.getEntitiesObject();
		return this.procesocambiarempresasucursalsObject;
	}
		
	public void setProcesoCambiarEmpresaSucursalsObject(List<Object> newProcesoCambiarEmpresaSucursalsObject) {
		this.procesocambiarempresasucursalsObject = newProcesoCambiarEmpresaSucursalsObject;
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
		procesocambiarempresasucursals = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarEmpresaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarempresasucursals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocambiarempresasucursals = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		  		  
        try {
			//ProcesoCambiarEmpresaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarempresasucursals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocambiarempresasucursals = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarEmpresaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarempresasucursals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocambiarempresasucursals = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		  		  
        try {
			//ProcesoCambiarEmpresaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarempresasucursals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocambiarempresasucursals = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarEmpresaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarempresasucursals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocambiarempresasucursals = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCambiarEmpresaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarempresasucursals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCambiarEmpresaSucursal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarEmpresaSucursal> entities = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		ProcesoCambiarEmpresaSucursal entity = new ProcesoCambiarEmpresaSucursal();		  
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
	
	public  List<ProcesoCambiarEmpresaSucursal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarEmpresaSucursal> entities = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		ProcesoCambiarEmpresaSucursal entity = new ProcesoCambiarEmpresaSucursal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCambiarEmpresaSucursal();
				
				
      	    	entity=ProcesoCambiarEmpresaSucursalLogic.getEntityProcesoCambiarEmpresaSucursal("",entity,resultSet);
      	    	
				//entity.setProcesoCambiarEmpresaSucursalOriginal( new ProcesoCambiarEmpresaSucursal());
      	    	//entity.setProcesoCambiarEmpresaSucursalOriginal(super.getEntity("",entity.getProcesoCambiarEmpresaSucursalOriginal(),resultSet,ProcesoCambiarEmpresaSucursalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCambiarEmpresaSucursalOriginal(ProcesoCambiarEmpresaSucursalDataAccess.getEntityProcesoCambiarEmpresaSucursal("",entity.getProcesoCambiarEmpresaSucursalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCambiarEmpresaSucursal> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarEmpresaSucursal> entities = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		ProcesoCambiarEmpresaSucursal entity = new ProcesoCambiarEmpresaSucursal();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCambiarEmpresaSucursal.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCambiarEmpresaSucursal>((List<ProcesoCambiarEmpresaSucursal>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCambiarEmpresaSucursalsOriginal(entities);
			
			}  else {
				this.procesocambiarempresasucursalsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCambiarEmpresaSucursalConstantesFunciones.quitarEspaciosProcesoCambiarEmpresaSucursals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCambiarEmpresaSucursal getEntityProcesoCambiarEmpresaSucursal(String strPrefijo,ProcesoCambiarEmpresaSucursal entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCambiarEmpresaSucursal getEntityProcesoCambiarEmpresaSucursal(String strPrefijo,ProcesoCambiarEmpresaSucursal entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCambiarEmpresaSucursal.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCambiarEmpresaSucursal.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCambiarEmpresaSucursalLogic.setFieldReflectionProcesoCambiarEmpresaSucursal(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCambiarEmpresaSucursal(Field field,String strPrefijo,String sColumn,ProcesoCambiarEmpresaSucursal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
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
	
	public void quitarProcesoCambiarEmpresaSucursalsNulos() throws Exception {				
		
		List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursalsAux= new ArrayList<ProcesoCambiarEmpresaSucursal>();
		
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal:procesocambiarempresasucursals) {
			if(procesocambiarempresasucursal!=null) {
				procesocambiarempresasucursalsAux.add(procesocambiarempresasucursal);
			}
		}
		
		procesocambiarempresasucursals=procesocambiarempresasucursalsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCambiarEmpresaSucursal> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarEmpresaSucursal> entities = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		ProcesoCambiarEmpresaSucursal entity = new ProcesoCambiarEmpresaSucursal();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCambiarEmpresaSucursal>((List<ProcesoCambiarEmpresaSucursal>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCambiarEmpresaSucursalsOriginal(entities);
			
			}  else {
				this.procesocambiarempresasucursalsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCambiarEmpresaSucursalConstantesFunciones.quitarEspaciosProcesoCambiarEmpresaSucursals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocambiarempresasucursals = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarEmpresaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarempresasucursals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesocambiarempresasucursals = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		  		  
        try {
			//ProcesoCambiarEmpresaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarempresasucursals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCambiarEmpresaSucursal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCambiarEmpresaSucursal> entities = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		ProcesoCambiarEmpresaSucursal entity = new ProcesoCambiarEmpresaSucursal();		  
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
	
	public  List<ProcesoCambiarEmpresaSucursal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCambiarEmpresaSucursal> entities = new  ArrayList<ProcesoCambiarEmpresaSucursal>();
		ProcesoCambiarEmpresaSucursal entity = new ProcesoCambiarEmpresaSucursal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCambiarEmpresaSucursal();
				
				if(conMapGenerico) {
					entity.setMapProcesoCambiarEmpresaSucursal( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCambiarEmpresaSucursal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCambiarEmpresaSucursalDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCambiarEmpresaSucursalLogic.getEntityProcesoCambiarEmpresaSucursal("",entity,resultSet,listColumns);
					
					////entity.setProcesoCambiarEmpresaSucursalOriginal( new ProcesoCambiarEmpresaSucursal());
					////entity.setProcesoCambiarEmpresaSucursalOriginal(super.getEntity("",entity.getProcesoCambiarEmpresaSucursalOriginal(),resultSet,ProcesoCambiarEmpresaSucursalDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCambiarEmpresaSucursalOriginal(ProcesoCambiarEmpresaSucursalDataAccess.getEntityProcesoCambiarEmpresaSucursal("",entity.getProcesoCambiarEmpresaSucursalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ProcesoCambiarEmpresaSucursal relprocesocambiarempresasucursal)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relprocesocambiarempresasucursal.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProcesoCambiarEmpresaSucursal relprocesocambiarempresasucursal)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relprocesocambiarempresasucursal.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}


	
	
	public void getProcesoCambiarEmpresaSucursalsBusquedaProcesoCambiarEmpresaSucursalWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_empresa,Long id_sucursal)throws Exception {
		try {
			ProcesoCambiarEmpresaSucursalLogicAdditional procesocambiarempresasucursalLogicAdditional=new ProcesoCambiarEmpresaSucursalLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocambiarempresasucursalLogicAdditional.BusquedaProcesoCambiarEmpresaSucursal(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_empresa,id_sucursal);

			//this.procesocambiarempresasucursals=this.getProcesoCambiarEmpresaSucursals();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCambiarEmpresaSucursalLogicAdditional.ProcesarInformacionProcesoCambiarEmpresaSucursal(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocambiarempresasucursalLogicAdditional,this.procesocambiarempresasucursals,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCambiarEmpresaSucursal",id_empresa,id_sucursal);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCambiarEmpresaSucursalsBusquedaProcesoCambiarEmpresaSucursal(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_empresa,Long id_sucursal)throws Exception {
		try {
			ProcesoCambiarEmpresaSucursalLogicAdditional procesocambiarempresasucursalLogicAdditional=new ProcesoCambiarEmpresaSucursalLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocambiarempresasucursalLogicAdditional.BusquedaProcesoCambiarEmpresaSucursal(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_empresa,id_sucursal);

			//this.procesocambiarempresasucursals=this.getProcesoCambiarEmpresaSucursals();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCambiarEmpresaSucursalLogicAdditional.ProcesarInformacionProcesoCambiarEmpresaSucursal(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocambiarempresasucursalLogicAdditional,this.procesocambiarempresasucursals,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCambiarEmpresaSucursal",id_empresa,id_sucursal);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoCambiarEmpresaSucursalLogicAdditional.updateProcesoCambiarEmpresaSucursalToGet(procesocambiarempresasucursal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocambiarempresasucursal.setEmpresa(procesocambiarempresasucursalDataAccess.getEmpresa(connexion,procesocambiarempresasucursal));
		procesocambiarempresasucursal.setSucursal(procesocambiarempresasucursalDataAccess.getSucursal(connexion,procesocambiarempresasucursal));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				procesocambiarempresasucursal.setEmpresa(procesocambiarempresasucursalDataAccess.getEmpresa(connexion,procesocambiarempresasucursal));
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesocambiarempresasucursal.setSucursal(procesocambiarempresasucursalDataAccess.getSucursal(connexion,procesocambiarempresasucursal));
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
			procesocambiarempresasucursal.setEmpresa(procesocambiarempresasucursalDataAccess.getEmpresa(connexion,procesocambiarempresasucursal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarempresasucursal.setSucursal(procesocambiarempresasucursalDataAccess.getSucursal(connexion,procesocambiarempresasucursal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocambiarempresasucursal.setEmpresa(procesocambiarempresasucursalDataAccess.getEmpresa(connexion,procesocambiarempresasucursal));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(procesocambiarempresasucursal.getEmpresa(),isDeep,deepLoadType,clases);
				
		procesocambiarempresasucursal.setSucursal(procesocambiarempresasucursalDataAccess.getSucursal(connexion,procesocambiarempresasucursal));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(procesocambiarempresasucursal.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				procesocambiarempresasucursal.setEmpresa(procesocambiarempresasucursalDataAccess.getEmpresa(connexion,procesocambiarempresasucursal));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(procesocambiarempresasucursal.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesocambiarempresasucursal.setSucursal(procesocambiarempresasucursalDataAccess.getSucursal(connexion,procesocambiarempresasucursal));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(procesocambiarempresasucursal.getSucursal(),isDeep,deepLoadType,clases);				
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
			procesocambiarempresasucursal.setEmpresa(procesocambiarempresasucursalDataAccess.getEmpresa(connexion,procesocambiarempresasucursal));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(procesocambiarempresasucursal.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarempresasucursal.setSucursal(procesocambiarempresasucursalDataAccess.getSucursal(connexion,procesocambiarempresasucursal));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(procesocambiarempresasucursal.getSucursal(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesocambiarempresasucursal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCambiarEmpresaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarEmpresaSucursal(procesocambiarempresasucursal);
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
			this.deepLoad(this.procesocambiarempresasucursal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCambiarEmpresaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarEmpresaSucursal(this.procesocambiarempresasucursal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocambiarempresasucursals!=null) {
				for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal:procesocambiarempresasucursals) {
					this.deepLoad(procesocambiarempresasucursal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCambiarEmpresaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarEmpresaSucursal(procesocambiarempresasucursals);
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
			if(procesocambiarempresasucursals!=null) {
				for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal:procesocambiarempresasucursals) {
					this.deepLoad(procesocambiarempresasucursal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCambiarEmpresaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarEmpresaSucursal(procesocambiarempresasucursals);
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
	
	public ProcesoCambiarEmpresaSucursalParameterReturnGeneral procesarAccionProcesoCambiarEmpresaSucursals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,ProcesoCambiarEmpresaSucursalParameterReturnGeneral procesocambiarempresasucursalParameterGeneral)throws Exception {
		 try {	
			ProcesoCambiarEmpresaSucursalParameterReturnGeneral procesocambiarempresasucursalReturnGeneral=new ProcesoCambiarEmpresaSucursalParameterReturnGeneral();
	
			ProcesoCambiarEmpresaSucursalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocambiarempresasucursals,procesocambiarempresasucursalParameterGeneral,procesocambiarempresasucursalReturnGeneral);
			
			return procesocambiarempresasucursalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCambiarEmpresaSucursalParameterReturnGeneral procesarAccionProcesoCambiarEmpresaSucursalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,ProcesoCambiarEmpresaSucursalParameterReturnGeneral procesocambiarempresasucursalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCambiarEmpresaSucursalParameterReturnGeneral procesocambiarempresasucursalReturnGeneral=new ProcesoCambiarEmpresaSucursalParameterReturnGeneral();
	
			ProcesoCambiarEmpresaSucursalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocambiarempresasucursals,procesocambiarempresasucursalParameterGeneral,procesocambiarempresasucursalReturnGeneral);
			
			this.connexion.commit();
			
			return procesocambiarempresasucursalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoCambiarEmpresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,String sTipoBusqueda,Long id_empresaBusquedaProcesoCambiarEmpresaSucursal,Long id_sucursalBusquedaProcesoCambiarEmpresaSucursal) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoCambiarEmpresaSucursalLogicAdditional procesocambiarempresasucursalLogicAdditional=new ProcesoCambiarEmpresaSucursalLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesocambiarempresasucursalLogicAdditional.setConnexion(this.connexion);

			procesocambiarempresasucursalLogicAdditional.ProcesarInformacionProcesoCambiarEmpresaSucursal(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocambiarempresasucursals,sTipoBusqueda,id_empresaBusquedaProcesoCambiarEmpresaSucursal,id_sucursalBusquedaProcesoCambiarEmpresaSucursal);

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

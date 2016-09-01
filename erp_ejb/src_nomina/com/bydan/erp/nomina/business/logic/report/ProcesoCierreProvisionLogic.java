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
import com.bydan.erp.nomina.util.report.ProcesoCierreProvisionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoCierreProvisionParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoCierreProvisionConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoCierreProvision;

import com.bydan.erp.nomina.business.logic.report.ProcesoCierreProvisionLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoCierreProvisionLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCierreProvisionLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCierreProvisionLogic procesocierreprovisionDataAccess; 		
	protected ProcesoCierreProvision procesocierreprovision;
	protected List<ProcesoCierreProvision> procesocierreprovisions;
	protected Object procesocierreprovisionObject;	
	protected List<Object> procesocierreprovisionsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCierreProvisionLogic()throws SQLException,Exception {
		try	{
			this.procesocierreprovisions= new ArrayList<ProcesoCierreProvision>();
			this.procesocierreprovision= new ProcesoCierreProvision();
			this.procesocierreprovisionObject=new Object();
			this.procesocierreprovisionsObject=new ArrayList<Object>();
			
			this.procesocierreprovisionDataAccess=this;
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
			this.procesocierreprovisionDataAccess.setConnexionType(this.connexionType);
			this.procesocierreprovisionDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocierreprovisionDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCierreProvisionLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocierreprovisions= new ArrayList<ProcesoCierreProvision>();
			this.procesocierreprovision= new ProcesoCierreProvision();
			this.procesocierreprovisionObject=new Object();
			this.procesocierreprovisionsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocierreprovisionDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocierreprovisionDataAccess.setConnexionType(this.connexionType);
			this.procesocierreprovisionDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocierreprovisionDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCierreProvision getProcesoCierreProvision() throws Exception {	
		ProcesoCierreProvisionLogicAdditional.checkProcesoCierreProvisionToGet(procesocierreprovision,this.datosCliente,this.arrDatoGeneral);
		ProcesoCierreProvisionLogicAdditional.updateProcesoCierreProvisionToGet(procesocierreprovision,this.arrDatoGeneral);
		
		return procesocierreprovision;
	}
		
	public void setProcesoCierreProvision(ProcesoCierreProvision newProcesoCierreProvision) {
		this.procesocierreprovision = newProcesoCierreProvision;
	}
	
	public List<ProcesoCierreProvision> getProcesoCierreProvisions() throws Exception {		
		this.quitarProcesoCierreProvisionsNulos();
		
		ProcesoCierreProvisionLogicAdditional.checkProcesoCierreProvisionToGets(procesocierreprovisions,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCierreProvision procesocierreprovisionLocal: procesocierreprovisions ) {
			ProcesoCierreProvisionLogicAdditional.updateProcesoCierreProvisionToGet(procesocierreprovisionLocal,this.arrDatoGeneral);
		}
		
		return procesocierreprovisions;
	}
	
	public void setProcesoCierreProvisions(List<ProcesoCierreProvision> newProcesoCierreProvisions) {
		this.procesocierreprovisions = newProcesoCierreProvisions;
	}
	
	public Object getProcesoCierreProvisionObject() {	
		//this.procesocierreprovisionObject=this.procesocierreprovisionDataAccess.getEntityObject();
		return this.procesocierreprovisionObject;
	}
		
	public void setProcesoCierreProvisionObject(Object newProcesoCierreProvisionObject) {
		this.procesocierreprovisionObject = newProcesoCierreProvisionObject;
	}
	
	public List<Object> getProcesoCierreProvisionsObject() {		
		//this.procesocierreprovisionsObject=this.procesocierreprovisionDataAccess.getEntitiesObject();
		return this.procesocierreprovisionsObject;
	}
		
	public void setProcesoCierreProvisionsObject(List<Object> newProcesoCierreProvisionsObject) {
		this.procesocierreprovisionsObject = newProcesoCierreProvisionsObject;
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
		procesocierreprovisions = new  ArrayList<ProcesoCierreProvision>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreProvisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreprovisions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocierreprovisions = new  ArrayList<ProcesoCierreProvision>();
		  		  
        try {
			//ProcesoCierreProvisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreprovisions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocierreprovisions = new  ArrayList<ProcesoCierreProvision>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreProvisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreprovisions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocierreprovisions = new  ArrayList<ProcesoCierreProvision>();
		  		  
        try {
			//ProcesoCierreProvisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreprovisions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocierreprovisions = new  ArrayList<ProcesoCierreProvision>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreProvisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreprovisions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocierreprovisions = new  ArrayList<ProcesoCierreProvision>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCierreProvisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreprovisions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCierreProvision> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreProvision> entities = new  ArrayList<ProcesoCierreProvision>();
		ProcesoCierreProvision entity = new ProcesoCierreProvision();		  
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
	
	public  List<ProcesoCierreProvision> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreProvision> entities = new  ArrayList<ProcesoCierreProvision>();
		ProcesoCierreProvision entity = new ProcesoCierreProvision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCierreProvision();
				
				
      	    	entity=ProcesoCierreProvisionLogic.getEntityProcesoCierreProvision("",entity,resultSet);
      	    	
				//entity.setProcesoCierreProvisionOriginal( new ProcesoCierreProvision());
      	    	//entity.setProcesoCierreProvisionOriginal(super.getEntity("",entity.getProcesoCierreProvisionOriginal(),resultSet,ProcesoCierreProvisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCierreProvisionOriginal(ProcesoCierreProvisionDataAccess.getEntityProcesoCierreProvision("",entity.getProcesoCierreProvisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCierreProvision> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreProvision> entities = new  ArrayList<ProcesoCierreProvision>();
		ProcesoCierreProvision entity = new ProcesoCierreProvision();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCierreProvision.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCierreProvision>((List<ProcesoCierreProvision>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCierreProvisionsOriginal(entities);
			
			}  else {
				this.procesocierreprovisionsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCierreProvisionConstantesFunciones.quitarEspaciosProcesoCierreProvisions(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCierreProvision getEntityProcesoCierreProvision(String strPrefijo,ProcesoCierreProvision entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_anio(resultSet.getLong(strPrefijo+ProcesoCierreProvisionConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
			entity.setid_estructura(resultSet.getLong(strPrefijo+ProcesoCierreProvisionConstantesFunciones.IDESTRUCTURA));
			entity.setid_empleado(resultSet.getLong(strPrefijo+ProcesoCierreProvisionConstantesFunciones.IDEMPLEADO));
			entity.setid_defi_provision_empleado(resultSet.getLong(strPrefijo+ProcesoCierreProvisionConstantesFunciones.IDDEFIPROVISIONEMPLEADO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCierreProvision getEntityProcesoCierreProvision(String strPrefijo,ProcesoCierreProvision entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCierreProvision.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCierreProvision.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCierreProvisionLogic.setFieldReflectionProcesoCierreProvision(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCierreProvision(Field field,String strPrefijo,String sColumn,ProcesoCierreProvision entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoCierreProvisionConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCierreProvisionConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCierreProvisionConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCierreProvisionConstantesFunciones.IDDEFIPROVISIONEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	public void quitarProcesoCierreProvisionsNulos() throws Exception {				
		
		List<ProcesoCierreProvision> procesocierreprovisionsAux= new ArrayList<ProcesoCierreProvision>();
		
		for(ProcesoCierreProvision procesocierreprovision:procesocierreprovisions) {
			if(procesocierreprovision!=null) {
				procesocierreprovisionsAux.add(procesocierreprovision);
			}
		}
		
		procesocierreprovisions=procesocierreprovisionsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCierreProvision> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreProvision> entities = new  ArrayList<ProcesoCierreProvision>();
		ProcesoCierreProvision entity = new ProcesoCierreProvision();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCierreProvision>((List<ProcesoCierreProvision>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCierreProvisionsOriginal(entities);
			
			}  else {
				this.procesocierreprovisionsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCierreProvisionConstantesFunciones.quitarEspaciosProcesoCierreProvisions(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocierreprovisions = new  ArrayList<ProcesoCierreProvision>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreProvisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreprovisions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesocierreprovisions = new  ArrayList<ProcesoCierreProvision>();
		  		  
        try {
			//ProcesoCierreProvisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierreprovisions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCierreProvision> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCierreProvision> entities = new  ArrayList<ProcesoCierreProvision>();
		ProcesoCierreProvision entity = new ProcesoCierreProvision();		  
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
	
	public  List<ProcesoCierreProvision> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCierreProvision> entities = new  ArrayList<ProcesoCierreProvision>();
		ProcesoCierreProvision entity = new ProcesoCierreProvision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCierreProvision();
				
				if(conMapGenerico) {
					entity.setMapProcesoCierreProvision( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCierreProvision().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCierreProvisionDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCierreProvisionLogic.getEntityProcesoCierreProvision("",entity,resultSet,listColumns);
					
					////entity.setProcesoCierreProvisionOriginal( new ProcesoCierreProvision());
					////entity.setProcesoCierreProvisionOriginal(super.getEntity("",entity.getProcesoCierreProvisionOriginal(),resultSet,ProcesoCierreProvisionDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCierreProvisionOriginal(ProcesoCierreProvisionDataAccess.getEntityProcesoCierreProvision("",entity.getProcesoCierreProvisionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Anio getAnio(Connexion connexion,ProcesoCierreProvision relprocesocierreprovision)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,relprocesocierreprovision.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Estructura getEstructura(Connexion connexion,ProcesoCierreProvision relprocesocierreprovision)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			estructura=estructuraDataAccess.getEntity(connexion,relprocesocierreprovision.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empleado getEmpleado(Connexion connexion,ProcesoCierreProvision relprocesocierreprovision)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);
			empleadoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empleado=empleadoDataAccess.getEntity(connexion,relprocesocierreprovision.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public DefiProvisionEmpleado getDefiProvisionEmpleado(Connexion connexion,ProcesoCierreProvision relprocesocierreprovision)throws SQLException,Exception {

		DefiProvisionEmpleado defiprovisionempleado= new DefiProvisionEmpleado();

		try {
			DefiProvisionEmpleadoDataAccess defiprovisionempleadoDataAccess=new DefiProvisionEmpleadoDataAccess();

			defiprovisionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			defiprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			defiprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			defiprovisionempleadoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			defiprovisionempleado=defiprovisionempleadoDataAccess.getEntity(connexion,relprocesocierreprovision.getid_defi_provision_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return defiprovisionempleado;

	}


	
	
	public void getProcesoCierreProvisionsBusquedaProcesoCierreProvisionWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_estructura,Long id_empleado,Long id_defi_provision_empleado)throws Exception {
		try {
			ProcesoCierreProvisionLogicAdditional procesocierreprovisionLogicAdditional=new ProcesoCierreProvisionLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocierreprovisionLogicAdditional.BusquedaProcesoCierreProvision(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_estructura,id_empleado,id_defi_provision_empleado);

			//this.procesocierreprovisions=this.getProcesoCierreProvisions();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCierreProvisionLogicAdditional.ProcesarInformacionProcesoCierreProvision(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierreprovisionLogicAdditional,this.procesocierreprovisions,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCierreProvision",id_anio,id_estructura,id_empleado,id_defi_provision_empleado);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCierreProvisionsBusquedaProcesoCierreProvision(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_estructura,Long id_empleado,Long id_defi_provision_empleado)throws Exception {
		try {
			ProcesoCierreProvisionLogicAdditional procesocierreprovisionLogicAdditional=new ProcesoCierreProvisionLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocierreprovisionLogicAdditional.BusquedaProcesoCierreProvision(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_estructura,id_empleado,id_defi_provision_empleado);

			//this.procesocierreprovisions=this.getProcesoCierreProvisions();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCierreProvisionLogicAdditional.ProcesarInformacionProcesoCierreProvision(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierreprovisionLogicAdditional,this.procesocierreprovisions,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCierreProvision",id_anio,id_estructura,id_empleado,id_defi_provision_empleado);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoCierreProvision procesocierreprovision,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoCierreProvisionLogicAdditional.updateProcesoCierreProvisionToGet(procesocierreprovision,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocierreprovision.setAnio(procesocierreprovisionDataAccess.getAnio(connexion,procesocierreprovision));
		procesocierreprovision.setEstructura(procesocierreprovisionDataAccess.getEstructura(connexion,procesocierreprovision));
		procesocierreprovision.setEmpleado(procesocierreprovisionDataAccess.getEmpleado(connexion,procesocierreprovision));
		procesocierreprovision.setDefiProvisionEmpleado(procesocierreprovisionDataAccess.getDefiProvisionEmpleado(connexion,procesocierreprovision));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesocierreprovision.setAnio(procesocierreprovisionDataAccess.getAnio(connexion,procesocierreprovision));
			}

			if(clas.clas.equals(Estructura.class)) {
				procesocierreprovision.setEstructura(procesocierreprovisionDataAccess.getEstructura(connexion,procesocierreprovision));
			}

			if(clas.clas.equals(Empleado.class)) {
				procesocierreprovision.setEmpleado(procesocierreprovisionDataAccess.getEmpleado(connexion,procesocierreprovision));
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				procesocierreprovision.setDefiProvisionEmpleado(procesocierreprovisionDataAccess.getDefiProvisionEmpleado(connexion,procesocierreprovision));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreprovision.setAnio(procesocierreprovisionDataAccess.getAnio(connexion,procesocierreprovision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreprovision.setEstructura(procesocierreprovisionDataAccess.getEstructura(connexion,procesocierreprovision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreprovision.setEmpleado(procesocierreprovisionDataAccess.getEmpleado(connexion,procesocierreprovision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreprovision.setDefiProvisionEmpleado(procesocierreprovisionDataAccess.getDefiProvisionEmpleado(connexion,procesocierreprovision));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocierreprovision.setAnio(procesocierreprovisionDataAccess.getAnio(connexion,procesocierreprovision));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(procesocierreprovision.getAnio(),isDeep,deepLoadType,clases);
				
		procesocierreprovision.setEstructura(procesocierreprovisionDataAccess.getEstructura(connexion,procesocierreprovision));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(procesocierreprovision.getEstructura(),isDeep,deepLoadType,clases);
				
		procesocierreprovision.setEmpleado(procesocierreprovisionDataAccess.getEmpleado(connexion,procesocierreprovision));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(procesocierreprovision.getEmpleado(),isDeep,deepLoadType,clases);
				
		procesocierreprovision.setDefiProvisionEmpleado(procesocierreprovisionDataAccess.getDefiProvisionEmpleado(connexion,procesocierreprovision));
		DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
		defiprovisionempleadoLogic.deepLoad(procesocierreprovision.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesocierreprovision.setAnio(procesocierreprovisionDataAccess.getAnio(connexion,procesocierreprovision));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(procesocierreprovision.getAnio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Estructura.class)) {
				procesocierreprovision.setEstructura(procesocierreprovisionDataAccess.getEstructura(connexion,procesocierreprovision));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(procesocierreprovision.getEstructura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empleado.class)) {
				procesocierreprovision.setEmpleado(procesocierreprovisionDataAccess.getEmpleado(connexion,procesocierreprovision));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(procesocierreprovision.getEmpleado(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				procesocierreprovision.setDefiProvisionEmpleado(procesocierreprovisionDataAccess.getDefiProvisionEmpleado(connexion,procesocierreprovision));
				DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
				defiprovisionempleadoLogic.deepLoad(procesocierreprovision.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreprovision.setAnio(procesocierreprovisionDataAccess.getAnio(connexion,procesocierreprovision));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(procesocierreprovision.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreprovision.setEstructura(procesocierreprovisionDataAccess.getEstructura(connexion,procesocierreprovision));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(procesocierreprovision.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreprovision.setEmpleado(procesocierreprovisionDataAccess.getEmpleado(connexion,procesocierreprovision));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(procesocierreprovision.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierreprovision.setDefiProvisionEmpleado(procesocierreprovisionDataAccess.getDefiProvisionEmpleado(connexion,procesocierreprovision));
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
			defiprovisionempleadoLogic.deepLoad(procesocierreprovision.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesocierreprovision,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCierreProvisionConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreProvision(procesocierreprovision);
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
			this.deepLoad(this.procesocierreprovision,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCierreProvisionConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreProvision(this.procesocierreprovision);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocierreprovisions!=null) {
				for(ProcesoCierreProvision procesocierreprovision:procesocierreprovisions) {
					this.deepLoad(procesocierreprovision,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCierreProvisionConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreProvision(procesocierreprovisions);
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
			if(procesocierreprovisions!=null) {
				for(ProcesoCierreProvision procesocierreprovision:procesocierreprovisions) {
					this.deepLoad(procesocierreprovision,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCierreProvisionConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreProvision(procesocierreprovisions);
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
	
	public ProcesoCierreProvisionParameterReturnGeneral procesarAccionProcesoCierreProvisions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCierreProvision> procesocierreprovisions,ProcesoCierreProvisionParameterReturnGeneral procesocierreprovisionParameterGeneral)throws Exception {
		 try {	
			ProcesoCierreProvisionParameterReturnGeneral procesocierreprovisionReturnGeneral=new ProcesoCierreProvisionParameterReturnGeneral();
	
			ProcesoCierreProvisionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocierreprovisions,procesocierreprovisionParameterGeneral,procesocierreprovisionReturnGeneral);
			
			return procesocierreprovisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCierreProvisionParameterReturnGeneral procesarAccionProcesoCierreProvisionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCierreProvision> procesocierreprovisions,ProcesoCierreProvisionParameterReturnGeneral procesocierreprovisionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCierreProvisionParameterReturnGeneral procesocierreprovisionReturnGeneral=new ProcesoCierreProvisionParameterReturnGeneral();
	
			ProcesoCierreProvisionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocierreprovisions,procesocierreprovisionParameterGeneral,procesocierreprovisionReturnGeneral);
			
			this.connexion.commit();
			
			return procesocierreprovisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoCierreProvision(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCierreProvision> procesocierreprovisions,String sTipoBusqueda,Long id_anioBusquedaProcesoCierreProvision,Long id_estructuraBusquedaProcesoCierreProvision,Long id_empleadoBusquedaProcesoCierreProvision,Long id_defi_provision_empleadoBusquedaProcesoCierreProvision) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoCierreProvisionLogicAdditional procesocierreprovisionLogicAdditional=new ProcesoCierreProvisionLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesocierreprovisionLogicAdditional.setConnexion(this.connexion);

			procesocierreprovisionLogicAdditional.ProcesarInformacionProcesoCierreProvision(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierreprovisions,sTipoBusqueda,id_anioBusquedaProcesoCierreProvision,id_estructuraBusquedaProcesoCierreProvision,id_empleadoBusquedaProcesoCierreProvision,id_defi_provision_empleadoBusquedaProcesoCierreProvision);

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

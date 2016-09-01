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
import com.bydan.erp.activosfijos.util.report.ProcesarCalcularDepreciacionesParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ProcesarCalcularDepreciacionesParameterGeneral;
import com.bydan.erp.activosfijos.util.report.ProcesarCalcularDepreciacionesConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.ProcesarCalcularDepreciaciones;

import com.bydan.erp.activosfijos.business.logic.report.ProcesarCalcularDepreciacionesLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesarCalcularDepreciacionesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesarCalcularDepreciacionesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesarCalcularDepreciacionesLogic procesarcalculardepreciacionesDataAccess; 		
	protected ProcesarCalcularDepreciaciones procesarcalculardepreciaciones;
	protected List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness;
	protected Object procesarcalculardepreciacionesObject;	
	protected List<Object> procesarcalculardepreciacionessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesarCalcularDepreciacionesLogic()throws SQLException,Exception {
		try	{
			this.procesarcalculardepreciacioness= new ArrayList<ProcesarCalcularDepreciaciones>();
			this.procesarcalculardepreciaciones= new ProcesarCalcularDepreciaciones();
			this.procesarcalculardepreciacionesObject=new Object();
			this.procesarcalculardepreciacionessObject=new ArrayList<Object>();
			
			this.procesarcalculardepreciacionesDataAccess=this;
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
			this.procesarcalculardepreciacionesDataAccess.setConnexionType(this.connexionType);
			this.procesarcalculardepreciacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesarcalculardepreciacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesarCalcularDepreciacionesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesarcalculardepreciacioness= new ArrayList<ProcesarCalcularDepreciaciones>();
			this.procesarcalculardepreciaciones= new ProcesarCalcularDepreciaciones();
			this.procesarcalculardepreciacionesObject=new Object();
			this.procesarcalculardepreciacionessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesarcalculardepreciacionesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesarcalculardepreciacionesDataAccess.setConnexionType(this.connexionType);
			this.procesarcalculardepreciacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesarcalculardepreciacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesarCalcularDepreciaciones getProcesarCalcularDepreciaciones() throws Exception {	
		ProcesarCalcularDepreciacionesLogicAdditional.checkProcesarCalcularDepreciacionesToGet(procesarcalculardepreciaciones,this.datosCliente,this.arrDatoGeneral);
		ProcesarCalcularDepreciacionesLogicAdditional.updateProcesarCalcularDepreciacionesToGet(procesarcalculardepreciaciones,this.arrDatoGeneral);
		
		return procesarcalculardepreciaciones;
	}
		
	public void setProcesarCalcularDepreciaciones(ProcesarCalcularDepreciaciones newProcesarCalcularDepreciaciones) {
		this.procesarcalculardepreciaciones = newProcesarCalcularDepreciaciones;
	}
	
	public List<ProcesarCalcularDepreciaciones> getProcesarCalcularDepreciacioness() throws Exception {		
		this.quitarProcesarCalcularDepreciacionessNulos();
		
		ProcesarCalcularDepreciacionesLogicAdditional.checkProcesarCalcularDepreciacionesToGets(procesarcalculardepreciacioness,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesarCalcularDepreciaciones procesarcalculardepreciacionesLocal: procesarcalculardepreciacioness ) {
			ProcesarCalcularDepreciacionesLogicAdditional.updateProcesarCalcularDepreciacionesToGet(procesarcalculardepreciacionesLocal,this.arrDatoGeneral);
		}
		
		return procesarcalculardepreciacioness;
	}
	
	public void setProcesarCalcularDepreciacioness(List<ProcesarCalcularDepreciaciones> newProcesarCalcularDepreciacioness) {
		this.procesarcalculardepreciacioness = newProcesarCalcularDepreciacioness;
	}
	
	public Object getProcesarCalcularDepreciacionesObject() {	
		//this.procesarcalculardepreciacionesObject=this.procesarcalculardepreciacionesDataAccess.getEntityObject();
		return this.procesarcalculardepreciacionesObject;
	}
		
	public void setProcesarCalcularDepreciacionesObject(Object newProcesarCalcularDepreciacionesObject) {
		this.procesarcalculardepreciacionesObject = newProcesarCalcularDepreciacionesObject;
	}
	
	public List<Object> getProcesarCalcularDepreciacionessObject() {		
		//this.procesarcalculardepreciacionessObject=this.procesarcalculardepreciacionesDataAccess.getEntitiesObject();
		return this.procesarcalculardepreciacionessObject;
	}
		
	public void setProcesarCalcularDepreciacionessObject(List<Object> newProcesarCalcularDepreciacionessObject) {
		this.procesarcalculardepreciacionessObject = newProcesarCalcularDepreciacionessObject;
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
		procesarcalculardepreciacioness = new  ArrayList<ProcesarCalcularDepreciaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarCalcularDepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcalculardepreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesarcalculardepreciacioness = new  ArrayList<ProcesarCalcularDepreciaciones>();
		  		  
        try {
			//ProcesarCalcularDepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcalculardepreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesarcalculardepreciacioness = new  ArrayList<ProcesarCalcularDepreciaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarCalcularDepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcalculardepreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesarcalculardepreciacioness = new  ArrayList<ProcesarCalcularDepreciaciones>();
		  		  
        try {
			//ProcesarCalcularDepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcalculardepreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesarcalculardepreciacioness = new  ArrayList<ProcesarCalcularDepreciaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarCalcularDepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcalculardepreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesarcalculardepreciacioness = new  ArrayList<ProcesarCalcularDepreciaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesarCalcularDepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcalculardepreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesarCalcularDepreciaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarCalcularDepreciaciones> entities = new  ArrayList<ProcesarCalcularDepreciaciones>();
		ProcesarCalcularDepreciaciones entity = new ProcesarCalcularDepreciaciones();		  
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
	
	public  List<ProcesarCalcularDepreciaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarCalcularDepreciaciones> entities = new  ArrayList<ProcesarCalcularDepreciaciones>();
		ProcesarCalcularDepreciaciones entity = new ProcesarCalcularDepreciaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesarCalcularDepreciaciones();
				
				
      	    	entity=ProcesarCalcularDepreciacionesLogic.getEntityProcesarCalcularDepreciaciones("",entity,resultSet);
      	    	
				//entity.setProcesarCalcularDepreciacionesOriginal( new ProcesarCalcularDepreciaciones());
      	    	//entity.setProcesarCalcularDepreciacionesOriginal(super.getEntity("",entity.getProcesarCalcularDepreciacionesOriginal(),resultSet,ProcesarCalcularDepreciacionesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesarCalcularDepreciacionesOriginal(ProcesarCalcularDepreciacionesDataAccess.getEntityProcesarCalcularDepreciaciones("",entity.getProcesarCalcularDepreciacionesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesarCalcularDepreciaciones> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarCalcularDepreciaciones> entities = new  ArrayList<ProcesarCalcularDepreciaciones>();
		ProcesarCalcularDepreciaciones entity = new ProcesarCalcularDepreciaciones();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesarCalcularDepreciaciones.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesarCalcularDepreciaciones>((List<ProcesarCalcularDepreciaciones>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesarCalcularDepreciacionessOriginal(entities);
			
			}  else {
				this.procesarcalculardepreciacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesarCalcularDepreciacionesConstantesFunciones.quitarEspaciosProcesarCalcularDepreciacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesarCalcularDepreciaciones getEntityProcesarCalcularDepreciaciones(String strPrefijo,ProcesarCalcularDepreciaciones entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_anio(resultSet.getLong(strPrefijo+ProcesarCalcularDepreciacionesConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
			entity.setid_mes(resultSet.getLong(strPrefijo+ProcesarCalcularDepreciacionesConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			entity.setid_detalle_grupo_activo_fijo(resultSet.getLong(strPrefijo+ProcesarCalcularDepreciacionesConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO));
			entity.setid_sub_grupo_activo_fijo(resultSet.getLong(strPrefijo+ProcesarCalcularDepreciacionesConstantesFunciones.IDSUBGRUPOACTIVOFIJO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesarCalcularDepreciaciones getEntityProcesarCalcularDepreciaciones(String strPrefijo,ProcesarCalcularDepreciaciones entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesarCalcularDepreciaciones.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesarCalcularDepreciaciones.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesarCalcularDepreciacionesLogic.setFieldReflectionProcesarCalcularDepreciaciones(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesarCalcularDepreciaciones(Field field,String strPrefijo,String sColumn,ProcesarCalcularDepreciaciones entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesarCalcularDepreciacionesConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesarCalcularDepreciacionesConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesarCalcularDepreciacionesConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesarCalcularDepreciacionesConstantesFunciones.IDSUBGRUPOACTIVOFIJO:
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
	
	public void quitarProcesarCalcularDepreciacionessNulos() throws Exception {				
		
		List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacionessAux= new ArrayList<ProcesarCalcularDepreciaciones>();
		
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones:procesarcalculardepreciacioness) {
			if(procesarcalculardepreciaciones!=null) {
				procesarcalculardepreciacionessAux.add(procesarcalculardepreciaciones);
			}
		}
		
		procesarcalculardepreciacioness=procesarcalculardepreciacionessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesarCalcularDepreciaciones> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesarCalcularDepreciaciones> entities = new  ArrayList<ProcesarCalcularDepreciaciones>();
		ProcesarCalcularDepreciaciones entity = new ProcesarCalcularDepreciaciones();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesarCalcularDepreciaciones>((List<ProcesarCalcularDepreciaciones>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesarCalcularDepreciacionessOriginal(entities);
			
			}  else {
				this.procesarcalculardepreciacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesarCalcularDepreciacionesConstantesFunciones.quitarEspaciosProcesarCalcularDepreciacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesarcalculardepreciacioness = new  ArrayList<ProcesarCalcularDepreciaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesarCalcularDepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcalculardepreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesarcalculardepreciacioness = new  ArrayList<ProcesarCalcularDepreciaciones>();
		  		  
        try {
			//ProcesarCalcularDepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesarcalculardepreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesarCalcularDepreciaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesarCalcularDepreciaciones> entities = new  ArrayList<ProcesarCalcularDepreciaciones>();
		ProcesarCalcularDepreciaciones entity = new ProcesarCalcularDepreciaciones();		  
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
	
	public  List<ProcesarCalcularDepreciaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesarCalcularDepreciaciones> entities = new  ArrayList<ProcesarCalcularDepreciaciones>();
		ProcesarCalcularDepreciaciones entity = new ProcesarCalcularDepreciaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesarCalcularDepreciaciones();
				
				if(conMapGenerico) {
					entity.setMapProcesarCalcularDepreciaciones( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesarCalcularDepreciaciones().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesarCalcularDepreciacionesDataAccess.ISWITHSCHEMA);         		
					entity=ProcesarCalcularDepreciacionesLogic.getEntityProcesarCalcularDepreciaciones("",entity,resultSet,listColumns);
					
					////entity.setProcesarCalcularDepreciacionesOriginal( new ProcesarCalcularDepreciaciones());
					////entity.setProcesarCalcularDepreciacionesOriginal(super.getEntity("",entity.getProcesarCalcularDepreciacionesOriginal(),resultSet,ProcesarCalcularDepreciacionesDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesarCalcularDepreciacionesOriginal(ProcesarCalcularDepreciacionesDataAccess.getEntityProcesarCalcularDepreciaciones("",entity.getProcesarCalcularDepreciacionesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Anio getAnio(Connexion connexion,ProcesarCalcularDepreciaciones relprocesarcalculardepreciaciones)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,relprocesarcalculardepreciaciones.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,ProcesarCalcularDepreciaciones relprocesarcalculardepreciaciones)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);
			mesDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			mes=mesDataAccess.getEntity(connexion,relprocesarcalculardepreciaciones.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo(Connexion connexion,ProcesarCalcularDepreciaciones relprocesarcalculardepreciaciones)throws SQLException,Exception {

		DetalleGrupoActivoFijo detallegrupoactivofijo= new DetalleGrupoActivoFijo();

		try {
			DetalleGrupoActivoFijoDataAccess detallegrupoactivofijoDataAccess=new DetalleGrupoActivoFijoDataAccess();

			detallegrupoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detallegrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			detallegrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			detallegrupoactivofijoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion,relprocesarcalculardepreciaciones.getid_detalle_grupo_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallegrupoactivofijo;

	}

	public SubGrupoActivoFijo getSubGrupoActivoFijo(Connexion connexion,ProcesarCalcularDepreciaciones relprocesarcalculardepreciaciones)throws SQLException,Exception {

		SubGrupoActivoFijo subgrupoactivofijo= new SubGrupoActivoFijo();

		try {
			SubGrupoActivoFijoDataAccess subgrupoactivofijoDataAccess=new SubGrupoActivoFijoDataAccess();

			subgrupoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			subgrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			subgrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			subgrupoactivofijoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			subgrupoactivofijo=subgrupoactivofijoDataAccess.getEntity(connexion,relprocesarcalculardepreciaciones.getid_sub_grupo_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subgrupoactivofijo;

	}


	
	
	public void getProcesarCalcularDepreciacionessBusquedaProcesarCalcularDepreciacionesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_detalle_grupo_activo_fijo,Long id_sub_grupo_activo_fijo)throws Exception {
		try {
			ProcesarCalcularDepreciacionesLogicAdditional procesarcalculardepreciacionesLogicAdditional=new ProcesarCalcularDepreciacionesLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesarcalculardepreciacionesLogicAdditional.BusquedaProcesarCalcularDepreciaciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_mes,id_detalle_grupo_activo_fijo,id_sub_grupo_activo_fijo);

			//this.procesarcalculardepreciacioness=this.getProcesarCalcularDepreciacioness();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesarCalcularDepreciacionesLogicAdditional.ProcesarInformacionProcesarCalcularDepreciaciones(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarcalculardepreciacionesLogicAdditional,this.procesarcalculardepreciacioness,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesarCalcularDepreciaciones",id_anio,id_mes,id_detalle_grupo_activo_fijo,id_sub_grupo_activo_fijo);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesarCalcularDepreciacionessBusquedaProcesarCalcularDepreciaciones(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_detalle_grupo_activo_fijo,Long id_sub_grupo_activo_fijo)throws Exception {
		try {
			ProcesarCalcularDepreciacionesLogicAdditional procesarcalculardepreciacionesLogicAdditional=new ProcesarCalcularDepreciacionesLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesarcalculardepreciacionesLogicAdditional.BusquedaProcesarCalcularDepreciaciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_mes,id_detalle_grupo_activo_fijo,id_sub_grupo_activo_fijo);

			//this.procesarcalculardepreciacioness=this.getProcesarCalcularDepreciacioness();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesarCalcularDepreciacionesLogicAdditional.ProcesarInformacionProcesarCalcularDepreciaciones(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarcalculardepreciacionesLogicAdditional,this.procesarcalculardepreciacioness,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesarCalcularDepreciaciones",id_anio,id_mes,id_detalle_grupo_activo_fijo,id_sub_grupo_activo_fijo);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesarCalcularDepreciacionesLogicAdditional.updateProcesarCalcularDepreciacionesToGet(procesarcalculardepreciaciones,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesarcalculardepreciaciones.setAnio(procesarcalculardepreciacionesDataAccess.getAnio(connexion,procesarcalculardepreciaciones));
		procesarcalculardepreciaciones.setMes(procesarcalculardepreciacionesDataAccess.getMes(connexion,procesarcalculardepreciaciones));
		procesarcalculardepreciaciones.setDetalleGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getDetalleGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
		procesarcalculardepreciaciones.setSubGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getSubGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesarcalculardepreciaciones.setAnio(procesarcalculardepreciacionesDataAccess.getAnio(connexion,procesarcalculardepreciaciones));
			}

			if(clas.clas.equals(Mes.class)) {
				procesarcalculardepreciaciones.setMes(procesarcalculardepreciacionesDataAccess.getMes(connexion,procesarcalculardepreciaciones));
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				procesarcalculardepreciaciones.setDetalleGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getDetalleGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				procesarcalculardepreciaciones.setSubGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getSubGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
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
			procesarcalculardepreciaciones.setAnio(procesarcalculardepreciacionesDataAccess.getAnio(connexion,procesarcalculardepreciaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarcalculardepreciaciones.setMes(procesarcalculardepreciacionesDataAccess.getMes(connexion,procesarcalculardepreciaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarcalculardepreciaciones.setDetalleGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getDetalleGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarcalculardepreciaciones.setSubGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getSubGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesarcalculardepreciaciones.setAnio(procesarcalculardepreciacionesDataAccess.getAnio(connexion,procesarcalculardepreciaciones));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(procesarcalculardepreciaciones.getAnio(),isDeep,deepLoadType,clases);
				
		procesarcalculardepreciaciones.setMes(procesarcalculardepreciacionesDataAccess.getMes(connexion,procesarcalculardepreciaciones));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(procesarcalculardepreciaciones.getMes(),isDeep,deepLoadType,clases);
				
		procesarcalculardepreciaciones.setDetalleGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getDetalleGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
		DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
		detallegrupoactivofijoLogic.deepLoad(procesarcalculardepreciaciones.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
		procesarcalculardepreciaciones.setSubGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getSubGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
		SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
		subgrupoactivofijoLogic.deepLoad(procesarcalculardepreciaciones.getSubGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesarcalculardepreciaciones.setAnio(procesarcalculardepreciacionesDataAccess.getAnio(connexion,procesarcalculardepreciaciones));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(procesarcalculardepreciaciones.getAnio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Mes.class)) {
				procesarcalculardepreciaciones.setMes(procesarcalculardepreciacionesDataAccess.getMes(connexion,procesarcalculardepreciaciones));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(procesarcalculardepreciaciones.getMes(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				procesarcalculardepreciaciones.setDetalleGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getDetalleGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
				DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
				detallegrupoactivofijoLogic.deepLoad(procesarcalculardepreciaciones.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				procesarcalculardepreciaciones.setSubGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getSubGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
				SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
				subgrupoactivofijoLogic.deepLoad(procesarcalculardepreciaciones.getSubGrupoActivoFijo(),isDeep,deepLoadType,clases);				
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
			procesarcalculardepreciaciones.setAnio(procesarcalculardepreciacionesDataAccess.getAnio(connexion,procesarcalculardepreciaciones));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(procesarcalculardepreciaciones.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarcalculardepreciaciones.setMes(procesarcalculardepreciacionesDataAccess.getMes(connexion,procesarcalculardepreciaciones));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(procesarcalculardepreciaciones.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarcalculardepreciaciones.setDetalleGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getDetalleGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
			detallegrupoactivofijoLogic.deepLoad(procesarcalculardepreciaciones.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesarcalculardepreciaciones.setSubGrupoActivoFijo(procesarcalculardepreciacionesDataAccess.getSubGrupoActivoFijo(connexion,procesarcalculardepreciaciones));
			SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
			subgrupoactivofijoLogic.deepLoad(procesarcalculardepreciaciones.getSubGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesarcalculardepreciaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesarCalcularDepreciacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesarCalcularDepreciaciones(procesarcalculardepreciaciones);
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
			this.deepLoad(this.procesarcalculardepreciaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesarCalcularDepreciacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesarCalcularDepreciaciones(this.procesarcalculardepreciaciones);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesarcalculardepreciacioness!=null) {
				for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones:procesarcalculardepreciacioness) {
					this.deepLoad(procesarcalculardepreciaciones,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesarCalcularDepreciacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesarCalcularDepreciaciones(procesarcalculardepreciacioness);
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
			if(procesarcalculardepreciacioness!=null) {
				for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones:procesarcalculardepreciacioness) {
					this.deepLoad(procesarcalculardepreciaciones,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesarCalcularDepreciacionesConstantesFunciones.refrescarForeignKeysDescripcionesProcesarCalcularDepreciaciones(procesarcalculardepreciacioness);
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
	
	public ProcesarCalcularDepreciacionesParameterReturnGeneral procesarAccionProcesarCalcularDepreciacioness(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,ProcesarCalcularDepreciacionesParameterReturnGeneral procesarcalculardepreciacionesParameterGeneral)throws Exception {
		 try {	
			ProcesarCalcularDepreciacionesParameterReturnGeneral procesarcalculardepreciacionesReturnGeneral=new ProcesarCalcularDepreciacionesParameterReturnGeneral();
	
			ProcesarCalcularDepreciacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesarcalculardepreciacioness,procesarcalculardepreciacionesParameterGeneral,procesarcalculardepreciacionesReturnGeneral);
			
			return procesarcalculardepreciacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesarCalcularDepreciacionesParameterReturnGeneral procesarAccionProcesarCalcularDepreciacionessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,ProcesarCalcularDepreciacionesParameterReturnGeneral procesarcalculardepreciacionesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesarCalcularDepreciacionesParameterReturnGeneral procesarcalculardepreciacionesReturnGeneral=new ProcesarCalcularDepreciacionesParameterReturnGeneral();
	
			ProcesarCalcularDepreciacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesarcalculardepreciacioness,procesarcalculardepreciacionesParameterGeneral,procesarcalculardepreciacionesReturnGeneral);
			
			this.connexion.commit();
			
			return procesarcalculardepreciacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,String sTipoBusqueda,Long id_anioBusquedaProcesarCalcularDepreciaciones,Long id_mesBusquedaProcesarCalcularDepreciaciones,Long id_detalle_grupo_activo_fijoBusquedaProcesarCalcularDepreciaciones,Long id_sub_grupo_activo_fijoBusquedaProcesarCalcularDepreciaciones) throws Exception {
		Boolean procesado=false;

		try {
			ProcesarCalcularDepreciacionesLogicAdditional procesarcalculardepreciacionesLogicAdditional=new ProcesarCalcularDepreciacionesLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesarcalculardepreciacionesLogicAdditional.setConnexion(this.connexion);

			procesarcalculardepreciacionesLogicAdditional.ProcesarInformacionProcesarCalcularDepreciaciones(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarcalculardepreciacioness,sTipoBusqueda,id_anioBusquedaProcesarCalcularDepreciaciones,id_mesBusquedaProcesarCalcularDepreciaciones,id_detalle_grupo_activo_fijoBusquedaProcesarCalcularDepreciaciones,id_sub_grupo_activo_fijoBusquedaProcesarCalcularDepreciaciones);

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

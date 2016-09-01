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
import com.bydan.erp.contabilidad.util.report.ProcesoMayorizarDiarioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoMayorizarDiarioParameterGeneral;
import com.bydan.erp.contabilidad.util.report.ProcesoMayorizarDiarioConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.ProcesoMayorizarDiario;

import com.bydan.erp.contabilidad.business.logic.report.ProcesoMayorizarDiarioLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoMayorizarDiarioLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoMayorizarDiarioLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoMayorizarDiarioLogic procesomayorizardiarioDataAccess; 		
	protected ProcesoMayorizarDiario procesomayorizardiario;
	protected List<ProcesoMayorizarDiario> procesomayorizardiarios;
	protected Object procesomayorizardiarioObject;	
	protected List<Object> procesomayorizardiariosObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoMayorizarDiarioLogic()throws SQLException,Exception {
		try	{
			this.procesomayorizardiarios= new ArrayList<ProcesoMayorizarDiario>();
			this.procesomayorizardiario= new ProcesoMayorizarDiario();
			this.procesomayorizardiarioObject=new Object();
			this.procesomayorizardiariosObject=new ArrayList<Object>();
			
			this.procesomayorizardiarioDataAccess=this;
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
			this.procesomayorizardiarioDataAccess.setConnexionType(this.connexionType);
			this.procesomayorizardiarioDataAccess.setParameterDbType(this.parameterDbType);
			this.procesomayorizardiarioDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoMayorizarDiarioLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesomayorizardiarios= new ArrayList<ProcesoMayorizarDiario>();
			this.procesomayorizardiario= new ProcesoMayorizarDiario();
			this.procesomayorizardiarioObject=new Object();
			this.procesomayorizardiariosObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesomayorizardiarioDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesomayorizardiarioDataAccess.setConnexionType(this.connexionType);
			this.procesomayorizardiarioDataAccess.setParameterDbType(this.parameterDbType);
			this.procesomayorizardiarioDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoMayorizarDiario getProcesoMayorizarDiario() throws Exception {	
		ProcesoMayorizarDiarioLogicAdditional.checkProcesoMayorizarDiarioToGet(procesomayorizardiario,this.datosCliente,this.arrDatoGeneral);
		ProcesoMayorizarDiarioLogicAdditional.updateProcesoMayorizarDiarioToGet(procesomayorizardiario,this.arrDatoGeneral);
		
		return procesomayorizardiario;
	}
		
	public void setProcesoMayorizarDiario(ProcesoMayorizarDiario newProcesoMayorizarDiario) {
		this.procesomayorizardiario = newProcesoMayorizarDiario;
	}
	
	public List<ProcesoMayorizarDiario> getProcesoMayorizarDiarios() throws Exception {		
		this.quitarProcesoMayorizarDiariosNulos();
		
		ProcesoMayorizarDiarioLogicAdditional.checkProcesoMayorizarDiarioToGets(procesomayorizardiarios,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoMayorizarDiario procesomayorizardiarioLocal: procesomayorizardiarios ) {
			ProcesoMayorizarDiarioLogicAdditional.updateProcesoMayorizarDiarioToGet(procesomayorizardiarioLocal,this.arrDatoGeneral);
		}
		
		return procesomayorizardiarios;
	}
	
	public void setProcesoMayorizarDiarios(List<ProcesoMayorizarDiario> newProcesoMayorizarDiarios) {
		this.procesomayorizardiarios = newProcesoMayorizarDiarios;
	}
	
	public Object getProcesoMayorizarDiarioObject() {	
		//this.procesomayorizardiarioObject=this.procesomayorizardiarioDataAccess.getEntityObject();
		return this.procesomayorizardiarioObject;
	}
		
	public void setProcesoMayorizarDiarioObject(Object newProcesoMayorizarDiarioObject) {
		this.procesomayorizardiarioObject = newProcesoMayorizarDiarioObject;
	}
	
	public List<Object> getProcesoMayorizarDiariosObject() {		
		//this.procesomayorizardiariosObject=this.procesomayorizardiarioDataAccess.getEntitiesObject();
		return this.procesomayorizardiariosObject;
	}
		
	public void setProcesoMayorizarDiariosObject(List<Object> newProcesoMayorizarDiariosObject) {
		this.procesomayorizardiariosObject = newProcesoMayorizarDiariosObject;
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
		procesomayorizardiarios = new  ArrayList<ProcesoMayorizarDiario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesomayorizardiarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesomayorizardiarios = new  ArrayList<ProcesoMayorizarDiario>();
		  		  
        try {
			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesomayorizardiarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesomayorizardiarios = new  ArrayList<ProcesoMayorizarDiario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesomayorizardiarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesomayorizardiarios = new  ArrayList<ProcesoMayorizarDiario>();
		  		  
        try {
			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesomayorizardiarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesomayorizardiarios = new  ArrayList<ProcesoMayorizarDiario>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesomayorizardiarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesomayorizardiarios = new  ArrayList<ProcesoMayorizarDiario>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesomayorizardiarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoMayorizarDiario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoMayorizarDiario> entities = new  ArrayList<ProcesoMayorizarDiario>();
		ProcesoMayorizarDiario entity = new ProcesoMayorizarDiario();		  
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
	
	public  List<ProcesoMayorizarDiario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoMayorizarDiario> entities = new  ArrayList<ProcesoMayorizarDiario>();
		ProcesoMayorizarDiario entity = new ProcesoMayorizarDiario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoMayorizarDiario();
				
      	    	entity=this.getEntity("",entity,resultSet,ProcesoMayorizarDiarioLogic.ISWITHSCHEMA);         		
				
      	    	entity=ProcesoMayorizarDiarioLogic.getEntityProcesoMayorizarDiario("",entity,resultSet);
      	    	
				//entity.setProcesoMayorizarDiarioOriginal( new ProcesoMayorizarDiario());
      	    	//entity.setProcesoMayorizarDiarioOriginal(super.getEntity("",entity.getProcesoMayorizarDiarioOriginal(),resultSet,ProcesoMayorizarDiarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoMayorizarDiarioOriginal(ProcesoMayorizarDiarioDataAccess.getEntityProcesoMayorizarDiario("",entity.getProcesoMayorizarDiarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoMayorizarDiario> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoMayorizarDiario> entities = new  ArrayList<ProcesoMayorizarDiario>();
		ProcesoMayorizarDiario entity = new ProcesoMayorizarDiario();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoMayorizarDiario.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoMayorizarDiario>((List<ProcesoMayorizarDiario>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoMayorizarDiariosOriginal(entities);
			
			}  else {
				this.procesomayorizardiariosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoMayorizarDiarioConstantesFunciones.quitarEspaciosProcesoMayorizarDiarios(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  ProcesoMayorizarDiario getEntity(String strPrefijo,ProcesoMayorizarDiario entityT,ResultSet rs,Boolean isWithSchema) throws Exception {	 
		  entityT.setIsNew(false);
        
		  try {
    	  
      	  if(isWithSchema) {
    	    	entityT.setId(rs.getLong(strPrefijo+DataAccessHelper.getColumnNameId()));	
    	    	//extracted(entityT).setIsActive(rs.getBoolean(strPrefijo+DataAccessHelper.getColumnNameIsActive()));
    	    	//extracted(entityT).setIsExpired(rs.getBoolean(strPrefijo+DataAccessHelper.getColumnNameIsExpired()));
    	    	entityT.setVersionRow(rs.getTimestamp(strPrefijo+DataAccessHelper.getColumnNameVersionRow()));     	    	       	 
      	  }
	      	} catch(Exception ex) {
	            throw new Exception();
	        }
	      	
        return entityT;
  	}
	
	public  static ProcesoMayorizarDiario getEntityProcesoMayorizarDiario(String strPrefijo,ProcesoMayorizarDiario entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ProcesoMayorizarDiarioConstantesFunciones.CODIGO));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ProcesoMayorizarDiarioConstantesFunciones.FECHA).getTime()));
			entity.setbeneficiario(resultSet.getString(strPrefijo+ProcesoMayorizarDiarioConstantesFunciones.BENEFICIARIO));
			entity.setvalor(resultSet.getDouble(strPrefijo+ProcesoMayorizarDiarioConstantesFunciones.VALOR));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoMayorizarDiario getEntityProcesoMayorizarDiario(String strPrefijo,ProcesoMayorizarDiario entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoMayorizarDiario.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoMayorizarDiario.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoMayorizarDiarioLogic.setFieldReflectionProcesoMayorizarDiario(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoMayorizarDiario(Field field,String strPrefijo,String sColumn,ProcesoMayorizarDiario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoMayorizarDiarioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoMayorizarDiarioConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProcesoMayorizarDiarioConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoMayorizarDiarioConstantesFunciones.VALOR:
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
	
	public void quitarProcesoMayorizarDiariosNulos() throws Exception {				
		
		List<ProcesoMayorizarDiario> procesomayorizardiariosAux= new ArrayList<ProcesoMayorizarDiario>();
		
		for(ProcesoMayorizarDiario procesomayorizardiario:procesomayorizardiarios) {
			if(procesomayorizardiario!=null) {
				procesomayorizardiariosAux.add(procesomayorizardiario);
			}
		}
		
		procesomayorizardiarios=procesomayorizardiariosAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoMayorizarDiario> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoMayorizarDiario> entities = new  ArrayList<ProcesoMayorizarDiario>();
		ProcesoMayorizarDiario entity = new ProcesoMayorizarDiario();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoMayorizarDiario>((List<ProcesoMayorizarDiario>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoMayorizarDiariosOriginal(entities);
			
			}  else {
				this.procesomayorizardiariosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoMayorizarDiarioConstantesFunciones.quitarEspaciosProcesoMayorizarDiarios(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesomayorizardiarios = new  ArrayList<ProcesoMayorizarDiario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesomayorizardiarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesomayorizardiarios = new  ArrayList<ProcesoMayorizarDiario>();
		  		  
        try {
			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesomayorizardiarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoMayorizarDiario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoMayorizarDiario> entities = new  ArrayList<ProcesoMayorizarDiario>();
		ProcesoMayorizarDiario entity = new ProcesoMayorizarDiario();		  
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
	
	public  List<ProcesoMayorizarDiario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoMayorizarDiario> entities = new  ArrayList<ProcesoMayorizarDiario>();
		ProcesoMayorizarDiario entity = new ProcesoMayorizarDiario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoMayorizarDiario();
				
				if(conMapGenerico) {
					entity.setMapProcesoMayorizarDiario( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoMayorizarDiario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoMayorizarDiarioDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoMayorizarDiarioLogic.getEntityProcesoMayorizarDiario("",entity,resultSet,listColumns);
					
					////entity.setProcesoMayorizarDiarioOriginal( new ProcesoMayorizarDiario());
					////entity.setProcesoMayorizarDiarioOriginal(super.getEntity("",entity.getProcesoMayorizarDiarioOriginal(),resultSet,ProcesoMayorizarDiarioDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoMayorizarDiarioOriginal(ProcesoMayorizarDiarioDataAccess.getEntityProcesoMayorizarDiario("",entity.getProcesoMayorizarDiarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ProcesoMayorizarDiario relprocesomayorizardiario)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relprocesomayorizardiario.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProcesoMayorizarDiario relprocesomayorizardiario)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relprocesomayorizardiario.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,ProcesoMayorizarDiario relprocesomayorizardiario)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relprocesomayorizardiario.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,ProcesoMayorizarDiario relprocesomayorizardiario)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);
			tipomovimientoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relprocesomayorizardiario.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}


	
	
	public void getProcesoMayorizarDiariosBusquedaProcesoMayorizarDiarioWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String codigo,Long id_tipo_movimiento,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			ProcesoMayorizarDiarioLogic procesomayorizardiarioLogic=new ProcesoMayorizarDiarioLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			//sQuerySelect=ProcesoMayorizarDiarioLogic.GetSelecSqlProcesoMayorizarDiario(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,codigo,id_tipo_movimiento,fecha_inicio,fecha_fin);

			//this.getEntities(sQuerySelect, sFinalQueryFinal);

			//this.procesomayorizardiarios=this.getProcesoMayorizarDiarios();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoMayorizarDiarioLogicAdditional.ProcesarInformacionProcesoMayorizarDiario(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesomayorizardiarioLogic,this.procesomayorizardiarios,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoMayorizarDiario",codigo,id_tipo_movimiento,fecha_inicio,fecha_fin);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoMayorizarDiariosBusquedaProcesoMayorizarDiario(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String codigo,Long id_tipo_movimiento,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			ProcesoMayorizarDiarioLogic procesomayorizardiarioLogic=new ProcesoMayorizarDiarioLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			//sQuerySelect=ProcesoMayorizarDiarioLogic.GetSelecSqlProcesoMayorizarDiario(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,codigo,id_tipo_movimiento,fecha_inicio,fecha_fin);

			//this.getEntities(sQuerySelect, sFinalQueryFinal);

			//this.procesomayorizardiarios=this.getProcesoMayorizarDiarios();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoMayorizarDiarioLogicAdditional.ProcesarInformacionProcesoMayorizarDiario(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesomayorizardiarioLogic,this.procesomayorizardiarios,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoMayorizarDiario",codigo,id_tipo_movimiento,fecha_inicio,fecha_fin);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoMayorizarDiario(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String codigo,Long id_tipo_movimiento,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoMayorizarDiario_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(codigo!= null && !codigo.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" codigo = "+"'"+codigo+"'";
					existeWhere=true;
				}

				if(id_tipo_movimiento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" id_tipo_movimiento = "+id_tipo_movimiento.toString();
					existeWhere=true;
				}

				if(fecha_inicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_inicio)+"'";
					existeWhere=true;
				}

				if(fecha_fin!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_fin)+"'";
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
	
	
	public void deepLoad(ProcesoMayorizarDiario procesomayorizardiario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoMayorizarDiarioLogicAdditional.updateProcesoMayorizarDiarioToGet(procesomayorizardiario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesomayorizardiario.setEmpresa(procesomayorizardiarioDataAccess.getEmpresa(connexion,procesomayorizardiario));
		procesomayorizardiario.setSucursal(procesomayorizardiarioDataAccess.getSucursal(connexion,procesomayorizardiario));
		procesomayorizardiario.setEjercicio(procesomayorizardiarioDataAccess.getEjercicio(connexion,procesomayorizardiario));
		procesomayorizardiario.setTipoMovimiento(procesomayorizardiarioDataAccess.getTipoMovimiento(connexion,procesomayorizardiario));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				procesomayorizardiario.setEmpresa(procesomayorizardiarioDataAccess.getEmpresa(connexion,procesomayorizardiario));
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesomayorizardiario.setSucursal(procesomayorizardiarioDataAccess.getSucursal(connexion,procesomayorizardiario));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				procesomayorizardiario.setEjercicio(procesomayorizardiarioDataAccess.getEjercicio(connexion,procesomayorizardiario));
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				procesomayorizardiario.setTipoMovimiento(procesomayorizardiarioDataAccess.getTipoMovimiento(connexion,procesomayorizardiario));
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
			procesomayorizardiario.setEmpresa(procesomayorizardiarioDataAccess.getEmpresa(connexion,procesomayorizardiario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesomayorizardiario.setSucursal(procesomayorizardiarioDataAccess.getSucursal(connexion,procesomayorizardiario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesomayorizardiario.setEjercicio(procesomayorizardiarioDataAccess.getEjercicio(connexion,procesomayorizardiario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesomayorizardiario.setTipoMovimiento(procesomayorizardiarioDataAccess.getTipoMovimiento(connexion,procesomayorizardiario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesomayorizardiario.setEmpresa(procesomayorizardiarioDataAccess.getEmpresa(connexion,procesomayorizardiario));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(procesomayorizardiario.getEmpresa(),isDeep,deepLoadType,clases);
				
		procesomayorizardiario.setSucursal(procesomayorizardiarioDataAccess.getSucursal(connexion,procesomayorizardiario));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(procesomayorizardiario.getSucursal(),isDeep,deepLoadType,clases);
				
		procesomayorizardiario.setEjercicio(procesomayorizardiarioDataAccess.getEjercicio(connexion,procesomayorizardiario));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(procesomayorizardiario.getEjercicio(),isDeep,deepLoadType,clases);
				
		procesomayorizardiario.setTipoMovimiento(procesomayorizardiarioDataAccess.getTipoMovimiento(connexion,procesomayorizardiario));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(procesomayorizardiario.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				procesomayorizardiario.setEmpresa(procesomayorizardiarioDataAccess.getEmpresa(connexion,procesomayorizardiario));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(procesomayorizardiario.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesomayorizardiario.setSucursal(procesomayorizardiarioDataAccess.getSucursal(connexion,procesomayorizardiario));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(procesomayorizardiario.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				procesomayorizardiario.setEjercicio(procesomayorizardiarioDataAccess.getEjercicio(connexion,procesomayorizardiario));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(procesomayorizardiario.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				procesomayorizardiario.setTipoMovimiento(procesomayorizardiarioDataAccess.getTipoMovimiento(connexion,procesomayorizardiario));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(procesomayorizardiario.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			procesomayorizardiario.setEmpresa(procesomayorizardiarioDataAccess.getEmpresa(connexion,procesomayorizardiario));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(procesomayorizardiario.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesomayorizardiario.setSucursal(procesomayorizardiarioDataAccess.getSucursal(connexion,procesomayorizardiario));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(procesomayorizardiario.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesomayorizardiario.setEjercicio(procesomayorizardiarioDataAccess.getEjercicio(connexion,procesomayorizardiario));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(procesomayorizardiario.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesomayorizardiario.setTipoMovimiento(procesomayorizardiarioDataAccess.getTipoMovimiento(connexion,procesomayorizardiario));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(procesomayorizardiario.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesomayorizardiario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoMayorizarDiarioConstantesFunciones.refrescarForeignKeysDescripcionesProcesoMayorizarDiario(procesomayorizardiario);
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
			this.deepLoad(this.procesomayorizardiario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoMayorizarDiarioConstantesFunciones.refrescarForeignKeysDescripcionesProcesoMayorizarDiario(this.procesomayorizardiario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesomayorizardiarios!=null) {
				for(ProcesoMayorizarDiario procesomayorizardiario:procesomayorizardiarios) {
					this.deepLoad(procesomayorizardiario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoMayorizarDiarioConstantesFunciones.refrescarForeignKeysDescripcionesProcesoMayorizarDiario(procesomayorizardiarios);
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
			if(procesomayorizardiarios!=null) {
				for(ProcesoMayorizarDiario procesomayorizardiario:procesomayorizardiarios) {
					this.deepLoad(procesomayorizardiario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoMayorizarDiarioConstantesFunciones.refrescarForeignKeysDescripcionesProcesoMayorizarDiario(procesomayorizardiarios);
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
	
	public ProcesoMayorizarDiarioParameterReturnGeneral procesarAccionProcesoMayorizarDiarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoMayorizarDiario> procesomayorizardiarios,ProcesoMayorizarDiarioParameterReturnGeneral procesomayorizardiarioParameterGeneral)throws Exception {
		 try {	
			ProcesoMayorizarDiarioParameterReturnGeneral procesomayorizardiarioReturnGeneral=new ProcesoMayorizarDiarioParameterReturnGeneral();
	
			ProcesoMayorizarDiarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesomayorizardiarios,procesomayorizardiarioParameterGeneral,procesomayorizardiarioReturnGeneral);
			
			return procesomayorizardiarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoMayorizarDiarioParameterReturnGeneral procesarAccionProcesoMayorizarDiariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoMayorizarDiario> procesomayorizardiarios,ProcesoMayorizarDiarioParameterReturnGeneral procesomayorizardiarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoMayorizarDiarioParameterReturnGeneral procesomayorizardiarioReturnGeneral=new ProcesoMayorizarDiarioParameterReturnGeneral();
	
			ProcesoMayorizarDiarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesomayorizardiarios,procesomayorizardiarioParameterGeneral,procesomayorizardiarioReturnGeneral);
			
			this.connexion.commit();
			
			return procesomayorizardiarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoMayorizarDiario> procesomayorizardiarios,String sTipoBusqueda,String codigoBusquedaProcesoMayorizarDiario,Long id_tipo_movimientoBusquedaProcesoMayorizarDiario,Date fecha_inicioBusquedaProcesoMayorizarDiario,Date fecha_finBusquedaProcesoMayorizarDiario) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoMayorizarDiarioLogicAdditional procesomayorizardiarioLogicAdditional=new ProcesoMayorizarDiarioLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesomayorizardiarioLogicAdditional.setConnexion(this.connexion);

			procesomayorizardiarioLogicAdditional.ProcesarInformacionProcesoMayorizarDiario(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesomayorizardiarios,sTipoBusqueda,codigoBusquedaProcesoMayorizarDiario,id_tipo_movimientoBusquedaProcesoMayorizarDiario,fecha_inicioBusquedaProcesoMayorizarDiario,fecha_finBusquedaProcesoMayorizarDiario);

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

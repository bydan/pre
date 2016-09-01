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
import com.bydan.erp.tesoreria.util.report.ConciliacionesBancariasParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ConciliacionesBancariasParameterGeneral;
import com.bydan.erp.tesoreria.util.report.ConciliacionesBancariasConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.ConciliacionesBancarias;

import com.bydan.erp.tesoreria.business.logic.report.ConciliacionesBancariasLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ConciliacionesBancariasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ConciliacionesBancariasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ConciliacionesBancariasLogic conciliacionesbancariasDataAccess; 		
	protected ConciliacionesBancarias conciliacionesbancarias;
	protected List<ConciliacionesBancarias> conciliacionesbancariass;
	protected Object conciliacionesbancariasObject;	
	protected List<Object> conciliacionesbancariassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ConciliacionesBancariasLogic()throws SQLException,Exception {
		try	{
			this.conciliacionesbancariass= new ArrayList<ConciliacionesBancarias>();
			this.conciliacionesbancarias= new ConciliacionesBancarias();
			this.conciliacionesbancariasObject=new Object();
			this.conciliacionesbancariassObject=new ArrayList<Object>();
			
			this.conciliacionesbancariasDataAccess=this;
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
			this.conciliacionesbancariasDataAccess.setConnexionType(this.connexionType);
			this.conciliacionesbancariasDataAccess.setParameterDbType(this.parameterDbType);
			this.conciliacionesbancariasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConciliacionesBancariasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.conciliacionesbancariass= new ArrayList<ConciliacionesBancarias>();
			this.conciliacionesbancarias= new ConciliacionesBancarias();
			this.conciliacionesbancariasObject=new Object();
			this.conciliacionesbancariassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.conciliacionesbancariasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.conciliacionesbancariasDataAccess.setConnexionType(this.connexionType);
			this.conciliacionesbancariasDataAccess.setParameterDbType(this.parameterDbType);
			this.conciliacionesbancariasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ConciliacionesBancarias getConciliacionesBancarias() throws Exception {	
		ConciliacionesBancariasLogicAdditional.checkConciliacionesBancariasToGet(conciliacionesbancarias,this.datosCliente,this.arrDatoGeneral);
		ConciliacionesBancariasLogicAdditional.updateConciliacionesBancariasToGet(conciliacionesbancarias,this.arrDatoGeneral);
		
		return conciliacionesbancarias;
	}
		
	public void setConciliacionesBancarias(ConciliacionesBancarias newConciliacionesBancarias) {
		this.conciliacionesbancarias = newConciliacionesBancarias;
	}
	
	public List<ConciliacionesBancarias> getConciliacionesBancariass() throws Exception {		
		this.quitarConciliacionesBancariassNulos();
		
		ConciliacionesBancariasLogicAdditional.checkConciliacionesBancariasToGets(conciliacionesbancariass,this.datosCliente,this.arrDatoGeneral);
		
		for (ConciliacionesBancarias conciliacionesbancariasLocal: conciliacionesbancariass ) {
			ConciliacionesBancariasLogicAdditional.updateConciliacionesBancariasToGet(conciliacionesbancariasLocal,this.arrDatoGeneral);
		}
		
		return conciliacionesbancariass;
	}
	
	public void setConciliacionesBancariass(List<ConciliacionesBancarias> newConciliacionesBancariass) {
		this.conciliacionesbancariass = newConciliacionesBancariass;
	}
	
	public Object getConciliacionesBancariasObject() {	
		//this.conciliacionesbancariasObject=this.conciliacionesbancariasDataAccess.getEntityObject();
		return this.conciliacionesbancariasObject;
	}
		
	public void setConciliacionesBancariasObject(Object newConciliacionesBancariasObject) {
		this.conciliacionesbancariasObject = newConciliacionesBancariasObject;
	}
	
	public List<Object> getConciliacionesBancariassObject() {		
		//this.conciliacionesbancariassObject=this.conciliacionesbancariasDataAccess.getEntitiesObject();
		return this.conciliacionesbancariassObject;
	}
		
	public void setConciliacionesBancariassObject(List<Object> newConciliacionesBancariassObject) {
		this.conciliacionesbancariassObject = newConciliacionesBancariassObject;
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
		conciliacionesbancariass = new  ArrayList<ConciliacionesBancarias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		conciliacionesbancariass = new  ArrayList<ConciliacionesBancarias>();
		  		  
        try {
			//ConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conciliacionesbancariass = new  ArrayList<ConciliacionesBancarias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		conciliacionesbancariass = new  ArrayList<ConciliacionesBancarias>();
		  		  
        try {
			//ConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		conciliacionesbancariass = new  ArrayList<ConciliacionesBancarias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		conciliacionesbancariass = new  ArrayList<ConciliacionesBancarias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ConciliacionesBancarias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConciliacionesBancarias> entities = new  ArrayList<ConciliacionesBancarias>();
		ConciliacionesBancarias entity = new ConciliacionesBancarias();		  
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
	
	public  List<ConciliacionesBancarias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConciliacionesBancarias> entities = new  ArrayList<ConciliacionesBancarias>();
		ConciliacionesBancarias entity = new ConciliacionesBancarias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConciliacionesBancarias();
				
				
      	    	entity=ConciliacionesBancariasLogic.getEntityConciliacionesBancarias("",entity,resultSet);
      	    	
				//entity.setConciliacionesBancariasOriginal( new ConciliacionesBancarias());
      	    	//entity.setConciliacionesBancariasOriginal(super.getEntity("",entity.getConciliacionesBancariasOriginal(),resultSet,ConciliacionesBancariasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConciliacionesBancariasOriginal(ConciliacionesBancariasDataAccess.getEntityConciliacionesBancarias("",entity.getConciliacionesBancariasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ConciliacionesBancarias> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConciliacionesBancarias> entities = new  ArrayList<ConciliacionesBancarias>();
		ConciliacionesBancarias entity = new ConciliacionesBancarias();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ConciliacionesBancarias.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConciliacionesBancarias>((List<ConciliacionesBancarias>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConciliacionesBancariassOriginal(entities);
			
			}  else {
				this.conciliacionesbancariassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConciliacionesBancariasConstantesFunciones.quitarEspaciosConciliacionesBancariass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ConciliacionesBancarias getEntityConciliacionesBancarias(String strPrefijo,ConciliacionesBancarias entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnumero_mayor(resultSet.getString(strPrefijo+ConciliacionesBancariasConstantesFunciones.NUMEROMAYOR));
			entity.setcodigo_cuenta(resultSet.getString(strPrefijo+ConciliacionesBancariasConstantesFunciones.CODIGOCUENTA));
			entity.setnombre_cuenta(resultSet.getString(strPrefijo+ConciliacionesBancariasConstantesFunciones.NOMBRECUENTA));
			entity.setdebito_local(resultSet.getDouble(strPrefijo+ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL));
			entity.setcredito_local(resultSet.getDouble(strPrefijo+ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL));
			entity.setnumero_deposito(resultSet.getString(strPrefijo+ConciliacionesBancariasConstantesFunciones.NUMERODEPOSITO));
			entity.setdebito_extran(resultSet.getDouble(strPrefijo+ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN));
			entity.setcredito_extran(resultSet.getDouble(strPrefijo+ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ConciliacionesBancariasConstantesFunciones.FECHA).getTime()));
			entity.setdetalle(resultSet.getString(strPrefijo+ConciliacionesBancariasConstantesFunciones.DETALLE));
			entity.setbeneficiario(resultSet.getString(strPrefijo+ConciliacionesBancariasConstantesFunciones.BENEFICIARIO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ConciliacionesBancarias getEntityConciliacionesBancarias(String strPrefijo,ConciliacionesBancarias entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ConciliacionesBancarias.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ConciliacionesBancarias.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ConciliacionesBancariasLogic.setFieldReflectionConciliacionesBancarias(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionConciliacionesBancarias(Field field,String strPrefijo,String sColumn,ConciliacionesBancarias entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ConciliacionesBancariasConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.CODIGOCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.NOMBRECUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.NUMERODEPOSITO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConciliacionesBancariasConstantesFunciones.BENEFICIARIO:
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
	
	public void quitarConciliacionesBancariassNulos() throws Exception {				
		
		List<ConciliacionesBancarias> conciliacionesbancariassAux= new ArrayList<ConciliacionesBancarias>();
		
		for(ConciliacionesBancarias conciliacionesbancarias:conciliacionesbancariass) {
			if(conciliacionesbancarias!=null) {
				conciliacionesbancariassAux.add(conciliacionesbancarias);
			}
		}
		
		conciliacionesbancariass=conciliacionesbancariassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ConciliacionesBancarias> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConciliacionesBancarias> entities = new  ArrayList<ConciliacionesBancarias>();
		ConciliacionesBancarias entity = new ConciliacionesBancarias();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConciliacionesBancarias>((List<ConciliacionesBancarias>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConciliacionesBancariassOriginal(entities);
			
			}  else {
				this.conciliacionesbancariassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConciliacionesBancariasConstantesFunciones.quitarEspaciosConciliacionesBancariass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		conciliacionesbancariass = new  ArrayList<ConciliacionesBancarias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		conciliacionesbancariass = new  ArrayList<ConciliacionesBancarias>();
		  		  
        try {
			//ConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ConciliacionesBancarias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConciliacionesBancarias> entities = new  ArrayList<ConciliacionesBancarias>();
		ConciliacionesBancarias entity = new ConciliacionesBancarias();		  
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
	
	public  List<ConciliacionesBancarias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConciliacionesBancarias> entities = new  ArrayList<ConciliacionesBancarias>();
		ConciliacionesBancarias entity = new ConciliacionesBancarias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConciliacionesBancarias();
				
				if(conMapGenerico) {
					entity.setMapConciliacionesBancarias( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapConciliacionesBancarias().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConciliacionesBancariasDataAccess.ISWITHSCHEMA);         		
					entity=ConciliacionesBancariasLogic.getEntityConciliacionesBancarias("",entity,resultSet,listColumns);
					
					////entity.setConciliacionesBancariasOriginal( new ConciliacionesBancarias());
					////entity.setConciliacionesBancariasOriginal(super.getEntity("",entity.getConciliacionesBancariasOriginal(),resultSet,ConciliacionesBancariasDataAccess.ISWITHSCHEMA));         		
					////entity.setConciliacionesBancariasOriginal(ConciliacionesBancariasDataAccess.getEntityConciliacionesBancarias("",entity.getConciliacionesBancariasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ConciliacionesBancarias relconciliacionesbancarias)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relconciliacionesbancarias.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CuentaContable getCuentaContable(Connexion connexion,ConciliacionesBancarias relconciliacionesbancarias)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontableDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relconciliacionesbancarias.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


	
	
	public void getConciliacionesBancariassBusquedaConciliacionesBancariasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//ConciliacionesBancariasLogic conciliacionesbancariasLogic=new ConciliacionesBancariasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConciliacionesBancariasLogic.GetSelecSqlConciliacionesBancarias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cuenta_contable,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.conciliacionesbancariass=this.getConciliacionesBancariass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getConciliacionesBancariassBusquedaConciliacionesBancarias(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//ConciliacionesBancariasLogic conciliacionesbancariasLogic=new ConciliacionesBancariasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConciliacionesBancariasLogic.GetSelecSqlConciliacionesBancarias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cuenta_contable,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.conciliacionesbancariass=this.getConciliacionesBancariass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlConciliacionesBancarias(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ConciliacionesBancarias_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" a.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" a.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_cuenta_contable!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_cuenta_contable = "+id_cuenta_contable.toString();
					existeWhere=true;
				}

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
					existeWhere=true;
				}

				if(fecha_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_hasta)+"'";
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
	
	
	public void deepLoad(ConciliacionesBancarias conciliacionesbancarias,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConciliacionesBancariasLogicAdditional.updateConciliacionesBancariasToGet(conciliacionesbancarias,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conciliacionesbancarias.setEmpresa(conciliacionesbancariasDataAccess.getEmpresa(connexion,conciliacionesbancarias));
		conciliacionesbancarias.setCuentaContable(conciliacionesbancariasDataAccess.getCuentaContable(connexion,conciliacionesbancarias));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				conciliacionesbancarias.setEmpresa(conciliacionesbancariasDataAccess.getEmpresa(connexion,conciliacionesbancarias));
			}

			if(clas.clas.equals(CuentaContable.class)) {
				conciliacionesbancarias.setCuentaContable(conciliacionesbancariasDataAccess.getCuentaContable(connexion,conciliacionesbancarias));
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
			conciliacionesbancarias.setEmpresa(conciliacionesbancariasDataAccess.getEmpresa(connexion,conciliacionesbancarias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conciliacionesbancarias.setCuentaContable(conciliacionesbancariasDataAccess.getCuentaContable(connexion,conciliacionesbancarias));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conciliacionesbancarias.setEmpresa(conciliacionesbancariasDataAccess.getEmpresa(connexion,conciliacionesbancarias));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(conciliacionesbancarias.getEmpresa(),isDeep,deepLoadType,clases);
				
		conciliacionesbancarias.setCuentaContable(conciliacionesbancariasDataAccess.getCuentaContable(connexion,conciliacionesbancarias));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(conciliacionesbancarias.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				conciliacionesbancarias.setEmpresa(conciliacionesbancariasDataAccess.getEmpresa(connexion,conciliacionesbancarias));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(conciliacionesbancarias.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(CuentaContable.class)) {
				conciliacionesbancarias.setCuentaContable(conciliacionesbancariasDataAccess.getCuentaContable(connexion,conciliacionesbancarias));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(conciliacionesbancarias.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			conciliacionesbancarias.setEmpresa(conciliacionesbancariasDataAccess.getEmpresa(connexion,conciliacionesbancarias));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(conciliacionesbancarias.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conciliacionesbancarias.setCuentaContable(conciliacionesbancariasDataAccess.getCuentaContable(connexion,conciliacionesbancarias));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(conciliacionesbancarias.getCuentaContable(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(conciliacionesbancarias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConciliacionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesConciliacionesBancarias(conciliacionesbancarias);
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
			this.deepLoad(this.conciliacionesbancarias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConciliacionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesConciliacionesBancarias(this.conciliacionesbancarias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(conciliacionesbancariass!=null) {
				for(ConciliacionesBancarias conciliacionesbancarias:conciliacionesbancariass) {
					this.deepLoad(conciliacionesbancarias,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConciliacionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesConciliacionesBancarias(conciliacionesbancariass);
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
			if(conciliacionesbancariass!=null) {
				for(ConciliacionesBancarias conciliacionesbancarias:conciliacionesbancariass) {
					this.deepLoad(conciliacionesbancarias,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConciliacionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesConciliacionesBancarias(conciliacionesbancariass);
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
	
	public ConciliacionesBancariasParameterReturnGeneral procesarAccionConciliacionesBancariass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConciliacionesBancarias> conciliacionesbancariass,ConciliacionesBancariasParameterReturnGeneral conciliacionesbancariasParameterGeneral)throws Exception {
		 try {	
			ConciliacionesBancariasParameterReturnGeneral conciliacionesbancariasReturnGeneral=new ConciliacionesBancariasParameterReturnGeneral();
	
			ConciliacionesBancariasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conciliacionesbancariass,conciliacionesbancariasParameterGeneral,conciliacionesbancariasReturnGeneral);
			
			return conciliacionesbancariasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConciliacionesBancariasParameterReturnGeneral procesarAccionConciliacionesBancariassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConciliacionesBancarias> conciliacionesbancariass,ConciliacionesBancariasParameterReturnGeneral conciliacionesbancariasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ConciliacionesBancariasParameterReturnGeneral conciliacionesbancariasReturnGeneral=new ConciliacionesBancariasParameterReturnGeneral();
	
			ConciliacionesBancariasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conciliacionesbancariass,conciliacionesbancariasParameterGeneral,conciliacionesbancariasReturnGeneral);
			
			this.connexion.commit();
			
			return conciliacionesbancariasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

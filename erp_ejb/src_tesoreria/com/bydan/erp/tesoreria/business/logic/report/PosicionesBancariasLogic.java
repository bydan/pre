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
import com.bydan.erp.tesoreria.util.report.PosicionesBancariasParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.PosicionesBancariasParameterGeneral;
import com.bydan.erp.tesoreria.util.report.PosicionesBancariasConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.PosicionesBancarias;

import com.bydan.erp.tesoreria.business.logic.report.PosicionesBancariasLogicAdditional;
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
public class PosicionesBancariasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(PosicionesBancariasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected PosicionesBancariasLogic posicionesbancariasDataAccess; 		
	protected PosicionesBancarias posicionesbancarias;
	protected List<PosicionesBancarias> posicionesbancariass;
	protected Object posicionesbancariasObject;	
	protected List<Object> posicionesbancariassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  PosicionesBancariasLogic()throws SQLException,Exception {
		try	{
			this.posicionesbancariass= new ArrayList<PosicionesBancarias>();
			this.posicionesbancarias= new PosicionesBancarias();
			this.posicionesbancariasObject=new Object();
			this.posicionesbancariassObject=new ArrayList<Object>();
			
			this.posicionesbancariasDataAccess=this;
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
			this.posicionesbancariasDataAccess.setConnexionType(this.connexionType);
			this.posicionesbancariasDataAccess.setParameterDbType(this.parameterDbType);
			this.posicionesbancariasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PosicionesBancariasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.posicionesbancariass= new ArrayList<PosicionesBancarias>();
			this.posicionesbancarias= new PosicionesBancarias();
			this.posicionesbancariasObject=new Object();
			this.posicionesbancariassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.posicionesbancariasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.posicionesbancariasDataAccess.setConnexionType(this.connexionType);
			this.posicionesbancariasDataAccess.setParameterDbType(this.parameterDbType);
			this.posicionesbancariasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PosicionesBancarias getPosicionesBancarias() throws Exception {	
		PosicionesBancariasLogicAdditional.checkPosicionesBancariasToGet(posicionesbancarias,this.datosCliente,this.arrDatoGeneral);
		PosicionesBancariasLogicAdditional.updatePosicionesBancariasToGet(posicionesbancarias,this.arrDatoGeneral);
		
		return posicionesbancarias;
	}
		
	public void setPosicionesBancarias(PosicionesBancarias newPosicionesBancarias) {
		this.posicionesbancarias = newPosicionesBancarias;
	}
	
	public List<PosicionesBancarias> getPosicionesBancariass() throws Exception {		
		this.quitarPosicionesBancariassNulos();
		
		PosicionesBancariasLogicAdditional.checkPosicionesBancariasToGets(posicionesbancariass,this.datosCliente,this.arrDatoGeneral);
		
		for (PosicionesBancarias posicionesbancariasLocal: posicionesbancariass ) {
			PosicionesBancariasLogicAdditional.updatePosicionesBancariasToGet(posicionesbancariasLocal,this.arrDatoGeneral);
		}
		
		return posicionesbancariass;
	}
	
	public void setPosicionesBancariass(List<PosicionesBancarias> newPosicionesBancariass) {
		this.posicionesbancariass = newPosicionesBancariass;
	}
	
	public Object getPosicionesBancariasObject() {	
		//this.posicionesbancariasObject=this.posicionesbancariasDataAccess.getEntityObject();
		return this.posicionesbancariasObject;
	}
		
	public void setPosicionesBancariasObject(Object newPosicionesBancariasObject) {
		this.posicionesbancariasObject = newPosicionesBancariasObject;
	}
	
	public List<Object> getPosicionesBancariassObject() {		
		//this.posicionesbancariassObject=this.posicionesbancariasDataAccess.getEntitiesObject();
		return this.posicionesbancariassObject;
	}
		
	public void setPosicionesBancariassObject(List<Object> newPosicionesBancariassObject) {
		this.posicionesbancariassObject = newPosicionesBancariassObject;
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
		posicionesbancariass = new  ArrayList<PosicionesBancarias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PosicionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			posicionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		posicionesbancariass = new  ArrayList<PosicionesBancarias>();
		  		  
        try {
			//PosicionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			posicionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		posicionesbancariass = new  ArrayList<PosicionesBancarias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PosicionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			posicionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		posicionesbancariass = new  ArrayList<PosicionesBancarias>();
		  		  
        try {
			//PosicionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			posicionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		posicionesbancariass = new  ArrayList<PosicionesBancarias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PosicionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			posicionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		posicionesbancariass = new  ArrayList<PosicionesBancarias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//PosicionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			posicionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<PosicionesBancarias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PosicionesBancarias> entities = new  ArrayList<PosicionesBancarias>();
		PosicionesBancarias entity = new PosicionesBancarias();		  
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
	
	public  List<PosicionesBancarias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PosicionesBancarias> entities = new  ArrayList<PosicionesBancarias>();
		PosicionesBancarias entity = new PosicionesBancarias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PosicionesBancarias();
				
				
      	    	entity=PosicionesBancariasLogic.getEntityPosicionesBancarias("",entity,resultSet);
      	    	
				//entity.setPosicionesBancariasOriginal( new PosicionesBancarias());
      	    	//entity.setPosicionesBancariasOriginal(super.getEntity("",entity.getPosicionesBancariasOriginal(),resultSet,PosicionesBancariasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPosicionesBancariasOriginal(PosicionesBancariasDataAccess.getEntityPosicionesBancarias("",entity.getPosicionesBancariasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<PosicionesBancarias> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PosicionesBancarias> entities = new  ArrayList<PosicionesBancarias>();
		PosicionesBancarias entity = new PosicionesBancarias();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,PosicionesBancarias.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PosicionesBancarias>((List<PosicionesBancarias>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPosicionesBancariassOriginal(entities);
			
			}  else {
				this.posicionesbancariassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PosicionesBancariasConstantesFunciones.quitarEspaciosPosicionesBancariass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static PosicionesBancarias getEntityPosicionesBancarias(String strPrefijo,PosicionesBancarias entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.settipo_documento(resultSet.getString(strPrefijo+PosicionesBancariasConstantesFunciones.TIPODOCUMENTO));
			entity.setdetalle(resultSet.getString(strPrefijo+PosicionesBancariasConstantesFunciones.DETALLE));
			entity.setcodigo_cuenta(resultSet.getString(strPrefijo+PosicionesBancariasConstantesFunciones.CODIGOCUENTA));
			entity.setnombre_cuenta(resultSet.getString(strPrefijo+PosicionesBancariasConstantesFunciones.NOMBRECUENTA));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+PosicionesBancariasConstantesFunciones.NUMEROMAYOR));
			entity.setdebito_local(resultSet.getDouble(strPrefijo+PosicionesBancariasConstantesFunciones.DEBITOLOCAL));
			entity.setcredito_local(resultSet.getDouble(strPrefijo+PosicionesBancariasConstantesFunciones.CREDITOLOCAL));
			entity.settipo_movimiento(resultSet.getString(strPrefijo+PosicionesBancariasConstantesFunciones.TIPOMOVIMIENTO));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PosicionesBancariasConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+PosicionesBancariasConstantesFunciones.FECHA).getTime()));
			entity.setbeneficiario(resultSet.getString(strPrefijo+PosicionesBancariasConstantesFunciones.BENEFICIARIO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PosicionesBancarias getEntityPosicionesBancarias(String strPrefijo,PosicionesBancarias entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = PosicionesBancarias.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = PosicionesBancarias.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				PosicionesBancariasLogic.setFieldReflectionPosicionesBancarias(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPosicionesBancarias(Field field,String strPrefijo,String sColumn,PosicionesBancarias entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PosicionesBancariasConstantesFunciones.TIPODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PosicionesBancariasConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PosicionesBancariasConstantesFunciones.CODIGOCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PosicionesBancariasConstantesFunciones.NOMBRECUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PosicionesBancariasConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PosicionesBancariasConstantesFunciones.DEBITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PosicionesBancariasConstantesFunciones.CREDITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PosicionesBancariasConstantesFunciones.TIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PosicionesBancariasConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PosicionesBancariasConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PosicionesBancariasConstantesFunciones.BENEFICIARIO:
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
	
	public void quitarPosicionesBancariassNulos() throws Exception {				
		
		List<PosicionesBancarias> posicionesbancariassAux= new ArrayList<PosicionesBancarias>();
		
		for(PosicionesBancarias posicionesbancarias:posicionesbancariass) {
			if(posicionesbancarias!=null) {
				posicionesbancariassAux.add(posicionesbancarias);
			}
		}
		
		posicionesbancariass=posicionesbancariassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<PosicionesBancarias> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PosicionesBancarias> entities = new  ArrayList<PosicionesBancarias>();
		PosicionesBancarias entity = new PosicionesBancarias();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PosicionesBancarias>((List<PosicionesBancarias>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPosicionesBancariassOriginal(entities);
			
			}  else {
				this.posicionesbancariassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PosicionesBancariasConstantesFunciones.quitarEspaciosPosicionesBancariass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		posicionesbancariass = new  ArrayList<PosicionesBancarias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PosicionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			posicionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		posicionesbancariass = new  ArrayList<PosicionesBancarias>();
		  		  
        try {
			//PosicionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			posicionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<PosicionesBancarias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PosicionesBancarias> entities = new  ArrayList<PosicionesBancarias>();
		PosicionesBancarias entity = new PosicionesBancarias();		  
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
	
	public  List<PosicionesBancarias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PosicionesBancarias> entities = new  ArrayList<PosicionesBancarias>();
		PosicionesBancarias entity = new PosicionesBancarias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PosicionesBancarias();
				
				if(conMapGenerico) {
					entity.setMapPosicionesBancarias( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapPosicionesBancarias().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PosicionesBancariasDataAccess.ISWITHSCHEMA);         		
					entity=PosicionesBancariasLogic.getEntityPosicionesBancarias("",entity,resultSet,listColumns);
					
					////entity.setPosicionesBancariasOriginal( new PosicionesBancarias());
					////entity.setPosicionesBancariasOriginal(super.getEntity("",entity.getPosicionesBancariasOriginal(),resultSet,PosicionesBancariasDataAccess.ISWITHSCHEMA));         		
					////entity.setPosicionesBancariasOriginal(PosicionesBancariasDataAccess.getEntityPosicionesBancarias("",entity.getPosicionesBancariasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,PosicionesBancarias relposicionesbancarias)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relposicionesbancarias.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,PosicionesBancarias relposicionesbancarias)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relposicionesbancarias.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,PosicionesBancarias relposicionesbancarias)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);
			tipomovimientoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relposicionesbancarias.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}


	
	
	public void getPosicionesBancariassBusquedaPosicionesBancariasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta,Long orden_desde,Long orden_hasta)throws Exception {
		try {
			//PosicionesBancariasLogic posicionesbancariasLogic=new PosicionesBancariasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PosicionesBancariasLogic.GetSelecSqlPosicionesBancarias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_tipo_movimiento,fecha_desde,fecha_hasta,orden_desde,orden_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.posicionesbancariass=this.getPosicionesBancariass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getPosicionesBancariassBusquedaPosicionesBancarias(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta,Long orden_desde,Long orden_hasta)throws Exception {
		try {
			//PosicionesBancariasLogic posicionesbancariasLogic=new PosicionesBancariasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PosicionesBancariasLogic.GetSelecSqlPosicionesBancarias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_tipo_movimiento,fecha_desde,fecha_hasta,orden_desde,orden_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.posicionesbancariass=this.getPosicionesBancariass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlPosicionesBancarias(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta,Long orden_desde,Long orden_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("PosicionesBancarias_Postgres.sql");
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
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_ejercicio = "+id_ejercicio.toString();
					existeWhere=true;
				}

				if(id_tipo_movimiento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_tipo_movimiento = "+id_tipo_movimiento.toString();
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

				if(orden_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.orden between "+orden_desde.toString();
					existeWhere=true;
				}

				if(orden_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=orden_hasta.toString();
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
	
	
	public void deepLoad(PosicionesBancarias posicionesbancarias,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PosicionesBancariasLogicAdditional.updatePosicionesBancariasToGet(posicionesbancarias,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		posicionesbancarias.setEmpresa(posicionesbancariasDataAccess.getEmpresa(connexion,posicionesbancarias));
		posicionesbancarias.setEjercicio(posicionesbancariasDataAccess.getEjercicio(connexion,posicionesbancarias));
		posicionesbancarias.setTipoMovimiento(posicionesbancariasDataAccess.getTipoMovimiento(connexion,posicionesbancarias));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				posicionesbancarias.setEmpresa(posicionesbancariasDataAccess.getEmpresa(connexion,posicionesbancarias));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				posicionesbancarias.setEjercicio(posicionesbancariasDataAccess.getEjercicio(connexion,posicionesbancarias));
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				posicionesbancarias.setTipoMovimiento(posicionesbancariasDataAccess.getTipoMovimiento(connexion,posicionesbancarias));
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
			posicionesbancarias.setEmpresa(posicionesbancariasDataAccess.getEmpresa(connexion,posicionesbancarias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			posicionesbancarias.setEjercicio(posicionesbancariasDataAccess.getEjercicio(connexion,posicionesbancarias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			posicionesbancarias.setTipoMovimiento(posicionesbancariasDataAccess.getTipoMovimiento(connexion,posicionesbancarias));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		posicionesbancarias.setEmpresa(posicionesbancariasDataAccess.getEmpresa(connexion,posicionesbancarias));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(posicionesbancarias.getEmpresa(),isDeep,deepLoadType,clases);
				
		posicionesbancarias.setEjercicio(posicionesbancariasDataAccess.getEjercicio(connexion,posicionesbancarias));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(posicionesbancarias.getEjercicio(),isDeep,deepLoadType,clases);
				
		posicionesbancarias.setTipoMovimiento(posicionesbancariasDataAccess.getTipoMovimiento(connexion,posicionesbancarias));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(posicionesbancarias.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				posicionesbancarias.setEmpresa(posicionesbancariasDataAccess.getEmpresa(connexion,posicionesbancarias));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(posicionesbancarias.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				posicionesbancarias.setEjercicio(posicionesbancariasDataAccess.getEjercicio(connexion,posicionesbancarias));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(posicionesbancarias.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				posicionesbancarias.setTipoMovimiento(posicionesbancariasDataAccess.getTipoMovimiento(connexion,posicionesbancarias));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(posicionesbancarias.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			posicionesbancarias.setEmpresa(posicionesbancariasDataAccess.getEmpresa(connexion,posicionesbancarias));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(posicionesbancarias.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			posicionesbancarias.setEjercicio(posicionesbancariasDataAccess.getEjercicio(connexion,posicionesbancarias));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(posicionesbancarias.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			posicionesbancarias.setTipoMovimiento(posicionesbancariasDataAccess.getTipoMovimiento(connexion,posicionesbancarias));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(posicionesbancarias.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(posicionesbancarias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PosicionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesPosicionesBancarias(posicionesbancarias);
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
			this.deepLoad(this.posicionesbancarias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PosicionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesPosicionesBancarias(this.posicionesbancarias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(posicionesbancariass!=null) {
				for(PosicionesBancarias posicionesbancarias:posicionesbancariass) {
					this.deepLoad(posicionesbancarias,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PosicionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesPosicionesBancarias(posicionesbancariass);
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
			if(posicionesbancariass!=null) {
				for(PosicionesBancarias posicionesbancarias:posicionesbancariass) {
					this.deepLoad(posicionesbancarias,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PosicionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesPosicionesBancarias(posicionesbancariass);
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
	
	public PosicionesBancariasParameterReturnGeneral procesarAccionPosicionesBancariass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PosicionesBancarias> posicionesbancariass,PosicionesBancariasParameterReturnGeneral posicionesbancariasParameterGeneral)throws Exception {
		 try {	
			PosicionesBancariasParameterReturnGeneral posicionesbancariasReturnGeneral=new PosicionesBancariasParameterReturnGeneral();
	
			PosicionesBancariasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,posicionesbancariass,posicionesbancariasParameterGeneral,posicionesbancariasReturnGeneral);
			
			return posicionesbancariasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PosicionesBancariasParameterReturnGeneral procesarAccionPosicionesBancariassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PosicionesBancarias> posicionesbancariass,PosicionesBancariasParameterReturnGeneral posicionesbancariasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			PosicionesBancariasParameterReturnGeneral posicionesbancariasReturnGeneral=new PosicionesBancariasParameterReturnGeneral();
	
			PosicionesBancariasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,posicionesbancariass,posicionesbancariasParameterGeneral,posicionesbancariasReturnGeneral);
			
			this.connexion.commit();
			
			return posicionesbancariasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

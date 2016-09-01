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
import com.bydan.erp.cartera.util.report.CobrarConciliacionesCarterasContabilidadParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarConciliacionesCarterasContabilidadParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarConciliacionesCarterasContabilidadConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarConciliacionesCarterasContabilidad;

import com.bydan.erp.cartera.business.logic.report.CobrarConciliacionesCarterasContabilidadLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarConciliacionesCarterasContabilidadLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarConciliacionesCarterasContabilidadLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarConciliacionesCarterasContabilidadLogic cobrarconciliacionescarterascontabilidadDataAccess; 		
	protected CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad;
	protected List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads;
	protected Object cobrarconciliacionescarterascontabilidadObject;	
	protected List<Object> cobrarconciliacionescarterascontabilidadsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarConciliacionesCarterasContabilidadLogic()throws SQLException,Exception {
		try	{
			this.cobrarconciliacionescarterascontabilidads= new ArrayList<CobrarConciliacionesCarterasContabilidad>();
			this.cobrarconciliacionescarterascontabilidad= new CobrarConciliacionesCarterasContabilidad();
			this.cobrarconciliacionescarterascontabilidadObject=new Object();
			this.cobrarconciliacionescarterascontabilidadsObject=new ArrayList<Object>();
			
			this.cobrarconciliacionescarterascontabilidadDataAccess=this;
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
			this.cobrarconciliacionescarterascontabilidadDataAccess.setConnexionType(this.connexionType);
			this.cobrarconciliacionescarterascontabilidadDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarconciliacionescarterascontabilidadDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarConciliacionesCarterasContabilidadLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarconciliacionescarterascontabilidads= new ArrayList<CobrarConciliacionesCarterasContabilidad>();
			this.cobrarconciliacionescarterascontabilidad= new CobrarConciliacionesCarterasContabilidad();
			this.cobrarconciliacionescarterascontabilidadObject=new Object();
			this.cobrarconciliacionescarterascontabilidadsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarconciliacionescarterascontabilidadDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarconciliacionescarterascontabilidadDataAccess.setConnexionType(this.connexionType);
			this.cobrarconciliacionescarterascontabilidadDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarconciliacionescarterascontabilidadDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarConciliacionesCarterasContabilidad getCobrarConciliacionesCarterasContabilidad() throws Exception {	
		CobrarConciliacionesCarterasContabilidadLogicAdditional.checkCobrarConciliacionesCarterasContabilidadToGet(cobrarconciliacionescarterascontabilidad,this.datosCliente,this.arrDatoGeneral);
		CobrarConciliacionesCarterasContabilidadLogicAdditional.updateCobrarConciliacionesCarterasContabilidadToGet(cobrarconciliacionescarterascontabilidad,this.arrDatoGeneral);
		
		return cobrarconciliacionescarterascontabilidad;
	}
		
	public void setCobrarConciliacionesCarterasContabilidad(CobrarConciliacionesCarterasContabilidad newCobrarConciliacionesCarterasContabilidad) {
		this.cobrarconciliacionescarterascontabilidad = newCobrarConciliacionesCarterasContabilidad;
	}
	
	public List<CobrarConciliacionesCarterasContabilidad> getCobrarConciliacionesCarterasContabilidads() throws Exception {		
		this.quitarCobrarConciliacionesCarterasContabilidadsNulos();
		
		CobrarConciliacionesCarterasContabilidadLogicAdditional.checkCobrarConciliacionesCarterasContabilidadToGets(cobrarconciliacionescarterascontabilidads,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadLocal: cobrarconciliacionescarterascontabilidads ) {
			CobrarConciliacionesCarterasContabilidadLogicAdditional.updateCobrarConciliacionesCarterasContabilidadToGet(cobrarconciliacionescarterascontabilidadLocal,this.arrDatoGeneral);
		}
		
		return cobrarconciliacionescarterascontabilidads;
	}
	
	public void setCobrarConciliacionesCarterasContabilidads(List<CobrarConciliacionesCarterasContabilidad> newCobrarConciliacionesCarterasContabilidads) {
		this.cobrarconciliacionescarterascontabilidads = newCobrarConciliacionesCarterasContabilidads;
	}
	
	public Object getCobrarConciliacionesCarterasContabilidadObject() {	
		//this.cobrarconciliacionescarterascontabilidadObject=this.cobrarconciliacionescarterascontabilidadDataAccess.getEntityObject();
		return this.cobrarconciliacionescarterascontabilidadObject;
	}
		
	public void setCobrarConciliacionesCarterasContabilidadObject(Object newCobrarConciliacionesCarterasContabilidadObject) {
		this.cobrarconciliacionescarterascontabilidadObject = newCobrarConciliacionesCarterasContabilidadObject;
	}
	
	public List<Object> getCobrarConciliacionesCarterasContabilidadsObject() {		
		//this.cobrarconciliacionescarterascontabilidadsObject=this.cobrarconciliacionescarterascontabilidadDataAccess.getEntitiesObject();
		return this.cobrarconciliacionescarterascontabilidadsObject;
	}
		
	public void setCobrarConciliacionesCarterasContabilidadsObject(List<Object> newCobrarConciliacionesCarterasContabilidadsObject) {
		this.cobrarconciliacionescarterascontabilidadsObject = newCobrarConciliacionesCarterasContabilidadsObject;
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
		cobrarconciliacionescarterascontabilidads = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarConciliacionesCarterasContabilidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarconciliacionescarterascontabilidads=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarconciliacionescarterascontabilidads = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		  		  
        try {
			//CobrarConciliacionesCarterasContabilidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarconciliacionescarterascontabilidads=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarconciliacionescarterascontabilidads = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarConciliacionesCarterasContabilidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarconciliacionescarterascontabilidads=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarconciliacionescarterascontabilidads = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		  		  
        try {
			//CobrarConciliacionesCarterasContabilidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarconciliacionescarterascontabilidads=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarconciliacionescarterascontabilidads = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarConciliacionesCarterasContabilidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarconciliacionescarterascontabilidads=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarconciliacionescarterascontabilidads = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarConciliacionesCarterasContabilidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarconciliacionescarterascontabilidads=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarConciliacionesCarterasContabilidad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarConciliacionesCarterasContabilidad> entities = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		CobrarConciliacionesCarterasContabilidad entity = new CobrarConciliacionesCarterasContabilidad();		  
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
	
	public  List<CobrarConciliacionesCarterasContabilidad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarConciliacionesCarterasContabilidad> entities = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		CobrarConciliacionesCarterasContabilidad entity = new CobrarConciliacionesCarterasContabilidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarConciliacionesCarterasContabilidad();
				
				
      	    	entity=CobrarConciliacionesCarterasContabilidadLogic.getEntityCobrarConciliacionesCarterasContabilidad("",entity,resultSet);
      	    	
				//entity.setCobrarConciliacionesCarterasContabilidadOriginal( new CobrarConciliacionesCarterasContabilidad());
      	    	//entity.setCobrarConciliacionesCarterasContabilidadOriginal(super.getEntity("",entity.getCobrarConciliacionesCarterasContabilidadOriginal(),resultSet,CobrarConciliacionesCarterasContabilidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarConciliacionesCarterasContabilidadOriginal(CobrarConciliacionesCarterasContabilidadDataAccess.getEntityCobrarConciliacionesCarterasContabilidad("",entity.getCobrarConciliacionesCarterasContabilidadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarConciliacionesCarterasContabilidad> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarConciliacionesCarterasContabilidad> entities = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		CobrarConciliacionesCarterasContabilidad entity = new CobrarConciliacionesCarterasContabilidad();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarConciliacionesCarterasContabilidad.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarConciliacionesCarterasContabilidad>((List<CobrarConciliacionesCarterasContabilidad>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarConciliacionesCarterasContabilidadsOriginal(entities);
			
			}  else {
				this.cobrarconciliacionescarterascontabilidadsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarConciliacionesCarterasContabilidadConstantesFunciones.quitarEspaciosCobrarConciliacionesCarterasContabilidads(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarConciliacionesCarterasContabilidad getEntityCobrarConciliacionesCarterasContabilidad(String strPrefijo,CobrarConciliacionesCarterasContabilidad entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGO));
			entity.setcodigo_tipo_movimiento(resultSet.getString(strPrefijo+CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGOTIPOMOVIMIENTO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+CobrarConciliacionesCarterasContabilidadConstantesFunciones.NUMEROMAYOR));
			entity.setdebito_asiento(resultSet.getDouble(strPrefijo+CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO));
			entity.setcredito_asiento(resultSet.getDouble(strPrefijo+CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO));
			entity.setdebito_cuentas(resultSet.getDouble(strPrefijo+CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS));
			entity.setcredito_cuentas(resultSet.getDouble(strPrefijo+CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarConciliacionesCarterasContabilidad getEntityCobrarConciliacionesCarterasContabilidad(String strPrefijo,CobrarConciliacionesCarterasContabilidad entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarConciliacionesCarterasContabilidad.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarConciliacionesCarterasContabilidad.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarConciliacionesCarterasContabilidadLogic.setFieldReflectionCobrarConciliacionesCarterasContabilidad(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarConciliacionesCarterasContabilidad(Field field,String strPrefijo,String sColumn,CobrarConciliacionesCarterasContabilidad entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGOTIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarConciliacionesCarterasContabilidadConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS:
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
	
	public void quitarCobrarConciliacionesCarterasContabilidadsNulos() throws Exception {				
		
		List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidadsAux= new ArrayList<CobrarConciliacionesCarterasContabilidad>();
		
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad:cobrarconciliacionescarterascontabilidads) {
			if(cobrarconciliacionescarterascontabilidad!=null) {
				cobrarconciliacionescarterascontabilidadsAux.add(cobrarconciliacionescarterascontabilidad);
			}
		}
		
		cobrarconciliacionescarterascontabilidads=cobrarconciliacionescarterascontabilidadsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarConciliacionesCarterasContabilidad> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarConciliacionesCarterasContabilidad> entities = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		CobrarConciliacionesCarterasContabilidad entity = new CobrarConciliacionesCarterasContabilidad();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarConciliacionesCarterasContabilidad>((List<CobrarConciliacionesCarterasContabilidad>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarConciliacionesCarterasContabilidadsOriginal(entities);
			
			}  else {
				this.cobrarconciliacionescarterascontabilidadsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarConciliacionesCarterasContabilidadConstantesFunciones.quitarEspaciosCobrarConciliacionesCarterasContabilidads(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarconciliacionescarterascontabilidads = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarConciliacionesCarterasContabilidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarconciliacionescarterascontabilidads=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarconciliacionescarterascontabilidads = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		  		  
        try {
			//CobrarConciliacionesCarterasContabilidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarconciliacionescarterascontabilidads=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarConciliacionesCarterasContabilidad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarConciliacionesCarterasContabilidad> entities = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		CobrarConciliacionesCarterasContabilidad entity = new CobrarConciliacionesCarterasContabilidad();		  
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
	
	public  List<CobrarConciliacionesCarterasContabilidad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarConciliacionesCarterasContabilidad> entities = new  ArrayList<CobrarConciliacionesCarterasContabilidad>();
		CobrarConciliacionesCarterasContabilidad entity = new CobrarConciliacionesCarterasContabilidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarConciliacionesCarterasContabilidad();
				
				if(conMapGenerico) {
					entity.setMapCobrarConciliacionesCarterasContabilidad( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarConciliacionesCarterasContabilidad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarConciliacionesCarterasContabilidadDataAccess.ISWITHSCHEMA);         		
					entity=CobrarConciliacionesCarterasContabilidadLogic.getEntityCobrarConciliacionesCarterasContabilidad("",entity,resultSet,listColumns);
					
					////entity.setCobrarConciliacionesCarterasContabilidadOriginal( new CobrarConciliacionesCarterasContabilidad());
					////entity.setCobrarConciliacionesCarterasContabilidadOriginal(super.getEntity("",entity.getCobrarConciliacionesCarterasContabilidadOriginal(),resultSet,CobrarConciliacionesCarterasContabilidadDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarConciliacionesCarterasContabilidadOriginal(CobrarConciliacionesCarterasContabilidadDataAccess.getEntityCobrarConciliacionesCarterasContabilidad("",entity.getCobrarConciliacionesCarterasContabilidadOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarConciliacionesCarterasContabilidad relcobrarconciliacionescarterascontabilidad)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarconciliacionescarterascontabilidad.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CuentaContable getCuentaContable(Connexion connexion,CobrarConciliacionesCarterasContabilidad relcobrarconciliacionescarterascontabilidad)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontableDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcobrarconciliacionescarterascontabilidad.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


	
	
	public void getCobrarConciliacionesCarterasContabilidadsBusquedaCobrarConciliacionesCarterasContabilidadWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//CobrarConciliacionesCarterasContabilidadLogic cobrarconciliacionescarterascontabilidadLogic=new CobrarConciliacionesCarterasContabilidadLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarConciliacionesCarterasContabilidadLogic.GetSelecSqlCobrarConciliacionesCarterasContabilidad(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cuenta_contable,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarconciliacionescarterascontabilidads=this.getCobrarConciliacionesCarterasContabilidads();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarConciliacionesCarterasContabilidadsBusquedaCobrarConciliacionesCarterasContabilidad(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//CobrarConciliacionesCarterasContabilidadLogic cobrarconciliacionescarterascontabilidadLogic=new CobrarConciliacionesCarterasContabilidadLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarConciliacionesCarterasContabilidadLogic.GetSelecSqlCobrarConciliacionesCarterasContabilidad(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cuenta_contable,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarconciliacionescarterascontabilidads=this.getCobrarConciliacionesCarterasContabilidads();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarConciliacionesCarterasContabilidad(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarConciliacionesCarterasContabilidad_Postgres.sql");
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
	
	
	public void deepLoad(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarConciliacionesCarterasContabilidadLogicAdditional.updateCobrarConciliacionesCarterasContabilidadToGet(cobrarconciliacionescarterascontabilidad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarconciliacionescarterascontabilidad.setEmpresa(cobrarconciliacionescarterascontabilidadDataAccess.getEmpresa(connexion,cobrarconciliacionescarterascontabilidad));
		cobrarconciliacionescarterascontabilidad.setCuentaContable(cobrarconciliacionescarterascontabilidadDataAccess.getCuentaContable(connexion,cobrarconciliacionescarterascontabilidad));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarconciliacionescarterascontabilidad.setEmpresa(cobrarconciliacionescarterascontabilidadDataAccess.getEmpresa(connexion,cobrarconciliacionescarterascontabilidad));
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cobrarconciliacionescarterascontabilidad.setCuentaContable(cobrarconciliacionescarterascontabilidadDataAccess.getCuentaContable(connexion,cobrarconciliacionescarterascontabilidad));
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
			cobrarconciliacionescarterascontabilidad.setEmpresa(cobrarconciliacionescarterascontabilidadDataAccess.getEmpresa(connexion,cobrarconciliacionescarterascontabilidad));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarconciliacionescarterascontabilidad.setCuentaContable(cobrarconciliacionescarterascontabilidadDataAccess.getCuentaContable(connexion,cobrarconciliacionescarterascontabilidad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarconciliacionescarterascontabilidad.setEmpresa(cobrarconciliacionescarterascontabilidadDataAccess.getEmpresa(connexion,cobrarconciliacionescarterascontabilidad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarconciliacionescarterascontabilidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		cobrarconciliacionescarterascontabilidad.setCuentaContable(cobrarconciliacionescarterascontabilidadDataAccess.getCuentaContable(connexion,cobrarconciliacionescarterascontabilidad));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cobrarconciliacionescarterascontabilidad.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarconciliacionescarterascontabilidad.setEmpresa(cobrarconciliacionescarterascontabilidadDataAccess.getEmpresa(connexion,cobrarconciliacionescarterascontabilidad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarconciliacionescarterascontabilidad.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cobrarconciliacionescarterascontabilidad.setCuentaContable(cobrarconciliacionescarterascontabilidadDataAccess.getCuentaContable(connexion,cobrarconciliacionescarterascontabilidad));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cobrarconciliacionescarterascontabilidad.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			cobrarconciliacionescarterascontabilidad.setEmpresa(cobrarconciliacionescarterascontabilidadDataAccess.getEmpresa(connexion,cobrarconciliacionescarterascontabilidad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarconciliacionescarterascontabilidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarconciliacionescarterascontabilidad.setCuentaContable(cobrarconciliacionescarterascontabilidadDataAccess.getCuentaContable(connexion,cobrarconciliacionescarterascontabilidad));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cobrarconciliacionescarterascontabilidad.getCuentaContable(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarconciliacionescarterascontabilidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarConciliacionesCarterasContabilidadConstantesFunciones.refrescarForeignKeysDescripcionesCobrarConciliacionesCarterasContabilidad(cobrarconciliacionescarterascontabilidad);
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
			this.deepLoad(this.cobrarconciliacionescarterascontabilidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarConciliacionesCarterasContabilidadConstantesFunciones.refrescarForeignKeysDescripcionesCobrarConciliacionesCarterasContabilidad(this.cobrarconciliacionescarterascontabilidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarconciliacionescarterascontabilidads!=null) {
				for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad:cobrarconciliacionescarterascontabilidads) {
					this.deepLoad(cobrarconciliacionescarterascontabilidad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarConciliacionesCarterasContabilidadConstantesFunciones.refrescarForeignKeysDescripcionesCobrarConciliacionesCarterasContabilidad(cobrarconciliacionescarterascontabilidads);
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
			if(cobrarconciliacionescarterascontabilidads!=null) {
				for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad:cobrarconciliacionescarterascontabilidads) {
					this.deepLoad(cobrarconciliacionescarterascontabilidad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarConciliacionesCarterasContabilidadConstantesFunciones.refrescarForeignKeysDescripcionesCobrarConciliacionesCarterasContabilidad(cobrarconciliacionescarterascontabilidads);
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
	
	public CobrarConciliacionesCarterasContabilidadParameterReturnGeneral procesarAccionCobrarConciliacionesCarterasContabilidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,CobrarConciliacionesCarterasContabilidadParameterReturnGeneral cobrarconciliacionescarterascontabilidadParameterGeneral)throws Exception {
		 try {	
			CobrarConciliacionesCarterasContabilidadParameterReturnGeneral cobrarconciliacionescarterascontabilidadReturnGeneral=new CobrarConciliacionesCarterasContabilidadParameterReturnGeneral();
	
			CobrarConciliacionesCarterasContabilidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarconciliacionescarterascontabilidads,cobrarconciliacionescarterascontabilidadParameterGeneral,cobrarconciliacionescarterascontabilidadReturnGeneral);
			
			return cobrarconciliacionescarterascontabilidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarConciliacionesCarterasContabilidadParameterReturnGeneral procesarAccionCobrarConciliacionesCarterasContabilidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,CobrarConciliacionesCarterasContabilidadParameterReturnGeneral cobrarconciliacionescarterascontabilidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarConciliacionesCarterasContabilidadParameterReturnGeneral cobrarconciliacionescarterascontabilidadReturnGeneral=new CobrarConciliacionesCarterasContabilidadParameterReturnGeneral();
	
			CobrarConciliacionesCarterasContabilidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarconciliacionescarterascontabilidads,cobrarconciliacionescarterascontabilidadParameterGeneral,cobrarconciliacionescarterascontabilidadReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarconciliacionescarterascontabilidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

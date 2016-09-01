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
import com.bydan.erp.cartera.util.report.CobrarClientesSuspendidosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesSuspendidosParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarClientesSuspendidosConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarClientesSuspendidos;

import com.bydan.erp.cartera.business.logic.report.CobrarClientesSuspendidosLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;














@SuppressWarnings("unused")
public class CobrarClientesSuspendidosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarClientesSuspendidosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarClientesSuspendidosLogic cobrarclientessuspendidosDataAccess; 		
	protected CobrarClientesSuspendidos cobrarclientessuspendidos;
	protected List<CobrarClientesSuspendidos> cobrarclientessuspendidoss;
	protected Object cobrarclientessuspendidosObject;	
	protected List<Object> cobrarclientessuspendidossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarClientesSuspendidosLogic()throws SQLException,Exception {
		try	{
			this.cobrarclientessuspendidoss= new ArrayList<CobrarClientesSuspendidos>();
			this.cobrarclientessuspendidos= new CobrarClientesSuspendidos();
			this.cobrarclientessuspendidosObject=new Object();
			this.cobrarclientessuspendidossObject=new ArrayList<Object>();
			
			this.cobrarclientessuspendidosDataAccess=this;
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
			this.cobrarclientessuspendidosDataAccess.setConnexionType(this.connexionType);
			this.cobrarclientessuspendidosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclientessuspendidosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarClientesSuspendidosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarclientessuspendidoss= new ArrayList<CobrarClientesSuspendidos>();
			this.cobrarclientessuspendidos= new CobrarClientesSuspendidos();
			this.cobrarclientessuspendidosObject=new Object();
			this.cobrarclientessuspendidossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarclientessuspendidosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarclientessuspendidosDataAccess.setConnexionType(this.connexionType);
			this.cobrarclientessuspendidosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclientessuspendidosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarClientesSuspendidos getCobrarClientesSuspendidos() throws Exception {	
		CobrarClientesSuspendidosLogicAdditional.checkCobrarClientesSuspendidosToGet(cobrarclientessuspendidos,this.datosCliente,this.arrDatoGeneral);
		CobrarClientesSuspendidosLogicAdditional.updateCobrarClientesSuspendidosToGet(cobrarclientessuspendidos,this.arrDatoGeneral);
		
		return cobrarclientessuspendidos;
	}
		
	public void setCobrarClientesSuspendidos(CobrarClientesSuspendidos newCobrarClientesSuspendidos) {
		this.cobrarclientessuspendidos = newCobrarClientesSuspendidos;
	}
	
	public List<CobrarClientesSuspendidos> getCobrarClientesSuspendidoss() throws Exception {		
		this.quitarCobrarClientesSuspendidossNulos();
		
		CobrarClientesSuspendidosLogicAdditional.checkCobrarClientesSuspendidosToGets(cobrarclientessuspendidoss,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarClientesSuspendidos cobrarclientessuspendidosLocal: cobrarclientessuspendidoss ) {
			CobrarClientesSuspendidosLogicAdditional.updateCobrarClientesSuspendidosToGet(cobrarclientessuspendidosLocal,this.arrDatoGeneral);
		}
		
		return cobrarclientessuspendidoss;
	}
	
	public void setCobrarClientesSuspendidoss(List<CobrarClientesSuspendidos> newCobrarClientesSuspendidoss) {
		this.cobrarclientessuspendidoss = newCobrarClientesSuspendidoss;
	}
	
	public Object getCobrarClientesSuspendidosObject() {	
		//this.cobrarclientessuspendidosObject=this.cobrarclientessuspendidosDataAccess.getEntityObject();
		return this.cobrarclientessuspendidosObject;
	}
		
	public void setCobrarClientesSuspendidosObject(Object newCobrarClientesSuspendidosObject) {
		this.cobrarclientessuspendidosObject = newCobrarClientesSuspendidosObject;
	}
	
	public List<Object> getCobrarClientesSuspendidossObject() {		
		//this.cobrarclientessuspendidossObject=this.cobrarclientessuspendidosDataAccess.getEntitiesObject();
		return this.cobrarclientessuspendidossObject;
	}
		
	public void setCobrarClientesSuspendidossObject(List<Object> newCobrarClientesSuspendidossObject) {
		this.cobrarclientessuspendidossObject = newCobrarClientesSuspendidossObject;
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
		cobrarclientessuspendidoss = new  ArrayList<CobrarClientesSuspendidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesSuspendidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientessuspendidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarclientessuspendidoss = new  ArrayList<CobrarClientesSuspendidos>();
		  		  
        try {
			//CobrarClientesSuspendidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientessuspendidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarclientessuspendidoss = new  ArrayList<CobrarClientesSuspendidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesSuspendidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientessuspendidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclientessuspendidoss = new  ArrayList<CobrarClientesSuspendidos>();
		  		  
        try {
			//CobrarClientesSuspendidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientessuspendidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarclientessuspendidoss = new  ArrayList<CobrarClientesSuspendidos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesSuspendidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientessuspendidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclientessuspendidoss = new  ArrayList<CobrarClientesSuspendidos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarClientesSuspendidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientessuspendidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarClientesSuspendidos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesSuspendidos> entities = new  ArrayList<CobrarClientesSuspendidos>();
		CobrarClientesSuspendidos entity = new CobrarClientesSuspendidos();		  
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
	
	public  List<CobrarClientesSuspendidos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesSuspendidos> entities = new  ArrayList<CobrarClientesSuspendidos>();
		CobrarClientesSuspendidos entity = new CobrarClientesSuspendidos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesSuspendidos();
				
				
      	    	entity=CobrarClientesSuspendidosLogic.getEntityCobrarClientesSuspendidos("",entity,resultSet);
      	    	
				//entity.setCobrarClientesSuspendidosOriginal( new CobrarClientesSuspendidos());
      	    	//entity.setCobrarClientesSuspendidosOriginal(super.getEntity("",entity.getCobrarClientesSuspendidosOriginal(),resultSet,CobrarClientesSuspendidosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarClientesSuspendidosOriginal(CobrarClientesSuspendidosDataAccess.getEntityCobrarClientesSuspendidos("",entity.getCobrarClientesSuspendidosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarClientesSuspendidos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesSuspendidos> entities = new  ArrayList<CobrarClientesSuspendidos>();
		CobrarClientesSuspendidos entity = new CobrarClientesSuspendidos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarClientesSuspendidos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesSuspendidos>((List<CobrarClientesSuspendidos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesSuspendidossOriginal(entities);
			
			}  else {
				this.cobrarclientessuspendidossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesSuspendidosConstantesFunciones.quitarEspaciosCobrarClientesSuspendidoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarClientesSuspendidos getEntityCobrarClientesSuspendidos(String strPrefijo,CobrarClientesSuspendidos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_ciudad(resultSet.getString(strPrefijo+CobrarClientesSuspendidosConstantesFunciones.NOMBRECIUDAD));
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarClientesSuspendidosConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMPLETO));
			entity.setnombre_comercial(resultSet.getString(strPrefijo+CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMERCIAL));
			entity.setruc(resultSet.getString(strPrefijo+CobrarClientesSuspendidosConstantesFunciones.RUC));
			entity.setdetalle_estado(resultSet.getString(strPrefijo+CobrarClientesSuspendidosConstantesFunciones.DETALLEESTADO));
			entity.setdireccion_direccion(resultSet.getString(strPrefijo+CobrarClientesSuspendidosConstantesFunciones.DIRECCIONDIRECCION));
			entity.settelefono_telefono(resultSet.getString(strPrefijo+CobrarClientesSuspendidosConstantesFunciones.TELEFONOTELEFONO));
			entity.setsaldo(resultSet.getDouble(strPrefijo+CobrarClientesSuspendidosConstantesFunciones.SALDO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarClientesSuspendidos getEntityCobrarClientesSuspendidos(String strPrefijo,CobrarClientesSuspendidos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarClientesSuspendidos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarClientesSuspendidos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarClientesSuspendidosLogic.setFieldReflectionCobrarClientesSuspendidos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarClientesSuspendidos(Field field,String strPrefijo,String sColumn,CobrarClientesSuspendidos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarClientesSuspendidosConstantesFunciones.NOMBRECIUDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesSuspendidosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMERCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesSuspendidosConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesSuspendidosConstantesFunciones.DETALLEESTADO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesSuspendidosConstantesFunciones.DIRECCIONDIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesSuspendidosConstantesFunciones.TELEFONOTELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesSuspendidosConstantesFunciones.SALDO:
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
	
	public void quitarCobrarClientesSuspendidossNulos() throws Exception {				
		
		List<CobrarClientesSuspendidos> cobrarclientessuspendidossAux= new ArrayList<CobrarClientesSuspendidos>();
		
		for(CobrarClientesSuspendidos cobrarclientessuspendidos:cobrarclientessuspendidoss) {
			if(cobrarclientessuspendidos!=null) {
				cobrarclientessuspendidossAux.add(cobrarclientessuspendidos);
			}
		}
		
		cobrarclientessuspendidoss=cobrarclientessuspendidossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarClientesSuspendidos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesSuspendidos> entities = new  ArrayList<CobrarClientesSuspendidos>();
		CobrarClientesSuspendidos entity = new CobrarClientesSuspendidos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesSuspendidos>((List<CobrarClientesSuspendidos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesSuspendidossOriginal(entities);
			
			}  else {
				this.cobrarclientessuspendidossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesSuspendidosConstantesFunciones.quitarEspaciosCobrarClientesSuspendidoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarclientessuspendidoss = new  ArrayList<CobrarClientesSuspendidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesSuspendidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientessuspendidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarclientessuspendidoss = new  ArrayList<CobrarClientesSuspendidos>();
		  		  
        try {
			//CobrarClientesSuspendidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientessuspendidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarClientesSuspendidos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesSuspendidos> entities = new  ArrayList<CobrarClientesSuspendidos>();
		CobrarClientesSuspendidos entity = new CobrarClientesSuspendidos();		  
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
	
	public  List<CobrarClientesSuspendidos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesSuspendidos> entities = new  ArrayList<CobrarClientesSuspendidos>();
		CobrarClientesSuspendidos entity = new CobrarClientesSuspendidos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesSuspendidos();
				
				if(conMapGenerico) {
					entity.setMapCobrarClientesSuspendidos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarClientesSuspendidos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarClientesSuspendidosDataAccess.ISWITHSCHEMA);         		
					entity=CobrarClientesSuspendidosLogic.getEntityCobrarClientesSuspendidos("",entity,resultSet,listColumns);
					
					////entity.setCobrarClientesSuspendidosOriginal( new CobrarClientesSuspendidos());
					////entity.setCobrarClientesSuspendidosOriginal(super.getEntity("",entity.getCobrarClientesSuspendidosOriginal(),resultSet,CobrarClientesSuspendidosDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarClientesSuspendidosOriginal(CobrarClientesSuspendidosDataAccess.getEntityCobrarClientesSuspendidos("",entity.getCobrarClientesSuspendidosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	public void getCobrarClientesSuspendidossBusquedaCobrarClientesSuspendidosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//CobrarClientesSuspendidosLogic cobrarclientessuspendidosLogic=new CobrarClientesSuspendidosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesSuspendidosLogic.GetSelecSqlCobrarClientesSuspendidos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclientessuspendidoss=this.getCobrarClientesSuspendidoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarClientesSuspendidossBusquedaCobrarClientesSuspendidos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//CobrarClientesSuspendidosLogic cobrarclientessuspendidosLogic=new CobrarClientesSuspendidosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesSuspendidosLogic.GetSelecSqlCobrarClientesSuspendidos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclientessuspendidoss=this.getCobrarClientesSuspendidoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarClientesSuspendidos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarClientesSuspendidos_Postgres.sql");
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
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" c.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
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
	
	
	public void deepLoad(CobrarClientesSuspendidos cobrarclientessuspendidos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			CobrarClientesSuspendidosLogicAdditional.updateCobrarClientesSuspendidosToGet(cobrarclientessuspendidos,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			this.deepLoad(cobrarclientessuspendidos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesSuspendidosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesSuspendidos(cobrarclientessuspendidos);
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
			this.deepLoad(this.cobrarclientessuspendidos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesSuspendidosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesSuspendidos(this.cobrarclientessuspendidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarclientessuspendidoss!=null) {
				for(CobrarClientesSuspendidos cobrarclientessuspendidos:cobrarclientessuspendidoss) {
					this.deepLoad(cobrarclientessuspendidos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesSuspendidosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesSuspendidos(cobrarclientessuspendidoss);
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
			if(cobrarclientessuspendidoss!=null) {
				for(CobrarClientesSuspendidos cobrarclientessuspendidos:cobrarclientessuspendidoss) {
					this.deepLoad(cobrarclientessuspendidos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesSuspendidosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesSuspendidos(cobrarclientessuspendidoss);
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
	
	public CobrarClientesSuspendidosParameterReturnGeneral procesarAccionCobrarClientesSuspendidoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesSuspendidos> cobrarclientessuspendidoss,CobrarClientesSuspendidosParameterReturnGeneral cobrarclientessuspendidosParameterGeneral)throws Exception {
		 try {	
			CobrarClientesSuspendidosParameterReturnGeneral cobrarclientessuspendidosReturnGeneral=new CobrarClientesSuspendidosParameterReturnGeneral();
	
			CobrarClientesSuspendidosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclientessuspendidoss,cobrarclientessuspendidosParameterGeneral,cobrarclientessuspendidosReturnGeneral);
			
			return cobrarclientessuspendidosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarClientesSuspendidosParameterReturnGeneral procesarAccionCobrarClientesSuspendidossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesSuspendidos> cobrarclientessuspendidoss,CobrarClientesSuspendidosParameterReturnGeneral cobrarclientessuspendidosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarClientesSuspendidosParameterReturnGeneral cobrarclientessuspendidosReturnGeneral=new CobrarClientesSuspendidosParameterReturnGeneral();
	
			CobrarClientesSuspendidosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclientessuspendidoss,cobrarclientessuspendidosParameterGeneral,cobrarclientessuspendidosReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarclientessuspendidosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

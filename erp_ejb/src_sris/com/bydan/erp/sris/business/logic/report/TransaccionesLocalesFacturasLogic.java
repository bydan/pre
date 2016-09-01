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
package com.bydan.erp.sris.business.logic.report;

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

import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.resources.general.AuxiliarGeneral;
import com.bydan.erp.sris.util.report.TransaccionesLocalesFacturasParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.TransaccionesLocalesFacturasParameterGeneral;
import com.bydan.erp.sris.util.report.TransaccionesLocalesFacturasConstantesFunciones;
import com.bydan.erp.sris.business.entity.report.TransaccionesLocalesFacturas;

import com.bydan.erp.sris.business.logic.report.TransaccionesLocalesFacturasLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class TransaccionesLocalesFacturasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(TransaccionesLocalesFacturasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected TransaccionesLocalesFacturasLogic transaccioneslocalesfacturasDataAccess; 		
	protected TransaccionesLocalesFacturas transaccioneslocalesfacturas;
	protected List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass;
	protected Object transaccioneslocalesfacturasObject;	
	protected List<Object> transaccioneslocalesfacturassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  TransaccionesLocalesFacturasLogic()throws SQLException,Exception {
		try	{
			this.transaccioneslocalesfacturass= new ArrayList<TransaccionesLocalesFacturas>();
			this.transaccioneslocalesfacturas= new TransaccionesLocalesFacturas();
			this.transaccioneslocalesfacturasObject=new Object();
			this.transaccioneslocalesfacturassObject=new ArrayList<Object>();
			
			this.transaccioneslocalesfacturasDataAccess=this;
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
			this.transaccioneslocalesfacturasDataAccess.setConnexionType(this.connexionType);
			this.transaccioneslocalesfacturasDataAccess.setParameterDbType(this.parameterDbType);
			this.transaccioneslocalesfacturasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TransaccionesLocalesFacturasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.transaccioneslocalesfacturass= new ArrayList<TransaccionesLocalesFacturas>();
			this.transaccioneslocalesfacturas= new TransaccionesLocalesFacturas();
			this.transaccioneslocalesfacturasObject=new Object();
			this.transaccioneslocalesfacturassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.transaccioneslocalesfacturasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.transaccioneslocalesfacturasDataAccess.setConnexionType(this.connexionType);
			this.transaccioneslocalesfacturasDataAccess.setParameterDbType(this.parameterDbType);
			this.transaccioneslocalesfacturasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TransaccionesLocalesFacturas getTransaccionesLocalesFacturas() throws Exception {	
		TransaccionesLocalesFacturasLogicAdditional.checkTransaccionesLocalesFacturasToGet(transaccioneslocalesfacturas,this.datosCliente,this.arrDatoGeneral);
		TransaccionesLocalesFacturasLogicAdditional.updateTransaccionesLocalesFacturasToGet(transaccioneslocalesfacturas,this.arrDatoGeneral);
		
		return transaccioneslocalesfacturas;
	}
		
	public void setTransaccionesLocalesFacturas(TransaccionesLocalesFacturas newTransaccionesLocalesFacturas) {
		this.transaccioneslocalesfacturas = newTransaccionesLocalesFacturas;
	}
	
	public List<TransaccionesLocalesFacturas> getTransaccionesLocalesFacturass() throws Exception {		
		this.quitarTransaccionesLocalesFacturassNulos();
		
		TransaccionesLocalesFacturasLogicAdditional.checkTransaccionesLocalesFacturasToGets(transaccioneslocalesfacturass,this.datosCliente,this.arrDatoGeneral);
		
		for (TransaccionesLocalesFacturas transaccioneslocalesfacturasLocal: transaccioneslocalesfacturass ) {
			TransaccionesLocalesFacturasLogicAdditional.updateTransaccionesLocalesFacturasToGet(transaccioneslocalesfacturasLocal,this.arrDatoGeneral);
		}
		
		return transaccioneslocalesfacturass;
	}
	
	public void setTransaccionesLocalesFacturass(List<TransaccionesLocalesFacturas> newTransaccionesLocalesFacturass) {
		this.transaccioneslocalesfacturass = newTransaccionesLocalesFacturass;
	}
	
	public Object getTransaccionesLocalesFacturasObject() {	
		//this.transaccioneslocalesfacturasObject=this.transaccioneslocalesfacturasDataAccess.getEntityObject();
		return this.transaccioneslocalesfacturasObject;
	}
		
	public void setTransaccionesLocalesFacturasObject(Object newTransaccionesLocalesFacturasObject) {
		this.transaccioneslocalesfacturasObject = newTransaccionesLocalesFacturasObject;
	}
	
	public List<Object> getTransaccionesLocalesFacturassObject() {		
		//this.transaccioneslocalesfacturassObject=this.transaccioneslocalesfacturasDataAccess.getEntitiesObject();
		return this.transaccioneslocalesfacturassObject;
	}
		
	public void setTransaccionesLocalesFacturassObject(List<Object> newTransaccionesLocalesFacturassObject) {
		this.transaccioneslocalesfacturassObject = newTransaccionesLocalesFacturassObject;
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
		transaccioneslocalesfacturass = new  ArrayList<TransaccionesLocalesFacturas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TransaccionesLocalesFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioneslocalesfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		transaccioneslocalesfacturass = new  ArrayList<TransaccionesLocalesFacturas>();
		  		  
        try {
			//TransaccionesLocalesFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioneslocalesfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccioneslocalesfacturass = new  ArrayList<TransaccionesLocalesFacturas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TransaccionesLocalesFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioneslocalesfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		transaccioneslocalesfacturass = new  ArrayList<TransaccionesLocalesFacturas>();
		  		  
        try {
			//TransaccionesLocalesFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioneslocalesfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		transaccioneslocalesfacturass = new  ArrayList<TransaccionesLocalesFacturas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TransaccionesLocalesFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioneslocalesfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		transaccioneslocalesfacturass = new  ArrayList<TransaccionesLocalesFacturas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//TransaccionesLocalesFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioneslocalesfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<TransaccionesLocalesFacturas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionesLocalesFacturas> entities = new  ArrayList<TransaccionesLocalesFacturas>();
		TransaccionesLocalesFacturas entity = new TransaccionesLocalesFacturas();		  
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
	
	public  List<TransaccionesLocalesFacturas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionesLocalesFacturas> entities = new  ArrayList<TransaccionesLocalesFacturas>();
		TransaccionesLocalesFacturas entity = new TransaccionesLocalesFacturas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionesLocalesFacturas();
				
				
      	    	entity=TransaccionesLocalesFacturasLogic.getEntityTransaccionesLocalesFacturas("",entity,resultSet);
      	    	
				//entity.setTransaccionesLocalesFacturasOriginal( new TransaccionesLocalesFacturas());
      	    	//entity.setTransaccionesLocalesFacturasOriginal(super.getEntity("",entity.getTransaccionesLocalesFacturasOriginal(),resultSet,TransaccionesLocalesFacturasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionesLocalesFacturasOriginal(TransaccionesLocalesFacturasDataAccess.getEntityTransaccionesLocalesFacturas("",entity.getTransaccionesLocalesFacturasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<TransaccionesLocalesFacturas> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionesLocalesFacturas> entities = new  ArrayList<TransaccionesLocalesFacturas>();
		TransaccionesLocalesFacturas entity = new TransaccionesLocalesFacturas();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,TransaccionesLocalesFacturas.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<TransaccionesLocalesFacturas>((List<TransaccionesLocalesFacturas>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setTransaccionesLocalesFacturassOriginal(entities);
			
			}  else {
				this.transaccioneslocalesfacturassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//TransaccionesLocalesFacturasConstantesFunciones.quitarEspaciosTransaccionesLocalesFacturass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static TransaccionesLocalesFacturas getEntityTransaccionesLocalesFacturas(String strPrefijo,TransaccionesLocalesFacturas entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+TransaccionesLocalesFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.settotal_iva(resultSet.getDouble(strPrefijo+TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA));
			entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA));
			entity.settotal_descuento(resultSet.getDouble(strPrefijo+TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO));
			entity.settotal(resultSet.getDouble(strPrefijo+TransaccionesLocalesFacturasConstantesFunciones.TOTAL));
			entity.setiva(resultSet.getDouble(strPrefijo+TransaccionesLocalesFacturasConstantesFunciones.IVA));
			entity.setruc_cliente(resultSet.getString(strPrefijo+TransaccionesLocalesFacturasConstantesFunciones.RUCCLIENTE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TransaccionesLocalesFacturas getEntityTransaccionesLocalesFacturas(String strPrefijo,TransaccionesLocalesFacturas entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = TransaccionesLocalesFacturas.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = TransaccionesLocalesFacturas.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				TransaccionesLocalesFacturasLogic.setFieldReflectionTransaccionesLocalesFacturas(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTransaccionesLocalesFacturas(Field field,String strPrefijo,String sColumn,TransaccionesLocalesFacturas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TransaccionesLocalesFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionesLocalesFacturasConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionesLocalesFacturasConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionesLocalesFacturasConstantesFunciones.RUCCLIENTE:
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
	
	public void quitarTransaccionesLocalesFacturassNulos() throws Exception {				
		
		List<TransaccionesLocalesFacturas> transaccioneslocalesfacturassAux= new ArrayList<TransaccionesLocalesFacturas>();
		
		for(TransaccionesLocalesFacturas transaccioneslocalesfacturas:transaccioneslocalesfacturass) {
			if(transaccioneslocalesfacturas!=null) {
				transaccioneslocalesfacturassAux.add(transaccioneslocalesfacturas);
			}
		}
		
		transaccioneslocalesfacturass=transaccioneslocalesfacturassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<TransaccionesLocalesFacturas> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionesLocalesFacturas> entities = new  ArrayList<TransaccionesLocalesFacturas>();
		TransaccionesLocalesFacturas entity = new TransaccionesLocalesFacturas();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<TransaccionesLocalesFacturas>((List<TransaccionesLocalesFacturas>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setTransaccionesLocalesFacturassOriginal(entities);
			
			}  else {
				this.transaccioneslocalesfacturassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//TransaccionesLocalesFacturasConstantesFunciones.quitarEspaciosTransaccionesLocalesFacturass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		transaccioneslocalesfacturass = new  ArrayList<TransaccionesLocalesFacturas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TransaccionesLocalesFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioneslocalesfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		transaccioneslocalesfacturass = new  ArrayList<TransaccionesLocalesFacturas>();
		  		  
        try {
			//TransaccionesLocalesFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioneslocalesfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<TransaccionesLocalesFacturas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransaccionesLocalesFacturas> entities = new  ArrayList<TransaccionesLocalesFacturas>();
		TransaccionesLocalesFacturas entity = new TransaccionesLocalesFacturas();		  
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
	
	public  List<TransaccionesLocalesFacturas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransaccionesLocalesFacturas> entities = new  ArrayList<TransaccionesLocalesFacturas>();
		TransaccionesLocalesFacturas entity = new TransaccionesLocalesFacturas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionesLocalesFacturas();
				
				if(conMapGenerico) {
					entity.setMapTransaccionesLocalesFacturas( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapTransaccionesLocalesFacturas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransaccionesLocalesFacturasDataAccess.ISWITHSCHEMA);         		
					entity=TransaccionesLocalesFacturasLogic.getEntityTransaccionesLocalesFacturas("",entity,resultSet,listColumns);
					
					////entity.setTransaccionesLocalesFacturasOriginal( new TransaccionesLocalesFacturas());
					////entity.setTransaccionesLocalesFacturasOriginal(super.getEntity("",entity.getTransaccionesLocalesFacturasOriginal(),resultSet,TransaccionesLocalesFacturasDataAccess.ISWITHSCHEMA));         		
					////entity.setTransaccionesLocalesFacturasOriginal(TransaccionesLocalesFacturasDataAccess.getEntityTransaccionesLocalesFacturas("",entity.getTransaccionesLocalesFacturasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,TransaccionesLocalesFacturas reltransaccioneslocalesfacturas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reltransaccioneslocalesfacturas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,TransaccionesLocalesFacturas reltransaccioneslocalesfacturas)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reltransaccioneslocalesfacturas.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}


	
	
	public void getTransaccionesLocalesFacturassBusquedaTransaccionesLocalesFacturasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//TransaccionesLocalesFacturasLogic transaccioneslocalesfacturasLogic=new TransaccionesLocalesFacturasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=TransaccionesLocalesFacturasLogic.GetSelecSqlTransaccionesLocalesFacturas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.transaccioneslocalesfacturass=this.getTransaccionesLocalesFacturass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getTransaccionesLocalesFacturassBusquedaTransaccionesLocalesFacturas(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//TransaccionesLocalesFacturasLogic transaccioneslocalesfacturasLogic=new TransaccionesLocalesFacturasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=TransaccionesLocalesFacturasLogic.GetSelecSqlTransaccionesLocalesFacturas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.transaccioneslocalesfacturass=this.getTransaccionesLocalesFacturass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlTransaccionesLocalesFacturas(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("TransaccionesLocalesFacturas_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" f.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" f.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_ejercicio = "+id_ejercicio.toString();
					existeWhere=true;
				}

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
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
	
	
	public void deepLoad(TransaccionesLocalesFacturas transaccioneslocalesfacturas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TransaccionesLocalesFacturasLogicAdditional.updateTransaccionesLocalesFacturasToGet(transaccioneslocalesfacturas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccioneslocalesfacturas.setEmpresa(transaccioneslocalesfacturasDataAccess.getEmpresa(connexion,transaccioneslocalesfacturas));
		transaccioneslocalesfacturas.setEjercicio(transaccioneslocalesfacturasDataAccess.getEjercicio(connexion,transaccioneslocalesfacturas));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transaccioneslocalesfacturas.setEmpresa(transaccioneslocalesfacturasDataAccess.getEmpresa(connexion,transaccioneslocalesfacturas));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				transaccioneslocalesfacturas.setEjercicio(transaccioneslocalesfacturasDataAccess.getEjercicio(connexion,transaccioneslocalesfacturas));
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
			transaccioneslocalesfacturas.setEmpresa(transaccioneslocalesfacturasDataAccess.getEmpresa(connexion,transaccioneslocalesfacturas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioneslocalesfacturas.setEjercicio(transaccioneslocalesfacturasDataAccess.getEjercicio(connexion,transaccioneslocalesfacturas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccioneslocalesfacturas.setEmpresa(transaccioneslocalesfacturasDataAccess.getEmpresa(connexion,transaccioneslocalesfacturas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transaccioneslocalesfacturas.getEmpresa(),isDeep,deepLoadType,clases);
				
		transaccioneslocalesfacturas.setEjercicio(transaccioneslocalesfacturasDataAccess.getEjercicio(connexion,transaccioneslocalesfacturas));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(transaccioneslocalesfacturas.getEjercicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transaccioneslocalesfacturas.setEmpresa(transaccioneslocalesfacturasDataAccess.getEmpresa(connexion,transaccioneslocalesfacturas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(transaccioneslocalesfacturas.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				transaccioneslocalesfacturas.setEjercicio(transaccioneslocalesfacturasDataAccess.getEjercicio(connexion,transaccioneslocalesfacturas));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(transaccioneslocalesfacturas.getEjercicio(),isDeep,deepLoadType,clases);				
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
			transaccioneslocalesfacturas.setEmpresa(transaccioneslocalesfacturasDataAccess.getEmpresa(connexion,transaccioneslocalesfacturas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(transaccioneslocalesfacturas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioneslocalesfacturas.setEjercicio(transaccioneslocalesfacturasDataAccess.getEjercicio(connexion,transaccioneslocalesfacturas));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(transaccioneslocalesfacturas.getEjercicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(transaccioneslocalesfacturas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionesLocalesFacturasConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionesLocalesFacturas(transaccioneslocalesfacturas);
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
			this.deepLoad(this.transaccioneslocalesfacturas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionesLocalesFacturasConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionesLocalesFacturas(this.transaccioneslocalesfacturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(transaccioneslocalesfacturass!=null) {
				for(TransaccionesLocalesFacturas transaccioneslocalesfacturas:transaccioneslocalesfacturass) {
					this.deepLoad(transaccioneslocalesfacturas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TransaccionesLocalesFacturasConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionesLocalesFacturas(transaccioneslocalesfacturass);
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
			if(transaccioneslocalesfacturass!=null) {
				for(TransaccionesLocalesFacturas transaccioneslocalesfacturas:transaccioneslocalesfacturass) {
					this.deepLoad(transaccioneslocalesfacturas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TransaccionesLocalesFacturasConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionesLocalesFacturas(transaccioneslocalesfacturass);
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
	
	public TransaccionesLocalesFacturasParameterReturnGeneral procesarAccionTransaccionesLocalesFacturass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass,TransaccionesLocalesFacturasParameterReturnGeneral transaccioneslocalesfacturasParameterGeneral)throws Exception {
		 try {	
			TransaccionesLocalesFacturasParameterReturnGeneral transaccioneslocalesfacturasReturnGeneral=new TransaccionesLocalesFacturasParameterReturnGeneral();
	
			TransaccionesLocalesFacturasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccioneslocalesfacturass,transaccioneslocalesfacturasParameterGeneral,transaccioneslocalesfacturasReturnGeneral);
			
			return transaccioneslocalesfacturasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionesLocalesFacturasParameterReturnGeneral procesarAccionTransaccionesLocalesFacturassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass,TransaccionesLocalesFacturasParameterReturnGeneral transaccioneslocalesfacturasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			TransaccionesLocalesFacturasParameterReturnGeneral transaccioneslocalesfacturasReturnGeneral=new TransaccionesLocalesFacturasParameterReturnGeneral();
	
			TransaccionesLocalesFacturasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccioneslocalesfacturass,transaccioneslocalesfacturasParameterGeneral,transaccioneslocalesfacturasReturnGeneral);
			
			this.connexion.commit();
			
			return transaccioneslocalesfacturasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

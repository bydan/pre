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
import com.bydan.erp.sris.util.report.SriFacturasProveedoresParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriFacturasProveedoresParameterGeneral;
import com.bydan.erp.sris.util.report.SriFacturasProveedoresConstantesFunciones;
import com.bydan.erp.sris.business.entity.report.SriFacturasProveedores;

import com.bydan.erp.sris.business.logic.report.SriFacturasProveedoresLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;






@SuppressWarnings("unused")
public class SriFacturasProveedoresLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(SriFacturasProveedoresLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected SriFacturasProveedoresLogic srifacturasproveedoresDataAccess; 		
	protected SriFacturasProveedores srifacturasproveedores;
	protected List<SriFacturasProveedores> srifacturasproveedoress;
	protected Object srifacturasproveedoresObject;	
	protected List<Object> srifacturasproveedoressObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  SriFacturasProveedoresLogic()throws SQLException,Exception {
		try	{
			this.srifacturasproveedoress= new ArrayList<SriFacturasProveedores>();
			this.srifacturasproveedores= new SriFacturasProveedores();
			this.srifacturasproveedoresObject=new Object();
			this.srifacturasproveedoressObject=new ArrayList<Object>();
			
			this.srifacturasproveedoresDataAccess=this;
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
			this.srifacturasproveedoresDataAccess.setConnexionType(this.connexionType);
			this.srifacturasproveedoresDataAccess.setParameterDbType(this.parameterDbType);
			this.srifacturasproveedoresDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SriFacturasProveedoresLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.srifacturasproveedoress= new ArrayList<SriFacturasProveedores>();
			this.srifacturasproveedores= new SriFacturasProveedores();
			this.srifacturasproveedoresObject=new Object();
			this.srifacturasproveedoressObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.srifacturasproveedoresDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.srifacturasproveedoresDataAccess.setConnexionType(this.connexionType);
			this.srifacturasproveedoresDataAccess.setParameterDbType(this.parameterDbType);
			this.srifacturasproveedoresDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SriFacturasProveedores getSriFacturasProveedores() throws Exception {	
		SriFacturasProveedoresLogicAdditional.checkSriFacturasProveedoresToGet(srifacturasproveedores,this.datosCliente,this.arrDatoGeneral);
		SriFacturasProveedoresLogicAdditional.updateSriFacturasProveedoresToGet(srifacturasproveedores,this.arrDatoGeneral);
		
		return srifacturasproveedores;
	}
		
	public void setSriFacturasProveedores(SriFacturasProveedores newSriFacturasProveedores) {
		this.srifacturasproveedores = newSriFacturasProveedores;
	}
	
	public List<SriFacturasProveedores> getSriFacturasProveedoress() throws Exception {		
		this.quitarSriFacturasProveedoressNulos();
		
		SriFacturasProveedoresLogicAdditional.checkSriFacturasProveedoresToGets(srifacturasproveedoress,this.datosCliente,this.arrDatoGeneral);
		
		for (SriFacturasProveedores srifacturasproveedoresLocal: srifacturasproveedoress ) {
			SriFacturasProveedoresLogicAdditional.updateSriFacturasProveedoresToGet(srifacturasproveedoresLocal,this.arrDatoGeneral);
		}
		
		return srifacturasproveedoress;
	}
	
	public void setSriFacturasProveedoress(List<SriFacturasProveedores> newSriFacturasProveedoress) {
		this.srifacturasproveedoress = newSriFacturasProveedoress;
	}
	
	public Object getSriFacturasProveedoresObject() {	
		//this.srifacturasproveedoresObject=this.srifacturasproveedoresDataAccess.getEntityObject();
		return this.srifacturasproveedoresObject;
	}
		
	public void setSriFacturasProveedoresObject(Object newSriFacturasProveedoresObject) {
		this.srifacturasproveedoresObject = newSriFacturasProveedoresObject;
	}
	
	public List<Object> getSriFacturasProveedoressObject() {		
		//this.srifacturasproveedoressObject=this.srifacturasproveedoresDataAccess.getEntitiesObject();
		return this.srifacturasproveedoressObject;
	}
		
	public void setSriFacturasProveedoressObject(List<Object> newSriFacturasProveedoressObject) {
		this.srifacturasproveedoressObject = newSriFacturasProveedoressObject;
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
		srifacturasproveedoress = new  ArrayList<SriFacturasProveedores>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriFacturasProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		srifacturasproveedoress = new  ArrayList<SriFacturasProveedores>();
		  		  
        try {
			//SriFacturasProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		srifacturasproveedoress = new  ArrayList<SriFacturasProveedores>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriFacturasProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		srifacturasproveedoress = new  ArrayList<SriFacturasProveedores>();
		  		  
        try {
			//SriFacturasProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		srifacturasproveedoress = new  ArrayList<SriFacturasProveedores>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriFacturasProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		srifacturasproveedoress = new  ArrayList<SriFacturasProveedores>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//SriFacturasProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<SriFacturasProveedores> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriFacturasProveedores> entities = new  ArrayList<SriFacturasProveedores>();
		SriFacturasProveedores entity = new SriFacturasProveedores();		  
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
	
	public  List<SriFacturasProveedores> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriFacturasProveedores> entities = new  ArrayList<SriFacturasProveedores>();
		SriFacturasProveedores entity = new SriFacturasProveedores();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriFacturasProveedores();
				
				
      	    	entity=SriFacturasProveedoresLogic.getEntitySriFacturasProveedores("",entity,resultSet);
      	    	
				//entity.setSriFacturasProveedoresOriginal( new SriFacturasProveedores());
      	    	//entity.setSriFacturasProveedoresOriginal(super.getEntity("",entity.getSriFacturasProveedoresOriginal(),resultSet,SriFacturasProveedoresDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriFacturasProveedoresOriginal(SriFacturasProveedoresDataAccess.getEntitySriFacturasProveedores("",entity.getSriFacturasProveedoresOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<SriFacturasProveedores> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriFacturasProveedores> entities = new  ArrayList<SriFacturasProveedores>();
		SriFacturasProveedores entity = new SriFacturasProveedores();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,SriFacturasProveedores.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriFacturasProveedores>((List<SriFacturasProveedores>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriFacturasProveedoressOriginal(entities);
			
			}  else {
				this.srifacturasproveedoressObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriFacturasProveedoresConstantesFunciones.quitarEspaciosSriFacturasProveedoress(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static SriFacturasProveedores getEntitySriFacturasProveedores(String strPrefijo,SriFacturasProveedores entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setidentificacion(resultSet.getString(strPrefijo+SriFacturasProveedoresConstantesFunciones.IDENTIFICACION));
			entity.setnombre(resultSet.getString(strPrefijo+SriFacturasProveedoresConstantesFunciones.NOMBRE));
			entity.setruc(resultSet.getString(strPrefijo+SriFacturasProveedoresConstantesFunciones.RUC));
			entity.setnombre_modulo(resultSet.getString(strPrefijo+SriFacturasProveedoresConstantesFunciones.NOMBREMODULO));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+SriFacturasProveedoresConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setnombre_transaccion(resultSet.getString(strPrefijo+SriFacturasProveedoresConstantesFunciones.NOMBRETRANSACCION));
			entity.setcodigo_asiento_contable(resultSet.getString(strPrefijo+SriFacturasProveedoresConstantesFunciones.CODIGOASIENTOCONTABLE));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+SriFacturasProveedoresConstantesFunciones.FECHAEMISION).getTime()));
			entity.setnumero_factura(resultSet.getString(strPrefijo+SriFacturasProveedoresConstantesFunciones.NUMEROFACTURA));
			entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SriFacturasProveedores getEntitySriFacturasProveedores(String strPrefijo,SriFacturasProveedores entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = SriFacturasProveedores.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = SriFacturasProveedores.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				SriFacturasProveedoresLogic.setFieldReflectionSriFacturasProveedores(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSriFacturasProveedores(Field field,String strPrefijo,String sColumn,SriFacturasProveedores entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SriFacturasProveedoresConstantesFunciones.IDENTIFICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresConstantesFunciones.NOMBREMODULO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresConstantesFunciones.NOMBRETRANSACCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresConstantesFunciones.CODIGOASIENTOCONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriFacturasProveedoresConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL:
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
	
	public void quitarSriFacturasProveedoressNulos() throws Exception {				
		
		List<SriFacturasProveedores> srifacturasproveedoressAux= new ArrayList<SriFacturasProveedores>();
		
		for(SriFacturasProveedores srifacturasproveedores:srifacturasproveedoress) {
			if(srifacturasproveedores!=null) {
				srifacturasproveedoressAux.add(srifacturasproveedores);
			}
		}
		
		srifacturasproveedoress=srifacturasproveedoressAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<SriFacturasProveedores> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriFacturasProveedores> entities = new  ArrayList<SriFacturasProveedores>();
		SriFacturasProveedores entity = new SriFacturasProveedores();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriFacturasProveedores>((List<SriFacturasProveedores>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriFacturasProveedoressOriginal(entities);
			
			}  else {
				this.srifacturasproveedoressObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriFacturasProveedoresConstantesFunciones.quitarEspaciosSriFacturasProveedoress(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		srifacturasproveedoress = new  ArrayList<SriFacturasProveedores>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriFacturasProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		srifacturasproveedoress = new  ArrayList<SriFacturasProveedores>();
		  		  
        try {
			//SriFacturasProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<SriFacturasProveedores> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriFacturasProveedores> entities = new  ArrayList<SriFacturasProveedores>();
		SriFacturasProveedores entity = new SriFacturasProveedores();		  
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
	
	public  List<SriFacturasProveedores> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriFacturasProveedores> entities = new  ArrayList<SriFacturasProveedores>();
		SriFacturasProveedores entity = new SriFacturasProveedores();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriFacturasProveedores();
				
				if(conMapGenerico) {
					entity.setMapSriFacturasProveedores( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapSriFacturasProveedores().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SriFacturasProveedoresDataAccess.ISWITHSCHEMA);         		
					entity=SriFacturasProveedoresLogic.getEntitySriFacturasProveedores("",entity,resultSet,listColumns);
					
					////entity.setSriFacturasProveedoresOriginal( new SriFacturasProveedores());
					////entity.setSriFacturasProveedoresOriginal(super.getEntity("",entity.getSriFacturasProveedoresOriginal(),resultSet,SriFacturasProveedoresDataAccess.ISWITHSCHEMA));         		
					////entity.setSriFacturasProveedoresOriginal(SriFacturasProveedoresDataAccess.getEntitySriFacturasProveedores("",entity.getSriFacturasProveedoresOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,SriFacturasProveedores relsrifacturasproveedores)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relsrifacturasproveedores.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Transaccion getTransaccion(Connexion connexion,SriFacturasProveedores relsrifacturasproveedores)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);
			transaccionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			transaccion=transaccionDataAccess.getEntity(connexion,relsrifacturasproveedores.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}


	
	
	public void getSriFacturasProveedoressBusquedaSriFacturasProveedoresWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//SriFacturasProveedoresLogic srifacturasproveedoresLogic=new SriFacturasProveedoresLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriFacturasProveedoresLogic.GetSelecSqlSriFacturasProveedores(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_transaccion,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.srifacturasproveedoress=this.getSriFacturasProveedoress();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getSriFacturasProveedoressBusquedaSriFacturasProveedores(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//SriFacturasProveedoresLogic srifacturasproveedoresLogic=new SriFacturasProveedoresLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriFacturasProveedoresLogic.GetSelecSqlSriFacturasProveedores(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_transaccion,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.srifacturasproveedoress=this.getSriFacturasProveedoress();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlSriFacturasProveedores(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("SriFacturasProveedores_Postgres.sql");
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
				

				if(id_transaccion!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_transaccion = "+id_transaccion.toString();
					existeWhere=true;
				}

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
					existeWhere=true;
				}

				if(fecha_emision_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_emision_hasta)+"'";
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
	
	
	public void deepLoad(SriFacturasProveedores srifacturasproveedores,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SriFacturasProveedoresLogicAdditional.updateSriFacturasProveedoresToGet(srifacturasproveedores,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		srifacturasproveedores.setEmpresa(srifacturasproveedoresDataAccess.getEmpresa(connexion,srifacturasproveedores));
		srifacturasproveedores.setTransaccion(srifacturasproveedoresDataAccess.getTransaccion(connexion,srifacturasproveedores));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				srifacturasproveedores.setEmpresa(srifacturasproveedoresDataAccess.getEmpresa(connexion,srifacturasproveedores));
			}

			if(clas.clas.equals(Transaccion.class)) {
				srifacturasproveedores.setTransaccion(srifacturasproveedoresDataAccess.getTransaccion(connexion,srifacturasproveedores));
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
			srifacturasproveedores.setEmpresa(srifacturasproveedoresDataAccess.getEmpresa(connexion,srifacturasproveedores));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedores.setTransaccion(srifacturasproveedoresDataAccess.getTransaccion(connexion,srifacturasproveedores));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		srifacturasproveedores.setEmpresa(srifacturasproveedoresDataAccess.getEmpresa(connexion,srifacturasproveedores));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(srifacturasproveedores.getEmpresa(),isDeep,deepLoadType,clases);
				
		srifacturasproveedores.setTransaccion(srifacturasproveedoresDataAccess.getTransaccion(connexion,srifacturasproveedores));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(srifacturasproveedores.getTransaccion(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				srifacturasproveedores.setEmpresa(srifacturasproveedoresDataAccess.getEmpresa(connexion,srifacturasproveedores));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(srifacturasproveedores.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Transaccion.class)) {
				srifacturasproveedores.setTransaccion(srifacturasproveedoresDataAccess.getTransaccion(connexion,srifacturasproveedores));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(srifacturasproveedores.getTransaccion(),isDeep,deepLoadType,clases);				
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
			srifacturasproveedores.setEmpresa(srifacturasproveedoresDataAccess.getEmpresa(connexion,srifacturasproveedores));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(srifacturasproveedores.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedores.setTransaccion(srifacturasproveedoresDataAccess.getTransaccion(connexion,srifacturasproveedores));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(srifacturasproveedores.getTransaccion(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(srifacturasproveedores,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriFacturasProveedoresConstantesFunciones.refrescarForeignKeysDescripcionesSriFacturasProveedores(srifacturasproveedores);
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
			this.deepLoad(this.srifacturasproveedores,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriFacturasProveedoresConstantesFunciones.refrescarForeignKeysDescripcionesSriFacturasProveedores(this.srifacturasproveedores);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(srifacturasproveedoress!=null) {
				for(SriFacturasProveedores srifacturasproveedores:srifacturasproveedoress) {
					this.deepLoad(srifacturasproveedores,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SriFacturasProveedoresConstantesFunciones.refrescarForeignKeysDescripcionesSriFacturasProveedores(srifacturasproveedoress);
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
			if(srifacturasproveedoress!=null) {
				for(SriFacturasProveedores srifacturasproveedores:srifacturasproveedoress) {
					this.deepLoad(srifacturasproveedores,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SriFacturasProveedoresConstantesFunciones.refrescarForeignKeysDescripcionesSriFacturasProveedores(srifacturasproveedoress);
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
	
	public SriFacturasProveedoresParameterReturnGeneral procesarAccionSriFacturasProveedoress(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriFacturasProveedores> srifacturasproveedoress,SriFacturasProveedoresParameterReturnGeneral srifacturasproveedoresParameterGeneral)throws Exception {
		 try {	
			SriFacturasProveedoresParameterReturnGeneral srifacturasproveedoresReturnGeneral=new SriFacturasProveedoresParameterReturnGeneral();
	
			SriFacturasProveedoresLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,srifacturasproveedoress,srifacturasproveedoresParameterGeneral,srifacturasproveedoresReturnGeneral);
			
			return srifacturasproveedoresReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SriFacturasProveedoresParameterReturnGeneral procesarAccionSriFacturasProveedoressWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriFacturasProveedores> srifacturasproveedoress,SriFacturasProveedoresParameterReturnGeneral srifacturasproveedoresParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SriFacturasProveedoresParameterReturnGeneral srifacturasproveedoresReturnGeneral=new SriFacturasProveedoresParameterReturnGeneral();
	
			SriFacturasProveedoresLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,srifacturasproveedoress,srifacturasproveedoresParameterGeneral,srifacturasproveedoresReturnGeneral);
			
			this.connexion.commit();
			
			return srifacturasproveedoresReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

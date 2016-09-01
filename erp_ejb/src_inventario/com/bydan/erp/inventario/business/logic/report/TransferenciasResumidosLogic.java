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
package com.bydan.erp.inventario.business.logic.report;

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

import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.resources.general.AuxiliarGeneral;
import com.bydan.erp.inventario.util.report.TransferenciasResumidosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.TransferenciasResumidosParameterGeneral;
import com.bydan.erp.inventario.util.report.TransferenciasResumidosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.TransferenciasResumidos;

import com.bydan.erp.inventario.business.logic.report.TransferenciasResumidosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;






@SuppressWarnings("unused")
public class TransferenciasResumidosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(TransferenciasResumidosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected TransferenciasResumidosLogic transferenciasresumidosDataAccess; 		
	protected TransferenciasResumidos transferenciasresumidos;
	protected List<TransferenciasResumidos> transferenciasresumidoss;
	protected Object transferenciasresumidosObject;	
	protected List<Object> transferenciasresumidossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  TransferenciasResumidosLogic()throws SQLException,Exception {
		try	{
			this.transferenciasresumidoss= new ArrayList<TransferenciasResumidos>();
			this.transferenciasresumidos= new TransferenciasResumidos();
			this.transferenciasresumidosObject=new Object();
			this.transferenciasresumidossObject=new ArrayList<Object>();
			
			this.transferenciasresumidosDataAccess=this;
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
			this.transferenciasresumidosDataAccess.setConnexionType(this.connexionType);
			this.transferenciasresumidosDataAccess.setParameterDbType(this.parameterDbType);
			this.transferenciasresumidosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TransferenciasResumidosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.transferenciasresumidoss= new ArrayList<TransferenciasResumidos>();
			this.transferenciasresumidos= new TransferenciasResumidos();
			this.transferenciasresumidosObject=new Object();
			this.transferenciasresumidossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.transferenciasresumidosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.transferenciasresumidosDataAccess.setConnexionType(this.connexionType);
			this.transferenciasresumidosDataAccess.setParameterDbType(this.parameterDbType);
			this.transferenciasresumidosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TransferenciasResumidos getTransferenciasResumidos() throws Exception {	
		TransferenciasResumidosLogicAdditional.checkTransferenciasResumidosToGet(transferenciasresumidos,this.datosCliente,this.arrDatoGeneral);
		TransferenciasResumidosLogicAdditional.updateTransferenciasResumidosToGet(transferenciasresumidos,this.arrDatoGeneral);
		
		return transferenciasresumidos;
	}
		
	public void setTransferenciasResumidos(TransferenciasResumidos newTransferenciasResumidos) {
		this.transferenciasresumidos = newTransferenciasResumidos;
	}
	
	public List<TransferenciasResumidos> getTransferenciasResumidoss() throws Exception {		
		this.quitarTransferenciasResumidossNulos();
		
		TransferenciasResumidosLogicAdditional.checkTransferenciasResumidosToGets(transferenciasresumidoss,this.datosCliente,this.arrDatoGeneral);
		
		for (TransferenciasResumidos transferenciasresumidosLocal: transferenciasresumidoss ) {
			TransferenciasResumidosLogicAdditional.updateTransferenciasResumidosToGet(transferenciasresumidosLocal,this.arrDatoGeneral);
		}
		
		return transferenciasresumidoss;
	}
	
	public void setTransferenciasResumidoss(List<TransferenciasResumidos> newTransferenciasResumidoss) {
		this.transferenciasresumidoss = newTransferenciasResumidoss;
	}
	
	public Object getTransferenciasResumidosObject() {	
		//this.transferenciasresumidosObject=this.transferenciasresumidosDataAccess.getEntityObject();
		return this.transferenciasresumidosObject;
	}
		
	public void setTransferenciasResumidosObject(Object newTransferenciasResumidosObject) {
		this.transferenciasresumidosObject = newTransferenciasResumidosObject;
	}
	
	public List<Object> getTransferenciasResumidossObject() {		
		//this.transferenciasresumidossObject=this.transferenciasresumidosDataAccess.getEntitiesObject();
		return this.transferenciasresumidossObject;
	}
		
	public void setTransferenciasResumidossObject(List<Object> newTransferenciasResumidossObject) {
		this.transferenciasresumidossObject = newTransferenciasResumidossObject;
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
		transferenciasresumidoss = new  ArrayList<TransferenciasResumidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TransferenciasResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferenciasresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		transferenciasresumidoss = new  ArrayList<TransferenciasResumidos>();
		  		  
        try {
			//TransferenciasResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferenciasresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transferenciasresumidoss = new  ArrayList<TransferenciasResumidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TransferenciasResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferenciasresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		transferenciasresumidoss = new  ArrayList<TransferenciasResumidos>();
		  		  
        try {
			//TransferenciasResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferenciasresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		transferenciasresumidoss = new  ArrayList<TransferenciasResumidos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TransferenciasResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferenciasresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		transferenciasresumidoss = new  ArrayList<TransferenciasResumidos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//TransferenciasResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferenciasresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<TransferenciasResumidos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransferenciasResumidos> entities = new  ArrayList<TransferenciasResumidos>();
		TransferenciasResumidos entity = new TransferenciasResumidos();		  
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
	
	public  List<TransferenciasResumidos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransferenciasResumidos> entities = new  ArrayList<TransferenciasResumidos>();
		TransferenciasResumidos entity = new TransferenciasResumidos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransferenciasResumidos();
				
				
      	    	entity=TransferenciasResumidosLogic.getEntityTransferenciasResumidos("",entity,resultSet);
      	    	
				//entity.setTransferenciasResumidosOriginal( new TransferenciasResumidos());
      	    	//entity.setTransferenciasResumidosOriginal(super.getEntity("",entity.getTransferenciasResumidosOriginal(),resultSet,TransferenciasResumidosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransferenciasResumidosOriginal(TransferenciasResumidosDataAccess.getEntityTransferenciasResumidos("",entity.getTransferenciasResumidosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<TransferenciasResumidos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransferenciasResumidos> entities = new  ArrayList<TransferenciasResumidos>();
		TransferenciasResumidos entity = new TransferenciasResumidos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,TransferenciasResumidos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<TransferenciasResumidos>((List<TransferenciasResumidos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setTransferenciasResumidossOriginal(entities);
			
			}  else {
				this.transferenciasresumidossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//TransferenciasResumidosConstantesFunciones.quitarEspaciosTransferenciasResumidoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static TransferenciasResumidos getEntityTransferenciasResumidos(String strPrefijo,TransferenciasResumidos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_transaccion(resultSet.getString(strPrefijo+TransferenciasResumidosConstantesFunciones.NOMBRETRANSACCION));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+TransferenciasResumidosConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_producto(resultSet.getString(strPrefijo+TransferenciasResumidosConstantesFunciones.NOMBREPRODUCTO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+TransferenciasResumidosConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad(resultSet.getInt(strPrefijo+TransferenciasResumidosConstantesFunciones.CANTIDAD));
			entity.setcosto_unitario(resultSet.getDouble(strPrefijo+TransferenciasResumidosConstantesFunciones.COSTOUNITARIO));
			entity.setcosto_total(resultSet.getDouble(strPrefijo+TransferenciasResumidosConstantesFunciones.COSTOTOTAL));
			entity.setnombre_bodega_enviar(resultSet.getString(strPrefijo+TransferenciasResumidosConstantesFunciones.NOMBREBODEGAENVIAR));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+TransferenciasResumidosConstantesFunciones.CODIGOPRODUCTO));
			entity.settipo(resultSet.getString(strPrefijo+TransferenciasResumidosConstantesFunciones.TIPO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TransferenciasResumidos getEntityTransferenciasResumidos(String strPrefijo,TransferenciasResumidos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = TransferenciasResumidos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = TransferenciasResumidos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				TransferenciasResumidosLogic.setFieldReflectionTransferenciasResumidos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTransferenciasResumidos(Field field,String strPrefijo,String sColumn,TransferenciasResumidos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TransferenciasResumidosConstantesFunciones.NOMBRETRANSACCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciasResumidosConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciasResumidosConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciasResumidosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciasResumidosConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case TransferenciasResumidosConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciasResumidosConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciasResumidosConstantesFunciones.NOMBREBODEGAENVIAR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciasResumidosConstantesFunciones.CODIGOPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciasResumidosConstantesFunciones.TIPO:
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
	
	public void quitarTransferenciasResumidossNulos() throws Exception {				
		
		List<TransferenciasResumidos> transferenciasresumidossAux= new ArrayList<TransferenciasResumidos>();
		
		for(TransferenciasResumidos transferenciasresumidos:transferenciasresumidoss) {
			if(transferenciasresumidos!=null) {
				transferenciasresumidossAux.add(transferenciasresumidos);
			}
		}
		
		transferenciasresumidoss=transferenciasresumidossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<TransferenciasResumidos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransferenciasResumidos> entities = new  ArrayList<TransferenciasResumidos>();
		TransferenciasResumidos entity = new TransferenciasResumidos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<TransferenciasResumidos>((List<TransferenciasResumidos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setTransferenciasResumidossOriginal(entities);
			
			}  else {
				this.transferenciasresumidossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//TransferenciasResumidosConstantesFunciones.quitarEspaciosTransferenciasResumidoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		transferenciasresumidoss = new  ArrayList<TransferenciasResumidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TransferenciasResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferenciasresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		transferenciasresumidoss = new  ArrayList<TransferenciasResumidos>();
		  		  
        try {
			//TransferenciasResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transferenciasresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<TransferenciasResumidos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransferenciasResumidos> entities = new  ArrayList<TransferenciasResumidos>();
		TransferenciasResumidos entity = new TransferenciasResumidos();		  
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
	
	public  List<TransferenciasResumidos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransferenciasResumidos> entities = new  ArrayList<TransferenciasResumidos>();
		TransferenciasResumidos entity = new TransferenciasResumidos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransferenciasResumidos();
				
				if(conMapGenerico) {
					entity.setMapTransferenciasResumidos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapTransferenciasResumidos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransferenciasResumidosDataAccess.ISWITHSCHEMA);         		
					entity=TransferenciasResumidosLogic.getEntityTransferenciasResumidos("",entity,resultSet,listColumns);
					
					////entity.setTransferenciasResumidosOriginal( new TransferenciasResumidos());
					////entity.setTransferenciasResumidosOriginal(super.getEntity("",entity.getTransferenciasResumidosOriginal(),resultSet,TransferenciasResumidosDataAccess.ISWITHSCHEMA));         		
					////entity.setTransferenciasResumidosOriginal(TransferenciasResumidosDataAccess.getEntityTransferenciasResumidos("",entity.getTransferenciasResumidosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,TransferenciasResumidos reltransferenciasresumidos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reltransferenciasresumidos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TransferenciasResumidos reltransferenciasresumidos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,reltransferenciasresumidos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,TransferenciasResumidos reltransferenciasresumidos)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,reltransferenciasresumidos.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,TransferenciasResumidos reltransferenciasresumidos)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,reltransferenciasresumidos.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Transaccion getTransaccion(Connexion connexion,TransferenciasResumidos reltransferenciasresumidos)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);
			transaccionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			transaccion=transaccionDataAccess.getEntity(connexion,reltransferenciasresumidos.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Linea getLinea(Connexion connexion,TransferenciasResumidos reltransferenciasresumidos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reltransferenciasresumidos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,TransferenciasResumidos reltransferenciasresumidos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reltransferenciasresumidos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,TransferenciasResumidos reltransferenciasresumidos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reltransferenciasresumidos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,TransferenciasResumidos reltransferenciasresumidos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reltransferenciasresumidos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getTransferenciasResumidossBusquedaTransferenciasResumidosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//TransferenciasResumidosLogic transferenciasresumidosLogic=new TransferenciasResumidosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=TransferenciasResumidosLogic.GetSelecSqlTransferenciasResumidos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_transaccion,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.transferenciasresumidoss=this.getTransferenciasResumidoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getTransferenciasResumidossBusquedaTransferenciasResumidos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//TransferenciasResumidosLogic transferenciasresumidosLogic=new TransferenciasResumidosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=TransferenciasResumidosLogic.GetSelecSqlTransferenciasResumidos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_transaccion,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.transferenciasresumidoss=this.getTransferenciasResumidoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlTransferenciasResumidos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("TransferenciasResumidos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" m.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" m.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_bodega!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_bodega = "+id_bodega.toString();
					existeWhere=true;
				}

				if(id_producto!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_producto = "+id_producto.toString();
					existeWhere=true;
				}

				if(id_transaccion!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" m.id_transaccion = "+id_transaccion.toString();
					existeWhere=true;
				}

				if(id_linea!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea = "+id_linea.toString();
					existeWhere=true;
				}

				if(id_linea_grupo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_grupo = "+id_linea_grupo.toString();
					existeWhere=true;
				}

				if(id_linea_categoria!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_categoria = "+id_linea_categoria.toString();
					existeWhere=true;
				}

				if(id_linea_marca!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_marca = "+id_linea_marca.toString();
					existeWhere=true;
				}

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" m.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
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

				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"1",sSqlWhere);
				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"2",sSqlWhere);

				sSql=sSelectQuery;

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
	
	
	public void deepLoad(TransferenciasResumidos transferenciasresumidos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TransferenciasResumidosLogicAdditional.updateTransferenciasResumidosToGet(transferenciasresumidos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transferenciasresumidos.setEmpresa(transferenciasresumidosDataAccess.getEmpresa(connexion,transferenciasresumidos));
		transferenciasresumidos.setSucursal(transferenciasresumidosDataAccess.getSucursal(connexion,transferenciasresumidos));
		transferenciasresumidos.setBodega(transferenciasresumidosDataAccess.getBodega(connexion,transferenciasresumidos));
		transferenciasresumidos.setProducto(transferenciasresumidosDataAccess.getProducto(connexion,transferenciasresumidos));
		transferenciasresumidos.setTransaccion(transferenciasresumidosDataAccess.getTransaccion(connexion,transferenciasresumidos));
		transferenciasresumidos.setLinea(transferenciasresumidosDataAccess.getLinea(connexion,transferenciasresumidos));
		transferenciasresumidos.setLineaGrupo(transferenciasresumidosDataAccess.getLineaGrupo(connexion,transferenciasresumidos));
		transferenciasresumidos.setLineaCategoria(transferenciasresumidosDataAccess.getLineaCategoria(connexion,transferenciasresumidos));
		transferenciasresumidos.setLineaMarca(transferenciasresumidosDataAccess.getLineaMarca(connexion,transferenciasresumidos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transferenciasresumidos.setEmpresa(transferenciasresumidosDataAccess.getEmpresa(connexion,transferenciasresumidos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				transferenciasresumidos.setSucursal(transferenciasresumidosDataAccess.getSucursal(connexion,transferenciasresumidos));
			}

			if(clas.clas.equals(Bodega.class)) {
				transferenciasresumidos.setBodega(transferenciasresumidosDataAccess.getBodega(connexion,transferenciasresumidos));
			}

			if(clas.clas.equals(Producto.class)) {
				transferenciasresumidos.setProducto(transferenciasresumidosDataAccess.getProducto(connexion,transferenciasresumidos));
			}

			if(clas.clas.equals(Transaccion.class)) {
				transferenciasresumidos.setTransaccion(transferenciasresumidosDataAccess.getTransaccion(connexion,transferenciasresumidos));
			}

			if(clas.clas.equals(Linea.class)) {
				transferenciasresumidos.setLinea(transferenciasresumidosDataAccess.getLinea(connexion,transferenciasresumidos));
			}

			if(clas.clas.equals(Linea.class)) {
				transferenciasresumidos.setLineaGrupo(transferenciasresumidosDataAccess.getLineaGrupo(connexion,transferenciasresumidos));
			}

			if(clas.clas.equals(Linea.class)) {
				transferenciasresumidos.setLineaCategoria(transferenciasresumidosDataAccess.getLineaCategoria(connexion,transferenciasresumidos));
			}

			if(clas.clas.equals(Linea.class)) {
				transferenciasresumidos.setLineaMarca(transferenciasresumidosDataAccess.getLineaMarca(connexion,transferenciasresumidos));
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
			transferenciasresumidos.setEmpresa(transferenciasresumidosDataAccess.getEmpresa(connexion,transferenciasresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setSucursal(transferenciasresumidosDataAccess.getSucursal(connexion,transferenciasresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setBodega(transferenciasresumidosDataAccess.getBodega(connexion,transferenciasresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setProducto(transferenciasresumidosDataAccess.getProducto(connexion,transferenciasresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setTransaccion(transferenciasresumidosDataAccess.getTransaccion(connexion,transferenciasresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setLinea(transferenciasresumidosDataAccess.getLinea(connexion,transferenciasresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setLineaGrupo(transferenciasresumidosDataAccess.getLineaGrupo(connexion,transferenciasresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setLineaCategoria(transferenciasresumidosDataAccess.getLineaCategoria(connexion,transferenciasresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setLineaMarca(transferenciasresumidosDataAccess.getLineaMarca(connexion,transferenciasresumidos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transferenciasresumidos.setEmpresa(transferenciasresumidosDataAccess.getEmpresa(connexion,transferenciasresumidos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transferenciasresumidos.getEmpresa(),isDeep,deepLoadType,clases);
				
		transferenciasresumidos.setSucursal(transferenciasresumidosDataAccess.getSucursal(connexion,transferenciasresumidos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(transferenciasresumidos.getSucursal(),isDeep,deepLoadType,clases);
				
		transferenciasresumidos.setBodega(transferenciasresumidosDataAccess.getBodega(connexion,transferenciasresumidos));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(transferenciasresumidos.getBodega(),isDeep,deepLoadType,clases);
				
		transferenciasresumidos.setProducto(transferenciasresumidosDataAccess.getProducto(connexion,transferenciasresumidos));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(transferenciasresumidos.getProducto(),isDeep,deepLoadType,clases);
				
		transferenciasresumidos.setTransaccion(transferenciasresumidosDataAccess.getTransaccion(connexion,transferenciasresumidos));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(transferenciasresumidos.getTransaccion(),isDeep,deepLoadType,clases);
				
		transferenciasresumidos.setLinea(transferenciasresumidosDataAccess.getLinea(connexion,transferenciasresumidos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(transferenciasresumidos.getLinea(),isDeep,deepLoadType,clases);
				
		transferenciasresumidos.setLineaGrupo(transferenciasresumidosDataAccess.getLineaGrupo(connexion,transferenciasresumidos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(transferenciasresumidos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		transferenciasresumidos.setLineaCategoria(transferenciasresumidosDataAccess.getLineaCategoria(connexion,transferenciasresumidos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(transferenciasresumidos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		transferenciasresumidos.setLineaMarca(transferenciasresumidosDataAccess.getLineaMarca(connexion,transferenciasresumidos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(transferenciasresumidos.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transferenciasresumidos.setEmpresa(transferenciasresumidosDataAccess.getEmpresa(connexion,transferenciasresumidos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(transferenciasresumidos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				transferenciasresumidos.setSucursal(transferenciasresumidosDataAccess.getSucursal(connexion,transferenciasresumidos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(transferenciasresumidos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Bodega.class)) {
				transferenciasresumidos.setBodega(transferenciasresumidosDataAccess.getBodega(connexion,transferenciasresumidos));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(transferenciasresumidos.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				transferenciasresumidos.setProducto(transferenciasresumidosDataAccess.getProducto(connexion,transferenciasresumidos));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(transferenciasresumidos.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Transaccion.class)) {
				transferenciasresumidos.setTransaccion(transferenciasresumidosDataAccess.getTransaccion(connexion,transferenciasresumidos));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(transferenciasresumidos.getTransaccion(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				transferenciasresumidos.setLinea(transferenciasresumidosDataAccess.getLinea(connexion,transferenciasresumidos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(transferenciasresumidos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				transferenciasresumidos.setLineaGrupo(transferenciasresumidosDataAccess.getLineaGrupo(connexion,transferenciasresumidos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(transferenciasresumidos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				transferenciasresumidos.setLineaCategoria(transferenciasresumidosDataAccess.getLineaCategoria(connexion,transferenciasresumidos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(transferenciasresumidos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				transferenciasresumidos.setLineaMarca(transferenciasresumidosDataAccess.getLineaMarca(connexion,transferenciasresumidos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(transferenciasresumidos.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			transferenciasresumidos.setEmpresa(transferenciasresumidosDataAccess.getEmpresa(connexion,transferenciasresumidos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(transferenciasresumidos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setSucursal(transferenciasresumidosDataAccess.getSucursal(connexion,transferenciasresumidos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(transferenciasresumidos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setBodega(transferenciasresumidosDataAccess.getBodega(connexion,transferenciasresumidos));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(transferenciasresumidos.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setProducto(transferenciasresumidosDataAccess.getProducto(connexion,transferenciasresumidos));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(transferenciasresumidos.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setTransaccion(transferenciasresumidosDataAccess.getTransaccion(connexion,transferenciasresumidos));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(transferenciasresumidos.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setLinea(transferenciasresumidosDataAccess.getLinea(connexion,transferenciasresumidos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(transferenciasresumidos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setLineaGrupo(transferenciasresumidosDataAccess.getLineaGrupo(connexion,transferenciasresumidos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(transferenciasresumidos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setLineaCategoria(transferenciasresumidosDataAccess.getLineaCategoria(connexion,transferenciasresumidos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(transferenciasresumidos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transferenciasresumidos.setLineaMarca(transferenciasresumidosDataAccess.getLineaMarca(connexion,transferenciasresumidos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(transferenciasresumidos.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(transferenciasresumidos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransferenciasResumidosConstantesFunciones.refrescarForeignKeysDescripcionesTransferenciasResumidos(transferenciasresumidos);
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
			this.deepLoad(this.transferenciasresumidos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransferenciasResumidosConstantesFunciones.refrescarForeignKeysDescripcionesTransferenciasResumidos(this.transferenciasresumidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(transferenciasresumidoss!=null) {
				for(TransferenciasResumidos transferenciasresumidos:transferenciasresumidoss) {
					this.deepLoad(transferenciasresumidos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TransferenciasResumidosConstantesFunciones.refrescarForeignKeysDescripcionesTransferenciasResumidos(transferenciasresumidoss);
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
			if(transferenciasresumidoss!=null) {
				for(TransferenciasResumidos transferenciasresumidos:transferenciasresumidoss) {
					this.deepLoad(transferenciasresumidos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TransferenciasResumidosConstantesFunciones.refrescarForeignKeysDescripcionesTransferenciasResumidos(transferenciasresumidoss);
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
	
	public TransferenciasResumidosParameterReturnGeneral procesarAccionTransferenciasResumidoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransferenciasResumidos> transferenciasresumidoss,TransferenciasResumidosParameterReturnGeneral transferenciasresumidosParameterGeneral)throws Exception {
		 try {	
			TransferenciasResumidosParameterReturnGeneral transferenciasresumidosReturnGeneral=new TransferenciasResumidosParameterReturnGeneral();
	
			TransferenciasResumidosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transferenciasresumidoss,transferenciasresumidosParameterGeneral,transferenciasresumidosReturnGeneral);
			
			return transferenciasresumidosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransferenciasResumidosParameterReturnGeneral procesarAccionTransferenciasResumidossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransferenciasResumidos> transferenciasresumidoss,TransferenciasResumidosParameterReturnGeneral transferenciasresumidosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			TransferenciasResumidosParameterReturnGeneral transferenciasresumidosReturnGeneral=new TransferenciasResumidosParameterReturnGeneral();
	
			TransferenciasResumidosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transferenciasresumidoss,transferenciasresumidosParameterGeneral,transferenciasresumidosReturnGeneral);
			
			this.connexion.commit();
			
			return transferenciasresumidosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

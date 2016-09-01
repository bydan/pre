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
import com.bydan.erp.inventario.util.report.ProcesoGenerarSaldosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoGenerarSaldosParameterGeneral;
import com.bydan.erp.inventario.util.report.ProcesoGenerarSaldosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProcesoGenerarSaldos;

import com.bydan.erp.inventario.business.logic.report.ProcesoGenerarSaldosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoGenerarSaldosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoGenerarSaldosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoGenerarSaldosLogic procesogenerarsaldosDataAccess; 		
	protected ProcesoGenerarSaldos procesogenerarsaldos;
	protected List<ProcesoGenerarSaldos> procesogenerarsaldoss;
	protected Object procesogenerarsaldosObject;	
	protected List<Object> procesogenerarsaldossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoGenerarSaldosLogic()throws SQLException,Exception {
		try	{
			this.procesogenerarsaldoss= new ArrayList<ProcesoGenerarSaldos>();
			this.procesogenerarsaldos= new ProcesoGenerarSaldos();
			this.procesogenerarsaldosObject=new Object();
			this.procesogenerarsaldossObject=new ArrayList<Object>();
			
			this.procesogenerarsaldosDataAccess=this;
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
			this.procesogenerarsaldosDataAccess.setConnexionType(this.connexionType);
			this.procesogenerarsaldosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesogenerarsaldosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoGenerarSaldosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesogenerarsaldoss= new ArrayList<ProcesoGenerarSaldos>();
			this.procesogenerarsaldos= new ProcesoGenerarSaldos();
			this.procesogenerarsaldosObject=new Object();
			this.procesogenerarsaldossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesogenerarsaldosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesogenerarsaldosDataAccess.setConnexionType(this.connexionType);
			this.procesogenerarsaldosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesogenerarsaldosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoGenerarSaldos getProcesoGenerarSaldos() throws Exception {	
		ProcesoGenerarSaldosLogicAdditional.checkProcesoGenerarSaldosToGet(procesogenerarsaldos,this.datosCliente,this.arrDatoGeneral);
		ProcesoGenerarSaldosLogicAdditional.updateProcesoGenerarSaldosToGet(procesogenerarsaldos,this.arrDatoGeneral);
		
		return procesogenerarsaldos;
	}
		
	public void setProcesoGenerarSaldos(ProcesoGenerarSaldos newProcesoGenerarSaldos) {
		this.procesogenerarsaldos = newProcesoGenerarSaldos;
	}
	
	public List<ProcesoGenerarSaldos> getProcesoGenerarSaldoss() throws Exception {		
		this.quitarProcesoGenerarSaldossNulos();
		
		ProcesoGenerarSaldosLogicAdditional.checkProcesoGenerarSaldosToGets(procesogenerarsaldoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoGenerarSaldos procesogenerarsaldosLocal: procesogenerarsaldoss ) {
			ProcesoGenerarSaldosLogicAdditional.updateProcesoGenerarSaldosToGet(procesogenerarsaldosLocal,this.arrDatoGeneral);
		}
		
		return procesogenerarsaldoss;
	}
	
	public void setProcesoGenerarSaldoss(List<ProcesoGenerarSaldos> newProcesoGenerarSaldoss) {
		this.procesogenerarsaldoss = newProcesoGenerarSaldoss;
	}
	
	public Object getProcesoGenerarSaldosObject() {	
		//this.procesogenerarsaldosObject=this.procesogenerarsaldosDataAccess.getEntityObject();
		return this.procesogenerarsaldosObject;
	}
		
	public void setProcesoGenerarSaldosObject(Object newProcesoGenerarSaldosObject) {
		this.procesogenerarsaldosObject = newProcesoGenerarSaldosObject;
	}
	
	public List<Object> getProcesoGenerarSaldossObject() {		
		//this.procesogenerarsaldossObject=this.procesogenerarsaldosDataAccess.getEntitiesObject();
		return this.procesogenerarsaldossObject;
	}
		
	public void setProcesoGenerarSaldossObject(List<Object> newProcesoGenerarSaldossObject) {
		this.procesogenerarsaldossObject = newProcesoGenerarSaldossObject;
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
		procesogenerarsaldoss = new  ArrayList<ProcesoGenerarSaldos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGenerarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogenerarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesogenerarsaldoss = new  ArrayList<ProcesoGenerarSaldos>();
		  		  
        try {
			//ProcesoGenerarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogenerarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesogenerarsaldoss = new  ArrayList<ProcesoGenerarSaldos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGenerarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogenerarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesogenerarsaldoss = new  ArrayList<ProcesoGenerarSaldos>();
		  		  
        try {
			//ProcesoGenerarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogenerarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesogenerarsaldoss = new  ArrayList<ProcesoGenerarSaldos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGenerarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogenerarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesogenerarsaldoss = new  ArrayList<ProcesoGenerarSaldos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoGenerarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogenerarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoGenerarSaldos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGenerarSaldos> entities = new  ArrayList<ProcesoGenerarSaldos>();
		ProcesoGenerarSaldos entity = new ProcesoGenerarSaldos();		  
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
	
	public  List<ProcesoGenerarSaldos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGenerarSaldos> entities = new  ArrayList<ProcesoGenerarSaldos>();
		ProcesoGenerarSaldos entity = new ProcesoGenerarSaldos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoGenerarSaldos();
				
				
      	    	entity=ProcesoGenerarSaldosLogic.getEntityProcesoGenerarSaldos("",entity,resultSet);
      	    	
				//entity.setProcesoGenerarSaldosOriginal( new ProcesoGenerarSaldos());
      	    	//entity.setProcesoGenerarSaldosOriginal(super.getEntity("",entity.getProcesoGenerarSaldosOriginal(),resultSet,ProcesoGenerarSaldosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoGenerarSaldosOriginal(ProcesoGenerarSaldosDataAccess.getEntityProcesoGenerarSaldos("",entity.getProcesoGenerarSaldosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoGenerarSaldos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGenerarSaldos> entities = new  ArrayList<ProcesoGenerarSaldos>();
		ProcesoGenerarSaldos entity = new ProcesoGenerarSaldos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoGenerarSaldos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoGenerarSaldos>((List<ProcesoGenerarSaldos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoGenerarSaldossOriginal(entities);
			
			}  else {
				this.procesogenerarsaldossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoGenerarSaldosConstantesFunciones.quitarEspaciosProcesoGenerarSaldoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoGenerarSaldos getEntityProcesoGenerarSaldos(String strPrefijo,ProcesoGenerarSaldos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.NOMBRESUCURSAL));
			entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.IDTIPOTRANSACCIONMODULO));
			entity.setnumero_comprobante(resultSet.getString(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.NUMEROCOMPROBANTE));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.FECHA).getTime()));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_producto(resultSet.getString(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.NOMBREPRODUCTO));
			entity.setcantidad(resultSet.getInt(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.CANTIDAD));
			entity.setcosto_unitario(resultSet.getDouble(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO));
			entity.setcosto_total(resultSet.getDouble(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL));
			entity.setnombre_bodega_enviar(resultSet.getString(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGAENVIAR));
			entity.settotal(resultSet.getDouble(strPrefijo+ProcesoGenerarSaldosConstantesFunciones.TOTAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoGenerarSaldos getEntityProcesoGenerarSaldos(String strPrefijo,ProcesoGenerarSaldos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoGenerarSaldos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoGenerarSaldos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoGenerarSaldosLogic.setFieldReflectionProcesoGenerarSaldos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoGenerarSaldos(Field field,String strPrefijo,String sColumn,ProcesoGenerarSaldos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoGenerarSaldosConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGAENVIAR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoGenerarSaldosConstantesFunciones.TOTAL:
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
	
	public void quitarProcesoGenerarSaldossNulos() throws Exception {				
		
		List<ProcesoGenerarSaldos> procesogenerarsaldossAux= new ArrayList<ProcesoGenerarSaldos>();
		
		for(ProcesoGenerarSaldos procesogenerarsaldos:procesogenerarsaldoss) {
			if(procesogenerarsaldos!=null) {
				procesogenerarsaldossAux.add(procesogenerarsaldos);
			}
		}
		
		procesogenerarsaldoss=procesogenerarsaldossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoGenerarSaldos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoGenerarSaldos> entities = new  ArrayList<ProcesoGenerarSaldos>();
		ProcesoGenerarSaldos entity = new ProcesoGenerarSaldos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoGenerarSaldos>((List<ProcesoGenerarSaldos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoGenerarSaldossOriginal(entities);
			
			}  else {
				this.procesogenerarsaldossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoGenerarSaldosConstantesFunciones.quitarEspaciosProcesoGenerarSaldoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesogenerarsaldoss = new  ArrayList<ProcesoGenerarSaldos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoGenerarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogenerarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesogenerarsaldoss = new  ArrayList<ProcesoGenerarSaldos>();
		  		  
        try {
			//ProcesoGenerarSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesogenerarsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoGenerarSaldos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoGenerarSaldos> entities = new  ArrayList<ProcesoGenerarSaldos>();
		ProcesoGenerarSaldos entity = new ProcesoGenerarSaldos();		  
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
	
	public  List<ProcesoGenerarSaldos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoGenerarSaldos> entities = new  ArrayList<ProcesoGenerarSaldos>();
		ProcesoGenerarSaldos entity = new ProcesoGenerarSaldos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoGenerarSaldos();
				
				if(conMapGenerico) {
					entity.setMapProcesoGenerarSaldos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoGenerarSaldos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoGenerarSaldosDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoGenerarSaldosLogic.getEntityProcesoGenerarSaldos("",entity,resultSet,listColumns);
					
					////entity.setProcesoGenerarSaldosOriginal( new ProcesoGenerarSaldos());
					////entity.setProcesoGenerarSaldosOriginal(super.getEntity("",entity.getProcesoGenerarSaldosOriginal(),resultSet,ProcesoGenerarSaldosDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoGenerarSaldosOriginal(ProcesoGenerarSaldosDataAccess.getEntityProcesoGenerarSaldos("",entity.getProcesoGenerarSaldosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ProcesoGenerarSaldos relprocesogenerarsaldos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relprocesogenerarsaldos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProcesoGenerarSaldos relprocesogenerarsaldos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relprocesogenerarsaldos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,ProcesoGenerarSaldos relprocesogenerarsaldos)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relprocesogenerarsaldos.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,ProcesoGenerarSaldos relprocesogenerarsaldos)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);
			periodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periodo=periodoDataAccess.getEntity(connexion,relprocesogenerarsaldos.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,ProcesoGenerarSaldos relprocesogenerarsaldos)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);
			tipotransaccionmoduloDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,relprocesogenerarsaldos.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}


	
	
	public void getProcesoGenerarSaldossBusquedaProcesoGenerarSaldosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo)throws Exception {
		try {
			//ProcesoGenerarSaldosLogic procesogenerarsaldosLogic=new ProcesoGenerarSaldosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoGenerarSaldosLogic.GetSelecSqlProcesoGenerarSaldos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesogenerarsaldoss=this.getProcesoGenerarSaldoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoGenerarSaldossBusquedaProcesoGenerarSaldos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo)throws Exception {
		try {
			//ProcesoGenerarSaldosLogic procesogenerarsaldosLogic=new ProcesoGenerarSaldosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoGenerarSaldosLogic.GetSelecSqlProcesoGenerarSaldos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesogenerarsaldoss=this.getProcesoGenerarSaldoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoGenerarSaldos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoGenerarSaldos_Postgres.sql");
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
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" m.id_ejercicio = "+id_ejercicio.toString();
					existeWhere=true;
				}

				if(id_periodo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" m.id_periodo = "+id_periodo.toString();
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
	
	
	public void deepLoad(ProcesoGenerarSaldos procesogenerarsaldos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoGenerarSaldosLogicAdditional.updateProcesoGenerarSaldosToGet(procesogenerarsaldos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesogenerarsaldos.setEmpresa(procesogenerarsaldosDataAccess.getEmpresa(connexion,procesogenerarsaldos));
		procesogenerarsaldos.setSucursal(procesogenerarsaldosDataAccess.getSucursal(connexion,procesogenerarsaldos));
		procesogenerarsaldos.setEjercicio(procesogenerarsaldosDataAccess.getEjercicio(connexion,procesogenerarsaldos));
		procesogenerarsaldos.setPeriodo(procesogenerarsaldosDataAccess.getPeriodo(connexion,procesogenerarsaldos));
		procesogenerarsaldos.setTipoTransaccionModulo(procesogenerarsaldosDataAccess.getTipoTransaccionModulo(connexion,procesogenerarsaldos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				procesogenerarsaldos.setEmpresa(procesogenerarsaldosDataAccess.getEmpresa(connexion,procesogenerarsaldos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesogenerarsaldos.setSucursal(procesogenerarsaldosDataAccess.getSucursal(connexion,procesogenerarsaldos));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				procesogenerarsaldos.setEjercicio(procesogenerarsaldosDataAccess.getEjercicio(connexion,procesogenerarsaldos));
			}

			if(clas.clas.equals(Periodo.class)) {
				procesogenerarsaldos.setPeriodo(procesogenerarsaldosDataAccess.getPeriodo(connexion,procesogenerarsaldos));
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				procesogenerarsaldos.setTipoTransaccionModulo(procesogenerarsaldosDataAccess.getTipoTransaccionModulo(connexion,procesogenerarsaldos));
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
			procesogenerarsaldos.setEmpresa(procesogenerarsaldosDataAccess.getEmpresa(connexion,procesogenerarsaldos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogenerarsaldos.setSucursal(procesogenerarsaldosDataAccess.getSucursal(connexion,procesogenerarsaldos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogenerarsaldos.setEjercicio(procesogenerarsaldosDataAccess.getEjercicio(connexion,procesogenerarsaldos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogenerarsaldos.setPeriodo(procesogenerarsaldosDataAccess.getPeriodo(connexion,procesogenerarsaldos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogenerarsaldos.setTipoTransaccionModulo(procesogenerarsaldosDataAccess.getTipoTransaccionModulo(connexion,procesogenerarsaldos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesogenerarsaldos.setEmpresa(procesogenerarsaldosDataAccess.getEmpresa(connexion,procesogenerarsaldos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(procesogenerarsaldos.getEmpresa(),isDeep,deepLoadType,clases);
				
		procesogenerarsaldos.setSucursal(procesogenerarsaldosDataAccess.getSucursal(connexion,procesogenerarsaldos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(procesogenerarsaldos.getSucursal(),isDeep,deepLoadType,clases);
				
		procesogenerarsaldos.setEjercicio(procesogenerarsaldosDataAccess.getEjercicio(connexion,procesogenerarsaldos));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(procesogenerarsaldos.getEjercicio(),isDeep,deepLoadType,clases);
				
		procesogenerarsaldos.setPeriodo(procesogenerarsaldosDataAccess.getPeriodo(connexion,procesogenerarsaldos));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(procesogenerarsaldos.getPeriodo(),isDeep,deepLoadType,clases);
				
		procesogenerarsaldos.setTipoTransaccionModulo(procesogenerarsaldosDataAccess.getTipoTransaccionModulo(connexion,procesogenerarsaldos));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(procesogenerarsaldos.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				procesogenerarsaldos.setEmpresa(procesogenerarsaldosDataAccess.getEmpresa(connexion,procesogenerarsaldos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(procesogenerarsaldos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesogenerarsaldos.setSucursal(procesogenerarsaldosDataAccess.getSucursal(connexion,procesogenerarsaldos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(procesogenerarsaldos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				procesogenerarsaldos.setEjercicio(procesogenerarsaldosDataAccess.getEjercicio(connexion,procesogenerarsaldos));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(procesogenerarsaldos.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Periodo.class)) {
				procesogenerarsaldos.setPeriodo(procesogenerarsaldosDataAccess.getPeriodo(connexion,procesogenerarsaldos));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(procesogenerarsaldos.getPeriodo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				procesogenerarsaldos.setTipoTransaccionModulo(procesogenerarsaldosDataAccess.getTipoTransaccionModulo(connexion,procesogenerarsaldos));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(procesogenerarsaldos.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
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
			procesogenerarsaldos.setEmpresa(procesogenerarsaldosDataAccess.getEmpresa(connexion,procesogenerarsaldos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(procesogenerarsaldos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogenerarsaldos.setSucursal(procesogenerarsaldosDataAccess.getSucursal(connexion,procesogenerarsaldos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(procesogenerarsaldos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogenerarsaldos.setEjercicio(procesogenerarsaldosDataAccess.getEjercicio(connexion,procesogenerarsaldos));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(procesogenerarsaldos.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogenerarsaldos.setPeriodo(procesogenerarsaldosDataAccess.getPeriodo(connexion,procesogenerarsaldos));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(procesogenerarsaldos.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesogenerarsaldos.setTipoTransaccionModulo(procesogenerarsaldosDataAccess.getTipoTransaccionModulo(connexion,procesogenerarsaldos));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(procesogenerarsaldos.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesogenerarsaldos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoGenerarSaldosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGenerarSaldos(procesogenerarsaldos);
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
			this.deepLoad(this.procesogenerarsaldos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoGenerarSaldosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGenerarSaldos(this.procesogenerarsaldos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesogenerarsaldoss!=null) {
				for(ProcesoGenerarSaldos procesogenerarsaldos:procesogenerarsaldoss) {
					this.deepLoad(procesogenerarsaldos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoGenerarSaldosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGenerarSaldos(procesogenerarsaldoss);
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
			if(procesogenerarsaldoss!=null) {
				for(ProcesoGenerarSaldos procesogenerarsaldos:procesogenerarsaldoss) {
					this.deepLoad(procesogenerarsaldos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoGenerarSaldosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoGenerarSaldos(procesogenerarsaldoss);
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
	
	public ProcesoGenerarSaldosParameterReturnGeneral procesarAccionProcesoGenerarSaldoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoGenerarSaldos> procesogenerarsaldoss,ProcesoGenerarSaldosParameterReturnGeneral procesogenerarsaldosParameterGeneral)throws Exception {
		 try {	
			ProcesoGenerarSaldosParameterReturnGeneral procesogenerarsaldosReturnGeneral=new ProcesoGenerarSaldosParameterReturnGeneral();
	
			ProcesoGenerarSaldosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesogenerarsaldoss,procesogenerarsaldosParameterGeneral,procesogenerarsaldosReturnGeneral);
			
			return procesogenerarsaldosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoGenerarSaldosParameterReturnGeneral procesarAccionProcesoGenerarSaldossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoGenerarSaldos> procesogenerarsaldoss,ProcesoGenerarSaldosParameterReturnGeneral procesogenerarsaldosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoGenerarSaldosParameterReturnGeneral procesogenerarsaldosReturnGeneral=new ProcesoGenerarSaldosParameterReturnGeneral();
	
			ProcesoGenerarSaldosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesogenerarsaldoss,procesogenerarsaldosParameterGeneral,procesogenerarsaldosReturnGeneral);
			
			this.connexion.commit();
			
			return procesogenerarsaldosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

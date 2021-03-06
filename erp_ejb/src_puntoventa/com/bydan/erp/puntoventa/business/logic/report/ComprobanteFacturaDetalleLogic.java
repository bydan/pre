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
package com.bydan.erp.puntoventa.business.logic.report;

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

import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.resources.general.AuxiliarGeneral;
import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaDetalleParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaDetalleParameterGeneral;
import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaDetalleConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.ComprobanteFacturaDetalle;

import com.bydan.erp.puntoventa.business.logic.report.ComprobanteFacturaDetalleLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;






@SuppressWarnings("unused")
public class ComprobanteFacturaDetalleLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ComprobanteFacturaDetalleLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ComprobanteFacturaDetalleLogic comprobantefacturadetalleDataAccess; 		
	protected ComprobanteFacturaDetalle comprobantefacturadetalle;
	protected List<ComprobanteFacturaDetalle> comprobantefacturadetalles;
	protected Object comprobantefacturadetalleObject;	
	protected List<Object> comprobantefacturadetallesObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ComprobanteFacturaDetalleLogic()throws SQLException,Exception {
		try	{
			this.comprobantefacturadetalles= new ArrayList<ComprobanteFacturaDetalle>();
			this.comprobantefacturadetalle= new ComprobanteFacturaDetalle();
			this.comprobantefacturadetalleObject=new Object();
			this.comprobantefacturadetallesObject=new ArrayList<Object>();
			
			this.comprobantefacturadetalleDataAccess=this;
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
			this.comprobantefacturadetalleDataAccess.setConnexionType(this.connexionType);
			this.comprobantefacturadetalleDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobantefacturadetalleDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComprobanteFacturaDetalleLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.comprobantefacturadetalles= new ArrayList<ComprobanteFacturaDetalle>();
			this.comprobantefacturadetalle= new ComprobanteFacturaDetalle();
			this.comprobantefacturadetalleObject=new Object();
			this.comprobantefacturadetallesObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.comprobantefacturadetalleDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.comprobantefacturadetalleDataAccess.setConnexionType(this.connexionType);
			this.comprobantefacturadetalleDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobantefacturadetalleDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComprobanteFacturaDetalle getComprobanteFacturaDetalle() throws Exception {	
		ComprobanteFacturaDetalleLogicAdditional.checkComprobanteFacturaDetalleToGet(comprobantefacturadetalle,this.datosCliente,this.arrDatoGeneral);
		ComprobanteFacturaDetalleLogicAdditional.updateComprobanteFacturaDetalleToGet(comprobantefacturadetalle,this.arrDatoGeneral);
		
		return comprobantefacturadetalle;
	}
		
	public void setComprobanteFacturaDetalle(ComprobanteFacturaDetalle newComprobanteFacturaDetalle) {
		this.comprobantefacturadetalle = newComprobanteFacturaDetalle;
	}
	
	public List<ComprobanteFacturaDetalle> getComprobanteFacturaDetalles() throws Exception {		
		this.quitarComprobanteFacturaDetallesNulos();
		
		ComprobanteFacturaDetalleLogicAdditional.checkComprobanteFacturaDetalleToGets(comprobantefacturadetalles,this.datosCliente,this.arrDatoGeneral);
		
		for (ComprobanteFacturaDetalle comprobantefacturadetalleLocal: comprobantefacturadetalles ) {
			ComprobanteFacturaDetalleLogicAdditional.updateComprobanteFacturaDetalleToGet(comprobantefacturadetalleLocal,this.arrDatoGeneral);
		}
		
		return comprobantefacturadetalles;
	}
	
	public void setComprobanteFacturaDetalles(List<ComprobanteFacturaDetalle> newComprobanteFacturaDetalles) {
		this.comprobantefacturadetalles = newComprobanteFacturaDetalles;
	}
	
	public Object getComprobanteFacturaDetalleObject() {	
		//this.comprobantefacturadetalleObject=this.comprobantefacturadetalleDataAccess.getEntityObject();
		return this.comprobantefacturadetalleObject;
	}
		
	public void setComprobanteFacturaDetalleObject(Object newComprobanteFacturaDetalleObject) {
		this.comprobantefacturadetalleObject = newComprobanteFacturaDetalleObject;
	}
	
	public List<Object> getComprobanteFacturaDetallesObject() {		
		//this.comprobantefacturadetallesObject=this.comprobantefacturadetalleDataAccess.getEntitiesObject();
		return this.comprobantefacturadetallesObject;
	}
		
	public void setComprobanteFacturaDetallesObject(List<Object> newComprobanteFacturaDetallesObject) {
		this.comprobantefacturadetallesObject = newComprobanteFacturaDetallesObject;
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
		comprobantefacturadetalles = new  ArrayList<ComprobanteFacturaDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFacturaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturadetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		comprobantefacturadetalles = new  ArrayList<ComprobanteFacturaDetalle>();
		  		  
        try {
			//ComprobanteFacturaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturadetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comprobantefacturadetalles = new  ArrayList<ComprobanteFacturaDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFacturaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturadetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobantefacturadetalles = new  ArrayList<ComprobanteFacturaDetalle>();
		  		  
        try {
			//ComprobanteFacturaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturadetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		comprobantefacturadetalles = new  ArrayList<ComprobanteFacturaDetalle>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFacturaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturadetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobantefacturadetalles = new  ArrayList<ComprobanteFacturaDetalle>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ComprobanteFacturaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturadetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ComprobanteFacturaDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFacturaDetalle> entities = new  ArrayList<ComprobanteFacturaDetalle>();
		ComprobanteFacturaDetalle entity = new ComprobanteFacturaDetalle();		  
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
	
	public  List<ComprobanteFacturaDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFacturaDetalle> entities = new  ArrayList<ComprobanteFacturaDetalle>();
		ComprobanteFacturaDetalle entity = new ComprobanteFacturaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobanteFacturaDetalle();
				
				
      	    	entity=ComprobanteFacturaDetalleLogic.getEntityComprobanteFacturaDetalle("",entity,resultSet);
      	    	
				//entity.setComprobanteFacturaDetalleOriginal( new ComprobanteFacturaDetalle());
      	    	//entity.setComprobanteFacturaDetalleOriginal(super.getEntity("",entity.getComprobanteFacturaDetalleOriginal(),resultSet,ComprobanteFacturaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComprobanteFacturaDetalleOriginal(ComprobanteFacturaDetalleDataAccess.getEntityComprobanteFacturaDetalle("",entity.getComprobanteFacturaDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ComprobanteFacturaDetalle> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFacturaDetalle> entities = new  ArrayList<ComprobanteFacturaDetalle>();
		ComprobanteFacturaDetalle entity = new ComprobanteFacturaDetalle();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ComprobanteFacturaDetalle.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobanteFacturaDetalle>((List<ComprobanteFacturaDetalle>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobanteFacturaDetallesOriginal(entities);
			
			}  else {
				this.comprobantefacturadetallesObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobanteFacturaDetalleConstantesFunciones.quitarEspaciosComprobanteFacturaDetalles(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ComprobanteFacturaDetalle getEntityComprobanteFacturaDetalle(String strPrefijo,ComprobanteFacturaDetalle entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_cliente(resultSet.getLong(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.IDCLIENTE));
			entity.setsecuencial(resultSet.getString(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.SECUENCIAL));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.FECHA).getTime()));
			entity.setnombre_cliente(resultSet.getString(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.NOMBRECLIENTE));
			entity.setdescuento(resultSet.getDouble(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO));
			entity.setsubtotal(resultSet.getDouble(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL));
			entity.settotal(resultSet.getDouble(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.TOTAL));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_producto(resultSet.getString(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.NOMBREPRODUCTO));
			entity.setcantidad(resultSet.getInt(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.CANTIDAD));
			entity.setprecio(resultSet.getDouble(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.PRECIO));
			entity.setdescuento_producto(resultSet.getDouble(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO));
			entity.setiva(resultSet.getDouble(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.IVA));
			entity.setserie(resultSet.getString(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.SERIE));
			entity.setdescripcion(resultSet.getString(strPrefijo+ComprobanteFacturaDetalleConstantesFunciones.DESCRIPCION));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComprobanteFacturaDetalle getEntityComprobanteFacturaDetalle(String strPrefijo,ComprobanteFacturaDetalle entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ComprobanteFacturaDetalle.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ComprobanteFacturaDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ComprobanteFacturaDetalleLogic.setFieldReflectionComprobanteFacturaDetalle(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComprobanteFacturaDetalle(Field field,String strPrefijo,String sColumn,ComprobanteFacturaDetalle entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComprobanteFacturaDetalleConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFacturaDetalleConstantesFunciones.DESCRIPCION:
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
	
	public void quitarComprobanteFacturaDetallesNulos() throws Exception {				
		
		List<ComprobanteFacturaDetalle> comprobantefacturadetallesAux= new ArrayList<ComprobanteFacturaDetalle>();
		
		for(ComprobanteFacturaDetalle comprobantefacturadetalle:comprobantefacturadetalles) {
			if(comprobantefacturadetalle!=null) {
				comprobantefacturadetallesAux.add(comprobantefacturadetalle);
			}
		}
		
		comprobantefacturadetalles=comprobantefacturadetallesAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ComprobanteFacturaDetalle> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFacturaDetalle> entities = new  ArrayList<ComprobanteFacturaDetalle>();
		ComprobanteFacturaDetalle entity = new ComprobanteFacturaDetalle();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobanteFacturaDetalle>((List<ComprobanteFacturaDetalle>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobanteFacturaDetallesOriginal(entities);
			
			}  else {
				this.comprobantefacturadetallesObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobanteFacturaDetalleConstantesFunciones.quitarEspaciosComprobanteFacturaDetalles(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		comprobantefacturadetalles = new  ArrayList<ComprobanteFacturaDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFacturaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturadetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		comprobantefacturadetalles = new  ArrayList<ComprobanteFacturaDetalle>();
		  		  
        try {
			//ComprobanteFacturaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturadetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ComprobanteFacturaDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobanteFacturaDetalle> entities = new  ArrayList<ComprobanteFacturaDetalle>();
		ComprobanteFacturaDetalle entity = new ComprobanteFacturaDetalle();		  
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
	
	public  List<ComprobanteFacturaDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobanteFacturaDetalle> entities = new  ArrayList<ComprobanteFacturaDetalle>();
		ComprobanteFacturaDetalle entity = new ComprobanteFacturaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobanteFacturaDetalle();
				
				if(conMapGenerico) {
					entity.setMapComprobanteFacturaDetalle( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapComprobanteFacturaDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComprobanteFacturaDetalleDataAccess.ISWITHSCHEMA);         		
					entity=ComprobanteFacturaDetalleLogic.getEntityComprobanteFacturaDetalle("",entity,resultSet,listColumns);
					
					////entity.setComprobanteFacturaDetalleOriginal( new ComprobanteFacturaDetalle());
					////entity.setComprobanteFacturaDetalleOriginal(super.getEntity("",entity.getComprobanteFacturaDetalleOriginal(),resultSet,ComprobanteFacturaDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setComprobanteFacturaDetalleOriginal(ComprobanteFacturaDetalleDataAccess.getEntityComprobanteFacturaDetalle("",entity.getComprobanteFacturaDetalleOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ComprobanteFacturaDetalle relcomprobantefacturadetalle)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcomprobantefacturadetalle.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ComprobanteFacturaDetalle relcomprobantefacturadetalle)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relcomprobantefacturadetalle.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,ComprobanteFacturaDetalle relcomprobantefacturadetalle)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relcomprobantefacturadetalle.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


	
	
	public void getComprobanteFacturaDetallesBusquedaComprobanteFacturaDetalleWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//ComprobanteFacturaDetalleLogic comprobantefacturadetalleLogic=new ComprobanteFacturaDetalleLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobanteFacturaDetalleLogic.GetSelecSqlComprobanteFacturaDetalle(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobantefacturadetalles=this.getComprobanteFacturaDetalles();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getComprobanteFacturaDetallesBusquedaComprobanteFacturaDetalle(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//ComprobanteFacturaDetalleLogic comprobantefacturadetalleLogic=new ComprobanteFacturaDetalleLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobanteFacturaDetalleLogic.GetSelecSqlComprobanteFacturaDetalle(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobantefacturadetalles=this.getComprobanteFacturaDetalles();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlComprobanteFacturaDetalle(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ComprobanteFacturaDetalle_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" f.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(fecha_inicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_inicio)+"'";
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
	
	
	public void deepLoad(ComprobanteFacturaDetalle comprobantefacturadetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComprobanteFacturaDetalleLogicAdditional.updateComprobanteFacturaDetalleToGet(comprobantefacturadetalle,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobantefacturadetalle.setEmpresa(comprobantefacturadetalleDataAccess.getEmpresa(connexion,comprobantefacturadetalle));
		comprobantefacturadetalle.setSucursal(comprobantefacturadetalleDataAccess.getSucursal(connexion,comprobantefacturadetalle));
		comprobantefacturadetalle.setCliente(comprobantefacturadetalleDataAccess.getCliente(connexion,comprobantefacturadetalle));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobantefacturadetalle.setEmpresa(comprobantefacturadetalleDataAccess.getEmpresa(connexion,comprobantefacturadetalle));
			}

			if(clas.clas.equals(Sucursal.class)) {
				comprobantefacturadetalle.setSucursal(comprobantefacturadetalleDataAccess.getSucursal(connexion,comprobantefacturadetalle));
			}

			if(clas.clas.equals(Cliente.class)) {
				comprobantefacturadetalle.setCliente(comprobantefacturadetalleDataAccess.getCliente(connexion,comprobantefacturadetalle));
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
			comprobantefacturadetalle.setEmpresa(comprobantefacturadetalleDataAccess.getEmpresa(connexion,comprobantefacturadetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefacturadetalle.setSucursal(comprobantefacturadetalleDataAccess.getSucursal(connexion,comprobantefacturadetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefacturadetalle.setCliente(comprobantefacturadetalleDataAccess.getCliente(connexion,comprobantefacturadetalle));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobantefacturadetalle.setEmpresa(comprobantefacturadetalleDataAccess.getEmpresa(connexion,comprobantefacturadetalle));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comprobantefacturadetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
		comprobantefacturadetalle.setSucursal(comprobantefacturadetalleDataAccess.getSucursal(connexion,comprobantefacturadetalle));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(comprobantefacturadetalle.getSucursal(),isDeep,deepLoadType,clases);
				
		comprobantefacturadetalle.setCliente(comprobantefacturadetalleDataAccess.getCliente(connexion,comprobantefacturadetalle));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(comprobantefacturadetalle.getCliente(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobantefacturadetalle.setEmpresa(comprobantefacturadetalleDataAccess.getEmpresa(connexion,comprobantefacturadetalle));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comprobantefacturadetalle.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				comprobantefacturadetalle.setSucursal(comprobantefacturadetalleDataAccess.getSucursal(connexion,comprobantefacturadetalle));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(comprobantefacturadetalle.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				comprobantefacturadetalle.setCliente(comprobantefacturadetalleDataAccess.getCliente(connexion,comprobantefacturadetalle));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(comprobantefacturadetalle.getCliente(),isDeep,deepLoadType,clases);				
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
			comprobantefacturadetalle.setEmpresa(comprobantefacturadetalleDataAccess.getEmpresa(connexion,comprobantefacturadetalle));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comprobantefacturadetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefacturadetalle.setSucursal(comprobantefacturadetalleDataAccess.getSucursal(connexion,comprobantefacturadetalle));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(comprobantefacturadetalle.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefacturadetalle.setCliente(comprobantefacturadetalleDataAccess.getCliente(connexion,comprobantefacturadetalle));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(comprobantefacturadetalle.getCliente(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(comprobantefacturadetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobanteFacturaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFacturaDetalle(comprobantefacturadetalle);
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
			this.deepLoad(this.comprobantefacturadetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobanteFacturaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFacturaDetalle(this.comprobantefacturadetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(comprobantefacturadetalles!=null) {
				for(ComprobanteFacturaDetalle comprobantefacturadetalle:comprobantefacturadetalles) {
					this.deepLoad(comprobantefacturadetalle,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComprobanteFacturaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFacturaDetalle(comprobantefacturadetalles);
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
			if(comprobantefacturadetalles!=null) {
				for(ComprobanteFacturaDetalle comprobantefacturadetalle:comprobantefacturadetalles) {
					this.deepLoad(comprobantefacturadetalle,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComprobanteFacturaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFacturaDetalle(comprobantefacturadetalles);
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
	
	public ComprobanteFacturaDetalleParameterReturnGeneral procesarAccionComprobanteFacturaDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobanteFacturaDetalle> comprobantefacturadetalles,ComprobanteFacturaDetalleParameterReturnGeneral comprobantefacturadetalleParameterGeneral)throws Exception {
		 try {	
			ComprobanteFacturaDetalleParameterReturnGeneral comprobantefacturadetalleReturnGeneral=new ComprobanteFacturaDetalleParameterReturnGeneral();
	
			ComprobanteFacturaDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobantefacturadetalles,comprobantefacturadetalleParameterGeneral,comprobantefacturadetalleReturnGeneral);
			
			return comprobantefacturadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComprobanteFacturaDetalleParameterReturnGeneral procesarAccionComprobanteFacturaDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobanteFacturaDetalle> comprobantefacturadetalles,ComprobanteFacturaDetalleParameterReturnGeneral comprobantefacturadetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ComprobanteFacturaDetalleParameterReturnGeneral comprobantefacturadetalleReturnGeneral=new ComprobanteFacturaDetalleParameterReturnGeneral();
	
			ComprobanteFacturaDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobantefacturadetalles,comprobantefacturadetalleParameterGeneral,comprobantefacturadetalleReturnGeneral);
			
			this.connexion.commit();
			
			return comprobantefacturadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

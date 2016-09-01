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
import com.bydan.erp.tesoreria.util.report.DetallesIngresosFacturasParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.DetallesIngresosFacturasParameterGeneral;
import com.bydan.erp.tesoreria.util.report.DetallesIngresosFacturasConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.DetallesIngresosFacturas;

import com.bydan.erp.tesoreria.business.logic.report.DetallesIngresosFacturasLogicAdditional;
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
public class DetallesIngresosFacturasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(DetallesIngresosFacturasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected DetallesIngresosFacturasLogic detallesingresosfacturasDataAccess; 		
	protected DetallesIngresosFacturas detallesingresosfacturas;
	protected List<DetallesIngresosFacturas> detallesingresosfacturass;
	protected Object detallesingresosfacturasObject;	
	protected List<Object> detallesingresosfacturassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  DetallesIngresosFacturasLogic()throws SQLException,Exception {
		try	{
			this.detallesingresosfacturass= new ArrayList<DetallesIngresosFacturas>();
			this.detallesingresosfacturas= new DetallesIngresosFacturas();
			this.detallesingresosfacturasObject=new Object();
			this.detallesingresosfacturassObject=new ArrayList<Object>();
			
			this.detallesingresosfacturasDataAccess=this;
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
			this.detallesingresosfacturasDataAccess.setConnexionType(this.connexionType);
			this.detallesingresosfacturasDataAccess.setParameterDbType(this.parameterDbType);
			this.detallesingresosfacturasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetallesIngresosFacturasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.detallesingresosfacturass= new ArrayList<DetallesIngresosFacturas>();
			this.detallesingresosfacturas= new DetallesIngresosFacturas();
			this.detallesingresosfacturasObject=new Object();
			this.detallesingresosfacturassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.detallesingresosfacturasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.detallesingresosfacturasDataAccess.setConnexionType(this.connexionType);
			this.detallesingresosfacturasDataAccess.setParameterDbType(this.parameterDbType);
			this.detallesingresosfacturasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetallesIngresosFacturas getDetallesIngresosFacturas() throws Exception {	
		DetallesIngresosFacturasLogicAdditional.checkDetallesIngresosFacturasToGet(detallesingresosfacturas,this.datosCliente,this.arrDatoGeneral);
		DetallesIngresosFacturasLogicAdditional.updateDetallesIngresosFacturasToGet(detallesingresosfacturas,this.arrDatoGeneral);
		
		return detallesingresosfacturas;
	}
		
	public void setDetallesIngresosFacturas(DetallesIngresosFacturas newDetallesIngresosFacturas) {
		this.detallesingresosfacturas = newDetallesIngresosFacturas;
	}
	
	public List<DetallesIngresosFacturas> getDetallesIngresosFacturass() throws Exception {		
		this.quitarDetallesIngresosFacturassNulos();
		
		DetallesIngresosFacturasLogicAdditional.checkDetallesIngresosFacturasToGets(detallesingresosfacturass,this.datosCliente,this.arrDatoGeneral);
		
		for (DetallesIngresosFacturas detallesingresosfacturasLocal: detallesingresosfacturass ) {
			DetallesIngresosFacturasLogicAdditional.updateDetallesIngresosFacturasToGet(detallesingresosfacturasLocal,this.arrDatoGeneral);
		}
		
		return detallesingresosfacturass;
	}
	
	public void setDetallesIngresosFacturass(List<DetallesIngresosFacturas> newDetallesIngresosFacturass) {
		this.detallesingresosfacturass = newDetallesIngresosFacturass;
	}
	
	public Object getDetallesIngresosFacturasObject() {	
		//this.detallesingresosfacturasObject=this.detallesingresosfacturasDataAccess.getEntityObject();
		return this.detallesingresosfacturasObject;
	}
		
	public void setDetallesIngresosFacturasObject(Object newDetallesIngresosFacturasObject) {
		this.detallesingresosfacturasObject = newDetallesIngresosFacturasObject;
	}
	
	public List<Object> getDetallesIngresosFacturassObject() {		
		//this.detallesingresosfacturassObject=this.detallesingresosfacturasDataAccess.getEntitiesObject();
		return this.detallesingresosfacturassObject;
	}
		
	public void setDetallesIngresosFacturassObject(List<Object> newDetallesIngresosFacturassObject) {
		this.detallesingresosfacturassObject = newDetallesIngresosFacturassObject;
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
		detallesingresosfacturass = new  ArrayList<DetallesIngresosFacturas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DetallesIngresosFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallesingresosfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		detallesingresosfacturass = new  ArrayList<DetallesIngresosFacturas>();
		  		  
        try {
			//DetallesIngresosFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallesingresosfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallesingresosfacturass = new  ArrayList<DetallesIngresosFacturas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DetallesIngresosFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallesingresosfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		detallesingresosfacturass = new  ArrayList<DetallesIngresosFacturas>();
		  		  
        try {
			//DetallesIngresosFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallesingresosfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		detallesingresosfacturass = new  ArrayList<DetallesIngresosFacturas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DetallesIngresosFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallesingresosfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		detallesingresosfacturass = new  ArrayList<DetallesIngresosFacturas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//DetallesIngresosFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallesingresosfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<DetallesIngresosFacturas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallesIngresosFacturas> entities = new  ArrayList<DetallesIngresosFacturas>();
		DetallesIngresosFacturas entity = new DetallesIngresosFacturas();		  
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
	
	public  List<DetallesIngresosFacturas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallesIngresosFacturas> entities = new  ArrayList<DetallesIngresosFacturas>();
		DetallesIngresosFacturas entity = new DetallesIngresosFacturas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallesIngresosFacturas();
				
				
      	    	entity=DetallesIngresosFacturasLogic.getEntityDetallesIngresosFacturas("",entity,resultSet);
      	    	
				//entity.setDetallesIngresosFacturasOriginal( new DetallesIngresosFacturas());
      	    	//entity.setDetallesIngresosFacturasOriginal(super.getEntity("",entity.getDetallesIngresosFacturasOriginal(),resultSet,DetallesIngresosFacturasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallesIngresosFacturasOriginal(DetallesIngresosFacturasDataAccess.getEntityDetallesIngresosFacturas("",entity.getDetallesIngresosFacturasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<DetallesIngresosFacturas> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallesIngresosFacturas> entities = new  ArrayList<DetallesIngresosFacturas>();
		DetallesIngresosFacturas entity = new DetallesIngresosFacturas();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,DetallesIngresosFacturas.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DetallesIngresosFacturas>((List<DetallesIngresosFacturas>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDetallesIngresosFacturassOriginal(entities);
			
			}  else {
				this.detallesingresosfacturassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DetallesIngresosFacturasConstantesFunciones.quitarEspaciosDetallesIngresosFacturass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static DetallesIngresosFacturas getEntityDetallesIngresosFacturas(String strPrefijo,DetallesIngresosFacturas entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+DetallesIngresosFacturasConstantesFunciones.FECHA).getTime()));
			entity.settipo_movimiento(resultSet.getString(strPrefijo+DetallesIngresosFacturasConstantesFunciones.TIPOMOVIMIENTO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+DetallesIngresosFacturasConstantesFunciones.NUMEROMAYOR));
			entity.setnumero_factura(resultSet.getString(strPrefijo+DetallesIngresosFacturasConstantesFunciones.NUMEROFACTURA));
			entity.setnombre_cliente(resultSet.getString(strPrefijo+DetallesIngresosFacturasConstantesFunciones.NOMBRECLIENTE));
			entity.setsiglas_pago(resultSet.getString(strPrefijo+DetallesIngresosFacturasConstantesFunciones.SIGLASPAGO));
			entity.setnombre_pago(resultSet.getString(strPrefijo+DetallesIngresosFacturasConstantesFunciones.NOMBREPAGO));
			entity.setcodigo(resultSet.getString(strPrefijo+DetallesIngresosFacturasConstantesFunciones.CODIGO));
			entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetallesIngresosFacturas getEntityDetallesIngresosFacturas(String strPrefijo,DetallesIngresosFacturas entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = DetallesIngresosFacturas.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = DetallesIngresosFacturas.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				DetallesIngresosFacturasLogic.setFieldReflectionDetallesIngresosFacturas(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetallesIngresosFacturas(Field field,String strPrefijo,String sColumn,DetallesIngresosFacturas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetallesIngresosFacturasConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetallesIngresosFacturasConstantesFunciones.TIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallesIngresosFacturasConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallesIngresosFacturasConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallesIngresosFacturasConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallesIngresosFacturasConstantesFunciones.SIGLASPAGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallesIngresosFacturasConstantesFunciones.NOMBREPAGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallesIngresosFacturasConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL:
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
	
	public void quitarDetallesIngresosFacturassNulos() throws Exception {				
		
		List<DetallesIngresosFacturas> detallesingresosfacturassAux= new ArrayList<DetallesIngresosFacturas>();
		
		for(DetallesIngresosFacturas detallesingresosfacturas:detallesingresosfacturass) {
			if(detallesingresosfacturas!=null) {
				detallesingresosfacturassAux.add(detallesingresosfacturas);
			}
		}
		
		detallesingresosfacturass=detallesingresosfacturassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<DetallesIngresosFacturas> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallesIngresosFacturas> entities = new  ArrayList<DetallesIngresosFacturas>();
		DetallesIngresosFacturas entity = new DetallesIngresosFacturas();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DetallesIngresosFacturas>((List<DetallesIngresosFacturas>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDetallesIngresosFacturassOriginal(entities);
			
			}  else {
				this.detallesingresosfacturassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DetallesIngresosFacturasConstantesFunciones.quitarEspaciosDetallesIngresosFacturass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		detallesingresosfacturass = new  ArrayList<DetallesIngresosFacturas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DetallesIngresosFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallesingresosfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		detallesingresosfacturass = new  ArrayList<DetallesIngresosFacturas>();
		  		  
        try {
			//DetallesIngresosFacturasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallesingresosfacturass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<DetallesIngresosFacturas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallesIngresosFacturas> entities = new  ArrayList<DetallesIngresosFacturas>();
		DetallesIngresosFacturas entity = new DetallesIngresosFacturas();		  
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
	
	public  List<DetallesIngresosFacturas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallesIngresosFacturas> entities = new  ArrayList<DetallesIngresosFacturas>();
		DetallesIngresosFacturas entity = new DetallesIngresosFacturas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallesIngresosFacturas();
				
				if(conMapGenerico) {
					entity.setMapDetallesIngresosFacturas( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapDetallesIngresosFacturas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallesIngresosFacturasDataAccess.ISWITHSCHEMA);         		
					entity=DetallesIngresosFacturasLogic.getEntityDetallesIngresosFacturas("",entity,resultSet,listColumns);
					
					////entity.setDetallesIngresosFacturasOriginal( new DetallesIngresosFacturas());
					////entity.setDetallesIngresosFacturasOriginal(super.getEntity("",entity.getDetallesIngresosFacturasOriginal(),resultSet,DetallesIngresosFacturasDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallesIngresosFacturasOriginal(DetallesIngresosFacturasDataAccess.getEntityDetallesIngresosFacturas("",entity.getDetallesIngresosFacturasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,DetallesIngresosFacturas reldetallesingresosfacturas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reldetallesingresosfacturas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetallesIngresosFacturas reldetallesingresosfacturas)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallesingresosfacturas.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetallesIngresosFacturas reldetallesingresosfacturas)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallesingresosfacturas.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}


	
	
	public void getDetallesIngresosFacturassBusquedaDetallesIngresosFacturasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio)throws Exception {
		try {
			//DetallesIngresosFacturasLogic detallesingresosfacturasLogic=new DetallesIngresosFacturasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DetallesIngresosFacturasLogic.GetSelecSqlDetallesIngresosFacturas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.detallesingresosfacturass=this.getDetallesIngresosFacturass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getDetallesIngresosFacturassBusquedaDetallesIngresosFacturas(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio)throws Exception {
		try {
			//DetallesIngresosFacturasLogic detallesingresosfacturasLogic=new DetallesIngresosFacturasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DetallesIngresosFacturasLogic.GetSelecSqlDetallesIngresosFacturas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.detallesingresosfacturass=this.getDetallesIngresosFacturass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlDetallesIngresosFacturas(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("DetallesIngresosFacturas_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" a.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_ejercicio = "+id_ejercicio.toString();
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
	
	
	public void deepLoad(DetallesIngresosFacturas detallesingresosfacturas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetallesIngresosFacturasLogicAdditional.updateDetallesIngresosFacturasToGet(detallesingresosfacturas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallesingresosfacturas.setEmpresa(detallesingresosfacturasDataAccess.getEmpresa(connexion,detallesingresosfacturas));
		detallesingresosfacturas.setSucursal(detallesingresosfacturasDataAccess.getSucursal(connexion,detallesingresosfacturas));
		detallesingresosfacturas.setEjercicio(detallesingresosfacturasDataAccess.getEjercicio(connexion,detallesingresosfacturas));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallesingresosfacturas.setEmpresa(detallesingresosfacturasDataAccess.getEmpresa(connexion,detallesingresosfacturas));
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallesingresosfacturas.setSucursal(detallesingresosfacturasDataAccess.getSucursal(connexion,detallesingresosfacturas));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallesingresosfacturas.setEjercicio(detallesingresosfacturasDataAccess.getEjercicio(connexion,detallesingresosfacturas));
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
			detallesingresosfacturas.setEmpresa(detallesingresosfacturasDataAccess.getEmpresa(connexion,detallesingresosfacturas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallesingresosfacturas.setSucursal(detallesingresosfacturasDataAccess.getSucursal(connexion,detallesingresosfacturas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallesingresosfacturas.setEjercicio(detallesingresosfacturasDataAccess.getEjercicio(connexion,detallesingresosfacturas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallesingresosfacturas.setEmpresa(detallesingresosfacturasDataAccess.getEmpresa(connexion,detallesingresosfacturas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallesingresosfacturas.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallesingresosfacturas.setSucursal(detallesingresosfacturasDataAccess.getSucursal(connexion,detallesingresosfacturas));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallesingresosfacturas.getSucursal(),isDeep,deepLoadType,clases);
				
		detallesingresosfacturas.setEjercicio(detallesingresosfacturasDataAccess.getEjercicio(connexion,detallesingresosfacturas));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallesingresosfacturas.getEjercicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallesingresosfacturas.setEmpresa(detallesingresosfacturasDataAccess.getEmpresa(connexion,detallesingresosfacturas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallesingresosfacturas.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallesingresosfacturas.setSucursal(detallesingresosfacturasDataAccess.getSucursal(connexion,detallesingresosfacturas));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallesingresosfacturas.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallesingresosfacturas.setEjercicio(detallesingresosfacturasDataAccess.getEjercicio(connexion,detallesingresosfacturas));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallesingresosfacturas.getEjercicio(),isDeep,deepLoadType,clases);				
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
			detallesingresosfacturas.setEmpresa(detallesingresosfacturasDataAccess.getEmpresa(connexion,detallesingresosfacturas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallesingresosfacturas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallesingresosfacturas.setSucursal(detallesingresosfacturasDataAccess.getSucursal(connexion,detallesingresosfacturas));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallesingresosfacturas.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallesingresosfacturas.setEjercicio(detallesingresosfacturasDataAccess.getEjercicio(connexion,detallesingresosfacturas));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallesingresosfacturas.getEjercicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(detallesingresosfacturas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallesIngresosFacturasConstantesFunciones.refrescarForeignKeysDescripcionesDetallesIngresosFacturas(detallesingresosfacturas);
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
			this.deepLoad(this.detallesingresosfacturas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallesIngresosFacturasConstantesFunciones.refrescarForeignKeysDescripcionesDetallesIngresosFacturas(this.detallesingresosfacturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(detallesingresosfacturass!=null) {
				for(DetallesIngresosFacturas detallesingresosfacturas:detallesingresosfacturass) {
					this.deepLoad(detallesingresosfacturas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetallesIngresosFacturasConstantesFunciones.refrescarForeignKeysDescripcionesDetallesIngresosFacturas(detallesingresosfacturass);
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
			if(detallesingresosfacturass!=null) {
				for(DetallesIngresosFacturas detallesingresosfacturas:detallesingresosfacturass) {
					this.deepLoad(detallesingresosfacturas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetallesIngresosFacturasConstantesFunciones.refrescarForeignKeysDescripcionesDetallesIngresosFacturas(detallesingresosfacturass);
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
	
	public DetallesIngresosFacturasParameterReturnGeneral procesarAccionDetallesIngresosFacturass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallesIngresosFacturas> detallesingresosfacturass,DetallesIngresosFacturasParameterReturnGeneral detallesingresosfacturasParameterGeneral)throws Exception {
		 try {	
			DetallesIngresosFacturasParameterReturnGeneral detallesingresosfacturasReturnGeneral=new DetallesIngresosFacturasParameterReturnGeneral();
	
			DetallesIngresosFacturasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallesingresosfacturass,detallesingresosfacturasParameterGeneral,detallesingresosfacturasReturnGeneral);
			
			return detallesingresosfacturasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallesIngresosFacturasParameterReturnGeneral procesarAccionDetallesIngresosFacturassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallesIngresosFacturas> detallesingresosfacturass,DetallesIngresosFacturasParameterReturnGeneral detallesingresosfacturasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			DetallesIngresosFacturasParameterReturnGeneral detallesingresosfacturasReturnGeneral=new DetallesIngresosFacturasParameterReturnGeneral();
	
			DetallesIngresosFacturasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallesingresosfacturass,detallesingresosfacturasParameterGeneral,detallesingresosfacturasReturnGeneral);
			
			this.connexion.commit();
			
			return detallesingresosfacturasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

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
import com.bydan.erp.inventario.util.report.MovimientosResumidosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.MovimientosResumidosParameterGeneral;
import com.bydan.erp.inventario.util.report.MovimientosResumidosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.MovimientosResumidos;

import com.bydan.erp.inventario.business.logic.report.MovimientosResumidosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;






@SuppressWarnings("unused")
public class MovimientosResumidosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(MovimientosResumidosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected MovimientosResumidosLogic movimientosresumidosDataAccess; 		
	protected MovimientosResumidos movimientosresumidos;
	protected List<MovimientosResumidos> movimientosresumidoss;
	protected Object movimientosresumidosObject;	
	protected List<Object> movimientosresumidossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  MovimientosResumidosLogic()throws SQLException,Exception {
		try	{
			this.movimientosresumidoss= new ArrayList<MovimientosResumidos>();
			this.movimientosresumidos= new MovimientosResumidos();
			this.movimientosresumidosObject=new Object();
			this.movimientosresumidossObject=new ArrayList<Object>();
			
			this.movimientosresumidosDataAccess=this;
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
			this.movimientosresumidosDataAccess.setConnexionType(this.connexionType);
			this.movimientosresumidosDataAccess.setParameterDbType(this.parameterDbType);
			this.movimientosresumidosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MovimientosResumidosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.movimientosresumidoss= new ArrayList<MovimientosResumidos>();
			this.movimientosresumidos= new MovimientosResumidos();
			this.movimientosresumidosObject=new Object();
			this.movimientosresumidossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.movimientosresumidosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.movimientosresumidosDataAccess.setConnexionType(this.connexionType);
			this.movimientosresumidosDataAccess.setParameterDbType(this.parameterDbType);
			this.movimientosresumidosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MovimientosResumidos getMovimientosResumidos() throws Exception {	
		MovimientosResumidosLogicAdditional.checkMovimientosResumidosToGet(movimientosresumidos,this.datosCliente,this.arrDatoGeneral);
		MovimientosResumidosLogicAdditional.updateMovimientosResumidosToGet(movimientosresumidos,this.arrDatoGeneral);
		
		return movimientosresumidos;
	}
		
	public void setMovimientosResumidos(MovimientosResumidos newMovimientosResumidos) {
		this.movimientosresumidos = newMovimientosResumidos;
	}
	
	public List<MovimientosResumidos> getMovimientosResumidoss() throws Exception {		
		this.quitarMovimientosResumidossNulos();
		
		MovimientosResumidosLogicAdditional.checkMovimientosResumidosToGets(movimientosresumidoss,this.datosCliente,this.arrDatoGeneral);
		
		for (MovimientosResumidos movimientosresumidosLocal: movimientosresumidoss ) {
			MovimientosResumidosLogicAdditional.updateMovimientosResumidosToGet(movimientosresumidosLocal,this.arrDatoGeneral);
		}
		
		return movimientosresumidoss;
	}
	
	public void setMovimientosResumidoss(List<MovimientosResumidos> newMovimientosResumidoss) {
		this.movimientosresumidoss = newMovimientosResumidoss;
	}
	
	public Object getMovimientosResumidosObject() {	
		//this.movimientosresumidosObject=this.movimientosresumidosDataAccess.getEntityObject();
		return this.movimientosresumidosObject;
	}
		
	public void setMovimientosResumidosObject(Object newMovimientosResumidosObject) {
		this.movimientosresumidosObject = newMovimientosResumidosObject;
	}
	
	public List<Object> getMovimientosResumidossObject() {		
		//this.movimientosresumidossObject=this.movimientosresumidosDataAccess.getEntitiesObject();
		return this.movimientosresumidossObject;
	}
		
	public void setMovimientosResumidossObject(List<Object> newMovimientosResumidossObject) {
		this.movimientosresumidossObject = newMovimientosResumidossObject;
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
		movimientosresumidoss = new  ArrayList<MovimientosResumidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MovimientosResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		movimientosresumidoss = new  ArrayList<MovimientosResumidos>();
		  		  
        try {
			//MovimientosResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		movimientosresumidoss = new  ArrayList<MovimientosResumidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MovimientosResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		movimientosresumidoss = new  ArrayList<MovimientosResumidos>();
		  		  
        try {
			//MovimientosResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		movimientosresumidoss = new  ArrayList<MovimientosResumidos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MovimientosResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		movimientosresumidoss = new  ArrayList<MovimientosResumidos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//MovimientosResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<MovimientosResumidos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientosResumidos> entities = new  ArrayList<MovimientosResumidos>();
		MovimientosResumidos entity = new MovimientosResumidos();		  
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
	
	public  List<MovimientosResumidos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientosResumidos> entities = new  ArrayList<MovimientosResumidos>();
		MovimientosResumidos entity = new MovimientosResumidos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientosResumidos();
				
				
      	    	entity=MovimientosResumidosLogic.getEntityMovimientosResumidos("",entity,resultSet);
      	    	
				//entity.setMovimientosResumidosOriginal( new MovimientosResumidos());
      	    	//entity.setMovimientosResumidosOriginal(super.getEntity("",entity.getMovimientosResumidosOriginal(),resultSet,MovimientosResumidosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientosResumidosOriginal(MovimientosResumidosDataAccess.getEntityMovimientosResumidos("",entity.getMovimientosResumidosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<MovimientosResumidos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientosResumidos> entities = new  ArrayList<MovimientosResumidos>();
		MovimientosResumidos entity = new MovimientosResumidos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,MovimientosResumidos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<MovimientosResumidos>((List<MovimientosResumidos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setMovimientosResumidossOriginal(entities);
			
			}  else {
				this.movimientosresumidossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//MovimientosResumidosConstantesFunciones.quitarEspaciosMovimientosResumidoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static MovimientosResumidos getEntityMovimientosResumidos(String strPrefijo,MovimientosResumidos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+MovimientosResumidosConstantesFunciones.NOMBRESUCURSAL));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+MovimientosResumidosConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setnombre_transaccion(resultSet.getString(strPrefijo+MovimientosResumidosConstantesFunciones.NOMBRETRANSACCION));
			entity.setnumero_comprobante(resultSet.getString(strPrefijo+MovimientosResumidosConstantesFunciones.NUMEROCOMPROBANTE));
			entity.setnumero_factura(resultSet.getString(strPrefijo+MovimientosResumidosConstantesFunciones.NUMEROFACTURA));
			entity.settotal(resultSet.getDouble(strPrefijo+MovimientosResumidosConstantesFunciones.TOTAL));
			entity.setiva(resultSet.getDouble(strPrefijo+MovimientosResumidosConstantesFunciones.IVA));
			entity.setnumero_secuencial(resultSet.getString(strPrefijo+MovimientosResumidosConstantesFunciones.NUMEROSECUENCIAL));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+MovimientosResumidosConstantesFunciones.FECHAEMISION).getTime()));
			entity.settotal_descuento(resultSet.getDouble(strPrefijo+MovimientosResumidosConstantesFunciones.TOTALDESCUENTO));
			entity.setice(resultSet.getDouble(strPrefijo+MovimientosResumidosConstantesFunciones.ICE));
			entity.setretencion(resultSet.getDouble(strPrefijo+MovimientosResumidosConstantesFunciones.RETENCION));
			entity.settotal_otro(resultSet.getDouble(strPrefijo+MovimientosResumidosConstantesFunciones.TOTALOTRO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MovimientosResumidos getEntityMovimientosResumidos(String strPrefijo,MovimientosResumidos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = MovimientosResumidos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = MovimientosResumidos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				MovimientosResumidosLogic.setFieldReflectionMovimientosResumidos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMovimientosResumidos(Field field,String strPrefijo,String sColumn,MovimientosResumidos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MovimientosResumidosConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.NOMBRETRANSACCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MovimientosResumidosConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.RETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientosResumidosConstantesFunciones.TOTALOTRO:
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
	
	public void quitarMovimientosResumidossNulos() throws Exception {				
		
		List<MovimientosResumidos> movimientosresumidossAux= new ArrayList<MovimientosResumidos>();
		
		for(MovimientosResumidos movimientosresumidos:movimientosresumidoss) {
			if(movimientosresumidos!=null) {
				movimientosresumidossAux.add(movimientosresumidos);
			}
		}
		
		movimientosresumidoss=movimientosresumidossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<MovimientosResumidos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientosResumidos> entities = new  ArrayList<MovimientosResumidos>();
		MovimientosResumidos entity = new MovimientosResumidos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<MovimientosResumidos>((List<MovimientosResumidos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setMovimientosResumidossOriginal(entities);
			
			}  else {
				this.movimientosresumidossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//MovimientosResumidosConstantesFunciones.quitarEspaciosMovimientosResumidoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		movimientosresumidoss = new  ArrayList<MovimientosResumidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MovimientosResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		movimientosresumidoss = new  ArrayList<MovimientosResumidos>();
		  		  
        try {
			//MovimientosResumidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosresumidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<MovimientosResumidos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<MovimientosResumidos> entities = new  ArrayList<MovimientosResumidos>();
		MovimientosResumidos entity = new MovimientosResumidos();		  
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
	
	public  List<MovimientosResumidos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<MovimientosResumidos> entities = new  ArrayList<MovimientosResumidos>();
		MovimientosResumidos entity = new MovimientosResumidos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientosResumidos();
				
				if(conMapGenerico) {
					entity.setMapMovimientosResumidos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapMovimientosResumidos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MovimientosResumidosDataAccess.ISWITHSCHEMA);         		
					entity=MovimientosResumidosLogic.getEntityMovimientosResumidos("",entity,resultSet,listColumns);
					
					////entity.setMovimientosResumidosOriginal( new MovimientosResumidos());
					////entity.setMovimientosResumidosOriginal(super.getEntity("",entity.getMovimientosResumidosOriginal(),resultSet,MovimientosResumidosDataAccess.ISWITHSCHEMA));         		
					////entity.setMovimientosResumidosOriginal(MovimientosResumidosDataAccess.getEntityMovimientosResumidos("",entity.getMovimientosResumidosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,MovimientosResumidos relmovimientosresumidos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relmovimientosresumidos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,MovimientosResumidos relmovimientosresumidos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relmovimientosresumidos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Transaccion getTransaccion(Connexion connexion,MovimientosResumidos relmovimientosresumidos)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);
			transaccionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			transaccion=transaccionDataAccess.getEntity(connexion,relmovimientosresumidos.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}


	
	
	public void getMovimientosResumidossBusquedaMovimientosResumidosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//MovimientosResumidosLogic movimientosresumidosLogic=new MovimientosResumidosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=MovimientosResumidosLogic.GetSelecSqlMovimientosResumidos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_transaccion,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.movimientosresumidoss=this.getMovimientosResumidoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getMovimientosResumidossBusquedaMovimientosResumidos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//MovimientosResumidosLogic movimientosresumidosLogic=new MovimientosResumidosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=MovimientosResumidosLogic.GetSelecSqlMovimientosResumidos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_transaccion,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.movimientosresumidoss=this.getMovimientosResumidoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlMovimientosResumidos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("MovimientosResumidos_Postgres.sql");
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
				

				if(id_transaccion!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" m.id_transaccion = "+id_transaccion.toString();
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
	
	
	public void deepLoad(MovimientosResumidos movimientosresumidos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MovimientosResumidosLogicAdditional.updateMovimientosResumidosToGet(movimientosresumidos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		movimientosresumidos.setEmpresa(movimientosresumidosDataAccess.getEmpresa(connexion,movimientosresumidos));
		movimientosresumidos.setSucursal(movimientosresumidosDataAccess.getSucursal(connexion,movimientosresumidos));
		movimientosresumidos.setTransaccion(movimientosresumidosDataAccess.getTransaccion(connexion,movimientosresumidos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				movimientosresumidos.setEmpresa(movimientosresumidosDataAccess.getEmpresa(connexion,movimientosresumidos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientosresumidos.setSucursal(movimientosresumidosDataAccess.getSucursal(connexion,movimientosresumidos));
			}

			if(clas.clas.equals(Transaccion.class)) {
				movimientosresumidos.setTransaccion(movimientosresumidosDataAccess.getTransaccion(connexion,movimientosresumidos));
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
			movimientosresumidos.setEmpresa(movimientosresumidosDataAccess.getEmpresa(connexion,movimientosresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosresumidos.setSucursal(movimientosresumidosDataAccess.getSucursal(connexion,movimientosresumidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosresumidos.setTransaccion(movimientosresumidosDataAccess.getTransaccion(connexion,movimientosresumidos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		movimientosresumidos.setEmpresa(movimientosresumidosDataAccess.getEmpresa(connexion,movimientosresumidos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(movimientosresumidos.getEmpresa(),isDeep,deepLoadType,clases);
				
		movimientosresumidos.setSucursal(movimientosresumidosDataAccess.getSucursal(connexion,movimientosresumidos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(movimientosresumidos.getSucursal(),isDeep,deepLoadType,clases);
				
		movimientosresumidos.setTransaccion(movimientosresumidosDataAccess.getTransaccion(connexion,movimientosresumidos));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(movimientosresumidos.getTransaccion(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				movimientosresumidos.setEmpresa(movimientosresumidosDataAccess.getEmpresa(connexion,movimientosresumidos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(movimientosresumidos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientosresumidos.setSucursal(movimientosresumidosDataAccess.getSucursal(connexion,movimientosresumidos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(movimientosresumidos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Transaccion.class)) {
				movimientosresumidos.setTransaccion(movimientosresumidosDataAccess.getTransaccion(connexion,movimientosresumidos));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(movimientosresumidos.getTransaccion(),isDeep,deepLoadType,clases);				
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
			movimientosresumidos.setEmpresa(movimientosresumidosDataAccess.getEmpresa(connexion,movimientosresumidos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(movimientosresumidos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosresumidos.setSucursal(movimientosresumidosDataAccess.getSucursal(connexion,movimientosresumidos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(movimientosresumidos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosresumidos.setTransaccion(movimientosresumidosDataAccess.getTransaccion(connexion,movimientosresumidos));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(movimientosresumidos.getTransaccion(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(movimientosresumidos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MovimientosResumidosConstantesFunciones.refrescarForeignKeysDescripcionesMovimientosResumidos(movimientosresumidos);
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
			this.deepLoad(this.movimientosresumidos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MovimientosResumidosConstantesFunciones.refrescarForeignKeysDescripcionesMovimientosResumidos(this.movimientosresumidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(movimientosresumidoss!=null) {
				for(MovimientosResumidos movimientosresumidos:movimientosresumidoss) {
					this.deepLoad(movimientosresumidos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MovimientosResumidosConstantesFunciones.refrescarForeignKeysDescripcionesMovimientosResumidos(movimientosresumidoss);
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
			if(movimientosresumidoss!=null) {
				for(MovimientosResumidos movimientosresumidos:movimientosresumidoss) {
					this.deepLoad(movimientosresumidos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MovimientosResumidosConstantesFunciones.refrescarForeignKeysDescripcionesMovimientosResumidos(movimientosresumidoss);
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
	
	public MovimientosResumidosParameterReturnGeneral procesarAccionMovimientosResumidoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MovimientosResumidos> movimientosresumidoss,MovimientosResumidosParameterReturnGeneral movimientosresumidosParameterGeneral)throws Exception {
		 try {	
			MovimientosResumidosParameterReturnGeneral movimientosresumidosReturnGeneral=new MovimientosResumidosParameterReturnGeneral();
	
			MovimientosResumidosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,movimientosresumidoss,movimientosresumidosParameterGeneral,movimientosresumidosReturnGeneral);
			
			return movimientosresumidosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MovimientosResumidosParameterReturnGeneral procesarAccionMovimientosResumidossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MovimientosResumidos> movimientosresumidoss,MovimientosResumidosParameterReturnGeneral movimientosresumidosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			MovimientosResumidosParameterReturnGeneral movimientosresumidosReturnGeneral=new MovimientosResumidosParameterReturnGeneral();
	
			MovimientosResumidosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,movimientosresumidoss,movimientosresumidosParameterGeneral,movimientosresumidosReturnGeneral);
			
			this.connexion.commit();
			
			return movimientosresumidosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

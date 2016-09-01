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
import com.bydan.erp.inventario.util.report.MovimientosDetalladosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.MovimientosDetalladosParameterGeneral;
import com.bydan.erp.inventario.util.report.MovimientosDetalladosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.MovimientosDetallados;

import com.bydan.erp.inventario.business.logic.report.MovimientosDetalladosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;






@SuppressWarnings("unused")
public class MovimientosDetalladosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(MovimientosDetalladosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected MovimientosDetalladosLogic movimientosdetalladosDataAccess; 		
	protected MovimientosDetallados movimientosdetallados;
	protected List<MovimientosDetallados> movimientosdetalladoss;
	protected Object movimientosdetalladosObject;	
	protected List<Object> movimientosdetalladossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  MovimientosDetalladosLogic()throws SQLException,Exception {
		try	{
			this.movimientosdetalladoss= new ArrayList<MovimientosDetallados>();
			this.movimientosdetallados= new MovimientosDetallados();
			this.movimientosdetalladosObject=new Object();
			this.movimientosdetalladossObject=new ArrayList<Object>();
			
			this.movimientosdetalladosDataAccess=this;
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
			this.movimientosdetalladosDataAccess.setConnexionType(this.connexionType);
			this.movimientosdetalladosDataAccess.setParameterDbType(this.parameterDbType);
			this.movimientosdetalladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MovimientosDetalladosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.movimientosdetalladoss= new ArrayList<MovimientosDetallados>();
			this.movimientosdetallados= new MovimientosDetallados();
			this.movimientosdetalladosObject=new Object();
			this.movimientosdetalladossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.movimientosdetalladosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.movimientosdetalladosDataAccess.setConnexionType(this.connexionType);
			this.movimientosdetalladosDataAccess.setParameterDbType(this.parameterDbType);
			this.movimientosdetalladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MovimientosDetallados getMovimientosDetallados() throws Exception {	
		MovimientosDetalladosLogicAdditional.checkMovimientosDetalladosToGet(movimientosdetallados,this.datosCliente,this.arrDatoGeneral);
		MovimientosDetalladosLogicAdditional.updateMovimientosDetalladosToGet(movimientosdetallados,this.arrDatoGeneral);
		
		return movimientosdetallados;
	}
		
	public void setMovimientosDetallados(MovimientosDetallados newMovimientosDetallados) {
		this.movimientosdetallados = newMovimientosDetallados;
	}
	
	public List<MovimientosDetallados> getMovimientosDetalladoss() throws Exception {		
		this.quitarMovimientosDetalladossNulos();
		
		MovimientosDetalladosLogicAdditional.checkMovimientosDetalladosToGets(movimientosdetalladoss,this.datosCliente,this.arrDatoGeneral);
		
		for (MovimientosDetallados movimientosdetalladosLocal: movimientosdetalladoss ) {
			MovimientosDetalladosLogicAdditional.updateMovimientosDetalladosToGet(movimientosdetalladosLocal,this.arrDatoGeneral);
		}
		
		return movimientosdetalladoss;
	}
	
	public void setMovimientosDetalladoss(List<MovimientosDetallados> newMovimientosDetalladoss) {
		this.movimientosdetalladoss = newMovimientosDetalladoss;
	}
	
	public Object getMovimientosDetalladosObject() {	
		//this.movimientosdetalladosObject=this.movimientosdetalladosDataAccess.getEntityObject();
		return this.movimientosdetalladosObject;
	}
		
	public void setMovimientosDetalladosObject(Object newMovimientosDetalladosObject) {
		this.movimientosdetalladosObject = newMovimientosDetalladosObject;
	}
	
	public List<Object> getMovimientosDetalladossObject() {		
		//this.movimientosdetalladossObject=this.movimientosdetalladosDataAccess.getEntitiesObject();
		return this.movimientosdetalladossObject;
	}
		
	public void setMovimientosDetalladossObject(List<Object> newMovimientosDetalladossObject) {
		this.movimientosdetalladossObject = newMovimientosDetalladossObject;
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
		movimientosdetalladoss = new  ArrayList<MovimientosDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MovimientosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		movimientosdetalladoss = new  ArrayList<MovimientosDetallados>();
		  		  
        try {
			//MovimientosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		movimientosdetalladoss = new  ArrayList<MovimientosDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MovimientosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		movimientosdetalladoss = new  ArrayList<MovimientosDetallados>();
		  		  
        try {
			//MovimientosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		movimientosdetalladoss = new  ArrayList<MovimientosDetallados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MovimientosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		movimientosdetalladoss = new  ArrayList<MovimientosDetallados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//MovimientosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<MovimientosDetallados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientosDetallados> entities = new  ArrayList<MovimientosDetallados>();
		MovimientosDetallados entity = new MovimientosDetallados();		  
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
	
	public  List<MovimientosDetallados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientosDetallados> entities = new  ArrayList<MovimientosDetallados>();
		MovimientosDetallados entity = new MovimientosDetallados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientosDetallados();
				
				
      	    	entity=MovimientosDetalladosLogic.getEntityMovimientosDetallados("",entity,resultSet);
      	    	
				//entity.setMovimientosDetalladosOriginal( new MovimientosDetallados());
      	    	//entity.setMovimientosDetalladosOriginal(super.getEntity("",entity.getMovimientosDetalladosOriginal(),resultSet,MovimientosDetalladosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientosDetalladosOriginal(MovimientosDetalladosDataAccess.getEntityMovimientosDetallados("",entity.getMovimientosDetalladosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<MovimientosDetallados> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientosDetallados> entities = new  ArrayList<MovimientosDetallados>();
		MovimientosDetallados entity = new MovimientosDetallados();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,MovimientosDetallados.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<MovimientosDetallados>((List<MovimientosDetallados>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setMovimientosDetalladossOriginal(entities);
			
			}  else {
				this.movimientosdetalladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//MovimientosDetalladosConstantesFunciones.quitarEspaciosMovimientosDetalladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static MovimientosDetallados getEntityMovimientosDetallados(String strPrefijo,MovimientosDetallados entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+MovimientosDetalladosConstantesFunciones.NOMBRESUCURSAL));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+MovimientosDetalladosConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setnombre_transaccion(resultSet.getString(strPrefijo+MovimientosDetalladosConstantesFunciones.NOMBRETRANSACCION));
			entity.setnumero_comprobante(resultSet.getString(strPrefijo+MovimientosDetalladosConstantesFunciones.NUMEROCOMPROBANTE));
			entity.setnumero_factura(resultSet.getString(strPrefijo+MovimientosDetalladosConstantesFunciones.NUMEROFACTURA));
			entity.setnumero_secuencial(resultSet.getString(strPrefijo+MovimientosDetalladosConstantesFunciones.NUMEROSECUENCIAL));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+MovimientosDetalladosConstantesFunciones.FECHAEMISION).getTime()));
			entity.setnombre_producto(resultSet.getString(strPrefijo+MovimientosDetalladosConstantesFunciones.NOMBREPRODUCTO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+MovimientosDetalladosConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad(resultSet.getInt(strPrefijo+MovimientosDetalladosConstantesFunciones.CANTIDAD));
			entity.setiva(resultSet.getDouble(strPrefijo+MovimientosDetalladosConstantesFunciones.IVA));
			entity.setcosto_unitario(resultSet.getDouble(strPrefijo+MovimientosDetalladosConstantesFunciones.COSTOUNITARIO));
			entity.setcosto_total(resultSet.getDouble(strPrefijo+MovimientosDetalladosConstantesFunciones.COSTOTOTAL));
			entity.setice(resultSet.getDouble(strPrefijo+MovimientosDetalladosConstantesFunciones.ICE));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+MovimientosDetalladosConstantesFunciones.CODIGOPRODUCTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MovimientosDetallados getEntityMovimientosDetallados(String strPrefijo,MovimientosDetallados entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = MovimientosDetallados.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = MovimientosDetallados.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				MovimientosDetalladosLogic.setFieldReflectionMovimientosDetallados(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMovimientosDetallados(Field field,String strPrefijo,String sColumn,MovimientosDetallados entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MovimientosDetalladosConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.NOMBRETRANSACCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MovimientosDetalladosConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientosDetalladosConstantesFunciones.CODIGOPRODUCTO:
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
	
	public void quitarMovimientosDetalladossNulos() throws Exception {				
		
		List<MovimientosDetallados> movimientosdetalladossAux= new ArrayList<MovimientosDetallados>();
		
		for(MovimientosDetallados movimientosdetallados:movimientosdetalladoss) {
			if(movimientosdetallados!=null) {
				movimientosdetalladossAux.add(movimientosdetallados);
			}
		}
		
		movimientosdetalladoss=movimientosdetalladossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<MovimientosDetallados> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientosDetallados> entities = new  ArrayList<MovimientosDetallados>();
		MovimientosDetallados entity = new MovimientosDetallados();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<MovimientosDetallados>((List<MovimientosDetallados>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setMovimientosDetalladossOriginal(entities);
			
			}  else {
				this.movimientosdetalladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//MovimientosDetalladosConstantesFunciones.quitarEspaciosMovimientosDetalladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		movimientosdetalladoss = new  ArrayList<MovimientosDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MovimientosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		movimientosdetalladoss = new  ArrayList<MovimientosDetallados>();
		  		  
        try {
			//MovimientosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<MovimientosDetallados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<MovimientosDetallados> entities = new  ArrayList<MovimientosDetallados>();
		MovimientosDetallados entity = new MovimientosDetallados();		  
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
	
	public  List<MovimientosDetallados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<MovimientosDetallados> entities = new  ArrayList<MovimientosDetallados>();
		MovimientosDetallados entity = new MovimientosDetallados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientosDetallados();
				
				if(conMapGenerico) {
					entity.setMapMovimientosDetallados( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapMovimientosDetallados().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MovimientosDetalladosDataAccess.ISWITHSCHEMA);         		
					entity=MovimientosDetalladosLogic.getEntityMovimientosDetallados("",entity,resultSet,listColumns);
					
					////entity.setMovimientosDetalladosOriginal( new MovimientosDetallados());
					////entity.setMovimientosDetalladosOriginal(super.getEntity("",entity.getMovimientosDetalladosOriginal(),resultSet,MovimientosDetalladosDataAccess.ISWITHSCHEMA));         		
					////entity.setMovimientosDetalladosOriginal(MovimientosDetalladosDataAccess.getEntityMovimientosDetallados("",entity.getMovimientosDetalladosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,MovimientosDetallados relmovimientosdetallados)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relmovimientosdetallados.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,MovimientosDetallados relmovimientosdetallados)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relmovimientosdetallados.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,MovimientosDetallados relmovimientosdetallados)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relmovimientosdetallados.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Transaccion getTransaccion(Connexion connexion,MovimientosDetallados relmovimientosdetallados)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);
			transaccionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			transaccion=transaccionDataAccess.getEntity(connexion,relmovimientosdetallados.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Linea getLinea(Connexion connexion,MovimientosDetallados relmovimientosdetallados)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmovimientosdetallados.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,MovimientosDetallados relmovimientosdetallados)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmovimientosdetallados.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,MovimientosDetallados relmovimientosdetallados)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmovimientosdetallados.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,MovimientosDetallados relmovimientosdetallados)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmovimientosdetallados.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getMovimientosDetalladossBusquedaMovimientosDetalladosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cliente,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//MovimientosDetalladosLogic movimientosdetalladosLogic=new MovimientosDetalladosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=MovimientosDetalladosLogic.GetSelecSqlMovimientosDetallados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cliente,id_transaccion,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.movimientosdetalladoss=this.getMovimientosDetalladoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getMovimientosDetalladossBusquedaMovimientosDetallados(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cliente,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//MovimientosDetalladosLogic movimientosdetalladosLogic=new MovimientosDetalladosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=MovimientosDetalladosLogic.GetSelecSqlMovimientosDetallados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cliente,id_transaccion,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.movimientosdetalladoss=this.getMovimientosDetalladoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlMovimientosDetallados(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cliente,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("MovimientosDetallados_Postgres.sql");
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
				

				if(id_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" m.id_cliente = "+id_cliente.toString();
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
	
	
	public void deepLoad(MovimientosDetallados movimientosdetallados,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MovimientosDetalladosLogicAdditional.updateMovimientosDetalladosToGet(movimientosdetallados,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		movimientosdetallados.setEmpresa(movimientosdetalladosDataAccess.getEmpresa(connexion,movimientosdetallados));
		movimientosdetallados.setSucursal(movimientosdetalladosDataAccess.getSucursal(connexion,movimientosdetallados));
		movimientosdetallados.setCliente(movimientosdetalladosDataAccess.getCliente(connexion,movimientosdetallados));
		movimientosdetallados.setTransaccion(movimientosdetalladosDataAccess.getTransaccion(connexion,movimientosdetallados));
		movimientosdetallados.setLinea(movimientosdetalladosDataAccess.getLinea(connexion,movimientosdetallados));
		movimientosdetallados.setLineaGrupo(movimientosdetalladosDataAccess.getLineaGrupo(connexion,movimientosdetallados));
		movimientosdetallados.setLineaCategoria(movimientosdetalladosDataAccess.getLineaCategoria(connexion,movimientosdetallados));
		movimientosdetallados.setLineaMarca(movimientosdetalladosDataAccess.getLineaMarca(connexion,movimientosdetallados));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				movimientosdetallados.setEmpresa(movimientosdetalladosDataAccess.getEmpresa(connexion,movimientosdetallados));
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientosdetallados.setSucursal(movimientosdetalladosDataAccess.getSucursal(connexion,movimientosdetallados));
			}

			if(clas.clas.equals(Cliente.class)) {
				movimientosdetallados.setCliente(movimientosdetalladosDataAccess.getCliente(connexion,movimientosdetallados));
			}

			if(clas.clas.equals(Transaccion.class)) {
				movimientosdetallados.setTransaccion(movimientosdetalladosDataAccess.getTransaccion(connexion,movimientosdetallados));
			}

			if(clas.clas.equals(Linea.class)) {
				movimientosdetallados.setLinea(movimientosdetalladosDataAccess.getLinea(connexion,movimientosdetallados));
			}

			if(clas.clas.equals(Linea.class)) {
				movimientosdetallados.setLineaGrupo(movimientosdetalladosDataAccess.getLineaGrupo(connexion,movimientosdetallados));
			}

			if(clas.clas.equals(Linea.class)) {
				movimientosdetallados.setLineaCategoria(movimientosdetalladosDataAccess.getLineaCategoria(connexion,movimientosdetallados));
			}

			if(clas.clas.equals(Linea.class)) {
				movimientosdetallados.setLineaMarca(movimientosdetalladosDataAccess.getLineaMarca(connexion,movimientosdetallados));
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
			movimientosdetallados.setEmpresa(movimientosdetalladosDataAccess.getEmpresa(connexion,movimientosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setSucursal(movimientosdetalladosDataAccess.getSucursal(connexion,movimientosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setCliente(movimientosdetalladosDataAccess.getCliente(connexion,movimientosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setTransaccion(movimientosdetalladosDataAccess.getTransaccion(connexion,movimientosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setLinea(movimientosdetalladosDataAccess.getLinea(connexion,movimientosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setLineaGrupo(movimientosdetalladosDataAccess.getLineaGrupo(connexion,movimientosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setLineaCategoria(movimientosdetalladosDataAccess.getLineaCategoria(connexion,movimientosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setLineaMarca(movimientosdetalladosDataAccess.getLineaMarca(connexion,movimientosdetallados));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		movimientosdetallados.setEmpresa(movimientosdetalladosDataAccess.getEmpresa(connexion,movimientosdetallados));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(movimientosdetallados.getEmpresa(),isDeep,deepLoadType,clases);
				
		movimientosdetallados.setSucursal(movimientosdetalladosDataAccess.getSucursal(connexion,movimientosdetallados));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(movimientosdetallados.getSucursal(),isDeep,deepLoadType,clases);
				
		movimientosdetallados.setCliente(movimientosdetalladosDataAccess.getCliente(connexion,movimientosdetallados));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(movimientosdetallados.getCliente(),isDeep,deepLoadType,clases);
				
		movimientosdetallados.setTransaccion(movimientosdetalladosDataAccess.getTransaccion(connexion,movimientosdetallados));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(movimientosdetallados.getTransaccion(),isDeep,deepLoadType,clases);
				
		movimientosdetallados.setLinea(movimientosdetalladosDataAccess.getLinea(connexion,movimientosdetallados));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(movimientosdetallados.getLinea(),isDeep,deepLoadType,clases);
				
		movimientosdetallados.setLineaGrupo(movimientosdetalladosDataAccess.getLineaGrupo(connexion,movimientosdetallados));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(movimientosdetallados.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		movimientosdetallados.setLineaCategoria(movimientosdetalladosDataAccess.getLineaCategoria(connexion,movimientosdetallados));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(movimientosdetallados.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		movimientosdetallados.setLineaMarca(movimientosdetalladosDataAccess.getLineaMarca(connexion,movimientosdetallados));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(movimientosdetallados.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				movimientosdetallados.setEmpresa(movimientosdetalladosDataAccess.getEmpresa(connexion,movimientosdetallados));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(movimientosdetallados.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientosdetallados.setSucursal(movimientosdetalladosDataAccess.getSucursal(connexion,movimientosdetallados));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(movimientosdetallados.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				movimientosdetallados.setCliente(movimientosdetalladosDataAccess.getCliente(connexion,movimientosdetallados));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(movimientosdetallados.getCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Transaccion.class)) {
				movimientosdetallados.setTransaccion(movimientosdetalladosDataAccess.getTransaccion(connexion,movimientosdetallados));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(movimientosdetallados.getTransaccion(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				movimientosdetallados.setLinea(movimientosdetalladosDataAccess.getLinea(connexion,movimientosdetallados));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(movimientosdetallados.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				movimientosdetallados.setLineaGrupo(movimientosdetalladosDataAccess.getLineaGrupo(connexion,movimientosdetallados));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(movimientosdetallados.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				movimientosdetallados.setLineaCategoria(movimientosdetalladosDataAccess.getLineaCategoria(connexion,movimientosdetallados));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(movimientosdetallados.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				movimientosdetallados.setLineaMarca(movimientosdetalladosDataAccess.getLineaMarca(connexion,movimientosdetallados));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(movimientosdetallados.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			movimientosdetallados.setEmpresa(movimientosdetalladosDataAccess.getEmpresa(connexion,movimientosdetallados));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(movimientosdetallados.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setSucursal(movimientosdetalladosDataAccess.getSucursal(connexion,movimientosdetallados));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(movimientosdetallados.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setCliente(movimientosdetalladosDataAccess.getCliente(connexion,movimientosdetallados));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(movimientosdetallados.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setTransaccion(movimientosdetalladosDataAccess.getTransaccion(connexion,movimientosdetallados));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(movimientosdetallados.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setLinea(movimientosdetalladosDataAccess.getLinea(connexion,movimientosdetallados));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(movimientosdetallados.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setLineaGrupo(movimientosdetalladosDataAccess.getLineaGrupo(connexion,movimientosdetallados));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(movimientosdetallados.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setLineaCategoria(movimientosdetalladosDataAccess.getLineaCategoria(connexion,movimientosdetallados));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(movimientosdetallados.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientosdetallados.setLineaMarca(movimientosdetalladosDataAccess.getLineaMarca(connexion,movimientosdetallados));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(movimientosdetallados.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(movimientosdetallados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MovimientosDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesMovimientosDetallados(movimientosdetallados);
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
			this.deepLoad(this.movimientosdetallados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MovimientosDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesMovimientosDetallados(this.movimientosdetallados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(movimientosdetalladoss!=null) {
				for(MovimientosDetallados movimientosdetallados:movimientosdetalladoss) {
					this.deepLoad(movimientosdetallados,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MovimientosDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesMovimientosDetallados(movimientosdetalladoss);
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
			if(movimientosdetalladoss!=null) {
				for(MovimientosDetallados movimientosdetallados:movimientosdetalladoss) {
					this.deepLoad(movimientosdetallados,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MovimientosDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesMovimientosDetallados(movimientosdetalladoss);
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
	
	public MovimientosDetalladosParameterReturnGeneral procesarAccionMovimientosDetalladoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MovimientosDetallados> movimientosdetalladoss,MovimientosDetalladosParameterReturnGeneral movimientosdetalladosParameterGeneral)throws Exception {
		 try {	
			MovimientosDetalladosParameterReturnGeneral movimientosdetalladosReturnGeneral=new MovimientosDetalladosParameterReturnGeneral();
	
			MovimientosDetalladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,movimientosdetalladoss,movimientosdetalladosParameterGeneral,movimientosdetalladosReturnGeneral);
			
			return movimientosdetalladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MovimientosDetalladosParameterReturnGeneral procesarAccionMovimientosDetalladossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MovimientosDetallados> movimientosdetalladoss,MovimientosDetalladosParameterReturnGeneral movimientosdetalladosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			MovimientosDetalladosParameterReturnGeneral movimientosdetalladosReturnGeneral=new MovimientosDetalladosParameterReturnGeneral();
	
			MovimientosDetalladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,movimientosdetalladoss,movimientosdetalladosParameterGeneral,movimientosdetalladosReturnGeneral);
			
			this.connexion.commit();
			
			return movimientosdetalladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

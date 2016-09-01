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
import com.bydan.erp.inventario.util.report.DiferenciasFisicasProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.DiferenciasFisicasProductosParameterGeneral;
import com.bydan.erp.inventario.util.report.DiferenciasFisicasProductosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.DiferenciasFisicasProductos;

import com.bydan.erp.inventario.business.logic.report.DiferenciasFisicasProductosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class DiferenciasFisicasProductosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(DiferenciasFisicasProductosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected DiferenciasFisicasProductosLogic diferenciasfisicasproductosDataAccess; 		
	protected DiferenciasFisicasProductos diferenciasfisicasproductos;
	protected List<DiferenciasFisicasProductos> diferenciasfisicasproductoss;
	protected Object diferenciasfisicasproductosObject;	
	protected List<Object> diferenciasfisicasproductossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  DiferenciasFisicasProductosLogic()throws SQLException,Exception {
		try	{
			this.diferenciasfisicasproductoss= new ArrayList<DiferenciasFisicasProductos>();
			this.diferenciasfisicasproductos= new DiferenciasFisicasProductos();
			this.diferenciasfisicasproductosObject=new Object();
			this.diferenciasfisicasproductossObject=new ArrayList<Object>();
			
			this.diferenciasfisicasproductosDataAccess=this;
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
			this.diferenciasfisicasproductosDataAccess.setConnexionType(this.connexionType);
			this.diferenciasfisicasproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.diferenciasfisicasproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DiferenciasFisicasProductosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.diferenciasfisicasproductoss= new ArrayList<DiferenciasFisicasProductos>();
			this.diferenciasfisicasproductos= new DiferenciasFisicasProductos();
			this.diferenciasfisicasproductosObject=new Object();
			this.diferenciasfisicasproductossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.diferenciasfisicasproductosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.diferenciasfisicasproductosDataAccess.setConnexionType(this.connexionType);
			this.diferenciasfisicasproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.diferenciasfisicasproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DiferenciasFisicasProductos getDiferenciasFisicasProductos() throws Exception {	
		DiferenciasFisicasProductosLogicAdditional.checkDiferenciasFisicasProductosToGet(diferenciasfisicasproductos,this.datosCliente,this.arrDatoGeneral);
		DiferenciasFisicasProductosLogicAdditional.updateDiferenciasFisicasProductosToGet(diferenciasfisicasproductos,this.arrDatoGeneral);
		
		return diferenciasfisicasproductos;
	}
		
	public void setDiferenciasFisicasProductos(DiferenciasFisicasProductos newDiferenciasFisicasProductos) {
		this.diferenciasfisicasproductos = newDiferenciasFisicasProductos;
	}
	
	public List<DiferenciasFisicasProductos> getDiferenciasFisicasProductoss() throws Exception {		
		this.quitarDiferenciasFisicasProductossNulos();
		
		DiferenciasFisicasProductosLogicAdditional.checkDiferenciasFisicasProductosToGets(diferenciasfisicasproductoss,this.datosCliente,this.arrDatoGeneral);
		
		for (DiferenciasFisicasProductos diferenciasfisicasproductosLocal: diferenciasfisicasproductoss ) {
			DiferenciasFisicasProductosLogicAdditional.updateDiferenciasFisicasProductosToGet(diferenciasfisicasproductosLocal,this.arrDatoGeneral);
		}
		
		return diferenciasfisicasproductoss;
	}
	
	public void setDiferenciasFisicasProductoss(List<DiferenciasFisicasProductos> newDiferenciasFisicasProductoss) {
		this.diferenciasfisicasproductoss = newDiferenciasFisicasProductoss;
	}
	
	public Object getDiferenciasFisicasProductosObject() {	
		//this.diferenciasfisicasproductosObject=this.diferenciasfisicasproductosDataAccess.getEntityObject();
		return this.diferenciasfisicasproductosObject;
	}
		
	public void setDiferenciasFisicasProductosObject(Object newDiferenciasFisicasProductosObject) {
		this.diferenciasfisicasproductosObject = newDiferenciasFisicasProductosObject;
	}
	
	public List<Object> getDiferenciasFisicasProductossObject() {		
		//this.diferenciasfisicasproductossObject=this.diferenciasfisicasproductosDataAccess.getEntitiesObject();
		return this.diferenciasfisicasproductossObject;
	}
		
	public void setDiferenciasFisicasProductossObject(List<Object> newDiferenciasFisicasProductossObject) {
		this.diferenciasfisicasproductossObject = newDiferenciasFisicasProductossObject;
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
		diferenciasfisicasproductoss = new  ArrayList<DiferenciasFisicasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiferenciasFisicasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diferenciasfisicasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		diferenciasfisicasproductoss = new  ArrayList<DiferenciasFisicasProductos>();
		  		  
        try {
			//DiferenciasFisicasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diferenciasfisicasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		diferenciasfisicasproductoss = new  ArrayList<DiferenciasFisicasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiferenciasFisicasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diferenciasfisicasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		diferenciasfisicasproductoss = new  ArrayList<DiferenciasFisicasProductos>();
		  		  
        try {
			//DiferenciasFisicasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diferenciasfisicasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		diferenciasfisicasproductoss = new  ArrayList<DiferenciasFisicasProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiferenciasFisicasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diferenciasfisicasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		diferenciasfisicasproductoss = new  ArrayList<DiferenciasFisicasProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//DiferenciasFisicasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diferenciasfisicasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<DiferenciasFisicasProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiferenciasFisicasProductos> entities = new  ArrayList<DiferenciasFisicasProductos>();
		DiferenciasFisicasProductos entity = new DiferenciasFisicasProductos();		  
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
	
	public  List<DiferenciasFisicasProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiferenciasFisicasProductos> entities = new  ArrayList<DiferenciasFisicasProductos>();
		DiferenciasFisicasProductos entity = new DiferenciasFisicasProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DiferenciasFisicasProductos();
				
				
      	    	entity=DiferenciasFisicasProductosLogic.getEntityDiferenciasFisicasProductos("",entity,resultSet);
      	    	
				//entity.setDiferenciasFisicasProductosOriginal( new DiferenciasFisicasProductos());
      	    	//entity.setDiferenciasFisicasProductosOriginal(super.getEntity("",entity.getDiferenciasFisicasProductosOriginal(),resultSet,DiferenciasFisicasProductosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDiferenciasFisicasProductosOriginal(DiferenciasFisicasProductosDataAccess.getEntityDiferenciasFisicasProductos("",entity.getDiferenciasFisicasProductosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<DiferenciasFisicasProductos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiferenciasFisicasProductos> entities = new  ArrayList<DiferenciasFisicasProductos>();
		DiferenciasFisicasProductos entity = new DiferenciasFisicasProductos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,DiferenciasFisicasProductos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DiferenciasFisicasProductos>((List<DiferenciasFisicasProductos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDiferenciasFisicasProductossOriginal(entities);
			
			}  else {
				this.diferenciasfisicasproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DiferenciasFisicasProductosConstantesFunciones.quitarEspaciosDiferenciasFisicasProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static DiferenciasFisicasProductos getEntityDiferenciasFisicasProductos(String strPrefijo,DiferenciasFisicasProductos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.CODIGO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad_disponible(resultSet.getInt(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.CANTIDADDISPONIBLE));
			entity.setcantidad_fisica(resultSet.getInt(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.CANTIDADFISICA));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.CODIGOPRODUCTO));
			entity.setnombre(resultSet.getString(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.NOMBRE));
			entity.setingresos(resultSet.getDouble(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.INGRESOS));
			entity.setegresos(resultSet.getDouble(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.EGRESOS));
			entity.setdisponible_corte(resultSet.getDouble(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE));
			entity.setdiferencia(resultSet.getDouble(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA));
			entity.setcosto(resultSet.getDouble(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.COSTO));
			entity.settotal(resultSet.getDouble(strPrefijo+DiferenciasFisicasProductosConstantesFunciones.TOTAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DiferenciasFisicasProductos getEntityDiferenciasFisicasProductos(String strPrefijo,DiferenciasFisicasProductos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = DiferenciasFisicasProductos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = DiferenciasFisicasProductos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				DiferenciasFisicasProductosLogic.setFieldReflectionDiferenciasFisicasProductos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDiferenciasFisicasProductos(Field field,String strPrefijo,String sColumn,DiferenciasFisicasProductos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DiferenciasFisicasProductosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.CANTIDADDISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.CANTIDADFISICA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.CODIGOPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.INGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.EGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiferenciasFisicasProductosConstantesFunciones.TOTAL:
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
	
	public void quitarDiferenciasFisicasProductossNulos() throws Exception {				
		
		List<DiferenciasFisicasProductos> diferenciasfisicasproductossAux= new ArrayList<DiferenciasFisicasProductos>();
		
		for(DiferenciasFisicasProductos diferenciasfisicasproductos:diferenciasfisicasproductoss) {
			if(diferenciasfisicasproductos!=null) {
				diferenciasfisicasproductossAux.add(diferenciasfisicasproductos);
			}
		}
		
		diferenciasfisicasproductoss=diferenciasfisicasproductossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<DiferenciasFisicasProductos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiferenciasFisicasProductos> entities = new  ArrayList<DiferenciasFisicasProductos>();
		DiferenciasFisicasProductos entity = new DiferenciasFisicasProductos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DiferenciasFisicasProductos>((List<DiferenciasFisicasProductos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDiferenciasFisicasProductossOriginal(entities);
			
			}  else {
				this.diferenciasfisicasproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DiferenciasFisicasProductosConstantesFunciones.quitarEspaciosDiferenciasFisicasProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		diferenciasfisicasproductoss = new  ArrayList<DiferenciasFisicasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiferenciasFisicasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diferenciasfisicasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		diferenciasfisicasproductoss = new  ArrayList<DiferenciasFisicasProductos>();
		  		  
        try {
			//DiferenciasFisicasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diferenciasfisicasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<DiferenciasFisicasProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DiferenciasFisicasProductos> entities = new  ArrayList<DiferenciasFisicasProductos>();
		DiferenciasFisicasProductos entity = new DiferenciasFisicasProductos();		  
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
	
	public  List<DiferenciasFisicasProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DiferenciasFisicasProductos> entities = new  ArrayList<DiferenciasFisicasProductos>();
		DiferenciasFisicasProductos entity = new DiferenciasFisicasProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DiferenciasFisicasProductos();
				
				if(conMapGenerico) {
					entity.setMapDiferenciasFisicasProductos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapDiferenciasFisicasProductos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DiferenciasFisicasProductosDataAccess.ISWITHSCHEMA);         		
					entity=DiferenciasFisicasProductosLogic.getEntityDiferenciasFisicasProductos("",entity,resultSet,listColumns);
					
					////entity.setDiferenciasFisicasProductosOriginal( new DiferenciasFisicasProductos());
					////entity.setDiferenciasFisicasProductosOriginal(super.getEntity("",entity.getDiferenciasFisicasProductosOriginal(),resultSet,DiferenciasFisicasProductosDataAccess.ISWITHSCHEMA));         		
					////entity.setDiferenciasFisicasProductosOriginal(DiferenciasFisicasProductosDataAccess.getEntityDiferenciasFisicasProductos("",entity.getDiferenciasFisicasProductosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,DiferenciasFisicasProductos reldiferenciasfisicasproductos)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,reldiferenciasfisicasproductos.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DiferenciasFisicasProductos reldiferenciasfisicasproductos)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,reldiferenciasfisicasproductos.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,DiferenciasFisicasProductos reldiferenciasfisicasproductos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reldiferenciasfisicasproductos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DiferenciasFisicasProductos reldiferenciasfisicasproductos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,reldiferenciasfisicasproductos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,DiferenciasFisicasProductos reldiferenciasfisicasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldiferenciasfisicasproductos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,DiferenciasFisicasProductos reldiferenciasfisicasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldiferenciasfisicasproductos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,DiferenciasFisicasProductos reldiferenciasfisicasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldiferenciasfisicasproductos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,DiferenciasFisicasProductos reldiferenciasfisicasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,reldiferenciasfisicasproductos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getDiferenciasFisicasProductossBusquedaDiferenciasFisicasProductosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//DiferenciasFisicasProductosLogic diferenciasfisicasproductosLogic=new DiferenciasFisicasProductosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DiferenciasFisicasProductosLogic.GetSelecSqlDiferenciasFisicasProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.diferenciasfisicasproductoss=this.getDiferenciasFisicasProductoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getDiferenciasFisicasProductossBusquedaDiferenciasFisicasProductos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//DiferenciasFisicasProductosLogic diferenciasfisicasproductosLogic=new DiferenciasFisicasProductosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DiferenciasFisicasProductosLogic.GetSelecSqlDiferenciasFisicasProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.diferenciasfisicasproductoss=this.getDiferenciasFisicasProductoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlDiferenciasFisicasProductos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("DiferenciasFisicasProductos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_bodega!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_bodega = "+id_bodega.toString();
					existeWhere=true;
				}

				if(id_producto!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_producto = "+id_producto.toString();
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

				if(fecha_ultima_venta_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.fecha_ultima_venta<="+"'"+Funciones2.getStringPostgresDate(fecha_ultima_venta_hasta)+"'";
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
	
	
	public void deepLoad(DiferenciasFisicasProductos diferenciasfisicasproductos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DiferenciasFisicasProductosLogicAdditional.updateDiferenciasFisicasProductosToGet(diferenciasfisicasproductos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		diferenciasfisicasproductos.setBodega(diferenciasfisicasproductosDataAccess.getBodega(connexion,diferenciasfisicasproductos));
		diferenciasfisicasproductos.setProducto(diferenciasfisicasproductosDataAccess.getProducto(connexion,diferenciasfisicasproductos));
		diferenciasfisicasproductos.setEmpresa(diferenciasfisicasproductosDataAccess.getEmpresa(connexion,diferenciasfisicasproductos));
		diferenciasfisicasproductos.setSucursal(diferenciasfisicasproductosDataAccess.getSucursal(connexion,diferenciasfisicasproductos));
		diferenciasfisicasproductos.setLinea(diferenciasfisicasproductosDataAccess.getLinea(connexion,diferenciasfisicasproductos));
		diferenciasfisicasproductos.setLineaGrupo(diferenciasfisicasproductosDataAccess.getLineaGrupo(connexion,diferenciasfisicasproductos));
		diferenciasfisicasproductos.setLineaCategoria(diferenciasfisicasproductosDataAccess.getLineaCategoria(connexion,diferenciasfisicasproductos));
		diferenciasfisicasproductos.setLineaMarca(diferenciasfisicasproductosDataAccess.getLineaMarca(connexion,diferenciasfisicasproductos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				diferenciasfisicasproductos.setBodega(diferenciasfisicasproductosDataAccess.getBodega(connexion,diferenciasfisicasproductos));
			}

			if(clas.clas.equals(Producto.class)) {
				diferenciasfisicasproductos.setProducto(diferenciasfisicasproductosDataAccess.getProducto(connexion,diferenciasfisicasproductos));
			}

			if(clas.clas.equals(Empresa.class)) {
				diferenciasfisicasproductos.setEmpresa(diferenciasfisicasproductosDataAccess.getEmpresa(connexion,diferenciasfisicasproductos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				diferenciasfisicasproductos.setSucursal(diferenciasfisicasproductosDataAccess.getSucursal(connexion,diferenciasfisicasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				diferenciasfisicasproductos.setLinea(diferenciasfisicasproductosDataAccess.getLinea(connexion,diferenciasfisicasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				diferenciasfisicasproductos.setLineaGrupo(diferenciasfisicasproductosDataAccess.getLineaGrupo(connexion,diferenciasfisicasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				diferenciasfisicasproductos.setLineaCategoria(diferenciasfisicasproductosDataAccess.getLineaCategoria(connexion,diferenciasfisicasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				diferenciasfisicasproductos.setLineaMarca(diferenciasfisicasproductosDataAccess.getLineaMarca(connexion,diferenciasfisicasproductos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setBodega(diferenciasfisicasproductosDataAccess.getBodega(connexion,diferenciasfisicasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setProducto(diferenciasfisicasproductosDataAccess.getProducto(connexion,diferenciasfisicasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setEmpresa(diferenciasfisicasproductosDataAccess.getEmpresa(connexion,diferenciasfisicasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setSucursal(diferenciasfisicasproductosDataAccess.getSucursal(connexion,diferenciasfisicasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setLinea(diferenciasfisicasproductosDataAccess.getLinea(connexion,diferenciasfisicasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setLineaGrupo(diferenciasfisicasproductosDataAccess.getLineaGrupo(connexion,diferenciasfisicasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setLineaCategoria(diferenciasfisicasproductosDataAccess.getLineaCategoria(connexion,diferenciasfisicasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setLineaMarca(diferenciasfisicasproductosDataAccess.getLineaMarca(connexion,diferenciasfisicasproductos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		diferenciasfisicasproductos.setBodega(diferenciasfisicasproductosDataAccess.getBodega(connexion,diferenciasfisicasproductos));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(diferenciasfisicasproductos.getBodega(),isDeep,deepLoadType,clases);
				
		diferenciasfisicasproductos.setProducto(diferenciasfisicasproductosDataAccess.getProducto(connexion,diferenciasfisicasproductos));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(diferenciasfisicasproductos.getProducto(),isDeep,deepLoadType,clases);
				
		diferenciasfisicasproductos.setEmpresa(diferenciasfisicasproductosDataAccess.getEmpresa(connexion,diferenciasfisicasproductos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(diferenciasfisicasproductos.getEmpresa(),isDeep,deepLoadType,clases);
				
		diferenciasfisicasproductos.setSucursal(diferenciasfisicasproductosDataAccess.getSucursal(connexion,diferenciasfisicasproductos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(diferenciasfisicasproductos.getSucursal(),isDeep,deepLoadType,clases);
				
		diferenciasfisicasproductos.setLinea(diferenciasfisicasproductosDataAccess.getLinea(connexion,diferenciasfisicasproductos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(diferenciasfisicasproductos.getLinea(),isDeep,deepLoadType,clases);
				
		diferenciasfisicasproductos.setLineaGrupo(diferenciasfisicasproductosDataAccess.getLineaGrupo(connexion,diferenciasfisicasproductos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(diferenciasfisicasproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		diferenciasfisicasproductos.setLineaCategoria(diferenciasfisicasproductosDataAccess.getLineaCategoria(connexion,diferenciasfisicasproductos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(diferenciasfisicasproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		diferenciasfisicasproductos.setLineaMarca(diferenciasfisicasproductosDataAccess.getLineaMarca(connexion,diferenciasfisicasproductos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(diferenciasfisicasproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				diferenciasfisicasproductos.setBodega(diferenciasfisicasproductosDataAccess.getBodega(connexion,diferenciasfisicasproductos));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(diferenciasfisicasproductos.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				diferenciasfisicasproductos.setProducto(diferenciasfisicasproductosDataAccess.getProducto(connexion,diferenciasfisicasproductos));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(diferenciasfisicasproductos.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				diferenciasfisicasproductos.setEmpresa(diferenciasfisicasproductosDataAccess.getEmpresa(connexion,diferenciasfisicasproductos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(diferenciasfisicasproductos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				diferenciasfisicasproductos.setSucursal(diferenciasfisicasproductosDataAccess.getSucursal(connexion,diferenciasfisicasproductos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(diferenciasfisicasproductos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				diferenciasfisicasproductos.setLinea(diferenciasfisicasproductosDataAccess.getLinea(connexion,diferenciasfisicasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(diferenciasfisicasproductos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				diferenciasfisicasproductos.setLineaGrupo(diferenciasfisicasproductosDataAccess.getLineaGrupo(connexion,diferenciasfisicasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(diferenciasfisicasproductos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				diferenciasfisicasproductos.setLineaCategoria(diferenciasfisicasproductosDataAccess.getLineaCategoria(connexion,diferenciasfisicasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(diferenciasfisicasproductos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				diferenciasfisicasproductos.setLineaMarca(diferenciasfisicasproductosDataAccess.getLineaMarca(connexion,diferenciasfisicasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(diferenciasfisicasproductos.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setBodega(diferenciasfisicasproductosDataAccess.getBodega(connexion,diferenciasfisicasproductos));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(diferenciasfisicasproductos.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setProducto(diferenciasfisicasproductosDataAccess.getProducto(connexion,diferenciasfisicasproductos));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(diferenciasfisicasproductos.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setEmpresa(diferenciasfisicasproductosDataAccess.getEmpresa(connexion,diferenciasfisicasproductos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(diferenciasfisicasproductos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setSucursal(diferenciasfisicasproductosDataAccess.getSucursal(connexion,diferenciasfisicasproductos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(diferenciasfisicasproductos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setLinea(diferenciasfisicasproductosDataAccess.getLinea(connexion,diferenciasfisicasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(diferenciasfisicasproductos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setLineaGrupo(diferenciasfisicasproductosDataAccess.getLineaGrupo(connexion,diferenciasfisicasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(diferenciasfisicasproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setLineaCategoria(diferenciasfisicasproductosDataAccess.getLineaCategoria(connexion,diferenciasfisicasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(diferenciasfisicasproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diferenciasfisicasproductos.setLineaMarca(diferenciasfisicasproductosDataAccess.getLineaMarca(connexion,diferenciasfisicasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(diferenciasfisicasproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(diferenciasfisicasproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DiferenciasFisicasProductosConstantesFunciones.refrescarForeignKeysDescripcionesDiferenciasFisicasProductos(diferenciasfisicasproductos);
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
			this.deepLoad(this.diferenciasfisicasproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DiferenciasFisicasProductosConstantesFunciones.refrescarForeignKeysDescripcionesDiferenciasFisicasProductos(this.diferenciasfisicasproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(diferenciasfisicasproductoss!=null) {
				for(DiferenciasFisicasProductos diferenciasfisicasproductos:diferenciasfisicasproductoss) {
					this.deepLoad(diferenciasfisicasproductos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DiferenciasFisicasProductosConstantesFunciones.refrescarForeignKeysDescripcionesDiferenciasFisicasProductos(diferenciasfisicasproductoss);
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
			if(diferenciasfisicasproductoss!=null) {
				for(DiferenciasFisicasProductos diferenciasfisicasproductos:diferenciasfisicasproductoss) {
					this.deepLoad(diferenciasfisicasproductos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DiferenciasFisicasProductosConstantesFunciones.refrescarForeignKeysDescripcionesDiferenciasFisicasProductos(diferenciasfisicasproductoss);
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
	
	public DiferenciasFisicasProductosParameterReturnGeneral procesarAccionDiferenciasFisicasProductoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DiferenciasFisicasProductos> diferenciasfisicasproductoss,DiferenciasFisicasProductosParameterReturnGeneral diferenciasfisicasproductosParameterGeneral)throws Exception {
		 try {	
			DiferenciasFisicasProductosParameterReturnGeneral diferenciasfisicasproductosReturnGeneral=new DiferenciasFisicasProductosParameterReturnGeneral();
	
			DiferenciasFisicasProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,diferenciasfisicasproductoss,diferenciasfisicasproductosParameterGeneral,diferenciasfisicasproductosReturnGeneral);
			
			return diferenciasfisicasproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DiferenciasFisicasProductosParameterReturnGeneral procesarAccionDiferenciasFisicasProductossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DiferenciasFisicasProductos> diferenciasfisicasproductoss,DiferenciasFisicasProductosParameterReturnGeneral diferenciasfisicasproductosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			DiferenciasFisicasProductosParameterReturnGeneral diferenciasfisicasproductosReturnGeneral=new DiferenciasFisicasProductosParameterReturnGeneral();
	
			DiferenciasFisicasProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,diferenciasfisicasproductoss,diferenciasfisicasproductosParameterGeneral,diferenciasfisicasproductosReturnGeneral);
			
			this.connexion.commit();
			
			return diferenciasfisicasproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

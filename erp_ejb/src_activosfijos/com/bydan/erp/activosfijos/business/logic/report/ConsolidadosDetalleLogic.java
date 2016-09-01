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
package com.bydan.erp.activosfijos.business.logic.report;

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

import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.resources.general.AuxiliarGeneral;
import com.bydan.erp.activosfijos.util.report.ConsolidadosDetalleParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ConsolidadosDetalleParameterGeneral;
import com.bydan.erp.activosfijos.util.report.ConsolidadosDetalleConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.ConsolidadosDetalle;

import com.bydan.erp.activosfijos.business.logic.report.ConsolidadosDetalleLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ConsolidadosDetalleLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ConsolidadosDetalleLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ConsolidadosDetalleLogic consolidadosdetalleDataAccess; 		
	protected ConsolidadosDetalle consolidadosdetalle;
	protected List<ConsolidadosDetalle> consolidadosdetalles;
	protected Object consolidadosdetalleObject;	
	protected List<Object> consolidadosdetallesObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ConsolidadosDetalleLogic()throws SQLException,Exception {
		try	{
			this.consolidadosdetalles= new ArrayList<ConsolidadosDetalle>();
			this.consolidadosdetalle= new ConsolidadosDetalle();
			this.consolidadosdetalleObject=new Object();
			this.consolidadosdetallesObject=new ArrayList<Object>();
			
			this.consolidadosdetalleDataAccess=this;
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
			this.consolidadosdetalleDataAccess.setConnexionType(this.connexionType);
			this.consolidadosdetalleDataAccess.setParameterDbType(this.parameterDbType);
			this.consolidadosdetalleDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConsolidadosDetalleLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.consolidadosdetalles= new ArrayList<ConsolidadosDetalle>();
			this.consolidadosdetalle= new ConsolidadosDetalle();
			this.consolidadosdetalleObject=new Object();
			this.consolidadosdetallesObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.consolidadosdetalleDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.consolidadosdetalleDataAccess.setConnexionType(this.connexionType);
			this.consolidadosdetalleDataAccess.setParameterDbType(this.parameterDbType);
			this.consolidadosdetalleDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ConsolidadosDetalle getConsolidadosDetalle() throws Exception {	
		ConsolidadosDetalleLogicAdditional.checkConsolidadosDetalleToGet(consolidadosdetalle,this.datosCliente,this.arrDatoGeneral);
		ConsolidadosDetalleLogicAdditional.updateConsolidadosDetalleToGet(consolidadosdetalle,this.arrDatoGeneral);
		
		return consolidadosdetalle;
	}
		
	public void setConsolidadosDetalle(ConsolidadosDetalle newConsolidadosDetalle) {
		this.consolidadosdetalle = newConsolidadosDetalle;
	}
	
	public List<ConsolidadosDetalle> getConsolidadosDetalles() throws Exception {		
		this.quitarConsolidadosDetallesNulos();
		
		ConsolidadosDetalleLogicAdditional.checkConsolidadosDetalleToGets(consolidadosdetalles,this.datosCliente,this.arrDatoGeneral);
		
		for (ConsolidadosDetalle consolidadosdetalleLocal: consolidadosdetalles ) {
			ConsolidadosDetalleLogicAdditional.updateConsolidadosDetalleToGet(consolidadosdetalleLocal,this.arrDatoGeneral);
		}
		
		return consolidadosdetalles;
	}
	
	public void setConsolidadosDetalles(List<ConsolidadosDetalle> newConsolidadosDetalles) {
		this.consolidadosdetalles = newConsolidadosDetalles;
	}
	
	public Object getConsolidadosDetalleObject() {	
		//this.consolidadosdetalleObject=this.consolidadosdetalleDataAccess.getEntityObject();
		return this.consolidadosdetalleObject;
	}
		
	public void setConsolidadosDetalleObject(Object newConsolidadosDetalleObject) {
		this.consolidadosdetalleObject = newConsolidadosDetalleObject;
	}
	
	public List<Object> getConsolidadosDetallesObject() {		
		//this.consolidadosdetallesObject=this.consolidadosdetalleDataAccess.getEntitiesObject();
		return this.consolidadosdetallesObject;
	}
		
	public void setConsolidadosDetallesObject(List<Object> newConsolidadosDetallesObject) {
		this.consolidadosdetallesObject = newConsolidadosDetallesObject;
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
		consolidadosdetalles = new  ArrayList<ConsolidadosDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsolidadosDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosdetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		consolidadosdetalles = new  ArrayList<ConsolidadosDetalle>();
		  		  
        try {
			//ConsolidadosDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosdetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		consolidadosdetalles = new  ArrayList<ConsolidadosDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsolidadosDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosdetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		consolidadosdetalles = new  ArrayList<ConsolidadosDetalle>();
		  		  
        try {
			//ConsolidadosDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosdetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		consolidadosdetalles = new  ArrayList<ConsolidadosDetalle>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsolidadosDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosdetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		consolidadosdetalles = new  ArrayList<ConsolidadosDetalle>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ConsolidadosDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosdetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ConsolidadosDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsolidadosDetalle> entities = new  ArrayList<ConsolidadosDetalle>();
		ConsolidadosDetalle entity = new ConsolidadosDetalle();		  
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
	
	public  List<ConsolidadosDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsolidadosDetalle> entities = new  ArrayList<ConsolidadosDetalle>();
		ConsolidadosDetalle entity = new ConsolidadosDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConsolidadosDetalle();
				
				
      	    	entity=ConsolidadosDetalleLogic.getEntityConsolidadosDetalle("",entity,resultSet);
      	    	
				//entity.setConsolidadosDetalleOriginal( new ConsolidadosDetalle());
      	    	//entity.setConsolidadosDetalleOriginal(super.getEntity("",entity.getConsolidadosDetalleOriginal(),resultSet,ConsolidadosDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConsolidadosDetalleOriginal(ConsolidadosDetalleDataAccess.getEntityConsolidadosDetalle("",entity.getConsolidadosDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ConsolidadosDetalle> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsolidadosDetalle> entities = new  ArrayList<ConsolidadosDetalle>();
		ConsolidadosDetalle entity = new ConsolidadosDetalle();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ConsolidadosDetalle.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConsolidadosDetalle>((List<ConsolidadosDetalle>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConsolidadosDetallesOriginal(entities);
			
			}  else {
				this.consolidadosdetallesObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConsolidadosDetalleConstantesFunciones.quitarEspaciosConsolidadosDetalles(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ConsolidadosDetalle getEntityConsolidadosDetalle(String strPrefijo,ConsolidadosDetalle entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_empresa(resultSet.getString(strPrefijo+ConsolidadosDetalleConstantesFunciones.NOMBREEMPRESA));
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+ConsolidadosDetalleConstantesFunciones.NOMBRESUCURSAL));
			entity.setcodigo_sub_grupo(resultSet.getString(strPrefijo+ConsolidadosDetalleConstantesFunciones.CODIGOSUBGRUPO));
			entity.setnombre_sub_grupo(resultSet.getString(strPrefijo+ConsolidadosDetalleConstantesFunciones.NOMBRESUBGRUPO));
			entity.setcodigo_detalle_grupo(resultSet.getString(strPrefijo+ConsolidadosDetalleConstantesFunciones.CODIGODETALLEGRUPO));
			entity.setnombre_detalle_grupo(resultSet.getString(strPrefijo+ConsolidadosDetalleConstantesFunciones.NOMBREDETALLEGRUPO));
			entity.setclave(resultSet.getString(strPrefijo+ConsolidadosDetalleConstantesFunciones.CLAVE));
			entity.setnombre(resultSet.getString(strPrefijo+ConsolidadosDetalleConstantesFunciones.NOMBRE));
			entity.setfecha_compra(new Date(resultSet.getDate(strPrefijo+ConsolidadosDetalleConstantesFunciones.FECHACOMPRA).getTime()));
			entity.setvida_util(resultSet.getDouble(strPrefijo+ConsolidadosDetalleConstantesFunciones.VIDAUTIL));
			entity.setcosto_de_compra(resultSet.getDouble(strPrefijo+ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA));
			entity.setcantidad(resultSet.getInt(strPrefijo+ConsolidadosDetalleConstantesFunciones.CANTIDAD));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ConsolidadosDetalle getEntityConsolidadosDetalle(String strPrefijo,ConsolidadosDetalle entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ConsolidadosDetalle.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ConsolidadosDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ConsolidadosDetalleLogic.setFieldReflectionConsolidadosDetalle(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionConsolidadosDetalle(Field field,String strPrefijo,String sColumn,ConsolidadosDetalle entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ConsolidadosDetalleConstantesFunciones.NOMBREEMPRESA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.CODIGOSUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.NOMBRESUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.CODIGODETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.NOMBREDETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.CLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.FECHACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.VIDAUTIL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConsolidadosDetalleConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	public void quitarConsolidadosDetallesNulos() throws Exception {				
		
		List<ConsolidadosDetalle> consolidadosdetallesAux= new ArrayList<ConsolidadosDetalle>();
		
		for(ConsolidadosDetalle consolidadosdetalle:consolidadosdetalles) {
			if(consolidadosdetalle!=null) {
				consolidadosdetallesAux.add(consolidadosdetalle);
			}
		}
		
		consolidadosdetalles=consolidadosdetallesAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsolidadosDetalle> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsolidadosDetalle> entities = new  ArrayList<ConsolidadosDetalle>();
		ConsolidadosDetalle entity = new ConsolidadosDetalle();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConsolidadosDetalle>((List<ConsolidadosDetalle>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConsolidadosDetallesOriginal(entities);
			
			}  else {
				this.consolidadosdetallesObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConsolidadosDetalleConstantesFunciones.quitarEspaciosConsolidadosDetalles(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		consolidadosdetalles = new  ArrayList<ConsolidadosDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsolidadosDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosdetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		consolidadosdetalles = new  ArrayList<ConsolidadosDetalle>();
		  		  
        try {
			//ConsolidadosDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosdetalles=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ConsolidadosDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConsolidadosDetalle> entities = new  ArrayList<ConsolidadosDetalle>();
		ConsolidadosDetalle entity = new ConsolidadosDetalle();		  
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
	
	public  List<ConsolidadosDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConsolidadosDetalle> entities = new  ArrayList<ConsolidadosDetalle>();
		ConsolidadosDetalle entity = new ConsolidadosDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConsolidadosDetalle();
				
				if(conMapGenerico) {
					entity.setMapConsolidadosDetalle( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapConsolidadosDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConsolidadosDetalleDataAccess.ISWITHSCHEMA);         		
					entity=ConsolidadosDetalleLogic.getEntityConsolidadosDetalle("",entity,resultSet,listColumns);
					
					////entity.setConsolidadosDetalleOriginal( new ConsolidadosDetalle());
					////entity.setConsolidadosDetalleOriginal(super.getEntity("",entity.getConsolidadosDetalleOriginal(),resultSet,ConsolidadosDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setConsolidadosDetalleOriginal(ConsolidadosDetalleDataAccess.getEntityConsolidadosDetalle("",entity.getConsolidadosDetalleOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ConsolidadosDetalle relconsolidadosdetalle)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relconsolidadosdetalle.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getConsolidadosDetallesBusquedaConsolidadosDetalleWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//ConsolidadosDetalleLogic consolidadosdetalleLogic=new ConsolidadosDetalleLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConsolidadosDetalleLogic.GetSelecSqlConsolidadosDetalle(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.consolidadosdetalles=this.getConsolidadosDetalles();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getConsolidadosDetallesBusquedaConsolidadosDetalle(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//ConsolidadosDetalleLogic consolidadosdetalleLogic=new ConsolidadosDetalleLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConsolidadosDetalleLogic.GetSelecSqlConsolidadosDetalle(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.consolidadosdetalles=this.getConsolidadosDetalles();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlConsolidadosDetalle(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ConsolidadosDetalle_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" id_sucursal="+parametroGeneralUsuario.getid_sucursal();
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
	
	
	public void deepLoad(ConsolidadosDetalle consolidadosdetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConsolidadosDetalleLogicAdditional.updateConsolidadosDetalleToGet(consolidadosdetalle,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consolidadosdetalle.setEmpresa(consolidadosdetalleDataAccess.getEmpresa(connexion,consolidadosdetalle));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consolidadosdetalle.setEmpresa(consolidadosdetalleDataAccess.getEmpresa(connexion,consolidadosdetalle));
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
			consolidadosdetalle.setEmpresa(consolidadosdetalleDataAccess.getEmpresa(connexion,consolidadosdetalle));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consolidadosdetalle.setEmpresa(consolidadosdetalleDataAccess.getEmpresa(connexion,consolidadosdetalle));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(consolidadosdetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consolidadosdetalle.setEmpresa(consolidadosdetalleDataAccess.getEmpresa(connexion,consolidadosdetalle));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(consolidadosdetalle.getEmpresa(),isDeep,deepLoadType,clases);				
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
			consolidadosdetalle.setEmpresa(consolidadosdetalleDataAccess.getEmpresa(connexion,consolidadosdetalle));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(consolidadosdetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(consolidadosdetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsolidadosDetalleConstantesFunciones.refrescarForeignKeysDescripcionesConsolidadosDetalle(consolidadosdetalle);
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
			this.deepLoad(this.consolidadosdetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsolidadosDetalleConstantesFunciones.refrescarForeignKeysDescripcionesConsolidadosDetalle(this.consolidadosdetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(consolidadosdetalles!=null) {
				for(ConsolidadosDetalle consolidadosdetalle:consolidadosdetalles) {
					this.deepLoad(consolidadosdetalle,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConsolidadosDetalleConstantesFunciones.refrescarForeignKeysDescripcionesConsolidadosDetalle(consolidadosdetalles);
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
			if(consolidadosdetalles!=null) {
				for(ConsolidadosDetalle consolidadosdetalle:consolidadosdetalles) {
					this.deepLoad(consolidadosdetalle,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConsolidadosDetalleConstantesFunciones.refrescarForeignKeysDescripcionesConsolidadosDetalle(consolidadosdetalles);
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
	
	public ConsolidadosDetalleParameterReturnGeneral procesarAccionConsolidadosDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConsolidadosDetalle> consolidadosdetalles,ConsolidadosDetalleParameterReturnGeneral consolidadosdetalleParameterGeneral)throws Exception {
		 try {	
			ConsolidadosDetalleParameterReturnGeneral consolidadosdetalleReturnGeneral=new ConsolidadosDetalleParameterReturnGeneral();
	
			ConsolidadosDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consolidadosdetalles,consolidadosdetalleParameterGeneral,consolidadosdetalleReturnGeneral);
			
			return consolidadosdetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConsolidadosDetalleParameterReturnGeneral procesarAccionConsolidadosDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConsolidadosDetalle> consolidadosdetalles,ConsolidadosDetalleParameterReturnGeneral consolidadosdetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ConsolidadosDetalleParameterReturnGeneral consolidadosdetalleReturnGeneral=new ConsolidadosDetalleParameterReturnGeneral();
	
			ConsolidadosDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consolidadosdetalles,consolidadosdetalleParameterGeneral,consolidadosdetalleReturnGeneral);
			
			this.connexion.commit();
			
			return consolidadosdetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

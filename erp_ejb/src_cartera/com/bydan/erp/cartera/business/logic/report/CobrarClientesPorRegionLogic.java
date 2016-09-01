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
package com.bydan.erp.cartera.business.logic.report;

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

import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.resources.general.AuxiliarGeneral;
import com.bydan.erp.cartera.util.report.CobrarClientesPorRegionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesPorRegionParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarClientesPorRegionConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarClientesPorRegion;

import com.bydan.erp.cartera.business.logic.report.CobrarClientesPorRegionLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarClientesPorRegionLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarClientesPorRegionLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarClientesPorRegionLogic cobrarclientesporregionDataAccess; 		
	protected CobrarClientesPorRegion cobrarclientesporregion;
	protected List<CobrarClientesPorRegion> cobrarclientesporregions;
	protected Object cobrarclientesporregionObject;	
	protected List<Object> cobrarclientesporregionsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarClientesPorRegionLogic()throws SQLException,Exception {
		try	{
			this.cobrarclientesporregions= new ArrayList<CobrarClientesPorRegion>();
			this.cobrarclientesporregion= new CobrarClientesPorRegion();
			this.cobrarclientesporregionObject=new Object();
			this.cobrarclientesporregionsObject=new ArrayList<Object>();
			
			this.cobrarclientesporregionDataAccess=this;
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
			this.cobrarclientesporregionDataAccess.setConnexionType(this.connexionType);
			this.cobrarclientesporregionDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclientesporregionDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarClientesPorRegionLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarclientesporregions= new ArrayList<CobrarClientesPorRegion>();
			this.cobrarclientesporregion= new CobrarClientesPorRegion();
			this.cobrarclientesporregionObject=new Object();
			this.cobrarclientesporregionsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarclientesporregionDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarclientesporregionDataAccess.setConnexionType(this.connexionType);
			this.cobrarclientesporregionDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclientesporregionDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarClientesPorRegion getCobrarClientesPorRegion() throws Exception {	
		CobrarClientesPorRegionLogicAdditional.checkCobrarClientesPorRegionToGet(cobrarclientesporregion,this.datosCliente,this.arrDatoGeneral);
		CobrarClientesPorRegionLogicAdditional.updateCobrarClientesPorRegionToGet(cobrarclientesporregion,this.arrDatoGeneral);
		
		return cobrarclientesporregion;
	}
		
	public void setCobrarClientesPorRegion(CobrarClientesPorRegion newCobrarClientesPorRegion) {
		this.cobrarclientesporregion = newCobrarClientesPorRegion;
	}
	
	public List<CobrarClientesPorRegion> getCobrarClientesPorRegions() throws Exception {		
		this.quitarCobrarClientesPorRegionsNulos();
		
		CobrarClientesPorRegionLogicAdditional.checkCobrarClientesPorRegionToGets(cobrarclientesporregions,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarClientesPorRegion cobrarclientesporregionLocal: cobrarclientesporregions ) {
			CobrarClientesPorRegionLogicAdditional.updateCobrarClientesPorRegionToGet(cobrarclientesporregionLocal,this.arrDatoGeneral);
		}
		
		return cobrarclientesporregions;
	}
	
	public void setCobrarClientesPorRegions(List<CobrarClientesPorRegion> newCobrarClientesPorRegions) {
		this.cobrarclientesporregions = newCobrarClientesPorRegions;
	}
	
	public Object getCobrarClientesPorRegionObject() {	
		//this.cobrarclientesporregionObject=this.cobrarclientesporregionDataAccess.getEntityObject();
		return this.cobrarclientesporregionObject;
	}
		
	public void setCobrarClientesPorRegionObject(Object newCobrarClientesPorRegionObject) {
		this.cobrarclientesporregionObject = newCobrarClientesPorRegionObject;
	}
	
	public List<Object> getCobrarClientesPorRegionsObject() {		
		//this.cobrarclientesporregionsObject=this.cobrarclientesporregionDataAccess.getEntitiesObject();
		return this.cobrarclientesporregionsObject;
	}
		
	public void setCobrarClientesPorRegionsObject(List<Object> newCobrarClientesPorRegionsObject) {
		this.cobrarclientesporregionsObject = newCobrarClientesPorRegionsObject;
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
		cobrarclientesporregions = new  ArrayList<CobrarClientesPorRegion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesPorRegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesporregions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarclientesporregions = new  ArrayList<CobrarClientesPorRegion>();
		  		  
        try {
			//CobrarClientesPorRegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesporregions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarclientesporregions = new  ArrayList<CobrarClientesPorRegion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesPorRegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesporregions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclientesporregions = new  ArrayList<CobrarClientesPorRegion>();
		  		  
        try {
			//CobrarClientesPorRegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesporregions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarclientesporregions = new  ArrayList<CobrarClientesPorRegion>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesPorRegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesporregions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclientesporregions = new  ArrayList<CobrarClientesPorRegion>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarClientesPorRegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesporregions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarClientesPorRegion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesPorRegion> entities = new  ArrayList<CobrarClientesPorRegion>();
		CobrarClientesPorRegion entity = new CobrarClientesPorRegion();		  
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
	
	public  List<CobrarClientesPorRegion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesPorRegion> entities = new  ArrayList<CobrarClientesPorRegion>();
		CobrarClientesPorRegion entity = new CobrarClientesPorRegion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesPorRegion();
				
				
      	    	entity=CobrarClientesPorRegionLogic.getEntityCobrarClientesPorRegion("",entity,resultSet);
      	    	
				//entity.setCobrarClientesPorRegionOriginal( new CobrarClientesPorRegion());
      	    	//entity.setCobrarClientesPorRegionOriginal(super.getEntity("",entity.getCobrarClientesPorRegionOriginal(),resultSet,CobrarClientesPorRegionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarClientesPorRegionOriginal(CobrarClientesPorRegionDataAccess.getEntityCobrarClientesPorRegion("",entity.getCobrarClientesPorRegionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarClientesPorRegion> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesPorRegion> entities = new  ArrayList<CobrarClientesPorRegion>();
		CobrarClientesPorRegion entity = new CobrarClientesPorRegion();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarClientesPorRegion.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesPorRegion>((List<CobrarClientesPorRegion>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesPorRegionsOriginal(entities);
			
			}  else {
				this.cobrarclientesporregionsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesPorRegionConstantesFunciones.quitarEspaciosCobrarClientesPorRegions(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarClientesPorRegion getEntityCobrarClientesPorRegion(String strPrefijo,CobrarClientesPorRegion entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_region(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.NOMBREREGION));
			entity.setnombre_provincia(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.NOMBREPROVINCIA));
			entity.setnombre_ciudad(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.NOMBRECIUDAD));
			entity.setnombre_zona(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.NOMBREZONA));
			entity.setnombre_ruta(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.NOMBRERUTA));
			entity.setnombre_vendedor(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.NOMBREVENDEDOR));
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.NOMBRE));
			entity.setapellido(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.APELLIDO));
			entity.setdireccion_direccion(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.DIRECCIONDIRECCION));
			entity.settelefono_telefono(resultSet.getString(strPrefijo+CobrarClientesPorRegionConstantesFunciones.TELEFONOTELEFONO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarClientesPorRegion getEntityCobrarClientesPorRegion(String strPrefijo,CobrarClientesPorRegion entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarClientesPorRegion.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarClientesPorRegion.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarClientesPorRegionLogic.setFieldReflectionCobrarClientesPorRegion(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarClientesPorRegion(Field field,String strPrefijo,String sColumn,CobrarClientesPorRegion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarClientesPorRegionConstantesFunciones.NOMBREREGION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.NOMBREPROVINCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.NOMBRECIUDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.NOMBREZONA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.NOMBRERUTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.NOMBREVENDEDOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.DIRECCIONDIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesPorRegionConstantesFunciones.TELEFONOTELEFONO:
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
	
	public void quitarCobrarClientesPorRegionsNulos() throws Exception {				
		
		List<CobrarClientesPorRegion> cobrarclientesporregionsAux= new ArrayList<CobrarClientesPorRegion>();
		
		for(CobrarClientesPorRegion cobrarclientesporregion:cobrarclientesporregions) {
			if(cobrarclientesporregion!=null) {
				cobrarclientesporregionsAux.add(cobrarclientesporregion);
			}
		}
		
		cobrarclientesporregions=cobrarclientesporregionsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarClientesPorRegion> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesPorRegion> entities = new  ArrayList<CobrarClientesPorRegion>();
		CobrarClientesPorRegion entity = new CobrarClientesPorRegion();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesPorRegion>((List<CobrarClientesPorRegion>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesPorRegionsOriginal(entities);
			
			}  else {
				this.cobrarclientesporregionsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesPorRegionConstantesFunciones.quitarEspaciosCobrarClientesPorRegions(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarclientesporregions = new  ArrayList<CobrarClientesPorRegion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesPorRegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesporregions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarclientesporregions = new  ArrayList<CobrarClientesPorRegion>();
		  		  
        try {
			//CobrarClientesPorRegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesporregions=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarClientesPorRegion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesPorRegion> entities = new  ArrayList<CobrarClientesPorRegion>();
		CobrarClientesPorRegion entity = new CobrarClientesPorRegion();		  
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
	
	public  List<CobrarClientesPorRegion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesPorRegion> entities = new  ArrayList<CobrarClientesPorRegion>();
		CobrarClientesPorRegion entity = new CobrarClientesPorRegion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesPorRegion();
				
				if(conMapGenerico) {
					entity.setMapCobrarClientesPorRegion( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarClientesPorRegion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarClientesPorRegionDataAccess.ISWITHSCHEMA);         		
					entity=CobrarClientesPorRegionLogic.getEntityCobrarClientesPorRegion("",entity,resultSet,listColumns);
					
					////entity.setCobrarClientesPorRegionOriginal( new CobrarClientesPorRegion());
					////entity.setCobrarClientesPorRegionOriginal(super.getEntity("",entity.getCobrarClientesPorRegionOriginal(),resultSet,CobrarClientesPorRegionDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarClientesPorRegionOriginal(CobrarClientesPorRegionDataAccess.getEntityCobrarClientesPorRegion("",entity.getCobrarClientesPorRegionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarClientesPorRegion relcobrarclientesporregion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarclientesporregion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CobrarClientesPorRegion relcobrarclientesporregion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relcobrarclientesporregion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Pais getPais(Connexion connexion,CobrarClientesPorRegion relcobrarclientesporregion)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);
			paisDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			pais=paisDataAccess.getEntity(connexion,relcobrarclientesporregion.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Region getRegion(Connexion connexion,CobrarClientesPorRegion relcobrarclientesporregion)throws SQLException,Exception {

		Region region= new Region();

		try {
			RegionDataAccess regionDataAccess=new RegionDataAccess();

			regionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			regionDataAccess.setConnexionType(this.connexionType);
			regionDataAccess.setParameterDbType(this.parameterDbType);
			regionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			region=regionDataAccess.getEntity(connexion,relcobrarclientesporregion.getid_region());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return region;

	}

	public Provincia getProvincia(Connexion connexion,CobrarClientesPorRegion relcobrarclientesporregion)throws SQLException,Exception {

		Provincia provincia= new Provincia();

		try {
			ProvinciaDataAccess provinciaDataAccess=new ProvinciaDataAccess();

			provinciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			provinciaDataAccess.setConnexionType(this.connexionType);
			provinciaDataAccess.setParameterDbType(this.parameterDbType);
			provinciaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			provincia=provinciaDataAccess.getEntity(connexion,relcobrarclientesporregion.getid_provincia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provincia;

	}

	public Ciudad getCiudad(Connexion connexion,CobrarClientesPorRegion relcobrarclientesporregion)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);
			ciudadDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ciudad=ciudadDataAccess.getEntity(connexion,relcobrarclientesporregion.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


	
	
	public void getCobrarClientesPorRegionsBusquedaCobrarClientesPorRegionWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad)throws Exception {
		try {
			//CobrarClientesPorRegionLogic cobrarclientesporregionLogic=new CobrarClientesPorRegionLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesPorRegionLogic.GetSelecSqlCobrarClientesPorRegion(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_pais,id_region,id_provincia,id_ciudad);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclientesporregions=this.getCobrarClientesPorRegions();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarClientesPorRegionsBusquedaCobrarClientesPorRegion(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad)throws Exception {
		try {
			//CobrarClientesPorRegionLogic cobrarclientesporregionLogic=new CobrarClientesPorRegionLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesPorRegionLogic.GetSelecSqlCobrarClientesPorRegion(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_pais,id_region,id_provincia,id_ciudad);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclientesporregions=this.getCobrarClientesPorRegions();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarClientesPorRegion(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarClientesPorRegion_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" c.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_pais!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_pais = "+id_pais.toString();
					existeWhere=true;
				}

				if(id_region!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_region = "+id_region.toString();
					existeWhere=true;
				}

				if(id_provincia!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_provincia = "+id_provincia.toString();
					existeWhere=true;
				}

				if(id_ciudad!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_ciudad = "+id_ciudad.toString();
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
	
	
	public void deepLoad(CobrarClientesPorRegion cobrarclientesporregion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarClientesPorRegionLogicAdditional.updateCobrarClientesPorRegionToGet(cobrarclientesporregion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarclientesporregion.setEmpresa(cobrarclientesporregionDataAccess.getEmpresa(connexion,cobrarclientesporregion));
		cobrarclientesporregion.setSucursal(cobrarclientesporregionDataAccess.getSucursal(connexion,cobrarclientesporregion));
		cobrarclientesporregion.setPais(cobrarclientesporregionDataAccess.getPais(connexion,cobrarclientesporregion));
		cobrarclientesporregion.setRegion(cobrarclientesporregionDataAccess.getRegion(connexion,cobrarclientesporregion));
		cobrarclientesporregion.setProvincia(cobrarclientesporregionDataAccess.getProvincia(connexion,cobrarclientesporregion));
		cobrarclientesporregion.setCiudad(cobrarclientesporregionDataAccess.getCiudad(connexion,cobrarclientesporregion));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarclientesporregion.setEmpresa(cobrarclientesporregionDataAccess.getEmpresa(connexion,cobrarclientesporregion));
			}

			if(clas.clas.equals(Sucursal.class)) {
				cobrarclientesporregion.setSucursal(cobrarclientesporregionDataAccess.getSucursal(connexion,cobrarclientesporregion));
			}

			if(clas.clas.equals(Pais.class)) {
				cobrarclientesporregion.setPais(cobrarclientesporregionDataAccess.getPais(connexion,cobrarclientesporregion));
			}

			if(clas.clas.equals(Region.class)) {
				cobrarclientesporregion.setRegion(cobrarclientesporregionDataAccess.getRegion(connexion,cobrarclientesporregion));
			}

			if(clas.clas.equals(Provincia.class)) {
				cobrarclientesporregion.setProvincia(cobrarclientesporregionDataAccess.getProvincia(connexion,cobrarclientesporregion));
			}

			if(clas.clas.equals(Ciudad.class)) {
				cobrarclientesporregion.setCiudad(cobrarclientesporregionDataAccess.getCiudad(connexion,cobrarclientesporregion));
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
			cobrarclientesporregion.setEmpresa(cobrarclientesporregionDataAccess.getEmpresa(connexion,cobrarclientesporregion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setSucursal(cobrarclientesporregionDataAccess.getSucursal(connexion,cobrarclientesporregion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setPais(cobrarclientesporregionDataAccess.getPais(connexion,cobrarclientesporregion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setRegion(cobrarclientesporregionDataAccess.getRegion(connexion,cobrarclientesporregion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setProvincia(cobrarclientesporregionDataAccess.getProvincia(connexion,cobrarclientesporregion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setCiudad(cobrarclientesporregionDataAccess.getCiudad(connexion,cobrarclientesporregion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarclientesporregion.setEmpresa(cobrarclientesporregionDataAccess.getEmpresa(connexion,cobrarclientesporregion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarclientesporregion.getEmpresa(),isDeep,deepLoadType,clases);
				
		cobrarclientesporregion.setSucursal(cobrarclientesporregionDataAccess.getSucursal(connexion,cobrarclientesporregion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cobrarclientesporregion.getSucursal(),isDeep,deepLoadType,clases);
				
		cobrarclientesporregion.setPais(cobrarclientesporregionDataAccess.getPais(connexion,cobrarclientesporregion));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(cobrarclientesporregion.getPais(),isDeep,deepLoadType,clases);
				
		cobrarclientesporregion.setRegion(cobrarclientesporregionDataAccess.getRegion(connexion,cobrarclientesporregion));
		RegionLogic regionLogic= new RegionLogic(connexion);
		regionLogic.deepLoad(cobrarclientesporregion.getRegion(),isDeep,deepLoadType,clases);
				
		cobrarclientesporregion.setProvincia(cobrarclientesporregionDataAccess.getProvincia(connexion,cobrarclientesporregion));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(cobrarclientesporregion.getProvincia(),isDeep,deepLoadType,clases);
				
		cobrarclientesporregion.setCiudad(cobrarclientesporregionDataAccess.getCiudad(connexion,cobrarclientesporregion));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(cobrarclientesporregion.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarclientesporregion.setEmpresa(cobrarclientesporregionDataAccess.getEmpresa(connexion,cobrarclientesporregion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarclientesporregion.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				cobrarclientesporregion.setSucursal(cobrarclientesporregionDataAccess.getSucursal(connexion,cobrarclientesporregion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cobrarclientesporregion.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Pais.class)) {
				cobrarclientesporregion.setPais(cobrarclientesporregionDataAccess.getPais(connexion,cobrarclientesporregion));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(cobrarclientesporregion.getPais(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Region.class)) {
				cobrarclientesporregion.setRegion(cobrarclientesporregionDataAccess.getRegion(connexion,cobrarclientesporregion));
				RegionLogic regionLogic= new RegionLogic(connexion);
				regionLogic.deepLoad(cobrarclientesporregion.getRegion(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Provincia.class)) {
				cobrarclientesporregion.setProvincia(cobrarclientesporregionDataAccess.getProvincia(connexion,cobrarclientesporregion));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(cobrarclientesporregion.getProvincia(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ciudad.class)) {
				cobrarclientesporregion.setCiudad(cobrarclientesporregionDataAccess.getCiudad(connexion,cobrarclientesporregion));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(cobrarclientesporregion.getCiudad(),isDeep,deepLoadType,clases);				
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
			cobrarclientesporregion.setEmpresa(cobrarclientesporregionDataAccess.getEmpresa(connexion,cobrarclientesporregion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarclientesporregion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setSucursal(cobrarclientesporregionDataAccess.getSucursal(connexion,cobrarclientesporregion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cobrarclientesporregion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setPais(cobrarclientesporregionDataAccess.getPais(connexion,cobrarclientesporregion));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(cobrarclientesporregion.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setRegion(cobrarclientesporregionDataAccess.getRegion(connexion,cobrarclientesporregion));
			RegionLogic regionLogic= new RegionLogic(connexion);
			regionLogic.deepLoad(cobrarclientesporregion.getRegion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setProvincia(cobrarclientesporregionDataAccess.getProvincia(connexion,cobrarclientesporregion));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(cobrarclientesporregion.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclientesporregion.setCiudad(cobrarclientesporregionDataAccess.getCiudad(connexion,cobrarclientesporregion));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(cobrarclientesporregion.getCiudad(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarclientesporregion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesPorRegionConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesPorRegion(cobrarclientesporregion);
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
			this.deepLoad(this.cobrarclientesporregion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesPorRegionConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesPorRegion(this.cobrarclientesporregion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarclientesporregions!=null) {
				for(CobrarClientesPorRegion cobrarclientesporregion:cobrarclientesporregions) {
					this.deepLoad(cobrarclientesporregion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesPorRegionConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesPorRegion(cobrarclientesporregions);
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
			if(cobrarclientesporregions!=null) {
				for(CobrarClientesPorRegion cobrarclientesporregion:cobrarclientesporregions) {
					this.deepLoad(cobrarclientesporregion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesPorRegionConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesPorRegion(cobrarclientesporregions);
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
	
	public CobrarClientesPorRegionParameterReturnGeneral procesarAccionCobrarClientesPorRegions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesPorRegion> cobrarclientesporregions,CobrarClientesPorRegionParameterReturnGeneral cobrarclientesporregionParameterGeneral)throws Exception {
		 try {	
			CobrarClientesPorRegionParameterReturnGeneral cobrarclientesporregionReturnGeneral=new CobrarClientesPorRegionParameterReturnGeneral();
	
			CobrarClientesPorRegionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclientesporregions,cobrarclientesporregionParameterGeneral,cobrarclientesporregionReturnGeneral);
			
			return cobrarclientesporregionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarClientesPorRegionParameterReturnGeneral procesarAccionCobrarClientesPorRegionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesPorRegion> cobrarclientesporregions,CobrarClientesPorRegionParameterReturnGeneral cobrarclientesporregionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarClientesPorRegionParameterReturnGeneral cobrarclientesporregionReturnGeneral=new CobrarClientesPorRegionParameterReturnGeneral();
	
			CobrarClientesPorRegionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclientesporregions,cobrarclientesporregionParameterGeneral,cobrarclientesporregionReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarclientesporregionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

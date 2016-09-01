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
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorGruposParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ActivosFijosPorGruposParameterGeneral;
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorGruposConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.ActivosFijosPorGrupos;

import com.bydan.erp.activosfijos.business.logic.report.ActivosFijosPorGruposLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ActivosFijosPorGruposLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ActivosFijosPorGruposLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ActivosFijosPorGruposLogic activosfijosporgruposDataAccess; 		
	protected ActivosFijosPorGrupos activosfijosporgrupos;
	protected List<ActivosFijosPorGrupos> activosfijosporgruposs;
	protected Object activosfijosporgruposObject;	
	protected List<Object> activosfijosporgrupossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ActivosFijosPorGruposLogic()throws SQLException,Exception {
		try	{
			this.activosfijosporgruposs= new ArrayList<ActivosFijosPorGrupos>();
			this.activosfijosporgrupos= new ActivosFijosPorGrupos();
			this.activosfijosporgruposObject=new Object();
			this.activosfijosporgrupossObject=new ArrayList<Object>();
			
			this.activosfijosporgruposDataAccess=this;
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
			this.activosfijosporgruposDataAccess.setConnexionType(this.connexionType);
			this.activosfijosporgruposDataAccess.setParameterDbType(this.parameterDbType);
			this.activosfijosporgruposDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ActivosFijosPorGruposLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.activosfijosporgruposs= new ArrayList<ActivosFijosPorGrupos>();
			this.activosfijosporgrupos= new ActivosFijosPorGrupos();
			this.activosfijosporgruposObject=new Object();
			this.activosfijosporgrupossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.activosfijosporgruposDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.activosfijosporgruposDataAccess.setConnexionType(this.connexionType);
			this.activosfijosporgruposDataAccess.setParameterDbType(this.parameterDbType);
			this.activosfijosporgruposDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ActivosFijosPorGrupos getActivosFijosPorGrupos() throws Exception {	
		ActivosFijosPorGruposLogicAdditional.checkActivosFijosPorGruposToGet(activosfijosporgrupos,this.datosCliente,this.arrDatoGeneral);
		ActivosFijosPorGruposLogicAdditional.updateActivosFijosPorGruposToGet(activosfijosporgrupos,this.arrDatoGeneral);
		
		return activosfijosporgrupos;
	}
		
	public void setActivosFijosPorGrupos(ActivosFijosPorGrupos newActivosFijosPorGrupos) {
		this.activosfijosporgrupos = newActivosFijosPorGrupos;
	}
	
	public List<ActivosFijosPorGrupos> getActivosFijosPorGruposs() throws Exception {		
		this.quitarActivosFijosPorGrupossNulos();
		
		ActivosFijosPorGruposLogicAdditional.checkActivosFijosPorGruposToGets(activosfijosporgruposs,this.datosCliente,this.arrDatoGeneral);
		
		for (ActivosFijosPorGrupos activosfijosporgruposLocal: activosfijosporgruposs ) {
			ActivosFijosPorGruposLogicAdditional.updateActivosFijosPorGruposToGet(activosfijosporgruposLocal,this.arrDatoGeneral);
		}
		
		return activosfijosporgruposs;
	}
	
	public void setActivosFijosPorGruposs(List<ActivosFijosPorGrupos> newActivosFijosPorGruposs) {
		this.activosfijosporgruposs = newActivosFijosPorGruposs;
	}
	
	public Object getActivosFijosPorGruposObject() {	
		//this.activosfijosporgruposObject=this.activosfijosporgruposDataAccess.getEntityObject();
		return this.activosfijosporgruposObject;
	}
		
	public void setActivosFijosPorGruposObject(Object newActivosFijosPorGruposObject) {
		this.activosfijosporgruposObject = newActivosFijosPorGruposObject;
	}
	
	public List<Object> getActivosFijosPorGrupossObject() {		
		//this.activosfijosporgrupossObject=this.activosfijosporgruposDataAccess.getEntitiesObject();
		return this.activosfijosporgrupossObject;
	}
		
	public void setActivosFijosPorGrupossObject(List<Object> newActivosFijosPorGrupossObject) {
		this.activosfijosporgrupossObject = newActivosFijosPorGrupossObject;
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
		activosfijosporgruposs = new  ArrayList<ActivosFijosPorGrupos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ActivosFijosPorGruposLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporgruposs=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		activosfijosporgruposs = new  ArrayList<ActivosFijosPorGrupos>();
		  		  
        try {
			//ActivosFijosPorGruposLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporgruposs=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		activosfijosporgruposs = new  ArrayList<ActivosFijosPorGrupos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ActivosFijosPorGruposLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporgruposs=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		activosfijosporgruposs = new  ArrayList<ActivosFijosPorGrupos>();
		  		  
        try {
			//ActivosFijosPorGruposLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporgruposs=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		activosfijosporgruposs = new  ArrayList<ActivosFijosPorGrupos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ActivosFijosPorGruposLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporgruposs=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		activosfijosporgruposs = new  ArrayList<ActivosFijosPorGrupos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ActivosFijosPorGruposLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporgruposs=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ActivosFijosPorGrupos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActivosFijosPorGrupos> entities = new  ArrayList<ActivosFijosPorGrupos>();
		ActivosFijosPorGrupos entity = new ActivosFijosPorGrupos();		  
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
	
	public  List<ActivosFijosPorGrupos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActivosFijosPorGrupos> entities = new  ArrayList<ActivosFijosPorGrupos>();
		ActivosFijosPorGrupos entity = new ActivosFijosPorGrupos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ActivosFijosPorGrupos();
				
				
      	    	entity=ActivosFijosPorGruposLogic.getEntityActivosFijosPorGrupos("",entity,resultSet);
      	    	
				//entity.setActivosFijosPorGruposOriginal( new ActivosFijosPorGrupos());
      	    	//entity.setActivosFijosPorGruposOriginal(super.getEntity("",entity.getActivosFijosPorGruposOriginal(),resultSet,ActivosFijosPorGruposDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setActivosFijosPorGruposOriginal(ActivosFijosPorGruposDataAccess.getEntityActivosFijosPorGrupos("",entity.getActivosFijosPorGruposOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ActivosFijosPorGrupos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActivosFijosPorGrupos> entities = new  ArrayList<ActivosFijosPorGrupos>();
		ActivosFijosPorGrupos entity = new ActivosFijosPorGrupos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ActivosFijosPorGrupos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ActivosFijosPorGrupos>((List<ActivosFijosPorGrupos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setActivosFijosPorGrupossOriginal(entities);
			
			}  else {
				this.activosfijosporgrupossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ActivosFijosPorGruposConstantesFunciones.quitarEspaciosActivosFijosPorGruposs(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ActivosFijosPorGrupos getEntityActivosFijosPorGrupos(String strPrefijo,ActivosFijosPorGrupos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_sub_grupo(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.CODIGOSUBGRUPO));
			entity.setnombre_sub_grupo(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.NOMBRESUBGRUPO));
			entity.setcodigo_detalle_grupo(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.CODIGODETALLEGRUPO));
			entity.setnombre_detalle_grupo(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.NOMBREDETALLEGRUPO));
			entity.setclave(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.CLAVE));
			entity.setnombre(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.NOMBRE));
			entity.setfecha_compra(new Date(resultSet.getDate(strPrefijo+ActivosFijosPorGruposConstantesFunciones.FECHACOMPRA).getTime()));
			entity.setvida_util(resultSet.getDouble(strPrefijo+ActivosFijosPorGruposConstantesFunciones.VIDAUTIL));
			entity.setcosto_de_compra(resultSet.getDouble(strPrefijo+ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA));
			entity.setmarca(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.MARCA));
			entity.setmodelo(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.MODELO));
			entity.setcolor(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.COLOR));
			entity.setserie(resultSet.getString(strPrefijo+ActivosFijosPorGruposConstantesFunciones.SERIE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ActivosFijosPorGrupos getEntityActivosFijosPorGrupos(String strPrefijo,ActivosFijosPorGrupos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ActivosFijosPorGrupos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ActivosFijosPorGrupos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ActivosFijosPorGruposLogic.setFieldReflectionActivosFijosPorGrupos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionActivosFijosPorGrupos(Field field,String strPrefijo,String sColumn,ActivosFijosPorGrupos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ActivosFijosPorGruposConstantesFunciones.CODIGOSUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.NOMBRESUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.CODIGODETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.NOMBREDETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.CLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.FECHACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.VIDAUTIL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.MARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.MODELO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.COLOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorGruposConstantesFunciones.SERIE:
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
	
	public void quitarActivosFijosPorGrupossNulos() throws Exception {				
		
		List<ActivosFijosPorGrupos> activosfijosporgrupossAux= new ArrayList<ActivosFijosPorGrupos>();
		
		for(ActivosFijosPorGrupos activosfijosporgrupos:activosfijosporgruposs) {
			if(activosfijosporgrupos!=null) {
				activosfijosporgrupossAux.add(activosfijosporgrupos);
			}
		}
		
		activosfijosporgruposs=activosfijosporgrupossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ActivosFijosPorGrupos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActivosFijosPorGrupos> entities = new  ArrayList<ActivosFijosPorGrupos>();
		ActivosFijosPorGrupos entity = new ActivosFijosPorGrupos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ActivosFijosPorGrupos>((List<ActivosFijosPorGrupos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setActivosFijosPorGrupossOriginal(entities);
			
			}  else {
				this.activosfijosporgrupossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ActivosFijosPorGruposConstantesFunciones.quitarEspaciosActivosFijosPorGruposs(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		activosfijosporgruposs = new  ArrayList<ActivosFijosPorGrupos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ActivosFijosPorGruposLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporgruposs=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		activosfijosporgruposs = new  ArrayList<ActivosFijosPorGrupos>();
		  		  
        try {
			//ActivosFijosPorGruposLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporgruposs=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ActivosFijosPorGrupos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ActivosFijosPorGrupos> entities = new  ArrayList<ActivosFijosPorGrupos>();
		ActivosFijosPorGrupos entity = new ActivosFijosPorGrupos();		  
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
	
	public  List<ActivosFijosPorGrupos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ActivosFijosPorGrupos> entities = new  ArrayList<ActivosFijosPorGrupos>();
		ActivosFijosPorGrupos entity = new ActivosFijosPorGrupos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ActivosFijosPorGrupos();
				
				if(conMapGenerico) {
					entity.setMapActivosFijosPorGrupos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapActivosFijosPorGrupos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ActivosFijosPorGruposDataAccess.ISWITHSCHEMA);         		
					entity=ActivosFijosPorGruposLogic.getEntityActivosFijosPorGrupos("",entity,resultSet,listColumns);
					
					////entity.setActivosFijosPorGruposOriginal( new ActivosFijosPorGrupos());
					////entity.setActivosFijosPorGruposOriginal(super.getEntity("",entity.getActivosFijosPorGruposOriginal(),resultSet,ActivosFijosPorGruposDataAccess.ISWITHSCHEMA));         		
					////entity.setActivosFijosPorGruposOriginal(ActivosFijosPorGruposDataAccess.getEntityActivosFijosPorGrupos("",entity.getActivosFijosPorGruposOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ActivosFijosPorGrupos relactivosfijosporgrupos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relactivosfijosporgrupos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ActivosFijosPorGrupos relactivosfijosporgrupos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relactivosfijosporgrupos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}


	
	
	public void getActivosFijosPorGrupossBusquedaActivosFijosPorGruposWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//ActivosFijosPorGruposLogic activosfijosporgruposLogic=new ActivosFijosPorGruposLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ActivosFijosPorGruposLogic.GetSelecSqlActivosFijosPorGrupos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.activosfijosporgruposs=this.getActivosFijosPorGruposs();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getActivosFijosPorGrupossBusquedaActivosFijosPorGrupos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//ActivosFijosPorGruposLogic activosfijosporgruposLogic=new ActivosFijosPorGruposLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ActivosFijosPorGruposLogic.GetSelecSqlActivosFijosPorGrupos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.activosfijosporgruposs=this.getActivosFijosPorGruposs();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlActivosFijosPorGrupos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ActivosFijosPorGrupos_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" id_sucursal="+parametroGeneralUsuario.getid_sucursal();
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
	
	
	public void deepLoad(ActivosFijosPorGrupos activosfijosporgrupos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ActivosFijosPorGruposLogicAdditional.updateActivosFijosPorGruposToGet(activosfijosporgrupos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		activosfijosporgrupos.setEmpresa(activosfijosporgruposDataAccess.getEmpresa(connexion,activosfijosporgrupos));
		activosfijosporgrupos.setSucursal(activosfijosporgruposDataAccess.getSucursal(connexion,activosfijosporgrupos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				activosfijosporgrupos.setEmpresa(activosfijosporgruposDataAccess.getEmpresa(connexion,activosfijosporgrupos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				activosfijosporgrupos.setSucursal(activosfijosporgruposDataAccess.getSucursal(connexion,activosfijosporgrupos));
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
			activosfijosporgrupos.setEmpresa(activosfijosporgruposDataAccess.getEmpresa(connexion,activosfijosporgrupos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			activosfijosporgrupos.setSucursal(activosfijosporgruposDataAccess.getSucursal(connexion,activosfijosporgrupos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		activosfijosporgrupos.setEmpresa(activosfijosporgruposDataAccess.getEmpresa(connexion,activosfijosporgrupos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(activosfijosporgrupos.getEmpresa(),isDeep,deepLoadType,clases);
				
		activosfijosporgrupos.setSucursal(activosfijosporgruposDataAccess.getSucursal(connexion,activosfijosporgrupos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(activosfijosporgrupos.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				activosfijosporgrupos.setEmpresa(activosfijosporgruposDataAccess.getEmpresa(connexion,activosfijosporgrupos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(activosfijosporgrupos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				activosfijosporgrupos.setSucursal(activosfijosporgruposDataAccess.getSucursal(connexion,activosfijosporgrupos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(activosfijosporgrupos.getSucursal(),isDeep,deepLoadType,clases);				
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
			activosfijosporgrupos.setEmpresa(activosfijosporgruposDataAccess.getEmpresa(connexion,activosfijosporgrupos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(activosfijosporgrupos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			activosfijosporgrupos.setSucursal(activosfijosporgruposDataAccess.getSucursal(connexion,activosfijosporgrupos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(activosfijosporgrupos.getSucursal(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(activosfijosporgrupos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ActivosFijosPorGruposConstantesFunciones.refrescarForeignKeysDescripcionesActivosFijosPorGrupos(activosfijosporgrupos);
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
			this.deepLoad(this.activosfijosporgrupos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ActivosFijosPorGruposConstantesFunciones.refrescarForeignKeysDescripcionesActivosFijosPorGrupos(this.activosfijosporgrupos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(activosfijosporgruposs!=null) {
				for(ActivosFijosPorGrupos activosfijosporgrupos:activosfijosporgruposs) {
					this.deepLoad(activosfijosporgrupos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ActivosFijosPorGruposConstantesFunciones.refrescarForeignKeysDescripcionesActivosFijosPorGrupos(activosfijosporgruposs);
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
			if(activosfijosporgruposs!=null) {
				for(ActivosFijosPorGrupos activosfijosporgrupos:activosfijosporgruposs) {
					this.deepLoad(activosfijosporgrupos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ActivosFijosPorGruposConstantesFunciones.refrescarForeignKeysDescripcionesActivosFijosPorGrupos(activosfijosporgruposs);
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
	
	public ActivosFijosPorGruposParameterReturnGeneral procesarAccionActivosFijosPorGruposs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ActivosFijosPorGrupos> activosfijosporgruposs,ActivosFijosPorGruposParameterReturnGeneral activosfijosporgruposParameterGeneral)throws Exception {
		 try {	
			ActivosFijosPorGruposParameterReturnGeneral activosfijosporgruposReturnGeneral=new ActivosFijosPorGruposParameterReturnGeneral();
	
			ActivosFijosPorGruposLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,activosfijosporgruposs,activosfijosporgruposParameterGeneral,activosfijosporgruposReturnGeneral);
			
			return activosfijosporgruposReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ActivosFijosPorGruposParameterReturnGeneral procesarAccionActivosFijosPorGrupossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ActivosFijosPorGrupos> activosfijosporgruposs,ActivosFijosPorGruposParameterReturnGeneral activosfijosporgruposParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ActivosFijosPorGruposParameterReturnGeneral activosfijosporgruposReturnGeneral=new ActivosFijosPorGruposParameterReturnGeneral();
	
			ActivosFijosPorGruposLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,activosfijosporgruposs,activosfijosporgruposParameterGeneral,activosfijosporgruposReturnGeneral);
			
			this.connexion.commit();
			
			return activosfijosporgruposReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

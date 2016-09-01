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
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorRamosParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ActivosFijosPorRamosParameterGeneral;
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorRamosConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.ActivosFijosPorRamos;

import com.bydan.erp.activosfijos.business.logic.report.ActivosFijosPorRamosLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;






@SuppressWarnings("unused")
public class ActivosFijosPorRamosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ActivosFijosPorRamosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ActivosFijosPorRamosLogic activosfijosporramosDataAccess; 		
	protected ActivosFijosPorRamos activosfijosporramos;
	protected List<ActivosFijosPorRamos> activosfijosporramoss;
	protected Object activosfijosporramosObject;	
	protected List<Object> activosfijosporramossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ActivosFijosPorRamosLogic()throws SQLException,Exception {
		try	{
			this.activosfijosporramoss= new ArrayList<ActivosFijosPorRamos>();
			this.activosfijosporramos= new ActivosFijosPorRamos();
			this.activosfijosporramosObject=new Object();
			this.activosfijosporramossObject=new ArrayList<Object>();
			
			this.activosfijosporramosDataAccess=this;
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
			this.activosfijosporramosDataAccess.setConnexionType(this.connexionType);
			this.activosfijosporramosDataAccess.setParameterDbType(this.parameterDbType);
			this.activosfijosporramosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ActivosFijosPorRamosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.activosfijosporramoss= new ArrayList<ActivosFijosPorRamos>();
			this.activosfijosporramos= new ActivosFijosPorRamos();
			this.activosfijosporramosObject=new Object();
			this.activosfijosporramossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.activosfijosporramosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.activosfijosporramosDataAccess.setConnexionType(this.connexionType);
			this.activosfijosporramosDataAccess.setParameterDbType(this.parameterDbType);
			this.activosfijosporramosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ActivosFijosPorRamos getActivosFijosPorRamos() throws Exception {	
		ActivosFijosPorRamosLogicAdditional.checkActivosFijosPorRamosToGet(activosfijosporramos,this.datosCliente,this.arrDatoGeneral);
		ActivosFijosPorRamosLogicAdditional.updateActivosFijosPorRamosToGet(activosfijosporramos,this.arrDatoGeneral);
		
		return activosfijosporramos;
	}
		
	public void setActivosFijosPorRamos(ActivosFijosPorRamos newActivosFijosPorRamos) {
		this.activosfijosporramos = newActivosFijosPorRamos;
	}
	
	public List<ActivosFijosPorRamos> getActivosFijosPorRamoss() throws Exception {		
		this.quitarActivosFijosPorRamossNulos();
		
		ActivosFijosPorRamosLogicAdditional.checkActivosFijosPorRamosToGets(activosfijosporramoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ActivosFijosPorRamos activosfijosporramosLocal: activosfijosporramoss ) {
			ActivosFijosPorRamosLogicAdditional.updateActivosFijosPorRamosToGet(activosfijosporramosLocal,this.arrDatoGeneral);
		}
		
		return activosfijosporramoss;
	}
	
	public void setActivosFijosPorRamoss(List<ActivosFijosPorRamos> newActivosFijosPorRamoss) {
		this.activosfijosporramoss = newActivosFijosPorRamoss;
	}
	
	public Object getActivosFijosPorRamosObject() {	
		//this.activosfijosporramosObject=this.activosfijosporramosDataAccess.getEntityObject();
		return this.activosfijosporramosObject;
	}
		
	public void setActivosFijosPorRamosObject(Object newActivosFijosPorRamosObject) {
		this.activosfijosporramosObject = newActivosFijosPorRamosObject;
	}
	
	public List<Object> getActivosFijosPorRamossObject() {		
		//this.activosfijosporramossObject=this.activosfijosporramosDataAccess.getEntitiesObject();
		return this.activosfijosporramossObject;
	}
		
	public void setActivosFijosPorRamossObject(List<Object> newActivosFijosPorRamossObject) {
		this.activosfijosporramossObject = newActivosFijosPorRamossObject;
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
		activosfijosporramoss = new  ArrayList<ActivosFijosPorRamos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ActivosFijosPorRamosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporramoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		activosfijosporramoss = new  ArrayList<ActivosFijosPorRamos>();
		  		  
        try {
			//ActivosFijosPorRamosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporramoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		activosfijosporramoss = new  ArrayList<ActivosFijosPorRamos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ActivosFijosPorRamosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporramoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		activosfijosporramoss = new  ArrayList<ActivosFijosPorRamos>();
		  		  
        try {
			//ActivosFijosPorRamosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporramoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		activosfijosporramoss = new  ArrayList<ActivosFijosPorRamos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ActivosFijosPorRamosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporramoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		activosfijosporramoss = new  ArrayList<ActivosFijosPorRamos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ActivosFijosPorRamosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporramoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ActivosFijosPorRamos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActivosFijosPorRamos> entities = new  ArrayList<ActivosFijosPorRamos>();
		ActivosFijosPorRamos entity = new ActivosFijosPorRamos();		  
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
	
	public  List<ActivosFijosPorRamos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActivosFijosPorRamos> entities = new  ArrayList<ActivosFijosPorRamos>();
		ActivosFijosPorRamos entity = new ActivosFijosPorRamos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ActivosFijosPorRamos();
				
				
      	    	entity=ActivosFijosPorRamosLogic.getEntityActivosFijosPorRamos("",entity,resultSet);
      	    	
				//entity.setActivosFijosPorRamosOriginal( new ActivosFijosPorRamos());
      	    	//entity.setActivosFijosPorRamosOriginal(super.getEntity("",entity.getActivosFijosPorRamosOriginal(),resultSet,ActivosFijosPorRamosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setActivosFijosPorRamosOriginal(ActivosFijosPorRamosDataAccess.getEntityActivosFijosPorRamos("",entity.getActivosFijosPorRamosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ActivosFijosPorRamos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActivosFijosPorRamos> entities = new  ArrayList<ActivosFijosPorRamos>();
		ActivosFijosPorRamos entity = new ActivosFijosPorRamos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ActivosFijosPorRamos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ActivosFijosPorRamos>((List<ActivosFijosPorRamos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setActivosFijosPorRamossOriginal(entities);
			
			}  else {
				this.activosfijosporramossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ActivosFijosPorRamosConstantesFunciones.quitarEspaciosActivosFijosPorRamoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ActivosFijosPorRamos getEntityActivosFijosPorRamos(String strPrefijo,ActivosFijosPorRamos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sub_grupo(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.NOMBRESUBGRUPO));
			entity.setnombre_detalle_grupo(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.NOMBREDETALLEGRUPO));
			entity.setclave(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.CLAVE));
			entity.setnombre(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.NOMBRE));
			entity.setfecha_compra(new Date(resultSet.getDate(strPrefijo+ActivosFijosPorRamosConstantesFunciones.FECHACOMPRA).getTime()));
			entity.setvida_util(resultSet.getDouble(strPrefijo+ActivosFijosPorRamosConstantesFunciones.VIDAUTIL));
			entity.setcosto_de_compra(resultSet.getDouble(strPrefijo+ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA));
			entity.setmarca(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.MARCA));
			entity.setmodelo(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.MODELO));
			entity.setnumero_matricula(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.NUMEROMATRICULA));
			entity.setnumero_motor(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.NUMEROMOTOR));
			entity.setnumero_chasis(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.NUMEROCHASIS));
			entity.setnumero_placa(resultSet.getString(strPrefijo+ActivosFijosPorRamosConstantesFunciones.NUMEROPLACA));
			entity.setvalor_comercial(resultSet.getDouble(strPrefijo+ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ActivosFijosPorRamos getEntityActivosFijosPorRamos(String strPrefijo,ActivosFijosPorRamos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ActivosFijosPorRamos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ActivosFijosPorRamos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ActivosFijosPorRamosLogic.setFieldReflectionActivosFijosPorRamos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionActivosFijosPorRamos(Field field,String strPrefijo,String sColumn,ActivosFijosPorRamos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ActivosFijosPorRamosConstantesFunciones.NOMBRESUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.NOMBREDETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.CLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.FECHACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.VIDAUTIL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.MARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.MODELO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.NUMEROMATRICULA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.NUMEROMOTOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.NUMEROCHASIS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.NUMEROPLACA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL:
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
	
	public void quitarActivosFijosPorRamossNulos() throws Exception {				
		
		List<ActivosFijosPorRamos> activosfijosporramossAux= new ArrayList<ActivosFijosPorRamos>();
		
		for(ActivosFijosPorRamos activosfijosporramos:activosfijosporramoss) {
			if(activosfijosporramos!=null) {
				activosfijosporramossAux.add(activosfijosporramos);
			}
		}
		
		activosfijosporramoss=activosfijosporramossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ActivosFijosPorRamos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActivosFijosPorRamos> entities = new  ArrayList<ActivosFijosPorRamos>();
		ActivosFijosPorRamos entity = new ActivosFijosPorRamos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ActivosFijosPorRamos>((List<ActivosFijosPorRamos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setActivosFijosPorRamossOriginal(entities);
			
			}  else {
				this.activosfijosporramossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ActivosFijosPorRamosConstantesFunciones.quitarEspaciosActivosFijosPorRamoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		activosfijosporramoss = new  ArrayList<ActivosFijosPorRamos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ActivosFijosPorRamosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporramoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		activosfijosporramoss = new  ArrayList<ActivosFijosPorRamos>();
		  		  
        try {
			//ActivosFijosPorRamosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			activosfijosporramoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ActivosFijosPorRamos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ActivosFijosPorRamos> entities = new  ArrayList<ActivosFijosPorRamos>();
		ActivosFijosPorRamos entity = new ActivosFijosPorRamos();		  
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
	
	public  List<ActivosFijosPorRamos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ActivosFijosPorRamos> entities = new  ArrayList<ActivosFijosPorRamos>();
		ActivosFijosPorRamos entity = new ActivosFijosPorRamos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ActivosFijosPorRamos();
				
				if(conMapGenerico) {
					entity.setMapActivosFijosPorRamos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapActivosFijosPorRamos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ActivosFijosPorRamosDataAccess.ISWITHSCHEMA);         		
					entity=ActivosFijosPorRamosLogic.getEntityActivosFijosPorRamos("",entity,resultSet,listColumns);
					
					////entity.setActivosFijosPorRamosOriginal( new ActivosFijosPorRamos());
					////entity.setActivosFijosPorRamosOriginal(super.getEntity("",entity.getActivosFijosPorRamosOriginal(),resultSet,ActivosFijosPorRamosDataAccess.ISWITHSCHEMA));         		
					////entity.setActivosFijosPorRamosOriginal(ActivosFijosPorRamosDataAccess.getEntityActivosFijosPorRamos("",entity.getActivosFijosPorRamosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ActivosFijosPorRamos relactivosfijosporramos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relactivosfijosporramos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoRamoActivoFijo getTipoRamoActivoFijo(Connexion connexion,ActivosFijosPorRamos relactivosfijosporramos)throws SQLException,Exception {

		TipoRamoActivoFijo tiporamoactivofijo= new TipoRamoActivoFijo();

		try {
			TipoRamoActivoFijoDataAccess tiporamoactivofijoDataAccess=new TipoRamoActivoFijoDataAccess();

			tiporamoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporamoactivofijoDataAccess.setConnexionType(this.connexionType);
			tiporamoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			tiporamoactivofijoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tiporamoactivofijo=tiporamoactivofijoDataAccess.getEntity(connexion,relactivosfijosporramos.getid_tipo_ramo_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporamoactivofijo;

	}


	
	
	public void getActivosFijosPorRamossBusquedaActivosFijosPorRamosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_ramo_activo_fijo)throws Exception {
		try {
			//ActivosFijosPorRamosLogic activosfijosporramosLogic=new ActivosFijosPorRamosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ActivosFijosPorRamosLogic.GetSelecSqlActivosFijosPorRamos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_ramo_activo_fijo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.activosfijosporramoss=this.getActivosFijosPorRamoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getActivosFijosPorRamossBusquedaActivosFijosPorRamos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_ramo_activo_fijo)throws Exception {
		try {
			//ActivosFijosPorRamosLogic activosfijosporramosLogic=new ActivosFijosPorRamosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ActivosFijosPorRamosLogic.GetSelecSqlActivosFijosPorRamos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_ramo_activo_fijo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.activosfijosporramoss=this.getActivosFijosPorRamoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlActivosFijosPorRamos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_ramo_activo_fijo)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ActivosFijosPorRamos_Postgres.sql");
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
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" a.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_tipo_ramo_activo_fijo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_tipo_ramo_activo_fijo = "+id_tipo_ramo_activo_fijo.toString();
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
	
	
	public void deepLoad(ActivosFijosPorRamos activosfijosporramos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ActivosFijosPorRamosLogicAdditional.updateActivosFijosPorRamosToGet(activosfijosporramos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		activosfijosporramos.setEmpresa(activosfijosporramosDataAccess.getEmpresa(connexion,activosfijosporramos));
		activosfijosporramos.setTipoRamoActivoFijo(activosfijosporramosDataAccess.getTipoRamoActivoFijo(connexion,activosfijosporramos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				activosfijosporramos.setEmpresa(activosfijosporramosDataAccess.getEmpresa(connexion,activosfijosporramos));
			}

			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				activosfijosporramos.setTipoRamoActivoFijo(activosfijosporramosDataAccess.getTipoRamoActivoFijo(connexion,activosfijosporramos));
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
			activosfijosporramos.setEmpresa(activosfijosporramosDataAccess.getEmpresa(connexion,activosfijosporramos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			activosfijosporramos.setTipoRamoActivoFijo(activosfijosporramosDataAccess.getTipoRamoActivoFijo(connexion,activosfijosporramos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		activosfijosporramos.setEmpresa(activosfijosporramosDataAccess.getEmpresa(connexion,activosfijosporramos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(activosfijosporramos.getEmpresa(),isDeep,deepLoadType,clases);
				
		activosfijosporramos.setTipoRamoActivoFijo(activosfijosporramosDataAccess.getTipoRamoActivoFijo(connexion,activosfijosporramos));
		TipoRamoActivoFijoLogic tiporamoactivofijoLogic= new TipoRamoActivoFijoLogic(connexion);
		tiporamoactivofijoLogic.deepLoad(activosfijosporramos.getTipoRamoActivoFijo(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				activosfijosporramos.setEmpresa(activosfijosporramosDataAccess.getEmpresa(connexion,activosfijosporramos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(activosfijosporramos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				activosfijosporramos.setTipoRamoActivoFijo(activosfijosporramosDataAccess.getTipoRamoActivoFijo(connexion,activosfijosporramos));
				TipoRamoActivoFijoLogic tiporamoactivofijoLogic= new TipoRamoActivoFijoLogic(connexion);
				tiporamoactivofijoLogic.deepLoad(activosfijosporramos.getTipoRamoActivoFijo(),isDeep,deepLoadType,clases);				
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
			activosfijosporramos.setEmpresa(activosfijosporramosDataAccess.getEmpresa(connexion,activosfijosporramos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(activosfijosporramos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			activosfijosporramos.setTipoRamoActivoFijo(activosfijosporramosDataAccess.getTipoRamoActivoFijo(connexion,activosfijosporramos));
			TipoRamoActivoFijoLogic tiporamoactivofijoLogic= new TipoRamoActivoFijoLogic(connexion);
			tiporamoactivofijoLogic.deepLoad(activosfijosporramos.getTipoRamoActivoFijo(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(activosfijosporramos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ActivosFijosPorRamosConstantesFunciones.refrescarForeignKeysDescripcionesActivosFijosPorRamos(activosfijosporramos);
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
			this.deepLoad(this.activosfijosporramos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ActivosFijosPorRamosConstantesFunciones.refrescarForeignKeysDescripcionesActivosFijosPorRamos(this.activosfijosporramos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(activosfijosporramoss!=null) {
				for(ActivosFijosPorRamos activosfijosporramos:activosfijosporramoss) {
					this.deepLoad(activosfijosporramos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ActivosFijosPorRamosConstantesFunciones.refrescarForeignKeysDescripcionesActivosFijosPorRamos(activosfijosporramoss);
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
			if(activosfijosporramoss!=null) {
				for(ActivosFijosPorRamos activosfijosporramos:activosfijosporramoss) {
					this.deepLoad(activosfijosporramos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ActivosFijosPorRamosConstantesFunciones.refrescarForeignKeysDescripcionesActivosFijosPorRamos(activosfijosporramoss);
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
	
	public ActivosFijosPorRamosParameterReturnGeneral procesarAccionActivosFijosPorRamoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ActivosFijosPorRamos> activosfijosporramoss,ActivosFijosPorRamosParameterReturnGeneral activosfijosporramosParameterGeneral)throws Exception {
		 try {	
			ActivosFijosPorRamosParameterReturnGeneral activosfijosporramosReturnGeneral=new ActivosFijosPorRamosParameterReturnGeneral();
	
			ActivosFijosPorRamosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,activosfijosporramoss,activosfijosporramosParameterGeneral,activosfijosporramosReturnGeneral);
			
			return activosfijosporramosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ActivosFijosPorRamosParameterReturnGeneral procesarAccionActivosFijosPorRamossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ActivosFijosPorRamos> activosfijosporramoss,ActivosFijosPorRamosParameterReturnGeneral activosfijosporramosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ActivosFijosPorRamosParameterReturnGeneral activosfijosporramosReturnGeneral=new ActivosFijosPorRamosParameterReturnGeneral();
	
			ActivosFijosPorRamosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,activosfijosporramoss,activosfijosporramosParameterGeneral,activosfijosporramosReturnGeneral);
			
			this.connexion.commit();
			
			return activosfijosporramosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

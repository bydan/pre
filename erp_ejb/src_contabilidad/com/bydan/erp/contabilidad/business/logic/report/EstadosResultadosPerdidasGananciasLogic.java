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
package com.bydan.erp.contabilidad.business.logic.report;

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

import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.resources.general.AuxiliarGeneral;
import com.bydan.erp.contabilidad.util.report.EstadosResultadosPerdidasGananciasParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.EstadosResultadosPerdidasGananciasParameterGeneral;
import com.bydan.erp.contabilidad.util.report.EstadosResultadosPerdidasGananciasConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.EstadosResultadosPerdidasGanancias;

import com.bydan.erp.contabilidad.business.logic.report.EstadosResultadosPerdidasGananciasLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class EstadosResultadosPerdidasGananciasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(EstadosResultadosPerdidasGananciasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected EstadosResultadosPerdidasGananciasLogic estadosresultadosperdidasgananciasDataAccess; 		
	protected EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias;
	protected List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass;
	protected Object estadosresultadosperdidasgananciasObject;	
	protected List<Object> estadosresultadosperdidasgananciassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  EstadosResultadosPerdidasGananciasLogic()throws SQLException,Exception {
		try	{
			this.estadosresultadosperdidasgananciass= new ArrayList<EstadosResultadosPerdidasGanancias>();
			this.estadosresultadosperdidasganancias= new EstadosResultadosPerdidasGanancias();
			this.estadosresultadosperdidasgananciasObject=new Object();
			this.estadosresultadosperdidasgananciassObject=new ArrayList<Object>();
			
			this.estadosresultadosperdidasgananciasDataAccess=this;
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
			this.estadosresultadosperdidasgananciasDataAccess.setConnexionType(this.connexionType);
			this.estadosresultadosperdidasgananciasDataAccess.setParameterDbType(this.parameterDbType);
			this.estadosresultadosperdidasgananciasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadosResultadosPerdidasGananciasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.estadosresultadosperdidasgananciass= new ArrayList<EstadosResultadosPerdidasGanancias>();
			this.estadosresultadosperdidasganancias= new EstadosResultadosPerdidasGanancias();
			this.estadosresultadosperdidasgananciasObject=new Object();
			this.estadosresultadosperdidasgananciassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.estadosresultadosperdidasgananciasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.estadosresultadosperdidasgananciasDataAccess.setConnexionType(this.connexionType);
			this.estadosresultadosperdidasgananciasDataAccess.setParameterDbType(this.parameterDbType);
			this.estadosresultadosperdidasgananciasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadosResultadosPerdidasGanancias getEstadosResultadosPerdidasGanancias() throws Exception {	
		EstadosResultadosPerdidasGananciasLogicAdditional.checkEstadosResultadosPerdidasGananciasToGet(estadosresultadosperdidasganancias,this.datosCliente,this.arrDatoGeneral);
		EstadosResultadosPerdidasGananciasLogicAdditional.updateEstadosResultadosPerdidasGananciasToGet(estadosresultadosperdidasganancias,this.arrDatoGeneral);
		
		return estadosresultadosperdidasganancias;
	}
		
	public void setEstadosResultadosPerdidasGanancias(EstadosResultadosPerdidasGanancias newEstadosResultadosPerdidasGanancias) {
		this.estadosresultadosperdidasganancias = newEstadosResultadosPerdidasGanancias;
	}
	
	public List<EstadosResultadosPerdidasGanancias> getEstadosResultadosPerdidasGananciass() throws Exception {		
		this.quitarEstadosResultadosPerdidasGananciassNulos();
		
		EstadosResultadosPerdidasGananciasLogicAdditional.checkEstadosResultadosPerdidasGananciasToGets(estadosresultadosperdidasgananciass,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasLocal: estadosresultadosperdidasgananciass ) {
			EstadosResultadosPerdidasGananciasLogicAdditional.updateEstadosResultadosPerdidasGananciasToGet(estadosresultadosperdidasgananciasLocal,this.arrDatoGeneral);
		}
		
		return estadosresultadosperdidasgananciass;
	}
	
	public void setEstadosResultadosPerdidasGananciass(List<EstadosResultadosPerdidasGanancias> newEstadosResultadosPerdidasGananciass) {
		this.estadosresultadosperdidasgananciass = newEstadosResultadosPerdidasGananciass;
	}
	
	public Object getEstadosResultadosPerdidasGananciasObject() {	
		//this.estadosresultadosperdidasgananciasObject=this.estadosresultadosperdidasgananciasDataAccess.getEntityObject();
		return this.estadosresultadosperdidasgananciasObject;
	}
		
	public void setEstadosResultadosPerdidasGananciasObject(Object newEstadosResultadosPerdidasGananciasObject) {
		this.estadosresultadosperdidasgananciasObject = newEstadosResultadosPerdidasGananciasObject;
	}
	
	public List<Object> getEstadosResultadosPerdidasGananciassObject() {		
		//this.estadosresultadosperdidasgananciassObject=this.estadosresultadosperdidasgananciasDataAccess.getEntitiesObject();
		return this.estadosresultadosperdidasgananciassObject;
	}
		
	public void setEstadosResultadosPerdidasGananciassObject(List<Object> newEstadosResultadosPerdidasGananciassObject) {
		this.estadosresultadosperdidasgananciassObject = newEstadosResultadosPerdidasGananciassObject;
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
		estadosresultadosperdidasgananciass = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EstadosResultadosPerdidasGananciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosresultadosperdidasgananciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		estadosresultadosperdidasgananciass = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		  		  
        try {
			//EstadosResultadosPerdidasGananciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosresultadosperdidasgananciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadosresultadosperdidasgananciass = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EstadosResultadosPerdidasGananciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosresultadosperdidasgananciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		estadosresultadosperdidasgananciass = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		  		  
        try {
			//EstadosResultadosPerdidasGananciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosresultadosperdidasgananciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		estadosresultadosperdidasgananciass = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EstadosResultadosPerdidasGananciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosresultadosperdidasgananciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		estadosresultadosperdidasgananciass = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//EstadosResultadosPerdidasGananciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosresultadosperdidasgananciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<EstadosResultadosPerdidasGanancias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadosResultadosPerdidasGanancias> entities = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		EstadosResultadosPerdidasGanancias entity = new EstadosResultadosPerdidasGanancias();		  
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
	
	public  List<EstadosResultadosPerdidasGanancias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadosResultadosPerdidasGanancias> entities = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		EstadosResultadosPerdidasGanancias entity = new EstadosResultadosPerdidasGanancias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadosResultadosPerdidasGanancias();
				
				
      	    	entity=EstadosResultadosPerdidasGananciasLogic.getEntityEstadosResultadosPerdidasGanancias("",entity,resultSet);
      	    	
				//entity.setEstadosResultadosPerdidasGananciasOriginal( new EstadosResultadosPerdidasGanancias());
      	    	//entity.setEstadosResultadosPerdidasGananciasOriginal(super.getEntity("",entity.getEstadosResultadosPerdidasGananciasOriginal(),resultSet,EstadosResultadosPerdidasGananciasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadosResultadosPerdidasGananciasOriginal(EstadosResultadosPerdidasGananciasDataAccess.getEntityEstadosResultadosPerdidasGanancias("",entity.getEstadosResultadosPerdidasGananciasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<EstadosResultadosPerdidasGanancias> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadosResultadosPerdidasGanancias> entities = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		EstadosResultadosPerdidasGanancias entity = new EstadosResultadosPerdidasGanancias();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,EstadosResultadosPerdidasGanancias.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EstadosResultadosPerdidasGanancias>((List<EstadosResultadosPerdidasGanancias>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEstadosResultadosPerdidasGananciassOriginal(entities);
			
			}  else {
				this.estadosresultadosperdidasgananciassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EstadosResultadosPerdidasGananciasConstantesFunciones.quitarEspaciosEstadosResultadosPerdidasGananciass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static EstadosResultadosPerdidasGanancias getEntityEstadosResultadosPerdidasGanancias(String strPrefijo,EstadosResultadosPerdidasGanancias entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+EstadosResultadosPerdidasGananciasConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRE));
			entity.setnombre_nivel_cuenta(resultSet.getString(strPrefijo+EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRENIVELCUENTA));
			entity.setdebito_inicial(resultSet.getDouble(strPrefijo+EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL));
			entity.setcredito_inicial(resultSet.getDouble(strPrefijo+EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL));
			entity.setsaldo_inicial(resultSet.getDouble(strPrefijo+EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadosResultadosPerdidasGanancias getEntityEstadosResultadosPerdidasGanancias(String strPrefijo,EstadosResultadosPerdidasGanancias entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = EstadosResultadosPerdidasGanancias.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = EstadosResultadosPerdidasGanancias.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				EstadosResultadosPerdidasGananciasLogic.setFieldReflectionEstadosResultadosPerdidasGanancias(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadosResultadosPerdidasGanancias(Field field,String strPrefijo,String sColumn,EstadosResultadosPerdidasGanancias entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadosResultadosPerdidasGananciasConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRENIVELCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL:
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
	
	public void quitarEstadosResultadosPerdidasGananciassNulos() throws Exception {				
		
		List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciassAux= new ArrayList<EstadosResultadosPerdidasGanancias>();
		
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias:estadosresultadosperdidasgananciass) {
			if(estadosresultadosperdidasganancias!=null) {
				estadosresultadosperdidasgananciassAux.add(estadosresultadosperdidasganancias);
			}
		}
		
		estadosresultadosperdidasgananciass=estadosresultadosperdidasgananciassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<EstadosResultadosPerdidasGanancias> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadosResultadosPerdidasGanancias> entities = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		EstadosResultadosPerdidasGanancias entity = new EstadosResultadosPerdidasGanancias();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EstadosResultadosPerdidasGanancias>((List<EstadosResultadosPerdidasGanancias>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEstadosResultadosPerdidasGananciassOriginal(entities);
			
			}  else {
				this.estadosresultadosperdidasgananciassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EstadosResultadosPerdidasGananciasConstantesFunciones.quitarEspaciosEstadosResultadosPerdidasGananciass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		estadosresultadosperdidasgananciass = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EstadosResultadosPerdidasGananciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosresultadosperdidasgananciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		estadosresultadosperdidasgananciass = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		  		  
        try {
			//EstadosResultadosPerdidasGananciasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosresultadosperdidasgananciass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<EstadosResultadosPerdidasGanancias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadosResultadosPerdidasGanancias> entities = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		EstadosResultadosPerdidasGanancias entity = new EstadosResultadosPerdidasGanancias();		  
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
	
	public  List<EstadosResultadosPerdidasGanancias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadosResultadosPerdidasGanancias> entities = new  ArrayList<EstadosResultadosPerdidasGanancias>();
		EstadosResultadosPerdidasGanancias entity = new EstadosResultadosPerdidasGanancias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadosResultadosPerdidasGanancias();
				
				if(conMapGenerico) {
					entity.setMapEstadosResultadosPerdidasGanancias( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapEstadosResultadosPerdidasGanancias().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadosResultadosPerdidasGananciasDataAccess.ISWITHSCHEMA);         		
					entity=EstadosResultadosPerdidasGananciasLogic.getEntityEstadosResultadosPerdidasGanancias("",entity,resultSet,listColumns);
					
					////entity.setEstadosResultadosPerdidasGananciasOriginal( new EstadosResultadosPerdidasGanancias());
					////entity.setEstadosResultadosPerdidasGananciasOriginal(super.getEntity("",entity.getEstadosResultadosPerdidasGananciasOriginal(),resultSet,EstadosResultadosPerdidasGananciasDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadosResultadosPerdidasGananciasOriginal(EstadosResultadosPerdidasGananciasDataAccess.getEntityEstadosResultadosPerdidasGanancias("",entity.getEstadosResultadosPerdidasGananciasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,EstadosResultadosPerdidasGanancias relestadosresultadosperdidasganancias)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relestadosresultadosperdidasganancias.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public NivelCuenta getNivelCuenta(Connexion connexion,EstadosResultadosPerdidasGanancias relestadosresultadosperdidasganancias)throws SQLException,Exception {

		NivelCuenta nivelcuenta= new NivelCuenta();

		try {
			NivelCuentaDataAccess nivelcuentaDataAccess=new NivelCuentaDataAccess();

			nivelcuentaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			nivelcuentaDataAccess.setConnexionType(this.connexionType);
			nivelcuentaDataAccess.setParameterDbType(this.parameterDbType);
			nivelcuentaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion,relestadosresultadosperdidasganancias.getid_nivel_cuenta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return nivelcuenta;

	}

	public Ejercicio getEjercicio(Connexion connexion,EstadosResultadosPerdidasGanancias relestadosresultadosperdidasganancias)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relestadosresultadosperdidasganancias.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,EstadosResultadosPerdidasGanancias relestadosresultadosperdidasganancias)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);
			periodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periodo=periodoDataAccess.getEntity(connexion,relestadosresultadosperdidasganancias.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}


	
	
	public void getEstadosResultadosPerdidasGananciassBusquedaEstadosResultadosPerdidasGananciasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_nivel_cuenta,Long id_ejercicio,Long id_periodo)throws Exception {
		try {
			//EstadosResultadosPerdidasGananciasLogic estadosresultadosperdidasgananciasLogic=new EstadosResultadosPerdidasGananciasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EstadosResultadosPerdidasGananciasLogic.GetSelecSqlEstadosResultadosPerdidasGanancias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_nivel_cuenta,id_ejercicio,id_periodo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.estadosresultadosperdidasgananciass=this.getEstadosResultadosPerdidasGananciass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getEstadosResultadosPerdidasGananciassBusquedaEstadosResultadosPerdidasGanancias(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_nivel_cuenta,Long id_ejercicio,Long id_periodo)throws Exception {
		try {
			//EstadosResultadosPerdidasGananciasLogic estadosresultadosperdidasgananciasLogic=new EstadosResultadosPerdidasGananciasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EstadosResultadosPerdidasGananciasLogic.GetSelecSqlEstadosResultadosPerdidasGanancias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_nivel_cuenta,id_ejercicio,id_periodo);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.estadosresultadosperdidasgananciass=this.getEstadosResultadosPerdidasGananciass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlEstadosResultadosPerdidasGanancias(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_nivel_cuenta,Long id_ejercicio,Long id_periodo)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("EstadosResultadosPerdidasGanancias_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				sSelectQuery=sSelectQuery.replace("IDEMPRESA", parametroGeneralUsuario.getid_empresa().toString());
				

				sSelectQuery=sSelectQuery.replace("ID_NIVEL_CUENTA", id_nivel_cuenta.toString());

				sSelectQuery=sSelectQuery.replace("ID_EJERCICIO", id_ejercicio.toString());

				sSelectQuery=sSelectQuery.replace("ID_PERIODO", id_periodo.toString());

				sSql=sSelectQuery;

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
	
	
	public void deepLoad(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadosResultadosPerdidasGananciasLogicAdditional.updateEstadosResultadosPerdidasGananciasToGet(estadosresultadosperdidasganancias,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadosresultadosperdidasganancias.setEmpresa(estadosresultadosperdidasgananciasDataAccess.getEmpresa(connexion,estadosresultadosperdidasganancias));
		estadosresultadosperdidasganancias.setNivelCuenta(estadosresultadosperdidasgananciasDataAccess.getNivelCuenta(connexion,estadosresultadosperdidasganancias));
		estadosresultadosperdidasganancias.setEjercicio(estadosresultadosperdidasgananciasDataAccess.getEjercicio(connexion,estadosresultadosperdidasganancias));
		estadosresultadosperdidasganancias.setPeriodo(estadosresultadosperdidasgananciasDataAccess.getPeriodo(connexion,estadosresultadosperdidasganancias));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadosresultadosperdidasganancias.setEmpresa(estadosresultadosperdidasgananciasDataAccess.getEmpresa(connexion,estadosresultadosperdidasganancias));
			}

			if(clas.clas.equals(NivelCuenta.class)) {
				estadosresultadosperdidasganancias.setNivelCuenta(estadosresultadosperdidasgananciasDataAccess.getNivelCuenta(connexion,estadosresultadosperdidasganancias));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				estadosresultadosperdidasganancias.setEjercicio(estadosresultadosperdidasgananciasDataAccess.getEjercicio(connexion,estadosresultadosperdidasganancias));
			}

			if(clas.clas.equals(Periodo.class)) {
				estadosresultadosperdidasganancias.setPeriodo(estadosresultadosperdidasgananciasDataAccess.getPeriodo(connexion,estadosresultadosperdidasganancias));
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
			estadosresultadosperdidasganancias.setEmpresa(estadosresultadosperdidasgananciasDataAccess.getEmpresa(connexion,estadosresultadosperdidasganancias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NivelCuenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosresultadosperdidasganancias.setNivelCuenta(estadosresultadosperdidasgananciasDataAccess.getNivelCuenta(connexion,estadosresultadosperdidasganancias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosresultadosperdidasganancias.setEjercicio(estadosresultadosperdidasgananciasDataAccess.getEjercicio(connexion,estadosresultadosperdidasganancias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosresultadosperdidasganancias.setPeriodo(estadosresultadosperdidasgananciasDataAccess.getPeriodo(connexion,estadosresultadosperdidasganancias));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadosresultadosperdidasganancias.setEmpresa(estadosresultadosperdidasgananciasDataAccess.getEmpresa(connexion,estadosresultadosperdidasganancias));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(estadosresultadosperdidasganancias.getEmpresa(),isDeep,deepLoadType,clases);
				
		estadosresultadosperdidasganancias.setNivelCuenta(estadosresultadosperdidasgananciasDataAccess.getNivelCuenta(connexion,estadosresultadosperdidasganancias));
		NivelCuentaLogic nivelcuentaLogic= new NivelCuentaLogic(connexion);
		nivelcuentaLogic.deepLoad(estadosresultadosperdidasganancias.getNivelCuenta(),isDeep,deepLoadType,clases);
				
		estadosresultadosperdidasganancias.setEjercicio(estadosresultadosperdidasgananciasDataAccess.getEjercicio(connexion,estadosresultadosperdidasganancias));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(estadosresultadosperdidasganancias.getEjercicio(),isDeep,deepLoadType,clases);
				
		estadosresultadosperdidasganancias.setPeriodo(estadosresultadosperdidasgananciasDataAccess.getPeriodo(connexion,estadosresultadosperdidasganancias));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(estadosresultadosperdidasganancias.getPeriodo(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadosresultadosperdidasganancias.setEmpresa(estadosresultadosperdidasgananciasDataAccess.getEmpresa(connexion,estadosresultadosperdidasganancias));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(estadosresultadosperdidasganancias.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(NivelCuenta.class)) {
				estadosresultadosperdidasganancias.setNivelCuenta(estadosresultadosperdidasgananciasDataAccess.getNivelCuenta(connexion,estadosresultadosperdidasganancias));
				NivelCuentaLogic nivelcuentaLogic= new NivelCuentaLogic(connexion);
				nivelcuentaLogic.deepLoad(estadosresultadosperdidasganancias.getNivelCuenta(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				estadosresultadosperdidasganancias.setEjercicio(estadosresultadosperdidasgananciasDataAccess.getEjercicio(connexion,estadosresultadosperdidasganancias));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(estadosresultadosperdidasganancias.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Periodo.class)) {
				estadosresultadosperdidasganancias.setPeriodo(estadosresultadosperdidasgananciasDataAccess.getPeriodo(connexion,estadosresultadosperdidasganancias));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(estadosresultadosperdidasganancias.getPeriodo(),isDeep,deepLoadType,clases);				
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
			estadosresultadosperdidasganancias.setEmpresa(estadosresultadosperdidasgananciasDataAccess.getEmpresa(connexion,estadosresultadosperdidasganancias));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(estadosresultadosperdidasganancias.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NivelCuenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosresultadosperdidasganancias.setNivelCuenta(estadosresultadosperdidasgananciasDataAccess.getNivelCuenta(connexion,estadosresultadosperdidasganancias));
			NivelCuentaLogic nivelcuentaLogic= new NivelCuentaLogic(connexion);
			nivelcuentaLogic.deepLoad(estadosresultadosperdidasganancias.getNivelCuenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosresultadosperdidasganancias.setEjercicio(estadosresultadosperdidasgananciasDataAccess.getEjercicio(connexion,estadosresultadosperdidasganancias));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(estadosresultadosperdidasganancias.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosresultadosperdidasganancias.setPeriodo(estadosresultadosperdidasgananciasDataAccess.getPeriodo(connexion,estadosresultadosperdidasganancias));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(estadosresultadosperdidasganancias.getPeriodo(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(estadosresultadosperdidasganancias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadosResultadosPerdidasGananciasConstantesFunciones.refrescarForeignKeysDescripcionesEstadosResultadosPerdidasGanancias(estadosresultadosperdidasganancias);
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
			this.deepLoad(this.estadosresultadosperdidasganancias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadosResultadosPerdidasGananciasConstantesFunciones.refrescarForeignKeysDescripcionesEstadosResultadosPerdidasGanancias(this.estadosresultadosperdidasganancias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(estadosresultadosperdidasgananciass!=null) {
				for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias:estadosresultadosperdidasgananciass) {
					this.deepLoad(estadosresultadosperdidasganancias,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadosResultadosPerdidasGananciasConstantesFunciones.refrescarForeignKeysDescripcionesEstadosResultadosPerdidasGanancias(estadosresultadosperdidasgananciass);
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
			if(estadosresultadosperdidasgananciass!=null) {
				for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias:estadosresultadosperdidasgananciass) {
					this.deepLoad(estadosresultadosperdidasganancias,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadosResultadosPerdidasGananciasConstantesFunciones.refrescarForeignKeysDescripcionesEstadosResultadosPerdidasGanancias(estadosresultadosperdidasgananciass);
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
	
	public EstadosResultadosPerdidasGananciasParameterReturnGeneral procesarAccionEstadosResultadosPerdidasGananciass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,EstadosResultadosPerdidasGananciasParameterReturnGeneral estadosresultadosperdidasgananciasParameterGeneral)throws Exception {
		 try {	
			EstadosResultadosPerdidasGananciasParameterReturnGeneral estadosresultadosperdidasgananciasReturnGeneral=new EstadosResultadosPerdidasGananciasParameterReturnGeneral();
	
			EstadosResultadosPerdidasGananciasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadosresultadosperdidasgananciass,estadosresultadosperdidasgananciasParameterGeneral,estadosresultadosperdidasgananciasReturnGeneral);
			
			return estadosresultadosperdidasgananciasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadosResultadosPerdidasGananciasParameterReturnGeneral procesarAccionEstadosResultadosPerdidasGananciassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,EstadosResultadosPerdidasGananciasParameterReturnGeneral estadosresultadosperdidasgananciasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			EstadosResultadosPerdidasGananciasParameterReturnGeneral estadosresultadosperdidasgananciasReturnGeneral=new EstadosResultadosPerdidasGananciasParameterReturnGeneral();
	
			EstadosResultadosPerdidasGananciasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadosresultadosperdidasgananciass,estadosresultadosperdidasgananciasParameterGeneral,estadosresultadosperdidasgananciasReturnGeneral);
			
			this.connexion.commit();
			
			return estadosresultadosperdidasgananciasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

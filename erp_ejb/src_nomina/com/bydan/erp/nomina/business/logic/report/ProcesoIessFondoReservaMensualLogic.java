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
package com.bydan.erp.nomina.business.logic.report;

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

import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;
import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaMensualParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaMensualParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaMensualConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoIessFondoReservaMensual;

import com.bydan.erp.nomina.business.logic.report.ProcesoIessFondoReservaMensualLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoIessFondoReservaMensualLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoIessFondoReservaMensualLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoIessFondoReservaMensualLogic procesoiessfondoreservamensualDataAccess; 		
	protected ProcesoIessFondoReservaMensual procesoiessfondoreservamensual;
	protected List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals;
	protected Object procesoiessfondoreservamensualObject;	
	protected List<Object> procesoiessfondoreservamensualsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoIessFondoReservaMensualLogic()throws SQLException,Exception {
		try	{
			this.procesoiessfondoreservamensuals= new ArrayList<ProcesoIessFondoReservaMensual>();
			this.procesoiessfondoreservamensual= new ProcesoIessFondoReservaMensual();
			this.procesoiessfondoreservamensualObject=new Object();
			this.procesoiessfondoreservamensualsObject=new ArrayList<Object>();
			
			this.procesoiessfondoreservamensualDataAccess=this;
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
			this.procesoiessfondoreservamensualDataAccess.setConnexionType(this.connexionType);
			this.procesoiessfondoreservamensualDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoiessfondoreservamensualDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoIessFondoReservaMensualLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesoiessfondoreservamensuals= new ArrayList<ProcesoIessFondoReservaMensual>();
			this.procesoiessfondoreservamensual= new ProcesoIessFondoReservaMensual();
			this.procesoiessfondoreservamensualObject=new Object();
			this.procesoiessfondoreservamensualsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesoiessfondoreservamensualDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesoiessfondoreservamensualDataAccess.setConnexionType(this.connexionType);
			this.procesoiessfondoreservamensualDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoiessfondoreservamensualDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoIessFondoReservaMensual getProcesoIessFondoReservaMensual() throws Exception {	
		ProcesoIessFondoReservaMensualLogicAdditional.checkProcesoIessFondoReservaMensualToGet(procesoiessfondoreservamensual,this.datosCliente,this.arrDatoGeneral);
		ProcesoIessFondoReservaMensualLogicAdditional.updateProcesoIessFondoReservaMensualToGet(procesoiessfondoreservamensual,this.arrDatoGeneral);
		
		return procesoiessfondoreservamensual;
	}
		
	public void setProcesoIessFondoReservaMensual(ProcesoIessFondoReservaMensual newProcesoIessFondoReservaMensual) {
		this.procesoiessfondoreservamensual = newProcesoIessFondoReservaMensual;
	}
	
	public List<ProcesoIessFondoReservaMensual> getProcesoIessFondoReservaMensuals() throws Exception {		
		this.quitarProcesoIessFondoReservaMensualsNulos();
		
		ProcesoIessFondoReservaMensualLogicAdditional.checkProcesoIessFondoReservaMensualToGets(procesoiessfondoreservamensuals,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoIessFondoReservaMensual procesoiessfondoreservamensualLocal: procesoiessfondoreservamensuals ) {
			ProcesoIessFondoReservaMensualLogicAdditional.updateProcesoIessFondoReservaMensualToGet(procesoiessfondoreservamensualLocal,this.arrDatoGeneral);
		}
		
		return procesoiessfondoreservamensuals;
	}
	
	public void setProcesoIessFondoReservaMensuals(List<ProcesoIessFondoReservaMensual> newProcesoIessFondoReservaMensuals) {
		this.procesoiessfondoreservamensuals = newProcesoIessFondoReservaMensuals;
	}
	
	public Object getProcesoIessFondoReservaMensualObject() {	
		//this.procesoiessfondoreservamensualObject=this.procesoiessfondoreservamensualDataAccess.getEntityObject();
		return this.procesoiessfondoreservamensualObject;
	}
		
	public void setProcesoIessFondoReservaMensualObject(Object newProcesoIessFondoReservaMensualObject) {
		this.procesoiessfondoreservamensualObject = newProcesoIessFondoReservaMensualObject;
	}
	
	public List<Object> getProcesoIessFondoReservaMensualsObject() {		
		//this.procesoiessfondoreservamensualsObject=this.procesoiessfondoreservamensualDataAccess.getEntitiesObject();
		return this.procesoiessfondoreservamensualsObject;
	}
		
	public void setProcesoIessFondoReservaMensualsObject(List<Object> newProcesoIessFondoReservaMensualsObject) {
		this.procesoiessfondoreservamensualsObject = newProcesoIessFondoReservaMensualsObject;
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
		procesoiessfondoreservamensuals = new  ArrayList<ProcesoIessFondoReservaMensual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessFondoReservaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservamensuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesoiessfondoreservamensuals = new  ArrayList<ProcesoIessFondoReservaMensual>();
		  		  
        try {
			//ProcesoIessFondoReservaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservamensuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesoiessfondoreservamensuals = new  ArrayList<ProcesoIessFondoReservaMensual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessFondoReservaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservamensuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoiessfondoreservamensuals = new  ArrayList<ProcesoIessFondoReservaMensual>();
		  		  
        try {
			//ProcesoIessFondoReservaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservamensuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesoiessfondoreservamensuals = new  ArrayList<ProcesoIessFondoReservaMensual>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessFondoReservaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservamensuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoiessfondoreservamensuals = new  ArrayList<ProcesoIessFondoReservaMensual>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoIessFondoReservaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservamensuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoIessFondoReservaMensual> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessFondoReservaMensual> entities = new  ArrayList<ProcesoIessFondoReservaMensual>();
		ProcesoIessFondoReservaMensual entity = new ProcesoIessFondoReservaMensual();		  
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
	
	public  List<ProcesoIessFondoReservaMensual> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessFondoReservaMensual> entities = new  ArrayList<ProcesoIessFondoReservaMensual>();
		ProcesoIessFondoReservaMensual entity = new ProcesoIessFondoReservaMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoIessFondoReservaMensual();
				
				
      	    	entity=ProcesoIessFondoReservaMensualLogic.getEntityProcesoIessFondoReservaMensual("",entity,resultSet);
      	    	
				//entity.setProcesoIessFondoReservaMensualOriginal( new ProcesoIessFondoReservaMensual());
      	    	//entity.setProcesoIessFondoReservaMensualOriginal(super.getEntity("",entity.getProcesoIessFondoReservaMensualOriginal(),resultSet,ProcesoIessFondoReservaMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoIessFondoReservaMensualOriginal(ProcesoIessFondoReservaMensualDataAccess.getEntityProcesoIessFondoReservaMensual("",entity.getProcesoIessFondoReservaMensualOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoIessFondoReservaMensual> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessFondoReservaMensual> entities = new  ArrayList<ProcesoIessFondoReservaMensual>();
		ProcesoIessFondoReservaMensual entity = new ProcesoIessFondoReservaMensual();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoIessFondoReservaMensual.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoIessFondoReservaMensual>((List<ProcesoIessFondoReservaMensual>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoIessFondoReservaMensualsOriginal(entities);
			
			}  else {
				this.procesoiessfondoreservamensualsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoIessFondoReservaMensualConstantesFunciones.quitarEspaciosProcesoIessFondoReservaMensuals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoIessFondoReservaMensual getEntityProcesoIessFondoReservaMensual(String strPrefijo,ProcesoIessFondoReservaMensual entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_anio(resultSet.getLong(strPrefijo+ProcesoIessFondoReservaMensualConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
			entity.setid_mes(resultSet.getLong(strPrefijo+ProcesoIessFondoReservaMensualConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			entity.setid_numero_patronal(resultSet.getLong(strPrefijo+ProcesoIessFondoReservaMensualConstantesFunciones.IDNUMEROPATRONAL));
			entity.setid_tipo_proceso_nomina(resultSet.getLong(strPrefijo+ProcesoIessFondoReservaMensualConstantesFunciones.IDTIPOPROCESONOMINA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoIessFondoReservaMensual getEntityProcesoIessFondoReservaMensual(String strPrefijo,ProcesoIessFondoReservaMensual entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoIessFondoReservaMensual.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoIessFondoReservaMensual.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoIessFondoReservaMensualLogic.setFieldReflectionProcesoIessFondoReservaMensual(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoIessFondoReservaMensual(Field field,String strPrefijo,String sColumn,ProcesoIessFondoReservaMensual entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoIessFondoReservaMensualConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoIessFondoReservaMensualConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoIessFondoReservaMensualConstantesFunciones.IDNUMEROPATRONAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoIessFondoReservaMensualConstantesFunciones.IDTIPOPROCESONOMINA:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	public void quitarProcesoIessFondoReservaMensualsNulos() throws Exception {				
		
		List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensualsAux= new ArrayList<ProcesoIessFondoReservaMensual>();
		
		for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual:procesoiessfondoreservamensuals) {
			if(procesoiessfondoreservamensual!=null) {
				procesoiessfondoreservamensualsAux.add(procesoiessfondoreservamensual);
			}
		}
		
		procesoiessfondoreservamensuals=procesoiessfondoreservamensualsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoIessFondoReservaMensual> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessFondoReservaMensual> entities = new  ArrayList<ProcesoIessFondoReservaMensual>();
		ProcesoIessFondoReservaMensual entity = new ProcesoIessFondoReservaMensual();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoIessFondoReservaMensual>((List<ProcesoIessFondoReservaMensual>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoIessFondoReservaMensualsOriginal(entities);
			
			}  else {
				this.procesoiessfondoreservamensualsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoIessFondoReservaMensualConstantesFunciones.quitarEspaciosProcesoIessFondoReservaMensuals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesoiessfondoreservamensuals = new  ArrayList<ProcesoIessFondoReservaMensual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessFondoReservaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservamensuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesoiessfondoreservamensuals = new  ArrayList<ProcesoIessFondoReservaMensual>();
		  		  
        try {
			//ProcesoIessFondoReservaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservamensuals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoIessFondoReservaMensual> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoIessFondoReservaMensual> entities = new  ArrayList<ProcesoIessFondoReservaMensual>();
		ProcesoIessFondoReservaMensual entity = new ProcesoIessFondoReservaMensual();		  
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
	
	public  List<ProcesoIessFondoReservaMensual> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoIessFondoReservaMensual> entities = new  ArrayList<ProcesoIessFondoReservaMensual>();
		ProcesoIessFondoReservaMensual entity = new ProcesoIessFondoReservaMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoIessFondoReservaMensual();
				
				if(conMapGenerico) {
					entity.setMapProcesoIessFondoReservaMensual( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoIessFondoReservaMensual().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoIessFondoReservaMensualDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoIessFondoReservaMensualLogic.getEntityProcesoIessFondoReservaMensual("",entity,resultSet,listColumns);
					
					////entity.setProcesoIessFondoReservaMensualOriginal( new ProcesoIessFondoReservaMensual());
					////entity.setProcesoIessFondoReservaMensualOriginal(super.getEntity("",entity.getProcesoIessFondoReservaMensualOriginal(),resultSet,ProcesoIessFondoReservaMensualDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoIessFondoReservaMensualOriginal(ProcesoIessFondoReservaMensualDataAccess.getEntityProcesoIessFondoReservaMensual("",entity.getProcesoIessFondoReservaMensualOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Anio getAnio(Connexion connexion,ProcesoIessFondoReservaMensual relprocesoiessfondoreservamensual)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,relprocesoiessfondoreservamensual.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,ProcesoIessFondoReservaMensual relprocesoiessfondoreservamensual)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);
			mesDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			mes=mesDataAccess.getEntity(connexion,relprocesoiessfondoreservamensual.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public NumeroPatronal getNumeroPatronal(Connexion connexion,ProcesoIessFondoReservaMensual relprocesoiessfondoreservamensual)throws SQLException,Exception {

		NumeroPatronal numeropatronal= new NumeroPatronal();

		try {
			NumeroPatronalDataAccess numeropatronalDataAccess=new NumeroPatronalDataAccess();

			numeropatronalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			numeropatronalDataAccess.setConnexionType(this.connexionType);
			numeropatronalDataAccess.setParameterDbType(this.parameterDbType);
			numeropatronalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			numeropatronal=numeropatronalDataAccess.getEntity(connexion,relprocesoiessfondoreservamensual.getid_numero_patronal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return numeropatronal;

	}

	public TipoProcesoNomina getTipoProcesoNomina(Connexion connexion,ProcesoIessFondoReservaMensual relprocesoiessfondoreservamensual)throws SQLException,Exception {

		TipoProcesoNomina tipoprocesonomina= new TipoProcesoNomina();

		try {
			TipoProcesoNominaDataAccess tipoprocesonominaDataAccess=new TipoProcesoNominaDataAccess();

			tipoprocesonominaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprocesonominaDataAccess.setConnexionType(this.connexionType);
			tipoprocesonominaDataAccess.setParameterDbType(this.parameterDbType);
			tipoprocesonominaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoprocesonomina=tipoprocesonominaDataAccess.getEntity(connexion,relprocesoiessfondoreservamensual.getid_tipo_proceso_nomina());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprocesonomina;

	}


	
	
	public void getProcesoIessFondoReservaMensualsBusquedaProcesoIessFondoReservaMensualWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_numero_patronal,Long id_tipo_proceso_nomina)throws Exception {
		try {
			ProcesoIessFondoReservaMensualLogicAdditional procesoiessfondoreservamensualLogicAdditional=new ProcesoIessFondoReservaMensualLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoiessfondoreservamensualLogicAdditional.BusquedaProcesoIessFondoReservaMensual(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_mes,id_numero_patronal,id_tipo_proceso_nomina);

			//this.procesoiessfondoreservamensuals=this.getProcesoIessFondoReservaMensuals();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoIessFondoReservaMensualLogicAdditional.ProcesarInformacionProcesoIessFondoReservaMensual(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoiessfondoreservamensualLogicAdditional,this.procesoiessfondoreservamensuals,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoIessFondoReservaMensual",id_anio,id_mes,id_numero_patronal,id_tipo_proceso_nomina);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoIessFondoReservaMensualsBusquedaProcesoIessFondoReservaMensual(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_numero_patronal,Long id_tipo_proceso_nomina)throws Exception {
		try {
			ProcesoIessFondoReservaMensualLogicAdditional procesoiessfondoreservamensualLogicAdditional=new ProcesoIessFondoReservaMensualLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoiessfondoreservamensualLogicAdditional.BusquedaProcesoIessFondoReservaMensual(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_mes,id_numero_patronal,id_tipo_proceso_nomina);

			//this.procesoiessfondoreservamensuals=this.getProcesoIessFondoReservaMensuals();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoIessFondoReservaMensualLogicAdditional.ProcesarInformacionProcesoIessFondoReservaMensual(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoiessfondoreservamensualLogicAdditional,this.procesoiessfondoreservamensuals,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoIessFondoReservaMensual",id_anio,id_mes,id_numero_patronal,id_tipo_proceso_nomina);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoIessFondoReservaMensualLogicAdditional.updateProcesoIessFondoReservaMensualToGet(procesoiessfondoreservamensual,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoiessfondoreservamensual.setAnio(procesoiessfondoreservamensualDataAccess.getAnio(connexion,procesoiessfondoreservamensual));
		procesoiessfondoreservamensual.setMes(procesoiessfondoreservamensualDataAccess.getMes(connexion,procesoiessfondoreservamensual));
		procesoiessfondoreservamensual.setNumeroPatronal(procesoiessfondoreservamensualDataAccess.getNumeroPatronal(connexion,procesoiessfondoreservamensual));
		procesoiessfondoreservamensual.setTipoProcesoNomina(procesoiessfondoreservamensualDataAccess.getTipoProcesoNomina(connexion,procesoiessfondoreservamensual));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoiessfondoreservamensual.setAnio(procesoiessfondoreservamensualDataAccess.getAnio(connexion,procesoiessfondoreservamensual));
			}

			if(clas.clas.equals(Mes.class)) {
				procesoiessfondoreservamensual.setMes(procesoiessfondoreservamensualDataAccess.getMes(connexion,procesoiessfondoreservamensual));
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				procesoiessfondoreservamensual.setNumeroPatronal(procesoiessfondoreservamensualDataAccess.getNumeroPatronal(connexion,procesoiessfondoreservamensual));
			}

			if(clas.clas.equals(TipoProcesoNomina.class)) {
				procesoiessfondoreservamensual.setTipoProcesoNomina(procesoiessfondoreservamensualDataAccess.getTipoProcesoNomina(connexion,procesoiessfondoreservamensual));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreservamensual.setAnio(procesoiessfondoreservamensualDataAccess.getAnio(connexion,procesoiessfondoreservamensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreservamensual.setMes(procesoiessfondoreservamensualDataAccess.getMes(connexion,procesoiessfondoreservamensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreservamensual.setNumeroPatronal(procesoiessfondoreservamensualDataAccess.getNumeroPatronal(connexion,procesoiessfondoreservamensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoNomina.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreservamensual.setTipoProcesoNomina(procesoiessfondoreservamensualDataAccess.getTipoProcesoNomina(connexion,procesoiessfondoreservamensual));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoiessfondoreservamensual.setAnio(procesoiessfondoreservamensualDataAccess.getAnio(connexion,procesoiessfondoreservamensual));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(procesoiessfondoreservamensual.getAnio(),isDeep,deepLoadType,clases);
				
		procesoiessfondoreservamensual.setMes(procesoiessfondoreservamensualDataAccess.getMes(connexion,procesoiessfondoreservamensual));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(procesoiessfondoreservamensual.getMes(),isDeep,deepLoadType,clases);
				
		procesoiessfondoreservamensual.setNumeroPatronal(procesoiessfondoreservamensualDataAccess.getNumeroPatronal(connexion,procesoiessfondoreservamensual));
		NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
		numeropatronalLogic.deepLoad(procesoiessfondoreservamensual.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
		procesoiessfondoreservamensual.setTipoProcesoNomina(procesoiessfondoreservamensualDataAccess.getTipoProcesoNomina(connexion,procesoiessfondoreservamensual));
		TipoProcesoNominaLogic tipoprocesonominaLogic= new TipoProcesoNominaLogic(connexion);
		tipoprocesonominaLogic.deepLoad(procesoiessfondoreservamensual.getTipoProcesoNomina(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoiessfondoreservamensual.setAnio(procesoiessfondoreservamensualDataAccess.getAnio(connexion,procesoiessfondoreservamensual));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(procesoiessfondoreservamensual.getAnio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Mes.class)) {
				procesoiessfondoreservamensual.setMes(procesoiessfondoreservamensualDataAccess.getMes(connexion,procesoiessfondoreservamensual));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(procesoiessfondoreservamensual.getMes(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				procesoiessfondoreservamensual.setNumeroPatronal(procesoiessfondoreservamensualDataAccess.getNumeroPatronal(connexion,procesoiessfondoreservamensual));
				NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
				numeropatronalLogic.deepLoad(procesoiessfondoreservamensual.getNumeroPatronal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoProcesoNomina.class)) {
				procesoiessfondoreservamensual.setTipoProcesoNomina(procesoiessfondoreservamensualDataAccess.getTipoProcesoNomina(connexion,procesoiessfondoreservamensual));
				TipoProcesoNominaLogic tipoprocesonominaLogic= new TipoProcesoNominaLogic(connexion);
				tipoprocesonominaLogic.deepLoad(procesoiessfondoreservamensual.getTipoProcesoNomina(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreservamensual.setAnio(procesoiessfondoreservamensualDataAccess.getAnio(connexion,procesoiessfondoreservamensual));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(procesoiessfondoreservamensual.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreservamensual.setMes(procesoiessfondoreservamensualDataAccess.getMes(connexion,procesoiessfondoreservamensual));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(procesoiessfondoreservamensual.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreservamensual.setNumeroPatronal(procesoiessfondoreservamensualDataAccess.getNumeroPatronal(connexion,procesoiessfondoreservamensual));
			NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
			numeropatronalLogic.deepLoad(procesoiessfondoreservamensual.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoNomina.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreservamensual.setTipoProcesoNomina(procesoiessfondoreservamensualDataAccess.getTipoProcesoNomina(connexion,procesoiessfondoreservamensual));
			TipoProcesoNominaLogic tipoprocesonominaLogic= new TipoProcesoNominaLogic(connexion);
			tipoprocesonominaLogic.deepLoad(procesoiessfondoreservamensual.getTipoProcesoNomina(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesoiessfondoreservamensual,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoIessFondoReservaMensualConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessFondoReservaMensual(procesoiessfondoreservamensual);
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
			this.deepLoad(this.procesoiessfondoreservamensual,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoIessFondoReservaMensualConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessFondoReservaMensual(this.procesoiessfondoreservamensual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesoiessfondoreservamensuals!=null) {
				for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual:procesoiessfondoreservamensuals) {
					this.deepLoad(procesoiessfondoreservamensual,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoIessFondoReservaMensualConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessFondoReservaMensual(procesoiessfondoreservamensuals);
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
			if(procesoiessfondoreservamensuals!=null) {
				for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual:procesoiessfondoreservamensuals) {
					this.deepLoad(procesoiessfondoreservamensual,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoIessFondoReservaMensualConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessFondoReservaMensual(procesoiessfondoreservamensuals);
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
	
	public ProcesoIessFondoReservaMensualParameterReturnGeneral procesarAccionProcesoIessFondoReservaMensuals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals,ProcesoIessFondoReservaMensualParameterReturnGeneral procesoiessfondoreservamensualParameterGeneral)throws Exception {
		 try {	
			ProcesoIessFondoReservaMensualParameterReturnGeneral procesoiessfondoreservamensualReturnGeneral=new ProcesoIessFondoReservaMensualParameterReturnGeneral();
	
			ProcesoIessFondoReservaMensualLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoiessfondoreservamensuals,procesoiessfondoreservamensualParameterGeneral,procesoiessfondoreservamensualReturnGeneral);
			
			return procesoiessfondoreservamensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoIessFondoReservaMensualParameterReturnGeneral procesarAccionProcesoIessFondoReservaMensualsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals,ProcesoIessFondoReservaMensualParameterReturnGeneral procesoiessfondoreservamensualParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoIessFondoReservaMensualParameterReturnGeneral procesoiessfondoreservamensualReturnGeneral=new ProcesoIessFondoReservaMensualParameterReturnGeneral();
	
			ProcesoIessFondoReservaMensualLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoiessfondoreservamensuals,procesoiessfondoreservamensualParameterGeneral,procesoiessfondoreservamensualReturnGeneral);
			
			this.connexion.commit();
			
			return procesoiessfondoreservamensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoIessFondoReservaMensual(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals,String sTipoBusqueda,Long id_anioBusquedaProcesoIessFondoReservaMensual,Long id_mesBusquedaProcesoIessFondoReservaMensual,Long id_numero_patronalBusquedaProcesoIessFondoReservaMensual,Long id_tipo_proceso_nominaBusquedaProcesoIessFondoReservaMensual) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoIessFondoReservaMensualLogicAdditional procesoiessfondoreservamensualLogicAdditional=new ProcesoIessFondoReservaMensualLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesoiessfondoreservamensualLogicAdditional.setConnexion(this.connexion);

			procesoiessfondoreservamensualLogicAdditional.ProcesarInformacionProcesoIessFondoReservaMensual(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoiessfondoreservamensuals,sTipoBusqueda,id_anioBusquedaProcesoIessFondoReservaMensual,id_mesBusquedaProcesoIessFondoReservaMensual,id_numero_patronalBusquedaProcesoIessFondoReservaMensual,id_tipo_proceso_nominaBusquedaProcesoIessFondoReservaMensual);

			//this.connexion.commit();
		} catch(Exception e) {
			//this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			//this.connexion.close();
		}

		return procesado;
	}

	
}

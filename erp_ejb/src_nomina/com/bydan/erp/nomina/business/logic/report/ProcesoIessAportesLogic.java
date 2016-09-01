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
import com.bydan.erp.nomina.util.report.ProcesoIessAportesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoIessAportesParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoIessAportesConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoIessAportes;

import com.bydan.erp.nomina.business.logic.report.ProcesoIessAportesLogicAdditional;
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
public class ProcesoIessAportesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoIessAportesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoIessAportesLogic procesoiessaportesDataAccess; 		
	protected ProcesoIessAportes procesoiessaportes;
	protected List<ProcesoIessAportes> procesoiessaportess;
	protected Object procesoiessaportesObject;	
	protected List<Object> procesoiessaportessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoIessAportesLogic()throws SQLException,Exception {
		try	{
			this.procesoiessaportess= new ArrayList<ProcesoIessAportes>();
			this.procesoiessaportes= new ProcesoIessAportes();
			this.procesoiessaportesObject=new Object();
			this.procesoiessaportessObject=new ArrayList<Object>();
			
			this.procesoiessaportesDataAccess=this;
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
			this.procesoiessaportesDataAccess.setConnexionType(this.connexionType);
			this.procesoiessaportesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoiessaportesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoIessAportesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesoiessaportess= new ArrayList<ProcesoIessAportes>();
			this.procesoiessaportes= new ProcesoIessAportes();
			this.procesoiessaportesObject=new Object();
			this.procesoiessaportessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesoiessaportesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesoiessaportesDataAccess.setConnexionType(this.connexionType);
			this.procesoiessaportesDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoiessaportesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoIessAportes getProcesoIessAportes() throws Exception {	
		ProcesoIessAportesLogicAdditional.checkProcesoIessAportesToGet(procesoiessaportes,this.datosCliente,this.arrDatoGeneral);
		ProcesoIessAportesLogicAdditional.updateProcesoIessAportesToGet(procesoiessaportes,this.arrDatoGeneral);
		
		return procesoiessaportes;
	}
		
	public void setProcesoIessAportes(ProcesoIessAportes newProcesoIessAportes) {
		this.procesoiessaportes = newProcesoIessAportes;
	}
	
	public List<ProcesoIessAportes> getProcesoIessAportess() throws Exception {		
		this.quitarProcesoIessAportessNulos();
		
		ProcesoIessAportesLogicAdditional.checkProcesoIessAportesToGets(procesoiessaportess,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoIessAportes procesoiessaportesLocal: procesoiessaportess ) {
			ProcesoIessAportesLogicAdditional.updateProcesoIessAportesToGet(procesoiessaportesLocal,this.arrDatoGeneral);
		}
		
		return procesoiessaportess;
	}
	
	public void setProcesoIessAportess(List<ProcesoIessAportes> newProcesoIessAportess) {
		this.procesoiessaportess = newProcesoIessAportess;
	}
	
	public Object getProcesoIessAportesObject() {	
		//this.procesoiessaportesObject=this.procesoiessaportesDataAccess.getEntityObject();
		return this.procesoiessaportesObject;
	}
		
	public void setProcesoIessAportesObject(Object newProcesoIessAportesObject) {
		this.procesoiessaportesObject = newProcesoIessAportesObject;
	}
	
	public List<Object> getProcesoIessAportessObject() {		
		//this.procesoiessaportessObject=this.procesoiessaportesDataAccess.getEntitiesObject();
		return this.procesoiessaportessObject;
	}
		
	public void setProcesoIessAportessObject(List<Object> newProcesoIessAportessObject) {
		this.procesoiessaportessObject = newProcesoIessAportessObject;
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
		procesoiessaportess = new  ArrayList<ProcesoIessAportes>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessAportesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessaportess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesoiessaportess = new  ArrayList<ProcesoIessAportes>();
		  		  
        try {
			//ProcesoIessAportesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessaportess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesoiessaportess = new  ArrayList<ProcesoIessAportes>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessAportesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessaportess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoiessaportess = new  ArrayList<ProcesoIessAportes>();
		  		  
        try {
			//ProcesoIessAportesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessaportess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesoiessaportess = new  ArrayList<ProcesoIessAportes>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessAportesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessaportess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoiessaportess = new  ArrayList<ProcesoIessAportes>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoIessAportesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessaportess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoIessAportes> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessAportes> entities = new  ArrayList<ProcesoIessAportes>();
		ProcesoIessAportes entity = new ProcesoIessAportes();		  
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
	
	public  List<ProcesoIessAportes> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessAportes> entities = new  ArrayList<ProcesoIessAportes>();
		ProcesoIessAportes entity = new ProcesoIessAportes();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoIessAportes();
				
				
      	    	entity=ProcesoIessAportesLogic.getEntityProcesoIessAportes("",entity,resultSet);
      	    	
				//entity.setProcesoIessAportesOriginal( new ProcesoIessAportes());
      	    	//entity.setProcesoIessAportesOriginal(super.getEntity("",entity.getProcesoIessAportesOriginal(),resultSet,ProcesoIessAportesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoIessAportesOriginal(ProcesoIessAportesDataAccess.getEntityProcesoIessAportes("",entity.getProcesoIessAportesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoIessAportes> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessAportes> entities = new  ArrayList<ProcesoIessAportes>();
		ProcesoIessAportes entity = new ProcesoIessAportes();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoIessAportes.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoIessAportes>((List<ProcesoIessAportes>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoIessAportessOriginal(entities);
			
			}  else {
				this.procesoiessaportessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoIessAportesConstantesFunciones.quitarEspaciosProcesoIessAportess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoIessAportes getEntityProcesoIessAportes(String strPrefijo,ProcesoIessAportes entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_anio(resultSet.getLong(strPrefijo+ProcesoIessAportesConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
			entity.setid_mes(resultSet.getLong(strPrefijo+ProcesoIessAportesConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			entity.setid_tipo_afiliacion(resultSet.getLong(strPrefijo+ProcesoIessAportesConstantesFunciones.IDTIPOAFILIACION));
			entity.setid_numero_patronal(resultSet.getLong(strPrefijo+ProcesoIessAportesConstantesFunciones.IDNUMEROPATRONAL));
			entity.setporcentaje(resultSet.getDouble(strPrefijo+ProcesoIessAportesConstantesFunciones.PORCENTAJE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoIessAportes getEntityProcesoIessAportes(String strPrefijo,ProcesoIessAportes entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoIessAportes.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoIessAportes.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoIessAportesLogic.setFieldReflectionProcesoIessAportes(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoIessAportes(Field field,String strPrefijo,String sColumn,ProcesoIessAportes entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoIessAportesConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoIessAportesConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoIessAportesConstantesFunciones.IDTIPOAFILIACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoIessAportesConstantesFunciones.IDNUMEROPATRONAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoIessAportesConstantesFunciones.PORCENTAJE:
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
	
	public void quitarProcesoIessAportessNulos() throws Exception {				
		
		List<ProcesoIessAportes> procesoiessaportessAux= new ArrayList<ProcesoIessAportes>();
		
		for(ProcesoIessAportes procesoiessaportes:procesoiessaportess) {
			if(procesoiessaportes!=null) {
				procesoiessaportessAux.add(procesoiessaportes);
			}
		}
		
		procesoiessaportess=procesoiessaportessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoIessAportes> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessAportes> entities = new  ArrayList<ProcesoIessAportes>();
		ProcesoIessAportes entity = new ProcesoIessAportes();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoIessAportes>((List<ProcesoIessAportes>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoIessAportessOriginal(entities);
			
			}  else {
				this.procesoiessaportessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoIessAportesConstantesFunciones.quitarEspaciosProcesoIessAportess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesoiessaportess = new  ArrayList<ProcesoIessAportes>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessAportesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessaportess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesoiessaportess = new  ArrayList<ProcesoIessAportes>();
		  		  
        try {
			//ProcesoIessAportesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessaportess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoIessAportes> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoIessAportes> entities = new  ArrayList<ProcesoIessAportes>();
		ProcesoIessAportes entity = new ProcesoIessAportes();		  
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
	
	public  List<ProcesoIessAportes> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoIessAportes> entities = new  ArrayList<ProcesoIessAportes>();
		ProcesoIessAportes entity = new ProcesoIessAportes();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoIessAportes();
				
				if(conMapGenerico) {
					entity.setMapProcesoIessAportes( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoIessAportes().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoIessAportesDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoIessAportesLogic.getEntityProcesoIessAportes("",entity,resultSet,listColumns);
					
					////entity.setProcesoIessAportesOriginal( new ProcesoIessAportes());
					////entity.setProcesoIessAportesOriginal(super.getEntity("",entity.getProcesoIessAportesOriginal(),resultSet,ProcesoIessAportesDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoIessAportesOriginal(ProcesoIessAportesDataAccess.getEntityProcesoIessAportes("",entity.getProcesoIessAportesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Anio getAnio(Connexion connexion,ProcesoIessAportes relprocesoiessaportes)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,relprocesoiessaportes.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,ProcesoIessAportes relprocesoiessaportes)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);
			mesDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			mes=mesDataAccess.getEntity(connexion,relprocesoiessaportes.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public TipoAfiliacion getTipoAfiliacion(Connexion connexion,ProcesoIessAportes relprocesoiessaportes)throws SQLException,Exception {

		TipoAfiliacion tipoafiliacion= new TipoAfiliacion();

		try {
			TipoAfiliacionDataAccess tipoafiliacionDataAccess=new TipoAfiliacionDataAccess();

			tipoafiliacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoafiliacionDataAccess.setConnexionType(this.connexionType);
			tipoafiliacionDataAccess.setParameterDbType(this.parameterDbType);
			tipoafiliacionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoafiliacion=tipoafiliacionDataAccess.getEntity(connexion,relprocesoiessaportes.getid_tipo_afiliacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoafiliacion;

	}

	public NumeroPatronal getNumeroPatronal(Connexion connexion,ProcesoIessAportes relprocesoiessaportes)throws SQLException,Exception {

		NumeroPatronal numeropatronal= new NumeroPatronal();

		try {
			NumeroPatronalDataAccess numeropatronalDataAccess=new NumeroPatronalDataAccess();

			numeropatronalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			numeropatronalDataAccess.setConnexionType(this.connexionType);
			numeropatronalDataAccess.setParameterDbType(this.parameterDbType);
			numeropatronalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			numeropatronal=numeropatronalDataAccess.getEntity(connexion,relprocesoiessaportes.getid_numero_patronal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return numeropatronal;

	}


	
	
	public void getProcesoIessAportessBusquedaProcesoIessAportesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_tipo_afiliacion,Long id_numero_patronal,Double porcentaje)throws Exception {
		try {
			ProcesoIessAportesLogicAdditional procesoiessaportesLogicAdditional=new ProcesoIessAportesLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoiessaportesLogicAdditional.BusquedaProcesoIessAportes(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_mes,id_tipo_afiliacion,id_numero_patronal,porcentaje);

			//this.procesoiessaportess=this.getProcesoIessAportess();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoIessAportesLogicAdditional.ProcesarInformacionProcesoIessAportes(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoiessaportesLogicAdditional,this.procesoiessaportess,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoIessAportes",id_anio,id_mes,id_tipo_afiliacion,id_numero_patronal,porcentaje);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoIessAportessBusquedaProcesoIessAportes(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_tipo_afiliacion,Long id_numero_patronal,Double porcentaje)throws Exception {
		try {
			ProcesoIessAportesLogicAdditional procesoiessaportesLogicAdditional=new ProcesoIessAportesLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoiessaportesLogicAdditional.BusquedaProcesoIessAportes(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_mes,id_tipo_afiliacion,id_numero_patronal,porcentaje);

			//this.procesoiessaportess=this.getProcesoIessAportess();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoIessAportesLogicAdditional.ProcesarInformacionProcesoIessAportes(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoiessaportesLogicAdditional,this.procesoiessaportess,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoIessAportes",id_anio,id_mes,id_tipo_afiliacion,id_numero_patronal,porcentaje);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoIessAportes procesoiessaportes,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoIessAportesLogicAdditional.updateProcesoIessAportesToGet(procesoiessaportes,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoiessaportes.setAnio(procesoiessaportesDataAccess.getAnio(connexion,procesoiessaportes));
		procesoiessaportes.setMes(procesoiessaportesDataAccess.getMes(connexion,procesoiessaportes));
		procesoiessaportes.setTipoAfiliacion(procesoiessaportesDataAccess.getTipoAfiliacion(connexion,procesoiessaportes));
		procesoiessaportes.setNumeroPatronal(procesoiessaportesDataAccess.getNumeroPatronal(connexion,procesoiessaportes));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoiessaportes.setAnio(procesoiessaportesDataAccess.getAnio(connexion,procesoiessaportes));
			}

			if(clas.clas.equals(Mes.class)) {
				procesoiessaportes.setMes(procesoiessaportesDataAccess.getMes(connexion,procesoiessaportes));
			}

			if(clas.clas.equals(TipoAfiliacion.class)) {
				procesoiessaportes.setTipoAfiliacion(procesoiessaportesDataAccess.getTipoAfiliacion(connexion,procesoiessaportes));
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				procesoiessaportes.setNumeroPatronal(procesoiessaportesDataAccess.getNumeroPatronal(connexion,procesoiessaportes));
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
			procesoiessaportes.setAnio(procesoiessaportesDataAccess.getAnio(connexion,procesoiessaportes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessaportes.setMes(procesoiessaportesDataAccess.getMes(connexion,procesoiessaportes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAfiliacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessaportes.setTipoAfiliacion(procesoiessaportesDataAccess.getTipoAfiliacion(connexion,procesoiessaportes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessaportes.setNumeroPatronal(procesoiessaportesDataAccess.getNumeroPatronal(connexion,procesoiessaportes));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoiessaportes.setAnio(procesoiessaportesDataAccess.getAnio(connexion,procesoiessaportes));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(procesoiessaportes.getAnio(),isDeep,deepLoadType,clases);
				
		procesoiessaportes.setMes(procesoiessaportesDataAccess.getMes(connexion,procesoiessaportes));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(procesoiessaportes.getMes(),isDeep,deepLoadType,clases);
				
		procesoiessaportes.setTipoAfiliacion(procesoiessaportesDataAccess.getTipoAfiliacion(connexion,procesoiessaportes));
		TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
		tipoafiliacionLogic.deepLoad(procesoiessaportes.getTipoAfiliacion(),isDeep,deepLoadType,clases);
				
		procesoiessaportes.setNumeroPatronal(procesoiessaportesDataAccess.getNumeroPatronal(connexion,procesoiessaportes));
		NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
		numeropatronalLogic.deepLoad(procesoiessaportes.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoiessaportes.setAnio(procesoiessaportesDataAccess.getAnio(connexion,procesoiessaportes));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(procesoiessaportes.getAnio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Mes.class)) {
				procesoiessaportes.setMes(procesoiessaportesDataAccess.getMes(connexion,procesoiessaportes));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(procesoiessaportes.getMes(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoAfiliacion.class)) {
				procesoiessaportes.setTipoAfiliacion(procesoiessaportesDataAccess.getTipoAfiliacion(connexion,procesoiessaportes));
				TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
				tipoafiliacionLogic.deepLoad(procesoiessaportes.getTipoAfiliacion(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				procesoiessaportes.setNumeroPatronal(procesoiessaportesDataAccess.getNumeroPatronal(connexion,procesoiessaportes));
				NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
				numeropatronalLogic.deepLoad(procesoiessaportes.getNumeroPatronal(),isDeep,deepLoadType,clases);				
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
			procesoiessaportes.setAnio(procesoiessaportesDataAccess.getAnio(connexion,procesoiessaportes));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(procesoiessaportes.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessaportes.setMes(procesoiessaportesDataAccess.getMes(connexion,procesoiessaportes));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(procesoiessaportes.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAfiliacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessaportes.setTipoAfiliacion(procesoiessaportesDataAccess.getTipoAfiliacion(connexion,procesoiessaportes));
			TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
			tipoafiliacionLogic.deepLoad(procesoiessaportes.getTipoAfiliacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessaportes.setNumeroPatronal(procesoiessaportesDataAccess.getNumeroPatronal(connexion,procesoiessaportes));
			NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
			numeropatronalLogic.deepLoad(procesoiessaportes.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesoiessaportes,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoIessAportesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessAportes(procesoiessaportes);
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
			this.deepLoad(this.procesoiessaportes,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoIessAportesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessAportes(this.procesoiessaportes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesoiessaportess!=null) {
				for(ProcesoIessAportes procesoiessaportes:procesoiessaportess) {
					this.deepLoad(procesoiessaportes,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoIessAportesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessAportes(procesoiessaportess);
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
			if(procesoiessaportess!=null) {
				for(ProcesoIessAportes procesoiessaportes:procesoiessaportess) {
					this.deepLoad(procesoiessaportes,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoIessAportesConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessAportes(procesoiessaportess);
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
	
	public ProcesoIessAportesParameterReturnGeneral procesarAccionProcesoIessAportess(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoIessAportes> procesoiessaportess,ProcesoIessAportesParameterReturnGeneral procesoiessaportesParameterGeneral)throws Exception {
		 try {	
			ProcesoIessAportesParameterReturnGeneral procesoiessaportesReturnGeneral=new ProcesoIessAportesParameterReturnGeneral();
	
			ProcesoIessAportesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoiessaportess,procesoiessaportesParameterGeneral,procesoiessaportesReturnGeneral);
			
			return procesoiessaportesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoIessAportesParameterReturnGeneral procesarAccionProcesoIessAportessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoIessAportes> procesoiessaportess,ProcesoIessAportesParameterReturnGeneral procesoiessaportesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoIessAportesParameterReturnGeneral procesoiessaportesReturnGeneral=new ProcesoIessAportesParameterReturnGeneral();
	
			ProcesoIessAportesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoiessaportess,procesoiessaportesParameterGeneral,procesoiessaportesReturnGeneral);
			
			this.connexion.commit();
			
			return procesoiessaportesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoIessAportes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoIessAportes> procesoiessaportess,String sTipoBusqueda,Long id_anioBusquedaProcesoIessAportes,Long id_mesBusquedaProcesoIessAportes,Long id_tipo_afiliacionBusquedaProcesoIessAportes,Long id_numero_patronalBusquedaProcesoIessAportes,Double porcentajeBusquedaProcesoIessAportes) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoIessAportesLogicAdditional procesoiessaportesLogicAdditional=new ProcesoIessAportesLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesoiessaportesLogicAdditional.setConnexion(this.connexion);

			procesoiessaportesLogicAdditional.ProcesarInformacionProcesoIessAportes(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoiessaportess,sTipoBusqueda,id_anioBusquedaProcesoIessAportes,id_mesBusquedaProcesoIessAportes,id_tipo_afiliacionBusquedaProcesoIessAportes,id_numero_patronalBusquedaProcesoIessAportes,porcentajeBusquedaProcesoIessAportes);

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

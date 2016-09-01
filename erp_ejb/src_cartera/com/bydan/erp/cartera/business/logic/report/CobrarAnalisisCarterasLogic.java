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
import com.bydan.erp.cartera.util.report.CobrarAnalisisCarterasParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarAnalisisCarterasParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarAnalisisCarterasConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarAnalisisCarteras;

import com.bydan.erp.cartera.business.logic.report.CobrarAnalisisCarterasLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;














@SuppressWarnings("unused")
public class CobrarAnalisisCarterasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarAnalisisCarterasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarAnalisisCarterasLogic cobraranalisiscarterasDataAccess; 		
	protected CobrarAnalisisCarteras cobraranalisiscarteras;
	protected List<CobrarAnalisisCarteras> cobraranalisiscarterass;
	protected Object cobraranalisiscarterasObject;	
	protected List<Object> cobraranalisiscarterassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarAnalisisCarterasLogic()throws SQLException,Exception {
		try	{
			this.cobraranalisiscarterass= new ArrayList<CobrarAnalisisCarteras>();
			this.cobraranalisiscarteras= new CobrarAnalisisCarteras();
			this.cobraranalisiscarterasObject=new Object();
			this.cobraranalisiscarterassObject=new ArrayList<Object>();
			
			this.cobraranalisiscarterasDataAccess=this;
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
			this.cobraranalisiscarterasDataAccess.setConnexionType(this.connexionType);
			this.cobraranalisiscarterasDataAccess.setParameterDbType(this.parameterDbType);
			this.cobraranalisiscarterasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarAnalisisCarterasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobraranalisiscarterass= new ArrayList<CobrarAnalisisCarteras>();
			this.cobraranalisiscarteras= new CobrarAnalisisCarteras();
			this.cobraranalisiscarterasObject=new Object();
			this.cobraranalisiscarterassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobraranalisiscarterasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobraranalisiscarterasDataAccess.setConnexionType(this.connexionType);
			this.cobraranalisiscarterasDataAccess.setParameterDbType(this.parameterDbType);
			this.cobraranalisiscarterasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarAnalisisCarteras getCobrarAnalisisCarteras() throws Exception {	
		CobrarAnalisisCarterasLogicAdditional.checkCobrarAnalisisCarterasToGet(cobraranalisiscarteras,this.datosCliente,this.arrDatoGeneral);
		CobrarAnalisisCarterasLogicAdditional.updateCobrarAnalisisCarterasToGet(cobraranalisiscarteras,this.arrDatoGeneral);
		
		return cobraranalisiscarteras;
	}
		
	public void setCobrarAnalisisCarteras(CobrarAnalisisCarteras newCobrarAnalisisCarteras) {
		this.cobraranalisiscarteras = newCobrarAnalisisCarteras;
	}
	
	public List<CobrarAnalisisCarteras> getCobrarAnalisisCarterass() throws Exception {		
		this.quitarCobrarAnalisisCarterassNulos();
		
		CobrarAnalisisCarterasLogicAdditional.checkCobrarAnalisisCarterasToGets(cobraranalisiscarterass,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarAnalisisCarteras cobraranalisiscarterasLocal: cobraranalisiscarterass ) {
			CobrarAnalisisCarterasLogicAdditional.updateCobrarAnalisisCarterasToGet(cobraranalisiscarterasLocal,this.arrDatoGeneral);
		}
		
		return cobraranalisiscarterass;
	}
	
	public void setCobrarAnalisisCarterass(List<CobrarAnalisisCarteras> newCobrarAnalisisCarterass) {
		this.cobraranalisiscarterass = newCobrarAnalisisCarterass;
	}
	
	public Object getCobrarAnalisisCarterasObject() {	
		//this.cobraranalisiscarterasObject=this.cobraranalisiscarterasDataAccess.getEntityObject();
		return this.cobraranalisiscarterasObject;
	}
		
	public void setCobrarAnalisisCarterasObject(Object newCobrarAnalisisCarterasObject) {
		this.cobraranalisiscarterasObject = newCobrarAnalisisCarterasObject;
	}
	
	public List<Object> getCobrarAnalisisCarterassObject() {		
		//this.cobraranalisiscarterassObject=this.cobraranalisiscarterasDataAccess.getEntitiesObject();
		return this.cobraranalisiscarterassObject;
	}
		
	public void setCobrarAnalisisCarterassObject(List<Object> newCobrarAnalisisCarterassObject) {
		this.cobraranalisiscarterassObject = newCobrarAnalisisCarterassObject;
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
		cobraranalisiscarterass = new  ArrayList<CobrarAnalisisCarteras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarAnalisisCarterasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobraranalisiscarterass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobraranalisiscarterass = new  ArrayList<CobrarAnalisisCarteras>();
		  		  
        try {
			//CobrarAnalisisCarterasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobraranalisiscarterass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobraranalisiscarterass = new  ArrayList<CobrarAnalisisCarteras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarAnalisisCarterasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobraranalisiscarterass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobraranalisiscarterass = new  ArrayList<CobrarAnalisisCarteras>();
		  		  
        try {
			//CobrarAnalisisCarterasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobraranalisiscarterass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobraranalisiscarterass = new  ArrayList<CobrarAnalisisCarteras>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarAnalisisCarterasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobraranalisiscarterass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobraranalisiscarterass = new  ArrayList<CobrarAnalisisCarteras>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarAnalisisCarterasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobraranalisiscarterass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarAnalisisCarteras> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarAnalisisCarteras> entities = new  ArrayList<CobrarAnalisisCarteras>();
		CobrarAnalisisCarteras entity = new CobrarAnalisisCarteras();		  
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
	
	public  List<CobrarAnalisisCarteras> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarAnalisisCarteras> entities = new  ArrayList<CobrarAnalisisCarteras>();
		CobrarAnalisisCarteras entity = new CobrarAnalisisCarteras();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarAnalisisCarteras();
				
				
      	    	entity=CobrarAnalisisCarterasLogic.getEntityCobrarAnalisisCarteras("",entity,resultSet);
      	    	
				//entity.setCobrarAnalisisCarterasOriginal( new CobrarAnalisisCarteras());
      	    	//entity.setCobrarAnalisisCarterasOriginal(super.getEntity("",entity.getCobrarAnalisisCarterasOriginal(),resultSet,CobrarAnalisisCarterasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarAnalisisCarterasOriginal(CobrarAnalisisCarterasDataAccess.getEntityCobrarAnalisisCarteras("",entity.getCobrarAnalisisCarterasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarAnalisisCarteras> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarAnalisisCarteras> entities = new  ArrayList<CobrarAnalisisCarteras>();
		CobrarAnalisisCarteras entity = new CobrarAnalisisCarteras();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarAnalisisCarteras.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarAnalisisCarteras>((List<CobrarAnalisisCarteras>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarAnalisisCarterassOriginal(entities);
			
			}  else {
				this.cobraranalisiscarterassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarAnalisisCarterasConstantesFunciones.quitarEspaciosCobrarAnalisisCarterass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarAnalisisCarteras getEntityCobrarAnalisisCarteras(String strPrefijo,CobrarAnalisisCarteras entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_tipo_radio_venci(resultSet.getString(strPrefijo+CobrarAnalisisCarterasConstantesFunciones.NOMBRETIPORADIOVENCI));
			entity.setdia_desde(resultSet.getInt(strPrefijo+CobrarAnalisisCarterasConstantesFunciones.DIADESDE));
			entity.setdia_hasta(resultSet.getInt(strPrefijo+CobrarAnalisisCarterasConstantesFunciones.DIAHASTA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarAnalisisCarteras getEntityCobrarAnalisisCarteras(String strPrefijo,CobrarAnalisisCarteras entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarAnalisisCarteras.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarAnalisisCarteras.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarAnalisisCarterasLogic.setFieldReflectionCobrarAnalisisCarteras(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarAnalisisCarteras(Field field,String strPrefijo,String sColumn,CobrarAnalisisCarteras entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarAnalisisCarterasConstantesFunciones.NOMBRETIPORADIOVENCI:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarAnalisisCarterasConstantesFunciones.DIADESDE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CobrarAnalisisCarterasConstantesFunciones.DIAHASTA:
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
	
	public void quitarCobrarAnalisisCarterassNulos() throws Exception {				
		
		List<CobrarAnalisisCarteras> cobraranalisiscarterassAux= new ArrayList<CobrarAnalisisCarteras>();
		
		for(CobrarAnalisisCarteras cobraranalisiscarteras:cobraranalisiscarterass) {
			if(cobraranalisiscarteras!=null) {
				cobraranalisiscarterassAux.add(cobraranalisiscarteras);
			}
		}
		
		cobraranalisiscarterass=cobraranalisiscarterassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarAnalisisCarteras> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarAnalisisCarteras> entities = new  ArrayList<CobrarAnalisisCarteras>();
		CobrarAnalisisCarteras entity = new CobrarAnalisisCarteras();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarAnalisisCarteras>((List<CobrarAnalisisCarteras>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarAnalisisCarterassOriginal(entities);
			
			}  else {
				this.cobraranalisiscarterassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarAnalisisCarterasConstantesFunciones.quitarEspaciosCobrarAnalisisCarterass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobraranalisiscarterass = new  ArrayList<CobrarAnalisisCarteras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarAnalisisCarterasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobraranalisiscarterass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobraranalisiscarterass = new  ArrayList<CobrarAnalisisCarteras>();
		  		  
        try {
			//CobrarAnalisisCarterasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobraranalisiscarterass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarAnalisisCarteras> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarAnalisisCarteras> entities = new  ArrayList<CobrarAnalisisCarteras>();
		CobrarAnalisisCarteras entity = new CobrarAnalisisCarteras();		  
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
	
	public  List<CobrarAnalisisCarteras> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarAnalisisCarteras> entities = new  ArrayList<CobrarAnalisisCarteras>();
		CobrarAnalisisCarteras entity = new CobrarAnalisisCarteras();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarAnalisisCarteras();
				
				if(conMapGenerico) {
					entity.setMapCobrarAnalisisCarteras( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarAnalisisCarteras().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarAnalisisCarterasDataAccess.ISWITHSCHEMA);         		
					entity=CobrarAnalisisCarterasLogic.getEntityCobrarAnalisisCarteras("",entity,resultSet,listColumns);
					
					////entity.setCobrarAnalisisCarterasOriginal( new CobrarAnalisisCarteras());
					////entity.setCobrarAnalisisCarterasOriginal(super.getEntity("",entity.getCobrarAnalisisCarterasOriginal(),resultSet,CobrarAnalisisCarterasDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarAnalisisCarterasOriginal(CobrarAnalisisCarterasDataAccess.getEntityCobrarAnalisisCarteras("",entity.getCobrarAnalisisCarterasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	public void getCobrarAnalisisCarterassBusquedaCobrarAnalisisCarterasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//CobrarAnalisisCarterasLogic cobraranalisiscarterasLogic=new CobrarAnalisisCarterasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarAnalisisCarterasLogic.GetSelecSqlCobrarAnalisisCarteras(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobraranalisiscarterass=this.getCobrarAnalisisCarterass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarAnalisisCarterassBusquedaCobrarAnalisisCarteras(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//CobrarAnalisisCarterasLogic cobraranalisiscarterasLogic=new CobrarAnalisisCarterasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarAnalisisCarterasLogic.GetSelecSqlCobrarAnalisisCarteras(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobraranalisiscarterass=this.getCobrarAnalisisCarterass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarAnalisisCarteras(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarAnalisisCarteras_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" r.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" r.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
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
	
	
	public void deepLoad(CobrarAnalisisCarteras cobraranalisiscarteras,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			CobrarAnalisisCarterasLogicAdditional.updateCobrarAnalisisCarterasToGet(cobraranalisiscarteras,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			this.deepLoad(cobraranalisiscarteras,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarAnalisisCarterasConstantesFunciones.refrescarForeignKeysDescripcionesCobrarAnalisisCarteras(cobraranalisiscarteras);
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
			this.deepLoad(this.cobraranalisiscarteras,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarAnalisisCarterasConstantesFunciones.refrescarForeignKeysDescripcionesCobrarAnalisisCarteras(this.cobraranalisiscarteras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobraranalisiscarterass!=null) {
				for(CobrarAnalisisCarteras cobraranalisiscarteras:cobraranalisiscarterass) {
					this.deepLoad(cobraranalisiscarteras,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarAnalisisCarterasConstantesFunciones.refrescarForeignKeysDescripcionesCobrarAnalisisCarteras(cobraranalisiscarterass);
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
			if(cobraranalisiscarterass!=null) {
				for(CobrarAnalisisCarteras cobraranalisiscarteras:cobraranalisiscarterass) {
					this.deepLoad(cobraranalisiscarteras,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarAnalisisCarterasConstantesFunciones.refrescarForeignKeysDescripcionesCobrarAnalisisCarteras(cobraranalisiscarterass);
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
	
	public CobrarAnalisisCarterasParameterReturnGeneral procesarAccionCobrarAnalisisCarterass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarAnalisisCarteras> cobraranalisiscarterass,CobrarAnalisisCarterasParameterReturnGeneral cobraranalisiscarterasParameterGeneral)throws Exception {
		 try {	
			CobrarAnalisisCarterasParameterReturnGeneral cobraranalisiscarterasReturnGeneral=new CobrarAnalisisCarterasParameterReturnGeneral();
	
			CobrarAnalisisCarterasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobraranalisiscarterass,cobraranalisiscarterasParameterGeneral,cobraranalisiscarterasReturnGeneral);
			
			return cobraranalisiscarterasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarAnalisisCarterasParameterReturnGeneral procesarAccionCobrarAnalisisCarterassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarAnalisisCarteras> cobraranalisiscarterass,CobrarAnalisisCarterasParameterReturnGeneral cobraranalisiscarterasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarAnalisisCarterasParameterReturnGeneral cobraranalisiscarterasReturnGeneral=new CobrarAnalisisCarterasParameterReturnGeneral();
	
			CobrarAnalisisCarterasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobraranalisiscarterass,cobraranalisiscarterasParameterGeneral,cobraranalisiscarterasReturnGeneral);
			
			this.connexion.commit();
			
			return cobraranalisiscarterasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

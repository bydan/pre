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
import com.bydan.erp.contabilidad.util.report.DiariosGeneralesParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.DiariosGeneralesParameterGeneral;
import com.bydan.erp.contabilidad.util.report.DiariosGeneralesConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.DiariosGenerales;

import com.bydan.erp.contabilidad.business.logic.report.DiariosGeneralesLogicAdditional;
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
public class DiariosGeneralesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(DiariosGeneralesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected DiariosGeneralesLogic diariosgeneralesDataAccess; 		
	protected DiariosGenerales diariosgenerales;
	protected List<DiariosGenerales> diariosgeneraless;
	protected Object diariosgeneralesObject;	
	protected List<Object> diariosgeneralessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  DiariosGeneralesLogic()throws SQLException,Exception {
		try	{
			this.diariosgeneraless= new ArrayList<DiariosGenerales>();
			this.diariosgenerales= new DiariosGenerales();
			this.diariosgeneralesObject=new Object();
			this.diariosgeneralessObject=new ArrayList<Object>();
			
			this.diariosgeneralesDataAccess=this;
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
			this.diariosgeneralesDataAccess.setConnexionType(this.connexionType);
			this.diariosgeneralesDataAccess.setParameterDbType(this.parameterDbType);
			this.diariosgeneralesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DiariosGeneralesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.diariosgeneraless= new ArrayList<DiariosGenerales>();
			this.diariosgenerales= new DiariosGenerales();
			this.diariosgeneralesObject=new Object();
			this.diariosgeneralessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.diariosgeneralesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.diariosgeneralesDataAccess.setConnexionType(this.connexionType);
			this.diariosgeneralesDataAccess.setParameterDbType(this.parameterDbType);
			this.diariosgeneralesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DiariosGenerales getDiariosGenerales() throws Exception {	
		DiariosGeneralesLogicAdditional.checkDiariosGeneralesToGet(diariosgenerales,this.datosCliente,this.arrDatoGeneral);
		DiariosGeneralesLogicAdditional.updateDiariosGeneralesToGet(diariosgenerales,this.arrDatoGeneral);
		
		return diariosgenerales;
	}
		
	public void setDiariosGenerales(DiariosGenerales newDiariosGenerales) {
		this.diariosgenerales = newDiariosGenerales;
	}
	
	public List<DiariosGenerales> getDiariosGeneraless() throws Exception {		
		this.quitarDiariosGeneralessNulos();
		
		DiariosGeneralesLogicAdditional.checkDiariosGeneralesToGets(diariosgeneraless,this.datosCliente,this.arrDatoGeneral);
		
		for (DiariosGenerales diariosgeneralesLocal: diariosgeneraless ) {
			DiariosGeneralesLogicAdditional.updateDiariosGeneralesToGet(diariosgeneralesLocal,this.arrDatoGeneral);
		}
		
		return diariosgeneraless;
	}
	
	public void setDiariosGeneraless(List<DiariosGenerales> newDiariosGeneraless) {
		this.diariosgeneraless = newDiariosGeneraless;
	}
	
	public Object getDiariosGeneralesObject() {	
		//this.diariosgeneralesObject=this.diariosgeneralesDataAccess.getEntityObject();
		return this.diariosgeneralesObject;
	}
		
	public void setDiariosGeneralesObject(Object newDiariosGeneralesObject) {
		this.diariosgeneralesObject = newDiariosGeneralesObject;
	}
	
	public List<Object> getDiariosGeneralessObject() {		
		//this.diariosgeneralessObject=this.diariosgeneralesDataAccess.getEntitiesObject();
		return this.diariosgeneralessObject;
	}
		
	public void setDiariosGeneralessObject(List<Object> newDiariosGeneralessObject) {
		this.diariosgeneralessObject = newDiariosGeneralessObject;
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
		diariosgeneraless = new  ArrayList<DiariosGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiariosGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariosgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		diariosgeneraless = new  ArrayList<DiariosGenerales>();
		  		  
        try {
			//DiariosGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariosgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		diariosgeneraless = new  ArrayList<DiariosGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiariosGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariosgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		diariosgeneraless = new  ArrayList<DiariosGenerales>();
		  		  
        try {
			//DiariosGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariosgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		diariosgeneraless = new  ArrayList<DiariosGenerales>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiariosGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariosgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		diariosgeneraless = new  ArrayList<DiariosGenerales>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//DiariosGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariosgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<DiariosGenerales> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiariosGenerales> entities = new  ArrayList<DiariosGenerales>();
		DiariosGenerales entity = new DiariosGenerales();		  
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
	
	public  List<DiariosGenerales> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiariosGenerales> entities = new  ArrayList<DiariosGenerales>();
		DiariosGenerales entity = new DiariosGenerales();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DiariosGenerales();
				
				
      	    	entity=DiariosGeneralesLogic.getEntityDiariosGenerales("",entity,resultSet);
      	    	
				//entity.setDiariosGeneralesOriginal( new DiariosGenerales());
      	    	//entity.setDiariosGeneralesOriginal(super.getEntity("",entity.getDiariosGeneralesOriginal(),resultSet,DiariosGeneralesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDiariosGeneralesOriginal(DiariosGeneralesDataAccess.getEntityDiariosGenerales("",entity.getDiariosGeneralesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<DiariosGenerales> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiariosGenerales> entities = new  ArrayList<DiariosGenerales>();
		DiariosGenerales entity = new DiariosGenerales();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,DiariosGenerales.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DiariosGenerales>((List<DiariosGenerales>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDiariosGeneralessOriginal(entities);
			
			}  else {
				this.diariosgeneralessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DiariosGeneralesConstantesFunciones.quitarEspaciosDiariosGeneraless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static DiariosGenerales getEntityDiariosGenerales(String strPrefijo,DiariosGenerales entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+DiariosGeneralesConstantesFunciones.CODIGO));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+DiariosGeneralesConstantesFunciones.FECHAEMISION).getTime()));
			entity.setcodigo_tipo_movimiento(resultSet.getString(strPrefijo+DiariosGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+DiariosGeneralesConstantesFunciones.NUMEROMAYOR));
			entity.setnombre_cuenta_contable(resultSet.getString(strPrefijo+DiariosGeneralesConstantesFunciones.NOMBRECUENTACONTABLE));
			entity.setdebito_local(resultSet.getDouble(strPrefijo+DiariosGeneralesConstantesFunciones.DEBITOLOCAL));
			entity.setcredito_local(resultSet.getDouble(strPrefijo+DiariosGeneralesConstantesFunciones.CREDITOLOCAL));
			entity.setdetalle(resultSet.getString(strPrefijo+DiariosGeneralesConstantesFunciones.DETALLE));
			entity.setcodigo_cuenta_contable(resultSet.getString(strPrefijo+DiariosGeneralesConstantesFunciones.CODIGOCUENTACONTABLE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DiariosGenerales getEntityDiariosGenerales(String strPrefijo,DiariosGenerales entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = DiariosGenerales.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = DiariosGenerales.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				DiariosGeneralesLogic.setFieldReflectionDiariosGenerales(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDiariosGenerales(Field field,String strPrefijo,String sColumn,DiariosGenerales entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DiariosGeneralesConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiariosGeneralesConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DiariosGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiariosGeneralesConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiariosGeneralesConstantesFunciones.NOMBRECUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiariosGeneralesConstantesFunciones.DEBITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiariosGeneralesConstantesFunciones.CREDITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiariosGeneralesConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiariosGeneralesConstantesFunciones.CODIGOCUENTACONTABLE:
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
	
	public void quitarDiariosGeneralessNulos() throws Exception {				
		
		List<DiariosGenerales> diariosgeneralessAux= new ArrayList<DiariosGenerales>();
		
		for(DiariosGenerales diariosgenerales:diariosgeneraless) {
			if(diariosgenerales!=null) {
				diariosgeneralessAux.add(diariosgenerales);
			}
		}
		
		diariosgeneraless=diariosgeneralessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<DiariosGenerales> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiariosGenerales> entities = new  ArrayList<DiariosGenerales>();
		DiariosGenerales entity = new DiariosGenerales();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DiariosGenerales>((List<DiariosGenerales>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDiariosGeneralessOriginal(entities);
			
			}  else {
				this.diariosgeneralessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DiariosGeneralesConstantesFunciones.quitarEspaciosDiariosGeneraless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		diariosgeneraless = new  ArrayList<DiariosGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiariosGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariosgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		diariosgeneraless = new  ArrayList<DiariosGenerales>();
		  		  
        try {
			//DiariosGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariosgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<DiariosGenerales> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DiariosGenerales> entities = new  ArrayList<DiariosGenerales>();
		DiariosGenerales entity = new DiariosGenerales();		  
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
	
	public  List<DiariosGenerales> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DiariosGenerales> entities = new  ArrayList<DiariosGenerales>();
		DiariosGenerales entity = new DiariosGenerales();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DiariosGenerales();
				
				if(conMapGenerico) {
					entity.setMapDiariosGenerales( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapDiariosGenerales().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DiariosGeneralesDataAccess.ISWITHSCHEMA);         		
					entity=DiariosGeneralesLogic.getEntityDiariosGenerales("",entity,resultSet,listColumns);
					
					////entity.setDiariosGeneralesOriginal( new DiariosGenerales());
					////entity.setDiariosGeneralesOriginal(super.getEntity("",entity.getDiariosGeneralesOriginal(),resultSet,DiariosGeneralesDataAccess.ISWITHSCHEMA));         		
					////entity.setDiariosGeneralesOriginal(DiariosGeneralesDataAccess.getEntityDiariosGenerales("",entity.getDiariosGeneralesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,DiariosGenerales reldiariosgenerales)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reldiariosgenerales.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DiariosGenerales reldiariosgenerales)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,reldiariosgenerales.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DiariosGenerales reldiariosgenerales)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldiariosgenerales.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,DiariosGenerales reldiariosgenerales)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);
			tipomovimientoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,reldiariosgenerales.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}


	
	
	public void getDiariosGeneralessBusquedaDiariosGeneralesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_movimiento,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//DiariosGeneralesLogic diariosgeneralesLogic=new DiariosGeneralesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DiariosGeneralesLogic.GetSelecSqlDiariosGenerales(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_tipo_movimiento,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.diariosgeneraless=this.getDiariosGeneraless();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getDiariosGeneralessBusquedaDiariosGenerales(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_movimiento,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//DiariosGeneralesLogic diariosgeneralesLogic=new DiariosGeneralesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DiariosGeneralesLogic.GetSelecSqlDiariosGenerales(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_tipo_movimiento,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.diariosgeneraless=this.getDiariosGeneraless();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlDiariosGenerales(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_movimiento,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("DiariosGenerales_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" a.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_ejercicio = "+id_ejercicio.toString();
					existeWhere=true;
				}

				if(id_tipo_movimiento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_tipo_movimiento = "+id_tipo_movimiento.toString();
					existeWhere=true;
				}

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
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
	
	
	public void deepLoad(DiariosGenerales diariosgenerales,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DiariosGeneralesLogicAdditional.updateDiariosGeneralesToGet(diariosgenerales,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		diariosgenerales.setEmpresa(diariosgeneralesDataAccess.getEmpresa(connexion,diariosgenerales));
		diariosgenerales.setSucursal(diariosgeneralesDataAccess.getSucursal(connexion,diariosgenerales));
		diariosgenerales.setEjercicio(diariosgeneralesDataAccess.getEjercicio(connexion,diariosgenerales));
		diariosgenerales.setTipoMovimiento(diariosgeneralesDataAccess.getTipoMovimiento(connexion,diariosgenerales));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				diariosgenerales.setEmpresa(diariosgeneralesDataAccess.getEmpresa(connexion,diariosgenerales));
			}

			if(clas.clas.equals(Sucursal.class)) {
				diariosgenerales.setSucursal(diariosgeneralesDataAccess.getSucursal(connexion,diariosgenerales));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				diariosgenerales.setEjercicio(diariosgeneralesDataAccess.getEjercicio(connexion,diariosgenerales));
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				diariosgenerales.setTipoMovimiento(diariosgeneralesDataAccess.getTipoMovimiento(connexion,diariosgenerales));
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
			diariosgenerales.setEmpresa(diariosgeneralesDataAccess.getEmpresa(connexion,diariosgenerales));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariosgenerales.setSucursal(diariosgeneralesDataAccess.getSucursal(connexion,diariosgenerales));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariosgenerales.setEjercicio(diariosgeneralesDataAccess.getEjercicio(connexion,diariosgenerales));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariosgenerales.setTipoMovimiento(diariosgeneralesDataAccess.getTipoMovimiento(connexion,diariosgenerales));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		diariosgenerales.setEmpresa(diariosgeneralesDataAccess.getEmpresa(connexion,diariosgenerales));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(diariosgenerales.getEmpresa(),isDeep,deepLoadType,clases);
				
		diariosgenerales.setSucursal(diariosgeneralesDataAccess.getSucursal(connexion,diariosgenerales));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(diariosgenerales.getSucursal(),isDeep,deepLoadType,clases);
				
		diariosgenerales.setEjercicio(diariosgeneralesDataAccess.getEjercicio(connexion,diariosgenerales));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(diariosgenerales.getEjercicio(),isDeep,deepLoadType,clases);
				
		diariosgenerales.setTipoMovimiento(diariosgeneralesDataAccess.getTipoMovimiento(connexion,diariosgenerales));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(diariosgenerales.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				diariosgenerales.setEmpresa(diariosgeneralesDataAccess.getEmpresa(connexion,diariosgenerales));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(diariosgenerales.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				diariosgenerales.setSucursal(diariosgeneralesDataAccess.getSucursal(connexion,diariosgenerales));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(diariosgenerales.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				diariosgenerales.setEjercicio(diariosgeneralesDataAccess.getEjercicio(connexion,diariosgenerales));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(diariosgenerales.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				diariosgenerales.setTipoMovimiento(diariosgeneralesDataAccess.getTipoMovimiento(connexion,diariosgenerales));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(diariosgenerales.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			diariosgenerales.setEmpresa(diariosgeneralesDataAccess.getEmpresa(connexion,diariosgenerales));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(diariosgenerales.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariosgenerales.setSucursal(diariosgeneralesDataAccess.getSucursal(connexion,diariosgenerales));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(diariosgenerales.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariosgenerales.setEjercicio(diariosgeneralesDataAccess.getEjercicio(connexion,diariosgenerales));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(diariosgenerales.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariosgenerales.setTipoMovimiento(diariosgeneralesDataAccess.getTipoMovimiento(connexion,diariosgenerales));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(diariosgenerales.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(diariosgenerales,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DiariosGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesDiariosGenerales(diariosgenerales);
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
			this.deepLoad(this.diariosgenerales,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DiariosGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesDiariosGenerales(this.diariosgenerales);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(diariosgeneraless!=null) {
				for(DiariosGenerales diariosgenerales:diariosgeneraless) {
					this.deepLoad(diariosgenerales,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DiariosGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesDiariosGenerales(diariosgeneraless);
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
			if(diariosgeneraless!=null) {
				for(DiariosGenerales diariosgenerales:diariosgeneraless) {
					this.deepLoad(diariosgenerales,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DiariosGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesDiariosGenerales(diariosgeneraless);
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
	
	public DiariosGeneralesParameterReturnGeneral procesarAccionDiariosGeneraless(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DiariosGenerales> diariosgeneraless,DiariosGeneralesParameterReturnGeneral diariosgeneralesParameterGeneral)throws Exception {
		 try {	
			DiariosGeneralesParameterReturnGeneral diariosgeneralesReturnGeneral=new DiariosGeneralesParameterReturnGeneral();
	
			DiariosGeneralesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,diariosgeneraless,diariosgeneralesParameterGeneral,diariosgeneralesReturnGeneral);
			
			return diariosgeneralesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DiariosGeneralesParameterReturnGeneral procesarAccionDiariosGeneralessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DiariosGenerales> diariosgeneraless,DiariosGeneralesParameterReturnGeneral diariosgeneralesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			DiariosGeneralesParameterReturnGeneral diariosgeneralesReturnGeneral=new DiariosGeneralesParameterReturnGeneral();
	
			DiariosGeneralesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,diariosgeneraless,diariosgeneralesParameterGeneral,diariosgeneralesReturnGeneral);
			
			this.connexion.commit();
			
			return diariosgeneralesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

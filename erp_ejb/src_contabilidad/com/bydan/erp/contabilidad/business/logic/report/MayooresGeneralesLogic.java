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
import com.bydan.erp.contabilidad.util.report.MayooresGeneralesParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.MayooresGeneralesParameterGeneral;
import com.bydan.erp.contabilidad.util.report.MayooresGeneralesConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.MayooresGenerales;

import com.bydan.erp.contabilidad.business.logic.report.MayooresGeneralesLogicAdditional;
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
public class MayooresGeneralesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(MayooresGeneralesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected MayooresGeneralesLogic mayooresgeneralesDataAccess; 		
	protected MayooresGenerales mayooresgenerales;
	protected List<MayooresGenerales> mayooresgeneraless;
	protected Object mayooresgeneralesObject;	
	protected List<Object> mayooresgeneralessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  MayooresGeneralesLogic()throws SQLException,Exception {
		try	{
			this.mayooresgeneraless= new ArrayList<MayooresGenerales>();
			this.mayooresgenerales= new MayooresGenerales();
			this.mayooresgeneralesObject=new Object();
			this.mayooresgeneralessObject=new ArrayList<Object>();
			
			this.mayooresgeneralesDataAccess=this;
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
			this.mayooresgeneralesDataAccess.setConnexionType(this.connexionType);
			this.mayooresgeneralesDataAccess.setParameterDbType(this.parameterDbType);
			this.mayooresgeneralesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MayooresGeneralesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.mayooresgeneraless= new ArrayList<MayooresGenerales>();
			this.mayooresgenerales= new MayooresGenerales();
			this.mayooresgeneralesObject=new Object();
			this.mayooresgeneralessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.mayooresgeneralesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.mayooresgeneralesDataAccess.setConnexionType(this.connexionType);
			this.mayooresgeneralesDataAccess.setParameterDbType(this.parameterDbType);
			this.mayooresgeneralesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MayooresGenerales getMayooresGenerales() throws Exception {	
		MayooresGeneralesLogicAdditional.checkMayooresGeneralesToGet(mayooresgenerales,this.datosCliente,this.arrDatoGeneral);
		MayooresGeneralesLogicAdditional.updateMayooresGeneralesToGet(mayooresgenerales,this.arrDatoGeneral);
		
		return mayooresgenerales;
	}
		
	public void setMayooresGenerales(MayooresGenerales newMayooresGenerales) {
		this.mayooresgenerales = newMayooresGenerales;
	}
	
	public List<MayooresGenerales> getMayooresGeneraless() throws Exception {		
		this.quitarMayooresGeneralessNulos();
		
		MayooresGeneralesLogicAdditional.checkMayooresGeneralesToGets(mayooresgeneraless,this.datosCliente,this.arrDatoGeneral);
		
		for (MayooresGenerales mayooresgeneralesLocal: mayooresgeneraless ) {
			MayooresGeneralesLogicAdditional.updateMayooresGeneralesToGet(mayooresgeneralesLocal,this.arrDatoGeneral);
		}
		
		return mayooresgeneraless;
	}
	
	public void setMayooresGeneraless(List<MayooresGenerales> newMayooresGeneraless) {
		this.mayooresgeneraless = newMayooresGeneraless;
	}
	
	public Object getMayooresGeneralesObject() {	
		//this.mayooresgeneralesObject=this.mayooresgeneralesDataAccess.getEntityObject();
		return this.mayooresgeneralesObject;
	}
		
	public void setMayooresGeneralesObject(Object newMayooresGeneralesObject) {
		this.mayooresgeneralesObject = newMayooresGeneralesObject;
	}
	
	public List<Object> getMayooresGeneralessObject() {		
		//this.mayooresgeneralessObject=this.mayooresgeneralesDataAccess.getEntitiesObject();
		return this.mayooresgeneralessObject;
	}
		
	public void setMayooresGeneralessObject(List<Object> newMayooresGeneralessObject) {
		this.mayooresgeneralessObject = newMayooresGeneralessObject;
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
		mayooresgeneraless = new  ArrayList<MayooresGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MayooresGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mayooresgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		mayooresgeneraless = new  ArrayList<MayooresGenerales>();
		  		  
        try {
			//MayooresGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mayooresgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mayooresgeneraless = new  ArrayList<MayooresGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MayooresGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mayooresgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		mayooresgeneraless = new  ArrayList<MayooresGenerales>();
		  		  
        try {
			//MayooresGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mayooresgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		mayooresgeneraless = new  ArrayList<MayooresGenerales>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MayooresGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mayooresgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		mayooresgeneraless = new  ArrayList<MayooresGenerales>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//MayooresGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mayooresgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<MayooresGenerales> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MayooresGenerales> entities = new  ArrayList<MayooresGenerales>();
		MayooresGenerales entity = new MayooresGenerales();		  
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
	
	public  List<MayooresGenerales> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MayooresGenerales> entities = new  ArrayList<MayooresGenerales>();
		MayooresGenerales entity = new MayooresGenerales();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MayooresGenerales();
				
				
      	    	entity=MayooresGeneralesLogic.getEntityMayooresGenerales("",entity,resultSet);
      	    	
				//entity.setMayooresGeneralesOriginal( new MayooresGenerales());
      	    	//entity.setMayooresGeneralesOriginal(super.getEntity("",entity.getMayooresGeneralesOriginal(),resultSet,MayooresGeneralesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMayooresGeneralesOriginal(MayooresGeneralesDataAccess.getEntityMayooresGenerales("",entity.getMayooresGeneralesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<MayooresGenerales> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MayooresGenerales> entities = new  ArrayList<MayooresGenerales>();
		MayooresGenerales entity = new MayooresGenerales();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,MayooresGenerales.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<MayooresGenerales>((List<MayooresGenerales>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setMayooresGeneralessOriginal(entities);
			
			}  else {
				this.mayooresgeneralessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//MayooresGeneralesConstantesFunciones.quitarEspaciosMayooresGeneraless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static MayooresGenerales getEntityMayooresGenerales(String strPrefijo,MayooresGenerales entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+MayooresGeneralesConstantesFunciones.NOMBRESUCURSAL));
			entity.setcodigo(resultSet.getString(strPrefijo+MayooresGeneralesConstantesFunciones.CODIGO));
			entity.setbeneficiario(resultSet.getString(strPrefijo+MayooresGeneralesConstantesFunciones.BENEFICIARIO));
			entity.setdetalle(resultSet.getString(strPrefijo+MayooresGeneralesConstantesFunciones.DETALLE));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+MayooresGeneralesConstantesFunciones.FECHAEMISION).getTime()));
			entity.setcodigo_tipo_movimiento(resultSet.getString(strPrefijo+MayooresGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+MayooresGeneralesConstantesFunciones.NUMEROMAYOR));
			entity.setnombre_cuenta_contable(resultSet.getString(strPrefijo+MayooresGeneralesConstantesFunciones.NOMBRECUENTACONTABLE));
			entity.setdebito_local(resultSet.getDouble(strPrefijo+MayooresGeneralesConstantesFunciones.DEBITOLOCAL));
			entity.setcredito_local(resultSet.getDouble(strPrefijo+MayooresGeneralesConstantesFunciones.CREDITOLOCAL));
			entity.setdetalle_detalle_asiento_contable(resultSet.getString(strPrefijo+MayooresGeneralesConstantesFunciones.DETALLEDETALLEASIENTOCONTABLE));
			entity.setcodigo_cuenta_contable(resultSet.getString(strPrefijo+MayooresGeneralesConstantesFunciones.CODIGOCUENTACONTABLE));
			entity.setsaldo(resultSet.getDouble(strPrefijo+MayooresGeneralesConstantesFunciones.SALDO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MayooresGenerales getEntityMayooresGenerales(String strPrefijo,MayooresGenerales entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = MayooresGenerales.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = MayooresGenerales.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				MayooresGeneralesLogic.setFieldReflectionMayooresGenerales(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMayooresGenerales(Field field,String strPrefijo,String sColumn,MayooresGenerales entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MayooresGeneralesConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MayooresGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.NOMBRECUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.DEBITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.CREDITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.DETALLEDETALLEASIENTOCONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.CODIGOCUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MayooresGeneralesConstantesFunciones.SALDO:
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
	
	public void quitarMayooresGeneralessNulos() throws Exception {				
		
		List<MayooresGenerales> mayooresgeneralessAux= new ArrayList<MayooresGenerales>();
		
		for(MayooresGenerales mayooresgenerales:mayooresgeneraless) {
			if(mayooresgenerales!=null) {
				mayooresgeneralessAux.add(mayooresgenerales);
			}
		}
		
		mayooresgeneraless=mayooresgeneralessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<MayooresGenerales> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MayooresGenerales> entities = new  ArrayList<MayooresGenerales>();
		MayooresGenerales entity = new MayooresGenerales();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<MayooresGenerales>((List<MayooresGenerales>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setMayooresGeneralessOriginal(entities);
			
			}  else {
				this.mayooresgeneralessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//MayooresGeneralesConstantesFunciones.quitarEspaciosMayooresGeneraless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		mayooresgeneraless = new  ArrayList<MayooresGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//MayooresGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mayooresgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		mayooresgeneraless = new  ArrayList<MayooresGenerales>();
		  		  
        try {
			//MayooresGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mayooresgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<MayooresGenerales> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<MayooresGenerales> entities = new  ArrayList<MayooresGenerales>();
		MayooresGenerales entity = new MayooresGenerales();		  
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
	
	public  List<MayooresGenerales> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<MayooresGenerales> entities = new  ArrayList<MayooresGenerales>();
		MayooresGenerales entity = new MayooresGenerales();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MayooresGenerales();
				
				if(conMapGenerico) {
					entity.setMapMayooresGenerales( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapMayooresGenerales().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MayooresGeneralesDataAccess.ISWITHSCHEMA);         		
					entity=MayooresGeneralesLogic.getEntityMayooresGenerales("",entity,resultSet,listColumns);
					
					////entity.setMayooresGeneralesOriginal( new MayooresGenerales());
					////entity.setMayooresGeneralesOriginal(super.getEntity("",entity.getMayooresGeneralesOriginal(),resultSet,MayooresGeneralesDataAccess.ISWITHSCHEMA));         		
					////entity.setMayooresGeneralesOriginal(MayooresGeneralesDataAccess.getEntityMayooresGenerales("",entity.getMayooresGeneralesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,MayooresGenerales relmayooresgenerales)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relmayooresgenerales.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,MayooresGenerales relmayooresgenerales)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relmayooresgenerales.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public CuentaContable getCuentaContable(Connexion connexion,MayooresGenerales relmayooresgenerales)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontableDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relmayooresgenerales.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


	
	
	public void getMayooresGeneralessBusquedaMayooresGeneralesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_cuenta_contable,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//MayooresGeneralesLogic mayooresgeneralesLogic=new MayooresGeneralesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=MayooresGeneralesLogic.GetSelecSqlMayooresGenerales(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_cuenta_contable,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.mayooresgeneraless=this.getMayooresGeneraless();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getMayooresGeneralessBusquedaMayooresGenerales(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_cuenta_contable,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//MayooresGeneralesLogic mayooresgeneralesLogic=new MayooresGeneralesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=MayooresGeneralesLogic.GetSelecSqlMayooresGenerales(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_cuenta_contable,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.mayooresgeneraless=this.getMayooresGeneraless();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlMayooresGenerales(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_cuenta_contable,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("MayooresGenerales_Postgres.sql");
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
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_ejercicio = "+id_ejercicio.toString();
					existeWhere=true;
				}

				if(id_cuenta_contable!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_cuenta_contable = "+id_cuenta_contable.toString();
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
	
	
	public void deepLoad(MayooresGenerales mayooresgenerales,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MayooresGeneralesLogicAdditional.updateMayooresGeneralesToGet(mayooresgenerales,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mayooresgenerales.setEmpresa(mayooresgeneralesDataAccess.getEmpresa(connexion,mayooresgenerales));
		mayooresgenerales.setEjercicio(mayooresgeneralesDataAccess.getEjercicio(connexion,mayooresgenerales));
		mayooresgenerales.setCuentaContable(mayooresgeneralesDataAccess.getCuentaContable(connexion,mayooresgenerales));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mayooresgenerales.setEmpresa(mayooresgeneralesDataAccess.getEmpresa(connexion,mayooresgenerales));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				mayooresgenerales.setEjercicio(mayooresgeneralesDataAccess.getEjercicio(connexion,mayooresgenerales));
			}

			if(clas.clas.equals(CuentaContable.class)) {
				mayooresgenerales.setCuentaContable(mayooresgeneralesDataAccess.getCuentaContable(connexion,mayooresgenerales));
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
			mayooresgenerales.setEmpresa(mayooresgeneralesDataAccess.getEmpresa(connexion,mayooresgenerales));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mayooresgenerales.setEjercicio(mayooresgeneralesDataAccess.getEjercicio(connexion,mayooresgenerales));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mayooresgenerales.setCuentaContable(mayooresgeneralesDataAccess.getCuentaContable(connexion,mayooresgenerales));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mayooresgenerales.setEmpresa(mayooresgeneralesDataAccess.getEmpresa(connexion,mayooresgenerales));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mayooresgenerales.getEmpresa(),isDeep,deepLoadType,clases);
				
		mayooresgenerales.setEjercicio(mayooresgeneralesDataAccess.getEjercicio(connexion,mayooresgenerales));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(mayooresgenerales.getEjercicio(),isDeep,deepLoadType,clases);
				
		mayooresgenerales.setCuentaContable(mayooresgeneralesDataAccess.getCuentaContable(connexion,mayooresgenerales));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(mayooresgenerales.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mayooresgenerales.setEmpresa(mayooresgeneralesDataAccess.getEmpresa(connexion,mayooresgenerales));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(mayooresgenerales.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				mayooresgenerales.setEjercicio(mayooresgeneralesDataAccess.getEjercicio(connexion,mayooresgenerales));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(mayooresgenerales.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(CuentaContable.class)) {
				mayooresgenerales.setCuentaContable(mayooresgeneralesDataAccess.getCuentaContable(connexion,mayooresgenerales));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(mayooresgenerales.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			mayooresgenerales.setEmpresa(mayooresgeneralesDataAccess.getEmpresa(connexion,mayooresgenerales));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(mayooresgenerales.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mayooresgenerales.setEjercicio(mayooresgeneralesDataAccess.getEjercicio(connexion,mayooresgenerales));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(mayooresgenerales.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mayooresgenerales.setCuentaContable(mayooresgeneralesDataAccess.getCuentaContable(connexion,mayooresgenerales));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(mayooresgenerales.getCuentaContable(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(mayooresgenerales,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MayooresGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesMayooresGenerales(mayooresgenerales);
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
			this.deepLoad(this.mayooresgenerales,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MayooresGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesMayooresGenerales(this.mayooresgenerales);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(mayooresgeneraless!=null) {
				for(MayooresGenerales mayooresgenerales:mayooresgeneraless) {
					this.deepLoad(mayooresgenerales,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MayooresGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesMayooresGenerales(mayooresgeneraless);
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
			if(mayooresgeneraless!=null) {
				for(MayooresGenerales mayooresgenerales:mayooresgeneraless) {
					this.deepLoad(mayooresgenerales,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MayooresGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesMayooresGenerales(mayooresgeneraless);
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
	
	public MayooresGeneralesParameterReturnGeneral procesarAccionMayooresGeneraless(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MayooresGenerales> mayooresgeneraless,MayooresGeneralesParameterReturnGeneral mayooresgeneralesParameterGeneral)throws Exception {
		 try {	
			MayooresGeneralesParameterReturnGeneral mayooresgeneralesReturnGeneral=new MayooresGeneralesParameterReturnGeneral();
	
			MayooresGeneralesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mayooresgeneraless,mayooresgeneralesParameterGeneral,mayooresgeneralesReturnGeneral);
			
			return mayooresgeneralesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MayooresGeneralesParameterReturnGeneral procesarAccionMayooresGeneralessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MayooresGenerales> mayooresgeneraless,MayooresGeneralesParameterReturnGeneral mayooresgeneralesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			MayooresGeneralesParameterReturnGeneral mayooresgeneralesReturnGeneral=new MayooresGeneralesParameterReturnGeneral();
	
			MayooresGeneralesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mayooresgeneraless,mayooresgeneralesParameterGeneral,mayooresgeneralesReturnGeneral);
			
			this.connexion.commit();
			
			return mayooresgeneralesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

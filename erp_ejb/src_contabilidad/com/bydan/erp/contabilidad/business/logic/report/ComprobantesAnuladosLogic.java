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
import com.bydan.erp.contabilidad.util.report.ComprobantesAnuladosParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ComprobantesAnuladosParameterGeneral;
import com.bydan.erp.contabilidad.util.report.ComprobantesAnuladosConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.ComprobantesAnulados;

import com.bydan.erp.contabilidad.business.logic.report.ComprobantesAnuladosLogicAdditional;
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
public class ComprobantesAnuladosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ComprobantesAnuladosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ComprobantesAnuladosLogic comprobantesanuladosDataAccess; 		
	protected ComprobantesAnulados comprobantesanulados;
	protected List<ComprobantesAnulados> comprobantesanuladoss;
	protected Object comprobantesanuladosObject;	
	protected List<Object> comprobantesanuladossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ComprobantesAnuladosLogic()throws SQLException,Exception {
		try	{
			this.comprobantesanuladoss= new ArrayList<ComprobantesAnulados>();
			this.comprobantesanulados= new ComprobantesAnulados();
			this.comprobantesanuladosObject=new Object();
			this.comprobantesanuladossObject=new ArrayList<Object>();
			
			this.comprobantesanuladosDataAccess=this;
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
			this.comprobantesanuladosDataAccess.setConnexionType(this.connexionType);
			this.comprobantesanuladosDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobantesanuladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComprobantesAnuladosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.comprobantesanuladoss= new ArrayList<ComprobantesAnulados>();
			this.comprobantesanulados= new ComprobantesAnulados();
			this.comprobantesanuladosObject=new Object();
			this.comprobantesanuladossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.comprobantesanuladosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.comprobantesanuladosDataAccess.setConnexionType(this.connexionType);
			this.comprobantesanuladosDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobantesanuladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComprobantesAnulados getComprobantesAnulados() throws Exception {	
		ComprobantesAnuladosLogicAdditional.checkComprobantesAnuladosToGet(comprobantesanulados,this.datosCliente,this.arrDatoGeneral);
		ComprobantesAnuladosLogicAdditional.updateComprobantesAnuladosToGet(comprobantesanulados,this.arrDatoGeneral);
		
		return comprobantesanulados;
	}
		
	public void setComprobantesAnulados(ComprobantesAnulados newComprobantesAnulados) {
		this.comprobantesanulados = newComprobantesAnulados;
	}
	
	public List<ComprobantesAnulados> getComprobantesAnuladoss() throws Exception {		
		this.quitarComprobantesAnuladossNulos();
		
		ComprobantesAnuladosLogicAdditional.checkComprobantesAnuladosToGets(comprobantesanuladoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ComprobantesAnulados comprobantesanuladosLocal: comprobantesanuladoss ) {
			ComprobantesAnuladosLogicAdditional.updateComprobantesAnuladosToGet(comprobantesanuladosLocal,this.arrDatoGeneral);
		}
		
		return comprobantesanuladoss;
	}
	
	public void setComprobantesAnuladoss(List<ComprobantesAnulados> newComprobantesAnuladoss) {
		this.comprobantesanuladoss = newComprobantesAnuladoss;
	}
	
	public Object getComprobantesAnuladosObject() {	
		//this.comprobantesanuladosObject=this.comprobantesanuladosDataAccess.getEntityObject();
		return this.comprobantesanuladosObject;
	}
		
	public void setComprobantesAnuladosObject(Object newComprobantesAnuladosObject) {
		this.comprobantesanuladosObject = newComprobantesAnuladosObject;
	}
	
	public List<Object> getComprobantesAnuladossObject() {		
		//this.comprobantesanuladossObject=this.comprobantesanuladosDataAccess.getEntitiesObject();
		return this.comprobantesanuladossObject;
	}
		
	public void setComprobantesAnuladossObject(List<Object> newComprobantesAnuladossObject) {
		this.comprobantesanuladossObject = newComprobantesAnuladossObject;
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
		comprobantesanuladoss = new  ArrayList<ComprobantesAnulados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobantesAnuladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantesanuladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		comprobantesanuladoss = new  ArrayList<ComprobantesAnulados>();
		  		  
        try {
			//ComprobantesAnuladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantesanuladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comprobantesanuladoss = new  ArrayList<ComprobantesAnulados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobantesAnuladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantesanuladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobantesanuladoss = new  ArrayList<ComprobantesAnulados>();
		  		  
        try {
			//ComprobantesAnuladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantesanuladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		comprobantesanuladoss = new  ArrayList<ComprobantesAnulados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobantesAnuladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantesanuladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobantesanuladoss = new  ArrayList<ComprobantesAnulados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ComprobantesAnuladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantesanuladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ComprobantesAnulados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobantesAnulados> entities = new  ArrayList<ComprobantesAnulados>();
		ComprobantesAnulados entity = new ComprobantesAnulados();		  
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
	
	public  List<ComprobantesAnulados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobantesAnulados> entities = new  ArrayList<ComprobantesAnulados>();
		ComprobantesAnulados entity = new ComprobantesAnulados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobantesAnulados();
				
				
      	    	entity=ComprobantesAnuladosLogic.getEntityComprobantesAnulados("",entity,resultSet);
      	    	
				//entity.setComprobantesAnuladosOriginal( new ComprobantesAnulados());
      	    	//entity.setComprobantesAnuladosOriginal(super.getEntity("",entity.getComprobantesAnuladosOriginal(),resultSet,ComprobantesAnuladosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComprobantesAnuladosOriginal(ComprobantesAnuladosDataAccess.getEntityComprobantesAnulados("",entity.getComprobantesAnuladosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ComprobantesAnulados> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobantesAnulados> entities = new  ArrayList<ComprobantesAnulados>();
		ComprobantesAnulados entity = new ComprobantesAnulados();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ComprobantesAnulados.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobantesAnulados>((List<ComprobantesAnulados>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobantesAnuladossOriginal(entities);
			
			}  else {
				this.comprobantesanuladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobantesAnuladosConstantesFunciones.quitarEspaciosComprobantesAnuladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ComprobantesAnulados getEntityComprobantesAnulados(String strPrefijo,ComprobantesAnulados entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setuser_name_usuario(resultSet.getString(strPrefijo+ComprobantesAnuladosConstantesFunciones.USERNAMEUSUARIO));
			entity.setnombre_modulo(resultSet.getString(strPrefijo+ComprobantesAnuladosConstantesFunciones.NOMBREMODULO));
			entity.setcodigo(resultSet.getString(strPrefijo+ComprobantesAnuladosConstantesFunciones.CODIGO));
			entity.setbeneficiario(resultSet.getString(strPrefijo+ComprobantesAnuladosConstantesFunciones.BENEFICIARIO));
			entity.setdetalle(resultSet.getString(strPrefijo+ComprobantesAnuladosConstantesFunciones.DETALLE));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+ComprobantesAnuladosConstantesFunciones.FECHAEMISION).getTime()));
			entity.setcodigo_tipo_movimiento(resultSet.getString(strPrefijo+ComprobantesAnuladosConstantesFunciones.CODIGOTIPOMOVIMIENTO));
			entity.setnumero_mayor_dato(resultSet.getString(strPrefijo+ComprobantesAnuladosConstantesFunciones.NUMEROMAYORDATO));
			entity.setnombre_cuenta_contable(resultSet.getString(strPrefijo+ComprobantesAnuladosConstantesFunciones.NOMBRECUENTACONTABLE));
			entity.setdebito_local(resultSet.getDouble(strPrefijo+ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL));
			entity.setcredito_local(resultSet.getDouble(strPrefijo+ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL));
			entity.setcodigo_cuenta_contable(resultSet.getString(strPrefijo+ComprobantesAnuladosConstantesFunciones.CODIGOCUENTACONTABLE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComprobantesAnulados getEntityComprobantesAnulados(String strPrefijo,ComprobantesAnulados entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ComprobantesAnulados.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ComprobantesAnulados.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ComprobantesAnuladosLogic.setFieldReflectionComprobantesAnulados(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComprobantesAnulados(Field field,String strPrefijo,String sColumn,ComprobantesAnulados entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComprobantesAnuladosConstantesFunciones.USERNAMEUSUARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.NOMBREMODULO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.CODIGOTIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.NUMEROMAYORDATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.NOMBRECUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobantesAnuladosConstantesFunciones.CODIGOCUENTACONTABLE:
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
	
	public void quitarComprobantesAnuladossNulos() throws Exception {				
		
		List<ComprobantesAnulados> comprobantesanuladossAux= new ArrayList<ComprobantesAnulados>();
		
		for(ComprobantesAnulados comprobantesanulados:comprobantesanuladoss) {
			if(comprobantesanulados!=null) {
				comprobantesanuladossAux.add(comprobantesanulados);
			}
		}
		
		comprobantesanuladoss=comprobantesanuladossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ComprobantesAnulados> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobantesAnulados> entities = new  ArrayList<ComprobantesAnulados>();
		ComprobantesAnulados entity = new ComprobantesAnulados();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobantesAnulados>((List<ComprobantesAnulados>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobantesAnuladossOriginal(entities);
			
			}  else {
				this.comprobantesanuladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobantesAnuladosConstantesFunciones.quitarEspaciosComprobantesAnuladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		comprobantesanuladoss = new  ArrayList<ComprobantesAnulados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobantesAnuladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantesanuladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		comprobantesanuladoss = new  ArrayList<ComprobantesAnulados>();
		  		  
        try {
			//ComprobantesAnuladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantesanuladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ComprobantesAnulados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobantesAnulados> entities = new  ArrayList<ComprobantesAnulados>();
		ComprobantesAnulados entity = new ComprobantesAnulados();		  
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
	
	public  List<ComprobantesAnulados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobantesAnulados> entities = new  ArrayList<ComprobantesAnulados>();
		ComprobantesAnulados entity = new ComprobantesAnulados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobantesAnulados();
				
				if(conMapGenerico) {
					entity.setMapComprobantesAnulados( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapComprobantesAnulados().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComprobantesAnuladosDataAccess.ISWITHSCHEMA);         		
					entity=ComprobantesAnuladosLogic.getEntityComprobantesAnulados("",entity,resultSet,listColumns);
					
					////entity.setComprobantesAnuladosOriginal( new ComprobantesAnulados());
					////entity.setComprobantesAnuladosOriginal(super.getEntity("",entity.getComprobantesAnuladosOriginal(),resultSet,ComprobantesAnuladosDataAccess.ISWITHSCHEMA));         		
					////entity.setComprobantesAnuladosOriginal(ComprobantesAnuladosDataAccess.getEntityComprobantesAnulados("",entity.getComprobantesAnuladosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ComprobantesAnulados relcomprobantesanulados)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcomprobantesanulados.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ComprobantesAnulados relcomprobantesanulados)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relcomprobantesanulados.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,ComprobantesAnulados relcomprobantesanulados)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relcomprobantesanulados.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,ComprobantesAnulados relcomprobantesanulados)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);
			tipodocumentoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relcomprobantesanulados.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,ComprobantesAnulados relcomprobantesanulados)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);
			tipomovimientoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relcomprobantesanulados.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}


	
	
	public void getComprobantesAnuladossBusquedaComprobantesAnuladosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_documento,Long id_tipo_movimiento,String numero_mayor,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//ComprobantesAnuladosLogic comprobantesanuladosLogic=new ComprobantesAnuladosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobantesAnuladosLogic.GetSelecSqlComprobantesAnulados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_tipo_documento,id_tipo_movimiento,numero_mayor,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobantesanuladoss=this.getComprobantesAnuladoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getComprobantesAnuladossBusquedaComprobantesAnulados(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_documento,Long id_tipo_movimiento,String numero_mayor,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//ComprobantesAnuladosLogic comprobantesanuladosLogic=new ComprobantesAnuladosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobantesAnuladosLogic.GetSelecSqlComprobantesAnulados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_tipo_documento,id_tipo_movimiento,numero_mayor,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobantesanuladoss=this.getComprobantesAnuladoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlComprobantesAnulados(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_documento,Long id_tipo_movimiento,String numero_mayor,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ComprobantesAnulados_Postgres.sql");
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

				if(id_tipo_documento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_tipo_documento = "+id_tipo_documento.toString();
					existeWhere=true;
				}

				if(id_tipo_movimiento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_tipo_movimiento = "+id_tipo_movimiento.toString();
					existeWhere=true;
				}

				if(numero_mayor!= null && !numero_mayor.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.numero_mayor = "+"'"+numero_mayor+"'";
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
	
	
	public void deepLoad(ComprobantesAnulados comprobantesanulados,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComprobantesAnuladosLogicAdditional.updateComprobantesAnuladosToGet(comprobantesanulados,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobantesanulados.setEmpresa(comprobantesanuladosDataAccess.getEmpresa(connexion,comprobantesanulados));
		comprobantesanulados.setSucursal(comprobantesanuladosDataAccess.getSucursal(connexion,comprobantesanulados));
		comprobantesanulados.setEjercicio(comprobantesanuladosDataAccess.getEjercicio(connexion,comprobantesanulados));
		comprobantesanulados.setTipoDocumento(comprobantesanuladosDataAccess.getTipoDocumento(connexion,comprobantesanulados));
		comprobantesanulados.setTipoMovimiento(comprobantesanuladosDataAccess.getTipoMovimiento(connexion,comprobantesanulados));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobantesanulados.setEmpresa(comprobantesanuladosDataAccess.getEmpresa(connexion,comprobantesanulados));
			}

			if(clas.clas.equals(Sucursal.class)) {
				comprobantesanulados.setSucursal(comprobantesanuladosDataAccess.getSucursal(connexion,comprobantesanulados));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				comprobantesanulados.setEjercicio(comprobantesanuladosDataAccess.getEjercicio(connexion,comprobantesanulados));
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				comprobantesanulados.setTipoDocumento(comprobantesanuladosDataAccess.getTipoDocumento(connexion,comprobantesanulados));
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				comprobantesanulados.setTipoMovimiento(comprobantesanuladosDataAccess.getTipoMovimiento(connexion,comprobantesanulados));
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
			comprobantesanulados.setEmpresa(comprobantesanuladosDataAccess.getEmpresa(connexion,comprobantesanulados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantesanulados.setSucursal(comprobantesanuladosDataAccess.getSucursal(connexion,comprobantesanulados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantesanulados.setEjercicio(comprobantesanuladosDataAccess.getEjercicio(connexion,comprobantesanulados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantesanulados.setTipoDocumento(comprobantesanuladosDataAccess.getTipoDocumento(connexion,comprobantesanulados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantesanulados.setTipoMovimiento(comprobantesanuladosDataAccess.getTipoMovimiento(connexion,comprobantesanulados));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobantesanulados.setEmpresa(comprobantesanuladosDataAccess.getEmpresa(connexion,comprobantesanulados));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comprobantesanulados.getEmpresa(),isDeep,deepLoadType,clases);
				
		comprobantesanulados.setSucursal(comprobantesanuladosDataAccess.getSucursal(connexion,comprobantesanulados));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(comprobantesanulados.getSucursal(),isDeep,deepLoadType,clases);
				
		comprobantesanulados.setEjercicio(comprobantesanuladosDataAccess.getEjercicio(connexion,comprobantesanulados));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(comprobantesanulados.getEjercicio(),isDeep,deepLoadType,clases);
				
		comprobantesanulados.setTipoDocumento(comprobantesanuladosDataAccess.getTipoDocumento(connexion,comprobantesanulados));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(comprobantesanulados.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		comprobantesanulados.setTipoMovimiento(comprobantesanuladosDataAccess.getTipoMovimiento(connexion,comprobantesanulados));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(comprobantesanulados.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobantesanulados.setEmpresa(comprobantesanuladosDataAccess.getEmpresa(connexion,comprobantesanulados));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comprobantesanulados.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				comprobantesanulados.setSucursal(comprobantesanuladosDataAccess.getSucursal(connexion,comprobantesanulados));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(comprobantesanulados.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				comprobantesanulados.setEjercicio(comprobantesanuladosDataAccess.getEjercicio(connexion,comprobantesanulados));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(comprobantesanulados.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				comprobantesanulados.setTipoDocumento(comprobantesanuladosDataAccess.getTipoDocumento(connexion,comprobantesanulados));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(comprobantesanulados.getTipoDocumento(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				comprobantesanulados.setTipoMovimiento(comprobantesanuladosDataAccess.getTipoMovimiento(connexion,comprobantesanulados));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(comprobantesanulados.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			comprobantesanulados.setEmpresa(comprobantesanuladosDataAccess.getEmpresa(connexion,comprobantesanulados));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comprobantesanulados.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantesanulados.setSucursal(comprobantesanuladosDataAccess.getSucursal(connexion,comprobantesanulados));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(comprobantesanulados.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantesanulados.setEjercicio(comprobantesanuladosDataAccess.getEjercicio(connexion,comprobantesanulados));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(comprobantesanulados.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantesanulados.setTipoDocumento(comprobantesanuladosDataAccess.getTipoDocumento(connexion,comprobantesanulados));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(comprobantesanulados.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantesanulados.setTipoMovimiento(comprobantesanuladosDataAccess.getTipoMovimiento(connexion,comprobantesanulados));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(comprobantesanulados.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(comprobantesanulados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobantesAnuladosConstantesFunciones.refrescarForeignKeysDescripcionesComprobantesAnulados(comprobantesanulados);
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
			this.deepLoad(this.comprobantesanulados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobantesAnuladosConstantesFunciones.refrescarForeignKeysDescripcionesComprobantesAnulados(this.comprobantesanulados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(comprobantesanuladoss!=null) {
				for(ComprobantesAnulados comprobantesanulados:comprobantesanuladoss) {
					this.deepLoad(comprobantesanulados,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComprobantesAnuladosConstantesFunciones.refrescarForeignKeysDescripcionesComprobantesAnulados(comprobantesanuladoss);
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
			if(comprobantesanuladoss!=null) {
				for(ComprobantesAnulados comprobantesanulados:comprobantesanuladoss) {
					this.deepLoad(comprobantesanulados,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComprobantesAnuladosConstantesFunciones.refrescarForeignKeysDescripcionesComprobantesAnulados(comprobantesanuladoss);
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
	
	public ComprobantesAnuladosParameterReturnGeneral procesarAccionComprobantesAnuladoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobantesAnulados> comprobantesanuladoss,ComprobantesAnuladosParameterReturnGeneral comprobantesanuladosParameterGeneral)throws Exception {
		 try {	
			ComprobantesAnuladosParameterReturnGeneral comprobantesanuladosReturnGeneral=new ComprobantesAnuladosParameterReturnGeneral();
	
			ComprobantesAnuladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobantesanuladoss,comprobantesanuladosParameterGeneral,comprobantesanuladosReturnGeneral);
			
			return comprobantesanuladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComprobantesAnuladosParameterReturnGeneral procesarAccionComprobantesAnuladossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobantesAnulados> comprobantesanuladoss,ComprobantesAnuladosParameterReturnGeneral comprobantesanuladosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ComprobantesAnuladosParameterReturnGeneral comprobantesanuladosReturnGeneral=new ComprobantesAnuladosParameterReturnGeneral();
	
			ComprobantesAnuladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobantesanuladoss,comprobantesanuladosParameterGeneral,comprobantesanuladosReturnGeneral);
			
			this.connexion.commit();
			
			return comprobantesanuladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

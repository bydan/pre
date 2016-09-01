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
import com.bydan.erp.cartera.util.report.CobrarClientesDetalladosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesDetalladosParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarClientesDetalladosConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarClientesDetallados;

import com.bydan.erp.cartera.business.logic.report.CobrarClientesDetalladosLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarClientesDetalladosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarClientesDetalladosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarClientesDetalladosLogic cobrarclientesdetalladosDataAccess; 		
	protected CobrarClientesDetallados cobrarclientesdetallados;
	protected List<CobrarClientesDetallados> cobrarclientesdetalladoss;
	protected Object cobrarclientesdetalladosObject;	
	protected List<Object> cobrarclientesdetalladossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarClientesDetalladosLogic()throws SQLException,Exception {
		try	{
			this.cobrarclientesdetalladoss= new ArrayList<CobrarClientesDetallados>();
			this.cobrarclientesdetallados= new CobrarClientesDetallados();
			this.cobrarclientesdetalladosObject=new Object();
			this.cobrarclientesdetalladossObject=new ArrayList<Object>();
			
			this.cobrarclientesdetalladosDataAccess=this;
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
			this.cobrarclientesdetalladosDataAccess.setConnexionType(this.connexionType);
			this.cobrarclientesdetalladosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclientesdetalladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarClientesDetalladosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarclientesdetalladoss= new ArrayList<CobrarClientesDetallados>();
			this.cobrarclientesdetallados= new CobrarClientesDetallados();
			this.cobrarclientesdetalladosObject=new Object();
			this.cobrarclientesdetalladossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarclientesdetalladosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarclientesdetalladosDataAccess.setConnexionType(this.connexionType);
			this.cobrarclientesdetalladosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclientesdetalladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarClientesDetallados getCobrarClientesDetallados() throws Exception {	
		CobrarClientesDetalladosLogicAdditional.checkCobrarClientesDetalladosToGet(cobrarclientesdetallados,this.datosCliente,this.arrDatoGeneral);
		CobrarClientesDetalladosLogicAdditional.updateCobrarClientesDetalladosToGet(cobrarclientesdetallados,this.arrDatoGeneral);
		
		return cobrarclientesdetallados;
	}
		
	public void setCobrarClientesDetallados(CobrarClientesDetallados newCobrarClientesDetallados) {
		this.cobrarclientesdetallados = newCobrarClientesDetallados;
	}
	
	public List<CobrarClientesDetallados> getCobrarClientesDetalladoss() throws Exception {		
		this.quitarCobrarClientesDetalladossNulos();
		
		CobrarClientesDetalladosLogicAdditional.checkCobrarClientesDetalladosToGets(cobrarclientesdetalladoss,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarClientesDetallados cobrarclientesdetalladosLocal: cobrarclientesdetalladoss ) {
			CobrarClientesDetalladosLogicAdditional.updateCobrarClientesDetalladosToGet(cobrarclientesdetalladosLocal,this.arrDatoGeneral);
		}
		
		return cobrarclientesdetalladoss;
	}
	
	public void setCobrarClientesDetalladoss(List<CobrarClientesDetallados> newCobrarClientesDetalladoss) {
		this.cobrarclientesdetalladoss = newCobrarClientesDetalladoss;
	}
	
	public Object getCobrarClientesDetalladosObject() {	
		//this.cobrarclientesdetalladosObject=this.cobrarclientesdetalladosDataAccess.getEntityObject();
		return this.cobrarclientesdetalladosObject;
	}
		
	public void setCobrarClientesDetalladosObject(Object newCobrarClientesDetalladosObject) {
		this.cobrarclientesdetalladosObject = newCobrarClientesDetalladosObject;
	}
	
	public List<Object> getCobrarClientesDetalladossObject() {		
		//this.cobrarclientesdetalladossObject=this.cobrarclientesdetalladosDataAccess.getEntitiesObject();
		return this.cobrarclientesdetalladossObject;
	}
		
	public void setCobrarClientesDetalladossObject(List<Object> newCobrarClientesDetalladossObject) {
		this.cobrarclientesdetalladossObject = newCobrarClientesDetalladossObject;
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
		cobrarclientesdetalladoss = new  ArrayList<CobrarClientesDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarclientesdetalladoss = new  ArrayList<CobrarClientesDetallados>();
		  		  
        try {
			//CobrarClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarclientesdetalladoss = new  ArrayList<CobrarClientesDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclientesdetalladoss = new  ArrayList<CobrarClientesDetallados>();
		  		  
        try {
			//CobrarClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarclientesdetalladoss = new  ArrayList<CobrarClientesDetallados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclientesdetalladoss = new  ArrayList<CobrarClientesDetallados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarClientesDetallados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesDetallados> entities = new  ArrayList<CobrarClientesDetallados>();
		CobrarClientesDetallados entity = new CobrarClientesDetallados();		  
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
	
	public  List<CobrarClientesDetallados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesDetallados> entities = new  ArrayList<CobrarClientesDetallados>();
		CobrarClientesDetallados entity = new CobrarClientesDetallados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesDetallados();
				
				
      	    	entity=CobrarClientesDetalladosLogic.getEntityCobrarClientesDetallados("",entity,resultSet);
      	    	
				//entity.setCobrarClientesDetalladosOriginal( new CobrarClientesDetallados());
      	    	//entity.setCobrarClientesDetalladosOriginal(super.getEntity("",entity.getCobrarClientesDetalladosOriginal(),resultSet,CobrarClientesDetalladosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarClientesDetalladosOriginal(CobrarClientesDetalladosDataAccess.getEntityCobrarClientesDetallados("",entity.getCobrarClientesDetalladosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarClientesDetallados> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesDetallados> entities = new  ArrayList<CobrarClientesDetallados>();
		CobrarClientesDetallados entity = new CobrarClientesDetallados();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarClientesDetallados.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesDetallados>((List<CobrarClientesDetallados>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesDetalladossOriginal(entities);
			
			}  else {
				this.cobrarclientesdetalladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesDetalladosConstantesFunciones.quitarEspaciosCobrarClientesDetalladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarClientesDetallados getEntityCobrarClientesDetallados(String strPrefijo,CobrarClientesDetallados entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_ciudad(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.NOMBRECIUDAD));
			entity.setnombre_zona(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.NOMBREZONA));
			entity.setnombre_grupo_cliente(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.NOMBREGRUPOCLIENTE));
			entity.setnombre_titulo_cliente(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.NOMBRETITULOCLIENTE));
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.NOMBRE));
			entity.setapellido(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.APELLIDO));
			entity.setruc(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.RUC));
			entity.setnombre_contacto_cliente(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.NOMBRECONTACTOCLIENTE));
			entity.setdireccion_direccion(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.DIRECCIONDIRECCION));
			entity.sete_mail_e_mail(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.EMAILEMAIL));
			entity.settelefono_telefono(resultSet.getString(strPrefijo+CobrarClientesDetalladosConstantesFunciones.TELEFONOTELEFONO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarClientesDetallados getEntityCobrarClientesDetallados(String strPrefijo,CobrarClientesDetallados entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarClientesDetallados.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarClientesDetallados.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarClientesDetalladosLogic.setFieldReflectionCobrarClientesDetallados(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarClientesDetallados(Field field,String strPrefijo,String sColumn,CobrarClientesDetallados entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarClientesDetalladosConstantesFunciones.NOMBRECIUDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.NOMBREZONA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.NOMBREGRUPOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.NOMBRETITULOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.NOMBRECONTACTOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.DIRECCIONDIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.EMAILEMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesDetalladosConstantesFunciones.TELEFONOTELEFONO:
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
	
	public void quitarCobrarClientesDetalladossNulos() throws Exception {				
		
		List<CobrarClientesDetallados> cobrarclientesdetalladossAux= new ArrayList<CobrarClientesDetallados>();
		
		for(CobrarClientesDetallados cobrarclientesdetallados:cobrarclientesdetalladoss) {
			if(cobrarclientesdetallados!=null) {
				cobrarclientesdetalladossAux.add(cobrarclientesdetallados);
			}
		}
		
		cobrarclientesdetalladoss=cobrarclientesdetalladossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarClientesDetallados> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesDetallados> entities = new  ArrayList<CobrarClientesDetallados>();
		CobrarClientesDetallados entity = new CobrarClientesDetallados();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesDetallados>((List<CobrarClientesDetallados>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesDetalladossOriginal(entities);
			
			}  else {
				this.cobrarclientesdetalladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesDetalladosConstantesFunciones.quitarEspaciosCobrarClientesDetalladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarclientesdetalladoss = new  ArrayList<CobrarClientesDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarclientesdetalladoss = new  ArrayList<CobrarClientesDetallados>();
		  		  
        try {
			//CobrarClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarClientesDetallados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesDetallados> entities = new  ArrayList<CobrarClientesDetallados>();
		CobrarClientesDetallados entity = new CobrarClientesDetallados();		  
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
	
	public  List<CobrarClientesDetallados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesDetallados> entities = new  ArrayList<CobrarClientesDetallados>();
		CobrarClientesDetallados entity = new CobrarClientesDetallados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesDetallados();
				
				if(conMapGenerico) {
					entity.setMapCobrarClientesDetallados( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarClientesDetallados().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarClientesDetalladosDataAccess.ISWITHSCHEMA);         		
					entity=CobrarClientesDetalladosLogic.getEntityCobrarClientesDetallados("",entity,resultSet,listColumns);
					
					////entity.setCobrarClientesDetalladosOriginal( new CobrarClientesDetallados());
					////entity.setCobrarClientesDetalladosOriginal(super.getEntity("",entity.getCobrarClientesDetalladosOriginal(),resultSet,CobrarClientesDetalladosDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarClientesDetalladosOriginal(CobrarClientesDetalladosDataAccess.getEntityCobrarClientesDetallados("",entity.getCobrarClientesDetalladosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarClientesDetallados relcobrarclientesdetallados)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarclientesdetallados.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getCobrarClientesDetalladossBusquedaCobrarClientesDetalladosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//CobrarClientesDetalladosLogic cobrarclientesdetalladosLogic=new CobrarClientesDetalladosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesDetalladosLogic.GetSelecSqlCobrarClientesDetallados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclientesdetalladoss=this.getCobrarClientesDetalladoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarClientesDetalladossBusquedaCobrarClientesDetallados(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//CobrarClientesDetalladosLogic cobrarclientesdetalladosLogic=new CobrarClientesDetalladosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesDetalladosLogic.GetSelecSqlCobrarClientesDetallados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclientesdetalladoss=this.getCobrarClientesDetalladoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarClientesDetallados(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarClientesDetallados_Postgres.sql");
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
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" c.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
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
	
	
	public void deepLoad(CobrarClientesDetallados cobrarclientesdetallados,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarClientesDetalladosLogicAdditional.updateCobrarClientesDetalladosToGet(cobrarclientesdetallados,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarclientesdetallados.setEmpresa(cobrarclientesdetalladosDataAccess.getEmpresa(connexion,cobrarclientesdetallados));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarclientesdetallados.setEmpresa(cobrarclientesdetalladosDataAccess.getEmpresa(connexion,cobrarclientesdetallados));
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
			cobrarclientesdetallados.setEmpresa(cobrarclientesdetalladosDataAccess.getEmpresa(connexion,cobrarclientesdetallados));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarclientesdetallados.setEmpresa(cobrarclientesdetalladosDataAccess.getEmpresa(connexion,cobrarclientesdetallados));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarclientesdetallados.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarclientesdetallados.setEmpresa(cobrarclientesdetalladosDataAccess.getEmpresa(connexion,cobrarclientesdetallados));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarclientesdetallados.getEmpresa(),isDeep,deepLoadType,clases);				
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
			cobrarclientesdetallados.setEmpresa(cobrarclientesdetalladosDataAccess.getEmpresa(connexion,cobrarclientesdetallados));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarclientesdetallados.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarclientesdetallados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesDetallados(cobrarclientesdetallados);
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
			this.deepLoad(this.cobrarclientesdetallados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesDetallados(this.cobrarclientesdetallados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarclientesdetalladoss!=null) {
				for(CobrarClientesDetallados cobrarclientesdetallados:cobrarclientesdetalladoss) {
					this.deepLoad(cobrarclientesdetallados,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesDetallados(cobrarclientesdetalladoss);
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
			if(cobrarclientesdetalladoss!=null) {
				for(CobrarClientesDetallados cobrarclientesdetallados:cobrarclientesdetalladoss) {
					this.deepLoad(cobrarclientesdetallados,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesDetallados(cobrarclientesdetalladoss);
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
	
	public CobrarClientesDetalladosParameterReturnGeneral procesarAccionCobrarClientesDetalladoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesDetallados> cobrarclientesdetalladoss,CobrarClientesDetalladosParameterReturnGeneral cobrarclientesdetalladosParameterGeneral)throws Exception {
		 try {	
			CobrarClientesDetalladosParameterReturnGeneral cobrarclientesdetalladosReturnGeneral=new CobrarClientesDetalladosParameterReturnGeneral();
	
			CobrarClientesDetalladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclientesdetalladoss,cobrarclientesdetalladosParameterGeneral,cobrarclientesdetalladosReturnGeneral);
			
			return cobrarclientesdetalladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarClientesDetalladosParameterReturnGeneral procesarAccionCobrarClientesDetalladossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesDetallados> cobrarclientesdetalladoss,CobrarClientesDetalladosParameterReturnGeneral cobrarclientesdetalladosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarClientesDetalladosParameterReturnGeneral cobrarclientesdetalladosReturnGeneral=new CobrarClientesDetalladosParameterReturnGeneral();
	
			CobrarClientesDetalladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclientesdetalladoss,cobrarclientesdetalladosParameterGeneral,cobrarclientesdetalladosReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarclientesdetalladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

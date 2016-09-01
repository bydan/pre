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
import com.bydan.erp.cartera.util.report.SaldosCuentasPorPagarParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.SaldosCuentasPorPagarParameterGeneral;
import com.bydan.erp.cartera.util.report.SaldosCuentasPorPagarConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.SaldosCuentasPorPagar;

import com.bydan.erp.cartera.business.logic.report.SaldosCuentasPorPagarLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;






@SuppressWarnings("unused")
public class SaldosCuentasPorPagarLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(SaldosCuentasPorPagarLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected SaldosCuentasPorPagarLogic saldoscuentasporpagarDataAccess; 		
	protected SaldosCuentasPorPagar saldoscuentasporpagar;
	protected List<SaldosCuentasPorPagar> saldoscuentasporpagars;
	protected Object saldoscuentasporpagarObject;	
	protected List<Object> saldoscuentasporpagarsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  SaldosCuentasPorPagarLogic()throws SQLException,Exception {
		try	{
			this.saldoscuentasporpagars= new ArrayList<SaldosCuentasPorPagar>();
			this.saldoscuentasporpagar= new SaldosCuentasPorPagar();
			this.saldoscuentasporpagarObject=new Object();
			this.saldoscuentasporpagarsObject=new ArrayList<Object>();
			
			this.saldoscuentasporpagarDataAccess=this;
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
			this.saldoscuentasporpagarDataAccess.setConnexionType(this.connexionType);
			this.saldoscuentasporpagarDataAccess.setParameterDbType(this.parameterDbType);
			this.saldoscuentasporpagarDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SaldosCuentasPorPagarLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.saldoscuentasporpagars= new ArrayList<SaldosCuentasPorPagar>();
			this.saldoscuentasporpagar= new SaldosCuentasPorPagar();
			this.saldoscuentasporpagarObject=new Object();
			this.saldoscuentasporpagarsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.saldoscuentasporpagarDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.saldoscuentasporpagarDataAccess.setConnexionType(this.connexionType);
			this.saldoscuentasporpagarDataAccess.setParameterDbType(this.parameterDbType);
			this.saldoscuentasporpagarDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SaldosCuentasPorPagar getSaldosCuentasPorPagar() throws Exception {	
		SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToGet(saldoscuentasporpagar,this.datosCliente,this.arrDatoGeneral);
		SaldosCuentasPorPagarLogicAdditional.updateSaldosCuentasPorPagarToGet(saldoscuentasporpagar,this.arrDatoGeneral);
		
		return saldoscuentasporpagar;
	}
		
	public void setSaldosCuentasPorPagar(SaldosCuentasPorPagar newSaldosCuentasPorPagar) {
		this.saldoscuentasporpagar = newSaldosCuentasPorPagar;
	}
	
	public List<SaldosCuentasPorPagar> getSaldosCuentasPorPagars() throws Exception {		
		this.quitarSaldosCuentasPorPagarsNulos();
		
		SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToGets(saldoscuentasporpagars,this.datosCliente,this.arrDatoGeneral);
		
		for (SaldosCuentasPorPagar saldoscuentasporpagarLocal: saldoscuentasporpagars ) {
			SaldosCuentasPorPagarLogicAdditional.updateSaldosCuentasPorPagarToGet(saldoscuentasporpagarLocal,this.arrDatoGeneral);
		}
		
		return saldoscuentasporpagars;
	}
	
	public void setSaldosCuentasPorPagars(List<SaldosCuentasPorPagar> newSaldosCuentasPorPagars) {
		this.saldoscuentasporpagars = newSaldosCuentasPorPagars;
	}
	
	public Object getSaldosCuentasPorPagarObject() {	
		//this.saldoscuentasporpagarObject=this.saldoscuentasporpagarDataAccess.getEntityObject();
		return this.saldoscuentasporpagarObject;
	}
		
	public void setSaldosCuentasPorPagarObject(Object newSaldosCuentasPorPagarObject) {
		this.saldoscuentasporpagarObject = newSaldosCuentasPorPagarObject;
	}
	
	public List<Object> getSaldosCuentasPorPagarsObject() {		
		//this.saldoscuentasporpagarsObject=this.saldoscuentasporpagarDataAccess.getEntitiesObject();
		return this.saldoscuentasporpagarsObject;
	}
		
	public void setSaldosCuentasPorPagarsObject(List<Object> newSaldosCuentasPorPagarsObject) {
		this.saldoscuentasporpagarsObject = newSaldosCuentasPorPagarsObject;
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
		saldoscuentasporpagars = new  ArrayList<SaldosCuentasPorPagar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldoscuentasporpagars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		saldoscuentasporpagars = new  ArrayList<SaldosCuentasPorPagar>();
		  		  
        try {
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldoscuentasporpagars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		saldoscuentasporpagars = new  ArrayList<SaldosCuentasPorPagar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldoscuentasporpagars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		saldoscuentasporpagars = new  ArrayList<SaldosCuentasPorPagar>();
		  		  
        try {
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldoscuentasporpagars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		saldoscuentasporpagars = new  ArrayList<SaldosCuentasPorPagar>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldoscuentasporpagars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		saldoscuentasporpagars = new  ArrayList<SaldosCuentasPorPagar>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldoscuentasporpagars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<SaldosCuentasPorPagar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosCuentasPorPagar> entities = new  ArrayList<SaldosCuentasPorPagar>();
		SaldosCuentasPorPagar entity = new SaldosCuentasPorPagar();		  
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
	
	public  List<SaldosCuentasPorPagar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosCuentasPorPagar> entities = new  ArrayList<SaldosCuentasPorPagar>();
		SaldosCuentasPorPagar entity = new SaldosCuentasPorPagar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SaldosCuentasPorPagar();
				
				
      	    	entity=SaldosCuentasPorPagarLogic.getEntitySaldosCuentasPorPagar("",entity,resultSet);
      	    	
				//entity.setSaldosCuentasPorPagarOriginal( new SaldosCuentasPorPagar());
      	    	//entity.setSaldosCuentasPorPagarOriginal(super.getEntity("",entity.getSaldosCuentasPorPagarOriginal(),resultSet,SaldosCuentasPorPagarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSaldosCuentasPorPagarOriginal(SaldosCuentasPorPagarDataAccess.getEntitySaldosCuentasPorPagar("",entity.getSaldosCuentasPorPagarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<SaldosCuentasPorPagar> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosCuentasPorPagar> entities = new  ArrayList<SaldosCuentasPorPagar>();
		SaldosCuentasPorPagar entity = new SaldosCuentasPorPagar();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,SaldosCuentasPorPagar.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SaldosCuentasPorPagar>((List<SaldosCuentasPorPagar>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSaldosCuentasPorPagarsOriginal(entities);
			
			}  else {
				this.saldoscuentasporpagarsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SaldosCuentasPorPagarConstantesFunciones.quitarEspaciosSaldosCuentasPorPagars(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static SaldosCuentasPorPagar getEntitySaldosCuentasPorPagar(String strPrefijo,SaldosCuentasPorPagar entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+SaldosCuentasPorPagarConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+SaldosCuentasPorPagarConstantesFunciones.NOMBRECOMPLETO));
			entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL));
			entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL));
			entity.setsaldo_anterior(resultSet.getDouble(strPrefijo+SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR));
			entity.setsaldo_debito(resultSet.getDouble(strPrefijo+SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO));
			entity.setsaldo_credito(resultSet.getDouble(strPrefijo+SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SaldosCuentasPorPagar getEntitySaldosCuentasPorPagar(String strPrefijo,SaldosCuentasPorPagar entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = SaldosCuentasPorPagar.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = SaldosCuentasPorPagar.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				SaldosCuentasPorPagarLogic.setFieldReflectionSaldosCuentasPorPagar(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSaldosCuentasPorPagar(Field field,String strPrefijo,String sColumn,SaldosCuentasPorPagar entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SaldosCuentasPorPagarConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosCuentasPorPagarConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO:
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
	
	public void quitarSaldosCuentasPorPagarsNulos() throws Exception {				
		
		List<SaldosCuentasPorPagar> saldoscuentasporpagarsAux= new ArrayList<SaldosCuentasPorPagar>();
		
		for(SaldosCuentasPorPagar saldoscuentasporpagar:saldoscuentasporpagars) {
			if(saldoscuentasporpagar!=null) {
				saldoscuentasporpagarsAux.add(saldoscuentasporpagar);
			}
		}
		
		saldoscuentasporpagars=saldoscuentasporpagarsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<SaldosCuentasPorPagar> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosCuentasPorPagar> entities = new  ArrayList<SaldosCuentasPorPagar>();
		SaldosCuentasPorPagar entity = new SaldosCuentasPorPagar();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SaldosCuentasPorPagar>((List<SaldosCuentasPorPagar>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSaldosCuentasPorPagarsOriginal(entities);
			
			}  else {
				this.saldoscuentasporpagarsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SaldosCuentasPorPagarConstantesFunciones.quitarEspaciosSaldosCuentasPorPagars(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		saldoscuentasporpagars = new  ArrayList<SaldosCuentasPorPagar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldoscuentasporpagars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		saldoscuentasporpagars = new  ArrayList<SaldosCuentasPorPagar>();
		  		  
        try {
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldoscuentasporpagars=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<SaldosCuentasPorPagar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SaldosCuentasPorPagar> entities = new  ArrayList<SaldosCuentasPorPagar>();
		SaldosCuentasPorPagar entity = new SaldosCuentasPorPagar();		  
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
	
	public  List<SaldosCuentasPorPagar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SaldosCuentasPorPagar> entities = new  ArrayList<SaldosCuentasPorPagar>();
		SaldosCuentasPorPagar entity = new SaldosCuentasPorPagar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SaldosCuentasPorPagar();
				
				if(conMapGenerico) {
					entity.setMapSaldosCuentasPorPagar( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapSaldosCuentasPorPagar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SaldosCuentasPorPagarDataAccess.ISWITHSCHEMA);         		
					entity=SaldosCuentasPorPagarLogic.getEntitySaldosCuentasPorPagar("",entity,resultSet,listColumns);
					
					////entity.setSaldosCuentasPorPagarOriginal( new SaldosCuentasPorPagar());
					////entity.setSaldosCuentasPorPagarOriginal(super.getEntity("",entity.getSaldosCuentasPorPagarOriginal(),resultSet,SaldosCuentasPorPagarDataAccess.ISWITHSCHEMA));         		
					////entity.setSaldosCuentasPorPagarOriginal(SaldosCuentasPorPagarDataAccess.getEntitySaldosCuentasPorPagar("",entity.getSaldosCuentasPorPagarOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Zona getZona(Connexion connexion,SaldosCuentasPorPagar relsaldoscuentasporpagar)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);
			zonaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			zona=zonaDataAccess.getEntity(connexion,relsaldoscuentasporpagar.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public GrupoCliente getGrupoCliente(Connexion connexion,SaldosCuentasPorPagar relsaldoscuentasporpagar)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			grupoclienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relsaldoscuentasporpagar.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}

	public Empresa getEmpresa(Connexion connexion,SaldosCuentasPorPagar relsaldoscuentasporpagar)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relsaldoscuentasporpagar.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,SaldosCuentasPorPagar relsaldoscuentasporpagar)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relsaldoscuentasporpagar.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,SaldosCuentasPorPagar relsaldoscuentasporpagar)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relsaldoscuentasporpagar.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


	
	
	public void getSaldosCuentasPorPagarsBusquedaSaldosCuentasPorPagarWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_zona,Long id_grupo_cliente,Long id_cliente,Date fecha_emision_hasta)throws Exception {
		try {
			SaldosCuentasPorPagarLogicAdditional saldoscuentasporpagarLogicAdditional=new SaldosCuentasPorPagarLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			saldoscuentasporpagarLogicAdditional.BusquedaSaldosCuentasPorPagar(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_zona,id_grupo_cliente,id_cliente,fecha_emision_hasta);

			this.saldoscuentasporpagars=this.getSaldosCuentasPorPagars();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getSaldosCuentasPorPagarsBusquedaSaldosCuentasPorPagar(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_zona,Long id_grupo_cliente,Long id_cliente,Date fecha_emision_hasta)throws Exception {
		try {
			SaldosCuentasPorPagarLogicAdditional saldoscuentasporpagarLogicAdditional=new SaldosCuentasPorPagarLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			saldoscuentasporpagarLogicAdditional.BusquedaSaldosCuentasPorPagar(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_zona,id_grupo_cliente,id_cliente,fecha_emision_hasta);

			this.saldoscuentasporpagars=this.getSaldosCuentasPorPagars();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(SaldosCuentasPorPagar saldoscuentasporpagar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SaldosCuentasPorPagarLogicAdditional.updateSaldosCuentasPorPagarToGet(saldoscuentasporpagar,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldoscuentasporpagar.setZona(saldoscuentasporpagarDataAccess.getZona(connexion,saldoscuentasporpagar));
		saldoscuentasporpagar.setGrupoCliente(saldoscuentasporpagarDataAccess.getGrupoCliente(connexion,saldoscuentasporpagar));
		saldoscuentasporpagar.setEmpresa(saldoscuentasporpagarDataAccess.getEmpresa(connexion,saldoscuentasporpagar));
		saldoscuentasporpagar.setSucursal(saldoscuentasporpagarDataAccess.getSucursal(connexion,saldoscuentasporpagar));
		saldoscuentasporpagar.setCliente(saldoscuentasporpagarDataAccess.getCliente(connexion,saldoscuentasporpagar));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				saldoscuentasporpagar.setZona(saldoscuentasporpagarDataAccess.getZona(connexion,saldoscuentasporpagar));
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				saldoscuentasporpagar.setGrupoCliente(saldoscuentasporpagarDataAccess.getGrupoCliente(connexion,saldoscuentasporpagar));
			}

			if(clas.clas.equals(Empresa.class)) {
				saldoscuentasporpagar.setEmpresa(saldoscuentasporpagarDataAccess.getEmpresa(connexion,saldoscuentasporpagar));
			}

			if(clas.clas.equals(Sucursal.class)) {
				saldoscuentasporpagar.setSucursal(saldoscuentasporpagarDataAccess.getSucursal(connexion,saldoscuentasporpagar));
			}

			if(clas.clas.equals(Cliente.class)) {
				saldoscuentasporpagar.setCliente(saldoscuentasporpagarDataAccess.getCliente(connexion,saldoscuentasporpagar));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setZona(saldoscuentasporpagarDataAccess.getZona(connexion,saldoscuentasporpagar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setGrupoCliente(saldoscuentasporpagarDataAccess.getGrupoCliente(connexion,saldoscuentasporpagar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setEmpresa(saldoscuentasporpagarDataAccess.getEmpresa(connexion,saldoscuentasporpagar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setSucursal(saldoscuentasporpagarDataAccess.getSucursal(connexion,saldoscuentasporpagar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setCliente(saldoscuentasporpagarDataAccess.getCliente(connexion,saldoscuentasporpagar));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldoscuentasporpagar.setZona(saldoscuentasporpagarDataAccess.getZona(connexion,saldoscuentasporpagar));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(saldoscuentasporpagar.getZona(),isDeep,deepLoadType,clases);
				
		saldoscuentasporpagar.setGrupoCliente(saldoscuentasporpagarDataAccess.getGrupoCliente(connexion,saldoscuentasporpagar));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(saldoscuentasporpagar.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		saldoscuentasporpagar.setEmpresa(saldoscuentasporpagarDataAccess.getEmpresa(connexion,saldoscuentasporpagar));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(saldoscuentasporpagar.getEmpresa(),isDeep,deepLoadType,clases);
				
		saldoscuentasporpagar.setSucursal(saldoscuentasporpagarDataAccess.getSucursal(connexion,saldoscuentasporpagar));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(saldoscuentasporpagar.getSucursal(),isDeep,deepLoadType,clases);
				
		saldoscuentasporpagar.setCliente(saldoscuentasporpagarDataAccess.getCliente(connexion,saldoscuentasporpagar));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(saldoscuentasporpagar.getCliente(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				saldoscuentasporpagar.setZona(saldoscuentasporpagarDataAccess.getZona(connexion,saldoscuentasporpagar));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(saldoscuentasporpagar.getZona(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				saldoscuentasporpagar.setGrupoCliente(saldoscuentasporpagarDataAccess.getGrupoCliente(connexion,saldoscuentasporpagar));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(saldoscuentasporpagar.getGrupoCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				saldoscuentasporpagar.setEmpresa(saldoscuentasporpagarDataAccess.getEmpresa(connexion,saldoscuentasporpagar));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(saldoscuentasporpagar.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				saldoscuentasporpagar.setSucursal(saldoscuentasporpagarDataAccess.getSucursal(connexion,saldoscuentasporpagar));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(saldoscuentasporpagar.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				saldoscuentasporpagar.setCliente(saldoscuentasporpagarDataAccess.getCliente(connexion,saldoscuentasporpagar));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(saldoscuentasporpagar.getCliente(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setZona(saldoscuentasporpagarDataAccess.getZona(connexion,saldoscuentasporpagar));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(saldoscuentasporpagar.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setGrupoCliente(saldoscuentasporpagarDataAccess.getGrupoCliente(connexion,saldoscuentasporpagar));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(saldoscuentasporpagar.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setEmpresa(saldoscuentasporpagarDataAccess.getEmpresa(connexion,saldoscuentasporpagar));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(saldoscuentasporpagar.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setSucursal(saldoscuentasporpagarDataAccess.getSucursal(connexion,saldoscuentasporpagar));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(saldoscuentasporpagar.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldoscuentasporpagar.setCliente(saldoscuentasporpagarDataAccess.getCliente(connexion,saldoscuentasporpagar));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(saldoscuentasporpagar.getCliente(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(saldoscuentasporpagar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldosCuentasPorPagarConstantesFunciones.refrescarForeignKeysDescripcionesSaldosCuentasPorPagar(saldoscuentasporpagar);
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
			this.deepLoad(this.saldoscuentasporpagar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldosCuentasPorPagarConstantesFunciones.refrescarForeignKeysDescripcionesSaldosCuentasPorPagar(this.saldoscuentasporpagar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(saldoscuentasporpagars!=null) {
				for(SaldosCuentasPorPagar saldoscuentasporpagar:saldoscuentasporpagars) {
					this.deepLoad(saldoscuentasporpagar,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SaldosCuentasPorPagarConstantesFunciones.refrescarForeignKeysDescripcionesSaldosCuentasPorPagar(saldoscuentasporpagars);
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
			if(saldoscuentasporpagars!=null) {
				for(SaldosCuentasPorPagar saldoscuentasporpagar:saldoscuentasporpagars) {
					this.deepLoad(saldoscuentasporpagar,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SaldosCuentasPorPagarConstantesFunciones.refrescarForeignKeysDescripcionesSaldosCuentasPorPagar(saldoscuentasporpagars);
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
	
	public SaldosCuentasPorPagarParameterReturnGeneral procesarAccionSaldosCuentasPorPagars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldosCuentasPorPagar> saldoscuentasporpagars,SaldosCuentasPorPagarParameterReturnGeneral saldoscuentasporpagarParameterGeneral)throws Exception {
		 try {	
			SaldosCuentasPorPagarParameterReturnGeneral saldoscuentasporpagarReturnGeneral=new SaldosCuentasPorPagarParameterReturnGeneral();
	
			SaldosCuentasPorPagarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldoscuentasporpagars,saldoscuentasporpagarParameterGeneral,saldoscuentasporpagarReturnGeneral);
			
			return saldoscuentasporpagarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SaldosCuentasPorPagarParameterReturnGeneral procesarAccionSaldosCuentasPorPagarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldosCuentasPorPagar> saldoscuentasporpagars,SaldosCuentasPorPagarParameterReturnGeneral saldoscuentasporpagarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SaldosCuentasPorPagarParameterReturnGeneral saldoscuentasporpagarReturnGeneral=new SaldosCuentasPorPagarParameterReturnGeneral();
	
			SaldosCuentasPorPagarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldoscuentasporpagars,saldoscuentasporpagarParameterGeneral,saldoscuentasporpagarReturnGeneral);
			
			this.connexion.commit();
			
			return saldoscuentasporpagarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	
	public static String SCHEMA="NINGUNO";	
	public static String TABLENAME="saldos_cuentas_por_pagar";
	
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+"(version_row,codigo,nombre_completo,debito_mone_local,credito_mone_local,saldo_anterior,saldo_debito,saldo_credito)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre_completo=?,debito_mone_local=?,credito_mone_local=?,saldo_anterior=?,saldo_debito=?,saldo_credito=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select saldoscuentasporpagar from "+SaldosCuentasPorPagarConstantesFunciones.SPERSISTENCENAME+" saldoscuentasporpagar";
	public static String QUERYSELECTNATIVE="select "+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".id,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".version_row,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".codigo,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".nombre_completo,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".debito_mone_local,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".credito_mone_local,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".saldo_anterior,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".saldo_debito,"+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME+".saldo_credito from "+SaldosCuentasPorPagarConstantesFunciones.SCHEMA+"."+SaldosCuentasPorPagarConstantesFunciones.TABLENAME;//+" as "+SaldosCuentasPorPagarConstantesFunciones.TABLENAME;
	
	public void saveSaldosCuentasPorPagarWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToSave(saldoscuentasporpagar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SaldosCuentasPorPagarLogicAdditional.updateSaldosCuentasPorPagarToSave(saldoscuentasporpagar,this.arrDatoGeneral);
			
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),saldoscuentasporpagar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSaldosCuentasPorPagar();
			
			
			SaldosCuentasPorPagarLogic.save(saldoscuentasporpagar, connexion);	    	       	 
			
			SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToSaveAfter(saldoscuentasporpagar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSaldosCuentasPorPagar();
			
			connexion.commit();			
			
			if(saldoscuentasporpagar.getIsDeleted()) {
				saldoscuentasporpagar=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSaldosCuentasPorPagar()throws Exception {	
		try {	
			
			SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToSave(saldoscuentasporpagar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SaldosCuentasPorPagarLogicAdditional.updateSaldosCuentasPorPagarToSave(saldoscuentasporpagar,this.arrDatoGeneral);
			
			//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),saldoscuentasporpagar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			SaldosCuentasPorPagarLogic.save(saldoscuentasporpagar, connexion);	    	       	 			
			
			SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToSaveAfter(saldoscuentasporpagar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(saldoscuentasporpagar.getIsDeleted()) {
				saldoscuentasporpagar=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSaldosCuentasPorPagarsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToSaves(saldoscuentasporpagars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSaldosCuentasPorPagars();
			
	   		for(SaldosCuentasPorPagar saldoscuentasporpagarLocal:saldoscuentasporpagars) {				
				SaldosCuentasPorPagarLogicAdditional.updateSaldosCuentasPorPagarToSave(saldoscuentasporpagarLocal,this.arrDatoGeneral);
	        	
				//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),saldoscuentasporpagarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
			
				SaldosCuentasPorPagarLogic.save(saldoscuentasporpagarLocal, connexion);				
			}
			
			SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToSavesAfter(saldoscuentasporpagars,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSaldosCuentasPorPagars();
			
			connexion.commit();		
			
			this.quitarSaldosCuentasPorPagarsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSaldosCuentasPorPagars()throws Exception {				
		 try {	
			SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToSaves(saldoscuentasporpagars,this.datosCliente,connexion,this.arrDatoGeneral);
			
	   		for(SaldosCuentasPorPagar saldoscuentasporpagarLocal:saldoscuentasporpagars) {				
				SaldosCuentasPorPagarLogicAdditional.updateSaldosCuentasPorPagarToSave(saldoscuentasporpagarLocal,this.arrDatoGeneral);
	        	
				//SaldosCuentasPorPagarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),saldoscuentasporpagarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				SaldosCuentasPorPagarLogic.save(saldoscuentasporpagarLocal, connexion);				
			}
			
			SaldosCuentasPorPagarLogicAdditional.checkSaldosCuentasPorPagarToSavesAfter(saldoscuentasporpagars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSaldosCuentasPorPagarsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void getSetVersionRowSaldosCuentasPorPagarWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(saldoscuentasporpagar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((saldoscuentasporpagar.getIsDeleted() || (saldoscuentasporpagar.getIsChanged()&&!saldoscuentasporpagar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				//saldoscuentasporpagarDataAccess
				timestamp=this.getSetVersionRowSaldosCuentasPorPagar(connexion,saldoscuentasporpagar.getId());
				
				if(!saldoscuentasporpagar.getVersionRow().equals(timestamp)) {	
					saldoscuentasporpagar.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				saldoscuentasporpagar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSaldosCuentasPorPagar()throws Exception {	
		
		if(saldoscuentasporpagar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((saldoscuentasporpagar.getIsDeleted() || (saldoscuentasporpagar.getIsChanged()&&!saldoscuentasporpagar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			//saldoscuentasporpagarDataAccess
			Timestamp timestamp=this.getSetVersionRowSaldosCuentasPorPagar(connexion,saldoscuentasporpagar.getId());
			
			try {							
				if(!saldoscuentasporpagar.getVersionRow().equals(timestamp)) {	
					saldoscuentasporpagar.setVersionRow(timestamp);
				}
				
				saldoscuentasporpagar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void quitarSaldosCuentasPorPagarsEliminados() throws Exception {				
		
		List<SaldosCuentasPorPagar> saldoscuentasporpagarsAux= new ArrayList<SaldosCuentasPorPagar>();
		
		for(SaldosCuentasPorPagar saldoscuentasporpagar:saldoscuentasporpagars) {
			if(!saldoscuentasporpagar.getIsDeleted()) {
				saldoscuentasporpagarsAux.add(saldoscuentasporpagar);
			}
		}
		
		saldoscuentasporpagars=saldoscuentasporpagarsAux;
	}
	
	private void getSetVersionRowSaldosCuentasPorPagars()throws Exception {	
		if(saldoscuentasporpagars!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SaldosCuentasPorPagar saldoscuentasporpagarAux:saldoscuentasporpagars) {
					if(saldoscuentasporpagarAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(saldoscuentasporpagarAux.getIsDeleted() || (saldoscuentasporpagarAux.getIsChanged()&&!saldoscuentasporpagarAux.getIsNew())) {
						
						//saldoscuentasporpagarDataAccess
						timestamp=this.getSetVersionRowSaldosCuentasPorPagar(connexion,saldoscuentasporpagarAux.getId());
						
						if(!saldoscuentasporpagarAux.getVersionRow().equals(timestamp)) {	
							saldoscuentasporpagarAux.setVersionRow(timestamp);
						}
						
													
						saldoscuentasporpagarAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public  Timestamp getSetVersionRowSaldosCuentasPorPagar(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
				Query query =connexion.getEntityManager().createQuery ("SELECT version_row FROM "+SaldosCuentasPorPagar.class.getSimpleName()+" WHERE id="+id);
					
				timestampVersionRow=(Timestamp)query.getSingleResult();
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(SaldosCuentasPorPagar entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SaldosCuentasPorPagarLogic.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SaldosCuentasPorPagarLogic.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SaldosCuentasPorPagarLogic.QUERYUPDATE;
				}
				
			} 
			
			sQuerySave=sQuerySave.replace("ninguno.","");
			sQuerySave=sQuerySave.replace("NINGUNO.","");
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SaldosCuentasPorPagarLogic.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SaldosCuentasPorPagarConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SaldosCuentasPorPagarLogic.TABLENAME,SaldosCuentasPorPagarLogic.ISWITHSTOREPROCEDURES);
			
			SaldosCuentasPorPagarLogic.setSaldosCuentasPorPagarOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	public static void setSaldosCuentasPorPagarOriginalStatic(SaldosCuentasPorPagar saldoscuentasporpagar)throws Exception  {
		saldoscuentasporpagar.setSaldosCuentasPorPagarOriginal((SaldosCuentasPorPagar)saldoscuentasporpagar.clone());		
	}
	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,SaldosCuentasPorPagar saldoscuentasporpagar) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!saldoscuentasporpagar.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(saldoscuentasporpagar.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_completo=new ParameterValue<String>();
					parameterMaintenanceValuenombre_completo.setValue(saldoscuentasporpagar.getnombre_completo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_completo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_mone_local.setValue(saldoscuentasporpagar.getdebito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_mone_local.setValue(saldoscuentasporpagar.getcredito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesaldo_anterior=new ParameterValue<Double>();
					parameterMaintenanceValuesaldo_anterior.setValue(saldoscuentasporpagar.getsaldo_anterior());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesaldo_anterior);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesaldo_debito=new ParameterValue<Double>();
					parameterMaintenanceValuesaldo_debito.setValue(saldoscuentasporpagar.getsaldo_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesaldo_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesaldo_credito=new ParameterValue<Double>();
					parameterMaintenanceValuesaldo_credito.setValue(saldoscuentasporpagar.getsaldo_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesaldo_credito);
					parametersTemp.add(parameterMaintenance);
					
						if(!saldoscuentasporpagar.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(saldoscuentasporpagar.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(saldoscuentasporpagar.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(saldoscuentasporpagar.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
}

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
package com.bydan.erp.tesoreria.business.logic.report;

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

import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.resources.general.AuxiliarGeneral;
import com.bydan.erp.tesoreria.util.report.SaldosDiariosBancosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.SaldosDiariosBancosParameterGeneral;
import com.bydan.erp.tesoreria.util.report.SaldosDiariosBancosConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.SaldosDiariosBancos;

import com.bydan.erp.tesoreria.business.logic.report.SaldosDiariosBancosLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class SaldosDiariosBancosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(SaldosDiariosBancosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected SaldosDiariosBancosLogic saldosdiariosbancosDataAccess; 		
	protected SaldosDiariosBancos saldosdiariosbancos;
	protected List<SaldosDiariosBancos> saldosdiariosbancoss;
	protected Object saldosdiariosbancosObject;	
	protected List<Object> saldosdiariosbancossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  SaldosDiariosBancosLogic()throws SQLException,Exception {
		try	{
			this.saldosdiariosbancoss= new ArrayList<SaldosDiariosBancos>();
			this.saldosdiariosbancos= new SaldosDiariosBancos();
			this.saldosdiariosbancosObject=new Object();
			this.saldosdiariosbancossObject=new ArrayList<Object>();
			
			this.saldosdiariosbancosDataAccess=this;
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
			this.saldosdiariosbancosDataAccess.setConnexionType(this.connexionType);
			this.saldosdiariosbancosDataAccess.setParameterDbType(this.parameterDbType);
			this.saldosdiariosbancosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SaldosDiariosBancosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.saldosdiariosbancoss= new ArrayList<SaldosDiariosBancos>();
			this.saldosdiariosbancos= new SaldosDiariosBancos();
			this.saldosdiariosbancosObject=new Object();
			this.saldosdiariosbancossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.saldosdiariosbancosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.saldosdiariosbancosDataAccess.setConnexionType(this.connexionType);
			this.saldosdiariosbancosDataAccess.setParameterDbType(this.parameterDbType);
			this.saldosdiariosbancosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SaldosDiariosBancos getSaldosDiariosBancos() throws Exception {	
		SaldosDiariosBancosLogicAdditional.checkSaldosDiariosBancosToGet(saldosdiariosbancos,this.datosCliente,this.arrDatoGeneral);
		SaldosDiariosBancosLogicAdditional.updateSaldosDiariosBancosToGet(saldosdiariosbancos,this.arrDatoGeneral);
		
		return saldosdiariosbancos;
	}
		
	public void setSaldosDiariosBancos(SaldosDiariosBancos newSaldosDiariosBancos) {
		this.saldosdiariosbancos = newSaldosDiariosBancos;
	}
	
	public List<SaldosDiariosBancos> getSaldosDiariosBancoss() throws Exception {		
		this.quitarSaldosDiariosBancossNulos();
		
		SaldosDiariosBancosLogicAdditional.checkSaldosDiariosBancosToGets(saldosdiariosbancoss,this.datosCliente,this.arrDatoGeneral);
		
		for (SaldosDiariosBancos saldosdiariosbancosLocal: saldosdiariosbancoss ) {
			SaldosDiariosBancosLogicAdditional.updateSaldosDiariosBancosToGet(saldosdiariosbancosLocal,this.arrDatoGeneral);
		}
		
		return saldosdiariosbancoss;
	}
	
	public void setSaldosDiariosBancoss(List<SaldosDiariosBancos> newSaldosDiariosBancoss) {
		this.saldosdiariosbancoss = newSaldosDiariosBancoss;
	}
	
	public Object getSaldosDiariosBancosObject() {	
		//this.saldosdiariosbancosObject=this.saldosdiariosbancosDataAccess.getEntityObject();
		return this.saldosdiariosbancosObject;
	}
		
	public void setSaldosDiariosBancosObject(Object newSaldosDiariosBancosObject) {
		this.saldosdiariosbancosObject = newSaldosDiariosBancosObject;
	}
	
	public List<Object> getSaldosDiariosBancossObject() {		
		//this.saldosdiariosbancossObject=this.saldosdiariosbancosDataAccess.getEntitiesObject();
		return this.saldosdiariosbancossObject;
	}
		
	public void setSaldosDiariosBancossObject(List<Object> newSaldosDiariosBancossObject) {
		this.saldosdiariosbancossObject = newSaldosDiariosBancossObject;
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
		saldosdiariosbancoss = new  ArrayList<SaldosDiariosBancos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosDiariosBancosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosdiariosbancoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		saldosdiariosbancoss = new  ArrayList<SaldosDiariosBancos>();
		  		  
        try {
			//SaldosDiariosBancosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosdiariosbancoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		saldosdiariosbancoss = new  ArrayList<SaldosDiariosBancos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosDiariosBancosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosdiariosbancoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		saldosdiariosbancoss = new  ArrayList<SaldosDiariosBancos>();
		  		  
        try {
			//SaldosDiariosBancosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosdiariosbancoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		saldosdiariosbancoss = new  ArrayList<SaldosDiariosBancos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosDiariosBancosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosdiariosbancoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		saldosdiariosbancoss = new  ArrayList<SaldosDiariosBancos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//SaldosDiariosBancosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosdiariosbancoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<SaldosDiariosBancos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosDiariosBancos> entities = new  ArrayList<SaldosDiariosBancos>();
		SaldosDiariosBancos entity = new SaldosDiariosBancos();		  
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
	
	public  List<SaldosDiariosBancos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosDiariosBancos> entities = new  ArrayList<SaldosDiariosBancos>();
		SaldosDiariosBancos entity = new SaldosDiariosBancos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SaldosDiariosBancos();
				
				
      	    	entity=SaldosDiariosBancosLogic.getEntitySaldosDiariosBancos("",entity,resultSet);
      	    	
				//entity.setSaldosDiariosBancosOriginal( new SaldosDiariosBancos());
      	    	//entity.setSaldosDiariosBancosOriginal(super.getEntity("",entity.getSaldosDiariosBancosOriginal(),resultSet,SaldosDiariosBancosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSaldosDiariosBancosOriginal(SaldosDiariosBancosDataAccess.getEntitySaldosDiariosBancos("",entity.getSaldosDiariosBancosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<SaldosDiariosBancos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosDiariosBancos> entities = new  ArrayList<SaldosDiariosBancos>();
		SaldosDiariosBancos entity = new SaldosDiariosBancos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,SaldosDiariosBancos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SaldosDiariosBancos>((List<SaldosDiariosBancos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSaldosDiariosBancossOriginal(entities);
			
			}  else {
				this.saldosdiariosbancossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SaldosDiariosBancosConstantesFunciones.quitarEspaciosSaldosDiariosBancoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static SaldosDiariosBancos getEntitySaldosDiariosBancos(String strPrefijo,SaldosDiariosBancos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_cuenta(resultSet.getString(strPrefijo+SaldosDiariosBancosConstantesFunciones.CODIGOCUENTA));
			entity.setnombre_banco(resultSet.getString(strPrefijo+SaldosDiariosBancosConstantesFunciones.NOMBREBANCO));
			entity.setnumero_cuenta(resultSet.getString(strPrefijo+SaldosDiariosBancosConstantesFunciones.NUMEROCUENTA));
			entity.setnombre_moneda(resultSet.getString(strPrefijo+SaldosDiariosBancosConstantesFunciones.NOMBREMONEDA));
			entity.setsaldo_anterior(resultSet.getDouble(strPrefijo+SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR));
			entity.setdeposito(resultSet.getDouble(strPrefijo+SaldosDiariosBancosConstantesFunciones.DEPOSITO));
			entity.setnc(resultSet.getDouble(strPrefijo+SaldosDiariosBancosConstantesFunciones.NC));
			entity.setch_girados(resultSet.getDouble(strPrefijo+SaldosDiariosBancosConstantesFunciones.CHGIRADOS));
			entity.setnd(resultSet.getDouble(strPrefijo+SaldosDiariosBancosConstantesFunciones.ND));
			entity.setprocedencia(resultSet.getString(strPrefijo+SaldosDiariosBancosConstantesFunciones.PROCEDENCIA));
			entity.setdestino(resultSet.getString(strPrefijo+SaldosDiariosBancosConstantesFunciones.DESTINO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SaldosDiariosBancos getEntitySaldosDiariosBancos(String strPrefijo,SaldosDiariosBancos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = SaldosDiariosBancos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = SaldosDiariosBancos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				SaldosDiariosBancosLogic.setFieldReflectionSaldosDiariosBancos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSaldosDiariosBancos(Field field,String strPrefijo,String sColumn,SaldosDiariosBancos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SaldosDiariosBancosConstantesFunciones.CODIGOCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.NOMBREBANCO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.NOMBREMONEDA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.DEPOSITO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.NC:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.CHGIRADOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.ND:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.PROCEDENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosDiariosBancosConstantesFunciones.DESTINO:
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
	
	public void quitarSaldosDiariosBancossNulos() throws Exception {				
		
		List<SaldosDiariosBancos> saldosdiariosbancossAux= new ArrayList<SaldosDiariosBancos>();
		
		for(SaldosDiariosBancos saldosdiariosbancos:saldosdiariosbancoss) {
			if(saldosdiariosbancos!=null) {
				saldosdiariosbancossAux.add(saldosdiariosbancos);
			}
		}
		
		saldosdiariosbancoss=saldosdiariosbancossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<SaldosDiariosBancos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosDiariosBancos> entities = new  ArrayList<SaldosDiariosBancos>();
		SaldosDiariosBancos entity = new SaldosDiariosBancos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SaldosDiariosBancos>((List<SaldosDiariosBancos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSaldosDiariosBancossOriginal(entities);
			
			}  else {
				this.saldosdiariosbancossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SaldosDiariosBancosConstantesFunciones.quitarEspaciosSaldosDiariosBancoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		saldosdiariosbancoss = new  ArrayList<SaldosDiariosBancos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosDiariosBancosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosdiariosbancoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		saldosdiariosbancoss = new  ArrayList<SaldosDiariosBancos>();
		  		  
        try {
			//SaldosDiariosBancosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosdiariosbancoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<SaldosDiariosBancos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SaldosDiariosBancos> entities = new  ArrayList<SaldosDiariosBancos>();
		SaldosDiariosBancos entity = new SaldosDiariosBancos();		  
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
	
	public  List<SaldosDiariosBancos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SaldosDiariosBancos> entities = new  ArrayList<SaldosDiariosBancos>();
		SaldosDiariosBancos entity = new SaldosDiariosBancos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SaldosDiariosBancos();
				
				if(conMapGenerico) {
					entity.setMapSaldosDiariosBancos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapSaldosDiariosBancos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SaldosDiariosBancosDataAccess.ISWITHSCHEMA);         		
					entity=SaldosDiariosBancosLogic.getEntitySaldosDiariosBancos("",entity,resultSet,listColumns);
					
					////entity.setSaldosDiariosBancosOriginal( new SaldosDiariosBancos());
					////entity.setSaldosDiariosBancosOriginal(super.getEntity("",entity.getSaldosDiariosBancosOriginal(),resultSet,SaldosDiariosBancosDataAccess.ISWITHSCHEMA));         		
					////entity.setSaldosDiariosBancosOriginal(SaldosDiariosBancosDataAccess.getEntitySaldosDiariosBancos("",entity.getSaldosDiariosBancosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,SaldosDiariosBancos relsaldosdiariosbancos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relsaldosdiariosbancos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,SaldosDiariosBancos relsaldosdiariosbancos)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relsaldosdiariosbancos.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}


	
	
	public void getSaldosDiariosBancossBusquedaSaldosDiariosBancosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//SaldosDiariosBancosLogic saldosdiariosbancosLogic=new SaldosDiariosBancosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SaldosDiariosBancosLogic.GetSelecSqlSaldosDiariosBancos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.saldosdiariosbancoss=this.getSaldosDiariosBancoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getSaldosDiariosBancossBusquedaSaldosDiariosBancos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//SaldosDiariosBancosLogic saldosdiariosbancosLogic=new SaldosDiariosBancosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SaldosDiariosBancosLogic.GetSelecSqlSaldosDiariosBancos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.saldosdiariosbancoss=this.getSaldosDiariosBancoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlSaldosDiariosBancos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("SaldosDiariosBancos_Postgres.sql");
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

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
					existeWhere=true;
				}

				if(fecha_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_hasta)+"'";
					existeWhere=true;
				}

				if(existeWhere) {
					sSqlWhere=" where "+sSqlWhere;
				}

				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"1",sSqlWhere);
				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"2",sSqlWhere);
				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"3",sSqlWhere);
				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"4",sSqlWhere);
				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"5",sSqlWhere);

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
	
	
	public void deepLoad(SaldosDiariosBancos saldosdiariosbancos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SaldosDiariosBancosLogicAdditional.updateSaldosDiariosBancosToGet(saldosdiariosbancos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldosdiariosbancos.setEmpresa(saldosdiariosbancosDataAccess.getEmpresa(connexion,saldosdiariosbancos));
		saldosdiariosbancos.setEjercicio(saldosdiariosbancosDataAccess.getEjercicio(connexion,saldosdiariosbancos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				saldosdiariosbancos.setEmpresa(saldosdiariosbancosDataAccess.getEmpresa(connexion,saldosdiariosbancos));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				saldosdiariosbancos.setEjercicio(saldosdiariosbancosDataAccess.getEjercicio(connexion,saldosdiariosbancos));
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
			saldosdiariosbancos.setEmpresa(saldosdiariosbancosDataAccess.getEmpresa(connexion,saldosdiariosbancos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosdiariosbancos.setEjercicio(saldosdiariosbancosDataAccess.getEjercicio(connexion,saldosdiariosbancos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldosdiariosbancos.setEmpresa(saldosdiariosbancosDataAccess.getEmpresa(connexion,saldosdiariosbancos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(saldosdiariosbancos.getEmpresa(),isDeep,deepLoadType,clases);
				
		saldosdiariosbancos.setEjercicio(saldosdiariosbancosDataAccess.getEjercicio(connexion,saldosdiariosbancos));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(saldosdiariosbancos.getEjercicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				saldosdiariosbancos.setEmpresa(saldosdiariosbancosDataAccess.getEmpresa(connexion,saldosdiariosbancos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(saldosdiariosbancos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				saldosdiariosbancos.setEjercicio(saldosdiariosbancosDataAccess.getEjercicio(connexion,saldosdiariosbancos));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(saldosdiariosbancos.getEjercicio(),isDeep,deepLoadType,clases);				
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
			saldosdiariosbancos.setEmpresa(saldosdiariosbancosDataAccess.getEmpresa(connexion,saldosdiariosbancos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(saldosdiariosbancos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosdiariosbancos.setEjercicio(saldosdiariosbancosDataAccess.getEjercicio(connexion,saldosdiariosbancos));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(saldosdiariosbancos.getEjercicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(saldosdiariosbancos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldosDiariosBancosConstantesFunciones.refrescarForeignKeysDescripcionesSaldosDiariosBancos(saldosdiariosbancos);
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
			this.deepLoad(this.saldosdiariosbancos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldosDiariosBancosConstantesFunciones.refrescarForeignKeysDescripcionesSaldosDiariosBancos(this.saldosdiariosbancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(saldosdiariosbancoss!=null) {
				for(SaldosDiariosBancos saldosdiariosbancos:saldosdiariosbancoss) {
					this.deepLoad(saldosdiariosbancos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SaldosDiariosBancosConstantesFunciones.refrescarForeignKeysDescripcionesSaldosDiariosBancos(saldosdiariosbancoss);
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
			if(saldosdiariosbancoss!=null) {
				for(SaldosDiariosBancos saldosdiariosbancos:saldosdiariosbancoss) {
					this.deepLoad(saldosdiariosbancos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SaldosDiariosBancosConstantesFunciones.refrescarForeignKeysDescripcionesSaldosDiariosBancos(saldosdiariosbancoss);
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
	
	public SaldosDiariosBancosParameterReturnGeneral procesarAccionSaldosDiariosBancoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldosDiariosBancos> saldosdiariosbancoss,SaldosDiariosBancosParameterReturnGeneral saldosdiariosbancosParameterGeneral)throws Exception {
		 try {	
			SaldosDiariosBancosParameterReturnGeneral saldosdiariosbancosReturnGeneral=new SaldosDiariosBancosParameterReturnGeneral();
	
			SaldosDiariosBancosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldosdiariosbancoss,saldosdiariosbancosParameterGeneral,saldosdiariosbancosReturnGeneral);
			
			return saldosdiariosbancosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SaldosDiariosBancosParameterReturnGeneral procesarAccionSaldosDiariosBancossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldosDiariosBancos> saldosdiariosbancoss,SaldosDiariosBancosParameterReturnGeneral saldosdiariosbancosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SaldosDiariosBancosParameterReturnGeneral saldosdiariosbancosReturnGeneral=new SaldosDiariosBancosParameterReturnGeneral();
	
			SaldosDiariosBancosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldosdiariosbancoss,saldosdiariosbancosParameterGeneral,saldosdiariosbancosReturnGeneral);
			
			this.connexion.commit();
			
			return saldosdiariosbancosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

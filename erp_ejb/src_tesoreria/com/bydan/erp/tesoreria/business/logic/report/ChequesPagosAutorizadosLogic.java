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
import com.bydan.erp.tesoreria.util.report.ChequesPagosAutorizadosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ChequesPagosAutorizadosParameterGeneral;
import com.bydan.erp.tesoreria.util.report.ChequesPagosAutorizadosConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.ChequesPagosAutorizados;

import com.bydan.erp.tesoreria.business.logic.report.ChequesPagosAutorizadosLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ChequesPagosAutorizadosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ChequesPagosAutorizadosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ChequesPagosAutorizadosLogic chequespagosautorizadosDataAccess; 		
	protected ChequesPagosAutorizados chequespagosautorizados;
	protected List<ChequesPagosAutorizados> chequespagosautorizadoss;
	protected Object chequespagosautorizadosObject;	
	protected List<Object> chequespagosautorizadossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ChequesPagosAutorizadosLogic()throws SQLException,Exception {
		try	{
			this.chequespagosautorizadoss= new ArrayList<ChequesPagosAutorizados>();
			this.chequespagosautorizados= new ChequesPagosAutorizados();
			this.chequespagosautorizadosObject=new Object();
			this.chequespagosautorizadossObject=new ArrayList<Object>();
			
			this.chequespagosautorizadosDataAccess=this;
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
			this.chequespagosautorizadosDataAccess.setConnexionType(this.connexionType);
			this.chequespagosautorizadosDataAccess.setParameterDbType(this.parameterDbType);
			this.chequespagosautorizadosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ChequesPagosAutorizadosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.chequespagosautorizadoss= new ArrayList<ChequesPagosAutorizados>();
			this.chequespagosautorizados= new ChequesPagosAutorizados();
			this.chequespagosautorizadosObject=new Object();
			this.chequespagosautorizadossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.chequespagosautorizadosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.chequespagosautorizadosDataAccess.setConnexionType(this.connexionType);
			this.chequespagosautorizadosDataAccess.setParameterDbType(this.parameterDbType);
			this.chequespagosautorizadosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ChequesPagosAutorizados getChequesPagosAutorizados() throws Exception {	
		ChequesPagosAutorizadosLogicAdditional.checkChequesPagosAutorizadosToGet(chequespagosautorizados,this.datosCliente,this.arrDatoGeneral);
		ChequesPagosAutorizadosLogicAdditional.updateChequesPagosAutorizadosToGet(chequespagosautorizados,this.arrDatoGeneral);
		
		return chequespagosautorizados;
	}
		
	public void setChequesPagosAutorizados(ChequesPagosAutorizados newChequesPagosAutorizados) {
		this.chequespagosautorizados = newChequesPagosAutorizados;
	}
	
	public List<ChequesPagosAutorizados> getChequesPagosAutorizadoss() throws Exception {		
		this.quitarChequesPagosAutorizadossNulos();
		
		ChequesPagosAutorizadosLogicAdditional.checkChequesPagosAutorizadosToGets(chequespagosautorizadoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ChequesPagosAutorizados chequespagosautorizadosLocal: chequespagosautorizadoss ) {
			ChequesPagosAutorizadosLogicAdditional.updateChequesPagosAutorizadosToGet(chequespagosautorizadosLocal,this.arrDatoGeneral);
		}
		
		return chequespagosautorizadoss;
	}
	
	public void setChequesPagosAutorizadoss(List<ChequesPagosAutorizados> newChequesPagosAutorizadoss) {
		this.chequespagosautorizadoss = newChequesPagosAutorizadoss;
	}
	
	public Object getChequesPagosAutorizadosObject() {	
		//this.chequespagosautorizadosObject=this.chequespagosautorizadosDataAccess.getEntityObject();
		return this.chequespagosautorizadosObject;
	}
		
	public void setChequesPagosAutorizadosObject(Object newChequesPagosAutorizadosObject) {
		this.chequespagosautorizadosObject = newChequesPagosAutorizadosObject;
	}
	
	public List<Object> getChequesPagosAutorizadossObject() {		
		//this.chequespagosautorizadossObject=this.chequespagosautorizadosDataAccess.getEntitiesObject();
		return this.chequespagosautorizadossObject;
	}
		
	public void setChequesPagosAutorizadossObject(List<Object> newChequesPagosAutorizadossObject) {
		this.chequespagosautorizadossObject = newChequesPagosAutorizadossObject;
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
		chequespagosautorizadoss = new  ArrayList<ChequesPagosAutorizados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ChequesPagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequespagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		chequespagosautorizadoss = new  ArrayList<ChequesPagosAutorizados>();
		  		  
        try {
			//ChequesPagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequespagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		chequespagosautorizadoss = new  ArrayList<ChequesPagosAutorizados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ChequesPagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequespagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		chequespagosautorizadoss = new  ArrayList<ChequesPagosAutorizados>();
		  		  
        try {
			//ChequesPagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequespagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		chequespagosautorizadoss = new  ArrayList<ChequesPagosAutorizados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ChequesPagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequespagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		chequespagosautorizadoss = new  ArrayList<ChequesPagosAutorizados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ChequesPagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequespagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ChequesPagosAutorizados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ChequesPagosAutorizados> entities = new  ArrayList<ChequesPagosAutorizados>();
		ChequesPagosAutorizados entity = new ChequesPagosAutorizados();		  
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
	
	public  List<ChequesPagosAutorizados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ChequesPagosAutorizados> entities = new  ArrayList<ChequesPagosAutorizados>();
		ChequesPagosAutorizados entity = new ChequesPagosAutorizados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ChequesPagosAutorizados();
				
				
      	    	entity=ChequesPagosAutorizadosLogic.getEntityChequesPagosAutorizados("",entity,resultSet);
      	    	
				//entity.setChequesPagosAutorizadosOriginal( new ChequesPagosAutorizados());
      	    	//entity.setChequesPagosAutorizadosOriginal(super.getEntity("",entity.getChequesPagosAutorizadosOriginal(),resultSet,ChequesPagosAutorizadosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setChequesPagosAutorizadosOriginal(ChequesPagosAutorizadosDataAccess.getEntityChequesPagosAutorizados("",entity.getChequesPagosAutorizadosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ChequesPagosAutorizados> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ChequesPagosAutorizados> entities = new  ArrayList<ChequesPagosAutorizados>();
		ChequesPagosAutorizados entity = new ChequesPagosAutorizados();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ChequesPagosAutorizados.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ChequesPagosAutorizados>((List<ChequesPagosAutorizados>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setChequesPagosAutorizadossOriginal(entities);
			
			}  else {
				this.chequespagosautorizadossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ChequesPagosAutorizadosConstantesFunciones.quitarEspaciosChequesPagosAutorizadoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ChequesPagosAutorizados getEntityChequesPagosAutorizados(String strPrefijo,ChequesPagosAutorizados entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_cliente(resultSet.getString(strPrefijo+ChequesPagosAutorizadosConstantesFunciones.NOMBRECLIENTE));
			entity.setnumero_factura(resultSet.getString(strPrefijo+ChequesPagosAutorizadosConstantesFunciones.NUMEROFACTURA));
			entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ChequesPagosAutorizadosConstantesFunciones.FECHA).getTime()));
			entity.setnombre_banco(resultSet.getString(strPrefijo+ChequesPagosAutorizadosConstantesFunciones.NOMBREBANCO));
			entity.setvalor(resultSet.getDouble(strPrefijo+ChequesPagosAutorizadosConstantesFunciones.VALOR));
			entity.setnumero_cheque(resultSet.getString(strPrefijo+ChequesPagosAutorizadosConstantesFunciones.NUMEROCHEQUE));
			entity.setnumero_cuenta(resultSet.getString(strPrefijo+ChequesPagosAutorizadosConstantesFunciones.NUMEROCUENTA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ChequesPagosAutorizados getEntityChequesPagosAutorizados(String strPrefijo,ChequesPagosAutorizados entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ChequesPagosAutorizados.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ChequesPagosAutorizados.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ChequesPagosAutorizadosLogic.setFieldReflectionChequesPagosAutorizados(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionChequesPagosAutorizados(Field field,String strPrefijo,String sColumn,ChequesPagosAutorizados entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ChequesPagosAutorizadosConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ChequesPagosAutorizadosConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ChequesPagosAutorizadosConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ChequesPagosAutorizadosConstantesFunciones.NOMBREBANCO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ChequesPagosAutorizadosConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ChequesPagosAutorizadosConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ChequesPagosAutorizadosConstantesFunciones.NUMEROCUENTA:
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
	
	public void quitarChequesPagosAutorizadossNulos() throws Exception {				
		
		List<ChequesPagosAutorizados> chequespagosautorizadossAux= new ArrayList<ChequesPagosAutorizados>();
		
		for(ChequesPagosAutorizados chequespagosautorizados:chequespagosautorizadoss) {
			if(chequespagosautorizados!=null) {
				chequespagosautorizadossAux.add(chequespagosautorizados);
			}
		}
		
		chequespagosautorizadoss=chequespagosautorizadossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ChequesPagosAutorizados> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ChequesPagosAutorizados> entities = new  ArrayList<ChequesPagosAutorizados>();
		ChequesPagosAutorizados entity = new ChequesPagosAutorizados();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ChequesPagosAutorizados>((List<ChequesPagosAutorizados>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setChequesPagosAutorizadossOriginal(entities);
			
			}  else {
				this.chequespagosautorizadossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ChequesPagosAutorizadosConstantesFunciones.quitarEspaciosChequesPagosAutorizadoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		chequespagosautorizadoss = new  ArrayList<ChequesPagosAutorizados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ChequesPagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequespagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		chequespagosautorizadoss = new  ArrayList<ChequesPagosAutorizados>();
		  		  
        try {
			//ChequesPagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequespagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ChequesPagosAutorizados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ChequesPagosAutorizados> entities = new  ArrayList<ChequesPagosAutorizados>();
		ChequesPagosAutorizados entity = new ChequesPagosAutorizados();		  
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
	
	public  List<ChequesPagosAutorizados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ChequesPagosAutorizados> entities = new  ArrayList<ChequesPagosAutorizados>();
		ChequesPagosAutorizados entity = new ChequesPagosAutorizados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ChequesPagosAutorizados();
				
				if(conMapGenerico) {
					entity.setMapChequesPagosAutorizados( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapChequesPagosAutorizados().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ChequesPagosAutorizadosDataAccess.ISWITHSCHEMA);         		
					entity=ChequesPagosAutorizadosLogic.getEntityChequesPagosAutorizados("",entity,resultSet,listColumns);
					
					////entity.setChequesPagosAutorizadosOriginal( new ChequesPagosAutorizados());
					////entity.setChequesPagosAutorizadosOriginal(super.getEntity("",entity.getChequesPagosAutorizadosOriginal(),resultSet,ChequesPagosAutorizadosDataAccess.ISWITHSCHEMA));         		
					////entity.setChequesPagosAutorizadosOriginal(ChequesPagosAutorizadosDataAccess.getEntityChequesPagosAutorizados("",entity.getChequesPagosAutorizadosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ChequesPagosAutorizados relchequespagosautorizados)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relchequespagosautorizados.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getChequesPagosAutorizadossBusquedaChequesPagosAutorizadosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//ChequesPagosAutorizadosLogic chequespagosautorizadosLogic=new ChequesPagosAutorizadosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ChequesPagosAutorizadosLogic.GetSelecSqlChequesPagosAutorizados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.chequespagosautorizadoss=this.getChequesPagosAutorizadoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getChequesPagosAutorizadossBusquedaChequesPagosAutorizados(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//ChequesPagosAutorizadosLogic chequespagosautorizadosLogic=new ChequesPagosAutorizadosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ChequesPagosAutorizadosLogic.GetSelecSqlChequesPagosAutorizados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.chequespagosautorizadoss=this.getChequesPagosAutorizadoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlChequesPagosAutorizados(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ChequesPagosAutorizados_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" dch.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" dch.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" dch.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
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
	
	
	public void deepLoad(ChequesPagosAutorizados chequespagosautorizados,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ChequesPagosAutorizadosLogicAdditional.updateChequesPagosAutorizadosToGet(chequespagosautorizados,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		chequespagosautorizados.setEmpresa(chequespagosautorizadosDataAccess.getEmpresa(connexion,chequespagosautorizados));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				chequespagosautorizados.setEmpresa(chequespagosautorizadosDataAccess.getEmpresa(connexion,chequespagosautorizados));
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
			chequespagosautorizados.setEmpresa(chequespagosautorizadosDataAccess.getEmpresa(connexion,chequespagosautorizados));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		chequespagosautorizados.setEmpresa(chequespagosautorizadosDataAccess.getEmpresa(connexion,chequespagosautorizados));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(chequespagosautorizados.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				chequespagosautorizados.setEmpresa(chequespagosautorizadosDataAccess.getEmpresa(connexion,chequespagosautorizados));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(chequespagosautorizados.getEmpresa(),isDeep,deepLoadType,clases);				
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
			chequespagosautorizados.setEmpresa(chequespagosautorizadosDataAccess.getEmpresa(connexion,chequespagosautorizados));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(chequespagosautorizados.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(chequespagosautorizados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ChequesPagosAutorizadosConstantesFunciones.refrescarForeignKeysDescripcionesChequesPagosAutorizados(chequespagosautorizados);
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
			this.deepLoad(this.chequespagosautorizados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ChequesPagosAutorizadosConstantesFunciones.refrescarForeignKeysDescripcionesChequesPagosAutorizados(this.chequespagosautorizados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(chequespagosautorizadoss!=null) {
				for(ChequesPagosAutorizados chequespagosautorizados:chequespagosautorizadoss) {
					this.deepLoad(chequespagosautorizados,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ChequesPagosAutorizadosConstantesFunciones.refrescarForeignKeysDescripcionesChequesPagosAutorizados(chequespagosautorizadoss);
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
			if(chequespagosautorizadoss!=null) {
				for(ChequesPagosAutorizados chequespagosautorizados:chequespagosautorizadoss) {
					this.deepLoad(chequespagosautorizados,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ChequesPagosAutorizadosConstantesFunciones.refrescarForeignKeysDescripcionesChequesPagosAutorizados(chequespagosautorizadoss);
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
	
	public ChequesPagosAutorizadosParameterReturnGeneral procesarAccionChequesPagosAutorizadoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ChequesPagosAutorizados> chequespagosautorizadoss,ChequesPagosAutorizadosParameterReturnGeneral chequespagosautorizadosParameterGeneral)throws Exception {
		 try {	
			ChequesPagosAutorizadosParameterReturnGeneral chequespagosautorizadosReturnGeneral=new ChequesPagosAutorizadosParameterReturnGeneral();
	
			ChequesPagosAutorizadosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,chequespagosautorizadoss,chequespagosautorizadosParameterGeneral,chequespagosautorizadosReturnGeneral);
			
			return chequespagosautorizadosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ChequesPagosAutorizadosParameterReturnGeneral procesarAccionChequesPagosAutorizadossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ChequesPagosAutorizados> chequespagosautorizadoss,ChequesPagosAutorizadosParameterReturnGeneral chequespagosautorizadosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ChequesPagosAutorizadosParameterReturnGeneral chequespagosautorizadosReturnGeneral=new ChequesPagosAutorizadosParameterReturnGeneral();
	
			ChequesPagosAutorizadosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,chequespagosautorizadoss,chequespagosautorizadosParameterGeneral,chequespagosautorizadosReturnGeneral);
			
			this.connexion.commit();
			
			return chequespagosautorizadosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

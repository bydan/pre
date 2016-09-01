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
import com.bydan.erp.nomina.util.report.CreditosDetalladosParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.CreditosDetalladosParameterGeneral;
import com.bydan.erp.nomina.util.report.CreditosDetalladosConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.CreditosDetallados;

import com.bydan.erp.nomina.business.logic.report.CreditosDetalladosLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CreditosDetalladosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CreditosDetalladosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CreditosDetalladosLogic creditosdetalladosDataAccess; 		
	protected CreditosDetallados creditosdetallados;
	protected List<CreditosDetallados> creditosdetalladoss;
	protected Object creditosdetalladosObject;	
	protected List<Object> creditosdetalladossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CreditosDetalladosLogic()throws SQLException,Exception {
		try	{
			this.creditosdetalladoss= new ArrayList<CreditosDetallados>();
			this.creditosdetallados= new CreditosDetallados();
			this.creditosdetalladosObject=new Object();
			this.creditosdetalladossObject=new ArrayList<Object>();
			
			this.creditosdetalladosDataAccess=this;
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
			this.creditosdetalladosDataAccess.setConnexionType(this.connexionType);
			this.creditosdetalladosDataAccess.setParameterDbType(this.parameterDbType);
			this.creditosdetalladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CreditosDetalladosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.creditosdetalladoss= new ArrayList<CreditosDetallados>();
			this.creditosdetallados= new CreditosDetallados();
			this.creditosdetalladosObject=new Object();
			this.creditosdetalladossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.creditosdetalladosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.creditosdetalladosDataAccess.setConnexionType(this.connexionType);
			this.creditosdetalladosDataAccess.setParameterDbType(this.parameterDbType);
			this.creditosdetalladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CreditosDetallados getCreditosDetallados() throws Exception {	
		CreditosDetalladosLogicAdditional.checkCreditosDetalladosToGet(creditosdetallados,this.datosCliente,this.arrDatoGeneral);
		CreditosDetalladosLogicAdditional.updateCreditosDetalladosToGet(creditosdetallados,this.arrDatoGeneral);
		
		return creditosdetallados;
	}
		
	public void setCreditosDetallados(CreditosDetallados newCreditosDetallados) {
		this.creditosdetallados = newCreditosDetallados;
	}
	
	public List<CreditosDetallados> getCreditosDetalladoss() throws Exception {		
		this.quitarCreditosDetalladossNulos();
		
		CreditosDetalladosLogicAdditional.checkCreditosDetalladosToGets(creditosdetalladoss,this.datosCliente,this.arrDatoGeneral);
		
		for (CreditosDetallados creditosdetalladosLocal: creditosdetalladoss ) {
			CreditosDetalladosLogicAdditional.updateCreditosDetalladosToGet(creditosdetalladosLocal,this.arrDatoGeneral);
		}
		
		return creditosdetalladoss;
	}
	
	public void setCreditosDetalladoss(List<CreditosDetallados> newCreditosDetalladoss) {
		this.creditosdetalladoss = newCreditosDetalladoss;
	}
	
	public Object getCreditosDetalladosObject() {	
		//this.creditosdetalladosObject=this.creditosdetalladosDataAccess.getEntityObject();
		return this.creditosdetalladosObject;
	}
		
	public void setCreditosDetalladosObject(Object newCreditosDetalladosObject) {
		this.creditosdetalladosObject = newCreditosDetalladosObject;
	}
	
	public List<Object> getCreditosDetalladossObject() {		
		//this.creditosdetalladossObject=this.creditosdetalladosDataAccess.getEntitiesObject();
		return this.creditosdetalladossObject;
	}
		
	public void setCreditosDetalladossObject(List<Object> newCreditosDetalladossObject) {
		this.creditosdetalladossObject = newCreditosDetalladossObject;
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
		creditosdetalladoss = new  ArrayList<CreditosDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CreditosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		creditosdetalladoss = new  ArrayList<CreditosDetallados>();
		  		  
        try {
			//CreditosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		creditosdetalladoss = new  ArrayList<CreditosDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CreditosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		creditosdetalladoss = new  ArrayList<CreditosDetallados>();
		  		  
        try {
			//CreditosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		creditosdetalladoss = new  ArrayList<CreditosDetallados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CreditosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		creditosdetalladoss = new  ArrayList<CreditosDetallados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CreditosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CreditosDetallados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CreditosDetallados> entities = new  ArrayList<CreditosDetallados>();
		CreditosDetallados entity = new CreditosDetallados();		  
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
	
	public  List<CreditosDetallados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CreditosDetallados> entities = new  ArrayList<CreditosDetallados>();
		CreditosDetallados entity = new CreditosDetallados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CreditosDetallados();
				
				
      	    	entity=CreditosDetalladosLogic.getEntityCreditosDetallados("",entity,resultSet);
      	    	
				//entity.setCreditosDetalladosOriginal( new CreditosDetallados());
      	    	//entity.setCreditosDetalladosOriginal(super.getEntity("",entity.getCreditosDetalladosOriginal(),resultSet,CreditosDetalladosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCreditosDetalladosOriginal(CreditosDetalladosDataAccess.getEntityCreditosDetallados("",entity.getCreditosDetalladosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CreditosDetallados> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CreditosDetallados> entities = new  ArrayList<CreditosDetallados>();
		CreditosDetallados entity = new CreditosDetallados();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CreditosDetallados.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CreditosDetallados>((List<CreditosDetallados>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCreditosDetalladossOriginal(entities);
			
			}  else {
				this.creditosdetalladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CreditosDetalladosConstantesFunciones.quitarEspaciosCreditosDetalladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CreditosDetallados getEntityCreditosDetallados(String strPrefijo,CreditosDetallados entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+CreditosDetalladosConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+CreditosDetalladosConstantesFunciones.NOMBRECOMPLETO));
			entity.setcodigo_tipo_prestamo(resultSet.getString(strPrefijo+CreditosDetalladosConstantesFunciones.CODIGOTIPOPRESTAMO));
			entity.setcodigo_prestamo(resultSet.getString(strPrefijo+CreditosDetalladosConstantesFunciones.CODIGOPRESTAMO));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+CreditosDetalladosConstantesFunciones.FECHA).getTime()));
			entity.setmonto(resultSet.getDouble(strPrefijo+CreditosDetalladosConstantesFunciones.MONTO));
			entity.setnumero_cuotas(resultSet.getInt(strPrefijo+CreditosDetalladosConstantesFunciones.NUMEROCUOTAS));
			entity.setnumero(resultSet.getInt(strPrefijo+CreditosDetalladosConstantesFunciones.NUMERO));
			entity.setmonto_capital(resultSet.getDouble(strPrefijo+CreditosDetalladosConstantesFunciones.MONTOCAPITAL));
			entity.setmonto_interes(resultSet.getDouble(strPrefijo+CreditosDetalladosConstantesFunciones.MONTOINTERES));
			entity.setvalor(resultSet.getDouble(strPrefijo+CreditosDetalladosConstantesFunciones.VALOR));
			entity.setsaldo(resultSet.getDouble(strPrefijo+CreditosDetalladosConstantesFunciones.SALDO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CreditosDetallados getEntityCreditosDetallados(String strPrefijo,CreditosDetallados entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CreditosDetallados.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CreditosDetallados.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CreditosDetalladosLogic.setFieldReflectionCreditosDetallados(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCreditosDetallados(Field field,String strPrefijo,String sColumn,CreditosDetallados entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CreditosDetalladosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.CODIGOTIPOPRESTAMO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.CODIGOPRESTAMO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CreditosDetalladosConstantesFunciones.MONTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.NUMEROCUOTAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.MONTOCAPITAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.MONTOINTERES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CreditosDetalladosConstantesFunciones.SALDO:
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
	
	public void quitarCreditosDetalladossNulos() throws Exception {				
		
		List<CreditosDetallados> creditosdetalladossAux= new ArrayList<CreditosDetallados>();
		
		for(CreditosDetallados creditosdetallados:creditosdetalladoss) {
			if(creditosdetallados!=null) {
				creditosdetalladossAux.add(creditosdetallados);
			}
		}
		
		creditosdetalladoss=creditosdetalladossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CreditosDetallados> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CreditosDetallados> entities = new  ArrayList<CreditosDetallados>();
		CreditosDetallados entity = new CreditosDetallados();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CreditosDetallados>((List<CreditosDetallados>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCreditosDetalladossOriginal(entities);
			
			}  else {
				this.creditosdetalladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CreditosDetalladosConstantesFunciones.quitarEspaciosCreditosDetalladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		creditosdetalladoss = new  ArrayList<CreditosDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CreditosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		creditosdetalladoss = new  ArrayList<CreditosDetallados>();
		  		  
        try {
			//CreditosDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditosdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CreditosDetallados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CreditosDetallados> entities = new  ArrayList<CreditosDetallados>();
		CreditosDetallados entity = new CreditosDetallados();		  
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
	
	public  List<CreditosDetallados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CreditosDetallados> entities = new  ArrayList<CreditosDetallados>();
		CreditosDetallados entity = new CreditosDetallados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CreditosDetallados();
				
				if(conMapGenerico) {
					entity.setMapCreditosDetallados( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCreditosDetallados().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CreditosDetalladosDataAccess.ISWITHSCHEMA);         		
					entity=CreditosDetalladosLogic.getEntityCreditosDetallados("",entity,resultSet,listColumns);
					
					////entity.setCreditosDetalladosOriginal( new CreditosDetallados());
					////entity.setCreditosDetalladosOriginal(super.getEntity("",entity.getCreditosDetalladosOriginal(),resultSet,CreditosDetalladosDataAccess.ISWITHSCHEMA));         		
					////entity.setCreditosDetalladosOriginal(CreditosDetalladosDataAccess.getEntityCreditosDetallados("",entity.getCreditosDetalladosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Cargo getCargo(Connexion connexion,CreditosDetallados relcreditosdetallados)throws SQLException,Exception {

		Cargo cargo= new Cargo();

		try {
			CargoDataAccess cargoDataAccess=new CargoDataAccess();

			cargoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cargoDataAccess.setConnexionType(this.connexionType);
			cargoDataAccess.setParameterDbType(this.parameterDbType);
			cargoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cargo=cargoDataAccess.getEntity(connexion,relcreditosdetallados.getid_cargo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargo;

	}

	public Estructura getEstructura(Connexion connexion,CreditosDetallados relcreditosdetallados)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			estructura=estructuraDataAccess.getEntity(connexion,relcreditosdetallados.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empresa getEmpresa(Connexion connexion,CreditosDetallados relcreditosdetallados)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcreditosdetallados.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,CreditosDetallados relcreditosdetallados)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);
			empleadoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empleado=empleadoDataAccess.getEntity(connexion,relcreditosdetallados.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoPrestamo getTipoPrestamo(Connexion connexion,CreditosDetallados relcreditosdetallados)throws SQLException,Exception {

		TipoPrestamo tipoprestamo= new TipoPrestamo();

		try {
			TipoPrestamoDataAccess tipoprestamoDataAccess=new TipoPrestamoDataAccess();

			tipoprestamoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprestamoDataAccess.setConnexionType(this.connexionType);
			tipoprestamoDataAccess.setParameterDbType(this.parameterDbType);
			tipoprestamoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoprestamo=tipoprestamoDataAccess.getEntity(connexion,relcreditosdetallados.getid_tipo_prestamo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprestamo;

	}


	
	
	public void getCreditosDetalladossBusquedaCreditosDetalladosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cargo,Long id_estructura,Long id_empleado,Long id_tipo_prestamo,Date fecha_vencimiento_desde,Date fecha_vencimiento_hasta)throws Exception {
		try {
			//CreditosDetalladosLogic creditosdetalladosLogic=new CreditosDetalladosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CreditosDetalladosLogic.GetSelecSqlCreditosDetallados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cargo,id_estructura,id_empleado,id_tipo_prestamo,fecha_vencimiento_desde,fecha_vencimiento_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.creditosdetalladoss=this.getCreditosDetalladoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCreditosDetalladossBusquedaCreditosDetallados(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cargo,Long id_estructura,Long id_empleado,Long id_tipo_prestamo,Date fecha_vencimiento_desde,Date fecha_vencimiento_hasta)throws Exception {
		try {
			//CreditosDetalladosLogic creditosdetalladosLogic=new CreditosDetalladosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CreditosDetalladosLogic.GetSelecSqlCreditosDetallados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cargo,id_estructura,id_empleado,id_tipo_prestamo,fecha_vencimiento_desde,fecha_vencimiento_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.creditosdetalladoss=this.getCreditosDetalladoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCreditosDetallados(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cargo,Long id_estructura,Long id_empleado,Long id_tipo_prestamo,Date fecha_vencimiento_desde,Date fecha_vencimiento_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CreditosDetallados_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" e.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" e.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_cargo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.id_cargo = "+id_cargo.toString();
					existeWhere=true;
				}

				if(id_estructura!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.id_estructura = "+id_estructura.toString();
					existeWhere=true;
				}

				if(id_empleado!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_empleado = "+id_empleado.toString();
					existeWhere=true;
				}

				if(id_tipo_prestamo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_tipo_prestamo = "+id_tipo_prestamo.toString();
					existeWhere=true;
				}

				if(fecha_vencimiento_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.fecha_vencimiento between "+"'"+Funciones2.getStringPostgresDate(fecha_vencimiento_desde)+"'";
					existeWhere=true;
				}

				if(fecha_vencimiento_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_vencimiento_hasta)+"'";
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
	
	
	public void deepLoad(CreditosDetallados creditosdetallados,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CreditosDetalladosLogicAdditional.updateCreditosDetalladosToGet(creditosdetallados,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		creditosdetallados.setCargo(creditosdetalladosDataAccess.getCargo(connexion,creditosdetallados));
		creditosdetallados.setEstructura(creditosdetalladosDataAccess.getEstructura(connexion,creditosdetallados));
		creditosdetallados.setEmpresa(creditosdetalladosDataAccess.getEmpresa(connexion,creditosdetallados));
		creditosdetallados.setEmpleado(creditosdetalladosDataAccess.getEmpleado(connexion,creditosdetallados));
		creditosdetallados.setTipoPrestamo(creditosdetalladosDataAccess.getTipoPrestamo(connexion,creditosdetallados));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				creditosdetallados.setCargo(creditosdetalladosDataAccess.getCargo(connexion,creditosdetallados));
			}

			if(clas.clas.equals(Estructura.class)) {
				creditosdetallados.setEstructura(creditosdetalladosDataAccess.getEstructura(connexion,creditosdetallados));
			}

			if(clas.clas.equals(Empresa.class)) {
				creditosdetallados.setEmpresa(creditosdetalladosDataAccess.getEmpresa(connexion,creditosdetallados));
			}

			if(clas.clas.equals(Empleado.class)) {
				creditosdetallados.setEmpleado(creditosdetalladosDataAccess.getEmpleado(connexion,creditosdetallados));
			}

			if(clas.clas.equals(TipoPrestamo.class)) {
				creditosdetallados.setTipoPrestamo(creditosdetalladosDataAccess.getTipoPrestamo(connexion,creditosdetallados));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setCargo(creditosdetalladosDataAccess.getCargo(connexion,creditosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setEstructura(creditosdetalladosDataAccess.getEstructura(connexion,creditosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setEmpresa(creditosdetalladosDataAccess.getEmpresa(connexion,creditosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setEmpleado(creditosdetalladosDataAccess.getEmpleado(connexion,creditosdetallados));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrestamo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setTipoPrestamo(creditosdetalladosDataAccess.getTipoPrestamo(connexion,creditosdetallados));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		creditosdetallados.setCargo(creditosdetalladosDataAccess.getCargo(connexion,creditosdetallados));
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(creditosdetallados.getCargo(),isDeep,deepLoadType,clases);
				
		creditosdetallados.setEstructura(creditosdetalladosDataAccess.getEstructura(connexion,creditosdetallados));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(creditosdetallados.getEstructura(),isDeep,deepLoadType,clases);
				
		creditosdetallados.setEmpresa(creditosdetalladosDataAccess.getEmpresa(connexion,creditosdetallados));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(creditosdetallados.getEmpresa(),isDeep,deepLoadType,clases);
				
		creditosdetallados.setEmpleado(creditosdetalladosDataAccess.getEmpleado(connexion,creditosdetallados));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(creditosdetallados.getEmpleado(),isDeep,deepLoadType,clases);
				
		creditosdetallados.setTipoPrestamo(creditosdetalladosDataAccess.getTipoPrestamo(connexion,creditosdetallados));
		TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
		tipoprestamoLogic.deepLoad(creditosdetallados.getTipoPrestamo(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				creditosdetallados.setCargo(creditosdetalladosDataAccess.getCargo(connexion,creditosdetallados));
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepLoad(creditosdetallados.getCargo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Estructura.class)) {
				creditosdetallados.setEstructura(creditosdetalladosDataAccess.getEstructura(connexion,creditosdetallados));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(creditosdetallados.getEstructura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				creditosdetallados.setEmpresa(creditosdetalladosDataAccess.getEmpresa(connexion,creditosdetallados));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(creditosdetallados.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empleado.class)) {
				creditosdetallados.setEmpleado(creditosdetalladosDataAccess.getEmpleado(connexion,creditosdetallados));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(creditosdetallados.getEmpleado(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoPrestamo.class)) {
				creditosdetallados.setTipoPrestamo(creditosdetalladosDataAccess.getTipoPrestamo(connexion,creditosdetallados));
				TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
				tipoprestamoLogic.deepLoad(creditosdetallados.getTipoPrestamo(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setCargo(creditosdetalladosDataAccess.getCargo(connexion,creditosdetallados));
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargoLogic.deepLoad(creditosdetallados.getCargo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setEstructura(creditosdetalladosDataAccess.getEstructura(connexion,creditosdetallados));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(creditosdetallados.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setEmpresa(creditosdetalladosDataAccess.getEmpresa(connexion,creditosdetallados));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(creditosdetallados.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setEmpleado(creditosdetalladosDataAccess.getEmpleado(connexion,creditosdetallados));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(creditosdetallados.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrestamo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditosdetallados.setTipoPrestamo(creditosdetalladosDataAccess.getTipoPrestamo(connexion,creditosdetallados));
			TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
			tipoprestamoLogic.deepLoad(creditosdetallados.getTipoPrestamo(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(creditosdetallados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CreditosDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCreditosDetallados(creditosdetallados);
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
			this.deepLoad(this.creditosdetallados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CreditosDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCreditosDetallados(this.creditosdetallados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(creditosdetalladoss!=null) {
				for(CreditosDetallados creditosdetallados:creditosdetalladoss) {
					this.deepLoad(creditosdetallados,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CreditosDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCreditosDetallados(creditosdetalladoss);
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
			if(creditosdetalladoss!=null) {
				for(CreditosDetallados creditosdetallados:creditosdetalladoss) {
					this.deepLoad(creditosdetallados,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CreditosDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCreditosDetallados(creditosdetalladoss);
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
	
	public CreditosDetalladosParameterReturnGeneral procesarAccionCreditosDetalladoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CreditosDetallados> creditosdetalladoss,CreditosDetalladosParameterReturnGeneral creditosdetalladosParameterGeneral)throws Exception {
		 try {	
			CreditosDetalladosParameterReturnGeneral creditosdetalladosReturnGeneral=new CreditosDetalladosParameterReturnGeneral();
	
			CreditosDetalladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,creditosdetalladoss,creditosdetalladosParameterGeneral,creditosdetalladosReturnGeneral);
			
			return creditosdetalladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CreditosDetalladosParameterReturnGeneral procesarAccionCreditosDetalladossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CreditosDetallados> creditosdetalladoss,CreditosDetalladosParameterReturnGeneral creditosdetalladosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CreditosDetalladosParameterReturnGeneral creditosdetalladosReturnGeneral=new CreditosDetalladosParameterReturnGeneral();
	
			CreditosDetalladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,creditosdetalladoss,creditosdetalladosParameterGeneral,creditosdetalladosReturnGeneral);
			
			this.connexion.commit();
			
			return creditosdetalladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

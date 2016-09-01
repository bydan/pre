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
import com.bydan.erp.tesoreria.util.report.HistorialConciliacionesBancariasParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.HistorialConciliacionesBancariasParameterGeneral;
import com.bydan.erp.tesoreria.util.report.HistorialConciliacionesBancariasConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.HistorialConciliacionesBancarias;

import com.bydan.erp.tesoreria.business.logic.report.HistorialConciliacionesBancariasLogicAdditional;
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
public class HistorialConciliacionesBancariasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(HistorialConciliacionesBancariasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected HistorialConciliacionesBancariasLogic historialconciliacionesbancariasDataAccess; 		
	protected HistorialConciliacionesBancarias historialconciliacionesbancarias;
	protected List<HistorialConciliacionesBancarias> historialconciliacionesbancariass;
	protected Object historialconciliacionesbancariasObject;	
	protected List<Object> historialconciliacionesbancariassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  HistorialConciliacionesBancariasLogic()throws SQLException,Exception {
		try	{
			this.historialconciliacionesbancariass= new ArrayList<HistorialConciliacionesBancarias>();
			this.historialconciliacionesbancarias= new HistorialConciliacionesBancarias();
			this.historialconciliacionesbancariasObject=new Object();
			this.historialconciliacionesbancariassObject=new ArrayList<Object>();
			
			this.historialconciliacionesbancariasDataAccess=this;
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
			this.historialconciliacionesbancariasDataAccess.setConnexionType(this.connexionType);
			this.historialconciliacionesbancariasDataAccess.setParameterDbType(this.parameterDbType);
			this.historialconciliacionesbancariasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  HistorialConciliacionesBancariasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.historialconciliacionesbancariass= new ArrayList<HistorialConciliacionesBancarias>();
			this.historialconciliacionesbancarias= new HistorialConciliacionesBancarias();
			this.historialconciliacionesbancariasObject=new Object();
			this.historialconciliacionesbancariassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.historialconciliacionesbancariasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.historialconciliacionesbancariasDataAccess.setConnexionType(this.connexionType);
			this.historialconciliacionesbancariasDataAccess.setParameterDbType(this.parameterDbType);
			this.historialconciliacionesbancariasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public HistorialConciliacionesBancarias getHistorialConciliacionesBancarias() throws Exception {	
		HistorialConciliacionesBancariasLogicAdditional.checkHistorialConciliacionesBancariasToGet(historialconciliacionesbancarias,this.datosCliente,this.arrDatoGeneral);
		HistorialConciliacionesBancariasLogicAdditional.updateHistorialConciliacionesBancariasToGet(historialconciliacionesbancarias,this.arrDatoGeneral);
		
		return historialconciliacionesbancarias;
	}
		
	public void setHistorialConciliacionesBancarias(HistorialConciliacionesBancarias newHistorialConciliacionesBancarias) {
		this.historialconciliacionesbancarias = newHistorialConciliacionesBancarias;
	}
	
	public List<HistorialConciliacionesBancarias> getHistorialConciliacionesBancariass() throws Exception {		
		this.quitarHistorialConciliacionesBancariassNulos();
		
		HistorialConciliacionesBancariasLogicAdditional.checkHistorialConciliacionesBancariasToGets(historialconciliacionesbancariass,this.datosCliente,this.arrDatoGeneral);
		
		for (HistorialConciliacionesBancarias historialconciliacionesbancariasLocal: historialconciliacionesbancariass ) {
			HistorialConciliacionesBancariasLogicAdditional.updateHistorialConciliacionesBancariasToGet(historialconciliacionesbancariasLocal,this.arrDatoGeneral);
		}
		
		return historialconciliacionesbancariass;
	}
	
	public void setHistorialConciliacionesBancariass(List<HistorialConciliacionesBancarias> newHistorialConciliacionesBancariass) {
		this.historialconciliacionesbancariass = newHistorialConciliacionesBancariass;
	}
	
	public Object getHistorialConciliacionesBancariasObject() {	
		//this.historialconciliacionesbancariasObject=this.historialconciliacionesbancariasDataAccess.getEntityObject();
		return this.historialconciliacionesbancariasObject;
	}
		
	public void setHistorialConciliacionesBancariasObject(Object newHistorialConciliacionesBancariasObject) {
		this.historialconciliacionesbancariasObject = newHistorialConciliacionesBancariasObject;
	}
	
	public List<Object> getHistorialConciliacionesBancariassObject() {		
		//this.historialconciliacionesbancariassObject=this.historialconciliacionesbancariasDataAccess.getEntitiesObject();
		return this.historialconciliacionesbancariassObject;
	}
		
	public void setHistorialConciliacionesBancariassObject(List<Object> newHistorialConciliacionesBancariassObject) {
		this.historialconciliacionesbancariassObject = newHistorialConciliacionesBancariassObject;
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
		historialconciliacionesbancariass = new  ArrayList<HistorialConciliacionesBancarias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//HistorialConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialconciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		historialconciliacionesbancariass = new  ArrayList<HistorialConciliacionesBancarias>();
		  		  
        try {
			//HistorialConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialconciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialconciliacionesbancariass = new  ArrayList<HistorialConciliacionesBancarias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//HistorialConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialconciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		historialconciliacionesbancariass = new  ArrayList<HistorialConciliacionesBancarias>();
		  		  
        try {
			//HistorialConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialconciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		historialconciliacionesbancariass = new  ArrayList<HistorialConciliacionesBancarias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//HistorialConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialconciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		historialconciliacionesbancariass = new  ArrayList<HistorialConciliacionesBancarias>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//HistorialConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialconciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<HistorialConciliacionesBancarias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialConciliacionesBancarias> entities = new  ArrayList<HistorialConciliacionesBancarias>();
		HistorialConciliacionesBancarias entity = new HistorialConciliacionesBancarias();		  
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
	
	public  List<HistorialConciliacionesBancarias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialConciliacionesBancarias> entities = new  ArrayList<HistorialConciliacionesBancarias>();
		HistorialConciliacionesBancarias entity = new HistorialConciliacionesBancarias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialConciliacionesBancarias();
				
				
      	    	entity=HistorialConciliacionesBancariasLogic.getEntityHistorialConciliacionesBancarias("",entity,resultSet);
      	    	
				//entity.setHistorialConciliacionesBancariasOriginal( new HistorialConciliacionesBancarias());
      	    	//entity.setHistorialConciliacionesBancariasOriginal(super.getEntity("",entity.getHistorialConciliacionesBancariasOriginal(),resultSet,HistorialConciliacionesBancariasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialConciliacionesBancariasOriginal(HistorialConciliacionesBancariasDataAccess.getEntityHistorialConciliacionesBancarias("",entity.getHistorialConciliacionesBancariasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<HistorialConciliacionesBancarias> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialConciliacionesBancarias> entities = new  ArrayList<HistorialConciliacionesBancarias>();
		HistorialConciliacionesBancarias entity = new HistorialConciliacionesBancarias();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,HistorialConciliacionesBancarias.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<HistorialConciliacionesBancarias>((List<HistorialConciliacionesBancarias>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setHistorialConciliacionesBancariassOriginal(entities);
			
			}  else {
				this.historialconciliacionesbancariassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//HistorialConciliacionesBancariasConstantesFunciones.quitarEspaciosHistorialConciliacionesBancariass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static HistorialConciliacionesBancarias getEntityHistorialConciliacionesBancarias(String strPrefijo,HistorialConciliacionesBancarias entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setdebito_local(resultSet.getDouble(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL));
			entity.setcredito_local(resultSet.getDouble(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL));
			entity.setnumero_cheque(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.NUMEROCHEQUE));
			entity.setcodigo(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.CODIGO));
			entity.setbeneficiario(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.BENEFICIARIO));
			entity.setdetalle(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.DETALLE));
			entity.setcuenta(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.CUENTA));
			entity.settipo_documento(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.TIPODOCUMENTO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.NUMEROMAYOR));
			entity.setfecha_finalizacion(new Date(resultSet.getDate(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.FECHAFINALIZACION).getTime()));
			entity.settipo_movimiento(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.TIPOMOVIMIENTO));
			entity.setsaldo_libros(resultSet.getDouble(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.FECHA).getTime()));
			entity.setnumero_cuenta(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.NUMEROCUENTA));
			entity.setnombre_cuenta_contable(resultSet.getString(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.NOMBRECUENTACONTABLE));
			entity.setanterior(resultSet.getDouble(strPrefijo+HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static HistorialConciliacionesBancarias getEntityHistorialConciliacionesBancarias(String strPrefijo,HistorialConciliacionesBancarias entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = HistorialConciliacionesBancarias.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = HistorialConciliacionesBancarias.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				HistorialConciliacionesBancariasLogic.setFieldReflectionHistorialConciliacionesBancarias(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionHistorialConciliacionesBancarias(Field field,String strPrefijo,String sColumn,HistorialConciliacionesBancarias entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.CUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.TIPODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.FECHAFINALIZACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.TIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.NOMBRECUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR:
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
	
	public void quitarHistorialConciliacionesBancariassNulos() throws Exception {				
		
		List<HistorialConciliacionesBancarias> historialconciliacionesbancariassAux= new ArrayList<HistorialConciliacionesBancarias>();
		
		for(HistorialConciliacionesBancarias historialconciliacionesbancarias:historialconciliacionesbancariass) {
			if(historialconciliacionesbancarias!=null) {
				historialconciliacionesbancariassAux.add(historialconciliacionesbancarias);
			}
		}
		
		historialconciliacionesbancariass=historialconciliacionesbancariassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<HistorialConciliacionesBancarias> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialConciliacionesBancarias> entities = new  ArrayList<HistorialConciliacionesBancarias>();
		HistorialConciliacionesBancarias entity = new HistorialConciliacionesBancarias();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<HistorialConciliacionesBancarias>((List<HistorialConciliacionesBancarias>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setHistorialConciliacionesBancariassOriginal(entities);
			
			}  else {
				this.historialconciliacionesbancariassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//HistorialConciliacionesBancariasConstantesFunciones.quitarEspaciosHistorialConciliacionesBancariass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		historialconciliacionesbancariass = new  ArrayList<HistorialConciliacionesBancarias>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//HistorialConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialconciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		historialconciliacionesbancariass = new  ArrayList<HistorialConciliacionesBancarias>();
		  		  
        try {
			//HistorialConciliacionesBancariasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialconciliacionesbancariass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<HistorialConciliacionesBancarias> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialConciliacionesBancarias> entities = new  ArrayList<HistorialConciliacionesBancarias>();
		HistorialConciliacionesBancarias entity = new HistorialConciliacionesBancarias();		  
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
	
	public  List<HistorialConciliacionesBancarias> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialConciliacionesBancarias> entities = new  ArrayList<HistorialConciliacionesBancarias>();
		HistorialConciliacionesBancarias entity = new HistorialConciliacionesBancarias();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialConciliacionesBancarias();
				
				if(conMapGenerico) {
					entity.setMapHistorialConciliacionesBancarias( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapHistorialConciliacionesBancarias().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialConciliacionesBancariasDataAccess.ISWITHSCHEMA);         		
					entity=HistorialConciliacionesBancariasLogic.getEntityHistorialConciliacionesBancarias("",entity,resultSet,listColumns);
					
					////entity.setHistorialConciliacionesBancariasOriginal( new HistorialConciliacionesBancarias());
					////entity.setHistorialConciliacionesBancariasOriginal(super.getEntity("",entity.getHistorialConciliacionesBancariasOriginal(),resultSet,HistorialConciliacionesBancariasDataAccess.ISWITHSCHEMA));         		
					////entity.setHistorialConciliacionesBancariasOriginal(HistorialConciliacionesBancariasDataAccess.getEntityHistorialConciliacionesBancarias("",entity.getHistorialConciliacionesBancariasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,HistorialConciliacionesBancarias relhistorialconciliacionesbancarias)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relhistorialconciliacionesbancarias.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CuentaContable getCuentaContable(Connexion connexion,HistorialConciliacionesBancarias relhistorialconciliacionesbancarias)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontableDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relhistorialconciliacionesbancarias.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


	
	
	public void getHistorialConciliacionesBancariassBusquedaHistorialConciliacionesBancariasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//HistorialConciliacionesBancariasLogic historialconciliacionesbancariasLogic=new HistorialConciliacionesBancariasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=HistorialConciliacionesBancariasLogic.GetSelecSqlHistorialConciliacionesBancarias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cuenta_contable,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.historialconciliacionesbancariass=this.getHistorialConciliacionesBancariass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getHistorialConciliacionesBancariassBusquedaHistorialConciliacionesBancarias(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//HistorialConciliacionesBancariasLogic historialconciliacionesbancariasLogic=new HistorialConciliacionesBancariasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=HistorialConciliacionesBancariasLogic.GetSelecSqlHistorialConciliacionesBancarias(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cuenta_contable,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.historialconciliacionesbancariass=this.getHistorialConciliacionesBancariass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlHistorialConciliacionesBancarias(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("HistorialConciliacionesBancarias_Postgres.sql");
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
				

				if(id_cuenta_contable!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_cuenta_contable = "+id_cuenta_contable.toString();
					existeWhere=true;
				}

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
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
	
	
	public void deepLoad(HistorialConciliacionesBancarias historialconciliacionesbancarias,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			HistorialConciliacionesBancariasLogicAdditional.updateHistorialConciliacionesBancariasToGet(historialconciliacionesbancarias,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialconciliacionesbancarias.setEmpresa(historialconciliacionesbancariasDataAccess.getEmpresa(connexion,historialconciliacionesbancarias));
		historialconciliacionesbancarias.setCuentaContable(historialconciliacionesbancariasDataAccess.getCuentaContable(connexion,historialconciliacionesbancarias));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				historialconciliacionesbancarias.setEmpresa(historialconciliacionesbancariasDataAccess.getEmpresa(connexion,historialconciliacionesbancarias));
			}

			if(clas.clas.equals(CuentaContable.class)) {
				historialconciliacionesbancarias.setCuentaContable(historialconciliacionesbancariasDataAccess.getCuentaContable(connexion,historialconciliacionesbancarias));
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
			historialconciliacionesbancarias.setEmpresa(historialconciliacionesbancariasDataAccess.getEmpresa(connexion,historialconciliacionesbancarias));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialconciliacionesbancarias.setCuentaContable(historialconciliacionesbancariasDataAccess.getCuentaContable(connexion,historialconciliacionesbancarias));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialconciliacionesbancarias.setEmpresa(historialconciliacionesbancariasDataAccess.getEmpresa(connexion,historialconciliacionesbancarias));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(historialconciliacionesbancarias.getEmpresa(),isDeep,deepLoadType,clases);
				
		historialconciliacionesbancarias.setCuentaContable(historialconciliacionesbancariasDataAccess.getCuentaContable(connexion,historialconciliacionesbancarias));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(historialconciliacionesbancarias.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				historialconciliacionesbancarias.setEmpresa(historialconciliacionesbancariasDataAccess.getEmpresa(connexion,historialconciliacionesbancarias));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(historialconciliacionesbancarias.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(CuentaContable.class)) {
				historialconciliacionesbancarias.setCuentaContable(historialconciliacionesbancariasDataAccess.getCuentaContable(connexion,historialconciliacionesbancarias));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(historialconciliacionesbancarias.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			historialconciliacionesbancarias.setEmpresa(historialconciliacionesbancariasDataAccess.getEmpresa(connexion,historialconciliacionesbancarias));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(historialconciliacionesbancarias.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialconciliacionesbancarias.setCuentaContable(historialconciliacionesbancariasDataAccess.getCuentaContable(connexion,historialconciliacionesbancarias));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(historialconciliacionesbancarias.getCuentaContable(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(historialconciliacionesbancarias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialConciliacionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesHistorialConciliacionesBancarias(historialconciliacionesbancarias);
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
			this.deepLoad(this.historialconciliacionesbancarias,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialConciliacionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesHistorialConciliacionesBancarias(this.historialconciliacionesbancarias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(historialconciliacionesbancariass!=null) {
				for(HistorialConciliacionesBancarias historialconciliacionesbancarias:historialconciliacionesbancariass) {
					this.deepLoad(historialconciliacionesbancarias,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					HistorialConciliacionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesHistorialConciliacionesBancarias(historialconciliacionesbancariass);
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
			if(historialconciliacionesbancariass!=null) {
				for(HistorialConciliacionesBancarias historialconciliacionesbancarias:historialconciliacionesbancariass) {
					this.deepLoad(historialconciliacionesbancarias,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					HistorialConciliacionesBancariasConstantesFunciones.refrescarForeignKeysDescripcionesHistorialConciliacionesBancarias(historialconciliacionesbancariass);
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
	
	public HistorialConciliacionesBancariasParameterReturnGeneral procesarAccionHistorialConciliacionesBancariass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,HistorialConciliacionesBancariasParameterReturnGeneral historialconciliacionesbancariasParameterGeneral)throws Exception {
		 try {	
			HistorialConciliacionesBancariasParameterReturnGeneral historialconciliacionesbancariasReturnGeneral=new HistorialConciliacionesBancariasParameterReturnGeneral();
	
			HistorialConciliacionesBancariasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialconciliacionesbancariass,historialconciliacionesbancariasParameterGeneral,historialconciliacionesbancariasReturnGeneral);
			
			return historialconciliacionesbancariasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialConciliacionesBancariasParameterReturnGeneral procesarAccionHistorialConciliacionesBancariassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,HistorialConciliacionesBancariasParameterReturnGeneral historialconciliacionesbancariasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			HistorialConciliacionesBancariasParameterReturnGeneral historialconciliacionesbancariasReturnGeneral=new HistorialConciliacionesBancariasParameterReturnGeneral();
	
			HistorialConciliacionesBancariasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialconciliacionesbancariass,historialconciliacionesbancariasParameterGeneral,historialconciliacionesbancariasReturnGeneral);
			
			this.connexion.commit();
			
			return historialconciliacionesbancariasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

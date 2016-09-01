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
import com.bydan.erp.cartera.util.report.CobrarMorosidadClientesDetalladosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarMorosidadClientesDetalladosParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarMorosidadClientesDetalladosConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarMorosidadClientesDetallados;

import com.bydan.erp.cartera.business.logic.report.CobrarMorosidadClientesDetalladosLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarMorosidadClientesDetalladosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarMorosidadClientesDetalladosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarMorosidadClientesDetalladosLogic cobrarmorosidadclientesdetalladosDataAccess; 		
	protected CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados;
	protected List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss;
	protected Object cobrarmorosidadclientesdetalladosObject;	
	protected List<Object> cobrarmorosidadclientesdetalladossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarMorosidadClientesDetalladosLogic()throws SQLException,Exception {
		try	{
			this.cobrarmorosidadclientesdetalladoss= new ArrayList<CobrarMorosidadClientesDetallados>();
			this.cobrarmorosidadclientesdetallados= new CobrarMorosidadClientesDetallados();
			this.cobrarmorosidadclientesdetalladosObject=new Object();
			this.cobrarmorosidadclientesdetalladossObject=new ArrayList<Object>();
			
			this.cobrarmorosidadclientesdetalladosDataAccess=this;
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
			this.cobrarmorosidadclientesdetalladosDataAccess.setConnexionType(this.connexionType);
			this.cobrarmorosidadclientesdetalladosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarmorosidadclientesdetalladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarMorosidadClientesDetalladosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarmorosidadclientesdetalladoss= new ArrayList<CobrarMorosidadClientesDetallados>();
			this.cobrarmorosidadclientesdetallados= new CobrarMorosidadClientesDetallados();
			this.cobrarmorosidadclientesdetalladosObject=new Object();
			this.cobrarmorosidadclientesdetalladossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarmorosidadclientesdetalladosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarmorosidadclientesdetalladosDataAccess.setConnexionType(this.connexionType);
			this.cobrarmorosidadclientesdetalladosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarmorosidadclientesdetalladosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarMorosidadClientesDetallados getCobrarMorosidadClientesDetallados() throws Exception {	
		CobrarMorosidadClientesDetalladosLogicAdditional.checkCobrarMorosidadClientesDetalladosToGet(cobrarmorosidadclientesdetallados,this.datosCliente,this.arrDatoGeneral);
		CobrarMorosidadClientesDetalladosLogicAdditional.updateCobrarMorosidadClientesDetalladosToGet(cobrarmorosidadclientesdetallados,this.arrDatoGeneral);
		
		return cobrarmorosidadclientesdetallados;
	}
		
	public void setCobrarMorosidadClientesDetallados(CobrarMorosidadClientesDetallados newCobrarMorosidadClientesDetallados) {
		this.cobrarmorosidadclientesdetallados = newCobrarMorosidadClientesDetallados;
	}
	
	public List<CobrarMorosidadClientesDetallados> getCobrarMorosidadClientesDetalladoss() throws Exception {		
		this.quitarCobrarMorosidadClientesDetalladossNulos();
		
		CobrarMorosidadClientesDetalladosLogicAdditional.checkCobrarMorosidadClientesDetalladosToGets(cobrarmorosidadclientesdetalladoss,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosLocal: cobrarmorosidadclientesdetalladoss ) {
			CobrarMorosidadClientesDetalladosLogicAdditional.updateCobrarMorosidadClientesDetalladosToGet(cobrarmorosidadclientesdetalladosLocal,this.arrDatoGeneral);
		}
		
		return cobrarmorosidadclientesdetalladoss;
	}
	
	public void setCobrarMorosidadClientesDetalladoss(List<CobrarMorosidadClientesDetallados> newCobrarMorosidadClientesDetalladoss) {
		this.cobrarmorosidadclientesdetalladoss = newCobrarMorosidadClientesDetalladoss;
	}
	
	public Object getCobrarMorosidadClientesDetalladosObject() {	
		//this.cobrarmorosidadclientesdetalladosObject=this.cobrarmorosidadclientesdetalladosDataAccess.getEntityObject();
		return this.cobrarmorosidadclientesdetalladosObject;
	}
		
	public void setCobrarMorosidadClientesDetalladosObject(Object newCobrarMorosidadClientesDetalladosObject) {
		this.cobrarmorosidadclientesdetalladosObject = newCobrarMorosidadClientesDetalladosObject;
	}
	
	public List<Object> getCobrarMorosidadClientesDetalladossObject() {		
		//this.cobrarmorosidadclientesdetalladossObject=this.cobrarmorosidadclientesdetalladosDataAccess.getEntitiesObject();
		return this.cobrarmorosidadclientesdetalladossObject;
	}
		
	public void setCobrarMorosidadClientesDetalladossObject(List<Object> newCobrarMorosidadClientesDetalladossObject) {
		this.cobrarmorosidadclientesdetalladossObject = newCobrarMorosidadClientesDetalladossObject;
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
		cobrarmorosidadclientesdetalladoss = new  ArrayList<CobrarMorosidadClientesDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarMorosidadClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarmorosidadclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarmorosidadclientesdetalladoss = new  ArrayList<CobrarMorosidadClientesDetallados>();
		  		  
        try {
			//CobrarMorosidadClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarmorosidadclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarmorosidadclientesdetalladoss = new  ArrayList<CobrarMorosidadClientesDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarMorosidadClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarmorosidadclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarmorosidadclientesdetalladoss = new  ArrayList<CobrarMorosidadClientesDetallados>();
		  		  
        try {
			//CobrarMorosidadClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarmorosidadclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarmorosidadclientesdetalladoss = new  ArrayList<CobrarMorosidadClientesDetallados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarMorosidadClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarmorosidadclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarmorosidadclientesdetalladoss = new  ArrayList<CobrarMorosidadClientesDetallados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarMorosidadClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarmorosidadclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarMorosidadClientesDetallados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarMorosidadClientesDetallados> entities = new  ArrayList<CobrarMorosidadClientesDetallados>();
		CobrarMorosidadClientesDetallados entity = new CobrarMorosidadClientesDetallados();		  
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
	
	public  List<CobrarMorosidadClientesDetallados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarMorosidadClientesDetallados> entities = new  ArrayList<CobrarMorosidadClientesDetallados>();
		CobrarMorosidadClientesDetallados entity = new CobrarMorosidadClientesDetallados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarMorosidadClientesDetallados();
				
				
      	    	entity=CobrarMorosidadClientesDetalladosLogic.getEntityCobrarMorosidadClientesDetallados("",entity,resultSet);
      	    	
				//entity.setCobrarMorosidadClientesDetalladosOriginal( new CobrarMorosidadClientesDetallados());
      	    	//entity.setCobrarMorosidadClientesDetalladosOriginal(super.getEntity("",entity.getCobrarMorosidadClientesDetalladosOriginal(),resultSet,CobrarMorosidadClientesDetalladosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarMorosidadClientesDetalladosOriginal(CobrarMorosidadClientesDetalladosDataAccess.getEntityCobrarMorosidadClientesDetallados("",entity.getCobrarMorosidadClientesDetalladosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarMorosidadClientesDetallados> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarMorosidadClientesDetallados> entities = new  ArrayList<CobrarMorosidadClientesDetallados>();
		CobrarMorosidadClientesDetallados entity = new CobrarMorosidadClientesDetallados();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarMorosidadClientesDetallados.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarMorosidadClientesDetallados>((List<CobrarMorosidadClientesDetallados>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarMorosidadClientesDetalladossOriginal(entities);
			
			}  else {
				this.cobrarmorosidadclientesdetalladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarMorosidadClientesDetalladosConstantesFunciones.quitarEspaciosCobrarMorosidadClientesDetalladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarMorosidadClientesDetallados getEntityCobrarMorosidadClientesDetallados(String strPrefijo,CobrarMorosidadClientesDetallados entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarMorosidadClientesDetalladosConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+CobrarMorosidadClientesDetalladosConstantesFunciones.NOMBRECOMPLETO));
			entity.setnumero_pre_impreso_factura(resultSet.getString(strPrefijo+CobrarMorosidadClientesDetalladosConstantesFunciones.NUMEROPREIMPRESOFACTURA));
			entity.setsaldo_vencido(resultSet.getDouble(strPrefijo+CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO));
			entity.setsaldo_vencer(resultSet.getDouble(strPrefijo+CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarMorosidadClientesDetallados getEntityCobrarMorosidadClientesDetallados(String strPrefijo,CobrarMorosidadClientesDetallados entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarMorosidadClientesDetallados.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarMorosidadClientesDetallados.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarMorosidadClientesDetalladosLogic.setFieldReflectionCobrarMorosidadClientesDetallados(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarMorosidadClientesDetallados(Field field,String strPrefijo,String sColumn,CobrarMorosidadClientesDetallados entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarMorosidadClientesDetalladosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarMorosidadClientesDetalladosConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarMorosidadClientesDetalladosConstantesFunciones.NUMEROPREIMPRESOFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER:
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
	
	public void quitarCobrarMorosidadClientesDetalladossNulos() throws Exception {				
		
		List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladossAux= new ArrayList<CobrarMorosidadClientesDetallados>();
		
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados:cobrarmorosidadclientesdetalladoss) {
			if(cobrarmorosidadclientesdetallados!=null) {
				cobrarmorosidadclientesdetalladossAux.add(cobrarmorosidadclientesdetallados);
			}
		}
		
		cobrarmorosidadclientesdetalladoss=cobrarmorosidadclientesdetalladossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarMorosidadClientesDetallados> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarMorosidadClientesDetallados> entities = new  ArrayList<CobrarMorosidadClientesDetallados>();
		CobrarMorosidadClientesDetallados entity = new CobrarMorosidadClientesDetallados();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarMorosidadClientesDetallados>((List<CobrarMorosidadClientesDetallados>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarMorosidadClientesDetalladossOriginal(entities);
			
			}  else {
				this.cobrarmorosidadclientesdetalladossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarMorosidadClientesDetalladosConstantesFunciones.quitarEspaciosCobrarMorosidadClientesDetalladoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarmorosidadclientesdetalladoss = new  ArrayList<CobrarMorosidadClientesDetallados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarMorosidadClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarmorosidadclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarmorosidadclientesdetalladoss = new  ArrayList<CobrarMorosidadClientesDetallados>();
		  		  
        try {
			//CobrarMorosidadClientesDetalladosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarmorosidadclientesdetalladoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarMorosidadClientesDetallados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarMorosidadClientesDetallados> entities = new  ArrayList<CobrarMorosidadClientesDetallados>();
		CobrarMorosidadClientesDetallados entity = new CobrarMorosidadClientesDetallados();		  
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
	
	public  List<CobrarMorosidadClientesDetallados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarMorosidadClientesDetallados> entities = new  ArrayList<CobrarMorosidadClientesDetallados>();
		CobrarMorosidadClientesDetallados entity = new CobrarMorosidadClientesDetallados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarMorosidadClientesDetallados();
				
				if(conMapGenerico) {
					entity.setMapCobrarMorosidadClientesDetallados( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarMorosidadClientesDetallados().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarMorosidadClientesDetalladosDataAccess.ISWITHSCHEMA);         		
					entity=CobrarMorosidadClientesDetalladosLogic.getEntityCobrarMorosidadClientesDetallados("",entity,resultSet,listColumns);
					
					////entity.setCobrarMorosidadClientesDetalladosOriginal( new CobrarMorosidadClientesDetallados());
					////entity.setCobrarMorosidadClientesDetalladosOriginal(super.getEntity("",entity.getCobrarMorosidadClientesDetalladosOriginal(),resultSet,CobrarMorosidadClientesDetalladosDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarMorosidadClientesDetalladosOriginal(CobrarMorosidadClientesDetalladosDataAccess.getEntityCobrarMorosidadClientesDetallados("",entity.getCobrarMorosidadClientesDetalladosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarMorosidadClientesDetallados relcobrarmorosidadclientesdetallados)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarmorosidadclientesdetallados.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getCobrarMorosidadClientesDetalladossBusquedaCobrarMorosidadClientesDetalladosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_vence)throws Exception {
		try {
			//CobrarMorosidadClientesDetalladosLogic cobrarmorosidadclientesdetalladosLogic=new CobrarMorosidadClientesDetalladosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarMorosidadClientesDetalladosLogic.GetSelecSqlCobrarMorosidadClientesDetallados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_vence);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarmorosidadclientesdetalladoss=this.getCobrarMorosidadClientesDetalladoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarMorosidadClientesDetalladossBusquedaCobrarMorosidadClientesDetallados(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_vence)throws Exception {
		try {
			//CobrarMorosidadClientesDetalladosLogic cobrarmorosidadclientesdetalladosLogic=new CobrarMorosidadClientesDetalladosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarMorosidadClientesDetalladosLogic.GetSelecSqlCobrarMorosidadClientesDetallados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_vence);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarmorosidadclientesdetalladoss=this.getCobrarMorosidadClientesDetalladoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarMorosidadClientesDetallados(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_vence)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarMorosidadClientesDetallados_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				sSelectQuery=sSelectQuery.replace("IDEMPRESA", parametroGeneralUsuario.getid_empresa().toString());
				

				sSelectQuery=sSelectQuery.replace("FECHA_VENCE", Funciones2.getStringPostgresDate(fecha_vence));

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
	
	
	public void deepLoad(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarMorosidadClientesDetalladosLogicAdditional.updateCobrarMorosidadClientesDetalladosToGet(cobrarmorosidadclientesdetallados,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarmorosidadclientesdetallados.setEmpresa(cobrarmorosidadclientesdetalladosDataAccess.getEmpresa(connexion,cobrarmorosidadclientesdetallados));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarmorosidadclientesdetallados.setEmpresa(cobrarmorosidadclientesdetalladosDataAccess.getEmpresa(connexion,cobrarmorosidadclientesdetallados));
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
			cobrarmorosidadclientesdetallados.setEmpresa(cobrarmorosidadclientesdetalladosDataAccess.getEmpresa(connexion,cobrarmorosidadclientesdetallados));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarmorosidadclientesdetallados.setEmpresa(cobrarmorosidadclientesdetalladosDataAccess.getEmpresa(connexion,cobrarmorosidadclientesdetallados));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarmorosidadclientesdetallados.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarmorosidadclientesdetallados.setEmpresa(cobrarmorosidadclientesdetalladosDataAccess.getEmpresa(connexion,cobrarmorosidadclientesdetallados));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarmorosidadclientesdetallados.getEmpresa(),isDeep,deepLoadType,clases);				
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
			cobrarmorosidadclientesdetallados.setEmpresa(cobrarmorosidadclientesdetalladosDataAccess.getEmpresa(connexion,cobrarmorosidadclientesdetallados));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarmorosidadclientesdetallados.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarmorosidadclientesdetallados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarMorosidadClientesDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarMorosidadClientesDetallados(cobrarmorosidadclientesdetallados);
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
			this.deepLoad(this.cobrarmorosidadclientesdetallados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarMorosidadClientesDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarMorosidadClientesDetallados(this.cobrarmorosidadclientesdetallados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarmorosidadclientesdetalladoss!=null) {
				for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados:cobrarmorosidadclientesdetalladoss) {
					this.deepLoad(cobrarmorosidadclientesdetallados,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarMorosidadClientesDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarMorosidadClientesDetallados(cobrarmorosidadclientesdetalladoss);
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
			if(cobrarmorosidadclientesdetalladoss!=null) {
				for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados:cobrarmorosidadclientesdetalladoss) {
					this.deepLoad(cobrarmorosidadclientesdetallados,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarMorosidadClientesDetalladosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarMorosidadClientesDetallados(cobrarmorosidadclientesdetalladoss);
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
	
	public CobrarMorosidadClientesDetalladosParameterReturnGeneral procesarAccionCobrarMorosidadClientesDetalladoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,CobrarMorosidadClientesDetalladosParameterReturnGeneral cobrarmorosidadclientesdetalladosParameterGeneral)throws Exception {
		 try {	
			CobrarMorosidadClientesDetalladosParameterReturnGeneral cobrarmorosidadclientesdetalladosReturnGeneral=new CobrarMorosidadClientesDetalladosParameterReturnGeneral();
	
			CobrarMorosidadClientesDetalladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarmorosidadclientesdetalladoss,cobrarmorosidadclientesdetalladosParameterGeneral,cobrarmorosidadclientesdetalladosReturnGeneral);
			
			return cobrarmorosidadclientesdetalladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarMorosidadClientesDetalladosParameterReturnGeneral procesarAccionCobrarMorosidadClientesDetalladossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,CobrarMorosidadClientesDetalladosParameterReturnGeneral cobrarmorosidadclientesdetalladosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarMorosidadClientesDetalladosParameterReturnGeneral cobrarmorosidadclientesdetalladosReturnGeneral=new CobrarMorosidadClientesDetalladosParameterReturnGeneral();
	
			CobrarMorosidadClientesDetalladosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarmorosidadclientesdetalladoss,cobrarmorosidadclientesdetalladosParameterGeneral,cobrarmorosidadclientesdetalladosReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarmorosidadclientesdetalladosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

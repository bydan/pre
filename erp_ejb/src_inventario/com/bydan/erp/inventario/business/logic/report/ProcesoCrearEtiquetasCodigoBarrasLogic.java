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
package com.bydan.erp.inventario.business.logic.report;

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

import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.resources.general.AuxiliarGeneral;
import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasCodigoBarrasParameterGeneral;
import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProcesoCrearEtiquetasCodigoBarras;

import com.bydan.erp.inventario.business.logic.report.ProcesoCrearEtiquetasCodigoBarrasLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoCrearEtiquetasCodigoBarrasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCrearEtiquetasCodigoBarrasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCrearEtiquetasCodigoBarrasLogic procesocrearetiquetascodigobarrasDataAccess; 		
	protected ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras;
	protected List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass;
	protected Object procesocrearetiquetascodigobarrasObject;	
	protected List<Object> procesocrearetiquetascodigobarrassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCrearEtiquetasCodigoBarrasLogic()throws SQLException,Exception {
		try	{
			this.procesocrearetiquetascodigobarrass= new ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
			this.procesocrearetiquetascodigobarras= new ProcesoCrearEtiquetasCodigoBarras();
			this.procesocrearetiquetascodigobarrasObject=new Object();
			this.procesocrearetiquetascodigobarrassObject=new ArrayList<Object>();
			
			this.procesocrearetiquetascodigobarrasDataAccess=this;
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
			this.procesocrearetiquetascodigobarrasDataAccess.setConnexionType(this.connexionType);
			this.procesocrearetiquetascodigobarrasDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocrearetiquetascodigobarrasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCrearEtiquetasCodigoBarrasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocrearetiquetascodigobarrass= new ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
			this.procesocrearetiquetascodigobarras= new ProcesoCrearEtiquetasCodigoBarras();
			this.procesocrearetiquetascodigobarrasObject=new Object();
			this.procesocrearetiquetascodigobarrassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocrearetiquetascodigobarrasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocrearetiquetascodigobarrasDataAccess.setConnexionType(this.connexionType);
			this.procesocrearetiquetascodigobarrasDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocrearetiquetascodigobarrasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCrearEtiquetasCodigoBarras getProcesoCrearEtiquetasCodigoBarras() throws Exception {	
		ProcesoCrearEtiquetasCodigoBarrasLogicAdditional.checkProcesoCrearEtiquetasCodigoBarrasToGet(procesocrearetiquetascodigobarras,this.datosCliente,this.arrDatoGeneral);
		ProcesoCrearEtiquetasCodigoBarrasLogicAdditional.updateProcesoCrearEtiquetasCodigoBarrasToGet(procesocrearetiquetascodigobarras,this.arrDatoGeneral);
		
		return procesocrearetiquetascodigobarras;
	}
		
	public void setProcesoCrearEtiquetasCodigoBarras(ProcesoCrearEtiquetasCodigoBarras newProcesoCrearEtiquetasCodigoBarras) {
		this.procesocrearetiquetascodigobarras = newProcesoCrearEtiquetasCodigoBarras;
	}
	
	public List<ProcesoCrearEtiquetasCodigoBarras> getProcesoCrearEtiquetasCodigoBarrass() throws Exception {		
		this.quitarProcesoCrearEtiquetasCodigoBarrassNulos();
		
		ProcesoCrearEtiquetasCodigoBarrasLogicAdditional.checkProcesoCrearEtiquetasCodigoBarrasToGets(procesocrearetiquetascodigobarrass,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarrasLocal: procesocrearetiquetascodigobarrass ) {
			ProcesoCrearEtiquetasCodigoBarrasLogicAdditional.updateProcesoCrearEtiquetasCodigoBarrasToGet(procesocrearetiquetascodigobarrasLocal,this.arrDatoGeneral);
		}
		
		return procesocrearetiquetascodigobarrass;
	}
	
	public void setProcesoCrearEtiquetasCodigoBarrass(List<ProcesoCrearEtiquetasCodigoBarras> newProcesoCrearEtiquetasCodigoBarrass) {
		this.procesocrearetiquetascodigobarrass = newProcesoCrearEtiquetasCodigoBarrass;
	}
	
	public Object getProcesoCrearEtiquetasCodigoBarrasObject() {	
		//this.procesocrearetiquetascodigobarrasObject=this.procesocrearetiquetascodigobarrasDataAccess.getEntityObject();
		return this.procesocrearetiquetascodigobarrasObject;
	}
		
	public void setProcesoCrearEtiquetasCodigoBarrasObject(Object newProcesoCrearEtiquetasCodigoBarrasObject) {
		this.procesocrearetiquetascodigobarrasObject = newProcesoCrearEtiquetasCodigoBarrasObject;
	}
	
	public List<Object> getProcesoCrearEtiquetasCodigoBarrassObject() {		
		//this.procesocrearetiquetascodigobarrassObject=this.procesocrearetiquetascodigobarrasDataAccess.getEntitiesObject();
		return this.procesocrearetiquetascodigobarrassObject;
	}
		
	public void setProcesoCrearEtiquetasCodigoBarrassObject(List<Object> newProcesoCrearEtiquetasCodigoBarrassObject) {
		this.procesocrearetiquetascodigobarrassObject = newProcesoCrearEtiquetasCodigoBarrassObject;
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
		procesocrearetiquetascodigobarrass = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCrearEtiquetasCodigoBarrasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetascodigobarrass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocrearetiquetascodigobarrass = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		  		  
        try {
			//ProcesoCrearEtiquetasCodigoBarrasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetascodigobarrass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocrearetiquetascodigobarrass = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCrearEtiquetasCodigoBarrasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetascodigobarrass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocrearetiquetascodigobarrass = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		  		  
        try {
			//ProcesoCrearEtiquetasCodigoBarrasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetascodigobarrass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocrearetiquetascodigobarrass = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCrearEtiquetasCodigoBarrasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetascodigobarrass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocrearetiquetascodigobarrass = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCrearEtiquetasCodigoBarrasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetascodigobarrass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCrearEtiquetasCodigoBarras> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasCodigoBarras> entities = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		ProcesoCrearEtiquetasCodigoBarras entity = new ProcesoCrearEtiquetasCodigoBarras();		  
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
	
	public  List<ProcesoCrearEtiquetasCodigoBarras> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasCodigoBarras> entities = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		ProcesoCrearEtiquetasCodigoBarras entity = new ProcesoCrearEtiquetasCodigoBarras();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCrearEtiquetasCodigoBarras();
				
				
      	    	entity=ProcesoCrearEtiquetasCodigoBarrasLogic.getEntityProcesoCrearEtiquetasCodigoBarras("",entity,resultSet);
      	    	
				//entity.setProcesoCrearEtiquetasCodigoBarrasOriginal( new ProcesoCrearEtiquetasCodigoBarras());
      	    	//entity.setProcesoCrearEtiquetasCodigoBarrasOriginal(super.getEntity("",entity.getProcesoCrearEtiquetasCodigoBarrasOriginal(),resultSet,ProcesoCrearEtiquetasCodigoBarrasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCrearEtiquetasCodigoBarrasOriginal(ProcesoCrearEtiquetasCodigoBarrasDataAccess.getEntityProcesoCrearEtiquetasCodigoBarras("",entity.getProcesoCrearEtiquetasCodigoBarrasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCrearEtiquetasCodigoBarras> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasCodigoBarras> entities = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		ProcesoCrearEtiquetasCodigoBarras entity = new ProcesoCrearEtiquetasCodigoBarras();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCrearEtiquetasCodigoBarras.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCrearEtiquetasCodigoBarras>((List<ProcesoCrearEtiquetasCodigoBarras>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCrearEtiquetasCodigoBarrassOriginal(entities);
			
			}  else {
				this.procesocrearetiquetascodigobarrassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.quitarEspaciosProcesoCrearEtiquetasCodigoBarrass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCrearEtiquetasCodigoBarras getEntityProcesoCrearEtiquetasCodigoBarras(String strPrefijo,ProcesoCrearEtiquetasCodigoBarras entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NOMBRE));
			entity.setprecio(resultSet.getDouble(strPrefijo+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO));
			entity.setnumero(resultSet.getDouble(strPrefijo+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO));
			entity.settalla(resultSet.getString(strPrefijo+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TALLA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCrearEtiquetasCodigoBarras getEntityProcesoCrearEtiquetasCodigoBarras(String strPrefijo,ProcesoCrearEtiquetasCodigoBarras entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCrearEtiquetasCodigoBarras.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCrearEtiquetasCodigoBarras.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCrearEtiquetasCodigoBarrasLogic.setFieldReflectionProcesoCrearEtiquetasCodigoBarras(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCrearEtiquetasCodigoBarras(Field field,String strPrefijo,String sColumn,ProcesoCrearEtiquetasCodigoBarras entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TALLA:
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
	
	public void quitarProcesoCrearEtiquetasCodigoBarrassNulos() throws Exception {				
		
		List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrassAux= new ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		
		for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras:procesocrearetiquetascodigobarrass) {
			if(procesocrearetiquetascodigobarras!=null) {
				procesocrearetiquetascodigobarrassAux.add(procesocrearetiquetascodigobarras);
			}
		}
		
		procesocrearetiquetascodigobarrass=procesocrearetiquetascodigobarrassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCrearEtiquetasCodigoBarras> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasCodigoBarras> entities = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		ProcesoCrearEtiquetasCodigoBarras entity = new ProcesoCrearEtiquetasCodigoBarras();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCrearEtiquetasCodigoBarras>((List<ProcesoCrearEtiquetasCodigoBarras>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCrearEtiquetasCodigoBarrassOriginal(entities);
			
			}  else {
				this.procesocrearetiquetascodigobarrassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.quitarEspaciosProcesoCrearEtiquetasCodigoBarrass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocrearetiquetascodigobarrass = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCrearEtiquetasCodigoBarrasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetascodigobarrass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesocrearetiquetascodigobarrass = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		  		  
        try {
			//ProcesoCrearEtiquetasCodigoBarrasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocrearetiquetascodigobarrass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCrearEtiquetasCodigoBarras> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasCodigoBarras> entities = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		ProcesoCrearEtiquetasCodigoBarras entity = new ProcesoCrearEtiquetasCodigoBarras();		  
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
	
	public  List<ProcesoCrearEtiquetasCodigoBarras> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCrearEtiquetasCodigoBarras> entities = new  ArrayList<ProcesoCrearEtiquetasCodigoBarras>();
		ProcesoCrearEtiquetasCodigoBarras entity = new ProcesoCrearEtiquetasCodigoBarras();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCrearEtiquetasCodigoBarras();
				
				if(conMapGenerico) {
					entity.setMapProcesoCrearEtiquetasCodigoBarras( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCrearEtiquetasCodigoBarras().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCrearEtiquetasCodigoBarrasDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCrearEtiquetasCodigoBarrasLogic.getEntityProcesoCrearEtiquetasCodigoBarras("",entity,resultSet,listColumns);
					
					////entity.setProcesoCrearEtiquetasCodigoBarrasOriginal( new ProcesoCrearEtiquetasCodigoBarras());
					////entity.setProcesoCrearEtiquetasCodigoBarrasOriginal(super.getEntity("",entity.getProcesoCrearEtiquetasCodigoBarrasOriginal(),resultSet,ProcesoCrearEtiquetasCodigoBarrasDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCrearEtiquetasCodigoBarrasOriginal(ProcesoCrearEtiquetasCodigoBarrasDataAccess.getEntityProcesoCrearEtiquetasCodigoBarras("",entity.getProcesoCrearEtiquetasCodigoBarrasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,ProcesoCrearEtiquetasCodigoBarras relprocesocrearetiquetascodigobarras)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relprocesocrearetiquetascodigobarras.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProcesoCrearEtiquetasCodigoBarras relprocesocrearetiquetascodigobarras)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relprocesocrearetiquetascodigobarras.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,ProcesoCrearEtiquetasCodigoBarras relprocesocrearetiquetascodigobarras)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relprocesocrearetiquetascodigobarras.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProcesoCrearEtiquetasCodigoBarras relprocesocrearetiquetascodigobarras)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relprocesocrearetiquetascodigobarras.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,ProcesoCrearEtiquetasCodigoBarras relprocesocrearetiquetascodigobarras)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocrearetiquetascodigobarras.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProcesoCrearEtiquetasCodigoBarras relprocesocrearetiquetascodigobarras)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocrearetiquetascodigobarras.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProcesoCrearEtiquetasCodigoBarras relprocesocrearetiquetascodigobarras)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocrearetiquetascodigobarras.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProcesoCrearEtiquetasCodigoBarras relprocesocrearetiquetascodigobarras)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocrearetiquetascodigobarras.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getProcesoCrearEtiquetasCodigoBarrassBusquedaProcesoCrearEtiquetasCodigoBarrasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoCrearEtiquetasCodigoBarrasLogic procesocrearetiquetascodigobarrasLogic=new ProcesoCrearEtiquetasCodigoBarrasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoCrearEtiquetasCodigoBarrasLogic.GetSelecSqlProcesoCrearEtiquetasCodigoBarras(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesocrearetiquetascodigobarrass=this.getProcesoCrearEtiquetasCodigoBarrass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCrearEtiquetasCodigoBarrassBusquedaProcesoCrearEtiquetasCodigoBarras(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoCrearEtiquetasCodigoBarrasLogic procesocrearetiquetascodigobarrasLogic=new ProcesoCrearEtiquetasCodigoBarrasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoCrearEtiquetasCodigoBarrasLogic.GetSelecSqlProcesoCrearEtiquetasCodigoBarras(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesocrearetiquetascodigobarrass=this.getProcesoCrearEtiquetasCodigoBarrass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoCrearEtiquetasCodigoBarras(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoCrearEtiquetasCodigoBarras_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_bodega!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_bodega = "+id_bodega.toString();
					existeWhere=true;
				}

				if(id_producto!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_producto = "+id_producto.toString();
					existeWhere=true;
				}

				if(id_linea!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea = "+id_linea.toString();
					existeWhere=true;
				}

				if(id_linea_grupo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_grupo = "+id_linea_grupo.toString();
					existeWhere=true;
				}

				if(id_linea_categoria!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_categoria = "+id_linea_categoria.toString();
					existeWhere=true;
				}

				if(id_linea_marca!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_marca = "+id_linea_marca.toString();
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
	
	
	public void deepLoad(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoCrearEtiquetasCodigoBarrasLogicAdditional.updateProcesoCrearEtiquetasCodigoBarrasToGet(procesocrearetiquetascodigobarras,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocrearetiquetascodigobarras.setBodega(procesocrearetiquetascodigobarrasDataAccess.getBodega(connexion,procesocrearetiquetascodigobarras));
		procesocrearetiquetascodigobarras.setProducto(procesocrearetiquetascodigobarrasDataAccess.getProducto(connexion,procesocrearetiquetascodigobarras));
		procesocrearetiquetascodigobarras.setEmpresa(procesocrearetiquetascodigobarrasDataAccess.getEmpresa(connexion,procesocrearetiquetascodigobarras));
		procesocrearetiquetascodigobarras.setSucursal(procesocrearetiquetascodigobarrasDataAccess.getSucursal(connexion,procesocrearetiquetascodigobarras));
		procesocrearetiquetascodigobarras.setLinea(procesocrearetiquetascodigobarrasDataAccess.getLinea(connexion,procesocrearetiquetascodigobarras));
		procesocrearetiquetascodigobarras.setLineaGrupo(procesocrearetiquetascodigobarrasDataAccess.getLineaGrupo(connexion,procesocrearetiquetascodigobarras));
		procesocrearetiquetascodigobarras.setLineaCategoria(procesocrearetiquetascodigobarrasDataAccess.getLineaCategoria(connexion,procesocrearetiquetascodigobarras));
		procesocrearetiquetascodigobarras.setLineaMarca(procesocrearetiquetascodigobarrasDataAccess.getLineaMarca(connexion,procesocrearetiquetascodigobarras));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesocrearetiquetascodigobarras.setBodega(procesocrearetiquetascodigobarrasDataAccess.getBodega(connexion,procesocrearetiquetascodigobarras));
			}

			if(clas.clas.equals(Producto.class)) {
				procesocrearetiquetascodigobarras.setProducto(procesocrearetiquetascodigobarrasDataAccess.getProducto(connexion,procesocrearetiquetascodigobarras));
			}

			if(clas.clas.equals(Empresa.class)) {
				procesocrearetiquetascodigobarras.setEmpresa(procesocrearetiquetascodigobarrasDataAccess.getEmpresa(connexion,procesocrearetiquetascodigobarras));
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesocrearetiquetascodigobarras.setSucursal(procesocrearetiquetascodigobarrasDataAccess.getSucursal(connexion,procesocrearetiquetascodigobarras));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetascodigobarras.setLinea(procesocrearetiquetascodigobarrasDataAccess.getLinea(connexion,procesocrearetiquetascodigobarras));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetascodigobarras.setLineaGrupo(procesocrearetiquetascodigobarrasDataAccess.getLineaGrupo(connexion,procesocrearetiquetascodigobarras));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetascodigobarras.setLineaCategoria(procesocrearetiquetascodigobarrasDataAccess.getLineaCategoria(connexion,procesocrearetiquetascodigobarras));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetascodigobarras.setLineaMarca(procesocrearetiquetascodigobarrasDataAccess.getLineaMarca(connexion,procesocrearetiquetascodigobarras));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setBodega(procesocrearetiquetascodigobarrasDataAccess.getBodega(connexion,procesocrearetiquetascodigobarras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setProducto(procesocrearetiquetascodigobarrasDataAccess.getProducto(connexion,procesocrearetiquetascodigobarras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setEmpresa(procesocrearetiquetascodigobarrasDataAccess.getEmpresa(connexion,procesocrearetiquetascodigobarras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setSucursal(procesocrearetiquetascodigobarrasDataAccess.getSucursal(connexion,procesocrearetiquetascodigobarras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setLinea(procesocrearetiquetascodigobarrasDataAccess.getLinea(connexion,procesocrearetiquetascodigobarras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setLineaGrupo(procesocrearetiquetascodigobarrasDataAccess.getLineaGrupo(connexion,procesocrearetiquetascodigobarras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setLineaCategoria(procesocrearetiquetascodigobarrasDataAccess.getLineaCategoria(connexion,procesocrearetiquetascodigobarras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setLineaMarca(procesocrearetiquetascodigobarrasDataAccess.getLineaMarca(connexion,procesocrearetiquetascodigobarras));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocrearetiquetascodigobarras.setBodega(procesocrearetiquetascodigobarrasDataAccess.getBodega(connexion,procesocrearetiquetascodigobarras));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(procesocrearetiquetascodigobarras.getBodega(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetascodigobarras.setProducto(procesocrearetiquetascodigobarrasDataAccess.getProducto(connexion,procesocrearetiquetascodigobarras));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(procesocrearetiquetascodigobarras.getProducto(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetascodigobarras.setEmpresa(procesocrearetiquetascodigobarrasDataAccess.getEmpresa(connexion,procesocrearetiquetascodigobarras));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(procesocrearetiquetascodigobarras.getEmpresa(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetascodigobarras.setSucursal(procesocrearetiquetascodigobarrasDataAccess.getSucursal(connexion,procesocrearetiquetascodigobarras));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(procesocrearetiquetascodigobarras.getSucursal(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetascodigobarras.setLinea(procesocrearetiquetascodigobarrasDataAccess.getLinea(connexion,procesocrearetiquetascodigobarras));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(procesocrearetiquetascodigobarras.getLinea(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetascodigobarras.setLineaGrupo(procesocrearetiquetascodigobarrasDataAccess.getLineaGrupo(connexion,procesocrearetiquetascodigobarras));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(procesocrearetiquetascodigobarras.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetascodigobarras.setLineaCategoria(procesocrearetiquetascodigobarrasDataAccess.getLineaCategoria(connexion,procesocrearetiquetascodigobarras));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(procesocrearetiquetascodigobarras.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		procesocrearetiquetascodigobarras.setLineaMarca(procesocrearetiquetascodigobarrasDataAccess.getLineaMarca(connexion,procesocrearetiquetascodigobarras));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(procesocrearetiquetascodigobarras.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesocrearetiquetascodigobarras.setBodega(procesocrearetiquetascodigobarrasDataAccess.getBodega(connexion,procesocrearetiquetascodigobarras));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(procesocrearetiquetascodigobarras.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				procesocrearetiquetascodigobarras.setProducto(procesocrearetiquetascodigobarrasDataAccess.getProducto(connexion,procesocrearetiquetascodigobarras));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(procesocrearetiquetascodigobarras.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				procesocrearetiquetascodigobarras.setEmpresa(procesocrearetiquetascodigobarrasDataAccess.getEmpresa(connexion,procesocrearetiquetascodigobarras));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(procesocrearetiquetascodigobarras.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesocrearetiquetascodigobarras.setSucursal(procesocrearetiquetascodigobarrasDataAccess.getSucursal(connexion,procesocrearetiquetascodigobarras));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(procesocrearetiquetascodigobarras.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetascodigobarras.setLinea(procesocrearetiquetascodigobarrasDataAccess.getLinea(connexion,procesocrearetiquetascodigobarras));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocrearetiquetascodigobarras.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetascodigobarras.setLineaGrupo(procesocrearetiquetascodigobarrasDataAccess.getLineaGrupo(connexion,procesocrearetiquetascodigobarras));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocrearetiquetascodigobarras.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetascodigobarras.setLineaCategoria(procesocrearetiquetascodigobarrasDataAccess.getLineaCategoria(connexion,procesocrearetiquetascodigobarras));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocrearetiquetascodigobarras.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocrearetiquetascodigobarras.setLineaMarca(procesocrearetiquetascodigobarrasDataAccess.getLineaMarca(connexion,procesocrearetiquetascodigobarras));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocrearetiquetascodigobarras.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setBodega(procesocrearetiquetascodigobarrasDataAccess.getBodega(connexion,procesocrearetiquetascodigobarras));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(procesocrearetiquetascodigobarras.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setProducto(procesocrearetiquetascodigobarrasDataAccess.getProducto(connexion,procesocrearetiquetascodigobarras));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(procesocrearetiquetascodigobarras.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setEmpresa(procesocrearetiquetascodigobarrasDataAccess.getEmpresa(connexion,procesocrearetiquetascodigobarras));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(procesocrearetiquetascodigobarras.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setSucursal(procesocrearetiquetascodigobarrasDataAccess.getSucursal(connexion,procesocrearetiquetascodigobarras));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(procesocrearetiquetascodigobarras.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setLinea(procesocrearetiquetascodigobarrasDataAccess.getLinea(connexion,procesocrearetiquetascodigobarras));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocrearetiquetascodigobarras.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setLineaGrupo(procesocrearetiquetascodigobarrasDataAccess.getLineaGrupo(connexion,procesocrearetiquetascodigobarras));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocrearetiquetascodigobarras.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setLineaCategoria(procesocrearetiquetascodigobarrasDataAccess.getLineaCategoria(connexion,procesocrearetiquetascodigobarras));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocrearetiquetascodigobarras.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocrearetiquetascodigobarras.setLineaMarca(procesocrearetiquetascodigobarrasDataAccess.getLineaMarca(connexion,procesocrearetiquetascodigobarras));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocrearetiquetascodigobarras.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesocrearetiquetascodigobarras,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCrearEtiquetasCodigoBarras(procesocrearetiquetascodigobarras);
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
			this.deepLoad(this.procesocrearetiquetascodigobarras,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCrearEtiquetasCodigoBarras(this.procesocrearetiquetascodigobarras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocrearetiquetascodigobarrass!=null) {
				for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras:procesocrearetiquetascodigobarrass) {
					this.deepLoad(procesocrearetiquetascodigobarras,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCrearEtiquetasCodigoBarras(procesocrearetiquetascodigobarrass);
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
			if(procesocrearetiquetascodigobarrass!=null) {
				for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras:procesocrearetiquetascodigobarrass) {
					this.deepLoad(procesocrearetiquetascodigobarras,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCrearEtiquetasCodigoBarras(procesocrearetiquetascodigobarrass);
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
	
	public ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral procesarAccionProcesoCrearEtiquetasCodigoBarrass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass,ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral procesocrearetiquetascodigobarrasParameterGeneral)throws Exception {
		 try {	
			ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral procesocrearetiquetascodigobarrasReturnGeneral=new ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral();
	
			ProcesoCrearEtiquetasCodigoBarrasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocrearetiquetascodigobarrass,procesocrearetiquetascodigobarrasParameterGeneral,procesocrearetiquetascodigobarrasReturnGeneral);
			
			return procesocrearetiquetascodigobarrasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral procesarAccionProcesoCrearEtiquetasCodigoBarrassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass,ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral procesocrearetiquetascodigobarrasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral procesocrearetiquetascodigobarrasReturnGeneral=new ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral();
	
			ProcesoCrearEtiquetasCodigoBarrasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocrearetiquetascodigobarrass,procesocrearetiquetascodigobarrasParameterGeneral,procesocrearetiquetascodigobarrasReturnGeneral);
			
			this.connexion.commit();
			
			return procesocrearetiquetascodigobarrasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

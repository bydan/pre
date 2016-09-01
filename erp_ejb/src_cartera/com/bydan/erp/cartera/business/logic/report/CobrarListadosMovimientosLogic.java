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
import com.bydan.erp.cartera.util.report.CobrarListadosMovimientosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarListadosMovimientosParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarListadosMovimientosConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarListadosMovimientos;

import com.bydan.erp.cartera.business.logic.report.CobrarListadosMovimientosLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarListadosMovimientosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarListadosMovimientosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarListadosMovimientosLogic cobrarlistadosmovimientosDataAccess; 		
	protected CobrarListadosMovimientos cobrarlistadosmovimientos;
	protected List<CobrarListadosMovimientos> cobrarlistadosmovimientoss;
	protected Object cobrarlistadosmovimientosObject;	
	protected List<Object> cobrarlistadosmovimientossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarListadosMovimientosLogic()throws SQLException,Exception {
		try	{
			this.cobrarlistadosmovimientoss= new ArrayList<CobrarListadosMovimientos>();
			this.cobrarlistadosmovimientos= new CobrarListadosMovimientos();
			this.cobrarlistadosmovimientosObject=new Object();
			this.cobrarlistadosmovimientossObject=new ArrayList<Object>();
			
			this.cobrarlistadosmovimientosDataAccess=this;
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
			this.cobrarlistadosmovimientosDataAccess.setConnexionType(this.connexionType);
			this.cobrarlistadosmovimientosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarlistadosmovimientosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarListadosMovimientosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarlistadosmovimientoss= new ArrayList<CobrarListadosMovimientos>();
			this.cobrarlistadosmovimientos= new CobrarListadosMovimientos();
			this.cobrarlistadosmovimientosObject=new Object();
			this.cobrarlistadosmovimientossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarlistadosmovimientosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarlistadosmovimientosDataAccess.setConnexionType(this.connexionType);
			this.cobrarlistadosmovimientosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarlistadosmovimientosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarListadosMovimientos getCobrarListadosMovimientos() throws Exception {	
		CobrarListadosMovimientosLogicAdditional.checkCobrarListadosMovimientosToGet(cobrarlistadosmovimientos,this.datosCliente,this.arrDatoGeneral);
		CobrarListadosMovimientosLogicAdditional.updateCobrarListadosMovimientosToGet(cobrarlistadosmovimientos,this.arrDatoGeneral);
		
		return cobrarlistadosmovimientos;
	}
		
	public void setCobrarListadosMovimientos(CobrarListadosMovimientos newCobrarListadosMovimientos) {
		this.cobrarlistadosmovimientos = newCobrarListadosMovimientos;
	}
	
	public List<CobrarListadosMovimientos> getCobrarListadosMovimientoss() throws Exception {		
		this.quitarCobrarListadosMovimientossNulos();
		
		CobrarListadosMovimientosLogicAdditional.checkCobrarListadosMovimientosToGets(cobrarlistadosmovimientoss,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarListadosMovimientos cobrarlistadosmovimientosLocal: cobrarlistadosmovimientoss ) {
			CobrarListadosMovimientosLogicAdditional.updateCobrarListadosMovimientosToGet(cobrarlistadosmovimientosLocal,this.arrDatoGeneral);
		}
		
		return cobrarlistadosmovimientoss;
	}
	
	public void setCobrarListadosMovimientoss(List<CobrarListadosMovimientos> newCobrarListadosMovimientoss) {
		this.cobrarlistadosmovimientoss = newCobrarListadosMovimientoss;
	}
	
	public Object getCobrarListadosMovimientosObject() {	
		//this.cobrarlistadosmovimientosObject=this.cobrarlistadosmovimientosDataAccess.getEntityObject();
		return this.cobrarlistadosmovimientosObject;
	}
		
	public void setCobrarListadosMovimientosObject(Object newCobrarListadosMovimientosObject) {
		this.cobrarlistadosmovimientosObject = newCobrarListadosMovimientosObject;
	}
	
	public List<Object> getCobrarListadosMovimientossObject() {		
		//this.cobrarlistadosmovimientossObject=this.cobrarlistadosmovimientosDataAccess.getEntitiesObject();
		return this.cobrarlistadosmovimientossObject;
	}
		
	public void setCobrarListadosMovimientossObject(List<Object> newCobrarListadosMovimientossObject) {
		this.cobrarlistadosmovimientossObject = newCobrarListadosMovimientossObject;
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
		cobrarlistadosmovimientoss = new  ArrayList<CobrarListadosMovimientos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarListadosMovimientosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarlistadosmovimientoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarlistadosmovimientoss = new  ArrayList<CobrarListadosMovimientos>();
		  		  
        try {
			//CobrarListadosMovimientosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarlistadosmovimientoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarlistadosmovimientoss = new  ArrayList<CobrarListadosMovimientos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarListadosMovimientosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarlistadosmovimientoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarlistadosmovimientoss = new  ArrayList<CobrarListadosMovimientos>();
		  		  
        try {
			//CobrarListadosMovimientosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarlistadosmovimientoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarlistadosmovimientoss = new  ArrayList<CobrarListadosMovimientos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarListadosMovimientosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarlistadosmovimientoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarlistadosmovimientoss = new  ArrayList<CobrarListadosMovimientos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarListadosMovimientosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarlistadosmovimientoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarListadosMovimientos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarListadosMovimientos> entities = new  ArrayList<CobrarListadosMovimientos>();
		CobrarListadosMovimientos entity = new CobrarListadosMovimientos();		  
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
	
	public  List<CobrarListadosMovimientos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarListadosMovimientos> entities = new  ArrayList<CobrarListadosMovimientos>();
		CobrarListadosMovimientos entity = new CobrarListadosMovimientos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarListadosMovimientos();
				
				
      	    	entity=CobrarListadosMovimientosLogic.getEntityCobrarListadosMovimientos("",entity,resultSet);
      	    	
				//entity.setCobrarListadosMovimientosOriginal( new CobrarListadosMovimientos());
      	    	//entity.setCobrarListadosMovimientosOriginal(super.getEntity("",entity.getCobrarListadosMovimientosOriginal(),resultSet,CobrarListadosMovimientosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarListadosMovimientosOriginal(CobrarListadosMovimientosDataAccess.getEntityCobrarListadosMovimientos("",entity.getCobrarListadosMovimientosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarListadosMovimientos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarListadosMovimientos> entities = new  ArrayList<CobrarListadosMovimientos>();
		CobrarListadosMovimientos entity = new CobrarListadosMovimientos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarListadosMovimientos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarListadosMovimientos>((List<CobrarListadosMovimientos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarListadosMovimientossOriginal(entities);
			
			}  else {
				this.cobrarlistadosmovimientossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarListadosMovimientosConstantesFunciones.quitarEspaciosCobrarListadosMovimientoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarListadosMovimientos getEntityCobrarListadosMovimientos(String strPrefijo,CobrarListadosMovimientos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarListadosMovimientosConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+CobrarListadosMovimientosConstantesFunciones.NOMBRECOMPLETO));
			entity.setnombre_transaccion(resultSet.getString(strPrefijo+CobrarListadosMovimientosConstantesFunciones.NOMBRETRANSACCION));
			entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+CobrarListadosMovimientosConstantesFunciones.FECHAVENCE).getTime()));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+CobrarListadosMovimientosConstantesFunciones.FECHAEMISION).getTime()));
			entity.setnumero_comprobante(resultSet.getString(strPrefijo+CobrarListadosMovimientosConstantesFunciones.NUMEROCOMPROBANTE));
			entity.setnumero_factura(resultSet.getString(strPrefijo+CobrarListadosMovimientosConstantesFunciones.NUMEROFACTURA));
			entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL));
			entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL));
			entity.setdescripcion(resultSet.getString(strPrefijo+CobrarListadosMovimientosConstantesFunciones.DESCRIPCION));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarListadosMovimientos getEntityCobrarListadosMovimientos(String strPrefijo,CobrarListadosMovimientos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarListadosMovimientos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarListadosMovimientos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarListadosMovimientosLogic.setFieldReflectionCobrarListadosMovimientos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarListadosMovimientos(Field field,String strPrefijo,String sColumn,CobrarListadosMovimientos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarListadosMovimientosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarListadosMovimientosConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarListadosMovimientosConstantesFunciones.NOMBRETRANSACCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarListadosMovimientosConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarListadosMovimientosConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarListadosMovimientosConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarListadosMovimientosConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarListadosMovimientosConstantesFunciones.DESCRIPCION:
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
	
	public void quitarCobrarListadosMovimientossNulos() throws Exception {				
		
		List<CobrarListadosMovimientos> cobrarlistadosmovimientossAux= new ArrayList<CobrarListadosMovimientos>();
		
		for(CobrarListadosMovimientos cobrarlistadosmovimientos:cobrarlistadosmovimientoss) {
			if(cobrarlistadosmovimientos!=null) {
				cobrarlistadosmovimientossAux.add(cobrarlistadosmovimientos);
			}
		}
		
		cobrarlistadosmovimientoss=cobrarlistadosmovimientossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarListadosMovimientos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarListadosMovimientos> entities = new  ArrayList<CobrarListadosMovimientos>();
		CobrarListadosMovimientos entity = new CobrarListadosMovimientos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarListadosMovimientos>((List<CobrarListadosMovimientos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarListadosMovimientossOriginal(entities);
			
			}  else {
				this.cobrarlistadosmovimientossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarListadosMovimientosConstantesFunciones.quitarEspaciosCobrarListadosMovimientoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarlistadosmovimientoss = new  ArrayList<CobrarListadosMovimientos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarListadosMovimientosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarlistadosmovimientoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarlistadosmovimientoss = new  ArrayList<CobrarListadosMovimientos>();
		  		  
        try {
			//CobrarListadosMovimientosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarlistadosmovimientoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarListadosMovimientos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarListadosMovimientos> entities = new  ArrayList<CobrarListadosMovimientos>();
		CobrarListadosMovimientos entity = new CobrarListadosMovimientos();		  
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
	
	public  List<CobrarListadosMovimientos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarListadosMovimientos> entities = new  ArrayList<CobrarListadosMovimientos>();
		CobrarListadosMovimientos entity = new CobrarListadosMovimientos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarListadosMovimientos();
				
				if(conMapGenerico) {
					entity.setMapCobrarListadosMovimientos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarListadosMovimientos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarListadosMovimientosDataAccess.ISWITHSCHEMA);         		
					entity=CobrarListadosMovimientosLogic.getEntityCobrarListadosMovimientos("",entity,resultSet,listColumns);
					
					////entity.setCobrarListadosMovimientosOriginal( new CobrarListadosMovimientos());
					////entity.setCobrarListadosMovimientosOriginal(super.getEntity("",entity.getCobrarListadosMovimientosOriginal(),resultSet,CobrarListadosMovimientosDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarListadosMovimientosOriginal(CobrarListadosMovimientosDataAccess.getEntityCobrarListadosMovimientos("",entity.getCobrarListadosMovimientosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarListadosMovimientos relcobrarlistadosmovimientos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarlistadosmovimientos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getCobrarListadosMovimientossBusquedaCobrarListadosMovimientosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//CobrarListadosMovimientosLogic cobrarlistadosmovimientosLogic=new CobrarListadosMovimientosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarListadosMovimientosLogic.GetSelecSqlCobrarListadosMovimientos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarlistadosmovimientoss=this.getCobrarListadosMovimientoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarListadosMovimientossBusquedaCobrarListadosMovimientos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//CobrarListadosMovimientosLogic cobrarlistadosmovimientosLogic=new CobrarListadosMovimientosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarListadosMovimientosLogic.GetSelecSqlCobrarListadosMovimientos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarlistadosmovimientoss=this.getCobrarListadosMovimientoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarListadosMovimientos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarListadosMovimientos_Postgres.sql");
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
				

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
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
	
	
	public void deepLoad(CobrarListadosMovimientos cobrarlistadosmovimientos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarListadosMovimientosLogicAdditional.updateCobrarListadosMovimientosToGet(cobrarlistadosmovimientos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarlistadosmovimientos.setEmpresa(cobrarlistadosmovimientosDataAccess.getEmpresa(connexion,cobrarlistadosmovimientos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarlistadosmovimientos.setEmpresa(cobrarlistadosmovimientosDataAccess.getEmpresa(connexion,cobrarlistadosmovimientos));
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
			cobrarlistadosmovimientos.setEmpresa(cobrarlistadosmovimientosDataAccess.getEmpresa(connexion,cobrarlistadosmovimientos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarlistadosmovimientos.setEmpresa(cobrarlistadosmovimientosDataAccess.getEmpresa(connexion,cobrarlistadosmovimientos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarlistadosmovimientos.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarlistadosmovimientos.setEmpresa(cobrarlistadosmovimientosDataAccess.getEmpresa(connexion,cobrarlistadosmovimientos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarlistadosmovimientos.getEmpresa(),isDeep,deepLoadType,clases);				
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
			cobrarlistadosmovimientos.setEmpresa(cobrarlistadosmovimientosDataAccess.getEmpresa(connexion,cobrarlistadosmovimientos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarlistadosmovimientos.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarlistadosmovimientos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarListadosMovimientosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarListadosMovimientos(cobrarlistadosmovimientos);
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
			this.deepLoad(this.cobrarlistadosmovimientos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarListadosMovimientosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarListadosMovimientos(this.cobrarlistadosmovimientos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarlistadosmovimientoss!=null) {
				for(CobrarListadosMovimientos cobrarlistadosmovimientos:cobrarlistadosmovimientoss) {
					this.deepLoad(cobrarlistadosmovimientos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarListadosMovimientosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarListadosMovimientos(cobrarlistadosmovimientoss);
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
			if(cobrarlistadosmovimientoss!=null) {
				for(CobrarListadosMovimientos cobrarlistadosmovimientos:cobrarlistadosmovimientoss) {
					this.deepLoad(cobrarlistadosmovimientos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarListadosMovimientosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarListadosMovimientos(cobrarlistadosmovimientoss);
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
	
	public CobrarListadosMovimientosParameterReturnGeneral procesarAccionCobrarListadosMovimientoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,CobrarListadosMovimientosParameterReturnGeneral cobrarlistadosmovimientosParameterGeneral)throws Exception {
		 try {	
			CobrarListadosMovimientosParameterReturnGeneral cobrarlistadosmovimientosReturnGeneral=new CobrarListadosMovimientosParameterReturnGeneral();
	
			CobrarListadosMovimientosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarlistadosmovimientoss,cobrarlistadosmovimientosParameterGeneral,cobrarlistadosmovimientosReturnGeneral);
			
			return cobrarlistadosmovimientosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarListadosMovimientosParameterReturnGeneral procesarAccionCobrarListadosMovimientossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,CobrarListadosMovimientosParameterReturnGeneral cobrarlistadosmovimientosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarListadosMovimientosParameterReturnGeneral cobrarlistadosmovimientosReturnGeneral=new CobrarListadosMovimientosParameterReturnGeneral();
	
			CobrarListadosMovimientosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarlistadosmovimientoss,cobrarlistadosmovimientosParameterGeneral,cobrarlistadosmovimientosReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarlistadosmovimientosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

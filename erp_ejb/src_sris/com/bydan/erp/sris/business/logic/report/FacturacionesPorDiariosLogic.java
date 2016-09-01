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
package com.bydan.erp.sris.business.logic.report;

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

import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.resources.general.AuxiliarGeneral;
import com.bydan.erp.sris.util.report.FacturacionesPorDiariosParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.FacturacionesPorDiariosParameterGeneral;
import com.bydan.erp.sris.util.report.FacturacionesPorDiariosConstantesFunciones;
import com.bydan.erp.sris.business.entity.report.FacturacionesPorDiarios;

import com.bydan.erp.sris.business.logic.report.FacturacionesPorDiariosLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class FacturacionesPorDiariosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(FacturacionesPorDiariosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected FacturacionesPorDiariosLogic facturacionespordiariosDataAccess; 		
	protected FacturacionesPorDiarios facturacionespordiarios;
	protected List<FacturacionesPorDiarios> facturacionespordiarioss;
	protected Object facturacionespordiariosObject;	
	protected List<Object> facturacionespordiariossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  FacturacionesPorDiariosLogic()throws SQLException,Exception {
		try	{
			this.facturacionespordiarioss= new ArrayList<FacturacionesPorDiarios>();
			this.facturacionespordiarios= new FacturacionesPorDiarios();
			this.facturacionespordiariosObject=new Object();
			this.facturacionespordiariossObject=new ArrayList<Object>();
			
			this.facturacionespordiariosDataAccess=this;
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
			this.facturacionespordiariosDataAccess.setConnexionType(this.connexionType);
			this.facturacionespordiariosDataAccess.setParameterDbType(this.parameterDbType);
			this.facturacionespordiariosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturacionesPorDiariosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.facturacionespordiarioss= new ArrayList<FacturacionesPorDiarios>();
			this.facturacionespordiarios= new FacturacionesPorDiarios();
			this.facturacionespordiariosObject=new Object();
			this.facturacionespordiariossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.facturacionespordiariosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.facturacionespordiariosDataAccess.setConnexionType(this.connexionType);
			this.facturacionespordiariosDataAccess.setParameterDbType(this.parameterDbType);
			this.facturacionespordiariosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FacturacionesPorDiarios getFacturacionesPorDiarios() throws Exception {	
		FacturacionesPorDiariosLogicAdditional.checkFacturacionesPorDiariosToGet(facturacionespordiarios,this.datosCliente,this.arrDatoGeneral);
		FacturacionesPorDiariosLogicAdditional.updateFacturacionesPorDiariosToGet(facturacionespordiarios,this.arrDatoGeneral);
		
		return facturacionespordiarios;
	}
		
	public void setFacturacionesPorDiarios(FacturacionesPorDiarios newFacturacionesPorDiarios) {
		this.facturacionespordiarios = newFacturacionesPorDiarios;
	}
	
	public List<FacturacionesPorDiarios> getFacturacionesPorDiarioss() throws Exception {		
		this.quitarFacturacionesPorDiariossNulos();
		
		FacturacionesPorDiariosLogicAdditional.checkFacturacionesPorDiariosToGets(facturacionespordiarioss,this.datosCliente,this.arrDatoGeneral);
		
		for (FacturacionesPorDiarios facturacionespordiariosLocal: facturacionespordiarioss ) {
			FacturacionesPorDiariosLogicAdditional.updateFacturacionesPorDiariosToGet(facturacionespordiariosLocal,this.arrDatoGeneral);
		}
		
		return facturacionespordiarioss;
	}
	
	public void setFacturacionesPorDiarioss(List<FacturacionesPorDiarios> newFacturacionesPorDiarioss) {
		this.facturacionespordiarioss = newFacturacionesPorDiarioss;
	}
	
	public Object getFacturacionesPorDiariosObject() {	
		//this.facturacionespordiariosObject=this.facturacionespordiariosDataAccess.getEntityObject();
		return this.facturacionespordiariosObject;
	}
		
	public void setFacturacionesPorDiariosObject(Object newFacturacionesPorDiariosObject) {
		this.facturacionespordiariosObject = newFacturacionesPorDiariosObject;
	}
	
	public List<Object> getFacturacionesPorDiariossObject() {		
		//this.facturacionespordiariossObject=this.facturacionespordiariosDataAccess.getEntitiesObject();
		return this.facturacionespordiariossObject;
	}
		
	public void setFacturacionesPorDiariossObject(List<Object> newFacturacionesPorDiariossObject) {
		this.facturacionespordiariossObject = newFacturacionesPorDiariossObject;
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
		facturacionespordiarioss = new  ArrayList<FacturacionesPorDiarios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturacionesPorDiariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturacionespordiarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		facturacionespordiarioss = new  ArrayList<FacturacionesPorDiarios>();
		  		  
        try {
			//FacturacionesPorDiariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturacionespordiarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturacionespordiarioss = new  ArrayList<FacturacionesPorDiarios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturacionesPorDiariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturacionespordiarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		facturacionespordiarioss = new  ArrayList<FacturacionesPorDiarios>();
		  		  
        try {
			//FacturacionesPorDiariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturacionespordiarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		facturacionespordiarioss = new  ArrayList<FacturacionesPorDiarios>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturacionesPorDiariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturacionespordiarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		facturacionespordiarioss = new  ArrayList<FacturacionesPorDiarios>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//FacturacionesPorDiariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturacionespordiarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<FacturacionesPorDiarios> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturacionesPorDiarios> entities = new  ArrayList<FacturacionesPorDiarios>();
		FacturacionesPorDiarios entity = new FacturacionesPorDiarios();		  
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
	
	public  List<FacturacionesPorDiarios> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturacionesPorDiarios> entities = new  ArrayList<FacturacionesPorDiarios>();
		FacturacionesPorDiarios entity = new FacturacionesPorDiarios();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturacionesPorDiarios();
				
				
      	    	entity=FacturacionesPorDiariosLogic.getEntityFacturacionesPorDiarios("",entity,resultSet);
      	    	
				//entity.setFacturacionesPorDiariosOriginal( new FacturacionesPorDiarios());
      	    	//entity.setFacturacionesPorDiariosOriginal(super.getEntity("",entity.getFacturacionesPorDiariosOriginal(),resultSet,FacturacionesPorDiariosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturacionesPorDiariosOriginal(FacturacionesPorDiariosDataAccess.getEntityFacturacionesPorDiarios("",entity.getFacturacionesPorDiariosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<FacturacionesPorDiarios> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturacionesPorDiarios> entities = new  ArrayList<FacturacionesPorDiarios>();
		FacturacionesPorDiarios entity = new FacturacionesPorDiarios();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,FacturacionesPorDiarios.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<FacturacionesPorDiarios>((List<FacturacionesPorDiarios>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setFacturacionesPorDiariossOriginal(entities);
			
			}  else {
				this.facturacionespordiariossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//FacturacionesPorDiariosConstantesFunciones.quitarEspaciosFacturacionesPorDiarioss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static FacturacionesPorDiarios getEntityFacturacionesPorDiarios(String strPrefijo,FacturacionesPorDiarios entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+FacturacionesPorDiariosConstantesFunciones.FECHAEMISION).getTime()));
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+FacturacionesPorDiariosConstantesFunciones.NOMBRESUCURSAL));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+FacturacionesPorDiariosConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+FacturacionesPorDiariosConstantesFunciones.IDTIPOTRANSACCIONMODULO));
			entity.setcodigo_asiento_contable(resultSet.getString(strPrefijo+FacturacionesPorDiariosConstantesFunciones.CODIGOASIENTOCONTABLE));
			entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+FacturacionesPorDiariosConstantesFunciones.FECHAVENCE).getTime()));
			entity.setfecha_emision_detalle_cliente(new Date(resultSet.getDate(strPrefijo+FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDETALLECLIENTE).getTime()));
			entity.setmonto_mone_local(resultSet.getDouble(strPrefijo+FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL));
			entity.setnumero_factura(resultSet.getString(strPrefijo+FacturacionesPorDiariosConstantesFunciones.NUMEROFACTURA));
			entity.setruc_cliente(resultSet.getString(strPrefijo+FacturacionesPorDiariosConstantesFunciones.RUCCLIENTE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FacturacionesPorDiarios getEntityFacturacionesPorDiarios(String strPrefijo,FacturacionesPorDiarios entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = FacturacionesPorDiarios.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = FacturacionesPorDiarios.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				FacturacionesPorDiariosLogic.setFieldReflectionFacturacionesPorDiarios(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFacturacionesPorDiarios(Field field,String strPrefijo,String sColumn,FacturacionesPorDiarios entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturacionesPorDiariosConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturacionesPorDiariosConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturacionesPorDiariosConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturacionesPorDiariosConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturacionesPorDiariosConstantesFunciones.CODIGOASIENTOCONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturacionesPorDiariosConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDETALLECLIENTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturacionesPorDiariosConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturacionesPorDiariosConstantesFunciones.RUCCLIENTE:
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
	
	public void quitarFacturacionesPorDiariossNulos() throws Exception {				
		
		List<FacturacionesPorDiarios> facturacionespordiariossAux= new ArrayList<FacturacionesPorDiarios>();
		
		for(FacturacionesPorDiarios facturacionespordiarios:facturacionespordiarioss) {
			if(facturacionespordiarios!=null) {
				facturacionespordiariossAux.add(facturacionespordiarios);
			}
		}
		
		facturacionespordiarioss=facturacionespordiariossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<FacturacionesPorDiarios> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturacionesPorDiarios> entities = new  ArrayList<FacturacionesPorDiarios>();
		FacturacionesPorDiarios entity = new FacturacionesPorDiarios();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<FacturacionesPorDiarios>((List<FacturacionesPorDiarios>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setFacturacionesPorDiariossOriginal(entities);
			
			}  else {
				this.facturacionespordiariossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//FacturacionesPorDiariosConstantesFunciones.quitarEspaciosFacturacionesPorDiarioss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		facturacionespordiarioss = new  ArrayList<FacturacionesPorDiarios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturacionesPorDiariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturacionespordiarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		facturacionespordiarioss = new  ArrayList<FacturacionesPorDiarios>();
		  		  
        try {
			//FacturacionesPorDiariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturacionespordiarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<FacturacionesPorDiarios> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturacionesPorDiarios> entities = new  ArrayList<FacturacionesPorDiarios>();
		FacturacionesPorDiarios entity = new FacturacionesPorDiarios();		  
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
	
	public  List<FacturacionesPorDiarios> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturacionesPorDiarios> entities = new  ArrayList<FacturacionesPorDiarios>();
		FacturacionesPorDiarios entity = new FacturacionesPorDiarios();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturacionesPorDiarios();
				
				if(conMapGenerico) {
					entity.setMapFacturacionesPorDiarios( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapFacturacionesPorDiarios().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturacionesPorDiariosDataAccess.ISWITHSCHEMA);         		
					entity=FacturacionesPorDiariosLogic.getEntityFacturacionesPorDiarios("",entity,resultSet,listColumns);
					
					////entity.setFacturacionesPorDiariosOriginal( new FacturacionesPorDiarios());
					////entity.setFacturacionesPorDiariosOriginal(super.getEntity("",entity.getFacturacionesPorDiariosOriginal(),resultSet,FacturacionesPorDiariosDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturacionesPorDiariosOriginal(FacturacionesPorDiariosDataAccess.getEntityFacturacionesPorDiarios("",entity.getFacturacionesPorDiariosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,FacturacionesPorDiarios relfacturacionespordiarios)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relfacturacionespordiarios.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Transaccion getTransaccion(Connexion connexion,FacturacionesPorDiarios relfacturacionespordiarios)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);
			transaccionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			transaccion=transaccionDataAccess.getEntity(connexion,relfacturacionespordiarios.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,FacturacionesPorDiarios relfacturacionespordiarios)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);
			tipotransaccionmoduloDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,relfacturacionespordiarios.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}


	
	
	public void getFacturacionesPorDiariossBusquedaFacturacionesPorDiariosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//FacturacionesPorDiariosLogic facturacionespordiariosLogic=new FacturacionesPorDiariosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=FacturacionesPorDiariosLogic.GetSelecSqlFacturacionesPorDiarios(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_transaccion,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.facturacionespordiarioss=this.getFacturacionesPorDiarioss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getFacturacionesPorDiariossBusquedaFacturacionesPorDiarios(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//FacturacionesPorDiariosLogic facturacionespordiariosLogic=new FacturacionesPorDiariosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=FacturacionesPorDiariosLogic.GetSelecSqlFacturacionesPorDiarios(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_transaccion,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.facturacionespordiarioss=this.getFacturacionesPorDiarioss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlFacturacionesPorDiarios(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("FacturacionesPorDiarios_Postgres.sql");
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
				

				if(id_transaccion!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_transaccion = "+id_transaccion.toString();
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
	
	
	public void deepLoad(FacturacionesPorDiarios facturacionespordiarios,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturacionesPorDiariosLogicAdditional.updateFacturacionesPorDiariosToGet(facturacionespordiarios,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturacionespordiarios.setEmpresa(facturacionespordiariosDataAccess.getEmpresa(connexion,facturacionespordiarios));
		facturacionespordiarios.setTransaccion(facturacionespordiariosDataAccess.getTransaccion(connexion,facturacionespordiarios));
		facturacionespordiarios.setTipoTransaccionModulo(facturacionespordiariosDataAccess.getTipoTransaccionModulo(connexion,facturacionespordiarios));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturacionespordiarios.setEmpresa(facturacionespordiariosDataAccess.getEmpresa(connexion,facturacionespordiarios));
			}

			if(clas.clas.equals(Transaccion.class)) {
				facturacionespordiarios.setTransaccion(facturacionespordiariosDataAccess.getTransaccion(connexion,facturacionespordiarios));
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				facturacionespordiarios.setTipoTransaccionModulo(facturacionespordiariosDataAccess.getTipoTransaccionModulo(connexion,facturacionespordiarios));
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
			facturacionespordiarios.setEmpresa(facturacionespordiariosDataAccess.getEmpresa(connexion,facturacionespordiarios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturacionespordiarios.setTransaccion(facturacionespordiariosDataAccess.getTransaccion(connexion,facturacionespordiarios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturacionespordiarios.setTipoTransaccionModulo(facturacionespordiariosDataAccess.getTipoTransaccionModulo(connexion,facturacionespordiarios));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturacionespordiarios.setEmpresa(facturacionespordiariosDataAccess.getEmpresa(connexion,facturacionespordiarios));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturacionespordiarios.getEmpresa(),isDeep,deepLoadType,clases);
				
		facturacionespordiarios.setTransaccion(facturacionespordiariosDataAccess.getTransaccion(connexion,facturacionespordiarios));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(facturacionespordiarios.getTransaccion(),isDeep,deepLoadType,clases);
				
		facturacionespordiarios.setTipoTransaccionModulo(facturacionespordiariosDataAccess.getTipoTransaccionModulo(connexion,facturacionespordiarios));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(facturacionespordiarios.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturacionespordiarios.setEmpresa(facturacionespordiariosDataAccess.getEmpresa(connexion,facturacionespordiarios));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(facturacionespordiarios.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Transaccion.class)) {
				facturacionespordiarios.setTransaccion(facturacionespordiariosDataAccess.getTransaccion(connexion,facturacionespordiarios));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(facturacionespordiarios.getTransaccion(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				facturacionespordiarios.setTipoTransaccionModulo(facturacionespordiariosDataAccess.getTipoTransaccionModulo(connexion,facturacionespordiarios));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(facturacionespordiarios.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
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
			facturacionespordiarios.setEmpresa(facturacionespordiariosDataAccess.getEmpresa(connexion,facturacionespordiarios));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(facturacionespordiarios.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturacionespordiarios.setTransaccion(facturacionespordiariosDataAccess.getTransaccion(connexion,facturacionespordiarios));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(facturacionespordiarios.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturacionespordiarios.setTipoTransaccionModulo(facturacionespordiariosDataAccess.getTipoTransaccionModulo(connexion,facturacionespordiarios));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(facturacionespordiarios.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(facturacionespordiarios,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturacionesPorDiariosConstantesFunciones.refrescarForeignKeysDescripcionesFacturacionesPorDiarios(facturacionespordiarios);
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
			this.deepLoad(this.facturacionespordiarios,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturacionesPorDiariosConstantesFunciones.refrescarForeignKeysDescripcionesFacturacionesPorDiarios(this.facturacionespordiarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(facturacionespordiarioss!=null) {
				for(FacturacionesPorDiarios facturacionespordiarios:facturacionespordiarioss) {
					this.deepLoad(facturacionespordiarios,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturacionesPorDiariosConstantesFunciones.refrescarForeignKeysDescripcionesFacturacionesPorDiarios(facturacionespordiarioss);
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
			if(facturacionespordiarioss!=null) {
				for(FacturacionesPorDiarios facturacionespordiarios:facturacionespordiarioss) {
					this.deepLoad(facturacionespordiarios,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturacionesPorDiariosConstantesFunciones.refrescarForeignKeysDescripcionesFacturacionesPorDiarios(facturacionespordiarioss);
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
	
	public FacturacionesPorDiariosParameterReturnGeneral procesarAccionFacturacionesPorDiarioss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturacionesPorDiarios> facturacionespordiarioss,FacturacionesPorDiariosParameterReturnGeneral facturacionespordiariosParameterGeneral)throws Exception {
		 try {	
			FacturacionesPorDiariosParameterReturnGeneral facturacionespordiariosReturnGeneral=new FacturacionesPorDiariosParameterReturnGeneral();
	
			FacturacionesPorDiariosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturacionespordiarioss,facturacionespordiariosParameterGeneral,facturacionespordiariosReturnGeneral);
			
			return facturacionespordiariosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturacionesPorDiariosParameterReturnGeneral procesarAccionFacturacionesPorDiariossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturacionesPorDiarios> facturacionespordiarioss,FacturacionesPorDiariosParameterReturnGeneral facturacionespordiariosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			FacturacionesPorDiariosParameterReturnGeneral facturacionespordiariosReturnGeneral=new FacturacionesPorDiariosParameterReturnGeneral();
	
			FacturacionesPorDiariosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturacionespordiarioss,facturacionespordiariosParameterGeneral,facturacionespordiariosReturnGeneral);
			
			this.connexion.commit();
			
			return facturacionespordiariosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

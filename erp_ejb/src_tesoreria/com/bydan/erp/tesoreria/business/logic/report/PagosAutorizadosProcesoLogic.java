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
import com.bydan.erp.tesoreria.util.report.PagosAutorizadosProcesoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.PagosAutorizadosProcesoParameterGeneral;
import com.bydan.erp.tesoreria.util.report.PagosAutorizadosProcesoConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.PagosAutorizadosProceso;

import com.bydan.erp.tesoreria.business.logic.report.PagosAutorizadosProcesoLogicAdditional;
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
public class PagosAutorizadosProcesoLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(PagosAutorizadosProcesoLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected PagosAutorizadosProcesoLogic pagosautorizadosprocesoDataAccess; 		
	protected PagosAutorizadosProceso pagosautorizadosproceso;
	protected List<PagosAutorizadosProceso> pagosautorizadosprocesos;
	protected Object pagosautorizadosprocesoObject;	
	protected List<Object> pagosautorizadosprocesosObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  PagosAutorizadosProcesoLogic()throws SQLException,Exception {
		try	{
			this.pagosautorizadosprocesos= new ArrayList<PagosAutorizadosProceso>();
			this.pagosautorizadosproceso= new PagosAutorizadosProceso();
			this.pagosautorizadosprocesoObject=new Object();
			this.pagosautorizadosprocesosObject=new ArrayList<Object>();
			
			this.pagosautorizadosprocesoDataAccess=this;
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
			this.pagosautorizadosprocesoDataAccess.setConnexionType(this.connexionType);
			this.pagosautorizadosprocesoDataAccess.setParameterDbType(this.parameterDbType);
			this.pagosautorizadosprocesoDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PagosAutorizadosProcesoLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.pagosautorizadosprocesos= new ArrayList<PagosAutorizadosProceso>();
			this.pagosautorizadosproceso= new PagosAutorizadosProceso();
			this.pagosautorizadosprocesoObject=new Object();
			this.pagosautorizadosprocesosObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.pagosautorizadosprocesoDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.pagosautorizadosprocesoDataAccess.setConnexionType(this.connexionType);
			this.pagosautorizadosprocesoDataAccess.setParameterDbType(this.parameterDbType);
			this.pagosautorizadosprocesoDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PagosAutorizadosProceso getPagosAutorizadosProceso() throws Exception {	
		PagosAutorizadosProcesoLogicAdditional.checkPagosAutorizadosProcesoToGet(pagosautorizadosproceso,this.datosCliente,this.arrDatoGeneral);
		PagosAutorizadosProcesoLogicAdditional.updatePagosAutorizadosProcesoToGet(pagosautorizadosproceso,this.arrDatoGeneral);
		
		return pagosautorizadosproceso;
	}
		
	public void setPagosAutorizadosProceso(PagosAutorizadosProceso newPagosAutorizadosProceso) {
		this.pagosautorizadosproceso = newPagosAutorizadosProceso;
	}
	
	public List<PagosAutorizadosProceso> getPagosAutorizadosProcesos() throws Exception {		
		this.quitarPagosAutorizadosProcesosNulos();
		
		PagosAutorizadosProcesoLogicAdditional.checkPagosAutorizadosProcesoToGets(pagosautorizadosprocesos,this.datosCliente,this.arrDatoGeneral);
		
		for (PagosAutorizadosProceso pagosautorizadosprocesoLocal: pagosautorizadosprocesos ) {
			PagosAutorizadosProcesoLogicAdditional.updatePagosAutorizadosProcesoToGet(pagosautorizadosprocesoLocal,this.arrDatoGeneral);
		}
		
		return pagosautorizadosprocesos;
	}
	
	public void setPagosAutorizadosProcesos(List<PagosAutorizadosProceso> newPagosAutorizadosProcesos) {
		this.pagosautorizadosprocesos = newPagosAutorizadosProcesos;
	}
	
	public Object getPagosAutorizadosProcesoObject() {	
		//this.pagosautorizadosprocesoObject=this.pagosautorizadosprocesoDataAccess.getEntityObject();
		return this.pagosautorizadosprocesoObject;
	}
		
	public void setPagosAutorizadosProcesoObject(Object newPagosAutorizadosProcesoObject) {
		this.pagosautorizadosprocesoObject = newPagosAutorizadosProcesoObject;
	}
	
	public List<Object> getPagosAutorizadosProcesosObject() {		
		//this.pagosautorizadosprocesosObject=this.pagosautorizadosprocesoDataAccess.getEntitiesObject();
		return this.pagosautorizadosprocesosObject;
	}
		
	public void setPagosAutorizadosProcesosObject(List<Object> newPagosAutorizadosProcesosObject) {
		this.pagosautorizadosprocesosObject = newPagosAutorizadosProcesosObject;
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
		pagosautorizadosprocesos = new  ArrayList<PagosAutorizadosProceso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosAutorizadosProcesoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadosprocesos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		pagosautorizadosprocesos = new  ArrayList<PagosAutorizadosProceso>();
		  		  
        try {
			//PagosAutorizadosProcesoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadosprocesos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pagosautorizadosprocesos = new  ArrayList<PagosAutorizadosProceso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosAutorizadosProcesoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadosprocesos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		pagosautorizadosprocesos = new  ArrayList<PagosAutorizadosProceso>();
		  		  
        try {
			//PagosAutorizadosProcesoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadosprocesos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		pagosautorizadosprocesos = new  ArrayList<PagosAutorizadosProceso>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosAutorizadosProcesoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadosprocesos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		pagosautorizadosprocesos = new  ArrayList<PagosAutorizadosProceso>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//PagosAutorizadosProcesoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadosprocesos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<PagosAutorizadosProceso> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosAutorizadosProceso> entities = new  ArrayList<PagosAutorizadosProceso>();
		PagosAutorizadosProceso entity = new PagosAutorizadosProceso();		  
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
	
	public  List<PagosAutorizadosProceso> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosAutorizadosProceso> entities = new  ArrayList<PagosAutorizadosProceso>();
		PagosAutorizadosProceso entity = new PagosAutorizadosProceso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagosAutorizadosProceso();
				
				
      	    	entity=PagosAutorizadosProcesoLogic.getEntityPagosAutorizadosProceso("",entity,resultSet);
      	    	
				//entity.setPagosAutorizadosProcesoOriginal( new PagosAutorizadosProceso());
      	    	//entity.setPagosAutorizadosProcesoOriginal(super.getEntity("",entity.getPagosAutorizadosProcesoOriginal(),resultSet,PagosAutorizadosProcesoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPagosAutorizadosProcesoOriginal(PagosAutorizadosProcesoDataAccess.getEntityPagosAutorizadosProceso("",entity.getPagosAutorizadosProcesoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<PagosAutorizadosProceso> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosAutorizadosProceso> entities = new  ArrayList<PagosAutorizadosProceso>();
		PagosAutorizadosProceso entity = new PagosAutorizadosProceso();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,PagosAutorizadosProceso.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PagosAutorizadosProceso>((List<PagosAutorizadosProceso>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPagosAutorizadosProcesosOriginal(entities);
			
			}  else {
				this.pagosautorizadosprocesosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PagosAutorizadosProcesoConstantesFunciones.quitarEspaciosPagosAutorizadosProcesos(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static PagosAutorizadosProceso getEntityPagosAutorizadosProceso(String strPrefijo,PagosAutorizadosProceso entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_tipo_documento(resultSet.getString(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.NOMBRETIPODOCUMENTO));
			entity.setcodigo(resultSet.getString(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.CODIGO));
			entity.setbeneficiario(resultSet.getString(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIO));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.FECHA).getTime()));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.FECHAEMISION).getTime()));
			entity.setcodigo_tipo_movimiento_modulo(resultSet.getString(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.CODIGOTIPOMOVIMIENTOMODULO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.NUMEROMAYOR));
			entity.setvalor(resultSet.getDouble(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.VALOR));
			entity.setcodigo_cuenta_banco(resultSet.getString(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.CODIGOCUENTABANCO));
			entity.setnumero_cheque(resultSet.getString(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.NUMEROCHEQUE));
			entity.setbeneficiario_detalle_cheque_girado(resultSet.getString(strPrefijo+PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIODETALLECHEQUEGIRADO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PagosAutorizadosProceso getEntityPagosAutorizadosProceso(String strPrefijo,PagosAutorizadosProceso entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = PagosAutorizadosProceso.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = PagosAutorizadosProceso.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				PagosAutorizadosProcesoLogic.setFieldReflectionPagosAutorizadosProceso(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPagosAutorizadosProceso(Field field,String strPrefijo,String sColumn,PagosAutorizadosProceso entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PagosAutorizadosProcesoConstantesFunciones.NOMBRETIPODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.CODIGOTIPOMOVIMIENTOMODULO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.CODIGOCUENTABANCO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIODETALLECHEQUEGIRADO:
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
	
	public void quitarPagosAutorizadosProcesosNulos() throws Exception {				
		
		List<PagosAutorizadosProceso> pagosautorizadosprocesosAux= new ArrayList<PagosAutorizadosProceso>();
		
		for(PagosAutorizadosProceso pagosautorizadosproceso:pagosautorizadosprocesos) {
			if(pagosautorizadosproceso!=null) {
				pagosautorizadosprocesosAux.add(pagosautorizadosproceso);
			}
		}
		
		pagosautorizadosprocesos=pagosautorizadosprocesosAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<PagosAutorizadosProceso> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosAutorizadosProceso> entities = new  ArrayList<PagosAutorizadosProceso>();
		PagosAutorizadosProceso entity = new PagosAutorizadosProceso();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PagosAutorizadosProceso>((List<PagosAutorizadosProceso>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPagosAutorizadosProcesosOriginal(entities);
			
			}  else {
				this.pagosautorizadosprocesosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PagosAutorizadosProcesoConstantesFunciones.quitarEspaciosPagosAutorizadosProcesos(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		pagosautorizadosprocesos = new  ArrayList<PagosAutorizadosProceso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosAutorizadosProcesoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadosprocesos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		pagosautorizadosprocesos = new  ArrayList<PagosAutorizadosProceso>();
		  		  
        try {
			//PagosAutorizadosProcesoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadosprocesos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<PagosAutorizadosProceso> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PagosAutorizadosProceso> entities = new  ArrayList<PagosAutorizadosProceso>();
		PagosAutorizadosProceso entity = new PagosAutorizadosProceso();		  
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
	
	public  List<PagosAutorizadosProceso> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PagosAutorizadosProceso> entities = new  ArrayList<PagosAutorizadosProceso>();
		PagosAutorizadosProceso entity = new PagosAutorizadosProceso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagosAutorizadosProceso();
				
				if(conMapGenerico) {
					entity.setMapPagosAutorizadosProceso( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapPagosAutorizadosProceso().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PagosAutorizadosProcesoDataAccess.ISWITHSCHEMA);         		
					entity=PagosAutorizadosProcesoLogic.getEntityPagosAutorizadosProceso("",entity,resultSet,listColumns);
					
					////entity.setPagosAutorizadosProcesoOriginal( new PagosAutorizadosProceso());
					////entity.setPagosAutorizadosProcesoOriginal(super.getEntity("",entity.getPagosAutorizadosProcesoOriginal(),resultSet,PagosAutorizadosProcesoDataAccess.ISWITHSCHEMA));         		
					////entity.setPagosAutorizadosProcesoOriginal(PagosAutorizadosProcesoDataAccess.getEntityPagosAutorizadosProceso("",entity.getPagosAutorizadosProcesoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,PagosAutorizadosProceso relpagosautorizadosproceso)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relpagosautorizadosproceso.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PagosAutorizadosProceso relpagosautorizadosproceso)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relpagosautorizadosproceso.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PagosAutorizadosProceso relpagosautorizadosproceso)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpagosautorizadosproceso.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}


	
	
	public void getPagosAutorizadosProcesosBusquedaPagosAutorizadosProcesoWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio)throws Exception {
		try {
			//PagosAutorizadosProcesoLogic pagosautorizadosprocesoLogic=new PagosAutorizadosProcesoLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PagosAutorizadosProcesoLogic.GetSelecSqlPagosAutorizadosProceso(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.pagosautorizadosprocesos=this.getPagosAutorizadosProcesos();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getPagosAutorizadosProcesosBusquedaPagosAutorizadosProceso(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio)throws Exception {
		try {
			//PagosAutorizadosProcesoLogic pagosautorizadosprocesoLogic=new PagosAutorizadosProcesoLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PagosAutorizadosProcesoLogic.GetSelecSqlPagosAutorizadosProceso(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.pagosautorizadosprocesos=this.getPagosAutorizadosProcesos();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlPagosAutorizadosProceso(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("PagosAutorizadosProceso_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" a.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_ejercicio = "+id_ejercicio.toString();
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
	
	
	public void deepLoad(PagosAutorizadosProceso pagosautorizadosproceso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PagosAutorizadosProcesoLogicAdditional.updatePagosAutorizadosProcesoToGet(pagosautorizadosproceso,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pagosautorizadosproceso.setEmpresa(pagosautorizadosprocesoDataAccess.getEmpresa(connexion,pagosautorizadosproceso));
		pagosautorizadosproceso.setSucursal(pagosautorizadosprocesoDataAccess.getSucursal(connexion,pagosautorizadosproceso));
		pagosautorizadosproceso.setEjercicio(pagosautorizadosprocesoDataAccess.getEjercicio(connexion,pagosautorizadosproceso));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pagosautorizadosproceso.setEmpresa(pagosautorizadosprocesoDataAccess.getEmpresa(connexion,pagosautorizadosproceso));
			}

			if(clas.clas.equals(Sucursal.class)) {
				pagosautorizadosproceso.setSucursal(pagosautorizadosprocesoDataAccess.getSucursal(connexion,pagosautorizadosproceso));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pagosautorizadosproceso.setEjercicio(pagosautorizadosprocesoDataAccess.getEjercicio(connexion,pagosautorizadosproceso));
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
			pagosautorizadosproceso.setEmpresa(pagosautorizadosprocesoDataAccess.getEmpresa(connexion,pagosautorizadosproceso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagosautorizadosproceso.setSucursal(pagosautorizadosprocesoDataAccess.getSucursal(connexion,pagosautorizadosproceso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagosautorizadosproceso.setEjercicio(pagosautorizadosprocesoDataAccess.getEjercicio(connexion,pagosautorizadosproceso));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pagosautorizadosproceso.setEmpresa(pagosautorizadosprocesoDataAccess.getEmpresa(connexion,pagosautorizadosproceso));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pagosautorizadosproceso.getEmpresa(),isDeep,deepLoadType,clases);
				
		pagosautorizadosproceso.setSucursal(pagosautorizadosprocesoDataAccess.getSucursal(connexion,pagosautorizadosproceso));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pagosautorizadosproceso.getSucursal(),isDeep,deepLoadType,clases);
				
		pagosautorizadosproceso.setEjercicio(pagosautorizadosprocesoDataAccess.getEjercicio(connexion,pagosautorizadosproceso));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pagosautorizadosproceso.getEjercicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pagosautorizadosproceso.setEmpresa(pagosautorizadosprocesoDataAccess.getEmpresa(connexion,pagosautorizadosproceso));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pagosautorizadosproceso.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				pagosautorizadosproceso.setSucursal(pagosautorizadosprocesoDataAccess.getSucursal(connexion,pagosautorizadosproceso));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pagosautorizadosproceso.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pagosautorizadosproceso.setEjercicio(pagosautorizadosprocesoDataAccess.getEjercicio(connexion,pagosautorizadosproceso));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(pagosautorizadosproceso.getEjercicio(),isDeep,deepLoadType,clases);				
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
			pagosautorizadosproceso.setEmpresa(pagosautorizadosprocesoDataAccess.getEmpresa(connexion,pagosautorizadosproceso));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pagosautorizadosproceso.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagosautorizadosproceso.setSucursal(pagosautorizadosprocesoDataAccess.getSucursal(connexion,pagosautorizadosproceso));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pagosautorizadosproceso.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagosautorizadosproceso.setEjercicio(pagosautorizadosprocesoDataAccess.getEjercicio(connexion,pagosautorizadosproceso));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(pagosautorizadosproceso.getEjercicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(pagosautorizadosproceso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PagosAutorizadosProcesoConstantesFunciones.refrescarForeignKeysDescripcionesPagosAutorizadosProceso(pagosautorizadosproceso);
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
			this.deepLoad(this.pagosautorizadosproceso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PagosAutorizadosProcesoConstantesFunciones.refrescarForeignKeysDescripcionesPagosAutorizadosProceso(this.pagosautorizadosproceso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(pagosautorizadosprocesos!=null) {
				for(PagosAutorizadosProceso pagosautorizadosproceso:pagosautorizadosprocesos) {
					this.deepLoad(pagosautorizadosproceso,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PagosAutorizadosProcesoConstantesFunciones.refrescarForeignKeysDescripcionesPagosAutorizadosProceso(pagosautorizadosprocesos);
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
			if(pagosautorizadosprocesos!=null) {
				for(PagosAutorizadosProceso pagosautorizadosproceso:pagosautorizadosprocesos) {
					this.deepLoad(pagosautorizadosproceso,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PagosAutorizadosProcesoConstantesFunciones.refrescarForeignKeysDescripcionesPagosAutorizadosProceso(pagosautorizadosprocesos);
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
	
	public PagosAutorizadosProcesoParameterReturnGeneral procesarAccionPagosAutorizadosProcesos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PagosAutorizadosProceso> pagosautorizadosprocesos,PagosAutorizadosProcesoParameterReturnGeneral pagosautorizadosprocesoParameterGeneral)throws Exception {
		 try {	
			PagosAutorizadosProcesoParameterReturnGeneral pagosautorizadosprocesoReturnGeneral=new PagosAutorizadosProcesoParameterReturnGeneral();
	
			PagosAutorizadosProcesoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pagosautorizadosprocesos,pagosautorizadosprocesoParameterGeneral,pagosautorizadosprocesoReturnGeneral);
			
			return pagosautorizadosprocesoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PagosAutorizadosProcesoParameterReturnGeneral procesarAccionPagosAutorizadosProcesosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PagosAutorizadosProceso> pagosautorizadosprocesos,PagosAutorizadosProcesoParameterReturnGeneral pagosautorizadosprocesoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			PagosAutorizadosProcesoParameterReturnGeneral pagosautorizadosprocesoReturnGeneral=new PagosAutorizadosProcesoParameterReturnGeneral();
	
			PagosAutorizadosProcesoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pagosautorizadosprocesos,pagosautorizadosprocesoParameterGeneral,pagosautorizadosprocesoReturnGeneral);
			
			this.connexion.commit();
			
			return pagosautorizadosprocesoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

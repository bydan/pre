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
import com.bydan.erp.sris.util.report.SriRetencionesParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriRetencionesParameterGeneral;
import com.bydan.erp.sris.util.report.SriRetencionesConstantesFunciones;
import com.bydan.erp.sris.business.entity.report.SriRetenciones;

import com.bydan.erp.sris.business.logic.report.SriRetencionesLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.sris.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;






@SuppressWarnings("unused")
public class SriRetencionesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(SriRetencionesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected SriRetencionesLogic sriretencionesDataAccess; 		
	protected SriRetenciones sriretenciones;
	protected List<SriRetenciones> sriretencioness;
	protected Object sriretencionesObject;	
	protected List<Object> sriretencionessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  SriRetencionesLogic()throws SQLException,Exception {
		try	{
			this.sriretencioness= new ArrayList<SriRetenciones>();
			this.sriretenciones= new SriRetenciones();
			this.sriretencionesObject=new Object();
			this.sriretencionessObject=new ArrayList<Object>();
			
			this.sriretencionesDataAccess=this;
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
			this.sriretencionesDataAccess.setConnexionType(this.connexionType);
			this.sriretencionesDataAccess.setParameterDbType(this.parameterDbType);
			this.sriretencionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SriRetencionesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.sriretencioness= new ArrayList<SriRetenciones>();
			this.sriretenciones= new SriRetenciones();
			this.sriretencionesObject=new Object();
			this.sriretencionessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.sriretencionesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.sriretencionesDataAccess.setConnexionType(this.connexionType);
			this.sriretencionesDataAccess.setParameterDbType(this.parameterDbType);
			this.sriretencionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SriRetenciones getSriRetenciones() throws Exception {	
		SriRetencionesLogicAdditional.checkSriRetencionesToGet(sriretenciones,this.datosCliente,this.arrDatoGeneral);
		SriRetencionesLogicAdditional.updateSriRetencionesToGet(sriretenciones,this.arrDatoGeneral);
		
		return sriretenciones;
	}
		
	public void setSriRetenciones(SriRetenciones newSriRetenciones) {
		this.sriretenciones = newSriRetenciones;
	}
	
	public List<SriRetenciones> getSriRetencioness() throws Exception {		
		this.quitarSriRetencionessNulos();
		
		SriRetencionesLogicAdditional.checkSriRetencionesToGets(sriretencioness,this.datosCliente,this.arrDatoGeneral);
		
		for (SriRetenciones sriretencionesLocal: sriretencioness ) {
			SriRetencionesLogicAdditional.updateSriRetencionesToGet(sriretencionesLocal,this.arrDatoGeneral);
		}
		
		return sriretencioness;
	}
	
	public void setSriRetencioness(List<SriRetenciones> newSriRetencioness) {
		this.sriretencioness = newSriRetencioness;
	}
	
	public Object getSriRetencionesObject() {	
		//this.sriretencionesObject=this.sriretencionesDataAccess.getEntityObject();
		return this.sriretencionesObject;
	}
		
	public void setSriRetencionesObject(Object newSriRetencionesObject) {
		this.sriretencionesObject = newSriRetencionesObject;
	}
	
	public List<Object> getSriRetencionessObject() {		
		//this.sriretencionessObject=this.sriretencionesDataAccess.getEntitiesObject();
		return this.sriretencionessObject;
	}
		
	public void setSriRetencionessObject(List<Object> newSriRetencionessObject) {
		this.sriretencionessObject = newSriRetencionessObject;
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
		sriretencioness = new  ArrayList<SriRetenciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sriretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		sriretencioness = new  ArrayList<SriRetenciones>();
		  		  
        try {
			//SriRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sriretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		sriretencioness = new  ArrayList<SriRetenciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sriretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		sriretencioness = new  ArrayList<SriRetenciones>();
		  		  
        try {
			//SriRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sriretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		sriretencioness = new  ArrayList<SriRetenciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sriretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		sriretencioness = new  ArrayList<SriRetenciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//SriRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sriretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<SriRetenciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriRetenciones> entities = new  ArrayList<SriRetenciones>();
		SriRetenciones entity = new SriRetenciones();		  
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
	
	public  List<SriRetenciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriRetenciones> entities = new  ArrayList<SriRetenciones>();
		SriRetenciones entity = new SriRetenciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriRetenciones();
				
				
      	    	entity=SriRetencionesLogic.getEntitySriRetenciones("",entity,resultSet);
      	    	
				//entity.setSriRetencionesOriginal( new SriRetenciones());
      	    	//entity.setSriRetencionesOriginal(super.getEntity("",entity.getSriRetencionesOriginal(),resultSet,SriRetencionesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriRetencionesOriginal(SriRetencionesDataAccess.getEntitySriRetenciones("",entity.getSriRetencionesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<SriRetenciones> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriRetenciones> entities = new  ArrayList<SriRetenciones>();
		SriRetenciones entity = new SriRetenciones();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,SriRetenciones.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriRetenciones>((List<SriRetenciones>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriRetencionessOriginal(entities);
			
			}  else {
				this.sriretencionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriRetencionesConstantesFunciones.quitarEspaciosSriRetencioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static SriRetenciones getEntitySriRetenciones(String strPrefijo,SriRetenciones entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_modulo(resultSet.getString(strPrefijo+SriRetencionesConstantesFunciones.NOMBREMODULO));
			entity.setnombre_tipo_comprobante(resultSet.getString(strPrefijo+SriRetencionesConstantesFunciones.NOMBRETIPOCOMPROBANTE));
			entity.setnumero_documento(resultSet.getString(strPrefijo+SriRetencionesConstantesFunciones.NUMERODOCUMENTO));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+SriRetencionesConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_registro_contable(new Date(resultSet.getDate(strPrefijo+SriRetencionesConstantesFunciones.FECHAREGISTROCONTABLE).getTime()));
			entity.setnumero_serie(resultSet.getString(strPrefijo+SriRetencionesConstantesFunciones.NUMEROSERIE));
			entity.settotal_iva(resultSet.getDouble(strPrefijo+SriRetencionesConstantesFunciones.TOTALIVA));
			entity.setmonto_iva(resultSet.getDouble(strPrefijo+SriRetencionesConstantesFunciones.MONTOIVA));
			entity.setnumero_documento_contable(resultSet.getString(strPrefijo+SriRetencionesConstantesFunciones.NUMERODOCUMENTOCONTABLE));
			entity.setnombre_cuenta_contable_retencion(resultSet.getString(strPrefijo+SriRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION));
			entity.setporcentaje(resultSet.getDouble(strPrefijo+SriRetencionesConstantesFunciones.PORCENTAJE));
			entity.setvalor(resultSet.getDouble(strPrefijo+SriRetencionesConstantesFunciones.VALOR));
			entity.setnombre_benef(resultSet.getString(strPrefijo+SriRetencionesConstantesFunciones.NOMBREBENEF));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SriRetenciones getEntitySriRetenciones(String strPrefijo,SriRetenciones entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = SriRetenciones.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = SriRetenciones.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				SriRetencionesLogic.setFieldReflectionSriRetenciones(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSriRetenciones(Field field,String strPrefijo,String sColumn,SriRetenciones entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SriRetencionesConstantesFunciones.NOMBREMODULO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.NOMBRETIPOCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriRetencionesConstantesFunciones.FECHAREGISTROCONTABLE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriRetencionesConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.MONTOIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.NUMERODOCUMENTOCONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriRetencionesConstantesFunciones.NOMBREBENEF:
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
	
	public void quitarSriRetencionessNulos() throws Exception {				
		
		List<SriRetenciones> sriretencionessAux= new ArrayList<SriRetenciones>();
		
		for(SriRetenciones sriretenciones:sriretencioness) {
			if(sriretenciones!=null) {
				sriretencionessAux.add(sriretenciones);
			}
		}
		
		sriretencioness=sriretencionessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<SriRetenciones> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriRetenciones> entities = new  ArrayList<SriRetenciones>();
		SriRetenciones entity = new SriRetenciones();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriRetenciones>((List<SriRetenciones>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriRetencionessOriginal(entities);
			
			}  else {
				this.sriretencionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriRetencionesConstantesFunciones.quitarEspaciosSriRetencioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		sriretencioness = new  ArrayList<SriRetenciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sriretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		sriretencioness = new  ArrayList<SriRetenciones>();
		  		  
        try {
			//SriRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sriretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<SriRetenciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriRetenciones> entities = new  ArrayList<SriRetenciones>();
		SriRetenciones entity = new SriRetenciones();		  
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
	
	public  List<SriRetenciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriRetenciones> entities = new  ArrayList<SriRetenciones>();
		SriRetenciones entity = new SriRetenciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriRetenciones();
				
				if(conMapGenerico) {
					entity.setMapSriRetenciones( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapSriRetenciones().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SriRetencionesDataAccess.ISWITHSCHEMA);         		
					entity=SriRetencionesLogic.getEntitySriRetenciones("",entity,resultSet,listColumns);
					
					////entity.setSriRetencionesOriginal( new SriRetenciones());
					////entity.setSriRetencionesOriginal(super.getEntity("",entity.getSriRetencionesOriginal(),resultSet,SriRetencionesDataAccess.ISWITHSCHEMA));         		
					////entity.setSriRetencionesOriginal(SriRetencionesDataAccess.getEntitySriRetenciones("",entity.getSriRetencionesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,SriRetenciones relsriretenciones)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relsriretenciones.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,SriRetenciones relsriretenciones)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relsriretenciones.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public PeriodoDeclara getPeriodoDeclara(Connexion connexion,SriRetenciones relsriretenciones)throws SQLException,Exception {

		PeriodoDeclara periododeclara= new PeriodoDeclara();

		try {
			PeriodoDeclaraDataAccess periododeclaraDataAccess=new PeriodoDeclaraDataAccess();

			periododeclaraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periododeclaraDataAccess.setConnexionType(this.connexionType);
			periododeclaraDataAccess.setParameterDbType(this.parameterDbType);
			periododeclaraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periododeclara=periododeclaraDataAccess.getEntity(connexion,relsriretenciones.getid_periodo_declara());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periododeclara;

	}


	
	
	public void getSriRetencionessBusquedaSriRetencionesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo_declara,String ruc)throws Exception {
		try {
			//SriRetencionesLogic sriretencionesLogic=new SriRetencionesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriRetencionesLogic.GetSelecSqlSriRetenciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo_declara,ruc);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.sriretencioness=this.getSriRetencioness();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getSriRetencionessBusquedaSriRetenciones(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo_declara,String ruc)throws Exception {
		try {
			//SriRetencionesLogic sriretencionesLogic=new SriRetencionesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriRetencionesLogic.GetSelecSqlSriRetenciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo_declara,ruc);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.sriretencioness=this.getSriRetencioness();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlSriRetenciones(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo_declara,String ruc)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("SriRetenciones_Postgres.sql");
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

				if(id_periodo_declara!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" l.id_periodo_declara = "+id_periodo_declara.toString();
					existeWhere=true;
				}

				if(ruc!= null && !ruc.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" l.ruc = "+"'"+ruc+"'";
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
	
	
	public void deepLoad(SriRetenciones sriretenciones,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SriRetencionesLogicAdditional.updateSriRetencionesToGet(sriretenciones,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sriretenciones.setEmpresa(sriretencionesDataAccess.getEmpresa(connexion,sriretenciones));
		sriretenciones.setEjercicio(sriretencionesDataAccess.getEjercicio(connexion,sriretenciones));
		sriretenciones.setPeriodoDeclara(sriretencionesDataAccess.getPeriodoDeclara(connexion,sriretenciones));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				sriretenciones.setEmpresa(sriretencionesDataAccess.getEmpresa(connexion,sriretenciones));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				sriretenciones.setEjercicio(sriretencionesDataAccess.getEjercicio(connexion,sriretenciones));
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				sriretenciones.setPeriodoDeclara(sriretencionesDataAccess.getPeriodoDeclara(connexion,sriretenciones));
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
			sriretenciones.setEmpresa(sriretencionesDataAccess.getEmpresa(connexion,sriretenciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sriretenciones.setEjercicio(sriretencionesDataAccess.getEjercicio(connexion,sriretenciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sriretenciones.setPeriodoDeclara(sriretencionesDataAccess.getPeriodoDeclara(connexion,sriretenciones));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sriretenciones.setEmpresa(sriretencionesDataAccess.getEmpresa(connexion,sriretenciones));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(sriretenciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		sriretenciones.setEjercicio(sriretencionesDataAccess.getEjercicio(connexion,sriretenciones));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(sriretenciones.getEjercicio(),isDeep,deepLoadType,clases);
				
		sriretenciones.setPeriodoDeclara(sriretencionesDataAccess.getPeriodoDeclara(connexion,sriretenciones));
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(sriretenciones.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				sriretenciones.setEmpresa(sriretencionesDataAccess.getEmpresa(connexion,sriretenciones));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(sriretenciones.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				sriretenciones.setEjercicio(sriretencionesDataAccess.getEjercicio(connexion,sriretenciones));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(sriretenciones.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				sriretenciones.setPeriodoDeclara(sriretencionesDataAccess.getPeriodoDeclara(connexion,sriretenciones));
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepLoad(sriretenciones.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
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
			sriretenciones.setEmpresa(sriretencionesDataAccess.getEmpresa(connexion,sriretenciones));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(sriretenciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sriretenciones.setEjercicio(sriretencionesDataAccess.getEjercicio(connexion,sriretenciones));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(sriretenciones.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sriretenciones.setPeriodoDeclara(sriretencionesDataAccess.getPeriodoDeclara(connexion,sriretenciones));
			PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
			periododeclaraLogic.deepLoad(sriretenciones.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(sriretenciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriRetencionesConstantesFunciones.refrescarForeignKeysDescripcionesSriRetenciones(sriretenciones);
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
			this.deepLoad(this.sriretenciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriRetencionesConstantesFunciones.refrescarForeignKeysDescripcionesSriRetenciones(this.sriretenciones);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(sriretencioness!=null) {
				for(SriRetenciones sriretenciones:sriretencioness) {
					this.deepLoad(sriretenciones,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SriRetencionesConstantesFunciones.refrescarForeignKeysDescripcionesSriRetenciones(sriretencioness);
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
			if(sriretencioness!=null) {
				for(SriRetenciones sriretenciones:sriretencioness) {
					this.deepLoad(sriretenciones,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SriRetencionesConstantesFunciones.refrescarForeignKeysDescripcionesSriRetenciones(sriretencioness);
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
	
	public SriRetencionesParameterReturnGeneral procesarAccionSriRetencioness(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriRetenciones> sriretencioness,SriRetencionesParameterReturnGeneral sriretencionesParameterGeneral)throws Exception {
		 try {	
			SriRetencionesParameterReturnGeneral sriretencionesReturnGeneral=new SriRetencionesParameterReturnGeneral();
	
			SriRetencionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sriretencioness,sriretencionesParameterGeneral,sriretencionesReturnGeneral);
			
			return sriretencionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SriRetencionesParameterReturnGeneral procesarAccionSriRetencionessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriRetenciones> sriretencioness,SriRetencionesParameterReturnGeneral sriretencionesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SriRetencionesParameterReturnGeneral sriretencionesReturnGeneral=new SriRetencionesParameterReturnGeneral();
	
			SriRetencionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sriretencioness,sriretencionesParameterGeneral,sriretencionesReturnGeneral);
			
			this.connexion.commit();
			
			return sriretencionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

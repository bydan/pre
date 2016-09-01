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
import com.bydan.erp.inventario.util.report.AutorizarRequisicionesParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.AutorizarRequisicionesParameterGeneral;
import com.bydan.erp.inventario.util.report.AutorizarRequisicionesConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.AutorizarRequisiciones;

import com.bydan.erp.inventario.business.logic.report.AutorizarRequisicionesLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class AutorizarRequisicionesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(AutorizarRequisicionesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected AutorizarRequisicionesLogic autorizarrequisicionesDataAccess; 		
	protected AutorizarRequisiciones autorizarrequisiciones;
	protected List<AutorizarRequisiciones> autorizarrequisicioness;
	protected Object autorizarrequisicionesObject;	
	protected List<Object> autorizarrequisicionessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  AutorizarRequisicionesLogic()throws SQLException,Exception {
		try	{
			this.autorizarrequisicioness= new ArrayList<AutorizarRequisiciones>();
			this.autorizarrequisiciones= new AutorizarRequisiciones();
			this.autorizarrequisicionesObject=new Object();
			this.autorizarrequisicionessObject=new ArrayList<Object>();
			
			this.autorizarrequisicionesDataAccess=this;
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
			this.autorizarrequisicionesDataAccess.setConnexionType(this.connexionType);
			this.autorizarrequisicionesDataAccess.setParameterDbType(this.parameterDbType);
			this.autorizarrequisicionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AutorizarRequisicionesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.autorizarrequisicioness= new ArrayList<AutorizarRequisiciones>();
			this.autorizarrequisiciones= new AutorizarRequisiciones();
			this.autorizarrequisicionesObject=new Object();
			this.autorizarrequisicionessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.autorizarrequisicionesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.autorizarrequisicionesDataAccess.setConnexionType(this.connexionType);
			this.autorizarrequisicionesDataAccess.setParameterDbType(this.parameterDbType);
			this.autorizarrequisicionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AutorizarRequisiciones getAutorizarRequisiciones() throws Exception {	
		AutorizarRequisicionesLogicAdditional.checkAutorizarRequisicionesToGet(autorizarrequisiciones,this.datosCliente,this.arrDatoGeneral);
		AutorizarRequisicionesLogicAdditional.updateAutorizarRequisicionesToGet(autorizarrequisiciones,this.arrDatoGeneral);
		
		return autorizarrequisiciones;
	}
		
	public void setAutorizarRequisiciones(AutorizarRequisiciones newAutorizarRequisiciones) {
		this.autorizarrequisiciones = newAutorizarRequisiciones;
	}
	
	public List<AutorizarRequisiciones> getAutorizarRequisicioness() throws Exception {		
		this.quitarAutorizarRequisicionessNulos();
		
		AutorizarRequisicionesLogicAdditional.checkAutorizarRequisicionesToGets(autorizarrequisicioness,this.datosCliente,this.arrDatoGeneral);
		
		for (AutorizarRequisiciones autorizarrequisicionesLocal: autorizarrequisicioness ) {
			AutorizarRequisicionesLogicAdditional.updateAutorizarRequisicionesToGet(autorizarrequisicionesLocal,this.arrDatoGeneral);
		}
		
		return autorizarrequisicioness;
	}
	
	public void setAutorizarRequisicioness(List<AutorizarRequisiciones> newAutorizarRequisicioness) {
		this.autorizarrequisicioness = newAutorizarRequisicioness;
	}
	
	public Object getAutorizarRequisicionesObject() {	
		//this.autorizarrequisicionesObject=this.autorizarrequisicionesDataAccess.getEntityObject();
		return this.autorizarrequisicionesObject;
	}
		
	public void setAutorizarRequisicionesObject(Object newAutorizarRequisicionesObject) {
		this.autorizarrequisicionesObject = newAutorizarRequisicionesObject;
	}
	
	public List<Object> getAutorizarRequisicionessObject() {		
		//this.autorizarrequisicionessObject=this.autorizarrequisicionesDataAccess.getEntitiesObject();
		return this.autorizarrequisicionessObject;
	}
		
	public void setAutorizarRequisicionessObject(List<Object> newAutorizarRequisicionessObject) {
		this.autorizarrequisicionessObject = newAutorizarRequisicionessObject;
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
		autorizarrequisicioness = new  ArrayList<AutorizarRequisiciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//AutorizarRequisicionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorizarrequisicioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		autorizarrequisicioness = new  ArrayList<AutorizarRequisiciones>();
		  		  
        try {
			//AutorizarRequisicionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorizarrequisicioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autorizarrequisicioness = new  ArrayList<AutorizarRequisiciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//AutorizarRequisicionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorizarrequisicioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		autorizarrequisicioness = new  ArrayList<AutorizarRequisiciones>();
		  		  
        try {
			//AutorizarRequisicionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorizarrequisicioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		autorizarrequisicioness = new  ArrayList<AutorizarRequisiciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//AutorizarRequisicionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorizarrequisicioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		autorizarrequisicioness = new  ArrayList<AutorizarRequisiciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//AutorizarRequisicionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorizarrequisicioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<AutorizarRequisiciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutorizarRequisiciones> entities = new  ArrayList<AutorizarRequisiciones>();
		AutorizarRequisiciones entity = new AutorizarRequisiciones();		  
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
	
	public  List<AutorizarRequisiciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutorizarRequisiciones> entities = new  ArrayList<AutorizarRequisiciones>();
		AutorizarRequisiciones entity = new AutorizarRequisiciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutorizarRequisiciones();
				
				
      	    	entity=AutorizarRequisicionesLogic.getEntityAutorizarRequisiciones("",entity,resultSet);
      	    	
				//entity.setAutorizarRequisicionesOriginal( new AutorizarRequisiciones());
      	    	//entity.setAutorizarRequisicionesOriginal(super.getEntity("",entity.getAutorizarRequisicionesOriginal(),resultSet,AutorizarRequisicionesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutorizarRequisicionesOriginal(AutorizarRequisicionesDataAccess.getEntityAutorizarRequisiciones("",entity.getAutorizarRequisicionesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<AutorizarRequisiciones> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutorizarRequisiciones> entities = new  ArrayList<AutorizarRequisiciones>();
		AutorizarRequisiciones entity = new AutorizarRequisiciones();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,AutorizarRequisiciones.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<AutorizarRequisiciones>((List<AutorizarRequisiciones>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setAutorizarRequisicionessOriginal(entities);
			
			}  else {
				this.autorizarrequisicionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//AutorizarRequisicionesConstantesFunciones.quitarEspaciosAutorizarRequisicioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static AutorizarRequisiciones getEntityAutorizarRequisiciones(String strPrefijo,AutorizarRequisiciones entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_tipo_requisicion(resultSet.getString(strPrefijo+AutorizarRequisicionesConstantesFunciones.CODIGOTIPOREQUISICION));
			entity.setcodigo(resultSet.getString(strPrefijo+AutorizarRequisicionesConstantesFunciones.CODIGO));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+AutorizarRequisicionesConstantesFunciones.FECHA).getTime()));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+AutorizarRequisicionesConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+AutorizarRequisicionesConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_producto(resultSet.getString(strPrefijo+AutorizarRequisicionesConstantesFunciones.NOMBREPRODUCTO));
			entity.setcantidad(resultSet.getLong(strPrefijo+AutorizarRequisicionesConstantesFunciones.CANTIDAD));
			entity.setfecha_autoriza(new Date(resultSet.getDate(strPrefijo+AutorizarRequisicionesConstantesFunciones.FECHAAUTORIZA).getTime()));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AutorizarRequisiciones getEntityAutorizarRequisiciones(String strPrefijo,AutorizarRequisiciones entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = AutorizarRequisiciones.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = AutorizarRequisiciones.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				AutorizarRequisicionesLogic.setFieldReflectionAutorizarRequisiciones(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAutorizarRequisiciones(Field field,String strPrefijo,String sColumn,AutorizarRequisiciones entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AutorizarRequisicionesConstantesFunciones.CODIGOTIPOREQUISICION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutorizarRequisicionesConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutorizarRequisicionesConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutorizarRequisicionesConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutorizarRequisicionesConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutorizarRequisicionesConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutorizarRequisicionesConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutorizarRequisicionesConstantesFunciones.FECHAAUTORIZA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	public void quitarAutorizarRequisicionessNulos() throws Exception {				
		
		List<AutorizarRequisiciones> autorizarrequisicionessAux= new ArrayList<AutorizarRequisiciones>();
		
		for(AutorizarRequisiciones autorizarrequisiciones:autorizarrequisicioness) {
			if(autorizarrequisiciones!=null) {
				autorizarrequisicionessAux.add(autorizarrequisiciones);
			}
		}
		
		autorizarrequisicioness=autorizarrequisicionessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<AutorizarRequisiciones> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutorizarRequisiciones> entities = new  ArrayList<AutorizarRequisiciones>();
		AutorizarRequisiciones entity = new AutorizarRequisiciones();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<AutorizarRequisiciones>((List<AutorizarRequisiciones>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setAutorizarRequisicionessOriginal(entities);
			
			}  else {
				this.autorizarrequisicionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//AutorizarRequisicionesConstantesFunciones.quitarEspaciosAutorizarRequisicioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		autorizarrequisicioness = new  ArrayList<AutorizarRequisiciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//AutorizarRequisicionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorizarrequisicioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		autorizarrequisicioness = new  ArrayList<AutorizarRequisiciones>();
		  		  
        try {
			//AutorizarRequisicionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorizarrequisicioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<AutorizarRequisiciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutorizarRequisiciones> entities = new  ArrayList<AutorizarRequisiciones>();
		AutorizarRequisiciones entity = new AutorizarRequisiciones();		  
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
	
	public  List<AutorizarRequisiciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutorizarRequisiciones> entities = new  ArrayList<AutorizarRequisiciones>();
		AutorizarRequisiciones entity = new AutorizarRequisiciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutorizarRequisiciones();
				
				if(conMapGenerico) {
					entity.setMapAutorizarRequisiciones( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapAutorizarRequisiciones().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AutorizarRequisicionesDataAccess.ISWITHSCHEMA);         		
					entity=AutorizarRequisicionesLogic.getEntityAutorizarRequisiciones("",entity,resultSet,listColumns);
					
					////entity.setAutorizarRequisicionesOriginal( new AutorizarRequisiciones());
					////entity.setAutorizarRequisicionesOriginal(super.getEntity("",entity.getAutorizarRequisicionesOriginal(),resultSet,AutorizarRequisicionesDataAccess.ISWITHSCHEMA));         		
					////entity.setAutorizarRequisicionesOriginal(AutorizarRequisicionesDataAccess.getEntityAutorizarRequisiciones("",entity.getAutorizarRequisicionesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,AutorizarRequisiciones relautorizarrequisiciones)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relautorizarrequisiciones.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,AutorizarRequisiciones relautorizarrequisiciones)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relautorizarrequisiciones.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}


	
	
	public void getAutorizarRequisicionessBusquedaAutorizarRequisicionesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//AutorizarRequisicionesLogic autorizarrequisicionesLogic=new AutorizarRequisicionesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=AutorizarRequisicionesLogic.GetSelecSqlAutorizarRequisiciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.autorizarrequisicioness=this.getAutorizarRequisicioness();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getAutorizarRequisicionessBusquedaAutorizarRequisiciones(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//AutorizarRequisicionesLogic autorizarrequisicionesLogic=new AutorizarRequisicionesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=AutorizarRequisicionesLogic.GetSelecSqlAutorizarRequisiciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.autorizarrequisicioness=this.getAutorizarRequisicioness();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlAutorizarRequisiciones(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("AutorizarRequisiciones_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" r.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" r.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" r.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
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
	
	
	public void deepLoad(AutorizarRequisiciones autorizarrequisiciones,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AutorizarRequisicionesLogicAdditional.updateAutorizarRequisicionesToGet(autorizarrequisiciones,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autorizarrequisiciones.setEmpresa(autorizarrequisicionesDataAccess.getEmpresa(connexion,autorizarrequisiciones));
		autorizarrequisiciones.setSucursal(autorizarrequisicionesDataAccess.getSucursal(connexion,autorizarrequisiciones));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autorizarrequisiciones.setEmpresa(autorizarrequisicionesDataAccess.getEmpresa(connexion,autorizarrequisiciones));
			}

			if(clas.clas.equals(Sucursal.class)) {
				autorizarrequisiciones.setSucursal(autorizarrequisicionesDataAccess.getSucursal(connexion,autorizarrequisiciones));
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
			autorizarrequisiciones.setEmpresa(autorizarrequisicionesDataAccess.getEmpresa(connexion,autorizarrequisiciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autorizarrequisiciones.setSucursal(autorizarrequisicionesDataAccess.getSucursal(connexion,autorizarrequisiciones));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autorizarrequisiciones.setEmpresa(autorizarrequisicionesDataAccess.getEmpresa(connexion,autorizarrequisiciones));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autorizarrequisiciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		autorizarrequisiciones.setSucursal(autorizarrequisicionesDataAccess.getSucursal(connexion,autorizarrequisiciones));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(autorizarrequisiciones.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autorizarrequisiciones.setEmpresa(autorizarrequisicionesDataAccess.getEmpresa(connexion,autorizarrequisiciones));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(autorizarrequisiciones.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				autorizarrequisiciones.setSucursal(autorizarrequisicionesDataAccess.getSucursal(connexion,autorizarrequisiciones));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(autorizarrequisiciones.getSucursal(),isDeep,deepLoadType,clases);				
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
			autorizarrequisiciones.setEmpresa(autorizarrequisicionesDataAccess.getEmpresa(connexion,autorizarrequisiciones));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(autorizarrequisiciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autorizarrequisiciones.setSucursal(autorizarrequisicionesDataAccess.getSucursal(connexion,autorizarrequisiciones));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(autorizarrequisiciones.getSucursal(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(autorizarrequisiciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutorizarRequisicionesConstantesFunciones.refrescarForeignKeysDescripcionesAutorizarRequisiciones(autorizarrequisiciones);
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
			this.deepLoad(this.autorizarrequisiciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutorizarRequisicionesConstantesFunciones.refrescarForeignKeysDescripcionesAutorizarRequisiciones(this.autorizarrequisiciones);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(autorizarrequisicioness!=null) {
				for(AutorizarRequisiciones autorizarrequisiciones:autorizarrequisicioness) {
					this.deepLoad(autorizarrequisiciones,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AutorizarRequisicionesConstantesFunciones.refrescarForeignKeysDescripcionesAutorizarRequisiciones(autorizarrequisicioness);
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
			if(autorizarrequisicioness!=null) {
				for(AutorizarRequisiciones autorizarrequisiciones:autorizarrequisicioness) {
					this.deepLoad(autorizarrequisiciones,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AutorizarRequisicionesConstantesFunciones.refrescarForeignKeysDescripcionesAutorizarRequisiciones(autorizarrequisicioness);
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
	
	public AutorizarRequisicionesParameterReturnGeneral procesarAccionAutorizarRequisicioness(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutorizarRequisiciones> autorizarrequisicioness,AutorizarRequisicionesParameterReturnGeneral autorizarrequisicionesParameterGeneral)throws Exception {
		 try {	
			AutorizarRequisicionesParameterReturnGeneral autorizarrequisicionesReturnGeneral=new AutorizarRequisicionesParameterReturnGeneral();
	
			AutorizarRequisicionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autorizarrequisicioness,autorizarrequisicionesParameterGeneral,autorizarrequisicionesReturnGeneral);
			
			return autorizarrequisicionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutorizarRequisicionesParameterReturnGeneral procesarAccionAutorizarRequisicionessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutorizarRequisiciones> autorizarrequisicioness,AutorizarRequisicionesParameterReturnGeneral autorizarrequisicionesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			AutorizarRequisicionesParameterReturnGeneral autorizarrequisicionesReturnGeneral=new AutorizarRequisicionesParameterReturnGeneral();
	
			AutorizarRequisicionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autorizarrequisicioness,autorizarrequisicionesParameterGeneral,autorizarrequisicionesReturnGeneral);
			
			this.connexion.commit();
			
			return autorizarrequisicionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

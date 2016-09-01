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
package com.bydan.erp.contabilidad.business.logic.report;

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

import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.resources.general.AuxiliarGeneral;
import com.bydan.erp.contabilidad.util.report.EstadosFlujosCajasParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.EstadosFlujosCajasParameterGeneral;
import com.bydan.erp.contabilidad.util.report.EstadosFlujosCajasConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.EstadosFlujosCajas;

import com.bydan.erp.contabilidad.business.logic.report.EstadosFlujosCajasLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class EstadosFlujosCajasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(EstadosFlujosCajasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected EstadosFlujosCajasLogic estadosflujoscajasDataAccess; 		
	protected EstadosFlujosCajas estadosflujoscajas;
	protected List<EstadosFlujosCajas> estadosflujoscajass;
	protected Object estadosflujoscajasObject;	
	protected List<Object> estadosflujoscajassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  EstadosFlujosCajasLogic()throws SQLException,Exception {
		try	{
			this.estadosflujoscajass= new ArrayList<EstadosFlujosCajas>();
			this.estadosflujoscajas= new EstadosFlujosCajas();
			this.estadosflujoscajasObject=new Object();
			this.estadosflujoscajassObject=new ArrayList<Object>();
			
			this.estadosflujoscajasDataAccess=this;
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
			this.estadosflujoscajasDataAccess.setConnexionType(this.connexionType);
			this.estadosflujoscajasDataAccess.setParameterDbType(this.parameterDbType);
			this.estadosflujoscajasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadosFlujosCajasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.estadosflujoscajass= new ArrayList<EstadosFlujosCajas>();
			this.estadosflujoscajas= new EstadosFlujosCajas();
			this.estadosflujoscajasObject=new Object();
			this.estadosflujoscajassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.estadosflujoscajasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.estadosflujoscajasDataAccess.setConnexionType(this.connexionType);
			this.estadosflujoscajasDataAccess.setParameterDbType(this.parameterDbType);
			this.estadosflujoscajasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadosFlujosCajas getEstadosFlujosCajas() throws Exception {	
		EstadosFlujosCajasLogicAdditional.checkEstadosFlujosCajasToGet(estadosflujoscajas,this.datosCliente,this.arrDatoGeneral);
		EstadosFlujosCajasLogicAdditional.updateEstadosFlujosCajasToGet(estadosflujoscajas,this.arrDatoGeneral);
		
		return estadosflujoscajas;
	}
		
	public void setEstadosFlujosCajas(EstadosFlujosCajas newEstadosFlujosCajas) {
		this.estadosflujoscajas = newEstadosFlujosCajas;
	}
	
	public List<EstadosFlujosCajas> getEstadosFlujosCajass() throws Exception {		
		this.quitarEstadosFlujosCajassNulos();
		
		EstadosFlujosCajasLogicAdditional.checkEstadosFlujosCajasToGets(estadosflujoscajass,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadosFlujosCajas estadosflujoscajasLocal: estadosflujoscajass ) {
			EstadosFlujosCajasLogicAdditional.updateEstadosFlujosCajasToGet(estadosflujoscajasLocal,this.arrDatoGeneral);
		}
		
		return estadosflujoscajass;
	}
	
	public void setEstadosFlujosCajass(List<EstadosFlujosCajas> newEstadosFlujosCajass) {
		this.estadosflujoscajass = newEstadosFlujosCajass;
	}
	
	public Object getEstadosFlujosCajasObject() {	
		//this.estadosflujoscajasObject=this.estadosflujoscajasDataAccess.getEntityObject();
		return this.estadosflujoscajasObject;
	}
		
	public void setEstadosFlujosCajasObject(Object newEstadosFlujosCajasObject) {
		this.estadosflujoscajasObject = newEstadosFlujosCajasObject;
	}
	
	public List<Object> getEstadosFlujosCajassObject() {		
		//this.estadosflujoscajassObject=this.estadosflujoscajasDataAccess.getEntitiesObject();
		return this.estadosflujoscajassObject;
	}
		
	public void setEstadosFlujosCajassObject(List<Object> newEstadosFlujosCajassObject) {
		this.estadosflujoscajassObject = newEstadosFlujosCajassObject;
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
		estadosflujoscajass = new  ArrayList<EstadosFlujosCajas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EstadosFlujosCajasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosflujoscajass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		estadosflujoscajass = new  ArrayList<EstadosFlujosCajas>();
		  		  
        try {
			//EstadosFlujosCajasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosflujoscajass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadosflujoscajass = new  ArrayList<EstadosFlujosCajas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EstadosFlujosCajasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosflujoscajass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		estadosflujoscajass = new  ArrayList<EstadosFlujosCajas>();
		  		  
        try {
			//EstadosFlujosCajasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosflujoscajass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		estadosflujoscajass = new  ArrayList<EstadosFlujosCajas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EstadosFlujosCajasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosflujoscajass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		estadosflujoscajass = new  ArrayList<EstadosFlujosCajas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//EstadosFlujosCajasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosflujoscajass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<EstadosFlujosCajas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadosFlujosCajas> entities = new  ArrayList<EstadosFlujosCajas>();
		EstadosFlujosCajas entity = new EstadosFlujosCajas();		  
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
	
	public  List<EstadosFlujosCajas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadosFlujosCajas> entities = new  ArrayList<EstadosFlujosCajas>();
		EstadosFlujosCajas entity = new EstadosFlujosCajas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadosFlujosCajas();
				
				
      	    	entity=EstadosFlujosCajasLogic.getEntityEstadosFlujosCajas("",entity,resultSet);
      	    	
				//entity.setEstadosFlujosCajasOriginal( new EstadosFlujosCajas());
      	    	//entity.setEstadosFlujosCajasOriginal(super.getEntity("",entity.getEstadosFlujosCajasOriginal(),resultSet,EstadosFlujosCajasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadosFlujosCajasOriginal(EstadosFlujosCajasDataAccess.getEntityEstadosFlujosCajas("",entity.getEstadosFlujosCajasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<EstadosFlujosCajas> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadosFlujosCajas> entities = new  ArrayList<EstadosFlujosCajas>();
		EstadosFlujosCajas entity = new EstadosFlujosCajas();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,EstadosFlujosCajas.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EstadosFlujosCajas>((List<EstadosFlujosCajas>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEstadosFlujosCajassOriginal(entities);
			
			}  else {
				this.estadosflujoscajassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EstadosFlujosCajasConstantesFunciones.quitarEspaciosEstadosFlujosCajass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static EstadosFlujosCajas getEntityEstadosFlujosCajas(String strPrefijo,EstadosFlujosCajas entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_periodo(resultSet.getLong(strPrefijo+EstadosFlujosCajasConstantesFunciones.IDPERIODO));
			entity.setnombre_centro_actividad(resultSet.getString(strPrefijo+EstadosFlujosCajasConstantesFunciones.NOMBRECENTROACTIVIDAD));
			entity.setcodigo_centro_actividad(resultSet.getString(strPrefijo+EstadosFlujosCajasConstantesFunciones.CODIGOCENTROACTIVIDAD));
			entity.setmensual(resultSet.getDouble(strPrefijo+EstadosFlujosCajasConstantesFunciones.MENSUAL));
			entity.setacumulado(resultSet.getDouble(strPrefijo+EstadosFlujosCajasConstantesFunciones.ACUMULADO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadosFlujosCajas getEntityEstadosFlujosCajas(String strPrefijo,EstadosFlujosCajas entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = EstadosFlujosCajas.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = EstadosFlujosCajas.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				EstadosFlujosCajasLogic.setFieldReflectionEstadosFlujosCajas(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadosFlujosCajas(Field field,String strPrefijo,String sColumn,EstadosFlujosCajas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadosFlujosCajasConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadosFlujosCajasConstantesFunciones.NOMBRECENTROACTIVIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadosFlujosCajasConstantesFunciones.CODIGOCENTROACTIVIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadosFlujosCajasConstantesFunciones.MENSUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EstadosFlujosCajasConstantesFunciones.ACUMULADO:
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
	
	public void quitarEstadosFlujosCajassNulos() throws Exception {				
		
		List<EstadosFlujosCajas> estadosflujoscajassAux= new ArrayList<EstadosFlujosCajas>();
		
		for(EstadosFlujosCajas estadosflujoscajas:estadosflujoscajass) {
			if(estadosflujoscajas!=null) {
				estadosflujoscajassAux.add(estadosflujoscajas);
			}
		}
		
		estadosflujoscajass=estadosflujoscajassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<EstadosFlujosCajas> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadosFlujosCajas> entities = new  ArrayList<EstadosFlujosCajas>();
		EstadosFlujosCajas entity = new EstadosFlujosCajas();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<EstadosFlujosCajas>((List<EstadosFlujosCajas>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setEstadosFlujosCajassOriginal(entities);
			
			}  else {
				this.estadosflujoscajassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//EstadosFlujosCajasConstantesFunciones.quitarEspaciosEstadosFlujosCajass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		estadosflujoscajass = new  ArrayList<EstadosFlujosCajas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//EstadosFlujosCajasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosflujoscajass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		estadosflujoscajass = new  ArrayList<EstadosFlujosCajas>();
		  		  
        try {
			//EstadosFlujosCajasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadosflujoscajass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<EstadosFlujosCajas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadosFlujosCajas> entities = new  ArrayList<EstadosFlujosCajas>();
		EstadosFlujosCajas entity = new EstadosFlujosCajas();		  
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
	
	public  List<EstadosFlujosCajas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadosFlujosCajas> entities = new  ArrayList<EstadosFlujosCajas>();
		EstadosFlujosCajas entity = new EstadosFlujosCajas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadosFlujosCajas();
				
				if(conMapGenerico) {
					entity.setMapEstadosFlujosCajas( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapEstadosFlujosCajas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadosFlujosCajasDataAccess.ISWITHSCHEMA);         		
					entity=EstadosFlujosCajasLogic.getEntityEstadosFlujosCajas("",entity,resultSet,listColumns);
					
					////entity.setEstadosFlujosCajasOriginal( new EstadosFlujosCajas());
					////entity.setEstadosFlujosCajasOriginal(super.getEntity("",entity.getEstadosFlujosCajasOriginal(),resultSet,EstadosFlujosCajasDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadosFlujosCajasOriginal(EstadosFlujosCajasDataAccess.getEntityEstadosFlujosCajas("",entity.getEstadosFlujosCajasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,EstadosFlujosCajas relestadosflujoscajas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relestadosflujoscajas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,EstadosFlujosCajas relestadosflujoscajas)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relestadosflujoscajas.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,EstadosFlujosCajas relestadosflujoscajas)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);
			periodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periodo=periodoDataAccess.getEntity(connexion,relestadosflujoscajas.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public CentroActividad getCentroActividad(Connexion connexion,EstadosFlujosCajas relestadosflujoscajas)throws SQLException,Exception {

		CentroActividad centroactividad= new CentroActividad();

		try {
			CentroActividadDataAccess centroactividadDataAccess=new CentroActividadDataAccess();

			centroactividadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centroactividadDataAccess.setConnexionType(this.connexionType);
			centroactividadDataAccess.setParameterDbType(this.parameterDbType);
			centroactividadDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			centroactividad=centroactividadDataAccess.getEntity(connexion,relestadosflujoscajas.getid_centro_actividad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centroactividad;

	}


	
	
	public void getEstadosFlujosCajassBusquedaEstadosFlujosCajasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_centro_actividad)throws Exception {
		try {
			//EstadosFlujosCajasLogic estadosflujoscajasLogic=new EstadosFlujosCajasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EstadosFlujosCajasLogic.GetSelecSqlEstadosFlujosCajas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_centro_actividad);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.estadosflujoscajass=this.getEstadosFlujosCajass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getEstadosFlujosCajassBusquedaEstadosFlujosCajas(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_centro_actividad)throws Exception {
		try {
			//EstadosFlujosCajasLogic estadosflujoscajasLogic=new EstadosFlujosCajasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=EstadosFlujosCajasLogic.GetSelecSqlEstadosFlujosCajas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_centro_actividad);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.estadosflujoscajass=this.getEstadosFlujosCajass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlEstadosFlujosCajas(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_centro_actividad)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("EstadosFlujosCajas_Postgres.sql");
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

				if(id_periodo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_periodo = "+id_periodo.toString();
					existeWhere=true;
				}

				if(id_centro_actividad!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_centro_actividad = "+id_centro_actividad.toString();
					existeWhere=true;
				}

				if(existeWhere) {
					sSqlWhere=" where "+sSqlWhere;
				}

				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"1",sSqlWhere);
				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"2",sSqlWhere);

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
	
	
	public void deepLoad(EstadosFlujosCajas estadosflujoscajas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadosFlujosCajasLogicAdditional.updateEstadosFlujosCajasToGet(estadosflujoscajas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadosflujoscajas.setEmpresa(estadosflujoscajasDataAccess.getEmpresa(connexion,estadosflujoscajas));
		estadosflujoscajas.setEjercicio(estadosflujoscajasDataAccess.getEjercicio(connexion,estadosflujoscajas));
		estadosflujoscajas.setPeriodo(estadosflujoscajasDataAccess.getPeriodo(connexion,estadosflujoscajas));
		estadosflujoscajas.setCentroActividad(estadosflujoscajasDataAccess.getCentroActividad(connexion,estadosflujoscajas));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadosflujoscajas.setEmpresa(estadosflujoscajasDataAccess.getEmpresa(connexion,estadosflujoscajas));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				estadosflujoscajas.setEjercicio(estadosflujoscajasDataAccess.getEjercicio(connexion,estadosflujoscajas));
			}

			if(clas.clas.equals(Periodo.class)) {
				estadosflujoscajas.setPeriodo(estadosflujoscajasDataAccess.getPeriodo(connexion,estadosflujoscajas));
			}

			if(clas.clas.equals(CentroActividad.class)) {
				estadosflujoscajas.setCentroActividad(estadosflujoscajasDataAccess.getCentroActividad(connexion,estadosflujoscajas));
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
			estadosflujoscajas.setEmpresa(estadosflujoscajasDataAccess.getEmpresa(connexion,estadosflujoscajas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosflujoscajas.setEjercicio(estadosflujoscajasDataAccess.getEjercicio(connexion,estadosflujoscajas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosflujoscajas.setPeriodo(estadosflujoscajasDataAccess.getPeriodo(connexion,estadosflujoscajas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosflujoscajas.setCentroActividad(estadosflujoscajasDataAccess.getCentroActividad(connexion,estadosflujoscajas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadosflujoscajas.setEmpresa(estadosflujoscajasDataAccess.getEmpresa(connexion,estadosflujoscajas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(estadosflujoscajas.getEmpresa(),isDeep,deepLoadType,clases);
				
		estadosflujoscajas.setEjercicio(estadosflujoscajasDataAccess.getEjercicio(connexion,estadosflujoscajas));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(estadosflujoscajas.getEjercicio(),isDeep,deepLoadType,clases);
				
		estadosflujoscajas.setPeriodo(estadosflujoscajasDataAccess.getPeriodo(connexion,estadosflujoscajas));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(estadosflujoscajas.getPeriodo(),isDeep,deepLoadType,clases);
				
		estadosflujoscajas.setCentroActividad(estadosflujoscajasDataAccess.getCentroActividad(connexion,estadosflujoscajas));
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(estadosflujoscajas.getCentroActividad(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadosflujoscajas.setEmpresa(estadosflujoscajasDataAccess.getEmpresa(connexion,estadosflujoscajas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(estadosflujoscajas.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				estadosflujoscajas.setEjercicio(estadosflujoscajasDataAccess.getEjercicio(connexion,estadosflujoscajas));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(estadosflujoscajas.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Periodo.class)) {
				estadosflujoscajas.setPeriodo(estadosflujoscajasDataAccess.getPeriodo(connexion,estadosflujoscajas));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(estadosflujoscajas.getPeriodo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(CentroActividad.class)) {
				estadosflujoscajas.setCentroActividad(estadosflujoscajasDataAccess.getCentroActividad(connexion,estadosflujoscajas));
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepLoad(estadosflujoscajas.getCentroActividad(),isDeep,deepLoadType,clases);				
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
			estadosflujoscajas.setEmpresa(estadosflujoscajasDataAccess.getEmpresa(connexion,estadosflujoscajas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(estadosflujoscajas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosflujoscajas.setEjercicio(estadosflujoscajasDataAccess.getEjercicio(connexion,estadosflujoscajas));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(estadosflujoscajas.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosflujoscajas.setPeriodo(estadosflujoscajasDataAccess.getPeriodo(connexion,estadosflujoscajas));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(estadosflujoscajas.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadosflujoscajas.setCentroActividad(estadosflujoscajasDataAccess.getCentroActividad(connexion,estadosflujoscajas));
			CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
			centroactividadLogic.deepLoad(estadosflujoscajas.getCentroActividad(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(estadosflujoscajas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadosFlujosCajasConstantesFunciones.refrescarForeignKeysDescripcionesEstadosFlujosCajas(estadosflujoscajas);
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
			this.deepLoad(this.estadosflujoscajas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadosFlujosCajasConstantesFunciones.refrescarForeignKeysDescripcionesEstadosFlujosCajas(this.estadosflujoscajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(estadosflujoscajass!=null) {
				for(EstadosFlujosCajas estadosflujoscajas:estadosflujoscajass) {
					this.deepLoad(estadosflujoscajas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadosFlujosCajasConstantesFunciones.refrescarForeignKeysDescripcionesEstadosFlujosCajas(estadosflujoscajass);
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
			if(estadosflujoscajass!=null) {
				for(EstadosFlujosCajas estadosflujoscajas:estadosflujoscajass) {
					this.deepLoad(estadosflujoscajas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadosFlujosCajasConstantesFunciones.refrescarForeignKeysDescripcionesEstadosFlujosCajas(estadosflujoscajass);
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
	
	public EstadosFlujosCajasParameterReturnGeneral procesarAccionEstadosFlujosCajass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadosFlujosCajas> estadosflujoscajass,EstadosFlujosCajasParameterReturnGeneral estadosflujoscajasParameterGeneral)throws Exception {
		 try {	
			EstadosFlujosCajasParameterReturnGeneral estadosflujoscajasReturnGeneral=new EstadosFlujosCajasParameterReturnGeneral();
	
			EstadosFlujosCajasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadosflujoscajass,estadosflujoscajasParameterGeneral,estadosflujoscajasReturnGeneral);
			
			return estadosflujoscajasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadosFlujosCajasParameterReturnGeneral procesarAccionEstadosFlujosCajassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadosFlujosCajas> estadosflujoscajass,EstadosFlujosCajasParameterReturnGeneral estadosflujoscajasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			EstadosFlujosCajasParameterReturnGeneral estadosflujoscajasReturnGeneral=new EstadosFlujosCajasParameterReturnGeneral();
	
			EstadosFlujosCajasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadosflujoscajass,estadosflujoscajasParameterGeneral,estadosflujoscajasReturnGeneral);
			
			this.connexion.commit();
			
			return estadosflujoscajasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

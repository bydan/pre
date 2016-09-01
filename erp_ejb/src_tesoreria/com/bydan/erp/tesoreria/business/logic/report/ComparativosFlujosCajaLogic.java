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
import com.bydan.erp.tesoreria.util.report.ComparativosFlujosCajaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ComparativosFlujosCajaParameterGeneral;
import com.bydan.erp.tesoreria.util.report.ComparativosFlujosCajaConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.ComparativosFlujosCaja;

import com.bydan.erp.tesoreria.business.logic.report.ComparativosFlujosCajaLogicAdditional;
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
public class ComparativosFlujosCajaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ComparativosFlujosCajaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ComparativosFlujosCajaLogic comparativosflujoscajaDataAccess; 		
	protected ComparativosFlujosCaja comparativosflujoscaja;
	protected List<ComparativosFlujosCaja> comparativosflujoscajas;
	protected Object comparativosflujoscajaObject;	
	protected List<Object> comparativosflujoscajasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ComparativosFlujosCajaLogic()throws SQLException,Exception {
		try	{
			this.comparativosflujoscajas= new ArrayList<ComparativosFlujosCaja>();
			this.comparativosflujoscaja= new ComparativosFlujosCaja();
			this.comparativosflujoscajaObject=new Object();
			this.comparativosflujoscajasObject=new ArrayList<Object>();
			
			this.comparativosflujoscajaDataAccess=this;
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
			this.comparativosflujoscajaDataAccess.setConnexionType(this.connexionType);
			this.comparativosflujoscajaDataAccess.setParameterDbType(this.parameterDbType);
			this.comparativosflujoscajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComparativosFlujosCajaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.comparativosflujoscajas= new ArrayList<ComparativosFlujosCaja>();
			this.comparativosflujoscaja= new ComparativosFlujosCaja();
			this.comparativosflujoscajaObject=new Object();
			this.comparativosflujoscajasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.comparativosflujoscajaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.comparativosflujoscajaDataAccess.setConnexionType(this.connexionType);
			this.comparativosflujoscajaDataAccess.setParameterDbType(this.parameterDbType);
			this.comparativosflujoscajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComparativosFlujosCaja getComparativosFlujosCaja() throws Exception {	
		ComparativosFlujosCajaLogicAdditional.checkComparativosFlujosCajaToGet(comparativosflujoscaja,this.datosCliente,this.arrDatoGeneral);
		ComparativosFlujosCajaLogicAdditional.updateComparativosFlujosCajaToGet(comparativosflujoscaja,this.arrDatoGeneral);
		
		return comparativosflujoscaja;
	}
		
	public void setComparativosFlujosCaja(ComparativosFlujosCaja newComparativosFlujosCaja) {
		this.comparativosflujoscaja = newComparativosFlujosCaja;
	}
	
	public List<ComparativosFlujosCaja> getComparativosFlujosCajas() throws Exception {		
		this.quitarComparativosFlujosCajasNulos();
		
		ComparativosFlujosCajaLogicAdditional.checkComparativosFlujosCajaToGets(comparativosflujoscajas,this.datosCliente,this.arrDatoGeneral);
		
		for (ComparativosFlujosCaja comparativosflujoscajaLocal: comparativosflujoscajas ) {
			ComparativosFlujosCajaLogicAdditional.updateComparativosFlujosCajaToGet(comparativosflujoscajaLocal,this.arrDatoGeneral);
		}
		
		return comparativosflujoscajas;
	}
	
	public void setComparativosFlujosCajas(List<ComparativosFlujosCaja> newComparativosFlujosCajas) {
		this.comparativosflujoscajas = newComparativosFlujosCajas;
	}
	
	public Object getComparativosFlujosCajaObject() {	
		//this.comparativosflujoscajaObject=this.comparativosflujoscajaDataAccess.getEntityObject();
		return this.comparativosflujoscajaObject;
	}
		
	public void setComparativosFlujosCajaObject(Object newComparativosFlujosCajaObject) {
		this.comparativosflujoscajaObject = newComparativosFlujosCajaObject;
	}
	
	public List<Object> getComparativosFlujosCajasObject() {		
		//this.comparativosflujoscajasObject=this.comparativosflujoscajaDataAccess.getEntitiesObject();
		return this.comparativosflujoscajasObject;
	}
		
	public void setComparativosFlujosCajasObject(List<Object> newComparativosFlujosCajasObject) {
		this.comparativosflujoscajasObject = newComparativosFlujosCajasObject;
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
		comparativosflujoscajas = new  ArrayList<ComparativosFlujosCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComparativosFlujosCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comparativosflujoscajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		comparativosflujoscajas = new  ArrayList<ComparativosFlujosCaja>();
		  		  
        try {
			//ComparativosFlujosCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comparativosflujoscajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comparativosflujoscajas = new  ArrayList<ComparativosFlujosCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComparativosFlujosCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comparativosflujoscajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comparativosflujoscajas = new  ArrayList<ComparativosFlujosCaja>();
		  		  
        try {
			//ComparativosFlujosCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comparativosflujoscajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		comparativosflujoscajas = new  ArrayList<ComparativosFlujosCaja>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComparativosFlujosCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comparativosflujoscajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comparativosflujoscajas = new  ArrayList<ComparativosFlujosCaja>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ComparativosFlujosCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comparativosflujoscajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ComparativosFlujosCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComparativosFlujosCaja> entities = new  ArrayList<ComparativosFlujosCaja>();
		ComparativosFlujosCaja entity = new ComparativosFlujosCaja();		  
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
	
	public  List<ComparativosFlujosCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComparativosFlujosCaja> entities = new  ArrayList<ComparativosFlujosCaja>();
		ComparativosFlujosCaja entity = new ComparativosFlujosCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComparativosFlujosCaja();
				
				
      	    	entity=ComparativosFlujosCajaLogic.getEntityComparativosFlujosCaja("",entity,resultSet);
      	    	
				//entity.setComparativosFlujosCajaOriginal( new ComparativosFlujosCaja());
      	    	//entity.setComparativosFlujosCajaOriginal(super.getEntity("",entity.getComparativosFlujosCajaOriginal(),resultSet,ComparativosFlujosCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComparativosFlujosCajaOriginal(ComparativosFlujosCajaDataAccess.getEntityComparativosFlujosCaja("",entity.getComparativosFlujosCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ComparativosFlujosCaja> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComparativosFlujosCaja> entities = new  ArrayList<ComparativosFlujosCaja>();
		ComparativosFlujosCaja entity = new ComparativosFlujosCaja();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ComparativosFlujosCaja.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComparativosFlujosCaja>((List<ComparativosFlujosCaja>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComparativosFlujosCajasOriginal(entities);
			
			}  else {
				this.comparativosflujoscajasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComparativosFlujosCajaConstantesFunciones.quitarEspaciosComparativosFlujosCajas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ComparativosFlujosCaja getEntityComparativosFlujosCaja(String strPrefijo,ComparativosFlujosCaja entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_centro_actividad(resultSet.getString(strPrefijo+ComparativosFlujosCajaConstantesFunciones.NOMBRECENTROACTIVIDAD));
			entity.settipo_movimiento(resultSet.getString(strPrefijo+ComparativosFlujosCajaConstantesFunciones.TIPOMOVIMIENTO));
			entity.setsaldo_actual(resultSet.getDouble(strPrefijo+ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL));
			entity.setsaldo_acumulado(resultSet.getDouble(strPrefijo+ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO));
			entity.setsaldo_pres_actual(resultSet.getDouble(strPrefijo+ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL));
			entity.setsaldo_pres_acumulado(resultSet.getDouble(strPrefijo+ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComparativosFlujosCaja getEntityComparativosFlujosCaja(String strPrefijo,ComparativosFlujosCaja entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ComparativosFlujosCaja.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ComparativosFlujosCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ComparativosFlujosCajaLogic.setFieldReflectionComparativosFlujosCaja(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComparativosFlujosCaja(Field field,String strPrefijo,String sColumn,ComparativosFlujosCaja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComparativosFlujosCajaConstantesFunciones.NOMBRECENTROACTIVIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComparativosFlujosCajaConstantesFunciones.TIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO:
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
	
	public void quitarComparativosFlujosCajasNulos() throws Exception {				
		
		List<ComparativosFlujosCaja> comparativosflujoscajasAux= new ArrayList<ComparativosFlujosCaja>();
		
		for(ComparativosFlujosCaja comparativosflujoscaja:comparativosflujoscajas) {
			if(comparativosflujoscaja!=null) {
				comparativosflujoscajasAux.add(comparativosflujoscaja);
			}
		}
		
		comparativosflujoscajas=comparativosflujoscajasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ComparativosFlujosCaja> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComparativosFlujosCaja> entities = new  ArrayList<ComparativosFlujosCaja>();
		ComparativosFlujosCaja entity = new ComparativosFlujosCaja();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComparativosFlujosCaja>((List<ComparativosFlujosCaja>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComparativosFlujosCajasOriginal(entities);
			
			}  else {
				this.comparativosflujoscajasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComparativosFlujosCajaConstantesFunciones.quitarEspaciosComparativosFlujosCajas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		comparativosflujoscajas = new  ArrayList<ComparativosFlujosCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComparativosFlujosCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comparativosflujoscajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		comparativosflujoscajas = new  ArrayList<ComparativosFlujosCaja>();
		  		  
        try {
			//ComparativosFlujosCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comparativosflujoscajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ComparativosFlujosCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComparativosFlujosCaja> entities = new  ArrayList<ComparativosFlujosCaja>();
		ComparativosFlujosCaja entity = new ComparativosFlujosCaja();		  
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
	
	public  List<ComparativosFlujosCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComparativosFlujosCaja> entities = new  ArrayList<ComparativosFlujosCaja>();
		ComparativosFlujosCaja entity = new ComparativosFlujosCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComparativosFlujosCaja();
				
				if(conMapGenerico) {
					entity.setMapComparativosFlujosCaja( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapComparativosFlujosCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComparativosFlujosCajaDataAccess.ISWITHSCHEMA);         		
					entity=ComparativosFlujosCajaLogic.getEntityComparativosFlujosCaja("",entity,resultSet,listColumns);
					
					////entity.setComparativosFlujosCajaOriginal( new ComparativosFlujosCaja());
					////entity.setComparativosFlujosCajaOriginal(super.getEntity("",entity.getComparativosFlujosCajaOriginal(),resultSet,ComparativosFlujosCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setComparativosFlujosCajaOriginal(ComparativosFlujosCajaDataAccess.getEntityComparativosFlujosCaja("",entity.getComparativosFlujosCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ComparativosFlujosCaja relcomparativosflujoscaja)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcomparativosflujoscaja.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,ComparativosFlujosCaja relcomparativosflujoscaja)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relcomparativosflujoscaja.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}


	
	
	public void getComparativosFlujosCajasBusquedaComparativosFlujosCajaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio)throws Exception {
		try {
			//ComparativosFlujosCajaLogic comparativosflujoscajaLogic=new ComparativosFlujosCajaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComparativosFlujosCajaLogic.GetSelecSqlComparativosFlujosCaja(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comparativosflujoscajas=this.getComparativosFlujosCajas();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getComparativosFlujosCajasBusquedaComparativosFlujosCaja(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio)throws Exception {
		try {
			//ComparativosFlujosCajaLogic comparativosflujoscajaLogic=new ComparativosFlujosCajaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComparativosFlujosCajaLogic.GetSelecSqlComparativosFlujosCaja(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comparativosflujoscajas=this.getComparativosFlujosCajas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlComparativosFlujosCaja(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ComparativosFlujosCaja_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" d.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" d.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_ejercicio = "+id_ejercicio.toString();
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
	
	
	public void deepLoad(ComparativosFlujosCaja comparativosflujoscaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComparativosFlujosCajaLogicAdditional.updateComparativosFlujosCajaToGet(comparativosflujoscaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comparativosflujoscaja.setEmpresa(comparativosflujoscajaDataAccess.getEmpresa(connexion,comparativosflujoscaja));
		comparativosflujoscaja.setEjercicio(comparativosflujoscajaDataAccess.getEjercicio(connexion,comparativosflujoscaja));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comparativosflujoscaja.setEmpresa(comparativosflujoscajaDataAccess.getEmpresa(connexion,comparativosflujoscaja));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				comparativosflujoscaja.setEjercicio(comparativosflujoscajaDataAccess.getEjercicio(connexion,comparativosflujoscaja));
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
			comparativosflujoscaja.setEmpresa(comparativosflujoscajaDataAccess.getEmpresa(connexion,comparativosflujoscaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comparativosflujoscaja.setEjercicio(comparativosflujoscajaDataAccess.getEjercicio(connexion,comparativosflujoscaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comparativosflujoscaja.setEmpresa(comparativosflujoscajaDataAccess.getEmpresa(connexion,comparativosflujoscaja));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comparativosflujoscaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		comparativosflujoscaja.setEjercicio(comparativosflujoscajaDataAccess.getEjercicio(connexion,comparativosflujoscaja));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(comparativosflujoscaja.getEjercicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comparativosflujoscaja.setEmpresa(comparativosflujoscajaDataAccess.getEmpresa(connexion,comparativosflujoscaja));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comparativosflujoscaja.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				comparativosflujoscaja.setEjercicio(comparativosflujoscajaDataAccess.getEjercicio(connexion,comparativosflujoscaja));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(comparativosflujoscaja.getEjercicio(),isDeep,deepLoadType,clases);				
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
			comparativosflujoscaja.setEmpresa(comparativosflujoscajaDataAccess.getEmpresa(connexion,comparativosflujoscaja));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comparativosflujoscaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comparativosflujoscaja.setEjercicio(comparativosflujoscajaDataAccess.getEjercicio(connexion,comparativosflujoscaja));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(comparativosflujoscaja.getEjercicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(comparativosflujoscaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComparativosFlujosCajaConstantesFunciones.refrescarForeignKeysDescripcionesComparativosFlujosCaja(comparativosflujoscaja);
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
			this.deepLoad(this.comparativosflujoscaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComparativosFlujosCajaConstantesFunciones.refrescarForeignKeysDescripcionesComparativosFlujosCaja(this.comparativosflujoscaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(comparativosflujoscajas!=null) {
				for(ComparativosFlujosCaja comparativosflujoscaja:comparativosflujoscajas) {
					this.deepLoad(comparativosflujoscaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComparativosFlujosCajaConstantesFunciones.refrescarForeignKeysDescripcionesComparativosFlujosCaja(comparativosflujoscajas);
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
			if(comparativosflujoscajas!=null) {
				for(ComparativosFlujosCaja comparativosflujoscaja:comparativosflujoscajas) {
					this.deepLoad(comparativosflujoscaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComparativosFlujosCajaConstantesFunciones.refrescarForeignKeysDescripcionesComparativosFlujosCaja(comparativosflujoscajas);
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
	
	public ComparativosFlujosCajaParameterReturnGeneral procesarAccionComparativosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComparativosFlujosCaja> comparativosflujoscajas,ComparativosFlujosCajaParameterReturnGeneral comparativosflujoscajaParameterGeneral)throws Exception {
		 try {	
			ComparativosFlujosCajaParameterReturnGeneral comparativosflujoscajaReturnGeneral=new ComparativosFlujosCajaParameterReturnGeneral();
	
			ComparativosFlujosCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comparativosflujoscajas,comparativosflujoscajaParameterGeneral,comparativosflujoscajaReturnGeneral);
			
			return comparativosflujoscajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComparativosFlujosCajaParameterReturnGeneral procesarAccionComparativosFlujosCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComparativosFlujosCaja> comparativosflujoscajas,ComparativosFlujosCajaParameterReturnGeneral comparativosflujoscajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ComparativosFlujosCajaParameterReturnGeneral comparativosflujoscajaReturnGeneral=new ComparativosFlujosCajaParameterReturnGeneral();
	
			ComparativosFlujosCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comparativosflujoscajas,comparativosflujoscajaParameterGeneral,comparativosflujoscajaReturnGeneral);
			
			this.connexion.commit();
			
			return comparativosflujoscajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

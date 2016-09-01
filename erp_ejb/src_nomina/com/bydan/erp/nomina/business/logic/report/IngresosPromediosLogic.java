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
package com.bydan.erp.nomina.business.logic.report;

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

import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;
import com.bydan.erp.nomina.util.report.IngresosPromediosParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.IngresosPromediosParameterGeneral;
import com.bydan.erp.nomina.util.report.IngresosPromediosConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.IngresosPromedios;

import com.bydan.erp.nomina.business.logic.report.IngresosPromediosLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class IngresosPromediosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(IngresosPromediosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected IngresosPromediosLogic ingresospromediosDataAccess; 		
	protected IngresosPromedios ingresospromedios;
	protected List<IngresosPromedios> ingresospromedioss;
	protected Object ingresospromediosObject;	
	protected List<Object> ingresospromediossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  IngresosPromediosLogic()throws SQLException,Exception {
		try	{
			this.ingresospromedioss= new ArrayList<IngresosPromedios>();
			this.ingresospromedios= new IngresosPromedios();
			this.ingresospromediosObject=new Object();
			this.ingresospromediossObject=new ArrayList<Object>();
			
			this.ingresospromediosDataAccess=this;
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
			this.ingresospromediosDataAccess.setConnexionType(this.connexionType);
			this.ingresospromediosDataAccess.setParameterDbType(this.parameterDbType);
			this.ingresospromediosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  IngresosPromediosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.ingresospromedioss= new ArrayList<IngresosPromedios>();
			this.ingresospromedios= new IngresosPromedios();
			this.ingresospromediosObject=new Object();
			this.ingresospromediossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.ingresospromediosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.ingresospromediosDataAccess.setConnexionType(this.connexionType);
			this.ingresospromediosDataAccess.setParameterDbType(this.parameterDbType);
			this.ingresospromediosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public IngresosPromedios getIngresosPromedios() throws Exception {	
		IngresosPromediosLogicAdditional.checkIngresosPromediosToGet(ingresospromedios,this.datosCliente,this.arrDatoGeneral);
		IngresosPromediosLogicAdditional.updateIngresosPromediosToGet(ingresospromedios,this.arrDatoGeneral);
		
		return ingresospromedios;
	}
		
	public void setIngresosPromedios(IngresosPromedios newIngresosPromedios) {
		this.ingresospromedios = newIngresosPromedios;
	}
	
	public List<IngresosPromedios> getIngresosPromedioss() throws Exception {		
		this.quitarIngresosPromediossNulos();
		
		IngresosPromediosLogicAdditional.checkIngresosPromediosToGets(ingresospromedioss,this.datosCliente,this.arrDatoGeneral);
		
		for (IngresosPromedios ingresospromediosLocal: ingresospromedioss ) {
			IngresosPromediosLogicAdditional.updateIngresosPromediosToGet(ingresospromediosLocal,this.arrDatoGeneral);
		}
		
		return ingresospromedioss;
	}
	
	public void setIngresosPromedioss(List<IngresosPromedios> newIngresosPromedioss) {
		this.ingresospromedioss = newIngresosPromedioss;
	}
	
	public Object getIngresosPromediosObject() {	
		//this.ingresospromediosObject=this.ingresospromediosDataAccess.getEntityObject();
		return this.ingresospromediosObject;
	}
		
	public void setIngresosPromediosObject(Object newIngresosPromediosObject) {
		this.ingresospromediosObject = newIngresosPromediosObject;
	}
	
	public List<Object> getIngresosPromediossObject() {		
		//this.ingresospromediossObject=this.ingresospromediosDataAccess.getEntitiesObject();
		return this.ingresospromediossObject;
	}
		
	public void setIngresosPromediossObject(List<Object> newIngresosPromediossObject) {
		this.ingresospromediossObject = newIngresosPromediossObject;
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
		ingresospromedioss = new  ArrayList<IngresosPromedios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//IngresosPromediosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingresospromedioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		ingresospromedioss = new  ArrayList<IngresosPromedios>();
		  		  
        try {
			//IngresosPromediosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingresospromedioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ingresospromedioss = new  ArrayList<IngresosPromedios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//IngresosPromediosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingresospromedioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		ingresospromedioss = new  ArrayList<IngresosPromedios>();
		  		  
        try {
			//IngresosPromediosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingresospromedioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		ingresospromedioss = new  ArrayList<IngresosPromedios>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//IngresosPromediosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingresospromedioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		ingresospromedioss = new  ArrayList<IngresosPromedios>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//IngresosPromediosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingresospromedioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<IngresosPromedios> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<IngresosPromedios> entities = new  ArrayList<IngresosPromedios>();
		IngresosPromedios entity = new IngresosPromedios();		  
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
	
	public  List<IngresosPromedios> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<IngresosPromedios> entities = new  ArrayList<IngresosPromedios>();
		IngresosPromedios entity = new IngresosPromedios();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new IngresosPromedios();
				
				
      	    	entity=IngresosPromediosLogic.getEntityIngresosPromedios("",entity,resultSet);
      	    	
				//entity.setIngresosPromediosOriginal( new IngresosPromedios());
      	    	//entity.setIngresosPromediosOriginal(super.getEntity("",entity.getIngresosPromediosOriginal(),resultSet,IngresosPromediosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setIngresosPromediosOriginal(IngresosPromediosDataAccess.getEntityIngresosPromedios("",entity.getIngresosPromediosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<IngresosPromedios> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<IngresosPromedios> entities = new  ArrayList<IngresosPromedios>();
		IngresosPromedios entity = new IngresosPromedios();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,IngresosPromedios.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<IngresosPromedios>((List<IngresosPromedios>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setIngresosPromediossOriginal(entities);
			
			}  else {
				this.ingresospromediossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//IngresosPromediosConstantesFunciones.quitarEspaciosIngresosPromedioss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static IngresosPromedios getEntityIngresosPromedios(String strPrefijo,IngresosPromedios entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_cargo(resultSet.getString(strPrefijo+IngresosPromediosConstantesFunciones.CODIGOCARGO));
			entity.setcodigo_dato(resultSet.getString(strPrefijo+IngresosPromediosConstantesFunciones.CODIGODATO));
			entity.setnombre(resultSet.getString(strPrefijo+IngresosPromediosConstantesFunciones.NOMBRE));
			entity.setvalor_pago(resultSet.getDouble(strPrefijo+IngresosPromediosConstantesFunciones.VALORPAGO));
			entity.setnombre_rubro_emplea(resultSet.getString(strPrefijo+IngresosPromediosConstantesFunciones.NOMBRERUBROEMPLEA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static IngresosPromedios getEntityIngresosPromedios(String strPrefijo,IngresosPromedios entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = IngresosPromedios.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = IngresosPromedios.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				IngresosPromediosLogic.setFieldReflectionIngresosPromedios(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionIngresosPromedios(Field field,String strPrefijo,String sColumn,IngresosPromedios entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case IngresosPromediosConstantesFunciones.CODIGOCARGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case IngresosPromediosConstantesFunciones.CODIGODATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case IngresosPromediosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case IngresosPromediosConstantesFunciones.VALORPAGO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case IngresosPromediosConstantesFunciones.NOMBRERUBROEMPLEA:
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
	
	public void quitarIngresosPromediossNulos() throws Exception {				
		
		List<IngresosPromedios> ingresospromediossAux= new ArrayList<IngresosPromedios>();
		
		for(IngresosPromedios ingresospromedios:ingresospromedioss) {
			if(ingresospromedios!=null) {
				ingresospromediossAux.add(ingresospromedios);
			}
		}
		
		ingresospromedioss=ingresospromediossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<IngresosPromedios> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<IngresosPromedios> entities = new  ArrayList<IngresosPromedios>();
		IngresosPromedios entity = new IngresosPromedios();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<IngresosPromedios>((List<IngresosPromedios>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setIngresosPromediossOriginal(entities);
			
			}  else {
				this.ingresospromediossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//IngresosPromediosConstantesFunciones.quitarEspaciosIngresosPromedioss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		ingresospromedioss = new  ArrayList<IngresosPromedios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//IngresosPromediosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingresospromedioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		ingresospromedioss = new  ArrayList<IngresosPromedios>();
		  		  
        try {
			//IngresosPromediosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingresospromedioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<IngresosPromedios> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<IngresosPromedios> entities = new  ArrayList<IngresosPromedios>();
		IngresosPromedios entity = new IngresosPromedios();		  
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
	
	public  List<IngresosPromedios> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<IngresosPromedios> entities = new  ArrayList<IngresosPromedios>();
		IngresosPromedios entity = new IngresosPromedios();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new IngresosPromedios();
				
				if(conMapGenerico) {
					entity.setMapIngresosPromedios( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapIngresosPromedios().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,IngresosPromediosDataAccess.ISWITHSCHEMA);         		
					entity=IngresosPromediosLogic.getEntityIngresosPromedios("",entity,resultSet,listColumns);
					
					////entity.setIngresosPromediosOriginal( new IngresosPromedios());
					////entity.setIngresosPromediosOriginal(super.getEntity("",entity.getIngresosPromediosOriginal(),resultSet,IngresosPromediosDataAccess.ISWITHSCHEMA));         		
					////entity.setIngresosPromediosOriginal(IngresosPromediosDataAccess.getEntityIngresosPromedios("",entity.getIngresosPromediosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Estructura getEstructura(Connexion connexion,IngresosPromedios relingresospromedios)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			estructura=estructuraDataAccess.getEntity(connexion,relingresospromedios.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empresa getEmpresa(Connexion connexion,IngresosPromedios relingresospromedios)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relingresospromedios.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Anio getAnio(Connexion connexion,IngresosPromedios relingresospromedios)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,relingresospromedios.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,IngresosPromedios relingresospromedios)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);
			mesDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			mes=mesDataAccess.getEntity(connexion,relingresospromedios.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


	
	
	public void getIngresosPromediossBusquedaIngresosPromediosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_estructura,String codigo,Long id_anio,Long id_mes)throws Exception {
		try {
			//IngresosPromediosLogic ingresospromediosLogic=new IngresosPromediosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=IngresosPromediosLogic.GetSelecSqlIngresosPromedios(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_estructura,codigo,id_anio,id_mes);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.ingresospromedioss=this.getIngresosPromedioss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getIngresosPromediossBusquedaIngresosPromedios(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_estructura,String codigo,Long id_anio,Long id_mes)throws Exception {
		try {
			//IngresosPromediosLogic ingresospromediosLogic=new IngresosPromediosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=IngresosPromediosLogic.GetSelecSqlIngresosPromedios(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_estructura,codigo,id_anio,id_mes);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.ingresospromedioss=this.getIngresosPromedioss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlIngresosPromedios(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_estructura,String codigo,Long id_anio,Long id_mes)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("IngresosPromedios_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" e.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" e.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_estructura!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.id_estructura = "+id_estructura.toString();
					existeWhere=true;
				}

				if(codigo!= null && !codigo.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.codigo = "+"'"+codigo+"'";
					existeWhere=true;
				}

				if(id_anio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_anio = "+id_anio.toString();
					existeWhere=true;
				}

				if(id_mes!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_mes = "+id_mes.toString();
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
	
	
	public void deepLoad(IngresosPromedios ingresospromedios,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			IngresosPromediosLogicAdditional.updateIngresosPromediosToGet(ingresospromedios,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ingresospromedios.setEstructura(ingresospromediosDataAccess.getEstructura(connexion,ingresospromedios));
		ingresospromedios.setEmpresa(ingresospromediosDataAccess.getEmpresa(connexion,ingresospromedios));
		ingresospromedios.setAnio(ingresospromediosDataAccess.getAnio(connexion,ingresospromedios));
		ingresospromedios.setMes(ingresospromediosDataAccess.getMes(connexion,ingresospromedios));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				ingresospromedios.setEstructura(ingresospromediosDataAccess.getEstructura(connexion,ingresospromedios));
			}

			if(clas.clas.equals(Empresa.class)) {
				ingresospromedios.setEmpresa(ingresospromediosDataAccess.getEmpresa(connexion,ingresospromedios));
			}

			if(clas.clas.equals(Anio.class)) {
				ingresospromedios.setAnio(ingresospromediosDataAccess.getAnio(connexion,ingresospromedios));
			}

			if(clas.clas.equals(Mes.class)) {
				ingresospromedios.setMes(ingresospromediosDataAccess.getMes(connexion,ingresospromedios));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingresospromedios.setEstructura(ingresospromediosDataAccess.getEstructura(connexion,ingresospromedios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingresospromedios.setEmpresa(ingresospromediosDataAccess.getEmpresa(connexion,ingresospromedios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingresospromedios.setAnio(ingresospromediosDataAccess.getAnio(connexion,ingresospromedios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingresospromedios.setMes(ingresospromediosDataAccess.getMes(connexion,ingresospromedios));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ingresospromedios.setEstructura(ingresospromediosDataAccess.getEstructura(connexion,ingresospromedios));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(ingresospromedios.getEstructura(),isDeep,deepLoadType,clases);
				
		ingresospromedios.setEmpresa(ingresospromediosDataAccess.getEmpresa(connexion,ingresospromedios));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ingresospromedios.getEmpresa(),isDeep,deepLoadType,clases);
				
		ingresospromedios.setAnio(ingresospromediosDataAccess.getAnio(connexion,ingresospromedios));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(ingresospromedios.getAnio(),isDeep,deepLoadType,clases);
				
		ingresospromedios.setMes(ingresospromediosDataAccess.getMes(connexion,ingresospromedios));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(ingresospromedios.getMes(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				ingresospromedios.setEstructura(ingresospromediosDataAccess.getEstructura(connexion,ingresospromedios));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(ingresospromedios.getEstructura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				ingresospromedios.setEmpresa(ingresospromediosDataAccess.getEmpresa(connexion,ingresospromedios));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ingresospromedios.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Anio.class)) {
				ingresospromedios.setAnio(ingresospromediosDataAccess.getAnio(connexion,ingresospromedios));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(ingresospromedios.getAnio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Mes.class)) {
				ingresospromedios.setMes(ingresospromediosDataAccess.getMes(connexion,ingresospromedios));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(ingresospromedios.getMes(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingresospromedios.setEstructura(ingresospromediosDataAccess.getEstructura(connexion,ingresospromedios));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(ingresospromedios.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingresospromedios.setEmpresa(ingresospromediosDataAccess.getEmpresa(connexion,ingresospromedios));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ingresospromedios.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingresospromedios.setAnio(ingresospromediosDataAccess.getAnio(connexion,ingresospromedios));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(ingresospromedios.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingresospromedios.setMes(ingresospromediosDataAccess.getMes(connexion,ingresospromedios));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(ingresospromedios.getMes(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(ingresospromedios,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				IngresosPromediosConstantesFunciones.refrescarForeignKeysDescripcionesIngresosPromedios(ingresospromedios);
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
			this.deepLoad(this.ingresospromedios,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				IngresosPromediosConstantesFunciones.refrescarForeignKeysDescripcionesIngresosPromedios(this.ingresospromedios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(ingresospromedioss!=null) {
				for(IngresosPromedios ingresospromedios:ingresospromedioss) {
					this.deepLoad(ingresospromedios,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					IngresosPromediosConstantesFunciones.refrescarForeignKeysDescripcionesIngresosPromedios(ingresospromedioss);
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
			if(ingresospromedioss!=null) {
				for(IngresosPromedios ingresospromedios:ingresospromedioss) {
					this.deepLoad(ingresospromedios,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					IngresosPromediosConstantesFunciones.refrescarForeignKeysDescripcionesIngresosPromedios(ingresospromedioss);
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
	
	public IngresosPromediosParameterReturnGeneral procesarAccionIngresosPromedioss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<IngresosPromedios> ingresospromedioss,IngresosPromediosParameterReturnGeneral ingresospromediosParameterGeneral)throws Exception {
		 try {	
			IngresosPromediosParameterReturnGeneral ingresospromediosReturnGeneral=new IngresosPromediosParameterReturnGeneral();
	
			IngresosPromediosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ingresospromedioss,ingresospromediosParameterGeneral,ingresospromediosReturnGeneral);
			
			return ingresospromediosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public IngresosPromediosParameterReturnGeneral procesarAccionIngresosPromediossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<IngresosPromedios> ingresospromedioss,IngresosPromediosParameterReturnGeneral ingresospromediosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			IngresosPromediosParameterReturnGeneral ingresospromediosReturnGeneral=new IngresosPromediosParameterReturnGeneral();
	
			IngresosPromediosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ingresospromedioss,ingresospromediosParameterGeneral,ingresospromediosReturnGeneral);
			
			this.connexion.commit();
			
			return ingresospromediosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

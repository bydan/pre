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
package com.bydan.erp.facturacion.business.logic.report;

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

import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.resources.general.AuxiliarGeneral;
import com.bydan.erp.facturacion.util.report.ProcesoRecibosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.ProcesoRecibosParameterGeneral;
import com.bydan.erp.facturacion.util.report.ProcesoRecibosConstantesFunciones;
import com.bydan.erp.facturacion.business.entity.report.ProcesoRecibos;

import com.bydan.erp.facturacion.business.logic.report.ProcesoRecibosLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoRecibosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoRecibosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoRecibosLogic procesorecibosDataAccess; 		
	protected ProcesoRecibos procesorecibos;
	protected List<ProcesoRecibos> procesoreciboss;
	protected Object procesorecibosObject;	
	protected List<Object> procesorecibossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoRecibosLogic()throws SQLException,Exception {
		try	{
			this.procesoreciboss= new ArrayList<ProcesoRecibos>();
			this.procesorecibos= new ProcesoRecibos();
			this.procesorecibosObject=new Object();
			this.procesorecibossObject=new ArrayList<Object>();
			
			this.procesorecibosDataAccess=this;
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
			this.procesorecibosDataAccess.setConnexionType(this.connexionType);
			this.procesorecibosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesorecibosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoRecibosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesoreciboss= new ArrayList<ProcesoRecibos>();
			this.procesorecibos= new ProcesoRecibos();
			this.procesorecibosObject=new Object();
			this.procesorecibossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesorecibosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesorecibosDataAccess.setConnexionType(this.connexionType);
			this.procesorecibosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesorecibosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoRecibos getProcesoRecibos() throws Exception {	
		ProcesoRecibosLogicAdditional.checkProcesoRecibosToGet(procesorecibos,this.datosCliente,this.arrDatoGeneral);
		ProcesoRecibosLogicAdditional.updateProcesoRecibosToGet(procesorecibos,this.arrDatoGeneral);
		
		return procesorecibos;
	}
		
	public void setProcesoRecibos(ProcesoRecibos newProcesoRecibos) {
		this.procesorecibos = newProcesoRecibos;
	}
	
	public List<ProcesoRecibos> getProcesoReciboss() throws Exception {		
		this.quitarProcesoRecibossNulos();
		
		ProcesoRecibosLogicAdditional.checkProcesoRecibosToGets(procesoreciboss,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoRecibos procesorecibosLocal: procesoreciboss ) {
			ProcesoRecibosLogicAdditional.updateProcesoRecibosToGet(procesorecibosLocal,this.arrDatoGeneral);
		}
		
		return procesoreciboss;
	}
	
	public void setProcesoReciboss(List<ProcesoRecibos> newProcesoReciboss) {
		this.procesoreciboss = newProcesoReciboss;
	}
	
	public Object getProcesoRecibosObject() {	
		//this.procesorecibosObject=this.procesorecibosDataAccess.getEntityObject();
		return this.procesorecibosObject;
	}
		
	public void setProcesoRecibosObject(Object newProcesoRecibosObject) {
		this.procesorecibosObject = newProcesoRecibosObject;
	}
	
	public List<Object> getProcesoRecibossObject() {		
		//this.procesorecibossObject=this.procesorecibosDataAccess.getEntitiesObject();
		return this.procesorecibossObject;
	}
		
	public void setProcesoRecibossObject(List<Object> newProcesoRecibossObject) {
		this.procesorecibossObject = newProcesoRecibossObject;
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
		procesoreciboss = new  ArrayList<ProcesoRecibos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoRecibosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoreciboss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesoreciboss = new  ArrayList<ProcesoRecibos>();
		  		  
        try {
			//ProcesoRecibosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoreciboss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesoreciboss = new  ArrayList<ProcesoRecibos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoRecibosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoreciboss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoreciboss = new  ArrayList<ProcesoRecibos>();
		  		  
        try {
			//ProcesoRecibosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoreciboss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesoreciboss = new  ArrayList<ProcesoRecibos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoRecibosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoreciboss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoreciboss = new  ArrayList<ProcesoRecibos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoRecibosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoreciboss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoRecibos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoRecibos> entities = new  ArrayList<ProcesoRecibos>();
		ProcesoRecibos entity = new ProcesoRecibos();		  
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
	
	public  List<ProcesoRecibos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoRecibos> entities = new  ArrayList<ProcesoRecibos>();
		ProcesoRecibos entity = new ProcesoRecibos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoRecibos();
				
				
      	    	entity=ProcesoRecibosLogic.getEntityProcesoRecibos("",entity,resultSet);
      	    	
				//entity.setProcesoRecibosOriginal( new ProcesoRecibos());
      	    	//entity.setProcesoRecibosOriginal(super.getEntity("",entity.getProcesoRecibosOriginal(),resultSet,ProcesoRecibosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoRecibosOriginal(ProcesoRecibosDataAccess.getEntityProcesoRecibos("",entity.getProcesoRecibosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoRecibos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoRecibos> entities = new  ArrayList<ProcesoRecibos>();
		ProcesoRecibos entity = new ProcesoRecibos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoRecibos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoRecibos>((List<ProcesoRecibos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoRecibossOriginal(entities);
			
			}  else {
				this.procesorecibossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoRecibosConstantesFunciones.quitarEspaciosProcesoReciboss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoRecibos getEntityProcesoRecibos(String strPrefijo,ProcesoRecibos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_provincia(resultSet.getString(strPrefijo+ProcesoRecibosConstantesFunciones.NOMBREPROVINCIA));
			entity.setnombre_ciudad(resultSet.getString(strPrefijo+ProcesoRecibosConstantesFunciones.NOMBRECIUDAD));
			entity.setnombre_zona(resultSet.getString(strPrefijo+ProcesoRecibosConstantesFunciones.NOMBREZONA));
			entity.setnombre_grupo_cliente(resultSet.getString(strPrefijo+ProcesoRecibosConstantesFunciones.NOMBREGRUPOCLIENTE));
			entity.setnombre_vendedor(resultSet.getString(strPrefijo+ProcesoRecibosConstantesFunciones.NOMBREVENDEDOR));
			entity.setcodigo(resultSet.getString(strPrefijo+ProcesoRecibosConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+ProcesoRecibosConstantesFunciones.NOMBRECOMPLETO));
			entity.setcodigo_asiento(resultSet.getString(strPrefijo+ProcesoRecibosConstantesFunciones.CODIGOASIENTO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+ProcesoRecibosConstantesFunciones.NUMEROMAYOR));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoRecibos getEntityProcesoRecibos(String strPrefijo,ProcesoRecibos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoRecibos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoRecibos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoRecibosLogic.setFieldReflectionProcesoRecibos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoRecibos(Field field,String strPrefijo,String sColumn,ProcesoRecibos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoRecibosConstantesFunciones.NOMBREPROVINCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoRecibosConstantesFunciones.NOMBRECIUDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoRecibosConstantesFunciones.NOMBREZONA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoRecibosConstantesFunciones.NOMBREGRUPOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoRecibosConstantesFunciones.NOMBREVENDEDOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoRecibosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoRecibosConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoRecibosConstantesFunciones.CODIGOASIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoRecibosConstantesFunciones.NUMEROMAYOR:
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
	
	public void quitarProcesoRecibossNulos() throws Exception {				
		
		List<ProcesoRecibos> procesorecibossAux= new ArrayList<ProcesoRecibos>();
		
		for(ProcesoRecibos procesorecibos:procesoreciboss) {
			if(procesorecibos!=null) {
				procesorecibossAux.add(procesorecibos);
			}
		}
		
		procesoreciboss=procesorecibossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoRecibos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoRecibos> entities = new  ArrayList<ProcesoRecibos>();
		ProcesoRecibos entity = new ProcesoRecibos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoRecibos>((List<ProcesoRecibos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoRecibossOriginal(entities);
			
			}  else {
				this.procesorecibossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoRecibosConstantesFunciones.quitarEspaciosProcesoReciboss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesoreciboss = new  ArrayList<ProcesoRecibos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoRecibosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoreciboss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesoreciboss = new  ArrayList<ProcesoRecibos>();
		  		  
        try {
			//ProcesoRecibosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoreciboss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoRecibos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoRecibos> entities = new  ArrayList<ProcesoRecibos>();
		ProcesoRecibos entity = new ProcesoRecibos();		  
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
	
	public  List<ProcesoRecibos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoRecibos> entities = new  ArrayList<ProcesoRecibos>();
		ProcesoRecibos entity = new ProcesoRecibos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoRecibos();
				
				if(conMapGenerico) {
					entity.setMapProcesoRecibos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoRecibos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoRecibosDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoRecibosLogic.getEntityProcesoRecibos("",entity,resultSet,listColumns);
					
					////entity.setProcesoRecibosOriginal( new ProcesoRecibos());
					////entity.setProcesoRecibosOriginal(super.getEntity("",entity.getProcesoRecibosOriginal(),resultSet,ProcesoRecibosDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoRecibosOriginal(ProcesoRecibosDataAccess.getEntityProcesoRecibos("",entity.getProcesoRecibosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Provincia getProvincia(Connexion connexion,ProcesoRecibos relprocesorecibos)throws SQLException,Exception {

		Provincia provincia= new Provincia();

		try {
			ProvinciaDataAccess provinciaDataAccess=new ProvinciaDataAccess();

			provinciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			provinciaDataAccess.setConnexionType(this.connexionType);
			provinciaDataAccess.setParameterDbType(this.parameterDbType);
			provinciaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			provincia=provinciaDataAccess.getEntity(connexion,relprocesorecibos.getid_provincia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provincia;

	}

	public Ciudad getCiudad(Connexion connexion,ProcesoRecibos relprocesorecibos)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);
			ciudadDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ciudad=ciudadDataAccess.getEntity(connexion,relprocesorecibos.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,ProcesoRecibos relprocesorecibos)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);
			zonaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			zona=zonaDataAccess.getEntity(connexion,relprocesorecibos.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public GrupoCliente getGrupoCliente(Connexion connexion,ProcesoRecibos relprocesorecibos)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			grupoclienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relprocesorecibos.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}

	public Vendedor getVendedor(Connexion connexion,ProcesoRecibos relprocesorecibos)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);
			vendedorDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			vendedor=vendedorDataAccess.getEntity(connexion,relprocesorecibos.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}


	
	
	public void getProcesoRecibossBusquedaProcesoRecibosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_provincia,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor)throws Exception {
		try {
			//ProcesoRecibosLogic procesorecibosLogic=new ProcesoRecibosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoRecibosLogic.GetSelecSqlProcesoRecibos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_provincia,id_ciudad,id_zona,id_grupo_cliente,id_vendedor);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesoreciboss=this.getProcesoReciboss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoRecibossBusquedaProcesoRecibos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_provincia,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor)throws Exception {
		try {
			//ProcesoRecibosLogic procesorecibosLogic=new ProcesoRecibosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoRecibosLogic.GetSelecSqlProcesoRecibos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_provincia,id_ciudad,id_zona,id_grupo_cliente,id_vendedor);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesoreciboss=this.getProcesoReciboss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoRecibos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_provincia,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoRecibos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" c.id_empresa="+parametroGeneralUsuario.getid_empresa();
					//existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" c.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_provincia!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_provincia = "+id_provincia.toString();
					existeWhere=true;
				}

				if(id_ciudad!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_ciudad = "+id_ciudad.toString();
					existeWhere=true;
				}

				if(id_zona!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_zona = "+id_zona.toString();
					existeWhere=true;
				}

				if(id_grupo_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_grupo_cliente = "+id_grupo_cliente.toString();
					existeWhere=true;
				}

				if(id_vendedor!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_vendedor = "+id_vendedor.toString();
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
	
	
	public void deepLoad(ProcesoRecibos procesorecibos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoRecibosLogicAdditional.updateProcesoRecibosToGet(procesorecibos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesorecibos.setProvincia(procesorecibosDataAccess.getProvincia(connexion,procesorecibos));
		procesorecibos.setCiudad(procesorecibosDataAccess.getCiudad(connexion,procesorecibos));
		procesorecibos.setZona(procesorecibosDataAccess.getZona(connexion,procesorecibos));
		procesorecibos.setGrupoCliente(procesorecibosDataAccess.getGrupoCliente(connexion,procesorecibos));
		procesorecibos.setVendedor(procesorecibosDataAccess.getVendedor(connexion,procesorecibos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				procesorecibos.setProvincia(procesorecibosDataAccess.getProvincia(connexion,procesorecibos));
			}

			if(clas.clas.equals(Ciudad.class)) {
				procesorecibos.setCiudad(procesorecibosDataAccess.getCiudad(connexion,procesorecibos));
			}

			if(clas.clas.equals(Zona.class)) {
				procesorecibos.setZona(procesorecibosDataAccess.getZona(connexion,procesorecibos));
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				procesorecibos.setGrupoCliente(procesorecibosDataAccess.getGrupoCliente(connexion,procesorecibos));
			}

			if(clas.clas.equals(Vendedor.class)) {
				procesorecibos.setVendedor(procesorecibosDataAccess.getVendedor(connexion,procesorecibos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setProvincia(procesorecibosDataAccess.getProvincia(connexion,procesorecibos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setCiudad(procesorecibosDataAccess.getCiudad(connexion,procesorecibos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setZona(procesorecibosDataAccess.getZona(connexion,procesorecibos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setGrupoCliente(procesorecibosDataAccess.getGrupoCliente(connexion,procesorecibos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setVendedor(procesorecibosDataAccess.getVendedor(connexion,procesorecibos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesorecibos.setProvincia(procesorecibosDataAccess.getProvincia(connexion,procesorecibos));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(procesorecibos.getProvincia(),isDeep,deepLoadType,clases);
				
		procesorecibos.setCiudad(procesorecibosDataAccess.getCiudad(connexion,procesorecibos));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(procesorecibos.getCiudad(),isDeep,deepLoadType,clases);
				
		procesorecibos.setZona(procesorecibosDataAccess.getZona(connexion,procesorecibos));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(procesorecibos.getZona(),isDeep,deepLoadType,clases);
				
		procesorecibos.setGrupoCliente(procesorecibosDataAccess.getGrupoCliente(connexion,procesorecibos));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(procesorecibos.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		procesorecibos.setVendedor(procesorecibosDataAccess.getVendedor(connexion,procesorecibos));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(procesorecibos.getVendedor(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				procesorecibos.setProvincia(procesorecibosDataAccess.getProvincia(connexion,procesorecibos));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(procesorecibos.getProvincia(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ciudad.class)) {
				procesorecibos.setCiudad(procesorecibosDataAccess.getCiudad(connexion,procesorecibos));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(procesorecibos.getCiudad(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Zona.class)) {
				procesorecibos.setZona(procesorecibosDataAccess.getZona(connexion,procesorecibos));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(procesorecibos.getZona(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				procesorecibos.setGrupoCliente(procesorecibosDataAccess.getGrupoCliente(connexion,procesorecibos));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(procesorecibos.getGrupoCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Vendedor.class)) {
				procesorecibos.setVendedor(procesorecibosDataAccess.getVendedor(connexion,procesorecibos));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(procesorecibos.getVendedor(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setProvincia(procesorecibosDataAccess.getProvincia(connexion,procesorecibos));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(procesorecibos.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setCiudad(procesorecibosDataAccess.getCiudad(connexion,procesorecibos));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(procesorecibos.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setZona(procesorecibosDataAccess.getZona(connexion,procesorecibos));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(procesorecibos.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setGrupoCliente(procesorecibosDataAccess.getGrupoCliente(connexion,procesorecibos));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(procesorecibos.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesorecibos.setVendedor(procesorecibosDataAccess.getVendedor(connexion,procesorecibos));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(procesorecibos.getVendedor(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesorecibos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoRecibosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoRecibos(procesorecibos);
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
			this.deepLoad(this.procesorecibos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoRecibosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoRecibos(this.procesorecibos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesoreciboss!=null) {
				for(ProcesoRecibos procesorecibos:procesoreciboss) {
					this.deepLoad(procesorecibos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoRecibosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoRecibos(procesoreciboss);
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
			if(procesoreciboss!=null) {
				for(ProcesoRecibos procesorecibos:procesoreciboss) {
					this.deepLoad(procesorecibos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoRecibosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoRecibos(procesoreciboss);
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
	
	public ProcesoRecibosParameterReturnGeneral procesarAccionProcesoReciboss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoRecibos> procesoreciboss,ProcesoRecibosParameterReturnGeneral procesorecibosParameterGeneral)throws Exception {
		 try {	
			ProcesoRecibosParameterReturnGeneral procesorecibosReturnGeneral=new ProcesoRecibosParameterReturnGeneral();
	
			ProcesoRecibosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoreciboss,procesorecibosParameterGeneral,procesorecibosReturnGeneral);
			
			return procesorecibosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoRecibosParameterReturnGeneral procesarAccionProcesoRecibossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoRecibos> procesoreciboss,ProcesoRecibosParameterReturnGeneral procesorecibosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoRecibosParameterReturnGeneral procesorecibosReturnGeneral=new ProcesoRecibosParameterReturnGeneral();
	
			ProcesoRecibosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoreciboss,procesorecibosParameterGeneral,procesorecibosReturnGeneral);
			
			this.connexion.commit();
			
			return procesorecibosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

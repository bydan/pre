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
import com.bydan.erp.cartera.util.report.CobrarClientesHonomasticosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesHonomasticosParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarClientesHonomasticosConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarClientesHonomasticos;

import com.bydan.erp.cartera.business.logic.report.CobrarClientesHonomasticosLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarClientesHonomasticosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarClientesHonomasticosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarClientesHonomasticosLogic cobrarclienteshonomasticosDataAccess; 		
	protected CobrarClientesHonomasticos cobrarclienteshonomasticos;
	protected List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss;
	protected Object cobrarclienteshonomasticosObject;	
	protected List<Object> cobrarclienteshonomasticossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarClientesHonomasticosLogic()throws SQLException,Exception {
		try	{
			this.cobrarclienteshonomasticoss= new ArrayList<CobrarClientesHonomasticos>();
			this.cobrarclienteshonomasticos= new CobrarClientesHonomasticos();
			this.cobrarclienteshonomasticosObject=new Object();
			this.cobrarclienteshonomasticossObject=new ArrayList<Object>();
			
			this.cobrarclienteshonomasticosDataAccess=this;
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
			this.cobrarclienteshonomasticosDataAccess.setConnexionType(this.connexionType);
			this.cobrarclienteshonomasticosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclienteshonomasticosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarClientesHonomasticosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarclienteshonomasticoss= new ArrayList<CobrarClientesHonomasticos>();
			this.cobrarclienteshonomasticos= new CobrarClientesHonomasticos();
			this.cobrarclienteshonomasticosObject=new Object();
			this.cobrarclienteshonomasticossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarclienteshonomasticosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarclienteshonomasticosDataAccess.setConnexionType(this.connexionType);
			this.cobrarclienteshonomasticosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarclienteshonomasticosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarClientesHonomasticos getCobrarClientesHonomasticos() throws Exception {	
		CobrarClientesHonomasticosLogicAdditional.checkCobrarClientesHonomasticosToGet(cobrarclienteshonomasticos,this.datosCliente,this.arrDatoGeneral);
		CobrarClientesHonomasticosLogicAdditional.updateCobrarClientesHonomasticosToGet(cobrarclienteshonomasticos,this.arrDatoGeneral);
		
		return cobrarclienteshonomasticos;
	}
		
	public void setCobrarClientesHonomasticos(CobrarClientesHonomasticos newCobrarClientesHonomasticos) {
		this.cobrarclienteshonomasticos = newCobrarClientesHonomasticos;
	}
	
	public List<CobrarClientesHonomasticos> getCobrarClientesHonomasticoss() throws Exception {		
		this.quitarCobrarClientesHonomasticossNulos();
		
		CobrarClientesHonomasticosLogicAdditional.checkCobrarClientesHonomasticosToGets(cobrarclienteshonomasticoss,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarClientesHonomasticos cobrarclienteshonomasticosLocal: cobrarclienteshonomasticoss ) {
			CobrarClientesHonomasticosLogicAdditional.updateCobrarClientesHonomasticosToGet(cobrarclienteshonomasticosLocal,this.arrDatoGeneral);
		}
		
		return cobrarclienteshonomasticoss;
	}
	
	public void setCobrarClientesHonomasticoss(List<CobrarClientesHonomasticos> newCobrarClientesHonomasticoss) {
		this.cobrarclienteshonomasticoss = newCobrarClientesHonomasticoss;
	}
	
	public Object getCobrarClientesHonomasticosObject() {	
		//this.cobrarclienteshonomasticosObject=this.cobrarclienteshonomasticosDataAccess.getEntityObject();
		return this.cobrarclienteshonomasticosObject;
	}
		
	public void setCobrarClientesHonomasticosObject(Object newCobrarClientesHonomasticosObject) {
		this.cobrarclienteshonomasticosObject = newCobrarClientesHonomasticosObject;
	}
	
	public List<Object> getCobrarClientesHonomasticossObject() {		
		//this.cobrarclienteshonomasticossObject=this.cobrarclienteshonomasticosDataAccess.getEntitiesObject();
		return this.cobrarclienteshonomasticossObject;
	}
		
	public void setCobrarClientesHonomasticossObject(List<Object> newCobrarClientesHonomasticossObject) {
		this.cobrarclienteshonomasticossObject = newCobrarClientesHonomasticossObject;
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
		cobrarclienteshonomasticoss = new  ArrayList<CobrarClientesHonomasticos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesHonomasticosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclienteshonomasticoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarclienteshonomasticoss = new  ArrayList<CobrarClientesHonomasticos>();
		  		  
        try {
			//CobrarClientesHonomasticosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclienteshonomasticoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarclienteshonomasticoss = new  ArrayList<CobrarClientesHonomasticos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesHonomasticosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclienteshonomasticoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclienteshonomasticoss = new  ArrayList<CobrarClientesHonomasticos>();
		  		  
        try {
			//CobrarClientesHonomasticosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclienteshonomasticoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarclienteshonomasticoss = new  ArrayList<CobrarClientesHonomasticos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesHonomasticosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclienteshonomasticoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarclienteshonomasticoss = new  ArrayList<CobrarClientesHonomasticos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarClientesHonomasticosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclienteshonomasticoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarClientesHonomasticos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesHonomasticos> entities = new  ArrayList<CobrarClientesHonomasticos>();
		CobrarClientesHonomasticos entity = new CobrarClientesHonomasticos();		  
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
	
	public  List<CobrarClientesHonomasticos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesHonomasticos> entities = new  ArrayList<CobrarClientesHonomasticos>();
		CobrarClientesHonomasticos entity = new CobrarClientesHonomasticos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesHonomasticos();
				
				
      	    	entity=CobrarClientesHonomasticosLogic.getEntityCobrarClientesHonomasticos("",entity,resultSet);
      	    	
				//entity.setCobrarClientesHonomasticosOriginal( new CobrarClientesHonomasticos());
      	    	//entity.setCobrarClientesHonomasticosOriginal(super.getEntity("",entity.getCobrarClientesHonomasticosOriginal(),resultSet,CobrarClientesHonomasticosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarClientesHonomasticosOriginal(CobrarClientesHonomasticosDataAccess.getEntityCobrarClientesHonomasticos("",entity.getCobrarClientesHonomasticosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarClientesHonomasticos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesHonomasticos> entities = new  ArrayList<CobrarClientesHonomasticos>();
		CobrarClientesHonomasticos entity = new CobrarClientesHonomasticos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarClientesHonomasticos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesHonomasticos>((List<CobrarClientesHonomasticos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesHonomasticossOriginal(entities);
			
			}  else {
				this.cobrarclienteshonomasticossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesHonomasticosConstantesFunciones.quitarEspaciosCobrarClientesHonomasticoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarClientesHonomasticos getEntityCobrarClientesHonomasticos(String strPrefijo,CobrarClientesHonomasticos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_ciudad(resultSet.getString(strPrefijo+CobrarClientesHonomasticosConstantesFunciones.NOMBRECIUDAD));
			entity.setnombre_ruta(resultSet.getString(strPrefijo+CobrarClientesHonomasticosConstantesFunciones.NOMBRERUTA));
			entity.setnombre_vendedor(resultSet.getString(strPrefijo+CobrarClientesHonomasticosConstantesFunciones.NOMBREVENDEDOR));
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarClientesHonomasticosConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMPLETO));
			entity.setnombre_comercial(resultSet.getString(strPrefijo+CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMERCIAL));
			entity.setfecha_nacimiento_dato(new Date(resultSet.getDate(strPrefijo+CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTODATO).getTime()));
			entity.setdireccion_direccion(resultSet.getString(strPrefijo+CobrarClientesHonomasticosConstantesFunciones.DIRECCIONDIRECCION));
			entity.settelefono_telefono(resultSet.getString(strPrefijo+CobrarClientesHonomasticosConstantesFunciones.TELEFONOTELEFONO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarClientesHonomasticos getEntityCobrarClientesHonomasticos(String strPrefijo,CobrarClientesHonomasticos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarClientesHonomasticos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarClientesHonomasticos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarClientesHonomasticosLogic.setFieldReflectionCobrarClientesHonomasticos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarClientesHonomasticos(Field field,String strPrefijo,String sColumn,CobrarClientesHonomasticos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarClientesHonomasticosConstantesFunciones.NOMBRECIUDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesHonomasticosConstantesFunciones.NOMBRERUTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesHonomasticosConstantesFunciones.NOMBREVENDEDOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesHonomasticosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMERCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTODATO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarClientesHonomasticosConstantesFunciones.DIRECCIONDIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarClientesHonomasticosConstantesFunciones.TELEFONOTELEFONO:
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
	
	public void quitarCobrarClientesHonomasticossNulos() throws Exception {				
		
		List<CobrarClientesHonomasticos> cobrarclienteshonomasticossAux= new ArrayList<CobrarClientesHonomasticos>();
		
		for(CobrarClientesHonomasticos cobrarclienteshonomasticos:cobrarclienteshonomasticoss) {
			if(cobrarclienteshonomasticos!=null) {
				cobrarclienteshonomasticossAux.add(cobrarclienteshonomasticos);
			}
		}
		
		cobrarclienteshonomasticoss=cobrarclienteshonomasticossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarClientesHonomasticos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarClientesHonomasticos> entities = new  ArrayList<CobrarClientesHonomasticos>();
		CobrarClientesHonomasticos entity = new CobrarClientesHonomasticos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarClientesHonomasticos>((List<CobrarClientesHonomasticos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarClientesHonomasticossOriginal(entities);
			
			}  else {
				this.cobrarclienteshonomasticossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarClientesHonomasticosConstantesFunciones.quitarEspaciosCobrarClientesHonomasticoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarclienteshonomasticoss = new  ArrayList<CobrarClientesHonomasticos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarClientesHonomasticosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclienteshonomasticoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarclienteshonomasticoss = new  ArrayList<CobrarClientesHonomasticos>();
		  		  
        try {
			//CobrarClientesHonomasticosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarclienteshonomasticoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarClientesHonomasticos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesHonomasticos> entities = new  ArrayList<CobrarClientesHonomasticos>();
		CobrarClientesHonomasticos entity = new CobrarClientesHonomasticos();		  
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
	
	public  List<CobrarClientesHonomasticos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarClientesHonomasticos> entities = new  ArrayList<CobrarClientesHonomasticos>();
		CobrarClientesHonomasticos entity = new CobrarClientesHonomasticos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarClientesHonomasticos();
				
				if(conMapGenerico) {
					entity.setMapCobrarClientesHonomasticos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarClientesHonomasticos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarClientesHonomasticosDataAccess.ISWITHSCHEMA);         		
					entity=CobrarClientesHonomasticosLogic.getEntityCobrarClientesHonomasticos("",entity,resultSet,listColumns);
					
					////entity.setCobrarClientesHonomasticosOriginal( new CobrarClientesHonomasticos());
					////entity.setCobrarClientesHonomasticosOriginal(super.getEntity("",entity.getCobrarClientesHonomasticosOriginal(),resultSet,CobrarClientesHonomasticosDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarClientesHonomasticosOriginal(CobrarClientesHonomasticosDataAccess.getEntityCobrarClientesHonomasticos("",entity.getCobrarClientesHonomasticosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarClientesHonomasticos relcobrarclienteshonomasticos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarclienteshonomasticos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CobrarClientesHonomasticos relcobrarclienteshonomasticos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relcobrarclienteshonomasticos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Pais getPais(Connexion connexion,CobrarClientesHonomasticos relcobrarclienteshonomasticos)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);
			paisDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			pais=paisDataAccess.getEntity(connexion,relcobrarclienteshonomasticos.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Region getRegion(Connexion connexion,CobrarClientesHonomasticos relcobrarclienteshonomasticos)throws SQLException,Exception {

		Region region= new Region();

		try {
			RegionDataAccess regionDataAccess=new RegionDataAccess();

			regionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			regionDataAccess.setConnexionType(this.connexionType);
			regionDataAccess.setParameterDbType(this.parameterDbType);
			regionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			region=regionDataAccess.getEntity(connexion,relcobrarclienteshonomasticos.getid_region());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return region;

	}

	public Provincia getProvincia(Connexion connexion,CobrarClientesHonomasticos relcobrarclienteshonomasticos)throws SQLException,Exception {

		Provincia provincia= new Provincia();

		try {
			ProvinciaDataAccess provinciaDataAccess=new ProvinciaDataAccess();

			provinciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			provinciaDataAccess.setConnexionType(this.connexionType);
			provinciaDataAccess.setParameterDbType(this.parameterDbType);
			provinciaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			provincia=provinciaDataAccess.getEntity(connexion,relcobrarclienteshonomasticos.getid_provincia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provincia;

	}

	public Ciudad getCiudad(Connexion connexion,CobrarClientesHonomasticos relcobrarclienteshonomasticos)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);
			ciudadDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ciudad=ciudadDataAccess.getEntity(connexion,relcobrarclienteshonomasticos.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


	
	
	public void getCobrarClientesHonomasticossBusquedaCobrarClientesHonomasticosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad,Date fecha_nacimiento)throws Exception {
		try {
			//CobrarClientesHonomasticosLogic cobrarclienteshonomasticosLogic=new CobrarClientesHonomasticosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesHonomasticosLogic.GetSelecSqlCobrarClientesHonomasticos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_pais,id_region,id_provincia,id_ciudad,fecha_nacimiento);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclienteshonomasticoss=this.getCobrarClientesHonomasticoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarClientesHonomasticossBusquedaCobrarClientesHonomasticos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad,Date fecha_nacimiento)throws Exception {
		try {
			//CobrarClientesHonomasticosLogic cobrarclienteshonomasticosLogic=new CobrarClientesHonomasticosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarClientesHonomasticosLogic.GetSelecSqlCobrarClientesHonomasticos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_pais,id_region,id_provincia,id_ciudad,fecha_nacimiento);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarclienteshonomasticoss=this.getCobrarClientesHonomasticoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarClientesHonomasticos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad,Date fecha_nacimiento)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarClientesHonomasticos_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" c.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_pais!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_pais = "+id_pais.toString();
					existeWhere=true;
				}

				if(id_region!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_region = "+id_region.toString();
					existeWhere=true;
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

				if(fecha_nacimiento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.fecha_nacimiento = "+"'"+Funciones2.getStringPostgresDate(fecha_nacimiento)+"'";
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
	
	
	public void deepLoad(CobrarClientesHonomasticos cobrarclienteshonomasticos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarClientesHonomasticosLogicAdditional.updateCobrarClientesHonomasticosToGet(cobrarclienteshonomasticos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarclienteshonomasticos.setEmpresa(cobrarclienteshonomasticosDataAccess.getEmpresa(connexion,cobrarclienteshonomasticos));
		cobrarclienteshonomasticos.setSucursal(cobrarclienteshonomasticosDataAccess.getSucursal(connexion,cobrarclienteshonomasticos));
		cobrarclienteshonomasticos.setPais(cobrarclienteshonomasticosDataAccess.getPais(connexion,cobrarclienteshonomasticos));
		cobrarclienteshonomasticos.setRegion(cobrarclienteshonomasticosDataAccess.getRegion(connexion,cobrarclienteshonomasticos));
		cobrarclienteshonomasticos.setProvincia(cobrarclienteshonomasticosDataAccess.getProvincia(connexion,cobrarclienteshonomasticos));
		cobrarclienteshonomasticos.setCiudad(cobrarclienteshonomasticosDataAccess.getCiudad(connexion,cobrarclienteshonomasticos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarclienteshonomasticos.setEmpresa(cobrarclienteshonomasticosDataAccess.getEmpresa(connexion,cobrarclienteshonomasticos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				cobrarclienteshonomasticos.setSucursal(cobrarclienteshonomasticosDataAccess.getSucursal(connexion,cobrarclienteshonomasticos));
			}

			if(clas.clas.equals(Pais.class)) {
				cobrarclienteshonomasticos.setPais(cobrarclienteshonomasticosDataAccess.getPais(connexion,cobrarclienteshonomasticos));
			}

			if(clas.clas.equals(Region.class)) {
				cobrarclienteshonomasticos.setRegion(cobrarclienteshonomasticosDataAccess.getRegion(connexion,cobrarclienteshonomasticos));
			}

			if(clas.clas.equals(Provincia.class)) {
				cobrarclienteshonomasticos.setProvincia(cobrarclienteshonomasticosDataAccess.getProvincia(connexion,cobrarclienteshonomasticos));
			}

			if(clas.clas.equals(Ciudad.class)) {
				cobrarclienteshonomasticos.setCiudad(cobrarclienteshonomasticosDataAccess.getCiudad(connexion,cobrarclienteshonomasticos));
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
			cobrarclienteshonomasticos.setEmpresa(cobrarclienteshonomasticosDataAccess.getEmpresa(connexion,cobrarclienteshonomasticos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setSucursal(cobrarclienteshonomasticosDataAccess.getSucursal(connexion,cobrarclienteshonomasticos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setPais(cobrarclienteshonomasticosDataAccess.getPais(connexion,cobrarclienteshonomasticos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setRegion(cobrarclienteshonomasticosDataAccess.getRegion(connexion,cobrarclienteshonomasticos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setProvincia(cobrarclienteshonomasticosDataAccess.getProvincia(connexion,cobrarclienteshonomasticos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setCiudad(cobrarclienteshonomasticosDataAccess.getCiudad(connexion,cobrarclienteshonomasticos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarclienteshonomasticos.setEmpresa(cobrarclienteshonomasticosDataAccess.getEmpresa(connexion,cobrarclienteshonomasticos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarclienteshonomasticos.getEmpresa(),isDeep,deepLoadType,clases);
				
		cobrarclienteshonomasticos.setSucursal(cobrarclienteshonomasticosDataAccess.getSucursal(connexion,cobrarclienteshonomasticos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cobrarclienteshonomasticos.getSucursal(),isDeep,deepLoadType,clases);
				
		cobrarclienteshonomasticos.setPais(cobrarclienteshonomasticosDataAccess.getPais(connexion,cobrarclienteshonomasticos));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(cobrarclienteshonomasticos.getPais(),isDeep,deepLoadType,clases);
				
		cobrarclienteshonomasticos.setRegion(cobrarclienteshonomasticosDataAccess.getRegion(connexion,cobrarclienteshonomasticos));
		RegionLogic regionLogic= new RegionLogic(connexion);
		regionLogic.deepLoad(cobrarclienteshonomasticos.getRegion(),isDeep,deepLoadType,clases);
				
		cobrarclienteshonomasticos.setProvincia(cobrarclienteshonomasticosDataAccess.getProvincia(connexion,cobrarclienteshonomasticos));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(cobrarclienteshonomasticos.getProvincia(),isDeep,deepLoadType,clases);
				
		cobrarclienteshonomasticos.setCiudad(cobrarclienteshonomasticosDataAccess.getCiudad(connexion,cobrarclienteshonomasticos));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(cobrarclienteshonomasticos.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarclienteshonomasticos.setEmpresa(cobrarclienteshonomasticosDataAccess.getEmpresa(connexion,cobrarclienteshonomasticos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarclienteshonomasticos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				cobrarclienteshonomasticos.setSucursal(cobrarclienteshonomasticosDataAccess.getSucursal(connexion,cobrarclienteshonomasticos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cobrarclienteshonomasticos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Pais.class)) {
				cobrarclienteshonomasticos.setPais(cobrarclienteshonomasticosDataAccess.getPais(connexion,cobrarclienteshonomasticos));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(cobrarclienteshonomasticos.getPais(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Region.class)) {
				cobrarclienteshonomasticos.setRegion(cobrarclienteshonomasticosDataAccess.getRegion(connexion,cobrarclienteshonomasticos));
				RegionLogic regionLogic= new RegionLogic(connexion);
				regionLogic.deepLoad(cobrarclienteshonomasticos.getRegion(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Provincia.class)) {
				cobrarclienteshonomasticos.setProvincia(cobrarclienteshonomasticosDataAccess.getProvincia(connexion,cobrarclienteshonomasticos));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(cobrarclienteshonomasticos.getProvincia(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ciudad.class)) {
				cobrarclienteshonomasticos.setCiudad(cobrarclienteshonomasticosDataAccess.getCiudad(connexion,cobrarclienteshonomasticos));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(cobrarclienteshonomasticos.getCiudad(),isDeep,deepLoadType,clases);				
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
			cobrarclienteshonomasticos.setEmpresa(cobrarclienteshonomasticosDataAccess.getEmpresa(connexion,cobrarclienteshonomasticos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarclienteshonomasticos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setSucursal(cobrarclienteshonomasticosDataAccess.getSucursal(connexion,cobrarclienteshonomasticos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cobrarclienteshonomasticos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setPais(cobrarclienteshonomasticosDataAccess.getPais(connexion,cobrarclienteshonomasticos));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(cobrarclienteshonomasticos.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setRegion(cobrarclienteshonomasticosDataAccess.getRegion(connexion,cobrarclienteshonomasticos));
			RegionLogic regionLogic= new RegionLogic(connexion);
			regionLogic.deepLoad(cobrarclienteshonomasticos.getRegion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setProvincia(cobrarclienteshonomasticosDataAccess.getProvincia(connexion,cobrarclienteshonomasticos));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(cobrarclienteshonomasticos.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarclienteshonomasticos.setCiudad(cobrarclienteshonomasticosDataAccess.getCiudad(connexion,cobrarclienteshonomasticos));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(cobrarclienteshonomasticos.getCiudad(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarclienteshonomasticos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesHonomasticosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesHonomasticos(cobrarclienteshonomasticos);
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
			this.deepLoad(this.cobrarclienteshonomasticos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarClientesHonomasticosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesHonomasticos(this.cobrarclienteshonomasticos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarclienteshonomasticoss!=null) {
				for(CobrarClientesHonomasticos cobrarclienteshonomasticos:cobrarclienteshonomasticoss) {
					this.deepLoad(cobrarclienteshonomasticos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesHonomasticosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesHonomasticos(cobrarclienteshonomasticoss);
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
			if(cobrarclienteshonomasticoss!=null) {
				for(CobrarClientesHonomasticos cobrarclienteshonomasticos:cobrarclienteshonomasticoss) {
					this.deepLoad(cobrarclienteshonomasticos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarClientesHonomasticosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarClientesHonomasticos(cobrarclienteshonomasticoss);
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
	
	public CobrarClientesHonomasticosParameterReturnGeneral procesarAccionCobrarClientesHonomasticoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss,CobrarClientesHonomasticosParameterReturnGeneral cobrarclienteshonomasticosParameterGeneral)throws Exception {
		 try {	
			CobrarClientesHonomasticosParameterReturnGeneral cobrarclienteshonomasticosReturnGeneral=new CobrarClientesHonomasticosParameterReturnGeneral();
	
			CobrarClientesHonomasticosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclienteshonomasticoss,cobrarclienteshonomasticosParameterGeneral,cobrarclienteshonomasticosReturnGeneral);
			
			return cobrarclienteshonomasticosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarClientesHonomasticosParameterReturnGeneral procesarAccionCobrarClientesHonomasticossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss,CobrarClientesHonomasticosParameterReturnGeneral cobrarclienteshonomasticosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarClientesHonomasticosParameterReturnGeneral cobrarclienteshonomasticosReturnGeneral=new CobrarClientesHonomasticosParameterReturnGeneral();
	
			CobrarClientesHonomasticosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarclienteshonomasticoss,cobrarclienteshonomasticosParameterGeneral,cobrarclienteshonomasticosReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarclienteshonomasticosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

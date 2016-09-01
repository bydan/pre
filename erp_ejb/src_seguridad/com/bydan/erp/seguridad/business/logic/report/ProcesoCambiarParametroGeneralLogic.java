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
package com.bydan.erp.seguridad.business.logic.report;

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

import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.resources.general.AuxiliarGeneral;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarParametroGeneralParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.report.ProcesoCambiarParametroGeneralParameterGeneral;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarParametroGeneralConstantesFunciones;
import com.bydan.erp.seguridad.business.entity.report.ProcesoCambiarParametroGeneral;

import com.bydan.erp.seguridad.business.logic.report.ProcesoCambiarParametroGeneralLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoCambiarParametroGeneralLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCambiarParametroGeneralLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCambiarParametroGeneralLogic procesocambiarparametrogeneralDataAccess; 		
	protected ProcesoCambiarParametroGeneral procesocambiarparametrogeneral;
	protected List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals;
	protected Object procesocambiarparametrogeneralObject;	
	protected List<Object> procesocambiarparametrogeneralsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCambiarParametroGeneralLogic()throws SQLException,Exception {
		try	{
			this.procesocambiarparametrogenerals= new ArrayList<ProcesoCambiarParametroGeneral>();
			this.procesocambiarparametrogeneral= new ProcesoCambiarParametroGeneral();
			this.procesocambiarparametrogeneralObject=new Object();
			this.procesocambiarparametrogeneralsObject=new ArrayList<Object>();
			
			this.procesocambiarparametrogeneralDataAccess=this;
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
			this.procesocambiarparametrogeneralDataAccess.setConnexionType(this.connexionType);
			this.procesocambiarparametrogeneralDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocambiarparametrogeneralDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCambiarParametroGeneralLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocambiarparametrogenerals= new ArrayList<ProcesoCambiarParametroGeneral>();
			this.procesocambiarparametrogeneral= new ProcesoCambiarParametroGeneral();
			this.procesocambiarparametrogeneralObject=new Object();
			this.procesocambiarparametrogeneralsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocambiarparametrogeneralDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocambiarparametrogeneralDataAccess.setConnexionType(this.connexionType);
			this.procesocambiarparametrogeneralDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocambiarparametrogeneralDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCambiarParametroGeneral getProcesoCambiarParametroGeneral() throws Exception {	
		ProcesoCambiarParametroGeneralLogicAdditional.checkProcesoCambiarParametroGeneralToGet(procesocambiarparametrogeneral,this.datosCliente,this.arrDatoGeneral);
		ProcesoCambiarParametroGeneralLogicAdditional.updateProcesoCambiarParametroGeneralToGet(procesocambiarparametrogeneral,this.arrDatoGeneral);
		
		return procesocambiarparametrogeneral;
	}
		
	public void setProcesoCambiarParametroGeneral(ProcesoCambiarParametroGeneral newProcesoCambiarParametroGeneral) {
		this.procesocambiarparametrogeneral = newProcesoCambiarParametroGeneral;
	}
	
	public List<ProcesoCambiarParametroGeneral> getProcesoCambiarParametroGenerals() throws Exception {		
		this.quitarProcesoCambiarParametroGeneralsNulos();
		
		ProcesoCambiarParametroGeneralLogicAdditional.checkProcesoCambiarParametroGeneralToGets(procesocambiarparametrogenerals,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCambiarParametroGeneral procesocambiarparametrogeneralLocal: procesocambiarparametrogenerals ) {
			ProcesoCambiarParametroGeneralLogicAdditional.updateProcesoCambiarParametroGeneralToGet(procesocambiarparametrogeneralLocal,this.arrDatoGeneral);
		}
		
		return procesocambiarparametrogenerals;
	}
	
	public void setProcesoCambiarParametroGenerals(List<ProcesoCambiarParametroGeneral> newProcesoCambiarParametroGenerals) {
		this.procesocambiarparametrogenerals = newProcesoCambiarParametroGenerals;
	}
	
	public Object getProcesoCambiarParametroGeneralObject() {	
		//this.procesocambiarparametrogeneralObject=this.procesocambiarparametrogeneralDataAccess.getEntityObject();
		return this.procesocambiarparametrogeneralObject;
	}
		
	public void setProcesoCambiarParametroGeneralObject(Object newProcesoCambiarParametroGeneralObject) {
		this.procesocambiarparametrogeneralObject = newProcesoCambiarParametroGeneralObject;
	}
	
	public List<Object> getProcesoCambiarParametroGeneralsObject() {		
		//this.procesocambiarparametrogeneralsObject=this.procesocambiarparametrogeneralDataAccess.getEntitiesObject();
		return this.procesocambiarparametrogeneralsObject;
	}
		
	public void setProcesoCambiarParametroGeneralsObject(List<Object> newProcesoCambiarParametroGeneralsObject) {
		this.procesocambiarparametrogeneralsObject = newProcesoCambiarParametroGeneralsObject;
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
		procesocambiarparametrogenerals = new  ArrayList<ProcesoCambiarParametroGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarparametrogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocambiarparametrogenerals = new  ArrayList<ProcesoCambiarParametroGeneral>();
		  		  
        try {
			//ProcesoCambiarParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarparametrogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocambiarparametrogenerals = new  ArrayList<ProcesoCambiarParametroGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarparametrogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocambiarparametrogenerals = new  ArrayList<ProcesoCambiarParametroGeneral>();
		  		  
        try {
			//ProcesoCambiarParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarparametrogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocambiarparametrogenerals = new  ArrayList<ProcesoCambiarParametroGeneral>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarparametrogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocambiarparametrogenerals = new  ArrayList<ProcesoCambiarParametroGeneral>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCambiarParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarparametrogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCambiarParametroGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarParametroGeneral> entities = new  ArrayList<ProcesoCambiarParametroGeneral>();
		ProcesoCambiarParametroGeneral entity = new ProcesoCambiarParametroGeneral();		  
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
	
	public  List<ProcesoCambiarParametroGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarParametroGeneral> entities = new  ArrayList<ProcesoCambiarParametroGeneral>();
		ProcesoCambiarParametroGeneral entity = new ProcesoCambiarParametroGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCambiarParametroGeneral();
				
				
      	    	entity=ProcesoCambiarParametroGeneralLogic.getEntityProcesoCambiarParametroGeneral("",entity,resultSet);
      	    	
				//entity.setProcesoCambiarParametroGeneralOriginal( new ProcesoCambiarParametroGeneral());
      	    	//entity.setProcesoCambiarParametroGeneralOriginal(super.getEntity("",entity.getProcesoCambiarParametroGeneralOriginal(),resultSet,ProcesoCambiarParametroGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCambiarParametroGeneralOriginal(ProcesoCambiarParametroGeneralDataAccess.getEntityProcesoCambiarParametroGeneral("",entity.getProcesoCambiarParametroGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCambiarParametroGeneral> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarParametroGeneral> entities = new  ArrayList<ProcesoCambiarParametroGeneral>();
		ProcesoCambiarParametroGeneral entity = new ProcesoCambiarParametroGeneral();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCambiarParametroGeneral.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCambiarParametroGeneral>((List<ProcesoCambiarParametroGeneral>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCambiarParametroGeneralsOriginal(entities);
			
			}  else {
				this.procesocambiarparametrogeneralsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCambiarParametroGeneralConstantesFunciones.quitarEspaciosProcesoCambiarParametroGenerals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCambiarParametroGeneral getEntityProcesoCambiarParametroGeneral(String strPrefijo,ProcesoCambiarParametroGeneral entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_tipo_visual(resultSet.getLong(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOVISUAL));
			entity.setid_tipo_fondo(resultSet.getLong(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDO));
			entity.setid_tipo_fondo_borde(resultSet.getLong(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOBORDE));
			entity.setid_tipo_fondo_control(resultSet.getLong(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOCONTROL));
			entity.setid_tipo_tamanio_control(resultSet.getLong(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOTAMANIOCONTROL));
			entity.setcon_mensaje_confirmacion(resultSet.getBoolean(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.CONMENSAJECONFIRMACION));
			entity.setcon_botones_tool_bar(resultSet.getBoolean(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.CONBOTONESTOOLBAR));
			entity.setid_tipo_exportar(resultSet.getLong(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOEXPORTAR));
			entity.setid_tipo_delimiter(resultSet.getLong(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPODELIMITER));
			entity.setcon_exportar_cabecera(resultSet.getBoolean(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.CONEXPORTARCABECERA));
			entity.setpath_exportar(resultSet.getString(strPrefijo+ProcesoCambiarParametroGeneralConstantesFunciones.PATHEXPORTAR));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCambiarParametroGeneral getEntityProcesoCambiarParametroGeneral(String strPrefijo,ProcesoCambiarParametroGeneral entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCambiarParametroGeneral.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCambiarParametroGeneral.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCambiarParametroGeneralLogic.setFieldReflectionProcesoCambiarParametroGeneral(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCambiarParametroGeneral(Field field,String strPrefijo,String sColumn,ProcesoCambiarParametroGeneral entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOVISUAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOBORDE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOFONDOCONTROL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOTAMANIOCONTROL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.CONMENSAJECONFIRMACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.CONBOTONESTOOLBAR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPOEXPORTAR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.IDTIPODELIMITER:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.CONEXPORTARCABECERA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProcesoCambiarParametroGeneralConstantesFunciones.PATHEXPORTAR:
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
	
	public void quitarProcesoCambiarParametroGeneralsNulos() throws Exception {				
		
		List<ProcesoCambiarParametroGeneral> procesocambiarparametrogeneralsAux= new ArrayList<ProcesoCambiarParametroGeneral>();
		
		for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral:procesocambiarparametrogenerals) {
			if(procesocambiarparametrogeneral!=null) {
				procesocambiarparametrogeneralsAux.add(procesocambiarparametrogeneral);
			}
		}
		
		procesocambiarparametrogenerals=procesocambiarparametrogeneralsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCambiarParametroGeneral> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCambiarParametroGeneral> entities = new  ArrayList<ProcesoCambiarParametroGeneral>();
		ProcesoCambiarParametroGeneral entity = new ProcesoCambiarParametroGeneral();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCambiarParametroGeneral>((List<ProcesoCambiarParametroGeneral>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCambiarParametroGeneralsOriginal(entities);
			
			}  else {
				this.procesocambiarparametrogeneralsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCambiarParametroGeneralConstantesFunciones.quitarEspaciosProcesoCambiarParametroGenerals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocambiarparametrogenerals = new  ArrayList<ProcesoCambiarParametroGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCambiarParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarparametrogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesocambiarparametrogenerals = new  ArrayList<ProcesoCambiarParametroGeneral>();
		  		  
        try {
			//ProcesoCambiarParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocambiarparametrogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCambiarParametroGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCambiarParametroGeneral> entities = new  ArrayList<ProcesoCambiarParametroGeneral>();
		ProcesoCambiarParametroGeneral entity = new ProcesoCambiarParametroGeneral();		  
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
	
	public  List<ProcesoCambiarParametroGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCambiarParametroGeneral> entities = new  ArrayList<ProcesoCambiarParametroGeneral>();
		ProcesoCambiarParametroGeneral entity = new ProcesoCambiarParametroGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCambiarParametroGeneral();
				
				if(conMapGenerico) {
					entity.setMapProcesoCambiarParametroGeneral( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCambiarParametroGeneral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCambiarParametroGeneralDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCambiarParametroGeneralLogic.getEntityProcesoCambiarParametroGeneral("",entity,resultSet,listColumns);
					
					////entity.setProcesoCambiarParametroGeneralOriginal( new ProcesoCambiarParametroGeneral());
					////entity.setProcesoCambiarParametroGeneralOriginal(super.getEntity("",entity.getProcesoCambiarParametroGeneralOriginal(),resultSet,ProcesoCambiarParametroGeneralDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCambiarParametroGeneralOriginal(ProcesoCambiarParametroGeneralDataAccess.getEntityProcesoCambiarParametroGeneral("",entity.getProcesoCambiarParametroGeneralOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public TipoVisual getTipoVisual(Connexion connexion,ProcesoCambiarParametroGeneral relprocesocambiarparametrogeneral)throws SQLException,Exception {

		TipoVisual tipovisual= new TipoVisual();

		try {
			TipoVisualDataAccess tipovisualDataAccess=new TipoVisualDataAccess();

			tipovisualDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipovisualDataAccess.setConnexionType(this.connexionType);
			tipovisualDataAccess.setParameterDbType(this.parameterDbType);
			tipovisualDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipovisual=tipovisualDataAccess.getEntity(connexion,relprocesocambiarparametrogeneral.getid_tipo_visual());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovisual;

	}

	public TipoFondo getTipoFondo(Connexion connexion,ProcesoCambiarParametroGeneral relprocesocambiarparametrogeneral)throws SQLException,Exception {

		TipoFondo tipofondo= new TipoFondo();

		try {
			TipoFondoDataAccess tipofondoDataAccess=new TipoFondoDataAccess();

			tipofondoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofondoDataAccess.setConnexionType(this.connexionType);
			tipofondoDataAccess.setParameterDbType(this.parameterDbType);
			tipofondoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipofondo=tipofondoDataAccess.getEntity(connexion,relprocesocambiarparametrogeneral.getid_tipo_fondo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofondo;

	}

	public TipoFondo getTipoFondoBorde(Connexion connexion,ProcesoCambiarParametroGeneral relprocesocambiarparametrogeneral)throws SQLException,Exception {

		TipoFondo tipofondo= new TipoFondo();

		try {
			TipoFondoDataAccess tipofondoDataAccess=new TipoFondoDataAccess();

			tipofondoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofondoDataAccess.setConnexionType(this.connexionType);
			tipofondoDataAccess.setParameterDbType(this.parameterDbType);
			tipofondoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipofondo=tipofondoDataAccess.getEntity(connexion,relprocesocambiarparametrogeneral.getid_tipo_fondo_borde());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofondo;

	}

	public TipoFondoControl getTipoFondoControl(Connexion connexion,ProcesoCambiarParametroGeneral relprocesocambiarparametrogeneral)throws SQLException,Exception {

		TipoFondoControl tipofondocontrol= new TipoFondoControl();

		try {
			TipoFondoControlDataAccess tipofondocontrolDataAccess=new TipoFondoControlDataAccess();

			tipofondocontrolDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofondocontrolDataAccess.setConnexionType(this.connexionType);
			tipofondocontrolDataAccess.setParameterDbType(this.parameterDbType);
			tipofondocontrolDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipofondocontrol=tipofondocontrolDataAccess.getEntity(connexion,relprocesocambiarparametrogeneral.getid_tipo_fondo_control());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofondocontrol;

	}

	public TipoTamanioControl getTipoTamanioControl(Connexion connexion,ProcesoCambiarParametroGeneral relprocesocambiarparametrogeneral)throws SQLException,Exception {

		TipoTamanioControl tipotamaniocontrol= new TipoTamanioControl();

		try {
			TipoTamanioControlDataAccess tipotamaniocontrolDataAccess=new TipoTamanioControlDataAccess();

			tipotamaniocontrolDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotamaniocontrolDataAccess.setConnexionType(this.connexionType);
			tipotamaniocontrolDataAccess.setParameterDbType(this.parameterDbType);
			tipotamaniocontrolDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipotamaniocontrol=tipotamaniocontrolDataAccess.getEntity(connexion,relprocesocambiarparametrogeneral.getid_tipo_tamanio_control());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotamaniocontrol;

	}

	public TipoExportar getTipoExportar(Connexion connexion,ProcesoCambiarParametroGeneral relprocesocambiarparametrogeneral)throws SQLException,Exception {

		TipoExportar tipoexportar= new TipoExportar();

		try {
			TipoExportarDataAccess tipoexportarDataAccess=new TipoExportarDataAccess();

			tipoexportarDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoexportarDataAccess.setConnexionType(this.connexionType);
			tipoexportarDataAccess.setParameterDbType(this.parameterDbType);
			tipoexportarDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoexportar=tipoexportarDataAccess.getEntity(connexion,relprocesocambiarparametrogeneral.getid_tipo_exportar());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoexportar;

	}

	public TipoDelimiter getTipoDelimiter(Connexion connexion,ProcesoCambiarParametroGeneral relprocesocambiarparametrogeneral)throws SQLException,Exception {

		TipoDelimiter tipodelimiter= new TipoDelimiter();

		try {
			TipoDelimiterDataAccess tipodelimiterDataAccess=new TipoDelimiterDataAccess();

			tipodelimiterDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodelimiterDataAccess.setConnexionType(this.connexionType);
			tipodelimiterDataAccess.setParameterDbType(this.parameterDbType);
			tipodelimiterDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipodelimiter=tipodelimiterDataAccess.getEntity(connexion,relprocesocambiarparametrogeneral.getid_tipo_delimiter());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodelimiter;

	}


	
	
	public void getProcesoCambiarParametroGeneralsBusquedaProcesoCambiarParametroGeneralWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_visual,Boolean con_mensaje_confirmacion,Boolean con_botones_tool_bar,Long id_tipo_fondo,Long id_tipo_fondo_borde,Long id_tipo_fondo_control,Long id_tipo_tamanio_control,Long id_tipo_exportar,Long id_tipo_delimiter,Boolean con_exportar_cabecera,String path_exportar)throws Exception {
		try {
			ProcesoCambiarParametroGeneralLogicAdditional procesocambiarparametrogeneralLogicAdditional=new ProcesoCambiarParametroGeneralLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocambiarparametrogeneralLogicAdditional.BusquedaProcesoCambiarParametroGeneral(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_visual,con_mensaje_confirmacion,con_botones_tool_bar,id_tipo_fondo,id_tipo_fondo_borde,id_tipo_fondo_control,id_tipo_tamanio_control,id_tipo_exportar,id_tipo_delimiter,con_exportar_cabecera,path_exportar);

			//this.procesocambiarparametrogenerals=this.getProcesoCambiarParametroGenerals();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCambiarParametroGeneralLogicAdditional.ProcesarInformacionProcesoCambiarParametroGeneral(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocambiarparametrogeneralLogicAdditional,this.procesocambiarparametrogenerals,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCambiarParametroGeneral",id_tipo_visual,con_mensaje_confirmacion,con_botones_tool_bar,id_tipo_fondo,id_tipo_fondo_borde,id_tipo_fondo_control,id_tipo_tamanio_control,id_tipo_exportar,id_tipo_delimiter,con_exportar_cabecera,path_exportar);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCambiarParametroGeneralsBusquedaProcesoCambiarParametroGeneral(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_visual,Boolean con_mensaje_confirmacion,Boolean con_botones_tool_bar,Long id_tipo_fondo,Long id_tipo_fondo_borde,Long id_tipo_fondo_control,Long id_tipo_tamanio_control,Long id_tipo_exportar,Long id_tipo_delimiter,Boolean con_exportar_cabecera,String path_exportar)throws Exception {
		try {
			ProcesoCambiarParametroGeneralLogicAdditional procesocambiarparametrogeneralLogicAdditional=new ProcesoCambiarParametroGeneralLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocambiarparametrogeneralLogicAdditional.BusquedaProcesoCambiarParametroGeneral(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_visual,con_mensaje_confirmacion,con_botones_tool_bar,id_tipo_fondo,id_tipo_fondo_borde,id_tipo_fondo_control,id_tipo_tamanio_control,id_tipo_exportar,id_tipo_delimiter,con_exportar_cabecera,path_exportar);

			//this.procesocambiarparametrogenerals=this.getProcesoCambiarParametroGenerals();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCambiarParametroGeneralLogicAdditional.ProcesarInformacionProcesoCambiarParametroGeneral(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocambiarparametrogeneralLogicAdditional,this.procesocambiarparametrogenerals,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCambiarParametroGeneral",id_tipo_visual,con_mensaje_confirmacion,con_botones_tool_bar,id_tipo_fondo,id_tipo_fondo_borde,id_tipo_fondo_control,id_tipo_tamanio_control,id_tipo_exportar,id_tipo_delimiter,con_exportar_cabecera,path_exportar);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoCambiarParametroGeneralLogicAdditional.updateProcesoCambiarParametroGeneralToGet(procesocambiarparametrogeneral,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocambiarparametrogeneral.setTipoVisual(procesocambiarparametrogeneralDataAccess.getTipoVisual(connexion,procesocambiarparametrogeneral));
		procesocambiarparametrogeneral.setTipoFondo(procesocambiarparametrogeneralDataAccess.getTipoFondo(connexion,procesocambiarparametrogeneral));
		procesocambiarparametrogeneral.setTipoFondoBorde(procesocambiarparametrogeneralDataAccess.getTipoFondoBorde(connexion,procesocambiarparametrogeneral));
		procesocambiarparametrogeneral.setTipoFondoControl(procesocambiarparametrogeneralDataAccess.getTipoFondoControl(connexion,procesocambiarparametrogeneral));
		procesocambiarparametrogeneral.setTipoTamanioControl(procesocambiarparametrogeneralDataAccess.getTipoTamanioControl(connexion,procesocambiarparametrogeneral));
		procesocambiarparametrogeneral.setTipoExportar(procesocambiarparametrogeneralDataAccess.getTipoExportar(connexion,procesocambiarparametrogeneral));
		procesocambiarparametrogeneral.setTipoDelimiter(procesocambiarparametrogeneralDataAccess.getTipoDelimiter(connexion,procesocambiarparametrogeneral));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVisual.class)) {
				procesocambiarparametrogeneral.setTipoVisual(procesocambiarparametrogeneralDataAccess.getTipoVisual(connexion,procesocambiarparametrogeneral));
			}

			if(clas.clas.equals(TipoFondo.class)) {
				procesocambiarparametrogeneral.setTipoFondo(procesocambiarparametrogeneralDataAccess.getTipoFondo(connexion,procesocambiarparametrogeneral));
			}

			if(clas.clas.equals(TipoFondo.class)) {
				procesocambiarparametrogeneral.setTipoFondoBorde(procesocambiarparametrogeneralDataAccess.getTipoFondoBorde(connexion,procesocambiarparametrogeneral));
			}

			if(clas.clas.equals(TipoFondoControl.class)) {
				procesocambiarparametrogeneral.setTipoFondoControl(procesocambiarparametrogeneralDataAccess.getTipoFondoControl(connexion,procesocambiarparametrogeneral));
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				procesocambiarparametrogeneral.setTipoTamanioControl(procesocambiarparametrogeneralDataAccess.getTipoTamanioControl(connexion,procesocambiarparametrogeneral));
			}

			if(clas.clas.equals(TipoExportar.class)) {
				procesocambiarparametrogeneral.setTipoExportar(procesocambiarparametrogeneralDataAccess.getTipoExportar(connexion,procesocambiarparametrogeneral));
			}

			if(clas.clas.equals(TipoDelimiter.class)) {
				procesocambiarparametrogeneral.setTipoDelimiter(procesocambiarparametrogeneralDataAccess.getTipoDelimiter(connexion,procesocambiarparametrogeneral));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVisual.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoVisual(procesocambiarparametrogeneralDataAccess.getTipoVisual(connexion,procesocambiarparametrogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoFondo(procesocambiarparametrogeneralDataAccess.getTipoFondo(connexion,procesocambiarparametrogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoFondoBorde(procesocambiarparametrogeneralDataAccess.getTipoFondoBorde(connexion,procesocambiarparametrogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondoControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoFondoControl(procesocambiarparametrogeneralDataAccess.getTipoFondoControl(connexion,procesocambiarparametrogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTamanioControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoTamanioControl(procesocambiarparametrogeneralDataAccess.getTipoTamanioControl(connexion,procesocambiarparametrogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoExportar.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoExportar(procesocambiarparametrogeneralDataAccess.getTipoExportar(connexion,procesocambiarparametrogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDelimiter.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoDelimiter(procesocambiarparametrogeneralDataAccess.getTipoDelimiter(connexion,procesocambiarparametrogeneral));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocambiarparametrogeneral.setTipoVisual(procesocambiarparametrogeneralDataAccess.getTipoVisual(connexion,procesocambiarparametrogeneral));
		TipoVisualLogic tipovisualLogic= new TipoVisualLogic(connexion);
		tipovisualLogic.deepLoad(procesocambiarparametrogeneral.getTipoVisual(),isDeep,deepLoadType,clases);
				
		procesocambiarparametrogeneral.setTipoFondo(procesocambiarparametrogeneralDataAccess.getTipoFondo(connexion,procesocambiarparametrogeneral));
		TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
		tipofondoLogic.deepLoad(procesocambiarparametrogeneral.getTipoFondo(),isDeep,deepLoadType,clases);
				
		procesocambiarparametrogeneral.setTipoFondoBorde(procesocambiarparametrogeneralDataAccess.getTipoFondoBorde(connexion,procesocambiarparametrogeneral));
		TipoFondoLogic tipofondobordeLogic= new TipoFondoLogic(connexion);
		tipofondobordeLogic.deepLoad(procesocambiarparametrogeneral.getTipoFondoBorde(),isDeep,deepLoadType,clases);
				
		procesocambiarparametrogeneral.setTipoFondoControl(procesocambiarparametrogeneralDataAccess.getTipoFondoControl(connexion,procesocambiarparametrogeneral));
		TipoFondoControlLogic tipofondocontrolLogic= new TipoFondoControlLogic(connexion);
		tipofondocontrolLogic.deepLoad(procesocambiarparametrogeneral.getTipoFondoControl(),isDeep,deepLoadType,clases);
				
		procesocambiarparametrogeneral.setTipoTamanioControl(procesocambiarparametrogeneralDataAccess.getTipoTamanioControl(connexion,procesocambiarparametrogeneral));
		TipoTamanioControlLogic tipotamaniocontrolLogic= new TipoTamanioControlLogic(connexion);
		tipotamaniocontrolLogic.deepLoad(procesocambiarparametrogeneral.getTipoTamanioControl(),isDeep,deepLoadType,clases);
				
		procesocambiarparametrogeneral.setTipoExportar(procesocambiarparametrogeneralDataAccess.getTipoExportar(connexion,procesocambiarparametrogeneral));
		TipoExportarLogic tipoexportarLogic= new TipoExportarLogic(connexion);
		tipoexportarLogic.deepLoad(procesocambiarparametrogeneral.getTipoExportar(),isDeep,deepLoadType,clases);
				
		procesocambiarparametrogeneral.setTipoDelimiter(procesocambiarparametrogeneralDataAccess.getTipoDelimiter(connexion,procesocambiarparametrogeneral));
		TipoDelimiterLogic tipodelimiterLogic= new TipoDelimiterLogic(connexion);
		tipodelimiterLogic.deepLoad(procesocambiarparametrogeneral.getTipoDelimiter(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVisual.class)) {
				procesocambiarparametrogeneral.setTipoVisual(procesocambiarparametrogeneralDataAccess.getTipoVisual(connexion,procesocambiarparametrogeneral));
				TipoVisualLogic tipovisualLogic= new TipoVisualLogic(connexion);
				tipovisualLogic.deepLoad(procesocambiarparametrogeneral.getTipoVisual(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoFondo.class)) {
				procesocambiarparametrogeneral.setTipoFondo(procesocambiarparametrogeneralDataAccess.getTipoFondo(connexion,procesocambiarparametrogeneral));
				TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
				tipofondoLogic.deepLoad(procesocambiarparametrogeneral.getTipoFondo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoFondo.class)) {
				procesocambiarparametrogeneral.setTipoFondoBorde(procesocambiarparametrogeneralDataAccess.getTipoFondoBorde(connexion,procesocambiarparametrogeneral));
				TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
				tipofondoLogic.deepLoad(procesocambiarparametrogeneral.getTipoFondoBorde(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoFondoControl.class)) {
				procesocambiarparametrogeneral.setTipoFondoControl(procesocambiarparametrogeneralDataAccess.getTipoFondoControl(connexion,procesocambiarparametrogeneral));
				TipoFondoControlLogic tipofondocontrolLogic= new TipoFondoControlLogic(connexion);
				tipofondocontrolLogic.deepLoad(procesocambiarparametrogeneral.getTipoFondoControl(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				procesocambiarparametrogeneral.setTipoTamanioControl(procesocambiarparametrogeneralDataAccess.getTipoTamanioControl(connexion,procesocambiarparametrogeneral));
				TipoTamanioControlLogic tipotamaniocontrolLogic= new TipoTamanioControlLogic(connexion);
				tipotamaniocontrolLogic.deepLoad(procesocambiarparametrogeneral.getTipoTamanioControl(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoExportar.class)) {
				procesocambiarparametrogeneral.setTipoExportar(procesocambiarparametrogeneralDataAccess.getTipoExportar(connexion,procesocambiarparametrogeneral));
				TipoExportarLogic tipoexportarLogic= new TipoExportarLogic(connexion);
				tipoexportarLogic.deepLoad(procesocambiarparametrogeneral.getTipoExportar(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoDelimiter.class)) {
				procesocambiarparametrogeneral.setTipoDelimiter(procesocambiarparametrogeneralDataAccess.getTipoDelimiter(connexion,procesocambiarparametrogeneral));
				TipoDelimiterLogic tipodelimiterLogic= new TipoDelimiterLogic(connexion);
				tipodelimiterLogic.deepLoad(procesocambiarparametrogeneral.getTipoDelimiter(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVisual.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoVisual(procesocambiarparametrogeneralDataAccess.getTipoVisual(connexion,procesocambiarparametrogeneral));
			TipoVisualLogic tipovisualLogic= new TipoVisualLogic(connexion);
			tipovisualLogic.deepLoad(procesocambiarparametrogeneral.getTipoVisual(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoFondo(procesocambiarparametrogeneralDataAccess.getTipoFondo(connexion,procesocambiarparametrogeneral));
			TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
			tipofondoLogic.deepLoad(procesocambiarparametrogeneral.getTipoFondo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoFondoBorde(procesocambiarparametrogeneralDataAccess.getTipoFondoBorde(connexion,procesocambiarparametrogeneral));
			TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
			tipofondoLogic.deepLoad(procesocambiarparametrogeneral.getTipoFondoBorde(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondoControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoFondoControl(procesocambiarparametrogeneralDataAccess.getTipoFondoControl(connexion,procesocambiarparametrogeneral));
			TipoFondoControlLogic tipofondocontrolLogic= new TipoFondoControlLogic(connexion);
			tipofondocontrolLogic.deepLoad(procesocambiarparametrogeneral.getTipoFondoControl(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTamanioControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoTamanioControl(procesocambiarparametrogeneralDataAccess.getTipoTamanioControl(connexion,procesocambiarparametrogeneral));
			TipoTamanioControlLogic tipotamaniocontrolLogic= new TipoTamanioControlLogic(connexion);
			tipotamaniocontrolLogic.deepLoad(procesocambiarparametrogeneral.getTipoTamanioControl(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoExportar.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoExportar(procesocambiarparametrogeneralDataAccess.getTipoExportar(connexion,procesocambiarparametrogeneral));
			TipoExportarLogic tipoexportarLogic= new TipoExportarLogic(connexion);
			tipoexportarLogic.deepLoad(procesocambiarparametrogeneral.getTipoExportar(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDelimiter.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocambiarparametrogeneral.setTipoDelimiter(procesocambiarparametrogeneralDataAccess.getTipoDelimiter(connexion,procesocambiarparametrogeneral));
			TipoDelimiterLogic tipodelimiterLogic= new TipoDelimiterLogic(connexion);
			tipodelimiterLogic.deepLoad(procesocambiarparametrogeneral.getTipoDelimiter(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesocambiarparametrogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCambiarParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarParametroGeneral(procesocambiarparametrogeneral);
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
			this.deepLoad(this.procesocambiarparametrogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCambiarParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarParametroGeneral(this.procesocambiarparametrogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocambiarparametrogenerals!=null) {
				for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral:procesocambiarparametrogenerals) {
					this.deepLoad(procesocambiarparametrogeneral,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCambiarParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarParametroGeneral(procesocambiarparametrogenerals);
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
			if(procesocambiarparametrogenerals!=null) {
				for(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral:procesocambiarparametrogenerals) {
					this.deepLoad(procesocambiarparametrogeneral,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCambiarParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCambiarParametroGeneral(procesocambiarparametrogenerals);
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
	
	public ProcesoCambiarParametroGeneralParameterReturnGeneral procesarAccionProcesoCambiarParametroGenerals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,ProcesoCambiarParametroGeneralParameterReturnGeneral procesocambiarparametrogeneralParameterGeneral)throws Exception {
		 try {	
			ProcesoCambiarParametroGeneralParameterReturnGeneral procesocambiarparametrogeneralReturnGeneral=new ProcesoCambiarParametroGeneralParameterReturnGeneral();
	
			ProcesoCambiarParametroGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocambiarparametrogenerals,procesocambiarparametrogeneralParameterGeneral,procesocambiarparametrogeneralReturnGeneral);
			
			return procesocambiarparametrogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCambiarParametroGeneralParameterReturnGeneral procesarAccionProcesoCambiarParametroGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,ProcesoCambiarParametroGeneralParameterReturnGeneral procesocambiarparametrogeneralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCambiarParametroGeneralParameterReturnGeneral procesocambiarparametrogeneralReturnGeneral=new ProcesoCambiarParametroGeneralParameterReturnGeneral();
	
			ProcesoCambiarParametroGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocambiarparametrogenerals,procesocambiarparametrogeneralParameterGeneral,procesocambiarparametrogeneralReturnGeneral);
			
			this.connexion.commit();
			
			return procesocambiarparametrogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,String sTipoBusqueda,Long id_tipo_visualBusquedaProcesoCambiarParametroGeneral,Boolean con_mensaje_confirmacionBusquedaProcesoCambiarParametroGeneral,Boolean con_botones_tool_barBusquedaProcesoCambiarParametroGeneral,Long id_tipo_fondoBusquedaProcesoCambiarParametroGeneral,Long id_tipo_fondo_bordeBusquedaProcesoCambiarParametroGeneral,Long id_tipo_fondo_controlBusquedaProcesoCambiarParametroGeneral,Long id_tipo_tamanio_controlBusquedaProcesoCambiarParametroGeneral,Long id_tipo_exportarBusquedaProcesoCambiarParametroGeneral,Long id_tipo_delimiterBusquedaProcesoCambiarParametroGeneral,Boolean con_exportar_cabeceraBusquedaProcesoCambiarParametroGeneral,String path_exportarBusquedaProcesoCambiarParametroGeneral) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoCambiarParametroGeneralLogicAdditional procesocambiarparametrogeneralLogicAdditional=new ProcesoCambiarParametroGeneralLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesocambiarparametrogeneralLogicAdditional.setConnexion(this.connexion);

			procesocambiarparametrogeneralLogicAdditional.ProcesarInformacionProcesoCambiarParametroGeneral(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocambiarparametrogenerals,sTipoBusqueda,id_tipo_visualBusquedaProcesoCambiarParametroGeneral,con_mensaje_confirmacionBusquedaProcesoCambiarParametroGeneral,con_botones_tool_barBusquedaProcesoCambiarParametroGeneral,id_tipo_fondoBusquedaProcesoCambiarParametroGeneral,id_tipo_fondo_bordeBusquedaProcesoCambiarParametroGeneral,id_tipo_fondo_controlBusquedaProcesoCambiarParametroGeneral,id_tipo_tamanio_controlBusquedaProcesoCambiarParametroGeneral,id_tipo_exportarBusquedaProcesoCambiarParametroGeneral,id_tipo_delimiterBusquedaProcesoCambiarParametroGeneral,con_exportar_cabeceraBusquedaProcesoCambiarParametroGeneral,path_exportarBusquedaProcesoCambiarParametroGeneral);

			//this.connexion.commit();
		} catch(Exception e) {
			//this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			//this.connexion.close();
		}

		return procesado;
	}

	
}

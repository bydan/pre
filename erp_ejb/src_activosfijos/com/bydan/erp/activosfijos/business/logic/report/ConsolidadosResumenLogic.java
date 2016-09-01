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
package com.bydan.erp.activosfijos.business.logic.report;

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

import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.resources.general.AuxiliarGeneral;
import com.bydan.erp.activosfijos.util.report.ConsolidadosResumenParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ConsolidadosResumenParameterGeneral;
import com.bydan.erp.activosfijos.util.report.ConsolidadosResumenConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.ConsolidadosResumen;

import com.bydan.erp.activosfijos.business.logic.report.ConsolidadosResumenLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ConsolidadosResumenLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ConsolidadosResumenLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ConsolidadosResumenLogic consolidadosresumenDataAccess; 		
	protected ConsolidadosResumen consolidadosresumen;
	protected List<ConsolidadosResumen> consolidadosresumens;
	protected Object consolidadosresumenObject;	
	protected List<Object> consolidadosresumensObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ConsolidadosResumenLogic()throws SQLException,Exception {
		try	{
			this.consolidadosresumens= new ArrayList<ConsolidadosResumen>();
			this.consolidadosresumen= new ConsolidadosResumen();
			this.consolidadosresumenObject=new Object();
			this.consolidadosresumensObject=new ArrayList<Object>();
			
			this.consolidadosresumenDataAccess=this;
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
			this.consolidadosresumenDataAccess.setConnexionType(this.connexionType);
			this.consolidadosresumenDataAccess.setParameterDbType(this.parameterDbType);
			this.consolidadosresumenDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConsolidadosResumenLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.consolidadosresumens= new ArrayList<ConsolidadosResumen>();
			this.consolidadosresumen= new ConsolidadosResumen();
			this.consolidadosresumenObject=new Object();
			this.consolidadosresumensObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.consolidadosresumenDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.consolidadosresumenDataAccess.setConnexionType(this.connexionType);
			this.consolidadosresumenDataAccess.setParameterDbType(this.parameterDbType);
			this.consolidadosresumenDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ConsolidadosResumen getConsolidadosResumen() throws Exception {	
		ConsolidadosResumenLogicAdditional.checkConsolidadosResumenToGet(consolidadosresumen,this.datosCliente,this.arrDatoGeneral);
		ConsolidadosResumenLogicAdditional.updateConsolidadosResumenToGet(consolidadosresumen,this.arrDatoGeneral);
		
		return consolidadosresumen;
	}
		
	public void setConsolidadosResumen(ConsolidadosResumen newConsolidadosResumen) {
		this.consolidadosresumen = newConsolidadosResumen;
	}
	
	public List<ConsolidadosResumen> getConsolidadosResumens() throws Exception {		
		this.quitarConsolidadosResumensNulos();
		
		ConsolidadosResumenLogicAdditional.checkConsolidadosResumenToGets(consolidadosresumens,this.datosCliente,this.arrDatoGeneral);
		
		for (ConsolidadosResumen consolidadosresumenLocal: consolidadosresumens ) {
			ConsolidadosResumenLogicAdditional.updateConsolidadosResumenToGet(consolidadosresumenLocal,this.arrDatoGeneral);
		}
		
		return consolidadosresumens;
	}
	
	public void setConsolidadosResumens(List<ConsolidadosResumen> newConsolidadosResumens) {
		this.consolidadosresumens = newConsolidadosResumens;
	}
	
	public Object getConsolidadosResumenObject() {	
		//this.consolidadosresumenObject=this.consolidadosresumenDataAccess.getEntityObject();
		return this.consolidadosresumenObject;
	}
		
	public void setConsolidadosResumenObject(Object newConsolidadosResumenObject) {
		this.consolidadosresumenObject = newConsolidadosResumenObject;
	}
	
	public List<Object> getConsolidadosResumensObject() {		
		//this.consolidadosresumensObject=this.consolidadosresumenDataAccess.getEntitiesObject();
		return this.consolidadosresumensObject;
	}
		
	public void setConsolidadosResumensObject(List<Object> newConsolidadosResumensObject) {
		this.consolidadosresumensObject = newConsolidadosResumensObject;
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
		consolidadosresumens = new  ArrayList<ConsolidadosResumen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsolidadosResumenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosresumens=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		consolidadosresumens = new  ArrayList<ConsolidadosResumen>();
		  		  
        try {
			//ConsolidadosResumenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosresumens=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		consolidadosresumens = new  ArrayList<ConsolidadosResumen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsolidadosResumenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosresumens=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		consolidadosresumens = new  ArrayList<ConsolidadosResumen>();
		  		  
        try {
			//ConsolidadosResumenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosresumens=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		consolidadosresumens = new  ArrayList<ConsolidadosResumen>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsolidadosResumenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosresumens=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		consolidadosresumens = new  ArrayList<ConsolidadosResumen>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ConsolidadosResumenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosresumens=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ConsolidadosResumen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsolidadosResumen> entities = new  ArrayList<ConsolidadosResumen>();
		ConsolidadosResumen entity = new ConsolidadosResumen();		  
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
	
	public  List<ConsolidadosResumen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsolidadosResumen> entities = new  ArrayList<ConsolidadosResumen>();
		ConsolidadosResumen entity = new ConsolidadosResumen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConsolidadosResumen();
				
				
      	    	entity=ConsolidadosResumenLogic.getEntityConsolidadosResumen("",entity,resultSet);
      	    	
				//entity.setConsolidadosResumenOriginal( new ConsolidadosResumen());
      	    	//entity.setConsolidadosResumenOriginal(super.getEntity("",entity.getConsolidadosResumenOriginal(),resultSet,ConsolidadosResumenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConsolidadosResumenOriginal(ConsolidadosResumenDataAccess.getEntityConsolidadosResumen("",entity.getConsolidadosResumenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ConsolidadosResumen> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsolidadosResumen> entities = new  ArrayList<ConsolidadosResumen>();
		ConsolidadosResumen entity = new ConsolidadosResumen();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ConsolidadosResumen.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConsolidadosResumen>((List<ConsolidadosResumen>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConsolidadosResumensOriginal(entities);
			
			}  else {
				this.consolidadosresumensObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConsolidadosResumenConstantesFunciones.quitarEspaciosConsolidadosResumens(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ConsolidadosResumen getEntityConsolidadosResumen(String strPrefijo,ConsolidadosResumen entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_empresa(resultSet.getString(strPrefijo+ConsolidadosResumenConstantesFunciones.NOMBREEMPRESA));
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+ConsolidadosResumenConstantesFunciones.NOMBRESUCURSAL));
			entity.setcodigo_sub_grupo(resultSet.getString(strPrefijo+ConsolidadosResumenConstantesFunciones.CODIGOSUBGRUPO));
			entity.setnombre_sub_grupo(resultSet.getString(strPrefijo+ConsolidadosResumenConstantesFunciones.NOMBRESUBGRUPO));
			entity.setcodigo_detalle_grupo(resultSet.getString(strPrefijo+ConsolidadosResumenConstantesFunciones.CODIGODETALLEGRUPO));
			entity.setnombre_detalle_grupo(resultSet.getString(strPrefijo+ConsolidadosResumenConstantesFunciones.NOMBREDETALLEGRUPO));
			entity.setclave(resultSet.getString(strPrefijo+ConsolidadosResumenConstantesFunciones.CLAVE));
			entity.setnombre(resultSet.getString(strPrefijo+ConsolidadosResumenConstantesFunciones.NOMBRE));
			entity.setfecha_compra(new Date(resultSet.getDate(strPrefijo+ConsolidadosResumenConstantesFunciones.FECHACOMPRA).getTime()));
			entity.setvida_util(resultSet.getDouble(strPrefijo+ConsolidadosResumenConstantesFunciones.VIDAUTIL));
			entity.setcosto_de_compra(resultSet.getDouble(strPrefijo+ConsolidadosResumenConstantesFunciones.COSTODECOMPRA));
			entity.setcantidad(resultSet.getInt(strPrefijo+ConsolidadosResumenConstantesFunciones.CANTIDAD));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ConsolidadosResumen getEntityConsolidadosResumen(String strPrefijo,ConsolidadosResumen entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ConsolidadosResumen.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ConsolidadosResumen.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ConsolidadosResumenLogic.setFieldReflectionConsolidadosResumen(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionConsolidadosResumen(Field field,String strPrefijo,String sColumn,ConsolidadosResumen entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ConsolidadosResumenConstantesFunciones.NOMBREEMPRESA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.CODIGOSUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.NOMBRESUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.CODIGODETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.NOMBREDETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.CLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.FECHACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ConsolidadosResumenConstantesFunciones.VIDAUTIL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.COSTODECOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConsolidadosResumenConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	public void quitarConsolidadosResumensNulos() throws Exception {				
		
		List<ConsolidadosResumen> consolidadosresumensAux= new ArrayList<ConsolidadosResumen>();
		
		for(ConsolidadosResumen consolidadosresumen:consolidadosresumens) {
			if(consolidadosresumen!=null) {
				consolidadosresumensAux.add(consolidadosresumen);
			}
		}
		
		consolidadosresumens=consolidadosresumensAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsolidadosResumen> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsolidadosResumen> entities = new  ArrayList<ConsolidadosResumen>();
		ConsolidadosResumen entity = new ConsolidadosResumen();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConsolidadosResumen>((List<ConsolidadosResumen>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConsolidadosResumensOriginal(entities);
			
			}  else {
				this.consolidadosresumensObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConsolidadosResumenConstantesFunciones.quitarEspaciosConsolidadosResumens(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		consolidadosresumens = new  ArrayList<ConsolidadosResumen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsolidadosResumenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosresumens=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		consolidadosresumens = new  ArrayList<ConsolidadosResumen>();
		  		  
        try {
			//ConsolidadosResumenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consolidadosresumens=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ConsolidadosResumen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConsolidadosResumen> entities = new  ArrayList<ConsolidadosResumen>();
		ConsolidadosResumen entity = new ConsolidadosResumen();		  
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
	
	public  List<ConsolidadosResumen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConsolidadosResumen> entities = new  ArrayList<ConsolidadosResumen>();
		ConsolidadosResumen entity = new ConsolidadosResumen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConsolidadosResumen();
				
				if(conMapGenerico) {
					entity.setMapConsolidadosResumen( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapConsolidadosResumen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConsolidadosResumenDataAccess.ISWITHSCHEMA);         		
					entity=ConsolidadosResumenLogic.getEntityConsolidadosResumen("",entity,resultSet,listColumns);
					
					////entity.setConsolidadosResumenOriginal( new ConsolidadosResumen());
					////entity.setConsolidadosResumenOriginal(super.getEntity("",entity.getConsolidadosResumenOriginal(),resultSet,ConsolidadosResumenDataAccess.ISWITHSCHEMA));         		
					////entity.setConsolidadosResumenOriginal(ConsolidadosResumenDataAccess.getEntityConsolidadosResumen("",entity.getConsolidadosResumenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ConsolidadosResumen relconsolidadosresumen)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relconsolidadosresumen.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getConsolidadosResumensBusquedaConsolidadosResumenWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//ConsolidadosResumenLogic consolidadosresumenLogic=new ConsolidadosResumenLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConsolidadosResumenLogic.GetSelecSqlConsolidadosResumen(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.consolidadosresumens=this.getConsolidadosResumens();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getConsolidadosResumensBusquedaConsolidadosResumen(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		try {
			//ConsolidadosResumenLogic consolidadosresumenLogic=new ConsolidadosResumenLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConsolidadosResumenLogic.GetSelecSqlConsolidadosResumen(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.consolidadosresumens=this.getConsolidadosResumens();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlConsolidadosResumen(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ConsolidadosResumen_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
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
	
	
	public void deepLoad(ConsolidadosResumen consolidadosresumen,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConsolidadosResumenLogicAdditional.updateConsolidadosResumenToGet(consolidadosresumen,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consolidadosresumen.setEmpresa(consolidadosresumenDataAccess.getEmpresa(connexion,consolidadosresumen));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consolidadosresumen.setEmpresa(consolidadosresumenDataAccess.getEmpresa(connexion,consolidadosresumen));
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
			consolidadosresumen.setEmpresa(consolidadosresumenDataAccess.getEmpresa(connexion,consolidadosresumen));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consolidadosresumen.setEmpresa(consolidadosresumenDataAccess.getEmpresa(connexion,consolidadosresumen));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(consolidadosresumen.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consolidadosresumen.setEmpresa(consolidadosresumenDataAccess.getEmpresa(connexion,consolidadosresumen));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(consolidadosresumen.getEmpresa(),isDeep,deepLoadType,clases);				
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
			consolidadosresumen.setEmpresa(consolidadosresumenDataAccess.getEmpresa(connexion,consolidadosresumen));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(consolidadosresumen.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(consolidadosresumen,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsolidadosResumenConstantesFunciones.refrescarForeignKeysDescripcionesConsolidadosResumen(consolidadosresumen);
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
			this.deepLoad(this.consolidadosresumen,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsolidadosResumenConstantesFunciones.refrescarForeignKeysDescripcionesConsolidadosResumen(this.consolidadosresumen);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(consolidadosresumens!=null) {
				for(ConsolidadosResumen consolidadosresumen:consolidadosresumens) {
					this.deepLoad(consolidadosresumen,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConsolidadosResumenConstantesFunciones.refrescarForeignKeysDescripcionesConsolidadosResumen(consolidadosresumens);
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
			if(consolidadosresumens!=null) {
				for(ConsolidadosResumen consolidadosresumen:consolidadosresumens) {
					this.deepLoad(consolidadosresumen,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConsolidadosResumenConstantesFunciones.refrescarForeignKeysDescripcionesConsolidadosResumen(consolidadosresumens);
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
	
	public ConsolidadosResumenParameterReturnGeneral procesarAccionConsolidadosResumens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConsolidadosResumen> consolidadosresumens,ConsolidadosResumenParameterReturnGeneral consolidadosresumenParameterGeneral)throws Exception {
		 try {	
			ConsolidadosResumenParameterReturnGeneral consolidadosresumenReturnGeneral=new ConsolidadosResumenParameterReturnGeneral();
	
			ConsolidadosResumenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consolidadosresumens,consolidadosresumenParameterGeneral,consolidadosresumenReturnGeneral);
			
			return consolidadosresumenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConsolidadosResumenParameterReturnGeneral procesarAccionConsolidadosResumensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConsolidadosResumen> consolidadosresumens,ConsolidadosResumenParameterReturnGeneral consolidadosresumenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ConsolidadosResumenParameterReturnGeneral consolidadosresumenReturnGeneral=new ConsolidadosResumenParameterReturnGeneral();
	
			ConsolidadosResumenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consolidadosresumens,consolidadosresumenParameterGeneral,consolidadosresumenReturnGeneral);
			
			this.connexion.commit();
			
			return consolidadosresumenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

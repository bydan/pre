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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;
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
import com.bydan.erp.contabilidad.util.report.VistaTotalSaldosParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.VistaTotalSaldosParameterGeneral;
import com.bydan.erp.contabilidad.util.report.VistaTotalSaldosConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.VistaTotalSaldos;

import com.bydan.erp.contabilidad.business.logic.report.VistaTotalSaldosLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class VistaTotalSaldosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(VistaTotalSaldosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected VistaTotalSaldosLogic vistatotalsaldosDataAccess; 		
	protected VistaTotalSaldos vistatotalsaldos;
	protected List<VistaTotalSaldos> vistatotalsaldoss;
	protected Object vistatotalsaldosObject;	
	protected List<Object> vistatotalsaldossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  VistaTotalSaldosLogic()throws SQLException,Exception {
		try	{
			this.vistatotalsaldoss= new ArrayList<VistaTotalSaldos>();
			this.vistatotalsaldos= new VistaTotalSaldos();
			this.vistatotalsaldosObject=new Object();
			this.vistatotalsaldossObject=new ArrayList<Object>();
			
			this.vistatotalsaldosDataAccess=this;
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
			this.vistatotalsaldosDataAccess.setConnexionType(this.connexionType);
			this.vistatotalsaldosDataAccess.setParameterDbType(this.parameterDbType);
			this.vistatotalsaldosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VistaTotalSaldosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.vistatotalsaldoss= new ArrayList<VistaTotalSaldos>();
			this.vistatotalsaldos= new VistaTotalSaldos();
			this.vistatotalsaldosObject=new Object();
			this.vistatotalsaldossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.vistatotalsaldosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.vistatotalsaldosDataAccess.setConnexionType(this.connexionType);
			this.vistatotalsaldosDataAccess.setParameterDbType(this.parameterDbType);
			this.vistatotalsaldosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public VistaTotalSaldos getVistaTotalSaldos() throws Exception {	
		VistaTotalSaldosLogicAdditional.checkVistaTotalSaldosToGet(vistatotalsaldos,this.datosCliente,this.arrDatoGeneral);
		VistaTotalSaldosLogicAdditional.updateVistaTotalSaldosToGet(vistatotalsaldos,this.arrDatoGeneral);
		
		return vistatotalsaldos;
	}
		
	public void setVistaTotalSaldos(VistaTotalSaldos newVistaTotalSaldos) {
		this.vistatotalsaldos = newVistaTotalSaldos;
	}
	
	public List<VistaTotalSaldos> getVistaTotalSaldoss() throws Exception {		
		this.quitarVistaTotalSaldossNulos();
		
		VistaTotalSaldosLogicAdditional.checkVistaTotalSaldosToGets(vistatotalsaldoss,this.datosCliente,this.arrDatoGeneral);
		
		for (VistaTotalSaldos vistatotalsaldosLocal: vistatotalsaldoss ) {
			VistaTotalSaldosLogicAdditional.updateVistaTotalSaldosToGet(vistatotalsaldosLocal,this.arrDatoGeneral);
		}
		
		return vistatotalsaldoss;
	}
	
	public void setVistaTotalSaldoss(List<VistaTotalSaldos> newVistaTotalSaldoss) {
		this.vistatotalsaldoss = newVistaTotalSaldoss;
	}
	
	public Object getVistaTotalSaldosObject() {	
		//this.vistatotalsaldosObject=this.vistatotalsaldosDataAccess.getEntityObject();
		return this.vistatotalsaldosObject;
	}
		
	public void setVistaTotalSaldosObject(Object newVistaTotalSaldosObject) {
		this.vistatotalsaldosObject = newVistaTotalSaldosObject;
	}
	
	public List<Object> getVistaTotalSaldossObject() {		
		//this.vistatotalsaldossObject=this.vistatotalsaldosDataAccess.getEntitiesObject();
		return this.vistatotalsaldossObject;
	}
		
	public void setVistaTotalSaldossObject(List<Object> newVistaTotalSaldossObject) {
		this.vistatotalsaldossObject = newVistaTotalSaldossObject;
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
		vistatotalsaldoss = new  ArrayList<VistaTotalSaldos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VistaTotalSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vistatotalsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		vistatotalsaldoss = new  ArrayList<VistaTotalSaldos>();
		  		  
        try {
			//VistaTotalSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vistatotalsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vistatotalsaldoss = new  ArrayList<VistaTotalSaldos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VistaTotalSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vistatotalsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		vistatotalsaldoss = new  ArrayList<VistaTotalSaldos>();
		  		  
        try {
			//VistaTotalSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vistatotalsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		vistatotalsaldoss = new  ArrayList<VistaTotalSaldos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VistaTotalSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vistatotalsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		vistatotalsaldoss = new  ArrayList<VistaTotalSaldos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//VistaTotalSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vistatotalsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<VistaTotalSaldos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VistaTotalSaldos> entities = new  ArrayList<VistaTotalSaldos>();
		VistaTotalSaldos entity = new VistaTotalSaldos();		  
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
	
	public  List<VistaTotalSaldos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VistaTotalSaldos> entities = new  ArrayList<VistaTotalSaldos>();
		VistaTotalSaldos entity = new VistaTotalSaldos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VistaTotalSaldos();
				
				
      	    	entity=VistaTotalSaldosLogic.getEntityVistaTotalSaldos("",entity,resultSet);
      	    	
				//entity.setVistaTotalSaldosOriginal( new VistaTotalSaldos());
      	    	//entity.setVistaTotalSaldosOriginal(super.getEntity("",entity.getVistaTotalSaldosOriginal(),resultSet,VistaTotalSaldosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVistaTotalSaldosOriginal(VistaTotalSaldosDataAccess.getEntityVistaTotalSaldos("",entity.getVistaTotalSaldosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<VistaTotalSaldos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VistaTotalSaldos> entities = new  ArrayList<VistaTotalSaldos>();
		VistaTotalSaldos entity = new VistaTotalSaldos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,VistaTotalSaldos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<VistaTotalSaldos>((List<VistaTotalSaldos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setVistaTotalSaldossOriginal(entities);
			
			}  else {
				this.vistatotalsaldossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//VistaTotalSaldosConstantesFunciones.quitarEspaciosVistaTotalSaldoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static VistaTotalSaldos getEntityVistaTotalSaldos(String strPrefijo,VistaTotalSaldos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+VistaTotalSaldosConstantesFunciones.IDCUENTACONTABLE));
			entity.settotal_debito_moneda_local(resultSet.getDouble(strPrefijo+VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL));
			entity.settotal_credito_moneda_local(resultSet.getDouble(strPrefijo+VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL));
			entity.settotal_debito_moneda_extran(resultSet.getDouble(strPrefijo+VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN));
			entity.settotal_credito_moneda_extran(resultSet.getDouble(strPrefijo+VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static VistaTotalSaldos getEntityVistaTotalSaldos(String strPrefijo,VistaTotalSaldos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = VistaTotalSaldos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = VistaTotalSaldos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				VistaTotalSaldosLogic.setFieldReflectionVistaTotalSaldos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVistaTotalSaldos(Field field,String strPrefijo,String sColumn,VistaTotalSaldos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VistaTotalSaldosConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN:
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
	
	public void quitarVistaTotalSaldossNulos() throws Exception {				
		
		List<VistaTotalSaldos> vistatotalsaldossAux= new ArrayList<VistaTotalSaldos>();
		
		for(VistaTotalSaldos vistatotalsaldos:vistatotalsaldoss) {
			if(vistatotalsaldos!=null) {
				vistatotalsaldossAux.add(vistatotalsaldos);
			}
		}
		
		vistatotalsaldoss=vistatotalsaldossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<VistaTotalSaldos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VistaTotalSaldos> entities = new  ArrayList<VistaTotalSaldos>();
		VistaTotalSaldos entity = new VistaTotalSaldos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<VistaTotalSaldos>((List<VistaTotalSaldos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setVistaTotalSaldossOriginal(entities);
			
			}  else {
				this.vistatotalsaldossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//VistaTotalSaldosConstantesFunciones.quitarEspaciosVistaTotalSaldoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		vistatotalsaldoss = new  ArrayList<VistaTotalSaldos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VistaTotalSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vistatotalsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		vistatotalsaldoss = new  ArrayList<VistaTotalSaldos>();
		  		  
        try {
			//VistaTotalSaldosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vistatotalsaldoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<VistaTotalSaldos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<VistaTotalSaldos> entities = new  ArrayList<VistaTotalSaldos>();
		VistaTotalSaldos entity = new VistaTotalSaldos();		  
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
	
	public  List<VistaTotalSaldos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<VistaTotalSaldos> entities = new  ArrayList<VistaTotalSaldos>();
		VistaTotalSaldos entity = new VistaTotalSaldos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VistaTotalSaldos();
				
				if(conMapGenerico) {
					entity.setMapVistaTotalSaldos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapVistaTotalSaldos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VistaTotalSaldosDataAccess.ISWITHSCHEMA);         		
					entity=VistaTotalSaldosLogic.getEntityVistaTotalSaldos("",entity,resultSet,listColumns);
					
					////entity.setVistaTotalSaldosOriginal( new VistaTotalSaldos());
					////entity.setVistaTotalSaldosOriginal(super.getEntity("",entity.getVistaTotalSaldosOriginal(),resultSet,VistaTotalSaldosDataAccess.ISWITHSCHEMA));         		
					////entity.setVistaTotalSaldosOriginal(VistaTotalSaldosDataAccess.getEntityVistaTotalSaldos("",entity.getVistaTotalSaldosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public CuentaContable getCuentaContable(Connexion connexion,VistaTotalSaldos relvistatotalsaldos)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontableDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relvistatotalsaldos.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


	
	
	public void getVistaTotalSaldossFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable)throws Exception {
		try {
			//VistaTotalSaldosLogic vistatotalsaldosLogic=new VistaTotalSaldosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=VistaTotalSaldosLogic.GetSelecSqlVistaTotalSaldosFK_IdCuentaContable(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cuenta_contable);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.vistatotalsaldoss=this.getVistaTotalSaldoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getVistaTotalSaldossFK_IdCuentaContable(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable)throws Exception {
		try {
			//VistaTotalSaldosLogic vistatotalsaldosLogic=new VistaTotalSaldosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=VistaTotalSaldosLogic.GetSelecSqlVistaTotalSaldosFK_IdCuentaContable(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cuenta_contable);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.vistatotalsaldoss=this.getVistaTotalSaldoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlVistaTotalSaldosFK_IdCuentaContable(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cuenta_contable)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("VistaTotalSaldos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" e.id_empresa="+parametroGeneralUsuario.getid_empresa();
					//existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" e.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_cuenta_contable!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.id_cuenta_contable = "+id_cuenta_contable.toString();
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
	
	
	public void deepLoad(VistaTotalSaldos vistatotalsaldos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VistaTotalSaldosLogicAdditional.updateVistaTotalSaldosToGet(vistatotalsaldos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vistatotalsaldos.setCuentaContable(vistatotalsaldosDataAccess.getCuentaContable(connexion,vistatotalsaldos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				vistatotalsaldos.setCuentaContable(vistatotalsaldosDataAccess.getCuentaContable(connexion,vistatotalsaldos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vistatotalsaldos.setCuentaContable(vistatotalsaldosDataAccess.getCuentaContable(connexion,vistatotalsaldos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vistatotalsaldos.setCuentaContable(vistatotalsaldosDataAccess.getCuentaContable(connexion,vistatotalsaldos));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(vistatotalsaldos.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				vistatotalsaldos.setCuentaContable(vistatotalsaldosDataAccess.getCuentaContable(connexion,vistatotalsaldos));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(vistatotalsaldos.getCuentaContable(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vistatotalsaldos.setCuentaContable(vistatotalsaldosDataAccess.getCuentaContable(connexion,vistatotalsaldos));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(vistatotalsaldos.getCuentaContable(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(vistatotalsaldos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VistaTotalSaldosConstantesFunciones.refrescarForeignKeysDescripcionesVistaTotalSaldos(vistatotalsaldos);
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
			this.deepLoad(this.vistatotalsaldos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VistaTotalSaldosConstantesFunciones.refrescarForeignKeysDescripcionesVistaTotalSaldos(this.vistatotalsaldos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(vistatotalsaldoss!=null) {
				for(VistaTotalSaldos vistatotalsaldos:vistatotalsaldoss) {
					this.deepLoad(vistatotalsaldos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VistaTotalSaldosConstantesFunciones.refrescarForeignKeysDescripcionesVistaTotalSaldos(vistatotalsaldoss);
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
			if(vistatotalsaldoss!=null) {
				for(VistaTotalSaldos vistatotalsaldos:vistatotalsaldoss) {
					this.deepLoad(vistatotalsaldos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VistaTotalSaldosConstantesFunciones.refrescarForeignKeysDescripcionesVistaTotalSaldos(vistatotalsaldoss);
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
	
	public VistaTotalSaldosParameterReturnGeneral procesarAccionVistaTotalSaldoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VistaTotalSaldos> vistatotalsaldoss,VistaTotalSaldosParameterReturnGeneral vistatotalsaldosParameterGeneral)throws Exception {
		 try {	
			VistaTotalSaldosParameterReturnGeneral vistatotalsaldosReturnGeneral=new VistaTotalSaldosParameterReturnGeneral();
	
			VistaTotalSaldosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vistatotalsaldoss,vistatotalsaldosParameterGeneral,vistatotalsaldosReturnGeneral);
			
			return vistatotalsaldosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VistaTotalSaldosParameterReturnGeneral procesarAccionVistaTotalSaldossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VistaTotalSaldos> vistatotalsaldoss,VistaTotalSaldosParameterReturnGeneral vistatotalsaldosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			VistaTotalSaldosParameterReturnGeneral vistatotalsaldosReturnGeneral=new VistaTotalSaldosParameterReturnGeneral();
	
			VistaTotalSaldosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vistatotalsaldoss,vistatotalsaldosParameterGeneral,vistatotalsaldosReturnGeneral);
			
			this.connexion.commit();
			
			return vistatotalsaldosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

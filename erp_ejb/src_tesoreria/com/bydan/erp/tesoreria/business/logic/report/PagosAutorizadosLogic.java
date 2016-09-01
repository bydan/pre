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
import com.bydan.erp.tesoreria.util.report.PagosAutorizadosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.PagosAutorizadosParameterGeneral;
import com.bydan.erp.tesoreria.util.report.PagosAutorizadosConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.PagosAutorizados;

import com.bydan.erp.tesoreria.business.logic.report.PagosAutorizadosLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class PagosAutorizadosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(PagosAutorizadosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected PagosAutorizadosLogic pagosautorizadosDataAccess; 		
	protected PagosAutorizados pagosautorizados;
	protected List<PagosAutorizados> pagosautorizadoss;
	protected Object pagosautorizadosObject;	
	protected List<Object> pagosautorizadossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  PagosAutorizadosLogic()throws SQLException,Exception {
		try	{
			this.pagosautorizadoss= new ArrayList<PagosAutorizados>();
			this.pagosautorizados= new PagosAutorizados();
			this.pagosautorizadosObject=new Object();
			this.pagosautorizadossObject=new ArrayList<Object>();
			
			this.pagosautorizadosDataAccess=this;
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
			this.pagosautorizadosDataAccess.setConnexionType(this.connexionType);
			this.pagosautorizadosDataAccess.setParameterDbType(this.parameterDbType);
			this.pagosautorizadosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PagosAutorizadosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.pagosautorizadoss= new ArrayList<PagosAutorizados>();
			this.pagosautorizados= new PagosAutorizados();
			this.pagosautorizadosObject=new Object();
			this.pagosautorizadossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.pagosautorizadosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.pagosautorizadosDataAccess.setConnexionType(this.connexionType);
			this.pagosautorizadosDataAccess.setParameterDbType(this.parameterDbType);
			this.pagosautorizadosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PagosAutorizados getPagosAutorizados() throws Exception {	
		PagosAutorizadosLogicAdditional.checkPagosAutorizadosToGet(pagosautorizados,this.datosCliente,this.arrDatoGeneral);
		PagosAutorizadosLogicAdditional.updatePagosAutorizadosToGet(pagosautorizados,this.arrDatoGeneral);
		
		return pagosautorizados;
	}
		
	public void setPagosAutorizados(PagosAutorizados newPagosAutorizados) {
		this.pagosautorizados = newPagosAutorizados;
	}
	
	public List<PagosAutorizados> getPagosAutorizadoss() throws Exception {		
		this.quitarPagosAutorizadossNulos();
		
		PagosAutorizadosLogicAdditional.checkPagosAutorizadosToGets(pagosautorizadoss,this.datosCliente,this.arrDatoGeneral);
		
		for (PagosAutorizados pagosautorizadosLocal: pagosautorizadoss ) {
			PagosAutorizadosLogicAdditional.updatePagosAutorizadosToGet(pagosautorizadosLocal,this.arrDatoGeneral);
		}
		
		return pagosautorizadoss;
	}
	
	public void setPagosAutorizadoss(List<PagosAutorizados> newPagosAutorizadoss) {
		this.pagosautorizadoss = newPagosAutorizadoss;
	}
	
	public Object getPagosAutorizadosObject() {	
		//this.pagosautorizadosObject=this.pagosautorizadosDataAccess.getEntityObject();
		return this.pagosautorizadosObject;
	}
		
	public void setPagosAutorizadosObject(Object newPagosAutorizadosObject) {
		this.pagosautorizadosObject = newPagosAutorizadosObject;
	}
	
	public List<Object> getPagosAutorizadossObject() {		
		//this.pagosautorizadossObject=this.pagosautorizadosDataAccess.getEntitiesObject();
		return this.pagosautorizadossObject;
	}
		
	public void setPagosAutorizadossObject(List<Object> newPagosAutorizadossObject) {
		this.pagosautorizadossObject = newPagosAutorizadossObject;
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
		pagosautorizadoss = new  ArrayList<PagosAutorizados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		pagosautorizadoss = new  ArrayList<PagosAutorizados>();
		  		  
        try {
			//PagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pagosautorizadoss = new  ArrayList<PagosAutorizados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		pagosautorizadoss = new  ArrayList<PagosAutorizados>();
		  		  
        try {
			//PagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		pagosautorizadoss = new  ArrayList<PagosAutorizados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		pagosautorizadoss = new  ArrayList<PagosAutorizados>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//PagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<PagosAutorizados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosAutorizados> entities = new  ArrayList<PagosAutorizados>();
		PagosAutorizados entity = new PagosAutorizados();		  
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
	
	public  List<PagosAutorizados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosAutorizados> entities = new  ArrayList<PagosAutorizados>();
		PagosAutorizados entity = new PagosAutorizados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagosAutorizados();
				
				
      	    	entity=PagosAutorizadosLogic.getEntityPagosAutorizados("",entity,resultSet);
      	    	
				//entity.setPagosAutorizadosOriginal( new PagosAutorizados());
      	    	//entity.setPagosAutorizadosOriginal(super.getEntity("",entity.getPagosAutorizadosOriginal(),resultSet,PagosAutorizadosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPagosAutorizadosOriginal(PagosAutorizadosDataAccess.getEntityPagosAutorizados("",entity.getPagosAutorizadosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<PagosAutorizados> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosAutorizados> entities = new  ArrayList<PagosAutorizados>();
		PagosAutorizados entity = new PagosAutorizados();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,PagosAutorizados.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PagosAutorizados>((List<PagosAutorizados>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPagosAutorizadossOriginal(entities);
			
			}  else {
				this.pagosautorizadossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PagosAutorizadosConstantesFunciones.quitarEspaciosPagosAutorizadoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static PagosAutorizados getEntityPagosAutorizados(String strPrefijo,PagosAutorizados entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_cliente(resultSet.getString(strPrefijo+PagosAutorizadosConstantesFunciones.NOMBRECLIENTE));
			entity.setnumero_factura(resultSet.getString(strPrefijo+PagosAutorizadosConstantesFunciones.NUMEROFACTURA));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PagosAutorizadosConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+PagosAutorizadosConstantesFunciones.FECHAVENCIMIENTO).getTime()));
			entity.setnombre_banco(resultSet.getString(strPrefijo+PagosAutorizadosConstantesFunciones.NOMBREBANCO));
			entity.setvalor_por_pagar(resultSet.getDouble(strPrefijo+PagosAutorizadosConstantesFunciones.VALORPORPAGAR));
			entity.setvalor_cancelado(resultSet.getDouble(strPrefijo+PagosAutorizadosConstantesFunciones.VALORCANCELADO));
			entity.setnumero_cuenta(resultSet.getString(strPrefijo+PagosAutorizadosConstantesFunciones.NUMEROCUENTA));
			entity.setesta_autorizado(resultSet.getBoolean(strPrefijo+PagosAutorizadosConstantesFunciones.ESTAAUTORIZADO));
			entity.setdescripcion(resultSet.getString(strPrefijo+PagosAutorizadosConstantesFunciones.DESCRIPCION));
			entity.setfecha_corte_dato(new Date(resultSet.getDate(strPrefijo+PagosAutorizadosConstantesFunciones.FECHACORTE).getTime()));
			entity.setestado(resultSet.getString(strPrefijo+PagosAutorizadosConstantesFunciones.ESTADO));
			entity.setcodigo_cuenta_con_cliente(resultSet.getString(strPrefijo+PagosAutorizadosConstantesFunciones.CODIGOCUENTACONCLIENTE));
			entity.setcodigo_cuenta_con_banco(resultSet.getString(strPrefijo+PagosAutorizadosConstantesFunciones.CODIGOCUENTACONBANCO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PagosAutorizados getEntityPagosAutorizados(String strPrefijo,PagosAutorizados entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = PagosAutorizados.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = PagosAutorizados.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				PagosAutorizadosLogic.setFieldReflectionPagosAutorizados(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPagosAutorizados(Field field,String strPrefijo,String sColumn,PagosAutorizados entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PagosAutorizadosConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PagosAutorizadosConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PagosAutorizadosConstantesFunciones.NOMBREBANCO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.VALORPORPAGAR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.VALORCANCELADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.ESTAAUTORIZADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.FECHACORTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PagosAutorizadosConstantesFunciones.ESTADO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.CODIGOCUENTACONCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosAutorizadosConstantesFunciones.CODIGOCUENTACONBANCO:
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
	
	public void quitarPagosAutorizadossNulos() throws Exception {				
		
		List<PagosAutorizados> pagosautorizadossAux= new ArrayList<PagosAutorizados>();
		
		for(PagosAutorizados pagosautorizados:pagosautorizadoss) {
			if(pagosautorizados!=null) {
				pagosautorizadossAux.add(pagosautorizados);
			}
		}
		
		pagosautorizadoss=pagosautorizadossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<PagosAutorizados> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosAutorizados> entities = new  ArrayList<PagosAutorizados>();
		PagosAutorizados entity = new PagosAutorizados();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PagosAutorizados>((List<PagosAutorizados>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPagosAutorizadossOriginal(entities);
			
			}  else {
				this.pagosautorizadossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PagosAutorizadosConstantesFunciones.quitarEspaciosPagosAutorizadoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		pagosautorizadoss = new  ArrayList<PagosAutorizados>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		pagosautorizadoss = new  ArrayList<PagosAutorizados>();
		  		  
        try {
			//PagosAutorizadosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagosautorizadoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<PagosAutorizados> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PagosAutorizados> entities = new  ArrayList<PagosAutorizados>();
		PagosAutorizados entity = new PagosAutorizados();		  
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
	
	public  List<PagosAutorizados> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PagosAutorizados> entities = new  ArrayList<PagosAutorizados>();
		PagosAutorizados entity = new PagosAutorizados();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagosAutorizados();
				
				if(conMapGenerico) {
					entity.setMapPagosAutorizados( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapPagosAutorizados().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PagosAutorizadosDataAccess.ISWITHSCHEMA);         		
					entity=PagosAutorizadosLogic.getEntityPagosAutorizados("",entity,resultSet,listColumns);
					
					////entity.setPagosAutorizadosOriginal( new PagosAutorizados());
					////entity.setPagosAutorizadosOriginal(super.getEntity("",entity.getPagosAutorizadosOriginal(),resultSet,PagosAutorizadosDataAccess.ISWITHSCHEMA));         		
					////entity.setPagosAutorizadosOriginal(PagosAutorizadosDataAccess.getEntityPagosAutorizados("",entity.getPagosAutorizadosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,PagosAutorizados relpagosautorizados)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relpagosautorizados.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getPagosAutorizadossBusquedaPagosAutorizadosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_corte)throws Exception {
		try {
			//PagosAutorizadosLogic pagosautorizadosLogic=new PagosAutorizadosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PagosAutorizadosLogic.GetSelecSqlPagosAutorizados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_corte);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.pagosautorizadoss=this.getPagosAutorizadoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getPagosAutorizadossBusquedaPagosAutorizados(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_corte)throws Exception {
		try {
			//PagosAutorizadosLogic pagosautorizadosLogic=new PagosAutorizadosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PagosAutorizadosLogic.GetSelecSqlPagosAutorizados(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_corte);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.pagosautorizadoss=this.getPagosAutorizadoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlPagosAutorizados(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_corte)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("PagosAutorizados_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" p.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" p.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(fecha_corte!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.fecha_corte = "+"'"+Funciones2.getStringPostgresDate(fecha_corte)+"'";
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
	
	
	public void deepLoad(PagosAutorizados pagosautorizados,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PagosAutorizadosLogicAdditional.updatePagosAutorizadosToGet(pagosautorizados,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pagosautorizados.setEmpresa(pagosautorizadosDataAccess.getEmpresa(connexion,pagosautorizados));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pagosautorizados.setEmpresa(pagosautorizadosDataAccess.getEmpresa(connexion,pagosautorizados));
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
			pagosautorizados.setEmpresa(pagosautorizadosDataAccess.getEmpresa(connexion,pagosautorizados));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pagosautorizados.setEmpresa(pagosautorizadosDataAccess.getEmpresa(connexion,pagosautorizados));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pagosautorizados.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pagosautorizados.setEmpresa(pagosautorizadosDataAccess.getEmpresa(connexion,pagosautorizados));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pagosautorizados.getEmpresa(),isDeep,deepLoadType,clases);				
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
			pagosautorizados.setEmpresa(pagosautorizadosDataAccess.getEmpresa(connexion,pagosautorizados));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pagosautorizados.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(pagosautorizados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PagosAutorizadosConstantesFunciones.refrescarForeignKeysDescripcionesPagosAutorizados(pagosautorizados);
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
			this.deepLoad(this.pagosautorizados,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PagosAutorizadosConstantesFunciones.refrescarForeignKeysDescripcionesPagosAutorizados(this.pagosautorizados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(pagosautorizadoss!=null) {
				for(PagosAutorizados pagosautorizados:pagosautorizadoss) {
					this.deepLoad(pagosautorizados,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PagosAutorizadosConstantesFunciones.refrescarForeignKeysDescripcionesPagosAutorizados(pagosautorizadoss);
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
			if(pagosautorizadoss!=null) {
				for(PagosAutorizados pagosautorizados:pagosautorizadoss) {
					this.deepLoad(pagosautorizados,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PagosAutorizadosConstantesFunciones.refrescarForeignKeysDescripcionesPagosAutorizados(pagosautorizadoss);
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
	
	public PagosAutorizadosParameterReturnGeneral procesarAccionPagosAutorizadoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PagosAutorizados> pagosautorizadoss,PagosAutorizadosParameterReturnGeneral pagosautorizadosParameterGeneral)throws Exception {
		 try {	
			PagosAutorizadosParameterReturnGeneral pagosautorizadosReturnGeneral=new PagosAutorizadosParameterReturnGeneral();
	
			PagosAutorizadosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pagosautorizadoss,pagosautorizadosParameterGeneral,pagosautorizadosReturnGeneral);
			
			return pagosautorizadosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PagosAutorizadosParameterReturnGeneral procesarAccionPagosAutorizadossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PagosAutorizados> pagosautorizadoss,PagosAutorizadosParameterReturnGeneral pagosautorizadosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			PagosAutorizadosParameterReturnGeneral pagosautorizadosReturnGeneral=new PagosAutorizadosParameterReturnGeneral();
	
			PagosAutorizadosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pagosautorizadoss,pagosautorizadosParameterGeneral,pagosautorizadosReturnGeneral);
			
			this.connexion.commit();
			
			return pagosautorizadosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

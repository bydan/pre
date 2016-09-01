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
import com.bydan.erp.nomina.util.report.ListadosFormasPagosParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ListadosFormasPagosParameterGeneral;
import com.bydan.erp.nomina.util.report.ListadosFormasPagosConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ListadosFormasPagos;

import com.bydan.erp.nomina.business.logic.report.ListadosFormasPagosLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ListadosFormasPagosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ListadosFormasPagosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ListadosFormasPagosLogic listadosformaspagosDataAccess; 		
	protected ListadosFormasPagos listadosformaspagos;
	protected List<ListadosFormasPagos> listadosformaspagoss;
	protected Object listadosformaspagosObject;	
	protected List<Object> listadosformaspagossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ListadosFormasPagosLogic()throws SQLException,Exception {
		try	{
			this.listadosformaspagoss= new ArrayList<ListadosFormasPagos>();
			this.listadosformaspagos= new ListadosFormasPagos();
			this.listadosformaspagosObject=new Object();
			this.listadosformaspagossObject=new ArrayList<Object>();
			
			this.listadosformaspagosDataAccess=this;
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
			this.listadosformaspagosDataAccess.setConnexionType(this.connexionType);
			this.listadosformaspagosDataAccess.setParameterDbType(this.parameterDbType);
			this.listadosformaspagosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ListadosFormasPagosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.listadosformaspagoss= new ArrayList<ListadosFormasPagos>();
			this.listadosformaspagos= new ListadosFormasPagos();
			this.listadosformaspagosObject=new Object();
			this.listadosformaspagossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.listadosformaspagosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.listadosformaspagosDataAccess.setConnexionType(this.connexionType);
			this.listadosformaspagosDataAccess.setParameterDbType(this.parameterDbType);
			this.listadosformaspagosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ListadosFormasPagos getListadosFormasPagos() throws Exception {	
		ListadosFormasPagosLogicAdditional.checkListadosFormasPagosToGet(listadosformaspagos,this.datosCliente,this.arrDatoGeneral);
		ListadosFormasPagosLogicAdditional.updateListadosFormasPagosToGet(listadosformaspagos,this.arrDatoGeneral);
		
		return listadosformaspagos;
	}
		
	public void setListadosFormasPagos(ListadosFormasPagos newListadosFormasPagos) {
		this.listadosformaspagos = newListadosFormasPagos;
	}
	
	public List<ListadosFormasPagos> getListadosFormasPagoss() throws Exception {		
		this.quitarListadosFormasPagossNulos();
		
		ListadosFormasPagosLogicAdditional.checkListadosFormasPagosToGets(listadosformaspagoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ListadosFormasPagos listadosformaspagosLocal: listadosformaspagoss ) {
			ListadosFormasPagosLogicAdditional.updateListadosFormasPagosToGet(listadosformaspagosLocal,this.arrDatoGeneral);
		}
		
		return listadosformaspagoss;
	}
	
	public void setListadosFormasPagoss(List<ListadosFormasPagos> newListadosFormasPagoss) {
		this.listadosformaspagoss = newListadosFormasPagoss;
	}
	
	public Object getListadosFormasPagosObject() {	
		//this.listadosformaspagosObject=this.listadosformaspagosDataAccess.getEntityObject();
		return this.listadosformaspagosObject;
	}
		
	public void setListadosFormasPagosObject(Object newListadosFormasPagosObject) {
		this.listadosformaspagosObject = newListadosFormasPagosObject;
	}
	
	public List<Object> getListadosFormasPagossObject() {		
		//this.listadosformaspagossObject=this.listadosformaspagosDataAccess.getEntitiesObject();
		return this.listadosformaspagossObject;
	}
		
	public void setListadosFormasPagossObject(List<Object> newListadosFormasPagossObject) {
		this.listadosformaspagossObject = newListadosFormasPagossObject;
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
		listadosformaspagoss = new  ArrayList<ListadosFormasPagos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ListadosFormasPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadosformaspagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		listadosformaspagoss = new  ArrayList<ListadosFormasPagos>();
		  		  
        try {
			//ListadosFormasPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadosformaspagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		listadosformaspagoss = new  ArrayList<ListadosFormasPagos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ListadosFormasPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadosformaspagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		listadosformaspagoss = new  ArrayList<ListadosFormasPagos>();
		  		  
        try {
			//ListadosFormasPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadosformaspagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		listadosformaspagoss = new  ArrayList<ListadosFormasPagos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ListadosFormasPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadosformaspagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		listadosformaspagoss = new  ArrayList<ListadosFormasPagos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ListadosFormasPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadosformaspagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ListadosFormasPagos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ListadosFormasPagos> entities = new  ArrayList<ListadosFormasPagos>();
		ListadosFormasPagos entity = new ListadosFormasPagos();		  
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
	
	public  List<ListadosFormasPagos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ListadosFormasPagos> entities = new  ArrayList<ListadosFormasPagos>();
		ListadosFormasPagos entity = new ListadosFormasPagos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ListadosFormasPagos();
				
				
      	    	entity=ListadosFormasPagosLogic.getEntityListadosFormasPagos("",entity,resultSet);
      	    	
				//entity.setListadosFormasPagosOriginal( new ListadosFormasPagos());
      	    	//entity.setListadosFormasPagosOriginal(super.getEntity("",entity.getListadosFormasPagosOriginal(),resultSet,ListadosFormasPagosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setListadosFormasPagosOriginal(ListadosFormasPagosDataAccess.getEntityListadosFormasPagos("",entity.getListadosFormasPagosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ListadosFormasPagos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ListadosFormasPagos> entities = new  ArrayList<ListadosFormasPagos>();
		ListadosFormasPagos entity = new ListadosFormasPagos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ListadosFormasPagos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ListadosFormasPagos>((List<ListadosFormasPagos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setListadosFormasPagossOriginal(entities);
			
			}  else {
				this.listadosformaspagossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ListadosFormasPagosConstantesFunciones.quitarEspaciosListadosFormasPagoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ListadosFormasPagos getEntityListadosFormasPagos(String strPrefijo,ListadosFormasPagos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ListadosFormasPagosConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+ListadosFormasPagosConstantesFunciones.NOMBRECOMPLETO));
			entity.setcodigo_tipo_cuenta_banco_global(resultSet.getString(strPrefijo+ListadosFormasPagosConstantesFunciones.CODIGOTIPOCUENTABANCOGLOBAL));
			entity.setnumero_cuenta(resultSet.getString(strPrefijo+ListadosFormasPagosConstantesFunciones.NUMEROCUENTA));
			entity.setcodigo_estado_anti_cliente(resultSet.getString(strPrefijo+ListadosFormasPagosConstantesFunciones.CODIGOESTADOANTICLIENTE));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ListadosFormasPagosConstantesFunciones.FECHA).getTime()));
			entity.setvalor(resultSet.getDouble(strPrefijo+ListadosFormasPagosConstantesFunciones.VALOR));
			entity.setvalor_adicional(resultSet.getDouble(strPrefijo+ListadosFormasPagosConstantesFunciones.VALORADICIONAL));
			entity.setnombre_tipo_grupo_forma_pago(resultSet.getString(strPrefijo+ListadosFormasPagosConstantesFunciones.NOMBRETIPOGRUPOFORMAPAGO));
			entity.settotal(resultSet.getDouble(strPrefijo+ListadosFormasPagosConstantesFunciones.TOTAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ListadosFormasPagos getEntityListadosFormasPagos(String strPrefijo,ListadosFormasPagos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ListadosFormasPagos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ListadosFormasPagos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ListadosFormasPagosLogic.setFieldReflectionListadosFormasPagos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionListadosFormasPagos(Field field,String strPrefijo,String sColumn,ListadosFormasPagos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ListadosFormasPagosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadosFormasPagosConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadosFormasPagosConstantesFunciones.CODIGOTIPOCUENTABANCOGLOBAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadosFormasPagosConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadosFormasPagosConstantesFunciones.CODIGOESTADOANTICLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadosFormasPagosConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ListadosFormasPagosConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ListadosFormasPagosConstantesFunciones.VALORADICIONAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ListadosFormasPagosConstantesFunciones.NOMBRETIPOGRUPOFORMAPAGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ListadosFormasPagosConstantesFunciones.TOTAL:
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
	
	public void quitarListadosFormasPagossNulos() throws Exception {				
		
		List<ListadosFormasPagos> listadosformaspagossAux= new ArrayList<ListadosFormasPagos>();
		
		for(ListadosFormasPagos listadosformaspagos:listadosformaspagoss) {
			if(listadosformaspagos!=null) {
				listadosformaspagossAux.add(listadosformaspagos);
			}
		}
		
		listadosformaspagoss=listadosformaspagossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ListadosFormasPagos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ListadosFormasPagos> entities = new  ArrayList<ListadosFormasPagos>();
		ListadosFormasPagos entity = new ListadosFormasPagos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ListadosFormasPagos>((List<ListadosFormasPagos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setListadosFormasPagossOriginal(entities);
			
			}  else {
				this.listadosformaspagossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ListadosFormasPagosConstantesFunciones.quitarEspaciosListadosFormasPagoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		listadosformaspagoss = new  ArrayList<ListadosFormasPagos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ListadosFormasPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadosformaspagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		listadosformaspagoss = new  ArrayList<ListadosFormasPagos>();
		  		  
        try {
			//ListadosFormasPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			listadosformaspagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ListadosFormasPagos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ListadosFormasPagos> entities = new  ArrayList<ListadosFormasPagos>();
		ListadosFormasPagos entity = new ListadosFormasPagos();		  
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
	
	public  List<ListadosFormasPagos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ListadosFormasPagos> entities = new  ArrayList<ListadosFormasPagos>();
		ListadosFormasPagos entity = new ListadosFormasPagos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ListadosFormasPagos();
				
				if(conMapGenerico) {
					entity.setMapListadosFormasPagos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapListadosFormasPagos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ListadosFormasPagosDataAccess.ISWITHSCHEMA);         		
					entity=ListadosFormasPagosLogic.getEntityListadosFormasPagos("",entity,resultSet,listColumns);
					
					////entity.setListadosFormasPagosOriginal( new ListadosFormasPagos());
					////entity.setListadosFormasPagosOriginal(super.getEntity("",entity.getListadosFormasPagosOriginal(),resultSet,ListadosFormasPagosDataAccess.ISWITHSCHEMA));         		
					////entity.setListadosFormasPagosOriginal(ListadosFormasPagosDataAccess.getEntityListadosFormasPagos("",entity.getListadosFormasPagosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public TipoGrupoFormaPago getTipoGrupoFormaPago(Connexion connexion,ListadosFormasPagos rellistadosformaspagos)throws SQLException,Exception {

		TipoGrupoFormaPago tipogrupoformapago= new TipoGrupoFormaPago();

		try {
			TipoGrupoFormaPagoDataAccess tipogrupoformapagoDataAccess=new TipoGrupoFormaPagoDataAccess();

			tipogrupoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogrupoformapagoDataAccess.setConnexionType(this.connexionType);
			tipogrupoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			tipogrupoformapagoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion,rellistadosformaspagos.getid_tipo_grupo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogrupoformapago;

	}

	public Empresa getEmpresa(Connexion connexion,ListadosFormasPagos rellistadosformaspagos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,rellistadosformaspagos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ListadosFormasPagos rellistadosformaspagos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,rellistadosformaspagos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}


	
	
	public void getListadosFormasPagossBusquedaListadosFormasPagosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_grupo_forma_pago,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//ListadosFormasPagosLogic listadosformaspagosLogic=new ListadosFormasPagosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ListadosFormasPagosLogic.GetSelecSqlListadosFormasPagos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_grupo_forma_pago,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.listadosformaspagoss=this.getListadosFormasPagoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getListadosFormasPagossBusquedaListadosFormasPagos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_grupo_forma_pago,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//ListadosFormasPagosLogic listadosformaspagosLogic=new ListadosFormasPagosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ListadosFormasPagosLogic.GetSelecSqlListadosFormasPagos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_tipo_grupo_forma_pago,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.listadosformaspagoss=this.getListadosFormasPagoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlListadosFormasPagos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_grupo_forma_pago,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ListadosFormasPagos_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" e.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_tipo_grupo_forma_pago!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_tipo_grupo_forma_pago = "+id_tipo_grupo_forma_pago.toString();
					existeWhere=true;
				}

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
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
	
	
	public void deepLoad(ListadosFormasPagos listadosformaspagos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ListadosFormasPagosLogicAdditional.updateListadosFormasPagosToGet(listadosformaspagos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		listadosformaspagos.setTipoGrupoFormaPago(listadosformaspagosDataAccess.getTipoGrupoFormaPago(connexion,listadosformaspagos));
		listadosformaspagos.setEmpresa(listadosformaspagosDataAccess.getEmpresa(connexion,listadosformaspagos));
		listadosformaspagos.setSucursal(listadosformaspagosDataAccess.getSucursal(connexion,listadosformaspagos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				listadosformaspagos.setTipoGrupoFormaPago(listadosformaspagosDataAccess.getTipoGrupoFormaPago(connexion,listadosformaspagos));
			}

			if(clas.clas.equals(Empresa.class)) {
				listadosformaspagos.setEmpresa(listadosformaspagosDataAccess.getEmpresa(connexion,listadosformaspagos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				listadosformaspagos.setSucursal(listadosformaspagosDataAccess.getSucursal(connexion,listadosformaspagos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			listadosformaspagos.setTipoGrupoFormaPago(listadosformaspagosDataAccess.getTipoGrupoFormaPago(connexion,listadosformaspagos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			listadosformaspagos.setEmpresa(listadosformaspagosDataAccess.getEmpresa(connexion,listadosformaspagos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			listadosformaspagos.setSucursal(listadosformaspagosDataAccess.getSucursal(connexion,listadosformaspagos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		listadosformaspagos.setTipoGrupoFormaPago(listadosformaspagosDataAccess.getTipoGrupoFormaPago(connexion,listadosformaspagos));
		TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
		tipogrupoformapagoLogic.deepLoad(listadosformaspagos.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				
		listadosformaspagos.setEmpresa(listadosformaspagosDataAccess.getEmpresa(connexion,listadosformaspagos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(listadosformaspagos.getEmpresa(),isDeep,deepLoadType,clases);
				
		listadosformaspagos.setSucursal(listadosformaspagosDataAccess.getSucursal(connexion,listadosformaspagos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(listadosformaspagos.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				listadosformaspagos.setTipoGrupoFormaPago(listadosformaspagosDataAccess.getTipoGrupoFormaPago(connexion,listadosformaspagos));
				TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
				tipogrupoformapagoLogic.deepLoad(listadosformaspagos.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				listadosformaspagos.setEmpresa(listadosformaspagosDataAccess.getEmpresa(connexion,listadosformaspagos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(listadosformaspagos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				listadosformaspagos.setSucursal(listadosformaspagosDataAccess.getSucursal(connexion,listadosformaspagos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(listadosformaspagos.getSucursal(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			listadosformaspagos.setTipoGrupoFormaPago(listadosformaspagosDataAccess.getTipoGrupoFormaPago(connexion,listadosformaspagos));
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
			tipogrupoformapagoLogic.deepLoad(listadosformaspagos.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			listadosformaspagos.setEmpresa(listadosformaspagosDataAccess.getEmpresa(connexion,listadosformaspagos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(listadosformaspagos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			listadosformaspagos.setSucursal(listadosformaspagosDataAccess.getSucursal(connexion,listadosformaspagos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(listadosformaspagos.getSucursal(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(listadosformaspagos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ListadosFormasPagosConstantesFunciones.refrescarForeignKeysDescripcionesListadosFormasPagos(listadosformaspagos);
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
			this.deepLoad(this.listadosformaspagos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ListadosFormasPagosConstantesFunciones.refrescarForeignKeysDescripcionesListadosFormasPagos(this.listadosformaspagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(listadosformaspagoss!=null) {
				for(ListadosFormasPagos listadosformaspagos:listadosformaspagoss) {
					this.deepLoad(listadosformaspagos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ListadosFormasPagosConstantesFunciones.refrescarForeignKeysDescripcionesListadosFormasPagos(listadosformaspagoss);
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
			if(listadosformaspagoss!=null) {
				for(ListadosFormasPagos listadosformaspagos:listadosformaspagoss) {
					this.deepLoad(listadosformaspagos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ListadosFormasPagosConstantesFunciones.refrescarForeignKeysDescripcionesListadosFormasPagos(listadosformaspagoss);
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
	
	public ListadosFormasPagosParameterReturnGeneral procesarAccionListadosFormasPagoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ListadosFormasPagos> listadosformaspagoss,ListadosFormasPagosParameterReturnGeneral listadosformaspagosParameterGeneral)throws Exception {
		 try {	
			ListadosFormasPagosParameterReturnGeneral listadosformaspagosReturnGeneral=new ListadosFormasPagosParameterReturnGeneral();
	
			ListadosFormasPagosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,listadosformaspagoss,listadosformaspagosParameterGeneral,listadosformaspagosReturnGeneral);
			
			return listadosformaspagosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ListadosFormasPagosParameterReturnGeneral procesarAccionListadosFormasPagossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ListadosFormasPagos> listadosformaspagoss,ListadosFormasPagosParameterReturnGeneral listadosformaspagosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ListadosFormasPagosParameterReturnGeneral listadosformaspagosReturnGeneral=new ListadosFormasPagosParameterReturnGeneral();
	
			ListadosFormasPagosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,listadosformaspagoss,listadosformaspagosParameterGeneral,listadosformaspagosReturnGeneral);
			
			this.connexion.commit();
			
			return listadosformaspagosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

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
import com.bydan.erp.cartera.util.report.PlaneacionPagosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.PlaneacionPagosParameterGeneral;
import com.bydan.erp.cartera.util.report.PlaneacionPagosConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.PlaneacionPagos;

import com.bydan.erp.cartera.business.logic.report.PlaneacionPagosLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;






@SuppressWarnings("unused")
public class PlaneacionPagosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(PlaneacionPagosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected PlaneacionPagosLogic planeacionpagosDataAccess; 		
	protected PlaneacionPagos planeacionpagos;
	protected List<PlaneacionPagos> planeacionpagoss;
	protected Object planeacionpagosObject;	
	protected List<Object> planeacionpagossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  PlaneacionPagosLogic()throws SQLException,Exception {
		try	{
			this.planeacionpagoss= new ArrayList<PlaneacionPagos>();
			this.planeacionpagos= new PlaneacionPagos();
			this.planeacionpagosObject=new Object();
			this.planeacionpagossObject=new ArrayList<Object>();
			
			this.planeacionpagosDataAccess=this;
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
			this.planeacionpagosDataAccess.setConnexionType(this.connexionType);
			this.planeacionpagosDataAccess.setParameterDbType(this.parameterDbType);
			this.planeacionpagosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PlaneacionPagosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.planeacionpagoss= new ArrayList<PlaneacionPagos>();
			this.planeacionpagos= new PlaneacionPagos();
			this.planeacionpagosObject=new Object();
			this.planeacionpagossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.planeacionpagosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.planeacionpagosDataAccess.setConnexionType(this.connexionType);
			this.planeacionpagosDataAccess.setParameterDbType(this.parameterDbType);
			this.planeacionpagosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PlaneacionPagos getPlaneacionPagos() throws Exception {	
		PlaneacionPagosLogicAdditional.checkPlaneacionPagosToGet(planeacionpagos,this.datosCliente,this.arrDatoGeneral);
		PlaneacionPagosLogicAdditional.updatePlaneacionPagosToGet(planeacionpagos,this.arrDatoGeneral);
		
		return planeacionpagos;
	}
		
	public void setPlaneacionPagos(PlaneacionPagos newPlaneacionPagos) {
		this.planeacionpagos = newPlaneacionPagos;
	}
	
	public List<PlaneacionPagos> getPlaneacionPagoss() throws Exception {		
		this.quitarPlaneacionPagossNulos();
		
		PlaneacionPagosLogicAdditional.checkPlaneacionPagosToGets(planeacionpagoss,this.datosCliente,this.arrDatoGeneral);
		
		for (PlaneacionPagos planeacionpagosLocal: planeacionpagoss ) {
			PlaneacionPagosLogicAdditional.updatePlaneacionPagosToGet(planeacionpagosLocal,this.arrDatoGeneral);
		}
		
		return planeacionpagoss;
	}
	
	public void setPlaneacionPagoss(List<PlaneacionPagos> newPlaneacionPagoss) {
		this.planeacionpagoss = newPlaneacionPagoss;
	}
	
	public Object getPlaneacionPagosObject() {	
		//this.planeacionpagosObject=this.planeacionpagosDataAccess.getEntityObject();
		return this.planeacionpagosObject;
	}
		
	public void setPlaneacionPagosObject(Object newPlaneacionPagosObject) {
		this.planeacionpagosObject = newPlaneacionPagosObject;
	}
	
	public List<Object> getPlaneacionPagossObject() {		
		//this.planeacionpagossObject=this.planeacionpagosDataAccess.getEntitiesObject();
		return this.planeacionpagossObject;
	}
		
	public void setPlaneacionPagossObject(List<Object> newPlaneacionPagossObject) {
		this.planeacionpagossObject = newPlaneacionPagossObject;
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
		planeacionpagoss = new  ArrayList<PlaneacionPagos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PlaneacionPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacionpagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		planeacionpagoss = new  ArrayList<PlaneacionPagos>();
		  		  
        try {
			//PlaneacionPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacionpagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		planeacionpagoss = new  ArrayList<PlaneacionPagos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PlaneacionPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacionpagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		planeacionpagoss = new  ArrayList<PlaneacionPagos>();
		  		  
        try {
			//PlaneacionPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacionpagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		planeacionpagoss = new  ArrayList<PlaneacionPagos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PlaneacionPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacionpagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		planeacionpagoss = new  ArrayList<PlaneacionPagos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//PlaneacionPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacionpagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<PlaneacionPagos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaneacionPagos> entities = new  ArrayList<PlaneacionPagos>();
		PlaneacionPagos entity = new PlaneacionPagos();		  
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
	
	public  List<PlaneacionPagos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaneacionPagos> entities = new  ArrayList<PlaneacionPagos>();
		PlaneacionPagos entity = new PlaneacionPagos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaneacionPagos();
				
				
      	    	entity=PlaneacionPagosLogic.getEntityPlaneacionPagos("",entity,resultSet);
      	    	
				//entity.setPlaneacionPagosOriginal( new PlaneacionPagos());
      	    	//entity.setPlaneacionPagosOriginal(super.getEntity("",entity.getPlaneacionPagosOriginal(),resultSet,PlaneacionPagosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaneacionPagosOriginal(PlaneacionPagosDataAccess.getEntityPlaneacionPagos("",entity.getPlaneacionPagosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<PlaneacionPagos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaneacionPagos> entities = new  ArrayList<PlaneacionPagos>();
		PlaneacionPagos entity = new PlaneacionPagos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,PlaneacionPagos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PlaneacionPagos>((List<PlaneacionPagos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPlaneacionPagossOriginal(entities);
			
			}  else {
				this.planeacionpagossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PlaneacionPagosConstantesFunciones.quitarEspaciosPlaneacionPagoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static PlaneacionPagos getEntityPlaneacionPagos(String strPrefijo,PlaneacionPagos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_factura(resultSet.getLong(strPrefijo+PlaneacionPagosConstantesFunciones.IDFACTURA));
			entity.setid_cliente(resultSet.getLong(strPrefijo+PlaneacionPagosConstantesFunciones.IDCLIENTE));
			entity.setnombre_cliente(resultSet.getString(strPrefijo+PlaneacionPagosConstantesFunciones.NOMBRECLIENTE));
			entity.setnumero_factura(resultSet.getString(strPrefijo+PlaneacionPagosConstantesFunciones.NUMEROFACTURA));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PlaneacionPagosConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_venta(new Date(resultSet.getDate(strPrefijo+PlaneacionPagosConstantesFunciones.FECHAVENTA).getTime()));
			entity.setfecha_pago(new Date(resultSet.getDate(strPrefijo+PlaneacionPagosConstantesFunciones.FECHAPAGO).getTime()));
			entity.setsaldo(resultSet.getDouble(strPrefijo+PlaneacionPagosConstantesFunciones.SALDO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PlaneacionPagos getEntityPlaneacionPagos(String strPrefijo,PlaneacionPagos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = PlaneacionPagos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = PlaneacionPagos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				PlaneacionPagosLogic.setFieldReflectionPlaneacionPagos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPlaneacionPagos(Field field,String strPrefijo,String sColumn,PlaneacionPagos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PlaneacionPagosConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionPagosConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaneacionPagosConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlaneacionPagosConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlaneacionPagosConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PlaneacionPagosConstantesFunciones.FECHAVENTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PlaneacionPagosConstantesFunciones.FECHAPAGO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PlaneacionPagosConstantesFunciones.SALDO:
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
	
	public void quitarPlaneacionPagossNulos() throws Exception {				
		
		List<PlaneacionPagos> planeacionpagossAux= new ArrayList<PlaneacionPagos>();
		
		for(PlaneacionPagos planeacionpagos:planeacionpagoss) {
			if(planeacionpagos!=null) {
				planeacionpagossAux.add(planeacionpagos);
			}
		}
		
		planeacionpagoss=planeacionpagossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<PlaneacionPagos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaneacionPagos> entities = new  ArrayList<PlaneacionPagos>();
		PlaneacionPagos entity = new PlaneacionPagos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PlaneacionPagos>((List<PlaneacionPagos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPlaneacionPagossOriginal(entities);
			
			}  else {
				this.planeacionpagossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PlaneacionPagosConstantesFunciones.quitarEspaciosPlaneacionPagoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		planeacionpagoss = new  ArrayList<PlaneacionPagos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PlaneacionPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacionpagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		planeacionpagoss = new  ArrayList<PlaneacionPagos>();
		  		  
        try {
			//PlaneacionPagosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planeacionpagoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<PlaneacionPagos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlaneacionPagos> entities = new  ArrayList<PlaneacionPagos>();
		PlaneacionPagos entity = new PlaneacionPagos();		  
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
	
	public  List<PlaneacionPagos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlaneacionPagos> entities = new  ArrayList<PlaneacionPagos>();
		PlaneacionPagos entity = new PlaneacionPagos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaneacionPagos();
				
				if(conMapGenerico) {
					entity.setMapPlaneacionPagos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapPlaneacionPagos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PlaneacionPagosDataAccess.ISWITHSCHEMA);         		
					entity=PlaneacionPagosLogic.getEntityPlaneacionPagos("",entity,resultSet,listColumns);
					
					////entity.setPlaneacionPagosOriginal( new PlaneacionPagos());
					////entity.setPlaneacionPagosOriginal(super.getEntity("",entity.getPlaneacionPagosOriginal(),resultSet,PlaneacionPagosDataAccess.ISWITHSCHEMA));         		
					////entity.setPlaneacionPagosOriginal(PlaneacionPagosDataAccess.getEntityPlaneacionPagos("",entity.getPlaneacionPagosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,PlaneacionPagos relplaneacionpagos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relplaneacionpagos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public GrupoCliente getGrupoCliente(Connexion connexion,PlaneacionPagos relplaneacionpagos)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			grupoclienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relplaneacionpagos.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}

	public Factura getFactura(Connexion connexion,PlaneacionPagos relplaneacionpagos)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);
			facturaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			factura=facturaDataAccess.getEntity(connexion,relplaneacionpagos.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Cliente getCliente(Connexion connexion,PlaneacionPagos relplaneacionpagos)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relplaneacionpagos.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


	
	
	public void getPlaneacionPagossBusquedaPlaneacionPagosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_grupo_cliente,Date fecha_pago_inicio,Date fecha_pago_fin)throws Exception {
		try {
			//PlaneacionPagosLogic planeacionpagosLogic=new PlaneacionPagosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PlaneacionPagosLogic.GetSelecSqlPlaneacionPagos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_grupo_cliente,fecha_pago_inicio,fecha_pago_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.planeacionpagoss=this.getPlaneacionPagoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getPlaneacionPagossBusquedaPlaneacionPagos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_grupo_cliente,Date fecha_pago_inicio,Date fecha_pago_fin)throws Exception {
		try {
			//PlaneacionPagosLogic planeacionpagosLogic=new PlaneacionPagosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PlaneacionPagosLogic.GetSelecSqlPlaneacionPagos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_grupo_cliente,fecha_pago_inicio,fecha_pago_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.planeacionpagoss=this.getPlaneacionPagoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlPlaneacionPagos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_grupo_cliente,Date fecha_pago_inicio,Date fecha_pago_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("PlaneacionPagos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" m.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" m.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_grupo_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_grupo_cliente = "+id_grupo_cliente.toString();
					existeWhere=true;
				}

				if(fecha_pago_inicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" m.fecha_pago between "+"'"+Funciones2.getStringPostgresDate(fecha_pago_inicio)+"'";
					existeWhere=true;
				}

				if(fecha_pago_fin!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_pago_fin)+"'";
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
	
	
	public void deepLoad(PlaneacionPagos planeacionpagos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PlaneacionPagosLogicAdditional.updatePlaneacionPagosToGet(planeacionpagos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		planeacionpagos.setEmpresa(planeacionpagosDataAccess.getEmpresa(connexion,planeacionpagos));
		planeacionpagos.setGrupoCliente(planeacionpagosDataAccess.getGrupoCliente(connexion,planeacionpagos));
		planeacionpagos.setFactura(planeacionpagosDataAccess.getFactura(connexion,planeacionpagos));
		planeacionpagos.setCliente(planeacionpagosDataAccess.getCliente(connexion,planeacionpagos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				planeacionpagos.setEmpresa(planeacionpagosDataAccess.getEmpresa(connexion,planeacionpagos));
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				planeacionpagos.setGrupoCliente(planeacionpagosDataAccess.getGrupoCliente(connexion,planeacionpagos));
			}

			if(clas.clas.equals(Factura.class)) {
				planeacionpagos.setFactura(planeacionpagosDataAccess.getFactura(connexion,planeacionpagos));
			}

			if(clas.clas.equals(Cliente.class)) {
				planeacionpagos.setCliente(planeacionpagosDataAccess.getCliente(connexion,planeacionpagos));
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
			planeacionpagos.setEmpresa(planeacionpagosDataAccess.getEmpresa(connexion,planeacionpagos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacionpagos.setGrupoCliente(planeacionpagosDataAccess.getGrupoCliente(connexion,planeacionpagos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacionpagos.setFactura(planeacionpagosDataAccess.getFactura(connexion,planeacionpagos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacionpagos.setCliente(planeacionpagosDataAccess.getCliente(connexion,planeacionpagos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		planeacionpagos.setEmpresa(planeacionpagosDataAccess.getEmpresa(connexion,planeacionpagos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(planeacionpagos.getEmpresa(),isDeep,deepLoadType,clases);
				
		planeacionpagos.setGrupoCliente(planeacionpagosDataAccess.getGrupoCliente(connexion,planeacionpagos));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(planeacionpagos.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		planeacionpagos.setFactura(planeacionpagosDataAccess.getFactura(connexion,planeacionpagos));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(planeacionpagos.getFactura(),isDeep,deepLoadType,clases);
				
		planeacionpagos.setCliente(planeacionpagosDataAccess.getCliente(connexion,planeacionpagos));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(planeacionpagos.getCliente(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				planeacionpagos.setEmpresa(planeacionpagosDataAccess.getEmpresa(connexion,planeacionpagos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(planeacionpagos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				planeacionpagos.setGrupoCliente(planeacionpagosDataAccess.getGrupoCliente(connexion,planeacionpagos));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(planeacionpagos.getGrupoCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Factura.class)) {
				planeacionpagos.setFactura(planeacionpagosDataAccess.getFactura(connexion,planeacionpagos));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(planeacionpagos.getFactura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				planeacionpagos.setCliente(planeacionpagosDataAccess.getCliente(connexion,planeacionpagos));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(planeacionpagos.getCliente(),isDeep,deepLoadType,clases);				
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
			planeacionpagos.setEmpresa(planeacionpagosDataAccess.getEmpresa(connexion,planeacionpagos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(planeacionpagos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacionpagos.setGrupoCliente(planeacionpagosDataAccess.getGrupoCliente(connexion,planeacionpagos));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(planeacionpagos.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacionpagos.setFactura(planeacionpagosDataAccess.getFactura(connexion,planeacionpagos));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(planeacionpagos.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planeacionpagos.setCliente(planeacionpagosDataAccess.getCliente(connexion,planeacionpagos));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(planeacionpagos.getCliente(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(planeacionpagos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PlaneacionPagosConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionPagos(planeacionpagos);
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
			this.deepLoad(this.planeacionpagos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PlaneacionPagosConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionPagos(this.planeacionpagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(planeacionpagoss!=null) {
				for(PlaneacionPagos planeacionpagos:planeacionpagoss) {
					this.deepLoad(planeacionpagos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PlaneacionPagosConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionPagos(planeacionpagoss);
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
			if(planeacionpagoss!=null) {
				for(PlaneacionPagos planeacionpagos:planeacionpagoss) {
					this.deepLoad(planeacionpagos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PlaneacionPagosConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionPagos(planeacionpagoss);
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
	
	public PlaneacionPagosParameterReturnGeneral procesarAccionPlaneacionPagoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PlaneacionPagos> planeacionpagoss,PlaneacionPagosParameterReturnGeneral planeacionpagosParameterGeneral)throws Exception {
		 try {	
			PlaneacionPagosParameterReturnGeneral planeacionpagosReturnGeneral=new PlaneacionPagosParameterReturnGeneral();
	
			PlaneacionPagosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,planeacionpagoss,planeacionpagosParameterGeneral,planeacionpagosReturnGeneral);
			
			return planeacionpagosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PlaneacionPagosParameterReturnGeneral procesarAccionPlaneacionPagossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PlaneacionPagos> planeacionpagoss,PlaneacionPagosParameterReturnGeneral planeacionpagosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			PlaneacionPagosParameterReturnGeneral planeacionpagosReturnGeneral=new PlaneacionPagosParameterReturnGeneral();
	
			PlaneacionPagosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,planeacionpagoss,planeacionpagosParameterGeneral,planeacionpagosReturnGeneral);
			
			this.connexion.commit();
			
			return planeacionpagosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

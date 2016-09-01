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
package com.bydan.erp.inventario.business.logic.report;

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

import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.resources.general.AuxiliarGeneral;
import com.bydan.erp.inventario.util.report.ConsumosServiciosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ConsumosServiciosParameterGeneral;
import com.bydan.erp.inventario.util.report.ConsumosServiciosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ConsumosServicios;

import com.bydan.erp.inventario.business.logic.report.ConsumosServiciosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;






@SuppressWarnings("unused")
public class ConsumosServiciosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ConsumosServiciosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ConsumosServiciosLogic consumosserviciosDataAccess; 		
	protected ConsumosServicios consumosservicios;
	protected List<ConsumosServicios> consumosservicioss;
	protected Object consumosserviciosObject;	
	protected List<Object> consumosserviciossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ConsumosServiciosLogic()throws SQLException,Exception {
		try	{
			this.consumosservicioss= new ArrayList<ConsumosServicios>();
			this.consumosservicios= new ConsumosServicios();
			this.consumosserviciosObject=new Object();
			this.consumosserviciossObject=new ArrayList<Object>();
			
			this.consumosserviciosDataAccess=this;
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
			this.consumosserviciosDataAccess.setConnexionType(this.connexionType);
			this.consumosserviciosDataAccess.setParameterDbType(this.parameterDbType);
			this.consumosserviciosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConsumosServiciosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.consumosservicioss= new ArrayList<ConsumosServicios>();
			this.consumosservicios= new ConsumosServicios();
			this.consumosserviciosObject=new Object();
			this.consumosserviciossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.consumosserviciosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.consumosserviciosDataAccess.setConnexionType(this.connexionType);
			this.consumosserviciosDataAccess.setParameterDbType(this.parameterDbType);
			this.consumosserviciosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ConsumosServicios getConsumosServicios() throws Exception {	
		ConsumosServiciosLogicAdditional.checkConsumosServiciosToGet(consumosservicios,this.datosCliente,this.arrDatoGeneral);
		ConsumosServiciosLogicAdditional.updateConsumosServiciosToGet(consumosservicios,this.arrDatoGeneral);
		
		return consumosservicios;
	}
		
	public void setConsumosServicios(ConsumosServicios newConsumosServicios) {
		this.consumosservicios = newConsumosServicios;
	}
	
	public List<ConsumosServicios> getConsumosServicioss() throws Exception {		
		this.quitarConsumosServiciossNulos();
		
		ConsumosServiciosLogicAdditional.checkConsumosServiciosToGets(consumosservicioss,this.datosCliente,this.arrDatoGeneral);
		
		for (ConsumosServicios consumosserviciosLocal: consumosservicioss ) {
			ConsumosServiciosLogicAdditional.updateConsumosServiciosToGet(consumosserviciosLocal,this.arrDatoGeneral);
		}
		
		return consumosservicioss;
	}
	
	public void setConsumosServicioss(List<ConsumosServicios> newConsumosServicioss) {
		this.consumosservicioss = newConsumosServicioss;
	}
	
	public Object getConsumosServiciosObject() {	
		//this.consumosserviciosObject=this.consumosserviciosDataAccess.getEntityObject();
		return this.consumosserviciosObject;
	}
		
	public void setConsumosServiciosObject(Object newConsumosServiciosObject) {
		this.consumosserviciosObject = newConsumosServiciosObject;
	}
	
	public List<Object> getConsumosServiciossObject() {		
		//this.consumosserviciossObject=this.consumosserviciosDataAccess.getEntitiesObject();
		return this.consumosserviciossObject;
	}
		
	public void setConsumosServiciossObject(List<Object> newConsumosServiciossObject) {
		this.consumosserviciossObject = newConsumosServiciossObject;
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
		consumosservicioss = new  ArrayList<ConsumosServicios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsumosServiciosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consumosservicioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		consumosservicioss = new  ArrayList<ConsumosServicios>();
		  		  
        try {
			//ConsumosServiciosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consumosservicioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		consumosservicioss = new  ArrayList<ConsumosServicios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsumosServiciosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consumosservicioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		consumosservicioss = new  ArrayList<ConsumosServicios>();
		  		  
        try {
			//ConsumosServiciosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consumosservicioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		consumosservicioss = new  ArrayList<ConsumosServicios>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsumosServiciosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consumosservicioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		consumosservicioss = new  ArrayList<ConsumosServicios>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ConsumosServiciosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consumosservicioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ConsumosServicios> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsumosServicios> entities = new  ArrayList<ConsumosServicios>();
		ConsumosServicios entity = new ConsumosServicios();		  
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
	
	public  List<ConsumosServicios> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsumosServicios> entities = new  ArrayList<ConsumosServicios>();
		ConsumosServicios entity = new ConsumosServicios();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConsumosServicios();
				
				
      	    	entity=ConsumosServiciosLogic.getEntityConsumosServicios("",entity,resultSet);
      	    	
				//entity.setConsumosServiciosOriginal( new ConsumosServicios());
      	    	//entity.setConsumosServiciosOriginal(super.getEntity("",entity.getConsumosServiciosOriginal(),resultSet,ConsumosServiciosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConsumosServiciosOriginal(ConsumosServiciosDataAccess.getEntityConsumosServicios("",entity.getConsumosServiciosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ConsumosServicios> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsumosServicios> entities = new  ArrayList<ConsumosServicios>();
		ConsumosServicios entity = new ConsumosServicios();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ConsumosServicios.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConsumosServicios>((List<ConsumosServicios>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConsumosServiciossOriginal(entities);
			
			}  else {
				this.consumosserviciossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConsumosServiciosConstantesFunciones.quitarEspaciosConsumosServicioss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ConsumosServicios getEntityConsumosServicios(String strPrefijo,ConsumosServicios entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ConsumosServiciosConstantesFunciones.NOMBREUNIDAD));
			entity.setnombre_producto(resultSet.getString(strPrefijo+ConsumosServiciosConstantesFunciones.NOMBREPRODUCTO));
			entity.setcantidad(resultSet.getInt(strPrefijo+ConsumosServiciosConstantesFunciones.CANTIDAD));
			entity.setnombre_linea(resultSet.getString(strPrefijo+ConsumosServiciosConstantesFunciones.NOMBRELINEA));
			entity.setnombre_linea_grupo(resultSet.getString(strPrefijo+ConsumosServiciosConstantesFunciones.NOMBRELINEAGRUPO));
			entity.setnombre_linea_categoria(resultSet.getString(strPrefijo+ConsumosServiciosConstantesFunciones.NOMBRELINEACATEGORIA));
			entity.setnombre_linea_marca(resultSet.getString(strPrefijo+ConsumosServiciosConstantesFunciones.NOMBRELINEAMARCA));
			entity.setcodigo(resultSet.getString(strPrefijo+ConsumosServiciosConstantesFunciones.CODIGO));
			entity.settotal(resultSet.getDouble(strPrefijo+ConsumosServiciosConstantesFunciones.TOTAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ConsumosServicios getEntityConsumosServicios(String strPrefijo,ConsumosServicios entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ConsumosServicios.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ConsumosServicios.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ConsumosServiciosLogic.setFieldReflectionConsumosServicios(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionConsumosServicios(Field field,String strPrefijo,String sColumn,ConsumosServicios entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ConsumosServiciosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsumosServiciosConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsumosServiciosConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ConsumosServiciosConstantesFunciones.NOMBRELINEA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsumosServiciosConstantesFunciones.NOMBRELINEAGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsumosServiciosConstantesFunciones.NOMBRELINEACATEGORIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsumosServiciosConstantesFunciones.NOMBRELINEAMARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsumosServiciosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConsumosServiciosConstantesFunciones.TOTAL:
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
	
	public void quitarConsumosServiciossNulos() throws Exception {				
		
		List<ConsumosServicios> consumosserviciossAux= new ArrayList<ConsumosServicios>();
		
		for(ConsumosServicios consumosservicios:consumosservicioss) {
			if(consumosservicios!=null) {
				consumosserviciossAux.add(consumosservicios);
			}
		}
		
		consumosservicioss=consumosserviciossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsumosServicios> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConsumosServicios> entities = new  ArrayList<ConsumosServicios>();
		ConsumosServicios entity = new ConsumosServicios();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConsumosServicios>((List<ConsumosServicios>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConsumosServiciossOriginal(entities);
			
			}  else {
				this.consumosserviciossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConsumosServiciosConstantesFunciones.quitarEspaciosConsumosServicioss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		consumosservicioss = new  ArrayList<ConsumosServicios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConsumosServiciosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consumosservicioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		consumosservicioss = new  ArrayList<ConsumosServicios>();
		  		  
        try {
			//ConsumosServiciosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consumosservicioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ConsumosServicios> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConsumosServicios> entities = new  ArrayList<ConsumosServicios>();
		ConsumosServicios entity = new ConsumosServicios();		  
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
	
	public  List<ConsumosServicios> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConsumosServicios> entities = new  ArrayList<ConsumosServicios>();
		ConsumosServicios entity = new ConsumosServicios();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConsumosServicios();
				
				if(conMapGenerico) {
					entity.setMapConsumosServicios( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapConsumosServicios().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConsumosServiciosDataAccess.ISWITHSCHEMA);         		
					entity=ConsumosServiciosLogic.getEntityConsumosServicios("",entity,resultSet,listColumns);
					
					////entity.setConsumosServiciosOriginal( new ConsumosServicios());
					////entity.setConsumosServiciosOriginal(super.getEntity("",entity.getConsumosServiciosOriginal(),resultSet,ConsumosServiciosDataAccess.ISWITHSCHEMA));         		
					////entity.setConsumosServiciosOriginal(ConsumosServiciosDataAccess.getEntityConsumosServicios("",entity.getConsumosServiciosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ConsumosServicios relconsumosservicios)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relconsumosservicios.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Transaccion getTransaccion(Connexion connexion,ConsumosServicios relconsumosservicios)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);
			transaccionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			transaccion=transaccionDataAccess.getEntity(connexion,relconsumosservicios.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Linea getLinea(Connexion connexion,ConsumosServicios relconsumosservicios)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relconsumosservicios.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ConsumosServicios relconsumosservicios)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relconsumosservicios.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ConsumosServicios relconsumosservicios)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relconsumosservicios.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ConsumosServicios relconsumosservicios)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relconsumosservicios.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public TipoProductoServicio getTipoProductoServicio(Connexion connexion,ConsumosServicios relconsumosservicios)throws SQLException,Exception {

		TipoProductoServicio tipoproductoservicio= new TipoProductoServicio();

		try {
			TipoProductoServicioDataAccess tipoproductoservicioDataAccess=new TipoProductoServicioDataAccess();

			tipoproductoservicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);
			tipoproductoservicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,relconsumosservicios.getid_tipo_producto_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicio;

	}


	
	
	public void getConsumosServiciossBusquedaConsumosServiciosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//ConsumosServiciosLogic consumosserviciosLogic=new ConsumosServiciosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConsumosServiciosLogic.GetSelecSqlConsumosServicios(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_transaccion,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.consumosservicioss=this.getConsumosServicioss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getConsumosServiciossBusquedaConsumosServicios(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//ConsumosServiciosLogic consumosserviciosLogic=new ConsumosServiciosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConsumosServiciosLogic.GetSelecSqlConsumosServicios(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_transaccion,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.consumosservicioss=this.getConsumosServicioss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlConsumosServicios(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ConsumosServicios_Postgres.sql");
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
				

				if(id_transaccion!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" m.id_transaccion = "+id_transaccion.toString();
					existeWhere=true;
				}

				if(id_linea!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea = "+id_linea.toString();
					existeWhere=true;
				}

				if(id_linea_grupo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_grupo = "+id_linea_grupo.toString();
					existeWhere=true;
				}

				if(id_linea_categoria!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_categoria = "+id_linea_categoria.toString();
					existeWhere=true;
				}

				if(id_linea_marca!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_marca = "+id_linea_marca.toString();
					existeWhere=true;
				}

				if(id_tipo_producto_servicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_tipo_producto_servicio = "+id_tipo_producto_servicio.toString();
					existeWhere=true;
				}

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" m.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
					existeWhere=true;
				}

				if(fecha_emision_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_emision_hasta)+"'";
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
	
	
	public void deepLoad(ConsumosServicios consumosservicios,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConsumosServiciosLogicAdditional.updateConsumosServiciosToGet(consumosservicios,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consumosservicios.setEmpresa(consumosserviciosDataAccess.getEmpresa(connexion,consumosservicios));
		consumosservicios.setTransaccion(consumosserviciosDataAccess.getTransaccion(connexion,consumosservicios));
		consumosservicios.setLinea(consumosserviciosDataAccess.getLinea(connexion,consumosservicios));
		consumosservicios.setLineaGrupo(consumosserviciosDataAccess.getLineaGrupo(connexion,consumosservicios));
		consumosservicios.setLineaCategoria(consumosserviciosDataAccess.getLineaCategoria(connexion,consumosservicios));
		consumosservicios.setLineaMarca(consumosserviciosDataAccess.getLineaMarca(connexion,consumosservicios));
		consumosservicios.setTipoProductoServicio(consumosserviciosDataAccess.getTipoProductoServicio(connexion,consumosservicios));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consumosservicios.setEmpresa(consumosserviciosDataAccess.getEmpresa(connexion,consumosservicios));
			}

			if(clas.clas.equals(Transaccion.class)) {
				consumosservicios.setTransaccion(consumosserviciosDataAccess.getTransaccion(connexion,consumosservicios));
			}

			if(clas.clas.equals(Linea.class)) {
				consumosservicios.setLinea(consumosserviciosDataAccess.getLinea(connexion,consumosservicios));
			}

			if(clas.clas.equals(Linea.class)) {
				consumosservicios.setLineaGrupo(consumosserviciosDataAccess.getLineaGrupo(connexion,consumosservicios));
			}

			if(clas.clas.equals(Linea.class)) {
				consumosservicios.setLineaCategoria(consumosserviciosDataAccess.getLineaCategoria(connexion,consumosservicios));
			}

			if(clas.clas.equals(Linea.class)) {
				consumosservicios.setLineaMarca(consumosserviciosDataAccess.getLineaMarca(connexion,consumosservicios));
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				consumosservicios.setTipoProductoServicio(consumosserviciosDataAccess.getTipoProductoServicio(connexion,consumosservicios));
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
			consumosservicios.setEmpresa(consumosserviciosDataAccess.getEmpresa(connexion,consumosservicios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setTransaccion(consumosserviciosDataAccess.getTransaccion(connexion,consumosservicios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setLinea(consumosserviciosDataAccess.getLinea(connexion,consumosservicios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setLineaGrupo(consumosserviciosDataAccess.getLineaGrupo(connexion,consumosservicios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setLineaCategoria(consumosserviciosDataAccess.getLineaCategoria(connexion,consumosservicios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setLineaMarca(consumosserviciosDataAccess.getLineaMarca(connexion,consumosservicios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setTipoProductoServicio(consumosserviciosDataAccess.getTipoProductoServicio(connexion,consumosservicios));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consumosservicios.setEmpresa(consumosserviciosDataAccess.getEmpresa(connexion,consumosservicios));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(consumosservicios.getEmpresa(),isDeep,deepLoadType,clases);
				
		consumosservicios.setTransaccion(consumosserviciosDataAccess.getTransaccion(connexion,consumosservicios));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(consumosservicios.getTransaccion(),isDeep,deepLoadType,clases);
				
		consumosservicios.setLinea(consumosserviciosDataAccess.getLinea(connexion,consumosservicios));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(consumosservicios.getLinea(),isDeep,deepLoadType,clases);
				
		consumosservicios.setLineaGrupo(consumosserviciosDataAccess.getLineaGrupo(connexion,consumosservicios));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(consumosservicios.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		consumosservicios.setLineaCategoria(consumosserviciosDataAccess.getLineaCategoria(connexion,consumosservicios));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(consumosservicios.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		consumosservicios.setLineaMarca(consumosserviciosDataAccess.getLineaMarca(connexion,consumosservicios));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(consumosservicios.getLineaMarca(),isDeep,deepLoadType,clases);
				
		consumosservicios.setTipoProductoServicio(consumosserviciosDataAccess.getTipoProductoServicio(connexion,consumosservicios));
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(consumosservicios.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consumosservicios.setEmpresa(consumosserviciosDataAccess.getEmpresa(connexion,consumosservicios));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(consumosservicios.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Transaccion.class)) {
				consumosservicios.setTransaccion(consumosserviciosDataAccess.getTransaccion(connexion,consumosservicios));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(consumosservicios.getTransaccion(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				consumosservicios.setLinea(consumosserviciosDataAccess.getLinea(connexion,consumosservicios));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(consumosservicios.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				consumosservicios.setLineaGrupo(consumosserviciosDataAccess.getLineaGrupo(connexion,consumosservicios));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(consumosservicios.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				consumosservicios.setLineaCategoria(consumosserviciosDataAccess.getLineaCategoria(connexion,consumosservicios));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(consumosservicios.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				consumosservicios.setLineaMarca(consumosserviciosDataAccess.getLineaMarca(connexion,consumosservicios));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(consumosservicios.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				consumosservicios.setTipoProductoServicio(consumosserviciosDataAccess.getTipoProductoServicio(connexion,consumosservicios));
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepLoad(consumosservicios.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
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
			consumosservicios.setEmpresa(consumosserviciosDataAccess.getEmpresa(connexion,consumosservicios));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(consumosservicios.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setTransaccion(consumosserviciosDataAccess.getTransaccion(connexion,consumosservicios));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(consumosservicios.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setLinea(consumosserviciosDataAccess.getLinea(connexion,consumosservicios));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(consumosservicios.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setLineaGrupo(consumosserviciosDataAccess.getLineaGrupo(connexion,consumosservicios));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(consumosservicios.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setLineaCategoria(consumosserviciosDataAccess.getLineaCategoria(connexion,consumosservicios));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(consumosservicios.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setLineaMarca(consumosserviciosDataAccess.getLineaMarca(connexion,consumosservicios));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(consumosservicios.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consumosservicios.setTipoProductoServicio(consumosserviciosDataAccess.getTipoProductoServicio(connexion,consumosservicios));
			TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
			tipoproductoservicioLogic.deepLoad(consumosservicios.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(consumosservicios,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsumosServiciosConstantesFunciones.refrescarForeignKeysDescripcionesConsumosServicios(consumosservicios);
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
			this.deepLoad(this.consumosservicios,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsumosServiciosConstantesFunciones.refrescarForeignKeysDescripcionesConsumosServicios(this.consumosservicios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(consumosservicioss!=null) {
				for(ConsumosServicios consumosservicios:consumosservicioss) {
					this.deepLoad(consumosservicios,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConsumosServiciosConstantesFunciones.refrescarForeignKeysDescripcionesConsumosServicios(consumosservicioss);
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
			if(consumosservicioss!=null) {
				for(ConsumosServicios consumosservicios:consumosservicioss) {
					this.deepLoad(consumosservicios,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConsumosServiciosConstantesFunciones.refrescarForeignKeysDescripcionesConsumosServicios(consumosservicioss);
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
	
	public ConsumosServiciosParameterReturnGeneral procesarAccionConsumosServicioss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConsumosServicios> consumosservicioss,ConsumosServiciosParameterReturnGeneral consumosserviciosParameterGeneral)throws Exception {
		 try {	
			ConsumosServiciosParameterReturnGeneral consumosserviciosReturnGeneral=new ConsumosServiciosParameterReturnGeneral();
	
			ConsumosServiciosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consumosservicioss,consumosserviciosParameterGeneral,consumosserviciosReturnGeneral);
			
			return consumosserviciosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConsumosServiciosParameterReturnGeneral procesarAccionConsumosServiciossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConsumosServicios> consumosservicioss,ConsumosServiciosParameterReturnGeneral consumosserviciosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ConsumosServiciosParameterReturnGeneral consumosserviciosReturnGeneral=new ConsumosServiciosParameterReturnGeneral();
	
			ConsumosServiciosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consumosservicioss,consumosserviciosParameterGeneral,consumosserviciosReturnGeneral);
			
			this.connexion.commit();
			
			return consumosserviciosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

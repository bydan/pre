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
import com.bydan.erp.inventario.util.report.ModificacionLineasProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ModificacionLineasProductosParameterGeneral;
import com.bydan.erp.inventario.util.report.ModificacionLineasProductosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ModificacionLineasProductos;

import com.bydan.erp.inventario.business.logic.report.ModificacionLineasProductosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;






@SuppressWarnings("unused")
public class ModificacionLineasProductosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ModificacionLineasProductosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ModificacionLineasProductosLogic modificacionlineasproductosDataAccess; 		
	protected ModificacionLineasProductos modificacionlineasproductos;
	protected List<ModificacionLineasProductos> modificacionlineasproductoss;
	protected Object modificacionlineasproductosObject;	
	protected List<Object> modificacionlineasproductossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ModificacionLineasProductosLogic()throws SQLException,Exception {
		try	{
			this.modificacionlineasproductoss= new ArrayList<ModificacionLineasProductos>();
			this.modificacionlineasproductos= new ModificacionLineasProductos();
			this.modificacionlineasproductosObject=new Object();
			this.modificacionlineasproductossObject=new ArrayList<Object>();
			
			this.modificacionlineasproductosDataAccess=this;
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
			this.modificacionlineasproductosDataAccess.setConnexionType(this.connexionType);
			this.modificacionlineasproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.modificacionlineasproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ModificacionLineasProductosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.modificacionlineasproductoss= new ArrayList<ModificacionLineasProductos>();
			this.modificacionlineasproductos= new ModificacionLineasProductos();
			this.modificacionlineasproductosObject=new Object();
			this.modificacionlineasproductossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.modificacionlineasproductosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.modificacionlineasproductosDataAccess.setConnexionType(this.connexionType);
			this.modificacionlineasproductosDataAccess.setParameterDbType(this.parameterDbType);
			this.modificacionlineasproductosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ModificacionLineasProductos getModificacionLineasProductos() throws Exception {	
		ModificacionLineasProductosLogicAdditional.checkModificacionLineasProductosToGet(modificacionlineasproductos,this.datosCliente,this.arrDatoGeneral);
		ModificacionLineasProductosLogicAdditional.updateModificacionLineasProductosToGet(modificacionlineasproductos,this.arrDatoGeneral);
		
		return modificacionlineasproductos;
	}
		
	public void setModificacionLineasProductos(ModificacionLineasProductos newModificacionLineasProductos) {
		this.modificacionlineasproductos = newModificacionLineasProductos;
	}
	
	public List<ModificacionLineasProductos> getModificacionLineasProductoss() throws Exception {		
		this.quitarModificacionLineasProductossNulos();
		
		ModificacionLineasProductosLogicAdditional.checkModificacionLineasProductosToGets(modificacionlineasproductoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ModificacionLineasProductos modificacionlineasproductosLocal: modificacionlineasproductoss ) {
			ModificacionLineasProductosLogicAdditional.updateModificacionLineasProductosToGet(modificacionlineasproductosLocal,this.arrDatoGeneral);
		}
		
		return modificacionlineasproductoss;
	}
	
	public void setModificacionLineasProductoss(List<ModificacionLineasProductos> newModificacionLineasProductoss) {
		this.modificacionlineasproductoss = newModificacionLineasProductoss;
	}
	
	public Object getModificacionLineasProductosObject() {	
		//this.modificacionlineasproductosObject=this.modificacionlineasproductosDataAccess.getEntityObject();
		return this.modificacionlineasproductosObject;
	}
		
	public void setModificacionLineasProductosObject(Object newModificacionLineasProductosObject) {
		this.modificacionlineasproductosObject = newModificacionLineasProductosObject;
	}
	
	public List<Object> getModificacionLineasProductossObject() {		
		//this.modificacionlineasproductossObject=this.modificacionlineasproductosDataAccess.getEntitiesObject();
		return this.modificacionlineasproductossObject;
	}
		
	public void setModificacionLineasProductossObject(List<Object> newModificacionLineasProductossObject) {
		this.modificacionlineasproductossObject = newModificacionLineasProductossObject;
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
		modificacionlineasproductoss = new  ArrayList<ModificacionLineasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ModificacionLineasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modificacionlineasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		modificacionlineasproductoss = new  ArrayList<ModificacionLineasProductos>();
		  		  
        try {
			//ModificacionLineasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modificacionlineasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		modificacionlineasproductoss = new  ArrayList<ModificacionLineasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ModificacionLineasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modificacionlineasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		modificacionlineasproductoss = new  ArrayList<ModificacionLineasProductos>();
		  		  
        try {
			//ModificacionLineasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modificacionlineasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		modificacionlineasproductoss = new  ArrayList<ModificacionLineasProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ModificacionLineasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modificacionlineasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		modificacionlineasproductoss = new  ArrayList<ModificacionLineasProductos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ModificacionLineasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modificacionlineasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ModificacionLineasProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ModificacionLineasProductos> entities = new  ArrayList<ModificacionLineasProductos>();
		ModificacionLineasProductos entity = new ModificacionLineasProductos();		  
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
	
	public  List<ModificacionLineasProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ModificacionLineasProductos> entities = new  ArrayList<ModificacionLineasProductos>();
		ModificacionLineasProductos entity = new ModificacionLineasProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ModificacionLineasProductos();
				
				
      	    	entity=ModificacionLineasProductosLogic.getEntityModificacionLineasProductos("",entity,resultSet);
      	    	
				//entity.setModificacionLineasProductosOriginal( new ModificacionLineasProductos());
      	    	//entity.setModificacionLineasProductosOriginal(super.getEntity("",entity.getModificacionLineasProductosOriginal(),resultSet,ModificacionLineasProductosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setModificacionLineasProductosOriginal(ModificacionLineasProductosDataAccess.getEntityModificacionLineasProductos("",entity.getModificacionLineasProductosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ModificacionLineasProductos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ModificacionLineasProductos> entities = new  ArrayList<ModificacionLineasProductos>();
		ModificacionLineasProductos entity = new ModificacionLineasProductos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ModificacionLineasProductos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ModificacionLineasProductos>((List<ModificacionLineasProductos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setModificacionLineasProductossOriginal(entities);
			
			}  else {
				this.modificacionlineasproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ModificacionLineasProductosConstantesFunciones.quitarEspaciosModificacionLineasProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ModificacionLineasProductos getEntityModificacionLineasProductos(String strPrefijo,ModificacionLineasProductos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_producto(resultSet.getLong(strPrefijo+ModificacionLineasProductosConstantesFunciones.IDPRODUCTO));
			entity.setid_linea(resultSet.getLong(strPrefijo+ModificacionLineasProductosConstantesFunciones.IDLINEA));
			entity.setid_linea_grupo(resultSet.getLong(strPrefijo+ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPO));
			entity.setid_linea_categoria(resultSet.getLong(strPrefijo+ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIA));
			entity.setid_linea_marca(resultSet.getLong(strPrefijo+ModificacionLineasProductosConstantesFunciones.IDLINEAMARCA));
			entity.setid_linea_destino(resultSet.getLong(strPrefijo+ModificacionLineasProductosConstantesFunciones.IDLINEADESTINO));
			entity.setid_linea_grupo_destino(resultSet.getLong(strPrefijo+ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPODESTINO));
			entity.setid_linea_categoria_destino(resultSet.getLong(strPrefijo+ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIADESTINO));
			entity.setid_linea_marca_destino(resultSet.getLong(strPrefijo+ModificacionLineasProductosConstantesFunciones.IDLINEAMARCADESTINO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ModificacionLineasProductos getEntityModificacionLineasProductos(String strPrefijo,ModificacionLineasProductos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ModificacionLineasProductos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ModificacionLineasProductos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ModificacionLineasProductosLogic.setFieldReflectionModificacionLineasProductos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionModificacionLineasProductos(Field field,String strPrefijo,String sColumn,ModificacionLineasProductos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ModificacionLineasProductosConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ModificacionLineasProductosConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ModificacionLineasProductosConstantesFunciones.IDLINEAMARCA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ModificacionLineasProductosConstantesFunciones.IDLINEADESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPODESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIADESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ModificacionLineasProductosConstantesFunciones.IDLINEAMARCADESTINO:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	public void quitarModificacionLineasProductossNulos() throws Exception {				
		
		List<ModificacionLineasProductos> modificacionlineasproductossAux= new ArrayList<ModificacionLineasProductos>();
		
		for(ModificacionLineasProductos modificacionlineasproductos:modificacionlineasproductoss) {
			if(modificacionlineasproductos!=null) {
				modificacionlineasproductossAux.add(modificacionlineasproductos);
			}
		}
		
		modificacionlineasproductoss=modificacionlineasproductossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ModificacionLineasProductos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ModificacionLineasProductos> entities = new  ArrayList<ModificacionLineasProductos>();
		ModificacionLineasProductos entity = new ModificacionLineasProductos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ModificacionLineasProductos>((List<ModificacionLineasProductos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setModificacionLineasProductossOriginal(entities);
			
			}  else {
				this.modificacionlineasproductossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ModificacionLineasProductosConstantesFunciones.quitarEspaciosModificacionLineasProductoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		modificacionlineasproductoss = new  ArrayList<ModificacionLineasProductos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ModificacionLineasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modificacionlineasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		modificacionlineasproductoss = new  ArrayList<ModificacionLineasProductos>();
		  		  
        try {
			//ModificacionLineasProductosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modificacionlineasproductoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ModificacionLineasProductos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ModificacionLineasProductos> entities = new  ArrayList<ModificacionLineasProductos>();
		ModificacionLineasProductos entity = new ModificacionLineasProductos();		  
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
	
	public  List<ModificacionLineasProductos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ModificacionLineasProductos> entities = new  ArrayList<ModificacionLineasProductos>();
		ModificacionLineasProductos entity = new ModificacionLineasProductos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ModificacionLineasProductos();
				
				if(conMapGenerico) {
					entity.setMapModificacionLineasProductos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapModificacionLineasProductos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ModificacionLineasProductosDataAccess.ISWITHSCHEMA);         		
					entity=ModificacionLineasProductosLogic.getEntityModificacionLineasProductos("",entity,resultSet,listColumns);
					
					////entity.setModificacionLineasProductosOriginal( new ModificacionLineasProductos());
					////entity.setModificacionLineasProductosOriginal(super.getEntity("",entity.getModificacionLineasProductosOriginal(),resultSet,ModificacionLineasProductosDataAccess.ISWITHSCHEMA));         		
					////entity.setModificacionLineasProductosOriginal(ModificacionLineasProductosDataAccess.getEntityModificacionLineasProductos("",entity.getModificacionLineasProductosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Producto getProducto(Connexion connexion,ModificacionLineasProductos relmodificacionlineasproductos)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relmodificacionlineasproductos.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Linea getLinea(Connexion connexion,ModificacionLineasProductos relmodificacionlineasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmodificacionlineasproductos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ModificacionLineasProductos relmodificacionlineasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmodificacionlineasproductos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ModificacionLineasProductos relmodificacionlineasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmodificacionlineasproductos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ModificacionLineasProductos relmodificacionlineasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmodificacionlineasproductos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaDestino(Connexion connexion,ModificacionLineasProductos relmodificacionlineasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmodificacionlineasproductos.getid_linea_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupoDestino(Connexion connexion,ModificacionLineasProductos relmodificacionlineasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmodificacionlineasproductos.getid_linea_grupo_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoriaDestino(Connexion connexion,ModificacionLineasProductos relmodificacionlineasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmodificacionlineasproductos.getid_linea_categoria_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarcaDestino(Connexion connexion,ModificacionLineasProductos relmodificacionlineasproductos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relmodificacionlineasproductos.getid_linea_marca_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getModificacionLineasProductossBusquedaModificacionLineasProductosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_linea_destino,Long id_linea_grupo_destino,Long id_linea_categoria_destino,Long id_linea_marca_destino)throws Exception {
		try {
			ModificacionLineasProductosLogicAdditional modificacionlineasproductosLogicAdditional=new ModificacionLineasProductosLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			modificacionlineasproductosLogicAdditional.BusquedaModificacionLineasProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_linea_destino,id_linea_grupo_destino,id_linea_categoria_destino,id_linea_marca_destino);

			//this.modificacionlineasproductoss=this.getModificacionLineasProductoss();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ModificacionLineasProductosLogicAdditional.ProcesarInformacionModificacionLineasProductos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,modificacionlineasproductosLogicAdditional,this.modificacionlineasproductoss,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaModificacionLineasProductos",id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_linea_destino,id_linea_grupo_destino,id_linea_categoria_destino,id_linea_marca_destino);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getModificacionLineasProductossBusquedaModificacionLineasProductos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_linea_destino,Long id_linea_grupo_destino,Long id_linea_categoria_destino,Long id_linea_marca_destino)throws Exception {
		try {
			ModificacionLineasProductosLogicAdditional modificacionlineasproductosLogicAdditional=new ModificacionLineasProductosLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			modificacionlineasproductosLogicAdditional.BusquedaModificacionLineasProductos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_linea_destino,id_linea_grupo_destino,id_linea_categoria_destino,id_linea_marca_destino);

			//this.modificacionlineasproductoss=this.getModificacionLineasProductoss();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ModificacionLineasProductosLogicAdditional.ProcesarInformacionModificacionLineasProductos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,modificacionlineasproductosLogicAdditional,this.modificacionlineasproductoss,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaModificacionLineasProductos",id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_linea_destino,id_linea_grupo_destino,id_linea_categoria_destino,id_linea_marca_destino);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ModificacionLineasProductos modificacionlineasproductos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ModificacionLineasProductosLogicAdditional.updateModificacionLineasProductosToGet(modificacionlineasproductos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		modificacionlineasproductos.setProducto(modificacionlineasproductosDataAccess.getProducto(connexion,modificacionlineasproductos));
		modificacionlineasproductos.setLinea(modificacionlineasproductosDataAccess.getLinea(connexion,modificacionlineasproductos));
		modificacionlineasproductos.setLineaGrupo(modificacionlineasproductosDataAccess.getLineaGrupo(connexion,modificacionlineasproductos));
		modificacionlineasproductos.setLineaCategoria(modificacionlineasproductosDataAccess.getLineaCategoria(connexion,modificacionlineasproductos));
		modificacionlineasproductos.setLineaMarca(modificacionlineasproductosDataAccess.getLineaMarca(connexion,modificacionlineasproductos));
		modificacionlineasproductos.setLineaDestino(modificacionlineasproductosDataAccess.getLineaDestino(connexion,modificacionlineasproductos));
		modificacionlineasproductos.setLineaGrupoDestino(modificacionlineasproductosDataAccess.getLineaGrupoDestino(connexion,modificacionlineasproductos));
		modificacionlineasproductos.setLineaCategoriaDestino(modificacionlineasproductosDataAccess.getLineaCategoriaDestino(connexion,modificacionlineasproductos));
		modificacionlineasproductos.setLineaMarcaDestino(modificacionlineasproductosDataAccess.getLineaMarcaDestino(connexion,modificacionlineasproductos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				modificacionlineasproductos.setProducto(modificacionlineasproductosDataAccess.getProducto(connexion,modificacionlineasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLinea(modificacionlineasproductosDataAccess.getLinea(connexion,modificacionlineasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaGrupo(modificacionlineasproductosDataAccess.getLineaGrupo(connexion,modificacionlineasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaCategoria(modificacionlineasproductosDataAccess.getLineaCategoria(connexion,modificacionlineasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaMarca(modificacionlineasproductosDataAccess.getLineaMarca(connexion,modificacionlineasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaDestino(modificacionlineasproductosDataAccess.getLineaDestino(connexion,modificacionlineasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaGrupoDestino(modificacionlineasproductosDataAccess.getLineaGrupoDestino(connexion,modificacionlineasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaCategoriaDestino(modificacionlineasproductosDataAccess.getLineaCategoriaDestino(connexion,modificacionlineasproductos));
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaMarcaDestino(modificacionlineasproductosDataAccess.getLineaMarcaDestino(connexion,modificacionlineasproductos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setProducto(modificacionlineasproductosDataAccess.getProducto(connexion,modificacionlineasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLinea(modificacionlineasproductosDataAccess.getLinea(connexion,modificacionlineasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaGrupo(modificacionlineasproductosDataAccess.getLineaGrupo(connexion,modificacionlineasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaCategoria(modificacionlineasproductosDataAccess.getLineaCategoria(connexion,modificacionlineasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaMarca(modificacionlineasproductosDataAccess.getLineaMarca(connexion,modificacionlineasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaDestino(modificacionlineasproductosDataAccess.getLineaDestino(connexion,modificacionlineasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaGrupoDestino(modificacionlineasproductosDataAccess.getLineaGrupoDestino(connexion,modificacionlineasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaCategoriaDestino(modificacionlineasproductosDataAccess.getLineaCategoriaDestino(connexion,modificacionlineasproductos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaMarcaDestino(modificacionlineasproductosDataAccess.getLineaMarcaDestino(connexion,modificacionlineasproductos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		modificacionlineasproductos.setProducto(modificacionlineasproductosDataAccess.getProducto(connexion,modificacionlineasproductos));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(modificacionlineasproductos.getProducto(),isDeep,deepLoadType,clases);
				
		modificacionlineasproductos.setLinea(modificacionlineasproductosDataAccess.getLinea(connexion,modificacionlineasproductos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(modificacionlineasproductos.getLinea(),isDeep,deepLoadType,clases);
				
		modificacionlineasproductos.setLineaGrupo(modificacionlineasproductosDataAccess.getLineaGrupo(connexion,modificacionlineasproductos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(modificacionlineasproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		modificacionlineasproductos.setLineaCategoria(modificacionlineasproductosDataAccess.getLineaCategoria(connexion,modificacionlineasproductos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(modificacionlineasproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		modificacionlineasproductos.setLineaMarca(modificacionlineasproductosDataAccess.getLineaMarca(connexion,modificacionlineasproductos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(modificacionlineasproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
		modificacionlineasproductos.setLineaDestino(modificacionlineasproductosDataAccess.getLineaDestino(connexion,modificacionlineasproductos));
		LineaLogic lineadestinoLogic= new LineaLogic(connexion);
		lineadestinoLogic.deepLoad(modificacionlineasproductos.getLineaDestino(),isDeep,deepLoadType,clases);
				
		modificacionlineasproductos.setLineaGrupoDestino(modificacionlineasproductosDataAccess.getLineaGrupoDestino(connexion,modificacionlineasproductos));
		LineaLogic lineagrupodestinoLogic= new LineaLogic(connexion);
		lineagrupodestinoLogic.deepLoad(modificacionlineasproductos.getLineaGrupoDestino(),isDeep,deepLoadType,clases);
				
		modificacionlineasproductos.setLineaCategoriaDestino(modificacionlineasproductosDataAccess.getLineaCategoriaDestino(connexion,modificacionlineasproductos));
		LineaLogic lineacategoriadestinoLogic= new LineaLogic(connexion);
		lineacategoriadestinoLogic.deepLoad(modificacionlineasproductos.getLineaCategoriaDestino(),isDeep,deepLoadType,clases);
				
		modificacionlineasproductos.setLineaMarcaDestino(modificacionlineasproductosDataAccess.getLineaMarcaDestino(connexion,modificacionlineasproductos));
		LineaLogic lineamarcadestinoLogic= new LineaLogic(connexion);
		lineamarcadestinoLogic.deepLoad(modificacionlineasproductos.getLineaMarcaDestino(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				modificacionlineasproductos.setProducto(modificacionlineasproductosDataAccess.getProducto(connexion,modificacionlineasproductos));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(modificacionlineasproductos.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLinea(modificacionlineasproductosDataAccess.getLinea(connexion,modificacionlineasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(modificacionlineasproductos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaGrupo(modificacionlineasproductosDataAccess.getLineaGrupo(connexion,modificacionlineasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(modificacionlineasproductos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaCategoria(modificacionlineasproductosDataAccess.getLineaCategoria(connexion,modificacionlineasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(modificacionlineasproductos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaMarca(modificacionlineasproductosDataAccess.getLineaMarca(connexion,modificacionlineasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(modificacionlineasproductos.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaDestino(modificacionlineasproductosDataAccess.getLineaDestino(connexion,modificacionlineasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(modificacionlineasproductos.getLineaDestino(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaGrupoDestino(modificacionlineasproductosDataAccess.getLineaGrupoDestino(connexion,modificacionlineasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(modificacionlineasproductos.getLineaGrupoDestino(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaCategoriaDestino(modificacionlineasproductosDataAccess.getLineaCategoriaDestino(connexion,modificacionlineasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(modificacionlineasproductos.getLineaCategoriaDestino(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				modificacionlineasproductos.setLineaMarcaDestino(modificacionlineasproductosDataAccess.getLineaMarcaDestino(connexion,modificacionlineasproductos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(modificacionlineasproductos.getLineaMarcaDestino(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setProducto(modificacionlineasproductosDataAccess.getProducto(connexion,modificacionlineasproductos));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(modificacionlineasproductos.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLinea(modificacionlineasproductosDataAccess.getLinea(connexion,modificacionlineasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(modificacionlineasproductos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaGrupo(modificacionlineasproductosDataAccess.getLineaGrupo(connexion,modificacionlineasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(modificacionlineasproductos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaCategoria(modificacionlineasproductosDataAccess.getLineaCategoria(connexion,modificacionlineasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(modificacionlineasproductos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaMarca(modificacionlineasproductosDataAccess.getLineaMarca(connexion,modificacionlineasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(modificacionlineasproductos.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaDestino(modificacionlineasproductosDataAccess.getLineaDestino(connexion,modificacionlineasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(modificacionlineasproductos.getLineaDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaGrupoDestino(modificacionlineasproductosDataAccess.getLineaGrupoDestino(connexion,modificacionlineasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(modificacionlineasproductos.getLineaGrupoDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaCategoriaDestino(modificacionlineasproductosDataAccess.getLineaCategoriaDestino(connexion,modificacionlineasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(modificacionlineasproductos.getLineaCategoriaDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modificacionlineasproductos.setLineaMarcaDestino(modificacionlineasproductosDataAccess.getLineaMarcaDestino(connexion,modificacionlineasproductos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(modificacionlineasproductos.getLineaMarcaDestino(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(modificacionlineasproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ModificacionLineasProductosConstantesFunciones.refrescarForeignKeysDescripcionesModificacionLineasProductos(modificacionlineasproductos);
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
			this.deepLoad(this.modificacionlineasproductos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ModificacionLineasProductosConstantesFunciones.refrescarForeignKeysDescripcionesModificacionLineasProductos(this.modificacionlineasproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(modificacionlineasproductoss!=null) {
				for(ModificacionLineasProductos modificacionlineasproductos:modificacionlineasproductoss) {
					this.deepLoad(modificacionlineasproductos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ModificacionLineasProductosConstantesFunciones.refrescarForeignKeysDescripcionesModificacionLineasProductos(modificacionlineasproductoss);
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
			if(modificacionlineasproductoss!=null) {
				for(ModificacionLineasProductos modificacionlineasproductos:modificacionlineasproductoss) {
					this.deepLoad(modificacionlineasproductos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ModificacionLineasProductosConstantesFunciones.refrescarForeignKeysDescripcionesModificacionLineasProductos(modificacionlineasproductoss);
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
	
	public ModificacionLineasProductosParameterReturnGeneral procesarAccionModificacionLineasProductoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ModificacionLineasProductos> modificacionlineasproductoss,ModificacionLineasProductosParameterReturnGeneral modificacionlineasproductosParameterGeneral)throws Exception {
		 try {	
			ModificacionLineasProductosParameterReturnGeneral modificacionlineasproductosReturnGeneral=new ModificacionLineasProductosParameterReturnGeneral();
	
			ModificacionLineasProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,modificacionlineasproductoss,modificacionlineasproductosParameterGeneral,modificacionlineasproductosReturnGeneral);
			
			return modificacionlineasproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ModificacionLineasProductosParameterReturnGeneral procesarAccionModificacionLineasProductossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ModificacionLineasProductos> modificacionlineasproductoss,ModificacionLineasProductosParameterReturnGeneral modificacionlineasproductosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ModificacionLineasProductosParameterReturnGeneral modificacionlineasproductosReturnGeneral=new ModificacionLineasProductosParameterReturnGeneral();
	
			ModificacionLineasProductosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,modificacionlineasproductoss,modificacionlineasproductosParameterGeneral,modificacionlineasproductosReturnGeneral);
			
			this.connexion.commit();
			
			return modificacionlineasproductosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ModificacionLineasProductos> modificacionlineasproductoss,String sTipoBusqueda,Long id_productoBusquedaModificacionLineasProductos,Long id_lineaBusquedaModificacionLineasProductos,Long id_linea_grupoBusquedaModificacionLineasProductos,Long id_linea_categoriaBusquedaModificacionLineasProductos,Long id_linea_marcaBusquedaModificacionLineasProductos,Long id_linea_destinoBusquedaModificacionLineasProductos,Long id_linea_grupo_destinoBusquedaModificacionLineasProductos,Long id_linea_categoria_destinoBusquedaModificacionLineasProductos,Long id_linea_marca_destinoBusquedaModificacionLineasProductos) throws Exception {
		Boolean procesado=false;

		try {
			ModificacionLineasProductosLogicAdditional modificacionlineasproductosLogicAdditional=new ModificacionLineasProductosLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//modificacionlineasproductosLogicAdditional.setConnexion(this.connexion);

			modificacionlineasproductosLogicAdditional.ProcesarInformacionModificacionLineasProductos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,modificacionlineasproductoss,sTipoBusqueda,id_productoBusquedaModificacionLineasProductos,id_lineaBusquedaModificacionLineasProductos,id_linea_grupoBusquedaModificacionLineasProductos,id_linea_categoriaBusquedaModificacionLineasProductos,id_linea_marcaBusquedaModificacionLineasProductos,id_linea_destinoBusquedaModificacionLineasProductos,id_linea_grupo_destinoBusquedaModificacionLineasProductos,id_linea_categoria_destinoBusquedaModificacionLineasProductos,id_linea_marca_destinoBusquedaModificacionLineasProductos);

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

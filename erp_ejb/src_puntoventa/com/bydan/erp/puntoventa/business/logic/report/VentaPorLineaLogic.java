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
package com.bydan.erp.puntoventa.business.logic.report;

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

import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.resources.general.AuxiliarGeneral;
import com.bydan.erp.puntoventa.util.report.VentaPorLineaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.VentaPorLineaParameterGeneral;
import com.bydan.erp.puntoventa.util.report.VentaPorLineaConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.VentaPorLinea;

import com.bydan.erp.puntoventa.business.logic.report.VentaPorLineaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;






@SuppressWarnings("unused")
public class VentaPorLineaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(VentaPorLineaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected VentaPorLineaLogic ventaporlineaDataAccess; 		
	protected VentaPorLinea ventaporlinea;
	protected List<VentaPorLinea> ventaporlineas;
	protected Object ventaporlineaObject;	
	protected List<Object> ventaporlineasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  VentaPorLineaLogic()throws SQLException,Exception {
		try	{
			this.ventaporlineas= new ArrayList<VentaPorLinea>();
			this.ventaporlinea= new VentaPorLinea();
			this.ventaporlineaObject=new Object();
			this.ventaporlineasObject=new ArrayList<Object>();
			
			this.ventaporlineaDataAccess=this;
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
			this.ventaporlineaDataAccess.setConnexionType(this.connexionType);
			this.ventaporlineaDataAccess.setParameterDbType(this.parameterDbType);
			this.ventaporlineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VentaPorLineaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.ventaporlineas= new ArrayList<VentaPorLinea>();
			this.ventaporlinea= new VentaPorLinea();
			this.ventaporlineaObject=new Object();
			this.ventaporlineasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.ventaporlineaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.ventaporlineaDataAccess.setConnexionType(this.connexionType);
			this.ventaporlineaDataAccess.setParameterDbType(this.parameterDbType);
			this.ventaporlineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public VentaPorLinea getVentaPorLinea() throws Exception {	
		VentaPorLineaLogicAdditional.checkVentaPorLineaToGet(ventaporlinea,this.datosCliente,this.arrDatoGeneral);
		VentaPorLineaLogicAdditional.updateVentaPorLineaToGet(ventaporlinea,this.arrDatoGeneral);
		
		return ventaporlinea;
	}
		
	public void setVentaPorLinea(VentaPorLinea newVentaPorLinea) {
		this.ventaporlinea = newVentaPorLinea;
	}
	
	public List<VentaPorLinea> getVentaPorLineas() throws Exception {		
		this.quitarVentaPorLineasNulos();
		
		VentaPorLineaLogicAdditional.checkVentaPorLineaToGets(ventaporlineas,this.datosCliente,this.arrDatoGeneral);
		
		for (VentaPorLinea ventaporlineaLocal: ventaporlineas ) {
			VentaPorLineaLogicAdditional.updateVentaPorLineaToGet(ventaporlineaLocal,this.arrDatoGeneral);
		}
		
		return ventaporlineas;
	}
	
	public void setVentaPorLineas(List<VentaPorLinea> newVentaPorLineas) {
		this.ventaporlineas = newVentaPorLineas;
	}
	
	public Object getVentaPorLineaObject() {	
		//this.ventaporlineaObject=this.ventaporlineaDataAccess.getEntityObject();
		return this.ventaporlineaObject;
	}
		
	public void setVentaPorLineaObject(Object newVentaPorLineaObject) {
		this.ventaporlineaObject = newVentaPorLineaObject;
	}
	
	public List<Object> getVentaPorLineasObject() {		
		//this.ventaporlineasObject=this.ventaporlineaDataAccess.getEntitiesObject();
		return this.ventaporlineasObject;
	}
		
	public void setVentaPorLineasObject(List<Object> newVentaPorLineasObject) {
		this.ventaporlineasObject = newVentaPorLineasObject;
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
		ventaporlineas = new  ArrayList<VentaPorLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VentaPorLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventaporlineas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		ventaporlineas = new  ArrayList<VentaPorLinea>();
		  		  
        try {
			//VentaPorLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventaporlineas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ventaporlineas = new  ArrayList<VentaPorLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VentaPorLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventaporlineas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		ventaporlineas = new  ArrayList<VentaPorLinea>();
		  		  
        try {
			//VentaPorLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventaporlineas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		ventaporlineas = new  ArrayList<VentaPorLinea>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VentaPorLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventaporlineas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		ventaporlineas = new  ArrayList<VentaPorLinea>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//VentaPorLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventaporlineas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<VentaPorLinea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VentaPorLinea> entities = new  ArrayList<VentaPorLinea>();
		VentaPorLinea entity = new VentaPorLinea();		  
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
	
	public  List<VentaPorLinea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VentaPorLinea> entities = new  ArrayList<VentaPorLinea>();
		VentaPorLinea entity = new VentaPorLinea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VentaPorLinea();
				
				
      	    	entity=VentaPorLineaLogic.getEntityVentaPorLinea("",entity,resultSet);
      	    	
				//entity.setVentaPorLineaOriginal( new VentaPorLinea());
      	    	//entity.setVentaPorLineaOriginal(super.getEntity("",entity.getVentaPorLineaOriginal(),resultSet,VentaPorLineaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVentaPorLineaOriginal(VentaPorLineaDataAccess.getEntityVentaPorLinea("",entity.getVentaPorLineaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<VentaPorLinea> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VentaPorLinea> entities = new  ArrayList<VentaPorLinea>();
		VentaPorLinea entity = new VentaPorLinea();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,VentaPorLinea.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<VentaPorLinea>((List<VentaPorLinea>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setVentaPorLineasOriginal(entities);
			
			}  else {
				this.ventaporlineasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//VentaPorLineaConstantesFunciones.quitarEspaciosVentaPorLineas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static VentaPorLinea getEntityVentaPorLinea(String strPrefijo,VentaPorLinea entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_producto(resultSet.getLong(strPrefijo+VentaPorLineaConstantesFunciones.IDPRODUCTO));
			entity.setid_linea(resultSet.getLong(strPrefijo+VentaPorLineaConstantesFunciones.IDLINEA));
			entity.setid_linea_grupo(resultSet.getLong(strPrefijo+VentaPorLineaConstantesFunciones.IDLINEAGRUPO));
			entity.setid_linea_categoria(resultSet.getLong(strPrefijo+VentaPorLineaConstantesFunciones.IDLINEACATEGORIA));
			entity.setid_linea_marca(resultSet.getLong(strPrefijo+VentaPorLineaConstantesFunciones.IDLINEAMARCA));
			entity.setnombre_producto(resultSet.getString(strPrefijo+VentaPorLineaConstantesFunciones.NOMBREPRODUCTO));
			entity.setnombre_linea(resultSet.getString(strPrefijo+VentaPorLineaConstantesFunciones.NOMBRELINEA));
			entity.setnombre_grupo(resultSet.getString(strPrefijo+VentaPorLineaConstantesFunciones.NOMBREGRUPO));
			entity.setnombre_categoria(resultSet.getString(strPrefijo+VentaPorLineaConstantesFunciones.NOMBRECATEGORIA));
			entity.setnombre_marca(resultSet.getString(strPrefijo+VentaPorLineaConstantesFunciones.NOMBREMARCA));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+VentaPorLineaConstantesFunciones.FECHA).getTime()));
			entity.setsecuencial(resultSet.getString(strPrefijo+VentaPorLineaConstantesFunciones.SECUENCIAL));
			entity.setcantidad(resultSet.getDouble(strPrefijo+VentaPorLineaConstantesFunciones.CANTIDAD));
			entity.setprecio(resultSet.getDouble(strPrefijo+VentaPorLineaConstantesFunciones.PRECIO));
			entity.setdescuento(resultSet.getDouble(strPrefijo+VentaPorLineaConstantesFunciones.DESCUENTO));
			entity.setiva(resultSet.getDouble(strPrefijo+VentaPorLineaConstantesFunciones.IVA));
			entity.setice(resultSet.getDouble(strPrefijo+VentaPorLineaConstantesFunciones.ICE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static VentaPorLinea getEntityVentaPorLinea(String strPrefijo,VentaPorLinea entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = VentaPorLinea.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = VentaPorLinea.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				VentaPorLineaLogic.setFieldReflectionVentaPorLinea(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVentaPorLinea(Field field,String strPrefijo,String sColumn,VentaPorLinea entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VentaPorLineaConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.IDLINEACATEGORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.IDLINEAMARCA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.NOMBRELINEA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.NOMBREGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.NOMBRECATEGORIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.NOMBREMARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VentaPorLineaConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VentaPorLineaConstantesFunciones.ICE:
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
	
	public void quitarVentaPorLineasNulos() throws Exception {				
		
		List<VentaPorLinea> ventaporlineasAux= new ArrayList<VentaPorLinea>();
		
		for(VentaPorLinea ventaporlinea:ventaporlineas) {
			if(ventaporlinea!=null) {
				ventaporlineasAux.add(ventaporlinea);
			}
		}
		
		ventaporlineas=ventaporlineasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<VentaPorLinea> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VentaPorLinea> entities = new  ArrayList<VentaPorLinea>();
		VentaPorLinea entity = new VentaPorLinea();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<VentaPorLinea>((List<VentaPorLinea>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setVentaPorLineasOriginal(entities);
			
			}  else {
				this.ventaporlineasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//VentaPorLineaConstantesFunciones.quitarEspaciosVentaPorLineas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		ventaporlineas = new  ArrayList<VentaPorLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VentaPorLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventaporlineas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		ventaporlineas = new  ArrayList<VentaPorLinea>();
		  		  
        try {
			//VentaPorLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventaporlineas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<VentaPorLinea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<VentaPorLinea> entities = new  ArrayList<VentaPorLinea>();
		VentaPorLinea entity = new VentaPorLinea();		  
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
	
	public  List<VentaPorLinea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<VentaPorLinea> entities = new  ArrayList<VentaPorLinea>();
		VentaPorLinea entity = new VentaPorLinea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VentaPorLinea();
				
				if(conMapGenerico) {
					entity.setMapVentaPorLinea( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapVentaPorLinea().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VentaPorLineaDataAccess.ISWITHSCHEMA);         		
					entity=VentaPorLineaLogic.getEntityVentaPorLinea("",entity,resultSet,listColumns);
					
					////entity.setVentaPorLineaOriginal( new VentaPorLinea());
					////entity.setVentaPorLineaOriginal(super.getEntity("",entity.getVentaPorLineaOriginal(),resultSet,VentaPorLineaDataAccess.ISWITHSCHEMA));         		
					////entity.setVentaPorLineaOriginal(VentaPorLineaDataAccess.getEntityVentaPorLinea("",entity.getVentaPorLineaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,VentaPorLinea relventaporlinea)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relventaporlinea.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,VentaPorLinea relventaporlinea)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relventaporlinea.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Producto getProducto(Connexion connexion,VentaPorLinea relventaporlinea)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relventaporlinea.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Linea getLinea(Connexion connexion,VentaPorLinea relventaporlinea)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relventaporlinea.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,VentaPorLinea relventaporlinea)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relventaporlinea.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,VentaPorLinea relventaporlinea)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relventaporlinea.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,VentaPorLinea relventaporlinea)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relventaporlinea.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getVentaPorLineasBusquedaVentaPorLineaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//VentaPorLineaLogic ventaporlineaLogic=new VentaPorLineaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=VentaPorLineaLogic.GetSelecSqlVentaPorLinea(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.ventaporlineas=this.getVentaPorLineas();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getVentaPorLineasBusquedaVentaPorLinea(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//VentaPorLineaLogic ventaporlineaLogic=new VentaPorLineaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=VentaPorLineaLogic.GetSelecSqlVentaPorLinea(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.ventaporlineas=this.getVentaPorLineas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlVentaPorLinea(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("VentaPorLinea_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" f.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" f.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
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
	
	
	public void deepLoad(VentaPorLinea ventaporlinea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VentaPorLineaLogicAdditional.updateVentaPorLineaToGet(ventaporlinea,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ventaporlinea.setEmpresa(ventaporlineaDataAccess.getEmpresa(connexion,ventaporlinea));
		ventaporlinea.setSucursal(ventaporlineaDataAccess.getSucursal(connexion,ventaporlinea));
		ventaporlinea.setProducto(ventaporlineaDataAccess.getProducto(connexion,ventaporlinea));
		ventaporlinea.setLinea(ventaporlineaDataAccess.getLinea(connexion,ventaporlinea));
		ventaporlinea.setLineaGrupo(ventaporlineaDataAccess.getLineaGrupo(connexion,ventaporlinea));
		ventaporlinea.setLineaCategoria(ventaporlineaDataAccess.getLineaCategoria(connexion,ventaporlinea));
		ventaporlinea.setLineaMarca(ventaporlineaDataAccess.getLineaMarca(connexion,ventaporlinea));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ventaporlinea.setEmpresa(ventaporlineaDataAccess.getEmpresa(connexion,ventaporlinea));
			}

			if(clas.clas.equals(Sucursal.class)) {
				ventaporlinea.setSucursal(ventaporlineaDataAccess.getSucursal(connexion,ventaporlinea));
			}

			if(clas.clas.equals(Producto.class)) {
				ventaporlinea.setProducto(ventaporlineaDataAccess.getProducto(connexion,ventaporlinea));
			}

			if(clas.clas.equals(Linea.class)) {
				ventaporlinea.setLinea(ventaporlineaDataAccess.getLinea(connexion,ventaporlinea));
			}

			if(clas.clas.equals(Linea.class)) {
				ventaporlinea.setLineaGrupo(ventaporlineaDataAccess.getLineaGrupo(connexion,ventaporlinea));
			}

			if(clas.clas.equals(Linea.class)) {
				ventaporlinea.setLineaCategoria(ventaporlineaDataAccess.getLineaCategoria(connexion,ventaporlinea));
			}

			if(clas.clas.equals(Linea.class)) {
				ventaporlinea.setLineaMarca(ventaporlineaDataAccess.getLineaMarca(connexion,ventaporlinea));
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
			ventaporlinea.setEmpresa(ventaporlineaDataAccess.getEmpresa(connexion,ventaporlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setSucursal(ventaporlineaDataAccess.getSucursal(connexion,ventaporlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setProducto(ventaporlineaDataAccess.getProducto(connexion,ventaporlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setLinea(ventaporlineaDataAccess.getLinea(connexion,ventaporlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setLineaGrupo(ventaporlineaDataAccess.getLineaGrupo(connexion,ventaporlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setLineaCategoria(ventaporlineaDataAccess.getLineaCategoria(connexion,ventaporlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setLineaMarca(ventaporlineaDataAccess.getLineaMarca(connexion,ventaporlinea));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ventaporlinea.setEmpresa(ventaporlineaDataAccess.getEmpresa(connexion,ventaporlinea));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ventaporlinea.getEmpresa(),isDeep,deepLoadType,clases);
				
		ventaporlinea.setSucursal(ventaporlineaDataAccess.getSucursal(connexion,ventaporlinea));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ventaporlinea.getSucursal(),isDeep,deepLoadType,clases);
				
		ventaporlinea.setProducto(ventaporlineaDataAccess.getProducto(connexion,ventaporlinea));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(ventaporlinea.getProducto(),isDeep,deepLoadType,clases);
				
		ventaporlinea.setLinea(ventaporlineaDataAccess.getLinea(connexion,ventaporlinea));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(ventaporlinea.getLinea(),isDeep,deepLoadType,clases);
				
		ventaporlinea.setLineaGrupo(ventaporlineaDataAccess.getLineaGrupo(connexion,ventaporlinea));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(ventaporlinea.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		ventaporlinea.setLineaCategoria(ventaporlineaDataAccess.getLineaCategoria(connexion,ventaporlinea));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(ventaporlinea.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		ventaporlinea.setLineaMarca(ventaporlineaDataAccess.getLineaMarca(connexion,ventaporlinea));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(ventaporlinea.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ventaporlinea.setEmpresa(ventaporlineaDataAccess.getEmpresa(connexion,ventaporlinea));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ventaporlinea.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				ventaporlinea.setSucursal(ventaporlineaDataAccess.getSucursal(connexion,ventaporlinea));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(ventaporlinea.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				ventaporlinea.setProducto(ventaporlineaDataAccess.getProducto(connexion,ventaporlinea));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(ventaporlinea.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				ventaporlinea.setLinea(ventaporlineaDataAccess.getLinea(connexion,ventaporlinea));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(ventaporlinea.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				ventaporlinea.setLineaGrupo(ventaporlineaDataAccess.getLineaGrupo(connexion,ventaporlinea));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(ventaporlinea.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				ventaporlinea.setLineaCategoria(ventaporlineaDataAccess.getLineaCategoria(connexion,ventaporlinea));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(ventaporlinea.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				ventaporlinea.setLineaMarca(ventaporlineaDataAccess.getLineaMarca(connexion,ventaporlinea));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(ventaporlinea.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			ventaporlinea.setEmpresa(ventaporlineaDataAccess.getEmpresa(connexion,ventaporlinea));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ventaporlinea.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setSucursal(ventaporlineaDataAccess.getSucursal(connexion,ventaporlinea));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(ventaporlinea.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setProducto(ventaporlineaDataAccess.getProducto(connexion,ventaporlinea));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(ventaporlinea.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setLinea(ventaporlineaDataAccess.getLinea(connexion,ventaporlinea));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(ventaporlinea.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setLineaGrupo(ventaporlineaDataAccess.getLineaGrupo(connexion,ventaporlinea));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(ventaporlinea.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setLineaCategoria(ventaporlineaDataAccess.getLineaCategoria(connexion,ventaporlinea));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(ventaporlinea.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventaporlinea.setLineaMarca(ventaporlineaDataAccess.getLineaMarca(connexion,ventaporlinea));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(ventaporlinea.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(ventaporlinea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VentaPorLineaConstantesFunciones.refrescarForeignKeysDescripcionesVentaPorLinea(ventaporlinea);
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
			this.deepLoad(this.ventaporlinea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VentaPorLineaConstantesFunciones.refrescarForeignKeysDescripcionesVentaPorLinea(this.ventaporlinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(ventaporlineas!=null) {
				for(VentaPorLinea ventaporlinea:ventaporlineas) {
					this.deepLoad(ventaporlinea,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VentaPorLineaConstantesFunciones.refrescarForeignKeysDescripcionesVentaPorLinea(ventaporlineas);
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
			if(ventaporlineas!=null) {
				for(VentaPorLinea ventaporlinea:ventaporlineas) {
					this.deepLoad(ventaporlinea,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VentaPorLineaConstantesFunciones.refrescarForeignKeysDescripcionesVentaPorLinea(ventaporlineas);
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
	
	public VentaPorLineaParameterReturnGeneral procesarAccionVentaPorLineas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VentaPorLinea> ventaporlineas,VentaPorLineaParameterReturnGeneral ventaporlineaParameterGeneral)throws Exception {
		 try {	
			VentaPorLineaParameterReturnGeneral ventaporlineaReturnGeneral=new VentaPorLineaParameterReturnGeneral();
	
			VentaPorLineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ventaporlineas,ventaporlineaParameterGeneral,ventaporlineaReturnGeneral);
			
			return ventaporlineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VentaPorLineaParameterReturnGeneral procesarAccionVentaPorLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VentaPorLinea> ventaporlineas,VentaPorLineaParameterReturnGeneral ventaporlineaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			VentaPorLineaParameterReturnGeneral ventaporlineaReturnGeneral=new VentaPorLineaParameterReturnGeneral();
	
			VentaPorLineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ventaporlineas,ventaporlineaParameterGeneral,ventaporlineaReturnGeneral);
			
			this.connexion.commit();
			
			return ventaporlineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

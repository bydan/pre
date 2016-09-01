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
import com.bydan.erp.activosfijos.util.report.DepreciacionesParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.DepreciacionesParameterGeneral;
import com.bydan.erp.activosfijos.util.report.DepreciacionesConstantesFunciones;
import com.bydan.erp.activosfijos.business.entity.report.Depreciaciones;

import com.bydan.erp.activosfijos.business.logic.report.DepreciacionesLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class DepreciacionesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(DepreciacionesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected DepreciacionesLogic depreciacionesDataAccess; 		
	protected Depreciaciones depreciaciones;
	protected List<Depreciaciones> depreciacioness;
	protected Object depreciacionesObject;	
	protected List<Object> depreciacionessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  DepreciacionesLogic()throws SQLException,Exception {
		try	{
			this.depreciacioness= new ArrayList<Depreciaciones>();
			this.depreciaciones= new Depreciaciones();
			this.depreciacionesObject=new Object();
			this.depreciacionessObject=new ArrayList<Object>();
			
			this.depreciacionesDataAccess=this;
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
			this.depreciacionesDataAccess.setConnexionType(this.connexionType);
			this.depreciacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.depreciacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DepreciacionesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.depreciacioness= new ArrayList<Depreciaciones>();
			this.depreciaciones= new Depreciaciones();
			this.depreciacionesObject=new Object();
			this.depreciacionessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.depreciacionesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.depreciacionesDataAccess.setConnexionType(this.connexionType);
			this.depreciacionesDataAccess.setParameterDbType(this.parameterDbType);
			this.depreciacionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Depreciaciones getDepreciaciones() throws Exception {	
		DepreciacionesLogicAdditional.checkDepreciacionesToGet(depreciaciones,this.datosCliente,this.arrDatoGeneral);
		DepreciacionesLogicAdditional.updateDepreciacionesToGet(depreciaciones,this.arrDatoGeneral);
		
		return depreciaciones;
	}
		
	public void setDepreciaciones(Depreciaciones newDepreciaciones) {
		this.depreciaciones = newDepreciaciones;
	}
	
	public List<Depreciaciones> getDepreciacioness() throws Exception {		
		this.quitarDepreciacionessNulos();
		
		DepreciacionesLogicAdditional.checkDepreciacionesToGets(depreciacioness,this.datosCliente,this.arrDatoGeneral);
		
		for (Depreciaciones depreciacionesLocal: depreciacioness ) {
			DepreciacionesLogicAdditional.updateDepreciacionesToGet(depreciacionesLocal,this.arrDatoGeneral);
		}
		
		return depreciacioness;
	}
	
	public void setDepreciacioness(List<Depreciaciones> newDepreciacioness) {
		this.depreciacioness = newDepreciacioness;
	}
	
	public Object getDepreciacionesObject() {	
		//this.depreciacionesObject=this.depreciacionesDataAccess.getEntityObject();
		return this.depreciacionesObject;
	}
		
	public void setDepreciacionesObject(Object newDepreciacionesObject) {
		this.depreciacionesObject = newDepreciacionesObject;
	}
	
	public List<Object> getDepreciacionessObject() {		
		//this.depreciacionessObject=this.depreciacionesDataAccess.getEntitiesObject();
		return this.depreciacionessObject;
	}
		
	public void setDepreciacionessObject(List<Object> newDepreciacionessObject) {
		this.depreciacionessObject = newDepreciacionessObject;
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
		depreciacioness = new  ArrayList<Depreciaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		depreciacioness = new  ArrayList<Depreciaciones>();
		  		  
        try {
			//DepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		depreciacioness = new  ArrayList<Depreciaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		depreciacioness = new  ArrayList<Depreciaciones>();
		  		  
        try {
			//DepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		depreciacioness = new  ArrayList<Depreciaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		depreciacioness = new  ArrayList<Depreciaciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//DepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<Depreciaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Depreciaciones> entities = new  ArrayList<Depreciaciones>();
		Depreciaciones entity = new Depreciaciones();		  
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
	
	public  List<Depreciaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Depreciaciones> entities = new  ArrayList<Depreciaciones>();
		Depreciaciones entity = new Depreciaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Depreciaciones();
				
				
      	    	entity=DepreciacionesLogic.getEntityDepreciaciones("",entity,resultSet);
      	    	
				//entity.setDepreciacionesOriginal( new Depreciaciones());
      	    	//entity.setDepreciacionesOriginal(super.getEntity("",entity.getDepreciacionesOriginal(),resultSet,DepreciacionesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDepreciacionesOriginal(DepreciacionesDataAccess.getEntityDepreciaciones("",entity.getDepreciacionesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<Depreciaciones> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Depreciaciones> entities = new  ArrayList<Depreciaciones>();
		Depreciaciones entity = new Depreciaciones();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,Depreciaciones.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<Depreciaciones>((List<Depreciaciones>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDepreciacionessOriginal(entities);
			
			}  else {
				this.depreciacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DepreciacionesConstantesFunciones.quitarEspaciosDepreciacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static Depreciaciones getEntityDepreciaciones(String strPrefijo,Depreciaciones entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_sub_grupo(resultSet.getString(strPrefijo+DepreciacionesConstantesFunciones.CODIGOSUBGRUPO));
			entity.setnombre_sub_grupo(resultSet.getString(strPrefijo+DepreciacionesConstantesFunciones.NOMBRESUBGRUPO));
			entity.setcodigo_detalle_grupo(resultSet.getString(strPrefijo+DepreciacionesConstantesFunciones.CODIGODETALLEGRUPO));
			entity.setnombre_detalle_grupo(resultSet.getString(strPrefijo+DepreciacionesConstantesFunciones.NOMBREDETALLEGRUPO));
			entity.setclave(resultSet.getString(strPrefijo+DepreciacionesConstantesFunciones.CLAVE));
			entity.setnombre(resultSet.getString(strPrefijo+DepreciacionesConstantesFunciones.NOMBRE));
			entity.setfecha_compra(new Date(resultSet.getDate(strPrefijo+DepreciacionesConstantesFunciones.FECHACOMPRA).getTime()));
			entity.setvida_util(resultSet.getDouble(strPrefijo+DepreciacionesConstantesFunciones.VIDAUTIL));
			entity.setcosto_de_compra(resultSet.getDouble(strPrefijo+DepreciacionesConstantesFunciones.COSTODECOMPRA));
			entity.setfecha_mantenimiento(new Date(resultSet.getDate(strPrefijo+DepreciacionesConstantesFunciones.FECHAMANTENIMIENTO).getTime()));
			entity.setfecha_depreciacion(new Date(resultSet.getDate(strPrefijo+DepreciacionesConstantesFunciones.FECHADEPRECIACION).getTime()));
			entity.setid_anio(resultSet.getLong(strPrefijo+DepreciacionesConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
			entity.setid_mes(resultSet.getLong(strPrefijo+DepreciacionesConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			entity.setvalor_acumulado(resultSet.getDouble(strPrefijo+DepreciacionesConstantesFunciones.VALORACUMULADO));
			entity.setvalor_gasto(resultSet.getDouble(strPrefijo+DepreciacionesConstantesFunciones.VALORGASTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Depreciaciones getEntityDepreciaciones(String strPrefijo,Depreciaciones entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = Depreciaciones.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = Depreciaciones.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				DepreciacionesLogic.setFieldReflectionDepreciaciones(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDepreciaciones(Field field,String strPrefijo,String sColumn,Depreciaciones entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DepreciacionesConstantesFunciones.CODIGOSUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.NOMBRESUBGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.CODIGODETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.NOMBREDETALLEGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.CLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.FECHACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DepreciacionesConstantesFunciones.VIDAUTIL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.COSTODECOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.FECHAMANTENIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DepreciacionesConstantesFunciones.FECHADEPRECIACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DepreciacionesConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.VALORACUMULADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DepreciacionesConstantesFunciones.VALORGASTO:
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
	
	public void quitarDepreciacionessNulos() throws Exception {				
		
		List<Depreciaciones> depreciacionessAux= new ArrayList<Depreciaciones>();
		
		for(Depreciaciones depreciaciones:depreciacioness) {
			if(depreciaciones!=null) {
				depreciacionessAux.add(depreciaciones);
			}
		}
		
		depreciacioness=depreciacionessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<Depreciaciones> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Depreciaciones> entities = new  ArrayList<Depreciaciones>();
		Depreciaciones entity = new Depreciaciones();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<Depreciaciones>((List<Depreciaciones>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDepreciacionessOriginal(entities);
			
			}  else {
				this.depreciacionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DepreciacionesConstantesFunciones.quitarEspaciosDepreciacioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		depreciacioness = new  ArrayList<Depreciaciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		depreciacioness = new  ArrayList<Depreciaciones>();
		  		  
        try {
			//DepreciacionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<Depreciaciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<Depreciaciones> entities = new  ArrayList<Depreciaciones>();
		Depreciaciones entity = new Depreciaciones();		  
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
	
	public  List<Depreciaciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<Depreciaciones> entities = new  ArrayList<Depreciaciones>();
		Depreciaciones entity = new Depreciaciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Depreciaciones();
				
				if(conMapGenerico) {
					entity.setMapDepreciaciones( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapDepreciaciones().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DepreciacionesDataAccess.ISWITHSCHEMA);         		
					entity=DepreciacionesLogic.getEntityDepreciaciones("",entity,resultSet,listColumns);
					
					////entity.setDepreciacionesOriginal( new Depreciaciones());
					////entity.setDepreciacionesOriginal(super.getEntity("",entity.getDepreciacionesOriginal(),resultSet,DepreciacionesDataAccess.ISWITHSCHEMA));         		
					////entity.setDepreciacionesOriginal(DepreciacionesDataAccess.getEntityDepreciaciones("",entity.getDepreciacionesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,Depreciaciones reldepreciaciones)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reldepreciaciones.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Anio getAnioInicio(Connexion connexion,Depreciaciones reldepreciaciones)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,reldepreciaciones.getid_anio_inicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Anio getAnioFin(Connexion connexion,Depreciaciones reldepreciaciones)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,reldepreciaciones.getid_anio_fin());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMesInicio(Connexion connexion,Depreciaciones reldepreciaciones)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);
			mesDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			mes=mesDataAccess.getEntity(connexion,reldepreciaciones.getid_mes_inicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Mes getMesFin(Connexion connexion,Depreciaciones reldepreciaciones)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);
			mesDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			mes=mesDataAccess.getEntity(connexion,reldepreciaciones.getid_mes_fin());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Anio getAnio(Connexion connexion,Depreciaciones reldepreciaciones)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,reldepreciaciones.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,Depreciaciones reldepreciaciones)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);
			mesDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			mes=mesDataAccess.getEntity(connexion,reldepreciaciones.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


	
	
	public void getDepreciacionessBusquedaDepreciacionesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio_inicio,Long id_anio_fin,Long id_mes_inicio,Long id_mes_fin)throws Exception {
		try {
			//DepreciacionesLogic depreciacionesLogic=new DepreciacionesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DepreciacionesLogic.GetSelecSqlDepreciaciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio_inicio,id_anio_fin,id_mes_inicio,id_mes_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.depreciacioness=this.getDepreciacioness();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getDepreciacionessBusquedaDepreciaciones(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio_inicio,Long id_anio_fin,Long id_mes_inicio,Long id_mes_fin)throws Exception {
		try {
			//DepreciacionesLogic depreciacionesLogic=new DepreciacionesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DepreciacionesLogic.GetSelecSqlDepreciaciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio_inicio,id_anio_fin,id_mes_inicio,id_mes_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.depreciacioness=this.getDepreciacioness();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlDepreciaciones(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio_inicio,Long id_anio_fin,Long id_mes_inicio,Long id_mes_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("Depreciaciones_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" d.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" d.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_anio_inicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_anio between "+id_anio_inicio.toString();
					existeWhere=true;
				}

				if(id_anio_fin!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=id_anio_fin.toString();
					existeWhere=true;
				}

				if(id_mes_inicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_mes between "+id_mes_inicio.toString();
					existeWhere=true;
				}

				if(id_mes_fin!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=id_mes_fin.toString();
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
	
	
	public void deepLoad(Depreciaciones depreciaciones,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DepreciacionesLogicAdditional.updateDepreciacionesToGet(depreciaciones,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		depreciaciones.setEmpresa(depreciacionesDataAccess.getEmpresa(connexion,depreciaciones));
		depreciaciones.setAnioInicio(depreciacionesDataAccess.getAnioInicio(connexion,depreciaciones));
		depreciaciones.setAnioFin(depreciacionesDataAccess.getAnioFin(connexion,depreciaciones));
		depreciaciones.setMesInicio(depreciacionesDataAccess.getMesInicio(connexion,depreciaciones));
		depreciaciones.setMesFin(depreciacionesDataAccess.getMesFin(connexion,depreciaciones));
		depreciaciones.setAnio(depreciacionesDataAccess.getAnio(connexion,depreciaciones));
		depreciaciones.setMes(depreciacionesDataAccess.getMes(connexion,depreciaciones));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				depreciaciones.setEmpresa(depreciacionesDataAccess.getEmpresa(connexion,depreciaciones));
			}

			if(clas.clas.equals(Anio.class)) {
				depreciaciones.setAnioInicio(depreciacionesDataAccess.getAnioInicio(connexion,depreciaciones));
			}

			if(clas.clas.equals(Anio.class)) {
				depreciaciones.setAnioFin(depreciacionesDataAccess.getAnioFin(connexion,depreciaciones));
			}

			if(clas.clas.equals(Mes.class)) {
				depreciaciones.setMesInicio(depreciacionesDataAccess.getMesInicio(connexion,depreciaciones));
			}

			if(clas.clas.equals(Mes.class)) {
				depreciaciones.setMesFin(depreciacionesDataAccess.getMesFin(connexion,depreciaciones));
			}

			if(clas.clas.equals(Anio.class)) {
				depreciaciones.setAnio(depreciacionesDataAccess.getAnio(connexion,depreciaciones));
			}

			if(clas.clas.equals(Mes.class)) {
				depreciaciones.setMes(depreciacionesDataAccess.getMes(connexion,depreciaciones));
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
			depreciaciones.setEmpresa(depreciacionesDataAccess.getEmpresa(connexion,depreciaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setAnioInicio(depreciacionesDataAccess.getAnioInicio(connexion,depreciaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setAnioFin(depreciacionesDataAccess.getAnioFin(connexion,depreciaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setMesInicio(depreciacionesDataAccess.getMesInicio(connexion,depreciaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setMesFin(depreciacionesDataAccess.getMesFin(connexion,depreciaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setAnio(depreciacionesDataAccess.getAnio(connexion,depreciaciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setMes(depreciacionesDataAccess.getMes(connexion,depreciaciones));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		depreciaciones.setEmpresa(depreciacionesDataAccess.getEmpresa(connexion,depreciaciones));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(depreciaciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		depreciaciones.setAnioInicio(depreciacionesDataAccess.getAnioInicio(connexion,depreciaciones));
		AnioLogic anioinicioLogic= new AnioLogic(connexion);
		anioinicioLogic.deepLoad(depreciaciones.getAnioInicio(),isDeep,deepLoadType,clases);
				
		depreciaciones.setAnioFin(depreciacionesDataAccess.getAnioFin(connexion,depreciaciones));
		AnioLogic aniofinLogic= new AnioLogic(connexion);
		aniofinLogic.deepLoad(depreciaciones.getAnioFin(),isDeep,deepLoadType,clases);
				
		depreciaciones.setMesInicio(depreciacionesDataAccess.getMesInicio(connexion,depreciaciones));
		MesLogic mesinicioLogic= new MesLogic(connexion);
		mesinicioLogic.deepLoad(depreciaciones.getMesInicio(),isDeep,deepLoadType,clases);
				
		depreciaciones.setMesFin(depreciacionesDataAccess.getMesFin(connexion,depreciaciones));
		MesLogic mesfinLogic= new MesLogic(connexion);
		mesfinLogic.deepLoad(depreciaciones.getMesFin(),isDeep,deepLoadType,clases);
				
		depreciaciones.setAnio(depreciacionesDataAccess.getAnio(connexion,depreciaciones));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(depreciaciones.getAnio(),isDeep,deepLoadType,clases);
				
		depreciaciones.setMes(depreciacionesDataAccess.getMes(connexion,depreciaciones));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(depreciaciones.getMes(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				depreciaciones.setEmpresa(depreciacionesDataAccess.getEmpresa(connexion,depreciaciones));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(depreciaciones.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Anio.class)) {
				depreciaciones.setAnioInicio(depreciacionesDataAccess.getAnioInicio(connexion,depreciaciones));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(depreciaciones.getAnioInicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Anio.class)) {
				depreciaciones.setAnioFin(depreciacionesDataAccess.getAnioFin(connexion,depreciaciones));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(depreciaciones.getAnioFin(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Mes.class)) {
				depreciaciones.setMesInicio(depreciacionesDataAccess.getMesInicio(connexion,depreciaciones));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(depreciaciones.getMesInicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Mes.class)) {
				depreciaciones.setMesFin(depreciacionesDataAccess.getMesFin(connexion,depreciaciones));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(depreciaciones.getMesFin(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Anio.class)) {
				depreciaciones.setAnio(depreciacionesDataAccess.getAnio(connexion,depreciaciones));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(depreciaciones.getAnio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Mes.class)) {
				depreciaciones.setMes(depreciacionesDataAccess.getMes(connexion,depreciaciones));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(depreciaciones.getMes(),isDeep,deepLoadType,clases);				
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
			depreciaciones.setEmpresa(depreciacionesDataAccess.getEmpresa(connexion,depreciaciones));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(depreciaciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setAnioInicio(depreciacionesDataAccess.getAnioInicio(connexion,depreciaciones));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(depreciaciones.getAnioInicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setAnioFin(depreciacionesDataAccess.getAnioFin(connexion,depreciaciones));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(depreciaciones.getAnioFin(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setMesInicio(depreciacionesDataAccess.getMesInicio(connexion,depreciaciones));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(depreciaciones.getMesInicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setMesFin(depreciacionesDataAccess.getMesFin(connexion,depreciaciones));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(depreciaciones.getMesFin(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setAnio(depreciacionesDataAccess.getAnio(connexion,depreciaciones));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(depreciaciones.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciaciones.setMes(depreciacionesDataAccess.getMes(connexion,depreciaciones));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(depreciaciones.getMes(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(depreciaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DepreciacionesConstantesFunciones.refrescarForeignKeysDescripcionesDepreciaciones(depreciaciones);
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
			this.deepLoad(this.depreciaciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DepreciacionesConstantesFunciones.refrescarForeignKeysDescripcionesDepreciaciones(this.depreciaciones);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(depreciacioness!=null) {
				for(Depreciaciones depreciaciones:depreciacioness) {
					this.deepLoad(depreciaciones,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DepreciacionesConstantesFunciones.refrescarForeignKeysDescripcionesDepreciaciones(depreciacioness);
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
			if(depreciacioness!=null) {
				for(Depreciaciones depreciaciones:depreciacioness) {
					this.deepLoad(depreciaciones,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DepreciacionesConstantesFunciones.refrescarForeignKeysDescripcionesDepreciaciones(depreciacioness);
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
	
	public DepreciacionesParameterReturnGeneral procesarAccionDepreciacioness(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Depreciaciones> depreciacioness,DepreciacionesParameterReturnGeneral depreciacionesParameterGeneral)throws Exception {
		 try {	
			DepreciacionesParameterReturnGeneral depreciacionesReturnGeneral=new DepreciacionesParameterReturnGeneral();
	
			DepreciacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,depreciacioness,depreciacionesParameterGeneral,depreciacionesReturnGeneral);
			
			return depreciacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DepreciacionesParameterReturnGeneral procesarAccionDepreciacionessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Depreciaciones> depreciacioness,DepreciacionesParameterReturnGeneral depreciacionesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			DepreciacionesParameterReturnGeneral depreciacionesReturnGeneral=new DepreciacionesParameterReturnGeneral();
	
			DepreciacionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,depreciacioness,depreciacionesParameterGeneral,depreciacionesReturnGeneral);
			
			this.connexion.commit();
			
			return depreciacionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

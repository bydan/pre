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
import com.bydan.erp.inventario.util.report.ConteosFisicosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ConteosFisicosParameterGeneral;
import com.bydan.erp.inventario.util.report.ConteosFisicosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ConteosFisicos;

import com.bydan.erp.inventario.business.logic.report.ConteosFisicosLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ConteosFisicosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ConteosFisicosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ConteosFisicosLogic conteosfisicosDataAccess; 		
	protected ConteosFisicos conteosfisicos;
	protected List<ConteosFisicos> conteosfisicoss;
	protected Object conteosfisicosObject;	
	protected List<Object> conteosfisicossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ConteosFisicosLogic()throws SQLException,Exception {
		try	{
			this.conteosfisicoss= new ArrayList<ConteosFisicos>();
			this.conteosfisicos= new ConteosFisicos();
			this.conteosfisicosObject=new Object();
			this.conteosfisicossObject=new ArrayList<Object>();
			
			this.conteosfisicosDataAccess=this;
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
			this.conteosfisicosDataAccess.setConnexionType(this.connexionType);
			this.conteosfisicosDataAccess.setParameterDbType(this.parameterDbType);
			this.conteosfisicosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConteosFisicosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.conteosfisicoss= new ArrayList<ConteosFisicos>();
			this.conteosfisicos= new ConteosFisicos();
			this.conteosfisicosObject=new Object();
			this.conteosfisicossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.conteosfisicosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.conteosfisicosDataAccess.setConnexionType(this.connexionType);
			this.conteosfisicosDataAccess.setParameterDbType(this.parameterDbType);
			this.conteosfisicosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ConteosFisicos getConteosFisicos() throws Exception {	
		ConteosFisicosLogicAdditional.checkConteosFisicosToGet(conteosfisicos,this.datosCliente,this.arrDatoGeneral);
		ConteosFisicosLogicAdditional.updateConteosFisicosToGet(conteosfisicos,this.arrDatoGeneral);
		
		return conteosfisicos;
	}
		
	public void setConteosFisicos(ConteosFisicos newConteosFisicos) {
		this.conteosfisicos = newConteosFisicos;
	}
	
	public List<ConteosFisicos> getConteosFisicoss() throws Exception {		
		this.quitarConteosFisicossNulos();
		
		ConteosFisicosLogicAdditional.checkConteosFisicosToGets(conteosfisicoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ConteosFisicos conteosfisicosLocal: conteosfisicoss ) {
			ConteosFisicosLogicAdditional.updateConteosFisicosToGet(conteosfisicosLocal,this.arrDatoGeneral);
		}
		
		return conteosfisicoss;
	}
	
	public void setConteosFisicoss(List<ConteosFisicos> newConteosFisicoss) {
		this.conteosfisicoss = newConteosFisicoss;
	}
	
	public Object getConteosFisicosObject() {	
		//this.conteosfisicosObject=this.conteosfisicosDataAccess.getEntityObject();
		return this.conteosfisicosObject;
	}
		
	public void setConteosFisicosObject(Object newConteosFisicosObject) {
		this.conteosfisicosObject = newConteosFisicosObject;
	}
	
	public List<Object> getConteosFisicossObject() {		
		//this.conteosfisicossObject=this.conteosfisicosDataAccess.getEntitiesObject();
		return this.conteosfisicossObject;
	}
		
	public void setConteosFisicossObject(List<Object> newConteosFisicossObject) {
		this.conteosfisicossObject = newConteosFisicossObject;
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
		conteosfisicoss = new  ArrayList<ConteosFisicos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConteosFisicosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conteosfisicoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		conteosfisicoss = new  ArrayList<ConteosFisicos>();
		  		  
        try {
			//ConteosFisicosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conteosfisicoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conteosfisicoss = new  ArrayList<ConteosFisicos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConteosFisicosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conteosfisicoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		conteosfisicoss = new  ArrayList<ConteosFisicos>();
		  		  
        try {
			//ConteosFisicosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conteosfisicoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		conteosfisicoss = new  ArrayList<ConteosFisicos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConteosFisicosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conteosfisicoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		conteosfisicoss = new  ArrayList<ConteosFisicos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ConteosFisicosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conteosfisicoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ConteosFisicos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConteosFisicos> entities = new  ArrayList<ConteosFisicos>();
		ConteosFisicos entity = new ConteosFisicos();		  
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
	
	public  List<ConteosFisicos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConteosFisicos> entities = new  ArrayList<ConteosFisicos>();
		ConteosFisicos entity = new ConteosFisicos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConteosFisicos();
				
				
      	    	entity=ConteosFisicosLogic.getEntityConteosFisicos("",entity,resultSet);
      	    	
				//entity.setConteosFisicosOriginal( new ConteosFisicos());
      	    	//entity.setConteosFisicosOriginal(super.getEntity("",entity.getConteosFisicosOriginal(),resultSet,ConteosFisicosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConteosFisicosOriginal(ConteosFisicosDataAccess.getEntityConteosFisicos("",entity.getConteosFisicosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ConteosFisicos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConteosFisicos> entities = new  ArrayList<ConteosFisicos>();
		ConteosFisicos entity = new ConteosFisicos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ConteosFisicos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConteosFisicos>((List<ConteosFisicos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConteosFisicossOriginal(entities);
			
			}  else {
				this.conteosfisicossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConteosFisicosConstantesFunciones.quitarEspaciosConteosFisicoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ConteosFisicos getEntityConteosFisicos(String strPrefijo,ConteosFisicos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ConteosFisicosConstantesFunciones.CODIGO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ConteosFisicosConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad_disponible(resultSet.getInt(strPrefijo+ConteosFisicosConstantesFunciones.CANTIDADDISPONIBLE));
			entity.setcantidad_fisica(resultSet.getInt(strPrefijo+ConteosFisicosConstantesFunciones.CANTIDADFISICA));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+ConteosFisicosConstantesFunciones.CODIGOPRODUCTO));
			entity.setnombre(resultSet.getString(strPrefijo+ConteosFisicosConstantesFunciones.NOMBRE));
			entity.setingresos(resultSet.getDouble(strPrefijo+ConteosFisicosConstantesFunciones.INGRESOS));
			entity.setegresos(resultSet.getDouble(strPrefijo+ConteosFisicosConstantesFunciones.EGRESOS));
			entity.setexistencia_corte(resultSet.getDouble(strPrefijo+ConteosFisicosConstantesFunciones.EXISTENCIACORTE));
			entity.setcosto(resultSet.getDouble(strPrefijo+ConteosFisicosConstantesFunciones.COSTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ConteosFisicos getEntityConteosFisicos(String strPrefijo,ConteosFisicos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ConteosFisicos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ConteosFisicos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ConteosFisicosLogic.setFieldReflectionConteosFisicos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionConteosFisicos(Field field,String strPrefijo,String sColumn,ConteosFisicos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ConteosFisicosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConteosFisicosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConteosFisicosConstantesFunciones.CANTIDADDISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ConteosFisicosConstantesFunciones.CANTIDADFISICA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ConteosFisicosConstantesFunciones.CODIGOPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConteosFisicosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConteosFisicosConstantesFunciones.INGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConteosFisicosConstantesFunciones.EGRESOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConteosFisicosConstantesFunciones.EXISTENCIACORTE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConteosFisicosConstantesFunciones.COSTO:
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
	
	public void quitarConteosFisicossNulos() throws Exception {				
		
		List<ConteosFisicos> conteosfisicossAux= new ArrayList<ConteosFisicos>();
		
		for(ConteosFisicos conteosfisicos:conteosfisicoss) {
			if(conteosfisicos!=null) {
				conteosfisicossAux.add(conteosfisicos);
			}
		}
		
		conteosfisicoss=conteosfisicossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ConteosFisicos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConteosFisicos> entities = new  ArrayList<ConteosFisicos>();
		ConteosFisicos entity = new ConteosFisicos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ConteosFisicos>((List<ConteosFisicos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setConteosFisicossOriginal(entities);
			
			}  else {
				this.conteosfisicossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ConteosFisicosConstantesFunciones.quitarEspaciosConteosFisicoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		conteosfisicoss = new  ArrayList<ConteosFisicos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ConteosFisicosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conteosfisicoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		conteosfisicoss = new  ArrayList<ConteosFisicos>();
		  		  
        try {
			//ConteosFisicosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conteosfisicoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ConteosFisicos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConteosFisicos> entities = new  ArrayList<ConteosFisicos>();
		ConteosFisicos entity = new ConteosFisicos();		  
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
	
	public  List<ConteosFisicos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConteosFisicos> entities = new  ArrayList<ConteosFisicos>();
		ConteosFisicos entity = new ConteosFisicos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConteosFisicos();
				
				if(conMapGenerico) {
					entity.setMapConteosFisicos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapConteosFisicos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConteosFisicosDataAccess.ISWITHSCHEMA);         		
					entity=ConteosFisicosLogic.getEntityConteosFisicos("",entity,resultSet,listColumns);
					
					////entity.setConteosFisicosOriginal( new ConteosFisicos());
					////entity.setConteosFisicosOriginal(super.getEntity("",entity.getConteosFisicosOriginal(),resultSet,ConteosFisicosDataAccess.ISWITHSCHEMA));         		
					////entity.setConteosFisicosOriginal(ConteosFisicosDataAccess.getEntityConteosFisicos("",entity.getConteosFisicosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,ConteosFisicos relconteosfisicos)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relconteosfisicos.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ConteosFisicos relconteosfisicos)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relconteosfisicos.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,ConteosFisicos relconteosfisicos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relconteosfisicos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ConteosFisicos relconteosfisicos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relconteosfisicos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,ConteosFisicos relconteosfisicos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relconteosfisicos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ConteosFisicos relconteosfisicos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relconteosfisicos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ConteosFisicos relconteosfisicos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relconteosfisicos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ConteosFisicos relconteosfisicos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relconteosfisicos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getConteosFisicossBusquedaConteosFisicosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//ConteosFisicosLogic conteosfisicosLogic=new ConteosFisicosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConteosFisicosLogic.GetSelecSqlConteosFisicos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.conteosfisicoss=this.getConteosFisicoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getConteosFisicossBusquedaConteosFisicos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//ConteosFisicosLogic conteosfisicosLogic=new ConteosFisicosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ConteosFisicosLogic.GetSelecSqlConteosFisicos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.conteosfisicoss=this.getConteosFisicoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlConteosFisicos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ConteosFisicos_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_bodega!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_bodega = "+id_bodega.toString();
					existeWhere=true;
				}

				if(id_producto!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_producto = "+id_producto.toString();
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

				if(fecha_ultima_venta_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.fecha_ultima_venta<="+"'"+Funciones2.getStringPostgresDate(fecha_ultima_venta_hasta)+"'";
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
	
	
	public void deepLoad(ConteosFisicos conteosfisicos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConteosFisicosLogicAdditional.updateConteosFisicosToGet(conteosfisicos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conteosfisicos.setBodega(conteosfisicosDataAccess.getBodega(connexion,conteosfisicos));
		conteosfisicos.setProducto(conteosfisicosDataAccess.getProducto(connexion,conteosfisicos));
		conteosfisicos.setEmpresa(conteosfisicosDataAccess.getEmpresa(connexion,conteosfisicos));
		conteosfisicos.setSucursal(conteosfisicosDataAccess.getSucursal(connexion,conteosfisicos));
		conteosfisicos.setLinea(conteosfisicosDataAccess.getLinea(connexion,conteosfisicos));
		conteosfisicos.setLineaGrupo(conteosfisicosDataAccess.getLineaGrupo(connexion,conteosfisicos));
		conteosfisicos.setLineaCategoria(conteosfisicosDataAccess.getLineaCategoria(connexion,conteosfisicos));
		conteosfisicos.setLineaMarca(conteosfisicosDataAccess.getLineaMarca(connexion,conteosfisicos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				conteosfisicos.setBodega(conteosfisicosDataAccess.getBodega(connexion,conteosfisicos));
			}

			if(clas.clas.equals(Producto.class)) {
				conteosfisicos.setProducto(conteosfisicosDataAccess.getProducto(connexion,conteosfisicos));
			}

			if(clas.clas.equals(Empresa.class)) {
				conteosfisicos.setEmpresa(conteosfisicosDataAccess.getEmpresa(connexion,conteosfisicos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				conteosfisicos.setSucursal(conteosfisicosDataAccess.getSucursal(connexion,conteosfisicos));
			}

			if(clas.clas.equals(Linea.class)) {
				conteosfisicos.setLinea(conteosfisicosDataAccess.getLinea(connexion,conteosfisicos));
			}

			if(clas.clas.equals(Linea.class)) {
				conteosfisicos.setLineaGrupo(conteosfisicosDataAccess.getLineaGrupo(connexion,conteosfisicos));
			}

			if(clas.clas.equals(Linea.class)) {
				conteosfisicos.setLineaCategoria(conteosfisicosDataAccess.getLineaCategoria(connexion,conteosfisicos));
			}

			if(clas.clas.equals(Linea.class)) {
				conteosfisicos.setLineaMarca(conteosfisicosDataAccess.getLineaMarca(connexion,conteosfisicos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setBodega(conteosfisicosDataAccess.getBodega(connexion,conteosfisicos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setProducto(conteosfisicosDataAccess.getProducto(connexion,conteosfisicos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setEmpresa(conteosfisicosDataAccess.getEmpresa(connexion,conteosfisicos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setSucursal(conteosfisicosDataAccess.getSucursal(connexion,conteosfisicos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setLinea(conteosfisicosDataAccess.getLinea(connexion,conteosfisicos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setLineaGrupo(conteosfisicosDataAccess.getLineaGrupo(connexion,conteosfisicos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setLineaCategoria(conteosfisicosDataAccess.getLineaCategoria(connexion,conteosfisicos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setLineaMarca(conteosfisicosDataAccess.getLineaMarca(connexion,conteosfisicos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conteosfisicos.setBodega(conteosfisicosDataAccess.getBodega(connexion,conteosfisicos));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(conteosfisicos.getBodega(),isDeep,deepLoadType,clases);
				
		conteosfisicos.setProducto(conteosfisicosDataAccess.getProducto(connexion,conteosfisicos));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(conteosfisicos.getProducto(),isDeep,deepLoadType,clases);
				
		conteosfisicos.setEmpresa(conteosfisicosDataAccess.getEmpresa(connexion,conteosfisicos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(conteosfisicos.getEmpresa(),isDeep,deepLoadType,clases);
				
		conteosfisicos.setSucursal(conteosfisicosDataAccess.getSucursal(connexion,conteosfisicos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(conteosfisicos.getSucursal(),isDeep,deepLoadType,clases);
				
		conteosfisicos.setLinea(conteosfisicosDataAccess.getLinea(connexion,conteosfisicos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(conteosfisicos.getLinea(),isDeep,deepLoadType,clases);
				
		conteosfisicos.setLineaGrupo(conteosfisicosDataAccess.getLineaGrupo(connexion,conteosfisicos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(conteosfisicos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		conteosfisicos.setLineaCategoria(conteosfisicosDataAccess.getLineaCategoria(connexion,conteosfisicos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(conteosfisicos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		conteosfisicos.setLineaMarca(conteosfisicosDataAccess.getLineaMarca(connexion,conteosfisicos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(conteosfisicos.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				conteosfisicos.setBodega(conteosfisicosDataAccess.getBodega(connexion,conteosfisicos));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(conteosfisicos.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				conteosfisicos.setProducto(conteosfisicosDataAccess.getProducto(connexion,conteosfisicos));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(conteosfisicos.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				conteosfisicos.setEmpresa(conteosfisicosDataAccess.getEmpresa(connexion,conteosfisicos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(conteosfisicos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				conteosfisicos.setSucursal(conteosfisicosDataAccess.getSucursal(connexion,conteosfisicos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(conteosfisicos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				conteosfisicos.setLinea(conteosfisicosDataAccess.getLinea(connexion,conteosfisicos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(conteosfisicos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				conteosfisicos.setLineaGrupo(conteosfisicosDataAccess.getLineaGrupo(connexion,conteosfisicos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(conteosfisicos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				conteosfisicos.setLineaCategoria(conteosfisicosDataAccess.getLineaCategoria(connexion,conteosfisicos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(conteosfisicos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				conteosfisicos.setLineaMarca(conteosfisicosDataAccess.getLineaMarca(connexion,conteosfisicos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(conteosfisicos.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setBodega(conteosfisicosDataAccess.getBodega(connexion,conteosfisicos));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(conteosfisicos.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setProducto(conteosfisicosDataAccess.getProducto(connexion,conteosfisicos));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(conteosfisicos.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setEmpresa(conteosfisicosDataAccess.getEmpresa(connexion,conteosfisicos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(conteosfisicos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setSucursal(conteosfisicosDataAccess.getSucursal(connexion,conteosfisicos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(conteosfisicos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setLinea(conteosfisicosDataAccess.getLinea(connexion,conteosfisicos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(conteosfisicos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setLineaGrupo(conteosfisicosDataAccess.getLineaGrupo(connexion,conteosfisicos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(conteosfisicos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setLineaCategoria(conteosfisicosDataAccess.getLineaCategoria(connexion,conteosfisicos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(conteosfisicos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conteosfisicos.setLineaMarca(conteosfisicosDataAccess.getLineaMarca(connexion,conteosfisicos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(conteosfisicos.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(conteosfisicos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConteosFisicosConstantesFunciones.refrescarForeignKeysDescripcionesConteosFisicos(conteosfisicos);
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
			this.deepLoad(this.conteosfisicos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConteosFisicosConstantesFunciones.refrescarForeignKeysDescripcionesConteosFisicos(this.conteosfisicos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(conteosfisicoss!=null) {
				for(ConteosFisicos conteosfisicos:conteosfisicoss) {
					this.deepLoad(conteosfisicos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConteosFisicosConstantesFunciones.refrescarForeignKeysDescripcionesConteosFisicos(conteosfisicoss);
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
			if(conteosfisicoss!=null) {
				for(ConteosFisicos conteosfisicos:conteosfisicoss) {
					this.deepLoad(conteosfisicos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConteosFisicosConstantesFunciones.refrescarForeignKeysDescripcionesConteosFisicos(conteosfisicoss);
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
	
	public ConteosFisicosParameterReturnGeneral procesarAccionConteosFisicoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConteosFisicos> conteosfisicoss,ConteosFisicosParameterReturnGeneral conteosfisicosParameterGeneral)throws Exception {
		 try {	
			ConteosFisicosParameterReturnGeneral conteosfisicosReturnGeneral=new ConteosFisicosParameterReturnGeneral();
	
			ConteosFisicosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conteosfisicoss,conteosfisicosParameterGeneral,conteosfisicosReturnGeneral);
			
			return conteosfisicosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConteosFisicosParameterReturnGeneral procesarAccionConteosFisicossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConteosFisicos> conteosfisicoss,ConteosFisicosParameterReturnGeneral conteosfisicosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ConteosFisicosParameterReturnGeneral conteosfisicosReturnGeneral=new ConteosFisicosParameterReturnGeneral();
	
			ConteosFisicosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conteosfisicoss,conteosfisicosParameterGeneral,conteosfisicosReturnGeneral);
			
			this.connexion.commit();
			
			return conteosfisicosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

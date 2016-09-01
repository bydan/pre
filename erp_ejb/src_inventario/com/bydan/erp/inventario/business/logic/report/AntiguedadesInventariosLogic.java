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
import com.bydan.erp.inventario.util.report.AntiguedadesInventariosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.AntiguedadesInventariosParameterGeneral;
import com.bydan.erp.inventario.util.report.AntiguedadesInventariosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.AntiguedadesInventarios;

import com.bydan.erp.inventario.business.logic.report.AntiguedadesInventariosLogicAdditional;
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
public class AntiguedadesInventariosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(AntiguedadesInventariosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected AntiguedadesInventariosLogic antiguedadesinventariosDataAccess; 		
	protected AntiguedadesInventarios antiguedadesinventarios;
	protected List<AntiguedadesInventarios> antiguedadesinventarioss;
	protected Object antiguedadesinventariosObject;	
	protected List<Object> antiguedadesinventariossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  AntiguedadesInventariosLogic()throws SQLException,Exception {
		try	{
			this.antiguedadesinventarioss= new ArrayList<AntiguedadesInventarios>();
			this.antiguedadesinventarios= new AntiguedadesInventarios();
			this.antiguedadesinventariosObject=new Object();
			this.antiguedadesinventariossObject=new ArrayList<Object>();
			
			this.antiguedadesinventariosDataAccess=this;
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
			this.antiguedadesinventariosDataAccess.setConnexionType(this.connexionType);
			this.antiguedadesinventariosDataAccess.setParameterDbType(this.parameterDbType);
			this.antiguedadesinventariosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AntiguedadesInventariosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.antiguedadesinventarioss= new ArrayList<AntiguedadesInventarios>();
			this.antiguedadesinventarios= new AntiguedadesInventarios();
			this.antiguedadesinventariosObject=new Object();
			this.antiguedadesinventariossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.antiguedadesinventariosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.antiguedadesinventariosDataAccess.setConnexionType(this.connexionType);
			this.antiguedadesinventariosDataAccess.setParameterDbType(this.parameterDbType);
			this.antiguedadesinventariosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AntiguedadesInventarios getAntiguedadesInventarios() throws Exception {	
		AntiguedadesInventariosLogicAdditional.checkAntiguedadesInventariosToGet(antiguedadesinventarios,this.datosCliente,this.arrDatoGeneral);
		AntiguedadesInventariosLogicAdditional.updateAntiguedadesInventariosToGet(antiguedadesinventarios,this.arrDatoGeneral);
		
		return antiguedadesinventarios;
	}
		
	public void setAntiguedadesInventarios(AntiguedadesInventarios newAntiguedadesInventarios) {
		this.antiguedadesinventarios = newAntiguedadesInventarios;
	}
	
	public List<AntiguedadesInventarios> getAntiguedadesInventarioss() throws Exception {		
		this.quitarAntiguedadesInventariossNulos();
		
		AntiguedadesInventariosLogicAdditional.checkAntiguedadesInventariosToGets(antiguedadesinventarioss,this.datosCliente,this.arrDatoGeneral);
		
		for (AntiguedadesInventarios antiguedadesinventariosLocal: antiguedadesinventarioss ) {
			AntiguedadesInventariosLogicAdditional.updateAntiguedadesInventariosToGet(antiguedadesinventariosLocal,this.arrDatoGeneral);
		}
		
		return antiguedadesinventarioss;
	}
	
	public void setAntiguedadesInventarioss(List<AntiguedadesInventarios> newAntiguedadesInventarioss) {
		this.antiguedadesinventarioss = newAntiguedadesInventarioss;
	}
	
	public Object getAntiguedadesInventariosObject() {	
		//this.antiguedadesinventariosObject=this.antiguedadesinventariosDataAccess.getEntityObject();
		return this.antiguedadesinventariosObject;
	}
		
	public void setAntiguedadesInventariosObject(Object newAntiguedadesInventariosObject) {
		this.antiguedadesinventariosObject = newAntiguedadesInventariosObject;
	}
	
	public List<Object> getAntiguedadesInventariossObject() {		
		//this.antiguedadesinventariossObject=this.antiguedadesinventariosDataAccess.getEntitiesObject();
		return this.antiguedadesinventariossObject;
	}
		
	public void setAntiguedadesInventariossObject(List<Object> newAntiguedadesInventariossObject) {
		this.antiguedadesinventariossObject = newAntiguedadesInventariossObject;
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
		antiguedadesinventarioss = new  ArrayList<AntiguedadesInventarios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//AntiguedadesInventariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			antiguedadesinventarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		antiguedadesinventarioss = new  ArrayList<AntiguedadesInventarios>();
		  		  
        try {
			//AntiguedadesInventariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			antiguedadesinventarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		antiguedadesinventarioss = new  ArrayList<AntiguedadesInventarios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//AntiguedadesInventariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			antiguedadesinventarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		antiguedadesinventarioss = new  ArrayList<AntiguedadesInventarios>();
		  		  
        try {
			//AntiguedadesInventariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			antiguedadesinventarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		antiguedadesinventarioss = new  ArrayList<AntiguedadesInventarios>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//AntiguedadesInventariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			antiguedadesinventarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		antiguedadesinventarioss = new  ArrayList<AntiguedadesInventarios>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//AntiguedadesInventariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			antiguedadesinventarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<AntiguedadesInventarios> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AntiguedadesInventarios> entities = new  ArrayList<AntiguedadesInventarios>();
		AntiguedadesInventarios entity = new AntiguedadesInventarios();		  
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
	
	public  List<AntiguedadesInventarios> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AntiguedadesInventarios> entities = new  ArrayList<AntiguedadesInventarios>();
		AntiguedadesInventarios entity = new AntiguedadesInventarios();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AntiguedadesInventarios();
				
				
      	    	entity=AntiguedadesInventariosLogic.getEntityAntiguedadesInventarios("",entity,resultSet);
      	    	
				//entity.setAntiguedadesInventariosOriginal( new AntiguedadesInventarios());
      	    	//entity.setAntiguedadesInventariosOriginal(super.getEntity("",entity.getAntiguedadesInventariosOriginal(),resultSet,AntiguedadesInventariosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAntiguedadesInventariosOriginal(AntiguedadesInventariosDataAccess.getEntityAntiguedadesInventarios("",entity.getAntiguedadesInventariosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<AntiguedadesInventarios> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AntiguedadesInventarios> entities = new  ArrayList<AntiguedadesInventarios>();
		AntiguedadesInventarios entity = new AntiguedadesInventarios();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,AntiguedadesInventarios.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<AntiguedadesInventarios>((List<AntiguedadesInventarios>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setAntiguedadesInventariossOriginal(entities);
			
			}  else {
				this.antiguedadesinventariossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//AntiguedadesInventariosConstantesFunciones.quitarEspaciosAntiguedadesInventarioss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static AntiguedadesInventarios getEntityAntiguedadesInventarios(String strPrefijo,AntiguedadesInventarios entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_sucursal(resultSet.getString(strPrefijo+AntiguedadesInventariosConstantesFunciones.NOMBRESUCURSAL));
			entity.setnombre_linea(resultSet.getString(strPrefijo+AntiguedadesInventariosConstantesFunciones.NOMBRELINEA));
			entity.setnombre_linea_grupo(resultSet.getString(strPrefijo+AntiguedadesInventariosConstantesFunciones.NOMBRELINEAGRUPO));
			entity.setnombre_linea_categoria(resultSet.getString(strPrefijo+AntiguedadesInventariosConstantesFunciones.NOMBRELINEACATEGORIA));
			entity.setnombre_linea_marca(resultSet.getString(strPrefijo+AntiguedadesInventariosConstantesFunciones.NOMBRELINEAMARCA));
			entity.setcodigo(resultSet.getString(strPrefijo+AntiguedadesInventariosConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+AntiguedadesInventariosConstantesFunciones.NOMBRE));
			entity.setnombre_bodega(resultSet.getString(strPrefijo+AntiguedadesInventariosConstantesFunciones.NOMBREBODEGA));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+AntiguedadesInventariosConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad_disponible(resultSet.getInt(strPrefijo+AntiguedadesInventariosConstantesFunciones.CANTIDADDISPONIBLE));
			entity.setfecha_ultima_compra(new Date(resultSet.getDate(strPrefijo+AntiguedadesInventariosConstantesFunciones.FECHAULTIMACOMPRA).getTime()));
			entity.setfecha_ultima_venta(new Date(resultSet.getDate(strPrefijo+AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTA).getTime()));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AntiguedadesInventarios getEntityAntiguedadesInventarios(String strPrefijo,AntiguedadesInventarios entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = AntiguedadesInventarios.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = AntiguedadesInventarios.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				AntiguedadesInventariosLogic.setFieldReflectionAntiguedadesInventarios(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAntiguedadesInventarios(Field field,String strPrefijo,String sColumn,AntiguedadesInventarios entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AntiguedadesInventariosConstantesFunciones.NOMBRESUCURSAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.NOMBRELINEA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.NOMBRELINEAGRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.NOMBRELINEACATEGORIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.NOMBRELINEAMARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.NOMBREBODEGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.CANTIDADDISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.FECHAULTIMACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	public void quitarAntiguedadesInventariossNulos() throws Exception {				
		
		List<AntiguedadesInventarios> antiguedadesinventariossAux= new ArrayList<AntiguedadesInventarios>();
		
		for(AntiguedadesInventarios antiguedadesinventarios:antiguedadesinventarioss) {
			if(antiguedadesinventarios!=null) {
				antiguedadesinventariossAux.add(antiguedadesinventarios);
			}
		}
		
		antiguedadesinventarioss=antiguedadesinventariossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<AntiguedadesInventarios> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AntiguedadesInventarios> entities = new  ArrayList<AntiguedadesInventarios>();
		AntiguedadesInventarios entity = new AntiguedadesInventarios();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<AntiguedadesInventarios>((List<AntiguedadesInventarios>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setAntiguedadesInventariossOriginal(entities);
			
			}  else {
				this.antiguedadesinventariossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//AntiguedadesInventariosConstantesFunciones.quitarEspaciosAntiguedadesInventarioss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		antiguedadesinventarioss = new  ArrayList<AntiguedadesInventarios>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//AntiguedadesInventariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			antiguedadesinventarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		antiguedadesinventarioss = new  ArrayList<AntiguedadesInventarios>();
		  		  
        try {
			//AntiguedadesInventariosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			antiguedadesinventarioss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<AntiguedadesInventarios> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<AntiguedadesInventarios> entities = new  ArrayList<AntiguedadesInventarios>();
		AntiguedadesInventarios entity = new AntiguedadesInventarios();		  
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
	
	public  List<AntiguedadesInventarios> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<AntiguedadesInventarios> entities = new  ArrayList<AntiguedadesInventarios>();
		AntiguedadesInventarios entity = new AntiguedadesInventarios();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AntiguedadesInventarios();
				
				if(conMapGenerico) {
					entity.setMapAntiguedadesInventarios( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapAntiguedadesInventarios().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AntiguedadesInventariosDataAccess.ISWITHSCHEMA);         		
					entity=AntiguedadesInventariosLogic.getEntityAntiguedadesInventarios("",entity,resultSet,listColumns);
					
					////entity.setAntiguedadesInventariosOriginal( new AntiguedadesInventarios());
					////entity.setAntiguedadesInventariosOriginal(super.getEntity("",entity.getAntiguedadesInventariosOriginal(),resultSet,AntiguedadesInventariosDataAccess.ISWITHSCHEMA));         		
					////entity.setAntiguedadesInventariosOriginal(AntiguedadesInventariosDataAccess.getEntityAntiguedadesInventarios("",entity.getAntiguedadesInventariosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,AntiguedadesInventarios relantiguedadesinventarios)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relantiguedadesinventarios.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Empresa getEmpresa(Connexion connexion,AntiguedadesInventarios relantiguedadesinventarios)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relantiguedadesinventarios.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,AntiguedadesInventarios relantiguedadesinventarios)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relantiguedadesinventarios.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,AntiguedadesInventarios relantiguedadesinventarios)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relantiguedadesinventarios.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,AntiguedadesInventarios relantiguedadesinventarios)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relantiguedadesinventarios.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,AntiguedadesInventarios relantiguedadesinventarios)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relantiguedadesinventarios.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,AntiguedadesInventarios relantiguedadesinventarios)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relantiguedadesinventarios.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getAntiguedadesInventariossBusquedaAntiguedadesInventariosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//AntiguedadesInventariosLogic antiguedadesinventariosLogic=new AntiguedadesInventariosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=AntiguedadesInventariosLogic.GetSelecSqlAntiguedadesInventarios(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.antiguedadesinventarioss=this.getAntiguedadesInventarioss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getAntiguedadesInventariossBusquedaAntiguedadesInventarios(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		try {
			//AntiguedadesInventariosLogic antiguedadesinventariosLogic=new AntiguedadesInventariosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=AntiguedadesInventariosLogic.GetSelecSqlAntiguedadesInventarios(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,fecha_ultima_venta_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.antiguedadesinventarioss=this.getAntiguedadesInventarioss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlAntiguedadesInventarios(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("AntiguedadesInventarios_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" p.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_bodega!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_bodega = "+id_bodega.toString();
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
	
	
	public void deepLoad(AntiguedadesInventarios antiguedadesinventarios,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AntiguedadesInventariosLogicAdditional.updateAntiguedadesInventariosToGet(antiguedadesinventarios,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		antiguedadesinventarios.setBodega(antiguedadesinventariosDataAccess.getBodega(connexion,antiguedadesinventarios));
		antiguedadesinventarios.setEmpresa(antiguedadesinventariosDataAccess.getEmpresa(connexion,antiguedadesinventarios));
		antiguedadesinventarios.setSucursal(antiguedadesinventariosDataAccess.getSucursal(connexion,antiguedadesinventarios));
		antiguedadesinventarios.setLinea(antiguedadesinventariosDataAccess.getLinea(connexion,antiguedadesinventarios));
		antiguedadesinventarios.setLineaGrupo(antiguedadesinventariosDataAccess.getLineaGrupo(connexion,antiguedadesinventarios));
		antiguedadesinventarios.setLineaCategoria(antiguedadesinventariosDataAccess.getLineaCategoria(connexion,antiguedadesinventarios));
		antiguedadesinventarios.setLineaMarca(antiguedadesinventariosDataAccess.getLineaMarca(connexion,antiguedadesinventarios));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				antiguedadesinventarios.setBodega(antiguedadesinventariosDataAccess.getBodega(connexion,antiguedadesinventarios));
			}

			if(clas.clas.equals(Empresa.class)) {
				antiguedadesinventarios.setEmpresa(antiguedadesinventariosDataAccess.getEmpresa(connexion,antiguedadesinventarios));
			}

			if(clas.clas.equals(Sucursal.class)) {
				antiguedadesinventarios.setSucursal(antiguedadesinventariosDataAccess.getSucursal(connexion,antiguedadesinventarios));
			}

			if(clas.clas.equals(Linea.class)) {
				antiguedadesinventarios.setLinea(antiguedadesinventariosDataAccess.getLinea(connexion,antiguedadesinventarios));
			}

			if(clas.clas.equals(Linea.class)) {
				antiguedadesinventarios.setLineaGrupo(antiguedadesinventariosDataAccess.getLineaGrupo(connexion,antiguedadesinventarios));
			}

			if(clas.clas.equals(Linea.class)) {
				antiguedadesinventarios.setLineaCategoria(antiguedadesinventariosDataAccess.getLineaCategoria(connexion,antiguedadesinventarios));
			}

			if(clas.clas.equals(Linea.class)) {
				antiguedadesinventarios.setLineaMarca(antiguedadesinventariosDataAccess.getLineaMarca(connexion,antiguedadesinventarios));
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
			antiguedadesinventarios.setBodega(antiguedadesinventariosDataAccess.getBodega(connexion,antiguedadesinventarios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setEmpresa(antiguedadesinventariosDataAccess.getEmpresa(connexion,antiguedadesinventarios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setSucursal(antiguedadesinventariosDataAccess.getSucursal(connexion,antiguedadesinventarios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setLinea(antiguedadesinventariosDataAccess.getLinea(connexion,antiguedadesinventarios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setLineaGrupo(antiguedadesinventariosDataAccess.getLineaGrupo(connexion,antiguedadesinventarios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setLineaCategoria(antiguedadesinventariosDataAccess.getLineaCategoria(connexion,antiguedadesinventarios));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setLineaMarca(antiguedadesinventariosDataAccess.getLineaMarca(connexion,antiguedadesinventarios));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		antiguedadesinventarios.setBodega(antiguedadesinventariosDataAccess.getBodega(connexion,antiguedadesinventarios));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(antiguedadesinventarios.getBodega(),isDeep,deepLoadType,clases);
				
		antiguedadesinventarios.setEmpresa(antiguedadesinventariosDataAccess.getEmpresa(connexion,antiguedadesinventarios));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(antiguedadesinventarios.getEmpresa(),isDeep,deepLoadType,clases);
				
		antiguedadesinventarios.setSucursal(antiguedadesinventariosDataAccess.getSucursal(connexion,antiguedadesinventarios));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(antiguedadesinventarios.getSucursal(),isDeep,deepLoadType,clases);
				
		antiguedadesinventarios.setLinea(antiguedadesinventariosDataAccess.getLinea(connexion,antiguedadesinventarios));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(antiguedadesinventarios.getLinea(),isDeep,deepLoadType,clases);
				
		antiguedadesinventarios.setLineaGrupo(antiguedadesinventariosDataAccess.getLineaGrupo(connexion,antiguedadesinventarios));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(antiguedadesinventarios.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		antiguedadesinventarios.setLineaCategoria(antiguedadesinventariosDataAccess.getLineaCategoria(connexion,antiguedadesinventarios));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(antiguedadesinventarios.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		antiguedadesinventarios.setLineaMarca(antiguedadesinventariosDataAccess.getLineaMarca(connexion,antiguedadesinventarios));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(antiguedadesinventarios.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				antiguedadesinventarios.setBodega(antiguedadesinventariosDataAccess.getBodega(connexion,antiguedadesinventarios));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(antiguedadesinventarios.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				antiguedadesinventarios.setEmpresa(antiguedadesinventariosDataAccess.getEmpresa(connexion,antiguedadesinventarios));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(antiguedadesinventarios.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				antiguedadesinventarios.setSucursal(antiguedadesinventariosDataAccess.getSucursal(connexion,antiguedadesinventarios));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(antiguedadesinventarios.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				antiguedadesinventarios.setLinea(antiguedadesinventariosDataAccess.getLinea(connexion,antiguedadesinventarios));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(antiguedadesinventarios.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				antiguedadesinventarios.setLineaGrupo(antiguedadesinventariosDataAccess.getLineaGrupo(connexion,antiguedadesinventarios));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(antiguedadesinventarios.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				antiguedadesinventarios.setLineaCategoria(antiguedadesinventariosDataAccess.getLineaCategoria(connexion,antiguedadesinventarios));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(antiguedadesinventarios.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				antiguedadesinventarios.setLineaMarca(antiguedadesinventariosDataAccess.getLineaMarca(connexion,antiguedadesinventarios));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(antiguedadesinventarios.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			antiguedadesinventarios.setBodega(antiguedadesinventariosDataAccess.getBodega(connexion,antiguedadesinventarios));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(antiguedadesinventarios.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setEmpresa(antiguedadesinventariosDataAccess.getEmpresa(connexion,antiguedadesinventarios));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(antiguedadesinventarios.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setSucursal(antiguedadesinventariosDataAccess.getSucursal(connexion,antiguedadesinventarios));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(antiguedadesinventarios.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setLinea(antiguedadesinventariosDataAccess.getLinea(connexion,antiguedadesinventarios));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(antiguedadesinventarios.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setLineaGrupo(antiguedadesinventariosDataAccess.getLineaGrupo(connexion,antiguedadesinventarios));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(antiguedadesinventarios.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setLineaCategoria(antiguedadesinventariosDataAccess.getLineaCategoria(connexion,antiguedadesinventarios));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(antiguedadesinventarios.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			antiguedadesinventarios.setLineaMarca(antiguedadesinventariosDataAccess.getLineaMarca(connexion,antiguedadesinventarios));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(antiguedadesinventarios.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(antiguedadesinventarios,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AntiguedadesInventariosConstantesFunciones.refrescarForeignKeysDescripcionesAntiguedadesInventarios(antiguedadesinventarios);
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
			this.deepLoad(this.antiguedadesinventarios,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AntiguedadesInventariosConstantesFunciones.refrescarForeignKeysDescripcionesAntiguedadesInventarios(this.antiguedadesinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(antiguedadesinventarioss!=null) {
				for(AntiguedadesInventarios antiguedadesinventarios:antiguedadesinventarioss) {
					this.deepLoad(antiguedadesinventarios,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AntiguedadesInventariosConstantesFunciones.refrescarForeignKeysDescripcionesAntiguedadesInventarios(antiguedadesinventarioss);
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
			if(antiguedadesinventarioss!=null) {
				for(AntiguedadesInventarios antiguedadesinventarios:antiguedadesinventarioss) {
					this.deepLoad(antiguedadesinventarios,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AntiguedadesInventariosConstantesFunciones.refrescarForeignKeysDescripcionesAntiguedadesInventarios(antiguedadesinventarioss);
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
	
	public AntiguedadesInventariosParameterReturnGeneral procesarAccionAntiguedadesInventarioss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AntiguedadesInventarios> antiguedadesinventarioss,AntiguedadesInventariosParameterReturnGeneral antiguedadesinventariosParameterGeneral)throws Exception {
		 try {	
			AntiguedadesInventariosParameterReturnGeneral antiguedadesinventariosReturnGeneral=new AntiguedadesInventariosParameterReturnGeneral();
	
			AntiguedadesInventariosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,antiguedadesinventarioss,antiguedadesinventariosParameterGeneral,antiguedadesinventariosReturnGeneral);
			
			return antiguedadesinventariosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AntiguedadesInventariosParameterReturnGeneral procesarAccionAntiguedadesInventariossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AntiguedadesInventarios> antiguedadesinventarioss,AntiguedadesInventariosParameterReturnGeneral antiguedadesinventariosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			AntiguedadesInventariosParameterReturnGeneral antiguedadesinventariosReturnGeneral=new AntiguedadesInventariosParameterReturnGeneral();
	
			AntiguedadesInventariosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,antiguedadesinventarioss,antiguedadesinventariosParameterGeneral,antiguedadesinventariosReturnGeneral);
			
			this.connexion.commit();
			
			return antiguedadesinventariosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

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
import com.bydan.erp.inventario.util.report.ProcesoCodigosAlternosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoCodigosAlternosParameterGeneral;
import com.bydan.erp.inventario.util.report.ProcesoCodigosAlternosConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProcesoCodigosAlternos;

import com.bydan.erp.inventario.business.logic.report.ProcesoCodigosAlternosLogicAdditional;
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
public class ProcesoCodigosAlternosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCodigosAlternosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCodigosAlternosLogic procesocodigosalternosDataAccess; 		
	protected ProcesoCodigosAlternos procesocodigosalternos;
	protected List<ProcesoCodigosAlternos> procesocodigosalternoss;
	protected Object procesocodigosalternosObject;	
	protected List<Object> procesocodigosalternossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCodigosAlternosLogic()throws SQLException,Exception {
		try	{
			this.procesocodigosalternoss= new ArrayList<ProcesoCodigosAlternos>();
			this.procesocodigosalternos= new ProcesoCodigosAlternos();
			this.procesocodigosalternosObject=new Object();
			this.procesocodigosalternossObject=new ArrayList<Object>();
			
			this.procesocodigosalternosDataAccess=this;
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
			this.procesocodigosalternosDataAccess.setConnexionType(this.connexionType);
			this.procesocodigosalternosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocodigosalternosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCodigosAlternosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocodigosalternoss= new ArrayList<ProcesoCodigosAlternos>();
			this.procesocodigosalternos= new ProcesoCodigosAlternos();
			this.procesocodigosalternosObject=new Object();
			this.procesocodigosalternossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocodigosalternosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocodigosalternosDataAccess.setConnexionType(this.connexionType);
			this.procesocodigosalternosDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocodigosalternosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCodigosAlternos getProcesoCodigosAlternos() throws Exception {	
		ProcesoCodigosAlternosLogicAdditional.checkProcesoCodigosAlternosToGet(procesocodigosalternos,this.datosCliente,this.arrDatoGeneral);
		ProcesoCodigosAlternosLogicAdditional.updateProcesoCodigosAlternosToGet(procesocodigosalternos,this.arrDatoGeneral);
		
		return procesocodigosalternos;
	}
		
	public void setProcesoCodigosAlternos(ProcesoCodigosAlternos newProcesoCodigosAlternos) {
		this.procesocodigosalternos = newProcesoCodigosAlternos;
	}
	
	public List<ProcesoCodigosAlternos> getProcesoCodigosAlternoss() throws Exception {		
		this.quitarProcesoCodigosAlternossNulos();
		
		ProcesoCodigosAlternosLogicAdditional.checkProcesoCodigosAlternosToGets(procesocodigosalternoss,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCodigosAlternos procesocodigosalternosLocal: procesocodigosalternoss ) {
			ProcesoCodigosAlternosLogicAdditional.updateProcesoCodigosAlternosToGet(procesocodigosalternosLocal,this.arrDatoGeneral);
		}
		
		return procesocodigosalternoss;
	}
	
	public void setProcesoCodigosAlternoss(List<ProcesoCodigosAlternos> newProcesoCodigosAlternoss) {
		this.procesocodigosalternoss = newProcesoCodigosAlternoss;
	}
	
	public Object getProcesoCodigosAlternosObject() {	
		//this.procesocodigosalternosObject=this.procesocodigosalternosDataAccess.getEntityObject();
		return this.procesocodigosalternosObject;
	}
		
	public void setProcesoCodigosAlternosObject(Object newProcesoCodigosAlternosObject) {
		this.procesocodigosalternosObject = newProcesoCodigosAlternosObject;
	}
	
	public List<Object> getProcesoCodigosAlternossObject() {		
		//this.procesocodigosalternossObject=this.procesocodigosalternosDataAccess.getEntitiesObject();
		return this.procesocodigosalternossObject;
	}
		
	public void setProcesoCodigosAlternossObject(List<Object> newProcesoCodigosAlternossObject) {
		this.procesocodigosalternossObject = newProcesoCodigosAlternossObject;
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
		procesocodigosalternoss = new  ArrayList<ProcesoCodigosAlternos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCodigosAlternosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocodigosalternoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocodigosalternoss = new  ArrayList<ProcesoCodigosAlternos>();
		  		  
        try {
			//ProcesoCodigosAlternosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocodigosalternoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocodigosalternoss = new  ArrayList<ProcesoCodigosAlternos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCodigosAlternosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocodigosalternoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocodigosalternoss = new  ArrayList<ProcesoCodigosAlternos>();
		  		  
        try {
			//ProcesoCodigosAlternosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocodigosalternoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocodigosalternoss = new  ArrayList<ProcesoCodigosAlternos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCodigosAlternosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocodigosalternoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocodigosalternoss = new  ArrayList<ProcesoCodigosAlternos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCodigosAlternosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocodigosalternoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCodigosAlternos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCodigosAlternos> entities = new  ArrayList<ProcesoCodigosAlternos>();
		ProcesoCodigosAlternos entity = new ProcesoCodigosAlternos();		  
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
	
	public  List<ProcesoCodigosAlternos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCodigosAlternos> entities = new  ArrayList<ProcesoCodigosAlternos>();
		ProcesoCodigosAlternos entity = new ProcesoCodigosAlternos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCodigosAlternos();
				
				
      	    	entity=ProcesoCodigosAlternosLogic.getEntityProcesoCodigosAlternos("",entity,resultSet);
      	    	
				//entity.setProcesoCodigosAlternosOriginal( new ProcesoCodigosAlternos());
      	    	//entity.setProcesoCodigosAlternosOriginal(super.getEntity("",entity.getProcesoCodigosAlternosOriginal(),resultSet,ProcesoCodigosAlternosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCodigosAlternosOriginal(ProcesoCodigosAlternosDataAccess.getEntityProcesoCodigosAlternos("",entity.getProcesoCodigosAlternosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCodigosAlternos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCodigosAlternos> entities = new  ArrayList<ProcesoCodigosAlternos>();
		ProcesoCodigosAlternos entity = new ProcesoCodigosAlternos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCodigosAlternos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCodigosAlternos>((List<ProcesoCodigosAlternos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCodigosAlternossOriginal(entities);
			
			}  else {
				this.procesocodigosalternossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCodigosAlternosConstantesFunciones.quitarEspaciosProcesoCodigosAlternoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCodigosAlternos getEntityProcesoCodigosAlternos(String strPrefijo,ProcesoCodigosAlternos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ProcesoCodigosAlternosConstantesFunciones.CODIGO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+ProcesoCodigosAlternosConstantesFunciones.NOMBREUNIDAD));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+ProcesoCodigosAlternosConstantesFunciones.CODIGOPRODUCTO));
			entity.setnombre(resultSet.getString(strPrefijo+ProcesoCodigosAlternosConstantesFunciones.NOMBRE));
			entity.setnombre_completo_cliente_proveedor_defecto(resultSet.getString(strPrefijo+ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCodigosAlternos getEntityProcesoCodigosAlternos(String strPrefijo,ProcesoCodigosAlternos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCodigosAlternos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCodigosAlternos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCodigosAlternosLogic.setFieldReflectionProcesoCodigosAlternos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCodigosAlternos(Field field,String strPrefijo,String sColumn,ProcesoCodigosAlternos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoCodigosAlternosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoCodigosAlternosConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoCodigosAlternosConstantesFunciones.CODIGOPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoCodigosAlternosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO:
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
	
	public void quitarProcesoCodigosAlternossNulos() throws Exception {				
		
		List<ProcesoCodigosAlternos> procesocodigosalternossAux= new ArrayList<ProcesoCodigosAlternos>();
		
		for(ProcesoCodigosAlternos procesocodigosalternos:procesocodigosalternoss) {
			if(procesocodigosalternos!=null) {
				procesocodigosalternossAux.add(procesocodigosalternos);
			}
		}
		
		procesocodigosalternoss=procesocodigosalternossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCodigosAlternos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCodigosAlternos> entities = new  ArrayList<ProcesoCodigosAlternos>();
		ProcesoCodigosAlternos entity = new ProcesoCodigosAlternos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCodigosAlternos>((List<ProcesoCodigosAlternos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCodigosAlternossOriginal(entities);
			
			}  else {
				this.procesocodigosalternossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCodigosAlternosConstantesFunciones.quitarEspaciosProcesoCodigosAlternoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocodigosalternoss = new  ArrayList<ProcesoCodigosAlternos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCodigosAlternosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocodigosalternoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesocodigosalternoss = new  ArrayList<ProcesoCodigosAlternos>();
		  		  
        try {
			//ProcesoCodigosAlternosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocodigosalternoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCodigosAlternos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCodigosAlternos> entities = new  ArrayList<ProcesoCodigosAlternos>();
		ProcesoCodigosAlternos entity = new ProcesoCodigosAlternos();		  
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
	
	public  List<ProcesoCodigosAlternos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCodigosAlternos> entities = new  ArrayList<ProcesoCodigosAlternos>();
		ProcesoCodigosAlternos entity = new ProcesoCodigosAlternos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCodigosAlternos();
				
				if(conMapGenerico) {
					entity.setMapProcesoCodigosAlternos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCodigosAlternos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCodigosAlternosDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCodigosAlternosLogic.getEntityProcesoCodigosAlternos("",entity,resultSet,listColumns);
					
					////entity.setProcesoCodigosAlternosOriginal( new ProcesoCodigosAlternos());
					////entity.setProcesoCodigosAlternosOriginal(super.getEntity("",entity.getProcesoCodigosAlternosOriginal(),resultSet,ProcesoCodigosAlternosDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCodigosAlternosOriginal(ProcesoCodigosAlternosDataAccess.getEntityProcesoCodigosAlternos("",entity.getProcesoCodigosAlternosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,ProcesoCodigosAlternos relprocesocodigosalternos)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relprocesocodigosalternos.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProcesoCodigosAlternos relprocesocodigosalternos)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relprocesocodigosalternos.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,ProcesoCodigosAlternos relprocesocodigosalternos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relprocesocodigosalternos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProcesoCodigosAlternos relprocesocodigosalternos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relprocesocodigosalternos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,ProcesoCodigosAlternos relprocesocodigosalternos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocodigosalternos.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProcesoCodigosAlternos relprocesocodigosalternos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocodigosalternos.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProcesoCodigosAlternos relprocesocodigosalternos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocodigosalternos.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProcesoCodigosAlternos relprocesocodigosalternos)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesocodigosalternos.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getProcesoCodigosAlternossBusquedaProcesoCodigosAlternosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoCodigosAlternosLogic procesocodigosalternosLogic=new ProcesoCodigosAlternosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoCodigosAlternosLogic.GetSelecSqlProcesoCodigosAlternos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesocodigosalternoss=this.getProcesoCodigosAlternoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCodigosAlternossBusquedaProcesoCodigosAlternos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoCodigosAlternosLogic procesocodigosalternosLogic=new ProcesoCodigosAlternosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoCodigosAlternosLogic.GetSelecSqlProcesoCodigosAlternos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesocodigosalternoss=this.getProcesoCodigosAlternoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoCodigosAlternos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoCodigosAlternos_Postgres.sql");
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
	
	
	public void deepLoad(ProcesoCodigosAlternos procesocodigosalternos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoCodigosAlternosLogicAdditional.updateProcesoCodigosAlternosToGet(procesocodigosalternos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocodigosalternos.setBodega(procesocodigosalternosDataAccess.getBodega(connexion,procesocodigosalternos));
		procesocodigosalternos.setProducto(procesocodigosalternosDataAccess.getProducto(connexion,procesocodigosalternos));
		procesocodigosalternos.setEmpresa(procesocodigosalternosDataAccess.getEmpresa(connexion,procesocodigosalternos));
		procesocodigosalternos.setSucursal(procesocodigosalternosDataAccess.getSucursal(connexion,procesocodigosalternos));
		procesocodigosalternos.setLinea(procesocodigosalternosDataAccess.getLinea(connexion,procesocodigosalternos));
		procesocodigosalternos.setLineaGrupo(procesocodigosalternosDataAccess.getLineaGrupo(connexion,procesocodigosalternos));
		procesocodigosalternos.setLineaCategoria(procesocodigosalternosDataAccess.getLineaCategoria(connexion,procesocodigosalternos));
		procesocodigosalternos.setLineaMarca(procesocodigosalternosDataAccess.getLineaMarca(connexion,procesocodigosalternos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesocodigosalternos.setBodega(procesocodigosalternosDataAccess.getBodega(connexion,procesocodigosalternos));
			}

			if(clas.clas.equals(Producto.class)) {
				procesocodigosalternos.setProducto(procesocodigosalternosDataAccess.getProducto(connexion,procesocodigosalternos));
			}

			if(clas.clas.equals(Empresa.class)) {
				procesocodigosalternos.setEmpresa(procesocodigosalternosDataAccess.getEmpresa(connexion,procesocodigosalternos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesocodigosalternos.setSucursal(procesocodigosalternosDataAccess.getSucursal(connexion,procesocodigosalternos));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocodigosalternos.setLinea(procesocodigosalternosDataAccess.getLinea(connexion,procesocodigosalternos));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocodigosalternos.setLineaGrupo(procesocodigosalternosDataAccess.getLineaGrupo(connexion,procesocodigosalternos));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocodigosalternos.setLineaCategoria(procesocodigosalternosDataAccess.getLineaCategoria(connexion,procesocodigosalternos));
			}

			if(clas.clas.equals(Linea.class)) {
				procesocodigosalternos.setLineaMarca(procesocodigosalternosDataAccess.getLineaMarca(connexion,procesocodigosalternos));
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
			procesocodigosalternos.setBodega(procesocodigosalternosDataAccess.getBodega(connexion,procesocodigosalternos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setProducto(procesocodigosalternosDataAccess.getProducto(connexion,procesocodigosalternos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setEmpresa(procesocodigosalternosDataAccess.getEmpresa(connexion,procesocodigosalternos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setSucursal(procesocodigosalternosDataAccess.getSucursal(connexion,procesocodigosalternos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setLinea(procesocodigosalternosDataAccess.getLinea(connexion,procesocodigosalternos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setLineaGrupo(procesocodigosalternosDataAccess.getLineaGrupo(connexion,procesocodigosalternos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setLineaCategoria(procesocodigosalternosDataAccess.getLineaCategoria(connexion,procesocodigosalternos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setLineaMarca(procesocodigosalternosDataAccess.getLineaMarca(connexion,procesocodigosalternos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocodigosalternos.setBodega(procesocodigosalternosDataAccess.getBodega(connexion,procesocodigosalternos));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(procesocodigosalternos.getBodega(),isDeep,deepLoadType,clases);
				
		procesocodigosalternos.setProducto(procesocodigosalternosDataAccess.getProducto(connexion,procesocodigosalternos));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(procesocodigosalternos.getProducto(),isDeep,deepLoadType,clases);
				
		procesocodigosalternos.setEmpresa(procesocodigosalternosDataAccess.getEmpresa(connexion,procesocodigosalternos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(procesocodigosalternos.getEmpresa(),isDeep,deepLoadType,clases);
				
		procesocodigosalternos.setSucursal(procesocodigosalternosDataAccess.getSucursal(connexion,procesocodigosalternos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(procesocodigosalternos.getSucursal(),isDeep,deepLoadType,clases);
				
		procesocodigosalternos.setLinea(procesocodigosalternosDataAccess.getLinea(connexion,procesocodigosalternos));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(procesocodigosalternos.getLinea(),isDeep,deepLoadType,clases);
				
		procesocodigosalternos.setLineaGrupo(procesocodigosalternosDataAccess.getLineaGrupo(connexion,procesocodigosalternos));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(procesocodigosalternos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		procesocodigosalternos.setLineaCategoria(procesocodigosalternosDataAccess.getLineaCategoria(connexion,procesocodigosalternos));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(procesocodigosalternos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		procesocodigosalternos.setLineaMarca(procesocodigosalternosDataAccess.getLineaMarca(connexion,procesocodigosalternos));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(procesocodigosalternos.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesocodigosalternos.setBodega(procesocodigosalternosDataAccess.getBodega(connexion,procesocodigosalternos));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(procesocodigosalternos.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				procesocodigosalternos.setProducto(procesocodigosalternosDataAccess.getProducto(connexion,procesocodigosalternos));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(procesocodigosalternos.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				procesocodigosalternos.setEmpresa(procesocodigosalternosDataAccess.getEmpresa(connexion,procesocodigosalternos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(procesocodigosalternos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesocodigosalternos.setSucursal(procesocodigosalternosDataAccess.getSucursal(connexion,procesocodigosalternos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(procesocodigosalternos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocodigosalternos.setLinea(procesocodigosalternosDataAccess.getLinea(connexion,procesocodigosalternos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocodigosalternos.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocodigosalternos.setLineaGrupo(procesocodigosalternosDataAccess.getLineaGrupo(connexion,procesocodigosalternos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocodigosalternos.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocodigosalternos.setLineaCategoria(procesocodigosalternosDataAccess.getLineaCategoria(connexion,procesocodigosalternos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocodigosalternos.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesocodigosalternos.setLineaMarca(procesocodigosalternosDataAccess.getLineaMarca(connexion,procesocodigosalternos));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesocodigosalternos.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			procesocodigosalternos.setBodega(procesocodigosalternosDataAccess.getBodega(connexion,procesocodigosalternos));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(procesocodigosalternos.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setProducto(procesocodigosalternosDataAccess.getProducto(connexion,procesocodigosalternos));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(procesocodigosalternos.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setEmpresa(procesocodigosalternosDataAccess.getEmpresa(connexion,procesocodigosalternos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(procesocodigosalternos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setSucursal(procesocodigosalternosDataAccess.getSucursal(connexion,procesocodigosalternos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(procesocodigosalternos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setLinea(procesocodigosalternosDataAccess.getLinea(connexion,procesocodigosalternos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocodigosalternos.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setLineaGrupo(procesocodigosalternosDataAccess.getLineaGrupo(connexion,procesocodigosalternos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocodigosalternos.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setLineaCategoria(procesocodigosalternosDataAccess.getLineaCategoria(connexion,procesocodigosalternos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocodigosalternos.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocodigosalternos.setLineaMarca(procesocodigosalternosDataAccess.getLineaMarca(connexion,procesocodigosalternos));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesocodigosalternos.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesocodigosalternos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCodigosAlternosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCodigosAlternos(procesocodigosalternos);
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
			this.deepLoad(this.procesocodigosalternos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCodigosAlternosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCodigosAlternos(this.procesocodigosalternos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocodigosalternoss!=null) {
				for(ProcesoCodigosAlternos procesocodigosalternos:procesocodigosalternoss) {
					this.deepLoad(procesocodigosalternos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCodigosAlternosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCodigosAlternos(procesocodigosalternoss);
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
			if(procesocodigosalternoss!=null) {
				for(ProcesoCodigosAlternos procesocodigosalternos:procesocodigosalternoss) {
					this.deepLoad(procesocodigosalternos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCodigosAlternosConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCodigosAlternos(procesocodigosalternoss);
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
	
	public ProcesoCodigosAlternosParameterReturnGeneral procesarAccionProcesoCodigosAlternoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCodigosAlternos> procesocodigosalternoss,ProcesoCodigosAlternosParameterReturnGeneral procesocodigosalternosParameterGeneral)throws Exception {
		 try {	
			ProcesoCodigosAlternosParameterReturnGeneral procesocodigosalternosReturnGeneral=new ProcesoCodigosAlternosParameterReturnGeneral();
	
			ProcesoCodigosAlternosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocodigosalternoss,procesocodigosalternosParameterGeneral,procesocodigosalternosReturnGeneral);
			
			return procesocodigosalternosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCodigosAlternosParameterReturnGeneral procesarAccionProcesoCodigosAlternossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCodigosAlternos> procesocodigosalternoss,ProcesoCodigosAlternosParameterReturnGeneral procesocodigosalternosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCodigosAlternosParameterReturnGeneral procesocodigosalternosReturnGeneral=new ProcesoCodigosAlternosParameterReturnGeneral();
	
			ProcesoCodigosAlternosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocodigosalternoss,procesocodigosalternosParameterGeneral,procesocodigosalternosReturnGeneral);
			
			this.connexion.commit();
			
			return procesocodigosalternosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

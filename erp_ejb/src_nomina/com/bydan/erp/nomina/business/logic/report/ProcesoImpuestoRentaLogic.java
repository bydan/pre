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
import com.bydan.erp.nomina.util.report.ProcesoImpuestoRentaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoImpuestoRentaParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoImpuestoRentaConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoImpuestoRenta;

import com.bydan.erp.nomina.business.logic.report.ProcesoImpuestoRentaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoImpuestoRentaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoImpuestoRentaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoImpuestoRentaLogic procesoimpuestorentaDataAccess; 		
	protected ProcesoImpuestoRenta procesoimpuestorenta;
	protected List<ProcesoImpuestoRenta> procesoimpuestorentas;
	protected Object procesoimpuestorentaObject;	
	protected List<Object> procesoimpuestorentasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoImpuestoRentaLogic()throws SQLException,Exception {
		try	{
			this.procesoimpuestorentas= new ArrayList<ProcesoImpuestoRenta>();
			this.procesoimpuestorenta= new ProcesoImpuestoRenta();
			this.procesoimpuestorentaObject=new Object();
			this.procesoimpuestorentasObject=new ArrayList<Object>();
			
			this.procesoimpuestorentaDataAccess=this;
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
			this.procesoimpuestorentaDataAccess.setConnexionType(this.connexionType);
			this.procesoimpuestorentaDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoimpuestorentaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoImpuestoRentaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesoimpuestorentas= new ArrayList<ProcesoImpuestoRenta>();
			this.procesoimpuestorenta= new ProcesoImpuestoRenta();
			this.procesoimpuestorentaObject=new Object();
			this.procesoimpuestorentasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesoimpuestorentaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesoimpuestorentaDataAccess.setConnexionType(this.connexionType);
			this.procesoimpuestorentaDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoimpuestorentaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoImpuestoRenta getProcesoImpuestoRenta() throws Exception {	
		ProcesoImpuestoRentaLogicAdditional.checkProcesoImpuestoRentaToGet(procesoimpuestorenta,this.datosCliente,this.arrDatoGeneral);
		ProcesoImpuestoRentaLogicAdditional.updateProcesoImpuestoRentaToGet(procesoimpuestorenta,this.arrDatoGeneral);
		
		return procesoimpuestorenta;
	}
		
	public void setProcesoImpuestoRenta(ProcesoImpuestoRenta newProcesoImpuestoRenta) {
		this.procesoimpuestorenta = newProcesoImpuestoRenta;
	}
	
	public List<ProcesoImpuestoRenta> getProcesoImpuestoRentas() throws Exception {		
		this.quitarProcesoImpuestoRentasNulos();
		
		ProcesoImpuestoRentaLogicAdditional.checkProcesoImpuestoRentaToGets(procesoimpuestorentas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoImpuestoRenta procesoimpuestorentaLocal: procesoimpuestorentas ) {
			ProcesoImpuestoRentaLogicAdditional.updateProcesoImpuestoRentaToGet(procesoimpuestorentaLocal,this.arrDatoGeneral);
		}
		
		return procesoimpuestorentas;
	}
	
	public void setProcesoImpuestoRentas(List<ProcesoImpuestoRenta> newProcesoImpuestoRentas) {
		this.procesoimpuestorentas = newProcesoImpuestoRentas;
	}
	
	public Object getProcesoImpuestoRentaObject() {	
		//this.procesoimpuestorentaObject=this.procesoimpuestorentaDataAccess.getEntityObject();
		return this.procesoimpuestorentaObject;
	}
		
	public void setProcesoImpuestoRentaObject(Object newProcesoImpuestoRentaObject) {
		this.procesoimpuestorentaObject = newProcesoImpuestoRentaObject;
	}
	
	public List<Object> getProcesoImpuestoRentasObject() {		
		//this.procesoimpuestorentasObject=this.procesoimpuestorentaDataAccess.getEntitiesObject();
		return this.procesoimpuestorentasObject;
	}
		
	public void setProcesoImpuestoRentasObject(List<Object> newProcesoImpuestoRentasObject) {
		this.procesoimpuestorentasObject = newProcesoImpuestoRentasObject;
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
		procesoimpuestorentas = new  ArrayList<ProcesoImpuestoRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoimpuestorentas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesoimpuestorentas = new  ArrayList<ProcesoImpuestoRenta>();
		  		  
        try {
			//ProcesoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoimpuestorentas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesoimpuestorentas = new  ArrayList<ProcesoImpuestoRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoimpuestorentas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoimpuestorentas = new  ArrayList<ProcesoImpuestoRenta>();
		  		  
        try {
			//ProcesoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoimpuestorentas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesoimpuestorentas = new  ArrayList<ProcesoImpuestoRenta>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoimpuestorentas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoimpuestorentas = new  ArrayList<ProcesoImpuestoRenta>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoimpuestorentas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoImpuestoRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoImpuestoRenta> entities = new  ArrayList<ProcesoImpuestoRenta>();
		ProcesoImpuestoRenta entity = new ProcesoImpuestoRenta();		  
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
	
	public  List<ProcesoImpuestoRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoImpuestoRenta> entities = new  ArrayList<ProcesoImpuestoRenta>();
		ProcesoImpuestoRenta entity = new ProcesoImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoImpuestoRenta();
				
				
      	    	entity=ProcesoImpuestoRentaLogic.getEntityProcesoImpuestoRenta("",entity,resultSet);
      	    	
				//entity.setProcesoImpuestoRentaOriginal( new ProcesoImpuestoRenta());
      	    	//entity.setProcesoImpuestoRentaOriginal(super.getEntity("",entity.getProcesoImpuestoRentaOriginal(),resultSet,ProcesoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoImpuestoRentaOriginal(ProcesoImpuestoRentaDataAccess.getEntityProcesoImpuestoRenta("",entity.getProcesoImpuestoRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoImpuestoRenta> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoImpuestoRenta> entities = new  ArrayList<ProcesoImpuestoRenta>();
		ProcesoImpuestoRenta entity = new ProcesoImpuestoRenta();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoImpuestoRenta.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoImpuestoRenta>((List<ProcesoImpuestoRenta>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoImpuestoRentasOriginal(entities);
			
			}  else {
				this.procesoimpuestorentasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoImpuestoRentaConstantesFunciones.quitarEspaciosProcesoImpuestoRentas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoImpuestoRenta getEntityProcesoImpuestoRenta(String strPrefijo,ProcesoImpuestoRenta entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_anio(resultSet.getLong(strPrefijo+ProcesoImpuestoRentaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoImpuestoRenta getEntityProcesoImpuestoRenta(String strPrefijo,ProcesoImpuestoRenta entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoImpuestoRenta.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoImpuestoRenta.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoImpuestoRentaLogic.setFieldReflectionProcesoImpuestoRenta(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoImpuestoRenta(Field field,String strPrefijo,String sColumn,ProcesoImpuestoRenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoImpuestoRentaConstantesFunciones.IDANIO:
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
	
	public void quitarProcesoImpuestoRentasNulos() throws Exception {				
		
		List<ProcesoImpuestoRenta> procesoimpuestorentasAux= new ArrayList<ProcesoImpuestoRenta>();
		
		for(ProcesoImpuestoRenta procesoimpuestorenta:procesoimpuestorentas) {
			if(procesoimpuestorenta!=null) {
				procesoimpuestorentasAux.add(procesoimpuestorenta);
			}
		}
		
		procesoimpuestorentas=procesoimpuestorentasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoImpuestoRenta> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoImpuestoRenta> entities = new  ArrayList<ProcesoImpuestoRenta>();
		ProcesoImpuestoRenta entity = new ProcesoImpuestoRenta();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoImpuestoRenta>((List<ProcesoImpuestoRenta>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoImpuestoRentasOriginal(entities);
			
			}  else {
				this.procesoimpuestorentasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoImpuestoRentaConstantesFunciones.quitarEspaciosProcesoImpuestoRentas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesoimpuestorentas = new  ArrayList<ProcesoImpuestoRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoimpuestorentas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesoimpuestorentas = new  ArrayList<ProcesoImpuestoRenta>();
		  		  
        try {
			//ProcesoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoimpuestorentas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoImpuestoRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoImpuestoRenta> entities = new  ArrayList<ProcesoImpuestoRenta>();
		ProcesoImpuestoRenta entity = new ProcesoImpuestoRenta();		  
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
	
	public  List<ProcesoImpuestoRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoImpuestoRenta> entities = new  ArrayList<ProcesoImpuestoRenta>();
		ProcesoImpuestoRenta entity = new ProcesoImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoImpuestoRenta();
				
				if(conMapGenerico) {
					entity.setMapProcesoImpuestoRenta( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoImpuestoRenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoImpuestoRentaDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoImpuestoRentaLogic.getEntityProcesoImpuestoRenta("",entity,resultSet,listColumns);
					
					////entity.setProcesoImpuestoRentaOriginal( new ProcesoImpuestoRenta());
					////entity.setProcesoImpuestoRentaOriginal(super.getEntity("",entity.getProcesoImpuestoRentaOriginal(),resultSet,ProcesoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoImpuestoRentaOriginal(ProcesoImpuestoRentaDataAccess.getEntityProcesoImpuestoRenta("",entity.getProcesoImpuestoRentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Anio getAnio(Connexion connexion,ProcesoImpuestoRenta relprocesoimpuestorenta)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,relprocesoimpuestorenta.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}


	
	
	public void getProcesoImpuestoRentasBusquedaProcesoImpuestoRentaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio)throws Exception {
		try {
			ProcesoImpuestoRentaLogicAdditional procesoimpuestorentaLogicAdditional=new ProcesoImpuestoRentaLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoimpuestorentaLogicAdditional.BusquedaProcesoImpuestoRenta(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio);

			//this.procesoimpuestorentas=this.getProcesoImpuestoRentas();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoImpuestoRentaLogicAdditional.ProcesarInformacionProcesoImpuestoRenta(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoimpuestorentaLogicAdditional,this.procesoimpuestorentas,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoImpuestoRenta",id_anio);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoImpuestoRentasBusquedaProcesoImpuestoRenta(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio)throws Exception {
		try {
			ProcesoImpuestoRentaLogicAdditional procesoimpuestorentaLogicAdditional=new ProcesoImpuestoRentaLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoimpuestorentaLogicAdditional.BusquedaProcesoImpuestoRenta(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio);

			//this.procesoimpuestorentas=this.getProcesoImpuestoRentas();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoImpuestoRentaLogicAdditional.ProcesarInformacionProcesoImpuestoRenta(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoimpuestorentaLogicAdditional,this.procesoimpuestorentas,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoImpuestoRenta",id_anio);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoImpuestoRenta procesoimpuestorenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoImpuestoRentaLogicAdditional.updateProcesoImpuestoRentaToGet(procesoimpuestorenta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoimpuestorenta.setAnio(procesoimpuestorentaDataAccess.getAnio(connexion,procesoimpuestorenta));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoimpuestorenta.setAnio(procesoimpuestorentaDataAccess.getAnio(connexion,procesoimpuestorenta));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoimpuestorenta.setAnio(procesoimpuestorentaDataAccess.getAnio(connexion,procesoimpuestorenta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoimpuestorenta.setAnio(procesoimpuestorentaDataAccess.getAnio(connexion,procesoimpuestorenta));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(procesoimpuestorenta.getAnio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoimpuestorenta.setAnio(procesoimpuestorentaDataAccess.getAnio(connexion,procesoimpuestorenta));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(procesoimpuestorenta.getAnio(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoimpuestorenta.setAnio(procesoimpuestorentaDataAccess.getAnio(connexion,procesoimpuestorenta));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(procesoimpuestorenta.getAnio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesoimpuestorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoImpuestoRenta(procesoimpuestorenta);
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
			this.deepLoad(this.procesoimpuestorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoImpuestoRenta(this.procesoimpuestorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesoimpuestorentas!=null) {
				for(ProcesoImpuestoRenta procesoimpuestorenta:procesoimpuestorentas) {
					this.deepLoad(procesoimpuestorenta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoImpuestoRenta(procesoimpuestorentas);
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
			if(procesoimpuestorentas!=null) {
				for(ProcesoImpuestoRenta procesoimpuestorenta:procesoimpuestorentas) {
					this.deepLoad(procesoimpuestorenta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoImpuestoRenta(procesoimpuestorentas);
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
	
	public ProcesoImpuestoRentaParameterReturnGeneral procesarAccionProcesoImpuestoRentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoImpuestoRenta> procesoimpuestorentas,ProcesoImpuestoRentaParameterReturnGeneral procesoimpuestorentaParameterGeneral)throws Exception {
		 try {	
			ProcesoImpuestoRentaParameterReturnGeneral procesoimpuestorentaReturnGeneral=new ProcesoImpuestoRentaParameterReturnGeneral();
	
			ProcesoImpuestoRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoimpuestorentas,procesoimpuestorentaParameterGeneral,procesoimpuestorentaReturnGeneral);
			
			return procesoimpuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoImpuestoRentaParameterReturnGeneral procesarAccionProcesoImpuestoRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoImpuestoRenta> procesoimpuestorentas,ProcesoImpuestoRentaParameterReturnGeneral procesoimpuestorentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoImpuestoRentaParameterReturnGeneral procesoimpuestorentaReturnGeneral=new ProcesoImpuestoRentaParameterReturnGeneral();
	
			ProcesoImpuestoRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoimpuestorentas,procesoimpuestorentaParameterGeneral,procesoimpuestorentaReturnGeneral);
			
			this.connexion.commit();
			
			return procesoimpuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoImpuestoRenta> procesoimpuestorentas,String sTipoBusqueda,Long id_anioBusquedaProcesoImpuestoRenta) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoImpuestoRentaLogicAdditional procesoimpuestorentaLogicAdditional=new ProcesoImpuestoRentaLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesoimpuestorentaLogicAdditional.setConnexion(this.connexion);

			procesoimpuestorentaLogicAdditional.ProcesarInformacionProcesoImpuestoRenta(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoimpuestorentas,sTipoBusqueda,id_anioBusquedaProcesoImpuestoRenta);

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

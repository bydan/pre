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
package com.bydan.erp.facturacion.business.logic.report;

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

import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.resources.general.AuxiliarGeneral;
import com.bydan.erp.facturacion.util.report.VentasVentasNoCerradasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.VentasVentasNoCerradasParameterGeneral;
import com.bydan.erp.facturacion.util.report.VentasVentasNoCerradasConstantesFunciones;
import com.bydan.erp.facturacion.business.entity.report.VentasVentasNoCerradas;

import com.bydan.erp.facturacion.business.logic.report.VentasVentasNoCerradasLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class VentasVentasNoCerradasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(VentasVentasNoCerradasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected VentasVentasNoCerradasLogic ventasventasnocerradasDataAccess; 		
	protected VentasVentasNoCerradas ventasventasnocerradas;
	protected List<VentasVentasNoCerradas> ventasventasnocerradass;
	protected Object ventasventasnocerradasObject;	
	protected List<Object> ventasventasnocerradassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  VentasVentasNoCerradasLogic()throws SQLException,Exception {
		try	{
			this.ventasventasnocerradass= new ArrayList<VentasVentasNoCerradas>();
			this.ventasventasnocerradas= new VentasVentasNoCerradas();
			this.ventasventasnocerradasObject=new Object();
			this.ventasventasnocerradassObject=new ArrayList<Object>();
			
			this.ventasventasnocerradasDataAccess=this;
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
			this.ventasventasnocerradasDataAccess.setConnexionType(this.connexionType);
			this.ventasventasnocerradasDataAccess.setParameterDbType(this.parameterDbType);
			this.ventasventasnocerradasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VentasVentasNoCerradasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.ventasventasnocerradass= new ArrayList<VentasVentasNoCerradas>();
			this.ventasventasnocerradas= new VentasVentasNoCerradas();
			this.ventasventasnocerradasObject=new Object();
			this.ventasventasnocerradassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.ventasventasnocerradasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.ventasventasnocerradasDataAccess.setConnexionType(this.connexionType);
			this.ventasventasnocerradasDataAccess.setParameterDbType(this.parameterDbType);
			this.ventasventasnocerradasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public VentasVentasNoCerradas getVentasVentasNoCerradas() throws Exception {	
		VentasVentasNoCerradasLogicAdditional.checkVentasVentasNoCerradasToGet(ventasventasnocerradas,this.datosCliente,this.arrDatoGeneral);
		VentasVentasNoCerradasLogicAdditional.updateVentasVentasNoCerradasToGet(ventasventasnocerradas,this.arrDatoGeneral);
		
		return ventasventasnocerradas;
	}
		
	public void setVentasVentasNoCerradas(VentasVentasNoCerradas newVentasVentasNoCerradas) {
		this.ventasventasnocerradas = newVentasVentasNoCerradas;
	}
	
	public List<VentasVentasNoCerradas> getVentasVentasNoCerradass() throws Exception {		
		this.quitarVentasVentasNoCerradassNulos();
		
		VentasVentasNoCerradasLogicAdditional.checkVentasVentasNoCerradasToGets(ventasventasnocerradass,this.datosCliente,this.arrDatoGeneral);
		
		for (VentasVentasNoCerradas ventasventasnocerradasLocal: ventasventasnocerradass ) {
			VentasVentasNoCerradasLogicAdditional.updateVentasVentasNoCerradasToGet(ventasventasnocerradasLocal,this.arrDatoGeneral);
		}
		
		return ventasventasnocerradass;
	}
	
	public void setVentasVentasNoCerradass(List<VentasVentasNoCerradas> newVentasVentasNoCerradass) {
		this.ventasventasnocerradass = newVentasVentasNoCerradass;
	}
	
	public Object getVentasVentasNoCerradasObject() {	
		//this.ventasventasnocerradasObject=this.ventasventasnocerradasDataAccess.getEntityObject();
		return this.ventasventasnocerradasObject;
	}
		
	public void setVentasVentasNoCerradasObject(Object newVentasVentasNoCerradasObject) {
		this.ventasventasnocerradasObject = newVentasVentasNoCerradasObject;
	}
	
	public List<Object> getVentasVentasNoCerradassObject() {		
		//this.ventasventasnocerradassObject=this.ventasventasnocerradasDataAccess.getEntitiesObject();
		return this.ventasventasnocerradassObject;
	}
		
	public void setVentasVentasNoCerradassObject(List<Object> newVentasVentasNoCerradassObject) {
		this.ventasventasnocerradassObject = newVentasVentasNoCerradassObject;
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
		ventasventasnocerradass = new  ArrayList<VentasVentasNoCerradas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VentasVentasNoCerradasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventasventasnocerradass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		ventasventasnocerradass = new  ArrayList<VentasVentasNoCerradas>();
		  		  
        try {
			//VentasVentasNoCerradasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventasventasnocerradass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ventasventasnocerradass = new  ArrayList<VentasVentasNoCerradas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VentasVentasNoCerradasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventasventasnocerradass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		ventasventasnocerradass = new  ArrayList<VentasVentasNoCerradas>();
		  		  
        try {
			//VentasVentasNoCerradasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventasventasnocerradass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		ventasventasnocerradass = new  ArrayList<VentasVentasNoCerradas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VentasVentasNoCerradasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventasventasnocerradass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		ventasventasnocerradass = new  ArrayList<VentasVentasNoCerradas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//VentasVentasNoCerradasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventasventasnocerradass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<VentasVentasNoCerradas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VentasVentasNoCerradas> entities = new  ArrayList<VentasVentasNoCerradas>();
		VentasVentasNoCerradas entity = new VentasVentasNoCerradas();		  
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
	
	public  List<VentasVentasNoCerradas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VentasVentasNoCerradas> entities = new  ArrayList<VentasVentasNoCerradas>();
		VentasVentasNoCerradas entity = new VentasVentasNoCerradas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VentasVentasNoCerradas();
				
				
      	    	entity=VentasVentasNoCerradasLogic.getEntityVentasVentasNoCerradas("",entity,resultSet);
      	    	
				//entity.setVentasVentasNoCerradasOriginal( new VentasVentasNoCerradas());
      	    	//entity.setVentasVentasNoCerradasOriginal(super.getEntity("",entity.getVentasVentasNoCerradasOriginal(),resultSet,VentasVentasNoCerradasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVentasVentasNoCerradasOriginal(VentasVentasNoCerradasDataAccess.getEntityVentasVentasNoCerradas("",entity.getVentasVentasNoCerradasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<VentasVentasNoCerradas> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VentasVentasNoCerradas> entities = new  ArrayList<VentasVentasNoCerradas>();
		VentasVentasNoCerradas entity = new VentasVentasNoCerradas();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,VentasVentasNoCerradas.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<VentasVentasNoCerradas>((List<VentasVentasNoCerradas>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setVentasVentasNoCerradassOriginal(entities);
			
			}  else {
				this.ventasventasnocerradassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//VentasVentasNoCerradasConstantesFunciones.quitarEspaciosVentasVentasNoCerradass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static VentasVentasNoCerradas getEntityVentasVentasNoCerradas(String strPrefijo,VentasVentasNoCerradas entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+VentasVentasNoCerradasConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+VentasVentasNoCerradasConstantesFunciones.NOMBRECOMPLETO));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+VentasVentasNoCerradasConstantesFunciones.FECHAEMISION).getTime()));
			entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+VentasVentasNoCerradasConstantesFunciones.NUMEROPREIMPRESO));
			entity.setnumero_documento(resultSet.getString(strPrefijo+VentasVentasNoCerradasConstantesFunciones.NUMERODOCUMENTO));
			entity.settotal(resultSet.getDouble(strPrefijo+VentasVentasNoCerradasConstantesFunciones.TOTAL));
			entity.setefectivo(resultSet.getDouble(strPrefijo+VentasVentasNoCerradasConstantesFunciones.EFECTIVO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static VentasVentasNoCerradas getEntityVentasVentasNoCerradas(String strPrefijo,VentasVentasNoCerradas entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = VentasVentasNoCerradas.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = VentasVentasNoCerradas.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				VentasVentasNoCerradasLogic.setFieldReflectionVentasVentasNoCerradas(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVentasVentasNoCerradas(Field field,String strPrefijo,String sColumn,VentasVentasNoCerradas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VentasVentasNoCerradasConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentasVentasNoCerradasConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentasVentasNoCerradasConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VentasVentasNoCerradasConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentasVentasNoCerradasConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VentasVentasNoCerradasConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VentasVentasNoCerradasConstantesFunciones.EFECTIVO:
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
	
	public void quitarVentasVentasNoCerradassNulos() throws Exception {				
		
		List<VentasVentasNoCerradas> ventasventasnocerradassAux= new ArrayList<VentasVentasNoCerradas>();
		
		for(VentasVentasNoCerradas ventasventasnocerradas:ventasventasnocerradass) {
			if(ventasventasnocerradas!=null) {
				ventasventasnocerradassAux.add(ventasventasnocerradas);
			}
		}
		
		ventasventasnocerradass=ventasventasnocerradassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<VentasVentasNoCerradas> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VentasVentasNoCerradas> entities = new  ArrayList<VentasVentasNoCerradas>();
		VentasVentasNoCerradas entity = new VentasVentasNoCerradas();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<VentasVentasNoCerradas>((List<VentasVentasNoCerradas>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setVentasVentasNoCerradassOriginal(entities);
			
			}  else {
				this.ventasventasnocerradassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//VentasVentasNoCerradasConstantesFunciones.quitarEspaciosVentasVentasNoCerradass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		ventasventasnocerradass = new  ArrayList<VentasVentasNoCerradas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//VentasVentasNoCerradasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventasventasnocerradass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		ventasventasnocerradass = new  ArrayList<VentasVentasNoCerradas>();
		  		  
        try {
			//VentasVentasNoCerradasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ventasventasnocerradass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<VentasVentasNoCerradas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<VentasVentasNoCerradas> entities = new  ArrayList<VentasVentasNoCerradas>();
		VentasVentasNoCerradas entity = new VentasVentasNoCerradas();		  
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
	
	public  List<VentasVentasNoCerradas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<VentasVentasNoCerradas> entities = new  ArrayList<VentasVentasNoCerradas>();
		VentasVentasNoCerradas entity = new VentasVentasNoCerradas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VentasVentasNoCerradas();
				
				if(conMapGenerico) {
					entity.setMapVentasVentasNoCerradas( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapVentasVentasNoCerradas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VentasVentasNoCerradasDataAccess.ISWITHSCHEMA);         		
					entity=VentasVentasNoCerradasLogic.getEntityVentasVentasNoCerradas("",entity,resultSet,listColumns);
					
					////entity.setVentasVentasNoCerradasOriginal( new VentasVentasNoCerradas());
					////entity.setVentasVentasNoCerradasOriginal(super.getEntity("",entity.getVentasVentasNoCerradasOriginal(),resultSet,VentasVentasNoCerradasDataAccess.ISWITHSCHEMA));         		
					////entity.setVentasVentasNoCerradasOriginal(VentasVentasNoCerradasDataAccess.getEntityVentasVentasNoCerradas("",entity.getVentasVentasNoCerradasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,VentasVentasNoCerradas relventasventasnocerradas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relventasventasnocerradas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,VentasVentasNoCerradas relventasventasnocerradas)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relventasventasnocerradas.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}


	
	
	public void getVentasVentasNoCerradassBusquedaVentasVentasNoCerradasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//VentasVentasNoCerradasLogic ventasventasnocerradasLogic=new VentasVentasNoCerradasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=VentasVentasNoCerradasLogic.GetSelecSqlVentasVentasNoCerradas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.ventasventasnocerradass=this.getVentasVentasNoCerradass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getVentasVentasNoCerradassBusquedaVentasVentasNoCerradas(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//VentasVentasNoCerradasLogic ventasventasnocerradasLogic=new VentasVentasNoCerradasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=VentasVentasNoCerradasLogic.GetSelecSqlVentasVentasNoCerradas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.ventasventasnocerradass=this.getVentasVentasNoCerradass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlVentasVentasNoCerradas(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("VentasVentasNoCerradas_Postgres.sql");
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
				

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
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
	
	
	public void deepLoad(VentasVentasNoCerradas ventasventasnocerradas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VentasVentasNoCerradasLogicAdditional.updateVentasVentasNoCerradasToGet(ventasventasnocerradas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ventasventasnocerradas.setEmpresa(ventasventasnocerradasDataAccess.getEmpresa(connexion,ventasventasnocerradas));
		ventasventasnocerradas.setSucursal(ventasventasnocerradasDataAccess.getSucursal(connexion,ventasventasnocerradas));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ventasventasnocerradas.setEmpresa(ventasventasnocerradasDataAccess.getEmpresa(connexion,ventasventasnocerradas));
			}

			if(clas.clas.equals(Sucursal.class)) {
				ventasventasnocerradas.setSucursal(ventasventasnocerradasDataAccess.getSucursal(connexion,ventasventasnocerradas));
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
			ventasventasnocerradas.setEmpresa(ventasventasnocerradasDataAccess.getEmpresa(connexion,ventasventasnocerradas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventasventasnocerradas.setSucursal(ventasventasnocerradasDataAccess.getSucursal(connexion,ventasventasnocerradas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ventasventasnocerradas.setEmpresa(ventasventasnocerradasDataAccess.getEmpresa(connexion,ventasventasnocerradas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ventasventasnocerradas.getEmpresa(),isDeep,deepLoadType,clases);
				
		ventasventasnocerradas.setSucursal(ventasventasnocerradasDataAccess.getSucursal(connexion,ventasventasnocerradas));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ventasventasnocerradas.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ventasventasnocerradas.setEmpresa(ventasventasnocerradasDataAccess.getEmpresa(connexion,ventasventasnocerradas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ventasventasnocerradas.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				ventasventasnocerradas.setSucursal(ventasventasnocerradasDataAccess.getSucursal(connexion,ventasventasnocerradas));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(ventasventasnocerradas.getSucursal(),isDeep,deepLoadType,clases);				
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
			ventasventasnocerradas.setEmpresa(ventasventasnocerradasDataAccess.getEmpresa(connexion,ventasventasnocerradas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ventasventasnocerradas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ventasventasnocerradas.setSucursal(ventasventasnocerradasDataAccess.getSucursal(connexion,ventasventasnocerradas));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(ventasventasnocerradas.getSucursal(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(ventasventasnocerradas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VentasVentasNoCerradasConstantesFunciones.refrescarForeignKeysDescripcionesVentasVentasNoCerradas(ventasventasnocerradas);
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
			this.deepLoad(this.ventasventasnocerradas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VentasVentasNoCerradasConstantesFunciones.refrescarForeignKeysDescripcionesVentasVentasNoCerradas(this.ventasventasnocerradas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(ventasventasnocerradass!=null) {
				for(VentasVentasNoCerradas ventasventasnocerradas:ventasventasnocerradass) {
					this.deepLoad(ventasventasnocerradas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VentasVentasNoCerradasConstantesFunciones.refrescarForeignKeysDescripcionesVentasVentasNoCerradas(ventasventasnocerradass);
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
			if(ventasventasnocerradass!=null) {
				for(VentasVentasNoCerradas ventasventasnocerradas:ventasventasnocerradass) {
					this.deepLoad(ventasventasnocerradas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VentasVentasNoCerradasConstantesFunciones.refrescarForeignKeysDescripcionesVentasVentasNoCerradas(ventasventasnocerradass);
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
	
	public VentasVentasNoCerradasParameterReturnGeneral procesarAccionVentasVentasNoCerradass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VentasVentasNoCerradas> ventasventasnocerradass,VentasVentasNoCerradasParameterReturnGeneral ventasventasnocerradasParameterGeneral)throws Exception {
		 try {	
			VentasVentasNoCerradasParameterReturnGeneral ventasventasnocerradasReturnGeneral=new VentasVentasNoCerradasParameterReturnGeneral();
	
			VentasVentasNoCerradasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ventasventasnocerradass,ventasventasnocerradasParameterGeneral,ventasventasnocerradasReturnGeneral);
			
			return ventasventasnocerradasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VentasVentasNoCerradasParameterReturnGeneral procesarAccionVentasVentasNoCerradassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VentasVentasNoCerradas> ventasventasnocerradass,VentasVentasNoCerradasParameterReturnGeneral ventasventasnocerradasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			VentasVentasNoCerradasParameterReturnGeneral ventasventasnocerradasReturnGeneral=new VentasVentasNoCerradasParameterReturnGeneral();
	
			VentasVentasNoCerradasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ventasventasnocerradass,ventasventasnocerradasParameterGeneral,ventasventasnocerradasReturnGeneral);
			
			this.connexion.commit();
			
			return ventasventasnocerradasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

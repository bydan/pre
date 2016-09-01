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
import com.bydan.erp.facturacion.util.report.FacturasGeneralesParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.FacturasGeneralesParameterGeneral;
import com.bydan.erp.facturacion.util.report.FacturasGeneralesConstantesFunciones;
import com.bydan.erp.facturacion.business.entity.report.FacturasGenerales;

import com.bydan.erp.facturacion.business.logic.report.FacturasGeneralesLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class FacturasGeneralesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(FacturasGeneralesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected FacturasGeneralesLogic facturasgeneralesDataAccess; 		
	protected FacturasGenerales facturasgenerales;
	protected List<FacturasGenerales> facturasgeneraless;
	protected Object facturasgeneralesObject;	
	protected List<Object> facturasgeneralessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  FacturasGeneralesLogic()throws SQLException,Exception {
		try	{
			this.facturasgeneraless= new ArrayList<FacturasGenerales>();
			this.facturasgenerales= new FacturasGenerales();
			this.facturasgeneralesObject=new Object();
			this.facturasgeneralessObject=new ArrayList<Object>();
			
			this.facturasgeneralesDataAccess=this;
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
			this.facturasgeneralesDataAccess.setConnexionType(this.connexionType);
			this.facturasgeneralesDataAccess.setParameterDbType(this.parameterDbType);
			this.facturasgeneralesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturasGeneralesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.facturasgeneraless= new ArrayList<FacturasGenerales>();
			this.facturasgenerales= new FacturasGenerales();
			this.facturasgeneralesObject=new Object();
			this.facturasgeneralessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.facturasgeneralesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.facturasgeneralesDataAccess.setConnexionType(this.connexionType);
			this.facturasgeneralesDataAccess.setParameterDbType(this.parameterDbType);
			this.facturasgeneralesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FacturasGenerales getFacturasGenerales() throws Exception {	
		FacturasGeneralesLogicAdditional.checkFacturasGeneralesToGet(facturasgenerales,this.datosCliente,this.arrDatoGeneral);
		FacturasGeneralesLogicAdditional.updateFacturasGeneralesToGet(facturasgenerales,this.arrDatoGeneral);
		
		return facturasgenerales;
	}
		
	public void setFacturasGenerales(FacturasGenerales newFacturasGenerales) {
		this.facturasgenerales = newFacturasGenerales;
	}
	
	public List<FacturasGenerales> getFacturasGeneraless() throws Exception {		
		this.quitarFacturasGeneralessNulos();
		
		FacturasGeneralesLogicAdditional.checkFacturasGeneralesToGets(facturasgeneraless,this.datosCliente,this.arrDatoGeneral);
		
		for (FacturasGenerales facturasgeneralesLocal: facturasgeneraless ) {
			FacturasGeneralesLogicAdditional.updateFacturasGeneralesToGet(facturasgeneralesLocal,this.arrDatoGeneral);
		}
		
		return facturasgeneraless;
	}
	
	public void setFacturasGeneraless(List<FacturasGenerales> newFacturasGeneraless) {
		this.facturasgeneraless = newFacturasGeneraless;
	}
	
	public Object getFacturasGeneralesObject() {	
		//this.facturasgeneralesObject=this.facturasgeneralesDataAccess.getEntityObject();
		return this.facturasgeneralesObject;
	}
		
	public void setFacturasGeneralesObject(Object newFacturasGeneralesObject) {
		this.facturasgeneralesObject = newFacturasGeneralesObject;
	}
	
	public List<Object> getFacturasGeneralessObject() {		
		//this.facturasgeneralessObject=this.facturasgeneralesDataAccess.getEntitiesObject();
		return this.facturasgeneralessObject;
	}
		
	public void setFacturasGeneralessObject(List<Object> newFacturasGeneralessObject) {
		this.facturasgeneralessObject = newFacturasGeneralessObject;
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
		facturasgeneraless = new  ArrayList<FacturasGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		facturasgeneraless = new  ArrayList<FacturasGenerales>();
		  		  
        try {
			//FacturasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturasgeneraless = new  ArrayList<FacturasGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		facturasgeneraless = new  ArrayList<FacturasGenerales>();
		  		  
        try {
			//FacturasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		facturasgeneraless = new  ArrayList<FacturasGenerales>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		facturasgeneraless = new  ArrayList<FacturasGenerales>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//FacturasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<FacturasGenerales> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasGenerales> entities = new  ArrayList<FacturasGenerales>();
		FacturasGenerales entity = new FacturasGenerales();		  
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
	
	public  List<FacturasGenerales> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasGenerales> entities = new  ArrayList<FacturasGenerales>();
		FacturasGenerales entity = new FacturasGenerales();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturasGenerales();
				
				
      	    	entity=FacturasGeneralesLogic.getEntityFacturasGenerales("",entity,resultSet);
      	    	
				//entity.setFacturasGeneralesOriginal( new FacturasGenerales());
      	    	//entity.setFacturasGeneralesOriginal(super.getEntity("",entity.getFacturasGeneralesOriginal(),resultSet,FacturasGeneralesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturasGeneralesOriginal(FacturasGeneralesDataAccess.getEntityFacturasGenerales("",entity.getFacturasGeneralesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<FacturasGenerales> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasGenerales> entities = new  ArrayList<FacturasGenerales>();
		FacturasGenerales entity = new FacturasGenerales();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,FacturasGenerales.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<FacturasGenerales>((List<FacturasGenerales>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setFacturasGeneralessOriginal(entities);
			
			}  else {
				this.facturasgeneralessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//FacturasGeneralesConstantesFunciones.quitarEspaciosFacturasGeneraless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static FacturasGenerales getEntityFacturasGenerales(String strPrefijo,FacturasGenerales entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_zona(resultSet.getString(strPrefijo+FacturasGeneralesConstantesFunciones.NOMBREZONA));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+FacturasGeneralesConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setnombre_tipo_factura(resultSet.getString(strPrefijo+FacturasGeneralesConstantesFunciones.NOMBRETIPOFACTURA));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+FacturasGeneralesConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+FacturasGeneralesConstantesFunciones.FECHAVENCIMIENTO).getTime()));
			entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+FacturasGeneralesConstantesFunciones.NUMEROPREIMPRESO));
			entity.settotal_descuento(resultSet.getDouble(strPrefijo+FacturasGeneralesConstantesFunciones.TOTALDESCUENTO));
			entity.settotal_otro(resultSet.getDouble(strPrefijo+FacturasGeneralesConstantesFunciones.TOTALOTRO));
			entity.setsub_total(resultSet.getDouble(strPrefijo+FacturasGeneralesConstantesFunciones.SUBTOTAL));
			entity.settotal(resultSet.getDouble(strPrefijo+FacturasGeneralesConstantesFunciones.TOTAL));
			entity.setiva(resultSet.getDouble(strPrefijo+FacturasGeneralesConstantesFunciones.IVA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FacturasGenerales getEntityFacturasGenerales(String strPrefijo,FacturasGenerales entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = FacturasGenerales.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = FacturasGenerales.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				FacturasGeneralesLogic.setFieldReflectionFacturasGenerales(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFacturasGenerales(Field field,String strPrefijo,String sColumn,FacturasGenerales entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturasGeneralesConstantesFunciones.NOMBREZONA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturasGeneralesConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturasGeneralesConstantesFunciones.NOMBRETIPOFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturasGeneralesConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturasGeneralesConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturasGeneralesConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturasGeneralesConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasGeneralesConstantesFunciones.TOTALOTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasGeneralesConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasGeneralesConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasGeneralesConstantesFunciones.IVA:
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
	
	public void quitarFacturasGeneralessNulos() throws Exception {				
		
		List<FacturasGenerales> facturasgeneralessAux= new ArrayList<FacturasGenerales>();
		
		for(FacturasGenerales facturasgenerales:facturasgeneraless) {
			if(facturasgenerales!=null) {
				facturasgeneralessAux.add(facturasgenerales);
			}
		}
		
		facturasgeneraless=facturasgeneralessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<FacturasGenerales> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasGenerales> entities = new  ArrayList<FacturasGenerales>();
		FacturasGenerales entity = new FacturasGenerales();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<FacturasGenerales>((List<FacturasGenerales>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setFacturasGeneralessOriginal(entities);
			
			}  else {
				this.facturasgeneralessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//FacturasGeneralesConstantesFunciones.quitarEspaciosFacturasGeneraless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		facturasgeneraless = new  ArrayList<FacturasGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		facturasgeneraless = new  ArrayList<FacturasGenerales>();
		  		  
        try {
			//FacturasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<FacturasGenerales> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturasGenerales> entities = new  ArrayList<FacturasGenerales>();
		FacturasGenerales entity = new FacturasGenerales();		  
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
	
	public  List<FacturasGenerales> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturasGenerales> entities = new  ArrayList<FacturasGenerales>();
		FacturasGenerales entity = new FacturasGenerales();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturasGenerales();
				
				if(conMapGenerico) {
					entity.setMapFacturasGenerales( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapFacturasGenerales().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturasGeneralesDataAccess.ISWITHSCHEMA);         		
					entity=FacturasGeneralesLogic.getEntityFacturasGenerales("",entity,resultSet,listColumns);
					
					////entity.setFacturasGeneralesOriginal( new FacturasGenerales());
					////entity.setFacturasGeneralesOriginal(super.getEntity("",entity.getFacturasGeneralesOriginal(),resultSet,FacturasGeneralesDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturasGeneralesOriginal(FacturasGeneralesDataAccess.getEntityFacturasGenerales("",entity.getFacturasGeneralesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Zona getZona(Connexion connexion,FacturasGenerales relfacturasgenerales)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);
			zonaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			zona=zonaDataAccess.getEntity(connexion,relfacturasgenerales.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public Empresa getEmpresa(Connexion connexion,FacturasGenerales relfacturasgenerales)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relfacturasgenerales.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FacturasGenerales relfacturasgenerales)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relfacturasgenerales.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,FacturasGenerales relfacturasgenerales)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relfacturasgenerales.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoFactura getTipoFactura(Connexion connexion,FacturasGenerales relfacturasgenerales)throws SQLException,Exception {

		TipoFactura tipofactura= new TipoFactura();

		try {
			TipoFacturaDataAccess tipofacturaDataAccess=new TipoFacturaDataAccess();

			tipofacturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofacturaDataAccess.setConnexionType(this.connexionType);
			tipofacturaDataAccess.setParameterDbType(this.parameterDbType);
			tipofacturaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipofactura=tipofacturaDataAccess.getEntity(connexion,relfacturasgenerales.getid_tipo_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofactura;

	}


	
	
	public void getFacturasGeneralessBusquedaFacturasGeneralesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_zona,Long id_tipo_cliente,Long id_tipo_factura,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//FacturasGeneralesLogic facturasgeneralesLogic=new FacturasGeneralesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=FacturasGeneralesLogic.GetSelecSqlFacturasGenerales(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_zona,id_tipo_cliente,id_tipo_factura,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.facturasgeneraless=this.getFacturasGeneraless();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getFacturasGeneralessBusquedaFacturasGenerales(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_zona,Long id_tipo_cliente,Long id_tipo_factura,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//FacturasGeneralesLogic facturasgeneralesLogic=new FacturasGeneralesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=FacturasGeneralesLogic.GetSelecSqlFacturasGenerales(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_zona,id_tipo_cliente,id_tipo_factura,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.facturasgeneraless=this.getFacturasGeneraless();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlFacturasGenerales(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_zona,Long id_tipo_cliente,Long id_tipo_factura,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("FacturasGenerales_Postgres.sql");
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
				

				if(id_zona!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_zona = "+id_zona.toString();
					existeWhere=true;
				}

				if(id_tipo_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_tipo_cliente = "+id_tipo_cliente.toString();
					existeWhere=true;
				}

				if(id_tipo_factura!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_tipo_factura = "+id_tipo_factura.toString();
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
	
	
	public void deepLoad(FacturasGenerales facturasgenerales,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturasGeneralesLogicAdditional.updateFacturasGeneralesToGet(facturasgenerales,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturasgenerales.setZona(facturasgeneralesDataAccess.getZona(connexion,facturasgenerales));
		facturasgenerales.setEmpresa(facturasgeneralesDataAccess.getEmpresa(connexion,facturasgenerales));
		facturasgenerales.setSucursal(facturasgeneralesDataAccess.getSucursal(connexion,facturasgenerales));
		facturasgenerales.setCliente(facturasgeneralesDataAccess.getCliente(connexion,facturasgenerales));
		facturasgenerales.setTipoFactura(facturasgeneralesDataAccess.getTipoFactura(connexion,facturasgenerales));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				facturasgenerales.setZona(facturasgeneralesDataAccess.getZona(connexion,facturasgenerales));
			}

			if(clas.clas.equals(Empresa.class)) {
				facturasgenerales.setEmpresa(facturasgeneralesDataAccess.getEmpresa(connexion,facturasgenerales));
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturasgenerales.setSucursal(facturasgeneralesDataAccess.getSucursal(connexion,facturasgenerales));
			}

			if(clas.clas.equals(Cliente.class)) {
				facturasgenerales.setCliente(facturasgeneralesDataAccess.getCliente(connexion,facturasgenerales));
			}

			if(clas.clas.equals(TipoFactura.class)) {
				facturasgenerales.setTipoFactura(facturasgeneralesDataAccess.getTipoFactura(connexion,facturasgenerales));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setZona(facturasgeneralesDataAccess.getZona(connexion,facturasgenerales));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setEmpresa(facturasgeneralesDataAccess.getEmpresa(connexion,facturasgenerales));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setSucursal(facturasgeneralesDataAccess.getSucursal(connexion,facturasgenerales));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setCliente(facturasgeneralesDataAccess.getCliente(connexion,facturasgenerales));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFactura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setTipoFactura(facturasgeneralesDataAccess.getTipoFactura(connexion,facturasgenerales));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturasgenerales.setZona(facturasgeneralesDataAccess.getZona(connexion,facturasgenerales));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(facturasgenerales.getZona(),isDeep,deepLoadType,clases);
				
		facturasgenerales.setEmpresa(facturasgeneralesDataAccess.getEmpresa(connexion,facturasgenerales));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturasgenerales.getEmpresa(),isDeep,deepLoadType,clases);
				
		facturasgenerales.setSucursal(facturasgeneralesDataAccess.getSucursal(connexion,facturasgenerales));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturasgenerales.getSucursal(),isDeep,deepLoadType,clases);
				
		facturasgenerales.setCliente(facturasgeneralesDataAccess.getCliente(connexion,facturasgenerales));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(facturasgenerales.getCliente(),isDeep,deepLoadType,clases);
				
		facturasgenerales.setTipoFactura(facturasgeneralesDataAccess.getTipoFactura(connexion,facturasgenerales));
		TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
		tipofacturaLogic.deepLoad(facturasgenerales.getTipoFactura(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				facturasgenerales.setZona(facturasgeneralesDataAccess.getZona(connexion,facturasgenerales));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(facturasgenerales.getZona(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				facturasgenerales.setEmpresa(facturasgeneralesDataAccess.getEmpresa(connexion,facturasgenerales));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(facturasgenerales.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturasgenerales.setSucursal(facturasgeneralesDataAccess.getSucursal(connexion,facturasgenerales));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(facturasgenerales.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				facturasgenerales.setCliente(facturasgeneralesDataAccess.getCliente(connexion,facturasgenerales));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(facturasgenerales.getCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoFactura.class)) {
				facturasgenerales.setTipoFactura(facturasgeneralesDataAccess.getTipoFactura(connexion,facturasgenerales));
				TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
				tipofacturaLogic.deepLoad(facturasgenerales.getTipoFactura(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setZona(facturasgeneralesDataAccess.getZona(connexion,facturasgenerales));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(facturasgenerales.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setEmpresa(facturasgeneralesDataAccess.getEmpresa(connexion,facturasgenerales));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(facturasgenerales.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setSucursal(facturasgeneralesDataAccess.getSucursal(connexion,facturasgenerales));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(facturasgenerales.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setCliente(facturasgeneralesDataAccess.getCliente(connexion,facturasgenerales));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(facturasgenerales.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFactura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasgenerales.setTipoFactura(facturasgeneralesDataAccess.getTipoFactura(connexion,facturasgenerales));
			TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
			tipofacturaLogic.deepLoad(facturasgenerales.getTipoFactura(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(facturasgenerales,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturasGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesFacturasGenerales(facturasgenerales);
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
			this.deepLoad(this.facturasgenerales,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturasGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesFacturasGenerales(this.facturasgenerales);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(facturasgeneraless!=null) {
				for(FacturasGenerales facturasgenerales:facturasgeneraless) {
					this.deepLoad(facturasgenerales,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturasGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesFacturasGenerales(facturasgeneraless);
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
			if(facturasgeneraless!=null) {
				for(FacturasGenerales facturasgenerales:facturasgeneraless) {
					this.deepLoad(facturasgenerales,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturasGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesFacturasGenerales(facturasgeneraless);
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
	
	public FacturasGeneralesParameterReturnGeneral procesarAccionFacturasGeneraless(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturasGenerales> facturasgeneraless,FacturasGeneralesParameterReturnGeneral facturasgeneralesParameterGeneral)throws Exception {
		 try {	
			FacturasGeneralesParameterReturnGeneral facturasgeneralesReturnGeneral=new FacturasGeneralesParameterReturnGeneral();
	
			FacturasGeneralesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturasgeneraless,facturasgeneralesParameterGeneral,facturasgeneralesReturnGeneral);
			
			return facturasgeneralesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturasGeneralesParameterReturnGeneral procesarAccionFacturasGeneralessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturasGenerales> facturasgeneraless,FacturasGeneralesParameterReturnGeneral facturasgeneralesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			FacturasGeneralesParameterReturnGeneral facturasgeneralesReturnGeneral=new FacturasGeneralesParameterReturnGeneral();
	
			FacturasGeneralesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturasgeneraless,facturasgeneralesParameterGeneral,facturasgeneralesReturnGeneral);
			
			this.connexion.commit();
			
			return facturasgeneralesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

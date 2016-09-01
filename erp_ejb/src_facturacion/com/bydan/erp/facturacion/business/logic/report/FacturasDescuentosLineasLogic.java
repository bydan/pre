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
import com.bydan.erp.facturacion.util.report.FacturasDescuentosLineasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.FacturasDescuentosLineasParameterGeneral;
import com.bydan.erp.facturacion.util.report.FacturasDescuentosLineasConstantesFunciones;
import com.bydan.erp.facturacion.business.entity.report.FacturasDescuentosLineas;

import com.bydan.erp.facturacion.business.logic.report.FacturasDescuentosLineasLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;






@SuppressWarnings("unused")
public class FacturasDescuentosLineasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(FacturasDescuentosLineasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected FacturasDescuentosLineasLogic facturasdescuentoslineasDataAccess; 		
	protected FacturasDescuentosLineas facturasdescuentoslineas;
	protected List<FacturasDescuentosLineas> facturasdescuentoslineass;
	protected Object facturasdescuentoslineasObject;	
	protected List<Object> facturasdescuentoslineassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  FacturasDescuentosLineasLogic()throws SQLException,Exception {
		try	{
			this.facturasdescuentoslineass= new ArrayList<FacturasDescuentosLineas>();
			this.facturasdescuentoslineas= new FacturasDescuentosLineas();
			this.facturasdescuentoslineasObject=new Object();
			this.facturasdescuentoslineassObject=new ArrayList<Object>();
			
			this.facturasdescuentoslineasDataAccess=this;
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
			this.facturasdescuentoslineasDataAccess.setConnexionType(this.connexionType);
			this.facturasdescuentoslineasDataAccess.setParameterDbType(this.parameterDbType);
			this.facturasdescuentoslineasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturasDescuentosLineasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.facturasdescuentoslineass= new ArrayList<FacturasDescuentosLineas>();
			this.facturasdescuentoslineas= new FacturasDescuentosLineas();
			this.facturasdescuentoslineasObject=new Object();
			this.facturasdescuentoslineassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.facturasdescuentoslineasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.facturasdescuentoslineasDataAccess.setConnexionType(this.connexionType);
			this.facturasdescuentoslineasDataAccess.setParameterDbType(this.parameterDbType);
			this.facturasdescuentoslineasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FacturasDescuentosLineas getFacturasDescuentosLineas() throws Exception {	
		FacturasDescuentosLineasLogicAdditional.checkFacturasDescuentosLineasToGet(facturasdescuentoslineas,this.datosCliente,this.arrDatoGeneral);
		FacturasDescuentosLineasLogicAdditional.updateFacturasDescuentosLineasToGet(facturasdescuentoslineas,this.arrDatoGeneral);
		
		return facturasdescuentoslineas;
	}
		
	public void setFacturasDescuentosLineas(FacturasDescuentosLineas newFacturasDescuentosLineas) {
		this.facturasdescuentoslineas = newFacturasDescuentosLineas;
	}
	
	public List<FacturasDescuentosLineas> getFacturasDescuentosLineass() throws Exception {		
		this.quitarFacturasDescuentosLineassNulos();
		
		FacturasDescuentosLineasLogicAdditional.checkFacturasDescuentosLineasToGets(facturasdescuentoslineass,this.datosCliente,this.arrDatoGeneral);
		
		for (FacturasDescuentosLineas facturasdescuentoslineasLocal: facturasdescuentoslineass ) {
			FacturasDescuentosLineasLogicAdditional.updateFacturasDescuentosLineasToGet(facturasdescuentoslineasLocal,this.arrDatoGeneral);
		}
		
		return facturasdescuentoslineass;
	}
	
	public void setFacturasDescuentosLineass(List<FacturasDescuentosLineas> newFacturasDescuentosLineass) {
		this.facturasdescuentoslineass = newFacturasDescuentosLineass;
	}
	
	public Object getFacturasDescuentosLineasObject() {	
		//this.facturasdescuentoslineasObject=this.facturasdescuentoslineasDataAccess.getEntityObject();
		return this.facturasdescuentoslineasObject;
	}
		
	public void setFacturasDescuentosLineasObject(Object newFacturasDescuentosLineasObject) {
		this.facturasdescuentoslineasObject = newFacturasDescuentosLineasObject;
	}
	
	public List<Object> getFacturasDescuentosLineassObject() {		
		//this.facturasdescuentoslineassObject=this.facturasdescuentoslineasDataAccess.getEntitiesObject();
		return this.facturasdescuentoslineassObject;
	}
		
	public void setFacturasDescuentosLineassObject(List<Object> newFacturasDescuentosLineassObject) {
		this.facturasdescuentoslineassObject = newFacturasDescuentosLineassObject;
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
		facturasdescuentoslineass = new  ArrayList<FacturasDescuentosLineas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasDescuentosLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasdescuentoslineass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		facturasdescuentoslineass = new  ArrayList<FacturasDescuentosLineas>();
		  		  
        try {
			//FacturasDescuentosLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasdescuentoslineass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturasdescuentoslineass = new  ArrayList<FacturasDescuentosLineas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasDescuentosLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasdescuentoslineass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		facturasdescuentoslineass = new  ArrayList<FacturasDescuentosLineas>();
		  		  
        try {
			//FacturasDescuentosLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasdescuentoslineass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		facturasdescuentoslineass = new  ArrayList<FacturasDescuentosLineas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasDescuentosLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasdescuentoslineass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		facturasdescuentoslineass = new  ArrayList<FacturasDescuentosLineas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//FacturasDescuentosLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasdescuentoslineass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<FacturasDescuentosLineas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasDescuentosLineas> entities = new  ArrayList<FacturasDescuentosLineas>();
		FacturasDescuentosLineas entity = new FacturasDescuentosLineas();		  
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
	
	public  List<FacturasDescuentosLineas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasDescuentosLineas> entities = new  ArrayList<FacturasDescuentosLineas>();
		FacturasDescuentosLineas entity = new FacturasDescuentosLineas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturasDescuentosLineas();
				
				
      	    	entity=FacturasDescuentosLineasLogic.getEntityFacturasDescuentosLineas("",entity,resultSet);
      	    	
				//entity.setFacturasDescuentosLineasOriginal( new FacturasDescuentosLineas());
      	    	//entity.setFacturasDescuentosLineasOriginal(super.getEntity("",entity.getFacturasDescuentosLineasOriginal(),resultSet,FacturasDescuentosLineasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturasDescuentosLineasOriginal(FacturasDescuentosLineasDataAccess.getEntityFacturasDescuentosLineas("",entity.getFacturasDescuentosLineasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<FacturasDescuentosLineas> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasDescuentosLineas> entities = new  ArrayList<FacturasDescuentosLineas>();
		FacturasDescuentosLineas entity = new FacturasDescuentosLineas();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,FacturasDescuentosLineas.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<FacturasDescuentosLineas>((List<FacturasDescuentosLineas>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setFacturasDescuentosLineassOriginal(entities);
			
			}  else {
				this.facturasdescuentoslineassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//FacturasDescuentosLineasConstantesFunciones.quitarEspaciosFacturasDescuentosLineass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static FacturasDescuentosLineas getEntityFacturasDescuentosLineas(String strPrefijo,FacturasDescuentosLineas entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre(resultSet.getString(strPrefijo+FacturasDescuentosLineasConstantesFunciones.NOMBRE));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+FacturasDescuentosLineasConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setnombre_tipo_factura(resultSet.getString(strPrefijo+FacturasDescuentosLineasConstantesFunciones.NOMBRETIPOFACTURA));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+FacturasDescuentosLineasConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+FacturasDescuentosLineasConstantesFunciones.FECHAVENCIMIENTO).getTime()));
			entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+FacturasDescuentosLineasConstantesFunciones.NUMEROPREIMPRESO));
			entity.settotal_descuento(resultSet.getDouble(strPrefijo+FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO));
			entity.settotal_otro(resultSet.getDouble(strPrefijo+FacturasDescuentosLineasConstantesFunciones.TOTALOTRO));
			entity.setsub_total(resultSet.getDouble(strPrefijo+FacturasDescuentosLineasConstantesFunciones.SUBTOTAL));
			entity.settotal(resultSet.getDouble(strPrefijo+FacturasDescuentosLineasConstantesFunciones.TOTAL));
			entity.setiva(resultSet.getDouble(strPrefijo+FacturasDescuentosLineasConstantesFunciones.IVA));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FacturasDescuentosLineas getEntityFacturasDescuentosLineas(String strPrefijo,FacturasDescuentosLineas entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = FacturasDescuentosLineas.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = FacturasDescuentosLineas.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				FacturasDescuentosLineasLogic.setFieldReflectionFacturasDescuentosLineas(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFacturasDescuentosLineas(Field field,String strPrefijo,String sColumn,FacturasDescuentosLineas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturasDescuentosLineasConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.NOMBRETIPOFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.TOTALOTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasDescuentosLineasConstantesFunciones.IVA:
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
	
	public void quitarFacturasDescuentosLineassNulos() throws Exception {				
		
		List<FacturasDescuentosLineas> facturasdescuentoslineassAux= new ArrayList<FacturasDescuentosLineas>();
		
		for(FacturasDescuentosLineas facturasdescuentoslineas:facturasdescuentoslineass) {
			if(facturasdescuentoslineas!=null) {
				facturasdescuentoslineassAux.add(facturasdescuentoslineas);
			}
		}
		
		facturasdescuentoslineass=facturasdescuentoslineassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<FacturasDescuentosLineas> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasDescuentosLineas> entities = new  ArrayList<FacturasDescuentosLineas>();
		FacturasDescuentosLineas entity = new FacturasDescuentosLineas();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<FacturasDescuentosLineas>((List<FacturasDescuentosLineas>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setFacturasDescuentosLineassOriginal(entities);
			
			}  else {
				this.facturasdescuentoslineassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//FacturasDescuentosLineasConstantesFunciones.quitarEspaciosFacturasDescuentosLineass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		facturasdescuentoslineass = new  ArrayList<FacturasDescuentosLineas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasDescuentosLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasdescuentoslineass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		facturasdescuentoslineass = new  ArrayList<FacturasDescuentosLineas>();
		  		  
        try {
			//FacturasDescuentosLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturasdescuentoslineass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<FacturasDescuentosLineas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturasDescuentosLineas> entities = new  ArrayList<FacturasDescuentosLineas>();
		FacturasDescuentosLineas entity = new FacturasDescuentosLineas();		  
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
	
	public  List<FacturasDescuentosLineas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturasDescuentosLineas> entities = new  ArrayList<FacturasDescuentosLineas>();
		FacturasDescuentosLineas entity = new FacturasDescuentosLineas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturasDescuentosLineas();
				
				if(conMapGenerico) {
					entity.setMapFacturasDescuentosLineas( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapFacturasDescuentosLineas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturasDescuentosLineasDataAccess.ISWITHSCHEMA);         		
					entity=FacturasDescuentosLineasLogic.getEntityFacturasDescuentosLineas("",entity,resultSet,listColumns);
					
					////entity.setFacturasDescuentosLineasOriginal( new FacturasDescuentosLineas());
					////entity.setFacturasDescuentosLineasOriginal(super.getEntity("",entity.getFacturasDescuentosLineasOriginal(),resultSet,FacturasDescuentosLineasDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturasDescuentosLineasOriginal(FacturasDescuentosLineasDataAccess.getEntityFacturasDescuentosLineas("",entity.getFacturasDescuentosLineasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,FacturasDescuentosLineas relfacturasdescuentoslineas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relfacturasdescuentoslineas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FacturasDescuentosLineas relfacturasdescuentoslineas)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relfacturasdescuentoslineas.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Vendedor getVendedor(Connexion connexion,FacturasDescuentosLineas relfacturasdescuentoslineas)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);
			vendedorDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			vendedor=vendedorDataAccess.getEntity(connexion,relfacturasdescuentoslineas.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}


	
	
	public void getFacturasDescuentosLineassBusquedaFacturasDescuentosLineasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_vendedor,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//FacturasDescuentosLineasLogic facturasdescuentoslineasLogic=new FacturasDescuentosLineasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=FacturasDescuentosLineasLogic.GetSelecSqlFacturasDescuentosLineas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_vendedor,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.facturasdescuentoslineass=this.getFacturasDescuentosLineass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getFacturasDescuentosLineassBusquedaFacturasDescuentosLineas(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_vendedor,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//FacturasDescuentosLineasLogic facturasdescuentoslineasLogic=new FacturasDescuentosLineasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=FacturasDescuentosLineasLogic.GetSelecSqlFacturasDescuentosLineas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_vendedor,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.facturasdescuentoslineass=this.getFacturasDescuentosLineass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlFacturasDescuentosLineas(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_vendedor,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("FacturasDescuentosLineas_Postgres.sql");
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
				

				if(id_vendedor!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_vendedor = "+id_vendedor.toString();
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
	
	
	public void deepLoad(FacturasDescuentosLineas facturasdescuentoslineas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturasDescuentosLineasLogicAdditional.updateFacturasDescuentosLineasToGet(facturasdescuentoslineas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturasdescuentoslineas.setEmpresa(facturasdescuentoslineasDataAccess.getEmpresa(connexion,facturasdescuentoslineas));
		facturasdescuentoslineas.setSucursal(facturasdescuentoslineasDataAccess.getSucursal(connexion,facturasdescuentoslineas));
		facturasdescuentoslineas.setVendedor(facturasdescuentoslineasDataAccess.getVendedor(connexion,facturasdescuentoslineas));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturasdescuentoslineas.setEmpresa(facturasdescuentoslineasDataAccess.getEmpresa(connexion,facturasdescuentoslineas));
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturasdescuentoslineas.setSucursal(facturasdescuentoslineasDataAccess.getSucursal(connexion,facturasdescuentoslineas));
			}

			if(clas.clas.equals(Vendedor.class)) {
				facturasdescuentoslineas.setVendedor(facturasdescuentoslineasDataAccess.getVendedor(connexion,facturasdescuentoslineas));
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
			facturasdescuentoslineas.setEmpresa(facturasdescuentoslineasDataAccess.getEmpresa(connexion,facturasdescuentoslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasdescuentoslineas.setSucursal(facturasdescuentoslineasDataAccess.getSucursal(connexion,facturasdescuentoslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasdescuentoslineas.setVendedor(facturasdescuentoslineasDataAccess.getVendedor(connexion,facturasdescuentoslineas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturasdescuentoslineas.setEmpresa(facturasdescuentoslineasDataAccess.getEmpresa(connexion,facturasdescuentoslineas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturasdescuentoslineas.getEmpresa(),isDeep,deepLoadType,clases);
				
		facturasdescuentoslineas.setSucursal(facturasdescuentoslineasDataAccess.getSucursal(connexion,facturasdescuentoslineas));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturasdescuentoslineas.getSucursal(),isDeep,deepLoadType,clases);
				
		facturasdescuentoslineas.setVendedor(facturasdescuentoslineasDataAccess.getVendedor(connexion,facturasdescuentoslineas));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(facturasdescuentoslineas.getVendedor(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturasdescuentoslineas.setEmpresa(facturasdescuentoslineasDataAccess.getEmpresa(connexion,facturasdescuentoslineas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(facturasdescuentoslineas.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturasdescuentoslineas.setSucursal(facturasdescuentoslineasDataAccess.getSucursal(connexion,facturasdescuentoslineas));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(facturasdescuentoslineas.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Vendedor.class)) {
				facturasdescuentoslineas.setVendedor(facturasdescuentoslineasDataAccess.getVendedor(connexion,facturasdescuentoslineas));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(facturasdescuentoslineas.getVendedor(),isDeep,deepLoadType,clases);				
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
			facturasdescuentoslineas.setEmpresa(facturasdescuentoslineasDataAccess.getEmpresa(connexion,facturasdescuentoslineas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(facturasdescuentoslineas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasdescuentoslineas.setSucursal(facturasdescuentoslineasDataAccess.getSucursal(connexion,facturasdescuentoslineas));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(facturasdescuentoslineas.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturasdescuentoslineas.setVendedor(facturasdescuentoslineasDataAccess.getVendedor(connexion,facturasdescuentoslineas));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(facturasdescuentoslineas.getVendedor(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(facturasdescuentoslineas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturasDescuentosLineasConstantesFunciones.refrescarForeignKeysDescripcionesFacturasDescuentosLineas(facturasdescuentoslineas);
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
			this.deepLoad(this.facturasdescuentoslineas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturasDescuentosLineasConstantesFunciones.refrescarForeignKeysDescripcionesFacturasDescuentosLineas(this.facturasdescuentoslineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(facturasdescuentoslineass!=null) {
				for(FacturasDescuentosLineas facturasdescuentoslineas:facturasdescuentoslineass) {
					this.deepLoad(facturasdescuentoslineas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturasDescuentosLineasConstantesFunciones.refrescarForeignKeysDescripcionesFacturasDescuentosLineas(facturasdescuentoslineass);
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
			if(facturasdescuentoslineass!=null) {
				for(FacturasDescuentosLineas facturasdescuentoslineas:facturasdescuentoslineass) {
					this.deepLoad(facturasdescuentoslineas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturasDescuentosLineasConstantesFunciones.refrescarForeignKeysDescripcionesFacturasDescuentosLineas(facturasdescuentoslineass);
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
	
	public FacturasDescuentosLineasParameterReturnGeneral procesarAccionFacturasDescuentosLineass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturasDescuentosLineas> facturasdescuentoslineass,FacturasDescuentosLineasParameterReturnGeneral facturasdescuentoslineasParameterGeneral)throws Exception {
		 try {	
			FacturasDescuentosLineasParameterReturnGeneral facturasdescuentoslineasReturnGeneral=new FacturasDescuentosLineasParameterReturnGeneral();
	
			FacturasDescuentosLineasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturasdescuentoslineass,facturasdescuentoslineasParameterGeneral,facturasdescuentoslineasReturnGeneral);
			
			return facturasdescuentoslineasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturasDescuentosLineasParameterReturnGeneral procesarAccionFacturasDescuentosLineassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturasDescuentosLineas> facturasdescuentoslineass,FacturasDescuentosLineasParameterReturnGeneral facturasdescuentoslineasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			FacturasDescuentosLineasParameterReturnGeneral facturasdescuentoslineasReturnGeneral=new FacturasDescuentosLineasParameterReturnGeneral();
	
			FacturasDescuentosLineasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturasdescuentoslineass,facturasdescuentoslineasParameterGeneral,facturasdescuentoslineasReturnGeneral);
			
			this.connexion.commit();
			
			return facturasdescuentoslineasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

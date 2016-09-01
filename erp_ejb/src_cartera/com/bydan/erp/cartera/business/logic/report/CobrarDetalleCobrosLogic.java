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
package com.bydan.erp.cartera.business.logic.report;

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

import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.resources.general.AuxiliarGeneral;
import com.bydan.erp.cartera.util.report.CobrarDetalleCobrosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarDetalleCobrosParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarDetalleCobrosConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarDetalleCobros;

import com.bydan.erp.cartera.business.logic.report.CobrarDetalleCobrosLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarDetalleCobrosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarDetalleCobrosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarDetalleCobrosLogic cobrardetallecobrosDataAccess; 		
	protected CobrarDetalleCobros cobrardetallecobros;
	protected List<CobrarDetalleCobros> cobrardetallecobross;
	protected Object cobrardetallecobrosObject;	
	protected List<Object> cobrardetallecobrossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarDetalleCobrosLogic()throws SQLException,Exception {
		try	{
			this.cobrardetallecobross= new ArrayList<CobrarDetalleCobros>();
			this.cobrardetallecobros= new CobrarDetalleCobros();
			this.cobrardetallecobrosObject=new Object();
			this.cobrardetallecobrossObject=new ArrayList<Object>();
			
			this.cobrardetallecobrosDataAccess=this;
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
			this.cobrardetallecobrosDataAccess.setConnexionType(this.connexionType);
			this.cobrardetallecobrosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrardetallecobrosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarDetalleCobrosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrardetallecobross= new ArrayList<CobrarDetalleCobros>();
			this.cobrardetallecobros= new CobrarDetalleCobros();
			this.cobrardetallecobrosObject=new Object();
			this.cobrardetallecobrossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrardetallecobrosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrardetallecobrosDataAccess.setConnexionType(this.connexionType);
			this.cobrardetallecobrosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrardetallecobrosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarDetalleCobros getCobrarDetalleCobros() throws Exception {	
		CobrarDetalleCobrosLogicAdditional.checkCobrarDetalleCobrosToGet(cobrardetallecobros,this.datosCliente,this.arrDatoGeneral);
		CobrarDetalleCobrosLogicAdditional.updateCobrarDetalleCobrosToGet(cobrardetallecobros,this.arrDatoGeneral);
		
		return cobrardetallecobros;
	}
		
	public void setCobrarDetalleCobros(CobrarDetalleCobros newCobrarDetalleCobros) {
		this.cobrardetallecobros = newCobrarDetalleCobros;
	}
	
	public List<CobrarDetalleCobros> getCobrarDetalleCobross() throws Exception {		
		this.quitarCobrarDetalleCobrossNulos();
		
		CobrarDetalleCobrosLogicAdditional.checkCobrarDetalleCobrosToGets(cobrardetallecobross,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarDetalleCobros cobrardetallecobrosLocal: cobrardetallecobross ) {
			CobrarDetalleCobrosLogicAdditional.updateCobrarDetalleCobrosToGet(cobrardetallecobrosLocal,this.arrDatoGeneral);
		}
		
		return cobrardetallecobross;
	}
	
	public void setCobrarDetalleCobross(List<CobrarDetalleCobros> newCobrarDetalleCobross) {
		this.cobrardetallecobross = newCobrarDetalleCobross;
	}
	
	public Object getCobrarDetalleCobrosObject() {	
		//this.cobrardetallecobrosObject=this.cobrardetallecobrosDataAccess.getEntityObject();
		return this.cobrardetallecobrosObject;
	}
		
	public void setCobrarDetalleCobrosObject(Object newCobrarDetalleCobrosObject) {
		this.cobrardetallecobrosObject = newCobrarDetalleCobrosObject;
	}
	
	public List<Object> getCobrarDetalleCobrossObject() {		
		//this.cobrardetallecobrossObject=this.cobrardetallecobrosDataAccess.getEntitiesObject();
		return this.cobrardetallecobrossObject;
	}
		
	public void setCobrarDetalleCobrossObject(List<Object> newCobrarDetalleCobrossObject) {
		this.cobrardetallecobrossObject = newCobrarDetalleCobrossObject;
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
		cobrardetallecobross = new  ArrayList<CobrarDetalleCobros>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarDetalleCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrardetallecobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrardetallecobross = new  ArrayList<CobrarDetalleCobros>();
		  		  
        try {
			//CobrarDetalleCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrardetallecobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrardetallecobross = new  ArrayList<CobrarDetalleCobros>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarDetalleCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrardetallecobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrardetallecobross = new  ArrayList<CobrarDetalleCobros>();
		  		  
        try {
			//CobrarDetalleCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrardetallecobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrardetallecobross = new  ArrayList<CobrarDetalleCobros>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarDetalleCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrardetallecobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrardetallecobross = new  ArrayList<CobrarDetalleCobros>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarDetalleCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrardetallecobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarDetalleCobros> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarDetalleCobros> entities = new  ArrayList<CobrarDetalleCobros>();
		CobrarDetalleCobros entity = new CobrarDetalleCobros();		  
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
	
	public  List<CobrarDetalleCobros> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarDetalleCobros> entities = new  ArrayList<CobrarDetalleCobros>();
		CobrarDetalleCobros entity = new CobrarDetalleCobros();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarDetalleCobros();
				
				
      	    	entity=CobrarDetalleCobrosLogic.getEntityCobrarDetalleCobros("",entity,resultSet);
      	    	
				//entity.setCobrarDetalleCobrosOriginal( new CobrarDetalleCobros());
      	    	//entity.setCobrarDetalleCobrosOriginal(super.getEntity("",entity.getCobrarDetalleCobrosOriginal(),resultSet,CobrarDetalleCobrosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarDetalleCobrosOriginal(CobrarDetalleCobrosDataAccess.getEntityCobrarDetalleCobros("",entity.getCobrarDetalleCobrosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarDetalleCobros> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarDetalleCobros> entities = new  ArrayList<CobrarDetalleCobros>();
		CobrarDetalleCobros entity = new CobrarDetalleCobros();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarDetalleCobros.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarDetalleCobros>((List<CobrarDetalleCobros>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarDetalleCobrossOriginal(entities);
			
			}  else {
				this.cobrardetallecobrossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarDetalleCobrosConstantesFunciones.quitarEspaciosCobrarDetalleCobross(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarDetalleCobros getEntityCobrarDetalleCobros(String strPrefijo,CobrarDetalleCobros entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_vendedor(resultSet.getString(strPrefijo+CobrarDetalleCobrosConstantesFunciones.NOMBREVENDEDOR));
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarDetalleCobrosConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+CobrarDetalleCobrosConstantesFunciones.NOMBRE));
			entity.setapellido(resultSet.getString(strPrefijo+CobrarDetalleCobrosConstantesFunciones.APELLIDO));
			entity.settotal_facturas(resultSet.getDouble(strPrefijo+CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS));
			entity.settotal_abonos(resultSet.getDouble(strPrefijo+CobrarDetalleCobrosConstantesFunciones.TOTALABONOS));
			entity.settotal_facturas_actual(resultSet.getDouble(strPrefijo+CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL));
			entity.setabonos_anterior(resultSet.getDouble(strPrefijo+CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR));
			entity.setabonos_actual(resultSet.getDouble(strPrefijo+CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarDetalleCobros getEntityCobrarDetalleCobros(String strPrefijo,CobrarDetalleCobros entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarDetalleCobros.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarDetalleCobros.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarDetalleCobrosLogic.setFieldReflectionCobrarDetalleCobros(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarDetalleCobros(Field field,String strPrefijo,String sColumn,CobrarDetalleCobros entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarDetalleCobrosConstantesFunciones.NOMBREVENDEDOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarDetalleCobrosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarDetalleCobrosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarDetalleCobrosConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarDetalleCobrosConstantesFunciones.TOTALABONOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL:
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
	
	public void quitarCobrarDetalleCobrossNulos() throws Exception {				
		
		List<CobrarDetalleCobros> cobrardetallecobrossAux= new ArrayList<CobrarDetalleCobros>();
		
		for(CobrarDetalleCobros cobrardetallecobros:cobrardetallecobross) {
			if(cobrardetallecobros!=null) {
				cobrardetallecobrossAux.add(cobrardetallecobros);
			}
		}
		
		cobrardetallecobross=cobrardetallecobrossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarDetalleCobros> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarDetalleCobros> entities = new  ArrayList<CobrarDetalleCobros>();
		CobrarDetalleCobros entity = new CobrarDetalleCobros();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarDetalleCobros>((List<CobrarDetalleCobros>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarDetalleCobrossOriginal(entities);
			
			}  else {
				this.cobrardetallecobrossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarDetalleCobrosConstantesFunciones.quitarEspaciosCobrarDetalleCobross(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrardetallecobross = new  ArrayList<CobrarDetalleCobros>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarDetalleCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrardetallecobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrardetallecobross = new  ArrayList<CobrarDetalleCobros>();
		  		  
        try {
			//CobrarDetalleCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrardetallecobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarDetalleCobros> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarDetalleCobros> entities = new  ArrayList<CobrarDetalleCobros>();
		CobrarDetalleCobros entity = new CobrarDetalleCobros();		  
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
	
	public  List<CobrarDetalleCobros> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarDetalleCobros> entities = new  ArrayList<CobrarDetalleCobros>();
		CobrarDetalleCobros entity = new CobrarDetalleCobros();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarDetalleCobros();
				
				if(conMapGenerico) {
					entity.setMapCobrarDetalleCobros( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarDetalleCobros().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarDetalleCobrosDataAccess.ISWITHSCHEMA);         		
					entity=CobrarDetalleCobrosLogic.getEntityCobrarDetalleCobros("",entity,resultSet,listColumns);
					
					////entity.setCobrarDetalleCobrosOriginal( new CobrarDetalleCobros());
					////entity.setCobrarDetalleCobrosOriginal(super.getEntity("",entity.getCobrarDetalleCobrosOriginal(),resultSet,CobrarDetalleCobrosDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarDetalleCobrosOriginal(CobrarDetalleCobrosDataAccess.getEntityCobrarDetalleCobros("",entity.getCobrarDetalleCobrosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarDetalleCobros relcobrardetallecobros)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrardetallecobros.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Pais getPais(Connexion connexion,CobrarDetalleCobros relcobrardetallecobros)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);
			paisDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			pais=paisDataAccess.getEntity(connexion,relcobrardetallecobros.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,CobrarDetalleCobros relcobrardetallecobros)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);
			ciudadDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ciudad=ciudadDataAccess.getEntity(connexion,relcobrardetallecobros.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,CobrarDetalleCobros relcobrardetallecobros)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);
			zonaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			zona=zonaDataAccess.getEntity(connexion,relcobrardetallecobros.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public GrupoCliente getGrupoCliente(Connexion connexion,CobrarDetalleCobros relcobrardetallecobros)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			grupoclienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relcobrardetallecobros.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}

	public Vendedor getVendedor(Connexion connexion,CobrarDetalleCobros relcobrardetallecobros)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);
			vendedorDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			vendedor=vendedorDataAccess.getEntity(connexion,relcobrardetallecobros.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}


	
	
	public void getCobrarDetalleCobrossBusquedaCobrarDetalleCobrosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_pais,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor,Date fecha_emision,Date fecha_emision_hasta)throws Exception {
		try {
			//CobrarDetalleCobrosLogic cobrardetallecobrosLogic=new CobrarDetalleCobrosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarDetalleCobrosLogic.GetSelecSqlCobrarDetalleCobros(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_pais,id_ciudad,id_zona,id_grupo_cliente,id_vendedor,fecha_emision,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrardetallecobross=this.getCobrarDetalleCobross();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarDetalleCobrossBusquedaCobrarDetalleCobros(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_pais,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor,Date fecha_emision,Date fecha_emision_hasta)throws Exception {
		try {
			//CobrarDetalleCobrosLogic cobrardetallecobrosLogic=new CobrarDetalleCobrosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarDetalleCobrosLogic.GetSelecSqlCobrarDetalleCobros(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_pais,id_ciudad,id_zona,id_grupo_cliente,id_vendedor,fecha_emision,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrardetallecobross=this.getCobrarDetalleCobross();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarDetalleCobros(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_pais,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor,Date fecha_emision,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarDetalleCobros_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				sSelectQuery=sSelectQuery.replace("IDEMPRESA", parametroGeneralUsuario.getid_empresa().toString());
				

				sSelectQuery=sSelectQuery.replace("ID_PAIS", id_pais.toString());

				sSelectQuery=sSelectQuery.replace("ID_CIUDAD", id_ciudad.toString());

				sSelectQuery=sSelectQuery.replace("ID_ZONA", id_zona.toString());

				sSelectQuery=sSelectQuery.replace("ID_GRUPO_CLIENTE", id_grupo_cliente.toString());

				sSelectQuery=sSelectQuery.replace("ID_VENDEDOR", id_vendedor.toString());

				sSelectQuery=sSelectQuery.replace("FECHA_EMISION_DESDE", Funciones2.getStringPostgresDate(fecha_emision));

				sSelectQuery=sSelectQuery.replace("FECHA_EMISION_HASTA", Funciones2.getStringPostgresDate(fecha_emision_hasta));

				sSql=sSelectQuery;

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
	
	
	public void deepLoad(CobrarDetalleCobros cobrardetallecobros,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarDetalleCobrosLogicAdditional.updateCobrarDetalleCobrosToGet(cobrardetallecobros,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrardetallecobros.setEmpresa(cobrardetallecobrosDataAccess.getEmpresa(connexion,cobrardetallecobros));
		cobrardetallecobros.setPais(cobrardetallecobrosDataAccess.getPais(connexion,cobrardetallecobros));
		cobrardetallecobros.setCiudad(cobrardetallecobrosDataAccess.getCiudad(connexion,cobrardetallecobros));
		cobrardetallecobros.setZona(cobrardetallecobrosDataAccess.getZona(connexion,cobrardetallecobros));
		cobrardetallecobros.setGrupoCliente(cobrardetallecobrosDataAccess.getGrupoCliente(connexion,cobrardetallecobros));
		cobrardetallecobros.setVendedor(cobrardetallecobrosDataAccess.getVendedor(connexion,cobrardetallecobros));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrardetallecobros.setEmpresa(cobrardetallecobrosDataAccess.getEmpresa(connexion,cobrardetallecobros));
			}

			if(clas.clas.equals(Pais.class)) {
				cobrardetallecobros.setPais(cobrardetallecobrosDataAccess.getPais(connexion,cobrardetallecobros));
			}

			if(clas.clas.equals(Ciudad.class)) {
				cobrardetallecobros.setCiudad(cobrardetallecobrosDataAccess.getCiudad(connexion,cobrardetallecobros));
			}

			if(clas.clas.equals(Zona.class)) {
				cobrardetallecobros.setZona(cobrardetallecobrosDataAccess.getZona(connexion,cobrardetallecobros));
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				cobrardetallecobros.setGrupoCliente(cobrardetallecobrosDataAccess.getGrupoCliente(connexion,cobrardetallecobros));
			}

			if(clas.clas.equals(Vendedor.class)) {
				cobrardetallecobros.setVendedor(cobrardetallecobrosDataAccess.getVendedor(connexion,cobrardetallecobros));
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
			cobrardetallecobros.setEmpresa(cobrardetallecobrosDataAccess.getEmpresa(connexion,cobrardetallecobros));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setPais(cobrardetallecobrosDataAccess.getPais(connexion,cobrardetallecobros));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setCiudad(cobrardetallecobrosDataAccess.getCiudad(connexion,cobrardetallecobros));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setZona(cobrardetallecobrosDataAccess.getZona(connexion,cobrardetallecobros));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setGrupoCliente(cobrardetallecobrosDataAccess.getGrupoCliente(connexion,cobrardetallecobros));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setVendedor(cobrardetallecobrosDataAccess.getVendedor(connexion,cobrardetallecobros));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrardetallecobros.setEmpresa(cobrardetallecobrosDataAccess.getEmpresa(connexion,cobrardetallecobros));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrardetallecobros.getEmpresa(),isDeep,deepLoadType,clases);
				
		cobrardetallecobros.setPais(cobrardetallecobrosDataAccess.getPais(connexion,cobrardetallecobros));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(cobrardetallecobros.getPais(),isDeep,deepLoadType,clases);
				
		cobrardetallecobros.setCiudad(cobrardetallecobrosDataAccess.getCiudad(connexion,cobrardetallecobros));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(cobrardetallecobros.getCiudad(),isDeep,deepLoadType,clases);
				
		cobrardetallecobros.setZona(cobrardetallecobrosDataAccess.getZona(connexion,cobrardetallecobros));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(cobrardetallecobros.getZona(),isDeep,deepLoadType,clases);
				
		cobrardetallecobros.setGrupoCliente(cobrardetallecobrosDataAccess.getGrupoCliente(connexion,cobrardetallecobros));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(cobrardetallecobros.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		cobrardetallecobros.setVendedor(cobrardetallecobrosDataAccess.getVendedor(connexion,cobrardetallecobros));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(cobrardetallecobros.getVendedor(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrardetallecobros.setEmpresa(cobrardetallecobrosDataAccess.getEmpresa(connexion,cobrardetallecobros));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrardetallecobros.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Pais.class)) {
				cobrardetallecobros.setPais(cobrardetallecobrosDataAccess.getPais(connexion,cobrardetallecobros));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(cobrardetallecobros.getPais(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ciudad.class)) {
				cobrardetallecobros.setCiudad(cobrardetallecobrosDataAccess.getCiudad(connexion,cobrardetallecobros));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(cobrardetallecobros.getCiudad(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Zona.class)) {
				cobrardetallecobros.setZona(cobrardetallecobrosDataAccess.getZona(connexion,cobrardetallecobros));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(cobrardetallecobros.getZona(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				cobrardetallecobros.setGrupoCliente(cobrardetallecobrosDataAccess.getGrupoCliente(connexion,cobrardetallecobros));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(cobrardetallecobros.getGrupoCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Vendedor.class)) {
				cobrardetallecobros.setVendedor(cobrardetallecobrosDataAccess.getVendedor(connexion,cobrardetallecobros));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(cobrardetallecobros.getVendedor(),isDeep,deepLoadType,clases);				
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
			cobrardetallecobros.setEmpresa(cobrardetallecobrosDataAccess.getEmpresa(connexion,cobrardetallecobros));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrardetallecobros.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setPais(cobrardetallecobrosDataAccess.getPais(connexion,cobrardetallecobros));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(cobrardetallecobros.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setCiudad(cobrardetallecobrosDataAccess.getCiudad(connexion,cobrardetallecobros));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(cobrardetallecobros.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setZona(cobrardetallecobrosDataAccess.getZona(connexion,cobrardetallecobros));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(cobrardetallecobros.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setGrupoCliente(cobrardetallecobrosDataAccess.getGrupoCliente(connexion,cobrardetallecobros));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(cobrardetallecobros.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrardetallecobros.setVendedor(cobrardetallecobrosDataAccess.getVendedor(connexion,cobrardetallecobros));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(cobrardetallecobros.getVendedor(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrardetallecobros,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarDetalleCobrosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarDetalleCobros(cobrardetallecobros);
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
			this.deepLoad(this.cobrardetallecobros,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarDetalleCobrosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarDetalleCobros(this.cobrardetallecobros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrardetallecobross!=null) {
				for(CobrarDetalleCobros cobrardetallecobros:cobrardetallecobross) {
					this.deepLoad(cobrardetallecobros,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarDetalleCobrosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarDetalleCobros(cobrardetallecobross);
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
			if(cobrardetallecobross!=null) {
				for(CobrarDetalleCobros cobrardetallecobros:cobrardetallecobross) {
					this.deepLoad(cobrardetallecobros,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarDetalleCobrosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarDetalleCobros(cobrardetallecobross);
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
	
	public CobrarDetalleCobrosParameterReturnGeneral procesarAccionCobrarDetalleCobross(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarDetalleCobros> cobrardetallecobross,CobrarDetalleCobrosParameterReturnGeneral cobrardetallecobrosParameterGeneral)throws Exception {
		 try {	
			CobrarDetalleCobrosParameterReturnGeneral cobrardetallecobrosReturnGeneral=new CobrarDetalleCobrosParameterReturnGeneral();
	
			CobrarDetalleCobrosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrardetallecobross,cobrardetallecobrosParameterGeneral,cobrardetallecobrosReturnGeneral);
			
			return cobrardetallecobrosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarDetalleCobrosParameterReturnGeneral procesarAccionCobrarDetalleCobrossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarDetalleCobros> cobrardetallecobross,CobrarDetalleCobrosParameterReturnGeneral cobrardetallecobrosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarDetalleCobrosParameterReturnGeneral cobrardetallecobrosReturnGeneral=new CobrarDetalleCobrosParameterReturnGeneral();
	
			CobrarDetalleCobrosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrardetallecobross,cobrardetallecobrosParameterGeneral,cobrardetallecobrosReturnGeneral);
			
			this.connexion.commit();
			
			return cobrardetallecobrosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

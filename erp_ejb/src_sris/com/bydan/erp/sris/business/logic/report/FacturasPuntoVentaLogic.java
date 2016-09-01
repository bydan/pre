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
package com.bydan.erp.sris.business.logic.report;

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

import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.resources.general.AuxiliarGeneral;
import com.bydan.erp.sris.util.report.FacturasPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.FacturasPuntoVentaParameterGeneral;
import com.bydan.erp.sris.util.report.FacturasPuntoVentaConstantesFunciones;
import com.bydan.erp.sris.business.entity.report.FacturasPuntoVenta;

import com.bydan.erp.sris.business.logic.report.FacturasPuntoVentaLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class FacturasPuntoVentaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(FacturasPuntoVentaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected FacturasPuntoVentaLogic facturaspuntoventaDataAccess; 		
	protected FacturasPuntoVenta facturaspuntoventa;
	protected List<FacturasPuntoVenta> facturaspuntoventas;
	protected Object facturaspuntoventaObject;	
	protected List<Object> facturaspuntoventasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  FacturasPuntoVentaLogic()throws SQLException,Exception {
		try	{
			this.facturaspuntoventas= new ArrayList<FacturasPuntoVenta>();
			this.facturaspuntoventa= new FacturasPuntoVenta();
			this.facturaspuntoventaObject=new Object();
			this.facturaspuntoventasObject=new ArrayList<Object>();
			
			this.facturaspuntoventaDataAccess=this;
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
			this.facturaspuntoventaDataAccess.setConnexionType(this.connexionType);
			this.facturaspuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			this.facturaspuntoventaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturasPuntoVentaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.facturaspuntoventas= new ArrayList<FacturasPuntoVenta>();
			this.facturaspuntoventa= new FacturasPuntoVenta();
			this.facturaspuntoventaObject=new Object();
			this.facturaspuntoventasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.facturaspuntoventaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.facturaspuntoventaDataAccess.setConnexionType(this.connexionType);
			this.facturaspuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			this.facturaspuntoventaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FacturasPuntoVenta getFacturasPuntoVenta() throws Exception {	
		FacturasPuntoVentaLogicAdditional.checkFacturasPuntoVentaToGet(facturaspuntoventa,this.datosCliente,this.arrDatoGeneral);
		FacturasPuntoVentaLogicAdditional.updateFacturasPuntoVentaToGet(facturaspuntoventa,this.arrDatoGeneral);
		
		return facturaspuntoventa;
	}
		
	public void setFacturasPuntoVenta(FacturasPuntoVenta newFacturasPuntoVenta) {
		this.facturaspuntoventa = newFacturasPuntoVenta;
	}
	
	public List<FacturasPuntoVenta> getFacturasPuntoVentas() throws Exception {		
		this.quitarFacturasPuntoVentasNulos();
		
		FacturasPuntoVentaLogicAdditional.checkFacturasPuntoVentaToGets(facturaspuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (FacturasPuntoVenta facturaspuntoventaLocal: facturaspuntoventas ) {
			FacturasPuntoVentaLogicAdditional.updateFacturasPuntoVentaToGet(facturaspuntoventaLocal,this.arrDatoGeneral);
		}
		
		return facturaspuntoventas;
	}
	
	public void setFacturasPuntoVentas(List<FacturasPuntoVenta> newFacturasPuntoVentas) {
		this.facturaspuntoventas = newFacturasPuntoVentas;
	}
	
	public Object getFacturasPuntoVentaObject() {	
		//this.facturaspuntoventaObject=this.facturaspuntoventaDataAccess.getEntityObject();
		return this.facturaspuntoventaObject;
	}
		
	public void setFacturasPuntoVentaObject(Object newFacturasPuntoVentaObject) {
		this.facturaspuntoventaObject = newFacturasPuntoVentaObject;
	}
	
	public List<Object> getFacturasPuntoVentasObject() {		
		//this.facturaspuntoventasObject=this.facturaspuntoventaDataAccess.getEntitiesObject();
		return this.facturaspuntoventasObject;
	}
		
	public void setFacturasPuntoVentasObject(List<Object> newFacturasPuntoVentasObject) {
		this.facturaspuntoventasObject = newFacturasPuntoVentasObject;
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
		facturaspuntoventas = new  ArrayList<FacturasPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaspuntoventas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		facturaspuntoventas = new  ArrayList<FacturasPuntoVenta>();
		  		  
        try {
			//FacturasPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaspuntoventas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturaspuntoventas = new  ArrayList<FacturasPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaspuntoventas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		facturaspuntoventas = new  ArrayList<FacturasPuntoVenta>();
		  		  
        try {
			//FacturasPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaspuntoventas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		facturaspuntoventas = new  ArrayList<FacturasPuntoVenta>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaspuntoventas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		facturaspuntoventas = new  ArrayList<FacturasPuntoVenta>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//FacturasPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaspuntoventas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<FacturasPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasPuntoVenta> entities = new  ArrayList<FacturasPuntoVenta>();
		FacturasPuntoVenta entity = new FacturasPuntoVenta();		  
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
	
	public  List<FacturasPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasPuntoVenta> entities = new  ArrayList<FacturasPuntoVenta>();
		FacturasPuntoVenta entity = new FacturasPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturasPuntoVenta();
				
				
      	    	entity=FacturasPuntoVentaLogic.getEntityFacturasPuntoVenta("",entity,resultSet);
      	    	
				//entity.setFacturasPuntoVentaOriginal( new FacturasPuntoVenta());
      	    	//entity.setFacturasPuntoVentaOriginal(super.getEntity("",entity.getFacturasPuntoVentaOriginal(),resultSet,FacturasPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturasPuntoVentaOriginal(FacturasPuntoVentaDataAccess.getEntityFacturasPuntoVenta("",entity.getFacturasPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<FacturasPuntoVenta> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasPuntoVenta> entities = new  ArrayList<FacturasPuntoVenta>();
		FacturasPuntoVenta entity = new FacturasPuntoVenta();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,FacturasPuntoVenta.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<FacturasPuntoVenta>((List<FacturasPuntoVenta>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setFacturasPuntoVentasOriginal(entities);
			
			}  else {
				this.facturaspuntoventasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//FacturasPuntoVentaConstantesFunciones.quitarEspaciosFacturasPuntoVentas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static FacturasPuntoVenta getEntityFacturasPuntoVenta(String strPrefijo,FacturasPuntoVenta entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+FacturasPuntoVentaConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.settotal_iva(resultSet.getDouble(strPrefijo+FacturasPuntoVentaConstantesFunciones.TOTALIVA));
			entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+FacturasPuntoVentaConstantesFunciones.TOTALSINIVA));
			entity.setiva(resultSet.getDouble(strPrefijo+FacturasPuntoVentaConstantesFunciones.IVA));
			entity.setdescuento(resultSet.getDouble(strPrefijo+FacturasPuntoVentaConstantesFunciones.DESCUENTO));
			entity.settotal(resultSet.getDouble(strPrefijo+FacturasPuntoVentaConstantesFunciones.TOTAL));
			entity.setruc_cliente(resultSet.getString(strPrefijo+FacturasPuntoVentaConstantesFunciones.RUCCLIENTE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FacturasPuntoVenta getEntityFacturasPuntoVenta(String strPrefijo,FacturasPuntoVenta entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = FacturasPuntoVenta.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = FacturasPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				FacturasPuntoVentaLogic.setFieldReflectionFacturasPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFacturasPuntoVenta(Field field,String strPrefijo,String sColumn,FacturasPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturasPuntoVentaConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturasPuntoVentaConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasPuntoVentaConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasPuntoVentaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasPuntoVentaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasPuntoVentaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturasPuntoVentaConstantesFunciones.RUCCLIENTE:
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
	
	public void quitarFacturasPuntoVentasNulos() throws Exception {				
		
		List<FacturasPuntoVenta> facturaspuntoventasAux= new ArrayList<FacturasPuntoVenta>();
		
		for(FacturasPuntoVenta facturaspuntoventa:facturaspuntoventas) {
			if(facturaspuntoventa!=null) {
				facturaspuntoventasAux.add(facturaspuntoventa);
			}
		}
		
		facturaspuntoventas=facturaspuntoventasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<FacturasPuntoVenta> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturasPuntoVenta> entities = new  ArrayList<FacturasPuntoVenta>();
		FacturasPuntoVenta entity = new FacturasPuntoVenta();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<FacturasPuntoVenta>((List<FacturasPuntoVenta>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setFacturasPuntoVentasOriginal(entities);
			
			}  else {
				this.facturaspuntoventasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//FacturasPuntoVentaConstantesFunciones.quitarEspaciosFacturasPuntoVentas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		facturaspuntoventas = new  ArrayList<FacturasPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//FacturasPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaspuntoventas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		facturaspuntoventas = new  ArrayList<FacturasPuntoVenta>();
		  		  
        try {
			//FacturasPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaspuntoventas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<FacturasPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturasPuntoVenta> entities = new  ArrayList<FacturasPuntoVenta>();
		FacturasPuntoVenta entity = new FacturasPuntoVenta();		  
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
	
	public  List<FacturasPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturasPuntoVenta> entities = new  ArrayList<FacturasPuntoVenta>();
		FacturasPuntoVenta entity = new FacturasPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturasPuntoVenta();
				
				if(conMapGenerico) {
					entity.setMapFacturasPuntoVenta( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapFacturasPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturasPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=FacturasPuntoVentaLogic.getEntityFacturasPuntoVenta("",entity,resultSet,listColumns);
					
					////entity.setFacturasPuntoVentaOriginal( new FacturasPuntoVenta());
					////entity.setFacturasPuntoVentaOriginal(super.getEntity("",entity.getFacturasPuntoVentaOriginal(),resultSet,FacturasPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturasPuntoVentaOriginal(FacturasPuntoVentaDataAccess.getEntityFacturasPuntoVenta("",entity.getFacturasPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,FacturasPuntoVenta relfacturaspuntoventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relfacturaspuntoventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getFacturasPuntoVentasBusquedaFacturasPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//FacturasPuntoVentaLogic facturaspuntoventaLogic=new FacturasPuntoVentaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=FacturasPuntoVentaLogic.GetSelecSqlFacturasPuntoVenta(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.facturaspuntoventas=this.getFacturasPuntoVentas();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getFacturasPuntoVentasBusquedaFacturasPuntoVenta(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//FacturasPuntoVentaLogic facturaspuntoventaLogic=new FacturasPuntoVentaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=FacturasPuntoVentaLogic.GetSelecSqlFacturasPuntoVenta(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.facturaspuntoventas=this.getFacturasPuntoVentas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlFacturasPuntoVenta(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("FacturasPuntoVenta_Postgres.sql");
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
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" f.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
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
	
	
	public void deepLoad(FacturasPuntoVenta facturaspuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturasPuntoVentaLogicAdditional.updateFacturasPuntoVentaToGet(facturaspuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturaspuntoventa.setEmpresa(facturaspuntoventaDataAccess.getEmpresa(connexion,facturaspuntoventa));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturaspuntoventa.setEmpresa(facturaspuntoventaDataAccess.getEmpresa(connexion,facturaspuntoventa));
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
			facturaspuntoventa.setEmpresa(facturaspuntoventaDataAccess.getEmpresa(connexion,facturaspuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturaspuntoventa.setEmpresa(facturaspuntoventaDataAccess.getEmpresa(connexion,facturaspuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturaspuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturaspuntoventa.setEmpresa(facturaspuntoventaDataAccess.getEmpresa(connexion,facturaspuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(facturaspuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
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
			facturaspuntoventa.setEmpresa(facturaspuntoventaDataAccess.getEmpresa(connexion,facturaspuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(facturaspuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(facturaspuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturasPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturasPuntoVenta(facturaspuntoventa);
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
			this.deepLoad(this.facturaspuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturasPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturasPuntoVenta(this.facturaspuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(facturaspuntoventas!=null) {
				for(FacturasPuntoVenta facturaspuntoventa:facturaspuntoventas) {
					this.deepLoad(facturaspuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturasPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturasPuntoVenta(facturaspuntoventas);
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
			if(facturaspuntoventas!=null) {
				for(FacturasPuntoVenta facturaspuntoventa:facturaspuntoventas) {
					this.deepLoad(facturaspuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturasPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturasPuntoVenta(facturaspuntoventas);
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
	
	public FacturasPuntoVentaParameterReturnGeneral procesarAccionFacturasPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturasPuntoVenta> facturaspuntoventas,FacturasPuntoVentaParameterReturnGeneral facturaspuntoventaParameterGeneral)throws Exception {
		 try {	
			FacturasPuntoVentaParameterReturnGeneral facturaspuntoventaReturnGeneral=new FacturasPuntoVentaParameterReturnGeneral();
	
			FacturasPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturaspuntoventas,facturaspuntoventaParameterGeneral,facturaspuntoventaReturnGeneral);
			
			return facturaspuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturasPuntoVentaParameterReturnGeneral procesarAccionFacturasPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturasPuntoVenta> facturaspuntoventas,FacturasPuntoVentaParameterReturnGeneral facturaspuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			FacturasPuntoVentaParameterReturnGeneral facturaspuntoventaReturnGeneral=new FacturasPuntoVentaParameterReturnGeneral();
	
			FacturasPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturaspuntoventas,facturaspuntoventaParameterGeneral,facturaspuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return facturaspuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

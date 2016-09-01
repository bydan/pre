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
import com.bydan.erp.cartera.util.report.CobrarControlCarterasGeneralesParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarControlCarterasGeneralesParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarControlCarterasGeneralesConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarControlCarterasGenerales;

import com.bydan.erp.cartera.business.logic.report.CobrarControlCarterasGeneralesLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarControlCarterasGeneralesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarControlCarterasGeneralesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarControlCarterasGeneralesLogic cobrarcontrolcarterasgeneralesDataAccess; 		
	protected CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales;
	protected List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless;
	protected Object cobrarcontrolcarterasgeneralesObject;	
	protected List<Object> cobrarcontrolcarterasgeneralessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarControlCarterasGeneralesLogic()throws SQLException,Exception {
		try	{
			this.cobrarcontrolcarterasgeneraless= new ArrayList<CobrarControlCarterasGenerales>();
			this.cobrarcontrolcarterasgenerales= new CobrarControlCarterasGenerales();
			this.cobrarcontrolcarterasgeneralesObject=new Object();
			this.cobrarcontrolcarterasgeneralessObject=new ArrayList<Object>();
			
			this.cobrarcontrolcarterasgeneralesDataAccess=this;
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
			this.cobrarcontrolcarterasgeneralesDataAccess.setConnexionType(this.connexionType);
			this.cobrarcontrolcarterasgeneralesDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarcontrolcarterasgeneralesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarControlCarterasGeneralesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarcontrolcarterasgeneraless= new ArrayList<CobrarControlCarterasGenerales>();
			this.cobrarcontrolcarterasgenerales= new CobrarControlCarterasGenerales();
			this.cobrarcontrolcarterasgeneralesObject=new Object();
			this.cobrarcontrolcarterasgeneralessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarcontrolcarterasgeneralesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarcontrolcarterasgeneralesDataAccess.setConnexionType(this.connexionType);
			this.cobrarcontrolcarterasgeneralesDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarcontrolcarterasgeneralesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarControlCarterasGenerales getCobrarControlCarterasGenerales() throws Exception {	
		CobrarControlCarterasGeneralesLogicAdditional.checkCobrarControlCarterasGeneralesToGet(cobrarcontrolcarterasgenerales,this.datosCliente,this.arrDatoGeneral);
		CobrarControlCarterasGeneralesLogicAdditional.updateCobrarControlCarterasGeneralesToGet(cobrarcontrolcarterasgenerales,this.arrDatoGeneral);
		
		return cobrarcontrolcarterasgenerales;
	}
		
	public void setCobrarControlCarterasGenerales(CobrarControlCarterasGenerales newCobrarControlCarterasGenerales) {
		this.cobrarcontrolcarterasgenerales = newCobrarControlCarterasGenerales;
	}
	
	public List<CobrarControlCarterasGenerales> getCobrarControlCarterasGeneraless() throws Exception {		
		this.quitarCobrarControlCarterasGeneralessNulos();
		
		CobrarControlCarterasGeneralesLogicAdditional.checkCobrarControlCarterasGeneralesToGets(cobrarcontrolcarterasgeneraless,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesLocal: cobrarcontrolcarterasgeneraless ) {
			CobrarControlCarterasGeneralesLogicAdditional.updateCobrarControlCarterasGeneralesToGet(cobrarcontrolcarterasgeneralesLocal,this.arrDatoGeneral);
		}
		
		return cobrarcontrolcarterasgeneraless;
	}
	
	public void setCobrarControlCarterasGeneraless(List<CobrarControlCarterasGenerales> newCobrarControlCarterasGeneraless) {
		this.cobrarcontrolcarterasgeneraless = newCobrarControlCarterasGeneraless;
	}
	
	public Object getCobrarControlCarterasGeneralesObject() {	
		//this.cobrarcontrolcarterasgeneralesObject=this.cobrarcontrolcarterasgeneralesDataAccess.getEntityObject();
		return this.cobrarcontrolcarterasgeneralesObject;
	}
		
	public void setCobrarControlCarterasGeneralesObject(Object newCobrarControlCarterasGeneralesObject) {
		this.cobrarcontrolcarterasgeneralesObject = newCobrarControlCarterasGeneralesObject;
	}
	
	public List<Object> getCobrarControlCarterasGeneralessObject() {		
		//this.cobrarcontrolcarterasgeneralessObject=this.cobrarcontrolcarterasgeneralesDataAccess.getEntitiesObject();
		return this.cobrarcontrolcarterasgeneralessObject;
	}
		
	public void setCobrarControlCarterasGeneralessObject(List<Object> newCobrarControlCarterasGeneralessObject) {
		this.cobrarcontrolcarterasgeneralessObject = newCobrarControlCarterasGeneralessObject;
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
		cobrarcontrolcarterasgeneraless = new  ArrayList<CobrarControlCarterasGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarControlCarterasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarcontrolcarterasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarcontrolcarterasgeneraless = new  ArrayList<CobrarControlCarterasGenerales>();
		  		  
        try {
			//CobrarControlCarterasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarcontrolcarterasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarcontrolcarterasgeneraless = new  ArrayList<CobrarControlCarterasGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarControlCarterasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarcontrolcarterasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarcontrolcarterasgeneraless = new  ArrayList<CobrarControlCarterasGenerales>();
		  		  
        try {
			//CobrarControlCarterasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarcontrolcarterasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarcontrolcarterasgeneraless = new  ArrayList<CobrarControlCarterasGenerales>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarControlCarterasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarcontrolcarterasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarcontrolcarterasgeneraless = new  ArrayList<CobrarControlCarterasGenerales>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarControlCarterasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarcontrolcarterasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarControlCarterasGenerales> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarControlCarterasGenerales> entities = new  ArrayList<CobrarControlCarterasGenerales>();
		CobrarControlCarterasGenerales entity = new CobrarControlCarterasGenerales();		  
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
	
	public  List<CobrarControlCarterasGenerales> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarControlCarterasGenerales> entities = new  ArrayList<CobrarControlCarterasGenerales>();
		CobrarControlCarterasGenerales entity = new CobrarControlCarterasGenerales();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarControlCarterasGenerales();
				
				
      	    	entity=CobrarControlCarterasGeneralesLogic.getEntityCobrarControlCarterasGenerales("",entity,resultSet);
      	    	
				//entity.setCobrarControlCarterasGeneralesOriginal( new CobrarControlCarterasGenerales());
      	    	//entity.setCobrarControlCarterasGeneralesOriginal(super.getEntity("",entity.getCobrarControlCarterasGeneralesOriginal(),resultSet,CobrarControlCarterasGeneralesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarControlCarterasGeneralesOriginal(CobrarControlCarterasGeneralesDataAccess.getEntityCobrarControlCarterasGenerales("",entity.getCobrarControlCarterasGeneralesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarControlCarterasGenerales> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarControlCarterasGenerales> entities = new  ArrayList<CobrarControlCarterasGenerales>();
		CobrarControlCarterasGenerales entity = new CobrarControlCarterasGenerales();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarControlCarterasGenerales.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarControlCarterasGenerales>((List<CobrarControlCarterasGenerales>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarControlCarterasGeneralessOriginal(entities);
			
			}  else {
				this.cobrarcontrolcarterasgeneralessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarControlCarterasGeneralesConstantesFunciones.quitarEspaciosCobrarControlCarterasGeneraless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarControlCarterasGenerales getEntityCobrarControlCarterasGenerales(String strPrefijo,CobrarControlCarterasGenerales entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_ciudad(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECIUDAD));
			entity.setnombre_zona(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.NOMBREZONA));
			entity.setnombre_vendedor(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.NOMBREVENDEDOR));
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECOMPLETO));
			entity.setlimite_credito(resultSet.getDouble(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO));
			entity.setrepresentante(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.REPRESENTANTE));
			entity.setdia_pago(resultSet.getInt(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.DIAPAGO));
			entity.setnumero_comprobante(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.NUMEROCOMPROBANTE));
			entity.setnumero_factura(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.NUMEROFACTURA));
			entity.setdireccion_direccion(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.DIRECCIONDIRECCION));
			entity.settelefono_telefono(resultSet.getString(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.TELEFONOTELEFONO));
			entity.setfecha_emisio(new Date(resultSet.getDate(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIO).getTime()));
			entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.FECHAVENCE).getTime()));
			entity.setdias(resultSet.getInt(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.DIAS));
			entity.setsaldo(resultSet.getDouble(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.SALDO));
			entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL));
			entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL));
			entity.sethora_pago(resultSet.getTime(strPrefijo+CobrarControlCarterasGeneralesConstantesFunciones.HORAPAGO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarControlCarterasGenerales getEntityCobrarControlCarterasGenerales(String strPrefijo,CobrarControlCarterasGenerales entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarControlCarterasGenerales.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarControlCarterasGenerales.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarControlCarterasGeneralesLogic.setFieldReflectionCobrarControlCarterasGenerales(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarControlCarterasGenerales(Field field,String strPrefijo,String sColumn,CobrarControlCarterasGenerales entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECIUDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.NOMBREZONA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.NOMBREVENDEDOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.REPRESENTANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.DIAPAGO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.DIRECCIONDIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.TELEFONOTELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.DIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.SALDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarControlCarterasGeneralesConstantesFunciones.HORAPAGO:
					field.set(entity,resultSet.getTime(sCampo));
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
	
	public void quitarCobrarControlCarterasGeneralessNulos() throws Exception {				
		
		List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneralessAux= new ArrayList<CobrarControlCarterasGenerales>();
		
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales:cobrarcontrolcarterasgeneraless) {
			if(cobrarcontrolcarterasgenerales!=null) {
				cobrarcontrolcarterasgeneralessAux.add(cobrarcontrolcarterasgenerales);
			}
		}
		
		cobrarcontrolcarterasgeneraless=cobrarcontrolcarterasgeneralessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarControlCarterasGenerales> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarControlCarterasGenerales> entities = new  ArrayList<CobrarControlCarterasGenerales>();
		CobrarControlCarterasGenerales entity = new CobrarControlCarterasGenerales();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarControlCarterasGenerales>((List<CobrarControlCarterasGenerales>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarControlCarterasGeneralessOriginal(entities);
			
			}  else {
				this.cobrarcontrolcarterasgeneralessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarControlCarterasGeneralesConstantesFunciones.quitarEspaciosCobrarControlCarterasGeneraless(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarcontrolcarterasgeneraless = new  ArrayList<CobrarControlCarterasGenerales>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarControlCarterasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarcontrolcarterasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarcontrolcarterasgeneraless = new  ArrayList<CobrarControlCarterasGenerales>();
		  		  
        try {
			//CobrarControlCarterasGeneralesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarcontrolcarterasgeneraless=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarControlCarterasGenerales> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarControlCarterasGenerales> entities = new  ArrayList<CobrarControlCarterasGenerales>();
		CobrarControlCarterasGenerales entity = new CobrarControlCarterasGenerales();		  
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
	
	public  List<CobrarControlCarterasGenerales> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarControlCarterasGenerales> entities = new  ArrayList<CobrarControlCarterasGenerales>();
		CobrarControlCarterasGenerales entity = new CobrarControlCarterasGenerales();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarControlCarterasGenerales();
				
				if(conMapGenerico) {
					entity.setMapCobrarControlCarterasGenerales( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarControlCarterasGenerales().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarControlCarterasGeneralesDataAccess.ISWITHSCHEMA);         		
					entity=CobrarControlCarterasGeneralesLogic.getEntityCobrarControlCarterasGenerales("",entity,resultSet,listColumns);
					
					////entity.setCobrarControlCarterasGeneralesOriginal( new CobrarControlCarterasGenerales());
					////entity.setCobrarControlCarterasGeneralesOriginal(super.getEntity("",entity.getCobrarControlCarterasGeneralesOriginal(),resultSet,CobrarControlCarterasGeneralesDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarControlCarterasGeneralesOriginal(CobrarControlCarterasGeneralesDataAccess.getEntityCobrarControlCarterasGenerales("",entity.getCobrarControlCarterasGeneralesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarControlCarterasGenerales relcobrarcontrolcarterasgenerales)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarcontrolcarterasgenerales.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getCobrarControlCarterasGeneralessBusquedaCobrarControlCarterasGeneralesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_hasta)throws Exception {
		try {
			//CobrarControlCarterasGeneralesLogic cobrarcontrolcarterasgeneralesLogic=new CobrarControlCarterasGeneralesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarControlCarterasGeneralesLogic.GetSelecSqlCobrarControlCarterasGenerales(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarcontrolcarterasgeneraless=this.getCobrarControlCarterasGeneraless();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarControlCarterasGeneralessBusquedaCobrarControlCarterasGenerales(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_hasta)throws Exception {
		try {
			//CobrarControlCarterasGeneralesLogic cobrarcontrolcarterasgeneralesLogic=new CobrarControlCarterasGeneralesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarControlCarterasGeneralesLogic.GetSelecSqlCobrarControlCarterasGenerales(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarcontrolcarterasgeneraless=this.getCobrarControlCarterasGeneraless();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarControlCarterasGenerales(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarControlCarterasGenerales_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" c.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" c.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(fecha_emision_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.fecha_emision<="+"'"+Funciones2.getStringPostgresDate(fecha_emision_hasta)+"'";
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
	
	
	public void deepLoad(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarControlCarterasGeneralesLogicAdditional.updateCobrarControlCarterasGeneralesToGet(cobrarcontrolcarterasgenerales,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarcontrolcarterasgenerales.setEmpresa(cobrarcontrolcarterasgeneralesDataAccess.getEmpresa(connexion,cobrarcontrolcarterasgenerales));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarcontrolcarterasgenerales.setEmpresa(cobrarcontrolcarterasgeneralesDataAccess.getEmpresa(connexion,cobrarcontrolcarterasgenerales));
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
			cobrarcontrolcarterasgenerales.setEmpresa(cobrarcontrolcarterasgeneralesDataAccess.getEmpresa(connexion,cobrarcontrolcarterasgenerales));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarcontrolcarterasgenerales.setEmpresa(cobrarcontrolcarterasgeneralesDataAccess.getEmpresa(connexion,cobrarcontrolcarterasgenerales));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarcontrolcarterasgenerales.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarcontrolcarterasgenerales.setEmpresa(cobrarcontrolcarterasgeneralesDataAccess.getEmpresa(connexion,cobrarcontrolcarterasgenerales));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarcontrolcarterasgenerales.getEmpresa(),isDeep,deepLoadType,clases);				
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
			cobrarcontrolcarterasgenerales.setEmpresa(cobrarcontrolcarterasgeneralesDataAccess.getEmpresa(connexion,cobrarcontrolcarterasgenerales));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarcontrolcarterasgenerales.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarcontrolcarterasgenerales,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarControlCarterasGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesCobrarControlCarterasGenerales(cobrarcontrolcarterasgenerales);
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
			this.deepLoad(this.cobrarcontrolcarterasgenerales,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarControlCarterasGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesCobrarControlCarterasGenerales(this.cobrarcontrolcarterasgenerales);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarcontrolcarterasgeneraless!=null) {
				for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales:cobrarcontrolcarterasgeneraless) {
					this.deepLoad(cobrarcontrolcarterasgenerales,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarControlCarterasGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesCobrarControlCarterasGenerales(cobrarcontrolcarterasgeneraless);
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
			if(cobrarcontrolcarterasgeneraless!=null) {
				for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales:cobrarcontrolcarterasgeneraless) {
					this.deepLoad(cobrarcontrolcarterasgenerales,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarControlCarterasGeneralesConstantesFunciones.refrescarForeignKeysDescripcionesCobrarControlCarterasGenerales(cobrarcontrolcarterasgeneraless);
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
	
	public CobrarControlCarterasGeneralesParameterReturnGeneral procesarAccionCobrarControlCarterasGeneraless(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,CobrarControlCarterasGeneralesParameterReturnGeneral cobrarcontrolcarterasgeneralesParameterGeneral)throws Exception {
		 try {	
			CobrarControlCarterasGeneralesParameterReturnGeneral cobrarcontrolcarterasgeneralesReturnGeneral=new CobrarControlCarterasGeneralesParameterReturnGeneral();
	
			CobrarControlCarterasGeneralesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarcontrolcarterasgeneraless,cobrarcontrolcarterasgeneralesParameterGeneral,cobrarcontrolcarterasgeneralesReturnGeneral);
			
			return cobrarcontrolcarterasgeneralesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarControlCarterasGeneralesParameterReturnGeneral procesarAccionCobrarControlCarterasGeneralessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,CobrarControlCarterasGeneralesParameterReturnGeneral cobrarcontrolcarterasgeneralesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarControlCarterasGeneralesParameterReturnGeneral cobrarcontrolcarterasgeneralesReturnGeneral=new CobrarControlCarterasGeneralesParameterReturnGeneral();
	
			CobrarControlCarterasGeneralesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarcontrolcarterasgeneraless,cobrarcontrolcarterasgeneralesParameterGeneral,cobrarcontrolcarterasgeneralesReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarcontrolcarterasgeneralesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

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
import com.bydan.erp.sris.util.report.SriComprasParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriComprasParameterGeneral;
import com.bydan.erp.sris.util.report.SriComprasConstantesFunciones;
import com.bydan.erp.sris.business.entity.report.SriCompras;

import com.bydan.erp.sris.business.logic.report.SriComprasLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class SriComprasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(SriComprasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected SriComprasLogic sricomprasDataAccess; 		
	protected SriCompras sricompras;
	protected List<SriCompras> sricomprass;
	protected Object sricomprasObject;	
	protected List<Object> sricomprassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  SriComprasLogic()throws SQLException,Exception {
		try	{
			this.sricomprass= new ArrayList<SriCompras>();
			this.sricompras= new SriCompras();
			this.sricomprasObject=new Object();
			this.sricomprassObject=new ArrayList<Object>();
			
			this.sricomprasDataAccess=this;
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
			this.sricomprasDataAccess.setConnexionType(this.connexionType);
			this.sricomprasDataAccess.setParameterDbType(this.parameterDbType);
			this.sricomprasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SriComprasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.sricomprass= new ArrayList<SriCompras>();
			this.sricompras= new SriCompras();
			this.sricomprasObject=new Object();
			this.sricomprassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.sricomprasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.sricomprasDataAccess.setConnexionType(this.connexionType);
			this.sricomprasDataAccess.setParameterDbType(this.parameterDbType);
			this.sricomprasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SriCompras getSriCompras() throws Exception {	
		SriComprasLogicAdditional.checkSriComprasToGet(sricompras,this.datosCliente,this.arrDatoGeneral);
		SriComprasLogicAdditional.updateSriComprasToGet(sricompras,this.arrDatoGeneral);
		
		return sricompras;
	}
		
	public void setSriCompras(SriCompras newSriCompras) {
		this.sricompras = newSriCompras;
	}
	
	public List<SriCompras> getSriComprass() throws Exception {		
		this.quitarSriComprassNulos();
		
		SriComprasLogicAdditional.checkSriComprasToGets(sricomprass,this.datosCliente,this.arrDatoGeneral);
		
		for (SriCompras sricomprasLocal: sricomprass ) {
			SriComprasLogicAdditional.updateSriComprasToGet(sricomprasLocal,this.arrDatoGeneral);
		}
		
		return sricomprass;
	}
	
	public void setSriComprass(List<SriCompras> newSriComprass) {
		this.sricomprass = newSriComprass;
	}
	
	public Object getSriComprasObject() {	
		//this.sricomprasObject=this.sricomprasDataAccess.getEntityObject();
		return this.sricomprasObject;
	}
		
	public void setSriComprasObject(Object newSriComprasObject) {
		this.sricomprasObject = newSriComprasObject;
	}
	
	public List<Object> getSriComprassObject() {		
		//this.sricomprassObject=this.sricomprasDataAccess.getEntitiesObject();
		return this.sricomprassObject;
	}
		
	public void setSriComprassObject(List<Object> newSriComprassObject) {
		this.sricomprassObject = newSriComprassObject;
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
		sricomprass = new  ArrayList<SriCompras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sricomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		sricomprass = new  ArrayList<SriCompras>();
		  		  
        try {
			//SriComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sricomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		sricomprass = new  ArrayList<SriCompras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sricomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		sricomprass = new  ArrayList<SriCompras>();
		  		  
        try {
			//SriComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sricomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		sricomprass = new  ArrayList<SriCompras>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sricomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		sricomprass = new  ArrayList<SriCompras>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//SriComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sricomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<SriCompras> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriCompras> entities = new  ArrayList<SriCompras>();
		SriCompras entity = new SriCompras();		  
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
	
	public  List<SriCompras> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriCompras> entities = new  ArrayList<SriCompras>();
		SriCompras entity = new SriCompras();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriCompras();
				
				
      	    	entity=SriComprasLogic.getEntitySriCompras("",entity,resultSet);
      	    	
				//entity.setSriComprasOriginal( new SriCompras());
      	    	//entity.setSriComprasOriginal(super.getEntity("",entity.getSriComprasOriginal(),resultSet,SriComprasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriComprasOriginal(SriComprasDataAccess.getEntitySriCompras("",entity.getSriComprasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<SriCompras> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriCompras> entities = new  ArrayList<SriCompras>();
		SriCompras entity = new SriCompras();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,SriCompras.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriCompras>((List<SriCompras>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriComprassOriginal(entities);
			
			}  else {
				this.sricomprassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriComprasConstantesFunciones.quitarEspaciosSriComprass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static SriCompras getEntitySriCompras(String strPrefijo,SriCompras entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_tipo_comprobante(resultSet.getString(strPrefijo+SriComprasConstantesFunciones.NOMBRETIPOCOMPROBANTE));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+SriComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setruc_dato(resultSet.getString(strPrefijo+SriComprasConstantesFunciones.RUCDATO));
			entity.setnumero_documento(resultSet.getString(strPrefijo+SriComprasConstantesFunciones.NUMERODOCUMENTO));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+SriComprasConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_registro_contable(new Date(resultSet.getDate(strPrefijo+SriComprasConstantesFunciones.FECHAREGISTROCONTABLE).getTime()));
			entity.setnumero_serie(resultSet.getString(strPrefijo+SriComprasConstantesFunciones.NUMEROSERIE));
			entity.setnumero_autorizacion(resultSet.getString(strPrefijo+SriComprasConstantesFunciones.NUMEROAUTORIZACION));
			entity.setbienes_iva(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.BIENESIVA));
			entity.setservicion_iva(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.SERVICIONIVA));
			entity.settotal_iva(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.TOTALIVA));
			entity.setbienes_sin_iva(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.BIENESSINIVA));
			entity.setservicios_sin_iva(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.SERVICIOSSINIVA));
			entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.TOTALSINIVA));
			entity.setid_tipo_iva(resultSet.getLong(strPrefijo+SriComprasConstantesFunciones.IDTIPOIVA));
			entity.setmonto_iva(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.MONTOIVA));
			entity.setmonto_ice(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.MONTOICE));
			entity.settransfe_iva_retener(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.TRANSFEIVARETENER));
			entity.setid_tipo_retencion_iva(resultSet.getLong(strPrefijo+SriComprasConstantesFunciones.IDTIPORETENCIONIVA));
			entity.settransfe_iva_retenido(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.TRANSFEIVARETENIDO));
			entity.setpresta_iva_retener(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.PRESTAIVARETENER));
			entity.setid_tipo_retencion_iva_presta(resultSet.getLong(strPrefijo+SriComprasConstantesFunciones.IDTIPORETENCIONIVAPRESTA));
			entity.setpresta_iva_retenido(resultSet.getDouble(strPrefijo+SriComprasConstantesFunciones.PRESTAIVARETENIDO));
			entity.setfecha_caducidad(new Date(resultSet.getDate(strPrefijo+SriComprasConstantesFunciones.FECHACADUCIDAD).getTime()));
			entity.setcodigo_asiento_contable(resultSet.getString(strPrefijo+SriComprasConstantesFunciones.CODIGOASIENTOCONTABLE));
			entity.setnumero_documento_contable(resultSet.getString(strPrefijo+SriComprasConstantesFunciones.NUMERODOCUMENTOCONTABLE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SriCompras getEntitySriCompras(String strPrefijo,SriCompras entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = SriCompras.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = SriCompras.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				SriComprasLogic.setFieldReflectionSriCompras(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSriCompras(Field field,String strPrefijo,String sColumn,SriCompras entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SriComprasConstantesFunciones.NOMBRETIPOCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriComprasConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriComprasConstantesFunciones.RUCDATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriComprasConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriComprasConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriComprasConstantesFunciones.FECHAREGISTROCONTABLE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriComprasConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriComprasConstantesFunciones.NUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriComprasConstantesFunciones.BIENESIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.SERVICIONIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.BIENESSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.SERVICIOSSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.IDTIPOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriComprasConstantesFunciones.MONTOIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.MONTOICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.TRANSFEIVARETENER:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.IDTIPORETENCIONIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriComprasConstantesFunciones.TRANSFEIVARETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.PRESTAIVARETENER:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.IDTIPORETENCIONIVAPRESTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriComprasConstantesFunciones.PRESTAIVARETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriComprasConstantesFunciones.FECHACADUCIDAD:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriComprasConstantesFunciones.CODIGOASIENTOCONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriComprasConstantesFunciones.NUMERODOCUMENTOCONTABLE:
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
	
	public void quitarSriComprassNulos() throws Exception {				
		
		List<SriCompras> sricomprassAux= new ArrayList<SriCompras>();
		
		for(SriCompras sricompras:sricomprass) {
			if(sricompras!=null) {
				sricomprassAux.add(sricompras);
			}
		}
		
		sricomprass=sricomprassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<SriCompras> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriCompras> entities = new  ArrayList<SriCompras>();
		SriCompras entity = new SriCompras();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriCompras>((List<SriCompras>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriComprassOriginal(entities);
			
			}  else {
				this.sricomprassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriComprasConstantesFunciones.quitarEspaciosSriComprass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		sricomprass = new  ArrayList<SriCompras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sricomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		sricomprass = new  ArrayList<SriCompras>();
		  		  
        try {
			//SriComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sricomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<SriCompras> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriCompras> entities = new  ArrayList<SriCompras>();
		SriCompras entity = new SriCompras();		  
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
	
	public  List<SriCompras> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriCompras> entities = new  ArrayList<SriCompras>();
		SriCompras entity = new SriCompras();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriCompras();
				
				if(conMapGenerico) {
					entity.setMapSriCompras( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapSriCompras().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SriComprasDataAccess.ISWITHSCHEMA);         		
					entity=SriComprasLogic.getEntitySriCompras("",entity,resultSet,listColumns);
					
					////entity.setSriComprasOriginal( new SriCompras());
					////entity.setSriComprasOriginal(super.getEntity("",entity.getSriComprasOriginal(),resultSet,SriComprasDataAccess.ISWITHSCHEMA));         		
					////entity.setSriComprasOriginal(SriComprasDataAccess.getEntitySriCompras("",entity.getSriComprasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,SriCompras relsricompras)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relsricompras.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public PeriodoDeclara getPeriodoDeclara(Connexion connexion,SriCompras relsricompras)throws SQLException,Exception {

		PeriodoDeclara periododeclara= new PeriodoDeclara();

		try {
			PeriodoDeclaraDataAccess periododeclaraDataAccess=new PeriodoDeclaraDataAccess();

			periododeclaraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periododeclaraDataAccess.setConnexionType(this.connexionType);
			periododeclaraDataAccess.setParameterDbType(this.parameterDbType);
			periododeclaraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periododeclara=periododeclaraDataAccess.getEntity(connexion,relsricompras.getid_periodo_declara());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periododeclara;

	}

	public Cliente getCliente(Connexion connexion,SriCompras relsricompras)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relsricompras.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoIva getTipoIva(Connexion connexion,SriCompras relsricompras)throws SQLException,Exception {

		TipoIva tipoiva= new TipoIva();

		try {
			TipoIvaDataAccess tipoivaDataAccess=new TipoIvaDataAccess();

			tipoivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoivaDataAccess.setConnexionType(this.connexionType);
			tipoivaDataAccess.setParameterDbType(this.parameterDbType);
			tipoivaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoiva=tipoivaDataAccess.getEntity(connexion,relsricompras.getid_tipo_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoiva;

	}

	public TipoRetencion getTipoRetencionIva(Connexion connexion,SriCompras relsricompras)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);
			tiporetencionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relsricompras.getid_tipo_retencion_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionIvaPresta(Connexion connexion,SriCompras relsricompras)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);
			tiporetencionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relsricompras.getid_tipo_retencion_iva_presta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}


	
	
	public void getSriComprassBusquedaSriComprasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_periodo_declara,Long id_cliente,String ruc)throws Exception {
		try {
			//SriComprasLogic sricomprasLogic=new SriComprasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriComprasLogic.GetSelecSqlSriCompras(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_periodo_declara,id_cliente,ruc);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.sricomprass=this.getSriComprass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getSriComprassBusquedaSriCompras(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_periodo_declara,Long id_cliente,String ruc)throws Exception {
		try {
			//SriComprasLogic sricomprasLogic=new SriComprasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriComprasLogic.GetSelecSqlSriCompras(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_periodo_declara,id_cliente,ruc);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.sricomprass=this.getSriComprass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlSriCompras(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_periodo_declara,Long id_cliente,String ruc)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("SriCompras_Postgres.sql");
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
					//sSqlWhere+=" l.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_periodo_declara!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" l.id_periodo_declara = "+id_periodo_declara.toString();
					existeWhere=true;
				}

				if(id_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" l.id_cliente = "+id_cliente.toString();
					existeWhere=true;
				}

				if(ruc!= null && !ruc.equals("")) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" l.ruc = "+"'"+ruc+"'";
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
	
	
	public void deepLoad(SriCompras sricompras,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SriComprasLogicAdditional.updateSriComprasToGet(sricompras,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sricompras.setEmpresa(sricomprasDataAccess.getEmpresa(connexion,sricompras));
		sricompras.setPeriodoDeclara(sricomprasDataAccess.getPeriodoDeclara(connexion,sricompras));
		sricompras.setCliente(sricomprasDataAccess.getCliente(connexion,sricompras));
		sricompras.setTipoIva(sricomprasDataAccess.getTipoIva(connexion,sricompras));
		sricompras.setTipoRetencionIva(sricomprasDataAccess.getTipoRetencionIva(connexion,sricompras));
		sricompras.setTipoRetencionIvaPresta(sricomprasDataAccess.getTipoRetencionIvaPresta(connexion,sricompras));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				sricompras.setEmpresa(sricomprasDataAccess.getEmpresa(connexion,sricompras));
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				sricompras.setPeriodoDeclara(sricomprasDataAccess.getPeriodoDeclara(connexion,sricompras));
			}

			if(clas.clas.equals(Cliente.class)) {
				sricompras.setCliente(sricomprasDataAccess.getCliente(connexion,sricompras));
			}

			if(clas.clas.equals(TipoIva.class)) {
				sricompras.setTipoIva(sricomprasDataAccess.getTipoIva(connexion,sricompras));
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				sricompras.setTipoRetencionIva(sricomprasDataAccess.getTipoRetencionIva(connexion,sricompras));
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				sricompras.setTipoRetencionIvaPresta(sricomprasDataAccess.getTipoRetencionIvaPresta(connexion,sricompras));
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
			sricompras.setEmpresa(sricomprasDataAccess.getEmpresa(connexion,sricompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setPeriodoDeclara(sricomprasDataAccess.getPeriodoDeclara(connexion,sricompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setCliente(sricomprasDataAccess.getCliente(connexion,sricompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setTipoIva(sricomprasDataAccess.getTipoIva(connexion,sricompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setTipoRetencionIva(sricomprasDataAccess.getTipoRetencionIva(connexion,sricompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setTipoRetencionIvaPresta(sricomprasDataAccess.getTipoRetencionIvaPresta(connexion,sricompras));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sricompras.setEmpresa(sricomprasDataAccess.getEmpresa(connexion,sricompras));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(sricompras.getEmpresa(),isDeep,deepLoadType,clases);
				
		sricompras.setPeriodoDeclara(sricomprasDataAccess.getPeriodoDeclara(connexion,sricompras));
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(sricompras.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		sricompras.setCliente(sricomprasDataAccess.getCliente(connexion,sricompras));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(sricompras.getCliente(),isDeep,deepLoadType,clases);
				
		sricompras.setTipoIva(sricomprasDataAccess.getTipoIva(connexion,sricompras));
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(sricompras.getTipoIva(),isDeep,deepLoadType,clases);
				
		sricompras.setTipoRetencionIva(sricomprasDataAccess.getTipoRetencionIva(connexion,sricompras));
		TipoRetencionLogic tiporetencionivaLogic= new TipoRetencionLogic(connexion);
		tiporetencionivaLogic.deepLoad(sricompras.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		sricompras.setTipoRetencionIvaPresta(sricomprasDataAccess.getTipoRetencionIvaPresta(connexion,sricompras));
		TipoRetencionLogic tiporetencionivaprestaLogic= new TipoRetencionLogic(connexion);
		tiporetencionivaprestaLogic.deepLoad(sricompras.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				sricompras.setEmpresa(sricomprasDataAccess.getEmpresa(connexion,sricompras));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(sricompras.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				sricompras.setPeriodoDeclara(sricomprasDataAccess.getPeriodoDeclara(connexion,sricompras));
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepLoad(sricompras.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				sricompras.setCliente(sricomprasDataAccess.getCliente(connexion,sricompras));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(sricompras.getCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoIva.class)) {
				sricompras.setTipoIva(sricomprasDataAccess.getTipoIva(connexion,sricompras));
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepLoad(sricompras.getTipoIva(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				sricompras.setTipoRetencionIva(sricomprasDataAccess.getTipoRetencionIva(connexion,sricompras));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(sricompras.getTipoRetencionIva(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				sricompras.setTipoRetencionIvaPresta(sricomprasDataAccess.getTipoRetencionIvaPresta(connexion,sricompras));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(sricompras.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);				
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
			sricompras.setEmpresa(sricomprasDataAccess.getEmpresa(connexion,sricompras));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(sricompras.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setPeriodoDeclara(sricomprasDataAccess.getPeriodoDeclara(connexion,sricompras));
			PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
			periododeclaraLogic.deepLoad(sricompras.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setCliente(sricomprasDataAccess.getCliente(connexion,sricompras));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(sricompras.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setTipoIva(sricomprasDataAccess.getTipoIva(connexion,sricompras));
			TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
			tipoivaLogic.deepLoad(sricompras.getTipoIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setTipoRetencionIva(sricomprasDataAccess.getTipoRetencionIva(connexion,sricompras));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(sricompras.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sricompras.setTipoRetencionIvaPresta(sricomprasDataAccess.getTipoRetencionIvaPresta(connexion,sricompras));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(sricompras.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(sricompras,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriComprasConstantesFunciones.refrescarForeignKeysDescripcionesSriCompras(sricompras);
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
			this.deepLoad(this.sricompras,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriComprasConstantesFunciones.refrescarForeignKeysDescripcionesSriCompras(this.sricompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(sricomprass!=null) {
				for(SriCompras sricompras:sricomprass) {
					this.deepLoad(sricompras,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SriComprasConstantesFunciones.refrescarForeignKeysDescripcionesSriCompras(sricomprass);
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
			if(sricomprass!=null) {
				for(SriCompras sricompras:sricomprass) {
					this.deepLoad(sricompras,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SriComprasConstantesFunciones.refrescarForeignKeysDescripcionesSriCompras(sricomprass);
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
	
	public SriComprasParameterReturnGeneral procesarAccionSriComprass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriCompras> sricomprass,SriComprasParameterReturnGeneral sricomprasParameterGeneral)throws Exception {
		 try {	
			SriComprasParameterReturnGeneral sricomprasReturnGeneral=new SriComprasParameterReturnGeneral();
	
			SriComprasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sricomprass,sricomprasParameterGeneral,sricomprasReturnGeneral);
			
			return sricomprasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SriComprasParameterReturnGeneral procesarAccionSriComprassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriCompras> sricomprass,SriComprasParameterReturnGeneral sricomprasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SriComprasParameterReturnGeneral sricomprasReturnGeneral=new SriComprasParameterReturnGeneral();
	
			SriComprasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sricomprass,sricomprasParameterGeneral,sricomprasReturnGeneral);
			
			this.connexion.commit();
			
			return sricomprasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

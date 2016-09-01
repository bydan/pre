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
import com.bydan.erp.sris.util.report.SriDetalladosIvaParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriDetalladosIvaParameterGeneral;
import com.bydan.erp.sris.util.report.SriDetalladosIvaConstantesFunciones;
import com.bydan.erp.sris.business.entity.report.SriDetalladosIva;

import com.bydan.erp.sris.business.logic.report.SriDetalladosIvaLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.sris.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class SriDetalladosIvaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(SriDetalladosIvaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected SriDetalladosIvaLogic sridetalladosivaDataAccess; 		
	protected SriDetalladosIva sridetalladosiva;
	protected List<SriDetalladosIva> sridetalladosivas;
	protected Object sridetalladosivaObject;	
	protected List<Object> sridetalladosivasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  SriDetalladosIvaLogic()throws SQLException,Exception {
		try	{
			this.sridetalladosivas= new ArrayList<SriDetalladosIva>();
			this.sridetalladosiva= new SriDetalladosIva();
			this.sridetalladosivaObject=new Object();
			this.sridetalladosivasObject=new ArrayList<Object>();
			
			this.sridetalladosivaDataAccess=this;
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
			this.sridetalladosivaDataAccess.setConnexionType(this.connexionType);
			this.sridetalladosivaDataAccess.setParameterDbType(this.parameterDbType);
			this.sridetalladosivaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SriDetalladosIvaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.sridetalladosivas= new ArrayList<SriDetalladosIva>();
			this.sridetalladosiva= new SriDetalladosIva();
			this.sridetalladosivaObject=new Object();
			this.sridetalladosivasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.sridetalladosivaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.sridetalladosivaDataAccess.setConnexionType(this.connexionType);
			this.sridetalladosivaDataAccess.setParameterDbType(this.parameterDbType);
			this.sridetalladosivaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SriDetalladosIva getSriDetalladosIva() throws Exception {	
		SriDetalladosIvaLogicAdditional.checkSriDetalladosIvaToGet(sridetalladosiva,this.datosCliente,this.arrDatoGeneral);
		SriDetalladosIvaLogicAdditional.updateSriDetalladosIvaToGet(sridetalladosiva,this.arrDatoGeneral);
		
		return sridetalladosiva;
	}
		
	public void setSriDetalladosIva(SriDetalladosIva newSriDetalladosIva) {
		this.sridetalladosiva = newSriDetalladosIva;
	}
	
	public List<SriDetalladosIva> getSriDetalladosIvas() throws Exception {		
		this.quitarSriDetalladosIvasNulos();
		
		SriDetalladosIvaLogicAdditional.checkSriDetalladosIvaToGets(sridetalladosivas,this.datosCliente,this.arrDatoGeneral);
		
		for (SriDetalladosIva sridetalladosivaLocal: sridetalladosivas ) {
			SriDetalladosIvaLogicAdditional.updateSriDetalladosIvaToGet(sridetalladosivaLocal,this.arrDatoGeneral);
		}
		
		return sridetalladosivas;
	}
	
	public void setSriDetalladosIvas(List<SriDetalladosIva> newSriDetalladosIvas) {
		this.sridetalladosivas = newSriDetalladosIvas;
	}
	
	public Object getSriDetalladosIvaObject() {	
		//this.sridetalladosivaObject=this.sridetalladosivaDataAccess.getEntityObject();
		return this.sridetalladosivaObject;
	}
		
	public void setSriDetalladosIvaObject(Object newSriDetalladosIvaObject) {
		this.sridetalladosivaObject = newSriDetalladosIvaObject;
	}
	
	public List<Object> getSriDetalladosIvasObject() {		
		//this.sridetalladosivasObject=this.sridetalladosivaDataAccess.getEntitiesObject();
		return this.sridetalladosivasObject;
	}
		
	public void setSriDetalladosIvasObject(List<Object> newSriDetalladosIvasObject) {
		this.sridetalladosivasObject = newSriDetalladosIvasObject;
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
		sridetalladosivas = new  ArrayList<SriDetalladosIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriDetalladosIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sridetalladosivas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		sridetalladosivas = new  ArrayList<SriDetalladosIva>();
		  		  
        try {
			//SriDetalladosIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sridetalladosivas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		sridetalladosivas = new  ArrayList<SriDetalladosIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriDetalladosIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sridetalladosivas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		sridetalladosivas = new  ArrayList<SriDetalladosIva>();
		  		  
        try {
			//SriDetalladosIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sridetalladosivas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		sridetalladosivas = new  ArrayList<SriDetalladosIva>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriDetalladosIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sridetalladosivas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		sridetalladosivas = new  ArrayList<SriDetalladosIva>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//SriDetalladosIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sridetalladosivas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<SriDetalladosIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriDetalladosIva> entities = new  ArrayList<SriDetalladosIva>();
		SriDetalladosIva entity = new SriDetalladosIva();		  
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
	
	public  List<SriDetalladosIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriDetalladosIva> entities = new  ArrayList<SriDetalladosIva>();
		SriDetalladosIva entity = new SriDetalladosIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriDetalladosIva();
				
				
      	    	entity=SriDetalladosIvaLogic.getEntitySriDetalladosIva("",entity,resultSet);
      	    	
				//entity.setSriDetalladosIvaOriginal( new SriDetalladosIva());
      	    	//entity.setSriDetalladosIvaOriginal(super.getEntity("",entity.getSriDetalladosIvaOriginal(),resultSet,SriDetalladosIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriDetalladosIvaOriginal(SriDetalladosIvaDataAccess.getEntitySriDetalladosIva("",entity.getSriDetalladosIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<SriDetalladosIva> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriDetalladosIva> entities = new  ArrayList<SriDetalladosIva>();
		SriDetalladosIva entity = new SriDetalladosIva();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,SriDetalladosIva.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriDetalladosIva>((List<SriDetalladosIva>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriDetalladosIvasOriginal(entities);
			
			}  else {
				this.sridetalladosivasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriDetalladosIvaConstantesFunciones.quitarEspaciosSriDetalladosIvas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static SriDetalladosIva getEntitySriDetalladosIva(String strPrefijo,SriDetalladosIva entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_tipo_comprobante(resultSet.getString(strPrefijo+SriDetalladosIvaConstantesFunciones.NOMBRETIPOCOMPROBANTE));
			entity.setruc_dato(resultSet.getString(strPrefijo+SriDetalladosIvaConstantesFunciones.RUCDATO));
			entity.setnumero_documento(resultSet.getString(strPrefijo+SriDetalladosIvaConstantesFunciones.NUMERODOCUMENTO));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+SriDetalladosIvaConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_registro_contable(new Date(resultSet.getDate(strPrefijo+SriDetalladosIvaConstantesFunciones.FECHAREGISTROCONTABLE).getTime()));
			entity.setnumero_serie(resultSet.getString(strPrefijo+SriDetalladosIvaConstantesFunciones.NUMEROSERIE));
			entity.settotal_iva(resultSet.getDouble(strPrefijo+SriDetalladosIvaConstantesFunciones.TOTALIVA));
			entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+SriDetalladosIvaConstantesFunciones.TOTALSINIVA));
			entity.setid_tipo_iva(resultSet.getLong(strPrefijo+SriDetalladosIvaConstantesFunciones.IDTIPOIVA));
			entity.setid_tipo_retencion_iva(resultSet.getLong(strPrefijo+SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVA));
			entity.settransfe_iva_retenido(resultSet.getDouble(strPrefijo+SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO));
			entity.setid_tipo_retencion_iva_presta(resultSet.getLong(strPrefijo+SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVAPRESTA));
			entity.setpresta_iva_retenido(resultSet.getDouble(strPrefijo+SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SriDetalladosIva getEntitySriDetalladosIva(String strPrefijo,SriDetalladosIva entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = SriDetalladosIva.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = SriDetalladosIva.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				SriDetalladosIvaLogic.setFieldReflectionSriDetalladosIva(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSriDetalladosIva(Field field,String strPrefijo,String sColumn,SriDetalladosIva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SriDetalladosIvaConstantesFunciones.NOMBRETIPOCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.RUCDATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriDetalladosIvaConstantesFunciones.FECHAREGISTROCONTABLE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriDetalladosIvaConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.IDTIPOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.TRANSFEIVARETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.IDTIPORETENCIONIVAPRESTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriDetalladosIvaConstantesFunciones.PRESTAIVARETENIDO:
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
	
	public void quitarSriDetalladosIvasNulos() throws Exception {				
		
		List<SriDetalladosIva> sridetalladosivasAux= new ArrayList<SriDetalladosIva>();
		
		for(SriDetalladosIva sridetalladosiva:sridetalladosivas) {
			if(sridetalladosiva!=null) {
				sridetalladosivasAux.add(sridetalladosiva);
			}
		}
		
		sridetalladosivas=sridetalladosivasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<SriDetalladosIva> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriDetalladosIva> entities = new  ArrayList<SriDetalladosIva>();
		SriDetalladosIva entity = new SriDetalladosIva();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriDetalladosIva>((List<SriDetalladosIva>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriDetalladosIvasOriginal(entities);
			
			}  else {
				this.sridetalladosivasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriDetalladosIvaConstantesFunciones.quitarEspaciosSriDetalladosIvas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		sridetalladosivas = new  ArrayList<SriDetalladosIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriDetalladosIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sridetalladosivas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		sridetalladosivas = new  ArrayList<SriDetalladosIva>();
		  		  
        try {
			//SriDetalladosIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sridetalladosivas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<SriDetalladosIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriDetalladosIva> entities = new  ArrayList<SriDetalladosIva>();
		SriDetalladosIva entity = new SriDetalladosIva();		  
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
	
	public  List<SriDetalladosIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriDetalladosIva> entities = new  ArrayList<SriDetalladosIva>();
		SriDetalladosIva entity = new SriDetalladosIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriDetalladosIva();
				
				if(conMapGenerico) {
					entity.setMapSriDetalladosIva( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapSriDetalladosIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SriDetalladosIvaDataAccess.ISWITHSCHEMA);         		
					entity=SriDetalladosIvaLogic.getEntitySriDetalladosIva("",entity,resultSet,listColumns);
					
					////entity.setSriDetalladosIvaOriginal( new SriDetalladosIva());
					////entity.setSriDetalladosIvaOriginal(super.getEntity("",entity.getSriDetalladosIvaOriginal(),resultSet,SriDetalladosIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setSriDetalladosIvaOriginal(SriDetalladosIvaDataAccess.getEntitySriDetalladosIva("",entity.getSriDetalladosIvaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public PeriodoDeclara getPeriodoDeclara(Connexion connexion,SriDetalladosIva relsridetalladosiva)throws SQLException,Exception {

		PeriodoDeclara periododeclara= new PeriodoDeclara();

		try {
			PeriodoDeclaraDataAccess periododeclaraDataAccess=new PeriodoDeclaraDataAccess();

			periododeclaraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periododeclaraDataAccess.setConnexionType(this.connexionType);
			periododeclaraDataAccess.setParameterDbType(this.parameterDbType);
			periododeclaraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periododeclara=periododeclaraDataAccess.getEntity(connexion,relsridetalladosiva.getid_periodo_declara());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periododeclara;

	}

	public TipoComprobante getTipoComprobante(Connexion connexion,SriDetalladosIva relsridetalladosiva)throws SQLException,Exception {

		TipoComprobante tipocomprobante= new TipoComprobante();

		try {
			TipoComprobanteDataAccess tipocomprobanteDataAccess=new TipoComprobanteDataAccess();

			tipocomprobanteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocomprobanteDataAccess.setConnexionType(this.connexionType);
			tipocomprobanteDataAccess.setParameterDbType(this.parameterDbType);
			tipocomprobanteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion,relsridetalladosiva.getid_tipo_comprobante());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocomprobante;

	}

	public TipoIva getTipoIva(Connexion connexion,SriDetalladosIva relsridetalladosiva)throws SQLException,Exception {

		TipoIva tipoiva= new TipoIva();

		try {
			TipoIvaDataAccess tipoivaDataAccess=new TipoIvaDataAccess();

			tipoivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoivaDataAccess.setConnexionType(this.connexionType);
			tipoivaDataAccess.setParameterDbType(this.parameterDbType);
			tipoivaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoiva=tipoivaDataAccess.getEntity(connexion,relsridetalladosiva.getid_tipo_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoiva;

	}

	public TipoRetencion getTipoRetencionIva(Connexion connexion,SriDetalladosIva relsridetalladosiva)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);
			tiporetencionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relsridetalladosiva.getid_tipo_retencion_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionIvaPresta(Connexion connexion,SriDetalladosIva relsridetalladosiva)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);
			tiporetencionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relsridetalladosiva.getid_tipo_retencion_iva_presta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}


	
	
	public void getSriDetalladosIvasBusquedaSriDetalladosIvaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_periodo_declara,Long id_tipo_comprobante,String ruc)throws Exception {
		try {
			//SriDetalladosIvaLogic sridetalladosivaLogic=new SriDetalladosIvaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriDetalladosIvaLogic.GetSelecSqlSriDetalladosIva(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_periodo_declara,id_tipo_comprobante,ruc);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.sridetalladosivas=this.getSriDetalladosIvas();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getSriDetalladosIvasBusquedaSriDetalladosIva(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_periodo_declara,Long id_tipo_comprobante,String ruc)throws Exception {
		try {
			//SriDetalladosIvaLogic sridetalladosivaLogic=new SriDetalladosIvaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriDetalladosIvaLogic.GetSelecSqlSriDetalladosIva(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_periodo_declara,id_tipo_comprobante,ruc);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.sridetalladosivas=this.getSriDetalladosIvas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlSriDetalladosIva(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_periodo_declara,Long id_tipo_comprobante,String ruc)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("SriDetalladosIva_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" l.id_empresa="+parametroGeneralUsuario.getid_empresa();
					//existeWhere=true;
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

				if(id_tipo_comprobante!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" l.id_tipo_comprobante = "+id_tipo_comprobante.toString();
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
	
	
	public void deepLoad(SriDetalladosIva sridetalladosiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SriDetalladosIvaLogicAdditional.updateSriDetalladosIvaToGet(sridetalladosiva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sridetalladosiva.setPeriodoDeclara(sridetalladosivaDataAccess.getPeriodoDeclara(connexion,sridetalladosiva));
		sridetalladosiva.setTipoComprobante(sridetalladosivaDataAccess.getTipoComprobante(connexion,sridetalladosiva));
		sridetalladosiva.setTipoIva(sridetalladosivaDataAccess.getTipoIva(connexion,sridetalladosiva));
		sridetalladosiva.setTipoRetencionIva(sridetalladosivaDataAccess.getTipoRetencionIva(connexion,sridetalladosiva));
		sridetalladosiva.setTipoRetencionIvaPresta(sridetalladosivaDataAccess.getTipoRetencionIvaPresta(connexion,sridetalladosiva));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				sridetalladosiva.setPeriodoDeclara(sridetalladosivaDataAccess.getPeriodoDeclara(connexion,sridetalladosiva));
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				sridetalladosiva.setTipoComprobante(sridetalladosivaDataAccess.getTipoComprobante(connexion,sridetalladosiva));
			}

			if(clas.clas.equals(TipoIva.class)) {
				sridetalladosiva.setTipoIva(sridetalladosivaDataAccess.getTipoIva(connexion,sridetalladosiva));
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				sridetalladosiva.setTipoRetencionIva(sridetalladosivaDataAccess.getTipoRetencionIva(connexion,sridetalladosiva));
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				sridetalladosiva.setTipoRetencionIvaPresta(sridetalladosivaDataAccess.getTipoRetencionIvaPresta(connexion,sridetalladosiva));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setPeriodoDeclara(sridetalladosivaDataAccess.getPeriodoDeclara(connexion,sridetalladosiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setTipoComprobante(sridetalladosivaDataAccess.getTipoComprobante(connexion,sridetalladosiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setTipoIva(sridetalladosivaDataAccess.getTipoIva(connexion,sridetalladosiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setTipoRetencionIva(sridetalladosivaDataAccess.getTipoRetencionIva(connexion,sridetalladosiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setTipoRetencionIvaPresta(sridetalladosivaDataAccess.getTipoRetencionIvaPresta(connexion,sridetalladosiva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sridetalladosiva.setPeriodoDeclara(sridetalladosivaDataAccess.getPeriodoDeclara(connexion,sridetalladosiva));
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(sridetalladosiva.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		sridetalladosiva.setTipoComprobante(sridetalladosivaDataAccess.getTipoComprobante(connexion,sridetalladosiva));
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(sridetalladosiva.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		sridetalladosiva.setTipoIva(sridetalladosivaDataAccess.getTipoIva(connexion,sridetalladosiva));
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(sridetalladosiva.getTipoIva(),isDeep,deepLoadType,clases);
				
		sridetalladosiva.setTipoRetencionIva(sridetalladosivaDataAccess.getTipoRetencionIva(connexion,sridetalladosiva));
		TipoRetencionLogic tiporetencionivaLogic= new TipoRetencionLogic(connexion);
		tiporetencionivaLogic.deepLoad(sridetalladosiva.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		sridetalladosiva.setTipoRetencionIvaPresta(sridetalladosivaDataAccess.getTipoRetencionIvaPresta(connexion,sridetalladosiva));
		TipoRetencionLogic tiporetencionivaprestaLogic= new TipoRetencionLogic(connexion);
		tiporetencionivaprestaLogic.deepLoad(sridetalladosiva.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				sridetalladosiva.setPeriodoDeclara(sridetalladosivaDataAccess.getPeriodoDeclara(connexion,sridetalladosiva));
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepLoad(sridetalladosiva.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				sridetalladosiva.setTipoComprobante(sridetalladosivaDataAccess.getTipoComprobante(connexion,sridetalladosiva));
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepLoad(sridetalladosiva.getTipoComprobante(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoIva.class)) {
				sridetalladosiva.setTipoIva(sridetalladosivaDataAccess.getTipoIva(connexion,sridetalladosiva));
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepLoad(sridetalladosiva.getTipoIva(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				sridetalladosiva.setTipoRetencionIva(sridetalladosivaDataAccess.getTipoRetencionIva(connexion,sridetalladosiva));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(sridetalladosiva.getTipoRetencionIva(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				sridetalladosiva.setTipoRetencionIvaPresta(sridetalladosivaDataAccess.getTipoRetencionIvaPresta(connexion,sridetalladosiva));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(sridetalladosiva.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setPeriodoDeclara(sridetalladosivaDataAccess.getPeriodoDeclara(connexion,sridetalladosiva));
			PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
			periododeclaraLogic.deepLoad(sridetalladosiva.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setTipoComprobante(sridetalladosivaDataAccess.getTipoComprobante(connexion,sridetalladosiva));
			TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
			tipocomprobanteLogic.deepLoad(sridetalladosiva.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setTipoIva(sridetalladosivaDataAccess.getTipoIva(connexion,sridetalladosiva));
			TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
			tipoivaLogic.deepLoad(sridetalladosiva.getTipoIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setTipoRetencionIva(sridetalladosivaDataAccess.getTipoRetencionIva(connexion,sridetalladosiva));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(sridetalladosiva.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sridetalladosiva.setTipoRetencionIvaPresta(sridetalladosivaDataAccess.getTipoRetencionIvaPresta(connexion,sridetalladosiva));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(sridetalladosiva.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(sridetalladosiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriDetalladosIvaConstantesFunciones.refrescarForeignKeysDescripcionesSriDetalladosIva(sridetalladosiva);
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
			this.deepLoad(this.sridetalladosiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriDetalladosIvaConstantesFunciones.refrescarForeignKeysDescripcionesSriDetalladosIva(this.sridetalladosiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(sridetalladosivas!=null) {
				for(SriDetalladosIva sridetalladosiva:sridetalladosivas) {
					this.deepLoad(sridetalladosiva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SriDetalladosIvaConstantesFunciones.refrescarForeignKeysDescripcionesSriDetalladosIva(sridetalladosivas);
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
			if(sridetalladosivas!=null) {
				for(SriDetalladosIva sridetalladosiva:sridetalladosivas) {
					this.deepLoad(sridetalladosiva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SriDetalladosIvaConstantesFunciones.refrescarForeignKeysDescripcionesSriDetalladosIva(sridetalladosivas);
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
	
	public SriDetalladosIvaParameterReturnGeneral procesarAccionSriDetalladosIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriDetalladosIva> sridetalladosivas,SriDetalladosIvaParameterReturnGeneral sridetalladosivaParameterGeneral)throws Exception {
		 try {	
			SriDetalladosIvaParameterReturnGeneral sridetalladosivaReturnGeneral=new SriDetalladosIvaParameterReturnGeneral();
	
			SriDetalladosIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sridetalladosivas,sridetalladosivaParameterGeneral,sridetalladosivaReturnGeneral);
			
			return sridetalladosivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SriDetalladosIvaParameterReturnGeneral procesarAccionSriDetalladosIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriDetalladosIva> sridetalladosivas,SriDetalladosIvaParameterReturnGeneral sridetalladosivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SriDetalladosIvaParameterReturnGeneral sridetalladosivaReturnGeneral=new SriDetalladosIvaParameterReturnGeneral();
	
			SriDetalladosIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sridetalladosivas,sridetalladosivaParameterGeneral,sridetalladosivaReturnGeneral);
			
			this.connexion.commit();
			
			return sridetalladosivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

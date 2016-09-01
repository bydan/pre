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
import com.bydan.erp.sris.util.report.SriFacturasProveedoresIva012ParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriFacturasProveedoresIva012ParameterGeneral;
import com.bydan.erp.sris.util.report.SriFacturasProveedoresIva012ConstantesFunciones;
import com.bydan.erp.sris.business.entity.report.SriFacturasProveedoresIva012;

import com.bydan.erp.sris.business.logic.report.SriFacturasProveedoresIva012LogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class SriFacturasProveedoresIva012Logic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(SriFacturasProveedoresIva012Logic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected SriFacturasProveedoresIva012Logic srifacturasproveedoresiva012DataAccess; 		
	protected SriFacturasProveedoresIva012 srifacturasproveedoresiva012;
	protected List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s;
	protected Object srifacturasproveedoresiva012Object;	
	protected List<Object> srifacturasproveedoresiva012sObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  SriFacturasProveedoresIva012Logic()throws SQLException,Exception {
		try	{
			this.srifacturasproveedoresiva012s= new ArrayList<SriFacturasProveedoresIva012>();
			this.srifacturasproveedoresiva012= new SriFacturasProveedoresIva012();
			this.srifacturasproveedoresiva012Object=new Object();
			this.srifacturasproveedoresiva012sObject=new ArrayList<Object>();
			
			this.srifacturasproveedoresiva012DataAccess=this;
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
			this.srifacturasproveedoresiva012DataAccess.setConnexionType(this.connexionType);
			this.srifacturasproveedoresiva012DataAccess.setParameterDbType(this.parameterDbType);
			this.srifacturasproveedoresiva012DataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SriFacturasProveedoresIva012Logic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.srifacturasproveedoresiva012s= new ArrayList<SriFacturasProveedoresIva012>();
			this.srifacturasproveedoresiva012= new SriFacturasProveedoresIva012();
			this.srifacturasproveedoresiva012Object=new Object();
			this.srifacturasproveedoresiva012sObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.srifacturasproveedoresiva012DataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.srifacturasproveedoresiva012DataAccess.setConnexionType(this.connexionType);
			this.srifacturasproveedoresiva012DataAccess.setParameterDbType(this.parameterDbType);
			this.srifacturasproveedoresiva012DataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SriFacturasProveedoresIva012 getSriFacturasProveedoresIva012() throws Exception {	
		SriFacturasProveedoresIva012LogicAdditional.checkSriFacturasProveedoresIva012ToGet(srifacturasproveedoresiva012,this.datosCliente,this.arrDatoGeneral);
		SriFacturasProveedoresIva012LogicAdditional.updateSriFacturasProveedoresIva012ToGet(srifacturasproveedoresiva012,this.arrDatoGeneral);
		
		return srifacturasproveedoresiva012;
	}
		
	public void setSriFacturasProveedoresIva012(SriFacturasProveedoresIva012 newSriFacturasProveedoresIva012) {
		this.srifacturasproveedoresiva012 = newSriFacturasProveedoresIva012;
	}
	
	public List<SriFacturasProveedoresIva012> getSriFacturasProveedoresIva012s() throws Exception {		
		this.quitarSriFacturasProveedoresIva012sNulos();
		
		SriFacturasProveedoresIva012LogicAdditional.checkSriFacturasProveedoresIva012ToGets(srifacturasproveedoresiva012s,this.datosCliente,this.arrDatoGeneral);
		
		for (SriFacturasProveedoresIva012 srifacturasproveedoresiva012Local: srifacturasproveedoresiva012s ) {
			SriFacturasProveedoresIva012LogicAdditional.updateSriFacturasProveedoresIva012ToGet(srifacturasproveedoresiva012Local,this.arrDatoGeneral);
		}
		
		return srifacturasproveedoresiva012s;
	}
	
	public void setSriFacturasProveedoresIva012s(List<SriFacturasProveedoresIva012> newSriFacturasProveedoresIva012s) {
		this.srifacturasproveedoresiva012s = newSriFacturasProveedoresIva012s;
	}
	
	public Object getSriFacturasProveedoresIva012Object() {	
		//this.srifacturasproveedoresiva012Object=this.srifacturasproveedoresiva012DataAccess.getEntityObject();
		return this.srifacturasproveedoresiva012Object;
	}
		
	public void setSriFacturasProveedoresIva012Object(Object newSriFacturasProveedoresIva012Object) {
		this.srifacturasproveedoresiva012Object = newSriFacturasProveedoresIva012Object;
	}
	
	public List<Object> getSriFacturasProveedoresIva012sObject() {		
		//this.srifacturasproveedoresiva012sObject=this.srifacturasproveedoresiva012DataAccess.getEntitiesObject();
		return this.srifacturasproveedoresiva012sObject;
	}
		
	public void setSriFacturasProveedoresIva012sObject(List<Object> newSriFacturasProveedoresIva012sObject) {
		this.srifacturasproveedoresiva012sObject = newSriFacturasProveedoresIva012sObject;
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
		srifacturasproveedoresiva012s = new  ArrayList<SriFacturasProveedoresIva012>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriFacturasProveedoresIva012Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoresiva012s=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		srifacturasproveedoresiva012s = new  ArrayList<SriFacturasProveedoresIva012>();
		  		  
        try {
			//SriFacturasProveedoresIva012Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoresiva012s=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		srifacturasproveedoresiva012s = new  ArrayList<SriFacturasProveedoresIva012>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriFacturasProveedoresIva012Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoresiva012s=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		srifacturasproveedoresiva012s = new  ArrayList<SriFacturasProveedoresIva012>();
		  		  
        try {
			//SriFacturasProveedoresIva012Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoresiva012s=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		srifacturasproveedoresiva012s = new  ArrayList<SriFacturasProveedoresIva012>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriFacturasProveedoresIva012Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoresiva012s=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		srifacturasproveedoresiva012s = new  ArrayList<SriFacturasProveedoresIva012>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//SriFacturasProveedoresIva012Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoresiva012s=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<SriFacturasProveedoresIva012> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriFacturasProveedoresIva012> entities = new  ArrayList<SriFacturasProveedoresIva012>();
		SriFacturasProveedoresIva012 entity = new SriFacturasProveedoresIva012();		  
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
	
	public  List<SriFacturasProveedoresIva012> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriFacturasProveedoresIva012> entities = new  ArrayList<SriFacturasProveedoresIva012>();
		SriFacturasProveedoresIva012 entity = new SriFacturasProveedoresIva012();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriFacturasProveedoresIva012();
				
				
      	    	entity=SriFacturasProveedoresIva012Logic.getEntitySriFacturasProveedoresIva012("",entity,resultSet);
      	    	
				//entity.setSriFacturasProveedoresIva012Original( new SriFacturasProveedoresIva012());
      	    	//entity.setSriFacturasProveedoresIva012Original(super.getEntity("",entity.getSriFacturasProveedoresIva012Original(),resultSet,SriFacturasProveedoresIva012DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriFacturasProveedoresIva012Original(SriFacturasProveedoresIva012DataAccess.getEntitySriFacturasProveedoresIva012("",entity.getSriFacturasProveedoresIva012Original(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<SriFacturasProveedoresIva012> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriFacturasProveedoresIva012> entities = new  ArrayList<SriFacturasProveedoresIva012>();
		SriFacturasProveedoresIva012 entity = new SriFacturasProveedoresIva012();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,SriFacturasProveedoresIva012.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriFacturasProveedoresIva012>((List<SriFacturasProveedoresIva012>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriFacturasProveedoresIva012sOriginal(entities);
			
			}  else {
				this.srifacturasproveedoresiva012sObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriFacturasProveedoresIva012ConstantesFunciones.quitarEspaciosSriFacturasProveedoresIva012s(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static SriFacturasProveedoresIva012 getEntitySriFacturasProveedoresIva012(String strPrefijo,SriFacturasProveedoresIva012 entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_tipo_comprobante(resultSet.getString(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPOCOMPROBANTE));
			entity.setnombre_completo_cliente(resultSet.getString(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.NOMBRECOMPLETOCLIENTE));
			entity.setruc_dato(resultSet.getString(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.RUCDATO));
			entity.setnumero_documento(resultSet.getString(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.NUMERODOCUMENTO));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_registro_contable(new Date(resultSet.getDate(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.FECHAREGISTROCONTABLE).getTime()));
			entity.setnumero_serie(resultSet.getString(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.NUMEROSERIE));
			entity.settotal_iva(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA));
			entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA));
			entity.setid_tipo_iva(resultSet.getLong(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.IDTIPOIVA));
			entity.setid_tipo_retencion_iva(resultSet.getLong(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVA));
			entity.settransfe_iva_retenido(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO));
			entity.setid_tipo_retencion_iva_presta(resultSet.getLong(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVAPRESTA));
			entity.setpresta_iva_retenido(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO));
			entity.setnombre_tipo_retencion_fuente1(resultSet.getString(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE1));
			entity.setret_fuente1_porcentaje(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE));
			entity.setret_fuente1_retenido(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO));
			entity.setnombre_tipo_retencion_fuente2(resultSet.getString(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE2));
			entity.setret_fuente2_porcentaje(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE));
			entity.setret_fuente2_retenido(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO));
			entity.setnombre_tipo_retencion_iva1(resultSet.getString(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA1));
			entity.setret_iva_bien_porcentaje(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE));
			entity.setret_iva_bien_retenido(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO));
			entity.setnombre_tipo_retencion_iva2(resultSet.getString(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA2));
			entity.setret_iva_servicio_porcentaje(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE));
			entity.setret_iva_servicio_retenido(resultSet.getDouble(strPrefijo+SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SriFacturasProveedoresIva012 getEntitySriFacturasProveedoresIva012(String strPrefijo,SriFacturasProveedoresIva012 entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = SriFacturasProveedoresIva012.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = SriFacturasProveedoresIva012.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				SriFacturasProveedoresIva012Logic.setFieldReflectionSriFacturasProveedoresIva012(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSriFacturasProveedoresIva012(Field field,String strPrefijo,String sColumn,SriFacturasProveedoresIva012 entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPOCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.NOMBRECOMPLETOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.RUCDATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.FECHAREGISTROCONTABLE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.IDTIPOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.TRANSFEIVARETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.IDTIPORETENCIONIVAPRESTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.PRESTAIVARETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE1:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE1RETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONFUENTE2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.RETFUENTE2RETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA1:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.RETIVABIENRETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.NOMBRETIPORETENCIONIVA2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIOPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriFacturasProveedoresIva012ConstantesFunciones.RETIVASERVICIORETENIDO:
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
	
	public void quitarSriFacturasProveedoresIva012sNulos() throws Exception {				
		
		List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012sAux= new ArrayList<SriFacturasProveedoresIva012>();
		
		for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012:srifacturasproveedoresiva012s) {
			if(srifacturasproveedoresiva012!=null) {
				srifacturasproveedoresiva012sAux.add(srifacturasproveedoresiva012);
			}
		}
		
		srifacturasproveedoresiva012s=srifacturasproveedoresiva012sAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<SriFacturasProveedoresIva012> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SriFacturasProveedoresIva012> entities = new  ArrayList<SriFacturasProveedoresIva012>();
		SriFacturasProveedoresIva012 entity = new SriFacturasProveedoresIva012();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SriFacturasProveedoresIva012>((List<SriFacturasProveedoresIva012>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSriFacturasProveedoresIva012sOriginal(entities);
			
			}  else {
				this.srifacturasproveedoresiva012sObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SriFacturasProveedoresIva012ConstantesFunciones.quitarEspaciosSriFacturasProveedoresIva012s(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		srifacturasproveedoresiva012s = new  ArrayList<SriFacturasProveedoresIva012>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SriFacturasProveedoresIva012Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoresiva012s=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		srifacturasproveedoresiva012s = new  ArrayList<SriFacturasProveedoresIva012>();
		  		  
        try {
			//SriFacturasProveedoresIva012Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			srifacturasproveedoresiva012s=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<SriFacturasProveedoresIva012> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriFacturasProveedoresIva012> entities = new  ArrayList<SriFacturasProveedoresIva012>();
		SriFacturasProveedoresIva012 entity = new SriFacturasProveedoresIva012();		  
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
	
	public  List<SriFacturasProveedoresIva012> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SriFacturasProveedoresIva012> entities = new  ArrayList<SriFacturasProveedoresIva012>();
		SriFacturasProveedoresIva012 entity = new SriFacturasProveedoresIva012();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SriFacturasProveedoresIva012();
				
				if(conMapGenerico) {
					entity.setMapSriFacturasProveedoresIva012( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapSriFacturasProveedoresIva012().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SriFacturasProveedoresIva012DataAccess.ISWITHSCHEMA);         		
					entity=SriFacturasProveedoresIva012Logic.getEntitySriFacturasProveedoresIva012("",entity,resultSet,listColumns);
					
					////entity.setSriFacturasProveedoresIva012Original( new SriFacturasProveedoresIva012());
					////entity.setSriFacturasProveedoresIva012Original(super.getEntity("",entity.getSriFacturasProveedoresIva012Original(),resultSet,SriFacturasProveedoresIva012DataAccess.ISWITHSCHEMA));         		
					////entity.setSriFacturasProveedoresIva012Original(SriFacturasProveedoresIva012DataAccess.getEntitySriFacturasProveedoresIva012("",entity.getSriFacturasProveedoresIva012Original(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,SriFacturasProveedoresIva012 relsrifacturasproveedoresiva012)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relsrifacturasproveedoresiva012.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public PeriodoDeclara getPeriodoDeclara(Connexion connexion,SriFacturasProveedoresIva012 relsrifacturasproveedoresiva012)throws SQLException,Exception {

		PeriodoDeclara periododeclara= new PeriodoDeclara();

		try {
			PeriodoDeclaraDataAccess periododeclaraDataAccess=new PeriodoDeclaraDataAccess();

			periododeclaraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periododeclaraDataAccess.setConnexionType(this.connexionType);
			periododeclaraDataAccess.setParameterDbType(this.parameterDbType);
			periododeclaraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periododeclara=periododeclaraDataAccess.getEntity(connexion,relsrifacturasproveedoresiva012.getid_periodo_declara());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periododeclara;

	}

	public TipoIva getTipoIva(Connexion connexion,SriFacturasProveedoresIva012 relsrifacturasproveedoresiva012)throws SQLException,Exception {

		TipoIva tipoiva= new TipoIva();

		try {
			TipoIvaDataAccess tipoivaDataAccess=new TipoIvaDataAccess();

			tipoivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoivaDataAccess.setConnexionType(this.connexionType);
			tipoivaDataAccess.setParameterDbType(this.parameterDbType);
			tipoivaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoiva=tipoivaDataAccess.getEntity(connexion,relsrifacturasproveedoresiva012.getid_tipo_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoiva;

	}

	public TipoRetencion getTipoRetencionIva(Connexion connexion,SriFacturasProveedoresIva012 relsrifacturasproveedoresiva012)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);
			tiporetencionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relsrifacturasproveedoresiva012.getid_tipo_retencion_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionIvaPresta(Connexion connexion,SriFacturasProveedoresIva012 relsrifacturasproveedoresiva012)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);
			tiporetencionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relsrifacturasproveedoresiva012.getid_tipo_retencion_iva_presta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}


	
	
	public void getSriFacturasProveedoresIva012sBusquedaSriFacturasProveedoresIva012WithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_periodo_declara,String ruc)throws Exception {
		try {
			//SriFacturasProveedoresIva012Logic srifacturasproveedoresiva012Logic=new SriFacturasProveedoresIva012Logic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriFacturasProveedoresIva012Logic.GetSelecSqlSriFacturasProveedoresIva012(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_periodo_declara,ruc);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.srifacturasproveedoresiva012s=this.getSriFacturasProveedoresIva012s();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getSriFacturasProveedoresIva012sBusquedaSriFacturasProveedoresIva012(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_periodo_declara,String ruc)throws Exception {
		try {
			//SriFacturasProveedoresIva012Logic srifacturasproveedoresiva012Logic=new SriFacturasProveedoresIva012Logic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SriFacturasProveedoresIva012Logic.GetSelecSqlSriFacturasProveedoresIva012(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_periodo_declara,ruc);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.srifacturasproveedoresiva012s=this.getSriFacturasProveedoresIva012s();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlSriFacturasProveedoresIva012(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_periodo_declara,String ruc)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("SriFacturasProveedoresIva012_Postgres.sql");
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
					//sSqlWhere+=" l.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_periodo_declara!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" l.id_periodo_declara = "+id_periodo_declara.toString();
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
	
	
	public void deepLoad(SriFacturasProveedoresIva012 srifacturasproveedoresiva012,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SriFacturasProveedoresIva012LogicAdditional.updateSriFacturasProveedoresIva012ToGet(srifacturasproveedoresiva012,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		srifacturasproveedoresiva012.setEmpresa(srifacturasproveedoresiva012DataAccess.getEmpresa(connexion,srifacturasproveedoresiva012));
		srifacturasproveedoresiva012.setPeriodoDeclara(srifacturasproveedoresiva012DataAccess.getPeriodoDeclara(connexion,srifacturasproveedoresiva012));
		srifacturasproveedoresiva012.setTipoIva(srifacturasproveedoresiva012DataAccess.getTipoIva(connexion,srifacturasproveedoresiva012));
		srifacturasproveedoresiva012.setTipoRetencionIva(srifacturasproveedoresiva012DataAccess.getTipoRetencionIva(connexion,srifacturasproveedoresiva012));
		srifacturasproveedoresiva012.setTipoRetencionIvaPresta(srifacturasproveedoresiva012DataAccess.getTipoRetencionIvaPresta(connexion,srifacturasproveedoresiva012));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				srifacturasproveedoresiva012.setEmpresa(srifacturasproveedoresiva012DataAccess.getEmpresa(connexion,srifacturasproveedoresiva012));
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				srifacturasproveedoresiva012.setPeriodoDeclara(srifacturasproveedoresiva012DataAccess.getPeriodoDeclara(connexion,srifacturasproveedoresiva012));
			}

			if(clas.clas.equals(TipoIva.class)) {
				srifacturasproveedoresiva012.setTipoIva(srifacturasproveedoresiva012DataAccess.getTipoIva(connexion,srifacturasproveedoresiva012));
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				srifacturasproveedoresiva012.setTipoRetencionIva(srifacturasproveedoresiva012DataAccess.getTipoRetencionIva(connexion,srifacturasproveedoresiva012));
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				srifacturasproveedoresiva012.setTipoRetencionIvaPresta(srifacturasproveedoresiva012DataAccess.getTipoRetencionIvaPresta(connexion,srifacturasproveedoresiva012));
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
			srifacturasproveedoresiva012.setEmpresa(srifacturasproveedoresiva012DataAccess.getEmpresa(connexion,srifacturasproveedoresiva012));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedoresiva012.setPeriodoDeclara(srifacturasproveedoresiva012DataAccess.getPeriodoDeclara(connexion,srifacturasproveedoresiva012));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedoresiva012.setTipoIva(srifacturasproveedoresiva012DataAccess.getTipoIva(connexion,srifacturasproveedoresiva012));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedoresiva012.setTipoRetencionIva(srifacturasproveedoresiva012DataAccess.getTipoRetencionIva(connexion,srifacturasproveedoresiva012));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedoresiva012.setTipoRetencionIvaPresta(srifacturasproveedoresiva012DataAccess.getTipoRetencionIvaPresta(connexion,srifacturasproveedoresiva012));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		srifacturasproveedoresiva012.setEmpresa(srifacturasproveedoresiva012DataAccess.getEmpresa(connexion,srifacturasproveedoresiva012));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(srifacturasproveedoresiva012.getEmpresa(),isDeep,deepLoadType,clases);
				
		srifacturasproveedoresiva012.setPeriodoDeclara(srifacturasproveedoresiva012DataAccess.getPeriodoDeclara(connexion,srifacturasproveedoresiva012));
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(srifacturasproveedoresiva012.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		srifacturasproveedoresiva012.setTipoIva(srifacturasproveedoresiva012DataAccess.getTipoIva(connexion,srifacturasproveedoresiva012));
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(srifacturasproveedoresiva012.getTipoIva(),isDeep,deepLoadType,clases);
				
		srifacturasproveedoresiva012.setTipoRetencionIva(srifacturasproveedoresiva012DataAccess.getTipoRetencionIva(connexion,srifacturasproveedoresiva012));
		TipoRetencionLogic tiporetencionivaLogic= new TipoRetencionLogic(connexion);
		tiporetencionivaLogic.deepLoad(srifacturasproveedoresiva012.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		srifacturasproveedoresiva012.setTipoRetencionIvaPresta(srifacturasproveedoresiva012DataAccess.getTipoRetencionIvaPresta(connexion,srifacturasproveedoresiva012));
		TipoRetencionLogic tiporetencionivaprestaLogic= new TipoRetencionLogic(connexion);
		tiporetencionivaprestaLogic.deepLoad(srifacturasproveedoresiva012.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				srifacturasproveedoresiva012.setEmpresa(srifacturasproveedoresiva012DataAccess.getEmpresa(connexion,srifacturasproveedoresiva012));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(srifacturasproveedoresiva012.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				srifacturasproveedoresiva012.setPeriodoDeclara(srifacturasproveedoresiva012DataAccess.getPeriodoDeclara(connexion,srifacturasproveedoresiva012));
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepLoad(srifacturasproveedoresiva012.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoIva.class)) {
				srifacturasproveedoresiva012.setTipoIva(srifacturasproveedoresiva012DataAccess.getTipoIva(connexion,srifacturasproveedoresiva012));
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepLoad(srifacturasproveedoresiva012.getTipoIva(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				srifacturasproveedoresiva012.setTipoRetencionIva(srifacturasproveedoresiva012DataAccess.getTipoRetencionIva(connexion,srifacturasproveedoresiva012));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(srifacturasproveedoresiva012.getTipoRetencionIva(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				srifacturasproveedoresiva012.setTipoRetencionIvaPresta(srifacturasproveedoresiva012DataAccess.getTipoRetencionIvaPresta(connexion,srifacturasproveedoresiva012));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(srifacturasproveedoresiva012.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);				
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
			srifacturasproveedoresiva012.setEmpresa(srifacturasproveedoresiva012DataAccess.getEmpresa(connexion,srifacturasproveedoresiva012));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(srifacturasproveedoresiva012.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedoresiva012.setPeriodoDeclara(srifacturasproveedoresiva012DataAccess.getPeriodoDeclara(connexion,srifacturasproveedoresiva012));
			PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
			periododeclaraLogic.deepLoad(srifacturasproveedoresiva012.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedoresiva012.setTipoIva(srifacturasproveedoresiva012DataAccess.getTipoIva(connexion,srifacturasproveedoresiva012));
			TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
			tipoivaLogic.deepLoad(srifacturasproveedoresiva012.getTipoIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedoresiva012.setTipoRetencionIva(srifacturasproveedoresiva012DataAccess.getTipoRetencionIva(connexion,srifacturasproveedoresiva012));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(srifacturasproveedoresiva012.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			srifacturasproveedoresiva012.setTipoRetencionIvaPresta(srifacturasproveedoresiva012DataAccess.getTipoRetencionIvaPresta(connexion,srifacturasproveedoresiva012));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(srifacturasproveedoresiva012.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(srifacturasproveedoresiva012,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriFacturasProveedoresIva012ConstantesFunciones.refrescarForeignKeysDescripcionesSriFacturasProveedoresIva012(srifacturasproveedoresiva012);
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
			this.deepLoad(this.srifacturasproveedoresiva012,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SriFacturasProveedoresIva012ConstantesFunciones.refrescarForeignKeysDescripcionesSriFacturasProveedoresIva012(this.srifacturasproveedoresiva012);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(srifacturasproveedoresiva012s!=null) {
				for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012:srifacturasproveedoresiva012s) {
					this.deepLoad(srifacturasproveedoresiva012,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SriFacturasProveedoresIva012ConstantesFunciones.refrescarForeignKeysDescripcionesSriFacturasProveedoresIva012(srifacturasproveedoresiva012s);
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
			if(srifacturasproveedoresiva012s!=null) {
				for(SriFacturasProveedoresIva012 srifacturasproveedoresiva012:srifacturasproveedoresiva012s) {
					this.deepLoad(srifacturasproveedoresiva012,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SriFacturasProveedoresIva012ConstantesFunciones.refrescarForeignKeysDescripcionesSriFacturasProveedoresIva012(srifacturasproveedoresiva012s);
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
	
	public SriFacturasProveedoresIva012ParameterReturnGeneral procesarAccionSriFacturasProveedoresIva012s(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s,SriFacturasProveedoresIva012ParameterReturnGeneral srifacturasproveedoresiva012ParameterGeneral)throws Exception {
		 try {	
			SriFacturasProveedoresIva012ParameterReturnGeneral srifacturasproveedoresiva012ReturnGeneral=new SriFacturasProveedoresIva012ParameterReturnGeneral();
	
			SriFacturasProveedoresIva012LogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,srifacturasproveedoresiva012s,srifacturasproveedoresiva012ParameterGeneral,srifacturasproveedoresiva012ReturnGeneral);
			
			return srifacturasproveedoresiva012ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SriFacturasProveedoresIva012ParameterReturnGeneral procesarAccionSriFacturasProveedoresIva012sWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s,SriFacturasProveedoresIva012ParameterReturnGeneral srifacturasproveedoresiva012ParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SriFacturasProveedoresIva012ParameterReturnGeneral srifacturasproveedoresiva012ReturnGeneral=new SriFacturasProveedoresIva012ParameterReturnGeneral();
	
			SriFacturasProveedoresIva012LogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,srifacturasproveedoresiva012s,srifacturasproveedoresiva012ParameterGeneral,srifacturasproveedoresiva012ReturnGeneral);
			
			this.connexion.commit();
			
			return srifacturasproveedoresiva012ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

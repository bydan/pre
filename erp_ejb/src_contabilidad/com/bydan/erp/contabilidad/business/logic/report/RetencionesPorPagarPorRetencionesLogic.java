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
package com.bydan.erp.contabilidad.business.logic.report;

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

import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.resources.general.AuxiliarGeneral;
import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorRetencionesParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorRetencionesParameterGeneral;
import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorRetencionesConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.RetencionesPorPagarPorRetenciones;

import com.bydan.erp.contabilidad.business.logic.report.RetencionesPorPagarPorRetencionesLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class RetencionesPorPagarPorRetencionesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(RetencionesPorPagarPorRetencionesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected RetencionesPorPagarPorRetencionesLogic retencionesporpagarporretencionesDataAccess; 		
	protected RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones;
	protected List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness;
	protected Object retencionesporpagarporretencionesObject;	
	protected List<Object> retencionesporpagarporretencionessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  RetencionesPorPagarPorRetencionesLogic()throws SQLException,Exception {
		try	{
			this.retencionesporpagarporretencioness= new ArrayList<RetencionesPorPagarPorRetenciones>();
			this.retencionesporpagarporretenciones= new RetencionesPorPagarPorRetenciones();
			this.retencionesporpagarporretencionesObject=new Object();
			this.retencionesporpagarporretencionessObject=new ArrayList<Object>();
			
			this.retencionesporpagarporretencionesDataAccess=this;
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
			this.retencionesporpagarporretencionesDataAccess.setConnexionType(this.connexionType);
			this.retencionesporpagarporretencionesDataAccess.setParameterDbType(this.parameterDbType);
			this.retencionesporpagarporretencionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RetencionesPorPagarPorRetencionesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.retencionesporpagarporretencioness= new ArrayList<RetencionesPorPagarPorRetenciones>();
			this.retencionesporpagarporretenciones= new RetencionesPorPagarPorRetenciones();
			this.retencionesporpagarporretencionesObject=new Object();
			this.retencionesporpagarporretencionessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.retencionesporpagarporretencionesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.retencionesporpagarporretencionesDataAccess.setConnexionType(this.connexionType);
			this.retencionesporpagarporretencionesDataAccess.setParameterDbType(this.parameterDbType);
			this.retencionesporpagarporretencionesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RetencionesPorPagarPorRetenciones getRetencionesPorPagarPorRetenciones() throws Exception {	
		RetencionesPorPagarPorRetencionesLogicAdditional.checkRetencionesPorPagarPorRetencionesToGet(retencionesporpagarporretenciones,this.datosCliente,this.arrDatoGeneral);
		RetencionesPorPagarPorRetencionesLogicAdditional.updateRetencionesPorPagarPorRetencionesToGet(retencionesporpagarporretenciones,this.arrDatoGeneral);
		
		return retencionesporpagarporretenciones;
	}
		
	public void setRetencionesPorPagarPorRetenciones(RetencionesPorPagarPorRetenciones newRetencionesPorPagarPorRetenciones) {
		this.retencionesporpagarporretenciones = newRetencionesPorPagarPorRetenciones;
	}
	
	public List<RetencionesPorPagarPorRetenciones> getRetencionesPorPagarPorRetencioness() throws Exception {		
		this.quitarRetencionesPorPagarPorRetencionessNulos();
		
		RetencionesPorPagarPorRetencionesLogicAdditional.checkRetencionesPorPagarPorRetencionesToGets(retencionesporpagarporretencioness,this.datosCliente,this.arrDatoGeneral);
		
		for (RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesLocal: retencionesporpagarporretencioness ) {
			RetencionesPorPagarPorRetencionesLogicAdditional.updateRetencionesPorPagarPorRetencionesToGet(retencionesporpagarporretencionesLocal,this.arrDatoGeneral);
		}
		
		return retencionesporpagarporretencioness;
	}
	
	public void setRetencionesPorPagarPorRetencioness(List<RetencionesPorPagarPorRetenciones> newRetencionesPorPagarPorRetencioness) {
		this.retencionesporpagarporretencioness = newRetencionesPorPagarPorRetencioness;
	}
	
	public Object getRetencionesPorPagarPorRetencionesObject() {	
		//this.retencionesporpagarporretencionesObject=this.retencionesporpagarporretencionesDataAccess.getEntityObject();
		return this.retencionesporpagarporretencionesObject;
	}
		
	public void setRetencionesPorPagarPorRetencionesObject(Object newRetencionesPorPagarPorRetencionesObject) {
		this.retencionesporpagarporretencionesObject = newRetencionesPorPagarPorRetencionesObject;
	}
	
	public List<Object> getRetencionesPorPagarPorRetencionessObject() {		
		//this.retencionesporpagarporretencionessObject=this.retencionesporpagarporretencionesDataAccess.getEntitiesObject();
		return this.retencionesporpagarporretencionessObject;
	}
		
	public void setRetencionesPorPagarPorRetencionessObject(List<Object> newRetencionesPorPagarPorRetencionessObject) {
		this.retencionesporpagarporretencionessObject = newRetencionesPorPagarPorRetencionessObject;
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
		retencionesporpagarporretencioness = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RetencionesPorPagarPorRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		retencionesporpagarporretencioness = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		  		  
        try {
			//RetencionesPorPagarPorRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencionesporpagarporretencioness = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RetencionesPorPagarPorRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		retencionesporpagarporretencioness = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		  		  
        try {
			//RetencionesPorPagarPorRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		retencionesporpagarporretencioness = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RetencionesPorPagarPorRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		retencionesporpagarporretencioness = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//RetencionesPorPagarPorRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<RetencionesPorPagarPorRetenciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionesPorPagarPorRetenciones> entities = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		RetencionesPorPagarPorRetenciones entity = new RetencionesPorPagarPorRetenciones();		  
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
	
	public  List<RetencionesPorPagarPorRetenciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionesPorPagarPorRetenciones> entities = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		RetencionesPorPagarPorRetenciones entity = new RetencionesPorPagarPorRetenciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RetencionesPorPagarPorRetenciones();
				
				
      	    	entity=RetencionesPorPagarPorRetencionesLogic.getEntityRetencionesPorPagarPorRetenciones("",entity,resultSet);
      	    	
				//entity.setRetencionesPorPagarPorRetencionesOriginal( new RetencionesPorPagarPorRetenciones());
      	    	//entity.setRetencionesPorPagarPorRetencionesOriginal(super.getEntity("",entity.getRetencionesPorPagarPorRetencionesOriginal(),resultSet,RetencionesPorPagarPorRetencionesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRetencionesPorPagarPorRetencionesOriginal(RetencionesPorPagarPorRetencionesDataAccess.getEntityRetencionesPorPagarPorRetenciones("",entity.getRetencionesPorPagarPorRetencionesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<RetencionesPorPagarPorRetenciones> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionesPorPagarPorRetenciones> entities = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		RetencionesPorPagarPorRetenciones entity = new RetencionesPorPagarPorRetenciones();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,RetencionesPorPagarPorRetenciones.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<RetencionesPorPagarPorRetenciones>((List<RetencionesPorPagarPorRetenciones>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setRetencionesPorPagarPorRetencionessOriginal(entities);
			
			}  else {
				this.retencionesporpagarporretencionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//RetencionesPorPagarPorRetencionesConstantesFunciones.quitarEspaciosRetencionesPorPagarPorRetencioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static RetencionesPorPagarPorRetenciones getEntityRetencionesPorPagarPorRetenciones(String strPrefijo,RetencionesPorPagarPorRetenciones entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.FECHAEMISION).getTime()));
			entity.setnombre_tipo_movimiento(resultSet.getString(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRETIPOMOVIMIENTO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROMAYOR));
			entity.setnombre_cuenta_contable_retencion(resultSet.getString(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION));
			entity.setnumero_pre_impreso_factura(resultSet.getString(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROPREIMPRESOFACTURA));
			entity.setporcentaje(resultSet.getDouble(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE));
			entity.setbase_imponible(resultSet.getDouble(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE));
			entity.setvalor(resultSet.getDouble(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR));
			entity.setnumero(resultSet.getString(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.NUMERO));
			entity.setnombre_benef(resultSet.getString(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBREBENEF));
			entity.setruc_benef(resultSet.getString(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.RUCBENEF));
			entity.setnombre_cuenta_contable(resultSet.getString(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLE));
			entity.setnombre_cuenta_contable_credito(resultSet.getString(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLECREDITO));
			entity.setes_debito_dato(resultSet.getBoolean(strPrefijo+RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITODATO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RetencionesPorPagarPorRetenciones getEntityRetencionesPorPagarPorRetenciones(String strPrefijo,RetencionesPorPagarPorRetenciones entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = RetencionesPorPagarPorRetenciones.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = RetencionesPorPagarPorRetenciones.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				RetencionesPorPagarPorRetencionesLogic.setFieldReflectionRetencionesPorPagarPorRetenciones(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRetencionesPorPagarPorRetenciones(Field field,String strPrefijo,String sColumn,RetencionesPorPagarPorRetenciones entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRETIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROPREIMPRESOFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBREBENEF:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.RUCBENEF:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLECREDITO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITODATO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	public void quitarRetencionesPorPagarPorRetencionessNulos() throws Exception {				
		
		List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencionessAux= new ArrayList<RetencionesPorPagarPorRetenciones>();
		
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones:retencionesporpagarporretencioness) {
			if(retencionesporpagarporretenciones!=null) {
				retencionesporpagarporretencionessAux.add(retencionesporpagarporretenciones);
			}
		}
		
		retencionesporpagarporretencioness=retencionesporpagarporretencionessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<RetencionesPorPagarPorRetenciones> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionesPorPagarPorRetenciones> entities = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		RetencionesPorPagarPorRetenciones entity = new RetencionesPorPagarPorRetenciones();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<RetencionesPorPagarPorRetenciones>((List<RetencionesPorPagarPorRetenciones>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setRetencionesPorPagarPorRetencionessOriginal(entities);
			
			}  else {
				this.retencionesporpagarporretencionessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//RetencionesPorPagarPorRetencionesConstantesFunciones.quitarEspaciosRetencionesPorPagarPorRetencioness(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		retencionesporpagarporretencioness = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RetencionesPorPagarPorRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		retencionesporpagarporretencioness = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		  		  
        try {
			//RetencionesPorPagarPorRetencionesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporretencioness=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<RetencionesPorPagarPorRetenciones> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<RetencionesPorPagarPorRetenciones> entities = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		RetencionesPorPagarPorRetenciones entity = new RetencionesPorPagarPorRetenciones();		  
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
	
	public  List<RetencionesPorPagarPorRetenciones> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<RetencionesPorPagarPorRetenciones> entities = new  ArrayList<RetencionesPorPagarPorRetenciones>();
		RetencionesPorPagarPorRetenciones entity = new RetencionesPorPagarPorRetenciones();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RetencionesPorPagarPorRetenciones();
				
				if(conMapGenerico) {
					entity.setMapRetencionesPorPagarPorRetenciones( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapRetencionesPorPagarPorRetenciones().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RetencionesPorPagarPorRetencionesDataAccess.ISWITHSCHEMA);         		
					entity=RetencionesPorPagarPorRetencionesLogic.getEntityRetencionesPorPagarPorRetenciones("",entity,resultSet,listColumns);
					
					////entity.setRetencionesPorPagarPorRetencionesOriginal( new RetencionesPorPagarPorRetenciones());
					////entity.setRetencionesPorPagarPorRetencionesOriginal(super.getEntity("",entity.getRetencionesPorPagarPorRetencionesOriginal(),resultSet,RetencionesPorPagarPorRetencionesDataAccess.ISWITHSCHEMA));         		
					////entity.setRetencionesPorPagarPorRetencionesOriginal(RetencionesPorPagarPorRetencionesDataAccess.getEntityRetencionesPorPagarPorRetenciones("",entity.getRetencionesPorPagarPorRetencionesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,RetencionesPorPagarPorRetenciones relretencionesporpagarporretenciones)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relretencionesporpagarporretenciones.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,RetencionesPorPagarPorRetenciones relretencionesporpagarporretenciones)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relretencionesporpagarporretenciones.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,RetencionesPorPagarPorRetenciones relretencionesporpagarporretenciones)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relretencionesporpagarporretenciones.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,RetencionesPorPagarPorRetenciones relretencionesporpagarporretenciones)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);
			periodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periodo=periodoDataAccess.getEntity(connexion,relretencionesporpagarporretenciones.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}


	
	
	public void getRetencionesPorPagarPorRetencionessBusquedaRetencionesPorPagarPorRetencionesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Boolean es_debito)throws Exception {
		try {
			//RetencionesPorPagarPorRetencionesLogic retencionesporpagarporretencionesLogic=new RetencionesPorPagarPorRetencionesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=RetencionesPorPagarPorRetencionesLogic.GetSelecSqlRetencionesPorPagarPorRetenciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,es_debito);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.retencionesporpagarporretencioness=this.getRetencionesPorPagarPorRetencioness();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getRetencionesPorPagarPorRetencionessBusquedaRetencionesPorPagarPorRetenciones(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Boolean es_debito)throws Exception {
		try {
			//RetencionesPorPagarPorRetencionesLogic retencionesporpagarporretencionesLogic=new RetencionesPorPagarPorRetencionesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=RetencionesPorPagarPorRetencionesLogic.GetSelecSqlRetencionesPorPagarPorRetenciones(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,es_debito);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.retencionesporpagarporretencioness=this.getRetencionesPorPagarPorRetencioness();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlRetencionesPorPagarPorRetenciones(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Boolean es_debito)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("RetencionesPorPagarPorRetenciones_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" a.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" a.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_ejercicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_ejercicio = "+id_ejercicio.toString();
					existeWhere=true;
				}

				if(id_periodo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_periodo = "+id_periodo.toString();
					existeWhere=true;
				}

				if(es_debito!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" tr.es_debito = "+es_debito.toString();
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
	
	
	public void deepLoad(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RetencionesPorPagarPorRetencionesLogicAdditional.updateRetencionesPorPagarPorRetencionesToGet(retencionesporpagarporretenciones,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		retencionesporpagarporretenciones.setEmpresa(retencionesporpagarporretencionesDataAccess.getEmpresa(connexion,retencionesporpagarporretenciones));
		retencionesporpagarporretenciones.setSucursal(retencionesporpagarporretencionesDataAccess.getSucursal(connexion,retencionesporpagarporretenciones));
		retencionesporpagarporretenciones.setEjercicio(retencionesporpagarporretencionesDataAccess.getEjercicio(connexion,retencionesporpagarporretenciones));
		retencionesporpagarporretenciones.setPeriodo(retencionesporpagarporretencionesDataAccess.getPeriodo(connexion,retencionesporpagarporretenciones));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				retencionesporpagarporretenciones.setEmpresa(retencionesporpagarporretencionesDataAccess.getEmpresa(connexion,retencionesporpagarporretenciones));
			}

			if(clas.clas.equals(Sucursal.class)) {
				retencionesporpagarporretenciones.setSucursal(retencionesporpagarporretencionesDataAccess.getSucursal(connexion,retencionesporpagarporretenciones));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				retencionesporpagarporretenciones.setEjercicio(retencionesporpagarporretencionesDataAccess.getEjercicio(connexion,retencionesporpagarporretenciones));
			}

			if(clas.clas.equals(Periodo.class)) {
				retencionesporpagarporretenciones.setPeriodo(retencionesporpagarporretencionesDataAccess.getPeriodo(connexion,retencionesporpagarporretenciones));
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
			retencionesporpagarporretenciones.setEmpresa(retencionesporpagarporretencionesDataAccess.getEmpresa(connexion,retencionesporpagarporretenciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporretenciones.setSucursal(retencionesporpagarporretencionesDataAccess.getSucursal(connexion,retencionesporpagarporretenciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporretenciones.setEjercicio(retencionesporpagarporretencionesDataAccess.getEjercicio(connexion,retencionesporpagarporretenciones));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporretenciones.setPeriodo(retencionesporpagarporretencionesDataAccess.getPeriodo(connexion,retencionesporpagarporretenciones));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		retencionesporpagarporretenciones.setEmpresa(retencionesporpagarporretencionesDataAccess.getEmpresa(connexion,retencionesporpagarporretenciones));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(retencionesporpagarporretenciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		retencionesporpagarporretenciones.setSucursal(retencionesporpagarporretencionesDataAccess.getSucursal(connexion,retencionesporpagarporretenciones));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(retencionesporpagarporretenciones.getSucursal(),isDeep,deepLoadType,clases);
				
		retencionesporpagarporretenciones.setEjercicio(retencionesporpagarporretencionesDataAccess.getEjercicio(connexion,retencionesporpagarporretenciones));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(retencionesporpagarporretenciones.getEjercicio(),isDeep,deepLoadType,clases);
				
		retencionesporpagarporretenciones.setPeriodo(retencionesporpagarporretencionesDataAccess.getPeriodo(connexion,retencionesporpagarporretenciones));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(retencionesporpagarporretenciones.getPeriodo(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				retencionesporpagarporretenciones.setEmpresa(retencionesporpagarporretencionesDataAccess.getEmpresa(connexion,retencionesporpagarporretenciones));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(retencionesporpagarporretenciones.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				retencionesporpagarporretenciones.setSucursal(retencionesporpagarporretencionesDataAccess.getSucursal(connexion,retencionesporpagarporretenciones));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(retencionesporpagarporretenciones.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				retencionesporpagarporretenciones.setEjercicio(retencionesporpagarporretencionesDataAccess.getEjercicio(connexion,retencionesporpagarporretenciones));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(retencionesporpagarporretenciones.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Periodo.class)) {
				retencionesporpagarporretenciones.setPeriodo(retencionesporpagarporretencionesDataAccess.getPeriodo(connexion,retencionesporpagarporretenciones));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(retencionesporpagarporretenciones.getPeriodo(),isDeep,deepLoadType,clases);				
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
			retencionesporpagarporretenciones.setEmpresa(retencionesporpagarporretencionesDataAccess.getEmpresa(connexion,retencionesporpagarporretenciones));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(retencionesporpagarporretenciones.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporretenciones.setSucursal(retencionesporpagarporretencionesDataAccess.getSucursal(connexion,retencionesporpagarporretenciones));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(retencionesporpagarporretenciones.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporretenciones.setEjercicio(retencionesporpagarporretencionesDataAccess.getEjercicio(connexion,retencionesporpagarporretenciones));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(retencionesporpagarporretenciones.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporretenciones.setPeriodo(retencionesporpagarporretencionesDataAccess.getPeriodo(connexion,retencionesporpagarporretenciones));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(retencionesporpagarporretenciones.getPeriodo(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(retencionesporpagarporretenciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RetencionesPorPagarPorRetencionesConstantesFunciones.refrescarForeignKeysDescripcionesRetencionesPorPagarPorRetenciones(retencionesporpagarporretenciones);
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
			this.deepLoad(this.retencionesporpagarporretenciones,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RetencionesPorPagarPorRetencionesConstantesFunciones.refrescarForeignKeysDescripcionesRetencionesPorPagarPorRetenciones(this.retencionesporpagarporretenciones);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(retencionesporpagarporretencioness!=null) {
				for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones:retencionesporpagarporretencioness) {
					this.deepLoad(retencionesporpagarporretenciones,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RetencionesPorPagarPorRetencionesConstantesFunciones.refrescarForeignKeysDescripcionesRetencionesPorPagarPorRetenciones(retencionesporpagarporretencioness);
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
			if(retencionesporpagarporretencioness!=null) {
				for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones:retencionesporpagarporretencioness) {
					this.deepLoad(retencionesporpagarporretenciones,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RetencionesPorPagarPorRetencionesConstantesFunciones.refrescarForeignKeysDescripcionesRetencionesPorPagarPorRetenciones(retencionesporpagarporretencioness);
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
	
	public RetencionesPorPagarPorRetencionesParameterReturnGeneral procesarAccionRetencionesPorPagarPorRetencioness(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,RetencionesPorPagarPorRetencionesParameterReturnGeneral retencionesporpagarporretencionesParameterGeneral)throws Exception {
		 try {	
			RetencionesPorPagarPorRetencionesParameterReturnGeneral retencionesporpagarporretencionesReturnGeneral=new RetencionesPorPagarPorRetencionesParameterReturnGeneral();
	
			RetencionesPorPagarPorRetencionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,retencionesporpagarporretencioness,retencionesporpagarporretencionesParameterGeneral,retencionesporpagarporretencionesReturnGeneral);
			
			return retencionesporpagarporretencionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RetencionesPorPagarPorRetencionesParameterReturnGeneral procesarAccionRetencionesPorPagarPorRetencionessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,RetencionesPorPagarPorRetencionesParameterReturnGeneral retencionesporpagarporretencionesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			RetencionesPorPagarPorRetencionesParameterReturnGeneral retencionesporpagarporretencionesReturnGeneral=new RetencionesPorPagarPorRetencionesParameterReturnGeneral();
	
			RetencionesPorPagarPorRetencionesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,retencionesporpagarporretencioness,retencionesporpagarporretencionesParameterGeneral,retencionesporpagarporretencionesReturnGeneral);
			
			this.connexion.commit();
			
			return retencionesporpagarporretencionesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

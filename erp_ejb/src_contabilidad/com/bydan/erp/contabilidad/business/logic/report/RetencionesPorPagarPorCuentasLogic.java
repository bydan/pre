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
import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorCuentasParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorCuentasParameterGeneral;
import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorCuentasConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.RetencionesPorPagarPorCuentas;

import com.bydan.erp.contabilidad.business.logic.report.RetencionesPorPagarPorCuentasLogicAdditional;
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
public class RetencionesPorPagarPorCuentasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(RetencionesPorPagarPorCuentasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected RetencionesPorPagarPorCuentasLogic retencionesporpagarporcuentasDataAccess; 		
	protected RetencionesPorPagarPorCuentas retencionesporpagarporcuentas;
	protected List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass;
	protected Object retencionesporpagarporcuentasObject;	
	protected List<Object> retencionesporpagarporcuentassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  RetencionesPorPagarPorCuentasLogic()throws SQLException,Exception {
		try	{
			this.retencionesporpagarporcuentass= new ArrayList<RetencionesPorPagarPorCuentas>();
			this.retencionesporpagarporcuentas= new RetencionesPorPagarPorCuentas();
			this.retencionesporpagarporcuentasObject=new Object();
			this.retencionesporpagarporcuentassObject=new ArrayList<Object>();
			
			this.retencionesporpagarporcuentasDataAccess=this;
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
			this.retencionesporpagarporcuentasDataAccess.setConnexionType(this.connexionType);
			this.retencionesporpagarporcuentasDataAccess.setParameterDbType(this.parameterDbType);
			this.retencionesporpagarporcuentasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RetencionesPorPagarPorCuentasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.retencionesporpagarporcuentass= new ArrayList<RetencionesPorPagarPorCuentas>();
			this.retencionesporpagarporcuentas= new RetencionesPorPagarPorCuentas();
			this.retencionesporpagarporcuentasObject=new Object();
			this.retencionesporpagarporcuentassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.retencionesporpagarporcuentasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.retencionesporpagarporcuentasDataAccess.setConnexionType(this.connexionType);
			this.retencionesporpagarporcuentasDataAccess.setParameterDbType(this.parameterDbType);
			this.retencionesporpagarporcuentasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RetencionesPorPagarPorCuentas getRetencionesPorPagarPorCuentas() throws Exception {	
		RetencionesPorPagarPorCuentasLogicAdditional.checkRetencionesPorPagarPorCuentasToGet(retencionesporpagarporcuentas,this.datosCliente,this.arrDatoGeneral);
		RetencionesPorPagarPorCuentasLogicAdditional.updateRetencionesPorPagarPorCuentasToGet(retencionesporpagarporcuentas,this.arrDatoGeneral);
		
		return retencionesporpagarporcuentas;
	}
		
	public void setRetencionesPorPagarPorCuentas(RetencionesPorPagarPorCuentas newRetencionesPorPagarPorCuentas) {
		this.retencionesporpagarporcuentas = newRetencionesPorPagarPorCuentas;
	}
	
	public List<RetencionesPorPagarPorCuentas> getRetencionesPorPagarPorCuentass() throws Exception {		
		this.quitarRetencionesPorPagarPorCuentassNulos();
		
		RetencionesPorPagarPorCuentasLogicAdditional.checkRetencionesPorPagarPorCuentasToGets(retencionesporpagarporcuentass,this.datosCliente,this.arrDatoGeneral);
		
		for (RetencionesPorPagarPorCuentas retencionesporpagarporcuentasLocal: retencionesporpagarporcuentass ) {
			RetencionesPorPagarPorCuentasLogicAdditional.updateRetencionesPorPagarPorCuentasToGet(retencionesporpagarporcuentasLocal,this.arrDatoGeneral);
		}
		
		return retencionesporpagarporcuentass;
	}
	
	public void setRetencionesPorPagarPorCuentass(List<RetencionesPorPagarPorCuentas> newRetencionesPorPagarPorCuentass) {
		this.retencionesporpagarporcuentass = newRetencionesPorPagarPorCuentass;
	}
	
	public Object getRetencionesPorPagarPorCuentasObject() {	
		//this.retencionesporpagarporcuentasObject=this.retencionesporpagarporcuentasDataAccess.getEntityObject();
		return this.retencionesporpagarporcuentasObject;
	}
		
	public void setRetencionesPorPagarPorCuentasObject(Object newRetencionesPorPagarPorCuentasObject) {
		this.retencionesporpagarporcuentasObject = newRetencionesPorPagarPorCuentasObject;
	}
	
	public List<Object> getRetencionesPorPagarPorCuentassObject() {		
		//this.retencionesporpagarporcuentassObject=this.retencionesporpagarporcuentasDataAccess.getEntitiesObject();
		return this.retencionesporpagarporcuentassObject;
	}
		
	public void setRetencionesPorPagarPorCuentassObject(List<Object> newRetencionesPorPagarPorCuentassObject) {
		this.retencionesporpagarporcuentassObject = newRetencionesPorPagarPorCuentassObject;
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
		retencionesporpagarporcuentass = new  ArrayList<RetencionesPorPagarPorCuentas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RetencionesPorPagarPorCuentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporcuentass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		retencionesporpagarporcuentass = new  ArrayList<RetencionesPorPagarPorCuentas>();
		  		  
        try {
			//RetencionesPorPagarPorCuentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporcuentass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencionesporpagarporcuentass = new  ArrayList<RetencionesPorPagarPorCuentas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RetencionesPorPagarPorCuentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporcuentass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		retencionesporpagarporcuentass = new  ArrayList<RetencionesPorPagarPorCuentas>();
		  		  
        try {
			//RetencionesPorPagarPorCuentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporcuentass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		retencionesporpagarporcuentass = new  ArrayList<RetencionesPorPagarPorCuentas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RetencionesPorPagarPorCuentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporcuentass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		retencionesporpagarporcuentass = new  ArrayList<RetencionesPorPagarPorCuentas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//RetencionesPorPagarPorCuentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporcuentass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<RetencionesPorPagarPorCuentas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionesPorPagarPorCuentas> entities = new  ArrayList<RetencionesPorPagarPorCuentas>();
		RetencionesPorPagarPorCuentas entity = new RetencionesPorPagarPorCuentas();		  
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
	
	public  List<RetencionesPorPagarPorCuentas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionesPorPagarPorCuentas> entities = new  ArrayList<RetencionesPorPagarPorCuentas>();
		RetencionesPorPagarPorCuentas entity = new RetencionesPorPagarPorCuentas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RetencionesPorPagarPorCuentas();
				
				
      	    	entity=RetencionesPorPagarPorCuentasLogic.getEntityRetencionesPorPagarPorCuentas("",entity,resultSet);
      	    	
				//entity.setRetencionesPorPagarPorCuentasOriginal( new RetencionesPorPagarPorCuentas());
      	    	//entity.setRetencionesPorPagarPorCuentasOriginal(super.getEntity("",entity.getRetencionesPorPagarPorCuentasOriginal(),resultSet,RetencionesPorPagarPorCuentasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRetencionesPorPagarPorCuentasOriginal(RetencionesPorPagarPorCuentasDataAccess.getEntityRetencionesPorPagarPorCuentas("",entity.getRetencionesPorPagarPorCuentasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<RetencionesPorPagarPorCuentas> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionesPorPagarPorCuentas> entities = new  ArrayList<RetencionesPorPagarPorCuentas>();
		RetencionesPorPagarPorCuentas entity = new RetencionesPorPagarPorCuentas();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,RetencionesPorPagarPorCuentas.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<RetencionesPorPagarPorCuentas>((List<RetencionesPorPagarPorCuentas>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setRetencionesPorPagarPorCuentassOriginal(entities);
			
			}  else {
				this.retencionesporpagarporcuentassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//RetencionesPorPagarPorCuentasConstantesFunciones.quitarEspaciosRetencionesPorPagarPorCuentass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static RetencionesPorPagarPorCuentas getEntityRetencionesPorPagarPorCuentas(String strPrefijo,RetencionesPorPagarPorCuentas entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.FECHAEMISION).getTime()));
			entity.setnombre_tipo_movimiento(resultSet.getString(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRETIPOMOVIMIENTO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROMAYOR));
			entity.setnombre_cuenta_contable_retencion(resultSet.getString(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLERETENCION));
			entity.setnumero_pre_impreso_factura(resultSet.getString(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROPREIMPRESOFACTURA));
			entity.setporcentaje(resultSet.getDouble(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE));
			entity.setbase_imponible(resultSet.getDouble(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE));
			entity.setvalor(resultSet.getDouble(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.VALOR));
			entity.setnumero(resultSet.getString(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.NUMERO));
			entity.setnombre_benef(resultSet.getString(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.NOMBREBENEF));
			entity.setruc_benef(resultSet.getString(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.RUCBENEF));
			entity.setnombre_cuenta_contable(resultSet.getString(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLE));
			entity.setnombre_cuenta_contable_credito(resultSet.getString(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLECREDITO));
			entity.setes_debito_dato(resultSet.getBoolean(strPrefijo+RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITODATO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RetencionesPorPagarPorCuentas getEntityRetencionesPorPagarPorCuentas(String strPrefijo,RetencionesPorPagarPorCuentas entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = RetencionesPorPagarPorCuentas.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = RetencionesPorPagarPorCuentas.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				RetencionesPorPagarPorCuentasLogic.setFieldReflectionRetencionesPorPagarPorCuentas(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRetencionesPorPagarPorCuentas(Field field,String strPrefijo,String sColumn,RetencionesPorPagarPorCuentas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRETIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLERETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROPREIMPRESOFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.NOMBREBENEF:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.RUCBENEF:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLECREDITO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITODATO:
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
	
	public void quitarRetencionesPorPagarPorCuentassNulos() throws Exception {				
		
		List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentassAux= new ArrayList<RetencionesPorPagarPorCuentas>();
		
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas:retencionesporpagarporcuentass) {
			if(retencionesporpagarporcuentas!=null) {
				retencionesporpagarporcuentassAux.add(retencionesporpagarporcuentas);
			}
		}
		
		retencionesporpagarporcuentass=retencionesporpagarporcuentassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<RetencionesPorPagarPorCuentas> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionesPorPagarPorCuentas> entities = new  ArrayList<RetencionesPorPagarPorCuentas>();
		RetencionesPorPagarPorCuentas entity = new RetencionesPorPagarPorCuentas();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<RetencionesPorPagarPorCuentas>((List<RetencionesPorPagarPorCuentas>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setRetencionesPorPagarPorCuentassOriginal(entities);
			
			}  else {
				this.retencionesporpagarporcuentassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//RetencionesPorPagarPorCuentasConstantesFunciones.quitarEspaciosRetencionesPorPagarPorCuentass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		retencionesporpagarporcuentass = new  ArrayList<RetencionesPorPagarPorCuentas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//RetencionesPorPagarPorCuentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporcuentass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		retencionesporpagarporcuentass = new  ArrayList<RetencionesPorPagarPorCuentas>();
		  		  
        try {
			//RetencionesPorPagarPorCuentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionesporpagarporcuentass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<RetencionesPorPagarPorCuentas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<RetencionesPorPagarPorCuentas> entities = new  ArrayList<RetencionesPorPagarPorCuentas>();
		RetencionesPorPagarPorCuentas entity = new RetencionesPorPagarPorCuentas();		  
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
	
	public  List<RetencionesPorPagarPorCuentas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<RetencionesPorPagarPorCuentas> entities = new  ArrayList<RetencionesPorPagarPorCuentas>();
		RetencionesPorPagarPorCuentas entity = new RetencionesPorPagarPorCuentas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RetencionesPorPagarPorCuentas();
				
				if(conMapGenerico) {
					entity.setMapRetencionesPorPagarPorCuentas( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapRetencionesPorPagarPorCuentas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RetencionesPorPagarPorCuentasDataAccess.ISWITHSCHEMA);         		
					entity=RetencionesPorPagarPorCuentasLogic.getEntityRetencionesPorPagarPorCuentas("",entity,resultSet,listColumns);
					
					////entity.setRetencionesPorPagarPorCuentasOriginal( new RetencionesPorPagarPorCuentas());
					////entity.setRetencionesPorPagarPorCuentasOriginal(super.getEntity("",entity.getRetencionesPorPagarPorCuentasOriginal(),resultSet,RetencionesPorPagarPorCuentasDataAccess.ISWITHSCHEMA));         		
					////entity.setRetencionesPorPagarPorCuentasOriginal(RetencionesPorPagarPorCuentasDataAccess.getEntityRetencionesPorPagarPorCuentas("",entity.getRetencionesPorPagarPorCuentasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,RetencionesPorPagarPorCuentas relretencionesporpagarporcuentas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relretencionesporpagarporcuentas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,RetencionesPorPagarPorCuentas relretencionesporpagarporcuentas)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relretencionesporpagarporcuentas.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,RetencionesPorPagarPorCuentas relretencionesporpagarporcuentas)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relretencionesporpagarporcuentas.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,RetencionesPorPagarPorCuentas relretencionesporpagarporcuentas)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);
			periodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periodo=periodoDataAccess.getEntity(connexion,relretencionesporpagarporcuentas.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public TipoRetencion getTipoRetencion(Connexion connexion,RetencionesPorPagarPorCuentas relretencionesporpagarporcuentas)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);
			tiporetencionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relretencionesporpagarporcuentas.getid_tipo_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}


	
	
	public void getRetencionesPorPagarPorCuentassBusquedaRetencionesPorPagarPorCuentasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_tipo_retencion,Boolean es_debito)throws Exception {
		try {
			//RetencionesPorPagarPorCuentasLogic retencionesporpagarporcuentasLogic=new RetencionesPorPagarPorCuentasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=RetencionesPorPagarPorCuentasLogic.GetSelecSqlRetencionesPorPagarPorCuentas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_tipo_retencion,es_debito);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.retencionesporpagarporcuentass=this.getRetencionesPorPagarPorCuentass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getRetencionesPorPagarPorCuentassBusquedaRetencionesPorPagarPorCuentas(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_tipo_retencion,Boolean es_debito)throws Exception {
		try {
			//RetencionesPorPagarPorCuentasLogic retencionesporpagarporcuentasLogic=new RetencionesPorPagarPorCuentasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=RetencionesPorPagarPorCuentasLogic.GetSelecSqlRetencionesPorPagarPorCuentas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_tipo_retencion,es_debito);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.retencionesporpagarporcuentass=this.getRetencionesPorPagarPorCuentass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlRetencionesPorPagarPorCuentas(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_tipo_retencion,Boolean es_debito)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("RetencionesPorPagarPorCuentas_Postgres.sql");
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

				if(id_tipo_retencion!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" tr.id_tipo_retencion = "+id_tipo_retencion.toString();
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
	
	
	public void deepLoad(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RetencionesPorPagarPorCuentasLogicAdditional.updateRetencionesPorPagarPorCuentasToGet(retencionesporpagarporcuentas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		retencionesporpagarporcuentas.setEmpresa(retencionesporpagarporcuentasDataAccess.getEmpresa(connexion,retencionesporpagarporcuentas));
		retencionesporpagarporcuentas.setSucursal(retencionesporpagarporcuentasDataAccess.getSucursal(connexion,retencionesporpagarporcuentas));
		retencionesporpagarporcuentas.setEjercicio(retencionesporpagarporcuentasDataAccess.getEjercicio(connexion,retencionesporpagarporcuentas));
		retencionesporpagarporcuentas.setPeriodo(retencionesporpagarporcuentasDataAccess.getPeriodo(connexion,retencionesporpagarporcuentas));
		retencionesporpagarporcuentas.setTipoRetencion(retencionesporpagarporcuentasDataAccess.getTipoRetencion(connexion,retencionesporpagarporcuentas));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				retencionesporpagarporcuentas.setEmpresa(retencionesporpagarporcuentasDataAccess.getEmpresa(connexion,retencionesporpagarporcuentas));
			}

			if(clas.clas.equals(Sucursal.class)) {
				retencionesporpagarporcuentas.setSucursal(retencionesporpagarporcuentasDataAccess.getSucursal(connexion,retencionesporpagarporcuentas));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				retencionesporpagarporcuentas.setEjercicio(retencionesporpagarporcuentasDataAccess.getEjercicio(connexion,retencionesporpagarporcuentas));
			}

			if(clas.clas.equals(Periodo.class)) {
				retencionesporpagarporcuentas.setPeriodo(retencionesporpagarporcuentasDataAccess.getPeriodo(connexion,retencionesporpagarporcuentas));
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				retencionesporpagarporcuentas.setTipoRetencion(retencionesporpagarporcuentasDataAccess.getTipoRetencion(connexion,retencionesporpagarporcuentas));
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
			retencionesporpagarporcuentas.setEmpresa(retencionesporpagarporcuentasDataAccess.getEmpresa(connexion,retencionesporpagarporcuentas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporcuentas.setSucursal(retencionesporpagarporcuentasDataAccess.getSucursal(connexion,retencionesporpagarporcuentas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporcuentas.setEjercicio(retencionesporpagarporcuentasDataAccess.getEjercicio(connexion,retencionesporpagarporcuentas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporcuentas.setPeriodo(retencionesporpagarporcuentasDataAccess.getPeriodo(connexion,retencionesporpagarporcuentas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporcuentas.setTipoRetencion(retencionesporpagarporcuentasDataAccess.getTipoRetencion(connexion,retencionesporpagarporcuentas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		retencionesporpagarporcuentas.setEmpresa(retencionesporpagarporcuentasDataAccess.getEmpresa(connexion,retencionesporpagarporcuentas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(retencionesporpagarporcuentas.getEmpresa(),isDeep,deepLoadType,clases);
				
		retencionesporpagarporcuentas.setSucursal(retencionesporpagarporcuentasDataAccess.getSucursal(connexion,retencionesporpagarporcuentas));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(retencionesporpagarporcuentas.getSucursal(),isDeep,deepLoadType,clases);
				
		retencionesporpagarporcuentas.setEjercicio(retencionesporpagarporcuentasDataAccess.getEjercicio(connexion,retencionesporpagarporcuentas));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(retencionesporpagarporcuentas.getEjercicio(),isDeep,deepLoadType,clases);
				
		retencionesporpagarporcuentas.setPeriodo(retencionesporpagarporcuentasDataAccess.getPeriodo(connexion,retencionesporpagarporcuentas));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(retencionesporpagarporcuentas.getPeriodo(),isDeep,deepLoadType,clases);
				
		retencionesporpagarporcuentas.setTipoRetencion(retencionesporpagarporcuentasDataAccess.getTipoRetencion(connexion,retencionesporpagarporcuentas));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(retencionesporpagarporcuentas.getTipoRetencion(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				retencionesporpagarporcuentas.setEmpresa(retencionesporpagarporcuentasDataAccess.getEmpresa(connexion,retencionesporpagarporcuentas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(retencionesporpagarporcuentas.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				retencionesporpagarporcuentas.setSucursal(retencionesporpagarporcuentasDataAccess.getSucursal(connexion,retencionesporpagarporcuentas));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(retencionesporpagarporcuentas.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				retencionesporpagarporcuentas.setEjercicio(retencionesporpagarporcuentasDataAccess.getEjercicio(connexion,retencionesporpagarporcuentas));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(retencionesporpagarporcuentas.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Periodo.class)) {
				retencionesporpagarporcuentas.setPeriodo(retencionesporpagarporcuentasDataAccess.getPeriodo(connexion,retencionesporpagarporcuentas));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(retencionesporpagarporcuentas.getPeriodo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				retencionesporpagarporcuentas.setTipoRetencion(retencionesporpagarporcuentasDataAccess.getTipoRetencion(connexion,retencionesporpagarporcuentas));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(retencionesporpagarporcuentas.getTipoRetencion(),isDeep,deepLoadType,clases);				
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
			retencionesporpagarporcuentas.setEmpresa(retencionesporpagarporcuentasDataAccess.getEmpresa(connexion,retencionesporpagarporcuentas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(retencionesporpagarporcuentas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporcuentas.setSucursal(retencionesporpagarporcuentasDataAccess.getSucursal(connexion,retencionesporpagarporcuentas));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(retencionesporpagarporcuentas.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporcuentas.setEjercicio(retencionesporpagarporcuentasDataAccess.getEjercicio(connexion,retencionesporpagarporcuentas));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(retencionesporpagarporcuentas.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporcuentas.setPeriodo(retencionesporpagarporcuentasDataAccess.getPeriodo(connexion,retencionesporpagarporcuentas));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(retencionesporpagarporcuentas.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionesporpagarporcuentas.setTipoRetencion(retencionesporpagarporcuentasDataAccess.getTipoRetencion(connexion,retencionesporpagarporcuentas));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(retencionesporpagarporcuentas.getTipoRetencion(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(retencionesporpagarporcuentas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RetencionesPorPagarPorCuentasConstantesFunciones.refrescarForeignKeysDescripcionesRetencionesPorPagarPorCuentas(retencionesporpagarporcuentas);
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
			this.deepLoad(this.retencionesporpagarporcuentas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RetencionesPorPagarPorCuentasConstantesFunciones.refrescarForeignKeysDescripcionesRetencionesPorPagarPorCuentas(this.retencionesporpagarporcuentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(retencionesporpagarporcuentass!=null) {
				for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas:retencionesporpagarporcuentass) {
					this.deepLoad(retencionesporpagarporcuentas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RetencionesPorPagarPorCuentasConstantesFunciones.refrescarForeignKeysDescripcionesRetencionesPorPagarPorCuentas(retencionesporpagarporcuentass);
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
			if(retencionesporpagarporcuentass!=null) {
				for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas:retencionesporpagarporcuentass) {
					this.deepLoad(retencionesporpagarporcuentas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RetencionesPorPagarPorCuentasConstantesFunciones.refrescarForeignKeysDescripcionesRetencionesPorPagarPorCuentas(retencionesporpagarporcuentass);
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
	
	public RetencionesPorPagarPorCuentasParameterReturnGeneral procesarAccionRetencionesPorPagarPorCuentass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,RetencionesPorPagarPorCuentasParameterReturnGeneral retencionesporpagarporcuentasParameterGeneral)throws Exception {
		 try {	
			RetencionesPorPagarPorCuentasParameterReturnGeneral retencionesporpagarporcuentasReturnGeneral=new RetencionesPorPagarPorCuentasParameterReturnGeneral();
	
			RetencionesPorPagarPorCuentasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,retencionesporpagarporcuentass,retencionesporpagarporcuentasParameterGeneral,retencionesporpagarporcuentasReturnGeneral);
			
			return retencionesporpagarporcuentasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RetencionesPorPagarPorCuentasParameterReturnGeneral procesarAccionRetencionesPorPagarPorCuentassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,RetencionesPorPagarPorCuentasParameterReturnGeneral retencionesporpagarporcuentasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			RetencionesPorPagarPorCuentasParameterReturnGeneral retencionesporpagarporcuentasReturnGeneral=new RetencionesPorPagarPorCuentasParameterReturnGeneral();
	
			RetencionesPorPagarPorCuentasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,retencionesporpagarporcuentass,retencionesporpagarporcuentasParameterGeneral,retencionesporpagarporcuentasReturnGeneral);
			
			this.connexion.commit();
			
			return retencionesporpagarporcuentasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

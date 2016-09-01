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
import com.bydan.erp.cartera.util.report.CobrarSaldosVencidosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarSaldosVencidosParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarSaldosVencidosConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarSaldosVencidos;

import com.bydan.erp.cartera.business.logic.report.CobrarSaldosVencidosLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarSaldosVencidosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarSaldosVencidosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarSaldosVencidosLogic cobrarsaldosvencidosDataAccess; 		
	protected CobrarSaldosVencidos cobrarsaldosvencidos;
	protected List<CobrarSaldosVencidos> cobrarsaldosvencidoss;
	protected Object cobrarsaldosvencidosObject;	
	protected List<Object> cobrarsaldosvencidossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarSaldosVencidosLogic()throws SQLException,Exception {
		try	{
			this.cobrarsaldosvencidoss= new ArrayList<CobrarSaldosVencidos>();
			this.cobrarsaldosvencidos= new CobrarSaldosVencidos();
			this.cobrarsaldosvencidosObject=new Object();
			this.cobrarsaldosvencidossObject=new ArrayList<Object>();
			
			this.cobrarsaldosvencidosDataAccess=this;
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
			this.cobrarsaldosvencidosDataAccess.setConnexionType(this.connexionType);
			this.cobrarsaldosvencidosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarsaldosvencidosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarSaldosVencidosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarsaldosvencidoss= new ArrayList<CobrarSaldosVencidos>();
			this.cobrarsaldosvencidos= new CobrarSaldosVencidos();
			this.cobrarsaldosvencidosObject=new Object();
			this.cobrarsaldosvencidossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarsaldosvencidosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarsaldosvencidosDataAccess.setConnexionType(this.connexionType);
			this.cobrarsaldosvencidosDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarsaldosvencidosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarSaldosVencidos getCobrarSaldosVencidos() throws Exception {	
		CobrarSaldosVencidosLogicAdditional.checkCobrarSaldosVencidosToGet(cobrarsaldosvencidos,this.datosCliente,this.arrDatoGeneral);
		CobrarSaldosVencidosLogicAdditional.updateCobrarSaldosVencidosToGet(cobrarsaldosvencidos,this.arrDatoGeneral);
		
		return cobrarsaldosvencidos;
	}
		
	public void setCobrarSaldosVencidos(CobrarSaldosVencidos newCobrarSaldosVencidos) {
		this.cobrarsaldosvencidos = newCobrarSaldosVencidos;
	}
	
	public List<CobrarSaldosVencidos> getCobrarSaldosVencidoss() throws Exception {		
		this.quitarCobrarSaldosVencidossNulos();
		
		CobrarSaldosVencidosLogicAdditional.checkCobrarSaldosVencidosToGets(cobrarsaldosvencidoss,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarSaldosVencidos cobrarsaldosvencidosLocal: cobrarsaldosvencidoss ) {
			CobrarSaldosVencidosLogicAdditional.updateCobrarSaldosVencidosToGet(cobrarsaldosvencidosLocal,this.arrDatoGeneral);
		}
		
		return cobrarsaldosvencidoss;
	}
	
	public void setCobrarSaldosVencidoss(List<CobrarSaldosVencidos> newCobrarSaldosVencidoss) {
		this.cobrarsaldosvencidoss = newCobrarSaldosVencidoss;
	}
	
	public Object getCobrarSaldosVencidosObject() {	
		//this.cobrarsaldosvencidosObject=this.cobrarsaldosvencidosDataAccess.getEntityObject();
		return this.cobrarsaldosvencidosObject;
	}
		
	public void setCobrarSaldosVencidosObject(Object newCobrarSaldosVencidosObject) {
		this.cobrarsaldosvencidosObject = newCobrarSaldosVencidosObject;
	}
	
	public List<Object> getCobrarSaldosVencidossObject() {		
		//this.cobrarsaldosvencidossObject=this.cobrarsaldosvencidosDataAccess.getEntitiesObject();
		return this.cobrarsaldosvencidossObject;
	}
		
	public void setCobrarSaldosVencidossObject(List<Object> newCobrarSaldosVencidossObject) {
		this.cobrarsaldosvencidossObject = newCobrarSaldosVencidossObject;
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
		cobrarsaldosvencidoss = new  ArrayList<CobrarSaldosVencidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarSaldosVencidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarsaldosvencidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarsaldosvencidoss = new  ArrayList<CobrarSaldosVencidos>();
		  		  
        try {
			//CobrarSaldosVencidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarsaldosvencidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarsaldosvencidoss = new  ArrayList<CobrarSaldosVencidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarSaldosVencidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarsaldosvencidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarsaldosvencidoss = new  ArrayList<CobrarSaldosVencidos>();
		  		  
        try {
			//CobrarSaldosVencidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarsaldosvencidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarsaldosvencidoss = new  ArrayList<CobrarSaldosVencidos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarSaldosVencidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarsaldosvencidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarsaldosvencidoss = new  ArrayList<CobrarSaldosVencidos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarSaldosVencidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarsaldosvencidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarSaldosVencidos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarSaldosVencidos> entities = new  ArrayList<CobrarSaldosVencidos>();
		CobrarSaldosVencidos entity = new CobrarSaldosVencidos();		  
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
	
	public  List<CobrarSaldosVencidos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarSaldosVencidos> entities = new  ArrayList<CobrarSaldosVencidos>();
		CobrarSaldosVencidos entity = new CobrarSaldosVencidos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarSaldosVencidos();
				
				
      	    	entity=CobrarSaldosVencidosLogic.getEntityCobrarSaldosVencidos("",entity,resultSet);
      	    	
				//entity.setCobrarSaldosVencidosOriginal( new CobrarSaldosVencidos());
      	    	//entity.setCobrarSaldosVencidosOriginal(super.getEntity("",entity.getCobrarSaldosVencidosOriginal(),resultSet,CobrarSaldosVencidosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarSaldosVencidosOriginal(CobrarSaldosVencidosDataAccess.getEntityCobrarSaldosVencidos("",entity.getCobrarSaldosVencidosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarSaldosVencidos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarSaldosVencidos> entities = new  ArrayList<CobrarSaldosVencidos>();
		CobrarSaldosVencidos entity = new CobrarSaldosVencidos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarSaldosVencidos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarSaldosVencidos>((List<CobrarSaldosVencidos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarSaldosVencidossOriginal(entities);
			
			}  else {
				this.cobrarsaldosvencidossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarSaldosVencidosConstantesFunciones.quitarEspaciosCobrarSaldosVencidoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarSaldosVencidos getEntityCobrarSaldosVencidos(String strPrefijo,CobrarSaldosVencidos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnumero_factura(resultSet.getString(strPrefijo+CobrarSaldosVencidosConstantesFunciones.NUMEROFACTURA));
			entity.setnombre_grupo_cliente(resultSet.getString(strPrefijo+CobrarSaldosVencidosConstantesFunciones.NOMBREGRUPOCLIENTE));
			entity.setcodigo(resultSet.getString(strPrefijo+CobrarSaldosVencidosConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+CobrarSaldosVencidosConstantesFunciones.NOMBRE));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+CobrarSaldosVencidosConstantesFunciones.FECHA).getTime()));
			entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+CobrarSaldosVencidosConstantesFunciones.FECHAVENCE).getTime()));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+CobrarSaldosVencidosConstantesFunciones.FECHAEMISION).getTime()));
			entity.setsaldo(resultSet.getDouble(strPrefijo+CobrarSaldosVencidosConstantesFunciones.SALDO));
			entity.settelefono_telefono(resultSet.getString(strPrefijo+CobrarSaldosVencidosConstantesFunciones.TELEFONOTELEFONO));
			entity.setdescripcion(resultSet.getString(strPrefijo+CobrarSaldosVencidosConstantesFunciones.DESCRIPCION));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarSaldosVencidos getEntityCobrarSaldosVencidos(String strPrefijo,CobrarSaldosVencidos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarSaldosVencidos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarSaldosVencidos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarSaldosVencidosLogic.setFieldReflectionCobrarSaldosVencidos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarSaldosVencidos(Field field,String strPrefijo,String sColumn,CobrarSaldosVencidos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarSaldosVencidosConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarSaldosVencidosConstantesFunciones.NOMBREGRUPOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarSaldosVencidosConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarSaldosVencidosConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarSaldosVencidosConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarSaldosVencidosConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarSaldosVencidosConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarSaldosVencidosConstantesFunciones.SALDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarSaldosVencidosConstantesFunciones.TELEFONOTELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarSaldosVencidosConstantesFunciones.DESCRIPCION:
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
	
	public void quitarCobrarSaldosVencidossNulos() throws Exception {				
		
		List<CobrarSaldosVencidos> cobrarsaldosvencidossAux= new ArrayList<CobrarSaldosVencidos>();
		
		for(CobrarSaldosVencidos cobrarsaldosvencidos:cobrarsaldosvencidoss) {
			if(cobrarsaldosvencidos!=null) {
				cobrarsaldosvencidossAux.add(cobrarsaldosvencidos);
			}
		}
		
		cobrarsaldosvencidoss=cobrarsaldosvencidossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarSaldosVencidos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarSaldosVencidos> entities = new  ArrayList<CobrarSaldosVencidos>();
		CobrarSaldosVencidos entity = new CobrarSaldosVencidos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarSaldosVencidos>((List<CobrarSaldosVencidos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarSaldosVencidossOriginal(entities);
			
			}  else {
				this.cobrarsaldosvencidossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarSaldosVencidosConstantesFunciones.quitarEspaciosCobrarSaldosVencidoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarsaldosvencidoss = new  ArrayList<CobrarSaldosVencidos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarSaldosVencidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarsaldosvencidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarsaldosvencidoss = new  ArrayList<CobrarSaldosVencidos>();
		  		  
        try {
			//CobrarSaldosVencidosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarsaldosvencidoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarSaldosVencidos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarSaldosVencidos> entities = new  ArrayList<CobrarSaldosVencidos>();
		CobrarSaldosVencidos entity = new CobrarSaldosVencidos();		  
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
	
	public  List<CobrarSaldosVencidos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarSaldosVencidos> entities = new  ArrayList<CobrarSaldosVencidos>();
		CobrarSaldosVencidos entity = new CobrarSaldosVencidos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarSaldosVencidos();
				
				if(conMapGenerico) {
					entity.setMapCobrarSaldosVencidos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarSaldosVencidos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarSaldosVencidosDataAccess.ISWITHSCHEMA);         		
					entity=CobrarSaldosVencidosLogic.getEntityCobrarSaldosVencidos("",entity,resultSet,listColumns);
					
					////entity.setCobrarSaldosVencidosOriginal( new CobrarSaldosVencidos());
					////entity.setCobrarSaldosVencidosOriginal(super.getEntity("",entity.getCobrarSaldosVencidosOriginal(),resultSet,CobrarSaldosVencidosDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarSaldosVencidosOriginal(CobrarSaldosVencidosDataAccess.getEntityCobrarSaldosVencidos("",entity.getCobrarSaldosVencidosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public GrupoCliente getGrupoCliente(Connexion connexion,CobrarSaldosVencidos relcobrarsaldosvencidos)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			grupoclienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relcobrarsaldosvencidos.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}

	public Empresa getEmpresa(Connexion connexion,CobrarSaldosVencidos relcobrarsaldosvencidos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarsaldosvencidos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getCobrarSaldosVencidossBusquedaCobrarSaldosVencidosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_grupo_cliente)throws Exception {
		try {
			//CobrarSaldosVencidosLogic cobrarsaldosvencidosLogic=new CobrarSaldosVencidosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarSaldosVencidosLogic.GetSelecSqlCobrarSaldosVencidos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_grupo_cliente);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarsaldosvencidoss=this.getCobrarSaldosVencidoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarSaldosVencidossBusquedaCobrarSaldosVencidos(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_grupo_cliente)throws Exception {
		try {
			//CobrarSaldosVencidosLogic cobrarsaldosvencidosLogic=new CobrarSaldosVencidosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarSaldosVencidosLogic.GetSelecSqlCobrarSaldosVencidos(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_grupo_cliente);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarsaldosvencidoss=this.getCobrarSaldosVencidoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarSaldosVencidos(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_grupo_cliente)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarSaldosVencidos_Postgres.sql");
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
				

				if(id_grupo_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_grupo_cliente = "+id_grupo_cliente.toString();
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
	
	
	public void deepLoad(CobrarSaldosVencidos cobrarsaldosvencidos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarSaldosVencidosLogicAdditional.updateCobrarSaldosVencidosToGet(cobrarsaldosvencidos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarsaldosvencidos.setGrupoCliente(cobrarsaldosvencidosDataAccess.getGrupoCliente(connexion,cobrarsaldosvencidos));
		cobrarsaldosvencidos.setEmpresa(cobrarsaldosvencidosDataAccess.getEmpresa(connexion,cobrarsaldosvencidos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				cobrarsaldosvencidos.setGrupoCliente(cobrarsaldosvencidosDataAccess.getGrupoCliente(connexion,cobrarsaldosvencidos));
			}

			if(clas.clas.equals(Empresa.class)) {
				cobrarsaldosvencidos.setEmpresa(cobrarsaldosvencidosDataAccess.getEmpresa(connexion,cobrarsaldosvencidos));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarsaldosvencidos.setGrupoCliente(cobrarsaldosvencidosDataAccess.getGrupoCliente(connexion,cobrarsaldosvencidos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarsaldosvencidos.setEmpresa(cobrarsaldosvencidosDataAccess.getEmpresa(connexion,cobrarsaldosvencidos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarsaldosvencidos.setGrupoCliente(cobrarsaldosvencidosDataAccess.getGrupoCliente(connexion,cobrarsaldosvencidos));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(cobrarsaldosvencidos.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		cobrarsaldosvencidos.setEmpresa(cobrarsaldosvencidosDataAccess.getEmpresa(connexion,cobrarsaldosvencidos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarsaldosvencidos.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				cobrarsaldosvencidos.setGrupoCliente(cobrarsaldosvencidosDataAccess.getGrupoCliente(connexion,cobrarsaldosvencidos));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(cobrarsaldosvencidos.getGrupoCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				cobrarsaldosvencidos.setEmpresa(cobrarsaldosvencidosDataAccess.getEmpresa(connexion,cobrarsaldosvencidos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarsaldosvencidos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarsaldosvencidos.setGrupoCliente(cobrarsaldosvencidosDataAccess.getGrupoCliente(connexion,cobrarsaldosvencidos));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(cobrarsaldosvencidos.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrarsaldosvencidos.setEmpresa(cobrarsaldosvencidosDataAccess.getEmpresa(connexion,cobrarsaldosvencidos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarsaldosvencidos.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarsaldosvencidos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarSaldosVencidosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarSaldosVencidos(cobrarsaldosvencidos);
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
			this.deepLoad(this.cobrarsaldosvencidos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarSaldosVencidosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarSaldosVencidos(this.cobrarsaldosvencidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarsaldosvencidoss!=null) {
				for(CobrarSaldosVencidos cobrarsaldosvencidos:cobrarsaldosvencidoss) {
					this.deepLoad(cobrarsaldosvencidos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarSaldosVencidosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarSaldosVencidos(cobrarsaldosvencidoss);
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
			if(cobrarsaldosvencidoss!=null) {
				for(CobrarSaldosVencidos cobrarsaldosvencidos:cobrarsaldosvencidoss) {
					this.deepLoad(cobrarsaldosvencidos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarSaldosVencidosConstantesFunciones.refrescarForeignKeysDescripcionesCobrarSaldosVencidos(cobrarsaldosvencidoss);
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
	
	public CobrarSaldosVencidosParameterReturnGeneral procesarAccionCobrarSaldosVencidoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarSaldosVencidos> cobrarsaldosvencidoss,CobrarSaldosVencidosParameterReturnGeneral cobrarsaldosvencidosParameterGeneral)throws Exception {
		 try {	
			CobrarSaldosVencidosParameterReturnGeneral cobrarsaldosvencidosReturnGeneral=new CobrarSaldosVencidosParameterReturnGeneral();
	
			CobrarSaldosVencidosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarsaldosvencidoss,cobrarsaldosvencidosParameterGeneral,cobrarsaldosvencidosReturnGeneral);
			
			return cobrarsaldosvencidosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarSaldosVencidosParameterReturnGeneral procesarAccionCobrarSaldosVencidossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarSaldosVencidos> cobrarsaldosvencidoss,CobrarSaldosVencidosParameterReturnGeneral cobrarsaldosvencidosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarSaldosVencidosParameterReturnGeneral cobrarsaldosvencidosReturnGeneral=new CobrarSaldosVencidosParameterReturnGeneral();
	
			CobrarSaldosVencidosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarsaldosvencidoss,cobrarsaldosvencidosParameterGeneral,cobrarsaldosvencidosReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarsaldosvencidosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

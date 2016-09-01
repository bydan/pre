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
import com.bydan.erp.cartera.util.report.SaldosVencidosProveedoresParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.SaldosVencidosProveedoresParameterGeneral;
import com.bydan.erp.cartera.util.report.SaldosVencidosProveedoresConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.SaldosVencidosProveedores;

import com.bydan.erp.cartera.business.logic.report.SaldosVencidosProveedoresLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class SaldosVencidosProveedoresLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(SaldosVencidosProveedoresLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected SaldosVencidosProveedoresLogic saldosvencidosproveedoresDataAccess; 		
	protected SaldosVencidosProveedores saldosvencidosproveedores;
	protected List<SaldosVencidosProveedores> saldosvencidosproveedoress;
	protected Object saldosvencidosproveedoresObject;	
	protected List<Object> saldosvencidosproveedoressObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  SaldosVencidosProveedoresLogic()throws SQLException,Exception {
		try	{
			this.saldosvencidosproveedoress= new ArrayList<SaldosVencidosProveedores>();
			this.saldosvencidosproveedores= new SaldosVencidosProveedores();
			this.saldosvencidosproveedoresObject=new Object();
			this.saldosvencidosproveedoressObject=new ArrayList<Object>();
			
			this.saldosvencidosproveedoresDataAccess=this;
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
			this.saldosvencidosproveedoresDataAccess.setConnexionType(this.connexionType);
			this.saldosvencidosproveedoresDataAccess.setParameterDbType(this.parameterDbType);
			this.saldosvencidosproveedoresDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SaldosVencidosProveedoresLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.saldosvencidosproveedoress= new ArrayList<SaldosVencidosProveedores>();
			this.saldosvencidosproveedores= new SaldosVencidosProveedores();
			this.saldosvencidosproveedoresObject=new Object();
			this.saldosvencidosproveedoressObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.saldosvencidosproveedoresDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.saldosvencidosproveedoresDataAccess.setConnexionType(this.connexionType);
			this.saldosvencidosproveedoresDataAccess.setParameterDbType(this.parameterDbType);
			this.saldosvencidosproveedoresDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SaldosVencidosProveedores getSaldosVencidosProveedores() throws Exception {	
		SaldosVencidosProveedoresLogicAdditional.checkSaldosVencidosProveedoresToGet(saldosvencidosproveedores,this.datosCliente,this.arrDatoGeneral);
		SaldosVencidosProveedoresLogicAdditional.updateSaldosVencidosProveedoresToGet(saldosvencidosproveedores,this.arrDatoGeneral);
		
		return saldosvencidosproveedores;
	}
		
	public void setSaldosVencidosProveedores(SaldosVencidosProveedores newSaldosVencidosProveedores) {
		this.saldosvencidosproveedores = newSaldosVencidosProveedores;
	}
	
	public List<SaldosVencidosProveedores> getSaldosVencidosProveedoress() throws Exception {		
		this.quitarSaldosVencidosProveedoressNulos();
		
		SaldosVencidosProveedoresLogicAdditional.checkSaldosVencidosProveedoresToGets(saldosvencidosproveedoress,this.datosCliente,this.arrDatoGeneral);
		
		for (SaldosVencidosProveedores saldosvencidosproveedoresLocal: saldosvencidosproveedoress ) {
			SaldosVencidosProveedoresLogicAdditional.updateSaldosVencidosProveedoresToGet(saldosvencidosproveedoresLocal,this.arrDatoGeneral);
		}
		
		return saldosvencidosproveedoress;
	}
	
	public void setSaldosVencidosProveedoress(List<SaldosVencidosProveedores> newSaldosVencidosProveedoress) {
		this.saldosvencidosproveedoress = newSaldosVencidosProveedoress;
	}
	
	public Object getSaldosVencidosProveedoresObject() {	
		//this.saldosvencidosproveedoresObject=this.saldosvencidosproveedoresDataAccess.getEntityObject();
		return this.saldosvencidosproveedoresObject;
	}
		
	public void setSaldosVencidosProveedoresObject(Object newSaldosVencidosProveedoresObject) {
		this.saldosvencidosproveedoresObject = newSaldosVencidosProveedoresObject;
	}
	
	public List<Object> getSaldosVencidosProveedoressObject() {		
		//this.saldosvencidosproveedoressObject=this.saldosvencidosproveedoresDataAccess.getEntitiesObject();
		return this.saldosvencidosproveedoressObject;
	}
		
	public void setSaldosVencidosProveedoressObject(List<Object> newSaldosVencidosProveedoressObject) {
		this.saldosvencidosproveedoressObject = newSaldosVencidosProveedoressObject;
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
		saldosvencidosproveedoress = new  ArrayList<SaldosVencidosProveedores>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosVencidosProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosvencidosproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		saldosvencidosproveedoress = new  ArrayList<SaldosVencidosProveedores>();
		  		  
        try {
			//SaldosVencidosProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosvencidosproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		saldosvencidosproveedoress = new  ArrayList<SaldosVencidosProveedores>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosVencidosProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosvencidosproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		saldosvencidosproveedoress = new  ArrayList<SaldosVencidosProveedores>();
		  		  
        try {
			//SaldosVencidosProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosvencidosproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		saldosvencidosproveedoress = new  ArrayList<SaldosVencidosProveedores>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosVencidosProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosvencidosproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		saldosvencidosproveedoress = new  ArrayList<SaldosVencidosProveedores>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//SaldosVencidosProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosvencidosproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<SaldosVencidosProveedores> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosVencidosProveedores> entities = new  ArrayList<SaldosVencidosProveedores>();
		SaldosVencidosProveedores entity = new SaldosVencidosProveedores();		  
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
	
	public  List<SaldosVencidosProveedores> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosVencidosProveedores> entities = new  ArrayList<SaldosVencidosProveedores>();
		SaldosVencidosProveedores entity = new SaldosVencidosProveedores();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SaldosVencidosProveedores();
				
				
      	    	entity=SaldosVencidosProveedoresLogic.getEntitySaldosVencidosProveedores("",entity,resultSet);
      	    	
				//entity.setSaldosVencidosProveedoresOriginal( new SaldosVencidosProveedores());
      	    	//entity.setSaldosVencidosProveedoresOriginal(super.getEntity("",entity.getSaldosVencidosProveedoresOriginal(),resultSet,SaldosVencidosProveedoresDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSaldosVencidosProveedoresOriginal(SaldosVencidosProveedoresDataAccess.getEntitySaldosVencidosProveedores("",entity.getSaldosVencidosProveedoresOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<SaldosVencidosProveedores> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosVencidosProveedores> entities = new  ArrayList<SaldosVencidosProveedores>();
		SaldosVencidosProveedores entity = new SaldosVencidosProveedores();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,SaldosVencidosProveedores.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SaldosVencidosProveedores>((List<SaldosVencidosProveedores>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSaldosVencidosProveedoressOriginal(entities);
			
			}  else {
				this.saldosvencidosproveedoressObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SaldosVencidosProveedoresConstantesFunciones.quitarEspaciosSaldosVencidosProveedoress(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static SaldosVencidosProveedores getEntitySaldosVencidosProveedores(String strPrefijo,SaldosVencidosProveedores entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_factura(resultSet.getLong(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.IDFACTURA));
			entity.setid_moneda(resultSet.getLong(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.IDMONEDA));
			entity.setid_cliente(resultSet.getLong(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.IDCLIENTE));
			entity.setnumero_factura(resultSet.getString(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.NUMEROFACTURA));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_venta(new Date(resultSet.getDate(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.FECHAVENTA).getTime()));
			entity.setnombre_moneda(resultSet.getString(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.NOMBREMONEDA));
			entity.setsaldo(resultSet.getDouble(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.SALDO));
			entity.setsaldo_extra(resultSet.getDouble(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA));
			entity.setnombre_cliente(resultSet.getString(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.NOMBRECLIENTE));
			entity.setnombre_grupo_cliente(resultSet.getString(strPrefijo+SaldosVencidosProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SaldosVencidosProveedores getEntitySaldosVencidosProveedores(String strPrefijo,SaldosVencidosProveedores entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = SaldosVencidosProveedores.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = SaldosVencidosProveedores.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				SaldosVencidosProveedoresLogic.setFieldReflectionSaldosVencidosProveedores(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSaldosVencidosProveedores(Field field,String strPrefijo,String sColumn,SaldosVencidosProveedores entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SaldosVencidosProveedoresConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.FECHAVENTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.NOMBREMONEDA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.SALDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SaldosVencidosProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE:
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
	
	public void quitarSaldosVencidosProveedoressNulos() throws Exception {				
		
		List<SaldosVencidosProveedores> saldosvencidosproveedoressAux= new ArrayList<SaldosVencidosProveedores>();
		
		for(SaldosVencidosProveedores saldosvencidosproveedores:saldosvencidosproveedoress) {
			if(saldosvencidosproveedores!=null) {
				saldosvencidosproveedoressAux.add(saldosvencidosproveedores);
			}
		}
		
		saldosvencidosproveedoress=saldosvencidosproveedoressAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<SaldosVencidosProveedores> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SaldosVencidosProveedores> entities = new  ArrayList<SaldosVencidosProveedores>();
		SaldosVencidosProveedores entity = new SaldosVencidosProveedores();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<SaldosVencidosProveedores>((List<SaldosVencidosProveedores>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setSaldosVencidosProveedoressOriginal(entities);
			
			}  else {
				this.saldosvencidosproveedoressObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//SaldosVencidosProveedoresConstantesFunciones.quitarEspaciosSaldosVencidosProveedoress(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		saldosvencidosproveedoress = new  ArrayList<SaldosVencidosProveedores>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//SaldosVencidosProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosvencidosproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		saldosvencidosproveedoress = new  ArrayList<SaldosVencidosProveedores>();
		  		  
        try {
			//SaldosVencidosProveedoresLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldosvencidosproveedoress=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<SaldosVencidosProveedores> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SaldosVencidosProveedores> entities = new  ArrayList<SaldosVencidosProveedores>();
		SaldosVencidosProveedores entity = new SaldosVencidosProveedores();		  
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
	
	public  List<SaldosVencidosProveedores> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<SaldosVencidosProveedores> entities = new  ArrayList<SaldosVencidosProveedores>();
		SaldosVencidosProveedores entity = new SaldosVencidosProveedores();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SaldosVencidosProveedores();
				
				if(conMapGenerico) {
					entity.setMapSaldosVencidosProveedores( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapSaldosVencidosProveedores().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SaldosVencidosProveedoresDataAccess.ISWITHSCHEMA);         		
					entity=SaldosVencidosProveedoresLogic.getEntitySaldosVencidosProveedores("",entity,resultSet,listColumns);
					
					////entity.setSaldosVencidosProveedoresOriginal( new SaldosVencidosProveedores());
					////entity.setSaldosVencidosProveedoresOriginal(super.getEntity("",entity.getSaldosVencidosProveedoresOriginal(),resultSet,SaldosVencidosProveedoresDataAccess.ISWITHSCHEMA));         		
					////entity.setSaldosVencidosProveedoresOriginal(SaldosVencidosProveedoresDataAccess.getEntitySaldosVencidosProveedores("",entity.getSaldosVencidosProveedoresOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,SaldosVencidosProveedores relsaldosvencidosproveedores)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relsaldosvencidosproveedores.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public GrupoCliente getGrupoCliente(Connexion connexion,SaldosVencidosProveedores relsaldosvencidosproveedores)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			grupoclienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relsaldosvencidosproveedores.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}

	public Factura getFactura(Connexion connexion,SaldosVencidosProveedores relsaldosvencidosproveedores)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);
			facturaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			factura=facturaDataAccess.getEntity(connexion,relsaldosvencidosproveedores.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Moneda getMoneda(Connexion connexion,SaldosVencidosProveedores relsaldosvencidosproveedores)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);
			monedaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			moneda=monedaDataAccess.getEntity(connexion,relsaldosvencidosproveedores.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Cliente getCliente(Connexion connexion,SaldosVencidosProveedores relsaldosvencidosproveedores)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relsaldosvencidosproveedores.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


	
	
	public void getSaldosVencidosProveedoressBusquedaSaldosVencidosProveedoresWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_grupo_cliente)throws Exception {
		try {
			//SaldosVencidosProveedoresLogic saldosvencidosproveedoresLogic=new SaldosVencidosProveedoresLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SaldosVencidosProveedoresLogic.GetSelecSqlSaldosVencidosProveedores(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_grupo_cliente);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.saldosvencidosproveedoress=this.getSaldosVencidosProveedoress();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getSaldosVencidosProveedoressBusquedaSaldosVencidosProveedores(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_grupo_cliente)throws Exception {
		try {
			//SaldosVencidosProveedoresLogic saldosvencidosproveedoresLogic=new SaldosVencidosProveedoresLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=SaldosVencidosProveedoresLogic.GetSelecSqlSaldosVencidosProveedores(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_grupo_cliente);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.saldosvencidosproveedoress=this.getSaldosVencidosProveedoress();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlSaldosVencidosProveedores(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_grupo_cliente)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("SaldosVencidosProveedores_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" m.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" m.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
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
	
	
	public void deepLoad(SaldosVencidosProveedores saldosvencidosproveedores,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SaldosVencidosProveedoresLogicAdditional.updateSaldosVencidosProveedoresToGet(saldosvencidosproveedores,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldosvencidosproveedores.setEmpresa(saldosvencidosproveedoresDataAccess.getEmpresa(connexion,saldosvencidosproveedores));
		saldosvencidosproveedores.setGrupoCliente(saldosvencidosproveedoresDataAccess.getGrupoCliente(connexion,saldosvencidosproveedores));
		saldosvencidosproveedores.setFactura(saldosvencidosproveedoresDataAccess.getFactura(connexion,saldosvencidosproveedores));
		saldosvencidosproveedores.setMoneda(saldosvencidosproveedoresDataAccess.getMoneda(connexion,saldosvencidosproveedores));
		saldosvencidosproveedores.setCliente(saldosvencidosproveedoresDataAccess.getCliente(connexion,saldosvencidosproveedores));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				saldosvencidosproveedores.setEmpresa(saldosvencidosproveedoresDataAccess.getEmpresa(connexion,saldosvencidosproveedores));
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				saldosvencidosproveedores.setGrupoCliente(saldosvencidosproveedoresDataAccess.getGrupoCliente(connexion,saldosvencidosproveedores));
			}

			if(clas.clas.equals(Factura.class)) {
				saldosvencidosproveedores.setFactura(saldosvencidosproveedoresDataAccess.getFactura(connexion,saldosvencidosproveedores));
			}

			if(clas.clas.equals(Moneda.class)) {
				saldosvencidosproveedores.setMoneda(saldosvencidosproveedoresDataAccess.getMoneda(connexion,saldosvencidosproveedores));
			}

			if(clas.clas.equals(Cliente.class)) {
				saldosvencidosproveedores.setCliente(saldosvencidosproveedoresDataAccess.getCliente(connexion,saldosvencidosproveedores));
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
			saldosvencidosproveedores.setEmpresa(saldosvencidosproveedoresDataAccess.getEmpresa(connexion,saldosvencidosproveedores));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosvencidosproveedores.setGrupoCliente(saldosvencidosproveedoresDataAccess.getGrupoCliente(connexion,saldosvencidosproveedores));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosvencidosproveedores.setFactura(saldosvencidosproveedoresDataAccess.getFactura(connexion,saldosvencidosproveedores));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosvencidosproveedores.setMoneda(saldosvencidosproveedoresDataAccess.getMoneda(connexion,saldosvencidosproveedores));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosvencidosproveedores.setCliente(saldosvencidosproveedoresDataAccess.getCliente(connexion,saldosvencidosproveedores));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldosvencidosproveedores.setEmpresa(saldosvencidosproveedoresDataAccess.getEmpresa(connexion,saldosvencidosproveedores));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(saldosvencidosproveedores.getEmpresa(),isDeep,deepLoadType,clases);
				
		saldosvencidosproveedores.setGrupoCliente(saldosvencidosproveedoresDataAccess.getGrupoCliente(connexion,saldosvencidosproveedores));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(saldosvencidosproveedores.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		saldosvencidosproveedores.setFactura(saldosvencidosproveedoresDataAccess.getFactura(connexion,saldosvencidosproveedores));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(saldosvencidosproveedores.getFactura(),isDeep,deepLoadType,clases);
				
		saldosvencidosproveedores.setMoneda(saldosvencidosproveedoresDataAccess.getMoneda(connexion,saldosvencidosproveedores));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(saldosvencidosproveedores.getMoneda(),isDeep,deepLoadType,clases);
				
		saldosvencidosproveedores.setCliente(saldosvencidosproveedoresDataAccess.getCliente(connexion,saldosvencidosproveedores));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(saldosvencidosproveedores.getCliente(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				saldosvencidosproveedores.setEmpresa(saldosvencidosproveedoresDataAccess.getEmpresa(connexion,saldosvencidosproveedores));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(saldosvencidosproveedores.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				saldosvencidosproveedores.setGrupoCliente(saldosvencidosproveedoresDataAccess.getGrupoCliente(connexion,saldosvencidosproveedores));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(saldosvencidosproveedores.getGrupoCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Factura.class)) {
				saldosvencidosproveedores.setFactura(saldosvencidosproveedoresDataAccess.getFactura(connexion,saldosvencidosproveedores));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(saldosvencidosproveedores.getFactura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Moneda.class)) {
				saldosvencidosproveedores.setMoneda(saldosvencidosproveedoresDataAccess.getMoneda(connexion,saldosvencidosproveedores));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(saldosvencidosproveedores.getMoneda(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				saldosvencidosproveedores.setCliente(saldosvencidosproveedoresDataAccess.getCliente(connexion,saldosvencidosproveedores));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(saldosvencidosproveedores.getCliente(),isDeep,deepLoadType,clases);				
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
			saldosvencidosproveedores.setEmpresa(saldosvencidosproveedoresDataAccess.getEmpresa(connexion,saldosvencidosproveedores));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(saldosvencidosproveedores.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosvencidosproveedores.setGrupoCliente(saldosvencidosproveedoresDataAccess.getGrupoCliente(connexion,saldosvencidosproveedores));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(saldosvencidosproveedores.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosvencidosproveedores.setFactura(saldosvencidosproveedoresDataAccess.getFactura(connexion,saldosvencidosproveedores));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(saldosvencidosproveedores.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosvencidosproveedores.setMoneda(saldosvencidosproveedoresDataAccess.getMoneda(connexion,saldosvencidosproveedores));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(saldosvencidosproveedores.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldosvencidosproveedores.setCliente(saldosvencidosproveedoresDataAccess.getCliente(connexion,saldosvencidosproveedores));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(saldosvencidosproveedores.getCliente(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(saldosvencidosproveedores,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldosVencidosProveedoresConstantesFunciones.refrescarForeignKeysDescripcionesSaldosVencidosProveedores(saldosvencidosproveedores);
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
			this.deepLoad(this.saldosvencidosproveedores,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldosVencidosProveedoresConstantesFunciones.refrescarForeignKeysDescripcionesSaldosVencidosProveedores(this.saldosvencidosproveedores);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(saldosvencidosproveedoress!=null) {
				for(SaldosVencidosProveedores saldosvencidosproveedores:saldosvencidosproveedoress) {
					this.deepLoad(saldosvencidosproveedores,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SaldosVencidosProveedoresConstantesFunciones.refrescarForeignKeysDescripcionesSaldosVencidosProveedores(saldosvencidosproveedoress);
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
			if(saldosvencidosproveedoress!=null) {
				for(SaldosVencidosProveedores saldosvencidosproveedores:saldosvencidosproveedoress) {
					this.deepLoad(saldosvencidosproveedores,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SaldosVencidosProveedoresConstantesFunciones.refrescarForeignKeysDescripcionesSaldosVencidosProveedores(saldosvencidosproveedoress);
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
	
	public SaldosVencidosProveedoresParameterReturnGeneral procesarAccionSaldosVencidosProveedoress(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldosVencidosProveedores> saldosvencidosproveedoress,SaldosVencidosProveedoresParameterReturnGeneral saldosvencidosproveedoresParameterGeneral)throws Exception {
		 try {	
			SaldosVencidosProveedoresParameterReturnGeneral saldosvencidosproveedoresReturnGeneral=new SaldosVencidosProveedoresParameterReturnGeneral();
	
			SaldosVencidosProveedoresLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldosvencidosproveedoress,saldosvencidosproveedoresParameterGeneral,saldosvencidosproveedoresReturnGeneral);
			
			return saldosvencidosproveedoresReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SaldosVencidosProveedoresParameterReturnGeneral procesarAccionSaldosVencidosProveedoressWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldosVencidosProveedores> saldosvencidosproveedoress,SaldosVencidosProveedoresParameterReturnGeneral saldosvencidosproveedoresParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			SaldosVencidosProveedoresParameterReturnGeneral saldosvencidosproveedoresReturnGeneral=new SaldosVencidosProveedoresParameterReturnGeneral();
	
			SaldosVencidosProveedoresLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldosvencidosproveedoress,saldosvencidosproveedoresParameterGeneral,saldosvencidosproveedoresReturnGeneral);
			
			this.connexion.commit();
			
			return saldosvencidosproveedoresReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

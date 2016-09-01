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
package com.bydan.erp.puntoventa.business.logic.report;

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

import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.resources.general.AuxiliarGeneral;
import com.bydan.erp.puntoventa.util.report.ComprobanteTarjetaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ComprobanteTarjetaParameterGeneral;
import com.bydan.erp.puntoventa.util.report.ComprobanteTarjetaConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.ComprobanteTarjeta;

import com.bydan.erp.puntoventa.business.logic.report.ComprobanteTarjetaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;






@SuppressWarnings("unused")
public class ComprobanteTarjetaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ComprobanteTarjetaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ComprobanteTarjetaLogic comprobantetarjetaDataAccess; 		
	protected ComprobanteTarjeta comprobantetarjeta;
	protected List<ComprobanteTarjeta> comprobantetarjetas;
	protected Object comprobantetarjetaObject;	
	protected List<Object> comprobantetarjetasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ComprobanteTarjetaLogic()throws SQLException,Exception {
		try	{
			this.comprobantetarjetas= new ArrayList<ComprobanteTarjeta>();
			this.comprobantetarjeta= new ComprobanteTarjeta();
			this.comprobantetarjetaObject=new Object();
			this.comprobantetarjetasObject=new ArrayList<Object>();
			
			this.comprobantetarjetaDataAccess=this;
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
			this.comprobantetarjetaDataAccess.setConnexionType(this.connexionType);
			this.comprobantetarjetaDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobantetarjetaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComprobanteTarjetaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.comprobantetarjetas= new ArrayList<ComprobanteTarjeta>();
			this.comprobantetarjeta= new ComprobanteTarjeta();
			this.comprobantetarjetaObject=new Object();
			this.comprobantetarjetasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.comprobantetarjetaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.comprobantetarjetaDataAccess.setConnexionType(this.connexionType);
			this.comprobantetarjetaDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobantetarjetaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComprobanteTarjeta getComprobanteTarjeta() throws Exception {	
		ComprobanteTarjetaLogicAdditional.checkComprobanteTarjetaToGet(comprobantetarjeta,this.datosCliente,this.arrDatoGeneral);
		ComprobanteTarjetaLogicAdditional.updateComprobanteTarjetaToGet(comprobantetarjeta,this.arrDatoGeneral);
		
		return comprobantetarjeta;
	}
		
	public void setComprobanteTarjeta(ComprobanteTarjeta newComprobanteTarjeta) {
		this.comprobantetarjeta = newComprobanteTarjeta;
	}
	
	public List<ComprobanteTarjeta> getComprobanteTarjetas() throws Exception {		
		this.quitarComprobanteTarjetasNulos();
		
		ComprobanteTarjetaLogicAdditional.checkComprobanteTarjetaToGets(comprobantetarjetas,this.datosCliente,this.arrDatoGeneral);
		
		for (ComprobanteTarjeta comprobantetarjetaLocal: comprobantetarjetas ) {
			ComprobanteTarjetaLogicAdditional.updateComprobanteTarjetaToGet(comprobantetarjetaLocal,this.arrDatoGeneral);
		}
		
		return comprobantetarjetas;
	}
	
	public void setComprobanteTarjetas(List<ComprobanteTarjeta> newComprobanteTarjetas) {
		this.comprobantetarjetas = newComprobanteTarjetas;
	}
	
	public Object getComprobanteTarjetaObject() {	
		//this.comprobantetarjetaObject=this.comprobantetarjetaDataAccess.getEntityObject();
		return this.comprobantetarjetaObject;
	}
		
	public void setComprobanteTarjetaObject(Object newComprobanteTarjetaObject) {
		this.comprobantetarjetaObject = newComprobanteTarjetaObject;
	}
	
	public List<Object> getComprobanteTarjetasObject() {		
		//this.comprobantetarjetasObject=this.comprobantetarjetaDataAccess.getEntitiesObject();
		return this.comprobantetarjetasObject;
	}
		
	public void setComprobanteTarjetasObject(List<Object> newComprobanteTarjetasObject) {
		this.comprobantetarjetasObject = newComprobanteTarjetasObject;
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
		comprobantetarjetas = new  ArrayList<ComprobanteTarjeta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantetarjetas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		comprobantetarjetas = new  ArrayList<ComprobanteTarjeta>();
		  		  
        try {
			//ComprobanteTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantetarjetas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comprobantetarjetas = new  ArrayList<ComprobanteTarjeta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantetarjetas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobantetarjetas = new  ArrayList<ComprobanteTarjeta>();
		  		  
        try {
			//ComprobanteTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantetarjetas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		comprobantetarjetas = new  ArrayList<ComprobanteTarjeta>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantetarjetas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobantetarjetas = new  ArrayList<ComprobanteTarjeta>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ComprobanteTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantetarjetas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ComprobanteTarjeta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteTarjeta> entities = new  ArrayList<ComprobanteTarjeta>();
		ComprobanteTarjeta entity = new ComprobanteTarjeta();		  
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
	
	public  List<ComprobanteTarjeta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteTarjeta> entities = new  ArrayList<ComprobanteTarjeta>();
		ComprobanteTarjeta entity = new ComprobanteTarjeta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobanteTarjeta();
				
				
      	    	entity=ComprobanteTarjetaLogic.getEntityComprobanteTarjeta("",entity,resultSet);
      	    	
				//entity.setComprobanteTarjetaOriginal( new ComprobanteTarjeta());
      	    	//entity.setComprobanteTarjetaOriginal(super.getEntity("",entity.getComprobanteTarjetaOriginal(),resultSet,ComprobanteTarjetaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComprobanteTarjetaOriginal(ComprobanteTarjetaDataAccess.getEntityComprobanteTarjeta("",entity.getComprobanteTarjetaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ComprobanteTarjeta> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteTarjeta> entities = new  ArrayList<ComprobanteTarjeta>();
		ComprobanteTarjeta entity = new ComprobanteTarjeta();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ComprobanteTarjeta.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobanteTarjeta>((List<ComprobanteTarjeta>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobanteTarjetasOriginal(entities);
			
			}  else {
				this.comprobantetarjetasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobanteTarjetaConstantesFunciones.quitarEspaciosComprobanteTarjetas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ComprobanteTarjeta getEntityComprobanteTarjeta(String strPrefijo,ComprobanteTarjeta entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_cliente(resultSet.getLong(strPrefijo+ComprobanteTarjetaConstantesFunciones.IDCLIENTE));
			entity.setid_caja(resultSet.getLong(strPrefijo+ComprobanteTarjetaConstantesFunciones.IDCAJA));
			entity.setnombre_caja(resultSet.getString(strPrefijo+ComprobanteTarjetaConstantesFunciones.NOMBRECAJA));
			entity.setsecuencial(resultSet.getString(strPrefijo+ComprobanteTarjetaConstantesFunciones.SECUENCIAL));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ComprobanteTarjetaConstantesFunciones.FECHA).getTime()));
			entity.setcodigo_cliente(resultSet.getString(strPrefijo+ComprobanteTarjetaConstantesFunciones.CODIGOCLIENTE));
			entity.setnombre_cliente(resultSet.getString(strPrefijo+ComprobanteTarjetaConstantesFunciones.NOMBRECLIENTE));
			entity.setsubtotal(resultSet.getDouble(strPrefijo+ComprobanteTarjetaConstantesFunciones.SUBTOTAL));
			entity.setiva(resultSet.getDouble(strPrefijo+ComprobanteTarjetaConstantesFunciones.IVA));
			entity.setdescuento(resultSet.getDouble(strPrefijo+ComprobanteTarjetaConstantesFunciones.DESCUENTO));
			entity.setfinanciamiento(resultSet.getDouble(strPrefijo+ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO));
			entity.setflete(resultSet.getDouble(strPrefijo+ComprobanteTarjetaConstantesFunciones.FLETE));
			entity.setice(resultSet.getDouble(strPrefijo+ComprobanteTarjetaConstantesFunciones.ICE));
			entity.settotal(resultSet.getDouble(strPrefijo+ComprobanteTarjetaConstantesFunciones.TOTAL));
			entity.setvalor(resultSet.getDouble(strPrefijo+ComprobanteTarjetaConstantesFunciones.VALOR));
			entity.setfecha_forma_pago(new Date(resultSet.getDate(strPrefijo+ComprobanteTarjetaConstantesFunciones.FECHAFORMAPAGO).getTime()));
			entity.setnumero(resultSet.getString(strPrefijo+ComprobanteTarjetaConstantesFunciones.NUMERO));
			entity.settarjeta_habiente(resultSet.getString(strPrefijo+ComprobanteTarjetaConstantesFunciones.TARJETAHABIENTE));
			entity.setautorizacion(resultSet.getString(strPrefijo+ComprobanteTarjetaConstantesFunciones.AUTORIZACION));
			entity.setvoucher(resultSet.getString(strPrefijo+ComprobanteTarjetaConstantesFunciones.VOUCHER));
			entity.setlote(resultSet.getString(strPrefijo+ComprobanteTarjetaConstantesFunciones.LOTE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComprobanteTarjeta getEntityComprobanteTarjeta(String strPrefijo,ComprobanteTarjeta entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ComprobanteTarjeta.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ComprobanteTarjeta.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ComprobanteTarjetaLogic.setFieldReflectionComprobanteTarjeta(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComprobanteTarjeta(Field field,String strPrefijo,String sColumn,ComprobanteTarjeta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComprobanteTarjetaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.NOMBRECAJA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.CODIGOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.FECHAFORMAPAGO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.TARJETAHABIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.AUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.VOUCHER:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteTarjetaConstantesFunciones.LOTE:
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
	
	public void quitarComprobanteTarjetasNulos() throws Exception {				
		
		List<ComprobanteTarjeta> comprobantetarjetasAux= new ArrayList<ComprobanteTarjeta>();
		
		for(ComprobanteTarjeta comprobantetarjeta:comprobantetarjetas) {
			if(comprobantetarjeta!=null) {
				comprobantetarjetasAux.add(comprobantetarjeta);
			}
		}
		
		comprobantetarjetas=comprobantetarjetasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ComprobanteTarjeta> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteTarjeta> entities = new  ArrayList<ComprobanteTarjeta>();
		ComprobanteTarjeta entity = new ComprobanteTarjeta();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobanteTarjeta>((List<ComprobanteTarjeta>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobanteTarjetasOriginal(entities);
			
			}  else {
				this.comprobantetarjetasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobanteTarjetaConstantesFunciones.quitarEspaciosComprobanteTarjetas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		comprobantetarjetas = new  ArrayList<ComprobanteTarjeta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantetarjetas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		comprobantetarjetas = new  ArrayList<ComprobanteTarjeta>();
		  		  
        try {
			//ComprobanteTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantetarjetas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ComprobanteTarjeta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobanteTarjeta> entities = new  ArrayList<ComprobanteTarjeta>();
		ComprobanteTarjeta entity = new ComprobanteTarjeta();		  
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
	
	public  List<ComprobanteTarjeta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobanteTarjeta> entities = new  ArrayList<ComprobanteTarjeta>();
		ComprobanteTarjeta entity = new ComprobanteTarjeta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobanteTarjeta();
				
				if(conMapGenerico) {
					entity.setMapComprobanteTarjeta( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapComprobanteTarjeta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComprobanteTarjetaDataAccess.ISWITHSCHEMA);         		
					entity=ComprobanteTarjetaLogic.getEntityComprobanteTarjeta("",entity,resultSet,listColumns);
					
					////entity.setComprobanteTarjetaOriginal( new ComprobanteTarjeta());
					////entity.setComprobanteTarjetaOriginal(super.getEntity("",entity.getComprobanteTarjetaOriginal(),resultSet,ComprobanteTarjetaDataAccess.ISWITHSCHEMA));         		
					////entity.setComprobanteTarjetaOriginal(ComprobanteTarjetaDataAccess.getEntityComprobanteTarjeta("",entity.getComprobanteTarjetaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ComprobanteTarjeta relcomprobantetarjeta)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcomprobantetarjeta.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ComprobanteTarjeta relcomprobantetarjeta)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relcomprobantetarjeta.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,ComprobanteTarjeta relcomprobantetarjeta)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relcomprobantetarjeta.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Caja getCaja(Connexion connexion,ComprobanteTarjeta relcomprobantetarjeta)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);
			cajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			caja=cajaDataAccess.getEntity(connexion,relcomprobantetarjeta.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}


	
	
	public void getComprobanteTarjetasBusquedaComprobanteTarjetaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//ComprobanteTarjetaLogic comprobantetarjetaLogic=new ComprobanteTarjetaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobanteTarjetaLogic.GetSelecSqlComprobanteTarjeta(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobantetarjetas=this.getComprobanteTarjetas();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getComprobanteTarjetasBusquedaComprobanteTarjeta(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//ComprobanteTarjetaLogic comprobantetarjetaLogic=new ComprobanteTarjetaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobanteTarjetaLogic.GetSelecSqlComprobanteTarjeta(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobantetarjetas=this.getComprobanteTarjetas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlComprobanteTarjeta(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ComprobanteTarjeta_Postgres.sql");
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
						sSqlWhere+=" and";
					}
					sSqlWhere+=" f.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(fecha_inicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_inicio)+"'";
					existeWhere=true;
				}

				if(fecha_fin!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_fin)+"'";
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
	
	
	public void deepLoad(ComprobanteTarjeta comprobantetarjeta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComprobanteTarjetaLogicAdditional.updateComprobanteTarjetaToGet(comprobantetarjeta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobantetarjeta.setEmpresa(comprobantetarjetaDataAccess.getEmpresa(connexion,comprobantetarjeta));
		comprobantetarjeta.setSucursal(comprobantetarjetaDataAccess.getSucursal(connexion,comprobantetarjeta));
		comprobantetarjeta.setCliente(comprobantetarjetaDataAccess.getCliente(connexion,comprobantetarjeta));
		comprobantetarjeta.setCaja(comprobantetarjetaDataAccess.getCaja(connexion,comprobantetarjeta));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobantetarjeta.setEmpresa(comprobantetarjetaDataAccess.getEmpresa(connexion,comprobantetarjeta));
			}

			if(clas.clas.equals(Sucursal.class)) {
				comprobantetarjeta.setSucursal(comprobantetarjetaDataAccess.getSucursal(connexion,comprobantetarjeta));
			}

			if(clas.clas.equals(Cliente.class)) {
				comprobantetarjeta.setCliente(comprobantetarjetaDataAccess.getCliente(connexion,comprobantetarjeta));
			}

			if(clas.clas.equals(Caja.class)) {
				comprobantetarjeta.setCaja(comprobantetarjetaDataAccess.getCaja(connexion,comprobantetarjeta));
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
			comprobantetarjeta.setEmpresa(comprobantetarjetaDataAccess.getEmpresa(connexion,comprobantetarjeta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantetarjeta.setSucursal(comprobantetarjetaDataAccess.getSucursal(connexion,comprobantetarjeta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantetarjeta.setCliente(comprobantetarjetaDataAccess.getCliente(connexion,comprobantetarjeta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantetarjeta.setCaja(comprobantetarjetaDataAccess.getCaja(connexion,comprobantetarjeta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobantetarjeta.setEmpresa(comprobantetarjetaDataAccess.getEmpresa(connexion,comprobantetarjeta));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comprobantetarjeta.getEmpresa(),isDeep,deepLoadType,clases);
				
		comprobantetarjeta.setSucursal(comprobantetarjetaDataAccess.getSucursal(connexion,comprobantetarjeta));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(comprobantetarjeta.getSucursal(),isDeep,deepLoadType,clases);
				
		comprobantetarjeta.setCliente(comprobantetarjetaDataAccess.getCliente(connexion,comprobantetarjeta));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(comprobantetarjeta.getCliente(),isDeep,deepLoadType,clases);
				
		comprobantetarjeta.setCaja(comprobantetarjetaDataAccess.getCaja(connexion,comprobantetarjeta));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(comprobantetarjeta.getCaja(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobantetarjeta.setEmpresa(comprobantetarjetaDataAccess.getEmpresa(connexion,comprobantetarjeta));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comprobantetarjeta.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				comprobantetarjeta.setSucursal(comprobantetarjetaDataAccess.getSucursal(connexion,comprobantetarjeta));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(comprobantetarjeta.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				comprobantetarjeta.setCliente(comprobantetarjetaDataAccess.getCliente(connexion,comprobantetarjeta));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(comprobantetarjeta.getCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Caja.class)) {
				comprobantetarjeta.setCaja(comprobantetarjetaDataAccess.getCaja(connexion,comprobantetarjeta));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(comprobantetarjeta.getCaja(),isDeep,deepLoadType,clases);				
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
			comprobantetarjeta.setEmpresa(comprobantetarjetaDataAccess.getEmpresa(connexion,comprobantetarjeta));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comprobantetarjeta.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantetarjeta.setSucursal(comprobantetarjetaDataAccess.getSucursal(connexion,comprobantetarjeta));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(comprobantetarjeta.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantetarjeta.setCliente(comprobantetarjetaDataAccess.getCliente(connexion,comprobantetarjeta));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(comprobantetarjeta.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantetarjeta.setCaja(comprobantetarjetaDataAccess.getCaja(connexion,comprobantetarjeta));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(comprobantetarjeta.getCaja(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(comprobantetarjeta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobanteTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteTarjeta(comprobantetarjeta);
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
			this.deepLoad(this.comprobantetarjeta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobanteTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteTarjeta(this.comprobantetarjeta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(comprobantetarjetas!=null) {
				for(ComprobanteTarjeta comprobantetarjeta:comprobantetarjetas) {
					this.deepLoad(comprobantetarjeta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComprobanteTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteTarjeta(comprobantetarjetas);
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
			if(comprobantetarjetas!=null) {
				for(ComprobanteTarjeta comprobantetarjeta:comprobantetarjetas) {
					this.deepLoad(comprobantetarjeta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComprobanteTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteTarjeta(comprobantetarjetas);
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
	
	public ComprobanteTarjetaParameterReturnGeneral procesarAccionComprobanteTarjetas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobanteTarjeta> comprobantetarjetas,ComprobanteTarjetaParameterReturnGeneral comprobantetarjetaParameterGeneral)throws Exception {
		 try {	
			ComprobanteTarjetaParameterReturnGeneral comprobantetarjetaReturnGeneral=new ComprobanteTarjetaParameterReturnGeneral();
	
			ComprobanteTarjetaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobantetarjetas,comprobantetarjetaParameterGeneral,comprobantetarjetaReturnGeneral);
			
			return comprobantetarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComprobanteTarjetaParameterReturnGeneral procesarAccionComprobanteTarjetasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobanteTarjeta> comprobantetarjetas,ComprobanteTarjetaParameterReturnGeneral comprobantetarjetaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ComprobanteTarjetaParameterReturnGeneral comprobantetarjetaReturnGeneral=new ComprobanteTarjetaParameterReturnGeneral();
	
			ComprobanteTarjetaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobantetarjetas,comprobantetarjetaParameterGeneral,comprobantetarjetaReturnGeneral);
			
			this.connexion.commit();
			
			return comprobantetarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

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
import com.bydan.erp.puntoventa.util.report.CajaDiariaCajaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.CajaDiariaCajaParameterGeneral;
import com.bydan.erp.puntoventa.util.report.CajaDiariaCajaConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.CajaDiariaCaja;

import com.bydan.erp.puntoventa.business.logic.report.CajaDiariaCajaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;






@SuppressWarnings("unused")
public class CajaDiariaCajaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CajaDiariaCajaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CajaDiariaCajaLogic cajadiariacajaDataAccess; 		
	protected CajaDiariaCaja cajadiariacaja;
	protected List<CajaDiariaCaja> cajadiariacajas;
	protected Object cajadiariacajaObject;	
	protected List<Object> cajadiariacajasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CajaDiariaCajaLogic()throws SQLException,Exception {
		try	{
			this.cajadiariacajas= new ArrayList<CajaDiariaCaja>();
			this.cajadiariacaja= new CajaDiariaCaja();
			this.cajadiariacajaObject=new Object();
			this.cajadiariacajasObject=new ArrayList<Object>();
			
			this.cajadiariacajaDataAccess=this;
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
			this.cajadiariacajaDataAccess.setConnexionType(this.connexionType);
			this.cajadiariacajaDataAccess.setParameterDbType(this.parameterDbType);
			this.cajadiariacajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CajaDiariaCajaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cajadiariacajas= new ArrayList<CajaDiariaCaja>();
			this.cajadiariacaja= new CajaDiariaCaja();
			this.cajadiariacajaObject=new Object();
			this.cajadiariacajasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cajadiariacajaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cajadiariacajaDataAccess.setConnexionType(this.connexionType);
			this.cajadiariacajaDataAccess.setParameterDbType(this.parameterDbType);
			this.cajadiariacajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CajaDiariaCaja getCajaDiariaCaja() throws Exception {	
		CajaDiariaCajaLogicAdditional.checkCajaDiariaCajaToGet(cajadiariacaja,this.datosCliente,this.arrDatoGeneral);
		CajaDiariaCajaLogicAdditional.updateCajaDiariaCajaToGet(cajadiariacaja,this.arrDatoGeneral);
		
		return cajadiariacaja;
	}
		
	public void setCajaDiariaCaja(CajaDiariaCaja newCajaDiariaCaja) {
		this.cajadiariacaja = newCajaDiariaCaja;
	}
	
	public List<CajaDiariaCaja> getCajaDiariaCajas() throws Exception {		
		this.quitarCajaDiariaCajasNulos();
		
		CajaDiariaCajaLogicAdditional.checkCajaDiariaCajaToGets(cajadiariacajas,this.datosCliente,this.arrDatoGeneral);
		
		for (CajaDiariaCaja cajadiariacajaLocal: cajadiariacajas ) {
			CajaDiariaCajaLogicAdditional.updateCajaDiariaCajaToGet(cajadiariacajaLocal,this.arrDatoGeneral);
		}
		
		return cajadiariacajas;
	}
	
	public void setCajaDiariaCajas(List<CajaDiariaCaja> newCajaDiariaCajas) {
		this.cajadiariacajas = newCajaDiariaCajas;
	}
	
	public Object getCajaDiariaCajaObject() {	
		//this.cajadiariacajaObject=this.cajadiariacajaDataAccess.getEntityObject();
		return this.cajadiariacajaObject;
	}
		
	public void setCajaDiariaCajaObject(Object newCajaDiariaCajaObject) {
		this.cajadiariacajaObject = newCajaDiariaCajaObject;
	}
	
	public List<Object> getCajaDiariaCajasObject() {		
		//this.cajadiariacajasObject=this.cajadiariacajaDataAccess.getEntitiesObject();
		return this.cajadiariacajasObject;
	}
		
	public void setCajaDiariaCajasObject(List<Object> newCajaDiariaCajasObject) {
		this.cajadiariacajasObject = newCajaDiariaCajasObject;
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
		cajadiariacajas = new  ArrayList<CajaDiariaCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CajaDiariaCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariacajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cajadiariacajas = new  ArrayList<CajaDiariaCaja>();
		  		  
        try {
			//CajaDiariaCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariacajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajadiariacajas = new  ArrayList<CajaDiariaCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CajaDiariaCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariacajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cajadiariacajas = new  ArrayList<CajaDiariaCaja>();
		  		  
        try {
			//CajaDiariaCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariacajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cajadiariacajas = new  ArrayList<CajaDiariaCaja>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CajaDiariaCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariacajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cajadiariacajas = new  ArrayList<CajaDiariaCaja>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CajaDiariaCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariacajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CajaDiariaCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaDiariaCaja> entities = new  ArrayList<CajaDiariaCaja>();
		CajaDiariaCaja entity = new CajaDiariaCaja();		  
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
	
	public  List<CajaDiariaCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaDiariaCaja> entities = new  ArrayList<CajaDiariaCaja>();
		CajaDiariaCaja entity = new CajaDiariaCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaDiariaCaja();
				
				
      	    	entity=CajaDiariaCajaLogic.getEntityCajaDiariaCaja("",entity,resultSet);
      	    	
				//entity.setCajaDiariaCajaOriginal( new CajaDiariaCaja());
      	    	//entity.setCajaDiariaCajaOriginal(super.getEntity("",entity.getCajaDiariaCajaOriginal(),resultSet,CajaDiariaCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaDiariaCajaOriginal(CajaDiariaCajaDataAccess.getEntityCajaDiariaCaja("",entity.getCajaDiariaCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CajaDiariaCaja> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaDiariaCaja> entities = new  ArrayList<CajaDiariaCaja>();
		CajaDiariaCaja entity = new CajaDiariaCaja();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CajaDiariaCaja.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CajaDiariaCaja>((List<CajaDiariaCaja>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCajaDiariaCajasOriginal(entities);
			
			}  else {
				this.cajadiariacajasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CajaDiariaCajaConstantesFunciones.quitarEspaciosCajaDiariaCajas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CajaDiariaCaja getEntityCajaDiariaCaja(String strPrefijo,CajaDiariaCaja entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_caja(resultSet.getLong(strPrefijo+CajaDiariaCajaConstantesFunciones.IDCAJA));
			entity.setid_cliente(resultSet.getLong(strPrefijo+CajaDiariaCajaConstantesFunciones.IDCLIENTE));
			entity.setnombre_caja(resultSet.getString(strPrefijo+CajaDiariaCajaConstantesFunciones.NOMBRECAJA));
			entity.setsecuencial(resultSet.getString(strPrefijo+CajaDiariaCajaConstantesFunciones.SECUENCIAL));
			entity.setcodigo_cliente(resultSet.getString(strPrefijo+CajaDiariaCajaConstantesFunciones.CODIGOCLIENTE));
			entity.setnombre_cliente(resultSet.getString(strPrefijo+CajaDiariaCajaConstantesFunciones.NOMBRECLIENTE));
			entity.setsubtotal(resultSet.getDouble(strPrefijo+CajaDiariaCajaConstantesFunciones.SUBTOTAL));
			entity.setiva(resultSet.getDouble(strPrefijo+CajaDiariaCajaConstantesFunciones.IVA));
			entity.setdescuento(resultSet.getDouble(strPrefijo+CajaDiariaCajaConstantesFunciones.DESCUENTO));
			entity.setfinanciamiento(resultSet.getDouble(strPrefijo+CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO));
			entity.setflete(resultSet.getDouble(strPrefijo+CajaDiariaCajaConstantesFunciones.FLETE));
			entity.setice(resultSet.getDouble(strPrefijo+CajaDiariaCajaConstantesFunciones.ICE));
			entity.settotal(resultSet.getDouble(strPrefijo+CajaDiariaCajaConstantesFunciones.TOTAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CajaDiariaCaja getEntityCajaDiariaCaja(String strPrefijo,CajaDiariaCaja entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CajaDiariaCaja.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CajaDiariaCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CajaDiariaCajaLogic.setFieldReflectionCajaDiariaCaja(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCajaDiariaCaja(Field field,String strPrefijo,String sColumn,CajaDiariaCaja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CajaDiariaCajaConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.NOMBRECAJA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.CODIGOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaCajaConstantesFunciones.TOTAL:
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
	
	public void quitarCajaDiariaCajasNulos() throws Exception {				
		
		List<CajaDiariaCaja> cajadiariacajasAux= new ArrayList<CajaDiariaCaja>();
		
		for(CajaDiariaCaja cajadiariacaja:cajadiariacajas) {
			if(cajadiariacaja!=null) {
				cajadiariacajasAux.add(cajadiariacaja);
			}
		}
		
		cajadiariacajas=cajadiariacajasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CajaDiariaCaja> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaDiariaCaja> entities = new  ArrayList<CajaDiariaCaja>();
		CajaDiariaCaja entity = new CajaDiariaCaja();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CajaDiariaCaja>((List<CajaDiariaCaja>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCajaDiariaCajasOriginal(entities);
			
			}  else {
				this.cajadiariacajasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CajaDiariaCajaConstantesFunciones.quitarEspaciosCajaDiariaCajas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cajadiariacajas = new  ArrayList<CajaDiariaCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CajaDiariaCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariacajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cajadiariacajas = new  ArrayList<CajaDiariaCaja>();
		  		  
        try {
			//CajaDiariaCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariacajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CajaDiariaCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaDiariaCaja> entities = new  ArrayList<CajaDiariaCaja>();
		CajaDiariaCaja entity = new CajaDiariaCaja();		  
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
	
	public  List<CajaDiariaCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaDiariaCaja> entities = new  ArrayList<CajaDiariaCaja>();
		CajaDiariaCaja entity = new CajaDiariaCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaDiariaCaja();
				
				if(conMapGenerico) {
					entity.setMapCajaDiariaCaja( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCajaDiariaCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaDiariaCajaDataAccess.ISWITHSCHEMA);         		
					entity=CajaDiariaCajaLogic.getEntityCajaDiariaCaja("",entity,resultSet,listColumns);
					
					////entity.setCajaDiariaCajaOriginal( new CajaDiariaCaja());
					////entity.setCajaDiariaCajaOriginal(super.getEntity("",entity.getCajaDiariaCajaOriginal(),resultSet,CajaDiariaCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaDiariaCajaOriginal(CajaDiariaCajaDataAccess.getEntityCajaDiariaCaja("",entity.getCajaDiariaCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CajaDiariaCaja relcajadiariacaja)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcajadiariacaja.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Caja getCaja(Connexion connexion,CajaDiariaCaja relcajadiariacaja)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);
			cajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			caja=cajaDataAccess.getEntity(connexion,relcajadiariacaja.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}

	public Cliente getCliente(Connexion connexion,CajaDiariaCaja relcajadiariacaja)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relcajadiariacaja.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


	
	
	public void getCajaDiariaCajasBusquedaCajaDiariaCajaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_caja,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//CajaDiariaCajaLogic cajadiariacajaLogic=new CajaDiariaCajaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CajaDiariaCajaLogic.GetSelecSqlCajaDiariaCaja(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_caja,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cajadiariacajas=this.getCajaDiariaCajas();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCajaDiariaCajasBusquedaCajaDiariaCaja(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_caja,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//CajaDiariaCajaLogic cajadiariacajaLogic=new CajaDiariaCajaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CajaDiariaCajaLogic.GetSelecSqlCajaDiariaCaja(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_caja,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cajadiariacajas=this.getCajaDiariaCajas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCajaDiariaCaja(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_caja,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CajaDiariaCaja_Postgres.sql");
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
				

				if(id_caja!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_caja = "+id_caja.toString();
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
	
	
	public void deepLoad(CajaDiariaCaja cajadiariacaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CajaDiariaCajaLogicAdditional.updateCajaDiariaCajaToGet(cajadiariacaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajadiariacaja.setEmpresa(cajadiariacajaDataAccess.getEmpresa(connexion,cajadiariacaja));
		cajadiariacaja.setCaja(cajadiariacajaDataAccess.getCaja(connexion,cajadiariacaja));
		cajadiariacaja.setCliente(cajadiariacajaDataAccess.getCliente(connexion,cajadiariacaja));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajadiariacaja.setEmpresa(cajadiariacajaDataAccess.getEmpresa(connexion,cajadiariacaja));
			}

			if(clas.clas.equals(Caja.class)) {
				cajadiariacaja.setCaja(cajadiariacajaDataAccess.getCaja(connexion,cajadiariacaja));
			}

			if(clas.clas.equals(Cliente.class)) {
				cajadiariacaja.setCliente(cajadiariacajaDataAccess.getCliente(connexion,cajadiariacaja));
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
			cajadiariacaja.setEmpresa(cajadiariacajaDataAccess.getEmpresa(connexion,cajadiariacaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariacaja.setCaja(cajadiariacajaDataAccess.getCaja(connexion,cajadiariacaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariacaja.setCliente(cajadiariacajaDataAccess.getCliente(connexion,cajadiariacaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajadiariacaja.setEmpresa(cajadiariacajaDataAccess.getEmpresa(connexion,cajadiariacaja));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajadiariacaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		cajadiariacaja.setCaja(cajadiariacajaDataAccess.getCaja(connexion,cajadiariacaja));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajadiariacaja.getCaja(),isDeep,deepLoadType,clases);
				
		cajadiariacaja.setCliente(cajadiariacajaDataAccess.getCliente(connexion,cajadiariacaja));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cajadiariacaja.getCliente(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajadiariacaja.setEmpresa(cajadiariacajaDataAccess.getEmpresa(connexion,cajadiariacaja));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cajadiariacaja.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Caja.class)) {
				cajadiariacaja.setCaja(cajadiariacajaDataAccess.getCaja(connexion,cajadiariacaja));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(cajadiariacaja.getCaja(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				cajadiariacaja.setCliente(cajadiariacajaDataAccess.getCliente(connexion,cajadiariacaja));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cajadiariacaja.getCliente(),isDeep,deepLoadType,clases);				
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
			cajadiariacaja.setEmpresa(cajadiariacajaDataAccess.getEmpresa(connexion,cajadiariacaja));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cajadiariacaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariacaja.setCaja(cajadiariacajaDataAccess.getCaja(connexion,cajadiariacaja));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(cajadiariacaja.getCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariacaja.setCliente(cajadiariacajaDataAccess.getCliente(connexion,cajadiariacaja));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cajadiariacaja.getCliente(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cajadiariacaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaDiariaCajaConstantesFunciones.refrescarForeignKeysDescripcionesCajaDiariaCaja(cajadiariacaja);
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
			this.deepLoad(this.cajadiariacaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaDiariaCajaConstantesFunciones.refrescarForeignKeysDescripcionesCajaDiariaCaja(this.cajadiariacaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cajadiariacajas!=null) {
				for(CajaDiariaCaja cajadiariacaja:cajadiariacajas) {
					this.deepLoad(cajadiariacaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CajaDiariaCajaConstantesFunciones.refrescarForeignKeysDescripcionesCajaDiariaCaja(cajadiariacajas);
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
			if(cajadiariacajas!=null) {
				for(CajaDiariaCaja cajadiariacaja:cajadiariacajas) {
					this.deepLoad(cajadiariacaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CajaDiariaCajaConstantesFunciones.refrescarForeignKeysDescripcionesCajaDiariaCaja(cajadiariacajas);
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
	
	public CajaDiariaCajaParameterReturnGeneral procesarAccionCajaDiariaCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaDiariaCaja> cajadiariacajas,CajaDiariaCajaParameterReturnGeneral cajadiariacajaParameterGeneral)throws Exception {
		 try {	
			CajaDiariaCajaParameterReturnGeneral cajadiariacajaReturnGeneral=new CajaDiariaCajaParameterReturnGeneral();
	
			CajaDiariaCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajadiariacajas,cajadiariacajaParameterGeneral,cajadiariacajaReturnGeneral);
			
			return cajadiariacajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaDiariaCajaParameterReturnGeneral procesarAccionCajaDiariaCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaDiariaCaja> cajadiariacajas,CajaDiariaCajaParameterReturnGeneral cajadiariacajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CajaDiariaCajaParameterReturnGeneral cajadiariacajaReturnGeneral=new CajaDiariaCajaParameterReturnGeneral();
	
			CajaDiariaCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajadiariacajas,cajadiariacajaParameterGeneral,cajadiariacajaReturnGeneral);
			
			this.connexion.commit();
			
			return cajadiariacajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

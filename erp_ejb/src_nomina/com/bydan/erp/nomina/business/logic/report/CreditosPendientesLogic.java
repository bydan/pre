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
package com.bydan.erp.nomina.business.logic.report;

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

import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;
import com.bydan.erp.nomina.util.report.CreditosPendientesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.CreditosPendientesParameterGeneral;
import com.bydan.erp.nomina.util.report.CreditosPendientesConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.CreditosPendientes;

import com.bydan.erp.nomina.business.logic.report.CreditosPendientesLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CreditosPendientesLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CreditosPendientesLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CreditosPendientesLogic creditospendientesDataAccess; 		
	protected CreditosPendientes creditospendientes;
	protected List<CreditosPendientes> creditospendientess;
	protected Object creditospendientesObject;	
	protected List<Object> creditospendientessObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CreditosPendientesLogic()throws SQLException,Exception {
		try	{
			this.creditospendientess= new ArrayList<CreditosPendientes>();
			this.creditospendientes= new CreditosPendientes();
			this.creditospendientesObject=new Object();
			this.creditospendientessObject=new ArrayList<Object>();
			
			this.creditospendientesDataAccess=this;
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
			this.creditospendientesDataAccess.setConnexionType(this.connexionType);
			this.creditospendientesDataAccess.setParameterDbType(this.parameterDbType);
			this.creditospendientesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CreditosPendientesLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.creditospendientess= new ArrayList<CreditosPendientes>();
			this.creditospendientes= new CreditosPendientes();
			this.creditospendientesObject=new Object();
			this.creditospendientessObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.creditospendientesDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.creditospendientesDataAccess.setConnexionType(this.connexionType);
			this.creditospendientesDataAccess.setParameterDbType(this.parameterDbType);
			this.creditospendientesDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CreditosPendientes getCreditosPendientes() throws Exception {	
		CreditosPendientesLogicAdditional.checkCreditosPendientesToGet(creditospendientes,this.datosCliente,this.arrDatoGeneral);
		CreditosPendientesLogicAdditional.updateCreditosPendientesToGet(creditospendientes,this.arrDatoGeneral);
		
		return creditospendientes;
	}
		
	public void setCreditosPendientes(CreditosPendientes newCreditosPendientes) {
		this.creditospendientes = newCreditosPendientes;
	}
	
	public List<CreditosPendientes> getCreditosPendientess() throws Exception {		
		this.quitarCreditosPendientessNulos();
		
		CreditosPendientesLogicAdditional.checkCreditosPendientesToGets(creditospendientess,this.datosCliente,this.arrDatoGeneral);
		
		for (CreditosPendientes creditospendientesLocal: creditospendientess ) {
			CreditosPendientesLogicAdditional.updateCreditosPendientesToGet(creditospendientesLocal,this.arrDatoGeneral);
		}
		
		return creditospendientess;
	}
	
	public void setCreditosPendientess(List<CreditosPendientes> newCreditosPendientess) {
		this.creditospendientess = newCreditosPendientess;
	}
	
	public Object getCreditosPendientesObject() {	
		//this.creditospendientesObject=this.creditospendientesDataAccess.getEntityObject();
		return this.creditospendientesObject;
	}
		
	public void setCreditosPendientesObject(Object newCreditosPendientesObject) {
		this.creditospendientesObject = newCreditosPendientesObject;
	}
	
	public List<Object> getCreditosPendientessObject() {		
		//this.creditospendientessObject=this.creditospendientesDataAccess.getEntitiesObject();
		return this.creditospendientessObject;
	}
		
	public void setCreditosPendientessObject(List<Object> newCreditosPendientessObject) {
		this.creditospendientessObject = newCreditosPendientessObject;
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
		creditospendientess = new  ArrayList<CreditosPendientes>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CreditosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		creditospendientess = new  ArrayList<CreditosPendientes>();
		  		  
        try {
			//CreditosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		creditospendientess = new  ArrayList<CreditosPendientes>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CreditosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		creditospendientess = new  ArrayList<CreditosPendientes>();
		  		  
        try {
			//CreditosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		creditospendientess = new  ArrayList<CreditosPendientes>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CreditosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		creditospendientess = new  ArrayList<CreditosPendientes>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CreditosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CreditosPendientes> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CreditosPendientes> entities = new  ArrayList<CreditosPendientes>();
		CreditosPendientes entity = new CreditosPendientes();		  
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
	
	public  List<CreditosPendientes> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CreditosPendientes> entities = new  ArrayList<CreditosPendientes>();
		CreditosPendientes entity = new CreditosPendientes();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CreditosPendientes();
				
				
      	    	entity=CreditosPendientesLogic.getEntityCreditosPendientes("",entity,resultSet);
      	    	
				//entity.setCreditosPendientesOriginal( new CreditosPendientes());
      	    	//entity.setCreditosPendientesOriginal(super.getEntity("",entity.getCreditosPendientesOriginal(),resultSet,CreditosPendientesDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCreditosPendientesOriginal(CreditosPendientesDataAccess.getEntityCreditosPendientes("",entity.getCreditosPendientesOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CreditosPendientes> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CreditosPendientes> entities = new  ArrayList<CreditosPendientes>();
		CreditosPendientes entity = new CreditosPendientes();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CreditosPendientes.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CreditosPendientes>((List<CreditosPendientes>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCreditosPendientessOriginal(entities);
			
			}  else {
				this.creditospendientessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CreditosPendientesConstantesFunciones.quitarEspaciosCreditosPendientess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CreditosPendientes getEntityCreditosPendientes(String strPrefijo,CreditosPendientes entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+CreditosPendientesConstantesFunciones.CODIGO));
			entity.setnombre_completo(resultSet.getString(strPrefijo+CreditosPendientesConstantesFunciones.NOMBRECOMPLETO));
			entity.setcodigo_tipo_prestamo(resultSet.getString(strPrefijo+CreditosPendientesConstantesFunciones.CODIGOTIPOPRESTAMO));
			entity.setcodigo_prestamo(resultSet.getString(strPrefijo+CreditosPendientesConstantesFunciones.CODIGOPRESTAMO));
			entity.setnumero(resultSet.getInt(strPrefijo+CreditosPendientesConstantesFunciones.NUMERO));
			entity.setmonto_capital(resultSet.getDouble(strPrefijo+CreditosPendientesConstantesFunciones.MONTOCAPITAL));
			entity.setmonto_interes(resultSet.getDouble(strPrefijo+CreditosPendientesConstantesFunciones.MONTOINTERES));
			entity.setvalor(resultSet.getDouble(strPrefijo+CreditosPendientesConstantesFunciones.VALOR));
			entity.setsaldo(resultSet.getDouble(strPrefijo+CreditosPendientesConstantesFunciones.SALDO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CreditosPendientes getEntityCreditosPendientes(String strPrefijo,CreditosPendientes entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CreditosPendientes.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CreditosPendientes.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CreditosPendientesLogic.setFieldReflectionCreditosPendientes(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCreditosPendientes(Field field,String strPrefijo,String sColumn,CreditosPendientes entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CreditosPendientesConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CreditosPendientesConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CreditosPendientesConstantesFunciones.CODIGOTIPOPRESTAMO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CreditosPendientesConstantesFunciones.CODIGOPRESTAMO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CreditosPendientesConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CreditosPendientesConstantesFunciones.MONTOCAPITAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CreditosPendientesConstantesFunciones.MONTOINTERES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CreditosPendientesConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CreditosPendientesConstantesFunciones.SALDO:
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
	
	public void quitarCreditosPendientessNulos() throws Exception {				
		
		List<CreditosPendientes> creditospendientessAux= new ArrayList<CreditosPendientes>();
		
		for(CreditosPendientes creditospendientes:creditospendientess) {
			if(creditospendientes!=null) {
				creditospendientessAux.add(creditospendientes);
			}
		}
		
		creditospendientess=creditospendientessAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CreditosPendientes> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CreditosPendientes> entities = new  ArrayList<CreditosPendientes>();
		CreditosPendientes entity = new CreditosPendientes();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CreditosPendientes>((List<CreditosPendientes>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCreditosPendientessOriginal(entities);
			
			}  else {
				this.creditospendientessObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CreditosPendientesConstantesFunciones.quitarEspaciosCreditosPendientess(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		creditospendientess = new  ArrayList<CreditosPendientes>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CreditosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		creditospendientess = new  ArrayList<CreditosPendientes>();
		  		  
        try {
			//CreditosPendientesLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			creditospendientess=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CreditosPendientes> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CreditosPendientes> entities = new  ArrayList<CreditosPendientes>();
		CreditosPendientes entity = new CreditosPendientes();		  
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
	
	public  List<CreditosPendientes> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CreditosPendientes> entities = new  ArrayList<CreditosPendientes>();
		CreditosPendientes entity = new CreditosPendientes();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CreditosPendientes();
				
				if(conMapGenerico) {
					entity.setMapCreditosPendientes( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCreditosPendientes().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CreditosPendientesDataAccess.ISWITHSCHEMA);         		
					entity=CreditosPendientesLogic.getEntityCreditosPendientes("",entity,resultSet,listColumns);
					
					////entity.setCreditosPendientesOriginal( new CreditosPendientes());
					////entity.setCreditosPendientesOriginal(super.getEntity("",entity.getCreditosPendientesOriginal(),resultSet,CreditosPendientesDataAccess.ISWITHSCHEMA));         		
					////entity.setCreditosPendientesOriginal(CreditosPendientesDataAccess.getEntityCreditosPendientes("",entity.getCreditosPendientesOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Cargo getCargo(Connexion connexion,CreditosPendientes relcreditospendientes)throws SQLException,Exception {

		Cargo cargo= new Cargo();

		try {
			CargoDataAccess cargoDataAccess=new CargoDataAccess();

			cargoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cargoDataAccess.setConnexionType(this.connexionType);
			cargoDataAccess.setParameterDbType(this.parameterDbType);
			cargoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cargo=cargoDataAccess.getEntity(connexion,relcreditospendientes.getid_cargo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargo;

	}

	public Estructura getEstructura(Connexion connexion,CreditosPendientes relcreditospendientes)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuraDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			estructura=estructuraDataAccess.getEntity(connexion,relcreditospendientes.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empresa getEmpresa(Connexion connexion,CreditosPendientes relcreditospendientes)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcreditospendientes.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,CreditosPendientes relcreditospendientes)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);
			empleadoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empleado=empleadoDataAccess.getEntity(connexion,relcreditospendientes.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


	
	
	public void getCreditosPendientessBusquedaCreditosPendientesWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cargo,Long id_estructura,Long id_empleado,Date fecha_vencimiento_desde,Date fecha_vencimiento_hasta)throws Exception {
		try {
			//CreditosPendientesLogic creditospendientesLogic=new CreditosPendientesLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CreditosPendientesLogic.GetSelecSqlCreditosPendientes(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cargo,id_estructura,id_empleado,fecha_vencimiento_desde,fecha_vencimiento_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.creditospendientess=this.getCreditosPendientess();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCreditosPendientessBusquedaCreditosPendientes(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cargo,Long id_estructura,Long id_empleado,Date fecha_vencimiento_desde,Date fecha_vencimiento_hasta)throws Exception {
		try {
			//CreditosPendientesLogic creditospendientesLogic=new CreditosPendientesLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CreditosPendientesLogic.GetSelecSqlCreditosPendientes(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_cargo,id_estructura,id_empleado,fecha_vencimiento_desde,fecha_vencimiento_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.creditospendientess=this.getCreditosPendientess();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCreditosPendientes(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_cargo,Long id_estructura,Long id_empleado,Date fecha_vencimiento_desde,Date fecha_vencimiento_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CreditosPendientes_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" e.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" e.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_cargo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.id_cargo = "+id_cargo.toString();
					existeWhere=true;
				}

				if(id_estructura!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" e.id_estructura = "+id_estructura.toString();
					existeWhere=true;
				}

				if(id_empleado!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_empleado = "+id_empleado.toString();
					existeWhere=true;
				}

				if(fecha_vencimiento_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.fecha_vencimiento between "+"'"+Funciones2.getStringPostgresDate(fecha_vencimiento_desde)+"'";
					existeWhere=true;
				}

				if(fecha_vencimiento_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_vencimiento_hasta)+"'";
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
	
	
	public void deepLoad(CreditosPendientes creditospendientes,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CreditosPendientesLogicAdditional.updateCreditosPendientesToGet(creditospendientes,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		creditospendientes.setCargo(creditospendientesDataAccess.getCargo(connexion,creditospendientes));
		creditospendientes.setEstructura(creditospendientesDataAccess.getEstructura(connexion,creditospendientes));
		creditospendientes.setEmpresa(creditospendientesDataAccess.getEmpresa(connexion,creditospendientes));
		creditospendientes.setEmpleado(creditospendientesDataAccess.getEmpleado(connexion,creditospendientes));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				creditospendientes.setCargo(creditospendientesDataAccess.getCargo(connexion,creditospendientes));
			}

			if(clas.clas.equals(Estructura.class)) {
				creditospendientes.setEstructura(creditospendientesDataAccess.getEstructura(connexion,creditospendientes));
			}

			if(clas.clas.equals(Empresa.class)) {
				creditospendientes.setEmpresa(creditospendientesDataAccess.getEmpresa(connexion,creditospendientes));
			}

			if(clas.clas.equals(Empleado.class)) {
				creditospendientes.setEmpleado(creditospendientesDataAccess.getEmpleado(connexion,creditospendientes));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditospendientes.setCargo(creditospendientesDataAccess.getCargo(connexion,creditospendientes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditospendientes.setEstructura(creditospendientesDataAccess.getEstructura(connexion,creditospendientes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditospendientes.setEmpresa(creditospendientesDataAccess.getEmpresa(connexion,creditospendientes));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditospendientes.setEmpleado(creditospendientesDataAccess.getEmpleado(connexion,creditospendientes));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		creditospendientes.setCargo(creditospendientesDataAccess.getCargo(connexion,creditospendientes));
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(creditospendientes.getCargo(),isDeep,deepLoadType,clases);
				
		creditospendientes.setEstructura(creditospendientesDataAccess.getEstructura(connexion,creditospendientes));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(creditospendientes.getEstructura(),isDeep,deepLoadType,clases);
				
		creditospendientes.setEmpresa(creditospendientesDataAccess.getEmpresa(connexion,creditospendientes));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(creditospendientes.getEmpresa(),isDeep,deepLoadType,clases);
				
		creditospendientes.setEmpleado(creditospendientesDataAccess.getEmpleado(connexion,creditospendientes));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(creditospendientes.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				creditospendientes.setCargo(creditospendientesDataAccess.getCargo(connexion,creditospendientes));
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepLoad(creditospendientes.getCargo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Estructura.class)) {
				creditospendientes.setEstructura(creditospendientesDataAccess.getEstructura(connexion,creditospendientes));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(creditospendientes.getEstructura(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				creditospendientes.setEmpresa(creditospendientesDataAccess.getEmpresa(connexion,creditospendientes));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(creditospendientes.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empleado.class)) {
				creditospendientes.setEmpleado(creditospendientesDataAccess.getEmpleado(connexion,creditospendientes));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(creditospendientes.getEmpleado(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditospendientes.setCargo(creditospendientesDataAccess.getCargo(connexion,creditospendientes));
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargoLogic.deepLoad(creditospendientes.getCargo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditospendientes.setEstructura(creditospendientesDataAccess.getEstructura(connexion,creditospendientes));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(creditospendientes.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditospendientes.setEmpresa(creditospendientesDataAccess.getEmpresa(connexion,creditospendientes));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(creditospendientes.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			creditospendientes.setEmpleado(creditospendientesDataAccess.getEmpleado(connexion,creditospendientes));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(creditospendientes.getEmpleado(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(creditospendientes,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CreditosPendientesConstantesFunciones.refrescarForeignKeysDescripcionesCreditosPendientes(creditospendientes);
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
			this.deepLoad(this.creditospendientes,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CreditosPendientesConstantesFunciones.refrescarForeignKeysDescripcionesCreditosPendientes(this.creditospendientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(creditospendientess!=null) {
				for(CreditosPendientes creditospendientes:creditospendientess) {
					this.deepLoad(creditospendientes,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CreditosPendientesConstantesFunciones.refrescarForeignKeysDescripcionesCreditosPendientes(creditospendientess);
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
			if(creditospendientess!=null) {
				for(CreditosPendientes creditospendientes:creditospendientess) {
					this.deepLoad(creditospendientes,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CreditosPendientesConstantesFunciones.refrescarForeignKeysDescripcionesCreditosPendientes(creditospendientess);
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
	
	public CreditosPendientesParameterReturnGeneral procesarAccionCreditosPendientess(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CreditosPendientes> creditospendientess,CreditosPendientesParameterReturnGeneral creditospendientesParameterGeneral)throws Exception {
		 try {	
			CreditosPendientesParameterReturnGeneral creditospendientesReturnGeneral=new CreditosPendientesParameterReturnGeneral();
	
			CreditosPendientesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,creditospendientess,creditospendientesParameterGeneral,creditospendientesReturnGeneral);
			
			return creditospendientesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CreditosPendientesParameterReturnGeneral procesarAccionCreditosPendientessWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CreditosPendientes> creditospendientess,CreditosPendientesParameterReturnGeneral creditospendientesParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CreditosPendientesParameterReturnGeneral creditospendientesReturnGeneral=new CreditosPendientesParameterReturnGeneral();
	
			CreditosPendientesLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,creditospendientess,creditospendientesParameterGeneral,creditospendientesReturnGeneral);
			
			this.connexion.commit();
			
			return creditospendientesReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

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
package com.bydan.erp.tesoreria.business.logic.report;

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

import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.resources.general.AuxiliarGeneral;
import com.bydan.erp.tesoreria.util.report.BeneficiariosPagosCobrosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.BeneficiariosPagosCobrosParameterGeneral;
import com.bydan.erp.tesoreria.util.report.BeneficiariosPagosCobrosConstantesFunciones;
import com.bydan.erp.tesoreria.business.entity.report.BeneficiariosPagosCobros;

import com.bydan.erp.tesoreria.business.logic.report.BeneficiariosPagosCobrosLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class BeneficiariosPagosCobrosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(BeneficiariosPagosCobrosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected BeneficiariosPagosCobrosLogic beneficiariospagoscobrosDataAccess; 		
	protected BeneficiariosPagosCobros beneficiariospagoscobros;
	protected List<BeneficiariosPagosCobros> beneficiariospagoscobross;
	protected Object beneficiariospagoscobrosObject;	
	protected List<Object> beneficiariospagoscobrossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  BeneficiariosPagosCobrosLogic()throws SQLException,Exception {
		try	{
			this.beneficiariospagoscobross= new ArrayList<BeneficiariosPagosCobros>();
			this.beneficiariospagoscobros= new BeneficiariosPagosCobros();
			this.beneficiariospagoscobrosObject=new Object();
			this.beneficiariospagoscobrossObject=new ArrayList<Object>();
			
			this.beneficiariospagoscobrosDataAccess=this;
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
			this.beneficiariospagoscobrosDataAccess.setConnexionType(this.connexionType);
			this.beneficiariospagoscobrosDataAccess.setParameterDbType(this.parameterDbType);
			this.beneficiariospagoscobrosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BeneficiariosPagosCobrosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.beneficiariospagoscobross= new ArrayList<BeneficiariosPagosCobros>();
			this.beneficiariospagoscobros= new BeneficiariosPagosCobros();
			this.beneficiariospagoscobrosObject=new Object();
			this.beneficiariospagoscobrossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.beneficiariospagoscobrosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.beneficiariospagoscobrosDataAccess.setConnexionType(this.connexionType);
			this.beneficiariospagoscobrosDataAccess.setParameterDbType(this.parameterDbType);
			this.beneficiariospagoscobrosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public BeneficiariosPagosCobros getBeneficiariosPagosCobros() throws Exception {	
		BeneficiariosPagosCobrosLogicAdditional.checkBeneficiariosPagosCobrosToGet(beneficiariospagoscobros,this.datosCliente,this.arrDatoGeneral);
		BeneficiariosPagosCobrosLogicAdditional.updateBeneficiariosPagosCobrosToGet(beneficiariospagoscobros,this.arrDatoGeneral);
		
		return beneficiariospagoscobros;
	}
		
	public void setBeneficiariosPagosCobros(BeneficiariosPagosCobros newBeneficiariosPagosCobros) {
		this.beneficiariospagoscobros = newBeneficiariosPagosCobros;
	}
	
	public List<BeneficiariosPagosCobros> getBeneficiariosPagosCobross() throws Exception {		
		this.quitarBeneficiariosPagosCobrossNulos();
		
		BeneficiariosPagosCobrosLogicAdditional.checkBeneficiariosPagosCobrosToGets(beneficiariospagoscobross,this.datosCliente,this.arrDatoGeneral);
		
		for (BeneficiariosPagosCobros beneficiariospagoscobrosLocal: beneficiariospagoscobross ) {
			BeneficiariosPagosCobrosLogicAdditional.updateBeneficiariosPagosCobrosToGet(beneficiariospagoscobrosLocal,this.arrDatoGeneral);
		}
		
		return beneficiariospagoscobross;
	}
	
	public void setBeneficiariosPagosCobross(List<BeneficiariosPagosCobros> newBeneficiariosPagosCobross) {
		this.beneficiariospagoscobross = newBeneficiariosPagosCobross;
	}
	
	public Object getBeneficiariosPagosCobrosObject() {	
		//this.beneficiariospagoscobrosObject=this.beneficiariospagoscobrosDataAccess.getEntityObject();
		return this.beneficiariospagoscobrosObject;
	}
		
	public void setBeneficiariosPagosCobrosObject(Object newBeneficiariosPagosCobrosObject) {
		this.beneficiariospagoscobrosObject = newBeneficiariosPagosCobrosObject;
	}
	
	public List<Object> getBeneficiariosPagosCobrossObject() {		
		//this.beneficiariospagoscobrossObject=this.beneficiariospagoscobrosDataAccess.getEntitiesObject();
		return this.beneficiariospagoscobrossObject;
	}
		
	public void setBeneficiariosPagosCobrossObject(List<Object> newBeneficiariosPagosCobrossObject) {
		this.beneficiariospagoscobrossObject = newBeneficiariosPagosCobrossObject;
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
		beneficiariospagoscobross = new  ArrayList<BeneficiariosPagosCobros>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//BeneficiariosPagosCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			beneficiariospagoscobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		beneficiariospagoscobross = new  ArrayList<BeneficiariosPagosCobros>();
		  		  
        try {
			//BeneficiariosPagosCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			beneficiariospagoscobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		beneficiariospagoscobross = new  ArrayList<BeneficiariosPagosCobros>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//BeneficiariosPagosCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			beneficiariospagoscobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		beneficiariospagoscobross = new  ArrayList<BeneficiariosPagosCobros>();
		  		  
        try {
			//BeneficiariosPagosCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			beneficiariospagoscobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		beneficiariospagoscobross = new  ArrayList<BeneficiariosPagosCobros>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//BeneficiariosPagosCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			beneficiariospagoscobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		beneficiariospagoscobross = new  ArrayList<BeneficiariosPagosCobros>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//BeneficiariosPagosCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			beneficiariospagoscobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<BeneficiariosPagosCobros> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BeneficiariosPagosCobros> entities = new  ArrayList<BeneficiariosPagosCobros>();
		BeneficiariosPagosCobros entity = new BeneficiariosPagosCobros();		  
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
	
	public  List<BeneficiariosPagosCobros> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BeneficiariosPagosCobros> entities = new  ArrayList<BeneficiariosPagosCobros>();
		BeneficiariosPagosCobros entity = new BeneficiariosPagosCobros();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BeneficiariosPagosCobros();
				
				
      	    	entity=BeneficiariosPagosCobrosLogic.getEntityBeneficiariosPagosCobros("",entity,resultSet);
      	    	
				//entity.setBeneficiariosPagosCobrosOriginal( new BeneficiariosPagosCobros());
      	    	//entity.setBeneficiariosPagosCobrosOriginal(super.getEntity("",entity.getBeneficiariosPagosCobrosOriginal(),resultSet,BeneficiariosPagosCobrosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBeneficiariosPagosCobrosOriginal(BeneficiariosPagosCobrosDataAccess.getEntityBeneficiariosPagosCobros("",entity.getBeneficiariosPagosCobrosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<BeneficiariosPagosCobros> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BeneficiariosPagosCobros> entities = new  ArrayList<BeneficiariosPagosCobros>();
		BeneficiariosPagosCobros entity = new BeneficiariosPagosCobros();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,BeneficiariosPagosCobros.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<BeneficiariosPagosCobros>((List<BeneficiariosPagosCobros>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setBeneficiariosPagosCobrossOriginal(entities);
			
			}  else {
				this.beneficiariospagoscobrossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//BeneficiariosPagosCobrosConstantesFunciones.quitarEspaciosBeneficiariosPagosCobross(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static BeneficiariosPagosCobros getEntityBeneficiariosPagosCobros(String strPrefijo,BeneficiariosPagosCobros entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_cuenta_contable(resultSet.getString(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.CODIGOCUENTACONTABLE));
			entity.setnombre_cuenta_contable(resultSet.getString(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.NOMBRECUENTACONTABLE));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.NUMEROMAYOR));
			entity.setnumero_cheque(resultSet.getString(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.NUMEROCHEQUE));
			entity.setbeneficiario(resultSet.getString(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIO));
			entity.setdebito_local(resultSet.getDouble(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL));
			entity.setcredito_local(resultSet.getDouble(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL));
			entity.setdetalle(resultSet.getString(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.DETALLE));
			entity.settipo_movimiento(resultSet.getString(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.TIPOMOVIMIENTO));
			entity.setvalor(resultSet.getDouble(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.VALOR));
			entity.setcuenta(resultSet.getString(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.CUENTA));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.FECHA).getTime()));
			entity.setbeneficiario_asiento(resultSet.getString(strPrefijo+BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIOASIENTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static BeneficiariosPagosCobros getEntityBeneficiariosPagosCobros(String strPrefijo,BeneficiariosPagosCobros entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = BeneficiariosPagosCobros.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = BeneficiariosPagosCobros.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				BeneficiariosPagosCobrosLogic.setFieldReflectionBeneficiariosPagosCobros(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionBeneficiariosPagosCobros(Field field,String strPrefijo,String sColumn,BeneficiariosPagosCobros entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case BeneficiariosPagosCobrosConstantesFunciones.CODIGOCUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.NOMBRECUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.TIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.CUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIOASIENTO:
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
	
	public void quitarBeneficiariosPagosCobrossNulos() throws Exception {				
		
		List<BeneficiariosPagosCobros> beneficiariospagoscobrossAux= new ArrayList<BeneficiariosPagosCobros>();
		
		for(BeneficiariosPagosCobros beneficiariospagoscobros:beneficiariospagoscobross) {
			if(beneficiariospagoscobros!=null) {
				beneficiariospagoscobrossAux.add(beneficiariospagoscobros);
			}
		}
		
		beneficiariospagoscobross=beneficiariospagoscobrossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<BeneficiariosPagosCobros> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BeneficiariosPagosCobros> entities = new  ArrayList<BeneficiariosPagosCobros>();
		BeneficiariosPagosCobros entity = new BeneficiariosPagosCobros();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<BeneficiariosPagosCobros>((List<BeneficiariosPagosCobros>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setBeneficiariosPagosCobrossOriginal(entities);
			
			}  else {
				this.beneficiariospagoscobrossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//BeneficiariosPagosCobrosConstantesFunciones.quitarEspaciosBeneficiariosPagosCobross(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		beneficiariospagoscobross = new  ArrayList<BeneficiariosPagosCobros>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//BeneficiariosPagosCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			beneficiariospagoscobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		beneficiariospagoscobross = new  ArrayList<BeneficiariosPagosCobros>();
		  		  
        try {
			//BeneficiariosPagosCobrosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			beneficiariospagoscobross=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<BeneficiariosPagosCobros> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<BeneficiariosPagosCobros> entities = new  ArrayList<BeneficiariosPagosCobros>();
		BeneficiariosPagosCobros entity = new BeneficiariosPagosCobros();		  
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
	
	public  List<BeneficiariosPagosCobros> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<BeneficiariosPagosCobros> entities = new  ArrayList<BeneficiariosPagosCobros>();
		BeneficiariosPagosCobros entity = new BeneficiariosPagosCobros();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BeneficiariosPagosCobros();
				
				if(conMapGenerico) {
					entity.setMapBeneficiariosPagosCobros( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapBeneficiariosPagosCobros().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BeneficiariosPagosCobrosDataAccess.ISWITHSCHEMA);         		
					entity=BeneficiariosPagosCobrosLogic.getEntityBeneficiariosPagosCobros("",entity,resultSet,listColumns);
					
					////entity.setBeneficiariosPagosCobrosOriginal( new BeneficiariosPagosCobros());
					////entity.setBeneficiariosPagosCobrosOriginal(super.getEntity("",entity.getBeneficiariosPagosCobrosOriginal(),resultSet,BeneficiariosPagosCobrosDataAccess.ISWITHSCHEMA));         		
					////entity.setBeneficiariosPagosCobrosOriginal(BeneficiariosPagosCobrosDataAccess.getEntityBeneficiariosPagosCobros("",entity.getBeneficiariosPagosCobrosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,BeneficiariosPagosCobros relbeneficiariospagoscobros)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relbeneficiariospagoscobros.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,BeneficiariosPagosCobros relbeneficiariospagoscobros)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relbeneficiariospagoscobros.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,BeneficiariosPagosCobros relbeneficiariospagoscobros)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relbeneficiariospagoscobros.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,BeneficiariosPagosCobros relbeneficiariospagoscobros)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);
			tipomovimientoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relbeneficiariospagoscobros.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}


	
	
	public void getBeneficiariosPagosCobrossBusquedaBeneficiariosPagosCobrosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//BeneficiariosPagosCobrosLogic beneficiariospagoscobrosLogic=new BeneficiariosPagosCobrosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=BeneficiariosPagosCobrosLogic.GetSelecSqlBeneficiariosPagosCobros(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_tipo_movimiento,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.beneficiariospagoscobross=this.getBeneficiariosPagosCobross();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getBeneficiariosPagosCobrossBusquedaBeneficiariosPagosCobros(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta)throws Exception {
		try {
			//BeneficiariosPagosCobrosLogic beneficiariospagoscobrosLogic=new BeneficiariosPagosCobrosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=BeneficiariosPagosCobrosLogic.GetSelecSqlBeneficiariosPagosCobros(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_tipo_movimiento,fecha_desde,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.beneficiariospagoscobross=this.getBeneficiariosPagosCobross();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlBeneficiariosPagosCobros(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("BeneficiariosPagosCobros_Postgres.sql");
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

				if(id_tipo_movimiento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_tipo_movimiento = "+id_tipo_movimiento.toString();
					existeWhere=true;
				}

				if(fecha_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_desde)+"'";
					existeWhere=true;
				}

				if(fecha_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_hasta)+"'";
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
	
	
	public void deepLoad(BeneficiariosPagosCobros beneficiariospagoscobros,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BeneficiariosPagosCobrosLogicAdditional.updateBeneficiariosPagosCobrosToGet(beneficiariospagoscobros,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		beneficiariospagoscobros.setEmpresa(beneficiariospagoscobrosDataAccess.getEmpresa(connexion,beneficiariospagoscobros));
		beneficiariospagoscobros.setSucursal(beneficiariospagoscobrosDataAccess.getSucursal(connexion,beneficiariospagoscobros));
		beneficiariospagoscobros.setEjercicio(beneficiariospagoscobrosDataAccess.getEjercicio(connexion,beneficiariospagoscobros));
		beneficiariospagoscobros.setTipoMovimiento(beneficiariospagoscobrosDataAccess.getTipoMovimiento(connexion,beneficiariospagoscobros));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				beneficiariospagoscobros.setEmpresa(beneficiariospagoscobrosDataAccess.getEmpresa(connexion,beneficiariospagoscobros));
			}

			if(clas.clas.equals(Sucursal.class)) {
				beneficiariospagoscobros.setSucursal(beneficiariospagoscobrosDataAccess.getSucursal(connexion,beneficiariospagoscobros));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				beneficiariospagoscobros.setEjercicio(beneficiariospagoscobrosDataAccess.getEjercicio(connexion,beneficiariospagoscobros));
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				beneficiariospagoscobros.setTipoMovimiento(beneficiariospagoscobrosDataAccess.getTipoMovimiento(connexion,beneficiariospagoscobros));
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
			beneficiariospagoscobros.setEmpresa(beneficiariospagoscobrosDataAccess.getEmpresa(connexion,beneficiariospagoscobros));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			beneficiariospagoscobros.setSucursal(beneficiariospagoscobrosDataAccess.getSucursal(connexion,beneficiariospagoscobros));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			beneficiariospagoscobros.setEjercicio(beneficiariospagoscobrosDataAccess.getEjercicio(connexion,beneficiariospagoscobros));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			beneficiariospagoscobros.setTipoMovimiento(beneficiariospagoscobrosDataAccess.getTipoMovimiento(connexion,beneficiariospagoscobros));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		beneficiariospagoscobros.setEmpresa(beneficiariospagoscobrosDataAccess.getEmpresa(connexion,beneficiariospagoscobros));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(beneficiariospagoscobros.getEmpresa(),isDeep,deepLoadType,clases);
				
		beneficiariospagoscobros.setSucursal(beneficiariospagoscobrosDataAccess.getSucursal(connexion,beneficiariospagoscobros));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(beneficiariospagoscobros.getSucursal(),isDeep,deepLoadType,clases);
				
		beneficiariospagoscobros.setEjercicio(beneficiariospagoscobrosDataAccess.getEjercicio(connexion,beneficiariospagoscobros));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(beneficiariospagoscobros.getEjercicio(),isDeep,deepLoadType,clases);
				
		beneficiariospagoscobros.setTipoMovimiento(beneficiariospagoscobrosDataAccess.getTipoMovimiento(connexion,beneficiariospagoscobros));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(beneficiariospagoscobros.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				beneficiariospagoscobros.setEmpresa(beneficiariospagoscobrosDataAccess.getEmpresa(connexion,beneficiariospagoscobros));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(beneficiariospagoscobros.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				beneficiariospagoscobros.setSucursal(beneficiariospagoscobrosDataAccess.getSucursal(connexion,beneficiariospagoscobros));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(beneficiariospagoscobros.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				beneficiariospagoscobros.setEjercicio(beneficiariospagoscobrosDataAccess.getEjercicio(connexion,beneficiariospagoscobros));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(beneficiariospagoscobros.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				beneficiariospagoscobros.setTipoMovimiento(beneficiariospagoscobrosDataAccess.getTipoMovimiento(connexion,beneficiariospagoscobros));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(beneficiariospagoscobros.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			beneficiariospagoscobros.setEmpresa(beneficiariospagoscobrosDataAccess.getEmpresa(connexion,beneficiariospagoscobros));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(beneficiariospagoscobros.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			beneficiariospagoscobros.setSucursal(beneficiariospagoscobrosDataAccess.getSucursal(connexion,beneficiariospagoscobros));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(beneficiariospagoscobros.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			beneficiariospagoscobros.setEjercicio(beneficiariospagoscobrosDataAccess.getEjercicio(connexion,beneficiariospagoscobros));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(beneficiariospagoscobros.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			beneficiariospagoscobros.setTipoMovimiento(beneficiariospagoscobrosDataAccess.getTipoMovimiento(connexion,beneficiariospagoscobros));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(beneficiariospagoscobros.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(beneficiariospagoscobros,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BeneficiariosPagosCobrosConstantesFunciones.refrescarForeignKeysDescripcionesBeneficiariosPagosCobros(beneficiariospagoscobros);
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
			this.deepLoad(this.beneficiariospagoscobros,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BeneficiariosPagosCobrosConstantesFunciones.refrescarForeignKeysDescripcionesBeneficiariosPagosCobros(this.beneficiariospagoscobros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(beneficiariospagoscobross!=null) {
				for(BeneficiariosPagosCobros beneficiariospagoscobros:beneficiariospagoscobross) {
					this.deepLoad(beneficiariospagoscobros,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BeneficiariosPagosCobrosConstantesFunciones.refrescarForeignKeysDescripcionesBeneficiariosPagosCobros(beneficiariospagoscobross);
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
			if(beneficiariospagoscobross!=null) {
				for(BeneficiariosPagosCobros beneficiariospagoscobros:beneficiariospagoscobross) {
					this.deepLoad(beneficiariospagoscobros,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BeneficiariosPagosCobrosConstantesFunciones.refrescarForeignKeysDescripcionesBeneficiariosPagosCobros(beneficiariospagoscobross);
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
	
	public BeneficiariosPagosCobrosParameterReturnGeneral procesarAccionBeneficiariosPagosCobross(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BeneficiariosPagosCobros> beneficiariospagoscobross,BeneficiariosPagosCobrosParameterReturnGeneral beneficiariospagoscobrosParameterGeneral)throws Exception {
		 try {	
			BeneficiariosPagosCobrosParameterReturnGeneral beneficiariospagoscobrosReturnGeneral=new BeneficiariosPagosCobrosParameterReturnGeneral();
	
			BeneficiariosPagosCobrosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,beneficiariospagoscobross,beneficiariospagoscobrosParameterGeneral,beneficiariospagoscobrosReturnGeneral);
			
			return beneficiariospagoscobrosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BeneficiariosPagosCobrosParameterReturnGeneral procesarAccionBeneficiariosPagosCobrossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BeneficiariosPagosCobros> beneficiariospagoscobross,BeneficiariosPagosCobrosParameterReturnGeneral beneficiariospagoscobrosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			BeneficiariosPagosCobrosParameterReturnGeneral beneficiariospagoscobrosReturnGeneral=new BeneficiariosPagosCobrosParameterReturnGeneral();
	
			BeneficiariosPagosCobrosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,beneficiariospagoscobross,beneficiariospagoscobrosParameterGeneral,beneficiariospagoscobrosReturnGeneral);
			
			this.connexion.commit();
			
			return beneficiariospagoscobrosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

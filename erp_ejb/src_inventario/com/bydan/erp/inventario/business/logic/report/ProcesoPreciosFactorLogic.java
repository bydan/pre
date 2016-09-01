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
package com.bydan.erp.inventario.business.logic.report;

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

import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.resources.general.AuxiliarGeneral;
import com.bydan.erp.inventario.util.report.ProcesoPreciosFactorParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoPreciosFactorParameterGeneral;
import com.bydan.erp.inventario.util.report.ProcesoPreciosFactorConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.ProcesoPreciosFactor;

import com.bydan.erp.inventario.business.logic.report.ProcesoPreciosFactorLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoPreciosFactorLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoPreciosFactorLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoPreciosFactorLogic procesopreciosfactorDataAccess; 		
	protected ProcesoPreciosFactor procesopreciosfactor;
	protected List<ProcesoPreciosFactor> procesopreciosfactors;
	protected Object procesopreciosfactorObject;	
	protected List<Object> procesopreciosfactorsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoPreciosFactorLogic()throws SQLException,Exception {
		try	{
			this.procesopreciosfactors= new ArrayList<ProcesoPreciosFactor>();
			this.procesopreciosfactor= new ProcesoPreciosFactor();
			this.procesopreciosfactorObject=new Object();
			this.procesopreciosfactorsObject=new ArrayList<Object>();
			
			this.procesopreciosfactorDataAccess=this;
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
			this.procesopreciosfactorDataAccess.setConnexionType(this.connexionType);
			this.procesopreciosfactorDataAccess.setParameterDbType(this.parameterDbType);
			this.procesopreciosfactorDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoPreciosFactorLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesopreciosfactors= new ArrayList<ProcesoPreciosFactor>();
			this.procesopreciosfactor= new ProcesoPreciosFactor();
			this.procesopreciosfactorObject=new Object();
			this.procesopreciosfactorsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesopreciosfactorDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesopreciosfactorDataAccess.setConnexionType(this.connexionType);
			this.procesopreciosfactorDataAccess.setParameterDbType(this.parameterDbType);
			this.procesopreciosfactorDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoPreciosFactor getProcesoPreciosFactor() throws Exception {	
		ProcesoPreciosFactorLogicAdditional.checkProcesoPreciosFactorToGet(procesopreciosfactor,this.datosCliente,this.arrDatoGeneral);
		ProcesoPreciosFactorLogicAdditional.updateProcesoPreciosFactorToGet(procesopreciosfactor,this.arrDatoGeneral);
		
		return procesopreciosfactor;
	}
		
	public void setProcesoPreciosFactor(ProcesoPreciosFactor newProcesoPreciosFactor) {
		this.procesopreciosfactor = newProcesoPreciosFactor;
	}
	
	public List<ProcesoPreciosFactor> getProcesoPreciosFactors() throws Exception {		
		this.quitarProcesoPreciosFactorsNulos();
		
		ProcesoPreciosFactorLogicAdditional.checkProcesoPreciosFactorToGets(procesopreciosfactors,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoPreciosFactor procesopreciosfactorLocal: procesopreciosfactors ) {
			ProcesoPreciosFactorLogicAdditional.updateProcesoPreciosFactorToGet(procesopreciosfactorLocal,this.arrDatoGeneral);
		}
		
		return procesopreciosfactors;
	}
	
	public void setProcesoPreciosFactors(List<ProcesoPreciosFactor> newProcesoPreciosFactors) {
		this.procesopreciosfactors = newProcesoPreciosFactors;
	}
	
	public Object getProcesoPreciosFactorObject() {	
		//this.procesopreciosfactorObject=this.procesopreciosfactorDataAccess.getEntityObject();
		return this.procesopreciosfactorObject;
	}
		
	public void setProcesoPreciosFactorObject(Object newProcesoPreciosFactorObject) {
		this.procesopreciosfactorObject = newProcesoPreciosFactorObject;
	}
	
	public List<Object> getProcesoPreciosFactorsObject() {		
		//this.procesopreciosfactorsObject=this.procesopreciosfactorDataAccess.getEntitiesObject();
		return this.procesopreciosfactorsObject;
	}
		
	public void setProcesoPreciosFactorsObject(List<Object> newProcesoPreciosFactorsObject) {
		this.procesopreciosfactorsObject = newProcesoPreciosFactorsObject;
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
		procesopreciosfactors = new  ArrayList<ProcesoPreciosFactor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoPreciosFactorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosfactors=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesopreciosfactors = new  ArrayList<ProcesoPreciosFactor>();
		  		  
        try {
			//ProcesoPreciosFactorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosfactors=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesopreciosfactors = new  ArrayList<ProcesoPreciosFactor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoPreciosFactorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosfactors=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesopreciosfactors = new  ArrayList<ProcesoPreciosFactor>();
		  		  
        try {
			//ProcesoPreciosFactorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosfactors=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesopreciosfactors = new  ArrayList<ProcesoPreciosFactor>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoPreciosFactorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosfactors=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesopreciosfactors = new  ArrayList<ProcesoPreciosFactor>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoPreciosFactorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosfactors=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoPreciosFactor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoPreciosFactor> entities = new  ArrayList<ProcesoPreciosFactor>();
		ProcesoPreciosFactor entity = new ProcesoPreciosFactor();		  
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
	
	public  List<ProcesoPreciosFactor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoPreciosFactor> entities = new  ArrayList<ProcesoPreciosFactor>();
		ProcesoPreciosFactor entity = new ProcesoPreciosFactor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoPreciosFactor();
				
				
      	    	entity=ProcesoPreciosFactorLogic.getEntityProcesoPreciosFactor("",entity,resultSet);
      	    	
				//entity.setProcesoPreciosFactorOriginal( new ProcesoPreciosFactor());
      	    	//entity.setProcesoPreciosFactorOriginal(super.getEntity("",entity.getProcesoPreciosFactorOriginal(),resultSet,ProcesoPreciosFactorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoPreciosFactorOriginal(ProcesoPreciosFactorDataAccess.getEntityProcesoPreciosFactor("",entity.getProcesoPreciosFactorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoPreciosFactor> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoPreciosFactor> entities = new  ArrayList<ProcesoPreciosFactor>();
		ProcesoPreciosFactor entity = new ProcesoPreciosFactor();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoPreciosFactor.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoPreciosFactor>((List<ProcesoPreciosFactor>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoPreciosFactorsOriginal(entities);
			
			}  else {
				this.procesopreciosfactorsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoPreciosFactorConstantesFunciones.quitarEspaciosProcesoPreciosFactors(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoPreciosFactor getEntityProcesoPreciosFactor(String strPrefijo,ProcesoPreciosFactor entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo(resultSet.getString(strPrefijo+ProcesoPreciosFactorConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+ProcesoPreciosFactorConstantesFunciones.NOMBRE));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+ProcesoPreciosFactorConstantesFunciones.CODIGOPRODUCTO));
			entity.setnombre_producto(resultSet.getString(strPrefijo+ProcesoPreciosFactorConstantesFunciones.NOMBREPRODUCTO));
			entity.setprecio(resultSet.getDouble(strPrefijo+ProcesoPreciosFactorConstantesFunciones.PRECIO));
			entity.setfactor(resultSet.getDouble(strPrefijo+ProcesoPreciosFactorConstantesFunciones.FACTOR));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoPreciosFactor getEntityProcesoPreciosFactor(String strPrefijo,ProcesoPreciosFactor entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoPreciosFactor.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoPreciosFactor.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoPreciosFactorLogic.setFieldReflectionProcesoPreciosFactor(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoPreciosFactor(Field field,String strPrefijo,String sColumn,ProcesoPreciosFactor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoPreciosFactorConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoPreciosFactorConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoPreciosFactorConstantesFunciones.CODIGOPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoPreciosFactorConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProcesoPreciosFactorConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProcesoPreciosFactorConstantesFunciones.FACTOR:
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
	
	public void quitarProcesoPreciosFactorsNulos() throws Exception {				
		
		List<ProcesoPreciosFactor> procesopreciosfactorsAux= new ArrayList<ProcesoPreciosFactor>();
		
		for(ProcesoPreciosFactor procesopreciosfactor:procesopreciosfactors) {
			if(procesopreciosfactor!=null) {
				procesopreciosfactorsAux.add(procesopreciosfactor);
			}
		}
		
		procesopreciosfactors=procesopreciosfactorsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoPreciosFactor> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoPreciosFactor> entities = new  ArrayList<ProcesoPreciosFactor>();
		ProcesoPreciosFactor entity = new ProcesoPreciosFactor();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoPreciosFactor>((List<ProcesoPreciosFactor>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoPreciosFactorsOriginal(entities);
			
			}  else {
				this.procesopreciosfactorsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoPreciosFactorConstantesFunciones.quitarEspaciosProcesoPreciosFactors(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesopreciosfactors = new  ArrayList<ProcesoPreciosFactor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoPreciosFactorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosfactors=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesopreciosfactors = new  ArrayList<ProcesoPreciosFactor>();
		  		  
        try {
			//ProcesoPreciosFactorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesopreciosfactors=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoPreciosFactor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoPreciosFactor> entities = new  ArrayList<ProcesoPreciosFactor>();
		ProcesoPreciosFactor entity = new ProcesoPreciosFactor();		  
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
	
	public  List<ProcesoPreciosFactor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoPreciosFactor> entities = new  ArrayList<ProcesoPreciosFactor>();
		ProcesoPreciosFactor entity = new ProcesoPreciosFactor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoPreciosFactor();
				
				if(conMapGenerico) {
					entity.setMapProcesoPreciosFactor( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoPreciosFactor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoPreciosFactorDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoPreciosFactorLogic.getEntityProcesoPreciosFactor("",entity,resultSet,listColumns);
					
					////entity.setProcesoPreciosFactorOriginal( new ProcesoPreciosFactor());
					////entity.setProcesoPreciosFactorOriginal(super.getEntity("",entity.getProcesoPreciosFactorOriginal(),resultSet,ProcesoPreciosFactorDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoPreciosFactorOriginal(ProcesoPreciosFactorDataAccess.getEntityProcesoPreciosFactor("",entity.getProcesoPreciosFactorOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Bodega getBodega(Connexion connexion,ProcesoPreciosFactor relprocesopreciosfactor)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			bodega=bodegaDataAccess.getEntity(connexion,relprocesopreciosfactor.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProcesoPreciosFactor relprocesopreciosfactor)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relprocesopreciosfactor.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Empresa getEmpresa(Connexion connexion,ProcesoPreciosFactor relprocesopreciosfactor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relprocesopreciosfactor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProcesoPreciosFactor relprocesopreciosfactor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relprocesopreciosfactor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,ProcesoPreciosFactor relprocesopreciosfactor)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesopreciosfactor.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProcesoPreciosFactor relprocesopreciosfactor)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesopreciosfactor.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProcesoPreciosFactor relprocesopreciosfactor)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesopreciosfactor.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProcesoPreciosFactor relprocesopreciosfactor)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relprocesopreciosfactor.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


	
	
	public void getProcesoPreciosFactorsBusquedaProcesoPreciosFactorWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoPreciosFactorLogic procesopreciosfactorLogic=new ProcesoPreciosFactorLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoPreciosFactorLogic.GetSelecSqlProcesoPreciosFactor(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesopreciosfactors=this.getProcesoPreciosFactors();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoPreciosFactorsBusquedaProcesoPreciosFactor(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try {
			//ProcesoPreciosFactorLogic procesopreciosfactorLogic=new ProcesoPreciosFactorLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ProcesoPreciosFactorLogic.GetSelecSqlProcesoPreciosFactor(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.procesopreciosfactors=this.getProcesoPreciosFactors();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlProcesoPreciosFactor(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoPreciosFactor_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" bp.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_bodega!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_bodega = "+id_bodega.toString();
					existeWhere=true;
				}

				if(id_producto!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" bp.id_producto = "+id_producto.toString();
					existeWhere=true;
				}

				if(id_linea!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea = "+id_linea.toString();
					existeWhere=true;
				}

				if(id_linea_grupo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_grupo = "+id_linea_grupo.toString();
					existeWhere=true;
				}

				if(id_linea_categoria!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_categoria = "+id_linea_categoria.toString();
					existeWhere=true;
				}

				if(id_linea_marca!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.id_linea_marca = "+id_linea_marca.toString();
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
	
	
	public void deepLoad(ProcesoPreciosFactor procesopreciosfactor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoPreciosFactorLogicAdditional.updateProcesoPreciosFactorToGet(procesopreciosfactor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesopreciosfactor.setBodega(procesopreciosfactorDataAccess.getBodega(connexion,procesopreciosfactor));
		procesopreciosfactor.setProducto(procesopreciosfactorDataAccess.getProducto(connexion,procesopreciosfactor));
		procesopreciosfactor.setEmpresa(procesopreciosfactorDataAccess.getEmpresa(connexion,procesopreciosfactor));
		procesopreciosfactor.setSucursal(procesopreciosfactorDataAccess.getSucursal(connexion,procesopreciosfactor));
		procesopreciosfactor.setLinea(procesopreciosfactorDataAccess.getLinea(connexion,procesopreciosfactor));
		procesopreciosfactor.setLineaGrupo(procesopreciosfactorDataAccess.getLineaGrupo(connexion,procesopreciosfactor));
		procesopreciosfactor.setLineaCategoria(procesopreciosfactorDataAccess.getLineaCategoria(connexion,procesopreciosfactor));
		procesopreciosfactor.setLineaMarca(procesopreciosfactorDataAccess.getLineaMarca(connexion,procesopreciosfactor));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesopreciosfactor.setBodega(procesopreciosfactorDataAccess.getBodega(connexion,procesopreciosfactor));
			}

			if(clas.clas.equals(Producto.class)) {
				procesopreciosfactor.setProducto(procesopreciosfactorDataAccess.getProducto(connexion,procesopreciosfactor));
			}

			if(clas.clas.equals(Empresa.class)) {
				procesopreciosfactor.setEmpresa(procesopreciosfactorDataAccess.getEmpresa(connexion,procesopreciosfactor));
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesopreciosfactor.setSucursal(procesopreciosfactorDataAccess.getSucursal(connexion,procesopreciosfactor));
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosfactor.setLinea(procesopreciosfactorDataAccess.getLinea(connexion,procesopreciosfactor));
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosfactor.setLineaGrupo(procesopreciosfactorDataAccess.getLineaGrupo(connexion,procesopreciosfactor));
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosfactor.setLineaCategoria(procesopreciosfactorDataAccess.getLineaCategoria(connexion,procesopreciosfactor));
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosfactor.setLineaMarca(procesopreciosfactorDataAccess.getLineaMarca(connexion,procesopreciosfactor));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setBodega(procesopreciosfactorDataAccess.getBodega(connexion,procesopreciosfactor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setProducto(procesopreciosfactorDataAccess.getProducto(connexion,procesopreciosfactor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setEmpresa(procesopreciosfactorDataAccess.getEmpresa(connexion,procesopreciosfactor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setSucursal(procesopreciosfactorDataAccess.getSucursal(connexion,procesopreciosfactor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setLinea(procesopreciosfactorDataAccess.getLinea(connexion,procesopreciosfactor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setLineaGrupo(procesopreciosfactorDataAccess.getLineaGrupo(connexion,procesopreciosfactor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setLineaCategoria(procesopreciosfactorDataAccess.getLineaCategoria(connexion,procesopreciosfactor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setLineaMarca(procesopreciosfactorDataAccess.getLineaMarca(connexion,procesopreciosfactor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesopreciosfactor.setBodega(procesopreciosfactorDataAccess.getBodega(connexion,procesopreciosfactor));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(procesopreciosfactor.getBodega(),isDeep,deepLoadType,clases);
				
		procesopreciosfactor.setProducto(procesopreciosfactorDataAccess.getProducto(connexion,procesopreciosfactor));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(procesopreciosfactor.getProducto(),isDeep,deepLoadType,clases);
				
		procesopreciosfactor.setEmpresa(procesopreciosfactorDataAccess.getEmpresa(connexion,procesopreciosfactor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(procesopreciosfactor.getEmpresa(),isDeep,deepLoadType,clases);
				
		procesopreciosfactor.setSucursal(procesopreciosfactorDataAccess.getSucursal(connexion,procesopreciosfactor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(procesopreciosfactor.getSucursal(),isDeep,deepLoadType,clases);
				
		procesopreciosfactor.setLinea(procesopreciosfactorDataAccess.getLinea(connexion,procesopreciosfactor));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(procesopreciosfactor.getLinea(),isDeep,deepLoadType,clases);
				
		procesopreciosfactor.setLineaGrupo(procesopreciosfactorDataAccess.getLineaGrupo(connexion,procesopreciosfactor));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(procesopreciosfactor.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		procesopreciosfactor.setLineaCategoria(procesopreciosfactorDataAccess.getLineaCategoria(connexion,procesopreciosfactor));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(procesopreciosfactor.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		procesopreciosfactor.setLineaMarca(procesopreciosfactorDataAccess.getLineaMarca(connexion,procesopreciosfactor));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(procesopreciosfactor.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				procesopreciosfactor.setBodega(procesopreciosfactorDataAccess.getBodega(connexion,procesopreciosfactor));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(procesopreciosfactor.getBodega(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				procesopreciosfactor.setProducto(procesopreciosfactorDataAccess.getProducto(connexion,procesopreciosfactor));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(procesopreciosfactor.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Empresa.class)) {
				procesopreciosfactor.setEmpresa(procesopreciosfactorDataAccess.getEmpresa(connexion,procesopreciosfactor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(procesopreciosfactor.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				procesopreciosfactor.setSucursal(procesopreciosfactorDataAccess.getSucursal(connexion,procesopreciosfactor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(procesopreciosfactor.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosfactor.setLinea(procesopreciosfactorDataAccess.getLinea(connexion,procesopreciosfactor));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesopreciosfactor.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosfactor.setLineaGrupo(procesopreciosfactorDataAccess.getLineaGrupo(connexion,procesopreciosfactor));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesopreciosfactor.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosfactor.setLineaCategoria(procesopreciosfactorDataAccess.getLineaCategoria(connexion,procesopreciosfactor));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesopreciosfactor.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				procesopreciosfactor.setLineaMarca(procesopreciosfactorDataAccess.getLineaMarca(connexion,procesopreciosfactor));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(procesopreciosfactor.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setBodega(procesopreciosfactorDataAccess.getBodega(connexion,procesopreciosfactor));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(procesopreciosfactor.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setProducto(procesopreciosfactorDataAccess.getProducto(connexion,procesopreciosfactor));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(procesopreciosfactor.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setEmpresa(procesopreciosfactorDataAccess.getEmpresa(connexion,procesopreciosfactor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(procesopreciosfactor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setSucursal(procesopreciosfactorDataAccess.getSucursal(connexion,procesopreciosfactor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(procesopreciosfactor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setLinea(procesopreciosfactorDataAccess.getLinea(connexion,procesopreciosfactor));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesopreciosfactor.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setLineaGrupo(procesopreciosfactorDataAccess.getLineaGrupo(connexion,procesopreciosfactor));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesopreciosfactor.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setLineaCategoria(procesopreciosfactorDataAccess.getLineaCategoria(connexion,procesopreciosfactor));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesopreciosfactor.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesopreciosfactor.setLineaMarca(procesopreciosfactorDataAccess.getLineaMarca(connexion,procesopreciosfactor));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(procesopreciosfactor.getLineaMarca(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesopreciosfactor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoPreciosFactorConstantesFunciones.refrescarForeignKeysDescripcionesProcesoPreciosFactor(procesopreciosfactor);
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
			this.deepLoad(this.procesopreciosfactor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoPreciosFactorConstantesFunciones.refrescarForeignKeysDescripcionesProcesoPreciosFactor(this.procesopreciosfactor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesopreciosfactors!=null) {
				for(ProcesoPreciosFactor procesopreciosfactor:procesopreciosfactors) {
					this.deepLoad(procesopreciosfactor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoPreciosFactorConstantesFunciones.refrescarForeignKeysDescripcionesProcesoPreciosFactor(procesopreciosfactors);
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
			if(procesopreciosfactors!=null) {
				for(ProcesoPreciosFactor procesopreciosfactor:procesopreciosfactors) {
					this.deepLoad(procesopreciosfactor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoPreciosFactorConstantesFunciones.refrescarForeignKeysDescripcionesProcesoPreciosFactor(procesopreciosfactors);
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
	
	public ProcesoPreciosFactorParameterReturnGeneral procesarAccionProcesoPreciosFactors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoPreciosFactor> procesopreciosfactors,ProcesoPreciosFactorParameterReturnGeneral procesopreciosfactorParameterGeneral)throws Exception {
		 try {	
			ProcesoPreciosFactorParameterReturnGeneral procesopreciosfactorReturnGeneral=new ProcesoPreciosFactorParameterReturnGeneral();
	
			ProcesoPreciosFactorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesopreciosfactors,procesopreciosfactorParameterGeneral,procesopreciosfactorReturnGeneral);
			
			return procesopreciosfactorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoPreciosFactorParameterReturnGeneral procesarAccionProcesoPreciosFactorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoPreciosFactor> procesopreciosfactors,ProcesoPreciosFactorParameterReturnGeneral procesopreciosfactorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoPreciosFactorParameterReturnGeneral procesopreciosfactorReturnGeneral=new ProcesoPreciosFactorParameterReturnGeneral();
	
			ProcesoPreciosFactorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesopreciosfactors,procesopreciosfactorParameterGeneral,procesopreciosfactorReturnGeneral);
			
			this.connexion.commit();
			
			return procesopreciosfactorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

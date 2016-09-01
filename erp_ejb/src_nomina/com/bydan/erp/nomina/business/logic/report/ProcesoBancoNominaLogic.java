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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;
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
import com.bydan.erp.nomina.util.report.ProcesoBancoNominaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoBancoNominaParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoBancoNominaConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoBancoNomina;

import com.bydan.erp.nomina.business.logic.report.ProcesoBancoNominaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoBancoNominaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoBancoNominaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoBancoNominaLogic procesobanconominaDataAccess; 		
	protected ProcesoBancoNomina procesobanconomina;
	protected List<ProcesoBancoNomina> procesobanconominas;
	protected Object procesobanconominaObject;	
	protected List<Object> procesobanconominasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoBancoNominaLogic()throws SQLException,Exception {
		try	{
			this.procesobanconominas= new ArrayList<ProcesoBancoNomina>();
			this.procesobanconomina= new ProcesoBancoNomina();
			this.procesobanconominaObject=new Object();
			this.procesobanconominasObject=new ArrayList<Object>();
			
			this.procesobanconominaDataAccess=this;
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
			this.procesobanconominaDataAccess.setConnexionType(this.connexionType);
			this.procesobanconominaDataAccess.setParameterDbType(this.parameterDbType);
			this.procesobanconominaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoBancoNominaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesobanconominas= new ArrayList<ProcesoBancoNomina>();
			this.procesobanconomina= new ProcesoBancoNomina();
			this.procesobanconominaObject=new Object();
			this.procesobanconominasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesobanconominaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesobanconominaDataAccess.setConnexionType(this.connexionType);
			this.procesobanconominaDataAccess.setParameterDbType(this.parameterDbType);
			this.procesobanconominaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoBancoNomina getProcesoBancoNomina() throws Exception {	
		ProcesoBancoNominaLogicAdditional.checkProcesoBancoNominaToGet(procesobanconomina,this.datosCliente,this.arrDatoGeneral);
		ProcesoBancoNominaLogicAdditional.updateProcesoBancoNominaToGet(procesobanconomina,this.arrDatoGeneral);
		
		return procesobanconomina;
	}
		
	public void setProcesoBancoNomina(ProcesoBancoNomina newProcesoBancoNomina) {
		this.procesobanconomina = newProcesoBancoNomina;
	}
	
	public List<ProcesoBancoNomina> getProcesoBancoNominas() throws Exception {		
		this.quitarProcesoBancoNominasNulos();
		
		ProcesoBancoNominaLogicAdditional.checkProcesoBancoNominaToGets(procesobanconominas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoBancoNomina procesobanconominaLocal: procesobanconominas ) {
			ProcesoBancoNominaLogicAdditional.updateProcesoBancoNominaToGet(procesobanconominaLocal,this.arrDatoGeneral);
		}
		
		return procesobanconominas;
	}
	
	public void setProcesoBancoNominas(List<ProcesoBancoNomina> newProcesoBancoNominas) {
		this.procesobanconominas = newProcesoBancoNominas;
	}
	
	public Object getProcesoBancoNominaObject() {	
		//this.procesobanconominaObject=this.procesobanconominaDataAccess.getEntityObject();
		return this.procesobanconominaObject;
	}
		
	public void setProcesoBancoNominaObject(Object newProcesoBancoNominaObject) {
		this.procesobanconominaObject = newProcesoBancoNominaObject;
	}
	
	public List<Object> getProcesoBancoNominasObject() {		
		//this.procesobanconominasObject=this.procesobanconominaDataAccess.getEntitiesObject();
		return this.procesobanconominasObject;
	}
		
	public void setProcesoBancoNominasObject(List<Object> newProcesoBancoNominasObject) {
		this.procesobanconominasObject = newProcesoBancoNominasObject;
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
		procesobanconominas = new  ArrayList<ProcesoBancoNomina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoBancoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesobanconominas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesobanconominas = new  ArrayList<ProcesoBancoNomina>();
		  		  
        try {
			//ProcesoBancoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesobanconominas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesobanconominas = new  ArrayList<ProcesoBancoNomina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoBancoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesobanconominas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesobanconominas = new  ArrayList<ProcesoBancoNomina>();
		  		  
        try {
			//ProcesoBancoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesobanconominas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesobanconominas = new  ArrayList<ProcesoBancoNomina>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoBancoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesobanconominas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesobanconominas = new  ArrayList<ProcesoBancoNomina>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoBancoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesobanconominas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoBancoNomina> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoBancoNomina> entities = new  ArrayList<ProcesoBancoNomina>();
		ProcesoBancoNomina entity = new ProcesoBancoNomina();		  
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
	
	public  List<ProcesoBancoNomina> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoBancoNomina> entities = new  ArrayList<ProcesoBancoNomina>();
		ProcesoBancoNomina entity = new ProcesoBancoNomina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoBancoNomina();
				
				
      	    	entity=ProcesoBancoNominaLogic.getEntityProcesoBancoNomina("",entity,resultSet);
      	    	
				//entity.setProcesoBancoNominaOriginal( new ProcesoBancoNomina());
      	    	//entity.setProcesoBancoNominaOriginal(super.getEntity("",entity.getProcesoBancoNominaOriginal(),resultSet,ProcesoBancoNominaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoBancoNominaOriginal(ProcesoBancoNominaDataAccess.getEntityProcesoBancoNomina("",entity.getProcesoBancoNominaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoBancoNomina> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoBancoNomina> entities = new  ArrayList<ProcesoBancoNomina>();
		ProcesoBancoNomina entity = new ProcesoBancoNomina();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoBancoNomina.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoBancoNomina>((List<ProcesoBancoNomina>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoBancoNominasOriginal(entities);
			
			}  else {
				this.procesobanconominasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoBancoNominaConstantesFunciones.quitarEspaciosProcesoBancoNominas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoBancoNomina getEntityProcesoBancoNomina(String strPrefijo,ProcesoBancoNomina entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_banco(resultSet.getLong(strPrefijo+ProcesoBancoNominaConstantesFunciones.IDBANCO));
			entity.setid_cuenta_banco(resultSet.getLong(strPrefijo+ProcesoBancoNominaConstantesFunciones.IDCUENTABANCO));
			entity.setid_tipo_contrato(resultSet.getLong(strPrefijo+ProcesoBancoNominaConstantesFunciones.IDTIPOCONTRATO));
			entity.setid_tipo_banco_disco(resultSet.getLong(strPrefijo+ProcesoBancoNominaConstantesFunciones.IDTIPOBANCODISCO));
			entity.setcon_otros(resultSet.getBoolean(strPrefijo+ProcesoBancoNominaConstantesFunciones.CONOTROS));
			entity.setcon_internet(resultSet.getBoolean(strPrefijo+ProcesoBancoNominaConstantesFunciones.CONINTERNET));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ProcesoBancoNominaConstantesFunciones.FECHA).getTime()));
			entity.setnumero_secuenciales(resultSet.getInt(strPrefijo+ProcesoBancoNominaConstantesFunciones.NUMEROSECUENCIALES));
			entity.setgenera_texto(resultSet.getBoolean(strPrefijo+ProcesoBancoNominaConstantesFunciones.GENERATEXTO));
			entity.setgenera_excel(resultSet.getBoolean(strPrefijo+ProcesoBancoNominaConstantesFunciones.GENERAEXCEL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoBancoNomina getEntityProcesoBancoNomina(String strPrefijo,ProcesoBancoNomina entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoBancoNomina.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoBancoNomina.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoBancoNominaLogic.setFieldReflectionProcesoBancoNomina(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoBancoNomina(Field field,String strPrefijo,String sColumn,ProcesoBancoNomina entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoBancoNominaConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoBancoNominaConstantesFunciones.IDCUENTABANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoBancoNominaConstantesFunciones.IDTIPOCONTRATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoBancoNominaConstantesFunciones.IDTIPOBANCODISCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoBancoNominaConstantesFunciones.CONOTROS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProcesoBancoNominaConstantesFunciones.CONINTERNET:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProcesoBancoNominaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProcesoBancoNominaConstantesFunciones.NUMEROSECUENCIALES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProcesoBancoNominaConstantesFunciones.GENERATEXTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProcesoBancoNominaConstantesFunciones.GENERAEXCEL:
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
	
	public void quitarProcesoBancoNominasNulos() throws Exception {				
		
		List<ProcesoBancoNomina> procesobanconominasAux= new ArrayList<ProcesoBancoNomina>();
		
		for(ProcesoBancoNomina procesobanconomina:procesobanconominas) {
			if(procesobanconomina!=null) {
				procesobanconominasAux.add(procesobanconomina);
			}
		}
		
		procesobanconominas=procesobanconominasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoBancoNomina> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoBancoNomina> entities = new  ArrayList<ProcesoBancoNomina>();
		ProcesoBancoNomina entity = new ProcesoBancoNomina();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoBancoNomina>((List<ProcesoBancoNomina>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoBancoNominasOriginal(entities);
			
			}  else {
				this.procesobanconominasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoBancoNominaConstantesFunciones.quitarEspaciosProcesoBancoNominas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesobanconominas = new  ArrayList<ProcesoBancoNomina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoBancoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesobanconominas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesobanconominas = new  ArrayList<ProcesoBancoNomina>();
		  		  
        try {
			//ProcesoBancoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesobanconominas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoBancoNomina> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoBancoNomina> entities = new  ArrayList<ProcesoBancoNomina>();
		ProcesoBancoNomina entity = new ProcesoBancoNomina();		  
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
	
	public  List<ProcesoBancoNomina> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoBancoNomina> entities = new  ArrayList<ProcesoBancoNomina>();
		ProcesoBancoNomina entity = new ProcesoBancoNomina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoBancoNomina();
				
				if(conMapGenerico) {
					entity.setMapProcesoBancoNomina( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoBancoNomina().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoBancoNominaDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoBancoNominaLogic.getEntityProcesoBancoNomina("",entity,resultSet,listColumns);
					
					////entity.setProcesoBancoNominaOriginal( new ProcesoBancoNomina());
					////entity.setProcesoBancoNominaOriginal(super.getEntity("",entity.getProcesoBancoNominaOriginal(),resultSet,ProcesoBancoNominaDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoBancoNominaOriginal(ProcesoBancoNominaDataAccess.getEntityProcesoBancoNomina("",entity.getProcesoBancoNominaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Banco getBanco(Connexion connexion,ProcesoBancoNomina relprocesobanconomina)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);
			bancoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			banco=bancoDataAccess.getEntity(connexion,relprocesobanconomina.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public CuentaBanco getCuentaBanco(Connexion connexion,ProcesoBancoNomina relprocesobanconomina)throws SQLException,Exception {

		CuentaBanco cuentabanco= new CuentaBanco();

		try {
			CuentaBancoDataAccess cuentabancoDataAccess=new CuentaBancoDataAccess();

			cuentabancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentabancoDataAccess.setConnexionType(this.connexionType);
			cuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			cuentabancoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cuentabanco=cuentabancoDataAccess.getEntity(connexion,relprocesobanconomina.getid_cuenta_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabanco;

	}

	public TipoContrato getTipoContrato(Connexion connexion,ProcesoBancoNomina relprocesobanconomina)throws SQLException,Exception {

		TipoContrato tipocontrato= new TipoContrato();

		try {
			TipoContratoDataAccess tipocontratoDataAccess=new TipoContratoDataAccess();

			tipocontratoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocontratoDataAccess.setConnexionType(this.connexionType);
			tipocontratoDataAccess.setParameterDbType(this.parameterDbType);
			tipocontratoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipocontrato=tipocontratoDataAccess.getEntity(connexion,relprocesobanconomina.getid_tipo_contrato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocontrato;

	}

	public TipoBancoDisco getTipoBancoDisco(Connexion connexion,ProcesoBancoNomina relprocesobanconomina)throws SQLException,Exception {

		TipoBancoDisco tipobancodisco= new TipoBancoDisco();

		try {
			TipoBancoDiscoDataAccess tipobancodiscoDataAccess=new TipoBancoDiscoDataAccess();

			tipobancodiscoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipobancodiscoDataAccess.setConnexionType(this.connexionType);
			tipobancodiscoDataAccess.setParameterDbType(this.parameterDbType);
			tipobancodiscoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipobancodisco=tipobancodiscoDataAccess.getEntity(connexion,relprocesobanconomina.getid_tipo_banco_disco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipobancodisco;

	}


	
	
	public void getProcesoBancoNominasBusquedaProcesoBancoNominaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_banco,Long id_cuenta_banco,Long id_tipo_contrato,Long id_tipo_banco_disco,Boolean con_otros,Boolean con_internet,Date fecha,Integer numero_secuenciales,Boolean genera_texto,Boolean genera_excel)throws Exception {
		try {
			ProcesoBancoNominaLogicAdditional procesobanconominaLogicAdditional=new ProcesoBancoNominaLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesobanconominaLogicAdditional.BusquedaProcesoBancoNomina(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_banco,id_cuenta_banco,id_tipo_contrato,id_tipo_banco_disco,con_otros,con_internet,fecha,numero_secuenciales,genera_texto,genera_excel);

			//this.procesobanconominas=this.getProcesoBancoNominas();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoBancoNominaLogicAdditional.ProcesarInformacionProcesoBancoNomina(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesobanconominaLogicAdditional,this.procesobanconominas,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoBancoNomina",id_banco,id_cuenta_banco,id_tipo_contrato,id_tipo_banco_disco,con_otros,con_internet,fecha,numero_secuenciales,genera_texto,genera_excel);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoBancoNominasBusquedaProcesoBancoNomina(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_banco,Long id_cuenta_banco,Long id_tipo_contrato,Long id_tipo_banco_disco,Boolean con_otros,Boolean con_internet,Date fecha,Integer numero_secuenciales,Boolean genera_texto,Boolean genera_excel)throws Exception {
		try {
			ProcesoBancoNominaLogicAdditional procesobanconominaLogicAdditional=new ProcesoBancoNominaLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesobanconominaLogicAdditional.BusquedaProcesoBancoNomina(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_banco,id_cuenta_banco,id_tipo_contrato,id_tipo_banco_disco,con_otros,con_internet,fecha,numero_secuenciales,genera_texto,genera_excel);

			//this.procesobanconominas=this.getProcesoBancoNominas();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoBancoNominaLogicAdditional.ProcesarInformacionProcesoBancoNomina(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesobanconominaLogicAdditional,this.procesobanconominas,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoBancoNomina",id_banco,id_cuenta_banco,id_tipo_contrato,id_tipo_banco_disco,con_otros,con_internet,fecha,numero_secuenciales,genera_texto,genera_excel);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoBancoNomina procesobanconomina,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoBancoNominaLogicAdditional.updateProcesoBancoNominaToGet(procesobanconomina,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesobanconomina.setBanco(procesobanconominaDataAccess.getBanco(connexion,procesobanconomina));
		procesobanconomina.setCuentaBanco(procesobanconominaDataAccess.getCuentaBanco(connexion,procesobanconomina));
		procesobanconomina.setTipoContrato(procesobanconominaDataAccess.getTipoContrato(connexion,procesobanconomina));
		procesobanconomina.setTipoBancoDisco(procesobanconominaDataAccess.getTipoBancoDisco(connexion,procesobanconomina));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				procesobanconomina.setBanco(procesobanconominaDataAccess.getBanco(connexion,procesobanconomina));
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				procesobanconomina.setCuentaBanco(procesobanconominaDataAccess.getCuentaBanco(connexion,procesobanconomina));
			}

			if(clas.clas.equals(TipoContrato.class)) {
				procesobanconomina.setTipoContrato(procesobanconominaDataAccess.getTipoContrato(connexion,procesobanconomina));
			}

			if(clas.clas.equals(TipoBancoDisco.class)) {
				procesobanconomina.setTipoBancoDisco(procesobanconominaDataAccess.getTipoBancoDisco(connexion,procesobanconomina));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesobanconomina.setBanco(procesobanconominaDataAccess.getBanco(connexion,procesobanconomina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesobanconomina.setCuentaBanco(procesobanconominaDataAccess.getCuentaBanco(connexion,procesobanconomina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesobanconomina.setTipoContrato(procesobanconominaDataAccess.getTipoContrato(connexion,procesobanconomina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoBancoDisco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesobanconomina.setTipoBancoDisco(procesobanconominaDataAccess.getTipoBancoDisco(connexion,procesobanconomina));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesobanconomina.setBanco(procesobanconominaDataAccess.getBanco(connexion,procesobanconomina));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(procesobanconomina.getBanco(),isDeep,deepLoadType,clases);
				
		procesobanconomina.setCuentaBanco(procesobanconominaDataAccess.getCuentaBanco(connexion,procesobanconomina));
		CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
		cuentabancoLogic.deepLoad(procesobanconomina.getCuentaBanco(),isDeep,deepLoadType,clases);
				
		procesobanconomina.setTipoContrato(procesobanconominaDataAccess.getTipoContrato(connexion,procesobanconomina));
		TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
		tipocontratoLogic.deepLoad(procesobanconomina.getTipoContrato(),isDeep,deepLoadType,clases);
				
		procesobanconomina.setTipoBancoDisco(procesobanconominaDataAccess.getTipoBancoDisco(connexion,procesobanconomina));
		TipoBancoDiscoLogic tipobancodiscoLogic= new TipoBancoDiscoLogic(connexion);
		tipobancodiscoLogic.deepLoad(procesobanconomina.getTipoBancoDisco(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				procesobanconomina.setBanco(procesobanconominaDataAccess.getBanco(connexion,procesobanconomina));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(procesobanconomina.getBanco(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				procesobanconomina.setCuentaBanco(procesobanconominaDataAccess.getCuentaBanco(connexion,procesobanconomina));
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepLoad(procesobanconomina.getCuentaBanco(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoContrato.class)) {
				procesobanconomina.setTipoContrato(procesobanconominaDataAccess.getTipoContrato(connexion,procesobanconomina));
				TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
				tipocontratoLogic.deepLoad(procesobanconomina.getTipoContrato(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoBancoDisco.class)) {
				procesobanconomina.setTipoBancoDisco(procesobanconominaDataAccess.getTipoBancoDisco(connexion,procesobanconomina));
				TipoBancoDiscoLogic tipobancodiscoLogic= new TipoBancoDiscoLogic(connexion);
				tipobancodiscoLogic.deepLoad(procesobanconomina.getTipoBancoDisco(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesobanconomina.setBanco(procesobanconominaDataAccess.getBanco(connexion,procesobanconomina));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(procesobanconomina.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesobanconomina.setCuentaBanco(procesobanconominaDataAccess.getCuentaBanco(connexion,procesobanconomina));
			CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
			cuentabancoLogic.deepLoad(procesobanconomina.getCuentaBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesobanconomina.setTipoContrato(procesobanconominaDataAccess.getTipoContrato(connexion,procesobanconomina));
			TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
			tipocontratoLogic.deepLoad(procesobanconomina.getTipoContrato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoBancoDisco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesobanconomina.setTipoBancoDisco(procesobanconominaDataAccess.getTipoBancoDisco(connexion,procesobanconomina));
			TipoBancoDiscoLogic tipobancodiscoLogic= new TipoBancoDiscoLogic(connexion);
			tipobancodiscoLogic.deepLoad(procesobanconomina.getTipoBancoDisco(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesobanconomina,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoBancoNominaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoBancoNomina(procesobanconomina);
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
			this.deepLoad(this.procesobanconomina,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoBancoNominaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoBancoNomina(this.procesobanconomina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesobanconominas!=null) {
				for(ProcesoBancoNomina procesobanconomina:procesobanconominas) {
					this.deepLoad(procesobanconomina,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoBancoNominaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoBancoNomina(procesobanconominas);
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
			if(procesobanconominas!=null) {
				for(ProcesoBancoNomina procesobanconomina:procesobanconominas) {
					this.deepLoad(procesobanconomina,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoBancoNominaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoBancoNomina(procesobanconominas);
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
	
	public ProcesoBancoNominaParameterReturnGeneral procesarAccionProcesoBancoNominas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoBancoNomina> procesobanconominas,ProcesoBancoNominaParameterReturnGeneral procesobanconominaParameterGeneral)throws Exception {
		 try {	
			ProcesoBancoNominaParameterReturnGeneral procesobanconominaReturnGeneral=new ProcesoBancoNominaParameterReturnGeneral();
	
			ProcesoBancoNominaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesobanconominas,procesobanconominaParameterGeneral,procesobanconominaReturnGeneral);
			
			return procesobanconominaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoBancoNominaParameterReturnGeneral procesarAccionProcesoBancoNominasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoBancoNomina> procesobanconominas,ProcesoBancoNominaParameterReturnGeneral procesobanconominaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoBancoNominaParameterReturnGeneral procesobanconominaReturnGeneral=new ProcesoBancoNominaParameterReturnGeneral();
	
			ProcesoBancoNominaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesobanconominas,procesobanconominaParameterGeneral,procesobanconominaReturnGeneral);
			
			this.connexion.commit();
			
			return procesobanconominaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoBancoNomina> procesobanconominas,String sTipoBusqueda,Long id_bancoBusquedaProcesoBancoNomina,Long id_cuenta_bancoBusquedaProcesoBancoNomina,Long id_tipo_contratoBusquedaProcesoBancoNomina,Long id_tipo_banco_discoBusquedaProcesoBancoNomina,Boolean con_otrosBusquedaProcesoBancoNomina,Boolean con_internetBusquedaProcesoBancoNomina,Date fechaBusquedaProcesoBancoNomina,Integer numero_secuencialesBusquedaProcesoBancoNomina,Boolean genera_textoBusquedaProcesoBancoNomina,Boolean genera_excelBusquedaProcesoBancoNomina) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoBancoNominaLogicAdditional procesobanconominaLogicAdditional=new ProcesoBancoNominaLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesobanconominaLogicAdditional.setConnexion(this.connexion);

			procesobanconominaLogicAdditional.ProcesarInformacionProcesoBancoNomina(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesobanconominas,sTipoBusqueda,id_bancoBusquedaProcesoBancoNomina,id_cuenta_bancoBusquedaProcesoBancoNomina,id_tipo_contratoBusquedaProcesoBancoNomina,id_tipo_banco_discoBusquedaProcesoBancoNomina,con_otrosBusquedaProcesoBancoNomina,con_internetBusquedaProcesoBancoNomina,fechaBusquedaProcesoBancoNomina,numero_secuencialesBusquedaProcesoBancoNomina,genera_textoBusquedaProcesoBancoNomina,genera_excelBusquedaProcesoBancoNomina);

			//this.connexion.commit();
		} catch(Exception e) {
			//this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			//this.connexion.close();
		}

		return procesado;
	}

	
}

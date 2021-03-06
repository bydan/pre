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
import com.bydan.erp.contabilidad.util.report.DiarioGeneralParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.DiarioGeneralParameterGeneral;
import com.bydan.erp.contabilidad.util.report.DiarioGeneralConstantesFunciones;
import com.bydan.erp.contabilidad.business.entity.report.DiarioGeneral;

import com.bydan.erp.contabilidad.business.logic.report.DiarioGeneralLogicAdditional;
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
public class DiarioGeneralLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(DiarioGeneralLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected DiarioGeneralLogic diariogeneralDataAccess; 		
	protected DiarioGeneral diariogeneral;
	protected List<DiarioGeneral> diariogenerals;
	protected Object diariogeneralObject;	
	protected List<Object> diariogeneralsObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  DiarioGeneralLogic()throws SQLException,Exception {
		try	{
			this.diariogenerals= new ArrayList<DiarioGeneral>();
			this.diariogeneral= new DiarioGeneral();
			this.diariogeneralObject=new Object();
			this.diariogeneralsObject=new ArrayList<Object>();
			
			this.diariogeneralDataAccess=this;
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
			this.diariogeneralDataAccess.setConnexionType(this.connexionType);
			this.diariogeneralDataAccess.setParameterDbType(this.parameterDbType);
			this.diariogeneralDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DiarioGeneralLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.diariogenerals= new ArrayList<DiarioGeneral>();
			this.diariogeneral= new DiarioGeneral();
			this.diariogeneralObject=new Object();
			this.diariogeneralsObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.diariogeneralDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.diariogeneralDataAccess.setConnexionType(this.connexionType);
			this.diariogeneralDataAccess.setParameterDbType(this.parameterDbType);
			this.diariogeneralDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DiarioGeneral getDiarioGeneral() throws Exception {	
		DiarioGeneralLogicAdditional.checkDiarioGeneralToGet(diariogeneral,this.datosCliente,this.arrDatoGeneral);
		DiarioGeneralLogicAdditional.updateDiarioGeneralToGet(diariogeneral,this.arrDatoGeneral);
		
		return diariogeneral;
	}
		
	public void setDiarioGeneral(DiarioGeneral newDiarioGeneral) {
		this.diariogeneral = newDiarioGeneral;
	}
	
	public List<DiarioGeneral> getDiarioGenerals() throws Exception {		
		this.quitarDiarioGeneralsNulos();
		
		DiarioGeneralLogicAdditional.checkDiarioGeneralToGets(diariogenerals,this.datosCliente,this.arrDatoGeneral);
		
		for (DiarioGeneral diariogeneralLocal: diariogenerals ) {
			DiarioGeneralLogicAdditional.updateDiarioGeneralToGet(diariogeneralLocal,this.arrDatoGeneral);
		}
		
		return diariogenerals;
	}
	
	public void setDiarioGenerals(List<DiarioGeneral> newDiarioGenerals) {
		this.diariogenerals = newDiarioGenerals;
	}
	
	public Object getDiarioGeneralObject() {	
		//this.diariogeneralObject=this.diariogeneralDataAccess.getEntityObject();
		return this.diariogeneralObject;
	}
		
	public void setDiarioGeneralObject(Object newDiarioGeneralObject) {
		this.diariogeneralObject = newDiarioGeneralObject;
	}
	
	public List<Object> getDiarioGeneralsObject() {		
		//this.diariogeneralsObject=this.diariogeneralDataAccess.getEntitiesObject();
		return this.diariogeneralsObject;
	}
		
	public void setDiarioGeneralsObject(List<Object> newDiarioGeneralsObject) {
		this.diariogeneralsObject = newDiarioGeneralsObject;
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
		diariogenerals = new  ArrayList<DiarioGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiarioGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		diariogenerals = new  ArrayList<DiarioGeneral>();
		  		  
        try {
			//DiarioGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		diariogenerals = new  ArrayList<DiarioGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiarioGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		diariogenerals = new  ArrayList<DiarioGeneral>();
		  		  
        try {
			//DiarioGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		diariogenerals = new  ArrayList<DiarioGeneral>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiarioGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		diariogenerals = new  ArrayList<DiarioGeneral>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//DiarioGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<DiarioGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiarioGeneral> entities = new  ArrayList<DiarioGeneral>();
		DiarioGeneral entity = new DiarioGeneral();		  
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
	
	public  List<DiarioGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiarioGeneral> entities = new  ArrayList<DiarioGeneral>();
		DiarioGeneral entity = new DiarioGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DiarioGeneral();
				
				
      	    	entity=DiarioGeneralLogic.getEntityDiarioGeneral("",entity,resultSet);
      	    	
				//entity.setDiarioGeneralOriginal( new DiarioGeneral());
      	    	//entity.setDiarioGeneralOriginal(super.getEntity("",entity.getDiarioGeneralOriginal(),resultSet,DiarioGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDiarioGeneralOriginal(DiarioGeneralDataAccess.getEntityDiarioGeneral("",entity.getDiarioGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<DiarioGeneral> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiarioGeneral> entities = new  ArrayList<DiarioGeneral>();
		DiarioGeneral entity = new DiarioGeneral();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,DiarioGeneral.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DiarioGeneral>((List<DiarioGeneral>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDiarioGeneralsOriginal(entities);
			
			}  else {
				this.diariogeneralsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DiarioGeneralConstantesFunciones.quitarEspaciosDiarioGenerals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static DiarioGeneral getEntityDiarioGeneral(String strPrefijo,DiarioGeneral entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_asiento_contable(resultSet.getLong(strPrefijo+DiarioGeneralConstantesFunciones.IDASIENTOCONTABLE));
			entity.settipo_movimiento(resultSet.getString(strPrefijo+DiarioGeneralConstantesFunciones.TIPOMOVIMIENTO));
			entity.setnumero_mayor(resultSet.getString(strPrefijo+DiarioGeneralConstantesFunciones.NUMEROMAYOR));
			entity.setcodigo(resultSet.getString(strPrefijo+DiarioGeneralConstantesFunciones.CODIGO));
			entity.setnombre(resultSet.getString(strPrefijo+DiarioGeneralConstantesFunciones.NOMBRE));
			entity.setcodigo_asiento(resultSet.getString(strPrefijo+DiarioGeneralConstantesFunciones.CODIGOASIENTO));
			entity.setdebito_local(resultSet.getDouble(strPrefijo+DiarioGeneralConstantesFunciones.DEBITOLOCAL));
			entity.setcredito_local(resultSet.getDouble(strPrefijo+DiarioGeneralConstantesFunciones.CREDITOLOCAL));
			entity.setdebito_extran(resultSet.getDouble(strPrefijo+DiarioGeneralConstantesFunciones.DEBITOEXTRAN));
			entity.setcredito_extran(resultSet.getDouble(strPrefijo+DiarioGeneralConstantesFunciones.CREDITOEXTRAN));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+DiarioGeneralConstantesFunciones.FECHA).getTime()));
			entity.setdetalle(resultSet.getString(strPrefijo+DiarioGeneralConstantesFunciones.DETALLE));
			entity.setnombre_estado(resultSet.getString(strPrefijo+DiarioGeneralConstantesFunciones.NOMBREESTADO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DiarioGeneral getEntityDiarioGeneral(String strPrefijo,DiarioGeneral entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = DiarioGeneral.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = DiarioGeneral.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				DiarioGeneralLogic.setFieldReflectionDiarioGeneral(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDiarioGeneral(Field field,String strPrefijo,String sColumn,DiarioGeneral entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DiarioGeneralConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.TIPOMOVIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.CODIGOASIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.DEBITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.CREDITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.DEBITOEXTRAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.CREDITOEXTRAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DiarioGeneralConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DiarioGeneralConstantesFunciones.NOMBREESTADO:
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
	
	public void quitarDiarioGeneralsNulos() throws Exception {				
		
		List<DiarioGeneral> diariogeneralsAux= new ArrayList<DiarioGeneral>();
		
		for(DiarioGeneral diariogeneral:diariogenerals) {
			if(diariogeneral!=null) {
				diariogeneralsAux.add(diariogeneral);
			}
		}
		
		diariogenerals=diariogeneralsAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<DiarioGeneral> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DiarioGeneral> entities = new  ArrayList<DiarioGeneral>();
		DiarioGeneral entity = new DiarioGeneral();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<DiarioGeneral>((List<DiarioGeneral>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setDiarioGeneralsOriginal(entities);
			
			}  else {
				this.diariogeneralsObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//DiarioGeneralConstantesFunciones.quitarEspaciosDiarioGenerals(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		diariogenerals = new  ArrayList<DiarioGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//DiarioGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		diariogenerals = new  ArrayList<DiarioGeneral>();
		  		  
        try {
			//DiarioGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diariogenerals=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<DiarioGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DiarioGeneral> entities = new  ArrayList<DiarioGeneral>();
		DiarioGeneral entity = new DiarioGeneral();		  
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
	
	public  List<DiarioGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<DiarioGeneral> entities = new  ArrayList<DiarioGeneral>();
		DiarioGeneral entity = new DiarioGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DiarioGeneral();
				
				if(conMapGenerico) {
					entity.setMapDiarioGeneral( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapDiarioGeneral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DiarioGeneralDataAccess.ISWITHSCHEMA);         		
					entity=DiarioGeneralLogic.getEntityDiarioGeneral("",entity,resultSet,listColumns);
					
					////entity.setDiarioGeneralOriginal( new DiarioGeneral());
					////entity.setDiarioGeneralOriginal(super.getEntity("",entity.getDiarioGeneralOriginal(),resultSet,DiarioGeneralDataAccess.ISWITHSCHEMA));         		
					////entity.setDiarioGeneralOriginal(DiarioGeneralDataAccess.getEntityDiarioGeneral("",entity.getDiarioGeneralOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,DiarioGeneral reldiariogeneral)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reldiariogeneral.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DiarioGeneral reldiariogeneral)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,reldiariogeneral.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DiarioGeneral reldiariogeneral)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldiariogeneral.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DiarioGeneral reldiariogeneral)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);
			periodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periodo=periodoDataAccess.getEntity(connexion,reldiariogeneral.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Modulo getModulo(Connexion connexion,DiarioGeneral reldiariogeneral)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);
			moduloDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			modulo=moduloDataAccess.getEntity(connexion,reldiariogeneral.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,DiarioGeneral reldiariogeneral)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);
			tipomovimientoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,reldiariogeneral.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,DiarioGeneral reldiariogeneral)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);
			tipodocumentoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,reldiariogeneral.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public AsientoContable getAsientoContable(Connexion connexion,DiarioGeneral reldiariogeneral)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			asientocontableDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			asientocontable=asientocontableDataAccess.getEntity(connexion,reldiariogeneral.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}


	
	
	public void getDiarioGeneralsBusquedaReporteWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_modulo,Long id_tipo_movimiento,Long id_tipo_documento,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//DiarioGeneralLogic diariogeneralLogic=new DiarioGeneralLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DiarioGeneralLogic.GetSelecSqlDiarioGeneralBusquedaReporte(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_modulo,id_tipo_movimiento,id_tipo_documento,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.diariogenerals=this.getDiarioGenerals();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getDiarioGeneralsBusquedaReporte(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_modulo,Long id_tipo_movimiento,Long id_tipo_documento,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//DiarioGeneralLogic diariogeneralLogic=new DiarioGeneralLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=DiarioGeneralLogic.GetSelecSqlDiarioGeneralBusquedaReporte(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_modulo,id_tipo_movimiento,id_tipo_documento,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.diariogenerals=this.getDiarioGenerals();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlDiarioGeneralBusquedaReporte(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_modulo,Long id_tipo_movimiento,Long id_tipo_documento,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("DiarioGeneral_Postgres.sql");
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

				if(id_modulo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_modulo = "+id_modulo.toString();
					existeWhere=true;
				}

				if(id_tipo_movimiento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_tipo_movimiento = "+id_tipo_movimiento.toString();
					existeWhere=true;
				}

				if(id_tipo_documento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.id_tipo_documento = "+id_tipo_documento.toString();
					existeWhere=true;
				}

				if(fecha_inicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" a.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_inicio)+"'";
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
	
	
	public void deepLoad(DiarioGeneral diariogeneral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DiarioGeneralLogicAdditional.updateDiarioGeneralToGet(diariogeneral,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		diariogeneral.setEmpresa(diariogeneralDataAccess.getEmpresa(connexion,diariogeneral));
		diariogeneral.setSucursal(diariogeneralDataAccess.getSucursal(connexion,diariogeneral));
		diariogeneral.setEjercicio(diariogeneralDataAccess.getEjercicio(connexion,diariogeneral));
		diariogeneral.setPeriodo(diariogeneralDataAccess.getPeriodo(connexion,diariogeneral));
		diariogeneral.setModulo(diariogeneralDataAccess.getModulo(connexion,diariogeneral));
		diariogeneral.setTipoMovimiento(diariogeneralDataAccess.getTipoMovimiento(connexion,diariogeneral));
		diariogeneral.setTipoDocumento(diariogeneralDataAccess.getTipoDocumento(connexion,diariogeneral));
		diariogeneral.setAsientoContable(diariogeneralDataAccess.getAsientoContable(connexion,diariogeneral));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				diariogeneral.setEmpresa(diariogeneralDataAccess.getEmpresa(connexion,diariogeneral));
			}

			if(clas.clas.equals(Sucursal.class)) {
				diariogeneral.setSucursal(diariogeneralDataAccess.getSucursal(connexion,diariogeneral));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				diariogeneral.setEjercicio(diariogeneralDataAccess.getEjercicio(connexion,diariogeneral));
			}

			if(clas.clas.equals(Periodo.class)) {
				diariogeneral.setPeriodo(diariogeneralDataAccess.getPeriodo(connexion,diariogeneral));
			}

			if(clas.clas.equals(Modulo.class)) {
				diariogeneral.setModulo(diariogeneralDataAccess.getModulo(connexion,diariogeneral));
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				diariogeneral.setTipoMovimiento(diariogeneralDataAccess.getTipoMovimiento(connexion,diariogeneral));
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				diariogeneral.setTipoDocumento(diariogeneralDataAccess.getTipoDocumento(connexion,diariogeneral));
			}

			if(clas.clas.equals(AsientoContable.class)) {
				diariogeneral.setAsientoContable(diariogeneralDataAccess.getAsientoContable(connexion,diariogeneral));
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
			diariogeneral.setEmpresa(diariogeneralDataAccess.getEmpresa(connexion,diariogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setSucursal(diariogeneralDataAccess.getSucursal(connexion,diariogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setEjercicio(diariogeneralDataAccess.getEjercicio(connexion,diariogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setPeriodo(diariogeneralDataAccess.getPeriodo(connexion,diariogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setModulo(diariogeneralDataAccess.getModulo(connexion,diariogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setTipoMovimiento(diariogeneralDataAccess.getTipoMovimiento(connexion,diariogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setTipoDocumento(diariogeneralDataAccess.getTipoDocumento(connexion,diariogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setAsientoContable(diariogeneralDataAccess.getAsientoContable(connexion,diariogeneral));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		diariogeneral.setEmpresa(diariogeneralDataAccess.getEmpresa(connexion,diariogeneral));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(diariogeneral.getEmpresa(),isDeep,deepLoadType,clases);
				
		diariogeneral.setSucursal(diariogeneralDataAccess.getSucursal(connexion,diariogeneral));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(diariogeneral.getSucursal(),isDeep,deepLoadType,clases);
				
		diariogeneral.setEjercicio(diariogeneralDataAccess.getEjercicio(connexion,diariogeneral));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(diariogeneral.getEjercicio(),isDeep,deepLoadType,clases);
				
		diariogeneral.setPeriodo(diariogeneralDataAccess.getPeriodo(connexion,diariogeneral));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(diariogeneral.getPeriodo(),isDeep,deepLoadType,clases);
				
		diariogeneral.setModulo(diariogeneralDataAccess.getModulo(connexion,diariogeneral));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(diariogeneral.getModulo(),isDeep,deepLoadType,clases);
				
		diariogeneral.setTipoMovimiento(diariogeneralDataAccess.getTipoMovimiento(connexion,diariogeneral));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(diariogeneral.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		diariogeneral.setTipoDocumento(diariogeneralDataAccess.getTipoDocumento(connexion,diariogeneral));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(diariogeneral.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		diariogeneral.setAsientoContable(diariogeneralDataAccess.getAsientoContable(connexion,diariogeneral));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(diariogeneral.getAsientoContable(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				diariogeneral.setEmpresa(diariogeneralDataAccess.getEmpresa(connexion,diariogeneral));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(diariogeneral.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				diariogeneral.setSucursal(diariogeneralDataAccess.getSucursal(connexion,diariogeneral));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(diariogeneral.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				diariogeneral.setEjercicio(diariogeneralDataAccess.getEjercicio(connexion,diariogeneral));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(diariogeneral.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Periodo.class)) {
				diariogeneral.setPeriodo(diariogeneralDataAccess.getPeriodo(connexion,diariogeneral));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(diariogeneral.getPeriodo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Modulo.class)) {
				diariogeneral.setModulo(diariogeneralDataAccess.getModulo(connexion,diariogeneral));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(diariogeneral.getModulo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				diariogeneral.setTipoMovimiento(diariogeneralDataAccess.getTipoMovimiento(connexion,diariogeneral));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(diariogeneral.getTipoMovimiento(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				diariogeneral.setTipoDocumento(diariogeneralDataAccess.getTipoDocumento(connexion,diariogeneral));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(diariogeneral.getTipoDocumento(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(AsientoContable.class)) {
				diariogeneral.setAsientoContable(diariogeneralDataAccess.getAsientoContable(connexion,diariogeneral));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(diariogeneral.getAsientoContable(),isDeep,deepLoadType,clases);				
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
			diariogeneral.setEmpresa(diariogeneralDataAccess.getEmpresa(connexion,diariogeneral));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(diariogeneral.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setSucursal(diariogeneralDataAccess.getSucursal(connexion,diariogeneral));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(diariogeneral.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setEjercicio(diariogeneralDataAccess.getEjercicio(connexion,diariogeneral));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(diariogeneral.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setPeriodo(diariogeneralDataAccess.getPeriodo(connexion,diariogeneral));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(diariogeneral.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setModulo(diariogeneralDataAccess.getModulo(connexion,diariogeneral));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(diariogeneral.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setTipoMovimiento(diariogeneralDataAccess.getTipoMovimiento(connexion,diariogeneral));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(diariogeneral.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setTipoDocumento(diariogeneralDataAccess.getTipoDocumento(connexion,diariogeneral));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(diariogeneral.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diariogeneral.setAsientoContable(diariogeneralDataAccess.getAsientoContable(connexion,diariogeneral));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(diariogeneral.getAsientoContable(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(diariogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DiarioGeneralConstantesFunciones.refrescarForeignKeysDescripcionesDiarioGeneral(diariogeneral);
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
			this.deepLoad(this.diariogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DiarioGeneralConstantesFunciones.refrescarForeignKeysDescripcionesDiarioGeneral(this.diariogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(diariogenerals!=null) {
				for(DiarioGeneral diariogeneral:diariogenerals) {
					this.deepLoad(diariogeneral,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DiarioGeneralConstantesFunciones.refrescarForeignKeysDescripcionesDiarioGeneral(diariogenerals);
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
			if(diariogenerals!=null) {
				for(DiarioGeneral diariogeneral:diariogenerals) {
					this.deepLoad(diariogeneral,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DiarioGeneralConstantesFunciones.refrescarForeignKeysDescripcionesDiarioGeneral(diariogenerals);
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
	
	public DiarioGeneralParameterReturnGeneral procesarAccionDiarioGenerals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DiarioGeneral> diariogenerals,DiarioGeneralParameterReturnGeneral diariogeneralParameterGeneral)throws Exception {
		 try {	
			DiarioGeneralParameterReturnGeneral diariogeneralReturnGeneral=new DiarioGeneralParameterReturnGeneral();
	
			DiarioGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,diariogenerals,diariogeneralParameterGeneral,diariogeneralReturnGeneral);
			
			return diariogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DiarioGeneralParameterReturnGeneral procesarAccionDiarioGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DiarioGeneral> diariogenerals,DiarioGeneralParameterReturnGeneral diariogeneralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			DiarioGeneralParameterReturnGeneral diariogeneralReturnGeneral=new DiarioGeneralParameterReturnGeneral();
	
			DiarioGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,diariogenerals,diariogeneralParameterGeneral,diariogeneralReturnGeneral);
			
			this.connexion.commit();
			
			return diariogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

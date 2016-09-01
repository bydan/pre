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
package com.bydan.erp.sris.business.logic.report;

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

import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.resources.general.AuxiliarGeneral;
import com.bydan.erp.sris.util.report.GuardarIvasVentasParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.GuardarIvasVentasParameterGeneral;
import com.bydan.erp.sris.util.report.GuardarIvasVentasConstantesFunciones;
import com.bydan.erp.sris.business.entity.report.GuardarIvasVentas;

import com.bydan.erp.sris.business.logic.report.GuardarIvasVentasLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;






@SuppressWarnings("unused")
public class GuardarIvasVentasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(GuardarIvasVentasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected GuardarIvasVentasLogic guardarivasventasDataAccess; 		
	protected GuardarIvasVentas guardarivasventas;
	protected List<GuardarIvasVentas> guardarivasventass;
	protected Object guardarivasventasObject;	
	protected List<Object> guardarivasventassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  GuardarIvasVentasLogic()throws SQLException,Exception {
		try	{
			this.guardarivasventass= new ArrayList<GuardarIvasVentas>();
			this.guardarivasventas= new GuardarIvasVentas();
			this.guardarivasventasObject=new Object();
			this.guardarivasventassObject=new ArrayList<Object>();
			
			this.guardarivasventasDataAccess=this;
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
			this.guardarivasventasDataAccess.setConnexionType(this.connexionType);
			this.guardarivasventasDataAccess.setParameterDbType(this.parameterDbType);
			this.guardarivasventasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GuardarIvasVentasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.guardarivasventass= new ArrayList<GuardarIvasVentas>();
			this.guardarivasventas= new GuardarIvasVentas();
			this.guardarivasventasObject=new Object();
			this.guardarivasventassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.guardarivasventasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.guardarivasventasDataAccess.setConnexionType(this.connexionType);
			this.guardarivasventasDataAccess.setParameterDbType(this.parameterDbType);
			this.guardarivasventasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GuardarIvasVentas getGuardarIvasVentas() throws Exception {	
		GuardarIvasVentasLogicAdditional.checkGuardarIvasVentasToGet(guardarivasventas,this.datosCliente,this.arrDatoGeneral);
		GuardarIvasVentasLogicAdditional.updateGuardarIvasVentasToGet(guardarivasventas,this.arrDatoGeneral);
		
		return guardarivasventas;
	}
		
	public void setGuardarIvasVentas(GuardarIvasVentas newGuardarIvasVentas) {
		this.guardarivasventas = newGuardarIvasVentas;
	}
	
	public List<GuardarIvasVentas> getGuardarIvasVentass() throws Exception {		
		this.quitarGuardarIvasVentassNulos();
		
		GuardarIvasVentasLogicAdditional.checkGuardarIvasVentasToGets(guardarivasventass,this.datosCliente,this.arrDatoGeneral);
		
		for (GuardarIvasVentas guardarivasventasLocal: guardarivasventass ) {
			GuardarIvasVentasLogicAdditional.updateGuardarIvasVentasToGet(guardarivasventasLocal,this.arrDatoGeneral);
		}
		
		return guardarivasventass;
	}
	
	public void setGuardarIvasVentass(List<GuardarIvasVentas> newGuardarIvasVentass) {
		this.guardarivasventass = newGuardarIvasVentass;
	}
	
	public Object getGuardarIvasVentasObject() {	
		//this.guardarivasventasObject=this.guardarivasventasDataAccess.getEntityObject();
		return this.guardarivasventasObject;
	}
		
	public void setGuardarIvasVentasObject(Object newGuardarIvasVentasObject) {
		this.guardarivasventasObject = newGuardarIvasVentasObject;
	}
	
	public List<Object> getGuardarIvasVentassObject() {		
		//this.guardarivasventassObject=this.guardarivasventasDataAccess.getEntitiesObject();
		return this.guardarivasventassObject;
	}
		
	public void setGuardarIvasVentassObject(List<Object> newGuardarIvasVentassObject) {
		this.guardarivasventassObject = newGuardarIvasVentassObject;
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
		guardarivasventass = new  ArrayList<GuardarIvasVentas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//GuardarIvasVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guardarivasventass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		guardarivasventass = new  ArrayList<GuardarIvasVentas>();
		  		  
        try {
			//GuardarIvasVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guardarivasventass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		guardarivasventass = new  ArrayList<GuardarIvasVentas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//GuardarIvasVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guardarivasventass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		guardarivasventass = new  ArrayList<GuardarIvasVentas>();
		  		  
        try {
			//GuardarIvasVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guardarivasventass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		guardarivasventass = new  ArrayList<GuardarIvasVentas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//GuardarIvasVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guardarivasventass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		guardarivasventass = new  ArrayList<GuardarIvasVentas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//GuardarIvasVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guardarivasventass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<GuardarIvasVentas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GuardarIvasVentas> entities = new  ArrayList<GuardarIvasVentas>();
		GuardarIvasVentas entity = new GuardarIvasVentas();		  
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
	
	public  List<GuardarIvasVentas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GuardarIvasVentas> entities = new  ArrayList<GuardarIvasVentas>();
		GuardarIvasVentas entity = new GuardarIvasVentas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GuardarIvasVentas();
				
				
      	    	entity=GuardarIvasVentasLogic.getEntityGuardarIvasVentas("",entity,resultSet);
      	    	
				//entity.setGuardarIvasVentasOriginal( new GuardarIvasVentas());
      	    	//entity.setGuardarIvasVentasOriginal(super.getEntity("",entity.getGuardarIvasVentasOriginal(),resultSet,GuardarIvasVentasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGuardarIvasVentasOriginal(GuardarIvasVentasDataAccess.getEntityGuardarIvasVentas("",entity.getGuardarIvasVentasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<GuardarIvasVentas> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GuardarIvasVentas> entities = new  ArrayList<GuardarIvasVentas>();
		GuardarIvasVentas entity = new GuardarIvasVentas();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,GuardarIvasVentas.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<GuardarIvasVentas>((List<GuardarIvasVentas>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setGuardarIvasVentassOriginal(entities);
			
			}  else {
				this.guardarivasventassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//GuardarIvasVentasConstantesFunciones.quitarEspaciosGuardarIvasVentass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static GuardarIvasVentas getEntityGuardarIvasVentas(String strPrefijo,GuardarIvasVentas entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_estado_asiento_contable(resultSet.getString(strPrefijo+GuardarIvasVentasConstantesFunciones.CODIGOESTADOASIENTOCONTABLE));
			entity.setnombre_periodo(resultSet.getString(strPrefijo+GuardarIvasVentasConstantesFunciones.NOMBREPERIODO));
			entity.setnombre_tipo_retencion_fuente_iva(resultSet.getString(strPrefijo+GuardarIvasVentasConstantesFunciones.NOMBRETIPORETENCIONFUENTEIVA));
			entity.setporcentaje(resultSet.getDouble(strPrefijo+GuardarIvasVentasConstantesFunciones.PORCENTAJE));
			entity.setbase_imponible(resultSet.getDouble(strPrefijo+GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE));
			entity.setvalor(resultSet.getDouble(strPrefijo+GuardarIvasVentasConstantesFunciones.VALOR));
			entity.setnumero(resultSet.getString(strPrefijo+GuardarIvasVentasConstantesFunciones.NUMERO));
			entity.setruc_benef(resultSet.getString(strPrefijo+GuardarIvasVentasConstantesFunciones.RUCBENEF));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static GuardarIvasVentas getEntityGuardarIvasVentas(String strPrefijo,GuardarIvasVentas entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = GuardarIvasVentas.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = GuardarIvasVentas.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				GuardarIvasVentasLogic.setFieldReflectionGuardarIvasVentas(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionGuardarIvasVentas(Field field,String strPrefijo,String sColumn,GuardarIvasVentas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case GuardarIvasVentasConstantesFunciones.CODIGOESTADOASIENTOCONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuardarIvasVentasConstantesFunciones.NOMBREPERIODO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuardarIvasVentasConstantesFunciones.NOMBRETIPORETENCIONFUENTEIVA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuardarIvasVentasConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuardarIvasVentasConstantesFunciones.BASEIMPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuardarIvasVentasConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GuardarIvasVentasConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GuardarIvasVentasConstantesFunciones.RUCBENEF:
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
	
	public void quitarGuardarIvasVentassNulos() throws Exception {				
		
		List<GuardarIvasVentas> guardarivasventassAux= new ArrayList<GuardarIvasVentas>();
		
		for(GuardarIvasVentas guardarivasventas:guardarivasventass) {
			if(guardarivasventas!=null) {
				guardarivasventassAux.add(guardarivasventas);
			}
		}
		
		guardarivasventass=guardarivasventassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<GuardarIvasVentas> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GuardarIvasVentas> entities = new  ArrayList<GuardarIvasVentas>();
		GuardarIvasVentas entity = new GuardarIvasVentas();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<GuardarIvasVentas>((List<GuardarIvasVentas>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setGuardarIvasVentassOriginal(entities);
			
			}  else {
				this.guardarivasventassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//GuardarIvasVentasConstantesFunciones.quitarEspaciosGuardarIvasVentass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		guardarivasventass = new  ArrayList<GuardarIvasVentas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//GuardarIvasVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guardarivasventass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		guardarivasventass = new  ArrayList<GuardarIvasVentas>();
		  		  
        try {
			//GuardarIvasVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guardarivasventass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<GuardarIvasVentas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<GuardarIvasVentas> entities = new  ArrayList<GuardarIvasVentas>();
		GuardarIvasVentas entity = new GuardarIvasVentas();		  
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
	
	public  List<GuardarIvasVentas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<GuardarIvasVentas> entities = new  ArrayList<GuardarIvasVentas>();
		GuardarIvasVentas entity = new GuardarIvasVentas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GuardarIvasVentas();
				
				if(conMapGenerico) {
					entity.setMapGuardarIvasVentas( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapGuardarIvasVentas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GuardarIvasVentasDataAccess.ISWITHSCHEMA);         		
					entity=GuardarIvasVentasLogic.getEntityGuardarIvasVentas("",entity,resultSet,listColumns);
					
					////entity.setGuardarIvasVentasOriginal( new GuardarIvasVentas());
					////entity.setGuardarIvasVentasOriginal(super.getEntity("",entity.getGuardarIvasVentasOriginal(),resultSet,GuardarIvasVentasDataAccess.ISWITHSCHEMA));         		
					////entity.setGuardarIvasVentasOriginal(GuardarIvasVentasDataAccess.getEntityGuardarIvasVentas("",entity.getGuardarIvasVentasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,GuardarIvasVentas relguardarivasventas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relguardarivasventas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,GuardarIvasVentas relguardarivasventas)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);
			ejercicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relguardarivasventas.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,GuardarIvasVentas relguardarivasventas)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);
			periodoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			periodo=periodoDataAccess.getEntity(connexion,relguardarivasventas.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public TipoRetencion getTipoRetencionFuenteIva(Connexion connexion,GuardarIvasVentas relguardarivasventas)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);
			tiporetencionDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relguardarivasventas.getid_tipo_retencion_fuente_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}


	
	
	public void getGuardarIvasVentassBusquedaGuardarIvasVentasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_tipo_retencion_fuente_iva)throws Exception {
		try {
			//GuardarIvasVentasLogic guardarivasventasLogic=new GuardarIvasVentasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=GuardarIvasVentasLogic.GetSelecSqlGuardarIvasVentas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_tipo_retencion_fuente_iva);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.guardarivasventass=this.getGuardarIvasVentass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getGuardarIvasVentassBusquedaGuardarIvasVentas(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_tipo_retencion_fuente_iva)throws Exception {
		try {
			//GuardarIvasVentasLogic guardarivasventasLogic=new GuardarIvasVentasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=GuardarIvasVentasLogic.GetSelecSqlGuardarIvasVentas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_ejercicio,id_periodo,id_tipo_retencion_fuente_iva);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.guardarivasventass=this.getGuardarIvasVentass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlGuardarIvasVentas(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_ejercicio,Long id_periodo,Long id_tipo_retencion_fuente_iva)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("GuardarIvasVentas_Postgres.sql");
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
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" a.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
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

				if(id_tipo_retencion_fuente_iva!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" r.id_tipo_retencion_fuente_iva = "+id_tipo_retencion_fuente_iva.toString();
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
	
	
	public void deepLoad(GuardarIvasVentas guardarivasventas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GuardarIvasVentasLogicAdditional.updateGuardarIvasVentasToGet(guardarivasventas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		guardarivasventas.setEmpresa(guardarivasventasDataAccess.getEmpresa(connexion,guardarivasventas));
		guardarivasventas.setEjercicio(guardarivasventasDataAccess.getEjercicio(connexion,guardarivasventas));
		guardarivasventas.setPeriodo(guardarivasventasDataAccess.getPeriodo(connexion,guardarivasventas));
		guardarivasventas.setTipoRetencionFuenteIva(guardarivasventasDataAccess.getTipoRetencionFuenteIva(connexion,guardarivasventas));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				guardarivasventas.setEmpresa(guardarivasventasDataAccess.getEmpresa(connexion,guardarivasventas));
			}

			if(clas.clas.equals(Ejercicio.class)) {
				guardarivasventas.setEjercicio(guardarivasventasDataAccess.getEjercicio(connexion,guardarivasventas));
			}

			if(clas.clas.equals(Periodo.class)) {
				guardarivasventas.setPeriodo(guardarivasventasDataAccess.getPeriodo(connexion,guardarivasventas));
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				guardarivasventas.setTipoRetencionFuenteIva(guardarivasventasDataAccess.getTipoRetencionFuenteIva(connexion,guardarivasventas));
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
			guardarivasventas.setEmpresa(guardarivasventasDataAccess.getEmpresa(connexion,guardarivasventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guardarivasventas.setEjercicio(guardarivasventasDataAccess.getEjercicio(connexion,guardarivasventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guardarivasventas.setPeriodo(guardarivasventasDataAccess.getPeriodo(connexion,guardarivasventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guardarivasventas.setTipoRetencionFuenteIva(guardarivasventasDataAccess.getTipoRetencionFuenteIva(connexion,guardarivasventas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		guardarivasventas.setEmpresa(guardarivasventasDataAccess.getEmpresa(connexion,guardarivasventas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(guardarivasventas.getEmpresa(),isDeep,deepLoadType,clases);
				
		guardarivasventas.setEjercicio(guardarivasventasDataAccess.getEjercicio(connexion,guardarivasventas));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(guardarivasventas.getEjercicio(),isDeep,deepLoadType,clases);
				
		guardarivasventas.setPeriodo(guardarivasventasDataAccess.getPeriodo(connexion,guardarivasventas));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(guardarivasventas.getPeriodo(),isDeep,deepLoadType,clases);
				
		guardarivasventas.setTipoRetencionFuenteIva(guardarivasventasDataAccess.getTipoRetencionFuenteIva(connexion,guardarivasventas));
		TipoRetencionLogic tiporetencionfuenteivaLogic= new TipoRetencionLogic(connexion);
		tiporetencionfuenteivaLogic.deepLoad(guardarivasventas.getTipoRetencionFuenteIva(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				guardarivasventas.setEmpresa(guardarivasventasDataAccess.getEmpresa(connexion,guardarivasventas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(guardarivasventas.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Ejercicio.class)) {
				guardarivasventas.setEjercicio(guardarivasventasDataAccess.getEjercicio(connexion,guardarivasventas));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(guardarivasventas.getEjercicio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Periodo.class)) {
				guardarivasventas.setPeriodo(guardarivasventasDataAccess.getPeriodo(connexion,guardarivasventas));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(guardarivasventas.getPeriodo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				guardarivasventas.setTipoRetencionFuenteIva(guardarivasventasDataAccess.getTipoRetencionFuenteIva(connexion,guardarivasventas));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(guardarivasventas.getTipoRetencionFuenteIva(),isDeep,deepLoadType,clases);				
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
			guardarivasventas.setEmpresa(guardarivasventasDataAccess.getEmpresa(connexion,guardarivasventas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(guardarivasventas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guardarivasventas.setEjercicio(guardarivasventasDataAccess.getEjercicio(connexion,guardarivasventas));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(guardarivasventas.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guardarivasventas.setPeriodo(guardarivasventasDataAccess.getPeriodo(connexion,guardarivasventas));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(guardarivasventas.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guardarivasventas.setTipoRetencionFuenteIva(guardarivasventasDataAccess.getTipoRetencionFuenteIva(connexion,guardarivasventas));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(guardarivasventas.getTipoRetencionFuenteIva(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(guardarivasventas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GuardarIvasVentasConstantesFunciones.refrescarForeignKeysDescripcionesGuardarIvasVentas(guardarivasventas);
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
			this.deepLoad(this.guardarivasventas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GuardarIvasVentasConstantesFunciones.refrescarForeignKeysDescripcionesGuardarIvasVentas(this.guardarivasventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(guardarivasventass!=null) {
				for(GuardarIvasVentas guardarivasventas:guardarivasventass) {
					this.deepLoad(guardarivasventas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GuardarIvasVentasConstantesFunciones.refrescarForeignKeysDescripcionesGuardarIvasVentas(guardarivasventass);
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
			if(guardarivasventass!=null) {
				for(GuardarIvasVentas guardarivasventas:guardarivasventass) {
					this.deepLoad(guardarivasventas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GuardarIvasVentasConstantesFunciones.refrescarForeignKeysDescripcionesGuardarIvasVentas(guardarivasventass);
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
	
	public GuardarIvasVentasParameterReturnGeneral procesarAccionGuardarIvasVentass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GuardarIvasVentas> guardarivasventass,GuardarIvasVentasParameterReturnGeneral guardarivasventasParameterGeneral)throws Exception {
		 try {	
			GuardarIvasVentasParameterReturnGeneral guardarivasventasReturnGeneral=new GuardarIvasVentasParameterReturnGeneral();
	
			GuardarIvasVentasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,guardarivasventass,guardarivasventasParameterGeneral,guardarivasventasReturnGeneral);
			
			return guardarivasventasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GuardarIvasVentasParameterReturnGeneral procesarAccionGuardarIvasVentassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GuardarIvasVentas> guardarivasventass,GuardarIvasVentasParameterReturnGeneral guardarivasventasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			GuardarIvasVentasParameterReturnGeneral guardarivasventasReturnGeneral=new GuardarIvasVentasParameterReturnGeneral();
	
			GuardarIvasVentasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,guardarivasventass,guardarivasventasParameterGeneral,guardarivasventasReturnGeneral);
			
			this.connexion.commit();
			
			return guardarivasventasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

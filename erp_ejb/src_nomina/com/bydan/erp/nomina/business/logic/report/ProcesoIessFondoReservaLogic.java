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
import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaParameterGeneral;
import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaConstantesFunciones;
import com.bydan.erp.nomina.business.entity.report.ProcesoIessFondoReserva;

import com.bydan.erp.nomina.business.logic.report.ProcesoIessFondoReservaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoIessFondoReservaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoIessFondoReservaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoIessFondoReservaLogic procesoiessfondoreservaDataAccess; 		
	protected ProcesoIessFondoReserva procesoiessfondoreserva;
	protected List<ProcesoIessFondoReserva> procesoiessfondoreservas;
	protected Object procesoiessfondoreservaObject;	
	protected List<Object> procesoiessfondoreservasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoIessFondoReservaLogic()throws SQLException,Exception {
		try	{
			this.procesoiessfondoreservas= new ArrayList<ProcesoIessFondoReserva>();
			this.procesoiessfondoreserva= new ProcesoIessFondoReserva();
			this.procesoiessfondoreservaObject=new Object();
			this.procesoiessfondoreservasObject=new ArrayList<Object>();
			
			this.procesoiessfondoreservaDataAccess=this;
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
			this.procesoiessfondoreservaDataAccess.setConnexionType(this.connexionType);
			this.procesoiessfondoreservaDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoiessfondoreservaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoIessFondoReservaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesoiessfondoreservas= new ArrayList<ProcesoIessFondoReserva>();
			this.procesoiessfondoreserva= new ProcesoIessFondoReserva();
			this.procesoiessfondoreservaObject=new Object();
			this.procesoiessfondoreservasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesoiessfondoreservaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesoiessfondoreservaDataAccess.setConnexionType(this.connexionType);
			this.procesoiessfondoreservaDataAccess.setParameterDbType(this.parameterDbType);
			this.procesoiessfondoreservaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoIessFondoReserva getProcesoIessFondoReserva() throws Exception {	
		ProcesoIessFondoReservaLogicAdditional.checkProcesoIessFondoReservaToGet(procesoiessfondoreserva,this.datosCliente,this.arrDatoGeneral);
		ProcesoIessFondoReservaLogicAdditional.updateProcesoIessFondoReservaToGet(procesoiessfondoreserva,this.arrDatoGeneral);
		
		return procesoiessfondoreserva;
	}
		
	public void setProcesoIessFondoReserva(ProcesoIessFondoReserva newProcesoIessFondoReserva) {
		this.procesoiessfondoreserva = newProcesoIessFondoReserva;
	}
	
	public List<ProcesoIessFondoReserva> getProcesoIessFondoReservas() throws Exception {		
		this.quitarProcesoIessFondoReservasNulos();
		
		ProcesoIessFondoReservaLogicAdditional.checkProcesoIessFondoReservaToGets(procesoiessfondoreservas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoIessFondoReserva procesoiessfondoreservaLocal: procesoiessfondoreservas ) {
			ProcesoIessFondoReservaLogicAdditional.updateProcesoIessFondoReservaToGet(procesoiessfondoreservaLocal,this.arrDatoGeneral);
		}
		
		return procesoiessfondoreservas;
	}
	
	public void setProcesoIessFondoReservas(List<ProcesoIessFondoReserva> newProcesoIessFondoReservas) {
		this.procesoiessfondoreservas = newProcesoIessFondoReservas;
	}
	
	public Object getProcesoIessFondoReservaObject() {	
		//this.procesoiessfondoreservaObject=this.procesoiessfondoreservaDataAccess.getEntityObject();
		return this.procesoiessfondoreservaObject;
	}
		
	public void setProcesoIessFondoReservaObject(Object newProcesoIessFondoReservaObject) {
		this.procesoiessfondoreservaObject = newProcesoIessFondoReservaObject;
	}
	
	public List<Object> getProcesoIessFondoReservasObject() {		
		//this.procesoiessfondoreservasObject=this.procesoiessfondoreservaDataAccess.getEntitiesObject();
		return this.procesoiessfondoreservasObject;
	}
		
	public void setProcesoIessFondoReservasObject(List<Object> newProcesoIessFondoReservasObject) {
		this.procesoiessfondoreservasObject = newProcesoIessFondoReservasObject;
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
		procesoiessfondoreservas = new  ArrayList<ProcesoIessFondoReserva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessFondoReservaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesoiessfondoreservas = new  ArrayList<ProcesoIessFondoReserva>();
		  		  
        try {
			//ProcesoIessFondoReservaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesoiessfondoreservas = new  ArrayList<ProcesoIessFondoReserva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessFondoReservaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoiessfondoreservas = new  ArrayList<ProcesoIessFondoReserva>();
		  		  
        try {
			//ProcesoIessFondoReservaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesoiessfondoreservas = new  ArrayList<ProcesoIessFondoReserva>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessFondoReservaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesoiessfondoreservas = new  ArrayList<ProcesoIessFondoReserva>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoIessFondoReservaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoIessFondoReserva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessFondoReserva> entities = new  ArrayList<ProcesoIessFondoReserva>();
		ProcesoIessFondoReserva entity = new ProcesoIessFondoReserva();		  
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
	
	public  List<ProcesoIessFondoReserva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessFondoReserva> entities = new  ArrayList<ProcesoIessFondoReserva>();
		ProcesoIessFondoReserva entity = new ProcesoIessFondoReserva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoIessFondoReserva();
				
				
      	    	entity=ProcesoIessFondoReservaLogic.getEntityProcesoIessFondoReserva("",entity,resultSet);
      	    	
				//entity.setProcesoIessFondoReservaOriginal( new ProcesoIessFondoReserva());
      	    	//entity.setProcesoIessFondoReservaOriginal(super.getEntity("",entity.getProcesoIessFondoReservaOriginal(),resultSet,ProcesoIessFondoReservaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoIessFondoReservaOriginal(ProcesoIessFondoReservaDataAccess.getEntityProcesoIessFondoReserva("",entity.getProcesoIessFondoReservaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoIessFondoReserva> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessFondoReserva> entities = new  ArrayList<ProcesoIessFondoReserva>();
		ProcesoIessFondoReserva entity = new ProcesoIessFondoReserva();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoIessFondoReserva.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoIessFondoReserva>((List<ProcesoIessFondoReserva>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoIessFondoReservasOriginal(entities);
			
			}  else {
				this.procesoiessfondoreservasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoIessFondoReservaConstantesFunciones.quitarEspaciosProcesoIessFondoReservas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoIessFondoReserva getEntityProcesoIessFondoReserva(String strPrefijo,ProcesoIessFondoReserva entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_anio(resultSet.getLong(strPrefijo+ProcesoIessFondoReservaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
			entity.setid_numero_patronal(resultSet.getLong(strPrefijo+ProcesoIessFondoReservaConstantesFunciones.IDNUMEROPATRONAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoIessFondoReserva getEntityProcesoIessFondoReserva(String strPrefijo,ProcesoIessFondoReserva entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoIessFondoReserva.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoIessFondoReserva.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoIessFondoReservaLogic.setFieldReflectionProcesoIessFondoReserva(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoIessFondoReserva(Field field,String strPrefijo,String sColumn,ProcesoIessFondoReserva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoIessFondoReservaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoIessFondoReservaConstantesFunciones.IDNUMEROPATRONAL:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	public void quitarProcesoIessFondoReservasNulos() throws Exception {				
		
		List<ProcesoIessFondoReserva> procesoiessfondoreservasAux= new ArrayList<ProcesoIessFondoReserva>();
		
		for(ProcesoIessFondoReserva procesoiessfondoreserva:procesoiessfondoreservas) {
			if(procesoiessfondoreserva!=null) {
				procesoiessfondoreservasAux.add(procesoiessfondoreserva);
			}
		}
		
		procesoiessfondoreservas=procesoiessfondoreservasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoIessFondoReserva> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoIessFondoReserva> entities = new  ArrayList<ProcesoIessFondoReserva>();
		ProcesoIessFondoReserva entity = new ProcesoIessFondoReserva();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoIessFondoReserva>((List<ProcesoIessFondoReserva>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoIessFondoReservasOriginal(entities);
			
			}  else {
				this.procesoiessfondoreservasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoIessFondoReservaConstantesFunciones.quitarEspaciosProcesoIessFondoReservas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesoiessfondoreservas = new  ArrayList<ProcesoIessFondoReserva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoIessFondoReservaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesoiessfondoreservas = new  ArrayList<ProcesoIessFondoReserva>();
		  		  
        try {
			//ProcesoIessFondoReservaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesoiessfondoreservas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoIessFondoReserva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoIessFondoReserva> entities = new  ArrayList<ProcesoIessFondoReserva>();
		ProcesoIessFondoReserva entity = new ProcesoIessFondoReserva();		  
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
	
	public  List<ProcesoIessFondoReserva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoIessFondoReserva> entities = new  ArrayList<ProcesoIessFondoReserva>();
		ProcesoIessFondoReserva entity = new ProcesoIessFondoReserva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoIessFondoReserva();
				
				if(conMapGenerico) {
					entity.setMapProcesoIessFondoReserva( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoIessFondoReserva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoIessFondoReservaDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoIessFondoReservaLogic.getEntityProcesoIessFondoReserva("",entity,resultSet,listColumns);
					
					////entity.setProcesoIessFondoReservaOriginal( new ProcesoIessFondoReserva());
					////entity.setProcesoIessFondoReservaOriginal(super.getEntity("",entity.getProcesoIessFondoReservaOriginal(),resultSet,ProcesoIessFondoReservaDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoIessFondoReservaOriginal(ProcesoIessFondoReservaDataAccess.getEntityProcesoIessFondoReserva("",entity.getProcesoIessFondoReservaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Anio getAnio(Connexion connexion,ProcesoIessFondoReserva relprocesoiessfondoreserva)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);
			anioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			anio=anioDataAccess.getEntity(connexion,relprocesoiessfondoreserva.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public NumeroPatronal getNumeroPatronal(Connexion connexion,ProcesoIessFondoReserva relprocesoiessfondoreserva)throws SQLException,Exception {

		NumeroPatronal numeropatronal= new NumeroPatronal();

		try {
			NumeroPatronalDataAccess numeropatronalDataAccess=new NumeroPatronalDataAccess();

			numeropatronalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			numeropatronalDataAccess.setConnexionType(this.connexionType);
			numeropatronalDataAccess.setParameterDbType(this.parameterDbType);
			numeropatronalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			numeropatronal=numeropatronalDataAccess.getEntity(connexion,relprocesoiessfondoreserva.getid_numero_patronal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return numeropatronal;

	}


	
	
	public void getProcesoIessFondoReservasBusquedaProcesoIessFondoReservaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_numero_patronal)throws Exception {
		try {
			ProcesoIessFondoReservaLogicAdditional procesoiessfondoreservaLogicAdditional=new ProcesoIessFondoReservaLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoiessfondoreservaLogicAdditional.BusquedaProcesoIessFondoReserva(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_numero_patronal);

			//this.procesoiessfondoreservas=this.getProcesoIessFondoReservas();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoIessFondoReservaLogicAdditional.ProcesarInformacionProcesoIessFondoReserva(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoiessfondoreservaLogicAdditional,this.procesoiessfondoreservas,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoIessFondoReserva",id_anio,id_numero_patronal);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoIessFondoReservasBusquedaProcesoIessFondoReserva(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_numero_patronal)throws Exception {
		try {
			ProcesoIessFondoReservaLogicAdditional procesoiessfondoreservaLogicAdditional=new ProcesoIessFondoReservaLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesoiessfondoreservaLogicAdditional.BusquedaProcesoIessFondoReserva(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_anio,id_numero_patronal);

			//this.procesoiessfondoreservas=this.getProcesoIessFondoReservas();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoIessFondoReservaLogicAdditional.ProcesarInformacionProcesoIessFondoReserva(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoiessfondoreservaLogicAdditional,this.procesoiessfondoreservas,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoIessFondoReserva",id_anio,id_numero_patronal);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoIessFondoReserva procesoiessfondoreserva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoIessFondoReservaLogicAdditional.updateProcesoIessFondoReservaToGet(procesoiessfondoreserva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoiessfondoreserva.setAnio(procesoiessfondoreservaDataAccess.getAnio(connexion,procesoiessfondoreserva));
		procesoiessfondoreserva.setNumeroPatronal(procesoiessfondoreservaDataAccess.getNumeroPatronal(connexion,procesoiessfondoreserva));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoiessfondoreserva.setAnio(procesoiessfondoreservaDataAccess.getAnio(connexion,procesoiessfondoreserva));
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				procesoiessfondoreserva.setNumeroPatronal(procesoiessfondoreservaDataAccess.getNumeroPatronal(connexion,procesoiessfondoreserva));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreserva.setAnio(procesoiessfondoreservaDataAccess.getAnio(connexion,procesoiessfondoreserva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreserva.setNumeroPatronal(procesoiessfondoreservaDataAccess.getNumeroPatronal(connexion,procesoiessfondoreserva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesoiessfondoreserva.setAnio(procesoiessfondoreservaDataAccess.getAnio(connexion,procesoiessfondoreserva));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(procesoiessfondoreserva.getAnio(),isDeep,deepLoadType,clases);
				
		procesoiessfondoreserva.setNumeroPatronal(procesoiessfondoreservaDataAccess.getNumeroPatronal(connexion,procesoiessfondoreserva));
		NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
		numeropatronalLogic.deepLoad(procesoiessfondoreserva.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				procesoiessfondoreserva.setAnio(procesoiessfondoreservaDataAccess.getAnio(connexion,procesoiessfondoreserva));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(procesoiessfondoreserva.getAnio(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				procesoiessfondoreserva.setNumeroPatronal(procesoiessfondoreservaDataAccess.getNumeroPatronal(connexion,procesoiessfondoreserva));
				NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
				numeropatronalLogic.deepLoad(procesoiessfondoreserva.getNumeroPatronal(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreserva.setAnio(procesoiessfondoreservaDataAccess.getAnio(connexion,procesoiessfondoreserva));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(procesoiessfondoreserva.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesoiessfondoreserva.setNumeroPatronal(procesoiessfondoreservaDataAccess.getNumeroPatronal(connexion,procesoiessfondoreserva));
			NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
			numeropatronalLogic.deepLoad(procesoiessfondoreserva.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesoiessfondoreserva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoIessFondoReservaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessFondoReserva(procesoiessfondoreserva);
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
			this.deepLoad(this.procesoiessfondoreserva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoIessFondoReservaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessFondoReserva(this.procesoiessfondoreserva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesoiessfondoreservas!=null) {
				for(ProcesoIessFondoReserva procesoiessfondoreserva:procesoiessfondoreservas) {
					this.deepLoad(procesoiessfondoreserva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoIessFondoReservaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessFondoReserva(procesoiessfondoreservas);
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
			if(procesoiessfondoreservas!=null) {
				for(ProcesoIessFondoReserva procesoiessfondoreserva:procesoiessfondoreservas) {
					this.deepLoad(procesoiessfondoreserva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoIessFondoReservaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoIessFondoReserva(procesoiessfondoreservas);
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
	
	public ProcesoIessFondoReservaParameterReturnGeneral procesarAccionProcesoIessFondoReservas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoIessFondoReserva> procesoiessfondoreservas,ProcesoIessFondoReservaParameterReturnGeneral procesoiessfondoreservaParameterGeneral)throws Exception {
		 try {	
			ProcesoIessFondoReservaParameterReturnGeneral procesoiessfondoreservaReturnGeneral=new ProcesoIessFondoReservaParameterReturnGeneral();
	
			ProcesoIessFondoReservaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoiessfondoreservas,procesoiessfondoreservaParameterGeneral,procesoiessfondoreservaReturnGeneral);
			
			return procesoiessfondoreservaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoIessFondoReservaParameterReturnGeneral procesarAccionProcesoIessFondoReservasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoIessFondoReserva> procesoiessfondoreservas,ProcesoIessFondoReservaParameterReturnGeneral procesoiessfondoreservaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoIessFondoReservaParameterReturnGeneral procesoiessfondoreservaReturnGeneral=new ProcesoIessFondoReservaParameterReturnGeneral();
	
			ProcesoIessFondoReservaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesoiessfondoreservas,procesoiessfondoreservaParameterGeneral,procesoiessfondoreservaReturnGeneral);
			
			this.connexion.commit();
			
			return procesoiessfondoreservaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoIessFondoReserva(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoIessFondoReserva> procesoiessfondoreservas,String sTipoBusqueda,Long id_anioBusquedaProcesoIessFondoReserva,Long id_numero_patronalBusquedaProcesoIessFondoReserva) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoIessFondoReservaLogicAdditional procesoiessfondoreservaLogicAdditional=new ProcesoIessFondoReservaLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesoiessfondoreservaLogicAdditional.setConnexion(this.connexion);

			procesoiessfondoreservaLogicAdditional.ProcesarInformacionProcesoIessFondoReserva(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesoiessfondoreservas,sTipoBusqueda,id_anioBusquedaProcesoIessFondoReserva,id_numero_patronalBusquedaProcesoIessFondoReserva);

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

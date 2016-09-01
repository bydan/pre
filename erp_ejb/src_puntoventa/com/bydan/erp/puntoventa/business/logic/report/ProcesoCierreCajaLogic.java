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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;
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
import com.bydan.erp.puntoventa.util.report.ProcesoCierreCajaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ProcesoCierreCajaParameterGeneral;
import com.bydan.erp.puntoventa.util.report.ProcesoCierreCajaConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.ProcesoCierreCaja;

import com.bydan.erp.puntoventa.business.logic.report.ProcesoCierreCajaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;






@SuppressWarnings("unused")
public class ProcesoCierreCajaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ProcesoCierreCajaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ProcesoCierreCajaLogic procesocierrecajaDataAccess; 		
	protected ProcesoCierreCaja procesocierrecaja;
	protected List<ProcesoCierreCaja> procesocierrecajas;
	protected Object procesocierrecajaObject;	
	protected List<Object> procesocierrecajasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ProcesoCierreCajaLogic()throws SQLException,Exception {
		try	{
			this.procesocierrecajas= new ArrayList<ProcesoCierreCaja>();
			this.procesocierrecaja= new ProcesoCierreCaja();
			this.procesocierrecajaObject=new Object();
			this.procesocierrecajasObject=new ArrayList<Object>();
			
			this.procesocierrecajaDataAccess=this;
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
			this.procesocierrecajaDataAccess.setConnexionType(this.connexionType);
			this.procesocierrecajaDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocierrecajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProcesoCierreCajaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.procesocierrecajas= new ArrayList<ProcesoCierreCaja>();
			this.procesocierrecaja= new ProcesoCierreCaja();
			this.procesocierrecajaObject=new Object();
			this.procesocierrecajasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.procesocierrecajaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.procesocierrecajaDataAccess.setConnexionType(this.connexionType);
			this.procesocierrecajaDataAccess.setParameterDbType(this.parameterDbType);
			this.procesocierrecajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProcesoCierreCaja getProcesoCierreCaja() throws Exception {	
		ProcesoCierreCajaLogicAdditional.checkProcesoCierreCajaToGet(procesocierrecaja,this.datosCliente,this.arrDatoGeneral);
		ProcesoCierreCajaLogicAdditional.updateProcesoCierreCajaToGet(procesocierrecaja,this.arrDatoGeneral);
		
		return procesocierrecaja;
	}
		
	public void setProcesoCierreCaja(ProcesoCierreCaja newProcesoCierreCaja) {
		this.procesocierrecaja = newProcesoCierreCaja;
	}
	
	public List<ProcesoCierreCaja> getProcesoCierreCajas() throws Exception {		
		this.quitarProcesoCierreCajasNulos();
		
		ProcesoCierreCajaLogicAdditional.checkProcesoCierreCajaToGets(procesocierrecajas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProcesoCierreCaja procesocierrecajaLocal: procesocierrecajas ) {
			ProcesoCierreCajaLogicAdditional.updateProcesoCierreCajaToGet(procesocierrecajaLocal,this.arrDatoGeneral);
		}
		
		return procesocierrecajas;
	}
	
	public void setProcesoCierreCajas(List<ProcesoCierreCaja> newProcesoCierreCajas) {
		this.procesocierrecajas = newProcesoCierreCajas;
	}
	
	public Object getProcesoCierreCajaObject() {	
		//this.procesocierrecajaObject=this.procesocierrecajaDataAccess.getEntityObject();
		return this.procesocierrecajaObject;
	}
		
	public void setProcesoCierreCajaObject(Object newProcesoCierreCajaObject) {
		this.procesocierrecajaObject = newProcesoCierreCajaObject;
	}
	
	public List<Object> getProcesoCierreCajasObject() {		
		//this.procesocierrecajasObject=this.procesocierrecajaDataAccess.getEntitiesObject();
		return this.procesocierrecajasObject;
	}
		
	public void setProcesoCierreCajasObject(List<Object> newProcesoCierreCajasObject) {
		this.procesocierrecajasObject = newProcesoCierreCajasObject;
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
		procesocierrecajas = new  ArrayList<ProcesoCierreCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		procesocierrecajas = new  ArrayList<ProcesoCierreCaja>();
		  		  
        try {
			//ProcesoCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		procesocierrecajas = new  ArrayList<ProcesoCierreCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocierrecajas = new  ArrayList<ProcesoCierreCaja>();
		  		  
        try {
			//ProcesoCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		procesocierrecajas = new  ArrayList<ProcesoCierreCaja>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		procesocierrecajas = new  ArrayList<ProcesoCierreCaja>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ProcesoCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ProcesoCierreCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreCaja> entities = new  ArrayList<ProcesoCierreCaja>();
		ProcesoCierreCaja entity = new ProcesoCierreCaja();		  
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
	
	public  List<ProcesoCierreCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreCaja> entities = new  ArrayList<ProcesoCierreCaja>();
		ProcesoCierreCaja entity = new ProcesoCierreCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCierreCaja();
				
				
      	    	entity=ProcesoCierreCajaLogic.getEntityProcesoCierreCaja("",entity,resultSet);
      	    	
				//entity.setProcesoCierreCajaOriginal( new ProcesoCierreCaja());
      	    	//entity.setProcesoCierreCajaOriginal(super.getEntity("",entity.getProcesoCierreCajaOriginal(),resultSet,ProcesoCierreCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProcesoCierreCajaOriginal(ProcesoCierreCajaDataAccess.getEntityProcesoCierreCaja("",entity.getProcesoCierreCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ProcesoCierreCaja> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreCaja> entities = new  ArrayList<ProcesoCierreCaja>();
		ProcesoCierreCaja entity = new ProcesoCierreCaja();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ProcesoCierreCaja.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCierreCaja>((List<ProcesoCierreCaja>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCierreCajasOriginal(entities);
			
			}  else {
				this.procesocierrecajasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCierreCajaConstantesFunciones.quitarEspaciosProcesoCierreCajas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ProcesoCierreCaja getEntityProcesoCierreCaja(String strPrefijo,ProcesoCierreCaja entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_usuario(resultSet.getLong(strPrefijo+ProcesoCierreCajaConstantesFunciones.IDUSUARIO));
			entity.setid_caja(resultSet.getLong(strPrefijo+ProcesoCierreCajaConstantesFunciones.IDCAJA));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ProcesoCierreCajaConstantesFunciones.FECHA).getTime()));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProcesoCierreCaja getEntityProcesoCierreCaja(String strPrefijo,ProcesoCierreCaja entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ProcesoCierreCaja.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ProcesoCierreCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ProcesoCierreCajaLogic.setFieldReflectionProcesoCierreCaja(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProcesoCierreCaja(Field field,String strPrefijo,String sColumn,ProcesoCierreCaja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProcesoCierreCajaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCierreCajaConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProcesoCierreCajaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	public void quitarProcesoCierreCajasNulos() throws Exception {				
		
		List<ProcesoCierreCaja> procesocierrecajasAux= new ArrayList<ProcesoCierreCaja>();
		
		for(ProcesoCierreCaja procesocierrecaja:procesocierrecajas) {
			if(procesocierrecaja!=null) {
				procesocierrecajasAux.add(procesocierrecaja);
			}
		}
		
		procesocierrecajas=procesocierrecajasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcesoCierreCaja> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProcesoCierreCaja> entities = new  ArrayList<ProcesoCierreCaja>();
		ProcesoCierreCaja entity = new ProcesoCierreCaja();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ProcesoCierreCaja>((List<ProcesoCierreCaja>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setProcesoCierreCajasOriginal(entities);
			
			}  else {
				this.procesocierrecajasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ProcesoCierreCajaConstantesFunciones.quitarEspaciosProcesoCierreCajas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		procesocierrecajas = new  ArrayList<ProcesoCierreCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ProcesoCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		procesocierrecajas = new  ArrayList<ProcesoCierreCaja>();
		  		  
        try {
			//ProcesoCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			procesocierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ProcesoCierreCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCierreCaja> entities = new  ArrayList<ProcesoCierreCaja>();
		ProcesoCierreCaja entity = new ProcesoCierreCaja();		  
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
	
	public  List<ProcesoCierreCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProcesoCierreCaja> entities = new  ArrayList<ProcesoCierreCaja>();
		ProcesoCierreCaja entity = new ProcesoCierreCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProcesoCierreCaja();
				
				if(conMapGenerico) {
					entity.setMapProcesoCierreCaja( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapProcesoCierreCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProcesoCierreCajaDataAccess.ISWITHSCHEMA);         		
					entity=ProcesoCierreCajaLogic.getEntityProcesoCierreCaja("",entity,resultSet,listColumns);
					
					////entity.setProcesoCierreCajaOriginal( new ProcesoCierreCaja());
					////entity.setProcesoCierreCajaOriginal(super.getEntity("",entity.getProcesoCierreCajaOriginal(),resultSet,ProcesoCierreCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setProcesoCierreCajaOriginal(ProcesoCierreCajaDataAccess.getEntityProcesoCierreCaja("",entity.getProcesoCierreCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Usuario getUsuario(Connexion connexion,ProcesoCierreCaja relprocesocierrecaja)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);
			usuarioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			usuario=usuarioDataAccess.getEntity(connexion,relprocesocierrecaja.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Caja getCaja(Connexion connexion,ProcesoCierreCaja relprocesocierrecaja)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);
			cajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			caja=cajaDataAccess.getEntity(connexion,relprocesocierrecaja.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}


	
	
	public void getProcesoCierreCajasBusquedaProcesoCierreCajaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_usuario,Long id_caja,Date fecha)throws Exception {
		try {
			ProcesoCierreCajaLogicAdditional procesocierrecajaLogicAdditional=new ProcesoCierreCajaLogicAdditional();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocierrecajaLogicAdditional.BusquedaProcesoCierreCaja(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_usuario,id_caja,fecha);

			//this.procesocierrecajas=this.getProcesoCierreCajas();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCierreCajaLogicAdditional.ProcesarInformacionProcesoCierreCaja(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierrecajaLogicAdditional,this.procesocierrecajas,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCierreCaja",id_usuario,id_caja,fecha);

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getProcesoCierreCajasBusquedaProcesoCierreCaja(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_usuario,Long id_caja,Date fecha)throws Exception {
		try {
			ProcesoCierreCajaLogicAdditional procesocierrecajaLogicAdditional=new ProcesoCierreCajaLogicAdditional();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			procesocierrecajaLogicAdditional.BusquedaProcesoCierreCaja(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_usuario,id_caja,fecha);

			//this.procesocierrecajas=this.getProcesoCierreCajas();

			GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			generalEntityReturnGeneral=ProcesoCierreCajaLogicAdditional.ProcesarInformacionProcesoCierreCaja(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierrecajaLogicAdditional,this.procesocierrecajas,new GeneralEntityParameterReturnGeneral(),generalEntityReturnGeneral,"BusquedaProcesoCierreCaja",id_usuario,id_caja,fecha);
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	
	
	public void deepLoad(ProcesoCierreCaja procesocierrecaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProcesoCierreCajaLogicAdditional.updateProcesoCierreCajaToGet(procesocierrecaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocierrecaja.setUsuario(procesocierrecajaDataAccess.getUsuario(connexion,procesocierrecaja));
		procesocierrecaja.setCaja(procesocierrecajaDataAccess.getCaja(connexion,procesocierrecaja));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				procesocierrecaja.setUsuario(procesocierrecajaDataAccess.getUsuario(connexion,procesocierrecaja));
			}

			if(clas.clas.equals(Caja.class)) {
				procesocierrecaja.setCaja(procesocierrecajaDataAccess.getCaja(connexion,procesocierrecaja));
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierrecaja.setUsuario(procesocierrecajaDataAccess.getUsuario(connexion,procesocierrecaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierrecaja.setCaja(procesocierrecajaDataAccess.getCaja(connexion,procesocierrecaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		procesocierrecaja.setUsuario(procesocierrecajaDataAccess.getUsuario(connexion,procesocierrecaja));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(procesocierrecaja.getUsuario(),isDeep,deepLoadType,clases);
				
		procesocierrecaja.setCaja(procesocierrecajaDataAccess.getCaja(connexion,procesocierrecaja));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(procesocierrecaja.getCaja(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				procesocierrecaja.setUsuario(procesocierrecajaDataAccess.getUsuario(connexion,procesocierrecaja));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(procesocierrecaja.getUsuario(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Caja.class)) {
				procesocierrecaja.setCaja(procesocierrecajaDataAccess.getCaja(connexion,procesocierrecaja));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(procesocierrecaja.getCaja(),isDeep,deepLoadType,clases);				
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierrecaja.setUsuario(procesocierrecajaDataAccess.getUsuario(connexion,procesocierrecaja));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(procesocierrecaja.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			procesocierrecaja.setCaja(procesocierrecajaDataAccess.getCaja(connexion,procesocierrecaja));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(procesocierrecaja.getCaja(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(procesocierrecaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreCaja(procesocierrecaja);
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
			this.deepLoad(this.procesocierrecaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProcesoCierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreCaja(this.procesocierrecaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(procesocierrecajas!=null) {
				for(ProcesoCierreCaja procesocierrecaja:procesocierrecajas) {
					this.deepLoad(procesocierrecaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProcesoCierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreCaja(procesocierrecajas);
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
			if(procesocierrecajas!=null) {
				for(ProcesoCierreCaja procesocierrecaja:procesocierrecajas) {
					this.deepLoad(procesocierrecaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProcesoCierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesProcesoCierreCaja(procesocierrecajas);
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
	
	public ProcesoCierreCajaParameterReturnGeneral procesarAccionProcesoCierreCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCierreCaja> procesocierrecajas,ProcesoCierreCajaParameterReturnGeneral procesocierrecajaParameterGeneral)throws Exception {
		 try {	
			ProcesoCierreCajaParameterReturnGeneral procesocierrecajaReturnGeneral=new ProcesoCierreCajaParameterReturnGeneral();
	
			ProcesoCierreCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocierrecajas,procesocierrecajaParameterGeneral,procesocierrecajaReturnGeneral);
			
			return procesocierrecajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProcesoCierreCajaParameterReturnGeneral procesarAccionProcesoCierreCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProcesoCierreCaja> procesocierrecajas,ProcesoCierreCajaParameterReturnGeneral procesocierrecajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ProcesoCierreCajaParameterReturnGeneral procesocierrecajaReturnGeneral=new ProcesoCierreCajaParameterReturnGeneral();
	
			ProcesoCierreCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,procesocierrecajas,procesocierrecajaParameterGeneral,procesocierrecajaReturnGeneral);
			
			this.connexion.commit();
			
			return procesocierrecajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCierreCaja> procesocierrecajas,String sTipoBusqueda,Long id_usuarioBusquedaProcesoCierreCaja,Long id_cajaBusquedaProcesoCierreCaja,Date fechaBusquedaProcesoCierreCaja) throws Exception {
		Boolean procesado=false;

		try {
			ProcesoCierreCajaLogicAdditional procesocierrecajaLogicAdditional=new ProcesoCierreCajaLogicAdditional();

			//this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//procesocierrecajaLogicAdditional.setConnexion(this.connexion);

			procesocierrecajaLogicAdditional.ProcesarInformacionProcesoCierreCaja(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesocierrecajas,sTipoBusqueda,id_usuarioBusquedaProcesoCierreCaja,id_cajaBusquedaProcesoCierreCaja,fechaBusquedaProcesoCierreCaja);

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

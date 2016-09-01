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
import com.bydan.erp.puntoventa.util.report.ResumenCierreCajaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ResumenCierreCajaParameterGeneral;
import com.bydan.erp.puntoventa.util.report.ResumenCierreCajaConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.ResumenCierreCaja;

import com.bydan.erp.puntoventa.business.logic.report.ResumenCierreCajaLogicAdditional;
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
public class ResumenCierreCajaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ResumenCierreCajaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ResumenCierreCajaLogic resumencierrecajaDataAccess; 		
	protected ResumenCierreCaja resumencierrecaja;
	protected List<ResumenCierreCaja> resumencierrecajas;
	protected Object resumencierrecajaObject;	
	protected List<Object> resumencierrecajasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ResumenCierreCajaLogic()throws SQLException,Exception {
		try	{
			this.resumencierrecajas= new ArrayList<ResumenCierreCaja>();
			this.resumencierrecaja= new ResumenCierreCaja();
			this.resumencierrecajaObject=new Object();
			this.resumencierrecajasObject=new ArrayList<Object>();
			
			this.resumencierrecajaDataAccess=this;
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
			this.resumencierrecajaDataAccess.setConnexionType(this.connexionType);
			this.resumencierrecajaDataAccess.setParameterDbType(this.parameterDbType);
			this.resumencierrecajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ResumenCierreCajaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.resumencierrecajas= new ArrayList<ResumenCierreCaja>();
			this.resumencierrecaja= new ResumenCierreCaja();
			this.resumencierrecajaObject=new Object();
			this.resumencierrecajasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.resumencierrecajaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.resumencierrecajaDataAccess.setConnexionType(this.connexionType);
			this.resumencierrecajaDataAccess.setParameterDbType(this.parameterDbType);
			this.resumencierrecajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ResumenCierreCaja getResumenCierreCaja() throws Exception {	
		ResumenCierreCajaLogicAdditional.checkResumenCierreCajaToGet(resumencierrecaja,this.datosCliente,this.arrDatoGeneral);
		ResumenCierreCajaLogicAdditional.updateResumenCierreCajaToGet(resumencierrecaja,this.arrDatoGeneral);
		
		return resumencierrecaja;
	}
		
	public void setResumenCierreCaja(ResumenCierreCaja newResumenCierreCaja) {
		this.resumencierrecaja = newResumenCierreCaja;
	}
	
	public List<ResumenCierreCaja> getResumenCierreCajas() throws Exception {		
		this.quitarResumenCierreCajasNulos();
		
		ResumenCierreCajaLogicAdditional.checkResumenCierreCajaToGets(resumencierrecajas,this.datosCliente,this.arrDatoGeneral);
		
		for (ResumenCierreCaja resumencierrecajaLocal: resumencierrecajas ) {
			ResumenCierreCajaLogicAdditional.updateResumenCierreCajaToGet(resumencierrecajaLocal,this.arrDatoGeneral);
		}
		
		return resumencierrecajas;
	}
	
	public void setResumenCierreCajas(List<ResumenCierreCaja> newResumenCierreCajas) {
		this.resumencierrecajas = newResumenCierreCajas;
	}
	
	public Object getResumenCierreCajaObject() {	
		//this.resumencierrecajaObject=this.resumencierrecajaDataAccess.getEntityObject();
		return this.resumencierrecajaObject;
	}
		
	public void setResumenCierreCajaObject(Object newResumenCierreCajaObject) {
		this.resumencierrecajaObject = newResumenCierreCajaObject;
	}
	
	public List<Object> getResumenCierreCajasObject() {		
		//this.resumencierrecajasObject=this.resumencierrecajaDataAccess.getEntitiesObject();
		return this.resumencierrecajasObject;
	}
		
	public void setResumenCierreCajasObject(List<Object> newResumenCierreCajasObject) {
		this.resumencierrecajasObject = newResumenCierreCajasObject;
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
		resumencierrecajas = new  ArrayList<ResumenCierreCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ResumenCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumencierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		resumencierrecajas = new  ArrayList<ResumenCierreCaja>();
		  		  
        try {
			//ResumenCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumencierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		resumencierrecajas = new  ArrayList<ResumenCierreCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ResumenCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumencierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		resumencierrecajas = new  ArrayList<ResumenCierreCaja>();
		  		  
        try {
			//ResumenCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumencierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		resumencierrecajas = new  ArrayList<ResumenCierreCaja>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ResumenCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumencierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		resumencierrecajas = new  ArrayList<ResumenCierreCaja>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ResumenCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumencierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ResumenCierreCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResumenCierreCaja> entities = new  ArrayList<ResumenCierreCaja>();
		ResumenCierreCaja entity = new ResumenCierreCaja();		  
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
	
	public  List<ResumenCierreCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResumenCierreCaja> entities = new  ArrayList<ResumenCierreCaja>();
		ResumenCierreCaja entity = new ResumenCierreCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResumenCierreCaja();
				
				
      	    	entity=ResumenCierreCajaLogic.getEntityResumenCierreCaja("",entity,resultSet);
      	    	
				//entity.setResumenCierreCajaOriginal( new ResumenCierreCaja());
      	    	//entity.setResumenCierreCajaOriginal(super.getEntity("",entity.getResumenCierreCajaOriginal(),resultSet,ResumenCierreCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResumenCierreCajaOriginal(ResumenCierreCajaDataAccess.getEntityResumenCierreCaja("",entity.getResumenCierreCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ResumenCierreCaja> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResumenCierreCaja> entities = new  ArrayList<ResumenCierreCaja>();
		ResumenCierreCaja entity = new ResumenCierreCaja();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ResumenCierreCaja.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ResumenCierreCaja>((List<ResumenCierreCaja>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setResumenCierreCajasOriginal(entities);
			
			}  else {
				this.resumencierrecajasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ResumenCierreCajaConstantesFunciones.quitarEspaciosResumenCierreCajas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ResumenCierreCaja getEntityResumenCierreCaja(String strPrefijo,ResumenCierreCaja entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_usuario(resultSet.getLong(strPrefijo+ResumenCierreCajaConstantesFunciones.IDUSUARIO));
			entity.setid_caja(resultSet.getLong(strPrefijo+ResumenCierreCajaConstantesFunciones.IDCAJA));
			entity.settipo_pago(resultSet.getString(strPrefijo+ResumenCierreCajaConstantesFunciones.TIPOPAGO));
			entity.setnombre_usuario(resultSet.getString(strPrefijo+ResumenCierreCajaConstantesFunciones.NOMBREUSUARIO));
			entity.setnombre_caja(resultSet.getString(strPrefijo+ResumenCierreCajaConstantesFunciones.NOMBRECAJA));
			entity.setvalor(resultSet.getDouble(strPrefijo+ResumenCierreCajaConstantesFunciones.VALOR));
			entity.settotal(resultSet.getDouble(strPrefijo+ResumenCierreCajaConstantesFunciones.TOTAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ResumenCierreCaja getEntityResumenCierreCaja(String strPrefijo,ResumenCierreCaja entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ResumenCierreCaja.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ResumenCierreCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ResumenCierreCajaLogic.setFieldReflectionResumenCierreCaja(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionResumenCierreCaja(Field field,String strPrefijo,String sColumn,ResumenCierreCaja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ResumenCierreCajaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenCierreCajaConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenCierreCajaConstantesFunciones.TIPOPAGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ResumenCierreCajaConstantesFunciones.NOMBREUSUARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ResumenCierreCajaConstantesFunciones.NOMBRECAJA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ResumenCierreCajaConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ResumenCierreCajaConstantesFunciones.TOTAL:
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
	
	public void quitarResumenCierreCajasNulos() throws Exception {				
		
		List<ResumenCierreCaja> resumencierrecajasAux= new ArrayList<ResumenCierreCaja>();
		
		for(ResumenCierreCaja resumencierrecaja:resumencierrecajas) {
			if(resumencierrecaja!=null) {
				resumencierrecajasAux.add(resumencierrecaja);
			}
		}
		
		resumencierrecajas=resumencierrecajasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ResumenCierreCaja> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResumenCierreCaja> entities = new  ArrayList<ResumenCierreCaja>();
		ResumenCierreCaja entity = new ResumenCierreCaja();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelperSinIdGenerated.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ResumenCierreCaja>((List<ResumenCierreCaja>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setResumenCierreCajasOriginal(entities);
			
			}  else {
				this.resumencierrecajasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ResumenCierreCajaConstantesFunciones.quitarEspaciosResumenCierreCajas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		resumencierrecajas = new  ArrayList<ResumenCierreCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ResumenCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumencierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		resumencierrecajas = new  ArrayList<ResumenCierreCaja>();
		  		  
        try {
			//ResumenCierreCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumencierrecajas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ResumenCierreCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ResumenCierreCaja> entities = new  ArrayList<ResumenCierreCaja>();
		ResumenCierreCaja entity = new ResumenCierreCaja();		  
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
	
	public  List<ResumenCierreCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ResumenCierreCaja> entities = new  ArrayList<ResumenCierreCaja>();
		ResumenCierreCaja entity = new ResumenCierreCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResumenCierreCaja();
				
				if(conMapGenerico) {
					entity.setMapResumenCierreCaja( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapResumenCierreCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ResumenCierreCajaDataAccess.ISWITHSCHEMA);         		
					entity=ResumenCierreCajaLogic.getEntityResumenCierreCaja("",entity,resultSet,listColumns);
					
					////entity.setResumenCierreCajaOriginal( new ResumenCierreCaja());
					////entity.setResumenCierreCajaOriginal(super.getEntity("",entity.getResumenCierreCajaOriginal(),resultSet,ResumenCierreCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setResumenCierreCajaOriginal(ResumenCierreCajaDataAccess.getEntityResumenCierreCaja("",entity.getResumenCierreCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ResumenCierreCaja relresumencierrecaja)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relresumencierrecaja.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ResumenCierreCaja relresumencierrecaja)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relresumencierrecaja.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,ResumenCierreCaja relresumencierrecaja)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);
			usuarioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			usuario=usuarioDataAccess.getEntity(connexion,relresumencierrecaja.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Caja getCaja(Connexion connexion,ResumenCierreCaja relresumencierrecaja)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);
			cajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			caja=cajaDataAccess.getEntity(connexion,relresumencierrecaja.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}


	
	
	public void getResumenCierreCajasBusquedaResumenCierreCajaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_usuario,Long id_caja,Date fecha)throws Exception {
		try {
			//ResumenCierreCajaLogic resumencierrecajaLogic=new ResumenCierreCajaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ResumenCierreCajaLogic.GetSelecSqlResumenCierreCaja(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_usuario,id_caja,fecha);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.resumencierrecajas=this.getResumenCierreCajas();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getResumenCierreCajasBusquedaResumenCierreCaja(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_usuario,Long id_caja,Date fecha)throws Exception {
		try {
			//ResumenCierreCajaLogic resumencierrecajaLogic=new ResumenCierreCajaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ResumenCierreCajaLogic.GetSelecSqlResumenCierreCaja(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_usuario,id_caja,fecha);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.resumencierrecajas=this.getResumenCierreCajas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlResumenCierreCaja(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_usuario,Long id_caja,Date fecha)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ResumenCierreCaja_Postgres.sql");
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
				

				if(id_usuario!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_usuario = "+id_usuario.toString();
					existeWhere=true;
				}

				if(id_caja!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_caja = "+id_caja.toString();
					existeWhere=true;
				}

				if(fecha!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.fecha = "+"'"+Funciones2.getStringPostgresDate(fecha)+"'";
					existeWhere=true;
				}

				if(existeWhere) {
					sSqlWhere=" where "+sSqlWhere;
				}

				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"1",sSqlWhere);
				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"2",sSqlWhere);
				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"3",sSqlWhere);
				sSelectQuery=sSelectQuery.replace(Constantes2.S_KEYWHERE+"4",sSqlWhere);

				sSql=sSelectQuery;

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
	
	
	public void deepLoad(ResumenCierreCaja resumencierrecaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ResumenCierreCajaLogicAdditional.updateResumenCierreCajaToGet(resumencierrecaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		resumencierrecaja.setEmpresa(resumencierrecajaDataAccess.getEmpresa(connexion,resumencierrecaja));
		resumencierrecaja.setSucursal(resumencierrecajaDataAccess.getSucursal(connexion,resumencierrecaja));
		resumencierrecaja.setUsuario(resumencierrecajaDataAccess.getUsuario(connexion,resumencierrecaja));
		resumencierrecaja.setCaja(resumencierrecajaDataAccess.getCaja(connexion,resumencierrecaja));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				resumencierrecaja.setEmpresa(resumencierrecajaDataAccess.getEmpresa(connexion,resumencierrecaja));
			}

			if(clas.clas.equals(Sucursal.class)) {
				resumencierrecaja.setSucursal(resumencierrecajaDataAccess.getSucursal(connexion,resumencierrecaja));
			}

			if(clas.clas.equals(Usuario.class)) {
				resumencierrecaja.setUsuario(resumencierrecajaDataAccess.getUsuario(connexion,resumencierrecaja));
			}

			if(clas.clas.equals(Caja.class)) {
				resumencierrecaja.setCaja(resumencierrecajaDataAccess.getCaja(connexion,resumencierrecaja));
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
			resumencierrecaja.setEmpresa(resumencierrecajaDataAccess.getEmpresa(connexion,resumencierrecaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			resumencierrecaja.setSucursal(resumencierrecajaDataAccess.getSucursal(connexion,resumencierrecaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			resumencierrecaja.setUsuario(resumencierrecajaDataAccess.getUsuario(connexion,resumencierrecaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			resumencierrecaja.setCaja(resumencierrecajaDataAccess.getCaja(connexion,resumencierrecaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		resumencierrecaja.setEmpresa(resumencierrecajaDataAccess.getEmpresa(connexion,resumencierrecaja));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(resumencierrecaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		resumencierrecaja.setSucursal(resumencierrecajaDataAccess.getSucursal(connexion,resumencierrecaja));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(resumencierrecaja.getSucursal(),isDeep,deepLoadType,clases);
				
		resumencierrecaja.setUsuario(resumencierrecajaDataAccess.getUsuario(connexion,resumencierrecaja));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(resumencierrecaja.getUsuario(),isDeep,deepLoadType,clases);
				
		resumencierrecaja.setCaja(resumencierrecajaDataAccess.getCaja(connexion,resumencierrecaja));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(resumencierrecaja.getCaja(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				resumencierrecaja.setEmpresa(resumencierrecajaDataAccess.getEmpresa(connexion,resumencierrecaja));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(resumencierrecaja.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				resumencierrecaja.setSucursal(resumencierrecajaDataAccess.getSucursal(connexion,resumencierrecaja));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(resumencierrecaja.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Usuario.class)) {
				resumencierrecaja.setUsuario(resumencierrecajaDataAccess.getUsuario(connexion,resumencierrecaja));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(resumencierrecaja.getUsuario(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Caja.class)) {
				resumencierrecaja.setCaja(resumencierrecajaDataAccess.getCaja(connexion,resumencierrecaja));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(resumencierrecaja.getCaja(),isDeep,deepLoadType,clases);				
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
			resumencierrecaja.setEmpresa(resumencierrecajaDataAccess.getEmpresa(connexion,resumencierrecaja));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(resumencierrecaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			resumencierrecaja.setSucursal(resumencierrecajaDataAccess.getSucursal(connexion,resumencierrecaja));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(resumencierrecaja.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			resumencierrecaja.setUsuario(resumencierrecajaDataAccess.getUsuario(connexion,resumencierrecaja));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(resumencierrecaja.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			resumencierrecaja.setCaja(resumencierrecajaDataAccess.getCaja(connexion,resumencierrecaja));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(resumencierrecaja.getCaja(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(resumencierrecaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResumenCierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesResumenCierreCaja(resumencierrecaja);
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
			this.deepLoad(this.resumencierrecaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResumenCierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesResumenCierreCaja(this.resumencierrecaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(resumencierrecajas!=null) {
				for(ResumenCierreCaja resumencierrecaja:resumencierrecajas) {
					this.deepLoad(resumencierrecaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ResumenCierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesResumenCierreCaja(resumencierrecajas);
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
			if(resumencierrecajas!=null) {
				for(ResumenCierreCaja resumencierrecaja:resumencierrecajas) {
					this.deepLoad(resumencierrecaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ResumenCierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesResumenCierreCaja(resumencierrecajas);
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
	
	public ResumenCierreCajaParameterReturnGeneral procesarAccionResumenCierreCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ResumenCierreCaja> resumencierrecajas,ResumenCierreCajaParameterReturnGeneral resumencierrecajaParameterGeneral)throws Exception {
		 try {	
			ResumenCierreCajaParameterReturnGeneral resumencierrecajaReturnGeneral=new ResumenCierreCajaParameterReturnGeneral();
	
			ResumenCierreCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,resumencierrecajas,resumencierrecajaParameterGeneral,resumencierrecajaReturnGeneral);
			
			return resumencierrecajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ResumenCierreCajaParameterReturnGeneral procesarAccionResumenCierreCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ResumenCierreCaja> resumencierrecajas,ResumenCierreCajaParameterReturnGeneral resumencierrecajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ResumenCierreCajaParameterReturnGeneral resumencierrecajaReturnGeneral=new ResumenCierreCajaParameterReturnGeneral();
	
			ResumenCierreCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,resumencierrecajas,resumencierrecajaParameterGeneral,resumencierrecajaReturnGeneral);
			
			this.connexion.commit();
			
			return resumencierrecajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

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
import com.bydan.erp.puntoventa.util.report.CajaDiariaUsuarioParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.CajaDiariaUsuarioParameterGeneral;
import com.bydan.erp.puntoventa.util.report.CajaDiariaUsuarioConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.CajaDiariaUsuario;

import com.bydan.erp.puntoventa.business.logic.report.CajaDiariaUsuarioLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;






@SuppressWarnings("unused")
public class CajaDiariaUsuarioLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CajaDiariaUsuarioLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CajaDiariaUsuarioLogic cajadiariausuarioDataAccess; 		
	protected CajaDiariaUsuario cajadiariausuario;
	protected List<CajaDiariaUsuario> cajadiariausuarios;
	protected Object cajadiariausuarioObject;	
	protected List<Object> cajadiariausuariosObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CajaDiariaUsuarioLogic()throws SQLException,Exception {
		try	{
			this.cajadiariausuarios= new ArrayList<CajaDiariaUsuario>();
			this.cajadiariausuario= new CajaDiariaUsuario();
			this.cajadiariausuarioObject=new Object();
			this.cajadiariausuariosObject=new ArrayList<Object>();
			
			this.cajadiariausuarioDataAccess=this;
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
			this.cajadiariausuarioDataAccess.setConnexionType(this.connexionType);
			this.cajadiariausuarioDataAccess.setParameterDbType(this.parameterDbType);
			this.cajadiariausuarioDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CajaDiariaUsuarioLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cajadiariausuarios= new ArrayList<CajaDiariaUsuario>();
			this.cajadiariausuario= new CajaDiariaUsuario();
			this.cajadiariausuarioObject=new Object();
			this.cajadiariausuariosObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cajadiariausuarioDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cajadiariausuarioDataAccess.setConnexionType(this.connexionType);
			this.cajadiariausuarioDataAccess.setParameterDbType(this.parameterDbType);
			this.cajadiariausuarioDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CajaDiariaUsuario getCajaDiariaUsuario() throws Exception {	
		CajaDiariaUsuarioLogicAdditional.checkCajaDiariaUsuarioToGet(cajadiariausuario,this.datosCliente,this.arrDatoGeneral);
		CajaDiariaUsuarioLogicAdditional.updateCajaDiariaUsuarioToGet(cajadiariausuario,this.arrDatoGeneral);
		
		return cajadiariausuario;
	}
		
	public void setCajaDiariaUsuario(CajaDiariaUsuario newCajaDiariaUsuario) {
		this.cajadiariausuario = newCajaDiariaUsuario;
	}
	
	public List<CajaDiariaUsuario> getCajaDiariaUsuarios() throws Exception {		
		this.quitarCajaDiariaUsuariosNulos();
		
		CajaDiariaUsuarioLogicAdditional.checkCajaDiariaUsuarioToGets(cajadiariausuarios,this.datosCliente,this.arrDatoGeneral);
		
		for (CajaDiariaUsuario cajadiariausuarioLocal: cajadiariausuarios ) {
			CajaDiariaUsuarioLogicAdditional.updateCajaDiariaUsuarioToGet(cajadiariausuarioLocal,this.arrDatoGeneral);
		}
		
		return cajadiariausuarios;
	}
	
	public void setCajaDiariaUsuarios(List<CajaDiariaUsuario> newCajaDiariaUsuarios) {
		this.cajadiariausuarios = newCajaDiariaUsuarios;
	}
	
	public Object getCajaDiariaUsuarioObject() {	
		//this.cajadiariausuarioObject=this.cajadiariausuarioDataAccess.getEntityObject();
		return this.cajadiariausuarioObject;
	}
		
	public void setCajaDiariaUsuarioObject(Object newCajaDiariaUsuarioObject) {
		this.cajadiariausuarioObject = newCajaDiariaUsuarioObject;
	}
	
	public List<Object> getCajaDiariaUsuariosObject() {		
		//this.cajadiariausuariosObject=this.cajadiariausuarioDataAccess.getEntitiesObject();
		return this.cajadiariausuariosObject;
	}
		
	public void setCajaDiariaUsuariosObject(List<Object> newCajaDiariaUsuariosObject) {
		this.cajadiariausuariosObject = newCajaDiariaUsuariosObject;
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
		cajadiariausuarios = new  ArrayList<CajaDiariaUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CajaDiariaUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariausuarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cajadiariausuarios = new  ArrayList<CajaDiariaUsuario>();
		  		  
        try {
			//CajaDiariaUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariausuarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajadiariausuarios = new  ArrayList<CajaDiariaUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CajaDiariaUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariausuarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cajadiariausuarios = new  ArrayList<CajaDiariaUsuario>();
		  		  
        try {
			//CajaDiariaUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariausuarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cajadiariausuarios = new  ArrayList<CajaDiariaUsuario>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CajaDiariaUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariausuarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cajadiariausuarios = new  ArrayList<CajaDiariaUsuario>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CajaDiariaUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariausuarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CajaDiariaUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaDiariaUsuario> entities = new  ArrayList<CajaDiariaUsuario>();
		CajaDiariaUsuario entity = new CajaDiariaUsuario();		  
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
	
	public  List<CajaDiariaUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaDiariaUsuario> entities = new  ArrayList<CajaDiariaUsuario>();
		CajaDiariaUsuario entity = new CajaDiariaUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaDiariaUsuario();
				
				
      	    	entity=CajaDiariaUsuarioLogic.getEntityCajaDiariaUsuario("",entity,resultSet);
      	    	
				//entity.setCajaDiariaUsuarioOriginal( new CajaDiariaUsuario());
      	    	//entity.setCajaDiariaUsuarioOriginal(super.getEntity("",entity.getCajaDiariaUsuarioOriginal(),resultSet,CajaDiariaUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaDiariaUsuarioOriginal(CajaDiariaUsuarioDataAccess.getEntityCajaDiariaUsuario("",entity.getCajaDiariaUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CajaDiariaUsuario> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaDiariaUsuario> entities = new  ArrayList<CajaDiariaUsuario>();
		CajaDiariaUsuario entity = new CajaDiariaUsuario();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CajaDiariaUsuario.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CajaDiariaUsuario>((List<CajaDiariaUsuario>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCajaDiariaUsuariosOriginal(entities);
			
			}  else {
				this.cajadiariausuariosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CajaDiariaUsuarioConstantesFunciones.quitarEspaciosCajaDiariaUsuarios(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CajaDiariaUsuario getEntityCajaDiariaUsuario(String strPrefijo,CajaDiariaUsuario entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_cliente(resultSet.getLong(strPrefijo+CajaDiariaUsuarioConstantesFunciones.IDCLIENTE));
			entity.setid_caja(resultSet.getLong(strPrefijo+CajaDiariaUsuarioConstantesFunciones.IDCAJA));
			entity.setid_usuario(resultSet.getLong(strPrefijo+CajaDiariaUsuarioConstantesFunciones.IDUSUARIO));
			entity.setnombre_caja(resultSet.getString(strPrefijo+CajaDiariaUsuarioConstantesFunciones.NOMBRECAJA));
			entity.setnombre_usuario(resultSet.getString(strPrefijo+CajaDiariaUsuarioConstantesFunciones.NOMBREUSUARIO));
			entity.setsecuencial(resultSet.getString(strPrefijo+CajaDiariaUsuarioConstantesFunciones.SECUENCIAL));
			entity.setcodigo_cliente(resultSet.getString(strPrefijo+CajaDiariaUsuarioConstantesFunciones.CODIGOCLIENTE));
			entity.setnombre_cliente(resultSet.getString(strPrefijo+CajaDiariaUsuarioConstantesFunciones.NOMBRECLIENTE));
			entity.setsubtotal(resultSet.getDouble(strPrefijo+CajaDiariaUsuarioConstantesFunciones.SUBTOTAL));
			entity.setiva(resultSet.getDouble(strPrefijo+CajaDiariaUsuarioConstantesFunciones.IVA));
			entity.setdescuento(resultSet.getDouble(strPrefijo+CajaDiariaUsuarioConstantesFunciones.DESCUENTO));
			entity.setfinanciamiento(resultSet.getDouble(strPrefijo+CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO));
			entity.setflete(resultSet.getDouble(strPrefijo+CajaDiariaUsuarioConstantesFunciones.FLETE));
			entity.setice(resultSet.getDouble(strPrefijo+CajaDiariaUsuarioConstantesFunciones.ICE));
			entity.settotal(resultSet.getDouble(strPrefijo+CajaDiariaUsuarioConstantesFunciones.TOTAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CajaDiariaUsuario getEntityCajaDiariaUsuario(String strPrefijo,CajaDiariaUsuario entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CajaDiariaUsuario.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CajaDiariaUsuario.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CajaDiariaUsuarioLogic.setFieldReflectionCajaDiariaUsuario(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCajaDiariaUsuario(Field field,String strPrefijo,String sColumn,CajaDiariaUsuario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CajaDiariaUsuarioConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.NOMBRECAJA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.NOMBREUSUARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.CODIGOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CajaDiariaUsuarioConstantesFunciones.TOTAL:
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
	
	public void quitarCajaDiariaUsuariosNulos() throws Exception {				
		
		List<CajaDiariaUsuario> cajadiariausuariosAux= new ArrayList<CajaDiariaUsuario>();
		
		for(CajaDiariaUsuario cajadiariausuario:cajadiariausuarios) {
			if(cajadiariausuario!=null) {
				cajadiariausuariosAux.add(cajadiariausuario);
			}
		}
		
		cajadiariausuarios=cajadiariausuariosAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CajaDiariaUsuario> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaDiariaUsuario> entities = new  ArrayList<CajaDiariaUsuario>();
		CajaDiariaUsuario entity = new CajaDiariaUsuario();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CajaDiariaUsuario>((List<CajaDiariaUsuario>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCajaDiariaUsuariosOriginal(entities);
			
			}  else {
				this.cajadiariausuariosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CajaDiariaUsuarioConstantesFunciones.quitarEspaciosCajaDiariaUsuarios(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cajadiariausuarios = new  ArrayList<CajaDiariaUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CajaDiariaUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariausuarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cajadiariausuarios = new  ArrayList<CajaDiariaUsuario>();
		  		  
        try {
			//CajaDiariaUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajadiariausuarios=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CajaDiariaUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaDiariaUsuario> entities = new  ArrayList<CajaDiariaUsuario>();
		CajaDiariaUsuario entity = new CajaDiariaUsuario();		  
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
	
	public  List<CajaDiariaUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaDiariaUsuario> entities = new  ArrayList<CajaDiariaUsuario>();
		CajaDiariaUsuario entity = new CajaDiariaUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaDiariaUsuario();
				
				if(conMapGenerico) {
					entity.setMapCajaDiariaUsuario( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCajaDiariaUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaDiariaUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=CajaDiariaUsuarioLogic.getEntityCajaDiariaUsuario("",entity,resultSet,listColumns);
					
					////entity.setCajaDiariaUsuarioOriginal( new CajaDiariaUsuario());
					////entity.setCajaDiariaUsuarioOriginal(super.getEntity("",entity.getCajaDiariaUsuarioOriginal(),resultSet,CajaDiariaUsuarioDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaDiariaUsuarioOriginal(CajaDiariaUsuarioDataAccess.getEntityCajaDiariaUsuario("",entity.getCajaDiariaUsuarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CajaDiariaUsuario relcajadiariausuario)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcajadiariausuario.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,CajaDiariaUsuario relcajadiariausuario)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relcajadiariausuario.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Caja getCaja(Connexion connexion,CajaDiariaUsuario relcajadiariausuario)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);
			cajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			caja=cajaDataAccess.getEntity(connexion,relcajadiariausuario.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}

	public Usuario getUsuario(Connexion connexion,CajaDiariaUsuario relcajadiariausuario)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);
			usuarioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			usuario=usuarioDataAccess.getEntity(connexion,relcajadiariausuario.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}


	
	
	public void getCajaDiariaUsuariosBusquedaCajaDiariaUsuarioWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_usuario,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//CajaDiariaUsuarioLogic cajadiariausuarioLogic=new CajaDiariaUsuarioLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CajaDiariaUsuarioLogic.GetSelecSqlCajaDiariaUsuario(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_usuario,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cajadiariausuarios=this.getCajaDiariaUsuarios();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCajaDiariaUsuariosBusquedaCajaDiariaUsuario(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_usuario,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//CajaDiariaUsuarioLogic cajadiariausuarioLogic=new CajaDiariaUsuarioLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CajaDiariaUsuarioLogic.GetSelecSqlCajaDiariaUsuario(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_usuario,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cajadiariausuarios=this.getCajaDiariaUsuarios();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCajaDiariaUsuario(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_usuario,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CajaDiariaUsuario_Postgres.sql");
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
				

				if(id_usuario!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_usuario = "+id_usuario.toString();
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
	
	
	public void deepLoad(CajaDiariaUsuario cajadiariausuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CajaDiariaUsuarioLogicAdditional.updateCajaDiariaUsuarioToGet(cajadiariausuario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajadiariausuario.setEmpresa(cajadiariausuarioDataAccess.getEmpresa(connexion,cajadiariausuario));
		cajadiariausuario.setCliente(cajadiariausuarioDataAccess.getCliente(connexion,cajadiariausuario));
		cajadiariausuario.setCaja(cajadiariausuarioDataAccess.getCaja(connexion,cajadiariausuario));
		cajadiariausuario.setUsuario(cajadiariausuarioDataAccess.getUsuario(connexion,cajadiariausuario));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajadiariausuario.setEmpresa(cajadiariausuarioDataAccess.getEmpresa(connexion,cajadiariausuario));
			}

			if(clas.clas.equals(Cliente.class)) {
				cajadiariausuario.setCliente(cajadiariausuarioDataAccess.getCliente(connexion,cajadiariausuario));
			}

			if(clas.clas.equals(Caja.class)) {
				cajadiariausuario.setCaja(cajadiariausuarioDataAccess.getCaja(connexion,cajadiariausuario));
			}

			if(clas.clas.equals(Usuario.class)) {
				cajadiariausuario.setUsuario(cajadiariausuarioDataAccess.getUsuario(connexion,cajadiariausuario));
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
			cajadiariausuario.setEmpresa(cajadiariausuarioDataAccess.getEmpresa(connexion,cajadiariausuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariausuario.setCliente(cajadiariausuarioDataAccess.getCliente(connexion,cajadiariausuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariausuario.setCaja(cajadiariausuarioDataAccess.getCaja(connexion,cajadiariausuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariausuario.setUsuario(cajadiariausuarioDataAccess.getUsuario(connexion,cajadiariausuario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajadiariausuario.setEmpresa(cajadiariausuarioDataAccess.getEmpresa(connexion,cajadiariausuario));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajadiariausuario.getEmpresa(),isDeep,deepLoadType,clases);
				
		cajadiariausuario.setCliente(cajadiariausuarioDataAccess.getCliente(connexion,cajadiariausuario));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cajadiariausuario.getCliente(),isDeep,deepLoadType,clases);
				
		cajadiariausuario.setCaja(cajadiariausuarioDataAccess.getCaja(connexion,cajadiariausuario));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajadiariausuario.getCaja(),isDeep,deepLoadType,clases);
				
		cajadiariausuario.setUsuario(cajadiariausuarioDataAccess.getUsuario(connexion,cajadiariausuario));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(cajadiariausuario.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajadiariausuario.setEmpresa(cajadiariausuarioDataAccess.getEmpresa(connexion,cajadiariausuario));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cajadiariausuario.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				cajadiariausuario.setCliente(cajadiariausuarioDataAccess.getCliente(connexion,cajadiariausuario));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cajadiariausuario.getCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Caja.class)) {
				cajadiariausuario.setCaja(cajadiariausuarioDataAccess.getCaja(connexion,cajadiariausuario));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(cajadiariausuario.getCaja(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Usuario.class)) {
				cajadiariausuario.setUsuario(cajadiariausuarioDataAccess.getUsuario(connexion,cajadiariausuario));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(cajadiariausuario.getUsuario(),isDeep,deepLoadType,clases);				
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
			cajadiariausuario.setEmpresa(cajadiariausuarioDataAccess.getEmpresa(connexion,cajadiariausuario));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cajadiariausuario.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariausuario.setCliente(cajadiariausuarioDataAccess.getCliente(connexion,cajadiariausuario));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cajadiariausuario.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariausuario.setCaja(cajadiariausuarioDataAccess.getCaja(connexion,cajadiariausuario));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(cajadiariausuario.getCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajadiariausuario.setUsuario(cajadiariausuarioDataAccess.getUsuario(connexion,cajadiariausuario));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(cajadiariausuario.getUsuario(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cajadiariausuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaDiariaUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesCajaDiariaUsuario(cajadiariausuario);
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
			this.deepLoad(this.cajadiariausuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaDiariaUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesCajaDiariaUsuario(this.cajadiariausuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cajadiariausuarios!=null) {
				for(CajaDiariaUsuario cajadiariausuario:cajadiariausuarios) {
					this.deepLoad(cajadiariausuario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CajaDiariaUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesCajaDiariaUsuario(cajadiariausuarios);
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
			if(cajadiariausuarios!=null) {
				for(CajaDiariaUsuario cajadiariausuario:cajadiariausuarios) {
					this.deepLoad(cajadiariausuario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CajaDiariaUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesCajaDiariaUsuario(cajadiariausuarios);
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
	
	public CajaDiariaUsuarioParameterReturnGeneral procesarAccionCajaDiariaUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaDiariaUsuario> cajadiariausuarios,CajaDiariaUsuarioParameterReturnGeneral cajadiariausuarioParameterGeneral)throws Exception {
		 try {	
			CajaDiariaUsuarioParameterReturnGeneral cajadiariausuarioReturnGeneral=new CajaDiariaUsuarioParameterReturnGeneral();
	
			CajaDiariaUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajadiariausuarios,cajadiariausuarioParameterGeneral,cajadiariausuarioReturnGeneral);
			
			return cajadiariausuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaDiariaUsuarioParameterReturnGeneral procesarAccionCajaDiariaUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaDiariaUsuario> cajadiariausuarios,CajaDiariaUsuarioParameterReturnGeneral cajadiariausuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CajaDiariaUsuarioParameterReturnGeneral cajadiariausuarioReturnGeneral=new CajaDiariaUsuarioParameterReturnGeneral();
	
			CajaDiariaUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajadiariausuarios,cajadiariausuarioParameterGeneral,cajadiariausuarioReturnGeneral);
			
			this.connexion.commit();
			
			return cajadiariausuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

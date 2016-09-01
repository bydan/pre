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
import com.bydan.erp.puntoventa.util.report.PagosTarjetasParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.PagosTarjetasParameterGeneral;
import com.bydan.erp.puntoventa.util.report.PagosTarjetasConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.PagosTarjetas;

import com.bydan.erp.puntoventa.business.logic.report.PagosTarjetasLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class PagosTarjetasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(PagosTarjetasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected PagosTarjetasLogic pagostarjetasDataAccess; 		
	protected PagosTarjetas pagostarjetas;
	protected List<PagosTarjetas> pagostarjetass;
	protected Object pagostarjetasObject;	
	protected List<Object> pagostarjetassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  PagosTarjetasLogic()throws SQLException,Exception {
		try	{
			this.pagostarjetass= new ArrayList<PagosTarjetas>();
			this.pagostarjetas= new PagosTarjetas();
			this.pagostarjetasObject=new Object();
			this.pagostarjetassObject=new ArrayList<Object>();
			
			this.pagostarjetasDataAccess=this;
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
			this.pagostarjetasDataAccess.setConnexionType(this.connexionType);
			this.pagostarjetasDataAccess.setParameterDbType(this.parameterDbType);
			this.pagostarjetasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PagosTarjetasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.pagostarjetass= new ArrayList<PagosTarjetas>();
			this.pagostarjetas= new PagosTarjetas();
			this.pagostarjetasObject=new Object();
			this.pagostarjetassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.pagostarjetasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.pagostarjetasDataAccess.setConnexionType(this.connexionType);
			this.pagostarjetasDataAccess.setParameterDbType(this.parameterDbType);
			this.pagostarjetasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PagosTarjetas getPagosTarjetas() throws Exception {	
		PagosTarjetasLogicAdditional.checkPagosTarjetasToGet(pagostarjetas,this.datosCliente,this.arrDatoGeneral);
		PagosTarjetasLogicAdditional.updatePagosTarjetasToGet(pagostarjetas,this.arrDatoGeneral);
		
		return pagostarjetas;
	}
		
	public void setPagosTarjetas(PagosTarjetas newPagosTarjetas) {
		this.pagostarjetas = newPagosTarjetas;
	}
	
	public List<PagosTarjetas> getPagosTarjetass() throws Exception {		
		this.quitarPagosTarjetassNulos();
		
		PagosTarjetasLogicAdditional.checkPagosTarjetasToGets(pagostarjetass,this.datosCliente,this.arrDatoGeneral);
		
		for (PagosTarjetas pagostarjetasLocal: pagostarjetass ) {
			PagosTarjetasLogicAdditional.updatePagosTarjetasToGet(pagostarjetasLocal,this.arrDatoGeneral);
		}
		
		return pagostarjetass;
	}
	
	public void setPagosTarjetass(List<PagosTarjetas> newPagosTarjetass) {
		this.pagostarjetass = newPagosTarjetass;
	}
	
	public Object getPagosTarjetasObject() {	
		//this.pagostarjetasObject=this.pagostarjetasDataAccess.getEntityObject();
		return this.pagostarjetasObject;
	}
		
	public void setPagosTarjetasObject(Object newPagosTarjetasObject) {
		this.pagostarjetasObject = newPagosTarjetasObject;
	}
	
	public List<Object> getPagosTarjetassObject() {		
		//this.pagostarjetassObject=this.pagostarjetasDataAccess.getEntitiesObject();
		return this.pagostarjetassObject;
	}
		
	public void setPagosTarjetassObject(List<Object> newPagosTarjetassObject) {
		this.pagostarjetassObject = newPagosTarjetassObject;
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
		pagostarjetass = new  ArrayList<PagosTarjetas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosTarjetasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagostarjetass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		pagostarjetass = new  ArrayList<PagosTarjetas>();
		  		  
        try {
			//PagosTarjetasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagostarjetass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pagostarjetass = new  ArrayList<PagosTarjetas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosTarjetasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagostarjetass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		pagostarjetass = new  ArrayList<PagosTarjetas>();
		  		  
        try {
			//PagosTarjetasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagostarjetass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		pagostarjetass = new  ArrayList<PagosTarjetas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosTarjetasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagostarjetass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		pagostarjetass = new  ArrayList<PagosTarjetas>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//PagosTarjetasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagostarjetass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<PagosTarjetas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosTarjetas> entities = new  ArrayList<PagosTarjetas>();
		PagosTarjetas entity = new PagosTarjetas();		  
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
	
	public  List<PagosTarjetas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosTarjetas> entities = new  ArrayList<PagosTarjetas>();
		PagosTarjetas entity = new PagosTarjetas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagosTarjetas();
				
				
      	    	entity=PagosTarjetasLogic.getEntityPagosTarjetas("",entity,resultSet);
      	    	
				//entity.setPagosTarjetasOriginal( new PagosTarjetas());
      	    	//entity.setPagosTarjetasOriginal(super.getEntity("",entity.getPagosTarjetasOriginal(),resultSet,PagosTarjetasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPagosTarjetasOriginal(PagosTarjetasDataAccess.getEntityPagosTarjetas("",entity.getPagosTarjetasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<PagosTarjetas> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosTarjetas> entities = new  ArrayList<PagosTarjetas>();
		PagosTarjetas entity = new PagosTarjetas();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,PagosTarjetas.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PagosTarjetas>((List<PagosTarjetas>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPagosTarjetassOriginal(entities);
			
			}  else {
				this.pagostarjetassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PagosTarjetasConstantesFunciones.quitarEspaciosPagosTarjetass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static PagosTarjetas getEntityPagosTarjetas(String strPrefijo,PagosTarjetas entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setcodigo_asiento_contable(resultSet.getString(strPrefijo+PagosTarjetasConstantesFunciones.CODIGOASIENTOCONTABLE));
			entity.setcodigo_tarjeta_credito(resultSet.getString(strPrefijo+PagosTarjetasConstantesFunciones.CODIGOTARJETACREDITO));
			entity.setnombre_tipo_interes_tarjeta(resultSet.getString(strPrefijo+PagosTarjetasConstantesFunciones.NOMBRETIPOINTERESTARJETA));
			entity.setnombre_conexion(resultSet.getString(strPrefijo+PagosTarjetasConstantesFunciones.NOMBRECONEXION));
			entity.setnombre_mes(resultSet.getString(strPrefijo+PagosTarjetasConstantesFunciones.NOMBREMES));
			entity.setnumero(resultSet.getString(strPrefijo+PagosTarjetasConstantesFunciones.NUMERO));
			entity.setlote(resultSet.getString(strPrefijo+PagosTarjetasConstantesFunciones.LOTE));
			entity.setvalor(resultSet.getDouble(strPrefijo+PagosTarjetasConstantesFunciones.VALOR));
			entity.setvalor_retencion(resultSet.getDouble(strPrefijo+PagosTarjetasConstantesFunciones.VALORRETENCION));
			entity.setvalor_comision(resultSet.getDouble(strPrefijo+PagosTarjetasConstantesFunciones.VALORCOMISION));
			entity.setvalor_calculado(resultSet.getDouble(strPrefijo+PagosTarjetasConstantesFunciones.VALORCALCULADO));
			entity.setvalor_cancelado(resultSet.getDouble(strPrefijo+PagosTarjetasConstantesFunciones.VALORCANCELADO));
			entity.setvalor_difiere(resultSet.getDouble(strPrefijo+PagosTarjetasConstantesFunciones.VALORDIFIERE));
			entity.setnumero_retencion(resultSet.getString(strPrefijo+PagosTarjetasConstantesFunciones.NUMERORETENCION));
			entity.setnumero_liquidacion(resultSet.getString(strPrefijo+PagosTarjetasConstantesFunciones.NUMEROLIQUIDACION));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+PagosTarjetasConstantesFunciones.FECHA).getTime()));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PagosTarjetas getEntityPagosTarjetas(String strPrefijo,PagosTarjetas entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = PagosTarjetas.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = PagosTarjetas.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				PagosTarjetasLogic.setFieldReflectionPagosTarjetas(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPagosTarjetas(Field field,String strPrefijo,String sColumn,PagosTarjetas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PagosTarjetasConstantesFunciones.CODIGOASIENTOCONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.CODIGOTARJETACREDITO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.NOMBRETIPOINTERESTARJETA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.NOMBRECONEXION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.NOMBREMES:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.VALORRETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.VALORCOMISION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.VALORCALCULADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.VALORCANCELADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.VALORDIFIERE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.NUMERORETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.NUMEROLIQUIDACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagosTarjetasConstantesFunciones.FECHA:
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
	
	public void quitarPagosTarjetassNulos() throws Exception {				
		
		List<PagosTarjetas> pagostarjetassAux= new ArrayList<PagosTarjetas>();
		
		for(PagosTarjetas pagostarjetas:pagostarjetass) {
			if(pagostarjetas!=null) {
				pagostarjetassAux.add(pagostarjetas);
			}
		}
		
		pagostarjetass=pagostarjetassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<PagosTarjetas> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagosTarjetas> entities = new  ArrayList<PagosTarjetas>();
		PagosTarjetas entity = new PagosTarjetas();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PagosTarjetas>((List<PagosTarjetas>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPagosTarjetassOriginal(entities);
			
			}  else {
				this.pagostarjetassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PagosTarjetasConstantesFunciones.quitarEspaciosPagosTarjetass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		pagostarjetass = new  ArrayList<PagosTarjetas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PagosTarjetasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagostarjetass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		pagostarjetass = new  ArrayList<PagosTarjetas>();
		  		  
        try {
			//PagosTarjetasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagostarjetass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<PagosTarjetas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PagosTarjetas> entities = new  ArrayList<PagosTarjetas>();
		PagosTarjetas entity = new PagosTarjetas();		  
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
	
	public  List<PagosTarjetas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PagosTarjetas> entities = new  ArrayList<PagosTarjetas>();
		PagosTarjetas entity = new PagosTarjetas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagosTarjetas();
				
				if(conMapGenerico) {
					entity.setMapPagosTarjetas( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapPagosTarjetas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PagosTarjetasDataAccess.ISWITHSCHEMA);         		
					entity=PagosTarjetasLogic.getEntityPagosTarjetas("",entity,resultSet,listColumns);
					
					////entity.setPagosTarjetasOriginal( new PagosTarjetas());
					////entity.setPagosTarjetasOriginal(super.getEntity("",entity.getPagosTarjetasOriginal(),resultSet,PagosTarjetasDataAccess.ISWITHSCHEMA));         		
					////entity.setPagosTarjetasOriginal(PagosTarjetasDataAccess.getEntityPagosTarjetas("",entity.getPagosTarjetasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,PagosTarjetas relpagostarjetas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relpagostarjetas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getPagosTarjetassBusquedaPagosTarjetasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_hasta)throws Exception {
		try {
			//PagosTarjetasLogic pagostarjetasLogic=new PagosTarjetasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PagosTarjetasLogic.GetSelecSqlPagosTarjetas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.pagostarjetass=this.getPagosTarjetass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getPagosTarjetassBusquedaPagosTarjetas(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_hasta)throws Exception {
		try {
			//PagosTarjetasLogic pagostarjetasLogic=new PagosTarjetasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PagosTarjetasLogic.GetSelecSqlPagosTarjetas(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.pagostarjetass=this.getPagosTarjetass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlPagosTarjetas(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("PagosTarjetas_Postgres.sql");
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
				

				if(fecha_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.fecha<="+"'"+Funciones2.getStringPostgresDate(fecha_hasta)+"'";
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
	
	
	public void deepLoad(PagosTarjetas pagostarjetas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PagosTarjetasLogicAdditional.updatePagosTarjetasToGet(pagostarjetas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pagostarjetas.setEmpresa(pagostarjetasDataAccess.getEmpresa(connexion,pagostarjetas));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pagostarjetas.setEmpresa(pagostarjetasDataAccess.getEmpresa(connexion,pagostarjetas));
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
			pagostarjetas.setEmpresa(pagostarjetasDataAccess.getEmpresa(connexion,pagostarjetas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pagostarjetas.setEmpresa(pagostarjetasDataAccess.getEmpresa(connexion,pagostarjetas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pagostarjetas.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pagostarjetas.setEmpresa(pagostarjetasDataAccess.getEmpresa(connexion,pagostarjetas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pagostarjetas.getEmpresa(),isDeep,deepLoadType,clases);				
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
			pagostarjetas.setEmpresa(pagostarjetasDataAccess.getEmpresa(connexion,pagostarjetas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pagostarjetas.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(pagostarjetas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PagosTarjetasConstantesFunciones.refrescarForeignKeysDescripcionesPagosTarjetas(pagostarjetas);
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
			this.deepLoad(this.pagostarjetas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PagosTarjetasConstantesFunciones.refrescarForeignKeysDescripcionesPagosTarjetas(this.pagostarjetas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(pagostarjetass!=null) {
				for(PagosTarjetas pagostarjetas:pagostarjetass) {
					this.deepLoad(pagostarjetas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PagosTarjetasConstantesFunciones.refrescarForeignKeysDescripcionesPagosTarjetas(pagostarjetass);
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
			if(pagostarjetass!=null) {
				for(PagosTarjetas pagostarjetas:pagostarjetass) {
					this.deepLoad(pagostarjetas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PagosTarjetasConstantesFunciones.refrescarForeignKeysDescripcionesPagosTarjetas(pagostarjetass);
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
	
	public PagosTarjetasParameterReturnGeneral procesarAccionPagosTarjetass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PagosTarjetas> pagostarjetass,PagosTarjetasParameterReturnGeneral pagostarjetasParameterGeneral)throws Exception {
		 try {	
			PagosTarjetasParameterReturnGeneral pagostarjetasReturnGeneral=new PagosTarjetasParameterReturnGeneral();
	
			PagosTarjetasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pagostarjetass,pagostarjetasParameterGeneral,pagostarjetasReturnGeneral);
			
			return pagostarjetasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PagosTarjetasParameterReturnGeneral procesarAccionPagosTarjetassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PagosTarjetas> pagostarjetass,PagosTarjetasParameterReturnGeneral pagostarjetasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			PagosTarjetasParameterReturnGeneral pagostarjetasReturnGeneral=new PagosTarjetasParameterReturnGeneral();
	
			PagosTarjetasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pagostarjetass,pagostarjetasParameterGeneral,pagostarjetasReturnGeneral);
			
			this.connexion.commit();
			
			return pagostarjetasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

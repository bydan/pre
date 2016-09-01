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
import com.bydan.erp.puntoventa.util.report.TarjetasCreditosParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.TarjetasCreditosParameterGeneral;
import com.bydan.erp.puntoventa.util.report.TarjetasCreditosConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.TarjetasCreditos;

import com.bydan.erp.puntoventa.business.logic.report.TarjetasCreditosLogicAdditional;
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
public class TarjetasCreditosLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(TarjetasCreditosLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected TarjetasCreditosLogic tarjetascreditosDataAccess; 		
	protected TarjetasCreditos tarjetascreditos;
	protected List<TarjetasCreditos> tarjetascreditoss;
	protected Object tarjetascreditosObject;	
	protected List<Object> tarjetascreditossObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  TarjetasCreditosLogic()throws SQLException,Exception {
		try	{
			this.tarjetascreditoss= new ArrayList<TarjetasCreditos>();
			this.tarjetascreditos= new TarjetasCreditos();
			this.tarjetascreditosObject=new Object();
			this.tarjetascreditossObject=new ArrayList<Object>();
			
			this.tarjetascreditosDataAccess=this;
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
			this.tarjetascreditosDataAccess.setConnexionType(this.connexionType);
			this.tarjetascreditosDataAccess.setParameterDbType(this.parameterDbType);
			this.tarjetascreditosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TarjetasCreditosLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.tarjetascreditoss= new ArrayList<TarjetasCreditos>();
			this.tarjetascreditos= new TarjetasCreditos();
			this.tarjetascreditosObject=new Object();
			this.tarjetascreditossObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.tarjetascreditosDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.tarjetascreditosDataAccess.setConnexionType(this.connexionType);
			this.tarjetascreditosDataAccess.setParameterDbType(this.parameterDbType);
			this.tarjetascreditosDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TarjetasCreditos getTarjetasCreditos() throws Exception {	
		TarjetasCreditosLogicAdditional.checkTarjetasCreditosToGet(tarjetascreditos,this.datosCliente,this.arrDatoGeneral);
		TarjetasCreditosLogicAdditional.updateTarjetasCreditosToGet(tarjetascreditos,this.arrDatoGeneral);
		
		return tarjetascreditos;
	}
		
	public void setTarjetasCreditos(TarjetasCreditos newTarjetasCreditos) {
		this.tarjetascreditos = newTarjetasCreditos;
	}
	
	public List<TarjetasCreditos> getTarjetasCreditoss() throws Exception {		
		this.quitarTarjetasCreditossNulos();
		
		TarjetasCreditosLogicAdditional.checkTarjetasCreditosToGets(tarjetascreditoss,this.datosCliente,this.arrDatoGeneral);
		
		for (TarjetasCreditos tarjetascreditosLocal: tarjetascreditoss ) {
			TarjetasCreditosLogicAdditional.updateTarjetasCreditosToGet(tarjetascreditosLocal,this.arrDatoGeneral);
		}
		
		return tarjetascreditoss;
	}
	
	public void setTarjetasCreditoss(List<TarjetasCreditos> newTarjetasCreditoss) {
		this.tarjetascreditoss = newTarjetasCreditoss;
	}
	
	public Object getTarjetasCreditosObject() {	
		//this.tarjetascreditosObject=this.tarjetascreditosDataAccess.getEntityObject();
		return this.tarjetascreditosObject;
	}
		
	public void setTarjetasCreditosObject(Object newTarjetasCreditosObject) {
		this.tarjetascreditosObject = newTarjetasCreditosObject;
	}
	
	public List<Object> getTarjetasCreditossObject() {		
		//this.tarjetascreditossObject=this.tarjetascreditosDataAccess.getEntitiesObject();
		return this.tarjetascreditossObject;
	}
		
	public void setTarjetasCreditossObject(List<Object> newTarjetasCreditossObject) {
		this.tarjetascreditossObject = newTarjetasCreditossObject;
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
		tarjetascreditoss = new  ArrayList<TarjetasCreditos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TarjetasCreditosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetascreditoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		tarjetascreditoss = new  ArrayList<TarjetasCreditos>();
		  		  
        try {
			//TarjetasCreditosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetascreditoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tarjetascreditoss = new  ArrayList<TarjetasCreditos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TarjetasCreditosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetascreditoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		tarjetascreditoss = new  ArrayList<TarjetasCreditos>();
		  		  
        try {
			//TarjetasCreditosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetascreditoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		tarjetascreditoss = new  ArrayList<TarjetasCreditos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TarjetasCreditosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetascreditoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		tarjetascreditoss = new  ArrayList<TarjetasCreditos>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//TarjetasCreditosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetascreditoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<TarjetasCreditos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetasCreditos> entities = new  ArrayList<TarjetasCreditos>();
		TarjetasCreditos entity = new TarjetasCreditos();		  
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
	
	public  List<TarjetasCreditos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetasCreditos> entities = new  ArrayList<TarjetasCreditos>();
		TarjetasCreditos entity = new TarjetasCreditos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetasCreditos();
				
				
      	    	entity=TarjetasCreditosLogic.getEntityTarjetasCreditos("",entity,resultSet);
      	    	
				//entity.setTarjetasCreditosOriginal( new TarjetasCreditos());
      	    	//entity.setTarjetasCreditosOriginal(super.getEntity("",entity.getTarjetasCreditosOriginal(),resultSet,TarjetasCreditosDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetasCreditosOriginal(TarjetasCreditosDataAccess.getEntityTarjetasCreditos("",entity.getTarjetasCreditosOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<TarjetasCreditos> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetasCreditos> entities = new  ArrayList<TarjetasCreditos>();
		TarjetasCreditos entity = new TarjetasCreditos();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,TarjetasCreditos.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<TarjetasCreditos>((List<TarjetasCreditos>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setTarjetasCreditossOriginal(entities);
			
			}  else {
				this.tarjetascreditossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//TarjetasCreditosConstantesFunciones.quitarEspaciosTarjetasCreditoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static TarjetasCreditos getEntityTarjetasCreditos(String strPrefijo,TarjetasCreditos entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_tarjeta_credito(resultSet.getLong(strPrefijo+TarjetasCreditosConstantesFunciones.IDTARJETACREDITO));
			entity.setnombre_tarjeta(resultSet.getString(strPrefijo+TarjetasCreditosConstantesFunciones.NOMBRETARJETA));
			entity.setlote(resultSet.getString(strPrefijo+TarjetasCreditosConstantesFunciones.LOTE));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+TarjetasCreditosConstantesFunciones.FECHA).getTime()));
			entity.settotal(resultSet.getDouble(strPrefijo+TarjetasCreditosConstantesFunciones.TOTAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TarjetasCreditos getEntityTarjetasCreditos(String strPrefijo,TarjetasCreditos entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = TarjetasCreditos.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = TarjetasCreditos.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				TarjetasCreditosLogic.setFieldReflectionTarjetasCreditos(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTarjetasCreditos(Field field,String strPrefijo,String sColumn,TarjetasCreditos entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TarjetasCreditosConstantesFunciones.IDTARJETACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetasCreditosConstantesFunciones.NOMBRETARJETA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TarjetasCreditosConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TarjetasCreditosConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TarjetasCreditosConstantesFunciones.TOTAL:
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
	
	public void quitarTarjetasCreditossNulos() throws Exception {				
		
		List<TarjetasCreditos> tarjetascreditossAux= new ArrayList<TarjetasCreditos>();
		
		for(TarjetasCreditos tarjetascreditos:tarjetascreditoss) {
			if(tarjetascreditos!=null) {
				tarjetascreditossAux.add(tarjetascreditos);
			}
		}
		
		tarjetascreditoss=tarjetascreditossAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<TarjetasCreditos> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetasCreditos> entities = new  ArrayList<TarjetasCreditos>();
		TarjetasCreditos entity = new TarjetasCreditos();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<TarjetasCreditos>((List<TarjetasCreditos>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setTarjetasCreditossOriginal(entities);
			
			}  else {
				this.tarjetascreditossObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//TarjetasCreditosConstantesFunciones.quitarEspaciosTarjetasCreditoss(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		tarjetascreditoss = new  ArrayList<TarjetasCreditos>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//TarjetasCreditosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetascreditoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		tarjetascreditoss = new  ArrayList<TarjetasCreditos>();
		  		  
        try {
			//TarjetasCreditosLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetascreditoss=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<TarjetasCreditos> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<TarjetasCreditos> entities = new  ArrayList<TarjetasCreditos>();
		TarjetasCreditos entity = new TarjetasCreditos();		  
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
	
	public  List<TarjetasCreditos> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<TarjetasCreditos> entities = new  ArrayList<TarjetasCreditos>();
		TarjetasCreditos entity = new TarjetasCreditos();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetasCreditos();
				
				if(conMapGenerico) {
					entity.setMapTarjetasCreditos( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapTarjetasCreditos().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TarjetasCreditosDataAccess.ISWITHSCHEMA);         		
					entity=TarjetasCreditosLogic.getEntityTarjetasCreditos("",entity,resultSet,listColumns);
					
					////entity.setTarjetasCreditosOriginal( new TarjetasCreditos());
					////entity.setTarjetasCreditosOriginal(super.getEntity("",entity.getTarjetasCreditosOriginal(),resultSet,TarjetasCreditosDataAccess.ISWITHSCHEMA));         		
					////entity.setTarjetasCreditosOriginal(TarjetasCreditosDataAccess.getEntityTarjetasCreditos("",entity.getTarjetasCreditosOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,TarjetasCreditos reltarjetascreditos)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,reltarjetascreditos.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TarjetasCreditos reltarjetascreditos)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,reltarjetascreditos.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TarjetaCredito getTarjetaCredito(Connexion connexion,TarjetasCreditos reltarjetascreditos)throws SQLException,Exception {

		TarjetaCredito tarjetacredito= new TarjetaCredito();

		try {
			TarjetaCreditoDataAccess tarjetacreditoDataAccess=new TarjetaCreditoDataAccess();

			tarjetacreditoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tarjetacreditoDataAccess.setConnexionType(this.connexionType);
			tarjetacreditoDataAccess.setParameterDbType(this.parameterDbType);
			tarjetacreditoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion,reltarjetascreditos.getid_tarjeta_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacredito;

	}


	
	
	public void getTarjetasCreditossBusquedaTarjetaCreditoWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//TarjetasCreditosLogic tarjetascreditosLogic=new TarjetasCreditosLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=TarjetasCreditosLogic.GetSelecSqlTarjetasCreditosBusquedaTarjetaCredito(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.tarjetascreditoss=this.getTarjetasCreditoss();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getTarjetasCreditossBusquedaTarjetaCredito(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//TarjetasCreditosLogic tarjetascreditosLogic=new TarjetasCreditosLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=TarjetasCreditosLogic.GetSelecSqlTarjetasCreditosBusquedaTarjetaCredito(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.tarjetascreditoss=this.getTarjetasCreditoss();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlTarjetasCreditosBusquedaTarjetaCredito(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("TarjetasCreditos_Postgres.sql");
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
	
	
	public void deepLoad(TarjetasCreditos tarjetascreditos,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TarjetasCreditosLogicAdditional.updateTarjetasCreditosToGet(tarjetascreditos,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tarjetascreditos.setEmpresa(tarjetascreditosDataAccess.getEmpresa(connexion,tarjetascreditos));
		tarjetascreditos.setSucursal(tarjetascreditosDataAccess.getSucursal(connexion,tarjetascreditos));
		tarjetascreditos.setTarjetaCredito(tarjetascreditosDataAccess.getTarjetaCredito(connexion,tarjetascreditos));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tarjetascreditos.setEmpresa(tarjetascreditosDataAccess.getEmpresa(connexion,tarjetascreditos));
			}

			if(clas.clas.equals(Sucursal.class)) {
				tarjetascreditos.setSucursal(tarjetascreditosDataAccess.getSucursal(connexion,tarjetascreditos));
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				tarjetascreditos.setTarjetaCredito(tarjetascreditosDataAccess.getTarjetaCredito(connexion,tarjetascreditos));
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
			tarjetascreditos.setEmpresa(tarjetascreditosDataAccess.getEmpresa(connexion,tarjetascreditos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetascreditos.setSucursal(tarjetascreditosDataAccess.getSucursal(connexion,tarjetascreditos));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetascreditos.setTarjetaCredito(tarjetascreditosDataAccess.getTarjetaCredito(connexion,tarjetascreditos));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tarjetascreditos.setEmpresa(tarjetascreditosDataAccess.getEmpresa(connexion,tarjetascreditos));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tarjetascreditos.getEmpresa(),isDeep,deepLoadType,clases);
				
		tarjetascreditos.setSucursal(tarjetascreditosDataAccess.getSucursal(connexion,tarjetascreditos));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tarjetascreditos.getSucursal(),isDeep,deepLoadType,clases);
				
		tarjetascreditos.setTarjetaCredito(tarjetascreditosDataAccess.getTarjetaCredito(connexion,tarjetascreditos));
		TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
		tarjetacreditoLogic.deepLoad(tarjetascreditos.getTarjetaCredito(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tarjetascreditos.setEmpresa(tarjetascreditosDataAccess.getEmpresa(connexion,tarjetascreditos));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tarjetascreditos.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				tarjetascreditos.setSucursal(tarjetascreditosDataAccess.getSucursal(connexion,tarjetascreditos));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(tarjetascreditos.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				tarjetascreditos.setTarjetaCredito(tarjetascreditosDataAccess.getTarjetaCredito(connexion,tarjetascreditos));
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepLoad(tarjetascreditos.getTarjetaCredito(),isDeep,deepLoadType,clases);				
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
			tarjetascreditos.setEmpresa(tarjetascreditosDataAccess.getEmpresa(connexion,tarjetascreditos));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tarjetascreditos.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetascreditos.setSucursal(tarjetascreditosDataAccess.getSucursal(connexion,tarjetascreditos));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(tarjetascreditos.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetascreditos.setTarjetaCredito(tarjetascreditosDataAccess.getTarjetaCredito(connexion,tarjetascreditos));
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacreditoLogic.deepLoad(tarjetascreditos.getTarjetaCredito(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(tarjetascreditos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TarjetasCreditosConstantesFunciones.refrescarForeignKeysDescripcionesTarjetasCreditos(tarjetascreditos);
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
			this.deepLoad(this.tarjetascreditos,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TarjetasCreditosConstantesFunciones.refrescarForeignKeysDescripcionesTarjetasCreditos(this.tarjetascreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(tarjetascreditoss!=null) {
				for(TarjetasCreditos tarjetascreditos:tarjetascreditoss) {
					this.deepLoad(tarjetascreditos,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TarjetasCreditosConstantesFunciones.refrescarForeignKeysDescripcionesTarjetasCreditos(tarjetascreditoss);
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
			if(tarjetascreditoss!=null) {
				for(TarjetasCreditos tarjetascreditos:tarjetascreditoss) {
					this.deepLoad(tarjetascreditos,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TarjetasCreditosConstantesFunciones.refrescarForeignKeysDescripcionesTarjetasCreditos(tarjetascreditoss);
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
	
	public TarjetasCreditosParameterReturnGeneral procesarAccionTarjetasCreditoss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TarjetasCreditos> tarjetascreditoss,TarjetasCreditosParameterReturnGeneral tarjetascreditosParameterGeneral)throws Exception {
		 try {	
			TarjetasCreditosParameterReturnGeneral tarjetascreditosReturnGeneral=new TarjetasCreditosParameterReturnGeneral();
	
			TarjetasCreditosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tarjetascreditoss,tarjetascreditosParameterGeneral,tarjetascreditosReturnGeneral);
			
			return tarjetascreditosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TarjetasCreditosParameterReturnGeneral procesarAccionTarjetasCreditossWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TarjetasCreditos> tarjetascreditoss,TarjetasCreditosParameterReturnGeneral tarjetascreditosParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			TarjetasCreditosParameterReturnGeneral tarjetascreditosReturnGeneral=new TarjetasCreditosParameterReturnGeneral();
	
			TarjetasCreditosLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tarjetascreditoss,tarjetascreditosParameterGeneral,tarjetascreditosReturnGeneral);
			
			this.connexion.commit();
			
			return tarjetascreditosReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

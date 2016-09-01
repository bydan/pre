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
import com.bydan.erp.inventario.util.report.PedidosComprasParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.PedidosComprasParameterGeneral;
import com.bydan.erp.inventario.util.report.PedidosComprasConstantesFunciones;
import com.bydan.erp.inventario.business.entity.report.PedidosCompras;

import com.bydan.erp.inventario.business.logic.report.PedidosComprasLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;






@SuppressWarnings("unused")
public class PedidosComprasLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(PedidosComprasLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected PedidosComprasLogic pedidoscomprasDataAccess; 		
	protected PedidosCompras pedidoscompras;
	protected List<PedidosCompras> pedidoscomprass;
	protected Object pedidoscomprasObject;	
	protected List<Object> pedidoscomprassObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  PedidosComprasLogic()throws SQLException,Exception {
		try	{
			this.pedidoscomprass= new ArrayList<PedidosCompras>();
			this.pedidoscompras= new PedidosCompras();
			this.pedidoscomprasObject=new Object();
			this.pedidoscomprassObject=new ArrayList<Object>();
			
			this.pedidoscomprasDataAccess=this;
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
			this.pedidoscomprasDataAccess.setConnexionType(this.connexionType);
			this.pedidoscomprasDataAccess.setParameterDbType(this.parameterDbType);
			this.pedidoscomprasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PedidosComprasLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.pedidoscomprass= new ArrayList<PedidosCompras>();
			this.pedidoscompras= new PedidosCompras();
			this.pedidoscomprasObject=new Object();
			this.pedidoscomprassObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.pedidoscomprasDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.pedidoscomprasDataAccess.setConnexionType(this.connexionType);
			this.pedidoscomprasDataAccess.setParameterDbType(this.parameterDbType);
			this.pedidoscomprasDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PedidosCompras getPedidosCompras() throws Exception {	
		PedidosComprasLogicAdditional.checkPedidosComprasToGet(pedidoscompras,this.datosCliente,this.arrDatoGeneral);
		PedidosComprasLogicAdditional.updatePedidosComprasToGet(pedidoscompras,this.arrDatoGeneral);
		
		return pedidoscompras;
	}
		
	public void setPedidosCompras(PedidosCompras newPedidosCompras) {
		this.pedidoscompras = newPedidosCompras;
	}
	
	public List<PedidosCompras> getPedidosComprass() throws Exception {		
		this.quitarPedidosComprassNulos();
		
		PedidosComprasLogicAdditional.checkPedidosComprasToGets(pedidoscomprass,this.datosCliente,this.arrDatoGeneral);
		
		for (PedidosCompras pedidoscomprasLocal: pedidoscomprass ) {
			PedidosComprasLogicAdditional.updatePedidosComprasToGet(pedidoscomprasLocal,this.arrDatoGeneral);
		}
		
		return pedidoscomprass;
	}
	
	public void setPedidosComprass(List<PedidosCompras> newPedidosComprass) {
		this.pedidoscomprass = newPedidosComprass;
	}
	
	public Object getPedidosComprasObject() {	
		//this.pedidoscomprasObject=this.pedidoscomprasDataAccess.getEntityObject();
		return this.pedidoscomprasObject;
	}
		
	public void setPedidosComprasObject(Object newPedidosComprasObject) {
		this.pedidoscomprasObject = newPedidosComprasObject;
	}
	
	public List<Object> getPedidosComprassObject() {		
		//this.pedidoscomprassObject=this.pedidoscomprasDataAccess.getEntitiesObject();
		return this.pedidoscomprassObject;
	}
		
	public void setPedidosComprassObject(List<Object> newPedidosComprassObject) {
		this.pedidoscomprassObject = newPedidosComprassObject;
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
		pedidoscomprass = new  ArrayList<PedidosCompras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PedidosComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoscomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		pedidoscomprass = new  ArrayList<PedidosCompras>();
		  		  
        try {
			//PedidosComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoscomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidoscomprass = new  ArrayList<PedidosCompras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PedidosComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoscomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		pedidoscomprass = new  ArrayList<PedidosCompras>();
		  		  
        try {
			//PedidosComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoscomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		pedidoscomprass = new  ArrayList<PedidosCompras>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PedidosComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoscomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		pedidoscomprass = new  ArrayList<PedidosCompras>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//PedidosComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoscomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<PedidosCompras> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidosCompras> entities = new  ArrayList<PedidosCompras>();
		PedidosCompras entity = new PedidosCompras();		  
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
	
	public  List<PedidosCompras> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidosCompras> entities = new  ArrayList<PedidosCompras>();
		PedidosCompras entity = new PedidosCompras();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidosCompras();
				
				
      	    	entity=PedidosComprasLogic.getEntityPedidosCompras("",entity,resultSet);
      	    	
				//entity.setPedidosComprasOriginal( new PedidosCompras());
      	    	//entity.setPedidosComprasOriginal(super.getEntity("",entity.getPedidosComprasOriginal(),resultSet,PedidosComprasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidosComprasOriginal(PedidosComprasDataAccess.getEntityPedidosCompras("",entity.getPedidosComprasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<PedidosCompras> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidosCompras> entities = new  ArrayList<PedidosCompras>();
		PedidosCompras entity = new PedidosCompras();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,PedidosCompras.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PedidosCompras>((List<PedidosCompras>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPedidosComprassOriginal(entities);
			
			}  else {
				this.pedidoscomprassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PedidosComprasConstantesFunciones.quitarEspaciosPedidosComprass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static PedidosCompras getEntityPedidosCompras(String strPrefijo,PedidosCompras entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setsecuencial(resultSet.getString(strPrefijo+PedidosComprasConstantesFunciones.SECUENCIAL));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PedidosComprasConstantesFunciones.FECHAEMISION).getTime()));
			entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+PedidosComprasConstantesFunciones.FECHAENTREGA).getTime()));
			entity.setnombre_producto(resultSet.getString(strPrefijo+PedidosComprasConstantesFunciones.NOMBREPRODUCTO));
			entity.setnombre_unidad(resultSet.getString(strPrefijo+PedidosComprasConstantesFunciones.NOMBREUNIDAD));
			entity.setcantidad_pedido(resultSet.getInt(strPrefijo+PedidosComprasConstantesFunciones.CANTIDADPEDIDO));
			entity.setcantidad_entregada(resultSet.getInt(strPrefijo+PedidosComprasConstantesFunciones.CANTIDADENTREGADA));
			entity.setcantidad_pendiente(resultSet.getInt(strPrefijo+PedidosComprasConstantesFunciones.CANTIDADPENDIENTE));
			entity.setcodigo_producto(resultSet.getString(strPrefijo+PedidosComprasConstantesFunciones.CODIGOPRODUCTO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PedidosCompras getEntityPedidosCompras(String strPrefijo,PedidosCompras entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = PedidosCompras.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = PedidosCompras.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				PedidosComprasLogic.setFieldReflectionPedidosCompras(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPedidosCompras(Field field,String strPrefijo,String sColumn,PedidosCompras entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PedidosComprasConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidosComprasConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidosComprasConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidosComprasConstantesFunciones.NOMBREPRODUCTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidosComprasConstantesFunciones.NOMBREUNIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidosComprasConstantesFunciones.CANTIDADPEDIDO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PedidosComprasConstantesFunciones.CANTIDADENTREGADA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PedidosComprasConstantesFunciones.CANTIDADPENDIENTE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PedidosComprasConstantesFunciones.CODIGOPRODUCTO:
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
	
	public void quitarPedidosComprassNulos() throws Exception {				
		
		List<PedidosCompras> pedidoscomprassAux= new ArrayList<PedidosCompras>();
		
		for(PedidosCompras pedidoscompras:pedidoscomprass) {
			if(pedidoscompras!=null) {
				pedidoscomprassAux.add(pedidoscompras);
			}
		}
		
		pedidoscomprass=pedidoscomprassAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidosCompras> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidosCompras> entities = new  ArrayList<PedidosCompras>();
		PedidosCompras entity = new PedidosCompras();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<PedidosCompras>((List<PedidosCompras>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setPedidosComprassOriginal(entities);
			
			}  else {
				this.pedidoscomprassObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//PedidosComprasConstantesFunciones.quitarEspaciosPedidosComprass(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		pedidoscomprass = new  ArrayList<PedidosCompras>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//PedidosComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoscomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		pedidoscomprass = new  ArrayList<PedidosCompras>();
		  		  
        try {
			//PedidosComprasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoscomprass=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<PedidosCompras> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidosCompras> entities = new  ArrayList<PedidosCompras>();
		PedidosCompras entity = new PedidosCompras();		  
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
	
	public  List<PedidosCompras> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidosCompras> entities = new  ArrayList<PedidosCompras>();
		PedidosCompras entity = new PedidosCompras();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidosCompras();
				
				if(conMapGenerico) {
					entity.setMapPedidosCompras( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapPedidosCompras().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidosComprasDataAccess.ISWITHSCHEMA);         		
					entity=PedidosComprasLogic.getEntityPedidosCompras("",entity,resultSet,listColumns);
					
					////entity.setPedidosComprasOriginal( new PedidosCompras());
					////entity.setPedidosComprasOriginal(super.getEntity("",entity.getPedidosComprasOriginal(),resultSet,PedidosComprasDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidosComprasOriginal(PedidosComprasDataAccess.getEntityPedidosCompras("",entity.getPedidosComprasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,PedidosCompras relpedidoscompras)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relpedidoscompras.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PedidosCompras relpedidoscompras)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relpedidoscompras.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Producto getProducto(Connexion connexion,PedidosCompras relpedidoscompras)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productoDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			producto=productoDataAccess.getEntity(connexion,relpedidoscompras.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Linea getLinea(Connexion connexion,PedidosCompras relpedidoscompras)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relpedidoscompras.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,PedidosCompras relpedidoscompras)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relpedidoscompras.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,PedidosCompras relpedidoscompras)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relpedidoscompras.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,PedidosCompras relpedidoscompras)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			linea=lineaDataAccess.getEntity(connexion,relpedidoscompras.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public TipoProductoServicio getTipoProductoServicio(Connexion connexion,PedidosCompras relpedidoscompras)throws SQLException,Exception {

		TipoProductoServicio tipoproductoservicio= new TipoProductoServicio();

		try {
			TipoProductoServicioDataAccess tipoproductoservicioDataAccess=new TipoProductoServicioDataAccess();

			tipoproductoservicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);
			tipoproductoservicioDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,relpedidoscompras.getid_tipo_producto_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicio;

	}


	
	
	public void getPedidosComprassBusquedaPedidosComprasWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//PedidosComprasLogic pedidoscomprasLogic=new PedidosComprasLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PedidosComprasLogic.GetSelecSqlPedidosCompras(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.pedidoscomprass=this.getPedidosComprass();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getPedidosComprassBusquedaPedidosCompras(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//PedidosComprasLogic pedidoscomprasLogic=new PedidosComprasLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=PedidosComprasLogic.GetSelecSqlPedidosCompras(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.pedidoscomprass=this.getPedidosComprass();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlPedidosCompras(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("PedidosCompras_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" p.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" p.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_producto!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_producto = "+id_producto.toString();
					existeWhere=true;
				}

				if(id_linea!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" pr.id_linea = "+id_linea.toString();
					existeWhere=true;
				}

				if(id_linea_grupo!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" pr.id_linea_grupo = "+id_linea_grupo.toString();
					existeWhere=true;
				}

				if(id_linea_categoria!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" pr.id_linea_categoria = "+id_linea_categoria.toString();
					existeWhere=true;
				}

				if(id_linea_marca!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" pr.id_linea_marca = "+id_linea_marca.toString();
					existeWhere=true;
				}

				if(id_tipo_producto_servicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" pr.id_tipo_producto_servicio = "+id_tipo_producto_servicio.toString();
					existeWhere=true;
				}

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" p.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
					existeWhere=true;
				}

				if(fecha_emision_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_emision_hasta)+"'";
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
	
	
	public void deepLoad(PedidosCompras pedidoscompras,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PedidosComprasLogicAdditional.updatePedidosComprasToGet(pedidoscompras,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidoscompras.setEmpresa(pedidoscomprasDataAccess.getEmpresa(connexion,pedidoscompras));
		pedidoscompras.setSucursal(pedidoscomprasDataAccess.getSucursal(connexion,pedidoscompras));
		pedidoscompras.setProducto(pedidoscomprasDataAccess.getProducto(connexion,pedidoscompras));
		pedidoscompras.setLinea(pedidoscomprasDataAccess.getLinea(connexion,pedidoscompras));
		pedidoscompras.setLineaGrupo(pedidoscomprasDataAccess.getLineaGrupo(connexion,pedidoscompras));
		pedidoscompras.setLineaCategoria(pedidoscomprasDataAccess.getLineaCategoria(connexion,pedidoscompras));
		pedidoscompras.setLineaMarca(pedidoscomprasDataAccess.getLineaMarca(connexion,pedidoscompras));
		pedidoscompras.setTipoProductoServicio(pedidoscomprasDataAccess.getTipoProductoServicio(connexion,pedidoscompras));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidoscompras.setEmpresa(pedidoscomprasDataAccess.getEmpresa(connexion,pedidoscompras));
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidoscompras.setSucursal(pedidoscomprasDataAccess.getSucursal(connexion,pedidoscompras));
			}

			if(clas.clas.equals(Producto.class)) {
				pedidoscompras.setProducto(pedidoscomprasDataAccess.getProducto(connexion,pedidoscompras));
			}

			if(clas.clas.equals(Linea.class)) {
				pedidoscompras.setLinea(pedidoscomprasDataAccess.getLinea(connexion,pedidoscompras));
			}

			if(clas.clas.equals(Linea.class)) {
				pedidoscompras.setLineaGrupo(pedidoscomprasDataAccess.getLineaGrupo(connexion,pedidoscompras));
			}

			if(clas.clas.equals(Linea.class)) {
				pedidoscompras.setLineaCategoria(pedidoscomprasDataAccess.getLineaCategoria(connexion,pedidoscompras));
			}

			if(clas.clas.equals(Linea.class)) {
				pedidoscompras.setLineaMarca(pedidoscomprasDataAccess.getLineaMarca(connexion,pedidoscompras));
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				pedidoscompras.setTipoProductoServicio(pedidoscomprasDataAccess.getTipoProductoServicio(connexion,pedidoscompras));
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
			pedidoscompras.setEmpresa(pedidoscomprasDataAccess.getEmpresa(connexion,pedidoscompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setSucursal(pedidoscomprasDataAccess.getSucursal(connexion,pedidoscompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setProducto(pedidoscomprasDataAccess.getProducto(connexion,pedidoscompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setLinea(pedidoscomprasDataAccess.getLinea(connexion,pedidoscompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setLineaGrupo(pedidoscomprasDataAccess.getLineaGrupo(connexion,pedidoscompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setLineaCategoria(pedidoscomprasDataAccess.getLineaCategoria(connexion,pedidoscompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setLineaMarca(pedidoscomprasDataAccess.getLineaMarca(connexion,pedidoscompras));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setTipoProductoServicio(pedidoscomprasDataAccess.getTipoProductoServicio(connexion,pedidoscompras));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidoscompras.setEmpresa(pedidoscomprasDataAccess.getEmpresa(connexion,pedidoscompras));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidoscompras.getEmpresa(),isDeep,deepLoadType,clases);
				
		pedidoscompras.setSucursal(pedidoscomprasDataAccess.getSucursal(connexion,pedidoscompras));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidoscompras.getSucursal(),isDeep,deepLoadType,clases);
				
		pedidoscompras.setProducto(pedidoscomprasDataAccess.getProducto(connexion,pedidoscompras));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(pedidoscompras.getProducto(),isDeep,deepLoadType,clases);
				
		pedidoscompras.setLinea(pedidoscomprasDataAccess.getLinea(connexion,pedidoscompras));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(pedidoscompras.getLinea(),isDeep,deepLoadType,clases);
				
		pedidoscompras.setLineaGrupo(pedidoscomprasDataAccess.getLineaGrupo(connexion,pedidoscompras));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(pedidoscompras.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		pedidoscompras.setLineaCategoria(pedidoscomprasDataAccess.getLineaCategoria(connexion,pedidoscompras));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(pedidoscompras.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		pedidoscompras.setLineaMarca(pedidoscomprasDataAccess.getLineaMarca(connexion,pedidoscompras));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(pedidoscompras.getLineaMarca(),isDeep,deepLoadType,clases);
				
		pedidoscompras.setTipoProductoServicio(pedidoscomprasDataAccess.getTipoProductoServicio(connexion,pedidoscompras));
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(pedidoscompras.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidoscompras.setEmpresa(pedidoscomprasDataAccess.getEmpresa(connexion,pedidoscompras));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pedidoscompras.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidoscompras.setSucursal(pedidoscomprasDataAccess.getSucursal(connexion,pedidoscompras));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pedidoscompras.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Producto.class)) {
				pedidoscompras.setProducto(pedidoscomprasDataAccess.getProducto(connexion,pedidoscompras));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(pedidoscompras.getProducto(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				pedidoscompras.setLinea(pedidoscomprasDataAccess.getLinea(connexion,pedidoscompras));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(pedidoscompras.getLinea(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				pedidoscompras.setLineaGrupo(pedidoscomprasDataAccess.getLineaGrupo(connexion,pedidoscompras));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(pedidoscompras.getLineaGrupo(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				pedidoscompras.setLineaCategoria(pedidoscomprasDataAccess.getLineaCategoria(connexion,pedidoscompras));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(pedidoscompras.getLineaCategoria(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Linea.class)) {
				pedidoscompras.setLineaMarca(pedidoscomprasDataAccess.getLineaMarca(connexion,pedidoscompras));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(pedidoscompras.getLineaMarca(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				pedidoscompras.setTipoProductoServicio(pedidoscomprasDataAccess.getTipoProductoServicio(connexion,pedidoscompras));
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepLoad(pedidoscompras.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
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
			pedidoscompras.setEmpresa(pedidoscomprasDataAccess.getEmpresa(connexion,pedidoscompras));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pedidoscompras.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setSucursal(pedidoscomprasDataAccess.getSucursal(connexion,pedidoscompras));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pedidoscompras.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setProducto(pedidoscomprasDataAccess.getProducto(connexion,pedidoscompras));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(pedidoscompras.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setLinea(pedidoscomprasDataAccess.getLinea(connexion,pedidoscompras));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(pedidoscompras.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setLineaGrupo(pedidoscomprasDataAccess.getLineaGrupo(connexion,pedidoscompras));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(pedidoscompras.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setLineaCategoria(pedidoscomprasDataAccess.getLineaCategoria(connexion,pedidoscompras));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(pedidoscompras.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setLineaMarca(pedidoscomprasDataAccess.getLineaMarca(connexion,pedidoscompras));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(pedidoscompras.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoscompras.setTipoProductoServicio(pedidoscomprasDataAccess.getTipoProductoServicio(connexion,pedidoscompras));
			TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
			tipoproductoservicioLogic.deepLoad(pedidoscompras.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(pedidoscompras,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidosComprasConstantesFunciones.refrescarForeignKeysDescripcionesPedidosCompras(pedidoscompras);
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
			this.deepLoad(this.pedidoscompras,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidosComprasConstantesFunciones.refrescarForeignKeysDescripcionesPedidosCompras(this.pedidoscompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(pedidoscomprass!=null) {
				for(PedidosCompras pedidoscompras:pedidoscomprass) {
					this.deepLoad(pedidoscompras,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PedidosComprasConstantesFunciones.refrescarForeignKeysDescripcionesPedidosCompras(pedidoscomprass);
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
			if(pedidoscomprass!=null) {
				for(PedidosCompras pedidoscompras:pedidoscomprass) {
					this.deepLoad(pedidoscompras,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PedidosComprasConstantesFunciones.refrescarForeignKeysDescripcionesPedidosCompras(pedidoscomprass);
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
	
	public PedidosComprasParameterReturnGeneral procesarAccionPedidosComprass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidosCompras> pedidoscomprass,PedidosComprasParameterReturnGeneral pedidoscomprasParameterGeneral)throws Exception {
		 try {	
			PedidosComprasParameterReturnGeneral pedidoscomprasReturnGeneral=new PedidosComprasParameterReturnGeneral();
	
			PedidosComprasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidoscomprass,pedidoscomprasParameterGeneral,pedidoscomprasReturnGeneral);
			
			return pedidoscomprasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidosComprasParameterReturnGeneral procesarAccionPedidosComprassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidosCompras> pedidoscomprass,PedidosComprasParameterReturnGeneral pedidoscomprasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			PedidosComprasParameterReturnGeneral pedidoscomprasReturnGeneral=new PedidosComprasParameterReturnGeneral();
	
			PedidosComprasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidoscomprass,pedidoscomprasParameterGeneral,pedidoscomprasReturnGeneral);
			
			this.connexion.commit();
			
			return pedidoscomprasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

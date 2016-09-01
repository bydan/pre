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
import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaParameterGeneral;
import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.ComprobanteFactura;

import com.bydan.erp.puntoventa.business.logic.report.ComprobanteFacturaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;






@SuppressWarnings("unused")
public class ComprobanteFacturaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ComprobanteFacturaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ComprobanteFacturaLogic comprobantefacturaDataAccess; 		
	protected ComprobanteFactura comprobantefactura;
	protected List<ComprobanteFactura> comprobantefacturas;
	protected Object comprobantefacturaObject;	
	protected List<Object> comprobantefacturasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ComprobanteFacturaLogic()throws SQLException,Exception {
		try	{
			this.comprobantefacturas= new ArrayList<ComprobanteFactura>();
			this.comprobantefactura= new ComprobanteFactura();
			this.comprobantefacturaObject=new Object();
			this.comprobantefacturasObject=new ArrayList<Object>();
			
			this.comprobantefacturaDataAccess=this;
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
			this.comprobantefacturaDataAccess.setConnexionType(this.connexionType);
			this.comprobantefacturaDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobantefacturaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComprobanteFacturaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.comprobantefacturas= new ArrayList<ComprobanteFactura>();
			this.comprobantefactura= new ComprobanteFactura();
			this.comprobantefacturaObject=new Object();
			this.comprobantefacturasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.comprobantefacturaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.comprobantefacturaDataAccess.setConnexionType(this.connexionType);
			this.comprobantefacturaDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobantefacturaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComprobanteFactura getComprobanteFactura() throws Exception {	
		ComprobanteFacturaLogicAdditional.checkComprobanteFacturaToGet(comprobantefactura,this.datosCliente,this.arrDatoGeneral);
		ComprobanteFacturaLogicAdditional.updateComprobanteFacturaToGet(comprobantefactura,this.arrDatoGeneral);
		
		return comprobantefactura;
	}
		
	public void setComprobanteFactura(ComprobanteFactura newComprobanteFactura) {
		this.comprobantefactura = newComprobanteFactura;
	}
	
	public List<ComprobanteFactura> getComprobanteFacturas() throws Exception {		
		this.quitarComprobanteFacturasNulos();
		
		ComprobanteFacturaLogicAdditional.checkComprobanteFacturaToGets(comprobantefacturas,this.datosCliente,this.arrDatoGeneral);
		
		for (ComprobanteFactura comprobantefacturaLocal: comprobantefacturas ) {
			ComprobanteFacturaLogicAdditional.updateComprobanteFacturaToGet(comprobantefacturaLocal,this.arrDatoGeneral);
		}
		
		return comprobantefacturas;
	}
	
	public void setComprobanteFacturas(List<ComprobanteFactura> newComprobanteFacturas) {
		this.comprobantefacturas = newComprobanteFacturas;
	}
	
	public Object getComprobanteFacturaObject() {	
		//this.comprobantefacturaObject=this.comprobantefacturaDataAccess.getEntityObject();
		return this.comprobantefacturaObject;
	}
		
	public void setComprobanteFacturaObject(Object newComprobanteFacturaObject) {
		this.comprobantefacturaObject = newComprobanteFacturaObject;
	}
	
	public List<Object> getComprobanteFacturasObject() {		
		//this.comprobantefacturasObject=this.comprobantefacturaDataAccess.getEntitiesObject();
		return this.comprobantefacturasObject;
	}
		
	public void setComprobanteFacturasObject(List<Object> newComprobanteFacturasObject) {
		this.comprobantefacturasObject = newComprobanteFacturasObject;
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
		comprobantefacturas = new  ArrayList<ComprobanteFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		comprobantefacturas = new  ArrayList<ComprobanteFactura>();
		  		  
        try {
			//ComprobanteFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comprobantefacturas = new  ArrayList<ComprobanteFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobantefacturas = new  ArrayList<ComprobanteFactura>();
		  		  
        try {
			//ComprobanteFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		comprobantefacturas = new  ArrayList<ComprobanteFactura>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobantefacturas = new  ArrayList<ComprobanteFactura>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ComprobanteFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ComprobanteFactura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFactura> entities = new  ArrayList<ComprobanteFactura>();
		ComprobanteFactura entity = new ComprobanteFactura();		  
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
	
	public  List<ComprobanteFactura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFactura> entities = new  ArrayList<ComprobanteFactura>();
		ComprobanteFactura entity = new ComprobanteFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobanteFactura();
				
				
      	    	entity=ComprobanteFacturaLogic.getEntityComprobanteFactura("",entity,resultSet);
      	    	
				//entity.setComprobanteFacturaOriginal( new ComprobanteFactura());
      	    	//entity.setComprobanteFacturaOriginal(super.getEntity("",entity.getComprobanteFacturaOriginal(),resultSet,ComprobanteFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComprobanteFacturaOriginal(ComprobanteFacturaDataAccess.getEntityComprobanteFactura("",entity.getComprobanteFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ComprobanteFactura> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFactura> entities = new  ArrayList<ComprobanteFactura>();
		ComprobanteFactura entity = new ComprobanteFactura();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ComprobanteFactura.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobanteFactura>((List<ComprobanteFactura>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobanteFacturasOriginal(entities);
			
			}  else {
				this.comprobantefacturasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobanteFacturaConstantesFunciones.quitarEspaciosComprobanteFacturas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ComprobanteFactura getEntityComprobanteFactura(String strPrefijo,ComprobanteFactura entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_caja(resultSet.getLong(strPrefijo+ComprobanteFacturaConstantesFunciones.IDCAJA));
			entity.setid_cliente(resultSet.getLong(strPrefijo+ComprobanteFacturaConstantesFunciones.IDCLIENTE));
			entity.setnombre_caja(resultSet.getString(strPrefijo+ComprobanteFacturaConstantesFunciones.NOMBRECAJA));
			entity.setsecuencial(resultSet.getString(strPrefijo+ComprobanteFacturaConstantesFunciones.SECUENCIAL));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ComprobanteFacturaConstantesFunciones.FECHA).getTime()));
			entity.setcodigo_cliente(resultSet.getString(strPrefijo+ComprobanteFacturaConstantesFunciones.CODIGOCLIENTE));
			entity.setnombre_cliente(resultSet.getString(strPrefijo+ComprobanteFacturaConstantesFunciones.NOMBRECLIENTE));
			entity.setsubtotal(resultSet.getDouble(strPrefijo+ComprobanteFacturaConstantesFunciones.SUBTOTAL));
			entity.setiva(resultSet.getDouble(strPrefijo+ComprobanteFacturaConstantesFunciones.IVA));
			entity.setdescuento(resultSet.getDouble(strPrefijo+ComprobanteFacturaConstantesFunciones.DESCUENTO));
			entity.setfinanciamiento(resultSet.getDouble(strPrefijo+ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO));
			entity.setflete(resultSet.getDouble(strPrefijo+ComprobanteFacturaConstantesFunciones.FLETE));
			entity.setice(resultSet.getDouble(strPrefijo+ComprobanteFacturaConstantesFunciones.ICE));
			entity.settotal(resultSet.getDouble(strPrefijo+ComprobanteFacturaConstantesFunciones.TOTAL));
			entity.setcantidad_formas_pago(resultSet.getInt(strPrefijo+ComprobanteFacturaConstantesFunciones.CANTIDADFORMASPAGO));
			entity.setdescuento_real(resultSet.getDouble(strPrefijo+ComprobanteFacturaConstantesFunciones.DESCUENTOREAL));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComprobanteFactura getEntityComprobanteFactura(String strPrefijo,ComprobanteFactura entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ComprobanteFactura.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ComprobanteFactura.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ComprobanteFacturaLogic.setFieldReflectionComprobanteFactura(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComprobanteFactura(Field field,String strPrefijo,String sColumn,ComprobanteFactura entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComprobanteFacturaConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.NOMBRECAJA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ComprobanteFacturaConstantesFunciones.CODIGOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.CANTIDADFORMASPAGO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ComprobanteFacturaConstantesFunciones.DESCUENTOREAL:
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
	
	public void quitarComprobanteFacturasNulos() throws Exception {				
		
		List<ComprobanteFactura> comprobantefacturasAux= new ArrayList<ComprobanteFactura>();
		
		for(ComprobanteFactura comprobantefactura:comprobantefacturas) {
			if(comprobantefactura!=null) {
				comprobantefacturasAux.add(comprobantefactura);
			}
		}
		
		comprobantefacturas=comprobantefacturasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ComprobanteFactura> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFactura> entities = new  ArrayList<ComprobanteFactura>();
		ComprobanteFactura entity = new ComprobanteFactura();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobanteFactura>((List<ComprobanteFactura>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobanteFacturasOriginal(entities);
			
			}  else {
				this.comprobantefacturasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobanteFacturaConstantesFunciones.quitarEspaciosComprobanteFacturas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		comprobantefacturas = new  ArrayList<ComprobanteFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		comprobantefacturas = new  ArrayList<ComprobanteFactura>();
		  		  
        try {
			//ComprobanteFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobantefacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ComprobanteFactura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobanteFactura> entities = new  ArrayList<ComprobanteFactura>();
		ComprobanteFactura entity = new ComprobanteFactura();		  
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
	
	public  List<ComprobanteFactura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobanteFactura> entities = new  ArrayList<ComprobanteFactura>();
		ComprobanteFactura entity = new ComprobanteFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobanteFactura();
				
				if(conMapGenerico) {
					entity.setMapComprobanteFactura( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapComprobanteFactura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComprobanteFacturaDataAccess.ISWITHSCHEMA);         		
					entity=ComprobanteFacturaLogic.getEntityComprobanteFactura("",entity,resultSet,listColumns);
					
					////entity.setComprobanteFacturaOriginal( new ComprobanteFactura());
					////entity.setComprobanteFacturaOriginal(super.getEntity("",entity.getComprobanteFacturaOriginal(),resultSet,ComprobanteFacturaDataAccess.ISWITHSCHEMA));         		
					////entity.setComprobanteFacturaOriginal(ComprobanteFacturaDataAccess.getEntityComprobanteFactura("",entity.getComprobanteFacturaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ComprobanteFactura relcomprobantefactura)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcomprobantefactura.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Vendedor getVendedor(Connexion connexion,ComprobanteFactura relcomprobantefactura)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);
			vendedorDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			vendedor=vendedorDataAccess.getEntity(connexion,relcomprobantefactura.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Caja getCaja(Connexion connexion,ComprobanteFactura relcomprobantefactura)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);
			cajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			caja=cajaDataAccess.getEntity(connexion,relcomprobantefactura.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}

	public Cliente getCliente(Connexion connexion,ComprobanteFactura relcomprobantefactura)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relcomprobantefactura.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


	
	
	public void getComprobanteFacturasBusquedaComprobanteFacturaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_vendedor,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//ComprobanteFacturaLogic comprobantefacturaLogic=new ComprobanteFacturaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobanteFacturaLogic.GetSelecSqlComprobanteFactura(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_vendedor,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobantefacturas=this.getComprobanteFacturas();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getComprobanteFacturasBusquedaComprobanteFactura(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_vendedor,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//ComprobanteFacturaLogic comprobantefacturaLogic=new ComprobanteFacturaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobanteFacturaLogic.GetSelecSqlComprobanteFactura(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,id_vendedor,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobantefacturas=this.getComprobanteFacturas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlComprobanteFactura(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_vendedor,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ComprobanteFactura_Postgres.sql");
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
				

				if(id_vendedor!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_vendedor = "+id_vendedor.toString();
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
	
	
	public void deepLoad(ComprobanteFactura comprobantefactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComprobanteFacturaLogicAdditional.updateComprobanteFacturaToGet(comprobantefactura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobantefactura.setEmpresa(comprobantefacturaDataAccess.getEmpresa(connexion,comprobantefactura));
		comprobantefactura.setVendedor(comprobantefacturaDataAccess.getVendedor(connexion,comprobantefactura));
		comprobantefactura.setCaja(comprobantefacturaDataAccess.getCaja(connexion,comprobantefactura));
		comprobantefactura.setCliente(comprobantefacturaDataAccess.getCliente(connexion,comprobantefactura));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobantefactura.setEmpresa(comprobantefacturaDataAccess.getEmpresa(connexion,comprobantefactura));
			}

			if(clas.clas.equals(Vendedor.class)) {
				comprobantefactura.setVendedor(comprobantefacturaDataAccess.getVendedor(connexion,comprobantefactura));
			}

			if(clas.clas.equals(Caja.class)) {
				comprobantefactura.setCaja(comprobantefacturaDataAccess.getCaja(connexion,comprobantefactura));
			}

			if(clas.clas.equals(Cliente.class)) {
				comprobantefactura.setCliente(comprobantefacturaDataAccess.getCliente(connexion,comprobantefactura));
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
			comprobantefactura.setEmpresa(comprobantefacturaDataAccess.getEmpresa(connexion,comprobantefactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefactura.setVendedor(comprobantefacturaDataAccess.getVendedor(connexion,comprobantefactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefactura.setCaja(comprobantefacturaDataAccess.getCaja(connexion,comprobantefactura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefactura.setCliente(comprobantefacturaDataAccess.getCliente(connexion,comprobantefactura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobantefactura.setEmpresa(comprobantefacturaDataAccess.getEmpresa(connexion,comprobantefactura));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comprobantefactura.getEmpresa(),isDeep,deepLoadType,clases);
				
		comprobantefactura.setVendedor(comprobantefacturaDataAccess.getVendedor(connexion,comprobantefactura));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comprobantefactura.getVendedor(),isDeep,deepLoadType,clases);
				
		comprobantefactura.setCaja(comprobantefacturaDataAccess.getCaja(connexion,comprobantefactura));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(comprobantefactura.getCaja(),isDeep,deepLoadType,clases);
				
		comprobantefactura.setCliente(comprobantefacturaDataAccess.getCliente(connexion,comprobantefactura));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(comprobantefactura.getCliente(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobantefactura.setEmpresa(comprobantefacturaDataAccess.getEmpresa(connexion,comprobantefactura));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comprobantefactura.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Vendedor.class)) {
				comprobantefactura.setVendedor(comprobantefacturaDataAccess.getVendedor(connexion,comprobantefactura));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(comprobantefactura.getVendedor(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Caja.class)) {
				comprobantefactura.setCaja(comprobantefacturaDataAccess.getCaja(connexion,comprobantefactura));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(comprobantefactura.getCaja(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				comprobantefactura.setCliente(comprobantefacturaDataAccess.getCliente(connexion,comprobantefactura));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(comprobantefactura.getCliente(),isDeep,deepLoadType,clases);				
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
			comprobantefactura.setEmpresa(comprobantefacturaDataAccess.getEmpresa(connexion,comprobantefactura));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comprobantefactura.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefactura.setVendedor(comprobantefacturaDataAccess.getVendedor(connexion,comprobantefactura));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(comprobantefactura.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefactura.setCaja(comprobantefacturaDataAccess.getCaja(connexion,comprobantefactura));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(comprobantefactura.getCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobantefactura.setCliente(comprobantefacturaDataAccess.getCliente(connexion,comprobantefactura));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(comprobantefactura.getCliente(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(comprobantefactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobanteFacturaConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFactura(comprobantefactura);
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
			this.deepLoad(this.comprobantefactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobanteFacturaConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFactura(this.comprobantefactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(comprobantefacturas!=null) {
				for(ComprobanteFactura comprobantefactura:comprobantefacturas) {
					this.deepLoad(comprobantefactura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComprobanteFacturaConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFactura(comprobantefacturas);
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
			if(comprobantefacturas!=null) {
				for(ComprobanteFactura comprobantefactura:comprobantefacturas) {
					this.deepLoad(comprobantefactura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComprobanteFacturaConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFactura(comprobantefacturas);
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
	
	public ComprobanteFacturaParameterReturnGeneral procesarAccionComprobanteFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobanteFactura> comprobantefacturas,ComprobanteFacturaParameterReturnGeneral comprobantefacturaParameterGeneral)throws Exception {
		 try {	
			ComprobanteFacturaParameterReturnGeneral comprobantefacturaReturnGeneral=new ComprobanteFacturaParameterReturnGeneral();
	
			ComprobanteFacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobantefacturas,comprobantefacturaParameterGeneral,comprobantefacturaReturnGeneral);
			
			return comprobantefacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComprobanteFacturaParameterReturnGeneral procesarAccionComprobanteFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobanteFactura> comprobantefacturas,ComprobanteFacturaParameterReturnGeneral comprobantefacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ComprobanteFacturaParameterReturnGeneral comprobantefacturaReturnGeneral=new ComprobanteFacturaParameterReturnGeneral();
	
			ComprobanteFacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobantefacturas,comprobantefacturaParameterGeneral,comprobantefacturaReturnGeneral);
			
			this.connexion.commit();
			
			return comprobantefacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

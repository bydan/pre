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
package com.bydan.erp.cartera.business.logic.report;

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

import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.resources.general.AuxiliarGeneral;
import com.bydan.erp.cartera.util.report.CobrarEstadosCuentasPorFacturaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarEstadosCuentasPorFacturaParameterGeneral;
import com.bydan.erp.cartera.util.report.CobrarEstadosCuentasPorFacturaConstantesFunciones;
import com.bydan.erp.cartera.business.entity.report.CobrarEstadosCuentasPorFactura;

import com.bydan.erp.cartera.business.logic.report.CobrarEstadosCuentasPorFacturaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;






@SuppressWarnings("unused")
public class CobrarEstadosCuentasPorFacturaLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(CobrarEstadosCuentasPorFacturaLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected CobrarEstadosCuentasPorFacturaLogic cobrarestadoscuentasporfacturaDataAccess; 		
	protected CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura;
	protected List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas;
	protected Object cobrarestadoscuentasporfacturaObject;	
	protected List<Object> cobrarestadoscuentasporfacturasObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  CobrarEstadosCuentasPorFacturaLogic()throws SQLException,Exception {
		try	{
			this.cobrarestadoscuentasporfacturas= new ArrayList<CobrarEstadosCuentasPorFactura>();
			this.cobrarestadoscuentasporfactura= new CobrarEstadosCuentasPorFactura();
			this.cobrarestadoscuentasporfacturaObject=new Object();
			this.cobrarestadoscuentasporfacturasObject=new ArrayList<Object>();
			
			this.cobrarestadoscuentasporfacturaDataAccess=this;
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
			this.cobrarestadoscuentasporfacturaDataAccess.setConnexionType(this.connexionType);
			this.cobrarestadoscuentasporfacturaDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarestadoscuentasporfacturaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobrarEstadosCuentasPorFacturaLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.cobrarestadoscuentasporfacturas= new ArrayList<CobrarEstadosCuentasPorFactura>();
			this.cobrarestadoscuentasporfactura= new CobrarEstadosCuentasPorFactura();
			this.cobrarestadoscuentasporfacturaObject=new Object();
			this.cobrarestadoscuentasporfacturasObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.cobrarestadoscuentasporfacturaDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.cobrarestadoscuentasporfacturaDataAccess.setConnexionType(this.connexionType);
			this.cobrarestadoscuentasporfacturaDataAccess.setParameterDbType(this.parameterDbType);
			this.cobrarestadoscuentasporfacturaDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CobrarEstadosCuentasPorFactura getCobrarEstadosCuentasPorFactura() throws Exception {	
		CobrarEstadosCuentasPorFacturaLogicAdditional.checkCobrarEstadosCuentasPorFacturaToGet(cobrarestadoscuentasporfactura,this.datosCliente,this.arrDatoGeneral);
		CobrarEstadosCuentasPorFacturaLogicAdditional.updateCobrarEstadosCuentasPorFacturaToGet(cobrarestadoscuentasporfactura,this.arrDatoGeneral);
		
		return cobrarestadoscuentasporfactura;
	}
		
	public void setCobrarEstadosCuentasPorFactura(CobrarEstadosCuentasPorFactura newCobrarEstadosCuentasPorFactura) {
		this.cobrarestadoscuentasporfactura = newCobrarEstadosCuentasPorFactura;
	}
	
	public List<CobrarEstadosCuentasPorFactura> getCobrarEstadosCuentasPorFacturas() throws Exception {		
		this.quitarCobrarEstadosCuentasPorFacturasNulos();
		
		CobrarEstadosCuentasPorFacturaLogicAdditional.checkCobrarEstadosCuentasPorFacturaToGets(cobrarestadoscuentasporfacturas,this.datosCliente,this.arrDatoGeneral);
		
		for (CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaLocal: cobrarestadoscuentasporfacturas ) {
			CobrarEstadosCuentasPorFacturaLogicAdditional.updateCobrarEstadosCuentasPorFacturaToGet(cobrarestadoscuentasporfacturaLocal,this.arrDatoGeneral);
		}
		
		return cobrarestadoscuentasporfacturas;
	}
	
	public void setCobrarEstadosCuentasPorFacturas(List<CobrarEstadosCuentasPorFactura> newCobrarEstadosCuentasPorFacturas) {
		this.cobrarestadoscuentasporfacturas = newCobrarEstadosCuentasPorFacturas;
	}
	
	public Object getCobrarEstadosCuentasPorFacturaObject() {	
		//this.cobrarestadoscuentasporfacturaObject=this.cobrarestadoscuentasporfacturaDataAccess.getEntityObject();
		return this.cobrarestadoscuentasporfacturaObject;
	}
		
	public void setCobrarEstadosCuentasPorFacturaObject(Object newCobrarEstadosCuentasPorFacturaObject) {
		this.cobrarestadoscuentasporfacturaObject = newCobrarEstadosCuentasPorFacturaObject;
	}
	
	public List<Object> getCobrarEstadosCuentasPorFacturasObject() {		
		//this.cobrarestadoscuentasporfacturasObject=this.cobrarestadoscuentasporfacturaDataAccess.getEntitiesObject();
		return this.cobrarestadoscuentasporfacturasObject;
	}
		
	public void setCobrarEstadosCuentasPorFacturasObject(List<Object> newCobrarEstadosCuentasPorFacturasObject) {
		this.cobrarestadoscuentasporfacturasObject = newCobrarEstadosCuentasPorFacturasObject;
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
		cobrarestadoscuentasporfacturas = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarEstadosCuentasPorFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarestadoscuentasporfacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		cobrarestadoscuentasporfacturas = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		  		  
        try {
			//CobrarEstadosCuentasPorFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarestadoscuentasporfacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobrarestadoscuentasporfacturas = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarEstadosCuentasPorFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarestadoscuentasporfacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarestadoscuentasporfacturas = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		  		  
        try {
			//CobrarEstadosCuentasPorFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarestadoscuentasporfacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		cobrarestadoscuentasporfacturas = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarEstadosCuentasPorFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarestadoscuentasporfacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		cobrarestadoscuentasporfacturas = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//CobrarEstadosCuentasPorFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarestadoscuentasporfacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<CobrarEstadosCuentasPorFactura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarEstadosCuentasPorFactura> entities = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		CobrarEstadosCuentasPorFactura entity = new CobrarEstadosCuentasPorFactura();		  
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
	
	public  List<CobrarEstadosCuentasPorFactura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarEstadosCuentasPorFactura> entities = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		CobrarEstadosCuentasPorFactura entity = new CobrarEstadosCuentasPorFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarEstadosCuentasPorFactura();
				
				
      	    	entity=CobrarEstadosCuentasPorFacturaLogic.getEntityCobrarEstadosCuentasPorFactura("",entity,resultSet);
      	    	
				//entity.setCobrarEstadosCuentasPorFacturaOriginal( new CobrarEstadosCuentasPorFactura());
      	    	//entity.setCobrarEstadosCuentasPorFacturaOriginal(super.getEntity("",entity.getCobrarEstadosCuentasPorFacturaOriginal(),resultSet,CobrarEstadosCuentasPorFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCobrarEstadosCuentasPorFacturaOriginal(CobrarEstadosCuentasPorFacturaDataAccess.getEntityCobrarEstadosCuentasPorFactura("",entity.getCobrarEstadosCuentasPorFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<CobrarEstadosCuentasPorFactura> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarEstadosCuentasPorFactura> entities = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		CobrarEstadosCuentasPorFactura entity = new CobrarEstadosCuentasPorFactura();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,CobrarEstadosCuentasPorFactura.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarEstadosCuentasPorFactura>((List<CobrarEstadosCuentasPorFactura>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarEstadosCuentasPorFacturasOriginal(entities);
			
			}  else {
				this.cobrarestadoscuentasporfacturasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarEstadosCuentasPorFacturaConstantesFunciones.quitarEspaciosCobrarEstadosCuentasPorFacturas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static CobrarEstadosCuentasPorFactura getEntityCobrarEstadosCuentasPorFactura(String strPrefijo,CobrarEstadosCuentasPorFactura entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setnombre_cuenta_contable(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECUENTACONTABLE));
			entity.setnombre_ciudad(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECIUDAD));
			entity.setnombre_zona(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBREZONA));
			entity.setnombre_completo(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECOMPLETO));
			entity.setruc(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.RUC));
			entity.setrepresentante(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.REPRESENTANTE));
			entity.setdia_pago(resultSet.getInt(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.DIAPAGO));
			entity.sethora_pago(resultSet.getTime(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.HORAPAGO));
			entity.setobservacion(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.OBSERVACION));
			entity.setnombre_transaccion(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRETRANSACCION));
			entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCE).getTime()));
			entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISION).getTime()));
			entity.setnumero_comprobante(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROCOMPROBANTE));
			entity.setnumero_factura(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROFACTURA));
			entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL));
			entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL));
			entity.setdireccion_direccion(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.DIRECCIONDIRECCION));
			entity.settelefono_telefono(resultSet.getString(strPrefijo+CobrarEstadosCuentasPorFacturaConstantesFunciones.TELEFONOTELEFONO));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CobrarEstadosCuentasPorFactura getEntityCobrarEstadosCuentasPorFactura(String strPrefijo,CobrarEstadosCuentasPorFactura entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = CobrarEstadosCuentasPorFactura.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = CobrarEstadosCuentasPorFactura.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				CobrarEstadosCuentasPorFacturaLogic.setFieldReflectionCobrarEstadosCuentasPorFactura(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCobrarEstadosCuentasPorFactura(Field field,String strPrefijo,String sColumn,CobrarEstadosCuentasPorFactura entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECUENTACONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECIUDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBREZONA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.REPRESENTANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.DIAPAGO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.HORAPAGO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.OBSERVACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRETRANSACCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.DIRECCIONDIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CobrarEstadosCuentasPorFacturaConstantesFunciones.TELEFONOTELEFONO:
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
	
	public void quitarCobrarEstadosCuentasPorFacturasNulos() throws Exception {				
		
		List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturasAux= new ArrayList<CobrarEstadosCuentasPorFactura>();
		
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura:cobrarestadoscuentasporfacturas) {
			if(cobrarestadoscuentasporfactura!=null) {
				cobrarestadoscuentasporfacturasAux.add(cobrarestadoscuentasporfactura);
			}
		}
		
		cobrarestadoscuentasporfacturas=cobrarestadoscuentasporfacturasAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<CobrarEstadosCuentasPorFactura> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CobrarEstadosCuentasPorFactura> entities = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		CobrarEstadosCuentasPorFactura entity = new CobrarEstadosCuentasPorFactura();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<CobrarEstadosCuentasPorFactura>((List<CobrarEstadosCuentasPorFactura>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setCobrarEstadosCuentasPorFacturasOriginal(entities);
			
			}  else {
				this.cobrarestadoscuentasporfacturasObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//CobrarEstadosCuentasPorFacturaConstantesFunciones.quitarEspaciosCobrarEstadosCuentasPorFacturas(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		cobrarestadoscuentasporfacturas = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//CobrarEstadosCuentasPorFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarestadoscuentasporfacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		cobrarestadoscuentasporfacturas = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		  		  
        try {
			//CobrarEstadosCuentasPorFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrarestadoscuentasporfacturas=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<CobrarEstadosCuentasPorFactura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarEstadosCuentasPorFactura> entities = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		CobrarEstadosCuentasPorFactura entity = new CobrarEstadosCuentasPorFactura();		  
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
	
	public  List<CobrarEstadosCuentasPorFactura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<CobrarEstadosCuentasPorFactura> entities = new  ArrayList<CobrarEstadosCuentasPorFactura>();
		CobrarEstadosCuentasPorFactura entity = new CobrarEstadosCuentasPorFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CobrarEstadosCuentasPorFactura();
				
				if(conMapGenerico) {
					entity.setMapCobrarEstadosCuentasPorFactura( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapCobrarEstadosCuentasPorFactura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CobrarEstadosCuentasPorFacturaDataAccess.ISWITHSCHEMA);         		
					entity=CobrarEstadosCuentasPorFacturaLogic.getEntityCobrarEstadosCuentasPorFactura("",entity,resultSet,listColumns);
					
					////entity.setCobrarEstadosCuentasPorFacturaOriginal( new CobrarEstadosCuentasPorFactura());
					////entity.setCobrarEstadosCuentasPorFacturaOriginal(super.getEntity("",entity.getCobrarEstadosCuentasPorFacturaOriginal(),resultSet,CobrarEstadosCuentasPorFacturaDataAccess.ISWITHSCHEMA));         		
					////entity.setCobrarEstadosCuentasPorFacturaOriginal(CobrarEstadosCuentasPorFacturaDataAccess.getEntityCobrarEstadosCuentasPorFactura("",entity.getCobrarEstadosCuentasPorFacturaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,CobrarEstadosCuentasPorFactura relcobrarestadoscuentasporfactura)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcobrarestadoscuentasporfactura.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


	
	
	public void getCobrarEstadosCuentasPorFacturasBusquedaCobrarEstadosCuentasPorFacturaWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//CobrarEstadosCuentasPorFacturaLogic cobrarestadoscuentasporfacturaLogic=new CobrarEstadosCuentasPorFacturaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarEstadosCuentasPorFacturaLogic.GetSelecSqlCobrarEstadosCuentasPorFactura(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarestadoscuentasporfacturas=this.getCobrarEstadosCuentasPorFacturas();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarEstadosCuentasPorFacturasBusquedaCobrarEstadosCuentasPorFactura(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		try {
			//CobrarEstadosCuentasPorFacturaLogic cobrarestadoscuentasporfacturaLogic=new CobrarEstadosCuentasPorFacturaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarEstadosCuentasPorFacturaLogic.GetSelecSqlCobrarEstadosCuentasPorFactura(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_emision_desde,fecha_emision_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarestadoscuentasporfacturas=this.getCobrarEstadosCuentasPorFacturas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCobrarEstadosCuentasPorFacturasBusquedaCobrarEstadosCuentasPorFactura2WithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_vence_desde,Date fecha_vence_hasta)throws Exception {
		try {
			//CobrarEstadosCuentasPorFacturaLogic cobrarestadoscuentasporfacturaLogic=new CobrarEstadosCuentasPorFacturaLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarEstadosCuentasPorFacturaLogic.GetSelecSqlCobrarEstadosCuentasPorFactura2(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_vence_desde,fecha_vence_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarestadoscuentasporfacturas=this.getCobrarEstadosCuentasPorFacturas();

			this.connexion.commit();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getCobrarEstadosCuentasPorFacturasBusquedaCobrarEstadosCuentasPorFactura2(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_vence_desde,Date fecha_vence_hasta)throws Exception {
		try {
			//CobrarEstadosCuentasPorFacturaLogic cobrarestadoscuentasporfacturaLogic=new CobrarEstadosCuentasPorFacturaLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=CobrarEstadosCuentasPorFacturaLogic.GetSelecSqlCobrarEstadosCuentasPorFactura2(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_vence_desde,fecha_vence_hasta);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.cobrarestadoscuentasporfacturas=this.getCobrarEstadosCuentasPorFacturas();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarEstadosCuentasPorFactura(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_emision_desde,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarEstadosCuentasPorFactura_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" g.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" g.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
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

	@SuppressWarnings("resource")
	public static String GetSelecSqlCobrarEstadosCuentasPorFactura2(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_vence_desde,Date fecha_vence_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("CobrarEstadosCuentasPorFactura_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" g.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" g.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(fecha_vence_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.fecha_vence between "+"'"+Funciones2.getStringPostgresDate(fecha_vence_desde)+"'";
					existeWhere=true;
				}

				if(fecha_vence_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_vence_hasta)+"'";
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
	
	
	public void deepLoad(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobrarEstadosCuentasPorFacturaLogicAdditional.updateCobrarEstadosCuentasPorFacturaToGet(cobrarestadoscuentasporfactura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarestadoscuentasporfactura.setEmpresa(cobrarestadoscuentasporfacturaDataAccess.getEmpresa(connexion,cobrarestadoscuentasporfactura));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarestadoscuentasporfactura.setEmpresa(cobrarestadoscuentasporfacturaDataAccess.getEmpresa(connexion,cobrarestadoscuentasporfactura));
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
			cobrarestadoscuentasporfactura.setEmpresa(cobrarestadoscuentasporfacturaDataAccess.getEmpresa(connexion,cobrarestadoscuentasporfactura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrarestadoscuentasporfactura.setEmpresa(cobrarestadoscuentasporfacturaDataAccess.getEmpresa(connexion,cobrarestadoscuentasporfactura));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cobrarestadoscuentasporfactura.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cobrarestadoscuentasporfactura.setEmpresa(cobrarestadoscuentasporfacturaDataAccess.getEmpresa(connexion,cobrarestadoscuentasporfactura));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cobrarestadoscuentasporfactura.getEmpresa(),isDeep,deepLoadType,clases);				
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
			cobrarestadoscuentasporfactura.setEmpresa(cobrarestadoscuentasporfacturaDataAccess.getEmpresa(connexion,cobrarestadoscuentasporfactura));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cobrarestadoscuentasporfactura.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(cobrarestadoscuentasporfactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarEstadosCuentasPorFacturaConstantesFunciones.refrescarForeignKeysDescripcionesCobrarEstadosCuentasPorFactura(cobrarestadoscuentasporfactura);
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
			this.deepLoad(this.cobrarestadoscuentasporfactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobrarEstadosCuentasPorFacturaConstantesFunciones.refrescarForeignKeysDescripcionesCobrarEstadosCuentasPorFactura(this.cobrarestadoscuentasporfactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(cobrarestadoscuentasporfacturas!=null) {
				for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura:cobrarestadoscuentasporfacturas) {
					this.deepLoad(cobrarestadoscuentasporfactura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobrarEstadosCuentasPorFacturaConstantesFunciones.refrescarForeignKeysDescripcionesCobrarEstadosCuentasPorFactura(cobrarestadoscuentasporfacturas);
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
			if(cobrarestadoscuentasporfacturas!=null) {
				for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura:cobrarestadoscuentasporfacturas) {
					this.deepLoad(cobrarestadoscuentasporfactura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobrarEstadosCuentasPorFacturaConstantesFunciones.refrescarForeignKeysDescripcionesCobrarEstadosCuentasPorFactura(cobrarestadoscuentasporfacturas);
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
	
	public CobrarEstadosCuentasPorFacturaParameterReturnGeneral procesarAccionCobrarEstadosCuentasPorFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,CobrarEstadosCuentasPorFacturaParameterReturnGeneral cobrarestadoscuentasporfacturaParameterGeneral)throws Exception {
		 try {	
			CobrarEstadosCuentasPorFacturaParameterReturnGeneral cobrarestadoscuentasporfacturaReturnGeneral=new CobrarEstadosCuentasPorFacturaParameterReturnGeneral();
	
			CobrarEstadosCuentasPorFacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarestadoscuentasporfacturas,cobrarestadoscuentasporfacturaParameterGeneral,cobrarestadoscuentasporfacturaReturnGeneral);
			
			return cobrarestadoscuentasporfacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobrarEstadosCuentasPorFacturaParameterReturnGeneral procesarAccionCobrarEstadosCuentasPorFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,CobrarEstadosCuentasPorFacturaParameterReturnGeneral cobrarestadoscuentasporfacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			CobrarEstadosCuentasPorFacturaParameterReturnGeneral cobrarestadoscuentasporfacturaReturnGeneral=new CobrarEstadosCuentasPorFacturaParameterReturnGeneral();
	
			CobrarEstadosCuentasPorFacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobrarestadoscuentasporfacturas,cobrarestadoscuentasporfacturaParameterGeneral,cobrarestadoscuentasporfacturaReturnGeneral);
			
			this.connexion.commit();
			
			return cobrarestadoscuentasporfacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

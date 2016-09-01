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
import com.bydan.erp.puntoventa.util.report.ComprobanteFormaPagoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ComprobanteFormaPagoParameterGeneral;
import com.bydan.erp.puntoventa.util.report.ComprobanteFormaPagoConstantesFunciones;
import com.bydan.erp.puntoventa.business.entity.report.ComprobanteFormaPago;

import com.bydan.erp.puntoventa.business.logic.report.ComprobanteFormaPagoLogicAdditional;
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
public class ComprobanteFormaPagoLogic extends GeneralEntityLogic {	
	static Logger logger = Logger.getLogger(ComprobanteFormaPagoLogic.class);
	
	public static boolean ISWITHSCHEMA=true;
	
	protected ComprobanteFormaPagoLogic comprobanteformapagoDataAccess; 		
	protected ComprobanteFormaPago comprobanteformapago;
	protected List<ComprobanteFormaPago> comprobanteformapagos;
	protected Object comprobanteformapagoObject;	
	protected List<Object> comprobanteformapagosObject;
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
		
	//DATAACCESS
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	public  ComprobanteFormaPagoLogic()throws SQLException,Exception {
		try	{
			this.comprobanteformapagos= new ArrayList<ComprobanteFormaPago>();
			this.comprobanteformapago= new ComprobanteFormaPago();
			this.comprobanteformapagoObject=new Object();
			this.comprobanteformapagosObject=new ArrayList<Object>();
			
			this.comprobanteformapagoDataAccess=this;
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
			this.comprobanteformapagoDataAccess.setConnexionType(this.connexionType);
			this.comprobanteformapagoDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobanteformapagoDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComprobanteFormaPagoLogic(Connexion newConnexion)throws Exception {
		try	{
			this.connexion=newConnexion;
			
			this.comprobanteformapagos= new ArrayList<ComprobanteFormaPago>();
			this.comprobanteformapago= new ComprobanteFormaPago();
			this.comprobanteformapagoObject=new Object();
			this.comprobanteformapagosObject=new ArrayList<Object>();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			this.comprobanteformapagoDataAccess=this;
			this.isForForeingsKeysDataRelationships=false;
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			/*
			this.comprobanteformapagoDataAccess.setConnexionType(this.connexionType);
			this.comprobanteformapagoDataAccess.setParameterDbType(this.parameterDbType);
			this.comprobanteformapagoDataAccess.setEntityManagerFactory(this.entityManagerFactory);
			*/
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComprobanteFormaPago getComprobanteFormaPago() throws Exception {	
		ComprobanteFormaPagoLogicAdditional.checkComprobanteFormaPagoToGet(comprobanteformapago,this.datosCliente,this.arrDatoGeneral);
		ComprobanteFormaPagoLogicAdditional.updateComprobanteFormaPagoToGet(comprobanteformapago,this.arrDatoGeneral);
		
		return comprobanteformapago;
	}
		
	public void setComprobanteFormaPago(ComprobanteFormaPago newComprobanteFormaPago) {
		this.comprobanteformapago = newComprobanteFormaPago;
	}
	
	public List<ComprobanteFormaPago> getComprobanteFormaPagos() throws Exception {		
		this.quitarComprobanteFormaPagosNulos();
		
		ComprobanteFormaPagoLogicAdditional.checkComprobanteFormaPagoToGets(comprobanteformapagos,this.datosCliente,this.arrDatoGeneral);
		
		for (ComprobanteFormaPago comprobanteformapagoLocal: comprobanteformapagos ) {
			ComprobanteFormaPagoLogicAdditional.updateComprobanteFormaPagoToGet(comprobanteformapagoLocal,this.arrDatoGeneral);
		}
		
		return comprobanteformapagos;
	}
	
	public void setComprobanteFormaPagos(List<ComprobanteFormaPago> newComprobanteFormaPagos) {
		this.comprobanteformapagos = newComprobanteFormaPagos;
	}
	
	public Object getComprobanteFormaPagoObject() {	
		//this.comprobanteformapagoObject=this.comprobanteformapagoDataAccess.getEntityObject();
		return this.comprobanteformapagoObject;
	}
		
	public void setComprobanteFormaPagoObject(Object newComprobanteFormaPagoObject) {
		this.comprobanteformapagoObject = newComprobanteFormaPagoObject;
	}
	
	public List<Object> getComprobanteFormaPagosObject() {		
		//this.comprobanteformapagosObject=this.comprobanteformapagoDataAccess.getEntitiesObject();
		return this.comprobanteformapagosObject;
	}
		
	public void setComprobanteFormaPagosObject(List<Object> newComprobanteFormaPagosObject) {
		this.comprobanteformapagosObject = newComprobanteFormaPagosObject;
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
		comprobanteformapagos = new  ArrayList<ComprobanteFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobanteformapagos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);
			
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
		comprobanteformapagos = new  ArrayList<ComprobanteFormaPago>();
		  		  
        try {
			//ComprobanteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobanteformapagos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	*/
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comprobanteformapagos = new  ArrayList<ComprobanteFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobanteformapagos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobanteformapagos = new  ArrayList<ComprobanteFormaPago>();
		  		  
        try {
			//ComprobanteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobanteformapagos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery)throws Exception {	
		comprobanteformapagos = new  ArrayList<ComprobanteFormaPago>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();		
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobanteformapagos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
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
		comprobanteformapagos = new  ArrayList<ComprobanteFormaPago>();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setFinalQuery(sFinalQuery);
		
        try {
			//ComprobanteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESNATIVEWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobanteformapagos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
				
		} catch(Exception e) {
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;				
		}
	}	
	
	public  List<ComprobanteFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFormaPago> entities = new  ArrayList<ComprobanteFormaPago>();
		ComprobanteFormaPago entity = new ComprobanteFormaPago();		  
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
	
	public  List<ComprobanteFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFormaPago> entities = new  ArrayList<ComprobanteFormaPago>();
		ComprobanteFormaPago entity = new ComprobanteFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobanteFormaPago();
				
				
      	    	entity=ComprobanteFormaPagoLogic.getEntityComprobanteFormaPago("",entity,resultSet);
      	    	
				//entity.setComprobanteFormaPagoOriginal( new ComprobanteFormaPago());
      	    	//entity.setComprobanteFormaPagoOriginal(super.getEntity("",entity.getComprobanteFormaPagoOriginal(),resultSet,ComprobanteFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComprobanteFormaPagoOriginal(ComprobanteFormaPagoDataAccess.getEntityComprobanteFormaPago("",entity.getComprobanteFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	@SuppressWarnings("unchecked")
	public  List<ComprobanteFormaPago> getEntitiesHibernateNative(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFormaPago> entities = new  ArrayList<ComprobanteFormaPago>();
		ComprobanteFormaPago entity = new ComprobanteFormaPago();		  
		String sQuery="";
	
        try {     	   
        		
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
			
			Query query =null;
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
      	    	query =connexion.getEntityManager().createNativeQuery (sQuery,ComprobanteFormaPago.class);
			}  else {
				query =connexion.getEntityManager().createNativeQuery (sQuery);
			}
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobanteFormaPago>((List<ComprobanteFormaPago>) query.getResultList());
				
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobanteFormaPagosOriginal(entities);
			
			}  else {
				this.comprobanteformapagosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobanteFormaPagoConstantesFunciones.quitarEspaciosComprobanteFormaPagos(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	public  static ComprobanteFormaPago getEntityComprobanteFormaPago(String strPrefijo,ComprobanteFormaPago entity,ResultSet resultSet) throws Exception
    {		
        try {     	  
			entity.setid_cliente(resultSet.getLong(strPrefijo+ComprobanteFormaPagoConstantesFunciones.IDCLIENTE));
			entity.setid_caja(resultSet.getLong(strPrefijo+ComprobanteFormaPagoConstantesFunciones.IDCAJA));
			entity.setnombre_caja(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.NOMBRECAJA));
			entity.setsecuencial(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.SECUENCIAL));
			entity.setfecha(new Date(resultSet.getDate(strPrefijo+ComprobanteFormaPagoConstantesFunciones.FECHA).getTime()));
			entity.setcodigo_cliente(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.CODIGOCLIENTE));
			entity.setnombre_cliente(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.NOMBRECLIENTE));
			entity.setsubtotal(resultSet.getDouble(strPrefijo+ComprobanteFormaPagoConstantesFunciones.SUBTOTAL));
			entity.setiva(resultSet.getDouble(strPrefijo+ComprobanteFormaPagoConstantesFunciones.IVA));
			entity.setdescuento(resultSet.getDouble(strPrefijo+ComprobanteFormaPagoConstantesFunciones.DESCUENTO));
			entity.setfinanciamiento(resultSet.getDouble(strPrefijo+ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO));
			entity.setflete(resultSet.getDouble(strPrefijo+ComprobanteFormaPagoConstantesFunciones.FLETE));
			entity.setice(resultSet.getDouble(strPrefijo+ComprobanteFormaPagoConstantesFunciones.ICE));
			entity.settotal(resultSet.getDouble(strPrefijo+ComprobanteFormaPagoConstantesFunciones.TOTAL));
			entity.settipo(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.TIPO));
			entity.setvalor(resultSet.getDouble(strPrefijo+ComprobanteFormaPagoConstantesFunciones.VALOR));
			entity.setfecha_forma_pago(new Date(resultSet.getDate(strPrefijo+ComprobanteFormaPagoConstantesFunciones.FECHAFORMAPAGO).getTime()));
			entity.setnumero_cuenta(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.NUMEROCUENTA));
			entity.setnumero_cheque(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.NUMEROCHEQUE));
			entity.setgirador(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.GIRADOR));
			entity.setnumero_dias_plazo(resultSet.getInt(strPrefijo+ComprobanteFormaPagoConstantesFunciones.NUMERODIASPLAZO));
			entity.setnumero_tarjeta(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.NUMEROTARJETA));
			entity.setautorizacion(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.AUTORIZACION));
			entity.setlote(resultSet.getString(strPrefijo+ComprobanteFormaPagoConstantesFunciones.LOTE));
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComprobanteFormaPago getEntityComprobanteFormaPago(String strPrefijo,ComprobanteFormaPago entity,ResultSet resultSet,List<String> listColumns) throws Exception {		
        try {     	  
        	for(String sColumn:listColumns) {	        	
				Field field =null;
        		try {
	        		field = ComprobanteFormaPago.class.getDeclaredField(sColumn);//getField
	        		field.setAccessible(true);
					
        		} catch(Exception e) {
        			field = ComprobanteFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
    	        	field.setAccessible(true);
        		}
				
				ComprobanteFormaPagoLogic.setFieldReflectionComprobanteFormaPago(field,strPrefijo,sColumn,entity,resultSet);
	            //field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
        	}            
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComprobanteFormaPago(Field field,String strPrefijo,String sColumn,ComprobanteFormaPago entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComprobanteFormaPagoConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.NOMBRECAJA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.CODIGOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.TIPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.FECHAFORMAPAGO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.GIRADOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.NUMERODIASPLAZO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.NUMEROTARJETA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.AUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComprobanteFormaPagoConstantesFunciones.LOTE:
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
	
	public void quitarComprobanteFormaPagosNulos() throws Exception {				
		
		List<ComprobanteFormaPago> comprobanteformapagosAux= new ArrayList<ComprobanteFormaPago>();
		
		for(ComprobanteFormaPago comprobanteformapago:comprobanteformapagos) {
			if(comprobanteformapago!=null) {
				comprobanteformapagosAux.add(comprobanteformapago);
			}
		}
		
		comprobanteformapagos=comprobanteformapagosAux;
	}
	
	@SuppressWarnings("unchecked")
	public List<ComprobanteFormaPago> getEntitiesHibernate(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComprobanteFormaPago> entities = new  ArrayList<ComprobanteFormaPago>();
		ComprobanteFormaPago entity = new ComprobanteFormaPago();		  
		String sQuery="";
	
        try {     	   
        					
			sQuery=DataAccessHelper.buildSqlGeneralGetEntities(entity,queryWhereSelectParameters,sQuerySelect);
						 
      	    Query query =connexion.getEntityManager().createQuery (sQuery);
			
			DataAccessHelper.buildSqlGeneralSetQueryParameters(query,queryWhereSelectParameters);
			
			DataAccessHelper.buildSqlGeneralSetQueryPagination(query,queryWhereSelectParameters);
			
			if(!queryWhereSelectParameters.getIsGetGeneralObjects()) {
				entities= new ArrayList<ComprobanteFormaPago>((List<ComprobanteFormaPago>) query.getResultList());
							
				//super.SetGeneralEntitiesIsNewFalseIsChangedFalse(entities);
				
				//this.setComprobanteFormaPagosOriginal(entities);
			
			}  else {
				this.comprobanteformapagosObject=query.getResultList();	
			}
			
			//MEJOR QUITAR SE USA EN GET Y AL COMPARAR EN SET SINO EJB HACE UPDATE AUTOMATICAMENTE
			//ComprobanteFormaPagoConstantesFunciones.quitarEspaciosComprobanteFormaPagos(entities);
				
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico)throws Exception {	
		comprobanteformapagos = new  ArrayList<ComprobanteFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			//ComprobanteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobanteformapagos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
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
		comprobanteformapagos = new  ArrayList<ComprobanteFormaPago>();
		  		  
        try {
			//ComprobanteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comprobanteformapagos=this.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,conMapGenerico);    	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  List<ComprobanteFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobanteFormaPago> entities = new  ArrayList<ComprobanteFormaPago>();
		ComprobanteFormaPago entity = new ComprobanteFormaPago();		  
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
	
	public  List<ComprobanteFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComprobanteFormaPago> entities = new  ArrayList<ComprobanteFormaPago>();
		ComprobanteFormaPago entity = new ComprobanteFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComprobanteFormaPago();
				
				if(conMapGenerico) {
					entity.setMapComprobanteFormaPago( new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.getMapComprobanteFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComprobanteFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=ComprobanteFormaPagoLogic.getEntityComprobanteFormaPago("",entity,resultSet,listColumns);
					
					////entity.setComprobanteFormaPagoOriginal( new ComprobanteFormaPago());
					////entity.setComprobanteFormaPagoOriginal(super.getEntity("",entity.getComprobanteFormaPagoOriginal(),resultSet,ComprobanteFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setComprobanteFormaPagoOriginal(ComprobanteFormaPagoDataAccess.getEntityComprobanteFormaPago("",entity.getComprobanteFormaPagoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

      	    statement.close();  
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
		public Empresa getEmpresa(Connexion connexion,ComprobanteFormaPago relcomprobanteformapago)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);
			empresaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			empresa=empresaDataAccess.getEntity(connexion,relcomprobanteformapago.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ComprobanteFormaPago relcomprobanteformapago)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursalDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			sucursal=sucursalDataAccess.getEntity(connexion,relcomprobanteformapago.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,ComprobanteFormaPago relcomprobanteformapago)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clienteDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			cliente=clienteDataAccess.getEntity(connexion,relcomprobanteformapago.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Caja getCaja(Connexion connexion,ComprobanteFormaPago relcomprobanteformapago)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);
			cajaDataAccess.setEntityManagerFactory(this.entityManagerFactory);

			caja=cajaDataAccess.getEntity(connexion,relcomprobanteformapago.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}


	
	
	public void getComprobanteFormaPagosBusquedaComprobanteFormaPagoWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//ComprobanteFormaPagoLogic comprobanteformapagoLogic=new ComprobanteFormaPagoLogic();

			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobanteFormaPagoLogic.GetSelecSqlComprobanteFormaPago(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobanteformapagos=this.getComprobanteFormaPagos();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
	}

	public void getComprobanteFormaPagosBusquedaComprobanteFormaPago(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		try {
			//ComprobanteFormaPagoLogic comprobanteformapagoLogic=new ComprobanteFormaPagoLogic();

			//this.setConnexion(this.connexion);this.setConnexionType(this.connexionType);this.setParameterDbType(this.parameterDbType);this.setEntityManagerFactory(this.entityManagerFactory);

			String sQuerySelect="";
			String sFinalQueryFinal="";
			sQuerySelect=ComprobanteFormaPagoLogic.GetSelecSqlComprobanteFormaPago(this.connexion,this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,fecha_inicio,fecha_fin);

			this.getEntities(sQuerySelect, sFinalQueryFinal);

			this.comprobanteformapagos=this.getComprobanteFormaPagos();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	

	@SuppressWarnings("resource")
	public static String GetSelecSqlComprobanteFormaPago(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ComprobanteFormaPago_Postgres.sql");
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
	
	
	public void deepLoad(ComprobanteFormaPago comprobanteformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComprobanteFormaPagoLogicAdditional.updateComprobanteFormaPagoToGet(comprobanteformapago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobanteformapago.setEmpresa(comprobanteformapagoDataAccess.getEmpresa(connexion,comprobanteformapago));
		comprobanteformapago.setSucursal(comprobanteformapagoDataAccess.getSucursal(connexion,comprobanteformapago));
		comprobanteformapago.setCliente(comprobanteformapagoDataAccess.getCliente(connexion,comprobanteformapago));
		comprobanteformapago.setCaja(comprobanteformapagoDataAccess.getCaja(connexion,comprobanteformapago));
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobanteformapago.setEmpresa(comprobanteformapagoDataAccess.getEmpresa(connexion,comprobanteformapago));
			}

			if(clas.clas.equals(Sucursal.class)) {
				comprobanteformapago.setSucursal(comprobanteformapagoDataAccess.getSucursal(connexion,comprobanteformapago));
			}

			if(clas.clas.equals(Cliente.class)) {
				comprobanteformapago.setCliente(comprobanteformapagoDataAccess.getCliente(connexion,comprobanteformapago));
			}

			if(clas.clas.equals(Caja.class)) {
				comprobanteformapago.setCaja(comprobanteformapagoDataAccess.getCaja(connexion,comprobanteformapago));
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
			comprobanteformapago.setEmpresa(comprobanteformapagoDataAccess.getEmpresa(connexion,comprobanteformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobanteformapago.setSucursal(comprobanteformapagoDataAccess.getSucursal(connexion,comprobanteformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobanteformapago.setCliente(comprobanteformapagoDataAccess.getCliente(connexion,comprobanteformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobanteformapago.setCaja(comprobanteformapagoDataAccess.getCaja(connexion,comprobanteformapago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comprobanteformapago.setEmpresa(comprobanteformapagoDataAccess.getEmpresa(connexion,comprobanteformapago));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comprobanteformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		comprobanteformapago.setSucursal(comprobanteformapagoDataAccess.getSucursal(connexion,comprobanteformapago));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(comprobanteformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		comprobanteformapago.setCliente(comprobanteformapagoDataAccess.getCliente(connexion,comprobanteformapago));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(comprobanteformapago.getCliente(),isDeep,deepLoadType,clases);
				
		comprobanteformapago.setCaja(comprobanteformapagoDataAccess.getCaja(connexion,comprobanteformapago));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(comprobanteformapago.getCaja(),isDeep,deepLoadType,clases);
				
	}
	else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comprobanteformapago.setEmpresa(comprobanteformapagoDataAccess.getEmpresa(connexion,comprobanteformapago));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comprobanteformapago.getEmpresa(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Sucursal.class)) {
				comprobanteformapago.setSucursal(comprobanteformapagoDataAccess.getSucursal(connexion,comprobanteformapago));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(comprobanteformapago.getSucursal(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Cliente.class)) {
				comprobanteformapago.setCliente(comprobanteformapagoDataAccess.getCliente(connexion,comprobanteformapago));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(comprobanteformapago.getCliente(),isDeep,deepLoadType,clases);				
			}

			if(clas.clas.equals(Caja.class)) {
				comprobanteformapago.setCaja(comprobanteformapagoDataAccess.getCaja(connexion,comprobanteformapago));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(comprobanteformapago.getCaja(),isDeep,deepLoadType,clases);				
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
			comprobanteformapago.setEmpresa(comprobanteformapagoDataAccess.getEmpresa(connexion,comprobanteformapago));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comprobanteformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobanteformapago.setSucursal(comprobanteformapagoDataAccess.getSucursal(connexion,comprobanteformapago));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(comprobanteformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobanteformapago.setCliente(comprobanteformapagoDataAccess.getCliente(connexion,comprobanteformapago));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(comprobanteformapago.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comprobanteformapago.setCaja(comprobanteformapagoDataAccess.getCaja(connexion,comprobanteformapago));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(comprobanteformapago.getCaja(),isDeep,deepLoadType,clases);
				
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
			
			this.deepLoad(comprobanteformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobanteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFormaPago(comprobanteformapago);
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
			this.deepLoad(this.comprobanteformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComprobanteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFormaPago(this.comprobanteformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep();
			
			if(comprobanteformapagos!=null) {
				for(ComprobanteFormaPago comprobanteformapago:comprobanteformapagos) {
					this.deepLoad(comprobanteformapago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComprobanteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFormaPago(comprobanteformapagos);
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
			if(comprobanteformapagos!=null) {
				for(ComprobanteFormaPago comprobanteformapago:comprobanteformapagos) {
					this.deepLoad(comprobanteformapago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComprobanteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesComprobanteFormaPago(comprobanteformapagos);
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
	
	public ComprobanteFormaPagoParameterReturnGeneral procesarAccionComprobanteFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobanteFormaPago> comprobanteformapagos,ComprobanteFormaPagoParameterReturnGeneral comprobanteformapagoParameterGeneral)throws Exception {
		 try {	
			ComprobanteFormaPagoParameterReturnGeneral comprobanteformapagoReturnGeneral=new ComprobanteFormaPagoParameterReturnGeneral();
	
			ComprobanteFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobanteformapagos,comprobanteformapagoParameterGeneral,comprobanteformapagoReturnGeneral);
			
			return comprobanteformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComprobanteFormaPagoParameterReturnGeneral procesarAccionComprobanteFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComprobanteFormaPago> comprobanteformapagos,ComprobanteFormaPagoParameterReturnGeneral comprobanteformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ComprobanteFormaPagoParameterReturnGeneral comprobanteformapagoReturnGeneral=new ComprobanteFormaPagoParameterReturnGeneral();
	
			ComprobanteFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comprobanteformapagos,comprobanteformapagoParameterGeneral,comprobanteformapagoReturnGeneral);
			
			this.connexion.commit();
			
			return comprobanteformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	
}

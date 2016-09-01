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
package com.bydan.erp.inventario.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.ProductoReemplaConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoReemplaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoReemplaParameterGeneral;
import com.bydan.erp.inventario.business.entity.ProductoReempla;
import com.bydan.erp.inventario.business.logic.ProductoReemplaLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoReemplaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoReemplaLogic.class);
	
	protected ProductoReemplaDataAccess productoreemplaDataAccess; 	
	protected ProductoReempla productoreempla;
	protected List<ProductoReempla> productoreemplas;
	protected Object productoreemplaObject;	
	protected List<Object> productoreemplasObject;
	
	public static ClassValidator<ProductoReempla> productoreemplaValidator = new ClassValidator<ProductoReempla>(ProductoReempla.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoReemplaLogicAdditional productoreemplaLogicAdditional=null;
	
	public ProductoReemplaLogicAdditional getProductoReemplaLogicAdditional() {
		return this.productoreemplaLogicAdditional;
	}
	
	public void setProductoReemplaLogicAdditional(ProductoReemplaLogicAdditional productoreemplaLogicAdditional) {
		try {
			this.productoreemplaLogicAdditional=productoreemplaLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  ProductoReemplaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoreemplaDataAccess = new ProductoReemplaDataAccess();
			
			this.productoreemplas= new ArrayList<ProductoReempla>();
			this.productoreempla= new ProductoReempla();
			
			this.productoreemplaObject=new Object();
			this.productoreemplasObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.productoreemplaDataAccess.setConnexionType(this.connexionType);
			this.productoreemplaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoReemplaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoreemplaDataAccess = new ProductoReemplaDataAccess();
			this.productoreemplas= new ArrayList<ProductoReempla>();
			this.productoreempla= new ProductoReempla();
			this.productoreemplaObject=new Object();
			this.productoreemplasObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.productoreemplaDataAccess.setConnexionType(this.connexionType);
			this.productoreemplaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoReempla getProductoReempla() throws Exception {	
		ProductoReemplaLogicAdditional.checkProductoReemplaToGet(productoreempla,this.datosCliente,this.arrDatoGeneral);
		ProductoReemplaLogicAdditional.updateProductoReemplaToGet(productoreempla,this.arrDatoGeneral);
		
		return productoreempla;
	}
		
	public void setProductoReempla(ProductoReempla newProductoReempla) {
		this.productoreempla = newProductoReempla;
	}
	
	public ProductoReemplaDataAccess getProductoReemplaDataAccess() {
		return productoreemplaDataAccess;
	}
	
	public void setProductoReemplaDataAccess(ProductoReemplaDataAccess newproductoreemplaDataAccess) {
		this.productoreemplaDataAccess = newproductoreemplaDataAccess;
	}
	
	public List<ProductoReempla> getProductoReemplas() throws Exception {		
		this.quitarProductoReemplasNulos();
		
		ProductoReemplaLogicAdditional.checkProductoReemplaToGets(productoreemplas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoReempla productoreemplaLocal: productoreemplas ) {
			ProductoReemplaLogicAdditional.updateProductoReemplaToGet(productoreemplaLocal,this.arrDatoGeneral);
		}
		
		return productoreemplas;
	}
	
	public void setProductoReemplas(List<ProductoReempla> newProductoReemplas) {
		this.productoreemplas = newProductoReemplas;
	}
	
	public Object getProductoReemplaObject() {	
		this.productoreemplaObject=this.productoreemplaDataAccess.getEntityObject();
		return this.productoreemplaObject;
	}
		
	public void setProductoReemplaObject(Object newProductoReemplaObject) {
		this.productoreemplaObject = newProductoReemplaObject;
	}
	
	public List<Object> getProductoReemplasObject() {		
		this.productoreemplasObject=this.productoreemplaDataAccess.getEntitiesObject();
		return this.productoreemplasObject;
	}
		
	public void setProductoReemplasObject(List<Object> newProductoReemplasObject) {
		this.productoreemplasObject = newProductoReemplasObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.productoreemplaDataAccess!=null) {
			this.productoreemplaDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
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
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
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
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoreemplaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoreemplaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoreempla = new  ProductoReempla();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoreempla=productoreemplaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoreempla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreempla);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		productoreempla = new  ProductoReempla();
		  		  
        try {
			
			productoreempla=productoreemplaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoreempla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreempla);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoreempla = new  ProductoReempla();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoreempla=productoreemplaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoreempla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreempla);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		productoreempla = new  ProductoReempla();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoreempla = new  ProductoReempla();
		  		  
        try {
			
			productoreempla=productoreemplaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoreempla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreempla);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoreempla = new  ProductoReempla();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoreempla = new  ProductoReempla();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoreemplaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoreempla = new  ProductoReempla();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoreemplaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoreempla = new  ProductoReempla();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoreemplaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoreempla = new  ProductoReempla();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoreemplaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoreempla = new  ProductoReempla();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoreemplaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoreempla = new  ProductoReempla();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoreemplaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoreemplas = new  ArrayList<ProductoReempla>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		productoreemplas = new  ArrayList<ProductoReempla>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoreemplas = new  ArrayList<ProductoReempla>();
		  		  
        try {			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoreemplas = new  ArrayList<ProductoReempla>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoreemplas = new  ArrayList<ProductoReempla>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
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
		productoreemplas = new  ArrayList<ProductoReempla>();
		  		  
        try {
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoreemplas = new  ArrayList<ProductoReempla>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoreemplas = new  ArrayList<ProductoReempla>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoreempla = new  ProductoReempla();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreempla=productoreemplaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoReempla(productoreempla);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreempla);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoreempla = new  ProductoReempla();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreempla=productoreemplaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoReempla(productoreempla);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreempla);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoreemplas = new  ArrayList<ProductoReempla>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoreemplas = new  ArrayList<ProductoReempla>();
		  		  
        try {
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoReemplasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoreemplas = new  ArrayList<ProductoReempla>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getTodosProductoReemplasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosProductoReemplas(String sFinalQuery,Pagination pagination)throws Exception {
		productoreemplas = new  ArrayList<ProductoReempla>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoReempla(productoreemplas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoReempla(ProductoReempla productoreempla) throws Exception {
		Boolean estaValidado=false;
		
		if(productoreempla.getIsNew() || productoreempla.getIsChanged()) { 
			this.invalidValues = productoreemplaValidator.getInvalidValues(productoreempla);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoreempla);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoReempla(List<ProductoReempla> ProductoReemplas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoReempla productoreemplaLocal:productoreemplas) {				
			estaValidadoObjeto=this.validarGuardarProductoReempla(productoreemplaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoReempla(List<ProductoReempla> ProductoReemplas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoReempla(productoreemplas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoReempla(ProductoReempla ProductoReempla) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoReempla(productoreempla)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoReempla productoreempla) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoreempla.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoReemplaConstantesFunciones.getProductoReemplaLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoreempla","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoReemplaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoReemplaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoReemplaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-saveProductoReemplaWithConnection");connexion.begin();			
			
			ProductoReemplaLogicAdditional.checkProductoReemplaToSave(this.productoreempla,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoReemplaLogicAdditional.updateProductoReemplaToSave(this.productoreempla,this.arrDatoGeneral);
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoreempla,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoReempla();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoReempla(this.productoreempla)) {
				ProductoReemplaDataAccess.save(this.productoreempla, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoreempla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoReemplaLogicAdditional.checkProductoReemplaToSaveAfter(this.productoreempla,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoReempla();
			
			connexion.commit();			
			
			if(this.productoreempla.getIsDeleted()) {
				this.productoreempla=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoReempla()throws Exception {	
		try {	
			
			ProductoReemplaLogicAdditional.checkProductoReemplaToSave(this.productoreempla,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoReemplaLogicAdditional.updateProductoReemplaToSave(this.productoreempla,this.arrDatoGeneral);
			
			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoreempla,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoReempla(this.productoreempla)) {			
				ProductoReemplaDataAccess.save(this.productoreempla, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoreempla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoReemplaLogicAdditional.checkProductoReemplaToSaveAfter(this.productoreempla,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoreempla.getIsDeleted()) {
				this.productoreempla=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoReemplasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-saveProductoReemplasWithConnection");connexion.begin();			
			
			ProductoReemplaLogicAdditional.checkProductoReemplaToSaves(productoreemplas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoReemplas();
			
			Boolean validadoTodosProductoReempla=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoReempla productoreemplaLocal:productoreemplas) {		
				if(productoreemplaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoReemplaLogicAdditional.updateProductoReemplaToSave(productoreemplaLocal,this.arrDatoGeneral);
	        	
				ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoreemplaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoReempla(productoreemplaLocal)) {
					ProductoReemplaDataAccess.save(productoreemplaLocal, connexion);				
				} else {
					validadoTodosProductoReempla=false;
				}
			}
			
			if(!validadoTodosProductoReempla) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoReemplaLogicAdditional.checkProductoReemplaToSavesAfter(productoreemplas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoReemplas();
			
			connexion.commit();		
			
			this.quitarProductoReemplasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoReemplas()throws Exception {				
		 try {	
			ProductoReemplaLogicAdditional.checkProductoReemplaToSaves(productoreemplas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoReempla=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoReempla productoreemplaLocal:productoreemplas) {				
				if(productoreemplaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoReemplaLogicAdditional.updateProductoReemplaToSave(productoreemplaLocal,this.arrDatoGeneral);
	        	
				ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoreemplaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoReempla(productoreemplaLocal)) {				
					ProductoReemplaDataAccess.save(productoreemplaLocal, connexion);				
				} else {
					validadoTodosProductoReempla=false;
				}
			}
			
			if(!validadoTodosProductoReempla) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoReemplaLogicAdditional.checkProductoReemplaToSavesAfter(productoreemplas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoReemplasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoReemplaParameterReturnGeneral procesarAccionProductoReemplas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoReempla> productoreemplas,ProductoReemplaParameterReturnGeneral productoreemplaParameterGeneral)throws Exception {
		 try {	
			ProductoReemplaParameterReturnGeneral productoreemplaReturnGeneral=new ProductoReemplaParameterReturnGeneral();
	
			ProductoReemplaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoreemplas,productoreemplaParameterGeneral,productoreemplaReturnGeneral);
			
			return productoreemplaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoReemplaParameterReturnGeneral procesarAccionProductoReemplasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoReempla> productoreemplas,ProductoReemplaParameterReturnGeneral productoreemplaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-procesarAccionProductoReemplasWithConnection");connexion.begin();			
			
			ProductoReemplaParameterReturnGeneral productoreemplaReturnGeneral=new ProductoReemplaParameterReturnGeneral();
	
			ProductoReemplaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoreemplas,productoreemplaParameterGeneral,productoreemplaReturnGeneral);
			
			this.connexion.commit();
			
			return productoreemplaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoReemplaParameterReturnGeneral procesarEventosProductoReemplas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoReempla> productoreemplas,ProductoReempla productoreempla,ProductoReemplaParameterReturnGeneral productoreemplaParameterGeneral,Boolean isEsNuevoProductoReempla,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoReemplaParameterReturnGeneral productoreemplaReturnGeneral=new ProductoReemplaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoreemplaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoReemplaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoreemplas,productoreempla,productoreemplaParameterGeneral,productoreemplaReturnGeneral,isEsNuevoProductoReempla,clases);
			
			return productoreemplaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoReemplaParameterReturnGeneral procesarEventosProductoReemplasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoReempla> productoreemplas,ProductoReempla productoreempla,ProductoReemplaParameterReturnGeneral productoreemplaParameterGeneral,Boolean isEsNuevoProductoReempla,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-procesarEventosProductoReemplasWithConnection");connexion.begin();			
			
			ProductoReemplaParameterReturnGeneral productoreemplaReturnGeneral=new ProductoReemplaParameterReturnGeneral();
	
			productoreemplaReturnGeneral.setProductoReempla(productoreempla);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoreemplaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoReemplaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoreemplas,productoreempla,productoreemplaParameterGeneral,productoreemplaReturnGeneral,isEsNuevoProductoReempla,clases);
			
			this.connexion.commit();
			
			return productoreemplaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoReemplaParameterReturnGeneral procesarImportacionProductoReemplasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoReemplaParameterReturnGeneral productoreemplaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-procesarImportacionProductoReemplasWithConnection");connexion.begin();			
			
			ProductoReemplaParameterReturnGeneral productoreemplaReturnGeneral=new ProductoReemplaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoreemplas=new ArrayList<ProductoReempla>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoreempla=new ProductoReempla();
				
				
				if(conColumnasBase) {this.productoreempla.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoreempla.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoreempla.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoreemplas.add(this.productoreempla);
			}
			
			this.saveProductoReemplas();
			
			this.connexion.commit();
			
			productoreemplaReturnGeneral.setConRetornoEstaProcesado(true);
			productoreemplaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoreemplaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoReemplasEliminados() throws Exception {				
		
		List<ProductoReempla> productoreemplasAux= new ArrayList<ProductoReempla>();
		
		for(ProductoReempla productoreempla:productoreemplas) {
			if(!productoreempla.getIsDeleted()) {
				productoreemplasAux.add(productoreempla);
			}
		}
		
		productoreemplas=productoreemplasAux;
	}
	
	public void quitarProductoReemplasNulos() throws Exception {				
		
		List<ProductoReempla> productoreemplasAux= new ArrayList<ProductoReempla>();
		
		for(ProductoReempla productoreempla : this.productoreemplas) {
			if(productoreempla==null) {
				productoreemplasAux.add(productoreempla);
			}
		}
		
		//this.productoreemplas=productoreemplasAux;
		
		this.productoreemplas.removeAll(productoreemplasAux);
	}
	
	public void getSetVersionRowProductoReemplaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoreempla.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoreempla.getIsDeleted() || (productoreempla.getIsChanged()&&!productoreempla.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoreemplaDataAccess.getSetVersionRowProductoReempla(connexion,productoreempla.getId());
				
				if(!productoreempla.getVersionRow().equals(timestamp)) {	
					productoreempla.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoreempla.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoReempla()throws Exception {	
		
		if(productoreempla.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoreempla.getIsDeleted() || (productoreempla.getIsChanged()&&!productoreempla.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoreemplaDataAccess.getSetVersionRowProductoReempla(connexion,productoreempla.getId());
			
			try {							
				if(!productoreempla.getVersionRow().equals(timestamp)) {	
					productoreempla.setVersionRow(timestamp);
				}
				
				productoreempla.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoReemplasWithConnection()throws Exception {	
		if(productoreemplas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoReempla productoreemplaAux:productoreemplas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoreemplaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoreemplaAux.getIsDeleted() || (productoreemplaAux.getIsChanged()&&!productoreemplaAux.getIsNew())) {
						
						timestamp=productoreemplaDataAccess.getSetVersionRowProductoReempla(connexion,productoreemplaAux.getId());
						
						if(!productoreempla.getVersionRow().equals(timestamp)) {	
							productoreemplaAux.setVersionRow(timestamp);
						}
								
						productoreemplaAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoReemplas()throws Exception {	
		if(productoreemplas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoReempla productoreemplaAux:productoreemplas) {
					if(productoreemplaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoreemplaAux.getIsDeleted() || (productoreemplaAux.getIsChanged()&&!productoreemplaAux.getIsNew())) {
						
						timestamp=productoreemplaDataAccess.getSetVersionRowProductoReempla(connexion,productoreemplaAux.getId());
						
						if(!productoreemplaAux.getVersionRow().equals(timestamp)) {	
							productoreemplaAux.setVersionRow(timestamp);
						}
						
													
						productoreemplaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoReemplaParameterReturnGeneral cargarCombosLoteForeignKeyProductoReemplaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalProductoReempla) throws Exception {
		ProductoReemplaParameterReturnGeneral  productoreemplaReturnGeneral =new ProductoReemplaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoReemplaWithConnection");connexion.begin();
			
			productoreemplaReturnGeneral =new ProductoReemplaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productoreemplaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productoreemplaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoreemplaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoreemplaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<ProductoReempla> productoreemplasForeignKey=new ArrayList<ProductoReempla>();
			ProductoReemplaLogic productoreemplaLogic=new ProductoReemplaLogic();
			productoreemplaLogic.setConnexion(this.connexion);
			productoreemplaLogic.getProductoReemplaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoReempla.equals("NONE")) {
				productoreemplaLogic.getTodosProductoReemplas(finalQueryGlobalProductoReempla,new Pagination());
				productoreemplasForeignKey=productoreemplaLogic.getProductoReemplas();
			}

			productoreemplaReturnGeneral.setproductoreemplasForeignKey(productoreemplasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoreemplaReturnGeneral;
	}
	
	public ProductoReemplaParameterReturnGeneral cargarCombosLoteForeignKeyProductoReempla(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalProductoReempla) throws Exception {
		ProductoReemplaParameterReturnGeneral  productoreemplaReturnGeneral =new ProductoReemplaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoreemplaReturnGeneral =new ProductoReemplaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productoreemplaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productoreemplaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoreemplaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoreemplaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<ProductoReempla> productoreemplasForeignKey=new ArrayList<ProductoReempla>();
			ProductoReemplaLogic productoreemplaLogic=new ProductoReemplaLogic();
			productoreemplaLogic.setConnexion(this.connexion);
			productoreemplaLogic.getProductoReemplaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoReempla.equals("NONE")) {
				productoreemplaLogic.getTodosProductoReemplas(finalQueryGlobalProductoReempla,new Pagination());
				productoreemplasForeignKey=productoreemplaLogic.getProductoReemplas();
			}

			productoreemplaReturnGeneral.setproductoreemplasForeignKey(productoreemplasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoreemplaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyProductoReemplaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoReemplaLogic productoreemplaLogic=new ProductoReemplaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyProductoReemplaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProductoReempla.class));
											
			

			productoreemplaLogic.setConnexion(this.getConnexion());
			productoreemplaLogic.setDatosCliente(this.datosCliente);
			productoreemplaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(ProductoReempla productoreempla:this.productoreemplas) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoReemplaConstantesFunciones.getClassesForeignKeysOfProductoReempla(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoreemplaLogic.setProductoReemplas(productoreempla.productoreemplas);
				productoreemplaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(ProductoReempla productoreempla,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoReemplaLogicAdditional.updateProductoReemplaToGet(productoreempla,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoreempla.setEmpresa(productoreemplaDataAccess.getEmpresa(connexion,productoreempla));
		productoreempla.setSucursal(productoreemplaDataAccess.getSucursal(connexion,productoreempla));
		productoreempla.setBodega(productoreemplaDataAccess.getBodega(connexion,productoreempla));
		productoreempla.setProducto(productoreemplaDataAccess.getProducto(connexion,productoreempla));
		productoreempla.setProductoReempla(productoreemplaDataAccess.getProductoReempla(connexion,productoreempla));
		productoreempla.setProductoReemplas(productoreemplaDataAccess.getProductoReemplas(connexion,productoreempla));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productoreempla.setEmpresa(productoreemplaDataAccess.getEmpresa(connexion,productoreempla));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productoreempla.setSucursal(productoreemplaDataAccess.getSucursal(connexion,productoreempla));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoreempla.setBodega(productoreemplaDataAccess.getBodega(connexion,productoreempla));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoreempla.setProducto(productoreemplaDataAccess.getProducto(connexion,productoreempla));
				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)) {
				productoreempla.setProductoReempla(productoreemplaDataAccess.getProductoReempla(connexion,productoreempla));
				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productoreempla.setProductoReemplas(productoreemplaDataAccess.getProductoReemplas(connexion,productoreempla));

				if(this.isConDeep) {
					ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(this.connexion);
					productoreemplaLogic.setProductoReemplas(productoreempla.getProductoReemplas());
					ArrayList<Classe> classesLocal=ProductoReemplaConstantesFunciones.getClassesForeignKeysOfProductoReempla(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoreemplaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(productoreemplaLogic.getProductoReemplas());
					productoreempla.setProductoReemplas(productoreemplaLogic.getProductoReemplas());
				}

				continue;
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
			productoreempla.setEmpresa(productoreemplaDataAccess.getEmpresa(connexion,productoreempla));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoreempla.setSucursal(productoreemplaDataAccess.getSucursal(connexion,productoreempla));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoreempla.setBodega(productoreemplaDataAccess.getBodega(connexion,productoreempla));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoreempla.setProducto(productoreemplaDataAccess.getProducto(connexion,productoreempla));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoReempla.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoreempla.setProductoReempla(productoreemplaDataAccess.getProductoReempla(connexion,productoreempla));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoReempla.class));
			productoreempla.setProductoReemplas(productoreemplaDataAccess.getProductoReemplas(connexion,productoreempla));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoreempla.setEmpresa(productoreemplaDataAccess.getEmpresa(connexion,productoreempla));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productoreempla.getEmpresa(),isDeep,deepLoadType,clases);
				
		productoreempla.setSucursal(productoreemplaDataAccess.getSucursal(connexion,productoreempla));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productoreempla.getSucursal(),isDeep,deepLoadType,clases);
				
		productoreempla.setBodega(productoreemplaDataAccess.getBodega(connexion,productoreempla));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoreempla.getBodega(),isDeep,deepLoadType,clases);
				
		productoreempla.setProducto(productoreemplaDataAccess.getProducto(connexion,productoreempla));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoreempla.getProducto(),isDeep,deepLoadType,clases);
				
		productoreempla.setProductoReempla(productoreemplaDataAccess.getProductoReempla(connexion,productoreempla));
		ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
		productoreemplaLogic.deepLoad(productoreempla.getProductoReempla(),isDeep,deepLoadType,clases);
				

		productoreempla.setProductoReemplas(productoreemplaDataAccess.getProductoReemplas(connexion,productoreempla));

		for(ProductoReempla productoreemplaRecursivo:productoreempla.getProductoReemplas()) {
			ProductoReemplaLogic productoreemplaRecursivoLogic= new ProductoReemplaLogic(connexion);
			productoreemplaRecursivoLogic.deepLoad(productoreemplaRecursivo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productoreempla.setEmpresa(productoreemplaDataAccess.getEmpresa(connexion,productoreempla));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productoreempla.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productoreempla.setSucursal(productoreemplaDataAccess.getSucursal(connexion,productoreempla));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productoreempla.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoreempla.setBodega(productoreemplaDataAccess.getBodega(connexion,productoreempla));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productoreempla.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoreempla.setProducto(productoreemplaDataAccess.getProducto(connexion,productoreempla));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productoreempla.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)) {
				productoreempla.setProductoReempla(productoreemplaDataAccess.getProductoReempla(connexion,productoreempla));
				ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
				productoreemplaLogic.deepLoad(productoreempla.getProductoReempla(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productoreempla.setProductoReemplas(productoreemplaDataAccess.getProductoReemplas(connexion,productoreempla));

				for(ProductoReempla productoreemplaRecursivo:productoreempla.getProductoReemplas()) {
					ProductoReemplaLogic productoreemplaRecursivoLogic= new ProductoReemplaLogic(connexion);
					productoreemplaRecursivoLogic.deepLoad(productoreemplaRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
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
			productoreempla.setEmpresa(productoreemplaDataAccess.getEmpresa(connexion,productoreempla));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productoreempla.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoreempla.setSucursal(productoreemplaDataAccess.getSucursal(connexion,productoreempla));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productoreempla.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoreempla.setBodega(productoreemplaDataAccess.getBodega(connexion,productoreempla));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productoreempla.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoreempla.setProducto(productoreemplaDataAccess.getProducto(connexion,productoreempla));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productoreempla.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoReempla.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoreempla.setProductoReempla(productoreemplaDataAccess.getProductoReempla(connexion,productoreempla));
			ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
			productoreemplaLogic.deepLoad(productoreempla.getProductoReempla(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoReempla.class));
			productoreempla.setProductoReemplas(productoreemplaDataAccess.getProductoReemplas(connexion,productoreempla));

			for(ProductoReempla productoreemplaRecursivo:productoreempla.getProductoReemplas()) {
				ProductoReemplaLogic productoreemplaRecursivoLogic= new ProductoReemplaLogic(connexion);
				productoreemplaRecursivoLogic.deepLoad(productoreemplaRecursivo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoReempla productoreempla,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoReemplaLogicAdditional.updateProductoReemplaToSave(productoreempla,this.arrDatoGeneral);
			
ProductoReemplaDataAccess.save(productoreempla, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productoreempla.getEmpresa(),connexion);

		SucursalDataAccess.save(productoreempla.getSucursal(),connexion);

		BodegaDataAccess.save(productoreempla.getBodega(),connexion);

		ProductoDataAccess.save(productoreempla.getProducto(),connexion);

		ProductoReemplaDataAccess.save(productoreempla.getProductoReempla(),connexion);

		for(ProductoReempla productoreemplaRecursivo:productoreempla.getProductoReemplas()) {
			productoreemplaRecursivo.setid_producto_reempla(productoreempla.getId());
			ProductoReemplaDataAccess.save(productoreemplaRecursivo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productoreempla.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productoreempla.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoreempla.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoreempla.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)) {
				ProductoReemplaDataAccess.save(productoreempla.getProductoReempla(),connexion);
				continue;
			}


			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoReempla productoreemplaRecursivo:productoreempla.getProductoReemplas()) {
					productoreemplaRecursivo.setid_producto_reempla(productoreempla.getId());
					ProductoReemplaDataAccess.save(productoreemplaRecursivo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productoreempla.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productoreempla.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(productoreempla.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productoreempla.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(productoreempla.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoreempla.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(productoreempla.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoreempla.getProducto(),isDeep,deepLoadType,clases);
				

		ProductoReemplaDataAccess.save(productoreempla.getProductoReempla(),connexion);
		ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
		productoreemplaLogic.deepLoad(productoreempla.getProductoReempla(),isDeep,deepLoadType,clases);
				

		for(ProductoReempla productoreemplaRecursivo:productoreempla.getProductoReemplas()) {
			ProductoReemplaLogic productoreemplaRecursivoLogic= new ProductoReemplaLogic(connexion);
			productoreemplaRecursivo.setid_producto_reempla(productoreempla.getId());
			ProductoReemplaDataAccess.save(productoreemplaRecursivo,connexion);
			productoreemplaRecursivoLogic.deepSave(productoreemplaRecursivo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productoreempla.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(productoreempla.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productoreempla.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(productoreempla.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoreempla.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(productoreempla.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoreempla.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(productoreempla.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)) {
				ProductoReemplaDataAccess.save(productoreempla.getProductoReempla(),connexion);
				ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
				productoreemplaLogic.deepSave(productoreempla.getProductoReempla(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoReempla productoreemplaRecursivo:productoreempla.getProductoReemplas()) {
					ProductoReemplaLogic productoreemplaRecursivoLogic= new ProductoReemplaLogic(connexion);
					productoreemplaRecursivo.setid_producto_reempla(productoreempla.getId());
					ProductoReemplaDataAccess.save(productoreemplaRecursivo,connexion);
					productoreemplaRecursivoLogic.deepSave(productoreemplaRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}
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
			this.getNewConnexionToDeep(ProductoReempla.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoreempla,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(productoreempla);
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
			this.deepLoad(this.productoreempla,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreempla);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoReempla.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoreemplas!=null) {
				for(ProductoReempla productoreempla:productoreemplas) {
					this.deepLoad(productoreempla,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(productoreemplas);
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
			if(productoreemplas!=null) {
				for(ProductoReempla productoreempla:productoreemplas) {
					this.deepLoad(productoreempla,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(productoreemplas);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(ProductoReempla.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoreempla,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(ProductoReempla.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoreemplas!=null) {
				for(ProductoReempla productoreempla:productoreemplas) {
					this.deepSave(productoreempla,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(productoreemplas!=null) {
				for(ProductoReempla productoreempla:productoreemplas) {
					this.deepSave(productoreempla,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoReemplasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoReemplaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoReemplasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoReemplaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoReemplasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoReemplaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoReemplasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoReemplaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoReemplasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoReemplaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoReemplasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoReemplaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoReemplasFK_IdProductoReemplaWithConnection(String sFinalQuery,Pagination pagination,Long id_producto_reempla)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoReempla= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoReempla.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_reempla,ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoReempla);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoReempla","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoReemplasFK_IdProductoReempla(String sFinalQuery,Pagination pagination,Long id_producto_reempla)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoReempla= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoReempla.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_reempla,ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoReempla);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoReempla","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoReemplasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoReempla.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoReemplaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoReemplasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoReemplaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoReemplaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(this.productoreemplas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoReemplaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoReemplaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoReempla productoreempla,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoReemplaConstantesFunciones.ISCONAUDITORIA) {
				if(productoreempla.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoReemplaDataAccess.TABLENAME, productoreempla.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoReemplaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoReemplaLogic.registrarAuditoriaDetallesProductoReempla(connexion,productoreempla,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoreempla.getIsDeleted()) {
					/*if(!productoreempla.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoReemplaDataAccess.TABLENAME, productoreempla.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoReemplaLogic.registrarAuditoriaDetallesProductoReempla(connexion,productoreempla,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoReemplaDataAccess.TABLENAME, productoreempla.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoreempla.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoReemplaDataAccess.TABLENAME, productoreempla.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoReemplaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoReemplaLogic.registrarAuditoriaDetallesProductoReempla(connexion,productoreempla,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoReempla(Connexion connexion,ProductoReempla productoreempla)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoreempla.getIsNew()||!productoreempla.getid_empresa().equals(productoreempla.getProductoReemplaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoreempla.getProductoReemplaOriginal().getid_empresa()!=null)
				{
					strValorActual=productoreempla.getProductoReemplaOriginal().getid_empresa().toString();
				}
				if(productoreempla.getid_empresa()!=null)
				{
					strValorNuevo=productoreempla.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoReemplaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoreempla.getIsNew()||!productoreempla.getid_sucursal().equals(productoreempla.getProductoReemplaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoreempla.getProductoReemplaOriginal().getid_sucursal()!=null)
				{
					strValorActual=productoreempla.getProductoReemplaOriginal().getid_sucursal().toString();
				}
				if(productoreempla.getid_sucursal()!=null)
				{
					strValorNuevo=productoreempla.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoReemplaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(productoreempla.getIsNew()||!productoreempla.getid_bodega().equals(productoreempla.getProductoReemplaOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoreempla.getProductoReemplaOriginal().getid_bodega()!=null)
				{
					strValorActual=productoreempla.getProductoReemplaOriginal().getid_bodega().toString();
				}
				if(productoreempla.getid_bodega()!=null)
				{
					strValorNuevo=productoreempla.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoReemplaConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(productoreempla.getIsNew()||!productoreempla.getid_producto().equals(productoreempla.getProductoReemplaOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoreempla.getProductoReemplaOriginal().getid_producto()!=null)
				{
					strValorActual=productoreempla.getProductoReemplaOriginal().getid_producto().toString();
				}
				if(productoreempla.getid_producto()!=null)
				{
					strValorNuevo=productoreempla.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoReemplaConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(productoreempla.getIsNew()||!productoreempla.getid_producto_reempla().equals(productoreempla.getProductoReemplaOriginal().getid_producto_reempla()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoreempla.getProductoReemplaOriginal().getid_producto_reempla()!=null)
				{
					strValorActual=productoreempla.getProductoReemplaOriginal().getid_producto_reempla().toString();
				}
				if(productoreempla.getid_producto_reempla()!=null)
				{
					strValorNuevo=productoreempla.getid_producto_reempla().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA,strValorActual,strValorNuevo);
			}	
			
			if(productoreempla.getIsNew()||!productoreempla.getdescripcion().equals(productoreempla.getProductoReemplaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoreempla.getProductoReemplaOriginal().getdescripcion()!=null)
				{
					strValorActual=productoreempla.getProductoReemplaOriginal().getdescripcion();
				}
				if(productoreempla.getdescripcion()!=null)
				{
					strValorNuevo=productoreempla.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoReemplaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoReemplaRelacionesWithConnection(ProductoReempla productoreempla,List<ProductoReempla> productoreemplas) throws Exception {

		if(!productoreempla.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoReemplaRelacionesBase(productoreempla,productoreemplas,true);
		}
	}

	public void saveProductoReemplaRelaciones(ProductoReempla productoreempla,List<ProductoReempla> productoreemplas)throws Exception {

		if(!productoreempla.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoReemplaRelacionesBase(productoreempla,productoreemplas,false);
		}
	}

	public void saveProductoReemplaRelacionesBase(ProductoReempla productoreempla,List<ProductoReempla> productoreemplas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoReempla-saveRelacionesWithConnection");}
	
			productoreempla.setProductoReemplas(productoreemplas);

			this.setProductoReempla(productoreempla);

			if(ProductoReemplaLogicAdditional.validarSaveRelaciones(productoreempla,this)) {

				ProductoReemplaLogicAdditional.updateRelacionesToSave(productoreempla,this);

				if((productoreempla.getIsNew()||productoreempla.getIsChanged())&&!productoreempla.getIsDeleted()) {
					this.saveProductoReempla();
					this.saveProductoReemplaRelacionesDetalles(productoreemplas);

				} else if(productoreempla.getIsDeleted()) {
					this.saveProductoReemplaRelacionesDetalles(productoreemplas);
					this.saveProductoReempla();
				}

				ProductoReemplaLogicAdditional.updateRelacionesToSaveAfter(productoreempla,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoReemplaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoReemplas(productoreemplas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveProductoReemplaRelacionesDetalles(List<ProductoReempla> productoreemplas)throws Exception {
		try {
	

			Long idProductoReemplaActual=this.getProductoReempla().getId();

			ProductoReemplaLogic productoreemplaLogicHijos_Desde_ProductoReempla=new ProductoReemplaLogic();
			productoreemplaLogicHijos_Desde_ProductoReempla.setProductoReemplas(productoreemplas);

			productoreemplaLogicHijos_Desde_ProductoReempla.setConnexion(this.getConnexion());
			productoreemplaLogicHijos_Desde_ProductoReempla.setDatosCliente(this.datosCliente);

			for(ProductoReempla productoreemplaHijos_Desde_ProductoReempla:productoreemplaLogicHijos_Desde_ProductoReempla.getProductoReemplas()) {
				productoreemplaHijos_Desde_ProductoReempla.setid_producto_reempla(idProductoReemplaActual);

				productoreemplaLogicHijos_Desde_ProductoReempla.setProductoReempla(productoreemplaHijos_Desde_ProductoReempla);
				productoreemplaLogicHijos_Desde_ProductoReempla.saveProductoReempla();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoReempla(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoReemplaConstantesFunciones.getClassesForeignKeysOfProductoReempla(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoReempla(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoReemplaConstantesFunciones.getClassesRelationshipsOfProductoReempla(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

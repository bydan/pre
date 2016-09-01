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
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.produccion.util.ProductoProduGastoConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduGastoParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduGastoParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoProduGasto;
import com.bydan.erp.produccion.business.logic.ProductoProduGastoLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoProduGastoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoProduGastoLogic.class);
	
	protected ProductoProduGastoDataAccess productoprodugastoDataAccess; 	
	protected ProductoProduGasto productoprodugasto;
	protected List<ProductoProduGasto> productoprodugastos;
	protected Object productoprodugastoObject;	
	protected List<Object> productoprodugastosObject;
	
	public static ClassValidator<ProductoProduGasto> productoprodugastoValidator = new ClassValidator<ProductoProduGasto>(ProductoProduGasto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoProduGastoLogicAdditional productoprodugastoLogicAdditional=null;
	
	public ProductoProduGastoLogicAdditional getProductoProduGastoLogicAdditional() {
		return this.productoprodugastoLogicAdditional;
	}
	
	public void setProductoProduGastoLogicAdditional(ProductoProduGastoLogicAdditional productoprodugastoLogicAdditional) {
		try {
			this.productoprodugastoLogicAdditional=productoprodugastoLogicAdditional;
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
	
	
	
	
	public  ProductoProduGastoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoprodugastoDataAccess = new ProductoProduGastoDataAccess();
			
			this.productoprodugastos= new ArrayList<ProductoProduGasto>();
			this.productoprodugasto= new ProductoProduGasto();
			
			this.productoprodugastoObject=new Object();
			this.productoprodugastosObject=new ArrayList<Object>();
				
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
			
			this.productoprodugastoDataAccess.setConnexionType(this.connexionType);
			this.productoprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoProduGastoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoprodugastoDataAccess = new ProductoProduGastoDataAccess();
			this.productoprodugastos= new ArrayList<ProductoProduGasto>();
			this.productoprodugasto= new ProductoProduGasto();
			this.productoprodugastoObject=new Object();
			this.productoprodugastosObject=new ArrayList<Object>();
			
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
			
			this.productoprodugastoDataAccess.setConnexionType(this.connexionType);
			this.productoprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoProduGasto getProductoProduGasto() throws Exception {	
		ProductoProduGastoLogicAdditional.checkProductoProduGastoToGet(productoprodugasto,this.datosCliente,this.arrDatoGeneral);
		ProductoProduGastoLogicAdditional.updateProductoProduGastoToGet(productoprodugasto,this.arrDatoGeneral);
		
		return productoprodugasto;
	}
		
	public void setProductoProduGasto(ProductoProduGasto newProductoProduGasto) {
		this.productoprodugasto = newProductoProduGasto;
	}
	
	public ProductoProduGastoDataAccess getProductoProduGastoDataAccess() {
		return productoprodugastoDataAccess;
	}
	
	public void setProductoProduGastoDataAccess(ProductoProduGastoDataAccess newproductoprodugastoDataAccess) {
		this.productoprodugastoDataAccess = newproductoprodugastoDataAccess;
	}
	
	public List<ProductoProduGasto> getProductoProduGastos() throws Exception {		
		this.quitarProductoProduGastosNulos();
		
		ProductoProduGastoLogicAdditional.checkProductoProduGastoToGets(productoprodugastos,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoProduGasto productoprodugastoLocal: productoprodugastos ) {
			ProductoProduGastoLogicAdditional.updateProductoProduGastoToGet(productoprodugastoLocal,this.arrDatoGeneral);
		}
		
		return productoprodugastos;
	}
	
	public void setProductoProduGastos(List<ProductoProduGasto> newProductoProduGastos) {
		this.productoprodugastos = newProductoProduGastos;
	}
	
	public Object getProductoProduGastoObject() {	
		this.productoprodugastoObject=this.productoprodugastoDataAccess.getEntityObject();
		return this.productoprodugastoObject;
	}
		
	public void setProductoProduGastoObject(Object newProductoProduGastoObject) {
		this.productoprodugastoObject = newProductoProduGastoObject;
	}
	
	public List<Object> getProductoProduGastosObject() {		
		this.productoprodugastosObject=this.productoprodugastoDataAccess.getEntitiesObject();
		return this.productoprodugastosObject;
	}
		
	public void setProductoProduGastosObject(List<Object> newProductoProduGastosObject) {
		this.productoprodugastosObject = newProductoProduGastosObject;
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
		
		if(this.productoprodugastoDataAccess!=null) {
			this.productoprodugastoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoprodugastoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoprodugastoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoprodugasto = new  ProductoProduGasto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodugasto=productoprodugastoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugasto);
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
		productoprodugasto = new  ProductoProduGasto();
		  		  
        try {
			
			productoprodugasto=productoprodugastoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugasto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoprodugasto = new  ProductoProduGasto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodugasto=productoprodugastoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugasto);
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
		productoprodugasto = new  ProductoProduGasto();
		  		  
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
		productoprodugasto = new  ProductoProduGasto();
		  		  
        try {
			
			productoprodugasto=productoprodugastoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugasto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoprodugasto = new  ProductoProduGasto();
		  		  
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
		productoprodugasto = new  ProductoProduGasto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoprodugastoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodugasto = new  ProductoProduGasto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoprodugastoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodugasto = new  ProductoProduGasto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoprodugastoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodugasto = new  ProductoProduGasto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoprodugastoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodugasto = new  ProductoProduGasto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoprodugastoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodugasto = new  ProductoProduGasto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoprodugastoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
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
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		  		  
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
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		  		  
        try {			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		  		  
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
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
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
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		  		  
        try {
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
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
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
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
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoprodugasto = new  ProductoProduGasto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugasto=productoprodugastoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduGasto(productoprodugasto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugasto);
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
		productoprodugasto = new  ProductoProduGasto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugasto=productoprodugastoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduGasto(productoprodugasto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugasto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
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
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		  		  
        try {
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoProduGastosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getTodosProductoProduGastosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
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
	
	public  void  getTodosProductoProduGastos(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodugastos = new  ArrayList<ProductoProduGasto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProduGasto(productoprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoProduGasto(ProductoProduGasto productoprodugasto) throws Exception {
		Boolean estaValidado=false;
		
		if(productoprodugasto.getIsNew() || productoprodugasto.getIsChanged()) { 
			this.invalidValues = productoprodugastoValidator.getInvalidValues(productoprodugasto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoprodugasto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoProduGasto(List<ProductoProduGasto> ProductoProduGastos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoProduGasto productoprodugastoLocal:productoprodugastos) {				
			estaValidadoObjeto=this.validarGuardarProductoProduGasto(productoprodugastoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoProduGasto(List<ProductoProduGasto> ProductoProduGastos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProduGasto(productoprodugastos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoProduGasto(ProductoProduGasto ProductoProduGasto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProduGasto(productoprodugasto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoProduGasto productoprodugasto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoprodugasto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoProduGastoConstantesFunciones.getProductoProduGastoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoprodugasto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoProduGastoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoProduGastoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoProduGastoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-saveProductoProduGastoWithConnection");connexion.begin();			
			
			ProductoProduGastoLogicAdditional.checkProductoProduGastoToSave(this.productoprodugasto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduGastoLogicAdditional.updateProductoProduGastoToSave(this.productoprodugasto,this.arrDatoGeneral);
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodugasto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoProduGasto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProduGasto(this.productoprodugasto)) {
				ProductoProduGastoDataAccess.save(this.productoprodugasto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduGastoLogicAdditional.checkProductoProduGastoToSaveAfter(this.productoprodugasto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProduGasto();
			
			connexion.commit();			
			
			if(this.productoprodugasto.getIsDeleted()) {
				this.productoprodugasto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoProduGasto()throws Exception {	
		try {	
			
			ProductoProduGastoLogicAdditional.checkProductoProduGastoToSave(this.productoprodugasto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduGastoLogicAdditional.updateProductoProduGastoToSave(this.productoprodugasto,this.arrDatoGeneral);
			
			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodugasto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProduGasto(this.productoprodugasto)) {			
				ProductoProduGastoDataAccess.save(this.productoprodugasto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduGastoLogicAdditional.checkProductoProduGastoToSaveAfter(this.productoprodugasto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoprodugasto.getIsDeleted()) {
				this.productoprodugasto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoProduGastosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-saveProductoProduGastosWithConnection");connexion.begin();			
			
			ProductoProduGastoLogicAdditional.checkProductoProduGastoToSaves(productoprodugastos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoProduGastos();
			
			Boolean validadoTodosProductoProduGasto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProduGasto productoprodugastoLocal:productoprodugastos) {		
				if(productoprodugastoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduGastoLogicAdditional.updateProductoProduGastoToSave(productoprodugastoLocal,this.arrDatoGeneral);
	        	
				ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoprodugastoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProduGasto(productoprodugastoLocal)) {
					ProductoProduGastoDataAccess.save(productoprodugastoLocal, connexion);				
				} else {
					validadoTodosProductoProduGasto=false;
				}
			}
			
			if(!validadoTodosProductoProduGasto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduGastoLogicAdditional.checkProductoProduGastoToSavesAfter(productoprodugastos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProduGastos();
			
			connexion.commit();		
			
			this.quitarProductoProduGastosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoProduGastos()throws Exception {				
		 try {	
			ProductoProduGastoLogicAdditional.checkProductoProduGastoToSaves(productoprodugastos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoProduGasto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProduGasto productoprodugastoLocal:productoprodugastos) {				
				if(productoprodugastoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduGastoLogicAdditional.updateProductoProduGastoToSave(productoprodugastoLocal,this.arrDatoGeneral);
	        	
				ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoprodugastoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProduGasto(productoprodugastoLocal)) {				
					ProductoProduGastoDataAccess.save(productoprodugastoLocal, connexion);				
				} else {
					validadoTodosProductoProduGasto=false;
				}
			}
			
			if(!validadoTodosProductoProduGasto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduGastoLogicAdditional.checkProductoProduGastoToSavesAfter(productoprodugastos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoProduGastosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduGastoParameterReturnGeneral procesarAccionProductoProduGastos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProduGasto> productoprodugastos,ProductoProduGastoParameterReturnGeneral productoprodugastoParameterGeneral)throws Exception {
		 try {	
			ProductoProduGastoParameterReturnGeneral productoprodugastoReturnGeneral=new ProductoProduGastoParameterReturnGeneral();
	
			ProductoProduGastoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodugastos,productoprodugastoParameterGeneral,productoprodugastoReturnGeneral);
			
			return productoprodugastoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduGastoParameterReturnGeneral procesarAccionProductoProduGastosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProduGasto> productoprodugastos,ProductoProduGastoParameterReturnGeneral productoprodugastoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-procesarAccionProductoProduGastosWithConnection");connexion.begin();			
			
			ProductoProduGastoParameterReturnGeneral productoprodugastoReturnGeneral=new ProductoProduGastoParameterReturnGeneral();
	
			ProductoProduGastoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodugastos,productoprodugastoParameterGeneral,productoprodugastoReturnGeneral);
			
			this.connexion.commit();
			
			return productoprodugastoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduGastoParameterReturnGeneral procesarEventosProductoProduGastos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProduGasto> productoprodugastos,ProductoProduGasto productoprodugasto,ProductoProduGastoParameterReturnGeneral productoprodugastoParameterGeneral,Boolean isEsNuevoProductoProduGasto,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoProduGastoParameterReturnGeneral productoprodugastoReturnGeneral=new ProductoProduGastoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoprodugastoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduGastoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodugastos,productoprodugasto,productoprodugastoParameterGeneral,productoprodugastoReturnGeneral,isEsNuevoProductoProduGasto,clases);
			
			return productoprodugastoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoProduGastoParameterReturnGeneral procesarEventosProductoProduGastosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProduGasto> productoprodugastos,ProductoProduGasto productoprodugasto,ProductoProduGastoParameterReturnGeneral productoprodugastoParameterGeneral,Boolean isEsNuevoProductoProduGasto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-procesarEventosProductoProduGastosWithConnection");connexion.begin();			
			
			ProductoProduGastoParameterReturnGeneral productoprodugastoReturnGeneral=new ProductoProduGastoParameterReturnGeneral();
	
			productoprodugastoReturnGeneral.setProductoProduGasto(productoprodugasto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoprodugastoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduGastoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodugastos,productoprodugasto,productoprodugastoParameterGeneral,productoprodugastoReturnGeneral,isEsNuevoProductoProduGasto,clases);
			
			this.connexion.commit();
			
			return productoprodugastoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduGastoParameterReturnGeneral procesarImportacionProductoProduGastosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoProduGastoParameterReturnGeneral productoprodugastoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-procesarImportacionProductoProduGastosWithConnection");connexion.begin();			
			
			ProductoProduGastoParameterReturnGeneral productoprodugastoReturnGeneral=new ProductoProduGastoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoprodugastos=new ArrayList<ProductoProduGasto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoprodugasto=new ProductoProduGasto();
				
				
				if(conColumnasBase) {this.productoprodugasto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoprodugasto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoprodugasto.setcanitdad(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoprodugasto.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodugasto.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodugasto.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoprodugastos.add(this.productoprodugasto);
			}
			
			this.saveProductoProduGastos();
			
			this.connexion.commit();
			
			productoprodugastoReturnGeneral.setConRetornoEstaProcesado(true);
			productoprodugastoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoprodugastoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoProduGastosEliminados() throws Exception {				
		
		List<ProductoProduGasto> productoprodugastosAux= new ArrayList<ProductoProduGasto>();
		
		for(ProductoProduGasto productoprodugasto:productoprodugastos) {
			if(!productoprodugasto.getIsDeleted()) {
				productoprodugastosAux.add(productoprodugasto);
			}
		}
		
		productoprodugastos=productoprodugastosAux;
	}
	
	public void quitarProductoProduGastosNulos() throws Exception {				
		
		List<ProductoProduGasto> productoprodugastosAux= new ArrayList<ProductoProduGasto>();
		
		for(ProductoProduGasto productoprodugasto : this.productoprodugastos) {
			if(productoprodugasto==null) {
				productoprodugastosAux.add(productoprodugasto);
			}
		}
		
		//this.productoprodugastos=productoprodugastosAux;
		
		this.productoprodugastos.removeAll(productoprodugastosAux);
	}
	
	public void getSetVersionRowProductoProduGastoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoprodugasto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoprodugasto.getIsDeleted() || (productoprodugasto.getIsChanged()&&!productoprodugasto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoprodugastoDataAccess.getSetVersionRowProductoProduGasto(connexion,productoprodugasto.getId());
				
				if(!productoprodugasto.getVersionRow().equals(timestamp)) {	
					productoprodugasto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoprodugasto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoProduGasto()throws Exception {	
		
		if(productoprodugasto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoprodugasto.getIsDeleted() || (productoprodugasto.getIsChanged()&&!productoprodugasto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoprodugastoDataAccess.getSetVersionRowProductoProduGasto(connexion,productoprodugasto.getId());
			
			try {							
				if(!productoprodugasto.getVersionRow().equals(timestamp)) {	
					productoprodugasto.setVersionRow(timestamp);
				}
				
				productoprodugasto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoProduGastosWithConnection()throws Exception {	
		if(productoprodugastos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoProduGasto productoprodugastoAux:productoprodugastos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoprodugastoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoprodugastoAux.getIsDeleted() || (productoprodugastoAux.getIsChanged()&&!productoprodugastoAux.getIsNew())) {
						
						timestamp=productoprodugastoDataAccess.getSetVersionRowProductoProduGasto(connexion,productoprodugastoAux.getId());
						
						if(!productoprodugasto.getVersionRow().equals(timestamp)) {	
							productoprodugastoAux.setVersionRow(timestamp);
						}
								
						productoprodugastoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoProduGastos()throws Exception {	
		if(productoprodugastos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoProduGasto productoprodugastoAux:productoprodugastos) {
					if(productoprodugastoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoprodugastoAux.getIsDeleted() || (productoprodugastoAux.getIsChanged()&&!productoprodugastoAux.getIsNew())) {
						
						timestamp=productoprodugastoDataAccess.getSetVersionRowProductoProduGasto(connexion,productoprodugastoAux.getId());
						
						if(!productoprodugastoAux.getVersionRow().equals(timestamp)) {	
							productoprodugastoAux.setVersionRow(timestamp);
						}
						
													
						productoprodugastoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoProduGastoParameterReturnGeneral cargarCombosLoteForeignKeyProductoProduGastoWithConnection(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalTipoGastoProduEmpresa,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalClienteProveedor,String finalQueryGlobalFactura,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduGastoParameterReturnGeneral  productoprodugastoReturnGeneral =new ProductoProduGastoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoProduGastoWithConnection");connexion.begin();
			
			productoprodugastoReturnGeneral =new ProductoProduGastoParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoprodugastoReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<TipoGastoProduEmpresa> tipogastoproduempresasForeignKey=new ArrayList<TipoGastoProduEmpresa>();
			TipoGastoProduEmpresaLogic tipogastoproduempresaLogic=new TipoGastoProduEmpresaLogic();
			tipogastoproduempresaLogic.setConnexion(this.connexion);
			tipogastoproduempresaLogic.getTipoGastoProduEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGastoProduEmpresa.equals("NONE")) {
				tipogastoproduempresaLogic.getTodosTipoGastoProduEmpresas(finalQueryGlobalTipoGastoProduEmpresa,new Pagination());
				tipogastoproduempresasForeignKey=tipogastoproduempresaLogic.getTipoGastoProduEmpresas();
			}

			productoprodugastoReturnGeneral.settipogastoproduempresasForeignKey(tipogastoproduempresasForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			productoprodugastoReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			productoprodugastoReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<Cliente> clienteproveedorsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedorLogic=new ClienteLogic();
			clienteproveedorLogic.setConnexion(this.connexion);
			clienteproveedorLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedor.equals("NONE")) {
				clienteproveedorLogic.getTodosClientes(finalQueryGlobalClienteProveedor,new Pagination());
				clienteproveedorsForeignKey=clienteproveedorLogic.getClientes();
			}

			productoprodugastoReturnGeneral.setclienteproveedorsForeignKey(clienteproveedorsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			productoprodugastoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoprodugastoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoprodugastoReturnGeneral;
	}
	
	public ProductoProduGastoParameterReturnGeneral cargarCombosLoteForeignKeyProductoProduGasto(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalTipoGastoProduEmpresa,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalClienteProveedor,String finalQueryGlobalFactura,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduGastoParameterReturnGeneral  productoprodugastoReturnGeneral =new ProductoProduGastoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoprodugastoReturnGeneral =new ProductoProduGastoParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoprodugastoReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<TipoGastoProduEmpresa> tipogastoproduempresasForeignKey=new ArrayList<TipoGastoProduEmpresa>();
			TipoGastoProduEmpresaLogic tipogastoproduempresaLogic=new TipoGastoProduEmpresaLogic();
			tipogastoproduempresaLogic.setConnexion(this.connexion);
			tipogastoproduempresaLogic.getTipoGastoProduEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGastoProduEmpresa.equals("NONE")) {
				tipogastoproduempresaLogic.getTodosTipoGastoProduEmpresas(finalQueryGlobalTipoGastoProduEmpresa,new Pagination());
				tipogastoproduempresasForeignKey=tipogastoproduempresaLogic.getTipoGastoProduEmpresas();
			}

			productoprodugastoReturnGeneral.settipogastoproduempresasForeignKey(tipogastoproduempresasForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			productoprodugastoReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			productoprodugastoReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<Cliente> clienteproveedorsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedorLogic=new ClienteLogic();
			clienteproveedorLogic.setConnexion(this.connexion);
			clienteproveedorLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedor.equals("NONE")) {
				clienteproveedorLogic.getTodosClientes(finalQueryGlobalClienteProveedor,new Pagination());
				clienteproveedorsForeignKey=clienteproveedorLogic.getClientes();
			}

			productoprodugastoReturnGeneral.setclienteproveedorsForeignKey(clienteproveedorsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			productoprodugastoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoprodugastoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoprodugastoReturnGeneral;
	}
	
	
	public void deepLoad(ProductoProduGasto productoprodugasto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoProduGastoLogicAdditional.updateProductoProduGastoToGet(productoprodugasto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodugasto.setProductoDefiProdu(productoprodugastoDataAccess.getProductoDefiProdu(connexion,productoprodugasto));
		productoprodugasto.setTipoGastoProduEmpresa(productoprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoprodugasto));
		productoprodugasto.setCuentaContableDebito(productoprodugastoDataAccess.getCuentaContableDebito(connexion,productoprodugasto));
		productoprodugasto.setCuentaContableCredito(productoprodugastoDataAccess.getCuentaContableCredito(connexion,productoprodugasto));
		productoprodugasto.setClienteProveedor(productoprodugastoDataAccess.getClienteProveedor(connexion,productoprodugasto));
		productoprodugasto.setFactura(productoprodugastoDataAccess.getFactura(connexion,productoprodugasto));
		productoprodugasto.setUnidad(productoprodugastoDataAccess.getUnidad(connexion,productoprodugasto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodugasto.setProductoDefiProdu(productoprodugastoDataAccess.getProductoDefiProdu(connexion,productoprodugasto));
				continue;
			}

			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				productoprodugasto.setTipoGastoProduEmpresa(productoprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoprodugasto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productoprodugasto.setCuentaContableDebito(productoprodugastoDataAccess.getCuentaContableDebito(connexion,productoprodugasto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productoprodugasto.setCuentaContableCredito(productoprodugastoDataAccess.getCuentaContableCredito(connexion,productoprodugasto));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				productoprodugasto.setClienteProveedor(productoprodugastoDataAccess.getClienteProveedor(connexion,productoprodugasto));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				productoprodugasto.setFactura(productoprodugastoDataAccess.getFactura(connexion,productoprodugasto));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodugasto.setUnidad(productoprodugastoDataAccess.getUnidad(connexion,productoprodugasto));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setProductoDefiProdu(productoprodugastoDataAccess.getProductoDefiProdu(connexion,productoprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setTipoGastoProduEmpresa(productoprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setCuentaContableDebito(productoprodugastoDataAccess.getCuentaContableDebito(connexion,productoprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setCuentaContableCredito(productoprodugastoDataAccess.getCuentaContableCredito(connexion,productoprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setClienteProveedor(productoprodugastoDataAccess.getClienteProveedor(connexion,productoprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setFactura(productoprodugastoDataAccess.getFactura(connexion,productoprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setUnidad(productoprodugastoDataAccess.getUnidad(connexion,productoprodugasto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodugasto.setProductoDefiProdu(productoprodugastoDataAccess.getProductoDefiProdu(connexion,productoprodugasto));
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodugasto.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		productoprodugasto.setTipoGastoProduEmpresa(productoprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoprodugasto));
		TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
		tipogastoproduempresaLogic.deepLoad(productoprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);
				
		productoprodugasto.setCuentaContableDebito(productoprodugastoDataAccess.getCuentaContableDebito(connexion,productoprodugasto));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(productoprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		productoprodugasto.setCuentaContableCredito(productoprodugastoDataAccess.getCuentaContableCredito(connexion,productoprodugasto));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(productoprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		productoprodugasto.setClienteProveedor(productoprodugastoDataAccess.getClienteProveedor(connexion,productoprodugasto));
		ClienteLogic clienteproveedorLogic= new ClienteLogic(connexion);
		clienteproveedorLogic.deepLoad(productoprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);
				
		productoprodugasto.setFactura(productoprodugastoDataAccess.getFactura(connexion,productoprodugasto));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(productoprodugasto.getFactura(),isDeep,deepLoadType,clases);
				
		productoprodugasto.setUnidad(productoprodugastoDataAccess.getUnidad(connexion,productoprodugasto));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodugasto.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodugasto.setProductoDefiProdu(productoprodugastoDataAccess.getProductoDefiProdu(connexion,productoprodugasto));
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepLoad(productoprodugasto.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				productoprodugasto.setTipoGastoProduEmpresa(productoprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoprodugasto));
				TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
				tipogastoproduempresaLogic.deepLoad(productoprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productoprodugasto.setCuentaContableDebito(productoprodugastoDataAccess.getCuentaContableDebito(connexion,productoprodugasto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productoprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productoprodugasto.setCuentaContableCredito(productoprodugastoDataAccess.getCuentaContableCredito(connexion,productoprodugasto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productoprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				productoprodugasto.setClienteProveedor(productoprodugastoDataAccess.getClienteProveedor(connexion,productoprodugasto));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(productoprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				productoprodugasto.setFactura(productoprodugastoDataAccess.getFactura(connexion,productoprodugasto));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(productoprodugasto.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodugasto.setUnidad(productoprodugastoDataAccess.getUnidad(connexion,productoprodugasto));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoprodugasto.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setProductoDefiProdu(productoprodugastoDataAccess.getProductoDefiProdu(connexion,productoprodugasto));
			ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
			productodefiproduLogic.deepLoad(productoprodugasto.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setTipoGastoProduEmpresa(productoprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoprodugasto));
			TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
			tipogastoproduempresaLogic.deepLoad(productoprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setCuentaContableDebito(productoprodugastoDataAccess.getCuentaContableDebito(connexion,productoprodugasto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productoprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setCuentaContableCredito(productoprodugastoDataAccess.getCuentaContableCredito(connexion,productoprodugasto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productoprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setClienteProveedor(productoprodugastoDataAccess.getClienteProveedor(connexion,productoprodugasto));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(productoprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setFactura(productoprodugastoDataAccess.getFactura(connexion,productoprodugasto));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(productoprodugasto.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodugasto.setUnidad(productoprodugastoDataAccess.getUnidad(connexion,productoprodugasto));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoprodugasto.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoProduGasto productoprodugasto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoProduGastoLogicAdditional.updateProductoProduGastoToSave(productoprodugasto,this.arrDatoGeneral);
			
ProductoProduGastoDataAccess.save(productoprodugasto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodugasto.getProductoDefiProdu(),connexion);

		TipoGastoProduEmpresaDataAccess.save(productoprodugasto.getTipoGastoProduEmpresa(),connexion);

		CuentaContableDataAccess.save(productoprodugasto.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(productoprodugasto.getCuentaContableCredito(),connexion);

		ClienteDataAccess.save(productoprodugasto.getClienteProveedor(),connexion);

		FacturaDataAccess.save(productoprodugasto.getFactura(),connexion);

		UnidadDataAccess.save(productoprodugasto.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodugasto.getProductoDefiProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				TipoGastoProduEmpresaDataAccess.save(productoprodugasto.getTipoGastoProduEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productoprodugasto.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productoprodugasto.getCuentaContableCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(productoprodugasto.getClienteProveedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(productoprodugasto.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodugasto.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodugasto.getProductoDefiProdu(),connexion);
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodugasto.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				

		TipoGastoProduEmpresaDataAccess.save(productoprodugasto.getTipoGastoProduEmpresa(),connexion);
		TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
		tipogastoproduempresaLogic.deepLoad(productoprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productoprodugasto.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(productoprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productoprodugasto.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(productoprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(productoprodugasto.getClienteProveedor(),connexion);
		ClienteLogic clienteproveedorLogic= new ClienteLogic(connexion);
		clienteproveedorLogic.deepLoad(productoprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(productoprodugasto.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(productoprodugasto.getFactura(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoprodugasto.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodugasto.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodugasto.getProductoDefiProdu(),connexion);
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepSave(productoprodugasto.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				TipoGastoProduEmpresaDataAccess.save(productoprodugasto.getTipoGastoProduEmpresa(),connexion);
				TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
				tipogastoproduempresaLogic.deepSave(productoprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productoprodugasto.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productoprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productoprodugasto.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productoprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(productoprodugasto.getClienteProveedor(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(productoprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(productoprodugasto.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(productoprodugasto.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodugasto.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoprodugasto.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoProduGasto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoprodugasto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(productoprodugasto);
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
			this.deepLoad(this.productoprodugasto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugasto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoProduGasto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoprodugastos!=null) {
				for(ProductoProduGasto productoprodugasto:productoprodugastos) {
					this.deepLoad(productoprodugasto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(productoprodugastos);
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
			if(productoprodugastos!=null) {
				for(ProductoProduGasto productoprodugasto:productoprodugastos) {
					this.deepLoad(productoprodugasto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(productoprodugastos);
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
			this.getNewConnexionToDeep(ProductoProduGasto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoprodugasto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoProduGasto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoprodugastos!=null) {
				for(ProductoProduGasto productoprodugasto:productoprodugastos) {
					this.deepSave(productoprodugasto,isDeep,deepLoadType,clases);
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
			if(productoprodugastos!=null) {
				for(ProductoProduGasto productoprodugasto:productoprodugastos) {
					this.deepSave(productoprodugasto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoProduGastosFK_IdClienteProveedorWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor,ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedor);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduGastosFK_IdClienteProveedor(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor,ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedor);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduGastosFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduGastosFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduGastosFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduGastosFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduGastosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,ProductoProduGastoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduGastosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,ProductoProduGastoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduGastosFK_IdProductoDefiProduWithConnection(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduGastosFK_IdProductoDefiProdu(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduGastosFK_IdTipoGastoProduEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_gasto_produ_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGastoProduEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGastoProduEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_gasto_produ_empresa,ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGastoProduEmpresa);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGastoProduEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduGastosFK_IdTipoGastoProduEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_gasto_produ_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGastoProduEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGastoProduEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_gasto_produ_empresa,ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGastoProduEmpresa);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGastoProduEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduGastosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduGastoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduGastosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduGastoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(this.productoprodugastos);
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
			if(ProductoProduGastoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduGastoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoProduGasto productoprodugasto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoProduGastoConstantesFunciones.ISCONAUDITORIA) {
				if(productoprodugasto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduGastoDataAccess.TABLENAME, productoprodugasto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduGastoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduGastoLogic.registrarAuditoriaDetallesProductoProduGasto(connexion,productoprodugasto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoprodugasto.getIsDeleted()) {
					/*if(!productoprodugasto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoProduGastoDataAccess.TABLENAME, productoprodugasto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoProduGastoLogic.registrarAuditoriaDetallesProductoProduGasto(connexion,productoprodugasto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduGastoDataAccess.TABLENAME, productoprodugasto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoprodugasto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduGastoDataAccess.TABLENAME, productoprodugasto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduGastoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduGastoLogic.registrarAuditoriaDetallesProductoProduGasto(connexion,productoprodugasto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoProduGasto(Connexion connexion,ProductoProduGasto productoprodugasto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getid_producto_defi_produ().equals(productoprodugasto.getProductoProduGastoOriginal().getid_producto_defi_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getid_producto_defi_produ()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getid_producto_defi_produ().toString();
				}
				if(productoprodugasto.getid_producto_defi_produ()!=null)
				{
					strValorNuevo=productoprodugasto.getid_producto_defi_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getid_tipo_gasto_produ_empresa().equals(productoprodugasto.getProductoProduGastoOriginal().getid_tipo_gasto_produ_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getid_tipo_gasto_produ_empresa()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getid_tipo_gasto_produ_empresa().toString();
				}
				if(productoprodugasto.getid_tipo_gasto_produ_empresa()!=null)
				{
					strValorNuevo=productoprodugasto.getid_tipo_gasto_produ_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getid_cuenta_contable_debito().equals(productoprodugasto.getProductoProduGastoOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getid_cuenta_contable_debito().toString();
				}
				if(productoprodugasto.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=productoprodugasto.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getid_cuenta_contable_credito().equals(productoprodugasto.getProductoProduGastoOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getid_cuenta_contable_credito().toString();
				}
				if(productoprodugasto.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=productoprodugasto.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getid_cliente_proveedor().equals(productoprodugasto.getProductoProduGastoOriginal().getid_cliente_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getid_cliente_proveedor()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getid_cliente_proveedor().toString();
				}
				if(productoprodugasto.getid_cliente_proveedor()!=null)
				{
					strValorNuevo=productoprodugasto.getid_cliente_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getid_factura().equals(productoprodugasto.getProductoProduGastoOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getid_factura()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getid_factura().toString();
				}
				if(productoprodugasto.getid_factura()!=null)
				{
					strValorNuevo=productoprodugasto.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getid_unidad().equals(productoprodugasto.getProductoProduGastoOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getid_unidad()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getid_unidad().toString();
				}
				if(productoprodugasto.getid_unidad()!=null)
				{
					strValorNuevo=productoprodugasto.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getcanitdad().equals(productoprodugasto.getProductoProduGastoOriginal().getcanitdad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getcanitdad()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getcanitdad().toString();
				}
				if(productoprodugasto.getcanitdad()!=null)
				{
					strValorNuevo=productoprodugasto.getcanitdad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getcosto().equals(productoprodugasto.getProductoProduGastoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getcosto()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getcosto().toString();
				}
				if(productoprodugasto.getcosto()!=null)
				{
					strValorNuevo=productoprodugasto.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getcosto_total().equals(productoprodugasto.getProductoProduGastoOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getcosto_total()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getcosto_total().toString();
				}
				if(productoprodugasto.getcosto_total()!=null)
				{
					strValorNuevo=productoprodugasto.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoprodugasto.getIsNew()||!productoprodugasto.getdescripcion().equals(productoprodugasto.getProductoProduGastoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodugasto.getProductoProduGastoOriginal().getdescripcion()!=null)
				{
					strValorActual=productoprodugasto.getProductoProduGastoOriginal().getdescripcion();
				}
				if(productoprodugasto.getdescripcion()!=null)
				{
					strValorNuevo=productoprodugasto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduGastoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoProduGastoRelacionesWithConnection(ProductoProduGasto productoprodugasto) throws Exception {

		if(!productoprodugasto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduGastoRelacionesBase(productoprodugasto,true);
		}
	}

	public void saveProductoProduGastoRelaciones(ProductoProduGasto productoprodugasto)throws Exception {

		if(!productoprodugasto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduGastoRelacionesBase(productoprodugasto,false);
		}
	}

	public void saveProductoProduGastoRelacionesBase(ProductoProduGasto productoprodugasto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoProduGasto-saveRelacionesWithConnection");}
	

			this.setProductoProduGasto(productoprodugasto);

			if(ProductoProduGastoLogicAdditional.validarSaveRelaciones(productoprodugasto,this)) {

				ProductoProduGastoLogicAdditional.updateRelacionesToSave(productoprodugasto,this);

				if((productoprodugasto.getIsNew()||productoprodugasto.getIsChanged())&&!productoprodugasto.getIsDeleted()) {
					this.saveProductoProduGasto();
					this.saveProductoProduGastoRelacionesDetalles();

				} else if(productoprodugasto.getIsDeleted()) {
					this.saveProductoProduGastoRelacionesDetalles();
					this.saveProductoProduGasto();
				}

				ProductoProduGastoLogicAdditional.updateRelacionesToSaveAfter(productoprodugasto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveProductoProduGastoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduGastoConstantesFunciones.getClassesForeignKeysOfProductoProduGasto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduGastoConstantesFunciones.getClassesRelationshipsOfProductoProduGasto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

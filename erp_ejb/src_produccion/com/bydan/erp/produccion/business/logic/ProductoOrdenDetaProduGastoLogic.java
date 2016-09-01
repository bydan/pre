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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduGastoConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduGastoParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduGastoParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoOrdenDetaProduGasto;
import com.bydan.erp.produccion.business.logic.ProductoOrdenDetaProduGastoLogicAdditional;
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
public class ProductoOrdenDetaProduGastoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoOrdenDetaProduGastoLogic.class);
	
	protected ProductoOrdenDetaProduGastoDataAccess productoordendetaprodugastoDataAccess; 	
	protected ProductoOrdenDetaProduGasto productoordendetaprodugasto;
	protected List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos;
	protected Object productoordendetaprodugastoObject;	
	protected List<Object> productoordendetaprodugastosObject;
	
	public static ClassValidator<ProductoOrdenDetaProduGasto> productoordendetaprodugastoValidator = new ClassValidator<ProductoOrdenDetaProduGasto>(ProductoOrdenDetaProduGasto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoOrdenDetaProduGastoLogicAdditional productoordendetaprodugastoLogicAdditional=null;
	
	public ProductoOrdenDetaProduGastoLogicAdditional getProductoOrdenDetaProduGastoLogicAdditional() {
		return this.productoordendetaprodugastoLogicAdditional;
	}
	
	public void setProductoOrdenDetaProduGastoLogicAdditional(ProductoOrdenDetaProduGastoLogicAdditional productoordendetaprodugastoLogicAdditional) {
		try {
			this.productoordendetaprodugastoLogicAdditional=productoordendetaprodugastoLogicAdditional;
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
	
	
	
	
	public  ProductoOrdenDetaProduGastoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoordendetaprodugastoDataAccess = new ProductoOrdenDetaProduGastoDataAccess();
			
			this.productoordendetaprodugastos= new ArrayList<ProductoOrdenDetaProduGasto>();
			this.productoordendetaprodugasto= new ProductoOrdenDetaProduGasto();
			
			this.productoordendetaprodugastoObject=new Object();
			this.productoordendetaprodugastosObject=new ArrayList<Object>();
				
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
			
			this.productoordendetaprodugastoDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoOrdenDetaProduGastoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoordendetaprodugastoDataAccess = new ProductoOrdenDetaProduGastoDataAccess();
			this.productoordendetaprodugastos= new ArrayList<ProductoOrdenDetaProduGasto>();
			this.productoordendetaprodugasto= new ProductoOrdenDetaProduGasto();
			this.productoordendetaprodugastoObject=new Object();
			this.productoordendetaprodugastosObject=new ArrayList<Object>();
			
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
			
			this.productoordendetaprodugastoDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoOrdenDetaProduGasto getProductoOrdenDetaProduGasto() throws Exception {	
		ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToGet(productoordendetaprodugasto,this.datosCliente,this.arrDatoGeneral);
		ProductoOrdenDetaProduGastoLogicAdditional.updateProductoOrdenDetaProduGastoToGet(productoordendetaprodugasto,this.arrDatoGeneral);
		
		return productoordendetaprodugasto;
	}
		
	public void setProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto newProductoOrdenDetaProduGasto) {
		this.productoordendetaprodugasto = newProductoOrdenDetaProduGasto;
	}
	
	public ProductoOrdenDetaProduGastoDataAccess getProductoOrdenDetaProduGastoDataAccess() {
		return productoordendetaprodugastoDataAccess;
	}
	
	public void setProductoOrdenDetaProduGastoDataAccess(ProductoOrdenDetaProduGastoDataAccess newproductoordendetaprodugastoDataAccess) {
		this.productoordendetaprodugastoDataAccess = newproductoordendetaprodugastoDataAccess;
	}
	
	public List<ProductoOrdenDetaProduGasto> getProductoOrdenDetaProduGastos() throws Exception {		
		this.quitarProductoOrdenDetaProduGastosNulos();
		
		ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToGets(productoordendetaprodugastos,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoOrdenDetaProduGasto productoordendetaprodugastoLocal: productoordendetaprodugastos ) {
			ProductoOrdenDetaProduGastoLogicAdditional.updateProductoOrdenDetaProduGastoToGet(productoordendetaprodugastoLocal,this.arrDatoGeneral);
		}
		
		return productoordendetaprodugastos;
	}
	
	public void setProductoOrdenDetaProduGastos(List<ProductoOrdenDetaProduGasto> newProductoOrdenDetaProduGastos) {
		this.productoordendetaprodugastos = newProductoOrdenDetaProduGastos;
	}
	
	public Object getProductoOrdenDetaProduGastoObject() {	
		this.productoordendetaprodugastoObject=this.productoordendetaprodugastoDataAccess.getEntityObject();
		return this.productoordendetaprodugastoObject;
	}
		
	public void setProductoOrdenDetaProduGastoObject(Object newProductoOrdenDetaProduGastoObject) {
		this.productoordendetaprodugastoObject = newProductoOrdenDetaProduGastoObject;
	}
	
	public List<Object> getProductoOrdenDetaProduGastosObject() {		
		this.productoordendetaprodugastosObject=this.productoordendetaprodugastoDataAccess.getEntitiesObject();
		return this.productoordendetaprodugastosObject;
	}
		
	public void setProductoOrdenDetaProduGastosObject(List<Object> newProductoOrdenDetaProduGastosObject) {
		this.productoordendetaprodugastosObject = newProductoOrdenDetaProduGastosObject;
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
		
		if(this.productoordendetaprodugastoDataAccess!=null) {
			this.productoordendetaprodugastoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoordendetaprodugastoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoordendetaprodugastoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodugasto=productoordendetaprodugastoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugasto);
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
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		  		  
        try {
			
			productoordendetaprodugasto=productoordendetaprodugastoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugasto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodugasto=productoordendetaprodugastoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugasto);
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
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		  		  
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
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		  		  
        try {
			
			productoordendetaprodugasto=productoordendetaprodugastoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugasto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		  		  
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
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoordendetaprodugastoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoordendetaprodugastoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoordendetaprodugastoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoordendetaprodugastoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoordendetaprodugastoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoordendetaprodugastoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
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
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		  		  
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
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		  		  
        try {			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		  		  
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
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
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
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		  		  
        try {
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
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
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
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
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugasto=productoordendetaprodugastoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugasto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugasto);
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
		productoordendetaprodugasto = new  ProductoOrdenDetaProduGasto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugasto=productoordendetaprodugastoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugasto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugasto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
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
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		  		  
        try {
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoOrdenDetaProduGastosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getTodosProductoOrdenDetaProduGastosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
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
	
	public  void  getTodosProductoOrdenDetaProduGastos(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodugastos = new  ArrayList<ProductoOrdenDetaProduGasto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProduGasto(productoordendetaprodugastos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto productoordendetaprodugasto) throws Exception {
		Boolean estaValidado=false;
		
		if(productoordendetaprodugasto.getIsNew() || productoordendetaprodugasto.getIsChanged()) { 
			this.invalidValues = productoordendetaprodugastoValidator.getInvalidValues(productoordendetaprodugasto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoordendetaprodugasto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoOrdenDetaProduGasto(List<ProductoOrdenDetaProduGasto> ProductoOrdenDetaProduGastos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugastoLocal:productoordendetaprodugastos) {				
			estaValidadoObjeto=this.validarGuardarProductoOrdenDetaProduGasto(productoordendetaprodugastoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoOrdenDetaProduGasto(List<ProductoOrdenDetaProduGasto> ProductoOrdenDetaProduGastos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProduGasto(productoordendetaprodugastos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto ProductoOrdenDetaProduGasto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProduGasto(productoordendetaprodugasto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoOrdenDetaProduGasto productoordendetaprodugasto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoordendetaprodugasto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoOrdenDetaProduGastoConstantesFunciones.getProductoOrdenDetaProduGastoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoordendetaprodugasto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoOrdenDetaProduGastoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoOrdenDetaProduGastoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoOrdenDetaProduGastoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-saveProductoOrdenDetaProduGastoWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToSave(this.productoordendetaprodugasto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduGastoLogicAdditional.updateProductoOrdenDetaProduGastoToSave(this.productoordendetaprodugasto,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodugasto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProduGasto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProduGasto(this.productoordendetaprodugasto)) {
				ProductoOrdenDetaProduGastoDataAccess.save(this.productoordendetaprodugasto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToSaveAfter(this.productoordendetaprodugasto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProduGasto();
			
			connexion.commit();			
			
			if(this.productoordendetaprodugasto.getIsDeleted()) {
				this.productoordendetaprodugasto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoOrdenDetaProduGasto()throws Exception {	
		try {	
			
			ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToSave(this.productoordendetaprodugasto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduGastoLogicAdditional.updateProductoOrdenDetaProduGastoToSave(this.productoordendetaprodugasto,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodugasto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProduGasto(this.productoordendetaprodugasto)) {			
				ProductoOrdenDetaProduGastoDataAccess.save(this.productoordendetaprodugasto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodugasto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToSaveAfter(this.productoordendetaprodugasto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoordendetaprodugasto.getIsDeleted()) {
				this.productoordendetaprodugasto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoOrdenDetaProduGastosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-saveProductoOrdenDetaProduGastosWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToSaves(productoordendetaprodugastos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProduGastos();
			
			Boolean validadoTodosProductoOrdenDetaProduGasto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProduGasto productoordendetaprodugastoLocal:productoordendetaprodugastos) {		
				if(productoordendetaprodugastoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduGastoLogicAdditional.updateProductoOrdenDetaProduGastoToSave(productoordendetaprodugastoLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaprodugastoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProduGasto(productoordendetaprodugastoLocal)) {
					ProductoOrdenDetaProduGastoDataAccess.save(productoordendetaprodugastoLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProduGasto=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProduGasto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToSavesAfter(productoordendetaprodugastos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProduGastos();
			
			connexion.commit();		
			
			this.quitarProductoOrdenDetaProduGastosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoOrdenDetaProduGastos()throws Exception {				
		 try {	
			ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToSaves(productoordendetaprodugastos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoOrdenDetaProduGasto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProduGasto productoordendetaprodugastoLocal:productoordendetaprodugastos) {				
				if(productoordendetaprodugastoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduGastoLogicAdditional.updateProductoOrdenDetaProduGastoToSave(productoordendetaprodugastoLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaprodugastoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProduGasto(productoordendetaprodugastoLocal)) {				
					ProductoOrdenDetaProduGastoDataAccess.save(productoordendetaprodugastoLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProduGasto=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProduGasto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduGastoLogicAdditional.checkProductoOrdenDetaProduGastoToSavesAfter(productoordendetaprodugastos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoOrdenDetaProduGastosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduGastoParameterReturnGeneral procesarAccionProductoOrdenDetaProduGastos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoParameterGeneral)throws Exception {
		 try {	
			ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoReturnGeneral=new ProductoOrdenDetaProduGastoParameterReturnGeneral();
	
			ProductoOrdenDetaProduGastoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodugastos,productoordendetaprodugastoParameterGeneral,productoordendetaprodugastoReturnGeneral);
			
			return productoordendetaprodugastoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduGastoParameterReturnGeneral procesarAccionProductoOrdenDetaProduGastosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-procesarAccionProductoOrdenDetaProduGastosWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoReturnGeneral=new ProductoOrdenDetaProduGastoParameterReturnGeneral();
	
			ProductoOrdenDetaProduGastoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodugastos,productoordendetaprodugastoParameterGeneral,productoordendetaprodugastoReturnGeneral);
			
			this.connexion.commit();
			
			return productoordendetaprodugastoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduGastoParameterReturnGeneral procesarEventosProductoOrdenDetaProduGastos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ProductoOrdenDetaProduGasto productoordendetaprodugasto,ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProduGasto,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoReturnGeneral=new ProductoOrdenDetaProduGastoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaprodugastoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduGastoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodugastos,productoordendetaprodugasto,productoordendetaprodugastoParameterGeneral,productoordendetaprodugastoReturnGeneral,isEsNuevoProductoOrdenDetaProduGasto,clases);
			
			return productoordendetaprodugastoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoOrdenDetaProduGastoParameterReturnGeneral procesarEventosProductoOrdenDetaProduGastosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ProductoOrdenDetaProduGasto productoordendetaprodugasto,ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProduGasto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-procesarEventosProductoOrdenDetaProduGastosWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoReturnGeneral=new ProductoOrdenDetaProduGastoParameterReturnGeneral();
	
			productoordendetaprodugastoReturnGeneral.setProductoOrdenDetaProduGasto(productoordendetaprodugasto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaprodugastoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduGastoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodugastos,productoordendetaprodugasto,productoordendetaprodugastoParameterGeneral,productoordendetaprodugastoReturnGeneral,isEsNuevoProductoOrdenDetaProduGasto,clases);
			
			this.connexion.commit();
			
			return productoordendetaprodugastoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduGastoParameterReturnGeneral procesarImportacionProductoOrdenDetaProduGastosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-procesarImportacionProductoOrdenDetaProduGastosWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduGastoParameterReturnGeneral productoordendetaprodugastoReturnGeneral=new ProductoOrdenDetaProduGastoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoordendetaprodugastos=new ArrayList<ProductoOrdenDetaProduGasto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoordendetaprodugasto=new ProductoOrdenDetaProduGasto();
				
				
				if(conColumnasBase) {this.productoordendetaprodugasto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoordendetaprodugasto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoordendetaprodugasto.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoordendetaprodugasto.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodugasto.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodugasto.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoordendetaprodugastos.add(this.productoordendetaprodugasto);
			}
			
			this.saveProductoOrdenDetaProduGastos();
			
			this.connexion.commit();
			
			productoordendetaprodugastoReturnGeneral.setConRetornoEstaProcesado(true);
			productoordendetaprodugastoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoordendetaprodugastoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoOrdenDetaProduGastosEliminados() throws Exception {				
		
		List<ProductoOrdenDetaProduGasto> productoordendetaprodugastosAux= new ArrayList<ProductoOrdenDetaProduGasto>();
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:productoordendetaprodugastos) {
			if(!productoordendetaprodugasto.getIsDeleted()) {
				productoordendetaprodugastosAux.add(productoordendetaprodugasto);
			}
		}
		
		productoordendetaprodugastos=productoordendetaprodugastosAux;
	}
	
	public void quitarProductoOrdenDetaProduGastosNulos() throws Exception {				
		
		List<ProductoOrdenDetaProduGasto> productoordendetaprodugastosAux= new ArrayList<ProductoOrdenDetaProduGasto>();
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto : this.productoordendetaprodugastos) {
			if(productoordendetaprodugasto==null) {
				productoordendetaprodugastosAux.add(productoordendetaprodugasto);
			}
		}
		
		//this.productoordendetaprodugastos=productoordendetaprodugastosAux;
		
		this.productoordendetaprodugastos.removeAll(productoordendetaprodugastosAux);
	}
	
	public void getSetVersionRowProductoOrdenDetaProduGastoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoordendetaprodugasto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoordendetaprodugasto.getIsDeleted() || (productoordendetaprodugasto.getIsChanged()&&!productoordendetaprodugasto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoordendetaprodugastoDataAccess.getSetVersionRowProductoOrdenDetaProduGasto(connexion,productoordendetaprodugasto.getId());
				
				if(!productoordendetaprodugasto.getVersionRow().equals(timestamp)) {	
					productoordendetaprodugasto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoordendetaprodugasto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoOrdenDetaProduGasto()throws Exception {	
		
		if(productoordendetaprodugasto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoordendetaprodugasto.getIsDeleted() || (productoordendetaprodugasto.getIsChanged()&&!productoordendetaprodugasto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoordendetaprodugastoDataAccess.getSetVersionRowProductoOrdenDetaProduGasto(connexion,productoordendetaprodugasto.getId());
			
			try {							
				if(!productoordendetaprodugasto.getVersionRow().equals(timestamp)) {	
					productoordendetaprodugasto.setVersionRow(timestamp);
				}
				
				productoordendetaprodugasto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoOrdenDetaProduGastosWithConnection()throws Exception {	
		if(productoordendetaprodugastos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoOrdenDetaProduGasto productoordendetaprodugastoAux:productoordendetaprodugastos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoordendetaprodugastoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaprodugastoAux.getIsDeleted() || (productoordendetaprodugastoAux.getIsChanged()&&!productoordendetaprodugastoAux.getIsNew())) {
						
						timestamp=productoordendetaprodugastoDataAccess.getSetVersionRowProductoOrdenDetaProduGasto(connexion,productoordendetaprodugastoAux.getId());
						
						if(!productoordendetaprodugasto.getVersionRow().equals(timestamp)) {	
							productoordendetaprodugastoAux.setVersionRow(timestamp);
						}
								
						productoordendetaprodugastoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoOrdenDetaProduGastos()throws Exception {	
		if(productoordendetaprodugastos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoOrdenDetaProduGasto productoordendetaprodugastoAux:productoordendetaprodugastos) {
					if(productoordendetaprodugastoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaprodugastoAux.getIsDeleted() || (productoordendetaprodugastoAux.getIsChanged()&&!productoordendetaprodugastoAux.getIsNew())) {
						
						timestamp=productoordendetaprodugastoDataAccess.getSetVersionRowProductoOrdenDetaProduGasto(connexion,productoordendetaprodugastoAux.getId());
						
						if(!productoordendetaprodugastoAux.getVersionRow().equals(timestamp)) {	
							productoordendetaprodugastoAux.setVersionRow(timestamp);
						}
						
													
						productoordendetaprodugastoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoOrdenDetaProduGastoParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProduGastoWithConnection(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalTipoGastoProduEmpresa,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalClienteProveedor,String finalQueryGlobalFactura,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduGastoParameterReturnGeneral  productoordendetaprodugastoReturnGeneral =new ProductoOrdenDetaProduGastoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoOrdenDetaProduGastoWithConnection");connexion.begin();
			
			productoordendetaprodugastoReturnGeneral =new ProductoOrdenDetaProduGastoParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaprodugastoReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<TipoGastoProduEmpresa> tipogastoproduempresasForeignKey=new ArrayList<TipoGastoProduEmpresa>();
			TipoGastoProduEmpresaLogic tipogastoproduempresaLogic=new TipoGastoProduEmpresaLogic();
			tipogastoproduempresaLogic.setConnexion(this.connexion);
			tipogastoproduempresaLogic.getTipoGastoProduEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGastoProduEmpresa.equals("NONE")) {
				tipogastoproduempresaLogic.getTodosTipoGastoProduEmpresas(finalQueryGlobalTipoGastoProduEmpresa,new Pagination());
				tipogastoproduempresasForeignKey=tipogastoproduempresaLogic.getTipoGastoProduEmpresas();
			}

			productoordendetaprodugastoReturnGeneral.settipogastoproduempresasForeignKey(tipogastoproduempresasForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			productoordendetaprodugastoReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			productoordendetaprodugastoReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<Cliente> clienteproveedorsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedorLogic=new ClienteLogic();
			clienteproveedorLogic.setConnexion(this.connexion);
			clienteproveedorLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedor.equals("NONE")) {
				clienteproveedorLogic.getTodosClientes(finalQueryGlobalClienteProveedor,new Pagination());
				clienteproveedorsForeignKey=clienteproveedorLogic.getClientes();
			}

			productoordendetaprodugastoReturnGeneral.setclienteproveedorsForeignKey(clienteproveedorsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			productoordendetaprodugastoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaprodugastoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoordendetaprodugastoReturnGeneral;
	}
	
	public ProductoOrdenDetaProduGastoParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProduGasto(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalTipoGastoProduEmpresa,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalClienteProveedor,String finalQueryGlobalFactura,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduGastoParameterReturnGeneral  productoordendetaprodugastoReturnGeneral =new ProductoOrdenDetaProduGastoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoordendetaprodugastoReturnGeneral =new ProductoOrdenDetaProduGastoParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaprodugastoReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<TipoGastoProduEmpresa> tipogastoproduempresasForeignKey=new ArrayList<TipoGastoProduEmpresa>();
			TipoGastoProduEmpresaLogic tipogastoproduempresaLogic=new TipoGastoProduEmpresaLogic();
			tipogastoproduempresaLogic.setConnexion(this.connexion);
			tipogastoproduempresaLogic.getTipoGastoProduEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGastoProduEmpresa.equals("NONE")) {
				tipogastoproduempresaLogic.getTodosTipoGastoProduEmpresas(finalQueryGlobalTipoGastoProduEmpresa,new Pagination());
				tipogastoproduempresasForeignKey=tipogastoproduempresaLogic.getTipoGastoProduEmpresas();
			}

			productoordendetaprodugastoReturnGeneral.settipogastoproduempresasForeignKey(tipogastoproduempresasForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			productoordendetaprodugastoReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			productoordendetaprodugastoReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<Cliente> clienteproveedorsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedorLogic=new ClienteLogic();
			clienteproveedorLogic.setConnexion(this.connexion);
			clienteproveedorLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedor.equals("NONE")) {
				clienteproveedorLogic.getTodosClientes(finalQueryGlobalClienteProveedor,new Pagination());
				clienteproveedorsForeignKey=clienteproveedorLogic.getClientes();
			}

			productoordendetaprodugastoReturnGeneral.setclienteproveedorsForeignKey(clienteproveedorsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			productoordendetaprodugastoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaprodugastoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoordendetaprodugastoReturnGeneral;
	}
	
	
	public void deepLoad(ProductoOrdenDetaProduGasto productoordendetaprodugasto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoOrdenDetaProduGastoLogicAdditional.updateProductoOrdenDetaProduGastoToGet(productoordendetaprodugasto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodugasto.setOrdenDetaProdu(productoordendetaprodugastoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodugasto));
		productoordendetaprodugasto.setTipoGastoProduEmpresa(productoordendetaprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoordendetaprodugasto));
		productoordendetaprodugasto.setCuentaContableDebito(productoordendetaprodugastoDataAccess.getCuentaContableDebito(connexion,productoordendetaprodugasto));
		productoordendetaprodugasto.setCuentaContableCredito(productoordendetaprodugastoDataAccess.getCuentaContableCredito(connexion,productoordendetaprodugasto));
		productoordendetaprodugasto.setClienteProveedor(productoordendetaprodugastoDataAccess.getClienteProveedor(connexion,productoordendetaprodugasto));
		productoordendetaprodugasto.setFactura(productoordendetaprodugastoDataAccess.getFactura(connexion,productoordendetaprodugasto));
		productoordendetaprodugasto.setUnidad(productoordendetaprodugastoDataAccess.getUnidad(connexion,productoordendetaprodugasto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodugasto.setOrdenDetaProdu(productoordendetaprodugastoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodugasto));
				continue;
			}

			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				productoordendetaprodugasto.setTipoGastoProduEmpresa(productoordendetaprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoordendetaprodugasto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productoordendetaprodugasto.setCuentaContableDebito(productoordendetaprodugastoDataAccess.getCuentaContableDebito(connexion,productoordendetaprodugasto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productoordendetaprodugasto.setCuentaContableCredito(productoordendetaprodugastoDataAccess.getCuentaContableCredito(connexion,productoordendetaprodugasto));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				productoordendetaprodugasto.setClienteProveedor(productoordendetaprodugastoDataAccess.getClienteProveedor(connexion,productoordendetaprodugasto));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				productoordendetaprodugasto.setFactura(productoordendetaprodugastoDataAccess.getFactura(connexion,productoordendetaprodugasto));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodugasto.setUnidad(productoordendetaprodugastoDataAccess.getUnidad(connexion,productoordendetaprodugasto));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setOrdenDetaProdu(productoordendetaprodugastoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setTipoGastoProduEmpresa(productoordendetaprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoordendetaprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setCuentaContableDebito(productoordendetaprodugastoDataAccess.getCuentaContableDebito(connexion,productoordendetaprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setCuentaContableCredito(productoordendetaprodugastoDataAccess.getCuentaContableCredito(connexion,productoordendetaprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setClienteProveedor(productoordendetaprodugastoDataAccess.getClienteProveedor(connexion,productoordendetaprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setFactura(productoordendetaprodugastoDataAccess.getFactura(connexion,productoordendetaprodugasto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setUnidad(productoordendetaprodugastoDataAccess.getUnidad(connexion,productoordendetaprodugasto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodugasto.setOrdenDetaProdu(productoordendetaprodugastoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodugasto));
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodugasto.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		productoordendetaprodugasto.setTipoGastoProduEmpresa(productoordendetaprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoordendetaprodugasto));
		TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
		tipogastoproduempresaLogic.deepLoad(productoordendetaprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);
				
		productoordendetaprodugasto.setCuentaContableDebito(productoordendetaprodugastoDataAccess.getCuentaContableDebito(connexion,productoordendetaprodugasto));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(productoordendetaprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		productoordendetaprodugasto.setCuentaContableCredito(productoordendetaprodugastoDataAccess.getCuentaContableCredito(connexion,productoordendetaprodugasto));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(productoordendetaprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		productoordendetaprodugasto.setClienteProveedor(productoordendetaprodugastoDataAccess.getClienteProveedor(connexion,productoordendetaprodugasto));
		ClienteLogic clienteproveedorLogic= new ClienteLogic(connexion);
		clienteproveedorLogic.deepLoad(productoordendetaprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);
				
		productoordendetaprodugasto.setFactura(productoordendetaprodugastoDataAccess.getFactura(connexion,productoordendetaprodugasto));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(productoordendetaprodugasto.getFactura(),isDeep,deepLoadType,clases);
				
		productoordendetaprodugasto.setUnidad(productoordendetaprodugastoDataAccess.getUnidad(connexion,productoordendetaprodugasto));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodugasto.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodugasto.setOrdenDetaProdu(productoordendetaprodugastoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodugasto));
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepLoad(productoordendetaprodugasto.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				productoordendetaprodugasto.setTipoGastoProduEmpresa(productoordendetaprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoordendetaprodugasto));
				TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
				tipogastoproduempresaLogic.deepLoad(productoordendetaprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productoordendetaprodugasto.setCuentaContableDebito(productoordendetaprodugastoDataAccess.getCuentaContableDebito(connexion,productoordendetaprodugasto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productoordendetaprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productoordendetaprodugasto.setCuentaContableCredito(productoordendetaprodugastoDataAccess.getCuentaContableCredito(connexion,productoordendetaprodugasto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productoordendetaprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				productoordendetaprodugasto.setClienteProveedor(productoordendetaprodugastoDataAccess.getClienteProveedor(connexion,productoordendetaprodugasto));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(productoordendetaprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				productoordendetaprodugasto.setFactura(productoordendetaprodugastoDataAccess.getFactura(connexion,productoordendetaprodugasto));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(productoordendetaprodugasto.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodugasto.setUnidad(productoordendetaprodugastoDataAccess.getUnidad(connexion,productoordendetaprodugasto));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoordendetaprodugasto.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setOrdenDetaProdu(productoordendetaprodugastoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodugasto));
			OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
			ordendetaproduLogic.deepLoad(productoordendetaprodugasto.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setTipoGastoProduEmpresa(productoordendetaprodugastoDataAccess.getTipoGastoProduEmpresa(connexion,productoordendetaprodugasto));
			TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
			tipogastoproduempresaLogic.deepLoad(productoordendetaprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setCuentaContableDebito(productoordendetaprodugastoDataAccess.getCuentaContableDebito(connexion,productoordendetaprodugasto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productoordendetaprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setCuentaContableCredito(productoordendetaprodugastoDataAccess.getCuentaContableCredito(connexion,productoordendetaprodugasto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productoordendetaprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setClienteProveedor(productoordendetaprodugastoDataAccess.getClienteProveedor(connexion,productoordendetaprodugasto));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(productoordendetaprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setFactura(productoordendetaprodugastoDataAccess.getFactura(connexion,productoordendetaprodugasto));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(productoordendetaprodugasto.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodugasto.setUnidad(productoordendetaprodugastoDataAccess.getUnidad(connexion,productoordendetaprodugasto));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoordendetaprodugasto.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoOrdenDetaProduGasto productoordendetaprodugasto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoOrdenDetaProduGastoLogicAdditional.updateProductoOrdenDetaProduGastoToSave(productoordendetaprodugasto,this.arrDatoGeneral);
			
ProductoOrdenDetaProduGastoDataAccess.save(productoordendetaprodugasto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodugasto.getOrdenDetaProdu(),connexion);

		TipoGastoProduEmpresaDataAccess.save(productoordendetaprodugasto.getTipoGastoProduEmpresa(),connexion);

		CuentaContableDataAccess.save(productoordendetaprodugasto.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(productoordendetaprodugasto.getCuentaContableCredito(),connexion);

		ClienteDataAccess.save(productoordendetaprodugasto.getClienteProveedor(),connexion);

		FacturaDataAccess.save(productoordendetaprodugasto.getFactura(),connexion);

		UnidadDataAccess.save(productoordendetaprodugasto.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodugasto.getOrdenDetaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				TipoGastoProduEmpresaDataAccess.save(productoordendetaprodugasto.getTipoGastoProduEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productoordendetaprodugasto.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productoordendetaprodugasto.getCuentaContableCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(productoordendetaprodugasto.getClienteProveedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(productoordendetaprodugasto.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodugasto.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodugasto.getOrdenDetaProdu(),connexion);
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodugasto.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				

		TipoGastoProduEmpresaDataAccess.save(productoordendetaprodugasto.getTipoGastoProduEmpresa(),connexion);
		TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
		tipogastoproduempresaLogic.deepLoad(productoordendetaprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productoordendetaprodugasto.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(productoordendetaprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productoordendetaprodugasto.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(productoordendetaprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(productoordendetaprodugasto.getClienteProveedor(),connexion);
		ClienteLogic clienteproveedorLogic= new ClienteLogic(connexion);
		clienteproveedorLogic.deepLoad(productoordendetaprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(productoordendetaprodugasto.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(productoordendetaprodugasto.getFactura(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoordendetaprodugasto.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodugasto.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodugasto.getOrdenDetaProdu(),connexion);
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepSave(productoordendetaprodugasto.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGastoProduEmpresa.class)) {
				TipoGastoProduEmpresaDataAccess.save(productoordendetaprodugasto.getTipoGastoProduEmpresa(),connexion);
				TipoGastoProduEmpresaLogic tipogastoproduempresaLogic= new TipoGastoProduEmpresaLogic(connexion);
				tipogastoproduempresaLogic.deepSave(productoordendetaprodugasto.getTipoGastoProduEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productoordendetaprodugasto.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productoordendetaprodugasto.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productoordendetaprodugasto.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productoordendetaprodugasto.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(productoordendetaprodugasto.getClienteProveedor(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(productoordendetaprodugasto.getClienteProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(productoordendetaprodugasto.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(productoordendetaprodugasto.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodugasto.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoordendetaprodugasto.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduGasto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoordendetaprodugasto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(productoordendetaprodugasto);
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
			this.deepLoad(this.productoordendetaprodugasto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugasto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoOrdenDetaProduGasto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoordendetaprodugastos!=null) {
				for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:productoordendetaprodugastos) {
					this.deepLoad(productoordendetaprodugasto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(productoordendetaprodugastos);
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
			if(productoordendetaprodugastos!=null) {
				for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:productoordendetaprodugastos) {
					this.deepLoad(productoordendetaprodugasto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(productoordendetaprodugastos);
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduGasto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoordendetaprodugasto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduGasto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoordendetaprodugastos!=null) {
				for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:productoordendetaprodugastos) {
					this.deepSave(productoordendetaprodugasto,isDeep,deepLoadType,clases);
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
			if(productoordendetaprodugastos!=null) {
				for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:productoordendetaprodugastos) {
					this.deepSave(productoordendetaprodugasto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoOrdenDetaProduGastosFK_IdClienteProveedorWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor,ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedor);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdClienteProveedor(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor,ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedor);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdOrdenDetaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdOrdenDetaProdu(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdTipoGastoProduEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_gasto_produ_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGastoProduEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGastoProduEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_gasto_produ_empresa,ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGastoProduEmpresa);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGastoProduEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdTipoGastoProduEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_gasto_produ_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGastoProduEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGastoProduEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_gasto_produ_empresa,ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGastoProduEmpresa);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGastoProduEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduGasto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduGastosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduGastoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(this.productoordendetaprodugastos);
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
			if(ProductoOrdenDetaProduGastoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduGastoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoOrdenDetaProduGasto productoordendetaprodugasto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoOrdenDetaProduGastoConstantesFunciones.ISCONAUDITORIA) {
				if(productoordendetaprodugasto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduGastoDataAccess.TABLENAME, productoordendetaprodugasto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduGastoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduGastoLogic.registrarAuditoriaDetallesProductoOrdenDetaProduGasto(connexion,productoordendetaprodugasto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoordendetaprodugasto.getIsDeleted()) {
					/*if(!productoordendetaprodugasto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoOrdenDetaProduGastoDataAccess.TABLENAME, productoordendetaprodugasto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoOrdenDetaProduGastoLogic.registrarAuditoriaDetallesProductoOrdenDetaProduGasto(connexion,productoordendetaprodugasto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduGastoDataAccess.TABLENAME, productoordendetaprodugasto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoordendetaprodugasto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduGastoDataAccess.TABLENAME, productoordendetaprodugasto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduGastoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduGastoLogic.registrarAuditoriaDetallesProductoOrdenDetaProduGasto(connexion,productoordendetaprodugasto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoOrdenDetaProduGasto(Connexion connexion,ProductoOrdenDetaProduGasto productoordendetaprodugasto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getid_orden_deta_produ().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_orden_deta_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_orden_deta_produ()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_orden_deta_produ().toString();
				}
				if(productoordendetaprodugasto.getid_orden_deta_produ()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getid_orden_deta_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getid_tipo_gasto_produ_empresa().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_tipo_gasto_produ_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_tipo_gasto_produ_empresa()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_tipo_gasto_produ_empresa().toString();
				}
				if(productoordendetaprodugasto.getid_tipo_gasto_produ_empresa()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getid_tipo_gasto_produ_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getid_cuenta_contable_debito().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_cuenta_contable_debito().toString();
				}
				if(productoordendetaprodugasto.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getid_cuenta_contable_credito().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_cuenta_contable_credito().toString();
				}
				if(productoordendetaprodugasto.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getid_cliente_proveedor().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_cliente_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_cliente_proveedor()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_cliente_proveedor().toString();
				}
				if(productoordendetaprodugasto.getid_cliente_proveedor()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getid_cliente_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getid_factura().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_factura()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_factura().toString();
				}
				if(productoordendetaprodugasto.getid_factura()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getid_unidad().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_unidad()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getid_unidad().toString();
				}
				if(productoordendetaprodugasto.getid_unidad()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getcantidad().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getcantidad()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getcantidad().toString();
				}
				if(productoordendetaprodugasto.getcantidad()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getcosto().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getcosto()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getcosto().toString();
				}
				if(productoordendetaprodugasto.getcosto()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getcosto_total().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getcosto_total()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getcosto_total().toString();
				}
				if(productoordendetaprodugasto.getcosto_total()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodugasto.getIsNew()||!productoordendetaprodugasto.getdescripcion().equals(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getdescripcion()!=null)
				{
					strValorActual=productoordendetaprodugasto.getProductoOrdenDetaProduGastoOriginal().getdescripcion();
				}
				if(productoordendetaprodugasto.getdescripcion()!=null)
				{
					strValorNuevo=productoordendetaprodugasto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoOrdenDetaProduGastoRelacionesWithConnection(ProductoOrdenDetaProduGasto productoordendetaprodugasto) throws Exception {

		if(!productoordendetaprodugasto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduGastoRelacionesBase(productoordendetaprodugasto,true);
		}
	}

	public void saveProductoOrdenDetaProduGastoRelaciones(ProductoOrdenDetaProduGasto productoordendetaprodugasto)throws Exception {

		if(!productoordendetaprodugasto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduGastoRelacionesBase(productoordendetaprodugasto,false);
		}
	}

	public void saveProductoOrdenDetaProduGastoRelacionesBase(ProductoOrdenDetaProduGasto productoordendetaprodugasto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoOrdenDetaProduGasto-saveRelacionesWithConnection");}
	

			this.setProductoOrdenDetaProduGasto(productoordendetaprodugasto);

			if(ProductoOrdenDetaProduGastoLogicAdditional.validarSaveRelaciones(productoordendetaprodugasto,this)) {

				ProductoOrdenDetaProduGastoLogicAdditional.updateRelacionesToSave(productoordendetaprodugasto,this);

				if((productoordendetaprodugasto.getIsNew()||productoordendetaprodugasto.getIsChanged())&&!productoordendetaprodugasto.getIsDeleted()) {
					this.saveProductoOrdenDetaProduGasto();
					this.saveProductoOrdenDetaProduGastoRelacionesDetalles();

				} else if(productoordendetaprodugasto.getIsDeleted()) {
					this.saveProductoOrdenDetaProduGastoRelacionesDetalles();
					this.saveProductoOrdenDetaProduGasto();
				}

				ProductoOrdenDetaProduGastoLogicAdditional.updateRelacionesToSaveAfter(productoordendetaprodugasto,this);

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
	
	
	private void saveProductoOrdenDetaProduGastoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduGastoConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduGasto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduGastoConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProduGasto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

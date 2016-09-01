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
import com.bydan.erp.inventario.util.ProductoConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.Producto;
import com.bydan.erp.inventario.business.logic.ProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoLogic.class);
	
	protected ProductoDataAccess productoDataAccess; 	
	protected Producto producto;
	protected List<Producto> productos;
	protected Object productoObject;	
	protected List<Object> productosObject;
	
	public static ClassValidator<Producto> productoValidator = new ClassValidator<Producto>(Producto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoLogicAdditional productoLogicAdditional=null;
	
	public ProductoLogicAdditional getProductoLogicAdditional() {
		return this.productoLogicAdditional;
	}
	
	public void setProductoLogicAdditional(ProductoLogicAdditional productoLogicAdditional) {
		try {
			this.productoLogicAdditional=productoLogicAdditional;
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
	
	
	
	
	public  ProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoDataAccess = new ProductoDataAccess();
			
			//SE QUITA INICIALIZACION INICIAL, RAPIDEZ PANTALLA
			
			this.productoObject=new Object();
			this.productosObject=new ArrayList<Object>();
				
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
			
			this.productoDataAccess.setConnexionType(this.connexionType);
			this.productoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoDataAccess = new ProductoDataAccess();
			this.productos= new ArrayList<Producto>();
			this.producto= new Producto();
			this.productoObject=new Object();
			this.productosObject=new ArrayList<Object>();
			
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
			
			this.productoDataAccess.setConnexionType(this.connexionType);
			this.productoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Producto getProducto() throws Exception {	
		ProductoLogicAdditional.checkProductoToGet(producto,this.datosCliente,this.arrDatoGeneral);
		ProductoLogicAdditional.updateProductoToGet(producto,this.arrDatoGeneral);
		
		return producto;
	}
		
	public void setProducto(Producto newProducto) {
		this.producto = newProducto;
	}
	
	public ProductoDataAccess getProductoDataAccess() {
		return productoDataAccess;
	}
	
	public void setProductoDataAccess(ProductoDataAccess newproductoDataAccess) {
		this.productoDataAccess = newproductoDataAccess;
	}
	
	public List<Producto> getProductos() throws Exception {		
		this.quitarProductosNulos();
		
		ProductoLogicAdditional.checkProductoToGets(productos,this.datosCliente,this.arrDatoGeneral);
		
		for (Producto productoLocal: productos ) {
			ProductoLogicAdditional.updateProductoToGet(productoLocal,this.arrDatoGeneral);
		}
		
		return productos;
	}
	
	public void setProductos(List<Producto> newProductos) {
		this.productos = newProductos;
	}
	
	public Object getProductoObject() {	
		this.productoObject=this.productoDataAccess.getEntityObject();
		return this.productoObject;
	}
		
	public void setProductoObject(Object newProductoObject) {
		this.productoObject = newProductoObject;
	}
	
	public List<Object> getProductosObject() {		
		this.productosObject=this.productoDataAccess.getEntitiesObject();
		return this.productosObject;
	}
		
	public void setProductosObject(List<Object> newProductosObject) {
		this.productosObject = newProductosObject;
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
		
		if(this.productoDataAccess!=null) {
			this.productoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		producto = new  Producto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			producto=productoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.producto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.producto);
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
		producto = new  Producto();
		  		  
        try {
			
			producto=productoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.producto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.producto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		producto = new  Producto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			producto=productoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.producto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.producto);
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
		producto = new  Producto();
		  		  
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
		producto = new  Producto();
		  		  
        try {
			
			producto=productoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.producto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.producto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		producto = new  Producto();
		  		  
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
		producto = new  Producto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		producto = new  Producto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		producto = new  Producto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		producto = new  Producto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		producto = new  Producto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		producto = new  Producto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productos = new  ArrayList<Producto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
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
		productos = new  ArrayList<Producto>();
		  		  
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
		productos = new  ArrayList<Producto>();
		  		  
        try {			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productos = new  ArrayList<Producto>();
		  		  
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
		productos = new  ArrayList<Producto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
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
		productos = new  ArrayList<Producto>();
		  		  
        try {
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
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
		productos = new  ArrayList<Producto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
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
		productos = new  ArrayList<Producto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		producto = new  Producto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			producto=productoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProducto(producto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.producto);
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
		producto = new  Producto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			producto=productoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProducto(producto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.producto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productos = new  ArrayList<Producto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
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
		productos = new  ArrayList<Producto>();
		  		  
        try {
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productos = new  ArrayList<Producto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getTodosProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
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
	
	public  void  getTodosProductos(String sFinalQuery,Pagination pagination)throws Exception {
		productos = new  ArrayList<Producto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProducto(productos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProducto(Producto producto) throws Exception {
		Boolean estaValidado=false;
		
		if(producto.getIsNew() || producto.getIsChanged()) { 
			this.invalidValues = productoValidator.getInvalidValues(producto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(producto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProducto(List<Producto> Productos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Producto productoLocal:productos) {				
			estaValidadoObjeto=this.validarGuardarProducto(productoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProducto(List<Producto> Productos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProducto(productos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProducto(Producto Producto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProducto(producto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Producto producto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+producto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoConstantesFunciones.getProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"producto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-saveProductoWithConnection");connexion.begin();			
			
			ProductoLogicAdditional.checkProductoToSave(this.producto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoLogicAdditional.updateProductoToSave(this.producto,this.arrDatoGeneral);
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.producto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProducto(this.producto)) {
				ProductoDataAccess.save(this.producto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.producto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoLogicAdditional.checkProductoToSaveAfter(this.producto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProducto();
			
			connexion.commit();			
			
			if(this.producto.getIsDeleted()) {
				this.producto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProducto()throws Exception {	
		try {	
			
			ProductoLogicAdditional.checkProductoToSave(this.producto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoLogicAdditional.updateProductoToSave(this.producto,this.arrDatoGeneral);
			
			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.producto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProducto(this.producto)) {			
				ProductoDataAccess.save(this.producto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.producto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoLogicAdditional.checkProductoToSaveAfter(this.producto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.producto.getIsDeleted()) {
				this.producto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-saveProductosWithConnection");connexion.begin();			
			
			ProductoLogicAdditional.checkProductoToSaves(productos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductos();
			
			Boolean validadoTodosProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Producto productoLocal:productos) {		
				if(productoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoLogicAdditional.updateProductoToSave(productoLocal,this.arrDatoGeneral);
	        	
				ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProducto(productoLocal)) {
					ProductoDataAccess.save(productoLocal, connexion);				
				} else {
					validadoTodosProducto=false;
				}
			}
			
			if(!validadoTodosProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoLogicAdditional.checkProductoToSavesAfter(productos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductos();
			
			connexion.commit();		
			
			this.quitarProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductos()throws Exception {				
		 try {	
			ProductoLogicAdditional.checkProductoToSaves(productos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Producto productoLocal:productos) {				
				if(productoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoLogicAdditional.updateProductoToSave(productoLocal,this.arrDatoGeneral);
	        	
				ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProducto(productoLocal)) {				
					ProductoDataAccess.save(productoLocal, connexion);				
				} else {
					validadoTodosProducto=false;
				}
			}
			
			if(!validadoTodosProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoLogicAdditional.checkProductoToSavesAfter(productos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoParameterReturnGeneral procesarAccionProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Producto> productos,ProductoParameterReturnGeneral productoParameterGeneral)throws Exception {
		 try {	
			ProductoParameterReturnGeneral productoReturnGeneral=new ProductoParameterReturnGeneral();
	
			ProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productos,productoParameterGeneral,productoReturnGeneral);
			
			return productoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoParameterReturnGeneral procesarAccionProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Producto> productos,ProductoParameterReturnGeneral productoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-procesarAccionProductosWithConnection");connexion.begin();			
			
			ProductoParameterReturnGeneral productoReturnGeneral=new ProductoParameterReturnGeneral();
	
			ProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productos,productoParameterGeneral,productoReturnGeneral);
			
			this.connexion.commit();
			
			return productoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoParameterReturnGeneral procesarEventosProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Producto> productos,Producto producto,ProductoParameterReturnGeneral productoParameterGeneral,Boolean isEsNuevoProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoParameterReturnGeneral productoReturnGeneral=new ProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productos,producto,productoParameterGeneral,productoReturnGeneral,isEsNuevoProducto,clases);
			
			return productoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoParameterReturnGeneral procesarEventosProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Producto> productos,Producto producto,ProductoParameterReturnGeneral productoParameterGeneral,Boolean isEsNuevoProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-procesarEventosProductosWithConnection");connexion.begin();			
			
			ProductoParameterReturnGeneral productoReturnGeneral=new ProductoParameterReturnGeneral();
	
			productoReturnGeneral.setProducto(producto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productos,producto,productoParameterGeneral,productoReturnGeneral,isEsNuevoProducto,clases);
			
			this.connexion.commit();
			
			return productoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoParameterReturnGeneral procesarImportacionProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoParameterReturnGeneral productoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-procesarImportacionProductosWithConnection");connexion.begin();			
			
			ProductoParameterReturnGeneral productoReturnGeneral=new ProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productos=new ArrayList<Producto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.producto=new Producto();
				
				
				if(conColumnasBase) {this.producto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.producto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.producto.setcodigo(arrColumnas[iColumn++]);
				this.producto.setnombre(arrColumnas[iColumn++]);
				this.producto.setnombre_extranjero(arrColumnas[iColumn++]);
			this.producto.setresumen_detalle(arrColumnas[iColumn++]);
				this.producto.setcodigo_barra(arrColumnas[iColumn++]);
				this.producto.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.producto.setdescripcion(arrColumnas[iColumn++]);
				this.producto.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setiva_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setice_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setarancel_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setarancel_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setcomision(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setcomision_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setdias_produccion(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setcon_stock_negativo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setcon_precio_minimo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setcon_lote(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setcon_confirmacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setcon_presupuesto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setcon_importacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setcon_final(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setcon_consep(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setcon_serie(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setcon_balanza(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.producto.setalto(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setancho(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setlargo(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setvolumen(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setpeso(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setgramos(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setunidades_caja(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setmargen(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setfactor(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setfob(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setfob2(Double.parseDouble(arrColumnas[iColumn++]));
				this.producto.setgrupo(arrColumnas[iColumn++]);
				this.producto.setreferencia(arrColumnas[iColumn++]);
				this.producto.setaplicacion(arrColumnas[iColumn++]);
				this.producto.setprocedencia(arrColumnas[iColumn++]);
				
				this.productos.add(this.producto);
			}
			
			this.saveProductos();
			
			this.connexion.commit();
			
			productoReturnGeneral.setConRetornoEstaProcesado(true);
			productoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductosEliminados() throws Exception {				
		
		List<Producto> productosAux= new ArrayList<Producto>();
		
		for(Producto producto:productos) {
			if(!producto.getIsDeleted()) {
				productosAux.add(producto);
			}
		}
		
		productos=productosAux;
	}
	
	public void quitarProductosNulos() throws Exception {				
		
		List<Producto> productosAux= new ArrayList<Producto>();
		
		for(Producto producto : this.productos) {
			if(producto==null) {
				productosAux.add(producto);
			}
		}
		
		//this.productos=productosAux;
		
		this.productos.removeAll(productosAux);
	}
	
	public void getSetVersionRowProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(producto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((producto.getIsDeleted() || (producto.getIsChanged()&&!producto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoDataAccess.getSetVersionRowProducto(connexion,producto.getId());
				
				if(!producto.getVersionRow().equals(timestamp)) {	
					producto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				producto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProducto()throws Exception {	
		
		if(producto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((producto.getIsDeleted() || (producto.getIsChanged()&&!producto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoDataAccess.getSetVersionRowProducto(connexion,producto.getId());
			
			try {							
				if(!producto.getVersionRow().equals(timestamp)) {	
					producto.setVersionRow(timestamp);
				}
				
				producto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductosWithConnection()throws Exception {	
		if(productos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Producto productoAux:productos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoAux.getIsDeleted() || (productoAux.getIsChanged()&&!productoAux.getIsNew())) {
						
						timestamp=productoDataAccess.getSetVersionRowProducto(connexion,productoAux.getId());
						
						if(!producto.getVersionRow().equals(timestamp)) {	
							productoAux.setVersionRow(timestamp);
						}
								
						productoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductos()throws Exception {	
		if(productos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Producto productoAux:productos) {
					if(productoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoAux.getIsDeleted() || (productoAux.getIsChanged()&&!productoAux.getIsNew())) {
						
						timestamp=productoDataAccess.getSetVersionRowProducto(connexion,productoAux.getId());
						
						if(!productoAux.getVersionRow().equals(timestamp)) {	
							productoAux.setVersionRow(timestamp);
						}
						
													
						productoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoParameterReturnGeneral cargarCombosLoteForeignKeyProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca,String finalQueryGlobalTipoProductoServicio,String finalQueryGlobalTipoProductoServicioInven,String finalQueryGlobalTipoCosteo,String finalQueryGlobalUnidad,String finalQueryGlobalUnidadPeso,String finalQueryGlobalArancel,String finalQueryGlobalCliente,String finalQueryGlobalClienteProveedorDefecto,String finalQueryGlobalTipoProducto,String finalQueryGlobalColorProducto,String finalQueryGlobalClaseProducto,String finalQueryGlobalEfectoProducto,String finalQueryGlobalMarcaProducto,String finalQueryGlobalModeloProducto,String finalQueryGlobalMaterialProducto,String finalQueryGlobalSegmentoProducto,String finalQueryGlobalTallaProducto) throws Exception {
		ProductoParameterReturnGeneral  productoReturnGeneral =new ProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoWithConnection");connexion.begin();
			
			productoReturnGeneral =new ProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			productoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			productoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			productoReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			productoReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);


			List<TipoProductoServicio> tipoproductoserviciosForeignKey=new ArrayList<TipoProductoServicio>();
			TipoProductoServicioLogic tipoproductoservicioLogic=new TipoProductoServicioLogic();
			tipoproductoservicioLogic.setConnexion(this.connexion);
			tipoproductoservicioLogic.getTipoProductoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicio.equals("NONE")) {
				tipoproductoservicioLogic.getTodosTipoProductoServicios(finalQueryGlobalTipoProductoServicio,new Pagination());
				tipoproductoserviciosForeignKey=tipoproductoservicioLogic.getTipoProductoServicios();
			}

			productoReturnGeneral.settipoproductoserviciosForeignKey(tipoproductoserviciosForeignKey);


			List<TipoProductoServicioInven> tipoproductoservicioinvensForeignKey=new ArrayList<TipoProductoServicioInven>();
			TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic=new TipoProductoServicioInvenLogic();
			tipoproductoservicioinvenLogic.setConnexion(this.connexion);
			tipoproductoservicioinvenLogic.getTipoProductoServicioInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicioInven.equals("NONE")) {
				tipoproductoservicioinvenLogic.getTodosTipoProductoServicioInvens(finalQueryGlobalTipoProductoServicioInven,new Pagination());
				tipoproductoservicioinvensForeignKey=tipoproductoservicioinvenLogic.getTipoProductoServicioInvens();
			}

			productoReturnGeneral.settipoproductoservicioinvensForeignKey(tipoproductoservicioinvensForeignKey);


			List<TipoCosteo> tipocosteosForeignKey=new ArrayList<TipoCosteo>();
			TipoCosteoLogic tipocosteoLogic=new TipoCosteoLogic();
			tipocosteoLogic.setConnexion(this.connexion);
			tipocosteoLogic.getTipoCosteoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCosteo.equals("NONE")) {
				tipocosteoLogic.getTodosTipoCosteos(finalQueryGlobalTipoCosteo,new Pagination());
				tipocosteosForeignKey=tipocosteoLogic.getTipoCosteos();
			}

			productoReturnGeneral.settipocosteosForeignKey(tipocosteosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Unidad> unidadpesosForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadpesoLogic=new UnidadLogic();
			unidadpesoLogic.setConnexion(this.connexion);
			unidadpesoLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidadPeso.equals("NONE")) {
				unidadpesoLogic.getTodosUnidads(finalQueryGlobalUnidadPeso,new Pagination());
				unidadpesosForeignKey=unidadpesoLogic.getUnidads();
			}

			productoReturnGeneral.setunidadpesosForeignKey(unidadpesosForeignKey);


			List<Arancel> arancelsForeignKey=new ArrayList<Arancel>();
			ArancelLogic arancelLogic=new ArancelLogic();
			arancelLogic.setConnexion(this.connexion);
			arancelLogic.getArancelDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalArancel.equals("NONE")) {
				arancelLogic.getTodosArancels(finalQueryGlobalArancel,new Pagination());
				arancelsForeignKey=arancelLogic.getArancels();
			}

			productoReturnGeneral.setarancelsForeignKey(arancelsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			productoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Cliente> clienteproveedordefectosForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedordefectoLogic=new ClienteLogic();
			clienteproveedordefectoLogic.setConnexion(this.connexion);
			clienteproveedordefectoLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedorDefecto.equals("NONE")) {
				clienteproveedordefectoLogic.getTodosClientes(finalQueryGlobalClienteProveedorDefecto,new Pagination());
				clienteproveedordefectosForeignKey=clienteproveedordefectoLogic.getClientes();
			}

			productoReturnGeneral.setclienteproveedordefectosForeignKey(clienteproveedordefectosForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			productoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);


			List<ColorProducto> colorproductosForeignKey=new ArrayList<ColorProducto>();
			ColorProductoLogic colorproductoLogic=new ColorProductoLogic();
			colorproductoLogic.setConnexion(this.connexion);
			colorproductoLogic.getColorProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorProducto.equals("NONE")) {
				colorproductoLogic.getTodosColorProductos(finalQueryGlobalColorProducto,new Pagination());
				colorproductosForeignKey=colorproductoLogic.getColorProductos();
			}

			productoReturnGeneral.setcolorproductosForeignKey(colorproductosForeignKey);


			List<ClaseProducto> claseproductosForeignKey=new ArrayList<ClaseProducto>();
			ClaseProductoLogic claseproductoLogic=new ClaseProductoLogic();
			claseproductoLogic.setConnexion(this.connexion);
			claseproductoLogic.getClaseProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClaseProducto.equals("NONE")) {
				claseproductoLogic.getTodosClaseProductos(finalQueryGlobalClaseProducto,new Pagination());
				claseproductosForeignKey=claseproductoLogic.getClaseProductos();
			}

			productoReturnGeneral.setclaseproductosForeignKey(claseproductosForeignKey);


			List<EfectoProducto> efectoproductosForeignKey=new ArrayList<EfectoProducto>();
			EfectoProductoLogic efectoproductoLogic=new EfectoProductoLogic();
			efectoproductoLogic.setConnexion(this.connexion);
			efectoproductoLogic.getEfectoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEfectoProducto.equals("NONE")) {
				efectoproductoLogic.getTodosEfectoProductos(finalQueryGlobalEfectoProducto,new Pagination());
				efectoproductosForeignKey=efectoproductoLogic.getEfectoProductos();
			}

			productoReturnGeneral.setefectoproductosForeignKey(efectoproductosForeignKey);


			List<MarcaProducto> marcaproductosForeignKey=new ArrayList<MarcaProducto>();
			MarcaProductoLogic marcaproductoLogic=new MarcaProductoLogic();
			marcaproductoLogic.setConnexion(this.connexion);
			marcaproductoLogic.getMarcaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMarcaProducto.equals("NONE")) {
				marcaproductoLogic.getTodosMarcaProductos(finalQueryGlobalMarcaProducto,new Pagination());
				marcaproductosForeignKey=marcaproductoLogic.getMarcaProductos();
			}

			productoReturnGeneral.setmarcaproductosForeignKey(marcaproductosForeignKey);


			List<ModeloProducto> modeloproductosForeignKey=new ArrayList<ModeloProducto>();
			ModeloProductoLogic modeloproductoLogic=new ModeloProductoLogic();
			modeloproductoLogic.setConnexion(this.connexion);
			modeloproductoLogic.getModeloProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModeloProducto.equals("NONE")) {
				modeloproductoLogic.getTodosModeloProductos(finalQueryGlobalModeloProducto,new Pagination());
				modeloproductosForeignKey=modeloproductoLogic.getModeloProductos();
			}

			productoReturnGeneral.setmodeloproductosForeignKey(modeloproductosForeignKey);


			List<MaterialProducto> materialproductosForeignKey=new ArrayList<MaterialProducto>();
			MaterialProductoLogic materialproductoLogic=new MaterialProductoLogic();
			materialproductoLogic.setConnexion(this.connexion);
			materialproductoLogic.getMaterialProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMaterialProducto.equals("NONE")) {
				materialproductoLogic.getTodosMaterialProductos(finalQueryGlobalMaterialProducto,new Pagination());
				materialproductosForeignKey=materialproductoLogic.getMaterialProductos();
			}

			productoReturnGeneral.setmaterialproductosForeignKey(materialproductosForeignKey);


			List<SegmentoProducto> segmentoproductosForeignKey=new ArrayList<SegmentoProducto>();
			SegmentoProductoLogic segmentoproductoLogic=new SegmentoProductoLogic();
			segmentoproductoLogic.setConnexion(this.connexion);
			segmentoproductoLogic.getSegmentoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSegmentoProducto.equals("NONE")) {
				segmentoproductoLogic.getTodosSegmentoProductos(finalQueryGlobalSegmentoProducto,new Pagination());
				segmentoproductosForeignKey=segmentoproductoLogic.getSegmentoProductos();
			}

			productoReturnGeneral.setsegmentoproductosForeignKey(segmentoproductosForeignKey);


			List<TallaProducto> tallaproductosForeignKey=new ArrayList<TallaProducto>();
			TallaProductoLogic tallaproductoLogic=new TallaProductoLogic();
			tallaproductoLogic.setConnexion(this.connexion);
			tallaproductoLogic.getTallaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTallaProducto.equals("NONE")) {
				tallaproductoLogic.getTodosTallaProductos(finalQueryGlobalTallaProducto,new Pagination());
				tallaproductosForeignKey=tallaproductoLogic.getTallaProductos();
			}

			productoReturnGeneral.settallaproductosForeignKey(tallaproductosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoReturnGeneral;
	}
	
	public ProductoParameterReturnGeneral cargarCombosLoteForeignKeyProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca,String finalQueryGlobalTipoProductoServicio,String finalQueryGlobalTipoProductoServicioInven,String finalQueryGlobalTipoCosteo,String finalQueryGlobalUnidad,String finalQueryGlobalUnidadPeso,String finalQueryGlobalArancel,String finalQueryGlobalCliente,String finalQueryGlobalClienteProveedorDefecto,String finalQueryGlobalTipoProducto,String finalQueryGlobalColorProducto,String finalQueryGlobalClaseProducto,String finalQueryGlobalEfectoProducto,String finalQueryGlobalMarcaProducto,String finalQueryGlobalModeloProducto,String finalQueryGlobalMaterialProducto,String finalQueryGlobalSegmentoProducto,String finalQueryGlobalTallaProducto) throws Exception {
		ProductoParameterReturnGeneral  productoReturnGeneral =new ProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoReturnGeneral =new ProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			productoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			productoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			productoReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			productoReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);


			List<TipoProductoServicio> tipoproductoserviciosForeignKey=new ArrayList<TipoProductoServicio>();
			TipoProductoServicioLogic tipoproductoservicioLogic=new TipoProductoServicioLogic();
			tipoproductoservicioLogic.setConnexion(this.connexion);
			tipoproductoservicioLogic.getTipoProductoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicio.equals("NONE")) {
				tipoproductoservicioLogic.getTodosTipoProductoServicios(finalQueryGlobalTipoProductoServicio,new Pagination());
				tipoproductoserviciosForeignKey=tipoproductoservicioLogic.getTipoProductoServicios();
			}

			productoReturnGeneral.settipoproductoserviciosForeignKey(tipoproductoserviciosForeignKey);


			List<TipoProductoServicioInven> tipoproductoservicioinvensForeignKey=new ArrayList<TipoProductoServicioInven>();
			TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic=new TipoProductoServicioInvenLogic();
			tipoproductoservicioinvenLogic.setConnexion(this.connexion);
			tipoproductoservicioinvenLogic.getTipoProductoServicioInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicioInven.equals("NONE")) {
				tipoproductoservicioinvenLogic.getTodosTipoProductoServicioInvens(finalQueryGlobalTipoProductoServicioInven,new Pagination());
				tipoproductoservicioinvensForeignKey=tipoproductoservicioinvenLogic.getTipoProductoServicioInvens();
			}

			productoReturnGeneral.settipoproductoservicioinvensForeignKey(tipoproductoservicioinvensForeignKey);


			List<TipoCosteo> tipocosteosForeignKey=new ArrayList<TipoCosteo>();
			TipoCosteoLogic tipocosteoLogic=new TipoCosteoLogic();
			tipocosteoLogic.setConnexion(this.connexion);
			tipocosteoLogic.getTipoCosteoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCosteo.equals("NONE")) {
				tipocosteoLogic.getTodosTipoCosteos(finalQueryGlobalTipoCosteo,new Pagination());
				tipocosteosForeignKey=tipocosteoLogic.getTipoCosteos();
			}

			productoReturnGeneral.settipocosteosForeignKey(tipocosteosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Unidad> unidadpesosForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadpesoLogic=new UnidadLogic();
			unidadpesoLogic.setConnexion(this.connexion);
			unidadpesoLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidadPeso.equals("NONE")) {
				unidadpesoLogic.getTodosUnidads(finalQueryGlobalUnidadPeso,new Pagination());
				unidadpesosForeignKey=unidadpesoLogic.getUnidads();
			}

			productoReturnGeneral.setunidadpesosForeignKey(unidadpesosForeignKey);


			List<Arancel> arancelsForeignKey=new ArrayList<Arancel>();
			ArancelLogic arancelLogic=new ArancelLogic();
			arancelLogic.setConnexion(this.connexion);
			arancelLogic.getArancelDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalArancel.equals("NONE")) {
				arancelLogic.getTodosArancels(finalQueryGlobalArancel,new Pagination());
				arancelsForeignKey=arancelLogic.getArancels();
			}

			productoReturnGeneral.setarancelsForeignKey(arancelsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			productoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Cliente> clienteproveedordefectosForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedordefectoLogic=new ClienteLogic();
			clienteproveedordefectoLogic.setConnexion(this.connexion);
			clienteproveedordefectoLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedorDefecto.equals("NONE")) {
				clienteproveedordefectoLogic.getTodosClientes(finalQueryGlobalClienteProveedorDefecto,new Pagination());
				clienteproveedordefectosForeignKey=clienteproveedordefectoLogic.getClientes();
			}

			productoReturnGeneral.setclienteproveedordefectosForeignKey(clienteproveedordefectosForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			productoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);


			List<ColorProducto> colorproductosForeignKey=new ArrayList<ColorProducto>();
			ColorProductoLogic colorproductoLogic=new ColorProductoLogic();
			colorproductoLogic.setConnexion(this.connexion);
			colorproductoLogic.getColorProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorProducto.equals("NONE")) {
				colorproductoLogic.getTodosColorProductos(finalQueryGlobalColorProducto,new Pagination());
				colorproductosForeignKey=colorproductoLogic.getColorProductos();
			}

			productoReturnGeneral.setcolorproductosForeignKey(colorproductosForeignKey);


			List<ClaseProducto> claseproductosForeignKey=new ArrayList<ClaseProducto>();
			ClaseProductoLogic claseproductoLogic=new ClaseProductoLogic();
			claseproductoLogic.setConnexion(this.connexion);
			claseproductoLogic.getClaseProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClaseProducto.equals("NONE")) {
				claseproductoLogic.getTodosClaseProductos(finalQueryGlobalClaseProducto,new Pagination());
				claseproductosForeignKey=claseproductoLogic.getClaseProductos();
			}

			productoReturnGeneral.setclaseproductosForeignKey(claseproductosForeignKey);


			List<EfectoProducto> efectoproductosForeignKey=new ArrayList<EfectoProducto>();
			EfectoProductoLogic efectoproductoLogic=new EfectoProductoLogic();
			efectoproductoLogic.setConnexion(this.connexion);
			efectoproductoLogic.getEfectoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEfectoProducto.equals("NONE")) {
				efectoproductoLogic.getTodosEfectoProductos(finalQueryGlobalEfectoProducto,new Pagination());
				efectoproductosForeignKey=efectoproductoLogic.getEfectoProductos();
			}

			productoReturnGeneral.setefectoproductosForeignKey(efectoproductosForeignKey);


			List<MarcaProducto> marcaproductosForeignKey=new ArrayList<MarcaProducto>();
			MarcaProductoLogic marcaproductoLogic=new MarcaProductoLogic();
			marcaproductoLogic.setConnexion(this.connexion);
			marcaproductoLogic.getMarcaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMarcaProducto.equals("NONE")) {
				marcaproductoLogic.getTodosMarcaProductos(finalQueryGlobalMarcaProducto,new Pagination());
				marcaproductosForeignKey=marcaproductoLogic.getMarcaProductos();
			}

			productoReturnGeneral.setmarcaproductosForeignKey(marcaproductosForeignKey);


			List<ModeloProducto> modeloproductosForeignKey=new ArrayList<ModeloProducto>();
			ModeloProductoLogic modeloproductoLogic=new ModeloProductoLogic();
			modeloproductoLogic.setConnexion(this.connexion);
			modeloproductoLogic.getModeloProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModeloProducto.equals("NONE")) {
				modeloproductoLogic.getTodosModeloProductos(finalQueryGlobalModeloProducto,new Pagination());
				modeloproductosForeignKey=modeloproductoLogic.getModeloProductos();
			}

			productoReturnGeneral.setmodeloproductosForeignKey(modeloproductosForeignKey);


			List<MaterialProducto> materialproductosForeignKey=new ArrayList<MaterialProducto>();
			MaterialProductoLogic materialproductoLogic=new MaterialProductoLogic();
			materialproductoLogic.setConnexion(this.connexion);
			materialproductoLogic.getMaterialProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMaterialProducto.equals("NONE")) {
				materialproductoLogic.getTodosMaterialProductos(finalQueryGlobalMaterialProducto,new Pagination());
				materialproductosForeignKey=materialproductoLogic.getMaterialProductos();
			}

			productoReturnGeneral.setmaterialproductosForeignKey(materialproductosForeignKey);


			List<SegmentoProducto> segmentoproductosForeignKey=new ArrayList<SegmentoProducto>();
			SegmentoProductoLogic segmentoproductoLogic=new SegmentoProductoLogic();
			segmentoproductoLogic.setConnexion(this.connexion);
			segmentoproductoLogic.getSegmentoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSegmentoProducto.equals("NONE")) {
				segmentoproductoLogic.getTodosSegmentoProductos(finalQueryGlobalSegmentoProducto,new Pagination());
				segmentoproductosForeignKey=segmentoproductoLogic.getSegmentoProductos();
			}

			productoReturnGeneral.setsegmentoproductosForeignKey(segmentoproductosForeignKey);


			List<TallaProducto> tallaproductosForeignKey=new ArrayList<TallaProducto>();
			TallaProductoLogic tallaproductoLogic=new TallaProductoLogic();
			tallaproductoLogic.setConnexion(this.connexion);
			tallaproductoLogic.getTallaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTallaProducto.equals("NONE")) {
				tallaproductoLogic.getTodosTallaProductos(finalQueryGlobalTallaProducto,new Pagination());
				tallaproductosForeignKey=tallaproductoLogic.getTallaProductos();
			}

			productoReturnGeneral.settallaproductosForeignKey(tallaproductosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyProductoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProveedorProductoLogic proveedorproductoLogic=new ProveedorProductoLogic();
			PrecioLogic precioLogic=new PrecioLogic();
			DetalleImpuestoInvenLogic detalleimpuestoinvenLogic=new DetalleImpuestoInvenLogic();
			PresupuestoVentasLogic presupuestoventasLogic=new PresupuestoVentasLogic();
			PoliticaProductoLogic politicaproductoLogic=new PoliticaProductoLogic();
			SerieProductoLogic serieproductoLogic=new SerieProductoLogic();
			UbicacionProduLogic ubicacionproduLogic=new UbicacionProduLogic();
			ParametroProductoLogic parametroproductoLogic=new ParametroProductoLogic();
			ProductoUnidadLogic productounidadLogic=new ProductoUnidadLogic();
			IngredienteLogic ingredienteLogic=new IngredienteLogic();
			ProductoCaracLogic productocaracLogic=new ProductoCaracLogic();
			ServicioClienteLogic servicioclienteLogic=new ServicioClienteLogic();
			ProductoPromocionLogic productopromocionLogic=new ProductoPromocionLogic();
			ProductoEspeciLogic productoespeciLogic=new ProductoEspeciLogic();
			ProductoReemplaLogic productoreemplaLogic=new ProductoReemplaLogic();
			ProductoEstadisticaLogic productoestadisticaLogic=new ProductoEstadisticaLogic();
			PoliticaFactuLogic politicafactuLogic=new PoliticaFactuLogic();
			ProductoCuentaContableLogic productocuentacontableLogic=new ProductoCuentaContableLogic();
			BodegaProductoLogic bodegaproductoLogic=new BodegaProductoLogic();
			PresupuestoProductoLogic presupuestoproductoLogic=new PresupuestoProductoLogic();
			SaldoMesProductoLogic saldomesproductoLogic=new SaldoMesProductoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyProductoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProveedorProducto.class));
			classes.add(new Classe(Precio.class));
			classes.add(new Classe(DetalleImpuestoInven.class));
			classes.add(new Classe(PresupuestoVentas.class));
			classes.add(new Classe(PoliticaProducto.class));
			classes.add(new Classe(SerieProducto.class));
			classes.add(new Classe(UbicacionProdu.class));
			classes.add(new Classe(ParametroProducto.class));
			classes.add(new Classe(ProductoUnidad.class));
			classes.add(new Classe(Ingrediente.class));
			classes.add(new Classe(ProductoCarac.class));
			classes.add(new Classe(ServicioCliente.class));
			classes.add(new Classe(ProductoPromocion.class));
			classes.add(new Classe(ProductoEspeci.class));
			classes.add(new Classe(ProductoReempla.class));
			classes.add(new Classe(ProductoEstadistica.class));
			classes.add(new Classe(PoliticaFactu.class));
			classes.add(new Classe(ProductoCuentaContable.class));
			classes.add(new Classe(BodegaProducto.class));
			classes.add(new Classe(PresupuestoProducto.class));
			classes.add(new Classe(SaldoMesProducto.class));
											
			

			proveedorproductoLogic.setConnexion(this.getConnexion());
			proveedorproductoLogic.setDatosCliente(this.datosCliente);
			proveedorproductoLogic.setIsConRefrescarForeignKeys(true);

			precioLogic.setConnexion(this.getConnexion());
			precioLogic.setDatosCliente(this.datosCliente);
			precioLogic.setIsConRefrescarForeignKeys(true);

			detalleimpuestoinvenLogic.setConnexion(this.getConnexion());
			detalleimpuestoinvenLogic.setDatosCliente(this.datosCliente);
			detalleimpuestoinvenLogic.setIsConRefrescarForeignKeys(true);

			presupuestoventasLogic.setConnexion(this.getConnexion());
			presupuestoventasLogic.setDatosCliente(this.datosCliente);
			presupuestoventasLogic.setIsConRefrescarForeignKeys(true);

			politicaproductoLogic.setConnexion(this.getConnexion());
			politicaproductoLogic.setDatosCliente(this.datosCliente);
			politicaproductoLogic.setIsConRefrescarForeignKeys(true);

			serieproductoLogic.setConnexion(this.getConnexion());
			serieproductoLogic.setDatosCliente(this.datosCliente);
			serieproductoLogic.setIsConRefrescarForeignKeys(true);

			ubicacionproduLogic.setConnexion(this.getConnexion());
			ubicacionproduLogic.setDatosCliente(this.datosCliente);
			ubicacionproduLogic.setIsConRefrescarForeignKeys(true);

			parametroproductoLogic.setConnexion(this.getConnexion());
			parametroproductoLogic.setDatosCliente(this.datosCliente);
			parametroproductoLogic.setIsConRefrescarForeignKeys(true);

			productounidadLogic.setConnexion(this.getConnexion());
			productounidadLogic.setDatosCliente(this.datosCliente);
			productounidadLogic.setIsConRefrescarForeignKeys(true);

			ingredienteLogic.setConnexion(this.getConnexion());
			ingredienteLogic.setDatosCliente(this.datosCliente);
			ingredienteLogic.setIsConRefrescarForeignKeys(true);

			productocaracLogic.setConnexion(this.getConnexion());
			productocaracLogic.setDatosCliente(this.datosCliente);
			productocaracLogic.setIsConRefrescarForeignKeys(true);

			servicioclienteLogic.setConnexion(this.getConnexion());
			servicioclienteLogic.setDatosCliente(this.datosCliente);
			servicioclienteLogic.setIsConRefrescarForeignKeys(true);

			productopromocionLogic.setConnexion(this.getConnexion());
			productopromocionLogic.setDatosCliente(this.datosCliente);
			productopromocionLogic.setIsConRefrescarForeignKeys(true);

			productoespeciLogic.setConnexion(this.getConnexion());
			productoespeciLogic.setDatosCliente(this.datosCliente);
			productoespeciLogic.setIsConRefrescarForeignKeys(true);

			productoreemplaLogic.setConnexion(this.getConnexion());
			productoreemplaLogic.setDatosCliente(this.datosCliente);
			productoreemplaLogic.setIsConRefrescarForeignKeys(true);

			productoestadisticaLogic.setConnexion(this.getConnexion());
			productoestadisticaLogic.setDatosCliente(this.datosCliente);
			productoestadisticaLogic.setIsConRefrescarForeignKeys(true);

			politicafactuLogic.setConnexion(this.getConnexion());
			politicafactuLogic.setDatosCliente(this.datosCliente);
			politicafactuLogic.setIsConRefrescarForeignKeys(true);

			productocuentacontableLogic.setConnexion(this.getConnexion());
			productocuentacontableLogic.setDatosCliente(this.datosCliente);
			productocuentacontableLogic.setIsConRefrescarForeignKeys(true);

			bodegaproductoLogic.setConnexion(this.getConnexion());
			bodegaproductoLogic.setDatosCliente(this.datosCliente);
			bodegaproductoLogic.setIsConRefrescarForeignKeys(true);

			presupuestoproductoLogic.setConnexion(this.getConnexion());
			presupuestoproductoLogic.setDatosCliente(this.datosCliente);
			presupuestoproductoLogic.setIsConRefrescarForeignKeys(true);

			saldomesproductoLogic.setConnexion(this.getConnexion());
			saldomesproductoLogic.setDatosCliente(this.datosCliente);
			saldomesproductoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Producto producto:this.productos) {
				

				classes=new ArrayList<Classe>();
				classes=ProveedorProductoConstantesFunciones.getClassesForeignKeysOfProveedorProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				proveedorproductoLogic.setProveedorProductos(producto.proveedorproductos);
				proveedorproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);

				precioLogic.setPrecios(producto.precios);
				precioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleImpuestoInvenConstantesFunciones.getClassesForeignKeysOfDetalleImpuestoInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleimpuestoinvenLogic.setDetalleImpuestoInvens(producto.detalleimpuestoinvens);
				detalleimpuestoinvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PresupuestoVentasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentas(new ArrayList<Classe>(),DeepLoadType.NONE);

				presupuestoventasLogic.setPresupuestoVentass(producto.presupuestoventass);
				presupuestoventasLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PoliticaProductoConstantesFunciones.getClassesForeignKeysOfPoliticaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				politicaproductoLogic.setPoliticaProductos(producto.politicaproductos);
				politicaproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SerieProductoConstantesFunciones.getClassesForeignKeysOfSerieProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				serieproductoLogic.setSerieProductos(producto.serieproductos);
				serieproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=UbicacionProduConstantesFunciones.getClassesForeignKeysOfUbicacionProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				ubicacionproduLogic.setUbicacionProdus(producto.ubicacionprodus);
				ubicacionproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroProductoConstantesFunciones.getClassesForeignKeysOfParametroProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroproductoLogic.setParametroProductos(producto.parametroproductos);
				parametroproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoUnidadConstantesFunciones.getClassesForeignKeysOfProductoUnidad(new ArrayList<Classe>(),DeepLoadType.NONE);

				productounidadLogic.setProductoUnidads(producto.productounidads);
				productounidadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=IngredienteConstantesFunciones.getClassesForeignKeysOfIngrediente(new ArrayList<Classe>(),DeepLoadType.NONE);

				ingredienteLogic.setIngredientes(producto.ingredienteRelacions);
				ingredienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoCaracConstantesFunciones.getClassesForeignKeysOfProductoCarac(new ArrayList<Classe>(),DeepLoadType.NONE);

				productocaracLogic.setProductoCaracs(producto.productocaracs);
				productocaracLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ServicioClienteConstantesFunciones.getClassesForeignKeysOfServicioCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				servicioclienteLogic.setServicioClientes(producto.servicioclientes);
				servicioclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoPromocionConstantesFunciones.getClassesForeignKeysOfProductoPromocion(new ArrayList<Classe>(),DeepLoadType.NONE);

				productopromocionLogic.setProductoPromocions(producto.productopromocionRelacions);
				productopromocionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoEspeciConstantesFunciones.getClassesForeignKeysOfProductoEspeci(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoespeciLogic.setProductoEspecis(producto.productoespecis);
				productoespeciLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoReemplaConstantesFunciones.getClassesForeignKeysOfProductoReempla(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoreemplaLogic.setProductoReemplas(producto.productoreemplas);
				productoreemplaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoEstadisticaConstantesFunciones.getClassesForeignKeysOfProductoEstadistica(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoestadisticaLogic.setProductoEstadisticas(producto.productoestadisticas);
				productoestadisticaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PoliticaFactuConstantesFunciones.getClassesForeignKeysOfPoliticaFactu(new ArrayList<Classe>(),DeepLoadType.NONE);

				politicafactuLogic.setPoliticaFactus(producto.politicafactus);
				politicafactuLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoCuentaContableConstantesFunciones.getClassesForeignKeysOfProductoCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);

				productocuentacontableLogic.setProductoCuentaContables(producto.productocuentacontables);
				productocuentacontableLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=BodegaProductoConstantesFunciones.getClassesForeignKeysOfBodegaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				bodegaproductoLogic.setBodegaProductos(producto.bodegaproductos);
				bodegaproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PresupuestoProductoConstantesFunciones.getClassesForeignKeysOfPresupuestoProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				presupuestoproductoLogic.setPresupuestoProductos(producto.presupuestoproductos);
				presupuestoproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SaldoMesProductoConstantesFunciones.getClassesForeignKeysOfSaldoMesProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				saldomesproductoLogic.setSaldoMesProductos(producto.saldomesproductos);
				saldomesproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Producto producto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoLogicAdditional.updateProductoToGet(producto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		producto.setEmpresa(productoDataAccess.getEmpresa(connexion,producto));
		producto.setSucursal(productoDataAccess.getSucursal(connexion,producto));
		producto.setLinea(productoDataAccess.getLinea(connexion,producto));
		producto.setLineaGrupo(productoDataAccess.getLineaGrupo(connexion,producto));
		producto.setLineaCategoria(productoDataAccess.getLineaCategoria(connexion,producto));
		producto.setLineaMarca(productoDataAccess.getLineaMarca(connexion,producto));
		producto.setTipoProductoServicio(productoDataAccess.getTipoProductoServicio(connexion,producto));
		producto.setTipoProductoServicioInven(productoDataAccess.getTipoProductoServicioInven(connexion,producto));
		producto.setTipoCosteo(productoDataAccess.getTipoCosteo(connexion,producto));
		producto.setUnidad(productoDataAccess.getUnidad(connexion,producto));
		producto.setUnidadPeso(productoDataAccess.getUnidadPeso(connexion,producto));
		producto.setArancel(productoDataAccess.getArancel(connexion,producto));
		producto.setCliente(productoDataAccess.getCliente(connexion,producto));
		producto.setClienteProveedorDefecto(productoDataAccess.getClienteProveedorDefecto(connexion,producto));
		producto.setTipoProducto(productoDataAccess.getTipoProducto(connexion,producto));
		producto.setColorProducto(productoDataAccess.getColorProducto(connexion,producto));
		producto.setClaseProducto(productoDataAccess.getClaseProducto(connexion,producto));
		producto.setEfectoProducto(productoDataAccess.getEfectoProducto(connexion,producto));
		producto.setMarcaProducto(productoDataAccess.getMarcaProducto(connexion,producto));
		producto.setModeloProducto(productoDataAccess.getModeloProducto(connexion,producto));
		producto.setMaterialProducto(productoDataAccess.getMaterialProducto(connexion,producto));
		producto.setSegmentoProducto(productoDataAccess.getSegmentoProducto(connexion,producto));
		producto.setTallaProducto(productoDataAccess.getTallaProducto(connexion,producto));
		producto.setProveedorProductos(productoDataAccess.getProveedorProductos(connexion,producto));
		producto.setPrecios(productoDataAccess.getPrecios(connexion,producto));
		producto.setDetalleImpuestoInvens(productoDataAccess.getDetalleImpuestoInvens(connexion,producto));
		producto.setPresupuestoVentass(productoDataAccess.getPresupuestoVentass(connexion,producto));
		producto.setPoliticaProductos(productoDataAccess.getPoliticaProductos(connexion,producto));
		producto.setSerieProductos(productoDataAccess.getSerieProductos(connexion,producto));
		producto.setUbicacionProdus(productoDataAccess.getUbicacionProdus(connexion,producto));
		producto.setParametroProductos(productoDataAccess.getParametroProductos(connexion,producto));
		producto.setProductoUnidads(productoDataAccess.getProductoUnidads(connexion,producto));
		producto.setIngredienteRelacions(productoDataAccess.getIngredienteRelacions(connexion,producto));
		producto.setProductoCaracs(productoDataAccess.getProductoCaracs(connexion,producto));
		producto.setServicioClientes(productoDataAccess.getServicioClientes(connexion,producto));
		producto.setProductoPromocionRelacions(productoDataAccess.getProductoPromocionRelacions(connexion,producto));
		producto.setProductoEspecis(productoDataAccess.getProductoEspecis(connexion,producto));
		producto.setProductoReemplas(productoDataAccess.getProductoReemplas(connexion,producto));
		producto.setProductoEstadisticas(productoDataAccess.getProductoEstadisticas(connexion,producto));
		producto.setPoliticaFactus(productoDataAccess.getPoliticaFactus(connexion,producto));
		producto.setProductoCuentaContables(productoDataAccess.getProductoCuentaContables(connexion,producto));
		producto.setBodegaProductos(productoDataAccess.getBodegaProductos(connexion,producto));
		producto.setPresupuestoProductos(productoDataAccess.getPresupuestoProductos(connexion,producto));
		producto.setSaldoMesProductos(productoDataAccess.getSaldoMesProductos(connexion,producto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				producto.setEmpresa(productoDataAccess.getEmpresa(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				producto.setSucursal(productoDataAccess.getSucursal(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				producto.setLinea(productoDataAccess.getLinea(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				producto.setLineaGrupo(productoDataAccess.getLineaGrupo(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				producto.setLineaCategoria(productoDataAccess.getLineaCategoria(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				producto.setLineaMarca(productoDataAccess.getLineaMarca(connexion,producto));
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				producto.setTipoProductoServicio(productoDataAccess.getTipoProductoServicio(connexion,producto));
				continue;
			}

			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				producto.setTipoProductoServicioInven(productoDataAccess.getTipoProductoServicioInven(connexion,producto));
				continue;
			}

			if(clas.clas.equals(TipoCosteo.class)) {
				producto.setTipoCosteo(productoDataAccess.getTipoCosteo(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				producto.setUnidad(productoDataAccess.getUnidad(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				producto.setUnidadPeso(productoDataAccess.getUnidadPeso(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Arancel.class)) {
				producto.setArancel(productoDataAccess.getArancel(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				producto.setCliente(productoDataAccess.getCliente(connexion,producto));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				producto.setClienteProveedorDefecto(productoDataAccess.getClienteProveedorDefecto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				producto.setTipoProducto(productoDataAccess.getTipoProducto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)) {
				producto.setColorProducto(productoDataAccess.getColorProducto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)) {
				producto.setClaseProducto(productoDataAccess.getClaseProducto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)) {
				producto.setEfectoProducto(productoDataAccess.getEfectoProducto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)) {
				producto.setMarcaProducto(productoDataAccess.getMarcaProducto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)) {
				producto.setModeloProducto(productoDataAccess.getModeloProducto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)) {
				producto.setMaterialProducto(productoDataAccess.getMaterialProducto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)) {
				producto.setSegmentoProducto(productoDataAccess.getSegmentoProducto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)) {
				producto.setTallaProducto(productoDataAccess.getTallaProducto(connexion,producto));
				continue;
			}

			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProveedorProductos(productoDataAccess.getProveedorProductos(connexion,producto));

				if(this.isConDeep) {
					ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(this.connexion);
					proveedorproductoLogic.setProveedorProductos(producto.getProveedorProductos());
					ArrayList<Classe> classesLocal=ProveedorProductoConstantesFunciones.getClassesForeignKeysOfProveedorProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					proveedorproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProveedorProductoConstantesFunciones.refrescarForeignKeysDescripcionesProveedorProducto(proveedorproductoLogic.getProveedorProductos());
					producto.setProveedorProductos(proveedorproductoLogic.getProveedorProductos());
				}

				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPrecios(productoDataAccess.getPrecios(connexion,producto));

				if(this.isConDeep) {
					PrecioLogic precioLogic= new PrecioLogic(this.connexion);
					precioLogic.setPrecios(producto.getPrecios());
					ArrayList<Classe> classesLocal=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);
					precioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(precioLogic.getPrecios());
					producto.setPrecios(precioLogic.getPrecios());
				}

				continue;
			}

			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setDetalleImpuestoInvens(productoDataAccess.getDetalleImpuestoInvens(connexion,producto));

				if(this.isConDeep) {
					DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(this.connexion);
					detalleimpuestoinvenLogic.setDetalleImpuestoInvens(producto.getDetalleImpuestoInvens());
					ArrayList<Classe> classesLocal=DetalleImpuestoInvenConstantesFunciones.getClassesForeignKeysOfDetalleImpuestoInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleimpuestoinvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(detalleimpuestoinvenLogic.getDetalleImpuestoInvens());
					producto.setDetalleImpuestoInvens(detalleimpuestoinvenLogic.getDetalleImpuestoInvens());
				}

				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPresupuestoVentass(productoDataAccess.getPresupuestoVentass(connexion,producto));

				if(this.isConDeep) {
					PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(this.connexion);
					presupuestoventasLogic.setPresupuestoVentass(producto.getPresupuestoVentass());
					ArrayList<Classe> classesLocal=PresupuestoVentasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentas(new ArrayList<Classe>(),DeepLoadType.NONE);
					presupuestoventasLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(presupuestoventasLogic.getPresupuestoVentass());
					producto.setPresupuestoVentass(presupuestoventasLogic.getPresupuestoVentass());
				}

				continue;
			}

			if(clas.clas.equals(PoliticaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPoliticaProductos(productoDataAccess.getPoliticaProductos(connexion,producto));

				if(this.isConDeep) {
					PoliticaProductoLogic politicaproductoLogic= new PoliticaProductoLogic(this.connexion);
					politicaproductoLogic.setPoliticaProductos(producto.getPoliticaProductos());
					ArrayList<Classe> classesLocal=PoliticaProductoConstantesFunciones.getClassesForeignKeysOfPoliticaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					politicaproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PoliticaProductoConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaProducto(politicaproductoLogic.getPoliticaProductos());
					producto.setPoliticaProductos(politicaproductoLogic.getPoliticaProductos());
				}

				continue;
			}

			if(clas.clas.equals(SerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setSerieProductos(productoDataAccess.getSerieProductos(connexion,producto));

				if(this.isConDeep) {
					SerieProductoLogic serieproductoLogic= new SerieProductoLogic(this.connexion);
					serieproductoLogic.setSerieProductos(producto.getSerieProductos());
					ArrayList<Classe> classesLocal=SerieProductoConstantesFunciones.getClassesForeignKeysOfSerieProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					serieproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(serieproductoLogic.getSerieProductos());
					producto.setSerieProductos(serieproductoLogic.getSerieProductos());
				}

				continue;
			}

			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setUbicacionProdus(productoDataAccess.getUbicacionProdus(connexion,producto));

				if(this.isConDeep) {
					UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(this.connexion);
					ubicacionproduLogic.setUbicacionProdus(producto.getUbicacionProdus());
					ArrayList<Classe> classesLocal=UbicacionProduConstantesFunciones.getClassesForeignKeysOfUbicacionProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					ubicacionproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(ubicacionproduLogic.getUbicacionProdus());
					producto.setUbicacionProdus(ubicacionproduLogic.getUbicacionProdus());
				}

				continue;
			}

			if(clas.clas.equals(ParametroProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setParametroProductos(productoDataAccess.getParametroProductos(connexion,producto));

				if(this.isConDeep) {
					ParametroProductoLogic parametroproductoLogic= new ParametroProductoLogic(this.connexion);
					parametroproductoLogic.setParametroProductos(producto.getParametroProductos());
					ArrayList<Classe> classesLocal=ParametroProductoConstantesFunciones.getClassesForeignKeysOfParametroProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroProductoConstantesFunciones.refrescarForeignKeysDescripcionesParametroProducto(parametroproductoLogic.getParametroProductos());
					producto.setParametroProductos(parametroproductoLogic.getParametroProductos());
				}

				continue;
			}

			if(clas.clas.equals(ProductoUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoUnidads(productoDataAccess.getProductoUnidads(connexion,producto));

				if(this.isConDeep) {
					ProductoUnidadLogic productounidadLogic= new ProductoUnidadLogic(this.connexion);
					productounidadLogic.setProductoUnidads(producto.getProductoUnidads());
					ArrayList<Classe> classesLocal=ProductoUnidadConstantesFunciones.getClassesForeignKeysOfProductoUnidad(new ArrayList<Classe>(),DeepLoadType.NONE);
					productounidadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesProductoUnidad(productounidadLogic.getProductoUnidads());
					producto.setProductoUnidads(productounidadLogic.getProductoUnidads());
				}

				continue;
			}

			if(clas.clas.equals(Ingrediente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setIngredienteRelacions(productoDataAccess.getIngredienteRelacions(connexion,producto));

				if(this.isConDeep) {
					IngredienteLogic ingredienteLogic= new IngredienteLogic(this.connexion);
					ingredienteLogic.setIngredientes(producto.getIngredienteRelacions());
					ArrayList<Classe> classesLocal=IngredienteConstantesFunciones.getClassesForeignKeysOfIngrediente(new ArrayList<Classe>(),DeepLoadType.NONE);
					ingredienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(ingredienteLogic.getIngredientes());
					producto.setIngredienteRelacions(ingredienteLogic.getIngredientes());
				}

				continue;
			}

			if(clas.clas.equals(ProductoCarac.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoCaracs(productoDataAccess.getProductoCaracs(connexion,producto));

				if(this.isConDeep) {
					ProductoCaracLogic productocaracLogic= new ProductoCaracLogic(this.connexion);
					productocaracLogic.setProductoCaracs(producto.getProductoCaracs());
					ArrayList<Classe> classesLocal=ProductoCaracConstantesFunciones.getClassesForeignKeysOfProductoCarac(new ArrayList<Classe>(),DeepLoadType.NONE);
					productocaracLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoCaracConstantesFunciones.refrescarForeignKeysDescripcionesProductoCarac(productocaracLogic.getProductoCaracs());
					producto.setProductoCaracs(productocaracLogic.getProductoCaracs());
				}

				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setServicioClientes(productoDataAccess.getServicioClientes(connexion,producto));

				if(this.isConDeep) {
					ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(this.connexion);
					servicioclienteLogic.setServicioClientes(producto.getServicioClientes());
					ArrayList<Classe> classesLocal=ServicioClienteConstantesFunciones.getClassesForeignKeysOfServicioCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					servicioclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ServicioClienteConstantesFunciones.refrescarForeignKeysDescripcionesServicioCliente(servicioclienteLogic.getServicioClientes());
					producto.setServicioClientes(servicioclienteLogic.getServicioClientes());
				}

				continue;
			}

			if(clas.clas.equals(ProductoPromocion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoPromocionRelacions(productoDataAccess.getProductoPromocionRelacions(connexion,producto));

				if(this.isConDeep) {
					ProductoPromocionLogic productopromocionLogic= new ProductoPromocionLogic(this.connexion);
					productopromocionLogic.setProductoPromocions(producto.getProductoPromocionRelacions());
					ArrayList<Classe> classesLocal=ProductoPromocionConstantesFunciones.getClassesForeignKeysOfProductoPromocion(new ArrayList<Classe>(),DeepLoadType.NONE);
					productopromocionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(productopromocionLogic.getProductoPromocions());
					producto.setProductoPromocionRelacions(productopromocionLogic.getProductoPromocions());
				}

				continue;
			}

			if(clas.clas.equals(ProductoEspeci.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoEspecis(productoDataAccess.getProductoEspecis(connexion,producto));

				if(this.isConDeep) {
					ProductoEspeciLogic productoespeciLogic= new ProductoEspeciLogic(this.connexion);
					productoespeciLogic.setProductoEspecis(producto.getProductoEspecis());
					ArrayList<Classe> classesLocal=ProductoEspeciConstantesFunciones.getClassesForeignKeysOfProductoEspeci(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoespeciLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoEspeciConstantesFunciones.refrescarForeignKeysDescripcionesProductoEspeci(productoespeciLogic.getProductoEspecis());
					producto.setProductoEspecis(productoespeciLogic.getProductoEspecis());
				}

				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoReemplas(productoDataAccess.getProductoReemplas(connexion,producto));

				if(this.isConDeep) {
					ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(this.connexion);
					productoreemplaLogic.setProductoReemplas(producto.getProductoReemplas());
					ArrayList<Classe> classesLocal=ProductoReemplaConstantesFunciones.getClassesForeignKeysOfProductoReempla(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoreemplaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoReemplaConstantesFunciones.refrescarForeignKeysDescripcionesProductoReempla(productoreemplaLogic.getProductoReemplas());
					producto.setProductoReemplas(productoreemplaLogic.getProductoReemplas());
				}

				continue;
			}

			if(clas.clas.equals(ProductoEstadistica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoEstadisticas(productoDataAccess.getProductoEstadisticas(connexion,producto));

				if(this.isConDeep) {
					ProductoEstadisticaLogic productoestadisticaLogic= new ProductoEstadisticaLogic(this.connexion);
					productoestadisticaLogic.setProductoEstadisticas(producto.getProductoEstadisticas());
					ArrayList<Classe> classesLocal=ProductoEstadisticaConstantesFunciones.getClassesForeignKeysOfProductoEstadistica(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoestadisticaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(productoestadisticaLogic.getProductoEstadisticas());
					producto.setProductoEstadisticas(productoestadisticaLogic.getProductoEstadisticas());
				}

				continue;
			}

			if(clas.clas.equals(PoliticaFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPoliticaFactus(productoDataAccess.getPoliticaFactus(connexion,producto));

				if(this.isConDeep) {
					PoliticaFactuLogic politicafactuLogic= new PoliticaFactuLogic(this.connexion);
					politicafactuLogic.setPoliticaFactus(producto.getPoliticaFactus());
					ArrayList<Classe> classesLocal=PoliticaFactuConstantesFunciones.getClassesForeignKeysOfPoliticaFactu(new ArrayList<Classe>(),DeepLoadType.NONE);
					politicafactuLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PoliticaFactuConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaFactu(politicafactuLogic.getPoliticaFactus());
					producto.setPoliticaFactus(politicafactuLogic.getPoliticaFactus());
				}

				continue;
			}

			if(clas.clas.equals(ProductoCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoCuentaContables(productoDataAccess.getProductoCuentaContables(connexion,producto));

				if(this.isConDeep) {
					ProductoCuentaContableLogic productocuentacontableLogic= new ProductoCuentaContableLogic(this.connexion);
					productocuentacontableLogic.setProductoCuentaContables(producto.getProductoCuentaContables());
					ArrayList<Classe> classesLocal=ProductoCuentaContableConstantesFunciones.getClassesForeignKeysOfProductoCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);
					productocuentacontableLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(productocuentacontableLogic.getProductoCuentaContables());
					producto.setProductoCuentaContables(productocuentacontableLogic.getProductoCuentaContables());
				}

				continue;
			}

			if(clas.clas.equals(BodegaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setBodegaProductos(productoDataAccess.getBodegaProductos(connexion,producto));

				if(this.isConDeep) {
					BodegaProductoLogic bodegaproductoLogic= new BodegaProductoLogic(this.connexion);
					bodegaproductoLogic.setBodegaProductos(producto.getBodegaProductos());
					ArrayList<Classe> classesLocal=BodegaProductoConstantesFunciones.getClassesForeignKeysOfBodegaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					bodegaproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(bodegaproductoLogic.getBodegaProductos());
					producto.setBodegaProductos(bodegaproductoLogic.getBodegaProductos());
				}

				continue;
			}

			if(clas.clas.equals(PresupuestoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPresupuestoProductos(productoDataAccess.getPresupuestoProductos(connexion,producto));

				if(this.isConDeep) {
					PresupuestoProductoLogic presupuestoproductoLogic= new PresupuestoProductoLogic(this.connexion);
					presupuestoproductoLogic.setPresupuestoProductos(producto.getPresupuestoProductos());
					ArrayList<Classe> classesLocal=PresupuestoProductoConstantesFunciones.getClassesForeignKeysOfPresupuestoProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					presupuestoproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresupuestoProductoConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoProducto(presupuestoproductoLogic.getPresupuestoProductos());
					producto.setPresupuestoProductos(presupuestoproductoLogic.getPresupuestoProductos());
				}

				continue;
			}

			if(clas.clas.equals(SaldoMesProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setSaldoMesProductos(productoDataAccess.getSaldoMesProductos(connexion,producto));

				if(this.isConDeep) {
					SaldoMesProductoLogic saldomesproductoLogic= new SaldoMesProductoLogic(this.connexion);
					saldomesproductoLogic.setSaldoMesProductos(producto.getSaldoMesProductos());
					ArrayList<Classe> classesLocal=SaldoMesProductoConstantesFunciones.getClassesForeignKeysOfSaldoMesProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					saldomesproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(saldomesproductoLogic.getSaldoMesProductos());
					producto.setSaldoMesProductos(saldomesproductoLogic.getSaldoMesProductos());
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
			producto.setEmpresa(productoDataAccess.getEmpresa(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setSucursal(productoDataAccess.getSucursal(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setLinea(productoDataAccess.getLinea(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setLineaGrupo(productoDataAccess.getLineaGrupo(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setLineaCategoria(productoDataAccess.getLineaCategoria(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setLineaMarca(productoDataAccess.getLineaMarca(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTipoProductoServicio(productoDataAccess.getTipoProductoServicio(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTipoProductoServicioInven(productoDataAccess.getTipoProductoServicioInven(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCosteo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTipoCosteo(productoDataAccess.getTipoCosteo(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setUnidad(productoDataAccess.getUnidad(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setUnidadPeso(productoDataAccess.getUnidadPeso(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Arancel.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setArancel(productoDataAccess.getArancel(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setCliente(productoDataAccess.getCliente(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setClienteProveedorDefecto(productoDataAccess.getClienteProveedorDefecto(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTipoProducto(productoDataAccess.getTipoProducto(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setColorProducto(productoDataAccess.getColorProducto(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClaseProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setClaseProducto(productoDataAccess.getClaseProducto(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EfectoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setEfectoProducto(productoDataAccess.getEfectoProducto(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MarcaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setMarcaProducto(productoDataAccess.getMarcaProducto(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ModeloProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setModeloProducto(productoDataAccess.getModeloProducto(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MaterialProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setMaterialProducto(productoDataAccess.getMaterialProducto(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SegmentoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setSegmentoProducto(productoDataAccess.getSegmentoProducto(connexion,producto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TallaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTallaProducto(productoDataAccess.getTallaProducto(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProveedorProducto.class));
			producto.setProveedorProductos(productoDataAccess.getProveedorProductos(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			producto.setPrecios(productoDataAccess.getPrecios(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleImpuestoInven.class));
			producto.setDetalleImpuestoInvens(productoDataAccess.getDetalleImpuestoInvens(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentas.class));
			producto.setPresupuestoVentass(productoDataAccess.getPresupuestoVentass(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticaProducto.class));
			producto.setPoliticaProductos(productoDataAccess.getPoliticaProductos(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SerieProducto.class));
			producto.setSerieProductos(productoDataAccess.getSerieProductos(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UbicacionProdu.class));
			producto.setUbicacionProdus(productoDataAccess.getUbicacionProdus(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroProducto.class));
			producto.setParametroProductos(productoDataAccess.getParametroProductos(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoUnidad.class));
			producto.setProductoUnidads(productoDataAccess.getProductoUnidads(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ingrediente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Ingrediente.class));
			producto.setIngredienteRelacions(productoDataAccess.getIngredienteRelacions(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoCarac.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoCarac.class));
			producto.setProductoCaracs(productoDataAccess.getProductoCaracs(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioCliente.class));
			producto.setServicioClientes(productoDataAccess.getServicioClientes(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoPromocion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoPromocion.class));
			producto.setProductoPromocionRelacions(productoDataAccess.getProductoPromocionRelacions(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoEspeci.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoEspeci.class));
			producto.setProductoEspecis(productoDataAccess.getProductoEspecis(connexion,producto));
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
			producto.setProductoReemplas(productoDataAccess.getProductoReemplas(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoEstadistica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoEstadistica.class));
			producto.setProductoEstadisticas(productoDataAccess.getProductoEstadisticas(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticaFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticaFactu.class));
			producto.setPoliticaFactus(productoDataAccess.getPoliticaFactus(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoCuentaContable.class));
			producto.setProductoCuentaContables(productoDataAccess.getProductoCuentaContables(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(BodegaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(BodegaProducto.class));
			producto.setBodegaProductos(productoDataAccess.getBodegaProductos(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoProducto.class));
			producto.setPresupuestoProductos(productoDataAccess.getPresupuestoProductos(connexion,producto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SaldoMesProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SaldoMesProducto.class));
			producto.setSaldoMesProductos(productoDataAccess.getSaldoMesProductos(connexion,producto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		producto.setEmpresa(productoDataAccess.getEmpresa(connexion,producto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(producto.getEmpresa(),isDeep,deepLoadType,clases);
				
		producto.setSucursal(productoDataAccess.getSucursal(connexion,producto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(producto.getSucursal(),isDeep,deepLoadType,clases);
				
		producto.setLinea(productoDataAccess.getLinea(connexion,producto));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(producto.getLinea(),isDeep,deepLoadType,clases);
				
		producto.setLineaGrupo(productoDataAccess.getLineaGrupo(connexion,producto));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(producto.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		producto.setLineaCategoria(productoDataAccess.getLineaCategoria(connexion,producto));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(producto.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		producto.setLineaMarca(productoDataAccess.getLineaMarca(connexion,producto));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(producto.getLineaMarca(),isDeep,deepLoadType,clases);
				
		producto.setTipoProductoServicio(productoDataAccess.getTipoProductoServicio(connexion,producto));
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(producto.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
		producto.setTipoProductoServicioInven(productoDataAccess.getTipoProductoServicioInven(connexion,producto));
		TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
		tipoproductoservicioinvenLogic.deepLoad(producto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);
				
		producto.setTipoCosteo(productoDataAccess.getTipoCosteo(connexion,producto));
		TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
		tipocosteoLogic.deepLoad(producto.getTipoCosteo(),isDeep,deepLoadType,clases);
				
		producto.setUnidad(productoDataAccess.getUnidad(connexion,producto));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(producto.getUnidad(),isDeep,deepLoadType,clases);
				
		producto.setUnidadPeso(productoDataAccess.getUnidadPeso(connexion,producto));
		UnidadLogic unidadpesoLogic= new UnidadLogic(connexion);
		unidadpesoLogic.deepLoad(producto.getUnidadPeso(),isDeep,deepLoadType,clases);
				
		producto.setArancel(productoDataAccess.getArancel(connexion,producto));
		ArancelLogic arancelLogic= new ArancelLogic(connexion);
		arancelLogic.deepLoad(producto.getArancel(),isDeep,deepLoadType,clases);
				
		producto.setCliente(productoDataAccess.getCliente(connexion,producto));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(producto.getCliente(),isDeep,deepLoadType,clases);
				
		producto.setClienteProveedorDefecto(productoDataAccess.getClienteProveedorDefecto(connexion,producto));
		ClienteLogic clienteproveedordefectoLogic= new ClienteLogic(connexion);
		clienteproveedordefectoLogic.deepLoad(producto.getClienteProveedorDefecto(),isDeep,deepLoadType,clases);
				
		producto.setTipoProducto(productoDataAccess.getTipoProducto(connexion,producto));
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(producto.getTipoProducto(),isDeep,deepLoadType,clases);
				
		producto.setColorProducto(productoDataAccess.getColorProducto(connexion,producto));
		ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
		colorproductoLogic.deepLoad(producto.getColorProducto(),isDeep,deepLoadType,clases);
				
		producto.setClaseProducto(productoDataAccess.getClaseProducto(connexion,producto));
		ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
		claseproductoLogic.deepLoad(producto.getClaseProducto(),isDeep,deepLoadType,clases);
				
		producto.setEfectoProducto(productoDataAccess.getEfectoProducto(connexion,producto));
		EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
		efectoproductoLogic.deepLoad(producto.getEfectoProducto(),isDeep,deepLoadType,clases);
				
		producto.setMarcaProducto(productoDataAccess.getMarcaProducto(connexion,producto));
		MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
		marcaproductoLogic.deepLoad(producto.getMarcaProducto(),isDeep,deepLoadType,clases);
				
		producto.setModeloProducto(productoDataAccess.getModeloProducto(connexion,producto));
		ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
		modeloproductoLogic.deepLoad(producto.getModeloProducto(),isDeep,deepLoadType,clases);
				
		producto.setMaterialProducto(productoDataAccess.getMaterialProducto(connexion,producto));
		MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
		materialproductoLogic.deepLoad(producto.getMaterialProducto(),isDeep,deepLoadType,clases);
				
		producto.setSegmentoProducto(productoDataAccess.getSegmentoProducto(connexion,producto));
		SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
		segmentoproductoLogic.deepLoad(producto.getSegmentoProducto(),isDeep,deepLoadType,clases);
				
		producto.setTallaProducto(productoDataAccess.getTallaProducto(connexion,producto));
		TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
		tallaproductoLogic.deepLoad(producto.getTallaProducto(),isDeep,deepLoadType,clases);
				

		producto.setProveedorProductos(productoDataAccess.getProveedorProductos(connexion,producto));

		for(ProveedorProducto proveedorproducto:producto.getProveedorProductos()) {
			ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
			proveedorproductoLogic.deepLoad(proveedorproducto,isDeep,deepLoadType,clases);
		}

		producto.setPrecios(productoDataAccess.getPrecios(connexion,producto));

		for(Precio precio:producto.getPrecios()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
		}

		producto.setDetalleImpuestoInvens(productoDataAccess.getDetalleImpuestoInvens(connexion,producto));

		for(DetalleImpuestoInven detalleimpuestoinven:producto.getDetalleImpuestoInvens()) {
			DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
			detalleimpuestoinvenLogic.deepLoad(detalleimpuestoinven,isDeep,deepLoadType,clases);
		}

		producto.setPresupuestoVentass(productoDataAccess.getPresupuestoVentass(connexion,producto));

		for(PresupuestoVentas presupuestoventas:producto.getPresupuestoVentass()) {
			PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
			presupuestoventasLogic.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
		}

		producto.setPoliticaProductos(productoDataAccess.getPoliticaProductos(connexion,producto));

		for(PoliticaProducto politicaproducto:producto.getPoliticaProductos()) {
			PoliticaProductoLogic politicaproductoLogic= new PoliticaProductoLogic(connexion);
			politicaproductoLogic.deepLoad(politicaproducto,isDeep,deepLoadType,clases);
		}

		producto.setSerieProductos(productoDataAccess.getSerieProductos(connexion,producto));

		for(SerieProducto serieproducto:producto.getSerieProductos()) {
			SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
			serieproductoLogic.deepLoad(serieproducto,isDeep,deepLoadType,clases);
		}

		producto.setUbicacionProdus(productoDataAccess.getUbicacionProdus(connexion,producto));

		for(UbicacionProdu ubicacionprodu:producto.getUbicacionProdus()) {
			UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
			ubicacionproduLogic.deepLoad(ubicacionprodu,isDeep,deepLoadType,clases);
		}

		producto.setParametroProductos(productoDataAccess.getParametroProductos(connexion,producto));

		for(ParametroProducto parametroproducto:producto.getParametroProductos()) {
			ParametroProductoLogic parametroproductoLogic= new ParametroProductoLogic(connexion);
			parametroproductoLogic.deepLoad(parametroproducto,isDeep,deepLoadType,clases);
		}

		producto.setProductoUnidads(productoDataAccess.getProductoUnidads(connexion,producto));

		for(ProductoUnidad productounidad:producto.getProductoUnidads()) {
			ProductoUnidadLogic productounidadLogic= new ProductoUnidadLogic(connexion);
			productounidadLogic.deepLoad(productounidad,isDeep,deepLoadType,clases);
		}

		producto.setIngredienteRelacions(productoDataAccess.getIngredienteRelacions(connexion,producto));

		for(Ingrediente ingrediente:producto.getIngredienteRelacions()) {
			IngredienteLogic ingredienteLogic= new IngredienteLogic(connexion);
			ingredienteLogic.deepLoad(ingrediente,isDeep,deepLoadType,clases);
		}

		producto.setProductoCaracs(productoDataAccess.getProductoCaracs(connexion,producto));

		for(ProductoCarac productocarac:producto.getProductoCaracs()) {
			ProductoCaracLogic productocaracLogic= new ProductoCaracLogic(connexion);
			productocaracLogic.deepLoad(productocarac,isDeep,deepLoadType,clases);
		}

		producto.setServicioClientes(productoDataAccess.getServicioClientes(connexion,producto));

		for(ServicioCliente serviciocliente:producto.getServicioClientes()) {
			ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
			servicioclienteLogic.deepLoad(serviciocliente,isDeep,deepLoadType,clases);
		}

		producto.setProductoPromocionRelacions(productoDataAccess.getProductoPromocionRelacions(connexion,producto));

		for(ProductoPromocion productopromocion:producto.getProductoPromocionRelacions()) {
			ProductoPromocionLogic productopromocionLogic= new ProductoPromocionLogic(connexion);
			productopromocionLogic.deepLoad(productopromocion,isDeep,deepLoadType,clases);
		}

		producto.setProductoEspecis(productoDataAccess.getProductoEspecis(connexion,producto));

		for(ProductoEspeci productoespeci:producto.getProductoEspecis()) {
			ProductoEspeciLogic productoespeciLogic= new ProductoEspeciLogic(connexion);
			productoespeciLogic.deepLoad(productoespeci,isDeep,deepLoadType,clases);
		}

		producto.setProductoReemplas(productoDataAccess.getProductoReemplas(connexion,producto));

		for(ProductoReempla productoreempla:producto.getProductoReemplas()) {
			ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
			productoreemplaLogic.deepLoad(productoreempla,isDeep,deepLoadType,clases);
		}

		producto.setProductoEstadisticas(productoDataAccess.getProductoEstadisticas(connexion,producto));

		for(ProductoEstadistica productoestadistica:producto.getProductoEstadisticas()) {
			ProductoEstadisticaLogic productoestadisticaLogic= new ProductoEstadisticaLogic(connexion);
			productoestadisticaLogic.deepLoad(productoestadistica,isDeep,deepLoadType,clases);
		}

		producto.setPoliticaFactus(productoDataAccess.getPoliticaFactus(connexion,producto));

		for(PoliticaFactu politicafactu:producto.getPoliticaFactus()) {
			PoliticaFactuLogic politicafactuLogic= new PoliticaFactuLogic(connexion);
			politicafactuLogic.deepLoad(politicafactu,isDeep,deepLoadType,clases);
		}

		producto.setProductoCuentaContables(productoDataAccess.getProductoCuentaContables(connexion,producto));

		for(ProductoCuentaContable productocuentacontable:producto.getProductoCuentaContables()) {
			ProductoCuentaContableLogic productocuentacontableLogic= new ProductoCuentaContableLogic(connexion);
			productocuentacontableLogic.deepLoad(productocuentacontable,isDeep,deepLoadType,clases);
		}

		producto.setBodegaProductos(productoDataAccess.getBodegaProductos(connexion,producto));

		for(BodegaProducto bodegaproducto:producto.getBodegaProductos()) {
			BodegaProductoLogic bodegaproductoLogic= new BodegaProductoLogic(connexion);
			bodegaproductoLogic.deepLoad(bodegaproducto,isDeep,deepLoadType,clases);
		}

		producto.setPresupuestoProductos(productoDataAccess.getPresupuestoProductos(connexion,producto));

		for(PresupuestoProducto presupuestoproducto:producto.getPresupuestoProductos()) {
			PresupuestoProductoLogic presupuestoproductoLogic= new PresupuestoProductoLogic(connexion);
			presupuestoproductoLogic.deepLoad(presupuestoproducto,isDeep,deepLoadType,clases);
		}

		producto.setSaldoMesProductos(productoDataAccess.getSaldoMesProductos(connexion,producto));

		for(SaldoMesProducto saldomesproducto:producto.getSaldoMesProductos()) {
			SaldoMesProductoLogic saldomesproductoLogic= new SaldoMesProductoLogic(connexion);
			saldomesproductoLogic.deepLoad(saldomesproducto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				producto.setEmpresa(productoDataAccess.getEmpresa(connexion,producto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(producto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				producto.setSucursal(productoDataAccess.getSucursal(connexion,producto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(producto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				producto.setLinea(productoDataAccess.getLinea(connexion,producto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(producto.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				producto.setLineaGrupo(productoDataAccess.getLineaGrupo(connexion,producto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(producto.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				producto.setLineaCategoria(productoDataAccess.getLineaCategoria(connexion,producto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(producto.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				producto.setLineaMarca(productoDataAccess.getLineaMarca(connexion,producto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(producto.getLineaMarca(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				producto.setTipoProductoServicio(productoDataAccess.getTipoProductoServicio(connexion,producto));
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepLoad(producto.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				producto.setTipoProductoServicioInven(productoDataAccess.getTipoProductoServicioInven(connexion,producto));
				TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
				tipoproductoservicioinvenLogic.deepLoad(producto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCosteo.class)) {
				producto.setTipoCosteo(productoDataAccess.getTipoCosteo(connexion,producto));
				TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
				tipocosteoLogic.deepLoad(producto.getTipoCosteo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				producto.setUnidad(productoDataAccess.getUnidad(connexion,producto));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(producto.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				producto.setUnidadPeso(productoDataAccess.getUnidadPeso(connexion,producto));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(producto.getUnidadPeso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Arancel.class)) {
				producto.setArancel(productoDataAccess.getArancel(connexion,producto));
				ArancelLogic arancelLogic= new ArancelLogic(connexion);
				arancelLogic.deepLoad(producto.getArancel(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				producto.setCliente(productoDataAccess.getCliente(connexion,producto));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(producto.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				producto.setClienteProveedorDefecto(productoDataAccess.getClienteProveedorDefecto(connexion,producto));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(producto.getClienteProveedorDefecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				producto.setTipoProducto(productoDataAccess.getTipoProducto(connexion,producto));
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepLoad(producto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)) {
				producto.setColorProducto(productoDataAccess.getColorProducto(connexion,producto));
				ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
				colorproductoLogic.deepLoad(producto.getColorProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)) {
				producto.setClaseProducto(productoDataAccess.getClaseProducto(connexion,producto));
				ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
				claseproductoLogic.deepLoad(producto.getClaseProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)) {
				producto.setEfectoProducto(productoDataAccess.getEfectoProducto(connexion,producto));
				EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
				efectoproductoLogic.deepLoad(producto.getEfectoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)) {
				producto.setMarcaProducto(productoDataAccess.getMarcaProducto(connexion,producto));
				MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
				marcaproductoLogic.deepLoad(producto.getMarcaProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)) {
				producto.setModeloProducto(productoDataAccess.getModeloProducto(connexion,producto));
				ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
				modeloproductoLogic.deepLoad(producto.getModeloProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)) {
				producto.setMaterialProducto(productoDataAccess.getMaterialProducto(connexion,producto));
				MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
				materialproductoLogic.deepLoad(producto.getMaterialProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)) {
				producto.setSegmentoProducto(productoDataAccess.getSegmentoProducto(connexion,producto));
				SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
				segmentoproductoLogic.deepLoad(producto.getSegmentoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)) {
				producto.setTallaProducto(productoDataAccess.getTallaProducto(connexion,producto));
				TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
				tallaproductoLogic.deepLoad(producto.getTallaProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProveedorProductos(productoDataAccess.getProveedorProductos(connexion,producto));

				for(ProveedorProducto proveedorproducto:producto.getProveedorProductos()) {
					ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
					proveedorproductoLogic.deepLoad(proveedorproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPrecios(productoDataAccess.getPrecios(connexion,producto));

				for(Precio precio:producto.getPrecios()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setDetalleImpuestoInvens(productoDataAccess.getDetalleImpuestoInvens(connexion,producto));

				for(DetalleImpuestoInven detalleimpuestoinven:producto.getDetalleImpuestoInvens()) {
					DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
					detalleimpuestoinvenLogic.deepLoad(detalleimpuestoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPresupuestoVentass(productoDataAccess.getPresupuestoVentass(connexion,producto));

				for(PresupuestoVentas presupuestoventas:producto.getPresupuestoVentass()) {
					PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
					presupuestoventasLogic.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPoliticaProductos(productoDataAccess.getPoliticaProductos(connexion,producto));

				for(PoliticaProducto politicaproducto:producto.getPoliticaProductos()) {
					PoliticaProductoLogic politicaproductoLogic= new PoliticaProductoLogic(connexion);
					politicaproductoLogic.deepLoad(politicaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setSerieProductos(productoDataAccess.getSerieProductos(connexion,producto));

				for(SerieProducto serieproducto:producto.getSerieProductos()) {
					SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
					serieproductoLogic.deepLoad(serieproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setUbicacionProdus(productoDataAccess.getUbicacionProdus(connexion,producto));

				for(UbicacionProdu ubicacionprodu:producto.getUbicacionProdus()) {
					UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
					ubicacionproduLogic.deepLoad(ubicacionprodu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setParametroProductos(productoDataAccess.getParametroProductos(connexion,producto));

				for(ParametroProducto parametroproducto:producto.getParametroProductos()) {
					ParametroProductoLogic parametroproductoLogic= new ParametroProductoLogic(connexion);
					parametroproductoLogic.deepLoad(parametroproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoUnidads(productoDataAccess.getProductoUnidads(connexion,producto));

				for(ProductoUnidad productounidad:producto.getProductoUnidads()) {
					ProductoUnidadLogic productounidadLogic= new ProductoUnidadLogic(connexion);
					productounidadLogic.deepLoad(productounidad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Ingrediente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setIngredienteRelacions(productoDataAccess.getIngredienteRelacions(connexion,producto));

				for(Ingrediente ingrediente:producto.getIngredienteRelacions()) {
					IngredienteLogic ingredienteLogic= new IngredienteLogic(connexion);
					ingredienteLogic.deepLoad(ingrediente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoCarac.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoCaracs(productoDataAccess.getProductoCaracs(connexion,producto));

				for(ProductoCarac productocarac:producto.getProductoCaracs()) {
					ProductoCaracLogic productocaracLogic= new ProductoCaracLogic(connexion);
					productocaracLogic.deepLoad(productocarac,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setServicioClientes(productoDataAccess.getServicioClientes(connexion,producto));

				for(ServicioCliente serviciocliente:producto.getServicioClientes()) {
					ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
					servicioclienteLogic.deepLoad(serviciocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoPromocion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoPromocionRelacions(productoDataAccess.getProductoPromocionRelacions(connexion,producto));

				for(ProductoPromocion productopromocion:producto.getProductoPromocionRelacions()) {
					ProductoPromocionLogic productopromocionLogic= new ProductoPromocionLogic(connexion);
					productopromocionLogic.deepLoad(productopromocion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoEspeci.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoEspecis(productoDataAccess.getProductoEspecis(connexion,producto));

				for(ProductoEspeci productoespeci:producto.getProductoEspecis()) {
					ProductoEspeciLogic productoespeciLogic= new ProductoEspeciLogic(connexion);
					productoespeciLogic.deepLoad(productoespeci,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoReemplas(productoDataAccess.getProductoReemplas(connexion,producto));

				for(ProductoReempla productoreempla:producto.getProductoReemplas()) {
					ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
					productoreemplaLogic.deepLoad(productoreempla,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoEstadistica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoEstadisticas(productoDataAccess.getProductoEstadisticas(connexion,producto));

				for(ProductoEstadistica productoestadistica:producto.getProductoEstadisticas()) {
					ProductoEstadisticaLogic productoestadisticaLogic= new ProductoEstadisticaLogic(connexion);
					productoestadisticaLogic.deepLoad(productoestadistica,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticaFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPoliticaFactus(productoDataAccess.getPoliticaFactus(connexion,producto));

				for(PoliticaFactu politicafactu:producto.getPoliticaFactus()) {
					PoliticaFactuLogic politicafactuLogic= new PoliticaFactuLogic(connexion);
					politicafactuLogic.deepLoad(politicafactu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setProductoCuentaContables(productoDataAccess.getProductoCuentaContables(connexion,producto));

				for(ProductoCuentaContable productocuentacontable:producto.getProductoCuentaContables()) {
					ProductoCuentaContableLogic productocuentacontableLogic= new ProductoCuentaContableLogic(connexion);
					productocuentacontableLogic.deepLoad(productocuentacontable,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(BodegaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setBodegaProductos(productoDataAccess.getBodegaProductos(connexion,producto));

				for(BodegaProducto bodegaproducto:producto.getBodegaProductos()) {
					BodegaProductoLogic bodegaproductoLogic= new BodegaProductoLogic(connexion);
					bodegaproductoLogic.deepLoad(bodegaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setPresupuestoProductos(productoDataAccess.getPresupuestoProductos(connexion,producto));

				for(PresupuestoProducto presupuestoproducto:producto.getPresupuestoProductos()) {
					PresupuestoProductoLogic presupuestoproductoLogic= new PresupuestoProductoLogic(connexion);
					presupuestoproductoLogic.deepLoad(presupuestoproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SaldoMesProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				producto.setSaldoMesProductos(productoDataAccess.getSaldoMesProductos(connexion,producto));

				for(SaldoMesProducto saldomesproducto:producto.getSaldoMesProductos()) {
					SaldoMesProductoLogic saldomesproductoLogic= new SaldoMesProductoLogic(connexion);
					saldomesproductoLogic.deepLoad(saldomesproducto,isDeep,deepLoadType,clases);
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
			producto.setEmpresa(productoDataAccess.getEmpresa(connexion,producto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(producto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setSucursal(productoDataAccess.getSucursal(connexion,producto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(producto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setLinea(productoDataAccess.getLinea(connexion,producto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(producto.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setLineaGrupo(productoDataAccess.getLineaGrupo(connexion,producto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(producto.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setLineaCategoria(productoDataAccess.getLineaCategoria(connexion,producto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(producto.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setLineaMarca(productoDataAccess.getLineaMarca(connexion,producto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(producto.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTipoProductoServicio(productoDataAccess.getTipoProductoServicio(connexion,producto));
			TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
			tipoproductoservicioLogic.deepLoad(producto.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTipoProductoServicioInven(productoDataAccess.getTipoProductoServicioInven(connexion,producto));
			TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
			tipoproductoservicioinvenLogic.deepLoad(producto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCosteo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTipoCosteo(productoDataAccess.getTipoCosteo(connexion,producto));
			TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
			tipocosteoLogic.deepLoad(producto.getTipoCosteo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setUnidad(productoDataAccess.getUnidad(connexion,producto));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(producto.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setUnidadPeso(productoDataAccess.getUnidadPeso(connexion,producto));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(producto.getUnidadPeso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Arancel.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setArancel(productoDataAccess.getArancel(connexion,producto));
			ArancelLogic arancelLogic= new ArancelLogic(connexion);
			arancelLogic.deepLoad(producto.getArancel(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setCliente(productoDataAccess.getCliente(connexion,producto));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(producto.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setClienteProveedorDefecto(productoDataAccess.getClienteProveedorDefecto(connexion,producto));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(producto.getClienteProveedorDefecto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTipoProducto(productoDataAccess.getTipoProducto(connexion,producto));
			TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
			tipoproductoLogic.deepLoad(producto.getTipoProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ColorProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setColorProducto(productoDataAccess.getColorProducto(connexion,producto));
			ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
			colorproductoLogic.deepLoad(producto.getColorProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ClaseProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setClaseProducto(productoDataAccess.getClaseProducto(connexion,producto));
			ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
			claseproductoLogic.deepLoad(producto.getClaseProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EfectoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setEfectoProducto(productoDataAccess.getEfectoProducto(connexion,producto));
			EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
			efectoproductoLogic.deepLoad(producto.getEfectoProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(MarcaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setMarcaProducto(productoDataAccess.getMarcaProducto(connexion,producto));
			MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
			marcaproductoLogic.deepLoad(producto.getMarcaProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ModeloProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setModeloProducto(productoDataAccess.getModeloProducto(connexion,producto));
			ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
			modeloproductoLogic.deepLoad(producto.getModeloProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(MaterialProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setMaterialProducto(productoDataAccess.getMaterialProducto(connexion,producto));
			MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
			materialproductoLogic.deepLoad(producto.getMaterialProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SegmentoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setSegmentoProducto(productoDataAccess.getSegmentoProducto(connexion,producto));
			SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
			segmentoproductoLogic.deepLoad(producto.getSegmentoProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TallaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			producto.setTallaProducto(productoDataAccess.getTallaProducto(connexion,producto));
			TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
			tallaproductoLogic.deepLoad(producto.getTallaProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProveedorProducto.class));
			producto.setProveedorProductos(productoDataAccess.getProveedorProductos(connexion,producto));

			for(ProveedorProducto proveedorproducto:producto.getProveedorProductos()) {
				ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
				proveedorproductoLogic.deepLoad(proveedorproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			producto.setPrecios(productoDataAccess.getPrecios(connexion,producto));

			for(Precio precio:producto.getPrecios()) {
				PrecioLogic precioLogic= new PrecioLogic(connexion);
				precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleImpuestoInven.class));
			producto.setDetalleImpuestoInvens(productoDataAccess.getDetalleImpuestoInvens(connexion,producto));

			for(DetalleImpuestoInven detalleimpuestoinven:producto.getDetalleImpuestoInvens()) {
				DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
				detalleimpuestoinvenLogic.deepLoad(detalleimpuestoinven,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentas.class));
			producto.setPresupuestoVentass(productoDataAccess.getPresupuestoVentass(connexion,producto));

			for(PresupuestoVentas presupuestoventas:producto.getPresupuestoVentass()) {
				PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
				presupuestoventasLogic.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticaProducto.class));
			producto.setPoliticaProductos(productoDataAccess.getPoliticaProductos(connexion,producto));

			for(PoliticaProducto politicaproducto:producto.getPoliticaProductos()) {
				PoliticaProductoLogic politicaproductoLogic= new PoliticaProductoLogic(connexion);
				politicaproductoLogic.deepLoad(politicaproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SerieProducto.class));
			producto.setSerieProductos(productoDataAccess.getSerieProductos(connexion,producto));

			for(SerieProducto serieproducto:producto.getSerieProductos()) {
				SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
				serieproductoLogic.deepLoad(serieproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UbicacionProdu.class));
			producto.setUbicacionProdus(productoDataAccess.getUbicacionProdus(connexion,producto));

			for(UbicacionProdu ubicacionprodu:producto.getUbicacionProdus()) {
				UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
				ubicacionproduLogic.deepLoad(ubicacionprodu,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroProducto.class));
			producto.setParametroProductos(productoDataAccess.getParametroProductos(connexion,producto));

			for(ParametroProducto parametroproducto:producto.getParametroProductos()) {
				ParametroProductoLogic parametroproductoLogic= new ParametroProductoLogic(connexion);
				parametroproductoLogic.deepLoad(parametroproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoUnidad.class));
			producto.setProductoUnidads(productoDataAccess.getProductoUnidads(connexion,producto));

			for(ProductoUnidad productounidad:producto.getProductoUnidads()) {
				ProductoUnidadLogic productounidadLogic= new ProductoUnidadLogic(connexion);
				productounidadLogic.deepLoad(productounidad,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ingrediente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Ingrediente.class));
			producto.setIngredienteRelacions(productoDataAccess.getIngredienteRelacions(connexion,producto));

			for(Ingrediente ingrediente:producto.getIngredienteRelacions()) {
				IngredienteLogic ingredienteLogic= new IngredienteLogic(connexion);
				ingredienteLogic.deepLoad(ingrediente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoCarac.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoCarac.class));
			producto.setProductoCaracs(productoDataAccess.getProductoCaracs(connexion,producto));

			for(ProductoCarac productocarac:producto.getProductoCaracs()) {
				ProductoCaracLogic productocaracLogic= new ProductoCaracLogic(connexion);
				productocaracLogic.deepLoad(productocarac,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioCliente.class));
			producto.setServicioClientes(productoDataAccess.getServicioClientes(connexion,producto));

			for(ServicioCliente serviciocliente:producto.getServicioClientes()) {
				ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
				servicioclienteLogic.deepLoad(serviciocliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoPromocion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoPromocion.class));
			producto.setProductoPromocionRelacions(productoDataAccess.getProductoPromocionRelacions(connexion,producto));

			for(ProductoPromocion productopromocion:producto.getProductoPromocionRelacions()) {
				ProductoPromocionLogic productopromocionLogic= new ProductoPromocionLogic(connexion);
				productopromocionLogic.deepLoad(productopromocion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoEspeci.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoEspeci.class));
			producto.setProductoEspecis(productoDataAccess.getProductoEspecis(connexion,producto));

			for(ProductoEspeci productoespeci:producto.getProductoEspecis()) {
				ProductoEspeciLogic productoespeciLogic= new ProductoEspeciLogic(connexion);
				productoespeciLogic.deepLoad(productoespeci,isDeep,deepLoadType,clases);
			}
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
			producto.setProductoReemplas(productoDataAccess.getProductoReemplas(connexion,producto));

			for(ProductoReempla productoreempla:producto.getProductoReemplas()) {
				ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
				productoreemplaLogic.deepLoad(productoreempla,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoEstadistica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoEstadistica.class));
			producto.setProductoEstadisticas(productoDataAccess.getProductoEstadisticas(connexion,producto));

			for(ProductoEstadistica productoestadistica:producto.getProductoEstadisticas()) {
				ProductoEstadisticaLogic productoestadisticaLogic= new ProductoEstadisticaLogic(connexion);
				productoestadisticaLogic.deepLoad(productoestadistica,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticaFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticaFactu.class));
			producto.setPoliticaFactus(productoDataAccess.getPoliticaFactus(connexion,producto));

			for(PoliticaFactu politicafactu:producto.getPoliticaFactus()) {
				PoliticaFactuLogic politicafactuLogic= new PoliticaFactuLogic(connexion);
				politicafactuLogic.deepLoad(politicafactu,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoCuentaContable.class));
			producto.setProductoCuentaContables(productoDataAccess.getProductoCuentaContables(connexion,producto));

			for(ProductoCuentaContable productocuentacontable:producto.getProductoCuentaContables()) {
				ProductoCuentaContableLogic productocuentacontableLogic= new ProductoCuentaContableLogic(connexion);
				productocuentacontableLogic.deepLoad(productocuentacontable,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(BodegaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(BodegaProducto.class));
			producto.setBodegaProductos(productoDataAccess.getBodegaProductos(connexion,producto));

			for(BodegaProducto bodegaproducto:producto.getBodegaProductos()) {
				BodegaProductoLogic bodegaproductoLogic= new BodegaProductoLogic(connexion);
				bodegaproductoLogic.deepLoad(bodegaproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoProducto.class));
			producto.setPresupuestoProductos(productoDataAccess.getPresupuestoProductos(connexion,producto));

			for(PresupuestoProducto presupuestoproducto:producto.getPresupuestoProductos()) {
				PresupuestoProductoLogic presupuestoproductoLogic= new PresupuestoProductoLogic(connexion);
				presupuestoproductoLogic.deepLoad(presupuestoproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SaldoMesProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SaldoMesProducto.class));
			producto.setSaldoMesProductos(productoDataAccess.getSaldoMesProductos(connexion,producto));

			for(SaldoMesProducto saldomesproducto:producto.getSaldoMesProductos()) {
				SaldoMesProductoLogic saldomesproductoLogic= new SaldoMesProductoLogic(connexion);
				saldomesproductoLogic.deepLoad(saldomesproducto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Producto producto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoLogicAdditional.updateProductoToSave(producto,this.arrDatoGeneral);
			
ProductoDataAccess.save(producto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(producto.getEmpresa(),connexion);

		SucursalDataAccess.save(producto.getSucursal(),connexion);

		LineaDataAccess.save(producto.getLinea(),connexion);

		LineaDataAccess.save(producto.getLineaGrupo(),connexion);

		LineaDataAccess.save(producto.getLineaCategoria(),connexion);

		LineaDataAccess.save(producto.getLineaMarca(),connexion);

		TipoProductoServicioDataAccess.save(producto.getTipoProductoServicio(),connexion);

		TipoProductoServicioInvenDataAccess.save(producto.getTipoProductoServicioInven(),connexion);

		TipoCosteoDataAccess.save(producto.getTipoCosteo(),connexion);

		UnidadDataAccess.save(producto.getUnidad(),connexion);

		UnidadDataAccess.save(producto.getUnidadPeso(),connexion);

		ArancelDataAccess.save(producto.getArancel(),connexion);

		ClienteDataAccess.save(producto.getCliente(),connexion);

		ClienteDataAccess.save(producto.getClienteProveedorDefecto(),connexion);

		TipoProductoDataAccess.save(producto.getTipoProducto(),connexion);

		ColorProductoDataAccess.save(producto.getColorProducto(),connexion);

		ClaseProductoDataAccess.save(producto.getClaseProducto(),connexion);

		EfectoProductoDataAccess.save(producto.getEfectoProducto(),connexion);

		MarcaProductoDataAccess.save(producto.getMarcaProducto(),connexion);

		ModeloProductoDataAccess.save(producto.getModeloProducto(),connexion);

		MaterialProductoDataAccess.save(producto.getMaterialProducto(),connexion);

		SegmentoProductoDataAccess.save(producto.getSegmentoProducto(),connexion);

		TallaProductoDataAccess.save(producto.getTallaProducto(),connexion);

		for(ProveedorProducto proveedorproducto:producto.getProveedorProductos()) {
			proveedorproducto.setid_producto(producto.getId());
			ProveedorProductoDataAccess.save(proveedorproducto,connexion);
		}

		for(Precio precio:producto.getPrecios()) {
			precio.setid_producto(producto.getId());
			PrecioDataAccess.save(precio,connexion);
		}

		for(DetalleImpuestoInven detalleimpuestoinven:producto.getDetalleImpuestoInvens()) {
			detalleimpuestoinven.setid_producto(producto.getId());
			DetalleImpuestoInvenDataAccess.save(detalleimpuestoinven,connexion);
		}

		for(PresupuestoVentas presupuestoventas:producto.getPresupuestoVentass()) {
			presupuestoventas.setid_producto(producto.getId());
			PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
		}

		for(PoliticaProducto politicaproducto:producto.getPoliticaProductos()) {
			politicaproducto.setid_producto(producto.getId());
			PoliticaProductoDataAccess.save(politicaproducto,connexion);
		}

		for(SerieProducto serieproducto:producto.getSerieProductos()) {
			serieproducto.setid_producto(producto.getId());
			SerieProductoDataAccess.save(serieproducto,connexion);
		}

		for(UbicacionProdu ubicacionprodu:producto.getUbicacionProdus()) {
			ubicacionprodu.setid_producto(producto.getId());
			UbicacionProduDataAccess.save(ubicacionprodu,connexion);
		}

		for(ParametroProducto parametroproducto:producto.getParametroProductos()) {
			parametroproducto.setid_producto(producto.getId());
			ParametroProductoDataAccess.save(parametroproducto,connexion);
		}

		for(ProductoUnidad productounidad:producto.getProductoUnidads()) {
			productounidad.setid_producto(producto.getId());
			ProductoUnidadDataAccess.save(productounidad,connexion);
		}

		for(Ingrediente ingrediente:producto.getIngredienteRelacions()) {
			ingrediente.setid_producto_relacion(producto.getId());
			IngredienteDataAccess.save(ingrediente,connexion);
		}

		for(ProductoCarac productocarac:producto.getProductoCaracs()) {
			productocarac.setid_producto(producto.getId());
			ProductoCaracDataAccess.save(productocarac,connexion);
		}

		for(ServicioCliente serviciocliente:producto.getServicioClientes()) {
			serviciocliente.setid_producto(producto.getId());
			ServicioClienteDataAccess.save(serviciocliente,connexion);
		}

		for(ProductoPromocion productopromocion:producto.getProductoPromocionRelacions()) {
			productopromocion.setid_producto_relacion(producto.getId());
			ProductoPromocionDataAccess.save(productopromocion,connexion);
		}

		for(ProductoEspeci productoespeci:producto.getProductoEspecis()) {
			productoespeci.setid_producto(producto.getId());
			ProductoEspeciDataAccess.save(productoespeci,connexion);
		}

		for(ProductoReempla productoreempla:producto.getProductoReemplas()) {
			productoreempla.setid_producto(producto.getId());
			ProductoReemplaDataAccess.save(productoreempla,connexion);
		}

		for(ProductoEstadistica productoestadistica:producto.getProductoEstadisticas()) {
			productoestadistica.setid_producto(producto.getId());
			ProductoEstadisticaDataAccess.save(productoestadistica,connexion);
		}

		for(PoliticaFactu politicafactu:producto.getPoliticaFactus()) {
			politicafactu.setid_producto(producto.getId());
			PoliticaFactuDataAccess.save(politicafactu,connexion);
		}

		for(ProductoCuentaContable productocuentacontable:producto.getProductoCuentaContables()) {
			productocuentacontable.setid_producto(producto.getId());
			ProductoCuentaContableDataAccess.save(productocuentacontable,connexion);
		}

		for(BodegaProducto bodegaproducto:producto.getBodegaProductos()) {
			bodegaproducto.setid_producto(producto.getId());
			BodegaProductoDataAccess.save(bodegaproducto,connexion);
		}

		for(PresupuestoProducto presupuestoproducto:producto.getPresupuestoProductos()) {
			presupuestoproducto.setid_producto(producto.getId());
			PresupuestoProductoDataAccess.save(presupuestoproducto,connexion);
		}

		for(SaldoMesProducto saldomesproducto:producto.getSaldoMesProductos()) {
			saldomesproducto.setid_producto(producto.getId());
			SaldoMesProductoDataAccess.save(saldomesproducto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(producto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(producto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(producto.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(producto.getLineaGrupo(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(producto.getLineaCategoria(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(producto.getLineaMarca(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				TipoProductoServicioDataAccess.save(producto.getTipoProductoServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				TipoProductoServicioInvenDataAccess.save(producto.getTipoProductoServicioInven(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCosteo.class)) {
				TipoCosteoDataAccess.save(producto.getTipoCosteo(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(producto.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(producto.getUnidadPeso(),connexion);
				continue;
			}

			if(clas.clas.equals(Arancel.class)) {
				ArancelDataAccess.save(producto.getArancel(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(producto.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(producto.getClienteProveedorDefecto(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(producto.getTipoProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)) {
				ColorProductoDataAccess.save(producto.getColorProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)) {
				ClaseProductoDataAccess.save(producto.getClaseProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)) {
				EfectoProductoDataAccess.save(producto.getEfectoProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)) {
				MarcaProductoDataAccess.save(producto.getMarcaProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)) {
				ModeloProductoDataAccess.save(producto.getModeloProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)) {
				MaterialProductoDataAccess.save(producto.getMaterialProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)) {
				SegmentoProductoDataAccess.save(producto.getSegmentoProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)) {
				TallaProductoDataAccess.save(producto.getTallaProducto(),connexion);
				continue;
			}


			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProveedorProducto proveedorproducto:producto.getProveedorProductos()) {
					proveedorproducto.setid_producto(producto.getId());
					ProveedorProductoDataAccess.save(proveedorproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:producto.getPrecios()) {
					precio.setid_producto(producto.getId());
					PrecioDataAccess.save(precio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleImpuestoInven detalleimpuestoinven:producto.getDetalleImpuestoInvens()) {
					detalleimpuestoinven.setid_producto(producto.getId());
					DetalleImpuestoInvenDataAccess.save(detalleimpuestoinven,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentas presupuestoventas:producto.getPresupuestoVentass()) {
					presupuestoventas.setid_producto(producto.getId());
					PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PoliticaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticaProducto politicaproducto:producto.getPoliticaProductos()) {
					politicaproducto.setid_producto(producto.getId());
					PoliticaProductoDataAccess.save(politicaproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SerieProducto serieproducto:producto.getSerieProductos()) {
					serieproducto.setid_producto(producto.getId());
					SerieProductoDataAccess.save(serieproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UbicacionProdu ubicacionprodu:producto.getUbicacionProdus()) {
					ubicacionprodu.setid_producto(producto.getId());
					UbicacionProduDataAccess.save(ubicacionprodu,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroProducto parametroproducto:producto.getParametroProductos()) {
					parametroproducto.setid_producto(producto.getId());
					ParametroProductoDataAccess.save(parametroproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoUnidad productounidad:producto.getProductoUnidads()) {
					productounidad.setid_producto(producto.getId());
					ProductoUnidadDataAccess.save(productounidad,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Ingrediente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Ingrediente ingrediente:producto.getIngredienteRelacions()) {
					ingrediente.setid_producto_relacion(producto.getId());
					IngredienteDataAccess.save(ingrediente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoCarac.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoCarac productocarac:producto.getProductoCaracs()) {
					productocarac.setid_producto(producto.getId());
					ProductoCaracDataAccess.save(productocarac,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioCliente serviciocliente:producto.getServicioClientes()) {
					serviciocliente.setid_producto(producto.getId());
					ServicioClienteDataAccess.save(serviciocliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoPromocion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoPromocion productopromocion:producto.getProductoPromocionRelacions()) {
					productopromocion.setid_producto_relacion(producto.getId());
					ProductoPromocionDataAccess.save(productopromocion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoEspeci.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoEspeci productoespeci:producto.getProductoEspecis()) {
					productoespeci.setid_producto(producto.getId());
					ProductoEspeciDataAccess.save(productoespeci,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoReempla productoreempla:producto.getProductoReemplas()) {
					productoreempla.setid_producto(producto.getId());
					ProductoReemplaDataAccess.save(productoreempla,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoEstadistica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoEstadistica productoestadistica:producto.getProductoEstadisticas()) {
					productoestadistica.setid_producto(producto.getId());
					ProductoEstadisticaDataAccess.save(productoestadistica,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PoliticaFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticaFactu politicafactu:producto.getPoliticaFactus()) {
					politicafactu.setid_producto(producto.getId());
					PoliticaFactuDataAccess.save(politicafactu,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoCuentaContable productocuentacontable:producto.getProductoCuentaContables()) {
					productocuentacontable.setid_producto(producto.getId());
					ProductoCuentaContableDataAccess.save(productocuentacontable,connexion);
				}
				continue;
			}

			if(clas.clas.equals(BodegaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(BodegaProducto bodegaproducto:producto.getBodegaProductos()) {
					bodegaproducto.setid_producto(producto.getId());
					BodegaProductoDataAccess.save(bodegaproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoProducto presupuestoproducto:producto.getPresupuestoProductos()) {
					presupuestoproducto.setid_producto(producto.getId());
					PresupuestoProductoDataAccess.save(presupuestoproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SaldoMesProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SaldoMesProducto saldomesproducto:producto.getSaldoMesProductos()) {
					saldomesproducto.setid_producto(producto.getId());
					SaldoMesProductoDataAccess.save(saldomesproducto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(producto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(producto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(producto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(producto.getSucursal(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(producto.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(producto.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(producto.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(producto.getLineaGrupo(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(producto.getLineaCategoria(),connexion);
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(producto.getLineaCategoria(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(producto.getLineaMarca(),connexion);
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(producto.getLineaMarca(),isDeep,deepLoadType,clases);
				

		TipoProductoServicioDataAccess.save(producto.getTipoProductoServicio(),connexion);
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(producto.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				

		TipoProductoServicioInvenDataAccess.save(producto.getTipoProductoServicioInven(),connexion);
		TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
		tipoproductoservicioinvenLogic.deepLoad(producto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);
				

		TipoCosteoDataAccess.save(producto.getTipoCosteo(),connexion);
		TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
		tipocosteoLogic.deepLoad(producto.getTipoCosteo(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(producto.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(producto.getUnidad(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(producto.getUnidadPeso(),connexion);
		UnidadLogic unidadpesoLogic= new UnidadLogic(connexion);
		unidadpesoLogic.deepLoad(producto.getUnidadPeso(),isDeep,deepLoadType,clases);
				

		ArancelDataAccess.save(producto.getArancel(),connexion);
		ArancelLogic arancelLogic= new ArancelLogic(connexion);
		arancelLogic.deepLoad(producto.getArancel(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(producto.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(producto.getCliente(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(producto.getClienteProveedorDefecto(),connexion);
		ClienteLogic clienteproveedordefectoLogic= new ClienteLogic(connexion);
		clienteproveedordefectoLogic.deepLoad(producto.getClienteProveedorDefecto(),isDeep,deepLoadType,clases);
				

		TipoProductoDataAccess.save(producto.getTipoProducto(),connexion);
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(producto.getTipoProducto(),isDeep,deepLoadType,clases);
				

		ColorProductoDataAccess.save(producto.getColorProducto(),connexion);
		ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
		colorproductoLogic.deepLoad(producto.getColorProducto(),isDeep,deepLoadType,clases);
				

		ClaseProductoDataAccess.save(producto.getClaseProducto(),connexion);
		ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
		claseproductoLogic.deepLoad(producto.getClaseProducto(),isDeep,deepLoadType,clases);
				

		EfectoProductoDataAccess.save(producto.getEfectoProducto(),connexion);
		EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
		efectoproductoLogic.deepLoad(producto.getEfectoProducto(),isDeep,deepLoadType,clases);
				

		MarcaProductoDataAccess.save(producto.getMarcaProducto(),connexion);
		MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
		marcaproductoLogic.deepLoad(producto.getMarcaProducto(),isDeep,deepLoadType,clases);
				

		ModeloProductoDataAccess.save(producto.getModeloProducto(),connexion);
		ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
		modeloproductoLogic.deepLoad(producto.getModeloProducto(),isDeep,deepLoadType,clases);
				

		MaterialProductoDataAccess.save(producto.getMaterialProducto(),connexion);
		MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
		materialproductoLogic.deepLoad(producto.getMaterialProducto(),isDeep,deepLoadType,clases);
				

		SegmentoProductoDataAccess.save(producto.getSegmentoProducto(),connexion);
		SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
		segmentoproductoLogic.deepLoad(producto.getSegmentoProducto(),isDeep,deepLoadType,clases);
				

		TallaProductoDataAccess.save(producto.getTallaProducto(),connexion);
		TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
		tallaproductoLogic.deepLoad(producto.getTallaProducto(),isDeep,deepLoadType,clases);
				

		for(ProveedorProducto proveedorproducto:producto.getProveedorProductos()) {
			ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
			proveedorproducto.setid_producto(producto.getId());
			ProveedorProductoDataAccess.save(proveedorproducto,connexion);
			proveedorproductoLogic.deepSave(proveedorproducto,isDeep,deepLoadType,clases);
		}

		for(Precio precio:producto.getPrecios()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precio.setid_producto(producto.getId());
			PrecioDataAccess.save(precio,connexion);
			precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
		}

		for(DetalleImpuestoInven detalleimpuestoinven:producto.getDetalleImpuestoInvens()) {
			DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
			detalleimpuestoinven.setid_producto(producto.getId());
			DetalleImpuestoInvenDataAccess.save(detalleimpuestoinven,connexion);
			detalleimpuestoinvenLogic.deepSave(detalleimpuestoinven,isDeep,deepLoadType,clases);
		}

		for(PresupuestoVentas presupuestoventas:producto.getPresupuestoVentass()) {
			PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
			presupuestoventas.setid_producto(producto.getId());
			PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
			presupuestoventasLogic.deepSave(presupuestoventas,isDeep,deepLoadType,clases);
		}

		for(PoliticaProducto politicaproducto:producto.getPoliticaProductos()) {
			PoliticaProductoLogic politicaproductoLogic= new PoliticaProductoLogic(connexion);
			politicaproducto.setid_producto(producto.getId());
			PoliticaProductoDataAccess.save(politicaproducto,connexion);
			politicaproductoLogic.deepSave(politicaproducto,isDeep,deepLoadType,clases);
		}

		for(SerieProducto serieproducto:producto.getSerieProductos()) {
			SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
			serieproducto.setid_producto(producto.getId());
			SerieProductoDataAccess.save(serieproducto,connexion);
			serieproductoLogic.deepSave(serieproducto,isDeep,deepLoadType,clases);
		}

		for(UbicacionProdu ubicacionprodu:producto.getUbicacionProdus()) {
			UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
			ubicacionprodu.setid_producto(producto.getId());
			UbicacionProduDataAccess.save(ubicacionprodu,connexion);
			ubicacionproduLogic.deepSave(ubicacionprodu,isDeep,deepLoadType,clases);
		}

		for(ParametroProducto parametroproducto:producto.getParametroProductos()) {
			ParametroProductoLogic parametroproductoLogic= new ParametroProductoLogic(connexion);
			parametroproducto.setid_producto(producto.getId());
			ParametroProductoDataAccess.save(parametroproducto,connexion);
			parametroproductoLogic.deepSave(parametroproducto,isDeep,deepLoadType,clases);
		}

		for(ProductoUnidad productounidad:producto.getProductoUnidads()) {
			ProductoUnidadLogic productounidadLogic= new ProductoUnidadLogic(connexion);
			productounidad.setid_producto(producto.getId());
			ProductoUnidadDataAccess.save(productounidad,connexion);
			productounidadLogic.deepSave(productounidad,isDeep,deepLoadType,clases);
		}

		for(Ingrediente ingrediente:producto.getIngredienteRelacions()) {
			IngredienteLogic ingredienteLogic= new IngredienteLogic(connexion);
			ingrediente.setid_producto_relacion(producto.getId());
			IngredienteDataAccess.save(ingrediente,connexion);
			ingredienteLogic.deepSave(ingrediente,isDeep,deepLoadType,clases);
		}

		for(ProductoCarac productocarac:producto.getProductoCaracs()) {
			ProductoCaracLogic productocaracLogic= new ProductoCaracLogic(connexion);
			productocarac.setid_producto(producto.getId());
			ProductoCaracDataAccess.save(productocarac,connexion);
			productocaracLogic.deepSave(productocarac,isDeep,deepLoadType,clases);
		}

		for(ServicioCliente serviciocliente:producto.getServicioClientes()) {
			ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
			serviciocliente.setid_producto(producto.getId());
			ServicioClienteDataAccess.save(serviciocliente,connexion);
			servicioclienteLogic.deepSave(serviciocliente,isDeep,deepLoadType,clases);
		}

		for(ProductoPromocion productopromocion:producto.getProductoPromocionRelacions()) {
			ProductoPromocionLogic productopromocionLogic= new ProductoPromocionLogic(connexion);
			productopromocion.setid_producto_relacion(producto.getId());
			ProductoPromocionDataAccess.save(productopromocion,connexion);
			productopromocionLogic.deepSave(productopromocion,isDeep,deepLoadType,clases);
		}

		for(ProductoEspeci productoespeci:producto.getProductoEspecis()) {
			ProductoEspeciLogic productoespeciLogic= new ProductoEspeciLogic(connexion);
			productoespeci.setid_producto(producto.getId());
			ProductoEspeciDataAccess.save(productoespeci,connexion);
			productoespeciLogic.deepSave(productoespeci,isDeep,deepLoadType,clases);
		}

		for(ProductoReempla productoreempla:producto.getProductoReemplas()) {
			ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
			productoreempla.setid_producto(producto.getId());
			ProductoReemplaDataAccess.save(productoreempla,connexion);
			productoreemplaLogic.deepSave(productoreempla,isDeep,deepLoadType,clases);
		}

		for(ProductoEstadistica productoestadistica:producto.getProductoEstadisticas()) {
			ProductoEstadisticaLogic productoestadisticaLogic= new ProductoEstadisticaLogic(connexion);
			productoestadistica.setid_producto(producto.getId());
			ProductoEstadisticaDataAccess.save(productoestadistica,connexion);
			productoestadisticaLogic.deepSave(productoestadistica,isDeep,deepLoadType,clases);
		}

		for(PoliticaFactu politicafactu:producto.getPoliticaFactus()) {
			PoliticaFactuLogic politicafactuLogic= new PoliticaFactuLogic(connexion);
			politicafactu.setid_producto(producto.getId());
			PoliticaFactuDataAccess.save(politicafactu,connexion);
			politicafactuLogic.deepSave(politicafactu,isDeep,deepLoadType,clases);
		}

		for(ProductoCuentaContable productocuentacontable:producto.getProductoCuentaContables()) {
			ProductoCuentaContableLogic productocuentacontableLogic= new ProductoCuentaContableLogic(connexion);
			productocuentacontable.setid_producto(producto.getId());
			ProductoCuentaContableDataAccess.save(productocuentacontable,connexion);
			productocuentacontableLogic.deepSave(productocuentacontable,isDeep,deepLoadType,clases);
		}

		for(BodegaProducto bodegaproducto:producto.getBodegaProductos()) {
			BodegaProductoLogic bodegaproductoLogic= new BodegaProductoLogic(connexion);
			bodegaproducto.setid_producto(producto.getId());
			BodegaProductoDataAccess.save(bodegaproducto,connexion);
			bodegaproductoLogic.deepSave(bodegaproducto,isDeep,deepLoadType,clases);
		}

		for(PresupuestoProducto presupuestoproducto:producto.getPresupuestoProductos()) {
			PresupuestoProductoLogic presupuestoproductoLogic= new PresupuestoProductoLogic(connexion);
			presupuestoproducto.setid_producto(producto.getId());
			PresupuestoProductoDataAccess.save(presupuestoproducto,connexion);
			presupuestoproductoLogic.deepSave(presupuestoproducto,isDeep,deepLoadType,clases);
		}

		for(SaldoMesProducto saldomesproducto:producto.getSaldoMesProductos()) {
			SaldoMesProductoLogic saldomesproductoLogic= new SaldoMesProductoLogic(connexion);
			saldomesproducto.setid_producto(producto.getId());
			SaldoMesProductoDataAccess.save(saldomesproducto,connexion);
			saldomesproductoLogic.deepSave(saldomesproducto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(producto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(producto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(producto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(producto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(producto.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(producto.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(producto.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(producto.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(producto.getLineaCategoria(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(producto.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(producto.getLineaMarca(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(producto.getLineaMarca(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				TipoProductoServicioDataAccess.save(producto.getTipoProductoServicio(),connexion);
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepSave(producto.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				TipoProductoServicioInvenDataAccess.save(producto.getTipoProductoServicioInven(),connexion);
				TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
				tipoproductoservicioinvenLogic.deepSave(producto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCosteo.class)) {
				TipoCosteoDataAccess.save(producto.getTipoCosteo(),connexion);
				TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
				tipocosteoLogic.deepSave(producto.getTipoCosteo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(producto.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(producto.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(producto.getUnidadPeso(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(producto.getUnidadPeso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Arancel.class)) {
				ArancelDataAccess.save(producto.getArancel(),connexion);
				ArancelLogic arancelLogic= new ArancelLogic(connexion);
				arancelLogic.deepSave(producto.getArancel(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(producto.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(producto.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(producto.getClienteProveedorDefecto(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(producto.getClienteProveedorDefecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(producto.getTipoProducto(),connexion);
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepSave(producto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)) {
				ColorProductoDataAccess.save(producto.getColorProducto(),connexion);
				ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
				colorproductoLogic.deepSave(producto.getColorProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)) {
				ClaseProductoDataAccess.save(producto.getClaseProducto(),connexion);
				ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
				claseproductoLogic.deepSave(producto.getClaseProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)) {
				EfectoProductoDataAccess.save(producto.getEfectoProducto(),connexion);
				EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
				efectoproductoLogic.deepSave(producto.getEfectoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)) {
				MarcaProductoDataAccess.save(producto.getMarcaProducto(),connexion);
				MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
				marcaproductoLogic.deepSave(producto.getMarcaProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)) {
				ModeloProductoDataAccess.save(producto.getModeloProducto(),connexion);
				ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
				modeloproductoLogic.deepSave(producto.getModeloProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)) {
				MaterialProductoDataAccess.save(producto.getMaterialProducto(),connexion);
				MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
				materialproductoLogic.deepSave(producto.getMaterialProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)) {
				SegmentoProductoDataAccess.save(producto.getSegmentoProducto(),connexion);
				SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
				segmentoproductoLogic.deepSave(producto.getSegmentoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)) {
				TallaProductoDataAccess.save(producto.getTallaProducto(),connexion);
				TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
				tallaproductoLogic.deepSave(producto.getTallaProducto(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProveedorProducto proveedorproducto:producto.getProveedorProductos()) {
					ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
					proveedorproducto.setid_producto(producto.getId());
					ProveedorProductoDataAccess.save(proveedorproducto,connexion);
					proveedorproductoLogic.deepSave(proveedorproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:producto.getPrecios()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precio.setid_producto(producto.getId());
					PrecioDataAccess.save(precio,connexion);
					precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleImpuestoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleImpuestoInven detalleimpuestoinven:producto.getDetalleImpuestoInvens()) {
					DetalleImpuestoInvenLogic detalleimpuestoinvenLogic= new DetalleImpuestoInvenLogic(connexion);
					detalleimpuestoinven.setid_producto(producto.getId());
					DetalleImpuestoInvenDataAccess.save(detalleimpuestoinven,connexion);
					detalleimpuestoinvenLogic.deepSave(detalleimpuestoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentas presupuestoventas:producto.getPresupuestoVentass()) {
					PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
					presupuestoventas.setid_producto(producto.getId());
					PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
					presupuestoventasLogic.deepSave(presupuestoventas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticaProducto politicaproducto:producto.getPoliticaProductos()) {
					PoliticaProductoLogic politicaproductoLogic= new PoliticaProductoLogic(connexion);
					politicaproducto.setid_producto(producto.getId());
					PoliticaProductoDataAccess.save(politicaproducto,connexion);
					politicaproductoLogic.deepSave(politicaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SerieProducto serieproducto:producto.getSerieProductos()) {
					SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
					serieproducto.setid_producto(producto.getId());
					SerieProductoDataAccess.save(serieproducto,connexion);
					serieproductoLogic.deepSave(serieproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UbicacionProdu ubicacionprodu:producto.getUbicacionProdus()) {
					UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
					ubicacionprodu.setid_producto(producto.getId());
					UbicacionProduDataAccess.save(ubicacionprodu,connexion);
					ubicacionproduLogic.deepSave(ubicacionprodu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroProducto parametroproducto:producto.getParametroProductos()) {
					ParametroProductoLogic parametroproductoLogic= new ParametroProductoLogic(connexion);
					parametroproducto.setid_producto(producto.getId());
					ParametroProductoDataAccess.save(parametroproducto,connexion);
					parametroproductoLogic.deepSave(parametroproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoUnidad productounidad:producto.getProductoUnidads()) {
					ProductoUnidadLogic productounidadLogic= new ProductoUnidadLogic(connexion);
					productounidad.setid_producto(producto.getId());
					ProductoUnidadDataAccess.save(productounidad,connexion);
					productounidadLogic.deepSave(productounidad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Ingrediente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Ingrediente ingrediente:producto.getIngredienteRelacions()) {
					IngredienteLogic ingredienteLogic= new IngredienteLogic(connexion);
					ingrediente.setid_producto_relacion(producto.getId());
					IngredienteDataAccess.save(ingrediente,connexion);
					ingredienteLogic.deepSave(ingrediente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoCarac.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoCarac productocarac:producto.getProductoCaracs()) {
					ProductoCaracLogic productocaracLogic= new ProductoCaracLogic(connexion);
					productocarac.setid_producto(producto.getId());
					ProductoCaracDataAccess.save(productocarac,connexion);
					productocaracLogic.deepSave(productocarac,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioCliente serviciocliente:producto.getServicioClientes()) {
					ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
					serviciocliente.setid_producto(producto.getId());
					ServicioClienteDataAccess.save(serviciocliente,connexion);
					servicioclienteLogic.deepSave(serviciocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoPromocion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoPromocion productopromocion:producto.getProductoPromocionRelacions()) {
					ProductoPromocionLogic productopromocionLogic= new ProductoPromocionLogic(connexion);
					productopromocion.setid_producto_relacion(producto.getId());
					ProductoPromocionDataAccess.save(productopromocion,connexion);
					productopromocionLogic.deepSave(productopromocion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoEspeci.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoEspeci productoespeci:producto.getProductoEspecis()) {
					ProductoEspeciLogic productoespeciLogic= new ProductoEspeciLogic(connexion);
					productoespeci.setid_producto(producto.getId());
					ProductoEspeciDataAccess.save(productoespeci,connexion);
					productoespeciLogic.deepSave(productoespeci,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoReempla.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoReempla productoreempla:producto.getProductoReemplas()) {
					ProductoReemplaLogic productoreemplaLogic= new ProductoReemplaLogic(connexion);
					productoreempla.setid_producto(producto.getId());
					ProductoReemplaDataAccess.save(productoreempla,connexion);
					productoreemplaLogic.deepSave(productoreempla,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoEstadistica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoEstadistica productoestadistica:producto.getProductoEstadisticas()) {
					ProductoEstadisticaLogic productoestadisticaLogic= new ProductoEstadisticaLogic(connexion);
					productoestadistica.setid_producto(producto.getId());
					ProductoEstadisticaDataAccess.save(productoestadistica,connexion);
					productoestadisticaLogic.deepSave(productoestadistica,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticaFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticaFactu politicafactu:producto.getPoliticaFactus()) {
					PoliticaFactuLogic politicafactuLogic= new PoliticaFactuLogic(connexion);
					politicafactu.setid_producto(producto.getId());
					PoliticaFactuDataAccess.save(politicafactu,connexion);
					politicafactuLogic.deepSave(politicafactu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoCuentaContable productocuentacontable:producto.getProductoCuentaContables()) {
					ProductoCuentaContableLogic productocuentacontableLogic= new ProductoCuentaContableLogic(connexion);
					productocuentacontable.setid_producto(producto.getId());
					ProductoCuentaContableDataAccess.save(productocuentacontable,connexion);
					productocuentacontableLogic.deepSave(productocuentacontable,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(BodegaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(BodegaProducto bodegaproducto:producto.getBodegaProductos()) {
					BodegaProductoLogic bodegaproductoLogic= new BodegaProductoLogic(connexion);
					bodegaproducto.setid_producto(producto.getId());
					BodegaProductoDataAccess.save(bodegaproducto,connexion);
					bodegaproductoLogic.deepSave(bodegaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoProducto presupuestoproducto:producto.getPresupuestoProductos()) {
					PresupuestoProductoLogic presupuestoproductoLogic= new PresupuestoProductoLogic(connexion);
					presupuestoproducto.setid_producto(producto.getId());
					PresupuestoProductoDataAccess.save(presupuestoproducto,connexion);
					presupuestoproductoLogic.deepSave(presupuestoproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SaldoMesProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SaldoMesProducto saldomesproducto:producto.getSaldoMesProductos()) {
					SaldoMesProductoLogic saldomesproductoLogic= new SaldoMesProductoLogic(connexion);
					saldomesproducto.setid_producto(producto.getId());
					SaldoMesProductoDataAccess.save(saldomesproducto,connexion);
					saldomesproductoLogic.deepSave(saldomesproducto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Producto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(producto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(producto);
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
			this.deepLoad(this.producto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.producto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Producto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productos!=null) {
				for(Producto producto:productos) {
					this.deepLoad(producto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(productos);
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
			if(productos!=null) {
				for(Producto producto:productos) {
					this.deepLoad(producto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(productos);
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
			this.getNewConnexionToDeep(Producto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(producto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Producto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productos!=null) {
				for(Producto producto:productos) {
					this.deepSave(producto,isDeep,deepLoadType,clases);
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
			if(productos!=null) {
				for(Producto producto:productos) {
					this.deepSave(producto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",ProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",ProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosBusquedaPorNombreExtranjeroWithConnection(String sFinalQuery,Pagination pagination,String nombre_extranjero)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreExtranjero= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreExtranjero.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_extranjero+"%",ProductoConstantesFunciones.NOMBREEXTRANJERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreExtranjero);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreExtranjero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosBusquedaPorNombreExtranjero(String sFinalQuery,Pagination pagination,String nombre_extranjero)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreExtranjero= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreExtranjero.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_extranjero+"%",ProductoConstantesFunciones.NOMBREEXTRANJERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreExtranjero);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreExtranjero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdArancelWithConnection(String sFinalQuery,Pagination pagination,Long id_arancel)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidArancel= new ParameterSelectionGeneral();
			parameterSelectionGeneralidArancel.setParameterSelectionGeneralEqual(ParameterType.LONG,id_arancel,ProductoConstantesFunciones.IDARANCEL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidArancel);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdArancel","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdArancel(String sFinalQuery,Pagination pagination,Long id_arancel)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidArancel= new ParameterSelectionGeneral();
			parameterSelectionGeneralidArancel.setParameterSelectionGeneralEqual(ParameterType.LONG,id_arancel,ProductoConstantesFunciones.IDARANCEL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidArancel);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdArancel","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdClaseProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_clase_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClaseProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClaseProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_clase_producto,ProductoConstantesFunciones.IDCLASEPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClaseProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClaseProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdClaseProducto(String sFinalQuery,Pagination pagination,Long id_clase_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClaseProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClaseProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_clase_producto,ProductoConstantesFunciones.IDCLASEPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClaseProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClaseProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ProductoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ProductoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdClienteProveedorDefectoWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor_defecto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedorDefecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedorDefecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor_defecto,ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedorDefecto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedorDefecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdClienteProveedorDefecto(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor_defecto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedorDefecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedorDefecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor_defecto,ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedorDefecto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedorDefecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdColorProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_color_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_producto,ProductoConstantesFunciones.IDCOLORPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdColorProducto(String sFinalQuery,Pagination pagination,Long id_color_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_producto,ProductoConstantesFunciones.IDCOLORPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdEfectoProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_efecto_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEfectoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEfectoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_efecto_producto,ProductoConstantesFunciones.IDEFECTOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEfectoProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEfectoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdEfectoProducto(String sFinalQuery,Pagination pagination,Long id_efecto_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEfectoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEfectoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_efecto_producto,ProductoConstantesFunciones.IDEFECTOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEfectoProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEfectoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdLineaCategoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,ProductoConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdLineaCategoria(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,ProductoConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,ProductoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,ProductoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdLineaMarcaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,ProductoConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdLineaMarca(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,ProductoConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdMarcaProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_marca_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMarcaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMarcaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_marca_producto,ProductoConstantesFunciones.IDMARCAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMarcaProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMarcaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdMarcaProducto(String sFinalQuery,Pagination pagination,Long id_marca_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMarcaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMarcaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_marca_producto,ProductoConstantesFunciones.IDMARCAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMarcaProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMarcaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdMaterialProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_material_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMaterialProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMaterialProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_material_producto,ProductoConstantesFunciones.IDMATERIALPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMaterialProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMaterialProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdMaterialProducto(String sFinalQuery,Pagination pagination,Long id_material_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMaterialProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMaterialProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_material_producto,ProductoConstantesFunciones.IDMATERIALPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMaterialProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMaterialProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdModeloProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_modelo_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModeloProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModeloProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modelo_producto,ProductoConstantesFunciones.IDMODELOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModeloProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModeloProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdModeloProducto(String sFinalQuery,Pagination pagination,Long id_modelo_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModeloProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModeloProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modelo_producto,ProductoConstantesFunciones.IDMODELOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModeloProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModeloProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdSegmentoProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_segmento_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSegmentoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSegmentoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_segmento_producto,ProductoConstantesFunciones.IDSEGMENTOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSegmentoProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSegmentoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdSegmentoProducto(String sFinalQuery,Pagination pagination,Long id_segmento_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSegmentoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSegmentoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_segmento_producto,ProductoConstantesFunciones.IDSEGMENTOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSegmentoProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSegmentoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdTallaProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_talla_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTallaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTallaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_talla_producto,ProductoConstantesFunciones.IDTALLAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTallaProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTallaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdTallaProducto(String sFinalQuery,Pagination pagination,Long id_talla_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTallaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTallaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_talla_producto,ProductoConstantesFunciones.IDTALLAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTallaProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTallaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdTipoCosteoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_costeo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCosteo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCosteo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costeo,ProductoConstantesFunciones.IDTIPOCOSTEO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCosteo);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCosteo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdTipoCosteo(String sFinalQuery,Pagination pagination,Long id_tipo_costeo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCosteo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCosteo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costeo,ProductoConstantesFunciones.IDTIPOCOSTEO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCosteo);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCosteo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdTipoProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,ProductoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdTipoProducto(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,ProductoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdTipoProductoServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio,ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicio);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdTipoProductoServicio(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio,ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicio);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdTipoProductoServicioInvenWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio_inven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicioInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicioInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio_inven,ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicioInven);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicioInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdTipoProductoServicioInven(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio_inven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicioInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicioInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio_inven,ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicioInven);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicioInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductosFK_IdUnidadPesoWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad_peso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Producto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidadPeso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidadPeso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad_peso,ProductoConstantesFunciones.IDUNIDADPESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidadPeso);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadPeso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductosFK_IdUnidadPeso(String sFinalQuery,Pagination pagination,Long id_unidad_peso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidadPeso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidadPeso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad_peso,ProductoConstantesFunciones.IDUNIDADPESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidadPeso);

			ProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadPeso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(this.productos);
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
			if(ProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Producto producto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoConstantesFunciones.ISCONAUDITORIA) {
				if(producto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoDataAccess.TABLENAME, producto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoLogic.registrarAuditoriaDetallesProducto(connexion,producto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(producto.getIsDeleted()) {
					/*if(!producto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoDataAccess.TABLENAME, producto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoLogic.registrarAuditoriaDetallesProducto(connexion,producto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoDataAccess.TABLENAME, producto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(producto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoDataAccess.TABLENAME, producto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoLogic.registrarAuditoriaDetallesProducto(connexion,producto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProducto(Connexion connexion,Producto producto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(producto.getIsNew()||!producto.getid_empresa().equals(producto.getProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_empresa().toString();
				}
				if(producto.getid_empresa()!=null)
				{
					strValorNuevo=producto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_sucursal().equals(producto.getProductoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_sucursal()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_sucursal().toString();
				}
				if(producto.getid_sucursal()!=null)
				{
					strValorNuevo=producto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcodigo().equals(producto.getProductoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcodigo()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcodigo();
				}
				if(producto.getcodigo()!=null)
				{
					strValorNuevo=producto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getnombre().equals(producto.getProductoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getnombre()!=null)
				{
					strValorActual=producto.getProductoOriginal().getnombre();
				}
				if(producto.getnombre()!=null)
				{
					strValorNuevo=producto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getnombre_extranjero().equals(producto.getProductoOriginal().getnombre_extranjero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getnombre_extranjero()!=null)
				{
					strValorActual=producto.getProductoOriginal().getnombre_extranjero();
				}
				if(producto.getnombre_extranjero()!=null)
				{
					strValorNuevo=producto.getnombre_extranjero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.NOMBREEXTRANJERO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getresumen_detalle().equals(producto.getProductoOriginal().getresumen_detalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getresumen_detalle()!=null)
				{
					strValorActual=producto.getProductoOriginal().getresumen_detalle();
				}
				if(producto.getresumen_detalle()!=null)
				{
					strValorNuevo=producto.getresumen_detalle() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.RESUMENDETALLE,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcodigo_barra().equals(producto.getProductoOriginal().getcodigo_barra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcodigo_barra()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcodigo_barra();
				}
				if(producto.getcodigo_barra()!=null)
				{
					strValorNuevo=producto.getcodigo_barra() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CODIGOBARRA,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_linea().equals(producto.getProductoOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_linea()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_linea().toString();
				}
				if(producto.getid_linea()!=null)
				{
					strValorNuevo=producto.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_linea_grupo().equals(producto.getProductoOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_linea_grupo().toString();
				}
				if(producto.getid_linea_grupo()!=null)
				{
					strValorNuevo=producto.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_linea_categoria().equals(producto.getProductoOriginal().getid_linea_categoria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_linea_categoria()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_linea_categoria().toString();
				}
				if(producto.getid_linea_categoria()!=null)
				{
					strValorNuevo=producto.getid_linea_categoria().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDLINEACATEGORIA,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_linea_marca().equals(producto.getProductoOriginal().getid_linea_marca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_linea_marca()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_linea_marca().toString();
				}
				if(producto.getid_linea_marca()!=null)
				{
					strValorNuevo=producto.getid_linea_marca().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDLINEAMARCA,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_tipo_producto_servicio().equals(producto.getProductoOriginal().getid_tipo_producto_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_tipo_producto_servicio()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_tipo_producto_servicio().toString();
				}
				if(producto.getid_tipo_producto_servicio()!=null)
				{
					strValorNuevo=producto.getid_tipo_producto_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_tipo_producto_servicio_inven().equals(producto.getProductoOriginal().getid_tipo_producto_servicio_inven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_tipo_producto_servicio_inven()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_tipo_producto_servicio_inven().toString();
				}
				if(producto.getid_tipo_producto_servicio_inven()!=null)
				{
					strValorNuevo=producto.getid_tipo_producto_servicio_inven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_tipo_costeo().equals(producto.getProductoOriginal().getid_tipo_costeo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_tipo_costeo()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_tipo_costeo().toString();
				}
				if(producto.getid_tipo_costeo()!=null)
				{
					strValorNuevo=producto.getid_tipo_costeo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDTIPOCOSTEO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_unidad().equals(producto.getProductoOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_unidad()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_unidad().toString();
				}
				if(producto.getid_unidad()!=null)
				{
					strValorNuevo=producto.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_unidad_peso().equals(producto.getProductoOriginal().getid_unidad_peso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_unidad_peso()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_unidad_peso().toString();
				}
				if(producto.getid_unidad_peso()!=null)
				{
					strValorNuevo=producto.getid_unidad_peso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDUNIDADPESO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_arancel().equals(producto.getProductoOriginal().getid_arancel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_arancel()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_arancel().toString();
				}
				if(producto.getid_arancel()!=null)
				{
					strValorNuevo=producto.getid_arancel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDARANCEL,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_cliente().equals(producto.getProductoOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_cliente()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_cliente().toString();
				}
				if(producto.getid_cliente()!=null)
				{
					strValorNuevo=producto.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_cliente_proveedor_defecto().equals(producto.getProductoOriginal().getid_cliente_proveedor_defecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_cliente_proveedor_defecto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_cliente_proveedor_defecto().toString();
				}
				if(producto.getid_cliente_proveedor_defecto()!=null)
				{
					strValorNuevo=producto.getid_cliente_proveedor_defecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getesta_activo().equals(producto.getProductoOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getesta_activo()!=null)
				{
					strValorActual=producto.getProductoOriginal().getesta_activo().toString();
				}
				if(producto.getesta_activo()!=null)
				{
					strValorNuevo=producto.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getdescripcion().equals(producto.getProductoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getdescripcion()!=null)
				{
					strValorActual=producto.getProductoOriginal().getdescripcion();
				}
				if(producto.getdescripcion()!=null)
				{
					strValorNuevo=producto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getprecio().equals(producto.getProductoOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getprecio()!=null)
				{
					strValorActual=producto.getProductoOriginal().getprecio().toString();
				}
				if(producto.getprecio()!=null)
				{
					strValorNuevo=producto.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getiva().equals(producto.getProductoOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getiva()!=null)
				{
					strValorActual=producto.getProductoOriginal().getiva().toString();
				}
				if(producto.getiva()!=null)
				{
					strValorNuevo=producto.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getiva_valor().equals(producto.getProductoOriginal().getiva_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getiva_valor()!=null)
				{
					strValorActual=producto.getProductoOriginal().getiva_valor().toString();
				}
				if(producto.getiva_valor()!=null)
				{
					strValorNuevo=producto.getiva_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IVAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getice().equals(producto.getProductoOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getice()!=null)
				{
					strValorActual=producto.getProductoOriginal().getice().toString();
				}
				if(producto.getice()!=null)
				{
					strValorNuevo=producto.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getice_valor().equals(producto.getProductoOriginal().getice_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getice_valor()!=null)
				{
					strValorActual=producto.getProductoOriginal().getice_valor().toString();
				}
				if(producto.getice_valor()!=null)
				{
					strValorNuevo=producto.getice_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.ICEVALOR,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getdescuento().equals(producto.getProductoOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getdescuento()!=null)
				{
					strValorActual=producto.getProductoOriginal().getdescuento().toString();
				}
				if(producto.getdescuento()!=null)
				{
					strValorNuevo=producto.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getdescuento_valor().equals(producto.getProductoOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getdescuento_valor()!=null)
				{
					strValorActual=producto.getProductoOriginal().getdescuento_valor().toString();
				}
				if(producto.getdescuento_valor()!=null)
				{
					strValorNuevo=producto.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getarancel_porcentaje().equals(producto.getProductoOriginal().getarancel_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getarancel_porcentaje()!=null)
				{
					strValorActual=producto.getProductoOriginal().getarancel_porcentaje().toString();
				}
				if(producto.getarancel_porcentaje()!=null)
				{
					strValorNuevo=producto.getarancel_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.ARANCELPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getarancel_valor().equals(producto.getProductoOriginal().getarancel_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getarancel_valor()!=null)
				{
					strValorActual=producto.getProductoOriginal().getarancel_valor().toString();
				}
				if(producto.getarancel_valor()!=null)
				{
					strValorNuevo=producto.getarancel_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.ARANCELVALOR,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcomision().equals(producto.getProductoOriginal().getcomision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcomision()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcomision().toString();
				}
				if(producto.getcomision()!=null)
				{
					strValorNuevo=producto.getcomision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.COMISION,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcomision_valor().equals(producto.getProductoOriginal().getcomision_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcomision_valor()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcomision_valor().toString();
				}
				if(producto.getcomision_valor()!=null)
				{
					strValorNuevo=producto.getcomision_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.COMISIONVALOR,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getdias_produccion().equals(producto.getProductoOriginal().getdias_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getdias_produccion()!=null)
				{
					strValorActual=producto.getProductoOriginal().getdias_produccion().toString();
				}
				if(producto.getdias_produccion()!=null)
				{
					strValorNuevo=producto.getdias_produccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.DIASPRODUCCION,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_stock_negativo().equals(producto.getProductoOriginal().getcon_stock_negativo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_stock_negativo()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_stock_negativo().toString();
				}
				if(producto.getcon_stock_negativo()!=null)
				{
					strValorNuevo=producto.getcon_stock_negativo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONSTOCKNEGATIVO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_precio_minimo().equals(producto.getProductoOriginal().getcon_precio_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_precio_minimo()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_precio_minimo().toString();
				}
				if(producto.getcon_precio_minimo()!=null)
				{
					strValorNuevo=producto.getcon_precio_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONPRECIOMINIMO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_lote().equals(producto.getProductoOriginal().getcon_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_lote()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_lote().toString();
				}
				if(producto.getcon_lote()!=null)
				{
					strValorNuevo=producto.getcon_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONLOTE,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_confirmacion().equals(producto.getProductoOriginal().getcon_confirmacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_confirmacion()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_confirmacion().toString();
				}
				if(producto.getcon_confirmacion()!=null)
				{
					strValorNuevo=producto.getcon_confirmacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONCONFIRMACION,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_presupuesto().equals(producto.getProductoOriginal().getcon_presupuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_presupuesto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_presupuesto().toString();
				}
				if(producto.getcon_presupuesto()!=null)
				{
					strValorNuevo=producto.getcon_presupuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONPRESUPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_importacion().equals(producto.getProductoOriginal().getcon_importacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_importacion()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_importacion().toString();
				}
				if(producto.getcon_importacion()!=null)
				{
					strValorNuevo=producto.getcon_importacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONIMPORTACION,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_final().equals(producto.getProductoOriginal().getcon_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_final()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_final().toString();
				}
				if(producto.getcon_final()!=null)
				{
					strValorNuevo=producto.getcon_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONFINAL,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_consep().equals(producto.getProductoOriginal().getcon_consep()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_consep()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_consep().toString();
				}
				if(producto.getcon_consep()!=null)
				{
					strValorNuevo=producto.getcon_consep().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONCONSEP,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_serie().equals(producto.getProductoOriginal().getcon_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_serie()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_serie().toString();
				}
				if(producto.getcon_serie()!=null)
				{
					strValorNuevo=producto.getcon_serie().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONSERIE,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getcon_balanza().equals(producto.getProductoOriginal().getcon_balanza()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getcon_balanza()!=null)
				{
					strValorActual=producto.getProductoOriginal().getcon_balanza().toString();
				}
				if(producto.getcon_balanza()!=null)
				{
					strValorNuevo=producto.getcon_balanza().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.CONBALANZA,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getalto().equals(producto.getProductoOriginal().getalto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getalto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getalto().toString();
				}
				if(producto.getalto()!=null)
				{
					strValorNuevo=producto.getalto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.ALTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getancho().equals(producto.getProductoOriginal().getancho()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getancho()!=null)
				{
					strValorActual=producto.getProductoOriginal().getancho().toString();
				}
				if(producto.getancho()!=null)
				{
					strValorNuevo=producto.getancho().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.ANCHO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getlargo().equals(producto.getProductoOriginal().getlargo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getlargo()!=null)
				{
					strValorActual=producto.getProductoOriginal().getlargo().toString();
				}
				if(producto.getlargo()!=null)
				{
					strValorNuevo=producto.getlargo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.LARGO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getvolumen().equals(producto.getProductoOriginal().getvolumen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getvolumen()!=null)
				{
					strValorActual=producto.getProductoOriginal().getvolumen().toString();
				}
				if(producto.getvolumen()!=null)
				{
					strValorNuevo=producto.getvolumen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.VOLUMEN,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getpeso().equals(producto.getProductoOriginal().getpeso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getpeso()!=null)
				{
					strValorActual=producto.getProductoOriginal().getpeso().toString();
				}
				if(producto.getpeso()!=null)
				{
					strValorNuevo=producto.getpeso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.PESO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getgramos().equals(producto.getProductoOriginal().getgramos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getgramos()!=null)
				{
					strValorActual=producto.getProductoOriginal().getgramos().toString();
				}
				if(producto.getgramos()!=null)
				{
					strValorNuevo=producto.getgramos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.GRAMOS,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getunidades_caja().equals(producto.getProductoOriginal().getunidades_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getunidades_caja()!=null)
				{
					strValorActual=producto.getProductoOriginal().getunidades_caja().toString();
				}
				if(producto.getunidades_caja()!=null)
				{
					strValorNuevo=producto.getunidades_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.UNIDADESCAJA,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getmargen().equals(producto.getProductoOriginal().getmargen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getmargen()!=null)
				{
					strValorActual=producto.getProductoOriginal().getmargen().toString();
				}
				if(producto.getmargen()!=null)
				{
					strValorNuevo=producto.getmargen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.MARGEN,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getfactor().equals(producto.getProductoOriginal().getfactor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getfactor()!=null)
				{
					strValorActual=producto.getProductoOriginal().getfactor().toString();
				}
				if(producto.getfactor()!=null)
				{
					strValorNuevo=producto.getfactor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.FACTOR,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getfob().equals(producto.getProductoOriginal().getfob()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getfob()!=null)
				{
					strValorActual=producto.getProductoOriginal().getfob().toString();
				}
				if(producto.getfob()!=null)
				{
					strValorNuevo=producto.getfob().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.FOB,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getfob2().equals(producto.getProductoOriginal().getfob2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getfob2()!=null)
				{
					strValorActual=producto.getProductoOriginal().getfob2().toString();
				}
				if(producto.getfob2()!=null)
				{
					strValorNuevo=producto.getfob2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.FOB2,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_tipo_producto().equals(producto.getProductoOriginal().getid_tipo_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_tipo_producto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_tipo_producto().toString();
				}
				if(producto.getid_tipo_producto()!=null)
				{
					strValorNuevo=producto.getid_tipo_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDTIPOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_color_producto().equals(producto.getProductoOriginal().getid_color_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_color_producto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_color_producto().toString();
				}
				if(producto.getid_color_producto()!=null)
				{
					strValorNuevo=producto.getid_color_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDCOLORPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_clase_producto().equals(producto.getProductoOriginal().getid_clase_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_clase_producto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_clase_producto().toString();
				}
				if(producto.getid_clase_producto()!=null)
				{
					strValorNuevo=producto.getid_clase_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDCLASEPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_efecto_producto().equals(producto.getProductoOriginal().getid_efecto_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_efecto_producto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_efecto_producto().toString();
				}
				if(producto.getid_efecto_producto()!=null)
				{
					strValorNuevo=producto.getid_efecto_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDEFECTOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_marca_producto().equals(producto.getProductoOriginal().getid_marca_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_marca_producto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_marca_producto().toString();
				}
				if(producto.getid_marca_producto()!=null)
				{
					strValorNuevo=producto.getid_marca_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDMARCAPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_modelo_producto().equals(producto.getProductoOriginal().getid_modelo_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_modelo_producto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_modelo_producto().toString();
				}
				if(producto.getid_modelo_producto()!=null)
				{
					strValorNuevo=producto.getid_modelo_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDMODELOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_material_producto().equals(producto.getProductoOriginal().getid_material_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_material_producto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_material_producto().toString();
				}
				if(producto.getid_material_producto()!=null)
				{
					strValorNuevo=producto.getid_material_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDMATERIALPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_segmento_producto().equals(producto.getProductoOriginal().getid_segmento_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_segmento_producto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_segmento_producto().toString();
				}
				if(producto.getid_segmento_producto()!=null)
				{
					strValorNuevo=producto.getid_segmento_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDSEGMENTOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getid_talla_producto().equals(producto.getProductoOriginal().getid_talla_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getid_talla_producto()!=null)
				{
					strValorActual=producto.getProductoOriginal().getid_talla_producto().toString();
				}
				if(producto.getid_talla_producto()!=null)
				{
					strValorNuevo=producto.getid_talla_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.IDTALLAPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getgrupo().equals(producto.getProductoOriginal().getgrupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getgrupo()!=null)
				{
					strValorActual=producto.getProductoOriginal().getgrupo();
				}
				if(producto.getgrupo()!=null)
				{
					strValorNuevo=producto.getgrupo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.GRUPO,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getreferencia().equals(producto.getProductoOriginal().getreferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getreferencia()!=null)
				{
					strValorActual=producto.getProductoOriginal().getreferencia();
				}
				if(producto.getreferencia()!=null)
				{
					strValorNuevo=producto.getreferencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.REFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getaplicacion().equals(producto.getProductoOriginal().getaplicacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getaplicacion()!=null)
				{
					strValorActual=producto.getProductoOriginal().getaplicacion();
				}
				if(producto.getaplicacion()!=null)
				{
					strValorNuevo=producto.getaplicacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.APLICACION,strValorActual,strValorNuevo);
			}	
			
			if(producto.getIsNew()||!producto.getprocedencia().equals(producto.getProductoOriginal().getprocedencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(producto.getProductoOriginal().getprocedencia()!=null)
				{
					strValorActual=producto.getProductoOriginal().getprocedencia();
				}
				if(producto.getprocedencia()!=null)
				{
					strValorNuevo=producto.getprocedencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoConstantesFunciones.PROCEDENCIA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoRelacionesWithConnection(Producto producto,List<ProveedorProducto> proveedorproductos,List<Precio> precios,List<DetalleImpuestoInven> detalleimpuestoinvens,List<PresupuestoVentas> presupuestoventass,List<PoliticaProducto> politicaproductos,List<SerieProducto> serieproductos,List<UbicacionProdu> ubicacionprodus,List<ParametroProducto> parametroproductos,List<ProductoUnidad> productounidads,List<Ingrediente> ingredienteRelacions,List<ProductoCarac> productocaracs,List<ServicioCliente> servicioclientes,List<ProductoPromocion> productopromocionRelacions,List<ProductoEspeci> productoespecis,List<ProductoReempla> productoreemplas,List<ProductoEstadistica> productoestadisticas,List<PoliticaFactu> politicafactus,List<ProductoCuentaContable> productocuentacontables,List<BodegaProducto> bodegaproductos,List<PresupuestoProducto> presupuestoproductos,List<SaldoMesProducto> saldomesproductos) throws Exception {

		if(!producto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoRelacionesBase(producto,proveedorproductos,precios,detalleimpuestoinvens,presupuestoventass,politicaproductos,serieproductos,ubicacionprodus,parametroproductos,productounidads,ingredienteRelacions,productocaracs,servicioclientes,productopromocionRelacions,productoespecis,productoreemplas,productoestadisticas,politicafactus,productocuentacontables,bodegaproductos,presupuestoproductos,saldomesproductos,true);
		}
	}

	public void saveProductoRelaciones(Producto producto,List<ProveedorProducto> proveedorproductos,List<Precio> precios,List<DetalleImpuestoInven> detalleimpuestoinvens,List<PresupuestoVentas> presupuestoventass,List<PoliticaProducto> politicaproductos,List<SerieProducto> serieproductos,List<UbicacionProdu> ubicacionprodus,List<ParametroProducto> parametroproductos,List<ProductoUnidad> productounidads,List<Ingrediente> ingredienteRelacions,List<ProductoCarac> productocaracs,List<ServicioCliente> servicioclientes,List<ProductoPromocion> productopromocionRelacions,List<ProductoEspeci> productoespecis,List<ProductoReempla> productoreemplas,List<ProductoEstadistica> productoestadisticas,List<PoliticaFactu> politicafactus,List<ProductoCuentaContable> productocuentacontables,List<BodegaProducto> bodegaproductos,List<PresupuestoProducto> presupuestoproductos,List<SaldoMesProducto> saldomesproductos)throws Exception {

		if(!producto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoRelacionesBase(producto,proveedorproductos,precios,detalleimpuestoinvens,presupuestoventass,politicaproductos,serieproductos,ubicacionprodus,parametroproductos,productounidads,ingredienteRelacions,productocaracs,servicioclientes,productopromocionRelacions,productoespecis,productoreemplas,productoestadisticas,politicafactus,productocuentacontables,bodegaproductos,presupuestoproductos,saldomesproductos,false);
		}
	}

	public void saveProductoRelacionesBase(Producto producto,List<ProveedorProducto> proveedorproductos,List<Precio> precios,List<DetalleImpuestoInven> detalleimpuestoinvens,List<PresupuestoVentas> presupuestoventass,List<PoliticaProducto> politicaproductos,List<SerieProducto> serieproductos,List<UbicacionProdu> ubicacionprodus,List<ParametroProducto> parametroproductos,List<ProductoUnidad> productounidads,List<Ingrediente> ingredienteRelacions,List<ProductoCarac> productocaracs,List<ServicioCliente> servicioclientes,List<ProductoPromocion> productopromocionRelacions,List<ProductoEspeci> productoespecis,List<ProductoReempla> productoreemplas,List<ProductoEstadistica> productoestadisticas,List<PoliticaFactu> politicafactus,List<ProductoCuentaContable> productocuentacontables,List<BodegaProducto> bodegaproductos,List<PresupuestoProducto> presupuestoproductos,List<SaldoMesProducto> saldomesproductos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Producto-saveRelacionesWithConnection");}
	
			producto.setProveedorProductos(proveedorproductos);
			producto.setPrecios(precios);
			producto.setDetalleImpuestoInvens(detalleimpuestoinvens);
			producto.setPresupuestoVentass(presupuestoventass);
			producto.setPoliticaProductos(politicaproductos);
			producto.setSerieProductos(serieproductos);
			producto.setUbicacionProdus(ubicacionprodus);
			producto.setParametroProductos(parametroproductos);
			producto.setProductoUnidads(productounidads);
			producto.setIngredienteRelacions(ingredienteRelacions);
			producto.setProductoCaracs(productocaracs);
			producto.setServicioClientes(servicioclientes);
			producto.setProductoPromocionRelacions(productopromocionRelacions);
			producto.setProductoEspecis(productoespecis);
			producto.setProductoReemplas(productoreemplas);
			producto.setProductoEstadisticas(productoestadisticas);
			producto.setPoliticaFactus(politicafactus);
			producto.setProductoCuentaContables(productocuentacontables);
			producto.setBodegaProductos(bodegaproductos);
			producto.setPresupuestoProductos(presupuestoproductos);
			producto.setSaldoMesProductos(saldomesproductos);

			this.setProducto(producto);

			if(ProductoLogicAdditional.validarSaveRelaciones(producto,this)) {

				ProductoLogicAdditional.updateRelacionesToSave(producto,this);

				if((producto.getIsNew()||producto.getIsChanged())&&!producto.getIsDeleted()) {
					this.saveProducto();
					this.saveProductoRelacionesDetalles(proveedorproductos,precios,detalleimpuestoinvens,presupuestoventass,politicaproductos,serieproductos,ubicacionprodus,parametroproductos,productounidads,ingredienteRelacions,productocaracs,servicioclientes,productopromocionRelacions,productoespecis,productoreemplas,productoestadisticas,politicafactus,productocuentacontables,bodegaproductos,presupuestoproductos,saldomesproductos);

				} else if(producto.getIsDeleted()) {
					this.saveProductoRelacionesDetalles(proveedorproductos,precios,detalleimpuestoinvens,presupuestoventass,politicaproductos,serieproductos,ubicacionprodus,parametroproductos,productounidads,ingredienteRelacions,productocaracs,servicioclientes,productopromocionRelacions,productoespecis,productoreemplas,productoestadisticas,politicafactus,productocuentacontables,bodegaproductos,presupuestoproductos,saldomesproductos);
					this.saveProducto();
				}

				ProductoLogicAdditional.updateRelacionesToSaveAfter(producto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProveedorProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresProveedorProductos(proveedorproductos,true,true);
			PrecioConstantesFunciones.InicializarGeneralEntityAuxiliaresPrecios(precios,true,true);
			DetalleImpuestoInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleImpuestoInvens(detalleimpuestoinvens,true,true);
			PresupuestoVentasConstantesFunciones.InicializarGeneralEntityAuxiliaresPresupuestoVentass(presupuestoventass,true,true);
			PoliticaProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresPoliticaProductos(politicaproductos,true,true);
			SerieProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresSerieProductos(serieproductos,true,true);
			UbicacionProduConstantesFunciones.InicializarGeneralEntityAuxiliaresUbicacionProdus(ubicacionprodus,true,true);
			ParametroProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroProductos(parametroproductos,true,true);
			ProductoUnidadConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoUnidads(productounidads,true,true);
			IngredienteConstantesFunciones.InicializarGeneralEntityAuxiliaresIngredientes(ingredienteRelacions,true,true);
			ProductoCaracConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoCaracs(productocaracs,true,true);
			ServicioClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresServicioClientes(servicioclientes,true,true);
			ProductoPromocionConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoPromocions(productopromocionRelacions,true,true);
			ProductoEspeciConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoEspecis(productoespecis,true,true);
			ProductoReemplaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoReemplas(productoreemplas,true,true);
			ProductoEstadisticaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoEstadisticas(productoestadisticas,true,true);
			PoliticaFactuConstantesFunciones.InicializarGeneralEntityAuxiliaresPoliticaFactus(politicafactus,true,true);
			ProductoCuentaContableConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoCuentaContables(productocuentacontables,true,true);
			BodegaProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresBodegaProductos(bodegaproductos,true,true);
			PresupuestoProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresPresupuestoProductos(presupuestoproductos,true,true);
			SaldoMesProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresSaldoMesProductos(saldomesproductos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveProductoRelacionesDetalles(List<ProveedorProducto> proveedorproductos,List<Precio> precios,List<DetalleImpuestoInven> detalleimpuestoinvens,List<PresupuestoVentas> presupuestoventass,List<PoliticaProducto> politicaproductos,List<SerieProducto> serieproductos,List<UbicacionProdu> ubicacionprodus,List<ParametroProducto> parametroproductos,List<ProductoUnidad> productounidads,List<Ingrediente> ingredienteRelacions,List<ProductoCarac> productocaracs,List<ServicioCliente> servicioclientes,List<ProductoPromocion> productopromocionRelacions,List<ProductoEspeci> productoespecis,List<ProductoReempla> productoreemplas,List<ProductoEstadistica> productoestadisticas,List<PoliticaFactu> politicafactus,List<ProductoCuentaContable> productocuentacontables,List<BodegaProducto> bodegaproductos,List<PresupuestoProducto> presupuestoproductos,List<SaldoMesProducto> saldomesproductos)throws Exception {
		try {
	

			Long idProductoActual=this.getProducto().getId();

			ProveedorProductoLogic proveedorproductoLogic_Desde_Producto=new ProveedorProductoLogic();
			proveedorproductoLogic_Desde_Producto.setProveedorProductos(proveedorproductos);

			proveedorproductoLogic_Desde_Producto.setConnexion(this.getConnexion());
			proveedorproductoLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ProveedorProducto proveedorproducto_Desde_Producto:proveedorproductoLogic_Desde_Producto.getProveedorProductos()) {
				proveedorproducto_Desde_Producto.setid_producto(idProductoActual);
			}

			proveedorproductoLogic_Desde_Producto.saveProveedorProductos();

			PrecioLogic precioLogic_Desde_Producto=new PrecioLogic();
			precioLogic_Desde_Producto.setPrecios(precios);

			precioLogic_Desde_Producto.setConnexion(this.getConnexion());
			precioLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(Precio precio_Desde_Producto:precioLogic_Desde_Producto.getPrecios()) {
				precio_Desde_Producto.setid_producto(idProductoActual);
			}

			precioLogic_Desde_Producto.savePrecios();

			DetalleImpuestoInvenLogic detalleimpuestoinvenLogic_Desde_Producto=new DetalleImpuestoInvenLogic();
			detalleimpuestoinvenLogic_Desde_Producto.setDetalleImpuestoInvens(detalleimpuestoinvens);

			detalleimpuestoinvenLogic_Desde_Producto.setConnexion(this.getConnexion());
			detalleimpuestoinvenLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(DetalleImpuestoInven detalleimpuestoinven_Desde_Producto:detalleimpuestoinvenLogic_Desde_Producto.getDetalleImpuestoInvens()) {
				detalleimpuestoinven_Desde_Producto.setid_producto(idProductoActual);
			}

			detalleimpuestoinvenLogic_Desde_Producto.saveDetalleImpuestoInvens();

			PresupuestoVentasLogic presupuestoventasLogic_Desde_Producto=new PresupuestoVentasLogic();
			presupuestoventasLogic_Desde_Producto.setPresupuestoVentass(presupuestoventass);

			presupuestoventasLogic_Desde_Producto.setConnexion(this.getConnexion());
			presupuestoventasLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(PresupuestoVentas presupuestoventas_Desde_Producto:presupuestoventasLogic_Desde_Producto.getPresupuestoVentass()) {
				presupuestoventas_Desde_Producto.setid_producto(idProductoActual);
			}

			presupuestoventasLogic_Desde_Producto.savePresupuestoVentass();

			PoliticaProductoLogic politicaproductoLogic_Desde_Producto=new PoliticaProductoLogic();
			politicaproductoLogic_Desde_Producto.setPoliticaProductos(politicaproductos);

			politicaproductoLogic_Desde_Producto.setConnexion(this.getConnexion());
			politicaproductoLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(PoliticaProducto politicaproducto_Desde_Producto:politicaproductoLogic_Desde_Producto.getPoliticaProductos()) {
				politicaproducto_Desde_Producto.setid_producto(idProductoActual);
			}

			politicaproductoLogic_Desde_Producto.savePoliticaProductos();

			SerieProductoLogic serieproductoLogic_Desde_Producto=new SerieProductoLogic();
			serieproductoLogic_Desde_Producto.setSerieProductos(serieproductos);

			serieproductoLogic_Desde_Producto.setConnexion(this.getConnexion());
			serieproductoLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(SerieProducto serieproducto_Desde_Producto:serieproductoLogic_Desde_Producto.getSerieProductos()) {
				serieproducto_Desde_Producto.setid_producto(idProductoActual);

				serieproductoLogic_Desde_Producto.setSerieProducto(serieproducto_Desde_Producto);
				serieproductoLogic_Desde_Producto.saveSerieProducto();

				Long idSerieProductoActual=serieproducto_Desde_Producto.getId();

				DetalleSerieProductoLogic detalleserieproductoLogic_Desde_SerieProducto=new DetalleSerieProductoLogic();

				if(serieproducto_Desde_Producto.getDetalleSerieProductos()==null){
					serieproducto_Desde_Producto.setDetalleSerieProductos(new ArrayList<DetalleSerieProducto>());
				}

				detalleserieproductoLogic_Desde_SerieProducto.setDetalleSerieProductos(serieproducto_Desde_Producto.getDetalleSerieProductos());

				detalleserieproductoLogic_Desde_SerieProducto.setConnexion(this.getConnexion());
				detalleserieproductoLogic_Desde_SerieProducto.setDatosCliente(this.datosCliente);

				for(DetalleSerieProducto detalleserieproducto_Desde_SerieProducto:detalleserieproductoLogic_Desde_SerieProducto.getDetalleSerieProductos()) {
					detalleserieproducto_Desde_SerieProducto.setid_serie_producto(idSerieProductoActual);
				}

				detalleserieproductoLogic_Desde_SerieProducto.saveDetalleSerieProductos();
			}


			UbicacionProduLogic ubicacionproduLogic_Desde_Producto=new UbicacionProduLogic();
			ubicacionproduLogic_Desde_Producto.setUbicacionProdus(ubicacionprodus);

			ubicacionproduLogic_Desde_Producto.setConnexion(this.getConnexion());
			ubicacionproduLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(UbicacionProdu ubicacionprodu_Desde_Producto:ubicacionproduLogic_Desde_Producto.getUbicacionProdus()) {
				ubicacionprodu_Desde_Producto.setid_producto(idProductoActual);
			}

			ubicacionproduLogic_Desde_Producto.saveUbicacionProdus();

			ParametroProductoLogic parametroproductoLogic_Desde_Producto=new ParametroProductoLogic();
			parametroproductoLogic_Desde_Producto.setParametroProductos(parametroproductos);

			parametroproductoLogic_Desde_Producto.setConnexion(this.getConnexion());
			parametroproductoLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ParametroProducto parametroproducto_Desde_Producto:parametroproductoLogic_Desde_Producto.getParametroProductos()) {
				parametroproducto_Desde_Producto.setid_producto(idProductoActual);
			}

			parametroproductoLogic_Desde_Producto.saveParametroProductos();

			ProductoUnidadLogic productounidadLogic_Desde_Producto=new ProductoUnidadLogic();
			productounidadLogic_Desde_Producto.setProductoUnidads(productounidads);

			productounidadLogic_Desde_Producto.setConnexion(this.getConnexion());
			productounidadLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ProductoUnidad productounidad_Desde_Producto:productounidadLogic_Desde_Producto.getProductoUnidads()) {
				productounidad_Desde_Producto.setid_producto(idProductoActual);
			}

			productounidadLogic_Desde_Producto.saveProductoUnidads();

			IngredienteLogic ingredienteRelacionLogic_Desde_Producto=new IngredienteLogic();
			ingredienteRelacionLogic_Desde_Producto.setIngredientes(ingredienteRelacions);

			ingredienteRelacionLogic_Desde_Producto.setConnexion(this.getConnexion());
			ingredienteRelacionLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(Ingrediente ingrediente_Desde_Producto:ingredienteRelacionLogic_Desde_Producto.getIngredientes()) {
				ingrediente_Desde_Producto.setid_producto_relacion(idProductoActual);
			}

			ingredienteRelacionLogic_Desde_Producto.saveIngredientes();

			ProductoCaracLogic productocaracLogic_Desde_Producto=new ProductoCaracLogic();
			productocaracLogic_Desde_Producto.setProductoCaracs(productocaracs);

			productocaracLogic_Desde_Producto.setConnexion(this.getConnexion());
			productocaracLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ProductoCarac productocarac_Desde_Producto:productocaracLogic_Desde_Producto.getProductoCaracs()) {
				productocarac_Desde_Producto.setid_producto(idProductoActual);
			}

			productocaracLogic_Desde_Producto.saveProductoCaracs();

			ServicioClienteLogic servicioclienteLogic_Desde_Producto=new ServicioClienteLogic();
			servicioclienteLogic_Desde_Producto.setServicioClientes(servicioclientes);

			servicioclienteLogic_Desde_Producto.setConnexion(this.getConnexion());
			servicioclienteLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ServicioCliente serviciocliente_Desde_Producto:servicioclienteLogic_Desde_Producto.getServicioClientes()) {
				serviciocliente_Desde_Producto.setid_producto(idProductoActual);
			}

			servicioclienteLogic_Desde_Producto.saveServicioClientes();

			ProductoPromocionLogic productopromocionRelacionLogic_Desde_Producto=new ProductoPromocionLogic();
			productopromocionRelacionLogic_Desde_Producto.setProductoPromocions(productopromocionRelacions);

			productopromocionRelacionLogic_Desde_Producto.setConnexion(this.getConnexion());
			productopromocionRelacionLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ProductoPromocion productopromocion_Desde_Producto:productopromocionRelacionLogic_Desde_Producto.getProductoPromocions()) {
				productopromocion_Desde_Producto.setid_producto_relacion(idProductoActual);
			}

			productopromocionRelacionLogic_Desde_Producto.saveProductoPromocions();

			ProductoEspeciLogic productoespeciLogic_Desde_Producto=new ProductoEspeciLogic();
			productoespeciLogic_Desde_Producto.setProductoEspecis(productoespecis);

			productoespeciLogic_Desde_Producto.setConnexion(this.getConnexion());
			productoespeciLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ProductoEspeci productoespeci_Desde_Producto:productoespeciLogic_Desde_Producto.getProductoEspecis()) {
				productoespeci_Desde_Producto.setid_producto(idProductoActual);
			}

			productoespeciLogic_Desde_Producto.saveProductoEspecis();

			ProductoReemplaLogic productoreemplaLogic_Desde_Producto=new ProductoReemplaLogic();
			productoreemplaLogic_Desde_Producto.setProductoReemplas(productoreemplas);

			productoreemplaLogic_Desde_Producto.setConnexion(this.getConnexion());
			productoreemplaLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ProductoReempla productoreempla_Desde_Producto:productoreemplaLogic_Desde_Producto.getProductoReemplas()) {
				productoreempla_Desde_Producto.setid_producto(idProductoActual);

				productoreemplaLogic_Desde_Producto.setProductoReempla(productoreempla_Desde_Producto);
				productoreemplaLogic_Desde_Producto.saveProductoReempla();

				Long idProductoReemplaActual=productoreempla_Desde_Producto.getId();

				ProductoReemplaLogic productoreemplaLogicHijos_Desde_ProductoReempla=new ProductoReemplaLogic();

				if(productoreempla_Desde_Producto.getProductoReemplas()==null){
					productoreempla_Desde_Producto.setProductoReemplas(new ArrayList<ProductoReempla>());
				}

				productoreemplaLogicHijos_Desde_ProductoReempla.setProductoReemplas(productoreempla_Desde_Producto.getProductoReemplas());

				productoreemplaLogicHijos_Desde_ProductoReempla.setConnexion(this.getConnexion());
				productoreemplaLogicHijos_Desde_ProductoReempla.setDatosCliente(this.datosCliente);

				for(ProductoReempla productoreemplaHijos_Desde_ProductoReempla:productoreemplaLogicHijos_Desde_ProductoReempla.getProductoReemplas()) {
					productoreemplaHijos_Desde_ProductoReempla.setid_producto_reempla(idProductoReemplaActual);

					productoreemplaLogicHijos_Desde_ProductoReempla.setProductoReempla(productoreemplaHijos_Desde_ProductoReempla);
					productoreemplaLogicHijos_Desde_ProductoReempla.saveProductoReempla();
				}

			}


			ProductoEstadisticaLogic productoestadisticaLogic_Desde_Producto=new ProductoEstadisticaLogic();
			productoestadisticaLogic_Desde_Producto.setProductoEstadisticas(productoestadisticas);

			productoestadisticaLogic_Desde_Producto.setConnexion(this.getConnexion());
			productoestadisticaLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ProductoEstadistica productoestadistica_Desde_Producto:productoestadisticaLogic_Desde_Producto.getProductoEstadisticas()) {
				productoestadistica_Desde_Producto.setid_producto(idProductoActual);
			}

			productoestadisticaLogic_Desde_Producto.saveProductoEstadisticas();

			PoliticaFactuLogic politicafactuLogic_Desde_Producto=new PoliticaFactuLogic();
			politicafactuLogic_Desde_Producto.setPoliticaFactus(politicafactus);

			politicafactuLogic_Desde_Producto.setConnexion(this.getConnexion());
			politicafactuLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(PoliticaFactu politicafactu_Desde_Producto:politicafactuLogic_Desde_Producto.getPoliticaFactus()) {
				politicafactu_Desde_Producto.setid_producto(idProductoActual);
			}

			politicafactuLogic_Desde_Producto.savePoliticaFactus();

			ProductoCuentaContableLogic productocuentacontableLogic_Desde_Producto=new ProductoCuentaContableLogic();
			productocuentacontableLogic_Desde_Producto.setProductoCuentaContables(productocuentacontables);

			productocuentacontableLogic_Desde_Producto.setConnexion(this.getConnexion());
			productocuentacontableLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(ProductoCuentaContable productocuentacontable_Desde_Producto:productocuentacontableLogic_Desde_Producto.getProductoCuentaContables()) {
				productocuentacontable_Desde_Producto.setid_producto(idProductoActual);
			}

			productocuentacontableLogic_Desde_Producto.saveProductoCuentaContables();

			BodegaProductoLogic bodegaproductoLogic_Desde_Producto=new BodegaProductoLogic();
			bodegaproductoLogic_Desde_Producto.setBodegaProductos(bodegaproductos);

			bodegaproductoLogic_Desde_Producto.setConnexion(this.getConnexion());
			bodegaproductoLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(BodegaProducto bodegaproducto_Desde_Producto:bodegaproductoLogic_Desde_Producto.getBodegaProductos()) {
				bodegaproducto_Desde_Producto.setid_producto(idProductoActual);
			}

			bodegaproductoLogic_Desde_Producto.saveBodegaProductos();

			PresupuestoProductoLogic presupuestoproductoLogic_Desde_Producto=new PresupuestoProductoLogic();
			presupuestoproductoLogic_Desde_Producto.setPresupuestoProductos(presupuestoproductos);

			presupuestoproductoLogic_Desde_Producto.setConnexion(this.getConnexion());
			presupuestoproductoLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(PresupuestoProducto presupuestoproducto_Desde_Producto:presupuestoproductoLogic_Desde_Producto.getPresupuestoProductos()) {
				presupuestoproducto_Desde_Producto.setid_producto(idProductoActual);
			}

			presupuestoproductoLogic_Desde_Producto.savePresupuestoProductos();

			SaldoMesProductoLogic saldomesproductoLogic_Desde_Producto=new SaldoMesProductoLogic();
			saldomesproductoLogic_Desde_Producto.setSaldoMesProductos(saldomesproductos);

			saldomesproductoLogic_Desde_Producto.setConnexion(this.getConnexion());
			saldomesproductoLogic_Desde_Producto.setDatosCliente(this.datosCliente);

			for(SaldoMesProducto saldomesproducto_Desde_Producto:saldomesproductoLogic_Desde_Producto.getSaldoMesProductos()) {
				saldomesproducto_Desde_Producto.setid_producto(idProductoActual);
			}

			saldomesproductoLogic_Desde_Producto.saveSaldoMesProductos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoConstantesFunciones.getClassesRelationshipsOfProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

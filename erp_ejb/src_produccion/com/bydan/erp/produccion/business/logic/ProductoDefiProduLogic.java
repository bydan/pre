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
import com.bydan.erp.produccion.util.ProductoDefiProduConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoDefiProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoDefiProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoDefiProdu;
import com.bydan.erp.produccion.business.logic.ProductoDefiProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoDefiProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoDefiProduLogic.class);
	
	protected ProductoDefiProduDataAccess productodefiproduDataAccess; 	
	protected ProductoDefiProdu productodefiprodu;
	protected List<ProductoDefiProdu> productodefiprodus;
	protected Object productodefiproduObject;	
	protected List<Object> productodefiprodusObject;
	
	public static ClassValidator<ProductoDefiProdu> productodefiproduValidator = new ClassValidator<ProductoDefiProdu>(ProductoDefiProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoDefiProduLogicAdditional productodefiproduLogicAdditional=null;
	
	public ProductoDefiProduLogicAdditional getProductoDefiProduLogicAdditional() {
		return this.productodefiproduLogicAdditional;
	}
	
	public void setProductoDefiProduLogicAdditional(ProductoDefiProduLogicAdditional productodefiproduLogicAdditional) {
		try {
			this.productodefiproduLogicAdditional=productodefiproduLogicAdditional;
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
	
	
	
	
	public  ProductoDefiProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productodefiproduDataAccess = new ProductoDefiProduDataAccess();
			
			this.productodefiprodus= new ArrayList<ProductoDefiProdu>();
			this.productodefiprodu= new ProductoDefiProdu();
			
			this.productodefiproduObject=new Object();
			this.productodefiprodusObject=new ArrayList<Object>();
				
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
			
			this.productodefiproduDataAccess.setConnexionType(this.connexionType);
			this.productodefiproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoDefiProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productodefiproduDataAccess = new ProductoDefiProduDataAccess();
			this.productodefiprodus= new ArrayList<ProductoDefiProdu>();
			this.productodefiprodu= new ProductoDefiProdu();
			this.productodefiproduObject=new Object();
			this.productodefiprodusObject=new ArrayList<Object>();
			
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
			
			this.productodefiproduDataAccess.setConnexionType(this.connexionType);
			this.productodefiproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoDefiProdu getProductoDefiProdu() throws Exception {	
		ProductoDefiProduLogicAdditional.checkProductoDefiProduToGet(productodefiprodu,this.datosCliente,this.arrDatoGeneral);
		ProductoDefiProduLogicAdditional.updateProductoDefiProduToGet(productodefiprodu,this.arrDatoGeneral);
		
		return productodefiprodu;
	}
		
	public void setProductoDefiProdu(ProductoDefiProdu newProductoDefiProdu) {
		this.productodefiprodu = newProductoDefiProdu;
	}
	
	public ProductoDefiProduDataAccess getProductoDefiProduDataAccess() {
		return productodefiproduDataAccess;
	}
	
	public void setProductoDefiProduDataAccess(ProductoDefiProduDataAccess newproductodefiproduDataAccess) {
		this.productodefiproduDataAccess = newproductodefiproduDataAccess;
	}
	
	public List<ProductoDefiProdu> getProductoDefiProdus() throws Exception {		
		this.quitarProductoDefiProdusNulos();
		
		ProductoDefiProduLogicAdditional.checkProductoDefiProduToGets(productodefiprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoDefiProdu productodefiproduLocal: productodefiprodus ) {
			ProductoDefiProduLogicAdditional.updateProductoDefiProduToGet(productodefiproduLocal,this.arrDatoGeneral);
		}
		
		return productodefiprodus;
	}
	
	public void setProductoDefiProdus(List<ProductoDefiProdu> newProductoDefiProdus) {
		this.productodefiprodus = newProductoDefiProdus;
	}
	
	public Object getProductoDefiProduObject() {	
		this.productodefiproduObject=this.productodefiproduDataAccess.getEntityObject();
		return this.productodefiproduObject;
	}
		
	public void setProductoDefiProduObject(Object newProductoDefiProduObject) {
		this.productodefiproduObject = newProductoDefiProduObject;
	}
	
	public List<Object> getProductoDefiProdusObject() {		
		this.productodefiprodusObject=this.productodefiproduDataAccess.getEntitiesObject();
		return this.productodefiprodusObject;
	}
		
	public void setProductoDefiProdusObject(List<Object> newProductoDefiProdusObject) {
		this.productodefiprodusObject = newProductoDefiProdusObject;
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
		
		if(this.productodefiproduDataAccess!=null) {
			this.productodefiproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productodefiproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productodefiproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productodefiprodu = new  ProductoDefiProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productodefiprodu=productodefiproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productodefiprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodu);
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
		productodefiprodu = new  ProductoDefiProdu();
		  		  
        try {
			
			productodefiprodu=productodefiproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productodefiprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productodefiprodu = new  ProductoDefiProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productodefiprodu=productodefiproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productodefiprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodu);
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
		productodefiprodu = new  ProductoDefiProdu();
		  		  
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
		productodefiprodu = new  ProductoDefiProdu();
		  		  
        try {
			
			productodefiprodu=productodefiproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productodefiprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productodefiprodu = new  ProductoDefiProdu();
		  		  
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
		productodefiprodu = new  ProductoDefiProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productodefiproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productodefiprodu = new  ProductoDefiProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productodefiproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productodefiprodu = new  ProductoDefiProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productodefiproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productodefiprodu = new  ProductoDefiProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productodefiproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productodefiprodu = new  ProductoDefiProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productodefiproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productodefiprodu = new  ProductoDefiProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productodefiproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
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
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		  		  
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
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		  		  
        try {			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		  		  
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
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
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
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		  		  
        try {
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
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
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
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
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productodefiprodu = new  ProductoDefiProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodu=productodefiproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodu);
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
		productodefiprodu = new  ProductoDefiProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodu=productodefiproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
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
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		  		  
        try {
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoDefiProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getTodosProductoDefiProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
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
	
	public  void  getTodosProductoDefiProdus(String sFinalQuery,Pagination pagination)throws Exception {
		productodefiprodus = new  ArrayList<ProductoDefiProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoDefiProdu(productodefiprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoDefiProdu(ProductoDefiProdu productodefiprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(productodefiprodu.getIsNew() || productodefiprodu.getIsChanged()) { 
			this.invalidValues = productodefiproduValidator.getInvalidValues(productodefiprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productodefiprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoDefiProdu(List<ProductoDefiProdu> ProductoDefiProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoDefiProdu productodefiproduLocal:productodefiprodus) {				
			estaValidadoObjeto=this.validarGuardarProductoDefiProdu(productodefiproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoDefiProdu(List<ProductoDefiProdu> ProductoDefiProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoDefiProdu(productodefiprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoDefiProdu(ProductoDefiProdu ProductoDefiProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoDefiProdu(productodefiprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoDefiProdu productodefiprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productodefiprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoDefiProduConstantesFunciones.getProductoDefiProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productodefiprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoDefiProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoDefiProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoDefiProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-saveProductoDefiProduWithConnection");connexion.begin();			
			
			ProductoDefiProduLogicAdditional.checkProductoDefiProduToSave(this.productodefiprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoDefiProduLogicAdditional.updateProductoDefiProduToSave(this.productodefiprodu,this.arrDatoGeneral);
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productodefiprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoDefiProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoDefiProdu(this.productodefiprodu)) {
				ProductoDefiProduDataAccess.save(this.productodefiprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productodefiprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoDefiProduLogicAdditional.checkProductoDefiProduToSaveAfter(this.productodefiprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoDefiProdu();
			
			connexion.commit();			
			
			if(this.productodefiprodu.getIsDeleted()) {
				this.productodefiprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoDefiProdu()throws Exception {	
		try {	
			
			ProductoDefiProduLogicAdditional.checkProductoDefiProduToSave(this.productodefiprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoDefiProduLogicAdditional.updateProductoDefiProduToSave(this.productodefiprodu,this.arrDatoGeneral);
			
			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productodefiprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoDefiProdu(this.productodefiprodu)) {			
				ProductoDefiProduDataAccess.save(this.productodefiprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productodefiprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoDefiProduLogicAdditional.checkProductoDefiProduToSaveAfter(this.productodefiprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productodefiprodu.getIsDeleted()) {
				this.productodefiprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoDefiProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-saveProductoDefiProdusWithConnection");connexion.begin();			
			
			ProductoDefiProduLogicAdditional.checkProductoDefiProduToSaves(productodefiprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoDefiProdus();
			
			Boolean validadoTodosProductoDefiProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoDefiProdu productodefiproduLocal:productodefiprodus) {		
				if(productodefiproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoDefiProduLogicAdditional.updateProductoDefiProduToSave(productodefiproduLocal,this.arrDatoGeneral);
	        	
				ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productodefiproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoDefiProdu(productodefiproduLocal)) {
					ProductoDefiProduDataAccess.save(productodefiproduLocal, connexion);				
				} else {
					validadoTodosProductoDefiProdu=false;
				}
			}
			
			if(!validadoTodosProductoDefiProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoDefiProduLogicAdditional.checkProductoDefiProduToSavesAfter(productodefiprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoDefiProdus();
			
			connexion.commit();		
			
			this.quitarProductoDefiProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoDefiProdus()throws Exception {				
		 try {	
			ProductoDefiProduLogicAdditional.checkProductoDefiProduToSaves(productodefiprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoDefiProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoDefiProdu productodefiproduLocal:productodefiprodus) {				
				if(productodefiproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoDefiProduLogicAdditional.updateProductoDefiProduToSave(productodefiproduLocal,this.arrDatoGeneral);
	        	
				ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productodefiproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoDefiProdu(productodefiproduLocal)) {				
					ProductoDefiProduDataAccess.save(productodefiproduLocal, connexion);				
				} else {
					validadoTodosProductoDefiProdu=false;
				}
			}
			
			if(!validadoTodosProductoDefiProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoDefiProduLogicAdditional.checkProductoDefiProduToSavesAfter(productodefiprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoDefiProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoDefiProduParameterReturnGeneral procesarAccionProductoDefiProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoDefiProdu> productodefiprodus,ProductoDefiProduParameterReturnGeneral productodefiproduParameterGeneral)throws Exception {
		 try {	
			ProductoDefiProduParameterReturnGeneral productodefiproduReturnGeneral=new ProductoDefiProduParameterReturnGeneral();
	
			ProductoDefiProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productodefiprodus,productodefiproduParameterGeneral,productodefiproduReturnGeneral);
			
			return productodefiproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoDefiProduParameterReturnGeneral procesarAccionProductoDefiProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoDefiProdu> productodefiprodus,ProductoDefiProduParameterReturnGeneral productodefiproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-procesarAccionProductoDefiProdusWithConnection");connexion.begin();			
			
			ProductoDefiProduParameterReturnGeneral productodefiproduReturnGeneral=new ProductoDefiProduParameterReturnGeneral();
	
			ProductoDefiProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productodefiprodus,productodefiproduParameterGeneral,productodefiproduReturnGeneral);
			
			this.connexion.commit();
			
			return productodefiproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoDefiProduParameterReturnGeneral procesarEventosProductoDefiProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoDefiProdu> productodefiprodus,ProductoDefiProdu productodefiprodu,ProductoDefiProduParameterReturnGeneral productodefiproduParameterGeneral,Boolean isEsNuevoProductoDefiProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoDefiProduParameterReturnGeneral productodefiproduReturnGeneral=new ProductoDefiProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productodefiproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoDefiProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productodefiprodus,productodefiprodu,productodefiproduParameterGeneral,productodefiproduReturnGeneral,isEsNuevoProductoDefiProdu,clases);
			
			return productodefiproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoDefiProduParameterReturnGeneral procesarEventosProductoDefiProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoDefiProdu> productodefiprodus,ProductoDefiProdu productodefiprodu,ProductoDefiProduParameterReturnGeneral productodefiproduParameterGeneral,Boolean isEsNuevoProductoDefiProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-procesarEventosProductoDefiProdusWithConnection");connexion.begin();			
			
			ProductoDefiProduParameterReturnGeneral productodefiproduReturnGeneral=new ProductoDefiProduParameterReturnGeneral();
	
			productodefiproduReturnGeneral.setProductoDefiProdu(productodefiprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productodefiproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoDefiProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productodefiprodus,productodefiprodu,productodefiproduParameterGeneral,productodefiproduReturnGeneral,isEsNuevoProductoDefiProdu,clases);
			
			this.connexion.commit();
			
			return productodefiproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoDefiProduParameterReturnGeneral procesarImportacionProductoDefiProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoDefiProduParameterReturnGeneral productodefiproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-procesarImportacionProductoDefiProdusWithConnection");connexion.begin();			
			
			ProductoDefiProduParameterReturnGeneral productodefiproduReturnGeneral=new ProductoDefiProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productodefiprodus=new ArrayList<ProductoDefiProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productodefiprodu=new ProductoDefiProdu();
				
				
				if(conColumnasBase) {this.productodefiprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productodefiprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productodefiprodu.setcon_genera_sub_productos(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.productodefiprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.productodefiprodus.add(this.productodefiprodu);
			}
			
			this.saveProductoDefiProdus();
			
			this.connexion.commit();
			
			productodefiproduReturnGeneral.setConRetornoEstaProcesado(true);
			productodefiproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productodefiproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoDefiProdusEliminados() throws Exception {				
		
		List<ProductoDefiProdu> productodefiprodusAux= new ArrayList<ProductoDefiProdu>();
		
		for(ProductoDefiProdu productodefiprodu:productodefiprodus) {
			if(!productodefiprodu.getIsDeleted()) {
				productodefiprodusAux.add(productodefiprodu);
			}
		}
		
		productodefiprodus=productodefiprodusAux;
	}
	
	public void quitarProductoDefiProdusNulos() throws Exception {				
		
		List<ProductoDefiProdu> productodefiprodusAux= new ArrayList<ProductoDefiProdu>();
		
		for(ProductoDefiProdu productodefiprodu : this.productodefiprodus) {
			if(productodefiprodu==null) {
				productodefiprodusAux.add(productodefiprodu);
			}
		}
		
		//this.productodefiprodus=productodefiprodusAux;
		
		this.productodefiprodus.removeAll(productodefiprodusAux);
	}
	
	public void getSetVersionRowProductoDefiProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productodefiprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productodefiprodu.getIsDeleted() || (productodefiprodu.getIsChanged()&&!productodefiprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productodefiproduDataAccess.getSetVersionRowProductoDefiProdu(connexion,productodefiprodu.getId());
				
				if(!productodefiprodu.getVersionRow().equals(timestamp)) {	
					productodefiprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productodefiprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoDefiProdu()throws Exception {	
		
		if(productodefiprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productodefiprodu.getIsDeleted() || (productodefiprodu.getIsChanged()&&!productodefiprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productodefiproduDataAccess.getSetVersionRowProductoDefiProdu(connexion,productodefiprodu.getId());
			
			try {							
				if(!productodefiprodu.getVersionRow().equals(timestamp)) {	
					productodefiprodu.setVersionRow(timestamp);
				}
				
				productodefiprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoDefiProdusWithConnection()throws Exception {	
		if(productodefiprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoDefiProdu productodefiproduAux:productodefiprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productodefiproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productodefiproduAux.getIsDeleted() || (productodefiproduAux.getIsChanged()&&!productodefiproduAux.getIsNew())) {
						
						timestamp=productodefiproduDataAccess.getSetVersionRowProductoDefiProdu(connexion,productodefiproduAux.getId());
						
						if(!productodefiprodu.getVersionRow().equals(timestamp)) {	
							productodefiproduAux.setVersionRow(timestamp);
						}
								
						productodefiproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoDefiProdus()throws Exception {	
		if(productodefiprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoDefiProdu productodefiproduAux:productodefiprodus) {
					if(productodefiproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productodefiproduAux.getIsDeleted() || (productodefiproduAux.getIsChanged()&&!productodefiproduAux.getIsNew())) {
						
						timestamp=productodefiproduDataAccess.getSetVersionRowProductoDefiProdu(connexion,productodefiproduAux.getId());
						
						if(!productodefiproduAux.getVersionRow().equals(timestamp)) {	
							productodefiproduAux.setVersionRow(timestamp);
						}
						
													
						productodefiproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoDefiProduParameterReturnGeneral cargarCombosLoteForeignKeyProductoDefiProduWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		ProductoDefiProduParameterReturnGeneral  productodefiproduReturnGeneral =new ProductoDefiProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoDefiProduWithConnection");connexion.begin();
			
			productodefiproduReturnGeneral =new ProductoDefiProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productodefiproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productodefiproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productodefiproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productodefiproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productodefiproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productodefiproduReturnGeneral;
	}
	
	public ProductoDefiProduParameterReturnGeneral cargarCombosLoteForeignKeyProductoDefiProdu(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		ProductoDefiProduParameterReturnGeneral  productodefiproduReturnGeneral =new ProductoDefiProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productodefiproduReturnGeneral =new ProductoDefiProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productodefiproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productodefiproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productodefiproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productodefiproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productodefiproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productodefiproduReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyProductoDefiProduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoProduManoLogic productoprodumanoLogic=new ProductoProduManoLogic();
			ProductoProduMermaLogic productoprodumermaLogic=new ProductoProduMermaLogic();
			ProductoProduGastoLogic productoprodugastoLogic=new ProductoProduGastoLogic();
			ProductoProduLogic productoproduLogic=new ProductoProduLogic();
			ProductoProduMaquinaLogic productoprodumaquinaLogic=new ProductoProduMaquinaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyProductoDefiProduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProductoProduMano.class));
			classes.add(new Classe(ProductoProduMerma.class));
			classes.add(new Classe(ProductoProduGasto.class));
			classes.add(new Classe(ProductoProdu.class));
			classes.add(new Classe(ProductoProduMaquina.class));
											
			

			productoprodumanoLogic.setConnexion(this.getConnexion());
			productoprodumanoLogic.setDatosCliente(this.datosCliente);
			productoprodumanoLogic.setIsConRefrescarForeignKeys(true);

			productoprodumermaLogic.setConnexion(this.getConnexion());
			productoprodumermaLogic.setDatosCliente(this.datosCliente);
			productoprodumermaLogic.setIsConRefrescarForeignKeys(true);

			productoprodugastoLogic.setConnexion(this.getConnexion());
			productoprodugastoLogic.setDatosCliente(this.datosCliente);
			productoprodugastoLogic.setIsConRefrescarForeignKeys(true);

			productoproduLogic.setConnexion(this.getConnexion());
			productoproduLogic.setDatosCliente(this.datosCliente);
			productoproduLogic.setIsConRefrescarForeignKeys(true);

			productoprodumaquinaLogic.setConnexion(this.getConnexion());
			productoprodumaquinaLogic.setDatosCliente(this.datosCliente);
			productoprodumaquinaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(ProductoDefiProdu productodefiprodu:this.productodefiprodus) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoProduManoConstantesFunciones.getClassesForeignKeysOfProductoProduMano(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoprodumanoLogic.setProductoProduManos(productodefiprodu.productoprodumanos);
				productoprodumanoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoProduMermaConstantesFunciones.getClassesForeignKeysOfProductoProduMerma(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoprodumermaLogic.setProductoProduMermas(productodefiprodu.productoprodumermas);
				productoprodumermaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoProduGastoConstantesFunciones.getClassesForeignKeysOfProductoProduGasto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoprodugastoLogic.setProductoProduGastos(productodefiprodu.productoprodugastos);
				productoprodugastoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoProduConstantesFunciones.getClassesForeignKeysOfProductoProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoproduLogic.setProductoProdus(productodefiprodu.productoprodus);
				productoproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoprodumaquinaLogic.setProductoProduMaquinas(productodefiprodu.productoprodumaquinas);
				productoprodumaquinaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(ProductoDefiProdu productodefiprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoDefiProduLogicAdditional.updateProductoDefiProduToGet(productodefiprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productodefiprodu.setEmpresa(productodefiproduDataAccess.getEmpresa(connexion,productodefiprodu));
		productodefiprodu.setSucursal(productodefiproduDataAccess.getSucursal(connexion,productodefiprodu));
		productodefiprodu.setBodega(productodefiproduDataAccess.getBodega(connexion,productodefiprodu));
		productodefiprodu.setProducto(productodefiproduDataAccess.getProducto(connexion,productodefiprodu));
		productodefiprodu.setUnidad(productodefiproduDataAccess.getUnidad(connexion,productodefiprodu));
		productodefiprodu.setProductoProduManos(productodefiproduDataAccess.getProductoProduManos(connexion,productodefiprodu));
		productodefiprodu.setProductoProduMermas(productodefiproduDataAccess.getProductoProduMermas(connexion,productodefiprodu));
		productodefiprodu.setProductoProduGastos(productodefiproduDataAccess.getProductoProduGastos(connexion,productodefiprodu));
		productodefiprodu.setProductoProdus(productodefiproduDataAccess.getProductoProdus(connexion,productodefiprodu));
		productodefiprodu.setProductoProduMaquinas(productodefiproduDataAccess.getProductoProduMaquinas(connexion,productodefiprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productodefiprodu.setEmpresa(productodefiproduDataAccess.getEmpresa(connexion,productodefiprodu));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productodefiprodu.setSucursal(productodefiproduDataAccess.getSucursal(connexion,productodefiprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productodefiprodu.setBodega(productodefiproduDataAccess.getBodega(connexion,productodefiprodu));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productodefiprodu.setProducto(productodefiproduDataAccess.getProducto(connexion,productodefiprodu));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productodefiprodu.setUnidad(productodefiproduDataAccess.getUnidad(connexion,productodefiprodu));
				continue;
			}

			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProduManos(productodefiproduDataAccess.getProductoProduManos(connexion,productodefiprodu));

				if(this.isConDeep) {
					ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(this.connexion);
					productoprodumanoLogic.setProductoProduManos(productodefiprodu.getProductoProduManos());
					ArrayList<Classe> classesLocal=ProductoProduManoConstantesFunciones.getClassesForeignKeysOfProductoProduMano(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoprodumanoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(productoprodumanoLogic.getProductoProduManos());
					productodefiprodu.setProductoProduManos(productoprodumanoLogic.getProductoProduManos());
				}

				continue;
			}

			if(clas.clas.equals(ProductoProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProduMermas(productodefiproduDataAccess.getProductoProduMermas(connexion,productodefiprodu));

				if(this.isConDeep) {
					ProductoProduMermaLogic productoprodumermaLogic= new ProductoProduMermaLogic(this.connexion);
					productoprodumermaLogic.setProductoProduMermas(productodefiprodu.getProductoProduMermas());
					ArrayList<Classe> classesLocal=ProductoProduMermaConstantesFunciones.getClassesForeignKeysOfProductoProduMerma(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoprodumermaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(productoprodumermaLogic.getProductoProduMermas());
					productodefiprodu.setProductoProduMermas(productoprodumermaLogic.getProductoProduMermas());
				}

				continue;
			}

			if(clas.clas.equals(ProductoProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProduGastos(productodefiproduDataAccess.getProductoProduGastos(connexion,productodefiprodu));

				if(this.isConDeep) {
					ProductoProduGastoLogic productoprodugastoLogic= new ProductoProduGastoLogic(this.connexion);
					productoprodugastoLogic.setProductoProduGastos(productodefiprodu.getProductoProduGastos());
					ArrayList<Classe> classesLocal=ProductoProduGastoConstantesFunciones.getClassesForeignKeysOfProductoProduGasto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoprodugastoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduGasto(productoprodugastoLogic.getProductoProduGastos());
					productodefiprodu.setProductoProduGastos(productoprodugastoLogic.getProductoProduGastos());
				}

				continue;
			}

			if(clas.clas.equals(ProductoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProdus(productodefiproduDataAccess.getProductoProdus(connexion,productodefiprodu));

				if(this.isConDeep) {
					ProductoProduLogic productoproduLogic= new ProductoProduLogic(this.connexion);
					productoproduLogic.setProductoProdus(productodefiprodu.getProductoProdus());
					ArrayList<Classe> classesLocal=ProductoProduConstantesFunciones.getClassesForeignKeysOfProductoProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(productoproduLogic.getProductoProdus());
					productodefiprodu.setProductoProdus(productoproduLogic.getProductoProdus());
				}

				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProduMaquinas(productodefiproduDataAccess.getProductoProduMaquinas(connexion,productodefiprodu));

				if(this.isConDeep) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(this.connexion);
					productoprodumaquinaLogic.setProductoProduMaquinas(productodefiprodu.getProductoProduMaquinas());
					ArrayList<Classe> classesLocal=ProductoProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoprodumaquinaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(productoprodumaquinaLogic.getProductoProduMaquinas());
					productodefiprodu.setProductoProduMaquinas(productoprodumaquinaLogic.getProductoProduMaquinas());
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
			productodefiprodu.setEmpresa(productodefiproduDataAccess.getEmpresa(connexion,productodefiprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productodefiprodu.setSucursal(productodefiproduDataAccess.getSucursal(connexion,productodefiprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productodefiprodu.setBodega(productodefiproduDataAccess.getBodega(connexion,productodefiprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productodefiprodu.setProducto(productodefiproduDataAccess.getProducto(connexion,productodefiprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productodefiprodu.setUnidad(productodefiproduDataAccess.getUnidad(connexion,productodefiprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMano.class));
			productodefiprodu.setProductoProduManos(productodefiproduDataAccess.getProductoProduManos(connexion,productodefiprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMerma.class));
			productodefiprodu.setProductoProduMermas(productodefiproduDataAccess.getProductoProduMermas(connexion,productodefiprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduGasto.class));
			productodefiprodu.setProductoProduGastos(productodefiproduDataAccess.getProductoProduGastos(connexion,productodefiprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProdu.class));
			productodefiprodu.setProductoProdus(productodefiproduDataAccess.getProductoProdus(connexion,productodefiprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMaquina.class));
			productodefiprodu.setProductoProduMaquinas(productodefiproduDataAccess.getProductoProduMaquinas(connexion,productodefiprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productodefiprodu.setEmpresa(productodefiproduDataAccess.getEmpresa(connexion,productodefiprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productodefiprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		productodefiprodu.setSucursal(productodefiproduDataAccess.getSucursal(connexion,productodefiprodu));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productodefiprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		productodefiprodu.setBodega(productodefiproduDataAccess.getBodega(connexion,productodefiprodu));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productodefiprodu.getBodega(),isDeep,deepLoadType,clases);
				
		productodefiprodu.setProducto(productodefiproduDataAccess.getProducto(connexion,productodefiprodu));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productodefiprodu.getProducto(),isDeep,deepLoadType,clases);
				
		productodefiprodu.setUnidad(productodefiproduDataAccess.getUnidad(connexion,productodefiprodu));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productodefiprodu.getUnidad(),isDeep,deepLoadType,clases);
				

		productodefiprodu.setProductoProduManos(productodefiproduDataAccess.getProductoProduManos(connexion,productodefiprodu));

		for(ProductoProduMano productoprodumano:productodefiprodu.getProductoProduManos()) {
			ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
			productoprodumanoLogic.deepLoad(productoprodumano,isDeep,deepLoadType,clases);
		}

		productodefiprodu.setProductoProduMermas(productodefiproduDataAccess.getProductoProduMermas(connexion,productodefiprodu));

		for(ProductoProduMerma productoprodumerma:productodefiprodu.getProductoProduMermas()) {
			ProductoProduMermaLogic productoprodumermaLogic= new ProductoProduMermaLogic(connexion);
			productoprodumermaLogic.deepLoad(productoprodumerma,isDeep,deepLoadType,clases);
		}

		productodefiprodu.setProductoProduGastos(productodefiproduDataAccess.getProductoProduGastos(connexion,productodefiprodu));

		for(ProductoProduGasto productoprodugasto:productodefiprodu.getProductoProduGastos()) {
			ProductoProduGastoLogic productoprodugastoLogic= new ProductoProduGastoLogic(connexion);
			productoprodugastoLogic.deepLoad(productoprodugasto,isDeep,deepLoadType,clases);
		}

		productodefiprodu.setProductoProdus(productodefiproduDataAccess.getProductoProdus(connexion,productodefiprodu));

		for(ProductoProdu productoprodu:productodefiprodu.getProductoProdus()) {
			ProductoProduLogic productoproduLogic= new ProductoProduLogic(connexion);
			productoproduLogic.deepLoad(productoprodu,isDeep,deepLoadType,clases);
		}

		productodefiprodu.setProductoProduMaquinas(productodefiproduDataAccess.getProductoProduMaquinas(connexion,productodefiprodu));

		for(ProductoProduMaquina productoprodumaquina:productodefiprodu.getProductoProduMaquinas()) {
			ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
			productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productodefiprodu.setEmpresa(productodefiproduDataAccess.getEmpresa(connexion,productodefiprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productodefiprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productodefiprodu.setSucursal(productodefiproduDataAccess.getSucursal(connexion,productodefiprodu));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productodefiprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productodefiprodu.setBodega(productodefiproduDataAccess.getBodega(connexion,productodefiprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productodefiprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productodefiprodu.setProducto(productodefiproduDataAccess.getProducto(connexion,productodefiprodu));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productodefiprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productodefiprodu.setUnidad(productodefiproduDataAccess.getUnidad(connexion,productodefiprodu));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productodefiprodu.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProduManos(productodefiproduDataAccess.getProductoProduManos(connexion,productodefiprodu));

				for(ProductoProduMano productoprodumano:productodefiprodu.getProductoProduManos()) {
					ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
					productoprodumanoLogic.deepLoad(productoprodumano,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProduMermas(productodefiproduDataAccess.getProductoProduMermas(connexion,productodefiprodu));

				for(ProductoProduMerma productoprodumerma:productodefiprodu.getProductoProduMermas()) {
					ProductoProduMermaLogic productoprodumermaLogic= new ProductoProduMermaLogic(connexion);
					productoprodumermaLogic.deepLoad(productoprodumerma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProduGastos(productodefiproduDataAccess.getProductoProduGastos(connexion,productodefiprodu));

				for(ProductoProduGasto productoprodugasto:productodefiprodu.getProductoProduGastos()) {
					ProductoProduGastoLogic productoprodugastoLogic= new ProductoProduGastoLogic(connexion);
					productoprodugastoLogic.deepLoad(productoprodugasto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProdus(productodefiproduDataAccess.getProductoProdus(connexion,productodefiprodu));

				for(ProductoProdu productoprodu:productodefiprodu.getProductoProdus()) {
					ProductoProduLogic productoproduLogic= new ProductoProduLogic(connexion);
					productoproduLogic.deepLoad(productoprodu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				productodefiprodu.setProductoProduMaquinas(productodefiproduDataAccess.getProductoProduMaquinas(connexion,productodefiprodu));

				for(ProductoProduMaquina productoprodumaquina:productodefiprodu.getProductoProduMaquinas()) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
					productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
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
			productodefiprodu.setEmpresa(productodefiproduDataAccess.getEmpresa(connexion,productodefiprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productodefiprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productodefiprodu.setSucursal(productodefiproduDataAccess.getSucursal(connexion,productodefiprodu));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productodefiprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productodefiprodu.setBodega(productodefiproduDataAccess.getBodega(connexion,productodefiprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productodefiprodu.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productodefiprodu.setProducto(productodefiproduDataAccess.getProducto(connexion,productodefiprodu));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productodefiprodu.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productodefiprodu.setUnidad(productodefiproduDataAccess.getUnidad(connexion,productodefiprodu));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productodefiprodu.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMano.class));
			productodefiprodu.setProductoProduManos(productodefiproduDataAccess.getProductoProduManos(connexion,productodefiprodu));

			for(ProductoProduMano productoprodumano:productodefiprodu.getProductoProduManos()) {
				ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
				productoprodumanoLogic.deepLoad(productoprodumano,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMerma.class));
			productodefiprodu.setProductoProduMermas(productodefiproduDataAccess.getProductoProduMermas(connexion,productodefiprodu));

			for(ProductoProduMerma productoprodumerma:productodefiprodu.getProductoProduMermas()) {
				ProductoProduMermaLogic productoprodumermaLogic= new ProductoProduMermaLogic(connexion);
				productoprodumermaLogic.deepLoad(productoprodumerma,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduGasto.class));
			productodefiprodu.setProductoProduGastos(productodefiproduDataAccess.getProductoProduGastos(connexion,productodefiprodu));

			for(ProductoProduGasto productoprodugasto:productodefiprodu.getProductoProduGastos()) {
				ProductoProduGastoLogic productoprodugastoLogic= new ProductoProduGastoLogic(connexion);
				productoprodugastoLogic.deepLoad(productoprodugasto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProdu.class));
			productodefiprodu.setProductoProdus(productodefiproduDataAccess.getProductoProdus(connexion,productodefiprodu));

			for(ProductoProdu productoprodu:productodefiprodu.getProductoProdus()) {
				ProductoProduLogic productoproduLogic= new ProductoProduLogic(connexion);
				productoproduLogic.deepLoad(productoprodu,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMaquina.class));
			productodefiprodu.setProductoProduMaquinas(productodefiproduDataAccess.getProductoProduMaquinas(connexion,productodefiprodu));

			for(ProductoProduMaquina productoprodumaquina:productodefiprodu.getProductoProduMaquinas()) {
				ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
				productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoDefiProdu productodefiprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoDefiProduLogicAdditional.updateProductoDefiProduToSave(productodefiprodu,this.arrDatoGeneral);
			
ProductoDefiProduDataAccess.save(productodefiprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productodefiprodu.getEmpresa(),connexion);

		SucursalDataAccess.save(productodefiprodu.getSucursal(),connexion);

		BodegaDataAccess.save(productodefiprodu.getBodega(),connexion);

		ProductoDataAccess.save(productodefiprodu.getProducto(),connexion);

		UnidadDataAccess.save(productodefiprodu.getUnidad(),connexion);

		for(ProductoProduMano productoprodumano:productodefiprodu.getProductoProduManos()) {
			productoprodumano.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduManoDataAccess.save(productoprodumano,connexion);
		}

		for(ProductoProduMerma productoprodumerma:productodefiprodu.getProductoProduMermas()) {
			productoprodumerma.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduMermaDataAccess.save(productoprodumerma,connexion);
		}

		for(ProductoProduGasto productoprodugasto:productodefiprodu.getProductoProduGastos()) {
			productoprodugasto.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduGastoDataAccess.save(productoprodugasto,connexion);
		}

		for(ProductoProdu productoprodu:productodefiprodu.getProductoProdus()) {
			productoprodu.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduDataAccess.save(productoprodu,connexion);
		}

		for(ProductoProduMaquina productoprodumaquina:productodefiprodu.getProductoProduMaquinas()) {
			productoprodumaquina.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productodefiprodu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productodefiprodu.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productodefiprodu.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productodefiprodu.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productodefiprodu.getUnidad(),connexion);
				continue;
			}


			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMano productoprodumano:productodefiprodu.getProductoProduManos()) {
					productoprodumano.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduManoDataAccess.save(productoprodumano,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMerma productoprodumerma:productodefiprodu.getProductoProduMermas()) {
					productoprodumerma.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduMermaDataAccess.save(productoprodumerma,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduGasto productoprodugasto:productodefiprodu.getProductoProduGastos()) {
					productoprodugasto.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduGastoDataAccess.save(productoprodugasto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProdu productoprodu:productodefiprodu.getProductoProdus()) {
					productoprodu.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduDataAccess.save(productoprodu,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMaquina productoprodumaquina:productodefiprodu.getProductoProduMaquinas()) {
					productoprodumaquina.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productodefiprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productodefiprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(productodefiprodu.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productodefiprodu.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(productodefiprodu.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productodefiprodu.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(productodefiprodu.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productodefiprodu.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productodefiprodu.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productodefiprodu.getUnidad(),isDeep,deepLoadType,clases);
				

		for(ProductoProduMano productoprodumano:productodefiprodu.getProductoProduManos()) {
			ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
			productoprodumano.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduManoDataAccess.save(productoprodumano,connexion);
			productoprodumanoLogic.deepSave(productoprodumano,isDeep,deepLoadType,clases);
		}

		for(ProductoProduMerma productoprodumerma:productodefiprodu.getProductoProduMermas()) {
			ProductoProduMermaLogic productoprodumermaLogic= new ProductoProduMermaLogic(connexion);
			productoprodumerma.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduMermaDataAccess.save(productoprodumerma,connexion);
			productoprodumermaLogic.deepSave(productoprodumerma,isDeep,deepLoadType,clases);
		}

		for(ProductoProduGasto productoprodugasto:productodefiprodu.getProductoProduGastos()) {
			ProductoProduGastoLogic productoprodugastoLogic= new ProductoProduGastoLogic(connexion);
			productoprodugasto.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduGastoDataAccess.save(productoprodugasto,connexion);
			productoprodugastoLogic.deepSave(productoprodugasto,isDeep,deepLoadType,clases);
		}

		for(ProductoProdu productoprodu:productodefiprodu.getProductoProdus()) {
			ProductoProduLogic productoproduLogic= new ProductoProduLogic(connexion);
			productoprodu.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduDataAccess.save(productoprodu,connexion);
			productoproduLogic.deepSave(productoprodu,isDeep,deepLoadType,clases);
		}

		for(ProductoProduMaquina productoprodumaquina:productodefiprodu.getProductoProduMaquinas()) {
			ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
			productoprodumaquina.setid_producto_defi_produ(productodefiprodu.getId());
			ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
			productoprodumaquinaLogic.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productodefiprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(productodefiprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productodefiprodu.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(productodefiprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productodefiprodu.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(productodefiprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productodefiprodu.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(productodefiprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productodefiprodu.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productodefiprodu.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMano productoprodumano:productodefiprodu.getProductoProduManos()) {
					ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
					productoprodumano.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduManoDataAccess.save(productoprodumano,connexion);
					productoprodumanoLogic.deepSave(productoprodumano,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMerma productoprodumerma:productodefiprodu.getProductoProduMermas()) {
					ProductoProduMermaLogic productoprodumermaLogic= new ProductoProduMermaLogic(connexion);
					productoprodumerma.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduMermaDataAccess.save(productoprodumerma,connexion);
					productoprodumermaLogic.deepSave(productoprodumerma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduGasto productoprodugasto:productodefiprodu.getProductoProduGastos()) {
					ProductoProduGastoLogic productoprodugastoLogic= new ProductoProduGastoLogic(connexion);
					productoprodugasto.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduGastoDataAccess.save(productoprodugasto,connexion);
					productoprodugastoLogic.deepSave(productoprodugasto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProdu productoprodu:productodefiprodu.getProductoProdus()) {
					ProductoProduLogic productoproduLogic= new ProductoProduLogic(connexion);
					productoprodu.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduDataAccess.save(productoprodu,connexion);
					productoproduLogic.deepSave(productoprodu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMaquina productoprodumaquina:productodefiprodu.getProductoProduMaquinas()) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
					productoprodumaquina.setid_producto_defi_produ(productodefiprodu.getId());
					ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
					productoprodumaquinaLogic.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(ProductoDefiProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productodefiprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(productodefiprodu);
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
			this.deepLoad(this.productodefiprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoDefiProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productodefiprodus!=null) {
				for(ProductoDefiProdu productodefiprodu:productodefiprodus) {
					this.deepLoad(productodefiprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(productodefiprodus);
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
			if(productodefiprodus!=null) {
				for(ProductoDefiProdu productodefiprodu:productodefiprodus) {
					this.deepLoad(productodefiprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(productodefiprodus);
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
			this.getNewConnexionToDeep(ProductoDefiProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productodefiprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoDefiProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productodefiprodus!=null) {
				for(ProductoDefiProdu productodefiprodu:productodefiprodus) {
					this.deepSave(productodefiprodu,isDeep,deepLoadType,clases);
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
			if(productodefiprodus!=null) {
				for(ProductoDefiProdu productodefiprodu:productodefiprodus) {
					this.deepSave(productodefiprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoDefiProdusFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoDefiProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoDefiProdusFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoDefiProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoDefiProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoDefiProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoDefiProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoDefiProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoDefiProdusFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoDefiProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoDefiProdusFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoDefiProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoDefiProdusFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoDefiProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoDefiProdusFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoDefiProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoDefiProdusFK_IdUnidadUnadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoDefiProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoDefiProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadUnad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoDefiProdusFK_IdUnidadUnad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoDefiProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoDefiProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadUnad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productodefiprodus=productodefiproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoDefiProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoDefiProdu(this.productodefiprodus);
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
			if(ProductoDefiProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoDefiProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoDefiProdu productodefiprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoDefiProduConstantesFunciones.ISCONAUDITORIA) {
				if(productodefiprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoDefiProduDataAccess.TABLENAME, productodefiprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoDefiProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoDefiProduLogic.registrarAuditoriaDetallesProductoDefiProdu(connexion,productodefiprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productodefiprodu.getIsDeleted()) {
					/*if(!productodefiprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoDefiProduDataAccess.TABLENAME, productodefiprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoDefiProduLogic.registrarAuditoriaDetallesProductoDefiProdu(connexion,productodefiprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoDefiProduDataAccess.TABLENAME, productodefiprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productodefiprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoDefiProduDataAccess.TABLENAME, productodefiprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoDefiProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoDefiProduLogic.registrarAuditoriaDetallesProductoDefiProdu(connexion,productodefiprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoDefiProdu(Connexion connexion,ProductoDefiProdu productodefiprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productodefiprodu.getIsNew()||!productodefiprodu.getid_empresa().equals(productodefiprodu.getProductoDefiProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productodefiprodu.getProductoDefiProduOriginal().getid_empresa()!=null)
				{
					strValorActual=productodefiprodu.getProductoDefiProduOriginal().getid_empresa().toString();
				}
				if(productodefiprodu.getid_empresa()!=null)
				{
					strValorNuevo=productodefiprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoDefiProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productodefiprodu.getIsNew()||!productodefiprodu.getid_sucursal().equals(productodefiprodu.getProductoDefiProduOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productodefiprodu.getProductoDefiProduOriginal().getid_sucursal()!=null)
				{
					strValorActual=productodefiprodu.getProductoDefiProduOriginal().getid_sucursal().toString();
				}
				if(productodefiprodu.getid_sucursal()!=null)
				{
					strValorNuevo=productodefiprodu.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoDefiProduConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(productodefiprodu.getIsNew()||!productodefiprodu.getid_bodega().equals(productodefiprodu.getProductoDefiProduOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productodefiprodu.getProductoDefiProduOriginal().getid_bodega()!=null)
				{
					strValorActual=productodefiprodu.getProductoDefiProduOriginal().getid_bodega().toString();
				}
				if(productodefiprodu.getid_bodega()!=null)
				{
					strValorNuevo=productodefiprodu.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoDefiProduConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(productodefiprodu.getIsNew()||!productodefiprodu.getid_producto().equals(productodefiprodu.getProductoDefiProduOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productodefiprodu.getProductoDefiProduOriginal().getid_producto()!=null)
				{
					strValorActual=productodefiprodu.getProductoDefiProduOriginal().getid_producto().toString();
				}
				if(productodefiprodu.getid_producto()!=null)
				{
					strValorNuevo=productodefiprodu.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoDefiProduConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(productodefiprodu.getIsNew()||!productodefiprodu.getid_unidad().equals(productodefiprodu.getProductoDefiProduOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productodefiprodu.getProductoDefiProduOriginal().getid_unidad()!=null)
				{
					strValorActual=productodefiprodu.getProductoDefiProduOriginal().getid_unidad().toString();
				}
				if(productodefiprodu.getid_unidad()!=null)
				{
					strValorNuevo=productodefiprodu.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoDefiProduConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productodefiprodu.getIsNew()||!productodefiprodu.getcon_genera_sub_productos().equals(productodefiprodu.getProductoDefiProduOriginal().getcon_genera_sub_productos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productodefiprodu.getProductoDefiProduOriginal().getcon_genera_sub_productos()!=null)
				{
					strValorActual=productodefiprodu.getProductoDefiProduOriginal().getcon_genera_sub_productos().toString();
				}
				if(productodefiprodu.getcon_genera_sub_productos()!=null)
				{
					strValorNuevo=productodefiprodu.getcon_genera_sub_productos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS,strValorActual,strValorNuevo);
			}	
			
			if(productodefiprodu.getIsNew()||!productodefiprodu.getdescripcion().equals(productodefiprodu.getProductoDefiProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productodefiprodu.getProductoDefiProduOriginal().getdescripcion()!=null)
				{
					strValorActual=productodefiprodu.getProductoDefiProduOriginal().getdescripcion();
				}
				if(productodefiprodu.getdescripcion()!=null)
				{
					strValorNuevo=productodefiprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoDefiProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoDefiProduRelacionesWithConnection(ProductoDefiProdu productodefiprodu,List<ProductoProduMano> productoprodumanos,List<ProductoProduMerma> productoprodumermas,List<ProductoProduGasto> productoprodugastos,List<ProductoProdu> productoprodus,List<ProductoProduMaquina> productoprodumaquinas) throws Exception {

		if(!productodefiprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoDefiProduRelacionesBase(productodefiprodu,productoprodumanos,productoprodumermas,productoprodugastos,productoprodus,productoprodumaquinas,true);
		}
	}

	public void saveProductoDefiProduRelaciones(ProductoDefiProdu productodefiprodu,List<ProductoProduMano> productoprodumanos,List<ProductoProduMerma> productoprodumermas,List<ProductoProduGasto> productoprodugastos,List<ProductoProdu> productoprodus,List<ProductoProduMaquina> productoprodumaquinas)throws Exception {

		if(!productodefiprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoDefiProduRelacionesBase(productodefiprodu,productoprodumanos,productoprodumermas,productoprodugastos,productoprodus,productoprodumaquinas,false);
		}
	}

	public void saveProductoDefiProduRelacionesBase(ProductoDefiProdu productodefiprodu,List<ProductoProduMano> productoprodumanos,List<ProductoProduMerma> productoprodumermas,List<ProductoProduGasto> productoprodugastos,List<ProductoProdu> productoprodus,List<ProductoProduMaquina> productoprodumaquinas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoDefiProdu-saveRelacionesWithConnection");}
	
			productodefiprodu.setProductoProduManos(productoprodumanos);
			productodefiprodu.setProductoProduMermas(productoprodumermas);
			productodefiprodu.setProductoProduGastos(productoprodugastos);
			productodefiprodu.setProductoProdus(productoprodus);
			productodefiprodu.setProductoProduMaquinas(productoprodumaquinas);

			this.setProductoDefiProdu(productodefiprodu);

			if(ProductoDefiProduLogicAdditional.validarSaveRelaciones(productodefiprodu,this)) {

				ProductoDefiProduLogicAdditional.updateRelacionesToSave(productodefiprodu,this);

				if((productodefiprodu.getIsNew()||productodefiprodu.getIsChanged())&&!productodefiprodu.getIsDeleted()) {
					this.saveProductoDefiProdu();
					this.saveProductoDefiProduRelacionesDetalles(productoprodumanos,productoprodumermas,productoprodugastos,productoprodus,productoprodumaquinas);

				} else if(productodefiprodu.getIsDeleted()) {
					this.saveProductoDefiProduRelacionesDetalles(productoprodumanos,productoprodumermas,productoprodugastos,productoprodus,productoprodumaquinas);
					this.saveProductoDefiProdu();
				}

				ProductoDefiProduLogicAdditional.updateRelacionesToSaveAfter(productodefiprodu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoProduManoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoProduManos(productoprodumanos,true,true);
			ProductoProduMermaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoProduMermas(productoprodumermas,true,true);
			ProductoProduGastoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoProduGastos(productoprodugastos,true,true);
			ProductoProduConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoProdus(productoprodus,true,true);
			ProductoProduMaquinaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoProduMaquinas(productoprodumaquinas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveProductoDefiProduRelacionesDetalles(List<ProductoProduMano> productoprodumanos,List<ProductoProduMerma> productoprodumermas,List<ProductoProduGasto> productoprodugastos,List<ProductoProdu> productoprodus,List<ProductoProduMaquina> productoprodumaquinas)throws Exception {
		try {
	

			Long idProductoDefiProduActual=this.getProductoDefiProdu().getId();

			ProductoProduManoLogic productoprodumanoLogic_Desde_ProductoDefiProdu=new ProductoProduManoLogic();
			productoprodumanoLogic_Desde_ProductoDefiProdu.setProductoProduManos(productoprodumanos);

			productoprodumanoLogic_Desde_ProductoDefiProdu.setConnexion(this.getConnexion());
			productoprodumanoLogic_Desde_ProductoDefiProdu.setDatosCliente(this.datosCliente);

			for(ProductoProduMano productoprodumano_Desde_ProductoDefiProdu:productoprodumanoLogic_Desde_ProductoDefiProdu.getProductoProduManos()) {
				productoprodumano_Desde_ProductoDefiProdu.setid_producto_defi_produ(idProductoDefiProduActual);
			}

			productoprodumanoLogic_Desde_ProductoDefiProdu.saveProductoProduManos();

			ProductoProduMermaLogic productoprodumermaLogic_Desde_ProductoDefiProdu=new ProductoProduMermaLogic();
			productoprodumermaLogic_Desde_ProductoDefiProdu.setProductoProduMermas(productoprodumermas);

			productoprodumermaLogic_Desde_ProductoDefiProdu.setConnexion(this.getConnexion());
			productoprodumermaLogic_Desde_ProductoDefiProdu.setDatosCliente(this.datosCliente);

			for(ProductoProduMerma productoprodumerma_Desde_ProductoDefiProdu:productoprodumermaLogic_Desde_ProductoDefiProdu.getProductoProduMermas()) {
				productoprodumerma_Desde_ProductoDefiProdu.setid_producto_defi_produ(idProductoDefiProduActual);
			}

			productoprodumermaLogic_Desde_ProductoDefiProdu.saveProductoProduMermas();

			ProductoProduGastoLogic productoprodugastoLogic_Desde_ProductoDefiProdu=new ProductoProduGastoLogic();
			productoprodugastoLogic_Desde_ProductoDefiProdu.setProductoProduGastos(productoprodugastos);

			productoprodugastoLogic_Desde_ProductoDefiProdu.setConnexion(this.getConnexion());
			productoprodugastoLogic_Desde_ProductoDefiProdu.setDatosCliente(this.datosCliente);

			for(ProductoProduGasto productoprodugasto_Desde_ProductoDefiProdu:productoprodugastoLogic_Desde_ProductoDefiProdu.getProductoProduGastos()) {
				productoprodugasto_Desde_ProductoDefiProdu.setid_producto_defi_produ(idProductoDefiProduActual);
			}

			productoprodugastoLogic_Desde_ProductoDefiProdu.saveProductoProduGastos();

			ProductoProduLogic productoproduLogic_Desde_ProductoDefiProdu=new ProductoProduLogic();
			productoproduLogic_Desde_ProductoDefiProdu.setProductoProdus(productoprodus);

			productoproduLogic_Desde_ProductoDefiProdu.setConnexion(this.getConnexion());
			productoproduLogic_Desde_ProductoDefiProdu.setDatosCliente(this.datosCliente);

			for(ProductoProdu productoprodu_Desde_ProductoDefiProdu:productoproduLogic_Desde_ProductoDefiProdu.getProductoProdus()) {
				productoprodu_Desde_ProductoDefiProdu.setid_producto_defi_produ(idProductoDefiProduActual);
			}

			productoproduLogic_Desde_ProductoDefiProdu.saveProductoProdus();

			ProductoProduMaquinaLogic productoprodumaquinaLogic_Desde_ProductoDefiProdu=new ProductoProduMaquinaLogic();
			productoprodumaquinaLogic_Desde_ProductoDefiProdu.setProductoProduMaquinas(productoprodumaquinas);

			productoprodumaquinaLogic_Desde_ProductoDefiProdu.setConnexion(this.getConnexion());
			productoprodumaquinaLogic_Desde_ProductoDefiProdu.setDatosCliente(this.datosCliente);

			for(ProductoProduMaquina productoprodumaquina_Desde_ProductoDefiProdu:productoprodumaquinaLogic_Desde_ProductoDefiProdu.getProductoProduMaquinas()) {
				productoprodumaquina_Desde_ProductoDefiProdu.setid_producto_defi_produ(idProductoDefiProduActual);
			}

			productoprodumaquinaLogic_Desde_ProductoDefiProdu.saveProductoProduMaquinas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoDefiProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoDefiProduConstantesFunciones.getClassesForeignKeysOfProductoDefiProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoDefiProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoDefiProduConstantesFunciones.getClassesRelationshipsOfProductoDefiProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

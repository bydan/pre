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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoOrdenDetaProdu;
import com.bydan.erp.produccion.business.logic.ProductoOrdenDetaProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoOrdenDetaProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoOrdenDetaProduLogic.class);
	
	protected ProductoOrdenDetaProduDataAccess productoordendetaproduDataAccess; 	
	protected ProductoOrdenDetaProdu productoordendetaprodu;
	protected List<ProductoOrdenDetaProdu> productoordendetaprodus;
	protected Object productoordendetaproduObject;	
	protected List<Object> productoordendetaprodusObject;
	
	public static ClassValidator<ProductoOrdenDetaProdu> productoordendetaproduValidator = new ClassValidator<ProductoOrdenDetaProdu>(ProductoOrdenDetaProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoOrdenDetaProduLogicAdditional productoordendetaproduLogicAdditional=null;
	
	public ProductoOrdenDetaProduLogicAdditional getProductoOrdenDetaProduLogicAdditional() {
		return this.productoordendetaproduLogicAdditional;
	}
	
	public void setProductoOrdenDetaProduLogicAdditional(ProductoOrdenDetaProduLogicAdditional productoordendetaproduLogicAdditional) {
		try {
			this.productoordendetaproduLogicAdditional=productoordendetaproduLogicAdditional;
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
	
	
	
	
	public  ProductoOrdenDetaProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoordendetaproduDataAccess = new ProductoOrdenDetaProduDataAccess();
			
			this.productoordendetaprodus= new ArrayList<ProductoOrdenDetaProdu>();
			this.productoordendetaprodu= new ProductoOrdenDetaProdu();
			
			this.productoordendetaproduObject=new Object();
			this.productoordendetaprodusObject=new ArrayList<Object>();
				
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
			
			this.productoordendetaproduDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoOrdenDetaProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoordendetaproduDataAccess = new ProductoOrdenDetaProduDataAccess();
			this.productoordendetaprodus= new ArrayList<ProductoOrdenDetaProdu>();
			this.productoordendetaprodu= new ProductoOrdenDetaProdu();
			this.productoordendetaproduObject=new Object();
			this.productoordendetaprodusObject=new ArrayList<Object>();
			
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
			
			this.productoordendetaproduDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoOrdenDetaProdu getProductoOrdenDetaProdu() throws Exception {	
		ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToGet(productoordendetaprodu,this.datosCliente,this.arrDatoGeneral);
		ProductoOrdenDetaProduLogicAdditional.updateProductoOrdenDetaProduToGet(productoordendetaprodu,this.arrDatoGeneral);
		
		return productoordendetaprodu;
	}
		
	public void setProductoOrdenDetaProdu(ProductoOrdenDetaProdu newProductoOrdenDetaProdu) {
		this.productoordendetaprodu = newProductoOrdenDetaProdu;
	}
	
	public ProductoOrdenDetaProduDataAccess getProductoOrdenDetaProduDataAccess() {
		return productoordendetaproduDataAccess;
	}
	
	public void setProductoOrdenDetaProduDataAccess(ProductoOrdenDetaProduDataAccess newproductoordendetaproduDataAccess) {
		this.productoordendetaproduDataAccess = newproductoordendetaproduDataAccess;
	}
	
	public List<ProductoOrdenDetaProdu> getProductoOrdenDetaProdus() throws Exception {		
		this.quitarProductoOrdenDetaProdusNulos();
		
		ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToGets(productoordendetaprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoOrdenDetaProdu productoordendetaproduLocal: productoordendetaprodus ) {
			ProductoOrdenDetaProduLogicAdditional.updateProductoOrdenDetaProduToGet(productoordendetaproduLocal,this.arrDatoGeneral);
		}
		
		return productoordendetaprodus;
	}
	
	public void setProductoOrdenDetaProdus(List<ProductoOrdenDetaProdu> newProductoOrdenDetaProdus) {
		this.productoordendetaprodus = newProductoOrdenDetaProdus;
	}
	
	public Object getProductoOrdenDetaProduObject() {	
		this.productoordendetaproduObject=this.productoordendetaproduDataAccess.getEntityObject();
		return this.productoordendetaproduObject;
	}
		
	public void setProductoOrdenDetaProduObject(Object newProductoOrdenDetaProduObject) {
		this.productoordendetaproduObject = newProductoOrdenDetaProduObject;
	}
	
	public List<Object> getProductoOrdenDetaProdusObject() {		
		this.productoordendetaprodusObject=this.productoordendetaproduDataAccess.getEntitiesObject();
		return this.productoordendetaprodusObject;
	}
		
	public void setProductoOrdenDetaProdusObject(List<Object> newProductoOrdenDetaProdusObject) {
		this.productoordendetaprodusObject = newProductoOrdenDetaProdusObject;
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
		
		if(this.productoordendetaproduDataAccess!=null) {
			this.productoordendetaproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoordendetaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoordendetaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodu=productoordendetaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodu);
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
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		  		  
        try {
			
			productoordendetaprodu=productoordendetaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodu=productoordendetaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodu);
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
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		  		  
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
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		  		  
        try {
			
			productoordendetaprodu=productoordendetaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		  		  
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
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoordendetaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoordendetaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoordendetaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoordendetaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoordendetaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoordendetaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
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
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		  		  
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
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		  		  
        try {			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		  		  
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
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
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
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		  		  
        try {
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
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
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
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
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodu=productoordendetaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodu);
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
		productoordendetaprodu = new  ProductoOrdenDetaProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodu=productoordendetaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
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
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		  		  
        try {
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoOrdenDetaProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getTodosProductoOrdenDetaProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
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
	
	public  void  getTodosProductoOrdenDetaProdus(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodus = new  ArrayList<ProductoOrdenDetaProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProdu(productoordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoOrdenDetaProdu(ProductoOrdenDetaProdu productoordendetaprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(productoordendetaprodu.getIsNew() || productoordendetaprodu.getIsChanged()) { 
			this.invalidValues = productoordendetaproduValidator.getInvalidValues(productoordendetaprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoordendetaprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoOrdenDetaProdu(List<ProductoOrdenDetaProdu> ProductoOrdenDetaProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoOrdenDetaProdu productoordendetaproduLocal:productoordendetaprodus) {				
			estaValidadoObjeto=this.validarGuardarProductoOrdenDetaProdu(productoordendetaproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoOrdenDetaProdu(List<ProductoOrdenDetaProdu> ProductoOrdenDetaProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProdu(productoordendetaprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoOrdenDetaProdu(ProductoOrdenDetaProdu ProductoOrdenDetaProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProdu(productoordendetaprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoOrdenDetaProdu productoordendetaprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoordendetaprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoOrdenDetaProduConstantesFunciones.getProductoOrdenDetaProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoordendetaprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoOrdenDetaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoOrdenDetaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoOrdenDetaProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-saveProductoOrdenDetaProduWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToSave(this.productoordendetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduLogicAdditional.updateProductoOrdenDetaProduToSave(this.productoordendetaprodu,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProdu(this.productoordendetaprodu)) {
				ProductoOrdenDetaProduDataAccess.save(this.productoordendetaprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToSaveAfter(this.productoordendetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProdu();
			
			connexion.commit();			
			
			if(this.productoordendetaprodu.getIsDeleted()) {
				this.productoordendetaprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoOrdenDetaProdu()throws Exception {	
		try {	
			
			ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToSave(this.productoordendetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduLogicAdditional.updateProductoOrdenDetaProduToSave(this.productoordendetaprodu,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProdu(this.productoordendetaprodu)) {			
				ProductoOrdenDetaProduDataAccess.save(this.productoordendetaprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToSaveAfter(this.productoordendetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoordendetaprodu.getIsDeleted()) {
				this.productoordendetaprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoOrdenDetaProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-saveProductoOrdenDetaProdusWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToSaves(productoordendetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProdus();
			
			Boolean validadoTodosProductoOrdenDetaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProdu productoordendetaproduLocal:productoordendetaprodus) {		
				if(productoordendetaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduLogicAdditional.updateProductoOrdenDetaProduToSave(productoordendetaproduLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProdu(productoordendetaproduLocal)) {
					ProductoOrdenDetaProduDataAccess.save(productoordendetaproduLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProdu=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToSavesAfter(productoordendetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProdus();
			
			connexion.commit();		
			
			this.quitarProductoOrdenDetaProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoOrdenDetaProdus()throws Exception {				
		 try {	
			ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToSaves(productoordendetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoOrdenDetaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProdu productoordendetaproduLocal:productoordendetaprodus) {				
				if(productoordendetaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduLogicAdditional.updateProductoOrdenDetaProduToSave(productoordendetaproduLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProdu(productoordendetaproduLocal)) {				
					ProductoOrdenDetaProduDataAccess.save(productoordendetaproduLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProdu=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduLogicAdditional.checkProductoOrdenDetaProduToSavesAfter(productoordendetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoOrdenDetaProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduParameterReturnGeneral procesarAccionProductoOrdenDetaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProdu> productoordendetaprodus,ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduParameterGeneral)throws Exception {
		 try {	
			ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduReturnGeneral=new ProductoOrdenDetaProduParameterReturnGeneral();
	
			ProductoOrdenDetaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodus,productoordendetaproduParameterGeneral,productoordendetaproduReturnGeneral);
			
			return productoordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduParameterReturnGeneral procesarAccionProductoOrdenDetaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProdu> productoordendetaprodus,ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-procesarAccionProductoOrdenDetaProdusWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduReturnGeneral=new ProductoOrdenDetaProduParameterReturnGeneral();
	
			ProductoOrdenDetaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodus,productoordendetaproduParameterGeneral,productoordendetaproduReturnGeneral);
			
			this.connexion.commit();
			
			return productoordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduParameterReturnGeneral procesarEventosProductoOrdenDetaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProdu> productoordendetaprodus,ProductoOrdenDetaProdu productoordendetaprodu,ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduReturnGeneral=new ProductoOrdenDetaProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodus,productoordendetaprodu,productoordendetaproduParameterGeneral,productoordendetaproduReturnGeneral,isEsNuevoProductoOrdenDetaProdu,clases);
			
			return productoordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoOrdenDetaProduParameterReturnGeneral procesarEventosProductoOrdenDetaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProdu> productoordendetaprodus,ProductoOrdenDetaProdu productoordendetaprodu,ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-procesarEventosProductoOrdenDetaProdusWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduReturnGeneral=new ProductoOrdenDetaProduParameterReturnGeneral();
	
			productoordendetaproduReturnGeneral.setProductoOrdenDetaProdu(productoordendetaprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodus,productoordendetaprodu,productoordendetaproduParameterGeneral,productoordendetaproduReturnGeneral,isEsNuevoProductoOrdenDetaProdu,clases);
			
			this.connexion.commit();
			
			return productoordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduParameterReturnGeneral procesarImportacionProductoOrdenDetaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-procesarImportacionProductoOrdenDetaProdusWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduParameterReturnGeneral productoordendetaproduReturnGeneral=new ProductoOrdenDetaProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoordendetaprodus=new ArrayList<ProductoOrdenDetaProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoordendetaprodu=new ProductoOrdenDetaProdu();
				
				
				if(conColumnasBase) {this.productoordendetaprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoordendetaprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoordendetaprodu.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodu.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoordendetaprodu.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodu.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
			this.productoordendetaprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoordendetaprodus.add(this.productoordendetaprodu);
			}
			
			this.saveProductoOrdenDetaProdus();
			
			this.connexion.commit();
			
			productoordendetaproduReturnGeneral.setConRetornoEstaProcesado(true);
			productoordendetaproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoOrdenDetaProdusEliminados() throws Exception {				
		
		List<ProductoOrdenDetaProdu> productoordendetaprodusAux= new ArrayList<ProductoOrdenDetaProdu>();
		
		for(ProductoOrdenDetaProdu productoordendetaprodu:productoordendetaprodus) {
			if(!productoordendetaprodu.getIsDeleted()) {
				productoordendetaprodusAux.add(productoordendetaprodu);
			}
		}
		
		productoordendetaprodus=productoordendetaprodusAux;
	}
	
	public void quitarProductoOrdenDetaProdusNulos() throws Exception {				
		
		List<ProductoOrdenDetaProdu> productoordendetaprodusAux= new ArrayList<ProductoOrdenDetaProdu>();
		
		for(ProductoOrdenDetaProdu productoordendetaprodu : this.productoordendetaprodus) {
			if(productoordendetaprodu==null) {
				productoordendetaprodusAux.add(productoordendetaprodu);
			}
		}
		
		//this.productoordendetaprodus=productoordendetaprodusAux;
		
		this.productoordendetaprodus.removeAll(productoordendetaprodusAux);
	}
	
	public void getSetVersionRowProductoOrdenDetaProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoordendetaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoordendetaprodu.getIsDeleted() || (productoordendetaprodu.getIsChanged()&&!productoordendetaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoordendetaproduDataAccess.getSetVersionRowProductoOrdenDetaProdu(connexion,productoordendetaprodu.getId());
				
				if(!productoordendetaprodu.getVersionRow().equals(timestamp)) {	
					productoordendetaprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoordendetaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoOrdenDetaProdu()throws Exception {	
		
		if(productoordendetaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoordendetaprodu.getIsDeleted() || (productoordendetaprodu.getIsChanged()&&!productoordendetaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoordendetaproduDataAccess.getSetVersionRowProductoOrdenDetaProdu(connexion,productoordendetaprodu.getId());
			
			try {							
				if(!productoordendetaprodu.getVersionRow().equals(timestamp)) {	
					productoordendetaprodu.setVersionRow(timestamp);
				}
				
				productoordendetaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoOrdenDetaProdusWithConnection()throws Exception {	
		if(productoordendetaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoOrdenDetaProdu productoordendetaproduAux:productoordendetaprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoordendetaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaproduAux.getIsDeleted() || (productoordendetaproduAux.getIsChanged()&&!productoordendetaproduAux.getIsNew())) {
						
						timestamp=productoordendetaproduDataAccess.getSetVersionRowProductoOrdenDetaProdu(connexion,productoordendetaproduAux.getId());
						
						if(!productoordendetaprodu.getVersionRow().equals(timestamp)) {	
							productoordendetaproduAux.setVersionRow(timestamp);
						}
								
						productoordendetaproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoOrdenDetaProdus()throws Exception {	
		if(productoordendetaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoOrdenDetaProdu productoordendetaproduAux:productoordendetaprodus) {
					if(productoordendetaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaproduAux.getIsDeleted() || (productoordendetaproduAux.getIsChanged()&&!productoordendetaproduAux.getIsNew())) {
						
						timestamp=productoordendetaproduDataAccess.getSetVersionRowProductoOrdenDetaProdu(connexion,productoordendetaproduAux.getId());
						
						if(!productoordendetaproduAux.getVersionRow().equals(timestamp)) {	
							productoordendetaproduAux.setVersionRow(timestamp);
						}
						
													
						productoordendetaproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoOrdenDetaProduParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProduWithConnection(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduParameterReturnGeneral  productoordendetaproduReturnGeneral =new ProductoOrdenDetaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoOrdenDetaProduWithConnection");connexion.begin();
			
			productoordendetaproduReturnGeneral =new ProductoOrdenDetaProduParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaproduReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoordendetaproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoordendetaproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoordendetaproduReturnGeneral;
	}
	
	public ProductoOrdenDetaProduParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProdu(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduParameterReturnGeneral  productoordendetaproduReturnGeneral =new ProductoOrdenDetaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoordendetaproduReturnGeneral =new ProductoOrdenDetaProduParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaproduReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoordendetaproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoordendetaproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoordendetaproduReturnGeneral;
	}
	
	
	public void deepLoad(ProductoOrdenDetaProdu productoordendetaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoOrdenDetaProduLogicAdditional.updateProductoOrdenDetaProduToGet(productoordendetaprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodu.setOrdenDetaProdu(productoordendetaproduDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodu));
		productoordendetaprodu.setBodega(productoordendetaproduDataAccess.getBodega(connexion,productoordendetaprodu));
		productoordendetaprodu.setProducto(productoordendetaproduDataAccess.getProducto(connexion,productoordendetaprodu));
		productoordendetaprodu.setUnidad(productoordendetaproduDataAccess.getUnidad(connexion,productoordendetaprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodu.setOrdenDetaProdu(productoordendetaproduDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoordendetaprodu.setBodega(productoordendetaproduDataAccess.getBodega(connexion,productoordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoordendetaprodu.setProducto(productoordendetaproduDataAccess.getProducto(connexion,productoordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodu.setUnidad(productoordendetaproduDataAccess.getUnidad(connexion,productoordendetaprodu));
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
			productoordendetaprodu.setOrdenDetaProdu(productoordendetaproduDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodu.setBodega(productoordendetaproduDataAccess.getBodega(connexion,productoordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodu.setProducto(productoordendetaproduDataAccess.getProducto(connexion,productoordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodu.setUnidad(productoordendetaproduDataAccess.getUnidad(connexion,productoordendetaprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodu.setOrdenDetaProdu(productoordendetaproduDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodu));
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodu.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		productoordendetaprodu.setBodega(productoordendetaproduDataAccess.getBodega(connexion,productoordendetaprodu));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoordendetaprodu.getBodega(),isDeep,deepLoadType,clases);
				
		productoordendetaprodu.setProducto(productoordendetaproduDataAccess.getProducto(connexion,productoordendetaprodu));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoordendetaprodu.getProducto(),isDeep,deepLoadType,clases);
				
		productoordendetaprodu.setUnidad(productoordendetaproduDataAccess.getUnidad(connexion,productoordendetaprodu));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodu.setOrdenDetaProdu(productoordendetaproduDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodu));
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepLoad(productoordendetaprodu.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoordendetaprodu.setBodega(productoordendetaproduDataAccess.getBodega(connexion,productoordendetaprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productoordendetaprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoordendetaprodu.setProducto(productoordendetaproduDataAccess.getProducto(connexion,productoordendetaprodu));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productoordendetaprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodu.setUnidad(productoordendetaproduDataAccess.getUnidad(connexion,productoordendetaprodu));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);				
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
			productoordendetaprodu.setOrdenDetaProdu(productoordendetaproduDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodu));
			OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
			ordendetaproduLogic.deepLoad(productoordendetaprodu.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodu.setBodega(productoordendetaproduDataAccess.getBodega(connexion,productoordendetaprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productoordendetaprodu.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodu.setProducto(productoordendetaproduDataAccess.getProducto(connexion,productoordendetaprodu));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productoordendetaprodu.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodu.setUnidad(productoordendetaproduDataAccess.getUnidad(connexion,productoordendetaprodu));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoOrdenDetaProdu productoordendetaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoOrdenDetaProduLogicAdditional.updateProductoOrdenDetaProduToSave(productoordendetaprodu,this.arrDatoGeneral);
			
ProductoOrdenDetaProduDataAccess.save(productoordendetaprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodu.getOrdenDetaProdu(),connexion);

		BodegaDataAccess.save(productoordendetaprodu.getBodega(),connexion);

		ProductoDataAccess.save(productoordendetaprodu.getProducto(),connexion);

		UnidadDataAccess.save(productoordendetaprodu.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodu.getOrdenDetaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoordendetaprodu.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoordendetaprodu.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodu.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodu.getOrdenDetaProdu(),connexion);
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodu.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(productoordendetaprodu.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoordendetaprodu.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(productoordendetaprodu.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoordendetaprodu.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoordendetaprodu.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodu.getOrdenDetaProdu(),connexion);
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepSave(productoordendetaprodu.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoordendetaprodu.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(productoordendetaprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoordendetaprodu.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(productoordendetaprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodu.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoordendetaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(productoordendetaprodu);
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
			this.deepLoad(this.productoordendetaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoOrdenDetaProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoordendetaprodus!=null) {
				for(ProductoOrdenDetaProdu productoordendetaprodu:productoordendetaprodus) {
					this.deepLoad(productoordendetaprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(productoordendetaprodus);
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
			if(productoordendetaprodus!=null) {
				for(ProductoOrdenDetaProdu productoordendetaprodu:productoordendetaprodus) {
					this.deepLoad(productoordendetaprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(productoordendetaprodus);
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoordendetaprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoordendetaprodus!=null) {
				for(ProductoOrdenDetaProdu productoordendetaprodu:productoordendetaprodus) {
					this.deepSave(productoordendetaprodu,isDeep,deepLoadType,clases);
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
			if(productoordendetaprodus!=null) {
				for(ProductoOrdenDetaProdu productoordendetaprodu:productoordendetaprodus) {
					this.deepSave(productoordendetaprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoOrdenDetaProdusFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoOrdenDetaProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProdusFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoOrdenDetaProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProdusFK_IdOrdenDetaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProdusFK_IdOrdenDetaProdu(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProdusFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProdusFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProdusFK_IdUnidadUnadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadUnad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProdusFK_IdUnidadUnad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadUnad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(this.productoordendetaprodus);
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
			if(ProductoOrdenDetaProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoOrdenDetaProdu productoordendetaprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoOrdenDetaProduConstantesFunciones.ISCONAUDITORIA) {
				if(productoordendetaprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduDataAccess.TABLENAME, productoordendetaprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduLogic.registrarAuditoriaDetallesProductoOrdenDetaProdu(connexion,productoordendetaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoordendetaprodu.getIsDeleted()) {
					/*if(!productoordendetaprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoOrdenDetaProduDataAccess.TABLENAME, productoordendetaprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoOrdenDetaProduLogic.registrarAuditoriaDetallesProductoOrdenDetaProdu(connexion,productoordendetaprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduDataAccess.TABLENAME, productoordendetaprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoordendetaprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduDataAccess.TABLENAME, productoordendetaprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduLogic.registrarAuditoriaDetallesProductoOrdenDetaProdu(connexion,productoordendetaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoOrdenDetaProdu(Connexion connexion,ProductoOrdenDetaProdu productoordendetaprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoordendetaprodu.getIsNew()||!productoordendetaprodu.getid_orden_deta_produ().equals(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_orden_deta_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_orden_deta_produ()!=null)
				{
					strValorActual=productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_orden_deta_produ().toString();
				}
				if(productoordendetaprodu.getid_orden_deta_produ()!=null)
				{
					strValorNuevo=productoordendetaprodu.getid_orden_deta_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodu.getIsNew()||!productoordendetaprodu.getid_bodega().equals(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_bodega()!=null)
				{
					strValorActual=productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_bodega().toString();
				}
				if(productoordendetaprodu.getid_bodega()!=null)
				{
					strValorNuevo=productoordendetaprodu.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodu.getIsNew()||!productoordendetaprodu.getid_producto().equals(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_producto()!=null)
				{
					strValorActual=productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_producto().toString();
				}
				if(productoordendetaprodu.getid_producto()!=null)
				{
					strValorNuevo=productoordendetaprodu.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodu.getIsNew()||!productoordendetaprodu.getid_unidad().equals(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_unidad()!=null)
				{
					strValorActual=productoordendetaprodu.getProductoOrdenDetaProduOriginal().getid_unidad().toString();
				}
				if(productoordendetaprodu.getid_unidad()!=null)
				{
					strValorNuevo=productoordendetaprodu.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodu.getIsNew()||!productoordendetaprodu.getporcentaje().equals(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getporcentaje()!=null)
				{
					strValorActual=productoordendetaprodu.getProductoOrdenDetaProduOriginal().getporcentaje().toString();
				}
				if(productoordendetaprodu.getporcentaje()!=null)
				{
					strValorNuevo=productoordendetaprodu.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodu.getIsNew()||!productoordendetaprodu.getcantidad().equals(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getcantidad()!=null)
				{
					strValorActual=productoordendetaprodu.getProductoOrdenDetaProduOriginal().getcantidad().toString();
				}
				if(productoordendetaprodu.getcantidad()!=null)
				{
					strValorNuevo=productoordendetaprodu.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodu.getIsNew()||!productoordendetaprodu.getcosto().equals(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getcosto()!=null)
				{
					strValorActual=productoordendetaprodu.getProductoOrdenDetaProduOriginal().getcosto().toString();
				}
				if(productoordendetaprodu.getcosto()!=null)
				{
					strValorNuevo=productoordendetaprodu.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodu.getIsNew()||!productoordendetaprodu.getcosto_total().equals(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getcosto_total()!=null)
				{
					strValorActual=productoordendetaprodu.getProductoOrdenDetaProduOriginal().getcosto_total().toString();
				}
				if(productoordendetaprodu.getcosto_total()!=null)
				{
					strValorNuevo=productoordendetaprodu.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodu.getIsNew()||!productoordendetaprodu.getdescripcion().equals(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodu.getProductoOrdenDetaProduOriginal().getdescripcion()!=null)
				{
					strValorActual=productoordendetaprodu.getProductoOrdenDetaProduOriginal().getdescripcion();
				}
				if(productoordendetaprodu.getdescripcion()!=null)
				{
					strValorNuevo=productoordendetaprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoOrdenDetaProduRelacionesWithConnection(ProductoOrdenDetaProdu productoordendetaprodu) throws Exception {

		if(!productoordendetaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduRelacionesBase(productoordendetaprodu,true);
		}
	}

	public void saveProductoOrdenDetaProduRelaciones(ProductoOrdenDetaProdu productoordendetaprodu)throws Exception {

		if(!productoordendetaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduRelacionesBase(productoordendetaprodu,false);
		}
	}

	public void saveProductoOrdenDetaProduRelacionesBase(ProductoOrdenDetaProdu productoordendetaprodu,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoOrdenDetaProdu-saveRelacionesWithConnection");}
	

			this.setProductoOrdenDetaProdu(productoordendetaprodu);

			if(ProductoOrdenDetaProduLogicAdditional.validarSaveRelaciones(productoordendetaprodu,this)) {

				ProductoOrdenDetaProduLogicAdditional.updateRelacionesToSave(productoordendetaprodu,this);

				if((productoordendetaprodu.getIsNew()||productoordendetaprodu.getIsChanged())&&!productoordendetaprodu.getIsDeleted()) {
					this.saveProductoOrdenDetaProdu();
					this.saveProductoOrdenDetaProduRelacionesDetalles();

				} else if(productoordendetaprodu.getIsDeleted()) {
					this.saveProductoOrdenDetaProduRelacionesDetalles();
					this.saveProductoOrdenDetaProdu();
				}

				ProductoOrdenDetaProduLogicAdditional.updateRelacionesToSaveAfter(productoordendetaprodu,this);

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
	
	
	private void saveProductoOrdenDetaProduRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

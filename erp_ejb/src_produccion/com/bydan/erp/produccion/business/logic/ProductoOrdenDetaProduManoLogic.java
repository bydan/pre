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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduManoConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduManoParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduManoParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoOrdenDetaProduMano;
import com.bydan.erp.produccion.business.logic.ProductoOrdenDetaProduManoLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoOrdenDetaProduManoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoOrdenDetaProduManoLogic.class);
	
	protected ProductoOrdenDetaProduManoDataAccess productoordendetaprodumanoDataAccess; 	
	protected ProductoOrdenDetaProduMano productoordendetaprodumano;
	protected List<ProductoOrdenDetaProduMano> productoordendetaprodumanos;
	protected Object productoordendetaprodumanoObject;	
	protected List<Object> productoordendetaprodumanosObject;
	
	public static ClassValidator<ProductoOrdenDetaProduMano> productoordendetaprodumanoValidator = new ClassValidator<ProductoOrdenDetaProduMano>(ProductoOrdenDetaProduMano.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoOrdenDetaProduManoLogicAdditional productoordendetaprodumanoLogicAdditional=null;
	
	public ProductoOrdenDetaProduManoLogicAdditional getProductoOrdenDetaProduManoLogicAdditional() {
		return this.productoordendetaprodumanoLogicAdditional;
	}
	
	public void setProductoOrdenDetaProduManoLogicAdditional(ProductoOrdenDetaProduManoLogicAdditional productoordendetaprodumanoLogicAdditional) {
		try {
			this.productoordendetaprodumanoLogicAdditional=productoordendetaprodumanoLogicAdditional;
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
	
	
	
	
	public  ProductoOrdenDetaProduManoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoordendetaprodumanoDataAccess = new ProductoOrdenDetaProduManoDataAccess();
			
			this.productoordendetaprodumanos= new ArrayList<ProductoOrdenDetaProduMano>();
			this.productoordendetaprodumano= new ProductoOrdenDetaProduMano();
			
			this.productoordendetaprodumanoObject=new Object();
			this.productoordendetaprodumanosObject=new ArrayList<Object>();
				
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
			
			this.productoordendetaprodumanoDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaprodumanoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoOrdenDetaProduManoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoordendetaprodumanoDataAccess = new ProductoOrdenDetaProduManoDataAccess();
			this.productoordendetaprodumanos= new ArrayList<ProductoOrdenDetaProduMano>();
			this.productoordendetaprodumano= new ProductoOrdenDetaProduMano();
			this.productoordendetaprodumanoObject=new Object();
			this.productoordendetaprodumanosObject=new ArrayList<Object>();
			
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
			
			this.productoordendetaprodumanoDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaprodumanoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoOrdenDetaProduMano getProductoOrdenDetaProduMano() throws Exception {	
		ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToGet(productoordendetaprodumano,this.datosCliente,this.arrDatoGeneral);
		ProductoOrdenDetaProduManoLogicAdditional.updateProductoOrdenDetaProduManoToGet(productoordendetaprodumano,this.arrDatoGeneral);
		
		return productoordendetaprodumano;
	}
		
	public void setProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano newProductoOrdenDetaProduMano) {
		this.productoordendetaprodumano = newProductoOrdenDetaProduMano;
	}
	
	public ProductoOrdenDetaProduManoDataAccess getProductoOrdenDetaProduManoDataAccess() {
		return productoordendetaprodumanoDataAccess;
	}
	
	public void setProductoOrdenDetaProduManoDataAccess(ProductoOrdenDetaProduManoDataAccess newproductoordendetaprodumanoDataAccess) {
		this.productoordendetaprodumanoDataAccess = newproductoordendetaprodumanoDataAccess;
	}
	
	public List<ProductoOrdenDetaProduMano> getProductoOrdenDetaProduManos() throws Exception {		
		this.quitarProductoOrdenDetaProduManosNulos();
		
		ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToGets(productoordendetaprodumanos,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoOrdenDetaProduMano productoordendetaprodumanoLocal: productoordendetaprodumanos ) {
			ProductoOrdenDetaProduManoLogicAdditional.updateProductoOrdenDetaProduManoToGet(productoordendetaprodumanoLocal,this.arrDatoGeneral);
		}
		
		return productoordendetaprodumanos;
	}
	
	public void setProductoOrdenDetaProduManos(List<ProductoOrdenDetaProduMano> newProductoOrdenDetaProduManos) {
		this.productoordendetaprodumanos = newProductoOrdenDetaProduManos;
	}
	
	public Object getProductoOrdenDetaProduManoObject() {	
		this.productoordendetaprodumanoObject=this.productoordendetaprodumanoDataAccess.getEntityObject();
		return this.productoordendetaprodumanoObject;
	}
		
	public void setProductoOrdenDetaProduManoObject(Object newProductoOrdenDetaProduManoObject) {
		this.productoordendetaprodumanoObject = newProductoOrdenDetaProduManoObject;
	}
	
	public List<Object> getProductoOrdenDetaProduManosObject() {		
		this.productoordendetaprodumanosObject=this.productoordendetaprodumanoDataAccess.getEntitiesObject();
		return this.productoordendetaprodumanosObject;
	}
		
	public void setProductoOrdenDetaProduManosObject(List<Object> newProductoOrdenDetaProduManosObject) {
		this.productoordendetaprodumanosObject = newProductoOrdenDetaProduManosObject;
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
		
		if(this.productoordendetaprodumanoDataAccess!=null) {
			this.productoordendetaprodumanoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoordendetaprodumanoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoordendetaprodumanoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodumano=productoordendetaprodumanoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumano);
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
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		  		  
        try {
			
			productoordendetaprodumano=productoordendetaprodumanoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumano);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodumano=productoordendetaprodumanoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumano);
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
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		  		  
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
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		  		  
        try {
			
			productoordendetaprodumano=productoordendetaprodumanoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumano);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		  		  
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
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoordendetaprodumanoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoordendetaprodumanoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoordendetaprodumanoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoordendetaprodumanoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoordendetaprodumanoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoordendetaprodumanoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
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
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		  		  
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
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		  		  
        try {			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		  		  
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
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
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
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		  		  
        try {
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
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
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
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
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumano=productoordendetaprodumanoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumano);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumano);
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
		productoordendetaprodumano = new  ProductoOrdenDetaProduMano();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumano=productoordendetaprodumanoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumano);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumano);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
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
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		  		  
        try {
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoOrdenDetaProduManosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getTodosProductoOrdenDetaProduManosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
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
	
	public  void  getTodosProductoOrdenDetaProduManos(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodumanos = new  ArrayList<ProductoOrdenDetaProduMano>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProduMano(productoordendetaprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano productoordendetaprodumano) throws Exception {
		Boolean estaValidado=false;
		
		if(productoordendetaprodumano.getIsNew() || productoordendetaprodumano.getIsChanged()) { 
			this.invalidValues = productoordendetaprodumanoValidator.getInvalidValues(productoordendetaprodumano);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoordendetaprodumano);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoOrdenDetaProduMano(List<ProductoOrdenDetaProduMano> ProductoOrdenDetaProduManos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumanoLocal:productoordendetaprodumanos) {				
			estaValidadoObjeto=this.validarGuardarProductoOrdenDetaProduMano(productoordendetaprodumanoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoOrdenDetaProduMano(List<ProductoOrdenDetaProduMano> ProductoOrdenDetaProduManos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProduMano(productoordendetaprodumanos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano ProductoOrdenDetaProduMano) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProduMano(productoordendetaprodumano)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoOrdenDetaProduMano productoordendetaprodumano) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoordendetaprodumano.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoOrdenDetaProduManoConstantesFunciones.getProductoOrdenDetaProduManoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoordendetaprodumano","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoOrdenDetaProduManoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoOrdenDetaProduManoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoOrdenDetaProduManoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-saveProductoOrdenDetaProduManoWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToSave(this.productoordendetaprodumano,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduManoLogicAdditional.updateProductoOrdenDetaProduManoToSave(this.productoordendetaprodumano,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodumano,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProduMano();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProduMano(this.productoordendetaprodumano)) {
				ProductoOrdenDetaProduManoDataAccess.save(this.productoordendetaprodumano, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToSaveAfter(this.productoordendetaprodumano,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProduMano();
			
			connexion.commit();			
			
			if(this.productoordendetaprodumano.getIsDeleted()) {
				this.productoordendetaprodumano=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoOrdenDetaProduMano()throws Exception {	
		try {	
			
			ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToSave(this.productoordendetaprodumano,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduManoLogicAdditional.updateProductoOrdenDetaProduManoToSave(this.productoordendetaprodumano,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodumano,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProduMano(this.productoordendetaprodumano)) {			
				ProductoOrdenDetaProduManoDataAccess.save(this.productoordendetaprodumano, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToSaveAfter(this.productoordendetaprodumano,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoordendetaprodumano.getIsDeleted()) {
				this.productoordendetaprodumano=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoOrdenDetaProduManosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-saveProductoOrdenDetaProduManosWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToSaves(productoordendetaprodumanos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProduManos();
			
			Boolean validadoTodosProductoOrdenDetaProduMano=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProduMano productoordendetaprodumanoLocal:productoordendetaprodumanos) {		
				if(productoordendetaprodumanoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduManoLogicAdditional.updateProductoOrdenDetaProduManoToSave(productoordendetaprodumanoLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaprodumanoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProduMano(productoordendetaprodumanoLocal)) {
					ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumanoLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProduMano=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProduMano) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToSavesAfter(productoordendetaprodumanos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProduManos();
			
			connexion.commit();		
			
			this.quitarProductoOrdenDetaProduManosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoOrdenDetaProduManos()throws Exception {				
		 try {	
			ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToSaves(productoordendetaprodumanos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoOrdenDetaProduMano=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProduMano productoordendetaprodumanoLocal:productoordendetaprodumanos) {				
				if(productoordendetaprodumanoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduManoLogicAdditional.updateProductoOrdenDetaProduManoToSave(productoordendetaprodumanoLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaprodumanoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProduMano(productoordendetaprodumanoLocal)) {				
					ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumanoLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProduMano=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProduMano) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduManoLogicAdditional.checkProductoOrdenDetaProduManoToSavesAfter(productoordendetaprodumanos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoOrdenDetaProduManosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduManoParameterReturnGeneral procesarAccionProductoOrdenDetaProduManos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoParameterGeneral)throws Exception {
		 try {	
			ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoReturnGeneral=new ProductoOrdenDetaProduManoParameterReturnGeneral();
	
			ProductoOrdenDetaProduManoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodumanos,productoordendetaprodumanoParameterGeneral,productoordendetaprodumanoReturnGeneral);
			
			return productoordendetaprodumanoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduManoParameterReturnGeneral procesarAccionProductoOrdenDetaProduManosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-procesarAccionProductoOrdenDetaProduManosWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoReturnGeneral=new ProductoOrdenDetaProduManoParameterReturnGeneral();
	
			ProductoOrdenDetaProduManoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodumanos,productoordendetaprodumanoParameterGeneral,productoordendetaprodumanoReturnGeneral);
			
			this.connexion.commit();
			
			return productoordendetaprodumanoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduManoParameterReturnGeneral procesarEventosProductoOrdenDetaProduManos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,ProductoOrdenDetaProduMano productoordendetaprodumano,ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProduMano,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoReturnGeneral=new ProductoOrdenDetaProduManoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaprodumanoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduManoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodumanos,productoordendetaprodumano,productoordendetaprodumanoParameterGeneral,productoordendetaprodumanoReturnGeneral,isEsNuevoProductoOrdenDetaProduMano,clases);
			
			return productoordendetaprodumanoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoOrdenDetaProduManoParameterReturnGeneral procesarEventosProductoOrdenDetaProduManosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,ProductoOrdenDetaProduMano productoordendetaprodumano,ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProduMano,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-procesarEventosProductoOrdenDetaProduManosWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoReturnGeneral=new ProductoOrdenDetaProduManoParameterReturnGeneral();
	
			productoordendetaprodumanoReturnGeneral.setProductoOrdenDetaProduMano(productoordendetaprodumano);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaprodumanoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduManoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodumanos,productoordendetaprodumano,productoordendetaprodumanoParameterGeneral,productoordendetaprodumanoReturnGeneral,isEsNuevoProductoOrdenDetaProduMano,clases);
			
			this.connexion.commit();
			
			return productoordendetaprodumanoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduManoParameterReturnGeneral procesarImportacionProductoOrdenDetaProduManosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-procesarImportacionProductoOrdenDetaProduManosWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduManoParameterReturnGeneral productoordendetaprodumanoReturnGeneral=new ProductoOrdenDetaProduManoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoordendetaprodumanos=new ArrayList<ProductoOrdenDetaProduMano>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoordendetaprodumano=new ProductoOrdenDetaProduMano();
				
				
				if(conColumnasBase) {this.productoordendetaprodumano.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoordendetaprodumano.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoordendetaprodumano.setcantidad(Long.parseLong(arrColumnas[iColumn++]));
				this.productoordendetaprodumano.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodumano.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodumano.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoordendetaprodumanos.add(this.productoordendetaprodumano);
			}
			
			this.saveProductoOrdenDetaProduManos();
			
			this.connexion.commit();
			
			productoordendetaprodumanoReturnGeneral.setConRetornoEstaProcesado(true);
			productoordendetaprodumanoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoordendetaprodumanoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoOrdenDetaProduManosEliminados() throws Exception {				
		
		List<ProductoOrdenDetaProduMano> productoordendetaprodumanosAux= new ArrayList<ProductoOrdenDetaProduMano>();
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumano:productoordendetaprodumanos) {
			if(!productoordendetaprodumano.getIsDeleted()) {
				productoordendetaprodumanosAux.add(productoordendetaprodumano);
			}
		}
		
		productoordendetaprodumanos=productoordendetaprodumanosAux;
	}
	
	public void quitarProductoOrdenDetaProduManosNulos() throws Exception {				
		
		List<ProductoOrdenDetaProduMano> productoordendetaprodumanosAux= new ArrayList<ProductoOrdenDetaProduMano>();
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumano : this.productoordendetaprodumanos) {
			if(productoordendetaprodumano==null) {
				productoordendetaprodumanosAux.add(productoordendetaprodumano);
			}
		}
		
		//this.productoordendetaprodumanos=productoordendetaprodumanosAux;
		
		this.productoordendetaprodumanos.removeAll(productoordendetaprodumanosAux);
	}
	
	public void getSetVersionRowProductoOrdenDetaProduManoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoordendetaprodumano.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoordendetaprodumano.getIsDeleted() || (productoordendetaprodumano.getIsChanged()&&!productoordendetaprodumano.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoordendetaprodumanoDataAccess.getSetVersionRowProductoOrdenDetaProduMano(connexion,productoordendetaprodumano.getId());
				
				if(!productoordendetaprodumano.getVersionRow().equals(timestamp)) {	
					productoordendetaprodumano.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoordendetaprodumano.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoOrdenDetaProduMano()throws Exception {	
		
		if(productoordendetaprodumano.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoordendetaprodumano.getIsDeleted() || (productoordendetaprodumano.getIsChanged()&&!productoordendetaprodumano.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoordendetaprodumanoDataAccess.getSetVersionRowProductoOrdenDetaProduMano(connexion,productoordendetaprodumano.getId());
			
			try {							
				if(!productoordendetaprodumano.getVersionRow().equals(timestamp)) {	
					productoordendetaprodumano.setVersionRow(timestamp);
				}
				
				productoordendetaprodumano.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoOrdenDetaProduManosWithConnection()throws Exception {	
		if(productoordendetaprodumanos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoOrdenDetaProduMano productoordendetaprodumanoAux:productoordendetaprodumanos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoordendetaprodumanoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaprodumanoAux.getIsDeleted() || (productoordendetaprodumanoAux.getIsChanged()&&!productoordendetaprodumanoAux.getIsNew())) {
						
						timestamp=productoordendetaprodumanoDataAccess.getSetVersionRowProductoOrdenDetaProduMano(connexion,productoordendetaprodumanoAux.getId());
						
						if(!productoordendetaprodumano.getVersionRow().equals(timestamp)) {	
							productoordendetaprodumanoAux.setVersionRow(timestamp);
						}
								
						productoordendetaprodumanoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoOrdenDetaProduManos()throws Exception {	
		if(productoordendetaprodumanos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoOrdenDetaProduMano productoordendetaprodumanoAux:productoordendetaprodumanos) {
					if(productoordendetaprodumanoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaprodumanoAux.getIsDeleted() || (productoordendetaprodumanoAux.getIsChanged()&&!productoordendetaprodumanoAux.getIsNew())) {
						
						timestamp=productoordendetaprodumanoDataAccess.getSetVersionRowProductoOrdenDetaProduMano(connexion,productoordendetaprodumanoAux.getId());
						
						if(!productoordendetaprodumanoAux.getVersionRow().equals(timestamp)) {	
							productoordendetaprodumanoAux.setVersionRow(timestamp);
						}
						
													
						productoordendetaprodumanoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoOrdenDetaProduManoParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProduManoWithConnection(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalTipoManoProduEmpresa,String finalQueryGlobalTipoProcesoEmpresaProdu,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduManoParameterReturnGeneral  productoordendetaprodumanoReturnGeneral =new ProductoOrdenDetaProduManoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoOrdenDetaProduManoWithConnection");connexion.begin();
			
			productoordendetaprodumanoReturnGeneral =new ProductoOrdenDetaProduManoParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaprodumanoReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<TipoManoProduEmpresa> tipomanoproduempresasForeignKey=new ArrayList<TipoManoProduEmpresa>();
			TipoManoProduEmpresaLogic tipomanoproduempresaLogic=new TipoManoProduEmpresaLogic();
			tipomanoproduempresaLogic.setConnexion(this.connexion);
			tipomanoproduempresaLogic.getTipoManoProduEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoManoProduEmpresa.equals("NONE")) {
				tipomanoproduempresaLogic.getTodosTipoManoProduEmpresas(finalQueryGlobalTipoManoProduEmpresa,new Pagination());
				tipomanoproduempresasForeignKey=tipomanoproduempresaLogic.getTipoManoProduEmpresas();
			}

			productoordendetaprodumanoReturnGeneral.settipomanoproduempresasForeignKey(tipomanoproduempresasForeignKey);


			List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic=new TipoProcesoEmpresaProduLogic();
			tipoprocesoempresaproduLogic.setConnexion(this.connexion);
			tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoEmpresaProdu.equals("NONE")) {
				tipoprocesoempresaproduLogic.getTodosTipoProcesoEmpresaProdus(finalQueryGlobalTipoProcesoEmpresaProdu,new Pagination());
				tipoprocesoempresaprodusForeignKey=tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProdus();
			}

			productoordendetaprodumanoReturnGeneral.settipoprocesoempresaprodusForeignKey(tipoprocesoempresaprodusForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaprodumanoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoordendetaprodumanoReturnGeneral;
	}
	
	public ProductoOrdenDetaProduManoParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProduMano(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalTipoManoProduEmpresa,String finalQueryGlobalTipoProcesoEmpresaProdu,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduManoParameterReturnGeneral  productoordendetaprodumanoReturnGeneral =new ProductoOrdenDetaProduManoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoordendetaprodumanoReturnGeneral =new ProductoOrdenDetaProduManoParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaprodumanoReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<TipoManoProduEmpresa> tipomanoproduempresasForeignKey=new ArrayList<TipoManoProduEmpresa>();
			TipoManoProduEmpresaLogic tipomanoproduempresaLogic=new TipoManoProduEmpresaLogic();
			tipomanoproduempresaLogic.setConnexion(this.connexion);
			tipomanoproduempresaLogic.getTipoManoProduEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoManoProduEmpresa.equals("NONE")) {
				tipomanoproduempresaLogic.getTodosTipoManoProduEmpresas(finalQueryGlobalTipoManoProduEmpresa,new Pagination());
				tipomanoproduempresasForeignKey=tipomanoproduempresaLogic.getTipoManoProduEmpresas();
			}

			productoordendetaprodumanoReturnGeneral.settipomanoproduempresasForeignKey(tipomanoproduempresasForeignKey);


			List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic=new TipoProcesoEmpresaProduLogic();
			tipoprocesoempresaproduLogic.setConnexion(this.connexion);
			tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoEmpresaProdu.equals("NONE")) {
				tipoprocesoempresaproduLogic.getTodosTipoProcesoEmpresaProdus(finalQueryGlobalTipoProcesoEmpresaProdu,new Pagination());
				tipoprocesoempresaprodusForeignKey=tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProdus();
			}

			productoordendetaprodumanoReturnGeneral.settipoprocesoempresaprodusForeignKey(tipoprocesoempresaprodusForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaprodumanoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoordendetaprodumanoReturnGeneral;
	}
	
	
	public void deepLoad(ProductoOrdenDetaProduMano productoordendetaprodumano,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoOrdenDetaProduManoLogicAdditional.updateProductoOrdenDetaProduManoToGet(productoordendetaprodumano,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodumano.setOrdenDetaProdu(productoordendetaprodumanoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumano));
		productoordendetaprodumano.setTipoManoProduEmpresa(productoordendetaprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoordendetaprodumano));
		productoordendetaprodumano.setTipoProcesoEmpresaProdu(productoordendetaprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumano));
		productoordendetaprodumano.setUnidad(productoordendetaprodumanoDataAccess.getUnidad(connexion,productoordendetaprodumano));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodumano.setOrdenDetaProdu(productoordendetaprodumanoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumano));
				continue;
			}

			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				productoordendetaprodumano.setTipoManoProduEmpresa(productoordendetaprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoordendetaprodumano));
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				productoordendetaprodumano.setTipoProcesoEmpresaProdu(productoordendetaprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumano));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodumano.setUnidad(productoordendetaprodumanoDataAccess.getUnidad(connexion,productoordendetaprodumano));
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
			productoordendetaprodumano.setOrdenDetaProdu(productoordendetaprodumanoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumano));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumano.setTipoManoProduEmpresa(productoordendetaprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoordendetaprodumano));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumano.setTipoProcesoEmpresaProdu(productoordendetaprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumano));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumano.setUnidad(productoordendetaprodumanoDataAccess.getUnidad(connexion,productoordendetaprodumano));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodumano.setOrdenDetaProdu(productoordendetaprodumanoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumano));
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodumano.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		productoordendetaprodumano.setTipoManoProduEmpresa(productoordendetaprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoordendetaprodumano));
		TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
		tipomanoproduempresaLogic.deepLoad(productoordendetaprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);
				
		productoordendetaprodumano.setTipoProcesoEmpresaProdu(productoordendetaprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumano));
		TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
		tipoprocesoempresaproduLogic.deepLoad(productoordendetaprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				
		productoordendetaprodumano.setUnidad(productoordendetaprodumanoDataAccess.getUnidad(connexion,productoordendetaprodumano));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodumano.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodumano.setOrdenDetaProdu(productoordendetaprodumanoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumano));
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepLoad(productoordendetaprodumano.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				productoordendetaprodumano.setTipoManoProduEmpresa(productoordendetaprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoordendetaprodumano));
				TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
				tipomanoproduempresaLogic.deepLoad(productoordendetaprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				productoordendetaprodumano.setTipoProcesoEmpresaProdu(productoordendetaprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumano));
				TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
				tipoprocesoempresaproduLogic.deepLoad(productoordendetaprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodumano.setUnidad(productoordendetaprodumanoDataAccess.getUnidad(connexion,productoordendetaprodumano));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoordendetaprodumano.getUnidad(),isDeep,deepLoadType,clases);				
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
			productoordendetaprodumano.setOrdenDetaProdu(productoordendetaprodumanoDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumano));
			OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
			ordendetaproduLogic.deepLoad(productoordendetaprodumano.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumano.setTipoManoProduEmpresa(productoordendetaprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoordendetaprodumano));
			TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
			tipomanoproduempresaLogic.deepLoad(productoordendetaprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumano.setTipoProcesoEmpresaProdu(productoordendetaprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumano));
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
			tipoprocesoempresaproduLogic.deepLoad(productoordendetaprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumano.setUnidad(productoordendetaprodumanoDataAccess.getUnidad(connexion,productoordendetaprodumano));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoordendetaprodumano.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoOrdenDetaProduMano productoordendetaprodumano,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoOrdenDetaProduManoLogicAdditional.updateProductoOrdenDetaProduManoToSave(productoordendetaprodumano,this.arrDatoGeneral);
			
ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumano, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodumano.getOrdenDetaProdu(),connexion);

		TipoManoProduEmpresaDataAccess.save(productoordendetaprodumano.getTipoManoProduEmpresa(),connexion);

		TipoProcesoEmpresaProduDataAccess.save(productoordendetaprodumano.getTipoProcesoEmpresaProdu(),connexion);

		UnidadDataAccess.save(productoordendetaprodumano.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodumano.getOrdenDetaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				TipoManoProduEmpresaDataAccess.save(productoordendetaprodumano.getTipoManoProduEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				TipoProcesoEmpresaProduDataAccess.save(productoordendetaprodumano.getTipoProcesoEmpresaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodumano.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodumano.getOrdenDetaProdu(),connexion);
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodumano.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				

		TipoManoProduEmpresaDataAccess.save(productoordendetaprodumano.getTipoManoProduEmpresa(),connexion);
		TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
		tipomanoproduempresaLogic.deepLoad(productoordendetaprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);
				

		TipoProcesoEmpresaProduDataAccess.save(productoordendetaprodumano.getTipoProcesoEmpresaProdu(),connexion);
		TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
		tipoprocesoempresaproduLogic.deepLoad(productoordendetaprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoordendetaprodumano.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodumano.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodumano.getOrdenDetaProdu(),connexion);
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepSave(productoordendetaprodumano.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				TipoManoProduEmpresaDataAccess.save(productoordendetaprodumano.getTipoManoProduEmpresa(),connexion);
				TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
				tipomanoproduempresaLogic.deepSave(productoordendetaprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				TipoProcesoEmpresaProduDataAccess.save(productoordendetaprodumano.getTipoProcesoEmpresaProdu(),connexion);
				TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
				tipoprocesoempresaproduLogic.deepSave(productoordendetaprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodumano.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoordendetaprodumano.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMano.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoordendetaprodumano,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(productoordendetaprodumano);
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
			this.deepLoad(this.productoordendetaprodumano,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumano);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMano.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoordendetaprodumanos!=null) {
				for(ProductoOrdenDetaProduMano productoordendetaprodumano:productoordendetaprodumanos) {
					this.deepLoad(productoordendetaprodumano,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(productoordendetaprodumanos);
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
			if(productoordendetaprodumanos!=null) {
				for(ProductoOrdenDetaProduMano productoordendetaprodumano:productoordendetaprodumanos) {
					this.deepLoad(productoordendetaprodumano,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(productoordendetaprodumanos);
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMano.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoordendetaprodumano,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMano.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoordendetaprodumanos!=null) {
				for(ProductoOrdenDetaProduMano productoordendetaprodumano:productoordendetaprodumanos) {
					this.deepSave(productoordendetaprodumano,isDeep,deepLoadType,clases);
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
			if(productoordendetaprodumanos!=null) {
				for(ProductoOrdenDetaProduMano productoordendetaprodumano:productoordendetaprodumanos) {
					this.deepSave(productoordendetaprodumano,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoOrdenDetaProduManosFK_IdOrdenDetaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduManosFK_IdOrdenDetaProdu(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduManosFK_IdTipoManoProduEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_mano_produ_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoManoProduEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoManoProduEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_mano_produ_empresa,ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoManoProduEmpresa);

			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoManoProduEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduManosFK_IdTipoManoProduEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_mano_produ_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoManoProduEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoManoProduEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_mano_produ_empresa,ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoManoProduEmpresa);

			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoManoProduEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduManosFK_IdTipoProcesoEmpresaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_empresa_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_empresa_produ,ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoEmpresaProdu);

			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduManosFK_IdTipoProcesoEmpresaProdu(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_empresa_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_empresa_produ,ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoEmpresaProdu);

			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduManosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMano.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduManosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(this.productoordendetaprodumanos);
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
			if(ProductoOrdenDetaProduManoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduManoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoOrdenDetaProduMano productoordendetaprodumano,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoOrdenDetaProduManoConstantesFunciones.ISCONAUDITORIA) {
				if(productoordendetaprodumano.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduManoDataAccess.TABLENAME, productoordendetaprodumano.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduManoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduManoLogic.registrarAuditoriaDetallesProductoOrdenDetaProduMano(connexion,productoordendetaprodumano,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoordendetaprodumano.getIsDeleted()) {
					/*if(!productoordendetaprodumano.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoOrdenDetaProduManoDataAccess.TABLENAME, productoordendetaprodumano.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoOrdenDetaProduManoLogic.registrarAuditoriaDetallesProductoOrdenDetaProduMano(connexion,productoordendetaprodumano,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduManoDataAccess.TABLENAME, productoordendetaprodumano.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoordendetaprodumano.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduManoDataAccess.TABLENAME, productoordendetaprodumano.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduManoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduManoLogic.registrarAuditoriaDetallesProductoOrdenDetaProduMano(connexion,productoordendetaprodumano,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoOrdenDetaProduMano(Connexion connexion,ProductoOrdenDetaProduMano productoordendetaprodumano)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoordendetaprodumano.getIsNew()||!productoordendetaprodumano.getid_orden_deta_produ().equals(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_orden_deta_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_orden_deta_produ()!=null)
				{
					strValorActual=productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_orden_deta_produ().toString();
				}
				if(productoordendetaprodumano.getid_orden_deta_produ()!=null)
				{
					strValorNuevo=productoordendetaprodumano.getid_orden_deta_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumano.getIsNew()||!productoordendetaprodumano.getid_tipo_mano_produ_empresa().equals(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_tipo_mano_produ_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_tipo_mano_produ_empresa()!=null)
				{
					strValorActual=productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_tipo_mano_produ_empresa().toString();
				}
				if(productoordendetaprodumano.getid_tipo_mano_produ_empresa()!=null)
				{
					strValorNuevo=productoordendetaprodumano.getid_tipo_mano_produ_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumano.getIsNew()||!productoordendetaprodumano.getid_tipo_proceso_empresa_produ().equals(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_tipo_proceso_empresa_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_tipo_proceso_empresa_produ()!=null)
				{
					strValorActual=productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_tipo_proceso_empresa_produ().toString();
				}
				if(productoordendetaprodumano.getid_tipo_proceso_empresa_produ()!=null)
				{
					strValorNuevo=productoordendetaprodumano.getid_tipo_proceso_empresa_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumano.getIsNew()||!productoordendetaprodumano.getid_unidad().equals(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_unidad()!=null)
				{
					strValorActual=productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getid_unidad().toString();
				}
				if(productoordendetaprodumano.getid_unidad()!=null)
				{
					strValorNuevo=productoordendetaprodumano.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumano.getIsNew()||!productoordendetaprodumano.getcantidad().equals(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getcantidad()!=null)
				{
					strValorActual=productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getcantidad().toString();
				}
				if(productoordendetaprodumano.getcantidad()!=null)
				{
					strValorNuevo=productoordendetaprodumano.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumano.getIsNew()||!productoordendetaprodumano.getcosto().equals(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getcosto()!=null)
				{
					strValorActual=productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getcosto().toString();
				}
				if(productoordendetaprodumano.getcosto()!=null)
				{
					strValorNuevo=productoordendetaprodumano.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduManoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumano.getIsNew()||!productoordendetaprodumano.getcosto_total().equals(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getcosto_total()!=null)
				{
					strValorActual=productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getcosto_total().toString();
				}
				if(productoordendetaprodumano.getcosto_total()!=null)
				{
					strValorNuevo=productoordendetaprodumano.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumano.getIsNew()||!productoordendetaprodumano.getdescripcion().equals(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getdescripcion()!=null)
				{
					strValorActual=productoordendetaprodumano.getProductoOrdenDetaProduManoOriginal().getdescripcion();
				}
				if(productoordendetaprodumano.getdescripcion()!=null)
				{
					strValorNuevo=productoordendetaprodumano.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoOrdenDetaProduManoRelacionesWithConnection(ProductoOrdenDetaProduMano productoordendetaprodumano) throws Exception {

		if(!productoordendetaprodumano.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduManoRelacionesBase(productoordendetaprodumano,true);
		}
	}

	public void saveProductoOrdenDetaProduManoRelaciones(ProductoOrdenDetaProduMano productoordendetaprodumano)throws Exception {

		if(!productoordendetaprodumano.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduManoRelacionesBase(productoordendetaprodumano,false);
		}
	}

	public void saveProductoOrdenDetaProduManoRelacionesBase(ProductoOrdenDetaProduMano productoordendetaprodumano,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoOrdenDetaProduMano-saveRelacionesWithConnection");}
	

			this.setProductoOrdenDetaProduMano(productoordendetaprodumano);

			if(ProductoOrdenDetaProduManoLogicAdditional.validarSaveRelaciones(productoordendetaprodumano,this)) {

				ProductoOrdenDetaProduManoLogicAdditional.updateRelacionesToSave(productoordendetaprodumano,this);

				if((productoordendetaprodumano.getIsNew()||productoordendetaprodumano.getIsChanged())&&!productoordendetaprodumano.getIsDeleted()) {
					this.saveProductoOrdenDetaProduMano();
					this.saveProductoOrdenDetaProduManoRelacionesDetalles();

				} else if(productoordendetaprodumano.getIsDeleted()) {
					this.saveProductoOrdenDetaProduManoRelacionesDetalles();
					this.saveProductoOrdenDetaProduMano();
				}

				ProductoOrdenDetaProduManoLogicAdditional.updateRelacionesToSaveAfter(productoordendetaprodumano,this);

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
	
	
	private void saveProductoOrdenDetaProduManoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduManoConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMano(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduManoConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProduMano(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

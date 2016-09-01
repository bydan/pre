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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMermaConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMermaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMermaParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoOrdenDetaProduMerma;
import com.bydan.erp.produccion.business.logic.ProductoOrdenDetaProduMermaLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoOrdenDetaProduMermaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoOrdenDetaProduMermaLogic.class);
	
	protected ProductoOrdenDetaProduMermaDataAccess productoordendetaprodumermaDataAccess; 	
	protected ProductoOrdenDetaProduMerma productoordendetaprodumerma;
	protected List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas;
	protected Object productoordendetaprodumermaObject;	
	protected List<Object> productoordendetaprodumermasObject;
	
	public static ClassValidator<ProductoOrdenDetaProduMerma> productoordendetaprodumermaValidator = new ClassValidator<ProductoOrdenDetaProduMerma>(ProductoOrdenDetaProduMerma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoOrdenDetaProduMermaLogicAdditional productoordendetaprodumermaLogicAdditional=null;
	
	public ProductoOrdenDetaProduMermaLogicAdditional getProductoOrdenDetaProduMermaLogicAdditional() {
		return this.productoordendetaprodumermaLogicAdditional;
	}
	
	public void setProductoOrdenDetaProduMermaLogicAdditional(ProductoOrdenDetaProduMermaLogicAdditional productoordendetaprodumermaLogicAdditional) {
		try {
			this.productoordendetaprodumermaLogicAdditional=productoordendetaprodumermaLogicAdditional;
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
	
	
	
	
	public  ProductoOrdenDetaProduMermaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoordendetaprodumermaDataAccess = new ProductoOrdenDetaProduMermaDataAccess();
			
			this.productoordendetaprodumermas= new ArrayList<ProductoOrdenDetaProduMerma>();
			this.productoordendetaprodumerma= new ProductoOrdenDetaProduMerma();
			
			this.productoordendetaprodumermaObject=new Object();
			this.productoordendetaprodumermasObject=new ArrayList<Object>();
				
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
			
			this.productoordendetaprodumermaDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaprodumermaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoOrdenDetaProduMermaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoordendetaprodumermaDataAccess = new ProductoOrdenDetaProduMermaDataAccess();
			this.productoordendetaprodumermas= new ArrayList<ProductoOrdenDetaProduMerma>();
			this.productoordendetaprodumerma= new ProductoOrdenDetaProduMerma();
			this.productoordendetaprodumermaObject=new Object();
			this.productoordendetaprodumermasObject=new ArrayList<Object>();
			
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
			
			this.productoordendetaprodumermaDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaprodumermaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoOrdenDetaProduMerma getProductoOrdenDetaProduMerma() throws Exception {	
		ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToGet(productoordendetaprodumerma,this.datosCliente,this.arrDatoGeneral);
		ProductoOrdenDetaProduMermaLogicAdditional.updateProductoOrdenDetaProduMermaToGet(productoordendetaprodumerma,this.arrDatoGeneral);
		
		return productoordendetaprodumerma;
	}
		
	public void setProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma newProductoOrdenDetaProduMerma) {
		this.productoordendetaprodumerma = newProductoOrdenDetaProduMerma;
	}
	
	public ProductoOrdenDetaProduMermaDataAccess getProductoOrdenDetaProduMermaDataAccess() {
		return productoordendetaprodumermaDataAccess;
	}
	
	public void setProductoOrdenDetaProduMermaDataAccess(ProductoOrdenDetaProduMermaDataAccess newproductoordendetaprodumermaDataAccess) {
		this.productoordendetaprodumermaDataAccess = newproductoordendetaprodumermaDataAccess;
	}
	
	public List<ProductoOrdenDetaProduMerma> getProductoOrdenDetaProduMermas() throws Exception {		
		this.quitarProductoOrdenDetaProduMermasNulos();
		
		ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToGets(productoordendetaprodumermas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoOrdenDetaProduMerma productoordendetaprodumermaLocal: productoordendetaprodumermas ) {
			ProductoOrdenDetaProduMermaLogicAdditional.updateProductoOrdenDetaProduMermaToGet(productoordendetaprodumermaLocal,this.arrDatoGeneral);
		}
		
		return productoordendetaprodumermas;
	}
	
	public void setProductoOrdenDetaProduMermas(List<ProductoOrdenDetaProduMerma> newProductoOrdenDetaProduMermas) {
		this.productoordendetaprodumermas = newProductoOrdenDetaProduMermas;
	}
	
	public Object getProductoOrdenDetaProduMermaObject() {	
		this.productoordendetaprodumermaObject=this.productoordendetaprodumermaDataAccess.getEntityObject();
		return this.productoordendetaprodumermaObject;
	}
		
	public void setProductoOrdenDetaProduMermaObject(Object newProductoOrdenDetaProduMermaObject) {
		this.productoordendetaprodumermaObject = newProductoOrdenDetaProduMermaObject;
	}
	
	public List<Object> getProductoOrdenDetaProduMermasObject() {		
		this.productoordendetaprodumermasObject=this.productoordendetaprodumermaDataAccess.getEntitiesObject();
		return this.productoordendetaprodumermasObject;
	}
		
	public void setProductoOrdenDetaProduMermasObject(List<Object> newProductoOrdenDetaProduMermasObject) {
		this.productoordendetaprodumermasObject = newProductoOrdenDetaProduMermasObject;
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
		
		if(this.productoordendetaprodumermaDataAccess!=null) {
			this.productoordendetaprodumermaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoordendetaprodumermaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoordendetaprodumermaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodumerma=productoordendetaprodumermaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumerma);
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
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		  		  
        try {
			
			productoordendetaprodumerma=productoordendetaprodumermaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumerma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodumerma=productoordendetaprodumermaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumerma);
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
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		  		  
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
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		  		  
        try {
			
			productoordendetaprodumerma=productoordendetaprodumermaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumerma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		  		  
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
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoordendetaprodumermaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoordendetaprodumermaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoordendetaprodumermaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoordendetaprodumermaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoordendetaprodumermaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoordendetaprodumermaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
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
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		  		  
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
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		  		  
        try {			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		  		  
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
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
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
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		  		  
        try {
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
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
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
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
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumerma=productoordendetaprodumermaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumerma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumerma);
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
		productoordendetaprodumerma = new  ProductoOrdenDetaProduMerma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumerma=productoordendetaprodumermaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumerma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumerma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
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
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		  		  
        try {
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoOrdenDetaProduMermasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getTodosProductoOrdenDetaProduMermasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
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
	
	public  void  getTodosProductoOrdenDetaProduMermas(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodumermas = new  ArrayList<ProductoOrdenDetaProduMerma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProduMerma(productoordendetaprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma productoordendetaprodumerma) throws Exception {
		Boolean estaValidado=false;
		
		if(productoordendetaprodumerma.getIsNew() || productoordendetaprodumerma.getIsChanged()) { 
			this.invalidValues = productoordendetaprodumermaValidator.getInvalidValues(productoordendetaprodumerma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoordendetaprodumerma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoOrdenDetaProduMerma(List<ProductoOrdenDetaProduMerma> ProductoOrdenDetaProduMermas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumermaLocal:productoordendetaprodumermas) {				
			estaValidadoObjeto=this.validarGuardarProductoOrdenDetaProduMerma(productoordendetaprodumermaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoOrdenDetaProduMerma(List<ProductoOrdenDetaProduMerma> ProductoOrdenDetaProduMermas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProduMerma(productoordendetaprodumermas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma ProductoOrdenDetaProduMerma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProduMerma(productoordendetaprodumerma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoOrdenDetaProduMerma productoordendetaprodumerma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoordendetaprodumerma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoOrdenDetaProduMermaConstantesFunciones.getProductoOrdenDetaProduMermaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoordendetaprodumerma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoOrdenDetaProduMermaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoOrdenDetaProduMermaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoOrdenDetaProduMermaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-saveProductoOrdenDetaProduMermaWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToSave(this.productoordendetaprodumerma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduMermaLogicAdditional.updateProductoOrdenDetaProduMermaToSave(this.productoordendetaprodumerma,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodumerma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProduMerma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProduMerma(this.productoordendetaprodumerma)) {
				ProductoOrdenDetaProduMermaDataAccess.save(this.productoordendetaprodumerma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToSaveAfter(this.productoordendetaprodumerma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProduMerma();
			
			connexion.commit();			
			
			if(this.productoordendetaprodumerma.getIsDeleted()) {
				this.productoordendetaprodumerma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoOrdenDetaProduMerma()throws Exception {	
		try {	
			
			ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToSave(this.productoordendetaprodumerma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduMermaLogicAdditional.updateProductoOrdenDetaProduMermaToSave(this.productoordendetaprodumerma,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodumerma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProduMerma(this.productoordendetaprodumerma)) {			
				ProductoOrdenDetaProduMermaDataAccess.save(this.productoordendetaprodumerma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToSaveAfter(this.productoordendetaprodumerma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoordendetaprodumerma.getIsDeleted()) {
				this.productoordendetaprodumerma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoOrdenDetaProduMermasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-saveProductoOrdenDetaProduMermasWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToSaves(productoordendetaprodumermas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProduMermas();
			
			Boolean validadoTodosProductoOrdenDetaProduMerma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProduMerma productoordendetaprodumermaLocal:productoordendetaprodumermas) {		
				if(productoordendetaprodumermaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduMermaLogicAdditional.updateProductoOrdenDetaProduMermaToSave(productoordendetaprodumermaLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaprodumermaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProduMerma(productoordendetaprodumermaLocal)) {
					ProductoOrdenDetaProduMermaDataAccess.save(productoordendetaprodumermaLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProduMerma=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProduMerma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToSavesAfter(productoordendetaprodumermas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProduMermas();
			
			connexion.commit();		
			
			this.quitarProductoOrdenDetaProduMermasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoOrdenDetaProduMermas()throws Exception {				
		 try {	
			ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToSaves(productoordendetaprodumermas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoOrdenDetaProduMerma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProduMerma productoordendetaprodumermaLocal:productoordendetaprodumermas) {				
				if(productoordendetaprodumermaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduMermaLogicAdditional.updateProductoOrdenDetaProduMermaToSave(productoordendetaprodumermaLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaprodumermaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProduMerma(productoordendetaprodumermaLocal)) {				
					ProductoOrdenDetaProduMermaDataAccess.save(productoordendetaprodumermaLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProduMerma=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProduMerma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduMermaLogicAdditional.checkProductoOrdenDetaProduMermaToSavesAfter(productoordendetaprodumermas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoOrdenDetaProduMermasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduMermaParameterReturnGeneral procesarAccionProductoOrdenDetaProduMermas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaParameterGeneral)throws Exception {
		 try {	
			ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaReturnGeneral=new ProductoOrdenDetaProduMermaParameterReturnGeneral();
	
			ProductoOrdenDetaProduMermaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodumermas,productoordendetaprodumermaParameterGeneral,productoordendetaprodumermaReturnGeneral);
			
			return productoordendetaprodumermaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduMermaParameterReturnGeneral procesarAccionProductoOrdenDetaProduMermasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-procesarAccionProductoOrdenDetaProduMermasWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaReturnGeneral=new ProductoOrdenDetaProduMermaParameterReturnGeneral();
	
			ProductoOrdenDetaProduMermaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodumermas,productoordendetaprodumermaParameterGeneral,productoordendetaprodumermaReturnGeneral);
			
			this.connexion.commit();
			
			return productoordendetaprodumermaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduMermaParameterReturnGeneral procesarEventosProductoOrdenDetaProduMermas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ProductoOrdenDetaProduMerma productoordendetaprodumerma,ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProduMerma,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaReturnGeneral=new ProductoOrdenDetaProduMermaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaprodumermaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduMermaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodumermas,productoordendetaprodumerma,productoordendetaprodumermaParameterGeneral,productoordendetaprodumermaReturnGeneral,isEsNuevoProductoOrdenDetaProduMerma,clases);
			
			return productoordendetaprodumermaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoOrdenDetaProduMermaParameterReturnGeneral procesarEventosProductoOrdenDetaProduMermasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ProductoOrdenDetaProduMerma productoordendetaprodumerma,ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProduMerma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-procesarEventosProductoOrdenDetaProduMermasWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaReturnGeneral=new ProductoOrdenDetaProduMermaParameterReturnGeneral();
	
			productoordendetaprodumermaReturnGeneral.setProductoOrdenDetaProduMerma(productoordendetaprodumerma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaprodumermaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduMermaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodumermas,productoordendetaprodumerma,productoordendetaprodumermaParameterGeneral,productoordendetaprodumermaReturnGeneral,isEsNuevoProductoOrdenDetaProduMerma,clases);
			
			this.connexion.commit();
			
			return productoordendetaprodumermaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduMermaParameterReturnGeneral procesarImportacionProductoOrdenDetaProduMermasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-procesarImportacionProductoOrdenDetaProduMermasWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMermaParameterReturnGeneral productoordendetaprodumermaReturnGeneral=new ProductoOrdenDetaProduMermaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoordendetaprodumermas=new ArrayList<ProductoOrdenDetaProduMerma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoordendetaprodumerma=new ProductoOrdenDetaProduMerma();
				
				
				if(conColumnasBase) {this.productoordendetaprodumerma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoordendetaprodumerma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoordendetaprodumerma.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoordendetaprodumerma.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodumerma.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodumerma.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoordendetaprodumermas.add(this.productoordendetaprodumerma);
			}
			
			this.saveProductoOrdenDetaProduMermas();
			
			this.connexion.commit();
			
			productoordendetaprodumermaReturnGeneral.setConRetornoEstaProcesado(true);
			productoordendetaprodumermaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoordendetaprodumermaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoOrdenDetaProduMermasEliminados() throws Exception {				
		
		List<ProductoOrdenDetaProduMerma> productoordendetaprodumermasAux= new ArrayList<ProductoOrdenDetaProduMerma>();
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:productoordendetaprodumermas) {
			if(!productoordendetaprodumerma.getIsDeleted()) {
				productoordendetaprodumermasAux.add(productoordendetaprodumerma);
			}
		}
		
		productoordendetaprodumermas=productoordendetaprodumermasAux;
	}
	
	public void quitarProductoOrdenDetaProduMermasNulos() throws Exception {				
		
		List<ProductoOrdenDetaProduMerma> productoordendetaprodumermasAux= new ArrayList<ProductoOrdenDetaProduMerma>();
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma : this.productoordendetaprodumermas) {
			if(productoordendetaprodumerma==null) {
				productoordendetaprodumermasAux.add(productoordendetaprodumerma);
			}
		}
		
		//this.productoordendetaprodumermas=productoordendetaprodumermasAux;
		
		this.productoordendetaprodumermas.removeAll(productoordendetaprodumermasAux);
	}
	
	public void getSetVersionRowProductoOrdenDetaProduMermaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoordendetaprodumerma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoordendetaprodumerma.getIsDeleted() || (productoordendetaprodumerma.getIsChanged()&&!productoordendetaprodumerma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoordendetaprodumermaDataAccess.getSetVersionRowProductoOrdenDetaProduMerma(connexion,productoordendetaprodumerma.getId());
				
				if(!productoordendetaprodumerma.getVersionRow().equals(timestamp)) {	
					productoordendetaprodumerma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoordendetaprodumerma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoOrdenDetaProduMerma()throws Exception {	
		
		if(productoordendetaprodumerma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoordendetaprodumerma.getIsDeleted() || (productoordendetaprodumerma.getIsChanged()&&!productoordendetaprodumerma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoordendetaprodumermaDataAccess.getSetVersionRowProductoOrdenDetaProduMerma(connexion,productoordendetaprodumerma.getId());
			
			try {							
				if(!productoordendetaprodumerma.getVersionRow().equals(timestamp)) {	
					productoordendetaprodumerma.setVersionRow(timestamp);
				}
				
				productoordendetaprodumerma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoOrdenDetaProduMermasWithConnection()throws Exception {	
		if(productoordendetaprodumermas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoOrdenDetaProduMerma productoordendetaprodumermaAux:productoordendetaprodumermas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoordendetaprodumermaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaprodumermaAux.getIsDeleted() || (productoordendetaprodumermaAux.getIsChanged()&&!productoordendetaprodumermaAux.getIsNew())) {
						
						timestamp=productoordendetaprodumermaDataAccess.getSetVersionRowProductoOrdenDetaProduMerma(connexion,productoordendetaprodumermaAux.getId());
						
						if(!productoordendetaprodumerma.getVersionRow().equals(timestamp)) {	
							productoordendetaprodumermaAux.setVersionRow(timestamp);
						}
								
						productoordendetaprodumermaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoOrdenDetaProduMermas()throws Exception {	
		if(productoordendetaprodumermas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoOrdenDetaProduMerma productoordendetaprodumermaAux:productoordendetaprodumermas) {
					if(productoordendetaprodumermaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaprodumermaAux.getIsDeleted() || (productoordendetaprodumermaAux.getIsChanged()&&!productoordendetaprodumermaAux.getIsNew())) {
						
						timestamp=productoordendetaprodumermaDataAccess.getSetVersionRowProductoOrdenDetaProduMerma(connexion,productoordendetaprodumermaAux.getId());
						
						if(!productoordendetaprodumermaAux.getVersionRow().equals(timestamp)) {	
							productoordendetaprodumermaAux.setVersionRow(timestamp);
						}
						
													
						productoordendetaprodumermaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoOrdenDetaProduMermaParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProduMermaWithConnection(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalTipoMermaEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduMermaParameterReturnGeneral  productoordendetaprodumermaReturnGeneral =new ProductoOrdenDetaProduMermaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoOrdenDetaProduMermaWithConnection");connexion.begin();
			
			productoordendetaprodumermaReturnGeneral =new ProductoOrdenDetaProduMermaParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaprodumermaReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<TipoMermaEmpresa> tipomermaempresasForeignKey=new ArrayList<TipoMermaEmpresa>();
			TipoMermaEmpresaLogic tipomermaempresaLogic=new TipoMermaEmpresaLogic();
			tipomermaempresaLogic.setConnexion(this.connexion);
			tipomermaempresaLogic.getTipoMermaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMermaEmpresa.equals("NONE")) {
				tipomermaempresaLogic.getTodosTipoMermaEmpresas(finalQueryGlobalTipoMermaEmpresa,new Pagination());
				tipomermaempresasForeignKey=tipomermaempresaLogic.getTipoMermaEmpresas();
			}

			productoordendetaprodumermaReturnGeneral.settipomermaempresasForeignKey(tipomermaempresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaprodumermaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoordendetaprodumermaReturnGeneral;
	}
	
	public ProductoOrdenDetaProduMermaParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProduMerma(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalTipoMermaEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduMermaParameterReturnGeneral  productoordendetaprodumermaReturnGeneral =new ProductoOrdenDetaProduMermaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoordendetaprodumermaReturnGeneral =new ProductoOrdenDetaProduMermaParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaprodumermaReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<TipoMermaEmpresa> tipomermaempresasForeignKey=new ArrayList<TipoMermaEmpresa>();
			TipoMermaEmpresaLogic tipomermaempresaLogic=new TipoMermaEmpresaLogic();
			tipomermaempresaLogic.setConnexion(this.connexion);
			tipomermaempresaLogic.getTipoMermaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMermaEmpresa.equals("NONE")) {
				tipomermaempresaLogic.getTodosTipoMermaEmpresas(finalQueryGlobalTipoMermaEmpresa,new Pagination());
				tipomermaempresasForeignKey=tipomermaempresaLogic.getTipoMermaEmpresas();
			}

			productoordendetaprodumermaReturnGeneral.settipomermaempresasForeignKey(tipomermaempresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaprodumermaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoordendetaprodumermaReturnGeneral;
	}
	
	
	public void deepLoad(ProductoOrdenDetaProduMerma productoordendetaprodumerma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoOrdenDetaProduMermaLogicAdditional.updateProductoOrdenDetaProduMermaToGet(productoordendetaprodumerma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodumerma.setOrdenDetaProdu(productoordendetaprodumermaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumerma));
		productoordendetaprodumerma.setTipoMermaEmpresa(productoordendetaprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoordendetaprodumerma));
		productoordendetaprodumerma.setUnidad(productoordendetaprodumermaDataAccess.getUnidad(connexion,productoordendetaprodumerma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodumerma.setOrdenDetaProdu(productoordendetaprodumermaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumerma));
				continue;
			}

			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				productoordendetaprodumerma.setTipoMermaEmpresa(productoordendetaprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoordendetaprodumerma));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodumerma.setUnidad(productoordendetaprodumermaDataAccess.getUnidad(connexion,productoordendetaprodumerma));
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
			productoordendetaprodumerma.setOrdenDetaProdu(productoordendetaprodumermaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumerma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumerma.setTipoMermaEmpresa(productoordendetaprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoordendetaprodumerma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumerma.setUnidad(productoordendetaprodumermaDataAccess.getUnidad(connexion,productoordendetaprodumerma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodumerma.setOrdenDetaProdu(productoordendetaprodumermaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumerma));
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodumerma.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		productoordendetaprodumerma.setTipoMermaEmpresa(productoordendetaprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoordendetaprodumerma));
		TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
		tipomermaempresaLogic.deepLoad(productoordendetaprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);
				
		productoordendetaprodumerma.setUnidad(productoordendetaprodumermaDataAccess.getUnidad(connexion,productoordendetaprodumerma));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodumerma.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodumerma.setOrdenDetaProdu(productoordendetaprodumermaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumerma));
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepLoad(productoordendetaprodumerma.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				productoordendetaprodumerma.setTipoMermaEmpresa(productoordendetaprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoordendetaprodumerma));
				TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
				tipomermaempresaLogic.deepLoad(productoordendetaprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodumerma.setUnidad(productoordendetaprodumermaDataAccess.getUnidad(connexion,productoordendetaprodumerma));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoordendetaprodumerma.getUnidad(),isDeep,deepLoadType,clases);				
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
			productoordendetaprodumerma.setOrdenDetaProdu(productoordendetaprodumermaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumerma));
			OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
			ordendetaproduLogic.deepLoad(productoordendetaprodumerma.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumerma.setTipoMermaEmpresa(productoordendetaprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoordendetaprodumerma));
			TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
			tipomermaempresaLogic.deepLoad(productoordendetaprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumerma.setUnidad(productoordendetaprodumermaDataAccess.getUnidad(connexion,productoordendetaprodumerma));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoordendetaprodumerma.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoOrdenDetaProduMerma productoordendetaprodumerma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoOrdenDetaProduMermaLogicAdditional.updateProductoOrdenDetaProduMermaToSave(productoordendetaprodumerma,this.arrDatoGeneral);
			
ProductoOrdenDetaProduMermaDataAccess.save(productoordendetaprodumerma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodumerma.getOrdenDetaProdu(),connexion);

		TipoMermaEmpresaDataAccess.save(productoordendetaprodumerma.getTipoMermaEmpresa(),connexion);

		UnidadDataAccess.save(productoordendetaprodumerma.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodumerma.getOrdenDetaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				TipoMermaEmpresaDataAccess.save(productoordendetaprodumerma.getTipoMermaEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodumerma.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodumerma.getOrdenDetaProdu(),connexion);
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodumerma.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				

		TipoMermaEmpresaDataAccess.save(productoordendetaprodumerma.getTipoMermaEmpresa(),connexion);
		TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
		tipomermaempresaLogic.deepLoad(productoordendetaprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoordendetaprodumerma.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodumerma.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodumerma.getOrdenDetaProdu(),connexion);
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepSave(productoordendetaprodumerma.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				TipoMermaEmpresaDataAccess.save(productoordendetaprodumerma.getTipoMermaEmpresa(),connexion);
				TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
				tipomermaempresaLogic.deepSave(productoordendetaprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodumerma.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoordendetaprodumerma.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMerma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoordendetaprodumerma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(productoordendetaprodumerma);
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
			this.deepLoad(this.productoordendetaprodumerma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumerma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMerma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoordendetaprodumermas!=null) {
				for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:productoordendetaprodumermas) {
					this.deepLoad(productoordendetaprodumerma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(productoordendetaprodumermas);
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
			if(productoordendetaprodumermas!=null) {
				for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:productoordendetaprodumermas) {
					this.deepLoad(productoordendetaprodumerma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(productoordendetaprodumermas);
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMerma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoordendetaprodumerma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMerma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoordendetaprodumermas!=null) {
				for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:productoordendetaprodumermas) {
					this.deepSave(productoordendetaprodumerma,isDeep,deepLoadType,clases);
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
			if(productoordendetaprodumermas!=null) {
				for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:productoordendetaprodumermas) {
					this.deepSave(productoordendetaprodumerma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoOrdenDetaProduMermasFK_IdOrdenDetaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduMermasFK_IdOrdenDetaProdu(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduMermasFK_IdTipoMermaEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_merma_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMermaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMermaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_merma_empresa,ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMermaEmpresa);

			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMermaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduMermasFK_IdTipoMermaEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_merma_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMermaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMermaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_merma_empresa,ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMermaEmpresa);

			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMermaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduMermasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMerma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduMermasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(this.productoordendetaprodumermas);
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
			if(ProductoOrdenDetaProduMermaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduMermaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoOrdenDetaProduMerma productoordendetaprodumerma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoOrdenDetaProduMermaConstantesFunciones.ISCONAUDITORIA) {
				if(productoordendetaprodumerma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduMermaDataAccess.TABLENAME, productoordendetaprodumerma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduMermaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduMermaLogic.registrarAuditoriaDetallesProductoOrdenDetaProduMerma(connexion,productoordendetaprodumerma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoordendetaprodumerma.getIsDeleted()) {
					/*if(!productoordendetaprodumerma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoOrdenDetaProduMermaDataAccess.TABLENAME, productoordendetaprodumerma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoOrdenDetaProduMermaLogic.registrarAuditoriaDetallesProductoOrdenDetaProduMerma(connexion,productoordendetaprodumerma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduMermaDataAccess.TABLENAME, productoordendetaprodumerma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoordendetaprodumerma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduMermaDataAccess.TABLENAME, productoordendetaprodumerma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduMermaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduMermaLogic.registrarAuditoriaDetallesProductoOrdenDetaProduMerma(connexion,productoordendetaprodumerma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoOrdenDetaProduMerma(Connexion connexion,ProductoOrdenDetaProduMerma productoordendetaprodumerma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoordendetaprodumerma.getIsNew()||!productoordendetaprodumerma.getid_orden_deta_produ().equals(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getid_orden_deta_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getid_orden_deta_produ()!=null)
				{
					strValorActual=productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getid_orden_deta_produ().toString();
				}
				if(productoordendetaprodumerma.getid_orden_deta_produ()!=null)
				{
					strValorNuevo=productoordendetaprodumerma.getid_orden_deta_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumerma.getIsNew()||!productoordendetaprodumerma.getid_tipo_merma_empresa().equals(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getid_tipo_merma_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getid_tipo_merma_empresa()!=null)
				{
					strValorActual=productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getid_tipo_merma_empresa().toString();
				}
				if(productoordendetaprodumerma.getid_tipo_merma_empresa()!=null)
				{
					strValorNuevo=productoordendetaprodumerma.getid_tipo_merma_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumerma.getIsNew()||!productoordendetaprodumerma.getid_unidad().equals(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getid_unidad()!=null)
				{
					strValorActual=productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getid_unidad().toString();
				}
				if(productoordendetaprodumerma.getid_unidad()!=null)
				{
					strValorNuevo=productoordendetaprodumerma.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumerma.getIsNew()||!productoordendetaprodumerma.getcantidad().equals(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getcantidad()!=null)
				{
					strValorActual=productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getcantidad().toString();
				}
				if(productoordendetaprodumerma.getcantidad()!=null)
				{
					strValorNuevo=productoordendetaprodumerma.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumerma.getIsNew()||!productoordendetaprodumerma.getcosto().equals(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getcosto()!=null)
				{
					strValorActual=productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getcosto().toString();
				}
				if(productoordendetaprodumerma.getcosto()!=null)
				{
					strValorNuevo=productoordendetaprodumerma.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMermaConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumerma.getIsNew()||!productoordendetaprodumerma.getcosto_total().equals(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getcosto_total()!=null)
				{
					strValorActual=productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getcosto_total().toString();
				}
				if(productoordendetaprodumerma.getcosto_total()!=null)
				{
					strValorNuevo=productoordendetaprodumerma.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumerma.getIsNew()||!productoordendetaprodumerma.getdescripcion().equals(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getdescripcion()!=null)
				{
					strValorActual=productoordendetaprodumerma.getProductoOrdenDetaProduMermaOriginal().getdescripcion();
				}
				if(productoordendetaprodumerma.getdescripcion()!=null)
				{
					strValorNuevo=productoordendetaprodumerma.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoOrdenDetaProduMermaRelacionesWithConnection(ProductoOrdenDetaProduMerma productoordendetaprodumerma) throws Exception {

		if(!productoordendetaprodumerma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduMermaRelacionesBase(productoordendetaprodumerma,true);
		}
	}

	public void saveProductoOrdenDetaProduMermaRelaciones(ProductoOrdenDetaProduMerma productoordendetaprodumerma)throws Exception {

		if(!productoordendetaprodumerma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduMermaRelacionesBase(productoordendetaprodumerma,false);
		}
	}

	public void saveProductoOrdenDetaProduMermaRelacionesBase(ProductoOrdenDetaProduMerma productoordendetaprodumerma,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoOrdenDetaProduMerma-saveRelacionesWithConnection");}
	

			this.setProductoOrdenDetaProduMerma(productoordendetaprodumerma);

			if(ProductoOrdenDetaProduMermaLogicAdditional.validarSaveRelaciones(productoordendetaprodumerma,this)) {

				ProductoOrdenDetaProduMermaLogicAdditional.updateRelacionesToSave(productoordendetaprodumerma,this);

				if((productoordendetaprodumerma.getIsNew()||productoordendetaprodumerma.getIsChanged())&&!productoordendetaprodumerma.getIsDeleted()) {
					this.saveProductoOrdenDetaProduMerma();
					this.saveProductoOrdenDetaProduMermaRelacionesDetalles();

				} else if(productoordendetaprodumerma.getIsDeleted()) {
					this.saveProductoOrdenDetaProduMermaRelacionesDetalles();
					this.saveProductoOrdenDetaProduMerma();
				}

				ProductoOrdenDetaProduMermaLogicAdditional.updateRelacionesToSaveAfter(productoordendetaprodumerma,this);

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
	
	
	private void saveProductoOrdenDetaProduMermaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduMermaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMerma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduMermaConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProduMerma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

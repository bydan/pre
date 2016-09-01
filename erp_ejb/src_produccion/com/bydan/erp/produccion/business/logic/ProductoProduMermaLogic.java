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
import com.bydan.erp.produccion.util.ProductoProduMermaConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduMermaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduMermaParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoProduMerma;
import com.bydan.erp.produccion.business.logic.ProductoProduMermaLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoProduMermaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoProduMermaLogic.class);
	
	protected ProductoProduMermaDataAccess productoprodumermaDataAccess; 	
	protected ProductoProduMerma productoprodumerma;
	protected List<ProductoProduMerma> productoprodumermas;
	protected Object productoprodumermaObject;	
	protected List<Object> productoprodumermasObject;
	
	public static ClassValidator<ProductoProduMerma> productoprodumermaValidator = new ClassValidator<ProductoProduMerma>(ProductoProduMerma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoProduMermaLogicAdditional productoprodumermaLogicAdditional=null;
	
	public ProductoProduMermaLogicAdditional getProductoProduMermaLogicAdditional() {
		return this.productoprodumermaLogicAdditional;
	}
	
	public void setProductoProduMermaLogicAdditional(ProductoProduMermaLogicAdditional productoprodumermaLogicAdditional) {
		try {
			this.productoprodumermaLogicAdditional=productoprodumermaLogicAdditional;
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
	
	
	
	
	public  ProductoProduMermaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoprodumermaDataAccess = new ProductoProduMermaDataAccess();
			
			this.productoprodumermas= new ArrayList<ProductoProduMerma>();
			this.productoprodumerma= new ProductoProduMerma();
			
			this.productoprodumermaObject=new Object();
			this.productoprodumermasObject=new ArrayList<Object>();
				
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
			
			this.productoprodumermaDataAccess.setConnexionType(this.connexionType);
			this.productoprodumermaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoProduMermaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoprodumermaDataAccess = new ProductoProduMermaDataAccess();
			this.productoprodumermas= new ArrayList<ProductoProduMerma>();
			this.productoprodumerma= new ProductoProduMerma();
			this.productoprodumermaObject=new Object();
			this.productoprodumermasObject=new ArrayList<Object>();
			
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
			
			this.productoprodumermaDataAccess.setConnexionType(this.connexionType);
			this.productoprodumermaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoProduMerma getProductoProduMerma() throws Exception {	
		ProductoProduMermaLogicAdditional.checkProductoProduMermaToGet(productoprodumerma,this.datosCliente,this.arrDatoGeneral);
		ProductoProduMermaLogicAdditional.updateProductoProduMermaToGet(productoprodumerma,this.arrDatoGeneral);
		
		return productoprodumerma;
	}
		
	public void setProductoProduMerma(ProductoProduMerma newProductoProduMerma) {
		this.productoprodumerma = newProductoProduMerma;
	}
	
	public ProductoProduMermaDataAccess getProductoProduMermaDataAccess() {
		return productoprodumermaDataAccess;
	}
	
	public void setProductoProduMermaDataAccess(ProductoProduMermaDataAccess newproductoprodumermaDataAccess) {
		this.productoprodumermaDataAccess = newproductoprodumermaDataAccess;
	}
	
	public List<ProductoProduMerma> getProductoProduMermas() throws Exception {		
		this.quitarProductoProduMermasNulos();
		
		ProductoProduMermaLogicAdditional.checkProductoProduMermaToGets(productoprodumermas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoProduMerma productoprodumermaLocal: productoprodumermas ) {
			ProductoProduMermaLogicAdditional.updateProductoProduMermaToGet(productoprodumermaLocal,this.arrDatoGeneral);
		}
		
		return productoprodumermas;
	}
	
	public void setProductoProduMermas(List<ProductoProduMerma> newProductoProduMermas) {
		this.productoprodumermas = newProductoProduMermas;
	}
	
	public Object getProductoProduMermaObject() {	
		this.productoprodumermaObject=this.productoprodumermaDataAccess.getEntityObject();
		return this.productoprodumermaObject;
	}
		
	public void setProductoProduMermaObject(Object newProductoProduMermaObject) {
		this.productoprodumermaObject = newProductoProduMermaObject;
	}
	
	public List<Object> getProductoProduMermasObject() {		
		this.productoprodumermasObject=this.productoprodumermaDataAccess.getEntitiesObject();
		return this.productoprodumermasObject;
	}
		
	public void setProductoProduMermasObject(List<Object> newProductoProduMermasObject) {
		this.productoprodumermasObject = newProductoProduMermasObject;
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
		
		if(this.productoprodumermaDataAccess!=null) {
			this.productoprodumermaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoprodumermaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoprodumermaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoprodumerma = new  ProductoProduMerma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodumerma=productoprodumermaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumerma);
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
		productoprodumerma = new  ProductoProduMerma();
		  		  
        try {
			
			productoprodumerma=productoprodumermaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumerma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoprodumerma = new  ProductoProduMerma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodumerma=productoprodumermaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumerma);
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
		productoprodumerma = new  ProductoProduMerma();
		  		  
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
		productoprodumerma = new  ProductoProduMerma();
		  		  
        try {
			
			productoprodumerma=productoprodumermaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumerma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoprodumerma = new  ProductoProduMerma();
		  		  
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
		productoprodumerma = new  ProductoProduMerma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoprodumermaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodumerma = new  ProductoProduMerma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoprodumermaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodumerma = new  ProductoProduMerma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoprodumermaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodumerma = new  ProductoProduMerma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoprodumermaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodumerma = new  ProductoProduMerma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoprodumermaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodumerma = new  ProductoProduMerma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoprodumermaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
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
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		  		  
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
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		  		  
        try {			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		  		  
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
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
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
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		  		  
        try {
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
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
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
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
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoprodumerma = new  ProductoProduMerma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumerma=productoprodumermaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMerma(productoprodumerma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumerma);
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
		productoprodumerma = new  ProductoProduMerma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumerma=productoprodumermaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMerma(productoprodumerma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumerma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
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
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		  		  
        try {
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoProduMermasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getTodosProductoProduMermasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
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
	
	public  void  getTodosProductoProduMermas(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodumermas = new  ArrayList<ProductoProduMerma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProduMerma(productoprodumermas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoProduMerma(ProductoProduMerma productoprodumerma) throws Exception {
		Boolean estaValidado=false;
		
		if(productoprodumerma.getIsNew() || productoprodumerma.getIsChanged()) { 
			this.invalidValues = productoprodumermaValidator.getInvalidValues(productoprodumerma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoprodumerma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoProduMerma(List<ProductoProduMerma> ProductoProduMermas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoProduMerma productoprodumermaLocal:productoprodumermas) {				
			estaValidadoObjeto=this.validarGuardarProductoProduMerma(productoprodumermaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoProduMerma(List<ProductoProduMerma> ProductoProduMermas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProduMerma(productoprodumermas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoProduMerma(ProductoProduMerma ProductoProduMerma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProduMerma(productoprodumerma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoProduMerma productoprodumerma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoprodumerma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoProduMermaConstantesFunciones.getProductoProduMermaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoprodumerma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoProduMermaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoProduMermaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoProduMermaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-saveProductoProduMermaWithConnection");connexion.begin();			
			
			ProductoProduMermaLogicAdditional.checkProductoProduMermaToSave(this.productoprodumerma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduMermaLogicAdditional.updateProductoProduMermaToSave(this.productoprodumerma,this.arrDatoGeneral);
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodumerma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoProduMerma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProduMerma(this.productoprodumerma)) {
				ProductoProduMermaDataAccess.save(this.productoprodumerma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduMermaLogicAdditional.checkProductoProduMermaToSaveAfter(this.productoprodumerma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProduMerma();
			
			connexion.commit();			
			
			if(this.productoprodumerma.getIsDeleted()) {
				this.productoprodumerma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoProduMerma()throws Exception {	
		try {	
			
			ProductoProduMermaLogicAdditional.checkProductoProduMermaToSave(this.productoprodumerma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduMermaLogicAdditional.updateProductoProduMermaToSave(this.productoprodumerma,this.arrDatoGeneral);
			
			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodumerma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProduMerma(this.productoprodumerma)) {			
				ProductoProduMermaDataAccess.save(this.productoprodumerma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoprodumerma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduMermaLogicAdditional.checkProductoProduMermaToSaveAfter(this.productoprodumerma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoprodumerma.getIsDeleted()) {
				this.productoprodumerma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoProduMermasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-saveProductoProduMermasWithConnection");connexion.begin();			
			
			ProductoProduMermaLogicAdditional.checkProductoProduMermaToSaves(productoprodumermas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoProduMermas();
			
			Boolean validadoTodosProductoProduMerma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProduMerma productoprodumermaLocal:productoprodumermas) {		
				if(productoprodumermaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduMermaLogicAdditional.updateProductoProduMermaToSave(productoprodumermaLocal,this.arrDatoGeneral);
	        	
				ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoprodumermaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProduMerma(productoprodumermaLocal)) {
					ProductoProduMermaDataAccess.save(productoprodumermaLocal, connexion);				
				} else {
					validadoTodosProductoProduMerma=false;
				}
			}
			
			if(!validadoTodosProductoProduMerma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduMermaLogicAdditional.checkProductoProduMermaToSavesAfter(productoprodumermas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProduMermas();
			
			connexion.commit();		
			
			this.quitarProductoProduMermasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoProduMermas()throws Exception {				
		 try {	
			ProductoProduMermaLogicAdditional.checkProductoProduMermaToSaves(productoprodumermas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoProduMerma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProduMerma productoprodumermaLocal:productoprodumermas) {				
				if(productoprodumermaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduMermaLogicAdditional.updateProductoProduMermaToSave(productoprodumermaLocal,this.arrDatoGeneral);
	        	
				ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoprodumermaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProduMerma(productoprodumermaLocal)) {				
					ProductoProduMermaDataAccess.save(productoprodumermaLocal, connexion);				
				} else {
					validadoTodosProductoProduMerma=false;
				}
			}
			
			if(!validadoTodosProductoProduMerma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduMermaLogicAdditional.checkProductoProduMermaToSavesAfter(productoprodumermas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoProduMermasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduMermaParameterReturnGeneral procesarAccionProductoProduMermas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProduMerma> productoprodumermas,ProductoProduMermaParameterReturnGeneral productoprodumermaParameterGeneral)throws Exception {
		 try {	
			ProductoProduMermaParameterReturnGeneral productoprodumermaReturnGeneral=new ProductoProduMermaParameterReturnGeneral();
	
			ProductoProduMermaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodumermas,productoprodumermaParameterGeneral,productoprodumermaReturnGeneral);
			
			return productoprodumermaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduMermaParameterReturnGeneral procesarAccionProductoProduMermasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProduMerma> productoprodumermas,ProductoProduMermaParameterReturnGeneral productoprodumermaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-procesarAccionProductoProduMermasWithConnection");connexion.begin();			
			
			ProductoProduMermaParameterReturnGeneral productoprodumermaReturnGeneral=new ProductoProduMermaParameterReturnGeneral();
	
			ProductoProduMermaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodumermas,productoprodumermaParameterGeneral,productoprodumermaReturnGeneral);
			
			this.connexion.commit();
			
			return productoprodumermaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduMermaParameterReturnGeneral procesarEventosProductoProduMermas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProduMerma> productoprodumermas,ProductoProduMerma productoprodumerma,ProductoProduMermaParameterReturnGeneral productoprodumermaParameterGeneral,Boolean isEsNuevoProductoProduMerma,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoProduMermaParameterReturnGeneral productoprodumermaReturnGeneral=new ProductoProduMermaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoprodumermaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduMermaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodumermas,productoprodumerma,productoprodumermaParameterGeneral,productoprodumermaReturnGeneral,isEsNuevoProductoProduMerma,clases);
			
			return productoprodumermaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoProduMermaParameterReturnGeneral procesarEventosProductoProduMermasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProduMerma> productoprodumermas,ProductoProduMerma productoprodumerma,ProductoProduMermaParameterReturnGeneral productoprodumermaParameterGeneral,Boolean isEsNuevoProductoProduMerma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-procesarEventosProductoProduMermasWithConnection");connexion.begin();			
			
			ProductoProduMermaParameterReturnGeneral productoprodumermaReturnGeneral=new ProductoProduMermaParameterReturnGeneral();
	
			productoprodumermaReturnGeneral.setProductoProduMerma(productoprodumerma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoprodumermaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduMermaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodumermas,productoprodumerma,productoprodumermaParameterGeneral,productoprodumermaReturnGeneral,isEsNuevoProductoProduMerma,clases);
			
			this.connexion.commit();
			
			return productoprodumermaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduMermaParameterReturnGeneral procesarImportacionProductoProduMermasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoProduMermaParameterReturnGeneral productoprodumermaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-procesarImportacionProductoProduMermasWithConnection");connexion.begin();			
			
			ProductoProduMermaParameterReturnGeneral productoprodumermaReturnGeneral=new ProductoProduMermaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoprodumermas=new ArrayList<ProductoProduMerma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoprodumerma=new ProductoProduMerma();
				
				
				if(conColumnasBase) {this.productoprodumerma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoprodumerma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoprodumerma.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoprodumerma.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodumerma.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodumerma.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoprodumermas.add(this.productoprodumerma);
			}
			
			this.saveProductoProduMermas();
			
			this.connexion.commit();
			
			productoprodumermaReturnGeneral.setConRetornoEstaProcesado(true);
			productoprodumermaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoprodumermaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoProduMermasEliminados() throws Exception {				
		
		List<ProductoProduMerma> productoprodumermasAux= new ArrayList<ProductoProduMerma>();
		
		for(ProductoProduMerma productoprodumerma:productoprodumermas) {
			if(!productoprodumerma.getIsDeleted()) {
				productoprodumermasAux.add(productoprodumerma);
			}
		}
		
		productoprodumermas=productoprodumermasAux;
	}
	
	public void quitarProductoProduMermasNulos() throws Exception {				
		
		List<ProductoProduMerma> productoprodumermasAux= new ArrayList<ProductoProduMerma>();
		
		for(ProductoProduMerma productoprodumerma : this.productoprodumermas) {
			if(productoprodumerma==null) {
				productoprodumermasAux.add(productoprodumerma);
			}
		}
		
		//this.productoprodumermas=productoprodumermasAux;
		
		this.productoprodumermas.removeAll(productoprodumermasAux);
	}
	
	public void getSetVersionRowProductoProduMermaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoprodumerma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoprodumerma.getIsDeleted() || (productoprodumerma.getIsChanged()&&!productoprodumerma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoprodumermaDataAccess.getSetVersionRowProductoProduMerma(connexion,productoprodumerma.getId());
				
				if(!productoprodumerma.getVersionRow().equals(timestamp)) {	
					productoprodumerma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoprodumerma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoProduMerma()throws Exception {	
		
		if(productoprodumerma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoprodumerma.getIsDeleted() || (productoprodumerma.getIsChanged()&&!productoprodumerma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoprodumermaDataAccess.getSetVersionRowProductoProduMerma(connexion,productoprodumerma.getId());
			
			try {							
				if(!productoprodumerma.getVersionRow().equals(timestamp)) {	
					productoprodumerma.setVersionRow(timestamp);
				}
				
				productoprodumerma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoProduMermasWithConnection()throws Exception {	
		if(productoprodumermas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoProduMerma productoprodumermaAux:productoprodumermas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoprodumermaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoprodumermaAux.getIsDeleted() || (productoprodumermaAux.getIsChanged()&&!productoprodumermaAux.getIsNew())) {
						
						timestamp=productoprodumermaDataAccess.getSetVersionRowProductoProduMerma(connexion,productoprodumermaAux.getId());
						
						if(!productoprodumerma.getVersionRow().equals(timestamp)) {	
							productoprodumermaAux.setVersionRow(timestamp);
						}
								
						productoprodumermaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoProduMermas()throws Exception {	
		if(productoprodumermas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoProduMerma productoprodumermaAux:productoprodumermas) {
					if(productoprodumermaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoprodumermaAux.getIsDeleted() || (productoprodumermaAux.getIsChanged()&&!productoprodumermaAux.getIsNew())) {
						
						timestamp=productoprodumermaDataAccess.getSetVersionRowProductoProduMerma(connexion,productoprodumermaAux.getId());
						
						if(!productoprodumermaAux.getVersionRow().equals(timestamp)) {	
							productoprodumermaAux.setVersionRow(timestamp);
						}
						
													
						productoprodumermaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoProduMermaParameterReturnGeneral cargarCombosLoteForeignKeyProductoProduMermaWithConnection(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalTipoMermaEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduMermaParameterReturnGeneral  productoprodumermaReturnGeneral =new ProductoProduMermaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoProduMermaWithConnection");connexion.begin();
			
			productoprodumermaReturnGeneral =new ProductoProduMermaParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoprodumermaReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<TipoMermaEmpresa> tipomermaempresasForeignKey=new ArrayList<TipoMermaEmpresa>();
			TipoMermaEmpresaLogic tipomermaempresaLogic=new TipoMermaEmpresaLogic();
			tipomermaempresaLogic.setConnexion(this.connexion);
			tipomermaempresaLogic.getTipoMermaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMermaEmpresa.equals("NONE")) {
				tipomermaempresaLogic.getTodosTipoMermaEmpresas(finalQueryGlobalTipoMermaEmpresa,new Pagination());
				tipomermaempresasForeignKey=tipomermaempresaLogic.getTipoMermaEmpresas();
			}

			productoprodumermaReturnGeneral.settipomermaempresasForeignKey(tipomermaempresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoprodumermaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoprodumermaReturnGeneral;
	}
	
	public ProductoProduMermaParameterReturnGeneral cargarCombosLoteForeignKeyProductoProduMerma(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalTipoMermaEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduMermaParameterReturnGeneral  productoprodumermaReturnGeneral =new ProductoProduMermaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoprodumermaReturnGeneral =new ProductoProduMermaParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoprodumermaReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<TipoMermaEmpresa> tipomermaempresasForeignKey=new ArrayList<TipoMermaEmpresa>();
			TipoMermaEmpresaLogic tipomermaempresaLogic=new TipoMermaEmpresaLogic();
			tipomermaempresaLogic.setConnexion(this.connexion);
			tipomermaempresaLogic.getTipoMermaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMermaEmpresa.equals("NONE")) {
				tipomermaempresaLogic.getTodosTipoMermaEmpresas(finalQueryGlobalTipoMermaEmpresa,new Pagination());
				tipomermaempresasForeignKey=tipomermaempresaLogic.getTipoMermaEmpresas();
			}

			productoprodumermaReturnGeneral.settipomermaempresasForeignKey(tipomermaempresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoprodumermaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoprodumermaReturnGeneral;
	}
	
	
	public void deepLoad(ProductoProduMerma productoprodumerma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoProduMermaLogicAdditional.updateProductoProduMermaToGet(productoprodumerma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodumerma.setProductoDefiProdu(productoprodumermaDataAccess.getProductoDefiProdu(connexion,productoprodumerma));
		productoprodumerma.setTipoMermaEmpresa(productoprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoprodumerma));
		productoprodumerma.setUnidad(productoprodumermaDataAccess.getUnidad(connexion,productoprodumerma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodumerma.setProductoDefiProdu(productoprodumermaDataAccess.getProductoDefiProdu(connexion,productoprodumerma));
				continue;
			}

			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				productoprodumerma.setTipoMermaEmpresa(productoprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoprodumerma));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodumerma.setUnidad(productoprodumermaDataAccess.getUnidad(connexion,productoprodumerma));
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
			productoprodumerma.setProductoDefiProdu(productoprodumermaDataAccess.getProductoDefiProdu(connexion,productoprodumerma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumerma.setTipoMermaEmpresa(productoprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoprodumerma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumerma.setUnidad(productoprodumermaDataAccess.getUnidad(connexion,productoprodumerma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodumerma.setProductoDefiProdu(productoprodumermaDataAccess.getProductoDefiProdu(connexion,productoprodumerma));
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodumerma.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		productoprodumerma.setTipoMermaEmpresa(productoprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoprodumerma));
		TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
		tipomermaempresaLogic.deepLoad(productoprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);
				
		productoprodumerma.setUnidad(productoprodumermaDataAccess.getUnidad(connexion,productoprodumerma));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodumerma.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodumerma.setProductoDefiProdu(productoprodumermaDataAccess.getProductoDefiProdu(connexion,productoprodumerma));
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepLoad(productoprodumerma.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				productoprodumerma.setTipoMermaEmpresa(productoprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoprodumerma));
				TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
				tipomermaempresaLogic.deepLoad(productoprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodumerma.setUnidad(productoprodumermaDataAccess.getUnidad(connexion,productoprodumerma));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoprodumerma.getUnidad(),isDeep,deepLoadType,clases);				
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
			productoprodumerma.setProductoDefiProdu(productoprodumermaDataAccess.getProductoDefiProdu(connexion,productoprodumerma));
			ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
			productodefiproduLogic.deepLoad(productoprodumerma.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumerma.setTipoMermaEmpresa(productoprodumermaDataAccess.getTipoMermaEmpresa(connexion,productoprodumerma));
			TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
			tipomermaempresaLogic.deepLoad(productoprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumerma.setUnidad(productoprodumermaDataAccess.getUnidad(connexion,productoprodumerma));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoprodumerma.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoProduMerma productoprodumerma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoProduMermaLogicAdditional.updateProductoProduMermaToSave(productoprodumerma,this.arrDatoGeneral);
			
ProductoProduMermaDataAccess.save(productoprodumerma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodumerma.getProductoDefiProdu(),connexion);

		TipoMermaEmpresaDataAccess.save(productoprodumerma.getTipoMermaEmpresa(),connexion);

		UnidadDataAccess.save(productoprodumerma.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodumerma.getProductoDefiProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				TipoMermaEmpresaDataAccess.save(productoprodumerma.getTipoMermaEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodumerma.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodumerma.getProductoDefiProdu(),connexion);
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodumerma.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				

		TipoMermaEmpresaDataAccess.save(productoprodumerma.getTipoMermaEmpresa(),connexion);
		TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
		tipomermaempresaLogic.deepLoad(productoprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoprodumerma.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodumerma.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodumerma.getProductoDefiProdu(),connexion);
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepSave(productoprodumerma.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMermaEmpresa.class)) {
				TipoMermaEmpresaDataAccess.save(productoprodumerma.getTipoMermaEmpresa(),connexion);
				TipoMermaEmpresaLogic tipomermaempresaLogic= new TipoMermaEmpresaLogic(connexion);
				tipomermaempresaLogic.deepSave(productoprodumerma.getTipoMermaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodumerma.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoprodumerma.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoProduMerma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoprodumerma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(productoprodumerma);
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
			this.deepLoad(this.productoprodumerma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumerma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoProduMerma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoprodumermas!=null) {
				for(ProductoProduMerma productoprodumerma:productoprodumermas) {
					this.deepLoad(productoprodumerma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(productoprodumermas);
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
			if(productoprodumermas!=null) {
				for(ProductoProduMerma productoprodumerma:productoprodumermas) {
					this.deepLoad(productoprodumerma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(productoprodumermas);
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
			this.getNewConnexionToDeep(ProductoProduMerma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoprodumerma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoProduMerma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoprodumermas!=null) {
				for(ProductoProduMerma productoprodumerma:productoprodumermas) {
					this.deepSave(productoprodumerma,isDeep,deepLoadType,clases);
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
			if(productoprodumermas!=null) {
				for(ProductoProduMerma productoprodumerma:productoprodumermas) {
					this.deepSave(productoprodumerma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoProduMermasFK_IdProductoDefiProduWithConnection(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduMermasFK_IdProductoDefiProdu(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduMermasFK_IdTipoMermaEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_merma_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMermaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMermaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_merma_empresa,ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMermaEmpresa);

			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMermaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduMermasFK_IdTipoMermaEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_merma_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMermaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMermaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_merma_empresa,ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMermaEmpresa);

			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMermaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduMermasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMerma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduMermaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduMermasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduMermaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduMermaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMerma(this.productoprodumermas);
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
			if(ProductoProduMermaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduMermaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoProduMerma productoprodumerma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoProduMermaConstantesFunciones.ISCONAUDITORIA) {
				if(productoprodumerma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduMermaDataAccess.TABLENAME, productoprodumerma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduMermaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduMermaLogic.registrarAuditoriaDetallesProductoProduMerma(connexion,productoprodumerma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoprodumerma.getIsDeleted()) {
					/*if(!productoprodumerma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoProduMermaDataAccess.TABLENAME, productoprodumerma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoProduMermaLogic.registrarAuditoriaDetallesProductoProduMerma(connexion,productoprodumerma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduMermaDataAccess.TABLENAME, productoprodumerma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoprodumerma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduMermaDataAccess.TABLENAME, productoprodumerma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduMermaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduMermaLogic.registrarAuditoriaDetallesProductoProduMerma(connexion,productoprodumerma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoProduMerma(Connexion connexion,ProductoProduMerma productoprodumerma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoprodumerma.getIsNew()||!productoprodumerma.getid_producto_defi_produ().equals(productoprodumerma.getProductoProduMermaOriginal().getid_producto_defi_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumerma.getProductoProduMermaOriginal().getid_producto_defi_produ()!=null)
				{
					strValorActual=productoprodumerma.getProductoProduMermaOriginal().getid_producto_defi_produ().toString();
				}
				if(productoprodumerma.getid_producto_defi_produ()!=null)
				{
					strValorNuevo=productoprodumerma.getid_producto_defi_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumerma.getIsNew()||!productoprodumerma.getid_tipo_merma_empresa().equals(productoprodumerma.getProductoProduMermaOriginal().getid_tipo_merma_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumerma.getProductoProduMermaOriginal().getid_tipo_merma_empresa()!=null)
				{
					strValorActual=productoprodumerma.getProductoProduMermaOriginal().getid_tipo_merma_empresa().toString();
				}
				if(productoprodumerma.getid_tipo_merma_empresa()!=null)
				{
					strValorNuevo=productoprodumerma.getid_tipo_merma_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumerma.getIsNew()||!productoprodumerma.getid_unidad().equals(productoprodumerma.getProductoProduMermaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumerma.getProductoProduMermaOriginal().getid_unidad()!=null)
				{
					strValorActual=productoprodumerma.getProductoProduMermaOriginal().getid_unidad().toString();
				}
				if(productoprodumerma.getid_unidad()!=null)
				{
					strValorNuevo=productoprodumerma.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMermaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumerma.getIsNew()||!productoprodumerma.getcantidad().equals(productoprodumerma.getProductoProduMermaOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumerma.getProductoProduMermaOriginal().getcantidad()!=null)
				{
					strValorActual=productoprodumerma.getProductoProduMermaOriginal().getcantidad().toString();
				}
				if(productoprodumerma.getcantidad()!=null)
				{
					strValorNuevo=productoprodumerma.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMermaConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumerma.getIsNew()||!productoprodumerma.getcosto().equals(productoprodumerma.getProductoProduMermaOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumerma.getProductoProduMermaOriginal().getcosto()!=null)
				{
					strValorActual=productoprodumerma.getProductoProduMermaOriginal().getcosto().toString();
				}
				if(productoprodumerma.getcosto()!=null)
				{
					strValorNuevo=productoprodumerma.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMermaConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumerma.getIsNew()||!productoprodumerma.getcosto_total().equals(productoprodumerma.getProductoProduMermaOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumerma.getProductoProduMermaOriginal().getcosto_total()!=null)
				{
					strValorActual=productoprodumerma.getProductoProduMermaOriginal().getcosto_total().toString();
				}
				if(productoprodumerma.getcosto_total()!=null)
				{
					strValorNuevo=productoprodumerma.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMermaConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumerma.getIsNew()||!productoprodumerma.getdescripcion().equals(productoprodumerma.getProductoProduMermaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumerma.getProductoProduMermaOriginal().getdescripcion()!=null)
				{
					strValorActual=productoprodumerma.getProductoProduMermaOriginal().getdescripcion();
				}
				if(productoprodumerma.getdescripcion()!=null)
				{
					strValorNuevo=productoprodumerma.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMermaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoProduMermaRelacionesWithConnection(ProductoProduMerma productoprodumerma) throws Exception {

		if(!productoprodumerma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduMermaRelacionesBase(productoprodumerma,true);
		}
	}

	public void saveProductoProduMermaRelaciones(ProductoProduMerma productoprodumerma)throws Exception {

		if(!productoprodumerma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduMermaRelacionesBase(productoprodumerma,false);
		}
	}

	public void saveProductoProduMermaRelacionesBase(ProductoProduMerma productoprodumerma,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoProduMerma-saveRelacionesWithConnection");}
	

			this.setProductoProduMerma(productoprodumerma);

			if(ProductoProduMermaLogicAdditional.validarSaveRelaciones(productoprodumerma,this)) {

				ProductoProduMermaLogicAdditional.updateRelacionesToSave(productoprodumerma,this);

				if((productoprodumerma.getIsNew()||productoprodumerma.getIsChanged())&&!productoprodumerma.getIsDeleted()) {
					this.saveProductoProduMerma();
					this.saveProductoProduMermaRelacionesDetalles();

				} else if(productoprodumerma.getIsDeleted()) {
					this.saveProductoProduMermaRelacionesDetalles();
					this.saveProductoProduMerma();
				}

				ProductoProduMermaLogicAdditional.updateRelacionesToSaveAfter(productoprodumerma,this);

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
	
	
	private void saveProductoProduMermaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduMermaConstantesFunciones.getClassesForeignKeysOfProductoProduMerma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduMermaConstantesFunciones.getClassesRelationshipsOfProductoProduMerma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

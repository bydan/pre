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
import com.bydan.erp.inventario.util.ProductoEstadisticaConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoEstadisticaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoEstadisticaParameterGeneral;
import com.bydan.erp.inventario.business.entity.ProductoEstadistica;
import com.bydan.erp.inventario.business.logic.ProductoEstadisticaLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoEstadisticaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoEstadisticaLogic.class);
	
	protected ProductoEstadisticaDataAccess productoestadisticaDataAccess; 	
	protected ProductoEstadistica productoestadistica;
	protected List<ProductoEstadistica> productoestadisticas;
	protected Object productoestadisticaObject;	
	protected List<Object> productoestadisticasObject;
	
	public static ClassValidator<ProductoEstadistica> productoestadisticaValidator = new ClassValidator<ProductoEstadistica>(ProductoEstadistica.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoEstadisticaLogicAdditional productoestadisticaLogicAdditional=null;
	
	public ProductoEstadisticaLogicAdditional getProductoEstadisticaLogicAdditional() {
		return this.productoestadisticaLogicAdditional;
	}
	
	public void setProductoEstadisticaLogicAdditional(ProductoEstadisticaLogicAdditional productoestadisticaLogicAdditional) {
		try {
			this.productoestadisticaLogicAdditional=productoestadisticaLogicAdditional;
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
	
	
	
	
	public  ProductoEstadisticaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoestadisticaDataAccess = new ProductoEstadisticaDataAccess();
			
			this.productoestadisticas= new ArrayList<ProductoEstadistica>();
			this.productoestadistica= new ProductoEstadistica();
			
			this.productoestadisticaObject=new Object();
			this.productoestadisticasObject=new ArrayList<Object>();
				
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
			
			this.productoestadisticaDataAccess.setConnexionType(this.connexionType);
			this.productoestadisticaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoEstadisticaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoestadisticaDataAccess = new ProductoEstadisticaDataAccess();
			this.productoestadisticas= new ArrayList<ProductoEstadistica>();
			this.productoestadistica= new ProductoEstadistica();
			this.productoestadisticaObject=new Object();
			this.productoestadisticasObject=new ArrayList<Object>();
			
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
			
			this.productoestadisticaDataAccess.setConnexionType(this.connexionType);
			this.productoestadisticaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoEstadistica getProductoEstadistica() throws Exception {	
		ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToGet(productoestadistica,this.datosCliente,this.arrDatoGeneral);
		ProductoEstadisticaLogicAdditional.updateProductoEstadisticaToGet(productoestadistica,this.arrDatoGeneral);
		
		return productoestadistica;
	}
		
	public void setProductoEstadistica(ProductoEstadistica newProductoEstadistica) {
		this.productoestadistica = newProductoEstadistica;
	}
	
	public ProductoEstadisticaDataAccess getProductoEstadisticaDataAccess() {
		return productoestadisticaDataAccess;
	}
	
	public void setProductoEstadisticaDataAccess(ProductoEstadisticaDataAccess newproductoestadisticaDataAccess) {
		this.productoestadisticaDataAccess = newproductoestadisticaDataAccess;
	}
	
	public List<ProductoEstadistica> getProductoEstadisticas() throws Exception {		
		this.quitarProductoEstadisticasNulos();
		
		ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToGets(productoestadisticas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoEstadistica productoestadisticaLocal: productoestadisticas ) {
			ProductoEstadisticaLogicAdditional.updateProductoEstadisticaToGet(productoestadisticaLocal,this.arrDatoGeneral);
		}
		
		return productoestadisticas;
	}
	
	public void setProductoEstadisticas(List<ProductoEstadistica> newProductoEstadisticas) {
		this.productoestadisticas = newProductoEstadisticas;
	}
	
	public Object getProductoEstadisticaObject() {	
		this.productoestadisticaObject=this.productoestadisticaDataAccess.getEntityObject();
		return this.productoestadisticaObject;
	}
		
	public void setProductoEstadisticaObject(Object newProductoEstadisticaObject) {
		this.productoestadisticaObject = newProductoEstadisticaObject;
	}
	
	public List<Object> getProductoEstadisticasObject() {		
		this.productoestadisticasObject=this.productoestadisticaDataAccess.getEntitiesObject();
		return this.productoestadisticasObject;
	}
		
	public void setProductoEstadisticasObject(List<Object> newProductoEstadisticasObject) {
		this.productoestadisticasObject = newProductoEstadisticasObject;
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
		
		if(this.productoestadisticaDataAccess!=null) {
			this.productoestadisticaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoestadisticaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoestadisticaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoestadistica = new  ProductoEstadistica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoestadistica=productoestadisticaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoestadistica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadistica);
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
		productoestadistica = new  ProductoEstadistica();
		  		  
        try {
			
			productoestadistica=productoestadisticaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoestadistica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadistica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoestadistica = new  ProductoEstadistica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoestadistica=productoestadisticaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoestadistica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadistica);
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
		productoestadistica = new  ProductoEstadistica();
		  		  
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
		productoestadistica = new  ProductoEstadistica();
		  		  
        try {
			
			productoestadistica=productoestadisticaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoestadistica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadistica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoestadistica = new  ProductoEstadistica();
		  		  
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
		productoestadistica = new  ProductoEstadistica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoestadisticaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoestadistica = new  ProductoEstadistica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoestadisticaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoestadistica = new  ProductoEstadistica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoestadisticaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoestadistica = new  ProductoEstadistica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoestadisticaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoestadistica = new  ProductoEstadistica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoestadisticaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoestadistica = new  ProductoEstadistica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoestadisticaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
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
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		  		  
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
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		  		  
        try {			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		  		  
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
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
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
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		  		  
        try {
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
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
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
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
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoestadistica = new  ProductoEstadistica();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadistica=productoestadisticaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoEstadistica(productoestadistica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadistica);
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
		productoestadistica = new  ProductoEstadistica();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadistica=productoestadisticaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoEstadistica(productoestadistica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadistica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
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
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		  		  
        try {
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoEstadisticasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getTodosProductoEstadisticasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
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
	
	public  void  getTodosProductoEstadisticas(String sFinalQuery,Pagination pagination)throws Exception {
		productoestadisticas = new  ArrayList<ProductoEstadistica>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoEstadistica(productoestadisticas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoEstadistica(ProductoEstadistica productoestadistica) throws Exception {
		Boolean estaValidado=false;
		
		if(productoestadistica.getIsNew() || productoestadistica.getIsChanged()) { 
			this.invalidValues = productoestadisticaValidator.getInvalidValues(productoestadistica);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoestadistica);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoEstadistica(List<ProductoEstadistica> ProductoEstadisticas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoEstadistica productoestadisticaLocal:productoestadisticas) {				
			estaValidadoObjeto=this.validarGuardarProductoEstadistica(productoestadisticaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoEstadistica(List<ProductoEstadistica> ProductoEstadisticas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoEstadistica(productoestadisticas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoEstadistica(ProductoEstadistica ProductoEstadistica) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoEstadistica(productoestadistica)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoEstadistica productoestadistica) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoestadistica.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoEstadisticaConstantesFunciones.getProductoEstadisticaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoestadistica","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoEstadisticaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoEstadisticaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoEstadisticaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-saveProductoEstadisticaWithConnection");connexion.begin();			
			
			ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToSave(this.productoestadistica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoEstadisticaLogicAdditional.updateProductoEstadisticaToSave(this.productoestadistica,this.arrDatoGeneral);
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoestadistica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoEstadistica();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoEstadistica(this.productoestadistica)) {
				ProductoEstadisticaDataAccess.save(this.productoestadistica, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoestadistica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToSaveAfter(this.productoestadistica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoEstadistica();
			
			connexion.commit();			
			
			if(this.productoestadistica.getIsDeleted()) {
				this.productoestadistica=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoEstadistica()throws Exception {	
		try {	
			
			ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToSave(this.productoestadistica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoEstadisticaLogicAdditional.updateProductoEstadisticaToSave(this.productoestadistica,this.arrDatoGeneral);
			
			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoestadistica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoEstadistica(this.productoestadistica)) {			
				ProductoEstadisticaDataAccess.save(this.productoestadistica, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoestadistica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToSaveAfter(this.productoestadistica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoestadistica.getIsDeleted()) {
				this.productoestadistica=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoEstadisticasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-saveProductoEstadisticasWithConnection");connexion.begin();			
			
			ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToSaves(productoestadisticas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoEstadisticas();
			
			Boolean validadoTodosProductoEstadistica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoEstadistica productoestadisticaLocal:productoestadisticas) {		
				if(productoestadisticaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoEstadisticaLogicAdditional.updateProductoEstadisticaToSave(productoestadisticaLocal,this.arrDatoGeneral);
	        	
				ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoestadisticaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoEstadistica(productoestadisticaLocal)) {
					ProductoEstadisticaDataAccess.save(productoestadisticaLocal, connexion);				
				} else {
					validadoTodosProductoEstadistica=false;
				}
			}
			
			if(!validadoTodosProductoEstadistica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToSavesAfter(productoestadisticas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoEstadisticas();
			
			connexion.commit();		
			
			this.quitarProductoEstadisticasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoEstadisticas()throws Exception {				
		 try {	
			ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToSaves(productoestadisticas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoEstadistica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoEstadistica productoestadisticaLocal:productoestadisticas) {				
				if(productoestadisticaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoEstadisticaLogicAdditional.updateProductoEstadisticaToSave(productoestadisticaLocal,this.arrDatoGeneral);
	        	
				ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoestadisticaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoEstadistica(productoestadisticaLocal)) {				
					ProductoEstadisticaDataAccess.save(productoestadisticaLocal, connexion);				
				} else {
					validadoTodosProductoEstadistica=false;
				}
			}
			
			if(!validadoTodosProductoEstadistica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoEstadisticaLogicAdditional.checkProductoEstadisticaToSavesAfter(productoestadisticas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoEstadisticasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoEstadisticaParameterReturnGeneral procesarAccionProductoEstadisticas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoEstadistica> productoestadisticas,ProductoEstadisticaParameterReturnGeneral productoestadisticaParameterGeneral)throws Exception {
		 try {	
			ProductoEstadisticaParameterReturnGeneral productoestadisticaReturnGeneral=new ProductoEstadisticaParameterReturnGeneral();
	
			ProductoEstadisticaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoestadisticas,productoestadisticaParameterGeneral,productoestadisticaReturnGeneral);
			
			return productoestadisticaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoEstadisticaParameterReturnGeneral procesarAccionProductoEstadisticasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoEstadistica> productoestadisticas,ProductoEstadisticaParameterReturnGeneral productoestadisticaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-procesarAccionProductoEstadisticasWithConnection");connexion.begin();			
			
			ProductoEstadisticaParameterReturnGeneral productoestadisticaReturnGeneral=new ProductoEstadisticaParameterReturnGeneral();
	
			ProductoEstadisticaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoestadisticas,productoestadisticaParameterGeneral,productoestadisticaReturnGeneral);
			
			this.connexion.commit();
			
			return productoestadisticaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoEstadisticaParameterReturnGeneral procesarEventosProductoEstadisticas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoEstadistica> productoestadisticas,ProductoEstadistica productoestadistica,ProductoEstadisticaParameterReturnGeneral productoestadisticaParameterGeneral,Boolean isEsNuevoProductoEstadistica,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoEstadisticaParameterReturnGeneral productoestadisticaReturnGeneral=new ProductoEstadisticaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoestadisticaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoEstadisticaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoestadisticas,productoestadistica,productoestadisticaParameterGeneral,productoestadisticaReturnGeneral,isEsNuevoProductoEstadistica,clases);
			
			return productoestadisticaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoEstadisticaParameterReturnGeneral procesarEventosProductoEstadisticasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoEstadistica> productoestadisticas,ProductoEstadistica productoestadistica,ProductoEstadisticaParameterReturnGeneral productoestadisticaParameterGeneral,Boolean isEsNuevoProductoEstadistica,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-procesarEventosProductoEstadisticasWithConnection");connexion.begin();			
			
			ProductoEstadisticaParameterReturnGeneral productoestadisticaReturnGeneral=new ProductoEstadisticaParameterReturnGeneral();
	
			productoestadisticaReturnGeneral.setProductoEstadistica(productoestadistica);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoestadisticaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoEstadisticaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoestadisticas,productoestadistica,productoestadisticaParameterGeneral,productoestadisticaReturnGeneral,isEsNuevoProductoEstadistica,clases);
			
			this.connexion.commit();
			
			return productoestadisticaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoEstadisticaParameterReturnGeneral procesarImportacionProductoEstadisticasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoEstadisticaParameterReturnGeneral productoestadisticaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-procesarImportacionProductoEstadisticasWithConnection");connexion.begin();			
			
			ProductoEstadisticaParameterReturnGeneral productoestadisticaReturnGeneral=new ProductoEstadisticaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoestadisticas=new ArrayList<ProductoEstadistica>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoestadistica=new ProductoEstadistica();
				
				
				if(conColumnasBase) {this.productoestadistica.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoestadistica.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoestadistica.setprecio_ultima_compra(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setprecio_ultima_venta(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setprecio_ultima_cotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setprecio_ultima_proforma(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setcantidad_disponible(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoestadistica.setcantidad_reservada(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setcantidad_demanda(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setcantidad_maximo(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoestadistica.setcantidad_minimo(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoestadistica.setcantidad_fisica(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setcantidad_orden_compra(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setcantidad_pedida(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setcantidad_requisicion(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setfecha_ultima_ingreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.productoestadistica.setfecha_ultima_egreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.productoestadistica.setfecha_ultima_produccion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.productoestadistica.setfecha_ultima_compra(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.productoestadistica.setfecha_ultima_venta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.productoestadistica.setfecha_ultima_devolucion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.productoestadistica.setfecha_ultima_orden_compra(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.productoestadistica.setfecha_ultima_pedido(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.productoestadistica.setfecha_ultima_requisicion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.productoestadistica.settotal_ingreso(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.settotal_egreso(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.settotal_compra(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.settotal_venta(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.settotal_producido(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.settotal_devuelto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setcosto_ultimo(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoestadistica.setcosto_produccion(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.productoestadisticas.add(this.productoestadistica);
			}
			
			this.saveProductoEstadisticas();
			
			this.connexion.commit();
			
			productoestadisticaReturnGeneral.setConRetornoEstaProcesado(true);
			productoestadisticaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoestadisticaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoEstadisticasEliminados() throws Exception {				
		
		List<ProductoEstadistica> productoestadisticasAux= new ArrayList<ProductoEstadistica>();
		
		for(ProductoEstadistica productoestadistica:productoestadisticas) {
			if(!productoestadistica.getIsDeleted()) {
				productoestadisticasAux.add(productoestadistica);
			}
		}
		
		productoestadisticas=productoestadisticasAux;
	}
	
	public void quitarProductoEstadisticasNulos() throws Exception {				
		
		List<ProductoEstadistica> productoestadisticasAux= new ArrayList<ProductoEstadistica>();
		
		for(ProductoEstadistica productoestadistica : this.productoestadisticas) {
			if(productoestadistica==null) {
				productoestadisticasAux.add(productoestadistica);
			}
		}
		
		//this.productoestadisticas=productoestadisticasAux;
		
		this.productoestadisticas.removeAll(productoestadisticasAux);
	}
	
	public void getSetVersionRowProductoEstadisticaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoestadistica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoestadistica.getIsDeleted() || (productoestadistica.getIsChanged()&&!productoestadistica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoestadisticaDataAccess.getSetVersionRowProductoEstadistica(connexion,productoestadistica.getId());
				
				if(!productoestadistica.getVersionRow().equals(timestamp)) {	
					productoestadistica.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoestadistica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoEstadistica()throws Exception {	
		
		if(productoestadistica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoestadistica.getIsDeleted() || (productoestadistica.getIsChanged()&&!productoestadistica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoestadisticaDataAccess.getSetVersionRowProductoEstadistica(connexion,productoestadistica.getId());
			
			try {							
				if(!productoestadistica.getVersionRow().equals(timestamp)) {	
					productoestadistica.setVersionRow(timestamp);
				}
				
				productoestadistica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoEstadisticasWithConnection()throws Exception {	
		if(productoestadisticas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoEstadistica productoestadisticaAux:productoestadisticas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoestadisticaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoestadisticaAux.getIsDeleted() || (productoestadisticaAux.getIsChanged()&&!productoestadisticaAux.getIsNew())) {
						
						timestamp=productoestadisticaDataAccess.getSetVersionRowProductoEstadistica(connexion,productoestadisticaAux.getId());
						
						if(!productoestadistica.getVersionRow().equals(timestamp)) {	
							productoestadisticaAux.setVersionRow(timestamp);
						}
								
						productoestadisticaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoEstadisticas()throws Exception {	
		if(productoestadisticas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoEstadistica productoestadisticaAux:productoestadisticas) {
					if(productoestadisticaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoestadisticaAux.getIsDeleted() || (productoestadisticaAux.getIsChanged()&&!productoestadisticaAux.getIsNew())) {
						
						timestamp=productoestadisticaDataAccess.getSetVersionRowProductoEstadistica(connexion,productoestadisticaAux.getId());
						
						if(!productoestadisticaAux.getVersionRow().equals(timestamp)) {	
							productoestadisticaAux.setVersionRow(timestamp);
						}
						
													
						productoestadisticaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoEstadisticaParameterReturnGeneral cargarCombosLoteForeignKeyProductoEstadisticaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto) throws Exception {
		ProductoEstadisticaParameterReturnGeneral  productoestadisticaReturnGeneral =new ProductoEstadisticaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoEstadisticaWithConnection");connexion.begin();
			
			productoestadisticaReturnGeneral =new ProductoEstadisticaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productoestadisticaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productoestadisticaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoestadisticaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoestadisticaReturnGeneral.setproductosForeignKey(productosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoestadisticaReturnGeneral;
	}
	
	public ProductoEstadisticaParameterReturnGeneral cargarCombosLoteForeignKeyProductoEstadistica(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto) throws Exception {
		ProductoEstadisticaParameterReturnGeneral  productoestadisticaReturnGeneral =new ProductoEstadisticaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoestadisticaReturnGeneral =new ProductoEstadisticaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productoestadisticaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productoestadisticaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoestadisticaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoestadisticaReturnGeneral.setproductosForeignKey(productosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoestadisticaReturnGeneral;
	}
	
	
	public void deepLoad(ProductoEstadistica productoestadistica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoEstadisticaLogicAdditional.updateProductoEstadisticaToGet(productoestadistica,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoestadistica.setEmpresa(productoestadisticaDataAccess.getEmpresa(connexion,productoestadistica));
		productoestadistica.setSucursal(productoestadisticaDataAccess.getSucursal(connexion,productoestadistica));
		productoestadistica.setBodega(productoestadisticaDataAccess.getBodega(connexion,productoestadistica));
		productoestadistica.setProducto(productoestadisticaDataAccess.getProducto(connexion,productoestadistica));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productoestadistica.setEmpresa(productoestadisticaDataAccess.getEmpresa(connexion,productoestadistica));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productoestadistica.setSucursal(productoestadisticaDataAccess.getSucursal(connexion,productoestadistica));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoestadistica.setBodega(productoestadisticaDataAccess.getBodega(connexion,productoestadistica));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoestadistica.setProducto(productoestadisticaDataAccess.getProducto(connexion,productoestadistica));
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
			productoestadistica.setEmpresa(productoestadisticaDataAccess.getEmpresa(connexion,productoestadistica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoestadistica.setSucursal(productoestadisticaDataAccess.getSucursal(connexion,productoestadistica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoestadistica.setBodega(productoestadisticaDataAccess.getBodega(connexion,productoestadistica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoestadistica.setProducto(productoestadisticaDataAccess.getProducto(connexion,productoestadistica));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoestadistica.setEmpresa(productoestadisticaDataAccess.getEmpresa(connexion,productoestadistica));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productoestadistica.getEmpresa(),isDeep,deepLoadType,clases);
				
		productoestadistica.setSucursal(productoestadisticaDataAccess.getSucursal(connexion,productoestadistica));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productoestadistica.getSucursal(),isDeep,deepLoadType,clases);
				
		productoestadistica.setBodega(productoestadisticaDataAccess.getBodega(connexion,productoestadistica));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoestadistica.getBodega(),isDeep,deepLoadType,clases);
				
		productoestadistica.setProducto(productoestadisticaDataAccess.getProducto(connexion,productoestadistica));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoestadistica.getProducto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productoestadistica.setEmpresa(productoestadisticaDataAccess.getEmpresa(connexion,productoestadistica));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productoestadistica.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productoestadistica.setSucursal(productoestadisticaDataAccess.getSucursal(connexion,productoestadistica));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productoestadistica.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoestadistica.setBodega(productoestadisticaDataAccess.getBodega(connexion,productoestadistica));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productoestadistica.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoestadistica.setProducto(productoestadisticaDataAccess.getProducto(connexion,productoestadistica));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productoestadistica.getProducto(),isDeep,deepLoadType,clases);				
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
			productoestadistica.setEmpresa(productoestadisticaDataAccess.getEmpresa(connexion,productoestadistica));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productoestadistica.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoestadistica.setSucursal(productoestadisticaDataAccess.getSucursal(connexion,productoestadistica));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productoestadistica.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoestadistica.setBodega(productoestadisticaDataAccess.getBodega(connexion,productoestadistica));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productoestadistica.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoestadistica.setProducto(productoestadisticaDataAccess.getProducto(connexion,productoestadistica));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productoestadistica.getProducto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoEstadistica productoestadistica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoEstadisticaLogicAdditional.updateProductoEstadisticaToSave(productoestadistica,this.arrDatoGeneral);
			
ProductoEstadisticaDataAccess.save(productoestadistica, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productoestadistica.getEmpresa(),connexion);

		SucursalDataAccess.save(productoestadistica.getSucursal(),connexion);

		BodegaDataAccess.save(productoestadistica.getBodega(),connexion);

		ProductoDataAccess.save(productoestadistica.getProducto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productoestadistica.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productoestadistica.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoestadistica.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoestadistica.getProducto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productoestadistica.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productoestadistica.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(productoestadistica.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productoestadistica.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(productoestadistica.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoestadistica.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(productoestadistica.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoestadistica.getProducto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productoestadistica.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(productoestadistica.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productoestadistica.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(productoestadistica.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoestadistica.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(productoestadistica.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoestadistica.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(productoestadistica.getProducto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoEstadistica.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoestadistica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(productoestadistica);
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
			this.deepLoad(this.productoestadistica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadistica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoEstadistica.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoestadisticas!=null) {
				for(ProductoEstadistica productoestadistica:productoestadisticas) {
					this.deepLoad(productoestadistica,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(productoestadisticas);
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
			if(productoestadisticas!=null) {
				for(ProductoEstadistica productoestadistica:productoestadisticas) {
					this.deepLoad(productoestadistica,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(productoestadisticas);
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
			this.getNewConnexionToDeep(ProductoEstadistica.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoestadistica,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoEstadistica.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoestadisticas!=null) {
				for(ProductoEstadistica productoestadistica:productoestadisticas) {
					this.deepSave(productoestadistica,isDeep,deepLoadType,clases);
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
			if(productoestadisticas!=null) {
				for(ProductoEstadistica productoestadistica:productoestadisticas) {
					this.deepSave(productoestadistica,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoEstadisticasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoEstadisticaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoEstadisticasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoEstadisticaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoEstadisticasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoEstadisticaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoEstadisticasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoEstadisticaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoEstadisticasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoEstadisticaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoEstadisticasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoEstadisticaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoEstadisticasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoEstadistica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoEstadisticaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoEstadisticasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoEstadisticaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoEstadisticaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoEstadisticaConstantesFunciones.refrescarForeignKeysDescripcionesProductoEstadistica(this.productoestadisticas);
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
			if(ProductoEstadisticaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoEstadisticaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoEstadistica productoestadistica,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoEstadisticaConstantesFunciones.ISCONAUDITORIA) {
				if(productoestadistica.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoEstadisticaDataAccess.TABLENAME, productoestadistica.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoEstadisticaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoEstadisticaLogic.registrarAuditoriaDetallesProductoEstadistica(connexion,productoestadistica,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoestadistica.getIsDeleted()) {
					/*if(!productoestadistica.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoEstadisticaDataAccess.TABLENAME, productoestadistica.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoEstadisticaLogic.registrarAuditoriaDetallesProductoEstadistica(connexion,productoestadistica,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoEstadisticaDataAccess.TABLENAME, productoestadistica.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoestadistica.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoEstadisticaDataAccess.TABLENAME, productoestadistica.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoEstadisticaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoEstadisticaLogic.registrarAuditoriaDetallesProductoEstadistica(connexion,productoestadistica,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoEstadistica(Connexion connexion,ProductoEstadistica productoestadistica)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoestadistica.getIsNew()||!productoestadistica.getid_empresa().equals(productoestadistica.getProductoEstadisticaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getid_empresa()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getid_empresa().toString();
				}
				if(productoestadistica.getid_empresa()!=null)
				{
					strValorNuevo=productoestadistica.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getid_sucursal().equals(productoestadistica.getProductoEstadisticaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getid_sucursal()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getid_sucursal().toString();
				}
				if(productoestadistica.getid_sucursal()!=null)
				{
					strValorNuevo=productoestadistica.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getid_bodega().equals(productoestadistica.getProductoEstadisticaOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getid_bodega()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getid_bodega().toString();
				}
				if(productoestadistica.getid_bodega()!=null)
				{
					strValorNuevo=productoestadistica.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getid_producto().equals(productoestadistica.getProductoEstadisticaOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getid_producto()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getid_producto().toString();
				}
				if(productoestadistica.getid_producto()!=null)
				{
					strValorNuevo=productoestadistica.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getprecio_ultima_compra().equals(productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_compra()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_compra().toString();
				}
				if(productoestadistica.getprecio_ultima_compra()!=null)
				{
					strValorNuevo=productoestadistica.getprecio_ultima_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getprecio_ultima_venta().equals(productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_venta()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_venta().toString();
				}
				if(productoestadistica.getprecio_ultima_venta()!=null)
				{
					strValorNuevo=productoestadistica.getprecio_ultima_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getprecio_ultima_cotizacion().equals(productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_cotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_cotizacion()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_cotizacion().toString();
				}
				if(productoestadistica.getprecio_ultima_cotizacion()!=null)
				{
					strValorNuevo=productoestadistica.getprecio_ultima_cotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getprecio_ultima_proforma().equals(productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_proforma()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getprecio_ultima_proforma().toString();
				}
				if(productoestadistica.getprecio_ultima_proforma()!=null)
				{
					strValorNuevo=productoestadistica.getprecio_ultima_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcantidad_disponible().equals(productoestadistica.getProductoEstadisticaOriginal().getcantidad_disponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcantidad_disponible()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcantidad_disponible().toString();
				}
				if(productoestadistica.getcantidad_disponible()!=null)
				{
					strValorNuevo=productoestadistica.getcantidad_disponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcantidad_reservada().equals(productoestadistica.getProductoEstadisticaOriginal().getcantidad_reservada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcantidad_reservada()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcantidad_reservada().toString();
				}
				if(productoestadistica.getcantidad_reservada()!=null)
				{
					strValorNuevo=productoestadistica.getcantidad_reservada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcantidad_demanda().equals(productoestadistica.getProductoEstadisticaOriginal().getcantidad_demanda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcantidad_demanda()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcantidad_demanda().toString();
				}
				if(productoestadistica.getcantidad_demanda()!=null)
				{
					strValorNuevo=productoestadistica.getcantidad_demanda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcantidad_maximo().equals(productoestadistica.getProductoEstadisticaOriginal().getcantidad_maximo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcantidad_maximo()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcantidad_maximo().toString();
				}
				if(productoestadistica.getcantidad_maximo()!=null)
				{
					strValorNuevo=productoestadistica.getcantidad_maximo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcantidad_minimo().equals(productoestadistica.getProductoEstadisticaOriginal().getcantidad_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcantidad_minimo()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcantidad_minimo().toString();
				}
				if(productoestadistica.getcantidad_minimo()!=null)
				{
					strValorNuevo=productoestadistica.getcantidad_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcantidad_fisica().equals(productoestadistica.getProductoEstadisticaOriginal().getcantidad_fisica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcantidad_fisica()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcantidad_fisica().toString();
				}
				if(productoestadistica.getcantidad_fisica()!=null)
				{
					strValorNuevo=productoestadistica.getcantidad_fisica().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.CANTIDADFISICA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcantidad_orden_compra().equals(productoestadistica.getProductoEstadisticaOriginal().getcantidad_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcantidad_orden_compra()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcantidad_orden_compra().toString();
				}
				if(productoestadistica.getcantidad_orden_compra()!=null)
				{
					strValorNuevo=productoestadistica.getcantidad_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcantidad_pedida().equals(productoestadistica.getProductoEstadisticaOriginal().getcantidad_pedida()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcantidad_pedida()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcantidad_pedida().toString();
				}
				if(productoestadistica.getcantidad_pedida()!=null)
				{
					strValorNuevo=productoestadistica.getcantidad_pedida().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcantidad_requisicion().equals(productoestadistica.getProductoEstadisticaOriginal().getcantidad_requisicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcantidad_requisicion()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcantidad_requisicion().toString();
				}
				if(productoestadistica.getcantidad_requisicion()!=null)
				{
					strValorNuevo=productoestadistica.getcantidad_requisicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getfecha_ultima_ingreso().equals(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_ingreso()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_ingreso().toString();
				}
				if(productoestadistica.getfecha_ultima_ingreso()!=null)
				{
					strValorNuevo=productoestadistica.getfecha_ultima_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getfecha_ultima_egreso().equals(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_egreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_egreso()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_egreso().toString();
				}
				if(productoestadistica.getfecha_ultima_egreso()!=null)
				{
					strValorNuevo=productoestadistica.getfecha_ultima_egreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getfecha_ultima_produccion().equals(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_produccion()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_produccion().toString();
				}
				if(productoestadistica.getfecha_ultima_produccion()!=null)
				{
					strValorNuevo=productoestadistica.getfecha_ultima_produccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getfecha_ultima_compra().equals(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_compra()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_compra().toString();
				}
				if(productoestadistica.getfecha_ultima_compra()!=null)
				{
					strValorNuevo=productoestadistica.getfecha_ultima_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getfecha_ultima_venta().equals(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_venta()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_venta().toString();
				}
				if(productoestadistica.getfecha_ultima_venta()!=null)
				{
					strValorNuevo=productoestadistica.getfecha_ultima_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getfecha_ultima_devolucion().equals(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_devolucion()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_devolucion().toString();
				}
				if(productoestadistica.getfecha_ultima_devolucion()!=null)
				{
					strValorNuevo=productoestadistica.getfecha_ultima_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getfecha_ultima_orden_compra().equals(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_orden_compra()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_orden_compra().toString();
				}
				if(productoestadistica.getfecha_ultima_orden_compra()!=null)
				{
					strValorNuevo=productoestadistica.getfecha_ultima_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getfecha_ultima_pedido().equals(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_pedido()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_pedido().toString();
				}
				if(productoestadistica.getfecha_ultima_pedido()!=null)
				{
					strValorNuevo=productoestadistica.getfecha_ultima_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getfecha_ultima_requisicion().equals(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_requisicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_requisicion()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getfecha_ultima_requisicion().toString();
				}
				if(productoestadistica.getfecha_ultima_requisicion()!=null)
				{
					strValorNuevo=productoestadistica.getfecha_ultima_requisicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.gettotal_ingreso().equals(productoestadistica.getProductoEstadisticaOriginal().gettotal_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().gettotal_ingreso()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().gettotal_ingreso().toString();
				}
				if(productoestadistica.gettotal_ingreso()!=null)
				{
					strValorNuevo=productoestadistica.gettotal_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.TOTALINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.gettotal_egreso().equals(productoestadistica.getProductoEstadisticaOriginal().gettotal_egreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().gettotal_egreso()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().gettotal_egreso().toString();
				}
				if(productoestadistica.gettotal_egreso()!=null)
				{
					strValorNuevo=productoestadistica.gettotal_egreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.TOTALEGRESO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.gettotal_compra().equals(productoestadistica.getProductoEstadisticaOriginal().gettotal_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().gettotal_compra()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().gettotal_compra().toString();
				}
				if(productoestadistica.gettotal_compra()!=null)
				{
					strValorNuevo=productoestadistica.gettotal_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.TOTALCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.gettotal_venta().equals(productoestadistica.getProductoEstadisticaOriginal().gettotal_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().gettotal_venta()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().gettotal_venta().toString();
				}
				if(productoestadistica.gettotal_venta()!=null)
				{
					strValorNuevo=productoestadistica.gettotal_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.TOTALVENTA,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.gettotal_producido().equals(productoestadistica.getProductoEstadisticaOriginal().gettotal_producido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().gettotal_producido()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().gettotal_producido().toString();
				}
				if(productoestadistica.gettotal_producido()!=null)
				{
					strValorNuevo=productoestadistica.gettotal_producido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.gettotal_devuelto().equals(productoestadistica.getProductoEstadisticaOriginal().gettotal_devuelto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().gettotal_devuelto()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().gettotal_devuelto().toString();
				}
				if(productoestadistica.gettotal_devuelto()!=null)
				{
					strValorNuevo=productoestadistica.gettotal_devuelto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcosto_ultimo().equals(productoestadistica.getProductoEstadisticaOriginal().getcosto_ultimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcosto_ultimo()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcosto_ultimo().toString();
				}
				if(productoestadistica.getcosto_ultimo()!=null)
				{
					strValorNuevo=productoestadistica.getcosto_ultimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.COSTOULTIMO,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcosto_total().equals(productoestadistica.getProductoEstadisticaOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcosto_total()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcosto_total().toString();
				}
				if(productoestadistica.getcosto_total()!=null)
				{
					strValorNuevo=productoestadistica.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoestadistica.getIsNew()||!productoestadistica.getcosto_produccion().equals(productoestadistica.getProductoEstadisticaOriginal().getcosto_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoestadistica.getProductoEstadisticaOriginal().getcosto_produccion()!=null)
				{
					strValorActual=productoestadistica.getProductoEstadisticaOriginal().getcosto_produccion().toString();
				}
				if(productoestadistica.getcosto_produccion()!=null)
				{
					strValorNuevo=productoestadistica.getcosto_produccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoEstadisticaRelacionesWithConnection(ProductoEstadistica productoestadistica) throws Exception {

		if(!productoestadistica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoEstadisticaRelacionesBase(productoestadistica,true);
		}
	}

	public void saveProductoEstadisticaRelaciones(ProductoEstadistica productoestadistica)throws Exception {

		if(!productoestadistica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoEstadisticaRelacionesBase(productoestadistica,false);
		}
	}

	public void saveProductoEstadisticaRelacionesBase(ProductoEstadistica productoestadistica,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoEstadistica-saveRelacionesWithConnection");}
	

			this.setProductoEstadistica(productoestadistica);

			if(ProductoEstadisticaLogicAdditional.validarSaveRelaciones(productoestadistica,this)) {

				ProductoEstadisticaLogicAdditional.updateRelacionesToSave(productoestadistica,this);

				if((productoestadistica.getIsNew()||productoestadistica.getIsChanged())&&!productoestadistica.getIsDeleted()) {
					this.saveProductoEstadistica();
					this.saveProductoEstadisticaRelacionesDetalles();

				} else if(productoestadistica.getIsDeleted()) {
					this.saveProductoEstadisticaRelacionesDetalles();
					this.saveProductoEstadistica();
				}

				ProductoEstadisticaLogicAdditional.updateRelacionesToSaveAfter(productoestadistica,this);

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
	
	
	private void saveProductoEstadisticaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoEstadistica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoEstadisticaConstantesFunciones.getClassesForeignKeysOfProductoEstadistica(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoEstadistica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoEstadisticaConstantesFunciones.getClassesRelationshipsOfProductoEstadistica(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

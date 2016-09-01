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
import com.bydan.erp.inventario.util.ProductoCuentaContableConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoCuentaContableParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoCuentaContableParameterGeneral;
import com.bydan.erp.inventario.business.entity.ProductoCuentaContable;
import com.bydan.erp.inventario.business.logic.ProductoCuentaContableLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoCuentaContableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoCuentaContableLogic.class);
	
	protected ProductoCuentaContableDataAccess productocuentacontableDataAccess; 	
	protected ProductoCuentaContable productocuentacontable;
	protected List<ProductoCuentaContable> productocuentacontables;
	protected Object productocuentacontableObject;	
	protected List<Object> productocuentacontablesObject;
	
	public static ClassValidator<ProductoCuentaContable> productocuentacontableValidator = new ClassValidator<ProductoCuentaContable>(ProductoCuentaContable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoCuentaContableLogicAdditional productocuentacontableLogicAdditional=null;
	
	public ProductoCuentaContableLogicAdditional getProductoCuentaContableLogicAdditional() {
		return this.productocuentacontableLogicAdditional;
	}
	
	public void setProductoCuentaContableLogicAdditional(ProductoCuentaContableLogicAdditional productocuentacontableLogicAdditional) {
		try {
			this.productocuentacontableLogicAdditional=productocuentacontableLogicAdditional;
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
	
	
	
	
	public  ProductoCuentaContableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productocuentacontableDataAccess = new ProductoCuentaContableDataAccess();
			
			this.productocuentacontables= new ArrayList<ProductoCuentaContable>();
			this.productocuentacontable= new ProductoCuentaContable();
			
			this.productocuentacontableObject=new Object();
			this.productocuentacontablesObject=new ArrayList<Object>();
				
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
			
			this.productocuentacontableDataAccess.setConnexionType(this.connexionType);
			this.productocuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoCuentaContableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productocuentacontableDataAccess = new ProductoCuentaContableDataAccess();
			this.productocuentacontables= new ArrayList<ProductoCuentaContable>();
			this.productocuentacontable= new ProductoCuentaContable();
			this.productocuentacontableObject=new Object();
			this.productocuentacontablesObject=new ArrayList<Object>();
			
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
			
			this.productocuentacontableDataAccess.setConnexionType(this.connexionType);
			this.productocuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoCuentaContable getProductoCuentaContable() throws Exception {	
		ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToGet(productocuentacontable,this.datosCliente,this.arrDatoGeneral);
		ProductoCuentaContableLogicAdditional.updateProductoCuentaContableToGet(productocuentacontable,this.arrDatoGeneral);
		
		return productocuentacontable;
	}
		
	public void setProductoCuentaContable(ProductoCuentaContable newProductoCuentaContable) {
		this.productocuentacontable = newProductoCuentaContable;
	}
	
	public ProductoCuentaContableDataAccess getProductoCuentaContableDataAccess() {
		return productocuentacontableDataAccess;
	}
	
	public void setProductoCuentaContableDataAccess(ProductoCuentaContableDataAccess newproductocuentacontableDataAccess) {
		this.productocuentacontableDataAccess = newproductocuentacontableDataAccess;
	}
	
	public List<ProductoCuentaContable> getProductoCuentaContables() throws Exception {		
		this.quitarProductoCuentaContablesNulos();
		
		ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToGets(productocuentacontables,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoCuentaContable productocuentacontableLocal: productocuentacontables ) {
			ProductoCuentaContableLogicAdditional.updateProductoCuentaContableToGet(productocuentacontableLocal,this.arrDatoGeneral);
		}
		
		return productocuentacontables;
	}
	
	public void setProductoCuentaContables(List<ProductoCuentaContable> newProductoCuentaContables) {
		this.productocuentacontables = newProductoCuentaContables;
	}
	
	public Object getProductoCuentaContableObject() {	
		this.productocuentacontableObject=this.productocuentacontableDataAccess.getEntityObject();
		return this.productocuentacontableObject;
	}
		
	public void setProductoCuentaContableObject(Object newProductoCuentaContableObject) {
		this.productocuentacontableObject = newProductoCuentaContableObject;
	}
	
	public List<Object> getProductoCuentaContablesObject() {		
		this.productocuentacontablesObject=this.productocuentacontableDataAccess.getEntitiesObject();
		return this.productocuentacontablesObject;
	}
		
	public void setProductoCuentaContablesObject(List<Object> newProductoCuentaContablesObject) {
		this.productocuentacontablesObject = newProductoCuentaContablesObject;
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
		
		if(this.productocuentacontableDataAccess!=null) {
			this.productocuentacontableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productocuentacontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productocuentacontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productocuentacontable = new  ProductoCuentaContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productocuentacontable=productocuentacontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productocuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontable);
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
		productocuentacontable = new  ProductoCuentaContable();
		  		  
        try {
			
			productocuentacontable=productocuentacontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productocuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productocuentacontable = new  ProductoCuentaContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productocuentacontable=productocuentacontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productocuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontable);
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
		productocuentacontable = new  ProductoCuentaContable();
		  		  
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
		productocuentacontable = new  ProductoCuentaContable();
		  		  
        try {
			
			productocuentacontable=productocuentacontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productocuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productocuentacontable = new  ProductoCuentaContable();
		  		  
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
		productocuentacontable = new  ProductoCuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productocuentacontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productocuentacontable = new  ProductoCuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productocuentacontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productocuentacontable = new  ProductoCuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productocuentacontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productocuentacontable = new  ProductoCuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productocuentacontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productocuentacontable = new  ProductoCuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productocuentacontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productocuentacontable = new  ProductoCuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productocuentacontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
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
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		  		  
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
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		  		  
        try {			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		  		  
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
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
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
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		  		  
        try {
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
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
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
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
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productocuentacontable = new  ProductoCuentaContable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontable=productocuentacontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontable);
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
		productocuentacontable = new  ProductoCuentaContable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontable=productocuentacontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
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
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		  		  
        try {
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoCuentaContablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getTodosProductoCuentaContablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
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
	
	public  void  getTodosProductoCuentaContables(String sFinalQuery,Pagination pagination)throws Exception {
		productocuentacontables = new  ArrayList<ProductoCuentaContable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoCuentaContable(productocuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoCuentaContable(ProductoCuentaContable productocuentacontable) throws Exception {
		Boolean estaValidado=false;
		
		if(productocuentacontable.getIsNew() || productocuentacontable.getIsChanged()) { 
			this.invalidValues = productocuentacontableValidator.getInvalidValues(productocuentacontable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productocuentacontable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoCuentaContable(List<ProductoCuentaContable> ProductoCuentaContables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoCuentaContable productocuentacontableLocal:productocuentacontables) {				
			estaValidadoObjeto=this.validarGuardarProductoCuentaContable(productocuentacontableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoCuentaContable(List<ProductoCuentaContable> ProductoCuentaContables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoCuentaContable(productocuentacontables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoCuentaContable(ProductoCuentaContable ProductoCuentaContable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoCuentaContable(productocuentacontable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoCuentaContable productocuentacontable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productocuentacontable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoCuentaContableConstantesFunciones.getProductoCuentaContableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productocuentacontable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoCuentaContableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoCuentaContableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoCuentaContableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-saveProductoCuentaContableWithConnection");connexion.begin();			
			
			ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToSave(this.productocuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoCuentaContableLogicAdditional.updateProductoCuentaContableToSave(this.productocuentacontable,this.arrDatoGeneral);
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productocuentacontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoCuentaContable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoCuentaContable(this.productocuentacontable)) {
				ProductoCuentaContableDataAccess.save(this.productocuentacontable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productocuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToSaveAfter(this.productocuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoCuentaContable();
			
			connexion.commit();			
			
			if(this.productocuentacontable.getIsDeleted()) {
				this.productocuentacontable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoCuentaContable()throws Exception {	
		try {	
			
			ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToSave(this.productocuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoCuentaContableLogicAdditional.updateProductoCuentaContableToSave(this.productocuentacontable,this.arrDatoGeneral);
			
			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productocuentacontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoCuentaContable(this.productocuentacontable)) {			
				ProductoCuentaContableDataAccess.save(this.productocuentacontable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productocuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToSaveAfter(this.productocuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productocuentacontable.getIsDeleted()) {
				this.productocuentacontable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoCuentaContablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-saveProductoCuentaContablesWithConnection");connexion.begin();			
			
			ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToSaves(productocuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoCuentaContables();
			
			Boolean validadoTodosProductoCuentaContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoCuentaContable productocuentacontableLocal:productocuentacontables) {		
				if(productocuentacontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoCuentaContableLogicAdditional.updateProductoCuentaContableToSave(productocuentacontableLocal,this.arrDatoGeneral);
	        	
				ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productocuentacontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoCuentaContable(productocuentacontableLocal)) {
					ProductoCuentaContableDataAccess.save(productocuentacontableLocal, connexion);				
				} else {
					validadoTodosProductoCuentaContable=false;
				}
			}
			
			if(!validadoTodosProductoCuentaContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToSavesAfter(productocuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoCuentaContables();
			
			connexion.commit();		
			
			this.quitarProductoCuentaContablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoCuentaContables()throws Exception {				
		 try {	
			ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToSaves(productocuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoCuentaContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoCuentaContable productocuentacontableLocal:productocuentacontables) {				
				if(productocuentacontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoCuentaContableLogicAdditional.updateProductoCuentaContableToSave(productocuentacontableLocal,this.arrDatoGeneral);
	        	
				ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productocuentacontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoCuentaContable(productocuentacontableLocal)) {				
					ProductoCuentaContableDataAccess.save(productocuentacontableLocal, connexion);				
				} else {
					validadoTodosProductoCuentaContable=false;
				}
			}
			
			if(!validadoTodosProductoCuentaContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoCuentaContableLogicAdditional.checkProductoCuentaContableToSavesAfter(productocuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoCuentaContablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoCuentaContableParameterReturnGeneral procesarAccionProductoCuentaContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoCuentaContable> productocuentacontables,ProductoCuentaContableParameterReturnGeneral productocuentacontableParameterGeneral)throws Exception {
		 try {	
			ProductoCuentaContableParameterReturnGeneral productocuentacontableReturnGeneral=new ProductoCuentaContableParameterReturnGeneral();
	
			ProductoCuentaContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productocuentacontables,productocuentacontableParameterGeneral,productocuentacontableReturnGeneral);
			
			return productocuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoCuentaContableParameterReturnGeneral procesarAccionProductoCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoCuentaContable> productocuentacontables,ProductoCuentaContableParameterReturnGeneral productocuentacontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-procesarAccionProductoCuentaContablesWithConnection");connexion.begin();			
			
			ProductoCuentaContableParameterReturnGeneral productocuentacontableReturnGeneral=new ProductoCuentaContableParameterReturnGeneral();
	
			ProductoCuentaContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productocuentacontables,productocuentacontableParameterGeneral,productocuentacontableReturnGeneral);
			
			this.connexion.commit();
			
			return productocuentacontableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoCuentaContableParameterReturnGeneral procesarEventosProductoCuentaContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoCuentaContable> productocuentacontables,ProductoCuentaContable productocuentacontable,ProductoCuentaContableParameterReturnGeneral productocuentacontableParameterGeneral,Boolean isEsNuevoProductoCuentaContable,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoCuentaContableParameterReturnGeneral productocuentacontableReturnGeneral=new ProductoCuentaContableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productocuentacontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoCuentaContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productocuentacontables,productocuentacontable,productocuentacontableParameterGeneral,productocuentacontableReturnGeneral,isEsNuevoProductoCuentaContable,clases);
			
			return productocuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoCuentaContableParameterReturnGeneral procesarEventosProductoCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoCuentaContable> productocuentacontables,ProductoCuentaContable productocuentacontable,ProductoCuentaContableParameterReturnGeneral productocuentacontableParameterGeneral,Boolean isEsNuevoProductoCuentaContable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-procesarEventosProductoCuentaContablesWithConnection");connexion.begin();			
			
			ProductoCuentaContableParameterReturnGeneral productocuentacontableReturnGeneral=new ProductoCuentaContableParameterReturnGeneral();
	
			productocuentacontableReturnGeneral.setProductoCuentaContable(productocuentacontable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productocuentacontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoCuentaContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productocuentacontables,productocuentacontable,productocuentacontableParameterGeneral,productocuentacontableReturnGeneral,isEsNuevoProductoCuentaContable,clases);
			
			this.connexion.commit();
			
			return productocuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoCuentaContableParameterReturnGeneral procesarImportacionProductoCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoCuentaContableParameterReturnGeneral productocuentacontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-procesarImportacionProductoCuentaContablesWithConnection");connexion.begin();			
			
			ProductoCuentaContableParameterReturnGeneral productocuentacontableReturnGeneral=new ProductoCuentaContableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productocuentacontables=new ArrayList<ProductoCuentaContable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productocuentacontable=new ProductoCuentaContable();
				
				
				if(conColumnasBase) {this.productocuentacontable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productocuentacontable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.productocuentacontables.add(this.productocuentacontable);
			}
			
			this.saveProductoCuentaContables();
			
			this.connexion.commit();
			
			productocuentacontableReturnGeneral.setConRetornoEstaProcesado(true);
			productocuentacontableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productocuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoCuentaContablesEliminados() throws Exception {				
		
		List<ProductoCuentaContable> productocuentacontablesAux= new ArrayList<ProductoCuentaContable>();
		
		for(ProductoCuentaContable productocuentacontable:productocuentacontables) {
			if(!productocuentacontable.getIsDeleted()) {
				productocuentacontablesAux.add(productocuentacontable);
			}
		}
		
		productocuentacontables=productocuentacontablesAux;
	}
	
	public void quitarProductoCuentaContablesNulos() throws Exception {				
		
		List<ProductoCuentaContable> productocuentacontablesAux= new ArrayList<ProductoCuentaContable>();
		
		for(ProductoCuentaContable productocuentacontable : this.productocuentacontables) {
			if(productocuentacontable==null) {
				productocuentacontablesAux.add(productocuentacontable);
			}
		}
		
		//this.productocuentacontables=productocuentacontablesAux;
		
		this.productocuentacontables.removeAll(productocuentacontablesAux);
	}
	
	public void getSetVersionRowProductoCuentaContableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productocuentacontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productocuentacontable.getIsDeleted() || (productocuentacontable.getIsChanged()&&!productocuentacontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productocuentacontableDataAccess.getSetVersionRowProductoCuentaContable(connexion,productocuentacontable.getId());
				
				if(!productocuentacontable.getVersionRow().equals(timestamp)) {	
					productocuentacontable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productocuentacontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoCuentaContable()throws Exception {	
		
		if(productocuentacontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productocuentacontable.getIsDeleted() || (productocuentacontable.getIsChanged()&&!productocuentacontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productocuentacontableDataAccess.getSetVersionRowProductoCuentaContable(connexion,productocuentacontable.getId());
			
			try {							
				if(!productocuentacontable.getVersionRow().equals(timestamp)) {	
					productocuentacontable.setVersionRow(timestamp);
				}
				
				productocuentacontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoCuentaContablesWithConnection()throws Exception {	
		if(productocuentacontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoCuentaContable productocuentacontableAux:productocuentacontables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productocuentacontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productocuentacontableAux.getIsDeleted() || (productocuentacontableAux.getIsChanged()&&!productocuentacontableAux.getIsNew())) {
						
						timestamp=productocuentacontableDataAccess.getSetVersionRowProductoCuentaContable(connexion,productocuentacontableAux.getId());
						
						if(!productocuentacontable.getVersionRow().equals(timestamp)) {	
							productocuentacontableAux.setVersionRow(timestamp);
						}
								
						productocuentacontableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoCuentaContables()throws Exception {	
		if(productocuentacontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoCuentaContable productocuentacontableAux:productocuentacontables) {
					if(productocuentacontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productocuentacontableAux.getIsDeleted() || (productocuentacontableAux.getIsChanged()&&!productocuentacontableAux.getIsNew())) {
						
						timestamp=productocuentacontableDataAccess.getSetVersionRowProductoCuentaContable(connexion,productocuentacontableAux.getId());
						
						if(!productocuentacontableAux.getVersionRow().equals(timestamp)) {	
							productocuentacontableAux.setVersionRow(timestamp);
						}
						
													
						productocuentacontableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoCuentaContableParameterReturnGeneral cargarCombosLoteForeignKeyProductoCuentaContableWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		ProductoCuentaContableParameterReturnGeneral  productocuentacontableReturnGeneral =new ProductoCuentaContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoCuentaContableWithConnection");connexion.begin();
			
			productocuentacontableReturnGeneral =new ProductoCuentaContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productocuentacontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productocuentacontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productocuentacontableReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productocuentacontableReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			productocuentacontableReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productocuentacontableReturnGeneral;
	}
	
	public ProductoCuentaContableParameterReturnGeneral cargarCombosLoteForeignKeyProductoCuentaContable(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		ProductoCuentaContableParameterReturnGeneral  productocuentacontableReturnGeneral =new ProductoCuentaContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productocuentacontableReturnGeneral =new ProductoCuentaContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productocuentacontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productocuentacontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productocuentacontableReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productocuentacontableReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			productocuentacontableReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			productocuentacontableReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productocuentacontableReturnGeneral;
	}
	
	
	public void deepLoad(ProductoCuentaContable productocuentacontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoCuentaContableLogicAdditional.updateProductoCuentaContableToGet(productocuentacontable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productocuentacontable.setEmpresa(productocuentacontableDataAccess.getEmpresa(connexion,productocuentacontable));
		productocuentacontable.setSucursal(productocuentacontableDataAccess.getSucursal(connexion,productocuentacontable));
		productocuentacontable.setBodega(productocuentacontableDataAccess.getBodega(connexion,productocuentacontable));
		productocuentacontable.setProducto(productocuentacontableDataAccess.getProducto(connexion,productocuentacontable));
		productocuentacontable.setCentroCosto(productocuentacontableDataAccess.getCentroCosto(connexion,productocuentacontable));
		productocuentacontable.setCuentaContableInventario(productocuentacontableDataAccess.getCuentaContableInventario(connexion,productocuentacontable));
		productocuentacontable.setCuentaContableCosto(productocuentacontableDataAccess.getCuentaContableCosto(connexion,productocuentacontable));
		productocuentacontable.setCuentaContableVenta(productocuentacontableDataAccess.getCuentaContableVenta(connexion,productocuentacontable));
		productocuentacontable.setCuentaContableDescuento(productocuentacontableDataAccess.getCuentaContableDescuento(connexion,productocuentacontable));
		productocuentacontable.setCuentaContableDevolucion(productocuentacontableDataAccess.getCuentaContableDevolucion(connexion,productocuentacontable));
		productocuentacontable.setCuentaContableDebito(productocuentacontableDataAccess.getCuentaContableDebito(connexion,productocuentacontable));
		productocuentacontable.setCuentaContableCredito(productocuentacontableDataAccess.getCuentaContableCredito(connexion,productocuentacontable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productocuentacontable.setEmpresa(productocuentacontableDataAccess.getEmpresa(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productocuentacontable.setSucursal(productocuentacontableDataAccess.getSucursal(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productocuentacontable.setBodega(productocuentacontableDataAccess.getBodega(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productocuentacontable.setProducto(productocuentacontableDataAccess.getProducto(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				productocuentacontable.setCentroCosto(productocuentacontableDataAccess.getCentroCosto(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableInventario(productocuentacontableDataAccess.getCuentaContableInventario(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableCosto(productocuentacontableDataAccess.getCuentaContableCosto(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableVenta(productocuentacontableDataAccess.getCuentaContableVenta(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableDescuento(productocuentacontableDataAccess.getCuentaContableDescuento(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableDevolucion(productocuentacontableDataAccess.getCuentaContableDevolucion(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableDebito(productocuentacontableDataAccess.getCuentaContableDebito(connexion,productocuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableCredito(productocuentacontableDataAccess.getCuentaContableCredito(connexion,productocuentacontable));
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
			productocuentacontable.setEmpresa(productocuentacontableDataAccess.getEmpresa(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setSucursal(productocuentacontableDataAccess.getSucursal(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setBodega(productocuentacontableDataAccess.getBodega(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setProducto(productocuentacontableDataAccess.getProducto(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCentroCosto(productocuentacontableDataAccess.getCentroCosto(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableInventario(productocuentacontableDataAccess.getCuentaContableInventario(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableCosto(productocuentacontableDataAccess.getCuentaContableCosto(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableVenta(productocuentacontableDataAccess.getCuentaContableVenta(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableDescuento(productocuentacontableDataAccess.getCuentaContableDescuento(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableDevolucion(productocuentacontableDataAccess.getCuentaContableDevolucion(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableDebito(productocuentacontableDataAccess.getCuentaContableDebito(connexion,productocuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableCredito(productocuentacontableDataAccess.getCuentaContableCredito(connexion,productocuentacontable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productocuentacontable.setEmpresa(productocuentacontableDataAccess.getEmpresa(connexion,productocuentacontable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productocuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setSucursal(productocuentacontableDataAccess.getSucursal(connexion,productocuentacontable));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productocuentacontable.getSucursal(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setBodega(productocuentacontableDataAccess.getBodega(connexion,productocuentacontable));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productocuentacontable.getBodega(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setProducto(productocuentacontableDataAccess.getProducto(connexion,productocuentacontable));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productocuentacontable.getProducto(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setCentroCosto(productocuentacontableDataAccess.getCentroCosto(connexion,productocuentacontable));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(productocuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setCuentaContableInventario(productocuentacontableDataAccess.getCuentaContableInventario(connexion,productocuentacontable));
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(productocuentacontable.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setCuentaContableCosto(productocuentacontableDataAccess.getCuentaContableCosto(connexion,productocuentacontable));
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(productocuentacontable.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setCuentaContableVenta(productocuentacontableDataAccess.getCuentaContableVenta(connexion,productocuentacontable));
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(productocuentacontable.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setCuentaContableDescuento(productocuentacontableDataAccess.getCuentaContableDescuento(connexion,productocuentacontable));
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(productocuentacontable.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setCuentaContableDevolucion(productocuentacontableDataAccess.getCuentaContableDevolucion(connexion,productocuentacontable));
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(productocuentacontable.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setCuentaContableDebito(productocuentacontableDataAccess.getCuentaContableDebito(connexion,productocuentacontable));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(productocuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		productocuentacontable.setCuentaContableCredito(productocuentacontableDataAccess.getCuentaContableCredito(connexion,productocuentacontable));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(productocuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productocuentacontable.setEmpresa(productocuentacontableDataAccess.getEmpresa(connexion,productocuentacontable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productocuentacontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productocuentacontable.setSucursal(productocuentacontableDataAccess.getSucursal(connexion,productocuentacontable));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productocuentacontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productocuentacontable.setBodega(productocuentacontableDataAccess.getBodega(connexion,productocuentacontable));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productocuentacontable.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productocuentacontable.setProducto(productocuentacontableDataAccess.getProducto(connexion,productocuentacontable));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productocuentacontable.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				productocuentacontable.setCentroCosto(productocuentacontableDataAccess.getCentroCosto(connexion,productocuentacontable));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(productocuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableInventario(productocuentacontableDataAccess.getCuentaContableInventario(connexion,productocuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableCosto(productocuentacontableDataAccess.getCuentaContableCosto(connexion,productocuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableVenta(productocuentacontableDataAccess.getCuentaContableVenta(connexion,productocuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableDescuento(productocuentacontableDataAccess.getCuentaContableDescuento(connexion,productocuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableDevolucion(productocuentacontableDataAccess.getCuentaContableDevolucion(connexion,productocuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableDebito(productocuentacontableDataAccess.getCuentaContableDebito(connexion,productocuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				productocuentacontable.setCuentaContableCredito(productocuentacontableDataAccess.getCuentaContableCredito(connexion,productocuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			productocuentacontable.setEmpresa(productocuentacontableDataAccess.getEmpresa(connexion,productocuentacontable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productocuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setSucursal(productocuentacontableDataAccess.getSucursal(connexion,productocuentacontable));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productocuentacontable.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setBodega(productocuentacontableDataAccess.getBodega(connexion,productocuentacontable));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productocuentacontable.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setProducto(productocuentacontableDataAccess.getProducto(connexion,productocuentacontable));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productocuentacontable.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCentroCosto(productocuentacontableDataAccess.getCentroCosto(connexion,productocuentacontable));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(productocuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableInventario(productocuentacontableDataAccess.getCuentaContableInventario(connexion,productocuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableCosto(productocuentacontableDataAccess.getCuentaContableCosto(connexion,productocuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableVenta(productocuentacontableDataAccess.getCuentaContableVenta(connexion,productocuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableDescuento(productocuentacontableDataAccess.getCuentaContableDescuento(connexion,productocuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableDevolucion(productocuentacontableDataAccess.getCuentaContableDevolucion(connexion,productocuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableDebito(productocuentacontableDataAccess.getCuentaContableDebito(connexion,productocuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productocuentacontable.setCuentaContableCredito(productocuentacontableDataAccess.getCuentaContableCredito(connexion,productocuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(productocuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoCuentaContable productocuentacontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoCuentaContableLogicAdditional.updateProductoCuentaContableToSave(productocuentacontable,this.arrDatoGeneral);
			
ProductoCuentaContableDataAccess.save(productocuentacontable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productocuentacontable.getEmpresa(),connexion);

		SucursalDataAccess.save(productocuentacontable.getSucursal(),connexion);

		BodegaDataAccess.save(productocuentacontable.getBodega(),connexion);

		ProductoDataAccess.save(productocuentacontable.getProducto(),connexion);

		CentroCostoDataAccess.save(productocuentacontable.getCentroCosto(),connexion);

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableInventario(),connexion);

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableCosto(),connexion);

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableVenta(),connexion);

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDescuento(),connexion);

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDevolucion(),connexion);

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productocuentacontable.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productocuentacontable.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productocuentacontable.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productocuentacontable.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(productocuentacontable.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDescuento(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDevolucion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productocuentacontable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productocuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(productocuentacontable.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productocuentacontable.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(productocuentacontable.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productocuentacontable.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(productocuentacontable.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productocuentacontable.getProducto(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(productocuentacontable.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(productocuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableInventario(),connexion);
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(productocuentacontable.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableCosto(),connexion);
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(productocuentacontable.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableVenta(),connexion);
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(productocuentacontable.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDescuento(),connexion);
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(productocuentacontable.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDevolucion(),connexion);
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(productocuentacontable.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(productocuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(productocuentacontable.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(productocuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productocuentacontable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(productocuentacontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productocuentacontable.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(productocuentacontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productocuentacontable.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(productocuentacontable.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productocuentacontable.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(productocuentacontable.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(productocuentacontable.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(productocuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableInventario(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productocuentacontable.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableCosto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productocuentacontable.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productocuentacontable.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDescuento(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productocuentacontable.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDevolucion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productocuentacontable.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productocuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(productocuentacontable.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(productocuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoCuentaContable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productocuentacontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(productocuentacontable);
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
			this.deepLoad(this.productocuentacontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoCuentaContable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productocuentacontables!=null) {
				for(ProductoCuentaContable productocuentacontable:productocuentacontables) {
					this.deepLoad(productocuentacontable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(productocuentacontables);
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
			if(productocuentacontables!=null) {
				for(ProductoCuentaContable productocuentacontable:productocuentacontables) {
					this.deepLoad(productocuentacontable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(productocuentacontables);
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
			this.getNewConnexionToDeep(ProductoCuentaContable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productocuentacontable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoCuentaContable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productocuentacontables!=null) {
				for(ProductoCuentaContable productocuentacontable:productocuentacontables) {
					this.deepSave(productocuentacontable,isDeep,deepLoadType,clases);
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
			if(productocuentacontables!=null) {
				for(ProductoCuentaContable productocuentacontable:productocuentacontables) {
					this.deepSave(productocuentacontable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoCuentaContablesFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoCuentaContableConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoCuentaContableConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableCosto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableDescuentoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableDescuento(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableDevolucionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableDevolucion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableInventario(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdCuentaContableVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoCuentaContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoCuentaContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoCuentaContableConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoCuentaContableConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoCuentaContablesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoCuentaContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoCuentaContablesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoCuentaContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesProductoCuentaContable(this.productocuentacontables);
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
			if(ProductoCuentaContableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoCuentaContableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoCuentaContable productocuentacontable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoCuentaContableConstantesFunciones.ISCONAUDITORIA) {
				if(productocuentacontable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoCuentaContableDataAccess.TABLENAME, productocuentacontable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoCuentaContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoCuentaContableLogic.registrarAuditoriaDetallesProductoCuentaContable(connexion,productocuentacontable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productocuentacontable.getIsDeleted()) {
					/*if(!productocuentacontable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoCuentaContableDataAccess.TABLENAME, productocuentacontable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoCuentaContableLogic.registrarAuditoriaDetallesProductoCuentaContable(connexion,productocuentacontable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoCuentaContableDataAccess.TABLENAME, productocuentacontable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productocuentacontable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoCuentaContableDataAccess.TABLENAME, productocuentacontable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoCuentaContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoCuentaContableLogic.registrarAuditoriaDetallesProductoCuentaContable(connexion,productocuentacontable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoCuentaContable(Connexion connexion,ProductoCuentaContable productocuentacontable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_empresa().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_empresa()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_empresa().toString();
				}
				if(productocuentacontable.getid_empresa()!=null)
				{
					strValorNuevo=productocuentacontable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_sucursal().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_sucursal()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_sucursal().toString();
				}
				if(productocuentacontable.getid_sucursal()!=null)
				{
					strValorNuevo=productocuentacontable.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_bodega().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_bodega()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_bodega().toString();
				}
				if(productocuentacontable.getid_bodega()!=null)
				{
					strValorNuevo=productocuentacontable.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_producto().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_producto()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_producto().toString();
				}
				if(productocuentacontable.getid_producto()!=null)
				{
					strValorNuevo=productocuentacontable.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_centro_costo().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_centro_costo()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_centro_costo().toString();
				}
				if(productocuentacontable.getid_centro_costo()!=null)
				{
					strValorNuevo=productocuentacontable.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_cuenta_contable_inventario().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_inventario()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_inventario().toString();
				}
				if(productocuentacontable.getid_cuenta_contable_inventario()!=null)
				{
					strValorNuevo=productocuentacontable.getid_cuenta_contable_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_cuenta_contable_costo().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_costo()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_costo().toString();
				}
				if(productocuentacontable.getid_cuenta_contable_costo()!=null)
				{
					strValorNuevo=productocuentacontable.getid_cuenta_contable_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_cuenta_contable_venta().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_venta()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_venta().toString();
				}
				if(productocuentacontable.getid_cuenta_contable_venta()!=null)
				{
					strValorNuevo=productocuentacontable.getid_cuenta_contable_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_cuenta_contable_descuento().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_descuento()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_descuento().toString();
				}
				if(productocuentacontable.getid_cuenta_contable_descuento()!=null)
				{
					strValorNuevo=productocuentacontable.getid_cuenta_contable_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_cuenta_contable_devolucion().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_devolucion()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_devolucion().toString();
				}
				if(productocuentacontable.getid_cuenta_contable_devolucion()!=null)
				{
					strValorNuevo=productocuentacontable.getid_cuenta_contable_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_cuenta_contable_debito().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_debito().toString();
				}
				if(productocuentacontable.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=productocuentacontable.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(productocuentacontable.getIsNew()||!productocuentacontable.getid_cuenta_contable_credito().equals(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=productocuentacontable.getProductoCuentaContableOriginal().getid_cuenta_contable_credito().toString();
				}
				if(productocuentacontable.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=productocuentacontable.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoCuentaContableRelacionesWithConnection(ProductoCuentaContable productocuentacontable) throws Exception {

		if(!productocuentacontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoCuentaContableRelacionesBase(productocuentacontable,true);
		}
	}

	public void saveProductoCuentaContableRelaciones(ProductoCuentaContable productocuentacontable)throws Exception {

		if(!productocuentacontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoCuentaContableRelacionesBase(productocuentacontable,false);
		}
	}

	public void saveProductoCuentaContableRelacionesBase(ProductoCuentaContable productocuentacontable,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoCuentaContable-saveRelacionesWithConnection");}
	

			this.setProductoCuentaContable(productocuentacontable);

			if(ProductoCuentaContableLogicAdditional.validarSaveRelaciones(productocuentacontable,this)) {

				ProductoCuentaContableLogicAdditional.updateRelacionesToSave(productocuentacontable,this);

				if((productocuentacontable.getIsNew()||productocuentacontable.getIsChanged())&&!productocuentacontable.getIsDeleted()) {
					this.saveProductoCuentaContable();
					this.saveProductoCuentaContableRelacionesDetalles();

				} else if(productocuentacontable.getIsDeleted()) {
					this.saveProductoCuentaContableRelacionesDetalles();
					this.saveProductoCuentaContable();
				}

				ProductoCuentaContableLogicAdditional.updateRelacionesToSaveAfter(productocuentacontable,this);

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
	
	
	private void saveProductoCuentaContableRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoCuentaContableConstantesFunciones.getClassesForeignKeysOfProductoCuentaContable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoCuentaContableConstantesFunciones.getClassesRelationshipsOfProductoCuentaContable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

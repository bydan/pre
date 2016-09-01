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
import com.bydan.erp.inventario.util.ProductoImpuestoConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoImpuestoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoImpuestoParameterGeneral;
import com.bydan.erp.inventario.business.entity.ProductoImpuesto;
import com.bydan.erp.inventario.business.logic.ProductoImpuestoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoImpuestoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoImpuestoLogic.class);
	
	protected ProductoImpuestoDataAccess productoimpuestoDataAccess; 	
	protected ProductoImpuesto productoimpuesto;
	protected List<ProductoImpuesto> productoimpuestos;
	protected Object productoimpuestoObject;	
	protected List<Object> productoimpuestosObject;
	
	public static ClassValidator<ProductoImpuesto> productoimpuestoValidator = new ClassValidator<ProductoImpuesto>(ProductoImpuesto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoImpuestoLogicAdditional productoimpuestoLogicAdditional=null;
	
	public ProductoImpuestoLogicAdditional getProductoImpuestoLogicAdditional() {
		return this.productoimpuestoLogicAdditional;
	}
	
	public void setProductoImpuestoLogicAdditional(ProductoImpuestoLogicAdditional productoimpuestoLogicAdditional) {
		try {
			this.productoimpuestoLogicAdditional=productoimpuestoLogicAdditional;
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
	
	
	
	
	public  ProductoImpuestoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoimpuestoDataAccess = new ProductoImpuestoDataAccess();
			
			this.productoimpuestos= new ArrayList<ProductoImpuesto>();
			this.productoimpuesto= new ProductoImpuesto();
			
			this.productoimpuestoObject=new Object();
			this.productoimpuestosObject=new ArrayList<Object>();
				
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
			
			this.productoimpuestoDataAccess.setConnexionType(this.connexionType);
			this.productoimpuestoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoImpuestoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoimpuestoDataAccess = new ProductoImpuestoDataAccess();
			this.productoimpuestos= new ArrayList<ProductoImpuesto>();
			this.productoimpuesto= new ProductoImpuesto();
			this.productoimpuestoObject=new Object();
			this.productoimpuestosObject=new ArrayList<Object>();
			
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
			
			this.productoimpuestoDataAccess.setConnexionType(this.connexionType);
			this.productoimpuestoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoImpuesto getProductoImpuesto() throws Exception {	
		ProductoImpuestoLogicAdditional.checkProductoImpuestoToGet(productoimpuesto,this.datosCliente,this.arrDatoGeneral);
		ProductoImpuestoLogicAdditional.updateProductoImpuestoToGet(productoimpuesto,this.arrDatoGeneral);
		
		return productoimpuesto;
	}
		
	public void setProductoImpuesto(ProductoImpuesto newProductoImpuesto) {
		this.productoimpuesto = newProductoImpuesto;
	}
	
	public ProductoImpuestoDataAccess getProductoImpuestoDataAccess() {
		return productoimpuestoDataAccess;
	}
	
	public void setProductoImpuestoDataAccess(ProductoImpuestoDataAccess newproductoimpuestoDataAccess) {
		this.productoimpuestoDataAccess = newproductoimpuestoDataAccess;
	}
	
	public List<ProductoImpuesto> getProductoImpuestos() throws Exception {		
		this.quitarProductoImpuestosNulos();
		
		ProductoImpuestoLogicAdditional.checkProductoImpuestoToGets(productoimpuestos,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoImpuesto productoimpuestoLocal: productoimpuestos ) {
			ProductoImpuestoLogicAdditional.updateProductoImpuestoToGet(productoimpuestoLocal,this.arrDatoGeneral);
		}
		
		return productoimpuestos;
	}
	
	public void setProductoImpuestos(List<ProductoImpuesto> newProductoImpuestos) {
		this.productoimpuestos = newProductoImpuestos;
	}
	
	public Object getProductoImpuestoObject() {	
		this.productoimpuestoObject=this.productoimpuestoDataAccess.getEntityObject();
		return this.productoimpuestoObject;
	}
		
	public void setProductoImpuestoObject(Object newProductoImpuestoObject) {
		this.productoimpuestoObject = newProductoImpuestoObject;
	}
	
	public List<Object> getProductoImpuestosObject() {		
		this.productoimpuestosObject=this.productoimpuestoDataAccess.getEntitiesObject();
		return this.productoimpuestosObject;
	}
		
	public void setProductoImpuestosObject(List<Object> newProductoImpuestosObject) {
		this.productoimpuestosObject = newProductoImpuestosObject;
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
		
		if(this.productoimpuestoDataAccess!=null) {
			this.productoimpuestoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoimpuestoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoimpuestoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoimpuesto = new  ProductoImpuesto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoimpuesto=productoimpuestoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoimpuesto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuesto);
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
		productoimpuesto = new  ProductoImpuesto();
		  		  
        try {
			
			productoimpuesto=productoimpuestoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoimpuesto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuesto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoimpuesto = new  ProductoImpuesto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoimpuesto=productoimpuestoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoimpuesto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuesto);
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
		productoimpuesto = new  ProductoImpuesto();
		  		  
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
		productoimpuesto = new  ProductoImpuesto();
		  		  
        try {
			
			productoimpuesto=productoimpuestoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoimpuesto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuesto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoimpuesto = new  ProductoImpuesto();
		  		  
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
		productoimpuesto = new  ProductoImpuesto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoimpuestoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoimpuesto = new  ProductoImpuesto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoimpuestoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoimpuesto = new  ProductoImpuesto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoimpuestoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoimpuesto = new  ProductoImpuesto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoimpuestoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoimpuesto = new  ProductoImpuesto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoimpuestoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoimpuesto = new  ProductoImpuesto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoimpuestoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
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
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		  		  
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
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		  		  
        try {			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		  		  
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
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
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
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		  		  
        try {
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
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
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
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
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoimpuesto = new  ProductoImpuesto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuesto=productoimpuestoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoImpuesto(productoimpuesto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuesto);
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
		productoimpuesto = new  ProductoImpuesto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuesto=productoimpuestoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoImpuesto(productoimpuesto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuesto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
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
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		  		  
        try {
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoImpuestosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getTodosProductoImpuestosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
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
	
	public  void  getTodosProductoImpuestos(String sFinalQuery,Pagination pagination)throws Exception {
		productoimpuestos = new  ArrayList<ProductoImpuesto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoImpuesto(productoimpuestos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoImpuesto(ProductoImpuesto productoimpuesto) throws Exception {
		Boolean estaValidado=false;
		
		if(productoimpuesto.getIsNew() || productoimpuesto.getIsChanged()) { 
			this.invalidValues = productoimpuestoValidator.getInvalidValues(productoimpuesto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoimpuesto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoImpuesto(List<ProductoImpuesto> ProductoImpuestos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoImpuesto productoimpuestoLocal:productoimpuestos) {				
			estaValidadoObjeto=this.validarGuardarProductoImpuesto(productoimpuestoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoImpuesto(List<ProductoImpuesto> ProductoImpuestos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoImpuesto(productoimpuestos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoImpuesto(ProductoImpuesto ProductoImpuesto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoImpuesto(productoimpuesto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoImpuesto productoimpuesto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoimpuesto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoImpuestoConstantesFunciones.getProductoImpuestoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoimpuesto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoImpuestoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoImpuestoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoImpuestoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-saveProductoImpuestoWithConnection");connexion.begin();			
			
			ProductoImpuestoLogicAdditional.checkProductoImpuestoToSave(this.productoimpuesto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoImpuestoLogicAdditional.updateProductoImpuestoToSave(this.productoimpuesto,this.arrDatoGeneral);
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoimpuesto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoImpuesto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoImpuesto(this.productoimpuesto)) {
				ProductoImpuestoDataAccess.save(this.productoimpuesto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoimpuesto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoImpuestoLogicAdditional.checkProductoImpuestoToSaveAfter(this.productoimpuesto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoImpuesto();
			
			connexion.commit();			
			
			if(this.productoimpuesto.getIsDeleted()) {
				this.productoimpuesto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoImpuesto()throws Exception {	
		try {	
			
			ProductoImpuestoLogicAdditional.checkProductoImpuestoToSave(this.productoimpuesto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoImpuestoLogicAdditional.updateProductoImpuestoToSave(this.productoimpuesto,this.arrDatoGeneral);
			
			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoimpuesto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoImpuesto(this.productoimpuesto)) {			
				ProductoImpuestoDataAccess.save(this.productoimpuesto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoimpuesto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoImpuestoLogicAdditional.checkProductoImpuestoToSaveAfter(this.productoimpuesto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoimpuesto.getIsDeleted()) {
				this.productoimpuesto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoImpuestosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-saveProductoImpuestosWithConnection");connexion.begin();			
			
			ProductoImpuestoLogicAdditional.checkProductoImpuestoToSaves(productoimpuestos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoImpuestos();
			
			Boolean validadoTodosProductoImpuesto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoImpuesto productoimpuestoLocal:productoimpuestos) {		
				if(productoimpuestoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoImpuestoLogicAdditional.updateProductoImpuestoToSave(productoimpuestoLocal,this.arrDatoGeneral);
	        	
				ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoimpuestoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoImpuesto(productoimpuestoLocal)) {
					ProductoImpuestoDataAccess.save(productoimpuestoLocal, connexion);				
				} else {
					validadoTodosProductoImpuesto=false;
				}
			}
			
			if(!validadoTodosProductoImpuesto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoImpuestoLogicAdditional.checkProductoImpuestoToSavesAfter(productoimpuestos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoImpuestos();
			
			connexion.commit();		
			
			this.quitarProductoImpuestosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoImpuestos()throws Exception {				
		 try {	
			ProductoImpuestoLogicAdditional.checkProductoImpuestoToSaves(productoimpuestos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoImpuesto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoImpuesto productoimpuestoLocal:productoimpuestos) {				
				if(productoimpuestoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoImpuestoLogicAdditional.updateProductoImpuestoToSave(productoimpuestoLocal,this.arrDatoGeneral);
	        	
				ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoimpuestoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoImpuesto(productoimpuestoLocal)) {				
					ProductoImpuestoDataAccess.save(productoimpuestoLocal, connexion);				
				} else {
					validadoTodosProductoImpuesto=false;
				}
			}
			
			if(!validadoTodosProductoImpuesto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoImpuestoLogicAdditional.checkProductoImpuestoToSavesAfter(productoimpuestos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoImpuestosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoImpuestoParameterReturnGeneral procesarAccionProductoImpuestos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoImpuesto> productoimpuestos,ProductoImpuestoParameterReturnGeneral productoimpuestoParameterGeneral)throws Exception {
		 try {	
			ProductoImpuestoParameterReturnGeneral productoimpuestoReturnGeneral=new ProductoImpuestoParameterReturnGeneral();
	
			ProductoImpuestoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoimpuestos,productoimpuestoParameterGeneral,productoimpuestoReturnGeneral);
			
			return productoimpuestoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoImpuestoParameterReturnGeneral procesarAccionProductoImpuestosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoImpuesto> productoimpuestos,ProductoImpuestoParameterReturnGeneral productoimpuestoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-procesarAccionProductoImpuestosWithConnection");connexion.begin();			
			
			ProductoImpuestoParameterReturnGeneral productoimpuestoReturnGeneral=new ProductoImpuestoParameterReturnGeneral();
	
			ProductoImpuestoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoimpuestos,productoimpuestoParameterGeneral,productoimpuestoReturnGeneral);
			
			this.connexion.commit();
			
			return productoimpuestoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoImpuestoParameterReturnGeneral procesarEventosProductoImpuestos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoImpuesto> productoimpuestos,ProductoImpuesto productoimpuesto,ProductoImpuestoParameterReturnGeneral productoimpuestoParameterGeneral,Boolean isEsNuevoProductoImpuesto,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoImpuestoParameterReturnGeneral productoimpuestoReturnGeneral=new ProductoImpuestoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoimpuestoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoImpuestoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoimpuestos,productoimpuesto,productoimpuestoParameterGeneral,productoimpuestoReturnGeneral,isEsNuevoProductoImpuesto,clases);
			
			return productoimpuestoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoImpuestoParameterReturnGeneral procesarEventosProductoImpuestosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoImpuesto> productoimpuestos,ProductoImpuesto productoimpuesto,ProductoImpuestoParameterReturnGeneral productoimpuestoParameterGeneral,Boolean isEsNuevoProductoImpuesto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-procesarEventosProductoImpuestosWithConnection");connexion.begin();			
			
			ProductoImpuestoParameterReturnGeneral productoimpuestoReturnGeneral=new ProductoImpuestoParameterReturnGeneral();
	
			productoimpuestoReturnGeneral.setProductoImpuesto(productoimpuesto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoimpuestoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoImpuestoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoimpuestos,productoimpuesto,productoimpuestoParameterGeneral,productoimpuestoReturnGeneral,isEsNuevoProductoImpuesto,clases);
			
			this.connexion.commit();
			
			return productoimpuestoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoImpuestoParameterReturnGeneral procesarImportacionProductoImpuestosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoImpuestoParameterReturnGeneral productoimpuestoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-procesarImportacionProductoImpuestosWithConnection");connexion.begin();			
			
			ProductoImpuestoParameterReturnGeneral productoimpuestoReturnGeneral=new ProductoImpuestoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoimpuestos=new ArrayList<ProductoImpuesto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoimpuesto=new ProductoImpuesto();
				
				
				if(conColumnasBase) {this.productoimpuesto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoimpuesto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoimpuesto.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoimpuesto.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.productoimpuestos.add(this.productoimpuesto);
			}
			
			this.saveProductoImpuestos();
			
			this.connexion.commit();
			
			productoimpuestoReturnGeneral.setConRetornoEstaProcesado(true);
			productoimpuestoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoimpuestoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoImpuestosEliminados() throws Exception {				
		
		List<ProductoImpuesto> productoimpuestosAux= new ArrayList<ProductoImpuesto>();
		
		for(ProductoImpuesto productoimpuesto:productoimpuestos) {
			if(!productoimpuesto.getIsDeleted()) {
				productoimpuestosAux.add(productoimpuesto);
			}
		}
		
		productoimpuestos=productoimpuestosAux;
	}
	
	public void quitarProductoImpuestosNulos() throws Exception {				
		
		List<ProductoImpuesto> productoimpuestosAux= new ArrayList<ProductoImpuesto>();
		
		for(ProductoImpuesto productoimpuesto : this.productoimpuestos) {
			if(productoimpuesto==null) {
				productoimpuestosAux.add(productoimpuesto);
			}
		}
		
		//this.productoimpuestos=productoimpuestosAux;
		
		this.productoimpuestos.removeAll(productoimpuestosAux);
	}
	
	public void getSetVersionRowProductoImpuestoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoimpuesto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoimpuesto.getIsDeleted() || (productoimpuesto.getIsChanged()&&!productoimpuesto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoimpuestoDataAccess.getSetVersionRowProductoImpuesto(connexion,productoimpuesto.getId());
				
				if(!productoimpuesto.getVersionRow().equals(timestamp)) {	
					productoimpuesto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoimpuesto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoImpuesto()throws Exception {	
		
		if(productoimpuesto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoimpuesto.getIsDeleted() || (productoimpuesto.getIsChanged()&&!productoimpuesto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoimpuestoDataAccess.getSetVersionRowProductoImpuesto(connexion,productoimpuesto.getId());
			
			try {							
				if(!productoimpuesto.getVersionRow().equals(timestamp)) {	
					productoimpuesto.setVersionRow(timestamp);
				}
				
				productoimpuesto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoImpuestosWithConnection()throws Exception {	
		if(productoimpuestos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoImpuesto productoimpuestoAux:productoimpuestos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoimpuestoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoimpuestoAux.getIsDeleted() || (productoimpuestoAux.getIsChanged()&&!productoimpuestoAux.getIsNew())) {
						
						timestamp=productoimpuestoDataAccess.getSetVersionRowProductoImpuesto(connexion,productoimpuestoAux.getId());
						
						if(!productoimpuesto.getVersionRow().equals(timestamp)) {	
							productoimpuestoAux.setVersionRow(timestamp);
						}
								
						productoimpuestoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoImpuestos()throws Exception {	
		if(productoimpuestos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoImpuesto productoimpuestoAux:productoimpuestos) {
					if(productoimpuestoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoimpuestoAux.getIsDeleted() || (productoimpuestoAux.getIsChanged()&&!productoimpuestoAux.getIsNew())) {
						
						timestamp=productoimpuestoDataAccess.getSetVersionRowProductoImpuesto(connexion,productoimpuestoAux.getId());
						
						if(!productoimpuestoAux.getVersionRow().equals(timestamp)) {	
							productoimpuestoAux.setVersionRow(timestamp);
						}
						
													
						productoimpuestoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoImpuestoParameterReturnGeneral cargarCombosLoteForeignKeyProductoImpuestoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalImpuestoInven) throws Exception {
		ProductoImpuestoParameterReturnGeneral  productoimpuestoReturnGeneral =new ProductoImpuestoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoImpuestoWithConnection");connexion.begin();
			
			productoimpuestoReturnGeneral =new ProductoImpuestoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productoimpuestoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productoimpuestoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoimpuestoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoimpuestoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<ImpuestoInven> impuestoinvensForeignKey=new ArrayList<ImpuestoInven>();
			ImpuestoInvenLogic impuestoinvenLogic=new ImpuestoInvenLogic();
			impuestoinvenLogic.setConnexion(this.connexion);
			impuestoinvenLogic.getImpuestoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalImpuestoInven.equals("NONE")) {
				impuestoinvenLogic.getTodosImpuestoInvens(finalQueryGlobalImpuestoInven,new Pagination());
				impuestoinvensForeignKey=impuestoinvenLogic.getImpuestoInvens();
			}

			productoimpuestoReturnGeneral.setimpuestoinvensForeignKey(impuestoinvensForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoimpuestoReturnGeneral;
	}
	
	public ProductoImpuestoParameterReturnGeneral cargarCombosLoteForeignKeyProductoImpuesto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalImpuestoInven) throws Exception {
		ProductoImpuestoParameterReturnGeneral  productoimpuestoReturnGeneral =new ProductoImpuestoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoimpuestoReturnGeneral =new ProductoImpuestoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productoimpuestoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productoimpuestoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoimpuestoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoimpuestoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<ImpuestoInven> impuestoinvensForeignKey=new ArrayList<ImpuestoInven>();
			ImpuestoInvenLogic impuestoinvenLogic=new ImpuestoInvenLogic();
			impuestoinvenLogic.setConnexion(this.connexion);
			impuestoinvenLogic.getImpuestoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalImpuestoInven.equals("NONE")) {
				impuestoinvenLogic.getTodosImpuestoInvens(finalQueryGlobalImpuestoInven,new Pagination());
				impuestoinvensForeignKey=impuestoinvenLogic.getImpuestoInvens();
			}

			productoimpuestoReturnGeneral.setimpuestoinvensForeignKey(impuestoinvensForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoimpuestoReturnGeneral;
	}
	
	
	public void deepLoad(ProductoImpuesto productoimpuesto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoImpuestoLogicAdditional.updateProductoImpuestoToGet(productoimpuesto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoimpuesto.setEmpresa(productoimpuestoDataAccess.getEmpresa(connexion,productoimpuesto));
		productoimpuesto.setSucursal(productoimpuestoDataAccess.getSucursal(connexion,productoimpuesto));
		productoimpuesto.setBodega(productoimpuestoDataAccess.getBodega(connexion,productoimpuesto));
		productoimpuesto.setProducto(productoimpuestoDataAccess.getProducto(connexion,productoimpuesto));
		productoimpuesto.setImpuestoInven(productoimpuestoDataAccess.getImpuestoInven(connexion,productoimpuesto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productoimpuesto.setEmpresa(productoimpuestoDataAccess.getEmpresa(connexion,productoimpuesto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productoimpuesto.setSucursal(productoimpuestoDataAccess.getSucursal(connexion,productoimpuesto));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoimpuesto.setBodega(productoimpuestoDataAccess.getBodega(connexion,productoimpuesto));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoimpuesto.setProducto(productoimpuestoDataAccess.getProducto(connexion,productoimpuesto));
				continue;
			}

			if(clas.clas.equals(ImpuestoInven.class)) {
				productoimpuesto.setImpuestoInven(productoimpuestoDataAccess.getImpuestoInven(connexion,productoimpuesto));
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
			productoimpuesto.setEmpresa(productoimpuestoDataAccess.getEmpresa(connexion,productoimpuesto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoimpuesto.setSucursal(productoimpuestoDataAccess.getSucursal(connexion,productoimpuesto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoimpuesto.setBodega(productoimpuestoDataAccess.getBodega(connexion,productoimpuesto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoimpuesto.setProducto(productoimpuestoDataAccess.getProducto(connexion,productoimpuesto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ImpuestoInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoimpuesto.setImpuestoInven(productoimpuestoDataAccess.getImpuestoInven(connexion,productoimpuesto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoimpuesto.setEmpresa(productoimpuestoDataAccess.getEmpresa(connexion,productoimpuesto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productoimpuesto.getEmpresa(),isDeep,deepLoadType,clases);
				
		productoimpuesto.setSucursal(productoimpuestoDataAccess.getSucursal(connexion,productoimpuesto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productoimpuesto.getSucursal(),isDeep,deepLoadType,clases);
				
		productoimpuesto.setBodega(productoimpuestoDataAccess.getBodega(connexion,productoimpuesto));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoimpuesto.getBodega(),isDeep,deepLoadType,clases);
				
		productoimpuesto.setProducto(productoimpuestoDataAccess.getProducto(connexion,productoimpuesto));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoimpuesto.getProducto(),isDeep,deepLoadType,clases);
				
		productoimpuesto.setImpuestoInven(productoimpuestoDataAccess.getImpuestoInven(connexion,productoimpuesto));
		ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
		impuestoinvenLogic.deepLoad(productoimpuesto.getImpuestoInven(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productoimpuesto.setEmpresa(productoimpuestoDataAccess.getEmpresa(connexion,productoimpuesto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productoimpuesto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productoimpuesto.setSucursal(productoimpuestoDataAccess.getSucursal(connexion,productoimpuesto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productoimpuesto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoimpuesto.setBodega(productoimpuestoDataAccess.getBodega(connexion,productoimpuesto));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productoimpuesto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoimpuesto.setProducto(productoimpuestoDataAccess.getProducto(connexion,productoimpuesto));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productoimpuesto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ImpuestoInven.class)) {
				productoimpuesto.setImpuestoInven(productoimpuestoDataAccess.getImpuestoInven(connexion,productoimpuesto));
				ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
				impuestoinvenLogic.deepLoad(productoimpuesto.getImpuestoInven(),isDeep,deepLoadType,clases);				
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
			productoimpuesto.setEmpresa(productoimpuestoDataAccess.getEmpresa(connexion,productoimpuesto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productoimpuesto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoimpuesto.setSucursal(productoimpuestoDataAccess.getSucursal(connexion,productoimpuesto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productoimpuesto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoimpuesto.setBodega(productoimpuestoDataAccess.getBodega(connexion,productoimpuesto));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productoimpuesto.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoimpuesto.setProducto(productoimpuestoDataAccess.getProducto(connexion,productoimpuesto));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productoimpuesto.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ImpuestoInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoimpuesto.setImpuestoInven(productoimpuestoDataAccess.getImpuestoInven(connexion,productoimpuesto));
			ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
			impuestoinvenLogic.deepLoad(productoimpuesto.getImpuestoInven(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoImpuesto productoimpuesto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoImpuestoLogicAdditional.updateProductoImpuestoToSave(productoimpuesto,this.arrDatoGeneral);
			
ProductoImpuestoDataAccess.save(productoimpuesto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productoimpuesto.getEmpresa(),connexion);

		SucursalDataAccess.save(productoimpuesto.getSucursal(),connexion);

		BodegaDataAccess.save(productoimpuesto.getBodega(),connexion);

		ProductoDataAccess.save(productoimpuesto.getProducto(),connexion);

		ImpuestoInvenDataAccess.save(productoimpuesto.getImpuestoInven(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productoimpuesto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productoimpuesto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoimpuesto.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoimpuesto.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(ImpuestoInven.class)) {
				ImpuestoInvenDataAccess.save(productoimpuesto.getImpuestoInven(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productoimpuesto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productoimpuesto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(productoimpuesto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productoimpuesto.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(productoimpuesto.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoimpuesto.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(productoimpuesto.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoimpuesto.getProducto(),isDeep,deepLoadType,clases);
				

		ImpuestoInvenDataAccess.save(productoimpuesto.getImpuestoInven(),connexion);
		ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
		impuestoinvenLogic.deepLoad(productoimpuesto.getImpuestoInven(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productoimpuesto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(productoimpuesto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productoimpuesto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(productoimpuesto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoimpuesto.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(productoimpuesto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoimpuesto.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(productoimpuesto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ImpuestoInven.class)) {
				ImpuestoInvenDataAccess.save(productoimpuesto.getImpuestoInven(),connexion);
				ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
				impuestoinvenLogic.deepSave(productoimpuesto.getImpuestoInven(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoImpuesto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoimpuesto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(productoimpuesto);
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
			this.deepLoad(this.productoimpuesto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuesto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoImpuesto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoimpuestos!=null) {
				for(ProductoImpuesto productoimpuesto:productoimpuestos) {
					this.deepLoad(productoimpuesto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(productoimpuestos);
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
			if(productoimpuestos!=null) {
				for(ProductoImpuesto productoimpuesto:productoimpuestos) {
					this.deepLoad(productoimpuesto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(productoimpuestos);
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
			this.getNewConnexionToDeep(ProductoImpuesto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoimpuesto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoImpuesto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoimpuestos!=null) {
				for(ProductoImpuesto productoimpuesto:productoimpuestos) {
					this.deepSave(productoimpuesto,isDeep,deepLoadType,clases);
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
			if(productoimpuestos!=null) {
				for(ProductoImpuesto productoimpuesto:productoimpuestos) {
					this.deepSave(productoimpuesto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoImpuestosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoImpuestoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoImpuestosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoImpuestoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoImpuestosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoImpuestoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoImpuestosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoImpuestoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoImpuestosFK_IdImpuestoInvenWithConnection(String sFinalQuery,Pagination pagination,Long id_impuesto_inven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidImpuestoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidImpuestoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_impuesto_inven,ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidImpuestoInven);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdImpuestoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoImpuestosFK_IdImpuestoInven(String sFinalQuery,Pagination pagination,Long id_impuesto_inven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidImpuestoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidImpuestoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_impuesto_inven,ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidImpuestoInven);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdImpuestoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoImpuestosFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoImpuestoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoImpuestosFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoImpuestoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoImpuestosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoImpuesto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoImpuestoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoImpuestosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoImpuestoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoImpuestoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoImpuestoConstantesFunciones.refrescarForeignKeysDescripcionesProductoImpuesto(this.productoimpuestos);
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
			if(ProductoImpuestoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoImpuestoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoImpuesto productoimpuesto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoImpuestoConstantesFunciones.ISCONAUDITORIA) {
				if(productoimpuesto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoImpuestoDataAccess.TABLENAME, productoimpuesto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoImpuestoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoImpuestoLogic.registrarAuditoriaDetallesProductoImpuesto(connexion,productoimpuesto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoimpuesto.getIsDeleted()) {
					/*if(!productoimpuesto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoImpuestoDataAccess.TABLENAME, productoimpuesto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoImpuestoLogic.registrarAuditoriaDetallesProductoImpuesto(connexion,productoimpuesto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoImpuestoDataAccess.TABLENAME, productoimpuesto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoimpuesto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoImpuestoDataAccess.TABLENAME, productoimpuesto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoImpuestoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoImpuestoLogic.registrarAuditoriaDetallesProductoImpuesto(connexion,productoimpuesto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoImpuesto(Connexion connexion,ProductoImpuesto productoimpuesto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoimpuesto.getIsNew()||!productoimpuesto.getid_empresa().equals(productoimpuesto.getProductoImpuestoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoimpuesto.getProductoImpuestoOriginal().getid_empresa()!=null)
				{
					strValorActual=productoimpuesto.getProductoImpuestoOriginal().getid_empresa().toString();
				}
				if(productoimpuesto.getid_empresa()!=null)
				{
					strValorNuevo=productoimpuesto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoImpuestoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoimpuesto.getIsNew()||!productoimpuesto.getid_sucursal().equals(productoimpuesto.getProductoImpuestoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoimpuesto.getProductoImpuestoOriginal().getid_sucursal()!=null)
				{
					strValorActual=productoimpuesto.getProductoImpuestoOriginal().getid_sucursal().toString();
				}
				if(productoimpuesto.getid_sucursal()!=null)
				{
					strValorNuevo=productoimpuesto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoImpuestoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(productoimpuesto.getIsNew()||!productoimpuesto.getid_bodega().equals(productoimpuesto.getProductoImpuestoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoimpuesto.getProductoImpuestoOriginal().getid_bodega()!=null)
				{
					strValorActual=productoimpuesto.getProductoImpuestoOriginal().getid_bodega().toString();
				}
				if(productoimpuesto.getid_bodega()!=null)
				{
					strValorNuevo=productoimpuesto.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoImpuestoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(productoimpuesto.getIsNew()||!productoimpuesto.getid_producto().equals(productoimpuesto.getProductoImpuestoOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoimpuesto.getProductoImpuestoOriginal().getid_producto()!=null)
				{
					strValorActual=productoimpuesto.getProductoImpuestoOriginal().getid_producto().toString();
				}
				if(productoimpuesto.getid_producto()!=null)
				{
					strValorNuevo=productoimpuesto.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoImpuestoConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(productoimpuesto.getIsNew()||!productoimpuesto.getid_impuesto_inven().equals(productoimpuesto.getProductoImpuestoOriginal().getid_impuesto_inven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoimpuesto.getProductoImpuestoOriginal().getid_impuesto_inven()!=null)
				{
					strValorActual=productoimpuesto.getProductoImpuestoOriginal().getid_impuesto_inven().toString();
				}
				if(productoimpuesto.getid_impuesto_inven()!=null)
				{
					strValorNuevo=productoimpuesto.getid_impuesto_inven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoImpuestoConstantesFunciones.IDIMPUESTOINVEN,strValorActual,strValorNuevo);
			}	
			
			if(productoimpuesto.getIsNew()||!productoimpuesto.getporcentaje().equals(productoimpuesto.getProductoImpuestoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoimpuesto.getProductoImpuestoOriginal().getporcentaje()!=null)
				{
					strValorActual=productoimpuesto.getProductoImpuestoOriginal().getporcentaje().toString();
				}
				if(productoimpuesto.getporcentaje()!=null)
				{
					strValorNuevo=productoimpuesto.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoImpuestoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(productoimpuesto.getIsNew()||!productoimpuesto.getvalor().equals(productoimpuesto.getProductoImpuestoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoimpuesto.getProductoImpuestoOriginal().getvalor()!=null)
				{
					strValorActual=productoimpuesto.getProductoImpuestoOriginal().getvalor().toString();
				}
				if(productoimpuesto.getvalor()!=null)
				{
					strValorNuevo=productoimpuesto.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoImpuestoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoImpuestoRelacionesWithConnection(ProductoImpuesto productoimpuesto) throws Exception {

		if(!productoimpuesto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoImpuestoRelacionesBase(productoimpuesto,true);
		}
	}

	public void saveProductoImpuestoRelaciones(ProductoImpuesto productoimpuesto)throws Exception {

		if(!productoimpuesto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoImpuestoRelacionesBase(productoimpuesto,false);
		}
	}

	public void saveProductoImpuestoRelacionesBase(ProductoImpuesto productoimpuesto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoImpuesto-saveRelacionesWithConnection");}
	

			this.setProductoImpuesto(productoimpuesto);

			if(ProductoImpuestoLogicAdditional.validarSaveRelaciones(productoimpuesto,this)) {

				ProductoImpuestoLogicAdditional.updateRelacionesToSave(productoimpuesto,this);

				if((productoimpuesto.getIsNew()||productoimpuesto.getIsChanged())&&!productoimpuesto.getIsDeleted()) {
					this.saveProductoImpuesto();
					this.saveProductoImpuestoRelacionesDetalles();

				} else if(productoimpuesto.getIsDeleted()) {
					this.saveProductoImpuestoRelacionesDetalles();
					this.saveProductoImpuesto();
				}

				ProductoImpuestoLogicAdditional.updateRelacionesToSaveAfter(productoimpuesto,this);

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
	
	
	private void saveProductoImpuestoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoImpuesto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoImpuestoConstantesFunciones.getClassesForeignKeysOfProductoImpuesto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoImpuesto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoImpuestoConstantesFunciones.getClassesRelationshipsOfProductoImpuesto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

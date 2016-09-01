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
import com.bydan.erp.inventario.util.ProductoPromocionConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoPromocionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoPromocionParameterGeneral;
import com.bydan.erp.inventario.business.entity.ProductoPromocion;
import com.bydan.erp.inventario.business.logic.ProductoPromocionLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoPromocionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoPromocionLogic.class);
	
	protected ProductoPromocionDataAccess productopromocionDataAccess; 	
	protected ProductoPromocion productopromocion;
	protected List<ProductoPromocion> productopromocions;
	protected Object productopromocionObject;	
	protected List<Object> productopromocionsObject;
	
	public static ClassValidator<ProductoPromocion> productopromocionValidator = new ClassValidator<ProductoPromocion>(ProductoPromocion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoPromocionLogicAdditional productopromocionLogicAdditional=null;
	
	public ProductoPromocionLogicAdditional getProductoPromocionLogicAdditional() {
		return this.productopromocionLogicAdditional;
	}
	
	public void setProductoPromocionLogicAdditional(ProductoPromocionLogicAdditional productopromocionLogicAdditional) {
		try {
			this.productopromocionLogicAdditional=productopromocionLogicAdditional;
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
	
	
	
	
	public  ProductoPromocionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productopromocionDataAccess = new ProductoPromocionDataAccess();
			
			this.productopromocions= new ArrayList<ProductoPromocion>();
			this.productopromocion= new ProductoPromocion();
			
			this.productopromocionObject=new Object();
			this.productopromocionsObject=new ArrayList<Object>();
				
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
			
			this.productopromocionDataAccess.setConnexionType(this.connexionType);
			this.productopromocionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoPromocionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productopromocionDataAccess = new ProductoPromocionDataAccess();
			this.productopromocions= new ArrayList<ProductoPromocion>();
			this.productopromocion= new ProductoPromocion();
			this.productopromocionObject=new Object();
			this.productopromocionsObject=new ArrayList<Object>();
			
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
			
			this.productopromocionDataAccess.setConnexionType(this.connexionType);
			this.productopromocionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoPromocion getProductoPromocion() throws Exception {	
		ProductoPromocionLogicAdditional.checkProductoPromocionToGet(productopromocion,this.datosCliente,this.arrDatoGeneral);
		ProductoPromocionLogicAdditional.updateProductoPromocionToGet(productopromocion,this.arrDatoGeneral);
		
		return productopromocion;
	}
		
	public void setProductoPromocion(ProductoPromocion newProductoPromocion) {
		this.productopromocion = newProductoPromocion;
	}
	
	public ProductoPromocionDataAccess getProductoPromocionDataAccess() {
		return productopromocionDataAccess;
	}
	
	public void setProductoPromocionDataAccess(ProductoPromocionDataAccess newproductopromocionDataAccess) {
		this.productopromocionDataAccess = newproductopromocionDataAccess;
	}
	
	public List<ProductoPromocion> getProductoPromocions() throws Exception {		
		this.quitarProductoPromocionsNulos();
		
		ProductoPromocionLogicAdditional.checkProductoPromocionToGets(productopromocions,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoPromocion productopromocionLocal: productopromocions ) {
			ProductoPromocionLogicAdditional.updateProductoPromocionToGet(productopromocionLocal,this.arrDatoGeneral);
		}
		
		return productopromocions;
	}
	
	public void setProductoPromocions(List<ProductoPromocion> newProductoPromocions) {
		this.productopromocions = newProductoPromocions;
	}
	
	public Object getProductoPromocionObject() {	
		this.productopromocionObject=this.productopromocionDataAccess.getEntityObject();
		return this.productopromocionObject;
	}
		
	public void setProductoPromocionObject(Object newProductoPromocionObject) {
		this.productopromocionObject = newProductoPromocionObject;
	}
	
	public List<Object> getProductoPromocionsObject() {		
		this.productopromocionsObject=this.productopromocionDataAccess.getEntitiesObject();
		return this.productopromocionsObject;
	}
		
	public void setProductoPromocionsObject(List<Object> newProductoPromocionsObject) {
		this.productopromocionsObject = newProductoPromocionsObject;
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
		
		if(this.productopromocionDataAccess!=null) {
			this.productopromocionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productopromocionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productopromocionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productopromocion = new  ProductoPromocion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productopromocion=productopromocionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productopromocion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocion);
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
		productopromocion = new  ProductoPromocion();
		  		  
        try {
			
			productopromocion=productopromocionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productopromocion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productopromocion = new  ProductoPromocion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productopromocion=productopromocionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productopromocion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocion);
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
		productopromocion = new  ProductoPromocion();
		  		  
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
		productopromocion = new  ProductoPromocion();
		  		  
        try {
			
			productopromocion=productopromocionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productopromocion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productopromocion = new  ProductoPromocion();
		  		  
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
		productopromocion = new  ProductoPromocion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productopromocionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productopromocion = new  ProductoPromocion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productopromocionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productopromocion = new  ProductoPromocion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productopromocionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productopromocion = new  ProductoPromocion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productopromocionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productopromocion = new  ProductoPromocion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productopromocionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productopromocion = new  ProductoPromocion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productopromocionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productopromocions = new  ArrayList<ProductoPromocion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
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
		productopromocions = new  ArrayList<ProductoPromocion>();
		  		  
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
		productopromocions = new  ArrayList<ProductoPromocion>();
		  		  
        try {			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productopromocions = new  ArrayList<ProductoPromocion>();
		  		  
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
		productopromocions = new  ArrayList<ProductoPromocion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
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
		productopromocions = new  ArrayList<ProductoPromocion>();
		  		  
        try {
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
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
		productopromocions = new  ArrayList<ProductoPromocion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
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
		productopromocions = new  ArrayList<ProductoPromocion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productopromocion = new  ProductoPromocion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocion=productopromocionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoPromocion(productopromocion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocion);
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
		productopromocion = new  ProductoPromocion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocion=productopromocionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoPromocion(productopromocion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productopromocions = new  ArrayList<ProductoPromocion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
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
		productopromocions = new  ArrayList<ProductoPromocion>();
		  		  
        try {
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoPromocionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productopromocions = new  ArrayList<ProductoPromocion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getTodosProductoPromocionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
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
	
	public  void  getTodosProductoPromocions(String sFinalQuery,Pagination pagination)throws Exception {
		productopromocions = new  ArrayList<ProductoPromocion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoPromocion(productopromocions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoPromocion(ProductoPromocion productopromocion) throws Exception {
		Boolean estaValidado=false;
		
		if(productopromocion.getIsNew() || productopromocion.getIsChanged()) { 
			this.invalidValues = productopromocionValidator.getInvalidValues(productopromocion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productopromocion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoPromocion(List<ProductoPromocion> ProductoPromocions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoPromocion productopromocionLocal:productopromocions) {				
			estaValidadoObjeto=this.validarGuardarProductoPromocion(productopromocionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoPromocion(List<ProductoPromocion> ProductoPromocions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoPromocion(productopromocions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoPromocion(ProductoPromocion ProductoPromocion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoPromocion(productopromocion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoPromocion productopromocion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productopromocion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoPromocionConstantesFunciones.getProductoPromocionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productopromocion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoPromocionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoPromocionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoPromocionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-saveProductoPromocionWithConnection");connexion.begin();			
			
			ProductoPromocionLogicAdditional.checkProductoPromocionToSave(this.productopromocion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoPromocionLogicAdditional.updateProductoPromocionToSave(this.productopromocion,this.arrDatoGeneral);
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productopromocion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoPromocion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoPromocion(this.productopromocion)) {
				ProductoPromocionDataAccess.save(this.productopromocion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productopromocion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoPromocionLogicAdditional.checkProductoPromocionToSaveAfter(this.productopromocion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoPromocion();
			
			connexion.commit();			
			
			if(this.productopromocion.getIsDeleted()) {
				this.productopromocion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoPromocion()throws Exception {	
		try {	
			
			ProductoPromocionLogicAdditional.checkProductoPromocionToSave(this.productopromocion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoPromocionLogicAdditional.updateProductoPromocionToSave(this.productopromocion,this.arrDatoGeneral);
			
			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productopromocion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoPromocion(this.productopromocion)) {			
				ProductoPromocionDataAccess.save(this.productopromocion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productopromocion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoPromocionLogicAdditional.checkProductoPromocionToSaveAfter(this.productopromocion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productopromocion.getIsDeleted()) {
				this.productopromocion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoPromocionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-saveProductoPromocionsWithConnection");connexion.begin();			
			
			ProductoPromocionLogicAdditional.checkProductoPromocionToSaves(productopromocions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoPromocions();
			
			Boolean validadoTodosProductoPromocion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoPromocion productopromocionLocal:productopromocions) {		
				if(productopromocionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoPromocionLogicAdditional.updateProductoPromocionToSave(productopromocionLocal,this.arrDatoGeneral);
	        	
				ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productopromocionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoPromocion(productopromocionLocal)) {
					ProductoPromocionDataAccess.save(productopromocionLocal, connexion);				
				} else {
					validadoTodosProductoPromocion=false;
				}
			}
			
			if(!validadoTodosProductoPromocion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoPromocionLogicAdditional.checkProductoPromocionToSavesAfter(productopromocions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoPromocions();
			
			connexion.commit();		
			
			this.quitarProductoPromocionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoPromocions()throws Exception {				
		 try {	
			ProductoPromocionLogicAdditional.checkProductoPromocionToSaves(productopromocions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoPromocion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoPromocion productopromocionLocal:productopromocions) {				
				if(productopromocionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoPromocionLogicAdditional.updateProductoPromocionToSave(productopromocionLocal,this.arrDatoGeneral);
	        	
				ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productopromocionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoPromocion(productopromocionLocal)) {				
					ProductoPromocionDataAccess.save(productopromocionLocal, connexion);				
				} else {
					validadoTodosProductoPromocion=false;
				}
			}
			
			if(!validadoTodosProductoPromocion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoPromocionLogicAdditional.checkProductoPromocionToSavesAfter(productopromocions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoPromocionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoPromocionParameterReturnGeneral procesarAccionProductoPromocions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoPromocion> productopromocions,ProductoPromocionParameterReturnGeneral productopromocionParameterGeneral)throws Exception {
		 try {	
			ProductoPromocionParameterReturnGeneral productopromocionReturnGeneral=new ProductoPromocionParameterReturnGeneral();
	
			ProductoPromocionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productopromocions,productopromocionParameterGeneral,productopromocionReturnGeneral);
			
			return productopromocionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoPromocionParameterReturnGeneral procesarAccionProductoPromocionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoPromocion> productopromocions,ProductoPromocionParameterReturnGeneral productopromocionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-procesarAccionProductoPromocionsWithConnection");connexion.begin();			
			
			ProductoPromocionParameterReturnGeneral productopromocionReturnGeneral=new ProductoPromocionParameterReturnGeneral();
	
			ProductoPromocionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productopromocions,productopromocionParameterGeneral,productopromocionReturnGeneral);
			
			this.connexion.commit();
			
			return productopromocionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoPromocionParameterReturnGeneral procesarEventosProductoPromocions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoPromocion> productopromocions,ProductoPromocion productopromocion,ProductoPromocionParameterReturnGeneral productopromocionParameterGeneral,Boolean isEsNuevoProductoPromocion,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoPromocionParameterReturnGeneral productopromocionReturnGeneral=new ProductoPromocionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productopromocionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoPromocionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productopromocions,productopromocion,productopromocionParameterGeneral,productopromocionReturnGeneral,isEsNuevoProductoPromocion,clases);
			
			return productopromocionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoPromocionParameterReturnGeneral procesarEventosProductoPromocionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoPromocion> productopromocions,ProductoPromocion productopromocion,ProductoPromocionParameterReturnGeneral productopromocionParameterGeneral,Boolean isEsNuevoProductoPromocion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-procesarEventosProductoPromocionsWithConnection");connexion.begin();			
			
			ProductoPromocionParameterReturnGeneral productopromocionReturnGeneral=new ProductoPromocionParameterReturnGeneral();
	
			productopromocionReturnGeneral.setProductoPromocion(productopromocion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productopromocionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoPromocionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productopromocions,productopromocion,productopromocionParameterGeneral,productopromocionReturnGeneral,isEsNuevoProductoPromocion,clases);
			
			this.connexion.commit();
			
			return productopromocionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoPromocionParameterReturnGeneral procesarImportacionProductoPromocionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoPromocionParameterReturnGeneral productopromocionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-procesarImportacionProductoPromocionsWithConnection");connexion.begin();			
			
			ProductoPromocionParameterReturnGeneral productopromocionReturnGeneral=new ProductoPromocionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productopromocions=new ArrayList<ProductoPromocion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productopromocion=new ProductoPromocion();
				
				
				if(conColumnasBase) {this.productopromocion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productopromocion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productopromocion.setcantidad(Double.parseDouble(arrColumnas[iColumn++]));
				this.productopromocion.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.productopromocion.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.productopromocion.setdescripcion(arrColumnas[iColumn++]);
				this.productopromocion.setdescripcion2(arrColumnas[iColumn++]);
				
				this.productopromocions.add(this.productopromocion);
			}
			
			this.saveProductoPromocions();
			
			this.connexion.commit();
			
			productopromocionReturnGeneral.setConRetornoEstaProcesado(true);
			productopromocionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productopromocionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoPromocionsEliminados() throws Exception {				
		
		List<ProductoPromocion> productopromocionsAux= new ArrayList<ProductoPromocion>();
		
		for(ProductoPromocion productopromocion:productopromocions) {
			if(!productopromocion.getIsDeleted()) {
				productopromocionsAux.add(productopromocion);
			}
		}
		
		productopromocions=productopromocionsAux;
	}
	
	public void quitarProductoPromocionsNulos() throws Exception {				
		
		List<ProductoPromocion> productopromocionsAux= new ArrayList<ProductoPromocion>();
		
		for(ProductoPromocion productopromocion : this.productopromocions) {
			if(productopromocion==null) {
				productopromocionsAux.add(productopromocion);
			}
		}
		
		//this.productopromocions=productopromocionsAux;
		
		this.productopromocions.removeAll(productopromocionsAux);
	}
	
	public void getSetVersionRowProductoPromocionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productopromocion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productopromocion.getIsDeleted() || (productopromocion.getIsChanged()&&!productopromocion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productopromocionDataAccess.getSetVersionRowProductoPromocion(connexion,productopromocion.getId());
				
				if(!productopromocion.getVersionRow().equals(timestamp)) {	
					productopromocion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productopromocion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoPromocion()throws Exception {	
		
		if(productopromocion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productopromocion.getIsDeleted() || (productopromocion.getIsChanged()&&!productopromocion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productopromocionDataAccess.getSetVersionRowProductoPromocion(connexion,productopromocion.getId());
			
			try {							
				if(!productopromocion.getVersionRow().equals(timestamp)) {	
					productopromocion.setVersionRow(timestamp);
				}
				
				productopromocion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoPromocionsWithConnection()throws Exception {	
		if(productopromocions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoPromocion productopromocionAux:productopromocions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productopromocionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productopromocionAux.getIsDeleted() || (productopromocionAux.getIsChanged()&&!productopromocionAux.getIsNew())) {
						
						timestamp=productopromocionDataAccess.getSetVersionRowProductoPromocion(connexion,productopromocionAux.getId());
						
						if(!productopromocion.getVersionRow().equals(timestamp)) {	
							productopromocionAux.setVersionRow(timestamp);
						}
								
						productopromocionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoPromocions()throws Exception {	
		if(productopromocions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoPromocion productopromocionAux:productopromocions) {
					if(productopromocionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productopromocionAux.getIsDeleted() || (productopromocionAux.getIsChanged()&&!productopromocionAux.getIsNew())) {
						
						timestamp=productopromocionDataAccess.getSetVersionRowProductoPromocion(connexion,productopromocionAux.getId());
						
						if(!productopromocionAux.getVersionRow().equals(timestamp)) {	
							productopromocionAux.setVersionRow(timestamp);
						}
						
													
						productopromocionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoPromocionParameterReturnGeneral cargarCombosLoteForeignKeyProductoPromocionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalBodegaRelacion,String finalQueryGlobalProductoRelacion) throws Exception {
		ProductoPromocionParameterReturnGeneral  productopromocionReturnGeneral =new ProductoPromocionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoPromocionWithConnection");connexion.begin();
			
			productopromocionReturnGeneral =new ProductoPromocionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productopromocionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productopromocionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productopromocionReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productopromocionReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Bodega> bodegarelacionsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegarelacionLogic=new BodegaLogic();
			bodegarelacionLogic.setConnexion(this.connexion);
			bodegarelacionLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaRelacion.equals("NONE")) {
				bodegarelacionLogic.getTodosBodegas(finalQueryGlobalBodegaRelacion,new Pagination());
				bodegarelacionsForeignKey=bodegarelacionLogic.getBodegas();
			}

			productopromocionReturnGeneral.setbodegarelacionsForeignKey(bodegarelacionsForeignKey);


			List<Producto> productorelacionsForeignKey=new ArrayList<Producto>();
			ProductoLogic productorelacionLogic=new ProductoLogic();
			productorelacionLogic.setConnexion(this.connexion);
			productorelacionLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoRelacion.equals("NONE")) {
				productorelacionLogic.getTodosProductos(finalQueryGlobalProductoRelacion,new Pagination());
				productorelacionsForeignKey=productorelacionLogic.getProductos();
			}

			productopromocionReturnGeneral.setproductorelacionsForeignKey(productorelacionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productopromocionReturnGeneral;
	}
	
	public ProductoPromocionParameterReturnGeneral cargarCombosLoteForeignKeyProductoPromocion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalBodegaRelacion,String finalQueryGlobalProductoRelacion) throws Exception {
		ProductoPromocionParameterReturnGeneral  productopromocionReturnGeneral =new ProductoPromocionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productopromocionReturnGeneral =new ProductoPromocionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			productopromocionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			productopromocionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productopromocionReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productopromocionReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Bodega> bodegarelacionsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegarelacionLogic=new BodegaLogic();
			bodegarelacionLogic.setConnexion(this.connexion);
			bodegarelacionLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaRelacion.equals("NONE")) {
				bodegarelacionLogic.getTodosBodegas(finalQueryGlobalBodegaRelacion,new Pagination());
				bodegarelacionsForeignKey=bodegarelacionLogic.getBodegas();
			}

			productopromocionReturnGeneral.setbodegarelacionsForeignKey(bodegarelacionsForeignKey);


			List<Producto> productorelacionsForeignKey=new ArrayList<Producto>();
			ProductoLogic productorelacionLogic=new ProductoLogic();
			productorelacionLogic.setConnexion(this.connexion);
			productorelacionLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoRelacion.equals("NONE")) {
				productorelacionLogic.getTodosProductos(finalQueryGlobalProductoRelacion,new Pagination());
				productorelacionsForeignKey=productorelacionLogic.getProductos();
			}

			productopromocionReturnGeneral.setproductorelacionsForeignKey(productorelacionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productopromocionReturnGeneral;
	}
	
	
	public void deepLoad(ProductoPromocion productopromocion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoPromocionLogicAdditional.updateProductoPromocionToGet(productopromocion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productopromocion.setEmpresa(productopromocionDataAccess.getEmpresa(connexion,productopromocion));
		productopromocion.setSucursal(productopromocionDataAccess.getSucursal(connexion,productopromocion));
		productopromocion.setBodega(productopromocionDataAccess.getBodega(connexion,productopromocion));
		productopromocion.setProducto(productopromocionDataAccess.getProducto(connexion,productopromocion));
		productopromocion.setBodegaRelacion(productopromocionDataAccess.getBodegaRelacion(connexion,productopromocion));
		productopromocion.setProductoRelacion(productopromocionDataAccess.getProductoRelacion(connexion,productopromocion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productopromocion.setEmpresa(productopromocionDataAccess.getEmpresa(connexion,productopromocion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productopromocion.setSucursal(productopromocionDataAccess.getSucursal(connexion,productopromocion));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productopromocion.setBodega(productopromocionDataAccess.getBodega(connexion,productopromocion));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productopromocion.setProducto(productopromocionDataAccess.getProducto(connexion,productopromocion));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productopromocion.setBodegaRelacion(productopromocionDataAccess.getBodegaRelacion(connexion,productopromocion));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productopromocion.setProductoRelacion(productopromocionDataAccess.getProductoRelacion(connexion,productopromocion));
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
			productopromocion.setEmpresa(productopromocionDataAccess.getEmpresa(connexion,productopromocion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setSucursal(productopromocionDataAccess.getSucursal(connexion,productopromocion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setBodega(productopromocionDataAccess.getBodega(connexion,productopromocion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setProducto(productopromocionDataAccess.getProducto(connexion,productopromocion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setBodegaRelacion(productopromocionDataAccess.getBodegaRelacion(connexion,productopromocion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setProductoRelacion(productopromocionDataAccess.getProductoRelacion(connexion,productopromocion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productopromocion.setEmpresa(productopromocionDataAccess.getEmpresa(connexion,productopromocion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productopromocion.getEmpresa(),isDeep,deepLoadType,clases);
				
		productopromocion.setSucursal(productopromocionDataAccess.getSucursal(connexion,productopromocion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productopromocion.getSucursal(),isDeep,deepLoadType,clases);
				
		productopromocion.setBodega(productopromocionDataAccess.getBodega(connexion,productopromocion));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productopromocion.getBodega(),isDeep,deepLoadType,clases);
				
		productopromocion.setProducto(productopromocionDataAccess.getProducto(connexion,productopromocion));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productopromocion.getProducto(),isDeep,deepLoadType,clases);
				
		productopromocion.setBodegaRelacion(productopromocionDataAccess.getBodegaRelacion(connexion,productopromocion));
		BodegaLogic bodegarelacionLogic= new BodegaLogic(connexion);
		bodegarelacionLogic.deepLoad(productopromocion.getBodegaRelacion(),isDeep,deepLoadType,clases);
				
		productopromocion.setProductoRelacion(productopromocionDataAccess.getProductoRelacion(connexion,productopromocion));
		ProductoLogic productorelacionLogic= new ProductoLogic(connexion);
		productorelacionLogic.deepLoad(productopromocion.getProductoRelacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				productopromocion.setEmpresa(productopromocionDataAccess.getEmpresa(connexion,productopromocion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(productopromocion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				productopromocion.setSucursal(productopromocionDataAccess.getSucursal(connexion,productopromocion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(productopromocion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productopromocion.setBodega(productopromocionDataAccess.getBodega(connexion,productopromocion));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productopromocion.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productopromocion.setProducto(productopromocionDataAccess.getProducto(connexion,productopromocion));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productopromocion.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productopromocion.setBodegaRelacion(productopromocionDataAccess.getBodegaRelacion(connexion,productopromocion));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productopromocion.getBodegaRelacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productopromocion.setProductoRelacion(productopromocionDataAccess.getProductoRelacion(connexion,productopromocion));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productopromocion.getProductoRelacion(),isDeep,deepLoadType,clases);				
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
			productopromocion.setEmpresa(productopromocionDataAccess.getEmpresa(connexion,productopromocion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(productopromocion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setSucursal(productopromocionDataAccess.getSucursal(connexion,productopromocion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(productopromocion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setBodega(productopromocionDataAccess.getBodega(connexion,productopromocion));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productopromocion.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setProducto(productopromocionDataAccess.getProducto(connexion,productopromocion));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productopromocion.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setBodegaRelacion(productopromocionDataAccess.getBodegaRelacion(connexion,productopromocion));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productopromocion.getBodegaRelacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productopromocion.setProductoRelacion(productopromocionDataAccess.getProductoRelacion(connexion,productopromocion));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productopromocion.getProductoRelacion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoPromocion productopromocion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoPromocionLogicAdditional.updateProductoPromocionToSave(productopromocion,this.arrDatoGeneral);
			
ProductoPromocionDataAccess.save(productopromocion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productopromocion.getEmpresa(),connexion);

		SucursalDataAccess.save(productopromocion.getSucursal(),connexion);

		BodegaDataAccess.save(productopromocion.getBodega(),connexion);

		ProductoDataAccess.save(productopromocion.getProducto(),connexion);

		BodegaDataAccess.save(productopromocion.getBodegaRelacion(),connexion);

		ProductoDataAccess.save(productopromocion.getProductoRelacion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productopromocion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productopromocion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productopromocion.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productopromocion.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productopromocion.getBodegaRelacion(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productopromocion.getProductoRelacion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(productopromocion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(productopromocion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(productopromocion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(productopromocion.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(productopromocion.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productopromocion.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(productopromocion.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productopromocion.getProducto(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(productopromocion.getBodegaRelacion(),connexion);
		BodegaLogic bodegarelacionLogic= new BodegaLogic(connexion);
		bodegarelacionLogic.deepLoad(productopromocion.getBodegaRelacion(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(productopromocion.getProductoRelacion(),connexion);
		ProductoLogic productorelacionLogic= new ProductoLogic(connexion);
		productorelacionLogic.deepLoad(productopromocion.getProductoRelacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(productopromocion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(productopromocion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(productopromocion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(productopromocion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productopromocion.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(productopromocion.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productopromocion.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(productopromocion.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productopromocion.getBodegaRelacion(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(productopromocion.getBodegaRelacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productopromocion.getProductoRelacion(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(productopromocion.getProductoRelacion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoPromocion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productopromocion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(productopromocion);
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
			this.deepLoad(this.productopromocion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoPromocion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productopromocions!=null) {
				for(ProductoPromocion productopromocion:productopromocions) {
					this.deepLoad(productopromocion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(productopromocions);
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
			if(productopromocions!=null) {
				for(ProductoPromocion productopromocion:productopromocions) {
					this.deepLoad(productopromocion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(productopromocions);
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
			this.getNewConnexionToDeep(ProductoPromocion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productopromocion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoPromocion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productopromocions!=null) {
				for(ProductoPromocion productopromocion:productopromocions) {
					this.deepSave(productopromocion,isDeep,deepLoadType,clases);
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
			if(productopromocions!=null) {
				for(ProductoPromocion productopromocion:productopromocions) {
					this.deepSave(productopromocion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoPromocionsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoPromocionConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoPromocionsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoPromocionConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoPromocionsFK_IdBodegaRelacionWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_relacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_relacion,ProductoPromocionConstantesFunciones.IDBODEGARELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaRelacion);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoPromocionsFK_IdBodegaRelacion(String sFinalQuery,Pagination pagination,Long id_bodega_relacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_relacion,ProductoPromocionConstantesFunciones.IDBODEGARELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaRelacion);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoPromocionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoPromocionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoPromocionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProductoPromocionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoPromocionsFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoPromocionConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoPromocionsFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoPromocionConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoPromocionsFK_IdProductoRelacionWithConnection(String sFinalQuery,Pagination pagination,Long id_producto_relacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_relacion,ProductoPromocionConstantesFunciones.IDPRODUCTORELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoRelacion);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoPromocionsFK_IdProductoRelacion(String sFinalQuery,Pagination pagination,Long id_producto_relacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_relacion,ProductoPromocionConstantesFunciones.IDPRODUCTORELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoRelacion);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoPromocionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoPromocion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoPromocionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoPromocionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProductoPromocionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProductoPromocionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productopromocions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoPromocionConstantesFunciones.refrescarForeignKeysDescripcionesProductoPromocion(this.productopromocions);
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
			if(ProductoPromocionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoPromocionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoPromocion productopromocion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoPromocionConstantesFunciones.ISCONAUDITORIA) {
				if(productopromocion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoPromocionDataAccess.TABLENAME, productopromocion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoPromocionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoPromocionLogic.registrarAuditoriaDetallesProductoPromocion(connexion,productopromocion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productopromocion.getIsDeleted()) {
					/*if(!productopromocion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoPromocionDataAccess.TABLENAME, productopromocion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoPromocionLogic.registrarAuditoriaDetallesProductoPromocion(connexion,productopromocion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoPromocionDataAccess.TABLENAME, productopromocion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productopromocion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoPromocionDataAccess.TABLENAME, productopromocion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoPromocionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoPromocionLogic.registrarAuditoriaDetallesProductoPromocion(connexion,productopromocion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoPromocion(Connexion connexion,ProductoPromocion productopromocion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productopromocion.getIsNew()||!productopromocion.getid_empresa().equals(productopromocion.getProductoPromocionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getid_empresa()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getid_empresa().toString();
				}
				if(productopromocion.getid_empresa()!=null)
				{
					strValorNuevo=productopromocion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getid_sucursal().equals(productopromocion.getProductoPromocionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getid_sucursal()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getid_sucursal().toString();
				}
				if(productopromocion.getid_sucursal()!=null)
				{
					strValorNuevo=productopromocion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getid_bodega().equals(productopromocion.getProductoPromocionOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getid_bodega()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getid_bodega().toString();
				}
				if(productopromocion.getid_bodega()!=null)
				{
					strValorNuevo=productopromocion.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getid_producto().equals(productopromocion.getProductoPromocionOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getid_producto()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getid_producto().toString();
				}
				if(productopromocion.getid_producto()!=null)
				{
					strValorNuevo=productopromocion.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getid_bodega_relacion().equals(productopromocion.getProductoPromocionOriginal().getid_bodega_relacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getid_bodega_relacion()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getid_bodega_relacion().toString();
				}
				if(productopromocion.getid_bodega_relacion()!=null)
				{
					strValorNuevo=productopromocion.getid_bodega_relacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.IDBODEGARELACION,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getid_producto_relacion().equals(productopromocion.getProductoPromocionOriginal().getid_producto_relacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getid_producto_relacion()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getid_producto_relacion().toString();
				}
				if(productopromocion.getid_producto_relacion()!=null)
				{
					strValorNuevo=productopromocion.getid_producto_relacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.IDPRODUCTORELACION,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getcantidad().equals(productopromocion.getProductoPromocionOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getcantidad()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getcantidad().toString();
				}
				if(productopromocion.getcantidad()!=null)
				{
					strValorNuevo=productopromocion.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getprecio().equals(productopromocion.getProductoPromocionOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getprecio()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getprecio().toString();
				}
				if(productopromocion.getprecio()!=null)
				{
					strValorNuevo=productopromocion.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getporcentaje().equals(productopromocion.getProductoPromocionOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getporcentaje()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getporcentaje().toString();
				}
				if(productopromocion.getporcentaje()!=null)
				{
					strValorNuevo=productopromocion.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getdescripcion().equals(productopromocion.getProductoPromocionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getdescripcion()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getdescripcion();
				}
				if(productopromocion.getdescripcion()!=null)
				{
					strValorNuevo=productopromocion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(productopromocion.getIsNew()||!productopromocion.getdescripcion2().equals(productopromocion.getProductoPromocionOriginal().getdescripcion2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productopromocion.getProductoPromocionOriginal().getdescripcion2()!=null)
				{
					strValorActual=productopromocion.getProductoPromocionOriginal().getdescripcion2();
				}
				if(productopromocion.getdescripcion2()!=null)
				{
					strValorNuevo=productopromocion.getdescripcion2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoPromocionConstantesFunciones.DESCRIPCION2,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoPromocionRelacionesWithConnection(ProductoPromocion productopromocion) throws Exception {

		if(!productopromocion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoPromocionRelacionesBase(productopromocion,true);
		}
	}

	public void saveProductoPromocionRelaciones(ProductoPromocion productopromocion)throws Exception {

		if(!productopromocion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoPromocionRelacionesBase(productopromocion,false);
		}
	}

	public void saveProductoPromocionRelacionesBase(ProductoPromocion productopromocion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoPromocion-saveRelacionesWithConnection");}
	

			this.setProductoPromocion(productopromocion);

			if(ProductoPromocionLogicAdditional.validarSaveRelaciones(productopromocion,this)) {

				ProductoPromocionLogicAdditional.updateRelacionesToSave(productopromocion,this);

				if((productopromocion.getIsNew()||productopromocion.getIsChanged())&&!productopromocion.getIsDeleted()) {
					this.saveProductoPromocion();
					this.saveProductoPromocionRelacionesDetalles();

				} else if(productopromocion.getIsDeleted()) {
					this.saveProductoPromocionRelacionesDetalles();
					this.saveProductoPromocion();
				}

				ProductoPromocionLogicAdditional.updateRelacionesToSaveAfter(productopromocion,this);

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
	
	
	private void saveProductoPromocionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoPromocion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoPromocionConstantesFunciones.getClassesForeignKeysOfProductoPromocion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoPromocion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoPromocionConstantesFunciones.getClassesRelationshipsOfProductoPromocion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

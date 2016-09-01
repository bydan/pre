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
import com.bydan.erp.produccion.util.ProductoProduConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoProdu;
import com.bydan.erp.produccion.business.logic.ProductoProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoProduLogic.class);
	
	protected ProductoProduDataAccess productoproduDataAccess; 	
	protected ProductoProdu productoprodu;
	protected List<ProductoProdu> productoprodus;
	protected Object productoproduObject;	
	protected List<Object> productoprodusObject;
	
	public static ClassValidator<ProductoProdu> productoproduValidator = new ClassValidator<ProductoProdu>(ProductoProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoProduLogicAdditional productoproduLogicAdditional=null;
	
	public ProductoProduLogicAdditional getProductoProduLogicAdditional() {
		return this.productoproduLogicAdditional;
	}
	
	public void setProductoProduLogicAdditional(ProductoProduLogicAdditional productoproduLogicAdditional) {
		try {
			this.productoproduLogicAdditional=productoproduLogicAdditional;
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
	
	
	
	
	public  ProductoProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoproduDataAccess = new ProductoProduDataAccess();
			
			this.productoprodus= new ArrayList<ProductoProdu>();
			this.productoprodu= new ProductoProdu();
			
			this.productoproduObject=new Object();
			this.productoprodusObject=new ArrayList<Object>();
				
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
			
			this.productoproduDataAccess.setConnexionType(this.connexionType);
			this.productoproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoproduDataAccess = new ProductoProduDataAccess();
			this.productoprodus= new ArrayList<ProductoProdu>();
			this.productoprodu= new ProductoProdu();
			this.productoproduObject=new Object();
			this.productoprodusObject=new ArrayList<Object>();
			
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
			
			this.productoproduDataAccess.setConnexionType(this.connexionType);
			this.productoproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoProdu getProductoProdu() throws Exception {	
		ProductoProduLogicAdditional.checkProductoProduToGet(productoprodu,this.datosCliente,this.arrDatoGeneral);
		ProductoProduLogicAdditional.updateProductoProduToGet(productoprodu,this.arrDatoGeneral);
		
		return productoprodu;
	}
		
	public void setProductoProdu(ProductoProdu newProductoProdu) {
		this.productoprodu = newProductoProdu;
	}
	
	public ProductoProduDataAccess getProductoProduDataAccess() {
		return productoproduDataAccess;
	}
	
	public void setProductoProduDataAccess(ProductoProduDataAccess newproductoproduDataAccess) {
		this.productoproduDataAccess = newproductoproduDataAccess;
	}
	
	public List<ProductoProdu> getProductoProdus() throws Exception {		
		this.quitarProductoProdusNulos();
		
		ProductoProduLogicAdditional.checkProductoProduToGets(productoprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoProdu productoproduLocal: productoprodus ) {
			ProductoProduLogicAdditional.updateProductoProduToGet(productoproduLocal,this.arrDatoGeneral);
		}
		
		return productoprodus;
	}
	
	public void setProductoProdus(List<ProductoProdu> newProductoProdus) {
		this.productoprodus = newProductoProdus;
	}
	
	public Object getProductoProduObject() {	
		this.productoproduObject=this.productoproduDataAccess.getEntityObject();
		return this.productoproduObject;
	}
		
	public void setProductoProduObject(Object newProductoProduObject) {
		this.productoproduObject = newProductoProduObject;
	}
	
	public List<Object> getProductoProdusObject() {		
		this.productoprodusObject=this.productoproduDataAccess.getEntitiesObject();
		return this.productoprodusObject;
	}
		
	public void setProductoProdusObject(List<Object> newProductoProdusObject) {
		this.productoprodusObject = newProductoProdusObject;
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
		
		if(this.productoproduDataAccess!=null) {
			this.productoproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoprodu = new  ProductoProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodu=productoproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodu);
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
		productoprodu = new  ProductoProdu();
		  		  
        try {
			
			productoprodu=productoproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoprodu = new  ProductoProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodu=productoproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodu);
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
		productoprodu = new  ProductoProdu();
		  		  
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
		productoprodu = new  ProductoProdu();
		  		  
        try {
			
			productoprodu=productoproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoprodu = new  ProductoProdu();
		  		  
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
		productoprodu = new  ProductoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodu = new  ProductoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodu = new  ProductoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodu = new  ProductoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodu = new  ProductoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodu = new  ProductoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodus = new  ArrayList<ProductoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
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
		productoprodus = new  ArrayList<ProductoProdu>();
		  		  
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
		productoprodus = new  ArrayList<ProductoProdu>();
		  		  
        try {			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoprodus = new  ArrayList<ProductoProdu>();
		  		  
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
		productoprodus = new  ArrayList<ProductoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
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
		productoprodus = new  ArrayList<ProductoProdu>();
		  		  
        try {
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
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
		productoprodus = new  ArrayList<ProductoProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
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
		productoprodus = new  ArrayList<ProductoProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoprodu = new  ProductoProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodu=productoproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProdu(productoprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodu);
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
		productoprodu = new  ProductoProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodu=productoproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProdu(productoprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodus = new  ArrayList<ProductoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
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
		productoprodus = new  ArrayList<ProductoProdu>();
		  		  
        try {
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodus = new  ArrayList<ProductoProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getTodosProductoProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
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
	
	public  void  getTodosProductoProdus(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodus = new  ArrayList<ProductoProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProdu(productoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoProdu(ProductoProdu productoprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(productoprodu.getIsNew() || productoprodu.getIsChanged()) { 
			this.invalidValues = productoproduValidator.getInvalidValues(productoprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoProdu(List<ProductoProdu> ProductoProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoProdu productoproduLocal:productoprodus) {				
			estaValidadoObjeto=this.validarGuardarProductoProdu(productoproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoProdu(List<ProductoProdu> ProductoProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProdu(productoprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoProdu(ProductoProdu ProductoProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProdu(productoprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoProdu productoprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoProduConstantesFunciones.getProductoProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-saveProductoProduWithConnection");connexion.begin();			
			
			ProductoProduLogicAdditional.checkProductoProduToSave(this.productoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduLogicAdditional.updateProductoProduToSave(this.productoprodu,this.arrDatoGeneral);
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProdu(this.productoprodu)) {
				ProductoProduDataAccess.save(this.productoprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduLogicAdditional.checkProductoProduToSaveAfter(this.productoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProdu();
			
			connexion.commit();			
			
			if(this.productoprodu.getIsDeleted()) {
				this.productoprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoProdu()throws Exception {	
		try {	
			
			ProductoProduLogicAdditional.checkProductoProduToSave(this.productoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduLogicAdditional.updateProductoProduToSave(this.productoprodu,this.arrDatoGeneral);
			
			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProdu(this.productoprodu)) {			
				ProductoProduDataAccess.save(this.productoprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduLogicAdditional.checkProductoProduToSaveAfter(this.productoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoprodu.getIsDeleted()) {
				this.productoprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-saveProductoProdusWithConnection");connexion.begin();			
			
			ProductoProduLogicAdditional.checkProductoProduToSaves(productoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoProdus();
			
			Boolean validadoTodosProductoProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProdu productoproduLocal:productoprodus) {		
				if(productoproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduLogicAdditional.updateProductoProduToSave(productoproduLocal,this.arrDatoGeneral);
	        	
				ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProdu(productoproduLocal)) {
					ProductoProduDataAccess.save(productoproduLocal, connexion);				
				} else {
					validadoTodosProductoProdu=false;
				}
			}
			
			if(!validadoTodosProductoProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduLogicAdditional.checkProductoProduToSavesAfter(productoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProdus();
			
			connexion.commit();		
			
			this.quitarProductoProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoProdus()throws Exception {				
		 try {	
			ProductoProduLogicAdditional.checkProductoProduToSaves(productoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProdu productoproduLocal:productoprodus) {				
				if(productoproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduLogicAdditional.updateProductoProduToSave(productoproduLocal,this.arrDatoGeneral);
	        	
				ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProdu(productoproduLocal)) {				
					ProductoProduDataAccess.save(productoproduLocal, connexion);				
				} else {
					validadoTodosProductoProdu=false;
				}
			}
			
			if(!validadoTodosProductoProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduLogicAdditional.checkProductoProduToSavesAfter(productoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduParameterReturnGeneral procesarAccionProductoProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProdu> productoprodus,ProductoProduParameterReturnGeneral productoproduParameterGeneral)throws Exception {
		 try {	
			ProductoProduParameterReturnGeneral productoproduReturnGeneral=new ProductoProduParameterReturnGeneral();
	
			ProductoProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodus,productoproduParameterGeneral,productoproduReturnGeneral);
			
			return productoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduParameterReturnGeneral procesarAccionProductoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProdu> productoprodus,ProductoProduParameterReturnGeneral productoproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-procesarAccionProductoProdusWithConnection");connexion.begin();			
			
			ProductoProduParameterReturnGeneral productoproduReturnGeneral=new ProductoProduParameterReturnGeneral();
	
			ProductoProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodus,productoproduParameterGeneral,productoproduReturnGeneral);
			
			this.connexion.commit();
			
			return productoproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduParameterReturnGeneral procesarEventosProductoProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProdu> productoprodus,ProductoProdu productoprodu,ProductoProduParameterReturnGeneral productoproduParameterGeneral,Boolean isEsNuevoProductoProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoProduParameterReturnGeneral productoproduReturnGeneral=new ProductoProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodus,productoprodu,productoproduParameterGeneral,productoproduReturnGeneral,isEsNuevoProductoProdu,clases);
			
			return productoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoProduParameterReturnGeneral procesarEventosProductoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProdu> productoprodus,ProductoProdu productoprodu,ProductoProduParameterReturnGeneral productoproduParameterGeneral,Boolean isEsNuevoProductoProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-procesarEventosProductoProdusWithConnection");connexion.begin();			
			
			ProductoProduParameterReturnGeneral productoproduReturnGeneral=new ProductoProduParameterReturnGeneral();
	
			productoproduReturnGeneral.setProductoProdu(productoprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodus,productoprodu,productoproduParameterGeneral,productoproduReturnGeneral,isEsNuevoProductoProdu,clases);
			
			this.connexion.commit();
			
			return productoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduParameterReturnGeneral procesarImportacionProductoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoProduParameterReturnGeneral productoproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-procesarImportacionProductoProdusWithConnection");connexion.begin();			
			
			ProductoProduParameterReturnGeneral productoproduReturnGeneral=new ProductoProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoprodus=new ArrayList<ProductoProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoprodu=new ProductoProdu();
				
				
				if(conColumnasBase) {this.productoprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoprodu.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodu.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoprodu.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodu.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
			this.productoprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoprodus.add(this.productoprodu);
			}
			
			this.saveProductoProdus();
			
			this.connexion.commit();
			
			productoproduReturnGeneral.setConRetornoEstaProcesado(true);
			productoproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoProdusEliminados() throws Exception {				
		
		List<ProductoProdu> productoprodusAux= new ArrayList<ProductoProdu>();
		
		for(ProductoProdu productoprodu:productoprodus) {
			if(!productoprodu.getIsDeleted()) {
				productoprodusAux.add(productoprodu);
			}
		}
		
		productoprodus=productoprodusAux;
	}
	
	public void quitarProductoProdusNulos() throws Exception {				
		
		List<ProductoProdu> productoprodusAux= new ArrayList<ProductoProdu>();
		
		for(ProductoProdu productoprodu : this.productoprodus) {
			if(productoprodu==null) {
				productoprodusAux.add(productoprodu);
			}
		}
		
		//this.productoprodus=productoprodusAux;
		
		this.productoprodus.removeAll(productoprodusAux);
	}
	
	public void getSetVersionRowProductoProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoprodu.getIsDeleted() || (productoprodu.getIsChanged()&&!productoprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoproduDataAccess.getSetVersionRowProductoProdu(connexion,productoprodu.getId());
				
				if(!productoprodu.getVersionRow().equals(timestamp)) {	
					productoprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoProdu()throws Exception {	
		
		if(productoprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoprodu.getIsDeleted() || (productoprodu.getIsChanged()&&!productoprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoproduDataAccess.getSetVersionRowProductoProdu(connexion,productoprodu.getId());
			
			try {							
				if(!productoprodu.getVersionRow().equals(timestamp)) {	
					productoprodu.setVersionRow(timestamp);
				}
				
				productoprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoProdusWithConnection()throws Exception {	
		if(productoprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoProdu productoproduAux:productoprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoproduAux.getIsDeleted() || (productoproduAux.getIsChanged()&&!productoproduAux.getIsNew())) {
						
						timestamp=productoproduDataAccess.getSetVersionRowProductoProdu(connexion,productoproduAux.getId());
						
						if(!productoprodu.getVersionRow().equals(timestamp)) {	
							productoproduAux.setVersionRow(timestamp);
						}
								
						productoproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoProdus()throws Exception {	
		if(productoprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoProdu productoproduAux:productoprodus) {
					if(productoproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoproduAux.getIsDeleted() || (productoproduAux.getIsChanged()&&!productoproduAux.getIsNew())) {
						
						timestamp=productoproduDataAccess.getSetVersionRowProductoProdu(connexion,productoproduAux.getId());
						
						if(!productoproduAux.getVersionRow().equals(timestamp)) {	
							productoproduAux.setVersionRow(timestamp);
						}
						
													
						productoproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoProduParameterReturnGeneral cargarCombosLoteForeignKeyProductoProduWithConnection(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduParameterReturnGeneral  productoproduReturnGeneral =new ProductoProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoProduWithConnection");connexion.begin();
			
			productoproduReturnGeneral =new ProductoProduParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoproduReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoproduReturnGeneral;
	}
	
	public ProductoProduParameterReturnGeneral cargarCombosLoteForeignKeyProductoProdu(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduParameterReturnGeneral  productoproduReturnGeneral =new ProductoProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoproduReturnGeneral =new ProductoProduParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoproduReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			productoproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			productoproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoproduReturnGeneral;
	}
	
	
	public void deepLoad(ProductoProdu productoprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoProduLogicAdditional.updateProductoProduToGet(productoprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodu.setProductoDefiProdu(productoproduDataAccess.getProductoDefiProdu(connexion,productoprodu));
		productoprodu.setBodega(productoproduDataAccess.getBodega(connexion,productoprodu));
		productoprodu.setProducto(productoproduDataAccess.getProducto(connexion,productoprodu));
		productoprodu.setUnidad(productoproduDataAccess.getUnidad(connexion,productoprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodu.setProductoDefiProdu(productoproduDataAccess.getProductoDefiProdu(connexion,productoprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoprodu.setBodega(productoproduDataAccess.getBodega(connexion,productoprodu));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoprodu.setProducto(productoproduDataAccess.getProducto(connexion,productoprodu));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodu.setUnidad(productoproduDataAccess.getUnidad(connexion,productoprodu));
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
			productoprodu.setProductoDefiProdu(productoproduDataAccess.getProductoDefiProdu(connexion,productoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodu.setBodega(productoproduDataAccess.getBodega(connexion,productoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodu.setProducto(productoproduDataAccess.getProducto(connexion,productoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodu.setUnidad(productoproduDataAccess.getUnidad(connexion,productoprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodu.setProductoDefiProdu(productoproduDataAccess.getProductoDefiProdu(connexion,productoprodu));
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodu.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		productoprodu.setBodega(productoproduDataAccess.getBodega(connexion,productoprodu));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoprodu.getBodega(),isDeep,deepLoadType,clases);
				
		productoprodu.setProducto(productoproduDataAccess.getProducto(connexion,productoprodu));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoprodu.getProducto(),isDeep,deepLoadType,clases);
				
		productoprodu.setUnidad(productoproduDataAccess.getUnidad(connexion,productoprodu));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodu.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodu.setProductoDefiProdu(productoproduDataAccess.getProductoDefiProdu(connexion,productoprodu));
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepLoad(productoprodu.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				productoprodu.setBodega(productoproduDataAccess.getBodega(connexion,productoprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(productoprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				productoprodu.setProducto(productoproduDataAccess.getProducto(connexion,productoprodu));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(productoprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodu.setUnidad(productoproduDataAccess.getUnidad(connexion,productoprodu));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoprodu.getUnidad(),isDeep,deepLoadType,clases);				
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
			productoprodu.setProductoDefiProdu(productoproduDataAccess.getProductoDefiProdu(connexion,productoprodu));
			ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
			productodefiproduLogic.deepLoad(productoprodu.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodu.setBodega(productoproduDataAccess.getBodega(connexion,productoprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(productoprodu.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodu.setProducto(productoproduDataAccess.getProducto(connexion,productoprodu));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(productoprodu.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodu.setUnidad(productoproduDataAccess.getUnidad(connexion,productoprodu));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoprodu.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoProdu productoprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoProduLogicAdditional.updateProductoProduToSave(productoprodu,this.arrDatoGeneral);
			
ProductoProduDataAccess.save(productoprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodu.getProductoDefiProdu(),connexion);

		BodegaDataAccess.save(productoprodu.getBodega(),connexion);

		ProductoDataAccess.save(productoprodu.getProducto(),connexion);

		UnidadDataAccess.save(productoprodu.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodu.getProductoDefiProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoprodu.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoprodu.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodu.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodu.getProductoDefiProdu(),connexion);
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodu.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(productoprodu.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(productoprodu.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(productoprodu.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(productoprodu.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoprodu.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodu.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodu.getProductoDefiProdu(),connexion);
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepSave(productoprodu.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(productoprodu.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(productoprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(productoprodu.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(productoprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodu.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoprodu.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(productoprodu);
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
			this.deepLoad(this.productoprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoprodus!=null) {
				for(ProductoProdu productoprodu:productoprodus) {
					this.deepLoad(productoprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(productoprodus);
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
			if(productoprodus!=null) {
				for(ProductoProdu productoprodu:productoprodus) {
					this.deepLoad(productoprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(productoprodus);
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
			this.getNewConnexionToDeep(ProductoProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoprodus!=null) {
				for(ProductoProdu productoprodu:productoprodus) {
					this.deepSave(productoprodu,isDeep,deepLoadType,clases);
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
			if(productoprodus!=null) {
				for(ProductoProdu productoprodu:productoprodus) {
					this.deepSave(productoprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoProdusFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProdusFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ProductoProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProdusFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProdusFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,ProductoProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProdusFK_IdProductoDefiProduWithConnection(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProdusFK_IdProductoDefiProdu(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProdusFK_IdUnidadUnadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadUnad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProdusFK_IdUnidadUnad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadUnad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoProdu(this.productoprodus);
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
			if(ProductoProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoProdu productoprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoProduConstantesFunciones.ISCONAUDITORIA) {
				if(productoprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduDataAccess.TABLENAME, productoprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduLogic.registrarAuditoriaDetallesProductoProdu(connexion,productoprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoprodu.getIsDeleted()) {
					/*if(!productoprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoProduDataAccess.TABLENAME, productoprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoProduLogic.registrarAuditoriaDetallesProductoProdu(connexion,productoprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduDataAccess.TABLENAME, productoprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduDataAccess.TABLENAME, productoprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduLogic.registrarAuditoriaDetallesProductoProdu(connexion,productoprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoProdu(Connexion connexion,ProductoProdu productoprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoprodu.getIsNew()||!productoprodu.getid_producto_defi_produ().equals(productoprodu.getProductoProduOriginal().getid_producto_defi_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodu.getProductoProduOriginal().getid_producto_defi_produ()!=null)
				{
					strValorActual=productoprodu.getProductoProduOriginal().getid_producto_defi_produ().toString();
				}
				if(productoprodu.getid_producto_defi_produ()!=null)
				{
					strValorNuevo=productoprodu.getid_producto_defi_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoprodu.getIsNew()||!productoprodu.getid_bodega().equals(productoprodu.getProductoProduOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodu.getProductoProduOriginal().getid_bodega()!=null)
				{
					strValorActual=productoprodu.getProductoProduOriginal().getid_bodega().toString();
				}
				if(productoprodu.getid_bodega()!=null)
				{
					strValorNuevo=productoprodu.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(productoprodu.getIsNew()||!productoprodu.getid_producto().equals(productoprodu.getProductoProduOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodu.getProductoProduOriginal().getid_producto()!=null)
				{
					strValorActual=productoprodu.getProductoProduOriginal().getid_producto().toString();
				}
				if(productoprodu.getid_producto()!=null)
				{
					strValorNuevo=productoprodu.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(productoprodu.getIsNew()||!productoprodu.getid_unidad().equals(productoprodu.getProductoProduOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodu.getProductoProduOriginal().getid_unidad()!=null)
				{
					strValorActual=productoprodu.getProductoProduOriginal().getid_unidad().toString();
				}
				if(productoprodu.getid_unidad()!=null)
				{
					strValorNuevo=productoprodu.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodu.getIsNew()||!productoprodu.getporcentaje().equals(productoprodu.getProductoProduOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodu.getProductoProduOriginal().getporcentaje()!=null)
				{
					strValorActual=productoprodu.getProductoProduOriginal().getporcentaje().toString();
				}
				if(productoprodu.getporcentaje()!=null)
				{
					strValorNuevo=productoprodu.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(productoprodu.getIsNew()||!productoprodu.getcantidad().equals(productoprodu.getProductoProduOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodu.getProductoProduOriginal().getcantidad()!=null)
				{
					strValorActual=productoprodu.getProductoProduOriginal().getcantidad().toString();
				}
				if(productoprodu.getcantidad()!=null)
				{
					strValorNuevo=productoprodu.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodu.getIsNew()||!productoprodu.getcosto().equals(productoprodu.getProductoProduOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodu.getProductoProduOriginal().getcosto()!=null)
				{
					strValorActual=productoprodu.getProductoProduOriginal().getcosto().toString();
				}
				if(productoprodu.getcosto()!=null)
				{
					strValorNuevo=productoprodu.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoprodu.getIsNew()||!productoprodu.getcosto_total().equals(productoprodu.getProductoProduOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodu.getProductoProduOriginal().getcosto_total()!=null)
				{
					strValorActual=productoprodu.getProductoProduOriginal().getcosto_total().toString();
				}
				if(productoprodu.getcosto_total()!=null)
				{
					strValorNuevo=productoprodu.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoprodu.getIsNew()||!productoprodu.getdescripcion().equals(productoprodu.getProductoProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodu.getProductoProduOriginal().getdescripcion()!=null)
				{
					strValorActual=productoprodu.getProductoProduOriginal().getdescripcion();
				}
				if(productoprodu.getdescripcion()!=null)
				{
					strValorNuevo=productoprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoProduRelacionesWithConnection(ProductoProdu productoprodu) throws Exception {

		if(!productoprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduRelacionesBase(productoprodu,true);
		}
	}

	public void saveProductoProduRelaciones(ProductoProdu productoprodu)throws Exception {

		if(!productoprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduRelacionesBase(productoprodu,false);
		}
	}

	public void saveProductoProduRelacionesBase(ProductoProdu productoprodu,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoProdu-saveRelacionesWithConnection");}
	

			this.setProductoProdu(productoprodu);

			if(ProductoProduLogicAdditional.validarSaveRelaciones(productoprodu,this)) {

				ProductoProduLogicAdditional.updateRelacionesToSave(productoprodu,this);

				if((productoprodu.getIsNew()||productoprodu.getIsChanged())&&!productoprodu.getIsDeleted()) {
					this.saveProductoProdu();
					this.saveProductoProduRelacionesDetalles();

				} else if(productoprodu.getIsDeleted()) {
					this.saveProductoProduRelacionesDetalles();
					this.saveProductoProdu();
				}

				ProductoProduLogicAdditional.updateRelacionesToSaveAfter(productoprodu,this);

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
	
	
	private void saveProductoProduRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduConstantesFunciones.getClassesForeignKeysOfProductoProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduConstantesFunciones.getClassesRelationshipsOfProductoProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

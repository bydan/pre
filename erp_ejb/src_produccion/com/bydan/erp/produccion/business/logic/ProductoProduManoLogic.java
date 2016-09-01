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
import com.bydan.erp.produccion.util.ProductoProduManoConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduManoParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduManoParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoProduMano;
import com.bydan.erp.produccion.business.logic.ProductoProduManoLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoProduManoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoProduManoLogic.class);
	
	protected ProductoProduManoDataAccess productoprodumanoDataAccess; 	
	protected ProductoProduMano productoprodumano;
	protected List<ProductoProduMano> productoprodumanos;
	protected Object productoprodumanoObject;	
	protected List<Object> productoprodumanosObject;
	
	public static ClassValidator<ProductoProduMano> productoprodumanoValidator = new ClassValidator<ProductoProduMano>(ProductoProduMano.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoProduManoLogicAdditional productoprodumanoLogicAdditional=null;
	
	public ProductoProduManoLogicAdditional getProductoProduManoLogicAdditional() {
		return this.productoprodumanoLogicAdditional;
	}
	
	public void setProductoProduManoLogicAdditional(ProductoProduManoLogicAdditional productoprodumanoLogicAdditional) {
		try {
			this.productoprodumanoLogicAdditional=productoprodumanoLogicAdditional;
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
	
	
	
	
	public  ProductoProduManoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoprodumanoDataAccess = new ProductoProduManoDataAccess();
			
			this.productoprodumanos= new ArrayList<ProductoProduMano>();
			this.productoprodumano= new ProductoProduMano();
			
			this.productoprodumanoObject=new Object();
			this.productoprodumanosObject=new ArrayList<Object>();
				
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
			
			this.productoprodumanoDataAccess.setConnexionType(this.connexionType);
			this.productoprodumanoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoProduManoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoprodumanoDataAccess = new ProductoProduManoDataAccess();
			this.productoprodumanos= new ArrayList<ProductoProduMano>();
			this.productoprodumano= new ProductoProduMano();
			this.productoprodumanoObject=new Object();
			this.productoprodumanosObject=new ArrayList<Object>();
			
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
			
			this.productoprodumanoDataAccess.setConnexionType(this.connexionType);
			this.productoprodumanoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoProduMano getProductoProduMano() throws Exception {	
		ProductoProduManoLogicAdditional.checkProductoProduManoToGet(productoprodumano,this.datosCliente,this.arrDatoGeneral);
		ProductoProduManoLogicAdditional.updateProductoProduManoToGet(productoprodumano,this.arrDatoGeneral);
		
		return productoprodumano;
	}
		
	public void setProductoProduMano(ProductoProduMano newProductoProduMano) {
		this.productoprodumano = newProductoProduMano;
	}
	
	public ProductoProduManoDataAccess getProductoProduManoDataAccess() {
		return productoprodumanoDataAccess;
	}
	
	public void setProductoProduManoDataAccess(ProductoProduManoDataAccess newproductoprodumanoDataAccess) {
		this.productoprodumanoDataAccess = newproductoprodumanoDataAccess;
	}
	
	public List<ProductoProduMano> getProductoProduManos() throws Exception {		
		this.quitarProductoProduManosNulos();
		
		ProductoProduManoLogicAdditional.checkProductoProduManoToGets(productoprodumanos,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoProduMano productoprodumanoLocal: productoprodumanos ) {
			ProductoProduManoLogicAdditional.updateProductoProduManoToGet(productoprodumanoLocal,this.arrDatoGeneral);
		}
		
		return productoprodumanos;
	}
	
	public void setProductoProduManos(List<ProductoProduMano> newProductoProduManos) {
		this.productoprodumanos = newProductoProduManos;
	}
	
	public Object getProductoProduManoObject() {	
		this.productoprodumanoObject=this.productoprodumanoDataAccess.getEntityObject();
		return this.productoprodumanoObject;
	}
		
	public void setProductoProduManoObject(Object newProductoProduManoObject) {
		this.productoprodumanoObject = newProductoProduManoObject;
	}
	
	public List<Object> getProductoProduManosObject() {		
		this.productoprodumanosObject=this.productoprodumanoDataAccess.getEntitiesObject();
		return this.productoprodumanosObject;
	}
		
	public void setProductoProduManosObject(List<Object> newProductoProduManosObject) {
		this.productoprodumanosObject = newProductoProduManosObject;
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
		
		if(this.productoprodumanoDataAccess!=null) {
			this.productoprodumanoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoprodumanoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoprodumanoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoprodumano = new  ProductoProduMano();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodumano=productoprodumanoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumano);
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
		productoprodumano = new  ProductoProduMano();
		  		  
        try {
			
			productoprodumano=productoprodumanoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumano);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoprodumano = new  ProductoProduMano();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodumano=productoprodumanoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumano);
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
		productoprodumano = new  ProductoProduMano();
		  		  
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
		productoprodumano = new  ProductoProduMano();
		  		  
        try {
			
			productoprodumano=productoprodumanoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumano);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoprodumano = new  ProductoProduMano();
		  		  
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
		productoprodumano = new  ProductoProduMano();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoprodumanoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodumano = new  ProductoProduMano();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoprodumanoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodumano = new  ProductoProduMano();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoprodumanoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodumano = new  ProductoProduMano();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoprodumanoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodumano = new  ProductoProduMano();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoprodumanoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodumano = new  ProductoProduMano();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoprodumanoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
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
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		  		  
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
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		  		  
        try {			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		  		  
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
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
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
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		  		  
        try {
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
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
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
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
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoprodumano = new  ProductoProduMano();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumano=productoprodumanoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMano(productoprodumano);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumano);
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
		productoprodumano = new  ProductoProduMano();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumano=productoprodumanoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMano(productoprodumano);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumano);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
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
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		  		  
        try {
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoProduManosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getTodosProductoProduManosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
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
	
	public  void  getTodosProductoProduManos(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodumanos = new  ArrayList<ProductoProduMano>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProduMano(productoprodumanos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoProduMano(ProductoProduMano productoprodumano) throws Exception {
		Boolean estaValidado=false;
		
		if(productoprodumano.getIsNew() || productoprodumano.getIsChanged()) { 
			this.invalidValues = productoprodumanoValidator.getInvalidValues(productoprodumano);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoprodumano);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoProduMano(List<ProductoProduMano> ProductoProduManos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoProduMano productoprodumanoLocal:productoprodumanos) {				
			estaValidadoObjeto=this.validarGuardarProductoProduMano(productoprodumanoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoProduMano(List<ProductoProduMano> ProductoProduManos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProduMano(productoprodumanos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoProduMano(ProductoProduMano ProductoProduMano) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProduMano(productoprodumano)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoProduMano productoprodumano) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoprodumano.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoProduManoConstantesFunciones.getProductoProduManoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoprodumano","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoProduManoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoProduManoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoProduManoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-saveProductoProduManoWithConnection");connexion.begin();			
			
			ProductoProduManoLogicAdditional.checkProductoProduManoToSave(this.productoprodumano,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduManoLogicAdditional.updateProductoProduManoToSave(this.productoprodumano,this.arrDatoGeneral);
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodumano,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoProduMano();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProduMano(this.productoprodumano)) {
				ProductoProduManoDataAccess.save(this.productoprodumano, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduManoLogicAdditional.checkProductoProduManoToSaveAfter(this.productoprodumano,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProduMano();
			
			connexion.commit();			
			
			if(this.productoprodumano.getIsDeleted()) {
				this.productoprodumano=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoProduMano()throws Exception {	
		try {	
			
			ProductoProduManoLogicAdditional.checkProductoProduManoToSave(this.productoprodumano,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduManoLogicAdditional.updateProductoProduManoToSave(this.productoprodumano,this.arrDatoGeneral);
			
			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodumano,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProduMano(this.productoprodumano)) {			
				ProductoProduManoDataAccess.save(this.productoprodumano, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoprodumano,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduManoLogicAdditional.checkProductoProduManoToSaveAfter(this.productoprodumano,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoprodumano.getIsDeleted()) {
				this.productoprodumano=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoProduManosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-saveProductoProduManosWithConnection");connexion.begin();			
			
			ProductoProduManoLogicAdditional.checkProductoProduManoToSaves(productoprodumanos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoProduManos();
			
			Boolean validadoTodosProductoProduMano=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProduMano productoprodumanoLocal:productoprodumanos) {		
				if(productoprodumanoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduManoLogicAdditional.updateProductoProduManoToSave(productoprodumanoLocal,this.arrDatoGeneral);
	        	
				ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoprodumanoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProduMano(productoprodumanoLocal)) {
					ProductoProduManoDataAccess.save(productoprodumanoLocal, connexion);				
				} else {
					validadoTodosProductoProduMano=false;
				}
			}
			
			if(!validadoTodosProductoProduMano) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduManoLogicAdditional.checkProductoProduManoToSavesAfter(productoprodumanos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProduManos();
			
			connexion.commit();		
			
			this.quitarProductoProduManosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoProduManos()throws Exception {				
		 try {	
			ProductoProduManoLogicAdditional.checkProductoProduManoToSaves(productoprodumanos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoProduMano=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProduMano productoprodumanoLocal:productoprodumanos) {				
				if(productoprodumanoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduManoLogicAdditional.updateProductoProduManoToSave(productoprodumanoLocal,this.arrDatoGeneral);
	        	
				ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoprodumanoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProduMano(productoprodumanoLocal)) {				
					ProductoProduManoDataAccess.save(productoprodumanoLocal, connexion);				
				} else {
					validadoTodosProductoProduMano=false;
				}
			}
			
			if(!validadoTodosProductoProduMano) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduManoLogicAdditional.checkProductoProduManoToSavesAfter(productoprodumanos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoProduManosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduManoParameterReturnGeneral procesarAccionProductoProduManos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProduMano> productoprodumanos,ProductoProduManoParameterReturnGeneral productoprodumanoParameterGeneral)throws Exception {
		 try {	
			ProductoProduManoParameterReturnGeneral productoprodumanoReturnGeneral=new ProductoProduManoParameterReturnGeneral();
	
			ProductoProduManoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodumanos,productoprodumanoParameterGeneral,productoprodumanoReturnGeneral);
			
			return productoprodumanoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduManoParameterReturnGeneral procesarAccionProductoProduManosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProduMano> productoprodumanos,ProductoProduManoParameterReturnGeneral productoprodumanoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-procesarAccionProductoProduManosWithConnection");connexion.begin();			
			
			ProductoProduManoParameterReturnGeneral productoprodumanoReturnGeneral=new ProductoProduManoParameterReturnGeneral();
	
			ProductoProduManoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodumanos,productoprodumanoParameterGeneral,productoprodumanoReturnGeneral);
			
			this.connexion.commit();
			
			return productoprodumanoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduManoParameterReturnGeneral procesarEventosProductoProduManos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProduMano> productoprodumanos,ProductoProduMano productoprodumano,ProductoProduManoParameterReturnGeneral productoprodumanoParameterGeneral,Boolean isEsNuevoProductoProduMano,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoProduManoParameterReturnGeneral productoprodumanoReturnGeneral=new ProductoProduManoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoprodumanoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduManoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodumanos,productoprodumano,productoprodumanoParameterGeneral,productoprodumanoReturnGeneral,isEsNuevoProductoProduMano,clases);
			
			return productoprodumanoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoProduManoParameterReturnGeneral procesarEventosProductoProduManosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProduMano> productoprodumanos,ProductoProduMano productoprodumano,ProductoProduManoParameterReturnGeneral productoprodumanoParameterGeneral,Boolean isEsNuevoProductoProduMano,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-procesarEventosProductoProduManosWithConnection");connexion.begin();			
			
			ProductoProduManoParameterReturnGeneral productoprodumanoReturnGeneral=new ProductoProduManoParameterReturnGeneral();
	
			productoprodumanoReturnGeneral.setProductoProduMano(productoprodumano);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoprodumanoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduManoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodumanos,productoprodumano,productoprodumanoParameterGeneral,productoprodumanoReturnGeneral,isEsNuevoProductoProduMano,clases);
			
			this.connexion.commit();
			
			return productoprodumanoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduManoParameterReturnGeneral procesarImportacionProductoProduManosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoProduManoParameterReturnGeneral productoprodumanoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-procesarImportacionProductoProduManosWithConnection");connexion.begin();			
			
			ProductoProduManoParameterReturnGeneral productoprodumanoReturnGeneral=new ProductoProduManoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoprodumanos=new ArrayList<ProductoProduMano>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoprodumano=new ProductoProduMano();
				
				
				if(conColumnasBase) {this.productoprodumano.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoprodumano.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoprodumano.setcantidad(Long.parseLong(arrColumnas[iColumn++]));
				this.productoprodumano.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodumano.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodumano.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoprodumanos.add(this.productoprodumano);
			}
			
			this.saveProductoProduManos();
			
			this.connexion.commit();
			
			productoprodumanoReturnGeneral.setConRetornoEstaProcesado(true);
			productoprodumanoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoprodumanoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoProduManosEliminados() throws Exception {				
		
		List<ProductoProduMano> productoprodumanosAux= new ArrayList<ProductoProduMano>();
		
		for(ProductoProduMano productoprodumano:productoprodumanos) {
			if(!productoprodumano.getIsDeleted()) {
				productoprodumanosAux.add(productoprodumano);
			}
		}
		
		productoprodumanos=productoprodumanosAux;
	}
	
	public void quitarProductoProduManosNulos() throws Exception {				
		
		List<ProductoProduMano> productoprodumanosAux= new ArrayList<ProductoProduMano>();
		
		for(ProductoProduMano productoprodumano : this.productoprodumanos) {
			if(productoprodumano==null) {
				productoprodumanosAux.add(productoprodumano);
			}
		}
		
		//this.productoprodumanos=productoprodumanosAux;
		
		this.productoprodumanos.removeAll(productoprodumanosAux);
	}
	
	public void getSetVersionRowProductoProduManoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoprodumano.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoprodumano.getIsDeleted() || (productoprodumano.getIsChanged()&&!productoprodumano.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoprodumanoDataAccess.getSetVersionRowProductoProduMano(connexion,productoprodumano.getId());
				
				if(!productoprodumano.getVersionRow().equals(timestamp)) {	
					productoprodumano.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoprodumano.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoProduMano()throws Exception {	
		
		if(productoprodumano.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoprodumano.getIsDeleted() || (productoprodumano.getIsChanged()&&!productoprodumano.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoprodumanoDataAccess.getSetVersionRowProductoProduMano(connexion,productoprodumano.getId());
			
			try {							
				if(!productoprodumano.getVersionRow().equals(timestamp)) {	
					productoprodumano.setVersionRow(timestamp);
				}
				
				productoprodumano.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoProduManosWithConnection()throws Exception {	
		if(productoprodumanos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoProduMano productoprodumanoAux:productoprodumanos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoprodumanoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoprodumanoAux.getIsDeleted() || (productoprodumanoAux.getIsChanged()&&!productoprodumanoAux.getIsNew())) {
						
						timestamp=productoprodumanoDataAccess.getSetVersionRowProductoProduMano(connexion,productoprodumanoAux.getId());
						
						if(!productoprodumano.getVersionRow().equals(timestamp)) {	
							productoprodumanoAux.setVersionRow(timestamp);
						}
								
						productoprodumanoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoProduManos()throws Exception {	
		if(productoprodumanos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoProduMano productoprodumanoAux:productoprodumanos) {
					if(productoprodumanoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoprodumanoAux.getIsDeleted() || (productoprodumanoAux.getIsChanged()&&!productoprodumanoAux.getIsNew())) {
						
						timestamp=productoprodumanoDataAccess.getSetVersionRowProductoProduMano(connexion,productoprodumanoAux.getId());
						
						if(!productoprodumanoAux.getVersionRow().equals(timestamp)) {	
							productoprodumanoAux.setVersionRow(timestamp);
						}
						
													
						productoprodumanoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoProduManoParameterReturnGeneral cargarCombosLoteForeignKeyProductoProduManoWithConnection(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalTipoManoProduEmpresa,String finalQueryGlobalTipoProcesoEmpresaProdu,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduManoParameterReturnGeneral  productoprodumanoReturnGeneral =new ProductoProduManoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoProduManoWithConnection");connexion.begin();
			
			productoprodumanoReturnGeneral =new ProductoProduManoParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoprodumanoReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<TipoManoProduEmpresa> tipomanoproduempresasForeignKey=new ArrayList<TipoManoProduEmpresa>();
			TipoManoProduEmpresaLogic tipomanoproduempresaLogic=new TipoManoProduEmpresaLogic();
			tipomanoproduempresaLogic.setConnexion(this.connexion);
			tipomanoproduempresaLogic.getTipoManoProduEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoManoProduEmpresa.equals("NONE")) {
				tipomanoproduempresaLogic.getTodosTipoManoProduEmpresas(finalQueryGlobalTipoManoProduEmpresa,new Pagination());
				tipomanoproduempresasForeignKey=tipomanoproduempresaLogic.getTipoManoProduEmpresas();
			}

			productoprodumanoReturnGeneral.settipomanoproduempresasForeignKey(tipomanoproduempresasForeignKey);


			List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic=new TipoProcesoEmpresaProduLogic();
			tipoprocesoempresaproduLogic.setConnexion(this.connexion);
			tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoEmpresaProdu.equals("NONE")) {
				tipoprocesoempresaproduLogic.getTodosTipoProcesoEmpresaProdus(finalQueryGlobalTipoProcesoEmpresaProdu,new Pagination());
				tipoprocesoempresaprodusForeignKey=tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProdus();
			}

			productoprodumanoReturnGeneral.settipoprocesoempresaprodusForeignKey(tipoprocesoempresaprodusForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoprodumanoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoprodumanoReturnGeneral;
	}
	
	public ProductoProduManoParameterReturnGeneral cargarCombosLoteForeignKeyProductoProduMano(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalTipoManoProduEmpresa,String finalQueryGlobalTipoProcesoEmpresaProdu,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduManoParameterReturnGeneral  productoprodumanoReturnGeneral =new ProductoProduManoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoprodumanoReturnGeneral =new ProductoProduManoParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoprodumanoReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<TipoManoProduEmpresa> tipomanoproduempresasForeignKey=new ArrayList<TipoManoProduEmpresa>();
			TipoManoProduEmpresaLogic tipomanoproduempresaLogic=new TipoManoProduEmpresaLogic();
			tipomanoproduempresaLogic.setConnexion(this.connexion);
			tipomanoproduempresaLogic.getTipoManoProduEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoManoProduEmpresa.equals("NONE")) {
				tipomanoproduempresaLogic.getTodosTipoManoProduEmpresas(finalQueryGlobalTipoManoProduEmpresa,new Pagination());
				tipomanoproduempresasForeignKey=tipomanoproduempresaLogic.getTipoManoProduEmpresas();
			}

			productoprodumanoReturnGeneral.settipomanoproduempresasForeignKey(tipomanoproduempresasForeignKey);


			List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic=new TipoProcesoEmpresaProduLogic();
			tipoprocesoempresaproduLogic.setConnexion(this.connexion);
			tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoEmpresaProdu.equals("NONE")) {
				tipoprocesoempresaproduLogic.getTodosTipoProcesoEmpresaProdus(finalQueryGlobalTipoProcesoEmpresaProdu,new Pagination());
				tipoprocesoempresaprodusForeignKey=tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProdus();
			}

			productoprodumanoReturnGeneral.settipoprocesoempresaprodusForeignKey(tipoprocesoempresaprodusForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoprodumanoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoprodumanoReturnGeneral;
	}
	
	
	public void deepLoad(ProductoProduMano productoprodumano,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoProduManoLogicAdditional.updateProductoProduManoToGet(productoprodumano,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodumano.setProductoDefiProdu(productoprodumanoDataAccess.getProductoDefiProdu(connexion,productoprodumano));
		productoprodumano.setTipoManoProduEmpresa(productoprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoprodumano));
		productoprodumano.setTipoProcesoEmpresaProdu(productoprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumano));
		productoprodumano.setUnidad(productoprodumanoDataAccess.getUnidad(connexion,productoprodumano));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodumano.setProductoDefiProdu(productoprodumanoDataAccess.getProductoDefiProdu(connexion,productoprodumano));
				continue;
			}

			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				productoprodumano.setTipoManoProduEmpresa(productoprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoprodumano));
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				productoprodumano.setTipoProcesoEmpresaProdu(productoprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumano));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodumano.setUnidad(productoprodumanoDataAccess.getUnidad(connexion,productoprodumano));
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
			productoprodumano.setProductoDefiProdu(productoprodumanoDataAccess.getProductoDefiProdu(connexion,productoprodumano));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumano.setTipoManoProduEmpresa(productoprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoprodumano));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumano.setTipoProcesoEmpresaProdu(productoprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumano));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumano.setUnidad(productoprodumanoDataAccess.getUnidad(connexion,productoprodumano));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodumano.setProductoDefiProdu(productoprodumanoDataAccess.getProductoDefiProdu(connexion,productoprodumano));
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodumano.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		productoprodumano.setTipoManoProduEmpresa(productoprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoprodumano));
		TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
		tipomanoproduempresaLogic.deepLoad(productoprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);
				
		productoprodumano.setTipoProcesoEmpresaProdu(productoprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumano));
		TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
		tipoprocesoempresaproduLogic.deepLoad(productoprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				
		productoprodumano.setUnidad(productoprodumanoDataAccess.getUnidad(connexion,productoprodumano));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodumano.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodumano.setProductoDefiProdu(productoprodumanoDataAccess.getProductoDefiProdu(connexion,productoprodumano));
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepLoad(productoprodumano.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				productoprodumano.setTipoManoProduEmpresa(productoprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoprodumano));
				TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
				tipomanoproduempresaLogic.deepLoad(productoprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				productoprodumano.setTipoProcesoEmpresaProdu(productoprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumano));
				TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
				tipoprocesoempresaproduLogic.deepLoad(productoprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodumano.setUnidad(productoprodumanoDataAccess.getUnidad(connexion,productoprodumano));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoprodumano.getUnidad(),isDeep,deepLoadType,clases);				
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
			productoprodumano.setProductoDefiProdu(productoprodumanoDataAccess.getProductoDefiProdu(connexion,productoprodumano));
			ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
			productodefiproduLogic.deepLoad(productoprodumano.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumano.setTipoManoProduEmpresa(productoprodumanoDataAccess.getTipoManoProduEmpresa(connexion,productoprodumano));
			TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
			tipomanoproduempresaLogic.deepLoad(productoprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumano.setTipoProcesoEmpresaProdu(productoprodumanoDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumano));
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
			tipoprocesoempresaproduLogic.deepLoad(productoprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumano.setUnidad(productoprodumanoDataAccess.getUnidad(connexion,productoprodumano));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoprodumano.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoProduMano productoprodumano,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoProduManoLogicAdditional.updateProductoProduManoToSave(productoprodumano,this.arrDatoGeneral);
			
ProductoProduManoDataAccess.save(productoprodumano, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodumano.getProductoDefiProdu(),connexion);

		TipoManoProduEmpresaDataAccess.save(productoprodumano.getTipoManoProduEmpresa(),connexion);

		TipoProcesoEmpresaProduDataAccess.save(productoprodumano.getTipoProcesoEmpresaProdu(),connexion);

		UnidadDataAccess.save(productoprodumano.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodumano.getProductoDefiProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				TipoManoProduEmpresaDataAccess.save(productoprodumano.getTipoManoProduEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				TipoProcesoEmpresaProduDataAccess.save(productoprodumano.getTipoProcesoEmpresaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodumano.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodumano.getProductoDefiProdu(),connexion);
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodumano.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				

		TipoManoProduEmpresaDataAccess.save(productoprodumano.getTipoManoProduEmpresa(),connexion);
		TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
		tipomanoproduempresaLogic.deepLoad(productoprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);
				

		TipoProcesoEmpresaProduDataAccess.save(productoprodumano.getTipoProcesoEmpresaProdu(),connexion);
		TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
		tipoprocesoempresaproduLogic.deepLoad(productoprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoprodumano.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodumano.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodumano.getProductoDefiProdu(),connexion);
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepSave(productoprodumano.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoManoProduEmpresa.class)) {
				TipoManoProduEmpresaDataAccess.save(productoprodumano.getTipoManoProduEmpresa(),connexion);
				TipoManoProduEmpresaLogic tipomanoproduempresaLogic= new TipoManoProduEmpresaLogic(connexion);
				tipomanoproduempresaLogic.deepSave(productoprodumano.getTipoManoProduEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				TipoProcesoEmpresaProduDataAccess.save(productoprodumano.getTipoProcesoEmpresaProdu(),connexion);
				TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
				tipoprocesoempresaproduLogic.deepSave(productoprodumano.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodumano.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoprodumano.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoProduMano.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoprodumano,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(productoprodumano);
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
			this.deepLoad(this.productoprodumano,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumano);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoProduMano.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoprodumanos!=null) {
				for(ProductoProduMano productoprodumano:productoprodumanos) {
					this.deepLoad(productoprodumano,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(productoprodumanos);
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
			if(productoprodumanos!=null) {
				for(ProductoProduMano productoprodumano:productoprodumanos) {
					this.deepLoad(productoprodumano,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(productoprodumanos);
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
			this.getNewConnexionToDeep(ProductoProduMano.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoprodumano,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoProduMano.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoprodumanos!=null) {
				for(ProductoProduMano productoprodumano:productoprodumanos) {
					this.deepSave(productoprodumano,isDeep,deepLoadType,clases);
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
			if(productoprodumanos!=null) {
				for(ProductoProduMano productoprodumano:productoprodumanos) {
					this.deepSave(productoprodumano,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoProduManosFK_IdProductoDefiProduWithConnection(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduManosFK_IdProductoDefiProdu(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduManosFK_IdTipoManoProduEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_mano_produ_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoManoProduEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoManoProduEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_mano_produ_empresa,ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoManoProduEmpresa);

			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoManoProduEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduManosFK_IdTipoManoProduEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_mano_produ_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoManoProduEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoManoProduEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_mano_produ_empresa,ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoManoProduEmpresa);

			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoManoProduEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduManosFK_IdTipoProcesoEmpresaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_empresa_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_empresa_produ,ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoEmpresaProdu);

			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduManosFK_IdTipoProcesoEmpresaProdu(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_empresa_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_empresa_produ,ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoEmpresaProdu);

			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduManosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMano.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduManoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduManosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduManoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduManoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(this.productoprodumanos);
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
			if(ProductoProduManoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduManoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoProduMano productoprodumano,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoProduManoConstantesFunciones.ISCONAUDITORIA) {
				if(productoprodumano.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduManoDataAccess.TABLENAME, productoprodumano.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduManoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduManoLogic.registrarAuditoriaDetallesProductoProduMano(connexion,productoprodumano,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoprodumano.getIsDeleted()) {
					/*if(!productoprodumano.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoProduManoDataAccess.TABLENAME, productoprodumano.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoProduManoLogic.registrarAuditoriaDetallesProductoProduMano(connexion,productoprodumano,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduManoDataAccess.TABLENAME, productoprodumano.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoprodumano.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduManoDataAccess.TABLENAME, productoprodumano.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduManoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduManoLogic.registrarAuditoriaDetallesProductoProduMano(connexion,productoprodumano,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoProduMano(Connexion connexion,ProductoProduMano productoprodumano)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoprodumano.getIsNew()||!productoprodumano.getid_producto_defi_produ().equals(productoprodumano.getProductoProduManoOriginal().getid_producto_defi_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumano.getProductoProduManoOriginal().getid_producto_defi_produ()!=null)
				{
					strValorActual=productoprodumano.getProductoProduManoOriginal().getid_producto_defi_produ().toString();
				}
				if(productoprodumano.getid_producto_defi_produ()!=null)
				{
					strValorNuevo=productoprodumano.getid_producto_defi_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumano.getIsNew()||!productoprodumano.getid_tipo_mano_produ_empresa().equals(productoprodumano.getProductoProduManoOriginal().getid_tipo_mano_produ_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumano.getProductoProduManoOriginal().getid_tipo_mano_produ_empresa()!=null)
				{
					strValorActual=productoprodumano.getProductoProduManoOriginal().getid_tipo_mano_produ_empresa().toString();
				}
				if(productoprodumano.getid_tipo_mano_produ_empresa()!=null)
				{
					strValorNuevo=productoprodumano.getid_tipo_mano_produ_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumano.getIsNew()||!productoprodumano.getid_tipo_proceso_empresa_produ().equals(productoprodumano.getProductoProduManoOriginal().getid_tipo_proceso_empresa_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumano.getProductoProduManoOriginal().getid_tipo_proceso_empresa_produ()!=null)
				{
					strValorActual=productoprodumano.getProductoProduManoOriginal().getid_tipo_proceso_empresa_produ().toString();
				}
				if(productoprodumano.getid_tipo_proceso_empresa_produ()!=null)
				{
					strValorNuevo=productoprodumano.getid_tipo_proceso_empresa_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumano.getIsNew()||!productoprodumano.getid_unidad().equals(productoprodumano.getProductoProduManoOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumano.getProductoProduManoOriginal().getid_unidad()!=null)
				{
					strValorActual=productoprodumano.getProductoProduManoOriginal().getid_unidad().toString();
				}
				if(productoprodumano.getid_unidad()!=null)
				{
					strValorNuevo=productoprodumano.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduManoConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumano.getIsNew()||!productoprodumano.getcantidad().equals(productoprodumano.getProductoProduManoOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumano.getProductoProduManoOriginal().getcantidad()!=null)
				{
					strValorActual=productoprodumano.getProductoProduManoOriginal().getcantidad().toString();
				}
				if(productoprodumano.getcantidad()!=null)
				{
					strValorNuevo=productoprodumano.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduManoConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumano.getIsNew()||!productoprodumano.getcosto().equals(productoprodumano.getProductoProduManoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumano.getProductoProduManoOriginal().getcosto()!=null)
				{
					strValorActual=productoprodumano.getProductoProduManoOriginal().getcosto().toString();
				}
				if(productoprodumano.getcosto()!=null)
				{
					strValorNuevo=productoprodumano.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduManoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumano.getIsNew()||!productoprodumano.getcosto_total().equals(productoprodumano.getProductoProduManoOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumano.getProductoProduManoOriginal().getcosto_total()!=null)
				{
					strValorActual=productoprodumano.getProductoProduManoOriginal().getcosto_total().toString();
				}
				if(productoprodumano.getcosto_total()!=null)
				{
					strValorNuevo=productoprodumano.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduManoConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumano.getIsNew()||!productoprodumano.getdescripcion().equals(productoprodumano.getProductoProduManoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumano.getProductoProduManoOriginal().getdescripcion()!=null)
				{
					strValorActual=productoprodumano.getProductoProduManoOriginal().getdescripcion();
				}
				if(productoprodumano.getdescripcion()!=null)
				{
					strValorNuevo=productoprodumano.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduManoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoProduManoRelacionesWithConnection(ProductoProduMano productoprodumano) throws Exception {

		if(!productoprodumano.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduManoRelacionesBase(productoprodumano,true);
		}
	}

	public void saveProductoProduManoRelaciones(ProductoProduMano productoprodumano)throws Exception {

		if(!productoprodumano.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduManoRelacionesBase(productoprodumano,false);
		}
	}

	public void saveProductoProduManoRelacionesBase(ProductoProduMano productoprodumano,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoProduMano-saveRelacionesWithConnection");}
	

			this.setProductoProduMano(productoprodumano);

			if(ProductoProduManoLogicAdditional.validarSaveRelaciones(productoprodumano,this)) {

				ProductoProduManoLogicAdditional.updateRelacionesToSave(productoprodumano,this);

				if((productoprodumano.getIsNew()||productoprodumano.getIsChanged())&&!productoprodumano.getIsDeleted()) {
					this.saveProductoProduMano();
					this.saveProductoProduManoRelacionesDetalles();

				} else if(productoprodumano.getIsDeleted()) {
					this.saveProductoProduManoRelacionesDetalles();
					this.saveProductoProduMano();
				}

				ProductoProduManoLogicAdditional.updateRelacionesToSaveAfter(productoprodumano,this);

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
	
	
	private void saveProductoProduManoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduManoConstantesFunciones.getClassesForeignKeysOfProductoProduMano(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduMano(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduManoConstantesFunciones.getClassesRelationshipsOfProductoProduMano(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

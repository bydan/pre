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
import com.bydan.erp.produccion.util.ProductoProduMaquinaConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoProduMaquinaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoProduMaquinaParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoProduMaquina;
import com.bydan.erp.produccion.business.logic.ProductoProduMaquinaLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoProduMaquinaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoProduMaquinaLogic.class);
	
	protected ProductoProduMaquinaDataAccess productoprodumaquinaDataAccess; 	
	protected ProductoProduMaquina productoprodumaquina;
	protected List<ProductoProduMaquina> productoprodumaquinas;
	protected Object productoprodumaquinaObject;	
	protected List<Object> productoprodumaquinasObject;
	
	public static ClassValidator<ProductoProduMaquina> productoprodumaquinaValidator = new ClassValidator<ProductoProduMaquina>(ProductoProduMaquina.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoProduMaquinaLogicAdditional productoprodumaquinaLogicAdditional=null;
	
	public ProductoProduMaquinaLogicAdditional getProductoProduMaquinaLogicAdditional() {
		return this.productoprodumaquinaLogicAdditional;
	}
	
	public void setProductoProduMaquinaLogicAdditional(ProductoProduMaquinaLogicAdditional productoprodumaquinaLogicAdditional) {
		try {
			this.productoprodumaquinaLogicAdditional=productoprodumaquinaLogicAdditional;
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
	
	
	
	
	public  ProductoProduMaquinaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoprodumaquinaDataAccess = new ProductoProduMaquinaDataAccess();
			
			this.productoprodumaquinas= new ArrayList<ProductoProduMaquina>();
			this.productoprodumaquina= new ProductoProduMaquina();
			
			this.productoprodumaquinaObject=new Object();
			this.productoprodumaquinasObject=new ArrayList<Object>();
				
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
			
			this.productoprodumaquinaDataAccess.setConnexionType(this.connexionType);
			this.productoprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoProduMaquinaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoprodumaquinaDataAccess = new ProductoProduMaquinaDataAccess();
			this.productoprodumaquinas= new ArrayList<ProductoProduMaquina>();
			this.productoprodumaquina= new ProductoProduMaquina();
			this.productoprodumaquinaObject=new Object();
			this.productoprodumaquinasObject=new ArrayList<Object>();
			
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
			
			this.productoprodumaquinaDataAccess.setConnexionType(this.connexionType);
			this.productoprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoProduMaquina getProductoProduMaquina() throws Exception {	
		ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToGet(productoprodumaquina,this.datosCliente,this.arrDatoGeneral);
		ProductoProduMaquinaLogicAdditional.updateProductoProduMaquinaToGet(productoprodumaquina,this.arrDatoGeneral);
		
		return productoprodumaquina;
	}
		
	public void setProductoProduMaquina(ProductoProduMaquina newProductoProduMaquina) {
		this.productoprodumaquina = newProductoProduMaquina;
	}
	
	public ProductoProduMaquinaDataAccess getProductoProduMaquinaDataAccess() {
		return productoprodumaquinaDataAccess;
	}
	
	public void setProductoProduMaquinaDataAccess(ProductoProduMaquinaDataAccess newproductoprodumaquinaDataAccess) {
		this.productoprodumaquinaDataAccess = newproductoprodumaquinaDataAccess;
	}
	
	public List<ProductoProduMaquina> getProductoProduMaquinas() throws Exception {		
		this.quitarProductoProduMaquinasNulos();
		
		ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToGets(productoprodumaquinas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoProduMaquina productoprodumaquinaLocal: productoprodumaquinas ) {
			ProductoProduMaquinaLogicAdditional.updateProductoProduMaquinaToGet(productoprodumaquinaLocal,this.arrDatoGeneral);
		}
		
		return productoprodumaquinas;
	}
	
	public void setProductoProduMaquinas(List<ProductoProduMaquina> newProductoProduMaquinas) {
		this.productoprodumaquinas = newProductoProduMaquinas;
	}
	
	public Object getProductoProduMaquinaObject() {	
		this.productoprodumaquinaObject=this.productoprodumaquinaDataAccess.getEntityObject();
		return this.productoprodumaquinaObject;
	}
		
	public void setProductoProduMaquinaObject(Object newProductoProduMaquinaObject) {
		this.productoprodumaquinaObject = newProductoProduMaquinaObject;
	}
	
	public List<Object> getProductoProduMaquinasObject() {		
		this.productoprodumaquinasObject=this.productoprodumaquinaDataAccess.getEntitiesObject();
		return this.productoprodumaquinasObject;
	}
		
	public void setProductoProduMaquinasObject(List<Object> newProductoProduMaquinasObject) {
		this.productoprodumaquinasObject = newProductoProduMaquinasObject;
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
		
		if(this.productoprodumaquinaDataAccess!=null) {
			this.productoprodumaquinaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoprodumaquinaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoprodumaquinaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoprodumaquina = new  ProductoProduMaquina();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodumaquina=productoprodumaquinaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquina);
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
		productoprodumaquina = new  ProductoProduMaquina();
		  		  
        try {
			
			productoprodumaquina=productoprodumaquinaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoprodumaquina = new  ProductoProduMaquina();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoprodumaquina=productoprodumaquinaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquina);
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
		productoprodumaquina = new  ProductoProduMaquina();
		  		  
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
		productoprodumaquina = new  ProductoProduMaquina();
		  		  
        try {
			
			productoprodumaquina=productoprodumaquinaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoprodumaquina = new  ProductoProduMaquina();
		  		  
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
		productoprodumaquina = new  ProductoProduMaquina();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoprodumaquinaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodumaquina = new  ProductoProduMaquina();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoprodumaquinaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodumaquina = new  ProductoProduMaquina();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoprodumaquinaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodumaquina = new  ProductoProduMaquina();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoprodumaquinaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoprodumaquina = new  ProductoProduMaquina();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoprodumaquinaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoprodumaquina = new  ProductoProduMaquina();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoprodumaquinaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
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
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		  		  
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
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		  		  
        try {			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		  		  
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
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
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
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		  		  
        try {
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
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
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
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
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoprodumaquina = new  ProductoProduMaquina();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquina=productoprodumaquinaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquina);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquina);
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
		productoprodumaquina = new  ProductoProduMaquina();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquina=productoprodumaquinaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquina);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
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
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		  		  
        try {
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoProduMaquinasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getTodosProductoProduMaquinasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
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
	
	public  void  getTodosProductoProduMaquinas(String sFinalQuery,Pagination pagination)throws Exception {
		productoprodumaquinas = new  ArrayList<ProductoProduMaquina>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoProduMaquina(productoprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoProduMaquina(ProductoProduMaquina productoprodumaquina) throws Exception {
		Boolean estaValidado=false;
		
		if(productoprodumaquina.getIsNew() || productoprodumaquina.getIsChanged()) { 
			this.invalidValues = productoprodumaquinaValidator.getInvalidValues(productoprodumaquina);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoprodumaquina);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoProduMaquina(List<ProductoProduMaquina> ProductoProduMaquinas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoProduMaquina productoprodumaquinaLocal:productoprodumaquinas) {				
			estaValidadoObjeto=this.validarGuardarProductoProduMaquina(productoprodumaquinaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoProduMaquina(List<ProductoProduMaquina> ProductoProduMaquinas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProduMaquina(productoprodumaquinas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoProduMaquina(ProductoProduMaquina ProductoProduMaquina) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoProduMaquina(productoprodumaquina)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoProduMaquina productoprodumaquina) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoprodumaquina.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoProduMaquinaConstantesFunciones.getProductoProduMaquinaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoprodumaquina","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoProduMaquinaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoProduMaquinaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoProduMaquinaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-saveProductoProduMaquinaWithConnection");connexion.begin();			
			
			ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToSave(this.productoprodumaquina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduMaquinaLogicAdditional.updateProductoProduMaquinaToSave(this.productoprodumaquina,this.arrDatoGeneral);
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodumaquina,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoProduMaquina();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProduMaquina(this.productoprodumaquina)) {
				ProductoProduMaquinaDataAccess.save(this.productoprodumaquina, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToSaveAfter(this.productoprodumaquina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProduMaquina();
			
			connexion.commit();			
			
			if(this.productoprodumaquina.getIsDeleted()) {
				this.productoprodumaquina=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoProduMaquina()throws Exception {	
		try {	
			
			ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToSave(this.productoprodumaquina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoProduMaquinaLogicAdditional.updateProductoProduMaquinaToSave(this.productoprodumaquina,this.arrDatoGeneral);
			
			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoprodumaquina,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoProduMaquina(this.productoprodumaquina)) {			
				ProductoProduMaquinaDataAccess.save(this.productoprodumaquina, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToSaveAfter(this.productoprodumaquina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoprodumaquina.getIsDeleted()) {
				this.productoprodumaquina=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoProduMaquinasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-saveProductoProduMaquinasWithConnection");connexion.begin();			
			
			ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToSaves(productoprodumaquinas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoProduMaquinas();
			
			Boolean validadoTodosProductoProduMaquina=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProduMaquina productoprodumaquinaLocal:productoprodumaquinas) {		
				if(productoprodumaquinaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduMaquinaLogicAdditional.updateProductoProduMaquinaToSave(productoprodumaquinaLocal,this.arrDatoGeneral);
	        	
				ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoprodumaquinaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProduMaquina(productoprodumaquinaLocal)) {
					ProductoProduMaquinaDataAccess.save(productoprodumaquinaLocal, connexion);				
				} else {
					validadoTodosProductoProduMaquina=false;
				}
			}
			
			if(!validadoTodosProductoProduMaquina) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToSavesAfter(productoprodumaquinas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoProduMaquinas();
			
			connexion.commit();		
			
			this.quitarProductoProduMaquinasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoProduMaquinas()throws Exception {				
		 try {	
			ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToSaves(productoprodumaquinas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoProduMaquina=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoProduMaquina productoprodumaquinaLocal:productoprodumaquinas) {				
				if(productoprodumaquinaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoProduMaquinaLogicAdditional.updateProductoProduMaquinaToSave(productoprodumaquinaLocal,this.arrDatoGeneral);
	        	
				ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoprodumaquinaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoProduMaquina(productoprodumaquinaLocal)) {				
					ProductoProduMaquinaDataAccess.save(productoprodumaquinaLocal, connexion);				
				} else {
					validadoTodosProductoProduMaquina=false;
				}
			}
			
			if(!validadoTodosProductoProduMaquina) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoProduMaquinaLogicAdditional.checkProductoProduMaquinaToSavesAfter(productoprodumaquinas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoProduMaquinasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduMaquinaParameterReturnGeneral procesarAccionProductoProduMaquinas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProduMaquina> productoprodumaquinas,ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaParameterGeneral)throws Exception {
		 try {	
			ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaReturnGeneral=new ProductoProduMaquinaParameterReturnGeneral();
	
			ProductoProduMaquinaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodumaquinas,productoprodumaquinaParameterGeneral,productoprodumaquinaReturnGeneral);
			
			return productoprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoProduMaquinaParameterReturnGeneral procesarAccionProductoProduMaquinasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoProduMaquina> productoprodumaquinas,ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-procesarAccionProductoProduMaquinasWithConnection");connexion.begin();			
			
			ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaReturnGeneral=new ProductoProduMaquinaParameterReturnGeneral();
	
			ProductoProduMaquinaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoprodumaquinas,productoprodumaquinaParameterGeneral,productoprodumaquinaReturnGeneral);
			
			this.connexion.commit();
			
			return productoprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduMaquinaParameterReturnGeneral procesarEventosProductoProduMaquinas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProduMaquina> productoprodumaquinas,ProductoProduMaquina productoprodumaquina,ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaParameterGeneral,Boolean isEsNuevoProductoProduMaquina,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaReturnGeneral=new ProductoProduMaquinaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoprodumaquinaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduMaquinaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodumaquinas,productoprodumaquina,productoprodumaquinaParameterGeneral,productoprodumaquinaReturnGeneral,isEsNuevoProductoProduMaquina,clases);
			
			return productoprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoProduMaquinaParameterReturnGeneral procesarEventosProductoProduMaquinasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoProduMaquina> productoprodumaquinas,ProductoProduMaquina productoprodumaquina,ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaParameterGeneral,Boolean isEsNuevoProductoProduMaquina,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-procesarEventosProductoProduMaquinasWithConnection");connexion.begin();			
			
			ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaReturnGeneral=new ProductoProduMaquinaParameterReturnGeneral();
	
			productoprodumaquinaReturnGeneral.setProductoProduMaquina(productoprodumaquina);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoprodumaquinaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoProduMaquinaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoprodumaquinas,productoprodumaquina,productoprodumaquinaParameterGeneral,productoprodumaquinaReturnGeneral,isEsNuevoProductoProduMaquina,clases);
			
			this.connexion.commit();
			
			return productoprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoProduMaquinaParameterReturnGeneral procesarImportacionProductoProduMaquinasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-procesarImportacionProductoProduMaquinasWithConnection");connexion.begin();			
			
			ProductoProduMaquinaParameterReturnGeneral productoprodumaquinaReturnGeneral=new ProductoProduMaquinaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoprodumaquinas=new ArrayList<ProductoProduMaquina>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoprodumaquina=new ProductoProduMaquina();
				
				
				if(conColumnasBase) {this.productoprodumaquina.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoprodumaquina.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoprodumaquina.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoprodumaquina.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodumaquina.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoprodumaquina.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoprodumaquinas.add(this.productoprodumaquina);
			}
			
			this.saveProductoProduMaquinas();
			
			this.connexion.commit();
			
			productoprodumaquinaReturnGeneral.setConRetornoEstaProcesado(true);
			productoprodumaquinaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoProduMaquinasEliminados() throws Exception {				
		
		List<ProductoProduMaquina> productoprodumaquinasAux= new ArrayList<ProductoProduMaquina>();
		
		for(ProductoProduMaquina productoprodumaquina:productoprodumaquinas) {
			if(!productoprodumaquina.getIsDeleted()) {
				productoprodumaquinasAux.add(productoprodumaquina);
			}
		}
		
		productoprodumaquinas=productoprodumaquinasAux;
	}
	
	public void quitarProductoProduMaquinasNulos() throws Exception {				
		
		List<ProductoProduMaquina> productoprodumaquinasAux= new ArrayList<ProductoProduMaquina>();
		
		for(ProductoProduMaquina productoprodumaquina : this.productoprodumaquinas) {
			if(productoprodumaquina==null) {
				productoprodumaquinasAux.add(productoprodumaquina);
			}
		}
		
		//this.productoprodumaquinas=productoprodumaquinasAux;
		
		this.productoprodumaquinas.removeAll(productoprodumaquinasAux);
	}
	
	public void getSetVersionRowProductoProduMaquinaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoprodumaquina.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoprodumaquina.getIsDeleted() || (productoprodumaquina.getIsChanged()&&!productoprodumaquina.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoprodumaquinaDataAccess.getSetVersionRowProductoProduMaquina(connexion,productoprodumaquina.getId());
				
				if(!productoprodumaquina.getVersionRow().equals(timestamp)) {	
					productoprodumaquina.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoprodumaquina.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoProduMaquina()throws Exception {	
		
		if(productoprodumaquina.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoprodumaquina.getIsDeleted() || (productoprodumaquina.getIsChanged()&&!productoprodumaquina.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoprodumaquinaDataAccess.getSetVersionRowProductoProduMaquina(connexion,productoprodumaquina.getId());
			
			try {							
				if(!productoprodumaquina.getVersionRow().equals(timestamp)) {	
					productoprodumaquina.setVersionRow(timestamp);
				}
				
				productoprodumaquina.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoProduMaquinasWithConnection()throws Exception {	
		if(productoprodumaquinas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoProduMaquina productoprodumaquinaAux:productoprodumaquinas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoprodumaquinaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoprodumaquinaAux.getIsDeleted() || (productoprodumaquinaAux.getIsChanged()&&!productoprodumaquinaAux.getIsNew())) {
						
						timestamp=productoprodumaquinaDataAccess.getSetVersionRowProductoProduMaquina(connexion,productoprodumaquinaAux.getId());
						
						if(!productoprodumaquina.getVersionRow().equals(timestamp)) {	
							productoprodumaquinaAux.setVersionRow(timestamp);
						}
								
						productoprodumaquinaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoProduMaquinas()throws Exception {	
		if(productoprodumaquinas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoProduMaquina productoprodumaquinaAux:productoprodumaquinas) {
					if(productoprodumaquinaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoprodumaquinaAux.getIsDeleted() || (productoprodumaquinaAux.getIsChanged()&&!productoprodumaquinaAux.getIsNew())) {
						
						timestamp=productoprodumaquinaDataAccess.getSetVersionRowProductoProduMaquina(connexion,productoprodumaquinaAux.getId());
						
						if(!productoprodumaquinaAux.getVersionRow().equals(timestamp)) {	
							productoprodumaquinaAux.setVersionRow(timestamp);
						}
						
													
						productoprodumaquinaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoProduMaquinaParameterReturnGeneral cargarCombosLoteForeignKeyProductoProduMaquinaWithConnection(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalTipoAreaEmpresaProdu,String finalQueryGlobalTipoProcesoEmpresaProdu,String finalQueryGlobalTipoMaquinaEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduMaquinaParameterReturnGeneral  productoprodumaquinaReturnGeneral =new ProductoProduMaquinaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoProduMaquinaWithConnection");connexion.begin();
			
			productoprodumaquinaReturnGeneral =new ProductoProduMaquinaParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoprodumaquinaReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<TipoAreaEmpresaProdu> tipoareaempresaprodusForeignKey=new ArrayList<TipoAreaEmpresaProdu>();
			TipoAreaEmpresaProduLogic tipoareaempresaproduLogic=new TipoAreaEmpresaProduLogic();
			tipoareaempresaproduLogic.setConnexion(this.connexion);
			tipoareaempresaproduLogic.getTipoAreaEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAreaEmpresaProdu.equals("NONE")) {
				tipoareaempresaproduLogic.getTodosTipoAreaEmpresaProdus(finalQueryGlobalTipoAreaEmpresaProdu,new Pagination());
				tipoareaempresaprodusForeignKey=tipoareaempresaproduLogic.getTipoAreaEmpresaProdus();
			}

			productoprodumaquinaReturnGeneral.settipoareaempresaprodusForeignKey(tipoareaempresaprodusForeignKey);


			List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic=new TipoProcesoEmpresaProduLogic();
			tipoprocesoempresaproduLogic.setConnexion(this.connexion);
			tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoEmpresaProdu.equals("NONE")) {
				tipoprocesoempresaproduLogic.getTodosTipoProcesoEmpresaProdus(finalQueryGlobalTipoProcesoEmpresaProdu,new Pagination());
				tipoprocesoempresaprodusForeignKey=tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProdus();
			}

			productoprodumaquinaReturnGeneral.settipoprocesoempresaprodusForeignKey(tipoprocesoempresaprodusForeignKey);


			List<TipoMaquinaEmpresa> tipomaquinaempresasForeignKey=new ArrayList<TipoMaquinaEmpresa>();
			TipoMaquinaEmpresaLogic tipomaquinaempresaLogic=new TipoMaquinaEmpresaLogic();
			tipomaquinaempresaLogic.setConnexion(this.connexion);
			tipomaquinaempresaLogic.getTipoMaquinaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMaquinaEmpresa.equals("NONE")) {
				tipomaquinaempresaLogic.getTodosTipoMaquinaEmpresas(finalQueryGlobalTipoMaquinaEmpresa,new Pagination());
				tipomaquinaempresasForeignKey=tipomaquinaempresaLogic.getTipoMaquinaEmpresas();
			}

			productoprodumaquinaReturnGeneral.settipomaquinaempresasForeignKey(tipomaquinaempresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoprodumaquinaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoprodumaquinaReturnGeneral;
	}
	
	public ProductoProduMaquinaParameterReturnGeneral cargarCombosLoteForeignKeyProductoProduMaquina(String finalQueryGlobalProductoDefiProdu,String finalQueryGlobalTipoAreaEmpresaProdu,String finalQueryGlobalTipoProcesoEmpresaProdu,String finalQueryGlobalTipoMaquinaEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ProductoProduMaquinaParameterReturnGeneral  productoprodumaquinaReturnGeneral =new ProductoProduMaquinaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoprodumaquinaReturnGeneral =new ProductoProduMaquinaParameterReturnGeneral();
			
			

			List<ProductoDefiProdu> productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
			ProductoDefiProduLogic productodefiproduLogic=new ProductoDefiProduLogic();
			productodefiproduLogic.setConnexion(this.connexion);
			productodefiproduLogic.getProductoDefiProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoDefiProdu.equals("NONE")) {
				productodefiproduLogic.getTodosProductoDefiProdus(finalQueryGlobalProductoDefiProdu,new Pagination());
				productodefiprodusForeignKey=productodefiproduLogic.getProductoDefiProdus();
			}

			productoprodumaquinaReturnGeneral.setproductodefiprodusForeignKey(productodefiprodusForeignKey);


			List<TipoAreaEmpresaProdu> tipoareaempresaprodusForeignKey=new ArrayList<TipoAreaEmpresaProdu>();
			TipoAreaEmpresaProduLogic tipoareaempresaproduLogic=new TipoAreaEmpresaProduLogic();
			tipoareaempresaproduLogic.setConnexion(this.connexion);
			tipoareaempresaproduLogic.getTipoAreaEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAreaEmpresaProdu.equals("NONE")) {
				tipoareaempresaproduLogic.getTodosTipoAreaEmpresaProdus(finalQueryGlobalTipoAreaEmpresaProdu,new Pagination());
				tipoareaempresaprodusForeignKey=tipoareaempresaproduLogic.getTipoAreaEmpresaProdus();
			}

			productoprodumaquinaReturnGeneral.settipoareaempresaprodusForeignKey(tipoareaempresaprodusForeignKey);


			List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic=new TipoProcesoEmpresaProduLogic();
			tipoprocesoempresaproduLogic.setConnexion(this.connexion);
			tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoEmpresaProdu.equals("NONE")) {
				tipoprocesoempresaproduLogic.getTodosTipoProcesoEmpresaProdus(finalQueryGlobalTipoProcesoEmpresaProdu,new Pagination());
				tipoprocesoempresaprodusForeignKey=tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProdus();
			}

			productoprodumaquinaReturnGeneral.settipoprocesoempresaprodusForeignKey(tipoprocesoempresaprodusForeignKey);


			List<TipoMaquinaEmpresa> tipomaquinaempresasForeignKey=new ArrayList<TipoMaquinaEmpresa>();
			TipoMaquinaEmpresaLogic tipomaquinaempresaLogic=new TipoMaquinaEmpresaLogic();
			tipomaquinaempresaLogic.setConnexion(this.connexion);
			tipomaquinaempresaLogic.getTipoMaquinaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMaquinaEmpresa.equals("NONE")) {
				tipomaquinaempresaLogic.getTodosTipoMaquinaEmpresas(finalQueryGlobalTipoMaquinaEmpresa,new Pagination());
				tipomaquinaempresasForeignKey=tipomaquinaempresaLogic.getTipoMaquinaEmpresas();
			}

			productoprodumaquinaReturnGeneral.settipomaquinaempresasForeignKey(tipomaquinaempresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoprodumaquinaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoprodumaquinaReturnGeneral;
	}
	
	
	public void deepLoad(ProductoProduMaquina productoprodumaquina,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoProduMaquinaLogicAdditional.updateProductoProduMaquinaToGet(productoprodumaquina,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodumaquina.setProductoDefiProdu(productoprodumaquinaDataAccess.getProductoDefiProdu(connexion,productoprodumaquina));
		productoprodumaquina.setTipoAreaEmpresaProdu(productoprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoprodumaquina));
		productoprodumaquina.setTipoProcesoEmpresaProdu(productoprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumaquina));
		productoprodumaquina.setTipoMaquinaEmpresa(productoprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoprodumaquina));
		productoprodumaquina.setUnidad(productoprodumaquinaDataAccess.getUnidad(connexion,productoprodumaquina));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodumaquina.setProductoDefiProdu(productoprodumaquinaDataAccess.getProductoDefiProdu(connexion,productoprodumaquina));
				continue;
			}

			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				productoprodumaquina.setTipoAreaEmpresaProdu(productoprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoprodumaquina));
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				productoprodumaquina.setTipoProcesoEmpresaProdu(productoprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumaquina));
				continue;
			}

			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				productoprodumaquina.setTipoMaquinaEmpresa(productoprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoprodumaquina));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodumaquina.setUnidad(productoprodumaquinaDataAccess.getUnidad(connexion,productoprodumaquina));
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
			productoprodumaquina.setProductoDefiProdu(productoprodumaquinaDataAccess.getProductoDefiProdu(connexion,productoprodumaquina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumaquina.setTipoAreaEmpresaProdu(productoprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoprodumaquina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumaquina.setTipoProcesoEmpresaProdu(productoprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumaquina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumaquina.setTipoMaquinaEmpresa(productoprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoprodumaquina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumaquina.setUnidad(productoprodumaquinaDataAccess.getUnidad(connexion,productoprodumaquina));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoprodumaquina.setProductoDefiProdu(productoprodumaquinaDataAccess.getProductoDefiProdu(connexion,productoprodumaquina));
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodumaquina.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		productoprodumaquina.setTipoAreaEmpresaProdu(productoprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoprodumaquina));
		TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
		tipoareaempresaproduLogic.deepLoad(productoprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);
				
		productoprodumaquina.setTipoProcesoEmpresaProdu(productoprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumaquina));
		TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
		tipoprocesoempresaproduLogic.deepLoad(productoprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				
		productoprodumaquina.setTipoMaquinaEmpresa(productoprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoprodumaquina));
		TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
		tipomaquinaempresaLogic.deepLoad(productoprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);
				
		productoprodumaquina.setUnidad(productoprodumaquinaDataAccess.getUnidad(connexion,productoprodumaquina));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodumaquina.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				productoprodumaquina.setProductoDefiProdu(productoprodumaquinaDataAccess.getProductoDefiProdu(connexion,productoprodumaquina));
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepLoad(productoprodumaquina.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				productoprodumaquina.setTipoAreaEmpresaProdu(productoprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoprodumaquina));
				TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
				tipoareaempresaproduLogic.deepLoad(productoprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				productoprodumaquina.setTipoProcesoEmpresaProdu(productoprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumaquina));
				TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
				tipoprocesoempresaproduLogic.deepLoad(productoprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				productoprodumaquina.setTipoMaquinaEmpresa(productoprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoprodumaquina));
				TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
				tipomaquinaempresaLogic.deepLoad(productoprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoprodumaquina.setUnidad(productoprodumaquinaDataAccess.getUnidad(connexion,productoprodumaquina));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoprodumaquina.getUnidad(),isDeep,deepLoadType,clases);				
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
			productoprodumaquina.setProductoDefiProdu(productoprodumaquinaDataAccess.getProductoDefiProdu(connexion,productoprodumaquina));
			ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
			productodefiproduLogic.deepLoad(productoprodumaquina.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumaquina.setTipoAreaEmpresaProdu(productoprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoprodumaquina));
			TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
			tipoareaempresaproduLogic.deepLoad(productoprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumaquina.setTipoProcesoEmpresaProdu(productoprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoprodumaquina));
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
			tipoprocesoempresaproduLogic.deepLoad(productoprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumaquina.setTipoMaquinaEmpresa(productoprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoprodumaquina));
			TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
			tipomaquinaempresaLogic.deepLoad(productoprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoprodumaquina.setUnidad(productoprodumaquinaDataAccess.getUnidad(connexion,productoprodumaquina));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoprodumaquina.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoProduMaquina productoprodumaquina,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoProduMaquinaLogicAdditional.updateProductoProduMaquinaToSave(productoprodumaquina,this.arrDatoGeneral);
			
ProductoProduMaquinaDataAccess.save(productoprodumaquina, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodumaquina.getProductoDefiProdu(),connexion);

		TipoAreaEmpresaProduDataAccess.save(productoprodumaquina.getTipoAreaEmpresaProdu(),connexion);

		TipoProcesoEmpresaProduDataAccess.save(productoprodumaquina.getTipoProcesoEmpresaProdu(),connexion);

		TipoMaquinaEmpresaDataAccess.save(productoprodumaquina.getTipoMaquinaEmpresa(),connexion);

		UnidadDataAccess.save(productoprodumaquina.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodumaquina.getProductoDefiProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				TipoAreaEmpresaProduDataAccess.save(productoprodumaquina.getTipoAreaEmpresaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				TipoProcesoEmpresaProduDataAccess.save(productoprodumaquina.getTipoProcesoEmpresaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				TipoMaquinaEmpresaDataAccess.save(productoprodumaquina.getTipoMaquinaEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodumaquina.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProductoDefiProduDataAccess.save(productoprodumaquina.getProductoDefiProdu(),connexion);
		ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
		productodefiproduLogic.deepLoad(productoprodumaquina.getProductoDefiProdu(),isDeep,deepLoadType,clases);
				

		TipoAreaEmpresaProduDataAccess.save(productoprodumaquina.getTipoAreaEmpresaProdu(),connexion);
		TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
		tipoareaempresaproduLogic.deepLoad(productoprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);
				

		TipoProcesoEmpresaProduDataAccess.save(productoprodumaquina.getTipoProcesoEmpresaProdu(),connexion);
		TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
		tipoprocesoempresaproduLogic.deepLoad(productoprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				

		TipoMaquinaEmpresaDataAccess.save(productoprodumaquina.getTipoMaquinaEmpresa(),connexion);
		TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
		tipomaquinaempresaLogic.deepLoad(productoprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoprodumaquina.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoprodumaquina.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoDefiProdu.class)) {
				ProductoDefiProduDataAccess.save(productoprodumaquina.getProductoDefiProdu(),connexion);
				ProductoDefiProduLogic productodefiproduLogic= new ProductoDefiProduLogic(connexion);
				productodefiproduLogic.deepSave(productoprodumaquina.getProductoDefiProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				TipoAreaEmpresaProduDataAccess.save(productoprodumaquina.getTipoAreaEmpresaProdu(),connexion);
				TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
				tipoareaempresaproduLogic.deepSave(productoprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				TipoProcesoEmpresaProduDataAccess.save(productoprodumaquina.getTipoProcesoEmpresaProdu(),connexion);
				TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
				tipoprocesoempresaproduLogic.deepSave(productoprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				TipoMaquinaEmpresaDataAccess.save(productoprodumaquina.getTipoMaquinaEmpresa(),connexion);
				TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
				tipomaquinaempresaLogic.deepSave(productoprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoprodumaquina.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoprodumaquina.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoProduMaquina.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(productoprodumaquina);
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
			this.deepLoad(this.productoprodumaquina,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoProduMaquina.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoprodumaquinas!=null) {
				for(ProductoProduMaquina productoprodumaquina:productoprodumaquinas) {
					this.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(productoprodumaquinas);
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
			if(productoprodumaquinas!=null) {
				for(ProductoProduMaquina productoprodumaquina:productoprodumaquinas) {
					this.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(productoprodumaquinas);
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
			this.getNewConnexionToDeep(ProductoProduMaquina.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoProduMaquina.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoprodumaquinas!=null) {
				for(ProductoProduMaquina productoprodumaquina:productoprodumaquinas) {
					this.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);
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
			if(productoprodumaquinas!=null) {
				for(ProductoProduMaquina productoprodumaquina:productoprodumaquinas) {
					this.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoProduMaquinasFK_IdProductoDefiProduWithConnection(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduMaquinasFK_IdProductoDefiProdu(String sFinalQuery,Pagination pagination,Long id_producto_defi_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoDefiProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoDefiProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_defi_produ,ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoDefiProdu);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoDefiProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduMaquinasFK_IdTipoAreaEmpresaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_area_empresa_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAreaEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAreaEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_area_empresa_produ,ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAreaEmpresaProdu);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAreaEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduMaquinasFK_IdTipoAreaEmpresaProdu(String sFinalQuery,Pagination pagination,Long id_tipo_area_empresa_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAreaEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAreaEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_area_empresa_produ,ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAreaEmpresaProdu);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAreaEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduMaquinasFK_IdTipoMaquinaEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_merma_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMaquinaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMaquinaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_merma_empresa,ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMaquinaEmpresa);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMaquinaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduMaquinasFK_IdTipoMaquinaEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_merma_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMaquinaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMaquinaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_merma_empresa,ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMaquinaEmpresa);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMaquinaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduMaquinasFK_IdTipoProcesoEmpresaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_empresa_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_empresa_produ,ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoEmpresaProdu);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduMaquinasFK_IdTipoProcesoEmpresaProdu(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_empresa_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_empresa_produ,ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoEmpresaProdu);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoProduMaquinasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduMaquinaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoProduMaquinasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoProduMaquinaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(this.productoprodumaquinas);
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
			if(ProductoProduMaquinaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduMaquinaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoProduMaquina productoprodumaquina,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoProduMaquinaConstantesFunciones.ISCONAUDITORIA) {
				if(productoprodumaquina.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduMaquinaDataAccess.TABLENAME, productoprodumaquina.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduMaquinaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduMaquinaLogic.registrarAuditoriaDetallesProductoProduMaquina(connexion,productoprodumaquina,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoprodumaquina.getIsDeleted()) {
					/*if(!productoprodumaquina.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoProduMaquinaDataAccess.TABLENAME, productoprodumaquina.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoProduMaquinaLogic.registrarAuditoriaDetallesProductoProduMaquina(connexion,productoprodumaquina,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduMaquinaDataAccess.TABLENAME, productoprodumaquina.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoprodumaquina.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoProduMaquinaDataAccess.TABLENAME, productoprodumaquina.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoProduMaquinaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoProduMaquinaLogic.registrarAuditoriaDetallesProductoProduMaquina(connexion,productoprodumaquina,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoProduMaquina(Connexion connexion,ProductoProduMaquina productoprodumaquina)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoprodumaquina.getIsNew()||!productoprodumaquina.getid_producto_defi_produ().equals(productoprodumaquina.getProductoProduMaquinaOriginal().getid_producto_defi_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumaquina.getProductoProduMaquinaOriginal().getid_producto_defi_produ()!=null)
				{
					strValorActual=productoprodumaquina.getProductoProduMaquinaOriginal().getid_producto_defi_produ().toString();
				}
				if(productoprodumaquina.getid_producto_defi_produ()!=null)
				{
					strValorNuevo=productoprodumaquina.getid_producto_defi_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumaquina.getIsNew()||!productoprodumaquina.getid_tipo_area_empresa_produ().equals(productoprodumaquina.getProductoProduMaquinaOriginal().getid_tipo_area_empresa_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumaquina.getProductoProduMaquinaOriginal().getid_tipo_area_empresa_produ()!=null)
				{
					strValorActual=productoprodumaquina.getProductoProduMaquinaOriginal().getid_tipo_area_empresa_produ().toString();
				}
				if(productoprodumaquina.getid_tipo_area_empresa_produ()!=null)
				{
					strValorNuevo=productoprodumaquina.getid_tipo_area_empresa_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumaquina.getIsNew()||!productoprodumaquina.getid_tipo_proceso_empresa_produ().equals(productoprodumaquina.getProductoProduMaquinaOriginal().getid_tipo_proceso_empresa_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumaquina.getProductoProduMaquinaOriginal().getid_tipo_proceso_empresa_produ()!=null)
				{
					strValorActual=productoprodumaquina.getProductoProduMaquinaOriginal().getid_tipo_proceso_empresa_produ().toString();
				}
				if(productoprodumaquina.getid_tipo_proceso_empresa_produ()!=null)
				{
					strValorNuevo=productoprodumaquina.getid_tipo_proceso_empresa_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumaquina.getIsNew()||!productoprodumaquina.getid_tipo_merma_empresa().equals(productoprodumaquina.getProductoProduMaquinaOriginal().getid_tipo_merma_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumaquina.getProductoProduMaquinaOriginal().getid_tipo_merma_empresa()!=null)
				{
					strValorActual=productoprodumaquina.getProductoProduMaquinaOriginal().getid_tipo_merma_empresa().toString();
				}
				if(productoprodumaquina.getid_tipo_merma_empresa()!=null)
				{
					strValorNuevo=productoprodumaquina.getid_tipo_merma_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumaquina.getIsNew()||!productoprodumaquina.getid_unidad().equals(productoprodumaquina.getProductoProduMaquinaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumaquina.getProductoProduMaquinaOriginal().getid_unidad()!=null)
				{
					strValorActual=productoprodumaquina.getProductoProduMaquinaOriginal().getid_unidad().toString();
				}
				if(productoprodumaquina.getid_unidad()!=null)
				{
					strValorNuevo=productoprodumaquina.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMaquinaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumaquina.getIsNew()||!productoprodumaquina.getcantidad().equals(productoprodumaquina.getProductoProduMaquinaOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumaquina.getProductoProduMaquinaOriginal().getcantidad()!=null)
				{
					strValorActual=productoprodumaquina.getProductoProduMaquinaOriginal().getcantidad().toString();
				}
				if(productoprodumaquina.getcantidad()!=null)
				{
					strValorNuevo=productoprodumaquina.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMaquinaConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumaquina.getIsNew()||!productoprodumaquina.getcosto().equals(productoprodumaquina.getProductoProduMaquinaOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumaquina.getProductoProduMaquinaOriginal().getcosto()!=null)
				{
					strValorActual=productoprodumaquina.getProductoProduMaquinaOriginal().getcosto().toString();
				}
				if(productoprodumaquina.getcosto()!=null)
				{
					strValorNuevo=productoprodumaquina.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMaquinaConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumaquina.getIsNew()||!productoprodumaquina.getcosto_total().equals(productoprodumaquina.getProductoProduMaquinaOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumaquina.getProductoProduMaquinaOriginal().getcosto_total()!=null)
				{
					strValorActual=productoprodumaquina.getProductoProduMaquinaOriginal().getcosto_total().toString();
				}
				if(productoprodumaquina.getcosto_total()!=null)
				{
					strValorNuevo=productoprodumaquina.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMaquinaConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoprodumaquina.getIsNew()||!productoprodumaquina.getdescripcion().equals(productoprodumaquina.getProductoProduMaquinaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoprodumaquina.getProductoProduMaquinaOriginal().getdescripcion()!=null)
				{
					strValorActual=productoprodumaquina.getProductoProduMaquinaOriginal().getdescripcion();
				}
				if(productoprodumaquina.getdescripcion()!=null)
				{
					strValorNuevo=productoprodumaquina.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoProduMaquinaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoProduMaquinaRelacionesWithConnection(ProductoProduMaquina productoprodumaquina) throws Exception {

		if(!productoprodumaquina.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduMaquinaRelacionesBase(productoprodumaquina,true);
		}
	}

	public void saveProductoProduMaquinaRelaciones(ProductoProduMaquina productoprodumaquina)throws Exception {

		if(!productoprodumaquina.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoProduMaquinaRelacionesBase(productoprodumaquina,false);
		}
	}

	public void saveProductoProduMaquinaRelacionesBase(ProductoProduMaquina productoprodumaquina,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoProduMaquina-saveRelacionesWithConnection");}
	

			this.setProductoProduMaquina(productoprodumaquina);

			if(ProductoProduMaquinaLogicAdditional.validarSaveRelaciones(productoprodumaquina,this)) {

				ProductoProduMaquinaLogicAdditional.updateRelacionesToSave(productoprodumaquina,this);

				if((productoprodumaquina.getIsNew()||productoprodumaquina.getIsChanged())&&!productoprodumaquina.getIsDeleted()) {
					this.saveProductoProduMaquina();
					this.saveProductoProduMaquinaRelacionesDetalles();

				} else if(productoprodumaquina.getIsDeleted()) {
					this.saveProductoProduMaquinaRelacionesDetalles();
					this.saveProductoProduMaquina();
				}

				ProductoProduMaquinaLogicAdditional.updateRelacionesToSaveAfter(productoprodumaquina,this);

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
	
	
	private void saveProductoProduMaquinaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoProduMaquina(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoProduMaquinaConstantesFunciones.getClassesRelationshipsOfProductoProduMaquina(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

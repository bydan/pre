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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMaquinaConstantesFunciones;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMaquinaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMaquinaParameterGeneral;
import com.bydan.erp.produccion.business.entity.ProductoOrdenDetaProduMaquina;
import com.bydan.erp.produccion.business.logic.ProductoOrdenDetaProduMaquinaLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProductoOrdenDetaProduMaquinaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProductoOrdenDetaProduMaquinaLogic.class);
	
	protected ProductoOrdenDetaProduMaquinaDataAccess productoordendetaprodumaquinaDataAccess; 	
	protected ProductoOrdenDetaProduMaquina productoordendetaprodumaquina;
	protected List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas;
	protected Object productoordendetaprodumaquinaObject;	
	protected List<Object> productoordendetaprodumaquinasObject;
	
	public static ClassValidator<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinaValidator = new ClassValidator<ProductoOrdenDetaProduMaquina>(ProductoOrdenDetaProduMaquina.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProductoOrdenDetaProduMaquinaLogicAdditional productoordendetaprodumaquinaLogicAdditional=null;
	
	public ProductoOrdenDetaProduMaquinaLogicAdditional getProductoOrdenDetaProduMaquinaLogicAdditional() {
		return this.productoordendetaprodumaquinaLogicAdditional;
	}
	
	public void setProductoOrdenDetaProduMaquinaLogicAdditional(ProductoOrdenDetaProduMaquinaLogicAdditional productoordendetaprodumaquinaLogicAdditional) {
		try {
			this.productoordendetaprodumaquinaLogicAdditional=productoordendetaprodumaquinaLogicAdditional;
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
	
	
	
	
	public  ProductoOrdenDetaProduMaquinaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.productoordendetaprodumaquinaDataAccess = new ProductoOrdenDetaProduMaquinaDataAccess();
			
			this.productoordendetaprodumaquinas= new ArrayList<ProductoOrdenDetaProduMaquina>();
			this.productoordendetaprodumaquina= new ProductoOrdenDetaProduMaquina();
			
			this.productoordendetaprodumaquinaObject=new Object();
			this.productoordendetaprodumaquinasObject=new ArrayList<Object>();
				
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
			
			this.productoordendetaprodumaquinaDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProductoOrdenDetaProduMaquinaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.productoordendetaprodumaquinaDataAccess = new ProductoOrdenDetaProduMaquinaDataAccess();
			this.productoordendetaprodumaquinas= new ArrayList<ProductoOrdenDetaProduMaquina>();
			this.productoordendetaprodumaquina= new ProductoOrdenDetaProduMaquina();
			this.productoordendetaprodumaquinaObject=new Object();
			this.productoordendetaprodumaquinasObject=new ArrayList<Object>();
			
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
			
			this.productoordendetaprodumaquinaDataAccess.setConnexionType(this.connexionType);
			this.productoordendetaprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProductoOrdenDetaProduMaquina getProductoOrdenDetaProduMaquina() throws Exception {	
		ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToGet(productoordendetaprodumaquina,this.datosCliente,this.arrDatoGeneral);
		ProductoOrdenDetaProduMaquinaLogicAdditional.updateProductoOrdenDetaProduMaquinaToGet(productoordendetaprodumaquina,this.arrDatoGeneral);
		
		return productoordendetaprodumaquina;
	}
		
	public void setProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina newProductoOrdenDetaProduMaquina) {
		this.productoordendetaprodumaquina = newProductoOrdenDetaProduMaquina;
	}
	
	public ProductoOrdenDetaProduMaquinaDataAccess getProductoOrdenDetaProduMaquinaDataAccess() {
		return productoordendetaprodumaquinaDataAccess;
	}
	
	public void setProductoOrdenDetaProduMaquinaDataAccess(ProductoOrdenDetaProduMaquinaDataAccess newproductoordendetaprodumaquinaDataAccess) {
		this.productoordendetaprodumaquinaDataAccess = newproductoordendetaprodumaquinaDataAccess;
	}
	
	public List<ProductoOrdenDetaProduMaquina> getProductoOrdenDetaProduMaquinas() throws Exception {		
		this.quitarProductoOrdenDetaProduMaquinasNulos();
		
		ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToGets(productoordendetaprodumaquinas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaLocal: productoordendetaprodumaquinas ) {
			ProductoOrdenDetaProduMaquinaLogicAdditional.updateProductoOrdenDetaProduMaquinaToGet(productoordendetaprodumaquinaLocal,this.arrDatoGeneral);
		}
		
		return productoordendetaprodumaquinas;
	}
	
	public void setProductoOrdenDetaProduMaquinas(List<ProductoOrdenDetaProduMaquina> newProductoOrdenDetaProduMaquinas) {
		this.productoordendetaprodumaquinas = newProductoOrdenDetaProduMaquinas;
	}
	
	public Object getProductoOrdenDetaProduMaquinaObject() {	
		this.productoordendetaprodumaquinaObject=this.productoordendetaprodumaquinaDataAccess.getEntityObject();
		return this.productoordendetaprodumaquinaObject;
	}
		
	public void setProductoOrdenDetaProduMaquinaObject(Object newProductoOrdenDetaProduMaquinaObject) {
		this.productoordendetaprodumaquinaObject = newProductoOrdenDetaProduMaquinaObject;
	}
	
	public List<Object> getProductoOrdenDetaProduMaquinasObject() {		
		this.productoordendetaprodumaquinasObject=this.productoordendetaprodumaquinaDataAccess.getEntitiesObject();
		return this.productoordendetaprodumaquinasObject;
	}
		
	public void setProductoOrdenDetaProduMaquinasObject(List<Object> newProductoOrdenDetaProduMaquinasObject) {
		this.productoordendetaprodumaquinasObject = newProductoOrdenDetaProduMaquinasObject;
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
		
		if(this.productoordendetaprodumaquinaDataAccess!=null) {
			this.productoordendetaprodumaquinaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			productoordendetaprodumaquinaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			productoordendetaprodumaquinaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodumaquina=productoordendetaprodumaquinaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquina);
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
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		  		  
        try {
			
			productoordendetaprodumaquina=productoordendetaprodumaquinaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			productoordendetaprodumaquina=productoordendetaprodumaquinaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquina);
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
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		  		  
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
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		  		  
        try {
			
			productoordendetaprodumaquina=productoordendetaprodumaquinaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.productoordendetaprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		  		  
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
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =productoordendetaprodumaquinaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=productoordendetaprodumaquinaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =productoordendetaprodumaquinaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=productoordendetaprodumaquinaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =productoordendetaprodumaquinaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=productoordendetaprodumaquinaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
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
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		  		  
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
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		  		  
        try {			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		  		  
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
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
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
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		  		  
        try {
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
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
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
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
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquina=productoordendetaprodumaquinaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquina);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquina);
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
		productoordendetaprodumaquina = new  ProductoOrdenDetaProduMaquina();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquina=productoordendetaprodumaquinaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquina);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
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
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		  		  
        try {
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProductoOrdenDetaProduMaquinasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getTodosProductoOrdenDetaProduMaquinasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
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
	
	public  void  getTodosProductoOrdenDetaProduMaquinas(String sFinalQuery,Pagination pagination)throws Exception {
		productoordendetaprodumaquinas = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina) throws Exception {
		Boolean estaValidado=false;
		
		if(productoordendetaprodumaquina.getIsNew() || productoordendetaprodumaquina.getIsChanged()) { 
			this.invalidValues = productoordendetaprodumaquinaValidator.getInvalidValues(productoordendetaprodumaquina);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(productoordendetaprodumaquina);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProductoOrdenDetaProduMaquina(List<ProductoOrdenDetaProduMaquina> ProductoOrdenDetaProduMaquinas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaLocal:productoordendetaprodumaquinas) {				
			estaValidadoObjeto=this.validarGuardarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProductoOrdenDetaProduMaquina(List<ProductoOrdenDetaProduMaquina> ProductoOrdenDetaProduMaquinas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina ProductoOrdenDetaProduMaquina) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProductoOrdenDetaProduMaquina(productoordendetaprodumaquina)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+productoordendetaprodumaquina.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProductoOrdenDetaProduMaquinaConstantesFunciones.getProductoOrdenDetaProduMaquinaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"productoordendetaprodumaquina","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProductoOrdenDetaProduMaquinaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProductoOrdenDetaProduMaquinaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProductoOrdenDetaProduMaquinaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-saveProductoOrdenDetaProduMaquinaWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToSave(this.productoordendetaprodumaquina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.updateProductoOrdenDetaProduMaquinaToSave(this.productoordendetaprodumaquina,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodumaquina,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProduMaquina();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquina)) {
				ProductoOrdenDetaProduMaquinaDataAccess.save(this.productoordendetaprodumaquina, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToSaveAfter(this.productoordendetaprodumaquina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProduMaquina();
			
			connexion.commit();			
			
			if(this.productoordendetaprodumaquina.getIsDeleted()) {
				this.productoordendetaprodumaquina=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProductoOrdenDetaProduMaquina()throws Exception {	
		try {	
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToSave(this.productoordendetaprodumaquina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.updateProductoOrdenDetaProduMaquinaToSave(this.productoordendetaprodumaquina,this.arrDatoGeneral);
			
			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.productoordendetaprodumaquina,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquina)) {			
				ProductoOrdenDetaProduMaquinaDataAccess.save(this.productoordendetaprodumaquina, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.productoordendetaprodumaquina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToSaveAfter(this.productoordendetaprodumaquina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.productoordendetaprodumaquina.getIsDeleted()) {
				this.productoordendetaprodumaquina=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProductoOrdenDetaProduMaquinasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-saveProductoOrdenDetaProduMaquinasWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToSaves(productoordendetaprodumaquinas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProductoOrdenDetaProduMaquinas();
			
			Boolean validadoTodosProductoOrdenDetaProduMaquina=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaLocal:productoordendetaprodumaquinas) {		
				if(productoordendetaprodumaquinaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduMaquinaLogicAdditional.updateProductoOrdenDetaProduMaquinaToSave(productoordendetaprodumaquinaLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaprodumaquinaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinaLocal)) {
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquinaLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProduMaquina=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProduMaquina) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToSavesAfter(productoordendetaprodumaquinas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProductoOrdenDetaProduMaquinas();
			
			connexion.commit();		
			
			this.quitarProductoOrdenDetaProduMaquinasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProductoOrdenDetaProduMaquinas()throws Exception {				
		 try {	
			ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToSaves(productoordendetaprodumaquinas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProductoOrdenDetaProduMaquina=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaLocal:productoordendetaprodumaquinas) {				
				if(productoordendetaprodumaquinaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProductoOrdenDetaProduMaquinaLogicAdditional.updateProductoOrdenDetaProduMaquinaToSave(productoordendetaprodumaquinaLocal,this.arrDatoGeneral);
	        	
				ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),productoordendetaprodumaquinaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProductoOrdenDetaProduMaquina(productoordendetaprodumaquinaLocal)) {				
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquinaLocal, connexion);				
				} else {
					validadoTodosProductoOrdenDetaProduMaquina=false;
				}
			}
			
			if(!validadoTodosProductoOrdenDetaProduMaquina) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.checkProductoOrdenDetaProduMaquinaToSavesAfter(productoordendetaprodumaquinas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProductoOrdenDetaProduMaquinasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduMaquinaParameterReturnGeneral procesarAccionProductoOrdenDetaProduMaquinas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaParameterGeneral)throws Exception {
		 try {	
			ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaReturnGeneral=new ProductoOrdenDetaProduMaquinaParameterReturnGeneral();
	
			ProductoOrdenDetaProduMaquinaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodumaquinas,productoordendetaprodumaquinaParameterGeneral,productoordendetaprodumaquinaReturnGeneral);
			
			return productoordendetaprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProductoOrdenDetaProduMaquinaParameterReturnGeneral procesarAccionProductoOrdenDetaProduMaquinasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-procesarAccionProductoOrdenDetaProduMaquinasWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaReturnGeneral=new ProductoOrdenDetaProduMaquinaParameterReturnGeneral();
	
			ProductoOrdenDetaProduMaquinaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,productoordendetaprodumaquinas,productoordendetaprodumaquinaParameterGeneral,productoordendetaprodumaquinaReturnGeneral);
			
			this.connexion.commit();
			
			return productoordendetaprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduMaquinaParameterReturnGeneral procesarEventosProductoOrdenDetaProduMaquinas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProduMaquina,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaReturnGeneral=new ProductoOrdenDetaProduMaquinaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaprodumaquinaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodumaquinas,productoordendetaprodumaquina,productoordendetaprodumaquinaParameterGeneral,productoordendetaprodumaquinaReturnGeneral,isEsNuevoProductoOrdenDetaProduMaquina,clases);
			
			return productoordendetaprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProductoOrdenDetaProduMaquinaParameterReturnGeneral procesarEventosProductoOrdenDetaProduMaquinasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaParameterGeneral,Boolean isEsNuevoProductoOrdenDetaProduMaquina,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-procesarEventosProductoOrdenDetaProduMaquinasWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaReturnGeneral=new ProductoOrdenDetaProduMaquinaParameterReturnGeneral();
	
			productoordendetaprodumaquinaReturnGeneral.setProductoOrdenDetaProduMaquina(productoordendetaprodumaquina);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				productoordendetaprodumaquinaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProductoOrdenDetaProduMaquinaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,productoordendetaprodumaquinas,productoordendetaprodumaquina,productoordendetaprodumaquinaParameterGeneral,productoordendetaprodumaquinaReturnGeneral,isEsNuevoProductoOrdenDetaProduMaquina,clases);
			
			this.connexion.commit();
			
			return productoordendetaprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProductoOrdenDetaProduMaquinaParameterReturnGeneral procesarImportacionProductoOrdenDetaProduMaquinasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-procesarImportacionProductoOrdenDetaProduMaquinasWithConnection");connexion.begin();			
			
			ProductoOrdenDetaProduMaquinaParameterReturnGeneral productoordendetaprodumaquinaReturnGeneral=new ProductoOrdenDetaProduMaquinaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.productoordendetaprodumaquinas=new ArrayList<ProductoOrdenDetaProduMaquina>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.productoordendetaprodumaquina=new ProductoOrdenDetaProduMaquina();
				
				
				if(conColumnasBase) {this.productoordendetaprodumaquina.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.productoordendetaprodumaquina.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.productoordendetaprodumaquina.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.productoordendetaprodumaquina.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodumaquina.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.productoordendetaprodumaquina.setdescripcion(arrColumnas[iColumn++]);
				
				this.productoordendetaprodumaquinas.add(this.productoordendetaprodumaquina);
			}
			
			this.saveProductoOrdenDetaProduMaquinas();
			
			this.connexion.commit();
			
			productoordendetaprodumaquinaReturnGeneral.setConRetornoEstaProcesado(true);
			productoordendetaprodumaquinaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return productoordendetaprodumaquinaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProductoOrdenDetaProduMaquinasEliminados() throws Exception {				
		
		List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinasAux= new ArrayList<ProductoOrdenDetaProduMaquina>();
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:productoordendetaprodumaquinas) {
			if(!productoordendetaprodumaquina.getIsDeleted()) {
				productoordendetaprodumaquinasAux.add(productoordendetaprodumaquina);
			}
		}
		
		productoordendetaprodumaquinas=productoordendetaprodumaquinasAux;
	}
	
	public void quitarProductoOrdenDetaProduMaquinasNulos() throws Exception {				
		
		List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinasAux= new ArrayList<ProductoOrdenDetaProduMaquina>();
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina : this.productoordendetaprodumaquinas) {
			if(productoordendetaprodumaquina==null) {
				productoordendetaprodumaquinasAux.add(productoordendetaprodumaquina);
			}
		}
		
		//this.productoordendetaprodumaquinas=productoordendetaprodumaquinasAux;
		
		this.productoordendetaprodumaquinas.removeAll(productoordendetaprodumaquinasAux);
	}
	
	public void getSetVersionRowProductoOrdenDetaProduMaquinaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(productoordendetaprodumaquina.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((productoordendetaprodumaquina.getIsDeleted() || (productoordendetaprodumaquina.getIsChanged()&&!productoordendetaprodumaquina.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=productoordendetaprodumaquinaDataAccess.getSetVersionRowProductoOrdenDetaProduMaquina(connexion,productoordendetaprodumaquina.getId());
				
				if(!productoordendetaprodumaquina.getVersionRow().equals(timestamp)) {	
					productoordendetaprodumaquina.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				productoordendetaprodumaquina.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProductoOrdenDetaProduMaquina()throws Exception {	
		
		if(productoordendetaprodumaquina.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((productoordendetaprodumaquina.getIsDeleted() || (productoordendetaprodumaquina.getIsChanged()&&!productoordendetaprodumaquina.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=productoordendetaprodumaquinaDataAccess.getSetVersionRowProductoOrdenDetaProduMaquina(connexion,productoordendetaprodumaquina.getId());
			
			try {							
				if(!productoordendetaprodumaquina.getVersionRow().equals(timestamp)) {	
					productoordendetaprodumaquina.setVersionRow(timestamp);
				}
				
				productoordendetaprodumaquina.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProductoOrdenDetaProduMaquinasWithConnection()throws Exception {	
		if(productoordendetaprodumaquinas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAux:productoordendetaprodumaquinas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(productoordendetaprodumaquinaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaprodumaquinaAux.getIsDeleted() || (productoordendetaprodumaquinaAux.getIsChanged()&&!productoordendetaprodumaquinaAux.getIsNew())) {
						
						timestamp=productoordendetaprodumaquinaDataAccess.getSetVersionRowProductoOrdenDetaProduMaquina(connexion,productoordendetaprodumaquinaAux.getId());
						
						if(!productoordendetaprodumaquina.getVersionRow().equals(timestamp)) {	
							productoordendetaprodumaquinaAux.setVersionRow(timestamp);
						}
								
						productoordendetaprodumaquinaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProductoOrdenDetaProduMaquinas()throws Exception {	
		if(productoordendetaprodumaquinas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAux:productoordendetaprodumaquinas) {
					if(productoordendetaprodumaquinaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(productoordendetaprodumaquinaAux.getIsDeleted() || (productoordendetaprodumaquinaAux.getIsChanged()&&!productoordendetaprodumaquinaAux.getIsNew())) {
						
						timestamp=productoordendetaprodumaquinaDataAccess.getSetVersionRowProductoOrdenDetaProduMaquina(connexion,productoordendetaprodumaquinaAux.getId());
						
						if(!productoordendetaprodumaquinaAux.getVersionRow().equals(timestamp)) {	
							productoordendetaprodumaquinaAux.setVersionRow(timestamp);
						}
						
													
						productoordendetaprodumaquinaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProductoOrdenDetaProduMaquinaParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProduMaquinaWithConnection(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalTipoAreaEmpresaProdu,String finalQueryGlobalTipoProcesoEmpresaProdu,String finalQueryGlobalTipoMaquinaEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduMaquinaParameterReturnGeneral  productoordendetaprodumaquinaReturnGeneral =new ProductoOrdenDetaProduMaquinaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-cargarCombosLoteForeignKeyProductoOrdenDetaProduMaquinaWithConnection");connexion.begin();
			
			productoordendetaprodumaquinaReturnGeneral =new ProductoOrdenDetaProduMaquinaParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaprodumaquinaReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<TipoAreaEmpresaProdu> tipoareaempresaprodusForeignKey=new ArrayList<TipoAreaEmpresaProdu>();
			TipoAreaEmpresaProduLogic tipoareaempresaproduLogic=new TipoAreaEmpresaProduLogic();
			tipoareaempresaproduLogic.setConnexion(this.connexion);
			tipoareaempresaproduLogic.getTipoAreaEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAreaEmpresaProdu.equals("NONE")) {
				tipoareaempresaproduLogic.getTodosTipoAreaEmpresaProdus(finalQueryGlobalTipoAreaEmpresaProdu,new Pagination());
				tipoareaempresaprodusForeignKey=tipoareaempresaproduLogic.getTipoAreaEmpresaProdus();
			}

			productoordendetaprodumaquinaReturnGeneral.settipoareaempresaprodusForeignKey(tipoareaempresaprodusForeignKey);


			List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic=new TipoProcesoEmpresaProduLogic();
			tipoprocesoempresaproduLogic.setConnexion(this.connexion);
			tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoEmpresaProdu.equals("NONE")) {
				tipoprocesoempresaproduLogic.getTodosTipoProcesoEmpresaProdus(finalQueryGlobalTipoProcesoEmpresaProdu,new Pagination());
				tipoprocesoempresaprodusForeignKey=tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProdus();
			}

			productoordendetaprodumaquinaReturnGeneral.settipoprocesoempresaprodusForeignKey(tipoprocesoempresaprodusForeignKey);


			List<TipoMaquinaEmpresa> tipomaquinaempresasForeignKey=new ArrayList<TipoMaquinaEmpresa>();
			TipoMaquinaEmpresaLogic tipomaquinaempresaLogic=new TipoMaquinaEmpresaLogic();
			tipomaquinaempresaLogic.setConnexion(this.connexion);
			tipomaquinaempresaLogic.getTipoMaquinaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMaquinaEmpresa.equals("NONE")) {
				tipomaquinaempresaLogic.getTodosTipoMaquinaEmpresas(finalQueryGlobalTipoMaquinaEmpresa,new Pagination());
				tipomaquinaempresasForeignKey=tipomaquinaempresaLogic.getTipoMaquinaEmpresas();
			}

			productoordendetaprodumaquinaReturnGeneral.settipomaquinaempresasForeignKey(tipomaquinaempresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaprodumaquinaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return productoordendetaprodumaquinaReturnGeneral;
	}
	
	public ProductoOrdenDetaProduMaquinaParameterReturnGeneral cargarCombosLoteForeignKeyProductoOrdenDetaProduMaquina(String finalQueryGlobalOrdenDetaProdu,String finalQueryGlobalTipoAreaEmpresaProdu,String finalQueryGlobalTipoProcesoEmpresaProdu,String finalQueryGlobalTipoMaquinaEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ProductoOrdenDetaProduMaquinaParameterReturnGeneral  productoordendetaprodumaquinaReturnGeneral =new ProductoOrdenDetaProduMaquinaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			productoordendetaprodumaquinaReturnGeneral =new ProductoOrdenDetaProduMaquinaParameterReturnGeneral();
			
			

			List<OrdenDetaProdu> ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
			ordendetaproduLogic.setConnexion(this.connexion);
			ordendetaproduLogic.getOrdenDetaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenDetaProdu.equals("NONE")) {
				ordendetaproduLogic.getTodosOrdenDetaProdus(finalQueryGlobalOrdenDetaProdu,new Pagination());
				ordendetaprodusForeignKey=ordendetaproduLogic.getOrdenDetaProdus();
			}

			productoordendetaprodumaquinaReturnGeneral.setordendetaprodusForeignKey(ordendetaprodusForeignKey);


			List<TipoAreaEmpresaProdu> tipoareaempresaprodusForeignKey=new ArrayList<TipoAreaEmpresaProdu>();
			TipoAreaEmpresaProduLogic tipoareaempresaproduLogic=new TipoAreaEmpresaProduLogic();
			tipoareaempresaproduLogic.setConnexion(this.connexion);
			tipoareaempresaproduLogic.getTipoAreaEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAreaEmpresaProdu.equals("NONE")) {
				tipoareaempresaproduLogic.getTodosTipoAreaEmpresaProdus(finalQueryGlobalTipoAreaEmpresaProdu,new Pagination());
				tipoareaempresaprodusForeignKey=tipoareaempresaproduLogic.getTipoAreaEmpresaProdus();
			}

			productoordendetaprodumaquinaReturnGeneral.settipoareaempresaprodusForeignKey(tipoareaempresaprodusForeignKey);


			List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic=new TipoProcesoEmpresaProduLogic();
			tipoprocesoempresaproduLogic.setConnexion(this.connexion);
			tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoEmpresaProdu.equals("NONE")) {
				tipoprocesoempresaproduLogic.getTodosTipoProcesoEmpresaProdus(finalQueryGlobalTipoProcesoEmpresaProdu,new Pagination());
				tipoprocesoempresaprodusForeignKey=tipoprocesoempresaproduLogic.getTipoProcesoEmpresaProdus();
			}

			productoordendetaprodumaquinaReturnGeneral.settipoprocesoempresaprodusForeignKey(tipoprocesoempresaprodusForeignKey);


			List<TipoMaquinaEmpresa> tipomaquinaempresasForeignKey=new ArrayList<TipoMaquinaEmpresa>();
			TipoMaquinaEmpresaLogic tipomaquinaempresaLogic=new TipoMaquinaEmpresaLogic();
			tipomaquinaempresaLogic.setConnexion(this.connexion);
			tipomaquinaempresaLogic.getTipoMaquinaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMaquinaEmpresa.equals("NONE")) {
				tipomaquinaempresaLogic.getTodosTipoMaquinaEmpresas(finalQueryGlobalTipoMaquinaEmpresa,new Pagination());
				tipomaquinaempresasForeignKey=tipomaquinaempresaLogic.getTipoMaquinaEmpresas();
			}

			productoordendetaprodumaquinaReturnGeneral.settipomaquinaempresasForeignKey(tipomaquinaempresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			productoordendetaprodumaquinaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return productoordendetaprodumaquinaReturnGeneral;
	}
	
	
	public void deepLoad(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProductoOrdenDetaProduMaquinaLogicAdditional.updateProductoOrdenDetaProduMaquinaToGet(productoordendetaprodumaquina,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodumaquina.setOrdenDetaProdu(productoordendetaprodumaquinaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumaquina));
		productoordendetaprodumaquina.setTipoAreaEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoordendetaprodumaquina));
		productoordendetaprodumaquina.setTipoProcesoEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumaquina));
		productoordendetaprodumaquina.setTipoMaquinaEmpresa(productoordendetaprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoordendetaprodumaquina));
		productoordendetaprodumaquina.setUnidad(productoordendetaprodumaquinaDataAccess.getUnidad(connexion,productoordendetaprodumaquina));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodumaquina.setOrdenDetaProdu(productoordendetaprodumaquinaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumaquina));
				continue;
			}

			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				productoordendetaprodumaquina.setTipoAreaEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoordendetaprodumaquina));
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				productoordendetaprodumaquina.setTipoProcesoEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumaquina));
				continue;
			}

			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				productoordendetaprodumaquina.setTipoMaquinaEmpresa(productoordendetaprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoordendetaprodumaquina));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodumaquina.setUnidad(productoordendetaprodumaquinaDataAccess.getUnidad(connexion,productoordendetaprodumaquina));
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
			productoordendetaprodumaquina.setOrdenDetaProdu(productoordendetaprodumaquinaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumaquina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumaquina.setTipoAreaEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoordendetaprodumaquina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumaquina.setTipoProcesoEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumaquina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumaquina.setTipoMaquinaEmpresa(productoordendetaprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoordendetaprodumaquina));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumaquina.setUnidad(productoordendetaprodumaquinaDataAccess.getUnidad(connexion,productoordendetaprodumaquina));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		productoordendetaprodumaquina.setOrdenDetaProdu(productoordendetaprodumaquinaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumaquina));
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodumaquina.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		productoordendetaprodumaquina.setTipoAreaEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoordendetaprodumaquina));
		TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
		tipoareaempresaproduLogic.deepLoad(productoordendetaprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);
				
		productoordendetaprodumaquina.setTipoProcesoEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumaquina));
		TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
		tipoprocesoempresaproduLogic.deepLoad(productoordendetaprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				
		productoordendetaprodumaquina.setTipoMaquinaEmpresa(productoordendetaprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoordendetaprodumaquina));
		TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
		tipomaquinaempresaLogic.deepLoad(productoordendetaprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);
				
		productoordendetaprodumaquina.setUnidad(productoordendetaprodumaquinaDataAccess.getUnidad(connexion,productoordendetaprodumaquina));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodumaquina.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				productoordendetaprodumaquina.setOrdenDetaProdu(productoordendetaprodumaquinaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumaquina));
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepLoad(productoordendetaprodumaquina.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				productoordendetaprodumaquina.setTipoAreaEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoordendetaprodumaquina));
				TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
				tipoareaempresaproduLogic.deepLoad(productoordendetaprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				productoordendetaprodumaquina.setTipoProcesoEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumaquina));
				TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
				tipoprocesoempresaproduLogic.deepLoad(productoordendetaprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				productoordendetaprodumaquina.setTipoMaquinaEmpresa(productoordendetaprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoordendetaprodumaquina));
				TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
				tipomaquinaempresaLogic.deepLoad(productoordendetaprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				productoordendetaprodumaquina.setUnidad(productoordendetaprodumaquinaDataAccess.getUnidad(connexion,productoordendetaprodumaquina));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(productoordendetaprodumaquina.getUnidad(),isDeep,deepLoadType,clases);				
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
			productoordendetaprodumaquina.setOrdenDetaProdu(productoordendetaprodumaquinaDataAccess.getOrdenDetaProdu(connexion,productoordendetaprodumaquina));
			OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
			ordendetaproduLogic.deepLoad(productoordendetaprodumaquina.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumaquina.setTipoAreaEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoAreaEmpresaProdu(connexion,productoordendetaprodumaquina));
			TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
			tipoareaempresaproduLogic.deepLoad(productoordendetaprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumaquina.setTipoProcesoEmpresaProdu(productoordendetaprodumaquinaDataAccess.getTipoProcesoEmpresaProdu(connexion,productoordendetaprodumaquina));
			TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
			tipoprocesoempresaproduLogic.deepLoad(productoordendetaprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumaquina.setTipoMaquinaEmpresa(productoordendetaprodumaquinaDataAccess.getTipoMaquinaEmpresa(connexion,productoordendetaprodumaquina));
			TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
			tipomaquinaempresaLogic.deepLoad(productoordendetaprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			productoordendetaprodumaquina.setUnidad(productoordendetaprodumaquinaDataAccess.getUnidad(connexion,productoordendetaprodumaquina));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(productoordendetaprodumaquina.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProductoOrdenDetaProduMaquinaLogicAdditional.updateProductoOrdenDetaProduMaquinaToSave(productoordendetaprodumaquina,this.arrDatoGeneral);
			
ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodumaquina.getOrdenDetaProdu(),connexion);

		TipoAreaEmpresaProduDataAccess.save(productoordendetaprodumaquina.getTipoAreaEmpresaProdu(),connexion);

		TipoProcesoEmpresaProduDataAccess.save(productoordendetaprodumaquina.getTipoProcesoEmpresaProdu(),connexion);

		TipoMaquinaEmpresaDataAccess.save(productoordendetaprodumaquina.getTipoMaquinaEmpresa(),connexion);

		UnidadDataAccess.save(productoordendetaprodumaquina.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodumaquina.getOrdenDetaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				TipoAreaEmpresaProduDataAccess.save(productoordendetaprodumaquina.getTipoAreaEmpresaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				TipoProcesoEmpresaProduDataAccess.save(productoordendetaprodumaquina.getTipoProcesoEmpresaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				TipoMaquinaEmpresaDataAccess.save(productoordendetaprodumaquina.getTipoMaquinaEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodumaquina.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenDetaProduDataAccess.save(productoordendetaprodumaquina.getOrdenDetaProdu(),connexion);
		OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
		ordendetaproduLogic.deepLoad(productoordendetaprodumaquina.getOrdenDetaProdu(),isDeep,deepLoadType,clases);
				

		TipoAreaEmpresaProduDataAccess.save(productoordendetaprodumaquina.getTipoAreaEmpresaProdu(),connexion);
		TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
		tipoareaempresaproduLogic.deepLoad(productoordendetaprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);
				

		TipoProcesoEmpresaProduDataAccess.save(productoordendetaprodumaquina.getTipoProcesoEmpresaProdu(),connexion);
		TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
		tipoprocesoempresaproduLogic.deepLoad(productoordendetaprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);
				

		TipoMaquinaEmpresaDataAccess.save(productoordendetaprodumaquina.getTipoMaquinaEmpresa(),connexion);
		TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
		tipomaquinaempresaLogic.deepLoad(productoordendetaprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(productoordendetaprodumaquina.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(productoordendetaprodumaquina.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)) {
				OrdenDetaProduDataAccess.save(productoordendetaprodumaquina.getOrdenDetaProdu(),connexion);
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepSave(productoordendetaprodumaquina.getOrdenDetaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAreaEmpresaProdu.class)) {
				TipoAreaEmpresaProduDataAccess.save(productoordendetaprodumaquina.getTipoAreaEmpresaProdu(),connexion);
				TipoAreaEmpresaProduLogic tipoareaempresaproduLogic= new TipoAreaEmpresaProduLogic(connexion);
				tipoareaempresaproduLogic.deepSave(productoordendetaprodumaquina.getTipoAreaEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoEmpresaProdu.class)) {
				TipoProcesoEmpresaProduDataAccess.save(productoordendetaprodumaquina.getTipoProcesoEmpresaProdu(),connexion);
				TipoProcesoEmpresaProduLogic tipoprocesoempresaproduLogic= new TipoProcesoEmpresaProduLogic(connexion);
				tipoprocesoempresaproduLogic.deepSave(productoordendetaprodumaquina.getTipoProcesoEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMaquinaEmpresa.class)) {
				TipoMaquinaEmpresaDataAccess.save(productoordendetaprodumaquina.getTipoMaquinaEmpresa(),connexion);
				TipoMaquinaEmpresaLogic tipomaquinaempresaLogic= new TipoMaquinaEmpresaLogic(connexion);
				tipomaquinaempresaLogic.deepSave(productoordendetaprodumaquina.getTipoMaquinaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(productoordendetaprodumaquina.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(productoordendetaprodumaquina.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(productoordendetaprodumaquina);
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
			this.deepLoad(this.productoordendetaprodumaquina,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(productoordendetaprodumaquinas!=null) {
				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:productoordendetaprodumaquinas) {
					this.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
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
			if(productoordendetaprodumaquinas!=null) {
				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:productoordendetaprodumaquinas) {
					this.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(productoordendetaprodumaquinas);
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(productoordendetaprodumaquinas!=null) {
				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:productoordendetaprodumaquinas) {
					this.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
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
			if(productoordendetaprodumaquinas!=null) {
				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:productoordendetaprodumaquinas) {
					this.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProductoOrdenDetaProduMaquinasFK_IdOrdenDetaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduMaquinasFK_IdOrdenDetaProdu(String sFinalQuery,Pagination pagination,Long id_orden_deta_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenDetaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenDetaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_deta_produ,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenDetaProdu);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenDetaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduMaquinasFK_IdTipoAreaEmpresaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_area_empresa_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAreaEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAreaEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_area_empresa_produ,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAreaEmpresaProdu);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAreaEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduMaquinasFK_IdTipoAreaEmpresaProdu(String sFinalQuery,Pagination pagination,Long id_tipo_area_empresa_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAreaEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAreaEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_area_empresa_produ,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAreaEmpresaProdu);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAreaEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduMaquinasFK_IdTipoMaquinaEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_merma_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMaquinaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMaquinaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_merma_empresa,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMaquinaEmpresa);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMaquinaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduMaquinasFK_IdTipoMaquinaEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_merma_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMaquinaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMaquinaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_merma_empresa,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMaquinaEmpresa);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMaquinaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduMaquinasFK_IdTipoProcesoEmpresaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_empresa_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_empresa_produ,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoEmpresaProdu);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduMaquinasFK_IdTipoProcesoEmpresaProdu(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_empresa_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_empresa_produ,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoEmpresaProdu);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProductoOrdenDetaProduMaquinasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProductoOrdenDetaProduMaquina.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProductoOrdenDetaProduMaquinasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ProductoOrdenDetaProduMaquinaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(this.productoordendetaprodumaquinas);
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
			if(ProductoOrdenDetaProduMaquinaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProductoOrdenDetaProduMaquinaConstantesFunciones.ISCONAUDITORIA) {
				if(productoordendetaprodumaquina.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME, productoordendetaprodumaquina.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduMaquinaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduMaquinaLogic.registrarAuditoriaDetallesProductoOrdenDetaProduMaquina(connexion,productoordendetaprodumaquina,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(productoordendetaprodumaquina.getIsDeleted()) {
					/*if(!productoordendetaprodumaquina.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME, productoordendetaprodumaquina.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProductoOrdenDetaProduMaquinaLogic.registrarAuditoriaDetallesProductoOrdenDetaProduMaquina(connexion,productoordendetaprodumaquina,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME, productoordendetaprodumaquina.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(productoordendetaprodumaquina.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME, productoordendetaprodumaquina.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProductoOrdenDetaProduMaquinaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProductoOrdenDetaProduMaquinaLogic.registrarAuditoriaDetallesProductoOrdenDetaProduMaquina(connexion,productoordendetaprodumaquina,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProductoOrdenDetaProduMaquina(Connexion connexion,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(productoordendetaprodumaquina.getIsNew()||!productoordendetaprodumaquina.getid_orden_deta_produ().equals(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_orden_deta_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_orden_deta_produ()!=null)
				{
					strValorActual=productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_orden_deta_produ().toString();
				}
				if(productoordendetaprodumaquina.getid_orden_deta_produ()!=null)
				{
					strValorNuevo=productoordendetaprodumaquina.getid_orden_deta_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumaquina.getIsNew()||!productoordendetaprodumaquina.getid_tipo_area_empresa_produ().equals(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_tipo_area_empresa_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_tipo_area_empresa_produ()!=null)
				{
					strValorActual=productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_tipo_area_empresa_produ().toString();
				}
				if(productoordendetaprodumaquina.getid_tipo_area_empresa_produ()!=null)
				{
					strValorNuevo=productoordendetaprodumaquina.getid_tipo_area_empresa_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumaquina.getIsNew()||!productoordendetaprodumaquina.getid_tipo_proceso_empresa_produ().equals(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_tipo_proceso_empresa_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_tipo_proceso_empresa_produ()!=null)
				{
					strValorActual=productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_tipo_proceso_empresa_produ().toString();
				}
				if(productoordendetaprodumaquina.getid_tipo_proceso_empresa_produ()!=null)
				{
					strValorNuevo=productoordendetaprodumaquina.getid_tipo_proceso_empresa_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumaquina.getIsNew()||!productoordendetaprodumaquina.getid_tipo_merma_empresa().equals(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_tipo_merma_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_tipo_merma_empresa()!=null)
				{
					strValorActual=productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_tipo_merma_empresa().toString();
				}
				if(productoordendetaprodumaquina.getid_tipo_merma_empresa()!=null)
				{
					strValorNuevo=productoordendetaprodumaquina.getid_tipo_merma_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumaquina.getIsNew()||!productoordendetaprodumaquina.getid_unidad().equals(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_unidad()!=null)
				{
					strValorActual=productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getid_unidad().toString();
				}
				if(productoordendetaprodumaquina.getid_unidad()!=null)
				{
					strValorNuevo=productoordendetaprodumaquina.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumaquina.getIsNew()||!productoordendetaprodumaquina.getcantidad().equals(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getcantidad()!=null)
				{
					strValorActual=productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getcantidad().toString();
				}
				if(productoordendetaprodumaquina.getcantidad()!=null)
				{
					strValorNuevo=productoordendetaprodumaquina.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumaquina.getIsNew()||!productoordendetaprodumaquina.getcosto().equals(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getcosto()!=null)
				{
					strValorActual=productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getcosto().toString();
				}
				if(productoordendetaprodumaquina.getcosto()!=null)
				{
					strValorNuevo=productoordendetaprodumaquina.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumaquina.getIsNew()||!productoordendetaprodumaquina.getcosto_total().equals(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getcosto_total()!=null)
				{
					strValorActual=productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getcosto_total().toString();
				}
				if(productoordendetaprodumaquina.getcosto_total()!=null)
				{
					strValorNuevo=productoordendetaprodumaquina.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(productoordendetaprodumaquina.getIsNew()||!productoordendetaprodumaquina.getdescripcion().equals(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getdescripcion()!=null)
				{
					strValorActual=productoordendetaprodumaquina.getProductoOrdenDetaProduMaquinaOriginal().getdescripcion();
				}
				if(productoordendetaprodumaquina.getdescripcion()!=null)
				{
					strValorNuevo=productoordendetaprodumaquina.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProductoOrdenDetaProduMaquinaRelacionesWithConnection(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina) throws Exception {

		if(!productoordendetaprodumaquina.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduMaquinaRelacionesBase(productoordendetaprodumaquina,true);
		}
	}

	public void saveProductoOrdenDetaProduMaquinaRelaciones(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina)throws Exception {

		if(!productoordendetaprodumaquina.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProductoOrdenDetaProduMaquinaRelacionesBase(productoordendetaprodumaquina,false);
		}
	}

	public void saveProductoOrdenDetaProduMaquinaRelacionesBase(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProductoOrdenDetaProduMaquina-saveRelacionesWithConnection");}
	

			this.setProductoOrdenDetaProduMaquina(productoordendetaprodumaquina);

			if(ProductoOrdenDetaProduMaquinaLogicAdditional.validarSaveRelaciones(productoordendetaprodumaquina,this)) {

				ProductoOrdenDetaProduMaquinaLogicAdditional.updateRelacionesToSave(productoordendetaprodumaquina,this);

				if((productoordendetaprodumaquina.getIsNew()||productoordendetaprodumaquina.getIsChanged())&&!productoordendetaprodumaquina.getIsDeleted()) {
					this.saveProductoOrdenDetaProduMaquina();
					this.saveProductoOrdenDetaProduMaquinaRelacionesDetalles();

				} else if(productoordendetaprodumaquina.getIsDeleted()) {
					this.saveProductoOrdenDetaProduMaquinaRelacionesDetalles();
					this.saveProductoOrdenDetaProduMaquina();
				}

				ProductoOrdenDetaProduMaquinaLogicAdditional.updateRelacionesToSaveAfter(productoordendetaprodumaquina,this);

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
	
	
	private void saveProductoOrdenDetaProduMaquinaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProductoOrdenDetaProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMaquina(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoOrdenDetaProduMaquina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesRelationshipsOfProductoOrdenDetaProduMaquina(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

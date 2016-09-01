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
import com.bydan.erp.inventario.util.EstadoBodegaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoBodegaProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoBodegaProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoBodegaProducto;
//import com.bydan.erp.inventario.business.logic.EstadoBodegaProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoBodegaProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoBodegaProductoLogic.class);
	
	protected EstadoBodegaProductoDataAccess estadobodegaproductoDataAccess; 	
	protected EstadoBodegaProducto estadobodegaproducto;
	protected List<EstadoBodegaProducto> estadobodegaproductos;
	protected Object estadobodegaproductoObject;	
	protected List<Object> estadobodegaproductosObject;
	
	public static ClassValidator<EstadoBodegaProducto> estadobodegaproductoValidator = new ClassValidator<EstadoBodegaProducto>(EstadoBodegaProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  EstadoBodegaProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadobodegaproductoDataAccess = new EstadoBodegaProductoDataAccess();
			
			this.estadobodegaproductos= new ArrayList<EstadoBodegaProducto>();
			this.estadobodegaproducto= new EstadoBodegaProducto();
			
			this.estadobodegaproductoObject=new Object();
			this.estadobodegaproductosObject=new ArrayList<Object>();
				
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
			
			this.estadobodegaproductoDataAccess.setConnexionType(this.connexionType);
			this.estadobodegaproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoBodegaProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadobodegaproductoDataAccess = new EstadoBodegaProductoDataAccess();
			this.estadobodegaproductos= new ArrayList<EstadoBodegaProducto>();
			this.estadobodegaproducto= new EstadoBodegaProducto();
			this.estadobodegaproductoObject=new Object();
			this.estadobodegaproductosObject=new ArrayList<Object>();
			
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
			
			this.estadobodegaproductoDataAccess.setConnexionType(this.connexionType);
			this.estadobodegaproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoBodegaProducto getEstadoBodegaProducto() throws Exception {	
		//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToGet(estadobodegaproducto,this.datosCliente,this.arrDatoGeneral);
		//EstadoBodegaProductoLogicAdditional.updateEstadoBodegaProductoToGet(estadobodegaproducto,this.arrDatoGeneral);
		
		return estadobodegaproducto;
	}
		
	public void setEstadoBodegaProducto(EstadoBodegaProducto newEstadoBodegaProducto) {
		this.estadobodegaproducto = newEstadoBodegaProducto;
	}
	
	public EstadoBodegaProductoDataAccess getEstadoBodegaProductoDataAccess() {
		return estadobodegaproductoDataAccess;
	}
	
	public void setEstadoBodegaProductoDataAccess(EstadoBodegaProductoDataAccess newestadobodegaproductoDataAccess) {
		this.estadobodegaproductoDataAccess = newestadobodegaproductoDataAccess;
	}
	
	public List<EstadoBodegaProducto> getEstadoBodegaProductos() throws Exception {		
		this.quitarEstadoBodegaProductosNulos();
		
		//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToGets(estadobodegaproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoBodegaProducto estadobodegaproductoLocal: estadobodegaproductos ) {
			//EstadoBodegaProductoLogicAdditional.updateEstadoBodegaProductoToGet(estadobodegaproductoLocal,this.arrDatoGeneral);
		}
		
		return estadobodegaproductos;
	}
	
	public void setEstadoBodegaProductos(List<EstadoBodegaProducto> newEstadoBodegaProductos) {
		this.estadobodegaproductos = newEstadoBodegaProductos;
	}
	
	public Object getEstadoBodegaProductoObject() {	
		this.estadobodegaproductoObject=this.estadobodegaproductoDataAccess.getEntityObject();
		return this.estadobodegaproductoObject;
	}
		
	public void setEstadoBodegaProductoObject(Object newEstadoBodegaProductoObject) {
		this.estadobodegaproductoObject = newEstadoBodegaProductoObject;
	}
	
	public List<Object> getEstadoBodegaProductosObject() {		
		this.estadobodegaproductosObject=this.estadobodegaproductoDataAccess.getEntitiesObject();
		return this.estadobodegaproductosObject;
	}
		
	public void setEstadoBodegaProductosObject(List<Object> newEstadoBodegaProductosObject) {
		this.estadobodegaproductosObject = newEstadoBodegaProductosObject;
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
		
		if(this.estadobodegaproductoDataAccess!=null) {
			this.estadobodegaproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadobodegaproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadobodegaproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadobodegaproducto = new  EstadoBodegaProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadobodegaproducto=estadobodegaproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadobodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproducto);
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
		estadobodegaproducto = new  EstadoBodegaProducto();
		  		  
        try {
			
			estadobodegaproducto=estadobodegaproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadobodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadobodegaproducto = new  EstadoBodegaProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadobodegaproducto=estadobodegaproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadobodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproducto);
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
		estadobodegaproducto = new  EstadoBodegaProducto();
		  		  
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
		estadobodegaproducto = new  EstadoBodegaProducto();
		  		  
        try {
			
			estadobodegaproducto=estadobodegaproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadobodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadobodegaproducto = new  EstadoBodegaProducto();
		  		  
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
		estadobodegaproducto = new  EstadoBodegaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadobodegaproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadobodegaproducto = new  EstadoBodegaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadobodegaproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadobodegaproducto = new  EstadoBodegaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadobodegaproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadobodegaproducto = new  EstadoBodegaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadobodegaproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadobodegaproducto = new  EstadoBodegaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadobodegaproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadobodegaproducto = new  EstadoBodegaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadobodegaproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproductos=estadobodegaproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproductos);
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
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		  		  
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
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		  		  
        try {			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproductos=estadobodegaproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		  		  
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
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproductos=estadobodegaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproductos);
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
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		  		  
        try {
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproductos=estadobodegaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproductos);
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
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproductos=estadobodegaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproductos);
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
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproductos=estadobodegaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadobodegaproducto = new  EstadoBodegaProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproducto=estadobodegaproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproducto);
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
		estadobodegaproducto = new  EstadoBodegaProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproducto=estadobodegaproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoBodegaProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getTodosEstadoBodegaProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproductos=estadobodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproductos);
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
	
	public  void  getTodosEstadoBodegaProductos(String sFinalQuery,Pagination pagination)throws Exception {
		estadobodegaproductos = new  ArrayList<EstadoBodegaProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadobodegaproductos=estadobodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoBodegaProducto(estadobodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoBodegaProducto(EstadoBodegaProducto estadobodegaproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(estadobodegaproducto.getIsNew() || estadobodegaproducto.getIsChanged()) { 
			this.invalidValues = estadobodegaproductoValidator.getInvalidValues(estadobodegaproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadobodegaproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoBodegaProducto(List<EstadoBodegaProducto> EstadoBodegaProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoBodegaProducto estadobodegaproductoLocal:estadobodegaproductos) {				
			estaValidadoObjeto=this.validarGuardarEstadoBodegaProducto(estadobodegaproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoBodegaProducto(List<EstadoBodegaProducto> EstadoBodegaProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoBodegaProducto(estadobodegaproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoBodegaProducto(EstadoBodegaProducto EstadoBodegaProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoBodegaProducto(estadobodegaproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoBodegaProducto estadobodegaproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadobodegaproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoBodegaProductoConstantesFunciones.getEstadoBodegaProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadobodegaproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoBodegaProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoBodegaProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoBodegaProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-saveEstadoBodegaProductoWithConnection");connexion.begin();			
			
			//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToSave(this.estadobodegaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoBodegaProductoLogicAdditional.updateEstadoBodegaProductoToSave(this.estadobodegaproducto,this.arrDatoGeneral);
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadobodegaproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoBodegaProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoBodegaProducto(this.estadobodegaproducto)) {
				EstadoBodegaProductoDataAccess.save(this.estadobodegaproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadobodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToSaveAfter(this.estadobodegaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoBodegaProducto();
			
			connexion.commit();			
			
			if(this.estadobodegaproducto.getIsDeleted()) {
				this.estadobodegaproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoBodegaProducto()throws Exception {	
		try {	
			
			//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToSave(this.estadobodegaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoBodegaProductoLogicAdditional.updateEstadoBodegaProductoToSave(this.estadobodegaproducto,this.arrDatoGeneral);
			
			EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadobodegaproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoBodegaProducto(this.estadobodegaproducto)) {			
				EstadoBodegaProductoDataAccess.save(this.estadobodegaproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadobodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToSaveAfter(this.estadobodegaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadobodegaproducto.getIsDeleted()) {
				this.estadobodegaproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoBodegaProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-saveEstadoBodegaProductosWithConnection");connexion.begin();			
			
			//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToSaves(estadobodegaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoBodegaProductos();
			
			Boolean validadoTodosEstadoBodegaProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoBodegaProducto estadobodegaproductoLocal:estadobodegaproductos) {		
				if(estadobodegaproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoBodegaProductoLogicAdditional.updateEstadoBodegaProductoToSave(estadobodegaproductoLocal,this.arrDatoGeneral);
	        	
				EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadobodegaproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoBodegaProducto(estadobodegaproductoLocal)) {
					EstadoBodegaProductoDataAccess.save(estadobodegaproductoLocal, connexion);				
				} else {
					validadoTodosEstadoBodegaProducto=false;
				}
			}
			
			if(!validadoTodosEstadoBodegaProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToSavesAfter(estadobodegaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoBodegaProductos();
			
			connexion.commit();		
			
			this.quitarEstadoBodegaProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoBodegaProductos()throws Exception {				
		 try {	
			//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToSaves(estadobodegaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoBodegaProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoBodegaProducto estadobodegaproductoLocal:estadobodegaproductos) {				
				if(estadobodegaproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoBodegaProductoLogicAdditional.updateEstadoBodegaProductoToSave(estadobodegaproductoLocal,this.arrDatoGeneral);
	        	
				EstadoBodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadobodegaproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoBodegaProducto(estadobodegaproductoLocal)) {				
					EstadoBodegaProductoDataAccess.save(estadobodegaproductoLocal, connexion);				
				} else {
					validadoTodosEstadoBodegaProducto=false;
				}
			}
			
			if(!validadoTodosEstadoBodegaProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoBodegaProductoLogicAdditional.checkEstadoBodegaProductoToSavesAfter(estadobodegaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoBodegaProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoBodegaProductoParameterReturnGeneral procesarAccionEstadoBodegaProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoBodegaProducto> estadobodegaproductos,EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoParameterGeneral)throws Exception {
		 try {	
			EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoReturnGeneral=new EstadoBodegaProductoParameterReturnGeneral();
	
			
			return estadobodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoBodegaProductoParameterReturnGeneral procesarAccionEstadoBodegaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoBodegaProducto> estadobodegaproductos,EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-procesarAccionEstadoBodegaProductosWithConnection");connexion.begin();			
			
			EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoReturnGeneral=new EstadoBodegaProductoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadobodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoBodegaProductoParameterReturnGeneral procesarEventosEstadoBodegaProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoBodegaProducto> estadobodegaproductos,EstadoBodegaProducto estadobodegaproducto,EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoParameterGeneral,Boolean isEsNuevoEstadoBodegaProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoReturnGeneral=new EstadoBodegaProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadobodegaproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadobodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoBodegaProductoParameterReturnGeneral procesarEventosEstadoBodegaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoBodegaProducto> estadobodegaproductos,EstadoBodegaProducto estadobodegaproducto,EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoParameterGeneral,Boolean isEsNuevoEstadoBodegaProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-procesarEventosEstadoBodegaProductosWithConnection");connexion.begin();			
			
			EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoReturnGeneral=new EstadoBodegaProductoParameterReturnGeneral();
	
			estadobodegaproductoReturnGeneral.setEstadoBodegaProducto(estadobodegaproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadobodegaproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadobodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoBodegaProductoParameterReturnGeneral procesarImportacionEstadoBodegaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-procesarImportacionEstadoBodegaProductosWithConnection");connexion.begin();			
			
			EstadoBodegaProductoParameterReturnGeneral estadobodegaproductoReturnGeneral=new EstadoBodegaProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadobodegaproductos=new ArrayList<EstadoBodegaProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadobodegaproducto=new EstadoBodegaProducto();
				
				
				if(conColumnasBase) {this.estadobodegaproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadobodegaproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadobodegaproducto.setcodigo(arrColumnas[iColumn++]);
				this.estadobodegaproducto.setnombre(arrColumnas[iColumn++]);
				this.estadobodegaproducto.setes_defecto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.estadobodegaproductos.add(this.estadobodegaproducto);
			}
			
			this.saveEstadoBodegaProductos();
			
			this.connexion.commit();
			
			estadobodegaproductoReturnGeneral.setConRetornoEstaProcesado(true);
			estadobodegaproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadobodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoBodegaProductosEliminados() throws Exception {				
		
		List<EstadoBodegaProducto> estadobodegaproductosAux= new ArrayList<EstadoBodegaProducto>();
		
		for(EstadoBodegaProducto estadobodegaproducto:estadobodegaproductos) {
			if(!estadobodegaproducto.getIsDeleted()) {
				estadobodegaproductosAux.add(estadobodegaproducto);
			}
		}
		
		estadobodegaproductos=estadobodegaproductosAux;
	}
	
	public void quitarEstadoBodegaProductosNulos() throws Exception {				
		
		List<EstadoBodegaProducto> estadobodegaproductosAux= new ArrayList<EstadoBodegaProducto>();
		
		for(EstadoBodegaProducto estadobodegaproducto : this.estadobodegaproductos) {
			if(estadobodegaproducto==null) {
				estadobodegaproductosAux.add(estadobodegaproducto);
			}
		}
		
		//this.estadobodegaproductos=estadobodegaproductosAux;
		
		this.estadobodegaproductos.removeAll(estadobodegaproductosAux);
	}
	
	public void getSetVersionRowEstadoBodegaProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadobodegaproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadobodegaproducto.getIsDeleted() || (estadobodegaproducto.getIsChanged()&&!estadobodegaproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadobodegaproductoDataAccess.getSetVersionRowEstadoBodegaProducto(connexion,estadobodegaproducto.getId());
				
				if(!estadobodegaproducto.getVersionRow().equals(timestamp)) {	
					estadobodegaproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadobodegaproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoBodegaProducto()throws Exception {	
		
		if(estadobodegaproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadobodegaproducto.getIsDeleted() || (estadobodegaproducto.getIsChanged()&&!estadobodegaproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadobodegaproductoDataAccess.getSetVersionRowEstadoBodegaProducto(connexion,estadobodegaproducto.getId());
			
			try {							
				if(!estadobodegaproducto.getVersionRow().equals(timestamp)) {	
					estadobodegaproducto.setVersionRow(timestamp);
				}
				
				estadobodegaproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoBodegaProductosWithConnection()throws Exception {	
		if(estadobodegaproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoBodegaProducto estadobodegaproductoAux:estadobodegaproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadobodegaproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadobodegaproductoAux.getIsDeleted() || (estadobodegaproductoAux.getIsChanged()&&!estadobodegaproductoAux.getIsNew())) {
						
						timestamp=estadobodegaproductoDataAccess.getSetVersionRowEstadoBodegaProducto(connexion,estadobodegaproductoAux.getId());
						
						if(!estadobodegaproducto.getVersionRow().equals(timestamp)) {	
							estadobodegaproductoAux.setVersionRow(timestamp);
						}
								
						estadobodegaproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoBodegaProductos()throws Exception {	
		if(estadobodegaproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoBodegaProducto estadobodegaproductoAux:estadobodegaproductos) {
					if(estadobodegaproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadobodegaproductoAux.getIsDeleted() || (estadobodegaproductoAux.getIsChanged()&&!estadobodegaproductoAux.getIsNew())) {
						
						timestamp=estadobodegaproductoDataAccess.getSetVersionRowEstadoBodegaProducto(connexion,estadobodegaproductoAux.getId());
						
						if(!estadobodegaproductoAux.getVersionRow().equals(timestamp)) {	
							estadobodegaproductoAux.setVersionRow(timestamp);
						}
						
													
						estadobodegaproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(EstadoBodegaProducto estadobodegaproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoBodegaProductoLogicAdditional.updateEstadoBodegaProductoToGet(estadobodegaproducto,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoBodegaProducto estadobodegaproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoBodegaProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadobodegaproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(estadobodegaproducto);
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
			this.deepLoad(this.estadobodegaproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoBodegaProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadobodegaproductos!=null) {
				for(EstadoBodegaProducto estadobodegaproducto:estadobodegaproductos) {
					this.deepLoad(estadobodegaproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(estadobodegaproductos);
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
			if(estadobodegaproductos!=null) {
				for(EstadoBodegaProducto estadobodegaproducto:estadobodegaproductos) {
					this.deepLoad(estadobodegaproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(estadobodegaproductos);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoBodegaProductoPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoBodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoBodegaProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadobodegaproducto=estadobodegaproductoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadobodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproducto);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoBodegaProductoPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoBodegaProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadobodegaproducto=estadobodegaproductoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadobodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoBodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoBodegaProducto(this.estadobodegaproducto);
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
			if(EstadoBodegaProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoBodegaProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoBodegaProducto estadobodegaproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoBodegaProductoConstantesFunciones.ISCONAUDITORIA) {
				if(estadobodegaproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoBodegaProductoDataAccess.TABLENAME, estadobodegaproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoBodegaProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoBodegaProductoLogic.registrarAuditoriaDetallesEstadoBodegaProducto(connexion,estadobodegaproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadobodegaproducto.getIsDeleted()) {
					/*if(!estadobodegaproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoBodegaProductoDataAccess.TABLENAME, estadobodegaproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoBodegaProductoLogic.registrarAuditoriaDetallesEstadoBodegaProducto(connexion,estadobodegaproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoBodegaProductoDataAccess.TABLENAME, estadobodegaproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadobodegaproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoBodegaProductoDataAccess.TABLENAME, estadobodegaproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoBodegaProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoBodegaProductoLogic.registrarAuditoriaDetallesEstadoBodegaProducto(connexion,estadobodegaproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoBodegaProducto(Connexion connexion,EstadoBodegaProducto estadobodegaproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadobodegaproducto.getIsNew()||!estadobodegaproducto.getcodigo().equals(estadobodegaproducto.getEstadoBodegaProductoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadobodegaproducto.getEstadoBodegaProductoOriginal().getcodigo()!=null)
				{
					strValorActual=estadobodegaproducto.getEstadoBodegaProductoOriginal().getcodigo();
				}
				if(estadobodegaproducto.getcodigo()!=null)
				{
					strValorNuevo=estadobodegaproducto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoBodegaProductoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadobodegaproducto.getIsNew()||!estadobodegaproducto.getnombre().equals(estadobodegaproducto.getEstadoBodegaProductoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadobodegaproducto.getEstadoBodegaProductoOriginal().getnombre()!=null)
				{
					strValorActual=estadobodegaproducto.getEstadoBodegaProductoOriginal().getnombre();
				}
				if(estadobodegaproducto.getnombre()!=null)
				{
					strValorNuevo=estadobodegaproducto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoBodegaProductoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(estadobodegaproducto.getIsNew()||!estadobodegaproducto.getes_defecto().equals(estadobodegaproducto.getEstadoBodegaProductoOriginal().getes_defecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadobodegaproducto.getEstadoBodegaProductoOriginal().getes_defecto()!=null)
				{
					strValorActual=estadobodegaproducto.getEstadoBodegaProductoOriginal().getes_defecto().toString();
				}
				if(estadobodegaproducto.getes_defecto()!=null)
				{
					strValorNuevo=estadobodegaproducto.getes_defecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoBodegaProductoConstantesFunciones.ESDEFECTO,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoBodegaProductoConstantesFunciones.getClassesForeignKeysOfEstadoBodegaProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoBodegaProductoConstantesFunciones.getClassesRelationshipsOfEstadoBodegaProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

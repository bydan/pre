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
import com.bydan.erp.inventario.util.DetalleCodigoBarraProductoConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleCodigoBarraProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleCodigoBarraProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleCodigoBarraProducto;
import com.bydan.erp.inventario.business.logic.DetalleCodigoBarraProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleCodigoBarraProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleCodigoBarraProductoLogic.class);
	
	protected DetalleCodigoBarraProductoDataAccess detallecodigobarraproductoDataAccess; 	
	protected DetalleCodigoBarraProducto detallecodigobarraproducto;
	protected List<DetalleCodigoBarraProducto> detallecodigobarraproductos;
	protected Object detallecodigobarraproductoObject;	
	protected List<Object> detallecodigobarraproductosObject;
	
	public static ClassValidator<DetalleCodigoBarraProducto> detallecodigobarraproductoValidator = new ClassValidator<DetalleCodigoBarraProducto>(DetalleCodigoBarraProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleCodigoBarraProductoLogicAdditional detallecodigobarraproductoLogicAdditional=null;
	
	public DetalleCodigoBarraProductoLogicAdditional getDetalleCodigoBarraProductoLogicAdditional() {
		return this.detallecodigobarraproductoLogicAdditional;
	}
	
	public void setDetalleCodigoBarraProductoLogicAdditional(DetalleCodigoBarraProductoLogicAdditional detallecodigobarraproductoLogicAdditional) {
		try {
			this.detallecodigobarraproductoLogicAdditional=detallecodigobarraproductoLogicAdditional;
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
	
	
	
	
	public  DetalleCodigoBarraProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallecodigobarraproductoDataAccess = new DetalleCodigoBarraProductoDataAccess();
			
			this.detallecodigobarraproductos= new ArrayList<DetalleCodigoBarraProducto>();
			this.detallecodigobarraproducto= new DetalleCodigoBarraProducto();
			
			this.detallecodigobarraproductoObject=new Object();
			this.detallecodigobarraproductosObject=new ArrayList<Object>();
				
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
			
			this.detallecodigobarraproductoDataAccess.setConnexionType(this.connexionType);
			this.detallecodigobarraproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleCodigoBarraProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallecodigobarraproductoDataAccess = new DetalleCodigoBarraProductoDataAccess();
			this.detallecodigobarraproductos= new ArrayList<DetalleCodigoBarraProducto>();
			this.detallecodigobarraproducto= new DetalleCodigoBarraProducto();
			this.detallecodigobarraproductoObject=new Object();
			this.detallecodigobarraproductosObject=new ArrayList<Object>();
			
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
			
			this.detallecodigobarraproductoDataAccess.setConnexionType(this.connexionType);
			this.detallecodigobarraproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleCodigoBarraProducto getDetalleCodigoBarraProducto() throws Exception {	
		DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToGet(detallecodigobarraproducto,this.datosCliente,this.arrDatoGeneral);
		DetalleCodigoBarraProductoLogicAdditional.updateDetalleCodigoBarraProductoToGet(detallecodigobarraproducto,this.arrDatoGeneral);
		
		return detallecodigobarraproducto;
	}
		
	public void setDetalleCodigoBarraProducto(DetalleCodigoBarraProducto newDetalleCodigoBarraProducto) {
		this.detallecodigobarraproducto = newDetalleCodigoBarraProducto;
	}
	
	public DetalleCodigoBarraProductoDataAccess getDetalleCodigoBarraProductoDataAccess() {
		return detallecodigobarraproductoDataAccess;
	}
	
	public void setDetalleCodigoBarraProductoDataAccess(DetalleCodigoBarraProductoDataAccess newdetallecodigobarraproductoDataAccess) {
		this.detallecodigobarraproductoDataAccess = newdetallecodigobarraproductoDataAccess;
	}
	
	public List<DetalleCodigoBarraProducto> getDetalleCodigoBarraProductos() throws Exception {		
		this.quitarDetalleCodigoBarraProductosNulos();
		
		DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToGets(detallecodigobarraproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleCodigoBarraProducto detallecodigobarraproductoLocal: detallecodigobarraproductos ) {
			DetalleCodigoBarraProductoLogicAdditional.updateDetalleCodigoBarraProductoToGet(detallecodigobarraproductoLocal,this.arrDatoGeneral);
		}
		
		return detallecodigobarraproductos;
	}
	
	public void setDetalleCodigoBarraProductos(List<DetalleCodigoBarraProducto> newDetalleCodigoBarraProductos) {
		this.detallecodigobarraproductos = newDetalleCodigoBarraProductos;
	}
	
	public Object getDetalleCodigoBarraProductoObject() {	
		this.detallecodigobarraproductoObject=this.detallecodigobarraproductoDataAccess.getEntityObject();
		return this.detallecodigobarraproductoObject;
	}
		
	public void setDetalleCodigoBarraProductoObject(Object newDetalleCodigoBarraProductoObject) {
		this.detallecodigobarraproductoObject = newDetalleCodigoBarraProductoObject;
	}
	
	public List<Object> getDetalleCodigoBarraProductosObject() {		
		this.detallecodigobarraproductosObject=this.detallecodigobarraproductoDataAccess.getEntitiesObject();
		return this.detallecodigobarraproductosObject;
	}
		
	public void setDetalleCodigoBarraProductosObject(List<Object> newDetalleCodigoBarraProductosObject) {
		this.detallecodigobarraproductosObject = newDetalleCodigoBarraProductosObject;
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
		
		if(this.detallecodigobarraproductoDataAccess!=null) {
			this.detallecodigobarraproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallecodigobarraproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallecodigobarraproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecodigobarraproducto=detallecodigobarraproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecodigobarraproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproducto);
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
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		  		  
        try {
			
			detallecodigobarraproducto=detallecodigobarraproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecodigobarraproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecodigobarraproducto=detallecodigobarraproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecodigobarraproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproducto);
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
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		  		  
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
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		  		  
        try {
			
			detallecodigobarraproducto=detallecodigobarraproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecodigobarraproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		  		  
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
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallecodigobarraproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallecodigobarraproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallecodigobarraproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallecodigobarraproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallecodigobarraproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallecodigobarraproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
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
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		  		  
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
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		  		  
        try {			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		  		  
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
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
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
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		  		  
        try {
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
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
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
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
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproducto=detallecodigobarraproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproducto);
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
		detallecodigobarraproducto = new  DetalleCodigoBarraProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproducto=detallecodigobarraproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
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
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		  		  
        try {
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleCodigoBarraProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getTodosDetalleCodigoBarraProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
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
	
	public  void  getTodosDetalleCodigoBarraProductos(String sFinalQuery,Pagination pagination)throws Exception {
		detallecodigobarraproductos = new  ArrayList<DetalleCodigoBarraProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCodigoBarraProducto(detallecodigobarraproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleCodigoBarraProducto(DetalleCodigoBarraProducto detallecodigobarraproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(detallecodigobarraproducto.getIsNew() || detallecodigobarraproducto.getIsChanged()) { 
			this.invalidValues = detallecodigobarraproductoValidator.getInvalidValues(detallecodigobarraproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallecodigobarraproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleCodigoBarraProducto(List<DetalleCodigoBarraProducto> DetalleCodigoBarraProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleCodigoBarraProducto detallecodigobarraproductoLocal:detallecodigobarraproductos) {				
			estaValidadoObjeto=this.validarGuardarDetalleCodigoBarraProducto(detallecodigobarraproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleCodigoBarraProducto(List<DetalleCodigoBarraProducto> DetalleCodigoBarraProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCodigoBarraProducto(detallecodigobarraproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleCodigoBarraProducto(DetalleCodigoBarraProducto DetalleCodigoBarraProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCodigoBarraProducto(detallecodigobarraproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleCodigoBarraProducto detallecodigobarraproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallecodigobarraproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleCodigoBarraProductoConstantesFunciones.getDetalleCodigoBarraProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallecodigobarraproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleCodigoBarraProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleCodigoBarraProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleCodigoBarraProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-saveDetalleCodigoBarraProductoWithConnection");connexion.begin();			
			
			DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToSave(this.detallecodigobarraproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleCodigoBarraProductoLogicAdditional.updateDetalleCodigoBarraProductoToSave(this.detallecodigobarraproducto,this.arrDatoGeneral);
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecodigobarraproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleCodigoBarraProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCodigoBarraProducto(this.detallecodigobarraproducto)) {
				DetalleCodigoBarraProductoDataAccess.save(this.detallecodigobarraproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallecodigobarraproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToSaveAfter(this.detallecodigobarraproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleCodigoBarraProducto();
			
			connexion.commit();			
			
			if(this.detallecodigobarraproducto.getIsDeleted()) {
				this.detallecodigobarraproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleCodigoBarraProducto()throws Exception {	
		try {	
			
			DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToSave(this.detallecodigobarraproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleCodigoBarraProductoLogicAdditional.updateDetalleCodigoBarraProductoToSave(this.detallecodigobarraproducto,this.arrDatoGeneral);
			
			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecodigobarraproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCodigoBarraProducto(this.detallecodigobarraproducto)) {			
				DetalleCodigoBarraProductoDataAccess.save(this.detallecodigobarraproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallecodigobarraproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToSaveAfter(this.detallecodigobarraproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallecodigobarraproducto.getIsDeleted()) {
				this.detallecodigobarraproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleCodigoBarraProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-saveDetalleCodigoBarraProductosWithConnection");connexion.begin();			
			
			DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToSaves(detallecodigobarraproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleCodigoBarraProductos();
			
			Boolean validadoTodosDetalleCodigoBarraProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCodigoBarraProducto detallecodigobarraproductoLocal:detallecodigobarraproductos) {		
				if(detallecodigobarraproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleCodigoBarraProductoLogicAdditional.updateDetalleCodigoBarraProductoToSave(detallecodigobarraproductoLocal,this.arrDatoGeneral);
	        	
				DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallecodigobarraproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCodigoBarraProducto(detallecodigobarraproductoLocal)) {
					DetalleCodigoBarraProductoDataAccess.save(detallecodigobarraproductoLocal, connexion);				
				} else {
					validadoTodosDetalleCodigoBarraProducto=false;
				}
			}
			
			if(!validadoTodosDetalleCodigoBarraProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToSavesAfter(detallecodigobarraproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleCodigoBarraProductos();
			
			connexion.commit();		
			
			this.quitarDetalleCodigoBarraProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleCodigoBarraProductos()throws Exception {				
		 try {	
			DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToSaves(detallecodigobarraproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleCodigoBarraProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCodigoBarraProducto detallecodigobarraproductoLocal:detallecodigobarraproductos) {				
				if(detallecodigobarraproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleCodigoBarraProductoLogicAdditional.updateDetalleCodigoBarraProductoToSave(detallecodigobarraproductoLocal,this.arrDatoGeneral);
	        	
				DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallecodigobarraproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCodigoBarraProducto(detallecodigobarraproductoLocal)) {				
					DetalleCodigoBarraProductoDataAccess.save(detallecodigobarraproductoLocal, connexion);				
				} else {
					validadoTodosDetalleCodigoBarraProducto=false;
				}
			}
			
			if(!validadoTodosDetalleCodigoBarraProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleCodigoBarraProductoLogicAdditional.checkDetalleCodigoBarraProductoToSavesAfter(detallecodigobarraproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleCodigoBarraProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleCodigoBarraProductoParameterReturnGeneral procesarAccionDetalleCodigoBarraProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCodigoBarraProducto> detallecodigobarraproductos,DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoParameterGeneral)throws Exception {
		 try {	
			DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoReturnGeneral=new DetalleCodigoBarraProductoParameterReturnGeneral();
	
			DetalleCodigoBarraProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallecodigobarraproductos,detallecodigobarraproductoParameterGeneral,detallecodigobarraproductoReturnGeneral);
			
			return detallecodigobarraproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleCodigoBarraProductoParameterReturnGeneral procesarAccionDetalleCodigoBarraProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCodigoBarraProducto> detallecodigobarraproductos,DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-procesarAccionDetalleCodigoBarraProductosWithConnection");connexion.begin();			
			
			DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoReturnGeneral=new DetalleCodigoBarraProductoParameterReturnGeneral();
	
			DetalleCodigoBarraProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallecodigobarraproductos,detallecodigobarraproductoParameterGeneral,detallecodigobarraproductoReturnGeneral);
			
			this.connexion.commit();
			
			return detallecodigobarraproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleCodigoBarraProductoParameterReturnGeneral procesarEventosDetalleCodigoBarraProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCodigoBarraProducto> detallecodigobarraproductos,DetalleCodigoBarraProducto detallecodigobarraproducto,DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoParameterGeneral,Boolean isEsNuevoDetalleCodigoBarraProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoReturnGeneral=new DetalleCodigoBarraProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallecodigobarraproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleCodigoBarraProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallecodigobarraproductos,detallecodigobarraproducto,detallecodigobarraproductoParameterGeneral,detallecodigobarraproductoReturnGeneral,isEsNuevoDetalleCodigoBarraProducto,clases);
			
			return detallecodigobarraproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleCodigoBarraProductoParameterReturnGeneral procesarEventosDetalleCodigoBarraProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCodigoBarraProducto> detallecodigobarraproductos,DetalleCodigoBarraProducto detallecodigobarraproducto,DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoParameterGeneral,Boolean isEsNuevoDetalleCodigoBarraProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-procesarEventosDetalleCodigoBarraProductosWithConnection");connexion.begin();			
			
			DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoReturnGeneral=new DetalleCodigoBarraProductoParameterReturnGeneral();
	
			detallecodigobarraproductoReturnGeneral.setDetalleCodigoBarraProducto(detallecodigobarraproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallecodigobarraproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleCodigoBarraProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallecodigobarraproductos,detallecodigobarraproducto,detallecodigobarraproductoParameterGeneral,detallecodigobarraproductoReturnGeneral,isEsNuevoDetalleCodigoBarraProducto,clases);
			
			this.connexion.commit();
			
			return detallecodigobarraproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleCodigoBarraProductoParameterReturnGeneral procesarImportacionDetalleCodigoBarraProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-procesarImportacionDetalleCodigoBarraProductosWithConnection");connexion.begin();			
			
			DetalleCodigoBarraProductoParameterReturnGeneral detallecodigobarraproductoReturnGeneral=new DetalleCodigoBarraProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallecodigobarraproductos=new ArrayList<DetalleCodigoBarraProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallecodigobarraproducto=new DetalleCodigoBarraProducto();
				
				
				if(conColumnasBase) {this.detallecodigobarraproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallecodigobarraproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallecodigobarraproducto.setcontrol(arrColumnas[iColumn++]);
				this.detallecodigobarraproducto.setmedicion(arrColumnas[iColumn++]);
				this.detallecodigobarraproducto.setvalor_anterior(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallecodigobarraproducto.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.detallecodigobarraproducto.setobservacion(arrColumnas[iColumn++]);
				
				this.detallecodigobarraproductos.add(this.detallecodigobarraproducto);
			}
			
			this.saveDetalleCodigoBarraProductos();
			
			this.connexion.commit();
			
			detallecodigobarraproductoReturnGeneral.setConRetornoEstaProcesado(true);
			detallecodigobarraproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallecodigobarraproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleCodigoBarraProductosEliminados() throws Exception {				
		
		List<DetalleCodigoBarraProducto> detallecodigobarraproductosAux= new ArrayList<DetalleCodigoBarraProducto>();
		
		for(DetalleCodigoBarraProducto detallecodigobarraproducto:detallecodigobarraproductos) {
			if(!detallecodigobarraproducto.getIsDeleted()) {
				detallecodigobarraproductosAux.add(detallecodigobarraproducto);
			}
		}
		
		detallecodigobarraproductos=detallecodigobarraproductosAux;
	}
	
	public void quitarDetalleCodigoBarraProductosNulos() throws Exception {				
		
		List<DetalleCodigoBarraProducto> detallecodigobarraproductosAux= new ArrayList<DetalleCodigoBarraProducto>();
		
		for(DetalleCodigoBarraProducto detallecodigobarraproducto : this.detallecodigobarraproductos) {
			if(detallecodigobarraproducto==null) {
				detallecodigobarraproductosAux.add(detallecodigobarraproducto);
			}
		}
		
		//this.detallecodigobarraproductos=detallecodigobarraproductosAux;
		
		this.detallecodigobarraproductos.removeAll(detallecodigobarraproductosAux);
	}
	
	public void getSetVersionRowDetalleCodigoBarraProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallecodigobarraproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallecodigobarraproducto.getIsDeleted() || (detallecodigobarraproducto.getIsChanged()&&!detallecodigobarraproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallecodigobarraproductoDataAccess.getSetVersionRowDetalleCodigoBarraProducto(connexion,detallecodigobarraproducto.getId());
				
				if(!detallecodigobarraproducto.getVersionRow().equals(timestamp)) {	
					detallecodigobarraproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallecodigobarraproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleCodigoBarraProducto()throws Exception {	
		
		if(detallecodigobarraproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallecodigobarraproducto.getIsDeleted() || (detallecodigobarraproducto.getIsChanged()&&!detallecodigobarraproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallecodigobarraproductoDataAccess.getSetVersionRowDetalleCodigoBarraProducto(connexion,detallecodigobarraproducto.getId());
			
			try {							
				if(!detallecodigobarraproducto.getVersionRow().equals(timestamp)) {	
					detallecodigobarraproducto.setVersionRow(timestamp);
				}
				
				detallecodigobarraproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleCodigoBarraProductosWithConnection()throws Exception {	
		if(detallecodigobarraproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleCodigoBarraProducto detallecodigobarraproductoAux:detallecodigobarraproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallecodigobarraproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallecodigobarraproductoAux.getIsDeleted() || (detallecodigobarraproductoAux.getIsChanged()&&!detallecodigobarraproductoAux.getIsNew())) {
						
						timestamp=detallecodigobarraproductoDataAccess.getSetVersionRowDetalleCodigoBarraProducto(connexion,detallecodigobarraproductoAux.getId());
						
						if(!detallecodigobarraproducto.getVersionRow().equals(timestamp)) {	
							detallecodigobarraproductoAux.setVersionRow(timestamp);
						}
								
						detallecodigobarraproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleCodigoBarraProductos()throws Exception {	
		if(detallecodigobarraproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleCodigoBarraProducto detallecodigobarraproductoAux:detallecodigobarraproductos) {
					if(detallecodigobarraproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallecodigobarraproductoAux.getIsDeleted() || (detallecodigobarraproductoAux.getIsChanged()&&!detallecodigobarraproductoAux.getIsNew())) {
						
						timestamp=detallecodigobarraproductoDataAccess.getSetVersionRowDetalleCodigoBarraProducto(connexion,detallecodigobarraproductoAux.getId());
						
						if(!detallecodigobarraproductoAux.getVersionRow().equals(timestamp)) {	
							detallecodigobarraproductoAux.setVersionRow(timestamp);
						}
						
													
						detallecodigobarraproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleCodigoBarraProductoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleCodigoBarraProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca) throws Exception {
		DetalleCodigoBarraProductoParameterReturnGeneral  detallecodigobarraproductoReturnGeneral =new DetalleCodigoBarraProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleCodigoBarraProductoWithConnection");connexion.begin();
			
			detallecodigobarraproductoReturnGeneral =new DetalleCodigoBarraProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallecodigobarraproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallecodigobarraproductoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallecodigobarraproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallecodigobarraproductoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallecodigobarraproductoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			detallecodigobarraproductoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			detallecodigobarraproductoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			detallecodigobarraproductoReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			detallecodigobarraproductoReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallecodigobarraproductoReturnGeneral;
	}
	
	public DetalleCodigoBarraProductoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleCodigoBarraProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca) throws Exception {
		DetalleCodigoBarraProductoParameterReturnGeneral  detallecodigobarraproductoReturnGeneral =new DetalleCodigoBarraProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallecodigobarraproductoReturnGeneral =new DetalleCodigoBarraProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallecodigobarraproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallecodigobarraproductoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallecodigobarraproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallecodigobarraproductoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallecodigobarraproductoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			detallecodigobarraproductoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			detallecodigobarraproductoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			detallecodigobarraproductoReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			detallecodigobarraproductoReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallecodigobarraproductoReturnGeneral;
	}
	
	
	public void deepLoad(DetalleCodigoBarraProducto detallecodigobarraproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleCodigoBarraProductoLogicAdditional.updateDetalleCodigoBarraProductoToGet(detallecodigobarraproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecodigobarraproducto.setEmpresa(detallecodigobarraproductoDataAccess.getEmpresa(connexion,detallecodigobarraproducto));
		detallecodigobarraproducto.setSucursal(detallecodigobarraproductoDataAccess.getSucursal(connexion,detallecodigobarraproducto));
		detallecodigobarraproducto.setBodega(detallecodigobarraproductoDataAccess.getBodega(connexion,detallecodigobarraproducto));
		detallecodigobarraproducto.setProducto(detallecodigobarraproductoDataAccess.getProducto(connexion,detallecodigobarraproducto));
		detallecodigobarraproducto.setUnidad(detallecodigobarraproductoDataAccess.getUnidad(connexion,detallecodigobarraproducto));
		detallecodigobarraproducto.setLinea(detallecodigobarraproductoDataAccess.getLinea(connexion,detallecodigobarraproducto));
		detallecodigobarraproducto.setLineaGrupo(detallecodigobarraproductoDataAccess.getLineaGrupo(connexion,detallecodigobarraproducto));
		detallecodigobarraproducto.setLineaCategoria(detallecodigobarraproductoDataAccess.getLineaCategoria(connexion,detallecodigobarraproducto));
		detallecodigobarraproducto.setLineaMarca(detallecodigobarraproductoDataAccess.getLineaMarca(connexion,detallecodigobarraproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallecodigobarraproducto.setEmpresa(detallecodigobarraproductoDataAccess.getEmpresa(connexion,detallecodigobarraproducto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallecodigobarraproducto.setSucursal(detallecodigobarraproductoDataAccess.getSucursal(connexion,detallecodigobarraproducto));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallecodigobarraproducto.setBodega(detallecodigobarraproductoDataAccess.getBodega(connexion,detallecodigobarraproducto));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallecodigobarraproducto.setProducto(detallecodigobarraproductoDataAccess.getProducto(connexion,detallecodigobarraproducto));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallecodigobarraproducto.setUnidad(detallecodigobarraproductoDataAccess.getUnidad(connexion,detallecodigobarraproducto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detallecodigobarraproducto.setLinea(detallecodigobarraproductoDataAccess.getLinea(connexion,detallecodigobarraproducto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detallecodigobarraproducto.setLineaGrupo(detallecodigobarraproductoDataAccess.getLineaGrupo(connexion,detallecodigobarraproducto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detallecodigobarraproducto.setLineaCategoria(detallecodigobarraproductoDataAccess.getLineaCategoria(connexion,detallecodigobarraproducto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detallecodigobarraproducto.setLineaMarca(detallecodigobarraproductoDataAccess.getLineaMarca(connexion,detallecodigobarraproducto));
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
			detallecodigobarraproducto.setEmpresa(detallecodigobarraproductoDataAccess.getEmpresa(connexion,detallecodigobarraproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setSucursal(detallecodigobarraproductoDataAccess.getSucursal(connexion,detallecodigobarraproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setBodega(detallecodigobarraproductoDataAccess.getBodega(connexion,detallecodigobarraproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setProducto(detallecodigobarraproductoDataAccess.getProducto(connexion,detallecodigobarraproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setUnidad(detallecodigobarraproductoDataAccess.getUnidad(connexion,detallecodigobarraproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setLinea(detallecodigobarraproductoDataAccess.getLinea(connexion,detallecodigobarraproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setLineaGrupo(detallecodigobarraproductoDataAccess.getLineaGrupo(connexion,detallecodigobarraproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setLineaCategoria(detallecodigobarraproductoDataAccess.getLineaCategoria(connexion,detallecodigobarraproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setLineaMarca(detallecodigobarraproductoDataAccess.getLineaMarca(connexion,detallecodigobarraproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecodigobarraproducto.setEmpresa(detallecodigobarraproductoDataAccess.getEmpresa(connexion,detallecodigobarraproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallecodigobarraproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallecodigobarraproducto.setSucursal(detallecodigobarraproductoDataAccess.getSucursal(connexion,detallecodigobarraproducto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallecodigobarraproducto.getSucursal(),isDeep,deepLoadType,clases);
				
		detallecodigobarraproducto.setBodega(detallecodigobarraproductoDataAccess.getBodega(connexion,detallecodigobarraproducto));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallecodigobarraproducto.getBodega(),isDeep,deepLoadType,clases);
				
		detallecodigobarraproducto.setProducto(detallecodigobarraproductoDataAccess.getProducto(connexion,detallecodigobarraproducto));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallecodigobarraproducto.getProducto(),isDeep,deepLoadType,clases);
				
		detallecodigobarraproducto.setUnidad(detallecodigobarraproductoDataAccess.getUnidad(connexion,detallecodigobarraproducto));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallecodigobarraproducto.getUnidad(),isDeep,deepLoadType,clases);
				
		detallecodigobarraproducto.setLinea(detallecodigobarraproductoDataAccess.getLinea(connexion,detallecodigobarraproducto));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(detallecodigobarraproducto.getLinea(),isDeep,deepLoadType,clases);
				
		detallecodigobarraproducto.setLineaGrupo(detallecodigobarraproductoDataAccess.getLineaGrupo(connexion,detallecodigobarraproducto));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(detallecodigobarraproducto.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		detallecodigobarraproducto.setLineaCategoria(detallecodigobarraproductoDataAccess.getLineaCategoria(connexion,detallecodigobarraproducto));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(detallecodigobarraproducto.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		detallecodigobarraproducto.setLineaMarca(detallecodigobarraproductoDataAccess.getLineaMarca(connexion,detallecodigobarraproducto));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(detallecodigobarraproducto.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallecodigobarraproducto.setEmpresa(detallecodigobarraproductoDataAccess.getEmpresa(connexion,detallecodigobarraproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallecodigobarraproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallecodigobarraproducto.setSucursal(detallecodigobarraproductoDataAccess.getSucursal(connexion,detallecodigobarraproducto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallecodigobarraproducto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallecodigobarraproducto.setBodega(detallecodigobarraproductoDataAccess.getBodega(connexion,detallecodigobarraproducto));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallecodigobarraproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallecodigobarraproducto.setProducto(detallecodigobarraproductoDataAccess.getProducto(connexion,detallecodigobarraproducto));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallecodigobarraproducto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallecodigobarraproducto.setUnidad(detallecodigobarraproductoDataAccess.getUnidad(connexion,detallecodigobarraproducto));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallecodigobarraproducto.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detallecodigobarraproducto.setLinea(detallecodigobarraproductoDataAccess.getLinea(connexion,detallecodigobarraproducto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(detallecodigobarraproducto.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detallecodigobarraproducto.setLineaGrupo(detallecodigobarraproductoDataAccess.getLineaGrupo(connexion,detallecodigobarraproducto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(detallecodigobarraproducto.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detallecodigobarraproducto.setLineaCategoria(detallecodigobarraproductoDataAccess.getLineaCategoria(connexion,detallecodigobarraproducto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(detallecodigobarraproducto.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detallecodigobarraproducto.setLineaMarca(detallecodigobarraproductoDataAccess.getLineaMarca(connexion,detallecodigobarraproducto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(detallecodigobarraproducto.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			detallecodigobarraproducto.setEmpresa(detallecodigobarraproductoDataAccess.getEmpresa(connexion,detallecodigobarraproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallecodigobarraproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setSucursal(detallecodigobarraproductoDataAccess.getSucursal(connexion,detallecodigobarraproducto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallecodigobarraproducto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setBodega(detallecodigobarraproductoDataAccess.getBodega(connexion,detallecodigobarraproducto));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallecodigobarraproducto.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setProducto(detallecodigobarraproductoDataAccess.getProducto(connexion,detallecodigobarraproducto));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallecodigobarraproducto.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setUnidad(detallecodigobarraproductoDataAccess.getUnidad(connexion,detallecodigobarraproducto));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallecodigobarraproducto.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setLinea(detallecodigobarraproductoDataAccess.getLinea(connexion,detallecodigobarraproducto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(detallecodigobarraproducto.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setLineaGrupo(detallecodigobarraproductoDataAccess.getLineaGrupo(connexion,detallecodigobarraproducto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(detallecodigobarraproducto.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setLineaCategoria(detallecodigobarraproductoDataAccess.getLineaCategoria(connexion,detallecodigobarraproducto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(detallecodigobarraproducto.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecodigobarraproducto.setLineaMarca(detallecodigobarraproductoDataAccess.getLineaMarca(connexion,detallecodigobarraproducto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(detallecodigobarraproducto.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleCodigoBarraProducto detallecodigobarraproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleCodigoBarraProductoLogicAdditional.updateDetalleCodigoBarraProductoToSave(detallecodigobarraproducto,this.arrDatoGeneral);
			
DetalleCodigoBarraProductoDataAccess.save(detallecodigobarraproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallecodigobarraproducto.getEmpresa(),connexion);

		SucursalDataAccess.save(detallecodigobarraproducto.getSucursal(),connexion);

		BodegaDataAccess.save(detallecodigobarraproducto.getBodega(),connexion);

		ProductoDataAccess.save(detallecodigobarraproducto.getProducto(),connexion);

		UnidadDataAccess.save(detallecodigobarraproducto.getUnidad(),connexion);

		LineaDataAccess.save(detallecodigobarraproducto.getLinea(),connexion);

		LineaDataAccess.save(detallecodigobarraproducto.getLineaGrupo(),connexion);

		LineaDataAccess.save(detallecodigobarraproducto.getLineaCategoria(),connexion);

		LineaDataAccess.save(detallecodigobarraproducto.getLineaMarca(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallecodigobarraproducto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallecodigobarraproducto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallecodigobarraproducto.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallecodigobarraproducto.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallecodigobarraproducto.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detallecodigobarraproducto.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detallecodigobarraproducto.getLineaGrupo(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detallecodigobarraproducto.getLineaCategoria(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detallecodigobarraproducto.getLineaMarca(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallecodigobarraproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallecodigobarraproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallecodigobarraproducto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallecodigobarraproducto.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallecodigobarraproducto.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallecodigobarraproducto.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallecodigobarraproducto.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallecodigobarraproducto.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallecodigobarraproducto.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallecodigobarraproducto.getUnidad(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(detallecodigobarraproducto.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(detallecodigobarraproducto.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(detallecodigobarraproducto.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(detallecodigobarraproducto.getLineaGrupo(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(detallecodigobarraproducto.getLineaCategoria(),connexion);
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(detallecodigobarraproducto.getLineaCategoria(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(detallecodigobarraproducto.getLineaMarca(),connexion);
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(detallecodigobarraproducto.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallecodigobarraproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallecodigobarraproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallecodigobarraproducto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallecodigobarraproducto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallecodigobarraproducto.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallecodigobarraproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallecodigobarraproducto.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallecodigobarraproducto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallecodigobarraproducto.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallecodigobarraproducto.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detallecodigobarraproducto.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(detallecodigobarraproducto.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detallecodigobarraproducto.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(detallecodigobarraproducto.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detallecodigobarraproducto.getLineaCategoria(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(detallecodigobarraproducto.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detallecodigobarraproducto.getLineaMarca(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(detallecodigobarraproducto.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleCodigoBarraProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallecodigobarraproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(detallecodigobarraproducto);
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
			this.deepLoad(this.detallecodigobarraproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleCodigoBarraProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallecodigobarraproductos!=null) {
				for(DetalleCodigoBarraProducto detallecodigobarraproducto:detallecodigobarraproductos) {
					this.deepLoad(detallecodigobarraproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(detallecodigobarraproductos);
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
			if(detallecodigobarraproductos!=null) {
				for(DetalleCodigoBarraProducto detallecodigobarraproducto:detallecodigobarraproductos) {
					this.deepLoad(detallecodigobarraproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(detallecodigobarraproductos);
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
			this.getNewConnexionToDeep(DetalleCodigoBarraProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallecodigobarraproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleCodigoBarraProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallecodigobarraproductos!=null) {
				for(DetalleCodigoBarraProducto detallecodigobarraproducto:detallecodigobarraproductos) {
					this.deepSave(detallecodigobarraproducto,isDeep,deepLoadType,clases);
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
			if(detallecodigobarraproductos!=null) {
				for(DetalleCodigoBarraProducto detallecodigobarraproducto:detallecodigobarraproductos) {
					this.deepSave(detallecodigobarraproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleCodigoBarraProductosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,DetalleCodigoBarraProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,DetalleCodigoBarraProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdLineaCategoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdLineaCategoria(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdLineaMarcaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdLineaMarca(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCodigoBarraProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCodigoBarraProductosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleCodigoBarraProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecodigobarraproductos=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCodigoBarraProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(this.detallecodigobarraproductos);
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
			if(DetalleCodigoBarraProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCodigoBarraProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleCodigoBarraProducto detallecodigobarraproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleCodigoBarraProductoConstantesFunciones.ISCONAUDITORIA) {
				if(detallecodigobarraproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCodigoBarraProductoDataAccess.TABLENAME, detallecodigobarraproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleCodigoBarraProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleCodigoBarraProductoLogic.registrarAuditoriaDetallesDetalleCodigoBarraProducto(connexion,detallecodigobarraproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallecodigobarraproducto.getIsDeleted()) {
					/*if(!detallecodigobarraproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleCodigoBarraProductoDataAccess.TABLENAME, detallecodigobarraproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleCodigoBarraProductoLogic.registrarAuditoriaDetallesDetalleCodigoBarraProducto(connexion,detallecodigobarraproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCodigoBarraProductoDataAccess.TABLENAME, detallecodigobarraproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallecodigobarraproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCodigoBarraProductoDataAccess.TABLENAME, detallecodigobarraproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleCodigoBarraProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleCodigoBarraProductoLogic.registrarAuditoriaDetallesDetalleCodigoBarraProducto(connexion,detallecodigobarraproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleCodigoBarraProducto(Connexion connexion,DetalleCodigoBarraProducto detallecodigobarraproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getid_empresa().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_empresa().toString();
				}
				if(detallecodigobarraproducto.getid_empresa()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getid_sucursal().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_sucursal().toString();
				}
				if(detallecodigobarraproducto.getid_sucursal()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getid_bodega().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_bodega()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_bodega().toString();
				}
				if(detallecodigobarraproducto.getid_bodega()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getid_producto().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_producto()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_producto().toString();
				}
				if(detallecodigobarraproducto.getid_producto()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getid_unidad().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_unidad()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_unidad().toString();
				}
				if(detallecodigobarraproducto.getid_unidad()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getid_linea().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea().toString();
				}
				if(detallecodigobarraproducto.getid_linea()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getid_linea_grupo().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea_grupo().toString();
				}
				if(detallecodigobarraproducto.getid_linea_grupo()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getid_linea_categoria().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea_categoria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea_categoria()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea_categoria().toString();
				}
				if(detallecodigobarraproducto.getid_linea_categoria()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getid_linea_categoria().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getid_linea_marca().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea_marca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea_marca()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getid_linea_marca().toString();
				}
				if(detallecodigobarraproducto.getid_linea_marca()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getid_linea_marca().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getcontrol().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getcontrol()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getcontrol()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getcontrol();
				}
				if(detallecodigobarraproducto.getcontrol()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getcontrol() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.CONTROL,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getmedicion().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getmedicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getmedicion()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getmedicion();
				}
				if(detallecodigobarraproducto.getmedicion()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getmedicion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.MEDICION,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getvalor_anterior().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getvalor_anterior()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getvalor_anterior()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getvalor_anterior().toString();
				}
				if(detallecodigobarraproducto.getvalor_anterior()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getvalor_anterior().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getfecha().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getfecha()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getfecha().toString();
				}
				if(detallecodigobarraproducto.getfecha()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(detallecodigobarraproducto.getIsNew()||!detallecodigobarraproducto.getobservacion().equals(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getobservacion()!=null)
				{
					strValorActual=detallecodigobarraproducto.getDetalleCodigoBarraProductoOriginal().getobservacion();
				}
				if(detallecodigobarraproducto.getobservacion()!=null)
				{
					strValorNuevo=detallecodigobarraproducto.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleCodigoBarraProductoRelacionesWithConnection(DetalleCodigoBarraProducto detallecodigobarraproducto) throws Exception {

		if(!detallecodigobarraproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleCodigoBarraProductoRelacionesBase(detallecodigobarraproducto,true);
		}
	}

	public void saveDetalleCodigoBarraProductoRelaciones(DetalleCodigoBarraProducto detallecodigobarraproducto)throws Exception {

		if(!detallecodigobarraproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleCodigoBarraProductoRelacionesBase(detallecodigobarraproducto,false);
		}
	}

	public void saveDetalleCodigoBarraProductoRelacionesBase(DetalleCodigoBarraProducto detallecodigobarraproducto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleCodigoBarraProducto-saveRelacionesWithConnection");}
	

			this.setDetalleCodigoBarraProducto(detallecodigobarraproducto);

			if(DetalleCodigoBarraProductoLogicAdditional.validarSaveRelaciones(detallecodigobarraproducto,this)) {

				DetalleCodigoBarraProductoLogicAdditional.updateRelacionesToSave(detallecodigobarraproducto,this);

				if((detallecodigobarraproducto.getIsNew()||detallecodigobarraproducto.getIsChanged())&&!detallecodigobarraproducto.getIsDeleted()) {
					this.saveDetalleCodigoBarraProducto();
					this.saveDetalleCodigoBarraProductoRelacionesDetalles();

				} else if(detallecodigobarraproducto.getIsDeleted()) {
					this.saveDetalleCodigoBarraProductoRelacionesDetalles();
					this.saveDetalleCodigoBarraProducto();
				}

				DetalleCodigoBarraProductoLogicAdditional.updateRelacionesToSaveAfter(detallecodigobarraproducto,this);

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
	
	
	private void saveDetalleCodigoBarraProductoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCodigoBarraProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleCodigoBarraProductoConstantesFunciones.getClassesForeignKeysOfDetalleCodigoBarraProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCodigoBarraProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleCodigoBarraProductoConstantesFunciones.getClassesRelationshipsOfDetalleCodigoBarraProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

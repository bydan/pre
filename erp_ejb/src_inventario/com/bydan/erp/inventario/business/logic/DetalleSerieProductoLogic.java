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
import com.bydan.erp.inventario.util.DetalleSerieProductoConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleSerieProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleSerieProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleSerieProducto;
import com.bydan.erp.inventario.business.logic.DetalleSerieProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class DetalleSerieProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleSerieProductoLogic.class);
	
	protected DetalleSerieProductoDataAccess detalleserieproductoDataAccess; 	
	protected DetalleSerieProducto detalleserieproducto;
	protected List<DetalleSerieProducto> detalleserieproductos;
	protected Object detalleserieproductoObject;	
	protected List<Object> detalleserieproductosObject;
	
	public static ClassValidator<DetalleSerieProducto> detalleserieproductoValidator = new ClassValidator<DetalleSerieProducto>(DetalleSerieProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleSerieProductoLogicAdditional detalleserieproductoLogicAdditional=null;
	
	public DetalleSerieProductoLogicAdditional getDetalleSerieProductoLogicAdditional() {
		return this.detalleserieproductoLogicAdditional;
	}
	
	public void setDetalleSerieProductoLogicAdditional(DetalleSerieProductoLogicAdditional detalleserieproductoLogicAdditional) {
		try {
			this.detalleserieproductoLogicAdditional=detalleserieproductoLogicAdditional;
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
	
	
	
	
	public  DetalleSerieProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleserieproductoDataAccess = new DetalleSerieProductoDataAccess();
			
			this.detalleserieproductos= new ArrayList<DetalleSerieProducto>();
			this.detalleserieproducto= new DetalleSerieProducto();
			
			this.detalleserieproductoObject=new Object();
			this.detalleserieproductosObject=new ArrayList<Object>();
				
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
			
			this.detalleserieproductoDataAccess.setConnexionType(this.connexionType);
			this.detalleserieproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleSerieProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleserieproductoDataAccess = new DetalleSerieProductoDataAccess();
			this.detalleserieproductos= new ArrayList<DetalleSerieProducto>();
			this.detalleserieproducto= new DetalleSerieProducto();
			this.detalleserieproductoObject=new Object();
			this.detalleserieproductosObject=new ArrayList<Object>();
			
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
			
			this.detalleserieproductoDataAccess.setConnexionType(this.connexionType);
			this.detalleserieproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleSerieProducto getDetalleSerieProducto() throws Exception {	
		DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToGet(detalleserieproducto,this.datosCliente,this.arrDatoGeneral);
		DetalleSerieProductoLogicAdditional.updateDetalleSerieProductoToGet(detalleserieproducto,this.arrDatoGeneral);
		
		return detalleserieproducto;
	}
		
	public void setDetalleSerieProducto(DetalleSerieProducto newDetalleSerieProducto) {
		this.detalleserieproducto = newDetalleSerieProducto;
	}
	
	public DetalleSerieProductoDataAccess getDetalleSerieProductoDataAccess() {
		return detalleserieproductoDataAccess;
	}
	
	public void setDetalleSerieProductoDataAccess(DetalleSerieProductoDataAccess newdetalleserieproductoDataAccess) {
		this.detalleserieproductoDataAccess = newdetalleserieproductoDataAccess;
	}
	
	public List<DetalleSerieProducto> getDetalleSerieProductos() throws Exception {		
		this.quitarDetalleSerieProductosNulos();
		
		DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToGets(detalleserieproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleSerieProducto detalleserieproductoLocal: detalleserieproductos ) {
			DetalleSerieProductoLogicAdditional.updateDetalleSerieProductoToGet(detalleserieproductoLocal,this.arrDatoGeneral);
		}
		
		return detalleserieproductos;
	}
	
	public void setDetalleSerieProductos(List<DetalleSerieProducto> newDetalleSerieProductos) {
		this.detalleserieproductos = newDetalleSerieProductos;
	}
	
	public Object getDetalleSerieProductoObject() {	
		this.detalleserieproductoObject=this.detalleserieproductoDataAccess.getEntityObject();
		return this.detalleserieproductoObject;
	}
		
	public void setDetalleSerieProductoObject(Object newDetalleSerieProductoObject) {
		this.detalleserieproductoObject = newDetalleSerieProductoObject;
	}
	
	public List<Object> getDetalleSerieProductosObject() {		
		this.detalleserieproductosObject=this.detalleserieproductoDataAccess.getEntitiesObject();
		return this.detalleserieproductosObject;
	}
		
	public void setDetalleSerieProductosObject(List<Object> newDetalleSerieProductosObject) {
		this.detalleserieproductosObject = newDetalleSerieProductosObject;
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
		
		if(this.detalleserieproductoDataAccess!=null) {
			this.detalleserieproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleserieproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleserieproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleserieproducto = new  DetalleSerieProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleserieproducto=detalleserieproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleserieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproducto);
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
		detalleserieproducto = new  DetalleSerieProducto();
		  		  
        try {
			
			detalleserieproducto=detalleserieproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleserieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleserieproducto = new  DetalleSerieProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleserieproducto=detalleserieproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleserieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproducto);
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
		detalleserieproducto = new  DetalleSerieProducto();
		  		  
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
		detalleserieproducto = new  DetalleSerieProducto();
		  		  
        try {
			
			detalleserieproducto=detalleserieproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleserieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleserieproducto = new  DetalleSerieProducto();
		  		  
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
		detalleserieproducto = new  DetalleSerieProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleserieproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleserieproducto = new  DetalleSerieProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleserieproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleserieproducto = new  DetalleSerieProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleserieproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleserieproducto = new  DetalleSerieProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleserieproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleserieproducto = new  DetalleSerieProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleserieproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleserieproducto = new  DetalleSerieProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleserieproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
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
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		  		  
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
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		  		  
        try {			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		  		  
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
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
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
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		  		  
        try {
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
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
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
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
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleserieproducto = new  DetalleSerieProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproducto=detalleserieproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproducto);
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
		detalleserieproducto = new  DetalleSerieProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproducto=detalleserieproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
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
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		  		  
        try {
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleSerieProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getTodosDetalleSerieProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
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
	
	public  void  getTodosDetalleSerieProductos(String sFinalQuery,Pagination pagination)throws Exception {
		detalleserieproductos = new  ArrayList<DetalleSerieProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleSerieProducto(detalleserieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleSerieProducto(DetalleSerieProducto detalleserieproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleserieproducto.getIsNew() || detalleserieproducto.getIsChanged()) { 
			this.invalidValues = detalleserieproductoValidator.getInvalidValues(detalleserieproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleserieproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleSerieProducto(List<DetalleSerieProducto> DetalleSerieProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleSerieProducto detalleserieproductoLocal:detalleserieproductos) {				
			estaValidadoObjeto=this.validarGuardarDetalleSerieProducto(detalleserieproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleSerieProducto(List<DetalleSerieProducto> DetalleSerieProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleSerieProducto(detalleserieproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleSerieProducto(DetalleSerieProducto DetalleSerieProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleSerieProducto(detalleserieproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleSerieProducto detalleserieproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleserieproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleSerieProductoConstantesFunciones.getDetalleSerieProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleserieproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleSerieProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleSerieProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleSerieProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-saveDetalleSerieProductoWithConnection");connexion.begin();			
			
			DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToSave(this.detalleserieproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleSerieProductoLogicAdditional.updateDetalleSerieProductoToSave(this.detalleserieproducto,this.arrDatoGeneral);
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleserieproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleSerieProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleSerieProducto(this.detalleserieproducto)) {
				DetalleSerieProductoDataAccess.save(this.detalleserieproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleserieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToSaveAfter(this.detalleserieproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleSerieProducto();
			
			connexion.commit();			
			
			if(this.detalleserieproducto.getIsDeleted()) {
				this.detalleserieproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleSerieProducto()throws Exception {	
		try {	
			
			DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToSave(this.detalleserieproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleSerieProductoLogicAdditional.updateDetalleSerieProductoToSave(this.detalleserieproducto,this.arrDatoGeneral);
			
			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleserieproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleSerieProducto(this.detalleserieproducto)) {			
				DetalleSerieProductoDataAccess.save(this.detalleserieproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleserieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToSaveAfter(this.detalleserieproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleserieproducto.getIsDeleted()) {
				this.detalleserieproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleSerieProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-saveDetalleSerieProductosWithConnection");connexion.begin();			
			
			DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToSaves(detalleserieproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleSerieProductos();
			
			Boolean validadoTodosDetalleSerieProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleSerieProducto detalleserieproductoLocal:detalleserieproductos) {		
				if(detalleserieproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleSerieProductoLogicAdditional.updateDetalleSerieProductoToSave(detalleserieproductoLocal,this.arrDatoGeneral);
	        	
				DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleserieproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleSerieProducto(detalleserieproductoLocal)) {
					DetalleSerieProductoDataAccess.save(detalleserieproductoLocal, connexion);				
				} else {
					validadoTodosDetalleSerieProducto=false;
				}
			}
			
			if(!validadoTodosDetalleSerieProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToSavesAfter(detalleserieproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleSerieProductos();
			
			connexion.commit();		
			
			this.quitarDetalleSerieProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleSerieProductos()throws Exception {				
		 try {	
			DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToSaves(detalleserieproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleSerieProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleSerieProducto detalleserieproductoLocal:detalleserieproductos) {				
				if(detalleserieproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleSerieProductoLogicAdditional.updateDetalleSerieProductoToSave(detalleserieproductoLocal,this.arrDatoGeneral);
	        	
				DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleserieproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleSerieProducto(detalleserieproductoLocal)) {				
					DetalleSerieProductoDataAccess.save(detalleserieproductoLocal, connexion);				
				} else {
					validadoTodosDetalleSerieProducto=false;
				}
			}
			
			if(!validadoTodosDetalleSerieProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleSerieProductoLogicAdditional.checkDetalleSerieProductoToSavesAfter(detalleserieproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleSerieProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleSerieProductoParameterReturnGeneral procesarAccionDetalleSerieProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleSerieProducto> detalleserieproductos,DetalleSerieProductoParameterReturnGeneral detalleserieproductoParameterGeneral)throws Exception {
		 try {	
			DetalleSerieProductoParameterReturnGeneral detalleserieproductoReturnGeneral=new DetalleSerieProductoParameterReturnGeneral();
	
			DetalleSerieProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleserieproductos,detalleserieproductoParameterGeneral,detalleserieproductoReturnGeneral);
			
			return detalleserieproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleSerieProductoParameterReturnGeneral procesarAccionDetalleSerieProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleSerieProducto> detalleserieproductos,DetalleSerieProductoParameterReturnGeneral detalleserieproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-procesarAccionDetalleSerieProductosWithConnection");connexion.begin();			
			
			DetalleSerieProductoParameterReturnGeneral detalleserieproductoReturnGeneral=new DetalleSerieProductoParameterReturnGeneral();
	
			DetalleSerieProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleserieproductos,detalleserieproductoParameterGeneral,detalleserieproductoReturnGeneral);
			
			this.connexion.commit();
			
			return detalleserieproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleSerieProductoParameterReturnGeneral procesarEventosDetalleSerieProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleSerieProducto> detalleserieproductos,DetalleSerieProducto detalleserieproducto,DetalleSerieProductoParameterReturnGeneral detalleserieproductoParameterGeneral,Boolean isEsNuevoDetalleSerieProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleSerieProductoParameterReturnGeneral detalleserieproductoReturnGeneral=new DetalleSerieProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleserieproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleSerieProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleserieproductos,detalleserieproducto,detalleserieproductoParameterGeneral,detalleserieproductoReturnGeneral,isEsNuevoDetalleSerieProducto,clases);
			
			return detalleserieproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleSerieProductoParameterReturnGeneral procesarEventosDetalleSerieProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleSerieProducto> detalleserieproductos,DetalleSerieProducto detalleserieproducto,DetalleSerieProductoParameterReturnGeneral detalleserieproductoParameterGeneral,Boolean isEsNuevoDetalleSerieProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-procesarEventosDetalleSerieProductosWithConnection");connexion.begin();			
			
			DetalleSerieProductoParameterReturnGeneral detalleserieproductoReturnGeneral=new DetalleSerieProductoParameterReturnGeneral();
	
			detalleserieproductoReturnGeneral.setDetalleSerieProducto(detalleserieproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleserieproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleSerieProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleserieproductos,detalleserieproducto,detalleserieproductoParameterGeneral,detalleserieproductoReturnGeneral,isEsNuevoDetalleSerieProducto,clases);
			
			this.connexion.commit();
			
			return detalleserieproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleSerieProductoParameterReturnGeneral procesarImportacionDetalleSerieProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleSerieProductoParameterReturnGeneral detalleserieproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-procesarImportacionDetalleSerieProductosWithConnection");connexion.begin();			
			
			DetalleSerieProductoParameterReturnGeneral detalleserieproductoReturnGeneral=new DetalleSerieProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleserieproductos=new ArrayList<DetalleSerieProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleserieproducto=new DetalleSerieProducto();
				
				
				if(conColumnasBase) {this.detalleserieproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleserieproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleserieproducto.setnombre(arrColumnas[iColumn++]);
			this.detalleserieproducto.setdescripcion(arrColumnas[iColumn++]);
				
				this.detalleserieproductos.add(this.detalleserieproducto);
			}
			
			this.saveDetalleSerieProductos();
			
			this.connexion.commit();
			
			detalleserieproductoReturnGeneral.setConRetornoEstaProcesado(true);
			detalleserieproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleserieproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleSerieProductosEliminados() throws Exception {				
		
		List<DetalleSerieProducto> detalleserieproductosAux= new ArrayList<DetalleSerieProducto>();
		
		for(DetalleSerieProducto detalleserieproducto:detalleserieproductos) {
			if(!detalleserieproducto.getIsDeleted()) {
				detalleserieproductosAux.add(detalleserieproducto);
			}
		}
		
		detalleserieproductos=detalleserieproductosAux;
	}
	
	public void quitarDetalleSerieProductosNulos() throws Exception {				
		
		List<DetalleSerieProducto> detalleserieproductosAux= new ArrayList<DetalleSerieProducto>();
		
		for(DetalleSerieProducto detalleserieproducto : this.detalleserieproductos) {
			if(detalleserieproducto==null) {
				detalleserieproductosAux.add(detalleserieproducto);
			}
		}
		
		//this.detalleserieproductos=detalleserieproductosAux;
		
		this.detalleserieproductos.removeAll(detalleserieproductosAux);
	}
	
	public void getSetVersionRowDetalleSerieProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleserieproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleserieproducto.getIsDeleted() || (detalleserieproducto.getIsChanged()&&!detalleserieproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleserieproductoDataAccess.getSetVersionRowDetalleSerieProducto(connexion,detalleserieproducto.getId());
				
				if(!detalleserieproducto.getVersionRow().equals(timestamp)) {	
					detalleserieproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleserieproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleSerieProducto()throws Exception {	
		
		if(detalleserieproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleserieproducto.getIsDeleted() || (detalleserieproducto.getIsChanged()&&!detalleserieproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleserieproductoDataAccess.getSetVersionRowDetalleSerieProducto(connexion,detalleserieproducto.getId());
			
			try {							
				if(!detalleserieproducto.getVersionRow().equals(timestamp)) {	
					detalleserieproducto.setVersionRow(timestamp);
				}
				
				detalleserieproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleSerieProductosWithConnection()throws Exception {	
		if(detalleserieproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleSerieProducto detalleserieproductoAux:detalleserieproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleserieproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleserieproductoAux.getIsDeleted() || (detalleserieproductoAux.getIsChanged()&&!detalleserieproductoAux.getIsNew())) {
						
						timestamp=detalleserieproductoDataAccess.getSetVersionRowDetalleSerieProducto(connexion,detalleserieproductoAux.getId());
						
						if(!detalleserieproducto.getVersionRow().equals(timestamp)) {	
							detalleserieproductoAux.setVersionRow(timestamp);
						}
								
						detalleserieproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleSerieProductos()throws Exception {	
		if(detalleserieproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleSerieProducto detalleserieproductoAux:detalleserieproductos) {
					if(detalleserieproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleserieproductoAux.getIsDeleted() || (detalleserieproductoAux.getIsChanged()&&!detalleserieproductoAux.getIsNew())) {
						
						timestamp=detalleserieproductoDataAccess.getSetVersionRowDetalleSerieProducto(connexion,detalleserieproductoAux.getId());
						
						if(!detalleserieproductoAux.getVersionRow().equals(timestamp)) {	
							detalleserieproductoAux.setVersionRow(timestamp);
						}
						
													
						detalleserieproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleSerieProductoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleSerieProductoWithConnection(String finalQueryGlobalSerieProducto) throws Exception {
		DetalleSerieProductoParameterReturnGeneral  detalleserieproductoReturnGeneral =new DetalleSerieProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleSerieProductoWithConnection");connexion.begin();
			
			detalleserieproductoReturnGeneral =new DetalleSerieProductoParameterReturnGeneral();
			
			

			List<SerieProducto> serieproductosForeignKey=new ArrayList<SerieProducto>();
			SerieProductoLogic serieproductoLogic=new SerieProductoLogic();
			serieproductoLogic.setConnexion(this.connexion);
			serieproductoLogic.getSerieProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSerieProducto.equals("NONE")) {
				serieproductoLogic.getTodosSerieProductos(finalQueryGlobalSerieProducto,new Pagination());
				serieproductosForeignKey=serieproductoLogic.getSerieProductos();
			}

			detalleserieproductoReturnGeneral.setserieproductosForeignKey(serieproductosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleserieproductoReturnGeneral;
	}
	
	public DetalleSerieProductoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleSerieProducto(String finalQueryGlobalSerieProducto) throws Exception {
		DetalleSerieProductoParameterReturnGeneral  detalleserieproductoReturnGeneral =new DetalleSerieProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleserieproductoReturnGeneral =new DetalleSerieProductoParameterReturnGeneral();
			
			

			List<SerieProducto> serieproductosForeignKey=new ArrayList<SerieProducto>();
			SerieProductoLogic serieproductoLogic=new SerieProductoLogic();
			serieproductoLogic.setConnexion(this.connexion);
			serieproductoLogic.getSerieProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSerieProducto.equals("NONE")) {
				serieproductoLogic.getTodosSerieProductos(finalQueryGlobalSerieProducto,new Pagination());
				serieproductosForeignKey=serieproductoLogic.getSerieProductos();
			}

			detalleserieproductoReturnGeneral.setserieproductosForeignKey(serieproductosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleserieproductoReturnGeneral;
	}
	
	
	public void deepLoad(DetalleSerieProducto detalleserieproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleSerieProductoLogicAdditional.updateDetalleSerieProductoToGet(detalleserieproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleserieproducto.setSerieProducto(detalleserieproductoDataAccess.getSerieProducto(connexion,detalleserieproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(SerieProducto.class)) {
				detalleserieproducto.setSerieProducto(detalleserieproductoDataAccess.getSerieProducto(connexion,detalleserieproducto));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SerieProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserieproducto.setSerieProducto(detalleserieproductoDataAccess.getSerieProducto(connexion,detalleserieproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleserieproducto.setSerieProducto(detalleserieproductoDataAccess.getSerieProducto(connexion,detalleserieproducto));
		SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
		serieproductoLogic.deepLoad(detalleserieproducto.getSerieProducto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(SerieProducto.class)) {
				detalleserieproducto.setSerieProducto(detalleserieproductoDataAccess.getSerieProducto(connexion,detalleserieproducto));
				SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
				serieproductoLogic.deepLoad(detalleserieproducto.getSerieProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SerieProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserieproducto.setSerieProducto(detalleserieproductoDataAccess.getSerieProducto(connexion,detalleserieproducto));
			SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
			serieproductoLogic.deepLoad(detalleserieproducto.getSerieProducto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleSerieProducto detalleserieproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleSerieProductoLogicAdditional.updateDetalleSerieProductoToSave(detalleserieproducto,this.arrDatoGeneral);
			
DetalleSerieProductoDataAccess.save(detalleserieproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SerieProductoDataAccess.save(detalleserieproducto.getSerieProducto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(SerieProducto.class)) {
				SerieProductoDataAccess.save(detalleserieproducto.getSerieProducto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SerieProductoDataAccess.save(detalleserieproducto.getSerieProducto(),connexion);
		SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
		serieproductoLogic.deepLoad(detalleserieproducto.getSerieProducto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(SerieProducto.class)) {
				SerieProductoDataAccess.save(detalleserieproducto.getSerieProducto(),connexion);
				SerieProductoLogic serieproductoLogic= new SerieProductoLogic(connexion);
				serieproductoLogic.deepSave(detalleserieproducto.getSerieProducto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleSerieProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleserieproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(detalleserieproducto);
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
			this.deepLoad(this.detalleserieproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleSerieProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleserieproductos!=null) {
				for(DetalleSerieProducto detalleserieproducto:detalleserieproductos) {
					this.deepLoad(detalleserieproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(detalleserieproductos);
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
			if(detalleserieproductos!=null) {
				for(DetalleSerieProducto detalleserieproducto:detalleserieproductos) {
					this.deepLoad(detalleserieproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(detalleserieproductos);
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
			this.getNewConnexionToDeep(DetalleSerieProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleserieproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleSerieProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleserieproductos!=null) {
				for(DetalleSerieProducto detalleserieproducto:detalleserieproductos) {
					this.deepSave(detalleserieproducto,isDeep,deepLoadType,clases);
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
			if(detalleserieproductos!=null) {
				for(DetalleSerieProducto detalleserieproducto:detalleserieproductos) {
					this.deepSave(detalleserieproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleSerieProductosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",DetalleSerieProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleSerieProductosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",DetalleSerieProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleSerieProductosFK_IdSerieProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_serie_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleSerieProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSerieProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSerieProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_serie_producto,DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSerieProducto);

			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSerieProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleSerieProductosFK_IdSerieProducto(String sFinalQuery,Pagination pagination,Long id_serie_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSerieProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSerieProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_serie_producto,DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSerieProducto);

			DetalleSerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSerieProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserieproductos=detalleserieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(this.detalleserieproductos);
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
			if(DetalleSerieProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleSerieProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleSerieProducto detalleserieproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleSerieProductoConstantesFunciones.ISCONAUDITORIA) {
				if(detalleserieproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleSerieProductoDataAccess.TABLENAME, detalleserieproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleSerieProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleSerieProductoLogic.registrarAuditoriaDetallesDetalleSerieProducto(connexion,detalleserieproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleserieproducto.getIsDeleted()) {
					/*if(!detalleserieproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleSerieProductoDataAccess.TABLENAME, detalleserieproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleSerieProductoLogic.registrarAuditoriaDetallesDetalleSerieProducto(connexion,detalleserieproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleSerieProductoDataAccess.TABLENAME, detalleserieproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleserieproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleSerieProductoDataAccess.TABLENAME, detalleserieproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleSerieProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleSerieProductoLogic.registrarAuditoriaDetallesDetalleSerieProducto(connexion,detalleserieproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleSerieProducto(Connexion connexion,DetalleSerieProducto detalleserieproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleserieproducto.getIsNew()||!detalleserieproducto.getid_serie_producto().equals(detalleserieproducto.getDetalleSerieProductoOriginal().getid_serie_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserieproducto.getDetalleSerieProductoOriginal().getid_serie_producto()!=null)
				{
					strValorActual=detalleserieproducto.getDetalleSerieProductoOriginal().getid_serie_producto().toString();
				}
				if(detalleserieproducto.getid_serie_producto()!=null)
				{
					strValorNuevo=detalleserieproducto.getid_serie_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleserieproducto.getIsNew()||!detalleserieproducto.getnombre().equals(detalleserieproducto.getDetalleSerieProductoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserieproducto.getDetalleSerieProductoOriginal().getnombre()!=null)
				{
					strValorActual=detalleserieproducto.getDetalleSerieProductoOriginal().getnombre();
				}
				if(detalleserieproducto.getnombre()!=null)
				{
					strValorNuevo=detalleserieproducto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleSerieProductoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(detalleserieproducto.getIsNew()||!detalleserieproducto.getdescripcion().equals(detalleserieproducto.getDetalleSerieProductoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserieproducto.getDetalleSerieProductoOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleserieproducto.getDetalleSerieProductoOriginal().getdescripcion();
				}
				if(detalleserieproducto.getdescripcion()!=null)
				{
					strValorNuevo=detalleserieproducto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleSerieProductoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleSerieProductoRelacionesWithConnection(DetalleSerieProducto detalleserieproducto) throws Exception {

		if(!detalleserieproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleSerieProductoRelacionesBase(detalleserieproducto,true);
		}
	}

	public void saveDetalleSerieProductoRelaciones(DetalleSerieProducto detalleserieproducto)throws Exception {

		if(!detalleserieproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleSerieProductoRelacionesBase(detalleserieproducto,false);
		}
	}

	public void saveDetalleSerieProductoRelacionesBase(DetalleSerieProducto detalleserieproducto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleSerieProducto-saveRelacionesWithConnection");}
	

			this.setDetalleSerieProducto(detalleserieproducto);

			if(DetalleSerieProductoLogicAdditional.validarSaveRelaciones(detalleserieproducto,this)) {

				DetalleSerieProductoLogicAdditional.updateRelacionesToSave(detalleserieproducto,this);

				if((detalleserieproducto.getIsNew()||detalleserieproducto.getIsChanged())&&!detalleserieproducto.getIsDeleted()) {
					this.saveDetalleSerieProducto();
					this.saveDetalleSerieProductoRelacionesDetalles();

				} else if(detalleserieproducto.getIsDeleted()) {
					this.saveDetalleSerieProductoRelacionesDetalles();
					this.saveDetalleSerieProducto();
				}

				DetalleSerieProductoLogicAdditional.updateRelacionesToSaveAfter(detalleserieproducto,this);

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
	
	
	private void saveDetalleSerieProductoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleSerieProductoConstantesFunciones.getClassesForeignKeysOfDetalleSerieProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleSerieProductoConstantesFunciones.getClassesRelationshipsOfDetalleSerieProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

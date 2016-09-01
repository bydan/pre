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
import com.bydan.erp.inventario.util.ServicioConstantesFunciones;
import com.bydan.erp.inventario.util.ServicioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ServicioParameterGeneral;
import com.bydan.erp.inventario.business.entity.Servicio;
import com.bydan.erp.inventario.business.logic.ServicioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class ServicioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ServicioLogic.class);
	
	protected ServicioDataAccess servicioDataAccess; 	
	protected Servicio servicio;
	protected List<Servicio> servicios;
	protected Object servicioObject;	
	protected List<Object> serviciosObject;
	
	public static ClassValidator<Servicio> servicioValidator = new ClassValidator<Servicio>(Servicio.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ServicioLogicAdditional servicioLogicAdditional=null;
	
	public ServicioLogicAdditional getServicioLogicAdditional() {
		return this.servicioLogicAdditional;
	}
	
	public void setServicioLogicAdditional(ServicioLogicAdditional servicioLogicAdditional) {
		try {
			this.servicioLogicAdditional=servicioLogicAdditional;
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
	
	
	
	
	public  ServicioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.servicioDataAccess = new ServicioDataAccess();
			
			this.servicios= new ArrayList<Servicio>();
			this.servicio= new Servicio();
			
			this.servicioObject=new Object();
			this.serviciosObject=new ArrayList<Object>();
				
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
			
			this.servicioDataAccess.setConnexionType(this.connexionType);
			this.servicioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ServicioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.servicioDataAccess = new ServicioDataAccess();
			this.servicios= new ArrayList<Servicio>();
			this.servicio= new Servicio();
			this.servicioObject=new Object();
			this.serviciosObject=new ArrayList<Object>();
			
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
			
			this.servicioDataAccess.setConnexionType(this.connexionType);
			this.servicioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Servicio getServicio() throws Exception {	
		ServicioLogicAdditional.checkServicioToGet(servicio,this.datosCliente,this.arrDatoGeneral);
		ServicioLogicAdditional.updateServicioToGet(servicio,this.arrDatoGeneral);
		
		return servicio;
	}
		
	public void setServicio(Servicio newServicio) {
		this.servicio = newServicio;
	}
	
	public ServicioDataAccess getServicioDataAccess() {
		return servicioDataAccess;
	}
	
	public void setServicioDataAccess(ServicioDataAccess newservicioDataAccess) {
		this.servicioDataAccess = newservicioDataAccess;
	}
	
	public List<Servicio> getServicios() throws Exception {		
		this.quitarServiciosNulos();
		
		ServicioLogicAdditional.checkServicioToGets(servicios,this.datosCliente,this.arrDatoGeneral);
		
		for (Servicio servicioLocal: servicios ) {
			ServicioLogicAdditional.updateServicioToGet(servicioLocal,this.arrDatoGeneral);
		}
		
		return servicios;
	}
	
	public void setServicios(List<Servicio> newServicios) {
		this.servicios = newServicios;
	}
	
	public Object getServicioObject() {	
		this.servicioObject=this.servicioDataAccess.getEntityObject();
		return this.servicioObject;
	}
		
	public void setServicioObject(Object newServicioObject) {
		this.servicioObject = newServicioObject;
	}
	
	public List<Object> getServiciosObject() {		
		this.serviciosObject=this.servicioDataAccess.getEntitiesObject();
		return this.serviciosObject;
	}
		
	public void setServiciosObject(List<Object> newServiciosObject) {
		this.serviciosObject = newServiciosObject;
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
		
		if(this.servicioDataAccess!=null) {
			this.servicioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			servicioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			servicioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		servicio = new  Servicio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			servicio=servicioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.servicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicio);
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
		servicio = new  Servicio();
		  		  
        try {
			
			servicio=servicioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.servicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		servicio = new  Servicio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			servicio=servicioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.servicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicio);
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
		servicio = new  Servicio();
		  		  
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
		servicio = new  Servicio();
		  		  
        try {
			
			servicio=servicioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.servicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		servicio = new  Servicio();
		  		  
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
		servicio = new  Servicio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =servicioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		servicio = new  Servicio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=servicioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		servicio = new  Servicio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =servicioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		servicio = new  Servicio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=servicioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		servicio = new  Servicio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =servicioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		servicio = new  Servicio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=servicioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		servicios = new  ArrayList<Servicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
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
		servicios = new  ArrayList<Servicio>();
		  		  
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
		servicios = new  ArrayList<Servicio>();
		  		  
        try {			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		servicios = new  ArrayList<Servicio>();
		  		  
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
		servicios = new  ArrayList<Servicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
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
		servicios = new  ArrayList<Servicio>();
		  		  
        try {
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
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
		servicios = new  ArrayList<Servicio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
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
		servicios = new  ArrayList<Servicio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		servicio = new  Servicio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicio=servicioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarServicio(servicio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicio);
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
		servicio = new  Servicio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicio=servicioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarServicio(servicio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		servicios = new  ArrayList<Servicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
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
		servicios = new  ArrayList<Servicio>();
		  		  
        try {
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosServiciosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		servicios = new  ArrayList<Servicio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getTodosServiciosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
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
	
	public  void  getTodosServicios(String sFinalQuery,Pagination pagination)throws Exception {
		servicios = new  ArrayList<Servicio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarServicio(servicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarServicio(Servicio servicio) throws Exception {
		Boolean estaValidado=false;
		
		if(servicio.getIsNew() || servicio.getIsChanged()) { 
			this.invalidValues = servicioValidator.getInvalidValues(servicio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(servicio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarServicio(List<Servicio> Servicios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Servicio servicioLocal:servicios) {				
			estaValidadoObjeto=this.validarGuardarServicio(servicioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarServicio(List<Servicio> Servicios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarServicio(servicios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarServicio(Servicio Servicio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarServicio(servicio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Servicio servicio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+servicio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ServicioConstantesFunciones.getServicioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"servicio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ServicioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ServicioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveServicioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-saveServicioWithConnection");connexion.begin();			
			
			ServicioLogicAdditional.checkServicioToSave(this.servicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ServicioLogicAdditional.updateServicioToSave(this.servicio,this.arrDatoGeneral);
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.servicio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowServicio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarServicio(this.servicio)) {
				ServicioDataAccess.save(this.servicio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.servicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ServicioLogicAdditional.checkServicioToSaveAfter(this.servicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowServicio();
			
			connexion.commit();			
			
			if(this.servicio.getIsDeleted()) {
				this.servicio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveServicio()throws Exception {	
		try {	
			
			ServicioLogicAdditional.checkServicioToSave(this.servicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ServicioLogicAdditional.updateServicioToSave(this.servicio,this.arrDatoGeneral);
			
			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.servicio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarServicio(this.servicio)) {			
				ServicioDataAccess.save(this.servicio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.servicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ServicioLogicAdditional.checkServicioToSaveAfter(this.servicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.servicio.getIsDeleted()) {
				this.servicio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveServiciosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-saveServiciosWithConnection");connexion.begin();			
			
			ServicioLogicAdditional.checkServicioToSaves(servicios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowServicios();
			
			Boolean validadoTodosServicio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Servicio servicioLocal:servicios) {		
				if(servicioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ServicioLogicAdditional.updateServicioToSave(servicioLocal,this.arrDatoGeneral);
	        	
				ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),servicioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarServicio(servicioLocal)) {
					ServicioDataAccess.save(servicioLocal, connexion);				
				} else {
					validadoTodosServicio=false;
				}
			}
			
			if(!validadoTodosServicio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ServicioLogicAdditional.checkServicioToSavesAfter(servicios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowServicios();
			
			connexion.commit();		
			
			this.quitarServiciosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveServicios()throws Exception {				
		 try {	
			ServicioLogicAdditional.checkServicioToSaves(servicios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosServicio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Servicio servicioLocal:servicios) {				
				if(servicioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ServicioLogicAdditional.updateServicioToSave(servicioLocal,this.arrDatoGeneral);
	        	
				ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),servicioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarServicio(servicioLocal)) {				
					ServicioDataAccess.save(servicioLocal, connexion);				
				} else {
					validadoTodosServicio=false;
				}
			}
			
			if(!validadoTodosServicio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ServicioLogicAdditional.checkServicioToSavesAfter(servicios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarServiciosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ServicioParameterReturnGeneral procesarAccionServicios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Servicio> servicios,ServicioParameterReturnGeneral servicioParameterGeneral)throws Exception {
		 try {	
			ServicioParameterReturnGeneral servicioReturnGeneral=new ServicioParameterReturnGeneral();
	
			ServicioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,servicios,servicioParameterGeneral,servicioReturnGeneral);
			
			return servicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ServicioParameterReturnGeneral procesarAccionServiciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Servicio> servicios,ServicioParameterReturnGeneral servicioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-procesarAccionServiciosWithConnection");connexion.begin();			
			
			ServicioParameterReturnGeneral servicioReturnGeneral=new ServicioParameterReturnGeneral();
	
			ServicioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,servicios,servicioParameterGeneral,servicioReturnGeneral);
			
			this.connexion.commit();
			
			return servicioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ServicioParameterReturnGeneral procesarEventosServicios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Servicio> servicios,Servicio servicio,ServicioParameterReturnGeneral servicioParameterGeneral,Boolean isEsNuevoServicio,ArrayList<Classe> clases)throws Exception {
		 try {	
			ServicioParameterReturnGeneral servicioReturnGeneral=new ServicioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				servicioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ServicioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,servicios,servicio,servicioParameterGeneral,servicioReturnGeneral,isEsNuevoServicio,clases);
			
			return servicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ServicioParameterReturnGeneral procesarEventosServiciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Servicio> servicios,Servicio servicio,ServicioParameterReturnGeneral servicioParameterGeneral,Boolean isEsNuevoServicio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-procesarEventosServiciosWithConnection");connexion.begin();			
			
			ServicioParameterReturnGeneral servicioReturnGeneral=new ServicioParameterReturnGeneral();
	
			servicioReturnGeneral.setServicio(servicio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				servicioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ServicioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,servicios,servicio,servicioParameterGeneral,servicioReturnGeneral,isEsNuevoServicio,clases);
			
			this.connexion.commit();
			
			return servicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ServicioParameterReturnGeneral procesarImportacionServiciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ServicioParameterReturnGeneral servicioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-procesarImportacionServiciosWithConnection");connexion.begin();			
			
			ServicioParameterReturnGeneral servicioReturnGeneral=new ServicioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.servicios=new ArrayList<Servicio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.servicio=new Servicio();
				
				
				if(conColumnasBase) {this.servicio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.servicio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.servicio.setcodigo(arrColumnas[iColumn++]);
				this.servicio.setnombre(arrColumnas[iColumn++]);
				this.servicio.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.servicio.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.servicio.setes_bien(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.servicio.setdescripcion(arrColumnas[iColumn++]);
				
				this.servicios.add(this.servicio);
			}
			
			this.saveServicios();
			
			this.connexion.commit();
			
			servicioReturnGeneral.setConRetornoEstaProcesado(true);
			servicioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return servicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarServiciosEliminados() throws Exception {				
		
		List<Servicio> serviciosAux= new ArrayList<Servicio>();
		
		for(Servicio servicio:servicios) {
			if(!servicio.getIsDeleted()) {
				serviciosAux.add(servicio);
			}
		}
		
		servicios=serviciosAux;
	}
	
	public void quitarServiciosNulos() throws Exception {				
		
		List<Servicio> serviciosAux= new ArrayList<Servicio>();
		
		for(Servicio servicio : this.servicios) {
			if(servicio==null) {
				serviciosAux.add(servicio);
			}
		}
		
		//this.servicios=serviciosAux;
		
		this.servicios.removeAll(serviciosAux);
	}
	
	public void getSetVersionRowServicioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(servicio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((servicio.getIsDeleted() || (servicio.getIsChanged()&&!servicio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=servicioDataAccess.getSetVersionRowServicio(connexion,servicio.getId());
				
				if(!servicio.getVersionRow().equals(timestamp)) {	
					servicio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				servicio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowServicio()throws Exception {	
		
		if(servicio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((servicio.getIsDeleted() || (servicio.getIsChanged()&&!servicio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=servicioDataAccess.getSetVersionRowServicio(connexion,servicio.getId());
			
			try {							
				if(!servicio.getVersionRow().equals(timestamp)) {	
					servicio.setVersionRow(timestamp);
				}
				
				servicio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowServiciosWithConnection()throws Exception {	
		if(servicios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Servicio servicioAux:servicios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(servicioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(servicioAux.getIsDeleted() || (servicioAux.getIsChanged()&&!servicioAux.getIsNew())) {
						
						timestamp=servicioDataAccess.getSetVersionRowServicio(connexion,servicioAux.getId());
						
						if(!servicio.getVersionRow().equals(timestamp)) {	
							servicioAux.setVersionRow(timestamp);
						}
								
						servicioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowServicios()throws Exception {	
		if(servicios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Servicio servicioAux:servicios) {
					if(servicioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(servicioAux.getIsDeleted() || (servicioAux.getIsChanged()&&!servicioAux.getIsNew())) {
						
						timestamp=servicioDataAccess.getSetVersionRowServicio(connexion,servicioAux.getId());
						
						if(!servicioAux.getVersionRow().equals(timestamp)) {	
							servicioAux.setVersionRow(timestamp);
						}
						
													
						servicioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ServicioParameterReturnGeneral cargarCombosLoteForeignKeyServicioWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoServicio,String finalQueryGlobalEstadoServicio,String finalQueryGlobalCuentaContableGasto,String finalQueryGlobalCuentaContableFiscal,String finalQueryGlobalCuentaContableFiscal2,String finalQueryGlobalCuentaContableRetencion,String finalQueryGlobalCuentaContableRetencion2,String finalQueryGlobalCuentaContableIva,String finalQueryGlobalCuentaContableIva2,String finalQueryGlobalCuentaContableCredito) throws Exception {
		ServicioParameterReturnGeneral  servicioReturnGeneral =new ServicioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-cargarCombosLoteForeignKeyServicioWithConnection");connexion.begin();
			
			servicioReturnGeneral =new ServicioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			servicioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoServicio> tiposerviciosForeignKey=new ArrayList<TipoServicio>();
			TipoServicioLogic tiposervicioLogic=new TipoServicioLogic();
			tiposervicioLogic.setConnexion(this.connexion);
			tiposervicioLogic.getTipoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoServicio.equals("NONE")) {
				tiposervicioLogic.getTodosTipoServicios(finalQueryGlobalTipoServicio,new Pagination());
				tiposerviciosForeignKey=tiposervicioLogic.getTipoServicios();
			}

			servicioReturnGeneral.settiposerviciosForeignKey(tiposerviciosForeignKey);


			List<EstadoServicio> estadoserviciosForeignKey=new ArrayList<EstadoServicio>();
			EstadoServicioLogic estadoservicioLogic=new EstadoServicioLogic();
			estadoservicioLogic.setConnexion(this.connexion);
			//estadoservicioLogic.getEstadoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoServicio.equals("NONE")) {
				estadoservicioLogic.getTodosEstadoServicios(finalQueryGlobalEstadoServicio,new Pagination());
				estadoserviciosForeignKey=estadoservicioLogic.getEstadoServicios();
			}

			servicioReturnGeneral.setestadoserviciosForeignKey(estadoserviciosForeignKey);


			List<CuentaContable> cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegastoLogic=new CuentaContableLogic();
			cuentacontablegastoLogic.setConnexion(this.connexion);
			cuentacontablegastoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto.equals("NONE")) {
				cuentacontablegastoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto,new Pagination());
				cuentacontablegastosForeignKey=cuentacontablegastoLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontablegastosForeignKey(cuentacontablegastosForeignKey);


			List<CuentaContable> cuentacontablefiscalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefiscalLogic=new CuentaContableLogic();
			cuentacontablefiscalLogic.setConnexion(this.connexion);
			cuentacontablefiscalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFiscal.equals("NONE")) {
				cuentacontablefiscalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFiscal,new Pagination());
				cuentacontablefiscalsForeignKey=cuentacontablefiscalLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontablefiscalsForeignKey(cuentacontablefiscalsForeignKey);


			List<CuentaContable> cuentacontablefiscal2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefiscal2Logic=new CuentaContableLogic();
			cuentacontablefiscal2Logic.setConnexion(this.connexion);
			cuentacontablefiscal2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFiscal2.equals("NONE")) {
				cuentacontablefiscal2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableFiscal2,new Pagination());
				cuentacontablefiscal2sForeignKey=cuentacontablefiscal2Logic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontablefiscal2sForeignKey(cuentacontablefiscal2sForeignKey);


			List<CuentaContable> cuentacontableretencionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableretencionLogic=new CuentaContableLogic();
			cuentacontableretencionLogic.setConnexion(this.connexion);
			cuentacontableretencionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRetencion.equals("NONE")) {
				cuentacontableretencionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableRetencion,new Pagination());
				cuentacontableretencionsForeignKey=cuentacontableretencionLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontableretencionsForeignKey(cuentacontableretencionsForeignKey);


			List<CuentaContable> cuentacontableretencion2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableretencion2Logic=new CuentaContableLogic();
			cuentacontableretencion2Logic.setConnexion(this.connexion);
			cuentacontableretencion2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRetencion2.equals("NONE")) {
				cuentacontableretencion2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableRetencion2,new Pagination());
				cuentacontableretencion2sForeignKey=cuentacontableretencion2Logic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontableretencion2sForeignKey(cuentacontableretencion2sForeignKey);


			List<CuentaContable> cuentacontableivasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivaLogic=new CuentaContableLogic();
			cuentacontableivaLogic.setConnexion(this.connexion);
			cuentacontableivaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIva.equals("NONE")) {
				cuentacontableivaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIva,new Pagination());
				cuentacontableivasForeignKey=cuentacontableivaLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontableivasForeignKey(cuentacontableivasForeignKey);


			List<CuentaContable> cuentacontableiva2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableiva2Logic=new CuentaContableLogic();
			cuentacontableiva2Logic.setConnexion(this.connexion);
			cuentacontableiva2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIva2.equals("NONE")) {
				cuentacontableiva2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableIva2,new Pagination());
				cuentacontableiva2sForeignKey=cuentacontableiva2Logic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontableiva2sForeignKey(cuentacontableiva2sForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return servicioReturnGeneral;
	}
	
	public ServicioParameterReturnGeneral cargarCombosLoteForeignKeyServicio(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoServicio,String finalQueryGlobalEstadoServicio,String finalQueryGlobalCuentaContableGasto,String finalQueryGlobalCuentaContableFiscal,String finalQueryGlobalCuentaContableFiscal2,String finalQueryGlobalCuentaContableRetencion,String finalQueryGlobalCuentaContableRetencion2,String finalQueryGlobalCuentaContableIva,String finalQueryGlobalCuentaContableIva2,String finalQueryGlobalCuentaContableCredito) throws Exception {
		ServicioParameterReturnGeneral  servicioReturnGeneral =new ServicioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			servicioReturnGeneral =new ServicioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			servicioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoServicio> tiposerviciosForeignKey=new ArrayList<TipoServicio>();
			TipoServicioLogic tiposervicioLogic=new TipoServicioLogic();
			tiposervicioLogic.setConnexion(this.connexion);
			tiposervicioLogic.getTipoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoServicio.equals("NONE")) {
				tiposervicioLogic.getTodosTipoServicios(finalQueryGlobalTipoServicio,new Pagination());
				tiposerviciosForeignKey=tiposervicioLogic.getTipoServicios();
			}

			servicioReturnGeneral.settiposerviciosForeignKey(tiposerviciosForeignKey);


			List<EstadoServicio> estadoserviciosForeignKey=new ArrayList<EstadoServicio>();
			EstadoServicioLogic estadoservicioLogic=new EstadoServicioLogic();
			estadoservicioLogic.setConnexion(this.connexion);
			//estadoservicioLogic.getEstadoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoServicio.equals("NONE")) {
				estadoservicioLogic.getTodosEstadoServicios(finalQueryGlobalEstadoServicio,new Pagination());
				estadoserviciosForeignKey=estadoservicioLogic.getEstadoServicios();
			}

			servicioReturnGeneral.setestadoserviciosForeignKey(estadoserviciosForeignKey);


			List<CuentaContable> cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegastoLogic=new CuentaContableLogic();
			cuentacontablegastoLogic.setConnexion(this.connexion);
			cuentacontablegastoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto.equals("NONE")) {
				cuentacontablegastoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto,new Pagination());
				cuentacontablegastosForeignKey=cuentacontablegastoLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontablegastosForeignKey(cuentacontablegastosForeignKey);


			List<CuentaContable> cuentacontablefiscalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefiscalLogic=new CuentaContableLogic();
			cuentacontablefiscalLogic.setConnexion(this.connexion);
			cuentacontablefiscalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFiscal.equals("NONE")) {
				cuentacontablefiscalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFiscal,new Pagination());
				cuentacontablefiscalsForeignKey=cuentacontablefiscalLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontablefiscalsForeignKey(cuentacontablefiscalsForeignKey);


			List<CuentaContable> cuentacontablefiscal2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefiscal2Logic=new CuentaContableLogic();
			cuentacontablefiscal2Logic.setConnexion(this.connexion);
			cuentacontablefiscal2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFiscal2.equals("NONE")) {
				cuentacontablefiscal2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableFiscal2,new Pagination());
				cuentacontablefiscal2sForeignKey=cuentacontablefiscal2Logic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontablefiscal2sForeignKey(cuentacontablefiscal2sForeignKey);


			List<CuentaContable> cuentacontableretencionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableretencionLogic=new CuentaContableLogic();
			cuentacontableretencionLogic.setConnexion(this.connexion);
			cuentacontableretencionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRetencion.equals("NONE")) {
				cuentacontableretencionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableRetencion,new Pagination());
				cuentacontableretencionsForeignKey=cuentacontableretencionLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontableretencionsForeignKey(cuentacontableretencionsForeignKey);


			List<CuentaContable> cuentacontableretencion2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableretencion2Logic=new CuentaContableLogic();
			cuentacontableretencion2Logic.setConnexion(this.connexion);
			cuentacontableretencion2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRetencion2.equals("NONE")) {
				cuentacontableretencion2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableRetencion2,new Pagination());
				cuentacontableretencion2sForeignKey=cuentacontableretencion2Logic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontableretencion2sForeignKey(cuentacontableretencion2sForeignKey);


			List<CuentaContable> cuentacontableivasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivaLogic=new CuentaContableLogic();
			cuentacontableivaLogic.setConnexion(this.connexion);
			cuentacontableivaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIva.equals("NONE")) {
				cuentacontableivaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIva,new Pagination());
				cuentacontableivasForeignKey=cuentacontableivaLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontableivasForeignKey(cuentacontableivasForeignKey);


			List<CuentaContable> cuentacontableiva2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableiva2Logic=new CuentaContableLogic();
			cuentacontableiva2Logic.setConnexion(this.connexion);
			cuentacontableiva2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIva2.equals("NONE")) {
				cuentacontableiva2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableIva2,new Pagination());
				cuentacontableiva2sForeignKey=cuentacontableiva2Logic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontableiva2sForeignKey(cuentacontableiva2sForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			servicioReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return servicioReturnGeneral;
	}
	
	
	public void deepLoad(Servicio servicio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ServicioLogicAdditional.updateServicioToGet(servicio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		servicio.setEmpresa(servicioDataAccess.getEmpresa(connexion,servicio));
		servicio.setTipoServicio(servicioDataAccess.getTipoServicio(connexion,servicio));
		servicio.setEstadoServicio(servicioDataAccess.getEstadoServicio(connexion,servicio));
		servicio.setCuentaContableGasto(servicioDataAccess.getCuentaContableGasto(connexion,servicio));
		servicio.setCuentaContableFiscal(servicioDataAccess.getCuentaContableFiscal(connexion,servicio));
		servicio.setCuentaContableFiscal2(servicioDataAccess.getCuentaContableFiscal2(connexion,servicio));
		servicio.setCuentaContableRetencion(servicioDataAccess.getCuentaContableRetencion(connexion,servicio));
		servicio.setCuentaContableRetencion2(servicioDataAccess.getCuentaContableRetencion2(connexion,servicio));
		servicio.setCuentaContableIva(servicioDataAccess.getCuentaContableIva(connexion,servicio));
		servicio.setCuentaContableIva2(servicioDataAccess.getCuentaContableIva2(connexion,servicio));
		servicio.setCuentaContableCredito(servicioDataAccess.getCuentaContableCredito(connexion,servicio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				servicio.setEmpresa(servicioDataAccess.getEmpresa(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(TipoServicio.class)) {
				servicio.setTipoServicio(servicioDataAccess.getTipoServicio(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(EstadoServicio.class)) {
				servicio.setEstadoServicio(servicioDataAccess.getEstadoServicio(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableGasto(servicioDataAccess.getCuentaContableGasto(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableFiscal(servicioDataAccess.getCuentaContableFiscal(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableFiscal2(servicioDataAccess.getCuentaContableFiscal2(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableRetencion(servicioDataAccess.getCuentaContableRetencion(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableRetencion2(servicioDataAccess.getCuentaContableRetencion2(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableIva(servicioDataAccess.getCuentaContableIva(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableIva2(servicioDataAccess.getCuentaContableIva2(connexion,servicio));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableCredito(servicioDataAccess.getCuentaContableCredito(connexion,servicio));
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
			servicio.setEmpresa(servicioDataAccess.getEmpresa(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setTipoServicio(servicioDataAccess.getTipoServicio(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setEstadoServicio(servicioDataAccess.getEstadoServicio(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableGasto(servicioDataAccess.getCuentaContableGasto(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableFiscal(servicioDataAccess.getCuentaContableFiscal(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableFiscal2(servicioDataAccess.getCuentaContableFiscal2(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableRetencion(servicioDataAccess.getCuentaContableRetencion(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableRetencion2(servicioDataAccess.getCuentaContableRetencion2(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableIva(servicioDataAccess.getCuentaContableIva(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableIva2(servicioDataAccess.getCuentaContableIva2(connexion,servicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableCredito(servicioDataAccess.getCuentaContableCredito(connexion,servicio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		servicio.setEmpresa(servicioDataAccess.getEmpresa(connexion,servicio));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(servicio.getEmpresa(),isDeep,deepLoadType,clases);
				
		servicio.setTipoServicio(servicioDataAccess.getTipoServicio(connexion,servicio));
		TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
		tiposervicioLogic.deepLoad(servicio.getTipoServicio(),isDeep,deepLoadType,clases);
				
		servicio.setEstadoServicio(servicioDataAccess.getEstadoServicio(connexion,servicio));
		EstadoServicioLogic estadoservicioLogic= new EstadoServicioLogic(connexion);
		estadoservicioLogic.deepLoad(servicio.getEstadoServicio(),isDeep,deepLoadType,clases);
				
		servicio.setCuentaContableGasto(servicioDataAccess.getCuentaContableGasto(connexion,servicio));
		CuentaContableLogic cuentacontablegastoLogic= new CuentaContableLogic(connexion);
		cuentacontablegastoLogic.deepLoad(servicio.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				
		servicio.setCuentaContableFiscal(servicioDataAccess.getCuentaContableFiscal(connexion,servicio));
		CuentaContableLogic cuentacontablefiscalLogic= new CuentaContableLogic(connexion);
		cuentacontablefiscalLogic.deepLoad(servicio.getCuentaContableFiscal(),isDeep,deepLoadType,clases);
				
		servicio.setCuentaContableFiscal2(servicioDataAccess.getCuentaContableFiscal2(connexion,servicio));
		CuentaContableLogic cuentacontablefiscal2Logic= new CuentaContableLogic(connexion);
		cuentacontablefiscal2Logic.deepLoad(servicio.getCuentaContableFiscal2(),isDeep,deepLoadType,clases);
				
		servicio.setCuentaContableRetencion(servicioDataAccess.getCuentaContableRetencion(connexion,servicio));
		CuentaContableLogic cuentacontableretencionLogic= new CuentaContableLogic(connexion);
		cuentacontableretencionLogic.deepLoad(servicio.getCuentaContableRetencion(),isDeep,deepLoadType,clases);
				
		servicio.setCuentaContableRetencion2(servicioDataAccess.getCuentaContableRetencion2(connexion,servicio));
		CuentaContableLogic cuentacontableretencion2Logic= new CuentaContableLogic(connexion);
		cuentacontableretencion2Logic.deepLoad(servicio.getCuentaContableRetencion2(),isDeep,deepLoadType,clases);
				
		servicio.setCuentaContableIva(servicioDataAccess.getCuentaContableIva(connexion,servicio));
		CuentaContableLogic cuentacontableivaLogic= new CuentaContableLogic(connexion);
		cuentacontableivaLogic.deepLoad(servicio.getCuentaContableIva(),isDeep,deepLoadType,clases);
				
		servicio.setCuentaContableIva2(servicioDataAccess.getCuentaContableIva2(connexion,servicio));
		CuentaContableLogic cuentacontableiva2Logic= new CuentaContableLogic(connexion);
		cuentacontableiva2Logic.deepLoad(servicio.getCuentaContableIva2(),isDeep,deepLoadType,clases);
				
		servicio.setCuentaContableCredito(servicioDataAccess.getCuentaContableCredito(connexion,servicio));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(servicio.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				servicio.setEmpresa(servicioDataAccess.getEmpresa(connexion,servicio));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(servicio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoServicio.class)) {
				servicio.setTipoServicio(servicioDataAccess.getTipoServicio(connexion,servicio));
				TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
				tiposervicioLogic.deepLoad(servicio.getTipoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoServicio.class)) {
				servicio.setEstadoServicio(servicioDataAccess.getEstadoServicio(connexion,servicio));
				EstadoServicioLogic estadoservicioLogic= new EstadoServicioLogic(connexion);
				estadoservicioLogic.deepLoad(servicio.getEstadoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableGasto(servicioDataAccess.getCuentaContableGasto(connexion,servicio));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(servicio.getCuentaContableGasto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableFiscal(servicioDataAccess.getCuentaContableFiscal(connexion,servicio));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(servicio.getCuentaContableFiscal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableFiscal2(servicioDataAccess.getCuentaContableFiscal2(connexion,servicio));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(servicio.getCuentaContableFiscal2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableRetencion(servicioDataAccess.getCuentaContableRetencion(connexion,servicio));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(servicio.getCuentaContableRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableRetencion2(servicioDataAccess.getCuentaContableRetencion2(connexion,servicio));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(servicio.getCuentaContableRetencion2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableIva(servicioDataAccess.getCuentaContableIva(connexion,servicio));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(servicio.getCuentaContableIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableIva2(servicioDataAccess.getCuentaContableIva2(connexion,servicio));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(servicio.getCuentaContableIva2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				servicio.setCuentaContableCredito(servicioDataAccess.getCuentaContableCredito(connexion,servicio));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(servicio.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			servicio.setEmpresa(servicioDataAccess.getEmpresa(connexion,servicio));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(servicio.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setTipoServicio(servicioDataAccess.getTipoServicio(connexion,servicio));
			TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
			tiposervicioLogic.deepLoad(servicio.getTipoServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setEstadoServicio(servicioDataAccess.getEstadoServicio(connexion,servicio));
			EstadoServicioLogic estadoservicioLogic= new EstadoServicioLogic(connexion);
			estadoservicioLogic.deepLoad(servicio.getEstadoServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableGasto(servicioDataAccess.getCuentaContableGasto(connexion,servicio));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(servicio.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableFiscal(servicioDataAccess.getCuentaContableFiscal(connexion,servicio));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(servicio.getCuentaContableFiscal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableFiscal2(servicioDataAccess.getCuentaContableFiscal2(connexion,servicio));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(servicio.getCuentaContableFiscal2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableRetencion(servicioDataAccess.getCuentaContableRetencion(connexion,servicio));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(servicio.getCuentaContableRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableRetencion2(servicioDataAccess.getCuentaContableRetencion2(connexion,servicio));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(servicio.getCuentaContableRetencion2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableIva(servicioDataAccess.getCuentaContableIva(connexion,servicio));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(servicio.getCuentaContableIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableIva2(servicioDataAccess.getCuentaContableIva2(connexion,servicio));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(servicio.getCuentaContableIva2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			servicio.setCuentaContableCredito(servicioDataAccess.getCuentaContableCredito(connexion,servicio));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(servicio.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Servicio servicio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ServicioLogicAdditional.updateServicioToSave(servicio,this.arrDatoGeneral);
			
ServicioDataAccess.save(servicio, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(servicio.getEmpresa(),connexion);

		TipoServicioDataAccess.save(servicio.getTipoServicio(),connexion);

		EstadoServicioDataAccess.save(servicio.getEstadoServicio(),connexion);

		CuentaContableDataAccess.save(servicio.getCuentaContableGasto(),connexion);

		CuentaContableDataAccess.save(servicio.getCuentaContableFiscal(),connexion);

		CuentaContableDataAccess.save(servicio.getCuentaContableFiscal2(),connexion);

		CuentaContableDataAccess.save(servicio.getCuentaContableRetencion(),connexion);

		CuentaContableDataAccess.save(servicio.getCuentaContableRetencion2(),connexion);

		CuentaContableDataAccess.save(servicio.getCuentaContableIva(),connexion);

		CuentaContableDataAccess.save(servicio.getCuentaContableIva2(),connexion);

		CuentaContableDataAccess.save(servicio.getCuentaContableCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(servicio.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoServicio.class)) {
				TipoServicioDataAccess.save(servicio.getTipoServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoServicio.class)) {
				EstadoServicioDataAccess.save(servicio.getEstadoServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableGasto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableFiscal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableFiscal2(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableRetencion2(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableIva(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableIva2(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(servicio.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(servicio.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoServicioDataAccess.save(servicio.getTipoServicio(),connexion);
		TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
		tiposervicioLogic.deepLoad(servicio.getTipoServicio(),isDeep,deepLoadType,clases);
				

		EstadoServicioDataAccess.save(servicio.getEstadoServicio(),connexion);
		EstadoServicioLogic estadoservicioLogic= new EstadoServicioLogic(connexion);
		estadoservicioLogic.deepLoad(servicio.getEstadoServicio(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(servicio.getCuentaContableGasto(),connexion);
		CuentaContableLogic cuentacontablegastoLogic= new CuentaContableLogic(connexion);
		cuentacontablegastoLogic.deepLoad(servicio.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(servicio.getCuentaContableFiscal(),connexion);
		CuentaContableLogic cuentacontablefiscalLogic= new CuentaContableLogic(connexion);
		cuentacontablefiscalLogic.deepLoad(servicio.getCuentaContableFiscal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(servicio.getCuentaContableFiscal2(),connexion);
		CuentaContableLogic cuentacontablefiscal2Logic= new CuentaContableLogic(connexion);
		cuentacontablefiscal2Logic.deepLoad(servicio.getCuentaContableFiscal2(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(servicio.getCuentaContableRetencion(),connexion);
		CuentaContableLogic cuentacontableretencionLogic= new CuentaContableLogic(connexion);
		cuentacontableretencionLogic.deepLoad(servicio.getCuentaContableRetencion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(servicio.getCuentaContableRetencion2(),connexion);
		CuentaContableLogic cuentacontableretencion2Logic= new CuentaContableLogic(connexion);
		cuentacontableretencion2Logic.deepLoad(servicio.getCuentaContableRetencion2(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(servicio.getCuentaContableIva(),connexion);
		CuentaContableLogic cuentacontableivaLogic= new CuentaContableLogic(connexion);
		cuentacontableivaLogic.deepLoad(servicio.getCuentaContableIva(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(servicio.getCuentaContableIva2(),connexion);
		CuentaContableLogic cuentacontableiva2Logic= new CuentaContableLogic(connexion);
		cuentacontableiva2Logic.deepLoad(servicio.getCuentaContableIva2(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(servicio.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(servicio.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(servicio.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(servicio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoServicio.class)) {
				TipoServicioDataAccess.save(servicio.getTipoServicio(),connexion);
				TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
				tiposervicioLogic.deepSave(servicio.getTipoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoServicio.class)) {
				EstadoServicioDataAccess.save(servicio.getEstadoServicio(),connexion);
				EstadoServicioLogic estadoservicioLogic= new EstadoServicioLogic(connexion);
				estadoservicioLogic.deepSave(servicio.getEstadoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableGasto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(servicio.getCuentaContableGasto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableFiscal(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(servicio.getCuentaContableFiscal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableFiscal2(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(servicio.getCuentaContableFiscal2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableRetencion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(servicio.getCuentaContableRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableRetencion2(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(servicio.getCuentaContableRetencion2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableIva(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(servicio.getCuentaContableIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableIva2(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(servicio.getCuentaContableIva2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(servicio.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(servicio.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Servicio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(servicio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(servicio);
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
			this.deepLoad(this.servicio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Servicio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(servicios!=null) {
				for(Servicio servicio:servicios) {
					this.deepLoad(servicio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(servicios);
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
			if(servicios!=null) {
				for(Servicio servicio:servicios) {
					this.deepLoad(servicio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(servicios);
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
			this.getNewConnexionToDeep(Servicio.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(servicio,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Servicio.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(servicios!=null) {
				for(Servicio servicio:servicios) {
					this.deepSave(servicio,isDeep,deepLoadType,clases);
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
			if(servicios!=null) {
				for(Servicio servicio:servicios) {
					this.deepSave(servicio,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getServiciosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",ServicioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",ServicioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ServicioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ServicioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,ServicioConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,ServicioConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdCuentaContableFiscalWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_fiscal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFiscal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFiscal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_fiscal,ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFiscal);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFiscal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdCuentaContableFiscal(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_fiscal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFiscal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFiscal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_fiscal,ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFiscal);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFiscal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdCuentaContableFiscal2WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_fiscal2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFiscal2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFiscal2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_fiscal2,ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFiscal2);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFiscal2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdCuentaContableFiscal2(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_fiscal2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFiscal2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFiscal2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_fiscal2,ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFiscal2);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFiscal2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdCuentaContableGastoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto,ServicioConstantesFunciones.IDCUENTACONTABLEGASTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdCuentaContableGasto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto,ServicioConstantesFunciones.IDCUENTACONTABLEGASTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdCuentaContableIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva,ServicioConstantesFunciones.IDCUENTACONTABLEIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIva);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdCuentaContableIva(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva,ServicioConstantesFunciones.IDCUENTACONTABLEIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIva);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdCuentaContableIva2WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIva2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIva2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva2,ServicioConstantesFunciones.IDCUENTACONTABLEIVA2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIva2);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIva2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdCuentaContableIva2(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIva2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIva2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva2,ServicioConstantesFunciones.IDCUENTACONTABLEIVA2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIva2);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIva2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdCuentaContableRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion,ServicioConstantesFunciones.IDCUENTACONTABLERETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRetencion);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdCuentaContableRetencion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion,ServicioConstantesFunciones.IDCUENTACONTABLERETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRetencion);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdCuentaContableRetencion2WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRetencion2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRetencion2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion2,ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRetencion2);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRetencion2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdCuentaContableRetencion2(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRetencion2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRetencion2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion2,ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRetencion2);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRetencion2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ServicioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ServicioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdEstadoServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_servicio,ServicioConstantesFunciones.IDESTADOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoServicio);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdEstadoServicio(String sFinalQuery,Pagination pagination,Long id_estado_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_servicio,ServicioConstantesFunciones.IDESTADOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoServicio);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServiciosFK_IdTipoServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Servicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_servicio,ServicioConstantesFunciones.IDTIPOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoServicio);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServiciosFK_IdTipoServicio(String sFinalQuery,Pagination pagination,Long id_tipo_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_servicio,ServicioConstantesFunciones.IDTIPOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoServicio);

			ServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			servicios=servicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioConstantesFunciones.refrescarForeignKeysDescripcionesServicio(this.servicios);
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
			if(ServicioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ServicioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Servicio servicio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ServicioConstantesFunciones.ISCONAUDITORIA) {
				if(servicio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ServicioDataAccess.TABLENAME, servicio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ServicioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ServicioLogic.registrarAuditoriaDetallesServicio(connexion,servicio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(servicio.getIsDeleted()) {
					/*if(!servicio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ServicioDataAccess.TABLENAME, servicio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ServicioLogic.registrarAuditoriaDetallesServicio(connexion,servicio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ServicioDataAccess.TABLENAME, servicio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(servicio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ServicioDataAccess.TABLENAME, servicio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ServicioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ServicioLogic.registrarAuditoriaDetallesServicio(connexion,servicio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesServicio(Connexion connexion,Servicio servicio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(servicio.getIsNew()||!servicio.getid_empresa().equals(servicio.getServicioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_empresa()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_empresa().toString();
				}
				if(servicio.getid_empresa()!=null)
				{
					strValorNuevo=servicio.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_tipo_servicio().equals(servicio.getServicioOriginal().getid_tipo_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_tipo_servicio()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_tipo_servicio().toString();
				}
				if(servicio.getid_tipo_servicio()!=null)
				{
					strValorNuevo=servicio.getid_tipo_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDTIPOSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getcodigo().equals(servicio.getServicioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getcodigo()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getcodigo();
				}
				if(servicio.getcodigo()!=null)
				{
					strValorNuevo=servicio.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getnombre().equals(servicio.getServicioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getnombre()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getnombre();
				}
				if(servicio.getnombre()!=null)
				{
					strValorNuevo=servicio.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getiva().equals(servicio.getServicioOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getiva()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getiva().toString();
				}
				if(servicio.getiva()!=null)
				{
					strValorNuevo=servicio.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getice().equals(servicio.getServicioOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getice()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getice().toString();
				}
				if(servicio.getice()!=null)
				{
					strValorNuevo=servicio.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getes_bien().equals(servicio.getServicioOriginal().getes_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getes_bien()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getes_bien().toString();
				}
				if(servicio.getes_bien()!=null)
				{
					strValorNuevo=servicio.getes_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.ESBIEN,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_estado_servicio().equals(servicio.getServicioOriginal().getid_estado_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_estado_servicio()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_estado_servicio().toString();
				}
				if(servicio.getid_estado_servicio()!=null)
				{
					strValorNuevo=servicio.getid_estado_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDESTADOSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getdescripcion().equals(servicio.getServicioOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getdescripcion()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getdescripcion();
				}
				if(servicio.getdescripcion()!=null)
				{
					strValorNuevo=servicio.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_cuenta_contable_gasto().equals(servicio.getServicioOriginal().getid_cuenta_contable_gasto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_cuenta_contable_gasto()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_cuenta_contable_gasto().toString();
				}
				if(servicio.getid_cuenta_contable_gasto()!=null)
				{
					strValorNuevo=servicio.getid_cuenta_contable_gasto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDCUENTACONTABLEGASTO,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_cuenta_contable_fiscal().equals(servicio.getServicioOriginal().getid_cuenta_contable_fiscal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_cuenta_contable_fiscal()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_cuenta_contable_fiscal().toString();
				}
				if(servicio.getid_cuenta_contable_fiscal()!=null)
				{
					strValorNuevo=servicio.getid_cuenta_contable_fiscal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_cuenta_contable_fiscal2().equals(servicio.getServicioOriginal().getid_cuenta_contable_fiscal2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_cuenta_contable_fiscal2()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_cuenta_contable_fiscal2().toString();
				}
				if(servicio.getid_cuenta_contable_fiscal2()!=null)
				{
					strValorNuevo=servicio.getid_cuenta_contable_fiscal2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_cuenta_contable_retencion().equals(servicio.getServicioOriginal().getid_cuenta_contable_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_cuenta_contable_retencion()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_cuenta_contable_retencion().toString();
				}
				if(servicio.getid_cuenta_contable_retencion()!=null)
				{
					strValorNuevo=servicio.getid_cuenta_contable_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDCUENTACONTABLERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_cuenta_contable_retencion2().equals(servicio.getServicioOriginal().getid_cuenta_contable_retencion2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_cuenta_contable_retencion2()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_cuenta_contable_retencion2().toString();
				}
				if(servicio.getid_cuenta_contable_retencion2()!=null)
				{
					strValorNuevo=servicio.getid_cuenta_contable_retencion2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_cuenta_contable_iva().equals(servicio.getServicioOriginal().getid_cuenta_contable_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_cuenta_contable_iva()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_cuenta_contable_iva().toString();
				}
				if(servicio.getid_cuenta_contable_iva()!=null)
				{
					strValorNuevo=servicio.getid_cuenta_contable_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDCUENTACONTABLEIVA,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_cuenta_contable_iva2().equals(servicio.getServicioOriginal().getid_cuenta_contable_iva2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_cuenta_contable_iva2()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_cuenta_contable_iva2().toString();
				}
				if(servicio.getid_cuenta_contable_iva2()!=null)
				{
					strValorNuevo=servicio.getid_cuenta_contable_iva2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDCUENTACONTABLEIVA2,strValorActual,strValorNuevo);
			}	
			
			if(servicio.getIsNew()||!servicio.getid_cuenta_contable_credito().equals(servicio.getServicioOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(servicio.getServicioOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=servicio.getServicioOriginal().getid_cuenta_contable_credito().toString();
				}
				if(servicio.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=servicio.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveServicioRelacionesWithConnection(Servicio servicio) throws Exception {

		if(!servicio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveServicioRelacionesBase(servicio,true);
		}
	}

	public void saveServicioRelaciones(Servicio servicio)throws Exception {

		if(!servicio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveServicioRelacionesBase(servicio,false);
		}
	}

	public void saveServicioRelacionesBase(Servicio servicio,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Servicio-saveRelacionesWithConnection");}
	

			this.setServicio(servicio);

			if(ServicioLogicAdditional.validarSaveRelaciones(servicio,this)) {

				ServicioLogicAdditional.updateRelacionesToSave(servicio,this);

				if((servicio.getIsNew()||servicio.getIsChanged())&&!servicio.getIsDeleted()) {
					this.saveServicio();
					this.saveServicioRelacionesDetalles();

				} else if(servicio.getIsDeleted()) {
					this.saveServicioRelacionesDetalles();
					this.saveServicio();
				}

				ServicioLogicAdditional.updateRelacionesToSaveAfter(servicio,this);

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
	
	
	private void saveServicioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ServicioConstantesFunciones.getClassesForeignKeysOfServicio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ServicioConstantesFunciones.getClassesRelationshipsOfServicio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

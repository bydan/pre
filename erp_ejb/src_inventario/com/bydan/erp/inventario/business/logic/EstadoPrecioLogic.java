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
import com.bydan.erp.inventario.util.EstadoPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoPrecioParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoPrecio;
import com.bydan.erp.inventario.business.logic.EstadoPrecioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoPrecioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoPrecioLogic.class);
	
	protected EstadoPrecioDataAccess estadoprecioDataAccess; 	
	protected EstadoPrecio estadoprecio;
	protected List<EstadoPrecio> estadoprecios;
	protected Object estadoprecioObject;	
	protected List<Object> estadopreciosObject;
	
	public static ClassValidator<EstadoPrecio> estadoprecioValidator = new ClassValidator<EstadoPrecio>(EstadoPrecio.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoPrecioLogicAdditional estadoprecioLogicAdditional=null;
	
	public EstadoPrecioLogicAdditional getEstadoPrecioLogicAdditional() {
		return this.estadoprecioLogicAdditional;
	}
	
	public void setEstadoPrecioLogicAdditional(EstadoPrecioLogicAdditional estadoprecioLogicAdditional) {
		try {
			this.estadoprecioLogicAdditional=estadoprecioLogicAdditional;
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
	
	
	
	
	public  EstadoPrecioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoprecioDataAccess = new EstadoPrecioDataAccess();
			
			this.estadoprecios= new ArrayList<EstadoPrecio>();
			this.estadoprecio= new EstadoPrecio();
			
			this.estadoprecioObject=new Object();
			this.estadopreciosObject=new ArrayList<Object>();
				
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
			
			this.estadoprecioDataAccess.setConnexionType(this.connexionType);
			this.estadoprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoPrecioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoprecioDataAccess = new EstadoPrecioDataAccess();
			this.estadoprecios= new ArrayList<EstadoPrecio>();
			this.estadoprecio= new EstadoPrecio();
			this.estadoprecioObject=new Object();
			this.estadopreciosObject=new ArrayList<Object>();
			
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
			
			this.estadoprecioDataAccess.setConnexionType(this.connexionType);
			this.estadoprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoPrecio getEstadoPrecio() throws Exception {	
		EstadoPrecioLogicAdditional.checkEstadoPrecioToGet(estadoprecio,this.datosCliente,this.arrDatoGeneral);
		EstadoPrecioLogicAdditional.updateEstadoPrecioToGet(estadoprecio,this.arrDatoGeneral);
		
		return estadoprecio;
	}
		
	public void setEstadoPrecio(EstadoPrecio newEstadoPrecio) {
		this.estadoprecio = newEstadoPrecio;
	}
	
	public EstadoPrecioDataAccess getEstadoPrecioDataAccess() {
		return estadoprecioDataAccess;
	}
	
	public void setEstadoPrecioDataAccess(EstadoPrecioDataAccess newestadoprecioDataAccess) {
		this.estadoprecioDataAccess = newestadoprecioDataAccess;
	}
	
	public List<EstadoPrecio> getEstadoPrecios() throws Exception {		
		this.quitarEstadoPreciosNulos();
		
		EstadoPrecioLogicAdditional.checkEstadoPrecioToGets(estadoprecios,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoPrecio estadoprecioLocal: estadoprecios ) {
			EstadoPrecioLogicAdditional.updateEstadoPrecioToGet(estadoprecioLocal,this.arrDatoGeneral);
		}
		
		return estadoprecios;
	}
	
	public void setEstadoPrecios(List<EstadoPrecio> newEstadoPrecios) {
		this.estadoprecios = newEstadoPrecios;
	}
	
	public Object getEstadoPrecioObject() {	
		this.estadoprecioObject=this.estadoprecioDataAccess.getEntityObject();
		return this.estadoprecioObject;
	}
		
	public void setEstadoPrecioObject(Object newEstadoPrecioObject) {
		this.estadoprecioObject = newEstadoPrecioObject;
	}
	
	public List<Object> getEstadoPreciosObject() {		
		this.estadopreciosObject=this.estadoprecioDataAccess.getEntitiesObject();
		return this.estadopreciosObject;
	}
		
	public void setEstadoPreciosObject(List<Object> newEstadoPreciosObject) {
		this.estadopreciosObject = newEstadoPreciosObject;
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
		
		if(this.estadoprecioDataAccess!=null) {
			this.estadoprecioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoprecio = new  EstadoPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoprecio=estadoprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecio);
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
		estadoprecio = new  EstadoPrecio();
		  		  
        try {
			
			estadoprecio=estadoprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoprecio = new  EstadoPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoprecio=estadoprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecio);
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
		estadoprecio = new  EstadoPrecio();
		  		  
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
		estadoprecio = new  EstadoPrecio();
		  		  
        try {
			
			estadoprecio=estadoprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoprecio = new  EstadoPrecio();
		  		  
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
		estadoprecio = new  EstadoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoprecio = new  EstadoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoprecio = new  EstadoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoprecio = new  EstadoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoprecio = new  EstadoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoprecio = new  EstadoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoprecios = new  ArrayList<EstadoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
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
		estadoprecios = new  ArrayList<EstadoPrecio>();
		  		  
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
		estadoprecios = new  ArrayList<EstadoPrecio>();
		  		  
        try {			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoprecios = new  ArrayList<EstadoPrecio>();
		  		  
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
		estadoprecios = new  ArrayList<EstadoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
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
		estadoprecios = new  ArrayList<EstadoPrecio>();
		  		  
        try {
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
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
		estadoprecios = new  ArrayList<EstadoPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
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
		estadoprecios = new  ArrayList<EstadoPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoprecio = new  EstadoPrecio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecio=estadoprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPrecio(estadoprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecio);
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
		estadoprecio = new  EstadoPrecio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecio=estadoprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPrecio(estadoprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoprecios = new  ArrayList<EstadoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
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
		estadoprecios = new  ArrayList<EstadoPrecio>();
		  		  
        try {
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoPreciosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoprecios = new  ArrayList<EstadoPrecio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-getTodosEstadoPreciosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
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
	
	public  void  getTodosEstadoPrecios(String sFinalQuery,Pagination pagination)throws Exception {
		estadoprecios = new  ArrayList<EstadoPrecio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoprecios=estadoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPrecio(estadoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoPrecio(EstadoPrecio estadoprecio) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoprecio.getIsNew() || estadoprecio.getIsChanged()) { 
			this.invalidValues = estadoprecioValidator.getInvalidValues(estadoprecio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoprecio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoPrecio(List<EstadoPrecio> EstadoPrecios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoPrecio estadoprecioLocal:estadoprecios) {				
			estaValidadoObjeto=this.validarGuardarEstadoPrecio(estadoprecioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoPrecio(List<EstadoPrecio> EstadoPrecios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPrecio(estadoprecios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoPrecio(EstadoPrecio EstadoPrecio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPrecio(estadoprecio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoPrecio estadoprecio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoprecio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoPrecioConstantesFunciones.getEstadoPrecioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoprecio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoPrecioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-saveEstadoPrecioWithConnection");connexion.begin();			
			
			EstadoPrecioLogicAdditional.checkEstadoPrecioToSave(this.estadoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoPrecioLogicAdditional.updateEstadoPrecioToSave(this.estadoprecio,this.arrDatoGeneral);
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPrecio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPrecio(this.estadoprecio)) {
				EstadoPrecioDataAccess.save(this.estadoprecio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoPrecioLogicAdditional.checkEstadoPrecioToSaveAfter(this.estadoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPrecio();
			
			connexion.commit();			
			
			if(this.estadoprecio.getIsDeleted()) {
				this.estadoprecio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoPrecio()throws Exception {	
		try {	
			
			EstadoPrecioLogicAdditional.checkEstadoPrecioToSave(this.estadoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoPrecioLogicAdditional.updateEstadoPrecioToSave(this.estadoprecio,this.arrDatoGeneral);
			
			EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPrecio(this.estadoprecio)) {			
				EstadoPrecioDataAccess.save(this.estadoprecio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoPrecioLogicAdditional.checkEstadoPrecioToSaveAfter(this.estadoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoprecio.getIsDeleted()) {
				this.estadoprecio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoPreciosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-saveEstadoPreciosWithConnection");connexion.begin();			
			
			EstadoPrecioLogicAdditional.checkEstadoPrecioToSaves(estadoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPrecios();
			
			Boolean validadoTodosEstadoPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPrecio estadoprecioLocal:estadoprecios) {		
				if(estadoprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoPrecioLogicAdditional.updateEstadoPrecioToSave(estadoprecioLocal,this.arrDatoGeneral);
	        	
				EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPrecio(estadoprecioLocal)) {
					EstadoPrecioDataAccess.save(estadoprecioLocal, connexion);				
				} else {
					validadoTodosEstadoPrecio=false;
				}
			}
			
			if(!validadoTodosEstadoPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoPrecioLogicAdditional.checkEstadoPrecioToSavesAfter(estadoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPrecios();
			
			connexion.commit();		
			
			this.quitarEstadoPreciosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoPrecios()throws Exception {				
		 try {	
			EstadoPrecioLogicAdditional.checkEstadoPrecioToSaves(estadoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPrecio estadoprecioLocal:estadoprecios) {				
				if(estadoprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoPrecioLogicAdditional.updateEstadoPrecioToSave(estadoprecioLocal,this.arrDatoGeneral);
	        	
				EstadoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPrecio(estadoprecioLocal)) {				
					EstadoPrecioDataAccess.save(estadoprecioLocal, connexion);				
				} else {
					validadoTodosEstadoPrecio=false;
				}
			}
			
			if(!validadoTodosEstadoPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoPrecioLogicAdditional.checkEstadoPrecioToSavesAfter(estadoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoPreciosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPrecioParameterReturnGeneral procesarAccionEstadoPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPrecio> estadoprecios,EstadoPrecioParameterReturnGeneral estadoprecioParameterGeneral)throws Exception {
		 try {	
			EstadoPrecioParameterReturnGeneral estadoprecioReturnGeneral=new EstadoPrecioParameterReturnGeneral();
	
			EstadoPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoprecios,estadoprecioParameterGeneral,estadoprecioReturnGeneral);
			
			return estadoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPrecioParameterReturnGeneral procesarAccionEstadoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPrecio> estadoprecios,EstadoPrecioParameterReturnGeneral estadoprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-procesarAccionEstadoPreciosWithConnection");connexion.begin();			
			
			EstadoPrecioParameterReturnGeneral estadoprecioReturnGeneral=new EstadoPrecioParameterReturnGeneral();
	
			EstadoPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoprecios,estadoprecioParameterGeneral,estadoprecioReturnGeneral);
			
			this.connexion.commit();
			
			return estadoprecioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPrecioParameterReturnGeneral procesarEventosEstadoPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPrecio> estadoprecios,EstadoPrecio estadoprecio,EstadoPrecioParameterReturnGeneral estadoprecioParameterGeneral,Boolean isEsNuevoEstadoPrecio,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoPrecioParameterReturnGeneral estadoprecioReturnGeneral=new EstadoPrecioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoprecios,estadoprecio,estadoprecioParameterGeneral,estadoprecioReturnGeneral,isEsNuevoEstadoPrecio,clases);
			
			return estadoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoPrecioParameterReturnGeneral procesarEventosEstadoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPrecio> estadoprecios,EstadoPrecio estadoprecio,EstadoPrecioParameterReturnGeneral estadoprecioParameterGeneral,Boolean isEsNuevoEstadoPrecio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-procesarEventosEstadoPreciosWithConnection");connexion.begin();			
			
			EstadoPrecioParameterReturnGeneral estadoprecioReturnGeneral=new EstadoPrecioParameterReturnGeneral();
	
			estadoprecioReturnGeneral.setEstadoPrecio(estadoprecio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoprecios,estadoprecio,estadoprecioParameterGeneral,estadoprecioReturnGeneral,isEsNuevoEstadoPrecio,clases);
			
			this.connexion.commit();
			
			return estadoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPrecioParameterReturnGeneral procesarImportacionEstadoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoPrecioParameterReturnGeneral estadoprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-procesarImportacionEstadoPreciosWithConnection");connexion.begin();			
			
			EstadoPrecioParameterReturnGeneral estadoprecioReturnGeneral=new EstadoPrecioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoprecios=new ArrayList<EstadoPrecio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoprecio=new EstadoPrecio();
				
				
				if(conColumnasBase) {this.estadoprecio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoprecio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoprecio.setcodigo(arrColumnas[iColumn++]);
				this.estadoprecio.setnombre(arrColumnas[iColumn++]);
				
				this.estadoprecios.add(this.estadoprecio);
			}
			
			this.saveEstadoPrecios();
			
			this.connexion.commit();
			
			estadoprecioReturnGeneral.setConRetornoEstaProcesado(true);
			estadoprecioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoPreciosEliminados() throws Exception {				
		
		List<EstadoPrecio> estadopreciosAux= new ArrayList<EstadoPrecio>();
		
		for(EstadoPrecio estadoprecio:estadoprecios) {
			if(!estadoprecio.getIsDeleted()) {
				estadopreciosAux.add(estadoprecio);
			}
		}
		
		estadoprecios=estadopreciosAux;
	}
	
	public void quitarEstadoPreciosNulos() throws Exception {				
		
		List<EstadoPrecio> estadopreciosAux= new ArrayList<EstadoPrecio>();
		
		for(EstadoPrecio estadoprecio : this.estadoprecios) {
			if(estadoprecio==null) {
				estadopreciosAux.add(estadoprecio);
			}
		}
		
		//this.estadoprecios=estadopreciosAux;
		
		this.estadoprecios.removeAll(estadopreciosAux);
	}
	
	public void getSetVersionRowEstadoPrecioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoprecio.getIsDeleted() || (estadoprecio.getIsChanged()&&!estadoprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoprecioDataAccess.getSetVersionRowEstadoPrecio(connexion,estadoprecio.getId());
				
				if(!estadoprecio.getVersionRow().equals(timestamp)) {	
					estadoprecio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoPrecio()throws Exception {	
		
		if(estadoprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoprecio.getIsDeleted() || (estadoprecio.getIsChanged()&&!estadoprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoprecioDataAccess.getSetVersionRowEstadoPrecio(connexion,estadoprecio.getId());
			
			try {							
				if(!estadoprecio.getVersionRow().equals(timestamp)) {	
					estadoprecio.setVersionRow(timestamp);
				}
				
				estadoprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoPreciosWithConnection()throws Exception {	
		if(estadoprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoPrecio estadoprecioAux:estadoprecios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoprecioAux.getIsDeleted() || (estadoprecioAux.getIsChanged()&&!estadoprecioAux.getIsNew())) {
						
						timestamp=estadoprecioDataAccess.getSetVersionRowEstadoPrecio(connexion,estadoprecioAux.getId());
						
						if(!estadoprecio.getVersionRow().equals(timestamp)) {	
							estadoprecioAux.setVersionRow(timestamp);
						}
								
						estadoprecioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoPrecios()throws Exception {	
		if(estadoprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoPrecio estadoprecioAux:estadoprecios) {
					if(estadoprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoprecioAux.getIsDeleted() || (estadoprecioAux.getIsChanged()&&!estadoprecioAux.getIsNew())) {
						
						timestamp=estadoprecioDataAccess.getSetVersionRowEstadoPrecio(connexion,estadoprecioAux.getId());
						
						if(!estadoprecioAux.getVersionRow().equals(timestamp)) {	
							estadoprecioAux.setVersionRow(timestamp);
						}
						
													
						estadoprecioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoPrecioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PrecioLogic precioLogic=new PrecioLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPrecio.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoPrecioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Precio.class));
											
			

			precioLogic.setConnexion(this.getConnexion());
			precioLogic.setDatosCliente(this.datosCliente);
			precioLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoPrecio estadoprecio:this.estadoprecios) {
				

				classes=new ArrayList<Classe>();
				classes=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);

				precioLogic.setPrecios(estadoprecio.precios);
				precioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(EstadoPrecio estadoprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoPrecioLogicAdditional.updateEstadoPrecioToGet(estadoprecio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoprecio.setPrecios(estadoprecioDataAccess.getPrecios(connexion,estadoprecio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoprecio.setPrecios(estadoprecioDataAccess.getPrecios(connexion,estadoprecio));

				if(this.isConDeep) {
					PrecioLogic precioLogic= new PrecioLogic(this.connexion);
					precioLogic.setPrecios(estadoprecio.getPrecios());
					ArrayList<Classe> classesLocal=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);
					precioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(precioLogic.getPrecios());
					estadoprecio.setPrecios(precioLogic.getPrecios());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			estadoprecio.setPrecios(estadoprecioDataAccess.getPrecios(connexion,estadoprecio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadoprecio.setPrecios(estadoprecioDataAccess.getPrecios(connexion,estadoprecio));

		for(Precio precio:estadoprecio.getPrecios()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoprecio.setPrecios(estadoprecioDataAccess.getPrecios(connexion,estadoprecio));

				for(Precio precio:estadoprecio.getPrecios()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			estadoprecio.setPrecios(estadoprecioDataAccess.getPrecios(connexion,estadoprecio));

			for(Precio precio:estadoprecio.getPrecios()) {
				PrecioLogic precioLogic= new PrecioLogic(connexion);
				precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoPrecio estadoprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoPrecioLogicAdditional.updateEstadoPrecioToSave(estadoprecio,this.arrDatoGeneral);
			
EstadoPrecioDataAccess.save(estadoprecio, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Precio precio:estadoprecio.getPrecios()) {
			precio.setid_estado_precio(estadoprecio.getId());
			PrecioDataAccess.save(precio,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:estadoprecio.getPrecios()) {
					precio.setid_estado_precio(estadoprecio.getId());
					PrecioDataAccess.save(precio,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Precio precio:estadoprecio.getPrecios()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precio.setid_estado_precio(estadoprecio.getId());
			PrecioDataAccess.save(precio,connexion);
			precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:estadoprecio.getPrecios()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precio.setid_estado_precio(estadoprecio.getId());
					PrecioDataAccess.save(precio,connexion);
					precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(EstadoPrecio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(estadoprecio);
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
			this.deepLoad(this.estadoprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(this.estadoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoPrecio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoprecios!=null) {
				for(EstadoPrecio estadoprecio:estadoprecios) {
					this.deepLoad(estadoprecio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(estadoprecios);
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
			if(estadoprecios!=null) {
				for(EstadoPrecio estadoprecio:estadoprecios) {
					this.deepLoad(estadoprecio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPrecio(estadoprecios);
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
			this.getNewConnexionToDeep(EstadoPrecio.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadoprecio,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoPrecio.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadoprecios!=null) {
				for(EstadoPrecio estadoprecio:estadoprecios) {
					this.deepSave(estadoprecio,isDeep,deepLoadType,clases);
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
			if(estadoprecios!=null) {
				for(EstadoPrecio estadoprecio:estadoprecios) {
					this.deepSave(estadoprecio,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoPrecioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPrecioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoPrecio estadoprecio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoPrecioConstantesFunciones.ISCONAUDITORIA) {
				if(estadoprecio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPrecioDataAccess.TABLENAME, estadoprecio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPrecioLogic.registrarAuditoriaDetallesEstadoPrecio(connexion,estadoprecio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoprecio.getIsDeleted()) {
					/*if(!estadoprecio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoPrecioDataAccess.TABLENAME, estadoprecio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoPrecioLogic.registrarAuditoriaDetallesEstadoPrecio(connexion,estadoprecio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPrecioDataAccess.TABLENAME, estadoprecio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoprecio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPrecioDataAccess.TABLENAME, estadoprecio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPrecioLogic.registrarAuditoriaDetallesEstadoPrecio(connexion,estadoprecio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoPrecio(Connexion connexion,EstadoPrecio estadoprecio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoprecio.getIsNew()||!estadoprecio.getcodigo().equals(estadoprecio.getEstadoPrecioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoprecio.getEstadoPrecioOriginal().getcodigo()!=null)
				{
					strValorActual=estadoprecio.getEstadoPrecioOriginal().getcodigo();
				}
				if(estadoprecio.getcodigo()!=null)
				{
					strValorNuevo=estadoprecio.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoPrecioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoprecio.getIsNew()||!estadoprecio.getnombre().equals(estadoprecio.getEstadoPrecioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoprecio.getEstadoPrecioOriginal().getnombre()!=null)
				{
					strValorActual=estadoprecio.getEstadoPrecioOriginal().getnombre();
				}
				if(estadoprecio.getnombre()!=null)
				{
					strValorNuevo=estadoprecio.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoPrecioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoPrecioRelacionesWithConnection(EstadoPrecio estadoprecio,List<Precio> precios) throws Exception {

		if(!estadoprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoPrecioRelacionesBase(estadoprecio,precios,true);
		}
	}

	public void saveEstadoPrecioRelaciones(EstadoPrecio estadoprecio,List<Precio> precios)throws Exception {

		if(!estadoprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoPrecioRelacionesBase(estadoprecio,precios,false);
		}
	}

	public void saveEstadoPrecioRelacionesBase(EstadoPrecio estadoprecio,List<Precio> precios,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoPrecio-saveRelacionesWithConnection");}
	
			estadoprecio.setPrecios(precios);

			this.setEstadoPrecio(estadoprecio);

				if((estadoprecio.getIsNew()||estadoprecio.getIsChanged())&&!estadoprecio.getIsDeleted()) {
					this.saveEstadoPrecio();
					this.saveEstadoPrecioRelacionesDetalles(precios);

				} else if(estadoprecio.getIsDeleted()) {
					this.saveEstadoPrecioRelacionesDetalles(precios);
					this.saveEstadoPrecio();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PrecioConstantesFunciones.InicializarGeneralEntityAuxiliaresPrecios(precios,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoPrecioRelacionesDetalles(List<Precio> precios)throws Exception {
		try {
	

			Long idEstadoPrecioActual=this.getEstadoPrecio().getId();

			PrecioLogic precioLogic_Desde_EstadoPrecio=new PrecioLogic();
			precioLogic_Desde_EstadoPrecio.setPrecios(precios);

			precioLogic_Desde_EstadoPrecio.setConnexion(this.getConnexion());
			precioLogic_Desde_EstadoPrecio.setDatosCliente(this.datosCliente);

			for(Precio precio_Desde_EstadoPrecio:precioLogic_Desde_EstadoPrecio.getPrecios()) {
				precio_Desde_EstadoPrecio.setid_estado_precio(idEstadoPrecioActual);
			}

			precioLogic_Desde_EstadoPrecio.savePrecios();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPrecioConstantesFunciones.getClassesForeignKeysOfEstadoPrecio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPrecioConstantesFunciones.getClassesRelationshipsOfEstadoPrecio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

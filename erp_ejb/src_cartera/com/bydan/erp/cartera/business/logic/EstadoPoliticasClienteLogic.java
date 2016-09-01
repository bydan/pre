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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.EstadoPoliticasClienteConstantesFunciones;
import com.bydan.erp.cartera.util.EstadoPoliticasClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EstadoPoliticasClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.EstadoPoliticasCliente;
import com.bydan.erp.cartera.business.logic.EstadoPoliticasClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoPoliticasClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoPoliticasClienteLogic.class);
	
	protected EstadoPoliticasClienteDataAccess estadopoliticasclienteDataAccess; 	
	protected EstadoPoliticasCliente estadopoliticascliente;
	protected List<EstadoPoliticasCliente> estadopoliticasclientes;
	protected Object estadopoliticasclienteObject;	
	protected List<Object> estadopoliticasclientesObject;
	
	public static ClassValidator<EstadoPoliticasCliente> estadopoliticasclienteValidator = new ClassValidator<EstadoPoliticasCliente>(EstadoPoliticasCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoPoliticasClienteLogicAdditional estadopoliticasclienteLogicAdditional=null;
	
	public EstadoPoliticasClienteLogicAdditional getEstadoPoliticasClienteLogicAdditional() {
		return this.estadopoliticasclienteLogicAdditional;
	}
	
	public void setEstadoPoliticasClienteLogicAdditional(EstadoPoliticasClienteLogicAdditional estadopoliticasclienteLogicAdditional) {
		try {
			this.estadopoliticasclienteLogicAdditional=estadopoliticasclienteLogicAdditional;
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
	
	
	
	
	public  EstadoPoliticasClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadopoliticasclienteDataAccess = new EstadoPoliticasClienteDataAccess();
			
			this.estadopoliticasclientes= new ArrayList<EstadoPoliticasCliente>();
			this.estadopoliticascliente= new EstadoPoliticasCliente();
			
			this.estadopoliticasclienteObject=new Object();
			this.estadopoliticasclientesObject=new ArrayList<Object>();
				
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
			
			this.estadopoliticasclienteDataAccess.setConnexionType(this.connexionType);
			this.estadopoliticasclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoPoliticasClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadopoliticasclienteDataAccess = new EstadoPoliticasClienteDataAccess();
			this.estadopoliticasclientes= new ArrayList<EstadoPoliticasCliente>();
			this.estadopoliticascliente= new EstadoPoliticasCliente();
			this.estadopoliticasclienteObject=new Object();
			this.estadopoliticasclientesObject=new ArrayList<Object>();
			
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
			
			this.estadopoliticasclienteDataAccess.setConnexionType(this.connexionType);
			this.estadopoliticasclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoPoliticasCliente getEstadoPoliticasCliente() throws Exception {	
		EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToGet(estadopoliticascliente,this.datosCliente,this.arrDatoGeneral);
		EstadoPoliticasClienteLogicAdditional.updateEstadoPoliticasClienteToGet(estadopoliticascliente,this.arrDatoGeneral);
		
		return estadopoliticascliente;
	}
		
	public void setEstadoPoliticasCliente(EstadoPoliticasCliente newEstadoPoliticasCliente) {
		this.estadopoliticascliente = newEstadoPoliticasCliente;
	}
	
	public EstadoPoliticasClienteDataAccess getEstadoPoliticasClienteDataAccess() {
		return estadopoliticasclienteDataAccess;
	}
	
	public void setEstadoPoliticasClienteDataAccess(EstadoPoliticasClienteDataAccess newestadopoliticasclienteDataAccess) {
		this.estadopoliticasclienteDataAccess = newestadopoliticasclienteDataAccess;
	}
	
	public List<EstadoPoliticasCliente> getEstadoPoliticasClientes() throws Exception {		
		this.quitarEstadoPoliticasClientesNulos();
		
		EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToGets(estadopoliticasclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoPoliticasCliente estadopoliticasclienteLocal: estadopoliticasclientes ) {
			EstadoPoliticasClienteLogicAdditional.updateEstadoPoliticasClienteToGet(estadopoliticasclienteLocal,this.arrDatoGeneral);
		}
		
		return estadopoliticasclientes;
	}
	
	public void setEstadoPoliticasClientes(List<EstadoPoliticasCliente> newEstadoPoliticasClientes) {
		this.estadopoliticasclientes = newEstadoPoliticasClientes;
	}
	
	public Object getEstadoPoliticasClienteObject() {	
		this.estadopoliticasclienteObject=this.estadopoliticasclienteDataAccess.getEntityObject();
		return this.estadopoliticasclienteObject;
	}
		
	public void setEstadoPoliticasClienteObject(Object newEstadoPoliticasClienteObject) {
		this.estadopoliticasclienteObject = newEstadoPoliticasClienteObject;
	}
	
	public List<Object> getEstadoPoliticasClientesObject() {		
		this.estadopoliticasclientesObject=this.estadopoliticasclienteDataAccess.getEntitiesObject();
		return this.estadopoliticasclientesObject;
	}
		
	public void setEstadoPoliticasClientesObject(List<Object> newEstadoPoliticasClientesObject) {
		this.estadopoliticasclientesObject = newEstadoPoliticasClientesObject;
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
		
		if(this.estadopoliticasclienteDataAccess!=null) {
			this.estadopoliticasclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadopoliticasclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadopoliticasclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadopoliticascliente = new  EstadoPoliticasCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadopoliticascliente=estadopoliticasclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopoliticascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticascliente);
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
		estadopoliticascliente = new  EstadoPoliticasCliente();
		  		  
        try {
			
			estadopoliticascliente=estadopoliticasclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopoliticascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticascliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadopoliticascliente = new  EstadoPoliticasCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadopoliticascliente=estadopoliticasclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopoliticascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticascliente);
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
		estadopoliticascliente = new  EstadoPoliticasCliente();
		  		  
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
		estadopoliticascliente = new  EstadoPoliticasCliente();
		  		  
        try {
			
			estadopoliticascliente=estadopoliticasclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopoliticascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticascliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadopoliticascliente = new  EstadoPoliticasCliente();
		  		  
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
		estadopoliticascliente = new  EstadoPoliticasCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadopoliticasclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopoliticascliente = new  EstadoPoliticasCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadopoliticasclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadopoliticascliente = new  EstadoPoliticasCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadopoliticasclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopoliticascliente = new  EstadoPoliticasCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadopoliticasclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadopoliticascliente = new  EstadoPoliticasCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadopoliticasclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopoliticascliente = new  EstadoPoliticasCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadopoliticasclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
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
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		  		  
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
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		  		  
        try {			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		  		  
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
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
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
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		  		  
        try {
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
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
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
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
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadopoliticascliente = new  EstadoPoliticasCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticascliente=estadopoliticasclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticascliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticascliente);
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
		estadopoliticascliente = new  EstadoPoliticasCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticascliente=estadopoliticasclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticascliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticascliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
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
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		  		  
        try {
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoPoliticasClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-getTodosEstadoPoliticasClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
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
	
	public  void  getTodosEstadoPoliticasClientes(String sFinalQuery,Pagination pagination)throws Exception {
		estadopoliticasclientes = new  ArrayList<EstadoPoliticasCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopoliticasclientes=estadopoliticasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPoliticasCliente(estadopoliticasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticasclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoPoliticasCliente(EstadoPoliticasCliente estadopoliticascliente) throws Exception {
		Boolean estaValidado=false;
		
		if(estadopoliticascliente.getIsNew() || estadopoliticascliente.getIsChanged()) { 
			this.invalidValues = estadopoliticasclienteValidator.getInvalidValues(estadopoliticascliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadopoliticascliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoPoliticasCliente(List<EstadoPoliticasCliente> EstadoPoliticasClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoPoliticasCliente estadopoliticasclienteLocal:estadopoliticasclientes) {				
			estaValidadoObjeto=this.validarGuardarEstadoPoliticasCliente(estadopoliticasclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoPoliticasCliente(List<EstadoPoliticasCliente> EstadoPoliticasClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPoliticasCliente(estadopoliticasclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoPoliticasCliente(EstadoPoliticasCliente EstadoPoliticasCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPoliticasCliente(estadopoliticascliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoPoliticasCliente estadopoliticascliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadopoliticascliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoPoliticasClienteConstantesFunciones.getEstadoPoliticasClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadopoliticascliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoPoliticasClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoPoliticasClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoPoliticasClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-saveEstadoPoliticasClienteWithConnection");connexion.begin();			
			
			EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToSave(this.estadopoliticascliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoPoliticasClienteLogicAdditional.updateEstadoPoliticasClienteToSave(this.estadopoliticascliente,this.arrDatoGeneral);
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadopoliticascliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPoliticasCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPoliticasCliente(this.estadopoliticascliente)) {
				EstadoPoliticasClienteDataAccess.save(this.estadopoliticascliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadopoliticascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToSaveAfter(this.estadopoliticascliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPoliticasCliente();
			
			connexion.commit();			
			
			if(this.estadopoliticascliente.getIsDeleted()) {
				this.estadopoliticascliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoPoliticasCliente()throws Exception {	
		try {	
			
			EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToSave(this.estadopoliticascliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoPoliticasClienteLogicAdditional.updateEstadoPoliticasClienteToSave(this.estadopoliticascliente,this.arrDatoGeneral);
			
			EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadopoliticascliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPoliticasCliente(this.estadopoliticascliente)) {			
				EstadoPoliticasClienteDataAccess.save(this.estadopoliticascliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadopoliticascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToSaveAfter(this.estadopoliticascliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadopoliticascliente.getIsDeleted()) {
				this.estadopoliticascliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoPoliticasClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-saveEstadoPoliticasClientesWithConnection");connexion.begin();			
			
			EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToSaves(estadopoliticasclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPoliticasClientes();
			
			Boolean validadoTodosEstadoPoliticasCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPoliticasCliente estadopoliticasclienteLocal:estadopoliticasclientes) {		
				if(estadopoliticasclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoPoliticasClienteLogicAdditional.updateEstadoPoliticasClienteToSave(estadopoliticasclienteLocal,this.arrDatoGeneral);
	        	
				EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadopoliticasclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPoliticasCliente(estadopoliticasclienteLocal)) {
					EstadoPoliticasClienteDataAccess.save(estadopoliticasclienteLocal, connexion);				
				} else {
					validadoTodosEstadoPoliticasCliente=false;
				}
			}
			
			if(!validadoTodosEstadoPoliticasCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToSavesAfter(estadopoliticasclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPoliticasClientes();
			
			connexion.commit();		
			
			this.quitarEstadoPoliticasClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoPoliticasClientes()throws Exception {				
		 try {	
			EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToSaves(estadopoliticasclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoPoliticasCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPoliticasCliente estadopoliticasclienteLocal:estadopoliticasclientes) {				
				if(estadopoliticasclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoPoliticasClienteLogicAdditional.updateEstadoPoliticasClienteToSave(estadopoliticasclienteLocal,this.arrDatoGeneral);
	        	
				EstadoPoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadopoliticasclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPoliticasCliente(estadopoliticasclienteLocal)) {				
					EstadoPoliticasClienteDataAccess.save(estadopoliticasclienteLocal, connexion);				
				} else {
					validadoTodosEstadoPoliticasCliente=false;
				}
			}
			
			if(!validadoTodosEstadoPoliticasCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoPoliticasClienteLogicAdditional.checkEstadoPoliticasClienteToSavesAfter(estadopoliticasclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoPoliticasClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPoliticasClienteParameterReturnGeneral procesarAccionEstadoPoliticasClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPoliticasCliente> estadopoliticasclientes,EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteParameterGeneral)throws Exception {
		 try {	
			EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteReturnGeneral=new EstadoPoliticasClienteParameterReturnGeneral();
	
			EstadoPoliticasClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadopoliticasclientes,estadopoliticasclienteParameterGeneral,estadopoliticasclienteReturnGeneral);
			
			return estadopoliticasclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPoliticasClienteParameterReturnGeneral procesarAccionEstadoPoliticasClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPoliticasCliente> estadopoliticasclientes,EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-procesarAccionEstadoPoliticasClientesWithConnection");connexion.begin();			
			
			EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteReturnGeneral=new EstadoPoliticasClienteParameterReturnGeneral();
	
			EstadoPoliticasClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadopoliticasclientes,estadopoliticasclienteParameterGeneral,estadopoliticasclienteReturnGeneral);
			
			this.connexion.commit();
			
			return estadopoliticasclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPoliticasClienteParameterReturnGeneral procesarEventosEstadoPoliticasClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPoliticasCliente> estadopoliticasclientes,EstadoPoliticasCliente estadopoliticascliente,EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteParameterGeneral,Boolean isEsNuevoEstadoPoliticasCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteReturnGeneral=new EstadoPoliticasClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadopoliticasclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoPoliticasClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadopoliticasclientes,estadopoliticascliente,estadopoliticasclienteParameterGeneral,estadopoliticasclienteReturnGeneral,isEsNuevoEstadoPoliticasCliente,clases);
			
			return estadopoliticasclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoPoliticasClienteParameterReturnGeneral procesarEventosEstadoPoliticasClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPoliticasCliente> estadopoliticasclientes,EstadoPoliticasCliente estadopoliticascliente,EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteParameterGeneral,Boolean isEsNuevoEstadoPoliticasCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-procesarEventosEstadoPoliticasClientesWithConnection");connexion.begin();			
			
			EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteReturnGeneral=new EstadoPoliticasClienteParameterReturnGeneral();
	
			estadopoliticasclienteReturnGeneral.setEstadoPoliticasCliente(estadopoliticascliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadopoliticasclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoPoliticasClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadopoliticasclientes,estadopoliticascliente,estadopoliticasclienteParameterGeneral,estadopoliticasclienteReturnGeneral,isEsNuevoEstadoPoliticasCliente,clases);
			
			this.connexion.commit();
			
			return estadopoliticasclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPoliticasClienteParameterReturnGeneral procesarImportacionEstadoPoliticasClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-procesarImportacionEstadoPoliticasClientesWithConnection");connexion.begin();			
			
			EstadoPoliticasClienteParameterReturnGeneral estadopoliticasclienteReturnGeneral=new EstadoPoliticasClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadopoliticasclientes=new ArrayList<EstadoPoliticasCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadopoliticascliente=new EstadoPoliticasCliente();
				
				
				if(conColumnasBase) {this.estadopoliticascliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadopoliticascliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadopoliticascliente.setcodigo(arrColumnas[iColumn++]);
				this.estadopoliticascliente.setnombre(arrColumnas[iColumn++]);
				
				this.estadopoliticasclientes.add(this.estadopoliticascliente);
			}
			
			this.saveEstadoPoliticasClientes();
			
			this.connexion.commit();
			
			estadopoliticasclienteReturnGeneral.setConRetornoEstaProcesado(true);
			estadopoliticasclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadopoliticasclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoPoliticasClientesEliminados() throws Exception {				
		
		List<EstadoPoliticasCliente> estadopoliticasclientesAux= new ArrayList<EstadoPoliticasCliente>();
		
		for(EstadoPoliticasCliente estadopoliticascliente:estadopoliticasclientes) {
			if(!estadopoliticascliente.getIsDeleted()) {
				estadopoliticasclientesAux.add(estadopoliticascliente);
			}
		}
		
		estadopoliticasclientes=estadopoliticasclientesAux;
	}
	
	public void quitarEstadoPoliticasClientesNulos() throws Exception {				
		
		List<EstadoPoliticasCliente> estadopoliticasclientesAux= new ArrayList<EstadoPoliticasCliente>();
		
		for(EstadoPoliticasCliente estadopoliticascliente : this.estadopoliticasclientes) {
			if(estadopoliticascliente==null) {
				estadopoliticasclientesAux.add(estadopoliticascliente);
			}
		}
		
		//this.estadopoliticasclientes=estadopoliticasclientesAux;
		
		this.estadopoliticasclientes.removeAll(estadopoliticasclientesAux);
	}
	
	public void getSetVersionRowEstadoPoliticasClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadopoliticascliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadopoliticascliente.getIsDeleted() || (estadopoliticascliente.getIsChanged()&&!estadopoliticascliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadopoliticasclienteDataAccess.getSetVersionRowEstadoPoliticasCliente(connexion,estadopoliticascliente.getId());
				
				if(!estadopoliticascliente.getVersionRow().equals(timestamp)) {	
					estadopoliticascliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadopoliticascliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoPoliticasCliente()throws Exception {	
		
		if(estadopoliticascliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadopoliticascliente.getIsDeleted() || (estadopoliticascliente.getIsChanged()&&!estadopoliticascliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadopoliticasclienteDataAccess.getSetVersionRowEstadoPoliticasCliente(connexion,estadopoliticascliente.getId());
			
			try {							
				if(!estadopoliticascliente.getVersionRow().equals(timestamp)) {	
					estadopoliticascliente.setVersionRow(timestamp);
				}
				
				estadopoliticascliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoPoliticasClientesWithConnection()throws Exception {	
		if(estadopoliticasclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoPoliticasCliente estadopoliticasclienteAux:estadopoliticasclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadopoliticasclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadopoliticasclienteAux.getIsDeleted() || (estadopoliticasclienteAux.getIsChanged()&&!estadopoliticasclienteAux.getIsNew())) {
						
						timestamp=estadopoliticasclienteDataAccess.getSetVersionRowEstadoPoliticasCliente(connexion,estadopoliticasclienteAux.getId());
						
						if(!estadopoliticascliente.getVersionRow().equals(timestamp)) {	
							estadopoliticasclienteAux.setVersionRow(timestamp);
						}
								
						estadopoliticasclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoPoliticasClientes()throws Exception {	
		if(estadopoliticasclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoPoliticasCliente estadopoliticasclienteAux:estadopoliticasclientes) {
					if(estadopoliticasclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadopoliticasclienteAux.getIsDeleted() || (estadopoliticasclienteAux.getIsChanged()&&!estadopoliticasclienteAux.getIsNew())) {
						
						timestamp=estadopoliticasclienteDataAccess.getSetVersionRowEstadoPoliticasCliente(connexion,estadopoliticasclienteAux.getId());
						
						if(!estadopoliticasclienteAux.getVersionRow().equals(timestamp)) {	
							estadopoliticasclienteAux.setVersionRow(timestamp);
						}
						
													
						estadopoliticasclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoPoliticasClienteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PoliticasClienteLogic politicasclienteLogic=new PoliticasClienteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPoliticasCliente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoPoliticasClienteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PoliticasCliente.class));
											
			

			politicasclienteLogic.setConnexion(this.getConnexion());
			politicasclienteLogic.setDatosCliente(this.datosCliente);
			politicasclienteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoPoliticasCliente estadopoliticascliente:this.estadopoliticasclientes) {
				

				classes=new ArrayList<Classe>();
				classes=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				politicasclienteLogic.setPoliticasClientes(estadopoliticascliente.politicasclientes);
				politicasclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoPoliticasCliente estadopoliticascliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoPoliticasClienteLogicAdditional.updateEstadoPoliticasClienteToGet(estadopoliticascliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadopoliticascliente.setPoliticasClientes(estadopoliticasclienteDataAccess.getPoliticasClientes(connexion,estadopoliticascliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopoliticascliente.setPoliticasClientes(estadopoliticasclienteDataAccess.getPoliticasClientes(connexion,estadopoliticascliente));

				if(this.isConDeep) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(this.connexion);
					politicasclienteLogic.setPoliticasClientes(estadopoliticascliente.getPoliticasClientes());
					ArrayList<Classe> classesLocal=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					politicasclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(politicasclienteLogic.getPoliticasClientes());
					estadopoliticascliente.setPoliticasClientes(politicasclienteLogic.getPoliticasClientes());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			estadopoliticascliente.setPoliticasClientes(estadopoliticasclienteDataAccess.getPoliticasClientes(connexion,estadopoliticascliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadopoliticascliente.setPoliticasClientes(estadopoliticasclienteDataAccess.getPoliticasClientes(connexion,estadopoliticascliente));

		for(PoliticasCliente politicascliente:estadopoliticascliente.getPoliticasClientes()) {
			PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
			politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopoliticascliente.setPoliticasClientes(estadopoliticasclienteDataAccess.getPoliticasClientes(connexion,estadopoliticascliente));

				for(PoliticasCliente politicascliente:estadopoliticascliente.getPoliticasClientes()) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
					politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			estadopoliticascliente.setPoliticasClientes(estadopoliticasclienteDataAccess.getPoliticasClientes(connexion,estadopoliticascliente));

			for(PoliticasCliente politicascliente:estadopoliticascliente.getPoliticasClientes()) {
				PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
				politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoPoliticasCliente estadopoliticascliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoPoliticasClienteLogicAdditional.updateEstadoPoliticasClienteToSave(estadopoliticascliente,this.arrDatoGeneral);
			
EstadoPoliticasClienteDataAccess.save(estadopoliticascliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(PoliticasCliente politicascliente:estadopoliticascliente.getPoliticasClientes()) {
			politicascliente.setid_estado_politicas_cliente(estadopoliticascliente.getId());
			PoliticasClienteDataAccess.save(politicascliente,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticasCliente politicascliente:estadopoliticascliente.getPoliticasClientes()) {
					politicascliente.setid_estado_politicas_cliente(estadopoliticascliente.getId());
					PoliticasClienteDataAccess.save(politicascliente,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(PoliticasCliente politicascliente:estadopoliticascliente.getPoliticasClientes()) {
			PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
			politicascliente.setid_estado_politicas_cliente(estadopoliticascliente.getId());
			PoliticasClienteDataAccess.save(politicascliente,connexion);
			politicasclienteLogic.deepSave(politicascliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticasCliente politicascliente:estadopoliticascliente.getPoliticasClientes()) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
					politicascliente.setid_estado_politicas_cliente(estadopoliticascliente.getId());
					PoliticasClienteDataAccess.save(politicascliente,connexion);
					politicasclienteLogic.deepSave(politicascliente,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoPoliticasCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadopoliticascliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(estadopoliticascliente);
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
			this.deepLoad(this.estadopoliticascliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(this.estadopoliticascliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoPoliticasCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadopoliticasclientes!=null) {
				for(EstadoPoliticasCliente estadopoliticascliente:estadopoliticasclientes) {
					this.deepLoad(estadopoliticascliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(estadopoliticasclientes);
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
			if(estadopoliticasclientes!=null) {
				for(EstadoPoliticasCliente estadopoliticascliente:estadopoliticasclientes) {
					this.deepLoad(estadopoliticascliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoPoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPoliticasCliente(estadopoliticasclientes);
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
			this.getNewConnexionToDeep(EstadoPoliticasCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadopoliticascliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoPoliticasCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadopoliticasclientes!=null) {
				for(EstadoPoliticasCliente estadopoliticascliente:estadopoliticasclientes) {
					this.deepSave(estadopoliticascliente,isDeep,deepLoadType,clases);
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
			if(estadopoliticasclientes!=null) {
				for(EstadoPoliticasCliente estadopoliticascliente:estadopoliticasclientes) {
					this.deepSave(estadopoliticascliente,isDeep,deepLoadType,clases);
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
			if(EstadoPoliticasClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPoliticasClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoPoliticasCliente estadopoliticascliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoPoliticasClienteConstantesFunciones.ISCONAUDITORIA) {
				if(estadopoliticascliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPoliticasClienteDataAccess.TABLENAME, estadopoliticascliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPoliticasClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPoliticasClienteLogic.registrarAuditoriaDetallesEstadoPoliticasCliente(connexion,estadopoliticascliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadopoliticascliente.getIsDeleted()) {
					/*if(!estadopoliticascliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoPoliticasClienteDataAccess.TABLENAME, estadopoliticascliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoPoliticasClienteLogic.registrarAuditoriaDetallesEstadoPoliticasCliente(connexion,estadopoliticascliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPoliticasClienteDataAccess.TABLENAME, estadopoliticascliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadopoliticascliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPoliticasClienteDataAccess.TABLENAME, estadopoliticascliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPoliticasClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPoliticasClienteLogic.registrarAuditoriaDetallesEstadoPoliticasCliente(connexion,estadopoliticascliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoPoliticasCliente(Connexion connexion,EstadoPoliticasCliente estadopoliticascliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadopoliticascliente.getIsNew()||!estadopoliticascliente.getcodigo().equals(estadopoliticascliente.getEstadoPoliticasClienteOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadopoliticascliente.getEstadoPoliticasClienteOriginal().getcodigo()!=null)
				{
					strValorActual=estadopoliticascliente.getEstadoPoliticasClienteOriginal().getcodigo();
				}
				if(estadopoliticascliente.getcodigo()!=null)
				{
					strValorNuevo=estadopoliticascliente.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoPoliticasClienteConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadopoliticascliente.getIsNew()||!estadopoliticascliente.getnombre().equals(estadopoliticascliente.getEstadoPoliticasClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadopoliticascliente.getEstadoPoliticasClienteOriginal().getnombre()!=null)
				{
					strValorActual=estadopoliticascliente.getEstadoPoliticasClienteOriginal().getnombre();
				}
				if(estadopoliticascliente.getnombre()!=null)
				{
					strValorNuevo=estadopoliticascliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoPoliticasClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoPoliticasClienteRelacionesWithConnection(EstadoPoliticasCliente estadopoliticascliente,List<PoliticasCliente> politicasclientes) throws Exception {

		if(!estadopoliticascliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoPoliticasClienteRelacionesBase(estadopoliticascliente,politicasclientes,true);
		}
	}

	public void saveEstadoPoliticasClienteRelaciones(EstadoPoliticasCliente estadopoliticascliente,List<PoliticasCliente> politicasclientes)throws Exception {

		if(!estadopoliticascliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoPoliticasClienteRelacionesBase(estadopoliticascliente,politicasclientes,false);
		}
	}

	public void saveEstadoPoliticasClienteRelacionesBase(EstadoPoliticasCliente estadopoliticascliente,List<PoliticasCliente> politicasclientes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoPoliticasCliente-saveRelacionesWithConnection");}
	
			estadopoliticascliente.setPoliticasClientes(politicasclientes);

			this.setEstadoPoliticasCliente(estadopoliticascliente);

				if((estadopoliticascliente.getIsNew()||estadopoliticascliente.getIsChanged())&&!estadopoliticascliente.getIsDeleted()) {
					this.saveEstadoPoliticasCliente();
					this.saveEstadoPoliticasClienteRelacionesDetalles(politicasclientes);

				} else if(estadopoliticascliente.getIsDeleted()) {
					this.saveEstadoPoliticasClienteRelacionesDetalles(politicasclientes);
					this.saveEstadoPoliticasCliente();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PoliticasClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresPoliticasClientes(politicasclientes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoPoliticasClienteRelacionesDetalles(List<PoliticasCliente> politicasclientes)throws Exception {
		try {
	

			Long idEstadoPoliticasClienteActual=this.getEstadoPoliticasCliente().getId();

			PoliticasClienteLogic politicasclienteLogic_Desde_EstadoPoliticasCliente=new PoliticasClienteLogic();
			politicasclienteLogic_Desde_EstadoPoliticasCliente.setPoliticasClientes(politicasclientes);

			politicasclienteLogic_Desde_EstadoPoliticasCliente.setConnexion(this.getConnexion());
			politicasclienteLogic_Desde_EstadoPoliticasCliente.setDatosCliente(this.datosCliente);

			for(PoliticasCliente politicascliente_Desde_EstadoPoliticasCliente:politicasclienteLogic_Desde_EstadoPoliticasCliente.getPoliticasClientes()) {
				politicascliente_Desde_EstadoPoliticasCliente.setid_estado_politicas_cliente(idEstadoPoliticasClienteActual);
			}

			politicasclienteLogic_Desde_EstadoPoliticasCliente.savePoliticasClientes();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPoliticasClienteConstantesFunciones.getClassesForeignKeysOfEstadoPoliticasCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPoliticasClienteConstantesFunciones.getClassesRelationshipsOfEstadoPoliticasCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

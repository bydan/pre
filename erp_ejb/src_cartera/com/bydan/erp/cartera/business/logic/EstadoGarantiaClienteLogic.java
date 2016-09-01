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
import com.bydan.erp.cartera.util.EstadoGarantiaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.EstadoGarantiaClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EstadoGarantiaClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.EstadoGarantiaCliente;
import com.bydan.erp.cartera.business.logic.EstadoGarantiaClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoGarantiaClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoGarantiaClienteLogic.class);
	
	protected EstadoGarantiaClienteDataAccess estadogarantiaclienteDataAccess; 	
	protected EstadoGarantiaCliente estadogarantiacliente;
	protected List<EstadoGarantiaCliente> estadogarantiaclientes;
	protected Object estadogarantiaclienteObject;	
	protected List<Object> estadogarantiaclientesObject;
	
	public static ClassValidator<EstadoGarantiaCliente> estadogarantiaclienteValidator = new ClassValidator<EstadoGarantiaCliente>(EstadoGarantiaCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoGarantiaClienteLogicAdditional estadogarantiaclienteLogicAdditional=null;
	
	public EstadoGarantiaClienteLogicAdditional getEstadoGarantiaClienteLogicAdditional() {
		return this.estadogarantiaclienteLogicAdditional;
	}
	
	public void setEstadoGarantiaClienteLogicAdditional(EstadoGarantiaClienteLogicAdditional estadogarantiaclienteLogicAdditional) {
		try {
			this.estadogarantiaclienteLogicAdditional=estadogarantiaclienteLogicAdditional;
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
	
	
	
	
	public  EstadoGarantiaClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadogarantiaclienteDataAccess = new EstadoGarantiaClienteDataAccess();
			
			this.estadogarantiaclientes= new ArrayList<EstadoGarantiaCliente>();
			this.estadogarantiacliente= new EstadoGarantiaCliente();
			
			this.estadogarantiaclienteObject=new Object();
			this.estadogarantiaclientesObject=new ArrayList<Object>();
				
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
			
			this.estadogarantiaclienteDataAccess.setConnexionType(this.connexionType);
			this.estadogarantiaclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoGarantiaClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadogarantiaclienteDataAccess = new EstadoGarantiaClienteDataAccess();
			this.estadogarantiaclientes= new ArrayList<EstadoGarantiaCliente>();
			this.estadogarantiacliente= new EstadoGarantiaCliente();
			this.estadogarantiaclienteObject=new Object();
			this.estadogarantiaclientesObject=new ArrayList<Object>();
			
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
			
			this.estadogarantiaclienteDataAccess.setConnexionType(this.connexionType);
			this.estadogarantiaclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoGarantiaCliente getEstadoGarantiaCliente() throws Exception {	
		EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToGet(estadogarantiacliente,this.datosCliente,this.arrDatoGeneral);
		EstadoGarantiaClienteLogicAdditional.updateEstadoGarantiaClienteToGet(estadogarantiacliente,this.arrDatoGeneral);
		
		return estadogarantiacliente;
	}
		
	public void setEstadoGarantiaCliente(EstadoGarantiaCliente newEstadoGarantiaCliente) {
		this.estadogarantiacliente = newEstadoGarantiaCliente;
	}
	
	public EstadoGarantiaClienteDataAccess getEstadoGarantiaClienteDataAccess() {
		return estadogarantiaclienteDataAccess;
	}
	
	public void setEstadoGarantiaClienteDataAccess(EstadoGarantiaClienteDataAccess newestadogarantiaclienteDataAccess) {
		this.estadogarantiaclienteDataAccess = newestadogarantiaclienteDataAccess;
	}
	
	public List<EstadoGarantiaCliente> getEstadoGarantiaClientes() throws Exception {		
		this.quitarEstadoGarantiaClientesNulos();
		
		EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToGets(estadogarantiaclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoGarantiaCliente estadogarantiaclienteLocal: estadogarantiaclientes ) {
			EstadoGarantiaClienteLogicAdditional.updateEstadoGarantiaClienteToGet(estadogarantiaclienteLocal,this.arrDatoGeneral);
		}
		
		return estadogarantiaclientes;
	}
	
	public void setEstadoGarantiaClientes(List<EstadoGarantiaCliente> newEstadoGarantiaClientes) {
		this.estadogarantiaclientes = newEstadoGarantiaClientes;
	}
	
	public Object getEstadoGarantiaClienteObject() {	
		this.estadogarantiaclienteObject=this.estadogarantiaclienteDataAccess.getEntityObject();
		return this.estadogarantiaclienteObject;
	}
		
	public void setEstadoGarantiaClienteObject(Object newEstadoGarantiaClienteObject) {
		this.estadogarantiaclienteObject = newEstadoGarantiaClienteObject;
	}
	
	public List<Object> getEstadoGarantiaClientesObject() {		
		this.estadogarantiaclientesObject=this.estadogarantiaclienteDataAccess.getEntitiesObject();
		return this.estadogarantiaclientesObject;
	}
		
	public void setEstadoGarantiaClientesObject(List<Object> newEstadoGarantiaClientesObject) {
		this.estadogarantiaclientesObject = newEstadoGarantiaClientesObject;
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
		
		if(this.estadogarantiaclienteDataAccess!=null) {
			this.estadogarantiaclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadogarantiaclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadogarantiaclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadogarantiacliente = new  EstadoGarantiaCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadogarantiacliente=estadogarantiaclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadogarantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiacliente);
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
		estadogarantiacliente = new  EstadoGarantiaCliente();
		  		  
        try {
			
			estadogarantiacliente=estadogarantiaclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadogarantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadogarantiacliente = new  EstadoGarantiaCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadogarantiacliente=estadogarantiaclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadogarantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiacliente);
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
		estadogarantiacliente = new  EstadoGarantiaCliente();
		  		  
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
		estadogarantiacliente = new  EstadoGarantiaCliente();
		  		  
        try {
			
			estadogarantiacliente=estadogarantiaclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadogarantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadogarantiacliente = new  EstadoGarantiaCliente();
		  		  
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
		estadogarantiacliente = new  EstadoGarantiaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadogarantiaclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadogarantiacliente = new  EstadoGarantiaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadogarantiaclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadogarantiacliente = new  EstadoGarantiaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadogarantiaclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadogarantiacliente = new  EstadoGarantiaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadogarantiaclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadogarantiacliente = new  EstadoGarantiaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadogarantiaclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadogarantiacliente = new  EstadoGarantiaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadogarantiaclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
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
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		  		  
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
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		  		  
        try {			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		  		  
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
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
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
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		  		  
        try {
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
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
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
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
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadogarantiacliente = new  EstadoGarantiaCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiacliente=estadogarantiaclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiacliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiacliente);
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
		estadogarantiacliente = new  EstadoGarantiaCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiacliente=estadogarantiaclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiacliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
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
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		  		  
        try {
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoGarantiaClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-getTodosEstadoGarantiaClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
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
	
	public  void  getTodosEstadoGarantiaClientes(String sFinalQuery,Pagination pagination)throws Exception {
		estadogarantiaclientes = new  ArrayList<EstadoGarantiaCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogarantiaclientes=estadogarantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoGarantiaCliente(estadogarantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiaclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoGarantiaCliente(EstadoGarantiaCliente estadogarantiacliente) throws Exception {
		Boolean estaValidado=false;
		
		if(estadogarantiacliente.getIsNew() || estadogarantiacliente.getIsChanged()) { 
			this.invalidValues = estadogarantiaclienteValidator.getInvalidValues(estadogarantiacliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadogarantiacliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoGarantiaCliente(List<EstadoGarantiaCliente> EstadoGarantiaClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoGarantiaCliente estadogarantiaclienteLocal:estadogarantiaclientes) {				
			estaValidadoObjeto=this.validarGuardarEstadoGarantiaCliente(estadogarantiaclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoGarantiaCliente(List<EstadoGarantiaCliente> EstadoGarantiaClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoGarantiaCliente(estadogarantiaclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoGarantiaCliente(EstadoGarantiaCliente EstadoGarantiaCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoGarantiaCliente(estadogarantiacliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoGarantiaCliente estadogarantiacliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadogarantiacliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoGarantiaClienteConstantesFunciones.getEstadoGarantiaClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadogarantiacliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoGarantiaClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoGarantiaClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoGarantiaClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-saveEstadoGarantiaClienteWithConnection");connexion.begin();			
			
			EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToSave(this.estadogarantiacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoGarantiaClienteLogicAdditional.updateEstadoGarantiaClienteToSave(this.estadogarantiacliente,this.arrDatoGeneral);
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadogarantiacliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoGarantiaCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoGarantiaCliente(this.estadogarantiacliente)) {
				EstadoGarantiaClienteDataAccess.save(this.estadogarantiacliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadogarantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToSaveAfter(this.estadogarantiacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoGarantiaCliente();
			
			connexion.commit();			
			
			if(this.estadogarantiacliente.getIsDeleted()) {
				this.estadogarantiacliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoGarantiaCliente()throws Exception {	
		try {	
			
			EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToSave(this.estadogarantiacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoGarantiaClienteLogicAdditional.updateEstadoGarantiaClienteToSave(this.estadogarantiacliente,this.arrDatoGeneral);
			
			EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadogarantiacliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoGarantiaCliente(this.estadogarantiacliente)) {			
				EstadoGarantiaClienteDataAccess.save(this.estadogarantiacliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadogarantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToSaveAfter(this.estadogarantiacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadogarantiacliente.getIsDeleted()) {
				this.estadogarantiacliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoGarantiaClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-saveEstadoGarantiaClientesWithConnection");connexion.begin();			
			
			EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToSaves(estadogarantiaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoGarantiaClientes();
			
			Boolean validadoTodosEstadoGarantiaCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoGarantiaCliente estadogarantiaclienteLocal:estadogarantiaclientes) {		
				if(estadogarantiaclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoGarantiaClienteLogicAdditional.updateEstadoGarantiaClienteToSave(estadogarantiaclienteLocal,this.arrDatoGeneral);
	        	
				EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadogarantiaclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoGarantiaCliente(estadogarantiaclienteLocal)) {
					EstadoGarantiaClienteDataAccess.save(estadogarantiaclienteLocal, connexion);				
				} else {
					validadoTodosEstadoGarantiaCliente=false;
				}
			}
			
			if(!validadoTodosEstadoGarantiaCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToSavesAfter(estadogarantiaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoGarantiaClientes();
			
			connexion.commit();		
			
			this.quitarEstadoGarantiaClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoGarantiaClientes()throws Exception {				
		 try {	
			EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToSaves(estadogarantiaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoGarantiaCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoGarantiaCliente estadogarantiaclienteLocal:estadogarantiaclientes) {				
				if(estadogarantiaclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoGarantiaClienteLogicAdditional.updateEstadoGarantiaClienteToSave(estadogarantiaclienteLocal,this.arrDatoGeneral);
	        	
				EstadoGarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadogarantiaclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoGarantiaCliente(estadogarantiaclienteLocal)) {				
					EstadoGarantiaClienteDataAccess.save(estadogarantiaclienteLocal, connexion);				
				} else {
					validadoTodosEstadoGarantiaCliente=false;
				}
			}
			
			if(!validadoTodosEstadoGarantiaCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoGarantiaClienteLogicAdditional.checkEstadoGarantiaClienteToSavesAfter(estadogarantiaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoGarantiaClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoGarantiaClienteParameterReturnGeneral procesarAccionEstadoGarantiaClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoGarantiaCliente> estadogarantiaclientes,EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteParameterGeneral)throws Exception {
		 try {	
			EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteReturnGeneral=new EstadoGarantiaClienteParameterReturnGeneral();
	
			EstadoGarantiaClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadogarantiaclientes,estadogarantiaclienteParameterGeneral,estadogarantiaclienteReturnGeneral);
			
			return estadogarantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoGarantiaClienteParameterReturnGeneral procesarAccionEstadoGarantiaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoGarantiaCliente> estadogarantiaclientes,EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-procesarAccionEstadoGarantiaClientesWithConnection");connexion.begin();			
			
			EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteReturnGeneral=new EstadoGarantiaClienteParameterReturnGeneral();
	
			EstadoGarantiaClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadogarantiaclientes,estadogarantiaclienteParameterGeneral,estadogarantiaclienteReturnGeneral);
			
			this.connexion.commit();
			
			return estadogarantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoGarantiaClienteParameterReturnGeneral procesarEventosEstadoGarantiaClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoGarantiaCliente> estadogarantiaclientes,EstadoGarantiaCliente estadogarantiacliente,EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteParameterGeneral,Boolean isEsNuevoEstadoGarantiaCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteReturnGeneral=new EstadoGarantiaClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadogarantiaclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoGarantiaClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadogarantiaclientes,estadogarantiacliente,estadogarantiaclienteParameterGeneral,estadogarantiaclienteReturnGeneral,isEsNuevoEstadoGarantiaCliente,clases);
			
			return estadogarantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoGarantiaClienteParameterReturnGeneral procesarEventosEstadoGarantiaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoGarantiaCliente> estadogarantiaclientes,EstadoGarantiaCliente estadogarantiacliente,EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteParameterGeneral,Boolean isEsNuevoEstadoGarantiaCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-procesarEventosEstadoGarantiaClientesWithConnection");connexion.begin();			
			
			EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteReturnGeneral=new EstadoGarantiaClienteParameterReturnGeneral();
	
			estadogarantiaclienteReturnGeneral.setEstadoGarantiaCliente(estadogarantiacliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadogarantiaclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoGarantiaClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadogarantiaclientes,estadogarantiacliente,estadogarantiaclienteParameterGeneral,estadogarantiaclienteReturnGeneral,isEsNuevoEstadoGarantiaCliente,clases);
			
			this.connexion.commit();
			
			return estadogarantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoGarantiaClienteParameterReturnGeneral procesarImportacionEstadoGarantiaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-procesarImportacionEstadoGarantiaClientesWithConnection");connexion.begin();			
			
			EstadoGarantiaClienteParameterReturnGeneral estadogarantiaclienteReturnGeneral=new EstadoGarantiaClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadogarantiaclientes=new ArrayList<EstadoGarantiaCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadogarantiacliente=new EstadoGarantiaCliente();
				
				
				if(conColumnasBase) {this.estadogarantiacliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadogarantiacliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadogarantiacliente.setcodigo(arrColumnas[iColumn++]);
				this.estadogarantiacliente.setnombre(arrColumnas[iColumn++]);
				
				this.estadogarantiaclientes.add(this.estadogarantiacliente);
			}
			
			this.saveEstadoGarantiaClientes();
			
			this.connexion.commit();
			
			estadogarantiaclienteReturnGeneral.setConRetornoEstaProcesado(true);
			estadogarantiaclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadogarantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoGarantiaClientesEliminados() throws Exception {				
		
		List<EstadoGarantiaCliente> estadogarantiaclientesAux= new ArrayList<EstadoGarantiaCliente>();
		
		for(EstadoGarantiaCliente estadogarantiacliente:estadogarantiaclientes) {
			if(!estadogarantiacliente.getIsDeleted()) {
				estadogarantiaclientesAux.add(estadogarantiacliente);
			}
		}
		
		estadogarantiaclientes=estadogarantiaclientesAux;
	}
	
	public void quitarEstadoGarantiaClientesNulos() throws Exception {				
		
		List<EstadoGarantiaCliente> estadogarantiaclientesAux= new ArrayList<EstadoGarantiaCliente>();
		
		for(EstadoGarantiaCliente estadogarantiacliente : this.estadogarantiaclientes) {
			if(estadogarantiacliente==null) {
				estadogarantiaclientesAux.add(estadogarantiacliente);
			}
		}
		
		//this.estadogarantiaclientes=estadogarantiaclientesAux;
		
		this.estadogarantiaclientes.removeAll(estadogarantiaclientesAux);
	}
	
	public void getSetVersionRowEstadoGarantiaClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadogarantiacliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadogarantiacliente.getIsDeleted() || (estadogarantiacliente.getIsChanged()&&!estadogarantiacliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadogarantiaclienteDataAccess.getSetVersionRowEstadoGarantiaCliente(connexion,estadogarantiacliente.getId());
				
				if(!estadogarantiacliente.getVersionRow().equals(timestamp)) {	
					estadogarantiacliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadogarantiacliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoGarantiaCliente()throws Exception {	
		
		if(estadogarantiacliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadogarantiacliente.getIsDeleted() || (estadogarantiacliente.getIsChanged()&&!estadogarantiacliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadogarantiaclienteDataAccess.getSetVersionRowEstadoGarantiaCliente(connexion,estadogarantiacliente.getId());
			
			try {							
				if(!estadogarantiacliente.getVersionRow().equals(timestamp)) {	
					estadogarantiacliente.setVersionRow(timestamp);
				}
				
				estadogarantiacliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoGarantiaClientesWithConnection()throws Exception {	
		if(estadogarantiaclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoGarantiaCliente estadogarantiaclienteAux:estadogarantiaclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadogarantiaclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadogarantiaclienteAux.getIsDeleted() || (estadogarantiaclienteAux.getIsChanged()&&!estadogarantiaclienteAux.getIsNew())) {
						
						timestamp=estadogarantiaclienteDataAccess.getSetVersionRowEstadoGarantiaCliente(connexion,estadogarantiaclienteAux.getId());
						
						if(!estadogarantiacliente.getVersionRow().equals(timestamp)) {	
							estadogarantiaclienteAux.setVersionRow(timestamp);
						}
								
						estadogarantiaclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoGarantiaClientes()throws Exception {	
		if(estadogarantiaclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoGarantiaCliente estadogarantiaclienteAux:estadogarantiaclientes) {
					if(estadogarantiaclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadogarantiaclienteAux.getIsDeleted() || (estadogarantiaclienteAux.getIsChanged()&&!estadogarantiaclienteAux.getIsNew())) {
						
						timestamp=estadogarantiaclienteDataAccess.getSetVersionRowEstadoGarantiaCliente(connexion,estadogarantiaclienteAux.getId());
						
						if(!estadogarantiaclienteAux.getVersionRow().equals(timestamp)) {	
							estadogarantiaclienteAux.setVersionRow(timestamp);
						}
						
													
						estadogarantiaclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoGarantiaClienteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			GarantiaClienteLogic garantiaclienteLogic=new GarantiaClienteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGarantiaCliente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoGarantiaClienteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(GarantiaCliente.class));
											
			

			garantiaclienteLogic.setConnexion(this.getConnexion());
			garantiaclienteLogic.setDatosCliente(this.datosCliente);
			garantiaclienteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoGarantiaCliente estadogarantiacliente:this.estadogarantiaclientes) {
				

				classes=new ArrayList<Classe>();
				classes=GarantiaClienteConstantesFunciones.getClassesForeignKeysOfGarantiaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				garantiaclienteLogic.setGarantiaClientes(estadogarantiacliente.garantiaclientes);
				garantiaclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoGarantiaCliente estadogarantiacliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoGarantiaClienteLogicAdditional.updateEstadoGarantiaClienteToGet(estadogarantiacliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadogarantiacliente.setGarantiaClientes(estadogarantiaclienteDataAccess.getGarantiaClientes(connexion,estadogarantiacliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadogarantiacliente.setGarantiaClientes(estadogarantiaclienteDataAccess.getGarantiaClientes(connexion,estadogarantiacliente));

				if(this.isConDeep) {
					GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(this.connexion);
					garantiaclienteLogic.setGarantiaClientes(estadogarantiacliente.getGarantiaClientes());
					ArrayList<Classe> classesLocal=GarantiaClienteConstantesFunciones.getClassesForeignKeysOfGarantiaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					garantiaclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(garantiaclienteLogic.getGarantiaClientes());
					estadogarantiacliente.setGarantiaClientes(garantiaclienteLogic.getGarantiaClientes());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GarantiaCliente.class));
			estadogarantiacliente.setGarantiaClientes(estadogarantiaclienteDataAccess.getGarantiaClientes(connexion,estadogarantiacliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadogarantiacliente.setGarantiaClientes(estadogarantiaclienteDataAccess.getGarantiaClientes(connexion,estadogarantiacliente));

		for(GarantiaCliente garantiacliente:estadogarantiacliente.getGarantiaClientes()) {
			GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
			garantiaclienteLogic.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadogarantiacliente.setGarantiaClientes(estadogarantiaclienteDataAccess.getGarantiaClientes(connexion,estadogarantiacliente));

				for(GarantiaCliente garantiacliente:estadogarantiacliente.getGarantiaClientes()) {
					GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
					garantiaclienteLogic.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GarantiaCliente.class));
			estadogarantiacliente.setGarantiaClientes(estadogarantiaclienteDataAccess.getGarantiaClientes(connexion,estadogarantiacliente));

			for(GarantiaCliente garantiacliente:estadogarantiacliente.getGarantiaClientes()) {
				GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
				garantiaclienteLogic.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoGarantiaCliente estadogarantiacliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoGarantiaClienteLogicAdditional.updateEstadoGarantiaClienteToSave(estadogarantiacliente,this.arrDatoGeneral);
			
EstadoGarantiaClienteDataAccess.save(estadogarantiacliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(GarantiaCliente garantiacliente:estadogarantiacliente.getGarantiaClientes()) {
			garantiacliente.setid_estado_garantia_cliente(estadogarantiacliente.getId());
			GarantiaClienteDataAccess.save(garantiacliente,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GarantiaCliente garantiacliente:estadogarantiacliente.getGarantiaClientes()) {
					garantiacliente.setid_estado_garantia_cliente(estadogarantiacliente.getId());
					GarantiaClienteDataAccess.save(garantiacliente,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(GarantiaCliente garantiacliente:estadogarantiacliente.getGarantiaClientes()) {
			GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
			garantiacliente.setid_estado_garantia_cliente(estadogarantiacliente.getId());
			GarantiaClienteDataAccess.save(garantiacliente,connexion);
			garantiaclienteLogic.deepSave(garantiacliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GarantiaCliente garantiacliente:estadogarantiacliente.getGarantiaClientes()) {
					GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
					garantiacliente.setid_estado_garantia_cliente(estadogarantiacliente.getId());
					GarantiaClienteDataAccess.save(garantiacliente,connexion);
					garantiaclienteLogic.deepSave(garantiacliente,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoGarantiaCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadogarantiacliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(estadogarantiacliente);
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
			this.deepLoad(this.estadogarantiacliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(this.estadogarantiacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoGarantiaCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadogarantiaclientes!=null) {
				for(EstadoGarantiaCliente estadogarantiacliente:estadogarantiaclientes) {
					this.deepLoad(estadogarantiacliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(estadogarantiaclientes);
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
			if(estadogarantiaclientes!=null) {
				for(EstadoGarantiaCliente estadogarantiacliente:estadogarantiaclientes) {
					this.deepLoad(estadogarantiacliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoGarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGarantiaCliente(estadogarantiaclientes);
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
			this.getNewConnexionToDeep(EstadoGarantiaCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadogarantiacliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoGarantiaCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadogarantiaclientes!=null) {
				for(EstadoGarantiaCliente estadogarantiacliente:estadogarantiaclientes) {
					this.deepSave(estadogarantiacliente,isDeep,deepLoadType,clases);
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
			if(estadogarantiaclientes!=null) {
				for(EstadoGarantiaCliente estadogarantiacliente:estadogarantiaclientes) {
					this.deepSave(estadogarantiacliente,isDeep,deepLoadType,clases);
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
			if(EstadoGarantiaClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoGarantiaClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoGarantiaCliente estadogarantiacliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoGarantiaClienteConstantesFunciones.ISCONAUDITORIA) {
				if(estadogarantiacliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoGarantiaClienteDataAccess.TABLENAME, estadogarantiacliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoGarantiaClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoGarantiaClienteLogic.registrarAuditoriaDetallesEstadoGarantiaCliente(connexion,estadogarantiacliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadogarantiacliente.getIsDeleted()) {
					/*if(!estadogarantiacliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoGarantiaClienteDataAccess.TABLENAME, estadogarantiacliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoGarantiaClienteLogic.registrarAuditoriaDetallesEstadoGarantiaCliente(connexion,estadogarantiacliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoGarantiaClienteDataAccess.TABLENAME, estadogarantiacliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadogarantiacliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoGarantiaClienteDataAccess.TABLENAME, estadogarantiacliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoGarantiaClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoGarantiaClienteLogic.registrarAuditoriaDetallesEstadoGarantiaCliente(connexion,estadogarantiacliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoGarantiaCliente(Connexion connexion,EstadoGarantiaCliente estadogarantiacliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadogarantiacliente.getIsNew()||!estadogarantiacliente.getcodigo().equals(estadogarantiacliente.getEstadoGarantiaClienteOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadogarantiacliente.getEstadoGarantiaClienteOriginal().getcodigo()!=null)
				{
					strValorActual=estadogarantiacliente.getEstadoGarantiaClienteOriginal().getcodigo();
				}
				if(estadogarantiacliente.getcodigo()!=null)
				{
					strValorNuevo=estadogarantiacliente.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoGarantiaClienteConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadogarantiacliente.getIsNew()||!estadogarantiacliente.getnombre().equals(estadogarantiacliente.getEstadoGarantiaClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadogarantiacliente.getEstadoGarantiaClienteOriginal().getnombre()!=null)
				{
					strValorActual=estadogarantiacliente.getEstadoGarantiaClienteOriginal().getnombre();
				}
				if(estadogarantiacliente.getnombre()!=null)
				{
					strValorNuevo=estadogarantiacliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoGarantiaClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoGarantiaClienteRelacionesWithConnection(EstadoGarantiaCliente estadogarantiacliente,List<GarantiaCliente> garantiaclientes) throws Exception {

		if(!estadogarantiacliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoGarantiaClienteRelacionesBase(estadogarantiacliente,garantiaclientes,true);
		}
	}

	public void saveEstadoGarantiaClienteRelaciones(EstadoGarantiaCliente estadogarantiacliente,List<GarantiaCliente> garantiaclientes)throws Exception {

		if(!estadogarantiacliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoGarantiaClienteRelacionesBase(estadogarantiacliente,garantiaclientes,false);
		}
	}

	public void saveEstadoGarantiaClienteRelacionesBase(EstadoGarantiaCliente estadogarantiacliente,List<GarantiaCliente> garantiaclientes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoGarantiaCliente-saveRelacionesWithConnection");}
	
			estadogarantiacliente.setGarantiaClientes(garantiaclientes);

			this.setEstadoGarantiaCliente(estadogarantiacliente);

				if((estadogarantiacliente.getIsNew()||estadogarantiacliente.getIsChanged())&&!estadogarantiacliente.getIsDeleted()) {
					this.saveEstadoGarantiaCliente();
					this.saveEstadoGarantiaClienteRelacionesDetalles(garantiaclientes);

				} else if(estadogarantiacliente.getIsDeleted()) {
					this.saveEstadoGarantiaClienteRelacionesDetalles(garantiaclientes);
					this.saveEstadoGarantiaCliente();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			GarantiaClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresGarantiaClientes(garantiaclientes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoGarantiaClienteRelacionesDetalles(List<GarantiaCliente> garantiaclientes)throws Exception {
		try {
	

			Long idEstadoGarantiaClienteActual=this.getEstadoGarantiaCliente().getId();

			GarantiaClienteLogic garantiaclienteLogic_Desde_EstadoGarantiaCliente=new GarantiaClienteLogic();
			garantiaclienteLogic_Desde_EstadoGarantiaCliente.setGarantiaClientes(garantiaclientes);

			garantiaclienteLogic_Desde_EstadoGarantiaCliente.setConnexion(this.getConnexion());
			garantiaclienteLogic_Desde_EstadoGarantiaCliente.setDatosCliente(this.datosCliente);

			for(GarantiaCliente garantiacliente_Desde_EstadoGarantiaCliente:garantiaclienteLogic_Desde_EstadoGarantiaCliente.getGarantiaClientes()) {
				garantiacliente_Desde_EstadoGarantiaCliente.setid_estado_garantia_cliente(idEstadoGarantiaClienteActual);
			}

			garantiaclienteLogic_Desde_EstadoGarantiaCliente.saveGarantiaClientes();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoGarantiaClienteConstantesFunciones.getClassesForeignKeysOfEstadoGarantiaCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoGarantiaClienteConstantesFunciones.getClassesRelationshipsOfEstadoGarantiaCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

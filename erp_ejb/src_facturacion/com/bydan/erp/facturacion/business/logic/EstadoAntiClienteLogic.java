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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.EstadoAntiClienteConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoAntiClienteParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoAntiClienteParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoAntiCliente;
import com.bydan.erp.facturacion.business.logic.EstadoAntiClienteLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoAntiClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoAntiClienteLogic.class);
	
	protected EstadoAntiClienteDataAccess estadoanticlienteDataAccess; 	
	protected EstadoAntiCliente estadoanticliente;
	protected List<EstadoAntiCliente> estadoanticlientes;
	protected Object estadoanticlienteObject;	
	protected List<Object> estadoanticlientesObject;
	
	public static ClassValidator<EstadoAntiCliente> estadoanticlienteValidator = new ClassValidator<EstadoAntiCliente>(EstadoAntiCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoAntiClienteLogicAdditional estadoanticlienteLogicAdditional=null;
	
	public EstadoAntiClienteLogicAdditional getEstadoAntiClienteLogicAdditional() {
		return this.estadoanticlienteLogicAdditional;
	}
	
	public void setEstadoAntiClienteLogicAdditional(EstadoAntiClienteLogicAdditional estadoanticlienteLogicAdditional) {
		try {
			this.estadoanticlienteLogicAdditional=estadoanticlienteLogicAdditional;
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
	
	
	
	
	public  EstadoAntiClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoanticlienteDataAccess = new EstadoAntiClienteDataAccess();
			
			this.estadoanticlientes= new ArrayList<EstadoAntiCliente>();
			this.estadoanticliente= new EstadoAntiCliente();
			
			this.estadoanticlienteObject=new Object();
			this.estadoanticlientesObject=new ArrayList<Object>();
				
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
			
			this.estadoanticlienteDataAccess.setConnexionType(this.connexionType);
			this.estadoanticlienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoAntiClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoanticlienteDataAccess = new EstadoAntiClienteDataAccess();
			this.estadoanticlientes= new ArrayList<EstadoAntiCliente>();
			this.estadoanticliente= new EstadoAntiCliente();
			this.estadoanticlienteObject=new Object();
			this.estadoanticlientesObject=new ArrayList<Object>();
			
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
			
			this.estadoanticlienteDataAccess.setConnexionType(this.connexionType);
			this.estadoanticlienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoAntiCliente getEstadoAntiCliente() throws Exception {	
		EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToGet(estadoanticliente,this.datosCliente,this.arrDatoGeneral);
		EstadoAntiClienteLogicAdditional.updateEstadoAntiClienteToGet(estadoanticliente,this.arrDatoGeneral);
		
		return estadoanticliente;
	}
		
	public void setEstadoAntiCliente(EstadoAntiCliente newEstadoAntiCliente) {
		this.estadoanticliente = newEstadoAntiCliente;
	}
	
	public EstadoAntiClienteDataAccess getEstadoAntiClienteDataAccess() {
		return estadoanticlienteDataAccess;
	}
	
	public void setEstadoAntiClienteDataAccess(EstadoAntiClienteDataAccess newestadoanticlienteDataAccess) {
		this.estadoanticlienteDataAccess = newestadoanticlienteDataAccess;
	}
	
	public List<EstadoAntiCliente> getEstadoAntiClientes() throws Exception {		
		this.quitarEstadoAntiClientesNulos();
		
		EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToGets(estadoanticlientes,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoAntiCliente estadoanticlienteLocal: estadoanticlientes ) {
			EstadoAntiClienteLogicAdditional.updateEstadoAntiClienteToGet(estadoanticlienteLocal,this.arrDatoGeneral);
		}
		
		return estadoanticlientes;
	}
	
	public void setEstadoAntiClientes(List<EstadoAntiCliente> newEstadoAntiClientes) {
		this.estadoanticlientes = newEstadoAntiClientes;
	}
	
	public Object getEstadoAntiClienteObject() {	
		this.estadoanticlienteObject=this.estadoanticlienteDataAccess.getEntityObject();
		return this.estadoanticlienteObject;
	}
		
	public void setEstadoAntiClienteObject(Object newEstadoAntiClienteObject) {
		this.estadoanticlienteObject = newEstadoAntiClienteObject;
	}
	
	public List<Object> getEstadoAntiClientesObject() {		
		this.estadoanticlientesObject=this.estadoanticlienteDataAccess.getEntitiesObject();
		return this.estadoanticlientesObject;
	}
		
	public void setEstadoAntiClientesObject(List<Object> newEstadoAntiClientesObject) {
		this.estadoanticlientesObject = newEstadoAntiClientesObject;
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
		
		if(this.estadoanticlienteDataAccess!=null) {
			this.estadoanticlienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoanticlienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoanticlienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoanticliente = new  EstadoAntiCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoanticliente=estadoanticlienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoanticliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticliente);
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
		estadoanticliente = new  EstadoAntiCliente();
		  		  
        try {
			
			estadoanticliente=estadoanticlienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoanticliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoanticliente = new  EstadoAntiCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoanticliente=estadoanticlienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoanticliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticliente);
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
		estadoanticliente = new  EstadoAntiCliente();
		  		  
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
		estadoanticliente = new  EstadoAntiCliente();
		  		  
        try {
			
			estadoanticliente=estadoanticlienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoanticliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoanticliente = new  EstadoAntiCliente();
		  		  
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
		estadoanticliente = new  EstadoAntiCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoanticlienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoanticliente = new  EstadoAntiCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoanticlienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoanticliente = new  EstadoAntiCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoanticlienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoanticliente = new  EstadoAntiCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoanticlienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoanticliente = new  EstadoAntiCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoanticlienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoanticliente = new  EstadoAntiCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoanticlienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
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
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		  		  
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
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		  		  
        try {			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		  		  
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
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
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
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		  		  
        try {
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
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
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
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
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoanticliente = new  EstadoAntiCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticliente=estadoanticlienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticliente);
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
		estadoanticliente = new  EstadoAntiCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticliente=estadoanticlienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
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
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		  		  
        try {
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoAntiClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getTodosEstadoAntiClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
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
	
	public  void  getTodosEstadoAntiClientes(String sFinalQuery,Pagination pagination)throws Exception {
		estadoanticlientes = new  ArrayList<EstadoAntiCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoanticlientes=estadoanticlienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoAntiCliente(estadoanticlientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticlientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoAntiCliente(EstadoAntiCliente estadoanticliente) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoanticliente.getIsNew() || estadoanticliente.getIsChanged()) { 
			this.invalidValues = estadoanticlienteValidator.getInvalidValues(estadoanticliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoanticliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoAntiCliente(List<EstadoAntiCliente> EstadoAntiClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoAntiCliente estadoanticlienteLocal:estadoanticlientes) {				
			estaValidadoObjeto=this.validarGuardarEstadoAntiCliente(estadoanticlienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoAntiCliente(List<EstadoAntiCliente> EstadoAntiClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoAntiCliente(estadoanticlientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoAntiCliente(EstadoAntiCliente EstadoAntiCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoAntiCliente(estadoanticliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoAntiCliente estadoanticliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoanticliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoAntiClienteConstantesFunciones.getEstadoAntiClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoanticliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoAntiClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoAntiClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoAntiClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-saveEstadoAntiClienteWithConnection");connexion.begin();			
			
			EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToSave(this.estadoanticliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoAntiClienteLogicAdditional.updateEstadoAntiClienteToSave(this.estadoanticliente,this.arrDatoGeneral);
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoanticliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoAntiCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoAntiCliente(this.estadoanticliente)) {
				EstadoAntiClienteDataAccess.save(this.estadoanticliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoanticliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToSaveAfter(this.estadoanticliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoAntiCliente();
			
			connexion.commit();			
			
			if(this.estadoanticliente.getIsDeleted()) {
				this.estadoanticliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoAntiCliente()throws Exception {	
		try {	
			
			EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToSave(this.estadoanticliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoAntiClienteLogicAdditional.updateEstadoAntiClienteToSave(this.estadoanticliente,this.arrDatoGeneral);
			
			EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoanticliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoAntiCliente(this.estadoanticliente)) {			
				EstadoAntiClienteDataAccess.save(this.estadoanticliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoanticliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToSaveAfter(this.estadoanticliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoanticliente.getIsDeleted()) {
				this.estadoanticliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoAntiClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-saveEstadoAntiClientesWithConnection");connexion.begin();			
			
			EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToSaves(estadoanticlientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoAntiClientes();
			
			Boolean validadoTodosEstadoAntiCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoAntiCliente estadoanticlienteLocal:estadoanticlientes) {		
				if(estadoanticlienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoAntiClienteLogicAdditional.updateEstadoAntiClienteToSave(estadoanticlienteLocal,this.arrDatoGeneral);
	        	
				EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoanticlienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoAntiCliente(estadoanticlienteLocal)) {
					EstadoAntiClienteDataAccess.save(estadoanticlienteLocal, connexion);				
				} else {
					validadoTodosEstadoAntiCliente=false;
				}
			}
			
			if(!validadoTodosEstadoAntiCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToSavesAfter(estadoanticlientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoAntiClientes();
			
			connexion.commit();		
			
			this.quitarEstadoAntiClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoAntiClientes()throws Exception {				
		 try {	
			EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToSaves(estadoanticlientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoAntiCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoAntiCliente estadoanticlienteLocal:estadoanticlientes) {				
				if(estadoanticlienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoAntiClienteLogicAdditional.updateEstadoAntiClienteToSave(estadoanticlienteLocal,this.arrDatoGeneral);
	        	
				EstadoAntiClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoanticlienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoAntiCliente(estadoanticlienteLocal)) {				
					EstadoAntiClienteDataAccess.save(estadoanticlienteLocal, connexion);				
				} else {
					validadoTodosEstadoAntiCliente=false;
				}
			}
			
			if(!validadoTodosEstadoAntiCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoAntiClienteLogicAdditional.checkEstadoAntiClienteToSavesAfter(estadoanticlientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoAntiClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoAntiClienteParameterReturnGeneral procesarAccionEstadoAntiClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoAntiCliente> estadoanticlientes,EstadoAntiClienteParameterReturnGeneral estadoanticlienteParameterGeneral)throws Exception {
		 try {	
			EstadoAntiClienteParameterReturnGeneral estadoanticlienteReturnGeneral=new EstadoAntiClienteParameterReturnGeneral();
	
			EstadoAntiClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoanticlientes,estadoanticlienteParameterGeneral,estadoanticlienteReturnGeneral);
			
			return estadoanticlienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoAntiClienteParameterReturnGeneral procesarAccionEstadoAntiClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoAntiCliente> estadoanticlientes,EstadoAntiClienteParameterReturnGeneral estadoanticlienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-procesarAccionEstadoAntiClientesWithConnection");connexion.begin();			
			
			EstadoAntiClienteParameterReturnGeneral estadoanticlienteReturnGeneral=new EstadoAntiClienteParameterReturnGeneral();
	
			EstadoAntiClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoanticlientes,estadoanticlienteParameterGeneral,estadoanticlienteReturnGeneral);
			
			this.connexion.commit();
			
			return estadoanticlienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoAntiClienteParameterReturnGeneral procesarEventosEstadoAntiClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoAntiCliente> estadoanticlientes,EstadoAntiCliente estadoanticliente,EstadoAntiClienteParameterReturnGeneral estadoanticlienteParameterGeneral,Boolean isEsNuevoEstadoAntiCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoAntiClienteParameterReturnGeneral estadoanticlienteReturnGeneral=new EstadoAntiClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoanticlienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoAntiClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoanticlientes,estadoanticliente,estadoanticlienteParameterGeneral,estadoanticlienteReturnGeneral,isEsNuevoEstadoAntiCliente,clases);
			
			return estadoanticlienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoAntiClienteParameterReturnGeneral procesarEventosEstadoAntiClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoAntiCliente> estadoanticlientes,EstadoAntiCliente estadoanticliente,EstadoAntiClienteParameterReturnGeneral estadoanticlienteParameterGeneral,Boolean isEsNuevoEstadoAntiCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-procesarEventosEstadoAntiClientesWithConnection");connexion.begin();			
			
			EstadoAntiClienteParameterReturnGeneral estadoanticlienteReturnGeneral=new EstadoAntiClienteParameterReturnGeneral();
	
			estadoanticlienteReturnGeneral.setEstadoAntiCliente(estadoanticliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoanticlienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoAntiClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoanticlientes,estadoanticliente,estadoanticlienteParameterGeneral,estadoanticlienteReturnGeneral,isEsNuevoEstadoAntiCliente,clases);
			
			this.connexion.commit();
			
			return estadoanticlienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoAntiClienteParameterReturnGeneral procesarImportacionEstadoAntiClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoAntiClienteParameterReturnGeneral estadoanticlienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-procesarImportacionEstadoAntiClientesWithConnection");connexion.begin();			
			
			EstadoAntiClienteParameterReturnGeneral estadoanticlienteReturnGeneral=new EstadoAntiClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoanticlientes=new ArrayList<EstadoAntiCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoanticliente=new EstadoAntiCliente();
				
				
				if(conColumnasBase) {this.estadoanticliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoanticliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoanticliente.setcodigo(arrColumnas[iColumn++]);
				this.estadoanticliente.setnombre(arrColumnas[iColumn++]);
				
				this.estadoanticlientes.add(this.estadoanticliente);
			}
			
			this.saveEstadoAntiClientes();
			
			this.connexion.commit();
			
			estadoanticlienteReturnGeneral.setConRetornoEstaProcesado(true);
			estadoanticlienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoanticlienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoAntiClientesEliminados() throws Exception {				
		
		List<EstadoAntiCliente> estadoanticlientesAux= new ArrayList<EstadoAntiCliente>();
		
		for(EstadoAntiCliente estadoanticliente:estadoanticlientes) {
			if(!estadoanticliente.getIsDeleted()) {
				estadoanticlientesAux.add(estadoanticliente);
			}
		}
		
		estadoanticlientes=estadoanticlientesAux;
	}
	
	public void quitarEstadoAntiClientesNulos() throws Exception {				
		
		List<EstadoAntiCliente> estadoanticlientesAux= new ArrayList<EstadoAntiCliente>();
		
		for(EstadoAntiCliente estadoanticliente : this.estadoanticlientes) {
			if(estadoanticliente==null) {
				estadoanticlientesAux.add(estadoanticliente);
			}
		}
		
		//this.estadoanticlientes=estadoanticlientesAux;
		
		this.estadoanticlientes.removeAll(estadoanticlientesAux);
	}
	
	public void getSetVersionRowEstadoAntiClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoanticliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoanticliente.getIsDeleted() || (estadoanticliente.getIsChanged()&&!estadoanticliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoanticlienteDataAccess.getSetVersionRowEstadoAntiCliente(connexion,estadoanticliente.getId());
				
				if(!estadoanticliente.getVersionRow().equals(timestamp)) {	
					estadoanticliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoanticliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoAntiCliente()throws Exception {	
		
		if(estadoanticliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoanticliente.getIsDeleted() || (estadoanticliente.getIsChanged()&&!estadoanticliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoanticlienteDataAccess.getSetVersionRowEstadoAntiCliente(connexion,estadoanticliente.getId());
			
			try {							
				if(!estadoanticliente.getVersionRow().equals(timestamp)) {	
					estadoanticliente.setVersionRow(timestamp);
				}
				
				estadoanticliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoAntiClientesWithConnection()throws Exception {	
		if(estadoanticlientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoAntiCliente estadoanticlienteAux:estadoanticlientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoanticlienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoanticlienteAux.getIsDeleted() || (estadoanticlienteAux.getIsChanged()&&!estadoanticlienteAux.getIsNew())) {
						
						timestamp=estadoanticlienteDataAccess.getSetVersionRowEstadoAntiCliente(connexion,estadoanticlienteAux.getId());
						
						if(!estadoanticliente.getVersionRow().equals(timestamp)) {	
							estadoanticlienteAux.setVersionRow(timestamp);
						}
								
						estadoanticlienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoAntiClientes()throws Exception {	
		if(estadoanticlientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoAntiCliente estadoanticlienteAux:estadoanticlientes) {
					if(estadoanticlienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoanticlienteAux.getIsDeleted() || (estadoanticlienteAux.getIsChanged()&&!estadoanticlienteAux.getIsNew())) {
						
						timestamp=estadoanticlienteDataAccess.getSetVersionRowEstadoAntiCliente(connexion,estadoanticlienteAux.getId());
						
						if(!estadoanticlienteAux.getVersionRow().equals(timestamp)) {	
							estadoanticlienteAux.setVersionRow(timestamp);
						}
						
													
						estadoanticlienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoAntiClienteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			AnticipoClienteLogic anticipoclienteLogic=new AnticipoClienteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoAntiClienteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(AnticipoCliente.class));
											
			

			anticipoclienteLogic.setConnexion(this.getConnexion());
			anticipoclienteLogic.setDatosCliente(this.datosCliente);
			anticipoclienteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoAntiCliente estadoanticliente:this.estadoanticlientes) {
				

				classes=new ArrayList<Classe>();
				classes=AnticipoClienteConstantesFunciones.getClassesForeignKeysOfAnticipoCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				anticipoclienteLogic.setAnticipoClientes(estadoanticliente.anticipoclientes);
				anticipoclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoAntiCliente estadoanticliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoAntiClienteLogicAdditional.updateEstadoAntiClienteToGet(estadoanticliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoanticliente.setAnticipoClientes(estadoanticlienteDataAccess.getAnticipoClientes(connexion,estadoanticliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoanticliente.setAnticipoClientes(estadoanticlienteDataAccess.getAnticipoClientes(connexion,estadoanticliente));

				if(this.isConDeep) {
					AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(this.connexion);
					anticipoclienteLogic.setAnticipoClientes(estadoanticliente.getAnticipoClientes());
					ArrayList<Classe> classesLocal=AnticipoClienteConstantesFunciones.getClassesForeignKeysOfAnticipoCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					anticipoclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(anticipoclienteLogic.getAnticipoClientes());
					estadoanticliente.setAnticipoClientes(anticipoclienteLogic.getAnticipoClientes());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AnticipoCliente.class));
			estadoanticliente.setAnticipoClientes(estadoanticlienteDataAccess.getAnticipoClientes(connexion,estadoanticliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadoanticliente.setAnticipoClientes(estadoanticlienteDataAccess.getAnticipoClientes(connexion,estadoanticliente));

		for(AnticipoCliente anticipocliente:estadoanticliente.getAnticipoClientes()) {
			AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
			anticipoclienteLogic.deepLoad(anticipocliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoanticliente.setAnticipoClientes(estadoanticlienteDataAccess.getAnticipoClientes(connexion,estadoanticliente));

				for(AnticipoCliente anticipocliente:estadoanticliente.getAnticipoClientes()) {
					AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
					anticipoclienteLogic.deepLoad(anticipocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AnticipoCliente.class));
			estadoanticliente.setAnticipoClientes(estadoanticlienteDataAccess.getAnticipoClientes(connexion,estadoanticliente));

			for(AnticipoCliente anticipocliente:estadoanticliente.getAnticipoClientes()) {
				AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
				anticipoclienteLogic.deepLoad(anticipocliente,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoAntiCliente estadoanticliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoAntiClienteLogicAdditional.updateEstadoAntiClienteToSave(estadoanticliente,this.arrDatoGeneral);
			
EstadoAntiClienteDataAccess.save(estadoanticliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(AnticipoCliente anticipocliente:estadoanticliente.getAnticipoClientes()) {
			anticipocliente.setid_estado_anti_cliente(estadoanticliente.getId());
			AnticipoClienteDataAccess.save(anticipocliente,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AnticipoCliente anticipocliente:estadoanticliente.getAnticipoClientes()) {
					anticipocliente.setid_estado_anti_cliente(estadoanticliente.getId());
					AnticipoClienteDataAccess.save(anticipocliente,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(AnticipoCliente anticipocliente:estadoanticliente.getAnticipoClientes()) {
			AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
			anticipocliente.setid_estado_anti_cliente(estadoanticliente.getId());
			AnticipoClienteDataAccess.save(anticipocliente,connexion);
			anticipoclienteLogic.deepSave(anticipocliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AnticipoCliente anticipocliente:estadoanticliente.getAnticipoClientes()) {
					AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
					anticipocliente.setid_estado_anti_cliente(estadoanticliente.getId());
					AnticipoClienteDataAccess.save(anticipocliente,connexion);
					anticipoclienteLogic.deepSave(anticipocliente,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoAntiCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoanticliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(estadoanticliente);
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
			this.deepLoad(this.estadoanticliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoAntiCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoanticlientes!=null) {
				for(EstadoAntiCliente estadoanticliente:estadoanticlientes) {
					this.deepLoad(estadoanticliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(estadoanticlientes);
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
			if(estadoanticlientes!=null) {
				for(EstadoAntiCliente estadoanticliente:estadoanticlientes) {
					this.deepLoad(estadoanticliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(estadoanticlientes);
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
			this.getNewConnexionToDeep(EstadoAntiCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadoanticliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoAntiCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadoanticlientes!=null) {
				for(EstadoAntiCliente estadoanticliente:estadoanticlientes) {
					this.deepSave(estadoanticliente,isDeep,deepLoadType,clases);
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
			if(estadoanticlientes!=null) {
				for(EstadoAntiCliente estadoanticliente:estadoanticlientes) {
					this.deepSave(estadoanticliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoAntiClientePorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAntiCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoAntiClienteConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadoanticliente=estadoanticlienteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadoanticliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticliente);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoAntiClientePorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoAntiClienteConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadoanticliente=estadoanticlienteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadoanticliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoAntiClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAntiCliente(this.estadoanticliente);
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
			if(EstadoAntiClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAntiClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoAntiCliente estadoanticliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoAntiClienteConstantesFunciones.ISCONAUDITORIA) {
				if(estadoanticliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAntiClienteDataAccess.TABLENAME, estadoanticliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoAntiClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoAntiClienteLogic.registrarAuditoriaDetallesEstadoAntiCliente(connexion,estadoanticliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoanticliente.getIsDeleted()) {
					/*if(!estadoanticliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoAntiClienteDataAccess.TABLENAME, estadoanticliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoAntiClienteLogic.registrarAuditoriaDetallesEstadoAntiCliente(connexion,estadoanticliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAntiClienteDataAccess.TABLENAME, estadoanticliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoanticliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAntiClienteDataAccess.TABLENAME, estadoanticliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoAntiClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoAntiClienteLogic.registrarAuditoriaDetallesEstadoAntiCliente(connexion,estadoanticliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoAntiCliente(Connexion connexion,EstadoAntiCliente estadoanticliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoanticliente.getIsNew()||!estadoanticliente.getcodigo().equals(estadoanticliente.getEstadoAntiClienteOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoanticliente.getEstadoAntiClienteOriginal().getcodigo()!=null)
				{
					strValorActual=estadoanticliente.getEstadoAntiClienteOriginal().getcodigo();
				}
				if(estadoanticliente.getcodigo()!=null)
				{
					strValorNuevo=estadoanticliente.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoAntiClienteConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoanticliente.getIsNew()||!estadoanticliente.getnombre().equals(estadoanticliente.getEstadoAntiClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoanticliente.getEstadoAntiClienteOriginal().getnombre()!=null)
				{
					strValorActual=estadoanticliente.getEstadoAntiClienteOriginal().getnombre();
				}
				if(estadoanticliente.getnombre()!=null)
				{
					strValorNuevo=estadoanticliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoAntiClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoAntiClienteRelacionesWithConnection(EstadoAntiCliente estadoanticliente,List<AnticipoCliente> anticipoclientes) throws Exception {

		if(!estadoanticliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoAntiClienteRelacionesBase(estadoanticliente,anticipoclientes,true);
		}
	}

	public void saveEstadoAntiClienteRelaciones(EstadoAntiCliente estadoanticliente,List<AnticipoCliente> anticipoclientes)throws Exception {

		if(!estadoanticliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoAntiClienteRelacionesBase(estadoanticliente,anticipoclientes,false);
		}
	}

	public void saveEstadoAntiClienteRelacionesBase(EstadoAntiCliente estadoanticliente,List<AnticipoCliente> anticipoclientes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoAntiCliente-saveRelacionesWithConnection");}
	
			estadoanticliente.setAnticipoClientes(anticipoclientes);

			this.setEstadoAntiCliente(estadoanticliente);

			if(EstadoAntiClienteLogicAdditional.validarSaveRelaciones(estadoanticliente,this)) {

				EstadoAntiClienteLogicAdditional.updateRelacionesToSave(estadoanticliente,this);

				if((estadoanticliente.getIsNew()||estadoanticliente.getIsChanged())&&!estadoanticliente.getIsDeleted()) {
					this.saveEstadoAntiCliente();
					this.saveEstadoAntiClienteRelacionesDetalles(anticipoclientes);

				} else if(estadoanticliente.getIsDeleted()) {
					this.saveEstadoAntiClienteRelacionesDetalles(anticipoclientes);
					this.saveEstadoAntiCliente();
				}

				EstadoAntiClienteLogicAdditional.updateRelacionesToSaveAfter(estadoanticliente,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			AnticipoClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresAnticipoClientes(anticipoclientes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoAntiClienteRelacionesDetalles(List<AnticipoCliente> anticipoclientes)throws Exception {
		try {
	

			Long idEstadoAntiClienteActual=this.getEstadoAntiCliente().getId();

			AnticipoClienteLogic anticipoclienteLogic_Desde_EstadoAntiCliente=new AnticipoClienteLogic();
			anticipoclienteLogic_Desde_EstadoAntiCliente.setAnticipoClientes(anticipoclientes);

			anticipoclienteLogic_Desde_EstadoAntiCliente.setConnexion(this.getConnexion());
			anticipoclienteLogic_Desde_EstadoAntiCliente.setDatosCliente(this.datosCliente);

			for(AnticipoCliente anticipocliente_Desde_EstadoAntiCliente:anticipoclienteLogic_Desde_EstadoAntiCliente.getAnticipoClientes()) {
				anticipocliente_Desde_EstadoAntiCliente.setid_estado_anti_cliente(idEstadoAntiClienteActual);
			}

			anticipoclienteLogic_Desde_EstadoAntiCliente.saveAnticipoClientes();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoAntiCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoAntiClienteConstantesFunciones.getClassesForeignKeysOfEstadoAntiCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoAntiCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoAntiClienteConstantesFunciones.getClassesRelationshipsOfEstadoAntiCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

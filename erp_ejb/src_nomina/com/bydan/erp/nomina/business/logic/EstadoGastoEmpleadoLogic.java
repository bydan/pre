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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.EstadoGastoEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoGastoEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoGastoEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.EstadoGastoEmpleado;
import com.bydan.erp.nomina.business.logic.EstadoGastoEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoGastoEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoGastoEmpleadoLogic.class);
	
	protected EstadoGastoEmpleadoDataAccess estadogastoempleadoDataAccess; 	
	protected EstadoGastoEmpleado estadogastoempleado;
	protected List<EstadoGastoEmpleado> estadogastoempleados;
	protected Object estadogastoempleadoObject;	
	protected List<Object> estadogastoempleadosObject;
	
	public static ClassValidator<EstadoGastoEmpleado> estadogastoempleadoValidator = new ClassValidator<EstadoGastoEmpleado>(EstadoGastoEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoGastoEmpleadoLogicAdditional estadogastoempleadoLogicAdditional=null;
	
	public EstadoGastoEmpleadoLogicAdditional getEstadoGastoEmpleadoLogicAdditional() {
		return this.estadogastoempleadoLogicAdditional;
	}
	
	public void setEstadoGastoEmpleadoLogicAdditional(EstadoGastoEmpleadoLogicAdditional estadogastoempleadoLogicAdditional) {
		try {
			this.estadogastoempleadoLogicAdditional=estadogastoempleadoLogicAdditional;
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
	
	
	
	
	public  EstadoGastoEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadogastoempleadoDataAccess = new EstadoGastoEmpleadoDataAccess();
			
			this.estadogastoempleados= new ArrayList<EstadoGastoEmpleado>();
			this.estadogastoempleado= new EstadoGastoEmpleado();
			
			this.estadogastoempleadoObject=new Object();
			this.estadogastoempleadosObject=new ArrayList<Object>();
				
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
			
			this.estadogastoempleadoDataAccess.setConnexionType(this.connexionType);
			this.estadogastoempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoGastoEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadogastoempleadoDataAccess = new EstadoGastoEmpleadoDataAccess();
			this.estadogastoempleados= new ArrayList<EstadoGastoEmpleado>();
			this.estadogastoempleado= new EstadoGastoEmpleado();
			this.estadogastoempleadoObject=new Object();
			this.estadogastoempleadosObject=new ArrayList<Object>();
			
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
			
			this.estadogastoempleadoDataAccess.setConnexionType(this.connexionType);
			this.estadogastoempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoGastoEmpleado getEstadoGastoEmpleado() throws Exception {	
		EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToGet(estadogastoempleado,this.datosCliente,this.arrDatoGeneral);
		EstadoGastoEmpleadoLogicAdditional.updateEstadoGastoEmpleadoToGet(estadogastoempleado,this.arrDatoGeneral);
		
		return estadogastoempleado;
	}
		
	public void setEstadoGastoEmpleado(EstadoGastoEmpleado newEstadoGastoEmpleado) {
		this.estadogastoempleado = newEstadoGastoEmpleado;
	}
	
	public EstadoGastoEmpleadoDataAccess getEstadoGastoEmpleadoDataAccess() {
		return estadogastoempleadoDataAccess;
	}
	
	public void setEstadoGastoEmpleadoDataAccess(EstadoGastoEmpleadoDataAccess newestadogastoempleadoDataAccess) {
		this.estadogastoempleadoDataAccess = newestadogastoempleadoDataAccess;
	}
	
	public List<EstadoGastoEmpleado> getEstadoGastoEmpleados() throws Exception {		
		this.quitarEstadoGastoEmpleadosNulos();
		
		EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToGets(estadogastoempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoGastoEmpleado estadogastoempleadoLocal: estadogastoempleados ) {
			EstadoGastoEmpleadoLogicAdditional.updateEstadoGastoEmpleadoToGet(estadogastoempleadoLocal,this.arrDatoGeneral);
		}
		
		return estadogastoempleados;
	}
	
	public void setEstadoGastoEmpleados(List<EstadoGastoEmpleado> newEstadoGastoEmpleados) {
		this.estadogastoempleados = newEstadoGastoEmpleados;
	}
	
	public Object getEstadoGastoEmpleadoObject() {	
		this.estadogastoempleadoObject=this.estadogastoempleadoDataAccess.getEntityObject();
		return this.estadogastoempleadoObject;
	}
		
	public void setEstadoGastoEmpleadoObject(Object newEstadoGastoEmpleadoObject) {
		this.estadogastoempleadoObject = newEstadoGastoEmpleadoObject;
	}
	
	public List<Object> getEstadoGastoEmpleadosObject() {		
		this.estadogastoempleadosObject=this.estadogastoempleadoDataAccess.getEntitiesObject();
		return this.estadogastoempleadosObject;
	}
		
	public void setEstadoGastoEmpleadosObject(List<Object> newEstadoGastoEmpleadosObject) {
		this.estadogastoempleadosObject = newEstadoGastoEmpleadosObject;
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
		
		if(this.estadogastoempleadoDataAccess!=null) {
			this.estadogastoempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadogastoempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadogastoempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadogastoempleado = new  EstadoGastoEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadogastoempleado=estadogastoempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadogastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleado);
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
		estadogastoempleado = new  EstadoGastoEmpleado();
		  		  
        try {
			
			estadogastoempleado=estadogastoempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadogastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadogastoempleado = new  EstadoGastoEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadogastoempleado=estadogastoempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadogastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleado);
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
		estadogastoempleado = new  EstadoGastoEmpleado();
		  		  
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
		estadogastoempleado = new  EstadoGastoEmpleado();
		  		  
        try {
			
			estadogastoempleado=estadogastoempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadogastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadogastoempleado = new  EstadoGastoEmpleado();
		  		  
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
		estadogastoempleado = new  EstadoGastoEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadogastoempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadogastoempleado = new  EstadoGastoEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadogastoempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadogastoempleado = new  EstadoGastoEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadogastoempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadogastoempleado = new  EstadoGastoEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadogastoempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadogastoempleado = new  EstadoGastoEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadogastoempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadogastoempleado = new  EstadoGastoEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadogastoempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
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
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		  		  
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
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		  		  
        try {			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		  		  
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
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
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
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		  		  
        try {
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
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
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
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
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadogastoempleado = new  EstadoGastoEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleado=estadogastoempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleado);
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
		estadogastoempleado = new  EstadoGastoEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleado=estadogastoempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
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
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		  		  
        try {
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoGastoEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-getTodosEstadoGastoEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
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
	
	public  void  getTodosEstadoGastoEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		estadogastoempleados = new  ArrayList<EstadoGastoEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadogastoempleados=estadogastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoGastoEmpleado(estadogastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(estadogastoempleado.getIsNew() || estadogastoempleado.getIsChanged()) { 
			this.invalidValues = estadogastoempleadoValidator.getInvalidValues(estadogastoempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadogastoempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoGastoEmpleado(List<EstadoGastoEmpleado> EstadoGastoEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoGastoEmpleado estadogastoempleadoLocal:estadogastoempleados) {				
			estaValidadoObjeto=this.validarGuardarEstadoGastoEmpleado(estadogastoempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoGastoEmpleado(List<EstadoGastoEmpleado> EstadoGastoEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoGastoEmpleado(estadogastoempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoGastoEmpleado(EstadoGastoEmpleado EstadoGastoEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoGastoEmpleado(estadogastoempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoGastoEmpleado estadogastoempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadogastoempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoGastoEmpleadoConstantesFunciones.getEstadoGastoEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadogastoempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoGastoEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoGastoEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoGastoEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-saveEstadoGastoEmpleadoWithConnection");connexion.begin();			
			
			EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToSave(this.estadogastoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoGastoEmpleadoLogicAdditional.updateEstadoGastoEmpleadoToSave(this.estadogastoempleado,this.arrDatoGeneral);
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadogastoempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoGastoEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoGastoEmpleado(this.estadogastoempleado)) {
				EstadoGastoEmpleadoDataAccess.save(this.estadogastoempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadogastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToSaveAfter(this.estadogastoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoGastoEmpleado();
			
			connexion.commit();			
			
			if(this.estadogastoempleado.getIsDeleted()) {
				this.estadogastoempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoGastoEmpleado()throws Exception {	
		try {	
			
			EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToSave(this.estadogastoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoGastoEmpleadoLogicAdditional.updateEstadoGastoEmpleadoToSave(this.estadogastoempleado,this.arrDatoGeneral);
			
			EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadogastoempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoGastoEmpleado(this.estadogastoempleado)) {			
				EstadoGastoEmpleadoDataAccess.save(this.estadogastoempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadogastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToSaveAfter(this.estadogastoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadogastoempleado.getIsDeleted()) {
				this.estadogastoempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoGastoEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-saveEstadoGastoEmpleadosWithConnection");connexion.begin();			
			
			EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToSaves(estadogastoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoGastoEmpleados();
			
			Boolean validadoTodosEstadoGastoEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoGastoEmpleado estadogastoempleadoLocal:estadogastoempleados) {		
				if(estadogastoempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoGastoEmpleadoLogicAdditional.updateEstadoGastoEmpleadoToSave(estadogastoempleadoLocal,this.arrDatoGeneral);
	        	
				EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadogastoempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoGastoEmpleado(estadogastoempleadoLocal)) {
					EstadoGastoEmpleadoDataAccess.save(estadogastoempleadoLocal, connexion);				
				} else {
					validadoTodosEstadoGastoEmpleado=false;
				}
			}
			
			if(!validadoTodosEstadoGastoEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToSavesAfter(estadogastoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoGastoEmpleados();
			
			connexion.commit();		
			
			this.quitarEstadoGastoEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoGastoEmpleados()throws Exception {				
		 try {	
			EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToSaves(estadogastoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoGastoEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoGastoEmpleado estadogastoempleadoLocal:estadogastoempleados) {				
				if(estadogastoempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoGastoEmpleadoLogicAdditional.updateEstadoGastoEmpleadoToSave(estadogastoempleadoLocal,this.arrDatoGeneral);
	        	
				EstadoGastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadogastoempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoGastoEmpleado(estadogastoempleadoLocal)) {				
					EstadoGastoEmpleadoDataAccess.save(estadogastoempleadoLocal, connexion);				
				} else {
					validadoTodosEstadoGastoEmpleado=false;
				}
			}
			
			if(!validadoTodosEstadoGastoEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoGastoEmpleadoLogicAdditional.checkEstadoGastoEmpleadoToSavesAfter(estadogastoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoGastoEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoGastoEmpleadoParameterReturnGeneral procesarAccionEstadoGastoEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoGastoEmpleado> estadogastoempleados,EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoParameterGeneral)throws Exception {
		 try {	
			EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoReturnGeneral=new EstadoGastoEmpleadoParameterReturnGeneral();
	
			EstadoGastoEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadogastoempleados,estadogastoempleadoParameterGeneral,estadogastoempleadoReturnGeneral);
			
			return estadogastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoGastoEmpleadoParameterReturnGeneral procesarAccionEstadoGastoEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoGastoEmpleado> estadogastoempleados,EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-procesarAccionEstadoGastoEmpleadosWithConnection");connexion.begin();			
			
			EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoReturnGeneral=new EstadoGastoEmpleadoParameterReturnGeneral();
	
			EstadoGastoEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadogastoempleados,estadogastoempleadoParameterGeneral,estadogastoempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return estadogastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoGastoEmpleadoParameterReturnGeneral procesarEventosEstadoGastoEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoGastoEmpleado> estadogastoempleados,EstadoGastoEmpleado estadogastoempleado,EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoParameterGeneral,Boolean isEsNuevoEstadoGastoEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoReturnGeneral=new EstadoGastoEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadogastoempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoGastoEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadogastoempleados,estadogastoempleado,estadogastoempleadoParameterGeneral,estadogastoempleadoReturnGeneral,isEsNuevoEstadoGastoEmpleado,clases);
			
			return estadogastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoGastoEmpleadoParameterReturnGeneral procesarEventosEstadoGastoEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoGastoEmpleado> estadogastoempleados,EstadoGastoEmpleado estadogastoempleado,EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoParameterGeneral,Boolean isEsNuevoEstadoGastoEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-procesarEventosEstadoGastoEmpleadosWithConnection");connexion.begin();			
			
			EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoReturnGeneral=new EstadoGastoEmpleadoParameterReturnGeneral();
	
			estadogastoempleadoReturnGeneral.setEstadoGastoEmpleado(estadogastoempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadogastoempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoGastoEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadogastoempleados,estadogastoempleado,estadogastoempleadoParameterGeneral,estadogastoempleadoReturnGeneral,isEsNuevoEstadoGastoEmpleado,clases);
			
			this.connexion.commit();
			
			return estadogastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoGastoEmpleadoParameterReturnGeneral procesarImportacionEstadoGastoEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-procesarImportacionEstadoGastoEmpleadosWithConnection");connexion.begin();			
			
			EstadoGastoEmpleadoParameterReturnGeneral estadogastoempleadoReturnGeneral=new EstadoGastoEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadogastoempleados=new ArrayList<EstadoGastoEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadogastoempleado=new EstadoGastoEmpleado();
				
				
				if(conColumnasBase) {this.estadogastoempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadogastoempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadogastoempleado.setcodigo(arrColumnas[iColumn++]);
				this.estadogastoempleado.setnombre(arrColumnas[iColumn++]);
				
				this.estadogastoempleados.add(this.estadogastoempleado);
			}
			
			this.saveEstadoGastoEmpleados();
			
			this.connexion.commit();
			
			estadogastoempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			estadogastoempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadogastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoGastoEmpleadosEliminados() throws Exception {				
		
		List<EstadoGastoEmpleado> estadogastoempleadosAux= new ArrayList<EstadoGastoEmpleado>();
		
		for(EstadoGastoEmpleado estadogastoempleado:estadogastoempleados) {
			if(!estadogastoempleado.getIsDeleted()) {
				estadogastoempleadosAux.add(estadogastoempleado);
			}
		}
		
		estadogastoempleados=estadogastoempleadosAux;
	}
	
	public void quitarEstadoGastoEmpleadosNulos() throws Exception {				
		
		List<EstadoGastoEmpleado> estadogastoempleadosAux= new ArrayList<EstadoGastoEmpleado>();
		
		for(EstadoGastoEmpleado estadogastoempleado : this.estadogastoempleados) {
			if(estadogastoempleado==null) {
				estadogastoempleadosAux.add(estadogastoempleado);
			}
		}
		
		//this.estadogastoempleados=estadogastoempleadosAux;
		
		this.estadogastoempleados.removeAll(estadogastoempleadosAux);
	}
	
	public void getSetVersionRowEstadoGastoEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadogastoempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadogastoempleado.getIsDeleted() || (estadogastoempleado.getIsChanged()&&!estadogastoempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadogastoempleadoDataAccess.getSetVersionRowEstadoGastoEmpleado(connexion,estadogastoempleado.getId());
				
				if(!estadogastoempleado.getVersionRow().equals(timestamp)) {	
					estadogastoempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadogastoempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoGastoEmpleado()throws Exception {	
		
		if(estadogastoempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadogastoempleado.getIsDeleted() || (estadogastoempleado.getIsChanged()&&!estadogastoempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadogastoempleadoDataAccess.getSetVersionRowEstadoGastoEmpleado(connexion,estadogastoempleado.getId());
			
			try {							
				if(!estadogastoempleado.getVersionRow().equals(timestamp)) {	
					estadogastoempleado.setVersionRow(timestamp);
				}
				
				estadogastoempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoGastoEmpleadosWithConnection()throws Exception {	
		if(estadogastoempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoGastoEmpleado estadogastoempleadoAux:estadogastoempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadogastoempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadogastoempleadoAux.getIsDeleted() || (estadogastoempleadoAux.getIsChanged()&&!estadogastoempleadoAux.getIsNew())) {
						
						timestamp=estadogastoempleadoDataAccess.getSetVersionRowEstadoGastoEmpleado(connexion,estadogastoempleadoAux.getId());
						
						if(!estadogastoempleado.getVersionRow().equals(timestamp)) {	
							estadogastoempleadoAux.setVersionRow(timestamp);
						}
								
						estadogastoempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoGastoEmpleados()throws Exception {	
		if(estadogastoempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoGastoEmpleado estadogastoempleadoAux:estadogastoempleados) {
					if(estadogastoempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadogastoempleadoAux.getIsDeleted() || (estadogastoempleadoAux.getIsChanged()&&!estadogastoempleadoAux.getIsNew())) {
						
						timestamp=estadogastoempleadoDataAccess.getSetVersionRowEstadoGastoEmpleado(connexion,estadogastoempleadoAux.getId());
						
						if(!estadogastoempleadoAux.getVersionRow().equals(timestamp)) {	
							estadogastoempleadoAux.setVersionRow(timestamp);
						}
						
													
						estadogastoempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoGastoEmpleadoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			GastoEmpleadoLogic gastoempleadoLogic=new GastoEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoGastoEmpleado.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoGastoEmpleadoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(GastoEmpleado.class));
											
			

			gastoempleadoLogic.setConnexion(this.getConnexion());
			gastoempleadoLogic.setDatosCliente(this.datosCliente);
			gastoempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoGastoEmpleado estadogastoempleado:this.estadogastoempleados) {
				

				classes=new ArrayList<Classe>();
				classes=GastoEmpleadoConstantesFunciones.getClassesForeignKeysOfGastoEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				gastoempleadoLogic.setGastoEmpleados(estadogastoempleado.gastoempleados);
				gastoempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoGastoEmpleado estadogastoempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoGastoEmpleadoLogicAdditional.updateEstadoGastoEmpleadoToGet(estadogastoempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadogastoempleado.setGastoEmpleados(estadogastoempleadoDataAccess.getGastoEmpleados(connexion,estadogastoempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadogastoempleado.setGastoEmpleados(estadogastoempleadoDataAccess.getGastoEmpleados(connexion,estadogastoempleado));

				if(this.isConDeep) {
					GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(this.connexion);
					gastoempleadoLogic.setGastoEmpleados(estadogastoempleado.getGastoEmpleados());
					ArrayList<Classe> classesLocal=GastoEmpleadoConstantesFunciones.getClassesForeignKeysOfGastoEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					gastoempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(gastoempleadoLogic.getGastoEmpleados());
					estadogastoempleado.setGastoEmpleados(gastoempleadoLogic.getGastoEmpleados());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GastoEmpleado.class));
			estadogastoempleado.setGastoEmpleados(estadogastoempleadoDataAccess.getGastoEmpleados(connexion,estadogastoempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadogastoempleado.setGastoEmpleados(estadogastoempleadoDataAccess.getGastoEmpleados(connexion,estadogastoempleado));

		for(GastoEmpleado gastoempleado:estadogastoempleado.getGastoEmpleados()) {
			GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
			gastoempleadoLogic.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadogastoempleado.setGastoEmpleados(estadogastoempleadoDataAccess.getGastoEmpleados(connexion,estadogastoempleado));

				for(GastoEmpleado gastoempleado:estadogastoempleado.getGastoEmpleados()) {
					GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
					gastoempleadoLogic.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GastoEmpleado.class));
			estadogastoempleado.setGastoEmpleados(estadogastoempleadoDataAccess.getGastoEmpleados(connexion,estadogastoempleado));

			for(GastoEmpleado gastoempleado:estadogastoempleado.getGastoEmpleados()) {
				GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
				gastoempleadoLogic.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoGastoEmpleado estadogastoempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoGastoEmpleadoLogicAdditional.updateEstadoGastoEmpleadoToSave(estadogastoempleado,this.arrDatoGeneral);
			
EstadoGastoEmpleadoDataAccess.save(estadogastoempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(GastoEmpleado gastoempleado:estadogastoempleado.getGastoEmpleados()) {
			gastoempleado.setid_estado_gasto_empleado(estadogastoempleado.getId());
			GastoEmpleadoDataAccess.save(gastoempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoEmpleado gastoempleado:estadogastoempleado.getGastoEmpleados()) {
					gastoempleado.setid_estado_gasto_empleado(estadogastoempleado.getId());
					GastoEmpleadoDataAccess.save(gastoempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(GastoEmpleado gastoempleado:estadogastoempleado.getGastoEmpleados()) {
			GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
			gastoempleado.setid_estado_gasto_empleado(estadogastoempleado.getId());
			GastoEmpleadoDataAccess.save(gastoempleado,connexion);
			gastoempleadoLogic.deepSave(gastoempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoEmpleado gastoempleado:estadogastoempleado.getGastoEmpleados()) {
					GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
					gastoempleado.setid_estado_gasto_empleado(estadogastoempleado.getId());
					GastoEmpleadoDataAccess.save(gastoempleado,connexion);
					gastoempleadoLogic.deepSave(gastoempleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoGastoEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadogastoempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(estadogastoempleado);
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
			this.deepLoad(this.estadogastoempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(this.estadogastoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoGastoEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadogastoempleados!=null) {
				for(EstadoGastoEmpleado estadogastoempleado:estadogastoempleados) {
					this.deepLoad(estadogastoempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(estadogastoempleados);
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
			if(estadogastoempleados!=null) {
				for(EstadoGastoEmpleado estadogastoempleado:estadogastoempleados) {
					this.deepLoad(estadogastoempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoGastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoGastoEmpleado(estadogastoempleados);
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
			this.getNewConnexionToDeep(EstadoGastoEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadogastoempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoGastoEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadogastoempleados!=null) {
				for(EstadoGastoEmpleado estadogastoempleado:estadogastoempleados) {
					this.deepSave(estadogastoempleado,isDeep,deepLoadType,clases);
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
			if(estadogastoempleados!=null) {
				for(EstadoGastoEmpleado estadogastoempleado:estadogastoempleados) {
					this.deepSave(estadogastoempleado,isDeep,deepLoadType,clases);
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
			if(EstadoGastoEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoGastoEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoGastoEmpleado estadogastoempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoGastoEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(estadogastoempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoGastoEmpleadoDataAccess.TABLENAME, estadogastoempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoGastoEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoGastoEmpleadoLogic.registrarAuditoriaDetallesEstadoGastoEmpleado(connexion,estadogastoempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadogastoempleado.getIsDeleted()) {
					/*if(!estadogastoempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoGastoEmpleadoDataAccess.TABLENAME, estadogastoempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoGastoEmpleadoLogic.registrarAuditoriaDetallesEstadoGastoEmpleado(connexion,estadogastoempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoGastoEmpleadoDataAccess.TABLENAME, estadogastoempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadogastoempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoGastoEmpleadoDataAccess.TABLENAME, estadogastoempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoGastoEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoGastoEmpleadoLogic.registrarAuditoriaDetallesEstadoGastoEmpleado(connexion,estadogastoempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoGastoEmpleado(Connexion connexion,EstadoGastoEmpleado estadogastoempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadogastoempleado.getIsNew()||!estadogastoempleado.getcodigo().equals(estadogastoempleado.getEstadoGastoEmpleadoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadogastoempleado.getEstadoGastoEmpleadoOriginal().getcodigo()!=null)
				{
					strValorActual=estadogastoempleado.getEstadoGastoEmpleadoOriginal().getcodigo();
				}
				if(estadogastoempleado.getcodigo()!=null)
				{
					strValorNuevo=estadogastoempleado.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoGastoEmpleadoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadogastoempleado.getIsNew()||!estadogastoempleado.getnombre().equals(estadogastoempleado.getEstadoGastoEmpleadoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadogastoempleado.getEstadoGastoEmpleadoOriginal().getnombre()!=null)
				{
					strValorActual=estadogastoempleado.getEstadoGastoEmpleadoOriginal().getnombre();
				}
				if(estadogastoempleado.getnombre()!=null)
				{
					strValorNuevo=estadogastoempleado.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoGastoEmpleadoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoGastoEmpleadoRelacionesWithConnection(EstadoGastoEmpleado estadogastoempleado,List<GastoEmpleado> gastoempleados) throws Exception {

		if(!estadogastoempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoGastoEmpleadoRelacionesBase(estadogastoempleado,gastoempleados,true);
		}
	}

	public void saveEstadoGastoEmpleadoRelaciones(EstadoGastoEmpleado estadogastoempleado,List<GastoEmpleado> gastoempleados)throws Exception {

		if(!estadogastoempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoGastoEmpleadoRelacionesBase(estadogastoempleado,gastoempleados,false);
		}
	}

	public void saveEstadoGastoEmpleadoRelacionesBase(EstadoGastoEmpleado estadogastoempleado,List<GastoEmpleado> gastoempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoGastoEmpleado-saveRelacionesWithConnection");}
	
			estadogastoempleado.setGastoEmpleados(gastoempleados);

			this.setEstadoGastoEmpleado(estadogastoempleado);

				if((estadogastoempleado.getIsNew()||estadogastoempleado.getIsChanged())&&!estadogastoempleado.getIsDeleted()) {
					this.saveEstadoGastoEmpleado();
					this.saveEstadoGastoEmpleadoRelacionesDetalles(gastoempleados);

				} else if(estadogastoempleado.getIsDeleted()) {
					this.saveEstadoGastoEmpleadoRelacionesDetalles(gastoempleados);
					this.saveEstadoGastoEmpleado();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			GastoEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresGastoEmpleados(gastoempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoGastoEmpleadoRelacionesDetalles(List<GastoEmpleado> gastoempleados)throws Exception {
		try {
	

			Long idEstadoGastoEmpleadoActual=this.getEstadoGastoEmpleado().getId();

			GastoEmpleadoLogic gastoempleadoLogic_Desde_EstadoGastoEmpleado=new GastoEmpleadoLogic();
			gastoempleadoLogic_Desde_EstadoGastoEmpleado.setGastoEmpleados(gastoempleados);

			gastoempleadoLogic_Desde_EstadoGastoEmpleado.setConnexion(this.getConnexion());
			gastoempleadoLogic_Desde_EstadoGastoEmpleado.setDatosCliente(this.datosCliente);

			for(GastoEmpleado gastoempleado_Desde_EstadoGastoEmpleado:gastoempleadoLogic_Desde_EstadoGastoEmpleado.getGastoEmpleados()) {
				gastoempleado_Desde_EstadoGastoEmpleado.setid_estado_gasto_empleado(idEstadoGastoEmpleadoActual);
			}

			gastoempleadoLogic_Desde_EstadoGastoEmpleado.saveGastoEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoGastoEmpleadoConstantesFunciones.getClassesForeignKeysOfEstadoGastoEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoGastoEmpleadoConstantesFunciones.getClassesRelationshipsOfEstadoGastoEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

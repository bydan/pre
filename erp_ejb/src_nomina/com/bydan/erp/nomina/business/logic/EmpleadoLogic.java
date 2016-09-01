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
import com.bydan.erp.nomina.util.EmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.Empleado;
import com.bydan.erp.nomina.business.logic.EmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoLogic.class);
	
	protected EmpleadoDataAccess empleadoDataAccess; 	
	protected Empleado empleado;
	protected List<Empleado> empleados;
	protected Object empleadoObject;	
	protected List<Object> empleadosObject;
	
	public static ClassValidator<Empleado> empleadoValidator = new ClassValidator<Empleado>(Empleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoLogicAdditional empleadoLogicAdditional=null;
	
	public EmpleadoLogicAdditional getEmpleadoLogicAdditional() {
		return this.empleadoLogicAdditional;
	}
	
	public void setEmpleadoLogicAdditional(EmpleadoLogicAdditional empleadoLogicAdditional) {
		try {
			this.empleadoLogicAdditional=empleadoLogicAdditional;
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
	
	
	
	
	public  EmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadoDataAccess = new EmpleadoDataAccess();
			
			//SE QUITA INICIALIZACION INICIAL, RAPIDEZ PANTALLA
			
			this.empleadoObject=new Object();
			this.empleadosObject=new ArrayList<Object>();
				
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
			
			this.empleadoDataAccess.setConnexionType(this.connexionType);
			this.empleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadoDataAccess = new EmpleadoDataAccess();
			this.empleados= new ArrayList<Empleado>();
			this.empleado= new Empleado();
			this.empleadoObject=new Object();
			this.empleadosObject=new ArrayList<Object>();
			
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
			
			this.empleadoDataAccess.setConnexionType(this.connexionType);
			this.empleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Empleado getEmpleado() throws Exception {	
		EmpleadoLogicAdditional.checkEmpleadoToGet(empleado,this.datosCliente,this.arrDatoGeneral);
		EmpleadoLogicAdditional.updateEmpleadoToGet(empleado,this.arrDatoGeneral);
		
		return empleado;
	}
		
	public void setEmpleado(Empleado newEmpleado) {
		this.empleado = newEmpleado;
	}
	
	public EmpleadoDataAccess getEmpleadoDataAccess() {
		return empleadoDataAccess;
	}
	
	public void setEmpleadoDataAccess(EmpleadoDataAccess newempleadoDataAccess) {
		this.empleadoDataAccess = newempleadoDataAccess;
	}
	
	public List<Empleado> getEmpleados() throws Exception {		
		this.quitarEmpleadosNulos();
		
		EmpleadoLogicAdditional.checkEmpleadoToGets(empleados,this.datosCliente,this.arrDatoGeneral);
		
		for (Empleado empleadoLocal: empleados ) {
			EmpleadoLogicAdditional.updateEmpleadoToGet(empleadoLocal,this.arrDatoGeneral);
		}
		
		return empleados;
	}
	
	public void setEmpleados(List<Empleado> newEmpleados) {
		this.empleados = newEmpleados;
	}
	
	public Object getEmpleadoObject() {	
		this.empleadoObject=this.empleadoDataAccess.getEntityObject();
		return this.empleadoObject;
	}
		
	public void setEmpleadoObject(Object newEmpleadoObject) {
		this.empleadoObject = newEmpleadoObject;
	}
	
	public List<Object> getEmpleadosObject() {		
		this.empleadosObject=this.empleadoDataAccess.getEntitiesObject();
		return this.empleadosObject;
	}
		
	public void setEmpleadosObject(List<Object> newEmpleadosObject) {
		this.empleadosObject = newEmpleadosObject;
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
		
		if(this.empleadoDataAccess!=null) {
			this.empleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleado = new  Empleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleado=empleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleado);
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
		empleado = new  Empleado();
		  		  
        try {
			
			empleado=empleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleado = new  Empleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleado=empleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleado);
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
		empleado = new  Empleado();
		  		  
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
		empleado = new  Empleado();
		  		  
        try {
			
			empleado=empleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleado = new  Empleado();
		  		  
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
		empleado = new  Empleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleado = new  Empleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleado = new  Empleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleado = new  Empleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleado = new  Empleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleado = new  Empleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleados = new  ArrayList<Empleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
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
		empleados = new  ArrayList<Empleado>();
		  		  
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
		empleados = new  ArrayList<Empleado>();
		  		  
        try {			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleados = new  ArrayList<Empleado>();
		  		  
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
		empleados = new  ArrayList<Empleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
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
		empleados = new  ArrayList<Empleado>();
		  		  
        try {
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
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
		empleados = new  ArrayList<Empleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
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
		empleados = new  ArrayList<Empleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleado = new  Empleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleado=empleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleado(empleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleado);
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
		empleado = new  Empleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleado=empleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleado(empleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleados = new  ArrayList<Empleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
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
		empleados = new  ArrayList<Empleado>();
		  		  
        try {
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleados = new  ArrayList<Empleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getTodosEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
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
	
	public  void  getTodosEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		empleados = new  ArrayList<Empleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleado(empleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleado(Empleado empleado) throws Exception {
		Boolean estaValidado=false;
		
		if(empleado.getIsNew() || empleado.getIsChanged()) { 
			this.invalidValues = empleadoValidator.getInvalidValues(empleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleado(List<Empleado> Empleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Empleado empleadoLocal:empleados) {				
			estaValidadoObjeto=this.validarGuardarEmpleado(empleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleado(List<Empleado> Empleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleado(empleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleado(Empleado Empleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleado(empleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Empleado empleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoConstantesFunciones.getEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-saveEmpleadoWithConnection");connexion.begin();			
			
			EmpleadoLogicAdditional.checkEmpleadoToSave(this.empleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoLogicAdditional.updateEmpleadoToSave(this.empleado,this.arrDatoGeneral);
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleado(this.empleado)) {
				EmpleadoDataAccess.save(this.empleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoLogicAdditional.checkEmpleadoToSaveAfter(this.empleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleado();
			
			connexion.commit();			
			
			if(this.empleado.getIsDeleted()) {
				this.empleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleado()throws Exception {	
		try {	
			
			EmpleadoLogicAdditional.checkEmpleadoToSave(this.empleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoLogicAdditional.updateEmpleadoToSave(this.empleado,this.arrDatoGeneral);
			
			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleado(this.empleado)) {			
				EmpleadoDataAccess.save(this.empleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoLogicAdditional.checkEmpleadoToSaveAfter(this.empleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleado.getIsDeleted()) {
				this.empleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-saveEmpleadosWithConnection");connexion.begin();			
			
			EmpleadoLogicAdditional.checkEmpleadoToSaves(empleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleados();
			
			Boolean validadoTodosEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Empleado empleadoLocal:empleados) {		
				if(empleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoLogicAdditional.updateEmpleadoToSave(empleadoLocal,this.arrDatoGeneral);
	        	
				EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleado(empleadoLocal)) {
					EmpleadoDataAccess.save(empleadoLocal, connexion);				
				} else {
					validadoTodosEmpleado=false;
				}
			}
			
			if(!validadoTodosEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoLogicAdditional.checkEmpleadoToSavesAfter(empleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleados();
			
			connexion.commit();		
			
			this.quitarEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleados()throws Exception {				
		 try {	
			EmpleadoLogicAdditional.checkEmpleadoToSaves(empleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Empleado empleadoLocal:empleados) {				
				if(empleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoLogicAdditional.updateEmpleadoToSave(empleadoLocal,this.arrDatoGeneral);
	        	
				EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleado(empleadoLocal)) {				
					EmpleadoDataAccess.save(empleadoLocal, connexion);				
				} else {
					validadoTodosEmpleado=false;
				}
			}
			
			if(!validadoTodosEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoLogicAdditional.checkEmpleadoToSavesAfter(empleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoParameterReturnGeneral procesarAccionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Empleado> empleados,EmpleadoParameterReturnGeneral empleadoParameterGeneral)throws Exception {
		 try {	
			EmpleadoParameterReturnGeneral empleadoReturnGeneral=new EmpleadoParameterReturnGeneral();
	
			EmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleados,empleadoParameterGeneral,empleadoReturnGeneral);
			
			return empleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoParameterReturnGeneral procesarAccionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Empleado> empleados,EmpleadoParameterReturnGeneral empleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-procesarAccionEmpleadosWithConnection");connexion.begin();			
			
			EmpleadoParameterReturnGeneral empleadoReturnGeneral=new EmpleadoParameterReturnGeneral();
	
			EmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleados,empleadoParameterGeneral,empleadoReturnGeneral);
			
			this.connexion.commit();
			
			return empleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoParameterReturnGeneral procesarEventosEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Empleado> empleados,Empleado empleado,EmpleadoParameterReturnGeneral empleadoParameterGeneral,Boolean isEsNuevoEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoParameterReturnGeneral empleadoReturnGeneral=new EmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleados,empleado,empleadoParameterGeneral,empleadoReturnGeneral,isEsNuevoEmpleado,clases);
			
			return empleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoParameterReturnGeneral procesarEventosEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Empleado> empleados,Empleado empleado,EmpleadoParameterReturnGeneral empleadoParameterGeneral,Boolean isEsNuevoEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-procesarEventosEmpleadosWithConnection");connexion.begin();			
			
			EmpleadoParameterReturnGeneral empleadoReturnGeneral=new EmpleadoParameterReturnGeneral();
	
			empleadoReturnGeneral.setEmpleado(empleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleados,empleado,empleadoParameterGeneral,empleadoReturnGeneral,isEsNuevoEmpleado,clases);
			
			this.connexion.commit();
			
			return empleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoParameterReturnGeneral procesarImportacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoParameterReturnGeneral empleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-procesarImportacionEmpleadosWithConnection");connexion.begin();			
			
			EmpleadoParameterReturnGeneral empleadoReturnGeneral=new EmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleados=new ArrayList<Empleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleado=new Empleado();
				
				
				if(conColumnasBase) {this.empleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleado.setcodigo(arrColumnas[iColumn++]);
				this.empleado.setnombre(arrColumnas[iColumn++]);
				this.empleado.setapellido(arrColumnas[iColumn++]);
			this.empleado.setnombre_completo(arrColumnas[iColumn++]);
				this.empleado.setmail(arrColumnas[iColumn++]);
			this.empleado.setdireccion(arrColumnas[iColumn++]);
				this.empleado.setsueldo(Double.parseDouble(arrColumnas[iColumn++]));
				this.empleado.settelefono(arrColumnas[iColumn++]);
				this.empleado.setnumero_cuenta(arrColumnas[iColumn++]);
				this.empleado.settiene_casa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.empleado.settiene_vehiculo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.empleados.add(this.empleado);
			}
			
			this.saveEmpleados();
			
			this.connexion.commit();
			
			empleadoReturnGeneral.setConRetornoEstaProcesado(true);
			empleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadosEliminados() throws Exception {				
		
		List<Empleado> empleadosAux= new ArrayList<Empleado>();
		
		for(Empleado empleado:empleados) {
			if(!empleado.getIsDeleted()) {
				empleadosAux.add(empleado);
			}
		}
		
		empleados=empleadosAux;
	}
	
	public void quitarEmpleadosNulos() throws Exception {				
		
		List<Empleado> empleadosAux= new ArrayList<Empleado>();
		
		for(Empleado empleado : this.empleados) {
			if(empleado==null) {
				empleadosAux.add(empleado);
			}
		}
		
		//this.empleados=empleadosAux;
		
		this.empleados.removeAll(empleadosAux);
	}
	
	public void getSetVersionRowEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleado.getIsDeleted() || (empleado.getIsChanged()&&!empleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadoDataAccess.getSetVersionRowEmpleado(connexion,empleado.getId());
				
				if(!empleado.getVersionRow().equals(timestamp)) {	
					empleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleado()throws Exception {	
		
		if(empleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleado.getIsDeleted() || (empleado.getIsChanged()&&!empleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadoDataAccess.getSetVersionRowEmpleado(connexion,empleado.getId());
			
			try {							
				if(!empleado.getVersionRow().equals(timestamp)) {	
					empleado.setVersionRow(timestamp);
				}
				
				empleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadosWithConnection()throws Exception {	
		if(empleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Empleado empleadoAux:empleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoAux.getIsDeleted() || (empleadoAux.getIsChanged()&&!empleadoAux.getIsNew())) {
						
						timestamp=empleadoDataAccess.getSetVersionRowEmpleado(connexion,empleadoAux.getId());
						
						if(!empleado.getVersionRow().equals(timestamp)) {	
							empleadoAux.setVersionRow(timestamp);
						}
								
						empleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleados()throws Exception {	
		if(empleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Empleado empleadoAux:empleados) {
					if(empleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoAux.getIsDeleted() || (empleadoAux.getIsChanged()&&!empleadoAux.getIsNew())) {
						
						timestamp=empleadoDataAccess.getSetVersionRowEmpleado(connexion,empleadoAux.getId());
						
						if(!empleadoAux.getVersionRow().equals(timestamp)) {	
							empleadoAux.setVersionRow(timestamp);
						}
						
													
						empleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPais,String finalQueryGlobalProvincia,String finalQueryGlobalCiudad,String finalQueryGlobalCentroCosto,String finalQueryGlobalReligion,String finalQueryGlobalEstadoCivil,String finalQueryGlobalTipoGenero,String finalQueryGlobalTipoEmpleado,String finalQueryGlobalTipoInstruccion,String finalQueryGlobalCargo,String finalQueryGlobalEstructura,String finalQueryGlobalEstructuraSeccion,String finalQueryGlobalEstadoEmpleado,String finalQueryGlobalTipoContrato,String finalQueryGlobalTipoCuentaBancoGlobal) throws Exception {
		EmpleadoParameterReturnGeneral  empleadoReturnGeneral =new EmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoWithConnection");connexion.begin();
			
			empleadoReturnGeneral =new EmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			empleadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			empleadoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			empleadoReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			empleadoReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			empleadoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Religion> religionsForeignKey=new ArrayList<Religion>();
			ReligionLogic religionLogic=new ReligionLogic();
			religionLogic.setConnexion(this.connexion);
			religionLogic.getReligionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalReligion.equals("NONE")) {
				religionLogic.getTodosReligions(finalQueryGlobalReligion,new Pagination());
				religionsForeignKey=religionLogic.getReligions();
			}

			empleadoReturnGeneral.setreligionsForeignKey(religionsForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			empleadoReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			empleadoReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<TipoEmpleado> tipoempleadosForeignKey=new ArrayList<TipoEmpleado>();
			TipoEmpleadoLogic tipoempleadoLogic=new TipoEmpleadoLogic();
			tipoempleadoLogic.setConnexion(this.connexion);
			tipoempleadoLogic.getTipoEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEmpleado.equals("NONE")) {
				tipoempleadoLogic.getTodosTipoEmpleados(finalQueryGlobalTipoEmpleado,new Pagination());
				tipoempleadosForeignKey=tipoempleadoLogic.getTipoEmpleados();
			}

			empleadoReturnGeneral.settipoempleadosForeignKey(tipoempleadosForeignKey);


			List<TipoInstruccion> tipoinstruccionsForeignKey=new ArrayList<TipoInstruccion>();
			TipoInstruccionLogic tipoinstruccionLogic=new TipoInstruccionLogic();
			tipoinstruccionLogic.setConnexion(this.connexion);
			tipoinstruccionLogic.getTipoInstruccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoInstruccion.equals("NONE")) {
				tipoinstruccionLogic.getTodosTipoInstruccions(finalQueryGlobalTipoInstruccion,new Pagination());
				tipoinstruccionsForeignKey=tipoinstruccionLogic.getTipoInstruccions();
			}

			empleadoReturnGeneral.settipoinstruccionsForeignKey(tipoinstruccionsForeignKey);


			List<Cargo> cargosForeignKey=new ArrayList<Cargo>();
			CargoLogic cargoLogic=new CargoLogic();
			cargoLogic.setConnexion(this.connexion);
			cargoLogic.getCargoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargo.equals("NONE")) {
				cargoLogic.getTodosCargos(finalQueryGlobalCargo,new Pagination());
				cargosForeignKey=cargoLogic.getCargos();
			}

			empleadoReturnGeneral.setcargosForeignKey(cargosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Estructura> estructuraseccionsForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraseccionLogic=new EstructuraLogic();
			estructuraseccionLogic.setConnexion(this.connexion);
			estructuraseccionLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructuraSeccion.equals("NONE")) {
				estructuraseccionLogic.getTodosEstructuras(finalQueryGlobalEstructuraSeccion,new Pagination());
				estructuraseccionsForeignKey=estructuraseccionLogic.getEstructuras();
			}

			empleadoReturnGeneral.setestructuraseccionsForeignKey(estructuraseccionsForeignKey);


			List<EstadoEmpleado> estadoempleadosForeignKey=new ArrayList<EstadoEmpleado>();
			EstadoEmpleadoLogic estadoempleadoLogic=new EstadoEmpleadoLogic();
			estadoempleadoLogic.setConnexion(this.connexion);
			estadoempleadoLogic.getEstadoEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoEmpleado.equals("NONE")) {
				estadoempleadoLogic.getTodosEstadoEmpleados(finalQueryGlobalEstadoEmpleado,new Pagination());
				estadoempleadosForeignKey=estadoempleadoLogic.getEstadoEmpleados();
			}

			empleadoReturnGeneral.setestadoempleadosForeignKey(estadoempleadosForeignKey);


			List<TipoContrato> tipocontratosForeignKey=new ArrayList<TipoContrato>();
			TipoContratoLogic tipocontratoLogic=new TipoContratoLogic();
			tipocontratoLogic.setConnexion(this.connexion);
			tipocontratoLogic.getTipoContratoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoContrato.equals("NONE")) {
				tipocontratoLogic.getTodosTipoContratos(finalQueryGlobalTipoContrato,new Pagination());
				tipocontratosForeignKey=tipocontratoLogic.getTipoContratos();
			}

			empleadoReturnGeneral.settipocontratosForeignKey(tipocontratosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			empleadoReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadoReturnGeneral;
	}
	
	public EmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyEmpleado(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPais,String finalQueryGlobalProvincia,String finalQueryGlobalCiudad,String finalQueryGlobalCentroCosto,String finalQueryGlobalReligion,String finalQueryGlobalEstadoCivil,String finalQueryGlobalTipoGenero,String finalQueryGlobalTipoEmpleado,String finalQueryGlobalTipoInstruccion,String finalQueryGlobalCargo,String finalQueryGlobalEstructura,String finalQueryGlobalEstructuraSeccion,String finalQueryGlobalEstadoEmpleado,String finalQueryGlobalTipoContrato,String finalQueryGlobalTipoCuentaBancoGlobal) throws Exception {
		EmpleadoParameterReturnGeneral  empleadoReturnGeneral =new EmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadoReturnGeneral =new EmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			empleadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			empleadoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			empleadoReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			empleadoReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			empleadoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Religion> religionsForeignKey=new ArrayList<Religion>();
			ReligionLogic religionLogic=new ReligionLogic();
			religionLogic.setConnexion(this.connexion);
			religionLogic.getReligionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalReligion.equals("NONE")) {
				religionLogic.getTodosReligions(finalQueryGlobalReligion,new Pagination());
				religionsForeignKey=religionLogic.getReligions();
			}

			empleadoReturnGeneral.setreligionsForeignKey(religionsForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			empleadoReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			empleadoReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<TipoEmpleado> tipoempleadosForeignKey=new ArrayList<TipoEmpleado>();
			TipoEmpleadoLogic tipoempleadoLogic=new TipoEmpleadoLogic();
			tipoempleadoLogic.setConnexion(this.connexion);
			tipoempleadoLogic.getTipoEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEmpleado.equals("NONE")) {
				tipoempleadoLogic.getTodosTipoEmpleados(finalQueryGlobalTipoEmpleado,new Pagination());
				tipoempleadosForeignKey=tipoempleadoLogic.getTipoEmpleados();
			}

			empleadoReturnGeneral.settipoempleadosForeignKey(tipoempleadosForeignKey);


			List<TipoInstruccion> tipoinstruccionsForeignKey=new ArrayList<TipoInstruccion>();
			TipoInstruccionLogic tipoinstruccionLogic=new TipoInstruccionLogic();
			tipoinstruccionLogic.setConnexion(this.connexion);
			tipoinstruccionLogic.getTipoInstruccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoInstruccion.equals("NONE")) {
				tipoinstruccionLogic.getTodosTipoInstruccions(finalQueryGlobalTipoInstruccion,new Pagination());
				tipoinstruccionsForeignKey=tipoinstruccionLogic.getTipoInstruccions();
			}

			empleadoReturnGeneral.settipoinstruccionsForeignKey(tipoinstruccionsForeignKey);


			List<Cargo> cargosForeignKey=new ArrayList<Cargo>();
			CargoLogic cargoLogic=new CargoLogic();
			cargoLogic.setConnexion(this.connexion);
			cargoLogic.getCargoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargo.equals("NONE")) {
				cargoLogic.getTodosCargos(finalQueryGlobalCargo,new Pagination());
				cargosForeignKey=cargoLogic.getCargos();
			}

			empleadoReturnGeneral.setcargosForeignKey(cargosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Estructura> estructuraseccionsForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraseccionLogic=new EstructuraLogic();
			estructuraseccionLogic.setConnexion(this.connexion);
			estructuraseccionLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructuraSeccion.equals("NONE")) {
				estructuraseccionLogic.getTodosEstructuras(finalQueryGlobalEstructuraSeccion,new Pagination());
				estructuraseccionsForeignKey=estructuraseccionLogic.getEstructuras();
			}

			empleadoReturnGeneral.setestructuraseccionsForeignKey(estructuraseccionsForeignKey);


			List<EstadoEmpleado> estadoempleadosForeignKey=new ArrayList<EstadoEmpleado>();
			EstadoEmpleadoLogic estadoempleadoLogic=new EstadoEmpleadoLogic();
			estadoempleadoLogic.setConnexion(this.connexion);
			estadoempleadoLogic.getEstadoEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoEmpleado.equals("NONE")) {
				estadoempleadoLogic.getTodosEstadoEmpleados(finalQueryGlobalEstadoEmpleado,new Pagination());
				estadoempleadosForeignKey=estadoempleadoLogic.getEstadoEmpleados();
			}

			empleadoReturnGeneral.setestadoempleadosForeignKey(estadoempleadosForeignKey);


			List<TipoContrato> tipocontratosForeignKey=new ArrayList<TipoContrato>();
			TipoContratoLogic tipocontratoLogic=new TipoContratoLogic();
			tipocontratoLogic.setConnexion(this.connexion);
			tipocontratoLogic.getTipoContratoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoContrato.equals("NONE")) {
				tipocontratoLogic.getTodosTipoContratos(finalQueryGlobalTipoContrato,new Pagination());
				tipocontratosForeignKey=tipocontratoLogic.getTipoContratos();
			}

			empleadoReturnGeneral.settipocontratosForeignKey(tipocontratosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			empleadoReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEmpleadoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CargaFamiliar_NMLogic cargafamiliar_nmLogic=new CargaFamiliar_NMLogic();
			CursoLogic cursoLogic=new CursoLogic();
			PrestamoLogic prestamoLogic=new PrestamoLogic();
			EmpleadoIdiomaLogic empleadoidiomaLogic=new EmpleadoIdiomaLogic();
			HistorialPagoMesNomiLogic historialpagomesnomiLogic=new HistorialPagoMesNomiLogic();
			EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic=new EmpleadoImpuestoRentaLogic();
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic=new DatoGeneralEmpleadoLogic();
			AreaLogic areaLogic=new AreaLogic();
			GastoEmpleadoLogic gastoempleadoLogic=new GastoEmpleadoLogic();
			EmpleadoHobbyLogic empleadohobbyLogic=new EmpleadoHobbyLogic();
			EmpleadoEMailLogic empleadoemailLogic=new EmpleadoEMailLogic();
			RasgoPersonalLogic rasgopersonalLogic=new RasgoPersonalLogic();
			ReferenciaLogic referenciaLogic=new ReferenciaLogic();
			Telefono_NMLogic telefono_nmLogic=new Telefono_NMLogic();
			NovedadLogic novedadLogic=new NovedadLogic();
			EmpleadoHerraLogic empleadoherraLogic=new EmpleadoHerraLogic();
			EmpleadoEnferLogic empleadoenferLogic=new EmpleadoEnferLogic();
			VisaLogic visaLogic=new VisaLogic();
			SeguroLogic seguroLogic=new SeguroLogic();
			AsistenciaMensualLogic asistenciamensualLogic=new AsistenciaMensualLogic();
			EmpleadoDiscaLogic empleadodiscaLogic=new EmpleadoDiscaLogic();
			ProfesionEmpleaLogic profesionempleaLogic=new ProfesionEmpleaLogic();
			RubroEmpleadoLogic rubroempleadoLogic=new RubroEmpleadoLogic();
			EmpleadoConstanteLogic empleadoconstanteLogic=new EmpleadoConstanteLogic();
			TallaVestidoLogic tallavestidoLogic=new TallaVestidoLogic();
			NovedadNomiLogic novedadnomiLogic=new NovedadNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEmpleadoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CargaFamiliar_NM.class));
			classes.add(new Classe(Curso.class));
			classes.add(new Classe(Prestamo.class));
			classes.add(new Classe(EmpleadoIdioma.class));
			classes.add(new Classe(HistorialPagoMesNomi.class));
			classes.add(new Classe(EmpleadoImpuestoRenta.class));
			classes.add(new Classe(DatoGeneralEmpleado.class));
			classes.add(new Classe(Area.class));
			classes.add(new Classe(GastoEmpleado.class));
			classes.add(new Classe(EmpleadoHobby.class));
			classes.add(new Classe(EmpleadoEMail.class));
			classes.add(new Classe(RasgoPersonal.class));
			classes.add(new Classe(Referencia.class));
			classes.add(new Classe(Telefono_NM.class));
			classes.add(new Classe(Novedad.class));
			classes.add(new Classe(EmpleadoHerra.class));
			classes.add(new Classe(EmpleadoEnfer.class));
			classes.add(new Classe(Visa.class));
			classes.add(new Classe(Seguro.class));
			classes.add(new Classe(AsistenciaMensual.class));
			classes.add(new Classe(EmpleadoDisca.class));
			classes.add(new Classe(ProfesionEmplea.class));
			classes.add(new Classe(RubroEmpleado.class));
			classes.add(new Classe(EmpleadoConstante.class));
			classes.add(new Classe(TallaVestido.class));
			classes.add(new Classe(NovedadNomi.class));
											
			

			cargafamiliar_nmLogic.setConnexion(this.getConnexion());
			cargafamiliar_nmLogic.setDatosCliente(this.datosCliente);
			cargafamiliar_nmLogic.setIsConRefrescarForeignKeys(true);

			cursoLogic.setConnexion(this.getConnexion());
			cursoLogic.setDatosCliente(this.datosCliente);
			cursoLogic.setIsConRefrescarForeignKeys(true);

			prestamoLogic.setConnexion(this.getConnexion());
			prestamoLogic.setDatosCliente(this.datosCliente);
			prestamoLogic.setIsConRefrescarForeignKeys(true);

			empleadoidiomaLogic.setConnexion(this.getConnexion());
			empleadoidiomaLogic.setDatosCliente(this.datosCliente);
			empleadoidiomaLogic.setIsConRefrescarForeignKeys(true);

			historialpagomesnomiLogic.setConnexion(this.getConnexion());
			historialpagomesnomiLogic.setDatosCliente(this.datosCliente);
			historialpagomesnomiLogic.setIsConRefrescarForeignKeys(true);

			empleadoimpuestorentaLogic.setConnexion(this.getConnexion());
			empleadoimpuestorentaLogic.setDatosCliente(this.datosCliente);
			empleadoimpuestorentaLogic.setIsConRefrescarForeignKeys(true);

			datogeneralempleadoLogic.setConnexion(this.getConnexion());
			datogeneralempleadoLogic.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic.setIsConRefrescarForeignKeys(true);

			areaLogic.setConnexion(this.getConnexion());
			areaLogic.setDatosCliente(this.datosCliente);
			areaLogic.setIsConRefrescarForeignKeys(true);

			gastoempleadoLogic.setConnexion(this.getConnexion());
			gastoempleadoLogic.setDatosCliente(this.datosCliente);
			gastoempleadoLogic.setIsConRefrescarForeignKeys(true);

			empleadohobbyLogic.setConnexion(this.getConnexion());
			empleadohobbyLogic.setDatosCliente(this.datosCliente);
			empleadohobbyLogic.setIsConRefrescarForeignKeys(true);

			empleadoemailLogic.setConnexion(this.getConnexion());
			empleadoemailLogic.setDatosCliente(this.datosCliente);
			empleadoemailLogic.setIsConRefrescarForeignKeys(true);

			rasgopersonalLogic.setConnexion(this.getConnexion());
			rasgopersonalLogic.setDatosCliente(this.datosCliente);
			rasgopersonalLogic.setIsConRefrescarForeignKeys(true);

			referenciaLogic.setConnexion(this.getConnexion());
			referenciaLogic.setDatosCliente(this.datosCliente);
			referenciaLogic.setIsConRefrescarForeignKeys(true);

			telefono_nmLogic.setConnexion(this.getConnexion());
			telefono_nmLogic.setDatosCliente(this.datosCliente);
			telefono_nmLogic.setIsConRefrescarForeignKeys(true);

			novedadLogic.setConnexion(this.getConnexion());
			novedadLogic.setDatosCliente(this.datosCliente);
			novedadLogic.setIsConRefrescarForeignKeys(true);

			empleadoherraLogic.setConnexion(this.getConnexion());
			empleadoherraLogic.setDatosCliente(this.datosCliente);
			empleadoherraLogic.setIsConRefrescarForeignKeys(true);

			empleadoenferLogic.setConnexion(this.getConnexion());
			empleadoenferLogic.setDatosCliente(this.datosCliente);
			empleadoenferLogic.setIsConRefrescarForeignKeys(true);

			visaLogic.setConnexion(this.getConnexion());
			visaLogic.setDatosCliente(this.datosCliente);
			visaLogic.setIsConRefrescarForeignKeys(true);

			seguroLogic.setConnexion(this.getConnexion());
			seguroLogic.setDatosCliente(this.datosCliente);
			seguroLogic.setIsConRefrescarForeignKeys(true);

			asistenciamensualLogic.setConnexion(this.getConnexion());
			asistenciamensualLogic.setDatosCliente(this.datosCliente);
			asistenciamensualLogic.setIsConRefrescarForeignKeys(true);

			empleadodiscaLogic.setConnexion(this.getConnexion());
			empleadodiscaLogic.setDatosCliente(this.datosCliente);
			empleadodiscaLogic.setIsConRefrescarForeignKeys(true);

			profesionempleaLogic.setConnexion(this.getConnexion());
			profesionempleaLogic.setDatosCliente(this.datosCliente);
			profesionempleaLogic.setIsConRefrescarForeignKeys(true);

			rubroempleadoLogic.setConnexion(this.getConnexion());
			rubroempleadoLogic.setDatosCliente(this.datosCliente);
			rubroempleadoLogic.setIsConRefrescarForeignKeys(true);

			empleadoconstanteLogic.setConnexion(this.getConnexion());
			empleadoconstanteLogic.setDatosCliente(this.datosCliente);
			empleadoconstanteLogic.setIsConRefrescarForeignKeys(true);

			tallavestidoLogic.setConnexion(this.getConnexion());
			tallavestidoLogic.setDatosCliente(this.datosCliente);
			tallavestidoLogic.setIsConRefrescarForeignKeys(true);

			novedadnomiLogic.setConnexion(this.getConnexion());
			novedadnomiLogic.setDatosCliente(this.datosCliente);
			novedadnomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Empleado empleado:this.empleados) {
				

				classes=new ArrayList<Classe>();
				classes=CargaFamiliar_NMConstantesFunciones.getClassesForeignKeysOfCargaFamiliar_NM(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargafamiliar_nmLogic.setCargaFamiliar_NMs(empleado.cargafamiliar_nms);
				cargafamiliar_nmLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CursoConstantesFunciones.getClassesForeignKeysOfCurso(new ArrayList<Classe>(),DeepLoadType.NONE);

				cursoLogic.setCursos(empleado.cursos);
				cursoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PrestamoConstantesFunciones.getClassesForeignKeysOfPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);

				prestamoLogic.setPrestamos(empleado.prestamos);
				prestamoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoIdiomaConstantesFunciones.getClassesForeignKeysOfEmpleadoIdioma(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoidiomaLogic.setEmpleadoIdiomas(empleado.empleadoidiomas);
				empleadoidiomaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=HistorialPagoMesNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoMesNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				historialpagomesnomiLogic.setHistorialPagoMesNomis(empleado.historialpagomesnomis);
				historialpagomesnomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoImpuestoRentaConstantesFunciones.getClassesForeignKeysOfEmpleadoImpuestoRenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoimpuestorentaLogic.setEmpleadoImpuestoRentas(empleado.empleadoimpuestorentas);
				empleadoimpuestorentaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralempleadoLogic.setDatoGeneralEmpleado(empleado.datogeneralempleado);
				datogeneralempleadoLogic.deepLoad(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AreaConstantesFunciones.getClassesForeignKeysOfArea(new ArrayList<Classe>(),DeepLoadType.NONE);

				areaLogic.setAreas(empleado.areas);
				areaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GastoEmpleadoConstantesFunciones.getClassesForeignKeysOfGastoEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				gastoempleadoLogic.setGastoEmpleados(empleado.gastoempleados);
				gastoempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoHobbyConstantesFunciones.getClassesForeignKeysOfEmpleadoHobby(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadohobbyLogic.setEmpleadoHobbys(empleado.empleadohobbys);
				empleadohobbyLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoEMailConstantesFunciones.getClassesForeignKeysOfEmpleadoEMail(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoemailLogic.setEmpleadoEMails(empleado.empleadoemails);
				empleadoemailLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RasgoPersonalConstantesFunciones.getClassesForeignKeysOfRasgoPersonal(new ArrayList<Classe>(),DeepLoadType.NONE);

				rasgopersonalLogic.setRasgoPersonals(empleado.rasgopersonals);
				rasgopersonalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ReferenciaConstantesFunciones.getClassesForeignKeysOfReferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciaLogic.setReferencias(empleado.referencias);
				referenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=Telefono_NMConstantesFunciones.getClassesForeignKeysOfTelefono_NM(new ArrayList<Classe>(),DeepLoadType.NONE);

				telefono_nmLogic.setTelefono_NMs(empleado.telefono_nms);
				telefono_nmLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NovedadConstantesFunciones.getClassesForeignKeysOfNovedad(new ArrayList<Classe>(),DeepLoadType.NONE);

				novedadLogic.setNovedads(empleado.novedads);
				novedadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoHerraConstantesFunciones.getClassesForeignKeysOfEmpleadoHerra(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoherraLogic.setEmpleadoHerras(empleado.empleadoherras);
				empleadoherraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoEnferConstantesFunciones.getClassesForeignKeysOfEmpleadoEnfer(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoenferLogic.setEmpleadoEnfers(empleado.empleadoenfers);
				empleadoenferLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=VisaConstantesFunciones.getClassesForeignKeysOfVisa(new ArrayList<Classe>(),DeepLoadType.NONE);

				visaLogic.setVisas(empleado.visas);
				visaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SeguroConstantesFunciones.getClassesForeignKeysOfSeguro(new ArrayList<Classe>(),DeepLoadType.NONE);

				seguroLogic.setSeguros(empleado.seguros);
				seguroLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AsistenciaMensualConstantesFunciones.getClassesForeignKeysOfAsistenciaMensual(new ArrayList<Classe>(),DeepLoadType.NONE);

				asistenciamensualLogic.setAsistenciaMensuals(empleado.asistenciamensuals);
				asistenciamensualLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoDiscaConstantesFunciones.getClassesForeignKeysOfEmpleadoDisca(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadodiscaLogic.setEmpleadoDiscas(empleado.empleadodiscas);
				empleadodiscaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProfesionEmpleaConstantesFunciones.getClassesForeignKeysOfProfesionEmplea(new ArrayList<Classe>(),DeepLoadType.NONE);

				profesionempleaLogic.setProfesionEmpleas(empleado.profesionempleas);
				profesionempleaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RubroEmpleadoConstantesFunciones.getClassesForeignKeysOfRubroEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				rubroempleadoLogic.setRubroEmpleados(empleado.rubroempleados);
				rubroempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstanteConstantesFunciones.getClassesForeignKeysOfEmpleadoConstante(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoconstanteLogic.setEmpleadoConstantes(empleado.empleadoconstantes);
				empleadoconstanteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TallaVestidoConstantesFunciones.getClassesForeignKeysOfTallaVestido(new ArrayList<Classe>(),DeepLoadType.NONE);

				tallavestidoLogic.setTallaVestidos(empleado.tallavestidos);
				tallavestidoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NovedadNomiConstantesFunciones.getClassesForeignKeysOfNovedadNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				novedadnomiLogic.setNovedadNomis(empleado.novedadnomis);
				novedadnomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Empleado empleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoLogicAdditional.updateEmpleadoToGet(empleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleado.setEmpresa(empleadoDataAccess.getEmpresa(connexion,empleado));
		empleado.setSucursal(empleadoDataAccess.getSucursal(connexion,empleado));
		empleado.setPais(empleadoDataAccess.getPais(connexion,empleado));
		empleado.setProvincia(empleadoDataAccess.getProvincia(connexion,empleado));
		empleado.setCiudad(empleadoDataAccess.getCiudad(connexion,empleado));
		empleado.setCentroCosto(empleadoDataAccess.getCentroCosto(connexion,empleado));
		empleado.setReligion(empleadoDataAccess.getReligion(connexion,empleado));
		empleado.setEstadoCivil(empleadoDataAccess.getEstadoCivil(connexion,empleado));
		empleado.setTipoGenero(empleadoDataAccess.getTipoGenero(connexion,empleado));
		empleado.setTipoEmpleado(empleadoDataAccess.getTipoEmpleado(connexion,empleado));
		empleado.setTipoInstruccion(empleadoDataAccess.getTipoInstruccion(connexion,empleado));
		empleado.setCargo(empleadoDataAccess.getCargo(connexion,empleado));
		empleado.setEstructura(empleadoDataAccess.getEstructura(connexion,empleado));
		empleado.setEstructuraSeccion(empleadoDataAccess.getEstructuraSeccion(connexion,empleado));
		empleado.setEstadoEmpleado(empleadoDataAccess.getEstadoEmpleado(connexion,empleado));
		empleado.setTipoContrato(empleadoDataAccess.getTipoContrato(connexion,empleado));
		empleado.setTipoCuentaBancoGlobal(empleadoDataAccess.getTipoCuentaBancoGlobal(connexion,empleado));
		empleado.setCargaFamiliar_NMs(empleadoDataAccess.getCargaFamiliar_NMs(connexion,empleado));
		empleado.setCursos(empleadoDataAccess.getCursos(connexion,empleado));
		empleado.setPrestamos(empleadoDataAccess.getPrestamos(connexion,empleado));
		empleado.setEmpleadoIdiomas(empleadoDataAccess.getEmpleadoIdiomas(connexion,empleado));
		empleado.setHistorialPagoMesNomis(empleadoDataAccess.getHistorialPagoMesNomis(connexion,empleado));
		empleado.setEmpleadoImpuestoRentas(empleadoDataAccess.getEmpleadoImpuestoRentas(connexion,empleado));
		empleado.setDatoGeneralEmpleado(empleadoDataAccess.getDatoGeneralEmpleado(connexion,empleado));
		empleado.setAreas(empleadoDataAccess.getAreas(connexion,empleado));
		empleado.setGastoEmpleados(empleadoDataAccess.getGastoEmpleados(connexion,empleado));
		empleado.setEmpleadoHobbys(empleadoDataAccess.getEmpleadoHobbys(connexion,empleado));
		empleado.setEmpleadoEMails(empleadoDataAccess.getEmpleadoEMails(connexion,empleado));
		empleado.setRasgoPersonals(empleadoDataAccess.getRasgoPersonals(connexion,empleado));
		empleado.setReferencias(empleadoDataAccess.getReferencias(connexion,empleado));
		empleado.setTelefono_NMs(empleadoDataAccess.getTelefono_NMs(connexion,empleado));
		empleado.setNovedads(empleadoDataAccess.getNovedads(connexion,empleado));
		empleado.setEmpleadoHerras(empleadoDataAccess.getEmpleadoHerras(connexion,empleado));
		empleado.setEmpleadoEnfers(empleadoDataAccess.getEmpleadoEnfers(connexion,empleado));
		empleado.setVisas(empleadoDataAccess.getVisas(connexion,empleado));
		empleado.setSeguros(empleadoDataAccess.getSeguros(connexion,empleado));
		empleado.setAsistenciaMensuals(empleadoDataAccess.getAsistenciaMensuals(connexion,empleado));
		empleado.setEmpleadoDiscas(empleadoDataAccess.getEmpleadoDiscas(connexion,empleado));
		empleado.setProfesionEmpleas(empleadoDataAccess.getProfesionEmpleas(connexion,empleado));
		empleado.setRubroEmpleados(empleadoDataAccess.getRubroEmpleados(connexion,empleado));
		empleado.setEmpleadoConstantes(empleadoDataAccess.getEmpleadoConstantes(connexion,empleado));
		empleado.setTallaVestidos(empleadoDataAccess.getTallaVestidos(connexion,empleado));
		empleado.setNovedadNomis(empleadoDataAccess.getNovedadNomis(connexion,empleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleado.setEmpresa(empleadoDataAccess.getEmpresa(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				empleado.setSucursal(empleadoDataAccess.getSucursal(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				empleado.setPais(empleadoDataAccess.getPais(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				empleado.setProvincia(empleadoDataAccess.getProvincia(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				empleado.setCiudad(empleadoDataAccess.getCiudad(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				empleado.setCentroCosto(empleadoDataAccess.getCentroCosto(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(Religion.class)) {
				empleado.setReligion(empleadoDataAccess.getReligion(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				empleado.setEstadoCivil(empleadoDataAccess.getEstadoCivil(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				empleado.setTipoGenero(empleadoDataAccess.getTipoGenero(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(TipoEmpleado.class)) {
				empleado.setTipoEmpleado(empleadoDataAccess.getTipoEmpleado(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(TipoInstruccion.class)) {
				empleado.setTipoInstruccion(empleadoDataAccess.getTipoInstruccion(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				empleado.setCargo(empleadoDataAccess.getCargo(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleado.setEstructura(empleadoDataAccess.getEstructura(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleado.setEstructuraSeccion(empleadoDataAccess.getEstructuraSeccion(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(EstadoEmpleado.class)) {
				empleado.setEstadoEmpleado(empleadoDataAccess.getEstadoEmpleado(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(TipoContrato.class)) {
				empleado.setTipoContrato(empleadoDataAccess.getTipoContrato(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				empleado.setTipoCuentaBancoGlobal(empleadoDataAccess.getTipoCuentaBancoGlobal(connexion,empleado));
				continue;
			}

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setCargaFamiliar_NMs(empleadoDataAccess.getCargaFamiliar_NMs(connexion,empleado));

				if(this.isConDeep) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(this.connexion);
					cargafamiliar_nmLogic.setCargaFamiliar_NMs(empleado.getCargaFamiliar_NMs());
					ArrayList<Classe> classesLocal=CargaFamiliar_NMConstantesFunciones.getClassesForeignKeysOfCargaFamiliar_NM(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargafamiliar_nmLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(cargafamiliar_nmLogic.getCargaFamiliar_NMs());
					empleado.setCargaFamiliar_NMs(cargafamiliar_nmLogic.getCargaFamiliar_NMs());
				}

				continue;
			}

			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setCursos(empleadoDataAccess.getCursos(connexion,empleado));

				if(this.isConDeep) {
					CursoLogic cursoLogic= new CursoLogic(this.connexion);
					cursoLogic.setCursos(empleado.getCursos());
					ArrayList<Classe> classesLocal=CursoConstantesFunciones.getClassesForeignKeysOfCurso(new ArrayList<Classe>(),DeepLoadType.NONE);
					cursoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(cursoLogic.getCursos());
					empleado.setCursos(cursoLogic.getCursos());
				}

				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setPrestamos(empleadoDataAccess.getPrestamos(connexion,empleado));

				if(this.isConDeep) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(this.connexion);
					prestamoLogic.setPrestamos(empleado.getPrestamos());
					ArrayList<Classe> classesLocal=PrestamoConstantesFunciones.getClassesForeignKeysOfPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);
					prestamoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(prestamoLogic.getPrestamos());
					empleado.setPrestamos(prestamoLogic.getPrestamos());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoIdiomas(empleadoDataAccess.getEmpleadoIdiomas(connexion,empleado));

				if(this.isConDeep) {
					EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(this.connexion);
					empleadoidiomaLogic.setEmpleadoIdiomas(empleado.getEmpleadoIdiomas());
					ArrayList<Classe> classesLocal=EmpleadoIdiomaConstantesFunciones.getClassesForeignKeysOfEmpleadoIdioma(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoidiomaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(empleadoidiomaLogic.getEmpleadoIdiomas());
					empleado.setEmpleadoIdiomas(empleadoidiomaLogic.getEmpleadoIdiomas());
				}

				continue;
			}

			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setHistorialPagoMesNomis(empleadoDataAccess.getHistorialPagoMesNomis(connexion,empleado));

				if(this.isConDeep) {
					HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(this.connexion);
					historialpagomesnomiLogic.setHistorialPagoMesNomis(empleado.getHistorialPagoMesNomis());
					ArrayList<Classe> classesLocal=HistorialPagoMesNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoMesNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					historialpagomesnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(historialpagomesnomiLogic.getHistorialPagoMesNomis());
					empleado.setHistorialPagoMesNomis(historialpagomesnomiLogic.getHistorialPagoMesNomis());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoImpuestoRentas(empleadoDataAccess.getEmpleadoImpuestoRentas(connexion,empleado));

				if(this.isConDeep) {
					EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(this.connexion);
					empleadoimpuestorentaLogic.setEmpleadoImpuestoRentas(empleado.getEmpleadoImpuestoRentas());
					ArrayList<Classe> classesLocal=EmpleadoImpuestoRentaConstantesFunciones.getClassesForeignKeysOfEmpleadoImpuestoRenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoimpuestorentaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(empleadoimpuestorentaLogic.getEmpleadoImpuestoRentas());
					empleado.setEmpleadoImpuestoRentas(empleadoimpuestorentaLogic.getEmpleadoImpuestoRentas());
				}

				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setDatoGeneralEmpleado(empleadoDataAccess.getDatoGeneralEmpleado(connexion,empleado));

				if(this.isConDeep) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(this.connexion);
					datogeneralempleadoLogic.setDatoGeneralEmpleado(empleado.getDatoGeneralEmpleado());
					ArrayList<Classe> classesLocal=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralempleadoLogic.deepLoad(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleado());
					empleado.setDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleado());
				}

				continue;
			}

			if(clas.clas.equals(Area.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setAreas(empleadoDataAccess.getAreas(connexion,empleado));

				if(this.isConDeep) {
					AreaLogic areaLogic= new AreaLogic(this.connexion);
					areaLogic.setAreas(empleado.getAreas());
					ArrayList<Classe> classesLocal=AreaConstantesFunciones.getClassesForeignKeysOfArea(new ArrayList<Classe>(),DeepLoadType.NONE);
					areaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AreaConstantesFunciones.refrescarForeignKeysDescripcionesArea(areaLogic.getAreas());
					empleado.setAreas(areaLogic.getAreas());
				}

				continue;
			}

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setGastoEmpleados(empleadoDataAccess.getGastoEmpleados(connexion,empleado));

				if(this.isConDeep) {
					GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(this.connexion);
					gastoempleadoLogic.setGastoEmpleados(empleado.getGastoEmpleados());
					ArrayList<Classe> classesLocal=GastoEmpleadoConstantesFunciones.getClassesForeignKeysOfGastoEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					gastoempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(gastoempleadoLogic.getGastoEmpleados());
					empleado.setGastoEmpleados(gastoempleadoLogic.getGastoEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoHobbys(empleadoDataAccess.getEmpleadoHobbys(connexion,empleado));

				if(this.isConDeep) {
					EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(this.connexion);
					empleadohobbyLogic.setEmpleadoHobbys(empleado.getEmpleadoHobbys());
					ArrayList<Classe> classesLocal=EmpleadoHobbyConstantesFunciones.getClassesForeignKeysOfEmpleadoHobby(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadohobbyLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(empleadohobbyLogic.getEmpleadoHobbys());
					empleado.setEmpleadoHobbys(empleadohobbyLogic.getEmpleadoHobbys());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoEMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoEMails(empleadoDataAccess.getEmpleadoEMails(connexion,empleado));

				if(this.isConDeep) {
					EmpleadoEMailLogic empleadoemailLogic= new EmpleadoEMailLogic(this.connexion);
					empleadoemailLogic.setEmpleadoEMails(empleado.getEmpleadoEMails());
					ArrayList<Classe> classesLocal=EmpleadoEMailConstantesFunciones.getClassesForeignKeysOfEmpleadoEMail(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoemailLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoEMailConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEMail(empleadoemailLogic.getEmpleadoEMails());
					empleado.setEmpleadoEMails(empleadoemailLogic.getEmpleadoEMails());
				}

				continue;
			}

			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setRasgoPersonals(empleadoDataAccess.getRasgoPersonals(connexion,empleado));

				if(this.isConDeep) {
					RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(this.connexion);
					rasgopersonalLogic.setRasgoPersonals(empleado.getRasgoPersonals());
					ArrayList<Classe> classesLocal=RasgoPersonalConstantesFunciones.getClassesForeignKeysOfRasgoPersonal(new ArrayList<Classe>(),DeepLoadType.NONE);
					rasgopersonalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(rasgopersonalLogic.getRasgoPersonals());
					empleado.setRasgoPersonals(rasgopersonalLogic.getRasgoPersonals());
				}

				continue;
			}

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setReferencias(empleadoDataAccess.getReferencias(connexion,empleado));

				if(this.isConDeep) {
					ReferenciaLogic referenciaLogic= new ReferenciaLogic(this.connexion);
					referenciaLogic.setReferencias(empleado.getReferencias());
					ArrayList<Classe> classesLocal=ReferenciaConstantesFunciones.getClassesForeignKeysOfReferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(referenciaLogic.getReferencias());
					empleado.setReferencias(referenciaLogic.getReferencias());
				}

				continue;
			}

			if(clas.clas.equals(Telefono_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setTelefono_NMs(empleadoDataAccess.getTelefono_NMs(connexion,empleado));

				if(this.isConDeep) {
					Telefono_NMLogic telefono_nmLogic= new Telefono_NMLogic(this.connexion);
					telefono_nmLogic.setTelefono_NMs(empleado.getTelefono_NMs());
					ArrayList<Classe> classesLocal=Telefono_NMConstantesFunciones.getClassesForeignKeysOfTelefono_NM(new ArrayList<Classe>(),DeepLoadType.NONE);
					telefono_nmLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(telefono_nmLogic.getTelefono_NMs());
					empleado.setTelefono_NMs(telefono_nmLogic.getTelefono_NMs());
				}

				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setNovedads(empleadoDataAccess.getNovedads(connexion,empleado));

				if(this.isConDeep) {
					NovedadLogic novedadLogic= new NovedadLogic(this.connexion);
					novedadLogic.setNovedads(empleado.getNovedads());
					ArrayList<Classe> classesLocal=NovedadConstantesFunciones.getClassesForeignKeysOfNovedad(new ArrayList<Classe>(),DeepLoadType.NONE);
					novedadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NovedadConstantesFunciones.refrescarForeignKeysDescripcionesNovedad(novedadLogic.getNovedads());
					empleado.setNovedads(novedadLogic.getNovedads());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoHerras(empleadoDataAccess.getEmpleadoHerras(connexion,empleado));

				if(this.isConDeep) {
					EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(this.connexion);
					empleadoherraLogic.setEmpleadoHerras(empleado.getEmpleadoHerras());
					ArrayList<Classe> classesLocal=EmpleadoHerraConstantesFunciones.getClassesForeignKeysOfEmpleadoHerra(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoherraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(empleadoherraLogic.getEmpleadoHerras());
					empleado.setEmpleadoHerras(empleadoherraLogic.getEmpleadoHerras());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoEnfers(empleadoDataAccess.getEmpleadoEnfers(connexion,empleado));

				if(this.isConDeep) {
					EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(this.connexion);
					empleadoenferLogic.setEmpleadoEnfers(empleado.getEmpleadoEnfers());
					ArrayList<Classe> classesLocal=EmpleadoEnferConstantesFunciones.getClassesForeignKeysOfEmpleadoEnfer(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoenferLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(empleadoenferLogic.getEmpleadoEnfers());
					empleado.setEmpleadoEnfers(empleadoenferLogic.getEmpleadoEnfers());
				}

				continue;
			}

			if(clas.clas.equals(Visa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setVisas(empleadoDataAccess.getVisas(connexion,empleado));

				if(this.isConDeep) {
					VisaLogic visaLogic= new VisaLogic(this.connexion);
					visaLogic.setVisas(empleado.getVisas());
					ArrayList<Classe> classesLocal=VisaConstantesFunciones.getClassesForeignKeysOfVisa(new ArrayList<Classe>(),DeepLoadType.NONE);
					visaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VisaConstantesFunciones.refrescarForeignKeysDescripcionesVisa(visaLogic.getVisas());
					empleado.setVisas(visaLogic.getVisas());
				}

				continue;
			}

			if(clas.clas.equals(Seguro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setSeguros(empleadoDataAccess.getSeguros(connexion,empleado));

				if(this.isConDeep) {
					SeguroLogic seguroLogic= new SeguroLogic(this.connexion);
					seguroLogic.setSeguros(empleado.getSeguros());
					ArrayList<Classe> classesLocal=SeguroConstantesFunciones.getClassesForeignKeysOfSeguro(new ArrayList<Classe>(),DeepLoadType.NONE);
					seguroLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SeguroConstantesFunciones.refrescarForeignKeysDescripcionesSeguro(seguroLogic.getSeguros());
					empleado.setSeguros(seguroLogic.getSeguros());
				}

				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setAsistenciaMensuals(empleadoDataAccess.getAsistenciaMensuals(connexion,empleado));

				if(this.isConDeep) {
					AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(this.connexion);
					asistenciamensualLogic.setAsistenciaMensuals(empleado.getAsistenciaMensuals());
					ArrayList<Classe> classesLocal=AsistenciaMensualConstantesFunciones.getClassesForeignKeysOfAsistenciaMensual(new ArrayList<Classe>(),DeepLoadType.NONE);
					asistenciamensualLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(asistenciamensualLogic.getAsistenciaMensuals());
					empleado.setAsistenciaMensuals(asistenciamensualLogic.getAsistenciaMensuals());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoDiscas(empleadoDataAccess.getEmpleadoDiscas(connexion,empleado));

				if(this.isConDeep) {
					EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(this.connexion);
					empleadodiscaLogic.setEmpleadoDiscas(empleado.getEmpleadoDiscas());
					ArrayList<Classe> classesLocal=EmpleadoDiscaConstantesFunciones.getClassesForeignKeysOfEmpleadoDisca(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadodiscaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(empleadodiscaLogic.getEmpleadoDiscas());
					empleado.setEmpleadoDiscas(empleadodiscaLogic.getEmpleadoDiscas());
				}

				continue;
			}

			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setProfesionEmpleas(empleadoDataAccess.getProfesionEmpleas(connexion,empleado));

				if(this.isConDeep) {
					ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(this.connexion);
					profesionempleaLogic.setProfesionEmpleas(empleado.getProfesionEmpleas());
					ArrayList<Classe> classesLocal=ProfesionEmpleaConstantesFunciones.getClassesForeignKeysOfProfesionEmplea(new ArrayList<Classe>(),DeepLoadType.NONE);
					profesionempleaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(profesionempleaLogic.getProfesionEmpleas());
					empleado.setProfesionEmpleas(profesionempleaLogic.getProfesionEmpleas());
				}

				continue;
			}

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setRubroEmpleados(empleadoDataAccess.getRubroEmpleados(connexion,empleado));

				if(this.isConDeep) {
					RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(this.connexion);
					rubroempleadoLogic.setRubroEmpleados(empleado.getRubroEmpleados());
					ArrayList<Classe> classesLocal=RubroEmpleadoConstantesFunciones.getClassesForeignKeysOfRubroEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					rubroempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(rubroempleadoLogic.getRubroEmpleados());
					empleado.setRubroEmpleados(rubroempleadoLogic.getRubroEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoConstantes(empleadoDataAccess.getEmpleadoConstantes(connexion,empleado));

				if(this.isConDeep) {
					EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(this.connexion);
					empleadoconstanteLogic.setEmpleadoConstantes(empleado.getEmpleadoConstantes());
					ArrayList<Classe> classesLocal=EmpleadoConstanteConstantesFunciones.getClassesForeignKeysOfEmpleadoConstante(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoconstanteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(empleadoconstanteLogic.getEmpleadoConstantes());
					empleado.setEmpleadoConstantes(empleadoconstanteLogic.getEmpleadoConstantes());
				}

				continue;
			}

			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setTallaVestidos(empleadoDataAccess.getTallaVestidos(connexion,empleado));

				if(this.isConDeep) {
					TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(this.connexion);
					tallavestidoLogic.setTallaVestidos(empleado.getTallaVestidos());
					ArrayList<Classe> classesLocal=TallaVestidoConstantesFunciones.getClassesForeignKeysOfTallaVestido(new ArrayList<Classe>(),DeepLoadType.NONE);
					tallavestidoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(tallavestidoLogic.getTallaVestidos());
					empleado.setTallaVestidos(tallavestidoLogic.getTallaVestidos());
				}

				continue;
			}

			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setNovedadNomis(empleadoDataAccess.getNovedadNomis(connexion,empleado));

				if(this.isConDeep) {
					NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(this.connexion);
					novedadnomiLogic.setNovedadNomis(empleado.getNovedadNomis());
					ArrayList<Classe> classesLocal=NovedadNomiConstantesFunciones.getClassesForeignKeysOfNovedadNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					novedadnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NovedadNomiConstantesFunciones.refrescarForeignKeysDescripcionesNovedadNomi(novedadnomiLogic.getNovedadNomis());
					empleado.setNovedadNomis(novedadnomiLogic.getNovedadNomis());
				}

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
			empleado.setEmpresa(empleadoDataAccess.getEmpresa(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setSucursal(empleadoDataAccess.getSucursal(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setPais(empleadoDataAccess.getPais(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setProvincia(empleadoDataAccess.getProvincia(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setCiudad(empleadoDataAccess.getCiudad(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setCentroCosto(empleadoDataAccess.getCentroCosto(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Religion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setReligion(empleadoDataAccess.getReligion(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setEstadoCivil(empleadoDataAccess.getEstadoCivil(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoGenero(empleadoDataAccess.getTipoGenero(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoEmpleado(empleadoDataAccess.getTipoEmpleado(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoInstruccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoInstruccion(empleadoDataAccess.getTipoInstruccion(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setCargo(empleadoDataAccess.getCargo(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setEstructura(empleadoDataAccess.getEstructura(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setEstructuraSeccion(empleadoDataAccess.getEstructuraSeccion(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setEstadoEmpleado(empleadoDataAccess.getEstadoEmpleado(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoContrato(empleadoDataAccess.getTipoContrato(connexion,empleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoCuentaBancoGlobal(empleadoDataAccess.getTipoCuentaBancoGlobal(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar_NM.class));
			empleado.setCargaFamiliar_NMs(empleadoDataAccess.getCargaFamiliar_NMs(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Curso.class));
			empleado.setCursos(empleadoDataAccess.getCursos(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Prestamo.class));
			empleado.setPrestamos(empleadoDataAccess.getPrestamos(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoIdioma.class));
			empleado.setEmpleadoIdiomas(empleadoDataAccess.getEmpleadoIdiomas(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialPagoMesNomi.class));
			empleado.setHistorialPagoMesNomis(empleadoDataAccess.getHistorialPagoMesNomis(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoImpuestoRenta.class));
			empleado.setEmpleadoImpuestoRentas(empleadoDataAccess.getEmpleadoImpuestoRentas(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			empleado.setDatoGeneralEmpleado(empleadoDataAccess.getDatoGeneralEmpleado(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Area.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Area.class));
			empleado.setAreas(empleadoDataAccess.getAreas(connexion,empleado));
		}

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
			empleado.setGastoEmpleados(empleadoDataAccess.getGastoEmpleados(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoHobby.class));
			empleado.setEmpleadoHobbys(empleadoDataAccess.getEmpleadoHobbys(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEMail.class));
			empleado.setEmpleadoEMails(empleadoDataAccess.getEmpleadoEMails(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RasgoPersonal.class));
			empleado.setRasgoPersonals(empleadoDataAccess.getRasgoPersonals(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Referencia.class));
			empleado.setReferencias(empleadoDataAccess.getReferencias(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Telefono_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Telefono_NM.class));
			empleado.setTelefono_NMs(empleadoDataAccess.getTelefono_NMs(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Novedad.class));
			empleado.setNovedads(empleadoDataAccess.getNovedads(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoHerra.class));
			empleado.setEmpleadoHerras(empleadoDataAccess.getEmpleadoHerras(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEnfer.class));
			empleado.setEmpleadoEnfers(empleadoDataAccess.getEmpleadoEnfers(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Visa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Visa.class));
			empleado.setVisas(empleadoDataAccess.getVisas(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Seguro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Seguro.class));
			empleado.setSeguros(empleadoDataAccess.getSeguros(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AsistenciaMensual.class));
			empleado.setAsistenciaMensuals(empleadoDataAccess.getAsistenciaMensuals(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoDisca.class));
			empleado.setEmpleadoDiscas(empleadoDataAccess.getEmpleadoDiscas(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProfesionEmplea.class));
			empleado.setProfesionEmpleas(empleadoDataAccess.getProfesionEmpleas(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleado.class));
			empleado.setRubroEmpleados(empleadoDataAccess.getRubroEmpleados(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoConstante.class));
			empleado.setEmpleadoConstantes(empleadoDataAccess.getEmpleadoConstantes(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TallaVestido.class));
			empleado.setTallaVestidos(empleadoDataAccess.getTallaVestidos(connexion,empleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NovedadNomi.class));
			empleado.setNovedadNomis(empleadoDataAccess.getNovedadNomis(connexion,empleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleado.setEmpresa(empleadoDataAccess.getEmpresa(connexion,empleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleado.setSucursal(empleadoDataAccess.getSucursal(connexion,empleado));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(empleado.getSucursal(),isDeep,deepLoadType,clases);
				
		empleado.setPais(empleadoDataAccess.getPais(connexion,empleado));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(empleado.getPais(),isDeep,deepLoadType,clases);
				
		empleado.setProvincia(empleadoDataAccess.getProvincia(connexion,empleado));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(empleado.getProvincia(),isDeep,deepLoadType,clases);
				
		empleado.setCiudad(empleadoDataAccess.getCiudad(connexion,empleado));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(empleado.getCiudad(),isDeep,deepLoadType,clases);
				
		empleado.setCentroCosto(empleadoDataAccess.getCentroCosto(connexion,empleado));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(empleado.getCentroCosto(),isDeep,deepLoadType,clases);
				
		empleado.setReligion(empleadoDataAccess.getReligion(connexion,empleado));
		ReligionLogic religionLogic= new ReligionLogic(connexion);
		religionLogic.deepLoad(empleado.getReligion(),isDeep,deepLoadType,clases);
				
		empleado.setEstadoCivil(empleadoDataAccess.getEstadoCivil(connexion,empleado));
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(empleado.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		empleado.setTipoGenero(empleadoDataAccess.getTipoGenero(connexion,empleado));
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(empleado.getTipoGenero(),isDeep,deepLoadType,clases);
				
		empleado.setTipoEmpleado(empleadoDataAccess.getTipoEmpleado(connexion,empleado));
		TipoEmpleadoLogic tipoempleadoLogic= new TipoEmpleadoLogic(connexion);
		tipoempleadoLogic.deepLoad(empleado.getTipoEmpleado(),isDeep,deepLoadType,clases);
				
		empleado.setTipoInstruccion(empleadoDataAccess.getTipoInstruccion(connexion,empleado));
		TipoInstruccionLogic tipoinstruccionLogic= new TipoInstruccionLogic(connexion);
		tipoinstruccionLogic.deepLoad(empleado.getTipoInstruccion(),isDeep,deepLoadType,clases);
				
		empleado.setCargo(empleadoDataAccess.getCargo(connexion,empleado));
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(empleado.getCargo(),isDeep,deepLoadType,clases);
				
		empleado.setEstructura(empleadoDataAccess.getEstructura(connexion,empleado));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleado.getEstructura(),isDeep,deepLoadType,clases);
				
		empleado.setEstructuraSeccion(empleadoDataAccess.getEstructuraSeccion(connexion,empleado));
		EstructuraLogic estructuraseccionLogic= new EstructuraLogic(connexion);
		estructuraseccionLogic.deepLoad(empleado.getEstructuraSeccion(),isDeep,deepLoadType,clases);
				
		empleado.setEstadoEmpleado(empleadoDataAccess.getEstadoEmpleado(connexion,empleado));
		EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
		estadoempleadoLogic.deepLoad(empleado.getEstadoEmpleado(),isDeep,deepLoadType,clases);
				
		empleado.setTipoContrato(empleadoDataAccess.getTipoContrato(connexion,empleado));
		TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
		tipocontratoLogic.deepLoad(empleado.getTipoContrato(),isDeep,deepLoadType,clases);
				
		empleado.setTipoCuentaBancoGlobal(empleadoDataAccess.getTipoCuentaBancoGlobal(connexion,empleado));
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(empleado.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				

		empleado.setCargaFamiliar_NMs(empleadoDataAccess.getCargaFamiliar_NMs(connexion,empleado));

		for(CargaFamiliar_NM cargafamiliar_nm:empleado.getCargaFamiliar_NMs()) {
			CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
			cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
		}

		empleado.setCursos(empleadoDataAccess.getCursos(connexion,empleado));

		for(Curso curso:empleado.getCursos()) {
			CursoLogic cursoLogic= new CursoLogic(connexion);
			cursoLogic.deepLoad(curso,isDeep,deepLoadType,clases);
		}

		empleado.setPrestamos(empleadoDataAccess.getPrestamos(connexion,empleado));

		for(Prestamo prestamo:empleado.getPrestamos()) {
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
		}

		empleado.setEmpleadoIdiomas(empleadoDataAccess.getEmpleadoIdiomas(connexion,empleado));

		for(EmpleadoIdioma empleadoidioma:empleado.getEmpleadoIdiomas()) {
			EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
			empleadoidiomaLogic.deepLoad(empleadoidioma,isDeep,deepLoadType,clases);
		}

		empleado.setHistorialPagoMesNomis(empleadoDataAccess.getHistorialPagoMesNomis(connexion,empleado));

		for(HistorialPagoMesNomi historialpagomesnomi:empleado.getHistorialPagoMesNomis()) {
			HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
			historialpagomesnomiLogic.deepLoad(historialpagomesnomi,isDeep,deepLoadType,clases);
		}

		empleado.setEmpleadoImpuestoRentas(empleadoDataAccess.getEmpleadoImpuestoRentas(connexion,empleado));

		for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleado.getEmpleadoImpuestoRentas()) {
			EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
			empleadoimpuestorentaLogic.deepLoad(empleadoimpuestorenta,isDeep,deepLoadType,clases);
		}
					empleado.setDatoGeneralEmpleado(empleadoDataAccess.getDatoGeneralEmpleado(connexion,empleado));

						DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);

					datogeneralempleadoLogic.deepLoad(empleado.getDatoGeneralEmpleado(),isDeep,deepLoadType,clases);

		empleado.setAreas(empleadoDataAccess.getAreas(connexion,empleado));

		for(Area area:empleado.getAreas()) {
			AreaLogic areaLogic= new AreaLogic(connexion);
			areaLogic.deepLoad(area,isDeep,deepLoadType,clases);
		}

		empleado.setGastoEmpleados(empleadoDataAccess.getGastoEmpleados(connexion,empleado));

		for(GastoEmpleado gastoempleado:empleado.getGastoEmpleados()) {
			GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
			gastoempleadoLogic.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
		}

		empleado.setEmpleadoHobbys(empleadoDataAccess.getEmpleadoHobbys(connexion,empleado));

		for(EmpleadoHobby empleadohobby:empleado.getEmpleadoHobbys()) {
			EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
			empleadohobbyLogic.deepLoad(empleadohobby,isDeep,deepLoadType,clases);
		}

		empleado.setEmpleadoEMails(empleadoDataAccess.getEmpleadoEMails(connexion,empleado));

		for(EmpleadoEMail empleadoemail:empleado.getEmpleadoEMails()) {
			EmpleadoEMailLogic empleadoemailLogic= new EmpleadoEMailLogic(connexion);
			empleadoemailLogic.deepLoad(empleadoemail,isDeep,deepLoadType,clases);
		}

		empleado.setRasgoPersonals(empleadoDataAccess.getRasgoPersonals(connexion,empleado));

		for(RasgoPersonal rasgopersonal:empleado.getRasgoPersonals()) {
			RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
			rasgopersonalLogic.deepLoad(rasgopersonal,isDeep,deepLoadType,clases);
		}

		empleado.setReferencias(empleadoDataAccess.getReferencias(connexion,empleado));

		for(Referencia referencia:empleado.getReferencias()) {
			ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
			referenciaLogic.deepLoad(referencia,isDeep,deepLoadType,clases);
		}

		empleado.setTelefono_NMs(empleadoDataAccess.getTelefono_NMs(connexion,empleado));

		for(Telefono_NM telefono_nm:empleado.getTelefono_NMs()) {
			Telefono_NMLogic telefono_nmLogic= new Telefono_NMLogic(connexion);
			telefono_nmLogic.deepLoad(telefono_nm,isDeep,deepLoadType,clases);
		}

		empleado.setNovedads(empleadoDataAccess.getNovedads(connexion,empleado));

		for(Novedad novedad:empleado.getNovedads()) {
			NovedadLogic novedadLogic= new NovedadLogic(connexion);
			novedadLogic.deepLoad(novedad,isDeep,deepLoadType,clases);
		}

		empleado.setEmpleadoHerras(empleadoDataAccess.getEmpleadoHerras(connexion,empleado));

		for(EmpleadoHerra empleadoherra:empleado.getEmpleadoHerras()) {
			EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
			empleadoherraLogic.deepLoad(empleadoherra,isDeep,deepLoadType,clases);
		}

		empleado.setEmpleadoEnfers(empleadoDataAccess.getEmpleadoEnfers(connexion,empleado));

		for(EmpleadoEnfer empleadoenfer:empleado.getEmpleadoEnfers()) {
			EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
			empleadoenferLogic.deepLoad(empleadoenfer,isDeep,deepLoadType,clases);
		}

		empleado.setVisas(empleadoDataAccess.getVisas(connexion,empleado));

		for(Visa visa:empleado.getVisas()) {
			VisaLogic visaLogic= new VisaLogic(connexion);
			visaLogic.deepLoad(visa,isDeep,deepLoadType,clases);
		}

		empleado.setSeguros(empleadoDataAccess.getSeguros(connexion,empleado));

		for(Seguro seguro:empleado.getSeguros()) {
			SeguroLogic seguroLogic= new SeguroLogic(connexion);
			seguroLogic.deepLoad(seguro,isDeep,deepLoadType,clases);
		}

		empleado.setAsistenciaMensuals(empleadoDataAccess.getAsistenciaMensuals(connexion,empleado));

		for(AsistenciaMensual asistenciamensual:empleado.getAsistenciaMensuals()) {
			AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
			asistenciamensualLogic.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
		}

		empleado.setEmpleadoDiscas(empleadoDataAccess.getEmpleadoDiscas(connexion,empleado));

		for(EmpleadoDisca empleadodisca:empleado.getEmpleadoDiscas()) {
			EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(connexion);
			empleadodiscaLogic.deepLoad(empleadodisca,isDeep,deepLoadType,clases);
		}

		empleado.setProfesionEmpleas(empleadoDataAccess.getProfesionEmpleas(connexion,empleado));

		for(ProfesionEmplea profesionemplea:empleado.getProfesionEmpleas()) {
			ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
			profesionempleaLogic.deepLoad(profesionemplea,isDeep,deepLoadType,clases);
		}

		empleado.setRubroEmpleados(empleadoDataAccess.getRubroEmpleados(connexion,empleado));

		for(RubroEmpleado rubroempleado:empleado.getRubroEmpleados()) {
			RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
			rubroempleadoLogic.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
		}

		empleado.setEmpleadoConstantes(empleadoDataAccess.getEmpleadoConstantes(connexion,empleado));

		for(EmpleadoConstante empleadoconstante:empleado.getEmpleadoConstantes()) {
			EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(connexion);
			empleadoconstanteLogic.deepLoad(empleadoconstante,isDeep,deepLoadType,clases);
		}

		empleado.setTallaVestidos(empleadoDataAccess.getTallaVestidos(connexion,empleado));

		for(TallaVestido tallavestido:empleado.getTallaVestidos()) {
			TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
			tallavestidoLogic.deepLoad(tallavestido,isDeep,deepLoadType,clases);
		}

		empleado.setNovedadNomis(empleadoDataAccess.getNovedadNomis(connexion,empleado));

		for(NovedadNomi novedadnomi:empleado.getNovedadNomis()) {
			NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
			novedadnomiLogic.deepLoad(novedadnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleado.setEmpresa(empleadoDataAccess.getEmpresa(connexion,empleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				empleado.setSucursal(empleadoDataAccess.getSucursal(connexion,empleado));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(empleado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				empleado.setPais(empleadoDataAccess.getPais(connexion,empleado));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(empleado.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				empleado.setProvincia(empleadoDataAccess.getProvincia(connexion,empleado));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(empleado.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				empleado.setCiudad(empleadoDataAccess.getCiudad(connexion,empleado));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(empleado.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				empleado.setCentroCosto(empleadoDataAccess.getCentroCosto(connexion,empleado));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(empleado.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Religion.class)) {
				empleado.setReligion(empleadoDataAccess.getReligion(connexion,empleado));
				ReligionLogic religionLogic= new ReligionLogic(connexion);
				religionLogic.deepLoad(empleado.getReligion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				empleado.setEstadoCivil(empleadoDataAccess.getEstadoCivil(connexion,empleado));
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepLoad(empleado.getEstadoCivil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				empleado.setTipoGenero(empleadoDataAccess.getTipoGenero(connexion,empleado));
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepLoad(empleado.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEmpleado.class)) {
				empleado.setTipoEmpleado(empleadoDataAccess.getTipoEmpleado(connexion,empleado));
				TipoEmpleadoLogic tipoempleadoLogic= new TipoEmpleadoLogic(connexion);
				tipoempleadoLogic.deepLoad(empleado.getTipoEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoInstruccion.class)) {
				empleado.setTipoInstruccion(empleadoDataAccess.getTipoInstruccion(connexion,empleado));
				TipoInstruccionLogic tipoinstruccionLogic= new TipoInstruccionLogic(connexion);
				tipoinstruccionLogic.deepLoad(empleado.getTipoInstruccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				empleado.setCargo(empleadoDataAccess.getCargo(connexion,empleado));
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepLoad(empleado.getCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleado.setEstructura(empleadoDataAccess.getEstructura(connexion,empleado));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(empleado.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleado.setEstructuraSeccion(empleadoDataAccess.getEstructuraSeccion(connexion,empleado));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(empleado.getEstructuraSeccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoEmpleado.class)) {
				empleado.setEstadoEmpleado(empleadoDataAccess.getEstadoEmpleado(connexion,empleado));
				EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
				estadoempleadoLogic.deepLoad(empleado.getEstadoEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoContrato.class)) {
				empleado.setTipoContrato(empleadoDataAccess.getTipoContrato(connexion,empleado));
				TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
				tipocontratoLogic.deepLoad(empleado.getTipoContrato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				empleado.setTipoCuentaBancoGlobal(empleadoDataAccess.getTipoCuentaBancoGlobal(connexion,empleado));
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepLoad(empleado.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setCargaFamiliar_NMs(empleadoDataAccess.getCargaFamiliar_NMs(connexion,empleado));

				for(CargaFamiliar_NM cargafamiliar_nm:empleado.getCargaFamiliar_NMs()) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
					cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setCursos(empleadoDataAccess.getCursos(connexion,empleado));

				for(Curso curso:empleado.getCursos()) {
					CursoLogic cursoLogic= new CursoLogic(connexion);
					cursoLogic.deepLoad(curso,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setPrestamos(empleadoDataAccess.getPrestamos(connexion,empleado));

				for(Prestamo prestamo:empleado.getPrestamos()) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
					prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoIdiomas(empleadoDataAccess.getEmpleadoIdiomas(connexion,empleado));

				for(EmpleadoIdioma empleadoidioma:empleado.getEmpleadoIdiomas()) {
					EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
					empleadoidiomaLogic.deepLoad(empleadoidioma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setHistorialPagoMesNomis(empleadoDataAccess.getHistorialPagoMesNomis(connexion,empleado));

				for(HistorialPagoMesNomi historialpagomesnomi:empleado.getHistorialPagoMesNomis()) {
					HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
					historialpagomesnomiLogic.deepLoad(historialpagomesnomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoImpuestoRentas(empleadoDataAccess.getEmpleadoImpuestoRentas(connexion,empleado));

				for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleado.getEmpleadoImpuestoRentas()) {
					EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
					empleadoimpuestorentaLogic.deepLoad(empleadoimpuestorenta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setDatoGeneralEmpleado(empleadoDataAccess.getDatoGeneralEmpleado(connexion,empleado));

				DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);

				datogeneralempleadoLogic.deepLoad(empleado.getDatoGeneralEmpleado(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(Area.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setAreas(empleadoDataAccess.getAreas(connexion,empleado));

				for(Area area:empleado.getAreas()) {
					AreaLogic areaLogic= new AreaLogic(connexion);
					areaLogic.deepLoad(area,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setGastoEmpleados(empleadoDataAccess.getGastoEmpleados(connexion,empleado));

				for(GastoEmpleado gastoempleado:empleado.getGastoEmpleados()) {
					GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
					gastoempleadoLogic.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoHobbys(empleadoDataAccess.getEmpleadoHobbys(connexion,empleado));

				for(EmpleadoHobby empleadohobby:empleado.getEmpleadoHobbys()) {
					EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
					empleadohobbyLogic.deepLoad(empleadohobby,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoEMails(empleadoDataAccess.getEmpleadoEMails(connexion,empleado));

				for(EmpleadoEMail empleadoemail:empleado.getEmpleadoEMails()) {
					EmpleadoEMailLogic empleadoemailLogic= new EmpleadoEMailLogic(connexion);
					empleadoemailLogic.deepLoad(empleadoemail,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setRasgoPersonals(empleadoDataAccess.getRasgoPersonals(connexion,empleado));

				for(RasgoPersonal rasgopersonal:empleado.getRasgoPersonals()) {
					RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
					rasgopersonalLogic.deepLoad(rasgopersonal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setReferencias(empleadoDataAccess.getReferencias(connexion,empleado));

				for(Referencia referencia:empleado.getReferencias()) {
					ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
					referenciaLogic.deepLoad(referencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Telefono_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setTelefono_NMs(empleadoDataAccess.getTelefono_NMs(connexion,empleado));

				for(Telefono_NM telefono_nm:empleado.getTelefono_NMs()) {
					Telefono_NMLogic telefono_nmLogic= new Telefono_NMLogic(connexion);
					telefono_nmLogic.deepLoad(telefono_nm,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setNovedads(empleadoDataAccess.getNovedads(connexion,empleado));

				for(Novedad novedad:empleado.getNovedads()) {
					NovedadLogic novedadLogic= new NovedadLogic(connexion);
					novedadLogic.deepLoad(novedad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoHerras(empleadoDataAccess.getEmpleadoHerras(connexion,empleado));

				for(EmpleadoHerra empleadoherra:empleado.getEmpleadoHerras()) {
					EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
					empleadoherraLogic.deepLoad(empleadoherra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoEnfers(empleadoDataAccess.getEmpleadoEnfers(connexion,empleado));

				for(EmpleadoEnfer empleadoenfer:empleado.getEmpleadoEnfers()) {
					EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
					empleadoenferLogic.deepLoad(empleadoenfer,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Visa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setVisas(empleadoDataAccess.getVisas(connexion,empleado));

				for(Visa visa:empleado.getVisas()) {
					VisaLogic visaLogic= new VisaLogic(connexion);
					visaLogic.deepLoad(visa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Seguro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setSeguros(empleadoDataAccess.getSeguros(connexion,empleado));

				for(Seguro seguro:empleado.getSeguros()) {
					SeguroLogic seguroLogic= new SeguroLogic(connexion);
					seguroLogic.deepLoad(seguro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setAsistenciaMensuals(empleadoDataAccess.getAsistenciaMensuals(connexion,empleado));

				for(AsistenciaMensual asistenciamensual:empleado.getAsistenciaMensuals()) {
					AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
					asistenciamensualLogic.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoDiscas(empleadoDataAccess.getEmpleadoDiscas(connexion,empleado));

				for(EmpleadoDisca empleadodisca:empleado.getEmpleadoDiscas()) {
					EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(connexion);
					empleadodiscaLogic.deepLoad(empleadodisca,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setProfesionEmpleas(empleadoDataAccess.getProfesionEmpleas(connexion,empleado));

				for(ProfesionEmplea profesionemplea:empleado.getProfesionEmpleas()) {
					ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
					profesionempleaLogic.deepLoad(profesionemplea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setRubroEmpleados(empleadoDataAccess.getRubroEmpleados(connexion,empleado));

				for(RubroEmpleado rubroempleado:empleado.getRubroEmpleados()) {
					RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
					rubroempleadoLogic.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setEmpleadoConstantes(empleadoDataAccess.getEmpleadoConstantes(connexion,empleado));

				for(EmpleadoConstante empleadoconstante:empleado.getEmpleadoConstantes()) {
					EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(connexion);
					empleadoconstanteLogic.deepLoad(empleadoconstante,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setTallaVestidos(empleadoDataAccess.getTallaVestidos(connexion,empleado));

				for(TallaVestido tallavestido:empleado.getTallaVestidos()) {
					TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
					tallavestidoLogic.deepLoad(tallavestido,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empleado.setNovedadNomis(empleadoDataAccess.getNovedadNomis(connexion,empleado));

				for(NovedadNomi novedadnomi:empleado.getNovedadNomis()) {
					NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
					novedadnomiLogic.deepLoad(novedadnomi,isDeep,deepLoadType,clases);
				}
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
			empleado.setEmpresa(empleadoDataAccess.getEmpresa(connexion,empleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setSucursal(empleadoDataAccess.getSucursal(connexion,empleado));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(empleado.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setPais(empleadoDataAccess.getPais(connexion,empleado));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(empleado.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setProvincia(empleadoDataAccess.getProvincia(connexion,empleado));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(empleado.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setCiudad(empleadoDataAccess.getCiudad(connexion,empleado));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(empleado.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setCentroCosto(empleadoDataAccess.getCentroCosto(connexion,empleado));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(empleado.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Religion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setReligion(empleadoDataAccess.getReligion(connexion,empleado));
			ReligionLogic religionLogic= new ReligionLogic(connexion);
			religionLogic.deepLoad(empleado.getReligion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setEstadoCivil(empleadoDataAccess.getEstadoCivil(connexion,empleado));
			EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
			estadocivilLogic.deepLoad(empleado.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoGenero(empleadoDataAccess.getTipoGenero(connexion,empleado));
			TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
			tipogeneroLogic.deepLoad(empleado.getTipoGenero(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoEmpleado(empleadoDataAccess.getTipoEmpleado(connexion,empleado));
			TipoEmpleadoLogic tipoempleadoLogic= new TipoEmpleadoLogic(connexion);
			tipoempleadoLogic.deepLoad(empleado.getTipoEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoInstruccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoInstruccion(empleadoDataAccess.getTipoInstruccion(connexion,empleado));
			TipoInstruccionLogic tipoinstruccionLogic= new TipoInstruccionLogic(connexion);
			tipoinstruccionLogic.deepLoad(empleado.getTipoInstruccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setCargo(empleadoDataAccess.getCargo(connexion,empleado));
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargoLogic.deepLoad(empleado.getCargo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setEstructura(empleadoDataAccess.getEstructura(connexion,empleado));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(empleado.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setEstructuraSeccion(empleadoDataAccess.getEstructuraSeccion(connexion,empleado));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(empleado.getEstructuraSeccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setEstadoEmpleado(empleadoDataAccess.getEstadoEmpleado(connexion,empleado));
			EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
			estadoempleadoLogic.deepLoad(empleado.getEstadoEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoContrato(empleadoDataAccess.getTipoContrato(connexion,empleado));
			TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
			tipocontratoLogic.deepLoad(empleado.getTipoContrato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleado.setTipoCuentaBancoGlobal(empleadoDataAccess.getTipoCuentaBancoGlobal(connexion,empleado));
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
			tipocuentabancoglobalLogic.deepLoad(empleado.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar_NM.class));
			empleado.setCargaFamiliar_NMs(empleadoDataAccess.getCargaFamiliar_NMs(connexion,empleado));

			for(CargaFamiliar_NM cargafamiliar_nm:empleado.getCargaFamiliar_NMs()) {
				CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
				cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Curso.class));
			empleado.setCursos(empleadoDataAccess.getCursos(connexion,empleado));

			for(Curso curso:empleado.getCursos()) {
				CursoLogic cursoLogic= new CursoLogic(connexion);
				cursoLogic.deepLoad(curso,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Prestamo.class));
			empleado.setPrestamos(empleadoDataAccess.getPrestamos(connexion,empleado));

			for(Prestamo prestamo:empleado.getPrestamos()) {
				PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
				prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoIdioma.class));
			empleado.setEmpleadoIdiomas(empleadoDataAccess.getEmpleadoIdiomas(connexion,empleado));

			for(EmpleadoIdioma empleadoidioma:empleado.getEmpleadoIdiomas()) {
				EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
				empleadoidiomaLogic.deepLoad(empleadoidioma,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialPagoMesNomi.class));
			empleado.setHistorialPagoMesNomis(empleadoDataAccess.getHistorialPagoMesNomis(connexion,empleado));

			for(HistorialPagoMesNomi historialpagomesnomi:empleado.getHistorialPagoMesNomis()) {
				HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
				historialpagomesnomiLogic.deepLoad(historialpagomesnomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoImpuestoRenta.class));
			empleado.setEmpleadoImpuestoRentas(empleadoDataAccess.getEmpleadoImpuestoRentas(connexion,empleado));

			for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleado.getEmpleadoImpuestoRentas()) {
				EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
				empleadoimpuestorentaLogic.deepLoad(empleadoimpuestorenta,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
				clases.add(new Classe(DatoGeneralEmpleado.class));
				empleado.setDatoGeneralEmpleado(empleadoDataAccess.getDatoGeneralEmpleado(connexion,empleado));

					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);

				datogeneralempleadoLogic.deepLoad(empleado.getDatoGeneralEmpleado(),isDeep,deepLoadType,clases);
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Area.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Area.class));
			empleado.setAreas(empleadoDataAccess.getAreas(connexion,empleado));

			for(Area area:empleado.getAreas()) {
				AreaLogic areaLogic= new AreaLogic(connexion);
				areaLogic.deepLoad(area,isDeep,deepLoadType,clases);
			}
		}

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
			empleado.setGastoEmpleados(empleadoDataAccess.getGastoEmpleados(connexion,empleado));

			for(GastoEmpleado gastoempleado:empleado.getGastoEmpleados()) {
				GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
				gastoempleadoLogic.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoHobby.class));
			empleado.setEmpleadoHobbys(empleadoDataAccess.getEmpleadoHobbys(connexion,empleado));

			for(EmpleadoHobby empleadohobby:empleado.getEmpleadoHobbys()) {
				EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
				empleadohobbyLogic.deepLoad(empleadohobby,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEMail.class));
			empleado.setEmpleadoEMails(empleadoDataAccess.getEmpleadoEMails(connexion,empleado));

			for(EmpleadoEMail empleadoemail:empleado.getEmpleadoEMails()) {
				EmpleadoEMailLogic empleadoemailLogic= new EmpleadoEMailLogic(connexion);
				empleadoemailLogic.deepLoad(empleadoemail,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RasgoPersonal.class));
			empleado.setRasgoPersonals(empleadoDataAccess.getRasgoPersonals(connexion,empleado));

			for(RasgoPersonal rasgopersonal:empleado.getRasgoPersonals()) {
				RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
				rasgopersonalLogic.deepLoad(rasgopersonal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Referencia.class));
			empleado.setReferencias(empleadoDataAccess.getReferencias(connexion,empleado));

			for(Referencia referencia:empleado.getReferencias()) {
				ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
				referenciaLogic.deepLoad(referencia,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Telefono_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Telefono_NM.class));
			empleado.setTelefono_NMs(empleadoDataAccess.getTelefono_NMs(connexion,empleado));

			for(Telefono_NM telefono_nm:empleado.getTelefono_NMs()) {
				Telefono_NMLogic telefono_nmLogic= new Telefono_NMLogic(connexion);
				telefono_nmLogic.deepLoad(telefono_nm,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Novedad.class));
			empleado.setNovedads(empleadoDataAccess.getNovedads(connexion,empleado));

			for(Novedad novedad:empleado.getNovedads()) {
				NovedadLogic novedadLogic= new NovedadLogic(connexion);
				novedadLogic.deepLoad(novedad,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoHerra.class));
			empleado.setEmpleadoHerras(empleadoDataAccess.getEmpleadoHerras(connexion,empleado));

			for(EmpleadoHerra empleadoherra:empleado.getEmpleadoHerras()) {
				EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
				empleadoherraLogic.deepLoad(empleadoherra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEnfer.class));
			empleado.setEmpleadoEnfers(empleadoDataAccess.getEmpleadoEnfers(connexion,empleado));

			for(EmpleadoEnfer empleadoenfer:empleado.getEmpleadoEnfers()) {
				EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
				empleadoenferLogic.deepLoad(empleadoenfer,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Visa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Visa.class));
			empleado.setVisas(empleadoDataAccess.getVisas(connexion,empleado));

			for(Visa visa:empleado.getVisas()) {
				VisaLogic visaLogic= new VisaLogic(connexion);
				visaLogic.deepLoad(visa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Seguro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Seguro.class));
			empleado.setSeguros(empleadoDataAccess.getSeguros(connexion,empleado));

			for(Seguro seguro:empleado.getSeguros()) {
				SeguroLogic seguroLogic= new SeguroLogic(connexion);
				seguroLogic.deepLoad(seguro,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AsistenciaMensual.class));
			empleado.setAsistenciaMensuals(empleadoDataAccess.getAsistenciaMensuals(connexion,empleado));

			for(AsistenciaMensual asistenciamensual:empleado.getAsistenciaMensuals()) {
				AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
				asistenciamensualLogic.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoDisca.class));
			empleado.setEmpleadoDiscas(empleadoDataAccess.getEmpleadoDiscas(connexion,empleado));

			for(EmpleadoDisca empleadodisca:empleado.getEmpleadoDiscas()) {
				EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(connexion);
				empleadodiscaLogic.deepLoad(empleadodisca,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProfesionEmplea.class));
			empleado.setProfesionEmpleas(empleadoDataAccess.getProfesionEmpleas(connexion,empleado));

			for(ProfesionEmplea profesionemplea:empleado.getProfesionEmpleas()) {
				ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
				profesionempleaLogic.deepLoad(profesionemplea,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleado.class));
			empleado.setRubroEmpleados(empleadoDataAccess.getRubroEmpleados(connexion,empleado));

			for(RubroEmpleado rubroempleado:empleado.getRubroEmpleados()) {
				RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
				rubroempleadoLogic.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoConstante.class));
			empleado.setEmpleadoConstantes(empleadoDataAccess.getEmpleadoConstantes(connexion,empleado));

			for(EmpleadoConstante empleadoconstante:empleado.getEmpleadoConstantes()) {
				EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(connexion);
				empleadoconstanteLogic.deepLoad(empleadoconstante,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TallaVestido.class));
			empleado.setTallaVestidos(empleadoDataAccess.getTallaVestidos(connexion,empleado));

			for(TallaVestido tallavestido:empleado.getTallaVestidos()) {
				TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
				tallavestidoLogic.deepLoad(tallavestido,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NovedadNomi.class));
			empleado.setNovedadNomis(empleadoDataAccess.getNovedadNomis(connexion,empleado));

			for(NovedadNomi novedadnomi:empleado.getNovedadNomis()) {
				NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
				novedadnomiLogic.deepLoad(novedadnomi,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Empleado empleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoLogicAdditional.updateEmpleadoToSave(empleado,this.arrDatoGeneral);
			
EmpleadoDataAccess.save(empleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleado.getEmpresa(),connexion);

		SucursalDataAccess.save(empleado.getSucursal(),connexion);

		PaisDataAccess.save(empleado.getPais(),connexion);

		ProvinciaDataAccess.save(empleado.getProvincia(),connexion);

		CiudadDataAccess.save(empleado.getCiudad(),connexion);

		CentroCostoDataAccess.save(empleado.getCentroCosto(),connexion);

		ReligionDataAccess.save(empleado.getReligion(),connexion);

		EstadoCivilDataAccess.save(empleado.getEstadoCivil(),connexion);

		TipoGeneroDataAccess.save(empleado.getTipoGenero(),connexion);

		TipoEmpleadoDataAccess.save(empleado.getTipoEmpleado(),connexion);

		TipoInstruccionDataAccess.save(empleado.getTipoInstruccion(),connexion);

		CargoDataAccess.save(empleado.getCargo(),connexion);

		EstructuraDataAccess.save(empleado.getEstructura(),connexion);

		EstructuraDataAccess.save(empleado.getEstructuraSeccion(),connexion);

		EstadoEmpleadoDataAccess.save(empleado.getEstadoEmpleado(),connexion);

		TipoContratoDataAccess.save(empleado.getTipoContrato(),connexion);

		TipoCuentaBancoGlobalDataAccess.save(empleado.getTipoCuentaBancoGlobal(),connexion);

		for(CargaFamiliar_NM cargafamiliar_nm:empleado.getCargaFamiliar_NMs()) {
			cargafamiliar_nm.setid_empleado(empleado.getId());
			CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
		}

		for(Curso curso:empleado.getCursos()) {
			curso.setid_empleado(empleado.getId());
			CursoDataAccess.save(curso,connexion);
		}

		for(Prestamo prestamo:empleado.getPrestamos()) {
			prestamo.setid_empleado(empleado.getId());
			PrestamoDataAccess.save(prestamo,connexion);
		}

		for(EmpleadoIdioma empleadoidioma:empleado.getEmpleadoIdiomas()) {
			empleadoidioma.setid_empleado(empleado.getId());
			EmpleadoIdiomaDataAccess.save(empleadoidioma,connexion);
		}

		for(HistorialPagoMesNomi historialpagomesnomi:empleado.getHistorialPagoMesNomis()) {
			historialpagomesnomi.setid_empleado(empleado.getId());
			HistorialPagoMesNomiDataAccess.save(historialpagomesnomi,connexion);
		}

		for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleado.getEmpleadoImpuestoRentas()) {
			empleadoimpuestorenta.setid_empleado(empleado.getId());
			EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorenta,connexion);
		}

			empleado.getDatoGeneralEmpleado().setId(empleado.getId());
		DatoGeneralEmpleadoDataAccess.save(empleado.getDatoGeneralEmpleado(),connexion);

		for(Area area:empleado.getAreas()) {
			area.setid_empleado(empleado.getId());
			AreaDataAccess.save(area,connexion);
		}

		for(GastoEmpleado gastoempleado:empleado.getGastoEmpleados()) {
			gastoempleado.setid_empleado(empleado.getId());
			GastoEmpleadoDataAccess.save(gastoempleado,connexion);
		}

		for(EmpleadoHobby empleadohobby:empleado.getEmpleadoHobbys()) {
			empleadohobby.setid_empleado(empleado.getId());
			EmpleadoHobbyDataAccess.save(empleadohobby,connexion);
		}

		for(EmpleadoEMail empleadoemail:empleado.getEmpleadoEMails()) {
			empleadoemail.setid_empleado(empleado.getId());
			EmpleadoEMailDataAccess.save(empleadoemail,connexion);
		}

		for(RasgoPersonal rasgopersonal:empleado.getRasgoPersonals()) {
			rasgopersonal.setid_empleado(empleado.getId());
			RasgoPersonalDataAccess.save(rasgopersonal,connexion);
		}

		for(Referencia referencia:empleado.getReferencias()) {
			referencia.setid_empleado(empleado.getId());
			ReferenciaDataAccess.save(referencia,connexion);
		}

		for(Telefono_NM telefono_nm:empleado.getTelefono_NMs()) {
			telefono_nm.setid_empleado(empleado.getId());
			Telefono_NMDataAccess.save(telefono_nm,connexion);
		}

		for(Novedad novedad:empleado.getNovedads()) {
			novedad.setid_empleado(empleado.getId());
			NovedadDataAccess.save(novedad,connexion);
		}

		for(EmpleadoHerra empleadoherra:empleado.getEmpleadoHerras()) {
			empleadoherra.setid_empleado(empleado.getId());
			EmpleadoHerraDataAccess.save(empleadoherra,connexion);
		}

		for(EmpleadoEnfer empleadoenfer:empleado.getEmpleadoEnfers()) {
			empleadoenfer.setid_empleado(empleado.getId());
			EmpleadoEnferDataAccess.save(empleadoenfer,connexion);
		}

		for(Visa visa:empleado.getVisas()) {
			visa.setid_empleado(empleado.getId());
			VisaDataAccess.save(visa,connexion);
		}

		for(Seguro seguro:empleado.getSeguros()) {
			seguro.setid_empleado(empleado.getId());
			SeguroDataAccess.save(seguro,connexion);
		}

		for(AsistenciaMensual asistenciamensual:empleado.getAsistenciaMensuals()) {
			asistenciamensual.setid_empleado(empleado.getId());
			AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
		}

		for(EmpleadoDisca empleadodisca:empleado.getEmpleadoDiscas()) {
			empleadodisca.setid_empleado(empleado.getId());
			EmpleadoDiscaDataAccess.save(empleadodisca,connexion);
		}

		for(ProfesionEmplea profesionemplea:empleado.getProfesionEmpleas()) {
			profesionemplea.setid_empleado(empleado.getId());
			ProfesionEmpleaDataAccess.save(profesionemplea,connexion);
		}

		for(RubroEmpleado rubroempleado:empleado.getRubroEmpleados()) {
			rubroempleado.setid_empleado(empleado.getId());
			RubroEmpleadoDataAccess.save(rubroempleado,connexion);
		}

		for(EmpleadoConstante empleadoconstante:empleado.getEmpleadoConstantes()) {
			empleadoconstante.setid_empleado(empleado.getId());
			EmpleadoConstanteDataAccess.save(empleadoconstante,connexion);
		}

		for(TallaVestido tallavestido:empleado.getTallaVestidos()) {
			tallavestido.setid_empleado(empleado.getId());
			TallaVestidoDataAccess.save(tallavestido,connexion);
		}

		for(NovedadNomi novedadnomi:empleado.getNovedadNomis()) {
			novedadnomi.setid_empleado(empleado.getId());
			NovedadNomiDataAccess.save(novedadnomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(empleado.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(empleado.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(empleado.getProvincia(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(empleado.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(empleado.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Religion.class)) {
				ReligionDataAccess.save(empleado.getReligion(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(empleado.getEstadoCivil(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(empleado.getTipoGenero(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoEmpleado.class)) {
				TipoEmpleadoDataAccess.save(empleado.getTipoEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoInstruccion.class)) {
				TipoInstruccionDataAccess.save(empleado.getTipoInstruccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				CargoDataAccess.save(empleado.getCargo(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleado.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleado.getEstructuraSeccion(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoEmpleado.class)) {
				EstadoEmpleadoDataAccess.save(empleado.getEstadoEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoContrato.class)) {
				TipoContratoDataAccess.save(empleado.getTipoContrato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				TipoCuentaBancoGlobalDataAccess.save(empleado.getTipoCuentaBancoGlobal(),connexion);
				continue;
			}


			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar_NM cargafamiliar_nm:empleado.getCargaFamiliar_NMs()) {
					cargafamiliar_nm.setid_empleado(empleado.getId());
					CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Curso curso:empleado.getCursos()) {
					curso.setid_empleado(empleado.getId());
					CursoDataAccess.save(curso,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Prestamo prestamo:empleado.getPrestamos()) {
					prestamo.setid_empleado(empleado.getId());
					PrestamoDataAccess.save(prestamo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoIdioma empleadoidioma:empleado.getEmpleadoIdiomas()) {
					empleadoidioma.setid_empleado(empleado.getId());
					EmpleadoIdiomaDataAccess.save(empleadoidioma,connexion);
				}
				continue;
			}

			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialPagoMesNomi historialpagomesnomi:empleado.getHistorialPagoMesNomis()) {
					historialpagomesnomi.setid_empleado(empleado.getId());
					HistorialPagoMesNomiDataAccess.save(historialpagomesnomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleado.getEmpleadoImpuestoRentas()) {
					empleadoimpuestorenta.setid_empleado(empleado.getId());
					EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorenta,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				empleado.getDatoGeneralEmpleado().setId(empleado.getId());
		DatoGeneralEmpleadoDataAccess.save(empleado.getDatoGeneralEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Area.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Area area:empleado.getAreas()) {
					area.setid_empleado(empleado.getId());
					AreaDataAccess.save(area,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoEmpleado gastoempleado:empleado.getGastoEmpleados()) {
					gastoempleado.setid_empleado(empleado.getId());
					GastoEmpleadoDataAccess.save(gastoempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoHobby empleadohobby:empleado.getEmpleadoHobbys()) {
					empleadohobby.setid_empleado(empleado.getId());
					EmpleadoHobbyDataAccess.save(empleadohobby,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEMail empleadoemail:empleado.getEmpleadoEMails()) {
					empleadoemail.setid_empleado(empleado.getId());
					EmpleadoEMailDataAccess.save(empleadoemail,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RasgoPersonal rasgopersonal:empleado.getRasgoPersonals()) {
					rasgopersonal.setid_empleado(empleado.getId());
					RasgoPersonalDataAccess.save(rasgopersonal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Referencia referencia:empleado.getReferencias()) {
					referencia.setid_empleado(empleado.getId());
					ReferenciaDataAccess.save(referencia,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Telefono_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Telefono_NM telefono_nm:empleado.getTelefono_NMs()) {
					telefono_nm.setid_empleado(empleado.getId());
					Telefono_NMDataAccess.save(telefono_nm,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Novedad novedad:empleado.getNovedads()) {
					novedad.setid_empleado(empleado.getId());
					NovedadDataAccess.save(novedad,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoHerra empleadoherra:empleado.getEmpleadoHerras()) {
					empleadoherra.setid_empleado(empleado.getId());
					EmpleadoHerraDataAccess.save(empleadoherra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEnfer empleadoenfer:empleado.getEmpleadoEnfers()) {
					empleadoenfer.setid_empleado(empleado.getId());
					EmpleadoEnferDataAccess.save(empleadoenfer,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Visa.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Visa visa:empleado.getVisas()) {
					visa.setid_empleado(empleado.getId());
					VisaDataAccess.save(visa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Seguro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Seguro seguro:empleado.getSeguros()) {
					seguro.setid_empleado(empleado.getId());
					SeguroDataAccess.save(seguro,connexion);
				}
				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AsistenciaMensual asistenciamensual:empleado.getAsistenciaMensuals()) {
					asistenciamensual.setid_empleado(empleado.getId());
					AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoDisca empleadodisca:empleado.getEmpleadoDiscas()) {
					empleadodisca.setid_empleado(empleado.getId());
					EmpleadoDiscaDataAccess.save(empleadodisca,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProfesionEmplea profesionemplea:empleado.getProfesionEmpleas()) {
					profesionemplea.setid_empleado(empleado.getId());
					ProfesionEmpleaDataAccess.save(profesionemplea,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleado rubroempleado:empleado.getRubroEmpleados()) {
					rubroempleado.setid_empleado(empleado.getId());
					RubroEmpleadoDataAccess.save(rubroempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoConstante empleadoconstante:empleado.getEmpleadoConstantes()) {
					empleadoconstante.setid_empleado(empleado.getId());
					EmpleadoConstanteDataAccess.save(empleadoconstante,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TallaVestido tallavestido:empleado.getTallaVestidos()) {
					tallavestido.setid_empleado(empleado.getId());
					TallaVestidoDataAccess.save(tallavestido,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadNomi novedadnomi:empleado.getNovedadNomis()) {
					novedadnomi.setid_empleado(empleado.getId());
					NovedadNomiDataAccess.save(novedadnomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(empleado.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(empleado.getSucursal(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(empleado.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(empleado.getPais(),isDeep,deepLoadType,clases);
				

		ProvinciaDataAccess.save(empleado.getProvincia(),connexion);
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(empleado.getProvincia(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(empleado.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(empleado.getCiudad(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(empleado.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(empleado.getCentroCosto(),isDeep,deepLoadType,clases);
				

		ReligionDataAccess.save(empleado.getReligion(),connexion);
		ReligionLogic religionLogic= new ReligionLogic(connexion);
		religionLogic.deepLoad(empleado.getReligion(),isDeep,deepLoadType,clases);
				

		EstadoCivilDataAccess.save(empleado.getEstadoCivil(),connexion);
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(empleado.getEstadoCivil(),isDeep,deepLoadType,clases);
				

		TipoGeneroDataAccess.save(empleado.getTipoGenero(),connexion);
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(empleado.getTipoGenero(),isDeep,deepLoadType,clases);
				

		TipoEmpleadoDataAccess.save(empleado.getTipoEmpleado(),connexion);
		TipoEmpleadoLogic tipoempleadoLogic= new TipoEmpleadoLogic(connexion);
		tipoempleadoLogic.deepLoad(empleado.getTipoEmpleado(),isDeep,deepLoadType,clases);
				

		TipoInstruccionDataAccess.save(empleado.getTipoInstruccion(),connexion);
		TipoInstruccionLogic tipoinstruccionLogic= new TipoInstruccionLogic(connexion);
		tipoinstruccionLogic.deepLoad(empleado.getTipoInstruccion(),isDeep,deepLoadType,clases);
				

		CargoDataAccess.save(empleado.getCargo(),connexion);
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(empleado.getCargo(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(empleado.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleado.getEstructura(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(empleado.getEstructuraSeccion(),connexion);
		EstructuraLogic estructuraseccionLogic= new EstructuraLogic(connexion);
		estructuraseccionLogic.deepLoad(empleado.getEstructuraSeccion(),isDeep,deepLoadType,clases);
				

		EstadoEmpleadoDataAccess.save(empleado.getEstadoEmpleado(),connexion);
		EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
		estadoempleadoLogic.deepLoad(empleado.getEstadoEmpleado(),isDeep,deepLoadType,clases);
				

		TipoContratoDataAccess.save(empleado.getTipoContrato(),connexion);
		TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
		tipocontratoLogic.deepLoad(empleado.getTipoContrato(),isDeep,deepLoadType,clases);
				

		TipoCuentaBancoGlobalDataAccess.save(empleado.getTipoCuentaBancoGlobal(),connexion);
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(empleado.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				

		for(CargaFamiliar_NM cargafamiliar_nm:empleado.getCargaFamiliar_NMs()) {
			CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
			cargafamiliar_nm.setid_empleado(empleado.getId());
			CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
			cargafamiliar_nmLogic.deepSave(cargafamiliar_nm,isDeep,deepLoadType,clases);
		}

		for(Curso curso:empleado.getCursos()) {
			CursoLogic cursoLogic= new CursoLogic(connexion);
			curso.setid_empleado(empleado.getId());
			CursoDataAccess.save(curso,connexion);
			cursoLogic.deepSave(curso,isDeep,deepLoadType,clases);
		}

		for(Prestamo prestamo:empleado.getPrestamos()) {
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamo.setid_empleado(empleado.getId());
			PrestamoDataAccess.save(prestamo,connexion);
			prestamoLogic.deepSave(prestamo,isDeep,deepLoadType,clases);
		}

		for(EmpleadoIdioma empleadoidioma:empleado.getEmpleadoIdiomas()) {
			EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
			empleadoidioma.setid_empleado(empleado.getId());
			EmpleadoIdiomaDataAccess.save(empleadoidioma,connexion);
			empleadoidiomaLogic.deepSave(empleadoidioma,isDeep,deepLoadType,clases);
		}

		for(HistorialPagoMesNomi historialpagomesnomi:empleado.getHistorialPagoMesNomis()) {
			HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
			historialpagomesnomi.setid_empleado(empleado.getId());
			HistorialPagoMesNomiDataAccess.save(historialpagomesnomi,connexion);
			historialpagomesnomiLogic.deepSave(historialpagomesnomi,isDeep,deepLoadType,clases);
		}

		for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleado.getEmpleadoImpuestoRentas()) {
			EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
			empleadoimpuestorenta.setid_empleado(empleado.getId());
			EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorenta,connexion);
			empleadoimpuestorentaLogic.deepSave(empleadoimpuestorenta,isDeep,deepLoadType,clases);
		}
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);

				empleado.getDatoGeneralEmpleado().setId(empleado.getId());
					DatoGeneralEmpleadoDataAccess.save(empleado.getDatoGeneralEmpleado(),connexion);
					datogeneralempleadoLogic.deepSave(empleado.getDatoGeneralEmpleado(),isDeep,deepLoadType,clases);

		for(Area area:empleado.getAreas()) {
			AreaLogic areaLogic= new AreaLogic(connexion);
			area.setid_empleado(empleado.getId());
			AreaDataAccess.save(area,connexion);
			areaLogic.deepSave(area,isDeep,deepLoadType,clases);
		}

		for(GastoEmpleado gastoempleado:empleado.getGastoEmpleados()) {
			GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
			gastoempleado.setid_empleado(empleado.getId());
			GastoEmpleadoDataAccess.save(gastoempleado,connexion);
			gastoempleadoLogic.deepSave(gastoempleado,isDeep,deepLoadType,clases);
		}

		for(EmpleadoHobby empleadohobby:empleado.getEmpleadoHobbys()) {
			EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
			empleadohobby.setid_empleado(empleado.getId());
			EmpleadoHobbyDataAccess.save(empleadohobby,connexion);
			empleadohobbyLogic.deepSave(empleadohobby,isDeep,deepLoadType,clases);
		}

		for(EmpleadoEMail empleadoemail:empleado.getEmpleadoEMails()) {
			EmpleadoEMailLogic empleadoemailLogic= new EmpleadoEMailLogic(connexion);
			empleadoemail.setid_empleado(empleado.getId());
			EmpleadoEMailDataAccess.save(empleadoemail,connexion);
			empleadoemailLogic.deepSave(empleadoemail,isDeep,deepLoadType,clases);
		}

		for(RasgoPersonal rasgopersonal:empleado.getRasgoPersonals()) {
			RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
			rasgopersonal.setid_empleado(empleado.getId());
			RasgoPersonalDataAccess.save(rasgopersonal,connexion);
			rasgopersonalLogic.deepSave(rasgopersonal,isDeep,deepLoadType,clases);
		}

		for(Referencia referencia:empleado.getReferencias()) {
			ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
			referencia.setid_empleado(empleado.getId());
			ReferenciaDataAccess.save(referencia,connexion);
			referenciaLogic.deepSave(referencia,isDeep,deepLoadType,clases);
		}

		for(Telefono_NM telefono_nm:empleado.getTelefono_NMs()) {
			Telefono_NMLogic telefono_nmLogic= new Telefono_NMLogic(connexion);
			telefono_nm.setid_empleado(empleado.getId());
			Telefono_NMDataAccess.save(telefono_nm,connexion);
			telefono_nmLogic.deepSave(telefono_nm,isDeep,deepLoadType,clases);
		}

		for(Novedad novedad:empleado.getNovedads()) {
			NovedadLogic novedadLogic= new NovedadLogic(connexion);
			novedad.setid_empleado(empleado.getId());
			NovedadDataAccess.save(novedad,connexion);
			novedadLogic.deepSave(novedad,isDeep,deepLoadType,clases);
		}

		for(EmpleadoHerra empleadoherra:empleado.getEmpleadoHerras()) {
			EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
			empleadoherra.setid_empleado(empleado.getId());
			EmpleadoHerraDataAccess.save(empleadoherra,connexion);
			empleadoherraLogic.deepSave(empleadoherra,isDeep,deepLoadType,clases);
		}

		for(EmpleadoEnfer empleadoenfer:empleado.getEmpleadoEnfers()) {
			EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
			empleadoenfer.setid_empleado(empleado.getId());
			EmpleadoEnferDataAccess.save(empleadoenfer,connexion);
			empleadoenferLogic.deepSave(empleadoenfer,isDeep,deepLoadType,clases);
		}

		for(Visa visa:empleado.getVisas()) {
			VisaLogic visaLogic= new VisaLogic(connexion);
			visa.setid_empleado(empleado.getId());
			VisaDataAccess.save(visa,connexion);
			visaLogic.deepSave(visa,isDeep,deepLoadType,clases);
		}

		for(Seguro seguro:empleado.getSeguros()) {
			SeguroLogic seguroLogic= new SeguroLogic(connexion);
			seguro.setid_empleado(empleado.getId());
			SeguroDataAccess.save(seguro,connexion);
			seguroLogic.deepSave(seguro,isDeep,deepLoadType,clases);
		}

		for(AsistenciaMensual asistenciamensual:empleado.getAsistenciaMensuals()) {
			AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
			asistenciamensual.setid_empleado(empleado.getId());
			AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
			asistenciamensualLogic.deepSave(asistenciamensual,isDeep,deepLoadType,clases);
		}

		for(EmpleadoDisca empleadodisca:empleado.getEmpleadoDiscas()) {
			EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(connexion);
			empleadodisca.setid_empleado(empleado.getId());
			EmpleadoDiscaDataAccess.save(empleadodisca,connexion);
			empleadodiscaLogic.deepSave(empleadodisca,isDeep,deepLoadType,clases);
		}

		for(ProfesionEmplea profesionemplea:empleado.getProfesionEmpleas()) {
			ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
			profesionemplea.setid_empleado(empleado.getId());
			ProfesionEmpleaDataAccess.save(profesionemplea,connexion);
			profesionempleaLogic.deepSave(profesionemplea,isDeep,deepLoadType,clases);
		}

		for(RubroEmpleado rubroempleado:empleado.getRubroEmpleados()) {
			RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
			rubroempleado.setid_empleado(empleado.getId());
			RubroEmpleadoDataAccess.save(rubroempleado,connexion);
			rubroempleadoLogic.deepSave(rubroempleado,isDeep,deepLoadType,clases);
		}

		for(EmpleadoConstante empleadoconstante:empleado.getEmpleadoConstantes()) {
			EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(connexion);
			empleadoconstante.setid_empleado(empleado.getId());
			EmpleadoConstanteDataAccess.save(empleadoconstante,connexion);
			empleadoconstanteLogic.deepSave(empleadoconstante,isDeep,deepLoadType,clases);
		}

		for(TallaVestido tallavestido:empleado.getTallaVestidos()) {
			TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
			tallavestido.setid_empleado(empleado.getId());
			TallaVestidoDataAccess.save(tallavestido,connexion);
			tallavestidoLogic.deepSave(tallavestido,isDeep,deepLoadType,clases);
		}

		for(NovedadNomi novedadnomi:empleado.getNovedadNomis()) {
			NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
			novedadnomi.setid_empleado(empleado.getId());
			NovedadNomiDataAccess.save(novedadnomi,connexion);
			novedadnomiLogic.deepSave(novedadnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(empleado.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(empleado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(empleado.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(empleado.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(empleado.getProvincia(),connexion);
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepSave(empleado.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(empleado.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(empleado.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(empleado.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(empleado.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Religion.class)) {
				ReligionDataAccess.save(empleado.getReligion(),connexion);
				ReligionLogic religionLogic= new ReligionLogic(connexion);
				religionLogic.deepSave(empleado.getReligion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(empleado.getEstadoCivil(),connexion);
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepSave(empleado.getEstadoCivil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(empleado.getTipoGenero(),connexion);
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepSave(empleado.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEmpleado.class)) {
				TipoEmpleadoDataAccess.save(empleado.getTipoEmpleado(),connexion);
				TipoEmpleadoLogic tipoempleadoLogic= new TipoEmpleadoLogic(connexion);
				tipoempleadoLogic.deepSave(empleado.getTipoEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoInstruccion.class)) {
				TipoInstruccionDataAccess.save(empleado.getTipoInstruccion(),connexion);
				TipoInstruccionLogic tipoinstruccionLogic= new TipoInstruccionLogic(connexion);
				tipoinstruccionLogic.deepSave(empleado.getTipoInstruccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				CargoDataAccess.save(empleado.getCargo(),connexion);
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepSave(empleado.getCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleado.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(empleado.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleado.getEstructuraSeccion(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(empleado.getEstructuraSeccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoEmpleado.class)) {
				EstadoEmpleadoDataAccess.save(empleado.getEstadoEmpleado(),connexion);
				EstadoEmpleadoLogic estadoempleadoLogic= new EstadoEmpleadoLogic(connexion);
				estadoempleadoLogic.deepSave(empleado.getEstadoEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoContrato.class)) {
				TipoContratoDataAccess.save(empleado.getTipoContrato(),connexion);
				TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
				tipocontratoLogic.deepSave(empleado.getTipoContrato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				TipoCuentaBancoGlobalDataAccess.save(empleado.getTipoCuentaBancoGlobal(),connexion);
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepSave(empleado.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar_NM cargafamiliar_nm:empleado.getCargaFamiliar_NMs()) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
					cargafamiliar_nm.setid_empleado(empleado.getId());
					CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
					cargafamiliar_nmLogic.deepSave(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Curso curso:empleado.getCursos()) {
					CursoLogic cursoLogic= new CursoLogic(connexion);
					curso.setid_empleado(empleado.getId());
					CursoDataAccess.save(curso,connexion);
					cursoLogic.deepSave(curso,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Prestamo prestamo:empleado.getPrestamos()) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
					prestamo.setid_empleado(empleado.getId());
					PrestamoDataAccess.save(prestamo,connexion);
					prestamoLogic.deepSave(prestamo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoIdioma empleadoidioma:empleado.getEmpleadoIdiomas()) {
					EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
					empleadoidioma.setid_empleado(empleado.getId());
					EmpleadoIdiomaDataAccess.save(empleadoidioma,connexion);
					empleadoidiomaLogic.deepSave(empleadoidioma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialPagoMesNomi historialpagomesnomi:empleado.getHistorialPagoMesNomis()) {
					HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
					historialpagomesnomi.setid_empleado(empleado.getId());
					HistorialPagoMesNomiDataAccess.save(historialpagomesnomi,connexion);
					historialpagomesnomiLogic.deepSave(historialpagomesnomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleado.getEmpleadoImpuestoRentas()) {
					EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
					empleadoimpuestorenta.setid_empleado(empleado.getId());
					EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorenta,connexion);
					empleadoimpuestorentaLogic.deepSave(empleadoimpuestorenta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);

				empleado.getDatoGeneralEmpleado().setId(empleado.getId());
					DatoGeneralEmpleadoDataAccess.save(empleado.getDatoGeneralEmpleado(),connexion);
					datogeneralempleadoLogic.deepSave(empleado.getDatoGeneralEmpleado(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(Area.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Area area:empleado.getAreas()) {
					AreaLogic areaLogic= new AreaLogic(connexion);
					area.setid_empleado(empleado.getId());
					AreaDataAccess.save(area,connexion);
					areaLogic.deepSave(area,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoEmpleado gastoempleado:empleado.getGastoEmpleados()) {
					GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
					gastoempleado.setid_empleado(empleado.getId());
					GastoEmpleadoDataAccess.save(gastoempleado,connexion);
					gastoempleadoLogic.deepSave(gastoempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoHobby empleadohobby:empleado.getEmpleadoHobbys()) {
					EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
					empleadohobby.setid_empleado(empleado.getId());
					EmpleadoHobbyDataAccess.save(empleadohobby,connexion);
					empleadohobbyLogic.deepSave(empleadohobby,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEMail empleadoemail:empleado.getEmpleadoEMails()) {
					EmpleadoEMailLogic empleadoemailLogic= new EmpleadoEMailLogic(connexion);
					empleadoemail.setid_empleado(empleado.getId());
					EmpleadoEMailDataAccess.save(empleadoemail,connexion);
					empleadoemailLogic.deepSave(empleadoemail,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RasgoPersonal rasgopersonal:empleado.getRasgoPersonals()) {
					RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
					rasgopersonal.setid_empleado(empleado.getId());
					RasgoPersonalDataAccess.save(rasgopersonal,connexion);
					rasgopersonalLogic.deepSave(rasgopersonal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Referencia referencia:empleado.getReferencias()) {
					ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
					referencia.setid_empleado(empleado.getId());
					ReferenciaDataAccess.save(referencia,connexion);
					referenciaLogic.deepSave(referencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Telefono_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Telefono_NM telefono_nm:empleado.getTelefono_NMs()) {
					Telefono_NMLogic telefono_nmLogic= new Telefono_NMLogic(connexion);
					telefono_nm.setid_empleado(empleado.getId());
					Telefono_NMDataAccess.save(telefono_nm,connexion);
					telefono_nmLogic.deepSave(telefono_nm,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Novedad novedad:empleado.getNovedads()) {
					NovedadLogic novedadLogic= new NovedadLogic(connexion);
					novedad.setid_empleado(empleado.getId());
					NovedadDataAccess.save(novedad,connexion);
					novedadLogic.deepSave(novedad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoHerra empleadoherra:empleado.getEmpleadoHerras()) {
					EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
					empleadoherra.setid_empleado(empleado.getId());
					EmpleadoHerraDataAccess.save(empleadoherra,connexion);
					empleadoherraLogic.deepSave(empleadoherra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEnfer empleadoenfer:empleado.getEmpleadoEnfers()) {
					EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
					empleadoenfer.setid_empleado(empleado.getId());
					EmpleadoEnferDataAccess.save(empleadoenfer,connexion);
					empleadoenferLogic.deepSave(empleadoenfer,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Visa.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Visa visa:empleado.getVisas()) {
					VisaLogic visaLogic= new VisaLogic(connexion);
					visa.setid_empleado(empleado.getId());
					VisaDataAccess.save(visa,connexion);
					visaLogic.deepSave(visa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Seguro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Seguro seguro:empleado.getSeguros()) {
					SeguroLogic seguroLogic= new SeguroLogic(connexion);
					seguro.setid_empleado(empleado.getId());
					SeguroDataAccess.save(seguro,connexion);
					seguroLogic.deepSave(seguro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AsistenciaMensual asistenciamensual:empleado.getAsistenciaMensuals()) {
					AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
					asistenciamensual.setid_empleado(empleado.getId());
					AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
					asistenciamensualLogic.deepSave(asistenciamensual,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoDisca empleadodisca:empleado.getEmpleadoDiscas()) {
					EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(connexion);
					empleadodisca.setid_empleado(empleado.getId());
					EmpleadoDiscaDataAccess.save(empleadodisca,connexion);
					empleadodiscaLogic.deepSave(empleadodisca,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProfesionEmplea profesionemplea:empleado.getProfesionEmpleas()) {
					ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
					profesionemplea.setid_empleado(empleado.getId());
					ProfesionEmpleaDataAccess.save(profesionemplea,connexion);
					profesionempleaLogic.deepSave(profesionemplea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleado rubroempleado:empleado.getRubroEmpleados()) {
					RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
					rubroempleado.setid_empleado(empleado.getId());
					RubroEmpleadoDataAccess.save(rubroempleado,connexion);
					rubroempleadoLogic.deepSave(rubroempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoConstante.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoConstante empleadoconstante:empleado.getEmpleadoConstantes()) {
					EmpleadoConstanteLogic empleadoconstanteLogic= new EmpleadoConstanteLogic(connexion);
					empleadoconstante.setid_empleado(empleado.getId());
					EmpleadoConstanteDataAccess.save(empleadoconstante,connexion);
					empleadoconstanteLogic.deepSave(empleadoconstante,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TallaVestido tallavestido:empleado.getTallaVestidos()) {
					TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
					tallavestido.setid_empleado(empleado.getId());
					TallaVestidoDataAccess.save(tallavestido,connexion);
					tallavestidoLogic.deepSave(tallavestido,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NovedadNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadNomi novedadnomi:empleado.getNovedadNomis()) {
					NovedadNomiLogic novedadnomiLogic= new NovedadNomiLogic(connexion);
					novedadnomi.setid_empleado(empleado.getId());
					NovedadNomiDataAccess.save(novedadnomi,connexion);
					novedadnomiLogic.deepSave(novedadnomi,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Empleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleado);
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
			this.deepLoad(this.empleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Empleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleados!=null) {
				for(Empleado empleado:empleados) {
					this.deepLoad(empleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleados);
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
			if(empleados!=null) {
				for(Empleado empleado:empleados) {
					this.deepLoad(empleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleados);
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
			this.getNewConnexionToDeep(Empleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Empleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleados!=null) {
				for(Empleado empleado:empleados) {
					this.deepSave(empleado,isDeep,deepLoadType,clases);
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
			if(empleados!=null) {
				for(Empleado empleado:empleados) {
					this.deepSave(empleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadosFK_IdCargoWithConnection(String sFinalQuery,Pagination pagination,Long id_cargo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo,EmpleadoConstantesFunciones.IDCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargo);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdCargo(String sFinalQuery,Pagination pagination,Long id_cargo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo,EmpleadoConstantesFunciones.IDCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargo);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,EmpleadoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,EmpleadoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,EmpleadoConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,EmpleadoConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdEstadoCivilWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,EmpleadoConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdEstadoCivil(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,EmpleadoConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdEstadoEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_empleado,EmpleadoConstantesFunciones.IDESTADOEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoEmpleado);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdEstadoEmpleado(String sFinalQuery,Pagination pagination,Long id_estado_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_empleado,EmpleadoConstantesFunciones.IDESTADOEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoEmpleado);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdEstructuraSeccionWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura_seccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructuraSeccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructuraSeccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura_seccion,EmpleadoConstantesFunciones.IDESTRUCTURASECCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructuraSeccion);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructuraSeccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdEstructuraSeccion(String sFinalQuery,Pagination pagination,Long id_estructura_seccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructuraSeccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructuraSeccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura_seccion,EmpleadoConstantesFunciones.IDESTRUCTURASECCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructuraSeccion);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructuraSeccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmpleadoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmpleadoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdProvinciaWithConnection(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,EmpleadoConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdProvincia(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,EmpleadoConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdReligionWithConnection(String sFinalQuery,Pagination pagination,Long id_religion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidReligion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidReligion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_religion,EmpleadoConstantesFunciones.IDRELIGION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidReligion);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdReligion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdReligion(String sFinalQuery,Pagination pagination,Long id_religion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidReligion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidReligion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_religion,EmpleadoConstantesFunciones.IDRELIGION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidReligion);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdReligion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EmpleadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EmpleadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdTipoContratoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_contrato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoContrato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoContrato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_contrato,EmpleadoConstantesFunciones.IDTIPOCONTRATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoContrato);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoContrato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdTipoContrato(String sFinalQuery,Pagination pagination,Long id_tipo_contrato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoContrato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoContrato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_contrato,EmpleadoConstantesFunciones.IDTIPOCONTRATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoContrato);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoContrato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdTipoCuentaBancoGlobalWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdTipoCuentaBancoGlobal(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdTipoEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_empleado,EmpleadoConstantesFunciones.IDTIPOEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEmpleado);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdTipoEmpleado(String sFinalQuery,Pagination pagination,Long id_tipo_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_empleado,EmpleadoConstantesFunciones.IDTIPOEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEmpleado);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdTipoGeneroWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,EmpleadoConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdTipoGenero(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,EmpleadoConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadosFK_IdTipoInstruccionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_instruccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoInstruccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoInstruccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_instruccion,EmpleadoConstantesFunciones.IDTIPOINSTRUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoInstruccion);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoInstruccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadosFK_IdTipoInstruccion(String sFinalQuery,Pagination pagination,Long id_tipo_instruccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoInstruccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoInstruccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_instruccion,EmpleadoConstantesFunciones.IDTIPOINSTRUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoInstruccion);

			EmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoInstruccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(this.empleados);
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
			if(EmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Empleado empleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(empleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoDataAccess.TABLENAME, empleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoLogic.registrarAuditoriaDetallesEmpleado(connexion,empleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleado.getIsDeleted()) {
					/*if(!empleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoDataAccess.TABLENAME, empleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoLogic.registrarAuditoriaDetallesEmpleado(connexion,empleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoDataAccess.TABLENAME, empleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoDataAccess.TABLENAME, empleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoLogic.registrarAuditoriaDetallesEmpleado(connexion,empleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleado(Connexion connexion,Empleado empleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleado.getIsNew()||!empleado.getid_empresa().equals(empleado.getEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_empresa().toString();
				}
				if(empleado.getid_empresa()!=null)
				{
					strValorNuevo=empleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_sucursal().equals(empleado.getEmpleadoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_sucursal()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_sucursal().toString();
				}
				if(empleado.getid_sucursal()!=null)
				{
					strValorNuevo=empleado.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_pais().equals(empleado.getEmpleadoOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_pais()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_pais().toString();
				}
				if(empleado.getid_pais()!=null)
				{
					strValorNuevo=empleado.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_provincia().equals(empleado.getEmpleadoOriginal().getid_provincia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_provincia()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_provincia().toString();
				}
				if(empleado.getid_provincia()!=null)
				{
					strValorNuevo=empleado.getid_provincia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDPROVINCIA,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_ciudad().equals(empleado.getEmpleadoOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_ciudad()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_ciudad().toString();
				}
				if(empleado.getid_ciudad()!=null)
				{
					strValorNuevo=empleado.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_centro_costo().equals(empleado.getEmpleadoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_centro_costo().toString();
				}
				if(empleado.getid_centro_costo()!=null)
				{
					strValorNuevo=empleado.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_religion().equals(empleado.getEmpleadoOriginal().getid_religion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_religion()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_religion().toString();
				}
				if(empleado.getid_religion()!=null)
				{
					strValorNuevo=empleado.getid_religion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDRELIGION,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_estado_civil().equals(empleado.getEmpleadoOriginal().getid_estado_civil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_estado_civil()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_estado_civil().toString();
				}
				if(empleado.getid_estado_civil()!=null)
				{
					strValorNuevo=empleado.getid_estado_civil().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDESTADOCIVIL,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_tipo_genero().equals(empleado.getEmpleadoOriginal().getid_tipo_genero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_tipo_genero()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_tipo_genero().toString();
				}
				if(empleado.getid_tipo_genero()!=null)
				{
					strValorNuevo=empleado.getid_tipo_genero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDTIPOGENERO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_tipo_empleado().equals(empleado.getEmpleadoOriginal().getid_tipo_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_tipo_empleado()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_tipo_empleado().toString();
				}
				if(empleado.getid_tipo_empleado()!=null)
				{
					strValorNuevo=empleado.getid_tipo_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDTIPOEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_tipo_instruccion().equals(empleado.getEmpleadoOriginal().getid_tipo_instruccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_tipo_instruccion()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_tipo_instruccion().toString();
				}
				if(empleado.getid_tipo_instruccion()!=null)
				{
					strValorNuevo=empleado.getid_tipo_instruccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDTIPOINSTRUCCION,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_cargo().equals(empleado.getEmpleadoOriginal().getid_cargo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_cargo()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_cargo().toString();
				}
				if(empleado.getid_cargo()!=null)
				{
					strValorNuevo=empleado.getid_cargo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDCARGO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_estructura().equals(empleado.getEmpleadoOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_estructura()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_estructura().toString();
				}
				if(empleado.getid_estructura()!=null)
				{
					strValorNuevo=empleado.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_estructura_seccion().equals(empleado.getEmpleadoOriginal().getid_estructura_seccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_estructura_seccion()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_estructura_seccion().toString();
				}
				if(empleado.getid_estructura_seccion()!=null)
				{
					strValorNuevo=empleado.getid_estructura_seccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDESTRUCTURASECCION,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_estado_empleado().equals(empleado.getEmpleadoOriginal().getid_estado_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_estado_empleado()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_estado_empleado().toString();
				}
				if(empleado.getid_estado_empleado()!=null)
				{
					strValorNuevo=empleado.getid_estado_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDESTADOEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_tipo_contrato().equals(empleado.getEmpleadoOriginal().getid_tipo_contrato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_tipo_contrato()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_tipo_contrato().toString();
				}
				if(empleado.getid_tipo_contrato()!=null)
				{
					strValorNuevo=empleado.getid_tipo_contrato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDTIPOCONTRATO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getcodigo().equals(empleado.getEmpleadoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getcodigo()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getcodigo();
				}
				if(empleado.getcodigo()!=null)
				{
					strValorNuevo=empleado.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getnombre().equals(empleado.getEmpleadoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getnombre()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getnombre();
				}
				if(empleado.getnombre()!=null)
				{
					strValorNuevo=empleado.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getapellido().equals(empleado.getEmpleadoOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getapellido()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getapellido();
				}
				if(empleado.getapellido()!=null)
				{
					strValorNuevo=empleado.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getnombre_completo().equals(empleado.getEmpleadoOriginal().getnombre_completo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getnombre_completo()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getnombre_completo();
				}
				if(empleado.getnombre_completo()!=null)
				{
					strValorNuevo=empleado.getnombre_completo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.NOMBRECOMPLETO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getmail().equals(empleado.getEmpleadoOriginal().getmail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getmail()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getmail();
				}
				if(empleado.getmail()!=null)
				{
					strValorNuevo=empleado.getmail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.MAIL,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getdireccion().equals(empleado.getEmpleadoOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getdireccion()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getdireccion();
				}
				if(empleado.getdireccion()!=null)
				{
					strValorNuevo=empleado.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getsueldo().equals(empleado.getEmpleadoOriginal().getsueldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getsueldo()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getsueldo().toString();
				}
				if(empleado.getsueldo()!=null)
				{
					strValorNuevo=empleado.getsueldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.SUELDO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.gettelefono().equals(empleado.getEmpleadoOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().gettelefono()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().gettelefono();
				}
				if(empleado.gettelefono()!=null)
				{
					strValorNuevo=empleado.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getid_tipo_cuenta_banco_global().equals(empleado.getEmpleadoOriginal().getid_tipo_cuenta_banco_global()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getid_tipo_cuenta_banco_global()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getid_tipo_cuenta_banco_global().toString();
				}
				if(empleado.getid_tipo_cuenta_banco_global()!=null)
				{
					strValorNuevo=empleado.getid_tipo_cuenta_banco_global().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.getnumero_cuenta().equals(empleado.getEmpleadoOriginal().getnumero_cuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().getnumero_cuenta()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().getnumero_cuenta();
				}
				if(empleado.getnumero_cuenta()!=null)
				{
					strValorNuevo=empleado.getnumero_cuenta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.NUMEROCUENTA,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.gettiene_casa().equals(empleado.getEmpleadoOriginal().gettiene_casa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().gettiene_casa()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().gettiene_casa().toString();
				}
				if(empleado.gettiene_casa()!=null)
				{
					strValorNuevo=empleado.gettiene_casa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.TIENECASA,strValorActual,strValorNuevo);
			}	
			
			if(empleado.getIsNew()||!empleado.gettiene_vehiculo().equals(empleado.getEmpleadoOriginal().gettiene_vehiculo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleado.getEmpleadoOriginal().gettiene_vehiculo()!=null)
				{
					strValorActual=empleado.getEmpleadoOriginal().gettiene_vehiculo().toString();
				}
				if(empleado.gettiene_vehiculo()!=null)
				{
					strValorNuevo=empleado.gettiene_vehiculo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstantesFunciones.TIENEVEHICULO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoRelacionesWithConnection(Empleado empleado,List<CargaFamiliar_NM> cargafamiliar_nms,List<Curso> cursos,List<Prestamo> prestamos,List<EmpleadoIdioma> empleadoidiomas,List<HistorialPagoMesNomi> historialpagomesnomis,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,DatoGeneralEmpleado datogeneralempleado,List<Area> areas,List<GastoEmpleado> gastoempleados,List<EmpleadoHobby> empleadohobbys,List<EmpleadoEMail> empleadoemails,List<RasgoPersonal> rasgopersonals,List<Referencia> referencias,List<Telefono_NM> telefono_nms,List<Novedad> novedads,List<EmpleadoHerra> empleadoherras,List<EmpleadoEnfer> empleadoenfers,List<Visa> visas,List<Seguro> seguros,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoDisca> empleadodiscas,List<ProfesionEmplea> profesionempleas,List<RubroEmpleado> rubroempleados,List<EmpleadoConstante> empleadoconstantes,List<TallaVestido> tallavestidos,List<NovedadNomi> novedadnomis) throws Exception {

		if(!empleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoRelacionesBase(empleado,cargafamiliar_nms,cursos,prestamos,empleadoidiomas,historialpagomesnomis,empleadoimpuestorentas,datogeneralempleado,areas,gastoempleados,empleadohobbys,empleadoemails,rasgopersonals,referencias,telefono_nms,novedads,empleadoherras,empleadoenfers,visas,seguros,asistenciamensuals,empleadodiscas,profesionempleas,rubroempleados,empleadoconstantes,tallavestidos,novedadnomis,true);
		}
	}

	public void saveEmpleadoRelaciones(Empleado empleado,List<CargaFamiliar_NM> cargafamiliar_nms,List<Curso> cursos,List<Prestamo> prestamos,List<EmpleadoIdioma> empleadoidiomas,List<HistorialPagoMesNomi> historialpagomesnomis,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,DatoGeneralEmpleado datogeneralempleado,List<Area> areas,List<GastoEmpleado> gastoempleados,List<EmpleadoHobby> empleadohobbys,List<EmpleadoEMail> empleadoemails,List<RasgoPersonal> rasgopersonals,List<Referencia> referencias,List<Telefono_NM> telefono_nms,List<Novedad> novedads,List<EmpleadoHerra> empleadoherras,List<EmpleadoEnfer> empleadoenfers,List<Visa> visas,List<Seguro> seguros,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoDisca> empleadodiscas,List<ProfesionEmplea> profesionempleas,List<RubroEmpleado> rubroempleados,List<EmpleadoConstante> empleadoconstantes,List<TallaVestido> tallavestidos,List<NovedadNomi> novedadnomis)throws Exception {

		if(!empleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoRelacionesBase(empleado,cargafamiliar_nms,cursos,prestamos,empleadoidiomas,historialpagomesnomis,empleadoimpuestorentas,datogeneralempleado,areas,gastoempleados,empleadohobbys,empleadoemails,rasgopersonals,referencias,telefono_nms,novedads,empleadoherras,empleadoenfers,visas,seguros,asistenciamensuals,empleadodiscas,profesionempleas,rubroempleados,empleadoconstantes,tallavestidos,novedadnomis,false);
		}
	}

	public void saveEmpleadoRelacionesBase(Empleado empleado,List<CargaFamiliar_NM> cargafamiliar_nms,List<Curso> cursos,List<Prestamo> prestamos,List<EmpleadoIdioma> empleadoidiomas,List<HistorialPagoMesNomi> historialpagomesnomis,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,DatoGeneralEmpleado datogeneralempleado,List<Area> areas,List<GastoEmpleado> gastoempleados,List<EmpleadoHobby> empleadohobbys,List<EmpleadoEMail> empleadoemails,List<RasgoPersonal> rasgopersonals,List<Referencia> referencias,List<Telefono_NM> telefono_nms,List<Novedad> novedads,List<EmpleadoHerra> empleadoherras,List<EmpleadoEnfer> empleadoenfers,List<Visa> visas,List<Seguro> seguros,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoDisca> empleadodiscas,List<ProfesionEmplea> profesionempleas,List<RubroEmpleado> rubroempleados,List<EmpleadoConstante> empleadoconstantes,List<TallaVestido> tallavestidos,List<NovedadNomi> novedadnomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Empleado-saveRelacionesWithConnection");}
	
			empleado.setCargaFamiliar_NMs(cargafamiliar_nms);
			empleado.setCursos(cursos);
			empleado.setPrestamos(prestamos);
			empleado.setEmpleadoIdiomas(empleadoidiomas);
			empleado.setHistorialPagoMesNomis(historialpagomesnomis);
			empleado.setEmpleadoImpuestoRentas(empleadoimpuestorentas);
			empleado.setDatoGeneralEmpleado(datogeneralempleado);
			empleado.setAreas(areas);
			empleado.setGastoEmpleados(gastoempleados);
			empleado.setEmpleadoHobbys(empleadohobbys);
			empleado.setEmpleadoEMails(empleadoemails);
			empleado.setRasgoPersonals(rasgopersonals);
			empleado.setReferencias(referencias);
			empleado.setTelefono_NMs(telefono_nms);
			empleado.setNovedads(novedads);
			empleado.setEmpleadoHerras(empleadoherras);
			empleado.setEmpleadoEnfers(empleadoenfers);
			empleado.setVisas(visas);
			empleado.setSeguros(seguros);
			empleado.setAsistenciaMensuals(asistenciamensuals);
			empleado.setEmpleadoDiscas(empleadodiscas);
			empleado.setProfesionEmpleas(profesionempleas);
			empleado.setRubroEmpleados(rubroempleados);
			empleado.setEmpleadoConstantes(empleadoconstantes);
			empleado.setTallaVestidos(tallavestidos);
			empleado.setNovedadNomis(novedadnomis);

			this.setEmpleado(empleado);

			if(EmpleadoLogicAdditional.validarSaveRelaciones(empleado,this)) {

				EmpleadoLogicAdditional.updateRelacionesToSave(empleado,this);

				if((empleado.getIsNew()||empleado.getIsChanged())&&!empleado.getIsDeleted()) {
					this.saveEmpleado();
					this.saveEmpleadoRelacionesDetalles(cargafamiliar_nms,cursos,prestamos,empleadoidiomas,historialpagomesnomis,empleadoimpuestorentas,datogeneralempleado,areas,gastoempleados,empleadohobbys,empleadoemails,rasgopersonals,referencias,telefono_nms,novedads,empleadoherras,empleadoenfers,visas,seguros,asistenciamensuals,empleadodiscas,profesionempleas,rubroempleados,empleadoconstantes,tallavestidos,novedadnomis);

				} else if(empleado.getIsDeleted()) {
					this.saveEmpleadoRelacionesDetalles(cargafamiliar_nms,cursos,prestamos,empleadoidiomas,historialpagomesnomis,empleadoimpuestorentas,datogeneralempleado,areas,gastoempleados,empleadohobbys,empleadoemails,rasgopersonals,referencias,telefono_nms,novedads,empleadoherras,empleadoenfers,visas,seguros,asistenciamensuals,empleadodiscas,profesionempleas,rubroempleados,empleadoconstantes,tallavestidos,novedadnomis);
					this.saveEmpleado();
				}

				EmpleadoLogicAdditional.updateRelacionesToSaveAfter(empleado,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CargaFamiliar_NMConstantesFunciones.InicializarGeneralEntityAuxiliaresCargaFamiliar_NMs(cargafamiliar_nms,true,true);
			CursoConstantesFunciones.InicializarGeneralEntityAuxiliaresCursos(cursos,true,true);
			PrestamoConstantesFunciones.InicializarGeneralEntityAuxiliaresPrestamos(prestamos,true,true);
			EmpleadoIdiomaConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoIdiomas(empleadoidiomas,true,true);
			HistorialPagoMesNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresHistorialPagoMesNomis(historialpagomesnomis,true,true);
			EmpleadoImpuestoRentaConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoImpuestoRentas(empleadoimpuestorentas,true,true);
		DatoGeneralEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoGeneralEmpleado(datogeneralempleado,true,true);
			AreaConstantesFunciones.InicializarGeneralEntityAuxiliaresAreas(areas,true,true);
			GastoEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresGastoEmpleados(gastoempleados,true,true);
			EmpleadoHobbyConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoHobbys(empleadohobbys,true,true);
			EmpleadoEMailConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoEMails(empleadoemails,true,true);
			RasgoPersonalConstantesFunciones.InicializarGeneralEntityAuxiliaresRasgoPersonals(rasgopersonals,true,true);
			ReferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresReferencias(referencias,true,true);
			Telefono_NMConstantesFunciones.InicializarGeneralEntityAuxiliaresTelefono_NMs(telefono_nms,true,true);
			NovedadConstantesFunciones.InicializarGeneralEntityAuxiliaresNovedads(novedads,true,true);
			EmpleadoHerraConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoHerras(empleadoherras,true,true);
			EmpleadoEnferConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoEnfers(empleadoenfers,true,true);
			VisaConstantesFunciones.InicializarGeneralEntityAuxiliaresVisas(visas,true,true);
			SeguroConstantesFunciones.InicializarGeneralEntityAuxiliaresSeguros(seguros,true,true);
			AsistenciaMensualConstantesFunciones.InicializarGeneralEntityAuxiliaresAsistenciaMensuals(asistenciamensuals,true,true);
			EmpleadoDiscaConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoDiscas(empleadodiscas,true,true);
			ProfesionEmpleaConstantesFunciones.InicializarGeneralEntityAuxiliaresProfesionEmpleas(profesionempleas,true,true);
			RubroEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresRubroEmpleados(rubroempleados,true,true);
			EmpleadoConstanteConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoConstantes(empleadoconstantes,true,true);
			TallaVestidoConstantesFunciones.InicializarGeneralEntityAuxiliaresTallaVestidos(tallavestidos,true,true);
			NovedadNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresNovedadNomis(novedadnomis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEmpleadoRelacionesDetalles(List<CargaFamiliar_NM> cargafamiliar_nms,List<Curso> cursos,List<Prestamo> prestamos,List<EmpleadoIdioma> empleadoidiomas,List<HistorialPagoMesNomi> historialpagomesnomis,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,DatoGeneralEmpleado datogeneralempleado,List<Area> areas,List<GastoEmpleado> gastoempleados,List<EmpleadoHobby> empleadohobbys,List<EmpleadoEMail> empleadoemails,List<RasgoPersonal> rasgopersonals,List<Referencia> referencias,List<Telefono_NM> telefono_nms,List<Novedad> novedads,List<EmpleadoHerra> empleadoherras,List<EmpleadoEnfer> empleadoenfers,List<Visa> visas,List<Seguro> seguros,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoDisca> empleadodiscas,List<ProfesionEmplea> profesionempleas,List<RubroEmpleado> rubroempleados,List<EmpleadoConstante> empleadoconstantes,List<TallaVestido> tallavestidos,List<NovedadNomi> novedadnomis)throws Exception {
		try {
	

			Long idEmpleadoActual=this.getEmpleado().getId();

			CargaFamiliar_NMLogic cargafamiliar_nmLogic_Desde_Empleado=new CargaFamiliar_NMLogic();
			cargafamiliar_nmLogic_Desde_Empleado.setCargaFamiliar_NMs(cargafamiliar_nms);

			cargafamiliar_nmLogic_Desde_Empleado.setConnexion(this.getConnexion());
			cargafamiliar_nmLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(CargaFamiliar_NM cargafamiliar_nm_Desde_Empleado:cargafamiliar_nmLogic_Desde_Empleado.getCargaFamiliar_NMs()) {
				cargafamiliar_nm_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			cargafamiliar_nmLogic_Desde_Empleado.saveCargaFamiliar_NMs();

			CursoLogic cursoLogic_Desde_Empleado=new CursoLogic();
			cursoLogic_Desde_Empleado.setCursos(cursos);

			cursoLogic_Desde_Empleado.setConnexion(this.getConnexion());
			cursoLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(Curso curso_Desde_Empleado:cursoLogic_Desde_Empleado.getCursos()) {
				curso_Desde_Empleado.setid_empleado(idEmpleadoActual);

				cursoLogic_Desde_Empleado.setCurso(curso_Desde_Empleado);
				cursoLogic_Desde_Empleado.saveCurso();

				Long idCursoActual=curso_Desde_Empleado.getId();

				DetalleCursoLogic detallecursoLogic_Desde_Curso=new DetalleCursoLogic();

				if(curso_Desde_Empleado.getDetalleCursos()==null){
					curso_Desde_Empleado.setDetalleCursos(new ArrayList<DetalleCurso>());
				}

				detallecursoLogic_Desde_Curso.setDetalleCursos(curso_Desde_Empleado.getDetalleCursos());

				detallecursoLogic_Desde_Curso.setConnexion(this.getConnexion());
				detallecursoLogic_Desde_Curso.setDatosCliente(this.datosCliente);

				for(DetalleCurso detallecurso_Desde_Curso:detallecursoLogic_Desde_Curso.getDetalleCursos()) {
					detallecurso_Desde_Curso.setid_curso(idCursoActual);
				}

				detallecursoLogic_Desde_Curso.saveDetalleCursos();
			}


			PrestamoLogic prestamoLogic_Desde_Empleado=new PrestamoLogic();
			prestamoLogic_Desde_Empleado.setPrestamos(prestamos);

			prestamoLogic_Desde_Empleado.setConnexion(this.getConnexion());
			prestamoLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(Prestamo prestamo_Desde_Empleado:prestamoLogic_Desde_Empleado.getPrestamos()) {
				prestamo_Desde_Empleado.setid_empleado(idEmpleadoActual);

				prestamoLogic_Desde_Empleado.setPrestamo(prestamo_Desde_Empleado);
				prestamoLogic_Desde_Empleado.savePrestamo();

				Long idPrestamoActual=prestamo_Desde_Empleado.getId();

				AbonoPrestamoLogic abonoprestamoLogic_Desde_Prestamo=new AbonoPrestamoLogic();

				if(prestamo_Desde_Empleado.getAbonoPrestamos()==null){
					prestamo_Desde_Empleado.setAbonoPrestamos(new ArrayList<AbonoPrestamo>());
				}

				abonoprestamoLogic_Desde_Prestamo.setAbonoPrestamos(prestamo_Desde_Empleado.getAbonoPrestamos());

				abonoprestamoLogic_Desde_Prestamo.setConnexion(this.getConnexion());
				abonoprestamoLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

				for(AbonoPrestamo abonoprestamo_Desde_Prestamo:abonoprestamoLogic_Desde_Prestamo.getAbonoPrestamos()) {
					abonoprestamo_Desde_Prestamo.setid_prestamo(idPrestamoActual);
				}

				abonoprestamoLogic_Desde_Prestamo.saveAbonoPrestamos();

				CuotaLogic cuotaLogic_Desde_Prestamo=new CuotaLogic();

				if(prestamo_Desde_Empleado.getCuotas()==null){
					prestamo_Desde_Empleado.setCuotas(new ArrayList<Cuota>());
				}

				cuotaLogic_Desde_Prestamo.setCuotas(prestamo_Desde_Empleado.getCuotas());

				cuotaLogic_Desde_Prestamo.setConnexion(this.getConnexion());
				cuotaLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

				for(Cuota cuota_Desde_Prestamo:cuotaLogic_Desde_Prestamo.getCuotas()) {
					cuota_Desde_Prestamo.setid_prestamo(idPrestamoActual);
				}

				cuotaLogic_Desde_Prestamo.saveCuotas();
			}


			EmpleadoIdiomaLogic empleadoidiomaLogic_Desde_Empleado=new EmpleadoIdiomaLogic();
			empleadoidiomaLogic_Desde_Empleado.setEmpleadoIdiomas(empleadoidiomas);

			empleadoidiomaLogic_Desde_Empleado.setConnexion(this.getConnexion());
			empleadoidiomaLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(EmpleadoIdioma empleadoidioma_Desde_Empleado:empleadoidiomaLogic_Desde_Empleado.getEmpleadoIdiomas()) {
				empleadoidioma_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			empleadoidiomaLogic_Desde_Empleado.saveEmpleadoIdiomas();

			HistorialPagoMesNomiLogic historialpagomesnomiLogic_Desde_Empleado=new HistorialPagoMesNomiLogic();
			historialpagomesnomiLogic_Desde_Empleado.setHistorialPagoMesNomis(historialpagomesnomis);

			historialpagomesnomiLogic_Desde_Empleado.setConnexion(this.getConnexion());
			historialpagomesnomiLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(HistorialPagoMesNomi historialpagomesnomi_Desde_Empleado:historialpagomesnomiLogic_Desde_Empleado.getHistorialPagoMesNomis()) {
				historialpagomesnomi_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			historialpagomesnomiLogic_Desde_Empleado.saveHistorialPagoMesNomis();

			EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic_Desde_Empleado=new EmpleadoImpuestoRentaLogic();
			empleadoimpuestorentaLogic_Desde_Empleado.setEmpleadoImpuestoRentas(empleadoimpuestorentas);

			empleadoimpuestorentaLogic_Desde_Empleado.setConnexion(this.getConnexion());
			empleadoimpuestorentaLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(EmpleadoImpuestoRenta empleadoimpuestorenta_Desde_Empleado:empleadoimpuestorentaLogic_Desde_Empleado.getEmpleadoImpuestoRentas()) {
				empleadoimpuestorenta_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			empleadoimpuestorentaLogic_Desde_Empleado.saveEmpleadoImpuestoRentas();

			DatoGeneralEmpleadoLogic datogeneralempleadoLogic_Desde_Empleado=new DatoGeneralEmpleadoLogic();
			datogeneralempleadoLogic_Desde_Empleado.setDatoGeneralEmpleado(datogeneralempleado);

			if(datogeneralempleadoLogic_Desde_Empleado.getDatoGeneralEmpleado()!=null) {
			datogeneralempleadoLogic_Desde_Empleado.getDatoGeneralEmpleado().setId(idEmpleadoActual);
			}

			datogeneralempleadoLogic_Desde_Empleado.setConnexion(this.getConnexion());
			datogeneralempleadoLogic_Desde_Empleado.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic_Desde_Empleado.saveDatoGeneralEmpleado();

			AreaLogic areaLogic_Desde_Empleado=new AreaLogic();
			areaLogic_Desde_Empleado.setAreas(areas);

			areaLogic_Desde_Empleado.setConnexion(this.getConnexion());
			areaLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(Area area_Desde_Empleado:areaLogic_Desde_Empleado.getAreas()) {
				area_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			areaLogic_Desde_Empleado.saveAreas();

			GastoEmpleadoLogic gastoempleadoLogic_Desde_Empleado=new GastoEmpleadoLogic();
			gastoempleadoLogic_Desde_Empleado.setGastoEmpleados(gastoempleados);

			gastoempleadoLogic_Desde_Empleado.setConnexion(this.getConnexion());
			gastoempleadoLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(GastoEmpleado gastoempleado_Desde_Empleado:gastoempleadoLogic_Desde_Empleado.getGastoEmpleados()) {
				gastoempleado_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			gastoempleadoLogic_Desde_Empleado.saveGastoEmpleados();

			EmpleadoHobbyLogic empleadohobbyLogic_Desde_Empleado=new EmpleadoHobbyLogic();
			empleadohobbyLogic_Desde_Empleado.setEmpleadoHobbys(empleadohobbys);

			empleadohobbyLogic_Desde_Empleado.setConnexion(this.getConnexion());
			empleadohobbyLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(EmpleadoHobby empleadohobby_Desde_Empleado:empleadohobbyLogic_Desde_Empleado.getEmpleadoHobbys()) {
				empleadohobby_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			empleadohobbyLogic_Desde_Empleado.saveEmpleadoHobbys();

			EmpleadoEMailLogic empleadoemailLogic_Desde_Empleado=new EmpleadoEMailLogic();
			empleadoemailLogic_Desde_Empleado.setEmpleadoEMails(empleadoemails);

			empleadoemailLogic_Desde_Empleado.setConnexion(this.getConnexion());
			empleadoemailLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(EmpleadoEMail empleadoemail_Desde_Empleado:empleadoemailLogic_Desde_Empleado.getEmpleadoEMails()) {
				empleadoemail_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			empleadoemailLogic_Desde_Empleado.saveEmpleadoEMails();

			RasgoPersonalLogic rasgopersonalLogic_Desde_Empleado=new RasgoPersonalLogic();
			rasgopersonalLogic_Desde_Empleado.setRasgoPersonals(rasgopersonals);

			rasgopersonalLogic_Desde_Empleado.setConnexion(this.getConnexion());
			rasgopersonalLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(RasgoPersonal rasgopersonal_Desde_Empleado:rasgopersonalLogic_Desde_Empleado.getRasgoPersonals()) {
				rasgopersonal_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			rasgopersonalLogic_Desde_Empleado.saveRasgoPersonals();

			ReferenciaLogic referenciaLogic_Desde_Empleado=new ReferenciaLogic();
			referenciaLogic_Desde_Empleado.setReferencias(referencias);

			referenciaLogic_Desde_Empleado.setConnexion(this.getConnexion());
			referenciaLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(Referencia referencia_Desde_Empleado:referenciaLogic_Desde_Empleado.getReferencias()) {
				referencia_Desde_Empleado.setid_empleado(idEmpleadoActual);

				referenciaLogic_Desde_Empleado.setReferencia(referencia_Desde_Empleado);
				referenciaLogic_Desde_Empleado.saveReferencia();

				Long idReferenciaActual=referencia_Desde_Empleado.getId();

				TelefonoReferenciaLogic telefonoreferenciaLogic_Desde_Referencia=new TelefonoReferenciaLogic();

				if(referencia_Desde_Empleado.getTelefonoReferencias()==null){
					referencia_Desde_Empleado.setTelefonoReferencias(new ArrayList<TelefonoReferencia>());
				}

				telefonoreferenciaLogic_Desde_Referencia.setTelefonoReferencias(referencia_Desde_Empleado.getTelefonoReferencias());

				telefonoreferenciaLogic_Desde_Referencia.setConnexion(this.getConnexion());
				telefonoreferenciaLogic_Desde_Referencia.setDatosCliente(this.datosCliente);

				for(TelefonoReferencia telefonoreferencia_Desde_Referencia:telefonoreferenciaLogic_Desde_Referencia.getTelefonoReferencias()) {
					telefonoreferencia_Desde_Referencia.setid_referencia(idReferenciaActual);
				}

				telefonoreferenciaLogic_Desde_Referencia.saveTelefonoReferencias();
			}


			Telefono_NMLogic telefono_nmLogic_Desde_Empleado=new Telefono_NMLogic();
			telefono_nmLogic_Desde_Empleado.setTelefono_NMs(telefono_nms);

			telefono_nmLogic_Desde_Empleado.setConnexion(this.getConnexion());
			telefono_nmLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(Telefono_NM telefono_nm_Desde_Empleado:telefono_nmLogic_Desde_Empleado.getTelefono_NMs()) {
				telefono_nm_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			telefono_nmLogic_Desde_Empleado.saveTelefono_NMs();

			NovedadLogic novedadLogic_Desde_Empleado=new NovedadLogic();
			novedadLogic_Desde_Empleado.setNovedads(novedads);

			novedadLogic_Desde_Empleado.setConnexion(this.getConnexion());
			novedadLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(Novedad novedad_Desde_Empleado:novedadLogic_Desde_Empleado.getNovedads()) {
				novedad_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			novedadLogic_Desde_Empleado.saveNovedads();

			EmpleadoHerraLogic empleadoherraLogic_Desde_Empleado=new EmpleadoHerraLogic();
			empleadoherraLogic_Desde_Empleado.setEmpleadoHerras(empleadoherras);

			empleadoherraLogic_Desde_Empleado.setConnexion(this.getConnexion());
			empleadoherraLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(EmpleadoHerra empleadoherra_Desde_Empleado:empleadoherraLogic_Desde_Empleado.getEmpleadoHerras()) {
				empleadoherra_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			empleadoherraLogic_Desde_Empleado.saveEmpleadoHerras();

			EmpleadoEnferLogic empleadoenferLogic_Desde_Empleado=new EmpleadoEnferLogic();
			empleadoenferLogic_Desde_Empleado.setEmpleadoEnfers(empleadoenfers);

			empleadoenferLogic_Desde_Empleado.setConnexion(this.getConnexion());
			empleadoenferLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(EmpleadoEnfer empleadoenfer_Desde_Empleado:empleadoenferLogic_Desde_Empleado.getEmpleadoEnfers()) {
				empleadoenfer_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			empleadoenferLogic_Desde_Empleado.saveEmpleadoEnfers();

			VisaLogic visaLogic_Desde_Empleado=new VisaLogic();
			visaLogic_Desde_Empleado.setVisas(visas);

			visaLogic_Desde_Empleado.setConnexion(this.getConnexion());
			visaLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(Visa visa_Desde_Empleado:visaLogic_Desde_Empleado.getVisas()) {
				visa_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			visaLogic_Desde_Empleado.saveVisas();

			SeguroLogic seguroLogic_Desde_Empleado=new SeguroLogic();
			seguroLogic_Desde_Empleado.setSeguros(seguros);

			seguroLogic_Desde_Empleado.setConnexion(this.getConnexion());
			seguroLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(Seguro seguro_Desde_Empleado:seguroLogic_Desde_Empleado.getSeguros()) {
				seguro_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			seguroLogic_Desde_Empleado.saveSeguros();

			AsistenciaMensualLogic asistenciamensualLogic_Desde_Empleado=new AsistenciaMensualLogic();
			asistenciamensualLogic_Desde_Empleado.setAsistenciaMensuals(asistenciamensuals);

			asistenciamensualLogic_Desde_Empleado.setConnexion(this.getConnexion());
			asistenciamensualLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(AsistenciaMensual asistenciamensual_Desde_Empleado:asistenciamensualLogic_Desde_Empleado.getAsistenciaMensuals()) {
				asistenciamensual_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			asistenciamensualLogic_Desde_Empleado.saveAsistenciaMensuals();

			EmpleadoDiscaLogic empleadodiscaLogic_Desde_Empleado=new EmpleadoDiscaLogic();
			empleadodiscaLogic_Desde_Empleado.setEmpleadoDiscas(empleadodiscas);

			empleadodiscaLogic_Desde_Empleado.setConnexion(this.getConnexion());
			empleadodiscaLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(EmpleadoDisca empleadodisca_Desde_Empleado:empleadodiscaLogic_Desde_Empleado.getEmpleadoDiscas()) {
				empleadodisca_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			empleadodiscaLogic_Desde_Empleado.saveEmpleadoDiscas();

			ProfesionEmpleaLogic profesionempleaLogic_Desde_Empleado=new ProfesionEmpleaLogic();
			profesionempleaLogic_Desde_Empleado.setProfesionEmpleas(profesionempleas);

			profesionempleaLogic_Desde_Empleado.setConnexion(this.getConnexion());
			profesionempleaLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(ProfesionEmplea profesionemplea_Desde_Empleado:profesionempleaLogic_Desde_Empleado.getProfesionEmpleas()) {
				profesionemplea_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			profesionempleaLogic_Desde_Empleado.saveProfesionEmpleas();

			RubroEmpleadoLogic rubroempleadoLogic_Desde_Empleado=new RubroEmpleadoLogic();
			rubroempleadoLogic_Desde_Empleado.setRubroEmpleados(rubroempleados);

			rubroempleadoLogic_Desde_Empleado.setConnexion(this.getConnexion());
			rubroempleadoLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(RubroEmpleado rubroempleado_Desde_Empleado:rubroempleadoLogic_Desde_Empleado.getRubroEmpleados()) {
				rubroempleado_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			rubroempleadoLogic_Desde_Empleado.saveRubroEmpleados();

			EmpleadoConstanteLogic empleadoconstanteLogic_Desde_Empleado=new EmpleadoConstanteLogic();
			empleadoconstanteLogic_Desde_Empleado.setEmpleadoConstantes(empleadoconstantes);

			empleadoconstanteLogic_Desde_Empleado.setConnexion(this.getConnexion());
			empleadoconstanteLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(EmpleadoConstante empleadoconstante_Desde_Empleado:empleadoconstanteLogic_Desde_Empleado.getEmpleadoConstantes()) {
				empleadoconstante_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			empleadoconstanteLogic_Desde_Empleado.saveEmpleadoConstantes();

			TallaVestidoLogic tallavestidoLogic_Desde_Empleado=new TallaVestidoLogic();
			tallavestidoLogic_Desde_Empleado.setTallaVestidos(tallavestidos);

			tallavestidoLogic_Desde_Empleado.setConnexion(this.getConnexion());
			tallavestidoLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(TallaVestido tallavestido_Desde_Empleado:tallavestidoLogic_Desde_Empleado.getTallaVestidos()) {
				tallavestido_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			tallavestidoLogic_Desde_Empleado.saveTallaVestidos();

			NovedadNomiLogic novedadnomiLogic_Desde_Empleado=new NovedadNomiLogic();
			novedadnomiLogic_Desde_Empleado.setNovedadNomis(novedadnomis);

			novedadnomiLogic_Desde_Empleado.setConnexion(this.getConnexion());
			novedadnomiLogic_Desde_Empleado.setDatosCliente(this.datosCliente);

			for(NovedadNomi novedadnomi_Desde_Empleado:novedadnomiLogic_Desde_Empleado.getNovedadNomis()) {
				novedadnomi_Desde_Empleado.setid_empleado(idEmpleadoActual);
			}

			novedadnomiLogic_Desde_Empleado.saveNovedadNomis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoConstantesFunciones.getClassesRelationshipsOfEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
